<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
//	out.println(request.getParameter("cause_indicator"));

%>
<iframe name='code_label' id='code_label'    src='TermCodeSearchQuery.jsp?<%=queryString%>'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:25%;width:100vw'></iframe><iframe name='codedesc' id='codedesc'    src='../../eCommon/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:100vh;width:100vw'></iframe>
</html>

