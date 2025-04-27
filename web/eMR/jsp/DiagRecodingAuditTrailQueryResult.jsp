<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,com.ehis.util.*,java.text.*,webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../../eMR/js/QueryDiagRecodingAuditTrail.js' language='javascript'></script>	
	
	</head>

<%

String locale			= (String)session.getAttribute("LOCALE");
String facilityId		=	(String)session.getValue("facility_id");
request.setCharacterEncoding("UTF-8");
Connection con=null; 
Statement stmt=null;
ResultSet rset=null;  
String patient_id1="";
//String patient_id_prev="";
String classValue	 = "";
StringBuffer whereClause = new StringBuffer("");
String patient_id="";
String encounter_id="";
int andCheck=0;

int i=0;
String mr_diagnosis_code=request.getParameter("mr_diagnosis_code")==null?"":request.getParameter("mr_diagnosis_code");
if(mr_diagnosis_code == null) mr_diagnosis_code="";
String recodedfromdate=request.getParameter("recodedfromdate")==null?"":request.getParameter("recodedfromdate");

if(recodedfromdate == null) recodedfromdate="";
String recodedtodate=request.getParameter("recodedtodate")==null?"":request.getParameter("recodedtodate");
if(recodedtodate == null) recodedtodate="";
String mr_diagnosis_code1=request.getParameter("mr_diagnosis_code1")==null?"":request.getParameter("mr_diagnosis_code1");
if(mr_diagnosis_code1 == null) mr_diagnosis_code1="";
 patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
if(patient_id == null) patient_id=""; 
 encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
if(encounter_id == null) encounter_id="";
encounter_id=encounter_id.trim();
String update_by=request.getParameter("update_by")==null?"":request.getParameter("update_by");
if(update_by == null) update_by="";
//Newly added by Shyam on 17/09/2005
String location_hidden=request.getParameter("location_hidden")==null?"":request.getParameter("location_hidden");
if(location_hidden == null) location_hidden="";
String gender_val=request.getParameter("gender_val")==null?"":request.getParameter("gender_val");
if(gender_val == null) gender_val="";
String age_from=request.getParameter("age_from")==null?"":request.getParameter("age_from");
if(age_from == null) age_from="";
String age_to=request.getParameter("age_to")==null?"":request.getParameter("age_to");
if(age_to == null) age_to="";
String diagnosis_stage=request.getParameter("diagnosis_stage")==null?"":request.getParameter("diagnosis_stage");
if(diagnosis_stage == null) diagnosis_stage="";
String location_sel=request.getParameter("location_sel")==null?"":request.getParameter("location_sel");
if(location_sel == null) location_sel="";
String encounter_type_sel=request.getParameter("encounter_type_sel")==null?"":request.getParameter("encounter_type_sel");


if(encounter_type_sel == null) encounter_type_sel="";

