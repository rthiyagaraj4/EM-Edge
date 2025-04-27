<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R           27/02/2014        Suresh R     AMS-CRF-0054(Added Item Based IssueReturn)

--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

 <%@ page import="eST.BatchSearchIssueReturnBean,eST.BatchSearchBeanForBarcode,eST.Common.StUtilities,eST.IssueReturnBean,eST.Common.StDuoHeaderBean,java.util.HashMap,java.util.ArrayList,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> 
 -->		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/IssueReturn.js"></script>
	</head>	
	<%
        IssueReturnBean bean = (IssueReturnBean) getBeanObject("issueReturnBean","eST.IssueReturnBean",request);			bean.setLanguageId(locale);
		eST.Common.StDuoHeaderBean beanHdr = (eST.Common.StDuoHeaderBean) getBeanObject("stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
		beanHdr.setLanguageId(locale);
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;
		String dec_allowed_yn = "N";
		int i	=0;
		//Added for GHL-CRF-0413 starts
		ArrayList barcodeExp = new ArrayList();
	        ArrayList itemCodeExp = new ArrayList();
		int doc_srl_no_forbean = -1;
		String qtyList = "";
		String p[]=null;
		int tmp = 0;
		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
 		//Added for GHL-CRF-0413 ends
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String fm_store_code = bean.checkForNull(request.getParameter("fm_store_code"));
		String to_store_code = bean.checkForNull(beanHdr.getTo_store_code());
		String item_qty = bean.checkForNull(request.getParameter("item_qty"));
		String addToList = request.getParameter("addToList");
		String mode = bean.checkForNull(request.getParameter("mode"));
		String iss_ret_based_on=bean.getIssueRetBasedOn();//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
		ArrayList alBatchRecords = null;		
		HashMap hmBatchRecord = null;
		String className =	"";
		HashMap hmParameters	=	new HashMap();
		String defaultBinLocationCode	= "";
		//Added against GHL-CRF-0413 starts
		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1    =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String barcode_appl                 =  bean.checkForNull(bean.getBarcodeApplicable(),"N");
		String BarcodeWithMultipleBatches	=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		boolean site=bean.isSite_spec_yn();
		//Added against GHL-CRF-0413 ends
        try { 
              if(mode.equals("1"))	{
			    defaultBinLocationCode	=	bean.getDefaultBinLocationCode(to_store_code,item_code);	
              }   
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("FM_STORE_CODE",fm_store_code);
				hmParameters.put("TO_STORE_CODE",to_store_code);
				hmParameters.put("TRN_QTY",item_qty);
                HashMap hmReturn =new HashMap();              
              if(function.equals("modify"))	{
				 alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
				if(site){
  				//Added against GHL-CRF-0413 starts
				doc_srl_no_forbean = (Integer.parseInt(index));
  				ArrayList setTmpList = new ArrayList(alBatchRecords);
  				bean.setTempBatchRecords(setTmpList);
				//Added against GHL-CRF-0413 ends
			   }else   
  				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
  			}
              else   
			  if(function.equals("edit"))	{
				hmReturn	=	bean.getIssueBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA");
				if(site){
					doc_srl_no_forbean = Integer.parseInt(index);
					if(doc_srl_no_forbean== -1 && bean.getDtlRecords().size()>0){
						for(int h =0; h< bean.getDtlRecords().size();h++){
							HashMap hmDtl = new HashMap();
							hmDtl = bean.getDtlRecord(h);
							if(hmDtl.containsValue(item_code))
								doc_srl_no_forbean = h;
						}
					}
					bean.getTempBatchRecords().clear();
					ArrayList albaArrayList = alBatchRecords;
					bean.setTempBatchRecords(albaArrayList);
				}
				else
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			 }
            //Added for GHL-CRF-0413 starts
				else if (function.equals("additionalBatch")){
					try
					{
						System.out.println("in IssueListDetail.jsp ...function=additionalBatch..");
						String barcode = bean.checkForNull(request.getParameter("barcode"));
						String store_code = bean.checkForNull(request.getParameter("store_code"));
						BarcodeWithMultipleBatches =  bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"));
	 					qtyList = bean.checkForNull(request.getParameter("qtyList"));
	   					p=qtyList.split(",");
	   					ArrayList oldBatchExpList = new ArrayList();
	   					ArrayList tmpList  = new ArrayList();
	   					if(bean.getTempBatchRecords().size()>0 ){
	   					oldBatchExpList = bean.getTempBatchRecords();//old records in current trnsaction	
	   					}
	   					HashMap newBatchId = null;
	   				  ArrayList alExp = new ArrayList();
	   				 newBatchId=	(HashMap)bean.fetchRecord("select batch_id,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, BIN_LOCATION_CODE  from st_item_batch where barcode_id = ? and store_code = ?",new String[]{barcode,store_code});
	   					/* HashMap hmExpBarcode = bean.getExpRecords();
	   					if(bean.getAlTempExpRecords().size()==0){
						   for(int b=0;b< hmExpBarcode.size();b++){
							   String j = ""+b;
						   	   alExp = (ArrayList)hmExpBarcode.get(j);
							      for(int c=0;c<alExp.size();c++)
							   {
								   HashMap hmExp = new HashMap();
								   hmExp = (HashMap)alExp.get(c);
								   if((hmExp.containsValue(newBatchId.get("BATCH_ID"))) && (hmExp.containsValue(newBatchId.get("EXPIRY_DATE_OR_RECEIPT_DATE")))&& (hmExp.containsValue(newBatchId.get("BIN_LOCATION_CODE"))))
								   {
									   tmpList.add(hmExp);
								  }
							   }
						   }
	   					}
	   					else{ */
	   						ArrayList alExp1 = new ArrayList();
	   						alExp1 = bean.getAlTempExpRecords();
							   for(int c=0;c<alExp1.size();c++)
							   {
								   HashMap hmExp1 = new HashMap();
								   hmExp1 = (HashMap)alExp1.get(c);
								   if((hmExp1.containsValue(newBatchId.get("BATCH_ID"))) && (hmExp1.containsValue(newBatchId.get("EXPIRY_DATE_OR_RECEIPT_DATE")))&& (hmExp1.containsValue(newBatchId.get("BIN_LOCATION_CODE"))))
							   		{
									   tmpList.add(hmExp1);
								  }
	   							}
	   					//}
	   						bean.getAlTempExpRecords().clear();
					for(int binlocn=0; binlocn < tmpList.size() ; binlocn++) {
					HashMap hmBatchRecord1 = (HashMap)tmpList.get(binlocn);
					hmBatchRecord1.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
					hmBatchRecord1.put("RET_ITEM_QTY",	"0");
					hmBatchRecord1.put("BARCODE_ID",	barcode);
					}
	   					ArrayList tempBatchRecordsList = new ArrayList();
	   					tempBatchRecordsList = null;
						 if(oldBatchExpList.size()>0)
						 {
							 tempBatchRecordsList=oldBatchExpList;
							 if(tmpList.size()>0)
							 tempBatchRecordsList.addAll(tmpList);
						 }
						 else
							 if(tmpList.size()>0)
							 tempBatchRecordsList = tmpList;
						  if(tmpList.size()>0){
						  ArrayList setTmpList = new ArrayList(tempBatchRecordsList);
						bean.setTempBatchRecords(setTmpList);  //curr trans all batches
						  }
						 ArrayList OldExpRecords = new ArrayList();
						HashMap CurrBatchRecords = new HashMap();
						doc_srl_no_forbean = bean.getDtlRecords().size();
						ArrayList alTmpList = new ArrayList();
						 if(bean.getDtlRecords().size()>0 ){
							 for(int m1=0; m1 < bean.getDtlRecords().size() ; m1++){ ///get the index for the itemcode
								HashMap hmTmp=(HashMap) bean.getDtlRecords().get(m1);
								if( hmTmp.containsValue(item_code)){
									 tmp = m1;
									doc_srl_no_forbean = tmp;	
								}
							 }
						 }
						if(alBatchRecords==null)
							alBatchRecords = bean.getTempBatchRecords();
						else
							alBatchRecords.addAll(bean.getTempBatchRecords());//curr trans all batches  
					}
					catch(Exception ex)
			 {
						ex.printStackTrace();
						System.out.println("Exception in IssueListDetail.jsp ...function=additionalBatch..");
						throw ex;
					}
				} 
				//Added for GHL-CRF-0413 ends
			  else
			 {
			 System.out.println("inside else in list detail");
				BatchSearchIssueReturnBean bean2 = (BatchSearchIssueReturnBean) getBeanObject("BatchSearchIssueReturnBean","eST.BatchSearchIssueReturnBean", request );
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();
				for(i=0;i<alBatchRecords.size();i++){
					hmBatchRecord=(HashMap)alBatchRecords.get(i);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);					
			    }
				if (alBatchRecords.size()==0)
				{
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
				function = "modify";
				}
				putObjectInBean("BatchSearchIssueReturnBean",bean2,request);
			//Added for GHL-CRF-0413 starts
				if(site){
					doc_srl_no_forbean = Integer.parseInt(index);
					if(doc_srl_no_forbean== -1 && bean.getDtlRecords().size()>0){
					for(int h =0; h< bean.getDtlRecords().size();h++){
						HashMap hmDtl = new HashMap();
						hmDtl = bean.getDtlRecord(h);
						if(hmDtl.containsValue(item_code))
							doc_srl_no_forbean = h;
					}
			}
					bean.getTempBatchRecords().clear();
					ArrayList albaArrayList = alBatchRecords;
					bean.setTempBatchRecords(albaArrayList);
				}else
			bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			}
			//Added for GHL-CRF-0413 ends
			//bean.setExpRecords( Integer.parseInt(index), alBatchRecords); Commented for GHL-CRF-0413
	%>
	<body >
		<form name='formIssueReturnListDetail' id='formIssueReturnListDetail'>
			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' >
 			<tr>
				<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ToBinLocation.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.RetQty.label" bundle="${st_labels}"/></th>
			</tr>
			<%
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(HashMap)alBatchRecords.get(i);
				 //Added for GHL-CRF-0413 starts
				 //barcodeExp.add((String)hmBatchRecord.get("BARCODE_ID"));
				 barcodeExp.add(bean.checkForNull((String)hmBatchRecord.get("BARCODE_ID"), ""));
				bean.setAlBarcodeExp(barcodeExp);
				itemCodeExp.add((String)hmBatchRecord.get("ITEM_CODE"));
				bean.setAlItemcodeExp(itemCodeExp);
				//Added for GHL-CRF-0413 ends
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
				
 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
					if((bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"))).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals = no_of_decimals_temp;
					}
			%>
			<tr>
				<td class="<%=className%>" nowrap  name="expiry_date_or_receipt_date_<%=i%>" title="Issue: <%=hmBatchRecord.get("DOC_NO")%>/<%=hmBatchRecord.get("DOC_TYPE_CODE")%>/<%=hmBatchRecord.get("SEQ_NO")%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_RECEIPT_DT"),"DMY","en",locale)%></td>
				<td class="<%=className%>" nowrap  name="batch_id_<%=i%>"><%=hmBatchRecord.get("BATCH_ID")%></td>
				<td class="<%=className%>" ><%=hmBatchRecord.get("TRADE_NAME")%></td>
				<td class="<%=className%>" ><%=bean.checkForNull((String )hmBatchRecord.get("TO_BIN_DESC"),"&nbsp;")%></td>
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align AVAIL_QTY.				
					-->
				<td class="<%=className%>" nowrap style="TEXT-ALIGN:right" ><%=bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),no_of_decimals)%>&nbsp;</td>
				<td class="<%=className%>" nowrap ><select class="STSMALL" name="to_bin_location_code_<%=i%>" id="to_bin_location_code_<%=i%>" value=? ><%=( mode.equals("1") && index.equals("-1") )?(bean.getBinLocationList(to_store_code,(String)hmBatchRecord.get("NEW_BIN_LOCATION_CODE"))):(bean.getBinLocationList(to_store_code,(String)hmBatchRecord.get("NEW_BIN_LOCATION_CODE"))) %></select></td>
