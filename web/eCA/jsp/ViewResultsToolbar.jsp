<!DOCTYPE html>
<!-- ReviewResultsBtn.jsp -->
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
15/11/2013 IN035717			vijayakumark	Alpha-OR- View Results Records not displayed in Practitioner s Desktop
--------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<% 

String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");//IN035717
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eCA/js/ViewResult.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>

 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
</head>
<!-- IN035717 starts here -->
<!--
<script language="JavaScript">
function btnDisabling(){

if('<% // =option_id%>'== 'PAT_VIEW_RESULT'){
document.getElementById("forwardBtn").disabled = true;
document.getElementById("completeReviewBtn").disabled = true;
}else{
document.getElementById("forwardBtn").disabled = false;
document.getElementById("completeReviewBtn").disabled = false;
}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
<body   onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!--<body   onload='FocusFirstElement();btnDisabling();'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<!-- IN035717 ends here -->
<form name='review_result_btn' id='review_result_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td  class='button' align="right">
		<!-- IN035717 starts here -->
		<!--<INPUT TYPE="button"  value='<fmt:message key="Common.Forward.label" bundle="${common_labels}"/>' class='button' onClick='callForward()'>-->
		<INPUT TYPE="button"  value='<fmt:message key="Common.Forward.label" bundle="${common_labels}"/>' class='button' onClick='callForward()' id='forwardBtn'>
		<!--<INPUT TYPE="button" value='<fmt:message key="eOR.CompleteReview.label" bundle="${or_labels}"/>' class='button' onClick='completeReview()'>-->
		<INPUT TYPE="button" value='<fmt:message key="eOR.CompleteReview.label" bundle="${or_labels}"/>' class='button' onClick='completeReview()' id='completeReviewBtn'>
		<!-- IN035717 ends here -->
		<%--<INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearChecked()'>--%>
		</td>
	</tr>

</table>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
</form>

</body>
</html>

