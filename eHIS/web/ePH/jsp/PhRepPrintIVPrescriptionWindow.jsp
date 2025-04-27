<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="ePH.ReportPrescription.label" bundle="${ph_labels}"/></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhRepPrintIVPrescription.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends


	String bean_id = "PrintPrescriptionReportBean" ;
	String bean_name = "ePH.PrintPrescriptionReportBean";
	PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;
	String patient_id=request.getParameter("patient_id");
	String order_id  =request.getParameter("order_id");
	
	String patient_class = request.getParameter("patient_class");
	String locn_code	= request.getParameter("locn_code");
	String iv_type	= request.getParameter("iv_type");
	String p_report_id = "";
	if (iv_type.equals("CON"))
	{
		p_report_id="PHPRDPRESIVCONT";
	}
	else if(iv_type.equals("1")){
		p_report_id="PHBOPPEX";
	}
	else
	{
		p_report_id="PHPRDPRESIVINTT";
	}
	ArrayList result = bean.getPatientLine(patient_id,order_id);
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmPrintPrescriptionReportWindow" id="frmPrintPrescriptionReportWindow" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<table cellpadding=0 cellspacing=0 width="103%" align="center">

 <tr>
	<td align="left" colspan="2" class="white">&nbsp;</td>
</tr>
 <tr>
		<td align="left" class="label" colspan="3" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=result.get(1)%></b>,<%=result.get(2)%>,<%=result.get(3)%>,<%=result.get(4)%></td>
	</tr>
	<tr>
		<td align="left" colspan="3" class="white">&nbsp;</td>
	</tr>
	<tr>
		<th align="left"><fmt:message key="Common.report.label" bundle="${common_labels}"/></th>
		<th align="left"><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></th>
		<th align="left"><fmt:message key="ePH.No.OfCopies.label" bundle="${ph_labels}"/></th>
	</tr>
	<tr>
		<td><b><fmt:message key="ePH.PrescriptionReprint.label" bundle="${ph_labels}"/></b></td>
		<td><b><%=result.get(0)%></b></td>
		<td>
			<input type="text" name="txt_copies" id="txt_copies" value="1" size="3" maxlength="3">
		</td>
	</tr>
	<tr>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td align="right" colspan="3">
			<input type="button" name="btnOK" id="btnOK" value="OK" class="button" onClick="submitTheWindow()">
			<input type="button" name="btnCancel" id="btnCancel" value="Cancel" class="button" onClick="window.close()">
		</td>
	</tr>
</table>
	<input type="hidden" name="p_order_id" id="p_order_id" value="<%=order_id%>">
	<input type="hidden" name="p_patclass" id="p_patclass" value="<%=patient_class%>">
	<input type="hidden" name="p_locncode" id="p_locncode" value="<%=locn_code%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="<%=p_report_id%>">
	<% putObjectInBean(bean_id,bean,request); %>
</FORM >
</body>
</html>

