package com.example.testbutton;

public interface BasicSocketInf {
	boolean parseMsgBuffer() ;

	void dispatchTranslatorMessage(String msg) ;
	
	boolean disconnect() ;
}
