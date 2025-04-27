/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE ;
import java.sql.* ;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import eAE.RegisterAttendance.*;
import eBL.BLInsuranceImageBean;
import eBL.BLReportIdMapper;
import eBL.PkgApprovalBean;
import webbeans.eCommon.*;
import com.ehis.persist.PersistenceHelper;
import com.ehis.util.*;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import eCommon.XSSRequestWrapper;

public class AERegisterAttnServlet extends HttpServlet implements SingleThreadModel {


	String invoke_from	= "";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {

		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		
		Connection con				= null;
	//	String locale	            = "";
       	HttpSession session         = null;
		java.util.Properties p		= null;
		PrintWriter out;
		session           	        = req.getSession(false) ;
		out               	        = res.getWriter() ;
	    String  errors              = "";
		String  operation	        = "";
		//String  req_no	        = "";
		String	sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		try{
			con = ConnectionManager.getConnection(req);
			operation	= req.getParameter("operation");
			p    = (java.util.Properties) session.getValue( "jdbc" ) ;
	//		locale			     = p.getProperty("LOCALE");
			
			// code changed by Vedesh A D for Edge Conversion
    		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function callAERegAttnHTML() { ");
			
			
			
			
			if((operation==null) || (operation.equals("null")) || (operation=="") || (operation.equals("")))	operation	= "";
			invoke_from			= req.getParameter("invoke_from") == null ? "" : req.getParameter("invoke_from");
			if( req.getParameter("operation") !=null && req.getParameter("operation").equalsIgnoreCase("GENERATEFILE") )
			insertRegisterAttendance(req,res,con);
			else if( req.getParameter("operation") !=null && req.getParameter("operation").equalsIgnoreCase("RegisterAttendance") ) {
            insertRegisterAttendance(req,res,con);
			}
			else if( req.getParameter("operation") !=null && req.getParameter("operation").equalsIgnoreCase("online_report") )
            doOnlineReport(req,"",0,0,errors,sStyle,out);
			else if( req.getParameter("operation") !=null && req.getParameter("operation").equalsIgnoreCase("update_locn_code") )
            updateLocnCode(req,con);
			else if( req.getParameter("operation") !=null && req.getParameter("operation").equalsIgnoreCase("fmOnlineReport") )
            fmOnlineReport(req,res,out);
			out.println("} callAERegAttnHTML ();</script></body></html>");
		}  catch(Exception e) {
			e.printStackTrace();
		} finally {
			 if(con != null)  ConnectionManager.returnConnection(con,req);
		}

	} // Do post method ending here

	// InsertRegisterAttendance method starts here
	private void insertRegisterAttendance(HttpServletRequest req, HttpServletResponse res,Connection con) throws ServletException,IOException{			
			
			HttpSession session         = null;
			PrintWriter out;
			session           	        = req.getSession(false) ;
			PreparedStatement deceased_pstmt	= null;
			ResultSet deceased_rslt		=	null; 
			PreparedStatement pstmt		= null;
			PreparedStatement alr_cln_ext_pstmt	= null;
			ResultSet rs				= null;
			ResultSet all_rs				= null;
	        java.util.Properties p		= null;
			out               	        = res.getWriter() ;
	        java.util.HashMap results   = null;
			java.util.HashMap ae_values_arrival           = new HashMap();;
	        java.util.HashMap ae_values_related_contacts  = new HashMap();
	        java.util.HashMap ae_values_add_visit         = new HashMap();
			String location_code;
			String location_type;
			String speciality_code;
			String visit_type_code;
	        String episode_visit_no;
			String brought_dead_yn;
	        String ClinicCode;
	        String patFlag;
			String user_id;
			String client_ip_address;
		    String patient_id;
	        String generate_file;
			String sStyle;

        	String error ="";
	        String errors = "";
			String addedDate              ="";		
			String credit_doc_ref_desc    ="";
			String credit_doc_date        ="";
			String cust_code              ="";
			String slmt_type_code         ="";
			String slmt_doc_ref_desc      ="";
			String slmt_doc_ref_date      ="";
			String slmt_doc_remarks       ="";
			String bl_interface_yn        ="";
			String bl_install_yn          ="";
			String billing_group          ="";
			String billing_class          ="";
			String cash_set_type1         ="";
			String cash_insmt_ref1        ="";
			String cash_insmt_date1       ="";
			String cash_insmt_rmks1       ="";
			String cust_1                 ="";
			String credit_doc_ref1        ="";
			String credit_doc_date1       ="";
			String cust_2                 ="";
			String credit_doc_ref2        ="";
			String credit_doc_date2       ="";
			String cust_3                 ="";
			String policy_expiry_date     ="";
			String cash_set_type2         ="";
			String cash_insmt_ref2        ="";
			String cash_insmt_date2       ="";
			String cash_insmt_rmks2       ="";
			String credit_doc_ref3        ="";
			String credit_doc_date3       ="";
			String cred_start_dt1         ="";
			String cred_start_dt2	      ="";
			String cred_start_dt3	      ="";
			String gl_holder_name	      ="";
			String gl_holder_reln	      ="";
			String upd_user_flag          ="";
			String cred_start_dt          ="";
			String recordCnt              ="";
			String billing_mode           ="";
			String recordMode             ="";
			String modalText			  ="";
			String entitlement_by_cat_yn  ="";
			String status				  ="0";
            String practWorkingYN		  ="N";
	     //   String call_mp_pat_add_update ="N";//Flag for calling MP Procedure Monday, April 26, 2010 (venkat s) Contact deatisl proc change related modification
			String facilityId;
			String biometric_reason="";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			
			
            String contact1_birth_date   = "";
			String deceased_sql		=	"";
			String deceased_count	=	"";
			String alr_cln_ext	=	"";
			int alr_cln_ext_count	=0;
			String upt_contact_dtls_oa_yn="";//added changes  HSA-CRF-0226 [IN:050599]
			
		   //Below line added for this CRF GDOH-CRF-0129			
	       String assigncare_loctype_ind="";
	       String assigncare_locacode="";	
          //End GDOH-CRF-0129
		  
		   String priorityZone=""; //Added for this CRF ML-MMOH-CRF-0629

		   String form60_YN=""; //Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17

		   Boolean isInvokeUploadDocAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
		   Boolean resiAddMailAdd = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		   Boolean isMLCAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "MLC_DTLS");//Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023
		  	   
		   String function_name = eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//Added by Himanshu for AAKH-CRF-0175

			java.sql.Date credit_doc_date_d			= null;
			java.sql.Date slmt_doc_ref_date_d		= null;
			java.sql.Date policy_expiry_date_d		= null;
			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			String addedById                        = (String) session.getValue("login_user") ;
			facilityId							    = (String) session.getValue( "facility_id" ) ;
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			if(function_name.equals("01")) {
			biometric_reason							    = (String) session.getValue( "biometric_reason" ) ;
			session.removeAttribute("biometric_reason");
			}
			//Ends
			
			p									    = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address					    = p.getProperty("client_ip_address");
       		user_id	= (String)session.getValue("login_user") ;			
			
			String locale	            = "";			
			locale			     = p.getProperty("LOCALE");



			sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			int reccnt				 = 0;
			boolean local_ejbs       = false;

		try{

   			String visit_date_time = req.getParameter("visit_date_time")== null ?"":req.getParameter("visit_date_time");

			if(!visit_date_time.equals(""))visit_date_time=com.ehis.util.DateUtils.convertDate(visit_date_time,"DMYHMS",locale, "en");
			
			recordCnt			  =      req.getParameter("reccnt");
		    billing_mode		  =      req.getParameter("billing_mode");
		    addedDate			  =      dateFormat.format( new java.util.Date() ) ;
    		bl_interface_yn       =      req.getParameter("bl_interface_yn");
			bl_install_yn         = 	 req.getParameter("bl_install_yn");
			billing_group         = 	 req.getParameter("billing_group");
			billing_class         = 	 req.getParameter("billing_class");
			cash_set_type1        = 	 req.getParameter("cash_set_type1");
			cash_insmt_ref1       = 	 req.getParameter("cash_insmt_ref1");
			cash_insmt_date1      = 	 req.getParameter("cash_insmt_date1");
			cash_insmt_rmks1      = 	 req.getParameter("cash_insmt_rmks1");
			cust_1                = 	 req.getParameter("cust_1");
			credit_doc_ref1       = 	 req.getParameter("credit_doc_ref1");
			credit_doc_date1      = 	 req.getParameter("credit_doc_date1");
			cust_2                = 	 req.getParameter("cust_2");
			credit_doc_ref2       = 	 req.getParameter("credit_doc_ref2");
			credit_doc_date2      = 	 req.getParameter("credit_doc_date2");
			cust_3                = 	 req.getParameter("cust_3");
			policy_expiry_date    = 	 req.getParameter("policy_expiry_date");
			cash_set_type2        = 	 req.getParameter("cash_set_type2");
			cash_insmt_ref2       = 	 req.getParameter("cash_insmt_ref2");
			cash_insmt_date2      = 	 req.getParameter("cash_insmt_date2");
			cash_insmt_rmks2      = 	 req.getParameter("cash_insmt_rmks2");
			credit_doc_ref3       = 	 req.getParameter("credit_doc_ref3");
			credit_doc_date3      = 	 req.getParameter("credit_doc_date3");
			cred_start_dt1        = 	 req.getParameter("cred_start_dt1");
			cred_start_dt2	      = 	 req.getParameter("cred_start_dt2");
			cred_start_dt3	      = 	 req.getParameter("cred_start_dt3");
			gl_holder_name	      = 	 req.getParameter("gl_holder_name");
			gl_holder_reln	      = 	 req.getParameter("gl_holder_reln");
			gl_holder_name	      = 	 req.getParameter("gl_holder_name");
			gl_holder_reln	      = 	 req.getParameter("gl_holder_reln");
			upd_user_flag         = 	 req.getParameter("upd_user_flag");
			patFlag                 = req.getParameter("patFlag");
			patFlag				    = (patFlag == null)?"N":patFlag;
			patient_id				= req.getParameter("patient_id");
			patient_id				= (patient_id == null)?"":patient_id;
			
		String isAENextofKinchngAppl = req.getParameter("isAENextofKinchngAppl"); // added by mujafar for ML-MMOH-CRF-0632
		String patient_id1_val       = req.getParameter("patient_id1_val"); // added by mujafar for ML-MMOH-CRF-0632
			
		//Below line added for this CRF GDOH-CRF-0129
		assigncare_loctype_ind=(req.getParameter("assigncare_loctype_ind") == null) ? "" : req.getParameter("assigncare_loctype_ind");
		assigncare_locacode=(req.getParameter("assigncare_locacode") == null) ? "" : req.getParameter("assigncare_locacode");	
		//End this CRF GDOH-CRF-0129
		
		//Below line added for this CRF ML-MMOH-CRF-0629
		priorityZone=(req.getParameter("priorityZone") == null) ? "" : req.getParameter("priorityZone");
		//End this CRF ML-MMOH-CRF-0629

		//Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
		form60_YN			=  req.getParameter("form60_YN");
		if((form60_YN==null) || (form60_YN.equals("null")) || (form60_YN=="") || (form60_YN.equals(""))) 	
			form60_YN		= "";

			generate_file	= req.getParameter("generate_file");
			if(generate_file==null) generate_file="N";

			cred_start_dt  =(!cred_start_dt1.equals("") ) ? cred_start_dt1 : ((!cred_start_dt2.equals("")) ? cred_start_dt2 : ((!cred_start_dt3.equals("") ? cred_start_dt3 : "")));
			ClinicCode = req.getParameter("ClinicCode");
			if(ClinicCode == null) ClinicCode="";
			if (billing_mode==null) billing_mode="";
			if(gl_holder_name	==null) gl_holder_name	="";
			if(gl_holder_reln==null	) gl_holder_reln	="";
			if (user_id == null) user_id ="";
			if (upd_user_flag==null) upd_user_flag = "";
			if(bl_interface_yn==null) bl_interface_yn="";
			if(billing_group == null) billing_group="";
			if(billing_class == null) billing_class="";
			if(cash_set_type1 == null) cash_set_type1="";
			if(cash_insmt_ref1 == null) cash_insmt_ref1="";
			if(cash_insmt_date1 == null) cash_insmt_date1="";
			if(cash_insmt_rmks1 == null) cash_insmt_rmks1="";
			if(cust_1 == null) cust_1="";
			if(credit_doc_ref1 == null) credit_doc_ref1="";
			if(credit_doc_date1 == null) credit_doc_date1="";
			if(cust_2 == null) cust_2="";
			if(credit_doc_ref2 == null) credit_doc_ref2="";
			if(credit_doc_date2 == null) credit_doc_date2="";
			if(cust_3 == null) cust_3="";
			if(policy_expiry_date == null) policy_expiry_date="";
			if(cash_set_type2 == null) cash_set_type2="";
			if(cash_insmt_ref2 == null) cash_insmt_ref2="";
			if(cash_insmt_date2 == null) cash_insmt_date2="";
			if(cash_insmt_rmks2 == null) cash_insmt_rmks2="";
			if(credit_doc_ref3 == null) credit_doc_ref3="";
			if(credit_doc_date3 == null) credit_doc_date3="";
			if(!(credit_doc_ref1.equals(""))) credit_doc_ref_desc=credit_doc_ref1;
			if(!(credit_doc_ref2.equals(""))) credit_doc_ref_desc=credit_doc_ref2;
			if(!(credit_doc_ref3.equals(""))) credit_doc_ref_desc=credit_doc_ref3;
			if(!(credit_doc_date1.equals(""))) credit_doc_date=credit_doc_date1;
			if(!(credit_doc_date2.equals(""))) credit_doc_date=credit_doc_date2;
			if(!(credit_doc_date3.equals(""))) credit_doc_date=credit_doc_date3;
			if(!(cust_1.equals(""))) cust_code=cust_1;
			if(!(cust_2.equals(""))) cust_code=cust_2;
			if(!(cust_3.equals(""))) cust_code=cust_3;
			if(!(cash_set_type1.equals(""))) slmt_type_code=cash_set_type1;
			if(!(cash_set_type2.equals(""))) slmt_type_code=cash_set_type2;
			if(!(cash_insmt_ref1.equals(""))) slmt_doc_ref_desc=cash_insmt_ref1;
			if(!(cash_insmt_ref2.equals(""))) slmt_doc_ref_desc=cash_insmt_ref2;
			if(!(cash_insmt_date1.equals(""))) slmt_doc_ref_date=cash_insmt_date1;
			if(!(cash_insmt_date2.equals(""))) slmt_doc_ref_date=cash_insmt_date2;
			if(!(cash_insmt_rmks1.equals(""))) slmt_doc_remarks=cash_insmt_rmks1;
			if(!(cash_insmt_rmks2.equals(""))) slmt_doc_remarks=cash_insmt_rmks2;
		   upt_contact_dtls_oa_yn = req.getParameter("upt_contact_dtls_oa_yn");//added changes  HSA-CRF-0226 [IN:050599]
			location_code 			=  req.getParameter("location_code");
			location_code 			= (location_code == null)?"":location_code;
			location_type 			=  req.getParameter("location_type");
			location_type 			= (location_type == null)?"":location_type;
			speciality_code 		=  req.getParameter("speciality_code");
			speciality_code 		= (speciality_code == null)?"":speciality_code;
			visit_type_code 		=  req.getParameter("visit_type");
			if((visit_type_code==null) || (visit_type_code.equals("null")) || (visit_type_code=="") || (visit_type_code.equals(""))) 	visit_type_code		= "";
			episode_visit_no 		=  req.getParameter("episode_visit_no");
			episode_visit_no 		= (episode_visit_no == null)?"":episode_visit_no;
			entitlement_by_cat_yn 		=  req.getParameter("entitlement_by_cat_yn");
			entitlement_by_cat_yn 		= (entitlement_by_cat_yn == null)?"N":entitlement_by_cat_yn;
			brought_dead_yn			=  req.getParameter("brought_dead_yn");
			brought_dead_yn 		= (brought_dead_yn == null)?"N":brought_dead_yn;			
			if(!location_code.equals("")) {
			java.util.HashMap practWorkingHash =ifClinicWorkingYN(location_code,facilityId,con);
			practWorkingYN=(String)practWorkingHash.get("practWorkingYN");
			practWorkingHash.clear();
			}
			if(practWorkingYN==null) practWorkingYN="N";
			if(practWorkingYN.equals("Y")) {
		//	call_mp_pat_add_update = (req.getParameter("call_mp_pat_add_update") == null)?"N":req.getParameter("call_mp_pat_add_update"); Monday, April 26, 2010 (venkat s) Contact deatisl proc change related modification
			if(credit_doc_date!=null && (!(credit_doc_date.equals("")))) {// added on 8/25/2003 for billing changes //Added for Billing
				StringTokenizer stoken = new StringTokenizer(credit_doc_date,"/");
				String dd = stoken.nextToken();
				String mm = stoken.nextToken();
				String yyyy = stoken.nextToken();
				credit_doc_date = yyyy+"-"+mm+"-"+dd;
			}
			if(slmt_doc_ref_date!=null && (!(slmt_doc_ref_date.equals("")))) {
			StringTokenizer stoken1 = new StringTokenizer(slmt_doc_ref_date,"/");
			String dd = stoken1.nextToken();
			String mm = stoken1.nextToken();
			String yyyy = stoken1.nextToken();
			slmt_doc_ref_date = yyyy+"-"+mm+"-"+dd;
			}
			if(policy_expiry_date!=null && (!(policy_expiry_date.equals("")))) {
			StringTokenizer stoken2 = new StringTokenizer(policy_expiry_date,"/");
			String dd = stoken2.nextToken();
			String mm = stoken2.nextToken();
			String yyyy = stoken2.nextToken();
			policy_expiry_date = yyyy+"-"+mm+"-"+dd;
			}
			if(!(credit_doc_date.equals(""))) {
			credit_doc_date_d = java.sql.Date.valueOf(credit_doc_date) ;
			}
			if(!(slmt_doc_ref_date.equals(""))) {
			slmt_doc_ref_date_d = java.sql.Date.valueOf(slmt_doc_ref_date) ;
			}
			if(!(policy_expiry_date.equals("")))	{
			policy_expiry_date_d = java.sql.Date.valueOf(policy_expiry_date) ;
			}
			if ((recordCnt==null)||(recordCnt.equals(""))) recordCnt="0";
			reccnt = Integer.parseInt(recordCnt);
			if (reccnt>0)  recordMode="U";	else recordMode="I";
			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			ae_values_add_visit.put("bl_interface_yn", bl_interface_yn);
			ae_values_add_visit.put("bl_install_yn", bl_install_yn);
			ae_values_add_visit.put("visit_charge_stage",req.getParameter("visit_charge_stage")== null ?"":req.getParameter("visit_charge_stage"));
			ae_values_add_visit.put("billing_group", billing_group);

			ae_values_add_visit.put("package_bill_doc_type",req.getParameter("package_bill_doc_type")== null ?"":req.getParameter("package_bill_doc_type"));
			ae_values_add_visit.put("package_bill_doc_num",req.getParameter("package_bill_doc_num")== null ?"0":req.getParameter("package_bill_doc_num"));
			ae_values_add_visit.put("episode_status","");

			ae_values_add_visit.put("episode_type","E");
			ae_values_add_visit.put("recordMode",recordMode);
			ae_values_add_visit.put("bill_type_code","");

			if(bl_install_yn.equalsIgnoreCase("y")){

			HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
			if(fin_dtls!=null)
			ae_values_add_visit.put("fin_dtls",(HashMap)fin_dtls);

            //Added by prithivi on 06/04/2017 for bupa interface crf-0085
			String bean_id2		= "PkgApprovalBean" ;
			String bean_name2	= "eBL.PkgApprovalBean";
			PkgApprovalBean bean2		= (PkgApprovalBean)PersistenceHelper.getBeanObject( bean_id2, bean_name2, req ) ;
			HashMap  payerEligibilityDtlsMap=(HashMap)bean2.getPayerDtls();		
			ae_values_add_visit.put("PAYER_ELIGIBILITY_CHECK_MAP",payerEligibilityDtlsMap);

			}

			/*Added by Thamizh selvi on 16th Mar 2018 against ML-MM0H-CRF-645 Start*/
			String isCaseDtlsRadioBtnAppl	= checkForNull(req.getParameter("isCaseDtlsRadioBtnAppl"));
			String osccType					= checkForNull(req.getParameter("osccType"));
			String osccYn					= checkNullWithDftValue(req.getParameter("oscc_yn"), "N");
			String OandGYn					= checkNullWithDftValue(req.getParameter("OandG_yn"), "N");
			String mechInjCode				= "";
			String mechInjSubCode			= "";
		
			if(!("").equals(osccType)){
				StringTokenizer osccToken = new StringTokenizer(osccType, ",");
				if(osccToken.hasMoreTokens()){
					mechInjCode		= checkForNull(osccToken.nextToken());
					mechInjSubCode	= checkForNull(osccToken.nextToken());
				}
			}
			
			if(isCaseDtlsRadioBtnAppl.equals("true") && osccYn.equals("Y")){
				ae_values_add_visit.put("mech_injury_catg_code",mechInjCode);
				ae_values_add_visit.put("mech_injury_subcatg_code",mechInjSubCode);
			}else{
				ae_values_add_visit.put("mech_injury_catg_code",req.getParameter("mechan_injury")== null ?"":req.getParameter("mechan_injury"));
				ae_values_add_visit.put("mech_injury_subcatg_code",req.getParameter("injury")== null ?"":req.getParameter("injury"));
			}

			ae_values_add_visit.put("OandGYn",OandGYn);
			/*End*/

			ae_values_add_visit.put("pkg_serv_code",req.getParameter("pkg_serv_code")== null ?"":req.getParameter("pkg_serv_code"));
			ae_values_add_visit.put("base_qty",req.getParameter("base_qty")== null ?"0":req.getParameter("base_qty"));
			ae_values_add_visit.put("base_rate",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));

			ae_values_add_visit.put("base_charge_amt",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));
			ae_values_add_visit.put("gross_charge_amt",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));
			ae_values_add_visit.put("disc_amt",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));
			ae_values_add_visit.put("net_charge_amt",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));
			ae_values_add_visit.put("pat_base_qty",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));
			ae_values_add_visit.put("pat_base_rate",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));
			ae_values_add_visit.put("pat_serv_qty",req.getParameter("base_rate")== null ?"0":req.getParameter("base_rate"));
			ae_values_add_visit.put("pat_base_charge_amt",req.getParameter("pat_base_charge_amt")== null ?"0":req.getParameter("pat_base_charge_amt"));
			ae_values_add_visit.put("pat_gross_charge_amt",req.getParameter("pat_gross_charge_amt")== null ?"0":req.getParameter("pat_gross_charge_amt"));
			ae_values_add_visit.put("pat_disc_amt",req.getParameter("pat_disc_amt")== null ?"0":req.getParameter("pat_disc_amt"));

			ae_values_add_visit.put("pat_net_charge_amt",req.getParameter("pat_net_charge_amt")== null ?"0":req.getParameter("pat_net_charge_amt"));
			ae_values_add_visit.put("cust_base_qty",req.getParameter("cust_base_qty")== null ?"0":req.getParameter("cust_base_qty"));
			ae_values_add_visit.put("cust_base_rate",req.getParameter("cust_base_rate")== null ?"0":req.getParameter("cust_base_rate"));
			ae_values_add_visit.put("cust_serv_qty",req.getParameter("cust_serv_qty")== null ?"0":req.getParameter("cust_serv_qty"));
			ae_values_add_visit.put("cust_base_charge_amt",req.getParameter("cust_base_charge_amt")== null ?"0":req.getParameter("cust_base_charge_amt"));
			ae_values_add_visit.put("cust_gross_charge_amt",req.getParameter("cust_gross_charge_amt")== null ?"0":req.getParameter("cust_gross_charge_amt"));
			ae_values_add_visit.put("cust_disc_amt",req.getParameter("cust_disc_amt")== null ?"0":req.getParameter("cust_disc_amt"));
			ae_values_add_visit.put("cust_net_charge_amt",req.getParameter("cust_net_charge_amt")== null ?"0":req.getParameter("cust_net_charge_amt"));
			ae_values_add_visit.put("pkg_ins_pat_ind",req.getParameter("pkg_ins_pat_ind")== null ?"":req.getParameter("pkg_ins_pat_ind"));
			ae_values_add_visit.put("split_yn",req.getParameter("split_yn")== null ?"":req.getParameter("split_yn"));

			ae_values_add_visit.put("pkg_bill_doc_type",req.getParameter("pkg_bill_doc_type")== null ?"":req.getParameter("pkg_bill_doc_type"));
			ae_values_add_visit.put("pkg_bill_doc_num",req.getParameter("pkg_bill_doc_num")== null ?"0":req.getParameter("pkg_bill_doc_num"));
			ae_values_add_visit.put("day_type_code",req.getParameter("day_type_code")== null ?"":req.getParameter("day_type_code"));
			ae_values_add_visit.put("time_type_code",req.getParameter("time_type_code")== null ?"":req.getParameter("time_type_code"));
			ae_values_add_visit.put("disc_perc",req.getParameter("disc_perc")== null ?"0":req.getParameter("disc_perc"));
			ae_values_add_visit.put("addl_fctr",req.getParameter("addl_fctr")== null ?"1":req.getParameter("addl_fctr"));
			ae_values_add_visit.put("upd_user_flag",upd_user_flag);
			ae_values_add_visit.put("user_id",user_id);
			ae_values_add_visit.put("locale",locale);
			ae_values_add_visit.put("addedAtWorkstation",client_ip_address);	//billling addtion ends
			ae_values_add_visit.put("buildEpisodeRule",req.getParameter("buildEpisodeRule")== null ?"":req.getParameter("buildEpisodeRule"));
			ae_values_add_visit.put("patient_id",patient_id);
			ae_values_add_visit.put("referral_id",req.getParameter("referral_id")== null ?"":req.getParameter("referral_id"));
			ae_values_add_visit.put("nationality",req.getParameter("nationality")== null ?"":req.getParameter("nationality"));
			ae_values_add_visit.put("brought_dead_yn",brought_dead_yn);
			ae_values_add_visit.put("mlc_case_yn",req.getParameter("mlc_case_yn")== null ?"N":req.getParameter("mlc_case_yn"));
			ae_values_add_visit.put("mv_accident_yn",req.getParameter("mv_accident_yn")== null ?"N":req.getParameter("mv_accident_yn"));
			ae_values_add_visit.put("alternate_id",req.getParameter("hddaltid")== null ?"":req.getParameter("hddaltid"));
			ae_values_add_visit.put("expiry_date",req.getParameter("hddexpdate")== null ?"":req.getParameter("hddexpdate"));
			ae_values_add_visit.put("blood_group",req.getParameter("blood_group")== null ?"":req.getParameter("blood_group"));
			ae_values_add_visit.put("rh_factor",req.getParameter("rh_factor")== null ?"":req.getParameter("rh_factor"));
				
			/**	
			  The  below line is comment for Incident NO--028019 by Naga Srinivas on 5/Aug/11
				ae_values_add_visit.put("visit_date_time",req.getParameter("sysDateSer")== null ?"":req.getParameter("sysDateSer"));*/
			//The  below line is add for Incident NO--028019 by Naga Srinivas on 5/Aug/11
	//		ae_values_add_visit.put("visit_date_time",req.getParameter("visit_date_time")== null ?"":req.getParameter("visit_date_time"));
			ae_values_add_visit.put("visit_date_time",visit_date_time);
			ae_values_add_visit.put("location_code",location_code);
			ae_values_add_visit.put("location_type",location_type);
			ae_values_add_visit.put("speciality_code",req.getParameter("speciality_code")== null ?"":req.getParameter("speciality_code"));
			ae_values_add_visit.put("service_code",req.getParameter("service")== null ?"":req.getParameter("service"));
			ae_values_add_visit.put("visit_type_code",visit_type_code);
			ae_values_add_visit.put("visit_type_ind",req.getParameter("visit_type_ind")== null ?"E":req.getParameter("visit_type_ind"));
			ae_values_add_visit.put("sub_service",req.getParameter("sub_service")== null ?"":req.getParameter("sub_service"));
			ae_values_add_visit.put("sub_service_code",req.getParameter("sub_service")== null ?"":req.getParameter("sub_service"));