try
{
	con =  ConnectionManager.getConnection(request); 
	
	if (!(mr_diagnosis_code == null || mr_diagnosis_code.equals("")) )
	{
		if(andCheck==0)
		{
			//whereClause modified on 8-3-2012 for the incident IN031056 - Begins
			whereClause.append(" and C.orig_term_code = '"+mr_diagnosis_code+"'");
			andCheck = 1;
		}
		else
		{
			whereClause.append(" and C.orig_term_code ='"+mr_diagnosis_code+"'");
		}
	}
	if (!(diagnosis_stage == null || diagnosis_stage.equals("")) )
	{
		if(andCheck==0)
		{
			whereClause.append("and D.encounter_id in (Select encounter_id from pr_diagnosis_enc_dtl where patient_id=a.patient_id and enc_stage='"+diagnosis_stage+"')");
     		//whereClause.append(" and a.ip_diag_stage = '"+diagnosis_stage+"'");
			andCheck = 1;
		}
		else
		{
			whereClause.append("and D.encounter_id in (Select encounter_id from pr_diagnosis_enc_dtl where patient_id=a.patient_id and enc_stage='"+diagnosis_stage+"')");
			//whereClause.append(" and a.ip_diag_stage =  '"+diagnosis_stage+"'");
		}
	}
	if (!(encounter_type_sel == null || encounter_type_sel.equals("")) )
	{
		if(andCheck==0)
		{
     	   whereClause.append(" and patient_class = '"+encounter_type_sel+"'");
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" and patient_class = '"+encounter_type_sel+"'");
		}
	}
	//out.println("Before Locn Sel");
	if (!(location_sel == null || location_sel.equals("")) )
	{
		if(andCheck==0)
		{
     		whereClause.append(" and D.pat_curr_locn_type = '"+location_sel+"'");
			andCheck = 1;
		}
		else
		{
			whereClause.append(" and D.pat_curr_locn_type =  '"+location_sel+"'");
		}
		
	}
	if (!(location_hidden == null || location_hidden.equals("")) )
	 {
	  if(andCheck==0)
		{
     	   whereClause.append(" and D.pat_curr_locn_code = '"+location_hidden+"'");
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" and D.pat_curr_locn_code = '"+location_hidden+"'");
		}
		
	}
	//out.println("Before Cal Age");
	if (!(age_from == null || age_from.equals("")) && (age_to == null || age_to.equals("")))
	 {
	  if(andCheck==0)
		{
     	   whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) >=   '"+age_from+"'");
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) >=  '"+age_from+"'");
		}
		
	}
	if (!(age_to == null || age_to.equals("")) )
	 {
	  if(andCheck==0)
		{
     	   whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) BETWEEN "+age_from+" AND "+age_to);
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) BETWEEN "+age_from+" AND "+age_to);
		   andCheck = 1;
		}
		
	}
	//out.println("Before Gender");
	if ( !(gender_val == null || gender_val.equals("")) )
	{
    	  if(andCheck==0)
	     {
		     whereClause.append("  AND B.SEX = '"+gender_val+"'");
		     andCheck = 1;
		 }
		 else
		{
		     whereClause.append("  AND B.SEX = '"+gender_val+"'");
		}
	}
	if ( !(patient_id == null || patient_id.equals("")) )
		{
		  if(andCheck==0)
			{
		   
			whereClause.append("  and a.patient_id = '"+patient_id+"'");
		    andCheck = 1;
			}
			else
			{
			whereClause.append(" and a.patient_id = '"+patient_id+"'");
			}
		
		}
	if ( !(encounter_id == null || encounter_id.equals("")) )
	{
		if(andCheck==0)
		{
//			whereClause.append(" and a.ONSET_ENCOUNTER_ID = '"+encounter_id+"'");
			whereClause.append(" and a.ENCOUNTER_ID = '"+encounter_id+"'");
			andCheck = 1;
		}
		else
		{
//			whereClause.append(" and a.ONSET_ENCOUNTER_ID = '"+encounter_id+"'");
			whereClause.append(" and a.ENCOUNTER_ID = '"+encounter_id+"'");
		}
	}
    
		if ( !(update_by == null || update_by.equals("")) )
		{
		  if(andCheck==0)
			{
		   whereClause.append(" and a.ADDED_BY_ID= '"+update_by+"'");
		   andCheck = 1;
			}
			else
			{
			whereClause.append(" and a.ADDED_BY_ID= '"+update_by+"'");
			}
		
		}
	//out.println("Before exists in prenc");
		///////////////////////
		if ( (!(recodedfromdate == null || recodedfromdate.equals(""))) && (!(recodedtodate == null || recodedtodate.equals(""))))
		{
		  if(andCheck==0)
			{
		  // whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by  a.added_date, a.patient_id, visit_adm_date_time, a.encounter_id");
		   whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by  a.patient_id, visit_adm_date_time, a.encounter_id,a.added_date ");
		   andCheck = 1;
			}
			else
			{
			//whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by a.added_date, a.patient_id, visit_adm_date_time, a.encounter_id");
			whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by a.patient_id, visit_adm_date_time, a.encounter_id,a.added_date ");
			}
		}
		else
		{
			//whereClause.append(" order by a.added_date, a.patient_id, visit_adm_date_time, a.encounter_id ");
			//whereClause.append(" order by a.patient_id, visit_adm_date_time, a.encounter_id,a.added_date ");  Jit- 06-mar-15
			whereClause.append(" order by a.patient_id,visit_adm_date_time, a.encounter_id, ORIG_RECORDED_DATE");
			
		}//whereClause modified on 8-3-2012 for the incident IN031056 - Ends

		//////////////////////
		
		//out.println("Before max rec");
	int maxRecord = 0;
	//out.println("After max rec");
