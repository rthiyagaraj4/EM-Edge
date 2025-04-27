<!DOCTYPE html>
 
<%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*,eST.OpeningStockBean, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
<%
	request.setCharacterEncoding("UTF-8");
	String locale				=		(String)session.getAttribute("LOCALE");
	String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/OpeningStock.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	OpeningStockBean bean			=		(OpeningStockBean)getBeanObject( "openingStockBean",  "eST.OpeningStockBean" ,request);
	bean.setLanguageId(locale);
	StHeaderBean beanHdr			=		(StHeaderBean)getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean",request );
	beanHdr.setLanguageId(locale);

	String store_code				=		beanHdr.getStore_code();
	String doc_srl_no				=		request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	HashMap DtlArray				=		new HashMap();
	String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	
	/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();
	
	String item_code = bean.checkForNull(request.getParameter("item_code"));
			/** @Name - Priya
			* @Date - 23/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To enable & disable remarks look up button
			*/
			String strRemarksDisabled = "disabled";

			if(!item_code.equals("")){
			   strRemarksDisabled = "enabled";
			}
	/**
	 * @Name - Priya
	 * @Date - 31/05/2010
	 * @Inc# - 
	 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
	 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();

	%>
	</head>
<body onLoad="FocusFirstElement();totalqty();">
<form name='formOpeningStockListHeader' id='formOpeningStockListHeader'>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' >
	   <tr>
			<td colspan=9>&nbsp;</td>
	   </tr>

<%

	if(doc_srl_no!="-1") {
		/**
		* @Name - Priya
		* @Date - 13/01/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
		*/
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		/**END**/
		DtlArray					=		bean.getDetailList(doc_srl_no); 
		
%>
				<% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
		<td class='label' width ='15%'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
		
			<td colspan=6 align=left><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends %>
	<tr>
		<td class=label width ='15%'> <fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td colspan=4 ><input type=text name=item_desc size=60 maxlength=60 disabled value="<%=DtlArray.get("item_desc")%>"><input type=button name="item_search" id="item_search" class="button" disabled  onClick="callItemSearchScreen(item_code)"  value='?' ><%=bean.getImage("M")%></td>
		<td id=td_uom class=label colspan =4><b><%=DtlArray.get("uom")%></b>&nbsp;</td>
	</tr>
	<tr>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class=label width ='10%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td width ="6%"><input type=text name=adj_item_qty size=12 maxlength=12 class="NUMBER" value="<%=bean.setNumber(bean.checkForNull((String)DtlArray.get("adj_item_qty"),"0"),no_of_decimals)%>" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);checkMaxLevel(); ComputeCost();totalqty();"><%=bean.getImage("M")%></td>
		<td class=label  width="3%"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>&nbsp;</td>
		<td  colspan='1'width="9%"  ><input type=text name=item_cost_value value="<%=(String)DtlArray.get("item_cost_value")%>"size=14 maxlength=14 class="NUMBER"  onkeypress="return isValidNumberCost(this,event,10,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this);ComputeCost();"><%=bean.getImage("M")%>&nbsp;</td>
		<td class=label  width='3%'><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  class=label id=td_cost width='8%'><b><%=(String)DtlArray.get("item_unit_cost")%>&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
		<td class=label  width ='15%'><fmt:message key="eST.MaxStockLevel.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class=label  id= "max_stk_qty_label"width ='10%' ><b><%=DtlArray.get("max_stk_qty")%></b>&nbsp;</td>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - setNumber function is called to set the no of digits after the decimal poit as given in entity parameter			
		-->
		<input type="hidden" name="max_stk_qty" id="max_stk_qty" value ="<%=(String)DtlArray.get("max_stk_qty")%>">

	</tr>
	<tr>
	<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Size and maxlength of 'tot_qty' is increased to 12 as it has to accept decimal numbers			
		-->
		<td class="label" width ='15%'><fmt:message key="eST.TotalQuantity.label" bundle="${st_labels}"/></td> <!-- Modified for MOHE-CRF-0040.1 -->
		<td><input type = "text" class="NUMBER" name="tot_qty" id="tot_qty" size=12 maxlength=12 disabled></td>
		<td id=td_gen_uom  class=label colspan=4><b><%=DtlArray.get("gen_uom")%></b>&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td class=label align=right width ='10%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<input type="hidden" name="remarks_code" id="remarks_code" value="<%=bean.checkForNull((String)DtlArray.get("remarks_code"))%>">
		<td colspan=6 align=left><textarea rows=2 cols=50 name=remarks  readonly onblur="checkRemarksLength(this);" style='resize:none'><%=bean.checkForNull((String)DtlArray.get("remarks"))%></textarea><input type='button' class='BUTTON' value='?' onClick="searchRemarks(remarks_code,remarks);"><%=bean.getImage("M")%></td>
	</tr>
