package com.example.testbutton;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
public class SocketClient {
	private ReadThread readThread;
	
	private WriteThread writeThread;
	
	private SocketChannel channel;

	private String ServerIP;
	
	private int ServerPort;

	public SocketClient(String IP, int port) {
		this.ServerIP = IP;
		this.ServerPort = port;		
	}

	public void start() {
		if (connect() != true)
			return;
		
		if (readThread == null){
			readThread = new ReadThread(channel);
		}
		readThread.start();
		if (writeThread == null){
			writeThread = new WriteThread(channel);
		}
		writeThread.start();
	}

	public void stop() {		
		writeThread.closeRequest = true;
		readThread.closeRequest = true;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			//logger.info(e);
		}
		disconnect();
	}

	public boolean isAlive() {
		if (readThread == null || writeThread == null)
			return false;
		return readThread.isAlive() && writeThread.isAlive();
	}

	public boolean isconnect() {
		return this.channel.isConnected();
	}


	public boolean connect() {
		// TODO: connect to the umc server;
		try {
			channel = SocketChannel.open();
			channel.configureBlocking(true);
			channel.connect(new InetSocketAddress(this.ServerIP,
					this.ServerPort));
		} catch (IOException e) {			
			e.printStackTrace();
			//logger.error(e);
			return false;
		}
		return true;
	}
	

	private boolean disconnect() {
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

	public boolean sendMsg(byte[] bb){
		return writeThread.internalQueue.add(bb);
	}

	public SocketChannel getChannel() {
		return channel;
	}

	public void setChannel(SocketChannel channel) {
		this.channel = channel;
	}

	public int getServerPort() {
		return ServerPort;
	}

	public void setServerPort(int serverPort) {
		ServerPort = serverPort;
	}

	public String getServerIP() {
		return ServerIP;
	}

	public void setServerIP(String serverIP) {
		ServerIP = serverIP;
	}
}
