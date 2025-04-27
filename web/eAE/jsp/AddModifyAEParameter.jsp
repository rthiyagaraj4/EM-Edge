<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/AEParameter.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 
</head>  
  <%
     Connection con 					= null;
	 java.sql.Statement stmt			= null; 
	 ResultSet rset					    = null;  
	 PreparedStatement pstmt			= null;
	 String mode						= "";
	 String	facilityId 					= (String)session.getValue( "facility_id" ) ;
	 String bl_operational              = (String)session.getValue("bl_operational"); 
	 String loginUser					= (String)session.getValue("login_user");
     String locale						= (String)session.getAttribute("LOCALE");
	 
	/*Below line added for this CRF ML-MMOH-CRF-0466*/
	Properties p = (Properties) session.getValue("jdbc");
    PreparedStatement pstmt2=null;
    ResultSet rset1=null;	
	//End ML-MMOH-CRF-0466

	 if(bl_operational == null)
	 {
		   bl_operational	=	""; 
	 }
  try
  {
     con								=	ConnectionManager.getConnection(request);
	 String order_catalog_code1			=	"";
	 String order_catalog_code2			=	"";	
	 String order_catalog_code3			=	"";	
	 String order_catalog_code4			=	"";	
	 String order_catalog_code5			=	"";	
	 String order_catlog_code1			=	"";
	 String order_catlog_code2			=	"";	
	 String order_catlog_code3			=	"";	
	 String order_catlog_code4			=	"";	
	 String order_catlog_code5			=	"";	
  	 String billing_interfaced_yn		=	"";
     String allow_chkout_with_bill_stmt_yn = "";
	 String visit_backdating_allowed_yn	=	"";
 	 String max_hours_allow_insert		=	"";   
	 String max_days_allow_update		=	"";
	 String cutoff_hours_prv_day_visit	=	"";
	 String min_age_for_preg_dtl		=	"";
	 String max_age_for_paed_dtl		=	"";
	 String min_age_for_lmp             =   "";
	 String checkBoxAttribute			=	"";
	 String checkBoxAttributeBL			=	""; 
	 String checkBoxAttribute1			=	"";
	 String checkBoxAttribute2			=	"";
	 String checkBoxAttribute_BID		=	""; //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
	 String checkBoxAttribute_absconded	=	""; //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
	 String ca_install_yn				=	"";
	 String systolicBP					=	"";
     String respiratory                 =	"";
	 String systolicBPdesc				=	"";
	 String respiratorydesc				=	"";
	 String visitDis					=	"";
	 String order1Dis					=	"";
	 String order2Dis					=	"";
	 String order3Dis					=	"";
	 String order4Dis					=	"";
	 String order5Dis					=	"";
	 String hrsDis						=	"";
	 String daysDis						=	"";
	 String cutoffDis					=	"";
     String maxAgeDis					=	"";
	 String sysBPDis					=	"";
     String respirDis					=	"";
	 String billingPorp					=	"";
	 String minAgePro					=	"";
	 String queue_refresh_intervel		=	"";
	 String record_vital_signs_yn		=	"";
	 String checkBoxRecord				=	"";
	 String checkBoxRecord1				=	"";
	 String orInstall					=	"";
	 String reg_attendance_for_inpat_yn =   "N"; 
	 String Rec_diag_not_mdt_BID		=	""; //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
	 String Rec_diag_not_mdt_absconded	=	""; //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
	 String enable_accs_rights_in_queue =	"";
	 String operstn						=	"";
	 String location_prop				=	"";
	 String service_prop				=	"";
	 String visitType_prop				=	"";
	 String clinic_code					=	"";
     String service_code 				=	"";
   	 String visit_type					=	"";
     String inv_reg_new_born_yn	        =	"";//Added by Mani on 03/08/2017
	 String chk_inv_reg_new_born_yn     =   "";//Added by Mani on 03/08/2017
     String observation_ward_type_code	=	"";
     String nursing_unit_desc           =	"";
     String dis_desc                    =	"";
     String nursing_unit                =	"";
     String nursing_unitDis             =	"";
     String hide_mand                   =	"";
     String dis_lookup                  =	"";
     String nursing_clinic_code_ae      =	"";
     String pry_zone_for_dis_regn		=	"";
     String un_adult_age_for_dis_regn	=	"";

	 /*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
	 String invoke_recall_for_AE		=   "N";
	 String checkBoxAttributeRecall		=	"";
	 Boolean isRecallForAEAppl			=	CommonBean.isSiteSpecific(con, "AE", "INVOKE_RECALL_FOR_AE");
	 /*End ML-MMOH-CRF-0657*/

	 /*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
	 String reconfirm_case_of_trauma	=   "N";
	 String chkReconfCot				=	"";
	 Boolean isReconfirmCOTAppl			=	CommonBean.isSiteSpecific(con, "AE", "RECONFIRM_CASE_OF_TRAUMA");
	 /*End ML-MMOH-CRF-1409*/
	 
	  Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(con, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526

	  String dfltRegAutoUpdateTime = ""; // added by mujafar for KDAH-CRF-0526
	  String dfltEmerFollowTypeCode = "";
	  String disEmerFollowTypeCode = "";
	  String vis_mand_reg_follow_up="style=visibility:hidden";
	 
	 Boolean isPatientEncRevokeDeathAppl=	CommonBean.isSiteSpecific(con, "MP", "PATIENT_ENC_REVOKE_DEATH"); // added by mujafar for JULY-2019 for ML-MMOH-CRF-1427
	String dispTypeForRevokeDeath=""; // added by mujafar  for ML-MMOH-CRF-1427
	
	 /*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
	 String validate_natid_reg_attn		= "Y";
	 String checkBoxAttributeNatIdVal	= "";
	 Boolean isNationalIdValidationAppl	= CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION");
	 /*End MO-CRF-20148*/

	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
   	 String sql_1                       =   "";
	 /* CRF  SKR-CRF-0021 [IN028173] end  */
	 // below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
    String  max_hrs_re_attend           =   "";	
	//end CRF  Bru-HIMS-CRF-152 [IN030272]
	
	/*Below line added for this CRF ML-MMOH-CRF-0639*/
	 String re_attendace_within_hour = "";
	//End ML-MMOH-CRF-0639

	//MMS-QH-CRF-0126.2 [IN:042931] Strat		
	String selWarning 			= "";
	String selStop				= "";
	String selNoAction			= "";
	String ACTION_ON_PENDING_BILL = "";
	//MMS-QH-CRF-0126.2 [IN:042931] End
	/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
	String backDateConsAllowedYn	= "";
	String consCheckBoxAttribute	= "";
	String backDateConsAllowedHrs	= "";
	String disableBackDateHrs		= "";
	String Rec_diag_not_mdt_DID_yn       = "";  //Added by Mano aganist ML-MMOH-CRF-0783
	String checkBoxAttribute_DID_yn = "";       //Added by Mano against ML-MMOH-CRF-0783
	String Rec_diag_mdt_CALLNOTAROUND_yn ="";   //Added by Mano against ML-MMOH-CRF-0783
	String checkBoxAttribute_CALLNOTAROUND_yn ="";   //Added by Mano against ML-MMOH-CRF-0783
	Boolean isStartConsultationAppl = false;
	/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
	String CHK_FOR_PEN_ORDERS_BFR_CHKOUT	= "N";
	String CHECKOUT_ALLOW_YN = "";
	/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
	isStartConsultationAppl = CommonBean.isSiteSpecific(con, "AE", "AE_START_CONSULTATION");
	/*End*/
	/*Added by Mano aganist ML-MMOH-CRF-0783*/
    Boolean isDidCallNotAroundDgnNotAppl = CommonBean.isSiteSpecific(con, "AE", "DID_CALLNOTAROUND_NOT_REQ_DGN");
    /*End*/
    
    //<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
    String enable_admission_tab="N";
    boolean isPendingForAdmissionAppl=false;
    isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");
    //String CHK_enable_admission_tab="Checked"
    //<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Starts-->		
    
/*Below line Added For MMS-QH-CRF-0146 [IN:043836] */	
String leveloftriage_visibility = "visibility:hidden";
String five_level_triage_appl_yn="";
String leveltriage_checkbox="";
String leveltriage_checkbox_disable="";
Boolean isFiveLevelTriageApplicable = CommonBean.isSiteSpecific(con, "AE","FIVE_LEVEL_TRIAGE");
if(isFiveLevelTriageApplicable)  leveloftriage_visibility="visibility:visible";
//End MMS-QH-CRF-0146 [IN:043836]

/*Below line added for this CRF ML-MMOH-CRF-0466*/   
    String Site="", dist_pat_series_code="";  
    StringBuffer sqlbuf = new StringBuffer();
    HashMap hashMap		= new HashMap();
	hashMap = eMP.ChangePatientDetails.getSetupData(facilityId,"",con,p);
	String pat_ser_access_by_user_yn = checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));	
	String userAccessSql	= "";
	if(pat_ser_access_by_user_yn.equals("Y")){
		userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+loginUser+"') ";
	}
