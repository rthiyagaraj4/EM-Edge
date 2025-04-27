<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><%=request.getParameter("title")%></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>


<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
%>

<iframe name='group_head' id='group_head' src='LocationforPractSearchCriteria.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:14%;width:100vw'></iframe><iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:100vh;width:100vw'></iframe><iframe name='group_head1' id='group_head1' src='LocationforPractSearchCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10%;width:100vw'></iframe>
</html>

