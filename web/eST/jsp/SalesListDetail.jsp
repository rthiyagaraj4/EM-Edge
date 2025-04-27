<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
15/11/2017		INC065695			Shazana Hasan							MMS-DM-CRF-0112 -US003 - Barcode search
19/2/2019               IN:072096               B Haribabu                                              MMS-JU-SCF-0141             
---------------------------------------------------------------------------------------------------------------
*/
%>



<%@ page import="eST.SalesBean,eST.BatchSearchBean,eST.Common.StUtilities,java.util.ArrayList,java.util.HashMap,eST.BatchSearchBeanForBarcode,eST.*, eST.Common.* , eCommon.Common.*, java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*" contentType="text/html;charset=UTF-8"%><!-- Modified for IN:072096 start-->
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
		<script language="javascript" src="../../eST/js/Sales.js"></script>
	</head>
	<%
	String bean_id				=    "SalesBean";
	String bean_name				=    "eST.SalesBean";
	SalesBean bean = (SalesBean) getBeanObject("salesBean","eST.SalesBean",request);
	bean.setLanguageId(locale);
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
        	boolean site=bean.isSite_spec_yn();//Added against IN:062328 
        	
        	//Added for IN:072096 start
            Connection con				= null;
       	 
       	boolean store_uom_multiples_appl = false;
       		
       	try 
       	{
       		con						= ConnectionManager.getConnection(request);
       		store_uom_multiples_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","MULT_STORE_UOM_APPL");
       		 
       	} 
       	catch (Exception e) 
       	{
       		e.printStackTrace(System.err);
       		System.out.println(" Error in headerlist Page " + e.getMessage());
       	} 
       	finally 
       	{
       		if (con != null) ConnectionManager.returnConnection(con, request);
       	}
       	//Added for IN:072096 end

		int i	=0;
		String mode = bean.getMode();
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String fnction = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String store_code = bean.checkForNull(request.getParameter("store_code"));
		String item_qty = bean.checkForNull(request.getParameter("item_qty"),"0");
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
		String stock_item_yn = bean.checkForNull(request.getParameter("stock_item_yn"));
		String addToList = request.getParameter("addToList");
		String kit = (String)request.getParameter("kit")==null?"":(String)request.getParameter("kit");
		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
		//String remarks						=		bean.checkForNull(request.getParameter("remarks"));
		

		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");

		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String BarcodeWithMultipleBatches					=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		
		System.out.println("BARCODE_YN== 44 === >"+BARCODE_YN);
		System.out.println("defaultqty_appl== 44 === >"+defaultqty_appl);
		System.out.println("editqty_appl1== 44 === >"+editqty_appl1);
		

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl1.equals("N") && !site){//Added site against IN:062328 
		Qty_disabled  = "disabled"	;
		}


		ArrayList alBatchRecords = null;		
		HashMap hmBatchRecord = null;
		String className	=	"";
		//String date_legend="Expiry Dt";
		String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");

        int EWDays = 0;
		int expired_batch = 0;
		/*Added by Shazana for INC065695*/
		double tmp_conv=bean.getConvFactTemp(item_code,store_code);
		System.out.println("tmp_conv in SalesListDetail.jsp: "+tmp_conv);
		/*Added by Shazana for INC065695*/
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
		int no_of_decimals					=			bean.getNoOfDecimals();
		int no_of_decimals_temp				=			bean.getNoOfDecimals();
		String item_code_bean="";
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		//Added for GHL-CRF-0413 starts
		ArrayList barcodeExp = new ArrayList();
	        ArrayList itemCodeExp = new ArrayList();
		int doc_srl_no_forbean =0;
		String qtyList = "";
		String p[]=null;
		int tmp = 0;
		//Added for GHL-CRF-0413 ends
		try { 
			System.out.println("index...in..69  SalesListDetail.jsp... "+index);
			System.out.println("function dd... "+function+"BARCODE_YN..."+BARCODE_YN);
			EWDays = bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));

			if(function.equals("modify"))	{
				HashMap hmDetailRecord  = new HashMap();

				if (BARCODE_YN.equals("TRUE"))
				hmDetailRecord	=	(HashMap) bean.getDtlRecordforBarCode(Integer.parseInt(index));
				else
				hmDetailRecord	=	(HashMap)bean.getDtlRecord(Integer.parseInt(index)); 
				
				if (BARCODE_YN.equals("TRUE"))
				alBatchRecords =(ArrayList)bean.getExpRecordsforBarCode(Integer.parseInt(index)); 
				else
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 

				System.out.println("alBatchRecords-------Modify=>"+alBatchRecords);

				expiry_yn=(String)hmDetailRecord.get("expiry_yn");
				stock_item_yn=(String)hmDetailRecord.get("stock_item_yn");
				if (stock_item_yn.equals("N")) 
					return;
			}
			else if(function.equals("edit"))	{
				try
				{
				StUtilities bean1 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean1.getBatches(hmParameters);
				System.out.println("hmParameters...in..SalesListDetail.jsp..."+hmParameters);
				System.out.println("hmReturn...in..SalesListDetail.jsp..."+hmReturn);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				
				System.out.println("alBatchRecords...in..SalesListDetail.jsp... "+alBatchRecords);
				System.out.println("index...in..SalesListDetail.jsp... "+index);
				
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
				System.out.println("kit...in..SalesListDetail.jsp... "+kit+"--bean.getBarcodeApplicable():"+bean.getBarcodeApplicable());
				if(((String)kit).equals("kit")  && bean.getBarcodeApplicable().equals("Y")){
				for(int h=0;h<alBatchRecords.size();h++){
				HashMap ht = (HashMap)alBatchRecords.get(h);
				ht.put("KIT","KIT");
				}
				System.out.println("kit...in..SalesListDetail.jsp... "+alBatchRecords);
				bean.setExpRecordsforBarCode( Integer.parseInt(index), alBatchRecords);
				}

				putObjectInBean("stUtilities",bean1,request);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in SalesListDetail.jsp ...function=edit..");
					System.out.println(ex.toString());
					throw ex;//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				}
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
					System.out.println("alBatchRecords getSelectedList in SalesListDetail.jsp ..."+alBatchRecords);
					if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
					}
					putObjectInBean("batchSearchBeanForBarcode",bean3,request);
				}else{
					alBatchRecords = bean.getBatchRecords() ;
				}

				//alBatchRecords = bean.getBatchRecords() ;

				if (bean.getDtlRecordsforBarCode().size()>0){
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
					System.out.println("check in SalesListDetail.jsp ...CurrBatchRecords.."+CurrBatchRecords);
					OldExpRecords.add(CurrBatchRecords);
					System.out.println("check in SalesListDetail.jsp ...OldExpRecords.."+OldExpRecords);
					}				
					}					
					bean.setExpRecordsforBarCode( pdoc_srl_no, OldExpRecords);
					check = false;
					}

				}
				}
				if(check){
				bean.setExpRecordsforBarCode( Integer.parseInt(index), alBatchRecords);
				}

				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in SalesListDetail.jsp ...function=barcode..");
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
				
				bean.setAddBatchRecords(alBatchRecords);
				putObjectInBean("stUtilities",bean2,request);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in SalesListDetail.jsp ...function=addbarcode..");
					throw ex;//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				}
			}
	
			//added ended
