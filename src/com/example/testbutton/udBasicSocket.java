package com.example.testbutton;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.media.MediaPlayer;

public class udBasicSocket {
	
	Socket socket = null;

	 protected void onDestroySocket() {
	  // TODO Auto-generated method stub
		 OutputStream ops = null;
			try {
				ops = socket.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		 DataOutputStream dos=new DataOutputStream(ops); 
		 try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }
	public Socket udGetBasicSocket()
	{
		return socket;
	}
	public udBasicSocket(String srvIp,int srvPort)
	{
		try {
			socket = new Socket(srvIp,srvPort);//"123.165.62.128" 5002
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public void fSocketSendMessage(String sendMeg)
	{	 
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
	}
}
