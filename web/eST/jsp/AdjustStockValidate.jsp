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
 
 <%@page import=" eST.AdjustStockBean,eST.Common.*,java.util.Hashtable,java.util.HashMap,java.util.ArrayList,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%	
	String locale			= (String)session.getAttribute("LOCALE");
	String user_name=		(String)session.getAttribute("login_user"); // added for MOHE-CRF-0167
	AdjustStockBean bean = (AdjustStockBean)getBeanObject( "adjustStockBean","eST.AdjustStockBean",request ) ;  
	
	bean.setLanguageId(locale);
	String validate								=	request.getParameter("validate");
	String item_desc							=	request.getParameter("item_desc");
	String mode											=request.getParameter("mode");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	String stAuthorized_allowed ="";
	HashMap hashmapDtl=new HashMap();
	boolean	result			=	false;

	try {

		if (validate.equals("ADD_TO_LIST")) {
			String doc_srl_no				=	request.getParameter("doc_srl_no");
			String item_code				=	request.getParameter("item_code");
			String store_code				=	request.getParameter("store_code");
			String adj_item_qty				=	request.getParameter("adj_item_qty");
			String item_unit_cost			=	request.getParameter("item_unit_cost");
			String item_cost_value			=	request.getParameter("item_cost_value");
			String remarks					=	request.getParameter("remarks");
			String item_unit_cost_org		=	request.getParameter("item_unit_cost_org");
			if(request.getParameter("remarks") == null) {
				remarks = "";
			}

			String expiry_yn				=	request.getParameter("expiry_yn");
			String batch_id_applicable_yn	=	request.getParameter("batch_id_applicable_yn");
			String trade_id_applicable_yn	=	request.getParameter("trade_id_applicable_yn");
			String stock_uom_code			=	request.getParameter("stock_uom_code");
			String uom						=	request.getParameter("uom");
			String storecost				=	request.getParameter("storecost");
			String itemlastcost				=	request.getParameter("itemlastcost");
			String adjustment_type				=	request.getParameter("adjustment_type");
			String dec_allowed_yn				=	request.getParameter("dec_allowed_yn");
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
			String disposable_yn				=	bean.checkForNull(request.getParameter("disposable_yn")); 
			String next_batch_id				=	bean.checkForNull(request.getParameter("next_batch_id"));
			flag="";
			//String[] stNames={"item_code"};
			//String[] stValues={item_code};
			String batchidexits="";

			if(doc_srl_no.equals("-1")){
				if(bean.isDuplicateInArrayList(bean.getDetailValues(), "item_code", item_code, Integer.parseInt(doc_srl_no)-1)) {
					throw new Exception("RECORD_ALREADY_EXISTS");
				}

			}
			if( bean.isDuplicateInExpList(htFormValues) ) {
				throw new Exception("RECORD_ALREADY_EXISTS");
			}

/*			if (bean.isNegativeAllowed(htFormValues , store_code ,item_code))
			{
				
				throw new Exception("NEGATIVE_STOCK");
			}
*/
			batchidexits = bean.isBatchIdExits(htFormValues, store_code ,item_code);
			stAuthorized_allowed	=	bean.getFinalize_allowed_yn(store_code);
			if(stAuthorized_allowed.equals("Y"))
			{
				result= true;
				//if(Integer.parseInt(adj_item_qty)<0){ replace for nagitive adj
				if(adjustment_type.equals("N")){
					if(batchidexits.length()>1){
						result	=	false;
						//message	=	"BATCH_RECORD_NOT_FOUND";
						flag=batchidexits;
						throw new Exception("BATCH_RECORD_NOT_FOUND");
					}else{
						if (bean.isNegativeAllowed(htFormValues , store_code ,item_code)){
							throw new Exception("NEGATIVE_STOCK");
						}
					}
				}
			}
			else{
				result= true;
				//if(Integer.parseInt(adj_item_qty)<0){
				if(adjustment_type.equals("N")){
					if(batchidexits.length()>1){
						result	=	false;
						//message	=	"BATCH_RECORD_NOT_FOUND";
						flag=batchidexits;
						throw new Exception("BATCH_RECORD_NOT_FOUND");
					}else{
						if (bean.isNegativeAllowed(htFormValues , store_code ,item_code)){
							throw new Exception("NEGATIVE_STOCK");
						}else
							result = true;
					}
				}
			}
			/*if (bean.isNegativeAllowed(htFormValues , store_code ,item_code)){
				throw new Exception("NEGATIVE_STOCK");
			}*/


			if(result){
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("batch_id_applicable_yn",			batch_id_applicable_yn		);
			hashmapDtl.put("trade_id_applicable_yn",			trade_id_applicable_yn		);
			hashmapDtl.put("item_unit_cost",	item_unit_cost		);
			hashmapDtl.put("adj_item_qty",		adj_item_qty	);
			hashmapDtl.put("item_cost_value",	item_cost_value		);
			hashmapDtl.put("stock_uom_code",	stock_uom_code		);
			hashmapDtl.put("uom",	uom		);
			hashmapDtl.put("storecost",storecost);
			hashmapDtl.put("itemlastcost",itemlastcost);
			hashmapDtl.put("remarks",			remarks		);
			hashmapDtl.put("mode",				request.getParameter("line_mode"));	
			hashmapDtl.put("avl_qty",			bean.checkForNull(request.getParameter("avl_qty"),"0"));
			hashmapDtl.put("min_stk_qty",		request.getParameter("min_stk_qty")	);
			hashmapDtl.put("max_stk_qty",		request.getParameter("max_stk_qty")	);
			hashmapDtl.put("mm_trn_qty",		request.getParameter("mm_trn_qty")	);
			hashmapDtl.put("language_id",		locale	);
			hashmapDtl.put("remarks_code",		request.getParameter("remarks_code")	);
			hashmapDtl.put("adjustment_type",	adjustment_type	);
			hashmapDtl.put("dec_allowed_yn",	dec_allowed_yn	);
			hashmapDtl.put("item_unit_cost_org",	item_unit_cost_org		);
			 
         
   	for(int i=0;i<10;i++) {
		htFormValues.put("expiry_date_or_receipt_date_"+i, com.ehis.util.DateUtils.convertDate((String)htFormValues.get("expiry_date_or_receipt_date_"+i),"DMY",locale,"en"));
	}
			bean.setDetailValues(hashmapDtl);
		//	bean1.setLanguage_id(locale);
			htFormValues.put("adjustment_type",adjustment_type);
			htFormValues.put("first","N");
			htFormValues.put("dec_allowed_yn",dec_allowed_yn);

			bean.setExpValues(htFormValues);
			
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
			if(disposable_yn.equals("Y")){
			bean.setDisposable_yn(disposable_yn);  
			String dflt_dispo_batch_id = bean.checkForNull(bean.getDflt_batch_id(),"");
			if(!dflt_dispo_batch_id.equals("")){ 
			if(Integer.parseInt(next_batch_id) >= Integer.parseInt(dflt_dispo_batch_id)){
			bean.setDflt_batch_id(next_batch_id);  
			}
			}else{
			bean.setDflt_batch_id(next_batch_id); 
            }			
			} //ENDS
			
			
			result			=	true;
			}
		}
		else if(validate.equals("VALIDATE_ITEM_CODE")) {
			String item_code	= request.getParameter("item_code");
			String store_code	= request.getParameter("store_code");
			String phy_inv_id	= "";

				result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result)
				{
					phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formAdjustStockListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
				/*result = false;
				String[] stParameters = {item_code, store_code};
				result = bean.get_unfinalized_trn_status(stParameters);
				if(!result) // False : Unfinalized transaction exits...
				{
					throw new Exception("UNFINALIZED_TRN_EXITS");
				}*/

			ArrayList alBatchList=new ArrayList();
			alBatchList=bean.getBatchDetails(item_code,store_code);            
            String stock_item_yn =(String)(alBatchList.get(0));
			result			=	true;
			if(stock_item_yn.equals("N")) {
				//result = true;
				throw new Exception("NOT_STOCK_ITEM");
			}	
		}		
		else if(validate.equals("setToConv")){
			String store_code				=	request.getParameter("store_code");
			String item_code				=	request.getParameter("item_code");
		double tmp_conv=bean.getConvFactTemp(item_code,store_code);
		/*if(tmp_conv==999999999){
			throw new Exception("Multiple");
			}*/
			result=true;
			out.println("setTempConvFactor('"+tmp_conv+"');");
		}
		else if (validate.equals("FETCH_COST")) {
			String item_code				=	request.getParameter("item_code");
			String store_code				=	request.getParameter("store_code");
			ArrayList alBatchList=new ArrayList();
			alBatchList=bean.getBatchDetails(item_code);
			/**
			 * @Name - Priya
			 * @Date - 20/05/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
			 */
			int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

			//double store_item_unit_cost=Double.parseDouble((String)(alBatchList.get(2)));
			double store_item_unit_cost=bean.getBaseUnitCost(item_code);//Added against inc#50521 to display base unit cost
			System.out.println("Priya=="+"AdjustStockValidate=store_item_unit_cost1==>"+store_item_unit_cost); 
			if (mode == null) mode ="1";
			if (mode.equals("1"))
			{
				out.println("formobj=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader");
				out.println("formobj1=parent.frameAdjustStockListHeader");
			}
			else
			{
			out.println("formobj=parent.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader");
			out.println("formobj1=parent.frameAdjustStockList.frameAdjustStockListHeader");
			}
			out.println( "formobj.item_store_unit_cost_1.value='"+store_item_unit_cost+"'");
			out.println( "formobj.item_last_unit_cost.value='"+store_item_unit_cost+"'");
			/*double item_unit_cost=Double.parseDouble(bean.setNumber(bean.checkForNull((String)(alBatchList.get(1)),"0"),noOfDecimalsForCost));
			System.out.println("Priya=="+"AdjustStockValidate=item_unit_cost==>"+item_unit_cost);
			if(store_item_unit_cost==0)
			{
				if(item_unit_cost!=0)
				{
					out.println( "formobj.item_last_unit_cost.value='"+item_unit_cost+"'");
					store_item_unit_cost=item_unit_cost;
				}
				else
				{
					String item_last_cost=bean.setNumber(bean.checkForNull(bean.getLastCost(item_code),"0"),noOfDecimalsForCost);
					out.println( "formobj.item_last_unit_cost.value='"+item_last_cost+"'");
					store_item_unit_cost=Double.parseDouble(item_last_cost);
				}
			}*/

			System.out.println("Priya=="+"AdjustStockValidate=store_item_unit_cost==>"+store_item_unit_cost);
			/**
				* @Name - Priya
				* @Date - 19/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - the variable 'available_stock' is changed from integer to double as it is having decimal values
				*/
			double available_stock=(Double)alBatchList.get(3);

			//out.println(" populateUnitCost("+ store_item_unit_cost + ",\'"+available_stock + "',\""+ mode + "\" ) ; ") ;
			out.println("populateUnitCost(" + store_item_unit_cost + ", '" + available_stock + "', \"" + mode + "\");");
		//	System.out.println("populateUnitCost(" + store_item_unit_cost + ", '" + available_stock + "', \"" + mode + "\");");
			String[]  minmaxarg = {""+bean.getConvFactTemp(item_code,store_code),item_code, store_code};
			HashMap hmminmax = new HashMap();
			hmminmax =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);

			out.println("formobj1.document.getElementById('min_stk_qty_label').innerHTML = '<B>"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"&nbsp;")+"</B>'");
			out.println("formobj1.document.getElementById('max_stk_qty_label').innerHTML = '<B>"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"&nbsp;")+"</B>'");
			out.println("formobj1.document.getElementById('min_stk_qty').value = '"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"")+"';");
			out.println("formobj1.document.getElementById('max_stk_qty').value = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"")+"';");
		}
		
	else if(validate.equals("CHECK_AUTHORIZE_ALLOWED"))
		{
		
				String store_code	= request.getParameter("store_code");
				stAuthorized_allowed	=	bean.getFinalize_allowed_yn(store_code);
				//out.println("setFinalize_allowed('"+stAuthorized_allowed+"');");
				if(stAuthorized_allowed.equals("Y"))
				result=true;
				else 
				result=false;

				
		}
		else if (validate.equals("printOnlineDoc")){
			try{
			ArrayList doc_no=bean.getPrintDocNo();
				
				String pdocno = "";
				for(int i=0;i<doc_no.size();i++){
					pdocno=(String)doc_no.get(i);
					//bean.doOnlineReportPrinting(pdocno); //Comented By Sakti Sankar on 06/03/2013 against Inc#
					bean.doOnlineReportPrinting(pdocno,request,response); //Added By Sakti Sankar on 06/03/2013 against Inc#
				
				}	}catch(Exception e){
			e.printStackTrace();
				
			}
			result =  true;
			message = request.getParameter("msg");
		}
		// till here
		//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
		else if (validate.equals("check_status")){
			try{
			      result =  true;
			      String store_code =	request.getParameter("store_code");
				  HashMap HMData = new HashMap();
				  HMData  = bean.getDisp_batch(store_code);
				  String dflt_batch_id = bean.checkForNull((String)HMData.get("NEXT_BATCH_ID"));
				  //System.out.println("dflt_batch_id validate==>" +dflt_batch_id);
				  if(dflt_batch_id.equals("")){
				  result =  false;
				  }else{
				  result =  true;
				  }
			  }catch(Exception e){
			      e.printStackTrace();
				   result =  false;
				}
		}
		else if(validate.equals("toolBar"))  {
	         String toolBarString = request.getQueryString() ;
			 session.removeValue("queryString") ;
			 session.putValue( "queryString", toolBarString ) ;
	  	}
		//ends
		else if(validate.equals("GET_GTIN"))  { // Added for MOHE-CRF-0167
			String barcode = request.getParameter("barcode");  
		     String  store_code = request.getParameter("store_code");  
		     String  item_code =request.getParameter("item_code")==null?"":request.getParameter("item_code");  
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
       result = bean.isPhysicalInventoryProcessStartedForStore(barcode_item,store_code,"");
	if(result){
														
			throw new Exception("PHY_INV_PROCESS_INITIATED");
	  }

       item_store_exists=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? and item_code =? and eff_status = 'E'",new String[]{store_code,barcode_item}).get("COUNT"));
if(item_store_exists>0){
		if(barcodeData.containsKey(barcode_item))
			batchData = (LinkedList)barcodeData.get(barcode_item);
			String barcode_item_desc="";
			String Item_desc_val="";
			String IteamSearchBy="";
			IteamSearchBy=(String) bean.fetchRecord("select DFLT_ITEM_SEARCH from st_user_access_for_store where USER_ID=? and STORE_CODE=?",new String[]{user_name,store_code}).get("DFLT_ITEM_SEARCH");
			if(IteamSearchBy.equals("IN")){
			barcode_item_desc=(String) bean.fetchRecord("select short_desc from mm_item_lang_vw where item_code=? and language_id='en'",new String[]{barcode_item}).get("SHORT_DESC");
			Item_desc_val=barcode_item_desc;
			} else if(IteamSearchBy.equals("IC")){
				Item_desc_val=barcode_item;	
			}	
		  out.println("document.formAdjustStockListHeader.item_desc.value = '"+bean.checkForNull(Item_desc_val,"")+"';");
		  out.println("document.formAdjustStockListHeader.barcode.value = ''");
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

			
		} // end
	}
	catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		
		//exception.printStackTrace();

		//flag=validate;
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("adjustStockBean",bean,request);
%>