//End ML-MMOH-CRF-0466	

	/*Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0651 Start*/
	String orderCatalogCode6	= "";
	String orderCatalogDesc6	= "";
	String order6Dis			=	"";
	String initialMgmtLblConfig	= "";
	String dressingLblConfig	= "";
	Boolean isOrderCatalogChngsAppl = false;
	isOrderCatalogChngsAppl			= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SEC_TRIAGE_ORDER_CATALOG");
	/*End*/

	 StringBuffer sqlLocation			= new StringBuffer();
	 
	 //sqlLocation.append("select a.CLINIC_CODE, a.long_desc SHORT_DESC, c.gender from OP_CLINIC a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b, am_age_group c  where decode(b.day_no,'1',working_day_1,'2', working_day_2,'3',working_day_3,'4',  working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' and a.facility_id = ? and a.clinic_type ='C' and a.level_of_care_ind = 'E'   and a.eff_status = 'E'   and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = a.facility_id and  register_visit_yn = 'Y')  and  a.age_group_code = c.age_group_code(+)  and c.gender is null and (facility_id,clinic_code) in (select facility_id,locn_code from am_locn_for_oper_stn_vw where facility_id =a.facility_id and oper_stn_id =? )order by 2  ");  

	sqlLocation.append("SELECT clinic_code, long_desc short_desc FROM op_clinic where facility_id = ? AND clinic_type = 'C' AND level_of_care_ind = 'E' AND eff_status = 'E' ORDER BY 2  ");

	 StringBuffer sqlService	  = new StringBuffer();

     sqlService.append("SELECT A.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A, AM_FACILITY_SERVICE B,OP_CLINIC_FOR_SERVICE C WHERE C.FACILITY_ID=? AND C.CLINIC_CODE = ? AND B.OPERATING_FACILITY_ID = C.FACILITY_ID AND C.SERVICE_CODE = B.SERVICE_CODE AND A.SERVICE_CODE = B.SERVICE_CODE UNION SELECT b.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A,OP_CLINIC B WHERE B.FACILITY_ID=?  AND b.CLINIC_CODE=? AND A.SERVICE_CODE = B.SERVICE_CODE ORDER BY 2");
	 


     StringBuffer sqlVisitType	  = new StringBuffer();

	 sqlVisitType.append("select distinct visit_type_code, visit_type_short_desc from OP_VISIT_TYPE_FOR_CLINIC_VW where visit_type_ind='E'  and eff_status='E'   and clinic_code= ? and FACILITY_ID= ?");

	 mode							=	"INSERT";

	 pstmt	 = con.prepareStatement("select VISIT_REV_CANCEL_DAYS,visit_compl_days from OP_PARAM where operating_facility_id=?");
	 pstmt.setString(1,facilityId);

	 rset	 = pstmt.executeQuery();
	 while(rset!=null && rset.next())
	  {
		 	max_days_allow_update		= rset.getString("VISIT_REV_CANCEL_DAYS");
	  }
	 if(rset!=null)  rset.close();
	 if(pstmt!=null)  pstmt.close(); 

	/*Below line added for this CRF ML-MMOH-CRF-0466*/
	    try {                
            	pstmt2 = con.prepareStatement("select site_id from sm_site_param");
				rset1 = pstmt2.executeQuery() ;
				if(rset1 !=null && rset1.next()){
				Site = rset1.getString(1) ;
				}
				if(rset1!=null) rset1.close();
				if(pstmt2!=null) pstmt2.close();
	    }catch(Exception ee){ee.printStackTrace();}
    
	//End ML-MMOH-CRF-0466	 

	 try{
					String sqlOper="select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id=? and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id =? and trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate))";
					pstmt=con.prepareStatement(sqlOper);
					pstmt.setString(1,facilityId);
					pstmt.setString(2,loginUser);
					rset=pstmt.executeQuery();
					if(rset != null && rset.next()) {
						operstn	 = (rset.getString("oper_stn_id") == null)?"":rset.getString("oper_stn_id");
					}
					if(pstmt != null) pstmt.close();
					if(rset != null) rset.close();

				}catch(Exception e) {
					e.printStackTrace();
				}
				
	 
	 try
	 {
		 pstmt								= con.prepareStatement("select install_yn from sm_module where module_id='CA' ");
		 rset								= pstmt.executeQuery();
		 while(rset!=null  && rset.next())
		  {
						ca_install_yn		= rset.getString(1);
		  }
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
	 }catch(Exception e)
     {
       e.printStackTrace();
     }


     if (ca_install_yn.equals("Y"))
	  {  
		 StringBuffer sqlCABuf = new StringBuffer();
		 sqlCABuf.append("SELECT DISCR_MSR_ID1 ,(SELECT short_desc FROM am_discr_msr WHERE DISCR_MSR_ID = a.DISCR_MSR_ID1) Desc1, DISCR_MSR_ID2,(SELECT short_desc FROM am_discr_msr WHERE DISCR_MSR_ID = a.DISCR_MSR_ID2) Desc2 FROM AE_PARAM a WHERE OPERATING_FACILITY_ID=?");
		 pstmt		= con.prepareStatement(sqlCABuf.toString());
	     pstmt.setString(1,facilityId);
         rset	 = pstmt.executeQuery();
		 if(rset!=null && rset.next())
		  {
			  systolicBP		 = rset.getString("DISCR_MSR_ID1");
			  systolicBP 		 = (systolicBP == null)?"":systolicBP;
              respiratory        = rset.getString("DISCR_MSR_ID2");
			  respiratory 		 = (respiratory == null)?"":respiratory;
              systolicBPdesc     = rset.getString("Desc1");
			  systolicBPdesc 	 = (systolicBPdesc == null)?"":systolicBPdesc;
			  respiratorydesc    = rset.getString("Desc2");
			  respiratorydesc 	 = (respiratorydesc == null)?"":respiratorydesc;
		  }
	 }
     //default  for min_age_for_preg_dtl of ae_param
	 String NB_MOTHER_CUTOFF_AGE = "";
	 String NB_MOTHER_MIN_AGE = "";

	 String sql_query				="SELECT NB_MOTHER_CUTOFF_AGE, NB_MOTHER_MIN_AGE FROM MP_PARAM  WHERE MODULE_ID='MP'";  
     stmt								=	con.createStatement();
	 rset								=	stmt.executeQuery(sql_query);
	 while(rset!=null && rset.next())
	  {
			NB_MOTHER_CUTOFF_AGE = rset.getString(1);
			NB_MOTHER_MIN_AGE = rset.getString(2);
	  }
	 if(rset!=null)  rset.close();
	 if(stmt!=null)  stmt.close(); 
	 // Min. Age of the patient for capturing pregnancy details validation based on MP Parameter values.
	 if(NB_MOTHER_CUTOFF_AGE != null)
		 {
				min_age_for_preg_dtl=NB_MOTHER_CUTOFF_AGE;
		 }
		 else if(NB_MOTHER_MIN_AGE != null)
		 {
				min_age_for_preg_dtl=NB_MOTHER_MIN_AGE;	
		 }

		if(!min_age_for_preg_dtl.equals(""))
		{
			minAgePro="readonly";
		}

	  pstmt	 = con.prepareStatement("select count(*) from sm_modules_facility where facility_id = '"+facilityId+"' and module_id='OR' and operational_yn='Y'");

	 rset	 = pstmt.executeQuery();
	 int cnt=0;
	 while(rset!=null && rset.next())
	  {
			cnt=rset.getInt(1); 	 	
	  }
	 if(rset!=null)  rset.close();
	 if(pstmt!=null)  pstmt.close();
	 

	 if(cnt>0)
	  {  
		 
		 orInstall  = "Y";
		 
		 /*Below line modified for ML-MMOH-CRF-0466*/

		 String sql = "SELECT DFLT_TIME_REG_AUTO_UPDATE,DFLT_EMER_FOLLOW_TYPE_CODE,ACTION_ON_PENDING_BILL,BILLING_INTERFACED_YN,ALLOW_CHKOUT_WITH_BILL_STMT_YN,INV_REG_NEW_BORN_YN, VISIT_BACKDATING_ALLOWED_YN,MAX_HRS_FOR_RE_ATTEND,reg_attendace_within_hour, MAX_HOURS_ALLOW_INSERT,MAX_DAYS_ALLOW_UPDATE, CUTOFF_HOURS_PRV_DAY_VISIT, MIN_AGE_FOR_PREG_DTL, MAX_AGE_FOR_PAED_DTL, MIN_AGE_FOR_LMP, DFLT_LOCN_CODE_FOR_DIS_REGN, DFLT_SRVC_CODE_FOR_DIS_REGN, DFLT_VIS_TYP_CDE_FOR_DIS_REGN, ORDER_CATALOG_CODE1, B.LONG_DESC DESC1, ORDER_CATALOG_CODE2,C.LONG_DESC DESC2, ORDER_CATALOG_CODE3, D.LONG_DESC DESC3,ORDER_CATALOG_CODE4, E.LONG_DESC DESC4, ORDER_CATALOG_CODE5, F.LONG_DESC DESC5,NVL(QUEUE_REFRESH_INTERVAL, 0) QUEUE_REFRESH_INTERVAL, A.RECORD_VITAL_SIGNS_YN, REG_ATTENDANCE_FOR_INPAT_YN, INVOKE_RECALL_FOR_AE, RECONFIRM_CASE_OF_TRAUMA, REVOKE_DEATH_DISP_TYPE,REC_DIAG_NOT_MDT_BID, REC_DIAG_NOT_MDT_ABSCONDED,REC_DIAG_NOT_MDT_DID_YN,REC_DIAG_MDT_CALLNOTAROUND_YN, ENABLE_ACCS_RIGHTS_IN_QUEUE,five_level_triage_appl_yn, A.NURSING_UNIT_CODE,  (CASE  WHEN A.AE_OBSERVE_BATTERY_ID = 'N'   THEN G.SHORT_DESC    WHEN A.AE_OBSERVE_BATTERY_ID = 'C'  THEN H.SHORT_DESC   WHEN A.AE_OBSERVE_BATTERY_ID = 'T'  THEN I.SHORT_DESC  END) SHORT_DESC, A.AE_OBSERVE_BATTERY_ID, A.DFLT_PRY_ZONE_FOR_DIS_REGN,A.DFLT_UN_ADULT_AGE_FOR_DIS_REGN, A.CLINIC_CODE, DIST_PAT_SER_GRP, BACKDATE_CONS_ALLOWED_YN, BACKDATE_CONS_ALLOWED_HRS, ORDER_CATALOG_CODE6, J.LONG_DESC DESC6, DRESSING_LABEL_CONFIG, INITIAL_MGMT_LABEL_CONFIG,A.CHK_FOR_PEN_ORDERS_BFR_CHKOUT,A.CHECKOUT_ALLOW_YN, A.VALIDATE_NATID_REG_ATTN,A.ENABLE_ADMISSION_TAB FROM AE_PARAM A, OR_ORDER_CATALOG B,   OR_ORDER_CATALOG C, OR_ORDER_CATALOG D, OR_ORDER_CATALOG E, OR_ORDER_CATALOG F,  IP_NURSING_UNIT G, OP_CLINIC H, AE_TMT_AREA_FOR_CLINIC I, OR_ORDER_CATALOG J  WHERE OPERATING_FACILITY_ID =? AND ORDER_CATALOG_CODE1 = B.ORDER_CATALOG_CODE(+)  AND ORDER_CATALOG_CODE2 = C.ORDER_CATALOG_CODE(+) AND ORDER_CATALOG_CODE3 = D.ORDER_CATALOG_CODE(+) AND ORDER_CATALOG_CODE4 = E.ORDER_CATALOG_CODE(+)  AND ORDER_CATALOG_CODE5 = F.ORDER_CATALOG_CODE(+)  AND ORDER_CATALOG_CODE6 = J.ORDER_CATALOG_CODE(+) AND A.OPERATING_FACILITY_ID = G.FACILITY_ID(+)  AND A.NURSING_UNIT_CODE = G.NURSING_UNIT_CODE(+)  AND A.OPERATING_FACILITY_ID = H.FACILITY_ID(+) AND A.NURSING_UNIT_CODE = H.CLINIC_CODE(+)  AND A.OPERATING_FACILITY_ID=I.FACILITY_ID(+)    AND A.NURSING_UNIT_CODE = I.TREATMENT_AREA_CODE(+)"; //Modified by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623
		 //Modified by Thamizh selvi on 10th Apr 2018 for ML-MMOH-CRF-0651
		 //Modified by Mujafar for ML-MMOH-CRF-1427
		 // added by mujafar for KDAH-CRF-0526

	
		  pstmt		= con.prepareStatement(sql);
		 pstmt.setString(1,facilityId);
		 rset	 = pstmt.executeQuery();
		 while(rset!=null && rset.next())
		  {
				ACTION_ON_PENDING_BILL = rset.getString("ACTION_ON_PENDING_BILL") == null ? "N" :rset.getString("ACTION_ON_PENDING_BILL"); // Added for MMS-QH-CRF-0126.2 [IN:042931]
				 billing_interfaced_yn		= rset.getString("BILLING_INTERFACED_YN");
				if(billing_interfaced_yn!=null && billing_interfaced_yn.equalsIgnoreCase("Y"))
				 {	checkBoxAttribute       = "CHECKED";
					billingPorp             = "DISABLED";
				 }else{ billingPorp = "";  }
				 allow_chkout_with_bill_stmt_yn = rset.getString("ALLOW_CHKOUT_WITH_BILL_STMT_YN");
				if(allow_chkout_with_bill_stmt_yn!=null && allow_chkout_with_bill_stmt_yn.equalsIgnoreCase("Y"))
				 {	checkBoxAttributeBL       = "CHECKED";
					
				 }else{ checkBoxAttributeBL = "";  }
				visit_backdating_allowed_yn	= rset.getString("VISIT_BACKDATING_ALLOWED_YN");
				if(visit_backdating_allowed_yn!=null && visit_backdating_allowed_yn.equalsIgnoreCase("Y"))
					checkBoxAttribute1       = "CHECKED";
				
				/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
				backDateConsAllowedYn			= rset.getString("BACKDATE_CONS_ALLOWED_YN");
				if(backDateConsAllowedYn != null && backDateConsAllowedYn.equalsIgnoreCase("Y")){
					consCheckBoxAttribute       = "CHECKED";
					disableBackDateHrs			= "";
				}else{
					consCheckBoxAttribute       = "";
					disableBackDateHrs			= "disabled";
				}
				backDateConsAllowedHrs			= rset.getString("BACKDATE_CONS_ALLOWED_HRS");
				backDateConsAllowedHrs 			= (backDateConsAllowedHrs == null)?"":backDateConsAllowedHrs;
				/*End*/
				/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
				CHK_FOR_PEN_ORDERS_BFR_CHKOUT	 = rset.getString("CHK_FOR_PEN_ORDERS_BFR_CHKOUT") == null ? "N" :rset.getString("CHK_FOR_PEN_ORDERS_BFR_CHKOUT");
				CHECKOUT_ALLOW_YN				 = rset.getString("CHECKOUT_ALLOW_YN") == null ? "N" :rset.getString("CHECKOUT_ALLOW_YN");
				/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

         reg_attendance_for_inpat_yn  = rset.getString("REG_ATTENDANCE_FOR_INPAT_YN");
				if(reg_attendance_for_inpat_yn!=null && reg_attendance_for_inpat_yn.equalsIgnoreCase("Y"))
					checkBoxAttribute2       = "CHECKED";
				
				/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
				invoke_recall_for_AE  = rset.getString("INVOKE_RECALL_FOR_AE");
				if(invoke_recall_for_AE!=null && invoke_recall_for_AE.equalsIgnoreCase("Y"))
				checkBoxAttributeRecall = "CHECKED";
				/*End ML-MMOH-CRF-0657*/

				//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
					enable_admission_tab	 = rset.getString("ENABLE_ADMISSION_TAB") == null ? "N" :rset.getString("ENABLE_ADMISSION_TAB");
				//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
					
				/*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
				reconfirm_case_of_trauma = checkForNull(rset.getString("RECONFIRM_CASE_OF_TRAUMA"),"N");
				if(reconfirm_case_of_trauma!=null && reconfirm_case_of_trauma.equalsIgnoreCase("Y"))
				chkReconfCot = "CHECKED";
				/*End ML-MMOH-CRF-1409*/
				
				dispTypeForRevokeDeath =rset.getString("REVOKE_DEATH_DISP_TYPE")==null?"":rset.getString("REVOKE_DEATH_DISP_TYPE"); 	// added by mujafar  for ML-MMOH-CRF-1427
				

				/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
				validate_natid_reg_attn = rset.getString("VALIDATE_NATID_REG_ATTN");
				if(validate_natid_reg_attn!=null && validate_natid_reg_attn.equalsIgnoreCase("Y"))
				checkBoxAttributeNatIdVal = "CHECKED";
				/*End MO-CRF-20148*/

				 //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
				 Rec_diag_not_mdt_BID  = rset.getString("REC_DIAG_NOT_MDT_BID");
				if(Rec_diag_not_mdt_BID!=null && Rec_diag_not_mdt_BID.equalsIgnoreCase("Y"))
					checkBoxAttribute_BID       = "CHECKED";

				//Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
				Rec_diag_not_mdt_absconded  = rset.getString("REC_DIAG_NOT_MDT_ABSCONDED");
				if(Rec_diag_not_mdt_absconded!=null && Rec_diag_not_mdt_absconded.equalsIgnoreCase("Y"))
					checkBoxAttribute_absconded     = "CHECKED";
				
				//Added by Mano against ML-MMOH-CRF-0783
				Rec_diag_not_mdt_DID_yn  = rset.getString("REC_DIAG_NOT_MDT_DID_YN");
				if(Rec_diag_not_mdt_DID_yn!=null && Rec_diag_not_mdt_DID_yn.equalsIgnoreCase("Y"))
					checkBoxAttribute_DID_yn      = "CHECKED";
				
				//Added by Mano Aganist ML-MMOH-CRF-0783
				Rec_diag_mdt_CALLNOTAROUND_yn  = rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN");
				if(Rec_diag_mdt_CALLNOTAROUND_yn!=null && Rec_diag_mdt_CALLNOTAROUND_yn.equalsIgnoreCase("Y"))
					checkBoxAttribute_CALLNOTAROUND_yn   = "CHECKED";

				max_hours_allow_insert		= rset.getString("MAX_HOURS_ALLOW_INSERT");    
				max_hours_allow_insert 		= (max_hours_allow_insert == null)?"":max_hours_allow_insert;
				// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
				max_hrs_re_attend           = rset.getString("MAX_HRS_FOR_RE_ATTEND");  
				max_hrs_re_attend 		= (max_hrs_re_attend == null)?"":max_hrs_re_attend;
				//end CRF  Bru-HIMS-CRF-152 [IN030272]
				
				/*Below line added fro this CRF ML-MMOH-CRF-0639*/				
				re_attendace_within_hour = rset.getString("reg_attendace_within_hour");  
				re_attendace_within_hour = (re_attendace_within_hour == null)?"":re_attendace_within_hour;				
				//End ML-MMOH-CRF-0639
				
				
				/*Below line added fro this CRF ML-MMOH-CRF-0631*/	
				inv_reg_new_born_yn  = rset.getString("INV_REG_NEW_BORN_YN");
					if(inv_reg_new_born_yn!=null && inv_reg_new_born_yn.equalsIgnoreCase("Y"))
						chk_inv_reg_new_born_yn       = "CHECKED";
				
				/*Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				orderCatalogCode6		= checkForNull(rset.getString("ORDER_CATALOG_CODE6")); 
				orderCatalogDesc6		= checkForNull(rset.getString("DESC6")); 
				initialMgmtLblConfig	= checkForNull(rset.getString("INITIAL_MGMT_LABEL_CONFIG")); 
				dressingLblConfig		= checkForNull(rset.getString("DRESSING_LABEL_CONFIG")); 
				/*End*/
					
				dfltRegAutoUpdateTime = checkForNull(rset.getString("DFLT_TIME_REG_AUTO_UPDATE"));
				dfltEmerFollowTypeCode = checkForNull(rset.getString("DFLT_EMER_FOLLOW_TYPE_CODE"));

				if(dfltRegAutoUpdateTime.equals(""))
				{
					disEmerFollowTypeCode="disabled";
					vis_mand_reg_follow_up="style=visibility:hidden";
			
				}
				else
				{
					disEmerFollowTypeCode="";
					vis_mand_reg_follow_up="style=visibility:visible";
					
				}
				
				max_days_allow_update		= rset.getString("MAX_DAYS_ALLOW_UPDATE");
				max_days_allow_update 		= (max_days_allow_update == null)?"":max_days_allow_update;
				cutoff_hours_prv_day_visit	= rset.getString("CUTOFF_HOURS_PRV_DAY_VISIT");
				cutoff_hours_prv_day_visit	= (cutoff_hours_prv_day_visit == null)?"":cutoff_hours_prv_day_visit;
				order_catlog_code1		= rset.getString("ORDER_CATALOG_CODE1");    
				order_catlog_code1 		= (order_catlog_code1 == null)?"":order_catlog_code1;
				order_catlog_code2		= rset.getString("ORDER_CATALOG_CODE2");    
				order_catlog_code2 		= (order_catlog_code2 == null)?"":order_catlog_code2;
				order_catlog_code3	= rset.getString("ORDER_CATALOG_CODE3");    
				order_catlog_code3		= (order_catlog_code3 == null)?"":order_catlog_code3;
				order_catlog_code4	= rset.getString("ORDER_CATALOG_CODE4");    
				order_catlog_code4		= (order_catlog_code4 == null)?"":order_catlog_code4;
				order_catlog_code5	= rset.getString("ORDER_CATALOG_CODE5");    
				order_catlog_code5		= (order_catlog_code5 == null)?"":order_catlog_code5;

				 order_catalog_code1		= rset.getString("DESC1");    
				order_catalog_code1 		= (order_catalog_code1 == null)?"":order_catalog_code1;
				order_catalog_code2		= rset.getString("DESC2");    
				order_catalog_code2 		= (order_catalog_code2 == null)?"":order_catalog_code2;
				order_catalog_code3	= rset.getString("DESC3");    
				order_catalog_code3		= (order_catalog_code3 == null)?"":order_catalog_code3;
				order_catalog_code4	= rset.getString("DESC4");    
				order_catalog_code4		= (order_catalog_code4 == null)?"":order_catalog_code4;
				order_catalog_code5	= rset.getString("DESC5");    
			   order_catalog_code5	= (order_catalog_code5 == null)?"":order_catalog_code5;
				if (min_age_for_preg_dtl.equals(""))
				{
					min_age_for_preg_dtl		= rset.getString("MIN_AGE_FOR_PREG_DTL");
					min_age_for_preg_dtl 		= (min_age_for_preg_dtl == null)?"":min_age_for_preg_dtl;
					//readonly="";
					//minAgeDis=""; 
				}
				else{
				//minAgeDis = "";
				minAgePro="readonly";}
				max_age_for_paed_dtl		= rset.getString("MAX_AGE_FOR_PAED_DTL");
				max_age_for_paed_dtl 		= (max_age_for_paed_dtl == null)?"":max_age_for_paed_dtl;
				min_age_for_lmp		= rset.getString("MIN_AGE_FOR_LMP");
				min_age_for_lmp		= (min_age_for_lmp == null)?"":min_age_for_lmp;
				
	            clinic_code		= rset.getString("DFLT_LOCN_CODE_FOR_DIS_REGN");
				clinic_code		= (clinic_code == null)?"":clinic_code;

				service_code		= rset.getString("DFLT_SRVC_CODE_FOR_DIS_REGN");
				service_code		= (service_code == null)?"":service_code;

				visit_type		= rset.getString("DFLT_VIS_TYP_CDE_FOR_DIS_REGN");
				visit_type		= (visit_type == null)?"":visit_type;

				observation_ward_type_code		= rset.getString("AE_OBSERVE_BATTERY_ID");
				observation_ward_type_code		= (observation_ward_type_code == null)?"":observation_ward_type_code;

				nursing_unit		= rset.getString("NURSING_UNIT_CODE");
				nursing_unit		= (nursing_unit == null)?"":nursing_unit;
      
	        	nursing_unit_desc		= rset.getString("short_desc");
				nursing_unit_desc		= (nursing_unit_desc == null)?"":nursing_unit_desc;

				nursing_clinic_code_ae		= rset.getString("clinic_code");
				nursing_clinic_code_ae		= (nursing_clinic_code_ae == null)?"":nursing_clinic_code_ae;


				un_adult_age_for_dis_regn		= rset.getString("DFLT_UN_ADULT_AGE_FOR_DIS_REGN");
				un_adult_age_for_dis_regn		= (un_adult_age_for_dis_regn == null)?"":un_adult_age_for_dis_regn;

				pry_zone_for_dis_regn		= rset.getString("DFLT_PRY_ZONE_FOR_DIS_REGN");
				pry_zone_for_dis_regn		= (pry_zone_for_dis_regn == null)?"":pry_zone_for_dis_regn;





		  if (observation_ward_type_code.equals(""))
				{
					hide_mand="style=visibility:hidden";
					dis_lookup="disabled";
					dis_desc="disabled";
				}
			else
				{
					hide_mand="style=visibility:visible";
					dis_lookup="";
					dis_desc="";
				}
				queue_refresh_intervel = rset.getString("QUEUE_REFRESH_INTERVAL");
				queue_refresh_intervel = (queue_refresh_intervel == null)?"":queue_refresh_intervel;
				record_vital_signs_yn  = rset.getString("RECORD_VITAL_SIGNS_YN");
				record_vital_signs_yn = (record_vital_signs_yn == null)?"N":record_vital_signs_yn;
				if(record_vital_signs_yn!=null && record_vital_signs_yn.equalsIgnoreCase("Y"))
				 {	
					checkBoxRecord       = "CHECKED";

				 }
				 else
					 { 
					 checkBoxRecord = "";  
					 }
					 
					 
                enable_accs_rights_in_queue = rset.getString("ENABLE_ACCS_RIGHTS_IN_QUEUE");
				enable_accs_rights_in_queue = (enable_accs_rights_in_queue == null)?"N":enable_accs_rights_in_queue;
				if(enable_accs_rights_in_queue!=null && enable_accs_rights_in_queue.equalsIgnoreCase("Y"))
				 	checkBoxRecord1       = "CHECKED";
					mode				  = "MODIFY";
            
			     /*Below line added for this CRF MMS-QH-CRF-0146 [IN:043836]*/
				five_level_triage_appl_yn = rset.getString("five_level_triage_appl_yn");
				five_level_triage_appl_yn = (five_level_triage_appl_yn == null)?"N":five_level_triage_appl_yn;
				if(five_level_triage_appl_yn!=null && five_level_triage_appl_yn.equalsIgnoreCase("Y")) {
				leveltriage_checkbox = "CHECKED";
				leveltriage_checkbox_disable= "DISABLED";
				}
				//End this CRF MMS-QH-CRF-0146 [IN:043836]
				
				 //Below line added for this CRF ML-MMOH-CRF-0466
                  dist_pat_series_code = rset.getString("DIST_PAT_SER_GRP");
				  dist_pat_series_code = (dist_pat_series_code == null)?"":dist_pat_series_code;
					 //End ML-MMOH-CRF-0466  
                 			
			
				
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null) pstmt.close(); 
	  }else
	  {     
	  //Below query modified for this CRF ML-MMOH-CRF-0466
		     orInstall  = "N";
			 String sql = "SELECT ACTION_ON_PENDING_BILL,BILLING_INTERFACED_YN,ALLOW_CHKOUT_WITH_BILL_STMT_YN,INV_REG_NEW_BORN_YN, VISIT_BACKDATING_ALLOWED_YN,REG_ATTENDANCE_FOR_INPAT_YN,INVOKE_RECALL_FOR_AE, RECONFIRM_CASE_OF_TRAUMA, REC_DIAG_NOT_MDT_BID,REC_DIAG_NOT_MDT_ABSCONDED,REC_DIAG_NOT_MDT_DID_YN,REC_DIAG_MDT_CALLNOTAROUND_YN, MAX_HOURS_ALLOW_INSERT,MAX_DAYS_ALLOW_UPDATE,CUTOFF_HOURS_PRV_DAY_VISIT, MIN_AGE_FOR_PREG_DTL, MAX_AGE_FOR_PAED_DTL,RECORD_VITAL_SIGNS_YN,ENABLE_ACCS_RIGHTS_IN_QUEUE,five_level_triage_appl_yn, NVL(QUEUE_REFRESH_INTERVAL,0) QUEUE_REFRESH_INTERVAL, DIST_PAT_SER_GRP, BACKDATE_CONS_ALLOWED_YN, BACKDATE_CONS_ALLOWED_HRS,CHK_FOR_PEN_ORDERS_BFR_CHKOUT,CHECKOUT_ALLOW_YN, VALIDATE_NATID_REG_ATTN,ENABLE_ADMISSION_TAB FROM AE_PARAM a WHERE OPERATING_FACILITY_ID=?";
			  pstmt		= con.prepareStatement(sql);
			 pstmt.setString(1,facilityId);
			 rset	 = pstmt.executeQuery();
			 while(rset!=null && rset.next())
			  {
				 	ACTION_ON_PENDING_BILL = rset.getString("ACTION_ON_PENDING_BILL") == null ? "" :rset.getString("ACTION_ON_PENDING_BILL"); // Added for MMS-QH-CRF-0126.2 [IN:042931]
				 	billing_interfaced_yn		= rset.getString("BILLING_INTERFACED_YN");
					if(billing_interfaced_yn!=null && billing_interfaced_yn.equalsIgnoreCase("Y"))
						checkBoxAttribute       = "CHECKED";

					allow_chkout_with_bill_stmt_yn	= rset.getString("ALLOW_CHKOUT_WITH_BILL_STMT_YN");
					if(allow_chkout_with_bill_stmt_yn!=null && allow_chkout_with_bill_stmt_yn.equalsIgnoreCase("Y"))
						checkBoxAttributeBL       = "CHECKED";

					visit_backdating_allowed_yn	= rset.getString("VISIT_BACKDATING_ALLOWED_YN");
					if(visit_backdating_allowed_yn!=null && visit_backdating_allowed_yn.equalsIgnoreCase("Y"))
						checkBoxAttribute1       = "CHECKED";
					
					/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
					backDateConsAllowedYn		= rset.getString("BACKDATE_CONS_ALLOWED_YN");
					if(backDateConsAllowedYn != null && backDateConsAllowedYn.equalsIgnoreCase("Y"))
						consCheckBoxAttribute   = "CHECKED";

					backDateConsAllowedHrs		= rset.getString("BACKDATE_CONS_ALLOWED_HRS");
					backDateConsAllowedHrs 		= (backDateConsAllowedHrs == null)?"":backDateConsAllowedHrs;
					/*End*/
					/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
					CHK_FOR_PEN_ORDERS_BFR_CHKOUT	 = rset.getString("CHK_FOR_PEN_ORDERS_BFR_CHKOUT") == null ? "N" :rset.getString("CHK_FOR_PEN_ORDERS_BFR_CHKOUT");
					CHECKOUT_ALLOW_YN				 = rset.getString("CHECKOUT_ALLOW_YN") == null ? "N" :rset.getString("CHECKOUT_ALLOW_YN");
					/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

					//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
					enable_admission_tab	 = rset.getString("ENABLE_ADMISSION_TAB") == null ? "N" :rset.getString("ENABLE_ADMISSION_TAB");
					//enable_admission_tab="Y";
					
					//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
					
					
					
					reg_attendance_for_inpat_yn  = rset.getString("REG_ATTENDANCE_FOR_INPAT_YN");
					if(reg_attendance_for_inpat_yn!=null && reg_attendance_for_inpat_yn.equalsIgnoreCase("Y"))
						checkBoxAttribute2       = "CHECKED";

					/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
					invoke_recall_for_AE  = rset.getString("INVOKE_RECALL_FOR_AE");
					if(invoke_recall_for_AE!=null && invoke_recall_for_AE.equalsIgnoreCase("Y"))
					checkBoxAttributeRecall = "CHECKED";
					/*End ML-MMOH-CRF-0657*/

					/*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
					reconfirm_case_of_trauma  = rset.getString("RECONFIRM_CASE_OF_TRAUMA");
					if(reconfirm_case_of_trauma!=null && reconfirm_case_of_trauma.equalsIgnoreCase("Y"))
					chkReconfCot = "CHECKED";
					/*End ML-MMOH-CRF-1409*/

					/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
					validate_natid_reg_attn = rset.getString("VALIDATE_NATID_REG_ATTN");
					if(validate_natid_reg_attn!=null && validate_natid_reg_attn.equalsIgnoreCase("Y"))
					checkBoxAttributeNatIdVal = "CHECKED";
					/*End MO-CRF-20148*/

					//Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
					Rec_diag_not_mdt_BID  = rset.getString("REC_DIAG_NOT_MDT_BID");
					if(Rec_diag_not_mdt_BID!=null && Rec_diag_not_mdt_BID.equalsIgnoreCase("Y"))
						checkBoxAttribute_BID       = "CHECKED";

					//Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
					Rec_diag_not_mdt_absconded  = rset.getString("REC_DIAG_NOT_MDT_ABSCONDED");
					if(Rec_diag_not_mdt_absconded!=null && Rec_diag_not_mdt_absconded.equalsIgnoreCase("Y"))
						checkBoxAttribute_BID       = "CHECKED";
					
					//Added by Mano against ML-MMOH-CRF-0783
					Rec_diag_not_mdt_DID_yn  = rset.getString("REC_DIAG_NOT_MDT_DID_YN");
					if(Rec_diag_not_mdt_DID_yn!=null && Rec_diag_not_mdt_DID_yn.equalsIgnoreCase("Y"))
						checkBoxAttribute_DID_yn = "CHECKED";
					
					//Added by Mano against ML-MMOH-CRF-0783
					Rec_diag_mdt_CALLNOTAROUND_yn = rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN");
					if(Rec_diag_mdt_CALLNOTAROUND_yn!=null && Rec_diag_mdt_CALLNOTAROUND_yn.equalsIgnoreCase("Y"))
					   checkBoxAttribute_CALLNOTAROUND_yn  = "CHECKED";
				   
					//Added by Mani on 03-Aug-2017 
					inv_reg_new_born_yn  = rset.getString("INV_REG_NEW_BORN_YN");
					if(inv_reg_new_born_yn!=null && inv_reg_new_born_yn.equalsIgnoreCase("Y"))
						chk_inv_reg_new_born_yn       = "CHECKED";
					
					
					

					max_hours_allow_insert		= rset.getString("MAX_HOURS_ALLOW_INSERT");    
					max_hours_allow_insert 		= (max_hours_allow_insert == null)?"":max_hours_allow_insert;
					max_days_allow_update		= rset.getString("MAX_DAYS_ALLOW_UPDATE");
					max_days_allow_update 		= (max_days_allow_update == null)?"":max_days_allow_update;
					cutoff_hours_prv_day_visit	= rset.getString("CUTOFF_HOURS_PRV_DAY_VISIT");
					cutoff_hours_prv_day_visit	= (cutoff_hours_prv_day_visit == null)?"":cutoff_hours_prv_day_visit;
					
					if (min_age_for_preg_dtl.equals(""))
					{
						min_age_for_preg_dtl		= rset.getString("MIN_AGE_FOR_PREG_DTL");
						min_age_for_preg_dtl 		= (min_age_for_preg_dtl == null)?"":min_age_for_preg_dtl;
					}
					else{
					//minAgeDis = "disabled";
					}
					max_age_for_paed_dtl		= rset.getString("MAX_AGE_FOR_PAED_DTL");
					max_age_for_paed_dtl 		= (max_age_for_paed_dtl == null)?"":max_age_for_paed_dtl;
					queue_refresh_intervel	    = rset.getString("QUEUE_REFRESH_INTERVAL");
					queue_refresh_intervel      = (queue_refresh_intervel == null)?"":queue_refresh_intervel;
                    enable_accs_rights_in_queue = rset.getString("ENABLE_ACCS_RIGHTS_IN_QUEUE");
					enable_accs_rights_in_queue 	= (enable_accs_rights_in_queue==null)?"N":enable_accs_rights_in_queue;
					if(enable_accs_rights_in_queue!=null && enable_accs_rights_in_queue.equalsIgnoreCase("Y"))
				     checkBoxRecord1       = "CHECKED";
					 
				   /*Below line added for this CRF MMS-QH-CRF-0146 [IN:043836]*/
				   five_level_triage_appl_yn = rset.getString("five_level_triage_appl_yn");
				   five_level_triage_appl_yn = (five_level_triage_appl_yn == null)?"N":five_level_triage_appl_yn;
				   if(five_level_triage_appl_yn!=null && five_level_triage_appl_yn.equalsIgnoreCase("Y")){ 
				   leveltriage_checkbox = "CHECKED";
				   leveltriage_checkbox_disable= "DISABLED";
				   }
				   //End this CRF MMS-QH-CRF-0146 [IN:043836]	

                    //Below line added for this CRF ML-MMOH-CRF-0466
                     dist_pat_series_code = rset.getString("DIST_PAT_SER_GRP");
					 dist_pat_series_code = (dist_pat_series_code == null)?"":dist_pat_series_code;
					 System.err.println("dist_pat_series_code===>"+dist_pat_series_code);
					 //End ML-MMOH-CRF-0466                       					 
					 
				    record_vital_signs_yn  = rset.getString("RECORD_VITAL_SIGNS_YN");
					record_vital_signs_yn = (record_vital_signs_yn == null)?"N":record_vital_signs_yn;
					if(record_vital_signs_yn!=null && record_vital_signs_yn.equalsIgnoreCase("Y"))
					 {	
						checkBoxRecord       = "CHECKED";
					 }else
					 { 
						 checkBoxRecord = "";  
					 }
					mode						= "MODIFY";
					
			  }
			  if(rset!=null)  rset.close();
			  if(pstmt!=null) pstmt.close(); 
			  
	  }
	  if(!order_catlog_code1.equals(""))
	   {
		   order1Dis ="disabled";
	   }
	   else
	   {  
		   order1Dis ="";
	   }
       if(!order_catlog_code2.equals(""))
	   {
		   order2Dis ="disabled";
	   }
	   else
	   {  
		   order2Dis =""; 
	   }
       if(!order_catlog_code3.equals(""))
	   {
		   order3Dis ="disabled";
	   }
	   else
	   {  
		   order3Dis =""; 
	   }
	   if(!order_catlog_code4.equals(""))
	   {
		   order4Dis ="disabled";
	   }
	   else
	   {  
		   order4Dis =""; 
	   }
	   if(!order_catlog_code5.equals(""))
	   {
		   order5Dis ="disabled";
	   }
	   else
	   {  
		   order5Dis =""; 
	   }
	   /*Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0651 Start*/
	   if(!orderCatalogCode6.equals(""))
	   	   order6Dis ="disabled";
	   else
		   order6Dis ="";
	   /*End*/	   
	  if(!systolicBP.equals(""))
	  {
		 sysBPDis ="disabled";
	  }
	  else
	  {  
		  sysBPDis =""; 
	  }
	  if(!respiratory.equals(""))
	  {
		 respirDis ="disabled";
	  }
	  else
	  {  
		  respirDis =""; 
	  }
		if(!nursing_unit.equals(""))
	   {
		   nursing_unitDis ="disabled";
	   }
	   else{  nursing_unitDis =""; }
		
		//MMS-QH-CRF-0126.2 [IN:042931] Strat	
		if(ACTION_ON_PENDING_BILL.equals("W"))
			selWarning = "selected";
		else if(ACTION_ON_PENDING_BILL.equals("S"))
			selStop = "selected";
		else if(ACTION_ON_PENDING_BILL.equals("N"))
			selNoAction = "selected";
		//MMS-QH-CRF-0126.2 [IN:042931] End

   %>
	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="parameter_form" id="parameter_form" action="../../servlet/eAE.AEParameterServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='98%'>
	  <%if(bl_operational.equalsIgnoreCase("Y")) {%>
		 <tr>
		 	<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.BillingInterface.label" bundle="${ae_labels}"/></td>
		 </tr>

        <tr>
		    
		      <td class='label'  width='25%'><fmt:message key="eAE.BillingInterfaced.label" bundle="${ae_labels}"/></td>
			    <td class='label'  width='25%'>&nbsp;</td> 	
		      <td class='fields'  width='25%'><input type='checkbox' name='billing_interfaced_yn' id='billing_interfaced_yn' value='<%=billing_interfaced_yn%>' <%=checkBoxAttribute%> onclick='chkValue(this);'  <%=billingPorp%> >
			  </td> 	
		      <td class='label' width='23%'>&nbsp;</td>
	    </tr>	
		<tr>
		    
		      <td class='label'  width='25%'><fmt:message key="eAE.AllowAEchkoutWithBillSettle.label" bundle="${ae_labels}"/></td>
			  <td class='label'  width='25%'>&nbsp;</td> 	
		      <td class='fields'  width='25%'><input type='checkbox' name='allow_chkout_with_bill_stmt_yn' id='allow_chkout_with_bill_stmt_yn' value='<%=allow_chkout_with_bill_stmt_yn%>' <%=checkBoxAttributeBL%> onclick='chkValue(this);'>
			  </td> 	
		      <td class='label' width='23%'>&nbsp;</td>
	    </tr>	
       <%}else{%>
          <tr>
			  <input type='hidden' name='billing_interfaced_yn' id='billing_interfaced_yn' value='N'  onclick='' > 
			  <input type='hidden' name='allow_chkout_with_bill_stmt_yn' id='allow_chkout_with_bill_stmt_yn' value='N'  onclick='' > 
		      <td class='label' colspan='4'>&nbsp;</td> 	
	      </tr>	

	   <%}%>
		 <tr>
		 			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.VisitControls.label" bundle="${common_labels}"/></td>
		 </tr>

		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		<!--Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start-->
		<% if(isStartConsultationAppl){ %>
		<tr>
			<td class='label'   nowrap colspan='2'>
				<fmt:message key="eAE.AllowbackdatingConsDateTime.label" bundle="${ae_labels}"/>
			</td>
		    <td class='fields'  nowrap colspan='2'>
				<input type='checkbox' name='back_date_cons_yn' id='back_date_cons_yn' value='<%=backDateConsAllowedYn%>' <%=consCheckBoxAttribute%> onclick='onCheckEnableDisableHrs(this)'> &nbsp;&nbsp; <fmt:message key="Common.within.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type='text' name='back_date_cons_hrs' id='back_date_cons_hrs' value='<%=backDateConsAllowedHrs%>' <%=disableBackDateHrs%> maxLength='2' size='2' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);checkRangeMaxHours(this);putDecimal(this,5,0);'><img id='cons_bkdatng_img' src='../../eCommon/images/mandatory.gif' ></img>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
			</td>   	
	    </tr>
		<% } %>
		<!--End-->
	    <tr>
		      <td class='label'   nowrap colspan='2'><fmt:message key="eAE.AllowbackdatingofVisitDateTime.label" bundle="${ae_labels}"/></td>
		      <td class='fields'  nowrap colspan='2'><input type='checkbox' name='visit_backdating_allowed_yn' id='visit_backdating_allowed_yn' value='<%=visit_backdating_allowed_yn%>' <%=checkBoxAttribute1%> onclick='chkValue(this);changeVal(this);' <%=visitDis%> >
			     &nbsp;&nbsp; <fmt:message key="Common.within.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type='text' name='max_hours_allow_insert' id='max_hours_allow_insert' value='<%=max_hours_allow_insert%>' maxLength='2' size='2'
				 onKeyPress='return(ChkNumberInput(this,event,0))'
				 onBlur='SPCheckPositiveNumber(this);checkRangeMaxHours(this);putDecimal(this,5,0);' <%=hrsDis%> ><img id='backdating_gif' src='../../eCommon/images/mandatory.gif' ></img>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
			   	
	    </tr>	
		<tr>
		       <td class='label'   nowrap colspan='2'><fmt:message key="eAE.MaxNoofdayallowedforrevattenddetls.label" bundle="${ae_labels}"/></td>
		      <td class='fields' >
			     <input type='text' name='max_days_allow_update' id='max_days_allow_update' value='<%=max_days_allow_update%>' maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);checkRangeMaxRevise(this);(this);putDecimal(this,5,0);' <%=daysDis%> >
			     <img src='../../eCommon/images/mandatory.gif' ></img>&nbsp;
			  </td> 	
		      <td class='label' >&nbsp;</td>
	    </tr>
		<tr>
			<td class='label'  nowrap colspan='2'><fmt:message key="eAE.Cutoffperiodforincluding.label" bundle="${ae_labels}"/></td>
			<td class='fields' colspan='2'>
				  <input type='text' name='cutoff_hours_prv_day_visit' id='cutoff_hours_prv_day_visit' value='<%=cutoff_hours_prv_day_visit%>' maxLength='2' size='2'onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);checkRangeMaxCutoff(this);putDecimal(this,5,0);' <%=cutoffDis%> ><img src='../../eCommon/images/mandatory.gif' ></img>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
		</tr>	
		<tr>
		      <td class='label'   nowrap colspan='2'><fmt:message key="eAE.AllowRegAttendInpat.label" bundle="${ae_labels}"/></td>
		      <td class='fields'  nowrap colspan='2'><input type='checkbox' name='reg_attendance_for_inpat_yn' id='reg_attendance_for_inpat_yn' value='<%=reg_attendance_for_inpat_yn%>' <%=checkBoxAttribute2%> onclick='chkValue(this);' ></td>
			  	
	    </tr>
	<!-- below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272] -->
	<tr>
		      <td class='label'   nowrap colspan='2'><fmt:message key="eAE.PromptMsgReAttnd.label" bundle="${ae_labels}"/></td>
		      <td class='fields' >
			     <input type='text' name='re_attendace_hour' id='re_attendace_hour' value='<%=max_hrs_re_attend%>' maxLength='3' size='3' onBlur='SPCheckPositiveNumber(this);checkRangeMaxHours1(this);putDecimal(this,5,0);' onKeyPress='return(ChkNumberInput(this,event,0))'>
			     <img src='../../eCommon/images/mandatory.gif' ></img>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
			  </td> 	
		      <td class='label' >&nbsp;</td>
	    </tr> 
		<!--end CRF Bru-HIMS-CRF-152 [IN030272]  -->
		
		<!--Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624 and ML-MMOH-CRF-0630-->
		<tr>
		      <td class='label'   nowrap colspan='2'><fmt:message key="eAE.RecordDiagnosisNotMandatory.label" bundle="${ae_labels}"/></td>
		      <td class='fields'  nowrap colspan='2'><input type='checkbox' name='Rec_diag_not_mdt_BID' id='Rec_diag_not_mdt_BID' value='<%=Rec_diag_not_mdt_BID%>' <%=checkBoxAttribute_BID%> onclick='chkValue(this);'><fmt:message key="Common.bid.label" bundle="${common_labels}"/> &nbsp;&nbsp;
			 <input type='checkbox' name='Rec_diag_not_mdt_absconded' id='Rec_diag_not_mdt_absconded' value='<%=Rec_diag_not_mdt_absconded%>' <%=checkBoxAttribute_absconded%> onclick='chkValue(this);'><fmt:message key="Common.Absconded.label" bundle="${common_labels}"/>
			 <!--below changes added by Mano Aganist ML-MMOH-CRF-0783-->
			 <% if(isDidCallNotAroundDgnNotAppl){ %>
			 <input type='checkbox' name='Rec_diag_not_mdt_DID_yn' id='Rec_diag_not_mdt_DID_yn' value='<%=Rec_diag_not_mdt_DID_yn%>' <%=checkBoxAttribute_DID_yn%> onclick='chkValue(this);'><fmt:message key="Common.did.label" bundle="${common_labels}"/> &nbsp;&nbsp;
			 <input type='checkbox' name='Rec_diag_mdt_CALLNOTAROUND_yn' id='Rec_diag_mdt_CALLNOTAROUND_yn' value='<%=Rec_diag_mdt_CALLNOTAROUND_yn%>' <%=checkBoxAttribute_CALLNOTAROUND_yn%> onclick='chkValue(this);'><fmt:message key="Common.CallNotAround.label" bundle="${common_labels}"/></td>
			 <% } %>
	    </tr>
		<!--Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624 and ML-MMOH-CRF-0630-->
		
		
		<!--Below line added for this CRF ML-MMOH-CRF-0639--> 		
		<tr>
		      <td class='label'   nowrap colspan='2'><fmt:message key="eAE.DisplayAEattendanceregisteredwithinHrs.label" bundle="${ae_labels}"/></td>
		      <td class='fields' >
			     <input type='text' name='re_attendace_within_hour' id='re_attendace_within_hour' value='<%=re_attendace_within_hour%>' maxLength='2' size='2' onBlur='SPCheckPositiveNumber(this);checkRangeMiniHours(this);putDecimal(this,5,0);' onKeyPress='return(ChkNumberInput(this,event,0))'>
			     <img src='../../eCommon/images/mandatory.gif' ></img>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
			  </td> 	
		      <td class='label' >&nbsp;</td>
	    </tr> 
		<!--End this CRF ML-MMOH-CRF-0639-->
