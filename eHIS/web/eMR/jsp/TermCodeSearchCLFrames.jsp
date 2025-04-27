<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
%>	
	<iframe name='searchframe' id='searchframe' src='TermCodeSearchCLCriteria.jsp?<%=queryString%>' noresize  scrolling=auto  frameborder=no  marginheight=0 marginwidth=0></iframe><iframe name='CusticdQueryResultFrame' id='CusticdQueryResultFrame'  src='../../eCommon/html/blank.html'  noresize  frameborder=no scrolling="yes"  marginheight=0 marginwidth=0></iframe>

</html>

