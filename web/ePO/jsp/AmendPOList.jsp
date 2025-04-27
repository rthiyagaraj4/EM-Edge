<!DOCTYPE html>
<%@ page import="ePO.AmendPurchaseOrderBean, ePO.AmendPurchaseOrderDetailBean,java.sql.*,java.util.*,webbeans.eCommon.*,java.io.UnsupportedEncodingException,
java.net.URLEncoder" contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../ePO/js/AmendPurchaseOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		String bean_id					=		"amendPurchaseOrderBean";
		String bean_name				=		"ePO.AmendPurchaseOrderBean";
		String checked					=		"";
		//String disabled					=		"";
		String className				=		"";
		String item_disabled = "";
		int srl_no = 0;
		//int net_amt=0	;
		Double net_amt=0.0	;
		String item_remarks = "";
		java.util.ArrayList alItemKeys  =		new java.util.ArrayList();
		java.util.HashMap hmItemStore   =		null;
		String mode						=		request.getParameter("mode");
		String function_id				=		request.getParameter("function_id");
		
		//String kit12					=		(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
		String itemStoreKey				=		"";

		AmendPurchaseOrderBean bean				=		(AmendPurchaseOrderBean) getBeanObject(bean_id,bean_name, request  );  
		bean.setLanguageId(locale);
		String supp_code				=		bean.checkForNull(request.getParameter("supp_code"));
		String currency_code			=		bean.checkForNull(request.getParameter("currency_code"));
		
		System.out.println("bean.getItemKeys() in po list = "+bean.getItemKeys());
		System.out.println("bean.getItemKeysAdded() in po list = "+bean.getItemKeysAdded());

		for(int i=0;i<bean.getItemKeys().size();i++) {
			alItemKeys.add(bean.getItemKeys().get(i));	
		} 
		for(int i=0;i<bean.getReqKeys().size();i++) {
			if(!alItemKeys.contains(bean.getReqKeys().get(i)))
			alItemKeys.add(bean.getReqKeys().get(i));	
		}
		java.util.ArrayList newKeys = bean.getItemKeysAdded();

		if (newKeys != null && newKeys.size() >0) {
			alItemKeys.addAll(newKeys);
		}

		hmItemStore						=		bean.getHmItemDetail();
		System.out.println("hmItemStore in po list.jsp = "+hmItemStore);
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
							
	%>
