/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import eAM.DurationType.*;

public class DurationTypeServlet extends javax.servlet.http.HttpServlet	{

PrintWriter out;
java.util.Properties p;

//String module_id = "CA";
String facilityId = "" ;
String client_ip_address = "";
//String serviceURL		=  "";
//String objectName	=  ""			;

//java.util.Hashtable env			;
//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

/*
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

/*
*	doPost	-	will be called when the method is of post
*	@param	req - this is HttpServletRequest
*	@param	res - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{       
	    req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("X-Content-Type-Options", "nosniff");
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = req.getRemoteAddr() ;

		//serviceURL 	= (String) session.getValue( "serviceURL" ) ;
		//objectName 	= "/test/SingleTabHandlerManager" ;

		try{
			res.setContentType("text/html");
			this.out = res.getWriter();

			modifyDurationType(req, res);

		} catch(Exception e) {
			out.println(e.toString());
		}

	}


/*
*	doGet	-	will be called when the method is of get
*	@param	req - this is HttpServletRequest
*	@param	res - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException {
	try	{
		this.out = res.getWriter();
		res.setContentType("text/html");
		String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = req.getQueryString() ;
		String source = url + params ;
    out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link><script language='javascript' src='../eMP/js/ActiveInactive.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");

	} catch(Exception e)	{	}
}


/*
*	modifyDurationType	-	used to populate the request parameters and
*										put in a Hashtable which will be further given as an argument to the
*										EJB - DurationType
*	@param	req - this is HttpServletRequest
*	@param	res - this is HttpServletResponse
*/

private void modifyDurationType(HttpServletRequest req, HttpServletResponse res)	{
	try {
		this.out = res.getWriter();

		
		String addedById = p.getProperty( "login_user" ) ;
	//	String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		//String modifiedDate = addedDate ;
		String modifiedFacilityId = facilityId ;
		String addedAtWorkstation=client_ip_address;
	
		String modifiedAtWorkstation = addedAtWorkstation ;
		
		HashMap tabdata=new HashMap();

		String  allTypeCode = req.getParameter("allTypeCode");
		String  allDesc = req.getParameter("allDesc");
		String  allForText = req.getParameter("allForText");

		tabdata.put("durn_desc_loc_lang",allDesc ) ;
	
		tabdata.put( "for_text",allForText ) ;
		tabdata.put("durn_type",allTypeCode);

		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("modified_facility_id",modifiedFacilityId);
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

	
		HashMap dupflds=new HashMap();
		dupflds.put("module_id","AM");

		/*InitialContext context = new InitialContext();
		Object homeObject = context.lookup("java:comp/env/DurationType");
		DurationTypeHome durationTypeHome  = (DurationTypeHome) PortableRemoteObject.narrow(homeObject ,DurationTypeHome.class);
		DurationTypeRemote durationTypeRemote = durationTypeHome.create();
		results = durationTypeRemote.modify(p,tabdata);*/

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
			local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DurationType",DurationTypeHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
		Object argArray[] = new Object[1];
		
		HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			
			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();
		
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
        hashmap.clear();
		tabdata.clear();
		dupflds.clear();
		
		String message = (String) results.get("message") ;
        
		if(message == null || message.equals("") ){
			message = (String) results.get("error") ;
		}
		String error_value = "0" ;

		if ( inserted ) error_value = "1" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( message ,"UTF-8" ) + "&err_value=" + error_value );

		results.clear();

	} catch ( Exception e ) {
		e.printStackTrace();
		
		
		}
	}
}
