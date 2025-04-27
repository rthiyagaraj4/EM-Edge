<!DOCTYPE html>
<%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<html>
	<head>
		<title> </title>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script language="javaScript" src="../../eST/js/OpeningStock.js"></script>
<script language="javaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style type="text/css">
		input{
			font-size: 10px;
		}
		select{
			font-size: 10px;
		}
	</style>
	<%	 
	try{
		OpeningStockBean bean = (OpeningStockBean) getBeanObject( "openingStockBean","eST.OpeningStockBean" , request  );

		StHeaderBean beanHdr = (StHeaderBean) getBeanObject( "stHeaderBean","eST.Common.StHeaderBean" , request );	

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	     
		ArrayList ALExp=new ArrayList();
		HashMap hashDtl=new HashMap();
		HashMap hmTemp	=	(HashMap)bean.fetchRecord("select SALE_PRICE_APPL_YN from st_acc_entity_param");//Added By Sakti Sankar on 30/11/2011 for INC# - 29770
		String sys_date=beanHdr.getSysDate();
		String store_code=beanHdr.getStore_code();
		String doc_date=beanHdr.getDoc_date();
		String doc_type_code=beanHdr.getDoc_type_code();
		String doc_no=beanHdr.getDoc_no();
		String doc_ref=beanHdr.getDoc_ref();
		String trn_type=beanHdr.getTrn_type();
		String dflt_trade_id="";
		String  sale_price_appl_yn		=bean.checkForNull((String)hmTemp.get("SALE_PRICE_APPL_YN"),"N"); //Added By Sakti Sankar on 30/11/2011 for INC# - 29770
		String facility_id	=	beanHdr.getLoginFacilityId();
		boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facility_id,trn_type); //Added By Sakti Sankar on 05/12/2011 for INC# - 29770
		
// pmd 29/01/05
//		String dflt_batch_id="";
		//To set values in OpeningStockBean
		bean.setOpeningStockHeaderBean(beanHdr);
		String item_code = request.getParameter("item_code")==null?"":request.getParameter("item_code");
		String item_desc = request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
		String batch_id_applicable_yn = 	bean.checkForNull(request.getParameter("batch_id_applicable_yn"));
		String trade_id_applicable_yn = bean.checkForNull(request.getParameter("trade_id_applicable_yn"));
		String uom = bean.checkForNull(request.getParameter("uom"));
		// default batch_id to be fetched from mm_parameter
		String disable_batch_id="";
		String disable_expiry_date="";
		String expiry_date="";
		String default_batch_id="";	
//		String default_trade_id="";	
		String default_bin_location_code="";	
//		String date_legend="Expiry Dt";		
		String expiry_date_or_receipt_date="";//Added for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015
		String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
//		int x=0;
		int y=0;										
		default_bin_location_code=bean.getDefaultBinLocationCode(item_code);
		dflt_trade_id=(String)bean.getDefault_trade_id();					
		if(expiry_yn.equals("N")) {
			expiry_date = doc_date;
			disable_expiry_date="disabled";
			//date_legend="Receipt Dt";
			date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
		}		
		
/*		if(trade_id_applicable_yn.equals("N")) {
			default_trade_id = (String)bean.getDefault_trade_id();
		}*/

		if(batch_id_applicable_yn.equals("N")) {
			disable_batch_id="disabled";
			default_batch_id = (String)bean.getDefault_batch_id();
		}
		else if(batch_id_applicable_yn.equals("E")) {
			if(expiry_yn.equals("N")) {
				default_batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
			}
			disable_batch_id="disabled";			
		}
		//fetch item params from bean
		String doc_srl_no = request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();

	HashMap BarCodeRules		=	bean.getNewBarCodeRules(facility_id);
	String BarcodeRule			=   bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));
	String BarcodeRule_Disable="";
	if(BarcodeRule.equals("P") || BarcodeRule.equals("S"))
	BarcodeRule_Disable = "Readonly";
	
	String manufacturer_id	= bean.checkForNull(request.getParameter("manufacturer_id"));

%>

