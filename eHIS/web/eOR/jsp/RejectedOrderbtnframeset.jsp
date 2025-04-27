<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
10/01/2018  	IN061893		Kamalakannan G  		10/01/2018 		 Ramesh G 		ML-MMOH-CRF-0545
---------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
		request.setCharacterEncoding("UTF-8");

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/RejectedOrders.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	
	

/* Mandatory checks end */

%>
<form name='rejected_order_btn' id='rejected_order_btn' target='messageFrame' >
<table  cellspacing=0 border=0 width="100%" align=center>
<tr>
<td  class='button' align="right" > 
	<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels")%>' class='button' onClick='reviewOrder(),populateResult()'>
	<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='clearAll()'>
</td>
</tr>
</table>
</form>
</body>
</html>

