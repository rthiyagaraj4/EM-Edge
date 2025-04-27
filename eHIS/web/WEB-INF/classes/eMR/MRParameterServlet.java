/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class MRParameterServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;

	Properties p;
	String DiagCodeScheme;
	String ProcCodeScheme;
	String g6pd_discr_msr_id;
	String sicc_discr_msr_id;
	String adult_min_age					= "";
	String adult_min_unit					= "";
	String adult_max_age					= "";
	String adult_max_unit					= "";
	String pead_min_age						= "";
	String pead_min_unit					= "";
	String pead_max_age						= "";
	String pead_max_unit					= "";
	String newborn_min_age					= "";
	String newborn_min_unit					= "";
	String newborn_max_age					= "";
	String newborn_max_unit					= "";
	String mr_pay_int_mode					= "";
	String ext_mand_for_consq				= "";
	String single_stage_death_reg_appl_yn	= "";
	String restrict_pract_self_referral 	= "";
	String restrict_pract_self_rfl_ip_op	= "";
	String restrict_pract_self_rfl_op_ip	= "";
	String restrict_bedside_self_referral	= "";
	String max_pri_diag_indicate_co_death	= "";
	String max_oth_dis_comp_indi_co_death	= "";
	String astk_mand_for_dagg				= "";
	String allow_recode_diag_yn				= "";
	String allow_recode_proc_yn				= "";
	String allow_ot_proc_recode_yn			= "";
	String allow_non_ot_proc_recode_yn		= "";
	String recode_for_op_yn					= "";
	String recode_for_ip_yn					= "";
	String recode_for_em_yn					= "";
	String recode_for_dc_yn					= "";
	
	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	String auto_fin_death_reg_appl_yn		= "";
	String primary_diag_class				= "";
	String pri_mand_postmortem_ip_yn		= "";
	String pri_mand_postmortem_dc_yn		= "";
	String pri_mand_postmortem_op_yn		= "";
	String pri_mand_postmortem_ae_yn		= "";
	String pri_mand_non_postmortem_ip_yn	= "";
	String pri_mand_non_postmortem_dc_yn	= "";
	String pri_mand_non_postmortem_op_yn	= "";
	String pri_mand_non_postmortem_ae_yn	= "";
	String secondary_diag_class				= "";
	String sec_mand_postmortem_ip_yn		= "";
	String sec_mand_postmortem_dc_yn		= "";
	String sec_mand_postmortem_op_yn		= "";
	String sec_mand_postmortem_ae_yn		= "";
	String sec_mand_non_postmortem_ip_yn	= "";
	String sec_mand_non_postmortem_dc_yn	= "";
	String sec_mand_non_postmortem_op_yn	= "";
	String sec_mand_non_postmortem_ae_yn	= "";
	/*End ML-MMOH-CRF-1742*/

	String recode_allow_beynd_max_lev_yn	= "";

	String max_level_for_op_yn				= "";
	String max_level_for_ip_yn				= "";
	String max_level_for_dc_yn				= "";
	String max_level_for_em_yn				= "";
	/*Added On 12/8/2009 */
	String proc_type_for_recode				= "";

	String grace_period						= "";
	String drg_calculation_yn				= "";
	String auth_at_stage					= "";
	String facilityId ;
	String client_ip_address ;

	String addl_field1_prompt               = "";
    String addl_field1_length               = "";
    String addl_field1_section              = "";
    String addl_field2_prompt				= "";
    String addl_field2_length               = "";
    String addl_field2_section              = "";
    String addl_field3_prompt               = "";
    String addl_field3_length               = "";
    String addl_field3_section              = "";
    String addl_field4_prompt               = "";
    String addl_field4_length               = "";
    String addl_field4_section              = "";
    String addl_field5_prompt               = "";
    String addl_field5_length               = "";
    String addl_field5_section              = "";
    String exclude_orig_code_recode_yn      = "";
    String diag_enc_level_yn="";//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
	
	String witness_pass_validate_yn=""; //Added for this CRF HSA-CRF-0222
	String diagnosis_by_long_desc_yn=""; //Added for this CRF - 0234
	/*Variable Added for this CRF PMG2013-CRF-0006*/
	String dflt_tab_in_diag_sel="";
	String diag_class_mand="";
	
	/*Below line added for this CRF Bru-HIMS-CRF-024.2*/
	String notifiable_form_mand_yn="N";

/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
String rep_date_range="";
/* ----end KDAH-CRF-0032---*/
String medrep_collection_days = "";/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
	
/*Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start*/
String medReqAuth	= ""; 
String medReqAuthApplicable ="";
/*End*/

/*Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719 Start*/
String incompleteReqCancel			= ""; 
String incompReqCancelApplicable	= "";
/*End*/

/*Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720*/
String mr_hdr_line1		= ""; 
String mr_hdr_line2		= ""; 
String mr_hdr_line3		= ""; 
String mr_hdr_line4		= ""; 
String mr_hdr_line5		= ""; 
String mr_hdr_line6		= ""; 
String mr_hdr_line7		= ""; //Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
String mr_sign_line1	= ""; 
String mr_sign_line2	= ""; 
String mr_sign_line3	= ""; 
String mr_sign_line4	= ""; 
String mr_sign_line5	= ""; 
String mr_sign_line6	= ""; 
String mr_sign_line7	= ""; 
String mr_sign_line8	= ""; //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
String mr_sign_line9	= "";//Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365

/* Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1 */
String diag_catg_mand_for_op_yn = "";
String diag_catg_mand_for_ip_yn = "";
String diag_catg_mand_for_em_yn = "";
String diag_catg_mand_for_dc_yn = "";

/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
String crossChkDfltMand="";
String enableLinkToCurrEnc="";
/* End of ML-MMOH-CRf-1741 */

String primaryDiagMandate = ""; //Added by Ashwin K for MMS-DM-CRF-0197.1
/*End*/