</head>
<body>
<form name="formOpeningStockListDetail" id="formOpeningStockListDetail">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center >
		<th><%=date_legend%></th>
		<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<!--Added By Sakti Sankar on 30/11/2011 for INC# - 29770 starts -->
		<%if(sale_price_appl_yn.equals("Y")){%>
		<th><fmt:message key="eST.SalePrice.label" bundle="${st_labels}"/></th>
		<%}%>
		<%if(BarCodeApplicable){%>
		<th><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></th>
		<%}%>
		<!--Added By Sakti Sankar on 30/11/2011 for INC# - 29770 ends -->

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
		 ALExp=bean.getExpList(doc_srl_no);
		if(ALExp.size()!=10) {
//			x=10-ALExp.size();
		}
			 for(int i=0;i<ALExp.size();i++) {
			 hashDtl=(HashMap)ALExp.get(i);
			 expiry_date_or_receipt_date=   (String)hashDtl.get("expiry_date_or_receipt_date");//Added for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015 begin
			   if(!locale.equals("en"))
					{
							expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
					}//Added ends
			 System.out.println("hashDtl" +hashDtl);
	 %>
	 <tr>
		<td >
			<input class="STSMALL" type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" <%=disable_expiry_date%>  value="<%=expiry_date_or_receipt_date%>" size=10 maxlength=10 onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>,'<%=batch_id_applicable_yn%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>);CheckDateLeap(this,'DMY','<%=locale%>');"><!-- Changed value from (String)hashDtl.get("expiry_date_or_receipt_date") and Added CheckDateLeap function for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015 -->
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>');" <%=disable_expiry_date%>></img>
		</td>
		<td class='fields'>
			&nbsp;
			<input type='text' class="UPPER" name="batch_id_<%=i%>" id="batch_id_<%=i%>" onblur="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)" onKeyPress="return  CheckForSpecialChars(event);" value="<%=(String)hashDtl.get("batch_id")%>"size=24 maxlength=20 <%=disable_batch_id%> >
		</td>
		<td class='fields'>
			<%
				if(trade_id_applicable_yn.equals("Y")) {
			%>
			<select class="STSMALL" name="trade_id_<%=i%>" id="trade_id_<%=i%>" onchange="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)">
				<%=bean.getTradeList(item_code,(String)hashDtl.get("trade_id"),locale)%>
			</select>
			<%
				}
				else if(trade_id_applicable_yn.equals("N")) {
			%>
			<select class="STSMALL" name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled>
				<%=bean.getTradeListDflt((String)hashDtl.get("trade_id"))%>
			</select>
			<%
				}
			%>
		</td>
		<td class='fields'>
			<select class="STSMALL" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" onchange="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)">
				<%=bean.getSTITBin_location_code_List(store_code,item_code,(String)hashDtl.get("bin_location_code"),locale)%>
			</select>
		</td>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=i%>" id="item_qty_<%=i%>" value="<%=bean.setNumber(bean.checkForNull((String)hashDtl.get("item_qty"),"0"),no_of_decimals)%>" class='NUMBER' onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)"  size=12 maxlength=12>
		</td>
		<!--Added By Sakti Sankar on 30/11/2011 for INC# - 29770 starts -->
		<%if(sale_price_appl_yn.equals("Y")){%>
			
			<td  class='fields'>&nbsp;&nbsp;<input type=text name="sale_price_<%=i%>" id="sale_price_<%=i%>" size=8 maxlength=7 class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="checkDoubleFormat(this, false);CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)"  value="<%=bean.checkForNull((String)hashDtl.get("sale_price"))%>"></td>
		<%}%>
		
		<%if(BarCodeApplicable){%>

			<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" size=20 maxlength=20 class="NUMBER" onKeyPress="return  CheckForSpecialChars(event);"  onBlur=""  value="<%=bean.checkForNull((String)hashDtl.get("barcode_id"))%>"  <%=BarcodeRule_Disable%> ></td>
		<%}else{%> 
		<td  class='fields'><input type=hidden name="barcode_id_<%=i%>" id="barcode_id_<%=i%>"></td>
		<%}%>

		<%if(!sale_price_appl_yn.equals("Y")){%>
		<td  class='fields'><input type=hidden name="sale_price_<%=i%>" id="sale_price_<%=i%>"></td>
		<%}%>
	</tr>
	<%	
				y=i;
		}
		y++;
		ALExp.clear();
		for(int j=y;j<10;j++) {
	%>
	<tr>
		<td class='fields'>
			<input class="STSMALL" type='text' name="expiry_date_or_receipt_date_<%=j%>" id="expiry_date_or_receipt_date_<%=j%>"  value="<%=expiry_date%>" size=10 maxlength=10 <%=disable_expiry_date%>  onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=j%>,<%=j%>,'<%=batch_id_applicable_yn%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,sale_price_<%=j%>);CheckDateLeap(this,'DMY','<%=locale%>');"><!-- Added CheckDateLeap function for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015  -->
			 <img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=j%>');" <%=disable_expiry_date%>></img>
		</td>
		<td class='fields'>
			&nbsp;
			<input  type='text' class="UPPER" name="batch_id_<%=j%>" id="batch_id_<%=j%>" onKeyPress="return  CheckForSpecialChars(event);"     onblur="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,sale_price_<%=j%>)" value="<%=default_batch_id%>" size=24 maxlength=20 <%=disable_batch_id%> >
		</td>
		<td class='fields'>
			<%
				if(trade_id_applicable_yn.equals("Y")) {
			%>
			<select class="STSMALL" name="trade_id_<%=j%>" id="trade_id_<%=j%>" onchange="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,sale_price_<%=j%>)">
				<%=bean.getTradeList(item_code,dflt_trade_id,locale)%>
			</select>
			<%
				}
				else if(trade_id_applicable_yn.equals("N")) {
			%>
			<select class="STSMALL" name="trade_id_<%=j%>" id="trade_id_<%=j%>"  disabled >
				<%=bean.getTradeListDflt(dflt_trade_id)%>
			</select>
			<%
				}
			%>
		</td>
		<td class='fields'>
			<select class="STSMALL" name="bin_location_code_<%=j%>" id="bin_location_code_<%=j%>" onchange="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,sale_price_<%=j%>)">
				<%//bean.getBinLocationList(store_code,default_bin_location_code)%>
				<%=bean.getSTITBin_location_code_List(store_code,item_code,default_bin_location_code,locale)%>
			</select>
		</td>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=j%>" id="item_qty_<%=j%>" class='NUMBER' onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,sale_price_<%=j%>)" size=12 maxlength=12>
		</td>
		<!--Added By Sakti Sankar on 30/11/2011 for INC# - 29770 starts -->
		<%if(sale_price_appl_yn.equals("Y")){%>
			
			<td  class='fields'>&nbsp;&nbsp;<input type=text name="sale_price_<%=j%>" id="sale_price_<%=j%>" size=8 maxlength=7 class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="checkDoubleFormat(this, false);CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,sale_price_<%=j%>)" ></td>
		<%}%>
		
		<%if(BarCodeApplicable){%>

			<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=j%>" id="barcode_id_<%=j%>" size=20 maxlength=20 class="NUMBER" onKeyPress="return  CheckForSpecialChars(event);"  onBlur=""  value=""  <%=BarcodeRule_Disable%> ></td>
		<%}else{%> 
		<td  class='fields'><input type=hidden name="barcode_id_<%=j%>" id="barcode_id_<%=j%>"></td>
		<%}%>
		<%if(!sale_price_appl_yn.equals("Y")){%>
		<td  class='fields'><input type=hidden name="sale_price_<%=j%>" id="sale_price_<%=j%>"></td>
		<%}%>
	</tr>
	<%
		}
	}
	else {
		for(int i=0;i<10;i++) {
	%>
	<tr>
		<td class='fields'>
			<input class="STSMALL" type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=expiry_date%>" size=10 maxlength=10 onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>,'<%=batch_id_applicable_yn%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CheckDateLeap(this,'DMY','<%=locale%>');" <%=disable_expiry_date%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>');CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>);" <%=disable_expiry_date%>></img><!-- Added CheckDateLeap function for RollForward from SRR - SRR20056-SCF-9520 by Badmavathi.B on 20/08/2015  -->
		</td>
		<td class='fields'>
			&nbsp;<input type='text' class="UPPER"  name="batch_id_<%=i%>" id="batch_id_<%=i%>" onKeyPress="return  CheckForSpecialChars(event);" onblur="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)" value="<%=default_batch_id%>" size=24 maxlength=20 <%=disable_batch_id%> >
		</td>
		<td class='fields'>
			<%
				if(trade_id_applicable_yn.equals("Y")) {
			%>
			<select class="STSMALL" name="trade_id_<%=i%>" id="trade_id_<%=i%>" onchange="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)">
				<%=bean.getTradeList(item_code,dflt_trade_id,locale)%>		
			</select>
			<%
				}
				else if(trade_id_applicable_yn.equals("N")) {
			%>
			<select class="STSMALL" name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled >
				<%=bean.getTradeListDflt(dflt_trade_id)%>
			</select>
			<%
				}
			%>
		</td>
		<td class='fields'>
			<select class="STSMALL" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" onchange="CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)">										
				<%//bean.getBinLocationList(store_code,default_bin_location_code)%>
				<%=bean.getSTITBin_location_code_List(store_code,item_code,default_bin_location_code,locale)%>
			</select>
		</td>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' class="NUMBER" name="item_qty_<%=i%>" id="item_qty_<%=i%>" onblur="checkDoubleFormat(this);CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)"  onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" size=12 maxlength=12>
		</td>
		<!--Added By Sakti Sankar on 30/11/2011 for INC# - 29770 starts -->
		<%if(sale_price_appl_yn.equals("Y")){%>
			
			<td  class='fields'>&nbsp;&nbsp;<input type=text name="sale_price_<%=i%>" id="sale_price_<%=i%>" size=8 maxlength=7 class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="checkDoubleFormat(this, false);CallNewBarcodeString('openingStockBean','eST.OpeningStockBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,sale_price_<%=i%>)"></td>
		<%}%>
		
		<%if(BarCodeApplicable){%>

			<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" size=20 maxlength=20 class="NUMBER" onKeyPress="return  CheckForSpecialChars(event);"  onBlur=""  value=""  <%=BarcodeRule_Disable%> ></td>
		<%}else{%> 
		<td  class='fields'><input type=hidden name="barcode_id_<%=i%>" id="barcode_id_<%=i%>"></td>
		<%}%>
		<%if(!sale_price_appl_yn.equals("Y")){%>
		<td  class='fields'><input type=hidden name="sale_price_<%=i%>" id="sale_price_<%=i%>"></td>
		<%}%>
	</tr>
	<%
		}
	}
	%>		 
	<%	
		if(doc_srl_no!="-1") {
	%>
	 <tr>
		<td colspan=7 class=WHITE>&nbsp;</td>
	</tr> 
	<tr valign="botton">
		<td colspan=3 class=WHITE></td>
		<td valign="botton"  colspan=2 class=WHITE><input type=button name=Modify id=Modify value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' class=button onclick="if(issueUOMQtyChk()) addToList('modify');"><input  type=button name=Cancel id=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();"></td>
	</tr>
	<%
		}
		else {
	%>
	<tr>
		<td colspan=7 class=WHITE>&nbsp;</td>
	</tr> 
	<tr valign="botton">
		<td colspan=3 class=WHITE></td>
		<td valign="botton"  colspan=2 class=WHITE><input type=button name=Add id=Add value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class=button onclick="if(issueUOMQtyChk()) addToList('add');"><input type=button name=Cancel id=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();"></td>
	</tr>
	<%
		}
	%>		 	
