<!DOCTYPE html>
<%@ page import=" ePO.*,ePO.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoMessages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PurchaseOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	String facility_id							=		(String) session.getValue( "facility_id" ) ;
	String bean_id								=		"purchaseOrderBean";
	String bean_name							=		"ePO.PurchaseOrderBean";
	String user									=		(String) session.getValue( "login_user" );
	String po_purchase_unit = request.getParameter("po_purchase_unit");
	String facility_disable = "";
	String mode = request.getParameter("mode");
	String po_no = request.getParameter("po_no");
		
	PurchaseOrderBean bean = (PurchaseOrderBean) getBeanObject( bean_id, bean_name,request );

	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String minusdate	       =    com.ehis.util.DateUtils.minusDate(currentdate,"DMY",locale,7,"d");
	
	String global_unit_yn =		bean.checkForNull((String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PO_GLOBAL_YN"),po_purchase_unit).get("GLOBAL_UNIT_YN"));
	
	if(global_unit_yn.equals("Y"))
		facility_disable = "";
	else
		facility_disable = "disabled";
	
	
%>
<body onload='FocusFirstElement();document.formPurchaseOrderSearchWindowCriteria.submit();' >
	<form name="formPurchaseOrderSearchWindowCriteria" id="formPurchaseOrderSearchWindowCriteria" action="../../ePO/jsp/PurchaseOrderSearchWindowResult.jsp" method="post" target="framePurchaseOrderSearchWindowResult" onReset='FocusFirstElement();'>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align="center"  colspan=6 >	
			<th  colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
			<tr>
				<td class="label"  ><fmt:message key="Common.item.label"	bundle="${common_labels}"/></td>
				<td class="fields" ><input type=text name=item_desc size=70 maxlength=60 value="" onkeypress=""> 
					<input type=hidden name="item_code" id="item_code" value=""> 
					<input type='button' class='button' value='?' onClick='searchItemCode(item_desc);' name="item_search" id="item_search"></td>
				<td class="label"  >Facility</td>
				<td class="fields">&nbsp;
				<% if(global_unit_yn.equals("Y")) { %>
					<select name="facility_id" id="facility_id" >
						<%=bean.getFacilityList(po_purchase_unit)%>
					</select>
				<% } else { %>
					<select name="facility_id" id="facility_id" <%=facility_disable%>>
						<%=bean.getFacilityList(po_purchase_unit,bean.getLoginFacilityId())%>
					</select>
				<% } %>		
				</td>
		
				<td class="label"  >Store</td>
				<td class="fields">&nbsp;
					<select name="req_store_code" id="req_store_code">
						<%=bean.getRequestByStoreList()%>
					</select>
				</td>
			</tr>
			<tr> 
				<td  class="label" colspan ="2">
					<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=minusdate%>" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="Common.todate.label" bundle="${common_labels}"/>
					<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');">
				</td>
				<td class="label"  >Req Doc NO</td>
				<td class="fields" ><input type="text" size="20" maxlength="20"  name="req_no" id="req_no" onKeyPress="return CheckForSpecialChars(event);" ></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<br>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td align="left"><input type=button name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="document.formPurchaseOrderSearchWindowCriteria.submit();" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type=button name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' style="font-family:verdana;width:5em"  onclick="ReloadPurchaseOrderWindow();"></td>
			</tr>
		</table>

		<input type="hidden" 	name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"  	value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_LOOKUP")%>"> 
		<input type="hidden" 	name="batch_id" id="batch_id"				value="" >
		<input type="hidden" 	name="expiry_date" id="expiry_date"			value="" >
		<input type="hidden" 	name="trade_id" id="trade_id"				value="" >
		<input type="hidden" 	name="binlocation" id="binlocation"			value="" >
		<input type="hidden" 	name="loc_batch_string" id="loc_batch_string"		value="" >
		<input type="hidden" 	name="po_purchase_unit" id="po_purchase_unit"		value="<%=po_purchase_unit%>" >
		<input type="hidden" 	name="po_no" id="po_no"		value="<%=po_no%>" >
		<input type="hidden" 	name="mode" id="mode"		value="<%=mode%>" >
		
</form>
 
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