%>
 <body OnMouseDown="CodeArrest()" onLoad='loadHeader()' onKeyDown='lockKey()'> 
	<form name=Trail_query_resultform>
	<!-- <div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:50%; visibility:hidden;' bgcolor='red'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center' bgcolor='red'>
	<tr >
		<td  width='100%' id='t'></td>
		</td>
	</tr>
	</table>
	</div> -->
		
<table border="1" width="100%" cellspacing='0' cellpadding='0' >
  <%
	//out.println("Inside Query Result Line 334");

	//StringBuffer sqlBuff=new StringBuffer();
 	//sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.ONSET_FACILITY_ID AND ENCOUNTER_ID = A.ONSET_ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'"+locale+"'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'"+locale+"'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'"+locale+"'),'#')-1) END ) PATIENT_LINE, A.ONSET_FACILITY_ID, A.ONSET_ENCOUNTER_ID, A.ORIG_DIAG_CODE, (SELECT SHORT_DESC FROM MR_ICD_CODE WHERE DIAG_CODE_SCHEME=A.ORIG_DIAG_CODE_SCHEME AND DIAG_CODE=A.ORIG_DIAG_CODE AND NVL(RECORD_TYPE,'D')=NVL(A.ORIG_RECORD_TYPE,'D') AND NVL(CAUSE_INDICATOR,'*')=NVL(A.ORIG_CAUSE_INDICATOR,'*')) ORIG_DIAG_DESC, A.OLD_RECODED_DIAG_CODE,(SELECT SHORT_DESC FROM MR_ICD_CODE WHERE NVL(DIAG_CODE_SCHEME,'*')=NVL(A.OLD_RECODED_DIAG_CODE_SCHEME,'*') AND DIAG_CODE=NVL(A.OLD_RECODED_DIAG_CODE,'*') AND NVL(RECORD_TYPE,'D')=NVL(A.OLD_RECODED_RECORD_TYPE,'D') AND NVL(CAUSE_INDICATOR,'*')=NVL(A.OLD_RECODED_CAUSE_INDICATOR,'*')) OLD_RECODED_DIAG_DESC,A.OLD_REMARKS,A.NEW_RECODED_DIAG_CODE,(SELECT SHORT_DESC FROM MR_ICD_CODE WHERE DIAG_CODE_SCHEME=A.NEW_RECODED_DIAG_CODE_SCHEME AND DIAG_CODE=A.NEW_RECODED_DIAG_CODE AND NVL(RECORD_TYPE,'D')=NVL(A.NEW_RECODED_RECORD_TYPE,'D') AND NVL(CAUSE_INDICATOR,'*')=NVL(A.NEW_RECODED_CAUSE_INDICATOR,'*')) NEW_RECODED_DIAG_DESC, A.NEW_REMARKS,(SELECT appl_user_name FROM sm_appl_user         WHERE appl_user_id = a.added_by_id) added_by_id,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE,A.ADDED_AT_WS_NO,B.SEX,B.DATE_OF_BIRTH,GET_AGE(B.DATE_OF_BIRTH) AGE, A.PATIENT_CLASS,(SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = A.PATIENT_CLASS) PATIENT_CLASS_DESC,A.IP_DIAG_STAGE, to_char(C.onset_date ,'dd/mm/yyyy') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.onset_practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID) RECORDED_BY,to_char(A.ADDED_DATE,'dd/mm/yyyy') RECORDED_DATE,c.onset_remarks original_ramarks  FROM MR_DIAG_RECODING_AUDIT A,MP_PATIENT B,pr_diagnosis c,mr_term_code d  WHERE B.PATIENT_ID = A.PATIENT_ID AND A.PATIENT_ID = C.PATIENT_ID AND a.srl_no = c.occur_srl_no  AND c.term_set_id = d.term_set_id AND c.term_code = d.term_code ");
	
	/*Modified by Dharma on Feb 5th 2015 Against HSA-SCF-0205 [IN:053238] Start */
