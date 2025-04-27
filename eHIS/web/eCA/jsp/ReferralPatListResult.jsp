<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        Rev.Date Rev.by Description
--------------------------------------------------------------------------------------------------------------
?				100					?           					created
30/01/2012		IN030566			Ramesh G						When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.								  
08/11/2011		IN28273				Dinesh T	 					Added the change event to that control
18/04/2012		IN030318			Ramesh G						This age of the newborn is displayed in the newborn list in location list as well as in the patient banner in patient?s chart.
24/04/2012		IN032435,IN032437		Ramesh G					The age of new born is displayed as Null.
12/09/2012		IN034999			vijayakumark					Encounter details and Confirm hyperlink not displayed for Enterprise Referral Type
21/01/2014		IN044931			Chowminya  	21/01 		Akbar	Referral Status Still remains as Pending Referral even though the referral is closed
13/03/2014		IN044157			Chowminya		 				[AAKH CRF 0010.1]Five level Triage system AE requirement 	
02/04/2014		IN047927			Chowminya						Referral List - Transactions Failed, while confirm Bed Side Referral 
10/02/2015		IN048463			Karthi L						Bed Side Referral Status
06/04/2015		IN052595			Karthi L						Referral Patient List
04/02/2016		IN057201		    Karthi L						View Forwarded Referral Letter Under Consults
----------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
24/10/2017		IN065452		Krishna Gowtham		25/10/2017		Ramesh G	ML-MMOH-CRF-0566.2
11/06/2018      IN067543        Ramya Maddena       11/06/2018      Ramesh G    ML-MMOH-CRF-1168
 6/11/2023     32902             Krishna Pranay    	     7/11/2023      Ramesh G      MMS-DM-CRF-0210	

