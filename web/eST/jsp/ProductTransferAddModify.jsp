<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037673	   		Karthi	 					SRR20056-SCF-9532
21/02/2016		IN0057461			B.Badmavathi					ML-MMOH-CRF-0448
22/06/2017		IN0064609			B.Badmavathi					ML-BRU-SCF-1720
8/8/2021		TFS:21452        	Shazana                      	ML-MMOH-SCF-1861
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.*, eST.Common.* ,java.util.HashMap,java.util.ArrayList, eCommon.Common.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle			=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 <!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="javaScript" src="../../eST/js/ProductTransfer.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script> <!-- IN0037673-SRR20056-SCF-9532 -->

</head>
<% 
//  int i						=			0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String  saleprice= null; 
	String  saleprice1 = null;


	//mode						=			request.getParameter( "mode" ) ;//Commented for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi 
	//if(mode==null)	mode		=			"1";//Commented for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi 
	function_id					=			request.getParameter( "function_id" ) ;
	
	bean_id						=			"ProductTransferBean" ;
	bean_name					=			"eST.ProductTransferBean";

	ProductTransferBean bean	=			(ProductTransferBean) getBeanObject( "ProductTransferBean","eST.ProductTransferBean", request );
	bean.setLanguageId(locale);

	StHeaderBean beanHdr		=			(StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean" ,request);
	beanHdr.setLanguageId(locale);
    bean.setProductTransferHeaderBean(beanHdr);
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi starts
   		boolean site=bean.isSite_spec_yn();
		System.out.println("site======product transfer start jsp= in add modify====");
		System.out.println(site);
	 if(site){
		  mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		 if(request.getParameter( "doc_type_code" ) != null) {
		 mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY");	
		 
		 }
		
	 }
	 else{
	 mode							=		request.getParameter( "mode" ) ;
	if(mode==null)
				mode				=		"1";
	}
	
	 String item_vis_query			=		"disabled";
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi ends
	//String bin_location_code1	=			bean.getBinlocationCodeList();
    String bin_location_value	=			eST.Common.StRepository.getStKeyValue("DEFAULT_LIST_OPTION");

	String sys_date				=			"";
	sys_date					=			beanHdr.getSystemDate();
	 String facility_id	        =	beanHdr.getLoginFacilityId();  
	 String store_code=beanHdr.getStore_code();
    //String to_item_code = "" ;
	int EWDays					=			0;
//pmd 29/01/05
//int expired_batch				=			0;
	EWDays						=			bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
	HashMap hmTemp				=			(HashMap)bean.fetchRecord("select SALE_PRICE_APPL_YN from st_acc_entity_param");
	String  sale_price_appl_yn	=			 bean.checkForNull((String)hmTemp.get("SALE_PRICE_APPL_YN"),"N");

	//System.out.println("sale_price_appl_yn" +sale_price_appl_yn);
	int no_of_decimals1			=			bean.getNoOfDecimals();
	String noOfDecimalsForCost	=			bean.getNoOfDecimalsCost();
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi starts
	String doc_no 					= 		bean.checkForNull(request.getParameter( "doc_no" ));
	String doc_type_code			=		bean.checkForNull(request.getParameter( "doc_type_code" ));
	//System.out.print("DOC_TYPE_CODE============");System.out.print(doc_type_code);
	String store_desc = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_STORE_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	//Added for request number delete in unfinalized mode 
	String reques_no= bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_STORE_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("PROD_TFR_REQUEST_NO"),"");
	String NOD = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_NOD_EXP_PROD_TRF"),new String[]{doc_no}).get("NOD"),"");
	
		
	String from_item_code = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("ITEM_CODE"),"");
	String from_item_desc = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	String FM_STK_UOM_CONV_FACTOR = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_STK_UOM_CONV_FACTOR"),"");
	
	
	String TO_STK_UOM_CONV_FACTOR = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_STK_UOM_CONV_FACTOR"),"");
	String to_item_code1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("ITEM_CODE"),"");
	String to_item_desc1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	String to_uom_desc1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("UOM_DESC"),"");
	
	String from_uom_desc1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	String expiry_yn = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("EXPIRY_YN"),"");
	String AVAIL_QTY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("AVAIL_QTY"),"");
	String QTY_ON_HAND = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("QTY_ON_HAND"),"");
	
	
	String from_exp_date = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_EXPIRY_DATE"),"");
	String to_exp_date = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_EXPIRY_DATE"),"");	
	String from_batch_id = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_BATCH_ID"),"");
	String to_batch_id = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_ITEM_BATCH_ID"),"");	
	String from_item_qty = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_QTY"),"");
	String to_item_qty = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_ITEM_QTY"),"");	
	String to_item_exp_qty = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_ITEM_EXP_QTY"),"");	
	String FM_ITEM_EXP_BAL_QTY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_EXP_BAL_QTY"),"");
	String FM_ITEM_ACT_BAL_QTY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_ACT_BAL_QTY"),"");
	String NO_OF_LABELS_footer = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("NO_OF_LABELS"),"");
	
	
	String TO_TRADE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_NAME"),"");
	String TO_BIN_LOCN_CODE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("BIN_LOCATION_CODE"),"");
	String TO_BIN_LOCN_DESC = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_DESC"),"");
	String to_barcode = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("BARCODE_ID"),"");
	
	
	String FM_TRADE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_NAME"),"");
	String FM_TRADE_ID = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("TRADE_ID"),"");
	String FM_BIN_LOCN = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_DESC"),"");
	String FM_BIN_LOCN_CODE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("BIN_LOCATION_CODE"),"");
	String MANUFACTURER_ID = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("MANUFACTURER_ID"),"");
	String MANU_DESC = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("MANU_DESC"),"");
	
	
	String remarks1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("REMARKS"),"");
	String PACKED_BY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("PACKED_BY"),"");
	String COUNTER_CHECKED = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("COUNTER_CHECKED"),"");
	String AUTHORIZED_BY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("AUTHORIZED_BY"),"");
	String NO_OF_LABELS = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("NO_OF_LABELS"),"");
	String time_taken1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("TIME_TAKEN"),"");
	//Added for delete option working
