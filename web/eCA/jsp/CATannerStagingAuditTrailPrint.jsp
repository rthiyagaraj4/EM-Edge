<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
23/10/2018		IN067402		Prakash		10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1				
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
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print</title>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../js/CATannerStaging.js'></script>
		<script language='javascript' src='../js/json2.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
 <form name="TannerStageForm1" id="TannerStageForm1" method="post" target="messageFrame">
 <%
 System.out.println("value at print--"+request.getQueryString());
 
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String isAuditYN =request.getParameter("isAuditYN")==null?"N":request.getParameter("isAuditYN");
String isPrintEnableYn = request.getParameter("isPrintEnableYn")==null?"N":request.getParameter("isPrintEnableYn");
String patientSex=request.getParameter("sex")==null?"U":request.getParameter("sex");
String stageOfPuberty = request.getParameter("stageOfPuberty")==null?"":request.getParameter("stageOfPuberty");
String pubicHair = request.getParameter("pubicHair")==null?"":request.getParameter("pubicHair");
String recorded_date = request.getParameter("Recorded_date")==null?"":request.getParameter("Recorded_date");
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    <td align="right" valign="center">
		<input type='button' class='button' name='print' id='print' value='Print' <%if(!isPrintEnableYn.equals("Y")){%> disabled <%}%> onclick='printTannerStaging()' >
		
		 <input type="hidden" id="patient_id" name="patient_id" id="patient_id" value="<%=patient_id%>"/>
		 <input type="hidden"  id="encounter_id" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"/>
		 <input type="hidden"  id="patientSex" name="patientSex" id="patientSex" value="<%=patientSex%>"/>
		 <input type="hidden"  id="stageOfPuberty" name="stageOfPuberty" id="stageOfPuberty" value="<%=stageOfPuberty%>"/>
		 <input type="hidden"  id="pubicHair" name="pubicHair" id="pubicHair" value="<%=pubicHair%>"/>
		 <input type="hidden"  id="isAuditYN" name="isAuditYN" id="isAuditYN" value="<%=isAuditYN%>"/>
		 <input type="hidden"  id="recorded_date" name="recorded_date" id="recorded_date" value="<%=recorded_date%>"/>
	</td>
  </tr>	
</form>
</body>
</html>

