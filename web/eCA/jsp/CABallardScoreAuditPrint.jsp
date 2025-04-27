<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
9/17/2018		IN067564	     Ramya Maddena		10/09/2018				Ramesh Goli		ML-MMOH-CRF-1186					
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
<script language='javascript' src='../js/CABallardScore.js'></script>
<script language='javascript' src='../js/json2.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
 <form name="BallardScoreForm1" id="BallardScoreForm1" method="post" target="messageFrame">
 <%
 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String isAuditYN = request.getParameter("isAuditYN")==null?"":request.getParameter("isAuditYN");
String Recorded_date = request.getParameter("Recorded_date")==null?"":request.getParameter("Recorded_date");
String isPrintEnableYn = request.getParameter("isPrintEnableYn")==null?"N":request.getParameter("isPrintEnableYn");
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    <td align="right" valign="center">
		
		<input type='button' class='button' name='print' id='print' value='Print' <%if(!isPrintEnableYn.equals("Y")){%> disabled <%}%> onclick='printBallardScoreRecord()' >
		<input type="hidden" id="patientId" name="patientId" id="patientId" value="<%=patient_id%>"/>
		 <input type="hidden"  id="encounterId" name="encounterId" id="encounterId" value="<%=encounter_id%>"/>
		 <input type="hidden" name="isAuditYN" id="isAuditYN" value="<%=isAuditYN%>"/>
         <input type="hidden" name="Recorded_date" id="Recorded_date" value="<%=Recorded_date%>"/>
	</td>
  </tr>	
</form>
</body>
</html>

