<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------------------------
16/11/2018		69074				Shazana Hasan										GHL-ICN-0032
07/08/2020  IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
-----------------------------------------------------------------------------------------------------------------------------
*/
%> 



<%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!--  <script language="javascript" src="../../eST/js/StMessages.js"></script>-->	
		 <script language="javascript" src="../../eST/js/StCommon.js"></script>
	     <script language="javascript" src="../../eST/js/StTransaction.js"></script>
		 <script language="JavaScript" src="../../eST/js/StockItemConsumption.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

	<%
	StockItemConsumptionBean bean	=		(StockItemConsumptionBean) getBeanObject( "stockItemConsumptionBean", "eST.StockItemConsumptionBean" ,request);
	//StHeaderBean beanHdr			=		(StHeaderBean) mh.getBeanObject( "stHeaderBean", request,  "eST.Common.StHeaderBean" );
	bean.setLanguageId(locale);
	String store_code				=		bean.getStore_code();
	String display_flag				=		"visibility:hidden";
	//Added for GHL-CRF-0413 starts
	String bean_id				=    "stockItemConsumptionBean";
	String bean_name			=    "eST.StockItemConsumptionBean";
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	System.out.println("System.out.println(site_main)===="+site_main);
	bean.setSite_spec_yn(site_main);
	boolean site=bean.isSite_spec_yn();
	String trn_type ="CON";
	String defaultqty_appl  =   bean.checkForNull(bean.getBarcodeDefaultQtyAppl(),"N");
	String editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String  barcode_applicable = "";
	//Added for GHL-CRF-0413 ends
	//String stButtonLegend			=		"  Add  ";
	String stButtonLegend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no				=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");

	String item_code				=		"";
	String item_desc				=		"";
	String uom						=		"";
	String uom_code					=		"";
	String stock_available			=		"";
	String item_unit_cost			=		"";
	String item_qty					=		"";
	String item_sal_value			=		"";
	String remarks					=		"";
	String expiry_yn				=		"";
	String stock_item_yn			=		"";
	String codeDisabled				=		"";
	//String display_flag				=		"visibility:hidden";
	String  tot_item_qty			=		"";
	int no_of_decimals				=		 0;
	String allow_decimals			=		"N";
	String kit_temp_code            =        "";
	String usage_type                =        "";
	String remarks_code				 =		""; //Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 08-MAY-2013
	double tmp_conv=bean.getConvFactTemp(item_code,store_code);
	if(!index.equals("-1")){
		//Added for GHL-CRF-0413 starts
		HashMap hmRecord			= null;		
		if(site)
			hmRecord= 	bean.getDtlRecordforBarCode(Integer.parseInt(index));
		else
			hmRecord= 	bean.getDtlRecord(Integer.parseInt(index));
		//Added for GHL-CRF-0413 ends
		//stButtonLegend			=		"Modify";
		 stButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		
		//setNumber
		doc_srl_no					=		(String)hmRecord.get("doc_srl_no");
		item_code					=		(String)hmRecord.get("item_code");
		item_desc					=		(String)hmRecord.get("item_desc");
		uom							=		(String)hmRecord.get("uom_desc");
		uom_code					=		(String)hmRecord.get("uom_code");
		stock_available				=		(String)hmRecord.get("stock_available");
		item_unit_cost				=		(String)hmRecord.get("item_unit_cost");
		item_qty					=		(String)hmRecord.get("item_qty");
		item_sal_value				=		(String)hmRecord.get("item_cost_value");
		remarks						=		(String)hmRecord.get("remarks");
		expiry_yn					=		(String)hmRecord.get("expiry_yn");
		stock_item_yn				=		(String)hmRecord.get("stock_item_yn");
//Added for GHL-CRF-0413 starts	
if(site)
	allow_decimals				=		(String)hmRecord.get("decimal_allowedYN");
else
		allow_decimals				=		(String)hmRecord.get("dec_allowed_yn");
//Added for GHL-CRF-0413 ends
		kit_temp_code				=		bean.checkForNull((String)hmRecord.get("kit_temp_code"));
		usage_type	                =	     bean.checkForNull((String)hmRecord.get("usage_type"),"");
		//Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 08-MAY-2013
		remarks_code				=	  bean.checkForNull((String)hmRecord.get("remarks_code"),"");
		
		codeDisabled				=		"disabled";			
		tmp_conv=bean.getConvFactTemp(item_code,store_code);
		tot_item_qty				=		""+Double.parseDouble(item_qty)*tmp_conv;
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag			=		"visibility:visible";
	
				
	}
		/**
			* @Name - Suri
			* @Date - 20/01/2010
			* @Inc# - IN015496
			* @Desc - Code added to accept decimal values dynamically.
			* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			* @Modify - Modified by priya on 18/02/2010 as the decimals are not getting displayed properly
		*/
		no_of_decimals=bean.getNoOfDecimals();
	  if (item_code != ""){
		 // allow_decimals=bean.getAllowDecimalsYN(item_code);
			if(allow_decimals.equals("N")){
				no_of_decimals = 0;
			}
		}
		if(!index.equals("-1")){
			  item_qty = bean.setNumber(bean.checkForNull((String)item_qty,"0"),no_of_decimals);
		}
		/** END Priya Modification **/

		/**
		 * @Name - Priya
		 * @Date - 18/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
		 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();

				//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
					item_desc = item_desc.replaceAll(" ","%20");
					item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
					item_desc = item_desc.replaceAll("%2520","%20");
				//Added ends
	  
	%>
	</head>
	<body onload="FocusFirstElement();GoBarcode();">
	<form name="formStockItemConsumptionListHeader" id="formStockItemConsumptionListHeader">
		<table border='0' cellpadding='0' cellspacing='0' width='100%' height='100%' align="center">
		<% if(site_main){//Added for GHL-CRF-0413%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=3  class='fields' nowrap>&nbsp;<input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="callBarCodeBatchSearchforBarcode1(event,barcode,trn_type,parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','StockItemConsumptionListHeader','StockItemConsumptionListDetail','StockItemConsumptionDetail');" <%=codeDisabled%> ></td><!--Modified for IN:073577 increased size from 70 to 80 -->			
		</tr>
		<%} %>
		<tr>
			<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=2  class='fields' nowrap>&nbsp;<input type=text name=item_desc size=70 maxlength=60 value="" <%=codeDisabled%>><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen(item_code)"  value='?' <%=codeDisabled%> ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>"><b>
			<span id="id_uom"><%=uom%></span></b></td>
			<td class='label'>&nbsp;</td>
			<input type="hidden" name="item_desc_temp" id="item_desc_temp" value="<%=item_desc%>" >
		</tr>
		<tr class='NODISPLAY'>
			<td class=label  colspan='7'>
			<table border=0 cellspacing=0 cellpadding=0 width='100%' align="center">
			<tr>
				<td width='25%' class='label' ><fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/></td>
				<td width='25%' class='label'>&nbsp;</td>
				<td width='25%' class='label' ><fmt:message key="Common.Cost.label" bundle="${common_labels}"/></td>
				<td width='25%' class='label'>&nbsp;<b><span id="id_store_item_unit_cost"><%=item_unit_cost%></span></b></td>
			</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td class=label ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
		<%if(site){%>
			<td  class='fields' width='20%'>&nbsp;<input type=text name=item_qty id=item_qty size=10 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="return CheckQuantity();"  value="<%=item_qty%>"><%=bean.getImage("M")%></td>
			<%}else{ %>
			<td  class='fields' width='20%'>&nbsp;<input type=text name=item_qty id=item_qty size=10 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="return CheckQuantity();" onChange="javascript:if(stock_item_yn.value=='Y')edit.disabled=false;" value="<%=item_qty%>"><%=bean.getImage("M")%></td>
			<%} %>
			<td class=label ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>:&nbsp;<b><span id="id_stock_available"><%=stock_available%></span></b></td>
			<td  width='35%'  class='label'><label id="id_item_sal_value_label" style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:&nbsp;<b></label><label id="id_item_sal_value" style=<%=display_flag%>><%=item_sal_value%></label></b></td>
		</tr>
		<tr>
			<td class=label width='15%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%'>&nbsp;<input type=text name=tot_item_qty id=tot_item_qty size=10 maxlength=10 class="NUMBER"  value="<%=bean.setNumber(tot_item_qty,no_of_decimals)%>" disabled></td>
			
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>

		</tr>
		<tr>
			<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td colspan=5 class='fields'>&nbsp;<textarea rows=2 cols=50 name=remarks onKeyPress="return false;" onBlur="checkRemarksLength(this);"><%=remarks%></textarea><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "<%=remarks_code%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
		</tr>

		<tr>
			<td class=label  colspan='6' class='fields'>
				<input type=button name="edit" id="edit" value='<fmt:message key="eST.Edit/View.label" bundle="${st_labels}"/>' class=button onclick="editViewBatch();" <%=codeDisabled%>>
				<input type=button name=batchsearch value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' class=button onclick="callBatchSearch();" <%=stock_item_yn.equals("N")?codeDisabled:""%>>
				<%if(site){ //Added for GHL-CRF-0413 starts%>
				<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="addToListforBarcode();">
				<%}else{ //Added for GHL-CRF-0413 ends%>
				<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="addToList();">
				<%} %>
				<input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();">
			</td>
		</tr>
		</table>
		<input type="hidden"	name="stock_item_yn" id="stock_item_yn"	value="<%=stock_item_yn%>">
		<input type="hidden"	name="store_code" id="store_code"		value="<%=store_code%>">
		<input type="hidden"	name="uom_code" id="uom_code"			value="<%=uom_code%>">
        <input type="hidden"	name="unit_cost" id="unit_cost"		value="<%=item_unit_cost%>">
		<input type="hidden"	name="expiry_yn" id="expiry_yn"		value="<%=expiry_yn%>">
		<input type="hidden"	name="doc_srl_no" id="doc_srl_no"		value="<%=doc_srl_no%>">
		<input type="hidden"	name="index" id="index"			value="<%=index%>">
		<input type="hidden"	name="kit" id="kit"				value="">
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id"		value="">
		<input type="hidden"	name="dec_allowed_yn" id="dec_allowed_yn"	 value="<%=allow_decimals%>">
		<input type="hidden"	name="lang_id" id="lang_id"			value="<%=locale%>">
		<input type="hidden"	name="function1" id="function1"			value="search">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"	value="SAL">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>
		 <input type="hidden"  name="kit_temp_code" id="kit_temp_code"	value="<%=kit_temp_code%>" >
		 <input type="hidden"  name="usage_type" id="usage_type"	value="<%=usage_type%>" >
		<!--Added against GHL-CRF-0413  starts-->
		<input type="hidden"    name="site" id="site"	 value="<%=site%>">
		<input type="hidden"    name="trn_type" id="trn_type"							    value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"							    value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"					value="<%=barcode_applicable%>" >
		<input type="hidden"    name="bar_or_item_code" id="bar_or_item_code"						value="" >
		<input type="hidden"  name="noofbatchesforbarcode" id="noofbatchesforbarcode"	value="1" >
		<input type="hidden"    name="no_of_decimals" id="no_of_decimals"						value='<%=no_of_decimals%>'>
		<input type="hidden"    name="no_deci" id="no_deci"						value="">
		<input type="hidden"	name="tmp_conv" id="tmp_conv"					value='<%=tmp_conv%>'>
		<!--Added against GHL-CRF-0413 ends-->
<%
	if(!index.equals("-1")){ //added for GHL-ICN-0032
%>
		<script>
			document.formStockItemConsumptionListHeader.batchsearch.disabled=true;
		</script>
		<%}%>
	</form>
	<%
//Added for GHL-CRF-0413
	if(con != null)
		ConnectionManager.returnConnection(con,request);
%>
	 <%
putObjectInBean("stockItemConsumptionBean",bean,request);
%>

	</body>
</html>
<script>
Setitemdesc(document.formStockItemConsumptionListHeader.item_desc_temp);
</script>

