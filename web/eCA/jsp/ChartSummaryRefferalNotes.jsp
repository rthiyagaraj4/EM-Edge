<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
21/01/2013    IN035928		Nijitha			CHL-CRF-0044 - 35928
18/12/2018   IN067236      	 Sivabagyam M	18/12/2018	Ramesh G	   ML-MMOH-CRF-1148
---------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//[IN035950] Starts
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<%
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
		java.util.Properties p = (java.util.Properties) session
				.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
	%>
	<title><%=title%></title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
			<!-- ****  Modified by kishor kumar n on 05/12/2008 for crf0387 applied new css grid. **** -->
		
		

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
	async function showNoteData(accession_num,from,no_modalval,encounter_id,contr_mod_accession_num,notestatus,note_group_desc)//[IN032721]
	{
		var dialogHeight	= "98vh" ;
		var dialogWidth		= "90vw" ;
		var status			= "no";
		var scroll			= "yes";
		var dialogTop		= "";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
		var no_modal=no_modalval;
		var function_id = "";
		var called_function_id="";
		if(from != 'DISCHARGE_SUMMARY')
		{
		var note_group=note_group_desc;
	    var status=notestatus;

	    var statustxt='';
		
		if(status ==  '3')
	    statustxt =  'Unauthorized'
		else if(status ==  '4')
	    statustxt =  'Authorized'
		else if(status ==  '5')
	    statustxt =  'Modified'
		else if(status ==  '5')
	    statustxt =  'In Error' 
		accession_num=accession_num;	
		}
		var retval = await top.window.showModalDialog('../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+statustxt+'&fun=VCN&called_function_id='+called_function_id+'&encounter_id='+encounter_id+'&function_id='+function_id+'&contr_mod_accession_num='+contr_mod_accession_num,arguments,features);
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='' id='' action="" method="" target="">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	PreparedStatement pstmtcnt = null;
	ResultSet rscnt = null;

	String query_notes_detail = "";
	StringBuffer query_string = new StringBuffer();
	StringBuffer whereClause = new StringBuffer();

	String function_id = "";
	String classValue = "";
	String facility_id = "";
	String accession_num = "";
	String note_type = "";
	String note_type_desc = "";
	String note_group = "";
	String appl_task_id = "";
	String service_code = "";
	String service_name = "";
	String event_title_desc = "";
	String event_date_time = "";
	String performed_by_id = "";
	String performed_by_name = "";
	String authorized_by_name = "";
	String status = "";
	String status1 = "";
	String tblrow_id = "";
	String login_user_id = "";
	String clinician_id = "";
	String resp_id = "";
	String operations_allowed = "";
	String amendment_type = "";
	String privilege_type = "";
	String patient_id = "";
	String encounter_id = "";
	String episode_type = "";
	String lower_limit = "";
	String upper_limit = "";
	String from_date_time = "";
	String to_date_time = "";
	String event_status = "";
	String status_display_text = "";
	String filter = "";
	String strModifiedId = "";
	String patient_class = "";
	String other_unsigned_yn = "";
	String doc_linked = "";
	String doc_linked_note_yn = "";
	String med_anc = "";
	String contr_mod_accession_num = "";
	String performed_by = "";
	String ref_no = "";
	String doc_ref_id = "";
	String Encline = "";
	String oldEncline = "";
	String speciality_code = "";
	String res_encounter_id = "";
	String eventClass="";
	String event_class_desc ="";
	String current_event_class_desc="";	
	boolean isClinician=false;//IN067236
	int rowCnt = 0, maxRecordsDisp = 10;
	int startIndex = 0, endIndex = 0;
	int totalRecordCount = 0, colIndex = 0;
	int sec_count = 0;

	patient_id = (request.getParameter("patient_id") == null) ? ""
			: request.getParameter("patient_id");
	encounter_id = (request.getParameter("encounter_id") == null) ? ""
			: request.getParameter("encounter_id");
	patient_class = (request.getParameter("patient_class") == null) ? ""
			: request.getParameter("patient_class");
	episode_type = (request.getParameter("episode_type") == null) ? ""
			: request.getParameter("episode_type");
	event_status = (request.getParameter("status") == null) ? "0"
			: request.getParameter("status");
	other_unsigned_yn = (request.getParameter("other_unsigned_yn") == null) ? "N"
			: request.getParameter("other_unsigned_yn");
	filter = (request.getParameter("filter") == null) ? "A" : request
			.getParameter("filter");
	function_id = (request.getParameter("function_id") == null) ? ""
			: request.getParameter("function_id");
	from_date_time = (request.getParameter("from_date_time") == null) ? ""
			: request.getParameter("from_date_time");
	to_date_time = (request.getParameter("to_date_time") == null) ? ""
			: request.getParameter("to_date_time");
	lower_limit = (request.getParameter("lower_limit") == null) ? "1"
			: request.getParameter("lower_limit");
	upper_limit = (request.getParameter("upper_limit") == null) ? ("" + maxRecordsDisp)
			: request.getParameter("upper_limit");
	note_type = (request.getParameter("note_type") == null) ? ""
			: request.getParameter("note_type");
	note_group = (request.getParameter("note_group") == null) ? ""
			: request.getParameter("note_group");
	appl_task_id = (request.getParameter("p_appl_task_id") == null) ? ""
			: request.getParameter("p_appl_task_id");
	performed_by = (request.getParameter("performed_by") == null) ? ""
			: request.getParameter("performed_by");
	med_anc = (request.getParameter("med_anc") == null) ? "" : request
			.getParameter("med_anc");
	contr_mod_accession_num = (request
			.getParameter("contr_mod_accession_num") == null) ? ""
			: request.getParameter("contr_mod_accession_num");
	ref_no = (request.getParameter("ref_no") == null) ? "" : request
			.getParameter("ref_no");
	speciality_code = (request.getParameter("speciality_code") == null) ? ""
			: request.getParameter("speciality_code");
	String option_id = (request.getParameter("option_id") == null) ? ""
			: request.getParameter("option_id");
	
	query_string.append("patient_id=");
	query_string.append(patient_id);
	query_string.append("&encounter_id=");
	query_string.append(encounter_id);
	query_string.append("&episode_type=");
	query_string.append(episode_type);
	query_string.append("&function_id=");
	query_string.append(function_id);
	query_string.append("&from_date_time=");
	query_string.append(from_date_time);
	query_string.append("&to_date_time=");
	query_string.append(to_date_time);
	query_string.append("&appl_task_id=");
	query_string.append(appl_task_id);
	query_string.append("&patient_class=");
	query_string.append(patient_class);
	query_string.append("&filter=");
	query_string.append(filter);
	query_string.append("&status=");
	query_string.append(event_status);
	query_string.append("&other_unsigned_yn=");
	query_string.append(other_unsigned_yn);
	query_string.append("&med_anc=");
	query_string.append(med_anc);
	query_string.append("&performed_by=");
	query_string.append(performed_by);
	query_string.append("&ref_no=");
	query_string.append(ref_no);
	query_string.append("&speciality_code=");
	query_string.append(speciality_code);

	from_date_time = com.ehis.util.DateUtils.convertDate(
			from_date_time, "DMYHM", locale, "en");
	to_date_time = com.ehis.util.DateUtils.convertDate(to_date_time,
			"DMYHM", locale, "en");

	startIndex = Integer.parseInt(lower_limit);
	endIndex = Integer.parseInt(upper_limit);

	try {

		con = ConnectionManager.getConnection(request);
		isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
		login_user_id = (String) session.getValue("login_user");
		facility_id = (String) session.getValue("facility_id");
		resp_id = (String) session.getValue("responsibility_id");
		clinician_id = (String) session.getValue("ca_practitioner_id");

		
		query_notes_detail = "select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, b.note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,decode(a.event_class,'PHY$','Physician Notes','CLI$','Clinician Notes','NUR$','Nursing Notes') event_class_desc from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ? and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) and a.event_status NOT IN('9') order by event_class_desc,event_date_time DESC";
		System.out.println("ChartSummaryRefferalSummart.jsp:Line:246:appl_task_id:"+appl_task_id);
		
		pstmt = con.prepareStatement(query_notes_detail.toString(),
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, clinician_id);
		pstmt.setString(++colIndex, login_user_id);
		pstmt.setString(++colIndex, other_unsigned_yn);

		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, clinician_id);
		pstmt.setString(++colIndex, login_user_id);
		pstmt.setString(++colIndex, other_unsigned_yn);
		//	pstmt.setString( ++colIndex,	locale			);
		pstmt.setString(++colIndex, patient_id);

		if (!(appl_task_id.equals("MEDICAL_CERTFICATE"))
				&& !(appl_task_id.equals("MC_CONSULT"))) {
			pstmt.setString(++colIndex, facility_id);
			pstmt.setString(++colIndex, encounter_id);

		}
		pstmt.setString(++colIndex, locale);

		if (!(from_date_time.equals("")))
			pstmt.setString(++colIndex, from_date_time);

		if (!(to_date_time.equals(""))) {
			pstmt.setString(++colIndex, to_date_time);
		}
		if (!(event_status.equals("0"))) {

			pstmt.setString(++colIndex, event_status);
		}
		if (!(contr_mod_accession_num.equals(""))) {

			pstmt.setString(++colIndex, contr_mod_accession_num);
		}
		if ((filter.equals("R"))) {

			pstmt.setString(++colIndex, clinician_id);

		} else if ((filter.equals("S"))) {
			pstmt.setString(++colIndex, clinician_id);

		}

		if (!note_type.equals("")) {

			pstmt.setString(++colIndex, note_type);

		}
	
		if (!performed_by.equals("")) {

			pstmt.setString(++colIndex, performed_by);
		}

		if (!med_anc.equals("")) {

			pstmt.setString(++colIndex, med_anc);
		}
		
		pstmt.setString(++colIndex, "REFERRAL_LETTER");
	
		rs = pstmt.executeQuery();
		
		if (!(rs.next())) {
			out.println("There is no Record found.");
%>

			<%
			} else {
					rs.last();
					totalRecordCount = rs.getRow();
					rs.beforeFirst();
					
					if (totalRecordCount > maxRecordsDisp) {
		%>
	
	<%
		}
	%>
		<table class='grid' width='100%' id='tb1' align='center'>

		
	<%-- 	<tr>
				<td class='columnheadercenter<%=content_ID%>'></td>
				<td class='columnheadercenter<%=content_ID%>'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter<%=content_ID%>'>Event Class Description</td>
				<td class='columnheadercenter<%=content_ID%>'></td>
				<td class='columnheadercenter<%=content_ID%>'></td>
		</tr> --%>
	<%
		/* if (startIndex > 1)
					rs.absolute((startIndex - 1)); */

				String countQuerySec = "select count(*) count  from ca_note_section_view where note_type = ? ";
				pstmtcnt = con.prepareStatement(countQuerySec);

				while (rs.next()) {
					tblrow_id = "tblrow_id" + (rowCnt);

					rowCnt++;

					if ((rowCnt % 2) == 0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";

					facility_id = rs.getString("facility_id") == null ? ""
							: rs.getString("facility_id");
					accession_num = rs.getString("accession_num") == null ? ""
							: rs.getString("accession_num");
					note_type = rs.getString("note_type") == null ? "" : rs
							.getString("note_type");
					note_type_desc = rs.getString("note_type_desc") == null ? ""
							: rs.getString("note_type_desc");
					service_code = rs.getString("service_code") == null ? ""
							: rs.getString("service_code");
					service_name = rs.getString("service_name") == null ? ""
							: rs.getString("service_name");
					service_name = service_name.replace('\'', ' ');
					event_title_desc = rs.getString("event_title_desc") == null ? "&nbsp;"
							: rs.getString("event_title_desc");
					event_date_time = rs.getString("event_date_time1") == null ? ""
							: rs.getString("event_date_time1");
					performed_by_id = rs.getString("performed_by_id") == null ? ""
							: rs.getString("performed_by_id");
					performed_by_name = rs.getString("performed_by_name") == null ? ""
							: rs.getString("performed_by_name");
					authorized_by_name = rs.getString("authorized_by_name") == null ? ""
							: rs.getString("authorized_by_name");
					doc_ref_id = rs.getString("doc_ref_id") == null ? ""
							: rs.getString("doc_ref_id");
					if (appl_task_id.equals("MEDICAL_CERTFICATE")
							|| appl_task_id.equals("MC_CONSULT")) {
						Encline = rs.getString("Encline") == null ? "" : rs
								.getString("Encline");
					}
					//status						=			rs.getString("status")==null?"&nbsp;":rs.getString("status");
					status1 = rs.getString("status") == null ? "&nbsp;"
							: rs.getString("status");
					operations_allowed = rs.getString("operations_allowed") == null ? ""
							: rs.getString("operations_allowed");
					amendment_type = rs.getString("ammendment_type") == null ? ""
							: rs.getString("ammendment_type");
					privilege_type = rs.getString("privilege_type") == null ? ""
							: rs.getString("privilege_type");
					strModifiedId = rs.getString("modifiedid") == null ? ""
							: rs.getString("modifiedid");
					doc_linked_note_yn = rs.getString("doc_linked_note_yn") == null ? "N"
							: rs.getString("doc_linked_note_yn");
					doc_linked = rs.getString("doc_linked") == null ? "N"
							: rs.getString("doc_linked");
					res_encounter_id = rs.getString("encounter_id") == null ? "0"
							: rs.getString("encounter_id");
					event_date_time = com.ehis.util.DateUtils.convertDate(
							event_date_time, "DMYHM", "en", locale);
					
					
					eventClass = rs.getString("EVENT_CLASS") == null ? "0"
							: rs.getString("EVENT_CLASS");
					
					
					event_class_desc = rs.getString("event_class_desc") == null ? "0"
							:rs.getString("event_class_desc");
					if(isClinician&&event_class_desc.equals("Clinician Notes"))//IN067236
						event_class_desc="Therapist Notes";//IN067236
					
					if (doc_linked_note_yn.equals("Y")) {
						pstmtcnt.clearParameters();
						pstmtcnt.setString(1, note_type);
						rscnt = pstmtcnt.executeQuery();

						while (rscnt.next()) {
							sec_count = rscnt.getInt("count");
						}

						if (rscnt != null)
							rscnt.close();
					}

					if (status1.equals("1"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.InProgress.label",
										"common_labels");
					else if (status1.equals("2"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Transcribed.label",
										"common_labels");
					else if (status1.equals("3"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Unauthorized.label",
										"common_labels");
					else if (status1.equals("4"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Authorized.label",
										"common_labels");
					else if (status1.equals("5"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Modified.label",
										"common_labels");
					else if (status1.equals("9"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.InError.label",
										"common_labels");

					String img = "";

					if (doc_linked.equals("Y"))
						img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""
								+ accession_num
								+ "\",\""
								+ note_type
								+ "\")' height='20' title='View Linked File' >";
					else
						img = "&nbsp;";

					if (status1.equals("9")) {
						status_display_text = "<a class='gridLink' href=\"javascript:showNoteStatus('"
								+ accession_num
								+ "',"
								+ tblrow_id
								+ ")\">"
								+ status
								+ "</a>&nbsp;&nbsp;<a class='gridLink' href=\"javascript:showErrorRemarks('"
								+ accession_num
								+ "','"
								+ facility_id
								+ "')\" style='color:red'><b>?</b></a>";
					} else 
					{
						status_display_text = "<a class='gridLink' href=\"javascript:showNoteStatus('"
								+ accession_num
								+ "',"
								+ tblrow_id
								+ ")\">"
								+ status + "</a>";
					}
					
		  		
			%>
				<%if(!current_event_class_desc.trim().equalsIgnoreCase(event_class_desc.trim()))
				{
				
				if("IeStyle.css".equals(sStyle)){%>
				<tr><td class='COLUMNHEADERCENTER' colspan="2"><%=event_class_desc%></td><td class='COLUMNHEADERCENTER'></td><td class='COLUMNHEADERCENTER'></td></tr>
				<%}else{ %>
				<tr><td class='COLUMNHEADERCENTER<%=content_ID%>' colspan="2"><%=event_class_desc%></td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td></tr>					
				<%}
				current_event_class_desc =event_class_desc;
				}
				 %>			
				<tr>
				<td class='gridData' width='50%'><%=note_type_desc%></td>		
				<TD><img class='gridData' src='../../eCA/images/flow_text.gif' onClick="showNoteData('<%=accession_num %>','<%=appl_task_id%>','','<%=res_encounter_id%>','','<%=status%>','');"/></TD>
				<td class='gridData'><%=img%></td>
				<td class='gridData' nowrap><b><%=event_date_time%></td>
				</tr>
		<%	
					}
				}
				if (rscnt != null)
					rscnt.close();
				if (pstmtcnt != null)
					pstmtcnt.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e) {
				//out.println("Exception@1 : " + e);//COMMON-ICN-0181
				e.printStackTrace();
			} finally {
				if (con != null)
					ConnectionManager.returnConnection(con, request);
			}
		%>
</table>
	<input type=hidden name=query_string value='<%=query_string.toString()%>'>
	<input type=hidden name=new_query_string value='<%=request.getQueryString()%>'>

	<!-------------hidden fields for fileupload-------------------->
	<input type=hidden name=accession_num value=''>
	<input type=hidden name=function_id value=''>
	<input type=hidden name=privilege_type value=''>
	<input type=hidden name=forwarded_clinician_id value=''>
	<input type=hidden name=action_comment value=''>
	<input type=hidden name=performed_by_id value=''>
	<input type=hidden name=operation_mode value=''>
	<input type=hidden name=doc_linked_note_yn value=''>
	<input type=hidden name=appl_task_id value=''>
	<input type="hidden" name="called_from" id="called_from" value=''>
	<!--Added by Ambiga.M for 18712 on 2/24/2010   --> 
	<input type=hidden name=forward_mode value=''>


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

