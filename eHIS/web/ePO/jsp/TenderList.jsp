<!DOCTYPE html>
<%@ page import="ePO.TenderBean, ePO.TenderDetailBean,java.sql.*,java.util.*,webbeans.eCommon.*,,java.io.UnsupportedEncodingException,
java.net.URLEncoder,java.text.*" contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../ePO/js/Tender.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		String bean_id					=		"tenderBean";
		String bean_name				=		"ePO.TenderBean";
		String checked					=		"";
		String disabled					=		"";
		String className				=		"";
		int srl_no 						= 		0;
		double net_amt					=		0.0	;
		Double Dnet_amt_conv 			= 		0.0;//41603 by Ganga
		double dnet_amt_conv 			= 		0.0;//41603 by Ganga
		ArrayList alItemKeys  			=		new ArrayList();
		HashMap hmItemStore   			=		null;
		String mode						=		request.getParameter("mode");
		String function_id				=		request.getParameter("function_id");
		String po_mode					=		request.getParameter("po_mode");
		String itemStoreKey				=		"";
		String rejection_remarks		=		"";
		String item_remarks				=		"";
		String bdUOM 					= 		"";
		String bdQty 					= 		"";
		String bdUOMDesc 				= 		"";
		DecimalFormat formatter 		= 		new DecimalFormat("##0.0######");//41603 by Ganga			
		
		TenderBean bean			=		(TenderBean) getBeanObject(bean_id,bean_name, request  );  
		bean.setLanguageId(locale);
		String currency_code			=		bean.checkForNull(request.getParameter("currency_code"));
		String local_currency			=		bean.checkForNull(request.getParameter("local_currency"));
		
		
		for(int i=0;i<bean.getItemKeys().size();i++) {
			alItemKeys.add(bean.getItemKeys().get(i));	
		} 
		
		for(int i=0;i<bean.getReqKeys().size();i++) {
			if(!alItemKeys.contains(bean.getReqKeys().get(i)))
			alItemKeys.add(bean.getReqKeys().get(i));	
		}
		
		ArrayList newKeys = bean.getItemKeysAdded();

		if (newKeys != null && newKeys.size() >0) {
			alItemKeys.addAll(newKeys);
		}
		
		hmItemStore						=		bean.getHmItemDetail();
		int i							=		0;
		String supplier_code = "";
		String dflt_currency = "";
		
		if(bean.getCurrency_code() != "" && bean.getCurrency_code() != null ){
			dflt_currency = bean.getCurrency_code() ;			
		}
		else if(currency_code != "" && currency_code != null){	 
			dflt_currency = currency_code ;			
		}
		if(dflt_currency == "" && dflt_currency == null){
			HashMap hmRecord = bean.getCurrencyDesc(supplier_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
		}	
		String dflt_currency_desc =	bean.checkForNull((String)bean.fetchRecord("SELECT currency_code, short_desc FROM sy_foreign_currency_lang_vw WHERE language_id = ? and currency_code = ? ORDER BY 2",new String[]{locale,dflt_currency}).get("SHORT_DESC"));	
		String currency_desc_lc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  sy_foreign_currency_lang_vw where CURRENCY_CODE=? and language_id = ?",new String[]{local_currency,locale}).get("SHORT_DESC"));
%>
<body onLoad="">
	<form name='formTenderList' id='formTenderList'>

		<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' > 
			<tr colspan=11>
				<th colspan=11 nowrap><fmt:message key="ePO.TenderDetails.label" bundle="${po_labels}"/></th>
			</tr>
		</table>
		
		<br>
	<!--	<div style='overflow:scroll;height:410px;width=980px;position:relative;float:left;'>   -->
		<div id="tndrList" style='overflow:auto;height:410px;width=980px;position:relative;float:left;'>
		<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' >		
			
			<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)' >
				<td width='4%' class='COLUMNHEADER' nowrap>	<fmt:message key="ePO.S.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="ePO.Item.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="ePO.TndrQty.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="ePO.TndrUOM.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="ePO.UnitCost.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.NetAmount.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.Brand.label" bundle="${po_labels}"/></td>
				<td class='COLUMNHEADER' nowrap ><fmt:message key="ePO.ItemRemarks.label" bundle="${po_labels}"/></td>
			</tr>
