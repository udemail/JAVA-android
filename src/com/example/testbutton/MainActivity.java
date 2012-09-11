package com.example.testbutton;
//git home 2
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
//-------------------------------------------
//GPS
import java.util.Iterator;
import android.content.Context;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.provider.Settings;
import android.util.Log;
//-------------------------------------------
import android.media.MediaPlayer; 
//-------------------------------------------
//保存信息
//----
//txt文件
import android.content.SharedPreferences;
import java.io.*;
//----
//ini文件
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
//----
//xml
import org.xmlpull.v1.XmlSerializer;
import java.io.File;   

import java.io.FileNotFoundException;   
import java.io.FileOutputStream;    
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.parsers.DocumentBuilder;   
import javax.xml.parsers.DocumentBuilderFactory;   
import javax.xml.parsers.ParserConfigurationException;   
import org.w3c.dom.Document;   
import org.w3c.dom.Element;   
import org.w3c.dom.NodeList;   
import org.xml.sax.SAXException;   
import org.xmlpull.v1.XmlPullParser;   
import org.xmlpull.v1.XmlPullParserException;   
import org.xmlpull.v1.XmlPullParserFactory;    
import android.util.Xml;  
import android.widget.TextView;
//import com.thoughtworks.xstream.XStream;
import java.util.Timer; 
import java.util.TimerTask;
import android.os.Handler; 
import android.os.Message; 

//-------------------------------------------
public class MainActivity extends Activity {
	
	//--------------------------------------
	private Timer timer;
	public String Longitude;
	public String Latitude;
	//--------------------------------------
	private MediaPlayer mMediaPlayerPowerOn;
	private MediaPlayer mMediaPlayerPowerDown;
	private MediaPlayer mMediaPlayerXfs3031cnp;
	private int iVoiceCnt;
	//-------------------------
	//保存信息
	public static final String PREFS_NAME = "MyPrefsFile"; 
	String FILENAME = "hello_file";     
    String string = "hello world!"; 
	//-------------------------
    
	private EditText mobileText;
    private EditText contentText;
    
	private EditText editText;
    private LocationManager lm;
    private static final String TAG="GpsActivity"; 
    // 定义Handler  
    Handler handler = new Handler() { 
 
        @Override 
        public void handleMessage(Message msg) { 
            super.handleMessage(msg); 
 
            Log.d("debug", "handleMessage方法所在的线程：" 
                    + Thread.currentThread().getName()); 
 
            // Handler处理消息  
            /*if(msg.what == 55)
            {
            	timer.cancel();
            }*/
            if (msg.what > 0) { 
                
            } else { 
                
                // 结束Timer计时器  
                timer.cancel(); 
            } 
        } 
    }; 

    
    @Override
	 protected void onDestroy() {
	  // TODO Auto-generated method stub
    	//----------------------------------
    	/*Message msg = new Message(); 
        msg.what = 55;//i--; 
        handler.sendMessage(msg); */
    	//----------------------------------
    	mMediaPlayerPowerDown = new MediaPlayer();
        mMediaPlayerPowerDown = MediaPlayer.create(MainActivity.this, R.raw.powerdown); 
        //mMediaPlayerPowerOn.prepare(); 
        //mMediaPlayerPowerOn.prepare();
        mMediaPlayerPowerDown.start(); 
    	//saveOpt();
      //createXmlFile();	 
	  super.onDestroy();
	  lm.removeUpdates(locationListener);
	 }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---------------------------------------------------
        
        //mCMGprs = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        //---------------------------------------------------
        mMediaPlayerPowerOn = new MediaPlayer();
        mMediaPlayerPowerOn = MediaPlayer.create(MainActivity.this, R.raw.poweron); 
        //mMediaPlayerPowerOn.prepare(); 
        //mMediaPlayerPowerOn.prepare();
        mMediaPlayerPowerOn.start(); 
        //---------------------------------------------------
        mobileText = (EditText)this.findViewById(R.id.mobile);
        contentText = (EditText)this.findViewById(R.id.content);
        Button button = (Button)this.findViewById(R.id.button);
        
