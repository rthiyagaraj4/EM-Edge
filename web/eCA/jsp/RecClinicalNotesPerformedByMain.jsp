<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
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
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<iframe src="../../eCA/jsp/RecClinicalNotesPerformedByCriteria.jsp?<%=request.getQueryString()%>" name="RecClinicalNotesPerformedByCriteriaFrame"  scrolling="auto" frameborder="0" style="height:21%;width:100vw"></iframe><iframe src="../../eCommon/html/blank.html" name="RecClinicalNotesPerformedByResultFrame" id="RecClinicalNotesPerformedByResultFrame"  scrolling="auto" frameborder="0" style="height:100vh;width:100vw"></iframe>
</html>
	