-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../js/CAMenu.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../js/ReferralPatListResult.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/CACommon.js'></script><!-- 32902 -->
    <head>
    </head>
    <body class='CONTENT' onscroll='moveFrame()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='PatCriteriaFrm' id='PatCriteriaFrm' action='../../eCA/jsp/OpenChartWrapper.jsp' method = 'post' target='messageFrame' >
	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
		<td class='white' width='90%'></td> 
		<td nowrap  width='5%' align='right' id='previous' ></td>
		<td nowrap  width='5%' align='right' id='next' ></td>
		</tr>
	</table>
	<table id='PatCriteriaTbl'  width='100%' class='grid' scrolling="auto">
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id=(String)session.getValue("facility_id");
	if(facility_id == null) facility_id="";

	String clinicianId =(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('"+request.getQueryString()+"');</script>");

	String locationType		=	request.getParameter("locationType") == null ? "" : request.getParameter("locationType");
	//out.println("locationType"+locationType);
	
	String locationCode		=	request.getParameter("locationCode") == null ? "" : request.getParameter("locationCode");

	String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
	String toDate			=	request.getParameter("toDate") == null ? "" : request.getParameter("toDate"); 
    String patientId		=	request.getParameter("patientId") == null ? "" : request.getParameter("patientId");
   // String groupByEpisode	=	request.getParameter("groupByEpisode") == null ? "" : request.getParameter("groupByEpisode");
	String groupByEpisode="N"; // 
   // String groupByLocn		=	request.getParameter("groupByLocn") == null ? "" : request.getParameter("groupByLocn");
    String groupByLocn	="N";
	String unAssigned		=	request.getParameter("unAssigned") == null ? "" : request.getParameter("unAssigned");
	String pendingRef		=	request.getParameter("pendingRef") == null ? "" : request.getParameter("pendingRef");
	String closed			=	request.getParameter("closed") == null ? "" : request.getParameter("closed");
	String open				=	request.getParameter("open") == null ? "" : request.getParameter("open");
	String refStatus		= 	request.getParameter("refStatus") == null ? "" : request.getParameter("refStatus");//IN064836

	String from				=	request.getParameter("from") ;
	String to				=	request.getParameter("to") ;
	String orderBy			=	request.getParameter("orderBy") == null ? "" : request.getParameter("orderBy");
	String reOrder			=	request.getParameter("reOrder") == null ? "" : request.getParameter("reOrder");
	String anchorID			=	request.getParameter("anchorID") == null ? "" : request.getParameter("anchorID");
	String leftScrolling	=	request.getParameter("leftScrolling") == null ? "" : request.getParameter("leftScrolling");

	//String mode				=	request.getParameter("mode") == null ? "" : request.getParameter("mode");

	String loc_code			=	request.getParameter("loc_code") == null ? "" : request.getParameter("loc_code");//from bean
	String locn_type			=	request.getParameter("locn_type") == null ? "" : request.getParameter("locn_type");//from bean
	
	String bedside_ref_review_status 	= "";  // added for IN048463
	String bedside_referral_YN			= "";  //  added for IN064836
	//Date Conversion added by Archana Dhal related to IN18772
	if(!locale.equals("en"))//IN28273
	{
	fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
	toDate = com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
	}
	  
	String prev = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String next = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

	String relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");

	String visitStyle = "";
	if(reOrder.equals("1"))
	{
		visitStyle = "color:pink" ;
	}
	else
	{
		visitStyle = "color:yellow" ;
	} 

	int maxNoRecords = 0;

	String qry_mo_install_yn = "select install_yn from sm_module where module_id='MO'";

	Connection con = null;

	PreparedStatement pstmt = null;
	PreparedStatement stmtMotherLink = null;

	ResultSet rs = null;
	ResultSet rsMotherLink = null;

	StringBuffer sql = new StringBuffer();
	StringBuffer layer = new StringBuffer();
	String mo_install_yn = "";
	String sqlMotherLink = "";
	String episode_type_desc = "";
	String sex = "";
	String patient_status = "";
	String decesedColor = "";
	String apgar_score = "	";
	String title = "";
	String dateofbirth1 = "";
	String enctr_id = "";
	String ca_record_referral_note_yn = "Y"; //ML-MMOH-CRF-0362 [IN057201]
	boolean isScroll	= true;

	Boolean isRefPatientListAppl = false; //IN067543
	if(groupByEpisode.equals("Y") && groupByLocn.equals("Y"))
	{

		isScroll = false;
	}

	boolean flag = true;

	try
	{
		// IN048463 Start.
		String bean_id = "CA_ca_patListbylocationresult" ;
		String bean_name = "eCA.PatListByLocationResult";
		PatListByLocationResult bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
		String allow_muti_bedside_review_yn  = bean.getMultiBedSideReviewYN(facility_id); 
		// IN048463 End.
		//32902 start
		String restPatientYN="";
	 String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	 String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	 CACommonGetPatientDtlBean bean1	= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	 int accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	
	 //32902 end
		ca_record_referral_note_yn = bean.getReferralNoteFromPASYN(facility_id); //  ML-MMOH-CRF-0362 [IN057201]
		con = ConnectionManager.getConnection(request);
		//IN064836 start
		String refRegSiteYN = "";
		//IN067543 Start.
		ArrayList<String> functionIds = new ArrayList<String>();
		functionIds.add("REF_PAT_LST_WITHIN_PRACT_SPLTY");
		bean.setSiteSpecific(functionIds,"CA");
		isRefPatientListAppl = bean.isSiteSpecific("REF_PAT_LST_WITHIN_PRACT_SPLTY");
		//IN067543 End.
		Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
		if(referralRegister)
		{
			refRegSiteYN = "Y";
		}
		else
		{
			refRegSiteYN = "N";
		}
		//IN064836 ends
	//IN044157 - Start
	String AEZone5 = "N";
	PreparedStatement stmtAE = con.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
	ResultSet rsAE = null;
	stmtAE.setString(1,facility_id);
	rsAE = stmtAE.executeQuery();
	while(rsAE.next()){
		AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
	}
	if(stmtAE!=null)stmtAE.close();
	if(rsAE!=null)rsAE.close();
	//IN044157 - End
		stmtMotherLink = con.prepareStatement(qry_mo_install_yn);
		rs = stmtMotherLink.executeQuery();

		if(rs.next())
			mo_install_yn = (rs.getString("install_yn") == null ? "" : rs.getString("install_yn"));

		if(rs != null) rs.close();
		if(stmtMotherLink != null) stmtMotherLink.close();

		sqlMotherLink = "select a.patient_id pat_id, replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) ,'''','')  short_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH, a.WEIGHT, a.WEIGHT_UNIT, a.LENGTH ||' cms'  LENGTH_OF_BABY,a.CIRCUMFERENCE ||' cms'  CIRCUMFERENCE_OF_HEAD,a.APGAR_SCORE, b.sex from mp_birth_register a,mp_patient b where  b.patient_id=a.patient_id and a.mother_patient_id= ? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by TIME_OF_BIRTH  ";

		stmtMotherLink = con.prepareStatement(sqlMotherLink);

		int k=0;
		int i=0;
		String rowclass = "gridData";

		//[IN030318] sql.append("SELECT B.PATIENT_NAME, A.referral_id, GET_AGE(B.DATE_OF_BIRTH) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");

		// [IN032435] sql.append("SELECT B.PATIENT_NAME, A.referral_id, MP_GET_AGE_YMDH(b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");

		// [IN032437] sql.append("SELECT B.PATIENT_NAME, A.referral_id, nvl(MP_GET_AGE_YMDH(b.date_of_birth,b.DECEASED_DATE),GET_AGE(B.DATE_OF_BIRTH)) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");
		
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");
		
		/* IN034999 starts */
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");
		/* IN034999 ends */
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); //IN044931//IN047927 added BEDSIDE_REFERRAL_YN col - Commented for IN048463
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); // Modified for IN048463 // commented  for ML-MMOH-CRF-0362 [IN057201]
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_REF_LETTER_NOTES_REC_YN, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN, CA_REF_LETTER_NOTES_REC_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); // Modified for ML-MMOH-CRF-0362 [IN057201]//32902
		sql.append("SELECT B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_REF_LETTER_NOTES_REC_YN, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN, b.restrict_reinstate_yn  FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN, CA_REF_LETTER_NOTES_REC_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); //32902
				//IN065452 start
		if("R".equals(pendingRef) && "Self".equals(unAssigned))
		{
			sql.append(" AND FROM_PRACT_ID = ?  ");
		}
		//if(unAssigned.equals("Self")){
		else if(unAssigned.equals("Self")){
		//IN065452 ends
			sql.append(" AND TO_PRACT_ID = ?  ");										
		}
		else if(unAssigned.equals("Unassigned"))
		{		
			// IN067543 Start.
			if(isRefPatientListAppl)
			{				
                sql.append(" and (TO_PRACT_ID != ? or TO_PRACT_ID IS NULL) AND TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ?)");
			}else
			{
			// IN067543 End.
			    sql.append(" and TO_PRACT_ID is null and TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ?)");
			}
		}
		else
		{	
			// IN067543 Start.
			if(isRefPatientListAppl)
			{ 				
				sql.append("AND (TO_PRACT_ID = ? or TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ?))" );	
	        
			}else
			{
			// IN067543	End.
              sql.append(" AND (TO_PRACT_ID = ? or (TO_PRACT_ID is null and TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? )) ) " );
			}
		}	
		//IN064836 start
		/*if(closed.equals("N") && open.equals("N"))
			sql.append(" AND 1=2 ");
		else if(closed.equals("Y") && open.equals("Y"))
			sql.append(" AND STATUS IN ('C','O') ");
		else if(closed.equals("Y"))
			sql.append(" AND STATUS IN ('C') ");
		else if(open.equals("Y"))
			sql.append(" AND STATUS IN ('O') ");*/
		if(referralRegister)
		{
			if("O".equals(refStatus))
				sql.append(" AND STATUS = 'O'");
			else if("C".equals(refStatus))
				sql.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'C' ");
			else if("N".equals(refStatus))
				sql.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'N' ");
			/*else if("P".equals(refStatus))
				sql.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'P' ");*/
			else if("S".equals(refStatus))
				sql.append(" AND STATUS = 'C' AND BEDSIDE_REF_REVIEW_STATUS = 'S' ");
			else if("X".equals(refStatus))
				sql.append(" AND STATUS = 'X' AND BEDSIDE_REF_REVIEW_STATUS = 'X' ");
		}
		else
		{
			if("O".equals(refStatus))
				sql.append(" AND STATUS IN ('O') ");
			else if("Z".equals(refStatus))
				sql.append(" AND STATUS IN ('C') ");
			else if("A".equals(refStatus))
				sql.append(" AND STATUS IN ('C','O') ");
		}
		//IN064836 ends

		if(pendingRef.equals("N"))
			sql.append(" AND ( BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID IS NOT NULL ) ");

		sql.append(" ) A , MP_PATIENT B , PR_ENCOUNTER C WHERE B.PATIENT_ID = A.PATIENT_ID AND C.FACILITY_ID(+) = A.FACILITY_ID AND C.ENCOUNTER_ID(+) = A.ENCOUNTER_ID /*and (NVL (c.adt_status, '01') IN ('07', '08') or nvl(c.visit_status,'01') between '01' and '08'*/ ");

		if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM") || groupByEpisode.equals("Y"))
		{
			sql.append(" AND C.PATIENT_CLASS = ? ");
		}

		if((!locationCode.equals("*ALL") && !locationCode.equals("")) || groupByLocn.equals("Y"))
			sql.append(" AND C.ASSIGN_CARE_LOCN_CODE(+)  = ? ");

		if(!patientId.equals(""))
			sql.append(" AND A.PATIENT_ID  = ? ");
		
		sql.append("AND 'N'=CA_GET_RESTRICTED_PATIENTS_YN(?,c.patient_id,c.facility_id) ");//32902

		
		String desc="";
		if(reOrder.equals("2"))
		{
			desc=" desc";

		}
		if(orderBy.equals("PC"))
		{
			sql.append(" Order By PATIENT_CLASS ");
			sql.append(desc);
		}
		else if(orderBy.equals("LOC"))
		{
			sql.append(" order By LOCATION_DETAILS ");
			sql.append(desc);
		}
		else if(orderBy.equals("PN"))
		{
			sql.append(" order By PATIENT_NAME ");
			sql.append(desc);
		}
		else if(orderBy.equals("AGE"))
		{
			if(reOrder.equals("1"))
			{
				sql.append(" order By actual_dob desc ");
			}
			else
			{
				sql.append(" order By actual_dob ");
			}
		}
		else if(orderBy.equals("SEX"))
		{
			sql.append(" order By sex ");
			sql.append(desc);
		}
		else if(orderBy.equals("PID"))
		{
			sql.append(" order By PATIENT_ID ");
			sql.append(desc);
		}
		else if(orderBy.equals("AD"))
		{
			sql.append(" order By VISIT_ADM_DATE_TIME ");
			sql.append(desc);
		}
		else if(orderBy.equals("RS"))
		{
			sql.append(" order By STATUS ");
			sql.append(desc);
		}
		else if(orderBy.equals("BN"))
		{
			sql.append(" order By BED_NO ");
			sql.append(desc);
		}
		else if(orderBy.equals("RID"))
		{
			sql.append(" order By referral_id ");
			sql.append(desc);
		}
		else if(orderBy.equals("AP"))
		{
			sql.append(" order By attend_pract_name ");
			sql.append(desc);
		}
		else if(orderBy.equals("DD"))
		{
			sql.append(" order By C.DISCHARGE_DATE_TIME");
			sql.append(desc);
		}
		else if(orderBy.equals("RN"))
		{
			sql.append(" order By ROOM_NO");
			sql.append(desc);
		}
		
		
		pstmt = con.prepareStatement(sql.toString());

		int count = 0;
		/*out.println("clinicianId"+clinicianId+"<BR>");
		out.println("locale"+locale+"<BR>");
		out.println("facility_id"+facility_id+"<BR>");
		out.println("clinicianId"+clinicianId+"<BR>");
		out.println("fromDate"+fromDate+"<BR>");
		out.println("toDate"+toDate+"<BR>");
		out.println("locationType"+locationType+"<BR>");
		out.println("locn_type"+locn_type+"<BR>");
		out.println("locationCode"+locationCode+"<BR>");
		out.println("loc_code"+loc_code+"<BR>");
		out.println("patientId"+patientId+"<BR>");*/


		pstmt.setString(++count,clinicianId);
		pstmt.setString(++count,locale);
		pstmt.setString(++count,locale);
		pstmt.setString(++count,locale);
		pstmt.setString(++count,facility_id);
		pstmt.setString(++count,fromDate);
		pstmt.setString(++count,toDate);

		if(unAssigned.equals("Self"))
			pstmt.setString(++count,clinicianId);
		else if(unAssigned.equals("Unassigned"))
		{
			// IN067543
			if(isRefPatientListAppl){
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,clinicianId);
			}else{
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,facility_id);
				pstmt.setString(++count,clinicianId);
			}
		}
		else
		{
			// IN067543
			if(isRefPatientListAppl){
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,clinicianId);
			}else{
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,facility_id);
				pstmt.setString(++count,clinicianId);
			}
		}

		if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM"))
			pstmt.setString(++count,locationType);
		else if(groupByEpisode.equals("Y"))
			pstmt.setString(++count,locn_type);
		
		if(!locationCode.equals("*ALL") && !locationCode.equals(""))
			pstmt.setString(++count,locationCode);
		else if(groupByLocn.equals("Y"))
			pstmt.setString(++count,loc_code); 

		if(!patientId.equals(""))
			pstmt.setString(++count,patientId);
			
		pstmt.setString(++count,clinicianId);//32902

		if(groupByEpisode.equals("N") || groupByLocn.equals("N"))
		{
			
			rs = pstmt.executeQuery();
			while(rs.next())
				maxNoRecords += 1;
		}
		if(rs!=null)rs.close();


