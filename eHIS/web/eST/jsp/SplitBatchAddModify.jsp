<!DOCTYPE html>

<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
1/2/2018				66368				Shazana 						  								GHL-CRF-0503 Split batch	
06/11/2019              IN0071697          B Haribabu                                  					Alpha incident
22/9/2021		TFS:22321	Shazana								GHL-SCF-1587
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 
<%@ page contentType="text/html;charset=UTF-8" import=" eST.SplitBatchBean, eST.Common.* , eCommon.Common.*, java.util.ArrayList,java.util.HashMap"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javaScript" src="../../eST/js/SplitBatch.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type="text/css">
		input{
/*			font-family:  verdana;*/
			font-size: 10px;

		}
		select{
/*			font-family:  verdana;*/
			font-size: 10px;
		}
	</style>
	<%
try{

	SplitBatchBean bean = (SplitBatchBean) getBeanObject( "splitBatchBean",  "eST.SplitBatchBean", request );
	bean.setLanguageId(locale);
	StHeaderBean beanHdr = (StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean", request );
		beanHdr.setLanguageId(locale);
 	boolean site = bean.isSite_spec_yn();//Added against GHL-CRF-0446 
	ArrayList ALExp=new ArrayList();
	HashMap hashDtl=new HashMap();

	String sys_date=beanHdr.getSysDate();
	String facility_id	 =	beanHdr.getLoginFacilityId();  
	String trn_type      =  beanHdr.getTrn_type();  
	String index						=		bean.checkForNull(request.getParameter("index"),"-1"); //24/04/12
	String doc_srl_no = request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	System.out.println("index===add" +index);
	//17/04/12
	String store_code             =   "";
	String item_code              =   "";
	String item_desc              =   "";
	String expiry_yn              =   "";
	String expiry_date            =   "";
	String dflt_trade_id          =   "";
	String batch_id_applicable_yn =   "";
	String trade_id_applicable_yn =   "";
	String  manufacturer_id       =   "";
	String supplier_id             = "";
	String allow_zero_batches =""; //ADDED FOR GHL-CRF-0503 
	String mrp          = "";
	HashMap alTemp	=	new HashMap();
	
	String bar_code = request.getParameter("bar_code")==null?"":request.getParameter("bar_code");
 	String Barcode_yn = request.getParameter("Barcode_yn")==null?"":request.getParameter("Barcode_yn");
 	boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facility_id,trn_type);  
	//System.out.println("BarCodeApplicable===57===>" +BarCodeApplicable);
	//Added against GHL-CRF-0446  starts
	String select_option= "";
	select_option=bean.getSTMessage(bean.getLanguageId(),"SELECT_OPTION","ST") ;
	String select_option_legend="------Select------";
	//Added against GHL-CRF-0446  ends
	if(Barcode_yn.equals("true")){
	if(doc_srl_no.equals("-1")){
	store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code");
	//System.out.println("store_code===55===>" +store_code);
	String barcode_2d_applicable_yn = bean.barcode2DApplicable(); 
	ArrayList alBarCodeListDetails = new ArrayList(); 
	if(barcode_2d_applicable_yn.equals("Y")){
		 alBarCodeListDetails =bean.get2DBarcodeBacthes(store_code,bar_code);//Adding end for MMS-DM-CRF-0174.6
	}else{
        alBarCodeListDetails = bean.getBarCodeDetailArrayList1(bar_code,store_code);//GHL-SCF-1587
	}
	 // ArrayList alBarCodeListDetails =   bean.getBarCodeDetailArrayList1(bar_code,store_code);//modified for GHL-SCF-1587  
	 //System.out.println("alBarCodeListDetails===59===>" +alBarCodeListDetails);
	          
	    for (int t=0;t<alBarCodeListDetails.size();t++){
			          HashMap record	=	(HashMap)alBarCodeListDetails.get(t);
					  
					        item_code     =     (String)record.get("ITEM_CODE");
				      String batchid	   =	 (String)record.get("BATCH_ID");
				       expiry_date	   =	  (String)record.get("EXPIRY_DATE");
				      String binlocation   =	  (String)record.get("BIN_LOCATION_CODE");
				       dflt_trade_id    =	   (String)record.get("TRADE_ID");
					   
				ArrayList alItemDetails = bean.getItemDetailArrayList(locale,item_code,store_code);
				alTemp = (HashMap)alItemDetails.get(t);
				//System.out.println("alTemp= validate=>"+alTemp);
			 
				  item_desc              = (String)alTemp.get("ITEM_DESC") ;
				  expiry_yn                = (String)alTemp.get("EXPIRY_YN") ;
                  batch_id_applicable_yn   = (String)alTemp.get("BATCH_ID_APPLICABLE_YN") ; 
                  trade_id_applicable_yn   = (String)alTemp.get("TRADE_ID_APPLICABLE_YN") ;
                    manufacturer_id   = bean.checkForNull((String)alTemp.get("MANUFACTURER_ID")) ;
				// System.out.println("manufacturer_id:" +manufacturer_id);
				 	  supplier_id = bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE_RULE"),new String[]{item_code,batchid,expiry_date}).get("SUPP_CODE"));
				// System.out.println("supplier_id:" +supplier_id);
				  mrp     =  bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",item_code,dflt_trade_id,batchid}).get("MRP_PRICE"));
				 }
				 }else{
				  store_code=beanHdr.getStore_code();
	 item_code = request.getParameter("item_code")==null?"":request.getParameter("item_code");
	 dflt_trade_id=bean.getDefault_trade_id();
	// if(trade_id_applicable_yn.equals("Y")){
	 dflt_trade_id=bean.checkForNull(request.getParameter("trade_id"));
	 //}

	 if(dflt_trade_id.equals("")){
	 dflt_trade_id=bean.getDefault_trade_id();	 
	 }

	  batch_id_applicable_yn = 	bean.checkForNull(request.getParameter("batch_id_applicable_yn"));
	  trade_id_applicable_yn = bean.checkForNull(request.getParameter("trade_id_applicable_yn"));
	  item_desc = request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
	  expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
	  expiry_date=request.getParameter("expiry_date")==null?"":request.getParameter("expiry_date"); //modified by ganga
	   mrp     =  bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",item_code,dflt_trade_id, bean.checkForNull((String)bean.getDefault_batch_id())}).get("MRP_PRICE"));
	  
	  
	}
}else{
	 store_code=beanHdr.getStore_code();
	 item_code = request.getParameter("item_code")==null?"":request.getParameter("item_code");
	 dflt_trade_id=bean.getDefault_trade_id();
	// if(trade_id_applicable_yn.equals("Y")){
	 dflt_trade_id=bean.checkForNull(request.getParameter("trade_id"));
	 //}

	 if(dflt_trade_id.equals("")){
	 dflt_trade_id=bean.getDefault_trade_id();	 
	 }

	  batch_id_applicable_yn = 	bean.checkForNull(request.getParameter("batch_id_applicable_yn"));
	  trade_id_applicable_yn = bean.checkForNull(request.getParameter("trade_id_applicable_yn"));
	  item_desc = request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
	  expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
	  expiry_date=request.getParameter("expiry_date")==null?"":request.getParameter("expiry_date"); //modified by ganga
	}
	
	
	String doc_date=beanHdr.getDoc_date();
	String doc_type_code=beanHdr.getDoc_type_code();
	String doc_no=beanHdr.getDoc_no();
	String doc_ref=beanHdr.getDoc_ref();
	//String trn_type=beanHdr.getTrn_type();
	bean.setOpeningStockHeaderBean(beanHdr);
	String uom = bean.checkForNull(request.getParameter("uom"));
	
	String disable_batch_id="";	
	String disable_expiry_date="";
	String default_batch_id="";	
	String default_bin_location_code="";
	
	//String expiry_date=request.getParameter("expiry_date");
	//commentted for IN:0071697 start	
// 	if(!locale.equals("en"))
// 	{
//        expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
// 	}
//commentted for IN:0071697 end
	//String date_legend="Expiry Dt";
	String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");

	

	//int x=0;
	int y=0;
	/*The below line was commented By Dinesh T 1/20/2011 for the CRF No 113*/
	//expiry_date=sys_date;
	default_bin_location_code=bean.getDefaultBinLocationCode(item_code);
	//System.out.println("default_bin_location_code===100===>" +default_bin_location_code);
	
	//System.out.println("dflt_trade_id===102===>" +dflt_trade_id);
	if(!locale.equals("en"))
	{
      expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
	}
	if(expiry_yn.equals("N")) {
		expiry_date = doc_date;
		disable_expiry_date="disabled";
		//date_legend="Receipt Dt";
		date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
	}

	/*if(trade_id_applicable_yn.equals("N")) {
		default_trade_id = (String)bean.getDefault_trade_id();
	}*/
	//System.out.println("batch_id_applicable_yn======>" +batch_id_applicable_yn);

	if(batch_id_applicable_yn.equals("N")) {
		disable_batch_id="disabled";
		default_batch_id = (String)bean.getDefault_batch_id();
	}	
	else if(batch_id_applicable_yn.equals("E")) {
		disable_batch_id="disabled";		
		if(expiry_yn.equals("N")) {
			//default_batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
			default_batch_id = "";
		}
		else{
			expiry_date="";
			default_batch_id="";
		}
	}

	

	/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();
	
	//System.out.println("dflt_trade_id===178===>" +dflt_trade_id);
	//System.out.println("trade_id_applicable_yn===179===>" +trade_id_applicable_yn);
	
	
	//09/05/12
	      HashMap BarCodeRules = bean.getNewBarCodeRules(facility_id);
	      // System.out.println("BarCodeRules ===PRT==>"+BarCodeRules);
			String BarcodeRule = bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));
              System.out.println("BarcodeRule ===PRT==>"+BarcodeRule);			
			String BarcodeRule_Disable = "";
			if(BarcodeRule.equals("P") ||BarcodeRule.equals("S") )
			BarcodeRule_Disable = "ReadOnly";
	boolean restrict_GRN_batch = bean.getRestrictSplitGRN();//Added against GHL-CRF-0446 
	System.out.println("restrict_GRN_batch----->"+restrict_GRN_batch);
	/*Added for GHL-CRF-0503 split batch START*/
	allow_zero_batches = bean.getAllowZeroBatchGRN();
	/*Added for GHL-CRF-0503 split batch END*/
