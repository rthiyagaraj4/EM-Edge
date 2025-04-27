<!DOCTYPE html>
<html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.*,eCommon.XSSRequestWrapper "  %>
	<script language='javascript' src='../../eOA/js/OALocationlookup.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String queryString=request.getQueryString();
%>

<title><fmt:message key="Common.Location.label" bundle="${common_labels}"/></title>
<iframe name='criteria_frame' id='criteria_frame' src='../../eOA/jsp/OALocationlookupcriteria.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:22vh;width:95vw'></iframe>
<iframe name='result_frame' id='result_frame'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:73vh;width:95vw'></iframe>
</html>

