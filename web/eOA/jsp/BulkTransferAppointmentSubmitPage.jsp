<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*" %>


<html>
<head>

	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script language='javascript' src='../../eOA/js/BulkTransferAppointment.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	%>
</head>
	
<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
<form name="bulktransferapptsubmitpage" id="bulktransferapptsubmitpage">
<table border="0" width="100%" bgColor=white cellspacing='0' height='100%' cellpadding='0'>


<tr>
			<td valign=center class=white align='right'><input type='button' name='confirmrevision' id='confirmrevision' value='<fmt:message key="Common.ConfirmRevision.label" bundle="${common_labels}"/>'   onClick="passvalues()" class='BUTTON'></td>
</tr>

</table>

