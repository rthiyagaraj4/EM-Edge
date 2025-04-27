<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCA/js/ScheduleForVacination.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	</head>

  <body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

	<form>
		<table border='0' width='100%' cellpadding='3' cellspacing=0 align='right'>
		  <tr>
		    <td colspan='3'></td>
			<!--Modifeied by Arvind width 25 to 9 @ 22-12-08-->
			<td width ='9%' class='fields' align='right'><input type='button' class='button' name='ok' id='ok' onclick="javascript:record_catalog()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'></input><input type='button' class='button' name='cancel' id='cancel' onclick="javascript:cancel_catalog()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'></input></td>
		  <tr>
		</table>
	</form>
  </body>
</html>

