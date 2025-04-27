<!DOCTYPE html>
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

 	<script language="JavaScript" src="../js/ResultEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name='culture_test_preview_btn' id='culture_test_preview_btn' target='messageFrame' >
		<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
			<tr>
				<td  class='button'>
				<INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='window.close()'>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>

