<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import=" eST.SalesReturnBean,eST.SalesReturnBatchSearchBean,java.util.ArrayList,java.util.HashMap"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/SalesReturn.js"></script>
	</head>
	<%	
			java.util.Properties prop	=		(java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		=		prop.getProperty( "client_ip_address" );
			String bean_id				=		"salesReturnBean"+login_at_ws_no;
			String bean_name			=		"eST.SalesReturnBean";


		SalesReturnBean bean = (SalesReturnBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		int i	=0;
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		String patient_id=bean.checkForNull(request.getParameter("patient_id"));
		String encounter_id=bean.checkForNull(request.getParameter("encounter_id"));
		String sal_trn_type=bean.checkForNull(request.getParameter("sal_trn_type"));
		
		String function = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));

		//String store_code = bean.checkForNull(request.getParameter("store_code"));
		String store_code = bean.checkForNull(bean.getStore_code());
   
		String item_qty = bean.checkForNull(request.getParameter("item_qty"));
		
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
		
		String addToList = request.getParameter("addToList");
        String mode = bean.checkForNull(bean.getMode());

		ArrayList alBatchRecords = null;
		HashMap hmBatchRecord = null;
	
		String className	=	"";
		//String dec_allowed_yn = bean.getAllowDecimalsYN(item_code);
		String dec_allowed_yn = "";
	//	String date_legend="Expiry Dt";
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
		int no_of_decimals					=			bean.getNoOfDecimals();
		String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		//Added for GHL-CRF-0413.5 starts
		ArrayList barcodeExp = new ArrayList();
	        ArrayList itemCodeExp = new ArrayList();
		int doc_srl_no_forbean =0;
		String qtyList = "";
		String p[]=null;
		int tmp = 0;
		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1    =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String barcode_appl                 =  bean.checkForNull(bean.getBarcodeApplicable(),"N");
		String BarcodeWithMultipleBatches	=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		boolean site=bean.isSite_spec_yn();
		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
 		//Added for GHL-CRF-0413.5 ends
		try { 
			if(function.equals("modify"))	{

				//HashMap hmDetailRecord	=	(HashMap)bean.getDtlRecord(Integer.parseInt(index)); 
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index));
				//bean.setExpRecords( Integer.parseInt(index), alBatchRecords);//Added by suresh.r on 13-10-2014 against Inc 2919
				if(site){
	  				//Added against GHL-CRF-0413.5 starts
	  				doc_srl_no_forbean = (Integer.parseInt(index));
	  				ArrayList setTmpList = new ArrayList(alBatchRecords);
	  				bean.setTempBatchRecords(setTmpList);
					//Added against GHL-CRF-0413.5 ends
				}else
	  				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			
			}
			else if(function.equals("edit"))	{

				HashMap hmParameters	=	new HashMap();

				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("PATIENT_ID",patient_id);
				hmParameters.put("ENCOUNTER_ID",encounter_id);
				hmParameters.put("TRN_QTY",item_qty);
				hmParameters.put("STORE_CODE",store_code);
                hmParameters.put("SAL_TRN_TYPE",sal_trn_type);
      			HashMap hmReturn	=	bean.getSalesReturnBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);//Added by suresh.r on 13-10-2014 against Inc 2919
			}
			//Added against GHL-CRF-0413.5 starts
			else if (function.equals("additionalBatch")){ 
			try
			{
				String barcode = bean.checkForNull(request.getParameter("barcode"));
				String list_store_code = bean.checkForNull(request.getParameter("store_code"));
				qtyList = bean.checkForNull(request.getParameter("qtyList"));
				p=qtyList.split(",");
				ArrayList oldBatchExpList = new ArrayList();
				ArrayList tmpList  = new ArrayList();
				if(bean.getTempBatchRecords().size()>0 ){
					oldBatchExpList = bean.getTempBatchRecords();//old records in current trnsaction
   				}
   				HashMap newBatchId = null;
   				ArrayList alExp = new ArrayList();
   				  newBatchId=	(HashMap)bean.fetchRecord("select batch_id,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, BIN_LOCATION_CODE  from st_sal_dtl_exp where FACILITY_ID=? and DOC_TYPE_CODE=? and doc_no = ? and STORE_CODE =? and BARCODE_ID = ?",new String[]{bean.getLoginFacilityId(),bean.getSalesDocTypeCode(),bean.getSalesDocNo(),list_store_code,barcode});
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
   				bean.getAlTempExpRecords().clear();
   				for(int binlocn=0; binlocn < tmpList.size() ; binlocn++) {
				HashMap hmBatchRecord1 = (HashMap)tmpList.get(binlocn);
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
					System.out.println("Exception in SalesReturnListDetail.jsp ...function=additionalBatch..");
					throw ex;
				}
			 }//Added against GHL-CRF-0413.5 ends
			else
			{
				SalesReturnBatchSearchBean bean2 = (SalesReturnBatchSearchBean)getBeanObject("SalesReturnBatchSearchBean",  "eST.SalesReturnBatchSearchBean", request);
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();

                if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
				}
				/*
				else
				{
						for(i=0;i<alBatchRecords.size();i++){
							hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
							hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
						}
                } */				

				putObjectInBean("salesReturnBatchSearchBean",bean2,request);//Comment removed by suresh.r on 13-10-2014 against Inc 2919
				//Added for GHL-CRF-0413.5 starts
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
			//Added for GHL-CRF-0413.5 ends

			if(expiry_yn.equals("N")) {
	//			date_legend="Receipt Dt";
				date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}

			//bean.setExpRecords( Integer.parseInt(index), alBatchRecords);//Commented by suresh.r on 13-10-2014 against Inc 2919

	%>
	<body  ><!--   onload="loadBatchCharges();" Commented against GHL-CRF-0.413.5-->
		<form name='formSalesReturnListDetail' id='formSalesReturnListDetail'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center">
 			<tr>
				<th><%=date_legend%></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
       		    <th><fmt:message key="eST.ToBinLocation.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.RetQty.label" bundle="${st_labels}"/></th>
			</tr>
		
			<%
				String batch_qty="";
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
				//Added for GHL-CRF-0413.5 starts
				barcodeExp.add(bean.checkForNull((String)hmBatchRecord.get("BARCODE_ID"), ""));
				bean.setAlBarcodeExp(barcodeExp);
				itemCodeExp.add((String)hmBatchRecord.get("ITEM_CODE"));
				bean.setAlItemcodeExp(itemCodeExp);
				//Added for GHL-CRF-0413.5 ends
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
			/**
			 * @Name - Priya
			 * @Date - 19/05/2010
			 * @Inc# - 
			 * @Desc -  as item code was coming null in the request 'dec_allowed_yn' is derived based on the ITEM_CODE from the hmBatchRecord  
			 */
				if(i==0){
						dec_allowed_yn = bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"));
				}

			if(dec_allowed_yn.equals("N")){
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),0);
			}else{
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals);
			}
			%>
	
				<tr>
					<td class="<%=className%>" nowrap  name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>"  title="Sales: <%=(String)hmBatchRecord.get("SAL_DOC_NO")%>/<%=(String)hmBatchRecord.get("SAL_DOC_TYPE_CODE")%>" ><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_RECEIPT_DT"),"DMY","en",locale)%></td>
					<td class="<%=className%>" nowrap  name="batch_id_<%=i%>" id="batch_id_<%=i%>" ><%=hmBatchRecord.get("BATCH_ID")%></td>
					<td class="<%=className%>" nowrap  name="trade_id_<%=i%>" id="trade_id_<%=i%>" ><%=hmBatchRecord.get("TRADE_NAME")%></td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"><%=hmBatchRecord.get("AVAIL_QTY")%></td>
					<td class="<%=className%>" nowrap >
						<select class="STSMALL" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value=? ><%=( (mode.equals("1") || mode.equals("2")  )&& index.equals("-1") )?(bean.getBinLocationList(store_code,(String)hmBatchRecord.get("BIN_LOCATION_CODE"))):(bean.getBinLocationList(store_code,(String)hmBatchRecord.get("NEW_BIN_LOCATION_CODE"))) %>
						</select>
					</td>
					
					<%if(function.equals("additionalBatch") ){//Added for GHL-CRF-0413.5 starts
					%>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=12 maxlength=12 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=p[i]%>"  
					onBlur="checkBatchQty(this,available_qty_<%=i%>.value);viewBatchCharges(<%=i%>); TotalBatchCharges();" ></td>
					<%}else{ //Added for GHL-CRF-0413.5 ends%>
					<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="item_qty_<%=i%>"  size=12 maxlength=12 class="NUMBER" 
					value="<%=(function.equals("edit")||function.equals("modify"))?batch_qty:""%>" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);"  
					onBlur="checkBatchQty(this,available_qty_<%=i%>.value);viewBatchCharges(<%=i%>); TotalBatchCharges();" ></td>
					<%} %>
						</tr>
					<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value="<%=hmBatchRecord.get("TRADE_ID")%>">
					<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=hmBatchRecord.get("BATCH_ID")%>">
					<input type="hidden" name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_RECEIPT_DT")%>">
					<input type="hidden" name="barcode_<%=i%>" id="barcode_<%=i%>" value="<%=hmBatchRecord.get("BARCODE_ID")%>">
					<td class="<%=className%>" nowrap ><input type="hidden"  name="trade_id1_<%=i%>" id="trade_id1_<%=i%>" id="trade_id1_<%=i%>"  value="<%=hmBatchRecord.get("TRADE_ID")%>"></td>
					<td class="<%=className%>" nowrap ><input type="hidden"  name="gross_charge_amt_<%=i%>" id="gross_charge_amt_<%=i%>" id="gross_charge_amt_<%=i%>"  value=""></td>
					<td class="<%=className%>" nowrap ><input type="hidden"  name="net_charge_amt_<%=i%>" id="net_charge_amt_<%=i%>" id="net_charge_amt_<%=i%>"  value=""></td>
				

					<input type="hidden" name="available_qty_<%=i%>" id="available_qty_<%=i%>" value="<%=hmBatchRecord.get("AVAIL_QTY")%>">
					
			<%	}
				
			%>
			<input type="hidden"   name="doc_srl_no_forbean" id="doc_srl_no_forbean"  value ="<%=doc_srl_no_forbean %>">
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=dec_allowed_yn%>">
			<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">
		</table>
		</form>
				<%
putObjectInBean(bean_id,bean,request);

%>
	<script language="JavaScript">
	loadBatchCharges();//Added against GHL-CRF-0413.5
<%
	if (addToList!=null){
%>				
		parent.frameSalesReturnListHeader.addToList();
<%
		}
	else if (function.equals("additionalBatch")){//Added additionalBatch for GHL-CRF-0413.5 starts
		if (defaultqty_appl.equals("Y")){
		%>
		parent.frameSalesReturnListHeader.callItemQtyUpdate();
		TotalBatchChargesBarcode();
		<%	}
		}//Added additionalBatch for GHL-CRF-0413.5 ends
%>
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {
			out.println("Insufficient Quantity.");
			out.println(insufficientBatchException);
			insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
			out.println(exception.getMessage());
			exception.printStackTrace();
			
		}
				
%>

	</body>
</html>

