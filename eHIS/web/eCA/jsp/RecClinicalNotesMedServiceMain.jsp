<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String title = request.getParameter("title");
%>
<title>
<%=title%>
</title>
<iframe src="../../eCA/jsp/RecClinicalNotesMedServiceCriteria.jsp?<%=request.getQueryString()%>" name="RecClinicalNotesMedServiceCriteriaFrame"  scrolling="no" frameborder="0" style="height:15vh;width:99vw"></iframe><iframe src="../../eCommon/html/blank.html" name="RecClinicalNotesMedServiceResultFrame" id="RecClinicalNotesMedServiceResultFrame"  scrolling="auto" frameborder="0" style="height:80vh;width:99vw"></iframe>
</html>
	

