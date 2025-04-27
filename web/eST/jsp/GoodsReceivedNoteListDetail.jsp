<!DOCTYPE html>
 <%  
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
22/4/2021		TFS:14012				Shazana			22/4/2021	   			Manickam				MO-CRF-20165 
23/04/2022		23925					Ramesh Goli		23/04/2022			RAMESH G    			MO-CRF-20171
-------------------------------------------------------------------------------------------------------------------------------------------- 
*/
%>
 
 <%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*,java.sql.* ,webbeans.eCommon.*" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<%
	request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String facilityid=(String)session.getValue("facility_id");
		Connection con				= null; //Added for MO-CRF-20165  
		con						= ConnectionManager.getConnection(request);
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
	<script language="javaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
try{
	//23925 Start.
	java.util.Date myDate = new java.util.Date();
	SimpleDateFormat mdyFormat = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
	String formatedDate=mdyFormat.format(myDate);
	//23925 End.	
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean) getBeanObject( "goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean", request  );
	bean.setLanguageId(locale); 	   
	ArrayList alExpRecords	=	new ArrayList();
	HashMap hmTmpExpRecords =   new HashMap();
	String	sys_date		=	bean.getSysDate();
	//To set values in GoodsReceivedNoteBean
	String exp_disp_date="";
	String manufactured_date = ""; //added for MO-CRF-20165 
	String	item_code = request.getParameter("item_code");
	String	index = bean.checkForNull(request.getParameter("index"),"-1");

	//String	flag = bean.checkForNull(request.getParameter("flag"),"X");
	String allow_deci_yn = "";
    String no_deci    = "";
    allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";

	if (item_code==null) {
		return;
	}
	HashMap hmItemRecord		=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_FOR_GRN"),item_code);
	HashMap hmTemp	=	(HashMap)bean.fetchRecord("select LESSER_SALE_PRICE_YN,SALE_PRICE_APPL_YN from st_acc_entity_param");
	
	//String external_po_yn			=	bean.checkForNull((String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");

	HashMap PO_Interface			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")});
	
	String po_interface_yn			=	bean.checkForNull((String)PO_Interface.get("PO_INTERFACE_YN"),"N");
	String external_po_yn			=	bean.checkForNull((String)PO_Interface.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");


	if(po_interface_yn.equals("Y")){
	external_po_yn = "N";
	}

	//Added by Rabbani #inc no:30127 on 09/01/11
	boolean flaggrn = bean.isCreateGRNApplicable(facilityid,"GRN");
	boolean grn_newfields_applicable = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_NEW_FIELDS");//added for MO-CRF-20165 START
	String mnaufactured_date_legend=""; //END 
	
	String  lesser_sale_price_yn	=bean.checkForNull((String)hmTemp.get("LESSER_SALE_PRICE_YN"),"N");
	String  sale_price_appl_yn		=bean.checkForNull((String)hmTemp.get("SALE_PRICE_APPL_YN"),"N");
	String  batch_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("BATCH_ID_APPLICABLE_YN"),"N");
	String	trade_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("TRADE_ID_APPLICABLE_YN"),"N");
	String	expiry_yn				=bean.checkForNull((String)hmItemRecord.get("EXPIRY_YN"),"N");	
	// default batch_id to be fetched from mm_parameter
	String disable_batch_id="";
	String disable_expiry_date="";
	String expiry_date="";
	String default_batch_id="";
	String default_trade_id="";
	String default_trade_id_new ="";
