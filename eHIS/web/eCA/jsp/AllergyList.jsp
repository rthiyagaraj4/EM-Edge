<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id");
String Context = request.getParameter("Context");
String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
%>
<html>
<head>
<title><fmt:message key="eCA.AllergyList.label" bundle="${ca_labels}"/></title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
 <style>
        #main{
           height: 680px;
            margin: 0;
            display: flex;
            flex-direction: row;
        }
        .container {
            display: flex;
            flex-direction: column;
            height: 90vh;
        }
        .container60 {
            flex: 0 0 65vw; /* Takes 60% of the viewport width */
            display: flex;
            flex-direction: column;
        }
        .container40 {
            flex: 0 0 35vw; /* Takes 40% of the viewport width */
            display: flex;
            flex-direction: column;
        }
        iframe {
            border: none;
            margin: 0;
        }
    </style>
</head>
<body style='overflow: hidden;'>
<!-- <frameset cols='55%,*' border=0>
<frameset rows='53%,*' border=0> 
Modified by kishor kumar N on 04/12/2008 for CRF 0387,
	size of the frameset to view properly.

<frameset rows='13%,*%' border=0> -->
<!-- ends here -->
	<div id="main">
	<div class="container container60">
        <iframe src="PatAlertQueryAllergyResult.jsp?patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>" name="PatAlertQueryAllergyResult" id="PatAlertQueryAllergyResult" style=" height: 10vh;width: 100%;" scrolling="no"></iframe>
        <iframe src="PatAlertQueryAllergyClass.jsp?patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>" name="PatAlertQueryAllergyClass" id="PatAlertQueryAllergyClass" style=" height: 73vh;width: 100%;"></iframe>
        <iframe src="PatAlertQueryHighRiskResult.jsp?patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>&Context=<%=Context%>" name="PatAlertQueryHighRiskResult" id="PatAlertQueryHighRiskResult" style=" height: 5vh;width: 100%;" scrolling="no"></iframe>
        <iframe src="../../eCommon/html/blank.html" marginheight=0 marginwidth=0 name="PatAlertHighRiskMainFrame" id="PatAlertHighRiskMainFrame" FRAMEBORDER="0" style="height:25vh;width:100%" ></iframe>
        
    </div>
    
    <div class="container container40">
        <iframe src="PatAlertQueryResult.jsp?patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>" name="PatAlertQueryResult" id="PatAlertQueryResult" style="height:100vh;width:100%;"></iframe>
    </div>
	</div>
	<!-- </frameset> -->
<!-- <frameset rows='15%,*' border=0 framespacing ="0"> -->
<!-- </frameset>
</frameset > -->
	<!-- </frameset> -->
	</body>
</html>
