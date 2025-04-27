/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

/**
 * @todo Class members should be moved to method level scope
 */
public class TransportModeServlet extends HttpServlet{
	PrintWriter out;
	Properties p;
	String transport_mode;
	String longDesc ;
	String shortDesc ;
	String patient_related_yn;
	String file_related_yn;
	String specimen_related_yn;
	String by_person_yn;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;

	//String serviceURL;
	//String objectName;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		/*serviceURL=(String) session.getValue("serviceURL");
		objectName="/test/SingleTabHandlerManager";*/

		try{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("operation");
			//out.println(operation);
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);						
		}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}*/
 
	private void modify(HttpServletRequest req, HttpServletResponse res){
		try{
			transport_mode=req.getParameter("transport_mode");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");

			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			patient_related_yn = req.getParameter("patient_related_yn");
			if (patient_related_yn == null)
			     patient_related_yn="N";

			specimen_related_yn = req.getParameter("specimen_related_yn");
			if (specimen_related_yn == null)
			     specimen_related_yn="N";
			
			file_related_yn = req.getParameter("file_related_yn");
			if (file_related_yn == null)
			     file_related_yn="N";

			by_person_yn = req.getParameter("by_person_yn");
			if (by_person_yn == null)
			     by_person_yn="N";
						
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("patient_related_yn",patient_related_yn);
			tabdata.put("file_related_yn",file_related_yn);
			tabdata.put("specimen_related_yn",specimen_related_yn);
			tabdata.put("by_person_yn",by_person_yn);
			tabdata.put("ip_tfr_pat_out_yn",checkForDefault(req.getParameter("tfr_pat_out_yn"),"N"));//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
			//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
			tabdata.put("application_mode",checkForDefault(req.getParameter("application_mode"),"N"));
			tabdata.put("collection_mode",checkForDefault(req.getParameter("collection_mode"),"N"));
			tabdata.put("notification_mode",checkForDefault(req.getParameter("notification_mode"),"N"));

			HashMap condflds=new HashMap();
			condflds.put("transport_mode",transport_mode);
			//condflds.put("facility_id",addedFacilityId); 

			/*java.util.HashMap env = (java.util.HashMap)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );*/
/*
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_transport_mode");
*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		/*	Object argArray[] = new Object[1];			
			HashMap hmParams = new HashMap();
			hmParams.put("p",p);
			hmParams.put("tabdata",tabdata);
			hmParams.put("condflds",condflds);
			hmParams.put("table_name","am_transport_mode");
			argArray[0] = hmParams;

			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();*/

						Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_transport_mode";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();

			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			//Clears the mapping
			tabdata.clear();
			condflds.clear();
//			hmParams.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
			     error_value = "1" ;
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
			}else{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}results.clear();
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			//out.println(arrivalcode+ " "+longDesc + " "+shortDesc + " "+ effectiveStatus );
		}
	} 
  	 
	private void insert(HttpServletRequest req, HttpServletResponse res){
		try{
			transport_mode=req.getParameter("transport_mode");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");

			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			patient_related_yn = req.getParameter("patient_related_yn");
			if (patient_related_yn == null)
			     patient_related_yn="N";

			specimen_related_yn = req.getParameter("specimen_related_yn");
			if (specimen_related_yn == null)
			     specimen_related_yn="N";
			
			file_related_yn = req.getParameter("file_related_yn");
			if (file_related_yn == null)
			     file_related_yn="N";

			by_person_yn = req.getParameter("by_person_yn");
			if (by_person_yn == null)
			     by_person_yn="N";	 
			
			out.println(transport_mode+effectiveStatus+patient_related_yn+specimen_related_yn+file_related_yn+by_person_yn);				        

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("transport_mode",transport_mode);
			//tabdata.put("facility_id",addedFacilityId);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("patient_related_yn",patient_related_yn);
			tabdata.put("file_related_yn",file_related_yn);
			tabdata.put("specimen_related_yn",specimen_related_yn);
			tabdata.put("by_person_yn",by_person_yn);
			tabdata.put("ip_tfr_pat_out_yn",checkForDefault(req.getParameter("tfr_pat_out_yn"),"N"));//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
			tabdata.put("application_mode",checkForDefault(req.getParameter("application_mode"),"N"));
			tabdata.put("collection_mode",checkForDefault(req.getParameter("collection_mode"),"N"));
			tabdata.put("notification_mode",checkForDefault(req.getParameter("notification_mode"),"N"));

			String dupflds[]={"transport_mode"};
		
			/*java.util.HashMap env = (java.util.HashMap)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );*/
/*
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_transport_mode");
*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			/*Object argArray[] = new Object[1];			
			HashMap hmParams = new HashMap();
			hmParams.put("p",p);
			hmParams.put("tabdata",tabdata);
			hmParams.put("dupflds",dupflds);
			hmParams.put("table_name","am_transport_mode");
			argArray[0] = hmParams;

			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();*/



				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_transport_mode";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();

			
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
			//Clears the mapping
			tabdata.clear();
	//		hmParams.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
			}else{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			} results.clear();			
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		} 	
	} 

	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}

}