//	String date_legend="Expiry Dt";
	String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
	if(expiry_yn.equals("N")) {
		expiry_date = sys_date;
		disable_expiry_date="disabled";
//		date_legend="Receipt Dt";
		date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
	}		
	if(grn_newfields_applicable){//MO-CRF-20165 
		mnaufactured_date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ManufacturedDate.label","st_labels"); 
	}
	if(trade_id_applicable_yn.equals("N")) {
		default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
	}

	if(batch_id_applicable_yn.equals("N")) {
		disable_batch_id="disabled";
		default_batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
	}
	else if(batch_id_applicable_yn.equals("E")) {
		if(expiry_yn.equals("Y")) {
			if (!expiry_date.equals("")) {
				default_batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
			}
		}
		disable_batch_id="disabled";			
	}
	if(!index.equals("-1") && po_interface_yn.equals("N")){
		ArrayList alTmpExpRecords=(ArrayList)bean.getExpRecords(Integer.parseInt(index.trim()));
		hmTmpExpRecords=(HashMap)alTmpExpRecords.get(0);
	}

	/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

	boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facilityid,"GRN");
	HashMap BarCodeRules		=	bean.getNewBarCodeRules(facilityid);
	String BarcodeRule			=   bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));	
	String BarcodeRule_Disable="";
	if(BarcodeRule.equals("P") || BarcodeRule.equals("S"))
	BarcodeRule_Disable = "Readonly";
	
	String manufacturer_id	= bean.checkForNull(request.getParameter("manufacturer_id"));//added for MO-CRF-20165
	String supplier_id		= bean.checkForNull(request.getParameter("supplier_id"));
	String store_code =bean.getStore_code();

	String by_po = bean.checkForNull((String)request.getParameter("by_po"),"N");
 	String by_do,by_do_disable = "";
	
	String shelf_life	=	bean.checkForNull((String)bean.fetchRecord("select SHELF_LIFE from MM_ITEM_LANG_VW where ITEM_CODE = ? and LANGUAGE_ID= ?",new String[]{item_code,locale}).get("SHELF_LIFE"),"N");
	String shelf_life_no = "";
	String shelf_life_time = "";
	if(shelf_life != null && shelf_life.length() > 0){
		 shelf_life_time = shelf_life.substring(shelf_life.length() - 1);
		 shelf_life_no = shelf_life.substring(0,shelf_life.length() - 1);
	}
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String shelfLifeDate	       = "";
	int s_life = 0 ;
	if(!shelf_life_no.equals(""))
		s_life = Integer.parseInt(shelf_life_no);
	if(shelf_life_time.equals("D")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"d");
	}else if(shelf_life_time.equals("M")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"M");
	}else if(shelf_life_time.equals("Y")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"Y");
	}
	int size = 10; //added for MO-CRF-20165 
%>

