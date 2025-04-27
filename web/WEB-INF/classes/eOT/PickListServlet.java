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
import eOT.*;*/

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;



public class PickListServlet extends javax.servlet.http.HttpServlet
{

public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}


	public String checkForNull(String value){

		if( value ==null|| value.equals("null")||value.length()==0)
			return "";
		else
			 return value;
    }

public void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
	{

Connection conn=null;

CallableStatement cstmt = null;
req.setCharacterEncoding("UTF-8");
res.setContentType("text/html;charset=UTF-8");
PrintWriter out=res.getWriter();
try	
	{
conn = ConnectionManager.getConnection(req);
String strScheduledDate="";
String strRoomCode="";
String login_user="";
String locale="";
String strClientAddress="";
String strFacilityId="";
String strStatus="";
String strErrMsg="";
String strErrMsgLang="";
String strPatientId="";

//Added by lakshmi against CRF-0146 starts here
String strSourceCode="";
String strSourceType="";
strSourceCode=CommonBean.checkForNull(req.getParameter("strSourceCode"));
strSourceType=CommonBean.checkForNull(req.getParameter("strSrcTypeTemp"));
//Added by lakshmi against CRF-0146 ends here

strScheduledDate=CommonBean.checkForNull(req.getParameter("schedule_date"));
strRoomCode=CommonBean.checkForNull(req.getParameter("room_code"));
strPatientId=CommonBean.checkForNull(req.getParameter("patient_id"));

HttpSession session=req.getSession(true);
strFacilityId=""+session.getAttribute("facility_id");
Properties p=(Properties)session.getAttribute("jdbc");
strClientAddress=""+p.getProperty("client_ip_address");
login_user=""+p.getProperty("login_user");
locale = ""+p.getProperty("locale");


cstmt=conn.prepareCall("{ call OT_GEN_PICKLIST(?,?,?,?,?,?,?,?,?,?,?)}");


cstmt.setString(1,strFacilityId);
////eOT.LogFile.log("OTDebugger","strFacilityId"+strFacilityId,this);

cstmt.setString(2,strPatientId);
//eOT.LogFile.log("OTDebugger","strPatientID"+strPatientId,this);

cstmt.setString(3,strScheduledDate);
//eOT.LogFile.log("OTDebugger","strScheduledDate"+strScheduledDate,this);
cstmt.setString(4,strRoomCode);
//eOT.LogFile.log("OTDebugger","strRoomCode"+strRoomCode,this);

/*Added by lakshmi against CRF-0146 starts here*/
cstmt.setString(5,strSourceType);
cstmt.setString(6,strSourceCode);
/*Added by lakshmi against CRF-0146 ends here*/

cstmt.setString(7,login_user);
//eOT.LogFile.log("OTDebugger","login_user"+login_user,this);
cstmt.setString(8,strClientAddress);
//eOT.LogFile.log("OTDebugger","strClientAddress"+strClientAddress,this);
cstmt.registerOutParameter(9,Types.VARCHAR);
cstmt.registerOutParameter(10,Types.VARCHAR);
cstmt.registerOutParameter(11,Types.VARCHAR);


cstmt.execute();
strStatus=CommonBean.checkForNull(cstmt.getString(9));
strErrMsg=CommonBean.checkForNull(cstmt.getString(10));
strErrMsgLang=CommonBean.checkForNull(cstmt.getString(11),"APP-OT0082");


//System.err.println(" Status : "+strStatus);
//System.err.println(" Str Err Msg : "+strErrMsg);
//System.err.println(" Str Err Msg Lang : "+strErrMsgLang);
if(strStatus.equalsIgnoreCase("E")==true || strErrMsg.length()>0){
//if(!strErrMsgLang.equals("") || !strErrMsg.equals("")){
	strErrMsg=strErrMsg;
	conn.rollback();
	if(strErrMsg.length() > 0){
		out.println("APP-OT0104");
//		out.println(strErrMsg);
	}else{
		out.println(strErrMsgLang);
	}
}else
//	if(strStatus.equalsIgnoreCase("S")==true) commented by bshankar...status will never be S..it will be null
		{
		conn.commit();
		//out.println("PickList is generated");
		out.println("APP-OT0104");
		}

	}catch(Exception ee)
		{
	//eOT.LogFile.log("OTDebugger","Exception"+ee,this);
	}

	finally
		{
		try{
cstmt.close();
ConnectionManager.returnConnection(conn,req);
		}catch(Exception e1){}
		}
}
}
