package com.example.testbutton;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import com.example.testbutton.LoginMessage;
//import com.ze.android.message.LoginMessage;

public class BasicSocket extends Thread {

    boolean closeRequest = false ;
	
	SocketChannel channel;

	ByteBuffer msgBuffer = ByteBuffer.allocate(1024 * 10);
	
	
	
	public BasicSocket(SocketChannel channel) {
		this.channel = channel;
	}

	boolean parseMsgBuffer() {
		if (msgBuffer.remaining() <= 2)
			return true;
		int header = msgBuffer.getShort();
		if (header == -217) { //头 FF 27
			int length = msgBuffer.getShort();
			if (msgBuffer.remaining() >= length) {
				int pos = msgBuffer.position();
				msgBuffer.position(msgBuffer.position() + length - 2);
				if (msgBuffer.getShort() != -216) { //结尾 FF 28
					return true;
				}
				msgBuffer.position(pos);
				//解析消息
				byte comdid = msgBuffer.get();
				if (comdid == 1) {					
					LoginMessage loginMessage = new LoginMessage();
					loginMessage.setMessageConent(msgBuffer);
					System.out.println("收到消息："+loginMessage.toString());
				}
			}
		}
		return true;
	}

	void dispatchTranslatorMessage(byte[] msg) {
		ByteBuffer buffer = ByteBuffer.wrap(msg);
		if ((buffer == null) || (buffer.position() == buffer.limit()))
			return;
		try {
			//this.channel.socket().setSendBufferSize(
			//		buffer.limit() - buffer.position());
			this.channel.write(buffer);
			//buffer.flip();
		} catch (IOException e) {
			e.printStackTrace();
			//logger.error(e);
		}
	}

	boolean disconnect() {
		// TODO: disconnect to the umc server.
		try {
			this.channel.socket().close();
			this.channel.close();
			System.out.println("Socket peer has been reset");
		} catch (IOException e) {
			e.printStackTrace();
			//logger.info(e);
			return false;
		}
		return true;
	}
}