<body>
<form name="formGoodsReceivedNoteListDetail" id="formGoodsReceivedNoteListDetail" action="../../servlet/eST.DocUploadServlet" method="post"  enctype='multipart/form-data' >  <!-- Added action and enctype properties for //23925 -->
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>
	<tr>
		<th nowrap><%=date_legend%></th>
		<%if(grn_newfields_applicable){ %> <!-- Added for MO-CRF-20165 -->
		<th><%=mnaufactured_date_legend%></th> 
		<%} %>
		<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<%if(BarCodeApplicable){%>
		<th><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></th>
		<%}%>
		<%if(sale_price_appl_yn.equals("Y")){%>
			<th nowrap>Sale Price/<%=bean.checkForNull(request.getParameter("gen_uom_desc"),bean.checkForNull((String)bean.getGenItemUOMDesc(item_code)))%></th>
		<%}%>
		<th>Uploaded Document</th> <!-- //23925 -->
	<% 
	//int size = 10;//added above for MO-CRF-20165 
	if(!index.equals("-1") && by_po.equals("N"))
		alExpRecords=bean.getExpRecords(Integer.parseInt(index.trim()));
	else if(!index.equals("-1") && by_po.equals("Y")){
		//alExpRecords=bean.getDoExpRecordsList(item_code);
		ArrayList alExpRecordsGroup=bean.getDoExpRecords(item_code);
 	if(alExpRecordsGroup != null){
		ArrayList alTempdetail = new ArrayList();
		for(int l=0;l<alExpRecordsGroup.size();l++){
			HashMap alExp = (HashMap)alExpRecordsGroup.get(l);
				HashMap hmTempdetail = new HashMap();
					hmTempdetail.put("grn_item_qty", (String)alExp.get("grn_item_qty"));             
					hmTempdetail.put("trade_id", (String)alExp.get("trade_id"));                 
					hmTempdetail.put("expiry_date_or_receipt_date", (String)alExp.get("expiry_date_or_receipt_date"));
					hmTempdetail.put("item_code", (String)alExp.get("item_code"));                
					hmTempdetail.put("store_code", (String)alExp.get("store_code"));               
					hmTempdetail.put("dist_store_code",(String) alExp.get("dist_store_code"));               
					hmTempdetail.put("batch_id", (String)alExp.get("batch_id"));                 
					hmTempdetail.put("do_no", (String)alExp.get("do_no"));                 
					hmTempdetail.put("po_no", (String)alExp.get("po_no"));                 
					hmTempdetail.put("do_srl_no", (String)alExp.get("do_srl_no"));                 
					hmTempdetail.put("dist_facility_id", (String)alExp.get("dist_facility_id"));                 
					hmTempdetail.put("sch_delv_date", (String)alExp.get("sch_delv_date"));      
					hmTempdetail.put("by_do", (String)alExp.get("by_do"));      
					hmTempdetail.put("manufactured_date", (String)alExp.get("manufactured_date"));//Added for MO-CRF-20165
					

			alTempdetail.add(hmTempdetail);
		}

 
		boolean check;

		for(int m=0;m<alTempdetail.size();m++){
			check = true;
			HashMap alTempGroup = (HashMap)alTempdetail.get(m);
					if(alExpRecords.size()>0){	
						for(int n=0;n<alExpRecords.size();n++){
							HashMap temp=(HashMap)alExpRecords.get(n);
							if(((String)alTempGroup.get("batch_id")).equals((String)temp.get("batch_id")) && ((String)alTempGroup.get("expiry_date_or_receipt_date")).equals((String)temp.get("expiry_date_or_receipt_date"))){
								//if(!(temp.containsKey("ADDED"))){
								float new_item_qty	= Float.parseFloat((String)alTempGroup.get("grn_item_qty"))+ Float.parseFloat((String)temp.get("grn_item_qty")) ; 
								temp.put("grn_item_qty",	""+new_item_qty);
								//temp.put("ADDED",	"YES");
							 	//}
								check = false;
							}
						}
					}else{
					alExpRecords.add(alTempGroup);
					check = false;
					}
					if(check){
					alExpRecords.add(alTempGroup);
					}
		}
	}
	}


 		HashMap hmExpRecords=new HashMap();
		
	 //Added by Rabbani #inc no:30127 on 09/01/11
			if(external_po_yn.equals("Y")){   
			   if(flaggrn){
				  size = 10;
			 }else{
				 if(alExpRecords.size()>10){
					size = 10;
				}else{
					size = alExpRecords.size();
				}
				}
			}
			else if(by_po.equals("Y")){
			size = 10;
			}
	/* if(external_po_yn.equals("Y")){
		if(alExpRecords.size()>10){
			size = 10;
		}else{
			size = alExpRecords.size();
		}
	} */
 for(int i=0;i<size;i++) {
		hmExpRecords=new HashMap();
		if(expiry_yn.equals("N")) {
			hmExpRecords.put("batch_id",default_batch_id);
			hmExpRecords.put("expiry_date_or_receipt_date",expiry_date);
		}
	//String exp_disp_date = bean.checkForNull((String)hmExpRecords.get("expiry_date_or_receipt_date"));
		if (i<alExpRecords.size()) 
			hmExpRecords	=	(HashMap)alExpRecords.get(i);

			  exp_disp_date	 = bean.checkForNull((String)hmExpRecords.get("expiry_date_or_receipt_date"));
			 manufactured_date = bean.checkForNull((String)hmExpRecords.get("manufactured_date"));//added for MO-CRF-20165 
			  

	  if(!locale.equals("en"))
		{
		  exp_disp_date = com.ehis.util.DateUtils.convertDate(exp_disp_date,"DMY","en",locale);
		}else
		{
		  exp_disp_date = com.ehis.util.DateUtils.convertDate(exp_disp_date,"DMY",locale,"en");
		}

			if(trade_id_applicable_yn.equals("Y")) {
			default_trade_id_new = bean.getTrade_id_List(item_code,(String)hmExpRecords.get("trade_id"));
			}
			else if(trade_id_applicable_yn.equals("N")) {
			default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull((String)hmExpRecords.get("trade_id"),default_trade_id));
			}
		
		by_do = bean.checkForNull((String)hmExpRecords.get("by_do"),"N");
		if(by_do.equals("Y"))
			by_do_disable = "disabled";
		else
			by_do_disable = "";
			%>
	 <tr>
		
		<td nowrap class='fields'>
		<input class="STSMALL" type='text' name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" <%=disable_expiry_date%>  <%=by_do_disable%> value="<%=exp_disp_date%>" size=10 maxlength='10' onBlur="getBatchIDFromExpiryDate(expiry_date_or_receipt_date_<%=i%>,<%=i%>);ChekDate(this,'<%=locale%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');CallNewBarcodeString('goodsReceivedNoteBean','eST.GoodsReceivedNoteBean','<%=facilityid%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,grn_item_qty_<%=i%>,sale_price_<%=i%>);"  onchange=""><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal  ('expiry_date_or_receipt_date_<%=i%>');" <%=disable_expiry_date%> <%=by_do_disable%>></img>	</td>
		<%if(grn_newfields_applicable){ %><!-- MO-CRF-20165 -->
		<td class='fields'><input class="STSMALL" type='text' name="manufactured_date_<%=i%>" id="manufactured_date_<%=i%>"  value="<%=manufactured_date%>" size=10 maxlength='10' onBlur="ChekDate(this,'<%=locale%>');CheckMaxYearForExpiryDate(this,'<%=locale%>');doDateCheckLocal(this);doDateCheckWithExpDate  (this,expiry_date_or_receipt_date_<%=i%>,<%=i%>);"  onchange=""><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarLocal  ('manufactured_date_<%=i%>');" ></img>	</td>
		<% } %> 
		<td class='fields'>&nbsp;<input type='text' class="UPPER" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=bean.checkForNull((String)hmExpRecords.get("batch_id"))%>"size=18 maxlength=20 <%=disable_batch_id%> <%=by_do_disable%> onKeyPress="return  CheckForSpecialChars(event);"  onBlur="CallNewBarcodeString('goodsReceivedNoteBean','eST.GoodsReceivedNoteBean','<%=facilityid%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,grn_item_qty_<%=i%>,sale_price_<%=i%>)">	</td>
		<td class='fields'><select class="STSMALL" name="trade_id_<%=i%>" id="trade_id_<%=i%>"  onchange="CallNewBarcodeString('goodsReceivedNoteBean','eST.GoodsReceivedNoteBean','<%=facilityid%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,grn_item_qty_<%=i%>,sale_price_<%=i%>);"><%=default_trade_id_new%></select></td>
		<td class='fields'>	<select class="STSMALL" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" onchange="CallNewBarcodeString('goodsReceivedNoteBean','eST.GoodsReceivedNoteBean','<%=facilityid%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,grn_item_qty_<%=i%>,sale_price_<%=i%>)">	<%=bean.getBin_location_code_List(bean.getStore_code(),bean.checkForNull((String)hmExpRecords.get("bin_location_code")),item_code)%></select></td>
	<%
		String grn_item_qty				=	(bean.checkForNull((String)hmExpRecords.get("grn_item_qty")).equals(""))?"":bean.setNumber((String)hmExpRecords.get("grn_item_qty"),Integer.parseInt(no_deci));%>
			<td class='fields' ><input class="STSMALL" type='text' name="grn_item_qty_<%=i%>" id="grn_item_qty_<%=i%>" value="<%=grn_item_qty%>"  style="text-align:right" onKeyPress="return isValidNumber(this,event,7,<%=Integer.parseInt(no_deci)%>);" <%=by_do_disable%> size=10 maxlength=12 onblur="checkDoubleFormat(this);CallNewBarcodeString('goodsReceivedNoteBean','eST.GoodsReceivedNoteBean','<%=facilityid%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,grn_item_qty_<%=i%>,sale_price_<%=i%>)">	</td>
	<%if(BarCodeApplicable){%>
			<td  class='fields'>&nbsp;&nbsp;<input type='text' name="barcode_id_<%=i%>" id="barcode_id_<%=i%>" size=20 maxlength=20 class="NUMBER"  onKeyPress="return  CheckForSpecialChars(event);"  value="<%=bean.checkForNull((String)hmExpRecords.get("barcode_id"))%>"  <%=BarcodeRule_Disable%> ></td>
	<%}
	if(sale_price_appl_yn.equals("Y")){%>
			<td  class='fields'>&nbsp;&nbsp;<input type='text' name="sale_price_<%=i%>" id="sale_price_<%=i%>" size=8 maxlength=7 class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="checkUnitCost(this);checkDoubleFormat(this, false);;CallNewBarcodeString('goodsReceivedNoteBean','eST.GoodsReceivedNoteBean','<%=facilityid%>','<%=item_code%>',batch_id_<%=i%>,expiry_date_or_receipt_date_<%=i%>,trade_id_<%=i%>,bin_location_code_<%=i%>,'<%=store_code%>',barcode_id_<%=i%>,grn_item_qty_<%=i%>,sale_price_<%=i%>)"  value="<%=bean.checkForNull((String)hmExpRecords.get("sale_price"))%>"></td>
	<%}else{%>
			<input type='hidden' name="sale_price_<%=i%>" id="sale_price_<%=i%>">
	<%}%>
	<%if(!BarCodeApplicable){%>
			<input type='hidden' name="barcode_id_<%=i%>" id="barcode_id_<%=i%>">
	<%}%>
		<input type='hidden' value="<%=bean.checkForNull((String)hmExpRecords.get("by_do"))%>" name="by_do_<%=i%>">
		<!--  Added by Rabbani #Inc no:40591 on 07-JUN-2013 -->
		<input type='hidden' name="shelf_life_exp_date_<%=i%>" id="shelf_life_exp_date_<%=i%>">	
		<!-- 23925 Start-->
		<td class = 'fields'  >	
		<% String fileRef				=	(bean.checkForNull((String)hmExpRecords.get("fileRef")).equals(""))?"":bean.checkForNull((String)hmExpRecords.get("fileRef"));%>
				<input type='hidden' name = 'fileRef_<%=i%>' id='fileRef_<%=i%>' value='<%=fileRef%>' />		
				<input type='file' name='fileupload_<%=i%>'  id = 'fileuploadid_<%=i%>' size='30' onMouseDown=' ' onKeyDown='' onKeyPress =''  onContextMenu ='return false;' onChange="javascript:validateUploadImage('fileuploadid_<%=i%>');" onclick="" >
		</td>
		<!-- 23925 End-->
	</tr>
	<%	
		}
	%>
</table> 

	<input type="hidden" name="sys_date" id="sys_date"				value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">  
	<input type="hidden" name="item_code" id="item_code"				value="<%=item_code%>">
	<input type="hidden" name="store_code" id="store_code"				value="<%=bean.getStore_code()%>">
	<input type="hidden" name="gen_uom_desc" id="gen_uom_desc"			value="<%=bean.checkForNull(request.getParameter("gen_uom_desc"),bean.checkForNull((String)bean.getGenItemUOMDesc(item_code)))%>">
	<input type="hidden" name="batch_id_applicable_yn" id="batch_id_applicable_yn"  value="<%=batch_id_applicable_yn%>">
	<input type="hidden" name="sale_price_appl_yn" id="sale_price_appl_yn"		value="<%=sale_price_appl_yn%>">
	<input type="hidden" name="lesser_sale_price_yn" id="lesser_sale_price_yn"	value="<%=lesser_sale_price_yn%>">
	<input type="hidden" name="index" id="index"					value="<%=index%>">
	<input type="hidden" name="total_records" id="total_records"			value="<%=size%>">
    <input type="hidden" name="language_id" id="language_id"				value="<%=locale%>">
    <input type="hidden" name="allow_deci_yn" id="allow_deci_yn"			value="<%=allow_deci_yn%>">
	<input type="hidden" name="no_deci" id="no_deci"					value="<%=no_deci%>">
    <input type="hidden" name="BarcodeRule" id="BarcodeRule"				value="<%=BarcodeRule%>">
	<input type="hidden" name="manufacturer_id" id="manufacturer_id"			value="<%=manufacturer_id%>" >
	<input type="hidden" name="supplier_id" id="supplier_id"				value="<%=supplier_id%>" >
	<input type="hidden" name="mrp" id="mrp"						value="" >
	<input type="hidden" name="trn_type" id="trn_type"				value="GRN" >
	<input type="hidden" name="shelfLifeDate" id="shelfLifeDate"			value="<%=shelfLifeDate%>" >
	<input type="hidden" name="formatedDate" id="formatedDate"			value="<%=formatedDate%>" >  <!-- //23925 -->
<script>
		if(document.forms[0].trade_id_0.length==1)
		{
			alert(getMessage("TRADE_NOT_ASS_FOR_ITEM","ST"));
			parent.frameGoodsReceivedNoteListHeader.location.reload();
			self.location.href="../../eCommon/html/blank.html";
		}
		else if(document.forms[0].bin_location_code_0.length==1)
		{			
			alert(getMessage("BIN_LOCN_NOT_ASS_FOR_STORE","ST"));
			parent.frameGoodsReceivedNoteListHeader.location.reload();
		
			self.location.href="../../eCommon/html/blank.html";
		}
	</script>
</form>
<%
putObjectInBean("goodsReceivedNoteBean",bean,request);
%>
</body>
</html>
	<% 
		}
		catch(Exception e) {
			e.printStackTrace();
					}
finally{//MO-CRF-20165 
	if(con!=null){
		ConnectionManager.returnConnection(con,request); 
	}
}
	%>

