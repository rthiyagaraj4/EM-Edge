<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/05/2018	IN063838		Ramesh G											ML-MMOH-CRF-0813
23/10/2018	IN067402	Prakash		10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id"); 
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String patientSex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
//IN067402 Starts
String recordedScoreYN = request.getParameter("recordedScoreYN")==null?"":request.getParameter("recordedScoreYN");
String Age = request.getParameter("Age")==null?"":request.getParameter("Age");
String isAuditYN =request.getParameter("isAuditYN")==null?"N":request.getParameter("isAuditYN");
String recorded_date = request.getParameter("recorded_date")==null?"":request.getParameter("recorded_date");

String btnEnable = "";
if(recordedScoreYN.equals("Y"))
	btnEnable = "";
else
	btnEnable = "disabled";
//IN067402 ends
%>
<html>
	<head>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../js/CATannerStaging.js'></script>
		<script language='javascript' src='../js/json2.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="TannerStagingButtonForm" id="TannerStagingButtonForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align="right" valign="center">
						<input type='button' class='button' name='record' id='record' value='Record' onclick='apply()'>
						<input type='Button' class="button" name='reset' id='reset' value=' Reset ' onclick='reSet()'>
						<input type='button' class='button' name='print' id='print' value='Print' onclick='printTannerStaging()' >
						<input type='button' class='button' name='audittrail' id='audittrail' <%=btnEnable%> value='Audit Trail' onclick='ShowAuditTrail()' <!--IN067402-->
						<input type='hidden'  name="patient_id" id="patient_id" value='<%=patient_id%>'>
						<input type='hidden'  name="encounter_id" id="encounter_id" value='<%=encounter_id%>'>
						<input type='hidden'  name="patientSex" id="patientSex" value='<%=patientSex%>'>
				<!--IN067402 starts-->		
						<input type='hidden'  name="Age" id="Age" value='<%=Age%>'>
						<input type='hidden'  name="isAuditYN" id="isAuditYN" value='<%=isAuditYN%>'>
						<input type="hidden"  id="recorded_date" name="recorded_date" id="recorded_date" value="<%=recorded_date%>"/>
				<!--IN067402 ends-->
					</td>
				</tr>	
			</table>
			<script>
			if(parent.TannerStagingFrame != null){
				if('<%=patientSex%>'=="M")
					parent.TannerStagingFrame.location.href='../../eCA/jsp/CATannerStagingMale.jsp?<%=request.getQueryString()%>';
				else if('<%=patientSex%>'=="F")
					parent.TannerStagingFrame.location.href='../../eCA/jsp/CATannerStagingFemale.jsp?<%=request.getQueryString()%>';	
			}
			</script>
		</form>
	</body>
</html>

