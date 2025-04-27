<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
03/02/2016	  	IN063027	   		Badmavathi B	 						GHL-CRF-0413.7 - US007 Barcode Search implementation
29/05/2017		IN063673			Badmavathi B							GHL-SCF-1169  - 'Process Expired Batches'-> unchecked , 'Use After Expiry' -> checked
15/11/2017		INC065695			Shazana Hasan							MMS-DM-CRF-0112 -US003 - Barcode search
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.Common.*,eST.StockItemConsumptionBean,eST.BatchSearchBean,eST.BatchSearchBeanForBarcode,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
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
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> 
		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StockItemConsumption.js"></script>
	</head>
	<%
		StockItemConsumptionBean bean = (StockItemConsumptionBean) getBeanObject("stockItemConsumptionBean","eST.StockItemConsumptionBean",request);
		int i	=0;
		bean.setLanguageId(locale);
		//Added for GHL-CRF-0413 starts
		ArrayList barcodeExp = new ArrayList();
	   	ArrayList itemCodeExp = new ArrayList();
		int doc_srl_no_forbean = -1;
		String qtyList = "";
		String p[]=null;
		int tmp = 0;
		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1    =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String barcode_appl                 =  bean.checkForNull(bean.getBarcodeApplicable(),"N");
		String BarcodeWithMultipleBatches	=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		boolean site=bean.isSite_spec_yn();
 		//Added for GHL-CRF-0413 ends
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		//String doc_srl_no=bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String fnction = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String store_code = bean.checkForNull(request.getParameter("store_code"));
		String item_qty = bean.checkForNull(request.getParameter("item_qty"),"0");
		//String function_id = bean.checkForNull(request.getParameter("function_id"));
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
		String stock_item_yn = bean.checkForNull(request.getParameter("stock_item_yn"));
		String addToList = request.getParameter("addToList");
		String kit = (String)request.getParameter("kit")==null?"":(String)request.getParameter("kit");
		ArrayList alBatchRecords = null;
		HashMap hmBatchRecord = null;
		String className	    =	"";
		String allow_decimals_yn	=	"N";
		String batch_qty	    =	"";
		//String date_legend="Expiry Dt";
		String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		/*Added by Shazana for INC065695 MMS-DM-CRF-0112 START*/
		double tmp_conv=bean.getConvFactTemp(item_code,store_code);
		System.out.println("tmp_conv in StockItemConsumptionListDetail.jsp: "+tmp_conv);
		/*Added by Shazana for INC065695 MMS-DM-CRF-0112 END*/
		int EWDays = 0;
		int expired_batch = 0;
		
		int no_of_decimals					=			bean.getNoOfDecimals();
		int no_of_decimals_temp				=			bean.getNoOfDecimals();
		
		try { 
			
				EWDays = bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
			if(function.equals("modify"))	{
//Modified for GHL-CRF-0413 starts				
				HashMap hmDetailRecord  = new HashMap();
				if (site)
					hmDetailRecord	=	(HashMap) bean.getDtlRecordforBarCode(Integer.parseInt(index));
				else
					hmDetailRecord	=	(HashMap)bean.getDtlRecord(Integer.parseInt(index)); 
				if (site)
					alBatchRecords =(ArrayList)bean.getExpRecordsforBarCode(Integer.parseInt(index)); 
				else
					alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
//Modified for GHL-CRF-0413 ends
			/* 	HashMap hmDetailRecord	=	(HashMap)bean.getDtlRecord(Integer.parseInt(index)); 
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
			 */	expiry_yn=(String)hmDetailRecord.get("expiry_yn");
				stock_item_yn=(String)hmDetailRecord.get("stock_item_yn");
				if (stock_item_yn.equals("N")) 
					return;
				//Added against GHL-CRF-0413 starts
	      		ArrayList setTmpList = new ArrayList(alBatchRecords);
				bean.setTempBatchRecords(setTmpList);
				doc_srl_no_forbean = (Integer.parseInt(index));
				//Added against GHL-CRF-0413 ends
			}else if(function.equals("edit"))	{
				StUtilities bean1 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				hmParameters.put("TRN_TYPE","CON");//Added for GHL-SCF-1169 
				HashMap hmReturn	=	bean1.getBatches(hmParameters);
				alBatchRecords		=	(ArrayList)hmReturn.get("BATCH_DATA"); 
				HashMap hmTemp		= null;
				ArrayList alTemp	= null;
				for(i=0;i<alBatchRecords.size();i++){
					hmBatchRecord=(HashMap)alBatchRecords.get(i);
                    String stItem_code =(String)hmBatchRecord.get("ITEM_CODE");
					String stBatch_id=(String)hmBatchRecord.get("BATCH_ID");
					String stExpiry_date=(String)hmBatchRecord.get("EXPIRY_DATE");
					alTemp = bean.getBatchStatus(stItem_code,stBatch_id,stExpiry_date);
					hmTemp = (HashMap)alTemp.get(0) ;
					String stBatch_status =(String)hmTemp.get("BATCH_STATUS") ;
					hmBatchRecord.put("BATCH_STATUS",stBatch_status);
				}
				//Added for GHL-CRF-0413 starts
				if(site){
					 doc_srl_no_forbean = Integer.parseInt(index);
					if(doc_srl_no_forbean== -1 && bean.getDtlRecordsforBarCode().size()>0){
						for(int h =0; h< bean.getDtlRecordsforBarCode().size();h++){
							HashMap hmDtl = new HashMap();
							hmDtl = bean.getDtlRecordforBarCode(h);
							if(hmDtl.containsValue(item_code))
								doc_srl_no_forbean = h;
						}
					} 
					bean.getTempBatchRecords().clear();
					 ArrayList albaArrayList = alBatchRecords;
					 ArrayList albaArrayList1 = new ArrayList();
					 HashMap hmBatchRecord1 = null;
					 for(i=0;i<albaArrayList.size();i++){
							hmBatchRecord1=(HashMap)albaArrayList.get(i);
							hmBatchRecord1.remove("QTY");//removed qty to avoid double posting of qty after clicking 'Add' button
							albaArrayList1.add(hmBatchRecord1);
				}
					bean.setTempBatchRecords(albaArrayList1);
				}
				else{//Added for GHL-CRF-0413 ends
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
				}
				putObjectInBean("stUtilities",bean1,request);

			}
			//Added for GHL-CRF-0413 starts
			else if (fnction.equals("additionalBatch")){
				try
				{
					String barcode = bean.checkForNull(request.getParameter("barcode"));
 					qtyList = bean.checkForNull(request.getParameter("qtyList"));
   					p=qtyList.split(",");
   					System.out.println("qtyList--->"+qtyList);
   					System.out.println("p--->"+p);
   					ArrayList oldBatchExpList = new ArrayList();
   					ArrayList tmpList  = new ArrayList();
   					if(bean.getTempBatchRecords().size()>0 ){
   					oldBatchExpList = bean.getTempBatchRecords();//old records in current trnsaction	
   					}
   					if(BarcodeWithMultipleBatches.equals("Y")){
   						BatchSearchBeanForBarcode bean3 = (BatchSearchBeanForBarcode) getBeanObject("batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode", request  );
   						bean3.setLanguageId(locale);
   						tmpList = bean3.getSelectedList();
   						System.out.println("alBatchRecords getSelectedList in 271 SalesListDetail.jsp ..."+alBatchRecords);
   						if (tmpList==null) {
   						throw new Exception("No batch selected..");
   						}
   						putObjectInBean("batchSearchBeanForBarcode",bean3,request);
   					}else{
	   				StUtilities bean2 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
					bean2.setLanguageId(locale);
					HashMap hmParameters	=	new HashMap();
					HashMap newExpBatchMap   = new HashMap();
					hmParameters.put("ITEM_CODE",item_code);
					hmParameters.put("STORE_CODE",store_code);
					hmParameters.put("BARCODE_ID",barcode);
					hmParameters.put("TRN_QTY","0");
					String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Adding start for MMS-DM-CRF-0174.6
					HashMap hmReturn = new HashMap();
					System.err.println("barcode_2d_applicable_ynlist details=="+barcode_2d_applicable_yn);
					if(barcode_2d_applicable_yn.equals("Y")){
						    hmReturn = bean2.get2DBarcodeDetails(hmParameters);
					}else{//Adding end for MMS-DM-CRF-0174.6
					        hmReturn	=	bean2.getAllBatches(hmParameters);
					}
					System.out.println("hmReturn---->"+hmReturn);
					tmpList = (ArrayList)hmReturn.get("BATCH_DATA");// new batch searched in current transaction
					putObjectInBean("stUtilities",bean2,request);
   					}
   				//Added against IN:062242 starts	
   					String user_id = bean.getLoginById();
   					System.out.println("user_id--->   "+user_id);
   					String PROCESS_SUSPENDED_ITEMS_YN = ((String)	bean.fetchRecord("SELECT PROCESS_SUSPENDED_ITEMS_YN FROM ST_USER_ACCESS_for_STORE WHERE USER_ID = ? AND STORE_CODE = ?",new String[]{user_id,store_code}).get("PROCESS_SUSPENDED_ITEMS_YN"));
   				 	System.out.println("PROCESS_SUSPENDED_ITEMS_YN--->   "+PROCESS_SUSPENDED_ITEMS_YN);
	    			        HashMap record_suspend	=	(HashMap)tmpList.get(0); 
   					 if(PROCESS_SUSPENDED_ITEMS_YN.equals("N"))	{
   						String suspend_yn = (String)record_suspend.get("SUSPENDED_YN");
   						System.out.println("SUSPENDED_YN--->   "+suspend_yn);
   						if(suspend_yn.equals("Y")){
   							tmpList.clear();%>
   						 <script>
   						alert(getMessage("SUSPENDED_BATCH", "ST"));
   						refreshDetailsforBarCode('999','StockItemConsumptionListHeader','StockItemConsumptionDetail','','','','','');
   						 </script><%
   						 }
   					} 
   					 BatchSearchBeanForBarcode expiryBean				=		(BatchSearchBeanForBarcode) getBeanObject( "batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode",request );
					 String expiry_date  =		(String)record_suspend.get("EXPIRY_DATE");
					String item_code_expiry = (String)record_suspend.get("ITEM_CODE");
				 String 	USE_AFTER_EXPIRY_YN = ((String) bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_EXPIRED_OR_NOT"), item_code_expiry).get("USE_AFTER_EXPIRY_YN"));
				 String PROCESS_EXPIRED_ITEMS_YN = ((String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_EXPIRED_USER_ACCESS"),new String[]{store_code,user_id}).get("PROCESS_EXPIRED_ITEMS_YN"));
				 System.out.println("PROCESS_EXPIRED_ITEMS_YN--->   "+PROCESS_EXPIRED_ITEMS_YN);
				 System.out.println("USE_AFTER_EXPIRY_YN--->   "+USE_AFTER_EXPIRY_YN);
				 System.out.println("expiry_date--->   "+expiryBean.isGreaterThanSysdate(expiry_date));
				 if(!expiryBean.isGreaterThanSysdate(expiry_date)) 
				 {
					 if(PROCESS_EXPIRED_ITEMS_YN.equals("N") || USE_AFTER_EXPIRY_YN.equals("N")){
							tmpList.clear();%>
						 <script>
						 alert(getMessage("EXPIRED_BATCH", "ST"));
						refreshDetailsforBarCode('999','StockItemConsumptionListHeader','StockItemConsumptionDetail','','','','','');
						 </script><%
						 }
				 }
				 putObjectInBean("batchSearchBeanForBarcode",expiryBean,request);	
   				//Added against IN:062242 ends	 
   					ArrayList tempBatchRecordsList = new ArrayList();
   					tempBatchRecordsList = null;
					 System.err.println("tmpList 290"+tmpList);// new batch searched in current transaction
					 if(oldBatchExpList.size()>0)
					 {
						 tempBatchRecordsList=oldBatchExpList;
						 if(tmpList.size()>0)
						 tempBatchRecordsList.addAll(tmpList);
					 }
					 else
						 if(tmpList.size()>0)
						 tempBatchRecordsList = tmpList;
					  System.err.println("tempBatchRecordsList 300"+tempBatchRecordsList);
					  if(tmpList.size()>0){
					  ArrayList setTmpList = new ArrayList(tempBatchRecordsList);
					bean.setTempBatchRecords(setTmpList);  //curr trans all batches
					  }
					 ArrayList OldExpRecords = new ArrayList();
					HashMap CurrBatchRecords = new HashMap();
					doc_srl_no_forbean = bean.getDtlRecordsforBarCode().size();
					System.out.println("doc_srl_no_forbean !305-->"+doc_srl_no_forbean);
					ArrayList alTmpList = new ArrayList();
					 if(bean.getDtlRecordsforBarCode().size()>0 ){
						 for(int m1=0; m1 < bean.getDtlRecordsforBarCode().size() ; m1++){ ///get the index for the itemcode
								HashMap hmTmp=(HashMap) bean.getDtlRecordsforBarCode().get(m1);
								 System.out.println("hmTmp-->"+hmTmp);
									if( hmTmp.containsValue(item_code)){
										System.out.println("item  "+item_code+"m1  "+m1);
										 tmp = m1;
										doc_srl_no_forbean = tmp;	
									}
						 }
					 }
							if(alBatchRecords==null)
								alBatchRecords = bean.getTempBatchRecords();
							else
								alBatchRecords.addAll(bean.getTempBatchRecords());//curr trans all batches  
							System.out.println("check in else if StockItemConsumptionListDetail.jsp 342...doc_srl_no.."+doc_srl_no_forbean);
							System.out.println("check in else if StockItemConsumptionListDetail.jsp 342...alBatchRecords.."+alBatchRecords);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in StockItemConsumptionListDetail.jsp ...function=additionalBatch..");
					throw ex;
				}
			} 
			//Added for GHL-CRF-0413 ends
			else
			{
				BatchSearchBean bean2 = (BatchSearchBean)getBeanObject("batchSearchBean", "eST.BatchSearchBean", request);
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();
				if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
					}
				//Added for GHL-CRF-0413 starts
				if(site)
				{
					doc_srl_no_forbean = Integer.parseInt(index);
					if(doc_srl_no_forbean == -1)		{
						for(int h =0;h<alBatchRecords.size();h++){
							HashMap hmBatchRec =(HashMap) alBatchRecords.get(h);
							String val_item = (String)hmBatchRec.get("ITEM_CODE");
							ArrayList alDtl = bean.getDtlRecordsforBarCode();
							for(int j=0;j<alDtl.size();j++)
							{
								HashMap hmDtl =(HashMap) alDtl.get(j);
								if(hmDtl.containsValue(val_item))
									doc_srl_no_forbean = j;
							}
						}
					}
							bean.getTempBatchRecords().clear();
							ArrayList albaArrayList = new ArrayList(alBatchRecords);
							bean.setTempBatchRecords(albaArrayList);
				}
				else{//Added for GHL-CRF-0413 ends
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
				}
				putObjectInBean("batchSearchBean",bean2,request);

				}
			if(expiry_yn.equals("N")) {
				//date_legend="Receipt Dt";
				 date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}
			//bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
	%>
	<body >
		<form name='formStockItemConsumptionListDetail' id='formStockItemConsumptionListDetail'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center">
 			<tr>
				<th><%=date_legend%></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.SaleQuantity.label" bundle="${common_labels}"/></th>
			</tr>
			<%
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
						/**
			* @Name - SURI
			* @Date - 20/01/2010
			* @Inc# - 15496
			* @Desc -  Decimal handling in item based.dec_allowed_yn 
			*/
			//Added for GHL-CRF-0413 starts
			 //barcodeExp.add((String)hmBatchRecord.get("BARCODE_ID"));
			 barcodeExp.add(bean.checkForNull((String)hmBatchRecord.get("BARCODE_ID"), ""));
			bean.setAlBarcodeExp(barcodeExp);
			itemCodeExp.add((String)hmBatchRecord.get("ITEM_CODE"));
			bean.setAlItemcodeExp(itemCodeExp);
			//Added for GHL-CRF-0413 ends
			allow_decimals_yn=((String)hmBatchRecord.get("ALLOW_DECIMALS_YN"));
			if(allow_decimals_yn.equals("N")){
				no_of_decimals = 0;
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals);
			}else{
				no_of_decimals = no_of_decimals_temp;
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals);
			}
			System.err.println("getConvFactTemp@@==="+bean.getConvFactTemp(item_code,store_code)+"batch_qty==="+batch_qty);
			%>
			<tr id="tr_<%=i%>">
				<%
					if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays){
					expired_batch = expired_batch + 1;    %>
			
           <%
					 if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0){
			%>
					<td  class="<%=className%>" nowrap   name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><!-- hmBatchRecord.get("EXPIRY_DATE")  changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015-->
					<font class="DATAHIGHLIGHT"><center><%="Exp. "+(String)hmBatchRecord.get("NOD")+"Days"%></center></font>
					</td>
		<%	}else{%>
<%
                       //String stTempStatus = "Expired";
					String stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
					   if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C")){
						  // stTempStatus ="Exp./Notified" ;
							stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Notified.label","st_labels");
						   %>
                  				<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><!-- hmBatchRecord.get("EXPIRY_DATE")  changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015--><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>


						   <%
							 } else if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S")){
						//	stTempStatus ="Exp./Suspnd" ;
							stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Suspend.label","st_labels");
					   %>
					<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><!-- hmBatchRecord.get("EXPIRY_DATE") changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015 --><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
