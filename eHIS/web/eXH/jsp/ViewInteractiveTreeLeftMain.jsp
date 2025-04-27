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
String msgId=request.getParameter("MessageId");  
System.out.println("MessageID16"+msgId);
session.setAttribute("Msg_Id",msgId);	 
%>      
</head>
<iframe name='f_query_add_mod2' id='f_query_add_mod2' src='../../eXH/jsp/ViewInitiateMessageLeftHeader.jsp?<%=params%>' frameborder=0 scrolling='no' style='height:4vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eXH/jsp/ViewInteractiveTreeLeft.jsp?<%=params%>' frameborder=0 scrolling='auto' style='height:96vh;width:100vw'></iframe> 
</html>		 
																				    			   

