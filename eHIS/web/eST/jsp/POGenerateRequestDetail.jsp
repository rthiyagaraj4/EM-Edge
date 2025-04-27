<!DOCTYPE html>
<%@ page import="java.lang.Math.*,eST.POGenerateRequestBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/POGenerateRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style type="text/css">
		.NOBORDER{
			border:1;
			border-width: 1;
			border-style: solid;
			text-align: right;
		}
		</style>
</head>

	<%
		request.setCharacterEncoding("UTF-8");
		String locale								=		(String)session.getAttribute("LOCALE");
		String bean_id								=		"pogenerateRequestBean";
		String bean_name							=		"eST.POGenerateRequestBean";
		String disabled								=		"";
		String checked								=		"checked";
		String className							=		"";
		
		
		String mode									=		request.getParameter("mode");
		String function_id							=		request.getParameter("function_id");

		POGenerateRequestBean pogenerateRequestBean		=		(POGenerateRequestBean)getBeanObject( bean_id, bean_name, request);  
		
		pogenerateRequestBean.setLanguageId(locale);

		int i							=		0;
		String to_department			=		"";
		String requisition_by_store		=		"";
		String selected_val				=		"";
		String qty_required				=		"";
		to_department					=		request.getParameter("to_department");
		requisition_by_store			=		request.getParameter("requisition_by_store");
		ArrayList alDtlRecords			=		(ArrayList)pogenerateRequestBean.getDtlRecords();
	
		%>
	<body onload="showCheckTickdisabled();">
		<form name='formPOGenerateRequestDetail' id='formPOGenerateRequestDetail'>
