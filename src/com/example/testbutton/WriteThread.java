package com.example.testbutton;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedQueue;
public class WriteThread extends BasicSocket {
	public WriteThread(SocketChannel channel) {
		super(channel);
	}

	public ConcurrentLinkedQueue<byte[]> internalQueue = new ConcurrentLinkedQueue<byte[]>();
	
	public void run() {
		int msgCount;
		while (true) {
			if (closeRequest == true) {
				break;
			}
			// TODO: send messages in the internal Queue to umc server. 
			//System.out.println("Send message to UMC,message content:");                
			msgCount = 0;
			byte[] msg = internalQueue.poll();
			/*if (msg != null){
				dispatchTranslatorMessage(msg);
			}*/
			while ((msg != null) && (msgCount++ < 20)) {
				dispatchTranslatorMessage(msg);
				msg = internalQueue.poll();
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				disconnect();
				//logger.info(e);
			}
		}
	}
}
