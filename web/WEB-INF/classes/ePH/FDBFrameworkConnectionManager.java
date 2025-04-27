/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//package com.medicom.dif;
package ePH;
//import firstdatabank.fdbffc.FrameworkConnection;
import firstdatabank.database.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class FDBFrameworkConnectionManager
{

    public FDBFrameworkConnectionManager()
    {
    }

    private void loadSettings()
        throws IOException
    {
      //  db_Settings = new Properties();
      //  java.io.InputStream in = null;
      //  in = webbeans.ePH.FDBInterface.FrameworkConnectionManager.class.getResourceAsStream("fdb.properties");
       // db_Settings.load(in);
    }


    public void setFrameworkConnection()
        throws IOException
    {
		Connection				con			=	null;
		try{
       // loadSettings();
       // String driver = db_Settings.get(DB_DRIVER).toString();
       // String url = db_Settings.get(DB_URL).toString();
       // String user = db_Settings.get(DB_USER).toString();
       // String password = db_Settings.get(DB_PASSWORD).toString();
       // boolean debug = (new Boolean(db_Settings.get(DB_DEBUG).toString())).booleanValue();
       // boolean con_pooling = (new Boolean(db_Settings.get(DB_CON_POOLING).toString())).booleanValue();
       // int con_poolsize = (new Integer(db_Settings.get(DB_CON_POOLSIZE).toString())).intValue();
       // int con_timeout = (new Integer(db_Settings.get(DB_CON_TIMEOUT).toString())).intValue();
        //fwConn = new FDBDataManager(driver, url, user, password, debug, con_pooling, con_poolsize, con_timeout);
		fwConn = FDBDataManager.getInstanceUsingProfile("fdbConnection");
		
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@indbgl-app03:1521:v3dv","fdb31","fdb31");
		fwConn =FDBDataManager.getInstanceUsingConnection(con);*/
		
		}catch(Exception e){
			e.printStackTrace();
			try {				
				if(con != null ) con.close();
			} catch(Exception e1){
			}
		}finally{
			try {
				if(con != null ) con.close();
			} catch(Exception e1){
			}
		}
    }

    public FDBDataManager getFrameworkConnection()
    {
        return fwConn;
    }

    //private FrameworkConnection fwConn;
	private FDBDataManager fwConn;
   // private static String DB_DRIVER = "DB_DRIVER";
   // private static String DB_URL = "DB_URL";
   // private static String DB_USER = "DB_USER";
   // private static String DB_PASSWORD = "DB_PASSWORD";
   // private static String DB_DEBUG = "DB_DEBUG";
   // private static String DB_CON_POOLING = "DB_CON_POOLING";
   // private static String DB_CON_POOLSIZE = "DB_CON_POOLSIZE";
   // private static String DB_CON_TIMEOUT = "DB_CON_TIMEOUT";
   // private Properties db_Settings;

}
