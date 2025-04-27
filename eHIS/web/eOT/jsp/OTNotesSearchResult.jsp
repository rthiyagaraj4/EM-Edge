<!DOCTYPE html>
<!-- Created Against ML-MMOH-CRF-1208 [IN:068081] -->

<%@page import="java.sql.*,eCommon.Common.CommonBean,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp"%>
<html>
<head>
<title>
	<fmt:message key="eOT.Ot.Label" bundle="${ot_labels}"/>&nbsp;
	<fmt:message key="Common.notes.label" bundle="${common_labels}"/>&nbsp;
	<fmt:message key="Common.search.label" bundle="${common_labels}"/>&nbsp;
	<fmt:message key="Common.Result.label" bundle="${common_labels}"/>
</title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />		
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eOT/js/OTNotesSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
	A:ACTIVE {
		COLOR: WHITE;
		TEXT-DECORATION : NONE;
	}

	TD.CAPOPUPMENULAYER
	{
		  FONT-FAMILY: VERDANA;
		  FONT-SIZE: 10PT;
		  BACKGROUND-COLOR: #D8BFD8;
		  COLOR: BLUE;
	 }
	 TD.CAPOPUPMENU
	{	
		BACKGROUND-COLOR: #C0C0C0;
		FONT-SIZE: 9PT;
		BORDER-STYLE: DASHED;
		BORDER-LEFT-COLOR: #FFA500;
		BORDER-RIGHT-COLOR: #FFA500;
		BORDER-TOP-COLOR: #FFFACD;
		BORDER-BOTTOM-COLOR: #FFFACD;
	}
	</style>	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='OTNotesSearchhResultForm' id='OTNotesSearchhResultForm' action="" method="" target="">
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;	
	StringBuffer sqlQueryBuffer	=	new StringBuffer();
	StringBuffer whereClause	=	new StringBuffer();
	int	rowCnt					=	0,	maxRecordsDisp		=	10;
	int	startIndex				=	0,	endIndex			=	0;
	int	totalRecordCount		=	0,	colIndex			=	0;
	String patient_id			=	(request.getParameter("patient_id")==null) ?	""	:	request.getParameter("patient_id");
	String encounter_id		=	(request.getParameter("encounter_id")==null) ?	""	:	request.getParameter("encounter_id");
	String fromDateTime		=	(request.getParameter("fromDateTime")==null)	?	""	:	request.getParameter("fromDateTime");
	String toDateTime		=	(request.getParameter("toDateTime")==null)	?	""	:	request.getParameter("toDateTime");
	String lower_limit		=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
	String upper_limit		=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
	String noteType			=(request.getParameter("noteType")==null)?"":request.getParameter("noteType");
	String appl_task_id		=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	String facility_id		=	(String)		session.getValue("facility_id");
	String login_user_id	=	(String)		session.getValue("login_user");
	String status_display_text =	"";
	StringBuffer  query_string = new StringBuffer();
	query_string.append("patient_id=");		query_string.append(patient_id);
	query_string.append("&encounter_id=");	query_string.append(encounter_id);
	query_string.append("&fromDateTime="); query_string.append(fromDateTime);
	query_string.append("&toDateTime="); query_string.append(toDateTime);
	query_string.append("&appl_task_id="); query_string.append(appl_task_id);

	//Billing Logic Start 
	boolean bill_flag = false; 
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	CallableStatement cstmt = null;
	//Billing Logic end
	boolean  isModifyNote        =   false ; //Added Against ML-MMOH-CRF-1993
	String locale = (String)session.getAttribute("LOCALE");//Added Against ML-MMOH-CRF-1993
	String fileName   =  "";
	
	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);

	try{
			con = ConnectionManager.getConnection(request);
			
			//Billing Logic Start
			cstmt=con.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,facility_id);
			cstmt.setString(2,facility_id);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.VARCHAR);
			cstmt.registerOutParameter(5,Types.VARCHAR);
			cstmt.registerOutParameter(6,Types.VARCHAR);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
			cstmt.execute();
			if(!checkForNull(cstmt.getString(5)).equals("Y")){
				bl_installed=cstmt.getString(3);
				bl_interface=cstmt.getString(4);
				bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
			}else{
				err_text = cstmt.getString(8);
			}	
			//Billing Logic end			
			
			if(!(fromDateTime.equals(""))){
				whereClause.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy' ) ");
			}
			if(!(toDateTime.equals(""))){
				whereClause.append(" 	and a.event_date_time <= (to_date( ?,'dd/mm/yyyy' ) + 1)");
			}
			
			if(!noteType.equals("")){
				whereClause.append(" 	and a.NOTE_TYPE=? " );
			}
			
			isModifyNote = CommonBean.isSiteSpecific(con,"OT","OT_MODIFY_NOTE");//Added against ML-MMOH-CRF-1993
			
		
		if(isModifyNote){
			sqlQueryBuffer.append("SELECT DISTINCT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name, nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, OT.APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC,a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE, A.CONTR_MOD_ACCESSION_NUM ," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status  FROM  OT_SCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B , CA_NOTE_GROUP C  ,am_practitioner d, am_practitioner e, am_service f,AT_ANAESTHESIA_RECORD_HDR g  WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code  AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND C.APPL_TASK_ID = 'OT_NOTES' AND B.NOTE_GROUP_ID = C.NOTE_GROUP AND OT.LANGUAGE_ID = '"+locale+"' AND ot.oper_num != ' ' AND (SUBSTR(a.contr_mod_accession_num,'3','10') = ot.oper_num OR (SUBSTR(a.contr_mod_accession_num,'3',length(G.ANAESTHESIA_SERIAL_NUM)) = G.ANAESTHESIA_SERIAL_NUM and ot.order_id=g.source_order_id))");//Modified Against ML-MMOH-CRF-1993
			//AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30')
			sqlQueryBuffer.append(whereClause);

			sqlQueryBuffer.append(" UNION  SELECT DISTINCT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name,nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, '' APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC, a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE, A.CONTR_MOD_ACCESSION_NUM ," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status FROM  OT_UNSCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B , CA_NOTE_GROUP C ,am_practitioner d, am_practitioner e, am_service f, AT_ANAESTHESIA_RECORD_HDR g WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND C.APPL_TASK_ID = 'OT_NOTES' AND B.NOTE_GROUP_ID = C.NOTE_GROUP AND OT.LANGUAGE_ID = '"+locale+"' AND  (SUBSTR(a.contr_mod_accession_num,'3','10') = ot.oper_num OR (SUBSTR(a.contr_mod_accession_num,'3',length(G.ANAESTHESIA_SERIAL_NUM)) = G.ANAESTHESIA_SERIAL_NUM and ot.order_id=g.source_order_id))");//Modified Against ML-MMOH-CRF-1993
			//AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30')
		}else{
			sqlQueryBuffer.append("SELECT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name, nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, OT.APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC,a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status  FROM  OT_SCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B ,am_practitioner d, am_practitioner e, am_service f  WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code  AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30') ");
			sqlQueryBuffer.append(whereClause);

			sqlQueryBuffer.append(" UNION  SELECT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name,nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, '' APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC, a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status FROM  OT_UNSCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B ,am_practitioner d, am_practitioner e, am_service f WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30')");
			//Added EXT_IMAGE_APPL_ID Against ML-MMOH-CRF-1977.1
		
			}
			sqlQueryBuffer.append(whereClause);	
			pstmt =	con.prepareStatement(sqlQueryBuffer.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		   
			pstmt.setString(++colIndex,	patient_id);
			pstmt.setString(++colIndex,	facility_id);	
			pstmt.setString(++colIndex,	encounter_id);
			
			if(!(fromDateTime.equals(""))){
				pstmt.setString	(++colIndex, fromDateTime);
			}
			if(!(toDateTime.equals(""))){
				pstmt.setString	(++colIndex, toDateTime);			
			}
			if(!noteType.equals("")){
				pstmt.setString	(++colIndex, noteType);			
			}
			pstmt.setString(++colIndex,	patient_id);
			pstmt.setString(++colIndex,	facility_id);	
			pstmt.setString(++colIndex,	encounter_id);

			if(!(fromDateTime.equals(""))){
				pstmt.setString(++colIndex, fromDateTime);
			}

			if(!(toDateTime.equals(""))){
				pstmt.setString	(++colIndex, toDateTime);
			}
			if(!noteType.equals("")){
				pstmt.setString	(++colIndex, noteType);
			}
			
			rs				=	pstmt.executeQuery();
			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
		
			if( totalRecordCount>maxRecordsDisp){
%>
		<table  class='gridComponentHolder' WIDTH='100%' align='center'  >
		<tr><td CLASS='BODYCOLORFILLED' >&nbsp;</td>	
<%
		if(startIndex>maxRecordsDisp){
%>
			<td class='LABEL'  width='8%'><a class='gridLink' href="../../eOT/jsp/OTNotesSearchResult.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&<%=query_string.toString()%>&noteType=<%=noteType%>" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
<%
		}
		if(totalRecordCount>endIndex){
%>
			<td class='LABEL' align='center' width='8%'><a class='gridLink' href="../../eOT/jsp/OTNotesSearchResult.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&<%=query_string.toString()%>&noteType=<%=noteType%>" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
<%
		}
%>
		</tr></table>
<%
		}
		if(totalRecordCount == 0){
%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>
<%	
		 }	
%>
		<table class='grid' width='100%' id='tb1' align='center'>
		<th class='columnheadercenter'><fmt:message key="eOT.OperDate.Label" bundle="${ot_labels}"/></th>
		<th class='columnheadercenter'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></th>
		<th></th>
		<th class='columnheadercenter'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter'><fmt:message key="eOT.OperNum.Label" bundle="${ot_labels}"/></th>
		<th class='columnheadercenter'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter'><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>		
<%
		
		if(startIndex>1){
			rs.absolute((startIndex-1));
		}
		String doc_linked = "";
		String img = "";
		String accessionNum = null;
		String noteTypeDesc = null;
		String eventDateTime = null;
		String performedById = null;
		String operNum = null;
		String bookingNum = null;
		String operDate = null;
		String operCode = null;
		String specialityCode = null;
		String specialityDesc = null;
		String surgeonCode = null;
		String nursingDocCompYN = null;
		String surgeonDocCompYN = null;
		String anesDocCompYN = null;
		String orderId = null;
		String tblrow_id = null;
		String classValue = null;
		String performed_by_name = null;
		String authorized_by_name = null;
		String status = null;
		String CONTR_MOD_ACCESSION_NUM = "";//Added Against ML-MMOH-CRF-1993
		
		while(rs.next()){
			tblrow_id		=	"tblrow_id"+(rowCnt);
			rowCnt++;
			if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";
			
			facility_id	= rs.getString("OPERATING_FACILITY_ID")==null?"":rs.getString("OPERATING_FACILITY_ID");
			noteType =rs.getString("NOTE_TYPE")==null?"":rs.getString("NOTE_TYPE");
			accessionNum = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			doc_linked = rs.getString("doc_linked")==null?"":rs.getString("doc_linked"); //Added Against ML-MMOH-CRF-1977.1
			noteTypeDesc = rs.getString("NOTE_TYPE_DESC")==null?"":rs.getString("NOTE_TYPE_DESC");
			eventDateTime = rs.getString("EVENT_DATE_TIME1")==null?"":rs.getString("EVENT_DATE_TIME1");
			performedById = rs.getString("PERFORMED_BY_ID")==null?"":rs.getString("PERFORMED_BY_ID");
			operNum = rs.getString("OPER_NUM")==null?"":rs.getString("OPER_NUM");
			bookingNum = rs.getString("APPT_REF_NUM")==null?"":rs.getString("APPT_REF_NUM");
			operDate = rs.getString("OPER_DATE")==null?"":rs.getString("OPER_DATE");
			operCode = rs.getString("OPER_CODE")==null?"":rs.getString("OPER_CODE");
			specialityCode = rs.getString("service_code")==null?"":rs.getString("service_code");
			specialityDesc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
			surgeonCode = rs.getString("SURGEON_CODE")==null?"":rs.getString("SURGEON_CODE");
			nursingDocCompYN = rs.getString("NURSING_DOC_COMP_YN")==null?"N":rs.getString("NURSING_DOC_COMP_YN");
			surgeonDocCompYN = rs.getString("SURGEON_DOC_COMP_YN")==null?"N":rs.getString("SURGEON_DOC_COMP_YN");
			anesDocCompYN = rs.getString("ANAESTHESIA_DOC_COMP_YN")==null?"N":rs.getString("ANAESTHESIA_DOC_COMP_YN");
			orderId = rs.getString("ORDER_ID")==null?"":rs.getString("ORDER_ID");
			performed_by_name = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
			authorized_by_name = rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
			status = rs.getString("status")==null?"":rs.getString("status");
			if(isModifyNote){
			CONTR_MOD_ACCESSION_NUM = rs.getString("CONTR_MOD_ACCESSION_NUM")==null?"":rs.getString("CONTR_MOD_ACCESSION_NUM");//Added Against ML-MMOH-CRF-1993
			}		
			if(status==null || status.equals(""))	status ="&nbsp;";		
			
			if(status.equals("In Error")){
			 status_display_text ="<a href=\"javascript:showNoteStatus('"+accessionNum+"',"+tblrow_id+")\">"+status+"</a>&nbsp;&nbsp;<a href=\"javascript:showErrorRemarks('"+accessionNum+"','"+facility_id+"')\" style='color:red'><b>?</b></a>";
			}else if( !(status.equals("In Progress")) ){
				status_display_text	=	"<a href=\"javascript:showNoteStatus('"+accessionNum+"',"+tblrow_id+")\">"+status+"</a>";
			}else{
				status_display_text	=	status;
			}
			
		//Added Against ML-MMOH-CRF-1993...starts
		if(isModifyNote){
		String str = CONTR_MOD_ACCESSION_NUM.substring(CONTR_MOD_ACCESSION_NUM.length()-2 , CONTR_MOD_ACCESSION_NUM.length());
		String[] str1 = CONTR_MOD_ACCESSION_NUM.substring(2).split("(?<=\\d)(?=\\D)");
		
		
			if(str.equals("30")) fileName = "../../eOT/jsp/RecordSurgeon.jsp?&tab_name=SCHEDULED";
			else if(str.equals("99")) fileName = "../../eOT/jsp/RecordNursing.jsp?";
			else if(str.equals("RE")) fileName = "../../eOT/jsp/AT_PreAnaesthesia.jsp?&tab_name=AnesthesiaDetails&anesthesia_srl_no="+str1[0];
			else if(str.equals("RA")) fileName = "../../eOT/jsp/AT_IntraAnaesthesia.jsp?&anesthesia_srl_no="+str1[0];
			else if(str.equals("ST")) fileName = "../../eOT/jsp/AT_PostAnaesthesia.jsp?&anesthesia_srl_no="+str1[0];
			else if(str.equals("40")) fileName = "../../eOT/jsp/OTChkInRecoveryRoom.jsp?&recovery_in_out_flag=CHECK_IN_RECO";
			else if(str.equals("10")) fileName = "../../eOT/jsp/OTHoldingArea.jsp?&function_id=OT_HOLDING_AREA";
		}else{
			fileName = "../../eOT/jsp/RecordSurgeon.jsp?";
		}
				String QueryString = fileName +  "&module_id=OT&function_type=F&menu_id=null&access=NYNNY&home_required_yn=N&called_from=OT_SLATE" 
				+ "&patient_id="+ patient_id + "&oper_num=" + operNum + "&booking_num=" + bookingNum + "&booking_no=" + bookingNum + "&waitlist_no=&slate_user_id=" + login_user_id 
				+ "&surgeon_doc_comp_yn=" + surgeonDocCompYN + "&nursing_doc_comp_yn=" +  nursingDocCompYN + "&anesthesia_doc_comp_yn=" + anesDocCompYN + "&order_id=" + orderId 
				+ "&speciality_code=" + specialityCode + "&facility_id=" + facility_id + "&oper_code=" + operCode + "&theatre_date=" + operDate + "&surgeon_code=" + surgeonCode + "&fromModifySurgeon=Y"+"&bill_flag="+bill_flag;//Modified Against ML-MMOH-CRF-1993
			//ML-MMOH-CRF-1977.1 Starts
			if(doc_linked.equals("Y"))
							img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accessionNum+"\",\""+noteType+"\")' height='20' title='View Linked File' >";
			else
			img = "&nbsp;";
			//ML-MMOH-CRF-1977.1 Ends			
%>
			<tr id='<%=tblrow_id%>'>
				<td class='gridData'><%=operDate%></td>
				<td class='gridData'><a class='gridLink' href=javascript:callRecordSurgeonNotes("<%=QueryString%>")><%=noteTypeDesc%></a>&nbsp;</td>
				<td><%=img%></td>
				<td class='gridData'><%=specialityDesc%></td>
				<td class='gridData'><%=operNum%></td>
				<td class='gridData'><%=performed_by_name%></td>
				<td class='gridData'><%=authorized_by_name%></td>
				<td class='gridData'><%=status_display_text%></td>
			</tr>
<%			
		if(rowCnt>=maxRecordsDisp) break;
		}		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();		
	}catch(Exception e){
		System.err.println("OTNotesSearchResult.jsp==="+e);
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
	</table>
	<input type="hidden" name="query_string" id="query_string" value='<%=query_string.toString()%>'>
	<input type="hidden" name="new_query_string" id="new_query_string" value='<%=request.getQueryString()%>'>
</form>
</center>
</body>
</html>