//Priority code............
			ae_values_add_visit.put("priority_no_code",req.getParameter("priority_no_code")== null ?"":req.getParameter("priority_no_code"));

			ae_values_add_visit.put("transport_mode",req.getParameter("transport_mode")== null ?"":req.getParameter("transport_mode"));
			ae_values_add_visit.put("mode_of_arrival",req.getParameter("mode_of_arrival")== null ?"":req.getParameter("mode_of_arrival"));
			ae_values_add_visit.put("priority",req.getParameter("hddpriority")== null ?"":req.getParameter("hddpriority"));
			//pat_critical_case_yn Added by Shanmukh for MMS-DM-CRF-0147
			ae_values_add_visit.put("pat_critical_case_yn",req.getParameter("pat_critical_case_yn")== null ?"N":req.getParameter("pat_critical_case_yn"));
			ae_values_add_visit.put("treat_area",req.getParameter("treat_area")== null ?"":req.getParameter("treat_area"));
			ae_values_add_visit.put("bed_bay_no",req.getParameter("bed_bay_no")== null ?"":req.getParameter("bed_bay_no"));
			ae_values_add_visit.put("disaster_yn",req.getParameter("Disaster_YN")== null ?"N":req.getParameter("Disaster_YN"));
			ae_values_add_visit.put("disaster_area",req.getParameter("disaster_area")== null ?"":req.getParameter("disaster_area"));
			ae_values_add_visit.put("disaster_type_code",req.getParameter("disaster_type")== null ?"":req.getParameter("disaster_type"));