<%                  } else {
	%> 
		<td  class="<%=className%>" nowrap    name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><!-- hmBatchRecord.get("EXPIRY_DATE")  changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015--><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
	<%
}
					} 
					  %>
                   
            <%
					} else {
					   %>
 			<%
					if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C"))
				{ %>

				 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);">				<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><!-- hmBatchRecord.get("EXPIRY_DATE")  changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015 --><br><font class="DATAHIGHLIGHT"><fmt:message key="eST.Notified.label" bundle="${st_labels}"/></font></center>
                 </td>
				<%
				}
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S"))
				{ 
						%>
							 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);">		<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><!-- hmBatchRecord.get("EXPIRY_DATE") changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015 --><br><font class="DATAHIGHLIGHT"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></font></center>	</td>
						<% 
				}  %>	  
			<%
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("A"))
				{ 	%>
				     <td  class="<%=className%>" >
						<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><!-- hmBatchRecord.get("EXPIRY_DATE") changed for RollForward from SRR - SRR20056-SCF-9528 by B.Badmavathi on 13/08/2015--></center>
                     </td>
                 <% 
				       }
			}			 %>

		<td class="<%=className%>" nowrap  name="batch_id_<%=i%>" ><%=hmBatchRecord.get("BATCH_ID")%></td>
					<td class="<%=className%>" nowrap ><%=bean.checkForNull((String)hmBatchRecord.get("TRADE_NAME"))%></td>
					<td class="<%=className%>" nowrap ><%=hmBatchRecord.get("BIN_DESC")%></td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align AVAIL_QTY.				
					-->
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right" ><%=hmBatchRecord.get("AVAIL_QTY")%>&nbsp;</td>
				<%if(function.equals("additionalBatch") ){//Added for GHL-CRF-0413 starts %>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=8 maxlength=7 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=p[i]%>"  
					 onBlur="checkBatchQty(this,available_qty_<%=i%>.value);" ></td>
					<%}else{ //Added for GHL-CRF-0413 ends%>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size=12 maxlength=12 class="NUMBER" value="<%=(function.equals("edit")||function.equals("modify"))?batch_qty:""%>" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="checkBatchQty(this,available_qty_<%=i%>.value);"></td>
					<%} %>
				</tr>
					<input type="hidden" name="available_qty_<%=i%>" id="available_qty_<%=i%>" value="<%=hmBatchRecord.get("AVAIL_QTY")%>">
						<input type="hidden" name="manufacturer_name_<%=i%>" id="manufacturer_name_<%=i%>" value="<%=hmBatchRecord.get("MANUFACTURER_NAME")%>">
						<!--Added for GHL-CRF-0413 starts -->
					<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=hmBatchRecord.get("BATCH_ID")%>">
					<input type="hidden" name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_DATE")%>">
					<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value="<%=hmBatchRecord.get("TRADE_ID")%>">
					<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=hmBatchRecord.get("BIN_LOCATION_CODE")%>">
					<input type="hidden" name="barcode_<%=i%>" id="barcode_<%=i%>" value="<%=hmBatchRecord.get("BARCODE_ID")%>">
					<!-- Added against GHL-CRF-0413 ends-->
			<%	}
				
			%>
				<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
				<input type="hidden" name="expired_batch" id="expired_batch" value="<%=expired_batch%>">
				<input type="hidden" name="ex_param_days" id="ex_param_days" value="<%=EWDays%>">
				<input type="hidden" name="batchsearch" id="batchsearch" value="<%=batchsearch%>"><!-- function changed to batchsearch GHL-CRF-0413 -->
			   <input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=allow_decimals_yn%>">
			<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals_temp%>">
			<input type="hidden"   name="doc_srl_no_forbean" id="doc_srl_no_forbean"  value ="<%=doc_srl_no_forbean %>">
			<input type="hidden"	name="tmp_conv" id="tmp_conv"					value='<%=tmp_conv%>'>	<!--  Added by Shazana for INC065695 MMS-DM-CRF-0112-->

		</form>
	<script language="JavaScript">
