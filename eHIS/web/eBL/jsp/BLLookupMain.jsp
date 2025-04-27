
<%@  page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
%>
<script>
	window.name = 'Billing Lookup';
</script>
<title><%=request.getParameter("title")%></title>
<iframe name='group_head' id='group_head' src="../../eBL/jsp/BLLookupHeader.jsp?<%=queryString%>" noresize scrolling=no  frameborder=no marginheight=0 marginwidth=0 style='height:15vh;width:98vw'></iframe><br>
<iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=auto frameborder=no marginheight=0 marginwidth=0 style='height: 75vh;width:98vw'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eCommon/jsp/GeneralCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:8vh;width:98vw'></iframe>
</html>

