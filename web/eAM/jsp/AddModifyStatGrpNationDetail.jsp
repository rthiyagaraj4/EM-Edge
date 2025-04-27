<!DOCTYPE html>
<%--
	FileName	: AddModifyStatGrpNationDetail.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<!--<script src='../../eAM/js/ServiceSetsDetail.js' language='javascript' ></script>-->
   	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<!--<script src='../../eOR/js/ServiceCategory.js' language='javascript'></script>-->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 		
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	String stat_grp_id=request.getParameter("stat_grp_id");
	if( stat_grp_id == null) stat_grp_id="";
	String category=request.getParameter("category");
	if(category == null) category="";

%>
<iframe name='query' id='query' 	src='../../eAM/jsp/StatGrpNationDetailquery.jsp?stat_grp_id=<%=stat_grp_id%>&category=<%=category%>' frameborder=0 scrolling='no' style='height:35vh;width:98vw'></iframe>
<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:98vw'></iframe>
</html>

