<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name	Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
24/01/2018	IN063931		Prakash C	25/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)								
------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<title>Recorded Previous Section Search Result</title>
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
<form name='RecClinicalSectionSearchResultForm' id='RecClinicalSectionSearchResultForm' action="" method="" target="">
<%
	Connection			con			=	null;

	PreparedStatement	pstmtcnt	=	null;
	ResultSet			rscnt		=	null;
	
	PreparedStatement   pstmtSec	= 	null;	
	ResultSet			rsSec		=	null;
	
	StringBuffer query_string		=	new StringBuffer();
	StringBuffer query_section_detail		=	new StringBuffer();

	String	function_id				=	"";
	String	classValue				=	"";
	String	facility_id				=	"";	
	String	note_type				=	"";	
	String	note_type_desc			=	"";
	String	note_group				=	"";		
	String	appl_task_id			=	"";		
	String	event_date_time			=	"";
	String	performed_by_name		=	"";
	String	authorized_by_name		=	"";
	String	status					=	"";	
	String	status1					=	"";
	String	tblrow_id				=	"";
	String	login_user_id			=	"";	
	String	clinician_id			=	"";
	String	resp_id					=	"";		
	String	patient_id				=	"";	
	String	encounter_id			=	"";
	String	episode_type			=	"";
	String	lower_limit				=	"";	
	String	upper_limit				=	"";
	String	from_date_time			=	"";	
	String	curr_sec_hdg_code		=	"";
	String 	curr_sec_accession_num	=	"";
	String 	curr_child_sec_hdg_code	=	"";
	String	to_date_time			=	"";
	String	event_status			=   "";	
	String	status_display_text		=	"";
	String	filter					=	"";
	String	patient_class			=	"";
	String	other_unsigned_yn		=	"";
	String	med_anc					=	"";
	String 	sec_hdg_code			=	"";
	String 	subsec_hdg_code			=	"";
	String	contr_mod_accession_num					=	"";
	String	performed_by			=	"";
	String	ref_no			=	"";
	String encline="";
	String oldEncline="";
	String speciality_code="";
	String p_called_from="";
	String notifiable_code = ""; 
	String nf_accession_num 	=""; 
	String called_from				=	""; 
	String p_event_class_widget	="";
	String encounter_desc	=	"";
	eCA.RecClinicalNotesPractBean pracObj = new eCA.RecClinicalNotesPractBean();
	
	java.sql.Clob	clob_notes_section_content_html	=	null;
	
	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0;
	int		secIndex				=	0;

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
	
	p_called_from				=	(request.getParameter("p_called_from_widget")==null)	?	""	: request.getParameter("p_called_from_widget");
	p_event_class_widget 		= 	(request.getParameter("p_event_class_widget") == null) 	? 	"" 	: request.getParameter("p_event_class_widget");
	other_unsigned_yn			=	(request.getParameter("other_unsigned_yn")==null) 		?	"N"	: request.getParameter("other_unsigned_yn");
	contr_mod_accession_num 	= 	(request.getParameter("contr_mod_accession_num")==null)	?	""	: request.getParameter("contr_mod_accession_num");
	curr_sec_hdg_code			=	(request.getParameter("curr_sec_hdg_code")==null)	?	""	:	request.getParameter("curr_sec_hdg_code");
	curr_child_sec_hdg_code		=	(request.getParameter("curr_child_sec_hdg_code")==null)	?	""	:	request.getParameter("curr_child_sec_hdg_code");
	
	
	
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

		String encounterList = "";
		if("DC".equals(patient_class) || "IP".equals(patient_class) )
		 encounterList = pracObj.getPreviousEncounter(patient_id,encounter_id,con);
		login_user_id	=	(String)		session.getValue("login_user");
		facility_id		=	(String)		session.getValue("facility_id");
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	 =	(String)		session.getValue("ca_practitioner_id");

			
				query_section_detail.append("Select b.ACCESSION_NUM, b.SEC_HDG_CODE, b.SUBSEC_HDG_CODE, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,'en',2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc,(select note_type_desc from CA_NOTE_TYPE where note_type = a.note_type) note_type_desc, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ') authorized_by_name, a.event_status status, b.NOTES_SEC_CONT_HTML from CA_ENCNTR_NOTE a, CA_ENCNTR_NOTE_SECTION b where a. accession_num = b. accession_num  and b.SEC_HDG_CODE = ? and b.SUBSEC_HDG_CODE = ? and b.NOTES_SEC_CONT_HTML is not null");
				
				query_section_detail.append(" 	and a.event_status in ('4','5') ");
				if(!(from_date_time.equals("")))
					query_section_detail.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
				if(!(to_date_time.equals("")))
					query_section_detail.append(" 	and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");
					query_section_detail.append(" and a.patient_id =? ");
				if("DC".equals(patient_class) || "IP".equals(patient_class) ){
					//query_section_detail.append(" and a.ENCOUNTER_ID in "+encounterList);//common-icn-0180 
					query_section_detail.append(" and a.ENCOUNTER_ID in "+encounterList);//common-icn-0180 
				}
				//query_section_detail.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180 
				query_section_detail.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT',?,?,a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180 
				
				query_section_detail.append("	order by event_date_time desc");
				
				
				pstmtSec = con.prepareStatement(query_section_detail.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				pstmtSec.setString( ++secIndex, locale);
				pstmtSec.setString( ++secIndex, locale);
				pstmtSec.setString( ++secIndex, curr_sec_hdg_code);
				pstmtSec.setString( ++secIndex, curr_child_sec_hdg_code);
				if(!(from_date_time.equals(""))){
					pstmtSec.setString	(	++secIndex,	from_date_time	);
				}
				if(!(to_date_time.equals(""))){
					pstmtSec.setString( ++secIndex, to_date_time);
				}
				pstmtSec.setString( ++secIndex, patient_id);
				//common-icn-0180 starts
				if("DC".equals(patient_class) || "IP".equals(patient_class) ){
					pstmtSec.setString( ++secIndex, encounterList);
				}
				pstmtSec.setString( ++secIndex, clinician_id);
				pstmtSec.setString( ++secIndex, resp_id);
				//common-icn-0180 ends
				rsSec = pstmtSec.executeQuery();
				
		if(!(rsSec.next())){
		%>
			<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));				
			</script>
		<%		
		}else{
			rsSec.last();
			totalRecordCount	=	rsSec.getRow();
			rsSec.beforeFirst();
			
			if( totalRecordCount>maxRecordsDisp){
				%>
				<table  class='gridComponentHolder' WIDTH='100%' align='center'  >
					<tr><td CLASS='BODYCOLORFILLED' >&nbsp;</td>	
				<%
					if(startIndex>maxRecordsDisp)
					{
				%>
						<td class='LABEL'  width='8%'><a class='gridLink' href="../../eCA/jsp/RecPreviousSectionSrchResults.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&<%=query_string.toString()%>&note_group=<%=note_group%>&note_type=<%=note_type%>&curr_sec_hdg_code=<%=curr_sec_hdg_code%>&curr_child_sec_hdg_code=<%=curr_child_sec_hdg_code%>" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
				<%
					}
					if(totalRecordCount>endIndex)
					{
				%>
						<td class='LABEL' align='center' width='8%'><a class='gridLink' href="../../eCA/jsp/RecPreviousSectionSrchResults.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&<%=query_string.toString()%>&note_group=<%=note_group%>&note_type=<%=note_type%>&curr_sec_hdg_code=<%=curr_sec_hdg_code%>&curr_child_sec_hdg_code=<%=curr_child_sec_hdg_code%>" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
				<%
					}
				%>
					</tr>
				</table>
			<%
			}
			%>
			<table class='grid' width='100%'  align='center' id="">
			<tr id="divTitleTable">
				<td class='columnheadercenter'>Sections</td>
			</tr>
			</table>
			<table class='grid' width='100%'  align='center' id="tablePreRec">
				<tr id="divTitleTable">
					<td class='columnheadercenter'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="eCA.VisitPatientClassEncounterSpecilityDtls.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter'>Note Type Desc</td>
					<td class='columnheadercenter'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				</tr>
			<%

			if(startIndex>1)
			rsSec.absolute((startIndex-1));	
				
				while(rsSec.next())
				{
					tblrow_id		=	"tblrow_id"+(rowCnt);
					rowCnt++;
					
					if( (rowCnt%2)==0 )
						classValue	=	"QRYEVEN";
					else
						classValue	=	"QRYODD";
					
					curr_sec_accession_num			= rsSec.getString("ACCESSION_NUM")==null?"&nbsp;":rsSec.getString("ACCESSION_NUM");
					sec_hdg_code					= rsSec.getString("sec_hdg_code")==null?"&nbsp;":rsSec.getString("sec_hdg_code");
					subsec_hdg_code					= rsSec.getString("subsec_hdg_code")==null?"&nbsp;":rsSec.getString("subsec_hdg_code");
					event_date_time  				= rsSec.getString("event_date_time1")==null?"&nbsp;":rsSec.getString("event_date_time1");
					encounter_desc					= rsSec.getString("encounterdesc")==null?"&nbsp;":rsSec.getString("encounterdesc");
					note_type_desc					= rsSec.getString("note_type_desc")==null?"&nbsp;":rsSec.getString("note_type_desc");
					performed_by_name				= rsSec.getString("performed_by_name")==null?"&nbsp;":rsSec.getString("performed_by_name");
					authorized_by_name				= rsSec.getString("authorized_by_name")==null?"&nbsp;":rsSec.getString("authorized_by_name");
					status1							= rsSec.getString("status")==null?"&nbsp;":rsSec.getString("status");
					clob_notes_section_content_html	= (java.sql.Clob) rsSec.getClob("NOTES_SEC_CONT_HTML");
					
					event_date_time				= com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
					
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
					
					if(!curr_sec_accession_num.equals("")&&sec_hdg_code.equals(curr_sec_hdg_code)&&subsec_hdg_code.equals(curr_child_sec_hdg_code))
					{
					%>
						<tr id='<%=tblrow_id%>' onClick="showPreviousSectionView('<%=curr_sec_accession_num%>','<%=facility_id%>','<%=subsec_hdg_code%>','<%=(rowCnt)%>')" style='cursor:pointer'>
							<td class='gridData'><%=event_date_time%></td>
							<td class='gridData'><%=encounter_desc%></td>
							<td class='gridData'><%=note_type_desc%></td>
							<td class='gridData'><%=performed_by_name%></td>
							<td class='gridData'><%=(authorized_by_name == null || authorized_by_name.equals("") )?"&nbsp;":authorized_by_name%></td>
							<td class='gridData'><%=status_display_text%></td>
						</tr>
					<%
					}
					oldEncline=encline;
				if(rowCnt>=maxRecordsDisp) break;
				}
				
			}
		} 
			
	catch(Exception e){
		System.out.println("Exception@ 501.RecPreviousNotesSrchResults.jsp : "+e);
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		if(rscnt!=null)	rscnt.close();
		if(pstmtcnt!=null) pstmtcnt.close();
		if(rsSec!=null) rsSec.close();
		if(pstmtSec!=null) pstmtSec.close();	
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
				<input type=hidden name=curr_sec_hdg_code value=''>
				<input type=hidden name=curr_child_sec_hdg_code value=''>
</form>
</center>
</body>
</html>






