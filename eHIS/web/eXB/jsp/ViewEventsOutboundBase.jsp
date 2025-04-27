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
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;						  
		String params = request.getQueryString() ;
		String source = url + params ;
		String function_id = request.getParameter("function_id");		
		session.setAttribute("function_id",function_id);
%> 
</head>
<frameset rows='40,*,35'>
	<frame name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize >		
<!--	<frame name='f_query_add_mod' id='f_query_add_mod' src='../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id=<%=function_id%>' frameborder=0 scrolling='no'> -->
	<frame name='f_query_add_mod' id='f_query_add_mod' src='../../eXB/jsp/ViewEventsOutboundHeader.jsp?function_id=<%=function_id%>' frameborder=0 scrolling='no'>
	<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='NO'>	
</frameset>
<input type="hidden" name="function_id" id="function_id" id="function_id" value="<%=function_id%>">
</html>				   			    			 	  	 					   		 	   

