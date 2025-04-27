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
import webbeans.eCommon.*;
import java.util.*;
//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;

import eCommon.SingleTabHandler.*;
import eCommon.XSSRequestWrapper;

public class SpecialityServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String specialitycode;
	String longDesc ;
	String shortDesc ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	String vitalsignsbattery ;
	String multi_speciality_yn ;//Added for the CRF- Bru-HIMS-CRF-0198
	
	/*Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 Start*/
	String mrApplYN;
	String locale;
	boolean isProceed	= true;
	int mrOpenReqCount = 0;
	String isMRSpecialtyApp = "false";
	/*Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 End*/

	//String serviceURL;
	//String objectName;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		//MMS-ME-SCF-0096 vulnerability Issue
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		/*serviceURL=(String) session.getValue("serviceURL");
		objectName="/test/SingleTabHandlerManager";*/
		this.locale			     = p.getProperty("LOCALE");

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertSpeciality(req, res);
			if ( operation.equals("modify"))    modifySpeciality(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}*/


	private void modifySpeciality(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			specialitycode=req.getParameter("speciality_code");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			vitalsignsbattery = req.getParameter("vital_signs_battery");
			effectiveStatus = req.getParameter("eff_status");
			multi_speciality_yn = req.getParameter("multi_speciality_yn")==null?"N":req.getParameter("multi_speciality_yn");//Added for the CRF- Bru-HIMS-CRF-0198
			if ( effectiveStatus == null )
				effectiveStatus="D";
			/*Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 Start*/
			mrApplYN = req.getParameter("mr_appl_yn")==null?"N":req.getParameter("mr_appl_yn");
			mrOpenReqCount = Integer.parseInt(req.getParameter("mrOpenReqCount"));
			isMRSpecialtyApp = req.getParameter("isMRSpecialtyApp")==null?"false":req.getParameter("isMRSpecialtyApp");
			isProceed	= true;
			if(!isMRSpecialtyApp.equals("true")){
				mrApplYN	= "Y";
			}
			if(mrApplYN.equals("N") && effectiveStatus.equals("E") && mrOpenReqCount > 0 && isMRSpecialtyApp.equals("true")){
				isProceed = false;
			}
			/*Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 End*/		
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

			if(isProceed){
				HashMap tabdata=new HashMap();
				tabdata.put("long_desc",longDesc);
				tabdata.put("short_desc",shortDesc);
				tabdata.put("vital_signs_battery_id",vitalsignsbattery);
				tabdata.put("multi_speciality_yn",multi_speciality_yn);//Added for the CRF- Bru-HIMS-CRF-0198
				tabdata.put("mr_appl_yn",mrApplYN );//Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454
				tabdata.put("eff_status",effectiveStatus);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				HashMap condflds=new HashMap();
				condflds.put("speciality_code",specialitycode);

			/*java.util.Hashtable env = (java.util.Hashtable)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) ic.lookup( serviceURL+objectName ) ;*/
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_speciality");*/

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		

				/*HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("condflds",condflds);
				String table_name="am_speciality";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/



				
						Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
					String table_name="am_speciality";
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

			

		

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);




			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
			     error_value = "1" ;
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8" ) );

			}
			tabdata.clear();
			condflds.clear();
			results.clear();
			}else{
				MessageManager mm = new MessageManager();
				final java.util.Hashtable error = mm.getMessage(locale, "MR_OPEN_REQ_AVAILABLE_CANNOT_PROCEED", "AM") ;
				String errMsg = ((String) error.get("message"));					
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( errMsg ,"UTF-8" ) );
			}
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( specialitycode+ " "+longDesc + " "+shortDesc + " "+ effectiveStatus );
		}
	}

	private void insertSpeciality(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			specialitycode=req.getParameter("speciality_code");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			vitalsignsbattery = req.getParameter("vital_signs_battery");

			effectiveStatus = req.getParameter("eff_status");
			multi_speciality_yn = req.getParameter("multi_speciality_yn")==null?"N":req.getParameter("multi_speciality_yn");//Added for the CRF- Bru-HIMS-CRF-0198
			if ( effectiveStatus == null )
				effectiveStatus="D";
			mrApplYN = req.getParameter("mr_appl_yn")==null?"N":req.getParameter("mr_appl_yn");//Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454

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
				tabdata.put("speciality_code",specialitycode);
				tabdata.put("long_desc",longDesc);
				tabdata.put("short_desc",shortDesc);
				tabdata.put("vital_signs_battery_id",vitalsignsbattery);
				tabdata.put("multi_speciality_yn",multi_speciality_yn);//Added for the CRF- Bru-HIMS-CRF-0198
				tabdata.put("eff_status",effectiveStatus);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("mr_appl_yn",mrApplYN );

				String dupflds[]={"speciality_code"};


/*			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_speciality");*/

			
						 boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			/*	HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("dupflds",dupflds);
				String table_name="am_speciality";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/

					
				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_speciality";
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

					

			

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);





			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}


			tabdata.clear();
			results.clear();

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( specialitycode+ " "+longDesc + " "+shortDesc +" "+ effectiveStatus );
		}
	}

}