String prt_delete_yn = bean.getMfg_delete_yn(); 
	//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi ends
    String item_code = request.getParameter("to_item_code")==null?"":request.getParameter("to_item_code");  
 	//System.out.println("item_code===72===>" +item_code);
    String  trn_type  = "PRT";
    String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	   //System.out.println("BARCODE_YN ===PRT==>"+BARCODE_YN);
	      boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facility_id,trn_type);
	      HashMap BarCodeRules = bean.getNewBarCodeRules(facility_id);
	     //System.out.println("BarCodeRules ===PRT==>"+BarCodeRules);
		String BarcodeRule = bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));
        // System.out.println("BarcodeRule ===PRT==>"+BarcodeRule);			
	     String BarcodeRule_Disable = "";
		 if(BarcodeRule.equals("P") ||BarcodeRule.equals("S") )
			BarcodeRule_Disable = "ReadOnly";
			
	 String site_id = bean.getCustomerID();
	//System.out.println("site_id" +site_id);
		 
	
%>

<body onLoad="FocusFirstElement();">
<form name="formProductTransferAddModify" id="formProductTransferAddModify" onReset="FocusFirstElement();">

<table border="0" cellpadding="2" cellspacing="0" width='100%'  align=center>

	<tr>
	   <th  colspan=10><fmt:message key="Common.TransferFrom.label" bundle="${common_labels}"/></th>
	</tr>

	<!-- <tr>
	  <td colspan=10>&nbsp;</td>
    </tr> -->

	<!-- <tr>
	<td align="right" class="LABEL"  colspan=6 nowrap>&nbsp;&nbsp;&nbsp;&nbsp;Prepare Location</td>
	 
	
	<td align='left' >&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc()%></select></td>
	<td align="left" class="LABEL"  nowrap>&nbsp;&nbsp;&nbsp;</td>
	<td align="left" class="LABEL"  nowrap>&nbsp;</td>
	
	</tr> -->


	<tr>
	 <td  class="LABEL"><label id='lblItem'><fmt:message key="Common.item.label" bundle="${common_labels}"/></label></td>
	  <td class='FIELDS'  colspan=3>&nbsp;&nbsp;
	  <!--<input maxLength=60 size=70 name="p_fm_item_desc" id="p_fm_item_desc" value="" onBlur='fn_check_for_item_validation_from()'> -->
	<!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->
	  <%if(site){if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){ %>
	  <input type=text name="p_fm_item_desc" id="p_fm_item_desc" size=70 maxlength=60 size=70 onkeypress="callBarCodeBatchSearchproduct(event, trn_type,parent.frameProductTransferHeader.document.formProductTransferHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>'); "    value=""   onBlur='fn_check_for_item_validation_from()' <%= mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))?item_vis_query:""%>>
	  <%}else{ %>
	  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi end -->
	  <input type=text name="p_fm_item_desc" id="p_fm_item_desc" size=70 maxlength=60 size=70 onkeypress="callBarCodeBatchSearchproduct(event, trn_type,parent.frameProductTransferHeader.document.formProductTransferHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>'); "    value="<%=from_item_desc %>"   onBlur='fn_check_for_item_validation_from()' <%= mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))?item_vis_query:""%>>
	  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
	  <%}}else{ %>
	  <input type=text name="p_fm_item_desc" id="p_fm_item_desc" size=70 maxlength=60 size=70 onkeypress="callBarCodeBatchSearchproduct(event, trn_type,parent.frameProductTransferHeader.document.formProductTransferHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>'); "    value=""   onBlur='fn_check_for_item_validation_from()' >
	  <%} %>
	  <input type=button name="item_search_from" id="item_search_from" class="button"  onClick="callItemSearchScreenFrom(event,trn_type,parent.frameProductTransferHeader.document.formProductTransferHeader.store_code,'' ,this.form,'<%=bean_id%>','<%=bean_name%>');"  value='?' <%= mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))?item_vis_query:""%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
	  <!--added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
	 <!-- <input type=button name="item_search_from" id="item_search_from" class="button" onClick="callItemSearchScreenFrom()"  value='?'  >&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td> -->
      <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->
      <%if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){ %>
      
     <td class="LABEL" ><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;&nbsp;<b><%=from_uom_desc1 %></b>
      <%}else{ %>
      <!--Added for ML-MMOH-CRF-0448 B.Badmavathi  ends-->
      <td id=fm_item_uom_desc  class='LABEL'  width='15%' style="visibility:visible">&nbsp;</td>
     <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->
      <%} %> 
	 <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	  <td class='FIELDS'><input type=button name="batch_search_from" id="batch_search_from" class="button"   disabled  onclick="callBatchSearchFrom();"  value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>'></td>
	 <%}else{ %>
	 <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends -->
	  <td class='FIELDS'><input type=button name="batch_search_from" id="batch_search_from" class="button"     onclick="callBatchSearchFrom();" disabled value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>'></td>
	  <%} %><!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->
	  <td  class="LABEL">&nbsp;</td>
	  <td  class="LABEL">&nbsp;</td>
    </tr>

	<tr>
	  <td colspan=10>&nbsp;</td>
    </tr>
    	