//add
            ae_values_add_visit.put("dis_regn_reference",req.getParameter("disaster_Reference")== null ?"":req.getParameter("disaster_Reference"));
            ae_values_add_visit.put("presenting_problem_code",req.getParameter("presentingproblem_code")== null ?"":req.getParameter("presentingproblem_code"));


			ae_values_add_visit.put("new_episode_yn_val",req.getParameter("new_episode_yn_val")== null ?"N":req.getParameter("new_episode_yn_val"));
			ae_values_add_visit.put("new_episode_yn",req.getParameter("new_episode_yn_val")== null ?"N":req.getParameter("new_episode_yn_val"));
			ae_values_add_visit.put("episode_id",req.getParameter("episode_id")== null ?"":req.getParameter("episode_id"));
			if (!episode_visit_no.equals(""))ae_values_add_visit.put("episode_visit_no",episode_visit_no);
			else	ae_values_add_visit.put("episode_visit_no","1");
			ae_values_add_visit.put("res_tel_no",req.getParameter("contact1_no")== null ?"":req.getParameter("contact1_no"));

			ae_values_add_visit.put("oth_contact_no",req.getParameter("contact2_no")== null ?"":req.getParameter("contact2_no"));
			ae_values_add_visit.put("res_area_code",req.getParameter("res_area_code")== null ?"":req.getParameter("res_area_code"));
			ae_values_add_visit.put("res_town_code",req.getParameter("res_town_code")== null ?"":req.getParameter("res_town_code"));
			ae_values_add_visit.put("res_region_code",req.getParameter("res_region_code")== null ?"":req.getParameter("res_region_code"));
			ae_values_add_visit.put("email_id",req.getParameter("email")== null ?"":req.getParameter("email"));
			ae_values_add_visit.put("res_addr_line1",req.getParameter("addr_line1")== null ?"":req.getParameter("addr_line1"));
			ae_values_add_visit.put("res_addr_line2",req.getParameter("addr_line2")== null ?"":req.getParameter("addr_line2"));
			ae_values_add_visit.put("res_addr_line3",req.getParameter("addr_line3")== null ?"":req.getParameter("addr_line3"));
			ae_values_add_visit.put("res_addr_line4",req.getParameter("addr_line4")== null ?"":req.getParameter("addr_line4"));
			ae_values_add_visit.put("postal_code",req.getParameter("postals_code")== null ?"":req.getParameter("postals_code"));
			ae_values_add_visit.put("country_code",req.getParameter("country_code")== null ?"":req.getParameter("country_code"));

			ae_values_add_visit.put("mail_addr_line1",req.getParameter("mail_addr_line1")== null ?"":req.getParameter("mail_addr_line1"));
			ae_values_add_visit.put("mail_addr_line2",req.getParameter("mail_addr_line2")== null ?"":req.getParameter("mail_addr_line2"));
			ae_values_add_visit.put("mail_addr_line3",req.getParameter("mail_addr_line3")== null ?"":req.getParameter("mail_addr_line3"));
			ae_values_add_visit.put("mail_addr_line4",req.getParameter("mail_addr_line4")== null ?"":req.getParameter("mail_addr_line4"));
			ae_values_add_visit.put("mail_area_code",req.getParameter("mail_res_area_code")== null ?"":req.getParameter("mail_res_area_code"));
			ae_values_add_visit.put("mail_town_code",req.getParameter("mail_res_town_code")== null ?"":req.getParameter("mail_res_town_code"));
			ae_values_add_visit.put("mail_postal_code",req.getParameter("mail_postal_code")== null ?"":req.getParameter("mail_postal_code"));
			ae_values_add_visit.put("mail_region_code",req.getParameter("mail_region_code")== null ?"":req.getParameter("mail_region_code"));
			ae_values_add_visit.put("mail_country_code",req.getParameter("mail_country_code")== null ?"":req.getParameter("mail_country_code"));
		ae_values_add_visit.put("patient_valuables_rcdby",req.getParameter("patient_valuables_rcdby")== null ?"":req.getParameter("patient_valuables_rcdby"));
			ae_values_add_visit.put("patient_valuables_chkin_dtm",req.getParameter("patient_valuables_chkin_dtm")== null ?"":req.getParameter("patient_valuables_chkin_dtm"));
		ae_values_add_visit.put("patient_valuables_remarks",req.getParameter("patient_valuables_remarks")== null ?"":req.getParameter("patient_valuables_remarks"));
			ae_values_add_visit.put("enc_type",req.getParameter("enc_type")== null ?"E":req.getParameter("enc_type"));
			ae_values_add_visit.put("generate_file",generate_file);
			ae_values_add_visit.put("oper_stn_id",req.getParameter("oper_stn_id")== null ?"":req.getParameter("oper_stn_id"));
			ae_values_add_visit.put("sysDateWithoutTime",req.getParameter("sysDateWithoutTime")== null ?"":req.getParameter("sysDateWithoutTime"));
			ae_values_add_visit.put("open_to_all_pract_yn",req.getParameter("open_to_all_pract_yn")== null ?"N":req.getParameter("open_to_all_pract_yn"));
			ae_values_add_visit.put("facility_id",facilityId);
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			ae_values_add_visit.put("biometric_reason",biometric_reason);
			ae_values_add_visit.put("function_name",function_name);
			//Ends
			
			ae_values_add_visit.put("operating_facility_id",facilityId);
			ae_values_add_visit.put("added_by_id",addedById);
			ae_values_add_visit.put("added_date",added_date);
			ae_values_add_visit.put("added_facility_id", facilityId);
			ae_values_add_visit.put("added_at_ws_no",client_ip_address);
			ae_values_add_visit.put("modified_by_id",addedById);
			ae_values_add_visit.put("modified_date",added_date);
			ae_values_add_visit.put("modified_facility_id",facilityId);
			ae_values_add_visit.put("modified_at_ws_no",client_ip_address );
			//ae_values_add_visit.put("call_mp_pat_add_update",call_mp_pat_add_update); Monday, April 26, 2010 (venkat s) Contact deatisl proc change related modification
             ae_values_add_visit.put("upt_contact_dtls_oa_yn",upt_contact_dtls_oa_yn );//added changes  HSA-CRF-0226 [IN:050599]
			/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
			ae_values_add_visit.put("accidentdatetime",req.getParameter("accidentdatetime")== null ?"":req.getParameter("accidentdatetime"));
			ae_values_add_visit.put("place_of_accident",req.getParameter("place_of_accident")== null ?"":req.getParameter("place_of_accident"));
			ae_values_add_visit.put("vehicle_invol1",req.getParameter("vehicle_invol1")== null ?"":req.getParameter("vehicle_invol1"));
			ae_values_add_visit.put("vehicle_invol2",req.getParameter("vehicle_invol2")== null ?"":req.getParameter("vehicle_invol2"));

			//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
			ae_values_add_visit.put("Vehicle_Reg_No1",req.getParameter("Vehicle_Reg_No1")== null ?"":req.getParameter("Vehicle_Reg_No1"));
			ae_values_add_visit.put("Vehicle_Reg_No2",req.getParameter("Vehicle_Reg_No2")== null ?"":req.getParameter("Vehicle_Reg_No2"));
			ae_values_add_visit.put("PosDurInc",req.getParameter("PosDurInc")== null ?"":req.getParameter("PosDurInc"));
			/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
			
			/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
			ae_values_add_visit.put("followup_enc",req.getParameter("followup_enc")== null ?"":req.getParameter("followup_enc"));
			
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			ae_values_add_visit.put("practitioner_id",req.getParameter("practitioner_id")== null ?"":req.getParameter("practitioner_id"));
		
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/

			/*Added by Rameswar on 03-OCT-16 for GDOH-CRF-0004.2*/
		
			ae_values_add_visit.put("CaseofTrauma_val",req.getParameter("CaseofTrauma_val")== null ?"N":req.getParameter("CaseofTrauma_val"));
			ae_values_add_visit.put("oscc_yn",req.getParameter("oscc_yn")== null ?"N":req.getParameter("oscc_yn"));
			ae_values_add_visit.put("medical_yn",req.getParameter("medical_yn")== null ?"N":req.getParameter("medical_yn"));
			ae_values_add_visit.put("surgical_yn",req.getParameter("surgical_yn")== null ?"N":req.getParameter("surgical_yn"));
			//Commented below lines and added the code above for ML-MMOH-CRF-0645 by Thamizh selvi
			//ae_values_add_visit.put("mech_injury_catg_code",req.getParameter("mechan_injury")== null ?"":req.getParameter("mechan_injury"));
			//ae_values_add_visit.put("mech_injury_subcatg_code",req.getParameter("injury")== null ?"":req.getParameter("injury"));
			ae_values_add_visit.put("protective_device_code",req.getParameter("protective_device")== null ?"":req.getParameter("protective_device"));
			
			/*Added by Rameswar on 03-OCT-16 for GDOH-CRF-0004.2*/
			
			//Added for this CRF GDOH-CRF-0129
			ae_values_add_visit.put("assigncare_loctype_ind",assigncare_loctype_ind);
			ae_values_add_visit.put("assigncare_locacode",assigncare_locacode);		
			//End this CRF GDOH-CRF-0129
			
			//Below line added for this CRF ML-MMOH-CRF-0629
			ae_values_add_visit.put("priorityZone",priorityZone);
            //End ML-MMOH-CRF-0629			
			
			//Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
			ae_values_add_visit.put("form60_YN",form60_YN);
			/*Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 Start*/
			ae_values_add_visit.put("altAddrLine1",checkForNull(req.getParameter("alt_addr_line1")));
			ae_values_add_visit.put("altAddrLine2",checkForNull(req.getParameter("alt_addr_line2")));
			ae_values_add_visit.put("altAddrLine3",checkForNull(req.getParameter("alt_addr_line3")));
			ae_values_add_visit.put("altAddrLine4",checkForNull(req.getParameter("alt_addr_line4")));
			ae_values_add_visit.put("altTownCode",checkForNull(req.getParameter("alt_town_code")));
			ae_values_add_visit.put("altAreaCode",checkForNull(req.getParameter("alt_area_code")));
			ae_values_add_visit.put("altRegionCode",checkForNull(req.getParameter("alt_region_code")));
			ae_values_add_visit.put("altCountryCode",checkForNull(req.getParameter("alt_country_code")));
			ae_values_add_visit.put("altPostalCode",checkForNull(req.getParameter("alt_postal_code")));
			/*End*/
			/* Added by Ajay Hatwate for GHL-CRF-0650  */
