<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
08/05/2019		IN69027			Ramesh G			?				?				MMS-DM-CRF-0150
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%request.setCharacterEncoding("UTF-8");	
    String queryString=request.getQueryString();
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/common.js"  language="javascript"></script>
<script language='javascript' src='../js/MDSForDiagnosisMandatory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='MDSForDiagnosisMandatoryHdrFrom' id='MDSForDiagnosisMandatoryHdrFrom'>
<BR>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='label'  width='24.75%'><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></td>
			<td class='fields' >&nbsp;&nbsp;
				<select name='minimumData' id='minimumData' onChange='showResultData();'>						
					<option value="S" selected><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option>
					<option value="P"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></option>				
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
			</td>
		</tr>
		<tr><td colspan="2"></td></tr>
		<tr>
			<td class='label'  width='24.75%'><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
			<td class='fields' >&nbsp;&nbsp;
				<select name='termsetId' id='termsetId' onChange='showResultData();'>					
					<option value="ICD10" selected >ICD10</option>
					<option value="ICD9CMD">ICD9CM - Diagnosis</option>				
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
			</td>
		</tr>
	</table>
	<script>
		showResultData();
	</script>
</form>
</body>
</html>

