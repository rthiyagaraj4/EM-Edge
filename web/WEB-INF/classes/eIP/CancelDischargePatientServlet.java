/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.SingleThreadModel;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eIP.IPCancelDischargePatient.* ;
import eCommon.XSSRequestWrapper;


 
public class CancelDischargePatientServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
		PrintWriter				out	= null;
		Properties				p	= null;
	String sStyle				= "";
		 /* CheckStyle Violation Commented by Munisekhar */ 
		//String locale				= "" ;  
	String encounterid			= "";
	String patientid			= "";
	String nursing_unit_code	= "";
	String specialty_code		= "";
	String cancel_discharge_bed_no		= "";
		 /* CheckStyle Violation Commented by Munisekhar */ 
		//String bed_class_code		= "";  
		//String bed_type_code		= "";  
	String attending_practitioner_id = "";
	String room_no				= "";
	String service_code			= "";
	String admissiondatetime	= "";			
	String reason_code			= "";						
	String assign_care_locn_type= "";			
	String adm_type_code		= "";	
	String patient_type			= "";
	String addedAtWorkstation	= "";
	String facilityId			= "";
	String bl_interfaced_yn		= "";
	String bl_operational		= "";
	String bed_no				= "";
	String patientgender		= "";
	String dateofbirth			= "";
	String disposition_type		= "";
	String referral_id			= "";
	String patient_class		= "";
	String cancel_ptact_id		= "";
	String discharge_status_code= "";

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
	{
		HttpSession session		=	req.getSession(false);
		facilityId				= checkForNull((String)session.getValue("facility_id"));
		sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		addedAtWorkstation		= p.getProperty("client_ip_address");	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//MMS-ME-SCF-0096 vulnerability Issue  
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		try 
		{
			
			this.out						= res.getWriter();
			patientid						= checkForNull(req.getParameter("patient_id"));
			encounterid						= checkForNull(req.getParameter("encounter_id"));
			nursing_unit_code				= checkForNull(req.getParameter("nursing_unit_code"));
			specialty_code					= checkForNull(req.getParameter("specialty_code"));
			cancel_discharge_bed_no			= checkForNull(req.getParameter("cancel_discharge_bed_no"));
			bed_no							= checkForNull(req.getParameter("bed_no"));
			attending_practitioner_id		= checkForNull(req.getParameter("practitioner_id"));
			room_no							= checkForNull(req.getParameter("room_no"));  
			service_code					= checkForNull(req.getParameter("service_code"));
			reason_code						= checkForNull(req.getParameter("cancel_reason"));
			patient_type					= checkForNull(req.getParameter("patient_type_code"));
			admissiondatetime				= checkForNull(req.getParameter("admission_date_time"));					
			assign_care_locn_type			= checkForNull(req.getParameter("assign_care_locn_type"));
			adm_type_code					= checkForNull(req.getParameter("admission_type"));
			bl_interfaced_yn				= checkForNull(req.getParameter("bl_interfaced_yn"));
			bl_operational					= checkForNull(req.getParameter("bl_operational"));
			//New Variables
			patientgender					= checkForNull(req.getParameter("gender"));
			dateofbirth						= checkForNull(req.getParameter("dateofbirth"));
			disposition_type				= checkForNull(req.getParameter("disposition_type"));
			referral_id						= checkForNull(req.getParameter("referral_id"));
			patient_class					= checkForNull(req.getParameter("patient_class_value"));
			cancel_ptact_id					= checkForNull(req.getParameter("cancel_pract_id"));
			discharge_status_code			= checkForNull(req.getParameter("discharge_status_code"));			
				
			HashMap hashData = new HashMap();

			hashData.put("facilityId",facilityId);
			hashData.put("patientid",patientid);
			hashData.put("encounter_id",encounterid);
			hashData.put("addedAtWorkstation",addedAtWorkstation);
			hashData.put("nursing_unit_code",nursing_unit_code);
			hashData.put("specialty_code",specialty_code);
			hashData.put("cancel_discharge_bed_no",cancel_discharge_bed_no);
			hashData.put("bed_no",bed_no);
			hashData.put("attending_practitioner_id",attending_practitioner_id);
			hashData.put("room_no",room_no);
			hashData.put("service_code",service_code);
			hashData.put("reason_code",reason_code);
			hashData.put("patient_type",patient_type);
			hashData.put("admissiondatetime",admissiondatetime);
			hashData.put("assign_care_locn_type",assign_care_locn_type);
			hashData.put("adm_type_code",adm_type_code);
			hashData.put("bl_interfaced_yn",bl_interfaced_yn);	
			hashData.put("bl_operational",bl_operational);	
			hashData.put("patientgender",patientgender);	
			hashData.put("dateofbirth",dateofbirth);	
			hashData.put("disposition_type",disposition_type);	
			hashData.put("referral_id",referral_id);
			hashData.put("patient_class",patient_class);
			hashData.put("cancel_ptact_id",cancel_ptact_id);
			hashData.put("discharge_status_code",discharge_status_code);

		
			boolean local_ejbs = false;
			java.util.HashMap results = new java.util.HashMap();
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPCancelDischargePatient",IPCancelDischargePatientHome.class,local_ejbs);

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
			
			results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPCancelDischargePatient",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		
			boolean inserted    = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				
			String error		= (String) results.get("error") ;

			if(inserted)
			{
				
				out.print("<script>alert('"+error+"')</script>");
				//out.print("<script>window.parent.close();</script>");
				out.print("<script>top.document.getElementById('dialog_tag').close();</script>");
			}
			else
			{				
				String error_value = "1" ;
				out.print("<script>parent.message_frame.location.href = '../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+error_value+"';</script>");
			}

			hashData.clear();
			results.clear();	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
} 

