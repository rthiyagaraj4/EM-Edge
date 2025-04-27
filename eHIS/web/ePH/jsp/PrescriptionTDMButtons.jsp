<!DOCTYPE html>

 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<HTML>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	 
	String enable_disable	= request.getParameter("enable_disable");
	
	/*String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");	
	
	String bean_id			= "@PrescriptionTDMBean"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionTDMBean";

	PrescriptionTDMBean bean	= (PrescriptionTDMBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
	 */
    
%>
<HEAD>	
 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PrescriptionTDM.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onMouseDown="" onKeyDown="lockKey()">
<FORM name="formTDMPrescriptionButtons" id="formTDMPrescriptionButtons">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="right" BORDER="0">
	<TR>
		<TD ALIGN="right"class=label ID='Buttons' style="display:inline">
			<INPUT TYPE="button" CLASS="button" name="CLEAR" id="CLEAR" VALUE='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  onClick="callClear()"<%=enable_disable%>>
			<INPUT TYPE="button" CLASS="button" name="RECORD" id="RECORD"  VALUE='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="callRecord()"<%=enable_disable%>>
		</TD>
	</TR>
	</TABLE>
</FORM>
<% //putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