<!-- 				<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size="5" maxlength="5" style="text-align:right" class="STSMALL" value="<%=(function.equals("edit")||function.equals("modify"))?bean.checkForNull((String)hmBatchRecord.get("QTY")):bean.checkForNull((String)hmBatchRecord.get("AVAIL_QTY"))%>" onKeyPress="return isValidInteger();" onBlur="checkBatchQty(this,available_qty_<%=i%>.value);"></td>
 -->			
				<%if(function.equals("additionalBatch") ){//Added for GHL-CRF-0413 starts %>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=8 maxlength=7 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=p[i]%>"  
					 onBlur="checkBatchQty(this,available_qty_<%=i%>.value);" ></td>
					<%}else{ //Added for GHL-CRF-0413 ends%>
 				<!--Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg-->
 				<%if(iss_ret_based_on.equals("I")){ %>
 				<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size="5" maxlength="5" style="text-align:right" class="STSMALL" value="<%=(function.equals("edit")||function.equals("modify"))?bean.setNumber(bean.checkForNull((String)hmBatchRecord.get("QTY")),no_of_decimals):""%>" onKeyPress="return isValidInteger();" onBlur="checkBatchQty(this,available_qty_<%=i%>.value);"></td>
 				<%}else{ %><!--Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end-->
 				<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size=8 maxlength=7 style="text-align:right" class="STSMALL" value="<%=!(bean.checkForNull((String)hmBatchRecord.get("QTY")).equals(""))?bean.setNumber(bean.checkForNull((String)hmBatchRecord.get("QTY")),no_of_decimals):bean.setNumber(bean.checkForNull((String)hmBatchRecord.get("AVAIL_QTY")),no_of_decimals)%>" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="checkBatchQty(this,available_qty_<%=i%>.value);"></td>
				<%} %><!--Added by suresh.r on 24-01-2014 against AMS-CRF-0054 -->
				<%} %>
				</tr>
				<input type="hidden" name="available_qty_<%=i%>" id="available_qty_<%=i%>" value="<%=bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),no_of_decimals)%>">
					<!--Added for GHL-CRF-0413 starts -->
					<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=hmBatchRecord.get("BATCH_ID")%>">
					<input type="hidden" name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_RECEIPT_DT")%>">
					<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value="<%=hmBatchRecord.get("TRADE_ID")%>">
					<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=hmBatchRecord.get("BIN_LOCATION_CODE")%>">
					<input type="hidden" name="barcode_<%=i%>" id="barcode_<%=i%>" value="<%=hmBatchRecord.get("BARCODE_ID")%>">
					<!-- Added against GHL-CRF-0413 ends-->
	     <% 
			dec_allowed_yn = bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"));
			}  
		%>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
