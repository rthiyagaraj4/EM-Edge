<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
??
23/06/2017		IN064605			Badmavathi B								ML-BRU-SCF-1717
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eST.BatchSearchBean, eST.Common.*,eST.StockTransferBean,java.util.HashMap,java.util.ArrayList,java.lang.*,java.sql.*,java.text.*,webbeans.eCommon.*,eST.BatchSearchBeanForBarcode" contentType="text/html;charset=UTF-8"%>
 
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
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StockTransfer.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	</head>
	<%

		StockTransferBean bean = (StockTransferBean)getBeanObject("stockTransferBean","eST.StockTransferBean",request);
		bean.setLanguageId(locale);
		eST.Common.StDuoHeaderBean beanHdr = (eST.Common.StDuoHeaderBean) getBeanObject("stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
		int i	=0;
		beanHdr.setLanguageId(locale);
		String index=bean.checkForNull(request.getParameter("index"),"-1");
	//	String doc_srl_no=bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String fnction = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String store_code = bean.checkForNull(request.getParameter("store_code"));
		String to_store_code = bean.checkForNull(beanHdr.getTo_store_code());
		String item_qty = bean.checkForNull(request.getParameter("item_qty"));
	//	String function_id = bean.checkForNull(request.getParameter("function_id"));
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
		String addToList = request.getParameter("addToList");
		String LoginFacilityId = bean.getLoginFacilityId();

		//ganga
		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
		String barcode_appl                 =		bean.checkForNull(bean.getBarcodeApplicable(),"N");
		String BarcodeWithMultipleBatches	=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		
		

        String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
	    String no_deci            =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		if(allow_deci_yn.equals("N"))
        no_deci ="0";

		

		String kit = (String)request.getParameter("kit")==null?"":(String)request.getParameter("kit");
		ArrayList alBatchRecords = null;
		
		HashMap hmBatchRecord = null;
		//String BatchKey = "";
		String className	=	"";
		//String date_legend="Expiry Dt";
		String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
        int EWDays = 0;
		int expired_batch = 0;
        String   trn_type = "";
		String  saleprice= ""; 
		String  display_flag					= "visibility:hidden";
		String  display = ""; 

		

		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1    =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String mode = bean.getMode();
		

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl1.equals("N")){
		Qty_disabled  = "disabled"	;
		}

		try { 
			

			EWDays = bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));

			if(expiry_yn.equals("N")) {
				//date_legend="Receipt Dt";
				 date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}

			String defaultBinLocationCode	=	bean.getDefaultBinLocationCode(to_store_code,item_code);	
			System.out.println("defaultBinLocationCode== T95 === >"+defaultBinLocationCode);				
			
			
			if(function.equals("modify"))	{
				
				//alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 

				if (BARCODE_YN.equals("TRUE"))
				alBatchRecords =(ArrayList)bean.getExpRecordsforBarCode(Integer.parseInt(index)); 
				else
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 


				}
			else if(function.equals("edit"))	{
				
				StUtilities bean1 = (StUtilities)getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean1.getBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				ArrayList alTemp	= null;
				HashMap hmTemp		= null;
				for(i=0;i<alBatchRecords.size();i++){
					hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				
                    String stItem_code =(String)hmBatchRecord.get("ITEM_CODE");
					String stBatch_id=(String)hmBatchRecord.get("BATCH_ID");
					String stExpiry_date=(String)hmBatchRecord.get("EXPIRY_DATE");
					alTemp = bean.getBatchStatus(stItem_code,stBatch_id,stExpiry_date);
					hmTemp = (HashMap)alTemp.get(0) ;
                    String stBatch_status =  (String)hmTemp.get("BATCH_STATUS") ;
					hmBatchRecord.put("BATCH_STATUS",stBatch_status);
				}

				System.out.println("kit...in..StockTransListDetail.jsp... "+kit+"--bean.getBarcodeApplicable():"+bean.getBarcodeApplicable());
				if(((String)kit).equals("kit")  && bean.getBarcodeApplicable().equals("Y")){
				for(int h=0;h<alBatchRecords.size();h++){
				HashMap ht = (HashMap)alBatchRecords.get(h);
				ht.put("KIT","KIT");
				}
				System.out.println("kit...in..StockTransListDetail.jsp... "+alBatchRecords);
				bean.setExpRecordsforBarCode( Integer.parseInt(index), alBatchRecords);
				}



				putObjectInBean("stUtilities",bean1,request);
			}
			//added for barcode
				else if(function.equals("barcode"))	{
				try
				{
				boolean check = true;
				ArrayList OldExpRecords = new ArrayList();
				HashMap CurrBatchRecords = new HashMap();

				if(BarcodeWithMultipleBatches.equals("Y")){
					BatchSearchBeanForBarcode bean3 = (BatchSearchBeanForBarcode) getBeanObject("batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode", request  );
					bean3.setLanguageId(locale);
					alBatchRecords = bean3.getSelectedList();
					System.out.println("alBatchRecords getSelectedList in StockTransferListDetail.jsp ..."+alBatchRecords);
					if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
					}
					putObjectInBean("batchSearchBeanForBarcode",bean3,request);
				}else{
					alBatchRecords = bean.getBatchRecords() ;
				}

				//alBatchRecords = bean.getBatchRecords() ;

				System.out.println("StockTransferListDetail alBatchRecords=====148=>"+alBatchRecords); 
				for(int binlocn=0; binlocn < alBatchRecords.size() ; binlocn++) {
				HashMap hmBatchRecord1 = (HashMap)alBatchRecords.get(binlocn);
				//HashMap hmBatchRecord1 = (HashMap)alBatchRecords.get(0);
				hmBatchRecord1.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				hmBatchRecord1.put("RET_ITEM_QTY",	"0");

				store_code = (String)hmBatchRecord1.get("STORE_CODE");
				}

				System.out.println("StockTransferListDetail alBatchRecords=====155=>"+alBatchRecords); 
				System.out.println("index...in..StockTransferListDetail.jsp... "+index);				
				
				ArrayList DtlRecords  = new ArrayList();
				DtlRecords =	bean.getDtlRecordsforBarCode()==null?DtlRecords:bean.getDtlRecordsforBarCode();

				if (DtlRecords.size()>0){
					ArrayList altemp = bean.getDtlRecordsforBarCode();
					for (int m = 0 ; m < altemp.size() ; m++){
					HashMap temp = (HashMap)altemp.get(m);
					if((temp.get("item_code")).toString().equals(item_code)) {
					//int pdoc_srl_no = Integer.parseInt((String)temp.get("doc_srl_no"));
					//--pdoc_srl_no;
					int pdoc_srl_no = m;

					OldExpRecords = bean.getExpRecordsforBarCode(pdoc_srl_no);
												
					int OldExp = OldExpRecords.size();
					for ( int m1=0; m1 < alBatchRecords.size(); m1++ ){
					boolean isExist = false;
					CurrBatchRecords =(HashMap)alBatchRecords.get(m1) ;					
					
					for ( int m2 = 0 ; m2 < OldExp ; m2++){
					HashMap exp = (HashMap)OldExpRecords.get(m2);
				
					if (( CurrBatchRecords.get("ITEM_CODE").equals(exp.get("ITEM_CODE")) &&  CurrBatchRecords.get("BATCH_ID").equals(exp.get("BATCH_ID")) &&  CurrBatchRecords.get("EXPIRY_DATE").equals(exp.get("EXPIRY_DATE"))	&& 	CurrBatchRecords.get("BIN_LOCATION_CODE").equals(exp.get("BIN_LOCATION_CODE")) &&  CurrBatchRecords.get("TRADE_ID").equals(exp.get("TRADE_ID")))){
					isExist = true;
					}  					
					}
					if (!isExist){
					OldExpRecords.add(CurrBatchRecords);
					}				
					}					
					bean.setExpRecordsforBarCode( pdoc_srl_no, OldExpRecords);
					check = false;
					}
				}
				}
				if(check){
				System.out.println("StockTransferListDetail.jsp 176.."+bean.getExpRecordsforBarCode());	
				hmBatchRecord = (HashMap)alBatchRecords.get(0);
				hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				hmBatchRecord.put("RET_ITEM_QTY",	"0");
				bean.setExpRecordsforBarCode( Integer.parseInt(index), alBatchRecords);
				System.out.println("StockTransferListDetail.jsp 178.."+bean.getExpRecordsforBarCode());	
				}

				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in StockTransferListDetail.jsp ...function=barcode..");
					System.out.println(ex.toString());
				}
				}

				else if (fnction.equals("addbarcode")){
				
				try
				{
				StUtilities bean2 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean2.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean2.getBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				//Modified against ML-BRU-SCF-1717 starts
				/*
				hmBatchRecord = (HashMap)alBatchRecords.get(0);
				hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);	
				hmBatchRecord.put("RET_ITEM_QTY",	"0");
				*/
				for(int k=0; k < alBatchRecords.size() ; k++) {
					hmBatchRecord = (HashMap)alBatchRecords.get(k);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
					hmBatchRecord.put("RET_ITEM_QTY",	"0");
				}
				//Modified against ML-BRU-SCF-1717 ends
				bean.setAddBatchRecords(alBatchRecords);
				putObjectInBean("stUtilities",bean2,request);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in StockTransferListDetail.jsp ...function=addbarcode..");
					throw ex;//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				}
			}
				else if(function.equals("2DBARCODE")){//Added for MOHE-CRF-0167
					String bar_code = bean.checkForNull(request.getParameter("bar_code"));
					String barcodeExist="";
					String newitem_exist="";
					 String select_array="";
					 ArrayList select_hashmap=new ArrayList();
					String item_2d_barcode_yn =bean.barcode2DApplicable();
					ArrayList alBatchRecords1 = new ArrayList();
					HashMap barcodeBatchRecords = new HashMap();
					HashMap ExpRecords = new HashMap();
					alBatchRecords1=bean.get2DBarcodeBacthes(store_code,bar_code);
					if(alBatchRecords1.size()>0){
					barcodeBatchRecords=(HashMap)alBatchRecords1.get(0);
					int avail_qty=Integer.parseInt((String)barcodeBatchRecords.get("AVAIL_QTY"));
					if(avail_qty>0){
					
						 if(((bean.getExpRecords()).size()>=1) && !item_code.equals("")){	
								ExpRecords=bean.getExpRecords();
								for (Object key : ExpRecords.keySet()) {
									String k = (String) key;
							alBatchRecords = (ArrayList)bean.getExpRecords(Integer.parseInt(k));
							for(i=0;i<alBatchRecords.size();i++){
								hmBatchRecord=(HashMap)alBatchRecords.get(i);
								String barcodeitem_code=(String)barcodeBatchRecords.get("ITEM_CODE");
								if(barcodeitem_code.equals((String)hmBatchRecord.get("ITEM_CODE"))){

									  select_array=k;
									  select_hashmap.add(i);
								}
							} // end i
							} // end j
								if(!select_array.equals("")){
								for (Object key : ExpRecords.keySet()) {
									String k = (String) key;
									if(select_array.equals(k)){
										alBatchRecords = (ArrayList)bean.getExpRecords(Integer.parseInt(k));
										for(int x=0 ; x<select_hashmap.size() ; x++ ){
											hmBatchRecord=(HashMap)alBatchRecords.get(x);
								String barcode_data1=(String)barcodeBatchRecords.get("EXPIRY_DATE")+(String)barcodeBatchRecords.get("BATCH_ID")+(String)barcodeBatchRecords.get("TRADE_ID")+(String)barcodeBatchRecords.get("BIN_LOCATION_CODE")+(String)barcodeBatchRecords.get("ITEM_CODE");
								if(barcode_data1.equals((String)hmBatchRecord.get("EXPIRY_DATE")+(String)hmBatchRecord.get("BATCH_ID")+(String)hmBatchRecord.get("TRADE_ID")+(String)hmBatchRecord.get("BIN_LOCATION_CODE")+(String)hmBatchRecord.get("ITEM_CODE"))) {
									barcodeExist="Y";
									int j=Integer.parseInt((String)hmBatchRecord.get("QTY"));
									j=j+1;
									String Str_j=String.valueOf(j);
									hmBatchRecord.put("QTY",Str_j);
							}
							} // end i
							} // end j
								} 
							if(!barcodeExist.equals("Y")){		
								barcodeBatchRecords.put("QTY","1");
								barcodeBatchRecords.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
							alBatchRecords.add(barcodeBatchRecords);
					}
						 }else {
									alBatchRecords = bean.get2DBarcodeBacthes(store_code,bar_code);
									hmBatchRecord=(HashMap)alBatchRecords.get(0);
									hmBatchRecord.put("QTY","1");
								}
						
						}else {
							alBatchRecords = bean.get2DBarcodeBacthes(store_code,bar_code);
							hmBatchRecord=(HashMap)alBatchRecords.get(0);
							hmBatchRecord.put("QTY","1");
						}
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
					function="edit";
					
					} else {
						throw new InsufficientBatchException();
					}
						
					} else {
						throw new Exception("ITEM_STORE_ITEM_CLASS_NOT_FOUND");
					}
				} // end


			else
			{

				BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean", request );
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();
				if (alBatchRecords.size() >0)
				{
					for(i=0;i<alBatchRecords.size();i++){
					hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				}
				}
				else
				{
					//	hmRecord=bean.getDtlRecord(Integer.parseInt(index));
					alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
					function="modify";
								}
			putObjectInBean("batchSearchBean",bean2,request);
			}
			
			//if((function.equals("barcode")) || (fnction.equals("barcode")) || ( batchsearch.equals("newbatch") && barcode_appl.equals("Y"))){
			//}
			//else{
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			//}


			//Added By Rabbani #inc no:28266 on 16/09/11 
	       //Starts Here

		   ArrayList  alist =  bean.getTrnTypeArrayList();
	         for(int k=0; k<alist.size(); k++){
	         HashMap  blist = (HashMap)alist.get(k);
	         for(int l=0; l<blist.size();l++){
	          trn_type = (String)blist.get("TRNTYPE");
	           if(trn_type.equals("TFR")){
		       if(((String)bean.getAccessSaleyn(store_code)).equals("Y")){ 
		         display = "visible";		   
	  	         display_flag	="visibility:visible"; 
			 }		 
		   } 
		}
	}
	 
	 //ends



	%>
	<!--<body onLoad="FocusFirstElement()">-->
	<body>
		<form name='formStockTransferListDetail' id='formStockTransferListDetail'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center">
 			<tr>
				<th><%=date_legend%></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ToStoreMasterBin.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.TransferQty.label" bundle="${st_labels}"/></th>
				<%if(display.equals("visible")){%>
				 <th style="<%=display_flag%>"><fmt:message key="eST.saleprice.label" bundle="${st_labels}"/></th>  
				 <%}%>
			</tr>
			<%
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
				//Added By Rabbani #inc no:28266 on 16/09/11

				try{
				String pitem_code=(String)hmBatchRecord.get("ITEM_CODE");
				String pbatch_id=(String)hmBatchRecord.get("BATCH_ID");
			    String ptrade_id=(String)hmBatchRecord.get("TRADE_ID");
				saleprice	 =  (String)bean.getSalePrice(LoginFacilityId,"I",pitem_code,ptrade_id,pbatch_id);
			  }
			  catch ( Exception e ){
					e.printStackTrace() ;
				}
				//ends
			 

				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
			%>



<tr id="tr_<%=i%>">
				<%
					if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays){
					expired_batch = expired_batch + 1;    %>

				
           <%
					 if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0){
			%>
					<td  class="<%=className%>" nowrap   name="expiry_date_or_receipt_date_<%=i%>" ><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%>
					<font class="DATAHIGHLIGHT"><center><%="Exp. "+(String)hmBatchRecord.get("NOD")+"Days"%></center></font>
					</td>

                    

			<%	}else{%>
				

<%
                      // String stTempStatus = "Expired";
String stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
					   if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C")){
		//				   stTempStatus ="Exp./Notified" ;
		stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Notified.label","st_labels");

						   %>
                  				<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>


						   <%
							 } else if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S")){
						//	stTempStatus ="Exp./Suspnd" ;
							stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Suspend.label","st_labels");
					   %>
