<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eOP/js/resourceType.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
	String funcname=request.getParameter("func_name");
	if(funcname==null)funcname="";
	session.setAttribute("SOURCE",source);
%>
<frameset rows='42,*,36' >
   
	<frame name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize>
	<%
	if(funcname.equals("Delete"))
	{
   %><frame name='f_query_add_mod' id='f_query_add_mod' src='../../eOP/jsp/resourceTypeVisitType.jsp' frameborder=0 scrolling='no' noresize>
	<%}
	else{
	%>
     <frame name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize>
   <%}%>
	 <frame name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
	
</frameset>
</html>

