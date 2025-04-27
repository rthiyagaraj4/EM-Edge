<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="JavaScript" src="../js/ViewResult.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='review_result_forward_pract_btn' id='review_result_forward_pract_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td  class='button' align="right">
		<INPUT TYPE="button" name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class='button' onClick='forwardToPract()' disabled>
		<INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='window.close()'>
		</td>
	</tr>

</table>
</form>
</body>
</html>

