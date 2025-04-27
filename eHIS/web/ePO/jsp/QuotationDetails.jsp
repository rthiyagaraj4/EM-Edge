<!DOCTYPE html>
<%@ page import=" ePO.QuotationDetailBean,ePO.QuotationBean, ePO.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
		<script language="JavaScript" src="../../ePO/js/Quotation.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		 </script>
</head>
<%
	QuotationDetailBean requestDetail;
	String bean_id						=			"quotationBean";
	String bean_name					=			"ePO.QuotationBean";
	QuotationBean bean				=			(QuotationBean) getBeanObject(bean_id, bean_name,request );  
	bean.setLanguageId(locale);
	boolean editMode					=			false;
	String mode							=			request.getParameter("mode");
	String edit							=			request.getParameter("edit")==null?"1":request.getParameter("edit");
	String disabled						=			"";
	String item_disabled				=			"";
	String item_desc					=			"";
	String uom							=			"";
	String	conv_fact					=			"";
	String 	id_pur_uom_conv1			=			"";
	String order_qty 					=			"";
	String item_remarks 				=			"";
	String  item_code_dis				=			"";
	int srl_no							=			-1;
	int po_srl_no 						= 			1;
	int delv_srl_no						=			1;
	mode								=			mode.trim();
	String item_code					=			request.getParameter("item_code");
	String po_no						=			request.getParameter("po_no")==null?"":request.getParameter("po_no");
	String delv_date					=			request.getParameter("delv_date")==null?"":request.getParameter("delv_date");
	String request_no					=			request.getParameter("request_no")==null?"":request.getParameter("request_no");
	

	String caption						=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.Add.label","po_labels");
	String disable_add					=			"";
	String	uom_code					=			"";
	String itemCode_reqNO 				= 			"";
	String req_store 					= 			"";
	String facility_id 					= 			"";
	String rejection_remarks 			=			"";
	String quotation_uom_desc			=			"";
	String quotation_uom_code			=			"";
	String quotation_qty = "";
	String free_qty = "";
	String sample_qty = "";
	String batch_id = "";
	String expiry_date = "";
	String trade_id = "";
	String rejected_qty = "";
	String delvy_date = "";
	String quotation_price = "";
	String to_supplier					=			request.getParameter("to_supplier");
	String currency_code				=			request.getParameter("currency_code");
	String local_currency			=		bean.checkForNull(request.getParameter("local_currency"));
	String tot_value					=			"";
	String dis_type						=			"";
	String dis_amt						=			"";
	String net_amount					=			"";
	String disPerSelected 				=			"";
	String disAmtSelected 				=			"";
	String perHidden					=			"";
	String manufactur_id = "" ;
	String sample_type = "";
	String replace_type = "";
	String item_status = "";
	
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;


	
	if (item_code != null) {
	
		caption							=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.Modify.label","po_labels");
		editMode						=			true;
		item_disabled					=			"disabled";
		if(edit.equals("2"))
			disabled					=			"disabled";
				
		
		requestDetail					=			bean.getItemDetail(item_code);
		System.out.println("requestDetail in details = "+requestDetail);
		item_code						=			bean.checkForNull(requestDetail.getItem_code());
		item_desc						=			requestDetail.getItem_desc();
		order_qty						=			bean.checkForNull(requestDetail.getOrder_qty());	
		uom								=			bean.checkForNull(requestDetail.getUomDesc());
		uom_code						=			bean.checkForNull(requestDetail.getUom());
		srl_no							=			requestDetail.getSrl_no();
		po_srl_no						=			requestDetail.getPo_srl_no();
		delv_srl_no						=			requestDetail.getDelv_srl_no();
		item_remarks 					= 			bean.checkForNull(requestDetail.getItem_remarks());
		req_store 						= 			bean.checkForNull(requestDetail.getStore_code());
		facility_id 					= 			bean.checkForNull(requestDetail.getFacility_code());
		conv_fact						=			bean.checkForNull(requestDetail.getConvFact());
		rejection_remarks 				= 			bean.checkForNull(requestDetail.getRejection_remarks());
		quotation_uom_desc				=			bean.checkForNull(requestDetail.getQuotation_uom_desc());
		quotation_uom_code 				= 			bean.checkForNull(requestDetail.getQuotation_uom_code());
		quotation_qty 					= 			bean.checkForNull(requestDetail.getQuotation_qty());
		free_qty 						= 			bean.checkForNull(requestDetail.getFree_qty());
		sample_qty 						= 			bean.checkForNull(requestDetail.getSample_qty());
		batch_id 						= 			bean.checkForNull(requestDetail.getBatch_id());
		expiry_date 					= 			bean.checkForNull(requestDetail.getExpiry_date());
		trade_id 						= 			bean.checkForNull(requestDetail.getTrade_id());
		rejected_qty 					= 			bean.checkForNull(requestDetail.getRejected_qty());
		delvy_date						=			bean.checkForNull(requestDetail.getDelv_date());
		quotation_price					=			bean.checkForNull(requestDetail.getQuotation_price());
		tot_value 						= 			bean.checkForNull(requestDetail.getTot_value());
		dis_type 						= 			bean.checkForNull(requestDetail.getDis_type());
		dis_amt 						= 			bean.checkForNull(requestDetail.getDis_amt());
		net_amount 						= 			bean.checkForNull(requestDetail.getNet_amount());
		manufactur_id					=			bean.checkForNull(requestDetail.getManufactur_id());
		replace_type					=			bean.checkForNull(requestDetail.getReplace_type());
		sample_type						=			bean.checkForNull(requestDetail.getSample_type());
		item_status						=			bean.checkForNull(requestDetail.getItem_status());
			
		}else{
			item_code						=			"";
			disable_add						=			 "disabled";
			
		}
		
	
		if(dis_type.equals("P")){
			disPerSelected = "selected";
			perHidden = "visible";
		}else if(dis_type.equals("A")){
			disAmtSelected = "selected";
			perHidden = "hidden";
		}
		
		String replaceYesSelected = "";
		String replaceNoSelected = "";
		
		if(replace_type.equals("Y")){
			replaceYesSelected = "selected";
			
		}else if(replace_type.equals("N")){
			replaceNoSelected = "selected";
		}
		
		String sampleYesSelected = "";
		String sampleNoSelected = "";
		
		if(sample_type.equals("Y")){
			sampleYesSelected = "selected";
			
		}else if(sample_type.equals("N")){
			sampleNoSelected = "selected";
		}
		
		String statusSelected = "";
		String statusRejected = "";
		String statusPending = "";
		
		System.out.println("item_status in dtl = "+item_status);
		
		if(item_status.equals("SD")){
			statusSelected = "selected";
			
		}else if(item_status.equals("RD")){
			statusRejected = "selected";
		}else if(item_status.equals("PD")){
			statusPending = "selected";
		}
		
		
				
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			item_code_dis= "disabled";
		else
			item_code_dis= "";
		
		String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
		String postdate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,7,"d");
		
		
		System.out.println("bean.getCurrency_code() in dtl= "+bean.getCurrency_code());
		String supp_code = "";
		String dflt_currency = "";
		if(bean.getRequest_on_supp() != "" && bean.getRequest_on_supp() != null ){
			supp_code = bean.getRequest_on_supp(); 
		}else if(to_supplier != "" && to_supplier != null){
			 supp_code = to_supplier ; 
		}
		if(bean.getCurrency_code() != "" && bean.getCurrency_code() != null ){
			dflt_currency = bean.getCurrency_code() ; 	 
			System.out.println("dflt_currency in hdr before1= "+dflt_currency);
		}
		else if(currency_code != "" && currency_code != null){	 
			dflt_currency = currency_code ; 	 
			System.out.println("dflt_currency in hdr before= "+dflt_currency);
		}
	
		
		System.out.println("supp_code in dtl = "+supp_code);
		
		if(dflt_currency == "" && dflt_currency == null){
		HashMap hmRecord = bean.getCurrencyDesc(supp_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
				
			}
		}	
			System.out.println("dflt_currency in  Detail= "+dflt_currency);
			
		String dflt_currency_desc =	bean.checkForNull((String)bean.fetchRecord("SELECT currency_code, short_desc FROM sy_foreign_currency_lang_vw WHERE language_id = ? and currency_code = ? ORDER BY 2",new String[]{locale,dflt_currency}).get("SHORT_DESC"),"");
		
		String currency_desc_lc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  sy_foreign_currency_lang_vw where CURRENCY_CODE=? and language_id = ?",new String[]{local_currency,locale}).get("SHORT_DESC"),"");	
		
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){	
%>
<body onLoad="FocusFirstElement();onLoadCurrCode('<%=dflt_currency_desc%>','<%=currency_desc_lc%>');calculateDisAmount();">
<% } else { %>
<body onLoad="onLoadCurrCode('<%=dflt_currency_desc%>','<%=currency_desc_lc%>');calculateDisAmount();">
<% } %>

	<form name="formQuotationDetail" id="formQuotationDetail">
		<table border="0" cellspacing="0" cellpadding="0" width="100%" >
			<tr>
				<th colspan=2><fmt:message key="ePO.EnterItemDetails.label" bundle="${po_labels}"/></th>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label" colspan=2><fmt:message key="ePO.Item.label" bundle="${po_labels}"/>&nbsp;&nbsp;
					<input type="text" name="item_desc" id="item_desc" size="30" maxlength="30"  value="<%=item_desc%>" <%=item_disabled%> onBlur="">
					<input type="button" value="?" class="button" onClick="return searchCodeItem(item_desc);" <%=item_disabled%>   >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>&nbsp;&nbsp;
				</td>
			</tr>
		
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
				<td class="label" >	<fmt:message key="ePO.QuotationQty.label" bundle="${po_labels}"/></td>
				<td class="field" >
				
				<input type="text" name="quotation_qty" id="quotation_qty"  class=NUMBER size="10" maxlength="8"  value="<%=quotation_qty%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);checkUOMConvFactor();calculateValue();calculateDiscount();"><%=bean.getImage("M")%>
				
				</td>
			</tr>
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label" >	<fmt:message key="ePO.QuotationUOM.label" bundle="${po_labels}"/></td>
				<td class="field" >	
					<select name='quotation_uom' id='quotation_uom' onchange="getUOMDesc(this);" onBlur="getUOMDesc(this);  checkUOMConvFactor();" ><%=bean.getUom_code(quotation_uom_code)%></select><%=bean.getImage("M")%>
					
				</td>
			</tr>
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label" >	<fmt:message key="ePO.UnitCost.label" bundle="${po_labels}"/></td>
				<td class="field" >	<input type="text" name="quotation_price" id="quotation_price" class=NUMBER size="12" maxlength="12"  value="<%=quotation_price%>" onKeyPress="return isValidNumber(this,event,7,3);isValidInteger();" onBlur="checkUOMConvFactor();calculateValue();calculateDiscount();" >
				<label id='currency_label_1' class="label" >&nbsp;<B></B></label>
				</td>
			</tr>
			
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label" >	<fmt:message key="ePO.GrossAmount.label" bundle="${st_labels}"/></td>
				<td class="field" > <input type="text" class=NUMBER name="tot_value" id="tot_value" size="15" maxlength="15"  value="<%=tot_value%>" onKeyPress="return isValidNumber(this,event,10,3);isValidInteger();" onBlur="calculateDiscount();">
				<label id='currency_label_2' class="label" >&nbsp;<B></B></label>
				</td>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label"> <fmt:message key="ePO.DiscountType.label" bundle="${st_labels}"/></td>
				<td class="field" > 
					<select name="dis_type" id="dis_type" onchange="calculateDiscount();perChange(this);">
						<option value="P" <%=disPerSelected%>>Percentage</option>
						<option value="A" <%=disAmtSelected%>>Amount</option>
					</select>
				</td>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label">	<fmt:message key="ePO.Discount.label" bundle="${st_labels}"/></td>
				<td class="field" > 
					<% if(dis_amt == "") {%>
						<input type="text" class=NUMBER name="dis_value" id="dis_value" size="10" maxlength="10"  value="0" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();">
						<span id="PerHide" style=visibility:visible>
							<input type="text" class=NUMBER name="dis_amt" id="dis_amt" size="10" maxlength="10"  value="0" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();" disabled>
						</span>
					<% } else { %>
						<input type="text" class=NUMBER name="dis_value" id="dis_value" size="10" maxlength="10"  value="" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();">
						<span id="PerHide" style=visibility:<%=perHidden%>>
							<input type="text" class=NUMBER name="dis_amt" id="dis_amt" size="10" maxlength="10"  value="<%=dis_amt%>" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();calculateDisAmount()" disabled>
						</span>	
					<% } %>
						<label id='currency_label_3' class="label" >&nbsp;<B></B></label>
				</td>
			</tr>
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label"> <fmt:message key="ePO.NetAmount.label" bundle="${st_labels}"/></td>
				<td class="field" > <input type="text"  class=NUMBER name="net_amount" id="net_amount" size="15" maxlength="15"  value="<%=net_amount%>" onKeyPress="return isValidNumber(this,event,10,3);isValidInteger();" onBlur="">
					<label id='currency_label_4' class="label" >&nbsp;<B></B></label>
				</td>
			</tr>
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label"> <fmt:message key="ePO.ItemStatus.label" bundle="${st_labels}"/></td>
				<td class="field" > 
					<select name="item_status" id="item_status" onchange="">
						<option value="PD" <%=statusPending%> >Pending</option>
						<option value="RD" <%=statusRejected%>>Rejected</option>
						<option value="SD" <%=statusSelected%>>Selected</option>
					</select>
				</td>
			</tr>
			
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td colspan=2 class="label" id="batch_td" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "MoreItemDetails('<%=bean_id%>','<%=bean_name%>','<%=mode%>');"><font class='HYPERLINK'><fmt:message key="ePO.MoreDetails.label" bundle="${po_labels}"/></font></label></td> 
				
			</tr>
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td colspan=2 class="label" id="batch_td" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "SelectionCriteria('<%=bean_id%>','<%=bean_name%>','<%=mode%>');"><font class='HYPERLINK'><fmt:message key="ePO.SelectionCriteria.label" bundle="${po_labels}"/></font></label></td> 
				
			</tr>
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td colspan=2 class="label" id="batch_td" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "EvaluationFactor('<%=bean_id%>','<%=bean_name%>','<%=mode%>');"><font class='HYPERLINK'><fmt:message key="ePO.EvaluationFactor.label" bundle="${po_labels}"/></font></label></td> 
				
			</tr>
			
			
			
			
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td colspan=2 align=right>
					<input type="button" class="button" name="add" id="add" value="<%=caption%>" <%=disable_add%> onClick="addItemRecord();">&nbsp;
					<input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="ePO.cancel.label" bundle="${po_labels}"/>' onClick="resetDetail();"></td>
			</tr>
		</table>
	
	
		<input type="hidden"		name="mode" id="mode"						 value="<%=mode%>">
		<input type="hidden"		name="request_by_pu" id="request_by_pu"			 value="">
		<input type="hidden"		name="request_on_supp" id="request_on_supp"			 value="">
		<input type="hidden"		name="item_code" id="item_code"				 value="<%=item_code%>">
		<input type="hidden"		name="srl_no" id="srl_no"					 value="<%=srl_no%>">
		<input type="hidden"		name="bean_id" id="bean_id"					 value="<%=bean_id%>">
		<input type="hidden"		name="bean_name" id="bean_name"				 value="<%= bean_name %>">
		<input type="hidden"		name="function_id" id="function_id"				 value="<%=bean.getFunctionId()%>">
		<input type="hidden"		name="editing" id="editing"					 value="<%=editMode?2:1%>">
		<input type="hidden"		name="check_box_status" id="check_box_status"			 value="Y">
		<input type="hidden"		name="store_name" id="store_name"				 value="">
		<input type="hidden"		name="uom" id="uom"					     value="<%=uom_code%>">
		<input type="hidden"		name="temp_uom" id="temp_uom"					 value="<%=uom%>">
		<input type="hidden"		name="temp_uom_code" id="temp_uom_code"			 value="<%=uom_code%>">
		<input type="hidden"		name="SQL_MM_ITEM_LOOKUP" id="SQL_MM_ITEM_LOOKUP"		 value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_MM_ITEM_LOOKUP")%>">
		<input type="hidden"		name="p_language_id" id="p_language_id"			 value="<%=locale%>">
		<input type="hidden"		name="conv_fact" id="conv_fact"				 value="<%=conv_fact%>">
		<input type="hidden"		name="item_remarks" id="item_remarks"				 value="<%=item_remarks%>">
		<input type="hidden"		name="order_qty1" id="order_qty1"				 value="">
		<input type="hidden"		name="del_due_dt1" id="del_due_dt1"				 value="">
		<input type="hidden"		name="itemCode_reqNO" id="itemCode_reqNO"			 value="<%=itemCode_reqNO%>">
		<input type="hidden"		name="req_store" id="req_store"				 value="<%=req_store%>">
		<input type="hidden"		name="facility_id" id="facility_id"				 value="<%=facility_id%>">
		<input type="hidden"		name="po_no" id="po_no"				     value="<%=po_no%>">
		<input type="hidden"		name="po_srl_no" id="po_srl_no"				 value="<%=po_srl_no%>">
		<input type="hidden"		name="delv_srl_no" id="delv_srl_no"				 value="<%=delv_srl_no%>">
		<input type="hidden"		name="bal_budget" id="bal_budget"				 value="">
		<input type="hidden"		name="rejection_remarks" id="rejection_remarks"		 value="<%=rejection_remarks%>">
		<input type="hidden"		name="temp_delv_uom_desc" id="temp_delv_uom_desc"		 value="<%=quotation_uom_desc%>">
		<input type="hidden"		name="temp_delv_uom_code" id="temp_delv_uom_code"		 value="<%=quotation_uom_code%>">
		<input type="hidden"		name="delv_date" id="delv_date"		 		 value="<%=delvy_date%>">
		<input type="hidden"		name="order_qty" id="order_qty"		 		 value="<%=order_qty%>">
		<input type="hidden"		name="request_no" id="request_no"		 		 value="<%=request_no%>">
		
		
				
	</form>
	<%
		putObjectInBean(bean_id,bean,request);
	%>
</body>
</html>

