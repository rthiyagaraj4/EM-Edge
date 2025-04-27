<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	17/06/2002
	Module			:	FM - Assign File Store Location
	Function		:	This function is used split into three frame structure.
-->
<%@ page contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMChFileRetDate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String user_security_yn = request.getParameter("user_security_yn");
	String p_accass_all		= request.getParameter("p_accass_all");

	if(user_security_yn == null || user_security_yn.equals("null")) user_security_yn = "";
	if(p_accass_all == null || p_accass_all.equals("null")) p_accass_all = "";
	
%>
<iframe name='FMChFileRetDateCriteriaFrame' id='FMChFileRetDateCriteriaFrame' src='../../eFM/jsp/FMChFileRetDateCriteria.jsp?user_security_yn=<%=user_security_yn%>&p_accass_all=<%=p_accass_all%>' frameborder='0' scrolling='no' noresize style='height:20%;width:99vw'></iframe>
	<iframe name='FMChFileRetDateResultFrame' id='FMChFileRetDateResultFrame' src='../../eCommon/html/blank.html' scrolling='no' frameborder='0' noresize style='height:100vh;width:99vw'></iframe>

</html>

