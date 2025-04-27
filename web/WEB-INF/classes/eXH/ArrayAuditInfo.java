/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eXH;
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

	}

	public static List<String> getAuditInfo(HttpSession session)
	{
		String clientIPAddress = "";
		String facilityID = "";
		String loginUser = "";
		Properties prop = null;

		facilityID = (String)session.getAttribute("facility_id");
		prop = (Properties) session.getAttribute("jdbc");
		clientIPAddress = prop.getProperty("client_ip_address");
		loginUser = prop.getProperty("login_user");

		ArrayList<String> auditInfo = new ArrayList<String>();

		auditInfo.add(loginUser);
		auditInfo.add(clientIPAddress);
		auditInfo.add(facilityID);
		
		return auditInfo;
	}
	
	public static Map<String, String> getMapAuditInfo(HttpSession session)
	{
		Map<String, String> auditInfo = new HashMap<String, String>();
		
		if(session != null) {
			Properties prop = (Properties) session.getAttribute("jdbc");
			auditInfo.put("loginUser", prop.getProperty("login_user"));
			auditInfo.put("clientIPAddress", prop.getProperty("client_ip_address")); 
			auditInfo.put("facilityID", (String)session.getAttribute("facility_id"));
			auditInfo.put("userPassword", prop.getProperty("login_password"));
			auditInfo.put("dbName", prop.getProperty("ecis_jdbc_dns").substring(prop.getProperty("ecis_jdbc_dns").lastIndexOf(":") + 1) );
			auditInfo.put("sessionID", session.getId());
		}
		
		return auditInfo;
	}
}
