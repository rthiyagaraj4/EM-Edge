/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;


public class AdminRouteCategoryRoutesServlet
 extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	//private ServletConfig config =	null;
		
	String added_by_id	= "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String client_ip_address  = "";
	String select_val="";

	HashMap TabData = new HashMap();
	ArrayList TabList =  new ArrayList();

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException	

	{
				
		this.out =	response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		this.prop	= (java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id = (String)session.getAttribute("facility_id");

		client_ip_address =	this.prop.getProperty("client_ip_address");
		
		try{
				response.setContentType("text/html");
				this.out = response.getWriter();
				AddModify(request,response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			request = request;
			this.out = response.getWriter();
			response.setContentType("text/html");
			
		}
		catch(Exception e)	{
		e.printStackTrace();
		}
	}



	private void AddModify(HttpServletRequest request, HttpServletResponse response)
	{
	try
		{
			//System.out.println("==request=="+request);
            HashMap tabdata=new HashMap();
            RecordSet	AdminRouteCategoryRoutes	=	null;
            AdminRouteCategoryRoutes	=	(webbeans.eCommon.RecordSet)	session.getAttribute("AdminRouteCategoryRoutes");

			added_by_id				=	 (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id		=	 (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no		=	 (client_ip_address == null)?"":client_ip_address; 

            //String checkedOnes = ""  ; //Commented for COMMON-ICN-0048
			String	from	=	"",	to		=	"";
           
			String admin_route_categ_code = request.getParameter("admin_route_categ_code")== null ? "":request.getParameter("admin_route_categ_code");
			
			
			from		=	(request.getParameter("from")==null)	?	"0"	:	request.getParameter("from");
			to			=	(request.getParameter("to")==null)		?	"0"	:	request.getParameter("to");

			
			int size=AdminRouteCategoryRoutes.getSize();

			for(int i=0;i<size;i++){
				TabList=(ArrayList)AdminRouteCategoryRoutes.getObject(i);
				tabdata.put( ("select"+i), TabList);
			}
			String locale=(String)session.getAttribute("LOCALE");
			tabdata.put("TotalRecords", String.valueOf(size));
			tabdata.put("admin_route_categ_code",admin_route_categ_code );
			tabdata.put("ADDED_BY_ID",added_by_id);
			tabdata.put("ADDED_FACILITY_ID",added_facility_id);
			tabdata.put("ADDED_AT_WS_NO",added_at_ws_no);
			tabdata.put("locale",locale);
			//System.out.println("TabData==>"+tabdata);
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AdminRouteCategoryRoutes", ePH.AdminRouteCategoryRoutes.AdminRouteCategoryRoutesHome.class, local_ejbs);				
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = tabdata;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = tabdata.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);


		boolean inserted =((Boolean) results.get("result")).booleanValue();
		Hashtable hashtable = MessageManager.getMessage(locale,(String)results.get("msgid"),"PH") ;
		String error = (String)hashtable.get("message");
		String error_value = "0" ;		
		if ( inserted ) error_value = "1" ;
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		
		tabdata.clear();
		TabData.clear();
		results.clear();


		}
		catch(Exception e){
		System.err.println("<h3>Record Not inserted</h3> :"+e.toString());
		e.printStackTrace();
	}//end of catch
	finally
	{
		session.removeAttribute("AdminRouteCategoryRoutes");		
	}
}//end of insert
}
			

           
