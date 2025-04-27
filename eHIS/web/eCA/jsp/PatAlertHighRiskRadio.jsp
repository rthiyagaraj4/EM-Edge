<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- ****  Modified by kishor kumar n on 04/12/2008 for crf0387 applied new css grid. **** -->
		
		
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String patient_id = request.getParameter("patient_id");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
%>
<script>
function CallDescFrame(Obj){
	if("<%=called_from_ip%>" == "Y"){
	parent.parent.PatAlertQueryResult.location.href='../../eCA/jsp/PatAlertQueryResult.jsp?called_from_ip=<%=called_from_ip%>';
			var selected_val =Obj.value;
		parent.parent.PatAlertHighRiskMainFrame.PatAlertQueryHighRiskDesc.location.href='../../eCA/jsp/PatAlertQueryHighRiskDesc.jsp?radio_par='+selected_val+'&patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>'
	}else{
		top.content.workAreaFrame.PatAlertQueryResult.location.href='../../eCA/jsp/PatAlertQueryResult.jsp?called_from_ip=<%=called_from_ip%>';
			var selected_val =Obj.value;
		top.content.workAreaFrame.PatAlertHighRiskMainFrame.PatAlertQueryHighRiskDesc.location.href='../../eCA/jsp/PatAlertQueryHighRiskDesc.jsp?radio_par='+selected_val+'&patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>'
	}
}
</script>
<form name="radio_high_risk" id="radio_high_risk">
<table width=100% height=100% class='grid'align='center'>
	<tr>
		<td class='gridData'>
		<input type="radio" name="high_risk_cond_radio" id="high_risk_cond_radio" class="label" value="A" onClick="CallDescFrame(this)" checked><font size=1><fmt:message key="eCA.ActiveOnly.label" bundle="${ca_labels}"/></font>
		&nbsp&nbsp&nbsp&nbsp<input type="radio" name="high_risk_cond_radio" id="high_risk_cond_radio" class="label" value="O" onClick="CallDescFrame(this)"><font size=1><fmt:message key="Common.all.label" bundle="${common_labels}"/></font>
		</td>
	</tr>
	<tr>
		<td class='columnheader'><font size=1><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>

