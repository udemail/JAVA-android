package com.checkupdateall;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class CheckUpdateAllActivity extends Activity implements OnItemClickListener  {
    /** Called when the activity is first created. */
	public  ArrayList<ApplicationInfo> needUpdateList = new ArrayList<ApplicationInfo>();
	public  static NeedUpdateListAdapter appAdapter;
	//private String webServicePath = "http://10.0.2.2:8080/AppUpdate/";
	private String webServicePath = "http://113.0.112.212:2001/";
	private ProgressDialog pBar;
	private String curClickItemAppName ="";
	private Handler haveDownHandler = new Handler();
	public static Handler refreshTitleHandler ;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //        
        scanNeedUpdateApp();
        //
        fillListView();
        
        registerRefreshTitleHandler();
        
	}
	public void scanNeedUpdateApp(){
		List<PackageInfo> appPackage = getPackageManager().getInstalledPackages(0);//获得系统所有应用的安装包信息
        for(int i=0; i<appPackage.size(); i++){
        	PackageInfo packageInfo = appPackage.get(i);
        	ApplicationInfo tmpAppInfo = new ApplicationInfo();
        	tmpAppInfo.appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
        	tmpAppInfo.packageName = packageInfo.packageName;
        	tmpAppInfo.versionName = packageInfo.versionName;
        	tmpAppInfo.versionCode = packageInfo.versionCode;
        	tmpAppInfo.appIcon = packageInfo.applicationInfo.loadIcon(getPackageManager());
        	//只添加非系统应用
        	if((packageInfo.applicationInfo.flags & android.content.pm.ApplicationInfo.FLAG_SYSTEM) == 0){
            	String appName = tmpAppInfo.appName.toString().replace('.', ' ');
        		String VerJSONPath =webServicePath + appName +"/"+"version.json";// +"c";
        		VerJSONPath = VerJSONPath.replaceAll(" ", "_");//拼接对应的version.json的访问路径
        		System.out.println(VerJSONPath);
        		try {
        			JSONObject jsonObj = GetNewVersionCode.getVersionJSON(VerJSONPath);
					if(jsonObj != null){
						Log.i("JSONnotNull","json 不为空！");
						int newVersionCode = Integer.parseInt(jsonObj.getString("versionCode"));
						System.out.print("旧代码版本");
						System.out.println(tmpAppInfo.versionCode);
						System.out.print("新代码版本");
						System.out.println(newVersionCode);
						if(tmpAppInfo.versionCode < newVersionCode){
							tmpAppInfo.newVersionCode = newVersionCode;
							tmpAppInfo.newVersionName = jsonObj.getString("versionName");
							needUpdateList.add(tmpAppInfo);//将第三方的应用添加到列表中
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
	}
	//填充ListView
		public void fillListView(){
			ListView newUpdateListView = (ListView)findViewById(R.id.listview);
	        appAdapter =new NeedUpdateListAdapter(this,needUpdateList);//填充adapter数据集
	        newUpdateListView.setDividerHeight(5);
	        if(!appAdapter.isEmpty()){
	        	int needUpdateCount = appAdapter.getCount();
	        	setTitle("当前发现"+needUpdateCount + "款应用需要升级！");
	        	newUpdateListView.setAdapter(appAdapter);//填充ListView
	        	newUpdateListView.setOnItemClickListener(this);//设置ListView中Item的单击事件
	        }else{					
	        	setTitle("未发现需要升级的应用！");
	        }
		}
		//注册refreshTitleHandler,用于在广播接收中更新Activity的标题
		public void registerRefreshTitleHandler(){
			refreshTitleHandler = new Handler(){
	        	public void handleMessage(Message msg){
	        		switch(msg.what){
	        		case 0:setTitle("当前发现"+appAdapter.getCount()+"款应用需要升级");break;
	        		}
	        		super.handleMessage(msg);
	        	}
	        };
		}
		//ListView中Item的单击事件
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			ApplicationInfo clickedItemInfo = (ApplicationInfo) appAdapter.getItem(position);
			curClickItemAppName = clickedItemInfo.appName;
			StringBuffer sb = new StringBuffer();
			Log.i("adapterVerName",clickedItemInfo.versionName);
			sb.append("当前版本:" + "\n");
			sb.append("版本名称：" + clickedItemInfo.versionName);
			sb.append("版本代码:" + clickedItemInfo.versionCode + "\n");
			sb.append("发现新版本:" + "\n");
			sb.append("版本名称:" + clickedItemInfo.newVersionName);
			sb.append("版本代码:" + clickedItemInfo.newVersionCode + "\n");
			sb.append("是否更新？");
			Dialog dialog = new AlertDialog.Builder(CheckUpdateAllActivity.this)
			.setTitle("软件更新")
			.setMessage(sb.toString())
			.setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					if(curClickItemAppName != ""){
						String appName = curClickItemAppName.replace('.', ' ');
						String loadUrl = webServicePath + appName +"/" +appName +".apk";
						loadUrl = loadUrl.replaceAll(" ", "_");
						Log.i("LoadUrl", loadUrl);
						downLoadApkFile(loadUrl, appName);
					}else{
						curClickItemAppName = "";
					}
				}
			})
			.setNegativeButton("暂不更新", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					curClickItemAppName = "";
				}
			}).create();
			dialog.show();
		}
		//下载新的apk应用文件
		protected void downLoadApkFile(final String url, final String appName) {
			// TODO Auto-generated method stub
			pBar = new ProgressDialog(CheckUpdateAllActivity.this);
			pBar.setTitle("正在下载");
			pBar.setMessage("请稍候...");
			pBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pBar.show();
			new Thread(){
				public void run(){
					HttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(url);
					HttpResponse httpResponse;
					try {
						httpResponse = httpClient.execute(httpGet);
						if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){  
							HttpEntity httpEntity = httpResponse.getEntity();
							InputStream is = httpEntity.getContent();
							FileOutputStream fos = null;
							if(is !=null){
								File file = new File(Environment.getExternalStorageDirectory(),appName+".apk");
								fos = new FileOutputStream(file);
								byte[] buf = new byte[1024];
								int ch = -1;
								do{
									ch = is.read(buf);
									if(ch <= 0)break;
									fos.write(buf, 0, ch);
								}while(true);
								is.close();
								fos.close();
								haveDownLoad(appName + ".apk");
							}else{
								throw new RuntimeException("isStream is null");
							}
						}else if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND){
							//404未找到相应的文件
							Looper.prepare();
							Toast toast = Toast.makeText(CheckUpdateAllActivity.this, "未找到对应的Apk文件！", 1);
							pBar.cancel();
							toast.show();
							Looper.loop();
						}
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		}	
	
		//下载完成 关闭进度条，并提示是否安装
		protected void haveDownLoad(final String fileName) {
			// TODO Auto-generated method stub
			pBar.cancel();//下载完成取消进度条
			haveDownHandler.post(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Dialog installDialog = new AlertDialog.Builder(CheckUpdateAllActivity.this)
					.setTitle("下载完成")
					.setMessage("是否安装新的应用")
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							installNewApk(fileName);
						}	
					})
					.setNegativeButton("取消", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							File downLoadApk = new File(Environment.getExternalStorageDirectory(),
									fileName);
							if(downLoadApk.exists()){
								downLoadApk.delete();
							}
						}
					}).create();
					installDialog.show();
				}
			});
		}
	
		//安装下载后的应用程序
		private void installNewApk(final String fileName) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName)),
					"application/vnd.android.package-archive");
			startActivity(intent);
		} 
}