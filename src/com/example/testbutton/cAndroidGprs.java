package com.example.testbutton;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
public class cAndroidGprs {
	private ConnectivityManager mCM; 
    //开启/关闭GPRS   
   /* private void setGprsEnable(String methodName, boolean isEnable)  
    {  
        Class cmClass       = mCM.getClass();  
        Class[] argClasses  = new Class[1];  
        argClasses[0]       = boolean.class;  
          
        try  
        {  
            Method method = cmClass.getMethod(methodName, argClasses);  
            method.invoke(mCM, isEnable);  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }
	//打开或关闭GPRS   
    private boolean gprsEnabled(boolean bEnable)  
    {  
        Object[] argObjects = null;                   
        boolean isOpen = gprsIsOpenMethod("getMobileDataEnabled");  
        if(isOpen == !bEnable)  
        {  
            setGprsEnable("setMobileDataEnabled", bEnable);  
        }  
          
        return isOpen;    
    }  
      
    //检测GPRS是否打开   
    private boolean gprsIsOpenMethod(String methodName)  
    {  
        Class cmClass       = mCM.getClass();  
        Class[] argClasses  = null;  
        Object[] argObject  = null;  
          
        Boolean isOpen = false;  
        try  
        {  
            Method method = cmClass.getMethod(methodName, argClasses);  
  
            isOpen = (Boolean) method.invoke(mCM, argObject);  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
  
        return isOpen;  
    }  */
}
