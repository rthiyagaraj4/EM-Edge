<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
	<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
	<!-- <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String patient_id   = request.getParameter("patient_id");
	String nursing_unit = request.getParameter("nursing_unit");
	String admin_to_date= request.getParameter("admin_to_date");
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="MedicationAdministrationViewMAR" id="MedicationAdministrationViewMAR" >
<table cellpadding="0" cellspacing="1" width="100%" align="center" border="">
	<tr>			
		<td class="white">
			<input type="button" name="btnViewAdminDetails" id="btnViewAdminDetails" value='<fmt:message key="ePH.ViewMedicationAdministrationChart.label" bundle="${ph_labels}"/>' class="button" style="font-size:9" onClick="callMednDetails('<%=patient_id%>','<%=nursing_unit%>','<%=admin_to_date%>')">
		</td>
	</tr>
</table>	
</form>
</body>
</html>

