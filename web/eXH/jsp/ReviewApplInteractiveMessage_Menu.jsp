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
 
String function=request.getParameter("func");
//session.setAttribute("Msg_Id",msgId);
%>      
</head>																										  
<title><fmt:message key="eXH.ViewMessage.Label" bundle="${xh_labels}"/></title>

<%
if(function.equals("Main"))
{
%>
<frameset COLS="50,50" border='1' >
<%}
else
{
	%>
<frameset rows="50,50" border='1' >	   
<%}%>
<frame name='f_query_add_mod' src='../../eXH/jsp/ViewInteractiveTreeLeftMain.jsp?<%=params%>' frameborder=0 scrolling='auto'>
<frame name='f_query_add_mod2' src='../../eXH/jsp/ViewInteractiveTreeRightMain.jsp?<%=params%>' frameborder=0 scrolling='auto'>
</frameset> 
</html>		 
							    



																		 	   
