<!DOCTYPE html>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
       request.setCharacterEncoding("UTF-8");
       String sStyle	=         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	   String procid=request.getParameter("procid");
   %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<title><fmt:message key="eSM.BackGroundProcesses.label" bundle="${sm_labels}"/></title>
</head>
	<iframe name='proc' id='proc'	src='../../eSM/jsp/SearchProc.jsp?procid=<%=procid%>' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='proc1' id='proc1'	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
</html>