//			ae_values_add_visit.put("mlc_dtl_yn",req.getParameter("mlc_dtl_yn") == null ? "N":req.getParameter("mlc_dtl_yn"));
			if(isMLCAppl){
			ae_values_add_visit.put("mlc_death_yn",req.getParameter("mlc_death") == null ? "N" : req.getParameter("mlc_death"));
			ae_values_add_visit.put("police_rep_no",checkForNull(req.getParameter("police_rep_no")));
			ae_values_add_visit.put("police_stn_dtls",checkForNull(req.getParameter("police_stn_dtls")));
			ae_values_add_visit.put("outside_mlc_dtls",checkForNull(req.getParameter("outside_mlc_dtls")));
			ae_values_add_visit.put("date_of_mlc_capture",checkForNull(req.getParameter("date_of_mlc_capture")));
			ae_values_add_visit.put("mlc_remarks",checkForNull(req.getParameter("mlc_remarks")));
			}
			ae_values_add_visit.put("isMLCAppl",isMLCAppl?"true":"false");
			/*END of GHL-CRF-0650*/
			ae_values_arrival.put("accompany_by",req.getParameter("accompany_by")== null ?"":req.getParameter("accompany_by"));
			ae_values_arrival.put("nat_id_no",req.getParameter("nat_id_no")== null ?"":req.getParameter("nat_id_no"));
			ae_values_arrival.put("name_of_escort",req.getParameter("name_of_escort")== null ?"":req.getParameter("name_of_escort"));
			ae_values_arrival.put("other_alt_id",req.getParameter("other_alt_id")== null ?"":req.getParameter("other_alt_id"));
			ae_values_arrival.put("oth_alt_id",req.getParameter("oth_alt_id")== null ?"":req.getParameter("oth_alt_id"));
			ae_values_arrival.put("relation_val",req.getParameter("relation_val")== null ?"":req.getParameter("relation_val"));
			ae_values_arrival.put("e_addr_line1",req.getParameter("e_addr_line1")== null ?"":req.getParameter("e_addr_line1"));
			ae_values_arrival.put("e_addr_line2",req.getParameter("e_addr_line2")== null ?"":req.getParameter("e_addr_line2"));
			ae_values_arrival.put("e_addr_line3",req.getParameter("e_addr_line3")== null ?"":req.getParameter("e_addr_line3"));
			ae_values_arrival.put("e_addr_line4",req.getParameter("e_addr_line4")== null ?"":req.getParameter("e_addr_line4"));
			ae_values_arrival.put("e_res_town_code",req.getParameter("m_town")== null ?"":req.getParameter("m_town"));
			ae_values_arrival.put("e_region_code",req.getParameter("m_region")== null ?"":req.getParameter("m_region"));
			ae_values_arrival.put("e_res_area_code",req.getParameter("m_area")== null ?"":req.getParameter("m_area"));
			ae_values_arrival.put("e_postal_code",req.getParameter("m_postal_code")== null ?"":req.getParameter("m_postal_code"));
			ae_values_arrival.put("e_country_desc",req.getParameter("e_country_desc")== null ?"":req.getParameter("e_country_desc"));
			ae_values_arrival.put("e_country_code",req.getParameter("e_country_code")== null ?"":req.getParameter("e_country_code"));
			ae_values_arrival.put("ambulance_contact_no",req.getParameter("ambulance_contact_no")== null ?"":req.getParameter("ambulance_contact_no"));
			ae_values_arrival.put("motor_vehicle_reg_no",req.getParameter("motor_vehicle_reg_no")== null ?"":req.getParameter("motor_vehicle_reg_no"));
			ae_values_arrival.put("arrival_remarks",req.getParameter("arrival_remarks")== null ?"":req.getParameter("arrival_remarks"));
			ae_values_related_contacts.put("isAENextofKinchngAppl",isAENextofKinchngAppl); // added by mujafar for ML-MMOH-CRF-0632
			ae_values_related_contacts.put("patient_id1_val",req.getParameter("patient_id1_val")== null ?"":req.getParameter("patient_id1_val")); // added by mujafar for ML-MMOH-CRF-0632
			ae_values_related_contacts.put("next_contact_name",req.getParameter("next_contact_name")== null ?"":req.getParameter("next_contact_name"));
			ae_values_related_contacts.put("next_contact_relation",req.getParameter("next_contact_relation")== null ?"":req.getParameter("next_contact_relation"));
			ae_values_related_contacts.put("contact1_new_nat_id_no",req.getParameter("contact1_new_nat_id_no")== null ?"":req.getParameter("contact1_new_nat_id_no"));
			ae_values_related_contacts.put("contact1_oth_alt_id_type",req.getParameter("contact1_oth_alt_id_type")== null ?"":req.getParameter("contact1_oth_alt_id_type"));
			ae_values_related_contacts.put("contact1_oth_alt_id_no",req.getParameter("contact1_oth_alt_id_no")== null ?"":req.getParameter("contact1_oth_alt_id_no"));
		    contact1_birth_date = req.getParameter("contact1_birth_date")== null ?"":req.getParameter("contact1_birth_date");
            contact1_birth_date = DateUtils.convertDate(contact1_birth_date,"DMY",locale,"en");
		    ae_values_related_contacts.put("contact1_birth_date",contact1_birth_date);
			ae_values_related_contacts.put("next_job_title",req.getParameter("next_job_title")== null ?"":req.getParameter("next_job_title"));
			ae_values_related_contacts.put("next_addr_line1",req.getParameter("next_addr_line1")== null ?"":req.getParameter("next_addr_line1"));
			ae_values_related_contacts.put("next_addr_line2",req.getParameter("next_addr_line2")== null ?"":req.getParameter("next_addr_line2"));
			ae_values_related_contacts.put("next_addr_line3",req.getParameter("next_addr_line3")== null ?"":req.getParameter("next_addr_line3"));
			ae_values_related_contacts.put("next_addr_line4",req.getParameter("next_addr_line4")== null ?"":req.getParameter("next_addr_line4"));
			ae_values_related_contacts.put("contact1_res_town_code",req.getParameter("n_town")== null ?"":req.getParameter("n_town"));
			ae_values_related_contacts.put("contact1_region_code",req.getParameter("n_region")== null ?"":req.getParameter("n_region"));
			ae_values_related_contacts.put("contact1_res_area_code",req.getParameter("n_area")== null ?"":req.getParameter("n_area"));
			ae_values_related_contacts.put("next_postal_code",req.getParameter("next_postal_code")== null ?"":req.getParameter("next_postal_code"));
			ae_values_related_contacts.put("next_country_desc",req.getParameter("next_country_desc")== null ?"":req.getParameter("next_country_desc"));
			ae_values_related_contacts.put("next_country_code",req.getParameter("next_country_code")== null ?"":req.getParameter("next_country_code"));
			ae_values_related_contacts.put("next_res_tel_no",req.getParameter("next_res_tel_no")== null ?"":req.getParameter("next_res_tel_no"));
			ae_values_related_contacts.put("contact1_mob_tel_no",req.getParameter("contact1_mob_tel_no")== null ?"":req.getParameter("contact1_mob_tel_no"));
			ae_values_related_contacts.put("next_off_tel_no",req.getParameter("next_off_tel_no")== null ?"":req.getParameter("next_off_tel_no"));
			ae_values_related_contacts.put("contact1_email_id",req.getParameter("contact1_email_id")== null ?"":req.getParameter("contact1_email_id"));
			ae_values_related_contacts.put("first_contact_name",req.getParameter("first_contact_name")== null ?"":req.getParameter("first_contact_name"));
			ae_values_related_contacts.put("first_contact_relation",req.getParameter("first_contact_relation")== null ?"":req.getParameter("first_contact_relation"));
			ae_values_related_contacts.put("contact2_nat_id_no",req.getParameter("contact2_nat_id_no")== null ?"":req.getParameter("contact2_nat_id_no"));
			ae_values_related_contacts.put("notify_oth_alt_id_type",req.getParameter("notify_oth_alt_id_type")== null ?"":req.getParameter("notify_oth_alt_id_type"));
		ae_values_related_contacts.put("notify_oth_alt_id_text",req.getParameter("notify_oth_alt_id_text")== null ?"":req.getParameter("notify_oth_alt_id_text"));
			ae_values_related_contacts.put("first_job_title",req.getParameter("first_job_title")== null ?"":req.getParameter("first_job_title"));
			ae_values_related_contacts.put("first_res_tel_no",req.getParameter("first_res_tel_no")== null ?"":req.getParameter("first_res_tel_no"));
			ae_values_related_contacts.put("contact2_mob_tel_no",req.getParameter("contact2_mob_tel_no")== null ?"":req.getParameter("contact2_mob_tel_no"));
			ae_values_related_contacts.put("first_off_tel_no",req.getParameter("first_off_tel_no")== null ?"":req.getParameter("first_off_tel_no"));
			ae_values_related_contacts.put("contact2_email_id",req.getParameter("contact2_email_id")== null ?"":req.getParameter("contact2_email_id"));
			ae_values_related_contacts.put("first_addr_line1",req.getParameter("first_addr_line1")== null ?"":req.getParameter("first_addr_line1"));
			ae_values_related_contacts.put("first_addr_line2",req.getParameter("first_addr_line2")== null ?"":req.getParameter("first_addr_line2"));
			ae_values_related_contacts.put("first_addr_line3",req.getParameter("first_addr_line3")== null ?"":req.getParameter("first_addr_line3"));
			ae_values_related_contacts.put("first_addr_line4",req.getParameter("first_addr_line4")== null ?"":req.getParameter("first_addr_line4"));
			ae_values_related_contacts.put("contact2_res_town_code",req.getParameter("f_town")== null ?"":req.getParameter("f_town"));
			ae_values_related_contacts.put("contact2_region_code",req.getParameter("f_region")== null ?"":req.getParameter("f_region"));
			ae_values_related_contacts.put("contact2_res_area_code",req.getParameter("f_area")== null ?"":req.getParameter("f_area"));
			ae_values_related_contacts.put("first_postal_code",req.getParameter("first_postal_code")== null ?"":req.getParameter("first_postal_code"));
			ae_values_related_contacts.put("first_country_desc",req.getParameter("first_country_desc")== null ?"":req.getParameter("first_country_desc"));
			ae_values_related_contacts.put("first_country_code",req.getParameter("first_country_code")== null ?"":req.getParameter("first_country_code"));
			ae_values_related_contacts.put("organization_name",req.getParameter("organization_name")== null ?"":req.getParameter("organization_name"));
			ae_values_related_contacts.put("empyr_contact_name",req.getParameter("empyr_contact_name")== null ?"":req.getParameter("empyr_contact_name"));
			ae_values_related_contacts.put("employ_addr_line1",req.getParameter("employ_addr_line1")== null ?"":req.getParameter("employ_addr_line1"));
			ae_values_related_contacts.put("employ_addr_line2",req.getParameter("employ_addr_line2")== null ?"":req.getParameter("employ_addr_line2"));
			ae_values_related_contacts.put("employ_addr_line3",req.getParameter("employ_addr_line3")== null ?"":req.getParameter("employ_addr_line3"));
			ae_values_related_contacts.put("employ_addr_line4",req.getParameter("employ_addr_line4")== null ?"":req.getParameter("employ_addr_line4"));
			ae_values_related_contacts.put("contact3_res_town_code",req.getParameter("e_town")== null ?"":req.getParameter("e_town"));
			ae_values_related_contacts.put("contact3_region_code",req.getParameter("e_region")== null ?"":req.getParameter("e_region"));
			ae_values_related_contacts.put("contact3_res_area_code",req.getParameter("e_area")== null ?"":req.getParameter("e_area"));
			ae_values_related_contacts.put("employ_postal_code",req.getParameter("employ_postal_code")== null ?"":req.getParameter("employ_postal_code"));
			ae_values_related_contacts.put("empyr_country_desc",req.getParameter("empyr_country_desc")== null ?"":req.getParameter("empyr_country_desc"));
			ae_values_related_contacts.put("empyr_country_code",req.getParameter("empyr_country_code")== null ?"":req.getParameter("empyr_country_code"));
			ae_values_related_contacts.put("res3_tel_no",req.getParameter("res3_tel_no")== null ?"":req.getParameter("res3_tel_no"));
			ae_values_related_contacts.put("empyr_off_tel_no",req.getParameter("empyr_off_tel_no")== null ?"":req.getParameter("empyr_off_tel_no"));
			ae_values_related_contacts.put("empyr_eid",req.getParameter("empyr_eid")== null ?"":req.getParameter("empyr_eid"));
			ae_values_related_contacts.put("occ_class",req.getParameter("occ_class")== null ?"":req.getParameter("occ_class"));
			ae_values_related_contacts.put("occ_of_per",req.getParameter("occ_of_per")== null ?"":req.getParameter("occ_of_per"));
			ae_values_related_contacts.put("occu_of_per_desc",req.getParameter("occu_of_per_desc")== null ?"":req.getParameter("occu_of_per_desc"));
		ae_values_related_contacts.put("empyr_employment_status",req.getParameter("empyr_employment_status")== null ?"":req.getParameter("empyr_employment_status"));

			//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			if(resiAddMailAdd){
            ae_values_related_contacts.put("n_next_addr_line1",req.getParameter("n_next_addr_line1")== null ?"":req.getParameter("n_next_addr_line1"));
			ae_values_related_contacts.put("n_ma_addr_line2",req.getParameter("n_ma_addr_line2")== null ?"":req.getParameter("n_ma_addr_line2"));
			ae_values_related_contacts.put("n_ma_addr_line3",req.getParameter("n_ma_addr_line3")== null ?"":req.getParameter("n_ma_addr_line3"));
			ae_values_related_contacts.put("n_ma_addr_line4",req.getParameter("n_ma_addr_line4")== null ?"":req.getParameter("n_ma_addr_line4"));
			ae_values_related_contacts.put("n_contact_ma_town_code",req.getParameter("nkma_town")== null ?"":req.getParameter("nkma_town"));
			ae_values_related_contacts.put("n_contac_region_code",req.getParameter("contact1_region")== null ?"":req.getParameter("contact1_region"));
			ae_values_related_contacts.put("n_contact_ma_area_code",req.getParameter("nkma_area")== null ?"":req.getParameter("nkma_area"));
			ae_values_related_contacts.put("n_ma_postal_code",req.getParameter("n_ma_postal_code")== null ?"":req.getParameter("n_ma_postal_code"));
			ae_values_related_contacts.put("nk_ma_country_desc",req.getParameter("nk_ma_country_desc")== null ?"":req.getParameter("nk_ma_country_desc"));
			ae_values_related_contacts.put("nkin_mail_country_code",req.getParameter("nkin_mail_country_code")== null ?"":req.getParameter("nkin_mail_country_code"));
			ae_values_related_contacts.put("nk_res_contact_name",req.getParameter("ra_contact_name")== null ?"":req.getParameter("ra_contact_name"));
			ae_values_related_contacts.put("nk_mail_contact_name",req.getParameter("ma_contact_name")== null ?"":req.getParameter("ma_contact_name"));

			ae_values_related_contacts.put("fton_mail_addr_line1",req.getParameter("fton_mail_addr_line1")== null ?"":req.getParameter("fton_mail_addr_line1"));
			ae_values_related_contacts.put("fton_mail_addr_line2",req.getParameter("fton_mail_addr_line2")== null ?"":req.getParameter("fton_mail_addr_line2"));
			ae_values_related_contacts.put("fton_mail_addr_line3",req.getParameter("fton_mail_addr_line3")== null ?"":req.getParameter("fton_mail_addr_line3"));
			ae_values_related_contacts.put("fton_mail_addr_line4",req.getParameter("fton_mail_addr_line4")== null ?"":req.getParameter("fton_mail_addr_line4"));
			ae_values_related_contacts.put("fst_to_no_ma_town_code",req.getParameter("contact2_res_town")== null ?"":req.getParameter("contact2_res_town"));
			ae_values_related_contacts.put("fst_to_no_ma_reg_cod",req.getParameter("contact2_region")== null ?"":req.getParameter("contact2_region"));
			ae_values_related_contacts.put("fst_to_no_ma_area_code",req.getParameter("contact2_res_area")== null ?"":req.getParameter("contact2_res_area"));
			ae_values_related_contacts.put("fst_no_ma_pos_cod",req.getParameter("fst_no_ma_pos_cod")== null ?"":req.getParameter("fst_no_ma_pos_cod"));
			ae_values_related_contacts.put("first_mail_country_desc",req.getParameter("first_mail_country_desc")== null ?"":req.getParameter("first_mail_country_desc"));
			ae_values_related_contacts.put("first_mail_country_code",req.getParameter("first_mail_country_code")== null ?"":req.getParameter("first_mail_country_code"));
			ae_values_related_contacts.put("fton_res_contact_name",req.getParameter("fton_ra_contact_name")== null ?"":req.getParameter("fton_ra_contact_name"));
			ae_values_related_contacts.put("fton_mail_contact_name",req.getParameter("fton_ma_contact_name")== null ?"":req.getParameter("fton_ma_contact_name"));

			ae_values_related_contacts.put("nk_contact3_mode",req.getParameter("nk_contact3_mode")== null ?"":req.getParameter("nk_contact3_mode"));
			ae_values_related_contacts.put("nk_contact3_no",req.getParameter("nk_contact3_no")== null ?"":req.getParameter("nk_contact3_no"));
			ae_values_related_contacts.put("nk_contact4_mode",req.getParameter("nk_contact4_mode")== null ?"":req.getParameter("nk_contact4_mode"));
			ae_values_related_contacts.put("nk_contact4_no",req.getParameter("nk_contact4_no")== null ?"":req.getParameter("nk_contact4_no"));
			ae_values_related_contacts.put("nk_contact5_mode",req.getParameter("nk_contact5_mode")== null ?"":req.getParameter("nk_contact5_mode"));
			ae_values_related_contacts.put("nk_contact5_no",req.getParameter("nk_contact5_no")== null ?"":req.getParameter("nk_contact5_no"));

			ae_values_related_contacts.put("fton_contact3_mode",req.getParameter("fton_contact3_mode")== null ?"":req.getParameter("fton_contact3_mode"));
			ae_values_related_contacts.put("fton_contact3_no",req.getParameter("fton_contact3_no")== null ?"":req.getParameter("fton_contact3_no"));
			ae_values_related_contacts.put("fton_contact4_mode",req.getParameter("fton_contact4_mode")== null ?"":req.getParameter("fton_contact4_mode"));
			ae_values_related_contacts.put("fton_contact4_no",req.getParameter("fton_contact4_no")== null ?"":req.getParameter("fton_contact4_no"));
			ae_values_related_contacts.put("fton_contact5_mode",req.getParameter("fton_contact5_mode")== null ?"":req.getParameter("fton_contact5_mode"));
			ae_values_related_contacts.put("fton_contact5_no",req.getParameter("fton_contact5_no")== null ?"":req.getParameter("fton_contact5_no"));
			}
            //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008


			if(entitlement_by_cat_yn.equals("Y"))
			{
			try
				{
				 pstmt=con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,to_char(sysdate,'dd/mm/yyyy'),?,?,?,'EM',?,'') from dual");
				 pstmt.setString(1,patient_id);
				 pstmt.setString(2,facilityId);
				 pstmt.setString(3,location_type);
				 pstmt.setString(4,location_code);
				 pstmt.setString(5,speciality_code);
				 rs=pstmt.executeQuery();
				 if(rs != null)
				  {
					 if(rs.next())
					  {
						status=rs.getString(1);
						if(status == null) status="";
					  }
				  }
				 if(pstmt != null) pstmt.close();
				 if(rs != null) rs.close();


				}catch(Exception e)
				{
				  e.printStackTrace();
				}
			}