String max_num_day_for_BHT="";//added by Himanshu Saxena for ML-MOHE-CRF-1959 on 21-06-2023
String rest_integration_enotifikasi="";//Added by Santhosh for ML-MMOH-CRF-2156
String eNotifikasiDemographicsAppl="";//Added by Santhosh for ML-MMOH-CRF-2156
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		try{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function1");
			
			eNotifikasiDemographicsAppl = checkForNull(req.getParameter ("eNotifikasiDemographicsAppl"));//Added by Santhosh for ML-MMOH-CRF-2156

			if ( operation.equals("insert") )   insertDiagProcScheme(req, res);
			if ( operation.equals("modify"))    modifyDiagProcScheme(req, res);
		
		
		}catch(Exception e){  
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		try{
			this.out = res.getWriter();	
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String operation = req.getParameter("function1");
			if ( operation.equals("insert") )   insertDiagProcScheme(req, res);
			if ( operation.equals("modify"))    modifyDiagProcScheme(req, res);
		}catch(Exception e)	{/* out.println(e.toString()); */ e.printStackTrace();  }
	}

	private void modifyDiagProcScheme(HttpServletRequest req, HttpServletResponse res){
		try{
			//DiagCodeScheme = req.getParameter("diag_code_scheme");
			//ProcCodeScheme = req.getParameter("proc_code_scheme");
			g6pd_discr_msr_id				= req.getParameter("g6pd_discr_msr_id");
			sicc_discr_msr_id				= req.getParameter("sicc_discr_msr_id");
			mr_pay_int_mode					= req.getParameter("mr_pay_int_mode");
			adult_min_age					= checkForNull(req.getParameter("adult_min_age"));
			adult_min_unit					= checkForNull(req.getParameter("adult_min_unit"));
			adult_max_age					= checkForNull(req.getParameter("adult_max_age"));
			adult_max_unit					= checkForNull(req.getParameter("adult_max_unit"));
			pead_min_age					= checkForNull(req.getParameter("pead_min_age"));
			pead_min_unit					= checkForNull(req.getParameter("pead_min_unit"));
			pead_max_age					= checkForNull(req.getParameter("pead_max_age"));
			pead_max_unit					= checkForNull(req.getParameter("pead_max_unit"));
			max_pri_diag_indicate_co_death	= checkForNull(req.getParameter("max_pri_diag_indicate_co_death"));
			max_oth_dis_comp_indi_co_death	= checkForNull(req.getParameter("max_oth_dis_comp_indi_co_death"));
			newborn_min_age					= checkForNull(req.getParameter("newborn_min_age"));
			newborn_min_unit				= checkForNull(req.getParameter("newborn_min_unit"));
			newborn_max_age					= checkForNull(req.getParameter("newborn_max_age"));
			newborn_max_unit				= checkForNull(req.getParameter("newborn_max_unit"));
			ext_mand_for_consq				= checkForNull(req.getParameter("ext_mand_for_consq"),"N");
			single_stage_death_reg_appl_yn	= checkForNull(req.getParameter("single_stage_death_reg_appl_yn"),"N");

			/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
			auto_fin_death_reg_appl_yn		= checkForNull(req.getParameter("auto_fin_death_reg_appl_yn"),"N");
			primary_diag_class				= checkForNull(req.getParameter("primary_diag_class"));
			pri_mand_postmortem_ip_yn		= checkForNull(req.getParameter("pri_mand_postmortem_ip_yn"),"N");
			pri_mand_postmortem_dc_yn		= checkForNull(req.getParameter("pri_mand_postmortem_dc_yn"),"N");
			pri_mand_postmortem_op_yn		= checkForNull(req.getParameter("pri_mand_postmortem_op_yn"),"N");
			pri_mand_postmortem_ae_yn		= checkForNull(req.getParameter("pri_mand_postmortem_ae_yn"),"N");
			pri_mand_non_postmortem_ip_yn	= checkForNull(req.getParameter("pri_mand_non_postmortem_ip_yn"),"N");
			pri_mand_non_postmortem_dc_yn	= checkForNull(req.getParameter("pri_mand_non_postmortem_dc_yn"),"N");
			pri_mand_non_postmortem_op_yn	= checkForNull(req.getParameter("pri_mand_non_postmortem_op_yn"),"N");
			pri_mand_non_postmortem_ae_yn	= checkForNull(req.getParameter("pri_mand_non_postmortem_ae_yn"),"N");
			secondary_diag_class			= checkForNull(req.getParameter("secondary_diag_class"));
			sec_mand_postmortem_ip_yn		= checkForNull(req.getParameter("sec_mand_postmortem_ip_yn"),"N");
			sec_mand_postmortem_dc_yn		= checkForNull(req.getParameter("sec_mand_postmortem_dc_yn"),"N");
			sec_mand_postmortem_op_yn		= checkForNull(req.getParameter("sec_mand_postmortem_op_yn"),"N");
			sec_mand_postmortem_ae_yn		= checkForNull(req.getParameter("sec_mand_postmortem_ae_yn"),"N");
			sec_mand_non_postmortem_ip_yn	= checkForNull(req.getParameter("sec_mand_non_postmortem_ip_yn"),"N");
			sec_mand_non_postmortem_dc_yn	= checkForNull(req.getParameter("sec_mand_non_postmortem_dc_yn"),"N");
			sec_mand_non_postmortem_op_yn	= checkForNull(req.getParameter("sec_mand_non_postmortem_op_yn"),"N");
			sec_mand_non_postmortem_ae_yn	= checkForNull(req.getParameter("sec_mand_non_postmortem_ae_yn"),"N");
			/*End ML-MMOH-CRF-1742*/
			
			restrict_pract_self_referral	= checkForNull(req.getParameter("restrict_pract_self_referral"),"N");
			restrict_pract_self_rfl_ip_op	= checkForNull(req.getParameter("restrict_pract_self_rfl_ip_op"),"N");
			restrict_pract_self_rfl_op_ip	= checkForNull(req.getParameter("restrict_pract_self_rfl_op_ip"),"N");
			restrict_bedside_self_referral	= checkForNull(req.getParameter("restrict_bedside_self_referral"),"N");
			
			astk_mand_for_dagg				= checkForNull(req.getParameter("astk_mand_for_dagg"),"N");
			allow_recode_diag_yn			= checkForNull(req.getParameter("allow_recode_diag_yn"),"N");
			allow_recode_proc_yn			= checkForNull(req.getParameter("allow_recode_proc_yn"),"N");
			allow_ot_proc_recode_yn			= checkForNull(req.getParameter("allow_ot_proc_recode_yn"),"N");
			allow_non_ot_proc_recode_yn		= checkForNull(req.getParameter("allow_non_ot_proc_recode_yn"),"N");
			
			recode_for_op_yn				= checkForNull(req.getParameter("recode_for_op_yn"),"N");
			recode_for_ip_yn				= checkForNull(req.getParameter("recode_for_ip_yn"),"N");
			recode_for_dc_yn				= checkForNull(req.getParameter("recode_for_dc_yn"),"N");
			recode_for_em_yn				= checkForNull(req.getParameter("recode_for_em_yn"),"N");
			recode_allow_beynd_max_lev_yn	= checkForNull(req.getParameter("recode_allow_beynd_max_lev_yn"),"N");
			max_level_for_op_yn				= checkForNull(req.getParameter("max_level_for_op_yn"),"N");
			max_level_for_ip_yn				= checkForNull(req.getParameter("max_level_for_ip_yn"),"N");
			max_level_for_dc_yn				= checkForNull(req.getParameter("max_level_for_dc_yn"),"N");
			max_level_for_em_yn				= checkForNull(req.getParameter("max_level_for_em_yn"),"N");
            grace_period				    =req.getParameter("grace_period")==null?"":req.getParameter("grace_period").trim();
            //auth_appl_stage=req.getParameter("auth_appl_stage")==null?"":req.getParameter("auth_appl_stage").trim();
			drg_calculation_yn				= checkForNull(req.getParameter("drg_calculation_yn"),"N");
			auth_at_stage					= checkForNull(req.getParameter("auth_at_stage"));

			addl_field1_prompt				= checkForNull(req.getParameter ("addl_field1_prompt"));
			addl_field1_length				= checkForNull(req.getParameter ("addl_field1_length"));
			addl_field1_section				= checkForNull(req.getParameter ("addl_field1_section"));
			addl_field2_prompt				= checkForNull(req.getParameter ("addl_field2_prompt"));
			addl_field2_length				= checkForNull(req.getParameter ("addl_field2_length"));
			addl_field2_section				= checkForNull(req.getParameter ("addl_field2_section"));
			addl_field3_prompt				= checkForNull(req.getParameter ("addl_field3_prompt"));
			addl_field3_length				= checkForNull(req.getParameter ("addl_field3_length"));
			addl_field3_section				= checkForNull(req.getParameter ("addl_field3_section"));
			addl_field4_prompt				= checkForNull(req.getParameter ("addl_field4_prompt"));
			addl_field4_length				= checkForNull(req.getParameter ("addl_field4_length"));
			addl_field4_section				= checkForNull(req.getParameter ("addl_field4_section"));
			addl_field5_prompt				= checkForNull(req.getParameter ("addl_field5_prompt"));
			addl_field5_length				= checkForNull(req.getParameter ("addl_field5_length"));
			addl_field5_section				= checkForNull(req.getParameter ("addl_field5_section"));
			proc_type_for_recode			= checkForNull(req.getParameter ("proc_type_setup"));// Added On 12/8/2009 For SRR-CRF-303.1
			exclude_orig_code_recode_yn		= checkForNull(req.getParameter ("exclude_orig_code_recode_yn"));// Added On Saturday, January 23, 2010 For SRR-CRF-303.2
			
            /*Below line Added for this CRF [PMG2013-CRF-0006]*/			
			dflt_tab_in_diag_sel		= checkForNull(req.getParameter ("dflt_tab_in_diag_sel"));
			
			diag_class_mand = checkForNull(req.getParameter ("diag_class_mand"),"N");
			
           	/*Below line added for this CRF Bru-HIMS-CRF-024.2*/
	        notifiable_form_mand_yn=checkForNull(req.getParameter("notifiable_form_mand_yn"),"N");         	   
           	   
			 /*Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start*/
			   medReqAuth				= req.getParameter("medReqAuthorize"); 
			   medReqAuthApplicable		= req.getParameter("MedReqAuthApplicable");
			  /*End*/

			/*Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719 Start*/
			incompleteReqCancel				= checkForNull(req.getParameter("incompleteReqCancel"),"0"); 
			incompReqCancelApplicable		= checkForNull(req.getParameter("IncompReqCancelApplicable"));
			/*End*/
			
			/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
	           rep_date_range			= req.getParameter ("rep_date_range").trim();
			
/* ----end KDAH-CRF-0032---*/
	           diag_enc_level_yn= checkForNull(req.getParameter("diag_enc_level"),"N");//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013

			   witness_pass_validate_yn= checkForNull(req.getParameter("witness_pass_validate_yn"),"N"); //Added for this CRF HSA-CRF-0222
			   diagnosis_by_long_desc_yn= checkForNull(req.getParameter("diagnosis_by_long_desc_yn"),"N"); // Added for this CRF - 0234
				
			medrep_collection_days = checkForNull(req.getParameter("medrep_collection_days"));/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
			
			/*Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720*/
			mr_hdr_line1				= checkForNull(req.getParameter ("mr_hdr_line1"));
			mr_hdr_line2				= checkForNull(req.getParameter ("mr_hdr_line2"));
			mr_hdr_line3				= checkForNull(req.getParameter ("mr_hdr_line3"));
			mr_hdr_line4				= checkForNull(req.getParameter ("mr_hdr_line4"));
			mr_hdr_line5				= checkForNull(req.getParameter ("mr_hdr_line5"));
			mr_hdr_line6				= checkForNull(req.getParameter ("mr_hdr_line6"));
			mr_hdr_line7				= checkForNull(req.getParameter ("mr_hdr_line7"));//Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
			mr_sign_line1				= checkForNull(req.getParameter ("mr_sign_line1"));
			mr_sign_line2				= checkForNull(req.getParameter ("mr_sign_line2"));
			mr_sign_line3				= checkForNull(req.getParameter ("mr_sign_line3"));
			mr_sign_line4				= checkForNull(req.getParameter ("mr_sign_line4"));
			mr_sign_line5				= checkForNull(req.getParameter ("mr_sign_line5"));
			mr_sign_line6				= checkForNull(req.getParameter ("mr_sign_line6"));
			mr_sign_line7				= checkForNull(req.getParameter ("mr_sign_line7"));
			mr_sign_line8				= checkForNull(req.getParameter ("mr_sign_line8"));//Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
			/*End*/
			mr_sign_line9				= checkForNull(req.getParameter ("mr_sign_line9"));	//Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365

			primaryDiagMandate = checkForNull(req.getParameter ("Primary_Diag_Mandate"),"N"); //Added by Ashwin K for MMS-DM-CRF-0197.1
			/* Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1 */
			diag_catg_mand_for_op_yn = checkForNull(req.getParameter ("diag_catg_mand_for_op_yn"), "N");
			diag_catg_mand_for_ip_yn = checkForNull(req.getParameter ("diag_catg_mand_for_ip_yn"), "N");
			diag_catg_mand_for_em_yn = checkForNull(req.getParameter ("diag_catg_mand_for_em_yn"), "N");
			diag_catg_mand_for_dc_yn = checkForNull(req.getParameter ("diag_catg_mand_for_dc_yn"), "N");
			
			max_num_day_for_BHT= checkForNull(req.getParameter ("max_num_day_for_BHT"));//added by Himanshu Saxena for ML-MOHE-CRF-1959 on 21-06-2023

			crossChkDfltMand= checkForNull(req.getParameter ("crossCheckDfltMand"));//added by Ajay Hatwate for ML-MOHE-CRF-1741
			enableLinkToCurrEnc= checkForNull(req.getParameter ("enableLinkToCurrEnc"));//added by Ajay Hatwate for ML-MOHE-CRF-1741

			if(eNotifikasiDemographicsAppl.equals("true")){
				rest_integration_enotifikasi= checkForNull(req.getParameter ("rest_integration_enotifikasi"));//Added by Santhosh for ML-MMOH-CRF-2156
			}			
			//if (primaryDiagMandate==null)   primaryDiagMandate="N";  //Added by Ashwin K for MMS-DM-CRF-0197.1

			String addedById				= p.getProperty( "login_user" ) ;
			String addedDate				= dateFormat.format( new java.util.Date() ) ;
			String modifiedById				= addedById ;
			String modifiedDate				= addedDate ;
			String addedFacilityId			=  facilityId;
			String modifiedFacilityId		= addedFacilityId ;
			String addedAtWorkstation	    = client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;
			java.sql.Date modified_date		= java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata					= new HashMap();
			//tabdata.put("diag_code_scheme",DiagCodeScheme);
			//tabdata.put("proc_code_scheme",ProcCodeScheme);
			tabdata.put("g6pd_discr_msr_id",g6pd_discr_msr_id);
			tabdata.put("sicc_discr_msr_id",sicc_discr_msr_id);
			tabdata.put("MEDREP_PAY_INT_MODE",mr_pay_int_mode);
			tabdata.put("ADULT_MIN_AGE_VALUE",adult_min_age);
			tabdata.put("ADULT_MIN_AGE_UNIT",adult_min_unit);
			tabdata.put("ADULT_MAX_AGE_VALUE",adult_max_age);
			tabdata.put("ADULT_MAX_AGE_UNIT",adult_max_unit);
			tabdata.put("PEAD_MIN_AGE_VALUE",pead_min_age);
			tabdata.put("PEAD_MIN_AGE_UNIT",pead_min_unit);
			tabdata.put("PEAD_MAX_AGE_VALUE",pead_max_age);
			tabdata.put("PEAD_MAX_AGE_UNIT",pead_max_unit);
			tabdata.put("max_oth_dis_comp_indi_co_death",max_oth_dis_comp_indi_co_death);
			tabdata.put("max_pri_diag_indicate_co_death",max_pri_diag_indicate_co_death);
			tabdata.put("NB_MIN_AGE_VALUE",newborn_min_age);
			tabdata.put("NB_MIN_AGE_UNIT",newborn_min_unit);
			tabdata.put("NB_MAX_AGE_VALUE",newborn_max_age);
			tabdata.put("NB_MAX_AGE_UNIT",newborn_max_unit);	
			tabdata.put("ext_mand_for_consq",ext_mand_for_consq);				
			tabdata.put("astk_mand_for_dagg",astk_mand_for_dagg);	
			tabdata.put("single_stage_death_reg_appl_yn",single_stage_death_reg_appl_yn);	
			
			/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
			tabdata.put("auto_fin_death_reg_appl_yn",auto_fin_death_reg_appl_yn);
			tabdata.put("primary_diag_class",primary_diag_class);
			tabdata.put("pri_mand_postmortem_ip_yn",pri_mand_postmortem_ip_yn);
			tabdata.put("pri_mand_postmortem_dc_yn",pri_mand_postmortem_dc_yn);
			tabdata.put("pri_mand_postmortem_op_yn",pri_mand_postmortem_op_yn);
			tabdata.put("pri_mand_postmortem_ae_yn",pri_mand_postmortem_ae_yn);
			tabdata.put("pri_mand_non_postmortem_ip_yn",pri_mand_non_postmortem_ip_yn);
			tabdata.put("pri_mand_non_postmortem_dc_yn",pri_mand_non_postmortem_dc_yn);
			tabdata.put("pri_mand_non_postmortem_op_yn",pri_mand_non_postmortem_op_yn);
			tabdata.put("pri_mand_non_postmortem_ae_yn",pri_mand_non_postmortem_ae_yn);
			tabdata.put("secondary_diag_class",secondary_diag_class);
			tabdata.put("sec_mand_postmortem_ip_yn",sec_mand_postmortem_ip_yn);
			tabdata.put("sec_mand_postmortem_dc_yn",sec_mand_postmortem_dc_yn);
			tabdata.put("sec_mand_postmortem_op_yn",sec_mand_postmortem_op_yn);
			tabdata.put("sec_mand_postmortem_ae_yn",sec_mand_postmortem_ae_yn);
			tabdata.put("sec_mand_non_postmortem_ip_yn",sec_mand_non_postmortem_ip_yn);
			tabdata.put("sec_mand_non_postmortem_dc_yn",sec_mand_non_postmortem_dc_yn);
			tabdata.put("sec_mand_non_postmortem_op_yn",sec_mand_non_postmortem_op_yn);
			tabdata.put("sec_mand_non_postmortem_ae_yn",sec_mand_non_postmortem_ae_yn);
			/*End ML-MMOH-CRF-1742*/

			tabdata.put("restrict_pract_self_referral",restrict_pract_self_referral);	
			tabdata.put("restrict_pract_self_rfl_ip_op",restrict_pract_self_rfl_ip_op);	
			tabdata.put("restrict_pract_self_rfl_op_ip",restrict_pract_self_rfl_op_ip);	
			tabdata.put("restrict_bedside_self_referral",restrict_bedside_self_referral);
			tabdata.put("allow_recode_diag_yn",allow_recode_diag_yn);	
			tabdata.put("allow_recode_proc_yn",allow_recode_proc_yn);	
			tabdata.put("allow_ot_proc_recode_yn",allow_ot_proc_recode_yn);	
			tabdata.put("allow_non_ot_proc_recode_yn",allow_non_ot_proc_recode_yn);	
			tabdata.put("recode_for_op_yn",recode_for_op_yn);	
			tabdata.put("recode_for_ip_yn",recode_for_ip_yn);	
			tabdata.put("recode_for_dc_yn",recode_for_dc_yn);	
			tabdata.put("recode_for_em_yn",recode_for_em_yn);	
			tabdata.put("recode_allow_beynd_max_lev_yn",recode_allow_beynd_max_lev_yn);	
			tabdata.put("addl_field1_prompt",addl_field1_prompt);
            tabdata.put("addl_field1_length",addl_field1_length);
            tabdata.put("addl_field1_section",addl_field1_section );
            tabdata.put("addl_field2_prompt",addl_field2_prompt);
            tabdata.put("addl_field2_length",addl_field2_length);
            tabdata.put("addl_field2_section",addl_field2_section );
            tabdata.put("addl_field3_prompt",addl_field3_prompt);
            tabdata.put("addl_field3_length",addl_field3_length);
            tabdata.put("addl_field3_section",addl_field3_section );
            tabdata.put("addl_field4_prompt",addl_field4_prompt);
            tabdata.put("addl_field4_length",addl_field4_length);
            tabdata.put("addl_field4_section",addl_field4_section );
            tabdata.put("addl_field5_prompt",addl_field5_prompt);
            tabdata.put("addl_field5_length",addl_field5_length);
            tabdata.put("addl_field5_section",addl_field5_section );
            tabdata.put("DF_NEW_PROC_TYPE_FR_RECODE",proc_type_for_recode );//Added On 12/8/2009 For SRR-CRF-303.1
            tabdata.put("DIAG_ENC_LEVEL",diag_enc_level_yn );//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
			tabdata.put("max_level_for_op_yn",max_level_for_op_yn);	
			tabdata.put("max_level_for_ip_yn",max_level_for_ip_yn);	
			tabdata.put("max_level_for_dc_yn",max_level_for_dc_yn);	
			tabdata.put("max_level_for_em_yn",max_level_for_em_yn);	
			tabdata.put("grace_period",grace_period);	
			tabdata.put("drg_calculation_yn",drg_calculation_yn);	
			tabdata.put("auth_at_stage",auth_at_stage);	
			tabdata.put("exclude_orig_code",exclude_orig_code_recode_yn);//Saturday, January 23, 2010 For SRR-CRF-303.2 	


			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		
			tabdata.put("RESTRICT_SEC_DIAG_YN",primaryDiagMandate ); //Added by Ashwin K for MMS-DM-CRF-0197.1
		
			tabdata.put("DIAG_CATG_PR_FOR_OP_YN",diag_catg_mand_for_op_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1
			tabdata.put("DIAG_CATG_PR_FOR_IP_YN",diag_catg_mand_for_ip_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1
			tabdata.put("DIAG_CATG_PR_FOR_EM_YN",diag_catg_mand_for_em_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1
			tabdata.put("DIAG_CATG_PR_FOR_DC_YN",diag_catg_mand_for_dc_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1
						
			/*Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start*/
			if(medReqAuthApplicable.equals("true")){
			tabdata.put("MEDICAL_REQ_AUTHORIZE_VALIDITY ",medReqAuth); 
			}
			/*End*/

			/*Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719 Start*/
			if(incompReqCancelApplicable.equals("true")){
				tabdata.put("AUTO_CANCEL_MEDICAL_REQ_DAYS",incompleteReqCancel); 
			}
			/*End*/

			/*Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720*/
			tabdata.put("mr_hdr_line1",mr_hdr_line1);
			tabdata.put("mr_hdr_line2",mr_hdr_line2);
			tabdata.put("mr_hdr_line3",mr_hdr_line3);
			tabdata.put("mr_hdr_line4",mr_hdr_line4);
			tabdata.put("mr_hdr_line5",mr_hdr_line5);
			tabdata.put("mr_hdr_line6",mr_hdr_line6);
			tabdata.put("mr_hdr_line7",mr_hdr_line7);//Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
			tabdata.put("mr_sign_line1",mr_sign_line1);
			tabdata.put("mr_sign_line2",mr_sign_line2);
			tabdata.put("mr_sign_line3",mr_sign_line3);
			tabdata.put("mr_sign_line4",mr_sign_line4);
			tabdata.put("mr_sign_line5",mr_sign_line5);
			tabdata.put("mr_sign_line6",mr_sign_line6);
			tabdata.put("mr_sign_line7",mr_sign_line7);
			tabdata.put("mr_sign_line8",mr_sign_line8); //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
			tabdata.put("mr_sign_line9",mr_sign_line9); //Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
			/*End*/

          /*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
          tabdata.put("MAX_DAYS_NOTIFY_DIS_LST",rep_date_range);
/* ----end KDAH-CRF-0032---*/
          tabdata.put("allergy_conf_reqd_yn",checkForNull(req.getParameter ("allergy_conf_reqd_yn"),"N"));

          /*Below line Addded for this CRF [PMG2013-CRF-0006]*/
		  tabdata.put("DFLT_TAB_IN_DIAG_SEL",dflt_tab_in_diag_sel);
		  tabdata.put("DIAG_CLASS_MAND_YN",diag_class_mand);
		 
		 tabdata.put("witness_pass_validate_yn",witness_pass_validate_yn); //Added for this CRF HSA-CRF-0222
		 tabdata.put("DIAGNOSIS_BY_LONG_DESC_YN",diagnosis_by_long_desc_yn); // Added for this CRF - 0234
		 
		 tabdata.put("notifiable_form_mand_yn",notifiable_form_mand_yn);  //Added for this CRF Bru-HIMS-CRF-024.2
		
		tabdata.put("medrep_collection_days",medrep_collection_days );/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
		tabdata.put("MAX_NUM_DAYS_BHT_SUBMISSION",max_num_day_for_BHT ); //added by Himanshu Saxena for ML-MOHE-CRF-1959 on 21-06-2023

		tabdata.put("enable_link_to_curr_enc_s",enableLinkToCurrEnc ); //added by Ajay Hatwate for ML-MOHE-CRF-1741
		tabdata.put("crs_chk_mand_flds_on_link_diag",crossChkDfltMand); //added by Ajay Hatwate for ML-MOHE-CRF-1741
		
		if(eNotifikasiDemographicsAppl.equals("true")){
			tabdata.put("rest_integration_enotifikasi",rest_integration_enotifikasi ); //Added by Santhosh for ML-MMOH-CRF-2156
		}
			HashMap condflds=new HashMap();
			//condflds.put("added_facility_id",addedFacilityId);

			String tableName = "MR_PARAMETER";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value="";
			if(inserted)
			{
				error_value = "1" ;
			}
			else
			{
				error_value = "0" ;
				error = (String) results.get("error") ;
			}

        	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=" + error_value );
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}
		catch ( Exception e )
		{ 
			//out.println("<h3> Exception raise by Servlet ...So Record Not Updated </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}

	private void insertDiagProcScheme(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			//DiagCodeScheme = req.getParameter("diag_code_scheme");
			//ProcCodeScheme = req.getParameter("proc_code_scheme");

			g6pd_discr_msr_id = req.getParameter("g6pd_discr_msr_id");
			sicc_discr_msr_id = req.getParameter("sicc_discr_msr_id");

			mr_pay_int_mode = req.getParameter("mr_pay_int_mode");
			adult_min_age = checkForNull(req.getParameter("adult_min_age"));
			adult_min_unit = checkForNull(req.getParameter("adult_min_unit"));
			adult_max_age = checkForNull(req.getParameter("adult_max_age"));
			adult_max_unit = checkForNull(req.getParameter("adult_max_unit"));

			pead_min_age = checkForNull(req.getParameter("pead_min_age"));
			pead_min_unit = checkForNull(req.getParameter("pead_min_unit"));
			pead_max_age = checkForNull(req.getParameter("pead_max_age"));
			pead_max_unit = checkForNull(req.getParameter("pead_max_unit"));

			newborn_min_age = checkForNull(req.getParameter("newborn_min_age"));
			newborn_min_unit = checkForNull(req.getParameter("newborn_min_unit"));
			newborn_max_age = checkForNull(req.getParameter("newborn_max_age"));
			newborn_max_unit = checkForNull(req.getParameter("newborn_max_unit"));

			ext_mand_for_consq = checkForNull(req.getParameter("ext_mand_for_consq"),"N");
			astk_mand_for_dagg = checkForNull(req.getParameter("astk_mand_for_dagg"),"N");
			
			allow_recode_diag_yn = checkForNull(req.getParameter("allow_recode_diag_yn"),"N");
			allow_recode_proc_yn = checkForNull(req.getParameter("allow_recode_proc_yn"),"N");
			allow_ot_proc_recode_yn = checkForNull(req.getParameter("allow_ot_proc_recode_yn"),"N");
			allow_non_ot_proc_recode_yn = checkForNull(req.getParameter("allow_non_ot_proc_recode_yn"),"N");
			
			recode_for_op_yn = checkForNull(req.getParameter("recode_for_op_yn"),"N");
			recode_for_ip_yn = checkForNull(req.getParameter("recode_for_ip_yn"),"N");
			recode_for_dc_yn = checkForNull(req.getParameter("recode_for_dc_yn"),"N");
			recode_for_em_yn = checkForNull(req.getParameter("recode_for_em_yn"),"N");
			
			recode_allow_beynd_max_lev_yn = checkForNull(req.getParameter("recode_allow_beynd_max_lev_yn"),"N");
			
			max_level_for_op_yn = checkForNull(req.getParameter("max_level_for_op_yn"),"N");
			max_level_for_ip_yn = checkForNull(req.getParameter("max_level_for_ip_yn"),"N");
			max_level_for_dc_yn = checkForNull(req.getParameter("max_level_for_dc_yn"),"N");
			max_level_for_em_yn = checkForNull(req.getParameter("max_level_for_em_yn"),"N");
			drg_calculation_yn = checkForNull(req.getParameter("drg_calculation_yn"),"N");

			max_pri_diag_indicate_co_death	  = checkForNull(req.getParameter("max_pri_diag_indicate_co_death"));
			max_oth_dis_comp_indi_co_death = checkForNull(req.getParameter("max_oth_dis_comp_indi_co_death"));
			grace_period				=req.getParameter("grace_period")==null?"":req.getParameter("grace_period").trim();
			//auth_appl_stage=req.getParameter("auth_appl_stage")==null?"":req.getParameter("auth_appl_stage").trim();
			auth_at_stage				= checkForNull(req.getParameter("auth_at_stage"));
			addl_field1_prompt		=	checkForNull(req.getParameter ("addl_field1_prompt"));
			addl_field1_length		=	checkForNull(req.getParameter ("addl_field1_length"));
			addl_field1_section		=	checkForNull(req.getParameter ("addl_field1_section"));
			addl_field2_prompt		=	checkForNull(req.getParameter ("addl_field2_prompt"));
			addl_field2_length		=	checkForNull(req.getParameter ("addl_field2_length"));
			addl_field2_section		=	checkForNull(req.getParameter ("addl_field2_section"));
			addl_field3_prompt		=	checkForNull(req.getParameter ("addl_field3_prompt"));
			addl_field3_length		=	checkForNull(req.getParameter ("addl_field3_length"));
			addl_field3_section		=	checkForNull(req.getParameter ("addl_field3_section"));
			addl_field4_prompt		=	checkForNull(req.getParameter ("addl_field4_prompt"));
			addl_field4_length		=	checkForNull(req.getParameter ("addl_field4_length"));
			addl_field4_section		=	checkForNull(req.getParameter ("addl_field4_section"));
			addl_field5_prompt		=	checkForNull(req.getParameter ("addl_field5_prompt"));
			addl_field5_length		=	checkForNull(req.getParameter ("addl_field5_length"));
			addl_field5_section		=	checkForNull(req.getParameter ("addl_field5_section"));
			proc_type_for_recode =	checkForNull(req.getParameter ("proc_type_setup"));// Added On 12/8/2009 For SRR-CRF-303.1
			exclude_orig_code_recode_yn =	checkForNull(req.getParameter ("exclude_orig_code_recode_yn"));// Added On Saturday, January 23, 2010 For SRR-CRF-303.2
			
			/*Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start*/
			   medReqAuth				= req.getParameter("medReqAuthorize"); 
			   medReqAuthApplicable		= req.getParameter("MedReqAuthApplicable");
			  /*End*/

			/*Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719 Start*/
			incompleteReqCancel				= checkForNull(req.getParameter("incompleteReqCancel"),"0"); 
			incompReqCancelApplicable		= checkForNull(req.getParameter("IncompReqCancelApplicable"));
			/*End*/
			
			/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/

			rep_date_range			= checkForNull(req.getParameter ("rep_date_range"));
/* ----end KDAH-CRF-0032---*/

            /*Below line added for this CRF Bru-HIMS-CRF-024.2*/
	        notifiable_form_mand_yn=checkForNull(req.getParameter("notifiable_form_mand_yn"),"N");   
              /*Below line Added for this CRF PMG2013-CRF-0006*/		
			dflt_tab_in_diag_sel		= checkForNull(req.getParameter ("dflt_tab_in_diag_sel"));        

			diag_class_mand = checkForNull(req.getParameter ("diag_class_mand"),"N");
			diag_enc_level_yn= checkForNull(req.getParameter("diag_enc_level"),"N");//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
			
			witness_pass_validate_yn= checkForNull(req.getParameter("witness_pass_validate_yn"),"N"); //Added for this CRF HSA-CRF-0222
			diagnosis_by_long_desc_yn= checkForNull(req.getParameter("diagnosis_by_long_desc_yn"),"N"); // Added for this CRF - 0234

			/*Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720*/
			mr_hdr_line1				= checkForNull(req.getParameter ("mr_hdr_line1"));
			mr_hdr_line2				= checkForNull(req.getParameter ("mr_hdr_line2"));
			mr_hdr_line3				= checkForNull(req.getParameter ("mr_hdr_line3"));
			mr_hdr_line4				= checkForNull(req.getParameter ("mr_hdr_line4"));
			mr_hdr_line5				= checkForNull(req.getParameter ("mr_hdr_line5"));
			mr_hdr_line6				= checkForNull(req.getParameter ("mr_hdr_line6"));
			mr_hdr_line7				= checkForNull(req.getParameter ("mr_hdr_line7"));//Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
			mr_sign_line1				= checkForNull(req.getParameter ("mr_sign_line1"));
			mr_sign_line2				= checkForNull(req.getParameter ("mr_sign_line2"));
			mr_sign_line3				= checkForNull(req.getParameter ("mr_sign_line3"));
			mr_sign_line4				= checkForNull(req.getParameter ("mr_sign_line4"));
			mr_sign_line5				= checkForNull(req.getParameter ("mr_sign_line5"));
			mr_sign_line6				= checkForNull(req.getParameter ("mr_sign_line6"));
			mr_sign_line7				= checkForNull(req.getParameter ("mr_sign_line7"));
			mr_sign_line8				= checkForNull(req.getParameter ("mr_sign_line8")); //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
			mr_sign_line9				= checkForNull(req.getParameter ("mr_sign_line9")); //Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
			/*End*/

			primaryDiagMandate = checkForNull(req.getParameter ("Primary_Diag_Mandate")); //Added by Ashwin K for MMS-DM-CRF-0197.1

			/* Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1 */	
			diag_catg_mand_for_op_yn = checkForNull(req.getParameter ("diag_catg_mand_for_op_yn"), "N");
			diag_catg_mand_for_ip_yn = checkForNull(req.getParameter ("diag_catg_mand_for_ip_yn"), "N");
			diag_catg_mand_for_em_yn = checkForNull(req.getParameter ("diag_catg_mand_for_em_yn"), "N");
			diag_catg_mand_for_dc_yn = checkForNull(req.getParameter ("diag_catg_mand_for_dc_yn"), "N");

			 medrep_collection_days = checkForNull(req.getParameter("medrep_collection_days"));/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
			 max_num_day_for_BHT= checkForNull(req.getParameter ("max_num_day_for_BHT"));
			 
				crossChkDfltMand= checkForNull(req.getParameter ("crossCheckDfltMand"));//added by Ajay Hatwate for ML-MOHE-CRF-1741
				enableLinkToCurrEnc= checkForNull(req.getParameter ("enableLinkToCurrEnc"));//added by Ajay Hatwate for ML-MOHE-CRF-1741
			 
			 if(eNotifikasiDemographicsAppl.equals("true")){
				rest_integration_enotifikasi= checkForNull(req.getParameter ("rest_integration_enotifikasi"));//Added by Santhosh for ML-MMOH-CRF-2156
			}
			 
			 
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
			//tabdata.put("diag_code_scheme",DiagCodeScheme);
			//tabdata.put("proc_code_scheme",ProcCodeScheme);

			tabdata.put("g6pd_discr_msr_id",g6pd_discr_msr_id);
			tabdata.put("sicc_discr_msr_id",sicc_discr_msr_id);
			tabdata.put("MEDREP_PAY_INT_MODE",mr_pay_int_mode);
			tabdata.put("ADULT_MIN_AGE_VALUE",adult_min_age);
			tabdata.put("ADULT_MIN_AGE_UNIT",adult_min_unit);
			tabdata.put("ADULT_MAX_AGE_VALUE",adult_max_age);
			tabdata.put("ADULT_MAX_AGE_UNIT",adult_max_unit);

			tabdata.put("PEAD_MIN_AGE_VALUE",pead_min_age);
			tabdata.put("PEAD_MIN_AGE_UNIT",pead_min_unit);
			tabdata.put("PEAD_MAX_AGE_VALUE",pead_max_age);
			tabdata.put("PEAD_MAX_AGE_UNIT",pead_max_unit);

			tabdata.put("NB_MIN_AGE_VALUE",newborn_min_age);
			tabdata.put("NB_MIN_AGE_UNIT",newborn_min_unit);
			tabdata.put("NB_MAX_AGE_VALUE",newborn_max_age);
			tabdata.put("NB_MAX_AGE_UNIT",newborn_max_unit);	

			tabdata.put("ext_mand_for_consq",ext_mand_for_consq);				
			tabdata.put("astk_mand_for_dagg",astk_mand_for_dagg);	
			
			tabdata.put("allow_recode_diag_yn",allow_recode_diag_yn);	
			tabdata.put("allow_recode_proc_yn",allow_recode_proc_yn);	
			tabdata.put("allow_ot_proc_recode_yn",allow_ot_proc_recode_yn);	
			tabdata.put("allow_non_ot_proc_recode_yn",allow_non_ot_proc_recode_yn);	
			
			tabdata.put("recode_for_op_yn",recode_for_op_yn);	
			tabdata.put("recode_for_ip_yn",recode_for_ip_yn);	
			tabdata.put("recode_for_dc_yn",recode_for_dc_yn);	
			tabdata.put("recode_for_em_yn",recode_for_em_yn);	
			
			tabdata.put("recode_allow_beynd_max_lev_yn",recode_allow_beynd_max_lev_yn);	

			tabdata.put("max_oth_dis_comp_indi_co_death",max_oth_dis_comp_indi_co_death);
			tabdata.put("max_pri_diag_indicate_co_death",max_pri_diag_indicate_co_death);
			
			tabdata.put("max_level_for_op_yn",max_level_for_op_yn);	
			tabdata.put("max_level_for_ip_yn",max_level_for_ip_yn);	
			tabdata.put("max_level_for_dc_yn",max_level_for_dc_yn);	
			tabdata.put("max_level_for_em_yn",max_level_for_em_yn);	
			tabdata.put("grace_period",grace_period);	
			tabdata.put("drg_calculation_yn",drg_calculation_yn);	
			tabdata.put("auth_at_stage",auth_at_stage);	

			tabdata.put("addl_field1_prompt",addl_field1_prompt);
            tabdata.put("addl_field1_length",addl_field1_length);
            tabdata.put("addl_field1_section",addl_field1_section );
            tabdata.put("addl_field2_prompt",addl_field2_prompt);
            tabdata.put("addl_field2_length",addl_field2_length);
            tabdata.put("addl_field2_section",addl_field2_section );
            tabdata.put("addl_field3_prompt",addl_field3_prompt);
            tabdata.put("addl_field3_length",addl_field3_length);
            tabdata.put("addl_field3_section",addl_field3_section );
            tabdata.put("addl_field4_prompt",addl_field4_prompt);
            tabdata.put("addl_field4_length",addl_field4_length);
            tabdata.put("addl_field4_section",addl_field4_section );
            tabdata.put("addl_field5_prompt",addl_field5_prompt);
            tabdata.put("addl_field5_length",addl_field5_length);
            tabdata.put("addl_field5_section",addl_field5_section );
            tabdata.put("DF_NEW_PROC_TYPE_FR_RECODE",proc_type_for_recode );//Added On 12/8/2009 For SRR-CRF-303.1
            tabdata.put("DIAG_ENC_LEVEL",diag_enc_level_yn );//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
			tabdata.put("exclude_orig_code",exclude_orig_code_recode_yn);//Saturday, January 23, 2010 For SRR-CRF-303.2 	
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			tabdata.put("RESTRICT_SEC_DIAG_YN",primaryDiagMandate ); //Added by Ashwin K for MMS-DM-CRF-0197.1
			tabdata.put("DIAG_CATG_PR_FOR_OP_YN",diag_catg_mand_for_op_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1
			tabdata.put("DIAG_CATG_PR_FOR_IP_YN",diag_catg_mand_for_ip_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1
			tabdata.put("DIAG_CATG_PR_FOR_EM_YN",diag_catg_mand_for_em_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1
			tabdata.put("DIAG_CATG_PR_FOR_DC_YN",diag_catg_mand_for_dc_yn ); //Added by Ajay on 21/12/2022 for TH-KW-CRF 165.1

			/*Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720*/
			tabdata.put("mr_hdr_line1",mr_hdr_line1);
			tabdata.put("mr_hdr_line2",mr_hdr_line2);
			tabdata.put("mr_hdr_line3",mr_hdr_line3);
			tabdata.put("mr_hdr_line4",mr_hdr_line4);
			tabdata.put("mr_hdr_line5",mr_hdr_line5);
			tabdata.put("mr_hdr_line6",mr_hdr_line6);
			tabdata.put("mr_hdr_line7",mr_hdr_line7);//Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
			tabdata.put("mr_sign_line1",mr_sign_line1);
			tabdata.put("mr_sign_line2",mr_sign_line2);
			tabdata.put("mr_sign_line3",mr_sign_line3);
			tabdata.put("mr_sign_line4",mr_sign_line4);
			tabdata.put("mr_sign_line5",mr_sign_line5);
			tabdata.put("mr_sign_line6",mr_sign_line6);
			tabdata.put("mr_sign_line7",mr_sign_line7);
			tabdata.put("mr_sign_line8",mr_sign_line8); //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
			/*End*/
			tabdata.put("mr_sign_line9",mr_sign_line9);//Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
			/*Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start*/
			if(medReqAuthApplicable.equals("true")){
			tabdata.put("MEDICAL_REQ_AUTHORIZE_VALIDITY ",medReqAuth); 
			}
			/*End*/

			/*Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719 Start*/
			if(incompReqCancelApplicable.equals("true")){
				tabdata.put("AUTO_CANCEL_MEDICAL_REQ_DAYS",incompleteReqCancel); 
			}
			/*End*/

			/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
tabdata.put("MAX_DAYS_NOTIFY_DIS_LST",rep_date_range);
/* ----end KDAH-CRF-0032---*/

          /*Below line Added for this CRF PMG2013-CRF-0006*/
          tabdata.put("DFLT_TAB_IN_DIAG_SEL",dflt_tab_in_diag_sel);
		  
		  tabdata.put("DIAG_CLASS_MAND_YN",diag_class_mand);
		  
		  tabdata.put("allergy_conf_reqd_yn",checkForNull(req.getParameter ("allergy_conf_reqd_yn"),"N"));//added for the cRF RUT-CRF-0064
		  
		 tabdata.put("witness_pass_validate_yn",witness_pass_validate_yn); //Added for this CRF HSA-CRF-0222
		  tabdata.put("DIAGNOSIS_BY_LONG_DESC_YN",diagnosis_by_long_desc_yn); // Added for this CRF - 0234
		   tabdata.put("notifiable_form_mand_yn",notifiable_form_mand_yn); //Added for this CRF Bru-HIMS-CRF-024.2

		   tabdata.put("medrep_collection_days",medrep_collection_days );/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
		   tabdata.put("MAX_NUM_DAYS_BHT_SUBMISSION",max_num_day_for_BHT ); //added by Himanshu Saxena for ML-MOHE-CRF-1959 on 21-06-2023
		   
		   tabdata.put("enable_link_to_curr_enc_s",enableLinkToCurrEnc ); //added by Ajay Hatwate for ML-MOHE-CRF-1741
			tabdata.put("crs_chk_mand_flds_on_link_diag",crossChkDfltMand); //added by Ajay Hatwate for ML-MOHE-CRF-1741
			
			if(eNotifikasiDemographicsAppl.equals("true")){
				tabdata.put("rest_integration_enotifikasi",rest_integration_enotifikasi ); //Added by Santhosh for ML-MMOH-CRF-2156
			}

			String dupflds[]={"added_facility_id"};

			String tableName = "MR_PARAMETER";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value="";
			if ( inserted )
			{
				error_value = "1" ;
			}
			else
			{
				error = (String) results.get("error") ;
				error_value = "0" ;
			}

		   	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		}
		catch ( Exception e )
		{  
//			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted</h3> Foll: Error Received : "+e.toString()+"DiagCodeScheme   "+DiagCodeScheme+"g6pd_discr_msr_id :" +sicc_discr_msr_id+" sicc_discr_msr_id "+sicc_discr_msr_id);
		e.printStackTrace();
		}
	}


	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
