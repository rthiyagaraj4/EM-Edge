<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template if filled up earlier for same patient in template format.
04/09/2015	IN057368		Ramesh G										CRF-CA-GHL-CRF-0372/05 - In Day care Encounter , system lists the OP encounter Notes.
18/05/2017  IN063798		Raja S		22/05/2017		Ramesh Goli			ML-MMOH-CRF-0807
30/10/2017	IN063591		Raja S		30/10/2017		Ramesh Goli			ML-MMOH-CRF-0787
14/10/2020	IN072542		SIVABAGYAM M	14/10/2020	RAMESH G	CA-GHL-CRF-0558.1-US003/02- View Chart Summary
17/10/2023      28796           hariharan k     19/10/2023              Ramesh G                        NMC-JD-CRF-0154                                
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<title>Recorded Previous Notes Search Result</title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>
function scrollTitleBar()	//function to make the heading of the table static
{
	var scrollXY = document.body.scrollTop;
		document.getElementById("divTitleTable").style.position = 'relative';
		document.getElementById("divTitleTable").style.posTop  = scrollXY-1;
		
}
</script>	
<style>
		.gridDataSelect
		{
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #FFFFFF;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
			border-bottom:1px;
			border-top:0px;
			border-left:0px;
			border-right:0px;	
			background-color: #2E9AFE;	
			border-style:solid;
			border-color:#EEEEEE;
		}
