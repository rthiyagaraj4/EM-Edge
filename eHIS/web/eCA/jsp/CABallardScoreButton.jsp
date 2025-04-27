<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/02/2018		IN063837		Ramesh Goli											ML-MMOH-CRF-0812
09/25/2018      IN067564        Ramya Maddena       10/09/2018      Ramesh Goli     ML-MMOH-CRF-1186
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,java.sql.*, eCA.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><!--IN067564-->

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//IN067564 starts
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String bean_id="@caballardscore"+patient_id+encounter_id;
	String bean_name="eCA.CABallardScoreBean";
	eCA.CABallardScoreBean beanObj = (eCA.CABallardScoreBean)getObjectFromBean(bean_id,bean_name,session);
		
String RecordedScoreYN = beanObj.getBallardScoreNotRecordedYN(request,patient_id,encounter_id,"","");

	
String btnEnable = "";
if(RecordedScoreYN.equals("Y"))
	btnEnable = "";
else
	btnEnable = "disabled";
//IN067564 ends
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language='javascript' src='../js/CABallardScore.js'></script>
<script language='javascript' src='../js/json2.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="BallardScoreButtonForm" id="BallardScoreButtonForm">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    <td align="right" valign="center">
		<input type='button' class='button' name='record' id='record' value='Record' onclick='apply()'>
		<input type='Button' class="button" name='reset' id='reset' value=' Reset ' onclick='reSet()'>
		<input type='button' class='button' name='print' id='print' value='Print' onclick='printBallardScore()' >
		<input type='button' class='button' name='audittrail' id='audittrail' <%=btnEnable%> value='Audit Trail' onclick='ShowHistory1()' ><!--IN067564-->
		
	</td>
  </tr>	
</table>
<script>
if(parent.BallardScoreFrame != null)
parent.BallardScoreFrame.location.href='../../eCA/jsp/CABallardScore.jsp?<%=request.getQueryString()%>';
</script>
</form>
</body>
</html>

