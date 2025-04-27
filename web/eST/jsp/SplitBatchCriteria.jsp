<!DOCTYPE html>
<!-- 
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
09/02/2017		IN061923			Badmavathi B							GHL-CRF-0413.6 - Barcode search
07/08/2020      IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
---------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" import=" eST.SplitBatchBean, eST.Common.*,eMM.Common.* ,webbeans.eCommon.*,java.sql.*, eCommon.Common.*, java.util.HashMap"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>

		<title> </title>
<!--	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/SplitBatch.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	SplitBatchBean bean				=		(SplitBatchBean) getBeanObject( "splitBatchBean",  "eST.SplitBatchBean",  request );
	bean.setLanguageId(locale);

	StHeaderBean beanHdr			=		(StHeaderBean) getBeanObject( "stHeaderBean",  "eST.Common.StHeaderBean",request   );
	beanHdr.setLanguageId(locale);
	String bean_id = "SplitBatchBean";
	String bean_name = "eST.SplitBatchBean";

    String codeDisabled="enable";  //added by gangadharan

	String display_flag				=		"visibility:hidden";
	String store_code				=		(String)request.getParameter("store_code")==null?"":(String)request.getParameter("store_code");;
	String doc_srl_no				=		request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	HashMap DtlArray				=		new HashMap();
	
       String  trn_type  = "SPB";   
       String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	  // System.out.println("BARCODE_YN ===SPB==>"+BARCODE_YN);
	   String  barcode_applicable = "";
       String index						=		bean.checkForNull(request.getParameter("index"),"-1");     
     //Added for GHL-CRF-0413.6 starts
       Connection con				= null;
   	con						= ConnectionManager.getConnection(request);
   	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
   	bean.setSite_spec_yn(site);
  //Added for GHL-CRF-0413.6 ends
	if(!(store_code.equals(""))){
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag			=		"visibility:visible";
	}

	/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();

	//added by gangadharan
	if (!doc_srl_no.equals("-1")||doc_srl_no!="-1")
	{
     codeDisabled="Disabled";
	}
	//added ended		

			
		%>	</head>
<body onLoad="FocusFirstElement();diplayLbl();GoBarcode();">
<form name=formOpeningStockListHeader>
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align="center">
	
