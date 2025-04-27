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
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import webbeans.eCommon.*;
import eIP.IPPrepareDischargeAdvice.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public class DischargeAdviceServlet extends javax.servlet.http.HttpServlet
{
	/*
	java.util.Properties p;
	HttpSession session;
	String sStyle				= "";
	String locale				= "" ;
	*/
	PrintWriter		out;
	Properties		p;
	String sStyle				= "";
	String locale				= "" ;
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		PrintWriter				out = null;
		HttpSession session			= null;
		String sStyle				= "";
		/* CheckStyle Violation Commented by Munisekhar */ 
		//String locale				= "" ; //CheckStyle Violation
		try	
		{
			session				=	request.getSession(false);
			out					= response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
			String url		= "../eCommon/jsp/commonToolbar.jsp?" ;
			String params	= request.getQueryString() ;
			String source	= url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException,IOException
	{
		HttpSession session		= request.getSession(false);
		sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//MMS-ME-SCF-0096 vulnerability Issue
		request= new XSSRequestWrapper(request);
		out					= response.getWriter();
		out.println("<!DOCTYPE html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/" + sStyle + "'>");
		out.println("<script src='../eCommon/js/showModalDialog.js' type='text/javascript'></script>");
		out.println("<script src='../eIP/js/DischargeAdvice.js' type='text/javascript'></script>");
		out.println("<script type='text/javascript'>");
		out.println("async function callDischargeAdviceServletHTML() { ");
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		/*
		session				=	request.getSession(false);
		this.p				=	(java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		*/
		updateDischargeAdvice(request, response);
		out.println("} callDischargeAdviceServletHTML();</script></body></html>");
	}

	private void updateDischargeAdvice(HttpServletRequest request, HttpServletResponse response)
	{
		java.util.Properties p		= null;
		HttpSession session			= null;
		String sStyle				= "";
		String locale				= "" ;
		PrintWriter				out = null;
		Connection con				= null;
		Statement stmt				= null;
		ResultSet rs				= null;
		session						=	request.getSession(false);
		p							=	(java.util.Properties) session.getValue( "jdbc" ) ;
		locale						= p.getProperty("LOCALE");
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		try
		{
			con = ConnectionManager.getConnection(request);
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
		}catch (Exception Ex)
		{
				Ex.printStackTrace();		
		}
		String facilityId 					=	checkForNull((String) session.getValue("facility_id"));
		String encounterId 	 				=	request.getParameter("encounterID");
		String proceed						=	"Pass";
		String takehomenewmedyn				=	"";
		String labchargesyn					=	"";
		String xraychargesyn				=	"";
		String scanchargesyn				=	"";
		String ultrasoundchargesyn			=	"";
		String mrichargesyn					=	"";
		String rtchargesyn					=	"";
		String physiochargesyn				=	"";
		String ecgchargesyn					=	"";
		String dietchargesyn				=	"";
		String phchargesyn					=	"";
		String setup_bl_dtls_in_ip_yn		=	"";
		//These variables added by kishore on 10/26/2004 for Medical Certificate Page
		String SickLeaveDetails				=	"";
		String SickLeaveRecordFlag			=	""; 
		String LeaveFrom					=	"";
		String LeaveTo						=	"";
		String FitForDuty					=	"";
		String FitonDuty					=	"";
		String CertIssued					=	"";
		String AuthorizedById				=	"";
		String Pract_name					= "";
		String MC_No						= "";
		String emp_details					= "";
		String cert_type					= "";
		String issued_date					= "";
		String cert_Remarks					= "";
		String resume_date					= "";
		String	take_home_new_med_bill_yn	=	"Y";
		String	lab_charges_bill_yn			=	"Y";
		String	xray_charges_bill_yn		=	"Y";
		String	scan_charges_bill_yn		=	"Y";
		String	ultrasound_charges_bill_yn	=	"Y";
		String	ecg_charges_bill_yn			=	"Y";
		String	mri_charges_bill_yn			=	"Y";
		String	rt_charges_bill_yn			=	"Y";
		String	ph_charges_bill_yn			=	"Y";
		String	physio_charges_bill_yn		=	"Y";
		String	diet_charges_bill_yn		=	"Y";
		String	is_ca_yn					=	"N";
		String msg1							=	"";
		String nursingunitcode				=   "";
		//String mr_mds_recorded				=   "";//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		String patient_class_value			=   "";
		String bl_interfaced_yn				=   "";
		String bl_operational				=   "";
		String function_id					=   "";
		String ca_install_yn				=	"";
		String record_exists				=	"";
		int diagnosisCount					= 0;
		String patientid					=	checkForNull(request.getParameter("patient_id"));
		String discharge_indicator			=	checkForNull(request.getParameter("dischage_indicator"));
//modified on 2/07/2008 for SCR 3228
		String discharge_status_indicator	=	checkForNull(request.getParameter("dischage_status_indicator"));

		takehomenewmedyn	 				=	checkForNull(request.getParameter("newmedicine"), "N");
		labchargesyn   						=   checkForNull(request.getParameter("lab"), "N");
		xraychargesyn  						=	checkForNull(request.getParameter("xray"), "N");
		scanchargesyn  						=	checkForNull(request.getParameter("scan"), "N");
		ultrasoundchargesyn					=	checkForNull(request.getParameter("ultrasound"), "N");
		mrichargesyn  						=	checkForNull(request.getParameter("mri"), "N");
		rtchargesyn 	  					=	checkForNull(request.getParameter("rt"), "N");
		physiochargesyn						=	checkForNull(request.getParameter("physio"), "N");
		ecgchargesyn   						=	checkForNull(request.getParameter("ecg"), "N");
		dietchargesyn  						=	checkForNull(request.getParameter("diet"), "N");
		phchargesyn 						=	checkForNull(request.getParameter("pharmacy"), "N");
		setup_bl_dtls_in_ip_yn 				=	checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"), "N");
		is_ca_yn							=	checkForNull(request.getParameter("is_ca_yn"), "N");
		SickLeaveRecordFlag					=   checkForNull(request.getParameter("SickLeaveRecordFlag"));
		SickLeaveDetails					=   checkForNull(request.getParameter("SickLeaveDetails"));
		nursingunitcode					    =   checkForNull(request.getParameter("nursingunitcode"));
		patient_class_value					=   checkForNull(request.getParameter("patient_class_value"));
		bl_interfaced_yn					=   checkForNull(request.getParameter("bl_interfaced_yn"));
		bl_operational 						=   checkForNull(request.getParameter("bl_operational"));
		function_id 						=   checkForNull(request.getParameter("function_id"));
		record_exists 						=   checkForNull(request.getParameter("record_exists"));
		
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
		String weight_on_admission		= checkForNull(request.getParameter("weight_on_admission"));
		String weight_on_admission_unit	= checkForNull(request.getParameter("weight_on_admission_unit"));
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
		/*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-JUN-2020*/
		String height_on_admission		= checkForNull(request.getParameter("height_on_admission"));
		String bmi = checkForNull(request.getParameter("bmi"));
		String discharge_to =checkForNull(request.getParameter("discharge_to"));
	/*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-JUN-2020 END */
		if (SickLeaveRecordFlag.equals("Y"))
		{
		if(SickLeaveDetails!=null);		
			SickLeaveDetails = SickLeaveDetails.trim();
			StringTokenizer token1	= new StringTokenizer(SickLeaveDetails, "~");

			if (token1.hasMoreTokens())
			{
					
				LeaveFrom			= checkForNull(token1.nextToken());
				if (LeaveFrom.equals("||")) LeaveFrom="";
				
				LeaveTo				= checkForNull(token1.nextToken());
				if (LeaveTo.equals("||")) LeaveTo="";
				
				FitForDuty			= checkForNull(token1.nextToken());
				if (FitForDuty.equals("||")) FitForDuty="N";
				
				CertIssued			= checkForNull(token1.nextToken());
				if (CertIssued.equals("||")) CertIssued="";
				
				AuthorizedById		= checkForNull(token1.nextToken());
				if (AuthorizedById.equals("||")) AuthorizedById="";
				
				cert_type		= checkForNull(token1.nextToken());
				if (cert_type.equals("||")) cert_type="";
				
				issued_date		= checkForNull(token1.nextToken());
				if (issued_date.equals("||")) issued_date="";
				
				cert_Remarks		= checkForNull(token1.nextToken());
				if (cert_Remarks.equals("||")) cert_Remarks="";
				
				resume_date			= checkForNull(token1.nextToken());
				if (resume_date.equals("||")) resume_date="";
				
				Pract_name		= checkForNull(token1.nextToken());
				if (Pract_name.equals("||")) Pract_name="";
				
				MC_No		= checkForNull(token1.nextToken());
				if (MC_No.equals("||")) MC_No="";
				
				if (token1.hasMoreTokens())
				{
					emp_details		= checkForNull(token1.nextToken());
					if (emp_details.equals("||")) 
						emp_details="";
				}
				else
					emp_details="";

/*
				emp_details1		= checkForNull(token1.nextToken());
				if (emp_details1.equals("¤")) emp_details1="";
*/				
				if (token1.hasMoreTokens())
				{
					FitonDuty			= checkForNull(token1.nextToken());
					if (FitonDuty.equals("||")) 
						FitonDuty="";
				}
				else
					FitonDuty="";
				
			}
		}

		if(takehomenewmedyn.equals("N"))
			take_home_new_med_bill_yn= "N";
		if(labchargesyn.equals("N"))
			lab_charges_bill_yn	= "N";
		if(xraychargesyn.equals("N"))
			xray_charges_bill_yn = "N";
		if(scanchargesyn.equals("N"))
			scan_charges_bill_yn = "N";
		if(ultrasoundchargesyn.equals("N"))
			ultrasound_charges_bill_yn = "N";
		if(mrichargesyn.equals("N"))
			mri_charges_bill_yn = "N";
		if(rtchargesyn.equals("N"))
			rt_charges_bill_yn = "N";
		if(physiochargesyn.equals("N"))
			physio_charges_bill_yn = "N";
		if(ecgchargesyn.equals("N"))
			ecg_charges_bill_yn = "N";
		if(dietchargesyn.equals("N"))
			diet_charges_bill_yn = "N";
		if(phchargesyn.equals("N"))
			ph_charges_bill_yn = "N";

		proceed = "Pass";
		/*SRR20056-SCF-3347 IN012727 Saturday, July 25, 2009*/
		//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	/*	try
		{

			StringBuffer chk_request =new StringBuffer();
			chk_request.append("select MR_MDS_RECORDED_YN('"+facilityId+"','"+encounterId+"','"+patient_class_value+"','') mr_mds_recorded from dual");
			stmt	= con.createStatement();
			rs = stmt.executeQuery(chk_request.toString());	
			if ((rs != null) && (rs.next()))
			mr_mds_recorded = checkForNull(rs.getString("mr_mds_recorded"));
			if(mr_mds_recorded.equals("Y"))
			{
				proceed = "Pass";
			}
			else
			{
				proceed = "Fail";
				java.util.Hashtable message = MessageManager.getMessage(locale,"MDS_NOT_ENTERED","Common");
				msg1 = ((String) message.get("message"));
				message.clear();
			}
			if(rs	 != null)   rs.close();
			if(stmt	 != null)   stmt.close();
			
	

		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
		/**/
		try
		{

			StringBuffer CAinstall = new StringBuffer();
			CAinstall.append("SELECT install_yn FROM sm_module WHERE module_id = 'CA'");
			stmt	= con.createStatement();
			rs		= stmt.executeQuery(CAinstall.toString());	
			if ((rs != null) && (rs.next()))
			ca_install_yn = rs.getString("install_yn");
			if(ca_install_yn  == null) ca_install_yn ="N";
			if(rs	 != null)   rs.close();
			if(stmt	 != null)   stmt.close();

			if(ca_install_yn.equals("Y"))
			{	
				StringBuffer diagCountSql = new StringBuffer();
				//diagCountSql.append( " select count(*) from PR_PROBLEM_ENC_DTL a, PR_PROBLEM b where a.patient_id='"+patientid+"' and a.encounter_id = '"+encounterId+"' and a.facility_id = '"+facilityId+"' and a.patient_id = b.patient_id and a.srl_no = b.srl_no and b.ip_diag_stage = 'D' and b.ERROR_YN = 'N' ");
				diagCountSql.append( " select  count(*) from PR_DIAGNOSIS a WHERE a.patient_id='"+patientid+"' and a.CURR_ENCOUNTER_ID = '"+encounterId+"' and a.CURR_FACILITY_ID = '"+facilityId+"'");


		
				stmt	= con.createStatement();
				rs		= stmt.executeQuery(diagCountSql.toString());	
				if((rs != null) && (rs.next()))
				{
					diagnosisCount = rs.getInt(1);
				}
				if(rs	 != null)   rs.close();
				if(stmt	 != null)   stmt.close();
				

			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		try 
		{	
			if(proceed.equals("Pass"))
			{	
				//request.setCharacterEncoding("UTF-8");
				//response.setContentType("text/html;charset=UTF-8");
				String error="";
	
				String exp_dis_date = checkForNull(request.getParameter("expecteddischargedate"));
				if(exp_dis_date.equals(""))
					exp_dis_date = "";
				else
					exp_dis_date = DateUtils.convertDate(exp_dis_date,"DMYHM",locale,"en");

				String death_date	= checkForNull(request.getParameter("death_date"));
				if(death_date.equals(""))
					death_date = "";
				else
					death_date	= DateUtils.convertDate(death_date,"DMYHM",locale,"en");
				
				String informed_date =  checkForNull(request.getParameter("informed_date"));
				if(informed_date.equals(""))
					informed_date = "";
				else
					informed_date = DateUtils.convertDate(informed_date,"DMYHM",locale,"en");

				String absconding_date = checkForNull(request.getParameter("absconding_date"));
				if(absconding_date.equals(""))
					absconding_date = "";
				else
					absconding_date = DateUtils.convertDate(absconding_date,"DMYHM",locale,"en");

				//out.println("<script>alert('exp: "+exp_dis_date+"   desth: "+death_date+"  informed: "+informed_date+"  absco: "+absconding_date+" ')</script>");
				
				/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
				String aadhar_card			   =  checkForNull(request.getParameter("aadhar_card"));
				String relationship			   =  checkForNull(request.getParameter("relationship"));
				String isAadharCardAndRelAppl  =  checkForNull(request.getParameter("isAadharCardAndRelAppl"));
				String citizen_yn			   =  checkForNull(request.getParameter("citizen_yn"));
				String alt_id4_type			   =  checkForNull(request.getParameter("alt_id4_type"));
				/*End GHL-CRF-0505*/
				String isDeathRegisterFormAppl					= checkForNull(request.getParameter("isDeathRegisterFormAppl"), "false");//Added for AAKH-CRF-0179 by Ajay Hatwate on 23-08-2023
				
				java.util.HashMap paramHashTab =  new java.util.HashMap();
				paramHashTab.put("facilityId", facilityId);
				paramHashTab.put("encounterId", encounterId);
				paramHashTab.put("remarks", checkForNull(request.getParameter("cancel_remarks")));
				paramHashTab.put("bedno", checkForNull(request.getParameter("bedno")));
				paramHashTab.put("nursingunitcode", checkForNull(request.getParameter("nursingunitcode")));
				paramHashTab.put("roomno", checkForNull(request.getParameter("roomno")));
				paramHashTab.put("gender", checkForNull(request.getParameter("gender")));
				paramHashTab.put("expecteddischargedate", exp_dis_date);
				paramHashTab.put("patientid", patientid);
				paramHashTab.put("dischargetypecode", checkForNull(request.getParameter("discharge_code")));

				paramHashTab.put("discharge_indicator", discharge_indicator);
		//modified on 2/07/2008 for SCR 3228
				paramHashTab.put("dischargestatuscode", checkForNull(request.getParameter("discharge_status")));
				paramHashTab.put("discharge_status_indicator", discharge_status_indicator);
	
				paramHashTab.put("deathtime", death_date);
				paramHashTab.put("post_mortem_req_yn", checkForNull(request.getParameter("post_mortem_request"),"N"));
				paramHashTab.put("dischargesummaryyn", checkForNull(request.getParameter("dischgsumsigned"), "N"));
				paramHashTab.put("takehomenewmedyn", takehomenewmedyn);
				paramHashTab.put("take_home_new_med_bill_yn", take_home_new_med_bill_yn);
				paramHashTab.put("takehomestkmedyn", checkForNull(request.getParameter("stockmedicine"),"N"));
				paramHashTab.put("labchargesyn", labchargesyn);
				paramHashTab.put("lab_charges_bill_yn", lab_charges_bill_yn);
				paramHashTab.put("xraychargesyn", xraychargesyn);
				paramHashTab.put("xray_charges_bill_yn", xray_charges_bill_yn);
				paramHashTab.put("scanchargesyn", scanchargesyn);
				paramHashTab.put("scan_charges_bill_yn", scan_charges_bill_yn);
				paramHashTab.put("ultrasoundchargesyn", ultrasoundchargesyn);
				paramHashTab.put("ultrasound_charges_bill_yn", ultrasound_charges_bill_yn);
				paramHashTab.put("mrichargesyn", mrichargesyn);
				paramHashTab.put("mri_charges_bill_yn", mri_charges_bill_yn);
				paramHashTab.put("rtchargesyn", rtchargesyn);
				paramHashTab.put("rt_charges_bill_yn", rt_charges_bill_yn);
				paramHashTab.put("physiochargesyn", physiochargesyn);
				paramHashTab.put("physio_charges_bill_yn", physio_charges_bill_yn);
				paramHashTab.put("ecgchargesyn", ecgchargesyn);
				paramHashTab.put("ecg_charges_bill_yn", ecg_charges_bill_yn);
				paramHashTab.put("dietchargesyn", dietchargesyn);
				paramHashTab.put("diet_charges_bill_yn", diet_charges_bill_yn);
				paramHashTab.put("phchargesyn", phchargesyn);
				paramHashTab.put("ph_charges_bill_yn", ph_charges_bill_yn);
				paramHashTab.put("setup_bl_dtls_in_ip_yn", setup_bl_dtls_in_ip_yn);
				paramHashTab.put("client_ip_address", p.getProperty("client_ip_address"));
				paramHashTab.put("practid", checkForNull(request.getParameter("practid")));
				paramHashTab.put("inform_to", checkForNull(request.getParameter("inform_to")));
				paramHashTab.put("informed_date", informed_date );
				paramHashTab.put("informed_name", checkForNull(request.getParameter("informed_name")));
				paramHashTab.put("medico_legal", checkForNull(request.getParameter("medico_legal"), "N"));
				paramHashTab.put("police_rep_no", checkForNull(request.getParameter("pol_rep_no")));
				paramHashTab.put("police_station", checkForNull(request.getParameter("pol_stn_id")));
				paramHashTab.put("police_id", checkForNull(request.getParameter("pol_id")));
				paramHashTab.put("discharge_remarks", checkForNull(request.getParameter("remarks")));
				paramHashTab.put("referred", checkForNull(request.getParameter("referred"), "N"));
				paramHashTab.put("referral_type", checkForNull(request.getParameter("referral_type")));
				paramHashTab.put("hcare_setting_type", checkForNull(request.getParameter("hcare_setting_type")));
				paramHashTab.put("referred_to", checkForNull(request.getParameter("referred_to")));
				paramHashTab.put("priority", checkForNull(request.getParameter("priority")));
				paramHashTab.put("preferred_date",checkForNull(request.getParameter("preferred_date")));
				paramHashTab.put("speciality",checkForNull(request.getParameter("speciality")));
				paramHashTab.put("service", checkForNull(request.getParameter("service")));
				paramHashTab.put("location0", checkForNull(request.getParameter("location0")));
				paramHashTab.put("location1", checkForNull(request.getParameter("location1")));
				paramHashTab.put("location2", checkForNull(request.getParameter("location2")));
				paramHashTab.put("pract_name", checkForNull(request.getParameter("pract_name")));
				paramHashTab.put("practitioner1", checkForNull(request.getParameter("practitioner1")));
				paramHashTab.put("practitioner", checkForNull(request.getParameter("practitioner")));
				paramHashTab.put("ref_for_ip", checkForNull(request.getParameter("ref_for_ip")));
				//paramHashTab.put("patient_class_value", checkForNull(request.getParameter("patient_class_value")));
				paramHashTab.put("patient_class_value", patient_class_value );
				paramHashTab.put("absconded_date", absconding_date);
				paramHashTab.put("absconded_yn", checkForNull(request.getParameter("absconding_yn"),"N"));
				paramHashTab.put("reported_to", checkForNull(request.getParameter("absconding_rep_to")));
				paramHashTab.put("patient_status", checkForNull(request.getParameter("patient_status")));
				paramHashTab.put("SickLeaveRecordFlag", SickLeaveRecordFlag);         
				paramHashTab.put("LeaveFrom", LeaveFrom);                   
				paramHashTab.put("LeaveTo", LeaveTo);                     
				paramHashTab.put("FitForDuty", FitForDuty);                  
				paramHashTab.put("FitonDuty", FitonDuty);                   
				paramHashTab.put("CertIssued", CertIssued);                  
				paramHashTab.put("AuthorizedById", AuthorizedById);
				paramHashTab.put("cert_type", cert_type);
				paramHashTab.put("issued_date", issued_date);
				paramHashTab.put("resume_date", resume_date);
				paramHashTab.put("MC_No", MC_No);
				paramHashTab.put("emp_details", emp_details);
				paramHashTab.put("cert_Remarks", cert_Remarks); 
				paramHashTab.put("billing_interfaced", bl_interfaced_yn); 
				paramHashTab.put("billing_installed", bl_operational); 
				paramHashTab.put("function_id", function_id); 
				paramHashTab.put("modified_date_val",checkForNull(request.getParameter("modified_date_val")));
				/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
				paramHashTab.put("weight_on_admission", weight_on_admission); 
				paramHashTab.put("weight_on_admission_unit", weight_on_admission_unit); 
				/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
				
				/*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-JUN-2020*/
				paramHashTab.put("height_on_admission", height_on_admission);
				paramHashTab.put("bmi", bmi); 
				paramHashTab.put("discharge_to", discharge_to); 
				/*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-JUN-2020 End*/

				/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
				paramHashTab.put("aadhar_card", aadhar_card); 
				paramHashTab.put("relationship", relationship); 
				paramHashTab.put("isAadharCardAndRelAppl", isAadharCardAndRelAppl); 
				paramHashTab.put("citizen_yn", citizen_yn);
				paramHashTab.put("alt_id4_type", alt_id4_type);
				/*End GHL-CRF-0505*/
				/*Added by Ajay Hatwate for AAKH-CRF-0179 on 23-08-2023 */
				paramHashTab.put("isDeathRegisterFormAppl", isDeathRegisterFormAppl);
				paramHashTab.put("enable_death_reg_form", checkForNull(request.getParameter("enable_death_reg_form"), "N")); 
				if(isDeathRegisterFormAppl.equals("true")){
					paramHashTab.put("death_reg_form_accession_num", checkForNull(request.getParameter("death_reg_form_accession_num")));	
				}

				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPPrepareDischargeAdvice",IPPrepareDischargeAdviceHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = paramHashTab;

				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = paramHashTab.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateDischargeAdvice",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error = (String) results.get("error") ;

				
			
				if (inserted)
				{
					// added by Bangarraju k  on 6th March 2009.....
					/*5/18/2009 IN010456*/

					if(is_ca_yn.equals("Y")) // From CA
					{

						out.println("alert('"+error+"');");
						if(record_exists.equals("true"))
							out.println("await parent.frames[2].FreezePage();");
					}
					else
					{

						out.println("alert('"+error+"');");
						error="";
						if(record_exists.equals("true"))
						{
							//out.println("var dialogFrame = parent.parent.document.getElementById('dialog-body').contentWindow;");
							//out.println("await dialogFrame.document.getElementById('messageFrame').FreezePage();");
							out.println("console.log(parent.frames[2].document)");
							out.println("await parent.frames[2].FreezePage();");

						}
					}

					String report_id_cnt="";
					String SM_Report = "Select count(*) from sm_report where module_id='IP' and report_id='IPBINDIS'";
					stmt	= con.createStatement();
					rs		= stmt.executeQuery(SM_Report.toString());	
					if((rs != null) && (rs.next()))
					{
						report_id_cnt = rs.getString(1);
					}
					if(rs	 != null)   rs.close();
					if(stmt	 != null)   stmt.close();
					if(!report_id_cnt.equals("0"))
						doOnlineReports(encounterId, nursingunitcode, patientid, facilityId,out,is_ca_yn,record_exists,discharge_indicator,sStyle);
					/*Wednesday, January 20, 2010 IN018336 ,since report_id = 'IPBINDIS' is applicable for ARTMES Site only & if Adaptive menu is not defined system should close discharge advice window.*/
					else
					{
						if(is_ca_yn.equals("Y") && record_exists.equals("false")) // From CA
						{
							/*Tuesday, February 09, 2010 , IN019055,to invoke MDR if adaptive menu not defined*/
							if(discharge_indicator.equals("DS"))
								out.println("parent.frames[2].invokeMaintainDeathRegister();");
							else
								out.print("document.location.href ='../eCommon/html/blank.html';parent.frames[2].document.location.href = '../eCommon/html/blank.html';parent.frames[1].document.location.href = '../eCommon/html/blank.html';parent.frames[3].document.location.href = '../eCommon/html/blank.html';");
						}
						else 
						{
							if(record_exists.equals("false"))
							{
								/*Tuesday, February 09, 2010 , IN019055,to invoke MDR if adaptive menu not defined*/
								if(discharge_indicator.equals("DS"))
								out.println("parent.frames[2].invokeMaintainDeathRegister();");
								else
									out.println("parent.window.close();");	

							}
						}
						
					}
					/**/

					/*if(!discharge_indicator.equals("DS") && !discharge_indicator.equals("AB") && !discharge_indicator.equals("AO"))
					{
						if(!discharge_indicator.equals("ED"))
						{
							java.util.Hashtable message = MessageManager.getMessage(locale,"REG_REFERRAL","Common");
							String ref_error = (String) message.get("message") ;


							out.print("<script>var truthBeTold = window.confirm(\""+ref_error+"\"); </script>");
							if(is_ca_yn.equals("Y")) // From CA
							{

								//out.print("<script>if(!truthBeTold)document.location.href ='../eCommon/html/blank.html';parent.frames(2).document.location.href = '../eCommon/html/blank.html';parent.frames(1).document.location.href = '../eCommon/html/blank.html';parent.frames(3).document.location.href = '../eCommon/html/blank.html';</script>");
								
							}
//							out.print("<script>if(!truthBeTold)parent.window.close();</script>");

							out.print("<script>if(truthBeTold) parent.frames(2).RegisterMoreReferral(\""+encounterId+"\",\""+patientid+"\",\""+discharge_indicator+"\");</script>");
								//RegisterMoreReferral(encounterId,patientid,discharge_indicator, response);
							
							message.clear();
						}
						
					}*/
					
				}
				else 
				{
					if(is_ca_yn.equals("Y")) // From CA
					{
						out.println("alert('"+error+"');document.location.href ='../eCommon/html/blank.html';parent.frames[2].document.location.href = '../eCommon/html/blank.html';parent.frames[1].document.location.href = '../eCommon/html/blank.html';parent.frames[3].document.location.href = '../eCommon/html/blank.html';");
					}
					else 
					{
						out.println("alert('"+error+"');parent.window.close();");	
					}
				}
				paramHashTab.clear();
				results.clear();
			}
			else if(proceed.equals("Fail"))
			{
				out.println("alert('"+msg1+"');parent.frames[3].document.forms[0].record.disabled=false;");	
			}

		} catch ( Exception e ) 
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

	/// Added by Bangarraju k on 6 Marc 2009

	private void doOnlineReports(String encounter_id, String nursingunitcode, String patientid, String facilityId,PrintWriter out,String called_ca,String rec_exists,String discharge_ind,String sStyle) throws ServletException, IOException, SQLException
	{
		StringBuffer htmlFor				= new StringBuffer();
		StringBuffer sqlBuffer				= new StringBuffer();
		
		sqlBuffer.append("select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, ");
		sqlBuffer.append("a.module_id from ip_online_report a, sm_report b  where  a.module_id = 'IP' ");
		sqlBuffer.append("and b.internal_request_yn='Y' and a.facility_id='");
		sqlBuffer.append(facilityId);
		sqlBuffer.append("' and a.PRINT_ON_DISCH_ADV_YN='Y' and b.report_id ='IPBINDIS' and a.nursing_unit_code ='");
		sqlBuffer.append(nursingunitcode);
		sqlBuffer.append("' and a.report_id = b.report_id ");
		
		String locn_type = "N";
		String reportParamNames = "p_encounter_id,p_clinic_code,p_patient_id,p_facilityId";
		String reportParamValues = ""+encounter_id+","+nursingunitcode+","+patientid+","+facilityId+"";
		htmlFor.append(" var dialogHeight    = '80vh' ;");
		htmlFor.append(" var dialogWidth = '80vw' ;");
		htmlFor.append("var dialogTop = 5;" );
		htmlFor.append("  var arguments =   ''; ");
		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=PRE_DIS_ADVICE&step=1&sqlString="+java.net.URLEncoder.encode(sqlBuffer.toString())+"&EncounterId="+encounter_id+"&dest_locn_type="+locn_type+"&dest_locn_code="+nursingunitcode+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
				
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append("  retVal            = await   window.showModalDialog(getUrl,arguments,features); ");
		if(called_ca.equals("Y") && rec_exists.equals("false")) // From CA
		{
			/*Tuesday, February 09, 2010 , IN019055,to invoke MDR if adaptive menu not defined*/
			if(discharge_ind.equals("DS"))
				htmlFor.append("parent.frames[2].invokeMaintainDeathRegister();");
			else
				htmlFor.append("document.location.href ='../eCommon/html/blank.html';parent.frames[2].document.location.href = '../eCommon/html/blank.html';parent.frames[1].document.location.href = '../eCommon/html/blank.html';parent.frames[3].document.location.href = '../eCommon/html/blank.html';");
		}
		else 
		{
			if(rec_exists.equals("false"))
			{
				/*Tuesday, February 09, 2010 , IN019055,to invoke MDR if adaptive menu not defined*/
				if(discharge_ind.equals("DS"))
					htmlFor.append("parent.frames[2].invokeMaintainDeathRegister();");
				else
					htmlFor.append("parent.window.close();");	
			}
		}
		out.println(htmlFor.toString());
	}

	/// Added by Sridhar R on 6 Sep 2004
	/// This function will open a modal window which alows the user to Register multiple referrals...
	private void RegisterMoreReferral(String encounter_id, String patient_id, String discharge_indicator, HttpServletResponse response,String sStyle) throws ServletException, IOException
	{
		String Transaction_type = "DA" ;
		PrintWriter				out = null;
		try
		{
			out = response.getWriter();		
			StringBuffer htmlFor = new StringBuffer();
			htmlFor.append(" var dialogHeight	= '90vh';");
			htmlFor.append(" var dialogWidth	= '90vw';");
			htmlFor.append(" var dialogTop		= '2';");
			htmlFor.append(" var arguments		= ''  ;");
			htmlFor.append(" var getUrl = '../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter_id+"&Module="+Transaction_type+"&patient_id="+patient_id+"&Transaction_type="+Transaction_type+"&discharge_indicator="+discharge_indicator+" ';");
			htmlFor.append(" var features = 'dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+'; status=no;' ;");
			htmlFor.append("  retVal = await window.showModalDialog(getUrl,arguments,features);");
			out.println(htmlFor.toString());
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}//E.O.CLass 