%>
</head>
<body>
<%
	//expiry_yn="Y";
%>
<form name=formOpeningStockListDetail>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align="center">
	<th><%=date_legend%></th>
	<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
<%if(restrict_GRN_batch){ //Added against GHL-CRF-0446 %>
	<th><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></th><!-- Modified for TFS id:6938 -->
	<th><fmt:message key="Common.Qty.label" bundle="${st_labels}"/></th>
	<%}
  else{%>
	<th><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
	 <%if(BarCodeApplicable){%>
		<th><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></th>
	<%}
}%>
	<%
	if(doc_srl_no!="-1") {
		
		/**
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
			*/
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		/**END**/
		
		 ALExp=bean.getExpList(doc_srl_no);
		 System.out.println("ALExp ==209=>" +ALExp);
		/*if(ALExp.size()!=10) {
			x=10-ALExp.size();
		}*/
			 for(int i=0;i<ALExp.size();i++) {
			 hashDtl=(HashMap)ALExp.get(i);
			 System.out.println("hashDtl ==215=>" +hashDtl);
			 			// System.out.println("hashDtl ==215=>" +hashDtl);
						// System.out.println("store_code ==215=>" +store_code);
						// System.out.println("item_code ==215=>" +item_code);
	if(restrict_GRN_batch){//Added against GHL-CRF-0446  starts
 	 %>
	<tr>
		<td class='fields'>
			<input type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" disabled value="<%=bean.checkForNull((String)hashDtl.get("expiry_date_or_receipt_date"),expiry_date)%>" size=10 maxlength=10 >
			<img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>');"  disabled ></img>
		</td>
		<td class='fields'>
			&nbsp;<input type='text' name="batch_id_<%=i%>" id="batch_id_<%=i%>" class="UPPER" value="<%=(String)hashDtl.get("batch_id")%>" size=24 maxlength=20 disabled  >
				<input type=button name="batch_search_<%=i%>" id="batch_search_<%=i%>" class="button" onClick="callGRNBatchSearch(<%=i%>,'<%=locale%>')" value='?' >
		</td>
		<td class='fields'><%if(trade_id_applicable_yn.equals("Y")){%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled><%=bean.getTradeList(item_code,(String)hashDtl.get("trade_id"))%></select><%}else{%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled><%=bean.getTradeListDflt((String)hashDtl.get("trade_id"))%></select><%}%>
		</td> 
		<td class='fields'>
			<select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" disabled >
				<%=bean.getSTITBin_location_code_List(store_code,item_code,(String)hashDtl.get("bin_location_code"),locale)%>
			</select>
		</td>
		<%if(BarCodeApplicable){%>
		<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" size=12 maxlength=20 class="NUMBER" disabled value="<%=bean.checkForNull((String)hashDtl.get("barcode_id"))%>"></td>
		<%}else{%> 
		<td  class='fields'><input type=hidden name="barcode_id_<%=i%>" id="barcode_id_<%=i%>"></td>
		<%}%>
		<td class='fields'>
			<input type='text' name="item_qty_<%=i%>" id="item_qty_<%=i%>" value="<%=bean.setNumber(bean.checkForNull((String)hashDtl.get("item_qty"),"0"),no_of_decimals)%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this); CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" size=12 maxlength=12>
		</td>
	</tr>
	<%}	else{//Added against GHL-CRF-0446 ends
 	 %>
	
		 
	 <tr>
		<td class='fields'>
			<input type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" <%=disable_expiry_date%>  value="<%=bean.checkForNull((String)hashDtl.get("expiry_date_or_receipt_date"),expiry_date)%>" size=10 maxlength=10 onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>,'<%=batch_id_applicable_yn%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');">
			<img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>');"  <%=disable_expiry_date%> ></img>
		</td>
		 
		<td class='fields'>
			&nbsp;<input type='text' name="batch_id_<%=i%>" id="batch_id_<%=i%>" class="UPPER" value="<%=(String)hashDtl.get("batch_id")%>" size=24 maxlength=20 <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars(event);" onblur = "CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" >
		</td>
		<td class='fields'><%if(trade_id_applicable_yn.equals("Y")){%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled><%=bean.getTradeList(item_code,(String)hashDtl.get("trade_id"))%></select><%}else{%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled><%=bean.getTradeListDflt((String)hashDtl.get("trade_id"))%></select><%}%>
		</td> 
		
		<td class='fields'>
			<select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" onchange="CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" >
				<%=bean.getSTITBin_location_code_List(store_code,item_code,(String)hashDtl.get("bin_location_code"),locale)%>
			</select>
		</td>
		 
		<!-- 		
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=i%>" id="item_qty_<%=i%>" value="<%=bean.setNumber(bean.checkForNull((String)hashDtl.get("item_qty"),"0"),no_of_decimals)%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this); CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" size=12 maxlength=12>
		</td>
		<%if(BarCodeApplicable){%>

			<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" size=12 maxlength=20 class="NUMBER" onKeyPress="return  CheckForSpecialChars(event);"  onBlur=""  <%=BarcodeRule_Disable%> value="<%=bean.checkForNull((String)hashDtl.get("barcode_id"))%>"></td>
		<%}else{%> 
		<td  class='fields'><input type=hidden name="barcode_id_<%=i%>" id="barcode_id_<%=i%>"></td>
		<%}%>
		
		
		
		
	</tr>
	<%	
	}
				y=i;
		}
		y++;
		ALExp.clear();
		for(int j=y;j<10;j++) {
		dflt_trade_id=(String)hashDtl.get("trade_id");	
		if(restrict_GRN_batch){//Added against GHL-CRF-0446 starts
				%>
				<tr>
					<td class='fields'>
						<input type='text' name="expiry_date_or_receipt_date_<%=j%>" id="expiry_date_or_receipt_date_<%=j%>" value="" size=10 maxlength=10 disabled><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=j%>');"  disabled ></img>
					</td>
					<td class='fields'>
						&nbsp;<input type='text' name="batch_id_<%=j%>" id="batch_id_<%=j%>" class="UPPER" value="" size=24 maxlength=20 disabled  >
						<input type=button name="batch_search_<%=j%>" id="batch_search_<%=j%>" class="button" onClick="callGRNBatchSearch(<%=j%>,'<%=locale%>')" value='?' >
					</td>
					<td class='fields'>
						<select name="trade_id_<%=j%>" id="trade_id_<%=j%>" value ="" disabled  >
						<option  value="" ><%=select_option_legend %></option>  </select>
					</td>
					<td class='fields'>
						<select name="bin_location_code_<%=j%>" id="bin_location_code_<%=j%>"  value=""  disabled >	
					<option  value="" ><%=select_option_legend %></option>  
						</select>
					</td>
					<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=j%>" id="barcode_id_<%=j%>" size=12 maxlength=20 class="NUMBER"  disabled value=""></td>				
					<td class='fields'>
						<input type='text' name="item_qty_<%=j%>" id="item_qty_<%=j%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" size=12 maxlength=12>
					</td>
				</tr>
				<%
		}
		else{//Added against GHL-CRF-0446 ends
	%>
	<tr>
		<td class='fields'>
			<input type='text' name="expiry_date_or_receipt_date_<%=j%>" id="expiry_date_or_receipt_date_<%=j%>" value="<%=expiry_date%>" size=10 maxlength=10 <%=disable_expiry_date%>  onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=j%>,<%=j%>,'<%=batch_id_applicable_yn%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,'<%=mrp%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=j%>');"  <%=disable_expiry_date%> ></img>
		</td>
		<td class='fields'>
			&nbsp;<input type='text' name="batch_id_<%=j%>" id="batch_id_<%=j%>" class="UPPER" value="<%=default_batch_id%>" size=24 maxlength=20 <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars(event);"  onchange="CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,'<%=mrp%>')">
		</td>
		<td class='fields'><%if(trade_id_applicable_yn.equals("Y")){%>
			<select name="trade_id_<%=j%>" id="trade_id_<%=j%>"   disabled ><%=bean.getTradeList(item_code,dflt_trade_id)%>		</select><%}else{%>
				<select name="trade_id_<%=j%>" id="trade_id_<%=j%>"  disabled ><%=bean.getTradeListDflt(dflt_trade_id)%></select><%}%>
		</td>
		<td class='fields'>
			<select name="bin_location_code_<%=j%>" id="bin_location_code_<%=j%>" onblur="CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,'<%=mrp%>')">
				<%=bean.getSTITBin_location_code_List(store_code,item_code,default_bin_location_code,locale)%>
			</select>
		</td>
		<!-- 		
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=j%>" id="item_qty_<%=j%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this); CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=j%>,expiry_date_or_receipt_date_<%=j%>,trade_id_<%=j%>,bin_location_code_<%=j%>,'<%=store_code%>',barcode_id_<%=j%>,item_qty_<%=j%>,'<%=mrp%>');" size=12 maxlength=12>
		</td>
		
		<%if(BarCodeApplicable){%>

			<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=j%>" id="barcode_id_<%=j%>" size=12 maxlength=20  class="NUMBER"  onKeyPress="return  CheckForSpecialChars(event);" onBlur=""  value=""></td>
		<%}else{%> 
		<td  class='fields'><input type=hidden name="barcode_id_<%=j%>" id="barcode_id_<%=j%>"></td>
		<%}%>
		
	</tr>
	<%
		}
	}
	}
	else {
		for(int i=0;i<10;i++) {	
			if(restrict_GRN_batch){//Added against GHL-CRF-0446 starts 
				%>
				<tr>
					<td class='fields'>
						<input type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="" size=10 maxlength=10 disabled><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>');"  disabled ></img>
					</td>
					<td class='fields'>
						&nbsp;<input type='text' name="batch_id_<%=i%>" class="UPPER" id="batch_id_<%=i%>" value="" size=24 maxlength=20 disabled  >
						<input type=button name="batch_search_<%=i%>" id="batch_search_<%=i%>" class="button" onClick="callGRNBatchSearch(<%=i%>,'<%=locale%>')" value='?' >
					</td>
					<td class='fields'>
						<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" value ="" disabled  >
						<option  value="" ><%=select_option_legend %></option>  </select>
					</td>
					<td class='fields'>
						<select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>"  value=""  disabled >	
					 <option  value="" ><%=select_option_legend %></option>   
						</select>
					</td>
					<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" size=12 maxlength=20 class="NUMBER"  disabled value=""></td>				
					<td class='fields'>
						<input type='text' name="item_qty_<%=i%>" id="item_qty_<%=i%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this); " size=12 maxlength=12>
					</td>
				</tr>
				<%
			}
			else{//Added against GHL-CRF-0446 ends
	%>
	<tr>
		<td class='fields'>
			<input type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=expiry_date%>" size=10 maxlength=10 onBlur="javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>,'<%=batch_id_applicable_yn%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" <%=disable_expiry_date%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal('expiry_date_or_receipt_date_<%=i%>');"  <%=disable_expiry_date%> ></img>
		</td>
		<td class='fields'>
			&nbsp;<input type='text' name="batch_id_<%=i%>" id="batch_id_<%=i%>" class="UPPER" value="<%=default_batch_id%>" size=24 maxlength=20 <%=disable_batch_id%> onKeyPress="return  CheckForSpecialChars(event);" onblur="CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" >
		</td>
		<td class='fields'><%if(trade_id_applicable_yn.equals("Y")){%>
			<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled  ><%=bean.getTradeList(item_code,dflt_trade_id)%></select><%}else{%>
				<select name="trade_id_<%=i%>" id="trade_id_<%=i%>" disabled ><%=bean.getTradeListDflt(dflt_trade_id)%></select><%}%>
				<% System.out.println("fr"+bean.getTradeListDflt(dflt_trade_id)); %>
		</td>
		<td class='fields'><select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>"  onblur="CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" >	<%=bean.getSTITBin_location_code_List(store_code,item_code,default_bin_location_code,locale)%>
			</select>
		</td>
	
		<!-- 		
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - For the field 'item_qty_' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class='fields'>
			<input type='text' name="item_qty_<%=i%>" id="item_qty_<%=i%>" class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this); CallNewBarcodeString('SplitBatchBean','eST.SplitBatchBean','<%=facility_id%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,item_qty_<%=i%>,'<%=mrp%>');" size=12 maxlength=12>
		</td>
		<%if(BarCodeApplicable){%>

			<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" size=12 maxlength=20 class="NUMBER" onKeyPress="return  CheckForSpecialChars(event);"  onBlur=""  <%=BarcodeRule_Disable%> value=""></td>
		<%}else{%> 
		<td  class='fields'><input type=hidden name="barcode_id_<%=i%>" id="barcode_id_<%=i%>"></td>
		<%}%>
		
	</tr>
	<%
		}
		}
	}
	%>
	 <tr>
		 <td colspan=7>&nbsp;</td>
	 </tr>
	<%	if(doc_srl_no!="-1") {%>
	<tr>
		<td colspan=3 class=WHITE></td>
		<td  colspan=2 class=WHITE><input type=button name=Modify value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' class=button onclick="addToList('modify');"><input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();"></td>
	</tr>
	<%}else{%>
	<tr>
		<td colspan=3 class=WHITE></td>
		<td  colspan=2 class=WHITE><input type=button name=Add value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class=button onclick="addToList('add');"><input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();"></td>
	</tr>
	<%}%>
