/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import eMR.UserAccessRights.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommon.XSSRequestWrapper;

public class UserAccessRightsServlet extends javax.servlet.http.HttpServlet
{

	PrintWriter out;
	Properties p;
	StringBuffer sb = new StringBuffer();

	String rec_sen_diag_for_cons_pat_yn="";
	String rec_sen_diag_for_oth_pat_yn="";
	String vw_sen_diag_for_cons_pat_yn="";
	String vw_sen_diag_for_oth_pat_yn="";
	String sen_diag_password="";
	String rec_high_risk_for_cons_pat_yn="";
	String rec_high_risk_for_oth_pat_yn="";
	String vw_high_risk_for_cons_pat_yn="";
	String vw_high_risk_for_oth_pat_yn="";
	String high_risk_password="";
	String appl_user_id="";
	String user_fac_id="";
	//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
	String change_national_id="";
	String enable_national_id=""; //Added by Ashwin K for AAKH-CRF-0150
	String myhix_view_YN=""; //added myhix_view_YN for MYHIX integration ML-MMOH-CRF-0507.1
	String cancel_transfer_in_yn=""; //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
	String requestor_type_yn=""; //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
	String facility_id ;
	String client_ip_address ;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		session = req.getSession(false);
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )   insertUserAccessRights(req, res);
			if ( operation.equals("modify"))    modifyUserAccessRights(req, res);

		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +sb.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )   insertUserAccessRights(req, res);
			if ( operation.equals("modify"))    modifyUserAccessRights(req, res);
		}
		catch(Exception e)	{	/* out.println(e.toString()); */ e.printStackTrace();	}
	}


	private void modifyUserAccessRights(HttpServletRequest req, HttpServletResponse res)
	{
	try
		{
			user_fac_id = req.getParameter("user_fac_id");
				if(user_fac_id == null) user_fac_id="";

			appl_user_id=req.getParameter("appl_user_id");
			rec_sen_diag_for_cons_pat_yn=req.getParameter("SD_record_for_cons_patient");
			rec_sen_diag_for_oth_pat_yn=req.getParameter("SD_record_for_oth_patient");
			vw_sen_diag_for_cons_pat_yn=req.getParameter("SD_view_of_cons_patient");
			vw_sen_diag_for_oth_pat_yn=req.getParameter("SD_view_of_oth_patient");
			sen_diag_password=req.getParameter("hidden_sensitive_password");

			rec_high_risk_for_cons_pat_yn=req.getParameter("HR_record_for_cons_patient");
			rec_high_risk_for_oth_pat_yn=req.getParameter("HR_record_for_oth_patient");
			vw_high_risk_for_cons_pat_yn=req.getParameter("HR_view_of_cons_patient");
			vw_high_risk_for_oth_pat_yn=req.getParameter("HR_view_of_oth_patient");
			high_risk_password=req.getParameter("hidden_highrisk_password");
			//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
			change_national_id=req.getParameter("change_national_id");
			if (change_national_id==null)   change_national_id="N";

			//Added by Ashwin K for AAKH-CRF-0150
			enable_national_id=req.getParameter("enable_national_id");
			if (enable_national_id==null)   enable_national_id="N";
			//Ended by Ashwin K for AAKH-CRF-0150

			//End

			myhix_view_YN=req.getParameter("myhix_view_YN"); //Added for MYHIX integration ML-MMOH-CRF-0507.1
			if (myhix_view_YN==null)   myhix_view_YN="N";

			//Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
			cancel_transfer_in_yn=req.getParameter("cancel_transfer_in_yn"); 
			if (cancel_transfer_in_yn==null)	 cancel_transfer_in_yn="N";
			
			//Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
			requestor_type_yn=req.getParameter("requestor_type_yn"); 
			if (requestor_type_yn==null)	 requestor_type_yn="N";
			
			if (rec_sen_diag_for_cons_pat_yn==null)	 rec_sen_diag_for_cons_pat_yn="N";
			if (rec_sen_diag_for_oth_pat_yn==null)   rec_sen_diag_for_oth_pat_yn="N";
			if (vw_sen_diag_for_cons_pat_yn==null)   vw_sen_diag_for_cons_pat_yn="N";
			if (vw_sen_diag_for_oth_pat_yn==null)    vw_sen_diag_for_oth_pat_yn="N";

			if (rec_high_risk_for_cons_pat_yn==null) rec_high_risk_for_cons_pat_yn="N";
			if (rec_high_risk_for_oth_pat_yn==null)  rec_high_risk_for_oth_pat_yn="N";
			if (vw_high_risk_for_cons_pat_yn==null)  vw_high_risk_for_cons_pat_yn="N";
			if (vw_high_risk_for_oth_pat_yn==null)   vw_high_risk_for_oth_pat_yn="N";

			String addedFacilityId=facility_id;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap hashdata=new HashMap();
			hashdata.put("rec_sen_diag_for_cons_pat_yn", rec_sen_diag_for_cons_pat_yn);
			hashdata.put("rec_sen_diag_for_oth_pat_yn", rec_sen_diag_for_oth_pat_yn);
			hashdata.put("vw_sen_diag_for_cons_pat_yn", vw_sen_diag_for_cons_pat_yn);
			hashdata.put("vw_sen_diag_for_oth_pat_yn", vw_sen_diag_for_oth_pat_yn);
			hashdata.put("sen_diag_password", sen_diag_password);
			hashdata.put("rec_high_risk_for_cons_pat_yn", rec_high_risk_for_cons_pat_yn);
			hashdata.put("rec_high_risk_for_oth_pat_yn", rec_high_risk_for_oth_pat_yn);
			hashdata.put("vw_high_risk_for_cons_pat_yn", vw_high_risk_for_cons_pat_yn);
			hashdata.put("vw_high_risk_for_oth_pat_yn", vw_high_risk_for_oth_pat_yn);
			hashdata.put("high_risk_password", high_risk_password);
			//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
			hashdata.put("change_national_id", change_national_id);
			hashdata.put("enable_national_id", enable_national_id); // added by Ashwin K for AAKH-CRF-0150


			hashdata.put("myhix_view_YN", myhix_view_YN);  //Added for MYHIX integration ML-MMOH-CRF-0507.1
			hashdata.put("cancel_transfer_in_yn", cancel_transfer_in_yn); //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
			hashdata.put("requestor_type_yn", requestor_type_yn); //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
			hashdata.put("modifiedFacilityId", modifiedFacilityId);
			hashdata.put("modifiedAtWorkstation", modifiedAtWorkstation);
			hashdata.put("appl_user_id", appl_user_id);
			hashdata.put("facility_id", facility_id);
			hashdata.put("user_fac_id", user_fac_id);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserAccessRights",UserAccessRightsHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashdata.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("updateUserAccessRights",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
			}
			else
			{
				error = (String) results.get("error") ;
			}

        	error = (String) results.get("error") ;
                  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
  			if ( hashdata != null) hashdata.clear();
			if ( results != null) results.clear();
		}

		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();
		}
	}

	private void insertUserAccessRights(HttpServletRequest req, HttpServletResponse res)
	{

		try
		{
				user_fac_id = req.getParameter("user_fac_id");
					if(user_fac_id == null) user_fac_id="";

			appl_user_id=req.getParameter("appl_user_id");
			rec_sen_diag_for_cons_pat_yn=req.getParameter("SD_record_for_cons_patient");
			rec_sen_diag_for_oth_pat_yn=req.getParameter("SD_record_for_oth_patient");
			vw_sen_diag_for_cons_pat_yn=req.getParameter("SD_view_of_cons_patient");
			vw_sen_diag_for_oth_pat_yn=req.getParameter("SD_view_of_oth_patient");
			sen_diag_password=req.getParameter("hidden_sensitive_password");

			rec_high_risk_for_cons_pat_yn=req.getParameter("HR_record_for_cons_patient");
			rec_high_risk_for_oth_pat_yn=req.getParameter("HR_record_for_oth_patient");
			vw_high_risk_for_cons_pat_yn=req.getParameter("HR_view_of_cons_patient");
			vw_high_risk_for_oth_pat_yn=req.getParameter("HR_view_of_oth_patient");
			high_risk_password=req.getParameter("hidden_highrisk_password");
			//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
			change_national_id=req.getParameter("change_national_id");
			if (change_national_id==null)	 change_national_id="N";

			//Added by Ashwin K for AAKH-CRF-0150
			enable_national_id=req.getParameter("enable_national_id");
			if (enable_national_id==null)   enable_national_id="N";
			//Ended by Ashwin K for AAKH-CRF-0150

			//End
			
			//Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
			cancel_transfer_in_yn=req.getParameter("cancel_transfer_in_yn"); 
			if (cancel_transfer_in_yn==null)	 cancel_transfer_in_yn="N";
			
			//Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
			requestor_type_yn=req.getParameter("requestor_type_yn"); 
			if (requestor_type_yn==null)	 requestor_type_yn="N";

			myhix_view_YN=req.getParameter("myhix_view_YN"); //Added for MYHIX integration ML-MMOH-CRF-0507.1.
			if (myhix_view_YN==null)	 myhix_view_YN="N";
			
			if (rec_sen_diag_for_cons_pat_yn==null)	 rec_sen_diag_for_cons_pat_yn="N";
			if (rec_sen_diag_for_oth_pat_yn==null)   rec_sen_diag_for_oth_pat_yn="N";
			if (vw_sen_diag_for_cons_pat_yn==null)   vw_sen_diag_for_cons_pat_yn="N";
			if (vw_sen_diag_for_oth_pat_yn==null)    vw_sen_diag_for_oth_pat_yn="N";
			if (rec_high_risk_for_cons_pat_yn==null) rec_high_risk_for_cons_pat_yn="N";
			if (rec_high_risk_for_oth_pat_yn==null)  rec_high_risk_for_oth_pat_yn="N";
			if (vw_high_risk_for_cons_pat_yn==null)  vw_high_risk_for_cons_pat_yn="N";
			if (vw_high_risk_for_oth_pat_yn==null)   vw_high_risk_for_oth_pat_yn="N";

			String addedFacilityId=facility_id;
			String addedAtWorkstation=client_ip_address;
			
			HashMap hashdata=new HashMap();
			hashdata.put("facility_id", facility_id);
			hashdata.put("appl_user_id", appl_user_id);
			hashdata.put("rec_sen_diag_for_cons_pat_yn", rec_sen_diag_for_cons_pat_yn);
			hashdata.put("rec_sen_diag_for_oth_pat_yn", rec_sen_diag_for_oth_pat_yn);
			hashdata.put("vw_sen_diag_for_cons_pat_yn", vw_sen_diag_for_cons_pat_yn);
			hashdata.put("vw_sen_diag_for_oth_pat_yn", vw_sen_diag_for_oth_pat_yn);
			hashdata.put("sen_diag_password", sen_diag_password);
			hashdata.put("rec_high_risk_for_cons_pat_yn", rec_high_risk_for_cons_pat_yn);
			hashdata.put("rec_high_risk_for_oth_pat_yn", rec_high_risk_for_oth_pat_yn);
			hashdata.put("vw_high_risk_for_cons_pat_yn", vw_high_risk_for_cons_pat_yn);
			hashdata.put("vw_high_risk_for_oth_pat_yn", vw_high_risk_for_oth_pat_yn);
			hashdata.put("high_risk_password", high_risk_password);
			//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
			hashdata.put("change_national_id", change_national_id);

			hashdata.put("enable_national_id", enable_national_id);

			hashdata.put("myhix_view_YN", myhix_view_YN); //Added for MYHIX integration ML-MMOH-CRF-0507.1
			hashdata.put("cancel_transfer_in_yn", cancel_transfer_in_yn); //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
			hashdata.put("requestor_type_yn", requestor_type_yn); //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
			hashdata.put("addedFacilityId", addedFacilityId);
			hashdata.put("addedAtWorkstation", addedAtWorkstation);
			hashdata.put("user_fac_id", user_fac_id);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserAccessRights",UserAccessRightsHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashdata.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insertUserAccessRights",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;

						String error_value = "0" ;
						if ( inserted )
						{
						 error_value = "1" ;
						}
						else
						{
						 error = (String) results.get("error") ;
						}

			        	error = (String) results.get("error") ;
		                res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
						if (hashdata != null) hashdata.clear();
						if ( results != null) results.clear();
					}
					catch ( Exception e )
					{
						/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
						out.println( "Values sent are : <br>" ) ;
						out.println( appl_user_id+" "+sb.toString()); */
						
						e.printStackTrace();						
					}


		}
}