<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start-->
	<tr>
		<td class=label><fmt:message key="eAE.ChkForPendingOrdersBeforeAECheckout.label" bundle="${ae_labels}" /> </td>
		<td class=fields>
			<input type='checkbox' size='8' maxlength='8'  name='chk_for_pen_orders_bfr_chk' id='chk_for_pen_orders_bfr_chk' value='Y'tabIndex='0' onclick='fnChkPendingOrders()' <%if("Y".equals(CHK_FOR_PEN_ORDERS_BFR_CHKOUT)){%>checked<%}%> ></td>
		<td  colspan=2 class=label>
			<fmt:message key="eIP.IfOrdersArePending.label" bundle="${ip_labels}"  /> 
			<input type='radio' id='notallow' name='chk_not_allow' id='chk_not_allow' value='N'  tabIndex='0' <%if("N".equals(CHK_FOR_PEN_ORDERS_BFR_CHKOUT)){%>disabled<%}else if("N".equals(CHECKOUT_ALLOW_YN)){%>checked<%}%> onclick='allowNotAllowChk(this)' >
			<height=5 colspan=2 class=label>
				<fmt:message key="eAE.DonotallowAECheckout.label" bundle="${ae_labels}"  />
				<input type='radio' id='allow' name='chk_allow' id='chk_allow' value='Y'  tabIndex='0' <%if("N".equals(CHK_FOR_PEN_ORDERS_BFR_CHKOUT)){%>disabled<%}else if("Y".equals(CHECKOUT_ALLOW_YN)){%>checked<%}%> onclick='allowNotAllowChk(this)'>
			<height=5 colspan=2 class=label>
				<fmt:message key="eAE.AllowAECheckout.label" bundle="${ae_labels}"/>
			</td>	
			<input type='hidden' name='checkout_allow_yn' id='checkout_allow_yn' value='N' >
	</tr>	
