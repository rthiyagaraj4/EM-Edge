<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
%>
	<iframe name='TermCodeSearchKWCriteriaFrame' id='TermCodeSearchKWCriteriaFrame'    src='TermCodeSearchKWCriteria.jsp?<%=queryString%>'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:25%;width:100vw'></iframe><iframe name='TermCodeSearchKWResultFrame' id='TermCodeSearchKWResultFrame' src='../../eCommon/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:100vh;width:100vw'></iframe>
</html>

