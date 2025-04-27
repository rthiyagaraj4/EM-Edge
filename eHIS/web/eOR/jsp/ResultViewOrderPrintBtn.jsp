<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!-- ViewOrderBtn.jsp -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='view_order_btn' id='view_order_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td  class='button' align="right">
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onClick='toCloseTopShowModal()'><INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' class='button' onClick='printit()'>
		</td>
	</tr>

</table>

<!-- <input type="hidden" name="p_language_id" id="p_language_id" value="<%= localeName %>"> -->
</form>

</body>
</html>