<%
	if (addToList!=null){
		if(((String)kit).equals("kit") || (fnction.equals("edit"))){
			if(site){//Added for GHL-CRF-0413 starts%>
				parent.frameStockItemConsumptionListHeader.callItemQtyUpdate();
				parent.frameStockItemConsumptionListHeader.addToListforBarcode();
			<%}
			else {
				%>
				parent.frameStockItemConsumptionListHeader.addToList1();
<%			}
		}
		else if(fnction.equals("additionalBatch")){
			 %>				
				parent.frameStockItemConsumptionListHeader.addToListforBarcode();
				<%
		}//Added for GHL-CRF-0413 ends
		else{
%>
		parent.frameStockItemConsumptionListHeader.addToList();
<%
		}
	}
//Added for GHL-CRF-0413 starts
	else if (fnction.equals("additionalBatch")){
		if (defaultqty_appl.equals("Y")){
	%>	
			parent.frameStockItemConsumptionListHeader.callItemQtyUpdate();
	<%	}
	}
    %>//Added for GHL-CRF-0413 ends
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {
			/*Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 beg
			//out.println("Insufficient Quantity.");
			//out.println(insufficientBatchException);*/%>
			<script>alert(getMessage("INSUFFICIENT_BATCH_QTY","ST"));</script>
			<%//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] end
			insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
			//Added for GHL-SCF-1169 starts  
			if(exception.getMessage().equals("EXPIRED_BATCH"))
					{
				%><script>
				parent.frameStockItemConsumptionListHeader.document.formStockItemConsumptionListHeader.apply.disabled = false;
				alert(getMessage("EXPIRED_BATCH_CONS","ST"));
				</script>
				<%
					}
			else{
				//Added for GHL-SCF-1169  ends
				out.println(exception.getMessage());
				exception.printStackTrace();
			}
		}
%>
 <%
putObjectInBean("stockItemConsumptionBean",bean,request);
%>
	</body>
</html>