<!-- 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/

 -->	
		<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="<%=dec_allowed_yn%>">
		<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_of_decimals%>">
		<input type="hidden"   name="doc_srl_no_forbean" id="doc_srl_no_forbean"  value ="<%=doc_srl_no_forbean %>"><!-- Added against GHL-CRF-0413-->
		<input type="hidden" name="batchsearch" id="batchsearch" value="<%=batchsearch%>">
    </form>
					
    <script language="JavaScript">
    <% if (addToList!=null){ 
    //Added against GHL-CRF-0413
    		if(site) %>				
		parent.frameIssueReturnListHeader.addToListforBarcode();
		<%else%>
		parent.frameIssueReturnListHeader.addToList();
    <% 	} 
    //Added for GHL-CRF-0413 starts
	else if (function.equals("additionalBatch")){
	if (defaultqty_appl.equals("Y")){
	%>	
	parent.frameIssueReturnListHeader.callItemQtyUpdate();
	<%	}
	}
    %>//Added for GHL-CRF-0413 ends
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



  <%  } catch (Exception exception) {
			exception.printStackTrace();
	  }   %>
	  <%
putObjectInBean("issueReturnBean",bean,request);
putObjectInBean("stDuoHeaderBean",beanHdr,request);
%>
</body>
</html>