<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
						

<%                  } else {

	%> 
		<td  class="<%=className%>" nowrap    name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
	
	
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

				 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" >				<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><br><font class="DATAHIGHLIGHT"><fmt:message key="eST.Notified.label" bundle="${st_labels}"/></font></center>
                 </td>
				<%
				}
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S"))
				{ 
						%>
							 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" >		<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><br><font class="DATAHIGHLIGHT"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></font></center>	</td>
						<% 
				}  %>	  
			<%
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("A"))
				{ 	%>
				     <td  class="<%=className%>"  >
						<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%></center>
                     </td>
                 <% 
				       }
			}			 %>


					<td class="<%=className%>" nowrap  name="batch_id_<%=i%>" ><%=hmBatchRecord.get("BATCH_ID")%></td>
					<td class="<%=className%>"  ><%=hmBatchRecord.get("TRADE_NAME")%></td>
					<td class="<%=className%>"  ><%=hmBatchRecord.get("BIN_DESC")%></td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Avaiable Qty.				
					-->
					<td class="<%=className%>" nowrap  name="avail_qty" style="TEXT-ALIGN:right"><span id="id_stock_avail_<%=i%>"><%=bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),Integer.parseInt(no_deci))%></span>&nbsp;</td>
					<td class="<%=className%>" nowrap ><select class="STSMALL" name="to_bin_location_code_<%=i%>" id="to_bin_location_code_<%=i%>"><%=bean.getSTITBin_location_code_List(to_store_code,(String)hmBatchRecord.get("ITEM_CODE"),(String)hmBatchRecord.get("TO_BIN_LOCATION_CODE"),locale)%></select></td>
					<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size=12 maxlength=12 class="NUMBER" onkeypress="allow_restrict_decimals1(this,event);" onBlur="return CheckDtlQuantity('<%=i%>');" value="<%=(function.equals("edit")||function.equals("modify"))?bean.setNumber((String)hmBatchRecord.get("QTY"),Integer.parseInt(no_deci)):""%>"   <%=Qty_disabled%> ></td>
					<%if(display.equals("visible")){%>
				 	<td class="<%=className%>" nowrap  name="saleprice" style =  "<%=display_flag%>";"TEXT-ALIGN:right"><span id="id_sales_price<%=i%>"><%=saleprice%></span>&nbsp;</td>  
					<%}%>

				</tr>
					<!--added-->
					<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=hmBatchRecord.get("BATCH_ID")%>">
					<input type="hidden" name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_DATE")%>">
					<!--ended-->
					<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value="<%=hmBatchRecord.get("TRADE_ID")%>">
					<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=hmBatchRecord.get("BIN_LOCATION_CODE")%>">
					<input type="hidden" name="manufacturer_name_<%=i%>" id="manufacturer_name_<%=i%>" value="<%=hmBatchRecord.get("MANUFACTURER_NAME")%>">
						 

			<%	}
				
			%>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="expired_batch" id="expired_batch" value="<%=expired_batch%>">
			<input type="hidden" name="ex_param_days" id="ex_param_days" value="<%=EWDays%>">
           <input type="hidden" name="allow_deci_yn" id="allow_deci_yn" value="<%=allow_deci_yn%>">
            <input type="hidden" name="no_deci" id="no_deci"		 value="<%=no_deci%>">
			 <input type="hidden" name="store_code" id="store_code"		 value="">

				<input type="hidden" name="batchsearch" id="batchsearch" value="<%=batchsearch%>">




		</form>
			<%
