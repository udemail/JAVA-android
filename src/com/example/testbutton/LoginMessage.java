package com.example.testbutton;
import java.nio.ByteBuffer;
public class LoginMessage {
	protected int total_length; //4 bytes
	protected byte commandid;   //1 bytes
	protected String imsi;      //21 bytes
	protected short sequence;  //31 bytes
	private byte status;
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("LoginMessage,imsi:").append(this.imsi).append(" sequence:");
		buffer.append(this.sequence).append(" status:").append(this.status).append(" ");
		return buffer.toString();
	}
	
	public boolean setMessageConent(ByteBuffer in){
		this.commandid = 1;
		this.imsi = "";
		for(int i=0;i<21;i++){
			this.imsi = this.imsi + (char)in.get();
		}
		this.sequence = in.getShort();
		
		this.status = in.get();
		
		in.get();
		
		in.getShort();
		
		return true;
	}
}
