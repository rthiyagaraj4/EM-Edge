/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA; 

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class CADocRefFormatServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//modifiedDate = dateFormat.format(new java.util.Date());
		PrintWriter out = null;
		try{
			out = response.getWriter();
			update(request, out);
		}
		catch(Exception e){
			out.println("Exception in try of doPost() of CADocRefFormatServlet.java"+e);
			e.printStackTrace();
		}
	}//end of doPost()

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}


/************************************Modify***********************************/
private void update(HttpServletRequest request, PrintWriter out){
	
	java.util.Properties p;
	HttpSession session;

	
	String added_by_id = "";
	//String addedDate = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	//String modifiedDate = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String error_value = "0";
	String error = "";
	String document_type = "";
	String refno_logic = "";
	
	
	HashMap tableChart = new HashMap();
	session   = request.getSession(false);
	p         = (java.util.Properties)session.getValue("jdbc");
	//String locale       = (String) p.getProperty("LOCALE");
	added_facility_id   = (String)session.getValue("facility_id");
	client_ip_address   = p.getProperty("client_ip_address");
	modified_by_id      = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
    modified_facility_id = (added_facility_id==null)?"":added_facility_id;
	modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;
	

	//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");

	try{
		added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		//addedDate = dateFormat.format(new java.util.Date());
		added_facility_id = (added_facility_id == null)?"":added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
		//added_date1	 = java.sql.Date.valueOf(addedDate);
		//modified_date1 = java.sql.Date.valueOf(modifiedDate);

		document_type = request.getParameter("document_type")==null?"":request.getParameter("document_type");
		refno_logic = request.getParameter("refno_logic")==null?"":request.getParameter("refno_logic");

		tableChart.put("DOC_TYPE_REF_FORMAT",refno_logic);
		tableChart.put("added_by_id",added_by_id);
		tableChart.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tableChart.put("added_at_ws_no",added_at_ws_no);
		tableChart.put("added_facility_id",added_facility_id);
		tableChart.put("modified_by_id",modified_by_id);
		tableChart.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tableChart.put("modified_at_ws_no",modified_at_ws_no);
		tableChart.put("modified_facility_id",modified_facility_id);

		HashMap tableUpdate = new HashMap();
		tableUpdate.put("DOC_TYPE",document_type);
		
		boolean local_ejbs = false;
		String tabname="CA_DOC_REFERENCE";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tableChart;
		argArray[2] = tableUpdate;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tableChart.getClass();
		paramArray[2] = tableUpdate.getClass();
		paramArray[3] = tabname.getClass();


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		tableUpdate.clear();
		tableChart.clear();

		boolean modified = (((Boolean) results.get("status")).booleanValue());

		error = (String) results.get("error") ;
		if (modified){
			error_value = "1" ;
//			error= getMessage(locale,"RECORD_INSERTED","CA");
			}
			results.clear();
			
			out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value="+error_value+"'</script>");
	}//end of try
	catch(Exception e){
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
}//end of update


}//end of class


