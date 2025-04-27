<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%><html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<head>
		<title><fmt:message key="eCP.RecordButton.label" bundle="${cp_labels}"/></title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
    	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<jsp:useBean id="diagBean" class="eCP.PatientAssessmentDiag" scope="session"/>
<%
//This file is saved on 19/11/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
	<body onmousedown = 'CodeArrest()'>
		<form name='patAssessRecordBtnForm' id='patAssessRecordBtnForm' action=''>
		<%
			String disableButton = "";
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String status = request.getParameter("status") == null ? "" : request.getParameter("status");
			String status_flag = request.getParameter("status_flag") == null ? "" : request.getParameter("status_flag");
			String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag");

			if(mode.equals("modify") && status_flag.equals("4") && !flag.equals("modAuth"))
			{
				disableButton       = " style='display:none' ";
			}
			else
			{
				disableButton = " style='display:inline' ";
			}
		%>
			<table width='100%' align='center' border=0 cellpadding='0' cellspacing=0>
				<tr>
					<td align='right'>
						<input type='button' name='printPreview' id='printPreview' class='button' value='<fmt:message key="Common.PrintPreview.label" bundle="${common_labels}"/>' onClick="PrintPreview();">
						<input type='button' name='assessRecord' id='assessRecord' class='button' <%=disableButton%> value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick='recordValues()'>
					
						<input type='button' name='assessClear' id='assessClear' class='button' <%=disableButton%> value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearValues('<%=mode%>','<%=status%>','<%=status_flag%>')">
						<input type='button' name='assessCancel' id='assessCancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='closeWindow()' style="visibility:hidden">
					</td>
				</tr>
			</table>			
	</form>
	</body>
</html>

