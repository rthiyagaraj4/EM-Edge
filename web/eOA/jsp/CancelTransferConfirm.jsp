<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*" %>
<html> 
<title><fmt:message key="eOA.CancelTransferAppointment.label" bundle="${oa_labels}"/></title>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src="../../eOA/js/TransferCancelAppointment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
request.setCharacterEncoding("UTF-8");	

String tfr_appt_yn=request.getParameter("tfr_appt_yn");
String canc_appt_yn=request.getParameter("canc_appt_yn");

%>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table border="0" width="107%" cellspacing='0' cellpadding='0' class=label>
  <tr><td class=label></td></tr>  <tr><td class=label></td></tr>  <tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr>  <tr><td class=label></td></tr>  <tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr>
  <tr>
	<td class=label>&nbsp;</td>
  </tr>
  <%
  if(canc_appt_yn!=null && canc_appt_yn.equals("Y")){
  %>
  <tr>
	<td class=label align='center'><a href ='javascript:canc_appt();' target='this'><fmt:message key="Common.CancelAppointment.label" bundle="${common_labels}"/></a></td>
  </tr>
  <%
  }else{
  %>
  <tr>
	<td class=label>&nbsp;</td>
  </tr>
  <%
  }
  %>
  <tr>
	<td class=label>&nbsp;</td>
  </tr>
  <%
  if(tfr_appt_yn!=null && tfr_appt_yn.equals("Y")){
  %>
  <tr>
	<td class=label align='center'><a href ='javascript:trans_appt();' target='this'><fmt:message key="Common.TransferAppointment.label" bundle="${common_labels}"/></a></td>
  </tr>
  <%
  }else{
  %>
  <tr>
	<td class=label>&nbsp;</td>
  </tr>
  <%
  }
  %>
  <tr>
	<td class=label>&nbsp;</td>
  </tr>
   <tr>
	<td class=label >&nbsp;</td>
  </tr>
  <tr><td class=label>&nbsp;</td></tr>
  <tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr>  <tr><td class=label></td></tr>  <tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr>
  <tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr>  <tr><td class=label></td></tr>  <tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr><tr><td class=label></td></tr>
</table>
</body>
</html>



