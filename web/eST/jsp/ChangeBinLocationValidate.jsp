 <%@page import=" eST.*,eST.Common.*,java.util.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	ChangeBinLocationBean bean = 
	(ChangeBinLocationBean)getBeanObject( "ChangeBinLocationBean","eST.ChangeBinLocationBean",request ) ;  
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String user_name=		(String)session.getAttribute("login_user");
	bean.setLanguageId(locale); 	 
	String validate	  =	request.getParameter("validate");
		
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
	String item_code		=	"";
	String store_code		=	"";
	String bar_code         =   "";  

	HashMap hashmapDtl=new HashMap();
	boolean	result			=	false;

	try {
		if (validate.equals("ADD_TO_LIST")) {
			String doc_srl_no				=	request.getParameter("doc_srl_no");
			item_code						=	request.getParameter("item_code");
            String item_desc				=	request.getParameter("item_desc");
            String batch_id				    =	request.getParameter("batch_id");
			String uom_code					=	request.getParameter("uom_code");
            String uom						=	request.getParameter("uom");
            String trade_id 				=	request.getParameter("trade_id");
            String trade_name				=	request.getParameter("trade_name");
			String adj_item_qty				=	request.getParameter("adj_item_qty");
            String avl_item_qty				=	request.getParameter("avl_item_qty");
			String old_bin_loc_code			=	request.getParameter("old_bin_loc_code");
            String old_bin_loc_desc		    =	request.getParameter("old_bin_loc_desc");
            String new_bin_loc_code			=	request.getParameter("new_bin_loc_code");
            String new_bin_loc_desc			=	request.getParameter("new_bin_loc_desc");
			String exp_date			        =	request.getParameter("exp_date");
            store_code						=	request.getParameter("store_code");
			String new_barcode_id           =   bean.checkForNull(request.getParameter("new_barcode_id"));  
			String old_barcode_id           =   bean.checkForNull(request.getParameter("old_barcode_id"));  
            String trn_type					=	"CBL" ;
			String suspended_batch_allowed_yn = "Y"   ;
			flag="";

			String []name={ "item_code","batch_id","exp_date","new_bin_loc_code" };
			String []value={item_code,batch_id,exp_date,new_bin_loc_code};

			if(bean.isDuplicateInArrayList(bean.getDetailValues(),name,value,Integer.parseInt(doc_srl_no)-1)) {
					throw new Exception("RECORD_ALREADY_EXISTS");
			}
			
			hashmapDtl.put("doc_srl_no",	doc_srl_no	);
			hashmapDtl.put("item_code", 	item_code	);
            hashmapDtl.put("trn_type", 	    trn_type	);
            hashmapDtl.put("suspended_batch_allowed_yn",suspended_batch_allowed_yn);
            hashmapDtl.put("item_desc", 	item_desc	);
			hashmapDtl.put("batch_id",  	batch_id );
			hashmapDtl.put("uom_code",  	uom_code );
            hashmapDtl.put("uom",  			uom );
            hashmapDtl.put("trade_id", 	    trade_id	 );
			hashmapDtl.put("trade_name", 	trade_name	 );
			hashmapDtl.put("adj_item_qty",	adj_item_qty );
			hashmapDtl.put("avl_item_qty",	avl_item_qty	);
			hashmapDtl.put("old_bin_loc_code",	old_bin_loc_code	);
            hashmapDtl.put("old_bin_loc_desc",	old_bin_loc_desc	);
			hashmapDtl.put("new_bin_loc_code",	new_bin_loc_code	);
			hashmapDtl.put("new_bin_loc_desc",	new_bin_loc_desc );
			hashmapDtl.put("exp_date",		exp_date    ); 
			hashmapDtl.put("mode",      	request.getParameter("mode"));		
            hashmapDtl.put("old_barcode_id",		old_barcode_id    );  
			hashmapDtl.put("new_barcode_id",		new_barcode_id    );   
			System.out.println("hashmapDtl====>" +hashmapDtl);
			
			bean.setDetailValues(hashmapDtl);
			result			=	true;
		}
		else if(validate.equals("ITEM_CODE")) {

			item_code	=	request.getParameter("item_code");
            store_code	=	request.getParameter("store_code");

            try{

			result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result)
				{
					String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formChangeBinLocationList.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
			ArrayList alBatchList=new ArrayList();
			alBatchList=bean.getBatchDetails(item_code,store_code);
            String stock_availability="";

			stock_availability =(String)(alBatchList.get(0));

			if(stock_availability.equals("N"))
               out.println( "disableBatchButton1();" ) ;
            else
			  out.println( "enableBatchButton();" ) ;

			}
			catch(Exception exception) {
				exception.printStackTrace();
				
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
				result=true;

		}else if(validate.equals("BIN_LOCATION")) {
            store_code	=	request.getParameter("store_code");
            item_code	=	request.getParameter("item_code");
			ArrayList BinLocationList = bean.getSTITBin_location_code_ArrayList(store_code,item_code,locale);
			out.println("clearListItems('formChangeBinLocationList.to_bin_location'); ");
			HashMap record = new HashMap();
			for(int i=0; i< BinLocationList.size(); i++) {
      		   record = (HashMap)BinLocationList.get(i);
 			   out.println("addListItem(\"formChangeBinLocationList.to_bin_location\", \"" + record.get("BIN_LOCATION_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
			result=true;
		}else if (validate.equals("BARCODE")) {	 
			String	trn_type     =	bean.checkForNull(request.getParameter("trn_type"));
			String  facility_id  =  bean.checkForNull(bean.getLoginFacilityId());
			String  formname     =	bean.checkForNull(request.getParameter("formObj"));
			String  fromStore    =  bean.checkForNull(request.getParameter("fromStore"));
			String  toStore      =  bean.checkForNull(request.getParameter("toStore"));
			        bar_code     =  bean.checkForNull(request.getParameter("bar_code"));
			String allow_decimals_yn="";
			String uom_desc = "";
			HashMap alTemp	=	new HashMap();
			try {
			ArrayList alBarCodeListDetails = bean.getBarCodeDetailArrayList(bar_code,fromStore);
			 //System.out.println("alBarCodeListDetails=product=>"+alBarCodeListDetails);							
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
				 //System.out.println("record==>"+record);
				 String itemcode	=	(String)record.get("ITEM_CODE");
				 String batchid	    =	(String)record.get("BATCH_ID");
				 String expirydate	=	(String)record.get("EXPIRY_DATE");
				 String binlocation	=	(String)record.get("BIN_LOCATION_CODE");
				 String tradeid     =	(String)record.get("TRADE_ID");
				 int availqty		=	Integer.parseInt((String)record.get("AVAIL_QTY"));
				 
				String bindesc =  bean.getSTITBin_location_code_List(fromStore,itemcode,binlocation,locale);
				  //System.out.println("bindesc===85 val===>" +bindesc);
		   if(availqty<=0 )				 
			 throw new Exception("INSUFFICIENT_BATCH_QTY");
		else{	
				//to get the item details
				ArrayList alItemDetails = bean.getItemDetailArrayList(locale,itemcode,fromStore); 
				//System.out.println("alItemDetails===val==181==>" +alItemDetails);
				alTemp = (HashMap)alItemDetails.get(0);
				System.out.println("alTemp===val==181==>" +alTemp);
				 item_code  = (String)alTemp.get("ITEM_CODE") ;
				String item_desc1  = (String)alTemp.get("ITEM_DESC") ;
				String expiry_yn  = (String)alTemp.get("EXPIRY_YN") ;
				String uom_code   = (String)alTemp.get("GEN_UOM_CODE") ;
				 uom_desc   = (String)alTemp.get("GEN_UOM_DESC") ;
                String batch_id_applicable_yn   = (String)alTemp.get("BATCH_ID_APPLICABLE_YN") ; 
                String trade_id_applicable_yn   = (String)alTemp.get("TRADE_ID_APPLICABLE_YN") ;  
                String manufacturer_id          = bean.checkForNull((String)alTemp.get("MANUFACTURER_ID")) ;
				// System.out.println("manufacturer_id:" +manufacturer_id);
				 
				 String supplier_id = bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE_RULE"),new String[]{itemcode,batchid,expirydate}).get("SUPP_CODE"));
				// System.out.println("supplier_id:" +supplier_id);
				String mrp     =  bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",itemcode,tradeid,batchid}).get("MRP_PRICE"));
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
				double avail_stock=0;				
				 								
				if(use_after_expiry_yn.equals("Y")){
					avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")));
				}else{
					avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")));  
				}
				allow_decimals_yn=(String)hmStockAvailabilityStatus.get("allow_decimals_yn");
 				if(allow_decimals_yn.equals("Y")){
				//out.println("document."+formname+".no_of_decimals.value = '"+allow_decimals_yn+"';");				
				}else{
				//out.println("document."+formname+".no_of_decimals.value = '0';");				
				}
				String  storeItemUnitCost=bean.getUnitCost(itemcode,fromStore);
				
                out.println("document."+formname+".item_desc.value = '"+item_desc1+"';");
				out.println("document."+formname+".item_desc.readOnly = true;");
				out.println("document."+formname+".batch_search.disabled = true;");
				out.println("document."+formname+".item_search.disabled = true;");
				out.println("document."+formname+".item_code_bar_code.value = '"+item_code+"';");
				out.println("document."+formname+".item_code.value = '"+item_code+"';");
				out.println("document."+formname+".uom_code.value = '"+uom_code+"';");
				out.println("document."+formname+".uom.value = '"+uom_desc+"';");
				out.println("document."+formname+".check.value =  'Y';");
				out.println("document."+formname+".bar_code.value = '"+bar_code+"';");
 				uom_desc = "UOM <b>"+uom_desc+"</b>";
			    out.println("document.getElementById('td_uom').innerHTML = '"+uom_desc+"';");
			    out.println("document."+formname+".manufacturer_id.value = '"+manufacturer_id+"';");  
			    out.println("document."+formname+".supplier_id.value = '"+supplier_id+"';");  
				out.println("document."+formname+".mrp.value = '"+mrp+"';");  
				
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
				
				throw new Exception("ITEM_STORE_NOT_FOUND");
				}				
			}
				
				message = itemcode+";"+batchid+";"+expirydate;
				System.out.println("message.... "+message);	
                					 			
			}
			}else{
			//out.println("document."+formname+".bar_or_item_code.value = 'I';");
			//out.println("document."+formname+".BARCODE_YN.value = 'TRUE';");			
			out.println("callItemSearchScreen()");
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
				flag			=	"INVALID_BARCODE";
				result			=	false;
			}	
	}  else if (validate.equals("BARCODE_CHANGE")) {
	        try{
	          store_code      =  bean.checkForNull(request.getParameter("store_code"));
			   bar_code       =  bean.checkForNull(request.getParameter("bar_code"));
	          item_code       =  bean.checkForNull(request.getParameter("item_code"));
			  String short_desc ="";
 		      String  frmname     =	bean.checkForNull(request.getParameter("formObj"));
 	          ArrayList albatchdetails = bean.getBarCodeDetailArrayList(bar_code,store_code);
			 System.out.println("albatchdetails=changevaildate=>"+albatchdetails);
		   	 for(int l=0; l<1; l++){
			  HashMap recrd	=	(HashMap)albatchdetails.get(l);
			 
			   String availableqty	=   (String)recrd.get("AVAIL_QTY");
			   String BATCH_ID	=	(String)recrd.get("BATCH_ID");
			   String EXPIRY_DATE	=	(String)recrd.get("EXPIRY_DATE");
			   String ITEM_CODE	=	(String)recrd.get("ITEM_CODE");
			   String TRADE_ID	=	(String)recrd.get("TRADE_ID");
			   String STORE_CODE	=	(String)recrd.get("STORE_CODE");
			   String binlocation	=	(String)recrd.get("BIN_LOCATION_CODE");
			   System.out.println("binlocation======>" +binlocation);
				   
			// HashMap bin_desc=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_LIST"),new String[]{store_code,item_code,locale});
			 
			HashMap bin_desc=    bean.fetchRecord("SELECT st.bin_location_code, mm.short_desc FROM st_item_store_bin_locn st, mm_bin_location_lang_vw mm WHERE st.store_code=mm.store_code AND  st.bin_location_code=mm.bin_location_code AND st.store_code=? AND st.item_code=? AND st.bin_location_code = ? AND mm.eff_status ='E' AND mm.language_id = ? and st.eff_status = 'Y' ORDER BY short_desc",new String[]{store_code,item_code,binlocation,locale});
			  System.out.println("bin_desc======>" +bin_desc);
			 
			    short_desc = bean.checkForNull((String)bin_desc.get("SHORT_DESC"));
				 System.out.println("short_desc======>" +short_desc);
 				HashMap alTempBIN = new HashMap();
				ArrayList alItemDetailsBIN = bean.getItemDetailArrayList(locale,item_code,store_code);
				alTempBIN = (HashMap)alItemDetailsBIN.get(0);

				 
				String ITEM_DESC  = (String)alTempBIN.get("ITEM_DESC") ;
				String EXPIRY_YN  = (String)alTempBIN.get("EXPIRY_YN") ;
				String GEN_UOM_CODE   = (String)alTempBIN.get("GEN_UOM_CODE") ;
				String GEN_UOM_DESC   = (String)alTempBIN.get("GEN_UOM_DESC") ;
                String BATCH_ID_APPLICABLE_YN   = (String)alTempBIN.get("BATCH_ID_APPLICABLE_YN") ; 
                String TRADE_ID_APPLICABLE_YN   = (String)alTempBIN.get("TRADE_ID_APPLICABLE_YN") ;  			
		   if(Integer.parseInt(availableqty)<=0 )				 
			 throw new Exception("INSUFFICIENT_BATCH_QTY");
		     else{
			 out.println("document."+frmname+".adj_item_qty.value = '"+availableqty+"';");
 			    String  short_desc_bin = "Bin Location&nbsp&nbsp&nbsp;  <b>"+short_desc+"</b>";
 				 out.println("document.getElementById('batch_dtl1').innerHTML = '"+short_desc_bin+"';");
 			out.println("BarcodeApply('"+ITEM_CODE+"','"+ITEM_DESC+"','"+TRADE_ID+"','"+short_desc+"','"+BATCH_ID+"','"+EXPIRY_DATE+"','"+EXPIRY_YN+"','"+GEN_UOM_DESC+"','"+GEN_UOM_CODE+"','"+availableqty+"','"+binlocation+"')");
			 
			 }
			 
			 }
			 
			 result			=	true;			
			}
			catch(Exception e){
				 
				if (e.getMessage().equals("INSUFFICIENT_BATCH_QTY")) {
					throw e;
				}
				result			=	false;
			  }
			 
           
     }	// end
	else if (validate.equals("BARCODE_VAL")){
		String barcode =  request.getParameter("barcode");
		String fromStore = request.getParameter("fromStore");
		String barcode_item ="";
		int item_store_exists = 0;
		int gtin_count =0;
		
        gtin_count =bean.getGTINItemCount(barcode);
	if(gtin_count==1){ 
		barcode_item  = bean.checkForNull(bean.getItemByGTIN(barcode)); 
		HashMap barcodeData  =new HashMap();
		 LinkedList batchData=new LinkedList();	 
         barcodeData =bean.getBarcodeData();
		 int j =0;
		 
	 if(barcode_item!=""){

        result = bean.isPhysicalInventoryProcessStartedForStore(barcode_item,fromStore,"");
	if(result){
														
			throw new Exception("PHY_INV_PROCESS_INITIATED");
	  }

        item_store_exists=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? and item_code =? and eff_status = 'E'",new String[]{fromStore,barcode_item}).get("COUNT"));
        
if(item_store_exists>0){
		if(barcodeData.containsKey(barcode_item))
			batchData = (LinkedList)barcodeData.get(barcode_item);
		String barcode_item_desc="";
		String Item_desc_val="";
		String IteamSearchBy="";
		IteamSearchBy=(String) bean.fetchRecord("select DFLT_ITEM_SEARCH from st_user_access_for_store where USER_ID=? and STORE_CODE=?",new String[]{user_name,fromStore}).get("DFLT_ITEM_SEARCH");
		if(IteamSearchBy.equals("IN")){
		barcode_item_desc=(String) bean.fetchRecord("select short_desc from mm_item_lang_vw where item_code=? and language_id='en'",new String[]{barcode_item}).get("SHORT_DESC");
		Item_desc_val=barcode_item_desc;
		} else if(IteamSearchBy.equals("IC")){
			Item_desc_val=barcode_item;	
		}		
			out.println("document.formChangeBinLocationList.item_desc.value = '"+bean.checkForNull(Item_desc_val,"")+"';");		
		    out.println("document.formChangeBinLocationList.barcode.value = ''");
			result=true;
	   }else{
		    throw new Exception ("ITEM_STORE_NOT_FOUND1");

	   }
	 }else{
		 
		     throw new Exception ("ST_INVALID_BAR_CODE");
	    }
	}else{
		if(gtin_count==0){
			throw new Exception ("ST_INVALID_BAR_CODE");
		}else if(gtin_count>1){
			throw new Exception ("BARCODE_WITH_MORE_ITEMS");
		}
	 }
		
	}

		
	}
	catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%><%
putObjectInBean("ChangeBinLocationBean",bean,request);
%>