/*
	StringBuffer sqlBuff=new StringBuffer();
	sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'en'),'#')-1) END ) PATIENT_LINE, A.FACILITY_ID, A.ENCOUNTER_ID ONSET_ENCOUNTER_ID, C.ORIG_TERM_CODE ORIG_DIAG_CODE, C.ORIG_TERM_CODE OLD_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.ORIG_TERM_SET_ID and TERM_CODE=C.ORIG_TERM_CODE) ORIG_DIAG_DESC, C.TERM_CODE NEW_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.TERM_SET_ID and TERM_CODE=C.TERM_CODE) NEW_RECODED_DIAG_DESC, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE appl_user_id = a.MODIFIED_BY_ID) ADDED_BY_ID, TO_CHAR(C.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE, A.ADDED_AT_WS_NO, B.SEX, B.DATE_OF_BIRTH ,GET_AGE(B.DATE_OF_BIRTH) AGE, D.patient_class, (SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = D.PATIENT_CLASS) PATIENT_CLASS_DESC,to_char(C.added_date ,'dd/mm/yyyy') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID) RECORDED_BY,to_char(C.RECORDED_DATE_TIME,'dd/mm/yyyy') RECORDED_DATE,(SELECT distinct onset_remarks FROM PR_DIAGNOSIS WHERE patient_id=a.patient_id and term_code=C.orig_term_code) original_ramarks, C.remarks new_remarks, lag(C.remarks,1) over(order by stage_srl_no) as old_remarks, (SELECT SHORT_DESC FROM mr_term_code WHERE term_set_id=C.TERM_SET_ID and term_code=C.TERM_CODE) OLD_RECODED_DIAG_DESC, (select enc_stage from pr_diagnosis_enc_dtl where patient_id=a.patient_id and encounter_id=a.encounter_id and term_code=c.ORIG_TERM_CODE ) ip_diag_stage FROM MR_DIAG_PROC_RECODING_HDR A, MP_PATIENT B,MR_DIAGNOSIS_RECODING_DTL C, PR_ENCOUNTER D where B.PATIENT_ID = A.PATIENT_ID AND C.STAGE_SRL_NO not in (1,2) AND C.STAGE_NO != 0 AND A.PATIENT_ID = C.PATIENT_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID and A.ENCOUNTER_ID=D.ENCOUNTER_ID AND a.facility_id= '"+facilityId+"' ");
	*/
	//Query modified on 8-3-2012 for the incident 31056
	
	StringBuffer sqlBuff=new StringBuffer();
	//sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'en'),'#')-1) END ) PATIENT_LINE, A.FACILITY_ID, A.ENCOUNTER_ID ONSET_ENCOUNTER_ID, C.ORIG_TERM_CODE ORIG_DIAG_CODE, C.ORIG_TERM_CODE OLD_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.ORIG_TERM_SET_ID and TERM_CODE=C.ORIG_TERM_CODE) ORIG_DIAG_DESC, C.TERM_CODE NEW_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.TERM_SET_ID and TERM_CODE=C.TERM_CODE) NEW_RECODED_DIAG_DESC, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE appl_user_id = a.MODIFIED_BY_ID) ADDED_BY_ID, TO_CHAR(C.ADDED_DATE,'DD/MM/YYYY hh24:mi:ss') ADDED_DATE, A.ADDED_AT_WS_NO, B.SEX, B.DATE_OF_BIRTH ,GET_AGE(B.DATE_OF_BIRTH) AGE, D.patient_class, (SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = D.PATIENT_CLASS) PATIENT_CLASS_DESC,to_char(C.added_date ,'dd/mm/yyyy hh24:mi') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.ADDED_BY_ID) RECORDED_BY,to_char(C.RECORDED_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') RECORDED_DATE,(SELECT distinct onset_remarks FROM PR_DIAGNOSIS WHERE patient_id=a.patient_id and term_code=C.orig_term_code) original_ramarks, C.remarks new_remarks, lag(C.remarks,1) over(order by stage_srl_no) as old_remarks, (SELECT SHORT_DESC FROM mr_term_code WHERE term_set_id=C.TERM_SET_ID and term_code=C.TERM_CODE) OLD_RECODED_DIAG_DESC, (select enc_stage from pr_diagnosis_enc_dtl where patient_id=a.patient_id and encounter_id=a.encounter_id and term_code=c.ORIG_TERM_CODE ) ip_diag_stage, mr_get_orig_term_code_dtls(C.FACILITY_ID,C.ENCOUNTER_ID,C.STAGE_SRL_NO) org_rec_data FROM MR_DIAG_PROC_RECODING_HDR A, MP_PATIENT B,MR_DIAGNOSIS_RECODING_DTL C, PR_ENCOUNTER D where B.PATIENT_ID = A.PATIENT_ID AND C.STAGE_SRL_NO not in (1,2) AND C.STAGE_NO != 0 AND A.PATIENT_ID = C.PATIENT_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID and A.ENCOUNTER_ID=D.ENCOUNTER_ID AND a.facility_id= '"+facilityId+"' ");

	sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'en'),'#')-1) END ) PATIENT_LINE, A.FACILITY_ID, A.ENCOUNTER_ID ONSET_ENCOUNTER_ID, C.ORIG_TERM_CODE ORIG_DIAG_CODE, C.ORIG_TERM_CODE OLD_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.ORIG_TERM_SET_ID and TERM_CODE=C.ORIG_TERM_CODE) ORIG_DIAG_DESC, C.TERM_CODE NEW_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.TERM_SET_ID and TERM_CODE=C.TERM_CODE) NEW_RECODED_DIAG_DESC, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE appl_user_id = a.MODIFIED_BY_ID) ADDED_BY_ID, TO_CHAR(C.ADDED_DATE,'DD/MM/YYYY hh24:mi:ss') ADDED_DATE, A.ADDED_AT_WS_NO, B.SEX, B.DATE_OF_BIRTH ,GET_AGE(B.DATE_OF_BIRTH) AGE, D.patient_class, (SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = D.PATIENT_CLASS) PATIENT_CLASS_DESC,to_char(C.added_date ,'dd/mm/yyyy hh24:mi') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.MODIFIED_BY_ID) RECORDED_BY,to_char(C.MODIFIED_DATE,'dd/mm/yyyy hh24:mi:ss') RECORDED_DATE,(SELECT distinct CASE WHEN LENGTH(onset_remarks)>30 THEN SUBSTR(onset_remarks,1,30)||'..' ELSE SUBSTR(onset_remarks,1,30) END FROM PR_DIAGNOSIS WHERE patient_id=a.patient_id and term_code=C.orig_term_code) original_ramarks,  CASE WHEN LENGTH(C.remarks)>30 THEN SUBSTR(C.remarks,1,30)||'..' ELSE SUBSTR(C.remarks,1,30) END new_remarks, lag(C.remarks,1) over(order by stage_srl_no) as old_remarks, (SELECT SHORT_DESC FROM mr_term_code WHERE term_set_id=C.TERM_SET_ID and term_code=C.TERM_CODE) OLD_RECODED_DIAG_DESC, (select enc_stage from pr_diagnosis_enc_dtl where patient_id=a.patient_id and encounter_id=a.encounter_id and term_code=c.ORIG_TERM_CODE and OCCUR_SRL_NO=c.OCCUR_SRL_NO) ip_diag_stage, mr_get_orig_term_code_dtls(C.FACILITY_ID,C.ENCOUNTER_ID,C.STAGE_SRL_NO) org_rec_data FROM MR_DIAG_PROC_RECODING_HDR A, MP_PATIENT B,MR_DIAGNOSIS_RECODING_DTL C, PR_ENCOUNTER D where B.PATIENT_ID = A.PATIENT_ID AND C.STAGE_NO != 0 AND A.PATIENT_ID = C.PATIENT_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID and A.ENCOUNTER_ID=D.ENCOUNTER_ID AND a.facility_id= '"+facilityId+"' and C.RECODE_STATUS not in ( 'E' ,'O')");


	


	/*Modified by Dharma on Feb 5th 2015 Against HSA-SCF-0205 [IN:053238] End*/
	sqlBuff.append(whereClause.toString()); 
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
    rset=stmt.executeQuery(sqlBuff.toString());
	rset.last();
	maxRecord=rset.getRow();
	rset.beforeFirst();
	if(maxRecord == 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
		out.println("parent.parent.frames[2].frames[3].location.href='../../eCommon/html/blank.html'");
		out.println("parent.parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html' </script>");
	}else{
		while (rset.next())
    {
		//if patient_id_prev
		patient_id1=rset.getString("PATIENT_ID");  
		
		i=1;
		%>
		<tr>
			<td class='CAGROUPHEADING' colspan=8	><FONT   style='font-size:8pt'><B>
			<!--Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]-->
			<!--<fmt:message key="eMR.PatientIdName.label" bundle="${mr_labels}"/> -->
			<fmt:message key="Common.name.label" bundle="${common_labels}"/> / <fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			
			&nbsp; :</B>
			       <%=(rset.getString("PATIENT_LINE")==null?"":rset.getString("PATIENT_LINE"))%></FONT>
			</td>
	  		<% classValue = "QRYEVEN" ;
               String new_diag_desc="";
			   String new_diag_remarks="";
			   String ip_diag_stage="";
			   String diag_type="";
			   String orig_recorded_date="";
			   String orig_recorded_by="";
			   StringBuffer concat=new StringBuffer("");
			   String old_diag_desc="";
			   String old_diag_remarks="";
			   String old_new_recorded_by="";
			   String old_new_recorded_date="";
				String old_recoded_code="";
				String new_recoded_code="";
				String orig_rec_data	= ""; //Added by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238]
			  // if (old_recoded_diag_code != null && new_recoded_diag_code != null && old_recoded_diag_code.equals(new_recoded_diag_code))
				//	break;
			   StringBuffer concat1=new StringBuffer("");
			   String original_ramarks="";
			while(patient_id1.equals(rset.getString("PATIENT_ID")))
		    {
				old_recoded_code=rset.getString("OLD_RECODED_DIAG_CODE");
				new_recoded_code=rset.getString("NEW_RECODED_DIAG_CODE");
				
				 /*below line was commented by venkatesh.s on 04-MARCH-2013 Reason is java.sql.SQLException: Exhausted Resultset  error happening */
				/*if (old_recoded_code != null && new_recoded_code != null && old_recoded_code.equals(new_recoded_code))
				{
					rset.next();
					continue;
				}*/
				old_new_recorded_by=checkForNull(rset.getString("RECORDED_BY"));
				old_new_recorded_date=checkForNull(rset.getString("RECORDED_DATE"));

				new_diag_desc=checkForNull(rset.getString("NEW_RECODED_DIAG_DESC"));
				new_diag_remarks=checkForNull(rset.getString("NEW_REMARKS"));
				ip_diag_stage=checkForNull(rset.getString("ip_diag_stage"));
				//diag_type=checkForNull(rset.getString("diag_type"));
				/* Commented by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] Start */
				//orig_recorded_date=checkForNull(rset.getString("orig_recorded_date"));
				//orig_recorded_by=checkForNull(rset.getString("orig_recorded_by"));
				/* Commented by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] End */
				original_ramarks=checkForNull(rset.getString("original_ramarks"));
                //Added by shyam on 03/11/2005///
				
				if(diag_type.equals("P")) diag_type="Provisional";
				else if(diag_type.equals("D")) diag_type="Differential";
				else if(diag_type.equals("F")) diag_type="Final";
               
			    if(ip_diag_stage.equals("A")) ip_diag_stage="Admission";
				else if(ip_diag_stage.equals("I")) ip_diag_stage="Intermediate";
				else if(ip_diag_stage.equals("D")) ip_diag_stage="Discharge";

				concat.append(new_diag_desc+"!"+new_diag_remarks+"|");

				old_diag_desc=checkForNull(rset.getString("ORIG_DIAG_DESC"));
				old_diag_remarks=checkForNull(rset.getString("OLD_REMARKS"));
				concat1.append(old_diag_desc+"!"+old_diag_remarks+"|");
				/*Added by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] Start*/
				orig_rec_data			= checkForNull(rset.getString("org_rec_data"));
				if(!orig_rec_data.equals("") && !orig_rec_data.equals(null)){
					if(orig_rec_data.contains("@@@")){
						String arr_orig_rec_data[]	= orig_rec_data.split("@@@");
						orig_recorded_by			= arr_orig_rec_data[0];
						orig_recorded_date			= arr_orig_rec_data[1];
					}
				}
				/*Added by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] End*/
				%>
				</tr>
				<tr>
						
				</tr>
				<tr>
					
					<td   width='14%' class='<%=classValue%>'>
					<a href="javascript:showEncounter('<%=rset.getString("ONSET_ENCOUNTER_ID")%>','<%=rset.getString("PATIENT_ID")%>','<%=(rset.getString("PATIENT_CLASS")==null)?"":rset.getString("PATIENT_CLASS")%>')"><%=rset.getString("ONSET_ENCOUNTER_ID")%></a>
					
					<td   width='15%' class='<%=classValue%>'>
					<%
						String vis_dat_tim_display = rset.getString("VISIT_ADM_DATE_TIME");
						if(vis_dat_tim_display == null) 
							vis_dat_tim_display = "&nbsp;";
						else
							vis_dat_tim_display = DateUtils.convertDate(vis_dat_tim_display,"DMYHM","en",locale);
						out.println(vis_dat_tim_display);
					%>
					</td>
					<td   width='9%' class='<%=classValue%>'	><%=rset.getString("PATIENT_CLASS_DESC")%></td>
					<td width='10%' id="new_desc" onMouseOver="displayToolTip_org('<%=java.net.URLEncoder.encode(rset.getString("ORIG_DIAG_DESC"))%>','<%=java.net.URLEncoder.encode(original_ramarks)%>','<%=ip_diag_stage%>','<%=diag_type%>','<%=orig_recorded_date%>','<%=orig_recorded_by%>',this);" onMouseOut ='hideToolTip();' class='<%=classValue%>'><%=rset.getString("ORIG_DIAG_CODE")%></td>
					<!--Commented by Dharma on Feb 5th 2015 against HSA-SCF-0205 [IN:053238]-->			
					
					<td width='10%' id="new_desc" onMouseOver="displayToolTip('<%=java.net.URLEncoder.encode(new_diag_desc) %>','<%=java.net.URLEncoder.encode(new_diag_remarks) %>','<%=ip_diag_stage%>','<%=diag_type%>','<%=old_new_recorded_date%>','<%=old_new_recorded_by%>',this);" onMouseOut ='hideToolTip();' class='<%=classValue%>'><%=(rset.getString("NEW_RECODED_DIAG_CODE")==null)?"&nbsp;":rset.getString("NEW_RECODED_DIAG_CODE")%></td>
					
					<td  width='14%'  class='<%=classValue%>'>
					
					<%// =(rset.getString("ADDED_BY_ID")==null)?"&nbsp; ":rset.getString("ADDED_BY_ID") ---- Jit- 06-mar-15%>
					<%=(rset.getString("RECORDED_BY")==null)?"&nbsp; ":rset.getString("RECORDED_BY")%>
					
					
					
					</td>
					<td width='15%' class='<%=classValue%>'>
					<%					
						/*String added_dat_display = rset.getString("ADDED_DATE");
 
						if(added_dat_display == null || added_dat_display.equals("")) 
							added_dat_display = "&nbsp;";
						else
							dded_dat_display = DateUtils.convertDate(added_dat_display,"DMY","en",locale);
							added_dat_display = DateUtils.convertDate(added_dat_display,"DMYHMS","en",locale);*/
						// Modified By Dharma on Mar 16th 2015 against HSA-SCF-0205 [IN:053238]

 
						out.println(old_new_recorded_date);
					%>					
					</td>
					
				</tr>
				<%
			if(rset.next()) 
		    {
			  if (i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				i++;

			}
			else
			{
				break;
			}
				
			}
			rset.previous();
		}
	}
if(rset!=null)
	rset.close();
if(stmt!=null)
	stmt.close();

%>
</table>
</form>
</body>
<%
}
catch(Exception e)
{	
	//out.println("Exception="+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