        //----------------------------------------------------
        //GPRS连接
        Button buttonGprs = (Button)this.findViewById(R.id.ButtonGprs);
        buttonGprs.setOnClickListener(new View.OnClickListener() {
         
			public void onClick(View v) {
					
				//fSocketSendMessage("hmtcptest.meibu.com",1000,"##DEVNO0014000"+telMgr.getLine1Number()+"99**");
				//fSocketSendMessage("udemail.gicp.net",5002,"##DEVNO0014000"+telMgr.getLine1Number()+"99**");
				//fSocketSendMessage("123.165.62.128",5002,"##DEVNO0014000"+telMgr.getLine1Number()+"99**");
                
				// 按钮按下时创建一个Timer定时器  
	            timer = new Timer(); 
	            // 创建一个TimerTask  
	            // TimerTask是个抽象类,实现了Runnable接口，所以TimerTask就是一个子线程  
	            TimerTask timerTask = new TimerTask() { 
	                // 倒数10秒  
	                int i = 2; 
	                TelephonyManager telMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	                udBasicSocket udsocket = new udBasicSocket("hmtcptest.meibu.com",1000);
	                @Override 
	                public void run() { 
						/*Log.d("debug", "run方法所在的线程：" 
	                            + Thread.currentThread().getName()); */
					    if(i == 2)
					    {
					    	udsocket.fSocketSendMessage("##DEVNO0014000"+telMgr.getLine1Number()+"99**");//
					    	//i = 1;
					    }
					    else
	                	udsocket.fSocketSendMessage("##JUMP|000"+telMgr.getLine1Number()+"|0|"+Longitude+",E|"+Latitude+",N|"+"99|**|");//
	                	//fSocketSendMessage("hmtcptest.meibu.com",1000,telMgr.getLine1Number()+":"+Longitude+Latitude);
	                    // 定义一个消息传过去  
	                    Message msg = new Message(); 
	                    msg.what = i--;//i--; 
	                    handler.sendMessage(msg); 
	                }
	            }; 
	            // 定义计划任务，根据参数的不同可以完成以下种类的工作：  
	            // １．schedule(TimerTask task, Date when)　ー＞　在固定时间执行某任务  
	            // ２．schedule(TimerTask task, Date when, long period)　ー＞　在固定时间开始重复执行某任务，重复时间间隔可控  
	            // ３．schedule(TimerTask task, long delay)　ー＞　在延迟多久后执行某任务  
	            // ４．schedule(TimerTask task, long delay, long period)　ー＞　在延迟多久后重复执行某任务，重复时间间隔可控  
	            timer.schedule(timerTask, 3000, 2000);// 3秒后开始倒计时，倒计时间隔为1秒 
			}
		});
        //----------------------------------------------------
        Button buttonGps = (Button)this.findViewById(R.id.ButtonGps);
        buttonGps.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				mMediaPlayerXfs3031cnp = new MediaPlayer();
				iVoiceCnt++;
				if(iVoiceCnt%2 == 0)
				{
					Toast.makeText(MainActivity.this, "xfs3031声音效果", Toast.LENGTH_LONG).show();
					mMediaPlayerXfs3031cnp = MediaPlayer.create(MainActivity.this, R.raw.xfs3031cnp);
				}
				else
				{
					Toast.makeText(MainActivity.this, "xfs4041声音效果", Toast.LENGTH_LONG).show();
					mMediaPlayerXfs3031cnp = MediaPlayer.create(MainActivity.this, R.raw.xfs4041cn);
				}
				mMediaPlayerXfs3031cnp.start();
			}
		});
        //----------------------------------------------------
        //打电话
        //mobileText = (EditText)this.findViewById(R.id.mobile);
        Button call = (Button)this.findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String mobile = mobileText.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mobile));//action,data
				MainActivity.this.startActivity(intent);
			}
		});
        //----------------------------------------------------
        //----------------------------------------------------   
        button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String mobile = mobileText.getText().toString();
				String content = contentText.getText().toString();
				
				SmsManager smsManager  = SmsManager.getDefault();
				if(mobile.length()>11)
				{
					Toast.makeText(MainActivity.this, "号码不合法！！", Toast.LENGTH_LONG).show();
				}
				else
				{
					if(content.length() > 70){
						Toast.makeText(MainActivity.this, "内容过多", Toast.LENGTH_LONG).show();
						//List<String> contents = smsManager.divideMessage(content);
						//for(String sms : contents){
							//smsManager.sendTextMessage(mobile, null, content, null, null);
						//}
					}
					else
					{
						if(content.length() == 0)
						{
							Toast.makeText(MainActivity.this, "请输入内容", Toast.LENGTH_LONG).show();
						}
						else
						{
							smsManager.sendTextMessage(mobile, null, content, null, null);
							Toast.makeText(MainActivity.this, R.string.info, Toast.LENGTH_LONG).show();
						}
					}
				}
				//xmlPullParseXML();
			}
		});
        //-----------------------------------------------------
        
        editText=(EditText)findViewById(R.id.editText);
        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
        //判断GPS是否正常启动
        if(!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(this, "请开启GPS导航...", Toast.LENGTH_SHORT).show();
            //返回开启GPS导航设置界面
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);   
            startActivityForResult(intent,0); 
            return;
        }
        
        //为获取地理位置信息时设置查询条件
        String bestProvider = lm.getBestProvider(getCriteria(), true);
        //获取位置信息
        //如果不设置查询要求，getLastKnownLocation方法传人的参数为LocationManager.GPS_PROVIDER
        Location location= lm.getLastKnownLocation(bestProvider);    
        updateView(location);
        //监听状态
        lm.addGpsStatusListener(listener);
        //绑定监听，有4个参数    
        //参数1，设备：有GPS_PROVIDER和NETWORK_PROVIDER两种
        //参数2，位置信息更新周期，单位毫秒    
        //参数3，位置变化最小距离：当位置距离变化超过此值时，将更新位置信息    
        //参数4，监听    
        //备注：参数2和3，如果参数3不为0，则以参数3为准；参数3为0，则通过时间来定时更新；两者为0，则随时刷新   
        
        // 1秒更新一次，或最小位移变化超过1米更新一次；
        //注意：此处更新准确度非常低，推荐在service里面启动一个Thread，在run中sleep(10000);然后执行handler.sendMessage(),更新位置
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
        
        //-----------------------------------
        //保存信息
        /*SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);  
        boolean silent = settings.getBoolean("silentMode", false);  
        setSilent(silent); */
        //-----------------------------------
        //loadOpt();
        //xmlPullParseXML();
    }
    
	//---------------------------------------
    //保存信息
    @Override  
    protected void onStop(){  
    	super.onStop();  
    	

    	/*
    	// Save user preferences. We need an Editor object to  
    	// make changes. All objects are from android.context.Context  
    	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);  
    	SharedPreferences.Editor editor = settings.edit();  
    	editor.putBoolean("silentMode", mSilentMode);  
    	// Don't forget to commit your edits!!!  
    	editor.commit();  */ 
    	//saveOpt();
    	//loadOpt();
    }
    //--------------------
    //ini文件
    public void iniSaveOpt()
    {
    	iniRdWr reader = null;
        try {
                reader = new iniRdWr("main.ini");
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    //-------
    //txt文件
    public void saveOpt()
    {
        try {
            FileOutputStream outStream=this.openFileOutput("a.txt",Context.MODE_WORLD_READABLE);
            outStream.write(mobileText.getText().toString().getBytes());
            outStream.write(contentText.getText().toString().getBytes());
            outStream.close();
            Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
        } 
        catch (FileNotFoundException e) {
            return;
        }
        catch (IOException e){
            return ;
        }
    }   

    public void loadOpt()
    {
        try {
            FileInputStream inStream=this.openFileInput("a.txt");
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int length=-1;
            while((length=inStream.read(buffer))!=-1)   {
                stream.write(buffer,0,length);
            }
            stream.close();
            inStream.close();
            mobileText.setText(stream.toString());
            contentText.setText(stream.toString());
            Toast.makeText(MainActivity.this,"Loaded",Toast.LENGTH_LONG).show();
            
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            return ;
        }
    }   
    //----------------------------------------
    //位置监听
    private LocationListener locationListener=new LocationListener() {
        
        /**
         * 位置信息变化时触发
         */
        public void onLocationChanged(Location location) {
            updateView(location);
            Log.i(TAG, "时间："+location.getTime()); 
            Log.i(TAG, "经度："+location.getLongitude()); 
            Log.i(TAG, "纬度："+location.getLatitude()); 
            Log.i(TAG, "海拔："+location.getAltitude()); 
        }
        
        /**
         * GPS状态变化时触发
         */
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
            //GPS状态为可见时
            case LocationProvider.AVAILABLE:
                Log.i(TAG, "当前GPS状态为可见状态");
                break;
            //GPS状态为服务区外时
            case LocationProvider.OUT_OF_SERVICE:
                Log.i(TAG, "当前GPS状态为服务区外状态");
                break;
            //GPS状态为暂停服务时
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.i(TAG, "当前GPS状态为暂停服务状态");
                break;
            }
        }
    
        /**
         * GPS开启时触发
         */
        public void onProviderEnabled(String provider) {
            Location location=lm.getLastKnownLocation(provider);
            updateView(location);
        }
    
        /**
         * GPS禁用时触发
         */
        public void onProviderDisabled(String provider) {
            updateView(null);
        }

    
    };
    
    //状态监听
    GpsStatus.Listener listener = new GpsStatus.Listener() {
        public void onGpsStatusChanged(int event) {
            switch (event) {
            //第一次定位
            case GpsStatus.GPS_EVENT_FIRST_FIX:
                Log.i(TAG, "第一次定位");
                break;
            //卫星状态改变
            case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
                Log.i(TAG, "卫星状态改变");
                //获取当前状态
                GpsStatus gpsStatus=lm.getGpsStatus(null);
                //获取卫星颗数的默认最大值
                int maxSatellites = gpsStatus.getMaxSatellites();
                //创建一个迭代器保存所有卫星 
                Iterator<GpsSatellite> iters = gpsStatus.getSatellites().iterator();
                int count = 0;     
                while (iters.hasNext() && count <= maxSatellites) {     
                    GpsSatellite s = iters.next();     
                    count++;     
                }   
                System.out.println("搜索到："+count+"颗卫星");
                break;
            //定位启动
            case GpsStatus.GPS_EVENT_STARTED:
                Log.i(TAG, "定位启动");
                break;
            //定位结束
            case GpsStatus.GPS_EVENT_STOPPED:
                Log.i(TAG, "定位结束");
                break;
            }
        };
    };
    
    /**
     * 实时更新文本内容
     * 
     * @param location
     */
    private void updateView(Location location){
        if(location!=null){
            editText.setText("设备位置信息\n\n经度：");
            editText.append(String.valueOf(location.getLongitude()));
            editText.append("\n纬度：");
            editText.append(String.valueOf(location.getLatitude()));
            
            Longitude = String.valueOf(location.getLongitude());
            Latitude = String.valueOf(location.getLatitude());
        }else{
            //清空EditText对象
            editText.getEditableText().clear();
        }
    }
    
    /**
     * 返回查询条件
     * @return
     */
    private Criteria getCriteria(){
        Criteria criteria=new Criteria();
        //设置定位精确度 Criteria.ACCURACY_COARSE比较粗略，Criteria.ACCURACY_FINE则比较精细 
        criteria.setAccuracy(Criteria.ACCURACY_FINE);    
        //设置是否要求速度
        criteria.setSpeedRequired(false);
        // 设置是否允许运营商收费  
        criteria.setCostAllowed(false);
        //设置是否需要方位信息
        criteria.setBearingRequired(false);
        //设置是否需要海拔信息
        criteria.setAltitudeRequired(false);
        // 设置对电源的需求  
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        return criteria;
    }
    private void createXmlFile(){ 
    //-----------------------------------------
	File linceseFile = new File("/sdcard/config.xml");   
	try{   
	linceseFile.createNewFile();   
	}catch (IOException e) {   
	 Log.e("IOException", "exception in createNewFile() method");   
	 }   	
	 FileOutputStream fileos = null;   
	 try{   
	 fileos = new FileOutputStream(linceseFile);   
	 }catch (FileNotFoundException e) {   
	 Log.e("FileNotFoundException", "can't create FileOutputStream");   
	 } 
    //-----------------------------------------
    XmlSerializer xmlser =Xml.newSerializer();        //初始化一个XmlSerializer对象
    try
    {
    	xmlser.setOutput(fileos, "UTF-8");                    //定义编码格式为UTF-8 
    	xmlser.startDocument("UTF-8", true);            //开始文档，第二个参数为是否独立
    	xmlser.startTag(null, "配置");                 //设置一个标签
    
        //for(Student stu : students)                        //从传入集合中开始循环写入到xml文件中
        {
            //xmlser.startTag(null, "student");
            //xmlser.attribute(null, "id", stu.getId().toString());        //设置标签的id值
            
        	//mobileText = (EditText)this.findViewById(R.id.mobile);
            //contentText = (EditText)this.findViewById(R.id.content);
            
            xmlser.startTag(null, "电话号");        
            //xmlser.text(mobileText.getText().toString().getBytes());                    //设置标签中间的text值
            
            xmlser.text(mobileText.getText().toString());
           
            xmlser.endTag(null, "电话号");
            
            
            xmlser.startTag(null, "短信内容");
            
            xmlser.text(contentText.getText().toString());
           // xmlser.text("哈尔滨海铭科技有限公司");
            
            //xmlser.text(contentText.getText().);
            xmlser.endTag(null, "短信内容");                
            //xmlser.endTag(null, "student");
        }            
        xmlser.endTag(null, "配置");
        xmlser.endDocument();                            //结束文档标签

        xmlser.flush();   
        fileos.close();   
    }catch (Exception e) {   
    	 Log.e("Exception","error occurred while creating xml file");   
    }  
}
private void xmlPullParseXML()/*throws XmlPullParserException, IOException*/{   

 //String res = "本结果是通过XmlPullParse解析:" + "/n";   
	
try {   
 XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
 factory.setNamespaceAware(true);
 XmlPullParser xmlPullParser = factory.newPullParser();   
 xmlPullParser.setInput(Thread.currentThread().getContextClassLoader().getResourceAsStream("/sdcard/config.xml"), "UTF-8");       
 //xmlPullParser.setInput(this.getAssets().open("/sdcard/config.xml"), "UTF-8");
 
 int eventType = xmlPullParser.getEventType();   
 try{   
	 while (eventType != XmlPullParser.END_DOCUMENT) {   
	 String nodeName = xmlPullParser.getName();   
	 switch (eventType) {   
	 case XmlPullParser.START_TAG:   
	 if("电话号".equals(nodeName)){   
		 mobileText.setText(xmlPullParser.nextText());
	 //res += "书名: " + xmlPullParser.nextText() + " ";   
	 }else if("短信内容".equals(nodeName)){  
		 contentText.setText(xmlPullParser.nextText());
	 //res += "作者: " + xmlPullParser.nextText() + "/n";   
	 }   
	 break;   
	 default:   
	 break;   
	 }
	 eventType = xmlPullParser.next();   
	 }
	} catch (IOException e) {   
  e.printStackTrace();   
  }  
  } catch (XmlPullParserException e) {   
  e.printStackTrace();   
  }      
  //mTextView.setText(res);   
  }