//Added for GHL-CRF-0413 starts
			else if (fnction.equals("additionalBatch")){
				try
				{
					String barcode = bean.checkForNull(request.getParameter("barcode"));
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
   						refreshDetailsforBarCode('999','SalesListHeader','SalesDetail','','','','','');
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
						refreshDetailsforBarCode('999','SalesListHeader','SalesDetail','','','','','');
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
							System.out.println("check in else if SalesListDetail.jsp 342...doc_srl_no.."+doc_srl_no_forbean);
							System.out.println("check in else if SalesListDetail.jsp 342...alBatchRecords.."+alBatchRecords);
				}
				catch(Exception ex)
				{
				
					ex.printStackTrace();
					System.out.println("Exception in SalesListDetail.jsp ...function=additionalBatch..");
					throw ex;
				}
			} 
			//Added for GHL-CRF-0413 ends
			else
			{
				BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean", request  );
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();
				System.out.println("alBatchRecords in SalesListDetail.jsp ..."+alBatchRecords);
				if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
					//alBatchRecords	=	new ArrayList();
				}
				putObjectInBean("batchSearchBean",bean2,request);

			}

			if(expiry_yn.equals("N")) {
				//date_legend="Receipt Dt";
				date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}
			/**
					 * @Name - krishna
					 * @Date - 24/12/2009
					 * @Inc# - IN017635
					 * @Desc - batch detail null handling begin
				 */
			//bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			/**@ end**/
	%>
	 
	<body >
		<form name='formSalesListDetail' id='formSalesListDetail'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center" >
 			<tr>
				<th><%=date_legend%></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.SaleQuantity.label" bundle="${common_labels}"/></th>
			</tr>
			<%
				String batch_qty="";
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(HashMap)alBatchRecords.get(i);
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
 //Added for GHL-CRF-0413 starts
 barcodeExp.add((String)hmBatchRecord.get("BARCODE_ID"));
