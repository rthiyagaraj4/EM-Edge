<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<title><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></title>
<iframe src="../../eCA/jsp/ViewSpecialtyEventMain.jsp?<%=request.getQueryString()%>" name="ViewSpecialtyEventMainFrame"  scrolling="auto" frameborder="0" style="height:90%;width:100vw"></iframe><iframe src="../../eCA/jsp/ViewSpecialtyEventbar.jsp" name="ViewSpecialtyEventbarFrame" id="ViewSpecialtyEventbarFrame"  scrolling="auto" frameborder="0" style="height:100vh;width:100vw"></iframe>
</html>

