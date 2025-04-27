<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
</head>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="RegPrescriptionsDetailsHeader" id="RegPrescriptionsDetailsHeader" >
<%
	String	mode			=	CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String	bean_id			=	"RegPrescriptionsBean" ;
	String	bean_name		=	"ePH.RegPrescriptionsBean";

	String	disp_bean_id				=	"DispMedicationAllStages" ;
	String	disp_bean_name			    =	"ePH.DispMedicationAllStages";	
	
	DispMedicationAllStages disp_bean = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name,request);
	disp_bean.setLanguageId(locale);
    String  billing_interface_yn		=	disp_bean.checkforbillinginterface();


	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//RegPrescriptionsBean bean = (RegPrescriptionsBean)mh.getBeanObject( bean_id, request, bean_name ) ;
    String called_from =request.getParameter("called_from");
	%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="regprescriptionsdetailstable" name="regprescriptionsdetailstable" style="visibility:hidden">
	<tr>
		<th style="font-size:9px" width="20%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
		<th style="font-size:9px" width="15%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th> 
		<th style="font-size:9px" width="15%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th><!--code 'OrderDate' replaced by StartDate for Bru-HIMS-CRF-418[IN045564]  -->
		<th style="font-size:9px" width="14%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th style="font-size:9px" width="16%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th style="font-size:9px" width="2%">&nbsp;</th>
		<th style="font-size:9px" width="6%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<th style="font-size:9px" width="6%"><fmt:message key="Common.print.label" bundle="${common_labels}"/></th>
	</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="no_of_orders" id="no_of_orders" value="">
<input type="hidden" name="print_pres" id="print_pres" value="">
<input type="hidden" name="orders_selected" id="orders_selected" value="">
<input type="hidden" name="print_pres_orders" id="print_pres_orders" value="">
<input type="hidden" name="billing_interface_yn" id="billing_interface_yn" value="<%=billing_interface_yn%>">
<input type="hidden" name="dischargeIND" id="dischargeIND" value="">

</form>
</body><SCRIPT LANGUAGE="JavaScript">
<%if(!called_from.equals("TASKLIST")){%>
	loadStatusDisplayFrame();
<%}%>
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

