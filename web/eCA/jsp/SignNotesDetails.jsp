<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?		created
06/02/2013	IN037675		Dinesh T	IN037675
27/02/2013	IN038176		DineshT		Privilege level setup with sign is not working		
16/03/2013	IN038659		DineshT		Privilege level setup with sign is not working		
27/12/2013	IN046001		Ramesh G	Bru-HIMS-CRF-391-42552/11	
15/09/2015  IN057492		Vijayakumar K	16/09/2015		Dinesh T			PMG2015-CRF-AAKH-CA-0001
25/01/2016	IN056951		Vijayakumar K	21/08/2015	Dinesh T	GHL-SCF-959 [IN:056951]
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
18/03/2020	IN071264		Nijitha S	 18/03/2020		Ramesh G	   GHL-CRF-0604
--------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.SignNotes.label" bundle="${ca_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	


    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/SignNotes.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<form name="SignNotesDetails_form" id="SignNotesDetails_form" action="../../servlet/eCA.SignNotesServlet" method="post" target=messageFrame>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<%
	Connection con  = null;
	ResultSet rs = null;
	//ResultSet rs1 = null;
	PreparedStatement	pstmt		=	null;
	Boolean fag=true;
	
	try
	{
		con = ConnectionManager.getConnection(request);
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");

		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		String	respid		=	(String)	session.getValue("responsibility_id");
		String	facilityid	=	(String)	session.getValue("facility_id");
		String 	userid	=	(String)	session.getValue("login_user");
		String notetypecode = request.getParameter("note_type_code")==null?"":request.getParameter("note_type_code");
		String p_called_func =request.getParameter("p_called_func")==null?"":request.getParameter("p_called_func"); //IN057492
		
		String requestedbyid = request.getParameter("requested_by_id")==null?"":request.getParameter("requested_by_id");
		if (requestedbyid.equals("ALL")) requestedbyid="";
				
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");

	/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/
	/*to pass the date that is NOT converted, to the next page*/
		String fromDateParam = fromDate;
		String ToDateParam = ToDate;
	/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/	

   
		//Start Added by Sridhar Reddy on 20/01/2009 PMGCRF0359 For Frame Reference in Servlet
		String option_id =request.getParameter("option_id")==null?"":request.getParameter("option_id");
		//End
		
		if (ToDate.equals(""))
			ToDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/
		/*converted the date to english, that has to be passed to the query*/

		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
	    ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/

		/*out.println("<script>alert('="+fromDate+"=');</script>");
		out.println("<script>alert('="+ToDate+"=');</script>");*/
		
		//String code = "";
		//String desc = "";
		StringBuffer sql = new StringBuffer();
		String classValue = "";
		String prevnotetype = "";
		String value = "";
		String valueForNotes = "";
		StringBuffer list = new StringBuffer();
		String curr_patient_id = "";
		String curr_episode_id = "";
		String patient_class = "";
		String img = "";
		String doc_linked = "";
		String autosavetmpdtls ="";//IN071264
		StringBuffer autosavenotestemp = new StringBuffer();//IN071264
		int i = 0;
		//shaiju>> 
		int		rowCnt					=	0,		maxRecordsDisp		=	10;
		int		startIndex				=	0,		endIndex			=	0;
		int		totalRecordCount		=	0;
		String	lower_limit				=	"";	
		String	upper_limit				=	"";
		lower_limit		=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
		upper_limit		=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
		startIndex		=	Integer.parseInt(lower_limit);
		endIndex		=	Integer.parseInt(upper_limit);
		if(sql.length() > 0) sql.delete(0,sql.length());
			/*sql.append( " select a.note_type,a.note_type_desc, a.facility_id, a.accession_num ");
			sql.append(", to_char(a.request_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append( " ,a.request_by_id,a.request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id) pline");
			sql.append( " ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.request_date_time dummydate, a.ACTION_COMMENT subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note_audit_log_view a ");
			sql.append( " ,ca_note_type_for_resp b ");
			sql.append(" where a.facility_id=? ");
			sql.append( " and a.action_type = 'SN' ");
			sql.append( " and a.action_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append( " and b.resp_id = ? ");
			sql.append( " and a.ACTION_STATUS ='RQ' ");

			if(!notetypecode.equals(""))
				sql.append( " and a.note_type =? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
	 		sql.append("  union all ");
			sql.append(" select a.note_type,c.note_type_desc, a.facility_id, a.accession_num ");
			sql.append( ", to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append(" ,to_char(null) request_by_id,'Self' request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id) pline");
			sql.append(" ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate ,null subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note a ");
			sql.append(" ,ca_note_type_for_resp b ");
			sql.append( " ,ca_note_type c ");
			sql.append( " where a.facility_id=? ");
			sql.append( " and a.added_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append(" and c.note_type = a.note_type ");
			sql.append(" and b.resp_id = ? ");
			sql.append( " and a.event_status='1' ");
			if(!notetypecode.equals(""))
				sql.append(" and a.note_type =? ");*/

		/*	sql.append( " select a.note_type,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1')note_type_desc, a.facility_id, a.accession_num ");
			sql.append(", to_char(a.request_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append( " ,a.request_by_id,AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,?,'1')request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id,?) pline");
			sql.append( " ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.request_date_time dummydate, a.ACTION_COMMENT subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note_audit_log_view a ");
			sql.append( " ,ca_note_type_for_resp b ");
			sql.append(" where a.facility_id=? ");
			sql.append( " and a.action_type = 'SN' ");
			sql.append( " and a.action_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append( " and b.resp_id = ? ");
			sql.append( " and a.ACTION_STATUS ='RQ' ");

			if(!notetypecode.equals(""))
				sql.append( " and a.note_type =? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");

			sql.append("  union all ");
			sql.append(" select a.note_type,c.note_type_desc, a.facility_id, a.accession_num ");
			sql.append( ", to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append(" ,to_char(null) request_by_id,'Self' request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id,?) pline");
			sql.append(" ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate ,null subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note a ");
			sql.append(" ,ca_note_type_for_resp b ");
			sql.append( " ,ca_note_type_lang_vw c ");
			sql.append( " where a.facility_id=? ");
			sql.append( " and a.added_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append(" and c.note_type = a.note_type ");
			sql.append(" and b.resp_id = ? ");
			sql.append( " and a.event_status='1' ");
			sql.append( " and c.language_id = ? ");
	
		if(!notetypecode.equals(""))
			  sql.append(" and a.note_type =? "); */

		/*In Below query this condition is appended  decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?) as  for new born cases the application shows blank for patient details.
		Added by Archana on 4/16/2010 at 3:07 PM for IN020707*/


		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5')  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE a.facility_id = ? AND a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176
		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5')  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE a.FWD_TO_FAC_ID = ? AND  a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176
		//IN056951 starts this fix for privilege type
		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5')  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE /*a.FWD_TO_FAC_ID = ? AND */ a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176
		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5' and ia.resp_id = ? )  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE /*a.FWD_TO_FAC_ID = ? AND */ a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176//IN67872
		//IN056951 ends
		sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5' and ia.resp_id = ? )  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE /*a.FWD_TO_FAC_ID = ? AND */ a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status not in ('9','8') ");//IN038176//IN67872

		//---[IN057492]/Start------
		if(!p_called_func.equals("MC")) 
		{
			//sql.append(" and c.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'MC_CONSULT')) ");//IN67872
			sql.append(" and c.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group a WHERE appl_task_id = 'MC_CONSULT' and  a.note_group=note_group_id)) ");//IN67872
		}
		//---[IN057492]/End------
		
		//IN046001 Start.
		sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");
		//IN046001 End.
				
		if(!notetypecode.equals(""))
			sql.append( " and c.note_type =? ");
		if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");

		if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		//Added By Archana Dhal on 22/01/2010 related to IN18229.
			else if(!fromDate.equals("") && (ToDate.equals("")))
		{
			sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}
		if(!patientId.equals(""))
			sql.append( " and c.patient_id =? ");
		
		//sql.append(" and nvl(a.FORWARD_TO_FAC_ID,'*') in (?,'*') ");//IN037675
		//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type),'A', '*', a.facility_id)) in (?,'*') ");//IN037675//IN038176
		sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type),'A', '*A','P','*A', a.facility_id)) in (?,'*A') ");//IN038659
		/*In Below query this condition is appended  decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?) as  for new born cases the application shows blank for patient details.
		Added by Archana on 4/16/2010 at 3:07 PM for IN020707*/

		//--[IN057492]/Start---
		//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5')  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS NULL");
		if(!p_called_func.equals("MC")) 
		{
		//IN056951 starts
		//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5')  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS NULL");
		sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5' and ia.resp_id = ? )  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS NULL");
		//IN056951 ends
		}
		else 
		{
			//IN056951 starts
			//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5')  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS not NULL and c.note_type in (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group where appl_task_id = 'MC_CONSULT'))" );
			//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5' and ia.resp_id = ?)  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS not NULL and c.note_type in (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group where appl_task_id = 'MC_CONSULT'))" );//IN67872
			//IN056951 ends
			sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5' and ia.resp_id = ?)  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS not NULL and c.note_type in (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group a where appl_task_id = 'MC_CONSULT' and  a.note_group=note_group_id))" );//IN67872
		}
		//--[IN057492]/End---
		//IN046001 Start.
		sql.append("  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y' ");
		//IN046001 End.
				
		if(!notetypecode.equals(""))
			  sql.append(" and a.note_type =? "); 
		if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and a.event_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		else if(!fromDate.equals("") && (ToDate.equals("")))
		{
			sql.append(" 	and a.event_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and a.event_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}
		if(!patientId.equals(""))
			sql.append( " and a.patient_id =? ");

		sql.append( " ORDER BY 2,dummydate DESC "); 


			pstmt = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//****parameter binding
			int count=0;
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			//Added by Archana on 4/16/2010 at 3:07 PM for IN020707
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,userid);//app_user
			pstmt.setString(++count,respid);//IN056951
			//pstmt.setString(++count,facilityid);//IN038176
			pstmt.setString(++count,clinicianid);
			pstmt.setString(++count,respid);
			if(!notetypecode.equals(""))
				pstmt.setString(++count,notetypecode);
			if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid);
			if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,ToDate);
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
		  {
				pstmt.setString(++count,fromDate);
		  }
          else if(fromDate.equals("") && !ToDate.equals(""))
		  {
			pstmt.setString(++count,ToDate);
		  }

			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);
           	//Added by Archana on 4/16/2010 at 3:07 PM for IN020707.
			pstmt.setString(++count,(String)session.getValue("facility_id"));//IN037675
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,userid);//app_user
			pstmt.setString(++count,respid);//IN056951
			pstmt.setString(++count,facilityid);
			pstmt.setString(++count,userid);
			pstmt.setString(++count,respid);
			pstmt.setString(++count,locale);

			if(!notetypecode.equals(""))
				pstmt.setString(++count,notetypecode);
			if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,ToDate);
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
		  {
				pstmt.setString(++count,fromDate);
		  }
          else if(fromDate.equals("") && !ToDate.equals(""))
		  {
			pstmt.setString(++count,ToDate);
		  }

			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);

			//***********
			rs = pstmt.executeQuery();
			//rs.absolute(-1);
			rs.last();
			totalRecordCount	=	rs.getRow();
			//rs.absolute(1);
			rs.beforeFirst();
	if( totalRecordCount>maxRecordsDisp)
		{

		//shaiju <<
	
%>
	<table  width='100%' border='0' align='center'  >
		<tr><td CLASS='BODYCOLORFILLED' >&nbsp;</td>	
	<%
		if(startIndex>maxRecordsDisp)
		{  
	/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
	/*Passing the date that is NOT converted, to the next page, since the date gets converted again in the next page*/
	%>

			
			<td class='LABEL'  width='8%'><a class='gridLink'  href="../../eCA/jsp/SignNotesDetails.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&note_type_code=<%=notetypecode%>&requested_by_id=<%=requestedbyid%>&patientId=<%=patientId%>&fromDate=<%=fromDateParam%>&ToDate=<%=ToDateParam%>"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>

	<%
		}
		if(totalRecordCount>endIndex)
		{
	%>
			<td class='LABEL' align='center' width='8%'><a class='gridLink' href="../../eCA/jsp/SignNotesDetails.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&note_type_code=<%=notetypecode%>&requested_by_id=<%=requestedbyid%>&patientId=<%=patientId%>&fromDate=<%=fromDateParam%>&ToDate=<%=ToDateParam%>"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
		}
		/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
	%>
		</tr></table>
	<%
		}
	%>