/*		out.println("<BR>");
		out.println("locationType ="+locationType+"=<BR>");
		out.println("loc_code ="+loc_code+"=<BR>");
		out.println("clinicianId ="+clinicianId+"=<BR>");*/

		int start   = 0 ;
		int end     = 0 ;
		int iterate = 1 ;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt(from) ; 

		if ( to == null )
			end = 11 ;
		else
			end = Integer.parseInt(to) ;

		if(isScroll)
		{
			if (!(start <= 1))
			{
%>
				<script>
					document.getElementById('previous').innerHTML = "<a href=`javascript:onClick=navigate('<%=(start-11)%>','<%=(end-11)%>')`title='Previous'  value=' Previous  ' class='gridLink'><%=prev%></a>";
				</script>
<%
			}
			if ( !( (start+11) > maxNoRecords ) )
			{
%>
				<script>
					document.getElementById('next').innerHTML = "<a href=`javascript:onClick=navigate('<%=(start+11)%>','<%=(end+11)%>')`title='Next' value=' next  ' class='gridLink'><%=next%></a>";
				</script>
<%
			}
		}
		else
		{
%>
			<script>
				document.getElementById('previous').innerHTML="";
			</script>
<%
		}

		rs = pstmt.executeQuery();

		if(isScroll)
		{
			if ( start != 1 )
			{
				for( int j=1; j<start;j++ )
				{
					rs.next() ;
					iterate++;
				}
			}
		}

		if(groupByEpisode.equals("N") && groupByLocn.equals("N"))
		{
			
			//out.println("first Query -----------"+sql.toString()+"-----<BR>");
			String status = null;
			String emergencyYn = null;
			String deceasedYn = null;
			String relationYn = null;
			String className = null;
			String className1 = null;
			String text = null;
			String disp_cls_cons_date = null;
  			StringTokenizer st = null;
			String n = null;           
            boolean header = false;
			String ca_ref_letter_notes_rec_yn = null; //ML-MMOH-CRF-0362 [IN057201]
			while( rs.next() && iterate <= end )
			{
				flag = false;
				iterate++ ;
			
				if(header == false)
				{
%>
				<tr>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th nowrap><a id='a01'   href="javascript:callForOrderByLoc('PC');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a02'   href="javascript:callForOrderByLoc('LOC');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a03'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a04'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a05'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a06'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a07'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a08'  href="javascript:callForOrderByLoc('RS');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a09'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'>
							<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a10' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a11'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a12'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a13'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
				<th nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
				</tr>
<%
				header = true;
				i++;
				}
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";*/

				
				emergencyYn = "";
				deceasedYn = "";
				int noofchildren = 0;
				relationYn = "";
				className = rowclass;
				className1 = rowclass;
				text = "&nbsp;&nbsp;&nbsp;";
				disp_cls_cons_date = "&nbsp;";
				bedside_ref_review_status = rs.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rs.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
				bedside_referral_YN			= rs.getString("BEDSIDE_REFERRAL_YN") == null ? "" : rs.getString("BEDSIDE_REFERRAL_YN"); //added for IN064836
				patient_status	= rs.getString("patient_status") == null ? "" : rs.getString("patient_status");
				episode_type_desc = rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				//out.println("episode_type_desc"+episode_type_desc);
				//out.println("patient_status"+patient_status);
				sex = rs.getString("sex")==null?"":rs.getString("sex");
				status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
				enctr_id = rs.getString("EPISODE_ID")== null ? "" : rs.getString("EPISODE_ID");
				ca_ref_letter_notes_rec_yn = rs.getString("CA_REF_LETTER_NOTES_REC_YN") ==  null ? "":rs.getString("CA_REF_LETTER_NOTES_REC_YN"); // ML-MMOH-CRF-0362 [IN057201]	
				restPatientYN = rs.getString("restrict_reinstate_yn")== null ? "" : rs.getString("restrict_reinstate_yn");//32902
				if(episode_type_desc.equals("OP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("Male") )
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equals("F") || sex.equals("Female"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex.equals("U") || sex.equals("Unknown"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				//IN064836 start			
				if(!referralRegister)
				{
					if(status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
					else if(status.equals("O"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}
				else
				{
					if(status.equals("C") && bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
					else if(status.equals("O") && bedside_ref_review_status.equals(""))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
					else if(status.equals("C") && bedside_referral_YN.equals("N"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
				}
				if(status.equals("P"))//IN064836 ends
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReferrals.label","ca_labels");
				else if(status.equals("U"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
				//IN064836 start
				else if(status.equals("X"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
				//IN064836 ends
				// added for IN048463 - Start
				if(allow_muti_bedside_review_yn.equals("Y")){
					if(bedside_ref_review_status.equals("P") && !status.equals("P"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
					else if(bedside_ref_review_status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
					else if(bedside_ref_review_status.equals("N")) // IN052595 
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595	
				//IN064836 start
					else if(bedside_ref_review_status.equals("X"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
					else if(bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
				//IN064836 ends
				}
				// added for IN048463 - End
				st = new StringTokenizer(patient_status,"|");
	
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				if(!( rs.getString("DISCHARGE_DATE_TIME") == null))
					if( !rs.getString("DISCHARGE_DATE_TIME").equals(""))
						className = "DISCHARGED";
				if(deceasedYn.equals("D"))
				{
					className = "CADECEASED";
					rowclass = "DECEASED1";
					decesedColor = "";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor = "";
				}
				else
				{
					decesedColor = "";
				}
				if(noofchildren > 0) 
					className = "NEWBORN";
				emergencyYn = rs.getString("PRIORITY_ZONE")==null?"":rs.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y"))
				{
				if(!emergencyYn.equals(""))
					className1 = rs.getString("ae_zone_color")==null?"":rs.getString("ae_zone_color");
				}else{
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End
				if(relnreqyn.equals("Y"))
				{
					if(relationYn.equals("N"))
						text = "<font size=2><b>*</b></font>";
				}
				if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					layer = new StringBuffer();
					
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rs.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rs.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						while(rsMotherLink.next())
						{
							if(locale.equals("en"))
	                       {
		                     dateofbirth1=rsMotherLink.getString("date_of_birth");
	                       }
	                      else
	                      {
		                   dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                      }
							apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
						}
						if(rsMotherLink!=null) rsMotherLink.close();
					}
				}
				//String s=rs.getString("EPISODE_ID");
				//String location = rs.getString("EPISODE_ID")==null?"":rs.getString("EPISODE_ID");
				
				out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rs.getString("QRYTIME")+ "</b>'}</script>");
				String location_details=rs.getString("LOCATION_DETAILS")==null?"":rs.getString("LOCATION_DETAILS");
				out.println("<script>babyDetails["+rs.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rs.getString("EPISODE_ID")+"]=\""+rs.getString("PATIENT_NAME")+"\";</script>");
				
                out.println("<tr>");
				if(!enctr_id.equals(""))
				{
				/*IN034999 starts */
				/*out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");*/
				out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"','"+rs.getString("FACILITY_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");
				/* IN034999 ends */
				}
				else
				{
				out.println("<td class='gridData'></td>");

				}
				//IN044157 - Start		
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt; width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td><td class='"+rowclass+"' nowrap><font size=1>"+episode_type_desc+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+location_details+"</font></td>");
				
				//IN065452 start
				if("R".equals(pendingRef) && "Self".equals(unAssigned))
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}
				//if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				else if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				//IN065452 ends	
				{
					//[IN030566] Starts
					out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rs.getString("patient_id")+"')\" class='gridLink'><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick('"+i+"')\" class='gridLink'><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");					
					//[IN030566] Ends
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}

				//out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>"); // commented for   ML-MMOH-CRF-0362 [IN057201]
				//   ML-MMOH-CRF-0362 [IN057201] - Start
				if("Y".equals(ca_record_referral_note_yn)) {
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
					//if("Y".equals(ca_ref_letter_notes_rec_yn)){
					else if("Y".equals(ca_ref_letter_notes_rec_yn)){
					//IN065452 ends
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font>&nbsp;<a class='gridLink' href=\"javascript:getRefClinicalNotes('"+rs.getString("patient_id")+"','"+enctr_id+"','"+rs.getString("PATIENT_CLASS")+"','"+facility_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
				}else{
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
					else{
					//IN065452 ends
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}//IN065452
				}
				//   ML-MMOH-CRF-0362 [IN057201] - End
				//if(rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))//IN047927
				if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned) && !("Unassigned".equals(status))){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					else if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					//IN065452 ends	
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else				
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 ends
				} else { // added for IN048463 - Start
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned) && !("Unassigned".equals(status))){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					else if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					//IN065452 ends
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 ends
					
					// added for IN048463 - End
					
				}
					
                out.println("<script language='javascript'>");
                out.println("episodeIdArr["+i+"]='"+rs.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rs.getString("patient_class")+"';");
				out.println("</script>");
%>
				<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value='<%=rs.getString("patient_id")%>'>
				<input type="hidden" name="referral_id<%=i%>" id="referral_id<%=i%>" value='<%=rs.getString("referral_id")%>'>
				<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value='<%=rs.getString("ASSIGN_CARE_LOCN_CODE")%>'>
				<input type="hidden" name="practitioner_Id<%=i%>" id="practitioner_Id<%=i%>" value='<%=rs.getString("ATTEND_PRACTITIONER_ID")%>'>
				<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value='<%=rs.getString("sex")%>'>
				<input type="hidden" name="unAssigned_yn<%=i%>" id="unAssigned_yn<%=i%>" value='<%=rs.getString("unAssigned_yn")%>'>
				<input type="hidden"  id="restPatientYN<%=i%>" name="restPatientYN<%=i%>" value='<%=rs.getString("restrict_reinstate_yn")%>'><!-- 32902 -->
			     <input type="hidden" id="accessRightsViewPatient" name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!-- 32902 -->
							
<%
			    i++;
			    k++;
			}
			if(rs!=null) rs.close();
			if(stmtMotherLink!=null) stmtMotherLink.close();
			}
				
			else if(groupByEpisode.equals("Y") && groupByLocn.equals("N"))
			{
				String status = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;
				String disp_cls_cons_date = null;
  				StringTokenizer st = null;
				String n = null;           
				boolean header = false;
				String ca_ref_letter_notes_rec_yn = null; //ML-MMOH-CRF-0362 [IN057201]
				while(rs.next())
				{
				flag = false;
				iterate++ ;
			
				if(header == false)
				{
%>
				<tr>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th nowrap><a id='a01'   href="javascript:callForOrderByLoc('LOC');" onclick='changeColor(this);' style='color:white' >
							<fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a02'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a03'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a04'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a05'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a06'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a07'  href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a08'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'>
							<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a09' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a10'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a11'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a12'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
				<th nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
				</tr>
<%
				header = true;
				i++;
				}
				if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";

				
				emergencyYn = "";
				deceasedYn = "";
				int noofchildren = 0;
				relationYn = "";
				className = rowclass;
				className1 = rowclass;
				text = "&nbsp;&nbsp;&nbsp;";
				disp_cls_cons_date = "&nbsp;";
				bedside_ref_review_status 	= rs.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rs.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
				bedside_referral_YN			= rs.getString("BEDSIDE_REFERRAL_YN") == null ? "" : rs.getString("BEDSIDE_REFERRAL_YN"); //added for IN064836
				patient_status	= rs.getString("patient_status") == null ? "" : rs.getString("patient_status");
				episode_type_desc = rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				
				sex = rs.getString("sex")==null?"":rs.getString("sex");
				status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
				enctr_id = rs.getString("EPISODE_ID")== null ? "" : rs.getString("EPISODE_ID");
				ca_ref_letter_notes_rec_yn = rs.getString("CA_REF_LETTER_NOTES_REC_YN") ==  null ? "":rs.getString("CA_REF_LETTER_NOTES_REC_YN"); // ML-MMOH-CRF-0362 [IN057201]
				if(episode_type_desc.equals("OP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("Male") )
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equals("F") || sex.equals("Female"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex.equals("U") || sex.equals("Unknown"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				//IN064836 start
				if(!referralRegister)
				{
					if(status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
					else if(status.equals("O"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}
				else
				{
					if(status.equals("C") && bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
					else if(status.equals("O") && bedside_ref_review_status.equals(""))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
					else if(status.equals("C") && bedside_referral_YN.equals("N"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
				}
				if(status.equals("P"))//IN064836 ends
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReferrals.label","ca_labels");
				else if(status.equals("U"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
				//IN064836 start
				else if(status.equals("X"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
				//IN064836 ends
					
				// added for IN048463 - Start
				if(allow_muti_bedside_review_yn.equals("Y")){
					if(bedside_ref_review_status.equals("P") && !status.equals("P"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
					else if(bedside_ref_review_status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
					else if(bedside_ref_review_status.equals("N")) // IN052595 
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595	
					//IN064836 start
					else if(bedside_ref_review_status.equals("X"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels");
					//IN064836 ends
				}
				// added for IN048463 - End
				st = new StringTokenizer(patient_status,"|");
	
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				if(!( rs.getString("DISCHARGE_DATE_TIME") == null))
					if( !rs.getString("DISCHARGE_DATE_TIME").equals(""))
						className = "DISCHARGED";
				if(deceasedYn.equals("D"))
				{
					className = "CADECEASED";
					rowclass = "DECEASED1";
					decesedColor = "";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor = "";
				}
				else
				{
					decesedColor = "";
				}
				if(noofchildren > 0) 
					className = "NEWBORN";
				emergencyYn = rs.getString("PRIORITY_ZONE")==null?"":rs.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y"))
				{
				if(!emergencyYn.equals(""))
					className1 = rs.getString("ae_zone_color")==null?"":rs.getString("ae_zone_color");
				}else{
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End
				if(relnreqyn.equals("Y"))
				{
					if(relationYn.equals("N"))
						text = "<font size=2><b>*</b></font>";
				}
				if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					layer = new StringBuffer();
					
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rs.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rs.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						while(rsMotherLink.next())
						{
							if(locale.equals("en"))
	                        {
		                      dateofbirth1=rsMotherLink.getString("date_of_birth");
	                        }
	                       else
	                       {
		                    dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                       }
							apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
						}
						if(rsMotherLink!=null) rsMotherLink.close();	
					}
					
				}


				out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rs.getString("QRYTIME")+ "</b>'}</script>");
				out.println("<script>babyDetails["+rs.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rs.getString("EPISODE_ID")+"]=\""+rs.getString("PATIENT_NAME")+"\";</script>");
				
               
				out.println("<tr>");
				if(!enctr_id.equals(""))
				{
				/* IN034999 starts */
				/*out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");*/
				
				out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"','"+rs.getString("FACILITY_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");
				/* IN034999 ends */
				
				}
				else
				{
				out.println("<td class='gridData'></td>");

				}
				//IN044157 - Start		
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt; width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("LOCATION_DETAILS")+"</font></td>");
				
				if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				{
					//[IN030566] Starts
					out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rs.getString("patient_id")+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//[IN030566] Ends
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}
				
				//out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>"); // commented for ML-MMOH-CRF-0362 [IN057201]
				//   ML-MMOH-CRF-0362 [IN057201] - Start
				if("Y".equals(ca_record_referral_note_yn)) {
					if("Y".equals(ca_ref_letter_notes_rec_yn)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font>&nbsp;<a class='gridLink' href=\"javascript:getRefClinicalNotes('"+rs.getString("patient_id")+"','"+enctr_id+"','"+rs.getString("PATIENT_CLASS")+"','"+facility_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
				}else{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
				}
				//   ML-MMOH-CRF-0362 [IN057201] - End
				//if(rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))//IN047927
				if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\">");
	%>
						<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 ends
				} else { // added for IN048463 - Start
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 ends
				} // added for IN048463 - End
				
                out.println("<script language='javascript'>");
                out.println("episodeIdArr["+i+"]='"+rs.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rs.getString("patient_class")+"';");
				out.println("</script>");
%>
				<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value='<%=rs.getString("patient_id")%>'>
				<input type="hidden" name="referral_id<%=i%>" id="referral_id<%=i%>" value='<%=rs.getString("referral_id")%>'>
				<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value='<%=rs.getString("ASSIGN_CARE_LOCN_CODE")%>'>
				<input type="hidden" name="practitioner_Id<%=i%>" id="practitioner_Id<%=i%>" value='<%=rs.getString("ATTEND_PRACTITIONER_ID")%>'>
				<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value='<%=rs.getString("sex")%>'>
				<input type="hidden" name="unAssigned_yn<%=i%>" id="unAssigned_yn<%=i%>" value='<%=rs.getString("unAssigned_yn")%>'>
<%
			    i++;
			    k++;
			}
			if(rs!=null) rs.close();
			if(stmtMotherLink!=null) stmtMotherLink.close();

			}
			else if(groupByEpisode.equals("Y") && groupByLocn.equals("Y"))
			{
				String status = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;
				String disp_cls_cons_date = null;
  				StringTokenizer st = null;
				String n = null;           
				boolean header = false;
				String ca_ref_letter_notes_rec_yn = null; //ML-MMOH-CRF-0362 [IN057201]
				while(rs.next())
				{
				flag = false;
				iterate++ ;
			
				if(header == false)
				{
%>
				<tr>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th nowrap><a id='a01'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a02'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a03'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a04'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a05'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a06'  href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a07'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'>
							<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a08' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a09'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a10'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a11'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
				<th nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
				</tr>
<%
				header = true;
				i++;
				}
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/

				
				emergencyYn = "";
				deceasedYn = "";
				int noofchildren = 0;
				relationYn = "";
				className = rowclass;
				className1 = rowclass;
				text = "&nbsp;&nbsp;&nbsp;";
				disp_cls_cons_date = "&nbsp;";

				bedside_ref_review_status = rs.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rs.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
				bedside_referral_YN			= rs.getString("BEDSIDE_REFERRAL_YN") == null ? "" : rs.getString("BEDSIDE_REFERRAL_YN"); //added for IN064836 
				patient_status	= rs.getString("patient_status") == null ? "" : rs.getString("patient_status");
				episode_type_desc = rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				sex = rs.getString("sex")==null?"":rs.getString("sex");
				status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
				enctr_id = rs.getString("EPISODE_ID")== null ? "" : rs.getString("EPISODE_ID");
				ca_ref_letter_notes_rec_yn = rs.getString("CA_REF_LETTER_NOTES_REC_YN") ==  null ? "":rs.getString("CA_REF_LETTER_NOTES_REC_YN"); // ML-MMOH-CRF-0362 [IN057201]
				if(episode_type_desc.equals("OP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("Male") )
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equals("F") || sex.equals("Female"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex.equals("U") || sex.equals("Unknown"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				//IN064836 start
				if(!referralRegister)
				{
					if(status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
					else if(status.equals("O"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}
				else
				{
					if(status.equals("C") && bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
					else if(status.equals("O") && bedside_ref_review_status.equals(""))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
					else if(status.equals("C") && bedside_referral_YN.equals("N"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
				}
				if(status.equals("P"))//IN064836 ends
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReferrals.label","ca_labels");
				else if(status.equals("U"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
				//IN064836 start
				else if(status.equals("X"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
				//IN064836 ends

				// added for IN048463 - Start
				if(allow_muti_bedside_review_yn.equals("Y")){
					if(bedside_ref_review_status.equals("P") && !status.equals("P"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
					else if(bedside_ref_review_status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
					else if(bedside_ref_review_status.equals("N")) // IN052595 
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595	
					//IN064836 start
					else if(bedside_ref_review_status.equals("X"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels");
					//IN064836 ends
				}
				// added for IN048463 - End
				if(rs.getString("unAssigned_yn").equals("N"))
					title = "Speciality Specific Patient (Unassigned)";
				else
					title = "";
					
				st = new StringTokenizer(patient_status,"|");
	
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				if(!( rs.getString("DISCHARGE_DATE_TIME") == null))
					if( !rs.getString("DISCHARGE_DATE_TIME").equals(""))
						className = "DISCHARGED";
				if(deceasedYn.equals("D"))
				{
					className = "CADECEASED";
					rowclass = "DECEASED1";
					decesedColor = "";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor = "";
				}
				else
				{
					decesedColor = "";
				}
				if(noofchildren > 0) 
					className = "NEWBORN";
				emergencyYn = rs.getString("PRIORITY_ZONE")==null?"":rs.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y"))
				{
				if(!emergencyYn.equals(""))
					className1 = rs.getString("ae_zone_color")==null?"":rs.getString("ae_zone_color");
				}else{
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End
				if(relnreqyn.equals("Y"))
				{
					if(relationYn.equals("N"))
						text = "<font size=2><b>*</b></font>";
				}
				if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					layer = new StringBuffer();
					
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rs.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rs.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						while(rsMotherLink.next())
						{
							if(locale.equals("en"))
	                        {
		                      dateofbirth1=rsMotherLink.getString("date_of_birth");
	                        }
	                       else
	                       {
		                      dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                       }
							apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
						}
						if(rsMotherLink!=null) rsMotherLink.close();
					}
					
				}
				out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rs.getString("QRYTIME")+ "</b>'}</script>");
				out.println("<script>babyDetails["+rs.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rs.getString("EPISODE_ID")+"]=\""+rs.getString("PATIENT_NAME")+"\";</script>");
				                
				out.println("<tr>");
				if(!enctr_id.equals(""))
				{
				/* IN034999 starts */
				/*out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");*/
				out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"','"+rs.getString("FACILITY_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");
				/* IN034999 ends */
				}
				else
				{
				out.println("<td class='gridData'></td>");

				}
				//IN044157 - Start		
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt; width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
				
				if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				{
					//[IN030566] Starts
					out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rs.getString("patient_id")+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap><font size=1><a href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//[IN030566] Ends
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}
				
				//out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>"); // commented for ML-MMOH-CRF-0362 [IN057201]
				//   ML-MMOH-CRF-0362 [IN057201] - Start
				if("Y".equals(ca_record_referral_note_yn)) {
					if("Y".equals(ca_ref_letter_notes_rec_yn)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font>&nbsp;<a class='gridLink' href=\"javascript:getRefClinicalNotes('"+rs.getString("patient_id")+"','"+enctr_id+"','"+rs.getString("PATIENT_CLASS")+"','"+facility_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
				
				}else{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
				}
				//   ML-MMOH-CRF-0362 [IN057201] - End
				//if(rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))//IN047927
				if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
	%>
						<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 ends
				} else { // added for IN048463 - Start
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	%>
						<fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/>
	<%
						out.println("</a></font></td>");
					}
					//IN064836 ends
				} // added for IN048463 - End
				
                out.println("<script language='javascript'>");
                out.println("episodeIdArr["+i+"]='"+rs.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rs.getString("patient_class")+"';");
				out.println("</script>");
%>
				<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value='<%=rs.getString("patient_id")%>'>
				<input type="hidden" name="referral_id<%=i%>" id="referral_id<%=i%>" value='<%=rs.getString("referral_id")%>'>
				<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value='<%=rs.getString("ASSIGN_CARE_LOCN_CODE")%>'>
				<input type="hidden" name="practitioner_Id<%=i%>" id="practitioner_Id<%=i%>" value='<%=rs.getString("ATTEND_PRACTITIONER_ID")%>'>
				<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value='<%=rs.getString("sex")%>'>
				<input type="hidden" name="unAssigned_yn<%=i%>" id="unAssigned_yn<%=i%>" value='<%=rs.getString("unAssigned_yn")%>'>
<%
			    i++;
			    k++;
			}
			if(rs!=null) rs.close();
			if(stmtMotherLink!=null) stmtMotherLink.close();
			}
			
		
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		
		if(rs != null ) rs.close();
		if(pstmt != null) pstmt.close();
%>
		</table>
		<input type="hidden" name="patient_class" id="patient_class" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="unAssigned_yn" id="unAssigned_yn" value="">
		<input type="hidden" name="referral_id" id="referral_id" value="">
		<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
		<input type="hidden" name="locationType" id="locationType" value="<%=locationType%>">
		<input type="hidden" name="locationCode" id="locationCode" value="<%=locationCode%>">
		<!-- <input type="hidden" name="fromDate" id="fromDate" value="<%=fromDate%>">//IN28273
		<input type="hidden" name="toDate" id="toDate" value="<%=toDate%>"> -->
		<input type="hidden" name="groupByLocn" id="groupByLocn" value="<%=groupByLocn%>">
		<input type="hidden" name="groupByEpisode" id="groupByEpisode" value="<%=groupByEpisode%>">
		<input type="hidden" name="unAssigned" id="unAssigned" value="<%=unAssigned%>">
		<input type="hidden" name="pendingRef" id="pendingRef" value="<%=pendingRef%>">
		<!--IN064836 start-->
		<!--<input type="hidden" name="closed" id="closed" value="<%=closed%>">
		<input type="hidden" name="open" id="open" value="<%=open%>">-->
		<input type="hidden" name="refStatus" id="refStatus" value="<%=refStatus%>">
		<input type="hidden" name="refRegSiteYN" id="refRegSiteYN" value="<%=refRegSiteYN%>">
		<!--IN064836 ends-->
		<input type="hidden" name="reln_req_yn" id="reln_req_yn" value="<%=relnreqyn%>">
		<input type="hidden" name="mode" id="mode" value="navigate">
		<input type="hidden" name="from" id="from" value="">
		<input type="hidden" name="to" id="to" value="">
		<input type="hidden" name="form" id="form" value="ReferralList">
		<input type="hidden" name="function_id" id="function_id" value='<%=request.getParameter("function_id")%>'>
		<input type="hidden" name="loc_code" id="loc_code" value='<%=loc_code%>'>
		<input type="hidden" name="locn_type" id="locn_type" value='<%=locn_type%>'>
		</form>
		<div id='motherLink' style='position:absolute; visibility:hidden;overflow:overflow'></div>
<%
		if(!anchorID.equals(""))
		{
%>
		<script>
			if('<%=leftScrolling%>'!='')
			{
				document.body.scrollLeft='<%=leftScrolling%>';
			}
			if('<%=anchorID%>'!='')
			{
				for(i=0;i<document.anchors.length;i++)
				{
					document.anchors(i).style.color='white';

				}
				if('<%=reOrder%>'=='1')
					document.getElementById(<%=anchorID%>).style.color='pink';
				else if('<%=reOrder%>'=='2')
					document.getElementById(<%=anchorID%>).style.color='yellow';
			}
		</script>
<%
		}
		putObjectInBean(bean_id,bean,session);
	}
	catch(Exception e)
	{
		
		//out.println("Exception in ReferralPatListResult.jsp ------"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>

	
    

