/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;
import java.net.URLDecoder;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.util.Hashtable;
import java.util.HashMap;
import javax.servlet.http.*;
import javax.rmi.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import com.ehis.util.*;
//import com.ehis.util.DateUtils;
import eIP.IPAdmitPatient.* ;
import eBL.BLInsuranceImageBean;
import com.ehis.persist.PersistenceHelper;
/*************Package Billing Changes**********start********/
import eBL.*;	
import com.ehis.persist.*;
import java.util.*;
import eCommon.Common.*;
/*************Package Billing Changes**********end********/ 

public class AdmitPatientServlet extends javax.servlet.http.HttpServlet
{
	String errorPage="error.jsp";

	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public  void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{   
		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rset			= null;
		req.setCharacterEncoding("UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		res.setContentType("text/html;charset=UTF-8");
		java.util.Properties p	= null;
		PrintWriter	out			= null;
		out						= res.getWriter();
		HttpSession session		= null;
		session					= req.getSession(false);
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale			= "";
		locale					= p.getProperty("LOCALE");
		String sStyle			= "";	
		sStyle					= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String facilityId		= "";
		facilityId				= (String)session.getValue("facility_id") ;
		if(facilityId == null || facilityId.equals("") || facilityId=="")
			facilityId		= "";
		String	client_ip_address = "";
		client_ip_address		= p.getProperty("client_ip_address");
		String	fid				= "";
		fid                     = p.getProperty( "login_user" ) ;
		String	req_no			= "";
		req_no					= req.getParameter("req_no");
		if (req_no == null) req_no = "";
		String perm_fs_locn		= "";
		perm_fs_locn			= req.getParameter("perm_fs_locn");
		if (perm_fs_locn == null) perm_fs_locn = "";

		String patientid		= "";
		String practitioner		= "";
		String attd_practitioner		= "";
		String speciality		= "";
		String bedclass			= "";
		//String modified_bed_type		= "";
		String nursingunit		= "";
		String bedno			= "";
		String roomno			= "";
		String mod_id			= "";
		String age				= "";
		String patientgender	= "";
		String dateofbirth		= "";
		String pat_ser_grp_code	= "";
		String error			= "";
		String pat_flag			= "N";
		String repParamNames	= "" ;
		String repParamValues	= "" ;
		String admissiondate	= "" ;
		boolean proceed			= true;
		String from_adv_bed_mgmt	= checkForNull(req.getParameter("from_adv_bed_mgmt"),"N");
		
		/*Below line Added for this CRF Bru-HIMS-CRF-261*/
		String quick_admission_type= checkForNull(req.getParameter("quick_admission_type"));
		String quick_adm=checkForNull(req.getParameter("quick_adm"));		
		//End this CRF Bru-HIMS-CRF-261
		
		//Added By Santhosh for PMG2023-MOHE-CRF-0001
		boolean isDepositAmountAppl = false;
		// code changed by Vedesh A D for Edge Conversion
		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
		out.println("async function callAdmitPatientHTML() { ");
		try {
			con						= ConnectionManager.getConnection(req);
			isDepositAmountAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","GET_DEPOSIT_AMOUNT");
			errorPage = isDepositAmountAppl ? "errorDeposit.jsp" : errorPage;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception on getConnection && isSiteSpecific=============="+e.toString());
		} finally {
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
		//End
		
		
		if(req_no == "")
		{
			try
			{
				mod_id							= checkForNull(req.getParameter("call_func"));

				//operation generate file exists then prompts for file generation
	
					facilityId					=	convertString(facilityId) ;
					patientid					=	convertString(checkForNull(req.getParameter("patient_id")));
					//patientid					=	convertString(patientid) ;
					practitioner				=	convertString(checkForNull(req.getParameter("practid"))) ;
					attd_practitioner			=	convertString(checkForNull(req.getParameter("att_practid")));
					speciality					=	convertString(checkForNull(req.getParameter("Splcode"))) ;
					bedclass					=	convertString(checkForNull(req.getParameter("Bedcode"))) ;
					nursingunit					=	convertString(checkForNull(req.getParameter("nursing_unit"))) ;
					bedno						=	convertString(checkForNull(req.getParameter("r_bed_no"))) ;
					roomno						=	convertString(checkForNull(req.getParameter("room_no"))) ;
					try
					{
						con = ConnectionManager.getConnection(req);
						StringBuffer ageSql = new StringBuffer();
						
						
						
						
						//ageSql.append("select res_area_code, res_town_code, res_town_desc, to_char(date_of_birth,'dd/mm/rrrr') date_of_birth , sex, get_age(date_of_birth) age from MP_PATIENT where patient_id = '"+patientid+"'");
						/*IP-ICN-IN009476_FileCreation 4/3/2009 pat_ser_grp_code added*/
						ageSql.append("select res_area_code, res_town_code, res_town_desc, to_char(date_of_birth,'dd/mm/rrrr') date_of_birth , sex, get_age(date_of_birth) age,pat_ser_grp_code from MP_PATIENT where patient_id = '"+patientid+"'");
						pstmt = con.prepareStatement(ageSql.toString());
						rset = pstmt.executeQuery();

						if (rset != null && rset.next())
						{
							age					= checkForNull(rset.getString("age"));
							patientgender		= checkForNull(rset.getString("sex"));
							dateofbirth			= checkForNull(rset.getString("date_of_birth"));
							//res_area_code		= checkForNull(rset.getString("res_area_code"));
							//res_town_code		= checkForNull(rset.getString("res_town_code"));
							//res_town_desc		= checkForNull(rset.getString("res_town_desc"));
							pat_ser_grp_code	= checkForNull(rset.getString("pat_ser_grp_code"));
						}

						if(rset != null) rset.close();
						if(pstmt != null) pstmt.close();
					}catch(Exception getAge)
					{
						proceed = false;
						getAge.printStackTrace();
					}
					finally
					{
						try
						{
							if(rset != null) rset.close();
							if(pstmt != null) pstmt.close();
							if(con != null)  ConnectionManager.returnConnection(con,req);
						}
						catch (Exception e)
						{
						e.printStackTrace();
						}
						
					}
					java.util.HashMap ret	=   ValidateIPAdmitPatient(res,	p, facilityId, practitioner, speciality, nursingunit, roomno, patientid, bedno, bedclass, attd_practitioner, req, age, patientgender, dateofbirth,admissiondate );

					boolean retval			= ((Boolean)ret.get("status")).booleanValue();
					error					= (String) ret.get("error") ;
					String blocked_yn		=(String)ret.get("blocked_yn");
					String appl_patient_class	=(String)ret.get("appl_patient_class");
					String nursingunittype	=(String)ret.get("nursingunittype");
					String pseudo_bed_yn	=(String)ret.get("pseudo_bed_yn");
					if(retval)
					{  
					   IPAdmitPatient(req, res, blocked_yn,age,patientgender, dateofbirth,appl_patient_class,nursingunittype,pseudo_bed_yn,pat_ser_grp_code,mod_id);
						  
					}
					else
					{
						if(from_adv_bed_mgmt.equals("N")){ 
							System.err.println("hi in new issue 1=============================================================>");
							out.println("parent.frames[2].location.href ='../eCommon/jsp/"+errorPage+"?err_num=" + java.net.URLEncoder.encode(error,"UTF-8")+"';");
						}else{
							out.println("alert('"+error+"');window.close();");
						}

					}
					ret.clear();
				

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con != null)  ConnectionManager.returnConnection(con,req);
			}
		}else
		{
			String eid					= ""; 
			String callfunc				= "";
			String wristBandLbl			= "";
			try
			{
				error					= req.getParameter("error");
				if (error == null) error = "";
				eid						= req.getParameter("encounterId");
				if (eid == null) eid = "";
				patientid				= req.getParameter("patient_id");
				if (patientid == null) patientid = "";
				nursingunit				= req.getParameter("nursing_unit");
				if (nursingunit == null) nursingunit = "";
				age				= req.getParameter("age");
				if (age == null) age = "";
				callfunc		= req.getParameter("callfunc");
				if(callfunc == null) callfunc = "";
				String p_call_from = "WALKIN";
				int n_Age = 0;
				try
				{
					if(age.indexOf("Y")>0)
					{
						age = age.substring(0,age.indexOf("Y"));
						n_Age = Integer.parseInt(age);
						if(n_Age <= 2)
							wristBandLbl = "IPBWBLBL";
						else
							wristBandLbl = "IPBINWBL";
					}
					else
					{
						n_Age = Integer.parseInt(age);
						if(n_Age <= 2)
							wristBandLbl = "IPBWBLBL";
						else
							wristBandLbl = "IPBINWBL";
					}
				}
				catch(Exception repEx)
				{
					repEx.printStackTrace();
				}
				StringBuffer repSQL	= new StringBuffer();
				if(req_no.equals("") || req_no.equals("N"))
				{


					if(pat_flag.equals("Y")) {
					repSQL.append(" SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report_lang_vw b WHERE a.module_id = 'IP' AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursingunit+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') UNION SELECT report_id, report_desc, no_of_copies, module_id FROM (SELECT DISTINCT a.report_id, b.report_desc, 1 no_of_copies, b.module_id, 1 orderby FROM mp_online_reports a, sm_report_lang_vw b, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' AND b.language_id = '"+locale+"' AND a.print_reqd_yn = 'Y' AND b.report_id = a.report_id AND a.report_id = c.report_id(+) AND NVL (c.facility_id, '"+facilityId+"') = '"+facilityId+"' AND a.report_id IN ('MPBIDLBL')) ORDER BY 2 ");
					} else {
						repSQL.append(" SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report_lang_vw b WHERE a.module_id = 'IP' AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursingunit+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') ORDER BY 2 ");
					}				

					repParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
					repParamValues = ""+eid+","+nursingunit+",N,"+patientid+"";
				} else {
					if(pat_flag.equals("Y")) {
					repSQL.append(" SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report_lang_vw b WHERE a.module_id IN ('IP', 'FM') AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursingunit+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') UNION SELECT report_id, report_desc, no_of_copies, module_id FROM (SELECT DISTINCT a.report_id, b.report_desc, 1 no_of_copies, b.module_id, 1 orderby FROM mp_online_reports a, sm_report_lang_vw b, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' AND b.language_id = '"+locale+"' AND a.print_reqd_yn = 'Y' AND b.report_id = a.report_id AND a.report_id = c.report_id(+) AND NVL (c.facility_id, '"+facilityId+"') = '"+facilityId+"' AND a.report_id IN ('MPBIDLBL')) ORDER BY 2 ");
					} else {
						repSQL.append(" SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report_lang_vw b WHERE a.module_id IN ('IP', 'FM') AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursingunit+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') ORDER BY 2 ");
					}
					repParamNames = "p_encounter_id,p_call_from,p_clinic_code,p_clinic_type,p_patient_id,p_req_no";
					repParamValues = ""+eid+","+p_call_from+","+nursingunit+",N,"+patientid+","+req_no+"";
				}
				HashMap hashResults = new HashMap();
				hashResults.put("reportParamNames",repParamNames);
				hashResults.put("reportParamValues",repParamValues);
				hashResults.put("cliniccode",nursingunit);
				hashResults.put("clinictype","N");
				hashResults.put("callfunc",callfunc);
				hashResults.put("req",req);
				hashResults.put("perm_fs_locn_code",perm_fs_locn);
				hashResults.put("sqlString",repSQL.toString());
				doOnlineReports(req,res,error,eid,hashResults);
				hashResults.clear();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		out.println("} callAdmitPatientHTML();</script></body></html>");	
	}

	
	/**
	 * This method is used to insert the values into db through EJB
	 * @param1	:	HttpServletRequest request object
	 * @param2	:	HttpServletResponse response object
	 * @return	:   void
	 */
	private void IPAdmitPatient(HttpServletRequest req, HttpServletResponse res, String blocked_YN,String age,String patientgender,String dateofbirth,String appl_patient_class,String nursingunittype,String pseudo_bed_yn,String pat_ser_grp_code,String mod_id)throws java.io.IOException
	{   
		Connection con				= null;
		java.util.Properties p		= null;
		PrintWriter	out				= null;
		HttpSession session			= null;
		session           	        = req.getSession(false) ;
		out							= res.getWriter();
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		String sStyle				= "";	
		sStyle						= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		boolean proceed				= true;
		String function_id			= "";
		String facilityId			= "";
		facilityId					= (String)session.getValue("facility_id") ;
		String bookingrefno			= "";
		String patientid			= "";
		String sourcetype			= "";
		String source				= "";
		String refpractitioner		= "";
		String admissiondate		= "";
		String admissiontype		= "";
		String circumstanceofinjury	= "";
		String chiefcomplaint		= "";
		String otdatetime			= "";
		String practitioner			= "";
		String attd_practitioner	= "";
		String speciality			= "";
		String patienttype			= "";
		String bedclass				= "";
		String bedtypecode			= "";
		String nursingunit			= "";
		String service				= "";
		String sub_service			= "";
		String bedno				= "";
		String roomno				= "";
		String ambulatorystatus		= "";
		String modeofarrival		= "";
		String name					= "";
		String address1				= "";
		String address2				= "";
		String address3				= "";
		String address4				= "";
		String postalcode			= "";
		String telno				= "";
		String mvregnno				= "";
		String emergencydetail		= "";
		String admtypeind			= "";
		String ancillaryyn			= "";
		String patientclass			= "";
		String refpractitionername	= "";
		String contact_details		= "";
		String client_ip_address	= "";
		client_ip_address			= p.getProperty("client_ip_address");
		String locale				= "";
		locale						= p.getProperty("LOCALE");
		
		
		String billing_interfaced	= "";
		String continue_as_mlc_yn	= "";
		String isBlInstalled		= "";
		String billing_group		= "";
		String patient_class		= "";
		String bkg_type				= "";
		String pat_check_in_allowed_yn	= "N";
		String d_referral_id		= "";
		String d_clinic_code		= "";
		String bed_assigned_for_nb_yn= "";
		String baby_flag			= "";
		String confirm_flag			= "";
		String admission_remarks	= "";
		String error				= "";
		String eid					= "";
		//String	pat_flag			= checkForNull(req.getParameter("pat_flag"),"N");
		String p_privl_type_code    = "";
		String p_expiry_date	    = "";
		String p_card_id		    = "";
		String p_hosp_sub		    = "";
		String p_hosp_main		    = "";
		String res_tel_no			= "";
		String oth_contact_no		= "";
		String email_id				= "";
		String postal_code			= "";
		String country_code			= "";
		int   dailycharge			= 0;
		String res_addr_line1		= "";
		String res_addr_line2		= "";
		String res_addr_line3		= "";
		String res_addr_line4		= "";
		String res_town_code		= "";
		String res_area_code		= "";
		String res_region_code		= "";

		String mail_addr_line1		= "";
		String mail_addr_line2		= "";
		String mail_addr_line3		= "";
		String mail_addr_line4		= "";
		String mail_town_code		= "";
		String mail_area_code		= "";
		String mail_region_code		= "";
		String mail_postal_code		= "";
		String mail_country_code	= "";
		
		String referralid			= "";
		String expecteddischargedate			= "";
		String pkg_bill_type		= "";
		String insTrackDtlsExists	= "";
		String team_id				= "";
		String modified_bed_type	= "";
		int pkg_bill_no				= 0;
		String err					= "";
		String err1					= "";
		String error_value			= "0" ;
		String deposit_amount		= "";
		String admn_dep_coll_reqd_yn= "";
		String callfunc				= "";
		String chiefComplaintDesc 	= "";
		String from_adv_bed_mgmt	= checkForNull(req.getParameter("from_adv_bed_mgmt"),"N");

		String booking_bed_no		= "";//Added by Rameswar for PMG2016-CRF-0002 [IN:061508] on 23rd Aug 16

		/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 Start*/
		String bl_adm_remarks	= checkForNull(req.getParameter("bl_adm_remarks"));
		String bl_bed_request	= checkForNull(req.getParameter("bl_bed_request"));
		String bl_bed_type_code	= checkForNull(req.getParameter("bl_bed_type_code"));
		/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 End*/


		
	//Below line added for this CRF GDOH-CRF-0129
	    String assigncare_loctype_ind="";
	    String assigncare_locacode="";	
    //End GDOH-CRF-0129
		
		//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
		String admission_form_codes		= "";

		String admission_approval_details = ""; //Added by Suji Keerthi for MMS-DM-CRF-0191 US001
		
		String form60_YN=""; //Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= "";
		String altAddrLine2		= "";
		String altAddrLine3		= "";
		String altAddrLine4		= "";
		String altAreaCode		= "";
		String altTownCode		= "";
		String altPostalCode	= "";
		String altRegionCode	= "";
		String altCountryCode	= "";
		/*End*/

		Boolean isInvokeUploadDocAppl = false;//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11

		try
		{
			con						= ConnectionManager.getConnection(req);

			isInvokeUploadDocAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11

			String episodetype		= "I";
			String episodestatus	= "0";
		    function_id				= checkForNull(req.getParameter("function_id"));
			if(function_id.equals("ADMIT_PAT"))
				function_id			= "ADMISSION";

			int visitid				= 0;
			
				facilityId				=	convertString(facilityId) ;
				bookingrefno			=	convertString(checkForNull(req.getParameter("booking_ref_no"))) ;
				patientid				=	convertString(checkForNull(req.getParameter("patient_id"))) ;
				eid						=	convertString(checkForNull(req.getParameter("encounter_id")));
				sourcetype				=	convertString(checkForNull(req.getParameter("source_type"))) ;
				source					=	convertString(checkForNull(req.getParameter("source"))) ;
				refpractitioner			=	convertString(checkForNull(req.getParameter("practitioner"))) ;
				admissiondate			=	checkForNull(req.getParameter("visit_adm_date_time")) ;
				admissiondate           =	convertString(DateUtils.convertDate(admissiondate,"DMYHM",locale,"en"));
				admissiontype			=	convertString(checkForNull(req.getParameter("visit_adm_type"))) ;
				circumstanceofinjury	=	convertString(checkForNull(req.getParameter("circumstance_of_injury"))) ;
				chiefcomplaint			=	convertString(checkForNull(req.getParameter("complaintcode"))) ;
				chiefComplaintDesc		= 	convertString(checkForNull(req.getParameter("chief_complaint"))) ;
				//System.out.println("AdmitPatientServlet IPAdmitPatient chiefComplaintDesc:"+chiefComplaintDesc);
				otdatetime              =	checkForNull(req.getParameter("ot_date_time"));
				otdatetime	            =	DateUtils.convertDate(otdatetime,"DMYHM",locale,"en");
				otdatetime				=	convertString(otdatetime) ;
				practitioner			=	convertString(checkForNull(req.getParameter("practid"))) ;
				attd_practitioner		=	convertString(checkForNull(req.getParameter("att_practid")));
				speciality				=	convertString(checkForNull(req.getParameter("Splcode"))) ;
				patienttype				=	convertString(checkForNull(req.getParameter("PatCode"))) ;
				bedclass				=	convertString(checkForNull(req.getParameter("Bedcode"))) ;
				bedtypecode				=	convertString(checkForNull(req.getParameter("bed_type"))) ;
				modified_bed_type		=	convertString(checkForNull(req.getParameter("modified_bed_type")));
				if(modified_bed_type.equals("") || modified_bed_type == null)
				modified_bed_type       = bedtypecode;
				nursingunit				=	convertString(checkForNull(req.getParameter("nursing_unit"))) ;
				service					=	convertString(checkForNull(req.getParameter("service"))) ;
				sub_service				=	convertString(checkForNull(req.getParameter("sub_service"))) ;
				bedno					=	convertString(checkForNull(req.getParameter("r_bed_no"))) ;
				roomno					=	convertString(checkForNull(req.getParameter("room_no"))) ;
				ambulatorystatus		=	convertString(checkForNull(req.getParameter("ambulatory_status"))) ;
				modeofarrival			=	convertString(checkForNull(req.getParameter("arrival_code"))) ;
				name					=	convertString(checkForNull(req.getParameter("escort_name"))) ;
				
				booking_bed_no			=	convertString(checkForNull(req.getParameter("booking_bed_no"))) ;//Added by Rameswar for PMG2016-CRF-0002 [IN:061508] on 23rd Aug 16
				/*remove the convertString method by Senthil on 14-Sept-2011 for this Incident[IN28723]*/				 address1				 =	 checkForNull(req.getParameter("escort_add_ln1")) ;
				address2				=	checkForNull(req.getParameter("escort_add_ln2")) ;
				address3				=	checkForNull(req.getParameter("escort_add_ln3")) ;
				address4				=	checkForNull(req.getParameter("escort_add_ln4")) ;
				
				postalcode				=	convertString(checkForNull(req.getParameter("escort_add_postal_code"))) ;
				telno					=	convertString(checkForNull(req.getParameter("escort_tel_num"))) ;
				mvregnno				=	convertString(checkForNull(req.getParameter("escort_mv_regn_no"))) ;
				emergencydetail			=	convertString(checkForNull(req.getParameter("emergency_detail"))) ;
				admtypeind				=	convertString(checkForNull(req.getParameter("adm_type_ind"))) ;
				ancillaryyn				=	convertString(checkForNull(req.getParameter("ancillary_yn"),"N")) ;
				patientclass			=	convertString(checkForNull(req.getParameter("patient_class_id"))) ;
				refpractitionername		=	convertString(checkForNull(req.getParameter("ref_practitioner_name"))) ;
				/*remove the convertString method by Senthil on 14-Sept-2011 for this Incident[IN28723]*/				 res_tel_no				=	checkForNull(req.getParameter("contact1_no"));
				oth_contact_no			=	checkForNull(req.getParameter("contact2_no"));
				email_id				=	checkForNull(req.getParameter("email"));
				
				postal_code				=	convertString(checkForNull(req.getParameter("postal_code")));
				country_code			=	convertString(checkForNull(req.getParameter("country_code")));
				/*remove the convertString method by Senthil on 14-Sept-2011  for this Incident[IN28723]*/
			    res_addr_line1			=	checkForNull(req.getParameter("addr_line1"));
				res_addr_line2			=	checkForNull(req.getParameter("addr_line2"));
				res_addr_line3			=	checkForNull(req.getParameter("addr_line3"));
				res_addr_line4			=	checkForNull(req.getParameter("addr_line4"));
				
				res_town_code			=	convertString(checkForNull(req.getParameter("res_town_code")));
				res_area_code           =	convertString(checkForNull(req.getParameter("res_area_code")));
				res_region_code         =	convertString(checkForNull(req.getParameter("region_code")));
				/*remove the convertString method by Senthil on 14-Sept-2011 for this Incident[IN28723]*/
				mail_addr_line1         =	checkForNull(req.getParameter("mail_addr_line1"));
				mail_addr_line2         =	checkForNull(req.getParameter("mail_addr_line2"));
				mail_addr_line3         =	checkForNull(req.getParameter("mail_addr_line3"));
				mail_addr_line4         =	checkForNull(req.getParameter("mail_addr_line4"));
				
				mail_town_code          =	convertString(checkForNull(req.getParameter("mail_res_town_code")));
				mail_area_code          =	convertString(checkForNull(req.getParameter("mail_res_area_code")));
				mail_region_code        =	convertString(checkForNull(req.getParameter("mail_region_code")));
				mail_postal_code		=	convertString(checkForNull(req.getParameter("mail_postal_code")));
				mail_country_code		=	convertString(checkForNull(req.getParameter("mail_country_code")));
				contact_details			=	convertString(checkForNull(req.getParameter("contact_details")));
				client_ip_address		=	convertString(client_ip_address) ;
				billing_interfaced		=	convertString(checkForNull(req.getParameter("isBlInterfaced"))) ;
				continue_as_mlc_yn		=	convertString(checkForNull(req.getParameter("continue_as_mlc_yn"),"N")) ;
				isBlInstalled			=	convertString(checkForNull(req.getParameter("isBlInstalled"))) ;
				episodetype				=	convertString(episodetype) ;
				billing_group			=	convertString(checkForNull(req.getParameter("billing_group"))) ;
				
				/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
				altAddrLine1	= checkForNull(req.getParameter("alt_addr_line1"));
				altAddrLine2	= checkForNull(req.getParameter("alt_addr_line2"));
				altAddrLine3	= checkForNull(req.getParameter("alt_addr_line3"));
				altAddrLine4	= checkForNull(req.getParameter("alt_addr_line4"));
				altAreaCode		= checkForNull(req.getParameter("alt_area_code"));
				altTownCode		= checkForNull(req.getParameter("alt_town_code"));
				altPostalCode	= checkForNull(req.getParameter("alt_postal_code"));
				altRegionCode	= checkForNull(req.getParameter("alt_region_code"));
				altCountryCode	= checkForNull(req.getParameter("alt_country_code"));
				/*End*/
				//Below line added for this CRF GDOH-CRF-0129
				assigncare_loctype_ind=checkForNull(req.getParameter("assigncare_loctype_ind"));
				assigncare_locacode=checkForNull(req.getParameter("assigncare_locacode"));		
		       //End GDOH-CRF-0129
				
				//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
				admission_form_codes = checkForNull(req.getParameter("PFValue"));
				admission_approval_details = checkForNull(req.getParameter("admission_approval_details")); //Added by Suji Keerthi for MMS-DM-CRF-0191 US001

			   //Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
				form60_YN			=  req.getParameter("form60_YN");
				if((form60_YN==null) || (form60_YN.equals("null")) || (form60_YN=="") || (form60_YN.equals(""))) 	
					form60_YN		= "";
				
	/*
				billing_class			=	convertString(billing_class) ;
				employer_code			=	convertString(employer_code) ;
				setlmt_ind				=	convertString(setlmt_ind) ;
				credit_doc_ref_desc		=	convertString(credit_doc_ref_desc) ;
				cust_code				=	convertString(cust_code) ;
				slmt_type_code			=	convertString(slmt_type_code) ;
				slmt_doc_ref_desc		=	convertString(slmt_doc_ref_desc) ;
				slmt_doc_remarks		=	convertString(slmt_doc_remarks) ;
				remarks					=	convertString(remarks) ;
				user_id					=	convertString(user_id);
				policy_type				=	convertString(policy_type) ;
				policy_no				=	convertString(policy_no) ;
				non_insur_blng_grp		=	convertString(non_insur_blng_grp) ;
				cust_4					=	convertString(cust_4) ;
	*/
				episodetype				=	convertString(episodetype) ;
				pkg_bill_type			=	convertString(checkForNull(req.getParameter("pkg_bill_type"))) ;
	//			credit_auth_ref			=	convertString(credit_auth_ref) ;
				episodestatus			=	convertString(episodestatus) ;
				practitioner			=	convertString(checkForNull(req.getParameter("practid"))) ;
				insTrackDtlsExists		=	convertString(checkForNull(req.getParameter("insTrackDtlsExists"))) ;
				expecteddischargedate   =	checkForNull(req.getParameter("expecteddischargedate"));
				expecteddischargedate   = convertString(DateUtils.convertDate(expecteddischargedate,"DMYHM",locale,"en"));

				referralid				=	convertString(checkForNull(req.getParameter("referral_id"))) ;
	/*
				upd_fin_dtls			=	convertString(upd_fin_dtls) ;
				cred_st_dt				=	convertString(cred_st_dt) ;
				gl_holder_name			=	convertString(gl_holder_name) ;
				gl_holder_reln			=	convertString(gl_holder_reln) ;
	*/
				patient_class			=	convertString(checkForNull(req.getParameter("patient_class_id"))) ;
				if(patient_class.equals("DC"))
					episodetype = "D";
				bkg_type				=	convertString(checkForNull(req.getParameter("bkg_type"))) ;
				if(bkg_type.equals("D"))
					episodetype = "D";
				pat_check_in_allowed_yn = convertString(checkForNull(req.getParameter("pat_check_in_allowed_yn")));
				d_referral_id			= convertString(checkForNull(req.getParameter("d_referral_id")));
				d_clinic_code			= convertString(checkForNull(req.getParameter("d_clinic_code")));
				bed_assigned_for_nb_yn  = convertString(checkForNull(req.getParameter("bed_assigned_for_nb_yn")));
				baby_flag				= convertString(checkForNull(req.getParameter("baby_flag")));
				confirm_flag			= convertString(checkForNull(req.getParameter("confirm_flag")));
				admission_remarks		= convertString(checkForNull(req.getParameter("admission_remarks")));
				team_id					= convertString(checkForNull(req.getParameter("team_id")));
				modified_bed_type		= convertString(modified_bed_type);
				p_hosp_main				= convertString(checkForNull(req.getParameter("p_hosp_main")));
				p_hosp_sub				= convertString(checkForNull(req.getParameter("p_hosp_sub")));
				p_card_id				= convertString(checkForNull(req.getParameter("p_card_id")));
				p_expiry_date			= convertString(checkForNull(req.getParameter("p_expiry_date")));
				p_privl_type_code		= convertString(checkForNull(req.getParameter("p_privl_type_code")));
				callfunc                = checkForNull(req.getParameter("call_func"));
				try
				{
					if(!( req.getParameter("pkg_bill_no")==null || req.getParameter("pkg_bill_no").equals("") ))
						pkg_bill_no		= Integer.parseInt(req.getParameter("pkg_bill_no"));
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					//return false;
				}
				//pkg_bill_no				= convertString(pkg_bill_no);

			java.util.Hashtable enc_message = MessageManager.getMessage(locale,"ENCOUNTER_ID","IP");
			String enc_msg				= (String) enc_message.get("message");

			Statement entitle_stmt			= null;
			PreparedStatement entitle_pstmt = null;
			ResultSet entitle_rs			= null;
			String status					= "0";
			String msg						= "";
			String entitlement_by_pat_cat_yn = "";
			//added for PE By Sudhakar
			String file_creation			= "N" ;
			String maintain_doc_or_file		= "" ;
			String fm_install_yn			= "N" ;
			String file_type_appl_yn		= "N";
			String single_or_multi_files_ind= "S";
			String p_seperate_file_no_yn	= "N";
			String upt_contact_dtls_oa_yn="";//added changes for HSA-CRF-0226 [IN:050599]
			try
			{


				entitle_stmt = con.createStatement();
				//Changed for PE By Sudhakar Starts
				entitle_rs = entitle_stmt.executeQuery("SELECT a.entitlement_by_pat_cat_yn,a.maintain_doc_or_file,a.create_file_at_admission,a.create_file_at_dc_admission_yn,file_type_appl_yn ,single_or_multi_files_ind,separate_file_no_yn,(SELECT DECODE(COUNT(*),'0','N','Y') FROM SM_MODULE WHERE MODULE_ID = 'FM' AND INSTALL_YN = 'Y' ) fm_install_yn,upt_contact_dtls_oa_yn FROM MP_PARAM a WHERE a.module_id = 'MP'") ;
				if(entitle_rs.next()){
					fm_install_yn				= entitle_rs.getString("fm_install_yn");
					entitlement_by_pat_cat_yn	= entitle_rs.getString("entitlement_by_pat_cat_yn");
					maintain_doc_or_file		= checkForNull(entitle_rs.getString("maintain_doc_or_file"));
					file_type_appl_yn			= entitle_rs.getString("file_type_appl_yn");
					single_or_multi_files_ind	= entitle_rs.getString("single_or_multi_files_ind");
					p_seperate_file_no_yn		= entitle_rs.getString("separate_file_no_yn");
					upt_contact_dtls_oa_yn      =entitle_rs.getString("upt_contact_dtls_oa_yn");//added changes for HSA-CRF-0226 [IN:050599]
					if (patient_class.equals("IP")){
						file_creation			= checkForNull(entitle_rs.getString("create_file_at_admission"));
					}else{
						file_creation			= checkForNull(entitle_rs.getString("create_file_at_dc_admission_yn"));
					}
				}
				if(file_creation.equals("")){
					file_creation				= "N" ;
				}
				//Changed for PE By Sudhakar Ends
				if(entitle_rs != null) entitle_rs.close();
				if(entitle_stmt != null) entitle_stmt.close();
				if(entitlement_by_pat_cat_yn.equals("Y"))
				{
					entitle_pstmt = con.prepareStatement(" select MP_ENTITLEMENT_VALIDATION(?,to_char(to_date(?,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy'),?,?,?,?,?,?) from dual");
					entitle_pstmt.setString(1,patientid);
					entitle_pstmt.setString(2,admissiondate);
					entitle_pstmt.setString(3,facilityId);
					entitle_pstmt.setString(4,"N");
					entitle_pstmt.setString(5,nursingunit);
					entitle_pstmt.setString(6,patient_class);
					entitle_pstmt.setString(7,speciality);
					entitle_pstmt.setString(8,bedclass);

					entitle_rs=entitle_pstmt.executeQuery();
					if(entitle_rs != null && entitle_rs.next())
					{
						status=entitle_rs.getString(1);
						if(status == null) status="";
					}
					if(entitle_rs != null) entitle_rs.close();
					if(entitle_pstmt != null) entitle_pstmt.close();
				}
			}catch(Exception e)
			{
				proceed=false;
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if(entitle_rs != null) entitle_rs.close();
					if(entitle_stmt != null) entitle_stmt.close();
					if(entitle_pstmt != null) entitle_pstmt.close();
				}
				catch (Exception e)
				{
				e.printStackTrace();
				}
			}
			if(status.equals("0"))
			{
				proceed = true;
			}
			else if(status.equals("1"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
				msg = ((String) message.get("message"));
				if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));

				if(mod_id.equals("PATREG") || from_adv_bed_mgmt.equals("Y"))
				{
					out.println("alert('"+msg+"');parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
				}
				else
				{  
					out.println("alert('"+msg+"');parent.location.href='../eIP/jsp/AdmitPatient.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit Patient&function_type=F&access=NYNNN';");

					out.println("parent.frames[1].frames[0].location.reload();");
					out.println("parent.frames[1].frames[1].location.href='../../eCommon/jsp/blank.jsp';");
					out.println("parent.frames[1].frames[2].location.reload();");
				}
				message.clear();
			}
			else if(status.equals("2"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
				msg = ((String) message.get("message"));
				if(mod_id.equals("PATREG") || from_adv_bed_mgmt.equals("Y"))
				{
					out.println("alert('"+msg+"');parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
				}
				else
				{   
					System.err.println("hi in new issue 2=============================================================>");
					out.println("parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(msg,"UTF-8")+"';");
				}
				message.clear();

			}
			else if(status.equals("3"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
				msg = ((String) message.get("message"));
				message.clear();
				if(mod_id.equals("PATREG") || from_adv_bed_mgmt.equals("Y"))
				{
					out.println("alert('"+msg+"');parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
				}
				else
				{   
					System.err.println("hi in new issue 3=============================================================>");
					out.println("parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(msg,"UTF-8")+"';");
				}
			}
			else if(status.equals("4"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
				msg = ((String) message.get("message"));
				message.clear();

				if(mod_id.equals("PATREG") || from_adv_bed_mgmt.equals("Y"))
				{
					out.println("alert('"+msg+"');parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
				}
				else
				{           
					System.err.println("hi in new issue 4=============================================================>");
				out.println("parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(msg,"UTF-8")+"';");
				}
			}

			if(proceed)
			{
				java.util.HashMap hashData = new java.util.HashMap();
				try
				{
					hashData.put("blocked_yn",blocked_YN);
					hashData.put("facilityId",facilityId);
					hashData.put("bookingrefno",bookingrefno);
					hashData.put("patientid",patientid);
					hashData.put("encounterid",eid);
					hashData.put("sourcetype",sourcetype);
					hashData.put("source",source);
					hashData.put("refpractitioner",refpractitioner);
					hashData.put("admissiondate",admissiondate);
					hashData.put("admissiontype",	admissiontype);
					hashData.put("circumstanceofinjury",circumstanceofinjury);
					hashData.put("chiefcomplaint",chiefcomplaint);
					hashData.put("otdatetime",otdatetime);
					hashData.put("practitioner",practitioner);
					hashData.put("speciality",speciality);
					hashData.put("team_id",team_id);
					hashData.put("patienttype",patienttype);
					hashData.put("bedclass",bedclass);
					hashData.put("bedtype",bedtypecode);
					hashData.put("modified_bed_type",modified_bed_type);
					hashData.put("nursingunit",nursingunit);
					hashData.put("service",service);
					hashData.put("sub_service",sub_service);
					hashData.put("bedno",bedno);
					hashData.put("roomno",roomno);
					hashData.put("dailycharge",dailycharge+"");
					hashData.put("ambulatorystatus",ambulatorystatus);
					hashData.put("modeofarrival",modeofarrival);
					hashData.put("name",name);
					hashData.put("address1",address1);
					hashData.put("address2",address2);
					hashData.put("address3",address3);
					hashData.put("address4",address4);
					hashData.put("postalcode",postalcode);
					hashData.put("telno",telno);
					hashData.put("mvregnno",mvregnno);
					hashData.put("emergencydetail",emergencydetail);
					hashData.put("admtypeind",admtypeind);
					hashData.put("ancillaryyn",ancillaryyn);
					hashData.put("patientclass",patientclass);
					hashData.put("refpractitionername",refpractitionername);
					hashData.put("client_ip_address",client_ip_address);
					hashData.put("billing_interfaced",billing_interfaced);
					hashData.put("continue_as_mlc_yn",continue_as_mlc_yn);
					hashData.put("isBlInstalled",isBlInstalled);
					hashData.put("episodetype",episodetype);
					hashData.put("billing_group",billing_group);
					hashData.put("admission_remarks",admission_remarks);
					
					//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
					hashData.put("admission_form_codes",admission_form_codes);

					hashData.put("admission_approval_details",admission_approval_details); //Added by Suji Keerthi for MMS-DM-CRF-0191 US001
					
					hashData.put("booking_bed_no",booking_bed_no);//Added by Rameswar for PMG2016-CRF-0002 [IN:061508] on 23rd Aug 16
					/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 Start*/
					hashData.put("bl_adm_remarks",bl_adm_remarks);
					hashData.put("bl_bed_request",bl_bed_request);
					hashData.put("bl_bed_type_code",bl_bed_type_code);
		    		/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 End*/                
					//Below line added for this CRF GDOH-CRF-0129
                     hashData.put("assigncare_loctype_ind",assigncare_loctype_ind);
                     hashData.put("assigncare_locacode",assigncare_locacode);
                     //End GDOH-CRF-0129                      
					
					//Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
					hashData.put("form60_YN",form60_YN);

					HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
					if(fin_dtls!=null)
					{
						hashData.put("fin_dtls",(HashMap)fin_dtls);
					}
/*
					hashData.put("billing_class",billing_class);
					hashData.put("employer_code",employer_code);
					hashData.put("setlmt_ind",setlmt_ind);
					hashData.put("credit_doc_ref_desc",credit_doc_ref_desc);
					hashData.put("credit_doc_date",credit_doc_date);
					hashData.put("cust_code",cust_code);
					hashData.put("slmt_type_code",slmt_type_code);
					hashData.put("slmt_doc_ref_desc",slmt_doc_ref_desc );
					hashData.put("slmt_doc_ref_date",slmt_doc_ref_date);
					hashData.put("slmt_doc_remarks",slmt_doc_remarks);
					hashData.put("remarks",remarks);
					hashData.put("user_id",user_id);// MOD#	Added new variable user_id
					hashData.put("policy_type",policy_type);
					hashData.put("policy_no",policy_no);
					hashData.put("policy_expiry_date",policy_expiry_date);
					hashData.put("non_insur_blng_grp",non_insur_blng_grp);
					hashData.put("cust_4",cust_4);
*/

					hashData.put("pkg_bill_type",pkg_bill_type );
					hashData.put("pkg_bill_no",pkg_bill_no+"");
/*
					hashData.put("credit_auth_ref",credit_auth_ref);
					hashData.put("credit_auth_date",credit_auth_date);
					hashData.put("eff_frm_date",eff_frm_date );
					hashData.put("app_amount",app_amount+"");
					hashData.put("app_days",app_days+"");
*/
					hashData.put("episodestatus",episodestatus);
					hashData.put("visitid",visitid+"");
					hashData.put("practitioner",practitioner);
					hashData.put("insTrackDtlsExists",insTrackDtlsExists);
					hashData.put("expecteddischargedate",expecteddischargedate);
					hashData.put("referralid",referralid);
/*
					hashData.put("upd_fin_dtls",upd_fin_dtls);
					hashData.put("annual_income",annual_income);
					hashData.put("family_asset",family_asset);
					hashData.put("no_of_dependants",no_of_dependants);
					hashData.put("resp_for_payment",resp_for_payment);
*/
					hashData.put("contact_details",contact_details);
					hashData.put("res_tel_no",res_tel_no);
					hashData.put("oth_contact_no",oth_contact_no);
					hashData.put("email_id",email_id);
					hashData.put("postal_code",postal_code);
					hashData.put("country_code",country_code);
					hashData.put("res_addr_line1",res_addr_line1);
					hashData.put("res_addr_line2",res_addr_line2);
					hashData.put("res_addr_line3",res_addr_line3);
					hashData.put("res_addr_line4",res_addr_line4);
					hashData.put("res_town_code",res_town_code);
					hashData.put("res_area_code",res_area_code);
					hashData.put("res_region_code",res_region_code);
					hashData.put("mail_addr_line1",mail_addr_line1);
					hashData.put("mail_addr_line2",mail_addr_line2);
					hashData.put("mail_addr_line3",mail_addr_line3);
					hashData.put("mail_addr_line4",mail_addr_line4);
					hashData.put("mail_town_code",mail_town_code);
					hashData.put("mail_area_code",mail_area_code);
					hashData.put("mail_region_code",mail_region_code);
					hashData.put("mail_postal_code",mail_postal_code);
					hashData.put("mail_country_code",mail_country_code);
/*
					hashData.put("cred_st_dt",cred_st_dt);
					hashData.put("gl_holder_name",gl_holder_name);
					hashData.put("gl_holder_reln",gl_holder_reln);
*/
					hashData.put("attd_practitioner",attd_practitioner);
					hashData.put("patient_class",patient_class);
					hashData.put("bkg_type",bkg_type);
					hashData.put("pat_check_in_allowed_yn",pat_check_in_allowed_yn);
					hashData.put("d_referral_id",d_referral_id);
					hashData.put("d_clinic_code",d_clinic_code);
					hashData.put("bed_assigned_for_nb_yn",bed_assigned_for_nb_yn);
					hashData.put("confirm_flag",confirm_flag);
					hashData.put("baby_flag",baby_flag);
					hashData.put("age",age);
					hashData.put("patientgender",patientgender);
					hashData.put("dateofbirth",dateofbirth);
					//hashData.put("res_town_desc",res_town_desc);
					hashData.put("appl_patient_class",appl_patient_class);
					hashData.put("nursingunittype",nursingunittype);
					hashData.put("pseudo_bed_yn",pseudo_bed_yn);
					hashData.put("locale",locale);
					hashData.put("p_hosp_main",p_hosp_main);
					hashData.put("p_hosp_sub",p_hosp_sub);
					hashData.put("p_card_id",p_card_id);
					hashData.put("p_expiry_date",p_expiry_date);
					hashData.put("p_privl_type_code",p_privl_type_code);
					hashData.put("upt_contact_dtls_oa_yn",upt_contact_dtls_oa_yn);//added changes for HSA-CRF-0226 [IN:050599]
					/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
					hashData.put("altAddrLine1",altAddrLine1);
					hashData.put("altAddrLine2",altAddrLine2);
					hashData.put("altAddrLine3",altAddrLine3);
					hashData.put("altAddrLine4",altAddrLine4);
					hashData.put("altAreaCode",altAreaCode);
					hashData.put("altTownCode",altTownCode);
					hashData.put("altPostalCode",altPostalCode);
					hashData.put("altRegionCode",altRegionCode);
					hashData.put("altCountryCode",altCountryCode);
					/*End*/
					/***********Added for Package Billing******start****/
					String bean_id		= "PkgSubsBean" ;
					String bean_name	= "eBL.PkgSubsBean";
					PkgSubsBean bean			= (PkgSubsBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;			

					HashMap  patPackSubsDtls=bean.getPatientPackSubsDtls();		
								
					hashData.put("PACKAGE_DET",(HashMap)patPackSubsDtls);
										
					String bean_id1		= "PkgAssociateBean" ;
					String bean_name1	= "eBL.PkgAssociateBean";
					PkgAssociateBean bean1			= (PkgAssociateBean)PersistenceHelper.getBeanObject( bean_id1, bean_name1, req ) ;			

					ArrayList  patPackAssociateDtls=(ArrayList)bean1.getAssociatedPkgs();		
				
					hashData.put("PACKAGE_ASSOCIATED",patPackAssociateDtls);
					
					String bean_id2		= "PkgApprovalBean" ;
					String bean_name2	= "eBL.PkgApprovalBean";
					PkgApprovalBean bean2			= (PkgApprovalBean)PersistenceHelper.getBeanObject( bean_id2, bean_name2, req ) ;			

					HashMap  patPackApprvDtls=(HashMap)bean2.getPayerDtls();		
				
					hashData.put("PACKAGE_APPROVALS",patPackApprvDtls);
					
					String bean_id3		= "PkgDiscountBean" ;
					String bean_name3	= "eBL.PkgDiscountBean";
					PkgDiscountBean bean3			= (PkgDiscountBean)PersistenceHelper.getBeanObject( bean_id3, bean_name3, req ) ;			

					ArrayList  patPackDiscountDtls=(ArrayList)bean3.getdiscPkgs();
					
					hashData.put("PACKAGE_DISCOUNT",patPackDiscountDtls);
					
					
					/***********Added for Package Billing******end****/
	
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}

				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPAdmitPatient",IPAdmitPatientHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = hashData;
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = hashData.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPAdmitPatient",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
                
				error_value = "0" ;
				error = (String) results.get("error") ;
				System.out.println("error "+ error);
				error = URLDecoder.decode(error, "UTF-8");
				System.out.println("error1 "+ error);
			    // Step 2: Manually replace HTML entities with corresponding symbols
				error = error
			                .replace("&lt;", "<")
			                .replace("&gt;", ">")
			                .replace("&amp;", "&")
			                .replace("&quot;", "\"")
			                .replace("&#39;", "'");
				System.out.println("error2 "+ error);
				deposit_amount = (String) results.get("deposit_amount") ;
				admn_dep_coll_reqd_yn = checkForNull((String) results.get("admn_dep_coll_reqd_yn"),"N") ;

				String e = String.valueOf(results.get("encounter"));
				String ord_exist_yn = String.valueOf(results.get("or_check_unbill_ord_exists_yn"));
				eid = e;
				String str_package_amt = (String) results.get("str_package_amt") ;
				if (str_package_amt==null) str_package_amt = "";
				String str_package_code = (String) results.get("str_package_code") ;
					if (str_package_code==null) str_package_code = "";
				String str_package_seq_num = (String) results.get("str_package_seq_num") ;
				if (str_package_seq_num==null) str_package_seq_num = "";
				String package_enabled_yn = (String) results.get("package_enabled_yn") ;
				if (package_enabled_yn==null) package_enabled_yn = "N";
				
				str_package_amt = str_package_amt.replace('|','^');
				str_package_code = str_package_code.replace('|','^');
				str_package_seq_num = str_package_seq_num.replace('|','^');

				//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
				if (inserted)
				{
					if(isInvokeUploadDocAppl)
					{
						int ins_count = eMP.MPCommonBean.getInsuranceCount(con,eid,patientid);

						if(ins_count > 0)
						{

						String htmlFor = "var dialogHeight = '70vh'; var dialogWidth = '70vw'; var arguments = ''; var getUrl = '../../eMP/jsp/MPUploadDocument.jsp?function_id="
							+ "UPLOAD_DOC"
							+ "&patient_id="
							+ patientid
							+ "&encounter_id="
							+ eid
							+ "'; var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll = auto; status = no;' ; var retVal = await window.showModalDialog(getUrl,arguments,features);";

						out.println(htmlFor);

						}
					}
				}
				
/**********************Added for package billing***************************starts**********/
//out.println("<script>alert('Check:"+error+"');</script>");
try{
	if(package_enabled_yn.equals("Y")){ 
			if(!str_package_seq_num.equals("")){ 
				    /*
					StringTokenizer pkg_seq_no_st = new StringTokenizer(str_package_seq_num,"|");
					StringTokenizer pkg_code_st = new StringTokenizer(str_package_code,"|");
					StringTokenizer pkg_amt_st = new StringTokenizer(str_package_amt,"|");
					String pkg_seq_no="",pkg_code="", pkg_amt="";
				    */
					/*while(pkg_seq_no_st.hasMoreTokens())
					{
						
						pkg_seq_no = pkg_seq_no_st.nextToken();		
						pkg_code   = pkg_code_st.nextToken();	
						pkg_amt    = pkg_amt_st.nextToken();	*/
							
					/*	String htmlFor1 = " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"
											+ sStyle
											+ "'></link></head><body class='message'><script language = 'JavaScript'>var arr = new Array();var retVal; var dialogHeight    = '40' ;	 var dialogWidth = '70' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ;  var getUrl  = '../eBL/jsp/BLEnterReceiptRefundFrame.jsp?patient_id="
											+patientid
											+"&episode_type=I"
											+"&episode_id="
											+eid
											+"&encounter_id="
											+eid
											+"&packseqno="
											+pkg_seq_no
											+"&pkgCode="
											+pkg_code
											+"&pkgAmount="
											+pkg_amt																					
											+"&function_id=PKG_BILLING"
											+"';"
											+ "retVal = window.showModalDialog(getUrl,arguments,features);"
											+" while(retVal == undefined || retVal == 'undefined') { "
											+"retVal = window.showModalDialog(getUrl,arguments,features);"								
											+" } "
											+" </script></body></html>";

											out.println(htmlFor1);*/

											StringBuffer htmlFor = new StringBuffer();
											htmlFor.append("var center = '1';");
											htmlFor.append("var dialogTop	= '100';");
											htmlFor.append(" var dialogHeight	= '90vh';" );
											htmlFor.append("var dialogWidth		= '90vw';" );
											htmlFor.append("var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no;' ;");
											htmlFor.append("var  arguments 		= '';" );										
											//htmlFor.append(" param = '../eBL/jsp/BLEnterReceiptRefundFrame.jsp?patient_id="+patientid+"&encounter_id="+eid+"&episode_type=I&episode_id="+eid+"&visit_id&packseqno="+pkg_seq_no+"&pkgCode="+pkg_code+"&pkgAmount="+pkg_amt+"&function_id=PKG_BILLING';");
											htmlFor.append(" param = '../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?patient_id="+patientid+"&encounter_id="+eid+"&episode_type=I&episode_id="+eid+"&visit_id&packseqno="+str_package_seq_num+"&pkgCode="+str_package_code+"&pkgAmount="+str_package_amt+"&function_id=PKG_BILLING';");
											htmlFor.append(" retVal	= await top.window.showModalDialog(param,arguments, features );");
											
											htmlFor.append(" while(retVal==null || retVal ==''|| retVal==undefined || retVal=='undefined'){");
												htmlFor.append(" retVal	= await top.window.showModalDialog(param,arguments, features );");
											htmlFor.append(" }");
											out.println(htmlFor.toString());
											
                                         
						
					//}
			}
}
}catch(Exception  eee)
				{				
	eee.printStackTrace();			
	out.print(eee+"deposit function");
				}
/**********************Added for package billing***************************ends**********/

				
			     int amount;
				 deposit_amount 			= (deposit_amount == null)?"":deposit_amount;


			      if (deposit_amount!="")
			      {
				      amount = Integer.parseInt(deposit_amount);
			      }
			      else
				  {
					  amount=0;
			      }
				   
				  
				  
				  if (inserted && amount > 0 && admn_dep_coll_reqd_yn.equals("Y"))
				   {
				   
				   

		            StringBuffer htmlFor = new StringBuffer();
					htmlFor.append("var center = '1';");
					htmlFor.append("var dialogTop	= '70';");
					htmlFor.append(" var dialogHeight	= '95vh';" );
					htmlFor.append("var dialogWidth		= '90vw';" );
					htmlFor.append("var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no;' ;");
					htmlFor.append("var  arguments 		= '';" );
					//htmlFor.append("var  column_sizes  		= escape('');" );
					//htmlFor.append("var  column_descriptions  	= '';" );
					//htmlFor.append(" param = '../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patientid+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&visit_id="+strVisitId+"&encounter_id="+eid+"&nursing_unit_code="+nursingunit+"';");
					htmlFor.append(" param = '../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?patient_id="+patientid+"&encounter_id="+eid+"&episode_type="+episodetype+"&episode_id="+eid+"&visit_id&nursing_unit_code="+nursingunit+"&chiefcomplaint="+chiefcomplaint+"&chiefComplaintDesc="+java.net.URLEncoder.encode(chiefComplaintDesc, "UTF-8")+"';");
					htmlFor.append(" retVal	= await top.window.showModalDialog(param,arguments, features );");

                    out.println(htmlFor.toString()); 

                    }
			 
                    
                    			   

				if(inserted && ord_exist_yn.equals("Y"))
				{
					//futureOrder(patientclass,eid, eid, p_episode_visit_num, p_source_type,  p_source_code, patientid);
					futureOrder(req,res,appl_patient_class,eid, eid, "", nursingunittype,  nursingunit, patientid);
				}
               
				if ( inserted )
				{  
                      
                   
					// Added by Sridhar R., from Version2 - eMAL. on 3/21/2005, coded by Ranjani ...
					if(mod_id.equals("PATREG") || from_adv_bed_mgmt.equals("Y"))
					{
						if(error.indexOf("<u>")>=0)
						{
							err = error.substring(3,error.indexOf("</u>"));
							err1 = error.substring(error.indexOf("</u>")+4,error.length());
							error = err+err1;
						}
						if(error.indexOf("<b>")>=0)
						{
							err = error.substring(3,error.indexOf("</b>"));
							err1 = error.substring(error.indexOf("</b>")+4,error.length());
							error = err+err1;
						}
					}
					error_value = "1" ;
					if(error.lastIndexOf("<br>")>=0)
					error=error.substring(0,error.lastIndexOf("<br>"));

					if(mod_id.equals("PATREG") || from_adv_bed_mgmt.equals("Y"))
					{
						//if(error.lastIndexOf("<br>")>=0)
						if(error.lastIndexOf("<br>") != -1)
						{
                           

							err	= error.substring(0,error.indexOf("<br>"));
							err1 = error.substring(error.indexOf("<br>")+4);
							error = err + " "+err1;
							error = error + " " +enc_msg + " " + eid + " "; 
						}
						else
						{
							error = error + " " +enc_msg + " " + eid + " "; 
						}

					}
					else
					{
						error = error + enc_msg + " <b>"+eid+"</b> ";
					} 
					HashMap htRepResults = new HashMap();
					htRepResults = onlineReports( req,res,eid,nursingunit, age,pat_ser_grp_code);
					htRepResults.put("age",age);
					htRepResults.put("admissiondate",admissiondate);
					htRepResults.put("maintain_doc_or_file",maintain_doc_or_file);
					htRepResults.put("file_creation",file_creation);
					htRepResults.put("fm_install_yn",fm_install_yn);
					htRepResults.put("pat_ser_grp_code",pat_ser_grp_code);
					htRepResults.put("patient_class",patient_class);
					htRepResults.put("mod_id",mod_id);
					htRepResults.put("nursingunittype",nursingunittype);
					htRepResults.put("single_or_multi_files_ind",single_or_multi_files_ind);
					htRepResults.put("p_seperate_file_no_yn",p_seperate_file_no_yn);
					htRepResults.put("file_type_appl_yn",file_type_appl_yn);
					htRepResults.put("callfunc",callfunc);  
					getMRNFile(req,res,nursingunit,error,eid,htRepResults);
					htRepResults.clear();
					/*Added for the CRF - MMS-QH-CRF-0066 - start*/
					if (isBlInstalled.equals("Y")) {
						try
						{
							String bean_id		= "bl_blinsuranceimagebean" ;
							String bean_name	= "eBL.BLInsuranceImageBean";
							BLInsuranceImageBean bean = (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
							bean.insertInsuranceDBvalues(patientid);  
						}
						catch(Exception ex)
						{
							System.out.println("Exception while calling BLInsuranceImageBean:::: "+ex);
							ex.printStackTrace();
						}
					}
					/*Added for the CRF - MMS-QH-CRF-0066 - End*/
				}
				else
				{ 
					error = error + " "; 
		
					if(error.contains("APP-IP0221"))
					{  
						if(from_adv_bed_mgmt.equals("N")){
							out.println("parent.frames[1].frames[0].location.reload();parent.frames[1].frames[1].location.href='../eCommon/html/blank.html'  ;parent.frames[1].frames[2].location.reload();parent.frames[1].frames[3].location.reload();");
                            System.err.println("hi in new issue 5=============================================================>");
							out.println("parent.frames[2].location.href ='../eCommon/jsp/"+errorPage+"?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "';");
						}else{
							//out.println("alert('"+ java.net.URLEncoder.encode(error,"UTF-8")+"');");
							out.println("alert('"+error+"');window.close();");
						}
						
					}
					else
					{  
						if(from_adv_bed_mgmt.equals("Y")){
							//out.println("alert('"+ java.net.URLEncoder.encode(error,"UTF-8")+"');");
							out.println("alert('"+error+"');window.close();");
						}else{
							System.err.println("hi in 1319 servlet error ===================>"+error);
							System.err.println("hi in new issue 6=============================================================>");
							out.println("parent.frames[2].location.href ='../eCommon/jsp/"+errorPage+"?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "';");
						}
					}
				}
				
				hashData.clear();
				results.clear();

				if(inserted)
				{
					session.removeAttribute("financial_details");
				}
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)  ConnectionManager.returnConnection(con,req);
			if (session.getAttribute("financial_details") != null )
			{
				//session.removeAttribute("financial_details");
			}
		}
		
	}

	private void getMRNFile(HttpServletRequest req,HttpServletResponse res,String nursingunit,String error, String eid,HashMap reportResults) throws Exception
    {   
        	
		java.util.Properties p		= null;
		PrintWriter	out				= null;
		HttpSession session			= null;
		session           	        = req.getSession(false) ;
		out							= res.getWriter();
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		String facilityId			= (String)session.getValue("facility_id") ;
		String locale				= p.getProperty("LOCALE");
		String sStyle				=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String pat_file_no			= "" ;
		StringBuffer sql			= new StringBuffer();
		StringBuffer sqlMPString	= new StringBuffer();
		StringBuffer sqlIPString	= new StringBuffer();
		StringBuffer sqlMPIPString	= new StringBuffer();
		StringBuffer sqlIPMPString	= new StringBuffer();
        PreparedStatement pstmt		= null;
		CallableStatement cs		= null ;
        Connection conn				= null ;
		PreparedStatement pstmtMR_Sect_Code = null;
		ResultSet rsMR_Sect_Code	= null;
		ResultSet rset				= null;
		String reportParamNames		= "";
		String reportParamValues	= "";
		String clinic_type			= "";
		String nursing_unit_code	= "";
		String p_patient_id			= "";
		String age					= "";
		String admissiondate		= "";
		String maintain_doc_or_file	= "";
		String file_creation		= "";
		String fm_install_yn		= "";
		String pat_ser_grp_code		= "";
		String patient_class		= "";
		String mod_id				= "";
		String nursingunittype		= "";
		String single_or_multi_files_ind = "";
		String file_type_appl_yn	= "";
		String function_name		= "";
		String	pat_flag			= "";
		String function_id			= "";
		String callfunc             = "";
		String d_clinic_code		= "";
		String bookingrefno         = "";
		String bedno                = "";
		String pat_check_in_allowed_yn = "";
		String p_seperate_file_no_yn= "N";
		reportParamNames			= (String)reportResults.get("reportParamNames");
		reportParamValues			= (String)reportResults.get("reportParamValues");
		clinic_type					= (String)reportResults.get("clinictype");
		nursing_unit_code			= (String)reportResults.get("cliniccode");
		p_patient_id				= (String)reportResults.get("p_patient_id");
		age							= (String)reportResults.get("age");
		admissiondate				= (String)reportResults.get("admissiondate");
		maintain_doc_or_file		= (String)reportResults.get("maintain_doc_or_file");
		file_creation				= (String)reportResults.get("file_creation");
		fm_install_yn				= (String)reportResults.get("fm_install_yn");
		pat_ser_grp_code			= (String)reportResults.get("pat_ser_grp_code");
		patient_class				= (String)reportResults.get("patient_class");
		mod_id						= (String)reportResults.get("mod_id");
		nursingunittype				= (String)reportResults.get("nursingunittype");
		single_or_multi_files_ind	= (String)reportResults.get("single_or_multi_files_ind");
		file_type_appl_yn			= (String)reportResults.get("file_type_appl_yn");
		p_seperate_file_no_yn		= (String)reportResults.get("p_seperate_file_no_yn");
		callfunc					= (String)reportResults.get("callfunc");
		String from_adv_bed_mgmt	= req.getParameter("from_adv_bed_mgmt")==null?"N":req.getParameter("from_adv_bed_mgmt");
		//System.out.println("getMRNFile 1156 from_adv_bed_mgmt 2:=====>"+from_adv_bed_mgmt);	
		if(callfunc == null) callfunc = "";
		//String booking_case_yn	= (String)reportResults.get("booking_case_yn");
		//String booking_ref_no		= (String)reportResults.get("booking_ref_no");
		//String maintain_doc_or_file = "";//commented for PE By Sudhakar
		function_name				= "Admit Patient";
		
		String p_create_file_no_yn	= "";
		String file_flag			= "N";
		String createFile			= "Y";
		String wristBandLbl			= "IPBWBLBL"; 
		//String fm_install_yn		= "N" ;
		pat_flag					= checkForNull(req.getParameter("pat_flag"),"N");
		function_id					= checkForNull(req.getParameter("function_id"));
		
		d_clinic_code				= checkForNull(req.getParameter("d_clinic_code"));
		bookingrefno				= checkForNull(req.getParameter("booking_ref_no"));
		bedno						= checkForNull(req.getParameter("r_bed_no"));
		pat_check_in_allowed_yn		= checkForNull(req.getParameter("pat_check_in_allowed_yn"),"N");
		String err1					= "";
		String err2					= "";
		String error_value			= "0" ;
		String mr_section_code		= "";
		String mr_section_type		= "";
		
		if(age.indexOf("Y") > 0)
		{
			age						= age.substring(0,age.indexOf("Y"));
			int n_Age				= 0;
			n_Age					= Integer.parseInt(age);

			if(n_Age <= 2)
				wristBandLbl		= "IPBWBLBL";
			else
				wristBandLbl		= "IPBINWBL";
		}
		else
		{
			//wristBandLbl = "IPBINWBL";
			wristBandLbl			= "IPBWBLBL";
		}
		
		/*called when patient is registered from IP with file creation*/
		 sqlMPString.append(" SELECT a.report_id, b.report_desc, 1 no_of_copies, b.module_id, 1 orderby FROM mp_online_reports a, sm_report_lang_vw b, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' AND a.print_reqd_yn = 'Y' AND b.language_id = '"+locale+"' AND b.report_id = a.report_id AND a.report_id = c.report_id(+) AND NVL (c.facility_id, '"+facilityId+"') = '"+facilityId+"' AND a.report_id NOT IN ('MPBCPBCT', 'MPBBTCRA', 'MPBBTCER', 'MPBBTNOT', 'MPBNBFRM', 'MPBWBLBL', 'MPBIRCER', 'MPSTBCER') UNION SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id module_id, 2 orderby FROM ip_online_report a, sm_report_lang_vw b WHERE ");
		 sqlMPString.append(" a.module_id = 'IP' ");
		 sqlMPString.append(" AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') ORDER BY 5, 2 ");
		
		/*called when patient is registered from IP without file creation*/
		 sqlIPMPString.append(" SELECT a.report_id, b.report_desc, 1 no_of_copies, b.module_id, 1 orderby FROM mp_online_reports a, sm_report_lang_vw b, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' AND a.print_reqd_yn = 'Y' AND b.language_id = '"+locale+"' AND b.report_id = a.report_id AND a.report_id = c.report_id(+) AND NVL (c.facility_id, '"+facilityId+"') = '"+facilityId+"' AND a.report_id NOT IN ('MPBCPBCT', 'MPBBTCRA', 'MPBBTCER', 'MPBBTNOT', 'MPBNBFRM', 'MPBWBLBL', 'MPBIRCER', 'MPSTBCER', 'MPBFLLBL') UNION SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id module_id, 2 orderby FROM ip_online_report a, sm_report_lang_vw b WHERE ");
		 sqlIPMPString.append(" a.module_id = 'IP' ");
		 sqlIPMPString.append(" AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') ORDER BY 5, 2 ");
         
		/*called when patient is registered from MP with file creation */
		sqlIPString.append(" SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report_lang_vw b WHERE a.module_id = 'IP' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND b.language_id = '"+locale+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') ORDER BY 2 ");	
        
 		/*called when patient is registered from MP without file creation */
		 sqlMPIPString.append(" SELECT a.report_id, b.report_desc, 1 no_of_copies, b.module_id, 1 orderby FROM mp_online_reports a, sm_report_lang_vw b, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' AND a.print_reqd_yn = 'Y' AND b.language_id = '"+locale+"' AND b.report_id = a.report_id AND a.report_id = c.report_id(+) AND NVL (c.facility_id, '"+facilityId+"') = '"+facilityId+"' AND a.report_id = 'MPBFLLBL' UNION SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id module_id, 2 orderby FROM ip_online_report a, sm_report_lang_vw b WHERE ");
		 sqlMPIPString.append(" a.module_id = 'IP' ");
		 sqlMPIPString.append(" AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') ORDER BY 5, 2 ");
		

		try
		{
			conn					= ConnectionManager.getConnection(req);
			// Check whether the file managment is installed or not
			if(sql.length() > 0) sql.delete(0,sql.length());//this one
			//commented for PE By Sudhakar
			/*sql.append("select install_yn from SM_MODULE where module_id = 'FM'");
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt					= conn.prepareStatement(sql.toString());
			rset					= pstmt.executeQuery();
			//String fm_install_yn	= "N" ;
			if (rset != null && rset.next())
				fm_install_yn		= checkForNull(rset.getString(1));
			if(fm_install_yn.equals(""))
				fm_install_yn		= "N" ;
			if(sql.length() > 0) sql.delete(0,sql.length());*/
			//commented for PE By Sudhakar
			/*sql.append("select maintain_doc_or_file, create_file_at_admission, create_file_at_dc_admission_yn from MP_PARAM where module_id = 'MP'");
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			pstmt					= conn.prepareStatement(sql.toString());
			rset					= pstmt.executeQuery();
			String file_creation	= "N" ;
			if (rset != null && rset.next())
			{
				maintain_doc_or_file= checkForNull(rset.getString("maintain_doc_or_file"));
				if (patient_class.equals("IP"))
				{
					file_creation   = checkForNull(rset.getString("create_file_at_admission"));
				}
				else
				{
					file_creation   = checkForNull(rset.getString("create_file_at_dc_admission_yn"));
				}
			}
			if(file_creation.equals(""))
				file_creation		= "N" ;*/
			

			/*Thursday, March 25, 2010 , SRR20056-SCF-4336-IN020228 , toget pat_file_no*/
			if(sql.length() > 0) sql.delete(0,sql.length());
				if(!mr_section_code.equals(""))
				{
					//sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patientid+"' and MR_SECTION_CODE  = '"+mr_section_code+"'");
					sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+p_patient_id+"' and MR_SECTION_CODE  = '"+mr_section_code+"'"); 
				}
				else
				{	//sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patientid+"'" );
					sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+p_patient_id+"'" ); 
					
				}  
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				pstmt = conn.prepareStatement(sql.toString());
				rset = pstmt.executeQuery();


				if(rset != null && rset.next())
				{
					pat_file_no = checkForNull(rset.getString(1));
				}

			/**/

			
			 
			if(fm_install_yn.equals("Y") && maintain_doc_or_file.equals("F") && pat_check_in_allowed_yn.equals("N"))
			{
				/*
				if(sql.length() > 0) sql.delete(0,sql.length());
				if(!mr_section_code.equals(""))
					sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patientid+"' and MR_SECTION_CODE  = '"+mr_section_code+"'");
				else
					sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patientid+"'" );
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				pstmt = conn.prepareStatement(sql.toString());
				rset = pstmt.executeQuery();


				if(rset != null && rset.next())
				{
					pat_file_no = checkForNull(rset.getString(1));
				}
				*/
				  
				   
				if (!bedno.equals("") && !pat_file_no.equals("") && bookingrefno.equals(""))
				{
					createFile = "N";
					requestfile(req,res,nursingunit,conn,error,fm_install_yn,p_patient_id,eid,pat_flag,pat_ser_grp_code,age,callfunc);
				}


			}

			if(bookingrefno.equals("") && patient_class.equals("DC"))
				createFile = "N";
            
			
			if (maintain_doc_or_file.equals("F"))
			{
				StringBuffer strMR_Sect_Code = new StringBuffer();
				try
				{
					if (patient_class.equals("IP"))
					{
						strMR_Sect_Code.append("Select mr_section_code, mr_section_type from ip_nursing_unit where facility_id = ? and nursing_unit_code = ?");
					}
					else
					{
						strMR_Sect_Code.append("Select mr_section_code, mr_section_type from op_clinic where facility_id = ? and clinic_code = ?");
					} 
					pstmtMR_Sect_Code = conn.prepareStatement(strMR_Sect_Code.toString());
					pstmtMR_Sect_Code.setString(1,facilityId);
					if (patient_class.equals("IP"))
						pstmtMR_Sect_Code.setString(2,nursingunit); 
					else
						pstmtMR_Sect_Code.setString(2,d_clinic_code); 
					rsMR_Sect_Code = pstmtMR_Sect_Code.executeQuery();
					if (rsMR_Sect_Code!=null && rsMR_Sect_Code.next())
					{
						mr_section_code = rsMR_Sect_Code.getString("mr_section_code");
						mr_section_code = (mr_section_code==null)?"":mr_section_code;
						mr_section_type = rsMR_Sect_Code.getString("mr_section_type");
						mr_section_type = (mr_section_type==null)?"":mr_section_type;
					}
				}
				catch(Exception pc)
				{
					pc.printStackTrace();
				}
				rsMR_Sect_Code.close();
				pstmtMR_Sect_Code.close();
				
				if (file_creation.equals("Y"))
				{
									
					if(file_type_appl_yn.equals("Y"))
						file_flag ="Y";
					else
					{
						Hashtable hashFILE_NO_EXISTS = File_No_ExistsCall(req,res,p_patient_id, facilityId, "IP", nursingunit, conn);
						p_seperate_file_no_yn = (String)hashFILE_NO_EXISTS.get("p_seperate_file_no_yn");
						p_create_file_no_yn = (String)hashFILE_NO_EXISTS.get("p_create_file_no_yn");
												
						if(p_create_file_no_yn.equals("Y"))
							file_flag ="Y";
						else
							file_flag = "N";
						if(p_create_file_no_yn==null) p_create_file_no_yn="";
						if(p_seperate_file_no_yn==null) p_seperate_file_no_yn="";

						hashFILE_NO_EXISTS.clear();
					}
				     
					if(file_flag.equals("Y"))
					{   
						String temp_Called_from="";
						String temp_location_type="";
						String temp_location_code="";
						if(patient_class.equals("IP"))
						{
							temp_Called_from   = "IP";
							temp_location_type = nursingunittype;
							temp_location_code = nursingunit;
						}
						else
						{
							temp_Called_from   = "OP";
							temp_location_type = "D";
							temp_location_code = d_clinic_code;
						}
						reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_file_no";
						reportParamValues = ""+eid+","+nursing_unit_code+","+clinic_type+","+p_patient_id+"";
						error_value = "1" ;
						int idval = 0;
						if(error.indexOf("<br>")!=-1)
						idval=error.indexOf("<br>");
						err1=error.substring(0,idval);
						err2=error.substring(idval);

						String dcd_err1=java.net.URLDecoder.decode(java.net.URLEncoder.encode(err1,"UTF-8"),"UTF-8");
						String dcd_err2=java.net.URLDecoder.decode(java.net.URLEncoder.encode(err2,"UTF-8"),"UTF-8");
                        	
						//if(createFile.equals("Y")) //Thursday, March 25, 2010 , SRR20056-SCF-4336-IN020228 , to call create patient file window if file is not created during register patient in MP.
                        
						if(createFile.equals("Y") && pat_file_no.equals(""))
						{   
						   //Below line added for this incident[IN:049872]
						   String quick_admission_type	= req.getParameter("quick_admission_type")==null?"":req.getParameter("quick_admission_type");
                           String quick_adm=checkForNull(req.getParameter("quick_adm"));
                           String ref_encounter_id=checkForNull(req.getParameter("ref_encounter_id"));
						   String patient_id= checkForNull(req.getParameter("patient_id"));
						   String encStr="Encounter ID  ";
                           encStr=encStr+eid;
						   //End [IN:049872]
						  
							if(pat_flag.equals("Y"))
							{	
							
								/*Thursday, October 07, 2010 , patientid changed to p_patient_id due to concurrent user.*/
								//String htmlFor = "<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'><script language = 'JavaScript'>var dialogHeight    = '18' ;	var dialogWidth = '23' ;var dialogTop = '85';var arguments =   ''; var fileString=''; var fileString2=''; var arr1;var getUrl = '../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+temp_Called_from+"&Location_Type="+temp_location_type+"&Location_Code="+temp_location_code+"&P_Patient_ID="+p_patient_id+"&p_encounter_id="+eid+"&p_patient_class="+patient_class+"&p_encounter_date_time="+admissiondate+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_seperate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var retVal = window.showModalDialog(getUrl,arguments,features); var newval=' ';  var fileval=' ';if(retVal==null) {retVal=' ` '; fileString=' '; fileString2='';}    var arr = retVal.split('`');if(arr[0]==null || arr[0]==''){arr[0]=' ';	fileString=' ';	fileString2=' '; }if(arr[1]==null || arr[1]==''){arr[1]= ' ';}	if(arr[0] != ' '){var arr1=arr[0].split('||');if(arr1[0]==null || arr1[0] == ''){  arr1[0]=' ';fileString=' ';fileString2=' ';newval=' ';fileval='';}else{/**/if(arr1.length==2){/**/newval=arr1[0];fileval=arr1[1];/**/} else{newval=arr1[0];fileval=arr1[0];}/**/}if(arr1[1] == null || arr1[1] == ''){	arr1[1]=' ';} eval(parent.frames[1].frames[2].assignnewfileno(arr1[1])); } if((arr[0]!=' ')){var dialogHeight    = '55vh' ;var dialogWidth = '45vw' ; var dialogTop = 58; var arguments =   ''; var new_file_no = fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlMPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+",'+new_file_no; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth+';status=no;';retVal=window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG'){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+newval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{if(newval!=' '){parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" <br> and File No : '+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"' }else{ parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" '+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"' }}}else{ var dialogHeight    = '30' ;var dialogWidth = '45vw' ;var dialogTop = 58; var arguments =   '';var new_file_no= fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlIPMPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ; retVal= window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG'){if(newval != ' '){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' and File No : '+fileString+newval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+newval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}}else{if(newval != ' '){parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"<br> and File No : '+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';}else{parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"'+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"';} }}</script></body></html>";
								/*Above Line Commented and Below Line Added for this [SS-SCF-0666]*/
								//Below line mofified for this incident[IN:049872]	
								//String htmlFor = "<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'><script language = 'JavaScript'>var dialogHeight    = '18' ;	var dialogWidth = '23' ;var dialogTop = '85';var arguments =   ''; var fileString=''; var fileString2=''; var arr1;var getUrl = '../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+temp_Called_from+"&Location_Type="+temp_location_type+"&Location_Code="+temp_location_code+"&P_Patient_ID="+p_patient_id+"&p_encounter_id="+eid+"&p_patient_class="+patient_class+"&p_encounter_date_time="+admissiondate+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_seperate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var retVal = window.showModalDialog(getUrl,arguments,features); var newval=' ';  var fileval=' ';if(retVal==null) {retVal=' ` '; fileString=' '; fileString2='';}    var arr = retVal.split('`');if(arr[0]==null || arr[0]==''){arr[0]=' ';	fileString=' ';	fileString2=' '; }if(arr[1]==null || arr[1]==''){arr[1]= ' ';}	if(arr[0] != ' '){var arr1=arr[0].split('||');if(arr1[0]==null || arr1[0] == ''){  arr1[0]=' ';fileString=' ';fileString2=' ';newval=' ';fileval='';}else{/**/if(arr1.length==2){/**/newval=arr1[0];fileval=arr1[1];/**/} else{newval=arr1[0];fileval=arr1[0];}/**/}if(arr1[1] == null || arr1[1] == ''){	arr1[1]=' ';} eval(parent.frames[1].frames[2].assignnewfileno(arr1[1])); } if((arr[0]!=' ')){var dialogHeight    = '55vh' ;var dialogWidth = '45vw' ; var dialogTop = 58; var arguments =   ''; var new_file_no = fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&step=1&sqlString="+java.net.URLEncoder.encode(sqlMPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+",'+new_file_no; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth+';status=no;';retVal=window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG' || '"+from_adv_bed_mgmt+"'=='Y'){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{if(newval!=' '){parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" <br> and File No : '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();} }else{ parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();} }}}else{ var dialogHeight    = '30' ;var dialogWidth = '45vw' ;var dialogTop = 58; var arguments =   '';var new_file_no= fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&step=1&sqlString="+java.net.URLEncoder.encode(sqlIPMPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ; retVal= window.showModalDialog(getUrl,arguments,features); if('"+mod_id+
								session.setAttribute("SQLSTRING_QUERYKEYMP",sqlMPString.toString());
								session.setAttribute("SQLSTRING_QUERYKEYIPMP",sqlIPMPString.toString());
								System.err.println("hi in 1693 servlet error ===================>"+error);
								System.err.println("hi in new issue 7=============================================================>");
								String htmlFor = "var dialogHeight    = '45vh' ;	var dialogWidth = '30vw' ;var dialogTop = '85';var arguments =   ''; var fileString=''; var fileString2=''; var arr1;var getUrl = '../../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+temp_Called_from+"&Location_Type="+temp_location_type+"&Location_Code="+temp_location_code+"&P_Patient_ID="+p_patient_id+"&p_encounter_id="+eid+"&p_patient_class="+patient_class+"&p_encounter_date_time="+admissiondate+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_seperate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var retVal = await window.showModalDialog(getUrl,arguments,features); var newval=' ';  var fileval=' ';if(retVal==null) {retVal=' ` '; fileString=' '; fileString2='';}    var arr = retVal.split('`');if(arr[0]==null || arr[0]==''){arr[0]=' ';	fileString=' ';	fileString2=' '; }if(arr[1]==null || arr[1]==''){arr[1]= ' ';}	if(arr[0] != ' '){var arr1=arr[0].split('||');if(arr1[0]==null || arr1[0] == ''){  arr1[0]=' ';fileString=' ';fileString2=' ';newval=' ';fileval='';}else{/**/if(arr1.length==2){/**/newval=arr1[0];fileval=arr1[1];/**/} else{newval=arr1[0];fileval=arr1[0];}/**/}if(arr1[1] == null || arr1[1] == ''){	arr1[1]=' ';} eval(parent.frames[1].frames[2].assignnewfileno(arr1[1])); } if((arr[0]!=' ')){var dialogHeight    = '55vh' ;var dialogWidth = '45vw' ; var dialogTop = 58; var arguments =   ''; var new_file_no = fileval; if(new_file_no == null) new_file_no='';var getUrl='../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&sql_querykey=SQLSTRING_QUERYKEYMP&step=1&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+",'+new_file_no; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth+';status=no;';retVal= await window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG' || '"+from_adv_bed_mgmt+"'=='Y'){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{if(newval!=' '){parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" <br> and File No : '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();} }else{ parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();} }}}else{ var dialogHeight    = '50vh' ;var dialogWidth = '45vw' ;var dialogTop = 58; var arguments =   '';var new_file_no= fileval; if(new_file_no == null) new_file_no='';var getUrl='../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&sql_querykey=SQLSTRING_QUERYKEYIPMP&step=1&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ; retVal= await window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG' || '"+from_adv_bed_mgmt+"'=='Y'){if(newval != ' '){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' and File No : '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}}else{if(newval != ' '){parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"<br> and File No : '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}}else{parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"'+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}} }}";
								out.println(htmlFor);  
                                								
								
							}else
							{                                  
								/*Thursday, October 07, 2010 , patientid changed to p_patient_id due to concurrent user.*/
								//String htmlFor = "<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'><script language = 'JavaScript'>var dialogHeight    = '18' ;	var dialogWidth = '23' ;var dialogTop = '85';var arguments =   ''; var fileString=''; var fileString2=''; var arr1;var getUrl = '../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+temp_Called_from+"&Location_Type="+temp_location_type+"&Location_Code="+temp_location_code+"&P_Patient_ID="+p_patient_id+"&p_encounter_id="+eid+"&p_patient_class="+patient_class+"&p_encounter_date_time="+admissiondate+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_seperate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var retVal = window.showModalDialog(getUrl,arguments,features); var newval=' ';  var fileval=' ';if(retVal==null) {retVal=' ` '; fileString=' '; fileString2='';}    var arr = retVal.split('`');if(arr[0]==null || arr[0]==''){arr[0]=' ';	fileString=' ';	fileString2=' '; }if(arr[1]==null || arr[1]==''){arr[1]= ' ';}	if(arr[0] != ' '){var arr1=arr[0].split('||');if(arr1[0]==null || arr1[0] == ''){  arr1[0]=' ';fileString=' ';fileString2=' ';newval=' ';fileval='';}else{/**/if(arr1.length==2){/**/newval=arr1[0];fileval=arr1[1];/**/} else{newval=arr1[0];fileval=arr1[0];}/**/ }if(arr1[1] == null || arr1[1] == ''){	arr1[1]=' ';} eval(parent.frames[1].frames[2].assignnewfileno(arr1[1])); } if((arr[0]!=' ')){var dialogHeight    = '55vh' ;var dialogWidth = '45vw' ; var dialogTop = 58; var arguments =   ''; var new_file_no = fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlMPIPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+",'+new_file_no; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth+';status=no;';retVal=window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG'){alert('"+dcd_err1+"'+' '+'"+dcd_err2+" and File No : '+'  '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{if(newval!=' '){parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" <br> and File No : '+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"' }else{ parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" '+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"' }}}else{ var dialogHeight    = '30' ;var dialogWidth = '45vw' ;var dialogTop = 58; var arguments =   '';var new_file_no= fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlIPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ; retVal= window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG'){if(newval != ' '){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' and File No : '+fileString+newval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+newval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}}else{if(newval != ' '){parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"<br> and File No : '+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';}else{parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"'+fileString+' <B><FONT SIZE=2>'+newval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"';} }}</script></body></html>";
								/*Above Line Commented and Below Line Added for this [SS-SCF-0666]*/								
								//String htmlFor = "<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'><script language = 'JavaScript'>var dialogHeight    = '18' ;	var dialogWidth = '23' ;var dialogTop = '85';var arguments =   ''; var fileString=''; var fileString2=''; var arr1;var getUrl = '../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+temp_Called_from+"&Location_Type="+temp_location_type+"&Location_Code="+temp_location_code+"&P_Patient_ID="+p_patient_id+"&p_encounter_id="+eid+"&p_patient_class="+patient_class+"&p_encounter_date_time="+admissiondate+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_seperate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var retVal = window.showModalDialog(getUrl,arguments,features); var newval=' ';  var fileval=' ';if(retVal==null) {retVal=' ` '; fileString=' '; fileString2='';}    var arr = retVal.split('`');if(arr[0]==null || arr[0]==''){arr[0]=' ';	fileString=' ';	fileString2=' '; }if(arr[1]==null || arr[1]==''){arr[1]= ' ';}	if(arr[0] != ' '){var arr1=arr[0].split('||');if(arr1[0]==null || arr1[0] == ''){  arr1[0]=' ';fileString=' ';fileString2=' ';newval=' ';fileval='';}else{/**/if(arr1.length==2){/**/newval=arr1[0];fileval=arr1[1];/**/} else{newval=arr1[0];fileval=arr1[0];}/**/ }if(arr1[1] == null || arr1[1] == ''){	arr1[1]=' ';} eval(parent.frames[1].frames[2].assignnewfileno(arr1[1])); } if((arr[0]!=' ')){var dialogHeight    = '55vh' ;var dialogWidth = '45vw' ; var dialogTop = 58; var arguments =   ''; var new_file_no = fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&step=1&sqlString="+java.net.URLEncoder.encode(sqlMPIPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+",'+new_file_no; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth+';status=no;';retVal=window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG' || '"+from_adv_bed_mgmt+"'=='Y'){alert('"+dcd_err1+"'+' '+'"+dcd_err2+" and File No : '+'  '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{if(newval!=' '){parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" <br> and File No : '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"' }else{ parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"' }}}else{ var dialogHeight    = '30' ;var dialogWidth = '45vw' ;var dialogTop = 58; var arguments =   '';var new_file_no= fileval; if(new_file_no == null) new_file_no='';var getUrl='../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&step=1&sqlString="+java.net.URLEncoder.encode(sqlIPString.toString())+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ; retVal= window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG' || '"+from_adv_bed_mgmt+"'=='Y'){if(newval != ' '){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' and File No : '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}}else{if(newval != ' '){parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"<br> and File No : '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';}else{parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"'+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"';} }}</script></body></html>";
								//Above line commented for this incident and Below line added[IN:049872]
								session.setAttribute("SQLSTRING_QUERYKEYMPIP",sqlMPIPString.toString());
								session.setAttribute("SQLSTRING_QUERYKEYIP",sqlIPString.toString());
								String htmlFor = "";
							    //System.err.println("hi in new issue 1737=============================================================>");
							    //System.err.println("hi in new issue 1741=============================================================>");
								htmlFor = "var dialogHeight    = '45vh' ;	var dialogWidth = '30vw' ;var dialogTop = '85';var arguments =   ''; var fileString=''; var fileString2=''; var arr1;var getUrl = '../../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+temp_Called_from+"&Location_Type="+temp_location_type+"&Location_Code="+temp_location_code+"&P_Patient_ID="+p_patient_id+"&p_encounter_id="+eid+"&p_patient_class="+patient_class+"&p_encounter_date_time="+admissiondate+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_seperate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var retVal = await window.showModalDialog(getUrl,arguments,features); var newval=' ';  var fileval=' ';if(retVal==null) {retVal=' ` '; fileString=' '; fileString2='';}    var arr = retVal.split('`');if(arr[0]==null || arr[0]==''){arr[0]=' ';	fileString=' ';	fileString2=' '; }if(arr[1]==null || arr[1]==''){arr[1]= ' ';}	if(arr[0] != ' '){var arr1=arr[0].split('||');if(arr1[0]==null || arr1[0] == ''){  arr1[0]=' ';fileString=' ';fileString2=' ';newval=' ';fileval='';}else{/**/if(arr1.length==2){/**/newval=arr1[0];fileval=arr1[1];/**/} else{newval=arr1[0];fileval=arr1[0];}/**/ }if(arr1[1] == null || arr1[1] == ''){	arr1[1]=' ';} eval(parent.frames[1].frames[2].assignnewfileno(arr1[1])); } if((arr[0]!=' ')){var dialogHeight    = '55vh' ;var dialogWidth = '45vw' ; var dialogTop = 58; var arguments =   ''; var new_file_no = fileval; if(new_file_no == null) new_file_no='';var getUrl='../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&sql_querykey=SQLSTRING_QUERYKEYMPIP&step=1&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+",'+new_file_no; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth+';status=no;';retVal= await window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG' || '"+from_adv_bed_mgmt+"'=='Y'){alert('"+dcd_err1+"'+' '+'"+dcd_err2+" and File No : '+'  '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{if(newval!=' '){parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" <br> and File No : '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"'; if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();} }else{parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+" '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();} }}}else{ var dialogHeight    = '50vh' ;var dialogWidth = '45vw' ;var dialogTop = 58; var arguments =   '';var new_file_no= fileval; if(new_file_no == null) new_file_no='';var getUrl='../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&sql_querykey=SQLSTRING_QUERYKEYIP&step=1&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ; retVal= await window.showModalDialog(getUrl,arguments,features); if('"+mod_id+"' == 'PATREG' || '"+from_adv_bed_mgmt+"'=='Y'){if(newval != ' '){alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' and File No : '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{alert('"+dcd_err1+"'+' '+'"+dcd_err2+"'+' '+fileString+fileval+fileString2+arr[1]);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}}else{if(newval != ' '){parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"<br> and File No : '+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+ arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}}else{parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"'+fileString+' <B><FONT SIZE=2>'+fileval+'</B></FONT> '+fileString2+''+arr[1]+' &err_value=" + error_value +"';if('"+quick_admission_type+"' == 'Y' && '"+quick_adm+"'=='Quick_admission'){alert('"+encStr+"');parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}} }}";
								out.println(htmlFor); 	
								
							}

						}
						else
						{   
							doOnlineReports(  req,res,error, eid, reportResults);
						}

					}
					else
					{    
						doOnlineReports(  req,res,error, eid, reportResults);
					}
				}
				else
				{   
					doOnlineReports(  req,res,error, eid, reportResults);
				}
			}  
			else if (maintain_doc_or_file.equals("D") && pat_flag.equals("Y") )
			{ 
				session.setAttribute("SQLSTRING_QUERYKEYMP",sqlMPString.toString());
			     
				String htmlFor = "var dialogHeight = '16';var dialogHeight    = '55vh' ;	var dialogWidth = '45vw' ;var dialogTop = '45vw'; var arguments =   '';var newval=' ';var fileString='';var fileString2='';  var fileval=''; var new_file_no= fileval; if(new_file_no == null) new_file_no=''; var getUrl        =  '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&sql_querykey=SQLSTRING_QUERYKEYMP&step=1&EncounterId="+eid+"&dest_locn_type=N&dest_locn_code="+nursingunit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;'; var retVal = await window.showModalDialog(getUrl,arguments,features);if('"+mod_id+"' == 'MP' || '"+from_adv_bed_mgmt+"'=='Y'){alert('"+java.net.URLEncoder.encode(err1,"UTF-8")+"'+' '+'"+java.net.URLEncoder.encode(err2,"UTF-8")+"'+' '+fileString+newval+fileString2);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{parent.commontoolbarFrame.location.href = '../eCommon/jsp/commonToolbar.jsp?module_id=OP&function_id="+function_id+"&function_name="+function_name+"&function_type=F&access=NYNNN';"+	"parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+error_value+"'}";
				out.println(htmlFor); 

			}
			else if (maintain_doc_or_file.equals("D") && pat_flag.equals("N") )
			{   
		
				session.setAttribute("SQLSTRING_QUERYKEYIP",sqlIPString.toString());
				String htmlFor = "var dialogHeight    = '55vh' ;	var dialogWidth = '45vw' ;var dialogTop = '45vw'; var arguments =   '';var newval=' ';var fileString='';var fileString2='';  var fileval=''; var new_file_no= fileval; if(new_file_no == null) new_file_no=''; var getUrl        =  '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&sql_querykey=SQLSTRING_QUERYKEYIP&step=1&EncounterId="+eid+"&dest_locn_type=N&dest_locn_code="+nursingunit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;'; var retVal = await window.showModalDialog(getUrl,arguments,features);if('"+mod_id+"' == 'MP' || '"+from_adv_bed_mgmt+"'=='Y'){alert('"+java.net.URLEncoder.encode(err1,"UTF-8")+"'+' '+'"+java.net.URLEncoder.encode(err2,"UTF-8")+"'+' '+fileString+newval+fileString2);parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}else{parent.commontoolbarFrame.location.href = '../eCommon/jsp/commonToolbar.jsp?module_id=OP&function_id="+function_id+"&function_name="+function_name+"&function_type=F&access=NYNNN';"+	"parent.messageFrame.location.href = '../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+error_value+"'}";
				out.println(htmlFor);


			}
/*
			if(fm_install_yn.equals("Y") && maintain_doc_or_file.equals("F") )
			{
*/
/*
				if(sql.length() > 0) sql.delete(0,sql.length());
				if(!mr_section_code.equals(""))
					sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patientid+"' and MR_SECTION_CODE  = '"+mr_section_code+"'");
				else
					sql.append("select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patientid+"'" );
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				pstmt = conn.prepareStatement(sql.toString());
				rset = pstmt.executeQuery();
				if (rset != null && rset.next())
					pat_file_no = checkForNull(rset.getString(1));
*/
/*
//				if (!(bedno.equals("")) && pat_file_no!="" && bookingrefno.equals(""))

				if (!(bedno.equals("")) && bookingrefno.equals(""))
				{
					if(pat_check_in_allowed_yn.equals("N"))
					{
						requestfile(nursingunit,conn);
					}
				}
			}
*/

		if(cs!=null)    cs.close();
		if(pstmt!=null) pstmt.close();
        }
		catch (Exception e)
		{
		   //out.println("Error in get MRN File "+e.toString());
		   e.printStackTrace();
		}
		finally
		{
			try
			{
				if(cs!=null)    cs.close();
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(rsMR_Sect_Code !=null) rsMR_Sect_Code.close();
				if(pstmtMR_Sect_Code !=null) pstmtMR_Sect_Code.close();
				if(conn != null)  ConnectionManager.returnConnection(conn,req);
			}
			catch (Exception e)
			{
			e.printStackTrace();
			}
			
		}
    }
/*
	private String getMessage(String msg, Connection con)
	{
		java.util.Hashtable message = MessageManager.getMessage( con, msg ) ;
		return((String) message.get("message")) ;
	}
*/
	private void requestfile(HttpServletRequest req, HttpServletResponse res,String nursingUnitCode,Connection con,String error,String fm_install_yn,String patient,String encid,String pat_flagyn,String pat_ser_grp_code,String age,String callfunc)  throws Exception
	{
       
	   
		StringBuffer sql			= new StringBuffer();
		PrintWriter	out				= null;
		HttpSession session			= null;
		session           	        = req.getSession(false) ;
		out							= res.getWriter();
		String sStyle				= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String facilityId			= (String)session.getValue("facility_id") ;
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		try
		{
			if(sql.length() > 0) sql.delete(0,sql.length());//this one
			//commented for PE By Sudhakar
			/*sql.append("select install_yn from sm_module where module_id = 'FM'");
			pstmt = con.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();
			String fm_install_yn = "N" ;
			if (rset.next())
			fm_install_yn = rset.getString(1);*/
			if(sql.length() > 0) sql.delete(0,sql.length());//this one
			sql.append("select fs_locn_code, online_mr_notfn_yn from ip_nursing_unit where facility_id = '"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"' ");
			
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			pstmt = con.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();
			String online_mr_notfn_yn		= "N" ;
			String fs_locn_code				= "N" ;
			String error_value				= "0" ;  
			if(fm_install_yn.equals("Y"))
			{
				if (rset.next())
				{
					fs_locn_code	   = rset.getString(1);
					online_mr_notfn_yn = rset.getString(2);
					if (online_mr_notfn_yn==null) online_mr_notfn_yn = "N";
				}
				if (fs_locn_code==null) fs_locn_code="";
                
				if(online_mr_notfn_yn.equals("Y"))
				{
	              
					error_value="1";
					StringBuffer htmlFor = new StringBuffer();/*
					htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
					//htmlFor.append("</head><body class='message'>");
					htmlFor.append("<script language = 'JavaScript'>" );
					htmlFor.append("function showModal(){ ");*/
					htmlFor.append("var jsp_name = '../../eCommon/blank.html';");
					htmlFor.append(" jsp_name = '../eFM/jsp/FMAcceptFileTypeVolumeNoFrame.jsp?patient_id="+patient+"&encounter_id="+encid+"&fs_locn_code="+fs_locn_code+"&online_mr_notfn_yn="+online_mr_notfn_yn+"&req_locn_id="+nursingUnitCode+"';");
					htmlFor.append("var retVal = '';");
					htmlFor.append("dialogHeight	= '35vh';");
					htmlFor.append("dialogWidth	= '30vw';" );
					htmlFor.append("dialogTop		= '185';" );
					htmlFor.append("dialogLeft		= '250';" );
					htmlFor.append("center			= '0';" );
					htmlFor.append("status			= 'no';");
					htmlFor.append("var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; center: ' + center + '; status: ' + status + '; dialogTop :' + dialogTop + ';dialogLeft:' + dialogLeft+';scroll=no';");
					htmlFor.append("var arguments		= '';");
					htmlFor.append("retValue				= await window.showModalDialog(jsp_name,arguments, features );");
					htmlFor.append("if(retValue== null)  retValue = 'N';");
					htmlFor.append("var ret = retValue.split('&');");
					htmlFor.append("var HTMLVal = \"");
					/*htmlFor.append("</script>");*/
					/*htmlFor.append("</head><body class='message'>");*/
					htmlFor.append("<form name='form1' method='post' action='../servlet/eIP.AdmitPatientServlet' target='messageFrame'>");
					htmlFor.append("<input type='hidden' name='req_no'></input>");
					htmlFor.append("<input type='hidden' name='perm_fs_locn'></input>");
					htmlFor.append("<input type='hidden' name='facility_id' value='"+facilityId+"'></input>");
					htmlFor.append("<input type='hidden' name='nursing_unit' value='"+nursingUnitCode+"'></input>");
					htmlFor.append("<input type='hidden' name='encounterId' value='"+encid+"'></input>");

					htmlFor.append("<input type='hidden' name='patient_id' value='"+patient+"'></input>");
					htmlFor.append("<input type='hidden' name='error' value='"+error+"'></input>");
					htmlFor.append("<input type='hidden' name='age' value='"+age+"'></input>");
					htmlFor.append("<input type='hidden' name='callfunc' value='"+callfunc+"'></input>");
					htmlFor.append("<input type='hidden' name='pat_flag' value='"+pat_flagyn+"'></input>");
					htmlFor.append("<input type='hidden' name='pat_ser_grp_code' value='"+pat_ser_grp_code+"'></input>");
					htmlFor.append("</form>\";");
					htmlFor.append("self.document.write(HTMLVal);");
					htmlFor.append("self.document.form1.req_no.value =ret[0]; ");				
					htmlFor.append("self.document.form1.perm_fs_locn.value =ret[1]; ");	
					htmlFor.append("self.document.form1.submit();");
					htmlFor.append("await new Promise(resolve => setTimeout(resolve, 1000));");
					
					/*htmlFor.append("<script>");
					htmlFor.append("showModal();");

					htmlFor.append("</script>");	
					out.println("</body></html>");*/
					out.println(htmlFor.toString());  
					

				}

			}
		}
		catch( Exception e )
		{
			//out.println("request file "+e);
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
			}
			catch (Exception e)
			{
			e.printStackTrace();
			}
		}

	}

	private void doOnlineReports(HttpServletRequest req, HttpServletResponse res,String message,String eid, HashMap reportResults) throws ServletException, IOException, SQLException
    {   
	
		PrintWriter	out				= null;
		HttpSession session			= null;
		session           	        = req.getSession(false) ;
		out							= res.getWriter();
		StringBuffer htmlFor = new StringBuffer();
		String reportParamNames		= "";
		String reportParamValues	= "";
		String sqlString			= "";
		String clinic_type			= "";
		String nursing_unit_code	= "";
		String perm_fs_locn_code	= "";
		reportParamNames			= (String)reportResults.get("reportParamNames");
		reportParamValues			= (String)reportResults.get("reportParamValues");
		sqlString					= (String)reportResults.get("sqlString");
		clinic_type					= (String)reportResults.get("clinictype");
		nursing_unit_code			= (String)reportResults.get("cliniccode");
		perm_fs_locn_code			= (String)reportResults.get("perm_fs_locn_code");
		String	callfunc			= (String)reportResults.get("callfunc");
		String error				= "";
		String error_value			= "0" ;
		//String callfunc             = req.getParameter("call_func");
		
		//Added By Santhosh for PMG2023-MOHE-CRF-0001
		boolean isDepositAmountAppl = false;
		Connection con				= null;
		try {
			con						= ConnectionManager.getConnection(req);
			isDepositAmountAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","GET_DEPOSIT_AMOUNT");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception on getConnection && isSiteSpecific=============="+e.toString());
		} finally {
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
		//End
		
		if(callfunc == null) callfunc = "";
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		/*htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
        htmlFor.append("</head><body class='message'>");
        htmlFor.append("<script language = 'JavaScript'>") ;*/
        htmlFor.append("  var dialogHeight    = '55vh' ;");
        htmlFor.append(" var dialogWidth = '45vw' ;");
        htmlFor.append("var dialogTop = 58;" );
        htmlFor.append("  var arguments =   ''; ");
		session.setAttribute("SQLSTRING_QUERYKEY",sqlString);
       
        //modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&sql_querykey=SQLSTRING_QUERYKEY&step=1&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&perm_fs_locn_code="+perm_fs_locn_code+"';");
        htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        htmlFor.append("  retVal            =  await window.showModalDialog(getUrl,arguments,features); ");
        //htmlFor.append(" </script>");
        error_value="1";
        out.println(htmlFor.toString());  
		/*out.println("</body></html>");
		out.println("<script language = 'JavaScript'>");*/
		
		String from_adv_bed_mgmt	= req.getParameter("from_adv_bed_mgmt")==null?"N":req.getParameter("from_adv_bed_mgmt");
		
		/*Below line Added for this CRF Bru-HIMS-CRF-261*/
		String quick_admission_type	= req.getParameter("quick_admission_type")==null?"":req.getParameter("quick_admission_type");
		String quick_adm=checkForNull(req.getParameter("quick_adm"));
		String ref_encounter_id=checkForNull(req.getParameter("ref_encounter_id"));
		
		
		
		if(callfunc.equals("ADMIT") && from_adv_bed_mgmt.equals("N"))
        {
/*
			if(message.lastIndexOf("<br>")>=0)
                error=message.substring(0,message.lastIndexOf("<br>"));
*/
          /*Below line Added for this CRF Bru-HIMS-CRF-261*/
          if(quick_admission_type.equals("Y") && quick_adm.equals("Quick_admission")){                        
			    String encStr="Encounter ID  ";
                encStr=encStr+eid;				
				String patient_id=(String)reportResults.get("p_patient_id");				  
                out.println("alert('"+encStr+"')");					
                out.println("parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+ref_encounter_id+"*"+patient_id+"*"+eid+"\" ;");					
				out.println("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");	
			}else{ 
				System.err.println("hi in 2002 servlet message ===================>"+message);
				System.err.println("hi in new issue 11=============================================================>");
				out.println("parent.frames[2].location.href =\"../eCommon/jsp/"+errorPage+"?err_value=1&err_num="+message+"\"; ");
				out.println("await new Promise(resolve => setTimeout(resolve, 500));");
				out.println("parent.location.href='../eIP/jsp/AdmitPatient.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit Patient&function_type=F&access=NYNNN';"); 
			}
        }
        else if(!callfunc.equals(""))
		{   
			/*Monday, November 22, 2010,Commented for 25164*/
			/*if(message.lastIndexOf("<br>")>=0)
                error=message.substring(0,message.lastIndexOf("<br>"));
            out.println("alert('"+error+"');parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");*/
			out.println("alert('"+message+"');parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
        }
        else
        {  
			//	System.err.println("hi in 2018 servlet error ===================>"+error);
				System.err.println("hi in new issue 12=============================================================>");
			out.println("parent.frames[2].location.href='../eCommon/jsp/"+errorPage+"?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value=1';");


        }
       /* out.println("</script>");
		*/

		reportResults.clear();
    }

    private String convertString(String val)
    {
      	/*if(val == null) val = "" ;
        if(!val.equals(""))
        {
            String dup_val = val ;
            int i = 0 ;
            StringBuffer stringbuffer = new StringBuffer(dup_val);
            for(int j = 0; dup_val.indexOf('\'', i) != -1; j++)
            {
                i = dup_val.indexOf('\'', i);
                stringbuffer.insert(i + j, "'");
                i++;
            }
            val = stringbuffer.toString() ;
        }
        return val ;
		*/
		if(val == null) val = "" ;
		 return val.replaceAll("'","''");
    }

	/**
	 * This method is used to validate the patient details
	 * @return	:   Hashtable
	 */
	private java.util.HashMap ValidateIPAdmitPatient	(HttpServletResponse res,
															java.util.Properties p,
															String facilityId,
															String practitioner,
															String speciality,
															String nursingunit,
															String roomno,
															String patientid,
															String bedno,
															String bedclass,
															String attd_practitioner,
															HttpServletRequest req,
															String age,
															String patientgender,
															String dateofbirth,
															String admissiondate
														) throws java.io.IOException
	{

		ResultSet srs				= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null ;
		ResultSet rset1				= null;
		ResultSet rset				= null;
		PrintWriter	out				= null;
		out							= res.getWriter();
		String locale				= p.getProperty("LOCALE");
		String L_current_gender		= "*";
		String blocked_yn			= "";
		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= true ;
		StringBuffer sb				= new StringBuffer("");
		StringBuffer sql			= new StringBuffer("");
		Connection con				= null;
		String nursingunittype		= "";
		String appl_patient_class	= "";
		String pseudo_bed_yn		= "N";

		try
		{
			con = ConnectionManager.getConnection(req);
			if(sql.length() > 0) sql.delete(0,sql.length());

			// Condition check if the patient to be admitted is already an inpatient or not ...
			sql.append(" select count(1) from IP_OPEN_ENCOUNTER where patient_id = '"+patientid+"' ");
			pstmt1 = con.prepareStatement(sql.toString());
			rset1 = pstmt1.executeQuery();
			if(rset1!=null && rset1.next())
			{
				if(rset1.getInt(1) != 0)
				{
					result = false;
					java.util.Hashtable message =MessageManager.getMessage(locale,"CURRENTLY_IN_PATIENT","IP");
					sb.append( (String) message.get("message")) ;
					message.clear();
				}
				else
					result=true;
			}
			if(rset1!=null) rset1.close();
			if(pstmt1!=null) pstmt1.close();

			/*
			start
			*/
				if(result){

					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("SELECT * FROM IP_PATIENT_LAST_ENCOUNTER WHERE  facility_id='"+facilityId+"' and PATIENT_ID='"+patientid+"' AND  DISCHARGE_DATE_TIME >= To_Date('"+admissiondate+"','dd/mm/yyyy hh24:mi')");
					if(pstmt1!=null) pstmt1.close();
					if(rset1!=null) rset1.close();



					pstmt1 = con.prepareStatement(sql.toString());
					rset1	  = pstmt1.executeQuery();
					if(rset1.next())
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"ADM_DT_GR_LST_DIS_DT","IP");
						sb.append( (String) message.get("message")) ;
						message.clear();

					}
					else
						result = true;
					if(rset1!=null) rset1.close();
					if(pstmt1!=null) pstmt1.close();

				}

			/*
			end
			*/

			// validations for RoomNo...IF bed is assigned then room cannot be blank..,
			if(result)
			{
				if(!bedno.equals("") && roomno.equals(""))
				{
					java.util.Hashtable room_message = MessageManager.getMessage(locale,"ROOM_CANT_BE_BLANK","IP");
					sb.append( (String) room_message.get("message"));
					room_message.clear();
					result = false;
				}
			}
			
			// Commented for PE By Sudhakar
			/*if(result)//this one can be removed
			{
				if(!nursingunit.equals(""))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select locn_code from am_os_user_locn_access_vw where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn where facility_id='"+facilityId+"' and appl_user_id ='"+fid+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) and APPL_USER_ID = '"+fid+"' and locn_type = 'N' AND (admit_pat_yn = 'Y' or ADMIT_PATIENT_WITH_BED_YN = 'Y') and LOCN_CODE = '"+nursingunit+"' ");
					if(pstmt!=null) pstmt.close();
					if(rset!=null) rset.close();
					pstmt = con.prepareStatement(sql.toString());
					srs	  = pstmt.executeQuery();

					if(!srs.next())
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"NURS_UNIT_NOT_DEFINED","IP");
						sb.append( (String) message.get("message")) ;
						message.clear();
					}
					if(srs!=null) srs.close();
				}
			}*/

			if(result)
			{
				//this one
				//Check for Valid nursing Unit -  Practitioner Admission Rights
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" Select '1' from IP_NURSING_UNIT_FOR_PRACT where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit +"' and practitioner_id='"+practitioner+"' ");
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
				if(!srs.next())
				{
					result = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ADMN_RIGHTS_DENIED","IP" );
					sb.append( (String) message.get("message")) ;
					message.clear();
				}
				if(srs!=null) srs.close();
			}

			if(result)
			{


				if(!attd_practitioner.equals(""))
				{
					//Check for Valid nursing Unit -  Practitioner Admission Rights
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" Select '1' from IP_NURSING_UNIT_FOR_PRACT where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit +"' and practitioner_id='"+attd_practitioner+"' ");
					if(pstmt!=null) pstmt.close();
					if(rset!=null) rset.close();
					pstmt=con.prepareStatement(sql.toString());
					srs = pstmt.executeQuery();
					if(!srs.next())
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage( locale,"PRACT_ADMN_RIGHTS_DENIED","IP" ) ;
						sb.append( (String) message.get("message")) ;
						message.clear();
					}
					if(srs!=null) srs.close();
				}
			}

			if(result)
			{


				//Check for Valid nursing Unit - Speciality Admission Rights
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" Select '1' from ip_nurs_unit_for_specialty a where a.facility_id='"+facilityId+"' and a.nursing_unit_code='"+nursingunit+"' and a.specialty_code='"+speciality+"' ");
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
				if(!srs.next())
				{
					result = false;
					java.util.Hashtable message = MessageManager.getMessage( locale,"SPLTY_ADMN_RIGHTS_DENIED","IP" ) ;
					sb.append( (String) message.get("message")) ;
					message.clear();
				}
				if(srs!=null) srs.close();
			}

			if(result)
			{


				//Checking for valid age group and gender
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT age_group_code, locn_type, appl_patient_class FROM IP_NURSING_UNIT WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit+"' ");
				if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
				if (srs.next())
				{
					String agegrpcode = checkForNull(srs.getString(1));
					nursingunittype = checkForNull(srs.getString(2));
					appl_patient_class = checkForNull(srs.getString("appl_patient_class"));
					if(!agegrpcode.equals(""))
					{
						StringBuffer ageGrpCodesql = new StringBuffer();
						ageGrpCodesql.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"'  And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
						if(pstmt!=null) pstmt.close();
						if(rset!=null) rset.close();
						pstmt=con.prepareStatement(ageGrpCodesql.toString());
						srs = pstmt.executeQuery();
						if(!srs.next())
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
							sb.append( (String) message.get("message")) ;
							message.clear();
						}
					}
				}
				if(srs!=null) srs.close();
			}

			if(result)
			{


				//Check for valid Bed
				if (!(bedno.equals("") || bedno == null ))
				{


					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" Select pseudo_bed_yn, occupying_patient_id, bed_type_code, bed_class_code, sex_spec_ind, room_no, specialty_code from IP_NURSING_UNIT_BED where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit+"' And bed_no='"+bedno+"' ");
					if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql.toString());

					srs = pstmt.executeQuery();
					if(!srs.next())
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_BED","Common");
						sb.append((String) message.get("message"));
						message.clear();
					}
					else
					{
						pseudo_bed_yn = checkForNull(srs.getString("pseudo_bed_yn"),"N");
						String occupyingpatientid = checkForNull(srs.getString("Occupying_Patient_Id"));
						String tabbedclasscode = checkForNull(srs.getString("bed_class_code"));
						String sex_spec_ind = checkForNull(srs.getString("sex_spec_ind"));
						String splty_code = checkForNull(srs.getString("specialty_code"));
						
						if (!occupyingpatientid.equals(""))
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else if(!tabbedclasscode.equals(bedclass))
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED_CLASS","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}else if ((!sex_spec_ind.equals("")) && (!patientgender.equals(sex_spec_ind)))
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else if (!splty_code.equals("") && !splty_code.equals(speciality)) //Added for specialty to bed validation
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						//Modified by Rajan for gender specific bed
					}
					if(srs!=null) srs.close();
				}
			}

			if(result)
			{
				//Checking for Blocked/Booked beds
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" Select booking_type, override_yn, patient_id from IP_BED_BOOKING WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+nursingunit+"' "+
				" and req_bed_no='"+bedno+"' and booking_status='0' AND sysdate between blocked_from_date_time and blocked_until_date_time ");
				if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
				if (srs.next())
				{
					String bookingtype = checkForNull(srs.getString(1));
					String overrideyn  = checkForNull(srs.getString(2));
					if(overrideyn.equals("") || overrideyn == null) overrideyn = "N";
					String patID  = checkForNull(srs.getString(3));
					if(overrideyn.equals("Y"))
					{
						blocked_yn  = "Y";

						if((!patID.equals("")) && (patID.equals(patientid)))
						{
							result = true;
						}
						else
						{
							if (bookingtype.equals("L"))
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG","IP");
								sb.append( (String) message.get("message")) ;
								message.clear();
							}
							else
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage( locale, "OVERRIDEABLE_BLOCKING","IP");
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
						}
					}
					else if(overrideyn.equals("N"))
					{
						if((!patID.equals("")) && (patID.equals(patientid)))
						{
							result = true;
						}
						else if (bookingtype.equals("L"))
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"BLOCKED_BED","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
				}
				if(srs!=null) srs.close();
			}

			if(result)
			{
				if (!(roomno.equals("") || roomno == null ))
				{
					//Checking for same sex in the room
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select a.occ_male_bed_count, a.occ_female_bed_count, a.occ_unknown_bed_count from ip_nursing_unit_room a, ip_nursing_unit b where a.facility_id='"+facilityId+"' and   a. nursing_unit_code='"+nursingunit+"' and  a.room_no='"+roomno+"' and  b.facility_id=a.facility_id and  b.nursing_unit_code=a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
					if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql.toString());
					srs = pstmt.executeQuery();
					if(srs.next())
					{
						int malebedcount  = srs.getInt(1);
						int femalebedcount = srs.getInt(2);
						int unknownbedcount = srs.getInt(3);
						if(malebedcount > 0)    L_current_gender = "M";
						else if(femalebedcount > 0) L_current_gender = "F";
						else if(unknownbedcount > 0) L_current_gender = "U";

						if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender))
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
					if(srs!=null) srs.close();
				}
			}
			
/*
			if(result)
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT Count(1) FROM IP_NURS_UNIT_FOR_SPECIALTY WHERE FACILITY_ID = '"+facilityId+"' AND NURSING_UNIT_CODE= '"+nursingunit+"' AND SPECIALTY_CODE = '"+speciality+"' ");
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql.toString());
				srs	  = pstmt.executeQuery();
				if(srs.next())
				{
					int nurSpclCount  = srs.getInt(1);
					if (nurSpclCount == 0)
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"IN_ROOM_ONLY_SAME_GENDER","IP");
						sb.append((String)message.get("message"));
						message.clear();
					}
				}
				if(srs!=null) srs.close();
				if(pstmt != null)     pstmt.close() ;
			}
*/
				if(pstmt != null)     pstmt.close() ;
				if(rset != null)      rset.close();
				if(pstmt1 != null)    pstmt1.close() ;
				if(rset1 != null)     rset1.close();
				if(srs != null)       srs.close();
		}
		catch(Exception e)
		{
			result  = false;
			sb.append( e.getMessage() +" Error in ValidateIPAdmitPatient " ) ;
			e.printStackTrace() ;
		}
		finally
		{
			try
			{
				if(pstmt != null)     pstmt.close() ;
				if(rset != null)      rset.close();
				if(pstmt1 != null)    pstmt1.close() ;
				if(rset1 != null)     rset1.close();
				if(srs != null)       srs.close();
				if(con != null)	ConnectionManager.returnConnection(con,p);
			}
			catch (Exception e)
			{
			e.printStackTrace();
			}
			
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "blocked_yn", blocked_yn ) ;
		results.put( "appl_patient_class", appl_patient_class ) ;
		results.put( "nursingunittype", nursingunittype ) ;
		results.put( "pseudo_bed_yn", pseudo_bed_yn ) ;
		return results ;
	}


	public Hashtable File_No_ExistsCall(HttpServletRequest req, HttpServletResponse res,String patientId, String facilityId, String callFrom,String assign_care_locn_code, Connection con)  throws Exception
	{  

		java.util.Properties p		= null;
		PrintWriter	out				= null;
		out							= res.getWriter();
		String fileCreateSql		=  "{call FILE_NO_EXISTS(?,?,?,?,?,?,?,?,?,?,?,?)}";
		String p_create_file_no_yn	= "N";
		Hashtable hashFILE_NO_EXISTS= new Hashtable();
		CallableStatement fileCreateCS = con.prepareCall(fileCreateSql);
            fileCreateCS.setString(1, patientId);
            fileCreateCS.setString(2, facilityId);
            fileCreateCS.setString(3, callFrom);
			fileCreateCS.setString(4, assign_care_locn_code);
            fileCreateCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
            fileCreateCS.registerOutParameter( 6,java.sql.Types.VARCHAR);
            fileCreateCS.registerOutParameter( 7,java.sql.Types.VARCHAR);
			fileCreateCS.registerOutParameter( 8,java.sql.Types.VARCHAR);
            fileCreateCS.registerOutParameter( 9,java.sql.Types.VARCHAR);
            fileCreateCS.registerOutParameter( 10,java.sql.Types.VARCHAR);
			fileCreateCS.registerOutParameter( 11,java.sql.Types.VARCHAR);
            fileCreateCS.registerOutParameter( 12,java.sql.Types.INTEGER);
		    try
			{
				fileCreateCS.execute();
				p_create_file_no_yn = fileCreateCS.getString(5);
				if(p_create_file_no_yn==null)p_create_file_no_yn="";
				hashFILE_NO_EXISTS.put("p_create_file_no_yn",p_create_file_no_yn);
 				String p_seperate_file_no_yn = fileCreateCS.getString(6);
                if(p_seperate_file_no_yn==null)p_seperate_file_no_yn="";
			    hashFILE_NO_EXISTS.put("p_seperate_file_no_yn",p_seperate_file_no_yn);
        		String p_pat_ser_grp_code = fileCreateCS.getString(7);
                if(p_pat_ser_grp_code==null)p_pat_ser_grp_code="";
		        hashFILE_NO_EXISTS.put("p_pat_ser_grp_code",p_pat_ser_grp_code);
				String p_mr_section_type = fileCreateCS.getString(8);
                if(p_mr_section_type==null)p_mr_section_type="";
					hashFILE_NO_EXISTS.put("p_mr_section_type",p_mr_section_type);
				String p_mr_section_code = fileCreateCS.getString(9);
                if(p_mr_section_code==null)p_mr_section_code="";
				hashFILE_NO_EXISTS.put("p_mr_section_code",p_mr_section_code);
				String p_single_or_multi_files_ind = fileCreateCS.getString(10);
                if(p_single_or_multi_files_ind==null)p_single_or_multi_files_ind="";
				hashFILE_NO_EXISTS.put("p_single_or_multi_files_ind",p_single_or_multi_files_ind);
				String p_error_message = fileCreateCS.getString(11);
                if(p_error_message==null)p_error_message="";
				hashFILE_NO_EXISTS.put("p_error_message",p_error_message);
			}
            catch(Exception e1)
			{
				e1.printStackTrace();
			}
            finally
			{
				if(fileCreateCS != null)fileCreateCS.close();
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}
		
		return hashFILE_NO_EXISTS;
     
	}//end of File_No_ExistsCall

	public HashMap onlineReports(HttpServletRequest req, HttpServletResponse res, String eid, String nursing_unit_code, String patient_age,String pat_ser_grp_code) throws ServletException, IOException, SQLException
	{  

        java.util.Properties p  = null;
		PrintWriter	out			= null;
		out						= res.getWriter();
		HttpSession session		= null;
		session           	    = req.getSession(false) ;
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		PreparedStatement pstmt = null;
		Connection con			= null;
		ResultSet rset			= null;
		con						= ConnectionManager.getConnection(req);
		String facilityId		= (String)session.getValue("facility_id") ;
		String locale			= p.getProperty("LOCALE");
		HashMap reportResults	= new HashMap();
		StringBuffer sqlString	= new StringBuffer();
		String clinic_type		= "N";
		String p_patient_id		= "";
		p_patient_id			= checkForNull(req.getParameter("patient_id"));
		String gen_file_no		= "";
		String booking_case_yn	= "";
		String pr_booking_ref_no= "";
		String age				= "";
		String wristBandLbl		= "";
		String pat_flag			= checkForNull(req.getParameter("pat_flag"),"N");
		try
		{
			
						
						
			
			 age			= patient_age ;
			if(age.indexOf("Y")>0)
			{
				age				= age.substring(0,age.indexOf("Y"));
				int n_Age		= 0;
				n_Age			= Integer.parseInt(age);

				if(n_Age <= 2)
				    wristBandLbl= "IPBWBLBL";
				else
					wristBandLbl= "IPBINWBL";
			}
			else
			{
				//wristBandLbl = "IPBINWBL";
				wristBandLbl    = "IPBWBLBL";
			}
		}
		catch(Exception repEx)
		{
			repEx.printStackTrace();
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
		}
		try
		{
			if(sqlString.length() > 0) sqlString.delete(0,sqlString.length());
			// Commented for PE - Changed to the query below using ip_open_encounter - on 12/05/2010
			//sqlString.append("select booking_case_yn,booking_ref_no from pr_encounter where encounter_id = '"+eid+"' and facility_id = '"+facilityId+"' ");
			sqlString.append(" SELECT booking_case_yn, booking_ref_no FROM ip_open_encounter WHERE encounter_id = '"+eid+"' AND facility_id = '"+facilityId+"' ");
			pstmt				= con.prepareStatement(sqlString.toString());
			rset				= pstmt.executeQuery();
			if(rset != null && rset.next())
			{
				booking_case_yn  = rset.getString("booking_case_yn");
				if(booking_case_yn == null) booking_case_yn = "N";
				pr_booking_ref_no= rset.getString("booking_ref_no");
				if(pr_booking_ref_no == null) pr_booking_ref_no = "";
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			//if(con!=null) con.close();
			if(con!=null) ConnectionManager.returnConnection(con,req);
		}

		// added MPBIDLBL on 11/23/2005
		if(sqlString.length() > 0) sqlString.delete(0,sqlString.length());

		if(pat_flag.equals("Y")) {
			sqlString.append(" SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report_lang_vw b WHERE a.module_id = 'IP' AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') UNION SELECT report_id, report_desc, no_of_copies, module_id FROM (SELECT DISTINCT a.report_id, b.report_desc, 1 no_of_copies, b.module_id, 1 orderby FROM mp_online_reports a, sm_report_lang_vw b, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' AND b.language_id = '"+locale+"' AND a.print_reqd_yn = 'Y' AND b.report_id = a.report_id AND a.report_id = c.report_id(+) AND NVL (c.facility_id, '"+facilityId+"') = '"+facilityId+"' AND a.report_id IN ('MPBIDLBL')) ORDER BY 2 ");

		} else {
			sqlString.append(" SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report_lang_vw b WHERE a.module_id = 'IP' AND b.language_id = '"+locale+"' AND b.internal_request_yn = 'Y' AND a.facility_id = '"+facilityId+"' AND a.print_on_admission_yn = 'Y' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.report_id = b.report_id AND a.report_id NOT IN ('"+wristBandLbl+"') ORDER BY 2 ");
			
		}		

		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_file_no";
		String reportParamValues = ""+eid+","+nursing_unit_code+","+clinic_type+","+p_patient_id+","+gen_file_no+"";
        
		reportResults.put("reportParamNames",reportParamNames);
		reportResults.put("reportParamValues",reportParamValues);
		reportResults.put("sqlString",sqlString.toString());
		reportResults.put("clinictype",clinic_type);
		reportResults.put("cliniccode",nursing_unit_code);
		reportResults.put("p_patient_id",p_patient_id);
		reportResults.put("gen_file_no",gen_file_no);
		reportResults.put("booking_case_yn",booking_case_yn);
		reportResults.put("booking_ref_no",pr_booking_ref_no);
		return reportResults;
	}

	private void futureOrder(HttpServletRequest req, HttpServletResponse res,String p_patient_class,String p_encounter_id, String p_episode_id,String p_episode_visit_num,String p_source_type, String p_source_code, String p_patient_id) throws java.io.IOException
	{
       

		PrintWriter	out			= null;
		HttpSession session		= null;
		session           	    = req.getSession(false) ;
		out						= res.getWriter();
		StringBuffer htmlFor = new StringBuffer();
		/*String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	    htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCA/js/CAMainCommonTasks.js'></script><script language=javascript src='../../eOR/js/FutureOrder.js'></script>	<script src='../../eCommon/js/common.js' language='javascript'></script>");
        htmlFor.append("</head><body class='message'>");
        htmlFor.append("<script language = 'JavaScript'>") ;*/
        htmlFor.append("  var dialogHeight    = '96vh' ;");
        htmlFor.append(" var dialogWidth = '48vw' ;");
        htmlFor.append("var dialogTop = 58;" );
        htmlFor.append("  var arguments =   ''; ");
        htmlFor.append("  var getUrl        =   '../../eOR/jsp/FutureOrderDtl.jsp?p_patient_class="+p_patient_class+"&p_encounter_id="+p_encounter_id+"&p_episode_id="+p_episode_id+"&p_episode_visit_num="+p_episode_visit_num+"&p_source_type="+p_source_type+"&p_source_code="+p_source_code+"&p_patient_id="+p_patient_id+"';");
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        htmlFor.append("  retVal            =  await top.window.showModalDialog(getUrl,arguments,features); ");
        /*htmlFor.append(" </script>");*/
        out.println(htmlFor.toString());  
		//out.println("</body></html>");

	}
	
	

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
