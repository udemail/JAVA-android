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
//������Ϣ
//----
//txt�ļ�
import android.content.SharedPreferences;
import java.io.*;
//----
//ini�ļ�
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
	//������Ϣ
	public static final String PREFS_NAME = "MyPrefsFile"; 
	String FILENAME = "hello_file";     
    String string = "hello world!"; 
	//-------------------------
    
	private EditText mobileText;
    private EditText contentText;
    
	private EditText editText;
    private LocationManager lm;
    private static final String TAG="GpsActivity"; 
    // ����Handler  
    Handler handler = new Handler() { 
 
        @Override 
        public void handleMessage(Message msg) { 
            super.handleMessage(msg); 
 
            Log.d("debug", "handleMessage�������ڵ��̣߳�" 
                    + Thread.currentThread().getName()); 
 
            // Handler������Ϣ  
            /*if(msg.what == 55)
            {
            	timer.cancel();
            }*/
            if (msg.what > 0) { 
                
            } else { 
                
                // ����Timer��ʱ��  
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
        //GPRS����
        Button buttonGprs = (Button)this.findViewById(R.id.ButtonGprs);
        buttonGprs.setOnClickListener(new View.OnClickListener() {
         
			public void onClick(View v) {
					
				//fSocketSendMessage("hmtcptest.meibu.com",1000,"##DEVNO0014000"+telMgr.getLine1Number()+"99**");
				//fSocketSendMessage("udemail.gicp.net",5002,"##DEVNO0014000"+telMgr.getLine1Number()+"99**");
				//fSocketSendMessage("123.165.62.128",5002,"##DEVNO0014000"+telMgr.getLine1Number()+"99**");
                
				// ��ť����ʱ����һ��Timer��ʱ��  
	            timer = new Timer(); 
	            // ����һ��TimerTask  
	            // TimerTask�Ǹ�������,ʵ����Runnable�ӿڣ�����TimerTask����һ�����߳�  
	            TimerTask timerTask = new TimerTask() { 
	                // ����10��  
	                int i = 2; 
	                TelephonyManager telMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	                udBasicSocket udsocket = new udBasicSocket("hmtcptest.meibu.com",1000);
	                @Override 
	                public void run() { 
						/*Log.d("debug", "run�������ڵ��̣߳�" 
	                            + Thread.currentThread().getName()); */
					    if(i == 2)
					    {
					    	udsocket.fSocketSendMessage("##DEVNO0014000"+telMgr.getLine1Number()+"99**");//
					    	//i = 1;
					    }
					    else
	                	udsocket.fSocketSendMessage("##JUMP|000"+telMgr.getLine1Number()+"|0|"+Longitude+",E|"+Latitude+",N|"+"99|**|");//
	                	//fSocketSendMessage("hmtcptest.meibu.com",1000,telMgr.getLine1Number()+":"+Longitude+Latitude);
	                    // ����һ����Ϣ����ȥ  
	                    Message msg = new Message(); 
	                    msg.what = i--;//i--; 
	                    handler.sendMessage(msg); 
	                }
	            }; 
	            // ����ƻ����񣬸��ݲ����Ĳ�ͬ���������������Ĺ�����  
	            // ����schedule(TimerTask task, Date when)���`�����ڹ̶�ʱ��ִ��ĳ����  
	            // ����schedule(TimerTask task, Date when, long period)���`�����ڹ̶�ʱ�俪ʼ�ظ�ִ��ĳ�����ظ�ʱ�����ɿ�  
	            // ����schedule(TimerTask task, long delay)���`�������ӳٶ�ú�ִ��ĳ����  
	            // ����schedule(TimerTask task, long delay, long period)���`�������ӳٶ�ú��ظ�ִ��ĳ�����ظ�ʱ�����ɿ�  
	            timer.schedule(timerTask, 3000, 2000);// 3���ʼ����ʱ������ʱ���Ϊ1�� 
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
					Toast.makeText(MainActivity.this, "xfs3031����Ч��", Toast.LENGTH_LONG).show();
					mMediaPlayerXfs3031cnp = MediaPlayer.create(MainActivity.this, R.raw.xfs3031cnp);
				}
				else
				{
					Toast.makeText(MainActivity.this, "xfs4041����Ч��", Toast.LENGTH_LONG).show();
					mMediaPlayerXfs3031cnp = MediaPlayer.create(MainActivity.this, R.raw.xfs4041cn);
				}
				mMediaPlayerXfs3031cnp.start();
			}
		});
        //----------------------------------------------------
        //��绰
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
					Toast.makeText(MainActivity.this, "���벻�Ϸ�����", Toast.LENGTH_LONG).show();
				}
				else
				{
					if(content.length() > 70){
						Toast.makeText(MainActivity.this, "���ݹ���", Toast.LENGTH_LONG).show();
						//List<String> contents = smsManager.divideMessage(content);
						//for(String sms : contents){
							//smsManager.sendTextMessage(mobile, null, content, null, null);
						//}
					}
					else
					{
						if(content.length() == 0)
						{
							Toast.makeText(MainActivity.this, "����������", Toast.LENGTH_LONG).show();
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
        
        //�ж�GPS�Ƿ���������
        if(!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(this, "�뿪��GPS����...", Toast.LENGTH_SHORT).show();
            //���ؿ���GPS�������ý���
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);   
            startActivityForResult(intent,0); 
            return;
        }
        
        //Ϊ��ȡ����λ����Ϣʱ���ò�ѯ����
        String bestProvider = lm.getBestProvider(getCriteria(), true);
        //��ȡλ����Ϣ
        //��������ò�ѯҪ��getLastKnownLocation�������˵Ĳ���ΪLocationManager.GPS_PROVIDER
        Location location= lm.getLastKnownLocation(bestProvider);    
        updateView(location);
        //����״̬
        lm.addGpsStatusListener(listener);
        //�󶨼�������4������    
        //����1���豸����GPS_PROVIDER��NETWORK_PROVIDER����
        //����2��λ����Ϣ�������ڣ���λ����    
        //����3��λ�ñ仯��С���룺��λ�þ���仯������ֵʱ��������λ����Ϣ    
        //����4������    
        //��ע������2��3���������3��Ϊ0�����Բ���3Ϊ׼������3Ϊ0����ͨ��ʱ������ʱ���£�����Ϊ0������ʱˢ��   
        
        // 1�����һ�Σ�����Сλ�Ʊ仯����1�׸���һ�Σ�
        //ע�⣺�˴�����׼ȷ�ȷǳ��ͣ��Ƽ���service��������һ��Thread����run��sleep(10000);Ȼ��ִ��handler.sendMessage(),����λ��
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
        
        //-----------------------------------
        //������Ϣ
        /*SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);  
        boolean silent = settings.getBoolean("silentMode", false);  
        setSilent(silent); */
        //-----------------------------------
        //loadOpt();
        //xmlPullParseXML();
    }
    
	//---------------------------------------
    //������Ϣ
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
    //ini�ļ�
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
    //txt�ļ�
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
    //λ�ü���
    private LocationListener locationListener=new LocationListener() {
        
        /**
         * λ����Ϣ�仯ʱ����
         */
        public void onLocationChanged(Location location) {
            updateView(location);
            Log.i(TAG, "ʱ�䣺"+location.getTime()); 
            Log.i(TAG, "���ȣ�"+location.getLongitude()); 
            Log.i(TAG, "γ�ȣ�"+location.getLatitude()); 
            Log.i(TAG, "���Σ�"+location.getAltitude()); 
        }
        
        /**
         * GPS״̬�仯ʱ����
         */
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
            //GPS״̬Ϊ�ɼ�ʱ
            case LocationProvider.AVAILABLE:
                Log.i(TAG, "��ǰGPS״̬Ϊ�ɼ�״̬");
                break;
            //GPS״̬Ϊ��������ʱ
            case LocationProvider.OUT_OF_SERVICE:
                Log.i(TAG, "��ǰGPS״̬Ϊ��������״̬");
                break;
            //GPS״̬Ϊ��ͣ����ʱ
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.i(TAG, "��ǰGPS״̬Ϊ��ͣ����״̬");
                break;
            }
        }
    
        /**
         * GPS����ʱ����
         */
        public void onProviderEnabled(String provider) {
            Location location=lm.getLastKnownLocation(provider);
            updateView(location);
        }
    
        /**
         * GPS����ʱ����
         */
        public void onProviderDisabled(String provider) {
            updateView(null);
        }

    
    };
    
    //״̬����
    GpsStatus.Listener listener = new GpsStatus.Listener() {
        public void onGpsStatusChanged(int event) {
            switch (event) {
            //��һ�ζ�λ
            case GpsStatus.GPS_EVENT_FIRST_FIX:
                Log.i(TAG, "��һ�ζ�λ");
                break;
            //����״̬�ı�
            case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
                Log.i(TAG, "����״̬�ı�");
                //��ȡ��ǰ״̬
                GpsStatus gpsStatus=lm.getGpsStatus(null);
                //��ȡ���ǿ�����Ĭ�����ֵ
                int maxSatellites = gpsStatus.getMaxSatellites();
                //����һ�������������������� 
                Iterator<GpsSatellite> iters = gpsStatus.getSatellites().iterator();
                int count = 0;     
                while (iters.hasNext() && count <= maxSatellites) {     
                    GpsSatellite s = iters.next();     
                    count++;     
                }   
                System.out.println("��������"+count+"������");
                break;
            //��λ����
            case GpsStatus.GPS_EVENT_STARTED:
                Log.i(TAG, "��λ����");
                break;
            //��λ����
            case GpsStatus.GPS_EVENT_STOPPED:
                Log.i(TAG, "��λ����");
                break;
            }
        };
    };
    
    /**
     * ʵʱ�����ı�����
     * 
     * @param location
     */
    private void updateView(Location location){
        if(location!=null){
            editText.setText("�豸λ����Ϣ\n\n���ȣ�");
            editText.append(String.valueOf(location.getLongitude()));
            editText.append("\nγ�ȣ�");
            editText.append(String.valueOf(location.getLatitude()));
            
            Longitude = String.valueOf(location.getLongitude());
            Latitude = String.valueOf(location.getLatitude());
        }else{
            //���EditText����
            editText.getEditableText().clear();
        }
    }
    
    /**
     * ���ز�ѯ����
     * @return
     */
    private Criteria getCriteria(){
        Criteria criteria=new Criteria();
        //���ö�λ��ȷ�� Criteria.ACCURACY_COARSE�Ƚϴ��ԣ�Criteria.ACCURACY_FINE��ȽϾ�ϸ 
        criteria.setAccuracy(Criteria.ACCURACY_FINE);    
        //�����Ƿ�Ҫ���ٶ�
        criteria.setSpeedRequired(false);
        // �����Ƿ�������Ӫ���շ�  
        criteria.setCostAllowed(false);
        //�����Ƿ���Ҫ��λ��Ϣ
        criteria.setBearingRequired(false);
        //�����Ƿ���Ҫ������Ϣ
        criteria.setAltitudeRequired(false);
        // ���öԵ�Դ������  
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
    XmlSerializer xmlser =Xml.newSerializer();        //��ʼ��һ��XmlSerializer����
    try
    {
    	xmlser.setOutput(fileos, "UTF-8");                    //��������ʽΪUTF-8 
    	xmlser.startDocument("UTF-8", true);            //��ʼ�ĵ����ڶ�������Ϊ�Ƿ����
    	xmlser.startTag(null, "����");                 //����һ����ǩ
    
        //for(Student stu : students)                        //�Ӵ��뼯���п�ʼѭ��д�뵽xml�ļ���
        {
            //xmlser.startTag(null, "student");
            //xmlser.attribute(null, "id", stu.getId().toString());        //���ñ�ǩ��idֵ
            
        	//mobileText = (EditText)this.findViewById(R.id.mobile);
            //contentText = (EditText)this.findViewById(R.id.content);
            
            xmlser.startTag(null, "�绰��");        
            //xmlser.text(mobileText.getText().toString().getBytes());                    //���ñ�ǩ�м��textֵ
            
            xmlser.text(mobileText.getText().toString());
           
            xmlser.endTag(null, "�绰��");
            
            
            xmlser.startTag(null, "��������");
            
            xmlser.text(contentText.getText().toString());
           // xmlser.text("�����������Ƽ����޹�˾");
            
            //xmlser.text(contentText.getText().);
            xmlser.endTag(null, "��������");                
            //xmlser.endTag(null, "student");
        }            
        xmlser.endTag(null, "����");
        xmlser.endDocument();                            //�����ĵ���ǩ

        xmlser.flush();   
        fileos.close();   
    }catch (Exception e) {   
    	 Log.e("Exception","error occurred while creating xml file");   
    }  
}
private void xmlPullParseXML()/*throws XmlPullParserException, IOException*/{   

 //String res = "�������ͨ��XmlPullParse����:" + "/n";   
	
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
	 if("�绰��".equals(nodeName)){   
		 mobileText.setText(xmlPullParser.nextText());
	 //res += "����: " + xmlPullParser.nextText() + " ";   
	 }else if("��������".equals(nodeName)){  
		 contentText.setText(xmlPullParser.nextText());
	 //res += "����: " + xmlPullParser.nextText() + "/n";   
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
//��绰�������ţ����ܺ���
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
        //��绰
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
					Toast.makeText(MainActivity.this, "���벻�Ϸ�����", Toast.LENGTH_LONG).show();
				}
				else
				{
					if(content.length() > 70){
						Toast.makeText(MainActivity.this, "���ݹ���", Toast.LENGTH_LONG).show();
						//List<String> contents = smsManager.divideMessage(content);
						//for(String sms : contents){
							//smsManager.sendTextMessage(mobile, null, content, null, null);
						//}
					}
					else
					{
						if(content.length() == 0)
						{
							Toast.makeText(MainActivity.this, "����������", Toast.LENGTH_LONG).show();
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
                //CharSequence text = "��ť���飺messageBox 1!";
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, text, duration);
                //toast.show();
            	Dialog dlg = new AlertDialog.Builder(MainActivity .this)
                .setMessage(R.string.IsOutSys)
                .setCancelable(false)   // disable cancel action, hardware back button 
                .setPositiveButton("�˳�",
                       new DialogInterface.OnClickListener() {                                                      
                            public void onClick(DialogInterface dialog, int which) {
                            	MainActivity.this.finish();

                           }
                        })//.create();
            	.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
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
//��messagebox
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
//��ť���飺messagebox
static final int DIALOG_PAUSED_ID = 0;
@Override protected
Dialog onCreateDialog (int id)
{
   AlertDialog.Builder builder = new AlertDialog.Builder(this);
   builder.setMessage("ȷ��Ҫ�˳���")
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
    button.setText("�˳�");
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




