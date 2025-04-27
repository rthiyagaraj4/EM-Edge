<!DOCTYPE html>
<html>
 <head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  </head>
  <body >
  <%	request.setCharacterEncoding("UTF-8");	%>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
  <form name="BTPatientHeaderForm" id="BTPatientHeaderForm"> 
   <table cellpadding=0 cellspacing=0 width="100%" align="center">
<tr>
  <td class='PATIENTLINECOLOR' align='left' ><b>&nbsp;&nbsp;<%=request.getParameter("Patient_ID")%>,
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getParameter("Patient_Name")%>,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<%=request.getParameter("Facility_ID")%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
</tr>
	</table>
	</form>
  </body>
 </html>

