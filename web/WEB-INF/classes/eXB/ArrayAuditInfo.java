/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eXB; 
 import java.util.*;
 import java.net.*;
 import java.sql.*;
 import java.io.*;
 import webbeans.eCommon.ConnectionManager;
 import javax.servlet.http.HttpSession;	
 /**
 * Class is used to set an array list containing all std info i.e client_id,user_name etc
 */
 public class  ArrayAuditInfo 
{

	/**
	 * Method which returna audit information
	 * @param  HttpSession session
	 */
	public  static ArrayList getArrayAuditInfo(HttpSession session)
	{
		String client_ip_address="";
		String facility_id = "";
		String login_user="";
		java.util.Properties prop = null;
		facility_id = (String)session.getAttribute( "facility_id" ) ;
		prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );

		ArrayList arr1=new ArrayList();

		arr1.add(login_user);
		arr1.add(client_ip_address);
		arr1.add(facility_id);
		
		return(arr1);	

	}//end of function 
}//end of class 
