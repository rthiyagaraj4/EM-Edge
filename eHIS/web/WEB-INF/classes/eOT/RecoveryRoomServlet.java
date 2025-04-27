/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

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
import eCommon.SingleTabHandler.*;
import eCommon.XSSRequestWrapper;

public class RecoveryRoomServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String table_name="OT_RECOVERY_ROOM";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		//String locale = this.p.getProperty("LOCALE"); //Common-ICN-0055
		
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		String mode = checkForNull(req.getParameter("mode"));
		HashMap tabdata=new HashMap();
		if("insert".equals(mode)){
			String recovery_room_code=checkForNull(req.getParameter("recovery_room_code"));
			String recovery_room_desc=checkForNull(req.getParameter("recovery_room_desc"));
			String facility_id=checkForNull(req.getParameter("facility_id"));
			String chargeable_yn = checkForNull(req.getParameter("chargeable_yn"),"N");
			String status = checkForNull(req.getParameter("status"),"D");
			tabdata.put("recovery_room_code",recovery_room_code);
			tabdata.put("recovery_room_desc",recovery_room_desc);
			tabdata.put("operating_facility_id",facility_id);
			tabdata.put("chargeable_yn",chargeable_yn);
			tabdata.put("status",status);
			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facility_id);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}else if("modify".equals(mode)){
			String recovery_room_desc=checkForNull(req.getParameter("recovery_room_desc"),checkForNull(req.getParameter("recovery_room_desc1")));
			String facility_id=checkForNull(req.getParameter("facility_id"));
			String chargeable_yn = checkForNull(req.getParameter("chargeable_yn"),"N");
			String status = checkForNull(req.getParameter("status"),"D");
			tabdata.put("recovery_room_desc",recovery_room_desc);
			tabdata.put("operating_facility_id",facility_id);
			tabdata.put("chargeable_yn",chargeable_yn);
			tabdata.put("status",status);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}
		return tabdata;
	}

	private Object getRemoteObject(){
		boolean local_ejbs = isLocalEJB();
		Object busObj=null;
		try{
			//Object home =com.medicom.ESLP.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
			e.printStackTrace();
			//	out.println(e.toString());
		}
		return busObj;
	}

	
	private void insert(HttpServletRequest req, HttpServletResponse res){
		HashMap tabData = populateTabData(req,res);
		String dupflds[]={"recovery_room_code"};
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
			}else{
				 error = (String) results.get("error") ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch ( Exception e ){
			e.printStackTrace();
			//out.println(" Exception raised in Recovery Room Servlet...So Record Not insertedFoll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){
		String recovery_room_code=checkForNull(req.getParameter("recovery_room_code1"));
		HashMap tabData = populateTabData(req,res);
		HashMap condflds=new HashMap();
		condflds.put("recovery_room_code",recovery_room_code);
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
		}
		catch ( Exception e ){
			e.printStackTrace();
			//out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			//out.println( oper_group_code+" "+oper_cat_code);
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

