/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;
import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.Date;
import com.ehis.util.*;

public class MOBurialPermitServlet extends javax.servlet.http.HttpServlet	{
Connection con = null;
PrintWriter out;
String patientid            ="";
String burial_permit_no     ="";
String burial_permit_app_by ="";
java.util.Properties p;
String facilityId ;
String locale;
String client_ip_address ;
String mode;
Timestamp receiveTimestamp1=null;
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
public void init(ServletConfig config) throws ServletException
{
	super.init(config);
}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	HttpSession session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	
	this.client_ip_address = p.getProperty("client_ip_address");
	locale			       = p.getProperty("LOCALE");
	patientid	             = req.getParameter("patient_id");
	burial_permit_no	     = req.getParameter("burial_permit_no");
	burial_permit_app_by	 = req.getParameter("burial_permit_app_by");
    bpadate                  = req.getParameter("bpadate");
    mode                     = req.getParameter("mode");
	if(mode == null)	                    mode		            = "";
	if(patientid == null)	                patientid		        = "";
	if(burial_permit_no == null)	        burial_permit_no		= "";
	if(burial_permit_app_by == null)		burial_permit_app_by	= "";
	if(bpadate == null)						bpadate			= "";
	bpadate = DateUtils.convertDate(bpadate,"DMYHM",locale,"en");
	StringTokenizer receivetoks6 = new StringTokenizer (bpadate," ") ;
	StringTokenizer receivetok7  = new StringTokenizer (receivetoks6.nextToken(), "/" ) ;
	String receiveArr8[]		 = new String[3] ;
	
	for( int n=0;n<3;n++ )
		receiveArr8[n] = receivetok7.nextToken() ;
	String time48	   = receivetoks6.nextToken();
	if(time48.equals("")||(time48==null)) time48="00:00";
	bpadate	= receiveArr8[2] +"-"+receiveArr8[1]+"-"+ receiveArr8[0]+" "+time48+":00"  ;
	receiveTimestamp1 = Timestamp.valueOf(bpadate);

