/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.SingleThreadModel;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.*;
import eCommon.SingleTabHandler.*;
	 
public class FMDocumentTypeServlet extends HttpServlet implements SingleThreadModel
{		
	PrintWriter out	= null;
	Properties prop	= null;
	HttpSession session	= null;	

	String facilityId = "";
	String login_user =	"";
	String client_ip_address = "";
  
	String addedById = "";
	String doc_type_code = "";
	String doc_type_name = "";		
	String doc_desc = "";
	String doc_no = "";				
	String locale			= "" ;
	String eff_status = "";		

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	 try
	 {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		session	=	request.getSession(false);
		this.facilityId =	checkForNull((String) session.getValue("facility_id"));
		this.prop =	(Properties) session.getValue("jdbc");
		locale = prop.getProperty("LOCALE");
		this.login_user	= checkForNull(prop.getProperty("login_user"));
		this.client_ip_address	=	checkForNull(prop.getProperty("client_ip_address"));
		this.out = response.getWriter();

		String operation	= checkForNull(request.getParameter("operation"));
		if(operation.equals("insert")) insertFMDocumentType(request, response, locale);
		else if(operation.equals("modify")) modifyFMDocumentType(request, response, locale);
	 }
	 catch(Exception e)
	 {
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_value=0&err_num="+java.net.URLEncoder.encode(e.toString(),"UTF8"));
	 }
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try	{
	this.out = res.getWriter();
	res.setContentType("text/html");
	String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = req.getQueryString() ;
	String source = url + params ;
	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/SiteBlank.jsp' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
	}
	catch(Exception e)	{	
	out.println("Exception in doGet method :"+e.toString());
	}
	}
	private void insertFMDocumentType(HttpServletRequest req, HttpServletResponse res, String locale)
	{
	 try
	 {
		doc_type_code = checkForNull(req.getParameter("doc_type_code"));
		doc_type_name = checkForNull(req.getParameter("doc_type_name"));
		doc_desc = checkForNull(req.getParameter("doc_description"));
		doc_no = checkForNull(req.getParameter("doc_number"));
		eff_status  = checkForNull(req.getParameter("eff_status"));
		if (eff_status=="")
		{
			eff_status = "D";
		}
		addedById = login_user;		
		String modifiedById = addedById ;		
		String addedFacilityId=facilityId;		
		String addedAtWorkstation = client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;		

		Timestamp ts = new Timestamp(System.currentTimeMillis());

	   HashMap tabdata=new HashMap();
       tabdata.put("DOC_TYPE_CODE",doc_type_code);
	   tabdata.put("DOC_TYPE_NAME",doc_type_name);
	   tabdata.put("DOC_DESC",doc_desc);
	   tabdata.put("DOC_NO",doc_no);
	   tabdata.put("EFF_STATUS",eff_status);


	   tabdata.put("added_by_id",addedById);
	   tabdata.put("added_date",ts);
	   tabdata.put("added_at_ws_no",addedAtWorkstation);
	   tabdata.put("added_facility_id",addedFacilityId);
	   tabdata.put("modified_by_id",modifiedById);
	   tabdata.put("modified_date",ts);
	   tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
	   tabdata.put("modified_facility_id",addedFacilityId );
	  // tabdata.put("locale",locale );
	   String dupflds[]={"DOC_TYPE_CODE"};
	   String table_name ="FM_DOC_TYPE";
	   
		boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[4];
					argArray[0] = prop;
					argArray[1] = tabdata;
					argArray[2] = dupflds;
					argArray[3] = table_name;
					
					
				Class [] paramArray = new Class[4];
					paramArray[0] = prop.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = dupflds.getClass();
					paramArray[3] = table_name.getClass();
					
					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		tabdata.clear();
		
	   if ( inserted )
		{
			 error_value = "1" ;
		}
	   else
		{
			 error = (String) results.get("error") ;
		}
	   error = (String) results.get("error") ;
	   results.clear();
	   res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	 }
	 catch(Exception e)
	 {
		 out.println("<h3> Exception raise by Servlet ...So Record Not Created </h3> Foll: Error Received : "+e.toString());
	 }
	}
	private void modifyFMDocumentType(HttpServletRequest req, HttpServletResponse res, String locale)
	{
	  try
	  {
		doc_type_code = checkForNull(req.getParameter("doc_type_code"));
		doc_type_name = checkForNull(req.getParameter("doc_type_name"));
		doc_desc = checkForNull(req.getParameter("doc_description"));
		doc_no = checkForNull(req.getParameter("doc_number"));
		eff_status  = checkForNull(req.getParameter("eff_status"));
		if (eff_status=="")
		{
			eff_status = "D";
		}
		addedById = login_user;		
		String modifiedById = addedById ;		
		String addedFacilityId=facilityId;		
		String addedAtWorkstation = client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;		
	
		Timestamp ts = new Timestamp(System.currentTimeMillis());

	   HashMap tabdata=new HashMap();
       tabdata.put("DOC_TYPE_CODE",doc_type_code);
	   tabdata.put("DOC_TYPE_NAME",doc_type_name);
	   tabdata.put("DOC_DESC",doc_desc);
	   tabdata.put("DOC_NO",doc_no);
	   tabdata.put("EFF_STATUS",eff_status);
	   
	   tabdata.put("modified_by_id",modifiedById);
	   tabdata.put("modified_date",ts);
	   tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
	   tabdata.put("modified_facility_id",addedFacilityId );
	  // tabdata.put("locale",locale );

	   HashMap condflds = new HashMap();
	   condflds.put("DOC_TYPE_CODE",doc_type_code);
	   String table_name ="FM_DOC_TYPE";		
		boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[4];
					argArray[0] = prop;
					argArray[1] = tabdata;
					argArray[2] = condflds;
					argArray[3] = table_name;
					
					
				Class [] paramArray = new Class[4];
					paramArray[0] = prop.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = condflds.getClass();
					paramArray[3] = table_name.getClass();
					
					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	   boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
       String error = (String) results.get("error") ;
	   String error_value = "0" ;
	   tabdata.clear();
	   condflds.clear();
	   
	   if ( inserted )
		{
			 error_value = "1" ;
		}
	   else
		{
			 error = (String) results.get("error") ;
		}
	   error = (String) results.get("error") ;
	   results.clear();
	   res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
	 }
	 catch(Exception e)
	 {
	   out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());		}
	 }
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
}
