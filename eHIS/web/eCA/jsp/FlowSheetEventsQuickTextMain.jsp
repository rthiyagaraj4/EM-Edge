<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%  
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patientid = request.getParameter("patient_id") == null? "" : request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
%>
<HTML>
<HEAD>
    <TITLE><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></TITLE>
	<%

		
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encounter_id,"eCA.PatientBannerGroupLine",session);
	ArrayList keyList2 = manageEmailBean.returnList2();
	if(keyList2.size() == 0)
	{
		out.println("<script>alert(getMessage(\"EVENTS_FOR_QUICKTEXT\",\"CA\"));window.close();</script>");		
	}
	%>
</head>
	<iframe src="../../eCA/jsp/FlowSheetEventsQuickTextView.jsp?<%=request.getQueryString()%>" name="criteria_f1" id="criteria_f1" scrolling="auto" frameborder="0" noresize style="height:20vh;width:99vw"></iframe>
		<iframe src="../../eCA/jsp/FlowSheetEventsQuickText.jsp?<%=request.getQueryString()%>" name="details" id="details" scrolling="yes" frameborder="0" noresize style="height:55vh;width:99vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name="commButtons" id="commButtons"  scrolling="no" frameborder="0" noresize style="height:15vh;width:99vw"></iframe>
		<iframe src="../../eCommon/jsp/error.jsp" name="messageframe" id="messageframe"  scrolling="no" frameborder="0" noresize style="height:5vh;width:99vw"></iframe>
	 
</HTML>