<%	if (alDtlRecords != null && (alDtlRecords.size()>0)) {
	String firstItem			=null;
	%>
	<div name='HeaderLabels' id='HeaderLabels' style='width:1022;height:400;overflow-y:auto'>
		<table border="1" cellpadding="0" height='2' cellspacing="0" width="100%"  id='tb1'   >
			<!--	
	* @Name - Priya
	* @Date - 19/02/2010
	* @Inc# - IN019466
	* @Desc - To align the headers in center . 					
	-->
 			<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
				<td class='COLUMNHEADER' width="1%"  style="TEXT-ALIGN:center">
				<fmt:message key="Common.item.label" bundle="${common_labels}"/><BR><input type="checkbox" value="Y" name="checkAll" id="checkAll" disabled onClick="return toggleCheck(this);"></td>
				<td class='COLUMNHEADERCENTER'  width="19%"  style="TEXT-ALIGN:center">
				<fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'  width="5%" style="TEXT-ALIGN:center">&nbsp;&nbsp;
				<fmt:message key="eST.StockItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td class='COLUMNHEADERCENTER'  width="8%" style="TEXT-ALIGN:center">
				<fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='COLUMNHEADERCENTER'   width="7%" style="TEXT-ALIGN:center">
				<fmt:message key="eST.MaxStockQuantity.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADER'  width="5%"  style="TEXT-ALIGN:center">&nbsp;&nbsp;
				<fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>

				<td class='COLUMNHEADERCENTER'  width = "8%" style="TEXT-ALIGN:center"><fmt:message key="eST.ROQty.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="8%" style="TEXT-ALIGN:center"><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="7%" style="TEXT-ALIGN:center"><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="8%" style="TEXT-ALIGN:center"><fmt:message key="eST.RequestedUOM.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="8%" style="TEXT-ALIGN:center"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></td>
			</tr>
		<% 
			
			for( i=0;i<alDtlRecords.size();i++){
			HashMap hmDtlRecords=(HashMap)alDtlRecords.get(i);
		
			className					=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";	
	
			if (i==0) {
					firstItem				=		""+i;
						}
			if((pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("REQ_QTY"),"0")).equals("0")){
						qty_required			=		"disabled";
					}else {
						qty_required			=		"enabled";
					}
					
					if(Double.parseDouble(pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("REQ_QTY"),"0"))<=0){
							disabled = "disabled";
							checked = "";
							selected_val="N";
						}else{
							disabled = "";
							checked = "checked";
							selected_val="Y";
						}
						
			%>	
					<tr id="tr_<%=i%>">
					<td class="<%=className%>" width="2%" >
					<input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>"  value="<%=selected_val%>"   onFocus="return changeRowColor(tr_<%=i%>);" <%=disabled%> <%=checked%> <%=qty_required%> onclick="assignValue(this);"></td>
					<td class="<%=className%>" width="20 %"><%=hmDtlRecords.get("ITEM_DESC")%></td>
					<td class="<%=className%>" width="5%">
					<%if(((String)hmDtlRecords.get("STOCK_ITEM_YN")).equals("Y")){
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					}else{
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
					}%>
					</td>
					<td class="<%=className%>" width="8%"><%=hmDtlRecords.get("UOM_DESC")%></td>
					 <!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Max Stock Quantity, RO Level, RO Qty, Quantity On Hand, Pending Qty .				
					-->
					<td class="<%=className%>" width="7%" style="TEXT-ALIGN:right"> <%=pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("MAX_STK_QTY"),"")%>&nbsp;</td>
					
					<td class="<%=className%>" width="5%" style="TEXT-ALIGN:right"> <%=pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("REORDER_LEVEL"),"")%>&nbsp;</td>
					
					<td class="<%=className%>" width="8%" style="TEXT-ALIGN:right"> <%=pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("REORDER_QTY"),"")%>&nbsp;</td>
					
					<td class="<%=className%>" width="8%" style="TEXT-ALIGN:right"> <%=pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("QTY_ON_HAND"),"")%>&nbsp;</td>
					
					<td class="<%=className%>"  width="8%" style="TEXT-ALIGN:right"> <%=pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("PENDING_REQ_QTY"),"0")%>&nbsp;</td>
					
					<td class="<%=className%>" width="8%"><%=hmDtlRecords.get("UOM_DESC")%></td>
					<input type="hidden" name="uom_code_<%=i%>" id="uom_code_<%=i%>" value="<%=(String)hmDtlRecords.get("UOM_CODE")%>">
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=(String)hmDtlRecords.get("ITEM_CODE")%>">
<!-- 	/**
	* @Name - krishna
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.
	*/

 -->	

					<td class="<%=className%>" width="8%"><input type="text" class="NOBORDER" name="req_qty_<%=i%>" id="req_qty_<%=i%>" value="<%=(String)hmDtlRecords.get("REQ_QTY")%>" size=12 maxlength=12 onkeypress="return isValidNumber(this,event,7,'<%=Integer.parseInt((String) hmDtlRecords.get("NO_OF_DECIMALS"))%>','<%=(String) hmDtlRecords.get("ALLOW_DECIMALS_YN")%>');" onBlur="checkQty(this,add_itm_<%=i%>,'<%=pogenerateRequestBean.checkForNull((String)hmDtlRecords.get("MAX_STK_QTY"),"0")%>','<%=(String)hmDtlRecords.get("REQ_QTY")%>','<%=Integer.parseInt((String) hmDtlRecords.get("NO_OF_DECIMALS"))%>');" onFocus="return changeRowColor(tr_<%=i%>);"></td>
			<%}%>
			<script>
		document.formPOGenerateRequestDetail.req_qty_<%=firstItem%>.focus();
		</script>	
		<%}else{%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
		</script>
		<%}%>
		</table>
	</div>



			<input type="hidden"		 name="total_checkboxes" id="total_checkboxes"			value="<%=i%>">
			<input type="hidden"		 name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden"		 name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden"		 name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden"		 name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden"		 name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden"		 name="doc_type_code" id="doc_type_code"				value="">
			<input type="hidden"		 name="doc_no" id="doc_no"						value="">
			<input type="hidden"		 name="doc_date" id="doc_date"					value="">
			<input type="hidden"		 name="doc_ref" id="doc_ref"						value="">
			<input type="hidden"		 name="requisition_by_store" id="requisition_by_store"		value="">
			<input type="hidden"		 name="to_department" id="to_department"				value="">
			<input type="hidden"		 name="item_class_code" id="item_class_code"				value="">
			<input type="hidden"		 name="finalize_yn" id="finalize_yn"					value="">
			<input type="hidden"		 name="autono_yn" id="autono_yn"					value="">
			<input type="hidden"		 name="effective_date" id="effective_date"				value="">
			<input type="hidden"		 name="item_from_code" id="item_from_code"				value="">
			<input type="hidden"		 name="item_to_code" id="item_to_code"				value="">
			<input type="hidden"		 name="alpha_from_code" id="alpha_from_code"				value="">
			<input type="hidden"		 name="alpha_to_code" id="alpha_to_code"				value="">
			
	
		</form>
		<%
putObjectInBean(bean_id,pogenerateRequestBean,request);
%>
	</body>
</html>