<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End-->

<!--Added by Mujafar for KDAH-CRF-0526 -->
		<%if(isAERegisterTypeAutoUpdateAppl){%>
		
		<tr>
		  <td class='label' nowrap  ><fmt:message key="eAE.AERegistrationTypeAutoUpdate.label" bundle="${ae_labels}"/></td>
			<td class='fields' >
			     <input type='text' name='ae_reg_update_val' id='ae_reg_update_val' value='<%=dfltRegAutoUpdateTime%>' maxLength='2' size='2' onBlur='SPCheckPositiveNumber(this);checkRangeMiniHours(this);putDecimal(this,5,0);' onKeyPress='return(ChkNumberInput(this,event,0))'>
			    &nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
			  </td>   
		   <td class='label'  ><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.followup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			
			<td class='fields'  	>
					 <select name='emerFollowSel' id='emerFollowSel' <%=disEmerFollowTypeCode%>  ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			
						<%
						                try{ 	
						
										  String sql="SELECT distinct visit_type_code, visit_type_short_desc   FROM op_visit_type_for_clinic_vw  WHERE care_locn_type_ind = 'C' AND visit_type_ind = 'W' AND facility_id = '"+facilityId+"'  AND eff_status = 'E' AND visit_type_eff_status = 'E' ";
										  String selval= "";
									
										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql);
										 if(rset!=null) {
										 String id1="";
										 String val1="";
										 
										 while(rset.next()) {
											 id1=rset.getString("visit_type_code");
											 val1=rset.getString("visit_type_short_desc");
											 if(id1.equals(dfltEmerFollowTypeCode))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+val1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           %>


           
			</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'  name='mand_reg_follow_up' <%=vis_mand_reg_follow_up%> ></img></td>

			
		  
	    </tr>
		
		<%}%>
		<!--End KDAH-CRF-0526 -->


		<!--Added by Ashwini on 06-Mar-2019 for MO-CRF-20148-->
		<%if(isNationalIdValidationAppl){%>
		<tr>
		      <td class='label' nowrap colspan='2'><fmt:message key="eAE.ValidateNatIDRegAttn.label" bundle="${ae_labels}"/></td>
		      <td class='fields' nowrap colspan='2'><input type='checkbox' name='validate_natid_reg_attn' id='validate_natid_reg_attn' value='<%=validate_natid_reg_attn%>' <%=checkBoxAttributeNatIdVal%> onclick='chkValue(this);'></td>
	    </tr>
		<%}%>
		<!--End MO-CRF-20148-->
		
		<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->
		<%if(isRecallForAEAppl){%>
		<tr>
		      <td class='label'   nowrap colspan='2'><fmt:message key="eAE.InvokeRecallForAE.label" bundle="${ae_labels}"/></td>
		      <td class='fields'  nowrap colspan='2'><input type='checkbox' name='invoke_recall_for_AE' id='invoke_recall_for_AE' value='<%=invoke_recall_for_AE%>' <%=checkBoxAttributeRecall%> onclick='chkValue(this);' ></td>
	    </tr>
		<%}%>
		<!--End ML-MMOH-CRF-0657-->
		
		<!-- Added by Mujafar  for ML-MMOH-CRF-1427 start -->
		
		<%
		if(isPatientEncRevokeDeathAppl)
		{ // Added by mujafar for ML-MMOH-CRF-1427
		%>
		<tr>
		
			<td  class='label' colspan='2' ><fmt:message key="eOP.DispTypeFOrOPEncounterRevokeDeath.label" bundle="${op_labels}"/>
                                    </td>
                                    <td class='fields' colspan='2'  ><select name='DISP_TYPE_FOR_REVOKE_DEATH' id='DISP_TYPE_FOR_REVOKE_DEATH' >
                                            <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
										<%
						                try{ 	
						
										  String sql="select disp_type, short_desc from am_disposition_type where eff_status='E' and use_at_concl_yn='Y' and DECEASED_YN = 'N' order by 2";
										  String selval= "";

										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql);
										 if(rset!=null) {
										 String id1="";
										 String val1="";
										 
										 while(rset.next()) {
											 id1=rset.getString("disp_type");
											 val1=rset.getString("short_desc");
											 if(id1.equals(dispTypeForRevokeDeath))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+val1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           %>
							</select>
							</td>
		
		
		</tr>
		<%}%>
		
		
		<!-- Added by Mujafar  for ML-MMOH-CRF-1427 end  -->

		<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
		<%if(isReconfirmCOTAppl){%>
		<tr>
		      <td class='label' nowrap colspan='2'><fmt:message key="eAE.ReconfirmCOT.label" bundle="${ae_labels}"/></td>
		      <td class='fields' nowrap colspan='2'><input type='checkbox' name='reconfirm_case_of_trauma' id='reconfirm_case_of_trauma' value='<%=reconfirm_case_of_trauma%>' <%=chkReconfCot%> onclick='chkValue(this);'></td>
	    </tr>
		<%}%>
		<!--End ML-MMOH-CRF-1409-->
		
		
	<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
	<tr>
	<% if(isPendingForAdmissionAppl){%>
		<td class=label><fmt:message key="eAE.EnableForAdmission.label" bundle="${ae_labels}" /> </td>
		<td class=fields>
			<input type='checkbox' size='8' maxlength='8'  name='enable_admission_tab' id='enable_admission_tab' id='enable_admission_tab' value='Y' tabIndex='0' onclick='enableValueChange()' <%if("Y".equals(enable_admission_tab)){%>checked<%}%> ></td>
	<% }%>
	</tr>
	<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
	

        <tr>
		   <td colspan='4' class='label'>&nbsp;</td>
		</tr>	
		<tr>
		 			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.AgeLimits.label" bundle="${ae_labels}"/></td>
		</tr>

		<tr>
		      <td class='label'  nowrap colspan='2'><fmt:message key="eAE.MinAgeofcapturingpediatric.label" bundle="${ae_labels}"/></td>
		      <td class='fields' >
			     <input type='text' name='min_age_for_preg_dtl' id='min_age_for_preg_dtl' value='<%=min_age_for_preg_dtl%>' maxLength='2' size='2'  onKeyPress='return(ChkNumberInput(this,event,0))'  <%=minAgePro%> >
  			    <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
		      <td class='label'  >&nbsp;</td>
	    </tr>	
	
		<tr>
		      <td class='label'  nowrap colspan='2'><fmt:message key="eAE.MaxAgeofcapturingpediatric.label" bundle="${ae_labels}"/></td>
		      <td class='fields' >
			     <input type='text' name='max_age_for_paed_dtl' id='max_age_for_paed_dtl' value='<%=max_age_for_paed_dtl%>' maxLength='2' size='2' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);checkRangeMaxPreg(this);putDecimal(this,5,0);' <%=maxAgeDis%> >
  			    <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
		      <td class='label' >&nbsp;</td>
	    </tr>

		<tr>
		      <td class='label'  nowrap colspan='2'><fmt:message key="eAE.MinAgeofcapturingLMP.label" bundle="${ae_labels}"/></td>
		      <td class='fields' >
			     <input type='text' name='min_age_for_lmp' id='min_age_for_lmp' value='<%=min_age_for_lmp%>' maxLength='2' size='2' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);checkRangeMaxPreg(this);putDecimal(this,5,0);' >
  			    <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
		      <td class='label' >&nbsp;</td>
	    </tr>



<%if(cnt>0)
	  {
%>
		<tr>
		 			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		</tr>
	<tr>
		   <td colspan='4'>&nbsp;</td> 
	</tr>
	 <tr>
		<!--Added by Thamizh selvi on 11th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngsAppl){ %>
			 <td class='label' colspan='1' ><fmt:message key="eAE.CBD.label" bundle="${ae_labels}"/></td> 
             <td class='fields' colspan='1'><input type=text  name='order_catalog_code6' id='order_catalog_code6' onBlur = 'if(this.value != "")beforeCallSearch(ordercatalogcode6,order_catalog_code6);' value="<%=orderCatalogDesc6%>" size="30" maxlength="40"   <%=order6Dis%> ><input type='button' name='ordercatalogcode6' id='ordercatalogcode6' value='?' class='button' onclick='callSearch(this,order_catalog_code6)' <%=order6Dis%>> </td>
			 <input type='hidden' name='order_catalog_code1' id='order_catalog_code1' value="">
			 <input type='hidden' name='order_catalog_code5' id='order_catalog_code5' value="">
		<% }else{ %><!--End-->	
	         <td class='label' colspan='1' ><fmt:message key="eAE.SpO2.label" bundle="${ae_labels}"/></td> 
             <td class='fields' colspan='1'><input type=text  name='order_catalog_code1' id='order_catalog_code1' onBlur = 'if(this.value != "")beforeCallSearch(ordercatalogcode1,order_catalog_code1);' value="<%=order_catalog_code1%>" size="30" maxlength="40"   <%=order1Dis%> ><input type='button' name='ordercatalogcode1' id='ordercatalogcode1' value='?' class='button' onclick='callSearch(this,order_catalog_code1)' <%=order1Dis%>> </td>
		<% } %>
	         <td class='label' colspan='1' ><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
             <td class='fields' colspan='1'><input type=text  name='order_catalog_code2' id='order_catalog_code2'  onBlur = 'if(this.value != "")beforeCallSearch(ordercatalogcode2,order_catalog_code2);' value="<%=order_catalog_code2%>" size="30" maxlength="40"   <%=order2Dis%>><input type='button' name='ordercatalogcode2' id='ordercatalogcode2' value='?' class='button' onclick='callSearch(this,order_catalog_code2)' <%=order2Dis%>> </td>
	  </tr> 
	  <tr>
			 <td class='label'  colspan='1'><fmt:message key="eAE.FBC.label" bundle="${ae_labels}"/></td>
             <td class='fields' colspan='1'><input type=text  name='order_catalog_code3' id='order_catalog_code3'   onBlur = 'if(this.value != "")beforeCallSearch(ordercatalogcode3,order_catalog_code3);' value="<%=order_catalog_code3%>" size="30" maxlength="40" 
			  <%=order3Dis%>><input type='button' name='ordercatalogcode3' id='ordercatalogcode3' value='?' class='button'  onclick='callSearch(this,order_catalog_code3)' <%=order3Dis%>> </td>
		<!--Added by Thamizh selvi on 11th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngsAppl){ %>
	         <td class='label' colspan='1' ><fmt:message key="Common.Compression.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Dressing.label" bundle="${common_labels}"/></td>
		<% }else{ %><!--End-->
			 <td class='label' colspan='1' ><fmt:message key="Common.Dressing.label" bundle="${common_labels}"/></td>
		<% } %>
             <td class='fields' colspan='1'><input type=text  name='order_catalog_code4' id='order_catalog_code4'  onBlur = 'if(this.value != "")beforeCallSearch(ordercatalogcode4,order_catalog_code4);' value="<%=order_catalog_code4%>" size="30" maxlength="40"   <%=order4Dis%>><input type='button' name='ordercatalogcode4' id='ordercatalogcode4' value='?' class='button' onclick='callSearch(this,order_catalog_code4)' <%=order4Dis%>> </td>
	  </tr>
	<% if(!isOrderCatalogChngsAppl){ %><!--Added by Thamizh selvi on 11th Apr 2018 against ML-MMOH-CRF-0651-->
	  <tr>
			 <td class='label'   nowrap colspan='1'><fmt:message key="eAE.CapillaryBloodSugar.label" bundle="${ae_labels}"/></td>
             <td class='fields' colspan='1'><input type=text  name='order_catalog_code5' id='order_catalog_code5'  onBlur = 'if(this.value != "")beforeCallSearch(ordercatalogcode5,order_catalog_code5);' value="<%=order_catalog_code5%>" size="30" maxlength="40"   <%=order5Dis%>><input type='button' name='ordercatalogcode5' id='ordercatalogcode5' value='?' class='button' onclick='callSearch(this,order_catalog_code5)' <%=order5Dis%>> </td>
	         <td class='label' colspan='1' >&nbsp;</td>
             <td class='label'colspan='1'>&nbsp</td>
			 <input type='hidden' name='order_catalog_code6' id='order_catalog_code6' value="">
	  </tr>
	<% } %>
	  <tr>
		   <td colspan='4'>&nbsp;</td>
	  </tr>

		<!--Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngsAppl){ %>
		<tr>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.LegendNameConfig.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			 <td colspan=4 class='label' height=5></td>
		</tr>
		<tr>
			<td class='label' colspan='1'>
				<fmt:message key="eAE.InitialManagement.label" bundle="${ae_labels}"/>
			</td>
			<td class='fields'colspan='1'>
				<input type=text  name='initialMgmtLbl' id='initialMgmtLbl'  onKeyPress="return CheckForSpecChar(event)" onPaste = "return false;" value="<%=initialMgmtLblConfig%>" size="30" maxlength="30">
			</td>
			<td class='label' colspan='1'>
				<fmt:message key="Common.Compression.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
			</td>
			<td class='fields' colspan='1'>
				<input type=text  name='CompressionDressngLbl' id='CompressionDressngLbl' onKeyPress="return CheckForSpecChar(event)" onPaste = "return false;" value='<%=dressingLblConfig%>' size="30" maxlength="30">
			</td>
		</tr>
		<tr>
			 <td colspan=4 class='label' height=5></td>
		</tr>
		<% } %>
		<!--End-->
		 <%
		 if (ca_install_yn.equals("Y"))
		  {
		 %>

		   <tr>
		 <td class='COLUMNHEADER' colspan='4' ><fmt:message key="eOP.recordvitalsigns.label" bundle="${op_labels}"/></td>
		        </tr>
				<tr>
					 <td colspan=4 class='label' height=5></td>
				</tr>
				<tr>
					 <td class='label' colspan='1' ><fmt:message key="eAE.SystolicBP.label" bundle="${ae_labels}"/></td>
					 <td class='fields'colspan='1'><input type=text  name='systolicBP' id='systolicBP' onBlur = 'checkForValidData2(this);if(this.value != "")beforeCallSearchVital(systolicBPbutt,systolicBP);' value="<%=systolicBPdesc%>" size="15" maxlength="15" 
					  <%=sysBPDis%> ><input type='button' name='systolicBPbutt' id='systolicBPbutt' value='?' class='button' onclick='callSearchVital(this,systolicBP);' <%=sysBPDis%>> </td>
					 <td class='label' colspan='1' ><fmt:message key="eAE.RespiratoryRate.label" bundle="${ae_labels}"/></td>
					 <td class='fields' colspan='1'><input type=text  name='respiratory' id='respiratory' onBlur = 'checkForValidData2(this);if(this.value != "")beforeCallSearchVital(respiratorybutt,respiratory);' value='<%=respiratorydesc%>' size="15" maxlength="15"   <%=respirDis%> ><input type='button' name='respiratorybutt' id='respiratorybutt' value='?' class='button' onclick='callSearchVital(this,respiratory);' <%=respirDis%> > </td>
				</tr>
				<tr>
					 <td colspan=4 class='label' height=5></td>
				</tr>

					<input type='hidden' name='systolicBPhdd' id='systolicBPhdd' value='<%=systolicBP%>' >	
					<input type='hidden' name='respiratoryhdd' id='respiratoryhdd' value='<%=respiratory%>' >	
		<%
			
		} //CAInstalled condition ends
	}%> 
		

				<input type='hidden' name='order_cat_code1' id='order_cat_code1' value="<%=order_catlog_code1%>">	
				<input type='hidden' name='order_cat_code2' id='order_cat_code2' value="<%=order_catlog_code2%>" >	 
				<input type='hidden' name='order_cat_code3' id='order_cat_code3' value="<%=order_catlog_code3%>" >	 
				<input type='hidden' name='order_cat_code4' id='order_cat_code4' value="<%=order_catlog_code4%>" >	 
				<input type='hidden' name='order_cat_code5' id='order_cat_code5' value="<%=order_catlog_code5%>" >	  
				<input type='hidden' name='order_cat_code6' id='order_cat_code6' value="<%=orderCatalogCode6%>" ><!--Added by Thamizh selvi on 11th Apr 2018 against ML-MMOH-CRF-0651-->	  
				<input type='hidden' name='caInstall' id='caInstall' value="<%=ca_install_yn%>" >	  
				<input type='hidden' name='mode' id='mode' value='<%=mode%>' >	 
				<input type='hidden' name='orInstall' id='orInstall' value="<%=orInstall%>" >	
	

				<tr>
		 		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.QueueManagement.label" bundle="${common_labels}"/></td>
		        </tr>
				<tr>
					 <td colspan=4 class='label' height=5></td>
				 </tr>
				 <tr>
					  <td class='label' colspan='1' ><fmt:message key="Common.RefreshInterval.label" bundle="${common_labels}"/></td>
					  <td class='fields' colspan='1' ><input type='text' name='queue_refresh_intervel' id='queue_refresh_intervel' value='<%=queue_refresh_intervel%>' maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);checkRefreshRange(this)'> <img src='../../eCommon/images/mandatory.gif' ></img><fmt:message key="Common.MIN.label" bundle="${common_labels}"/></td>
					  <td class='label' nowrap colspan='1'> <fmt:message key="eAE.InvokeVitalSignsfromQueue.label" bundle="${ae_labels}"/></td>
					  <td class='fields' colspan='1'><input type='checkbox' name='record_vital_signs' id='record_vital_signs' value='<%=record_vital_signs_yn%>' <%=checkBoxRecord%> onclick='chkValue(this);'>
			          </td> 	
				</tr>
				<tr>
				<td class='label'colspan='1'>&nbsp;</td>
				<td class='label'colspan='1'>&nbsp;</td>
				<td class='label' nowrapcolspan='1'> <fmt:message key="eAE.EnableAccess.label" bundle="${ae_labels}"/></td>
				 <td class='fields' colspan='1' >
                         <input type='checkbox' name='enable_accs_rights_in_queue' id='enable_accs_rights_in_queue' value='<%=enable_accs_rights_in_queue%>' <%=checkBoxRecord1%> onclick='chkValue(this);'></td>
				</tr>
			 		<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>' >
			 		<input type='hidden' name='locale' id='locale' value='<%=locale%>' >

				 <tr>
					  <td class='label' colspan='1' ><fmt:message key="eAE.ObservationWardType.label" bundle="${ae_labels}"/> </td>
					  <td class='fields' colspan='1' ><select name='observation_ward_type' id='observation_ward_type' onchange='call_observation_ward(this)'>
					   <%
			  if(observation_ward_type_code.equals(""))
			   {
		      %>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
				<option value="T"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
		      <%
			   }
			  else if(observation_ward_type_code.equals("C"))
			  {
		      %>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<option value="C" selected><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
				<option value="T"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
		      <%
			   }
			else if(observation_ward_type_code.equals("N"))
			  {
		      %>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<option value="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
				<option value="N" selected><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
				<option value="T"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
             <%
			  }
			else if(observation_ward_type_code.equals("T"))
			 {
		     %>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<option value="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
				<option value="T" selected><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
            <%
			 }
			 %> </select>
					  </td>
			 		  <td class='label' nowrap colspan='1'><fmt:message key="Common.Observation.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Ward.label" bundle="${common_labels}"/> </td>
					 <td class='fields' colspan='1' ><input type=text name="nursing_unit_desc" id="nursing_unit_desc" size=15 maxlength='15'value="<%=nursing_unit_desc%>" onblur="beforeLookup(this);"<%=dis_desc%> ><input type=hidden  name="nursing_unit" id="nursing_unit" size=15 value="<%=nursing_unit%>" ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="Lookup(document.forms[0].nursing_unit,document.forms[0].nursing_unit_desc);"<%=dis_lookup%>>
                       <img src='../../eCommon/images/mandatory.gif' align='center' name='mand_nursing' <%=hide_mand%>></img>&nbsp; <input type=hidden  name="nursing_clinic_code" id="nursing_clinic_code" size=15 value="<%=nursing_clinic_code_ae%>" >
		          </td>
				</tr>
				

			    <tr>
					  <td colspan=4 class='label' height=5></td>
				</tr>
				<!-- MMS-QH-CRF-0126.2 [IN:042931] Strat -->	
				 <tr>
					  <td class='label' colspan='1' ><fmt:message key="eOP.ActionUnsettledorUnbilledAmountfortheEncounter.label" bundle="${op_labels}"/> </td>
					  <td class='fields' colspan='1' >
 							<select name='action_on_pending_bill' id='action_on_pending_bill'>
								<option value='N' <%=selNoAction%>>No Action</option>					
								<option value='W' <%=selWarning%> >Warning</option>
								<option value='S' <%=selStop%> >Stop</option>
							</select>
					  </td>
					  <!--below line added for this CRF MMS-QH-CRF-0146 [IN:043836] -->
					  <td class='label' colspan='1' style='<%=leveloftriage_visibility%>'><fmt:message key="eAE.LevelsOfTriageApplicable.label" bundle="${ae_labels}"/> </td>
					  <td class='fields' colspan='1' style='<%=leveloftriage_visibility%>'><input type='checkbox' name='five_level_triage_appl' id='five_level_triage_appl' value='<%=five_level_triage_appl_yn%>' <%=leveltriage_checkbox%>  <%=leveltriage_checkbox_disable%>></td></td>
					  <input type="hidden" name="five_level_triage_appl_yn" id="five_level_triage_appl_yn" value="<%=five_level_triage_appl_yn%>">
					  <!--End MMS-QH-CRF-0146 [IN:043836] -->
				</tr>
				 <tr>
					  <td colspan=4 class='label' height=5></td>
				</tr>
					<tr>
				<td class='label' colspan='1'> <fmt:message key="eAE.InvokeRegisterNewBorn.label" bundle="${ae_labels}"/></td>
				 <td class='fields' colspan='1' >
                         <input type='checkbox' name='inv_reg_new_born_yn' id='inv_reg_new_born_yn' value= '<%=inv_reg_new_born_yn%>'<%=chk_inv_reg_new_born_yn%> onclick='chkValue(this);'></td>
				</tr>	 
				
				 <tr>
					  <td colspan=4 class='label' height=5></td>
				</tr>
				<!--  MMS-QH-CRF-0126.2 [IN:042931] End	 -->
	
				  <tr>
		 			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.DisasterManag.label" bundle="${ae_labels}"/> </td>
		        </tr>
             <tr>
					  <td colspan=4 class='label' height=5></td>
				</tr>
				<tr>

				  <td class='label' colspan='1'><fmt:message key="Common.Location.label" bundle="${common_labels}"/> &nbsp;</td>
					 <td class='fields' colspan='1'	>
					 <select name='clinic_code' id='clinic_code' onchange="populateVisitType(this);populateService(this)" ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
            <%	
				try {					  
				   pstmt = con.prepareStatement(sqlLocation.toString());
				   pstmt.setString(1,facilityId);
				   //pstmt.setString(2,operstn);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   int counter = 1; 
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);
						if(clinic_code.equals(code))	
			            {
							location_prop				=	"selected";
						}
						else
						{
							location_prop				=	"";
						}
  						if(counter==1){ counter=0;}
            %>
			<option value='<%=code%>' <%=location_prop%>> <%=desc%></option>
            <%
				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
				if((sqlLocation != null) && (sqlLocation.length() > 0))
				 {
					sqlLocation.delete(0,sqlLocation.length());
				 }

			    }catch (Exception e){}
				finally {
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
				}
            %>
			</select></td>
	<!--Below line added for this CRF ML-MMOH-CRF-0466-->			
	 <td class='label'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;</td>
	 <td class='fields'>
	 <% 
	  try{
	           sqlbuf.append("select pat_ser_grp_code, short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"'  and  gen_pat_id_yn = 'Y' and gen_pid_using_alt_id1_rule_yn = 'N' and id_type in ('E', 'U','G','N') and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where  site_or_facility_id = decode(site_or_facility,'S',?,'F',?) and used_status = 'N' ))  "+userAccessSql+" order by 2");
				
			
				
                        pstmt2 = con.prepareStatement(sqlbuf.toString());					
						pstmt2.setString(1,Site);
						pstmt2.setString(2,facilityId);
                        rset1 = pstmt2.executeQuery( );
                        out.println("<select name='dist_pat_ser_grp' id='dist_pat_ser_grp'>");
						out.println( "<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----</Option>" ) ;  
						if(rset1 !=null)  {
							while(rset1.next())  {
								String selval ="" ;
								String pat_series_code=rset1.getString(1) == null ? "" :rset1.getString(1);								
                                if(dist_pat_series_code.equals(pat_series_code))
								selval = "selected" ;	
								
                                out.println( "<Option value=\""+pat_series_code+"\" "+selval+">"+rset1.getString(2)+"</Option>" ) ;
                            }
                         }
						out.println("</select>");
						
					if(rset1!=null) rset1.close();										
					if(pstmt2!=null) pstmt2.close();
					sqlbuf.setLength(0);			
					
                }catch(Exception e) {e.printStackTrace();}%>
	       </td>		
		</tr>
		<!--End ML-MMOH-CRF-0466 -->

			<tr>
		<td class='label' colspan='1'><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>
			 <td class='fields' colspan='1'><select name='service_code' id='service_code' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</option> 
			<%
				if((!clinic_code.equals("")))
				{
				  try {
				   pstmt = con.prepareStatement(sqlService.toString());
				   pstmt.setString(1,facilityId);
				   pstmt.setString(2,clinic_code);
				   pstmt.setString(3,facilityId);
				   pstmt.setString(4,clinic_code);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);
						if(service_code.equals(code))	
			            {
							service_prop				=	"selected";
						}
						else
						{
							service_prop				=	"";
						}
            %>
			<option value='<%=code%>' <%=service_prop%>> <%=desc%></option>
            <%
				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
			    }catch (Exception e){}
				if((sqlService != null) && (sqlService.length() > 0))
				 {
					sqlService.delete(0,sqlService.length());
				 }
			}
			%>
			</select>
		</td>
		</tr>
		<tr>
			<td class='label' colspan='1'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='fields'colspan='1'><select name='visit_type' id='visit_type' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</option>
			<%
			if((!clinic_code.equals("")))
				{
				  try {
				   pstmt = con.prepareStatement(sqlVisitType.toString());
				   pstmt.setString(1,clinic_code);
				   pstmt.setString(2,facilityId);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);
						if(visit_type.equals(code))	
			            {
							visitType_prop				=	"selected";
						}
						else
						{
							visitType_prop				=	"";
						}
            %>
			<option value='<%=code%>' <%=visitType_prop%>> <%=desc%></option>
            <%
				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
			    }catch (Exception e){}
				if((sqlVisitType != null) && (sqlVisitType.length() > 0))
				 {
					sqlVisitType.delete(0,sqlService.length());
				 }
			}
			%>
			</select>
			</td>
		</tr>
		<tr>
		  <td class='label' colspan='1' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/> </td>
					  <td class='fields' colspan='1' ><select name='priority_zone_area' id='priority_zone_area'>
					    <option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
			 
			 
			 <!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
			 <% if(pry_zone_for_dis_regn.equals("")  || ! pry_zone_for_dis_regn.equals("") ){
				 
			 
				 
			   sql_1   ="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' ";
				if(!five_level_triage_appl_yn.equals("Y")){
					sql_1	= sql_1 + "  and priority_zone not in ('B','W') ";
				}
				sql_1= sql_1 + " order by PRIORITY_ZONE_ORDER asc"; 
			    pstmt   = con.prepareStatement(sql_1.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{ 
			   out.println("<option value='"+rset.getString(1)+"'>");	     
			   out.println(rset.getString(2));
			   out.println("</option>"); 
			   
			   
			   }}%>
		     </select>
			<!--CRF  SKR-CRF-0021 [IN028173] end-->
					  </td>
		</tr>
		<tr>
		 <td class='label' colspan='1'><fmt:message key="eAE.DefUnknownAdultAge.label" bundle="${ae_labels}"/></td>
					  <td class='fields' colspan='1' ><input type='text' name='unknown_adult_age_for_dis_regn' id='unknown_adult_age_for_dis_regn' value='<%=un_adult_age_for_dis_regn%>' maxLength='3' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);checkdefaultRangeg(this)'> &nbsp;<fmt:message key="Common.Years.label" bundle="${common_labels}"/>
		</tr>

			 </table> 
	 
	 
	 
	 <script>
	 /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	  var pry_zone_for_dis_regn ="<%=pry_zone_for_dis_regn%>";
	  if (pry_zone_for_dis_regn !=""){  
		 var drop_down = document.forms[0].priority_zone_area;
		 for (var i = 0; i < drop_down.options.length; i++){
		   if (drop_down.options[i].value == pry_zone_for_dis_regn){
		    drop_down.selectedIndex = i;}}}	
	 /* CRF  SKR-CRF-0021 [IN028173] end  */
	</script>
	<input type='hidden' name='isStartConsultationAppl' id='isStartConsultationAppl' value='<%=isStartConsultationAppl%>'><!--Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623-->
	<input type='hidden' name='isAERegisterTypeAutoUpdateAppl' id='isAERegisterTypeAutoUpdateAppl' value='<%=isAERegisterTypeAutoUpdateAppl%>'>
	

	 </form>
			<input type='hidden' name='max_age_for_paed_dtl' id='max_age_for_paed_dtl' value='<%=max_age_for_paed_dtl%>' >	

	<script>
		loadVisit(document.parameter_form.visit_backdating_allowed_yn);
		/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
		if(document.forms[0].back_date_cons_yn){
			if(document.forms[0].back_date_cons_yn.checked==true)
				document.getElementById('cons_bkdatng_img').style.visibility='visible';
			else
				document.getElementById('cons_bkdatng_img').style.visibility='hidden';
		}
		/*End*/
	</script>
  </body>
	
<% 

if(stmt!=null) stmt.close();
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close();

} catch(Exception e){ e.printStackTrace();}
   finally
    {
    	if(con!=null)
	    ConnectionManager.returnConnection(con,request);
    }
%>

</html>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
	}
%>

