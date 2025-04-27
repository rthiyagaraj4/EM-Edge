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
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/MedicationAdministration.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String params			= request.getQueryString() ;
	
	String bean_id	= "MedicationAdministrationBean";
	String bean_name= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean	= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name , request);
	bean.setLanguageId(locale);
 %>
		
		<iframe name="f_patient_line" id="f_patient_line" frameborder="0" scrolling="no" noresize src="MedicationAdministrationFTBedFrame.jsp?<%=params%>" style="height:22vh;width:100vw"></iframe>
		<!-- <frame name="f_medn_admin_view" id="f_medn_admin_view" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" > -->
		<iframe name="f_admin_chart" id="f_admin_chart" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:40vh;width:100vw"></iframe>
		<iframe name="f_admin_detail" id="f_admin_detail" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:22vh;width:100vw"></iframe>
		<iframe name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/MedicationAdministrationButton.jsp?<%=params%>"style="height:4vh;width:100vw"></iframe>
	
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

