<!DOCTYPE html>
 <%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
	<script language="JavaScript" src="../../eST/js/GoodsReturnToVendor.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

	<%
	GoodsReturnToVendorBean bean	=		(GoodsReturnToVendorBean) getBeanObject( "goodsReturnToVendorBean","eST.GoodsReturnToVendorBean", request);
	bean.setLanguageId(locale);
	String store_code				=		bean.getStore_code();
	String stButtonLegend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");

	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no				=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
	String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	String item_code				=		"";
	String item_desc				=		"";
	String uom						=		"";
	String gen_uom_desc				=		"";
	String uom_code					=		"";
	String max_item_qty_normal		=		"";
	String item_qty_normal			=		"";
	String max_item_qty_bonus		=		"";
	String item_qty_bonus			=		"";
	String expiry_yn				=		"";
	String remarks					=		"";
	String store_item_unit_cost		=		"";
	String allow_deci_yn            =    "";
	int no_deci                   =    bean.getNoOfDecimals();
	String to_conv_fact				=		"";
	String codeDisabled				=		"";
	String visibilityBonus			=		((String)bean.getMmParameter().get("RECEIVE_BONUS_YN")).equals("Y")?"visible":"hidden";	

	if(!index.equals("-1")){
		HashMap hmRecord			=		bean.getDtlRecord(Integer.parseInt(index));
		stButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");

		doc_srl_no					=		(String)hmRecord.get("doc_srl_no");
		item_code					=		(String)hmRecord.get("item_code");
		item_desc					=		(String)hmRecord.get("item_desc");
		uom							=		(String)hmRecord.get("uom_desc");
		uom_code					=		(String)hmRecord.get("uom_code");
		/**
			* @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092
			* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
			*/
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_deci = 0;
		}
		item_qty_normal				=		 (bean.checkForNull((String)hmRecord.get("item_qty_normal")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_normal"),no_deci);
		if(item_qty_normal.equals("0")){
		   item_qty_normal ="";
		}
		item_qty_bonus				=	 (bean.checkForNull((String)hmRecord.get("item_qty_bonus")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_bonus"),no_deci);
		expiry_yn					=		(String)hmRecord.get("expiry_yn");
		store_item_unit_cost		=		(String)hmRecord.get("store_item_unit_cost");
		max_item_qty_normal			=		(String)hmRecord.get("max_item_qty_normal");
		max_item_qty_bonus			=		(String)hmRecord.get("max_item_qty_bonus");
		to_conv_fact				=		(String)hmRecord.get("to_conv_fact");
		remarks						=		(String)hmRecord.get("remarks");
		gen_uom_desc				=		(String)hmRecord.get("gen_uom_desc");
        allow_deci_yn               =   (String)hmRecord.get("allow_deci_yn");
       
		codeDisabled				=		"disabled";
	}
	%>
	</head>
	<body>
	<form name="formGoodsReturnToVendorListHeader" id="formGoodsReturnToVendorListHeader">
		<table border='0' cellpadding='2' cellspacing='0' width='100%' height='100%' align=center>
				<% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
			<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 align='left' class='fields' colspan=2><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends%>
		<tr>
			<td class='label' ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=2  class='fields'><input type='text' name='item_desc' id='item_desc' size=70 maxlength=60 value="<%=item_desc%>" <%=codeDisabled%>><input type='button' name="item_search" id="item_search" class="button" onClick="callItemSearchScreen()"  value='?' <%=codeDisabled%> ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>"></td>
			<td class='label'><b><span id="id_uom"><%=uom%></span></b></td>
		</tr>
		<tr>
		<td colspan='4'  class='ITEMSELECT'><b><fmt:message key="Common.ReturnQty.label" bundle="${common_labels}"/> In <fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></b></td>
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></td>
				<!-- 		
				* @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
				-->
			<td class='fields'><input type='text' name='item_qty_normal' id='item_qty_normal' size='13' maxlength='13' class="NUMBER" onKeyPress="return isValidNumber(this,event,8,<%=no_deci%>);" onBlur="checkDoubleFormat(this);"  value="<%=item_qty_normal%>"></td>
			<td class=label ><fmt:message key="eST.MaxAvailable.label" bundle="${st_labels}"/></td>
			<td class='fields' nowrap><input type='text' name='max_item_qty_normal' id='max_item_qty_normal' size="<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>" maxlength="<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>" class="NUMBER" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"  value="<%=max_item_qty_normal%>" disabled>
			<b><span id = "gen_uom_desc2"><%=gen_uom_desc%></span></b></td>
		</tr>
		<tr>
			<td class=label ><span style="visibility:<%=visibilityBonus%>"><fmt:message key="eST.Bonus.label" bundle="${st_labels}"/></span></td>
				<!-- 		
				* @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
				-->
			<td class='fields'><span style="visibility:<%=visibilityBonus%>"><input type='text' name='item_qty_bonus' id='item_qty_bonus' size=13 maxlength=13 class="NUMBER" onKeyPress="return isValidNumber(this,event,8,<%=no_deci%>);" onBlur="checkDoubleFormat(this);"  value="<%=item_qty_bonus%>"></span></td>
			<td class=label ><span style="visibility:<%=visibilityBonus%>"><fmt:message key="eST.MaxAvailable.label" bundle="${st_labels}"/></td>
			<td class='fields' nowrap><span style="visibility:<%=visibilityBonus%>"><input type='text' name='max_item_qty_bonus' id='max_item_qty_bonus' size="<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>" maxlength="<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>" class="NUMBER" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"  value="<%=max_item_qty_bonus%>" disabled>
			<b><span id="gen_uom_desc1"><%=gen_uom_desc%></span></b></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fields'  colspan='3'><textarea rows='2' cols='56' name="remarks" onKeyPress="return false;" onBlur= "chkTextAreaMaxLength(this, 200);" ><%=remarks%></textarea><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
		</tr>

		<tr>
			<td class='fields'  colspan='4'>
				<input type='button' name="batch_search" id="batch_search" value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>'  class='button' onclick="callRTVBatchSearch();"><input type='button' name="apply" id="apply" value="<%=stButtonLegend%>" class='button' onclick="toConvFactor();if(issueUOMQtyChk()) addToList();"><input type='button' name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class='button' onclick="cancel_me();">
			</td>
		</tr>
		</table>
		<input type="hidden"	name="store_item_unit_cost" id="store_item_unit_cost"		value="<%=store_item_unit_cost%>">
		<input type="hidden"	name="store_code" id="store_code"				value="<%=store_code%>">
		<input type="hidden"	name="uom_code" id="uom_code"					value="<%=uom_code%>">
		<input type="hidden"	name="expiry_yn" id="expiry_yn"				value="<%=expiry_yn%>">
		<input type="hidden"	name="doc_srl_no" id="doc_srl_no"				value="<%=doc_srl_no%>">
		<input type="hidden"	name="index" id="index"					value="<%=index%>">
		<input type="hidden"	name="tmp_conv" id="tmp_conv"					value="<%=to_conv_fact%>">
		<input type="hidden"	name="gen_uom_desc" id="gen_uom_desc"				value="<%=gen_uom_desc%>">
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id"				value="">
		<input type="hidden"	name="lang_id" id="lang_id"					value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"			value="RTV">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>">
	    <input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>">
		<!-- 		
		* @Name - Priya
		* @Date - 10/02/2010
		* @Inc# - 19092
		* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	<input type="hidden"		name="item_2d_barcode_yn" id="item_2d_barcode_yn"		 			 value='<%=item_2d_barcode_yn%>'><!-- added for MOHE-CRF-0167 -->
	</form>
	<%
//putObjectInBean("goodsReturnToVendorBean",bean,request);
%>
	</body>
</html>

