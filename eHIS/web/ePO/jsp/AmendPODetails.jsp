<!DOCTYPE html>
<%@ page import=" ePO.AmendPurchaseOrderDetailBean,ePO.AmendPurchaseOrderBean, ePO.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
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
		<script language="JavaScript" src="../../ePO/js/AmendPurchaseOrder.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		 </script>
</head>
<%
	boolean editMode					=			 false;
	AmendPurchaseOrderDetailBean requestDetail;
	String mode							=			 request.getParameter("mode");
	String edit							=			 request.getParameter("edit")==null?"1":request.getParameter("edit");
	String disabled						=			 "";
	String item_disabled				=			 "";
	String item_desc					=			 "";
	String uom							=			 "";
	String required_qty					=			 "";
	String req_uom_qty					=			 "";
	String	pur_uom_code				=			 "";
	String	conv_fact					=			 "";
	String	qty_on_hand					=			 "";
	String	max_stk_qty					=			 "";
	String 	id_pur_uom_conv1			=			"";
	String order_qty 					= 			"";
	String unit_price 					= 			"";
	String list_price					=			"";
	String tot_value					=			"";
	String dis_type						=			"";
	String dis_amt						=			"";
	String net_amount					=			"";
	String commit_code					=			"";
	String commit_desc					=			"";
	String dept_no						=			"";
	String acc_no						=			"";
	String acc_desc						=			"";
	String app_ref						=			"";
	String ref_value					=			"";
	String item_remarks 				= 			"";
	String disPerSelected 				=			"";
	String disAmtSelected 				=			"";
	String appRefChecked 				= 			"";
	String appRefDisabled 				= 			"";
	String DevlHidden					=			"";
	String DevlHide						=			"";
	String perHidden					=			"";
	String i_disabled 					= 			"";
	int srl_no							=			-1;
	int req_srl_no 						= 			0;
	String  item_code_dis				=			"";
	String eff_from_dt 					=			"";
	String budget_check_mandatory		=			"hidden";
	mode								=			mode.trim();
	
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	String bean_id						=			 "amendPurchaseOrderBean";
	String bean_name					=			 "ePO.AmendPurchaseOrderBean";
	String caption						=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String disable_add					=			"";
	String available_stock				=			"";
	String	uom_code					=			"";
	String itemCode_reqNO = "";
	String req_store = "";
	String facility_id = "";
	String del_date						=			request.getParameter("del_date");
	String to_supplier					=			request.getParameter("to_supplier");
	String currency_code				=			request.getParameter("currency_code");
	

	AmendPurchaseOrderBean bean			=			(AmendPurchaseOrderBean) getBeanObject(bean_id, bean_name,request );  
	bean.setLanguageId(locale);
	
	int no_of_decimals					=			bean.getNoOfDecimals();
	String item_code					=			 request.getParameter("item_code");
	String req_no						=			request.getParameter("req_no")==null?"":request.getParameter("req_no");
	if (item_code != null) {
	
	for(int i=0;i<bean.getItemKeysAdded().size();i++){
		String i_code = (String)bean.getItemKeysAdded().get(i);

		if(i_code.equals(item_code)){
			item_disabled = "";
			i_disabled = "disabled";
			break;
		}else{
			item_disabled	=			"disabled";
		}	
	}
	
	if(bean.getItemKeysAdded().size() == 0 )
		item_disabled					=			"disabled";
		
		
		caption							=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		editMode						=			true;
	//	item_disabled					=			"disabled";
		if(edit.equals("2"))
			disabled					=			"disabled";
		
		if(req_no == null){
			itemCode_reqNO = item_code;
		}else{
			itemCode_reqNO = item_code +""+req_no;
		}
		
		requestDetail					=			bean.getItemDetail(itemCode_reqNO);
		item_code						=			bean.checkForNull(requestDetail.getItem_code());
		item_desc						=			requestDetail.getItem_desc();
		order_qty						=			requestDetail.getOrder_qty();	
		uom								=			bean.checkForNull(requestDetail.getUomDesc());
		uom_code						=			bean.checkForNull(requestDetail.getUom());
		srl_no							=			requestDetail.getSrl_no();
		req_srl_no						=			requestDetail.getReq_srl_no();
		list_price 						= 			bean.checkForNull(requestDetail.getUnit_price());
		unit_price 						= 			bean.checkForNull(requestDetail.getPur_price());
		tot_value 						= 			bean.checkForNull(requestDetail.getTot_value());
		dis_type 						=			bean.checkForNull(requestDetail.getDis_type());
		dis_amt 						=			bean.checkForNull(requestDetail.getDis_amt());
		net_amount 						= 			bean.checkForNull(requestDetail.getNet_amount());
		commit_code 					= 			bean.checkForNull(requestDetail.getCommit_code());
		commit_desc						= 			bean.checkForNull(requestDetail.getCommt_Desc());	
		dept_no 						= 			bean.checkForNull(requestDetail.getDept_no());
		acc_no 							= 			bean.checkForNull(requestDetail.getAcc_no());
		acc_desc 						= 			bean.checkForNull(requestDetail.getAcc_desc());
		app_ref 						= 			bean.checkForNull(requestDetail.getApp_ref());
		ref_value 						= 			bean.checkForNull(requestDetail.getRef_value());
		item_remarks 					= 			bean.checkForNull(requestDetail.getItem_remarks());
		req_store 						= 			bean.checkForNull(requestDetail.getStore_code());
		facility_id 					= 			bean.checkForNull(requestDetail.getFacility_code());
		del_date 						= 			bean.checkForNull(requestDetail.getDel_date());
		eff_from_dt 					= 			bean.checkForNull(requestDetail.getEff_from_dt());
		required_qty					=			bean.checkForNull(requestDetail.getRequired_qty())	;
		available_stock					=			bean.checkForNull(requestDetail.getAvailable_stock());
		req_uom_qty						=			bean.checkForNull(requestDetail.getReqUomQty());
		pur_uom_code					=			bean.checkForNull(requestDetail.getPurUomCode());
		conv_fact						=			bean.checkForNull(requestDetail.getConvFact());
		qty_on_hand						=			bean.checkForNull(requestDetail.getQty_on_hand());
		max_stk_qty						=			bean.checkForNull(requestDetail.getMax_stk_qty());
		id_pur_uom_conv1				=			bean.checkForNull(requestDetail.getPur_uom_conv_id());
	if(conv_fact.equals(id_pur_uom_conv1))
		id_pur_uom_conv1=conv_fact;
	}
	else {
		item_code						=			"";
		disable_add						=			 "disabled";
		appRefDisabled = "disabled";
	}
	
	if(dis_type.equals("P")){
		 disPerSelected = "selected";
		 perHidden = "visible";
	}else if(dis_type.equals("A")){
		 disAmtSelected = "selected";
		 perHidden = "hidden";
	}
	
	if(app_ref.equals("Y")){
		 appRefChecked = "checked";
		 appRefDisabled = "";
	}else{
		appRefChecked = "";
		appRefDisabled = "disabled";
	}
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
	item_code_dis= "disabled";
	else
	item_code_dis= "";
	
	if(bean.getBlanket_po_yn().equals("Y")){

			DevlHidden = "visible";
			DevlHide = "hidden";
		
	} else {

			DevlHidden = "hidden";
			DevlHide = "visible";
		
	}

		String dept_desc =		bean.checkForNull((String)bean.fetchRecord("SELECT ad.DEPT_CODE,ad.SHORT_DESC FROM PO_COMMTTMENT_ACCOUNT ca,  AM_DEPT_LANG_VW ad WHERE ad.LANGUAGE_ID=? AND ca.DEPT_CODE = ad.DEPT_CODE AND ca.MASTER_CODE=? AND ca.DEPT_CODE = ?",new String[]{bean.getLanguageId(),(String) commit_code , (String) dept_no }).get("SHORT_DESC"),"");	
		
		dept_desc = dept_desc+"-"+eff_from_dt;
		
		
		String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
		String postdate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,7,"d");

		String supp_code = "";
		String dflt_currency = "";
		if(bean.getRequest_on_supp() != "" && bean.getRequest_on_supp() != null ){
			 supp_code = bean.getRequest_on_supp(); 
		}else if(currency_code != "" && currency_code != null){	 
			dflt_currency = currency_code ; 	 
		}else if(to_supplier != "" && to_supplier != null){
			 supp_code = to_supplier ; 
		}
		
		HashMap hmRecord = bean.getCurrencyDesc(supp_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
	
		String budget_check_yn =		bean.checkForNull((String)bean.fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
		if(budget_check_yn.equals("Y")) { 
			budget_check_mandatory = "visible";
		}
%>
<body onLoad=" FocusFirstElement(); onLoadCurrCode('<%=dflt_currency%>');calculateDisAmount();loadDeptId1('<%=commit_code%>','<%=dept_desc%>');">
	<form name="formAmendPODetail" id="formAmendPODetail">
	<table border="0" cellspacing="0" cellpadding="0" width="100%" >
	<tr>
	<th colspan=2><fmt:message key="ePO.EnterItemDetails.label" bundle="${po_labels}"/></th>
	</tr>
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	  <tr>
	  	<td class="label" colspan=2>
		<fmt:message key="Common.item.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;
		
		<%if(i_disabled.equals("disabled")){%>
		<input type="text" name="item_desc" id="item_desc" size="30" maxlength="30"  value="<%=item_desc%>" <%=i_disabled%>>
		
		<input type="button" value="?" class="button" onClick="return searchCodeItem(item_desc);" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>&nbsp;&nbsp;
		<%}else{%>
		<input type="text" name="item_desc" id="item_desc" size="30" maxlength="30"  value="<%=item_desc%>" <%=item_disabled%><%=i_disabled%>>
		
		<input type="button" value="?" class="button" onClick="return searchCodeItem(item_desc);" <%=item_disabled%> >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>&nbsp;&nbsp;
		
		<%}%>
		
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class="label" >
		<fmt:message key="ePO.OrderQty.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<input type="text" name="order_qty" id="order_qty" class=NUMBER size="10" maxlength="8"  value="<%=order_qty%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);calculateValue();calculateDiscount();" >
		<%=bean.getImage("M")%>
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class="label" >
		<fmt:message key="ePO.OrderUOM.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<select name='uom' id='uom' onchange="getUOMDesc(this);" onBlur="getUOMDesc(this); checkUOMConvFactor();"  ><%//bean.getUom_code(uom_code) Modified by suresh.r on 19-12-2014 against ML-BRU-SCF-1457%> <%=bean.getPur_uom_code_List(uom_code,item_code) %></select>
		<%=bean.getImage("M")%>
		</td>
		
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class="label" >
		<fmt:message key="ePO.ListPrice.label" bundle="${po_labels}"/></td>
		<% if(list_price == "") {%>
			<td class="field" > <input type="text" class=NUMBER name="unit_price" id="unit_price" size="12" maxlength="12"  value="0" onKeyPress="return isValidNumber(this,event,7,3);isValidInteger();" onBlur="calculateValue();calculateDiscount();calculatePrice();" >
		<% } else { %>
			<td class="field" >	<input type="text" class=NUMBER name="unit_price" id="unit_price" size="12" maxlength="12"  value="<%=list_price%>" onKeyPress="return isValidNumber(this,event,7,3);isValidInteger();" onBlur="calculateValue();calculateDiscount();calculatePrice();" >
		<% } %>
		
		<label id='currency_label_1' class="label" >&nbsp;<B></B></label>
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class="label" >
		<fmt:message key="ePO.GrossAmount.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<input type="text" class=NUMBER name="tot_value" id="tot_value" size="15" maxlength="15"  value="<%=tot_value%>" onKeyPress="isValidNumber(this,event,10,3);isValidInteger();" onBlur="calculateDiscount();calculateDiscount();" >
		<label id='currency_label_2' class="label" >&nbsp;<B></B></label>
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class=label align=right>
		<fmt:message key="ePO.DiscountType.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<select name="dis_type" id="dis_type" onchange="calculateDiscount();perChange(this);" >
		<option value="P" <%=disPerSelected%>>Percentage</option>
		<option value="A" <%=disAmtSelected%>>Amount</option>
		</select>
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class=label align=right>
		<fmt:message key="ePO.Discount.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<% if(dis_amt == "") {%>
			<input type="text" class=NUMBER name="dis_value" id="dis_value" size="10" maxlength="10"  value="0" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();calculatePrice();" >
			<span id="perHidden" style=visibility:visible>
				<input type="text" class=NUMBER name="dis_amt" id="dis_amt" size="10" maxlength="10"  value="0" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();" disabled>
			</span>
		<% } else { %>
			<input type="text" class=NUMBER name="dis_value" id="dis_value" size="10" maxlength="10"  value="" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();calculatePrice();" > 
			<span id="perHidden" style=visibility:<%=perHidden%>>
				<input type="text" class=NUMBER name="dis_amt" id="dis_amt" size="10" maxlength="10"  value="<%=dis_amt%>" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();" onBlur="calculateDiscount();calculateDisAmount()" disabled>
			</span>	
		<% } %>
		<label id='currency_label_3' class="label" >&nbsp;<B></B></label>
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class=label align=right>
		<fmt:message key="ePO.NetAmount.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<input type="text"  class=NUMBER name="net_amount" id="net_amount" size="15" maxlength="15"  value="<%=net_amount%>"  onKeyPress="return isValidNumber(this,event,10,3);isValidInteger();" onBlur="" >
		<label id='currency_label_4' class="label" >&nbsp;<B></B></label>
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td class="label" >	<fmt:message key="ePO.PurchasePrice.label" bundle="${st_labels}"/></td>
				<td class="field" > <input type="text" class=NUMBER name="pur_price" id="pur_price" size="12" maxlength="12"  value="<%=unit_price%>" onKeyPress="return isValidNumber(this,event,7,3);isValidInteger();" onBlur="calculatePrice();" >
				<label id='currency_label_8' class="label" >&nbsp;<B></B></label>
				</td>
			</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<td class=label align=right><fmt:message key="ePO.CommitmentCode.label" bundle="${po_labels}"/></td>
			<td class="field" >	<select name="commit_code" id="commit_code" onchange="loadDeptId(this);getCOMMNTDesc(this);" onBlur="getCOMMNTDesc(this);" >
			<%=bean.getComm_code(commit_code)%></select><span style='visibility:<%=budget_check_mandatory%>'><%=bean.getImage("M")%></span>	</td>
		</tr>
		
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<td class=label align=right><fmt:message key="ePO.DeptId/Acc.label" bundle="${po_labels}"/></td>
			<td class="field" >	<select name="dept_id" id="dept_id" onchange="loadAccNo(this);" >
			<% if(dept_no != "" && dept_no != null) {%>
				<option value="<%=dept_no%>"><%=dept_desc%></option>
			<% } else { %>	
				<option value="">---Select---</option>
			<% } %>	
			</select> <span style='visibility:<%=budget_check_mandatory%>'><%=bean.getImage("M")%></span></td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<td class=label align=right><fmt:message key="ePO.AcctNumber.label" bundle="${po_labels}"/></td>
			<td class="field" >	<select name="acc_no" id="acc_no" onchange='loadAccDesc(this);' >
			<% if(acc_no != "" && acc_no != null) {%>
				<option value="<%=acc_no%>"><%=acc_no%></option>
			<% } else { %>	
				<option value="">---Select---</option>
			<% } %>
			</select> <span style='visibility:<%=budget_check_mandatory%>'><%=bean.getImage("M")%></span></td>
		
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class=label align=right>
		<fmt:message key="ePO.AccNoDesc.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<label id='acc_desc_label'  class="label"><%=acc_desc%></label><input type="hidden" name="acc_desc" id="acc_desc" value="<%=acc_desc%>">
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		
		<tr>
				<td class=label align=right> 
					<span id="DelvSchHidden" style=visibility:<%=DevlHidden%>>
						<a href="javascript:DeliverySchedule('<%=bean_id%>','<%=bean_name%>','<%=mode%>')">Delivery Schedule</a>
					</span>
					<span id="DelvSchHide" style=visibility:<%=DevlHide%>>
						Delivery Schedule
					</span>				
				</td>
			
			<td class="fields">
			
				<% if(bean.checkForNull(del_date) != "" && bean.checkForNull(del_date) != null){ %>
					<input type="text" value="<%=bean.checkForNull(del_date)%>" name="del_date"  maxLength="10" size="10"  onBlur="CheckDate(this);" >&nbsp;
				<% } else  if(bean.checkForNull(bean.getExp_date()) != "" && bean.checkForNull(bean.getExp_date()) != null){ %>	
					<input type="text" value="<%=bean.checkForNull(bean.getExp_date())%>" name="del_date"  maxLength="10" size="10"  onBlur="CheckDate(this);" <%=item_disabled%> >&nbsp;
				<% } else { %>		
					<input type="text" value="<%=postdate%>" name="del_date"  maxLength="10" size="10"  onBlur="CheckDate(this);" >&nbsp;
					
				<% } %>	
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('del_date');"  ></img><%=bean.getImage("M")%>	
				</td>
		</tr>
		
		
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		<td class=label align=right>
		<fmt:message key="ePO.ApprovalReference.label" bundle="${po_labels}"/></td>
		<td class="field" >
		<input type="checkbox" value="Y" name="app_ref" id="app_ref" onclick="checkAppvlRef(this)" <%=appRefChecked%>>
		<input type="text" name="ref_value" id="ref_value" size="10" maxlength="10"  value="<%=ref_value%>" <%=appRefDisabled%> >
		<span id="manditHidden" style=visibility:hidden>
		<%=bean.getImage("M")%>		
		</span>	
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
	
		<td class="label" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "ItemRemarks(item_remarks.value,'');"><font class='HYPERLINK'><fmt:message key="ePO.ItemRmks.label" bundle="${po_labels}"/></font></label>
		</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
		
		<td colspan=2 align=right>
		<input type="button" class="button" name="add" id="add" value="<%=caption%>" <%=disable_add%> onClick="addItemRecord();" >&nbsp;
		<input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="resetDetail();"></td>
	
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
		<input type="hidden"		name="temp_uom" id="temp_uom"					 value="<%=uom%>">
		<input type="hidden"		name="temp_uom_code" id="temp_uom_code"			 value="<%=uom_code%>">
		<input type="hidden"		name="temp_commt" id="temp_commt"				 value="<%=commit_desc%>">
		
		<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">
		
		<input type="hidden" 		name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" 		name="p_language_id" id="p_language_id"			value="<%=locale%>">
		<input type="hidden"		name="conv_fact" id="conv_fact"				 value="<%=conv_fact%>">
		<input type="hidden"		name="item_remarks" id="item_remarks"				 value="<%=item_remarks%>">
		<input type="hidden"		name="order_qty1" id="order_qty1"				 value="">
		<input type="hidden"		name="del_due_dt1" id="del_due_dt1"				 value="">
		<input type="hidden"		name="itemCode_reqNO" id="itemCode_reqNO"			 value="<%=itemCode_reqNO%>">
		<input type="hidden"		name="req_store" id="req_store"				 value="<%=req_store%>">
		<input type="hidden"		name="facility_id" id="facility_id"				 value="<%=facility_id%>">
		<input type="hidden"		name="req_no" id="req_no"				     value="<%=req_no%>">
		<input type="hidden"		name="req_srl_no" id="req_srl_no"				 value="<%=req_srl_no%>">
		<input type="hidden"		name="budget_check_yn" id="budget_check_yn"			 value="<%=budget_check_yn%>">
		<input type="hidden"		name="dept_desc" id="dept_desc"				 value="<%=dept_desc%>">
		<input type="hidden"		name="bal_budget" id="bal_budget"				 value="">
		<input type="hidden"		name="eff_from" id="eff_from"				 value="">
	</form>
	<%
putObjectInBean(bean_id,bean,request);
	%>
</body>
</html>

