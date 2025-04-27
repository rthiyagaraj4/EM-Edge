/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.SingleTabHandler.*;

public class MTasksServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="";
	String table_name="OH_TASKS";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int flag=0;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		locale = this.p.getProperty("LOCALE") ;
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		String mode = checkForNull(req.getParameter("mode"));
		con = ConnectionManager.getConnection(req);		
		HashMap tabdata=new HashMap();
		if("insert".equals(mode)){
			String task_code=checkForNull(req.getParameter("task_code"));
			String task_desc=checkForNull(req.getParameter("task_desc"));
			String order_catalog_code=checkForNull(req.getParameter("order_catalog_code"));
			String ext_perm_loc=checkForNull(req.getParameter("ext_perm_loc"),"N");
			String oh_note_type=checkForNull(req.getParameter("oh_note_type"));
			String eff_status = checkForNull(req.getParameter("eff_status"),"D");
			if(order_catalog_code.equals(""))
				order_catalog_code = checkForNull(req.getParameter("task_code"));
			
			tabdata.put("task_code",task_code);
			tabdata.put("task_desc",task_desc);
			tabdata.put("order_catalog_code",order_catalog_code);
			tabdata.put("eff_status",eff_status);
			tabdata.put("ext_perm_loc",ext_perm_loc);
			tabdata.put("oh_note_type",oh_note_type);
			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}
		else if("modify".equals(mode)){

			
			String task_desc=checkForNull(req.getParameter("task_desc"),req.getParameter("task_desc1") );
			String order_catalog_code=checkForNull(req.getParameter("order_catalog_code"),req.getParameter("order_catalog_code1") );
			String eff_status = checkForNull(req.getParameter("eff_status"),"D");
			String ext_perm_loc = checkForNull(req.getParameter("ext_perm_loc1"),"N");
			String oh_note_type = checkForNull(req.getParameter("oh_note_type"),req.getParameter("oh_note_type1"));//oh_note_type1 is added by Sridevi Joshi on 6/1/2010 for IN021708
					
			tabdata.put("task_desc",task_desc);
			tabdata.put("order_catalog_code",order_catalog_code);
			tabdata.put("eff_status",eff_status);
			tabdata.put("ext_perm_loc",ext_perm_loc);
			tabdata.put("oh_note_type",oh_note_type);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}
		return tabdata;
	}

	private Object getRemoteObject(){
		boolean local_ejbs = isLocalEJB();
		Object busObj=null;
		try{
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
				out.println(e.toString());
		}
		return busObj;
	}

	
	private void insert(HttpServletRequest req, HttpServletResponse res){
		HashMap tabData = populateTabData(req,res);
		String dupflds[]={"task_code"};
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = dupflds;
		argArray[3] = table_name;

		//Create a class array, containing the class types of the arguments passed
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();
		
		try{
			Object busObj =	getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
				try{		
					
					String task_code_update=checkForNull(req.getParameter("task_code"));
					String order_catalog_code_update=checkForNull(req.getParameter("order_catalog_code"));                    
				 if(order_catalog_code_update.equals("")){
						order_catalog_code_update = task_code_update;

				 }
					pstmt=con.prepareStatement("UPDATE OR_ORDER_CATALOG SET CONTR_MOD_ID='OH', CONTR_MSR_PANEL_ID=? WHERE ORDER_CATEGORY='OH' AND ORDER_CATALOG_CODE = ?");
					pstmt.setString(1,task_code_update);
					pstmt.setString(2,order_catalog_code_update);
					flag = pstmt.executeUpdate();
					if(flag != 0){
						con.commit();
					}
					else{
						con.rollback();
					}
				}catch(Exception e){
					try{
						System.err.println("Rollback performed, Err Msg in MTasksServlet"+e.getMessage());
						con.rollback();
					}catch(Exception e_1){
						System.err.println("MTasksServlet :Caught Exception during rollback"+e_1);
					}
				}finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(con!=null) ConnectionManager.returnConnection(con,req);
					}catch(Exception e){}
				}
			}else{
				 error = (String) results.get("error") ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
			tabData.clear();
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){
		String task_code=checkForNull(req.getParameter("task_code1"));
		HashMap tabData = populateTabData(req,res);
		HashMap condflds=new HashMap();
		condflds.put("task_code",task_code);
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = condflds;
		argArray[3] = table_name;
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = table_name.getClass();
		try{   
			Object busObj = getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
			}else{
				error = (String) results.get("error") ;
			}
       		error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
			tabData.clear();
			condflds.clear();
		}
		catch ( Exception e ){
			out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}


	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}

}

