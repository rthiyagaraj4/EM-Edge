<!DOCTYPE html>

  <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	  request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmDispMedicationWSActionButtons" id="frmDispMedicationWSActionButtons">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
	<td  class='white' align='right'>&nbsp;
		<input type="button" name="recordWSButton" id="recordWSButton" value='<fmt:message key="ePH.RecordWorksheet.label" bundle="${ph_labels}"/>' disabled class="button" onClick="window.returnValue='RECORDWS';window.close()">		
		<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="window.close()">
	</td>
</tr>
</table>
</form>
</body>
</html>

