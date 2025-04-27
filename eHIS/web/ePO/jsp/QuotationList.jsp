<!DOCTYPE html>
<%@ page import="ePO.QuotationBean, ePO.QuotationDetailBean,java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=   (String)session.getAttribute("LOCALE");
		String sStyle			=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="javascript" src="../../ePO/js/Quotation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		String bean_id					=		"quotationBean";
		String bean_name				=		"ePO.QuotationBean";
		String checked					=		"";
		String disabled					=		"";
		String className				=		"";
		int srl_no = 0;
		Double net_amt=0.0	;
		java.util.ArrayList alItemKeys  =		new java.util.ArrayList();
		java.util.HashMap hmItemStore   =		null;
		String mode						=		request.getParameter("mode");
		String function_id				=		request.getParameter("function_id");
		String po_mode					=		request.getParameter("po_mode");
		String itemStoreKey				=		"";
		String rejection_remarks		=			"";
		String item_remarks		=			"";
		String bdUOM = "";
		String bdQty = "";
		String bdUOMDesc = "";
		QuotationBean bean			=		(QuotationBean) getBeanObject(bean_id,bean_name, request  );  
		bean.setLanguageId(locale);
		String supp_code				=		bean.checkForNull(request.getParameter("supp_code"));
		String currency_code			=		bean.checkForNull(request.getParameter("currency_code"));
		String local_currency			=		bean.checkForNull(request.getParameter("local_currency"));
		
		
		for(int i=0;i<bean.getItemKeys().size();i++) {
			alItemKeys.add(bean.getItemKeys().get(i));	
		} 
		System.out.println("bean.getItemKeys() = "+bean.getItemKeys());
		for(int i=0;i<bean.getReqKeys().size();i++) {
			if(!alItemKeys.contains(bean.getReqKeys().get(i)))
			alItemKeys.add(bean.getReqKeys().get(i));	
		}
		System.out.println("bean.getReqKeys() = "+bean.getReqKeys());
		java.util.ArrayList newKeys = bean.getItemKeysAdded();

		if (newKeys != null && newKeys.size() >0) {
			alItemKeys.addAll(newKeys);
		}
		System.out.println("bean.getItemKeysAdded() = "+bean.getItemKeysAdded());
		hmItemStore						=		bean.getHmItemDetail();
		int i							=		0;
		
		
		String supplier_code = "";
		String dflt_currency = "";
		
		if(bean.getRequest_on_supp() != "" && bean.getRequest_on_supp() != null ){
			supplier_code = bean.getRequest_on_supp(); 
		}else if(supp_code != "" && supp_code != null){
			 supplier_code = supp_code ; 
		}
		if(bean.getCurrency_code() != "" && bean.getCurrency_code() != null ){
			dflt_currency = bean.getCurrency_code() ; 	 
			System.out.println("dflt_currency in hdr before1= "+dflt_currency);
		}
		else if(currency_code != "" && currency_code != null){	 
			dflt_currency = currency_code ; 	 
			System.out.println("dflt_currency in hdr before= "+dflt_currency);
		}
		
	
		System.out.println("supplier_code in hdr = "+supplier_code);
		if(dflt_currency == "" && dflt_currency == null){
		HashMap hmRecord = bean.getCurrencyDesc(supplier_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
		}	
			System.out.println("dflt_currency in hdr = "+dflt_currency);
			
		String dflt_currency_desc =	bean.checkForNull((String)bean.fetchRecord("SELECT currency_code, short_desc FROM sy_foreign_currency_lang_vw WHERE language_id = ? and currency_code = ? ORDER BY 2",new String[]{locale,dflt_currency}).get("SHORT_DESC"),"");	
		
		String currency_desc_lc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  sy_foreign_currency_lang_vw where CURRENCY_CODE=? and language_id = ?",new String[]{local_currency,locale}).get("SHORT_DESC"),"");	
		
		System.out.println("mode in do list = "+mode);
							
	%>
<body onLoad="loadExRate();calculateNetAmt();onLoadCurrCode('<%=dflt_currency_desc%>','<%=currency_desc_lc%>');">
	<form name='formQuotationList' id='formQuotationList'>

		<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' > 
			<tr colspan=11>
				<th colspan=11 nowrap><fmt:message key="ePO.QuotationDetails.label" bundle="${po_labels}"/></th>
			</tr>
		</table>
		
		<br>
	<!--	<div style='overflow:scroll;height:410px;width=980px;position:relative;float:left;'>   -->
		<div id="quotList" style='overflow:auto;height:410px;width=980px;position:relative;float:left;'>
		<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' > 
		
 		
			
			<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)' >
				<td width='4%' class='COLUMNHEADER' nowrap>
				<fmt:message key="ePO.S.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>
				<fmt:message key="Common.defaultSelect.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>
				<fmt:message key="ePO.Item.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap></td>
				<td class='COLUMNHEADER' nowrap>
				<fmt:message key="ePO.QuotnQty.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>
				<fmt:message key="ePO.QuotnUOM.label" bundle="${po_labels}"/>
				</td>
				<td class='COLUMNHEADER' nowrap>
				<fmt:message key="ePO.UnitCost.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.GrossAmount.label" bundle="${po_labels}"/></td>			
				<td class='COLUMNHEADER'nowrap><fmt:message key="ePO.Discount.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.NetAmount.label" bundle="${po_labels}"/></td>
				
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.SelectionCriteria.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.EvaluationFactor.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.ItemStatus.label" bundle="${po_labels}"/></td>
				
			</tr>
	
			
			<%
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize			=		alItemKeys.size();
					for (i=0;	i<totalSize;	i++){
						itemStoreKey		=		(String) alItemKeys.get(i);
						
						QuotationDetailBean detailBean = (QuotationDetailBean) hmItemStore.get(itemStoreKey);

						System.out.println("detailBean in po list.jsp = "+detailBean);
						
						if (detailBean != null){
						
						//	if( (bean.checkForNull(detailBean.getCheck_box_status())).equals("Y") )
							  checked		=		"checked" ;
						//	else
						 //     checked		=		"" ;

                         
							  className		=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
						
								net_amt = net_amt + Double.parseDouble(bean.checkForNull(detailBean.getNet_amount(),"0"));
								srl_no = srl_no+1;
								
								
								String st_code = bean.checkForNull((String)detailBean.getStore_code());
								if(st_code.equals("*A") || st_code.equals(""))
									st_code = "ALL";
								else
									st_code = st_code;
									
									rejection_remarks = bean.checkForNull((String)detailBean.getRejection_remarks(),"");
									item_remarks = bean.checkForNull((String)detailBean.getItem_remarks(),"");
									String po_no = bean.checkForNull((String)detailBean.getPo_no());
									if(po_no.equals("*A"))
										po_no = "";
									String item_status = bean.checkForNull((String)detailBean.getItem_status());	
									String item_status_value = "";
									if(item_status.equals("SD")){
										item_status_value = "Selected";
									}else if(item_status.equals("RD")){
										item_status_value = "Rejected";
									}else if(item_status.equals("PD")){
										item_status_value = "Pending";
									}
		
						
			%>
			<tr id="tr_<%=i%>">
					
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right' title="<%=srl_no%>" value="<%=srl_no%>"><%=srl_no%></td>
				<td class="<%=className%>" nowrap align='center'><input type="checkbox" name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=itemStoreKey%>" <%=disabled%> <%=checked%> onClick="updateCheckStatus(this);"></td>
				<td id="a_<%=i%>" nowrap class="<%=className%>"  align='left' onClick="displayItemDetail(<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=detailBean.getItem_desc()%></font></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><input type='button' name='additional_dtls_<%=i%>' id='additional_dtls_<%=i%>' class='button' onclick= "MoreItemDetails1('<%=bean_id%>','<%=bean_name%>','<%=mode%>','<%=bean.checkForNull(detailBean.getItem_code())%>','<%=bean.checkForNull(detailBean.getItem_desc())%>','<%=bean.checkForNull(detailBean.getQuotation_qty())%>','<%=bean.checkForNull(detailBean.getQuotation_uom_desc())%>','<%=bean.checkForNull(detailBean.getQuotation_uom_code())%>')" value='>>' ></td> 
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getQuotation_qty(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getQuotation_uom_desc(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getQuotation_price(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getTot_value(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getDis_amt(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getNet_amount(),"&nbsp;")%></td>
				
				<td class="<%=className%>" nowrap align='center' onMouseOver="changeCursor(this);"   onClick = "SelectionCriteria1('<%=bean_id%>','<%=bean_name%>','<%=mode%>','<%=bean.checkForNull(detailBean.getItem_code())%>','<%=bean.checkForNull(detailBean.getItem_desc())%>','<%=bean.checkForNull(detailBean.getQuotation_qty())%>','<%=bean.checkForNull(detailBean.getQuotation_uom_desc())%>','<%=bean.checkForNull(detailBean.getQuotation_uom_code())%>');"><font class='HYPERLINK'><fmt:message key="ePO.SelectionCriteria.label" bundle="${po_labels}"/></font></td> 
				<td class="<%=className%>" nowrap align='center' onMouseOver="changeCursor(this);"   onClick = "EvaluationFactor1('<%=bean_id%>','<%=bean_name%>','<%=mode%>','<%=bean.checkForNull(detailBean.getItem_code())%>','<%=bean.checkForNull(detailBean.getItem_desc())%>','<%=bean.checkForNull(detailBean.getQuotation_qty())%>','<%=bean.checkForNull(detailBean.getQuotation_uom_desc())%>','<%=bean.checkForNull(detailBean.getQuotation_uom_code())%>');"><font class='HYPERLINK'><fmt:message key="ePO.EvaluationFactor.label" bundle="${po_labels}"/></font></td> 
								
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=item_status_value%></td>
			
											
				
				
			</tr>
				<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
				<input type="hidden" name="po_no_<%=i%>" id="po_no_<%=i%>" value="<%=bean.checkForNull(detailBean.getPo_no())%>">
				<input type="hidden" name="delv_date_<%=i%>" id="delv_date_<%=i%>" value="<%=bean.checkForNull(detailBean.getDelv_date())%>">
				<input type="hidden" name="delv_price_<%=i%>" id="delv_price_<%=i%>" value="<%=bean.checkForNull(detailBean.getQuotation_price())%>">
				<input type="hidden" name="request_no_<%=i%>" id="request_no_<%=i%>" value="<%=bean.checkForNull(detailBean.getRequest_no())%>">
			<%
						}
					}
				}
				
			%>
			
			<tr></tr>
		</table>
		</div>
		<br>
		<table name ="tblItemList" border='0' width='98%' cellpadding='0' cellspacing='0' >
			<tr>
				<th><fmt:message key="ePO.GrossQuotAmount.label" bundle="${po_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<label id='currency_label_5' class="label" >&nbsp;<B></B></label></th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='gross_poAmt_label' class="label" ><%=net_amt%></label>
				<input type=hidden name="gross_poAmt" id="gross_poAmt" value="<%=net_amt%>" onBlur="calculateNetAmt();"></th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePO.AdditionalDiscount.label" bundle="${po_labels}"/>&nbsp;&nbsp;<label id='currency_label_6' class="label" >&nbsp;<B></B></label></th>
				<% if(bean.checkForNull(bean.getAddi_dist()) == "") {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=NUMBER type="text" name="addi_dist" id="addi_dist" size="10" maxlength="10"  value="0" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();calculateNetAmt();" onBlur="calculateNetAmt();" >
				<% }else {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class=NUMBER name="addi_dist" id="addi_dist" size="10" maxlength="10"  value="<%=bean.checkForNull(bean.getAddi_dist())%>" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();calculateNetAmt();" onBlur="calculateNetAmt();" >
				<%}%>
				</th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePO.NetQuotAmount.label" bundle="${po_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='currency_label_7' class="label" >&nbsp;<B></B></label></th>
				<% if(bean.checkForNull(bean.getNet_poAmt()) == "") {%>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label' class="label" >&nbsp;<%=net_amt%></label>
				<input type="hidden" name="net_poAmt" id="net_poAmt"	value="<%=net_amt%>">
				<% }else {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label' class="label" >&nbsp;<%=bean.checkForNull(bean.getNet_poAmt())%></label>
					<input type="hidden" name="net_poAmt" id="net_poAmt"	value="<%=bean.checkForNull(bean.getNet_poAmt())%>">
				<%}%>
					
				</th>
			</tr>
			<span>
			<tr id="netDoAmtHidden" style=visibility:hidden>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePO.NetQuotAmount.label" bundle="${po_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='currency_label_8' class="label" >&nbsp;<B></B></label></th>
				<% if(bean.checkForNull(bean.getNet_poAmt()) == "") {%>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label_lc' class="label" >&nbsp;<%=net_amt%></label>
				<input type="hidden" name="net_poAmt_lc" id="net_poAmt_lc"	value="<%=net_amt%>">
				<% }else {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label_lc' class="label" >&nbsp;<%=bean.checkForNull(bean.getNet_poAmt())%></label>
					<input type="hidden" name="net_poAmt_lc" id="net_poAmt_lc"	value="<%=bean.checkForNull(bean.getNet_poAmt())%>">
				<%}%>
					
				</th>
			</tr>			
			</span>
			
		</table>
		<br>
		
			
			<input type="hidden" 	name="total_checkboxes" id="total_checkboxes"				value="<%=i%>">
			<input type="hidden" 	name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden" 	name="mode" id="mode"							value="<%=mode%>">
			<input type="hidden" 	name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" 	name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" 	name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden" 	name="quotation_type" id="quotation_type"				value="">
			<input type="hidden" 	name="po_mode" id="po_mode"						value="">
			<input type="hidden" 	name="doc_no" id="doc_no"						value="">
			<input type="hidden" 	name="doc_date" id="doc_date"						value="">
			<input type="hidden" 	name="doc_ref" id="doc_ref"						value="">
			<input type="hidden" 	name="request_by_pu" id="request_by_pu"				value="">
			<input type="hidden" 	name="request_on_supp" id="request_on_supp"				value="">
			<input type="hidden" 	name="item_class_code" id="item_class_code"				value="">
			<input type="hidden" 	name="finalize_yn" id="finalize_yn"					value="">
			<input type="hidden" 	name="autono_yn" id="autono_yn"					value="">   
			<input type="hidden" 	name="currency_code" id="currency_code"				value="">
			<input type="hidden" 	name="exc_rate" id="exc_rate"						value="">
			<input type="hidden" 	name="local_currency" id="local_currency"				value="">
			<input type="hidden" 	name="blanket_po_yn" id="blanket_po_yn"				value="">
			<input type="hidden" 	name="valid_upto" id="valid_upto"					value="">
			<input type="hidden" 	name="exp_date" id="exp_date"						value="">
			<input type='hidden' 	name="order_remarks" id="order_remarks"				value="">
			<input type='hidden' 	name="item_remarks" id="item_remarks"					value="">
			<input type='hidden' 	name="rejection_remarks" id="rejection_remarks"			value="">
			<input type='hidden' 	name="doc_remarks" id="doc_remarks"					value="">
			
			
			
			
						
		</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

</html>



