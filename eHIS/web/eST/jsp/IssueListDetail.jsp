<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------

23/06/2017		IN064605			Badmavathi B								ML-BRU-SCF-1717
11/4/2022		TFS30461			Shazana 									MMS-MD-SCF-0204
---------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import="eST.BatchSearchBean,eST.Common.StUtilities, eST.IssueBean,java.util.HashMap,java.util.ArrayList,eST.BatchSearchBeanForBarcode,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/Issue.js"></script>
	</head>
	<%
		IssueBean bean						=		(IssueBean) getBeanObject("issueBean","eST.IssueBean",request);
		bean.setLanguageId(locale);
		eST.Common.StDuoHeaderBean beanHdr	=		(eST.Common.StDuoHeaderBean) getBeanObject("stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
		beanHdr.setLanguageId(locale);
		int i								=		0;
		//Added for GHL-CRF-0413 starts 
				ArrayList barcodeExp = new ArrayList();
			        ArrayList itemCodeExp = new ArrayList();
				int doc_srl_no_forbean =0;
				String qtyList = "";
				String p[]=null;
				int tmp = 0;
	     	//Added for GHL-CRF-0413 ends
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;
		String index						=		bean.checkForNull(request.getParameter("index"),"-1");
		//String doc_srl_no					=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
		String function						=		bean.checkForNull(request.getParameter("function"));
		String fnction						=		bean.checkForNull(request.getParameter("function"));
		String remarks						=		bean.checkForNull(request.getParameter("remarks"));
		String remarks_code					=		bean.checkForNull(request.getParameter("remarks_code"));

		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
		String item_code					=		bean.checkForNull(request.getParameter("item_code"));
		String store_code					=		bean.checkForNull(request.getParameter("store_code"));
		String to_store_code				=		bean.checkForNull(beanHdr.getTo_store_code());
		String item_qty						=		bean.checkForNull(request.getParameter("item_qty"));
		//String function_id				=		bean.checkForNull(request.getParameter("function_id"));
		String expiry_yn					=		bean.checkForNull(request.getParameter("expiry_yn"));
		String addToList					=		request.getParameter("addToList");
		String kit							=		(String)request.getParameter("kit")==null?"":(String)request.getParameter("kit");
		//Date d							=		new Date();
		bean.setRemarks(remarks);
		ArrayList alBatchRecords			=		new ArrayList();
		HashMap hmBatchRecord				=		new HashMap();
		//String BatchKey					=		"";
		String className					=		"";
		String decimal_allowed_yn			=		"N";
		//String date_legend				=		"Expiry Dt";
		String date_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		String includeSuspendedBatches		=		"N";
		HashMap hmRecord					=		new HashMap();
		int EWDays							=		0;
		int expired_batch					=		0;
		double tmp_conv_fac = 0.0;//MMS-MD-SCF-0204 
		try { 
			EWDays							=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
		if(expiry_yn.equals("N")) {
			//date_legend					=		"Receipt Dt";
			date_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
		}
			String defaultBinLocationCode	=		bean.getDefaultBinLocationCode(to_store_code,item_code);	



		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1    =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String mode = bean.getMode();
		//String barcode_appl                 =  bean.checkForNull(bean.getBarcodeApplicable(),"N"); commanded for unused local variable
		String BarcodeWithMultipleBatches	=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		
		/*System.out.println("BARCODE_YN== I44 === >"+BARCODE_YN);
		System.out.println("defaultqty_appl== I44 === >"+defaultqty_appl);
		System.out.println("editqty_appl1== I44 === >"+editqty_appl1);
		System.out.println("batchsearch== I44 === >"+batchsearch);
		System.out.println("barcode_appl== I44 === >"+barcode_appl);*/
		boolean site=bean.isSite_spec_yn();//Added against GHL-CRF-0413
		//if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl1.equals("N")) Modified against GHL-CRF-0413
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl1.equals("N") && !site){
		Qty_disabled  = "disabled"	;
		}




			if(function.equals("modify"))	{
				//hmRecord					=		bean.getDtlRecord(Integer.parseInt(index));			
				if (BARCODE_YN.equals("TRUE"))
				hmRecord			=(HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
				else
				hmRecord			=		bean.getDtlRecord(Integer.parseInt(index));

				//alBatchRecords			=		null;
				//alBatchRecords				=		(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
				// System.err.println("alBatchRecords-----modify------>"+alBatchRecords);

				if (BARCODE_YN.equals("TRUE"))
				alBatchRecords =(ArrayList)bean.getExpRecordsforBarCode(Integer.parseInt(index)); 
				else
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
				//Added against GHL-CRF-0413.2-US002 starts
          			ArrayList setTmpList = new ArrayList(alBatchRecords);
				bean.setTempBatchRecords(setTmpList);
				doc_srl_no_forbean = (Integer.parseInt(index));
				//Added against GHL-CRF-0413.2-US002 ends

			}
			else if(function.equals("edit"))	{
				StUtilities bean1			=		(StUtilities)getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
				HashMap hmParameters		=		new HashMap();
				HashMap hmTemp				=		new HashMap();
				ArrayList alTemp			=		new ArrayList();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn			=		bean1.getBatches(hmParameters);
				alBatchRecords				=		(ArrayList)hmReturn.get("BATCH_DATA"); 
				for(i=0;i<alBatchRecords.size();i++){
					hmBatchRecord			=		(HashMap)alBatchRecords.get(i);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
                    String stItem_code		=		(String)hmBatchRecord.get("ITEM_CODE");
					String stBatch_id		=		(String)hmBatchRecord.get("BATCH_ID");
					String stExpiry_date	=		(String)hmBatchRecord.get("EXPIRY_DATE");
                    alTemp					=		 bean.getBatchStatus(stItem_code,stBatch_id,stExpiry_date);
					hmTemp					=		(HashMap)alTemp.get(0) ;
                    String stBatch_status	=		(String)hmTemp.get("BATCH_STATUS") ;
					hmBatchRecord.put("BATCH_STATUS",stBatch_status);

				}
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);


				//System.out.println("kit...in..IssueListDetail.jsp... "+kit+"--bean.getBarcodeApplicable():"+bean.getBarcodeApplicable());
				if(((String)kit).equals("kit")  && bean.getBarcodeApplicable().equals("Y")){
				for(int h=0;h<alBatchRecords.size();h++){
				HashMap ht = (HashMap)alBatchRecords.get(h);
				ht.put("KIT","KIT");
				}
				//System.out.println("kit...in..IssueListDetail.jsp... "+alBatchRecords);
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
					//System.out.println("alBatchRecords getSelectedList in IssueListDetail.jsp ..."+alBatchRecords);
					if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
					}
					putObjectInBean("batchSearchBeanForBarcode",bean3,request);
				}else{
					alBatchRecords = bean.getBatchRecords() ;
				}

				//alBatchRecords = bean.getBatchRecords() ;
				//System.out.println("IssueListDetail alBatchRecords=====148=>"+alBatchRecords); 
				for(int binlocn=0; binlocn < alBatchRecords.size() ; binlocn++) {
				HashMap hmBatchRecord1 = (HashMap)alBatchRecords.get(binlocn);
				//HashMap hmBatchRecord1 = (HashMap)alBatchRecords.get(0);
				hmBatchRecord1.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				hmBatchRecord1.put("RET_ITEM_QTY",	"0");
				}

				//System.out.println("IssueListDetail alBatchRecords=====155=>"+alBatchRecords); 
				//System.out.println("index...in..IssueListDetail.jsp... "+index);				
				
				ArrayList DtlRecords  = new ArrayList();
				DtlRecords =	bean.getDtlRecordsforBarCode()==null?DtlRecords:bean.getDtlRecordsforBarCode();

				if (DtlRecords.size()>0){
					ArrayList altemp = bean.getDtlRecordsforBarCode();
					for (int m = 0 ; m < altemp.size() ; m++){
					HashMap temp = (HashMap)altemp.get(m);
					if((temp.get("item_code")).toString().equals(item_code)) {
					//int pdoc_srl_no = Integer.parseInt((String)temp.get("doc_srl_no"));
					//--pdoc_srl_no;
					int pdoc_srl_no = m ;

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
				//System.out.println("IssueListDetail.jsp 176.."+bean.getExpRecordsforBarCode());	
				hmBatchRecord = (HashMap)alBatchRecords.get(0);
				hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				hmBatchRecord.put("RET_ITEM_QTY",	"0");
				bean.setExpRecordsforBarCode( Integer.parseInt(index), alBatchRecords);
				//System.out.println("IssueListDetail.jsp 178.."+bean.getExpRecordsforBarCode());	
				}

				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in IssueListDetail.jsp ...function=barcode..");
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
					System.out.println("Exception in IssueListDetail.jsp ...function=addbarcode..");
					throw ex;//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				}
			}

			//ended

			//Added for GHL-CRF-0413 starts
			else if (fnction.equals("additionalBatch")){
				try
				{
					String barcode = bean.checkForNull(request.getParameter("barcode"));
					BarcodeWithMultipleBatches =  bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"));
 					qtyList = bean.checkForNull(request.getParameter("qtyList"));
   					p=qtyList.split(",");
   					ArrayList oldBatchExpList = new ArrayList();
   					ArrayList tmpList  = new ArrayList();
   					if(bean.getTempBatchRecords().size()>0 ){
   					oldBatchExpList = bean.getTempBatchRecords();//old records in current trnsaction	
   					}
   					if(BarcodeWithMultipleBatches.equals("Y")){
   						BatchSearchBeanForBarcode bean3 = (BatchSearchBeanForBarcode) getBeanObject("batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode", request  );
   						bean3.setLanguageId(locale);
   						tmpList = bean3.getSelectedList();
   						System.out.println("alBatchRecords getSelectedList in 271 IssueListDetail.jsp ..."+alBatchRecords);
   						if (tmpList==null) {
   						throw new Exception("No batch selected..");
   						}
   						putObjectInBean("batchSearchBeanForBarcode",bean3,request);
   					}else{
	   				StUtilities bean2 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
					bean2.setLanguageId(locale);
					HashMap hmParameters	=	new HashMap();
				//	HashMap newExpBatchMap   = new HashMap(); commanded for unused local variable
					hmParameters.put("ITEM_CODE",item_code);
					hmParameters.put("STORE_CODE",store_code);
					hmParameters.put("BARCODE_ID",barcode);
					hmParameters.put("TRN_QTY","0");
					//System.err.println("hmParameters list details=="+hmParameters);
					String barcode_2d_applicable_yn = beanHdr.barcode2DApplicable();//Adding start for MMS-DM-CRF-0174.6
					HashMap hmReturn = new HashMap();
					//System.err.println("barcode_2d_applicable_ynlist details=="+barcode_2d_applicable_yn);
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
   						refreshDetailsforBarCode('999','IssueListHeader','IssueDetail','','','','','');
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
						refreshDetailsforBarCode('999','IssueListHeader','IssueDetail','','','','','');
						 </script><%
						 }
				 }
				 putObjectInBean("batchSearchBeanForBarcode",expiryBean,request);	
   				//Added against IN:062242 ends	 
   				 System.err.println("tmpList before bin location 350"+tmpList);
   				//System.out.println("IssueListDetail alBatchRecords=====148=>"+alBatchRecords); 
				for(int binlocn=0; binlocn < tmpList.size() ; binlocn++) {
				HashMap hmBatchRecord1 = (HashMap)tmpList.get(binlocn);
				//HashMap hmBatchRecord1 = (HashMap)alBatchRecords.get(0);
				hmBatchRecord1.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				hmBatchRecord1.put("RET_ITEM_QTY",	"0");
				System.out.println("IssueListDetail alBatchRecords=====155=>"+hmBatchRecord1); 
				}
   					ArrayList tempBatchRecordsList = new ArrayList();
   					tempBatchRecordsList = null;
					 System.err.println("tmpList after bin location 361"+tmpList);// new batch searched in current transaction
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
					// ArrayList OldExpRecords = new ArrayList(); Unused Local Variables
					//HashMap CurrBatchRecords = new HashMap();Unused Local Variables
					doc_srl_no_forbean = bean.getDtlRecordsforBarCode().size();
					System.out.println("doc_srl_no_forbean !305-->"+doc_srl_no_forbean);
					//ArrayList alTmpList = new ArrayList();Unused Local Variables
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
							System.out.println("check in else if IssueListDetail.jsp 342...doc_srl_no.."+doc_srl_no_forbean);
							System.out.println("check in else if IssueListDetail.jsp 342...alBatchRecords.."+alBatchRecords);
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
			{	//System.out.println("BatchSearchBean in IssueListDetail");
				BatchSearchBean bean2		=		(BatchSearchBean)getBeanObject("batchSearchBean",  "eST.BatchSearchBean",request);
				bean2.setLanguageId(locale);
				alBatchRecords				=		bean2.getSelectedList();
				 //System.err.println("alBatchRecords-----batchsearch------>"+alBatchRecords);
				includeSuspendedBatches		=		bean2.getIncludeSuspendedBatches();
				if (alBatchRecords.size() >0)
				{
					for(i=0;i<alBatchRecords.size();i++){
							hmBatchRecord	=		(HashMap)alBatchRecords.get(i);
							hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
							hmBatchRecord.put("RET_ITEM_QTY",	"0");
					}
				}
				else
				{
					hmRecord				=		bean.getDtlRecord(Integer.parseInt(index));
					alBatchRecords			=		(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
					function				=		"modify";
								}
					putObjectInBean("batchSearchBean",bean2,request);
			//Added against GHL-CRF-0413 starts	
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
			//Added against GHL-CRF-0413 ends			
			}
		//		System.err.println("alBatchRecords --ending----"+alBatchRecords);
//				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
		%>
	<body>
		<form name='formIssueListDetail' id='formIssueListDetail'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align=center> 
	<tr id="tr_<%=i%>">
				<th><%=date_legend%></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ToStoreBin.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.IssQty.label" bundle="${st_labels}"/></th>
			</tr>
			<%
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(HashMap)alBatchRecords.get(i);
				 //Added for GHL-CRF-0413 starts
				 barcodeExp.add(bean.checkForNull((String)hmBatchRecord.get("BARCODE_ID"), ""));
				 //barcodeExp.add((String)hmBatchRecord.get("BARCODE_ID"));
				bean.setAlBarcodeExp(barcodeExp);
				itemCodeExp.add((String)hmBatchRecord.get("ITEM_CODE"));
				bean.setAlItemcodeExp(itemCodeExp);
				//Added for GHL-CRF-0413 ends
				 tmp_conv_fac=bean.getConvFactTemp((String)hmBatchRecord.get("ITEM_CODE"),(String)hmBatchRecord.get("STORE_CODE"));//MMS-MD-SCF-0204
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
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
			%>
			<tr id="tr_<%=i%>">
				<%
					if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays){
					expired_batch = expired_batch + 1;    %>
           <%
					 if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0){
					String exp_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
					String exp_status_days = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			%>
					<td  class="<%=className%>" nowrap   name="expiry_date_or_receipt_date_<%=i%>" ><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%>
					<font class="DATAHIGHLIGHT"><center><%=exp_status+(String)hmBatchRecord.get("NOD")+exp_status_days%>
						</center></font>
					</td>
			<%	}else
						{
                      // String stTempStatus = "Expired";
					   String stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
					   if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C")){
						   //stTempStatus ="Exp./Notified" ;
						   stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Notified.label","st_labels");
						   %>
                  				<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
						   <%
							 } else if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S")){
							//stTempStatus ="Exp./Suspnd" ;
							stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Suspend.label","st_labels");
					   %>
<td  class="<%=className%>" nowrap style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
<%                  } else {	%> 
		<td  class="<%=className%>" nowrap    name="expiry_date_or_receipt_date_<%=i%>"><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><center><font class="DATAHIGHLIGHT"><%=stTempStatus%></font></center></td>
		<%
               }
					} 
					  	} else {
					  		if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C"))
				{ %>
				 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" >				<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><br><font class="DATAHIGHLIGHT"><fmt:message key="eST.Notified.label" bundle="${st_labels}"/></font></center>
                 </td>
				<%
				}
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S"))
				{ 	%>
							 <td  class="<%=className%>" style = "cursor:pointer"   onClick="showHistory(tr_<%=i%>,<%=i%>);" >		<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%><br><font class="DATAHIGHLIGHT"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></font></center>	</td>
						<% 
				} 
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("A"))
				{ 	%>
				     <td  class="<%=className%>"  >
						<center><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%></center>
                     </td>
                 <% 
				       }
			                } %>
					<td class="<%=className%>" nowrap  name="batch_id_<%=i%>" ><%=hmBatchRecord.get("BATCH_ID")%></td>
					<td class="<%=className%>" ><%=bean.checkForNull((String)hmBatchRecord.get("TRADE_NAME"),(String)hmBatchRecord.get("TRADE_ID"))%></td>
					<td class="<%=className%>"  ><%=hmBatchRecord.get("BIN_DESC")%></td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align avail_qty.				
					-->
					<td class="<%=className%>" nowrap  name="avail_qty" style="TEXT-ALIGN:right"><span id="id_stock_avail_<%=i%>"><%=bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),no_of_decimals)%></span>&nbsp;</td>
					<td class="<%=className%>" nowrap ><select class="STSMALL" name="to_bin_location_code_<%=i%>" id="to_bin_location_code_<%=i%>"><%=bean.getSTITBin_location_code_List(to_store_code,(String)hmBatchRecord.get("ITEM_CODE"),(String)hmBatchRecord.get("TO_BIN_LOCATION_CODE"),locale)%></select></td>
			
				<%if(function.equals("additionalBatch") ){//Added for GHL-CRF-0413 starts
					System.out.println("inside if @455-->"+p[i]);%>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=8 maxlength=12 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=p[i]%>"  
					 onBlur="CheckDtlQuantity('<%=i%>');batchUomMultiples(this, <%=tmp_conv_fac%>,<%=mode%>);" onchange="CheckDtlQuantity1('<%=i%>');CumValue('<%=i%>',this);" ></td><!--CumValue()added for GHL-CRF-0465, batchUomMultiples added for MMS-MD-SCF-0204  -->
					<%}else{ //Added for GHL-CRF-0413 ends%>  
					<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size=8 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);"
					 onBlur="CheckDtlQuantity('<%=i%>');batchUomMultiples(this, <%=tmp_conv_fac%>,<%=mode%>);" onchange="CheckDtlQuantity1('<%=i%>');CumValue('<%=i%>',this);"
					 value="<%=(function.equals("edit")||function.equals("modify"))?bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals):""%>"  <%=Qty_disabled%> ></td><!--CumValue()added for GHL-CRF-0465,batchUomMultiples added for MMS-MD-SCF-0204   -->
					 <%} %>
			</tr>
					<!--added-->
					<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=hmBatchRecord.get("BATCH_ID")%>">
					<input type="hidden" name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_DATE")%>">
					<!--ended-->
					<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value="<%=hmBatchRecord.get("TRADE_ID")%>">
					<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=hmBatchRecord.get("BIN_LOCATION_CODE")%>">
                    <input type="hidden" name="manufacturer_name_<%=i%>" id="manufacturer_name_<%=i%>" value="<%=hmBatchRecord.get("MANUFACTURER_NAME")%>">
					<input type="hidden" name="barcode_<%=i%>" id="barcode_<%=i%>" value="<%=hmBatchRecord.get("BARCODE_ID")%>"><!-- Added against GHL-CRF-0413-->
			<%  
				decimal_allowed_yn = bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"));
				}	%>
	<!-- 	/**
		* @Name - Mahesh
		* @Date - 20/01/2010
		* @Inc# - IN015496
		* @Desc - Code added to accept decimal values dynamically.
		*/

	 -->	
			<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="<%=decimal_allowed_yn%>">
			<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_of_decimals%>">
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="includeSuspendedBatches" id="includeSuspendedBatches" value="<%=(function.equals("edit")||function.equals("modify"))?(bean.checkForNull((String)hmRecord.get("includeSuspendedBatches")).equals("")?"N":(String)hmRecord.get("includeSuspendedBatches")):includeSuspendedBatches%>">
			<input type="hidden" name="expired_batch" id="expired_batch" value="<%=expired_batch%>">
			<input type="hidden" name="ex_param_days" id="ex_param_days" value="<%=EWDays%>">
			<input type="hidden" name="batchsearch" id="batchsearch" value="<%=batchsearch%>">
			<input type="hidden" name="remarks" id="remarks" value="<%=remarks%>">
			<input type="hidden" name="remarks_code" id="remarks_code" value="<%=remarks_code%>">
			<input type="hidden" name="tmp_conv_fac" id="tmp_conv_fac" value="<%=tmp_conv_fac%>"> <!-- MMS-MD-SCF-0204 -->
			
			<input type="hidden"   name="doc_srl_no_forbean" id="doc_srl_no_forbean"  value ="<%=doc_srl_no_forbean %>"><!-- Added against GHL-CRF-0413-->
		</form>
			
	<script language="JavaScript">
