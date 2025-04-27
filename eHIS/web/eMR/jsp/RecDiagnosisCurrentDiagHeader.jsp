<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	%>
<html>
<script src='../js/RecDiagnosis.js' language='javascript'></script>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='query_form_header' id='query_form_header'>

		<table border='0' width='100%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center' >
			<tr><td class="COLUMNHEADER" colspan='7' style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size='1'><fmt:message key="eMR.CurrentDiagnosisProfile.label" bundle="${mr_labels}"/></font></td>
			</tr>
		</table>
		<!--<table border='1' width='100%' id='' cellpadding='0' cellspacing='0' align='center' >
		<tr>
				<td align='center' width='2%'><font size=1 >&nbsp;</font></td>
				<td align='center' width='2%'><font size=1 >&nbsp;</font></td>
				<td align='center'  width='30%'><font size=1 align='top'><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></font></td>
<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->
<!--				<td color='red' align='center' width='10%'><font size=1 ><fmt:message key="eMR.ApplicableSide.label" bundle="${mr_labels}"/></font></td>
																														<td color='red' align='center' width='9%'><font size=1 ><fmt:message			key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/></font></td>

				<td color='red' align='center' width='9%'><font size=1 ><fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/></font></td>
				<td color='red' align='center' width='9%'><font size=1 ><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></font></td>
				
				<td align='center' width='10%'><font size=1 ><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></font></td>
				<td align='center' width='9%'><font size=1 ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></font></td>
				<td align='center' width='7%'><font size=1 ><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></td>
				<td align='center' width='8%'><font size=1 ><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></font></td>
		</tr>
		</table>-->
		
</form>

</body>
</html>

