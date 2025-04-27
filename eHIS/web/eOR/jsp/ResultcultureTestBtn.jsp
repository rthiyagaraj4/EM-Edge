<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
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

 	<script language="JavaScript" src="../js/ResultEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name='view_order_btn' id='view_order_btn' target='messageFrame' >
		<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
			<!-- <input type=text name="ord_status" id="ord_status" value = ""> -->
			<tr>
				<td  class='button'>
				<INPUT TYPE="button" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class='button' onClick='previewCultureTest()'>
				<INPUT TYPE="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class='button' onClick='storeCultureTest()'>
				<INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='window.close()'>
			
				</td>
			</tr>

		</table>
	</form>
</body>
</html>

