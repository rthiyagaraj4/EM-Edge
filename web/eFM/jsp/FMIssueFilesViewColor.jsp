<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@ page import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
  <table border=0 cellspacing=0 width='100%' cellpadding='0' align ='center'>
	<tr><td colspan='12' class='ANBOR' >&nbsp;</td></tr>
	<tr>
		<td class='ANBOR' width="2%" ></td>
		<td width="2%"  style='background-color:lightgreen'>&nbsp;</td>
		<td width="22%"  class='ANBOR'>&nbsp;&nbsp;&nbsp;<b><fmt:message key="eFM.FromLoggedInFacility.label" bundle="${fm_labels}"/></b></td>
		<td class='ANBOR' width="2%" ></td>
		<td width="2%"  style='background-color:lightpink'>&nbsp;</td>
		<td width="20%"  class='ANBOR'>&nbsp;&nbsp;&nbsp;<b><fmt:message key="eFM.FromOtherFacilities.label" bundle="${fm_labels}"/></b></td>
		<td class='ANBOR' width="2%" ></td>
		<td class='ANBOR' width="2%" ><b>#</b></td>
		<td width="15%"  class='ANBOR'>&nbsp;&nbsp;&nbsp;<b><fmt:message key="eFM.ManualEntry.label" bundle="${fm_labels}"/></b></td>
		<td class='ANBOR' width="2%" ></td>	
		<td width="2%"  ><img src='../../eFM/images/stop.gif' align='center'></img></td>
		<td width="20%"  class='ANBOR'>&nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></b></td>
		<!--Above line modified for this incident [61325] -->
	</tr>	
	<tr><td colspan='12' class='ANBOR' >&nbsp;</td></tr>
	</table>	
</body>
</html>




