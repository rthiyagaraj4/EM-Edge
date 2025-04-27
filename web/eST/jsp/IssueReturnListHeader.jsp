<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R           27/02/2014        Suresh R     AMS-CRF-0054(Added Item Based IssueReturn)
07/08/2020      IN073577        B Haribabu          07/08/2020                    MMS-DM-CRF-0174.2
30/12/2020      TFSid:1896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*,eST.IssueReturnBean, java.util.ArrayList,java.util.HashMap"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/IssueReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
	<%
	IssueReturnBean bean			=			(IssueReturnBean) getBeanObject( "issueReturnBean", "eST.IssueReturnBean" , request);
	bean.setLanguageId(locale);
	//Added for GHL-CRF-0413 starts
	String bean_id					=		"issueReturnBean";
	String bean_name				=		"eST.IssueReturnBean";
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	bean.setSite_spec_yn(site);
	String trn_type = "RET";	
	String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String  barcode_applicable = "";
	String   editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	//Added for GHL-CRF-0413 ends
	//String stButtonLegend				=			"  Add  ";
	String stButtonLegend				=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index						=			bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no					=			bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
	String item_code					=			"";
	String item_desc					=			"";
	String expiry_yn					=		"";		//Added for GHL-CRF-0413 
    String fm_store_code				=			"";
    String to_store_code				=			"";
	String uom_code						=			"";
    String uom_desc						=			"";
	String item_unit_cost				=			"";
	String item_unit_cost_org			=			"";
    String item_cost_value				=			"";
	String stock_available				=			"";
	String item_qty						=			"";
    String Max_Returnable_Qty			=			"";
	String remarks						=			"";
	String remarks_code					=			"";
	String codeDisabled					=			"";	
	String frm_store_qty_on_hand		=			"";
	String frm_store_min_stk_level		=			"";
	String frm_store_max_stk_level		=			"";
	String frm_store_reorder_level		=			"";
	String to_store_qty_on_hand			=			"";
	String to_store_min_stk_level		=			"";
	String to_store_max_stk_level		=			"";
	String to_store_reorder_level		=			"";
	String frm_store_uom_desc			=			"";
	String to_store_uom_desc			=			"";
	String seq_no						=			"1";
	String disable_add					=			"disabled";
	String ret_qty						=			request.getParameter("ret_qty")==null?"":request.getParameter("ret_qty");
	String from_multiples				=		"1";
	String to_multiples					=		"1";
	String batch_multiples				=		"1";
	String issue_uom_multiples			=		"1";
	String uom_desc_base				=		"";
 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals					=			bean.getNoOfDecimals();

	if(!index.equals("-1")){
		HashMap hmRecord				=			bean.getDtlRecord(Integer.parseInt(index));
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
		item_code						=		(String)hmRecord.get("item_code");
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		fm_store_code					=			request.getParameter("fm_store_code");
		to_store_code					=			request.getParameter("to_store_code");
		stButtonLegend					=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		doc_srl_no						=			(String)hmRecord.get("doc_srl_no");
		seq_no							=			(String)hmRecord.get("seq_no");
		item_desc						=			(String)hmRecord.get("item_desc");
		stock_available					=			bean.setNumber((String)hmRecord.get("stock_available"),no_of_decimals);
		uom_code						=			(String)hmRecord.get("uom_code");
        uom_desc						=			(String)hmRecord.get("stock_uom");
		uom_desc_base					=			(String)hmRecord.get("uom_desc_base");
		item_qty						=			bean.setNumber((String)hmRecord.get("item_qty"),no_of_decimals);
        item_unit_cost					=			(String)hmRecord.get("item_unit_cost");
		item_unit_cost_org				=			(String)hmRecord.get("item_unit_cost_org");
		item_cost_value					=			(String)hmRecord.get("item_cost_value");
		//Max_Returnable_Qty				=			bean.setNumber((String)hmRecord.get("Max_Returnable_Qty"),no_of_decimals);
		//Modified by suresh.r on 22-08-2014 against 
		Max_Returnable_Qty				=			(String)hmRecord.get("Max_Returnable_Qty");
        remarks							=			bean.checkForNull((String)hmRecord.get("remarks"),"");
        remarks_code							=			bean.checkForNull((String)hmRecord.get("remarks_code"),"");
		frm_store_uom_desc				=			bean.getShortDesc(item_code,fm_store_code);
		to_store_uom_desc				=			bean.getShortDesc(item_code,to_store_code);
		codeDisabled					=			"disabled";			
		disable_add						=			"";			

		from_multiples					=		bean.checkForNull((String)hmRecord.get("from_multiples"),"1");
		to_multiples					=		bean.checkForNull((String)hmRecord.get("to_multiples"),"1");
		batch_multiples					=		bean.checkForNull((String)hmRecord.get("batch_multiples"),"1");
		issue_uom_multiples				=		bean.checkForNull((String)hmRecord.get("issue_uom_multiples"),"1");
		expiry_yn						=		(String)hmRecord.get("expiry_yn");		//Added for GHL-CRF-0413 
		HashMap hmMinMaxRecord			=			bean.getMinMaxRecord(Integer.parseInt(index));
		frm_store_qty_on_hand			=			(String)hmMinMaxRecord.get("frm_store_qty_on_hand");
		frm_store_min_stk_level			=			(String)hmMinMaxRecord.get("frm_store_min_stk_level");
		frm_store_max_stk_level			=			(String)hmMinMaxRecord.get("frm_store_max_stk_level");
		frm_store_reorder_level			=			(String)hmMinMaxRecord.get("frm_store_reorder_level");
		to_store_qty_on_hand			=			(String)hmMinMaxRecord.get("to_store_qty_on_hand");
		to_store_min_stk_level			=			(String)hmMinMaxRecord.get("to_store_min_stk_level");
		to_store_max_stk_level			=			(String)hmMinMaxRecord.get("to_store_max_stk_level");
		to_store_reorder_level			=			(String)hmMinMaxRecord.get("to_store_reorder_level");
	}
	String iss_ret_based_on=bean.getIssueRetBasedOn(); //Added by suresh.r on 23-01-2014 against AMS-CRF-0054

	/**
	 * @Name - Priya
	 * @Date - 02/06/2010
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
	<body onLoad="FocusFirstElement();totalqty();GoBarcode();">
    <form name="formIssueReturnListHeader" id="formIssueReturnListHeader">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' height = "50%" >
		<% if( site &&  iss_ret_based_on.equals("D") ){//Added for GHL-CRF-0413 starts   %>
		<tr>
		<td class='label' align=left><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=3 align=left class='label' colspan=2>&nbsp;<input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="callBarCodeBatchSearchRETDoc(event,barcode,trn_type,parent.parent.frames[0].document.forms[0].from_store_code,parent.parent.frames[0].document.forms[0].to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','IssueReturnListHeader','IssueReturnListDetail','IssueReturnDetail');" <%=codeDisabled%> ></td>	<!--Modified for IN:073577 increased size from 70 to 80 -->		
		</tr>
		<%} else if(site &&  iss_ret_based_on.equals("I")){%>
		<tr>
		<td class='label' align=left><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=3 align=left class='label' colspan=2>&nbsp;<input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="callBarCodeBatchSearchRETItem(event,barcode,trn_type,parent.parent.frames[0].document.forms[0].from_store_code,parent.parent.frames[0].document.forms[0].to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','IssueReturnListHeader','IssueReturnListDetail','IssueReturnDetail');" <%=codeDisabled%> ></td>	<!--Modified for IN:073577 increased size from 70 to 80 -->		
		</tr>
		<%} //Added for GHL-CRF-0413 ends%>
		<tr>
			<td class=label align=left><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<input type="hidden" name="item_desc_temp" id="item_desc_temp" value="<%=item_desc%>" >
			<!-- <td colspan=3 align=left class='label' colspan=2>&nbsp;<input type=text name=item_desc size=70 maxlength=60 value="" disabled ><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen(item_code)"  value='?' disabled ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">&nbsp;&nbsp;<span id="id_uom"><b><%=uom_desc%></b></td> Commented by suresh.r on 23-01-2014 against AMS-CRF-0054 beg-->
			<td colspan=3 align=left class='label' colspan=2>&nbsp;<input type=text name=item_desc size=70 maxlength=60 value="<%=item_desc%>" <%=codeDisabled%> ><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen_Main()"  value='?'  <%=codeDisabled%>><!-- Modified function name callItemSearchScreen(item_code) on 09-06-2014 against ML-BRU-SCF-1360--><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">&nbsp;&nbsp;<span id="id_uom"><b><%=uom_desc%></b></td><!-- Added by suresh.r on 23-01-2014 against AMS-CRF-0054 beg-->
		</tr>
		<tr>
			<td class=label align=left><fmt:message key="Common.ReturnQty.label" bundle="${common_labels}"/></td>
			<td align=left  class='label' width='20%'>&nbsp;<input type=text name=item_qty  value="<%=item_qty%>" size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="CheckQuantity(this);ChackIssueQty(this);checkminmaxstatus();totalqty();" ><%=bean.getImage("M")%></td>
			<td align=right class=label ><fmt:message key="eST.MaxReturnableQuantity.label" bundle="${st_labels}"/>
			&nbsp;<span id=pending_qty><b><%=Max_Returnable_Qty%></b></span></td>
			<td class="label">&nbsp;</td>
			<input type="hidden" name="Max_Returnable_Qty" id="Max_Returnable_Qty" value="<%=Max_Returnable_Qty%>">
		</tr>
		<tr>
			<td class=label align=left><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td align=left class='label'>&nbsp<input type="text" name="ret_qty" id="ret_qty" value="<%=ret_qty%>" size=12 maxlength=12 class="NUMBER" disabled>&nbsp;<span id="id_uom_base"><b><%=uom_desc_base%></b></span></td>
			<td colspan=3>&nbsp;</td>
		</tr>
		<tr>
			<td class=label align=left><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td colspan=3 align=left class='label'>&nbsp;<textarea rows=2 cols=50 name=remarks onKeyPress="return false;" onBlur="return checkLength()" readonly><%=remarks%></textarea><input type="hidden" name="remarks_code" id="remarks_code" value = "<%=remarks_code%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code,remarks);"></td>
		</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="2" width="100%"> 
			<tr>
			<td colspan = '7' class ="label">&nbsp;</td>
			</tr>
<!--		 <tr> 
			<td align = right class ="label" nowrap Width="15%"> <B>&nbsp;<fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/> -> </B></td>
			<td align = right class ="label" nowrap Width="10%" > <fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="12%" > <fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="12%"> &nbsp;<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="13%"> &nbsp;<fmt:message key="Common.maximum.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="14%"> &nbsp;<fmt:message key="eST.ReOrder.label" bundle="${st_labels}"/></td>
			<td align = right class ="label" nowrap Width="40%">&nbsp;</td>
		</tr>
		<tr>
			<td align = right class ="label" nowrap> <fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_qty_on_hand">   </label><%=frm_store_qty_on_hand%></td>
			<td align = right class ="label" nowrap> <label class="label" id="lb_frm_store_uom_desc"> </label><%=frm_store_uom_desc%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_min_stk_level"> </label><%=frm_store_min_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_max_stk_level"> </label><%=frm_store_max_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_reorder_level"> </label><%=frm_store_reorder_level%></td>
			<td align = right class ="label" nowrap>&nbsp;</td>
		</tr>
		<tr>
			<td align = right class ="label" nowrap> <fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_qty_on_hand">	</label><%=to_store_qty_on_hand%></td>
			<td align = right class ="label" nowrap> <label class="label" id="lb_to_store_uom_desc"> </label><%=to_store_uom_desc%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_min_stk_level"> </label><%=to_store_min_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_max_stk_level"> </label><%=to_store_max_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_reorder_level"> </label><%=to_store_reorder_level%></td>
			<td align = right class ="label" nowrap>&nbsp;</td>
		</tr>-->
		<tr>
			<td class=label align=left colspan='7'><input type=button name="edit" id="edit" value='<fmt:message key="eST.Edit/View.label" bundle="${st_labels}"/>' class=button onclick="editViewBatch()" <%=codeDisabled%>><input type=button name=batchsearch value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' class=button onclick="callIssRetBatchSearch();">
			<%if(site){ %>
			<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="toConvFactor();addToListforBarcode();">
			<%}else{ %>
			<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="toConvFactor();addToList();">
			<%} %>
			<input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();">
			<input class="button" type="button" name="ItemDetails" id="ItemDetails" value='<fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>' onClick="ItemDetail();" <%=disable_add%>></td>
		</tr>
	</table>
    <input type="hidden"	name="fm_store_code" id="fm_store_code"			value="<%=fm_store_code%>">
    <input type="hidden"	name="to_store_code" id="to_store_code"			value="<%=to_store_code%>">
    <input type="hidden"	name="uom_code" id="uom_code"					value="<%=uom_code%>">
    <input type="hidden"	name="uom_desc" id="uom_desc"					value="<%=uom_desc%>">
    <input type="hidden"	name="item_unit_cost" id="item_unit_cost"			value="<%=item_unit_cost%>">
    <input type="hidden"	name="item_cost_value" id="item_cost_value"			value="<%=item_cost_value%>">
	<input type="hidden"	name="doc_srl_no" id="doc_srl_no"				value="<%=doc_srl_no%>">
	<input type="hidden"	name="seq_no" id="seq_no"					value="<%=seq_no%>">
	<input type="hidden"	name="index" id="index"					value="<%=index%>">
	<input type="hidden"	name="frm_store_qty_on_hand" id="frm_store_qty_on_hand"	value="<%=frm_store_qty_on_hand%>">
	<input type="hidden"	name="frm_store_min_stk_level" id="frm_store_min_stk_level"  value="<%=frm_store_min_stk_level%>">
	<input type="hidden"	name="frm_store_max_stk_level" id="frm_store_max_stk_level"  value="<%=frm_store_max_stk_level%>">
	<input type="hidden"	name="frm_store_reorder_level" id="frm_store_reorder_level"  value="<%=frm_store_reorder_level%>">
	<input type="hidden"	name="to_store_qty_on_hand" id="to_store_qty_on_hand"		value="<%=to_store_qty_on_hand%>">
	<input type="hidden"	name="to_store_min_stk_level" id="to_store_min_stk_level"	value="<%=to_store_min_stk_level%>">
	<input type="hidden"	name="to_store_max_stk_level" id="to_store_max_stk_level"	value="<%=to_store_max_stk_level%>">
	<input type="hidden"	name="to_store_reorder_level" id="to_store_reorder_level"	value="<%=to_store_reorder_level%>">
	<input type="hidden"	name="frm_store_uom_desc" id="frm_store_uom_desc"		value="<%=frm_store_uom_desc%>">
	<input type="hidden"	name="to_store_uom_desc" id="to_store_uom_desc"		value="<%=to_store_uom_desc%>">
	<input type="hidden"	name="tmp_conv" id="tmp_conv"					value="">
	<input type="hidden"	name="frm_tmp_conv" id="frm_tmp_conv"				value="">
	<input type="hidden"	name="phy_inv_id" id="phy_inv_id"				value="">
	<input type="hidden"	name="lang_id" id="lang_id"					value="<%=locale%>">
	<input type="hidden"	name="rem_trans_type" id="rem_trans_type"			value="RET">
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	<input type="hidden" name="from_multiples" id="from_multiples"							value="<%=from_multiples%>">
	<input type="hidden" name="to_multiples" id="to_multiples"							value="<%=to_multiples%>">
	<input type="hidden" name="batch_multiples" id="batch_multiples"							value="<%=batch_multiples%>">
	<input type="hidden" name="issue_uom_multiples" id="issue_uom_multiples"						value="<%=issue_uom_multiples%>">
	<input type="hidden"	name="return_uom_code" id="return_uom_code"				value="">
<!-- 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/

 -->	
		<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="<%=bean.getAllowDecimalsYN(item_code)%>">
		<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_of_decimals%>">
		<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>
		<input type="hidden" name="item_unit_cost_org" id="item_unit_cost_org" value='<%=item_unit_cost_org%>'>
<!--Added against GHL-CRF-0413  starts-->
		<input type="hidden"    name="site" id="site"	 value="<%=site%>">
		<input type="hidden"    name="trn_type" id="trn_type"							    value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"							    value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"					value="<%=barcode_applicable%>" >
		<input type="hidden"    name="bar_or_item_code" id="bar_or_item_code"						value="" >
		<input type="hidden"	name="expiry_yn" id="expiry_yn"							value="<%=expiry_yn%>">
		<input type="hidden"  name="noofbatchesforbarcode" id="noofbatchesforbarcode"	value="1" >
		<input type="hidden"	name="conv_factor" id="conv_factor"			value="1">	<!--Added for TFS id: 11896-->
		<!--Added against GHL-CRF-0413 ends-->
	</form>
<%
		putObjectInBean("issueReturnBean",bean,request);
%>
<%
//Added for GHL-CRF-0413 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413 ends
%>
</body>
</html>
<script>
Setitemdesc(document.formIssueReturnListHeader.item_desc_temp);
<!-- Added by suresh.r on 23-01-2014 against AMS-CRF-0054 beg-->
<%
if(site){
if(iss_ret_based_on.equals("D") && index.equals("-1")){ 
//Added for GHL-CRF-0413 starts
	int count = bean.getDtlRecords().size();
	if(count < 1){%>
    document.formIssueReturnListHeader.barcode.disabled=true;
    <%}%>
	document.formIssueReturnListHeader.item_desc.disabled=true;
	document.formIssueReturnListHeader.item_search.disabled=true;
<%}else if(iss_ret_based_on.equals("I") && index.equals("-1")){ %>
document.formIssueReturnListHeader.item_desc.disabled=false;
	document.formIssueReturnListHeader.item_search.disabled=false;
<%} }
else{
//Added for GHL-CRF-0413 ends
	if(iss_ret_based_on.equals("D") && index.equals("-1")){ %>
	document.formIssueReturnListHeader.item_desc.disabled=true;
	document.formIssueReturnListHeader.item_search.disabled=true;
<%}else if(iss_ret_based_on.equals("I") && index.equals("-1")){ %>
	document.formIssueReturnListHeader.item_desc.disabled=false;
	document.formIssueReturnListHeader.item_search.disabled=false;
<%}
}
%>
<!-- Added by suresh.r on 23-01-2014 against AMS-CRF-054 end-->
</script>