</table>
    <input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
	<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
	<input type="hidden" name="item_desc" id="item_desc" value="<%=item_desc%>">
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="doc_date" id="doc_date" value="<%=doc_date%>">
	<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
	<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input type="hidden" name="doc_ref" id="doc_ref" value="<%=doc_ref%>">
	<input type="hidden" name="trn_type" id="trn_type" value="<%=trn_type%>">
	<input type="hidden" name="expiry_yn" id="expiry_yn" value="<%=expiry_yn%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="10">
	<input type="hidden" name="batch_id_applicable_yn" id="batch_id_applicable_yn" value="<%=batch_id_applicable_yn%>">
	<input type="hidden" name="trade_id_applicable_yn" id="trade_id_applicable_yn" value="<%=trade_id_applicable_yn%>">
	<input type="hidden" name="uom" id="uom" value="<%=uom%>">
	<input type="hidden" name="doc_srl_no" id="doc_srl_no" value="<%=(request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")%>">
	<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
	<!-- 		
			* @Name - Priya
			* @Date - 18/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To get the value, whether decimals are allowed to this item or not.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	<input type="hidden"		name="Barcode_app_yn" id="Barcode_app_yn"			 value="<%=BarCodeApplicable%>">
	<input type="hidden"		name="Barcode_" id="Barcode_"			        value="<%=bar_code%>">
	<input type="hidden"		name="index" id="index"			        value="<%=index%>">
	<input type="hidden"        name="bin_location_code_chk" id="bin_location_code_chk"		value="<%=default_bin_location_code%>">
	  
	  
	   <input type="hidden"     name="BarcodeRule" id="BarcodeRule"                value="<%=BarcodeRule%>">
	   <input type="hidden"     name="facility_id" id="facility_id"                value="<%=facility_id%>">
	   <input type="hidden"     name="no_of_batches_entered" id="no_of_batches_entered"		value="">
	    <input type="hidden"    name="manufacturer_id" id="manufacturer_id"				 value="<%=manufacturer_id%>" >
	    <input type="hidden"    name="supplier_id" id="supplier_id"					value="<%=supplier_id%>" >
	   <input type="hidden"     name="mrp" id="mrp"						     value="<%=mrp%>" >
 	   <input type="hidden"     name="restrict_GRN_batch" id="restrict_GRN_batch"						     value="<%=restrict_GRN_batch%>" ><!-- Added against GHL-CRF-0446  -->
 	   <input type="hidden"     name="allow_zero_batches" id="allow_zero_batches"						     value="<%=allow_zero_batches%>" ><!-- Added against GHL-CRF-0503  -->
 	   
	
	
	<script>
		if(document.forms[0].trade_id_0.length==1 && !<%=site%>)
		{
			alert(getMessage("TRADE_NOT_ASS_FOR_ITEM","ST"));
			parent.frameOpeningStockListHeader.location.reload();
			self.location.href="../../eCommon/html/blank.html";
		}
		 else if(document.forms[0].bin_location_code_0.length==1 && !<%=site%>)
		{
			alert(getMessage("BIN_LOCN_NOT_ASS_FOR_STORE","ST"));
			parent.frameOpeningStockListHeader.location.reload();
			self.location.href="../../eCommon/html/blank.html";
		}
	</script>
</form>
<%
putObjectInBean("splitBatchBean",bean,request);
putObjectInBean("stHeaderBean",beanHdr,request);
%>
	</body>
</html>
		<%}
	catch(Exception e)
	{
e.printStackTrace();
}%>

