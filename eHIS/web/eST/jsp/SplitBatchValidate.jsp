<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
09/02/2017		IN061923			Badmavathi B							GHL-CRF-0413.6 - Barcode search
04/12/2018		68069			Shazana 							GHL-CRF-0503 - SPLIT BATCH
03/09/2020      IN073899            Haribabu                                MMS-DM-CRF-0174.2
22/9/2021		TFS22321			Shazana												GHL-SCF-1587
---------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import=" eST.SplitBatchBean,eST.BatchSearchBeanForBarcode,eST.Common.*,java.util.Hashtable,java.util.HashMap,java.util.ArrayList,webbeans.eCommon.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	SplitBatchBean bean = (SplitBatchBean) getBeanObject("splitBatchBean",  "eST.SplitBatchBean", request ) ;  
	bean.setLanguageId(locale);
	String validate								=	request.getParameter("validate");
	String item_desc							=	request.getParameter("item_desc");

	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
//out.println("htFormValues"+htFormValues);
	String message			=	"";
	String flag				=	"";
	boolean result1=false;
//	String facility_id=(String)session.getValue("facility_id");
	HashMap hashmapDtl=new HashMap();
	boolean	result			=	false;
	try {
		//String operation							=	request.getParameter("operation");
		
		if (validate.equals("ADD_TO_LIST")) {
			 int no_of_decimals				=	bean.getNoOfDecimals();
			String doc_srl_no				=	request.getParameter("doc_srl_no");
			String index				    =	request.getParameter("index");
			//System.out.println("index val==>" +index);
			//System.out.println("doc_srl_no val==>" +doc_srl_no);
			String item_code				=	request.getParameter("item_code");
			String adj_item_qty				=	request.getParameter("adj_item_qty");
			String item_unit_cost			=	request.getParameter("item_unit_cost");
			String item_cost_value			=	request.getParameter("item_cost_value");
			String remarks					=	request.getParameter("remarks");
			String remarks_code				=	request.getParameter("remarks_code");
			String expiry_yn				=	request.getParameter("expiry_yn");
			String batch_id_applicable_yn	=	request.getParameter("batch_id_applicable_yn");
			String trade_id_applicable_yn	=	request.getParameter("trade_id_applicable_yn");
			String stock_uom_code			=	request.getParameter("stock_uom_code");
			String uom			            =	request.getParameter("uom");
			String expiry_date			    =	request.getParameter("expiry_date");
			String batch_id			        =	request.getParameter("batch_id");
			//System.out.println("batch_id 227===>" +batch_id);
			String bin_loc_desc			    =	request.getParameter("bin_loc_desc");
			String trade_name_desc			=	request.getParameter("trade_name_desc");
			String trade_id			        =	request.getParameter("trade_id");
			String bin_loc_code			    =	request.getParameter("bin_loc_code");
			String avl_qty			        =	request.getParameter("avl_qty");
			String dec_allowed_yn			=	request.getParameter("dec_allowed_yn");
			String barcode_yn			    =	request.getParameter("barcode_yn");
			//System.out.println("barcode_yn 51===>" +barcode_yn);
			
			BatchSearchBeanForBarcode bean2 = (BatchSearchBeanForBarcode) getBeanObject("batchSearchBeanForBarcode",  "eST.BatchSearchBeanForBarcode", request ) ;  //added for GHL-CRF-0503
			//System.out.println(bean2.getAllow_zero_batches());
			flag="";
			if(!locale.equals("en"))
			{
                 expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY",locale,"en");
			}

//out.println(bean.getDetailValues());
//			if(operation.equals("insert")) {
               if(barcode_yn.equals("false")){
               if(bean.isDuplicateInArrayList(bean.getDetailValues(), "item_code", item_code, Integer.parseInt(doc_srl_no)-1)) { 
					throw new Exception("RECORD_ALREADY_EXISTS");
				} 
				}
                			 
//			}
//out.println("hellooo");
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("batch_id_applicable_yn",			batch_id_applicable_yn		);
			hashmapDtl.put("trade_id_applicable_yn",			trade_id_applicable_yn		);
			hashmapDtl.put("adj_item_qty",		adj_item_qty	);
			hashmapDtl.put("item_unit_cost",	item_unit_cost		);
			hashmapDtl.put("item_cost_value",	item_cost_value		);
			hashmapDtl.put("stock_uom_code",	stock_uom_code		);
			hashmapDtl.put("uom",	uom		);
			hashmapDtl.put("remarks",			remarks		);
			hashmapDtl.put("remarks_code",		remarks_code);
			hashmapDtl.put("expiry_date",			expiry_date		);
			hashmapDtl.put("batch_id",			batch_id		);
			hashmapDtl.put("bin_loc_desc",			bin_loc_desc		);
			hashmapDtl.put("trade_name_desc",			trade_name_desc		);
			hashmapDtl.put("trade_id",			trade_id		);
			hashmapDtl.put("bin_loc_code",			bin_loc_code		);
			hashmapDtl.put("avl_qty",			avl_qty		);
			hashmapDtl.put("mode",				request.getParameter("mode"));		
			hashmapDtl.put("dec_allowed_yn",				dec_allowed_yn);
            hashmapDtl.put("ADD","NO"); 	
            
          /*added for GHL-ICN-0023 AGAINST GHL-CRF-0503 START*/
            String toBatcBinloc ="";
            String storeBinLoc ="";
            String defaultBinLoc = ""; 
            /*added for GHL-ICN-0023 AGAINST GHL-CRF-0503 END*/
			
//			bean.setExpValues(htFormValues);
//			out.println("alert(\"item_code:"+item_code+"\");");
//			out.println("alert('bean:"+bean+"');");
for(int i=0;i<10;i++) {
		htFormValues.put("expiry_date_or_receipt_date_"+i, com.ehis.util.DateUtils.convertDate((String)htFormValues.get("expiry_date_or_receipt_date_"+i),"DMY",locale,"en"));
	}
	/*Added for GHL-ICN-0023 against GHL-CRF-0503 START*/
	//System.out.println("bean2.getAllow_zero_batches(): "+bean2.getAllow_zero_batches()); 
	if(bean2.getAllow_zero_batches()!=null){ //added for GHL-ICN-0023 issue
		if(bean2.getAllow_zero_batches().equalsIgnoreCase("Y") || bean2.getAllow_zero_batches().equalsIgnoreCase("N") ){
			for(int i=0;i<10;i++){				
				toBatcBinloc = (String)htFormValues.get("bin_location_code_"+i);				
				if(toBatcBinloc.length()>0 ){
					
					storeBinLoc = bean.getStoreBinLocation(toBatcBinloc);					
					if(storeBinLoc.equals("0")){
						//GET DEFAULT BIN LOCATION
						defaultBinLoc= bean.getDefaultBinLocationCode(item_code);
						//System.out.println("defaultBinLoc: "+defaultBinLoc);
						//System.out.println("i: "+i);
						htFormValues.put("bin_location_code_"+i,defaultBinLoc);
						//System.out.println("bin_location_code_i: "+(String)htFormValues.get("bin_location_code_"+i));
					}
					
				}
			}
		}
	}//added for GHL-ICN-0023 issue
		/*Added for GHL-ICN-0023 against GHL-CRF-0503 END*/		
		     boolean check = true;
			//System.out.println("getDetailValues=======146===>"+bean.getDetailValues());
			//System.out.println("toString=======146===>"+bean.toString());
			
			ArrayList altemp =  new ArrayList();
			if (Integer.parseInt(doc_srl_no) == -1 ){
			//System.out.println("altemp==>");
			if (bean.getDetailValues()!=null && bean.getDetailValues().size()>0){
			
			altemp = bean.getDetailValues();

			System.out.println("altemp==>"+altemp);

			for (int i = 0 ; i < altemp.size() ; i++){

			HashMap temp = (HashMap)altemp.get(i);
			if((temp.get("item_code")).toString().equals(item_code)) {
			//System.out.println("altemp==>"+temp.get("batch_id"));
			//System.out.println("batch_id==>"+batch_id);
			if(!(temp.get("batch_id")).equals(batch_id)) {
			throw new Exception("BATCH_MANDATORY");
			}
			hashmapDtl.put("ADD","YES");
			hashmapDtl.put("doc_srl_no",(String)temp.get("doc_srl_no"));
			hashmapDtl.put("mode",(String)temp.get("mode"));
			
		    float	new_adj_item_qty        = Float.parseFloat((String)temp.get("adj_item_qty")) + Float.parseFloat(bean.checkForNull(adj_item_qty,"0")); 
		    float new_item_cost_value		= Float.parseFloat((String)temp.get("item_cost_value")) + Float.parseFloat(bean.checkForNull(item_cost_value,"0"));
			
		   if((bean.getAllowDecimalsYN(item_code)).equals("Y"))			 
    		hashmapDtl.put("adj_item_qty",bean.setNumber(bean.checkForNull(""+new_adj_item_qty,"0"),no_of_decimals));
	    	else
			hashmapDtl.put("adj_item_qty",bean.setNumber(bean.checkForNull(""+new_adj_item_qty,"0"),0));
			
		   hashmapDtl.put("item_cost_value", bean.setNumber(  ""+new_item_cost_value,6));
			 		
			 
			htFormValues.put("ADD1","YES");
			htFormValues.put("ADD2","YES");
			htFormValues.put("ADD3","YES");
			htFormValues.put("doc_srl_no",(String)temp.get("doc_srl_no"));
			
			result			= bean.setExpValues(htFormValues);
			if(!result){
			message="BATCH_DTL_ALREADY_EXIST";
			}
			else
				bean.setDetailValues(hashmapDtl);

			check = false;
			}
			}
			}
			else{
			//System.out.println("pdoc_srl_no=216=>"+doc_srl_no);
			hashmapDtl.put("ADD","NO");
			hashmapDtl.put("doc_srl_no",doc_srl_no);
			htFormValues.put("ADD1","NO");
			htFormValues.put("doc_srl_no",doc_srl_no);
			htFormValues.put("ADD2","NO");
			htFormValues.put("ADD3","NO");
			result			=bean.setExpValues(htFormValues);
			//System.out.println("result===434==>" +result);
		    if(!result){
			message="BATCH_DTL_ALREADY_EXIST";
			}
			else
				bean.setDetailValues(hashmapDtl);
			check = false;
			}
			}
			
			if(check){
				//System.out.println("pdoc_srl_no=227=>"+doc_srl_no);
			hashmapDtl.put("ADD","NO");
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			htFormValues.put("doc_srl_no",		doc_srl_no	);
			htFormValues.put("ADD1","NO");
			htFormValues.put("ADD2","NO");
			htFormValues.put("ADD3","NO");
			result			=bean.setExpValues(htFormValues);
			//System.out.println("result===453==>" +result);
			   if(!result){
			message="BATCH_DTL_ALREADY_EXIST";
			}
			else
				bean.setDetailValues(hashmapDtl);
			}	
		}
		// from here
		else if(validate.equals("ITEM_CODE")) {
		}
		else if (validate.equals("CHECK_PROC")){
			result	=	true;
			try{
			String item_code		=	request.getParameter("item_code");
			String store_code	=	request.getParameter("store_code");
			String [] params={item_code,store_code,"0","N","","N",""};
			HashMap hashStock=new HashMap();

				result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result1)
				{
					String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formOpeningStockListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
				
			hashStock=bean.getStockAvailabilityStatus(params);

			//out.println("hashStock" + hashStock);//store_item_unit_cost
			out.println("document.forms[0].stock_item_yn.value=\""+hashStock.get("stock_item_yn")+"\"");
			/**
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - "available_stock" & "expired_stock" are changed to double from integer.
			*/
			if( ((Double.parseDouble(bean.checkForNull((String)hashStock.get("available_stock"),"0"))) + (Double.parseDouble(bean.checkForNull((String)hashStock.get("expired_stock"),"0")))) > 0)
			{
				
				out.println("document.forms[0].stock_available_yn.value='"+"Y"+"'");
			}
			else{
				
			out.println("document.forms[0].stock_available_yn.value=\""+hashStock.get("stock_available_yn")+"\"");
			}
			/* @Name - Priya
				* @Date - 24/05/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and passed it in the setStockDetails() function and  assign it to the item_unit_cost field
				*/
				//String storeItemUnitCost=bean.getUnitCost(item_code,store_code);
				Double storeItemUnitCost=bean.getBaseUnitCost(item_code);//Added against inc#50521 to display base unit cost

			//out.println("document.getElementById("td_cost").innerText=\""+bean.setNumber((String)hashStock.get("store_item_unit_cost"),3)+"\"");
			out.println("document.getElementById('td_cost').innerText=\""+bean.setNumber(""+storeItemUnitCost,3)+"\"");
			out.println("document.getElementById('td_cost').title=\""+storeItemUnitCost+"\"");
			
			/*** End***/

				if(((String)bean.getAccessCostDetails()).equals("Y")){
					out.println("document.getElementById('id_item_unit_cost_label').style.visibility = 'visible';");
					out.println("document.getElementById('td_cost').style.visibility = 'visible';");
				}
			}catch(Exception exception) {
				result	=	false;
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
			//exception.printStackTrace();
			throw new Exception("ITEM_STORE_NOT_FOUND");//exception;
		}
			//out.println("start of catch"+item_code+hashStock+store_code+"start of catch");
		}else if (validate.equals("BARCODE")) {	
			String frombarcode = bean.checkForNull(request.getParameter("frombarcode"));//Added for GHL-CRF-0413
			String	trn_type     =	bean.checkForNull(request.getParameter("trn_type"));
			String  facility_id  =  bean.checkForNull(bean.getLoginFacilityId());
			String  formname     =	bean.checkForNull(request.getParameter("formObj"));
			String  fromStore    =  bean.checkForNull(request.getParameter("fromStore"));
			String  toStore      =  bean.checkForNull(request.getParameter("toStore"));
			String bar_code = bean.checkForNull(request.getParameter("bar_code"));
			String jsp_page = bean.checkForNull(request.getParameter("jsp_page"));
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
			ArrayList alBarCodeListDetails = new ArrayList();
			String allow_decimals_yn="";
			HashMap alTemp	=	new HashMap();
			boolean site = bean.isSite_spec_yn();
			try {
				if(barcode_2d_applicable_yn.equals("Y")){
					 alBarCodeListDetails =bean.get2DBarcodeBacthes(fromStore,bar_code);//Adding end for MMS-DM-CRF-0174.6
				}else{
			         alBarCodeListDetails = bean.getBarCodeDetailArrayList1(bar_code,fromStore);//GHL-SCF-1587
				}
			if (alBarCodeListDetails.size() > 0 ){			
				 if(alBarCodeListDetails.size() > 1 ){
					HashMap prev_records = new HashMap();
					String itemcode2 = "";
					for (int t=0;t<alBarCodeListDetails.size();t++){
						HashMap record	=	(HashMap)alBarCodeListDetails.get(t);
						String itemcode1 = (String)record.get("ITEM_CODE");
						if(prev_records.size()>0){
							if (!itemcode1.equals(itemcode2)){
							throw new Exception("BARCODE_WITH_MORE_ITEMS");
							}
						}
					prev_records = record;
					itemcode2 = (String)prev_records.get("ITEM_CODE");
					}
					}
			          for(int i=0; i<1; i++) {
					//this is to handle multiple batch, select 1st avail_qty>0
					for(int t1=0; t1<alBarCodeListDetails.size();) {
						HashMap temp_record	=	(HashMap)alBarCodeListDetails.get(t1);
						//System.out.println("temp_record==>"+temp_record);
						int temp_availqty		=	Integer.parseInt((String)temp_record.get("AVAIL_QTY"));
						if(temp_availqty<=0){
							t1++;
						}
						else{
							i = t1;
							break;
						}
					}
				 HashMap record	=	(HashMap)alBarCodeListDetails.get(i);
				// System.out.println("record==>"+record);
				 String itemcode	=	(String)record.get("ITEM_CODE");
				 String batchid	    =	(String)record.get("BATCH_ID");
				 String expirydate	=	(String)record.get("EXPIRY_DATE");
				 String binlocation	=	(String)record.get("BIN_LOCATION_CODE");
				 String tradeid     =	(String)record.get("TRADE_ID");
				 int availqty		=	Integer.parseInt((String)record.get("AVAIL_QTY"));
				 
				String bindesc =  bean.getSTITBin_location_code_List(fromStore,itemcode,binlocation,locale);
				 // System.out.println("bindesc===85 val===>" +bindesc);
		   if(availqty<=0 )				 
			 throw new Exception("INSUFFICIENT_BATCH_QTY");
		else{	
				//to get the item details
				ArrayList alItemDetails = bean.getItemDetailArrayList(locale,itemcode,fromStore);
				alTemp = (HashMap)alItemDetails.get(0);
             //System.out.println("alTemp====" +alTemp);
				String item_code  = (String)alTemp.get("ITEM_CODE") ;
				String item_desc1  = (String)alTemp.get("ITEM_DESC") ;
				String expiry_yn  = (String)alTemp.get("EXPIRY_YN") ;
				String uom_code   = (String)alTemp.get("GEN_UOM_CODE") ;
				String uom_desc   = (String)alTemp.get("GEN_UOM_DESC") ;
                String batch_id_applicable_yn   = (String)alTemp.get("BATCH_ID_APPLICABLE_YN") ;  
                String trade_id_applicable_yn   = (String)alTemp.get("TRADE_ID_APPLICABLE_YN") ;  
              //Added for IN:073899 start
                if(!item_desc1.equals("")&&item_desc1!=null){
					item_desc1=item_desc1.replaceAll(" ","%20");
					item_desc1=	java.net.URLEncoder.encode(item_desc1,"UTF-8");
					item_desc1=item_desc1.replaceAll("%2520","%20");
				}
              //Added for IN:073899 end
				//String manufacturer_id   = bean.checkForNull((String)alTemp.get("MANUFACTURER_ID")) ;
				 //System.out.println("manufacturer_id:" +manufacturer_id);
				 

			//	String supplier_id = bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE_RULE"),new String[]{itemcode,batchid,expirydate}).get("SUPP_CODE"));
				 //System.out.println("supplier_id:" +supplier_id);
			//	String mrp     =  bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",itemcode,tradeid,batchid}).get("MRP_PRICE"));	
                 			
				//System.out.println("alItemDetails==>"+alItemDetails);
				String[] stParameters = {itemcode, fromStore, "0", "N", "", "N", toStore };
				String phy_inv_id = "";
			try { 
				result = bean.isPhysicalInventoryProcessStartedForStore(itemcode,fromStore,toStore);
				if(result){
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,fromStore}).get("PHY_INV_ID");
						if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,toStore}).get("PHY_INV_ID");
			
						out.println("document."+formname+".phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				String use_after_expiry_yn =(String)bean.fetchRecord("select USE_AFTER_EXPIRY_YN from st_item where item_code =?",new String[]{item_code}).get("USE_AFTER_EXPIRY_YN");
				//HashMap bin_desc=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_LIST"),new String[]{fromStore,item_code,locale});
				
				HashMap bin_desc=    bean.fetchRecord("SELECT st.bin_location_code, mm.short_desc FROM st_item_store_bin_locn st, mm_bin_location_lang_vw mm WHERE st.store_code=mm.store_code AND  st.bin_location_code=mm.bin_location_code AND st.store_code=? AND st.item_code=? AND st.bin_location_code = ? AND mm.eff_status ='E' AND mm.language_id = ? and st.eff_status = 'Y' ORDER BY short_desc",new String[]{fromStore,item_code,binlocation,locale});
			    System.out.println("bin_desc======>" +bin_desc);
				
				
				String bin_short_desc = bean.checkForNull((String)bin_desc.get("SHORT_DESC"));
				//System.out.println("bin_short_desc 212" +bin_short_desc);
				double avail_stock=0;				
				 								
				if(use_after_expiry_yn.equals("Y")){
					avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")));
				}else{
					avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")));  
				}
				allow_decimals_yn=(String)hmStockAvailabilityStatus.get("allow_decimals_yn");
				out.println("document."+formname+".dec_allowed_yn.value = '"+allow_decimals_yn+"';");
				if(allow_decimals_yn.equals("Y")){
				out.println("document."+formname+".no_of_decimals.value = '"+allow_decimals_yn+"';");				
				}else{
				out.println("document."+formname+".no_of_decimals.value = '0';");				
				}
				
               // out.println("document."+formname+".manufacturer_id.value = '"+""+"';");  
				//out.println("document."+formname+".supplier_id.value = '"+supplier_id+"';"); 
			  //out.println("document."+formname+".mrp.value = '"+mrp+"';");  
				out.println("document."+formname+".item_code.value = '"+item_code+"';");
				out.println("document."+formname+".item_desc.value = decodeURIComponent('"+item_desc1+"');");//Modified for IN:073899 start
				out.println("document."+formname+".item_desc.readOnly = true;");
				out.println("document."+formname+".expiry_yn.value = '"+expiry_yn+"';");
				out.println("document."+formname+".uom_code.value = '"+uom_code+"';");			
				out.println("document.getElementById('td_uom').innerHTML = '"+uom_desc+"';");	
				out.println("document."+formname+".item_desc.disabled = true;");
				out.println("document.getElementById('ed_data').innerHTML = '"+expirydate+"';");	
				out.println("document.getElementById('bid_data').innerHTML = '"+batchid+"';");	
				out.println("document.getElementById('bl_data').innerHTML = '"+bin_short_desc+"';");	
				out.println("document.getElementById('tn_data').innerHTML = '"+tradeid+"';");	
				out.println("document.getElementById('aq_data').innerHTML = '"+availqty+"';");
               out.println("document."+formname+".bin_location_code.value = '"+binlocation+"';");				
				
				//out.println("document."+formname+".bar_or_item_code.value = 'B';");
				
				
				String  storeItemUnitCost=bean.getUnitCost(itemcode,fromStore);
				//System.out.println("storeItemUnitCost==>"+storeItemUnitCost);
				if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y"))
				{
					if( hmStockAvailabilityStatus.get("available_stock").equals("0"))
						throw new Exception("STOCK_NOT_AVAILABLE");
				} else
					throw new Exception("NOT_STOCK_ITEM");	 		
			}

			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();		
				exception.printStackTrace();	

				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				if (exception.getMessage().equals("STOCK_NOT_AVAILABLE")) {
					throw exception;
				}
				if (exception.getMessage().equals("NOT_STOCK_ITEM")) {
					throw exception;
				}
				if (exception.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
					throw exception;
				}
				if(site)
					throw new Exception("ITEM_STORE_NOT_FOUND1");
				else
				throw new Exception("ITEM_STORE_NOT_FOUND");
				}				
			}
				
				message = itemcode+";"+batchid+";"+expirydate;
				//System.out.println("message.... "+message);	
                out.println("BarcodeApply('"+bar_code+"')");					 			
			}
			}else{
			out.println("document."+formname+".bar_or_item_code.value = 'I';");
			out.println("document."+formname+".BARCODE_YN.value = 'TRUE';");			
			if(!frombarcode.equals("Y")){//Added for GHL-CRF-0413.6 starts
			out.println("callItemSearchScreen()");
			}else{
				throw new Exception("ITEM_STORE_NOT_FOUND1");
			}//Added for GHL-CRF-0413.6 ends
			}
			result			=	true;			
			}
			catch(Exception e){
				 
				if (e.getMessage().equals("INSUFFICIENT_BATCH_QTY")) {
					throw e;
				}
				if (e.getMessage().equals("AVAIL_BATCH_QTY_ALREADY_USED")) {
					throw e;
				}
				if (e.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
					throw e;
				}
				if (e.getMessage().equals("ITEM_STORE_NOT_FOUND")) {//Added for GHL-CRF-0413.6 - Store/Item combination does not exist
					throw e;
				}
				if (e.getMessage().equals("ITEM_STORE_NOT_FOUND1")) {//Added for GHL-CRF-0413.6
					throw e;
				}
				flag			=	"INVALID_BARCODE";
				result			=	false;
			}	
	}else if (validate.equals("BARCODE_VAL")){  
		
		String bar_code =  request.getParameter("bar_code");
		String doc_srl_no = request.getParameter("doc_srl_no");
		String from_store = request.getParameter("fromStore");
			 try{
			 HashMap alTemp	=	new HashMap();
				String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
				ArrayList alBarCodeListDetails = new ArrayList();
			// ArrayList alBarCodeListDetails = bean.getBarCodeDetailArrayList(bar_code,from_store); Modified for IN:062247
			//  ArrayList alBarCodeListDetails = bean.getBarCodeDetail(bar_code,from_store);
				if(barcode_2d_applicable_yn.equals("Y")){
					 alBarCodeListDetails =bean.get2DBarcodeBacthes(from_store,bar_code);//Adding end for MMS-DM-CRF-0174.6
				}else{
					alBarCodeListDetails = bean.getBarCodeDetail(bar_code,from_store);
				
				}
			 //System.out.println("alBarCodeListDetails val" +alBarCodeListDetails); 
			 	 //Added against IN:062247 starts
			String user_id = bean.getLoginById();
			 System.out.println("user_id--->   "+user_id);
			 String PROCESS_SUSPENDED_ITEMS_YN = ((String)	bean.fetchRecord("SELECT PROCESS_SUSPENDED_ITEMS_YN FROM ST_USER_ACCESS_for_STORE WHERE USER_ID = ? AND STORE_CODE = ?",new String[]{user_id,from_store}).get("PROCESS_SUSPENDED_ITEMS_YN"));
			 System.out.println("PROCESS_SUSPENDED_ITEMS_YN--->   "+PROCESS_SUSPENDED_ITEMS_YN);
			 HashMap record_suspend	=	(HashMap)alBarCodeListDetails.get(0); 
				 if(PROCESS_SUSPENDED_ITEMS_YN.equals("N"))	{
					String suspend_yn = (String)record_suspend.get("SUSPENDED_YN");
					System.out.println("SUSPENDED_YN--->   "+suspend_yn);
					if(suspend_yn.equals("Y")){
						throw new Exception("SUSPENDED_BATCH");
					}
				} 
				 BatchSearchBeanForBarcode expiryBean				=		(BatchSearchBeanForBarcode) getBeanObject( "batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode",request );
				 String expiry_date  =		(String)record_suspend.get("EXPIRY_DATE");
				//SQL_ST_BATCH_EXPIRED_OR_NOT
				String item_code_expiry = (String)record_suspend.get("ITEM_CODE");
			 String 	USE_AFTER_EXPIRY_YN = ((String) bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_EXPIRED_OR_NOT"), item_code_expiry).get("USE_AFTER_EXPIRY_YN"));
			 String PROCESS_EXPIRED_ITEMS_YN = ((String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_EXPIRED_USER_ACCESS"),new String[]{from_store,user_id}).get("PROCESS_EXPIRED_ITEMS_YN"));
			 System.out.println("PROCESS_EXPIRED_ITEMS_YN--->   "+PROCESS_EXPIRED_ITEMS_YN);
			 System.out.println("USE_AFTER_EXPIRY_YN--->   "+USE_AFTER_EXPIRY_YN);
			 System.out.println("expiry_date--->   "+expiryBean.isGreaterThanSysdate(expiry_date));
			 if(!expiryBean.isGreaterThanSysdate(expiry_date)) 
			 {
				 if(PROCESS_EXPIRED_ITEMS_YN.equals("N") || USE_AFTER_EXPIRY_YN.equals("N")){
				 System.out.println("EXPIRED_BATCH----->532");
				 throw new Exception("EXPIRED_BATCH");
			 	}
			 }
			 putObjectInBean("batchSearchBeanForBarcode",expiryBean,request);
			 	 //Added against IN:062247 ends
			 for (int t=0;t<alBarCodeListDetails.size();t++){
			          HashMap record	   =	(HashMap)alBarCodeListDetails.get(t);
					  String item_code     =      (String)record.get("ITEM_CODE");
				      String batchid	   =	  (String)record.get("BATCH_ID");
				      String expirydate	   =	  (String)record.get("EXPIRY_DATE");
				      String binlocation   =	  (String)record.get("BIN_LOCATION_CODE");
				      String tradeid       =	  (String)record.get("TRADE_ID");
				       int availqty		   =	   Integer.parseInt((String)record.get("AVAIL_QTY"));
				 
				//to get the item details
				 ArrayList alItemDetails = bean.getItemDetailArrayList(locale,item_code,from_store);
				//System.out.println("alItemDetails= validate=>"+alItemDetails);
				alTemp = (HashMap)alItemDetails.get(t);
				//System.out.println("alTemp= validate=>"+alTemp);	
			  String storeItemUnitCost=bean.getUnitCost(item_code,from_store);
		       out.println("document.getElementById('td_cost').innerText=\""+storeItemUnitCost+"\"");
			  String  default_bin_location_code=bean.getDefaultBinLocationCode(item_code);
			  //System.out.println("default_bin_location_code= validate=>"+default_bin_location_code);
		      String binlocationdefault =   bean.getSTITBin_location_code_List(from_store,item_code,default_bin_location_code,locale);
			 //System.out.println("binlocationdefault= validate=>"+binlocationdefault);
              String trade_id        =       bean.getTradeList(item_code,tradeid);
		        System.out.println("trade_id= validate=>"+trade_id);
			  String trade_id_default =       bean.getTradeListDflt(tradeid);
                System.out.println("trade_id_default= validate=>"+trade_id_default);									  
			   // out.println("document.getElementById("bin_location_code_0").value=\""+binlocationdefault+"\"");  
			 }
				if(((String)bean.getAccessCostDetails()).equals("Y")){
					out.println("document.getElementById('id_item_unit_cost_label').style.visibility = 'visible';");
					out.println("document.getElementById('td_cost').style.visibility = 'visible';");
				}
				result	=	true;
			// if(availqty<=0 )				 
			// throw new Exception("INSUFFICIENT_BATCH_QTY");
				
				}catch (Exception exception) { 
					 //Added against IN:062247 starts
					if (exception.getMessage().equals("SUSPENDED_BATCH")) {
						throw exception;
					}
					if (exception.getMessage().equals("ITEM_STORE_ITEM_CLASS_NOT_FOUND")) {//EXPIRED_BATCH
						throw exception;
					}
					 //Added against IN:062247 ends					
	  	      result	=	false;
		      message	=	exception.getMessage();
				}
		}	
	}
	catch (Exception exception) {//out.println("start of catch");
		result	=	false;
		message	=	exception.getMessage();
		//throws exception.getMessage();
		//exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("splitBatchBean",bean,request);
%>
