<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<form name='RecClinicalNotesTemplateToolbarForm' id='RecClinicalNotesTemplateToolbarForm'>
	<table border=1 cellpadding=3 cellspacing=0 width='100%' align='center' >
	<tr ><td width ='25%'></td><td width ='25%'></td>
		<td width ='25%'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' name='but_ok' align='right'></input></td>
		<td width ='25%'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' name='but_cancel' align='right'></input></td>
	</tr>
	</table>
	</form>
	</body>
</html>