</table>
	<input class="STSMALL" type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
	<input class="STSMALL" type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
	<input class="STSMALL" type="hidden" name="item_desc" id="item_desc" value="<%=item_desc%>">
	<input class="STSMALL" type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input class="STSMALL" type="hidden" name="doc_date" id="doc_date" value="<%=doc_date%>">
	<input class="STSMALL" type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
	<input class="STSMALL" type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input class="STSMALL" type="hidden" name="doc_ref" id="doc_ref" value="<%=doc_ref%>">
	<input class="STSMALL" type="hidden" name="trn_type" id="trn_type" value="<%=trn_type%>">
	<input class="STSMALL" type="hidden" name="expiry_yn" id="expiry_yn" value="<%=expiry_yn%>">
	<input class="STSMALL" type="hidden" name="batch_id_applicable_yn" id="batch_id_applicable_yn" value="<%=batch_id_applicable_yn%>">
	<input class="STSMALL" type="hidden" name="trade_id_applicable_yn" id="trade_id_applicable_yn" value="<%=trade_id_applicable_yn%>">
	<input class="STSMALL" type="hidden" name="uom" id="uom" value="<%=uom%>">
	<input class="STSMALL" type="hidden" name="doc_srl_no" id="doc_srl_no" value="<%=(request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")%>">
	<input class="STSMALL" type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">

	<input class="STSMALL" type="hidden" name="locale" id="locale" value="<%=locale%>">

	 <input type="hidden"	 name="BarcodeRule" id="BarcodeRule"		 value="<%=BarcodeRule%>">
	 <input type="hidden"    name="manufacturer_id" id="manufacturer_id"	 value="<%=manufacturer_id%>" >
	 <input type="hidden"    name="supplier_id" id="supplier_id"		 value="" >

 		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	<script>
		var errorPage	 = "../../eCommon/jsp/error.jsp";
		if(document.forms[0].trade_id_0.length==1)
		{
			parent.parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage("TRADE_NOT_ASS_FOR_ITEM","ST");
			parent.frameOpeningStockListHeader.location.reload();
			self.location.href="../../eCommon/html/blank.html";
		}
		else if(document.forms[0].bin_location_code_0.length==1)
		{
			parent.parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage("BIN_LOCN_NOT_ASS_FOR_STORE","ST");
			parent.frameOpeningStockListHeader.location.reload();
			self.location.href="../../eCommon/html/blank.html";
		}
	</script>
</form>
		<%
putObjectInBean("openingStockBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);
%>
</body>
</html>
	<% 
		}
		catch(Exception e) {
			e.printStackTrace();
				}
	%>

