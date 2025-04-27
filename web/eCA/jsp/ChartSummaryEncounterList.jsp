<!DOCTYPE html>
<%  
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.
21/03/2014		IN047977		Nijitha			AAKH-SCF-0106												
21/03/2014	 	IN034513	  	Vijayakumar K 							SS-CRF-0007 In the patient Chart Clinician Access, 
23/04/2014		IN048730		Vijayakumar K							SS-CRF-0007/01 - Only 13 Encounter Details are only displayed																	
23/04/2014		IN048732		Vijayakumar K							ALPHA- CA- Cancelled Admission Record displayed in Encounter Widget
16/06/2014  	IN049663		 Nijitha		HSA_ADHOC_0010
10/01/2017		IN062564		Raja S			12/01/2017		Ramesh G			MO-GN-5511
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*, java.text.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN049663
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
%>
		<title><%=title%></title><!--[IN035950]-->
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
        <script language='javascript' src='../../eCommon/js/common.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
		
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!-- <script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<form name=chartsummary>
<%
	
	Connection conn= null;
	PreparedStatement pstmt =null;
	ResultSet rs	 =null;
	String patientid=request.getParameter("patient_id");
	String Encounter_Id=request.getParameter("episode_id");
	//[IN035950] Starts
	String patient_class = request.getParameter("p_encounter");
	if ("null".equals(patient_class) || patient_class==" ") patient_class="";
	//[IN035950] Ends
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	//IN034513 starts	
	String querySpltycode = "select SPECIALTY_CODE service_code from pr_encounter where facility_id=? and encounter_id=?"; //IN034513
	String queryCAWidgetPrm = "SELECT ENC_GRP_BY_SPLTY_YN FROM CA_WIDGET_PARAM"; //IN034513
	String enc_grp_by_splty_yn = "";
	String service_code = "";
	String encounter_id_for_grping = request.getParameter("encounter_id");
	String facilityId_for_grping =	(String)session.getValue( "facility_id" );
	String Sql="";
	String pre_service_ind	=	"*";
	String service_ind = "";
	//IN034513 ends	
	try
	{
		boolean rsval= true;

	String visitdate="",from_date=null,to_date=null;
	String Details ="";

	
	String encounter_dtls1 = "",encounter_dtls2 = "",encounter_dtls="";
	String facilityId = "";
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id == null)resp_id ="";
	String linkFlag="";
	String privilegeStatus=""; //IN062564
	String relnId = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id"); //IN062564
	conn = ConnectionManager.getConnection(request);
	  //reason_for_contact
	 //IN034513 starts
	try
	{
		pstmt = conn.prepareStatement(queryCAWidgetPrm);
		rs = pstmt.executeQuery();
		 while(rs.next())
		{
			enc_grp_by_splty_yn = rs.getString("ENC_GRP_BY_SPLTY_YN");
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
			
		
	}catch(Exception excawidget)
	{
	excawidget.printStackTrace();
	}
	//IN034513 ends	
	//IN062564 starts
	try
	{
		
		pstmt = conn.prepareStatement("SELECT DFLT_PRIVILEGE_STATUS FROM CA_APPL_TASK WHERE APPL_TASK_ID='FLOW_SHEET'");
		rs = pstmt.executeQuery();
		 while(rs.next())
		{
			 privilegeStatus = rs.getString("DFLT_PRIVILEGE_STATUS");
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
			
		
	}catch(Exception apptskawidget)
	{
		apptskawidget.printStackTrace();
	}
	//IN062564 Ends


	 //String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','O','EM','O','I') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,GET_TASK_APPLICABILITY('FLOW_SHEET',null,?,null) link_flag from pr_encounter_VW a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16)order by visit_adm_date_time desc ";
	   //String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','O','EM','O','I') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16)order by visit_adm_date_time desc ";//IN035950
	   //String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";//IN035950
		//IN034513 starts
		//String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter and (visit_status != '99' or visit_status is null) order by visit_adm_date_time desc ";//IN047977		
		if("Y".equals(enc_grp_by_splty_yn))
		{
			try
			{
				pstmt = conn.prepareStatement(querySpltycode);
				pstmt.setString(1, facilityId_for_grping);
				pstmt.setString(2, encounter_id_for_grping);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					service_code = rs.getString("service_code");
				}
				
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}catch(Exception exsplty)
			{
			exsplty.printStackTrace();
			}
			//IN048730 starts
			//Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter and (visit_status != '99' or visit_status is null) order by 1,visit_adm_date_time desc ";
			//IN048732 starts
			//Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null)) where RANK_NO <16) &&patient_class_filter  order by 1,visit_adm_date_time desc ";
			//IN048730 ends
			//Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter  order by 1,visit_adm_date_time desc "; //Commented for IN062564
			//IN048732 ends
			Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,Get_Task_Applicability('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+facilityId_for_grping+"','"+Encounter_Id+"','"+patientid+"') link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter  order by 1,visit_adm_date_time desc ";//Edited for IN062564
		}
		else
		{
			//IN048730 starts
			//Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter and (visit_status != '99' or visit_status is null) order by visit_adm_date_time desc ";//IN047977
			//IN048732 starts
			//Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null)) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";
			//IN048730 ends
			//Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";//Commented for IN062564
			//IN048732 ends
			Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,Get_Task_Applicability('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+facilityId_for_grping+"','"+Encounter_Id+"','"+patientid+"') link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";//Edited for IN062564
		}
		//IN034513 ends	
	//[IN035950] Starts
	   if((!"".equals(patient_class)) && (null!=patient_class)){
		   Sql=Sql.replace("&&patient_class_filter", " and a.patient_class =?");	
		}
		else{
			Sql=Sql.replace("&&patient_class_filter", "");
		}
	//[IN035950] End
	  pstmt = conn.prepareStatement(Sql);

	   pstmt.setString(1, locale);
	    pstmt.setString(2, locale);
	   pstmt.setString(3, locale);
	    pstmt.setString(4, locale);
	    pstmt.setString(5, locale);
		 pstmt.setString(6, locale);

	//  pstmt.setString(7, resp_id);
	  pstmt.setString(7, patientid);
	//  pstmt.setString(3, patientid);
	//[IN035950] Starts
	if((!"".equals(patient_class)) && (null!=patient_class)){
		System.out.println("ChartSummaryEncounterList.jsp:Line:83");
	  pstmt.setString(8, patient_class);
	}
	//[IN035950] Ends
	  rs = pstmt.executeQuery();
%>
	
<%
		 if (rsval==true)
		 {
%>
		<table border align='center' class='grid' width='100%'>
		<!-- IN034513 starts-->
		<%
		if(!("Y".equals(enc_grp_by_splty_yn)))
		{
		%>
		<!-- IN034513 ends-->
		<tr><td class='gridData'>Date</td><td class='gridData' nowrap>Patient Class</td><td class='gridData' ></td>	<!--[IN035950] Starts-->

		</tr>
<%
		} //IN034513 -- added
		int row=1;
      		String classValue="";

	        while(rs.next())
		{
		 try
		  {
		   if ( row%2 == 0 )
			classValue="QRYEVEN";
		   else
			classValue="QRYODD";

			visitdate=rs.getString("visit_date");

			if(visitdate == null)
				visitdate = "";

			visitdate = com.ehis.util.DateUtils.convertDate(visitdate,"DMY","en",locale);

			Details =rs.getString("Details");
			from_date = rs.getString("from_date");
			to_date = rs.getString("to_date");
			facilityId = rs.getString("facility_id")==null?"":rs.getString("facility_id");
			linkFlag = rs.getString("link_flag")==null?"X":rs.getString("link_flag");
			String patientclass = rs.getString("PATIENT_CLASS")==null?"&nbsp;":rs.getString("PATIENT_CLASS");
			Encounter_Id=rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
			encounter_dtls1 = rs.getString("Encounter_dtls1")==null?"":rs.getString("Encounter_dtls1");
			encounter_dtls2 = rs.getString("Encounter_dtls2")==null?"":rs.getString("Encounter_dtls2");
			if (Details==null)
			{
			    Details="&nbsp";
			}
			encounter_dtls = encounter_dtls1+encounter_dtls2;
			//IN034513 starts
			if("Y".equals(enc_grp_by_splty_yn))
			{
				service_ind		=	rs.getString("service_ind")==null?"":rs.getString("service_ind");
				if (!pre_service_ind.equals(service_ind))
				{
			%>
					<tr><td colspan=4 class=CAGROUP ><%=service_ind%></font></td> </tr>
					<tr><td class='gridData'>Date</td><td class='gridData' nowrap>Patient Class</td><td class='gridData' ></td>	</tr><!--[IN035950] Starts-->
			<% 
					pre_service_ind=service_ind;
				}
			}
			
			//IN034513 ends
			%>
			<tr title="<%=encounter_dtls%>"><td class='gridData'><%=visitdate%></td>
			<td  class='gridData'><%=patientclass%></td>
			<td  class='gridData'>
			<%if(linkFlag.equals("A")){%>	
				<a class='gridLink' href="javascript:showEncounterDialog('<%=Encounter_Id%>','<%=from_date%>','<%=to_date%>','<%=facilityId%>')"><%=Details%></a>
			<%}else{%>
				<!--  <%=Details%>  //Commented for IN062564 -->
				<a class='gridLink' href="javascript:alert(getMessage('FUNC_NOTAPP_RESP_RELN','CA'))"><%=Details%></a> <!-- Added for IN062564 -->
			<%}%>
			</td></tr>
			<%
			row++;
		}
		catch(Exception e)
		{
			//out.println("error"+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		 }
		}

		rsval=false;
%>
		</table>
<%
	       }
		else if (rsval==false)
	       {
%>
		<table border  align='center' class='grid' width='100%'  height='100%'>
		<tr>
		<td>&nbsp
		<br><br>
		<br><br>
		</td>
		</tr>
	        </table>
<%		}

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	}
	catch (Exception e)
	{
		//out.println("Errors have occured"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		
		if (conn != null) ConnectionManager.returnConnection(conn,request);
	}

%>
	<input type='hidden' name=patient_id value=<%=patientid%>>
	<input type='hidden' name=Encounter_Id value=<%=Encounter_Id%>>
	<input type='hidden' name=p_called_from_widget  id=p_called_from_widget value=<%=p_called_from%>><!--IN049663 -->
</form>
</body>
</html>