<%

	}
	else {

%>
		<% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
		<td class='label' width ='13%'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 align=left ><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends %>
	<tr>
		<td class=label  width ='13%'> <fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td colspan=4 ><input type=text name=item_desc size=60 maxlength=60 ><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen(item_code)"  value='?' ><%=bean.getImage("M")%></td>
		<td id=td_uom  class=label colspan=4><b>&nbsp;</b>&nbsp;</td>
	</tr>
	<tr>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class=label  width ='13%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  width ="6%"><input type=text name=adj_item_qty size=12 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);checkMaxLevel(); ComputeCost();totalqty();"><%=bean.getImage("M")%>&nbsp;&nbsp;</td>
		<td class=label  width="3%"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>&nbsp;</td>
		<td  width="9%" ><input type=text name=item_cost_value size=14 maxlength=14 class="NUMBER"  onkeypress="return isValidNumberCost(this,event,10,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this);ComputeCost();"><%=bean.getImage("M")%>&nbsp;</td>
		<td class=label  width ="3%"><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  class=label id=td_cost width='8%'><b></b>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class=label    width ='13%'><fmt:message key="eST.MaxStockLevel.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class=label   id= "max_stk_qty_label" width ='10%'>&nbsp;</td>
		<input type="hidden" name="max_stk_qty" id="max_stk_qty">

	</tr>
	<tr>
	<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Size and maxlength of 'tot_qty' is increased to 12 as it has to accept decimal numbers			
		-->
		<td class="label" width ='15%'><fmt:message key="eST.TotalQuantity.label" bundle="${st_labels}"/></td> <!-- Modified for MOHE-CRF-0040.1 -->
		<td><input type = "text" class="NUMBER" name="tot_qty" id="tot_qty" size=12 maxlength=12 disabled></td>
		<td id=td_gen_uom  class=label colspan=4><b>&nbsp;</b>&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td class=label  width ='10%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td colspan=6 ><textarea rows=2 cols=50 name=remarks style='resize:none' onKeyPress="return false;"></textarea><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);" <%=strRemarksDisabled%>></td>
		<td colspan=2>&nbsp;</td>
	</tr>

<%
	}
%>
	</table>
	
	<input type="hidden"	name="tmp_conv" id="tmp_conv" value="">
	<input type="hidden"	name="doc_type_code" id="doc_type_code" >
	<input type="hidden"	name="doc_no" id="doc_no" >
	<input type="hidden"	name="item_code" id="item_code"			value="<%=bean.checkForNull(request.getParameter("item_code"))%>">
	<input type="hidden"	name="store_code" id="store_code"			value="<%=store_code%>">
	<input type="hidden"	name="item_unit_cost" id="item_unit_cost" >
	<input type="hidden"	name="uom" id="uom" >
	<input type="hidden"	name="gen_uom" id="gen_uom" >
	<input type="hidden"	name="uom_code" id="uom_code">
	<input type="hidden"	name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"	value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
	<input type="hidden"	name="expiry_yn" id="expiry_yn">
	<input type="hidden"	name="batch_id_applicable_yn" id="batch_id_applicable_yn">
	<input type="hidden"	name="trade_id_applicable_yn" id="trade_id_applicable_yn">
	<input type="hidden"	name="trade_id" id="trade_id">
	<input type="hidden"	name="doc_srl_no" id="doc_srl_no"			value="<%=(request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")%>">
	<input type="hidden"	name="lang_id" id="lang_id"				value="<%=locale%>">
	<input type="hidden"	name="rem_trans_type" id="rem_trans_type"		value="OBS">
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%=  java.net.URLEncoder.encode(eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT"))%>">
	<input type="hidden"		name="item_2d_barcode_yn" id="item_2d_barcode_yn"		 			 value='<%=item_2d_barcode_yn%>'><!-- added for MOHE-CRF-0167 -->
	<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">
	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>

</form>
<%
	putObjectInBean("openingStockBean",bean,request);
	putObjectInBean( "stHeaderBean",beanHdr,request);
%>
</body>
</html>


