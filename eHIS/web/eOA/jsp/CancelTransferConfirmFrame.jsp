<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html> 
<title><fmt:message key="eOA.CancelTransferAppointment.label" bundle="${oa_labels}"/></title>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<% 
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String tfr_appt_yn=request.getParameter("tfr_appt_yn");
	String tfr_appt_across_catg_yn=request.getParameter("tfr_appt_across_catg_yn");
	String canc_appt_yn=request.getParameter("canc_appt_yn");
	%>
	<iframe name='f_apptdetails' id='f_apptdetails' src='../../eOA/jsp/CancelTransferConfirm.jsp?canc_appt_yn=<%=canc_appt_yn%>&tfr_appt_yn=<%=tfr_appt_yn%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>'   scrolling='no' marginheight='0' marginwidth='0' style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='no' marginheight='0' marginwidth='0' style='height:0vh;width:100vw'></iframe>
</html>
<%
%>


