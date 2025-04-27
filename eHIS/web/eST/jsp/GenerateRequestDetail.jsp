<!DOCTYPE html>
<!-- 
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
14/10/2019  IN:071343        B Haribabu                                         GHL-CRF-0608
26/11/2020      TFS:6626         Haribabu                                  ML-MMOH-SCF-1642
-------------------------------------------------------------------------------------------------------------------------------
*/
 -->
<%@ page import="eST.GenerateRequestBean,eST.GenerateRequestDetail,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../eST/js/GenerateRequest.js"></script>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale								=		(String)session.getAttribute("LOCALE");
		String bean_id								=		"generateRequestBean";
		String bean_name							=		"eST.GenerateRequestBean";
		String disabled								=		"";
		String checked								=		"checked";
		String className							=		"";
		
		java.util.ArrayList alItemKeys				=		null;
		java.util.HashMap hmGenerateRequest			=		null;
		String mode									=		request.getParameter("mode");
		String function_id							=		request.getParameter("function_id");
		String generateRequestKey					=		"";
		GenerateRequestBean bean					=		(GenerateRequestBean)getBeanObject( bean_id, bean_name, request);  
		alItemKeys									=		bean.getGenerateRequestKeys();
		hmGenerateRequest							=		bean.getHmGenerateRequest();
		bean.setLanguageId(locale);

		int i										=		0;
		String store_code_on						=		"";
		String store_code_by						=		"";
		String qty_check							=		"";
		String qty_required							=		"";
		//String	issue_uom							=		"";
		store_code_on								=		request.getParameter("store_code");
		store_code_by								=		request.getParameter("store_code_by");
		String stock_style_color					=		"NO";
		int no_of_decimals							=		0;
		boolean restrict_req_exd_max_stock = bean.getRestrictReqExdMaxStock();//Added for IN:071343
	
		%>
	<body >
		<form name='formGenerateRequestDetail' id='formGenerateRequestDetail'>