<!-- 	<TR>
	  <td id=fm_display_dtl_1 class="LABEL" colspan=10 align=left nowrap>&nbsp;</td>
	</tr>
 -->
     <tr>
	  <td id=fm_display_dtl_1_bl class="LABEL"  nowrap>&nbsp;</td>
	  <td id=fm_display_dtl_1_bt class="LABEL"  nowrap>&nbsp;</td>
	  <td id=fm_display_dtl_1_el class="LABEL"  nowrap>&nbsp;</td>
	  <td id=fm_display_dtl_1_et class="LABEL"  nowrap colspan='3'>&nbsp;</td>
	  <td id=fm_display_slp_1_el class="LABEL"   nowrap>&nbsp;</td>
	  <td id=fm_display_slp_1_et class="LABEL"   nowrap >&nbsp;</td>

	</tr>
	<tr>
	  <td colspan=10>&nbsp;</td>
    </tr>

    <tr>
	  <td id=fm_display_dtl_2 class="LABEL" colspan=2  nowrap>&nbsp;</td>
      <td  class="LABEL"><fmt:message key="eST.RepackSize.label" bundle="${st_labels}"/></td>
	 <!--Added for ML-MMOH-CRF-0448 B.Badmavathi  starts -->
	  <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	  <td class='FIELDS' >&nbsp;&nbsp;<input class="NUMBER" onkeypress="return isValidNumber(this,event,6,0);" maxLength=6 size=18 name="p_fm_factor" id="p_fm_factor" value="<%=FM_STK_UOM_CONV_FACTOR %>"  onBlur="return CheckForZeroFrom(this);">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
	  <%}else{ %>
	  <td class='FIELDS' >&nbsp;&nbsp;<input class="NUMBER" onkeypress="return isValidNumber(this,event,6,0);" maxLength=6 size=18 name="p_fm_factor" id="p_fm_factor" value="1"  onBlur="return CheckForZeroFrom(this);">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
	  <%} %> 
	  <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi  ends-->
	  <td  class="LABEL" nowrap><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="p_fm_quantity" id="p_fm_quantity" value="<%=from_item_qty %>" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals1%>);" onBlur="return checkWithAvlQty(this)" disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></td>
	 <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts --> 
	  <%}else{ %>
	  <td  class="LABEL" nowrap><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="p_fm_quantity" id="p_fm_quantity" value="" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals1%>);" onBlur="return checkWithAvlQty(this)">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></td>
	  <%} %>
	  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends -->
	  <td  class="LABEL" nowrap>&nbsp;</td>
	  <td  class="LABEL" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
	
   	<tr>
	  <td colspan=10>&nbsp;</td>
    </tr>
	
      
   <tr>
	   <th  colspan=10><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></th>
   </tr>  

   

   <tr>
	  <td  class="LABEL"><label id='lblItem_2'><fmt:message key="Common.item.label" bundle="${common_labels}"/></label></td>
	<!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->
	 <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	  <td  class='FIELDS' colspan=4>&nbsp;&nbsp;<input maxLength=60 size=70 name="p_to_item_desc" id="p_to_item_desc" value="<%=to_item_desc1 %>"   disabled><input type=button name="item_search_to" id="item_search_to" class="button" onClick="callItemSearchScreenTo()"   value='?' disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
	  <%}else{ %>
	  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
	  <td  class='FIELDS' colspan=4>&nbsp;&nbsp;<input maxLength=60 size=70 name="p_to_item_desc" id="p_to_item_desc" value=""   disabled><input type=button name="item_search_to" id="item_search_to" class="button" onClick="callItemSearchScreenTo()"   value='?' disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
	  <%} %>
	  
	  <%if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){ %>
      
     <td class="LABEL" ><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;&nbsp;<b><%=to_uom_desc1 %></b>
      <%}else{ %>
        <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
      <td id=to_item_uom_desc   class=label ></td>
      <%} %>   <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->
      
      
  	  
	  <td class=LABEL >&nbsp;</td>
	  <td class=LABEL >&nbsp;</td>
    </tr>
       <!-- Modified maxlength to 20 against ML-BRU-SCF-1720 starts -->
	<tr>
	  <td id=to_batch_id_name class="LABEL" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
	     <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
	   <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	    <td id=to_batch_id_val class='FIELDS'>&nbsp;&nbsp;<input maxLength=20 size=10 name="p_to_batch_id" id="p_to_batch_id" class="UPPER" value="<%=to_batch_id %>" disabled onKeyPress="return CheckForSpecChars(event);" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'  id="imgs" style="visibility:visible">
	      <%}else{ %>
	        <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
	  <%if(BarCodeApplicable){%>
      <td id=to_batch_id_val class='FIELDS'>&nbsp;&nbsp;<input maxLength=20 size=10 name="p_to_batch_id" id="p_to_batch_id" class="UPPER"  value="" onKeyPress="return CheckForSpecChars(event);"  onBlur="NewBarcodeid('ProductTransferBean','eST.ProductTransferBean','<%=facility_id%>',to_item_code,p_to_batch_id, p_to_expiry_date, to_trade_id, p_to_bin_location,store_code, to_barcode_id,p_actual_qty,sale_price)" disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'  id="imgs" style="visibility:visible">
	   <%}else{%> 
	   <td id=to_batch_id_val class='FIELDS'>&nbsp;&nbsp;<input maxLength=20 size=10 name="p_to_batch_id" id="p_to_batch_id" class="UPPER"  value="" onKeyPress="return CheckForSpecChars(event);" disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'  id="imgs" style="visibility:visible">
	   <%}}%>  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->
	          <!-- Modified maxlength to 20 against ML-BRU-SCF-1720 ends -->
      <td class="LABEL"  nowrap id=to_expiry_date_id>&nbsp;<fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td> 
	    <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
	   <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	    <td class='FIELDS'>&nbsp;&nbsp;<input type='text' onBlur="CheckDateLeap(this,'DMY','<%=locale%>')" maxLength=10 size=18 name="p_to_expiry_date" value="<%=to_exp_date %>" >&nbsp;
	  <img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onClick="return  showCalendar('p_to_expiry_date');" ></img>
	  &nbsp;<img src='../../eCommon/images/mandatory.gif' >&nbsp;&nbsp;&nbsp;</td> 
	   <%}else{ %>
	     <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
	   <%if(BarCodeApplicable){%>
      <td class='FIELDS'>&nbsp;&nbsp;<input type='text' onBlur="CheckDateLeap(this,'DMY','<%=locale%>'); NewBarcodeid('ProductTransferBean','eST.ProductTransferBean','<%=facility_id%>',to_item_code,p_to_batch_id,p_to_expiry_date,to_trade_id,p_to_bin_location,store_code,to_barcode_id,p_actual_qty,sale_price);" maxLength=10 size=18 name="p_to_expiry_date" id="p_to_expiry_date" value="" disabled>&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onClick="return  showCalendar('p_to_expiry_date');"  disabled></img>&nbsp;<img src='../../eCommon/images/mandatory.gif' >&nbsp;&nbsp;&nbsp;</td> <!--changed from CheckDate() to CheckDateLeap() for SRR20056-SCF-9532 [IN037673] -->
	   <%}else{%> 
	   <td class='FIELDS'>&nbsp;&nbsp;<input type='text' onBlur="CheckDateLeap(this,'DMY','<%=locale%>')" maxLength=10 size=18 name="p_to_expiry_date"  id="p_to_expiry_date" value="" disabled>&nbsp;
	  <img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onClick="return  showCalendar('p_to_expiry_date');" disabled></img>
	  &nbsp;<img src='../../eCommon/images/mandatory.gif' >&nbsp;&nbsp;&nbsp;</td> <!-- changed CheckDate() to CheckDateLeap() for SRR20056-SCF-9532 [IN037673] -->
	   <%}}%>  
     
     <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
     	 <td class="LABEL" ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>&nbsp;&nbsp;<b><%=TO_TRADE%></b>
     
     <%}else{ %>
      	<td id="to_trade_dtl" class="LABEL"  nowrap>&nbsp;</td>
      <%} %>
	 <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->
	  <%if(sale_price_appl_yn.equals("Y")) {%>
	  <td class="LABEL" nowrap><fmt:message key="eST.SalePrice.label" bundle="${st_labels}"/>&nbsp;<input type=text name="sale_price" id="sale_price" value="" size=12 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=noOfDecimalsForCost%>);" onblur=""><img src='../../eCommon/images/mandatory.gif' ></td>
	  <%}%>     
    </tr>
	<tr>
	  <td class="LABEL" ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
	    <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
	   <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	    
	  <td class='FIELDS'>&nbsp;&nbsp;<select name="p_to_bin_location" id="p_to_bin_location" ><%=bean.getBinlocationCodeList1(TO_BIN_LOCN_CODE,to_item_code1)%> </select>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td> 
	  
	   
	 <%}else{ %>
	   <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
	  <%if(BarCodeApplicable){%>
	  <td class='FIELDS'>&nbsp;&nbsp;<select name="p_to_bin_location" id="p_to_bin_location"  onchange ="NewBarcodeid('ProductTransferBean','eST.ProductTransferBean','<%=facility_id%>',to_item_code,p_to_batch_id,p_to_expiry_date,to_trade_id,p_to_bin_location,store_code,to_barcode_id,p_actual_qty,sale_price);"  onfocus='populateBinLocation();' disabled><%=bin_location_value%></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>  
	    <%}else{%> 
	  <td class='FIELDS'>&nbsp;&nbsp;<select name="p_to_bin_location" id="p_to_bin_location"  onfocus='populateBinLocation();' disabled><%=bin_location_value%></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td> 
	   <%}%>
	 <%} %>  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->
	  <td  class="LABEL"><fmt:message key="eST.Factor.label" bundle="${st_labels}"/></td>
	    <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
	   <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	  <td class='FIELDS'>&nbsp;&nbsp;<input class="NUMBER" onkeypress="return isValidNumber(this,event,12,6);" maxLength=12 size=18 name="p_to_factor" id="p_to_factor" value="<%=TO_STK_UOM_CONV_FACTOR %>"  onBlur="return CheckForZeroFrom(this);" >&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
		<% }else{%>
		  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
		<td class='FIELDS'>&nbsp;&nbsp;<input class="NUMBER" onkeypress="return isValidNumber(this,event,12,6);" maxLength=12 size=18 name="p_to_factor" id="p_to_factor" value="1"  onBlur="return CheckForZeroFrom(this);" disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
		<%} %>  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->
		 
		<td  id=p_to_quantity width='5%' class="LABEL" ><fmt:message key="eST.ExpectedQuantity.label" bundle="${st_labels}"/></td>
		<td class="LABEL" nowrap><fmt:message key="eST.ActualQuantity.label" bundle="${st_labels}"/>&nbsp;<input type=text name=p_actual_qty value="" size=12 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals1%>);" onblur="computeLabel();"><img src='../../eCommon/images/mandatory.gif' ></td>
		<td  class='LABEL' ></td> 
      </tr>
	  
		<tr>
		<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
		<%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
       <%if(BarCodeApplicable){%>
	  <td class = 'LABEL'><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></td>
	 <td  class='fields'  >&nbsp;&nbsp;<input type=text name="to_barcode_id" id="to_barcode_id" size=15 maxlength=20 class="NUMBER"  onKeyPress="return  CheckForSpecialChars(event);" onBlur=""  value="<%=to_barcode %>" ></td>	
     <% if(site_id.equals("MOHBR")){%>	 
	  <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/> 
	  <input type='radio' id="label_reqd_yn_1"  name="label_reqd_yn" id="label_reqd_yn"  value="B" onClick="no_of_labels.disabled=!this.checked;enabledisable(); setreport();">
	  </td>
	  <td class=LABEL ><fmt:message key="eST.LabelwithBarcode.label" bundle="${st_labels}"/> 
	  <input type='radio'  id="label_reqd_yn_2"  name='label_reqd_yn' id='label_reqd_yn'  value="L" onClick="no_of_labels.disabled=!this.checked;enabledisable(); setreport();">
	  </td>
	  <%}else{%>
	      <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/></td>
	     <!--  Added for no of labels start -->
	<%	if(!NO_OF_LABELS.equals("")){
			%>
			<td  class='fields' >&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' id="label_reqd_yn_2" value="N" checked  onClick="checklabelyn(); setreport();" ></td>
			<%}
		else{
			%>
			<td  class='fields' >&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' id="label_reqd_yn_2" value="N"  onClick="no_of_labels.disabled=!this.checked;checklabelyn(); setreport();" ></td>
		<%}
		%>
		<!--  Added for no of labels end -->
		
	  <%}%>
	 <td  class='LABEL'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/> 
		 <input type=text name='no_of_labels' id='no_of_labels' size=10 maxlength=15 class="NUMBER" onKeyPress="return isValidInteger();"  value="<%=NO_OF_LABELS_footer%>" disabled></td>
		<td  class='LABEL'  id=p_expect_bal_qty  width='5%' ><fmt:message key="eST.ExpectedBalanceQuantity.label" bundle="${st_labels}"/></td>
		<td  class='LABEL' nowrap><fmt:message key="eST.ActualBalanceQty.label" bundle="${st_labels}"/>&nbsp;<input type=text name=p_expect_act_qty value="<%=FM_ITEM_ACT_BAL_QTY %>" size=12 maxlength=12 class="NUMBER"   onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals1%>);"   onblur='checkForValidFactor();' ><img src='../../eCommon/images/mandatory.gif' align='center'></td>
		<td  class=LABEL></td>
		 <%}else{%>
		 <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/></td>
		 
		 <!--for hsa  no of labels start -->
		 <%	if(!NO_OF_LABELS.equals("")){
			%>
			<td  class='FIELDS' >&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' id="label_reqd_yn_2" value="N" checked  onClick="checklabelyn(); setreport();" ></td>
			<%}
		else{
			%>
			
			<td  class='FIELDS' >&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' id="label_reqd_yn_2" value="N" onClick="no_of_labels.disabled=!this.checked;checklabelyn(); setreport();"></td>
		<%}
		%>
		 <!--for hsa  no of labels start -->
		 
		<!--<td  class='fields' >&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' id="label_reqd_yn_2" value="N" onClick="no_of_labels.disabled=!this.checked;checklabelyn(); setreport();"></td> for hsa -->
		<td  class='LABEL'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/></td>
		<td   class='fields'>&nbsp;&nbsp;<input type=text name='no_of_labels' id='no_of_labels' size=10 maxlength=15 class="NUMBER" onKeyPress="return isValidInteger();"  value="<%=NO_OF_LABELS_footer%>" disabled></td>
		<td  class='LABEL'  id=p_expect_bal_qty  width='5%' ><fmt:message key="eST.ExpectedBalanceQuantity.label" bundle="${st_labels}"/></td>
		<td  class='LABEL' nowrap><fmt:message key="eST.ActualBalanceQty.label" bundle="${st_labels}"/>&nbsp;<input type=text name=p_expect_act_qty value="<%=FM_ITEM_ACT_BAL_QTY %>" size=12 maxlength=12 class="NUMBER"   onKeyPress="allow_restrict_decimals(this,event);"   onblur='checkForValidFactor();' ><img src='../../eCommon/images/mandatory.gif' align='center'></td>
		<td  class=LABEL></td>
		 
		 <%}%>
		 <%}else{ %>
		 <!--//Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
		        <%if(BarCodeApplicable){%>
	  <td class = 'LABEL'><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></td>
	 <td  class='fields'  >&nbsp;&nbsp;<input type=text name="to_barcode_id" id="to_barcode_id" size=15 maxlength=20 class="NUMBER"  onKeyPress="return  CheckForSpecialChars(event);" onBlur=""  <%=BarcodeRule_Disable%>  ></td>	
     <% if(site_id.equals("MOHBR")){%>	 
	  <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/> 
	  <input type='radio' id="label_reqd_yn_1"  name="label_reqd_yn" id="label_reqd_yn"  value="B" onClick="no_of_labels.disabled=!this.checked;enabledisable(); setreport();">
	  </td>
	  <td class=LABEL ><fmt:message key="eST.LabelwithBarcode.label" bundle="${st_labels}"/> 
	  <input type='radio'  id="label_reqd_yn_2"  name='label_reqd_yn' id='label_reqd_yn'  value="L" onClick="no_of_labels.disabled=!this.checked;enabledisable(); setreport();">
	  </td>
	  <%}else{%>
	      <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/></td>
		<td  class='fields' >&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' id="label_reqd_yn_2" value="N" onClick="no_of_labels.disabled=!this.checked;checklabelyn(); setreport();"></td>
	  <%}%>
	 <td  class='LABEL'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/> 
		 <input type=text name='no_of_labels' id='no_of_labels' size=10 maxlength=15 class="NUMBER" onKeyPress="return isValidInteger();"  value="<%=NO_OF_LABELS %>" ></td><!--Changed for ML-MMOH-CRF-0448 B.Badmavathi -->
		<td  class='LABEL'  id=p_expect_bal_qty  width='5%' ><fmt:message key="eST.ExpectedBalanceQuantity.label" bundle="${st_labels}"/></td>
		<td  class='LABEL' nowrap><fmt:message key="eST.ActualBalanceQty.label" bundle="${st_labels}"/>&nbsp;<input type=text name=p_expect_act_qty value="" size=12 maxlength=12 class="NUMBER"   onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals1%>);"   onblur='checkForValidFactor();' ><img src='../../eCommon/images/mandatory.gif' align='center'></td>
		<td  class=LABEL></td>
		 <%}else{%>
		 <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/></td>
		<td  class='fields' >&nbsp;<input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' id="label_reqd_yn_2" value="N" onClick="no_of_labels.disabled=!this.checked;checklabelyn(); setreport();"></td>
		<td  class='LABEL'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/></td>
		<td   class='fields'>&nbsp;&nbsp;<input type=text name='no_of_labels' id='no_of_labels' size=10 maxlength=15 class="NUMBER" onKeyPress="return isValidInteger();"  value="<%=NO_OF_LABELS %>" ></td><!--Changed for ML-MMOH-CRF-0448 B.Badmavathi -->
		<td  class='LABEL'  id=p_expect_bal_qty  width='5%' ><fmt:message key="eST.ExpectedBalanceQuantity.label" bundle="${st_labels}"/></td>
		<td  class='LABEL' nowrap><fmt:message key="eST.ActualBalanceQty.label" bundle="${st_labels}"/>&nbsp;<input type=text name=p_expect_act_qty value="" size=12 maxlength=12 class="NUMBER"   onKeyPress="allow_restrict_decimals(this,event);"   onblur='checkForValidFactor();' ><img src='../../eCommon/images/mandatory.gif' align='center'></td>
		<td  class=LABEL></td>
		 
		 <%}%><!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->
		 <%} %>
		<!-- <td align='right'class='LABEL' colspan=3></td>
		<td align='left'class='LABEL' ></td>
		<td align='left' class='LABEL'  id=p_expect_bal_qty  width='5%' >Expect Bal Qty</td>
		<td align='left' class='LABEL' nowrap>Actual Bal Qty
		<input type=text name=p_expect_act_qty value="" size=7 maxlength=8 class="NUMBER" onKeyPress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);"  onblur='checkForValidFactor();' ></td>
		<td align='right' class='LABEL' ></td> -->
	</tr>

    
