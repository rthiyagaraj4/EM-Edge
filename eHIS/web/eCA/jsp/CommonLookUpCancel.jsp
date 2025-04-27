<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCA/js/CommonLookUp.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
	<tr>
		<td >
			<input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='retValue("","")' class='button'>
		</td>
	</tr>
</table>
</div>
</body>
</html>


