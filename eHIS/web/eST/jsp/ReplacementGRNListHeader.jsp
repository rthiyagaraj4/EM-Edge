<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
19/05/2017				IN062881			B.Badmavathi						     Unit Cost Mandatory in GRN 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<meta name="Author" content="Rammohan.C">
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/ReplacementGRN.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	ReplacementGRNBean bean			=		(ReplacementGRNBean) getBeanObject( "replacementGRNBean", "eST.ReplacementGRNBean" ,request);
	bean.setLanguageId(locale);
	String store_code=bean.getStore_code();
//	Added by B.Badmavathi against GDOH-CRF-0109 STARTS
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean check_uc = eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_UNIT_COST_MANDATORY_GRN");
	String visibilityUnitCost			= 	"";
	if(check_uc)
		visibilityUnitCost =	"visible";	
	else
		visibilityUnitCost =	"hidden";
//	Added by B.Badmavathi against GDOH-CRF-0109 ENDS
	String stButtonLegend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no				=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");

	String item_code				=		"";
	String item_desc				=		"";
	String uom						=		"";
	String uom_code					=		"";
	String pur_uom_code				=		"";
	String modify_legend			=		"";
	modify_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
//pmd 18/02/05
//	String stock_available			=		"";
//	String item_unit_cost			=		"";
	String item_qty_normal			=		"";
	String item_qty_bonus			=		"";
	String item_qty_sample			=		"";
	String item_cost_value			=		"";
	String replace_on_expiry_yn		=		"N";
	String label_reqd_yn			=		"N";
	String expiry_yn				=		"";
	String pur_uom_conv				=		"";
	String store_item_unit_cost		=		"";
	String codeDisabled				=		"";
	String rtvDisabled				=		"Disabled";
	String dis_expiry_yn			=		"";
	String no_of_labels				=		"";
	String grn_unit_cost_in_pur_uom	=		"";
	String rtv_unit_cost			=		"";
	String rate_disabled			=		"";
	String to_conv_fact				=		"";
	String associatedrtv			=		"disabled";
	String po_cost					=		"";
	String po_discount				=		"";
	String po_tax					=		"";
	String dis						=		"";
	String allow_deci_yn            =    "";
	int no_deci                   =    bean.getNoOfDecimals();
	String visibilityBonus			=		((String)bean.getMmParameter().get("RECEIVE_BONUS_YN")).equals("Y")?"visible":"hidden";	
	String visibilitySample			=		((String)bean.getMmParameter().get("RECEIVE_SAMPLE_YN")).equals("Y")?"visible":"hidden";	
	double effective_qty=0.0;
	String pur_uom_conv_id           =    "";
		
	if(!index.equals("-1")){
		HashMap hmRecord			=		bean.getDtlRecord(Integer.parseInt(index));
		stButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		associatedrtv				=		"";
		doc_srl_no					=		(String)hmRecord.get("doc_srl_no");
		item_code					=		(String)hmRecord.get("item_code");
		item_desc					=		(String)hmRecord.get("item_desc");
		uom							=		(String)hmRecord.get("uom_desc");
		uom_code					=		(String)hmRecord.get("uom_code");
		pur_uom_code				=		(String)hmRecord.get("pur_uom_code");
//		stock_available				=		(String)hmRecord.get("stock_available");
//		item_unit_cost				=		(String)hmRecord.get("item_unit_cost");
/**
			* @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092
			* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
			*/
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_deci = 0;
		}
		item_qty_normal				=		(bean.checkForNull((String)hmRecord.get("item_qty_normal")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_normal"),no_deci);
		item_qty_bonus				=		(bean.checkForNull((String)hmRecord.get("item_qty_bonus")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_bonus"),no_deci);
		item_qty_sample				=		(bean.checkForNull((String)hmRecord.get("item_qty_sample")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_sample"),no_deci);
		item_cost_value				=		(String)hmRecord.get("item_cost_value");
		replace_on_expiry_yn		=		(String)hmRecord.get("replace_on_expiry_yn");
		label_reqd_yn				=		(String)hmRecord.get("label_reqd_yn");
		expiry_yn					=		(String)hmRecord.get("expiry_yn");
		to_conv_fact				=		(String)hmRecord.get("to_conv_fact");
		no_of_labels				=		(String)hmRecord.get("no_of_labels"); 	
		grn_unit_cost_in_pur_uom	=		(String)hmRecord.get("grn_unit_cost_in_pur_uom");     
		rtv_unit_cost				=		(String)hmRecord.get("rtv_unit_cost");     
		po_cost						=		(String)hmRecord.get("po_cost");     
		po_discount					=		(String)hmRecord.get("po_discount");     
		po_tax						=		(String)hmRecord.get("po_tax"); 
		allow_deci_yn               =   (String)hmRecord.get("allow_deci_yn");
        
		if (!((!bean.checkForNull(item_qty_normal,"0").equals("0"))&&bean.checkForNull(item_qty_bonus,"0").equals("0")&&bean.checkForNull(item_qty_sample,"0").equals("0"))) {
			rate_disabled			=		"disabled";
		}
		if (!item_qty_normal.equals("")) {
			effective_qty+=Double.parseDouble(item_qty_normal);
		}
		if (!item_qty_bonus.equals("")) {
			effective_qty+=Double.parseDouble(item_qty_bonus);
		}
		if (no_of_labels.equals("")){
			no_of_labels=""+effective_qty;
		}
		if (effective_qty!=0 && grn_unit_cost_in_pur_uom.equals("")) {
			double unit_cost			=			Double.parseDouble(item_cost_value)/effective_qty;
			unit_cost*=1000;
			unit_cost					=			Math.round(unit_cost);
			unit_cost/=1000;
			grn_unit_cost_in_pur_uom	=			""+unit_cost;
		}
		if( (replace_on_expiry_yn).equals("N") && (expiry_yn).equals("N") )
			dis_expiry_yn				=			"disabled";
			store_item_unit_cost		=			(String)hmRecord.get("store_item_unit_cost");
			pur_uom_conv				=			(String)hmRecord.get("pur_uom_conv");
			codeDisabled				=			"disabled";
			rtvDisabled					=			"";
			pur_uom_conv_id			=	(String)hmRecord.get("pur_uom_conv_id");
			if(pur_uom_conv.equals(pur_uom_conv_id)){
			pur_uom_conv_id=pur_uom_conv;
			}
				
	}
	HashMap hmTemp	=	(HashMap)bean.fetchRecord("SELECT PO_DETAILS_APPLICABLE_YN FROM ST_ACC_ENTITY_PARAM");
	
	String  po_details_applicable_yn	=(String)hmTemp.get("PO_DETAILS_APPLICABLE_YN");
	if(po_details_applicable_yn.equals("Y")){
		if(!((String)bean.checkForNull(po_cost)).equals(""))
			dis = "disabled";
	}

	/**
	 * @Name - Priya
	 * @Date - 31/05/2010
	 * @Inc# - 
	 * @Desc -  To get no of decimals for cost
	 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	%>
	</head>
	<body>
	<form name="formGoodsReceivedNoteListHeader" id="formGoodsReceivedNoteListHeader">
		<table border='0' cellpadding='0' cellspacing='0' width='100%' height='100%' align="center">
		<tr>
			<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan=5 >&nbsp;&nbsp;<input type=text name=item_desc id=item_desc size=70 maxlength=60 value="<%=item_desc%>" <%=codeDisabled%>><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen()"  value='?' <%=codeDisabled%> ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			&nbsp;<b><span id="id_uom" class='label'><%=uom%></span></b></td>
		</tr>
		<tr>
			<td class=label ><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></td>
			<!-- 		
				* @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
				-->
			<td class='fields'>&nbsp;&nbsp;<input type=text name='item_qty_normal' id='item_qty_normal' size=13 maxlength=13 class="NUMBER" onKeyPress="return isValidNumber(this,event,8,<%=no_deci%>);" onBlur="checkDoubleFormat(this);calculateValue();"  value="<%=item_qty_normal%>"></td>

			<td class=label >&nbsp;<span class="NODISPLAY" style="visibility:<%=visibilityBonus%>">
			<fmt:message key="eST.Bonus.label" bundle="${st_labels}"/></span></td>
			<td class='fields' >&nbsp;&nbsp;<span class="NODISPLAY" style="visibility:<%=visibilityBonus%>"><input type=text name='item_qty_bonus' id='item_qty_bonus' size=10 maxlength=8 class="NUMBER" onKeyPress="return isValidInteger();" onBlur="calculateValue();checkIntegerFormat(this, false);"  value="<%=item_qty_bonus%>"></span></td>
			<td class=label >&nbsp;<span style="visibility:<%=visibilitySample%>">
			<fmt:message key="eST.Sample.label" bundle="${st_labels}"/></span></td>
			<!-- 		
				* @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
				-->
			<td class='fields' >&nbsp;&nbsp;<span style="visibility:<%=visibilitySample%>"><input type=text name='item_qty_sample' id='item_qty_sample' size=13 maxlength=13 class="NUMBER" onKeyPress="return isValidNumber(this,event,8,<%=no_deci%>);"  value="<%=item_qty_sample%>" onBlur="checkDoubleFormat(this);calculateValue();" ></span></td>
			
		</tr>
		<%if(po_details_applicable_yn.equals("Y")){%>
			<tr>
				<td class=label ><fmt:message key="eST.POCost.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type=text name='po_cost' id='po_cost' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="calculatePoCost(this);calculateValue();checkDoubleFormat(this, false);"  value="<%=po_cost.equals("")?"":bean.setNumber(po_cost,noOfDecimalsForCost)%>"></td>

				<td class=label >&nbsp;<fmt:message key="eST.PODiscount.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type=text name='po_discount' id='po_discount' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="calculatePoCost(this);calculateValue();checkDoubleFormat(this, false);"  value="<%=po_discount.equals("")?"":bean.setNumber(po_discount,noOfDecimalsForCost)%>"></td>
				<td class=label >&nbsp;<fmt:message key="eST.Tax.label" bundle="${st_labels}"/> %</td>
				<td  class='fields'>&nbsp;&nbsp;<input type=text name='po_tax' id='po_tax' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="calculatePoCost(this);calculateValue();checkDoubleFormat(this, false);"  value="<%=po_tax.equals("")?"":bean.setNumber(po_tax,noOfDecimalsForCost)%>"></td>
				
			</tr>
		<%}%>
		<tr>
			<td class=label ><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></td>
			<td class='fields' >&nbsp;&nbsp;<input type=text name='user_grn_unit_cost_in_pur_uom' id='user_grn_unit_cost_in_pur_uom' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,8,<%=noOfDecimalsForCost%>);" onBlur="chk_RTV_Cost_change();calculateValue();checkDoubleFormat(this, false);"  value="<%=bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)%>" <%=rate_disabled%> <%=dis%> onChange="grn_unit_cost_in_pur_uom.value=this.value;"><input type="hidden" name="grn_unit_cost_in_pur_uom" id="grn_unit_cost_in_pur_uom" value="<%=bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)%>" >
							<span style="visibility:<%=visibilityUnitCost%>"><IMG id='unit_cost_mandatory'  src="../../eCommon/images/mandatory.gif" ></td> <!-- Added visibilityUnitCost against GDOH-CRF-0109 -->
			<td class=label ><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
			<td class='fields' >&nbsp;&nbsp;<input type=text name='item_cost_value' id='item_cost_value' size="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="calculateCost();checkDoubleFormat(this, false);"  value="<%=item_cost_value%>" <%=dis%>></td>
			<td class='fields' colspan='2' onclick="callRTVRefPreview();" class=label><font class='HYPERLINK' onMouseOver="changeCursor(this);" id="associatedrtv" <%=associatedrtv%> ><fmt:message key="eST.AssociatedRTV.label" bundle="${st_labels}"/></font></td> 
		</tr>
		<tr>
			<td class=label ><fmt:message key="Common.Label.label" bundle="${common_labels}"/></td>
			<td  class='label' colspan='2'>
			<table border='0' cellpadding=0 cellspacing=0 width='100%' align="center">
			<tr><td class='fields'>&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' value='Y' <%=bean.getChecked(label_reqd_yn)%> onClick="no_of_labels.disabled=!this.checked">
			</td>
			<td  class='label'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/></td>
			</tr>
			</table>
			</td>
			<td  colspan='2'>
			<table border='0' cellpadding=0 cellspacing=0 width='100%' align="center">
			<tr><td class='fields'>
			&nbsp;&nbsp;<input type=text name='no_of_labels' id='no_of_labels' size=10 maxlength=15 class="NUMBER" onKeyPress="return isValidInteger();"  value="<%=no_of_labels%>" onBlur="checkIntegerFormat(this, false);" <%=label_reqd_yn.equals("N")?"disabled":""%>></td>
			<td class=label ><fmt:message key="eST.Replonexpiry.label" bundle="${st_labels}"/></td>
			</tr>
			</table>
			</td>
			<td class='fields' >&nbsp;<input type="checkbox" name='replace_on_expiry_yn' id='replace_on_expiry_yn' value='Y' <%=bean.getChecked(replace_on_expiry_yn)%> <%=dis_expiry_yn%> ></td>
		</tr>

		<tr>
			<td class=label ><fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></td>
		<% if(stButtonLegend.equals(modify_legend))
		{
		%>
			<td  colspan='11' class='fields'>&nbsp;&nbsp;<select name='pur_uom_code' id='pur_uom_code' onBlur="checkUOMConvFactor();" <%=codeDisabled%>>
			<%=bean.getPur_uom_code_List(pur_uom_code,item_code)%>
			</select>&nbsp;<fmt:message key="eST.ConvFactor.label" bundle="${st_labels}"/>:&nbsp;<b id="id_pur_uom_conv"><%=pur_uom_conv_id%></b>
			<%}
			else{
		%>
			<td  colspan='11' class='fields'>&nbsp;&nbsp;<select name='pur_uom_code' id='pur_uom_code' onBlur="checkUOMConvFactor();" <%=codeDisabled%>>
			<option>&nbsp;&nbsp;&nbsp;&nbsp;---
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>&nbsp;<fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:&nbsp;<b id="id_pur_uom_conv"></b>
		<%}%>
				<input type=button name="batch_search" id="batch_search" value='<fmt:message key="eST.RTVREF.label" bundle="${st_labels}"/>' class=button onclick="callRTVBatchSearch();" <%=rtvDisabled%> >
				<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="toConvFactor();if(issueUOMQtyChk()) addToList();"><input type=button name=Cancel id=Cancel 
 			    value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class=button  onclick="cancel_me();">
		</td>
			
		</tr>
		</table>
		<input type="hidden" name="store_item_unit_cost" id="store_item_unit_cost"	value="<%=store_item_unit_cost%>">
		<input type="hidden" name="store_code" id="store_code"				value="<%=store_code%>">
		<input type="hidden" name="uom_code" id="uom_code"				value="<%=uom_code%>">
		<input type="hidden" name="expiry_yn" id="expiry_yn"				value="<%=expiry_yn%>">
		<input type="hidden" name="doc_srl_no" id="doc_srl_no"				value="<%=doc_srl_no%>">
		<input type="hidden" name="index" id="index"					value="<%=index%>">
		<input type="hidden" name="dis_expiry_yn" id="dis_expiry_yn"			value="<%=dis_expiry_yn%>" >
		<input type="hidden" name="rtv_unit_cost" id="rtv_unit_cost"			value ="<%=bean.setNumber(rtv_unit_cost,noOfDecimalsForCost)%>">
		<input type="hidden" name="pur_uom_conv" id="pur_uom_conv"			value="<%=pur_uom_conv%>">
		<input type="hidden" name="tmp_conv" id="tmp_conv"				value="<%=to_conv_fact%>">
		<input type="hidden" name="phy_inv_id" id="phy_inv_id"				value="">
		<input type="hidden" name="po_details_applicable_yn" id="po_details_applicable_yn"value="<%=po_details_applicable_yn%>">
		<input type="hidden" name="tmp_cost" id="tmp_cost"				value="<%=bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)%>">
		<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>">
	    <input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>">
		<!-- 		
		* @Name - Priya
		* @Date - 10/02/2010
		* @Inc# - 19092
		* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>
	<input type="hidden" name="check_uc" id="check_uc" value='<%=check_uc%>'> <!-- Added against GDOH-CRF-0109 -->

	</form>
	<%
	//Added for GDOH-CRF-0109
	if(con != null)
		ConnectionManager.returnConnection(con,request);
%>
<%
	putObjectInBean("replacementGRNBean",bean,request);
%>
	</body>
</html>