<%
				if (alItemKeys != null && (alItemKeys.size()>0)) {
		%>

<!--
 * @Name - Priya
 * @Date - 13/07/2010
 * @Inc# - 22634
 * @Desc - div is added to freeze the header row 
*/-->
<div style='overflow:scroll;height:100vh;width=100vw;position:relative;float:left;'>
<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1'   >
		<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)' >
				<td class='COLUMNHEADER'>
				<fmt:message key="eST.S.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADER' >
				<fmt:message key="Common.item.label" bundle="${common_labels}"/><BR><input type="checkbox" value="Y" name="checkAll" id="checkAll" disabled onClick="return toggleCheck(this);"></td>
				<td class='COLUMNHEADERCENTER'>
				<fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td class='COLUMNHEADERCENTER'>
				<fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='COLUMNHEADERCENTER' >
				<fmt:message key="eST.MaxStockQuantity.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADER'  >&nbsp;&nbsp;
				<fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>

				<td class='COLUMNHEADERCENTER'><fmt:message key="eST.ROQty.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  ><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="eST.RequestedUOM.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  ><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></td>
			</tr>
		
	

					 <%
					int totalSize					=		alItemKeys.size();
					String firstItem=null;
					GenerateRequestDetail generateRequestDetail;
					for (i=0;	i<totalSize;	i++){
						generateRequestKey			=		(String) alItemKeys.get(i);
						if (i==0) {
							firstItem				=		""+i;
						}
						generateRequestDetail = (GenerateRequestDetail) hmGenerateRequest.get(generateRequestKey);

						//if((generateRequestDetail.getAllow_decimals_yn()).equals("Y")){
							no_of_decimals = generateRequestDetail.getNo_of_decimals();
						//}else{
					//		no_of_decimals = 0;
						//}
	
						if (generateRequestDetail != null) {
						className					=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";			
						//qty_check					=		bean.getStock_Status(store_code_on,generateRequestDetail.getItem_code());	
						qty_check					=		generateRequestDetail.getQoh_onstore();	
						
						String quantity_required	=		((Double.parseDouble(bean.checkForNull(generateRequestDetail.getReq_qty(),"0"))) < 0) ?"0":bean.checkForNull(generateRequestDetail.getReq_qty());

						if(quantity_required.equals("0")){
							qty_required			=		"disabled";
						}else {
							qty_required			=		"enabled";
						}			%>
					<tr id="tr_<%=i%>">
					<%
					double qty_check_val				=		0;
						
						if((bean.checkForNull(qty_check)).equals("")){
							qty_check_val			=		0;
						}else{
							qty_check_val			=		Double.parseDouble(qty_check);
							}

						double req_qty_val			=		Double.parseDouble(bean.checkForNull(generateRequestDetail.getReq_qty(),"0"));
						
						
					
						//String item					=		generateRequestDetail.getItem_code();
						//int conversion			=		0;
						//conversion					=		bean.convertMaxQty(store_code_by,item,store_code_on);
					//Comented by Sakti against inc# 45923 handled null
						//double pendng_qty				=		((Double.parseDouble(generateRequestDetail.getPending_req_qty())));
						double pendng_qty				=		((Double.parseDouble(bean.checkForNull(generateRequestDetail.getPending_req_qty(),"0"))));
						double qty_on_hand				=		((Double.parseDouble( bean.checkForNull(generateRequestDetail.getQty_on_hand(),"0"))));
						String rolStr				=		generateRequestDetail.getReorder_level();
						double rol						=		0;
						if(rolStr==null)
							{				rol		=		0;
						}else{
							rol	=		(Double.parseDouble(bean.checkForNull(generateRequestDetail.getReorder_level(),"0")));
							}

						double a					=		(Double.parseDouble(bean.checkForNull(generateRequestDetail.getReq_qty(),"0")));
						double req_qty				=		(a*generateRequestDetail.getByStockUOMConv())/generateRequestDetail.getReqUOMConv();

						//issue_uom					=		bean.getIssueUOM(store_code_by,item);
//						String s					=		bean.reqQuantityDisp(item,store_code_by,bean.checkForNull(generateRequestDetail.getReorder_qty(),"0"));
						String req_uom_reorder_qty	=	""+	(Double.parseDouble(bean.checkForNull(generateRequestDetail.getReorder_qty(),"0"))*generateRequestDetail.getByStockUOMConv())/generateRequestDetail.getReqUOMConv();
//Code Added By Mahesh on 3/12/2008 to check the values with Request Uom as we have converted rest of the values also into Request uom code...(Converting it into GenUom quantity and dividing with Request uom Conversion Factor)...
			qty_check_val = qty_check_val*generateRequestDetail.getOnStockUOMConv()/generateRequestDetail.getReqUOMConv();
			req_qty_val = req_qty_val*generateRequestDetail.getByStockUOMConv()/generateRequestDetail.getReqUOMConv();
						if(generateRequestDetail.getReorder_qty()!=null &&!(((String)generateRequestDetail.getReorder_qty()).equals(""))){
							if(Double.parseDouble(req_uom_reorder_qty) < req_qty ){
								req_qty					=		Double.parseDouble(req_uom_reorder_qty);
							}
						}
						/* Code added By mahesh on 1/13/2009 for multiple conversion factors....
						*/
						if((generateRequestDetail.getAllow_decimals_yn()).equals("N")){
							if(req_qty%Double.parseDouble(generateRequestDetail.getIssueUOMMultiples())!=0){
								req_qty = 0;
							}
						}	/*if((req_qty*generateRequestDetail.getReqUOMConv()%bean.getLcm(generateRequestDetail.getReqUOMConv(),generateRequestDetail.getByStockUOMConv(),generateRequestDetail.getOnStockUOMConv()))!=0){
							req_qty = 0;
						}/*end*/
							if((double)req_qty<req_qty_val)
							{
								if((double)req_qty>qty_check_val)
								{
									stock_style_color=		"YES";
								}
							}
							if((double)req_qty>req_qty_val)
							{
								if((double)req_qty_val>qty_check_val)
								{
									stock_style_color=		"YES";
								
								}
							}
							if((double)req_qty==req_qty_val)
							{
								if((double)req_qty_val>qty_check_val)
								{
									stock_style_color=		"YES";
								
								}
							}
					
					
						if(req_qty<=0){
							disabled = "disabled";
							checked = "";
						}else{
							disabled = "";
							checked = "checked";
						}
				
						%>
					
					<td class="<%=(stock_style_color =="YES")?"OARED":className%>" title="<%=(qty_check_val < req_qty_val)? "Insufficient Stock" : "" %>" width="1%" >&nbsp;</td>
					<td class="<%=className%>" width="2%" >
					<input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=generateRequestKey%>" <%=disabled%><%=checked%>  <%=qty_required%>   onFocus="return changeRowColor(tr_<%=i%>);"></td>

					
					<td class="<%=className%>"   width="21%" ><%=generateRequestDetail.getItem_desc().trim()%></td>
					<td class="<%=className%>"    width="5%"  ><%=bean.getImage(generateRequestDetail.getStock_item_yn())%></td>
					<td class="<%=className%>"   width="8%" ><%=generateRequestDetail.getStockUOM()%></td>
					<td align="right" class="<%=className%>"   width="7%" ><%=generateRequestDetail.getMax_stock_qty()%>&nbsp;</td>
					<td  align="right" class="<%=className%>"   width="6%" ><%=generateRequestDetail.getReorder_level()%>&nbsp;</td>
					<% if(bean.checkForNull(generateRequestDetail.getReorder_qty()).equals("")){
						
						%>
					<td  class="<%=className%>"   width = "8%"><%=bean.checkForNull(generateRequestDetail.getReorder_qty())%>&nbsp;</td>
						<%}else{%>
					<td  align="right" class="<%=className%>"   width = "8%"><%=generateRequestDetail.getReorder_qty()%>&nbsp;</td>
					<%}%>
					<td  align="right" class="<%=className%>"   width="8%" > <%=bean.setNumber(""+qty_on_hand,no_of_decimals)%></td>
					<td align="right" class="<%=className%>"   width="7%" > <%=bean.setNumber(""+pendng_qty,no_of_decimals)%></td>
					
					<td class="<%=className%>"   width="7%" > <%=generateRequestDetail.getRequestUOM()%></td>
					<td  class="<%=className%>"   width="8%"  >
					<%if (generateRequestDetail.getStock_item_yn().equals("N")){
							}
						%>
						<!-- @Name - Priya
						* @Date - 18/02/2010
						* @Inc# - 19304 
						* @Desc - size of the text field 'req_qty_' is increased to 11.
						-->
					<!--Added for IN:071343 starts -->	
					<%if(restrict_req_exd_max_stock){ %>	
					<input type="text" class="NOBORDER" name ="req_qty_<%=i%>" value="<%=(req_qty <= 0&&((String)generateRequestDetail.getStock_item_yn( )).equals("N")) ?"":(bean.setNumber((""+req_qty),no_of_decimals))%>" size=11  maxlength=12   onkeypress = "return isValidNumber(this,event,7,<%=no_of_decimals%>,'<%=generateRequestDetail.getAllow_decimals_yn()%>');"   onBlur="checkQty1(this,add_itm_<%=i%>,<%=bean.checkForNull(generateRequestDetail.getMax_stock_qty(),"0")%>,<%=req_qty%>,<%=no_of_decimals%>,<%=bean.setNumber(""+qty_on_hand,no_of_decimals)%>,<%=generateRequestDetail.getIssueUOMMultiples()%>);quantityCheck(this,'<%=store_code_by%>','<%=generateRequestDetail.getItem_code()%>','<%=generateRequestDetail.getIssueUOMMultiples()%>','<%=i%>');" onFocus="return changeRowColor(tr_<%=i%>);"></td><!-- Modified for 6626 --><!-- ,<%=generateRequestDetail.getIssueUOMMultiples()%> added for MMS-MD-SCF-0277 -->
					<%}else {%>
					<input type="text" class="NOBORDER" name ="req_qty_<%=i%>" value="<%=(req_qty <= 0&&((String)generateRequestDetail.getStock_item_yn( )).equals("N")) ?"":(bean.setNumber((""+req_qty),no_of_decimals))%>" size=11  maxlength=12   onkeypress = "return isValidNumber(this,event,7,<%=no_of_decimals%>,'<%=generateRequestDetail.getAllow_decimals_yn()%>');"   onBlur="checkQty(this,add_itm_<%=i%>,<%=bean.checkForNull(generateRequestDetail.getMax_stock_qty(),"0")%>,<%=req_qty%>,<%=no_of_decimals%>);quantityCheck(this,'<%=store_code_by%>','<%=generateRequestDetail.getItem_code()%>','<%=generateRequestDetail.getIssueUOMMultiples()%>','<%=i%>');" onFocus="return changeRowColor(tr_<%=i%>);"></td><!-- Modified for 6626 -->
					<%} %>
					<!--Added for IN:071343 end -->
        			<td class="NODISPLAY"   width='0%' style='display:none;'><input type="hidden" name="uom_code_<%=i%>" id="uom_code_<%=i%>" value=<%=bean.checkForNull(generateRequestDetail.getUom_code())%> ></td>				

				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=generateRequestDetail.getItem_code()%>">
				<% stock_style_color="NO";
					}
				}%>
		<script>
		document.formGenerateRequestDetail.req_qty_<%=firstItem%>.focus();
		</script>	
<%
			}
			else
	{
		%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
		</script>
		<%
	}
	%>
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
			<input type="hidden"		 name="requisition_on_store" id="requisition_on_store"		value="">
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
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

