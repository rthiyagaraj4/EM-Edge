/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
												Developed by		   :		Geetha C R
												Developed on	 	   :	 	02/02/2001
												Modified by      	   :
												Modified Date	       :										*/
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
 * @todo Some of the class members should be moved to method level scope
 */
public class CircumstanceofInjuryServlet extends HttpServlet{
	PrintWriter out;
	
	java.util.Properties p;
	String circumstanceofInjuryCode;
	String longDesc ;
	String effectiveStatus;
	String shortDesc ;
	String injuryReimbursementType;
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
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert"))   insertcircumstanceofInjuryCode(req, res);
			if ( operation.equals("modify"))    modifycircumstanceofInjuryCode(req, res);
		}catch(Exception e){
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
	}


	private void modifycircumstanceofInjuryCode(HttpServletRequest req, HttpServletResponse res)	{
		try	{
			circumstanceofInjuryCode=req.getParameter("circumstance_of_injury_code");
			longDesc  		 = req.getParameter("long_desc");
			shortDesc 		 = req.getParameter("short_desc");
			injuryReimbursementType	 = req.getParameter("injury_reimbursement_type");
			effectiveStatus	 = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				 effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			Date modified_date = Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("circumstance_of_injury_code",circumstanceofInjuryCode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("injury_reimbursement_type",injuryReimbursementType);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();

			condflds.put("circumstance_of_injury_code",circumstanceofInjuryCode);

			/*java.util.HashMap env = (java.util.HashMap)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );*/

/*			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_circumstance_of_injury");
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
			hmParams.put("table_name","am_circumstance_of_injury");
			argArray[0] = hmParams;

			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();*/

				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_circumstance_of_injury";
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
		//	hmParams.clear();
			tabdata.clear();
			condflds.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}else{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}results.clear();
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( circumstanceofInjuryCode+ " "+longDesc + " "+shortDesc + ""+injuryReimbursementType+ " "+ effectiveStatus );
		}
	}

	private void insertcircumstanceofInjuryCode(HttpServletRequest req, HttpServletResponse res){
		try{
			circumstanceofInjuryCode=req.getParameter("circumstance_of_injury_code");
			longDesc  		 = req.getParameter("long_desc");
			shortDesc 		 = req.getParameter("short_desc");
			injuryReimbursementType	 = req.getParameter("injury_reimbursement_type");
			effectiveStatus	 = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				 effectiveStatus="D";
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Date added_date = Date.valueOf( addedDate ) ;
			Date modified_date = Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("circumstance_of_injury_code",circumstanceofInjuryCode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("injury_reimbursement_type",injuryReimbursementType);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"circumstance_of_injury_code"};

			/*java.util.Hashtable env = (java.util.Hashtable)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );*/
/*
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome     = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_circumstance_of_injury");

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
			hmParams.put("dupflds",dupflds);
			hmParams.put("table_name","am_circumstance_of_injury");
			argArray[0] = hmParams;

			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();*/



				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_circumstance_of_injury";
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
		//	hmParams.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}else{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}results.clear();
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( circumstanceofInjuryCode+ " "+longDesc + " "+shortDesc +" "+injuryReimbursementType+" "+ effectiveStatus );
			e.printStackTrace();
		}
	}
}
