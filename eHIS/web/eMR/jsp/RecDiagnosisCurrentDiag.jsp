<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue%> 
<%@ include file="RecDiagnosisGetValidation.jsp"%>
<html>
<%	
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
%>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../js/RecDiagnosisMain.js' language='javascript'></script>
<script src='../js/RecDiagnosis.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale				= (String)session.getAttribute("LOCALE");
		String Patient_Id			= checkForNull(request.getParameter("Patient_Id"));
		String Encounter_Id			= checkForNull(request.getParameter("Encounter_Id"));		
		String cause_of_death		= checkForNull(request.getParameter("cause_of_death"));		
		String operating_facility_id= (String) session.getValue("facility_id");
		String patient_class        = checkForNull(request.getParameter("patient_class"));
		String age					= checkForNull(request.getParameter("Age"));	
		String dob					= checkForNull(request.getParameter("Dob"));	
		String Locn_Code            = checkForNull(request.getParameter("Locn_Code"));			
		String Locn_Type            = checkForNull(request.getParameter("Locn_Type"));

		String Practitioner_Id		= checkForNull(request.getParameter("Practitioner_Id"));	
		String relationship_id		= checkForNull(request.getParameter("relationship_id"));
		String sex					= checkForNull(request.getParameter("Sex"));
		String modal_yn				= checkForNull(request.getParameter("modal_yn"));
		String classValue			= "";
		String called_from_ip		= checkForNull(request.getParameter("called_from_ip"));

		String practitioner_type	= checkForNull(request.getParameter("practitioner_type"));
		if(practitioner_type.equals(""))	
			practitioner_type		= checkForNull((String)session.getValue("practitioner_type"));

		String option_id			= checkForNull(request.getParameter("option_id"));
		String accession_number     = checkForNull(request.getParameter("accession_num"));
		String oh_chart_num			= checkForNull(request.getParameter("oh_chart_num"));
		String f_authorize_yn		= checkForNull(request.getParameter("f_authorize_yn"));
		String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget"));	//CHL-CRF- 0008 - IN:001472
		String headerVal = checkForNull(request.getParameter("headerVal")); // Added by mujafar for ML-BRU-CRF-0524
		String function_id = checkForNull(request.getParameter("function_id")); // Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
				
		
		
		Connection con				= null;	
		PreparedStatement stmt		= null;
		PreparedStatement stmt1		= null;
		PreparedStatement stmt2		= null;
		PreparedStatement pstmt		= null; 
		ResultSet res				= null;		
		ResultSet rs				= null;		
		ResultSet rset2				= null;		
		ResultSet rs1				= null;		
		Statement st				= null;
		ResultSet rset				= null;

		String Support_exisist_yn_YN= "";
		String accur_code_ind		= ""; 
		String accuracy_short_desc  = "";
		int encounter_id1		= 0;	
		String occur_srl_no			= "";
		String onset_date			= "";
		String onset_date_converted	= "";
		String onset_nature			= "";	
		String onset_status			= "";	
		String short_desc			= "";
		String actual_short_desc		= ""; // included for the SCF - SRR20056-scf-8582 
		String term_code			= ""; 		
		String term_set_desc		= "";
		String term_set_id			= "";	
		String encounter_stage		= "";
		String old_encounter_id		= "";
		String curr_practitioner_id = "";
		String curr_practitioner_name= "";
		StringBuffer associate_codes = new StringBuffer();
		String anatomical_site		= "" ;
		String applicable_side		= "" ;
		String pat_accession_num	= "";
		String diag_classification	= "";
		String notifiable_code="";//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
		String diag_classification_display	= "";
		String recordedDate			= "";
		String recordedDateDisp		= "";
		String dagger_independent_yn		= "";// Added For SRR-CRF-303.2
		String disp_dagger_dep_ind			= "";// Added For SRR-CRF-303.2
		
		String called_from_ot=checkForNull(request.getParameter("called_from_ot")); //this line Added for this CRF [PMG2012-CRF-0030]
		//Maheshwaran K added for SKR-SCF-0839 [IN:044168] as on 11/10/2013
		//Start
		String encounter_stage_str="";
		String nature_str="";
		String curr_onset_type="";
		String severity_str="";
		String curr_enc_diag_class="";
		String diag_category_code = "";
		
		String diagnosis_remark	= ""; //added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023
		
		//End
		//Added for this CRF Bru-HIMS-CRF-024.2
		String accession_num_work_related="",accession_num_notifiable="", accession_num_notifiable_display="";
		String notifiable_form_mand_yn="N"; 
        HashMap ResultParamHashMap = new HashMap();	
		%>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='query_result_form' id='query_result_form' action='../../servlet/eMR.RecDiagnosisServlet' method='post' target='messageFrame'>
	<div>
	<table border='1' width='100%' id='dataTable' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff">
