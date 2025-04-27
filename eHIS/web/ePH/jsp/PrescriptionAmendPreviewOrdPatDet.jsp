<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<!-- used for renew prescription preview-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale = (String) session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="PreviewOrderPatientForm" id="PreviewOrderPatientForm" >
<%

String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String date					=	request.getParameter("date")==null?"":request.getParameter("date");
String locn_code			=	request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
String pract_name			=	request.getParameter("pract_name")==null?"":request.getParameter("pract_name");
String actual_patient_class	=	request.getParameter("actual_patient_class")==null?"":request.getParameter("actual_patient_class");

String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
String bean_name	= "ePH.PrescriptionBean_1";
PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
bean.setLanguageId(locale);
String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
String presBean_name	= "ePH.PrescriptionBean";
PrescriptionBean presBean = (PrescriptionBean)getBeanObject( presBean_id, presBean_name, request ) ;

HashMap pat_details	=	bean.getPatientDetails_1(patient_id);
String patient_name	=	(String)pat_details.get("patient_name");
String sex				=	(String)pat_details.get("sex");
String age				=	(String)pat_details.get("age");
String locn_desc	=	presBean.getLocationDesc(actual_patient_class,locn_code);
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr>
		<td  class="label" width="20%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=patient_name%></td>
		<td  class="label" width="20%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=patient_id%></td>
</tr>
<tr>
		<td  class="label" width="20%"><fmt:message key="Common.age.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=age%></td>
		<td class="label" width="20%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=encounter_id%></td>
</tr>
<tr>
		<td  class="label" width="20%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=sex%></td>
		<td  class="label" width="20%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=date%></td>
</tr>
<tr>
		<td  class="label" width="20%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/>:</td>
		<td class="data"   width="30%">&nbsp;&nbsp;<%=locn_desc%></td>
		<td  class="label" width="20%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=pract_name%></td>
</tr>

</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

