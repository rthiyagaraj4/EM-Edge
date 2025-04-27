<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		
    %>



	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eBL/js/BLCashCounterLogin.js'></script>
<%
		String hide_common_toolbar="N";

		String params = request.getQueryString() ;

		String called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";
		if(called_frm.equals("DISC_FUN"))
		{
			hide_common_toolbar = "Y";
		}
		else
		{
			hide_common_toolbar = "N";
		}
%>
<head>
<%
		if(called_frm.equals("DISC_FUN"))
		{
%>
			<title><fmt:message key="eBL.CASH_COUNTER_LOGIN.label" bundle="${bl_labels}"/></title>
<%
		}
%>
</head>
<!--<frameset rows='42,251,*,0'> -->
<%
	if(hide_common_toolbar.equals("Y"))
	{
%>
<!-- <frameset rows='0%,95%,0%,*'> -->
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
<frame name='bl_cashier_login_frame' id='bl_cashier_login_frame' 	src='../../eBL/jsp/BLLoginMainFrame.jsp?<%=params%>' frameborder=0 scrolling='no' noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
<!--frame name='bl_cashier_query'		src='BLLogInCashCounterQuery.jsp' frameborder=0 noresize scrolling='yes' noresize>-->
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize scrolling='no' style='height:95vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize scrolling='no' style='height:0vh;width:100vw'></iframe>

<%
	}
	else
	{
%>
<!-- <frameset rows='6%,89%,0%,*'>   -->
<iframe name='commontoolbarFrame' id='commontoolbarFrame' 	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
<iframe name='bl_cashier_login_frame' id='bl_cashier_login_frame' 	src='../../eBL/jsp/BLLoginMainFrame.jsp?<%=params%>' frameborder=0 scrolling='no' noresize scrolling='no' style='height:89vh;width:100vw'></iframe>
<!--frame name='bl_cashier_query'		src='BLLogInCashCounterQuery.jsp' frameborder=0 noresize scrolling='yes' noresize>-->
<iframe name='dummyFrame'	id='dummyFrame'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize scrolling='no' style='height:89vh;width:100vw'></iframe>
<iframe name='messageFrame'	id='messageFrame'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize scrolling='no' style='height:0vh;width:100vw'></iframe>


<%
	}
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
<!--<frame name='bl_cashier_login_frame' 	src='../../eBL/jsp/BLLoginMainFrame.jsp?<%=params%>' frameborder=0 scrolling='no' noresize>
<!--frame name='bl_cashier_query'		src='BLLogInCashCounterQuery.jsp' frameborder=0 noresize scrolling='yes' noresize>-->
<iframe name='dummyFrame'  id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
<!--</frameset>-->