<tr>
		<th  colspan='10'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>	
    </tr>
  
    <!-- <tr>
		<td align="right" class="LABEL">Packed By</td>
		<td class=LABEL colspan=9>&nbsp;&nbsp;<input maxLength=30 size=30 name="p_packed_by" id="p_packed_by" value="<%=session.getValue("login_user")%>" readOnly></td>
	</tr> -->
	<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
<%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
	<tr>
		<td  class=LABEL><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class='fields' colspan=9>&nbsp;&nbsp;<TEXTAREA id=TEXTAREA1 cols=95 rows=2 name='remarks' onKeyPress="return false;" disabled><%=remarks1%></TEXTAREA><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >	
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
	</tr>
	<tr>
		<td  class="LABEL"  nowrap><fmt:message key="Common.PackedBy.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=2>&nbsp;&nbsp;<input maxLength=30 size=35 name="p_packed_by" id="p_packed_by" value="<%=PACKED_BY%>" ></td>
		<td  class="LABEL" nowrap ><fmt:message key="eST.CounterChecked.label" bundle="${st_labels}"/> </td>
		<td  class='fields' nowrap colspan=2>&nbsp;&nbsp;<input type='text' maxLength=30 size=35 name="p_counter_chk" id="p_counter_chk" value="<%=COUNTER_CHECKED %>" ></td>

		
		<td  class="LABEL" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    </tr>
	<tr>
		<td  class="LABEL" nowrap><fmt:message key="Common.TimeTaken.label" bundle="${common_labels}"/></td>
		<td  class='fields' colspan=2>&nbsp;&nbsp;<input name='time_taken' id='time_taken' maxLength=5 size=3 onKeyPress='return allowValidNumber(event);' onblur='validateLength(this);chkCustomTime(this);' value="<%=time_taken1 %>" >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
		<td  class="LABEL" nowrap ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=2>&nbsp;&nbsp;<input maxLength=30 size=35 name="p_auth_by" id="p_auth_by" value="<%=AUTHORIZED_BY %>" ></td>
		<td  class="LABEL" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		
	</tr>
	<%}else{ %>
	<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
	<tr>
		<td  class=LABEL><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class='fields' colspan=9>&nbsp;&nbsp;<TEXTAREA id=TEXTAREA1 cols=95 rows=2 name='remarks' onKeyPress="return false;" disabled></TEXTAREA><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
	</tr>
	<tr>
		<td  class="LABEL"  nowrap><fmt:message key="Common.PackedBy.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=2>&nbsp;&nbsp;<input maxLength=30 size=35 name="p_packed_by" id="p_packed_by" value="<%=session.getValue("login_user")%>" ></td>
		<td  class="label" nowrap ><fmt:message key="eST.CounterChecked.label" bundle="${st_labels}"/> </td>
		<td  class='fields' nowrap colspan=2>&nbsp;&nbsp;<input type='text' maxLength=30 size=35 name="p_counter_chk" id="p_counter_chk" value="" ></td>

		
		<td  class="LABEL" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    </tr>
	<tr>
		<td  class="LABEL" nowrap><fmt:message key="Common.TimeTaken.label" bundle="${common_labels}"/></td>
		<td  class='fields' colspan=2>&nbsp;&nbsp;<input name='time_taken' id='time_taken' value=""  maxLength=5 size=3 onKeyPress='return allowValidNumber(event);' onblur='validateLength(this);chkCustomTime(this);' >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
		<td  class="LABEL" nowrap ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=2>&nbsp;&nbsp;<input maxLength=30 size=35 name="p_auth_by" id="p_auth_by" value="" ></td>
		<td  class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		
	</tr>
	<%} %><!--//Added for ML-MMOH-CRF-0448 B.Badmavathi -->
       <%if(!sale_price_appl_yn.equals("Y")) {%>
	   <td  class='fields'><input type=hidden name="sale_price" id="sale_price"></td>
	   <%}%>