bean.setAlBarcodeExp(barcodeExp);
itemCodeExp.add((String)hmBatchRecord.get("ITEM_CODE"));
bean.setAlItemcodeExp(itemCodeExp);
//Added for GHL-CRF-0413 ends
			if((bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"))).equals("N")){
				no_of_decimals = 0;
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals);
			}else{
				no_of_decimals = no_of_decimals_temp;
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals);
			}
			item_code_bean=(String)hmBatchRecord.get("ITEM_CODE");
			%>
				<tr>
					
					<td class="<%=className%>" nowrap  ><%=com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)%>
					<%
						if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays)
				        {
								expired_batch = expired_batch + 1;
							if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0)
							{
					%>
								<font class="DATAHIGHLIGHT"><center><%="Exp. "+(String)hmBatchRecord.get("NOD")+"Days"%></center></font>

					<%      }else{ 
						%>
									 <font class="DATAHIGHLIGHT"><center><fmt:message key="Common.Expired.label" bundle="${common_labels}"/></center></font>
					<%           }
					    } 
					 %>
						 <%
					if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C"))
				{ %>
						<br><font class="DATAHIGHLIGHT"><center><fmt:message key="eST.Notified.label" bundle="${st_labels}"/></center></font>
				<%
				}
					if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S"))
				{   %>
						<br><font class="DATAHIGHLIGHT"><center><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></center></font>
						<% }
					
				
			%>
			        </td>

					<td class="<%=className%>" nowrap  > <%=hmBatchRecord.get("BATCH_ID")%></td>
					<td class="<%=className%>" nowrap ><%=hmBatchRecord.get("TRADE_NAME")%></td>
					<td class="<%=className%>" nowrap ><%=hmBatchRecord.get("BIN_DESC")%></td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"><%=hmBatchRecord.get("AVAIL_QTY")%></td>
					<!-- Modified for IN:072096 start -->
					<%if(store_uom_multiples_appl){ %>
					<%if(function.equals("additionalBatch") ){//Added for GHL-CRF-0413 starts
					System.out.println("inside if @455-->"+p[i]);%>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=12 maxlength=12 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=p[i]%>"  
					onBlur="checkBatchQty(this,available_qty_<%=i%>.value);batchUonMultiples(this, <%=tmp_conv%>,<%=mode%>);chargeDetailsExp('<%=(String)hmBatchRecord.get("ITEM_CODE")%>');"  <%=Qty_disabled%>></td>
					<%}else{ //Added for GHL-CRF-0413 ends%>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=12 maxlength=12 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=(function.equals("edit")||function.equals("modify"))?batch_qty:""%>"  
					onBlur="checkBatchQty(this,available_qty_<%=i%>.value);batchUonMultiples(this, <%=tmp_conv%>,<%=mode%>);chargeDetailsExp('<%=(String)hmBatchRecord.get("ITEM_CODE")%>');"  <%=Qty_disabled%>></td>
					<%} }else{%>
					<%if(function.equals("additionalBatch") ){//Added for GHL-CRF-0413 starts
					System.out.println("inside if @455-->"+p[i]);%>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=12 maxlength=12 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=p[i]%>"  
					onBlur="checkBatchQty(this,available_qty_<%=i%>.value);chargeDetailsExp('<%=(String)hmBatchRecord.get("ITEM_CODE")%>');"  <%=Qty_disabled%>></td>
					<%}else{ //Added for GHL-CRF-0413 ends%>
					<td class="<%=className%>" nowrap >
					<input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  id="id_item_qty_<%=i%>"   class="NUMBER" size=12 maxlength=12 onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" value="<%=(function.equals("edit")||function.equals("modify"))?batch_qty:""%>"  
					onBlur="checkBatchQty(this,available_qty_<%=i%>.value);chargeDetailsExp('<%=(String)hmBatchRecord.get("ITEM_CODE")%>');"  <%=Qty_disabled%>></td>
					<%} }%>
					<!-- Modified for IN:072096 end -->
				<!-- 	/**
					 * @Name - krishna
					 * @Date - 24/12/2009
					 * @Inc# - IN017635
					 * @Desc - batch detail null handling begin
				 */--->
					<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value="<%=hmBatchRecord.get("TRADE_ID")%>">
					<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value="<%=hmBatchRecord.get("BATCH_ID")%>">
					<input type="hidden" name="expiry_date_or_receipt_date_<%=i%>" id="expiry_date_or_receipt_date_<%=i%>" value="<%=hmBatchRecord.get("EXPIRY_DATE")%>">
					<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=hmBatchRecord.get("BIN_LOCATION_CODE")%>">
					<input type="hidden" name="barcode_<%=i%>" id="barcode_<%=i%>" value="<%=hmBatchRecord.get("BARCODE_ID")%>">
			<!-- 	/**
					 * @Name - krishna
					 * @Date - 24/12/2009
					 * @Inc# - IN017635
					 * @Desc - batch detail null handling begin
				 */--->
				
				</tr>
					<input type="hidden" name="available_qty_<%=i%>" id="available_qty_<%=i%>" value="<%=hmBatchRecord.get("AVAIL_QTY")%>">
			<%	}
				
			%>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="batchsearch" id="batchsearch" value="<%=batchsearch%>">
			<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code_bean)%>">
			<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals_temp%>">
			<input type="hidden"   name="doc_srl_no_forbean" id="doc_srl_no_forbean"  value ="<%=doc_srl_no_forbean %>">
			<input type="hidden"	name="tmp_conv" id="tmp_conv"					value='<%=tmp_conv%>'>	<!-- Added by Shazana for INC065695 -->
			</table>	
		</form>
	<script language="JavaScript">
<%	
	if (addToList!=null){
		if(((String)kit).equals("kit") || (fnction.equals("edit"))){
%>		
		parent.frameSalesListHeader.addToList1();
<%		
		}
		else{
%>
		parent.frameSalesListHeader.addToList();
<%
		}
	}
	else if (fnction.equals("barcode") || fnction.equals("additionalBatch")){//Added additionalBatch for GHL-CRF-0413
	if (defaultqty_appl.equals("Y")){
	%>
	parent.frameSalesListHeader.callItemQtyUpdate();
	<%	}
	}
	else if (fnction.equals("addbarcode")){
	%>	
	parent.frameSalesListHeader.newbatch('salesBean','eST.SalesBean');
	parent.frameSalesListHeader.addToListforBarCode1('salesBean','eST.SalesBean','SalesListHeader','SalesListDetail','SalesDetail');
	<%	
	}
	%>
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {%>
		<script>alert(getMessage("INSUFFICIENT_BATCH_QTY","ST"));</script>
<%			//out.println("Insufficient Quantity.");
			//out.println(insufficientBatchException);
			insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
			out.println(exception.getMessage());
			exception.printStackTrace();
			
		}
				
%>
<%
putObjectInBean( "salesBean",bean,request);
%>
	</body>
</html>