<%
	if(doc_srl_no!="-1")
	{
		DtlArray					=		bean.getDetailList(doc_srl_no);
	}

			/* 		
			* @Name - Priya
			* @Date - 18/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To get the value, whether decimals are allowed to this item or not.	
			*/
			String strAllowDecYN="N";
		 /** @Name - Priya
			* @Date - 23/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To enable & disable remarks look up button
			*/
			String strRemarksDisabled = "disabled";
			
		 if(!(bean.checkForNull((String)DtlArray.get("item_code"))).equals("")){
			  strAllowDecYN	= bean.getAllowDecimalsYN(((String)DtlArray.get("item_code")));
			   strRemarksDisabled = "enabled";
		 }

		 /**
		 * @Name - Priya
		 * @Date - 24/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
		 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	 if (BARCODE_YN.equals("TRUE")){
		DtlArray					=		bean.getDetailList(doc_srl_no);
		barcode_applicable = "Y";
		} 
		System.out.println("barcode_applicable 112====>" +barcode_applicable);
		 String item_desc = bean.checkForNull(((String)DtlArray.get("item_desc")));
		
%>
<%if(site){//Added against GHL-CRF-0413.6 %>
<tr>
		<td class=label ><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td><!-- Modified for TFS id:6938 -->
		<td colspan=5  class='fields'>
	 	<input type=text name=barcode id=barcode size=80 maxlength=100 onkeypress="callBarCodeBatchSearchsplit1(event, barcode,trn_type,parent.parent.frameOpeningStockHeader.document.SplitBatchHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','OpeningStockListHeader','OpeningStockListDetail','OpeningStockDetail'); "   <%=codeDisabled%> ></td> <!--Modified for IN:073577 increased size from 70 to 80 -->  
	</tr>
<%} %>
	<tr>
		<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td colspan=5  class='fields'>
		 <!-- <input type=text name=item_desc size=70 maxlength=60 value="<%=bean.checkForNull(((String)DtlArray.get("item_desc")))%>"   <%=codeDisabled%> ><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen(item_code)"  value='?' <%=codeDisabled%>  ><%=bean.getImage("M")%><b  id=td_uom  ><%=bean.checkForNull(((String)DtlArray.get("uom")))%>&nbsp;</b></td>  --> 
		<!-- onblur="ValidateItem(this);" -->
	 	<input type=text name=item_desc id=item_desc size=70 maxlength=60 onkeypress="callBarCodeBatchSearchsplit(event, item_desc,trn_type,parent.parent.frameOpeningStockHeader.document.SplitBatchHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','OpeningStockListHeader','OpeningStockListDetail','OpeningStockDetail'); "    value="<%=bean.checkForNull(((String)DtlArray.get("item_desc")))%>"   <%=codeDisabled%> ><input type=button name="item_search" id="item_search" class="button"  onClick="callBarCodeBatchSearchsplit(event,item_desc,trn_type,parent.parent.frameOpeningStockHeader.document.SplitBatchHeader.store_code,'' ,this.form,'<%=bean_id%>','<%=bean_name%>','OpeningStockListHeader','OpeningStockListDetail','OpeningStockDetail');"  value='?' <%=codeDisabled%> ><%=bean.getImage("M")%><b  id=td_uom  ><%=bean.checkForNull(((String)DtlArray.get("uom")))%>&nbsp;</b></td>   
	</tr><!-- onblur="ValidateItem(this);" -->
	
	<tr>
		<td  class='fields'><input type=button name="batch_search" id="batch_search" class="button" onClick="callVals()" disabled value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' ></td>
		<td class=label  nowrap colspan=5><span id ="bid_lbl">&nbsp;</span><!-- </td> -->
		<b id ="bid_data" ><%=bean.checkForNull(((String)DtlArray.get("batch_id")))%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span id =ed_lbl nowrap >&nbsp;</span>
		<b id =ed_data ><%=bean.checkForNull(((String)DtlArray.get("expiry_date")))%></b>&nbsp;</td>
	
	</tr>
	<tr>
		<td   class=label nowrap ><span id =tn_lbl >&nbsp;</span></td>
		<td  class='fields' colspan=5 ><b  id =tn_data class='fields'><%=bean.checkForNull(((String)DtlArray.get("trade_name_desc")))%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span id =bl_lbl nowrap >&nbsp;</span>
		<b  id =bl_data class='fields'><%=bean.checkForNull(((String)DtlArray.get("bin_loc_desc")))%></b>&nbsp;&nbsp;
		<span  id =aq_lbl nowrap>&nbsp;</span>
		<b   id =aq_data class='fields'><%=bean.checkForNull(((String)DtlArray.get("avl_qty")))%>&nbsp;</b></td>
	</tr>
	<tr>
		<!-- 		
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
	<%	
		String str_adj_item_qty ="";
		if(doc_srl_no!="-1")
		{
			if(strAllowDecYN.equals("Y")){
				str_adj_item_qty = bean.setNumber(bean.checkForNull(((String)DtlArray.get("adj_item_qty")),"0"),no_of_decimals);
			}else{
				str_adj_item_qty = bean.setNumber(bean.checkForNull(((String)DtlArray.get("adj_item_qty")),"0"),0);
			}
		}
	%>
		<td class=label  ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td   colspan=5 class='fields' ><input type=text name=adj_item_qty size=12 value="<%=str_adj_item_qty%>" maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this); ComputeCost();"><%=bean.getImage("M")%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- @Name - Priya
				* @Date - 17/02/2010
				* @Inc# - 19404 
				* @Desc - value of 'Value' & 'Cost' is checked with 'checkForNull' function as it is throwing number format exception.
		-->
		<!-- @Name - Priya
				* @Date - 24/05/2010
				* @Inc# -  
				* @Desc - bean.setNumber() function of 'Value' & 'Cost' is removed as it is already rounded up.
		-->
		<label id="id_item_unit_cost_label" style=<%=display_flag%>><fmt:message key="Common.Cost.label" bundle="${common_labels}"/></label>&nbsp;
		<b><label id="td_cost" style=<%=display_flag%>><%=(String)DtlArray.get("item_unit_cost")%></label></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label   id="val_id" style=<%=display_flag%>>&nbsp;</label>
		<label id ="val_dat" style=<%=display_flag%>><b><%=(String)DtlArray.get("item_cost_value")%>&nbsp;</b></label></td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<input type="hidden" name="remarks_code" id="remarks_code" value="<%=bean.checkForNull(((String)DtlArray.get("remarks_code")))%>">
		<td colspan=5 class='fields'><textarea rows=2 cols=35 name=remarks readonly  ><%=bean.checkForNull(((String)DtlArray.get("remarks")))%></textarea>
		<input type='button' class='BUTTON' value='?' name='remark' id='remark' onClick="searchRemarks(remarks_code,remarks);" <%=strRemarksDisabled%>></td>
	</tr>
	</table>
	<BR>
	<input type="hidden" name="locale" id="locale"						value="<%=locale%>">
	<input type="hidden" name="doc_type_code" id="doc_type_code" >
	<input type="hidden" name="doc_no" id="doc_no" >
	<input type="hidden" name="item_code" id="item_code"					value="<%=bean.checkForNull(((String)DtlArray.get("item_code")))%>">
	<input type="hidden" name="store_code" id="store_code"					value="">
	<input type="hidden" name="item_unit_cost" id="item_unit_cost" >
	<input type="hidden" name="uom" id="uom" >
	<input type="hidden" name="uom_code" id="uom_code">
	<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"			value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
	<input type="hidden" name="expiry_yn" id="expiry_yn">
	<input type="hidden" name="batch_id_applicable_yn" id="batch_id_applicable_yn">
	<input type="hidden" name="trade_id_applicable_yn" id="trade_id_applicable_yn">
	<input type="hidden" name="trade_id" id="trade_id">
	<input type="hidden" name="bin_location_code" id="bin_location_code"			value="<%=bean.checkForNull(((String)DtlArray.get("bin_loc_code")))%>">
	<input type="hidden" name="stock_item_yn" id="stock_item_yn">
	<input type="hidden" name="stock_available_yn" id="stock_available_yn">
	<input type="hidden" name="language_id" id="language_id"					value="<%=locale%>">
	<input type="hidden" name="doc_srl_no" id="doc_srl_no"					value="<%=(request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")%>">
	<!-- <input type="hidden" name="SQL_MM_TRN_REMARKS_LOOKUP" id="SQL_MM_TRN_REMARKS_LOOKUP"   value="<%=MmRepository.getMmKeyValue("SQL_MM_TRN_REMARKS_LOOKUP")%>"> -->
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">

	<input type="hidden" name="phy_inv_id" id="phy_inv_id"					value="">
	<input type="hidden"	name="rem_trans_type" id="rem_trans_type"			value="SPB">
		
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=strAllowDecYN%>">
	<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">
	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>
	
	    <input type="hidden"    name="trn_type" id="trn_type"						    value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"						value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"				value="<%=barcode_applicable%>" >
		<input type="hidden"    name="bar_or_item_code" id="bar_or_item_code"					 value="" >
		<input type="hidden"    name="billable_item_yn" id="billable_item_yn"				     value="" ><!--dummy-->
		<input type="hidden"    name="sale_req_qty" id="sale_req_qty"				          value="" ><!--dummy-->
		<input type="hidden"    name="index_" id="index_"	  					  <%=index%>		 
	    	<input type="hidden"    name="site" id="site"	 					value="<%=site%>">
</form>
<%
	putObjectInBean("splitBatchBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);
%>
<%
//Added for GHL-CRF-0413.6 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413.6 ends
%>
</body>
</html>


