<!DOCTYPE html>
<%@ page import="java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<script>
	function updateLog()
	{
		document.frmLog.submit();
	}
</script>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Date currentDate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String strCurrentDate = dateFormat.format(currentDate);
	//out.println("<script>alert('"+strCurrentDate+"')</script>");
%>
</HEAD>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name="frmLog" id="frmLog" target="messageFrame" method='post' action="../../servlet/eCA.CAHomeLogServlet">
<br><br><br><br><br><br><br><br><br>
<font color='red' size='4'><fmt:message key="Common.processing.label" bundle="${common_labels}"/></font>
<INPUT TYPE="hidden" name="txtDate" id="txtDate" value="<%=strCurrentDate%>">
<INPUT TYPE="hidden" name="txtQueryString" id="txtQueryString" value="<%=request.getQueryString()%>">
</form>
</center>
</body>
<script>updateLog();</script>
</HTML>

