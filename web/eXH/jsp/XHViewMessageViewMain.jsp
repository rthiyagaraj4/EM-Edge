<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>

<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head>
<%
String params = request.getQueryString() ;
//String msgId=request.getParameter("MessageId");  
 
//session.setAttribute("Msg_Id",msgId); 
%>      
</head>
<title><fmt:message key="eXH.ViewMessage.Label" bundle="${xh_labels}"/></title>
<iframe name='f_query_add_mod_tree_text' id='f_query_add_mod_tree_text' src='../../eXH/jsp/XHViewMessageSimulatoeTreeText.jsp?<%=params%>' frameborder=0 scrolling='auto'style='height:50vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_tree' id='f_query_add_mod_tree' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:50vh;width:100vw'></iframe> 
</html>		  					  	 					  		   		    		 	   	    	  

