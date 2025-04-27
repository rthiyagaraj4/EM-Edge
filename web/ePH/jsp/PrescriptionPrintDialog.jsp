<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
		<title><fmt:message key="ePH.PrintPrescriptionOption.label" bundle="${ph_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript"src="../../eCommon/js/CommonCalendar.js"></script>	
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	</HEAD>
	<body onMouseDown="" onKeyDown="lockKey()">
<%
		String called_from			= request.getParameter("called_from")==null?"RX":request.getParameter("called_from");
		String narcotic_aprvl_form_req_yn	= request.getParameter("narcotic_aprvl_form_req_yn")==null?"":request.getParameter("narcotic_aprvl_form_req_yn");
		String print_narcotic_form_by_default	= request.getParameter("print_narcotic_form_by_default")==null?"":request.getParameter("print_narcotic_form_by_default");
		String buildMAR_yn	= request.getParameter("buildMAR_yn")==null?"":request.getParameter("buildMAR_yn");//added for MMS-QH-CRF-0080 [IN:038064]
		String print_mar_label_yn	= request.getParameter("print_mar_label_yn")==null?"":request.getParameter("print_mar_label_yn"); //added for MMS-QH-CRF-0080 [IN:038064]
		String print_ord_sht_rule_ind	= request.getParameter("print_ord_sht_rule_ind")==null?"":request.getParameter("print_ord_sht_rule_ind");//Added for Bru-HIMS-CRF-393_1.0
		String NarcoticApprovalForm_checkYN = "";	
		if (print_narcotic_form_by_default.equals("Y") || print_narcotic_form_by_default.equals("y"))
			NarcoticApprovalForm_checkYN = "checked";
		if(called_from.equals("RX")){
%>
			<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
<%
		}
		else if(called_from.equals("COMP")){
%>
			<script language="JavaScript" src="../../ePH/js/PrescriptionComp.js"></script>
<%
		}
		else if(called_from.equals("IVD")){
%>
			<script language="JavaScript" src="../../ePH/js/IVPrescriptionWithAdditives.js"></script>
<%
		}
		if(called_from.equals("IVWA")){
%>
			<script language="JavaScript" src="../../ePH/js/IVPrescription.js"></script>
<%
		}
		if(called_from.equals("IVPB")){
%>
			<script language="JavaScript" src="../../ePH/js/IVPiggyBack.js"></script>
<%
		}
		if(called_from.equals("ONCO")){
%>
			<script language="JavaScript" src="../../ePH/js/OncologyRegimen.js"></script>
<%
		}
		if(called_from.equals("NRX2")){
%>
			<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		}
%>
		<form name="PrescriptionPrintDialog" id="PrescriptionPrintDialog">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
				<TR>
					<td colspan="2" height="20">&nbsp;&nbsp;<td>
				</TR>
<%	
				if(print_ord_sht_rule_ind.equals("") || print_ord_sht_rule_ind.equals("C")) {//Added for Bru-HIMS-CRF-393_1.0 //print_ord_sht_rule_ind.equals("") || Added for HSA-SCF-0036[IN:050011]
%>
					<tr>
						<td><fmt:message key="ePH.Prescription.label" bundle="${ph_labels}"/> </td>
						<td  class="label"><input type="checkbox" name="prescriptionPrint" id="prescriptionPrint" checked ></td>
					</tr>
<%
				}
				if(narcotic_aprvl_form_req_yn.equals("Y") || narcotic_aprvl_form_req_yn.equals("y")){
%>
					<tr>
						<td><fmt:message key="ePH.NarcoticApprovalForm.label" bundle="${ph_labels}"/> </td>
						<td  class="label">
							<input type="checkbox" name="NarcoticPrint" id="NarcoticPrint" <%=NarcoticApprovalForm_checkYN%> >
						</td>
					</tr>
<%	
				}
				if(print_mar_label_yn.equals("Y") && buildMAR_yn.equals("Y")){ //if block added for MMS-QH-CRF-0080 [IN:038064]
%>
					<tr>
						<td><fmt:message key="ePH.MARLabel.label" bundle="${ph_labels}"/> </td>
						<td  class="label">
							<input type="checkbox" name="MARLabel" id="MARLabel" checked value='Y'>
						</td>
					</tr>
<%	
				}
%>
				<TR>
					<td colspan="2" height="20">&nbsp;&nbsp;<td>
				</TR>
				<tr align='center'>
					<td  colspan="2" class="white" align='center'>
						<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="printOnlinePrescription(document.PrescriptionPrintDialog,'OK','<%=print_ord_sht_rule_ind%>')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0 -->
						<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="printOnlinePrescription(document.PrescriptionPrintDialog,'CANCEL')">
					</td>
				</tr>
			</table>
		</form>		
	</body>
</html>

