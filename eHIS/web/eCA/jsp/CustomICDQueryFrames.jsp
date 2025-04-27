<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
%>	
	<iframe name='searchframe' id='searchframe' src='CustomICDCodeQueryResult.jsp?<%=queryString%>' noresize  scrolling=auto  frameborder=no  marginheight=0 marginwidth=0></iframe>
	<iframe name='CusticdQueryResultFrame' id='CusticdQueryResultFrame'  src='../../eCommon/html/blank.html'  noresize  frameborder=no scrolling="auto"  marginheight=0 marginwidth=0></iframe>

</html>