putObjectInBean("stockTransferBean",bean,request);
putObjectInBean("stDuoHeaderBean",beanHdr,request);

%>
	<script language="JavaScript">
<%
	if (addToList!=null){
		if(((String)kit).equals("kit")|| (fnction.equals("edit"))){
%>		
		parent.frameStockTransferListHeader.addToList1();
<%		
		}else{
%>
		parent.frameStockTransferListHeader.addToList();
<%
		}
	}
	else if (fnction.equals("barcode")){
	if (defaultqty_appl.equals("Y")){
	%>	
	parent.frameStockTransferListHeader.callItemQtyUpdate();
	<%	}
	}
	else if (fnction.equals("addbarcode")){
	%>	
	parent.frameStockTransferListHeader.newbatch('stockTransferBean','eST.StockTransferBean');
	parent.frameStockTransferListHeader.addToListforBarCode1('stockTransferBean','eST.StockTransferBean','StockTransferListHeader','StockTransferListDetail','StockTransferDetail');
	<%	
	}
	%>
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {
		//	out.println("Insufficient Quantity.");%>
		<!--Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014-->
			<script>alert(getMessage("INSUFFICIENT_BATCH_QTY","ST"));</script>
			<%insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
		//	out.println(exception);
			exception.printStackTrace();
			
		}
				
%>
	</body>
</html>

