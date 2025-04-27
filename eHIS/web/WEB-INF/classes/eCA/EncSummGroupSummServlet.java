/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.MessageManager;
import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

@SuppressWarnings("deprecation")
public class EncSummGroupSummServlet extends javax.servlet.http.HttpServlet
{	
	private static final long serialVersionUID = 1L;	
	
	String error = "";
	String mode = "";
	
	String es_summ_code="", es_summ_desc="", es_summ_title="", es_summ_status="", es_summ_type="";
	String es_summ_code1="", es_summ_desc1="", es_summ_title1="", es_summ_status1="", es_summ_type1="";	
	
	String facilityId="" ;
	String client_ip_address="";
	String addedById = "";
	String modifiedById = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
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
	
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		PrintWriter out = null;
		
		boolean bStatus = true;
		
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8 ");
			out = res.getWriter();			
			
			mode = (req.getParameter("mode")==null)?"":req.getParameter("mode");
			
			if(bStatus)
			{				
				if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
				if (mode.trim().equalsIgnoreCase("update"))   modify(req, res, out);
			}
			
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	

 /********************************* Populates the hash table with the values *******************/

	public HashMap<String, Object> populateHashMap(HttpServletRequest req, PrintWriter out)
	{			
		java.util.Properties p;				

		HashMap<String, Object> tabdata	= null;			

		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;        
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 
		
		tabdata=new HashMap<String, Object>();	
		
		es_summ_code = (req.getParameter("es_summ_code1")==null)?"":req.getParameter("es_summ_code1");
		es_summ_desc = (req.getParameter("es_summ_desc1")==null)?"":req.getParameter("es_summ_desc1");
		es_summ_title = (req.getParameter("es_summ_title1")==null)?"":req.getParameter("es_summ_title1");
		es_summ_status = req.getParameter("es_summ_status1");
		
		es_summ_type = (req.getParameter("es_summ_type1")==null)?"":req.getParameter("es_summ_type1");
		
		tabdata.put("ES_SUMM_CODE", es_summ_code);
		tabdata.put("ES_SUMM_DESC",es_summ_desc);
		tabdata.put("ES_SUMM_TITLE",es_summ_title);
		tabdata.put("ES_SUMM_STATUS",es_summ_status);	
		
		tabdata.put("ES_SUMM_TYPE",es_summ_type);
		
		if (mode.equalsIgnoreCase("insert"))
		{
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);									
		}
		
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_FACILITY_ID",facilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		
		return tabdata;
	
	}

/***************************************insert**********************************************/

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String error_value = "0" ;

		HashMap tabdata	= null;
		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		tabdata = new HashMap();		
		
		try
		{			
			error =	"";
			
			tabdata = populateHashMap(req, out); //FILL THE HASHMAP
			
			String dupflds[]={"ES_SUMM_CODE"};

			boolean local_ejbs = false;
			String tabname="CR_ES_SUMM_HDR";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			
			if ( inserted )
				error_value = "1" ;				

			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}


	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String error_value = "0" ;

		HashMap<String, Object> tabdata = null;	
		
		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;			
		
		tabdata=new HashMap<String, Object>();		
	
		try
		{			
			error =	"";		
						
			tabdata = populateHashMap(req, out); //FILL THE HASHMap
			
			HashMap<String, Object> condflds=new HashMap<String, Object>();
			condflds.put("ES_SUMM_CODE",es_summ_code);		
			
			boolean local_ejbs = false;
			String tabname="CR_ES_SUMM_HDR";
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;
			
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();
			condflds.clear();
			
			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;	
			
			if (modified)
				error_value = "1";

			results.clear();   			
   			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}
	
	public String checkNull(String str,HttpServletRequest req) //flag is true for null feilds
	{
		String tempHolder =  req.getParameter(str);
		return (tempHolder==null)?"":tempHolder;
	}	
}