// Saturday, May 08, 2010 venkat s
			//alr_cln_ext	="select count(*) from pr_encounter where patient_id = ? and facility_id = ? and TRUNC (visit_adm_date_time) = TRUNC (SYSDATE) and patient_class IN ('OP', 'EM')";
			alr_cln_ext	="SELECT count(*) FROM ae_current_patient  WHERE patient_id =?  AND facility_id =? and  queue_status < '07'    AND locn_code = ? ";
			
			alr_cln_ext_pstmt	=	con.prepareStatement(alr_cln_ext);
			alr_cln_ext_pstmt.setString(1,patient_id);
			alr_cln_ext_pstmt.setString(2,facilityId);
			alr_cln_ext_pstmt.setString(3,location_code);
			all_rs	=	alr_cln_ext_pstmt.executeQuery();	
				if (all_rs.next())
				{
				alr_cln_ext_count	=	all_rs.getInt(1);
				}
				if (alr_cln_ext_pstmt!=null) alr_cln_ext_pstmt.close();
				if (all_rs!=null) all_rs.close();
				if(alr_cln_ext_count>0)
				{					
					MessageManager mm = new MessageManager();
					final java.util.Hashtable message = mm.getMessage(locale, "OPEN_VST_STATUS_FOR_AE_CLINIC", "AE") ;
					String deceased_error = ((String) message.get("message"));					
					//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(deceased_error,"UTF-8");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(deceased_error,"UTF-8")+"&invoke_from="+invoke_from);
					message.clear();
				}else{


        if(status.equals("0"))
		{
			/*Restricting Duplicvation Insertion Through Following Piece Of Code Statrs Here */
			// Thursday, March 04, 2010 19744		
			deceased_sql	=	"select count(*) from pr_encounter where patient_id = ? and ( brought_dead_yn = 'Y'or deceased_date_time is not null ) and visit_status != '99' and facility_id = '"+facilityId+"'";
			deceased_pstmt	=	con.prepareStatement(deceased_sql);						deceased_pstmt.setString(1,patient_id);
			deceased_rslt	=	deceased_pstmt.executeQuery();	
			if (deceased_rslt.next())
			deceased_count	=	deceased_rslt.getString("count(*)");
			
			if (deceased_count.equals("0"))
			{
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RegisterAttendance",RegisterAttendanceHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = ae_values_add_visit;
			argArray[2] = ae_values_arrival;
			argArray[3] = ae_values_related_contacts;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = ae_values_add_visit.getClass();
			paramArray[2] = ae_values_arrival.getClass();
			paramArray[3] = ae_values_related_contacts.getClass();
			results = (java.util.HashMap)(busObj.getClass().getMethod("insertRegisterAttendance",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;

			//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
			if (inserted)
			{
				if(isInvokeUploadDocAppl)
				{
					String encounter_id = (String)results.get("encounter_id");

					int ins_count = eMP.MPCommonBean.getInsuranceCount(con,encounter_id,patient_id);

					if(ins_count > 0)
					{

					String htmlFor = "var dialogHeight = '40vh'; var dialogWidth = '70vw'; var arguments = ''; var getUrl = '../eMP/jsp/MPUploadDocument.jsp?function_id="
						+ "UPLOAD_DOC"
						+ "&patient_id="
						+ patient_id
						+ "&encounter_id="
						+ encounter_id
						+ "'; var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll = auto; status = no;' ; var retVal = await window.showModalDialog(getUrl,arguments,features);	";

					out.println(htmlFor);

					}
				}
			}
			
			if(inserted == false) {
			error = (String) results.get("error") ;
     		out.println("parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+ "<br>';");
			}  else {

					if(bl_install_yn.equals("Y")) {
						//added for billing interface on 8/27/2003
						String billdoctype = (String) results.get("billdoctype") ;
						String billdocnum = (String) results.get("billdocnum");
						String billgenlater = (String) results.get("billgenlater");
						String billAlreadyPrinted = "N";
						//String billtotalamt = (String) results.get("billtotalamt");

						String str_bill_prt_format_YN = (String) results.get("bill_prt_format_YN");	
						String str_bill_prt_format_vals = (String) results.get("bill_prt_format_vals");	
						if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";
						if(str_bill_prt_format_vals==null || (("null").equals(str_bill_prt_format_vals))) str_bill_prt_format_vals="";
						
						if(str_bill_prt_format_YN.equals("Y") && !(("").equals(str_bill_prt_format_vals)))
						{
							try
							{
								String pgm_id = (String) results.get("pgm_id");	
								if(pgm_id == null) pgm_id="";
								String session_id = (String) results.get("session_id");	
								if(session_id == null) session_id="";
								String pgm_date = (String) results.get("pgm_date");	
								if(pgm_date == null) pgm_date="";
								String mpi_id_rep = (String) results.get("mpi_id_rep");	
								if(mpi_id_rep == null) mpi_id_rep="";
								
								
								
								
								
								String reportId="BLRBLPRT";
								

								try{
									/* BLReportIdMapper.getReportId function used in other modules also
									 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
									 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
									 * eMP - PatientRegistrationServlet.java
									 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
									 */
									reportId=BLReportIdMapper.getReportId(con, locale,reportId, facilityId); //Added facilityId By Subha for MMS-DM-CRF-131.1
									System.out.println("AERegisterAttnServlet for Report ID "+reportId);
									
								}catch(Exception e)
								{
									e.printStackTrace();
									reportId="BLRBLPRT";
									System.err.println("Exception in AERegisterAttnServlet for reportID "+e);
								}
								
								
								/*Added by Rajesh V for ML-MMOH-CRF-0753*/
								PreparedStatement pstmtBill = null;;
								ResultSet rsBill = null;
								Boolean printRequired = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_NOT_REQD");
								String bill_print_reqd = "";
								int docNum = 0;
								if(printRequired){
									try{
										pstmtBill = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
										docNum = Integer.parseInt(billdocnum);
										pstmtBill.setString(1,facilityId);							
										pstmtBill.setString (2,billdoctype);
										pstmtBill.setInt(3,docNum);
										rsBill = pstmtBill.executeQuery();
										 if(rsBill != null && rsBill.next()){
											 bill_print_reqd = rsBill.getString(1);
										   }
										 if("Y".equals(bill_print_reqd)) {
											 OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
												onlinereportParam.addParameter("p_facility_id",facilityId);
												onlinereportParam.addParameter("p_pgm_date",pgm_date);
												onlinereportParam.addParameter("p_pgm_id",pgm_id);
												onlinereportParam.addParameter("p_Session_id",session_id);
												OnlineReports onlinereports = new OnlineReports();
												onlinereports.add(onlinereportParam);
												onlinereports.execute(req,res);//added for checkStyle by Munisekhar
												//String strResults =onlinereports.execute(req,res);//commented for checkStyle by Munisekhar

												onlinereportParam = null;
												onlinereports = null;	
												billAlreadyPrinted = "Y";
										}
										}
										 catch (Exception e) {
												e.printStackTrace();
											}
											finally{
												pstmtBill = null;
												rsBill = null;
											}
								}
								else{
									OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
									onlinereportParam.addParameter("p_facility_id",facilityId);
									onlinereportParam.addParameter("p_pgm_date",pgm_date);
									onlinereportParam.addParameter("p_pgm_id",pgm_id);
									onlinereportParam.addParameter("p_Session_id",session_id);
									OnlineReports onlinereports = new OnlineReports();
									onlinereports.add(onlinereportParam);
									onlinereports.execute(req,res);//added for checkStyle by Munisekhar
									//String strResults =onlinereports.execute(req,res);//commented for checkStyle by Munisekhar

									onlinereportParam = null;
									onlinereports = null;	
								}
								/*Added by Rajesh V for ML-MMOH-CRF-0753*/
															
							}
							catch (Exception e)
							{   e.printStackTrace();
								System.err.println("Error while submitting Print Job to Report Server:"+e);
							}
						}


						StringBuffer htmlFor1 = new StringBuffer();
						//Added by Rajesh V
						String restrictFlag = BLReportIdMapper.windowCloseRestrict(facilityId);
						//Added by Rajesh V
/*
						htmlFor1.append("<html><head> <link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
						htmlFor1.append("</head><body class='message'><script language = 'JavaScript'>var dialogHeight= '40';var dialogWidth = '70' ; var dialogTop = '100' ;var center    = '1' ;var arguments =   ''; ");
						htmlFor1.append("if(parent.frames[1].document.frames[2].checkingBL()) { ");
						if(brought_dead_yn.equals("Y"))  {
							htmlFor1.append("  var getUrl  = '../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode="+billdoctype+"&billdocnum="+billdocnum+"&blnggrp="+billing_group+"';");
						} else  {
							htmlFor1.append("  var getUrl  = '../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode="+billdoctype+"&billdocnum="+billdocnum+"&blnggrp="+billing_group+"';");
						}
						htmlFor1.append("  var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ;");
						htmlFor1.append("  retVal = window.showModalDialog(getUrl,arguments,features); ");
						htmlFor1.append(" parent.frames[1].document.frames[2].setBL(); }</script>");
						htmlFor1.append(" </body></html>");
						if(bl_interface_yn.equals("Y")) {
							out.println(htmlFor1.toString());
						}
*/
						htmlFor1.append("var billdoctype='"+billdoctype+"'; var billdocnum='"+billdocnum+"'; var arr = new Array();var dialogHeight= '90vh';var dialogWidth = '90vw' ; var dialogTop = '10' ;var center    = '1' ;var arguments =   ''; ");
						htmlFor1.append("  var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ;");
						//htmlFor1.append("if(parent.frames[1].document.frames[2].checkingBL()) { ");
						htmlFor1.append("if(parent.f_query_add_mod.patientDetailsFrame.checkingBL()) { ");
						if(brought_dead_yn.equals("Y"))  {
							htmlFor1.append(" var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="+patient_id+"&episode_type=E"+"&episode_id="+(String)results.get("episode_id")+"&visit_id="+(String)results.get("episode_visit_no")+"&encounter_id="+(String)results.get("encounter_id")+"&locn_code="+location_code+"&billgenlater="+ billgenlater+"&function_id=VISIT_REGISTRATION&module_id=AE"+"&visit_type_code="+ visit_type_code+"&blnggrp="+billing_group+"&called_frm=OTH_MOD';");
							htmlFor1.append("if('"+billgenlater+"' == 'Y') {  var retVal; ");
							//Added by Rajesh V
							htmlFor1.append(" if('"+restrictFlag+"' == 'Y'){ ");
							htmlFor1.append(" do{ retVal  =await window.showModalDialog(getUrl,arguments,features); }while(retVal == undefined || retVal == 'undefined');");
							htmlFor1.append(" } else{ ");
							htmlFor1.append(" retVal =await window.showModalDialog(getUrl,arguments,features); ");
							htmlFor1.append(" } ");
							//Added by Rajesh V
							htmlFor1.append("if(retVal == undefined || retVal == 'undefined') { retVal = '';} if(retVal != ''){ arr = retVal.split('|'); billdoctype = arr[0];billdocnum  = arr[1];}}");
							htmlFor1.append("  var getUrl1  = '../../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode='+billdoctype+'&billdocnum='+billdocnum+'&blnggrp="+billing_group+"&billgenlater="+billgenlater+"&billAlreadyPrinted="+billAlreadyPrinted+"';");
						} else  {
							htmlFor1.append(" var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="+patient_id+"&episode_type=E"+"&episode_id="+(String)results.get("episode_id")+"&visit_id="+(String)results.get("episode_visit_no")+"&encounter_id="+(String)results.get("encounter_id")+"&locn_code="+location_code+"&billgenlater="+ billgenlater+"&function_id=VISIT_REGISTRATION&module_id=AE"+"&visit_type_code="+ visit_type_code+"&blnggrp="+billing_group+"&called_frm=OTH_MOD';");
							htmlFor1.append("if('"+billgenlater+"' == 'Y') {  var retVal; ");
							//Added by Rajesh V
							htmlFor1.append(" if('"+restrictFlag+"' == 'Y'){ ");
							htmlFor1.append(" do{ retVal =await window.showModalDialog(getUrl,arguments,features); }while(retVal == undefined || retVal == 'undefined');");
							htmlFor1.append(" } else{ ");
							htmlFor1.append(" retVal =await window.showModalDialog(getUrl,arguments,features); ");
							htmlFor1.append(" } ");
							//Added by Rajesh V
							htmlFor1.append("if(retVal == undefined || retVal == 'undefined') { retVal = '';} if(retVal != ''){ arr = retVal.split('|'); billdoctype = arr[0];billdocnum  = arr[1];}}");
							htmlFor1.append("  var getUrl1  = '../../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode='+billdoctype+'&billdocnum='+billdocnum+'&blnggrp="+billing_group+"&billgenlater="+billgenlater+"&billAlreadyPrinted="+billAlreadyPrinted+"';");
						}

						htmlFor1.append("  retVal =await window.showModalDialog(getUrl1,arguments,features); ");
						htmlFor1.append(" parent.f_query_add_mod.patientDetailsFrame.setBL(); }");

						if(bl_interface_yn.equals("Y")) {
							out.println(htmlFor1.toString());
						}
					}
				}
             if(inserted) {
					if(brought_dead_yn.equals("N")) {
						errors = (String) results.get("ResultFromMessageManager") ;
	       					if(results.get("Prompt")!= null)  {
							modalText = (String) results.get("Prompt");
							out.println(modalText + error );
						} else  {
							if(results.get("outputLocnVal")!= null){
								String outputLocnVal = (String) results.get("outputLocnVal");
								out.println(outputLocnVal );
							}
							String encounter_id=(String)results.get("encounter_id");
                           	MessageManager mm = new MessageManager();
							final java.util.Hashtable mesg = mm.getMessage(locale, "AE_VISIT_REG_COMPLETE", "AE") ;
							String msg = ((String) mesg.get("message"));
							error =error + msg + "   " + "<B><font size=4>"+encounter_id+"</font></B>. ";
                            mesg.clear();
          					}
	       					session.removeAttribute("classTypChangeAuthYnPatId");
	       					session.removeAttribute("str_clinic_code");
					}// Brought dead condition ends here
					else 	{
						String encounter_id=(String)results.get("encounter_id");
						errors = (String) results.get("error") ;
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale, "AE_VISIT_REG_COMPLETE", "AE") ;
						String msg = ((String) mesg.get("message"));
						errors =errors + msg + "   " + "<B><font size=4>"+encounter_id+"</font></B>. ";
                        mesg.clear();
                        session.removeAttribute("classTypChangeAuthYnPatId");
                        session.removeAttribute("str_clinic_code");
					}}// if loop ends here
				else{
					
					errors = (String) results.get("error") ;
					//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" ) );
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+"&invoke_from="+invoke_from);
				}
				//Adding file generation logic here
				if (inserted)    {
					/*Added for the CRF - MMS-QH-CRF-0066 - start*/
				if(bl_install_yn.equals("Y")) {
					try
					{
						String bean_id		= "bl_blinsuranceimagebean" ;
						String bean_name	= "eBL.BLInsuranceImageBean";
						BLInsuranceImageBean bean = (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
						bean.insertInsuranceDBvalues(patient_id);  
					}
					catch(Exception e)
					{
						System.out.println("Exception while calling BLInsuranceImageBean:::: "+e);
						e.printStackTrace();
					}
				}
				/*Added for the CRF - MMS-QH-CRF-0066 - End*/
				generateFile(req,error,errors,results,sStyle,out,con);

				ae_values_add_visit.clear();
				ae_values_arrival.clear();
				ae_values_related_contacts.clear();
				results.clear();
				session.removeAttribute("financial_details");
			}else  {// check here.
				errors = (String) results.get("error") ;
				//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" ) );
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+"&invoke_from="+invoke_from);
			}

		 }
		 else
			{
			 // Thursday, March 04, 2010 19744
			MessageManager mm = new MessageManager();
			final java.util.Hashtable message = mm.getMessage(locale, "VISIT_ALRDY_REGISTERED", "AE") ;
			String deceased_error = ((String) message.get("message"));
			//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(deceased_error));
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(deceased_error)+"&invoke_from="+invoke_from);
			message.clear();
			}
			 	if (deceased_pstmt!=null) deceased_pstmt.close();
				if (deceased_rslt!=null) deceased_rslt.close();
			/*Restricting Duplicvation Insertion Through Above  Piece Of Code Ends  Here   End 19744*/

		}
		 else if(status.equals("1"))
		 {
			MessageManager mm = new MessageManager();
		    final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_CAT_EXP", "MP") ;
 	        String msg = ((String) mesg.get("message"));
			//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") );
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8")+"&invoke_from="+invoke_from );
		    mesg.clear();
		 }
		 else if(status.equals("2"))
		 {
			MessageManager mm = new MessageManager();
		    final java.util.Hashtable mesg = mm.getMessage(locale, "LOC_NOT_ENTITLED", "MP") ;
 	        String msg = ((String) mesg.get("message"));
			//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") );
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8")+"&invoke_from="+invoke_from);
		    mesg.clear();
		 }else if(status.equals("3"))
		 {
			MessageManager mm = new MessageManager();
		    final java.util.Hashtable mesg = mm.getMessage(locale, "SPL_NOT_ENTITLED", "MP") ;
 	        String msg = ((String) mesg.get("message"));
			//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") );
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8")+"&invoke_from="+invoke_from);
		    mesg.clear();
		  }else if(status.equals("4"))
		  {
			MessageManager mm = new MessageManager();
		    final java.util.Hashtable mesg = mm.getMessage(locale, "BDCL_NOT_ENTITLED", "MP") ;
 	        String msg = ((String) mesg.get("message"));
			//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") );
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8")+"&invoke_from="+invoke_from);
		    mesg.clear();
			}
			}
			}
		else  {// check here.
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "CLINIC_NOT_WORK", "OP") ;
				String msg = ((String) mesg.get("message"));
				//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") );
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8")+"&invoke_from="+invoke_from);
				mesg.clear();
			}
	
	}//try block ends here
	catch(Exception e){
			//out.println("From Servlet:"+e);
			System.out.println("Exception------------>"+e);
			e.printStackTrace();
	}   finally {
			 //if(con != null)  ConnectionManager.returnConnection(con,req);
			 //session.setAttribute("financial_details","");
	}
} // End of the insertRegisterAttendance


    public void generateFile(HttpServletRequest req,String error,String errors,java.util.HashMap results,String sStyle,PrintWriter out,Connection con) throws ServletException,IOException,SQLException {			
		HttpSession session         = null;
		session           	        = req.getSession(false) ;
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		String addedById            = (String)session.getValue("login_user") ;
		String facilityId			= (String) session.getValue( "facility_id" ) ;
		String patient_id			= req.getParameter("patient_id");
			patient_id				= (patient_id == null)?"":patient_id;
		String online_mr_notfn_yn   = "";
		String mr_location_code     = "";

		String locale	            = "";
		java.util.Properties p		= null;
		p    = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale			     = p.getProperty("LOCALE");

		try{
						
						String createFileAtReg			="";
				        String maintain_doc_or_file		="";
			            String encounter_date			="";
			            String p_separate_file_no_yn	="";
					    String single_or_multi_files_ind="";
						String mr_section_code          ="";
						String mr_section_type          ="";
						String p_status                 ="";
						String pat_ser_grp_code			="";
						String p_create_file_no_yn      ="";
						String p_error_message			="";
						String location_code 			=  req.getParameter("location_code");
			            location_code 					= (location_code == null)?"":location_code;
						String location_type			=  req.getParameter("location_type");
			            location_type 					= (location_type == null)?"":location_type;
						String visit_type_code			=  req.getParameter("visit_type");
			            visit_type_code 				= (visit_type_code == null)?"":visit_type_code;
						String patFlag					= req.getParameter("patFlag");
			            patFlag							= (patFlag == null)?"N":patFlag;


						pstmt = con.prepareStatement("select online_mr_notfn_yn,mr_location_code from op_clinic where clinic_code = '" + location_code + "' and facility_id='"+ facilityId + "'");
						
						rset = pstmt.executeQuery();
						while(rset!=null && rset.next()) {
							online_mr_notfn_yn    = rset.getString("online_mr_notfn_yn");
							online_mr_notfn_yn 	  = (online_mr_notfn_yn == null)?"":online_mr_notfn_yn;
		                    mr_location_code      = rset.getString("mr_location_code");
							mr_location_code 	  = (mr_location_code == null)?"":mr_location_code;

						}if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();

                        pstmt = con.prepareStatement("select pat_ser_grp_code from mp_patient where patient_id='"+patient_id+"'");
						rset = pstmt.executeQuery();
						while(rset!=null && rset.next()) {
						pat_ser_grp_code = rset.getString(1);
						}

						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();


						// Check whether the file managment is installed or not
						String sql = "select install_yn from sm_module where module_id = 'FM'";
						pstmt = con.prepareStatement(sql);
						rset = pstmt.executeQuery();

						String fm_install_yn = "N" ;
						if (rset != null && rset.next())
							fm_install_yn = rset.getString(1);
			 			if(fm_install_yn.equals(""))
							fm_install_yn = "N" ;

						if(rset != null) rset.close();
						if(pstmt != null) pstmt.close();
						/*new file creation logic */
						String createFileAtRegAttnSql = "select CREATE_FILE_AT_REG_ATT_YN,MAINTAIN_DOC_OR_FILE,to_char(sysdate, 'DD/MM/RRRR HH24:MI') enc_date from mp_param";
						String re_encounter_id = (String) results.get("encounter_id") ;
						try  {
                   			PreparedStatement createFileStmt = con.prepareStatement(createFileAtRegAttnSql);
							ResultSet createFileResultSet = createFileStmt.executeQuery();
							if(createFileResultSet!=null && createFileResultSet.next()) {
								createFileAtReg = createFileResultSet.getString("CREATE_FILE_AT_REG_ATT_YN");
								maintain_doc_or_file = createFileResultSet.getString("MAINTAIN_DOC_OR_FILE");
								encounter_date = createFileResultSet.getString("enc_date");
								
							}
							if((createFileAtReg==null) || (createFileAtReg.equals("null")) || (createFileAtReg=="") || (createFileAtReg.equals(""))) createFileAtReg		= "";
							if((maintain_doc_or_file==null) || (maintain_doc_or_file.equals("null")) || (createFileAtReg=="") || (maintain_doc_or_file.equals(""))) maintain_doc_or_file		= "";

							if(createFileResultSet!=null) createFileResultSet.close();
							if(createFileStmt!=null) createFileStmt.close();
						} catch (Exception createfilexcpn)  {
							System.out.println(createfilexcpn);
							createfilexcpn.printStackTrace();
						}
						
						

						if(maintain_doc_or_file.equals("F") && createFileAtReg.equals("Y")) {		
      						java.util.HashMap hashFILE_NO_EXISTS= File_No_ExistsCall(req, "AE",con);
							p_separate_file_no_yn = (String)hashFILE_NO_EXISTS.get("p_seperate_file_no_yn");
							p_create_file_no_yn = (String)hashFILE_NO_EXISTS.get("p_create_file_no_yn");
							mr_section_type=(String)hashFILE_NO_EXISTS.get("p_mr_section_type");
							mr_section_code = (String)hashFILE_NO_EXISTS.get("p_mr_section_code");
							single_or_multi_files_ind =(String)hashFILE_NO_EXISTS.get("p_single_or_multi_files_ind");
							p_error_message = (String)hashFILE_NO_EXISTS.get("p_error_message");
							p_status = (String)hashFILE_NO_EXISTS.get("p_status");
							if(p_create_file_no_yn==null) p_create_file_no_yn="";
							if(p_separate_file_no_yn==null) p_separate_file_no_yn="";
							if(p_error_message==null) p_error_message="";

							
							
							
						
							if (p_status.equals("1")) {
								if (!p_error_message.equals("File Cannot Be Created, Already Exist")) {
									errors = error + "<br>"+p_error_message;
								}
							}
							hashFILE_NO_EXISTS.clear();
						}
						int cnt=0;
						int cnt1=0;
						try
						{
							pstmt=con.prepareStatement("select count(*) from ae_online_report where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A')");
							rset=pstmt.executeQuery();
							if(rset != null)
							{
								if(rset.next())
								{
									cnt=rset.getInt(1);
								}
							}
							if(rset != null) rset.close();
							if(pstmt != null) pstmt.close();

							pstmt=con.prepareStatement("select count(*) from ae_online_report where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL')");
							rset=pstmt.executeQuery();
							if(rset != null)
							{
								if(rset.next())
								{
									cnt1=rset.getInt(1);
								}
							}
							if(rset != null) rset.close();
							if(pstmt != null) pstmt.close();

						}catch(Exception e)
						{
							System.out.println("Exception in generatFile:----------"+e);
							e.printStackTrace();		
						}
						String sqlString="select distinct report_id,SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id, 1 orderby from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') AND report_id NOT IN ('FMFLRQSL') ORDER BY 5,2";

						String sqlString1="select distinct report_id,SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id, 2 orderby from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','FMFLRQSL') ORDER BY 5,2";
					
						String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_user_name";
						String reportParamValues = ""+re_encounter_id+","+location_code+","+location_type+","+patient_id+","+addedById+"";

						if(maintain_doc_or_file.equals("F")) {

							if(p_create_file_no_yn.equals("Y"))	 {
    							re_encounter_id = (String) results.get("encounter_id") ;
								if (re_encounter_id.equals("null") || re_encounter_id == null) {
									re_encounter_id = "";
								}
								String htmlFor = "";
								// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
								//Added by Ajay Hatwate for MOHE-SCF-0242
								if(cnt>0){
								session.setAttribute("AE_REG_ATTN_SQL", sqlString); 
								}else if(cnt1>0){
									session.setAttribute("AE_REG_ATTN_SQL",sqlString1);
								}
								//htmlFor = "<html><head> <script language='javascript' src='../eCommon/js/messages.js'></script><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body class='message'><script language = 'JavaScript'>var dialogHeight = '50vh' ;var dialogWidth = '50vw' ;var dialogTop = '65';	var arguments = '';	var getUrl ='../../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+"AE"+"&Location_Type="+location_type+"&Location_Code="+location_code+"&P_Patient_ID="+patient_id+"&p_encounter_id="+re_encounter_id+"&p_encounter_date_time="+encounter_date+"&p_patient_class="+"EM"+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_separate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth+'; dialogTop:'+dialogTop+'; status=no;' ; var fileString='APP-MP0078 File No'; var fileString2=' is assigned '; var retVal = await.window.showModalDialog(getUrl,arguments,features);if(retVal==null) {retVal='`'; fileString=' '; fileString2=' ';}var arr = retVal.split('`');                                                                                            if(arr[0]==null || arr[0]==''){arr[0]=' ';fileString=' ';fileString2=' ';var arr1='';}                                       if (arr[1]==null || arr[1]==''){arr[1]=' ';}  if(arr[0]!= ' '){ var arr1=arr[0].split('||'); if(arr1[0] == null || arr1[0] == ''){arr1[0]=' ';fileString=' ';fileString2=' ';}if(arr1[1] == null || arr1[1] == ''){arr1[1]=' ';}} parent.f_query_add_mod.patientDetailsFrame.assignnewfileno(arr1[1]); if(arr1 !=''){var val1=arr1[0];val2=arr1[1];} else {var val1='';var val2='' } if(arr[0]!=' ')                                      {                                               var new_file_no=parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value; if(new_file_no == null) new_file_no='';  var dialogHeight    = '32' ;	var dialogWidth = '65' ;	var dialogTop = '65'; vararguments =   ''; 	if("+cnt+" > 0){ var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&reportParamNames="+reportParamNames+",p_file_no&reportParamValues="+reportParamValues+",'+new_file_no;	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal = await.window.showModalDialog(getUrl,arguments,features);  }   parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+ "<br>'+fileString+' <B><FONT SIZE=2>'+val1+'</B></FONT>'+fileString2+''+ arr[1]+'&err_value=1&invoke_from="+invoke_from+" '; 							}else{ var new_file_no=parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value; if(new_file_no == null) new_file_no='';  var dialogHeight    = '32' ;	var dialogWidth = '65' ;	var dialogTop = '65'; var arguments =   ''; 	if("+cnt1+" > 0){ var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&reportParamNames="+reportParamNames+",p_file_no&reportParamValues="+reportParamValues+",'+new_file_no; 	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal = await.window.showModalDialog(getUrl,arguments,features);} parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+ "<br>'+fileString+' <B><FONT SIZE=2>'+val1+'</B></FONT>'+fileString2+''+ arr[1]+'&err_value=1&invoke_from="+invoke_from+" '; 							}</script></body></html>";
							htmlFor = 
								"var dialogHeight = '40vh';" +
								"var dialogWidth = '35vw';" +
								"var dialogTop = '10';" +
								"var arguments = '';" +
								"var getUrl ='../../eMP/jsp/CallCreateFileComponent.jsp?Called_From="+"AE"+"&Location_Type="+location_type+"&Location_Code="+location_code+"&P_Patient_ID="+patient_id+"&p_encounter_id="+re_encounter_id+"&p_encounter_date_time="+encounter_date+"&p_patient_class="+"EM"+"&P_Single_or_multi_files_ind="+single_or_multi_files_ind+"&P_Seperate_file_no_yn="+p_separate_file_no_yn+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"&P_Mr_Section_Type="+mr_section_type+"&P_Mr_Section_Code="+mr_section_code+"';"+
								"var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; dialogTop:' + dialogTop + '; status=no;';" +
								"var fileString = 'APP-MP0078 File No';" +
								"var fileString2 = ' is assigned ';" +
								"var retVal = await window.showModalDialog(getUrl, arguments, features);" +
								"if (retVal == null) {" +
								"retVal = '`'; fileString = ' '; fileString2 = ' ';" +
								"}" +
								"var arr = retVal.split('`');" +
								"if (arr[0] == null || arr[0] == '') {" +
								"arr[0] = ' '; fileString = ' '; fileString2 = ' '; var arr1 = '';" +
								"}" +
								"if (arr[1] == null || arr[1] == '') { arr[1] = ' '; }" +
								"if (arr[0] != ' ') {" +
								"var arr1 = arr[0].split('||');" +
								"if (arr1[0] == null || arr1[0] == '') { arr1[0] = ' '; fileString = ' '; fileString2 = ' '; }" +
								"if (arr1[1] == null || arr1[1] == '') { arr1[1] = ' '; }" +
								"}" +
								"parent.f_query_add_mod.patientDetailsFrame.assignnewfileno(arr1[1]);" +
								"if (arr1 != '') {" +
								"var val1 = arr1[0];" +
								"var val2 = arr1[1];" +
								"} else {" +
								"var val1 = ''; var val2 = '';" +
								"}" +
								"if (arr[0] != ' ') {" +
								"var new_file_no = parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value;" +
								"if (new_file_no == null) new_file_no = '';" +
								"var dialogHeight = '60vh';" +
								"var dialogWidth = '60vw';" +
								"var dialogTop = '65';" +
								"var arguments = '';" +
								"if (" + cnt + " > 0) {" +
								"var getUrl = '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+ re_encounter_id + "&dest_locn_type=" + location_type + "&dest_locn_code=" + location_code + "&reportParamNames=" + reportParamNames + ",p_file_no&reportParamValues=" + reportParamValues + ",'+ new_file_no;" +
								"var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; dialogTop:' + dialogTop + '; status=no;';" +
								"retVal = await window.showModalDialog(getUrl, arguments, features);" +
								"}" +
								"parent.frames[2].location.href = '../eAE/jsp/AERegAttnError.jsp?err_num=" + java.net.URLEncoder.encode(errors, "UTF-8") + "<br>' + fileString + ' <B><FONT SIZE=2>' + val1 + '</B></FONT>' + fileString2 + '' + arr[1] + '&err_value=1&invoke_from="+ invoke_from+" ';" +
								"} else {" +
								"var new_file_no = parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value;" +
								"if (new_file_no == null) new_file_no = '';" +
								"var dialogHeight = '55vh';" +
								"var dialogWidth = '60vw';" +
								"var dialogTop = '65';" +
								"var arguments = '';" +
								"if (" + cnt1 + " > 0) {" +
								"var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&reportParamNames="+reportParamNames+",p_file_no&reportParamValues="+reportParamValues+",'+new_file_no;" +
								"var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; dialogTop:' + dialogTop + '; status=no;';" +
								"retVal = await window.showModalDialog(getUrl, arguments, features);" +
								"}" +
								"parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+ "<br>'+fileString+' <B><FONT SIZE=2>'+val1+'</B></FONT>'+fileString2+''+ arr[1]+'&err_value=1&invoke_from="+invoke_from+" ';" +
								"}" ;
								out.println(htmlFor);
							}else if(fm_install_yn.equals("Y") && online_mr_notfn_yn.equals("Y"))
							{
								//requestfile(req,re_encounter_id,errors,sStyle,out,"AE",patient_id,facilityId,location_code,mr_location_code,online_mr_notfn_yn,con);
							requestfile(req,re_encounter_id,errors,sStyle,out,"AE",patient_id,facilityId,location_code,mr_location_code,online_mr_notfn_yn,con,visit_type_code,location_type,addedById,cnt);
							// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
							//Added by Ajay Hatwate for MOHE-SCF-0242
							session.setAttribute("AE_REG_ATTN_SQL", sqlString); // added by Himanshu Saxena for MOHE-SCF-0242 on 05-07-2023
							String htmlFor = " var dialogHeight = '55vh';var dialogWidth = '60vw' ;var dialogTop = '65'; var arguments =   '';var new_file_no= parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value; if(new_file_no == null) new_file_no=''; var val1=''; var fileString='';  var fileString2=''; if("+cnt+" > 0){  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&reportParamNames="+reportParamNames+",p_file_no&reportParamValues="+reportParamValues+",'+new_file_no; 	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal =await window.showModalDialog(getUrl,arguments,features);} parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+ "<br>'+fileString+' <B><FONT SIZE=2>'+val1+'</B></FONT>'+fileString2+'&err_value=1&invoke_from="+invoke_from+" ';";
							
							out.println(htmlFor);
							}  else  {

								re_encounter_id = (String) results.get("encounter_id") ;
	    							if (re_encounter_id.equals("null") || re_encounter_id == null) {
									re_encounter_id = "";
		    						}
								doOnlineReport(req,re_encounter_id,cnt,cnt1,errors,sStyle,out);
		  					}
						}  else if(maintain_doc_or_file.equals("D") && patFlag.equals("Y"))  {
							// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
							session.setAttribute("AE_REG_ATTN_SQL", sqlString);
							//Added by Ajay Hatwate for MOHE-SCF-0242
							String htmlFor = " var dialogHeight = '55vh';var dialogWidth = '50vw' ;var dialogTop = '65'; var arguments =   '';var new_file_no=parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value; if(new_file_no == null) new_file_no=''; var val1=''; var fileString='';  var fileString2=''; if("+cnt+" > 0){  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&reportParamNames="+reportParamNames+",p_file_no&reportParamValues="+reportParamValues+",'+new_file_no; 	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal =await window.showModalDialog(getUrl,arguments,features);} parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+ "<br>'+fileString+' <B><FONT SIZE=2>'+val1+'</B></FONT>'+fileString2+'&err_value=1&invoke_from="+invoke_from+" ';";
							out.println(htmlFor);

						} else if(maintain_doc_or_file.equals("D") && patFlag.equals("N"))  {
							// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
								session.setAttribute("AE_REG_ATTN_SQL", sqlString); // added by Himanshu Saxena for MOHE-SCF-0242 on 05-07-2023
								String htmlFor = " var dialogHeight    = '55vh' ;	var dialogWidth = '50vw' ;var dialogTop = '65'; var arguments =   '';var new_file_no=parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value; if(new_file_no == null) new_file_no='';  var val1='';var fileString='';  var fileString2=''; if("+cnt1+" > 0){   var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&reportParamNames="+reportParamNames+",p_file_no&reportParamValues="+reportParamValues+",'+new_file_no; 	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal =await window.showModalDialog(getUrl,arguments,features);} parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+ "<br>'+fileString+' <B><FONT SIZE=2>'+val1+'</B></FONT>'+fileString2+'&err_value=1&invoke_from="+invoke_from+" '; ";
							out.println(htmlFor);
						} else  {

							re_encounter_id = (String) results.get("encounter_id") ;
	    						if (re_encounter_id.equals("null") || re_encounter_id == null) {
								re_encounter_id = "";
		    					}
							doOnlineReport(req,re_encounter_id,cnt,cnt1,errors,sStyle,out);
						}

					} catch (Exception e) {
						
						e.printStackTrace();
					} finally {
						try{
							if(pstmt!=null) pstmt.close();
			               // if(con != null)  ConnectionManager.returnConnection(con,req);

						}
						catch(Exception e){e.printStackTrace();}
					}
				}

        private void updateLocnCode(HttpServletRequest req,Connection con) throws ServletException,IOException,SQLException {								
			HttpSession session         = null;
			PrintWriter out;
			session           	        = req.getSession(false) ;
			PreparedStatement pstmt		= null;
			ResultSet rset				= null;
		    String facilityId			= (String) session.getValue( "facility_id" ) ;
		    String patient_id			= req.getParameter("patient_id");
			patient_id				    = (patient_id == null)?"":patient_id;
			String gen_file_no          ="";


		String fs_locn_code = req.getParameter("fs_locn_code") == null ?"" : req.getParameter("fs_locn_code");
		int rs1 = 0;
		ResultSet rs =null;
		try{			
			if(!(patient_id.equals("") && facilityId.equals("") && gen_file_no.equals(""))) {
				String sqlLocnCode="select DFLT_FS_LOCN_CODE from FM_PARAMETER where facility_id=? ";
				pstmt = con.prepareStatement(sqlLocnCode);
				pstmt.setString(1,facilityId);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next())
					fs_locn_code=rs.getString(1);
				String  sql = "update mr_pat_file_index set  fs_locn_code = ? where facility_id = ? and patient_id = ? and file_no = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,fs_locn_code);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,gen_file_no);
				rs1 = pstmt.executeUpdate();
				if(rs1 > 0)  {
					con.commit();
				} else  {
					con.rollback();
  				}
			} // end of if old_file_no, etc.
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			if(rs!=null) rs.close();
		 } catch( Exception e )  { 						
			e.printStackTrace();
           }
         finally {
			        //if(con != null)  ConnectionManager.returnConnection(con,req);
	              } 

	}// end of old_file_no

	private void doOnlineReport(HttpServletRequest req,String re_encounter_id,int cnt,int cnt1,String errors,String sStyle,PrintWriter out) throws ServletException, IOException, SQLException {

			HttpSession session         = null;
			session           	        = req.getSession(false) ;
			String addedById            =  (String)session.getValue("login_user") ;
		    String facilityId			=  (String) session.getValue( "facility_id" ) ;
			String locale	            = "";
			java.util.Properties p		= null;
			p    = (java.util.Properties) session.getValue( "jdbc" ) ;
			locale			     = p.getProperty("LOCALE");
		    String patient_id			=  req.getParameter("patient_id");
			patient_id				    =  (patient_id == null)?"":patient_id;
			String gen_file_no          = "";
			PreparedStatement pstmt  	=  null;
			ResultSet rset				=  null;
            String location_code 		=  req.getParameter("location_code");
			location_code 			    =  (location_code == null)?"":location_code;
			String location_type 		=  req.getParameter("location_type");
			location_type 			    =  (location_type == null)?"":location_type;
			String visit_type_code 		=  req.getParameter("visit_type");
			visit_type_code 			=  (visit_type_code == null)?"":visit_type_code;
			String p_passing_local_date =  req.getParameter("p_passing_local_date")== null ?"":req.getParameter("p_passing_local_date");
			String p_language_id        =  req.getParameter("p_language_id")== null ?"":req.getParameter("p_language_id");			
		try{

			String sqlString ="";
			StringTokenizer st_token = null;
			String strRptFileNo = "" ;
			int count=0;
			if(gen_file_no != null && gen_file_no.trim().length() > 0) {
				st_token = new StringTokenizer(gen_file_no,"+");
				strRptFileNo = st_token.nextToken();
			}
			if (!(strRptFileNo.equals(""))) {

				sqlString="select distinct report_id, SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id, 1 orderby from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') AND report_id NOT IN ('FMFLRQSL') ORDER BY 5,2";
				count=cnt;
			} else {
				sqlString="select distinct report_id, SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id, 2 orderby from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','FMFLRQSL') ORDER BY 5,2";
				count=cnt1;
			}
			String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_user_name,p_language_id,p_passing_local_date,p_file_no";
			String reportParamValues = ""+re_encounter_id+","+location_code+","+location_type+","+patient_id+","+addedById+","+p_language_id+","+p_passing_local_date+","+strRptFileNo+"";

			StringBuffer htmlFor = new StringBuffer();
			if(count > 0)
			{
			htmlFor.append("   var dialogHeight    = '55vh' ;");
			htmlFor.append("  var dialogWidth = '60vw' ;");
			htmlFor.append("  var dialogTop = '10' ;");
			htmlFor.append("  var arguments =   ''; ");
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			session.setAttribute("AE_REG_ATTN_SQL", sqlString); // added by Ajay Hatwate for MOHE-SCF-0242 on 05-07-2023
			htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			htmlFor.append("  var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ;");
			htmlFor.append("  retVal =await window.showModalDialog(getUrl,arguments,features);");
			out.println(htmlFor.toString());
			}
			StringBuffer errorHtml=new StringBuffer();
			errorHtml.append("parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num="+java.net.URLEncoder.encode( errors, "UTF-8" )+"&err_value=1&invoke_from="+invoke_from+"';");


			out.println("parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num="+java.net.URLEncoder.encode( errors, "UTF-8" )+"&err_value=1&invoke_from="+invoke_from+"';");
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
		} catch( Exception ee )  {
			out.print("Exception in invoking Online Report : " + ee);
			ee.printStackTrace();
		}

	}
	private void requestfile(HttpServletRequest req,String re_encounter_id,String errors,String sStyle,PrintWriter out,String from, String patientid, String facId, String locationCode,String mr_location_code,String online_mr_notfn_yn, Connection conn,String visit_type_code,String location_type,String addedById,int cnt)
			throws Exception {
		       try {				   

					StringBuffer htmlFor = new StringBuffer();
					htmlFor.setLength(0);

					
					htmlFor.append("var jsp_name = '../../eCommon/blank.html';");							
					htmlFor.append(" jsp_name = '../eFM/jsp/FMAcceptFileTypeVolumeNoFrame.jsp?patient_id="
									+ patientid
									+ "&online_mr_notfn_yn="
									+ online_mr_notfn_yn
									+ "&fs_locn_code="
									+ mr_location_code
									+ "&encounter_id="
									+ re_encounter_id
									+ "&req_locn_id="
									+ locationCode + "';");
					htmlFor.append("var retVal = '';");
					htmlFor.append("dialogHeight	= '35vh';");
					htmlFor.append("dialogWidth		= '35vw';");
					htmlFor.append("dialogTop		= '185';");
					htmlFor.append("dialogLeft		= '250';");
					htmlFor.append("center			= '0';");
					htmlFor.append("status			= 'no';");
					htmlFor
							.append("var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; center: ' + center + '; status: ' + status + '; dialogTop :' + dialogTop + ';dialogLeft:' + dialogLeft+';scroll=no';");
					htmlFor.append("var arguments		= '';");
					htmlFor
							.append("retValue				=await window.showModalDialog(jsp_name,arguments, features );");					
					htmlFor.append("if(retValue== null)  retValue = 'N';");
					//htmlFor.append("document.all.req_no.value =retValue; ");
					htmlFor.append("document.getElementById('req_no').value = retValue; ");
					htmlFor.append("document.form1.submit();}");
					htmlFor.append("<form name='form1' method='post' action='../servlet/eAE.AERegisterAttnServlet' target='messageFrame'>");
					htmlFor.append("<input type='hidden' name='req_no'></input>");
					htmlFor.append("<input type='hidden' name='operation' value='fmOnlineReport'></input>");
					htmlFor.append("<input type='hidden' name='visit_type_code' value='"+visit_type_code+"'></input>");
					htmlFor.append("<input type='hidden' name='locationCode' value='"+locationCode+"'></input>");
					htmlFor.append("<input type='hidden' name='re_encounter_id' value='"+re_encounter_id+"'></input>");
					htmlFor.append("<input type='hidden' name='location_type' value='"+location_type+"'></input>");
					htmlFor.append("<input type='hidden' name='patientid' value='"+patientid+"'></input>");
					htmlFor.append("<input type='hidden' name='addedById' value='"+addedById+"'></input>");
					htmlFor.append("<input type='hidden' name='errors' value='"+errors+"'></input>");
					htmlFor.append("<input type='hidden' name='cnt' value='"+cnt+"'></input>");
					htmlFor.append("<input type='hidden' name='sStyle' value='"+sStyle+"'></input>");					
					htmlFor.append("</form>");
					errors = "1";				
					out.println(htmlFor.toString());
					htmlFor.setLength(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void fmOnlineReport(HttpServletRequest req, HttpServletResponse res,PrintWriter out) throws ServletException, IOException, SQLException { 		
		try{				
			HttpSession session         = null;
			session           	        = req.getSession(false) ;
			String addedById                        = (String) session.getValue("login_user") ;
			String facilityId							    = (String) session.getValue( "facility_id" ) ;
			String locale	            = "";
			java.util.Properties p		= null;
			p    = (java.util.Properties) session.getValue( "jdbc" ) ;
			locale			     = p.getProperty("LOCALE");
			String req_no =  req.getParameter("req_no");
			String visit_type_code =  req.getParameter("visit_type_code");
			String location_code =  req.getParameter("locationCode");
			String re_encounter_id =  req.getParameter("re_encounter_id");
			String location_type =  req.getParameter("location_type");
			String patient_id =  req.getParameter("patientid");
			String errors =  req.getParameter("errors");
			String sStyle =  req.getParameter("sStyle");
			String cnt =  req.getParameter("cnt");			
			String perm_fs_locn = "";
			String new_req_no = "";			
			
	
			if(!req_no.equals("N"))  {
				StringTokenizer st  = new StringTokenizer(req_no,"&");
				while(st.hasMoreTokens()) {
							new_req_no = st.nextToken();
							perm_fs_locn      = st.nextToken();                      
				}
			}

			
			
			
			String sqlString="";
			if(req_no == null) req_no ="";
			
			

			if(req_no.equals("N")) {
				 sqlString="select distinct report_id,SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id, 1 orderby from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') and report_id not in ('FMFLRQSL') ORDER BY 5,2";
			} else {
				sqlString="select distinct report_id,SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id, 1 orderby from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and print_yn='Y' and (clinic_code='"+location_code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') AND report_id not in ('MPSTBCER') ORDER BY 5,2";
			}
				
				
						
				String p_call_from = "WALKIN";
				String reportParamNames = "p_encounter_id,p_call_from,p_clinic_code,p_clinic_type,p_patient_id,p_user_name,p_req_no";
				String reportParamValues = ""+re_encounter_id+","+p_call_from+","+location_code+","+location_type+","+patient_id+","+addedById+","+new_req_no+"";
				// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
				session.setAttribute("AE_REG_ATTN_SQL", sqlString); // added by Himanshu Saxena for MOHE-SCF-0242 on 05-07-2023
			String htmlFor = "var dialogHeight = '55vh';var dialogWidth = '65vw' ;var dialogTop = '65'; var arguments =   '';var new_file_no=parent.f_query_add_mod.patientDetailsFrame.document.forms[0].new_file_no.value; if(new_file_no == null) new_file_no=''; var val1=''; var fileString='';  var fileString2=''; if("+cnt+" > 0){  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=AE&P_function_id=AE_REGISTER_ATTN&step=1&EncounterId="+re_encounter_id+"&dest_locn_type="+location_type+"&dest_locn_code="+location_code+"&perm_fs_locn_code="+perm_fs_locn+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"'; 	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal =await window.showModalDialog(getUrl,arguments,features);} parent.frames[2].location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( errors, "UTF-8" )+ "<br>'+fileString+' <B><FONT SIZE=2>'+val1+'</B></FONT>'+fileString2+'&err_value=1&invoke_from="+invoke_from+" '; ";
			out.println(htmlFor);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//out.println(e.toString());
		} finally {
			//if (con != null)
				//ConnectionManager.returnConnection(con, req);
		}
	}

	/******* Nnew Method added for File Generation logic*********/
	public HashMap File_No_ExistsCall(HttpServletRequest req,String callFrom,Connection con)  throws ServletException,IOException,SQLException {		
		HttpSession session         = null;
		PrintWriter out;
		session           	        = req.getSession(false) ;
    	String fileCreateSql =  "{call FILE_NO_EXISTS(?,?,?,?,?,?,?,?,?,?,?,?)}";
 		String p_create_file_no_yn  = "N";
		String p_error_message      = "";
	    String patient_id			= req.getParameter("patient_id");
		patient_id				= (patient_id == null)?"":patient_id;

		String location_code 			=  req.getParameter("location_code");
	    location_code 			= (location_code == null)?"":location_code;
		String facilityId			    = (String) session.getValue( "facility_id" ) ;
		int p_status2 = 0;
		java.util.HashMap hashFILE_NO_EXISTS=new HashMap();		
		CallableStatement fileCreateCS = con.prepareCall(fileCreateSql);
		fileCreateCS.setString(1, patient_id);
		fileCreateCS.setString(2, facilityId);
		fileCreateCS.setString(3, callFrom);
		fileCreateCS.setString(4, location_code);
		fileCreateCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 6,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 7,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 8,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 9,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 10,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 11,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 12,java.sql.Types.INTEGER);

	        try{
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

			p_error_message = fileCreateCS.getString(11);
	                if(p_error_message==null)p_error_message="";
			hashFILE_NO_EXISTS.put("p_error_message",p_error_message);

		        p_status2 =fileCreateCS.getInt(12);

			Integer p_status1 = new Integer(p_status2);
			String p_status_str = p_status1.toString();

			hashFILE_NO_EXISTS.put("p_status",p_status_str);

		} catch(Exception e1) {e1.printStackTrace();}
		finally{fileCreateCS.close();}
		return hashFILE_NO_EXISTS;

	}//end of File_No_ExistsCall

	/////////new method added for Working Day Check///////
	public HashMap ifClinicWorkingYN(String location_code,String facilityId,Connection con)  throws Exception {						
		
		String fileCreateSql =  "{call GET_WORKING_DAY_YN(?,?,null,sysdate,?,?)}";
       	String practWorkingYN="N";
		java.util.HashMap hashFILE_NO_EXISTS=new HashMap();
		CallableStatement fileCreateCS = con.prepareCall(fileCreateSql);
		fileCreateCS.setString(1, facilityId);
		fileCreateCS.setString(2, location_code);
		fileCreateCS.registerOutParameter( 3,java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);

                try{
			fileCreateCS.execute();
			practWorkingYN = fileCreateCS.getString(3);
			if(practWorkingYN==null) practWorkingYN="N";
			hashFILE_NO_EXISTS.put("practWorkingYN",practWorkingYN);

			String P_ERR_MSG = fileCreateCS.getString(4);
	                if(P_ERR_MSG==null) P_ERR_MSG="";
		    hashFILE_NO_EXISTS.put("P_ERR_MSG",P_ERR_MSG);
		} catch(Exception e1) {
					e1.printStackTrace();
		} finally{fileCreateCS.close();}

		return hashFILE_NO_EXISTS;

	}//end of File_No_ExistsCall
	/********************************************/
	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}
}
