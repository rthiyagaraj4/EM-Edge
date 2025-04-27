<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ReviewResultsBtn.jsp -->
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
 	<script language="JavaScript" src="../js/ReviewResults.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>

 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='review_result_btn' id='review_result_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr >
		<td  class='button' align="right">
		<INPUT TYPE="button" value='<fmt:message key="Common.Forward.label" bundle="${common_labels}"/>' class='button' onClick='callForward()'>
		<INPUT TYPE="button" value='<fmt:message key="eOR.CompleteReview.label" bundle="${or_labels}"/>' class='button' onClick='completeReview()'>
		<%--<INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearChecked()'>--%>
		</td>
	</tr>

</table>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
</form>

</body>
</html>

