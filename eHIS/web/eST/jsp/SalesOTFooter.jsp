<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.lang.*"  	contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<html>
<head>
	<%
	 request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/Sales.js'></script>
	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<form name = "formSalesOTFooter">
		<table cellpadding=0 cellspacing=0 border=0 width='100%' align="center" >
			<tr>
				<td align=right>
					<input type=button class = button name="Sell" id="Sell" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="applyforot();">
					<input type=button class = button name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="clseWindow();">
				</td>
			</tr>
		<table>
	</form>
</html>