public static void socketsendMsg() {
	// TODO Auto-generated method stub
	
	SocketClient socket = new SocketClient("113.0.112.225 ",5007);
	socket.start();
	//socket.socketClient.start();
	
	byte[] tmp = new byte[93];
	//head
	tmp[0] = (byte)0xFF;
	tmp[1] = (byte)0x27;
	//length
	tmp[2] = (byte)0x00;
	tmp[3] = (byte)89;
	//cmd
	tmp[4] = (byte)0x01;
	//imsi
	for(int i =0;i<21;i++)		
		tmp[5+i] = (byte)0x00;
	//sequence
	tmp[26] = (byte)0x00;
	tmp[27] = (byte)0x01;
	
	tmp[28] = 0;
	tmp[29] =(byte)4;
	tmp[30] =0;
	tmp[31] =0;
	tmp[32] =0;
	tmp[33] =0;
	
	tmp[34] = 0;
	tmp[35] =(byte)4;

	tmp[36] =1;
	tmp[37] =1;
	tmp[38] =1;
	tmp[39] =1;
	
	for(int i=0;i<12;i++)
		tmp[40+i] = (byte)1;
	for(int i=0;i<21;i++)
		tmp[52+i] = (byte)3;
	for(int i=0;i<5;i++)
		tmp[73+i] = (byte)4;
	for(int i=0;i<12;i++)
		tmp[78+i] = (byte)5;
	tmp[90] = (byte)0x00;
	tmp[91] = (byte)0xFF;
	tmp[92] = (byte)0x28;
	
	//socket.socketClient.sendMsg(tmp);
	socket.sendMsg(tmp);
}
public void fSocketSendMessage(String srvIp,int srvPort,String sendMeg)
{
	//String message = "##DEVNO0014000";   
	Socket socket = null;
	try {
		socket = new Socket(srvIp,srvPort);//"123.165.62.128" 5002
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	OutputStream ops = null;
	try {
		ops = socket.getOutputStream();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	DataOutputStream dos=new DataOutputStream(ops);   
	try {
		dos.write(sendMeg.getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	/*try {
		dos.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/  
}
/*public class XmlPullFeedParser extends BaseFeedParser {    
	public XmlPullFeedParser(String feedUrl) {        
		super(feedUrl);    
		}    
	public List<Message> parse() {        
		List<Message> messages = null;        
		XmlPullParser parser = Xml.newPullParser();        
		try {            
			// auto-detect the encoding from the stream            
			parser.setInput(this.getInputStream(), null);            
			int eventType = parser.getEventType();            
			Message currentMessage = null;            
			boolean done = false;            
			while (eventType != XmlPullParser.END_DOCUMENT && !done){                
				String name = null;                
				switch (eventType){                    
				case XmlPullParser.START_DOCUMENT:                        
					messages = new ArrayList<Message>();                        
					break;                    
					case XmlPullParser.START_TAG:                        
						name = parser.getName();                        
						if (name.equalsIgnoreCase(ITEM)){                            
							currentMessage = new Message();                        
							} else if (currentMessage != null){                            
								if (name.equalsIgnoreCase(LINK)){                                
									currentMessage.setLink(parser.nextText());                            
									} else if (name.equalsIgnoreCase(DESCRIPTION)){                                
										currentMessage.setDescription(parser.nextText());                            
										} else if (name.equalsIgnoreCase(PUB_DATE)){                                
											currentMessage.setDate(parser.nextText());                            
											} else if (name.equalsIgnoreCase(TITLE)){                                
												currentMessage.setTitle(parser.nextText());                            
												}                            
								}                        
						break;                    
						case XmlPullParser.END_TAG:                        
							name = parser.getName();                        
							if (name.equalsIgnoreCase(ITEM) && currentMessage != null){                            
								messages.add(currentMessage);                        
								} else if (name.equalsIgnoreCase(CHANNEL)){                            
									done = true;                        
									}                        
							break;                
							}                
				eventType = parser.next();            
				}        
			} catch (Exception e) {            
				throw new RuntimeException(e);        
				}        
		return messages;    
		}
	}*/
}

/*
//打电话，发短信，功能好用
public class MainActivity extends Activity {
	
    private EditText mobileText;
    private EditText contentText;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mobileText = (EditText)this.findViewById(R.id.mobile);
        contentText = (EditText)this.findViewById(R.id.content);
        Button button = (Button)this.findViewById(R.id.button);
        //----------------------------------------------------
        //打电话
        //mobileText = (EditText)this.findViewById(R.id.mobile);
        Button call = (Button)this.findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String mobile = mobileText.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mobile));//action,data
				MainActivity.this.startActivity(intent);
			}
		});
        //----------------------------------------------------
        
        button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String mobile = mobileText.getText().toString();
				String content = contentText.getText().toString();
				
				SmsManager smsManager  = SmsManager.getDefault();
				if(mobile.length()>11)
				{
					Toast.makeText(MainActivity.this, "号码不合法！！", Toast.LENGTH_LONG).show();
				}
				else
				{
					if(content.length() > 70){
						Toast.makeText(MainActivity.this, "内容过多", Toast.LENGTH_LONG).show();
						//List<String> contents = smsManager.divideMessage(content);
						//for(String sms : contents){
							//smsManager.sendTextMessage(mobile, null, content, null, null);
						//}
					}
					else
					{
						if(content.length() == 0)
						{
							Toast.makeText(MainActivity.this, "请输入内容", Toast.LENGTH_LONG).show();
						}
						else
						{
							smsManager.sendTextMessage(mobile, null, content, null, null);
							Toast.makeText(MainActivity.this, R.string.info, Toast.LENGTH_LONG).show();
						}
					}
				}
			}
		});
    }
}*/
/*
import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.Toast;
//---------------------------
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.net.Uri;;
//import android.permission.SEND_SMS;


public class MainActivity extends Activity {
	private Button mAddAccountButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddAccountButton = (Button) findViewById(R.id.button);
        
        mAddAccountButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	findViewById(R.id.textView1).setBackgroundColor(Color.BLUE);
            	findViewById(R.id.button).setBackgroundColor(Color.BLUE);
            	//Context context = getApplicationContext();
                //CharSequence text = "按钮试验：messageBox 1!";
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, text, duration);
                //toast.show();
            	Dialog dlg = new AlertDialog.Builder(MainActivity .this)
                .setMessage(R.string.IsOutSys)
                .setCancelable(false)   // disable cancel action, hardware back button 
                .setPositiveButton("退出",
                       new DialogInterface.OnClickListener() {                                                      
                            public void onClick(DialogInterface dialog, int which) {
                            	MainActivity.this.finish();

                           }
                        })//.create();
            	.setNegativeButton("取消", new DialogInterface.OnClickListener() {
    	              public void onClick(DialogInterface dialog, int id) {
    	            	  dialog.cancel();
    	              }
            	}).create();
            		dlg.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}*/



/*
//虚messagebox
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
Button btn = (Button) this.findViewById(R.id.button);
btn.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
           // Show a hint message box and auto disappear after timeout
               Toast.makeText(getApplicationContext(), "Hello Android, I am coming....",
                Toast.LENGTH_LONG).show();                 
            }
       });
    }
*/
/*
//-------------------------------------------------------------------------------------
//按钮试验：messagebox
static final int DIALOG_PAUSED_ID = 0;
@Override protected
Dialog onCreateDialog (int id)
{
   AlertDialog.Builder builder = new AlertDialog.Builder(this);
   builder.setMessage("确认要退出吗？")
          .setCancelable(false)
          .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
            	  MainActivity.this.finish();
              }
          })
          .setNegativeButton("No", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                   dialog.cancel();
              }
          });
   AlertDialog alert = builder.create();
   return alert;
}
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LinearLayout layout = new LinearLayout(this);
    Button button = new Button(this);
    button.setText("退出");
    button.setOnClickListener(new OnClickListener(){
       @Override
       public void onClick(View v) {
          showDialog(DIALOG_PAUSED_ID);
       }
    });
    layout.addView(button);
    setContentView(layout);
}
//---------------------------------------------------------------------------------
*/




