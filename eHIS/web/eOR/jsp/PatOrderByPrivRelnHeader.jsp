<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PatOrderByPrivReln.js"></script>
 	<script language="JavaScript" src="../js/PatOrderByPrivRelnTracking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=PatOrderByPrivReln_hdg action=post target=messageFrame>
<table cellpadding=0 cellspacing=0 border=1 width='100%' align=center>
	<tr>
		<th width='16%' nowrap>Ordered At</th>
		<th width='10%' align=center>Urgency</th>
		<th width='10%' align=center>Order Type</th>
		<th width='25%' align=center>Order Detail</th>
		<th width='30%' align=center>Patient Detail</th>
		<th width='10%' align=center>Status
		</th>
	</tr>
</table>
</form>
</body>
</html>

