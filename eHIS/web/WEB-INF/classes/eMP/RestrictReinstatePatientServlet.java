/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Created Date Time 05/10/20023 ******/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*;


public class RestrictReinstatePatientServlet extends HttpServlet	
{
PrintWriter out;
java.util.Properties p;

String patient_id;
String action;
String reason;
String remarks;
String restrict_yn;

String facilityId;
String client_ip_address ;

public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	HttpSession session = req.getSession(false);
		this.facilityId = (String)session.getValue("facility_id") ;
	
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");

	try {
		this.out = res.getWriter();
		patient_id = req.getParameter("patient_id");
		action = req.getParameter("action");
		reason = req.getParameter("reason");

		if(action.equals("Restrict")){
			restrict_yn = "Y";
			remarks = req.getParameter("restriction_remark")==null?"":req.getParameter("restriction_remark");
		}else if(action.equals("Reinstate")){
			restrict_yn = "N";
			remarks = req.getParameter("reinastatement_remark")==null?"":req.getParameter("reinastatement_remark");
		}
		HashMap tabdata = new HashMap();
		tabdata.put("RESTRICT_REINSTATE_YN",restrict_yn);
		if(action.equals("Restrict")){
			tabdata.put("RESTRICT_REINSTATE_REASON_CODE",reason);
		}
		tabdata.put("RESTRICT_REINSTATE_REMARKS",remarks);
		tabdata.put("modified_by_id",p.getProperty( "login_user"));
		tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("modified_facility_id",(String) session.getValue( "facility_id"));
		tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address") );
		HashMap condflds=new HashMap();
		condflds.put("patient_id",req.getParameter("patient_id")==null ? "" : req.getParameter("patient_id"));
		boolean local_ejbs = isLocalEJB();
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = condflds;
		argArray[3] = "mp_patient";

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass(); ;
		paramArray[1] = tabdata.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = String.class;
		
		java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		argArray = null;
		paramArray = null;
		tabdata.clear();
		condflds.clear();

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		results.clear();
		if(inserted)
		{
			String error_num = " " ;
		 	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + error_num + "&err_value=1");
		}
		else
		{
			 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
		}		
	}
	catch (Exception e)	{
		out.println(e.toString());
		}
	}
public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try	{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	this.out = res.getWriter();


	String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = req.getQueryString() ;
	String source = url + params ;
	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/RestrictReinstatePatient.js'></script></head><frameset rows='42,8%,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='plineFrame'    src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../../eMP/jsp/blank.jsp?step_1=14' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	}
	catch(Exception e)	{
		e.printStackTrace();
	}
}


boolean isLocalEJB()
{
	ServletContext context = getServletConfig().getServletContext();

	if((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
	{
		return true;
	}
	else
	{
		return false;
	}
}


}