<%
	try
	{

		String Diff_status			= "";
		String curr_accuracy_code	= "";
		String nature				= "";
		String natureLangDesc		= "";
		String not_curr_enc			= "S";
		String notifiable_yn		= "";
		String sensitive_yn			= "";
		String prev_term_set_id		= "";
		String priority				= "";
		String priorityclass		= "";
		String status					= "";
		String status_lbl			= "";
		String isCurrentEncounter	= "N";

		String complaint_id			= "";
		String complaint_desc		= "";
		String remarks				= "";
		String onset_datetime_str	= "";
		String complaint_date		= "";
        String comp_added_by		= "";
        String severity				= "";
        String term_code_disply		= "";
        String diag_class_code		= "";
        String curr_status			= "";
		String diag_category 		= ""; //Added by Ajay for TH-KW-CRF-165.1
		String term_code_status="";
		int view_cnt=0;
		String linkviewcnt_sql = "";
		String preoperative=""; //Added this line for this CRF [PMG2012-CRF-0030]
		//String diag_enc_level_yn="N";//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
		
		//Below line added for this SCF TTM-SCF-0167-904499 [IN:061028]
		String diag_enc_level_yn="N";

        con=ConnectionManager.getConnection(request);

		Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TYPES_OF_NOTIFICATION_FORM"); //Added by Sangeetha for ML-MMOH-CRF-0547

		Boolean notifiableLegndChgApplYn =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","NOTIFIABLE_LEGEND_CHG"); //Added by Dharma
		
		Boolean isMultiDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281

		Boolean termCodeEffStatus =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CHK_TERM_CODE_EFF_STATUS"); //Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
		
		Boolean isDiagCatgMand  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MR_DIAG_CATEGORY_MAND"); //Added by Ajay for TH-KW-CRF-165.1
		
		
		String asc_desc	=	(request.getParameter("asc_desc")==null)? " desc" : request.getParameter("asc_desc"); // Added by mujafar for ML-BRU-CRF-0524
		
		Boolean diagRevokeStatus  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MR_DIAG_REVOKED_STATUS"); //Added by Maheshwaran K for MMS-DM-SCF-0867
		
		//	Boolean IsDiagRemark  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DIAG_REMARKS"); //<!-- added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started-->
		
		Boolean isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");
		
		/*Below line Added for this CRF Bru-HIMS-CRF-024.2*/
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("notifiable_form_mand_yn","S");		
		sqlColumns.put("enable_link_to_curr_enc_s","S");//Added by Ajay Hatwate for ML-MMOH-CRF-1741		
		sqlColumns.put("crs_chk_mand_flds_on_link_diag","S");//Added by Ajay Hatwate for ML-MMOH-CRF-1741		
		ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,"","mr_parameter",con);
		notifiable_form_mand_yn = (String) ResultParamHashMap.get("notifiable_form_mand_yn");		
		//End  Bru-HIMS-CRF-024.2	
		/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
		String diagClassMandYn		= "";		
		String crossChkMandFldsYn = checkForNull((String) ResultParamHashMap.get("crs_chk_mand_flds_on_link_diag"),"N");
		String enableLinktoCurrEncS = checkForNull((String) ResultParamHashMap.get("enable_link_to_curr_enc_s"),"N");
		//System.out.println(crossChkMandFldsYn + " crossChkMandFldsYn " +enableLinktoCurrEncS + " enableLinktoCurrEncS ");
		if(enableLinktoCurrEncS.equals("N")){
			not_curr_enc = "";
		}
		/* End of ML-MMOH-CRF-1741 */
		
		int k						= 0;
		StringBuffer strBuffer		= new StringBuffer();
		StringBuffer probBuffer		= new StringBuffer();
	
		if(strBuffer.length() > 0) strBuffer.delete(0,strBuffer.length());
		if(probBuffer.length() > 0) probBuffer.delete(0,probBuffer.length());
		
		//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
		//Start
		//Below line added for this SCF TTM-SCF-0167-904499 [IN:061028]
		try
		{
			stmt = con.prepareStatement("select diag_enc_level from mr_parameter");
			rs = stmt.executeQuery();
			if(rs!=null && rs.next())
			{
			diag_enc_level_yn=rs.getString("diag_enc_level")==null?"N":rs.getString("diag_enc_level");
			}
			if(rs!=null)		rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}	  	
		//End this SCF TTM-SCF-0167-904499 [IN:061028]
		
		//strBuffer.append("SELECT e.enc_stage,a.term_set_id, b.term_set_desc , a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn,c.short_desc,c.long_desc ");
		//strBuffer.append("SELECT  to_char(.ADDED_DATE,'dd/mm/yyyy hh24:mi') recordedDate,e.encounter_id old_encounter_id,e.enc_stage,a.term_set_id, mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1) term_set_desc , a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn");

		/*Below Query Modified for this CRF [PMG2012-CRF-0030]*/
		//Below query modified for this CRF Bru-HIMS-CRF-024.2
		//strBuffer.append("SELECT  to_char(e.recorded_date_time,'dd/mm/yyyy hh24:mi') recordedDate,e.encounter_id old_encounter_id,e.enc_stage,a.OT_PRE_OPER_DIAG_YN pre_operative, a.accession_num_work_related, a.accession_num_notifiable, a.term_set_id, mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1) term_set_desc , a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn");
		/*Modified the Query for ML-BRU-SCF-1655 as on 05/02/2016 */
		strBuffer.append("SELECT  NVL((select TO_CHAR (z.recorded_date_time, 'dd/mm/yyyy hh24:mi') FROM pr_diagnosis_enc_dtl z, pr_diagnosis y      WHERE z.facility_id = ?   AND  z.encounter_id = ?      AND z.term_set_id = e.term_set_id AND z.term_code = e.term_code AND z.occur_srl_no = e.occur_srl_no AND z.patient_id = y.patient_id AND z.term_set_id = y.term_set_id AND z.term_code = y.term_code AND z.occur_srl_no = y.occur_srl_no),to_char(e.recorded_date_time,'dd/mm/yyyy hh24:mi')) recordedDate ,");
		
		strBuffer.append(" e.encounter_id old_encounter_id,e.enc_stage,a.OT_PRE_OPER_DIAG_YN pre_operative, a.accession_num_work_related, a.accession_num_notifiable, a.term_set_id,a.curr_remarks, mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1) term_set_desc ,e.remarks, a.term_code,a.curr_accuracy_code,a.curr_accuracy_ind, c.notifiable_yn");
		
		
		//10/17/2008
		strBuffer.append(",c.sensitive_yn");
		//10/17/2008
		//Added by Ajay for TH-KW-CRF-165.1
		//Start
		if(isDiagCatgMand){
			strBuffer.append(",e.diag_catg diag_catg_code,(select short_desc from mr_diag_category where diag_catg_code = e.diag_catg ) diag_category");
		}//End of CRF TH-KW-CRF-165.1
		strBuffer.append(",mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2')short_desc,a.TERM_CODE_SHORT_DESC ");
		strBuffer.append("term_code_desc , (SELECT mr_get_desc.mr_accuracy(a.curr_accuracy_code,'"+locale+"','2')short_desc FROM MR_ACCURACY WHERE ");
		strBuffer.append(" accuracy_code =a.curr_accuracy_code) accuracy_short_desc,"); 

		/*11/4/2008 ICN 6224  MR_ACCURACY*/
		/*strBuffer.append(" (SELECT PRACTITIONER_NAME from AM_PRACTITIONER WHERE  ");
		strBuffer.append(" PRACTITIONER_ID='"+Practitioner_Id+"') practitioner_name, ");*/
		//strBuffer.append(" a.curr_practitioner_id, am_get_desc.am_practitioner(a.curr_practitioner_id,'"+locale+"','1') PRACTITIONER_NAME,");
			
		/*Modified the Query for ML-BRU-SCF-1655 as on 05/02/2016 */
		strBuffer.append(" a.curr_practitioner_id,NVL((select am_get_desc.am_practitioner(z.practitioner_id ,'"+locale+"','1')  FROM pr_diagnosis_enc_dtl z, pr_diagnosis y  WHERE z.facility_id = ?    AND z.encounter_id = ? AND z.term_set_id = e.term_set_id  AND z.term_code = e.term_code AND z.occur_srl_no =e.occur_srl_no AND z.patient_id = y.patient_id AND z.term_set_id = y.term_set_id AND z.term_code = y.term_code     AND z.occur_srl_no = y.occur_srl_no),am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"','1')) PRACTITIONER_NAME, " );
				
		//strBuffer.append(" a.MODIFIED_BY_ID, ");
		/*11/4/2008*/

		strBuffer.append("decode(a.curr_severity,'D','Moderate','L','Mild','S','Severe','E','Extreme')    severity, ");
		strBuffer.append("decode(a.curr_nature,'A','Actual','P','Potential','W','Wellness') ");
		//Maheshwaran K added curr_onset_type for SKR-SCF-0839 [IN:044168] as on 11/10/2013
		strBuffer.append("nature, TO_CHAR (a.onset_date,'dd/mm/yyyy') onset_date,to_number(to_char(a.onset_date,'YYYYMMDDHH24MISS')) onset_date1,a.curr_onset_type , ");  // Added by mujafar for ML-BRU-CRF-0524
		/*Thursday, March 18, 2010 , a.curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
		//strBuffer.append("a.curr_status ,decode(a.curr_status,'A','Active','R','Resolved','X','Revoked','E','In Error') status, a.curr_priority priority ,"); 
		//Maheshwaran K added for MMS-DM-SCF-0867
		if(diagRevokeStatus)
			{
			strBuffer.append("a.curr_status ,decode(a.curr_status,'A','Active','R','Resolved','E','In Error','X', decode(e.status, 'A', 'Active', 'R', 'Resolved','E', 'In Error')) status, a.curr_priority priority ,"); 	
			}
		else {
		strBuffer.append("a.curr_status ,decode(a.curr_status,'A','Active','R','Resolved','X','Revoked','E','In Error') status, a.curr_priority priority ,"); 	
		}	
	/*	strBuffer.append("NVL((select 'Y' from PR_DIAGNOSIS_STATUS ");
		strBuffer.append(" where patient_id =a.patient_id and term_set_id=a.term_set_id and"); 
		strBuffer.append(" term_code  =a.term_code and occur_srl_no =a.occur_srl_no  and "); 
		strBuffer.append(" facility_id=? and encounter_id=? and rownum=1),'N')");*/
		
		strBuffer.append(" (select count(*) from PR_DIAGNOSIS_ENC_DTL ");
		strBuffer.append(" where patient_id =a.patient_id and term_set_id=a.term_set_id and"); 
		strBuffer.append(" term_code  =a.term_code and occur_srl_no =a.occur_srl_no  and "); 
		strBuffer.append(" facility_id=? and encounter_id=?  and status in ('A','R')) curr_enc_yn ,");
		strBuffer.append("a.occur_srl_no,");
		strBuffer.append("NVL((select 'Y' from PR_SUPPORT_DIAGNOSIS where patient_id =a.patient_id "); 
		strBuffer.append(" and term_set_id=a.term_set_id and term_code  =a.term_code and ");
		strBuffer.append("occur_srl_no =a.occur_srl_no  and rownum=1),'N') support_exisist_yn_yn ");
		//<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->
		/*Thursday, March 18, 2010 , a.diag_class_code added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
		//Maheshwaran K modified the Query as on 12/09/2013
	 //	strBuffer.append(" , a.anatomical_site , a.applicable_side, a.accession_num ,(select mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')short_desc FROM MR_DIAG_CLASS WHERE diag_class_code = e.diag_class_code) diag_class_short_desc,e.diag_class_code,c.DAGGER_INDEPENDENT_YN,e.NOTIFICATION_CODE,(select  z.diag_class_code||'@|#$&*'||mr_get_desc.mr_diag_class(z.diag_class_code,'en','2')short_desc FROM pr_diagnosis_enc_dtl z   WHERE  z.facility_id='"+operating_facility_id+"' and z.encounter_id="+Encounter_Id+" and z.TERM_SET_ID=e.term_set_id and z.TERM_CODE=e.term_code and   z.OCCUR_SRL_NO=e.OCCUR_SRL_NO) curr_enc_diag_class ");
	 	strBuffer.append(" , a.anatomical_site , a.applicable_side, a.accession_num ,(select mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')short_desc FROM MR_DIAG_CLASS WHERE diag_class_code = e.diag_class_code) diag_class_short_desc,e.diag_class_code,c.DAGGER_INDEPENDENT_YN,(select i.notification_code  FROM pr_diagnosis_enc_dtl i,pr_diagnosis k  WHERE i.facility_id = '"+operating_facility_id+"' AND i.encounter_id =e.encounter_id AND i.term_set_id = e.term_set_id AND i.term_code = e.term_code AND i.occur_srl_no = e.occur_srl_no   AND i.patient_id = k.patient_id AND i.term_set_id = k.term_set_id AND i.term_code = k.term_code AND i.occur_srl_no = k.occur_srl_no ) notification_code,(select  CASE WHEN z.diag_class_code IS  NULL or  z.status='E' then y.diag_class_code ELSE z.diag_class_code                   END ||'@|#$&*'||mr_get_desc.mr_diag_class(CASE WHEN z.diag_class_code IS  NULL or  z.status='E' then y.diag_class_code   ELSE z.diag_class_code  END,'en','2')short_desc FROM pr_diagnosis_enc_dtl z  ,pr_diagnosis y  WHERE  z.facility_id='"+operating_facility_id+"' and z.encounter_id="+Encounter_Id+" and z.TERM_SET_ID=e.term_set_id and z.TERM_CODE=e.term_code and   z.OCCUR_SRL_NO=e.OCCUR_SRL_NO	and z.patient_id=y.patient_id  AND z.term_set_id = y.term_set_id AND z.term_code = y.term_code  AND z.occur_srl_no = y.occur_srl_no	) curr_enc_diag_class, ");
		//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
		strBuffer.append(" (SELECT f.eff_status FROM  MR_TERM_CODE f WHERE f.term_set_id = a.term_set_id AND f.term_code = a.term_code) term_code_status ");
		//Ends NMC-JD-SCF-0259
		/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
		strBuffer.append(", b.diagnosis_class_mand_yn ");
		/* end of ML-MMOH-CRF-1741 */
				
		//Maheshwaran K added "NOTIFICATION_CODE" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
		strBuffer.append(" FROM PR_DIAGNOSIS a , MR_TERM_SET b, MR_TERM_CODE c, PR_DIAGNOSIS_ENC_DTL e ");
		//10/17/2008
		//strBuffer.append(" ,mr_icd_code d ");
		//10/17/2008
		strBuffer.append(" WHERE a.patient_id = ? ");

		strBuffer.append(" and a.patient_id=e.patient_id and a.term_set_id=e.term_set_id and a.occur_srl_no=e.occur_srl_no and  a.term_code  =e.term_code  and a.CURR_ENCOUNTER_ID=e.encounter_id "); //CURR_ENCOUNTER_ID added by Suji Keerthi for PAS-IP- IP Transaction - Discharge - Prepare Discharge Advice - Discharge Diagnosis
		//Maheshwaran K has Removed Facility and onset facility ID condition for ML-BRU-SCF-2132 as on 20-12-2021
		//strBuffer.append("and a.onset_facility_id=e.facility_id ");
		//Ends
		//Below line added for this SCF TTM-SCF-0167-904499 [IN:061028]
		if(diag_enc_level_yn.equals("N"))
		     strBuffer.append(" and e.status!='E' ");	
		//End TTM-SCF-0167-904499 [IN:061028]
		
		//Added condition for limit to Code Set value
		strBuffer.append(" and exists (select 1 from MR_TERM_SET_FOR_FACILITY where facility_id=? and term_set_id=a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT_TYPE where pract_type=? and term_set_id=a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_SPECIALTY where specialty_code in (select specialty_code from PR_ENCOUNTER where facility_id=? and encounter_id=?) and term_set_id=a.term_set_id) and (exists (select 1 from MR_TERM_SET_FOR_PRACT ib  where practitioner_id=? and term_set_id=a.term_set_id)  or not exists (select 1 from MR_TERM_SET_FOR_PRACT where practitioner_id=?))");
		//Ended here
		/*strBuffer.append("and (a.curr_status ='A' or exists (select 1 from PR_DIAGNOSIS_STATUS ");
		strBuffer.append(" where patient_id =a.patient_id and term_set_id=a.term_set_id and "); 
		strBuffer.append(" term_code  =a. term_code and occur_srl_no =a.occur_srl_no and ");
		strBuffer.append(" facility_id=? and encounter_id=? and rownum=1))*///Commented for SCR 4807
		strBuffer.append(" and b.term_set_id(+) = a.term_set_id ");
		/*Added by Maheshwaran for the SKR-CRF-0020 as on 04/05/2012*/
		/*Start*/
		strBuffer.append(" and a.curr_status !='E' ");
		/*End*/
		strBuffer.append(" and c.term_set_id(+) =a.term_set_id and c.term_code(+)=a.term_code order by   ");
		
		
			//  Added by mujafar for ML-BRU-CRF-0524 start

				if(headerVal.equals("recDateTime"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  a.added_date desc ");
					else strBuffer.append("  a.added_date asc ");
				}
				else
					if(headerVal.equals("diagProb"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  a.term_code desc ");
					else strBuffer.append("  a.term_code asc ");
				} 
				else
					if(headerVal.equals("diagProbDesc"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  term_code_desc desc ");
					else strBuffer.append("  term_code_desc asc ");
				}
				else
					if(headerVal.equals("status"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  status desc ");
					else strBuffer.append("  status asc ");
				}
				else
					if(headerVal.equals("accuracy"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  accuracy_short_desc desc ");
					else strBuffer.append("  accuracy_short_desc asc ");
				} 
				else
					if(headerVal.equals("onsetDate"))
				{
					if(asc_desc.equals(" desc"))strBuffer.append("  onset_date1 desc ");
					else strBuffer.append("  onset_date1 asc ");
				}
				else
				{
					strBuffer.append("  a.added_date desc ");
				}
				//  Added by mujafar for ML-BRU-CRF-0524 end
		
		

	
		stmt = con.prepareStatement(strBuffer.toString());
		stmt.setString(1,operating_facility_id);
		stmt.setString(2,Encounter_Id);
		stmt.setString(3,operating_facility_id);
		stmt.setString(4,Encounter_Id);
		stmt.setString(5,operating_facility_id);
		stmt.setString(6,Encounter_Id);
		stmt.setString(7,Patient_Id);
		stmt.setString(8,operating_facility_id);
		stmt.setString(9,practitioner_type);
		stmt.setString(10,operating_facility_id);
		stmt.setString(11,Encounter_Id);
		stmt.setString(12,Practitioner_Id);
		stmt.setString(13,Practitioner_Id);
		//ended here
		//stmt.setString(9,operating_facility_id);
		//stmt.setString(10,Encounter_Id);//Commented for SCR 4807
		rs = stmt.executeQuery();
		probBuffer.append("select a.complaint_id, complaint_desc, a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy') onset_datetime_str, am_get_desc.am_practitioner(a.added_by_id,?,'1') added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date, (SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE COMPLAINT_ID =a.complaint_id AND  ENCOUNTER_ID=? AND  FACILITY_ID=?) compl_count from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id=? order by a.added_date desc");
				
		stmt1 = con.prepareStatement(probBuffer.toString());
		stmt1.setString(1,locale);
		stmt1.setString(2,Encounter_Id);
		stmt1.setString(3,operating_facility_id);
		stmt1.setString(4,operating_facility_id);
		stmt1.setString(5,Encounter_Id);
		rs1 = stmt1.executeQuery();
		%>
		
		<tr>
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'><font size=1 >&nbsp;</font></th>
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'><font size=1 >&nbsp;</font></th>
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'><font size=1 >&nbsp;</font></th>
				<!-- <td align='center'  nowrap><font size=1 align='top'><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></font></td>
				 -->
				<th style="border-bottom: 1px solid black;" align='center'   nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.Set.label" bundle="${common_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<th style="border-bottom: 1px solid black;" align='center'   onclick ="sort('diagProb','<%=asc_desc%>','<%=practitioner_type%>','<%=Patient_Id%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=patient_class%>','<%=age%>','<%=dob%>','<%=Locn_Code%>','<%=Locn_Type%>','<%=Practitioner_Id%>','<%=relationship_id%>','<%=sex%>','<%=modal_yn%>','<%=called_from_ip%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=f_authorize_yn%>','<%=p_called_from_widget%>','<%=called_from_ot%>');" style='cursor:pointer'    wrap class='CAGROUPHEADING'><font size=1 align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>/<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font>
				<img src=''  border=none  align=right name='diagprobGif' style='visibility:hidden'>
				</th>
				<th style="border-bottom: 1px solid black;" align='center'     onclick ="sort('diagProbDesc','<%=asc_desc%>','<%=practitioner_type%>','<%=Patient_Id%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=patient_class%>','<%=age%>','<%=dob%>','<%=Locn_Code%>','<%=Locn_Type%>','<%=Practitioner_Id%>','<%=relationship_id%>','<%=sex%>','<%=modal_yn%>','<%=called_from_ip%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=f_authorize_yn%>','<%=p_called_from_widget%>','<%=called_from_ot%>');" style='cursor:pointer'   nowrap class='CAGROUPHEADING'><font size=1 align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>/<fmt:message key="Common.Problem.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></font>
				<img src=''  border=none  align=right name='diagprobdescGif' style='visibility:hidden'>
				</th>
				<!--Below line added for this CRF Bru-HIMS-CRF-024.2-->
				<th style="border-bottom: 1px solid black;" align='center' nowrap   class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.view.label" bundle="${common_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<!--End Bru-HIMS-CRF-024.2 -->				
				<!--Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012
				//Start-->
				<th style="border-bottom: 1px solid black;" align='center'    onclick ="sort('status','<%=asc_desc%>','<%=practitioner_type%>','<%=Patient_Id%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=patient_class%>','<%=age%>','<%=dob%>','<%=Locn_Code%>','<%=Locn_Type%>','<%=Practitioner_Id%>','<%=relationship_id%>','<%=sex%>','<%=modal_yn%>','<%=called_from_ip%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=f_authorize_yn%>','<%=p_called_from_widget%>','<%=called_from_ot%>');" style='cursor:pointer'   nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.status.label" bundle="${common_labels}"/></font>
				<img src=''  border=none  align=right name='statusGif' style='visibility:hidden'>
				</th>
				<!--End-->
				
				<!--added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started-->
				
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'>  <font size=1><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/><br><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				
				<!--added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 End-->
				
				
				
				<th style="border-bottom: 1px solid black;" align='center'   nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="eMR.PreOpreative.label" bundle="${mr_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th> <!--this line Added for this CRF [PMG2012-CRF-0030] -->
				<th style="border-bottom: 1px solid black;" color='red' align='center'   nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="eMR.ApplicableSide.label" bundle="${mr_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<th style="border-bottom: 1px solid black;" color='red' align='center'    nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message			key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<!-- Added by Ajay for TH-KW-CRF-165.1  -->
				<%if(isDiagCatgMand){%>
				<th style="border-bottom: 1px solid black;" color='red' align='center'    nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="eMR.DiagnosisCategory.label" bundle="${mr_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<%}%>
				<!-- End of CRF TH-KW-CRF-165.1 -->
				<th style="border-bottom: 1px solid black;" color='red' align='center'   nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<th style="border-bottom: 1px solid black;" color='red' align='center'     onclick ="sort('recDateTime','<%=asc_desc%>','<%=practitioner_type%>','<%=Patient_Id%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=patient_class%>','<%=age%>','<%=dob%>','<%=Locn_Code%>','<%=Locn_Type%>','<%=Practitioner_Id%>','<%=relationship_id%>','<%=sex%>','<%=modal_yn%>','<%=called_from_ip%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=f_authorize_yn%>','<%=p_called_from_widget%>','<%=called_from_ot%>');" style='cursor:pointer'   nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.and.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.time.label" bundle="${common_labels}"/> </font>			
				<img src=''  border=none  align=right name='recordeddateGif' style='visibility:hidden'>
				</th>
				<th style="border-bottom: 1px solid black;" color='red' align='center'    onclick ="sort('accuracy','<%=asc_desc%>','<%=practitioner_type%>','<%=Patient_Id%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=patient_class%>','<%=age%>','<%=dob%>','<%=Locn_Code%>','<%=Locn_Type%>','<%=Practitioner_Id%>','<%=relationship_id%>','<%=sex%>','<%=modal_yn%>','<%=called_from_ip%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=f_authorize_yn%>','<%=p_called_from_widget%>','<%=called_from_ot%>');" style='cursor:pointer'  nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></font>
				<img src=''  border=none  align=right name='accuracyGif' style='visibility:hidden'>
				</th>
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'   ><font size=1 ><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'   ><font size=1 ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'   ><font size=1 ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
				<th style="border-bottom: 1px solid black;" align='center'   onclick ="sort('onsetDate','<%=asc_desc%>','<%=practitioner_type%>','<%=Patient_Id%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=patient_class%>','<%=age%>','<%=dob%>','<%=Locn_Code%>','<%=Locn_Type%>','<%=Practitioner_Id%>','<%=relationship_id%>','<%=sex%>','<%=modal_yn%>','<%=called_from_ip%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=f_authorize_yn%>','<%=p_called_from_widget%>','<%=called_from_ot%>');" style='cursor:pointer'  nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></font>
				<img src=''  border=none  align=right name='onsetDateGif' style='visibility:hidden'>
				</th>
				<!--Maheshwaran K has commented this code for SKR-CRF-0020 as on 10/07/2013-->
				<!--<td align='center' nowrap class='CAGROUPHEADING'><font size=1 ><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></td>-->
				<th style="border-bottom: 1px solid black;" align='center' nowrap class='CAGROUPHEADING'   ><font size=1 ><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></font><img src=''  border=none  align=right  style='visibility:hidden'></th>
		</tr>
		
		<%

					 
		while(rs1.next())
		{
			 complaint_id		= checkForNull(rs1.getString("complaint_id"));
			 complaint_desc		= checkForNull(rs1.getString("complaint_desc"));
			 remarks			= checkForNull(rs1.getString("remarks"));
			 onset_datetime_str = checkForNull(rs1.getString("onset_datetime_str"));
			 onset_datetime_str =DateUtils.convertDate(onset_datetime_str,"DMY","en",locale);
			 complaint_date		= checkForNull(rs1.getString("added_date"));
			 complaint_date     =DateUtils.convertDate(complaint_date,"DMYHM","en",locale);

			 comp_added_by		= checkForNull(rs1.getString("added_by_id"));


			
			
			//block commented. below query merged with the main query to get count of complaint.. for PE

			//String complaint_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE COMPLAINT_ID ='"+complaint_id+"' AND  ENCOUNTER_ID='"+Encounter_Id+"' AND  FACILITY_ID='"+operating_facility_id+"'";
			//st = con.createStatement();
			//rset = st.executeQuery(complaint_sql);
			//if(rset != null && rset.next()){

			// end block comment

				if(rs1.getInt("compl_count") == 0){

						if ( k%2 == 0 )
							 classValue = "QRYEVEN" ;
			            else
						    classValue = "QRYODD" ;

			

					out.println("<tr><td class='"+classValue+"'  nowrap>&nbsp;</td>");
					//Added by Jeyachitra - ML-MMOH-CRF 1742
					if(isDeceasedDiagClassDeathRegAppl){
					out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>"); 
					}
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><img src='../../eCommon/images/Problems.gif'>&nbsp;<font size='1'>"+complaint_id+"</font></td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+complaint_desc+"</font>&nbsp;</td>");
					/*Below line added for this CRF Bru-HIMS-CRF-024.2*/
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					/*End  Bru-HIMS-CRF-024.2*/
					//Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012
					//Start
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					//End
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+comp_added_by+"</font>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+complaint_date+"</font>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+onset_datetime_str+"</font>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td>");
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;</td></tr>");
					k++;

				}

			//}
				//if(rset != null )rset.close();
		}

				

		while(rs.next())
		{
			//11/13/2008 code add for dispaly recorded Date and time.
			recordedDate			= checkForNull(rs.getString("recordedDate"));
			if(!(recordedDate==null || recordedDate.equals("")))
				recordedDateDisp	=	DateUtils.convertDate(recordedDate,"DMYHM","en",localeName);

			term_set_desc			= checkForNull(rs.getString("TERM_SET_DESC"));
			encounter_id1			= rs.getInt("CURR_ENC_YN");
			accur_code_ind		= checkForNull(rs.getString("curr_accuracy_ind"));
			old_encounter_id		= checkForNull(rs.getString("old_encounter_id"));		
			curr_accuracy_code	= checkForNull(rs.getString("curr_accuracy_code"));
			priority						= checkForNull(rs.getString("priority"));
			notifiable_yn				= checkForNull(rs.getString("notifiable_yn"));
			sensitive_yn				= checkForNull(rs.getString("sensitive_yn"));
			curr_practitioner_name      = checkForNull(rs.getString("PRACTITIONER_NAME"));
			term_code_status				= checkForNull(rs.getString("term_code_status"));
			if(isDiagCatgMand){
			diag_category					= checkForNull(rs.getString("diag_category"));//Added by Ajay for TH-KW-CRF-165.1
			diag_category_code					= checkForNull(rs.getString("diag_catg_code"));//Added by Ajay for TH-KW-CRF-165.1
			}
			if(priority.equals("C")) priorityclass = "RED";
			else if(priority.equals("H")) priorityclass = "YELLOW";
			else if(priority.equals("N")) priorityclass = "GREEN";

			//practitioner_name = checkForNull(rs.getString("practitioner_name"));
			/*11/4/2008 ICN 6224  */
			//curr_practitioner_id = checkForNull(rs.getString("MODIFIED_BY_ID"));
			
			//block commented. below query merged with the main query to get pract name.. for PE
			/*  
				curr_practitioner_id	= checkForNull(rs.getString("curr_practitioner_id"));
			String curr_practitioner_sql = "select am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME from am_practitioner where PRACTITIONER_ID='"+curr_practitioner_id+"'";
			st = con.createStatement();
			rset = st.executeQuery(curr_practitioner_sql.toString());
			if(rset != null && rset.next())
			{
				curr_practitioner_name = rset.getString("PRACTITIONER_NAME");
			}
			if(rset != null )rset.close();
			*/
			// end block comment for PE
			
			/*11/4/2008 end*/
			if(!sensitive_yn.equals("Y"))
			{
			if(!prev_term_set_id.equals(term_set_desc))
			{
	
	%>
			<!-- <tr>
				<td colspan='12' class='CAGROUPHEADING' align='left'><font size=1><b><%=term_set_desc%></b></font></td>
			</tr>	 -->
	<%
			}
			prev_term_set_id = term_set_desc;
			if ( k%2 == 0 ){
                classValue = "QRYEVEN" ;
			}else{
                classValue = "QRYODD" ;
			}
//			short_desc					= checkForNull(rs.getString("term_code_desc"));
			term_code					= checkForNull(rs.getString("term_code"));
			term_code_disply			= term_code ;
			diagnosis_remark            = checkForNull(rs.getString("curr_remarks")); //added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 and curr_remarks is added to query by Himanshu
			
			if(term_code.equals("*OTH")){
					short_desc = checkForNull(rs.getString("term_code_desc"));
			}else{
					short_desc = checkForNull(rs.getString("short_desc"));
			}
			if(short_desc.equals("")){ 
				short_desc="&nbsp;";
			}
			//if(term_code.equals("*OTH"))
				//term_code_disply        = "" ;
			accuracy_short_desc	= checkForNull(rs.getString("accuracy_short_desc"));
			onset_nature					= checkForNull(rs.getString("nature"));
			severity				= checkForNull(rs.getString("severity"));
			if(severity.equals("")) 
				severity="&nbsp;";
			nature						= onset_nature;
			if(!(nature==null || nature.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
				else if(nature.equals("Potential"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				else if(nature.equals("Wellness"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
			}
			if(natureLangDesc.equals("")) 
				natureLangDesc="&nbsp;";
			encounter_stage		= checkForNull(rs.getString("ENC_STAGE"));
			if(encounter_stage.equals("")) 
				encounter_stage="&nbsp;";

			if(!(encounter_stage==null || encounter_stage.equals("&nbsp;")))
			{
				if(encounter_stage.equals("A"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				else if(encounter_stage.equals("I"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				else if(encounter_stage.equals("D"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");	
			}
	
			if(nature.equals("")) 
				nature="&nbsp;";
			onset_date					=checkForNull(rs.getString("onset_date")); 
			curr_onset_type					=checkForNull(rs.getString("curr_onset_type"));//Maheshwaran K added for SKR-SCF-0839 [IN:044168] as on 11/10/2013
			if(!(onset_date==null || onset_date.equals("")))
				onset_date_converted	=	DateUtils.convertDate(onset_date,"DMY","en",localeName);

			onset_status					= checkForNull(rs.getString("status")); 
			status	=onset_status;
			//Maheshwaran K added for SKR-SCF-0839 [IN:044168] as on 11/10/2013
			//Start
			if(severity.equals("")) 
				severity_str="&nbsp;";
			if(!(severity==null || severity_str.equals("&nbsp;")))
			{
				if(severity.equals("Moderate"))
				severity_str="D";
				if(severity.equals("Mild"))
				severity_str="L";
				if(severity.equals("Severe"))
				severity_str="S";
				if(severity.equals("Extreme"))
				severity_str="E";
			}
			if(encounter_stage.equals("")) 
				encounter_stage_str="&nbsp;";
			if(!(encounter_stage==null || encounter_stage_str.equals("&nbsp;")))
			{
				if(encounter_stage.equals("Admission"))
				encounter_stage_str="A";
				if(encounter_stage.equals("Intermediate"))
				encounter_stage_str="I";
				if(encounter_stage.equals("Discharge"))
				encounter_stage_str="D";
			}
	
			if(nature.equals("")) 
				nature_str="&nbsp;";
			if(!(nature==null || nature_str.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
				nature_str = "A";
				if(nature.equals("Potential"))
				nature_str = "P";
				if(nature.equals("Wellness"))
				nature_str = "W";
			}
			//end
			if(status.equals("Active"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			else if(status.equals("Resolved"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
			else if(status.equals("Revoked"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels");
			else if(status.equals("In Error"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");

			occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));
				//11/13/2008 If the status is resolved and in error we are assign to blank as per spec.
			/*if(status.equals("Resolved")||status.equals("In Error")){
				recordedDate="&nbsp";
			}
			*/
			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status="(D)";
			else
				Diff_status="";*/
////start			

					term_set_id							= checkForNull(rs.getString("term_set_id")); // Added by mujafar for ML-MMOH-CRF-1281
				if(isMultiDescAppl && term_set_id.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				short_desc = checkForNull(rs.getString("term_code_desc"));



				actual_short_desc=short_desc;// included for the SCF - SRR20056-scf-8582 
				short_desc=short_desc.replaceAll("'","''");// included for the SCF - SRR20056-scf-8582 
				if(!term_code.equals("*OTH")){
					 linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND  TERM_CODE =? and OCCUR_SRL_NO=?";
					/*Wednesday, February 10, 2010 , OCCUR_SRL_NO added for SRR20056-SCF-4238 IN019107*/
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,term_code);
					stmt2.setString(4,occur_srl_no);
				}
				else
				{
					 linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO=?";
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,short_desc);
					stmt2.setString(4,occur_srl_no);
				}
			//st = con.createStatement();
			//rset = st.executeQuery(linkviewcnt_sql);
			rset2=stmt2.executeQuery();
			if(rset2 != null && rset2.next())
			{
				//if(rset.getInt(1) == 0)
				//{
					view_cnt=rset2.getInt(1);


				//}
			}
				////end

			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status			="<img src='../../eCommon/images/Differentials.gif'></img>";
			else
				Diff_status			="&nbsp;";*/

			/*
			term_set_id							= checkForNull(rs.getString("term_set_id")); commented and added above for ML-MMOH-CRF-1281
				if(isMultiDescAppl && term_set_id.equals("ICD10") )
				short_desc = checkForNull(rs.getString("term_code_desc"));
			*/
			
			preoperative= checkForNull(rs.getString("pre_operative"));// this line Added for this CRF  [PMG2012-CRF-0030]
			
			//Added for this CRF Bru-HIMS-CRF-024.2
			accession_num_work_related=checkForNull(rs.getString("accession_num_work_related"));
			accession_num_notifiable=checkForNull(rs.getString("accession_num_notifiable"));
			Support_exisist_yn_YN				= checkForNull(rs.getString("Support_exisist_yn_YN"));

			//if(encounter_id1.equals("Y"))
			if(encounter_id1>0)
				isCurrentEncounter				= "N";
			else
				isCurrentEncounter				= "Y";			
				anatomical_site					= checkForNull(rs.getString("anatomical_site"));
				applicable_side					= checkForNull(rs.getString("applicable_side"));
				pat_accession_num				= checkForNull(rs.getString("accession_num"));
				/*Thursday, March 18, 2010 ,added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
				diag_class_code					= checkForNull(rs.getString("diag_class_code"));
				curr_status						= checkForNull(rs.getString("curr_status"));
				notifiable_code						= checkForNull(rs.getString("NOTIFICATION_CODE"));//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
				/**/
				diag_classification				= checkForNull(rs.getString("diag_class_short_desc"));
				curr_enc_diag_class				= checkForNull(rs.getString("curr_enc_diag_class"));
				//term_code_status				= checkForNull(rs.getString("term_code_status"));

				//if(diag_enc_level_yn.equals("N")){
					if(curr_enc_diag_class.equals("@|#$&*")){
						diag_classification="";
						diag_class_code="";
					}else if(!curr_enc_diag_class.equals("")){
						
						int indx=curr_enc_diag_class.indexOf("@|#$&*");
						
						diag_class_code=curr_enc_diag_class.substring(0,indx);
						diag_classification=curr_enc_diag_class.substring(indx +6,curr_enc_diag_class.length());
					}
				//}
				dagger_independent_yn	= checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"));//Added For SRR-CRF-303.2
				diagClassMandYn	= checkForNull(rs.getString("diagnosis_class_mand_yn"));//Added by Ajay Hatwate for ML-MMOH-CRF-1741
			/*
				F.Y.I
				Added For Added For SRR-CRF-303.2 on 1/27/2010.
				1.If the value of  the DAGGER_INDEPENDENT_YN =='Y' the indicatior of  the asterik will be visible.
			*/
				if(dagger_independent_yn.equals("Y")){
					disp_dagger_dep_ind	=	"display:inline";
				}else{
					disp_dagger_dep_ind	=	"display:none";
				}
				if(diag_classification.equals(""))
					diag_classification_display="&nbsp;";
				else
					diag_classification_display=diag_classification;
				if(applicable_side.equals("")) 
				applicable_side="&nbsp;";

				if(!(applicable_side==null || applicable_side.equals("&nbsp;")))
				{
				if(applicable_side.equals("L"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
				else if(applicable_side.equals("R"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
				else if(applicable_side.equals("B"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
				else if(applicable_side.equals("N"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");	
				}
			//
			out.println("<tr>");
			
			short_desc=short_desc.replaceAll("'","\\\\'");// included for the SCF - SRR20056-scf-8582 
			if(encounter_id1>0) {
			//if(encounter_id1.equals("Y")){	
				out.println("<td  nowrap class='"+classValue+"'><img src='../../eCommon/images/CurrentEncounter.gif'></td>");

			}else{	
				/*5/20/2009 Incident IN010259[1].2(reopen)*/
				/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
				if(status.equals("Active")){
					//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
					if(term_code_status.equals("E"))
					{
					//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013
					String url2="<td  class='"+classValue+"' nowrap><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"','"+accession_num_work_related+"','"+accession_num_notifiable+"','"+diag_category_code+"', '"+diagClassMandYn+"')  \">"+not_curr_enc+"</a>&nbsp;</td>";//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
					out.println(url2);
					}
					else
						{
						out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"&nbsp;</td>");	
						}
				}else{
						out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"&nbsp;</td>");
				}
			}
			//Added by Jeyachitra - ML-MMOH-CRF 1742 starts
			if(isDeceasedDiagClassDeathRegAppl)
			{
			try
			{
				
				pstmt = con.prepareStatement("select * from mr_rec_diag_audit_trial where patient_id=? and term_Set_id=? and encounter_id=? and term_code=? and occur_srl_no=? and facility_id=?");
				pstmt.setString(1, Patient_Id);
				pstmt.setString(2, term_set_id);
				pstmt.setString(3, Encounter_Id);
				pstmt.setString(4, term_code);
				pstmt.setString(5, occur_srl_no);
				pstmt.setString(6, operating_facility_id);
				res= pstmt.executeQuery();
				
				if(res!=null && res.next())
					out.println("<td class='" + classValue + "' nowrap><font size='1'><a href='javascript:displayAuditTrial(\"" + Patient_Id + "\",\"" + term_code + "\",\"" + term_set_id + "\",\"" + Encounter_Id + "\",\"" + operating_facility_id + "\",\"" + occur_srl_no + "\")'>Audit Trail</a></font></td>");
				else
					out.println("<td class='"+classValue+"' nowrap>&nbsp;</td>");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(res!=null) res.close();
				if(pstmt!=null) pstmt.close();
			}
			}//Added by Jeyachitra - ML-MMOH-CRF 1742 end
			if(!pat_accession_num.equals("")){
				out.println("<td class='"+classValue+"'  nowrap><font color='blue' ><b><a href=\"javascript:callOHLinkedDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+Encounter_Id+"','"+pat_accession_num+"','"+oh_chart_num+"')\">C</a></font></td>");
			}else{
				out.println("<td  class='"+classValue+"' nowrap>&nbsp;</td>");
			}
			//out.println("<td width='2%' class='"+priorityclass+"'>&nbsp;</td>");
			if(status.equals("Active") && accur_code_ind.equals("U")){
				//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:diffGroup('"+term_set_id+"','update','"+term_code+"')\">"+Diff_status+" </a></td>");
				%>
				<td nowrap class='<%=classValue%>'><img src='../../eCommon/images/Differentials.gif' style="cursor:pointer;visibility:visible" onclick='diffGroup("<%=term_set_id%>","update","<%=term_code%>")'></img></td>
		<%}else{
				out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");
			}
    			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+term_set_desc+"</font></td>");
				//out.println("<script>alert(\""+view_cnt+"\");</script>");
			//out.println("<script>alert(\""+term_code_disply+"\");</script>");
			if(view_cnt !=0){%>
					<td class='<%=classValue%>'  nowrap><font size='1'><%=term_code_disply%><img src='../../eCommon/images/LinkView.gif' align='right' onclick='showProblem("<%=Patient_Id%>","<%=term_code%>","<%=term_set_id%>","<%=Encounter_Id%>","<%=occur_srl_no%>")'></font></td>

			<%}else{
					out.println("<td class='"+classValue+"'  nowrap>&nbsp;<font size='1'>"+term_code_disply+"</font>&nbsp;</td>");
			}
			
           /*Below line Modified for this CRF [PMG2012-CRF-0030]*/
		  //Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
		  //Suresh M passed the diag_class_code in the callDetails Method
		  	//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
			if(term_code_status.equals("E"))
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+patient_class+"','"+onset_date+"','"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"','"+cause_of_death+"','"+Locn_Code+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+option_id+"','"+accession_number+"','"+oh_chart_num+"','"+diag_classification+"','"+status+"','"+notifiable_code+"','"+diag_class_code+"','"+p_called_from_widget+"','"+called_from_ot+"','"+diag_category_code+"')\">"+actual_short_desc+"</a>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='"+disp_dagger_dep_ind+"'>&nbsp;</font></td>");// included for the SCF - SRR20056-scf-8582  //CHL-CRF- 0008 - IN:001472 
				}
			else 
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+short_desc+"</font></td>");	
				}
			//Ends
			%>
			<!-- <td class='<%=classValue%>'  nowrap><font size='1'><a href="javascript:callDetails('<%=Patient_Id%>','<%=term_code%>','<%=term_set_id%>','<%=term_set_desc%>','<%=patient_class%>','<%=onset_date%>','<%=notifiable_yn%>','<%=dob%>','<%=age%>','<%=sex%>','<%=occur_srl_no%>','<%=java.net.URLEncoder.encode(associate_codes.toString())%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=Locn_Code%>','<%=isCurrentEncounter%>','<%=old_encounter_id%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=diag_classification%>','<%=status%>')"><%=short_desc%></a></font></td> -->
			<%
			/*Below line added for this Bru-HIMS-CRF-024.2*/
			//Added for this CRF Bru-HIMS-CRF-024.2			
			if(!accession_num_work_related.equals("")){
				//Added by Sangeetha for ML-MMOH-CRF-0547
				if(legendChangeAsTypesOfNotiForm)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypesofNotificationReport.label","mr_labels");
				else if(notifiableLegndChgApplYn)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NotifyReport.label","mr_labels");
				else
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.WorkRelatedReport.label","mr_labels");
			}
			else
			accession_num_notifiable_display="&nbsp;"; 
						
		    out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:NotifiableReport('"+accession_num_work_related+"','"+Patient_Id+"','"+Encounter_Id+"','"+operating_facility_id+"')\">"+accession_num_notifiable_display+"</a></font></td>");  
			
			//End Bru-HIMS-CRF-024.2
			//Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012
			//Start
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+status_lbl+"</font></td>");
			//End
			
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started
			
			diagnosis_remark=diagnosis_remark.trim();
			if(!diagnosis_remark.equals(""))
			{
					
						diagnosis_remark = diagnosis_remark.replace("\'", "\\\'"); 
						out.println("<td  class='"+classValue+"'  style='text-align:center' nowrap><font size='1'><a href=\"javascript:showDiagnosisRemark('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+occur_srl_no+"')\">View</a></font></td>");
					
			}
			else
			{
						out.println("<td  class='"+classValue+"' nowrap><font size='1'></font></td>");

			
			}
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 End
			
			
			/*below line Added for this CRF  [PMG2012-CRF-0030] */
			String pre_oper="";
			if(preoperative.equals("Y"))		  
                 pre_oper=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreOpreativedesc.label","mr_labels");
            else
			     pre_oper="&nbsp;";
			
		   
		    out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+pre_oper+"</font></td>");  
			// End this CRF  [PMG2012-CRF-0030]			
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+applicable_side+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+diag_classification_display+"</font></td>");
			//Added by Ajay for TH-KW-CRF-165.1
			//Start
			if(isDiagCatgMand){
				out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+diag_category+"</font></td>");
			}
			//End CRF TH-KW-CRF-165.1
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+curr_practitioner_name+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+recordedDateDisp+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+accuracy_short_desc+"</font></td>");
			//out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+nature+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+encounter_stage+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+natureLangDesc+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+severity+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+onset_date_converted+"</font></td>");
			//Maheshwaran K commented below line for the SKR-CRF-0020 as on 10/07/2013
			//out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+status_lbl+"</font></td>");		
			
			if(Support_exisist_yn_YN.equals("Y"))
			{
			out.println("<td class='"+classValue+"'  nowrap><font size=1>");
			out.println("<a href=\"javascript: ShowSupportingDiag('" + term_code+"','"+occur_srl_no+"','"+Patient_Id+"','"+term_set_id+"','"+(java.net.URLEncoder.encode(short_desc))+"("+term_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			out.println("</font></td>");
			}
			else{
			out.println("<td class='"+classValue+"'  nowrap>&nbsp<font size=1></font></td>");
			}

			out.println("</tr>");		
			k++;
			associate_codes = new StringBuffer();
			priorityclass = "";
			}
			else if(f_authorize_yn.equals("Y"))
			{
				
					if(!prev_term_set_id.equals(term_set_desc))
				{
	
	%>
<!-- 			<tr>
				<td colspan='12' class='CAGROUPHEADING' align='left'><font size=1><b><%=term_set_desc%></b></font></td>
			</tr>	
 -->	<%
			}
			prev_term_set_id = term_set_desc;
			if ( k%2 == 0 )
                classValue = "QRYEVEN" ;
             else
                classValue = "QRYODD" ;

			/*short_desc					= checkForNull(rs.getString("term_code_desc"));
			if(short_desc.equals("")) 
				short_desc="&nbsp;";*/
			 //Above line commented this incident  [IN:038488]	

			term_code					= checkForNull(rs.getString("term_code"));
			term_code_disply			= term_code ; 
			 //Added Below line for this incident [IN:038488]
			if(term_code.equals("*OTH")){
					short_desc = checkForNull(rs.getString("term_code_desc"));
			}else{
			
			short_desc = checkForNull(rs.getString("short_desc")); 
			}
				 
				 term_set_id							= checkForNull(rs.getString("term_set_id"));  //  added by mujafar for ML-MMOH-CRF-1281				 
				if(isMultiDescAppl && term_set_id.equals("ICD10") ) 
				short_desc = checkForNull(rs.getString("term_code_desc"));

			if(short_desc.equals("")) 
				short_desc="&nbsp;";
			preoperative= checkForNull(rs.getString("pre_operative"));// this line Added for this CRF  [PMG2012-CRF-0030]	

           /*below line Added for this CRF  [PMG2012-CRF-0030] */
			String pre_oper="";
			if(preoperative.equals("Y"))		  
                 pre_oper=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreOpreativedesc.label","mr_labels");
            else
			     pre_oper="&nbsp;";   
			
			//Added for this CRF Bru-HIMS-CRF-024.2
			accession_num_work_related=checkForNull(rs.getString("accession_num_work_related"));
			accession_num_notifiable=checkForNull(rs.getString("accession_num_notifiable"));
			if(!accession_num_work_related.equals("")){
				//Added by Sangeetha for ML-MMOH-CRF-0547
				if(legendChangeAsTypesOfNotiForm)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypesofNotificationReport.label","mr_labels");
				else if(notifiableLegndChgApplYn)
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NotifyReport.label","mr_labels");
				else
				accession_num_notifiable_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.WorkRelatedReport.label","mr_labels");
			}
			else
			accession_num_notifiable_display="&nbsp;";  
			
			//if(term_code.equals("*OTH"))
				//term_code_disply        = "" ;
			accuracy_short_desc			= checkForNull(rs.getString("accuracy_short_desc"));
			onset_nature				= checkForNull(rs.getString("nature"));
			nature						=onset_nature;
			severity					= checkForNull(rs.getString("severity"));
			if(severity.equals("")) 
				severity="&nbsp;";
			
			encounter_stage				= checkForNull(rs.getString("ENC_STAGE"));
			if(encounter_stage.equals("")) 
				encounter_stage="&nbsp;";

			if(!(encounter_stage==null || encounter_stage.equals("&nbsp;")))
			{
				if(encounter_stage.equals("A"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				else if(encounter_stage.equals("I"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				else if(encounter_stage.equals("D"))
					encounter_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");	
			}
	
			if(nature.equals("")) 
				nature="&nbsp;";
			if(!(nature==null || nature.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
				else if(nature.equals("Potential"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				else if(nature.equals("Wellness"))
					natureLangDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
			}
			if(natureLangDesc.equals("")) 
				natureLangDesc="&nbsp;";
			onset_date					=checkForNull(rs.getString("onset_date")); 
			if(!(onset_date==null || onset_date.equals("")))
				onset_date_converted	=	DateUtils.convertDate(onset_date,"DMY","en",localeName);

			onset_status					= checkForNull(rs.getString("status")); 
			status	=onset_status;
			//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013
			//Start
			if(severity.equals("")) 
				severity_str="&nbsp;";
			if(!(severity==null || severity_str.equals("&nbsp;")))
			{
				if(severity.equals("Moderate"))
				severity_str="D";
				if(severity.equals("Mild"))
				severity_str="L";
				if(severity.equals("Severe"))
				severity_str="S";
				if(severity.equals("Extreme"))
				severity_str="E";
			}
			if(encounter_stage.equals("")) 
				encounter_stage_str="&nbsp;";
			if(!(encounter_stage==null || encounter_stage_str.equals("&nbsp;")))
			{
				if(encounter_stage.equals("Admission"))
				encounter_stage_str="A";
				if(encounter_stage.equals("Intermediate"))
				encounter_stage_str="I";
				if(encounter_stage.equals("Discharge"))
				encounter_stage_str="D";
			}
	
			if(nature.equals("")) 
				nature_str="&nbsp;";
			if(!(nature==null || nature_str.equals("&nbsp;")))
			{
				if(nature.equals("Actual"))
				nature_str = "A";
				if(nature.equals("Potential"))
				nature_str = "P";
				if(nature.equals("Wellness"))
				nature_str = "W";
			}
			//end
			if(status.equals("Active"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			else if(status.equals("Resolved"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
			else if(status.equals("Revoked"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels");
			else if(status.equals("In Error"))
					status_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");

			occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));

			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status="(D)";
			else
				Diff_status="";*/

			/*if(status.equals("Active") && accur_code_ind.equals("U"))
				Diff_status="<img src='../../eCommon/images/Differentials.gif'></img>";
			else
				Diff_status="&nbsp;";*/
				if(!term_code.equals("*OTH"))
				{
					 linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND TERM_CODE =? and OCCUR_SRL_NO=?";
					
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,term_code);
					stmt2.setString(4,occur_srl_no);
				}
				else
				{
					 linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID=? AND  FACILITY_ID=? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO=?";
					stmt2=con.prepareStatement(linkviewcnt_sql);
					stmt2.setString(1,Encounter_Id);
					stmt2.setString(2,operating_facility_id);
					stmt2.setString(3,short_desc);
					stmt2.setString(4,occur_srl_no);
				}
			//st = con.createStatement();
			//rset = st.executeQuery(linkviewcnt_sql);


			rset2=stmt2.executeQuery();

			if(rset2 != null && rset2.next())
			{
				//if(rset.getInt(1) == 0)
				//{
					view_cnt=rset2.getInt(1);


				//}
			}


			term_set_id = checkForNull(rs.getString("term_set_id"));
			Support_exisist_yn_YN = checkForNull(rs.getString("Support_exisist_yn_YN"));
			//if(encounter_id1.equals("Y"))
			if(encounter_id1>0)
				isCurrentEncounter = "N";
			else
				isCurrentEncounter = "Y";			
			
				anatomical_site = checkForNull(rs.getString("anatomical_site"));
				applicable_side = checkForNull(rs.getString("applicable_side"));
				pat_accession_num = checkForNull(rs.getString("accession_num"));
				/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
				diag_class_code = checkForNull(rs.getString("diag_class_code"));
				curr_status		= checkForNull(rs.getString("curr_status"));
				notifiable_code						= checkForNull(rs.getString("NOTIFICATION_CODE"));//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
				/**/
				diag_classification = checkForNull(rs.getString("diag_class_short_desc"));
				curr_enc_diag_class				= checkForNull(rs.getString("curr_enc_diag_class"));

				//if(diag_enc_level_yn.equals("N")){
					if(curr_enc_diag_class.equals("@|#$&*")){
						diag_classification="";
						diag_class_code="";
					}else if(!curr_enc_diag_class.equals("")){
						
						int indx=curr_enc_diag_class.indexOf("@|#$&*");
						
						diag_class_code=curr_enc_diag_class.substring(0,indx);
						diag_classification=curr_enc_diag_class.substring(indx +6,curr_enc_diag_class.length());
					}
				//}

				if(diag_classification.equals(""))
					diag_classification="&nbsp";
				if(applicable_side.equals("")) 
				applicable_side="&nbsp;";

				if(!(applicable_side==null || applicable_side.equals("&nbsp;")))
				{
				if(applicable_side.equals("L"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
				else if(applicable_side.equals("R"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
				else if(applicable_side.equals("B"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
				else if(applicable_side.equals("N"))
					applicable_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");	
				}

				
			//
			out.println("<tr>");
			//if(encounter_id1.equals("Y"))
			if(encounter_id1>0)
				out.println("<td nowrap class='"+classValue+"'><img src='../../eCommon/images/CurrentEncounter.gif'></td>");
			else
				{	/*5/20/2009 Incident IN010259[1].2(reopen)*/
					/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
					if(status.equals("Active"))
					{
						//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
						if(term_code_status.equals("E"))
							{
							out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc.replaceAll("'","\\\\'")+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"','"+accession_num_work_related+"','"+accession_num_notifiable+"','"+diag_category_code+"', '"+diagClassMandYn+"')\">"+not_curr_enc+"</a>&nbsp;</td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013	
							}
						else 
							{
							out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"</td>");
							}
						//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013 Added Bru-HIMS-CRF-024.2
					//	String url="<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"')\">"+not_curr_enc+"</a>&nbsp;</td>";//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc.replaceAll("'","\\\\'")+"','"+diag_class_code+"','"+curr_status+"','"+priority+"','"+nature_str+"','"+severity_str+"','"+encounter_stage_str+"','"+curr_onset_type+"','"+notifiable_code+"','"+accession_num_work_related+"','"+accession_num_notifiable+"')\">"+not_curr_enc+"</a>&nbsp;</td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						//out.println(url);
						//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+short_desc+"','"+diag_class_code+"','"+curr_status+"')\">"+not_curr_enc+"</a>&nbsp;</td>");
					}
					else
						out.println("<td nowrap class='"+classValue+"'>"+not_curr_enc+"&nbsp;</td>");
				}

			if(!pat_accession_num.equals(""))
				out.println("<td class='"+classValue+"' nowrap ><font color='blue' ><b><a href=\"javascript:callOHLinkedDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+Encounter_Id+"','"+pat_accession_num+"','"+oh_chart_num+"')\">C</a></font></td>");
			else
				out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");

			//out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:diffGroup('"+term_set_id+"','update','"+term_code+"')\">"+Diff_status+" </a></td>");
			if(status.equals("Active") && accur_code_ind.equals("U"))
			{%>
				<td nowrap class='<%=classValue%>'><img src='../../eCommon/images/Differentials.gif' style="cursor:pointer;visibility:visible" onclick='diffGroup("<%=term_set_id%>","update","<%=term_code%>")'></img></td>
		<%
			}
			else
			{
				out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");

			}


			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+term_set_desc+"</font></td>");
			
			//out.println("<script>alert(\""+view_cnt+"\");</script>");
			//out.println("<script>alert(\""+term_code_disply+"\");</script>");

			if(view_cnt !=0){%>
				<td class='<%=classValue%>'  nowrap><font size='1'><%=term_code_disply%><img src='../../eCommon/images/LinkView.gif' align='right' onclick='showProblem("<%=Patient_Id%>","<%=term_code%>","<%=term_set_id%>","<%=Encounter_Id%>","<%=occur_srl_no%>")'></font></td>
			<%}
			else
			{
				out.println("<td class='"+classValue+"'  nowrap>&nbsp;<font size='1'>"+term_code_disply+"</font>&nbsp;</td>");

			}

			
			//out.println("<td width='2%' class='"+priorityclass+"'>&nbsp;</td>");
			//out.println("<td class='"+classValue+"' nowrap ><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+patient_class+"','"+onset_date+"','"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"','"+cause_of_death+"','"+Locn_Code+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+option_id+"','"+accession_number+"','"+oh_chart_num+"','"+diag_classification+"')\">"+short_desc+"</a></font>&nbsp;&nbsp;<font color='blue' size='1'><b></b></font></td>");
			
			//9/11/2009
			//Suresh M passed the diag_class_code in the callDetails Method
			//Maheshwaran K added to get the Effective Status of the TermCode for the NMC-JD-SCF-0259 as on 23-12-2021
			if(term_code_status.equals("E"))
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+patient_class+"','"+onset_date+"','"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"','"+cause_of_death+"','"+Locn_Code+"','"+isCurrentEncounter+"','"+old_encounter_id+"','"+option_id+"','"+accession_number+"','"+oh_chart_num+"','"+diag_classification+"','"+status+"','"+notifiable_code+"','"+diag_class_code+"','"+diag_category_code+"')\">"+short_desc+"</a></font></td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
				}
			else
				{
				out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+short_desc+"</a></font></td>");//Maheshwaran K added "notifiable_code" for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013	
				}
%>
			<!-- <td class='<%=classValue%>'  nowrap><font size='1'><a href="javascript:callDetails('<%=Patient_Id%>','<%=term_code%>','<%=term_set_id%>','<%=term_set_desc%>','<%=patient_class%>','<%=onset_date%>','<%=notifiable_yn%>','<%=dob%>','<%=age%>','<%=sex%>','<%=occur_srl_no%>','<%=java.net.URLEncoder.encode(associate_codes.toString())%>','<%=Encounter_Id%>','<%=cause_of_death%>','<%=Locn_Code%>','<%=isCurrentEncounter%>','<%=old_encounter_id%>','<%=option_id%>','<%=accession_number%>','<%=oh_chart_num%>','<%=diag_classification%>','<%=status%>')"><%=short_desc%></a></font></td> -->
<%        
            /*Below line added for this Bru-HIMS-CRF-024.2*/
			// String notifyreport=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NotifyReport.label","mr_labels");
			 //out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=javascript:callNotifiableNotes()>"+accession_num_notifiable_display+"</a></font></td>"); 
			out.println("<td class='"+classValue+"'  nowrap><font size='1'><a href=\"javascript:NotifiableReport('"+accession_num_work_related+"','"+Patient_Id+"','"+Encounter_Id+"','"+operating_facility_id+"')\">"+accession_num_notifiable_display+"</a></font></td>");  
			//End Bru-HIMS-CRF-024.2

			//Modified by Maheshwaran for the SKR-CRF-0020 as on 26/04/2012
			//Start
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+status_lbl+"</font></td>");
			//End
			
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started (added for sensitive case)
					
			diagnosis_remark            = checkForNull(rs.getString("curr_remarks")); //added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023
			diagnosis_remark=diagnosis_remark.trim();
			if(!diagnosis_remark.equals(""))
			{
						diagnosis_remark = diagnosis_remark.replace("\'", "\\\'"); 
						out.println("<td  class='"+classValue+"'  style='text-align:center' nowrap><font size='1'><a href=\"javascript:showDiagnosisRemark('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+term_set_desc+"','"+occur_srl_no+"')\">View</a></font></td>");
					
			}else
			{
						out.println("<td  class='"+classValue+"' nowrap><font size='1'></font></td>");
			}
			//added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 End
			
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+pre_oper+"</font></td>"); //Added this line for this incident [IN:038488]
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+applicable_side+"</font></td>");
			
			
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+diag_classification+"</font></td>");
			/*if(practitioner_name.equals(""))
					practitioner_name="&nbsp";
			out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+practitioner_name+"</font></td>");*/
			
			if(curr_practitioner_name.equals(""))
					curr_practitioner_name="&nbsp";
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+curr_practitioner_name+"</font></td>");
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+recordedDateDisp+"</font></td>");

			if(accuracy_short_desc.equals(""))
					accuracy_short_desc="&nbsp";
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+accuracy_short_desc+"</font></td>");
			//out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+nature+"</font></td>");
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+encounter_stage+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+natureLangDesc+"</font></td>");
			out.println("<td class='"+classValue+"'  nowrap><font size='1'>"+severity+"</font></td>");

			if(onset_date_converted.equals(""))
					onset_date_converted="&nbsp";
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+onset_date_converted+"</font></td>");
		//	out.println("<td class='"+classValue+"' nowrap><font size='1'>"+status_lbl+"</font></td>");		
			
			if(Support_exisist_yn_YN.equals("Y"))
			{
			out.println("<td class='"+classValue+"' nowrap><font size=1>");
			out.println("<a href=\"javascript: ShowSupportingDiag('" + term_code+"','"+occur_srl_no+"','"+Patient_Id+"','"+term_set_id+"','"+short_desc.replaceAll("'","\\\\'")+"("+term_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			out.println("</font></td>");
			}
			else{
			out.println("<td class='"+classValue+"' nowrap>&nbsp<font size=1></font></td>");
			
			//out.println("<td width='2%' class='"+classValue+"'>&nbsp;</td>")
			}

			out.println("</tr>");		
			k++;
			associate_codes = new StringBuffer();
			priorityclass = "";
			
									
			}
		natureLangDesc="";//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013	
		}
		
		  if(rs!=null)		rs.close();
		  if(stmt!=null)    stmt.close();

      %>
<tr style='visibility:hidden'>
<th>&nbsp;</th>
<!--<th>&nbsp;</th>-->
<th align='center'><font size=1><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></th>
<th align='center'><font size=1><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></font></th>
<!--<th align='center' ><font size=1><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></font></th>-->
<th align='center' ><font size=1><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></font></th>
<th align='center' ><font size=1><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></font></th>
<th align='center'><font size=1><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></th>
<th align='center'><font size=1><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></font></th>
</tr>
		  
</table>
</div>
<script>
//Added by mujafar for ML-BRU-CRF-0524
changeSortOrder('<%=asc_desc%>','<%=headerVal%>')
</script>
	<input type='hidden' name='qryStr' id='qryStr' value="<%=request.getQueryString()==null?"":request.getQueryString()%>" >
	<input type='hidden' name='Patient_Id' id='Patient_Id' value="<%=Patient_Id%>" >
	<input type='hidden' name='Encounter_Id' id='Encounter_Id' value="<%=Encounter_Id%>" >
	<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
	<%--<input type='hidden' name='onset_date' id='onset_date' value="<%=onset_date%>" >--%>
	<%--<input type='hidden' name='occur_srl_no' id='occur_srl_no' value="<%=occur_srl_no%>" >--%>
	<input type='hidden' name='diff_mode' id='diff_mode' value="" >
	<input type="hidden" name = "Locn_Code" id = "Locn_Code" value ="<%=Locn_Code%>">
	<input type="hidden" name = "Locn_Type" id = "Locn_Type" value ="<%=Locn_Type%>">
	<input type="hidden" name = "Practitioner_Id" id = "Practitioner_Id" value ="<%=Practitioner_Id%>">
	<input type="hidden" name = "relationship_id" id = "relationship_id" value ="<%=relationship_id%>">
	<input type="hidden" name = "modal_yn" id = "modal_yn" value ="<%=modal_yn%>">
	<input type="hidden" name ="practitioner_type" id ="practitioner_type" value ="<%=practitioner_type%>">
	<input type="hidden" name ="called_from_ip" id ="called_from_ip" value ="<%=called_from_ip%>">
	<input type='hidden' name='diag_classification' id='diag_classification' value='<%=diag_classification%>'></input>
	<input type='hidden' name='term_code_short_desc' id='term_code_short_desc' value='<%=short_desc%>'></input>
	<input type='hidden' name='diag_class_code' id='diag_class_code' value='<%=diag_class_code%>'></input>
	<!--Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645-->
	<input type='hidden' name='termCodeEffStatus' id='termCodeEffStatus' value='<%=termCodeEffStatus%>'></input>
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'></input>

	<input type='hidden' name='enbl_link_to_curr_enc' id='enbl_link_to_curr_enc' value='<%=enableLinktoCurrEncS%>'></input>
	<input type='hidden' name='crs_chk_mand_flds' id='crs_chk_mand_flds' value='<%=crossChkMandFldsYn%>'></input>	
	<input type='hidden' name='term_set_desc' id='term_set_desc' value='<%=term_set_desc%>'></input>	
	<input type='hidden' name='notifiable_yn' id='notifiable_yn' value='<%=notifiable_yn%>'></input>	
	<input type='hidden' name='onset_date' id='onset_date' value="<%=onset_date%>"></input>
	<input type='hidden' name='dob' id='dob' value="<%=dob%>"></input>
	<input type='hidden' name='age' id='age' value="<%=age%>"></input>
	<input type='hidden' name='cause_of_death' id='cause_of_death' value="<%=cause_of_death%>"></input>
	<input type='hidden' name='isCurrentEncounter' id='isCurrentEncounter' value="<%=isCurrentEncounter%>"></input>
</form>
</body>
</html>

<%
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
}
%>

