<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*"  contentType="text/html; charset=UTF-8" %>
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
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
  <table border=0 cellspacing=0 width='100%' cellpadding='0' align ='center'>
		<tr>
			<td width="2%" class='label'>&nbsp;</td>
			<td width="2%" style='background-color:ADD8E6;'>&nbsp;</td>
			<td width="15%"  class='label'><font size=1>&nbsp;&nbsp;<b><fmt:message key="eFM.FileisOutside.label" bundle="${fm_labels}"/></b></font></td>
			<td width="2%"  style='background-color:CCEEDD;'>&nbsp;</td>
			<td width="15%"  class='label'><font size=1>&nbsp;&nbsp;<b><fmt:message key="eFM.FileInTransit.label" bundle="${fm_labels}"/></b></font></td>
			<td width="2%"  style='background-color:FFFFEE;'>&nbsp;</td>
			<td width="15%"  class='label'><font size=1>&nbsp;&nbsp;<b><fmt:message key="eFM.FileisLost.label" bundle="${fm_labels}"/></b></font></td>
			<td width="2%"  style='background-color:FFEECC;'>&nbsp;</td>
			<td width="15%"  class='label'><font size=1>&nbsp;&nbsp;<b><fmt:message key="eFM.FileisArchived.label" bundle="${fm_labels}"/></b></font></td>
			<td width="10%" class='button'><input type='button' class='button' name='close' id='close' value=' Close ' onClick='parent.window.close();'>&nbsp;&nbsp;&nbsp;</td>
		</tr>
 	</table>	
</body>
</html>

