/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.

package eCP;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import java.net.*;
import webbeans.eCommon.*;
import eCP.EvaluateCarePlanMarkError.*;

public class EvaluateCarePlanMarkErrorServlet extends HttpServlet
{ 
	Connection con = null;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;
	String mode = "";
	String locale= "";

	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		this.config = config;
	}
	//end of init()
	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		this.out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		this.prop = (java.util.Properties)session.getAttribute("jdbc");
		
		try
		{
			 if(mode.equals("")) insert(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception in try of doPost()"+e);
		}
	}
	//end of doPost()
	public  void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			response.setContentType("text/html");
			doPost(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception in doGet()"+e);
		}
	}//end of doGet()
//***********Start of Insert************************
	private void insert(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			locale=(String)session.getAttribute("LOCALE");
			String eval_id = request.getParameter("eval_id");
			String md_plan_id = request.getParameter("md_plan_id");
			String care_plan_id = request.getParameter("care_plan_id");
			String mrk_reason = request.getParameter("mrk_reason");
			HashMap hashmap_main = new HashMap();
			hashmap_main.put("EVAL_ID",eval_id);
			hashmap_main.put("MD_PLAN_ID",md_plan_id);
			hashmap_main.put("CARE_PLAN_ID",care_plan_id);
			hashmap_main.put("MRK_REASON",mrk_reason);
			try
			{
				con = ConnectionManager.getConnection(request);
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/EvaluateCarePlanMarkError", eCP.EvaluateCarePlanMarkError.EvaluateCarePlanMarkErrorHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = hashmap_main;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = hashmap_main.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
				boolean inserted = (((Boolean)results.get("status")).booleanValue());
				String error = (String) results.get("error");
				Hashtable final_result = MessageManager.getMessage(locale,"RECORD_INSERTED","CP" );
				String msgid= (String) final_result.get("message");
				int i=msgid.lastIndexOf(".");
                msgid=msgid.substring(0,i+1);
				String error_value = "";
				if (inserted)
				{
					error_value= "1";
					out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
					out.println("<script>alert('"+msgid+"')</script>");
					out.println("<script>window.returnValue = 'SUCCESS'</script>");
					out.println("<script>window.close();</script>");
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8") + "&err_value=" + error_value );
				}
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				String error = "Error ";
				String error_value = "0" ;
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		}//end of catch
	}//end of insert
}
