<!DOCTYPE html>
 <%@ page import="" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
	
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/Issue.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
		<form name='formBarcodeColorIndicator' id='formBarcodeColorIndicator'>

			<table border='0' width='100%' cellpadding='0' cellspacing='0' align=center> 
			<tr>
			<td class="STLIGHTPINK" >&nbsp;&nbsp;</td>
			<td class="label" ><fmt:message key="eST.CurrentRecord.label" bundle="${st_labels}"/></td>		
			<td class="FOREDITOR">&nbsp;&nbsp;</td>
			<td class="label"><fmt:message key="eST.ScannedRecord.label" bundle="${st_labels}"/></td>
			<td bgcolor="WHITE" style='border: 1px solid;border-style:solid;border-color:lightblue;'>&nbsp;&nbsp;</td>
			<td class="label"><fmt:message key="eST.PendingForScanning.label" bundle="${st_labels}"/></td>
			</tr>
			</table>

		</form>
	</body>
</html>

