<!DOCTYPE html>
<%@ page import ="ePO.*, ePO.Common.* , eCommon.Common.*,  java.util.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonCalendar.js" type="text/javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<script language='javascript' src='../js/PurchaseOrderStatusQuery.js'></script>
	<script language='javascript' src='../js/PoMessages.js'></script>
	<script language='javascript' src='../js/PoCommon.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%


	String mode				=		CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String bean_id			=		"purchaseOrderStatusBean";
	String bean_name		=		"ePO.PurchaseOrderStatusBean";

	PurchaseOrderStatusBean bean	=		(PurchaseOrderStatusBean) getBeanObject(bean_id,bean_name, request  );  
	bean.clear();
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String facilityid=(String)session.getValue("facility_id");
	ServletContext context  =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMasterType("PORDER");
	bean.setLanguageId(locale);

	String currentWeek		   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String lastWeek		       =    com.ehis.util.DateUtils.minusDate(currentWeek,"DMY",locale,7,"d");

%>

<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
	<form name="po_order_status_qry_form" id="po_order_status_qry_form" action="" method="post" target="messageFrame">
	
		<table border=0 cellspacing=0 cellpadding='3' width='100%' align=center>
			<tr>
				<td class='label'>
					<fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/>
				</td>
				<td class='fields'><select name="purchaseUnit" id="purchaseUnit" ><%=bean.getRequestFromPurchaseUnit()%></select>
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class='label'>
					<fmt:message key="ePO.PurchaseType.label" bundle="${po_labels}"/>
				</td>
				<td class='fields'><select name="PurchaseType" id="PurchaseType" ><%=bean.getPurchase_type_List()%></select></td>
				<td class='label'>
					<fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/>
				</td>
				<td class='fields'><select name="supplierCode" id="supplierCode" ><%=bean.getRequestToSupp()%> </select></td>
				<td class='label'>
					<fmt:message key="ePO.orderStatus.label" bundle="${po_labels}"/>
				</td>
				<td class="fields">&nbsp;
					<select name="orderStatus" id="orderStatus" >
						<option value="" >&nbsp;---Select---&nbsp;</option>
						<option value="AM" >Amend</option>
						<option value="CA" >Cancelled</option>
						<option value="CL" >Closed</option>
						<option value="FA" >Fully Approved</option>
						<option value="FD" >Fully Delivered</option>
						<option value="UF" >Unfinalized</option>
						<option value="PA" >Partially Approved</option>
						<option value="PD" >Partially delivered</option>
						<option value="RA" >Re-Approved</option>
						<option value="PR" >Partially Received</option>
						<option value="FR" >Fully Received</option>
					</select>
				</td>
			</tr>

			<tr>
				<td class='label'>
					<fmt:message key="ePO.PoDateFrom.label" bundle="${po_labels}"/>
				</td>
				<td class='fields'>
					<input type="text" name="docDtFrom" id="docDtFrom" value="<%=lastWeek%>"  size="8" maxlength="10" onBlur="CheckDate(this);" onKeyPress='' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('docDtFrom');" style='cursor:pointer'></img>
				</td>
				<td class='label'>
					<fmt:message key="ePO.docDateTo.label" bundle="${po_labels}"/>
				</td>
				<td class='fields'>
					<input type="text" name="docDtTo" id="docDtTo" value="<%=currentWeek%>"  size="8" maxlength="10"  onBlur="checkDateRange(this,'po_order_status_qry_form');" onKeyPress='' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('docDtTo');" style='cursor:pointer'></img>
				</td>
				<td class='label'>
					<fmt:message key="ePO.PONo.label" bundle="${po_labels}"/>
				</td>
				<td class='fields'>
					<input type="text" name="docNo" id="docNo" value=""  size=20 maxlength=40  onKeyPress="return CheckForSpecialChars(event);" >
				</td>
				<td class='label'>
					<fmt:message key="ePO.Item.label" bundle="${po_labels}"/>&nbsp;&nbsp;
				</td>
				<td class='fields'>&nbsp;
					<input type="text" name="item_desc" id="item_desc" size="30" maxlength="30"  value="" >
					<input type="button" value="?" class="button" onClick="return searchCodeItem(item_desc);" >		
				</td>
			</tr>

			<tr>
				<td >&nbsp;&nbsp;</td>
				<td >&nbsp;&nbsp;</td>
				<td >&nbsp;&nbsp;</td>
				<td >&nbsp;&nbsp;</td>
				<td >&nbsp;&nbsp;</td>
				<td >&nbsp;&nbsp;</td>
				<td >&nbsp;&nbsp;</td>
				<td align=center>
					<input type="button" class="button" value="Search" onclick="submitQuery1();">
				</td>
				<td >&nbsp;&nbsp;</td>

			</tr>
		</table>

		<input type='hidden' name='flag' id='flag' value='true'>
		<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=currentWeek %>">
		<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=lastWeek %>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"	value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
		<input type="hidden" name="item_code" id="item_code"			value="">
	</form>
</body>
</html>

