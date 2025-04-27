<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/10/2016	Created 		Raja S											MO-CRF-20108[IN058912] 
20/07/2018	IN067717		Ramesh G	20/07/2018		Ramesh G			ML-MMOH-CRF-0898.1
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<title>Mother Clinical Notes</title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
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
	<script language='javascript' src='../../eCA/js/ViewMotherLinkedNotes.js'></script>
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
<form name='ViewMotherLinkedNotesSearchResultForm' id='ViewMotherLinkedNotesSearchResultForm' action="" method="" target="">
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	
	
	StringBuffer query_notes_detail	=	new StringBuffer();
	StringBuffer query_string		=	new StringBuffer();
	StringBuffer whereClause		=	new StringBuffer();

	String	facility_id				=	"";	
	String	accession_num			=	"";
	String	note_type				=	"";	
	String	note_type_desc			=	"";
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
	String	resp_id					=	"";		
	String	amendment_type			=	"";
	String	privilege_type			=	"";
	String	patient_id				=	"";	
	String	encounter_id			=	"";
	String	episode_type			=	"";
	String	from_date_time			=	"";		
	String	to_date_time			=	"";
	String	event_status			=   "";	
	String	status_display_text		=	"";
	String	strModifiedId			=	"";
	String	other_unsigned_yn		=	"";
	String	doc_linked				=	"";
	String	doc_linked_note_yn		=	"";
	String	ref_no			=	"";
	String doc_ref_id="";
	String speciality_code="";
	String p_called_from="";
	String nf_accession_num 	=""; 
	String encounter_desc	=	"";
	String selectedAccessNum =""; 
	
	int		rowCnt					=	0;
	int		totalRecordCount		=	0,		colIndex			=	0;

	patient_id				=	(request.getParameter("patient_id")==null) 		?	""	:	request.getParameter("patient_id");
	encounter_id			=	(request.getParameter("encounter_id")==null) 	?	""	:	request.getParameter("encounter_id");
	episode_type			=	(request.getParameter("episode_type")==null) 	?	""	:	request.getParameter("episode_type");
	event_status			=	(request.getParameter("status")==null) 			?	"0"	:	request.getParameter("status");	
	from_date_time			=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time			=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	note_type				=   (request.getParameter("note_type")==null)		?	""	:	request.getParameter("note_type");
	ref_no 					= 	(request.getParameter("ref_no")==null)			?	""	:	request.getParameter("ref_no");
	speciality_code			= 	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");		
	nf_accession_num		=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num"); 
	selectedAccessNum		=	(request.getParameter("sel_accession_num")==null)		?	""	:	request.getParameter("sel_accession_num");
	p_called_from			=	(request.getParameter("p_called_from_widget")==null)	?	""	: request.getParameter("p_called_from_widget");
	other_unsigned_yn		=	(request.getParameter("other_unsigned_yn")==null) 		?	"N"	: request.getParameter("other_unsigned_yn");
	String  function_id			=   request.getParameter("function_id")== null ? "" : request.getParameter("function_id");//IN067717
	//IN067717
	if("BIRTH_REG_NOTES".equals(function_id) && !(nf_accession_num.equals(""))) {
		selectedAccessNum	=nf_accession_num;
	}
	//IN067717
	
	query_string.append("patient_id=");			query_string.append(patient_id);
	query_string.append("&encounter_id=");		query_string.append(encounter_id);
	query_string.append("&episode_type=");		query_string.append(episode_type);
	query_string.append("&from_date_time="); 	query_string.append(from_date_time);
	query_string.append("&to_date_time="); 		query_string.append(to_date_time);
	query_string.append("&status="); 			query_string.append(event_status);
	query_string.append("&other_unsigned_yn="); query_string.append(other_unsigned_yn);
	query_string.append("&ref_no="); 			query_string.append(ref_no);
	query_string.append("&speciality_code="); 	query_string.append(speciality_code);
	query_string.append("&resp_id=CA");


	from_date_time		= com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		= com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	try
	{

		con				=	ConnectionManager.getConnection(request);

		login_user_id	=	(String)		session.getValue("login_user");
		facility_id		=	(String)		session.getValue("facility_id");
		resp_id			=	(request.getParameter("resp_id")==null)?"":request.getParameter("resp_id");


		if(!(from_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
		if(!(to_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");

		
		whereClause.append(" 	and a.event_status in ('4','5') ");

		if(!ref_no.equals("")){
			whereClause.append(" 	and upper(a.DOC_REF_ID) like upper('%"+ref_no.trim()+"%')" );
		}
		
		query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id , /*ca_pat_enc_dtls(a.encounter_id,b.language_id) encounterdesc */ (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,b.language_id,2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc  from 	ca_encntr_note a, ca_note_type_lang_vw b where a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ? and a.ENCOUNTER_ID = ?");
			
		query_notes_detail.append(whereClause.toString());
		//IN067717 starts
		if("BIRTH_REG_NOTES".equals(function_id) && !(nf_accession_num.equals(""))) {
			//query_notes_detail.append(" and a.accession_num='"+nf_accession_num+"'");//common-icn-0180
			query_notes_detail.append(" and a.accession_num=?");//common-icn-0180
		}
		//IN067717 ends
		query_notes_detail.append("	order by event_date_time desc");
		
		pstmt			=	con.prepareStatement(query_notes_detail.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	patient_id		);
		pstmt.setString( ++colIndex,	facility_id		);
		pstmt.setString( ++colIndex,	locale);
		pstmt.setString( ++colIndex,    encounter_id	);
		
		if(!(from_date_time.equals("")))
			pstmt.setString	(	++colIndex,	from_date_time	);
			
		if(!(to_date_time.equals("")))
			pstmt.setString	(	++colIndex,	to_date_time	);
		//common-icn-0180 starts
		if("BIRTH_REG_NOTES".equals(function_id) && !(nf_accession_num.equals(""))) {
			pstmt.setString( ++colIndex,    nf_accession_num	);
		}
		//common-icn-0180 ends
		
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
			%>
			<table class='grid' width='100%'  align='center' id="tablePreRec" >
				<tr id="divTitleTable">
					<td class='columnheadercenter'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="eCA.VisitPatientClassEncounterSpecilityDtls.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
				</tr>
			<%

			while(rs.next())
			{
				tblrow_id		=	"tblrow_id"+(rowCnt);
				rowCnt++;

				facility_id			=	rs.getString("facility_id")==null?"":rs.getString("facility_id");
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
				amendment_type		=	rs.getString("ammendment_type")==null?"":rs.getString("ammendment_type");
				privilege_type		=	rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
				strModifiedId		=	rs.getString("modifiedid")==null?"":rs.getString("modifiedid");
				doc_linked_note_yn	=	rs.getString("doc_linked_note_yn")==null?"N":rs.getString("doc_linked_note_yn");
				doc_linked			=	rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");
				event_date_time		=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);			
				encounter_desc		=	rs.getString("encounterdesc")==null?"":rs.getString("encounterdesc");
					
				
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

		
				status_display_text	= status;
				%>
					<tr id='<%=tblrow_id%>'  >
						<td class='gridData'><%=event_date_time%></td>
						<td class='gridData'><%=note_type_desc%></td>
						<td class='gridData'><%=encounter_desc%></td>
						<td class='gridData'><%=doc_ref_id%></td>
						<td class='gridData'><%=performed_by_name%></td>
						<td class='gridData'><%=(authorized_by_name == null || authorized_by_name.equals("") )?"&nbsp;":authorized_by_name%></td>
						<td class='gridData'><%=status_display_text%></td>
						<td class='gridData'><input type='radio' name='view_note' id='view_note' value='N' onClick="showPreviousNotesView('<%=accession_num%>','<%=facility_id%>','<%=(rowCnt)%>')" <%if(accession_num.equals(selectedAccessNum)){%>checked <%}%>></td>
					</tr>
					<%if(accession_num.equals(selectedAccessNum)){%>
					<script>
					setTimeout("showPreviousNotesView('<%=accession_num%>','<%=facility_id%>','<%=(rowCnt)%>')", 500);//IN067717
					</script>
					<%}%>
				<%
			}
		} 
			
	}catch(Exception e){
		System.out.println("Exception@ 501.ViewMotherLinkedNotesSrchResults.jsp : "+e);
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();	
	}
	%>
				</table>
				<input type=hidden name=query_string value='<%=query_string.toString()%>'>
				<input type=hidden name=new_query_string value='<%=request.getQueryString()%>'>
				
				<input type=hidden name=accession_num value=''>
				<input type=hidden name=privilege_type value=''>
				<input type=hidden name=forwarded_clinician_id value=''>
				<input type=hidden name=action_comment value=''>
				<input type=hidden name=performed_by_id value=''>
				<input type=hidden name=operation_mode value=''>
				<input type=hidden name=doc_linked_note_yn value=''>
				<input type=hidden name=rowCnt value='<%=rowCnt %>'>	
</form>
</center>
</body>
</html>






