<!DOCTYPE html>
<%
/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

20/10/2020      IN073108    		Nijitha				20/10/2020       Ramesh G       ML-MMOH-CRF-1546
15/03/2021		15904				Durga Natarajan		15/03/2021		 Ramesh G		ALPHA-CA-Clinical Notes Audit Trail Report-Label Issue
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="eCA.CAClinicalNotesAuditTrialReportBean"%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>Insert title here</title>
</head>
<form name="clinialaudittraislreportresult" id="clinialaudittraislreportresult">
<%
String total_query_records  = "0";
String patient_id			=	(request.getParameter("patientId")==null) ?	""	:	request.getParameter("patientId");
String encounter_id		=	(request.getParameter("encounterId")==null) ?	""	:	request.getParameter("encounterId");
String note_type			=(request.getParameter("note_type")==null)?"":request.getParameter("note_type");
String note_group			=	(request.getParameter("note_group")==null)?"":request.getParameter("note_group");
String from_date_time		=	(request.getParameter("p_fm_Date")==null)	?	""	:	request.getParameter("p_fm_Date");
String to_date_time		=	(request.getParameter("p_to_Date")==null)	?	""	:	request.getParameter("p_to_Date");
String authorised_by = (request.getParameter("authorised_by")==null)?"":request.getParameter("authorised_by");
String locn_code = (request.getParameter("locn_code")==null)?"":request.getParameter("locn_code");
ArrayList resultsData = new ArrayList();
CAClinicalNotesAuditTrialReportBean auditTrialReportBean = new CAClinicalNotesAuditTrialReportBean();
String from	 = "1";

String to	 ="7";
	int start	 = Integer.parseInt(from);
int end		 = Integer.parseInt(to);
resultsData = auditTrialReportBean.getClinicalNotesAuditTrialReportResult(localeName,patient_id,encounter_id,note_group,note_type,authorised_by,from_date_time,to_date_time,start, end);
if(resultsData.size() == 0)
{
%>
	<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))
	</script>

<%	}
%>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<div style="height: 600px;overflow-y: scroll;">
	<table border=0 cellspacing=0 cellpadding=3 width='80%' align=center>
		<th align='left'>Report Result
		</th>
	
	<tr>
		<td width="100%" class="Border" align='center'>

			<table width='100%' cellPadding="0" cellSpacing="0"  align='center' >
			<tr>
				<td width="15%" class='columnheadercenter'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
				<td width="15%" class='columnheadercenter'><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td> <!-- 15904 Bundle changed from common to ca -->
				<td width="15%" class='columnheadercenter'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
				<td width="15%" class='columnheadercenter'><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></td>
				<td width="15%" class='columnheadercenter'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
				<td width="15%" class='columnheadercenter'><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
				<td width="5%" class='columnheadercenter'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
			</tr>	
			</table>
		</td>
	</tr>
<%	for(int k=0; k<resultsData.size(); k++){		
		String[] report_details = (String[])resultsData.get(k);		
		%>
			<tr>
				<td width="100%" class="Border" >

				<table width='100%' cellPadding="0" cellSpacing="0" >
				<tr align="left">
					<td width="15%"><%=report_details[0] %></td>
					<td width="15%"><%=report_details[6] %></td>
					<td width="15%"><%=report_details[7] %></td>
					<td width="15%"><%=report_details[3] %></td>
					<td width="15%"><%=report_details[8] %></td>
					
					<td width="15%"><%=(report_details[9]==null)?"":report_details[9]%></td>
					<td width="5%"><input type="radio" name="selectedRow" id="selectedRow"  value='<%=k%>'></td>
					<input type ="hidden" name="accessionNum<%=k%>" id="accessionNum<%=k%>" id = "accessionNum<%=k%>" value="<%=report_details[10] %>">
					<input type ="hidden" name="noteType<%=k%>" id="noteType<%=k%>" id = "noteType<%=k%>" value="<%=report_details[2] %>">
					<input type ="hidden" name="recordedFacility<%=k%>" id="recordedFacility<%=k%>" id = "recordedFacility<%=k%>" value="<%=report_details[11] %>">
				</tr>
				</table>
				</td>
			</tr>	
		<%
		
	}%>	
	</table
	</div>
</body>
</form>
</html>

