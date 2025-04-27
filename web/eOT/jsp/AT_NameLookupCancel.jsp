<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="Javascript" src="../../eCommon/js/Booking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding=3='3' cellspacing='0' >
	<tr>
		<td >
			<input type='button' name='close' id='close' value='Close' onClick='closew()' class='button'>
		</td>
	</tr>
</table>
</div>
</body>
</html>