<table  width="100%" class='grid'>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Sign.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width="8%"><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'width="8%"><fmt:message key="eCA.RequestedAt.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width="8%"><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width="40%"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'width="15%"><fmt:message key="eCA.ForwardTo.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'>&nbsp;</td>
	<td class='COLUMNHEADERCENTER'></td>
	<%
			if(startIndex>1)
			rs.absolute((startIndex-1));
			rowCnt=0;
			String	note_type = "";
			while(rs != null && rs.next())
			{	
				rowCnt++;
				fag= false;
				if(i%2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";
				String patdetails = rs.getString("pline")==null?"":rs.getString("pline");
				String notetypedesc = rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
				
				doc_linked						=			rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");

				String privilegetype = rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
				note_type	=	rs.getString("note_type")==null?"":rs.getString("note_type");

				img = "";
				if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+rs.getString("accession_num")+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
				else
				img = "&nbsp;";

				curr_patient_id		=	rs.getString("patient_id")==null?"":rs.getString("patient_id");
				patient_class		=	rs.getString("patient_class")==null?"XT":rs.getString("patient_class");
				curr_episode_id 	=	rs.getString("encounter_id");
				String	subject	=	(rs.getString("subject")==null)?"&nbsp;":rs.getString("subject");
				String requestbyname = (rs.getString("request_by_name")==null)?"&nbsp;":rs.getString("request_by_name");
				list = new StringBuffer();
				
				if(requestbyname.equals("Self") )
					requestbyname = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.self.label","common_labels");
				if(privilegetype.equals("2") )
				{
					// FOR LOOK UP

					list.append("<input type='text' name='forward_to_desc_"+i+"' id='forward_to_desc_"+i+"' value='' size='15' maxlength='20'onBlur='getForwardTo(this,"+i+",\""+note_type+"\");'><input type='hidden'  name='forward_to_"+i+"' id='forward_to_"+i+"' value=''><input type='Button' name='forwardToButton' id='forwardToButton' class='button' value='?' onClick='forwardTo("+i+",\""+note_type+"\");'>");


					//
					
					
					/*list.append("<select name='forward_to_"+i+"' id='forward_to_"+i+"'><option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"  ---&nbsp;");
					
					String clincsql = " Select practitioner_id clinician_id, practitioner_name clinician_short_name from am_practitioner_lang_VW where language_id = ? and practitioner_id in ( select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ? and b.privilege_type in ('3','4') and a.appl_user_id = c.appl_user_id and c.resp_id = b.resp_id )  order by 2 ";

					//if (pstmt!=null) pstmt.close();

					pstmt	=	con.prepareStatement(clincsql);
					pstmt.setString (   1,  locale);
					pstmt.setString	(	2,	note_type	);
					rs1		=	pstmt.executeQuery();
					while(rs1.next())
					{
						list.append("<option value='"+rs1.getString("clinician_id")+"'>"+rs1.getString("clinician_short_name")+"");
					}
					list.append("</select>");
					
					if(rs1!=null)
						rs1.close();
					if(pstmt != null) pstmt.close(); */
				}
				else
				{
					list = new StringBuffer();
					list.append("&nbsp;<input type='hidden' name='forward_to_"+i+"' id='forward_to_"+i+"' value=''>");
				}
				if(!notetypedesc.equals(prevnotetype))
					out.println("<tr><td class='gridData' colspan='7'>"+notetypedesc+"</td></tr>");
				patdetails = patdetails.replace('|',',');

				value = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+rs.getString("note_type_desc")+"~"+curr_patient_id+"~"+curr_episode_id+"~"+note_type;//Added patient id, encounter id and note_type for IN071264

				/**********/
				valueForNotes = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+notetypedesc+"~"+note_type+"~"+curr_patient_id+"~"+curr_episode_id+"~"+rs.getString("EPISODE_TYPE")+"~"+patient_class;

				/*********/
				out.println("<tr height='1'><td class='gridData' ><input type='checkbox' name='chk_"+i+"' id='chk_"+i+"' value='"+value+"'></td>");
				out.println("<td class='gridData' >"+ subject 	+"</td>");
				out.println("<td class='gridData' >"+com.ehis.util.DateUtils.convertDate(rs.getString("request_date_time"),"DMYHM","en",locale)+"</td>");
				out.println("<td class='gridData' >"+requestbyname+"</td>");
				out.println("<td class='gridData'>"+patdetails+"</td>");
				out.println("<td class='gridData'>"+list.toString()+"</td>");
				out.println("<td class='gridData'>"+img+"</td>");
				out.println("<td class='gridData'><a class='gridLink' href=\"javascript:showDetails(escape(document.forms[0].valueForNotes"+i+".value))\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a><input type='hidden' name='value"+i+"' id='value"+i+"' value=\""+value+"\"></td><input type='hidden' name='valueForNotes"+i+"' id='valueForNotes"+i+"' value=\""+valueForNotes+"\"></td></tr>");
				i++;
				prevnotetype=notetypedesc;
				
				if(rowCnt>=maxRecordsDisp)   break;
			}%>
			<script>if(parent.SignNotesCriteriaFrame.document.getElementById("search")!=null)
				parent.SignNotesCriteriaFrame.document.getElementById("search").disabled=false;</script>
			<%
			if(fag)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
	%>
</table>
</body>
<input type="hidden" name="noofrec" id="noofrec" value="<%=i%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityid%>">
<input type="hidden" name="final_values" id="final_values" value="">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<!-- Start Added by Sridhar Reddy on 20/01/2009 PMGCRF0359 For Frame Reference in Servlet-->
<input type="hidden" name="optionID" id="optionID" value="<%=option_id%>">	
<!--End-->
</form>
<%	
		if(rs!=null) rs.close();
		//if(rs1!=null) rs1.close();
		if(pstmt != null) pstmt.close();
		
	}
	catch (Exception e)
	{
		out.println("Error"+e);
		e.printStackTrace();
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
    }
%>
</html>

