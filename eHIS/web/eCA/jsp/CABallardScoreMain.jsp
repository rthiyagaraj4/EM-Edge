<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/02/2018		IN063837		Ramesh Goli											ML-MMOH-CRF-0812
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
String age = request.getParameter("Age")==null?"":request.getParameter("Age");
String bean_id="@caballardscore"+patient_id;
String bean_name="eCA.CABallardScoreBean";
eCA.CABallardScoreBean beanObj = (eCA.CABallardScoreBean)getObjectFromBean(bean_id,bean_name,session);
String recordedScoreYN =beanObj.getBallardScoreRecordedYN(request,patient_id);  
%>
<html>
<head>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function removeObjectsFromSession(){}
</script>
</head>
	
		<iframe name="BallardScoreFrame" id="BallardScoreFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/blank.jsp"  style='height:92vh;width:98vw'></iframe>
		<iframe name="BallardScoreButtonFrame" id="BallardScoreButtonFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/CABallardScoreButton.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&Sex=<%=sex%>&Age=<%=age%>&recordedScoreYN=<%=recordedScoreYN %>" style='height:5vh;width:98vw'></iframe>		
	
	
</html>