<%
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize			=		alItemKeys.size();
					for (i=0;	i<totalSize;	i++){
						itemStoreKey		=		(String) alItemKeys.get(i);
						
						TenderDetailBean detailBean = (TenderDetailBean) hmItemStore.get(itemStoreKey);					
						
						if (detailBean != null){
						
						//	if( (bean.checkForNull(detailBean.getCheck_box_status())).equals("Y") )
							  checked		=		"checked" ;
						//	else
						 //     checked		=		"" ;

                         
						className		=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";

						Dnet_amt_conv = Double.parseDouble(bean.checkForNull(detailBean.getNet_amount(),"0"));//41603 by Ganga
						dnet_amt_conv = Dnet_amt_conv.doubleValue();//41603 by Ganga
						net_amt 	  = net_amt + dnet_amt_conv;					//41603 by Ganga											
						
						srl_no = srl_no+1;				
						
						String st_code = bean.checkForNull((String)detailBean.getStore_code());
						if(st_code.equals("*A") || st_code.equals(""))
							st_code = "ALL";
						else
							st_code = st_code;
							
						rejection_remarks = bean.checkForNull((String)detailBean.getRejection_remarks(),"");
						item_remarks = bean.checkForNull((String)detailBean.getItem_remarks(),"");
						item_remarks = URLEncoder.encode(item_remarks, "UTF-8").replaceAll("\\+", "%20") ;
						String po_no = bean.checkForNull((String)detailBean.getPo_no());
						if(po_no.equals("*A"))
							po_no = "";						
						
			%>
			<tr id="tr_<%=i%>">
					
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right' title="<%=srl_no%>" value="<%=srl_no%>"><%=srl_no%></td>
				<td class="<%=className%>" nowrap align='center'><input type="checkbox" name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=itemStoreKey%>" <%=disabled%> <%=checked%> onClick="updateCheckStatus(this);"></td>
				<td id="a_<%=i%>" nowrap class="<%=className%>"  align='left' onClick="displayItemDetail(<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=detailBean.getItem_desc()%></font></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getTender_qty(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getTender_uom_desc(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getTender_price(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(detailBean.getNet_amount(),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap style="WORD-BREAK:BREAK-ALL;" align='right'><%=bean.checkForNull(bean.getTradeName(bean.checkForNull(detailBean.getTrade_id())),"&nbsp;")%></td>
				<td class="<%=className%>" nowrap align='center' onClick = "ItemRemarks1('<%=item_remarks%>','disabled')" onMouseOver="changeCursor(this);"><font class='HYPERLINK'><fmt:message key="ePO.ItemRmks.label" bundle="${po_labels}"/></font></td>					
				
			</tr>
				<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
				<input type="hidden" name="po_no_<%=i%>" id="po_no_<%=i%>" value="<%=bean.checkForNull(detailBean.getPo_no())%>">
				
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
				
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Net Tender Amt &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='currency_label_7' class="label" >&nbsp;<B></B></label></th>
				<% if(bean.checkForNull(bean.getNet_poAmt()) == "") {%>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label' class="label" >&nbsp;<%=formatter.format(net_amt)%></label>
					<input type="hidden" name="net_poAmt" id="net_poAmt"	value="<%=formatter.format(net_amt)%>">
				<% }else {%>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id='net_poAmt_label' class="label" >&nbsp;<%=bean.checkForNull(bean.getNet_poAmt())%></label>
					<input type="hidden" name="net_poAmt" id="net_poAmt"	value="<%=bean.checkForNull(bean.getNet_poAmt())%>">
				<%}%>
					
				</th>
			</tr>
						
		</table>
		<br>
		
			
			<input type="hidden" 	name="total_checkboxes" id="total_checkboxes"				value="<%=i%>">
			<input type="hidden" 	name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden" 	name="mode" id="mode"							value="<%=mode%>">
			<input type="hidden" 	name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" 	name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" 	name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden" 	name="tender_type" id="tender_type"					value="">
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



