<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<title><%=request.getParameter("title")%></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	String queryString=request.getQueryString();

%>
<iframe name='group_head' id='group_head' src='Consultation.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:7%;width:100vw'></iframe><iframe name='group_head' id='group_head' src='PaintConsultation.jsp?<%=queryString%>' noresize  scrolling=auto  frameborder=no  marginheight=0 marginwidth=0 style='height:100vh;width:100vw'></iframe><iframe name='group_head' id='group_head' src='SearchCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10%;width:100vw'></iframe>
</html>

