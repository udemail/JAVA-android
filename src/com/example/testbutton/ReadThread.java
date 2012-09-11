package com.example.testbutton;
import java.io.IOException;
import java.nio.channels.SocketChannel;
public class ReadThread extends BasicSocket {
	public ReadThread(SocketChannel channel) {
		super(channel);
	}

	public void run() {
		while (true) {
			if ((closeRequest == true) || (channel.isConnected() == false)) {
				break;
			}
			//TODO: read data from umc server.
			try {
				//read tank status data from channel, parses the msg data and adds the msg in tankDataRecordMsgQueue
				int position = msgBuffer.position();
				channel.read(msgBuffer);
				if (position != msgBuffer.position()) {
					msgBuffer.flip();
					//parse swap buffer until it does not have remaining data
					while (!parseMsgBuffer())
						;
					msgBuffer.compact();
					//msgBuffer.compact().flip();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out
						.println("Error occur when read message from server.");
				disconnect();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