<body onLoad="calculateNetAmt();onLoadCurrCode('<%=dflt_currency%>');" >	
		<form name='formAmendPOList' id='formAmendPOList'>
		
			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' > 
			<tr colspan=11>
				<th colspan=11 nowrap><fmt:message key="ePO.PurchaseOrderDetails.label" bundle="${po_labels}"/></th>
			</tr>
			</table>
			<br>
		<!--	<div style='overflow:scroll;height:410px;width=980px;position:relative;float:left;'> -->
			<div id="amendList" style='overflow:auto;height:410px;width=980px;position:relative;float:left;'>
			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' > 
			
 			<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)' >
				<td width='4%' class='COLUMNHEADER'>
				<fmt:message key="ePO.S.label" bundle="${po_labels}"/></td>
				<td width='3%' class='COLUMNHEADER' >
				<fmt:message key="Common.defaultSelect.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER'>
				<fmt:message key="ePO.Item.label" bundle="${po_labels}"/></td>
				<% if(bean.checkForNull(bean.getPo_mode()).equals("R") ) {%>
				<td class='COLUMNHEADER'>
				<fmt:message key="ePO.RequestNo.label" bundle="${po_labels}"/></td>
				<% } %>
				
				<td class='COLUMNHEADER'><fmt:message key="Common.uom.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER'>
				<fmt:message key="ePO.POQty.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' >
				<fmt:message key="ePO.UnitPrice.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER'  ><fmt:message key="ePO.GrossAmount.label" bundle="${po_labels}"/></td>

				<td class='COLUMNHEADER'><fmt:message key="ePO.Discount.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER'  ><fmt:message key="ePO.NetAmount.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="ePO.CommitmentCode.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="ePO.Approval.label" bundle="${po_labels}"/></td>
				<% if(bean.checkForNull(bean.getPo_mode()).equals("R") ) {%>
				<td class='COLUMNHEADER'  >Str Dtls</td>
				<% } %>
				<td class='COLUMNHEADER' nowrap>
				<fmt:message key="ePO.ItemRmks.label" bundle="${po_labels}"/></td>
			</tr>
			<%
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize			=		alItemKeys.size();
					for (i=0;	i<totalSize;	i++){
						itemStoreKey		=		(String) alItemKeys.get(i);
						
						AmendPurchaseOrderDetailBean detailBean = (AmendPurchaseOrderDetailBean) hmItemStore.get(itemStoreKey);

						System.out.println("detailBean in po list.jsp = "+detailBean);
						
						if (detailBean != null){
						
						 if( (bean.checkForNull(detailBean.getCheck_box_status())).equals("Y") )
							  checked		=		"checked" ;
						  else
						      checked		=		"" ;

                         
							  className		=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
						
							//net_amt = net_amt + Integer.parseInt(bean.checkForNull(detailBean.getNet_amount(),"0"));
							net_amt = net_amt + Double.parseDouble(bean.checkForNull(detailBean.getNet_amount(),"0"));
							srl_no = srl_no+1;
							
													
						for(int j=0;j<bean.getItemKeysAdded().size();j++){
								String j_code = (String)bean.getItemKeysAdded().get(j);
								
								System.out.println("j_code = "+j_code);
								if(j_code.equals(detailBean.getItem_code())){
									item_disabled = "";
									break;
								}else{
									item_disabled	=			"disabled";
								}	
							}
							
		
							if(bean.getItemKeysAdded().size() == 0 )
								item_disabled					=			"disabled";	
							item_remarks = bean.checkForNull((String)detailBean.getItem_remarks(),"");
							item_remarks = URLEncoder.encode(item_remarks, "UTF-8").replaceAll("\\+", "%20") ;
				%>
				
				<tr id="tr_<%=i%>"> 
					 
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" nowrap align='right' title="<%=srl_no%>" value="<%=srl_no%>"><%=srl_no%></td>
					<td class="<%=className%>" nowrap align='center'><input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=itemStoreKey%>"  <%=checked%> onClick="updateCheckStatus(this);"></td>
					<td id="a_<%=i%>" class="<%=className%>"  align='left' onClick="displayItemDetail(<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=detailBean.getItem_desc()%></font></td>
					<% if(bean.checkForNull(bean.getPo_mode()).equals("R")) {%>
						<td class="<%=className%>" nowrap align='left'><%=bean.checkForNull(detailBean.getReq_no(),"&nbsp;")%></td>
					<% } %>
					<td class="<%=className%>" nowrap align='left'><%=bean.checkForNull(detailBean.getUomDesc(),"&nbsp;")%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='right'><%=detailBean.getOrder_qty()%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getUnit_price(),"&nbsp;")%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getTot_value(),"&nbsp;")%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getDis_amt(),"&nbsp;")%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getNet_amount(),"&nbsp;")%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='center'><%=bean.checkForNull(detailBean.getCommt_Desc(),"&nbsp;")%></td>
					<input type="hidden" name="commit_code_<%=i%>" id="commit_code_<%=i%>" value="<%=bean.checkForNull(detailBean.getCommt_Desc(),"")%>">
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" 
					<%
					out.println(" align=\'center\'>");
					if(detailBean.getApp_ref().equals("Y")){
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					}else {
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
					}
					
					%>
					</td>	
					<% if(bean.checkForNull(bean.getPo_mode()).equals("R")) {%>
					<td class="<%=className%>" nowrap align='left'>
						<a href="javascript:StoreDetails('<%=bean_id%>','<%=bean_name%>','<%=mode%>','<%=bean.checkForNull(detailBean.getReq_no())%>')">Str Dtls</a>
					</td>	
				<% } %>	
					<td class="<%=className%>" nowrap align='center' onClick = "ItemRemarks1('<%=item_remarks%>','disabled')" onMouseOver="changeCursor(this);"><font class='HYPERLINK'><fmt:message key="ePO.ItemRmks.label" bundle="${po_labels}"/></font></td>						
				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
					<input type="hidden" name="req_no_<%=i%>" id="req_no_<%=i%>" value="<%=bean.checkForNull(detailBean.getReq_no())%>">
				<%
				}
				}
				
			}
				
			%>
			
			<tr>
			
			</tr>
			</table>
			</div>
			<br>
			<table name ="tblItemList" border='0' width='98%' cellpadding='0' cellspacing='0' >
			<tr>
				<th>Gross PO Amount&nbsp;&nbsp;&nbsp;&nbsp;<label id='currency_label_5' class="label" >&nbsp;<B></B></label></th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='gross_poAmt_label' class="label" ><%=net_amt%></label>
				<input type=hidden name="gross_poAmt" id="gross_poAmt" value="<%=net_amt%>" onBlur="calculateNetAmt();"></th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Additional Discount&nbsp;&nbsp;<label id='currency_label_6' class="label" >&nbsp;<B></B></label></th>
				<% if(bean.checkForNull(bean.getAddi_dist()) == "") {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=NUMBER type="text" name="addi_dist" id="addi_dist" size="10" maxlength="10"  value="0" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();calculateNetAmt();" onBlur="calculateNetAmt();" >
				<% }else {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class=NUMBER name="addi_dist" id="addi_dist" size="10" maxlength="10"  value="<%=bean.checkForNull(bean.getAddi_dist())%>" onKeyPress="return isValidNumber(this,event,5,3);return isValidInteger();calculateNetAmt();" onBlur="calculateNetAmt();" >
				<%}%>
				</th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Net PO Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='currency_label_7' class="label" >&nbsp;<B></B></label></th>
				<% if(bean.checkForNull(bean.getNet_poAmt()) == "") {%>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label' class="label" >&nbsp;<%=net_amt%></label>
				<% }else {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label' class="label" >&nbsp;<%=bean.checkForNull(bean.getNet_poAmt())%></label>
				<%}%>
					<input type="hidden" name="net_poAmt" id="net_poAmt"	value="<%=bean.checkForNull(bean.getNet_poAmt())%>">
				</th>
			</tr>
			
		</table>
			
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"			value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden" name="purchase_type" id="purchase_type"				value="">
			<input type="hidden" name="po_mode" id="po_mode"				value="">
			<input type="hidden" name="doc_no" id="doc_no"						value="">
			<input type="hidden" name="doc_date" id="doc_date"					value="">
			<input type="hidden" name="doc_ref" id="doc_ref"						value="">
			<input type="hidden" name="request_by_pu" id="request_by_pu"			value="">
			<input type="hidden" name="request_on_supp" id="request_on_supp"			value="">
			<input type="hidden" name="item_class_code" id="item_class_code"				value="">
			<input type="hidden" name="finalize_yn" id="finalize_yn"					value="">
			<input type="hidden" name="autono_yn" id="autono_yn"					value="">
			<input type="hidden" name="request_type" id="request_type"				value="">
			<input type="hidden" name="currency_code" id="currency_code"				value="">
			<input type="hidden" name="exc_rate" id="exc_rate"				value="">
			<input type="hidden" name="local_currency" id="local_currency"				value="">
			<input type="hidden" name="blanket_po_yn" id="blanket_po_yn"				value="">
			<input type="hidden" name="valid_upto" id="valid_upto"				value="">
			<input type="hidden" name="exp_date" id="exp_date"					value="">
			<input type='hidden' name="order_remarks" id="order_remarks"		value="">
			<input type='hidden' name="item_remarks" id="item_remarks"		value="">
			<input type='hidden' name="old_po_no" id="old_po_no"		value="">
			
			<input type='hidden' 	name="com_code" id="com_code"					value="">
			<input type='hidden' 	name="com_desc" id="com_desc"					value="">
			<input type='hidden' 	name="dt_code" id="dt_code"					value="">
			<input type='hidden' 	name="dept_desc" id="dept_desc"					value="">
			<input type='hidden' 	name="balance_amt" id="balance_amt"					value="">
			<input type='hidden' 	name="override_amt" id="override_amt"					value="">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>

</html>



