
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
05/02/2021      TFS id:6938        B Haribabu          05/02/2021                     MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.AcknowledgmentBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097	
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	AcknowledgmentBean bean = (AcknowledgmentBean)getBeanObject("acknowledgmentBean","eST.AcknowledgmentBean",request);  
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	try {
		if(validate.equals("LOAD_DETAIL")){
			bean.clear();
			String trn_type			=	request.getParameter("trn_type");
			String doc_no			=	request.getParameter("doc_no");
			String fm_doc_date		=	request.getParameter("fm_doc_date");
			fm_doc_date				=	com.ehis.util.DateUtils.convertDate(fm_doc_date,"DMY",locale,"en");   
			String to_doc_date		=	request.getParameter("to_doc_date");
			to_doc_date				=	com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			String action_type		=	request.getParameter("action_type");
			String store_code		=	request.getParameter("store_code");
			String doc_type_code	=	request.getParameter("doc_type_code");
			bean.setStore_code(store_code);
			bean.setTrn_type(trn_type);
			bean.setAction_type(action_type);
			bean.setDoc_type_code(doc_type_code);
			bean.loadTFRDtlData(fm_doc_date,to_doc_date,doc_no);
			result = true;
		}else if(validate.equals("LOAD_EXP_DETAIL")){
			result = true;
			String doc_no			=	request.getParameter("doc_no");
			ArrayList alExpRecords	=	new ArrayList();
			HashMap hmRecord		=	new HashMap();
			boolean resultTemp		=	false;
			String seq_no			=	request.getParameter("seq_no");
			String fm_store_code	=	request.getParameter("fm_store_code");
			String to_store_code	=	request.getParameter("to_store_code");
			int size = ((ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no)).size();
			if(!(size>0)){
				bean.loadTFRExpData(doc_no,seq_no);
			}
			alExpRecords	=	bean.getTFRExpRecords(doc_no+"~"+seq_no);
			for(int i=0;i<alExpRecords.size();i++){
				hmRecord = (HashMap)alExpRecords.get(i); 
				String phy_inv_id = "";

				resultTemp = bean.isPhysicalInventoryProcessStartedForStore((String)hmRecord.get("ITEM_CODE"),fm_store_code,to_store_code);

				if(resultTemp){
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)hmRecord.get("ITEM_CODE"),fm_store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)hmRecord.get("ITEM_CODE"),to_store_code}).get("PHY_INV_ID");
					result =  false;
					flag = bean.checkForNull(phy_inv_id);
					break;
				}
			}
			if(!result){
				throw new Exception("PHY_INV_PROCESS_INITIATED");
			}

		}else if(validate.equals("UPDATE_EXP_DETAIL")){
			String doc_no	=	request.getParameter("doc_no");
			String seq_no	=	request.getParameter("seq_no");
			HashMap hmTemp	=	new HashMap();
			ArrayList alExpRecords = new ArrayList();
			ArrayList alResult = (ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no);
			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				hmTemp.put("REMARKS",(String)htFormValues.get("remarks_"+i));
				hmTemp.put("REJECTED_QTY",(String)htFormValues.get("rejected_qty_"+i));
				hmTemp.put("RECEIVED_QTY",(String)htFormValues.get("received_qty_"+i));
				hmTemp.put("PEN_RCD_QTY",(String)htFormValues.get("pending_qty_"+i));
				if(((String)bean.getAction_type()).equals("A")){
					hmTemp.put("TMP_REJECTED_QTY_1",(String)htFormValues.get("rejected_qty_"+i));
					hmTemp.put("TMP_RECEIVED_QTY_1",(String)htFormValues.get("received_qty_"+i));
				}else{
					hmTemp.put("TMP_REJECTED_QTY_2",(String)htFormValues.get("rejected_qty_"+i));
					hmTemp.put("TMP_RECEIVED_QTY_2",(String)htFormValues.get("received_qty_"+i));
				}
				hmTemp.put("NEW_BIN_LOCATION_CODE",(String)htFormValues.get("bin_location_"+i));
				hmTemp.put("TO_BIN_LOCATION_CODE",(String)htFormValues.get("bin_location_"+i));
				hmTemp.put("ENTRY_COMPLETED",(String)htFormValues.get("entry_completed_"+doc_no));
				alExpRecords.add(hmTemp);
			}
			bean.setTFRExpRecords(doc_no+"~"+seq_no,alExpRecords);
			result = true;
			flag="";
		}else if(validate.equals("CONFIRM")){
			result = true;
			flag = "";
			String confirm_yn			=	request.getParameter("confirm_yn");
			String doc_no				=	request.getParameter("doc_no");
			String seq_no				=	request.getParameter("seq_no");
			int index					=	Integer.parseInt((String)request.getParameter("index"));
			ArrayList alDtlRecords		=	(ArrayList)bean.getTFRDtlRecords();
			HashMap hmDtlRecords		=	(HashMap)alDtlRecords.get(index);
			hmDtlRecords.put("CONFIRM_YN",confirm_yn);
			alDtlRecords.set(index,hmDtlRecords);
			//if(confirm_yn.equals("N"))
			//	alDtlRecords.remove(index);
			bean.setTFRDtlRecords(alDtlRecords);
			/*Exp Details*/
			bean.loadTFRExpData(doc_no,seq_no);
			HashMap hmTemp	=	new HashMap();
			ArrayList alExpRecords = new ArrayList();
			ArrayList alResult = (ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no);
			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				hmTemp.put("REJECTED_QTY",(String)hmTemp.get("TMP_REJECTED_QTY_2"));
				hmTemp.put("RECEIVED_QTY",(String)hmTemp.get("TMP_RECEIVED_QTY_2"));
				alExpRecords.add(hmTemp);
			}
			bean.setTFRExpRecords(doc_no+"~"+seq_no,alExpRecords);
			if(confirm_yn.equals("N"))
				bean.removeTFTExpRecords(doc_no+"~"+seq_no);
		}else if(validate.equals("QUANTITY")){
	/**
	* @Name - Mahesh
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - Code is moved to intermediate JSP as caluculations we not happening properly in js for decimal values..
	*/
			result = false;
			flag = "";
			String item_code = request.getParameter("item_code");
			String fm_store_code = request.getParameter("fm_store_code");
			double item_qty	 = Double.parseDouble((String)request.getParameter("item_qty"));
			double to_conv_factor  = bean.getConvFactTemp(item_code,bean.getStore_code());
			double fm_conv_factor  = bean.getConvFactTemp(item_code,fm_store_code);
			double conv_factor  = bean.lcmConvFactor(fm_conv_factor,to_conv_factor);
			if(bean.getAllowDecimalsYN(item_code).equals("N")){
			if(item_qty%conv_factor == 0 || conv_factor == 1)
				result = true;
			else{
				result = false;
				flag   =bean.setNumber( ""+conv_factor,0);
			}
			}else{
			result = true;
			}
		}else if(validate.equals("TRNTYPE")){
			result = true;
			flag = "";
			String trn_type = request.getParameter("trn_type");
			bean.setTrn_type(trn_type);
			out.println("clearListItems('document.formAcknowledgeHeader.store_code'); ");
			ArrayList alStoreList = bean.getStoreArrayList();
			HashMap record	=	null;
			for(int i=0; i< alStoreList.size(); i++) {
				record	=	(HashMap)alStoreList.get(i);
				String listRecord	=	(String)record.get("STORE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formAcknowledgeHeader.store_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
				
			}
			out.println("clearListItems('document.formAcknowledgeHeader.doc_type_code'); ");
			ArrayList alDocTypeList = bean.getDocTypeArrayList();
			record	=	null;
			for(int i=0; i< alDocTypeList.size(); i++) {
				record	=	(HashMap)alDocTypeList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formAcknowledgeHeader.doc_type_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
				
			}
		}else if(validate.equals("ACTIONTYPE")){
			result = true;
			flag = "";
			String action_type = request.getParameter("action_type");
			bean.setAction_type(action_type);
			out.println("clearListItems('document.formAcknowledgeHeader.store_code'); ");
			ArrayList alStoreList = bean.getStoreArrayList();
			HashMap record	=	null;
			for(int i=0; i< alStoreList.size(); i++) {
				record	=	(HashMap)alStoreList.get(i);
				String listRecord	=	(String)record.get("STORE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formAcknowledgeHeader.store_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
			}
		}else if(validate.equals("VALIDATE_QTY")){
			result = true;
			flag = "";
			int no_of_decimals		= Integer.parseInt((String)request.getParameter("no_of_decimals"));
			//double pending_qty		= Double.parseDouble((String)request.getParameter("pending_qty"));
			double pending_temp_qty = Double.parseDouble((String)request.getParameter("pending_temp_qty"));
			double rejected_qty		= Double.parseDouble((String)request.getParameter("rejected_qty"));
			double received_qty		= Double.parseDouble((String)request.getParameter("received_qty"));
/*			out.println("alert(pending temp-->"+pending_temp_qty+");");
			out.println("alert(pending temp123-->"+request.getParameter("pending_temp_qty")+");");
			out.println("alert(pending-->"+pending_qty+");");
			out.println("alert(rejected-->"+rejected_qty+");");
			out.println("alert(received-->"+received_qty+");");
			out.println("alert(received123-->"+request.getParameter("received_qty")+");");
			out.println("alert(rej-->"+(pending_temp_qty-rejected_qty)+");");
			out.println("alert(rec-->"+bean.setNumber((""+(pending_temp_qty-received_qty)),4)+");");
			out.println("alert(rec final-->"+Double.parseDouble(bean.setNumber((""+(pending_temp_qty-received_qty)),4))+");");
*/			if(received_qty>Math.abs(Double.parseDouble(bean.setNumber((""+(pending_temp_qty-rejected_qty)),no_of_decimals)))){
				flag = "";
				message = "RCVD_QTY_NOT_GREATER_ISSUED_QTY";
				result = false;
			}else if(rejected_qty>Math.abs(Double.parseDouble(bean.setNumber((""+(pending_temp_qty-received_qty)),no_of_decimals)))){
				flag = "";
				message = "RJCTD_QTY_NOT_GREATER_ISSUED_QTY";
				result = false;
			}else{
				flag = bean.setNumber(""+ (Math.abs(pending_temp_qty - (rejected_qty+received_qty))),no_of_decimals);
			}
		}else if(validate.equals("BARCODE_ITEM_EXISTS")){ //Added for RUT-CRF-0079
			
			String 	barcode			=	bean.checkForNull(request.getParameter("barcode"));
			String doc_no			=	request.getParameter("doc_no");
			String seq_no			=	request.getParameter("seq_no");
			String store_code			=	request.getParameter("store_code");
			String item_code		=	"";
			String newItemCode="";
			int barcodeExists = 0;
			ArrayList TFRExpRecords = (ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no);
			HashMap TFRExpRecord = null;			
			boolean barcode_exist = false;
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
			//Modified for TFS id:6938 start
			String selected_indexes	= "";
			if (barcode_2d_applicable_yn.equals("Y")){
				 newItemCode = bean.get2DBarcodeItem("",barcode);
				
	
				ArrayList alBarCodeListDetails = new ArrayList();
				bean.initialize();
				alBarCodeListDetails=bean.get2DBarcodeBacthes(store_code,barcode);
				 HashMap BatchDetails= new HashMap();
				 BatchDetails= (HashMap)alBarCodeListDetails.get(0); // bean.getBarcodedetails(barcode);
				String	expiryDate =(String)BatchDetails.get("EXPIRY_DATE");
				String 	batchNumber =(String)BatchDetails.get("BATCH_ID");
				String 	tradeid =(String)BatchDetails.get("TRADE_ID");
				String barcode_data=newItemCode+batchNumber+expiryDate+tradeid;
			      
				if (newItemCode.equals("")){
					out.println("alert(getMessage('ST_INVALID_BAR_CODE','ST'));");
				} else {
					for(int i=0;i<TFRExpRecords.size();i++){
						TFRExpRecord = (HashMap)TFRExpRecords.get(i);
							item_code	= (String)TFRExpRecord.get("ITEM_CODE");
				if( barcode_data.equals((String)TFRExpRecord.get("ITEM_CODE")+(String)TFRExpRecord.get("BATCH_ID")+(String)TFRExpRecord.get("EXPIRY_DATE")+(String)TFRExpRecord.get("TRADE_ID"))){

							barcode_exist = true;
							selected_indexes = selected_indexes + i + "-";
							break;
							}
										
					}
				}
			}else {

if(!((bean.getBarcodeApplForAckYN()).equals("Y")) || !((bean.getTrn_type()).equals("TFR") || (bean.getTrn_type()).equals("RET") || (bean.getTrn_type()).equals("ISS"))){
			for(int i=0;i<TFRExpRecords.size();i++){
				TFRExpRecord = (HashMap)TFRExpRecords.get(i);
				if(barcode.equals((String)TFRExpRecord.get("BARCODE_ID"))){
					item_code	= (String)TFRExpRecord.get("ITEM_CODE");
					//TFRExpRecord.put("BARCODE_ITEM_EXIST","Y");
					barcode_exist = true;
					break;
				}				
			}
			
			for(int i=0;i<TFRExpRecords.size();i++){
				TFRExpRecord = (HashMap)TFRExpRecords.get(i);
				if(!((bean.getBarcodeApplForAckYN()).equals("Y")) || barcode.equals((String)TFRExpRecord.get("BARCODE_ID"))){
				if(item_code.equals((String)TFRExpRecord.get("ITEM_CODE"))){
					TFRExpRecord.put("BARCODE_ITEM_EXIST","Y");		
					selected_indexes = selected_indexes + i + "-";
				}
			}
			}
}
else{
	
	String fm_store_code="";
	String item_code_new="";
	for(int i=0;i<TFRExpRecords.size();i++){
		TFRExpRecord = (HashMap)TFRExpRecords.get(i);
		fm_store_code=(String)TFRExpRecord.get("STORE_CODE");

		item_code_new=bean.checkForNull((String)bean.fetchRecord("select item_code||batch_id||TO_CHAR(trunc(EXPIRY_DATE_OR_RECEIPT_DATE),'dd/mm/yyyy') item_code from st_item_batch where barcode_id =? and store_code=?",new String[]{barcode,fm_store_code}).get("ITEM_CODE"),"");
		if( item_code_new.equals((String)TFRExpRecord.get("ITEM_CODE")+(String)TFRExpRecord.get("BATCH_ID")+(String)TFRExpRecord.get("EXPIRY_DATE"))){
			barcode_exist = true;
			TFRExpRecord.put("BARCODE_ITEM_EXIST","Y");		
			selected_indexes = selected_indexes + i + "-";
			break;
		}
	}
}
			}	
			if(!selected_indexes.equals(""))
				selected_indexes = selected_indexes.substring(0,selected_indexes.length()-1);
			
			result = barcode_exist;
			message = selected_indexes;
			if(!barcode_exist){
				barcodeExists=Integer.parseInt((String)bean.fetchRecord("select count(*) COUNT from ST_BATCH_CONTROL where barcode_id = ?",new String[]{barcode}).get("COUNT"));
	 			
			}
		
			if(!barcode_exist && (bean.getBarcodeApplForAckYN()).equals("Y")){
				if(barcodeExists==0){
					out.println("alert(getMessage('ST_INVALID_BAR_CODE','ST'));");
				}
				else{
				out.println("alert(getMessage('BARCODE_SCAN_ITEM_NOT_EXISTS','ST'));");
				}
			}
			else if(!barcode_exist){
				out.println("alert(getMessage('BARCODE_ITEM_NOT_EXISTS','ST'));");
			}
	//Modified for TFS id:6938 end	
		}else if(validate.equals("BARCODE_FULLY_VERIFIED")){ //Added for RUT-CRF-0079			
			
			String doc_no			=	request.getParameter("doc_no");
			String seq_no			=	request.getParameter("seq_no");
			
			ArrayList TFRExpRecords = (ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no);
			HashMap TFRExpRecord = null;	
			result = true;
			
			for(int i=0;i<TFRExpRecords.size();i++){
				TFRExpRecord = (HashMap)TFRExpRecords.get(i);								
				if(!TFRExpRecord.containsKey("BARCODE_ITEM_EXIST")){					
					result = false;
					break;					
				}		
			}
		}
	}catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
		//flag=validate;
	}
	finally{
		out.println("assignResult(" + result + ",\"" + message + "\", \"" + flag + "\");") ;
	}
%>
<%
	putObjectInBean("acknowledgmentBean",bean,request);
%>