</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' onScroll='scrollTitleBar()'>
<center>
<form name='RecClinicalNotesSearchResultForm' id='RecClinicalNotesSearchResultForm' action="" method="" target="">
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	PreparedStatement	pstmtcnt	=	null;
	ResultSet			rscnt		=	null;
	
	PreparedStatement   pstmtot		= 	null;	
	ResultSet			rsot		=	null;	
	
	StringBuffer query_notes_detail	=	new StringBuffer();
	StringBuffer query_string		=	new StringBuffer();
	StringBuffer whereClause		=	new StringBuffer();

	String	function_id				=	"";
	String	classValue				=	"";
	String	facility_id				=	"";	
	String	accession_num			=	"";
	String	note_type				=	"";	
	String	note_type_desc			=	"";
	String	note_group				=	"";		
	String	appl_task_id			=	"";
	String	service_code			=	"";	
	String	service_name			=	"";
	String	event_title_desc		=	"";		
	String	event_date_time			=	"";
	String	performed_by_id			=	"";
	String	performed_by_name		=	"";
	String	authorized_by_name		=	"";
	String	status					=	"";	
	String	status1					=	"";
	String	tblrow_id				=	"";
	String	login_user_id			=	"";	
	String	clinician_id			=	"";
	String	resp_id					=	"";		
	String	operations_allowed		=	"";
	String	amendment_type			=	"";
	String	privilege_type			=	"";
	String	patient_id				=	"";	
	String	encounter_id			=	"";
	String	episode_type			=	"";
	String	lower_limit				=	"";	
	String	upper_limit				=	"";
	String	from_date_time			=	"";		
	String	to_date_time			=	"";
	String	event_status			=   "";	
	String	status_display_text		=	"";
	String	filter					=	"";
	String	strModifiedId			=	"";
	String	patient_class			=	"";
	String	other_unsigned_yn		=	"";
	String	doc_linked				=	"";
	String	doc_linked_note_yn		=	"";
	String	med_anc					=	"";
	String	contr_mod_accession_num					=	"";
	String	performed_by			=	"";
	String	ref_no			=	"";
	String doc_ref_id="";
	String encline="";
	String oldEncline="";
	String speciality_code="";
	String res_encounter_id="";
	String p_called_from="";
	String notifiable_code = ""; 
	String nf_accession_num 	=""; 
	String called_from				=	""; 
	String p_event_class_widget	="";
	String encounter_desc	=	"";
	String defaultval  = "ASC";//NMC-JD-CRF-0154 START
	String ID ="";
	String defaultval1  = "DESC";
	String defaultval2  = "DESC";
	String defaultval3  = "DESC";
	String defaultval4  = "DESC";//NM-JD-CRF-0154 END
		
	
	eCA.RecClinicalNotesPractBean pracObj = new eCA.RecClinicalNotesPractBean();	
	
	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0,		colIndex			=	0;
	int		sec_count				=	0;
	facility_id			=	(request.getParameter("facility")==null) 		?	""	:	request.getParameter("facility");//NMC-JD-CRF-0154 START
	
	defaultval			=	(request.getParameter("defaultval")==null) 		?	""	:	request.getParameter("defaultval");
	defaultval1			=	(request.getParameter("defaultval1")==null) 		?	""	:	request.getParameter("defaultval1");
	defaultval2			=	(request.getParameter("defaultval2")==null) 		?	""	:	request.getParameter("defaultval2");
	defaultval3			=	(request.getParameter("defaultval3")==null) 		?	""	:	request.getParameter("defaultval3");
	defaultval4			=	(request.getParameter("defaultval4")==null) 		?	""	:	request.getParameter("defaultval4");//NMC-JD-CRF-0154 END
		
	String orderBy      =    request.getParameter("ID")==null?""   :    request.getParameter("ID");//NMC-JD-CRF-0154
	
	patient_id			=	(request.getParameter("patient_id")==null) 		?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) 	?	""	:	request.getParameter("encounter_id");
	patient_class		=	(request.getParameter("patient_class")==null) 	?	""	:	request.getParameter("patient_class");
	episode_type		=	(request.getParameter("episode_type")==null) 	?	""	:	request.getParameter("episode_type");
	event_status		=	(request.getParameter("status")==null) 			?	"0"	:	request.getParameter("status");	
	filter				=	(request.getParameter("filter")==null) 			?	"A"	:	request.getParameter("filter");
	function_id			=	(request.getParameter("function_id")==null) 	? 	""	:	request.getParameter("function_id");
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	lower_limit			=	(request.getParameter("lower_limit")==null)		?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)		?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
	note_type			=   (request.getParameter("note_type")==null)		?	""	:	request.getParameter("note_type");
	note_group			=	(request.getParameter("note_group")==null)		?	""	:	request.getParameter("note_group");
	appl_task_id		=	(request.getParameter("appl_task_id")==null)	?	""	:	request.getParameter("appl_task_id");
	performed_by 		=   (request.getParameter("performed_by")==null)	?	""	:	request.getParameter("performed_by");
	med_anc 			=	(request.getParameter("med_anc")==null)			?	""	:	request.getParameter("med_anc");
	ref_no 				= 	(request.getParameter("ref_no")==null)			?	""	:	request.getParameter("ref_no");
	speciality_code 	= 	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");		
	notifiable_code		=	(request.getParameter("notifiable_code")==null)	?	""	:	request.getParameter("notifiable_code"); 
	nf_accession_num	=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num"); 
	called_from			=	(request.getParameter("called_from")==null)		?	""	:	request.getParameter("called_from"); 
	
	p_called_from				=	(request.getParameter("p_called_from_widget")==null)	?	""	: request.getParameter("p_called_from_widget");//CIS-CA-1490
	p_event_class_widget 		= 	(request.getParameter("p_event_class_widget") == null) 	? 	"" 	: request.getParameter("p_event_class_widget");//IN037701
	other_unsigned_yn			=	(request.getParameter("other_unsigned_yn")==null) 		?	"N"	: request.getParameter("other_unsigned_yn");
	contr_mod_accession_num 	= 	(request.getParameter("contr_mod_accession_num")==null)	?	""	: request.getParameter("contr_mod_accession_num");
	
	
	
	query_string.append("patient_id=");			query_string.append(patient_id);
	query_string.append("&encounter_id=");		query_string.append(encounter_id);
	query_string.append("&episode_type=");		query_string.append(episode_type);
	query_string.append("&function_id=");		query_string.append(function_id);
	query_string.append("&from_date_time="); 	query_string.append(from_date_time);
	query_string.append("&to_date_time="); 		query_string.append(to_date_time);
	query_string.append("&appl_task_id="); 		query_string.append(appl_task_id);
	query_string.append("&patient_class="); 	query_string.append(patient_class);
	query_string.append("&filter="); 			query_string.append(filter);
	query_string.append("&status="); 			query_string.append(event_status);
	query_string.append("&other_unsigned_yn="); query_string.append(other_unsigned_yn);
	query_string.append("&med_anc="); 			query_string.append(med_anc);
	query_string.append("&performed_by="); 		query_string.append(performed_by);
	query_string.append("&ref_no="); 			query_string.append(ref_no);
	query_string.append("&notifiable_code="); 	query_string.append(notifiable_code); 
	query_string.append("&called_from="); 		query_string.append(called_from); 
	query_string.append("&speciality_code="); 	query_string.append(speciality_code);


	from_date_time		= com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		= com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);

	try
	{

		con				=	ConnectionManager.getConnection(request);
		boolean restrict_rd	=false;	//IN072542
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN072542
		//IN063798 Starts
		String encounterList = "";
		if("DC".equals(patient_class) || "IP".equals(patient_class) )
		 encounterList = pracObj.getPreviousEncounter(patient_id,encounter_id,con); 
		//IN063798 Ends

		login_user_id	=	(String)		session.getValue("login_user");
		//facility_id		=	(String)		session.getValue("facility_id");hari
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	 =	(String)		session.getValue("ca_practitioner_id");

		if(!(from_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
		if(!(to_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");

		
			whereClause.append(" 	and a.event_status in ('4','5') ");

		if(!(contr_mod_accession_num.equals("")))
			whereClause.append(" 	and a.contr_mod_accession_num = ? ");
		
		
		//whereClause.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180
		whereClause.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT',?,?,a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180
		
		//IN072542 STARTS
		if(restrict_rd){
			//whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,'"+login_user_id+"')='N'");//common-icn-0180
		    whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,?)='N'");//common-icn-0180
		}
		//IN072542 ENDS
		if((filter.equals("R")))
				{
			whereClause.append(" 	and exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='RV' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) ");
				}
		else if((filter.equals("S")))
				{
			whereClause.append(" 	and (exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='SN' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) OR EVENT_STATUS='1') ");
				}
		if(!note_type.equals(""))
				{
			whereClause.append(" 	and a.note_type=? " );
				}

		if (!note_group.equals("")){
			whereClause.append(" 	and b.note_group_id=? " );
		}else{
			
			String DispClinicalNotesInOTYN ="N";
			pstmtot = con.prepareStatement("SELECT 'Y' DISP_CLNNOTE_OT FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID = 'DISP_CLINICAL_NOTES_IN_OT'");
			rsot = pstmtot.executeQuery();
			if(rsot.next()){
				DispClinicalNotesInOTYN= rsot.getString("DISP_CLNNOTE_OT")==null?"":rsot.getString("DISP_CLNNOTE_OT");
			}
			if(rsot!=null)	rsot.close();
			if(pstmtot!=null) pstmtot.close();
					
			
			if("OT_NOTES".equals(appl_task_id) && "Y".equals(DispClinicalNotesInOTYN)){ 
				whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id in ('CLINICAL_NOTES',?)) OR b.note_group_id IN ('*OPERNOTE'))  " );
			}else if("OT_NOTES".equals(appl_task_id) && "N".equals(DispClinicalNotesInOTYN)){ 
				whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id =?) OR b.note_group_id IN ('*OPERNOTE'))  " );
			}else{
				whereClause.append(" 		and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
			}

		}
		
		
		if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget)){
				whereClause.append(" 	AND b.EVENT_CLASS= ? ");
		}			
		
		if(!performed_by.equals("")){
			whereClause.append(" 	and a.PERFORMED_BY_ID=? " );
		}
		
		if(!med_anc.equals("")){
			whereClause.append(" 	and a.SERVICE_CODE=? " );
		}

		if(!ref_no.equals("")){
			whereClause.append(" 	and upper(a.DOC_REF_ID) like upper('%"+ref_no.trim()+"%')" );
		}
		
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
			query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id,Decode(patient_class,'XT', 'Non-Encounter Specific', replace(CA_GET_VISIT_DTL_NEW(a.FACILITY_ID,a.patient_class,a.ENCOUNTER_ID,A.PATIENT_ID),'\''','  ')) Encline,a.encounter_id , /* ca_pat_enc_dtls(a.encounter_id,b.language_id) encounterdesc */  (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,b.language_id,2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc from 	ca_encntr_note a, ca_note_type_lang_vw b  where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and a.patient_id = ? and b.language_id = ?");
		}else{ 
			if(called_from.equals("MR_DIAG")){
				query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id , /*ca_pat_enc_dtls(a.encounter_id,b.language_id) encounterdesc */ (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,b.language_id,2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ?");
			}else{				
				query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id , /*ca_pat_enc_dtls(a.encounter_id,b.language_id) encounterdesc */ (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,b.language_id,2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ?");
			}
		}
		
		//if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code)){
		if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code) && !"".equals(nf_accession_num)){//Added for IN063591
			//query_notes_detail.append(" and a.accession_num='"+nf_accession_num+"'");//common-icn-0180
			query_notes_detail.append(" and a.accession_num=?");//common-icn-0180
		}else if("NOTIFIABLEFORM".equals(function_id) && "".equals(notifiable_code)){
			query_notes_detail.append(" and a.CONTR_MOD_ACCESSION_NUM  IS NULL");
		}
		//IN057368 Start.
		if("DC".equals(patient_class) || "IP".equals(patient_class) ){
			//query_notes_detail.append(" and a.ENCOUNTER_ID='"+encounter_id+"'"); //Commented for IN063798
			query_notes_detail.append(" and a.ENCOUNTER_ID in "+encounterList); //Modified for IN063798
		}
		//IN057368	End.
		query_notes_detail.append(whereClause.toString());
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
			query_notes_detail.append("	order by a.encounter_id,event_date_time desc");
		}//NMC-JD-CRF-0154 -START
		
		else if(orderBy.equals("REF"))
		{ID="REF";
	     if(defaultval1.equals("ASC")){
		query_notes_detail.append(" order by doc_ref_id asc");}
		else{
		query_notes_detail.append(" order by doc_ref_id desc");}}
		
		else if(orderBy.equals("PP"))
		{ID="PP";
	     if(defaultval2.equals("ASC")){
		query_notes_detail.append(" order by performed_by_name asc");}
		else{
		query_notes_detail.append(" order by performed_by_name desc");}}
		
		else if(orderBy.equals("AP"))
		{ ID="AP";
		if(defaultval3.equals("ASC")){
			query_notes_detail.append(" order by authorized_by_name asc");}
			else{
			query_notes_detail.append(" order by authorized_by_name desc");}
		}
		
		else if(orderBy.equals("ST"))
		{ ID="ST";
		if(defaultval4.equals("ASC")){
		      query_notes_detail.append(" order by status asc");}
		else{
			query_notes_detail.append(" order by status desc");}}
		
		else if(orderBy.equals("DATE")&& defaultval.equals("ASC")){
			ID="DATE";
			
			query_notes_detail.append("	order by event_date_time asc");
		}//NMC-JD-CRF-0154 -END
		else {
			query_notes_detail.append("	order by event_date_time desc");
		}
		
		pstmt			=	con.prepareStatement(query_notes_detail.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       

		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);
		pstmt.setString( ++colIndex,	other_unsigned_yn	); 

		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);
		pstmt.setString( ++colIndex,	other_unsigned_yn	);
		pstmt.setString( ++colIndex,	patient_id		);
		
		
		
		if(!(appl_task_id.equals("MEDICAL_CERTFICATE")) && !(appl_task_id.equals("MC_CONSULT"))){
			pstmt.setString( ++colIndex,	facility_id		);	
		}
		pstmt.setString( ++colIndex,	locale);
		//common-icn-0180 starts
		if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code) && !"".equals(nf_accession_num)){
			pstmt.setString	(	++colIndex,	nf_accession_num	);
		}
		//common-icn-0180 ends
		if(!(from_date_time.equals("")))
			pstmt.setString	(	++colIndex,	from_date_time	);
			
		if(!(to_date_time.equals("")))
			pstmt.setString	(	++colIndex,	to_date_time	);
		
		if(!(event_status.equals("0")))
			pstmt.setString	(	++colIndex,	event_status	);
		
		if(!(contr_mod_accession_num.equals("")))
			pstmt.setString	(	++colIndex,	contr_mod_accession_num);		
		//common-icn-0180 starts
		pstmt.setString	(	++colIndex,	clinician_id);		
		pstmt.setString	(	++colIndex,	resp_id);				
		if(restrict_rd)
			pstmt.setString	(	++colIndex,	login_user_id);
		//common-icn-0180 ends
		if((filter.equals("R")))
			pstmt.setString	(	++colIndex,	clinician_id);			
		else if((filter.equals("S")))
			pstmt.setString	(	++colIndex,	clinician_id);			
		
		if(!note_type.equals(""))
			pstmt.setString	(	++colIndex,	note_type	);
		
		if (!note_group.equals(""))
			pstmt.setString	(	++colIndex,	note_group	);
		else			
			pstmt.setString	(	++colIndex,	appl_task_id);
					
		if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
				pstmt.setString	(	++colIndex,	p_event_class_widget);				
		
		if(!performed_by.equals(""))
			pstmt.setString	(	++colIndex,	performed_by );			
		
		if(!med_anc.equals(""))
			pstmt.setString	(	++colIndex,med_anc);
					
		rs				=	pstmt.executeQuery();

		if(!(rs.next())){
		%>
			<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));				
			</script>
		<%		
		}else{
			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
			
			if( totalRecordCount>maxRecordsDisp){
				%>
				<table  class='gridComponentHolder' WIDTH='100%' align='center'  >
					<tr><td CLASS='BODYCOLORFILLED' >&nbsp;</td>	
				<%
					if(startIndex>maxRecordsDisp)
					{
				%>
						<td class='LABEL'  width='8%'><a class='gridLink' href="../../eCA/jsp/RecPreviousNotesSrchResults.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&<%=query_string.toString()%>&note_group=<%=note_group%>&note_type=<%=note_type%>&facility=<%=facility_id%>&defaultval=<%=defaultval%>&defaultval1=<%=defaultval1%>&defaultval2=<%=defaultval2%>&defaultval3=<%=defaultval3%>&defaultval4=<%=defaultval4%>&ID=<%=ID%>" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
				<%
					}
					if(totalRecordCount>endIndex)
					{
				%>
						<td class='LABEL' align='center' width='8%'><a class='gridLink' href="../../eCA/jsp/RecPreviousNotesSrchResults.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&<%=query_string.toString()%>&note_group=<%=note_group%>&note_type=<%=note_type%>&facility=<%=facility_id%>&defaultval=<%=defaultval%>&defaultval1=<%=defaultval1%>&defaultval2=<%=defaultval2%>&defaultval3=<%=defaultval3%>&defaultval4=<%=defaultval4%>&ID=<%=ID%>" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
				<%
					}
				%>
					</tr>
				</table>
			<%
			}
			%>
			<table class='grid' width='100%'  align='center' id="tablePreRec">
				<tr id="divTitleTable">
				<!-- NMC-JD-CRF-0154--start -->
					<td class='columnheadercenter'  rowspan='' width='' nowrap ><a    href="javascript:OrderByShort('DATE');"  style='color:white'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></a></td>
		
					<td class='columnheadercenter'><fmt:message key="eCA.VisitPatientClassEncounterSpecilityDtls.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter'  rowspan='' width='' nowrap ><a   href="javascript:callOrderBy1('REF');"  style='color:white'><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></a></td>
					<td class='columnheadercenter' rowspan='' width='' nowrap ><a    href="javascript:callOrderBy2('PP');"  style='color:white'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></a></td>
					<td class='columnheadercenter'  rowspan='' width='' nowrap ><a   href="javascript:callOrderBy3('AP');"  style='color:white'><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></a></td>
					<td class='columnheadercenter'  rowspan='' width='' nowrap ><a   href="javascript:callOrderBy4('ST');"  style='color:white'><fmt:message key="Common.status.label" bundle="${common_labels}"/></a></td>
				<!-- NMC-JD-CRF-0154--end -->
				</tr>
			<%

			if(startIndex>1)
			rs.absolute((startIndex-1));

			String countQuerySec = "select count(*) count  from ca_note_section_view where note_type = ? ";
			pstmtcnt = con.prepareStatement(countQuerySec);
		
			while(rs.next())
			{
				tblrow_id		=	"tblrow_id"+(rowCnt);
				rowCnt++;

				if( (rowCnt%2)==0 )
					classValue	=	"QRYEVEN";
				else
					classValue	=	"QRYODD";

				//facility_id			=	rs.getString("facility_id")==null?"":rs.getString("facility_id");//NMC-JD-CRF-0154
				//System.out.println("facility_id-----------------"+facility_id);
				accession_num		=	rs.getString("accession_num")==null?"":rs.getString("accession_num");
				note_type			=	rs.getString("note_type")==null?"":rs.getString("note_type");
				note_type_desc		=	rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
				service_code		=	rs.getString("service_code")==null?"":rs.getString("service_code");
				service_name		=	rs.getString("service_name")==null?"":rs.getString("service_name");
				service_name		=	service_name.replace('\'',' ');
				event_title_desc	=	rs.getString("event_title_desc")==null?"&nbsp;":rs.getString("event_title_desc");
				event_date_time		=	rs.getString("event_date_time1")==null?"":rs.getString("event_date_time1");
				performed_by_id		=	rs.getString("performed_by_id")==null?"":rs.getString("performed_by_id");
				performed_by_name	=	rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
				authorized_by_name	=	rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
				doc_ref_id			=	rs.getString("doc_ref_id")==null?"":rs.getString("doc_ref_id");
				status1				=	rs.getString("status")==null?"&nbsp;":rs.getString("status");
				operations_allowed	=	rs.getString("operations_allowed")==null?"":rs.getString("operations_allowed");
				amendment_type		=	rs.getString("ammendment_type")==null?"":rs.getString("ammendment_type");
				privilege_type		=	rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
				strModifiedId		=	rs.getString("modifiedid")==null?"":rs.getString("modifiedid");
				doc_linked_note_yn	=	rs.getString("doc_linked_note_yn")==null?"N":rs.getString("doc_linked_note_yn");
				doc_linked			=	rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");
				res_encounter_id	=	rs.getString("encounter_id")==null?"0":rs.getString("encounter_id");
				event_date_time		=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);			
				encounter_desc		=	rs.getString("encounterdesc")==null?"":rs.getString("encounterdesc");
				
				if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT"))
					encline=rs.getString("Encline")==null?"":rs.getString("Encline");				
				
				if(doc_linked_note_yn.equals("Y")){
					pstmtcnt.clearParameters();
					pstmtcnt.setString(1,note_type);
					rscnt = pstmtcnt.executeQuery();
					while(rscnt.next()){
						sec_count = rscnt.getInt("count");
					}
					if(rscnt!=null)
						rscnt.close();
				}

				if(status1.equals("1"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
				else if(status1.equals("2"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
				else if(status1.equals("3"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
				else if(status1.equals("4"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
				else if(status1.equals("5"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
				else if(status1.equals("9"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");

				String img = "";
				
				if(doc_linked.equals("Y"))
					img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
				else
					img = "&nbsp;";
				
				status_display_text	= status;
				if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
					if(!encline.equals(oldEncline)){
						%><tr id="idddd"><td class='CAGROUP' colspan='9'><%=encline%></td></tr><% 
					}
				}
				%>
					<tr id='<%=tblrow_id%>' onClick="showPreviousNotesView('<%=accession_num%>','<%=facility_id%>','<%=(rowCnt)%>')" style='cursor:pointer'>
						<td class='gridData'><%=event_date_time%></td>
						<td class='gridData'><%=encounter_desc%></td>
						<td class='gridData'><%=doc_ref_id%></td>
						<td class='gridData'><%=performed_by_name%></td>
						<td class='gridData'><%=(authorized_by_name == null || authorized_by_name.equals("") )?"&nbsp;":authorized_by_name%></td>
						<td class='gridData'><%=status_display_text%></td>
					</tr>
				<%
				oldEncline=encline;
				if(rowCnt>=maxRecordsDisp) break;
			}
		} 
			
	}catch(Exception e){
		System.out.println("Exception@ 501.RecPreviousNotesSrchResults.jsp : "+e);
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		if(rscnt!=null)	rscnt.close();
		if(pstmtcnt!=null) pstmtcnt.close();
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();	
	}
	%>
				</table>
				<input type=hidden name=query_string value='<%=query_string.toString()%>'>
				<input type=hidden name=new_query_string value='<%=request.getQueryString()%>'>
				<input type=hidden name=notifiable_code value='<%=notifiable_code %>'>
				
				<input type=hidden name=accession_num value=''>
				<input type=hidden name=function_id value=''>
				<input type=hidden name=privilege_type value=''>
				<input type=hidden name=forwarded_clinician_id value=''>
				<input type=hidden name=action_comment value=''>
				<input type=hidden name=performed_by_id value=''>
				<input type=hidden name=operation_mode value=''>
				<input type=hidden name=doc_linked_note_yn value=''>
				<input type=hidden name=appl_task_id value=''>
				<input type=hidden name=called_from value=''>	
				<input type=hidden name=rowCnt value='<%=rowCnt %>'>
				<!--START NMC-JD-CRF-0154-->
				<input type=hidden name=facility_id value='<%=facility_id%>'>
				<input type=hidden name=from_date_time value='<%=from_date_time%>'>
				<input type=hidden name=to_date_time value='<%=to_date_time%>'>
				<input type=hidden name=ref_no value='<%=ref_no%>'>
				<input type=hidden name=note_type value='<%=note_type%>'>
				<input type=hidden name=performed_by value='<%=performed_by%>'>
				<input type=hidden name=ID value='<%=ID%>'>
				<input type=hidden name=defaultval value='<%=defaultval%>'>
				<input type=hidden name=defaultval1 value='<%=defaultval1%>'>
				<input type=hidden name=defaultval2 value='<%=defaultval2%>'>
				<input type=hidden name=defaultval3 value='<%=defaultval3%>'>
				<input type=hidden name=defaultval4 value='<%=defaultval4%>'>
				<!--END NMC-JD-CRF-0154-->
				
</center>
</body>
</html>






