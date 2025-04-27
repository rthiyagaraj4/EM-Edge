<!DOCTYPE html>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String title	=	request.getParameter("title");
	if (title==null)	title = "Search";
%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<title id="lookup_title"><%=title%></title>
<iframe name="lookup_head" id="lookup_head" src="../../eFM/jsp/DTDocumentNumberLookupCriteria.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:6%;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0" style="height:100vh;width:100vw"></iframe>
</html>

