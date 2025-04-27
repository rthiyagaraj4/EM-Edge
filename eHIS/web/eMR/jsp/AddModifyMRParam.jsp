<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script language='javascript' src='../../eMR/js/MRParam.js'></script> 
		<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
		<script>
				function checkME(obj){
					if(obj.checked){
						obj.value="Y";
					}else{
						obj.value="N";
					}
				}

				function chkAllZeros(obj){
					if(obj.value=="000" ||obj.value=="00"||obj.value=="0"){
						alert(getMessage("GRACE_PERIOD",'MR'));
						  obj.focus();
						  obj.select();
						return false;
				}else{
					return true;
				}
			}
	</script>
</head>
<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
<%

PreparedStatement pstmt	= null;
ResultSet reset = null;
String locale = (String)session.getAttribute("LOCALE");

String DiagCodeScheme	= "";
String ProcCodeScheme	= "";
//String MRParamDiagCols[]={"---Select---","ICD10","ICD9-CM"};
//String MRParamDiagVals[]={"","1","2"};
//String MRParamProcCols[]={"---Select---","CPT4","ICD9-CM","ICD10-PCS"};
//String MRParamProcVals[]={"","3","4","6"};
//String val_1="";
String sql						   = "";
String g6pd_discr_msr_id = "";
String sicc_discr_msr_id	= "";
String medrep_pay_int_mode	= "";
String adult_max_age_unit		= "";
int adult_max_age_value			= 0;
String adult_min_age_unit			= "";
int adult_min_age_value			= 0;
String nb_max_age_unit			= "";
int nb_max_age_value				= 0;
String nb_min_age_unit				= "";
int nb_min_age_value				= 0;
String pead_max_age_unit		= "";
int pead_max_age_value			= 0;
String pead_min_age_unit			= "";
String g6pd_desc						= "";
String sicc_desc						= "";
int pead_min_age_value			= 0;
String ext_mand_for_consq_yn= "N";
String astk_mand_for_dagg_yn= "N";
String single_stage_death_reg_appl_yn	= "N";
String restrict_pract_self_referral		= "N";
String restrict_pract_self_rfl_ip_op	= "N";
String restrict_pract_self_rfl_op_ip	= "N";
String restrict_bedside_self_referral	= "N";
String max_oth_dis_comp_indi_co_death	= "";
String max_pri_diag_indicate_co_death	= "";
String checkall											= "";
String checkall2											= "";


String	primary_diag_mandate = ""; //Added by Ashwin K for MMS-DM-CRF-0197.1 
String	primary_diag_mandate_check = ""; //Added by Ashwin K for MMS-DM-CRF-0197.1 
String medReqAuth = ""; //Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777
		
String max_num_day_for_BHT=""; //added by Himanshu Saxena for ML-MOHE-CRF-1959 on 21-06-2023

String incompleteReqCancel	= ""; //Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719

String allow_recode_diag_yn					= "N";
String allow_recode_proc_yn					= "N";
String allow_ot_proc_recode_yn				= "N";
String allow_non_ot_proc_recode_yn		= "N";
String recode_for_op_yn							= "N";
String recode_for_ip_yn							= "N";
String recode_for_em_yn							= "N";
String recode_for_dc_yn							= "N";
String recode_allow_beynd_max_lev_yn	= "N";
String max_level_for_op_yn						= "N";
String max_level_for_ip_yn						= "N";
String max_level_for_dc_yn						= "N";
String max_level_for_em_yn						= "N";
String drg_calculation_yn							= "N";
String graceperiod						= "";
String auth_at_stage					= "";
String proc_type_for_recode	= "";//Added On 12/7/2009
String allergy_conf_reqd_yn	= "";//Added for the CRF -RUT-CRF-0064
//String auth_stage="";
String checkdisable					= "";
String checkdisable1					= "";
String checkdisable4					= "";
String checkdisable_drg			= "";
String checkdisable5					= "";
String checkdisable6					= "";
String checkdisable7					= "";
String checkdisable8					= "";
String checkdisable9					= "";
String imagvalue						= "";
String checkall3							= "";
String checkall4							= "";
//String checkall5="";
String checkall6							= "";
String checkall7							= "";
String checkall8							= "";
String checkall9							= "";
String checkall10						= "";
String checkall11						= "";
String checkall12						= "";
String checkall13						= "";
String checkall14						=	"";
String checkall15						= "";
String checkall16						= "";
String checkall17						= "";
String checkall18						= "";
String checkall19						= "";//Added for the CRF RUT-CRF-0064
//Added by Ajay for TH-KW-CRF-165.1
String checkall21 = "";
String checkall22 = "";
String checkall23 = "";
String checkall24 = "";

String checkall25 = "";
String checkall26 = "";
String checkall27 = "";
String checkall28 = "";

String diag_catg_mand_for_op_yn = "N";
String diag_catg_mand_for_ip_yn = "N";
String diag_catg_mand_for_em_yn = "N";
String diag_catg_mand_for_dc_yn = "N";

//Abbed below linf for this CRF HSA-CRF-0222
String witness_pass_validate_yn="", checkwitness="";
//Added below line for this CRF - 0234
String diagnosis_by_long_desc_yn="", checksearchval="";

String addl_field1_prompt			= "";
String addl_field1_length			= "";
String addl_field1_section			= "";
String addl_field2_prompt	        = "";
String addl_field2_length			= "";
String addl_field2_section			= "";
String addl_field3_prompt	        = "";
String addl_field3_length			= "";
String addl_field3_section			= "";
String addl_field4_prompt	        = "";
String addl_field4_length			= "";
String addl_field4_section			= "";
String addl_field5_prompt	        = "";
String addl_field5_length			= "";
String addl_field5_section			= "";
String addl_field_disable			= "";

String sec11		="";
String sec12		="";
String sec13		="";
String sec14		="";
String sec15		="";
String sec21		="";
String sec22		="";
String sec23		="";
String sec24		="";
String sec25		="";
String sec31		="";
String sec32		="";
String sec33		="";
String sec34		="";
String sec35		="";
String sec41		="";
String sec42		="";
String sec43		="";
String sec44		="";
String sec45		="";
String sec51		="";
String sec52		="";
String sec53		="";
String sec54		="";
String sec55		="";
String exclude_orig_code_recode_yn		="";

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
/*End*/
String mr_sign_line9	= "";//Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365

Connection conn	= null;
Statement stmt		= null;    
ResultSet rset		= null;
boolean newDiagCode = false;
boolean billingIntsalled = false;
String facility_id				= "";
String enble_ot_proc_dis	= "";
String enble_ot_proc_chk	 = "";
String operation				 = "modify";
boolean chk_OT_proc		=false;
//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
//Start 
String diag_enc_level_yn="";
String diag_enc_level_chk="N";
//End

boolean isSiteSpecific		=false;//Added for the CRF - RUT-CRF-0064


/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/

String lab_test_days_range="";

/* ----end KDAH-CRF-0032---*/
/*Below variable Added for this CRF [PMG2013-CRF-0006]*/
String dflt_tab_in_diag_sel="";
String cus_diag_sel="", search_diag_sel=""; 

String diag_class_mand_yn=""; String checkmand="";
//End [PMG2013-CRF-0006]
/*Below line Added for this CRF Bru-HIMS-CRF-024.2*/  
String notifi_form_mand_yn="N";String notificheck="";

String medrep_collection_days="";/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/

//Added by Ajay Hatwate for ML-MMOH-CRF-1741
String crossChkDfltMandCheck = "";
String crossChkDfltMandDis = "";
String crossChkDfltMand = "";
String enableLinkToCurrEnc = "";
String enableLinkToCurrEncCheck = "";
//End of ML-MMOH-CRF-1741

//Added by Santhosh for ML-MMOH-CRF-2156 
String rest_integration_enotifikasi="N";
String checkENotifikasi="";
boolean eNotifikasiDemographicsAppl=false;
//End

