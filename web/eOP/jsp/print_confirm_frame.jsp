<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
		request.setCharacterEncoding("UTF-8");
		String params	 = request.getQueryString() ;
		String call_from = request.getParameter("call_from");
		if (call_from == null) call_from = "";
 if (call_from.equals("OA_APPT"))
{
%>
<title><fmt:message key="eOP.PrintAppointmentSlip.label" bundle="${op_labels}"/></title>
<%}else{%>
<title><fmt:message key="eOP.PrintReferralLetter.label" bundle="${op_labels}"/></title>
<%}%>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<iframe name='PrintFrame' id='PrintFrame'	src='../../eOP/jsp/print_confirm_form.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:99vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:1vh;width:100vw'></iframe>
</html>

