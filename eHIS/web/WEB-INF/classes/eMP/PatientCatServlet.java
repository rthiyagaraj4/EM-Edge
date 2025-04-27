/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 10:08 AM 

 * @filename PatientCatServlet.java
 *
 * @version 3.0 modified on 2/21/2005
 *	
 *****/

package eMP;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Properties;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

/*** @todo Class data members should be moved to method level scope ***/
public class PatientCatServlet extends HttpServlet{
	PrintWriter out;
	Properties p;
	String patientcategoryCode;
	String longDesc ;
	String shortDesc ;
	String jobType;
	String expiry_applicable;
	String expiry_period;
	String effectiveDateFrom ;
	String effectiveDateTo ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	
	/**
	 * @todo Synchronization can be removed once variables are moved to method level
	 */
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
												    throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try {
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			if ( operation.equals("insert") )
				insertPatientCategory(req, res);
			if ( operation.equals("modify"))
				modifyPatientCategory(req, res);
		}catch (Exception e)	{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		try	{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/PatientCategory.js'></script><script src='../eCommon/js/messages.js' language='javascript'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} catch(Exception e)	{	
			e.printStackTrace();
		}
	}

	private void modifyPatientCategory(HttpServletRequest req, HttpServletResponse res)	{
		try {
			patientcategoryCode=req.getParameter("patient_cat_code");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			jobType = req.getParameter( "job_type" );
			expiry_applicable           = req.getParameter( "expiry_appl" ) == null ? "N" : req.getParameter( "expiry_appl"  ) ;
			expiry_period           = req.getParameter( "expiry_period" ) == null ? "" : req.getParameter( "expiry_period"  ) ;
			
			effectiveDateFrom = req.getParameter("eff_date_from");
			effectiveDateTo = req.getParameter("eff_date_to");
			effectiveStatus = req.getParameter("eff_status");

			if ( effectiveStatus == null )
				effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			
			String modifiedById = addedById ;
		
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("pat_cat_code",patientcategoryCode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("govt_or_pvt_ind", jobType);
			tabdata.put("EXP_VAL_APPL_YN", expiry_applicable);
			tabdata.put("EXP_PERIOD_IN_DAYS", expiry_period);
			tabdata.put("eff_date_from",effectiveDateFrom);
			tabdata.put("eff_date_to",effectiveDateTo);
			tabdata.put("eff_status",effectiveStatus);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("pat_cat_code",patientcategoryCode);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_PAT_CATEGORY";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;			

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			condflds.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value ); 
		} catch ( Exception e ) {
				/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;
				out.println( patientcategoryCode + " "+longDesc + " "+shortDesc +" "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus ); */
				e.printStackTrace();
			}
	}
	private void insertPatientCategory(HttpServletRequest req, HttpServletResponse res)	{
		try {
			patientcategoryCode = req.getParameter("patient_cat_code");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			jobType = req.getParameter( "job_type" );
			//expiry_applicable=req.getParameter( "expiry_appl" );
			//expiry_period=req.getParameter( "expiry_period" );
			expiry_applicable           = req.getParameter( "expiry_appl" ) == null ? "N" : req.getParameter( "expiry_appl"  ) ;
			expiry_period           = req.getParameter( "expiry_period" ) == null ? "" : req.getParameter( "expiry_period"  ) ;

			effectiveDateFrom = req.getParameter("eff_date_from");
			effectiveDateTo = req.getParameter("eff_date_to");
			effectiveStatus = req.getParameter("eff_status");

			if ( effectiveStatus == null )
					effectiveStatus="D";
			
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("pat_cat_code",patientcategoryCode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("govt_or_pvt_ind", jobType);
			tabdata.put("EXP_VAL_APPL_YN", expiry_applicable);
			tabdata.put("EXP_PERIOD_IN_DAYS", expiry_period);

			tabdata.put("eff_date_from",effectiveDateFrom);
			tabdata.put("eff_date_to",effectiveDateTo);
			tabdata.put("eff_status",effectiveStatus);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);	
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"pat_cat_code"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_PAT_CATEGORY";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			
			

		} catch ( Exception e ) {
			/* out.println(e.getMessage());
			out.println(e.toString()); */
			e.printStackTrace();
		}
	}
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
}