/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
Boolean isDeceasedDiagClassDeathRegAppl = false;
String auto_fin_death_reg_appl_yn		= "N";
String checkautofinalize				= "";
String primary_diag_class				= "";
String pri_diag_class_dis				= "";
String pri_diag_class_code				= "";
String pri_diag_class_desc				= "";
String pri_mand_postmortem_ip_yn		= "N";
String checkpmpip						= "";
String dispmpip							= "disabled";
String pri_mand_postmortem_dc_yn		= "N";
String checkpmpdc						= "";
String dispmpdc							= "disabled";
String pri_mand_postmortem_op_yn		= "N";
String checkpmpop						= "";
String dispmpop							= "disabled";
String pri_mand_postmortem_ae_yn		= "N";
String checkpmpae						= "";
String dispmpae							= "disabled";
String pri_mand_non_postmortem_ip_yn	= "N";
String checkpmnpip						= "";
String dispmnpip						= "disabled";
String pri_mand_non_postmortem_dc_yn	= "N";
String checkpmnpdc						= "";
String dispmnpdc						= "disabled";
String pri_mand_non_postmortem_op_yn	= "N";
String checkpmnpop						= "";
String dispmnpop						= "disabled";
String pri_mand_non_postmortem_ae_yn	= "N";
String checkpmnpae						= "";
String dispmnpae						= "disabled";
String secondary_diag_class				= "";
String sec_diag_class_dis				= "";
String sec_diag_class_code				= "";
String sec_diag_class_desc				= "";
String sec_mand_postmortem_ip_yn		= "N";
String checksmpip						= "";
String dissmpip							= "disabled";
String sec_mand_postmortem_dc_yn		= "N";
String checksmpdc						= "";
String dissmpdc							= "disabled";
String sec_mand_postmortem_op_yn		= "N";
String checksmpop						= "";
String dissmpop							= "disabled";
String sec_mand_postmortem_ae_yn		= "N";
String checksmpae						= "";
String dissmpae							= "disabled";
String sec_mand_non_postmortem_ip_yn	= "N";
String checksmnpip						= "";
String dissmnpip						= "disabled";
String sec_mand_non_postmortem_dc_yn	= "N";
String checksmnpdc						= "";
String dissmnpdc						= "disabled";
String sec_mand_non_postmortem_op_yn	= "N";
String checksmnpop						= "";
String dissmnpop						= "disabled";
String sec_mand_non_postmortem_ae_yn	= "N";
String checksmnpae						= "";
String dissmnpae						= "disabled";
/*End ML-MMOH-CRF-1742*/

			try{
				conn = ConnectionManager.getConnection(request); 
				 facility_id=(String) session.getValue( "facility_id" ) ;
				 isSiteSpecific=eOP.QMSInterface.isSiteSpecific(conn,"MR","ALLERGY_CONFIRM");//Added for the CRF - RUT-CRF-0064
				
				Boolean isMedReqAuthApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","OUTSTAMT_CHECK_MED_REPORT_REQ");//Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777

				Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","TYPES_OF_NOTIFICATION_FORM"); //Added by Sangeetha for ML-MMOH-CRF-0547

				Boolean isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719

				Boolean isSignOfMedRecApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","SIGN_OF_MED_RECORDS");//Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720
				
				Boolean isDiagCatgMand  = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MR_DIAG_CATEGORY_MAND"); //Added by Ajay for TH-KW-CRF-165.1

				Boolean isPatientBHT =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","PATIENT_BHT_STATUS");//Added by Himanshu Saxena on 21th june 2023 for ML-MMOH-CRF-1959

				eNotifikasiDemographicsAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ENOTIFIKASI_DEMOGRAPHICS_APPL");//Added by Santhosh for ML-MMOH-CRF-2156

				isDeceasedDiagClassDeathRegAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

				try{
			/*Added For Allow procedure Recoding :OT Procedure on 7/2/2009*/
					String Instal_OT_yn="N";
					String Operational_yn="N";
					String sql_instal_OT_yn	="SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID='OT' ";
					String sql_operational_yn	="SELECT OPERATIONAL_YN FROM SM_MODULES_FACILITY WHERE MODULE_ID='OT' AND FACILITY_ID='"+facility_id+"' ";
						stmt = conn.createStatement();
						rset=stmt.executeQuery(sql_instal_OT_yn);	
						while(rset.next()){
							Instal_OT_yn=checkForNull(rset.getString("INSTALL_YN"));
						}
						if(rset!=null)rset.close();
						if(stmt!=null)stmt.close();

						if(Instal_OT_yn.equals("Y")){
							stmt = conn.createStatement();
							rset=stmt.executeQuery(sql_operational_yn);	
							while(rset.next()){
								Operational_yn	 =	checkForNull(rset.getString("OPERATIONAL_YN"));
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();

							if(Operational_yn.equals("Y")){
								chk_OT_proc=true;
			//					enble_ot_proc_dis	="";
							}else{
								chk_OT_proc=false;
			//					enble_ot_proc_dis	="disabled";
			//					enble_ot_proc_chk	="";
							}
						}else{
							chk_OT_proc=false;
			//				enble_ot_proc_dis	="disabled";
			//				enble_ot_proc_chk	="";
						}

			/***********Ends***************/
				stmt = conn.createStatement();

				sql = " select * from MR_PARAMETER ";

				rset = stmt.executeQuery(sql);

				if(rset.next()){
					DiagCodeScheme=rset.getString("diag_code_scheme");
					if(DiagCodeScheme==null)DiagCodeScheme="";
                     
					 /* Below line added by venkatesh.s  on 19/Jan/2012  aganist the  KDAH-CRF-0032*/
                          
						  lab_test_days_range = rset.getString("MAX_DAYS_NOTIFY_DIS_LST");	
						  	if(lab_test_days_range==null)lab_test_days_range="";
						 
						 /*  end   the  KDAH-CRF-0032 */


				/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
				 crossChkDfltMand = rset.getString("CRS_CHK_MAND_FLDS_ON_LINK_DIAG");
				 if(crossChkDfltMand==null)crossChkDfltMand="N";
				 if(crossChkDfltMand.equals("Y"))crossChkDfltMandCheck="checked";
				 
				 
				 enableLinkToCurrEnc = rset.getString("enable_link_to_curr_enc_s");
				 if(enableLinkToCurrEnc==null)enableLinkToCurrEnc="N";
				 if(enableLinkToCurrEnc.equals("Y")) enableLinkToCurrEncCheck="checked";
				 if(enableLinkToCurrEnc.equals("N")) crossChkDfltMandDis = "disabled";
				 

				 
				/* End of ML-MMOH-CRF-1741 */
						 
				/*Added by Rameswar on  30-06-2016 for 459*/	
				medrep_collection_days=rset.getString("medrep_collection_days");
				if(medrep_collection_days==null)medrep_collection_days="";	 
				/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/


				//Added by Ashwin K for MMS-DM-CRF-0197.1 
				primary_diag_mandate=rset.getString("RESTRICT_SEC_DIAG_YN");
				if(primary_diag_mandate.equals("Y")){
						primary_diag_mandate_check="checked";
					}else{
						primary_diag_mandate_check="";
					}

			
				//Ended by Ashwin K for MMS-DM-CRF-0197.1 
				/* Added by Ajay for TH-KW-CRF-165.1 */
										
					diag_catg_mand_for_op_yn = rset.getString("DIAG_CATG_PR_FOR_OP_YN");
					if(diag_catg_mand_for_op_yn == null) diag_catg_mand_for_op_yn = "N";
					if(diag_catg_mand_for_op_yn.equals("Y")){
						checkall21 = "checked";
					}else{
						checkall21 = "";
					}
					
					diag_catg_mand_for_ip_yn = rset.getString("DIAG_CATG_PR_FOR_IP_YN");
					if(diag_catg_mand_for_ip_yn==null) diag_catg_mand_for_ip_yn = "N";
					if(diag_catg_mand_for_ip_yn.equals("Y")){
						checkall22 = "checked";
					}else{
						checkall22 = "";
					}
										
					diag_catg_mand_for_em_yn = rset.getString("DIAG_CATG_PR_FOR_EM_YN");
					if(diag_catg_mand_for_em_yn==null) diag_catg_mand_for_em_yn = "N";
					if(diag_catg_mand_for_em_yn.equals("Y")){
						checkall23 = "checked";
					}else{
						checkall23 = "";
					}
					
					diag_catg_mand_for_dc_yn = rset.getString("DIAG_CATG_PR_FOR_DC_YN");
					if(diag_catg_mand_for_dc_yn == null)diag_catg_mand_for_dc_yn = "N";
					if(diag_catg_mand_for_dc_yn.equals("Y")){
						checkall24 = "checked";
					}else{
						checkall24 = "";
					}
					
					/* Ended TH-KW-CRF-165.1 */

					ProcCodeScheme=rset.getString("proc_code_scheme");
					if(ProcCodeScheme==null)ProcCodeScheme="";

					g6pd_discr_msr_id=rset.getString("g6pd_discr_msr_id");
					if(g6pd_discr_msr_id==null)g6pd_discr_msr_id="";

					sicc_discr_msr_id=rset.getString("sicc_discr_msr_id");
					if(sicc_discr_msr_id==null)sicc_discr_msr_id="";

					medrep_pay_int_mode=rset.getString("medrep_pay_int_mode");
					if(medrep_pay_int_mode==null)medrep_pay_int_mode="X";
					
					adult_max_age_unit=rset.getString("adult_max_age_unit");
					if(adult_max_age_unit==null)adult_max_age_unit="";
					adult_max_age_value=rset.getInt("adult_max_age_value");

					adult_min_age_unit=rset.getString("adult_min_age_unit");
					if(adult_min_age_unit==null)adult_min_age_unit="";
					adult_min_age_value=rset.getInt("adult_min_age_value");

					nb_max_age_unit=rset.getString("nb_max_age_unit");
					if(nb_max_age_unit==null)nb_max_age_unit="";
					nb_max_age_value=rset.getInt("nb_max_age_value");

					nb_min_age_unit=rset.getString("nb_min_age_unit");
					if(nb_min_age_unit==null)nb_min_age_unit="";
					nb_min_age_value=rset.getInt("nb_min_age_value");

					pead_max_age_unit=rset.getString("pead_max_age_unit");
					if(pead_max_age_unit==null)pead_max_age_unit="";
					pead_max_age_value=rset.getInt("pead_max_age_value");

					pead_min_age_unit=rset.getString("pead_min_age_unit");
					if(pead_min_age_unit==null)pead_min_age_unit="";
					pead_min_age_value=rset.getInt("pead_min_age_value");

					ext_mand_for_consq_yn=rset.getString("ext_mand_for_consq");
					if(ext_mand_for_consq_yn==null)ext_mand_for_consq_yn="N";

					if(ext_mand_for_consq_yn.equals("Y"))
						checkall="checked";
					else
						checkall="";

					astk_mand_for_dagg_yn=rset.getString("astk_mand_for_dagg");
					if(astk_mand_for_dagg_yn==null) astk_mand_for_dagg_yn="N";

					if(astk_mand_for_dagg_yn.equals("Y"))
						checkall2="checked";
					else
						checkall2="";
					
					/*Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start*/
					medReqAuth=rset.getString("MEDICAL_REQ_AUTHORIZE_VALIDITY");
					if(medReqAuth==null)medReqAuth="";
					/*End*/
					
					//added by Himanshu Saxena for ML-MOHE-CRF-1959 on 21-06-2023 Starts */
					max_num_day_for_BHT=rset.getString("MAX_NUM_DAYS_BHT_SUBMISSION");
					if(max_num_day_for_BHT==null)
						max_num_day_for_BHT="";
					//added by Himanshu Saxena for ML-MOHE-CRF-1959 on 21-06-2023 ends */
							
					incompleteReqCancel	= rset.getString("AUTO_CANCEL_MEDICAL_REQ_DAYS"); //Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719

					/*Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720*/
					 mr_hdr_line1	= rset.getString("MR_HDR_LINE1");
					 if(mr_hdr_line1==null)mr_hdr_line1="";
					 mr_hdr_line2	= rset.getString("MR_HDR_LINE2");
					 if(mr_hdr_line2==null)mr_hdr_line2="";
					 mr_hdr_line3	= rset.getString("MR_HDR_LINE3");
					 if(mr_hdr_line3==null)mr_hdr_line3="";
					 mr_hdr_line4	= rset.getString("MR_HDR_LINE4"); 
					 if(mr_hdr_line4==null)mr_hdr_line4="";
					 mr_hdr_line5	= rset.getString("MR_HDR_LINE5"); 
					 if(mr_hdr_line5==null)mr_hdr_line5="";
					 mr_hdr_line6	= rset.getString("MR_HDR_LINE6");
					 if(mr_hdr_line6==null)mr_hdr_line6="";
					 mr_hdr_line7	= rset.getString("MR_HDR_LINE7");
					 if(mr_hdr_line7==null)mr_hdr_line7="";
					 mr_sign_line1	= rset.getString("MR_SIGN_LINE1");
					 if(mr_sign_line1==null)mr_sign_line1="";
					 mr_sign_line2	= rset.getString("MR_SIGN_LINE2");
					 if(mr_sign_line2==null)mr_sign_line2="";
					 mr_sign_line3	= rset.getString("MR_SIGN_LINE3");
					 if(mr_sign_line3==null)mr_sign_line3="";
					 mr_sign_line4	= rset.getString("MR_SIGN_LINE4"); 
					 if(mr_sign_line4==null)mr_sign_line4="";
					 mr_sign_line5	= rset.getString("MR_SIGN_LINE5"); 
					 if(mr_sign_line5==null)mr_sign_line5="";
					 mr_sign_line6	= rset.getString("MR_SIGN_LINE6");
					 if(mr_sign_line6==null)mr_sign_line6="";
					 mr_sign_line7	= rset.getString("MR_SIGN_LINE7");
					 if(mr_sign_line7==null)mr_sign_line7="";
					 //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
					 mr_sign_line8	= rset.getString("MR_SIGN_LINE8");
					 if(mr_sign_line8==null)mr_sign_line8="";
					/*End*/
					/*Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 Start*/
					mr_sign_line9	= rset.getString("MR_SIGN_LINE9");
					if(mr_sign_line9==null)mr_sign_line9="";
					/*Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 End*/
                     /*Below Line Added for  this CRF PMG2013-CRF-0006*/					
					diag_class_mand_yn=rset.getString("DIAG_CLASS_MAND_YN");
					if(diag_class_mand_yn==null) diag_class_mand_yn="N";					
					if(diag_class_mand_yn.equals("Y"))
					   checkmand="checked";
					else
                       checkmand="";

					  //End  this CRF PMG2013-CRF-0006 
					  
					/*Below line Added for this CRF Bru-HIMS-CRF-024.2*/  
					notifi_form_mand_yn=rset.getString("notifiable_form_mand_yn");
					if(notifi_form_mand_yn==null)notifi_form_mand_yn="N";
					if(notifi_form_mand_yn.equals("Y"))
					  notificheck="checked";
					else
					  notificheck="";
					//End this Bru-HIMS-CRF-024.2
					  
					allow_recode_diag_yn=rset.getString("allow_recode_diag_yn");
					if(allow_recode_diag_yn==null) allow_recode_diag_yn="N";

					if(allow_recode_diag_yn.equals("Y")){
					checkall3="checked";
					}else{
						checkall3="";
					}
					allow_recode_proc_yn=rset.getString("allow_recode_proc_yn");
					if(allow_recode_proc_yn==null) allow_recode_proc_yn="N";
					if(allow_recode_proc_yn.equals("Y")){
						checkall4="checked";
						checkdisable="";
						enble_ot_proc_dis="";
					}else{
						checkall4="";
						checkdisable="disabled";
						enble_ot_proc_dis="disabled";
					}
					if((allow_recode_proc_yn.equals("Y"))||(allow_recode_diag_yn.equals("Y"))){
						checkdisable4="";
					}else
						checkdisable4="disabled";
					allow_ot_proc_recode_yn=rset.getString("allow_ot_proc_recode_yn");
					if(allow_ot_proc_recode_yn==null) allow_ot_proc_recode_yn="N";
					if(allow_ot_proc_recode_yn.equals("Y"))
						enble_ot_proc_chk="checked";
					else
						enble_ot_proc_chk="";
			

				/*Checking For Both OPerational and Procedure YN Added On 7/2/2009 */
					if(chk_OT_proc &&  allow_recode_proc_yn.equals("Y")){
									enble_ot_proc_dis	="";
					//				enble_ot_proc_chk	="";
					}else{
									enble_ot_proc_dis	="disabled";
									enble_ot_proc_chk	="";
					}
					/*New Coloumn added for SRR-CRF-303.1*/
						proc_type_for_recode	=checkForNull(rset.getString("DF_NEW_PROC_TYPE_FR_RECODE"));
					/*Ends*/
					allow_non_ot_proc_recode_yn=rset.getString("allow_non_ot_proc_recode_yn");
					if(allow_non_ot_proc_recode_yn==null) allow_non_ot_proc_recode_yn="N";

					if(allow_non_ot_proc_recode_yn.equals("Y"))
						checkall6="checked";
					else
						checkall6="";

			recode_for_op_yn=rset.getString("recode_for_op_yn");
					if(recode_for_op_yn==null) recode_for_op_yn="N";

					if(recode_for_op_yn.equals("Y")){
						
					checkall7="checked";
					//checkdisable6="";
					}
					else{
						checkall7="";
			//checkdisable6="disabled";
					}
					recode_for_ip_yn=rset.getString("recode_for_ip_yn");
					if(recode_for_ip_yn==null) recode_for_ip_yn="N";
					if(recode_for_ip_yn.equals("Y")){
						checkall8="checked";
					}else{
						checkall8="";
					}
					recode_for_em_yn=rset.getString("recode_for_em_yn");
					if(recode_for_em_yn==null) recode_for_em_yn="N";
					if(recode_for_em_yn.equals("Y")){
						checkall9="checked";
					}else{
						checkall9="";
					}
					recode_for_dc_yn=rset.getString("recode_for_dc_yn");
					if(recode_for_dc_yn==null) recode_for_dc_yn="N";
					if(recode_for_dc_yn.equals("Y")){
						checkall10="checked";
					}else{
						checkall10="";
					}
					recode_allow_beynd_max_lev_yn=rset.getString("recode_allow_beynd_max_lev_yn");
					if(recode_allow_beynd_max_lev_yn==null) recode_allow_beynd_max_lev_yn="N";
					if(recode_allow_beynd_max_lev_yn.equals("Y")){
						checkall11="checked";
						checkdisable1="";
					}else{
						checkall11="";
						checkdisable1="disabled";
					}
					max_level_for_op_yn=rset.getString("max_level_for_op_yn");
					if(max_level_for_op_yn==null) max_level_for_op_yn="N";
					if(max_level_for_op_yn.equals("Y"))
						checkall12="checked";
					else
						checkall12="";
					max_level_for_ip_yn=rset.getString("max_level_for_ip_yn");
					if(max_level_for_ip_yn==null) max_level_for_ip_yn="N";
					if(max_level_for_ip_yn.equals("Y"))
						checkall13="checked";
					else
						checkall13="";
					max_level_for_dc_yn=rset.getString("max_level_for_dc_yn");
					if(max_level_for_dc_yn==null) max_level_for_dc_yn="N";
					if(max_level_for_dc_yn.equals("Y"))
						checkall14="checked";
					else
						checkall14="";
					max_level_for_em_yn=rset.getString("max_level_for_em_yn");
					if(max_level_for_em_yn==null) max_level_for_em_yn="N";
					if(max_level_for_em_yn.equals("Y"))
						checkall15="checked";
					else
						checkall15="";
				 drg_calculation_yn=rset.getString("drg_calculation_yn");
					if(drg_calculation_yn==null)drg_calculation_yn="N";
					if(drg_calculation_yn.equals("Y")){
						checkall16="checked";
					checkdisable5="disabled";
					checkdisable_drg="disabled";
					imagvalue="visible";
					
					}
					else{
						checkall16="";
						checkdisable5="disabled";
						checkdisable_drg="";
						imagvalue="hidden";
						
					}
					graceperiod=rset.getString("grace_period");
					if(graceperiod==null) graceperiod="";
					max_oth_dis_comp_indi_co_death=rset.getString("max_oth_dis_comp_indi_co_death");

					if(max_oth_dis_comp_indi_co_death==null) max_oth_dis_comp_indi_co_death="";
					max_pri_diag_indicate_co_death=rset.getString("max_pri_diag_indicate_co_death");

					if(max_pri_diag_indicate_co_death==null) max_pri_diag_indicate_co_death="";
					single_stage_death_reg_appl_yn=rset.getString("single_stage_death_reg_appl_yn");
					if(single_stage_death_reg_appl_yn==null) single_stage_death_reg_appl_yn="N";
					if(single_stage_death_reg_appl_yn.equals("Y"))
						checkall17="checked";
					else
						checkall17="";
					
					/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
					auto_fin_death_reg_appl_yn = rset.getString("auto_fin_death_reg_appl_yn");
					if(auto_fin_death_reg_appl_yn==null) auto_fin_death_reg_appl_yn = "N";
					
					if(auto_fin_death_reg_appl_yn.equals("Y"))
						checkautofinalize = "checked";

					primary_diag_class = rset.getString("primary_diag_class");
					if(primary_diag_class==null) primary_diag_class = "";

					if(!primary_diag_class.equals(""))
						pri_diag_class_dis = "disabled";

					pri_mand_postmortem_ip_yn = rset.getString("pri_mand_postmortem_ip_yn");
					if(pri_mand_postmortem_ip_yn==null) pri_mand_postmortem_ip_yn = "N";
					
					if(pri_mand_postmortem_ip_yn.equals("Y"))
						checkpmpip = "checked";

					pri_mand_postmortem_dc_yn = rset.getString("pri_mand_postmortem_dc_yn");
					if(pri_mand_postmortem_dc_yn==null) pri_mand_postmortem_dc_yn = "N";
					
					if(pri_mand_postmortem_dc_yn.equals("Y"))
						checkpmpdc = "checked";

					pri_mand_postmortem_op_yn = rset.getString("pri_mand_postmortem_op_yn");
					if(pri_mand_postmortem_op_yn==null) pri_mand_postmortem_op_yn = "N";
					
					if(pri_mand_postmortem_op_yn.equals("Y"))
						checkpmpop = "checked";

					pri_mand_postmortem_ae_yn = rset.getString("pri_mand_postmortem_ae_yn");
					if(pri_mand_postmortem_ae_yn==null) pri_mand_postmortem_ae_yn = "N";
					
					if(pri_mand_postmortem_ae_yn.equals("Y"))
						checkpmpae = "checked";

					pri_mand_non_postmortem_ip_yn = rset.getString("pri_mand_non_postmortem_ip_yn");
					if(pri_mand_non_postmortem_ip_yn==null) pri_mand_non_postmortem_ip_yn = "N";
					
					if(pri_mand_non_postmortem_ip_yn.equals("Y"))
						checkpmnpip = "checked";

					pri_mand_non_postmortem_dc_yn = rset.getString("pri_mand_non_postmortem_dc_yn");
					if(pri_mand_non_postmortem_dc_yn==null) pri_mand_non_postmortem_dc_yn = "N";
					
					if(pri_mand_non_postmortem_dc_yn.equals("Y"))
						checkpmnpdc = "checked";

					pri_mand_non_postmortem_op_yn = rset.getString("pri_mand_non_postmortem_op_yn");
					if(pri_mand_non_postmortem_op_yn==null) pri_mand_non_postmortem_op_yn = "N";
					
					if(pri_mand_non_postmortem_op_yn.equals("Y"))
						checkpmnpop = "checked";

					pri_mand_non_postmortem_ae_yn = rset.getString("pri_mand_non_postmortem_ae_yn");
					if(pri_mand_non_postmortem_ae_yn==null) pri_mand_non_postmortem_ae_yn = "N";
					
					if(pri_mand_non_postmortem_ae_yn.equals("Y"))
						checkpmnpae = "checked";

					secondary_diag_class = rset.getString("secondary_diag_class");
					if(secondary_diag_class==null) secondary_diag_class = "";

					if(!secondary_diag_class.equals(""))
						sec_diag_class_dis = "disabled";

					sec_mand_postmortem_ip_yn = rset.getString("sec_mand_postmortem_ip_yn");
					if(sec_mand_postmortem_ip_yn==null) sec_mand_postmortem_ip_yn = "N";
					
					if(sec_mand_postmortem_ip_yn.equals("Y"))
						checksmpip = "checked";

					sec_mand_postmortem_dc_yn = rset.getString("sec_mand_postmortem_dc_yn");
					if(sec_mand_postmortem_dc_yn==null) sec_mand_postmortem_dc_yn = "N";
					
					if(sec_mand_postmortem_dc_yn.equals("Y"))
						checksmpdc = "checked";

					sec_mand_postmortem_op_yn = rset.getString("sec_mand_postmortem_op_yn");
					if(sec_mand_postmortem_op_yn==null) sec_mand_postmortem_op_yn = "N";
					
					if(sec_mand_postmortem_op_yn.equals("Y"))
						checksmpop = "checked";

					sec_mand_postmortem_ae_yn = rset.getString("sec_mand_postmortem_ae_yn");
					if(sec_mand_postmortem_ae_yn==null) sec_mand_postmortem_ae_yn = "N";
					
					if(sec_mand_postmortem_ae_yn.equals("Y"))
						checksmpae = "checked";

					sec_mand_non_postmortem_ip_yn = rset.getString("sec_mand_non_postmortem_ip_yn");
					if(sec_mand_non_postmortem_ip_yn==null) sec_mand_non_postmortem_ip_yn = "N";
					
					if(sec_mand_non_postmortem_ip_yn.equals("Y"))
						checksmnpip = "checked";

					sec_mand_non_postmortem_dc_yn = rset.getString("sec_mand_non_postmortem_dc_yn");
					if(sec_mand_non_postmortem_dc_yn==null) sec_mand_non_postmortem_dc_yn = "N";
					
					if(sec_mand_non_postmortem_dc_yn.equals("Y"))
						checksmnpdc = "checked";

					sec_mand_non_postmortem_op_yn = rset.getString("sec_mand_non_postmortem_op_yn");
					if(sec_mand_non_postmortem_op_yn==null) sec_mand_non_postmortem_op_yn = "N";
					
					if(sec_mand_non_postmortem_op_yn.equals("Y"))
						checksmnpop = "checked";

					sec_mand_non_postmortem_ae_yn = rset.getString("sec_mand_non_postmortem_ae_yn");
					if(sec_mand_non_postmortem_ae_yn==null) sec_mand_non_postmortem_ae_yn = "N";
					
					if(sec_mand_non_postmortem_ae_yn.equals("Y"))
						checksmnpae = "checked";
					/*End ML-MMOH-CRF-1742*/
				
					//Added by Santhosh for ML-MMOH-CRF-2156
					if(eNotifikasiDemographicsAppl) {
						rest_integration_enotifikasi=rset.getString("rest_integration_enotifikasi");
						if(rest_integration_enotifikasi==null) rest_integration_enotifikasi="N";
						if(rest_integration_enotifikasi.equals("Y"))
							checkENotifikasi="checked";
						else
							checkENotifikasi="";
						//End
					}
					
					restrict_pract_self_referral=rset.getString("restrict_pract_self_referral");
					if(restrict_pract_self_referral==null) restrict_pract_self_referral="N";
					if(restrict_pract_self_referral.equals("Y"))
						checkall25="checked";
					else
						checkall25="";
					
					restrict_pract_self_rfl_ip_op=rset.getString("restrict_pract_self_rfl_ip_op");
					if(restrict_pract_self_rfl_ip_op==null) restrict_pract_self_rfl_ip_op="N";
					if(restrict_pract_self_rfl_ip_op.equals("Y"))
						checkall26="checked";
					else
						checkall26="";
					
					restrict_pract_self_rfl_op_ip=rset.getString("restrict_pract_self_rfl_op_ip");
					if(restrict_pract_self_rfl_op_ip==null) restrict_pract_self_rfl_op_ip="N";
					if(restrict_pract_self_rfl_op_ip.equals("Y"))
						checkall27="checked";
					else
						checkall27="";
					
					restrict_bedside_self_referral=rset.getString("restrict_bedside_self_referral");
					if(restrict_bedside_self_referral==null) restrict_bedside_self_referral="N";
					if(restrict_bedside_self_referral.equals("Y"))
						checkall28="checked";
					else
						checkall28="";
					
					if((recode_for_op_yn.equals("Y")) && (recode_allow_beynd_max_lev_yn.equals("Y"))){
						checkdisable6="";
					}else{
						checkdisable6="disabled";
					}
					if((recode_for_ip_yn.equals("Y")) && (recode_allow_beynd_max_lev_yn.equals("Y"))){
						checkdisable7="";
					}else{
						checkdisable7="disabled";
					}

					if((recode_for_em_yn.equals("Y")) && (recode_allow_beynd_max_lev_yn.equals("Y"))){
						checkdisable8="";
					}else{
						checkdisable8="disabled";
					}
					if((recode_for_dc_yn.equals("Y")) && (recode_allow_beynd_max_lev_yn.equals("Y"))){
						checkdisable9="";
					}else{
						checkdisable9="disabled";
					}
					auth_at_stage=rset.getString("auth_at_stage");
					if(auth_at_stage==null)auth_at_stage="";
					addl_field1_prompt = rset.getString("addl_field1_prompt")==null?"":rset.getString("addl_field1_prompt");
					addl_field1_length = rset.getString("addl_field1_length")==null?"":rset.getString("addl_field1_length");
					addl_field1_section = rset.getString("addl_field1_section")==null?"":rset.getString("addl_field1_section");			
						 if (addl_field1_section.equals("")){
							sec11="Selected";
						  }else if (addl_field1_section.equals("H")){
							sec12="Selected";
						  }else if (addl_field1_section.equals("C")){
							sec13="Selected";
						  }else if (addl_field1_section.equals("P")){
							sec14="Selected";
						  }else if (addl_field1_section.equals("M")){
							sec15="Selected";
						  }
						addl_field2_prompt = rset.getString("addl_field2_prompt")==null?"":rset.getString("addl_field2_prompt");
						addl_field2_length = rset.getString("addl_field2_length")==null?"":rset.getString("addl_field2_length");
						addl_field2_section = rset.getString("addl_field2_section")==null?"":rset.getString("addl_field2_section");
						 if (addl_field2_section.equals("")){
							sec21="Selected";
						  }else if (addl_field2_section.equals("H")){
							sec22="Selected";
						  }else if (addl_field2_section.equals("C")){
							sec23="Selected";
						  }else if (addl_field2_section.equals("P")){
							sec24="Selected";
						  }else if (addl_field2_section.equals("M")){
							sec25="Selected";
						  }
						addl_field3_prompt = rset.getString("addl_field3_prompt")==null?"":rset.getString("addl_field3_prompt");
						addl_field3_length = rset.getString("addl_field3_length")==null?"":rset.getString("addl_field3_length");
						addl_field3_section = rset.getString("addl_field3_section")==null?"":rset.getString("addl_field3_section");
						 if (addl_field3_section.equals(""))
						  {
							sec31="Selected";
						  }
						else if (addl_field3_section.equals("H"))
						  {
							sec32="Selected";
						  }
						else if (addl_field3_section.equals("C"))
						  {
							sec33="Selected";
						  }
						else if (addl_field3_section.equals("P"))
						  {
							sec34="Selected";
						  }
						else if (addl_field3_section.equals("M"))
						  {
							sec35="Selected";
						  }
					   
						addl_field4_prompt = rset.getString("addl_field4_prompt")==null?"":rset.getString("addl_field4_prompt");
						addl_field4_length = rset.getString("addl_field4_length")==null?"":rset.getString("addl_field4_length");
						addl_field4_section = rset.getString("addl_field4_section")==null?"":rset.getString("addl_field4_section");

						 if (addl_field4_section.equals(""))
						  {
							sec41="Selected";
						  }
						else if (addl_field4_section.equals("H"))
						  {
							sec42="Selected";
						  }
						else if (addl_field4_section.equals("C"))
						  {
							sec43="Selected";
						  }
						else if (addl_field4_section.equals("P"))
						  {
							sec44="Selected";
						  }
						else if (addl_field4_section.equals("M"))
						  {
							sec45="Selected";
						  }            
					   
						addl_field5_prompt = rset.getString("addl_field5_prompt")==null?"":rset.getString("addl_field5_prompt");
						addl_field5_length = rset.getString("addl_field5_length")==null?"":rset.getString("addl_field5_length");
						addl_field5_section = rset.getString("addl_field5_section")==null?"":rset.getString("addl_field5_section");

						 if (addl_field5_section.equals(""))
						  {
							sec51="Selected";
						  }
						else if (addl_field5_section.equals("H"))
						  {
							sec52="Selected";
						  }
						else if (addl_field5_section.equals("C"))
						  {
							sec53="Selected";
						  }
						else if (addl_field5_section.equals("P"))
						  {
							sec54="Selected";
						  }
						else if (addl_field5_section.equals("M"))
						  {
							sec55="Selected";
						  }
						  
						/* Below line Added for this CRF PMG2013-CRF-0006 */  						
						 dflt_tab_in_diag_sel=rset.getString("dflt_tab_in_diag_sel")==null?"":rset.getString("dflt_tab_in_diag_sel");               
						 if(dflt_tab_in_diag_sel.equals("C")){
						 cus_diag_sel="Selected";
						 }if(dflt_tab_in_diag_sel.equals("S")){
						 search_diag_sel="Selected";
						 }						 
						  //End [PMG2013-CRF-0006]
						
					/*Saturday, January 23, 2010*/
						exclude_orig_code_recode_yn=rset.getString("exclude_orig_code");
						if(exclude_orig_code_recode_yn==null) exclude_orig_code_recode_yn="N";
						if(exclude_orig_code_recode_yn.equals("Y"))
							checkall18="checked";
						else
							checkall18="";
					/**/

					//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
					//Start 
					diag_enc_level_yn=rset.getString("diag_enc_level");
					if(diag_enc_level_yn.equals("Y"))
					diag_enc_level_chk="checked";
					else
					diag_enc_level_chk="";
					//End	

					//Added for the CRF - RUT-CRF-0064 - Start
					
					allergy_conf_reqd_yn=checkForNull(rset.getString("allergy_conf_reqd_yn"),"N");
					if(allergy_conf_reqd_yn.equals("Y"))
						checkall19="checked";
					else
						checkall19="";

					//Added for the CRF - RUT-CRF-0064 - End
					
					//Added for this CRF HSA-CRF-0222
					witness_pass_validate_yn=checkForNull(rset.getString("witness_pass_validate_yn"),"N");
					if(witness_pass_validate_yn.equals("Y"))
						checkwitness="checked";
					else
						checkwitness="";					
					//End HSA-CRF-0222
					
					//Added for this CRF-0234
					
				
					diagnosis_by_long_desc_yn=checkForNull(rset.getString("DIAGNOSIS_BY_LONG_DESC_YN"),"N");
					if(diagnosis_by_long_desc_yn.equals("Y"))
					checksearchval="checked";
					else
					checksearchval="";	
					// End CRF-0234 


					sql = "select  short_desc from am_discr_msr where result_type='L' and eff_status='E' and discr_msr_id ='"+g6pd_discr_msr_id+"'";
					if(rset != null) rset.close();
					rset = stmt.executeQuery(sql);
					if ( rset!=null && rset.next() )
					{
						g6pd_desc = rset.getString("short_desc");
					}	

					sql = "select  short_desc from am_discr_msr where result_type='L' and eff_status='E' and discr_msr_id ='"+sicc_discr_msr_id+"'";
					if(rset != null) rset.close();
					rset = stmt.executeQuery(sql);
					if ( rset!=null && rset.next() )
					{
						sicc_desc = rset.getString("short_desc");
					}
					
				}
				else{
						operation = "insert";
					 }

				sql = "select INSTALL_YN from sm_module where MODULE_ID='BL' " ;
				if(rset != null) rset.close();
				rset = stmt.executeQuery(sql);
				if ( rset != null)
				{
					while(rset.next())
					{
						if  ( (rset.getString("INSTALL_YN") != null) && (rset.getString("INSTALL_YN").equals("Y")) )
							billingIntsalled = true;
					}
				}
				
				if(rset != null) rset.close();

			}
			catch(Exception e){
					e.toString();
					e.printStackTrace();
			}
			finally
			{
				if(stmt!=null)stmt.close();
				if(rset!=null)rset.close();
			}

			if(DiagCodeScheme=="") {
				DiagCodeScheme="---Select---";
				ProcCodeScheme="---Select---";
				newDiagCode = true;
			}
			/*For New Parameter Based upon OT and Non OT procedure*/
//				StringBuffer populate_list_vals=new StringBuffer();
				String disable_type_list	 ="";
				String opt_selected		 ="";
				String ot_selected			 ="";
				String nonot_selected	 ="";
				String default_selected	 ="";
				String open_select			 ="";
//				proc_type_for_recode="OT";
				if(proc_type_for_recode.equals("NA")){
						disable_type_list="";
						opt_selected ="selected";
				}else if(proc_type_for_recode.equals("OT")){
						disable_type_list	="disabled";
						ot_selected	="selected";
				}else if(proc_type_for_recode.equals("NO")){
						disable_type_list="disabled";
						nonot_selected	 ="selected";
				}else{
						if(allow_ot_proc_recode_yn.equals("Y")&&allow_non_ot_proc_recode_yn.equals("Y")&&allow_recode_proc_yn.equals("Y")){
							open_select			="";
						}else{
							disable_type_list	="disabled";
							open_select			="Y";
							default_selected	="selected";
						}

				}
				if(allow_ot_proc_recode_yn.equals("Y")&&allow_non_ot_proc_recode_yn.equals("Y")){
					disable_type_list="";
				}
			/*Ends*/

			%>

			<form name='MRParamDiagProc_form' id='MRParamDiagProc_form' action='../../servlet/eMR.MRParameterServlet' method='post' target='messageFrame'>
			<!-- <a name = 'general_tab_vw'></a> -->
			<div id="gen_diag_div" >
					<table cellspacing='0' cellpadding='0' width='100%' border=0>
					<tr>
						<td width= "100%" class="white">
							<ul id="tablist" class="tablist">
								<li class="tablistitem" title='<fmt:message key="Common.general.label" bundle="${common_labels}"/>'>
									<a onclick="tab_click('general')"  class="tabClicked" id="general" >
										<span class="tabSpanclicked " id="generalspan">
										<fmt:message key="Common.general.label" bundle="${common_labels}"/></span>
									</a>
								</li>
								<li class="tablistitem" title='<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>'>
									<a onclick="tab_click('Diagnosis')" class="tabA" id="Diagnosis"><span class="tabAspan" id="Diagnosisspan">
										<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></span>
									</a>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
				<!--<div align='left'>-->
	<div id="general_div" style='visibility:visible;'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
			<tr>
				<td  colspan='2' class='COLUMNHEADER'><fmt:message key="eMR.DiscreteMeasureforGeneticMarkers.label" bundle="${mr_labels}"/></td>
			</tr>
			<tr>
				<td  class=label ><fmt:message key="Common.g6pd.label" bundle="${common_labels}"/></td>
				<td  class='fields'>
					<input type='text' name="g6pd_discr_msr" id="g6pd_discr_msr" size=30 align="left" value= "<%=g6pd_desc%>"  onblur="beforeG6pdVal(this)"><input class='button'type="button" name="g6pd_lookup" id="g6pd_lookup" value="?" onclick="getG6pdVal(g6pd_discr_msr,this)">
					<input type='hidden' name='g6pd_discr_msr_desc' id='g6pd_discr_msr_desc' value="<%=g6pd_desc%>">
					<input type='hidden' name='g6pd_discr_msr_id' id='g6pd_discr_msr_id' value="<%=g6pd_discr_msr_id%>">
				</td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="Common.sicc.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type='text' name="sicc_discr_msr" id="sicc_discr_msr" size=30 align="left" value= "<%=sicc_desc%>" onblur="beforeSiccVal(this)"><input class='button'type="button" name="sicc_lookup" id="sicc_lookup" value="?" onclick="getSiccVal(sicc_discr_msr,this)">
					<input type='hidden' name='sicc_discr_msr_desc' id='sicc_discr_msr_desc' value="<%=sicc_desc%>" >
					<input type='hidden' name='sicc_discr_msr_id' id='sicc_discr_msr_id' value="<%=sicc_discr_msr_id%>" >				
				</td>
			</tr>
			<!-- Added by Vinod Nov 2 2005 -->
			<tr>
				<td colspan='2' class="COLUMNHEADER"><fmt:message key="eMR.MedicalReportPaymentInterface.label" bundle="${mr_labels}"/></td>
			</tr>
			<tr>
				<td  class=label ><fmt:message key="eMR.InterfaceMode.label" bundle="${mr_labels}"/></td>
				<td  class='fields'>
					<select name="mr_pay_int_mode_type" id="mr_pay_int_mode_type">
						<% if(medrep_pay_int_mode.equals("X")) {%>
						<option value="X" selected><fmt:message key="eMR.NoInterface.label" bundle="${mr_labels}"/></option>
						<option value="B"><fmt:message key="eMR.InterfaceFromBilling.label" bundle="${mr_labels}"/></option>
						<% } else{%>
						<option value="X" ><fmt:message key="eMR.NoInterface.label" bundle="${mr_labels}"/></option>
						<option value="B" selected><fmt:message key="eMR.InterfaceFromBilling.label" bundle="${mr_labels}"/></option>
						<% }%>
					</select>
				</td>
				<%
					if ( billingIntsalled == false){
					out.println("<script>document.forms[0].mr_pay_int_mode_type.options[0].selected=true</script>");
					out.println("<script>document.forms[0].mr_pay_int_mode_type.value='X'</script>");
					out.println("<script>document.forms[0].mr_pay_int_mode_type.disabled=true</script>");
					}
					if(medrep_pay_int_mode.equals("X"))
					out.println("<script>document.forms[0].mr_pay_int_mode_type.options[0].selected=true;</script>");
					else
					if(medrep_pay_int_mode.equals("B"))
					out.println("<script>document.forms[0].mr_pay_int_mode_type.options[1].selected=true;</script>");
				%>
				<input type='hidden' name='mr_pay_int_mode' id='mr_pay_int_mode' value=''></input>						
			</tr>
			<tr><td class=label width='40%' align='right' class=label nowrap>                       <fmt:message key="eMR.MaxDaysForReportCompletion.label" bundle="${mr_labels}"/></td>
		<td width='60%' colspan='2'>
		<input type=text name="medrep_collection_days" id="medrep_collection_days" size="2" maxlength="2" value="<%=medrep_collection_days%>" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
		</tr><!-- Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459-->
		</table>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'> 
			<tr>
				<td  colspan='5' class="COLUMNHEADER"><fmt:message key="eMR.AgeGroupDetails.label" bundle="${mr_labels}"/></td>	
			</tr>
			<tr>
				<td class='labelheader' width="30%"></td>
				<td class='labelheader' width="15%"><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></td>
				<td class='labelheader' width="15%"><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
				<td class='labelheader' width="15%"><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></td>
				<td class='labelheader' width="25%"><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="Common.Adult.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text name="adult_min_age" id="adult_min_age" size="3" maxlength="3" value="<%=adult_min_age_value%>" onBlur="CheckNum(this);CheckZeroVal(this);clearUnit(this.value,adult_min_unit);" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
				<td class='fields' >
					<select name="adult_min_unit" id="adult_min_unit" onchange="chkAge(this,adult_min_age);">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
						<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
				    </select>
				</td>
				<%
					if(adult_min_age_unit.equals(""))
					out.println("<script>document.forms[0].adult_min_unit.options[0].selected=true;</script>");
					if(adult_min_age_unit.equals("D"))
					out.println("<script>document.forms[0].adult_min_unit.options[1].selected=true;</script>");
					if(adult_min_age_unit.equals("M"))
					out.println("<script>document.forms[0].adult_min_unit.options[2].selected=true;</script>");
					if(adult_min_age_unit.equals("Y"))
					out.println("<script>document.forms[0].adult_min_unit.options[3].selected=true;</script>");
			  %>
			<td class='fields'><input type=text name="adult_max_age" id="adult_max_age" size="3" maxlength="3" value="<%=adult_max_age_value%>" onBlur="CheckNum(this);CheckZeroVal(this);clearUnit(this.value,adult_max_unit);" onKeyPress='return(ChkNumberInput(this,event,0));'></td>
			<td class='fields' >
				<select name="adult_max_unit" id="adult_max_unit" onchange="chkAge(this,adult_max_age);" >
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
					<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
					<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		 </tr>
			<%
				if(adult_max_age_unit.equals(""))
				out.println("<script>document.forms[0].adult_max_unit.options[0].selected=true;</script>");
				if(adult_max_age_unit.equals("D"))
				out.println("<script>document.forms[0].adult_max_unit.options[1].selected=true;</script>");
				if(adult_max_age_unit.equals("M"))
				out.println("<script>document.forms[0].adult_max_unit.options[2].selected=true;</script>");
				if(adult_max_age_unit.equals("Y"))
				out.println("<script>document.forms[0].adult_max_unit.options[3].selected=true;</script>");
			%>
			<tr>
				<td class='label'><fmt:message key="eMR.Pediatric.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input type=text name="pead_min_age" id="pead_min_age" size="3" maxlength="3" value="<%=pead_min_age_value%>" onBlur="CheckNum(this);CheckZeroVal(this);clearUnit(this.value,pead_min_unit);" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
				<td class='fields' >
					<select name="pead_min_unit" id="pead_min_unit" onchange="chkAge(this,pead_min_age);">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
						<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<%
					if(pead_min_age_unit.equals(""))
					out.println("<script>document.forms[0].pead_min_unit.options[0].selected=true;</script>");
					if(pead_min_age_unit.equals("D"))
					out.println("<script>document.forms[0].pead_min_unit.options[1].selected=true;</script>");
					if(pead_min_age_unit.equals("M"))
					out.println("<script>document.forms[0].pead_min_unit.options[2].selected=true;</script>");
					if(pead_min_age_unit.equals("Y"))
					out.println("<script>document.forms[0].pead_min_unit.options[3].selected=true;</script>");
				%>
				<td class='fields'><input type=text name="pead_max_age" id="pead_max_age" size="3" maxlength="3" value="<%=pead_max_age_value%>" onBlur="CheckNum(this);CheckZeroVal(this);clearUnit(this.value,pead_max_unit);" onKeyPress='return(ChkNumberInput(this,event,0))' ></td>
				<td class='fields' >
					<select name="pead_max_unit" id="pead_max_unit" onchange="chkAge(this,pead_max_age);">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
						<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			<%
				if(pead_max_age_unit.equals(""))
				out.println("<script>document.forms[0].pead_max_unit.options[0].selected=true;</script>");
				if(pead_max_age_unit.equals("D"))
				out.println("<script>document.forms[0].pead_max_unit.options[1].selected=true;</script>");
				if(pead_max_age_unit.equals("M"))
				out.println("<script>document.forms[0].pead_max_unit.options[2].selected=true;</script>");
				if(pead_max_age_unit.equals("Y"))
				out.println("<script>document.forms[0].pead_max_unit.options[3].selected=true;</script>");
			%>
			</tr>
			<tr>
				<td class='label'><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></td>
				<td class='fields'><input type=text name="newborn_min_age" id="newborn_min_age" size="3" maxlength="3" value="<%=nb_min_age_value%>" onBlur="CheckNum(this);CheckZeroVal(this);clearUnit(this.value,newborn_min_unit);" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
				<td class='fields' >
					<select name="newborn_min_unit" id="newborn_min_unit" onchange="chkAge(this,newborn_min_age);">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
						<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<%
					if(nb_min_age_unit.equals(""))
					out.println("<script>document.forms[0].newborn_min_unit.options[0].selected=true;</script>");
					if(nb_min_age_unit.equals("D"))
					out.println("<script>document.forms[0].newborn_min_unit.options[1].selected=true;</script>");
					if(nb_min_age_unit.equals("M"))
					out.println("<script>document.forms[0].newborn_min_unit.options[2].selected=true;</script>");
					if(nb_min_age_unit.equals("Y"))
					out.println("<script>document.forms[0].newborn_min_unit.options[3].selected=true;</script>");
				%>
				<td class='fields'><input type=text name="newborn_max_age" id="newborn_max_age" size="3" maxlength="3" value="<%=nb_max_age_value%>"  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this);clearUnit(this.value,newborn_max_unit);"></td>
				<td class='fields' >
					<select name="newborn_max_unit" id="newborn_max_unit" onchange="chkAge(this,newborn_max_age);">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
						<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<%
					if(nb_max_age_unit.equals(""))
					out.println("<script>document.forms[0].newborn_max_unit.options[0].selected=true;</script>");
					if(nb_max_age_unit.equals("D"))
					out.println("<script>document.forms[0].newborn_max_unit.options[1].selected=true;</script>");
					if(nb_max_age_unit.equals("M"))
					out.println("<script>document.forms[0].newborn_max_unit.options[2].selected=true;</script>");
					if(nb_max_age_unit.equals("Y"))
					out.println("<script>document.forms[0].newborn_max_unit.options[3].selected=true;</script>");
				%>
				<input type='hidden' name='hdd_adult_max_age_unit' id='hdd_adult_max_age_unit' value="<%=adult_max_age_unit%>">
				<input type='hidden' name='hdd_adult_min_age_unit' id='hdd_adult_min_age_unit' value="<%=adult_min_age_unit%>">
				<input type='hidden' name='hdd_nb_max_age_unit' id='hdd_nb_max_age_unit' value="<%=nb_max_age_unit%>" >
				<input type='hidden' name='hdd_nb_min_age_unit' id='hdd_nb_min_age_unit' value="<%=nb_min_age_unit%>" >
				<input type='hidden' name='hdd_pead_max_age_unit' id='hdd_pead_max_age_unit' value="<%=pead_max_age_unit%>" >
				<input type='hidden' name='hdd_pead_min_age_unit' id='hdd_pead_min_age_unit' value="<%=pead_min_age_unit%>" >	
			</tr>
		<!--	<tr>
				<td class='label' colspan='5'>&nbsp;</td>
			</tr> -->
		</table> 
		<!--Below line added for this CRF HSA-CRF-0222 -->
		<table border='0' cellpadding='3' cellspacing='0' width='100%'> 
			<tr>
				<td  colspan='11' class="COLUMNHEADER"><fmt:message key="eIP.GeneralDetails.label" bundle="${ip_labels}"/></td>	
			</tr>		
		<tr>
			<td width='50%' class=label nowrap><fmt:message key="eMR.PasswordValidationforWitness.label" bundle="${mr_labels}"/></td>
			<td colspan='2'><input type='checkbox' name='witness_pass_validate_yn' id='witness_pass_validate_yn' onClick="checkME(this);" value='<%=witness_pass_validate_yn%>' <%=checkwitness%>  onBlur="">
			</td>

		</tr>
		
		<tr>
          <td width='50%' class=label nowrap><fmt:message key="eMR.DiagnosisSearchByLongDescription.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='diagnosis_by_long_desc_yn' id='diagnosis_by_long_desc_yn' onClick="checkME(this);"  value='<%=diagnosis_by_long_desc_yn%>' <%=checksearchval%>>
				</td>
		</tr>
		
		
		<!--Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start-->
		<%if(isMedReqAuthApplicable){%>
		<tr>
          <td width='50%' class=label nowrap><fmt:message key="eMR.MedicalReqAuth.label" bundle="${mr_labels}"/></td>
				<td class='fields' width='3%'><input type='text' name="medReqAuthorize" id="medReqAuthorize" size="2" maxlength="2" value="<%=medReqAuth%>" onBlur="CheckNum(this);zeroValChk(this);" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
				 <td  class=label ><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></td>
		</tr>
		<%}%>
		<!--End-->
		
		
		<!--Added by Himanshu saxena on 21/06/2023 for ML-MMOH-CRF-1959 Start-->
		<%if(isPatientBHT){%>
		<tr>
          <td width='50%' class=label nowrap><fmt:message key="eMR.MaxNofdaysforBHTSubmission.label" bundle="${mr_labels}"/></td>
				<td class='fields' width='3%'><input type='text' name="max_num_day_for_BHT" id="max_num_day_for_BHT" size="3" maxlength="3" value="<%=max_num_day_for_BHT%>" onBlur="CheckNum(this);" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
				<td  class=label ><fmt:message key="Common.days.label" bundle="${mr_labels}"/></td>
		</tr>
		<%}%>
		<!--End-->
		
		
		</table> 		
		<!--End HSA-CRF-0222 -->
		<table border='0' cellpadding='3' cellspacing='0' width='100%'  > 
			<tr>
				<td  colspan='11' class="COLUMNHEADER"><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Register.label" bundle="${common_labels}"/></td>	
			</tr>
			<tr>
				<td width='50%' class=label nowrap><fmt:message key="eMR.SingleStageDeathRegistrationAppl.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='single_stage_death_reg_appl_yn' id='single_stage_death_reg_appl_yn' onClick="checkME(this);" value='<%=single_stage_death_reg_appl_yn%>'  <%=checkall17%> onBlur=""></td>
			</tr> 

			<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
			<%if(isDeceasedDiagClassDeathRegAppl){%>
			<tr>
				<td width='50%' class=label nowrap><fmt:message key="Common.Auto.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></td>
				<td colspan='2'>
					<input type='checkbox' name='auto_fin_death_reg_appl_yn' id='auto_fin_death_reg_appl_yn' onClick="checkME(this);" value='<%=auto_fin_death_reg_appl_yn%>' <%=checkautofinalize%>>
				</td>
			</tr>
			<%}%>
			<!--End ML-MMOH-CRF-1742-->

			<!--Below line added by venkatesh.s  on 19/Jan/2012  aganist the  KDAH-CRF-0032 -->
			<tr>
			<td  colspan='11' class="COLUMNHEADER"><fmt:message key="eMR.MaxDateforNotifyDis.label" bundle="${mr_labels}"/></td>	
			</tr> 
			<tr>
				<td width='50%' class=label nowrap><fmt:message key="eMR.NotifyDisLabTestReportDateRange.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type=text name="rep_date_range" id="rep_date_range" size="3" maxlength="3" value="<%=lab_test_days_range%>" onBlur="CheckNum(this);CheckZeroVal(this);" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif' ></img></td>
				
			</tr> 
			<!--end   the  KDAH-CRF-0032 --->
			<!-- Added by Santhosh for ML-MMOH-CRF-2156 -->
			<%if(eNotifikasiDemographicsAppl){ %>
			<tr>
				<td width='50%' class=label nowrap><fmt:message key="eMR.RestrictIntegrationWithENotifikasi.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='rest_integration_enotifikasi' id='rest_integration_enotifikasi' onClick="checkME(this);" value='<%=rest_integration_enotifikasi%>'  <%=checkENotifikasi%> onBlur=""></td>
			</tr>
			<%} %>
			<!-- End-->
			<%/*Added for the CRF - RUT-CRF-0064 - Begin*/
			if(isSiteSpecific){ %>
			<tr>
			<td  colspan='11' class="COLUMNHEADER"><fmt:message key="eMR.AllergyConfirmation.label" bundle="${mr_labels}"/></td>	
			</tr> 
			<tr>
				<td width='50%' class=label nowrap><fmt:message key="eMR.AllergyConfirmationRequired.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name="allergy_conf_reqd_yn" id="allergy_conf_reqd_yn" onClick="checkME(this);" <%=checkall19%> value="<%=allergy_conf_reqd_yn%>"></td>
				
			</tr> 
		</table>
		<%} /*Added for the CRF - RUT-CRF-0064 - End*/%>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr>
					<td class='columnheader' colspan='4'><fmt:message key="eMR.SelfReferrals.label" bundle="${mr_labels}"/> </td></tr>
				<tr>
				<tr>
					<td width='20%' class="label"><fmt:message key="eMR.RestrictPractSelfRefferral.label" bundle="${mr_labels}"/> </td>
					<td width='25%' class='fields'><input name='restrict_pract_self_referral' id='restrict_pract_self_referral' type='checkbox' onClick="checkME(this);" value='<%=restrict_pract_self_referral%>'  <%=checkall25%>></td>
					<td width='20%' class="label"><fmt:message key="eMR.RestrictPractSelfReffIPToOP.label" bundle="${mr_labels}"/> </td>
					<td width='35%' class='fields'><input name='restrict_pract_self_rfl_ip_op' id='restrict_pract_self_rfl_ip_op' type='checkbox' onClick="checkME(this);" value='<%=restrict_pract_self_rfl_ip_op%>'  <%=checkall26%> ></td>
				</tr>
			<tr>
					<td width='20%' class="label"><fmt:message key="eMR.RestrictPractSelfReffOPToIP.label" bundle="${mr_labels}"/> </td>
					<td width='25%' class='fields'><input name='restrict_pract_self_rfl_op_ip' id='restrict_pract_self_rfl_op_ip' type='checkbox' onClick="checkME(this);" value='<%=restrict_pract_self_rfl_op_ip%>'  <%=checkall27%> ></td>
					<td width='20%' class="label"><fmt:message key="eMR.RestrictBedsideSelfRefferral.label" bundle="${mr_labels}"/> </td>
					<td width='35%' class='fields'><input name='restrict_bedside_self_referral' id='restrict_bedside_self_referral' type='checkbox' onClick="checkME(this);" value='<%=restrict_bedside_self_referral%>'  <%=checkall28%>></td>
				</tr>
		</table>
		<table  border='0' cellpadding='3' cellspacing='0' width='100%'> 
			<tr>
				<td colspan='4' class='COLUMNHEADER'><fmt:message key="eMP.AdditionalFields.label" bundle="${mp_labels}"/></td>
			</tr>
			<tr>    
				<td width='20%'>&nbsp;</td>
				<td class='querydata' width='20%'><b><fmt:message key="eMP.Legend.label" bundle="${mp_labels}"/></b></td>
				<td class='labelcenter' width='20%' ><b><fmt:message key="eMP.FieldSize.label" bundle="${mp_labels}"/></b></td>
				<td class='querydata' width='40%' ><b><fmt:message key="Common.Section.label" bundle="${common_labels}"/></b></td>
			</tr>
			<tr>    
				<td class='label' width='20%' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>1</td>
				<%		
					if ( operation.equalsIgnoreCase( "insert" ) ) {
					out.println("<td class='fields'><input type='text' name='addl_field1_prompt' id='addl_field1_prompt' maxlength='20' size='20' onBlur='enablefld(1);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field1_length' id='addl_field1_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field1_section' id='addl_field1_section' disabled> <option value=''>--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}
					else  if ( operation.equalsIgnoreCase( "modify" ) )
					{			
					if (!addl_field1_prompt.equals("")) addl_field_disable = "disabled";
					else addl_field_disable ="";					
					out.println("<td class='fields'><input type='text' name='addl_field1_prompt' id='addl_field1_prompt' maxlength='20' size='20'  value=\""+addl_field1_prompt+"\" "+addl_field_disable+" onBlur='enablefld(1);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field1_length' id='addl_field1_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' value=\""+addl_field1_length+"\" disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field1_section' id='addl_field1_section' disabled> <option value='' "+sec11+">--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' "+sec12+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C' "+sec13+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P' "+sec14+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M' "+sec15+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}
				%>
			</tr>
			<tr>    
				<td class='label' width='20%' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>2</td>
				<%				
					if ( operation.equalsIgnoreCase( "insert" ) ) {
						out.println("<td class='fields'><input type='text' name='addl_field2_prompt' id='addl_field2_prompt' maxlength='20' size='20' onBlur='enablefld(2);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field2_length' id='addl_field2_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field2_section' id='addl_field2_section' disabled> <option value=''>--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}else if ( operation.equalsIgnoreCase( "modify" ) ){		
							if (!addl_field2_prompt.equals("")){
								addl_field_disable = "disabled";
							}else{ 
								addl_field_disable ="";	
							}
						out.println("<td class='fields'><input type='text' name='addl_field2_prompt' id='addl_field2_prompt' maxlength='20' size='20'  value=\""+addl_field2_prompt+"\" "+addl_field_disable+" onBlur='enablefld(2);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field2_length' id='addl_field2_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' value=\""+addl_field2_length+"\" disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field2_section' id='addl_field2_section' disabled> <option value='' "+sec21+">--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' "+sec22+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C' "+sec23+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P' "+sec24+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M' "+sec25+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}
				%>
			</tr>
			<tr>    
				<td class='label' width='20%' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>3</td>
				<%				
					if ( operation.equalsIgnoreCase( "insert" ) ) {
					out.println("<td class='fields'><input type='text' name='addl_field3_prompt' id='addl_field3_prompt' maxlength='20' size='20' onBlur='enablefld(3);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field3_length' id='addl_field3_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field3_section' id='addl_field3_section' disabled> <option value=''>--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}else if ( operation.equalsIgnoreCase( "modify" ) ){			
						if (!addl_field3_prompt.equals("")){
								addl_field_disable = "disabled";
						}else{
								addl_field_disable ="";
						}
						out.println("<td class='fields'><input type='text' name='addl_field3_prompt' id='addl_field3_prompt' maxlength='20' size='20'  value=\""+addl_field3_prompt+"\" "+addl_field_disable+" onBlur='enablefld(3);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field3_length' id='addl_field3_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' value=\""+addl_field3_length+"\" disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field3_section' id='addl_field3_section' disabled> <option value='' "+sec31+">--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' "+sec32+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C' "+sec33+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P' "+sec34+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M' "+sec35+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}
				%>
			</tr>
			<tr>    
				<td class='label' width='20%' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>4</td>
				<%				
					if ( operation.equalsIgnoreCase( "insert" ) ) {
					out.println("<td class='fields'><input type='text' name='addl_field4_prompt' id='addl_field4_prompt' maxlength='20' size='20' onBlur='enablefld(4);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field4_length' id='addl_field4_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field4_section' id='addl_field4_section' disabled> <option value=''>--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}else if ( operation.equalsIgnoreCase( "modify" ) )	{		
						if (!addl_field4_prompt.equals("")){ 
								addl_field_disable = "disabled";
						}else{
								addl_field_disable ="";	
						}
						out.println("<td class='fields'><input type='text' name='addl_field4_prompt' id='addl_field4_prompt' maxlength='20' size='20'  value=\""+addl_field4_prompt+"\" "+addl_field_disable+" onBlur='enablefld(4);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field4_length' id='addl_field4_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' value=\""+addl_field4_length+"\" disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field4_section' id='addl_field4_section' disabled> <option value='' "+sec41+">--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' "+sec42+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C' "+sec43+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P' "+sec44+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M' "+sec45+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}
				%>
			</tr>
			<tr>    
				<td class='label' width='20%' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>5</td>
				<%				
					if ( operation.equalsIgnoreCase( "insert" ) ) {
						out.println("<td class='fields'><input type='text' name='addl_field5_prompt' id='addl_field5_prompt' maxlength='20' size='20' onBlur='enablefld(5);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field5_length' id='addl_field5_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field5_section' id='addl_field5_section' disabled> <option value=''>--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}else if ( operation.equalsIgnoreCase( "modify" ) ){		
						if (!addl_field5_prompt.equals("")){
							addl_field_disable = "disabled";
						}else{ 
							addl_field_disable ="";	
						}
						out.println("<td class='fields'><input type='text' name='addl_field5_prompt' id='addl_field5_prompt' maxlength='20' size='20'  value=\""+addl_field5_prompt+"\" "+addl_field_disable+" onBlur='enablefld(5);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field5_length' id='addl_field5_length' maxlength='2'  onKeyPress='return CheckForSpecChars1(event);' size='2' value=\""+addl_field5_length+"\" disabled onBlur='CheckNum(this); checkDecimal(this);' ></td><td class='fields' width='20%'><select name='addl_field5_section' id='addl_field5_section' disabled> <option value='' "+sec51+">--------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------</option><Option value='H' "+sec52+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Section.label","common_labels")+"</Option><Option value='C' "+sec53+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</Option><Option value='P' "+sec54+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PregnancyDetails.label","mr_labels")+"</Option><Option value='M' "+sec55+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mlcdetails.label","common_labels")+"</Option></select></td>");
					}
				%>
			</tr>
		</table>		
		<!--Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719 Start-->
		<%if(isIncompReqCancelApplicable){
			String header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.IncompleteReqCancellation.label","mr_labels");
			header = header.replace("Max No. of days for ","");
		%>
		<table  border='0' cellpadding='3' cellspacing='0' width='100%'> 
			<tr>
				<td colspan='4' class="COLUMNHEADER"><%=header%></td>
			</tr>
			<tr>
				<td width='10%' class=label nowrap>
					<fmt:message key="eMR.IncompleteReqCancellation.label" bundle="${mr_labels}"/>
				</td>
				<td class='fields' width='20%'>
					<input type='text' name="incompleteReqCancel" id="incompleteReqCancel" size="2" maxlength="2" value="<%=incompleteReqCancel%>" onBlur="CheckNum(this);" onKeyPress='return(ChkNumberInput(this,event,0))'>
					<img src="../../eCommon/images/mandatory.gif"></img>
				</td>
			</tr>
		</table>
		<% } %>
		<!--End-->

		<!--Added by Ashwini on 26-Sep-2017 for ML-MMOH-CRF-0720-->
		<%if(isSignOfMedRecApplicable){%>
		<table  border='0' cellpadding='3' cellspacing='0' width='100%'> 
			<tr><td>&nbsp</td></tr>
			<tr>
				<td>
					<a href="javascript:medReportConfig();" style="text-decoration:none;white-space: nowrap;" id="medReportConfig" name="medReportConfig"><b><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/> <fmt:message key="Common.Configuration.label" bundle="${common_labels}"/></b></a>
				</td>
			</tr>
		</table>
		<% } %>
		<!--End-->

	</div>
			<!-- <a name = 'diagnosis_tab_vw'></a>
				<ul id="tablist" class="tablist">
					<li class="tablistitem" title="general">
						<a onclick="tab_click('general_tab')"  class="tabA" id="general_tab" ><span class="tabAspan " id="outpat_act_tab_span"><fmt:message key="Common.general.label" bundle="${common_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title="diagnosis">
						<a onclick="tab_click('diagnosis_tab')" class="tabClicked" id="diagnosis_tab"><span class="tabSpanclicked" id="diagnosis_tab_span"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></span>
						</a>
					</li>
				</ul> -->
	<div id="Diagnosis_div" style="visibility:hidden;display:none" >
		<table border='0' cellpadding='3' cellspacing='0' width='100%'  >
			<tr>
				<td  colspan='11' class="COLUMNHEADER"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.setup.label" bundle="${common_labels}"/></td>	
			</tr>
			<tr>
				<td width='50%'  class=label nowrap>Supporting diagnosis mandatory for "Consequence"</td>
				<td colspan='2'><input type='checkbox' name='ext_mand_for_consq' id='ext_mand_for_consq' onClick="checkME(this);" value='<%=ext_mand_for_consq_yn%>'  <%=checkall%> ></td>
			</tr>
			<tr>
				<td width='50%'  class=label nowrap>Supporting diagnosis mandatory for "Dagger"</td>
				<td colspan='2'><input type='checkbox' name='astk_mand_for_dagg' id='astk_mand_for_dagg' onClick="checkME(this);"  value='<%=astk_mand_for_dagg_yn%>'  <%=checkall2%> ></td>
			</tr>
			<tr>
				<td width='50%'  class=label nowrap><fmt:message key="eMR.MaxPrimaryDiagnosisCauseOfDeath.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='text' onKeyPress="return CheckForSpecChars(event)" name='max_pri_diag_indicate_co_death' id='max_pri_diag_indicate_co_death' size='1' maxlength='1' onBlur="CheckNum(this); valid_dat(this);" value='<%=max_pri_diag_indicate_co_death%>'  <%=checkall%>><img src="../../eCommon/images/mandatory.gif"></img></td>
			</tr>
			<tr>
				<td width='50%'  class=label nowrap><fmt:message key="eMR.MaxOtherDiseaseCauseOfDeath.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='text' onKeyPress="return CheckForSpecChars(event)"  name='max_oth_dis_comp_indi_co_death' id='max_oth_dis_comp_indi_co_death' size='1' maxlength='1' onBlur="CheckNum(this); valid_dat(this)"  value='<%=max_oth_dis_comp_indi_co_death%>'  <%=checkall2%> ></td>
			</tr>
			<!-- Below line Added for this CRF PMG2013-CRF-0006-->
			<tr>
				<td width='50%'  class=label nowrap><fmt:message key="eMR.DiagnosisSelectionSearch.label" bundle="${mr_labels}"/></td>
				<td colspan='2'>
				   <select name="dflt_tab_in_diag_sel" id="dflt_tab_in_diag_sel">
						    <option value="C" <%=cus_diag_sel%>><fmt:message key="eMR.CustomList.label" bundle="${mr_labels}"/></option>     
							<option value="S" <%=search_diag_sel%>><fmt:message key="Common.search.label" bundle="${common_labels}" /></option>
				  </select>  
				
				</td>
			</tr>	

			<tr>
				<td width='50%'  class=label nowrap><fmt:message key="eMR.DiagnosisClassificationMandatory.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='diag_class_mand' id='diag_class_mand' onClick="checkME(this);"  value='<%=diag_class_mand_yn%>'  <%=checkmand%> ></td>
			</tr>
			<!--Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013  -->
			<!--Start  -->
			<tr>
				<td width='50%'  class=label nowrap><fmt:message key="eMR.DiagnosisEncounterLevel.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='diag_enc_level' id='diag_enc_level' onClick="checkME(this);"  value='<%=diag_enc_level_yn%>'  <%=diag_enc_level_chk%> disabled ></td>
			</tr>
			<!--End -->
			<!--End PMG2013-CRF-0006  -->
			<!--Below line added for this CRF Bru-HIMS-CRF-024.2-->
			<tr>
				<!--Added by Sangeetha on 20th Feb 2017 for ML-MMOH-CRF-0547-->
				<% if(legendChangeAsTypesOfNotiForm){ %>
				<td width='50%'  class=label nowrap><fmt:message key="eMR.TypesofNotificationFormMandatory.label" bundle="${mr_labels}"/></td>
				<% }else{ %>
				<td width='50%'  class=label nowrap><fmt:message key="eMR.WorkRelatedFormMandatory.label" bundle="${mr_labels}"/></td>
				<% } %>
				<td colspan='2'><input type='checkbox' name='notifiable_form_mand_yn' id='notifiable_form_mand_yn' onClick="checkME(this);"  value='<%=notifi_form_mand_yn%>'  <%=notificheck%> ></td>
			</tr>
			<!--Added by Ashwin K for MMS-DM-CRF-0197.1 -->
			<tr>
				<td width='50%'  class=label nowrap> <fmt:message key="eMR.PrimaryDiagMandate.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='Primary_Diag_Mandate' id='Primary_Diag_Mandate' onClick="checkME(this);"  value='<%=primary_diag_mandate%>' <%=primary_diag_mandate_check%>></td>
			</tr>

			<!--Ended by Ashwin K for MMS-DM-CRF-0197.1 -->

			<!--End Bru-HIMS-CRF-024.2-->
			
			
			<!--Added by Ajay Hatwate for ML-MMOH-CRF-1741 -->
			
			<tr>
				<td width='50%'  class=label nowrap> <fmt:message key="eMR.EnableLinkToCurrEnc.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='enableLinkToCurrEnc' id='enableLinkToCurrEnc' onClick="checkME(this);updateCrossCheckFields(this)"  value='<%=enableLinkToCurrEnc %>' <%=enableLinkToCurrEncCheck %> ></td>
			</tr>
			<tr>
				<td width='50%'  class=label nowrap> <fmt:message key="eMR.CrsChkDfltMandFldsUponLinkDiagToCurrEnc.label" bundle="${mr_labels}"/></td>
				<td colspan='2'><input type='checkbox' name='crossCheckDfltMand' id='crossCheckDfltMand' onClick="checkME(this);"  value='<%=crossChkDfltMand%>' <%=crossChkDfltMandCheck %> <%=crossChkDfltMandDis %> ></td>
			</tr>

			<!--Ended by Ajay Hatwate for ML-MMOH-CRF-1741 -->
			
			
			
			<!--Added by Ajay for TH-KW-CRF-165.1-->
			<% if(isDiagCatgMand){%>
						
				<table border='0' cellpadding='3' cellspacing='0' width='100%' >
					<tr>
							<td  class=label width="50%" >Diagnosis Category Mandatory for Primary Diagnosis Against Patient Class</td>
							 
							<td  class=label width="3%" ><fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>
							<td width="3%"><input type='checkbox' name='diag_catg_mand_for_op_yn' id='diag_catg_mand_for_op_yn'  onClick="checkME(this);" value='<%=diag_catg_mand_for_op_yn%>' <%=checkall21%> ></td>
							
							
							<td  class=label width="3%"><fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>
							<td width="3%"><input type='checkbox' name='diag_catg_mand_for_ip_yn' id='diag_catg_mand_for_ip_yn' value='<%=diag_catg_mand_for_ip_yn%>'<%=checkall22%>  onClick="checkME(this);" ></td>
														
							<td  class=label width="3%">EM</td>
							<td width="3%"><input type='checkbox' name='diag_catg_mand_for_em_yn' id='diag_catg_mand_for_em_yn' value='<%=diag_catg_mand_for_em_yn%>' <%=checkall23%>  onClick="checkME(this);"></td>
							
							<td  class=label width="3%"><fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>
							<td ><input type='checkbox' name='diag_catg_mand_for_dc_yn' id='diag_catg_mand_for_dc_yn' value='<%=diag_catg_mand_for_dc_yn%>' <%=checkall24%>  onClick="checkME(this);" ></td>
					</tr>
				</table>
			<%}%>
			
			</table>
			<table border='0' cellpadding='3' cellspacing='0' width='100%'  >
				<tr>
					<td  colspan='11' class="COLUMNHEADER"><fmt:message key="eMR.RecodeSetup.label" bundle="${mr_labels}"/></td>	
				</tr>
			</table>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'  >
			<tr>
				<td  class=label width="43%" ><fmt:message key="eMR.AllowRecoding.label" bundle="${mr_labels}"/></td>
				<td  class=label  ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
				<td width="10%"><input type='checkbox' value='<%=allow_recode_diag_yn %>' <%=checkall3 %> name='allow_recode_diag_yn' onClick="checkME(this);checkME3()" ></td>
				<td  class=label width="3%"><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
				<td  ><input type='checkbox' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value='<%=allow_recode_proc_yn %>' <%=checkall4 %> onClick='checkME(this); checkME1(this);checkME3();checkProcType(this);'></td>
			</tr>
			<tr >
				<td  class=label width="41%"><fmt:message key="eMR.AllowProcedureRecoding.label" bundle="${mr_labels}"/></td>
				<td  class=label width="3%"><fmt:message key="eMR.OT.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
				<td ><input type='checkbox' name='allow_ot_proc_recode_yn' id='allow_ot_proc_recode_yn'  value='<%= allow_ot_proc_recode_yn%>'  onClick="checkME(this);poplulateProclistvals();" <%=enble_ot_proc_dis%> <%=enble_ot_proc_chk%>></td>
				<td  class=label nowrap><fmt:message key="eMR.NonOT.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
				<td ><input type='checkbox' name='allow_non_ot_proc_recode_yn' id='allow_non_ot_proc_recode_yn'   value='<%= allow_non_ot_proc_recode_yn%>' <%=checkall6%>  <%= checkdisable%> onClick="checkME(this);poplulateProclistvals();"></td>
			</tr>
			</table>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' >
			<tr>
				<td  class=label width="38%" ><fmt:message key="eMR.ApplicablePatientClassForRecoding.label" bundle="${mr_labels}"/></td>
				<td  class=label width="3%" ><fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>
				<td width="3%"><input type='checkbox' name='recode_for_op_yn' id='recode_for_op_yn'  onClick="checkME(this);opValidate(this)" value='<%=recode_for_op_yn%>' <%=checkall7%> <%= checkdisable4%>  ></td>
				<td  class=label width="3%"><fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>
				<td width="3%"><input type='checkbox' name='recode_for_ip_yn' id='recode_for_ip_yn' value='<%=recode_for_ip_yn%>'<%=checkall8%> <%= checkdisable4%>   onClick="checkME(this);ipValidate(this)" ></td><input type='hidden' name='hdd_recode_for_op_yn' id='hdd_recode_for_op_yn' value="<%=recode_for_op_yn%>">
				<td  class=label width="3%">EM</td>
				<td width="3%"><input type='checkbox' name='recode_for_em_yn' id='recode_for_em_yn' value='<%=recode_for_em_yn%>' <%=checkall9%> <%= checkdisable4%>  onClick="checkME(this);emValidate(this)"></td>
				<td  class=label width="3%"><fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>
				<td ><input type='checkbox' name='recode_for_dc_yn' id='recode_for_dc_yn' value='<%=recode_for_dc_yn%>' <%=checkall10%> <%= checkdisable4%>   onClick="checkME(this);dcValidate(this)" ></td>
			</tr>
		</table>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
			<tr>
				<td  class=label width="38%" ><fmt:message key="eMR.RecodingAllowBeyondCutOff.label" bundle="${mr_labels}"/></td>
				<td  width="10%"><input type='checkbox' name='recode_allow_beynd_max_lev_yn' id='recode_allow_beynd_max_lev_yn' onClick="checkME(this);checkME5(this);opValidate(this);ipValidate(this);emValidate(this);dcValidate(this)" value='<%=recode_allow_beynd_max_lev_yn%>' <%=checkall11%> <%= checkdisable4%>></td>
				<td  class=label width="20%" ><fmt:message key="Common.ApplicablePatientClass.label" bundle="${common_labels}"/></td>
				<td  class=label width="2%" ><fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>
				<td  width="3%"><input type='checkbox' name='max_level_for_op_yn' id='max_level_for_op_yn'  onClick="checkME(this);"value='<%=max_level_for_op_yn%>' <%=checkall12%> <%=checkdisable6%> ></td>
				<td  class=label  width="3%"><fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>
				<td width="3%"><input type='checkbox' name='max_level_for_ip_yn' id='max_level_for_ip_yn'  onClick="checkME(this);" value='<%=max_level_for_ip_yn%>' <%=checkall13%> <%=checkdisable7%> ></td>
				<td  class=label width="4%"><fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>
				<td width="3%" ><input type='checkbox' name='max_level_for_dc_yn' id='max_level_for_dc_yn'  onClick="checkME(this);"value='<%=max_level_for_dc_yn%>' <%=checkall14%>  <%=checkdisable9%> ></td>
				<td  class=label width="3%" ><fmt:message key="eMR.EM.label" bundle="${mr_labels}"/></td>
				<td ><input type='checkbox' name='max_level_for_em_yn' id='max_level_for_em_yn'   onClick="checkME(this);" value='<%=max_level_for_em_yn%>' <%=checkall15%> <%=checkdisable8%>onblur='' ></td>
			</tr>
			<tr>
				<td  class=label width="38%"  ><fmt:message key="eMR.GracePeriod.label" bundle="${mr_labels}"/></td>
				<td colspan="10" ><input type='textbox' name='grace_period' id='grace_period' size='3' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0));'  value='<%=graceperiod%>'<%= checkdisable4%> <%=checkdisable1%> onblur='chkAllZeros(this);'></td>
			</tr>
		</table>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
			<tr>
				<td   class=label width="37%" ><fmt:message key="eMR.DRGCalculationApplicable.label" bundle="${mr_labels}"/></td>
				<td  width='80'><input type='checkbox' name='drg_calculation_yn' id='drg_calculation_yn' onClick="checkME(this);" value='<%=drg_calculation_yn%>' <%=checkall16%> <%= checkdisable_drg%>  ></td>
				<td  class=label  ><fmt:message key="eMR.StageWhichAuthorizationApplicable.label" bundle="${mr_labels}"/></td>
				<td  class='fields' width='12'>
					<select name="auth_at_stage" id="auth_at_stage" <%=checkdisable5%>  onChange='changeValue(this)' >			
						<option value="1" >1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
				<td >&nbsp;</td>
			</tr>
		<!-- 
			F.Y.I.
				1.Below field is added for the  Enhancement in Recoding(SRR-CRF-303.1) .
				2.Based upon the selection of  OT, Non OT procedure or Optional the recording a new procedure in the Recoding function will be done.
		-->
			<tr>
				<td  class=label width="38%" nowrap><fmt:message key="eMR.new_proc_for_recode.label" bundle="${mr_labels}"/></td>
				<td colspan="16" >
					<select name="proc_type_setup" id="proc_type_setup" <%=disable_type_list%>>
							<option value="NA" <%=opt_selected%>><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></option>     
							<option value="OT" <%=ot_selected%>><fmt:message key="eMR.OT.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>               
							<option value="NO" <%=nonot_selected%>><fmt:message key="eMR.NonOT.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
						<%if(open_select.equals("Y")){%>
								<option value=''<%=default_selected%>>---<fmt:message key="Common.Select.label" bundle="${mr_labels}"/>---</option>     
						<%}%>
						</select>				
					</td>
			</tr>
		<%
			if(auth_at_stage.equals("1")){
				out.println("<script>document.forms[0].auth_at_stage.options[0].selected=true;</script>");
			}
			if(auth_at_stage.equals("2")){
				out.println("<script>document.forms[0].auth_at_stage.options[1].selected=true;</script>");
			}
			if(auth_at_stage.equals("3")){
				out.println("<script>document.forms[0].auth_at_stage.options[2].selected=true;</script>");
			}
	 %>
		<!-- Saturday, January 23, 2010 
			Below field is added for the  Enhancement in Recoding(SRR-CRF-303.2) 
		-->
		<tr>
			<td  class=label width="38%" nowrap><fmt:message key="eMR.excludeorignalcodes.label" bundle="${mr_labels}"/></td>
				<td colspan="16" ><input type='checkbox' name='exclude_orig_code_recode_yn' id='exclude_orig_code_recode_yn' value='<%=exclude_orig_code_recode_yn%>' <%=checkall18%> onClick="checkME(this);">
				</td>
		</tr>
		
		</table>
		
		<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
		<%if(isDeceasedDiagClassDeathRegAppl){%>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
			<tr>
				<td  colspan='11' class='columnheader'><fmt:message key="eMR.DiagClassDeceasedPat.label" bundle="${mr_labels}"/></td>	
			</tr>
		</table>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
			<tr>
				<td class='label' width="10%" nowrap><fmt:message key="Common.primary.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/></td>
				<td class='fields' width="10%">
					<select name="primary_diag_class" id="primary_diag_class" <%=pri_diag_class_dis%> onChange='changeValuePrimary(this)'>			
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
						pstmt = conn.prepareStatement("SELECT diag_class_code, short_desc FROM mr_diag_class_lang_vw WHERE language_id = '"+locale+"' AND eff_status = 'E' ORDER BY 2");
						reset = pstmt.executeQuery();
						if( reset != null )
						{
							while( reset.next() )
							{
								pri_diag_class_code = reset.getString("diag_class_code");
								pri_diag_class_desc = reset.getString("short_desc");

								if(pri_diag_class_code.equals(primary_diag_class))
								{
									out.println("<option value ='"+primary_diag_class+"' selected>"+pri_diag_class_desc);
								}else
								{
									out.println("<option value ='"+pri_diag_class_code+"'>"+pri_diag_class_desc);
								}
							}
						}

						if(reset!=null) reset.close();
						if(pstmt!=null) pstmt.close();
						%>
					</select>
				</td>

				<td class='label' width="8%" nowrap><fmt:message key="eMR.MandForPostmortem.label" bundle="${mr_labels}"/>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_postmortem_ip_yn' id='pri_mand_postmortem_ip_yn' onClick="checkME(this);" value='<%=pri_mand_postmortem_ip_yn%>' <%=checkpmpip%> <%=dispmpip%>>&nbsp;<fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_postmortem_dc_yn' id='pri_mand_postmortem_dc_yn' onClick="checkME(this);" value='<%=pri_mand_postmortem_dc_yn%>' <%=checkpmpdc%> <%=dispmpdc%>>&nbsp;<fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_postmortem_op_yn' id='pri_mand_postmortem_op_yn' onClick="checkME(this);" value='<%=pri_mand_postmortem_op_yn%>' <%=checkpmpop%> <%=dispmpop%>>&nbsp;<fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_postmortem_ae_yn' id='pri_mand_postmortem_ae_yn' onClick="checkME(this);" value='<%=pri_mand_postmortem_ae_yn%>' <%=checkpmpae%> <%=dispmpae%>>&nbsp;<fmt:message key="Common.AE.label" bundle="${common_labels}"/></td>
				
				<td width="45%">&nbsp;</td>
			</tr>

			<tr>
				<td width="10%"></td>
				<td width="10%"></td>

				<td class='label' width="8%" nowrap><fmt:message key="eMR.MandForNonPostmortem.label" bundle="${mr_labels}"/>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_non_postmortem_ip_yn' id='pri_mand_non_postmortem_ip_yn' onClick="checkME(this);" value='<%=pri_mand_non_postmortem_ip_yn%>' <%=checkpmnpip%> <%=dispmnpip%>>&nbsp;<fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_non_postmortem_dc_yn' id='pri_mand_non_postmortem_dc_yn' onClick="checkME(this);" value='<%=pri_mand_non_postmortem_dc_yn%>' <%=checkpmnpdc%> <%=dispmnpdc%>>&nbsp;<fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_non_postmortem_op_yn' id='pri_mand_non_postmortem_op_yn' onClick="checkME(this);" value='<%=pri_mand_non_postmortem_op_yn%>' <%=checkpmnpop%> <%=dispmnpop%>>&nbsp;<fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='pri_mand_non_postmortem_ae_yn' id='pri_mand_non_postmortem_ae_yn' onClick="checkME(this);" value='<%=pri_mand_non_postmortem_ae_yn%>' <%=checkpmnpae%> <%=dispmnpae%>>&nbsp;<fmt:message key="Common.AE.label" bundle="${common_labels}"/></td>
				
				<td width="45%">&nbsp;</td>
			</tr>

			<tr><td>&nbsp;</td></tr>

			<tr>
				<td class='label' width="10%" nowrap><fmt:message key="Common.secondary.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/></td>
				<td class='fields' width="10%">
					<select name="secondary_diag_class" id="secondary_diag_class" <%=sec_diag_class_dis%> onChange='changeValueSecondary(this)'>			
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
						pstmt = conn.prepareStatement("SELECT diag_class_code, short_desc FROM mr_diag_class_lang_vw WHERE language_id = '"+locale+"' AND eff_status = 'E' ORDER BY 2");
						reset = pstmt.executeQuery();
						if( reset != null )
						{
							while( reset.next() )
							{
								sec_diag_class_code = reset.getString("diag_class_code");
								sec_diag_class_desc = reset.getString("short_desc");

								if(sec_diag_class_code.equals(secondary_diag_class))
								{
									out.println("<option value ='"+secondary_diag_class+"' selected>"+sec_diag_class_desc);
								}else
								{
									out.println("<option value ='"+sec_diag_class_code+"'>"+sec_diag_class_desc);
								}
							}
						}

						if(reset!=null) reset.close();
						if(pstmt!=null) pstmt.close();
						%>
					</select>
				</td>

				<td class='label' width="8%" nowrap><fmt:message key="eMR.MandForPostmortem.label" bundle="${mr_labels}"/>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_postmortem_ip_yn' id='sec_mand_postmortem_ip_yn' onClick="checkME(this);" value='<%=sec_mand_postmortem_ip_yn%>' <%=checksmpip%> <%=dissmpip%>>&nbsp;<fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_postmortem_dc_yn' id='sec_mand_postmortem_dc_yn' onClick="checkME(this);" value='<%=sec_mand_postmortem_dc_yn%>' <%=checksmpdc%> <%=dissmpdc%>>&nbsp;<fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_postmortem_op_yn' id='sec_mand_postmortem_op_yn' onClick="checkME(this);" value='<%=sec_mand_postmortem_op_yn%>' <%=checksmpop%> <%=dissmpop%>>&nbsp;<fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_postmortem_ae_yn' id='sec_mand_postmortem_ae_yn' onClick="checkME(this);" value='<%=sec_mand_postmortem_ae_yn%>' <%=checksmpae%> <%=dissmpae%>>&nbsp;<fmt:message key="Common.AE.label" bundle="${common_labels}"/></td>
				
				<td width="45%">&nbsp;</td>
			</tr>

			<tr>
				<td width="10%"></td>
				<td width="10%"></td>

				<td class='label' width="8%" nowrap><fmt:message key="eMR.MandForNonPostmortem.label" bundle="${mr_labels}"/>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_non_postmortem_ip_yn' id='sec_mand_non_postmortem_ip_yn' onClick="checkME(this);" value='<%=sec_mand_non_postmortem_ip_yn%>' <%=checksmnpip%> <%=dissmnpip%>>&nbsp;<fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_non_postmortem_dc_yn' id='sec_mand_non_postmortem_dc_yn' onClick="checkME(this);" value='<%=sec_mand_non_postmortem_dc_yn%>' <%=checksmnpdc%> <%=dissmnpdc%>>&nbsp;<fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_non_postmortem_op_yn' id='sec_mand_non_postmortem_op_yn' onClick="checkME(this);" value='<%=sec_mand_non_postmortem_op_yn%>' <%=checksmnpop%> <%=dissmnpop%>>&nbsp;<fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>

				<td class='fields' width="5%">
					<input type='checkbox' name='sec_mand_non_postmortem_ae_yn' id='sec_mand_non_postmortem_ae_yn' onClick="checkME(this);" value='<%=sec_mand_non_postmortem_ae_yn%>' <%=checksmnpae%> <%=dissmnpae%>>&nbsp;<fmt:message key="Common.AE.label" bundle="${common_labels}"/></td>
				
				<td width="45%">&nbsp;</td>
			</tr>

		</table>
		<%}%>
		<!--End ML-MMOH-CRF-1742-->

		<script>prevTabObj='general'</script>
	</div>
			<!-- End of Addition by Sridhar R  -->
				  <!-- 	</div> -->
			<%if ( operation.equalsIgnoreCase( "insert" ) ){%>
					<input type='hidden' name='function1' id='function1' value='insert'>
					<input type='hidden' name='function_name' id='function_name' value='insert'>
				<%}else{%>
					<input type='hidden' name='function1' id='function1' value='modify'>
					<input type='hidden' name='function_name' id='function_name' value='modify'>
			<%}%>
			<input type="hidden" name='chk_OT_proc' id='chk_OT_proc' value="<%=chk_OT_proc%>">

			<input type="hidden" name="MedReqAuthApplicable" id="MedReqAuthApplicable" value="<%=isMedReqAuthApplicable%>"> <!--Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777-->

			<input type="hidden" name="IncompReqCancelApplicable" id="IncompReqCancelApplicable" value="<%=isIncompReqCancelApplicable%>"> <!--Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719-->
			
			<!--Added by by Ashwini on 12-Oct-2017 for ML-MMOH-CRF-0720-->
			<input type="hidden" name="isSignOfMedRecApplicable" id="isSignOfMedRecApplicable" value="<%=isSignOfMedRecApplicable%>"> 
			<input type="hidden" name="mr_hdr_line1" id="mr_hdr_line1" value="<%=mr_hdr_line1%>">
			<input type="hidden" name="mr_hdr_line2" id="mr_hdr_line2" value="<%=mr_hdr_line2%>">
			<input type="hidden" name="mr_hdr_line3" id="mr_hdr_line3" value="<%=mr_hdr_line3%>">
			<input type="hidden" name="mr_hdr_line4" id="mr_hdr_line4" value="<%=mr_hdr_line4%>">
			<input type="hidden" name="mr_hdr_line5" id="mr_hdr_line5" value="<%=mr_hdr_line5%>">
			<input type="hidden" name="mr_hdr_line6" id="mr_hdr_line6" value="<%=mr_hdr_line6%>">
			<input type="hidden" name="mr_hdr_line7" id="mr_hdr_line7" value="<%=mr_hdr_line7%>">
			<input type="hidden" name="mr_sign_line1" id="mr_sign_line1" value="<%=mr_sign_line1%>">
			<input type="hidden" name="mr_sign_line2" id="mr_sign_line2" value="<%=mr_sign_line2%>">
			<input type="hidden" name="mr_sign_line3" id="mr_sign_line3" value="<%=mr_sign_line3%>">
			<input type="hidden" name="mr_sign_line4" id="mr_sign_line4" value="<%=mr_sign_line4%>">
			<input type="hidden" name="mr_sign_line5" id="mr_sign_line5" value="<%=mr_sign_line5%>">
			<input type="hidden" name="mr_sign_line6" id="mr_sign_line6" value="<%=mr_sign_line6%>">
			<input type="hidden" name="mr_sign_line7" id="mr_sign_line7" value="<%=mr_sign_line7%>">
			<!--Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282-->
			<input type="hidden" name="mr_sign_line8" id="mr_sign_line8" value="<%=mr_sign_line8%>">
			<input type="hidden" name="mr_sign_line9" id="mr_sign_line9" value="<%=mr_sign_line9%>"><!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 -->
			<input type="hidden" name="eNotifikasiDemographicsAppl" id="eNotifikasiDemographicsAppl" value="<%=eNotifikasiDemographicsAppl%>">

			<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
			<input type="hidden" name="isDeceasedDiagClassDeathRegAppl" id="isDeceasedDiagClassDeathRegAppl" value="<%=isDeceasedDiagClassDeathRegAppl%>">

		</form>
	</body>
</html>
<%
	}catch(Exception e){
		e.printStackTrace();
	}
	 finally{
			ConnectionManager.returnConnection(conn,request);
		}
%>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

