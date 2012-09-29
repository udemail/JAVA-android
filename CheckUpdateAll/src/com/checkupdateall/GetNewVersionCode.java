package com.checkupdateall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;

import android.util.Log;

public class GetNewVersionCode {

	public static JSONObject getVersionJSON(String VerJSONPath) throws ClientProtocolException, IOException, JSONException{
		StringBuilder VerJSON = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpParams httpParams = client.getParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 3000);
		HttpConnectionParams.setSoTimeout(httpParams, 5000);
		HttpResponse response;
		response = client.execute(new HttpGet(VerJSONPath));
		//请求成功
		System.out.print("链接请求码：");
		System.out.println(response.getStatusLine().getStatusCode());
		if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
			Log.i("ConOK","链接成功");
			HttpEntity entity = response.getEntity();
			if(entity != null){
				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"), 8192);
				String line = null;
				while((line = reader.readLine()) != null){
					VerJSON.append(line+"\n");
				}
				reader.close();
				JSONArray verJSONArray = new JSONArray(VerJSON.toString());
				if(verJSONArray.length() > 0){
					JSONObject obj = verJSONArray.getJSONObject(0);
					return obj;
				}
			}
			
			Log.i("ContFail","获取JSONObject失败！");
			return null;
		}
		Log.i("ConFail","链接失败！");
		return null;
	}
}
