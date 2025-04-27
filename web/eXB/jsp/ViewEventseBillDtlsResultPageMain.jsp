<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html> 
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXB.*" %>
<head> 
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eXB/js/XHAjaxUtil.js"></script>
<script language='javascript' src='../../eXB/js/ViewEventsOutbound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String params = request.getQueryString() ;		 
																 		 		   
%>																	    							   
</head>
<frameset id='ViewEventFrame' rows='30,540,1,*'>
<frame name='f_query_add_mod' id='f_query_add_mod' src='../../eXB/jsp/ViewEventseBillShowDtlOption.jsp?<%=params%>' frameborder=0 scrolling='no'>
<frame name='f_query_add_mod_dtl' id='f_query_add_mod_dtl' src='../../eXB/jsp/ViewEventseBillResult.jsp?<%=params%>'  frameborder=0 scrolling='no'>
<!--<frame name='f_query_add_mod_export' id='f_query_add_mod_export' src='../../eXB/jsp/ViewEventsBillFooter.jsp?<%=params%>'  frameborder=0 scrolling='no'> -->
<frame name='f_query_add_mod_export' id='f_query_add_mod_export' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'>
<frame name='f_query_add_mod_footer' id='f_query_add_mod_footer' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'>

</html>							    		 			   												    

