<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DirectDispensing.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body>

<form name ="DirectDispPrintDialogButton">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<!--<tr>
	<td colspan="3" class="white" align="right"><input type="button" class="button" name="rec_ref1" id="rec_ref1" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/> ' onClick="printOnlineDispense(document.DirectDispPrintDialog,'OK');parent.window.returnValue='OK'"><input type="button" class="button" name="rec_ref2" id="rec_ref2" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onClick="printOnlineDispense(document.DirectDispPrintDialog,'CANCEL');parent.window.returnValue='OK';"></td>
</tr> -->
<tr>  <!-- changed onclick for RUT-CRF-0067-->
	<td colspan="3" class="white" align="right"><input type="button" class="button" name="rec_ref1" id="rec_ref1" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/> ' onClick="if(validateRecordMandatory()){validateEditDetails(parent.editLabelFrame.document.DireciDispensingEditLabel,'PRINT_DIALOG');};"><input type="button" class="button" name="rec_ref2" id="rec_ref2" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onClick="printOnlineDispense(document.DirectDispPrintDialog,'CANCEL');parent.window.returnValue='OK';"></td>
</tr>
</table>

</form>
</body>
</html>


