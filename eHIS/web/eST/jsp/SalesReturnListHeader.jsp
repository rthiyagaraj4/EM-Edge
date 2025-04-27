<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
07/08/2020  IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
30/12/2020      TFSid:11896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.SalesReturnBean,eST.SalesBean,webbeans.eCommon.*,java.sql.*, java.util.HashMap"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/SalesReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%	

	java.util.Properties prop	=		(java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		=		prop.getProperty( "client_ip_address" );
	String bean_id				=		"salesReturnBean"+login_at_ws_no;
	String bean_name			=		"eST.SalesReturnBean";

	SalesReturnBean bean		=		(SalesReturnBean)getBeanObject( bean_id, bean_name ,request);
	bean.setLanguageId(locale);
	//Added for GHL-CRF-0413.5 starts
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	bean.setSite_spec_yn(site);
	String trn_type = "SRT";	
	String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String  barcode_applicable = "";
	String   editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	//Added for GHL-CRF-0413.5 ends
	eST.SalesBean bean_sale		=		(eST.SalesBean)getBeanObject( "salesBean", "eST.SalesBean",request  );
	bean_sale.setLanguageId(locale);
	

	String store_code			=		bean.getStore_code();
	String stButtonLegend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");

	String index				=		bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no			=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");

	String item_code			=		"";
	String item_desc			=		"";
	String uom					=		"";
	String uom_code				=		"";
	String stock_available		=		"";
	String item_unit_cost		=		"";
	String item_qty				=		"";
	String item_sal_value		=		"";
	String remarks				=		"";
	String expiry_yn			=		"";
	String stock_item_yn		=		"";
	String codeDisabled			=		"";
	String payab_amt			=		"";
	String  charge_amt			=		"";
	String  sal_doc_srl_no		=		"";
	String  sales_doc_type_code	=		"";
	String  sales_doc_no	=		"";
	String  tot_item_qty		=		"";
	String display_flag			=		"visibility:hidden";
	String decimal_allowedYN = "N";
	String billable_item_yn = "Y";//Modified against GHL-CRF-0413.5
	String billmodule_yn = bean_sale.getBLModuleInstalled();//Added against GHL-CRF-0413.5
	String remarks_code		    =		""; //20/06/12
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
	int no_of_decimals = 0;
		/*if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}*/

	if(!index.equals("-1")){
		HashMap hmRecord		=		bean.getDtlRecord(Integer.parseInt(index));
		//stButtonLegend		=		"Modify";
		stButtonLegend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");

		//setNumber
		doc_srl_no				=		(String)hmRecord.get("doc_srl_no");
		item_code				=		(String)hmRecord.get("item_code");
		item_desc				=		(String)hmRecord.get("item_desc");
		uom						=		(String)hmRecord.get("uom_desc");
		uom_code				=		(String)hmRecord.get("uom_code");
		item_unit_cost			=		(String)hmRecord.get("item_unit_cost");
		item_qty				=		(String)hmRecord.get("item_qty");
		stock_available			=		(String)hmRecord.get("stock_available");
		item_sal_value			=		(String)hmRecord.get("item_cost_value");
		remarks					=		(String)hmRecord.get("remarks");
		expiry_yn				=		(String)hmRecord.get("expiry_yn");
		stock_item_yn			=		(String)hmRecord.get("stock_item_yn");
		payab_amt				=		(String)hmRecord.get("pat_net_amt");
		charge_amt				=		(String)hmRecord.get("gross_charge_amt");	
		sal_doc_srl_no			=		(String)hmRecord.get("sal_doc_srl_no");	
		sales_doc_type_code		=		(String)hmRecord.get("sales_doc_type_code");
		sales_doc_no		=		(String)hmRecord.get("sales_doc_no");
		remarks_code            =        bean.checkForNull((String)hmRecord.get("remarks_code")); //20/06/12
		stock_available			=		bean.checkForNull((String)hmRecord.get("available_qty"),(String)hmRecord.get("stock_available"));//Added by suresh.r on 15-10-2014 against Inc 2919
		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

		**/

		 decimal_allowedYN = bean.checkForNull(((String)hmRecord.get("decimal_allowedYN")),"N");
		 billable_item_yn = bean.checkForNull(((String)hmRecord.get("billable_item_yn")),"Y");//Modified against GHL-CRF-0413.5
		 no_of_decimals = Integer.parseInt((String)hmRecord.get("no_of_decimals"));
		double tmp_conv=bean.getConvFactTemp(item_code,store_code);
		/*if(tmp_conv==999999999){
			return;
			}	*/
		if((bean.checkForNull(((String)hmRecord.get("decimal_allowedYN")),"N")).equals("Y")){
			tot_item_qty			=bean.setNumber(""+(Double.parseDouble(item_qty)*tmp_conv),no_of_decimals);
		}else{
			tot_item_qty			=bean.setNumber(""+(Double.parseDouble(item_qty)*tmp_conv),0);		
		}
		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

		**/
		/** before modification
		tot_item_qty=""+(Integer.parseInt(item_qty)*bean.getConvFactTemp(item_code,store_code));
		**/
		
		codeDisabled			=		"disabled";
		if(((String)bean.getAccessCostDetails()).equals("Y")){
			display_flag		=		"visibility:visible";
		}
			
	}
	/**
		 * @Name - Priya
		 * @Date - 18/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
		 */
			String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
			


	%>
	</head>
	<body onLoad="setBarcodeField()">
	<form name="formSalesReturnListHeader" id="formSalesReturnListHeader">
		<table border='0' cellpadding='0' cellspacing='0' width='100%' height='100%' align="center">
			<% if(site){//Added for GHL-CRF-0413.5 starts   %>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=5  class='fields'>&nbsp;<input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="callBarCodeBatchSearchSRT(event,barcode,trn_type,parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','SalesReturnListHeader','SalesReturnListDetail','SalesReturnDetail');" disabled ></td>		<!--Modified for IN:073577 increased size from 70 to 80 -->	
		<td class='label'>&nbsp;</td>
		</tr>
		<%}//Added for GHL-CRF-0413.5 ends %>
			<tr><td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=5  class='fields'>&nbsp;<input type=text name=item_desc size=70 maxlength=60 value="<%=item_desc%>" <%=codeDisabled%>><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen(item_desc)"  value='?' disabled ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" id="item_code" value="<%=item_code%>"><span id="id_uom_base"><b><%=uom%></b></td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr class='NODISPLAY'>
			<td class=label  colspan='7'>
			<table border=0 cellspacing=0 cellpadding=0 width='100%' align="center">
			<tr>
				<td width='25%' class='label' ><fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/></td>
				<td width='25%' class='label'>&nbsp;</td>
				<td width='25%' class='label' ><fmt:message key="Common.Cost.label" bundle="${common_labels}"/></td>
				<td width='25%' class='label'>&nbsp;<b><span id="id_store_item_unit_cost"><%=item_unit_cost%></span></b><input type='hidden' name="store_item_unit_cost" id="store_item_unit_cost" value="<%=item_unit_cost%>"></td>
			</tr>
			</table>
			</td>
		</tr>
		 <%
		  if(billmodule_yn.equals("Y") && billable_item_yn.equals("Y")){
		 %>
		<tr>
			<td class=label ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='30%' nowrap>&nbsp;<input type=text name=item_qty size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="CheckQuantity(this);calTotalQty();" onChange="javascript:if(stock_item_yn.value=='Y')edit.disabled=false;" value="<%=item_qty%>"><%=bean.getImage("M")%><b><span id="id_uom"><%=uom%></span> </td>
			<td class=label  nowrap><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>:&nbsp;<b><span id="id_pending_qty"><%=stock_available%></span></b></td>
			<td class=label nowrap>
				<span  id="id_char_amt" style=<%=display_flag%>>
<!-- 					<fmt:message key="eST.chargeAmt.label"      bundle="${st_labels}"/>:&nbsp;
 -->					Return Amount:&nbsp;
 <!--<span id="id_charge_amt" style=<%=display_flag%>><%=payab_amt%> by ganga down is charge_amt-->
				<span id="id_charge_amt" style=<%=display_flag%>><%=charge_amt%>
				</span>
			</td>
			<td class=label nowrap>
				<span  id="id_pay_amt" style="visibility:hidden">
					<fmt:message key="Common.PatientPayable.label"  bundle="${common_labels}"/>:&nbsp;
				<span id="id_payable_amt" style="visibility:hidden"><%=payab_amt%></span></b>
			</td>
			<td align=left  class='label'><b><span style="visibility:hidden" id="id_item_sal_value"><%=item_sal_value%></span></b></td>		
			<input type="hidden" name="max_returnable_qty" id="max_returnable_qty" value="<%=stock_available%>">
			<td class = "label">&nbsp;</td>
		</tr>
		<tr>
			<td class=label width='15%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%'>&nbsp;<input type=text name=tot_item_qty size=12 maxlength=12 class="NUMBER"  value="<%=tot_item_qty%>" disabled></td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>

		</tr>
		<% 
	} else {

		  %>
		<tr>
			<td class=label ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%' nowrap>&nbsp;<input type=text name=item_qty size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="CheckQuantity(this);calTotalQty();" onChange="javascript:if(stock_item_yn.value=='Y')edit.disabled=false;" value="<%=item_qty%>"><%=bean.getImage("M")%></td>
			<td class='fields'><b><span id="id_uom"><%=uom%></span></b></td>
			<td class=label ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>:&nbsp;<b><span id="id_pending_qty"><%=stock_available%></span></b></td>
			<td  width='25%'  class='fields'>&nbsp;<b><span style="visibility:hidden" id="id_item_sal_value"><%=item_sal_value%></span></b></td>
			<input type="hidden" name="max_returnable_qty" id="max_returnable_qty" value="<%=stock_available%>">
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
			<td class=label width='15%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%'>&nbsp;<input type=text name=tot_item_qty size=12 maxlength=12 class="NUMBER"  value="<%=tot_item_qty%>" disabled></td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			

		</tr>
		<% 
			}
		  %>
		<tr>
			<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td colspan=7 class='fields'>&nbsp;<textarea rows=2 cols=50 name=remarks  readonly onBlur="checkRemarksLength(this);"><%=remarks%></textarea><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "<%=remarks_code%>"" ><input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
		</tr>
		<tr>
			<td class='fields'  colspan='7'>
				<input type=button name="edit" id="edit" value='<fmt:message key="eST.Edit/View.label" bundle="${st_labels}"/>'  class=button onclick="editViewBatch();" <%=codeDisabled%>><input type=button name=batchsearch value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>'  class=button onclick="callSalRetBatchSearch();" <%=stock_item_yn.equals("N")?codeDisabled:""%>>
				<%if(site){ //Added for GHL-CRF-0413.5 starts%>
			<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="addToListforBarcode();">
			<%}else{ %>
			<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="addToList();">
			<%}//Added for GHL-CRF-0413.5 ends %>
				<input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'   class=button onclick="cancel_me('<%=index%>');">
			</td>
		</tr>
		</table>
		<input type="hidden"	name="stock_item_yn" id="stock_item_yn"						value="<%=stock_item_yn%>">
		<input type="hidden"	name="store_code" id="store_code"							value="<%=store_code%>">
		<input type="hidden"	name="uom_code" id="uom_code"								value="<%=uom_code%>">
        <input type="hidden"	name="unit_cost" id="unit_cost"							value="<%=item_unit_cost%>">
		<input type="hidden"	name="expiry_yn" id="expiry_yn"							value="<%=expiry_yn%>">
		<input type="hidden"	name="doc_srl_no" id="doc_srl_no"							value="<%=doc_srl_no%>">
		<input type="hidden"	name="index" id="index"								value="<%=index%>">
		<input type="hidden"	name="id_item_sal_value" id="id_item_sal_value"					value="<%=item_sal_value%>">
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id"							value="">
		<input type="hidden"	name="sales_doc_type_code" id="sales_doc_type_code"					value="<%=sales_doc_type_code%>">
		<input type="hidden"	name="sal_doc_srl_no" id="sal_doc_srl_no"						value="<%=sal_doc_srl_no%>">
		<input type="hidden"	name="sales_doc_no" id="sales_doc_no"						value="<%=sales_doc_no%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="SRT">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="decimal_allowedYN" id="decimal_allowedYN"					value='<%=decimal_allowedYN%>'>
		<input type="hidden"	name="no_of_decimals" id="no_of_decimals"						value='<%=no_of_decimals%>'>
		<input type="hidden"	name="dec_allowed_yn" id="dec_allowed_yn"						value="<%=decimal_allowedYN%>">
		<input type="hidden"	name="billable_item_yn" id="billable_item_yn"						value="<%=billable_item_yn%>">
		<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>
		<!--Added against GHL-CRF-0413  starts-->
		<input type="hidden"    name="site" id="site"	 						value="<%=site%>">
		<input type="hidden"    name="trn_type" id="trn_type"							value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"						value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"					value="<%=barcode_applicable%>" >
		<input type="hidden"    name="bar_or_item_code" id="bar_or_item_code"						value="" >
		<input type="hidden"    name="noofbatchesforbarcode" id="noofbatchesforbarcode"					value="1" >
		<input type="hidden"	name="billmodule_yn" id="billmodule_yn"						value="<%=billmodule_yn%>">
		<input type="hidden"	name="conv_factor" id="conv_factor"						value="1"><!--Added for TFS id: 11896-->
		<!--Added against GHL-CRF-0413 ends-->
	
</form>

<%
	putObjectInBean(bean_id,bean,request);
	String index1 = request.getParameter("index")==null?"":(String)request.getParameter("index");
%>
<%
//Added for GHL-CRF-0413.5 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413.5 ends
%>
	</body>
	<script>
	if("<%=index1%>" != '')
	{
	parent.frameSalesReturnListDetail.location.href='../../eST/jsp/SalesReturnListDetail.jsp?<%=request.getQueryString()%>'
	}
	</script>

</html>


