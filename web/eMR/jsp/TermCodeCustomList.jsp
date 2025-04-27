<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
%>
	<iframe name='group_head' id='group_head' src='TermCodeGroupHeading.jsp?<%=queryString%>' noresize  scrolling=auto  frameborder=no  marginheight=0 marginwidth=0></iframe><iframe name='code_description' id='code_description'    src='../../eCommon/html/blank.html'  noresize  frameborder=no scrollbar=no  marginheight=0 marginwidth=0></iframe>

</html>