	try
	{
		this.out = res.getWriter();
		if ( mode.equals("query")){
            modifyBurialPermit(res);
		}
		else{
			insertBurialPermit(req,res);
		}
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
}

private void insertBurialPermit(HttpServletRequest req, HttpServletResponse res)
{	
	PreparedStatement pstmt = null;
	//Statement stmt = null;
	ResultSet rset = null;
	int rs1 = 0;
   try
   {
    con  = ConnectionManager.getConnection(req);  
	HashMap tabdata=new HashMap();
	String s = p.getProperty("login_user");
	String s1 = dateFormat.format(new Date());
	String s3 = s1;
	String s6 = client_ip_address;
	boolean result = true;
	java.sql.Date date1 = java.sql.Date.valueOf(s3);

	if (burial_permit_no.equals(""))
	{
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" select NEXT_BURIAL_PERMIT_NO  ");
		sqlBuf.append(" from mo_parameter where ");
		sqlBuf.append(" facility_id= ? ");
		pstmt  = con.prepareStatement(sqlBuf.toString());
		pstmt.setString(1,facilityId);
	    rset = pstmt.executeQuery();
	 	if(rset!=null && rset.next())
		{
			   burial_permit_no = rset.getString("NEXT_BURIAL_PERMIT_NO");
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
        if((sqlBuf != null) && (sqlBuf.length() > 0))
		{
			sqlBuf.delete(0,sqlBuf.length());
		}
		
		StringBuffer sqlBuf1 = new StringBuffer();
	    sqlBuf1.append("UPDATE mo_parameter SET ");
	    sqlBuf1.append(" NEXT_BURIAL_PERMIT_NO= TO_NUMBER(?)+1, ");
	    sqlBuf1.append(" MODIFIED_DATE  = SYSDATE,");
		sqlBuf1.append(" MODIFIED_BY_ID = ?,");
	    sqlBuf1.append(" MODIFIED_FACILITY_ID = ?,");
	    sqlBuf1.append(" MODIFIED_AT_WS_NO = ? ");
	    sqlBuf1.append(" WHERE FACILITY_ID = ? ");
		pstmt	= con.prepareStatement(sqlBuf1.toString());

	    pstmt.setString(1, burial_permit_no) ; 
	    pstmt.setString(2, s) ;
	    pstmt.setString(3, facilityId) ;
	    pstmt.setString(4, s6) ;
	    pstmt.setString(5, facilityId) ;
											 
	    rs1 =  pstmt.executeUpdate();
		if(rs1 > 0)
			result = true;
		else
			result = false;

		if(pstmt!=null) pstmt.close();
		if((sqlBuf1 != null) && (sqlBuf1.length() > 0))
			{
				sqlBuf1.delete(0,sqlBuf1.length());
			}
			
	}
  if (result)
  {
    tabdata.put("PATIENT_ID", patientid);
	tabdata.put("FACILITY_ID", facilityId);
	tabdata.put("BURIAL_PERMIT_NO", burial_permit_no);
	tabdata.put("BURIAL_PERMIT_APPROVED_BY", burial_permit_app_by);
	if(!(bpadate.equals("")))
	{
		tabdata.put("BURIAL_PERMIT_APPROVED_DATE",receiveTimestamp1);		
	}
		else
	{
		tabdata.put("BURIAL_PERMIT_APPROVED_DATE","");
	}
	tabdata.put("added_by_id", s);
	tabdata.put("added_date",date1);
	tabdata.put("added_at_ws_no",s6);
	tabdata.put("added_facility_id",facilityId);
	tabdata.put("modified_by_id", s);
	tabdata.put("modified_date", date1);
	tabdata.put("MODIFIED_FACILITY_ID", facilityId);
    tabdata.put("MODIFIED_AT_WS_NO", s6);
    String as[] = {
                "BURIAL_PERMIT_NO"
            };
	String tabname     ="MO_BURIAL_PERMIT";
	boolean local_ejbs = false;
	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = as;
		argArray[3] = tabname;
		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = as.getClass();
		paramArray[3] = tabname.getClass();
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error     = (String) results.get("error") ;
		error_value      = "0" ;
	    if ( inserted )
		{	 
		   error_value = "1" ;
           res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8") +"&err_value="+error_value );
		}
		else
		{
		   error = (String) results.get("error") ;
           res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8") +"&err_value="+error_value );
		}
    tabdata.clear();
	results.clear();
	  }
 
   
	}
	catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println( "Values sent are : <br>" ) ;
	}
	finally{
		if(con != null)      ConnectionManager.returnConnection(con,req);
	}
}

private void modifyBurialPermit(HttpServletResponse res) {
        try {
			HashMap tabdata=new HashMap();
	        String s = p.getProperty("login_user");
	        String s1 = dateFormat.format(new Date());
	        String s3 = s1;
	        String s6 = client_ip_address;
	        java.sql.Date date1 = java.sql.Date.valueOf(s3);
          
			tabdata.put("BURIAL_PERMIT_APPROVED_BY", burial_permit_app_by);
			if(!(bpadate.equals("")))
			{
				tabdata.put("BURIAL_PERMIT_APPROVED_DATE",receiveTimestamp1);		
			}
				else
			{
				tabdata.put("BURIAL_PERMIT_APPROVED_DATE","");
			}
			tabdata.put("modified_by_id", s);
			tabdata.put("modified_date", date1);
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", s6);

			HashMap tabdata1 = new HashMap();
            tabdata1.put("BURIAL_PERMIT_NO", burial_permit_no);

			String tabname     ="MO_BURIAL_PERMIT";

	boolean local_ejbs = false;
	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = tabdata1;
		argArray[3] = tabname;
		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = tabdata1.getClass();
		paramArray[3] = tabname.getClass();
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error     = (String) results.get("error") ;
		error_value      = "0" ;
	    if ( inserted )
		{	 
			error_value = "1" ;
            res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
		}
		else
		{
			error = (String) results.get("error") ;
            res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
		}
	 tabdata.clear();
	 results.clear();
	 tabdata1.clear();
	 } catch(Exception exception) {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
        }
    }


String bpadate		=	"";
String error_value  =	"";	

} 
