/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS.Common;

import java.net.URL;
import java.net.URLConnection;
//import java.util.HashMap;

public class ReportCallerThread extends Thread{


	public ReportCallerThread(String ssURL){
		this.ssurl=ssURL;
	}

	public void run(){
		callReport(ssurl);
	}

	public void callReport(String ssURL){
		try { 
			URL url = new URL(ssURL);
            URLConnection urlconnection = url.openConnection();
			urlconnection.getInputStream();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	private String ssurl;
}
