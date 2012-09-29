package com.checkupdateall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;

public class RefreshListViewBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i("Broadcast", "我是广播");
		if(intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")){
			//获取被替换的包名，因为getDataString（）返回的值包含了“package：“，所以要从第八的位置开始截取
			String replacedPackageName =intent.getDataString().substring(8);
			if(!context.getPackageName().equals(replacedPackageName)){
				Log.i("curPackName",context.getPackageName());
				System.out.print(replacedPackageName);
				Log.i("replacedPack",replacedPackageName);
				if(CheckUpdateAllActivity.appAdapter.remove(replacedPackageName)){
					//刷新主Activity的Titlt
					Message message = new Message();
					message.what = 0;
					CheckUpdateAllActivity.refreshTitleHandler.sendMessage(message);
				}
			}
		}
	}
}
