<!DOCTYPE html>
<!-- 
Developed by	: P.Sudhakaran
Module/Function : 
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/MedicationAdministration.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
<form name="MedicationAdministrationPatientLine" id="MedicationAdministrationPatientLine" >
<%
	String patient_id			= request.getParameter("patient_id");
	//out.println(patient_id);
	String bean_id				= "MedicationAdministrationBean";
	String bean_name			= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean			= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	String patientLine=(String)bean.getPatientLine(patient_id);
	
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="regprescriptionspatientlinetable">
	<tr>
		<td class='white' width='2%'  id='maximageTD'>
		<img src="../../ePH/images/max.gif"  name="patImg" id="patImg" height="20" title="Restore Down" onClick="return windexpand(this);" onmouseover="changeCursor(this);"></td>
		<th ><%=patientLine%></th>	
	</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

