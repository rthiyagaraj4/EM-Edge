/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
	
/*import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eCommon.Common.*;
import eOT.*;
import javax.rmi.* ;
import javax.naming.* ;
import eOT.Booking.*;*/

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.PrintWriter;
import java.io.IOException;
//import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.CallableStatement;
//import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;


public class CancelWaitList extends javax.servlet.http.HttpServlet
{

public void init(ServletConfig config) throws ServletException
	{
	super.init(config);
	}


public void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
	{

Connection conn=null;
//PreparedStatement pstmt=null;
//ResultSet rs=null;
CallableStatement cstmt = null;
String sql="";
String strFacilityId="";
String strWaitListNo="";
String strReasonCode="";
//String strCancelledBy="";
String strClientAddress="";
String login_user="";
String strStatus="";
String strErrMsg="";


HttpSession session=req.getSession(true);
strFacilityId=""+session.getAttribute("facility_id");
Properties p=(Properties)session.getAttribute("jdbc");
strClientAddress=""+p.getProperty("client_ip_address");
login_user=""+p.getProperty("login_user");
String langstrErrMsg = "";


try	{
PrintWriter out=res.getWriter();

   strWaitListNo=CommonBean.checkForNull(req.getParameter("waitlist_no"));
   strReasonCode=CommonBean.checkForNull(req.getParameter("reason_code"));

sql="{ call OT_CANCEL_WAITLIST(?,?,?,?,?,?,?,?,?,?,?)}";

conn=ConnectionManager.getConnection(req);
cstmt=conn.prepareCall(sql);
	
 cstmt.setString(1,strFacilityId);
 ////eOT.LogFile.log("OTDebugger","FacilityId"+strFacilityId,this);

 cstmt.setString(2,strWaitListNo);
 ////eOT.LogFile.log("OTDebugger","strWaitListNo"+strWaitListNo,this);

 cstmt.setString(3,strReasonCode);
  ////eOT.LogFile.log("OTDebugger","strCancelReason"+strReasonCode,this);

 cstmt.setString(4,login_user);
  ////eOT.LogFile.log("OTDebugger","login_user"+login_user,this);

cstmt.setString(5,strClientAddress);
 ////eOT.LogFile.log("OTDebugger","strClientAddress"+strClientAddress,this);

cstmt.registerOutParameter(6,Types.VARCHAR);
cstmt.registerOutParameter(7,Types.VARCHAR);
cstmt.setString(8,"");
cstmt.setString(9,"");
cstmt.setString(10,"");
// Newly Added
cstmt.registerOutParameter(11,Types.VARCHAR);
cstmt.executeQuery();
strStatus=cstmt.getString(6);
strErrMsg=cstmt.getString(7);
langstrErrMsg=cstmt.getString(11);
 ////eOT.LogFile.log("OTDebugger","strStatus ="+strStatus,this);
 ////eOT.LogFile.log("OTDebugger","strErrMsg ="+strErrMsg,this);

if(strStatus.equalsIgnoreCase("S")==true)
	{
	//out.println("WaitList canceled");
	out.println("APP-OT0108");
	}
	else
		//out.println(strErrMsg);  // Old Message
		System.err.println("Error in CancelWaitlist: "+ strErrMsg);
		//out.println(langstrErrMsg);

cstmt.close();
}catch(Exception ee)
{
	System.err.println("Dhana CancelWaitList "+ee);
	////eOT.LogFile.log("OTDebugger","Exception"+ee,this);
}
		finally
		{
	
			if(conn!=null)		ConnectionManager.returnConnection(conn,req);
		}

//BOOKING_DATE



}
}
