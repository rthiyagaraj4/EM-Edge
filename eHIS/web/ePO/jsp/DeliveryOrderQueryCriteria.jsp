<!DOCTYPE html>
<%@ page import=" ePO.*, ePO.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/DeliveryOrder.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id			=	"<%= request.getParameter("function_id") %>"
		menu_id				=	"<%= request.getParameter("menu_id") %>"
		module_id			=	"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode				=		CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String bean_id			=		"deliveryOrderBean";
	String bean_name		=		"ePO.DeliveryOrderBean";
	String default_value	=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";

	DeliveryOrderBean bean	=		(DeliveryOrderBean) getBeanObject(bean_id,bean_name, request  );  
	bean.clear();
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String facilityid=(String)session.getValue("facility_id");
	ServletContext context  =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//bean.setEntity_param((String) session.getAttribute("ACC_ENTITY_ID"));
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String minusdate	       =    com.ehis.util.DateUtils.minusDate(currentdate,"DMY",locale,7,"d");
	
	String master_type			=		"DLVORD";
	bean.setMasterType(master_type);
	
%>
<body onload='FocusFirstElement();document.formDeliveryOrderQueryCriteria.submit();'>
	<form name= "formDeliveryOrderQueryCriteria" action="../../ePO/jsp/DeliveryOrderQueryResult.jsp" method="post" target="DeliveryOrderQueryResult" onReset='FocusFirstElement();'>
		<table border="0" cellspacing="0" width="100%" align="center">
			<tr>
				<td  class="label"><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/></td>
				<td class='fields'><select name="supp_code" id="supp_code" ><%=bean.getRequestToSupp()%> </select></td>	 
				<td class="label">&nbsp;</td>
				<td class='fields'>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="ePO.DOType.label" bundle="${po_labels}"/></td>
				<td class='fields'><select name="delivery_type" id="delivery_type" ><%=bean.getDelivery_type_List()%></select></td>
				<td  class="label"><fmt:message key="ePO.DONo.label" bundle="${po_labels}"/></td>
				<td class='fields'><input type="text" size="15" maxlength="20" class='NUMBER' name="do_no" id="do_no"  onKeyPress="return CheckForSpecialChars(event);"> </td>
				<td  class="label" ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="from_do_date" id="from_do_date" size="10" value="<%=minusdate%>" maxlength="10" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_do_date');"></img>
				</td>
				<td class='label'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="to_do_date" id="to_do_date" size="10" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_do_date');"> 
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
				<td class='fields'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="checkValidateQryDate();"></td>
			</tr>
		</table>
		<input type="hidden" 	name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" 	name="language_id" id="language_id"		value="<%=locale%>">
		<input type="hidden" 	name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" 	name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" 	name="orderbycolumns" id="orderbycolumns"   value="PO_MASTER_CODE,hdr.do_date,hdr.do_no">
	</form>
<%	
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

