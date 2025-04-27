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
import java.util.StringTokenizer;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eCommon.SingleTabHandler.*;
import eCommon.XSSRequestWrapper;

public class HolidaysServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String table_name="OT_HOLIDAY";  
	String locale;
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
		String locale = (String)session.getAttribute("LOCALE");
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		locale = this.p.getProperty("LOCALE");
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);
			if ( operation.equals("delete"))    delete(req, res);
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
			String reason_for_holiday=checkForNull(req.getParameter("reason_for_holiday"));
			String holiday_date=defaultDateFormat(com.ehis.util.DateUtils.convertDate(req.getParameter("holiday_date"),"DMY","en",locale));
			tabdata.put("holiday_date",holiday_date);
			tabdata.put("reason_for_holiday",reason_for_holiday);
		//	System.out.println("eOT Holiday facility_id "+facility_id);
			tabdata.put("operating_facility_id",facility_id);
			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facility_id);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}else if("modify".equals(mode)){
			String reason_for_holiday=checkForNull(req.getParameter("reason_for_holiday"));
			tabdata.put("reason_for_holiday",reason_for_holiday);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );			
		}else if("delete".equals(mode)){
			String holiday_date=defaultDateFormat(req.getParameter("holiday_date"));		
			tabdata.put("holiday_date",holiday_date);
			tabdata.put("operating_facility_id",facility_id);
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
			//out.println(e.toString());
		}
		return busObj;
	}

	
	private void insert(HttpServletRequest req, HttpServletResponse res){
		HashMap tabData = populateTabData(req,res);
		String dupflds[]={"operating_facility_id","holiday_date"};
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
			//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){
		String holiday_date=defaultDateFormat(req.getParameter("holiday_date"));


		HashMap tabData = populateTabData(req,res);
		HashMap condflds=new HashMap();
		condflds.put("holiday_date",holiday_date);
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

		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse res){
		HashMap tabData = populateTabData(req,res);
		Object argArray[]  = new Object[3];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = table_name;
		Class [] paramArray	   = new Class[3];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = table_name.getClass();
		try{   
			Object busObj = getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
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

	public String defaultDateFormat(String date){
		String[] tokens={"","",""}; 
		String formatted_date = "";
		StringTokenizer tokenizer = new StringTokenizer(date,"/");
		int count = 0;
		while(tokenizer.hasMoreElements()){
			tokens[count] = tokenizer.nextToken();
			count++;
		}
		String months[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		formatted_date = tokens[0]+"-"+months[Integer.parseInt(tokens[1])-1 ]+"-"+tokens[2];
		return formatted_date;
	}

}

