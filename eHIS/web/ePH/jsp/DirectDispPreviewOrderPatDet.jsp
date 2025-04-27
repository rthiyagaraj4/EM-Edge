<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="PreviewOrderPatientForm" id="PreviewOrderPatientForm" >
<%

String patient_id			=	request.getParameter("patient_id");
String encounter_id			=	request.getParameter("encounter_id");
String date					=	request.getParameter("date");
String locn_code			=	request.getParameter("locn_code");
String pract_name			=	request.getParameter("pract_name");
String actual_patient_class	=	request.getParameter("actual_patient_class");

if(patient_id==null)	patient_id		=	"";
if(encounter_id==null)	encounter_id	=	"";
if(date==null)	date					=	"";
if(locn_code==null)	locn_code			=	"";
if(pract_name==null) pract_name			=	"";
if(actual_patient_class==null) actual_patient_class	=	"";


String bean_id		=	"";
String	patient_name	=	"";
String	sex				=	"";
String	age				=	"";

//bean_id			= "DirectDispensingBean"+patient_id+encounter_id;
bean_id			= "DirectDispensingBean";
String bean_name	= "ePH.DirectDispensingBean";
DirectDispensingBean bean = (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
//bean.setLanguageId(locale);
HashMap pat_details	=	bean.getPatientDetails(patient_id);
patient_name	=	(String)pat_details.get("patient_name");
sex				=	(String)pat_details.get("sex");
age				=	(String)pat_details.get("age");
if(sex.equalsIgnoreCase("female"))
 sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
 else if(sex.equalsIgnoreCase("male"))
sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
else if(sex.equalsIgnoreCase("unknown"))
sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

//out.println(locn_code);
//out.println("pat class"+actual_patient_class);
//out.println("locn_code"+locn_code);
String locn_desc	=	bean.getLocationDesc(actual_patient_class,locn_code);

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
		<td  class="label" width="20%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>:</td>
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
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=locn_desc%></td>
		<td  class="label" width="20%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/> :</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=pract_name%></td>
</tr>

</form>
<% //putObjectInBean(bean_id,bean,request); %>
</body>
</html>

