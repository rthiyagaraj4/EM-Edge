<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
09/07/2012    	IN033511		Chowminya G		When Login Thai and view existing note Print button disappear
04/12/2012		IN032060		Ramesh G		MO-CRF-20059[All the notes which are documented through OT slate when modified 
												by the user who has got privilege to Author and modify these notes and the note 
												type set up is amend original section the system does not store the original note 
												content which was modified. ]
02/01/2013		IN036899		Ramesh G		The Status is not updated in the search tab after the transaction is completed. 
18/12/2013		IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality		
06/06/2014	    IN037701		Nijitha S		SKR-SCF-0865		
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
13/01/2015	IN053167		Rames G		13/01/2015		Akbar S			Since the deployment of September release in test environment we are unable to record pre anesthesia evaluation details.
06/05/2015	IN053733		Ramesh G									When a notifiable recorded against a notifiable diagnosis is marked in error, 
																		the notification to be de-linked from the parent diagnosis
01/11/2016	IN061988		Vijayakumar K										AAKH-CRF-0088.3 [IN:061988]
22/5/2018	IN066108		Dinesh T	22/5/2018		Ramesh G		GHL-CRF-0497
05/06/2018	IN67872			Dinesh T	05/06/2018		Ramesh G		GHL-CRF-0497.1
20/07/2018	IN067717		Ramesh G	20/07/2018		Ramesh G		ML-MMOH-CRF-0898.1
07/08/2018	IN063818		Raja S		07/08/2018		Ramesh G		MMS-DM-CRF-0102.1
03/02/2020		IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
12/07/2023		24094	Ranjith P R		13/07/2023		RAMESH G		ML-MMOH-CRF-1804.1
12/07/2023		24094	Ranjith P R		13/07/2023		RAMESH G		ML-MMOH-CRF-1804.2
19/07/2023		65008	Ranjith P R		20/07/2023		RAMESH G		PMG2024-COMN-CRF-0053
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
	<title>Recording Clinical Notes Search Result</title>
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
			<!-- ****  Modified by kishor kumar n on 05/12/2008 for crf0387 applied new css grid. **** -->
		
		

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='RecClinicalNotesSearchResultForm' id='RecClinicalNotesSearchResultForm' action="" method="" target="">
<%


	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	PreparedStatement	pstmtcnt	=	null;
	ResultSet			rscnt		=	null;
	
	PreparedStatement   pstmtot		= 	null;	//IN053167
	ResultSet			rsot		=	null;	//IN053167
	
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
	String	modified_date			=	"";//24094
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
	String Encline="";
	String oldEncline="";
	String speciality_code="";
	String res_encounter_id="";
	String p_called_from="";//CIS-CA-1490
	String notifiable_code = ""; //IN053733
	String nf_accession_num 	=""; //IN053733
	String called_from				=	""; //IN053733
	String l_inerror_access_yn = "N";//IN066108
	String l_sign_others_unsigned_notes_access_yn = "N";//IN066108
	String en_clin_note_modify_track_yn = "";//65008
	String orderStatusCodeHdr=""; //68801
	//IN063818 starts
	boolean isModifyDescSS = false;
	String isModifyDescYN ="N";
	ArrayList<String> functionIds = new ArrayList<String>();
	functionIds.add("DIS_MODIFY_AS_UPDATE");
	String beanId					= "CAClinicalHistoryBean" ;
	String beanName				= "eCA.CAClinicalHistoryBean";
	CAClinicalHistoryBean bean1	= (CAClinicalHistoryBean)getBeanObject( beanId, beanName , request) ;
	bean1.setSiteSpecific(functionIds,"CA");
	isModifyDescSS = bean1.isSiteSpecific("DIS_MODIFY_AS_UPDATE");
	if(isModifyDescSS)
		isModifyDescYN ="Y";
	//IN063818 ends
	
	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0,		colIndex			=	0;
	int		sec_count				=	0;

	patient_id			=	(request.getParameter("patient_id")==null) ?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) ?	""	:	request.getParameter("encounter_id");
	patient_class		=	(request.getParameter("patient_class")==null) ?	""	:	request.getParameter("patient_class");
	episode_type		=	(request.getParameter("episode_type")==null) ?	""	:	request.getParameter("episode_type");
	event_status		=	(request.getParameter("status")==null) ?	"0"	:	request.getParameter("status");
	other_unsigned_yn	=	(request.getParameter("other_unsigned_yn")==null) ?	"N"	:	request.getParameter("other_unsigned_yn");
	filter				=	(request.getParameter("filter")==null) ?	"A"	:	request.getParameter("filter");
	function_id			=	(request.getParameter("function_id")==null) ? ""	:	request.getParameter("function_id");
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
	note_type			=(request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	note_group			=	(request.getParameter("note_group")==null)?"":request.getParameter("note_group");
	appl_task_id		=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	performed_by = (request.getParameter("performed_by")==null)?"":request.getParameter("performed_by");
	med_anc = (request.getParameter("med_anc")==null)?"":request.getParameter("med_anc");
	contr_mod_accession_num = (request.getParameter("contr_mod_accession_num")==null)?"":request.getParameter("contr_mod_accession_num");
	ref_no = (request.getParameter("ref_no")==null)?"":request.getParameter("ref_no");
	speciality_code = (request.getParameter("speciality_code")==null)?"":request.getParameter("speciality_code");
 p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//CIS-CA-1490
	String p_event_class_widget = request.getParameter("p_event_class_widget") == null ? "" : request.getParameter("p_event_class_widget");//IN037701
	notifiable_code		=	request.getParameter("notifiable_code")==null?"":request.getParameter("notifiable_code"); //IN053733
	nf_accession_num	=	request.getParameter("accession_num")==null?"":request.getParameter("accession_num"); //IN053733
	called_from			=	request.getParameter("called_from")==null?"":request.getParameter("called_from"); //IN053733
	orderStatusCodeHdr			=	request.getParameter("orderStatusCodeHdr")==null?"N":request.getParameter("orderStatusCodeHdr"); //68801
	query_string.append("patient_id=");		query_string.append(patient_id);
	query_string.append("&encounter_id=");	query_string.append(encounter_id);
	query_string.append("&episode_type=");	query_string.append(episode_type);
	query_string.append("&function_id=");	query_string.append(function_id);
	query_string.append("&from_date_time="); query_string.append(from_date_time);
	query_string.append("&to_date_time="); query_string.append(to_date_time);
	query_string.append("&appl_task_id="); query_string.append(appl_task_id);
	query_string.append("&patient_class="); query_string.append(patient_class);
	query_string.append("&filter="); query_string.append(filter);
	query_string.append("&status="); query_string.append(event_status);
	query_string.append("&other_unsigned_yn="); query_string.append(other_unsigned_yn);
	query_string.append("&med_anc="); query_string.append(med_anc);
	query_string.append("&performed_by="); query_string.append(performed_by);
	query_string.append("&ref_no="); query_string.append(ref_no);
	query_string.append("&notifiable_code="); query_string.append(notifiable_code); //IN053733
	query_string.append("&called_from="); query_string.append(called_from); //IN053733
	query_string.append("&speciality_code="); query_string.append(speciality_code);


	from_date_time		= com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		= com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);

	try
	{

		con				=	ConnectionManager.getConnection(request);
		//IN066108, starts		
		boolean restrict_rd	=false;	//IN071561
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		//pstmt = con.prepareStatement("select IN_ERROR_YN,UNSIGNED_ACCESS_YN from CA_NOTE_PARAM");//65008
		pstmt = con.prepareStatement("select IN_ERROR_YN,UNSIGNED_ACCESS_YN,EN_CLIN_NOTE_MODIFY_TRACK_YN from CA_NOTE_PARAM");//65008
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			l_inerror_access_yn = rs.getString(1) == null ? "N" : rs.getString(1);
			l_sign_others_unsigned_notes_access_yn = rs.getString(2) == null ? "N" : rs.getString(2);
			en_clin_note_modify_track_yn =  rs.getString(3) == null ? "N" : rs.getString(3);;//65008
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		//IN066108, ends

		login_user_id	=	(String)		session.getValue("login_user");
		facility_id		=	(String)		session.getValue("facility_id");
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	 =	(String)		session.getValue("ca_practitioner_id");


		/*if(!(from_date_time.equals("")))
			whereClause.append(" and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");

		if(!(to_date_time.equals("")))
			whereClause.append(" and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' ) ");

		if(!(event_status.equals("0")))
			whereClause.append(" and a.event_status = ? ");

		if((filter.equals("R")))
		{
			whereClause.append(" and exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='RV' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) ");
		}
		else if((filter.equals("S")))
		{
			whereClause.append(" and (exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='SN' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) OR EVENT_STATUS='1') ");
		}

		if(!note_type.equals(""))
		{
			whereClause.append(" and a.note_type=? " );
		}

		if (!note_group.equals(""))
		{
			whereClause.append(" and b.note_group_id=? " );
		}

		else
		{
			whereClause.append(" and b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
		}

		//query_notes_detail.append("select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, c.short_desc  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(d.practitioner_name,'''',' ') performed_by_name, a.authorized_by_id, replace(e.practitioner_name,'''',' ') authorized_by_name, a.note_content,  decode( a.event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified','9','In Error') status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid from ca_encntr_note a, ca_note_type b, am_service c, am_practitioner d, am_practitioner e where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and b.note_type=a.note_type  and  c.service_code=a.service_code  and  d.practitioner_id = a.performed_by_id  and  e.practitioner_id(+) = a.authorized_by_id and a.patient_id = ? and a.facility_id =? and a.encounter_id = ? ");//IN066108
		query_notes_detail.append("select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, c.short_desc  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(d.practitioner_name,'''',' ') performed_by_name, a.authorized_by_id, replace(e.practitioner_name,'''',' ') authorized_by_name, a.note_content,  decode( a.event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified','9','In Error') status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid from ca_encntr_note a, ca_note_type b, am_service c, am_practitioner d, am_practitioner e where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and b.note_type=a.note_type  and  c.service_code=a.service_code  and  d.practitioner_id = a.performed_by_id  and  e.practitioner_id(+) = a.authorized_by_id and a.patient_id = ? and a.facility_id =? and a.encounter_id = ? ");//IN066108
		query_notes_detail.append(whereClause.toString());
		query_notes_detail.append(" order by event_date_time desc"); */
//
		if(!(from_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
		if(!(to_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");// 0.00068287   +.9999

		if(!(event_status.equals("0")))
			whereClause.append(" 	and a.event_status = ? ");

		//if(!(contr_mod_accession_num.equals("")))   //75294
		//whereClause.append(" 	and a.contr_mod_accession_num = ? ");    
		
		//IN042552 Start.
		//whereClause.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180
		whereClause.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT',?,?,a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180
		
		//IN042552 End.
		//IN071561 starts
		if(restrict_rd){
		//whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,'"+login_user_id+"')='N'");//common-icn-0180
		whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,?)='N'");//common-icn-0180
		}
		//IN071561 ends
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

		if (!note_group.equals(""))
				{
			whereClause.append(" 	and b.note_group_id=? " );
				}

		else
				{
				//IN053167 Start.
					String DispClinicalNotesInOTYN ="N";
					pstmtot = con.prepareStatement("SELECT 'Y' DISP_CLNNOTE_OT FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID = 'DISP_CLINICAL_NOTES_IN_OT'");
					rsot = pstmtot.executeQuery();
					if(rsot.next()){
						DispClinicalNotesInOTYN= rsot.getString("DISP_CLNNOTE_OT")==null?"":rsot.getString("DISP_CLNNOTE_OT");
					}
					if(rsot!=null)	rsot.close();
					if(pstmtot!=null) pstmtot.close();
					//IN053167 End.
				//[IN032060]	Start.
					//IN053167 Start. 
					if("OT_NOTES".equals(appl_task_id) && "Y".equals(DispClinicalNotesInOTYN)){ 
						whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id in ('CLINICAL_NOTES',?)) OR b.note_group_id IN ('*OPERNOTE'))  " );
					}else if("OT_NOTES".equals(appl_task_id) && "N".equals(DispClinicalNotesInOTYN)){ 
						whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id =?) OR b.note_group_id IN ('*OPERNOTE'))  " );
					}else{
						whereClause.append(" 		and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
					}
				
					/*if("OT_NOTES".equals(appl_task_id) && "N".equals(DispClinicalNotesInOTYN)){ 
						whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id =?) OR b.note_group_id IN ('*OPERNOTE'))  " );
					}else{
						whereClause.append(" 		and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
					}*/
					//IN053167 End.
				//whereClause.append(" 		and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
				////[IN032060]	End.
				}
		//IN037701 Starts		
		if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
		{
				whereClause.append(" 	AND b.EVENT_CLASS= ? ");
		}	
		//IN037701 Ends
		if(!performed_by.equals(""))
		{
			whereClause.append(" 	and a.PERFORMED_BY_ID=? " );
		}
		
		if(!med_anc.equals(""))
		{
			whereClause.append(" 	and a.SERVICE_CODE=? " );
		}

		if(!ref_no.equals(""))
		{
			whereClause.append(" 	and upper(a.DOC_REF_ID) like upper('%"+ref_no.trim()+"%')" );
		}
		//appl_task_id="MEDICAL_CERTFICATE";

		
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
			//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id,Decode(patient_class,'XT', 'Non-Encounter Specific', replace(CA_GET_VISIT_DTL_NEW(a.FACILITY_ID,a.patient_class,a.ENCOUNTER_ID,A.PATIENT_ID),'\''','  ')) Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b  where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and a.patient_id = ? and b.language_id = ?");//IN066108
			//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id,Decode(patient_class,'XT', 'Non-Encounter Specific', replace(CA_GET_VISIT_DTL_NEW(a.FACILITY_ID,a.patient_class,a.ENCOUNTER_ID,A.PATIENT_ID),'\''','  ')) Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b  where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and a.patient_id = ? and b.language_id = ?");//IN066108 
			query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id,Decode(patient_class,'XT', 'Non-Encounter Specific', replace(CA_GET_VISIT_DTL_NEW(a.FACILITY_ID,a.patient_class,a.ENCOUNTER_ID,A.PATIENT_ID),'\''','  ')) Encline,a.encounter_id,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date1  from ca_encntr_note a, ca_note_type_lang_vw b  where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and a.patient_id = ? and b.language_id = ?");//IN066108//24094 

		}else{ 
			if(called_from.equals("MR_DIAG")){
				//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ?");//IN066108
				//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ?");//IN066108 
				query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date1  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ?");//IN066108 //24094
				
			}else{
				//IN061988 starts
				//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ?");//IN066108
				
				if("PH_NOTES".equals(called_from))
				{
					//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and b.language_id = ?");//IN066108
					//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and b.language_id = ?");//IN066108 
					query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date1  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and b.language_id = ?");//IN066108 //24094
					
				}
				else
				{
					//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ?");//IN066108
					//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ?");//IN066108
					query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?,?,?,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date1  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?,?,?,?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ?");//IN066108 //24094

				}
				//IN061988 ends
			}
		}
		//IN053733 Start.
		if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code)){
			//query_notes_detail.append(" and a.accession_num='"+nf_accession_num+"'");//common-icn-0180
			query_notes_detail.append(" and a.accession_num=?");//common-icn-0180
		}else if("NOTIFIABLEFORM".equals(function_id) && "".equals(notifiable_code)){
			query_notes_detail.append(" and a.contr_oth_accession_num  IS NULL");
		}
		//IN061988 starts
		if("PH_NOTES".equals(function_id) && "PH_NOTES".equals(appl_task_id))
		{
			//query_notes_detail.append(" and a.accession_num='"+nf_accession_num+"'");//common-icn-0180
			query_notes_detail.append(" and a.accession_num=?");//common-icn-0180
		}
		//IN061988 ends
		//IN053733 End.
		//IN067717 starts
		if("BIRTH_REG_NOTES".equals(function_id) && !(nf_accession_num.equals(""))) {
			//query_notes_detail.append(" and a.accession_num='"+nf_accession_num+"'");//common-icn-0180
			query_notes_detail.append(" and a.accession_num=?");//common-icn-0180
		}
		//IN067717 ends
		query_notes_detail.append(whereClause.toString());
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
				query_notes_detail.append("	order by a.encounter_id,event_date_time desc");
		}else {
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
		pstmt.setString( ++colIndex,	"N"	); //IN066108
		pstmt.setString( ++colIndex,	l_inerror_access_yn	); //IN066108
		pstmt.setString( ++colIndex,	l_sign_others_unsigned_notes_access_yn	); //IN066108
		

		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);
		pstmt.setString( ++colIndex,	other_unsigned_yn	);
		pstmt.setString( ++colIndex,	"N"	);//IN066108
		pstmt.setString( ++colIndex,	l_inerror_access_yn	);//IN066108
		pstmt.setString( ++colIndex,	l_sign_others_unsigned_notes_access_yn	);//IN066108
	//	pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	patient_id		);
		

		
		if(!(appl_task_id.equals("MEDICAL_CERTFICATE")) && !(appl_task_id.equals("MC_CONSULT"))){
			pstmt.setString( ++colIndex,	facility_id		);
			//IN061988 starts
			//if(!(called_from.equals("MR_DIAG")))
			if(!(called_from.equals("MR_DIAG"))&&!("PH_NOTES".equals(called_from)))
			{
				pstmt.setString( ++colIndex,	encounter_id);
			}
			//IN061988 ends
		}
		pstmt.setString( ++colIndex,	locale);

		//common-icn-0180 starts
		if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code))
		{
			pstmt.setString( ++colIndex,	nf_accession_num);
		}
		if("PH_NOTES".equals(function_id) && "PH_NOTES".equals(appl_task_id))
		{
			pstmt.setString	(	++colIndex,	nf_accession_num	);
		}
		if("BIRTH_REG_NOTES".equals(function_id) && !(nf_accession_num.equals(""))) 
		{
			pstmt.setString	(	++colIndex,	nf_accession_num	);
		}

		//common-icn-0180 ends
		if(!(from_date_time.equals("")))
			pstmt.setString	(	++colIndex,	from_date_time	);

		if(!(to_date_time.equals("")))
		{
			pstmt.setString	(	++colIndex,	to_date_time	);
		}
		if(!(event_status.equals("0")))
		{

			pstmt.setString	(	++colIndex,	event_status	);
		}
		/* 69004 if(!(contr_mod_accession_num.equals("")))   //75294
		{

			pstmt.setString	(	++colIndex,	contr_mod_accession_num);
		}*/
		
		//common-icn-0180 starts
		pstmt.setString	(	++colIndex,	clinician_id);
		pstmt.setString	(	++colIndex,	resp_id);
		if(restrict_rd)
		{

			pstmt.setString	(	++colIndex,	login_user_id);
		}
		//common-icn-0180 ends
		if((filter.equals("R")))
		{

			pstmt.setString	(	++colIndex,	clinician_id);

		}
		else if((filter.equals("S")))
		{ 
			pstmt.setString	(	++colIndex,	clinician_id);

		}

		if(!note_type.equals(""))
		{
			
			pstmt.setString	(	++colIndex,	note_type	);

		}
		if (!note_group.equals(""))
		{
			pstmt.setString	(	++colIndex,	note_group	);

		}
		else
		{			
			pstmt.setString	(	++colIndex,	appl_task_id);

		}
		//IN037701 Starts
		if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
		{
				pstmt.setString	(	++colIndex,	p_event_class_widget);
		}
		//IN037701 Ends
		if(!performed_by.equals(""))
		{

			pstmt.setString	(	++colIndex,	performed_by );
		}
		
		if(!med_anc.equals(""))
		{

			pstmt.setString	(	++colIndex,med_anc);
		}
		
		rs				=	pstmt.executeQuery();
		////[IN032060]	Start.
		if(!(rs.next())){
		%>
			<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));				
			</script>
		<%		
		}else{
		//[IN032060]	End.
		rs.last();
		totalRecordCount	=	rs.getRow();
		rs.beforeFirst();
	
		if( totalRecordCount>maxRecordsDisp)
		{
	%>
		<table  class='gridComponentHolder' WIDTH='100%' align='center'  >
		<tr><td CLASS='BODYCOLORFILLED' >&nbsp;</td>	
	<%
		if(startIndex>maxRecordsDisp)
		{
	%>
			<td class='LABEL'  width='8%'><a class='gridLink' href="../../eCA/jsp/RecClinicalNotesSearchResult.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&<%=query_string.toString()%>&note_group=<%=note_group%>&note_type=<%=note_type%>" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
	<%
		}
		if(totalRecordCount>endIndex)
		{
	%>
			<td class='LABEL' align='center' width='8%'><a class='gridLink' href="../../eCA/jsp/RecClinicalNotesSearchResult.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&<%=query_string.toString()%>&note_group=<%=note_group%>&note_type=<%=note_type%>" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
		}
	%>
		</tr></table>
	<%
		}
	%>
		<table class='grid' width='100%' id='tb1' align='center'>
		<!-- 24094 starts -->
		<!-- 65008 starts -->
		<%if(en_clin_note_modify_track_yn.equals("Y")){ %>
		<td class='columnheadercenter'><fmt:message key="eCA.DateTimeCreated.label" bundle="${ca_labels}"/></td> 
		<td class='columnheadercenter'><fmt:message key="eCA.DateTimeLastModified.label" bundle="${ca_labels}"/></td> <!-- 24094 ends -->
		<td class='columnheadercenter'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'>&nbsp;</td>
		<td class='columnheadercenter'><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<%}else { %>
		
		<td class='columnheadercenter'><fmt:message key="eCA.DateTime.label" bundle="${ca_labels}"/></td> 
		<td class='columnheadercenter'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'>&nbsp;</td>
		<td class='columnheadercenter'><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<%} %>
	 <!-- 65008 ends -->
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

			facility_id						=			rs.getString("facility_id")==null?"":rs.getString("facility_id");
			accession_num					=			rs.getString("accession_num")==null?"":rs.getString("accession_num");
			note_type						=			rs.getString("note_type")==null?"":rs.getString("note_type");
			note_type_desc					=			rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
			service_code					=			rs.getString("service_code")==null?"":rs.getString("service_code");
			service_name					=			rs.getString("service_name")==null?"":rs.getString("service_name");
			service_name					=			service_name.replace('\'',' ');
			event_title_desc				=			rs.getString("event_title_desc")==null?"&nbsp;":rs.getString("event_title_desc");
			event_date_time					=			rs.getString("event_date_time1")==null?"":rs.getString("event_date_time1");
			modified_date					=			rs.getString("modified_date1")==null?"":rs.getString("modified_date1");//24094
			performed_by_id					=			rs.getString("performed_by_id")==null?"":rs.getString("performed_by_id");
			performed_by_name				=			rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
			authorized_by_name				=			rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
			doc_ref_id=rs.getString("doc_ref_id")==null?"":rs.getString("doc_ref_id");
			if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
				Encline=rs.getString("Encline")==null?"":rs.getString("Encline");
			}
			//status						=			rs.getString("status")==null?"&nbsp;":rs.getString("status");
			status1							=			rs.getString("status")==null?"&nbsp;":rs.getString("status");
			operations_allowed				=			rs.getString("operations_allowed")==null?"":rs.getString("operations_allowed");
			amendment_type					=			rs.getString("ammendment_type")==null?"":rs.getString("ammendment_type");
			privilege_type					=			rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
			strModifiedId					=			rs.getString("modifiedid")==null?"":rs.getString("modifiedid");
			doc_linked_note_yn				=			rs.getString("doc_linked_note_yn")==null?"N":rs.getString("doc_linked_note_yn");
			doc_linked						=			rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");
			res_encounter_id						=			rs.getString("encounter_id")==null?"0":rs.getString("encounter_id");
			event_date_time					=			com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
			modified_date					=			com.ehis.util.DateUtils.convertDate(modified_date,"DMYHM","en",locale);//24094


			//IN061988 starts
			if("PH_NOTES".equals(called_from))
			{
				if(!res_encounter_id.equals(encounter_id))
				{
					operations_allowed = "";
				}
			}
			//IN061988 ends
			//out.println("status1"+status1);
			//out.println("note_type"+note_type);
		
			
			if(doc_linked_note_yn.equals("Y"))
			{
				pstmtcnt.clearParameters();
				pstmtcnt.setString(1,note_type);
				rscnt = pstmtcnt.executeQuery();

				while(rscnt.next())
				{
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
			else if(status1.equals("5")){
				//IN063818 starts
				//status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
				if(isModifyDescYN.equals("Y"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Updated.label","ca_labels");
				else
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
				//IN063818 ends
			}
			else if(status1.equals("9"))
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
			else if(status1.equals("8"))//IN67872
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");//IN67872

			String img = "";
			
			if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
			else
				img = "&nbsp;";
			
			if(status1.equals("9"))
			{
				status_display_text ="<a class='gridLink' href=\"javascript:showNoteStatus('"+accession_num+"',"+tblrow_id+")\">"+status+"</a>&nbsp;&nbsp;<a class='gridLink' href=\"javascript:showErrorRemarks('"+accession_num+"','"+facility_id+"')\" style='color:red'><b>?</b></a>";
			}
			else if(status1.equals("8"))//IN67872
			{
				status_display_text ="<a class='gridLink' href=\"javascript:showNoteStatus('"+accession_num+"',"+tblrow_id+")\">"+status+"</a>&nbsp;&nbsp;<a class='gridLink' href=\"javascript:showRemarks('"+accession_num+"','"+facility_id+"')\" style='color:red'><b>?</b></a>";//IN67872
			}
			else //if( !(status1.equals("1")) )
			{
				status_display_text	=	"<a class='gridLink' href=\"javascript:showNoteStatus('"+accession_num+"',"+tblrow_id+")\">"+status+"</a>";
			}
			//else
			//	status_display_text	=	status;
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
			if(!Encline.equals(oldEncline)){%>
			<tr id="idddd"><td class='CAGROUP' colspan='9'><%=Encline%></td></tr>
			<% }
		}%>
			<tr id='<%=tblrow_id%>'>
				<td class='gridData'><%=event_date_time%></td>
				<!-- 24094 starts-->
				<!-- 65008 -->
		<%if(en_clin_note_modify_track_yn.equals("Y")){		
	    if(status1.equals("5")||status1.equals("8")||status1.equals("9")){ %> 
			<td class='gridData'><%=modified_date%></td>
		 <% } else{ %>
	        <td class='gridData'><%=""%></td>
	        <!-- 24094 ends -->
	        <!-- 65008 ends -->
	   <% }
		}  %>	
		
				
		<%	
			//Passes status1 value to part2 js for [IN033511]
			if(doc_linked_note_yn.equals("Y") && sec_count == 0)
			{
		%>
			<td id='tooltipCol<%=rowCnt%>' class='gridDataBlue' onMouseOver="hideToolTip(this,'imgArrow<%=rowCnt%>')"  onClick="displayToolTip('<%=facility_id%>','<%=note_type%>','<%=accession_num%>','<%=performed_by_id%>','<%=operations_allowed%>','<%=amendment_type%>','<%=privilege_type%>','<%=service_code%>','<%=authorized_by_name%>','<%=strModifiedId%>','<%=doc_linked_note_yn%>','<%=patient_id%>','<%=encounter_id%>','<%=episode_type%>','<%=function_id%>','<%=from_date_time%>','<%=to_date_time%>','<%=appl_task_id%>','<%=note_group%>','<%=patient_class%>',this,'imgArrow<%=rowCnt%>')"  style='cursor:pointer'><%=(status1.equals("5")?"<i>":"") + note_type_desc + (status1.equals("5")?"</i>":"")%><img align='right' src="../../eCommon/images/inactiveArrow.gif" name="imgArrow<%=rowCnt%>"></td>
		<%
			}else{
		%>
			<!-- IN036899 Start. -->
			<!--  <td class='gridData'><a class='gridLink' href="javascript:callMeOnClickSearchResultDis('<%=facility_id%>','<%=note_type%>','<%=accession_num%>','<%=performed_by_id%>','<%=operations_allowed%>','<%=amendment_type%>','<%=privilege_type%>',<%=tblrow_id%>,'<%=service_code%>','<%=authorized_by_name%>','<%=strModifiedId%>','<%=doc_linked_note_yn%>','<%=sec_count%>','<%=speciality_code%>','<%=res_encounter_id%>','<%=status%>','<%=status1%>')"><%=(status1.equals("5")?"<i>":"") + note_type_desc + (status1.equals("5")?"</i>":"")%></a>&nbsp;</td> -->
			<!--CIS-CA-1490 Start -->
				  <!--<td class='gridData'><a class='gridLink' href="javascript:callMeOnClickSearchResultDis('<%=facility_id%>','<%=note_type%>','<%=accession_num%>','<%=performed_by_id%>','<%=operations_allowed%>','<%=amendment_type%>','<%=privilege_type%>',<%=tblrow_id%>,'<%=service_code%>','<%=authorized_by_name%>','<%=strModifiedId%>','<%=doc_linked_note_yn%>','<%=sec_count%>','<%=speciality_code%>','<%=res_encounter_id%>','<%=status%>','<%=status1%>','<%=appl_task_id%>','<%=function_id%>')"><%=(status1.equals("5")?"<i>":"") + note_type_desc + (status1.equals("5")?"</i>":"")%></a>&nbsp;</td>--> 
<%-- <td class='gridData'><a class='gridLink' href="javascript:callMeOnClickSearchResultDis('<%=facility_id%>','<%=note_type%>','<%=accession_num%>','<%=performed_by_id%>','<%=operations_allowed%>','<%=amendment_type%>','<%=privilege_type%>',<%=tblrow_id%>,'<%=service_code%>','<%=authorized_by_name%>','<%=strModifiedId%>','<%=doc_linked_note_yn%>','<%=sec_count%>','<%=speciality_code%>','<%=res_encounter_id%>','<%=status%>','<%=status1%>','<%=appl_task_id%>','<%=function_id%>','<%=p_called_from%>')"><%=(status1.equals("5")?"<i>":"") + note_type_desc + (status1.equals("5")?"</i>":"")%></a>&nbsp;</td>   69004--%>			
<%-- <td class='gridData'><a class='gridLink' href="javascript:callMeOnClickSearchResultDis('<%=facility_id%>','<%=note_type%>','<%=accession_num%>','<%=performed_by_id%>','<%=operations_allowed%>','<%=amendment_type%>','<%=privilege_type%>',<%=tblrow_id%>,'<%=service_code%>','<%=authorized_by_name%>','<%=strModifiedId%>','<%=doc_linked_note_yn%>','<%=sec_count%>','<%=speciality_code%>','<%=res_encounter_id%>','<%=status%>','<%=status1%>','<%=appl_task_id%>','<%=function_id%>','<%=p_called_from%>','<%=includeInErrNoteCopyPreNoteYN%>')"><%=(status1.equals("5")?"<i>":"") + note_type_desc + (status1.equals("5")?"</i>":"")%></a>&nbsp;</td>   <!-- 69004 //68801--> --%>
<td class='gridData'><a class='gridLink' href="javascript:callMeOnClickSearchResultDis('<%=facility_id%>','<%=note_type%>','<%=accession_num%>','<%=performed_by_id%>','<%=operations_allowed%>','<%=amendment_type%>','<%=privilege_type%>',<%=tblrow_id%>,'<%=service_code%>','<%=authorized_by_name%>','<%=strModifiedId%>','<%=doc_linked_note_yn%>','<%=sec_count%>','<%=speciality_code%>','<%=res_encounter_id%>','<%=status%>','<%=status1%>','<%=appl_task_id%>','<%=function_id%>','<%=p_called_from%>','<%=orderStatusCodeHdr%>')"><%=(status1.equals("5")?"<i>":"") + note_type_desc + (status1.equals("5")?"</i>":"")%></a>&nbsp;</td>   <!-- 68801 -->

			<!--CIS-CA-1490 End -->
			<!-- IN036899 End. -->
		<%
			}
		%>

				<td class='gridData'><%=doc_ref_id%></td>
				<td class='gridData'><%=img%></td>
				<td class='gridData'><%=service_name%></td>
				<td class='gridData'><%=event_title_desc%></td>
				<td class='gridData'><%=performed_by_name%></td>
				<td class='gridData'><%=(authorized_by_name == null || authorized_by_name.equals("") )?"&nbsp;":authorized_by_name%></td>
				<td class='gridData'><%=status_display_text%></td>
			</tr>
		<%
				oldEncline=Encline;
			if(rowCnt>=maxRecordsDisp) break;
		}
		} //[IN032060]	
		if(rscnt!=null)	rscnt.close();
		if(pstmtcnt!=null) pstmtcnt.close();
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
</table>
	<input type=hidden name=query_string id=query_string value='<%=query_string.toString()%>'>
	<input type=hidden name=new_query_string id=new_query_string value='<%=request.getQueryString()%>'>
	<input type=hidden name=notifiable_code id=notifiable_code value='<%=notifiable_code %>'> <!--  IN053733 -->
	<!-------------hidden fields for fileupload-------------------->
	<input type=hidden name=accession_num id=accession_num value=''>
	<input type=hidden name=function_id id=function_id value=''>
	<input type=hidden name=privilege_type id=privilege_type value=''>
	<input type=hidden name=forwarded_clinician_id id=forwarded_clinician_id value=''>
	<input type=hidden name=action_comment id=action_comment value=''>
	<input type=hidden name=performed_by_id id=performed_by_id value=''>
	<input type=hidden name=operation_mode id=operation_mode value=''>
	<input type=hidden name=doc_linked_note_yn id=doc_linked_note_yn value=''>
	<input type=hidden name=appl_task_id id=appl_task_id value=''>
	<input type="hidden" name="called_from" id="called_from" value=''>
	<!--Added by Ambiga.M for 18712 on 2/24/2010   --> 
	<input type=hidden name=forward_mode id=forward_mode value=''>
	<!-- IN061988 starts-->
	<%
	if("PH_NOTES".equals(function_id))
	{
	%>
	<input type=hidden name='ph_error_status' id='ph_error_status' value=''>
	<%
	}
	%>
	<!-- IN061988 ends-->

<!------------------------------------------------------------>

<br><br>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center' >
	<tr><td width='100%' id='t'></td></tr>
	</table>
	</div>	

</form>
</center>
</body>
</html>