<%
	if (addToList!=null){
		
		if(((String)kit).equals("kit")|| (fnction.equals("edit"))){
%>		
	
		parent.frameIssueListHeader.addToList1();
<%		
		}else{
%>
		parent.frameIssueListHeader.addToList();
<%
		}
	}
	else if (fnction.equals("barcode")|| fnction.equals("additionalBatch")){//Added additionalBatch for GHL-CRF-0413
	if (defaultqty_appl.equals("Y")){
	%>	
	parent.frameIssueListHeader.callItemQtyUpdate();
	<%	}
	}
	else if (fnction.equals("addbarcode")){
	%>	
	parent.frameIssueListHeader.newbatch('issueBean','eST.IssueBean');
	parent.frameIssueListHeader.addToListforBarCode1('issueBean','eST.IssueBean','IssueListHeader','IssueListDetail','IssueDetail');
	<%	
	}
%>
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<% 		}catch (eST.Common.InsufficientBatchException insufficientBatchException) {%>
			<!--Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014-->
			<script>alert(getMessage("INSUFFICIENT_BATCH_QTY","ST"));</script>
			
			<%insufficientBatchException.printStackTrace();
		}
		 catch (Exception exception) {
			exception.printStackTrace();
			}
		%>
		<%
putObjectInBean("issueBean",bean,request);
putObjectInBean("stDuoHeaderBean",beanHdr,request);
%>		
	</body>
</html>