</table>

		
		<input type="hidden"	name="fm_uom_code" id="fm_uom_code"						value="">
		<input type="hidden"	name="to_uom_code" id="to_uom_code"						value="">
		<input type="hidden"	name="repack_group1" id="repack_group1"					value="">
		<input type="hidden"	name="repack_group2" id="repack_group2"					value="">
		<input type="hidden"	name="eqvlvalue" id="eqvlvalue"						value="">
		<input type="hidden"	name="fm_bin_location_code" id="fm_bin_location_code"				value="">
		<input type="hidden"	name="p_act_expect_bal_qty" id="p_act_expect_bal_qty"				value="">
		<input type="hidden"	name="p_no_of_label" id="p_no_of_label"					value="">
		<input type="hidden"	name="fm_expiry_date" id="fm_expiry_date"					value="">
		<input type="hidden"	name="fm_batch_id" id="fm_batch_id"						value="">
		<input type="hidden"	name="to_quantity" id="to_quantity"						value="">
		<input type="hidden"	name="sys_date" id="sys_date"							value="<%=sys_date%>">
		<input type="hidden"	name="fm_item_unit_cost" id="fm_item_unit_cost"				value="">
		<input type="hidden"	name="to_item_unit_cost" id="to_item_unit_cost"				value="">
		<input type="hidden"	name="to_item_unit_price" id="to_item_unit_price"				value="">
		<input type="hidden"	name="fm_trade_id" id="fm_trade_id"						value="">
		<input type="hidden"	name="to_trade_id" id="to_trade_id"						value="">
		<input type="hidden"	name="store_code" id="store_code"						value="">
		<input type="hidden"	name="fm_trade_id_applicable_yn" id="fm_trade_id_applicable_yn"		value="">
		<input type="hidden"	name="from_req_trade_id_applicable_yn" id="from_req_trade_id_applicable_yn"  value="">
		<input type="hidden"	name="from_uom_desc" id="from_uom_desc"					value="">
		<input type="hidden"	name="too_uom_desc" id="too_uom_desc"						value="">
		<input type="hidden"	name="from_item_desc" id="from_item_desc"					value="<%=from_item_desc%>">  <!--Changed for ML-MMOH-CRF-0448 B.Badmavathi -->
		<input type="hidden"	name="too_item_desc" id="too_item_desc"					value="">
		<input type="hidden"	name="to_req_trade_id_applicable_yn" id="to_req_trade_id_applicable_yn"	value="">
		<input type="hidden"	name="to_req_batch_id_applicable_yn" id="to_req_batch_id_applicable_yn"	value="">
		<input type="hidden"	name="from_req_batch_id_applicable_yn" id="from_req_batch_id_applicable_yn"  value="">
		<input type="hidden"	name="to_trade_id_applicable_yn" id="to_trade_id_applicable_yn"		value="">
		<input type="hidden"	name="from_uom" id="from_uom"							value="">
		<input type="hidden"	name="to_uom" id="to_uom"							value="">
		<input type="hidden"	name="fm_expiry_yn" id="fm_expiry_yn"						value="">
		<input type="hidden"	name="to_expiry_yn" id="to_expiry_yn"						value="">
		<input type="hidden"	name="doc_srl_no" id="doc_srl_no"						value="-1">
		<input type="hidden"	name="next_batch_id" id="next_batch_id"					value="">
		<input type="hidden"	name="to_batch_id_applicable_yn_1" id="to_batch_id_applicable_yn_1"		value="" >
		<input type="hidden"	name="from_store_code" id="from_store_code"					value="">
		<input type="hidden"	name="auto_gen_batch_yn" id="auto_gen_batch_yn" >
		<input type="hidden"	name="mode" id="mode"								value="<%=mode%>">
		<input type="hidden"	name="prod_transfer_mode" id="prod_transfer_mode"				value="<%=mode%>"><!-- ML-MMOH-SCF-1861 -->
		<input type="hidden"	name="doc_no" id="doc_no"				value="<%=doc_no%>">
		<input type="hidden"	name="doc_type_code" id="doc_type_code"				value="<%=doc_type_code%>"><!-- end -->		
		<input type="hidden"	name="bean_id" id="bean_id"							value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"						value="<%= bean_name %>">
		<input type="hidden"	name="function_id" id="function_id"						value="<%= function_id %>">
		<input type="hidden"	name="expired_batch" id="expired_batch"					value="">
		<input type="hidden"	name="ex_param_days" id="ex_param_days"					value="<%=EWDays%>">
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id"						value="">
		<input type="hidden"	name="request_no" id="request_no"						value="<%=reques_no%>">
		<input type="hidden"	name="lang_id" id="lang_id"							value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"					value="PRT">
		<!--<input type="hidden" name="to_bin_location_code" id="to_bin_location_code"				value="">  -->
		<!--<input type="hidden" name="from_item_code" id="from_item_code"						value="">
		<input type="hidden" name="too_item_code" id="too_item_code"						value=""> -->
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden" name="allow_deci_yn_from" id="allow_deci_yn_from"				value="">
		<input type="hidden" name="no_deci_from" id="no_deci_from"				value="">
		<input type="hidden" name="allow_deci_yn_to" id="allow_deci_yn_to"				value="">
		<input type="hidden" name="no_deci_to" id="no_deci_to"				value="">

		<input type="hidden" name="fr_sale_price" id="fr_sale_price"				value="">
		<input type="hidden" name="episode_type" id="episode_type"				value="I">
		<input type="hidden" name="sale_price_appl_yn" id="sale_price_appl_yn"						value="<%=sale_price_appl_yn%>">
		<input type="hidden" name="no_of_decimals" id="no_of_decimals"						value="<%=no_of_decimals1%>">
		<!-- 04/05/12 -->
		<input type="hidden"    name="trn_type" id="trn_type"							    value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"							value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"					value="<%=BarCodeApplicable%>" >
		<input type="hidden"    name="fm_barcode" id="fm_barcode"				value="">
		<input type="hidden"    name="manufacturer_id" id="manufacturer_id"						value="" >
	   <input type="hidden"     name="supplier_id" id="supplier_id"						value="" >
	   <input type="hidden"     name="mrp" id="mrp"						value="" >
	   <input type="hidden"    name="BarcodeRule" id="BarcodeRule" value="<%=BarcodeRule%>">
	   <input type="hidden"    name="facility_id" id="facility_id" value="<%=facility_id%>">
	    <input type="hidden"    name="site_id" id="site_id" value="<%=site_id%>">
	  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
	   <input type="hidden"	name="finalize_allowed_yn" id="finalize_allowed_yn"	value="N">
	   <input type="hidden"	name="site" id="site"			value="<%=site %>">
	   <input type="hidden"	name="from_exp_date" id="from_exp_date"		value="<%=from_exp_date%>">
	   <input type="hidden"	name="store_desc" id="store_desc"		value="<%=store_desc%>">
	   <input type="hidden"	name="FM_BIN_LOCN" id="FM_BIN_LOCN"		value="<%=FM_BIN_LOCN%>">
	   <input type="hidden"	name="FM_BIN_LOCN_CODE" id="FM_BIN_LOCN_CODE"		value="<%=FM_BIN_LOCN_CODE%>">
	   <input type="hidden"	name="FM_TRADE" id="FM_TRADE"			value="<%=FM_TRADE%>">
	   <input type="hidden"	name="FM_TRADE_ID" id="FM_TRADE_ID"		value="<%=FM_TRADE_ID%>">
	   <input type="hidden"	name="MANUFACTURER_ID" id="MANUFACTURER_ID"		value="<%=MANUFACTURER_ID%>">
	   <input type="hidden"	name="MANU_DESC" id="MANU_DESC"		value="<%=MANU_DESC%>">
	   <input type="hidden"	name="expiry_yn" id="expiry_yn"		value="<%=expiry_yn%>">
	   <input type="hidden"	name="QTY_ON_HAND" id="QTY_ON_HAND"		value="<%=QTY_ON_HAND%>">
	   <input type="hidden"	name="AVAIL_QTY" id="AVAIL_QTY"		value="<%=AVAIL_QTY%>">
	   <input type="hidden"	name="NOD" id="NOD"			value="<%=NOD%>">
	   <input type="hidden" 	name="from_item_code" id="from_item_code"						value="<%=from_item_code%>">
	   <input type="hidden" 	name="from_batch_id" id="from_batch_id"						value="<%=from_batch_id%>">
	   <input type='hidden'	 name="finalize_yn" id="finalize_yn"				 value="Y">
	  <%-- added for delete action working --%>
	   <input type='hidden'	 name="prt_delete_yn" id="prt_delete_yn"				 value="<%=prt_delete_yn%>"> 
	   <%if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ %>
		<input type="hidden"	name="to_batch_id" id="to_batch_id"						value="<%=to_batch_id%>">
		<input type="hidden"	name="fm_item_code" id="fm_item_code"						value="<%=from_item_code%>">
		<input type="hidden"	name="to_item_code" id="to_item_code"						value="<%=to_item_code1%>">
	   <%}else{ %>
		<input type="hidden"	name="to_batch_id" id="to_batch_id"						value="">
		<input type="hidden"	name="fm_item_code" id="fm_item_code"						value="">
		<input type="hidden"	name="to_item_code" id="to_item_code"						value="">
	   <%} %>
	   <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
	   
</form>

</form>
<%
	putObjectInBean("ProductTransferBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);

%>
<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
<script type="text/javascript">
<%if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))%>
	callBatchSearchFrom1();clearMessageFrame();ComputeToQuantity();
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
</body>
</html>

