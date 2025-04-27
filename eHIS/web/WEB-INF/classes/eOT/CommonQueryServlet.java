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

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;

public class CommonQueryServlet extends javax.servlet.http.HttpServlet
{
public void init(ServletConfig config) throws ServletException
	{
	super.init(config);
	}

public void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
	{
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String output="";
String flag="";
StringBuffer strData=new StringBuffer();
StringBuffer strData1=new StringBuffer();
req.setCharacterEncoding("UTF-8");
res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req);
res.addHeader("X-XSS-Protection", "1; mode=block");
res.addHeader("X-Content-Type-Options", "nosniff");
HttpSession session = req.getSession(false);
java.util.Properties prop = null;
prop = (java.util.Properties) session.getValue( "jdbc" ) ;
//String locale = prop.getProperty("LOCALE") ;
//eOT.LogFile.log("OTDebugger","Enter in commonquery Servlet",this);


try	
{
PrintWriter out=res.getWriter();
String sql="";
String strShortDesc="";
String strOrderType="";



flag=CommonBean.checkForNull(req.getParameter("flag"));
//eOT.LogFile.log("OTDebugger","flag"+flag,this);

sql=CommonBean.checkForNull(req.getParameter("sql"));
//eOT.LogFile.log("OTDebugger","sql"+sql,this);

if(flag.equals("PERS_RECORD")){
	StringBuffer sbr = new StringBuffer();
	sbr.append(sql);
	int pos = sbr.indexOf("PLUS");
	sbr.replace(pos,pos+4,"+");
	sql = sbr.toString();
	sbr.setLength(0);
 }

conn=ConnectionManager.getConnection(req);
pstmt=conn.prepareCall(sql);
rs=pstmt.executeQuery();

if(flag.equals("1")==true)
	{
	while(rs.next())
	    {     
	 strShortDesc=CommonBean.checkForNull(rs.getString("SHOR_DESC1"));
     strOrderType=CommonBean.checkForNull(rs.getString("ORDER_TYPE1"));
 	 strShortDesc=strShortDesc.replace('(','^');
	 strShortDesc=strShortDesc.replace(')','!');
	 strShortDesc=strShortDesc.replace('\'','@');

	 strData.append(strShortDesc+",");
 	 strData1.append(strOrderType+",");
		}
	}
else
if(flag.equals("2")==true)
	{
   while(rs.next())
	    {     
	 strShortDesc=CommonBean.checkForNull(rs.getString("SHOR_DESC1"));
     strOrderType=CommonBean.checkForNull(rs.getString("ORDER_TYPE1"));
 	 strShortDesc=strShortDesc.replace('(','&');
	 strShortDesc=strShortDesc.replace(')','!');
	 strShortDesc=strShortDesc.replace('\'','@');
	 strData.append(strShortDesc+",");
	 strData1.append(strOrderType+",");
		}
	}
	else
if(flag.equals("3")==true)
	{
   while(rs.next())
    {     
	strShortDesc=CommonBean.checkForNull(rs.getString("SHOR_DESC1"));
    strOrderType=CommonBean.checkForNull(rs.getString("ORDER_CATALOG_CODE1"));
	 	 strShortDesc=strShortDesc.replace('(','&');
	 strShortDesc=strShortDesc.replace(')','!');
	 strShortDesc=strShortDesc.replace('\'','@');

	strData.append(strShortDesc+",");
	strData1.append(strOrderType+",");
	 }
	}else if( "PERS_RECORD".equals(flag) || "MED_SER".equals(flag) ){
		 //Modified by subramanian 11\12\2005.
		 //get the position_desc in Personnel Record function
		while(rs.next()){
			output=CommonBean.checkForNull(rs.getString(1));
		}
		out.println(output);
	}
else
	{ 

//eOT.LogFile.log("OTDebugger","Here call query",this);
	output="0";
 if(rs.next()) 
	{
	output=CommonBean.checkForNull(rs.getString(1));
	}
	rs.close();
	pstmt.close();
	out.println("setAssignValue(\""+output+"\")");
	}

if(flag.equals("1")||flag.equals("2")||flag.equals("3"))
	{
strShortDesc=strData.toString();
strOrderType=strData1.toString();
strData.setLength(0);
strData1.setLength(0);
out.println("assignItem('"+strShortDesc+"','"+strOrderType+"','"+flag+"')");
	}

}
catch(Exception ee)		{
//eOT.LogFile.log("OTDebugger","Exception occured"+ee,this);
ee.printStackTrace();
}
finally
{
	try
	{
if(rs!=null) rs.close();
if(pstmt!=null) pstmt.close();		
if(conn!=null)ConnectionManager.returnConnection(conn,req);
	}catch(Exception e){e.printStackTrace();}
}
}
}
