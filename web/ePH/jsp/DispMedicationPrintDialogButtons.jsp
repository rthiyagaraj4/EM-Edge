<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
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
		 
		//Added for GHL-CRF-0669 start
		String	bean_id			=	"DispMedicationBean" ;
		String	bean_name		=	"ePH.DispMedicationBean";
		DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);
		//Added for GHL-CRF-0669 end
		
boolean siteSpecDispSheet = false;//Adding start for KDAH-CRF-0476
String customer_id = bean.getCustomerID(); //Added for GHL-CRF-0669

Connection con = null;
try{

		  con	= ConnectionManager.getConnection(request);
		 siteSpecDispSheet = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PRINT_DISP_SHEET");//added for KDAH-CRF-476
}catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
}
finally{
	if(con != null)
		ConnectionManager.returnConnection(con,request);
}//Adding end for KDAH-CRF-0476
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedicationAllStages.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body onload="printDispenseFocus();">
		<form name ="frmPrintDialogButtons"  TARGET="messageFrame" method="get"><!-- action removed for KDAH-CRF-0487-->
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<tr align="right">
				<td  width ="100%" class='button'>
					<input type="button" name='btnOk' id='btnOk' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="if(validateRecordMandatory()){validateEditDetails(parent.editLabelFrame.document.DispMedicationEditLabel,'PRINT_DIALOG');};" onKeyPress='ok_enter_event(event, this);'>&nbsp;&nbsp;
<%if(siteSpecDispSheet){ //KDAH-CRF-0476
	if(customer_id.equals("KDAH") || (customer_id.equals("MC") && bean.getOrderType().equals("NOR"))){ //If Condition added for GHL-CRF-0669
%>
					<input type = "button" name = "disp_sheet" value="Print Dispense Sheet" onclick = "printDispSheet();">&nbsp;
<%}}%>
					<input type="button" name = 'btnCancel' class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="if(validateRecordMandatory()){closePrintDialogWindow();}">&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			</table>


	
	<script>
		document.frmPrintDialogButtons.btnOk.focus(); //Added for AMS-CRF-0009[IN:030935]
	</script>
<%if(siteSpecDispSheet){ //KDAH-CRF-0476
	if(customer_id.equals("KDAH") || (customer_id.equals("MC") && bean.getOrderType().equals("NOR"))){// If condition added for GHL-CRF-0669
	%>
<script>
document.frmPrintDialogButtons.disp_sheet.focus();
printDispenseFocus();
</script>
<%}
}

%>
					<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
					<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE=""> <!-- Added for KDAH-CRF-0476 -->
					<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="">
					<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_disp_fm_no" id="p_disp_fm_no" value="">
					<input type="hidden" name="p_disp_to_no" id="p_disp_to_no" value="">
					<input type="hidden" name="p_patient_id" id="p_patient_id" value="">
					<input type="hidden" name="p_patient_class" id="p_patient_class" value="">
					<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
					<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
					<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
					<INPUT TYPE="hidden" name="p_reprint_yn" id="p_reprint_yn" VALUE="Y">
					<INPUT TYPE="hidden" name="p_order_type" id="p_order_type" VALUE="">
					<INPUT type="hidden" name="customer_id" id="customer_id" value="<%=customer_id%>"> <!-- Added for GHL-CRF-0669 -->
					
</form></body>

</html>

