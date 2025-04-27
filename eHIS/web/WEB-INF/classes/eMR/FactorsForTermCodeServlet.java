/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eMR.FactorsForTermCode.*;

public class FactorsForTermCodeServlet extends HttpServlet
{ 
	//Connection con = null;
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	private ServletConfig config=null;
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String mode = "";
	String locale="";
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" );

	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		this.config = config;
	}	//end of init()

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
      	out = response.getWriter();		
		this.p = (java.util.Properties)session.getValue("jdbc");
		this.added_facility_id = (String)session.getValue("facility_id");
		client_ip_address = this.p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	
		modified_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		modified_facility_id = (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		try
		{
			 mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
			 if(mode.equals("")) insert(request,response);
		}
		catch(Exception e)
		{
			//out.println("Exception in try of doPost()"+e);
			
			e.printStackTrace();
		}
	}	//end of doPost()

	public synchronized void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			out = response.getWriter();		
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			doPost(request,response);
		}
		catch(Exception e)
		{
			//out.println("Exception in doGet()"+e);
			
			e.printStackTrace();
		}
	}//end of doGet()

//***********Start of Insert************************
	private void insert(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
				
			HashMap hashmap_main = new HashMap();
			ArrayList arr_main = new ArrayList();
			added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address;
			String term_set_id = request.getParameter("term_set_id");
			String term_code = request.getParameter("term_code");
			String factor_code = "";	
			String defn_characteristic_yn = "";	
			String related_factor_yn = "";	
			String risk_factor_yn = "";	
			int rec_index = -1;
           // RecordSet FactorsForTermCodebn = null;
			String from = (request.getParameter("from")==null)?"0":request.getParameter("from");
			String to = (request.getParameter("to")==null)?"0":request.getParameter("to");

			//FactorsForTermCodebn = (webbeans.eCommon.RecordSet)
			//session.getAttribute("FactorsForTermCodebn");
		//	if(from != null && to != null)
			{
				for(int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
				{
					String chk_fact = request.getParameter("chks_factor"+(i))==null?"I":request.getParameter("chks_factor"+(i));
					if(chk_fact.equals("U"))
					{
						factor_code = request.getParameter("factor_code"+i);
						defn_characteristic_yn = request.getParameter("defn_characteristic_yn"+i);
						related_factor_yn = request.getParameter("related_factor_yn"+i);
						risk_factor_yn = request.getParameter("risk_factor_yn"+i);
						rec_index = -1;
						arr_main.add(factor_code);
						arr_main.add(defn_characteristic_yn);
						arr_main.add(related_factor_yn);
						arr_main.add(risk_factor_yn);
					/*	ArrayList fact_arr=new ArrayList();
						fact_arr.add(factor_code);
						fact_arr.add(defn_characteristic_yn);
						fact_arr.add(related_factor_yn);
						fact_arr.add(risk_factor_yn);
						if ( !FactorsForTermCodebn.containsObject(fact_arr) )
										FactorsForTermCodebn.putObject(fact_arr);
										*/
					}
				}
			}
		/*	ArrayList arr_factor = new ArrayList();

 System.out.println(FactorsForTermCodebn.getSize());

			for (int j=1;j<Integer.parseInt(to);j++)
			{
				arr_factor = (ArrayList) FactorsForTermCodebn.getObject(j);
				factor_code = (String) arr_factor.get(0);
				defn_characteristic_yn = (String) arr_factor.get(1);
				related_factor_yn = (String) arr_factor.get(2);
				risk_factor_yn = (String) arr_factor.get(3);
				arr_main.add(factor_code);
				arr_main.add(defn_characteristic_yn);
				arr_main.add(related_factor_yn);
				arr_main.add(risk_factor_yn);
				if ( arr_factor != null ) arr_factor.clear();
			}
			*/
			hashmap_main.put("ARR_MAIN",arr_main);
			hashmap_main.put("TERM_SET_ID",term_set_id);
			hashmap_main.put("TERM_CODE",term_code);
			hashmap_main.put("ADDED_BY_ID",added_by_id);
			hashmap_main.put("ADDED_AT_WS_NO",added_at_ws_no);
			hashmap_main.put("ADDED_FACILITY_ID",added_facility_id);
			hashmap_main.put("MODIFIED_BY_ID",modified_by_id);
			hashmap_main.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
			hashmap_main.put("MODIFIED_FACILITY_ID",modified_facility_id);
			try
			{
				//con = ConnectionManager.getConnection(request);
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
 				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FactorsForTermCode",FactorsForTermCodeHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = hashmap_main;
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = hashmap_main.getClass();
				HashMap results = (HashMap)(busObj.getClass().getMethod("AddModify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = (((Boolean)results.get("status")).booleanValue());
				Hashtable final_result = MessageManager.getMessage(locale,"RECORD_INSERTED","SM" );
				String msgid= (String) final_result.get("message");
				String error_value = "";
				if (inserted)
				{
					error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msgid ,"UTF-8") + "&err_value=" + error_value );
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msgid,"UTF-8" ) + "&err_value=" + error_value );
				}
				if ( final_result != null) final_result.clear();
				if ( results != null) results.clear();
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				String error = "Error ";
				String error_value = "0" ;
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			finally
			{
				//ConnectionManager.returnConnection(con,request);
			}
			if ( arr_main != null) arr_main.clear();
			if ( hashmap_main != null) hashmap_main.clear();
		}
		catch(Exception e)
		{
			//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		//end of catch
	}//end of insert
}
