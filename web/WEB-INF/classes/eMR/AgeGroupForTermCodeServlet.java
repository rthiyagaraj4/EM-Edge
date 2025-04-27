/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eMR.AgeGroupForTermCode.*;

public class AgeGroupForTermCodeServlet
 extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	//private ServletConfig config =	null; Check style correction 10/19/2005
	String added_by_id	= "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String client_ip_address  = "";
	ArrayList TerminologyCode = new ArrayList();
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException	
	{
		session = request.getSession(false);
		this.p	= (java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id = (String)session.getAttribute("facility_id");
		client_ip_address =	this.p.getProperty("client_ip_address");
		try{
				response.setContentType("text/html");
				this.out = response.getWriter();
				AddModify(request,response);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		session = request.getSession(false);
		this.p	= (java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id = (String)session.getAttribute("facility_id");
		client_ip_address =	this.p.getProperty("client_ip_address");
		try
		{
			this.out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			doPost(request,response);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	private void AddModify(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
            HashMap TabData=new HashMap();
			RecordSet	AgeGroupForTermCode	=	null;
            AgeGroupForTermCode	=	(webbeans.eCommon.RecordSet)	session.getAttribute("AgeGroupForTermCode");
			TerminologyCode=(ArrayList)AgeGroupForTermCode.getObject(0);
			
            /*
           Implementing the logic for the Elemenating duplicates
		   In TerminologyTermCode
		   */

		   Set set = new HashSet();
			List newList = new ArrayList();
			 for (Iterator iter = TerminologyCode.iterator();    iter.hasNext(); ) {
			 Object element = iter.next();
			   if (set.add(element))
				  newList.add(element);
				}
			TerminologyCode.clear();
			TerminologyCode.addAll(newList);

          /*
             End for the duplicates logic
			*/


			added_by_id				=	 (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			added_facility_id		=	 (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no		=	 (client_ip_address == null)?"":client_ip_address; 
			String age_group_code = request.getParameter("age_group_code")== null ? "":request.getParameter("age_group_code");
			String term_set_id=request.getParameter("term_set_id")==null ? "":request.getParameter("term_set_id");
			TabData.put("age_group_code",age_group_code );
			TabData.put("term_set_id",term_set_id );
			TabData.put("ADDED_BY_ID",added_by_id);
			TabData.put("ADDED_FACILITY_ID",added_facility_id);
			TabData.put("ADDED_AT_WS_NO",added_at_ws_no);
			TabData.put("TerminologyCode",TerminologyCode);
            boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AgeGroupForTermCode",AgeGroupForTermCodeHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = TabData;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = TabData.getClass();
			HashMap results = (HashMap)(busObj.getClass().getMethod("AddModify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted =	( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ) {
				error_value = "1" ;
				session.removeAttribute("AgeGroupForTermCode");
			}
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			TabData.clear();
			TerminologyCode.clear();
			TabData.clear();
			results.clear();
		}
		catch(Exception e)
		{
			//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}//end of catch
	}//end of insert
}
			

           
