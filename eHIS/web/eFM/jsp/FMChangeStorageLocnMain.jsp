<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Change File Store Location
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
	<script language='javascript' src='../../eFM/js/FMChangeStorageLocn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String user_security_yn = request.getParameter("user_security_yn");
	String p_access_all		= request.getParameter("p_access_all");
//   String p_first="true"; checkstyle changes 35865
	if(user_security_yn == null || user_security_yn.equals("null")) user_security_yn = "";
	if(p_access_all == null || p_access_all.equals("null")) p_access_all = "";
%>
	<iframe name='FMChngStrLocnCriteriaFrame' id='FMChngStrLocnCriteriaFrame' src='../../eFM/jsp/FMChangeStorageLocnCriteria.jsp?user_security_yn=<%=user_security_yn%>&p_access_all=<%=p_access_all%>' frameborder='0' scrolling=no noresize style='height:31vh;width:100vw'></iframe>
	<iframe name='FMChngStrLocnSubResultFrame' id='FMChngStrLocnSubResultFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no' style='height:5vh;width:100vw' ></iframe>
	<iframe name='FMChngStrLocnMainResultFrame' id='FMChngStrLocnMainResultFrame' src='../../eCommon/html/blank.html' frameborder='0' noresize style='height:60vh;width:100vw'></iframe>
	<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>

</html>

