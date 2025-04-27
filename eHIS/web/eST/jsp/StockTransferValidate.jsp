
<%@page contentType="text/html;charset=UTF-8" import=" eST.StockTransferBean,java.util.ArrayList,java.util.HashMap,java.sql.*,webbeans.eCommon.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String user_name=		(String)session.getAttribute("login_user");
	StockTransferBean bean = (StockTransferBean)getBeanObject( "stockTransferBean","eST.StockTransferBean" , request ) ;  
	bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	String item_desc	=	request.getParameter("item_desc");
	System.out.println("validate--T-->"+validate);
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	HashMap hmminmaxlist=new HashMap();

	String message			=	"";
	String flag				=	"";
	//String facility_id=(String)session.getValue("facility_id");
	HashMap hashmapDtl=new HashMap();
	String item_code				=	request.getParameter("item_code");
	String store_code				=	request.getParameter("store_code");
	String to_store					=	request.getParameter("to_store_code");
	String item_qty					=	request.getParameter("item_qty");
	String uom_desc					=	request.getParameter("uom_desc");
	String stock_available			=	request.getParameter("stock_available");
	String stock_item_yn			=	request.getParameter("stock_item_yn");
	String doc_srl_no				=	request.getParameter("doc_srl_no");
	String item_unit_cost			=	request.getParameter("item_unit_cost");
	String item_cost_value			=	request.getParameter("item_cost_value");
	String expiry_yn				=	request.getParameter("expiry_yn");
//	String stock_uom_code			=	request.getParameter("stock_uom_code");
	String uom_code					=	request.getParameter("uom_code");
	String index					=	request.getParameter("index");
	String to_conv_fact				=	request.getParameter("to_conv_fact");
	String frm_conv_fact			=	request.getParameter("frm_conv_fact");
	String frm_store_uom_desc		=	request.getParameter("frm_store_uom_desc");
	String to_store_uom_desc		=	request.getParameter("to_store_uom_desc");
	String batch_records			=	request.getParameter("batch_records");

    String expired_batch            =   request.getParameter("expired_batch");
	String ex_param_days            =   request.getParameter("ex_param_days");
	String allow_deci_yn            =   request.getParameter("allow_yn");
	String no_deci					=   request.getParameter("no_decimals");
    String kit_item_yn				=	request.getParameter("kit_item_yn");
    String from_multiples			=	bean.checkForNull(request.getParameter("from_multiples"),"1");
    String to_multiples				=	bean.checkForNull(request.getParameter("to_multiples"),"1");
    String batch_multiples			=	bean.checkForNull(request.getParameter("batch_multiples"),"1");
	String kit_temp_code             =  bean.checkForNull(request.getParameter("kit_temp_code"),"");        //01/08/12
	String usage_type                =  bean.checkForNull(request.getParameter("usage_type"),"");  
	
	boolean	result					=	false;
	String trn_type = null;
		HashMap hresult= null;
	try {
	//	String operation							=	request.getParameter("operation");
		if (validate.equals("ADD_TO_LIST")) {
		
			flag="";
			
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("stock_item_yn",		stock_item_yn	);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_code",			uom_code		);
			hashmapDtl.put("item_qty",			item_qty		);
			hashmapDtl.put("item_unit_cost",	item_unit_cost	);
			hashmapDtl.put("item_cost_value",	item_cost_value	);
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("stock_available",	stock_available	);
			hashmapDtl.put("store_code",		store_code		);
			hashmapDtl.put("expired_batch",		expired_batch	);
			hashmapDtl.put("ex_param_days",		ex_param_days	);
			hashmapDtl.put("to_conv_fact",		to_conv_fact	);
			hashmapDtl.put("frm_conv_fact",		frm_conv_fact	);
			hashmapDtl.put("frm_store_uom_desc",		frm_store_uom_desc);
			hashmapDtl.put("to_store_uom_desc",		to_store_uom_desc);
			hashmapDtl.put("batch_records",		batch_records);
			hashmapDtl.put("no_deci",		no_deci);
			hashmapDtl.put("allow_deci_yn",		allow_deci_yn);
			hashmapDtl.put("kit_item_yn",		kit_item_yn);
			hashmapDtl.put("from_multiples",	from_multiples);
			hashmapDtl.put("to_multiples",		to_multiples);
			hashmapDtl.put("batch_multiples",	batch_multiples);
			
			// changed on 28/07/2004 to display the icons	
			HashMap rol_min = new HashMap();
			try{
						rol_min = bean.getROL(item_code,request.getParameter("store_alt_code"));
			}catch(Exception e){
				e.printStackTrace();
			}
			if(!stock_available.equals("")){
				if((Double.parseDouble(stock_available) - Double.parseDouble(item_qty)) < Double.parseDouble((String)rol_min.get("REORDER_LEVEL")))
					hashmapDtl.put("ROL_YN", "Y"	);
				else
					hashmapDtl.put("ROL_YN", "N"	);
				
				if((Double.parseDouble(stock_available) - Double.parseDouble(item_qty)) < Double.parseDouble((String)rol_min.get("MIN_STK_QTY")))
					hashmapDtl.put("Min_YN", "Y"	);
				else
					hashmapDtl.put("Min_YN", "N"	);
			}else{
					hashmapDtl.put("ROL_YN", "N"	);
					hashmapDtl.put("Min_YN", "N"	);
			}
			hashmapDtl.put("kit_temp_code",	kit_temp_code); //01/08/12
			hashmapDtl.put("usage_type",	usage_type);
			
			System.out.println("hashmapDtl===110===>>>" +hashmapDtl);

			String[] stNames={"item_code"};
			String[] stValues={item_code};
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");

			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);


			/*  ========= Start of Min Max Validation ===========*/
			hmminmaxlist.put("frm_store_qty_on_hand",  request.getParameter("frm_store_qty_on_hand"));	
			hmminmaxlist.put("frm_store_min_stk_level",request.getParameter("frm_store_min_stk_level"));	
			hmminmaxlist.put("frm_store_max_stk_level",request.getParameter("frm_store_max_stk_level"));	
			hmminmaxlist.put("frm_store_reorder_level",request.getParameter("frm_store_reorder_level"));	
			hmminmaxlist.put("to_store_qty_on_hand",   request.getParameter("to_store_qty_on_hand"));	
			hmminmaxlist.put("to_store_min_stk_level", request.getParameter("to_store_min_stk_level"));	
			hmminmaxlist.put("to_store_max_stk_level", request.getParameter("to_store_max_stk_level"));	
			hmminmaxlist.put("to_store_reorder_level", request.getParameter("to_store_reorder_level"));	
			bean.updateMinMaxRecords(Integer.parseInt(index), hmminmaxlist);

			
			System.out.println(" Stock getBarcodeApplicable()()"+bean.getBarcodeApplicable());
			if(bean.getBarcodeApplicable().equals("Y")){
			hashmapDtl.put("ADD","NO");
			htFormValues.put("pindex",		""+index);
			bean.updateDtlRecordforBarCode(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecordsforBarCode(Integer.parseInt(index), htFormValues);
			bean.updateMinMaxRecordsforBarcode(Integer.parseInt(index), hmminmaxlist);
			}	


			result			=	true;
		}

		else if(validate.equals("GET_STATUS")) {
			String[] stParameters = {item_code, store_code, "0", "N", "", "Y", to_store };
			try {
				String phy_inv_id = "";
			result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,to_store);
				if(result)
				{
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,to_store}).get("PHY_INV_ID");
					out.println("document.formStockTransferListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
				String[] stNames={"item_code"};
				String[] stValues={item_code};
				String allow_deci_yn1 = "";
				String no_deci1 = "";

				//if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				//	throw new Exception("RECORD_ALREADY_EXISTS");

				if(bean.getBarcodeApplicable().equals("Y")){
				//if (bean.isDuplicateInArrayList(bean.getDtlRecordsforBarCode(),stNames,stValues,-1)){
				//	throw new Exception("RECORD_ALREADY_EXISTS");
				//}
				}
				else{
				if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1)){
					throw new Exception("RECORD_ALREADY_EXISTS");
				}
				}


				 allow_deci_yn1	        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
                 out.println("document.formStockTransferListHeader.no_deci.value = '"+bean.getNoOfDecimals()+"';");
				 if(allow_deci_yn1.equals("Y"))
			     no_deci1              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			     else
                 no_deci1   = "0";
				 
				 out.println("document.formStockTransferListHeader.allow_deci_yn.value = '"+allow_deci_yn1+"';");
				 
				 HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				
				 String use_after_expiry_yn =(String)bean.fetchRecord("select USE_AFTER_EXPIRY_YN from st_item where item_code =?",new String[]{item_code}).get("USE_AFTER_EXPIRY_YN");
				
				 double availble_st=0;
			
				
				System.out.println("hmStockAvailabilityStatus==>"+hmStockAvailabilityStatus);

				if(use_after_expiry_yn.equals("Y")){
					availble_st=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")));
				}else{
					availble_st=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")));  
				}
				/* @Name - Priya
				* @Date - 26/05/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and passed it in the setStockDetails() function and  assign it to the item_unit_cost field
				*/
				//String storeItemUnitCost=bean.getUnitCost(item_code,store_code);
				//Modified by suresh.r on 11-08-2014 against Inc#50616
				double storeItemUnitCost=bean.getBaseUnitCost(item_code);

			//out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("to_stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\",\""+bean.setNumber(String.valueOf(availble_st),Integer.parseInt(no_deci1))+"\",\""+bean.getConvFactTemp(item_code,store_code)+"\",\""+hmStockAvailabilityStatus.get("expired_stock")+"\");");
			   out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("to_stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+bean.setNumber(String.valueOf(availble_st),Integer.parseInt(no_deci1))+"\",\""+bean.getConvFactTemp(item_code,store_code)+"\",\""+hmStockAvailabilityStatus.get("expired_stock")+"\");");
			/** End**/
				if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y"))
				{
					if( availble_st==0){
						throw new Exception("STOCK_NOT_AVAILABLE");
					}
				}else{
					throw new Exception("NOT_STOCK_ITEM");
				}
				if(hmStockAvailabilityStatus.get("to_stock_item_yn").equals("N"))
					throw new Exception("NOT_STOCK_ITEM");
				result		=	true;

			}catch (Exception exception) {
		//		exception.printStackTrace();
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
					throw exception;
				}
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				if (exception.getMessage().equals("STOCK_NOT_AVAILABLE")) {
					throw exception;
				}
				if (exception.getMessage().equals("NOT_STOCK_ITEM")) {
					throw exception;
				}
				
				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
		}
		else if(validate.equals("MIN_MAX_STATUS"))
		{
			try{
				String[]  minmaxarg = {""+bean.getConvFactTemp(item_code,store_code),item_code, store_code};
				HashMap hmminmax = new HashMap();
				hmminmax =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);
				//out.println("document.getElementById("lb_frm_store_qty_on_hand").innerHTML = '"+bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"&nbsp;")+"';");
/*				out.println("document.getElementById("lb_frm_store_min_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_frm_store_max_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_frm_store_reorder_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_frm_store_uom_desc").innerHTML = '"+bean.checkForNull((String)bean.getShortDesc(item_code,store_code),"&nbsp;")+"';");
*/
				//out.println("document.getElementById("frm_store_qty_on_hand").value = '"+bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"0")+"';");
				out.println("document.getElementById('frm_store_min_stk_level').value = '"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('frm_store_max_stk_level').value = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('frm_store_reorder_level').value = '"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"")+"';");
				//out.println("document.getElementById("frm_store_uom_desc").value = '"+bean.checkForNull((String)bean.getShortDesc(item_code,store_code),"&nbsp;")+"';");
				
				//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014
		        if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
				if(!(bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")).equals("0")){
				out.println("document.getElementById('id_min_stk_label').style.visibility = 'visible';");
				out.println("document.getElementById('id_min_str_stk').style.visibility = 'visible';");
				out.println("document.getElementById('id_min_str_stk').innerHTML = '<B>"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")+"</B>';");
				if 
				((Double.parseDouble(bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"0")) < Double.parseDouble(bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")))) {
						out.println("document.getElementById('id_min_str_stk').innerHTML = '<B style= background-color:red;color:yellow;>"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")+"</B>';");
				 }
				}
				if(!(bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0")).equals("0")){
				out.println("document.getElementById('id_stk_rol_label').style.visibility = 'visible';");
				out.println("document.getElementById('id_stk_rol').style.visibility = 'visible';");
				out.println("document.getElementById('id_stk_rol').innerHTML = '<B >"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0")+"</B>';");
				
				if 
				((Double.parseDouble(bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"0")) < Double.parseDouble(bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0"))))
				 {
					out.println("document.getElementById('id_stk_rol').innerHTML = '<B style= background-color:red;color:yellow; >"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0")+"</B>';");
				 }
				}
		       } //ends
				
				
				
				String frm_storeUOMDesc = bean.checkForNull((String)bean.getShortDesc(item_code,store_code));
				if(!frm_storeUOMDesc.equals(""))
					frm_storeUOMDesc =  java.net.URLEncoder.encode(frm_storeUOMDesc,"UTF-8");

				String[]  minmaxarg1 = {""+bean.getConvFactTemp(item_code,store_code),item_code, to_store};
				HashMap hmminmax1 = new HashMap();
				hmminmax1 =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg1);

/*				out.println("document.getElementById("lb_to_store_qty_on_hand").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("QTY_ON_HAND"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_min_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("MIN_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_max_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("MAX_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_reorder_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("REORDER_LEVEL"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_uom_desc").innerHTML = '"+bean.checkForNull((String)bean.getShortDesc(item_code,to_store),"&nbsp;")+"';");
*/			
				out.println("document.getElementById('to_store_qty_on_hand').value = '"+bean.checkForNull((String)hmminmax1.get("QTY_ON_HAND"),"0")+"';");
				out.println("document.getElementById('to_store_min_stk_level').value = '"+bean.checkForNull((String)hmminmax1.get("MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('to_store_max_stk_level').value = '"+bean.checkForNull((String)hmminmax1.get("MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('to_store_reorder_level').value = '"+bean.checkForNull((String)hmminmax1.get("REORDER_LEVEL"),"")+"';");
				//out.println("document.getElementById("to_store_uom_desc").value = '"+bean.checkForNull((String)bean.getShortDesc(item_code,to_store),"&nbsp;")+"';");
				String to_storeUOMDesc = bean.checkForNull((String)bean.getShortDesc(item_code,store_code));
				if(!to_storeUOMDesc.equals(""))
					to_storeUOMDesc =  java.net.URLEncoder.encode(to_storeUOMDesc,"UTF-8");
				out.println("assignUOMDesc('"+frm_storeUOMDesc+"','"+to_storeUOMDesc+"')");



				if(((String)bean.getAccessCostDetails()).equals("Y")){
					out.println("document.getElementById('id_item_unit_cost_label').style.visibility = 'visible';");
					out.println("document.getElementById('id_item_unit_cost').style.visibility = 'visible';");
					out.println("document.getElementById('id_item_sal_value_label').style.visibility = 'visible';");
					out.println("document.getElementById('id_item_sal_value').style.visibility = 'visible';");
				}
				
			result =  true;
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}

			
		}

		else if(validate.equals("CHECK_AUTHORIZE_ALLOWED")) {
			String stAuthorized_allowed	=	bean.getFinalize_allowed_yn(store_code);
			out.println("setFinalize_allowed('"+stAuthorized_allowed+"');");
			result=true;
		}else if(validate.equals("setToConv")){
			item_code       =   (String)request.getParameter("item_code");
			String to_store_code	=	(String)request.getParameter("to_store_code");
			String fm_store_code	=	(String)request.getParameter("fm_store_code");
			double tmp_conv=bean.getConvFactTemp(item_code,to_store_code);
			bean.setTempConvFact(tmp_conv);
			double frm_tmp_conv=bean.getConvFactTemp(item_code,fm_store_code);
			bean.setFromTempConvFact(frm_tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
			out.println("setFromTempConvFactor('"+frm_tmp_conv+"');");
		}

//  Added for online printing on 9/30/2004

		else if (validate.equals("printOnlineDoc")){
			try{
				//String pdocno=bean.getPrintDocNo();
				//bean.doOnlineReportPrinting(pdocno);	
				ArrayList doc_no=bean.getPrintDocNo();
				String pdocno = "";
				for(int i=0;i<doc_no.size();i++){
					pdocno=(String)doc_no.get(i);
					//bean.doOnlineReportPrinting(pdocno);
					bean.doOnlineReportPrinting(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
				}
			   }catch(Exception e){
					e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}
		else if (validate.equals("POPULATE_TO_STORES")){

			String request_by_store=request.getParameter("request_by_store");
			
			bean.setFrom_store_code(request_by_store);
				//To populate the requisition_on_stores
					out.println("clearListItems('formStockTransferQueryCriteria.to_store'); ");
					ArrayList req_by_stores = bean.getOnStoresStock(bean.getFrom_store_code());
					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formStockTransferQueryCriteria.to_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
					}
		}
		else if (validate.equals("POPULATE_ITEM_CLASSES")){

			String request_by_store = request.getParameter("request_by_store");
			String request_on_store = request.getParameter("request_on_store");
	
			out.println("clearListItems('formStockTransferQueryCriteria.item_class_code'); ");
			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			HashMap record = null;
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"formStockTransferQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		else if(validate.equals("KIT_TEMPLATE")){
			try{
				String kit_template_code = (String)request.getParameter("kit_template_code")==null?"":(String)request.getParameter("kit_template_code");
				String to_store_code = (String)request.getParameter("to_store_code")==null?"":(String)request.getParameter("to_store_code");
				if(!(kit_template_code.equals(""))){
					bean.kitTemplateValues(kit_template_code,store_code,to_store_code);
				}
				ArrayList alDetailData=bean.getKitDtlData();
				HashMap hmStockAvailabilityStatus = new HashMap();	
				int count = (int)bean.getCount();
					HashMap ht = new HashMap();
				if(alDetailData.size()>count){
					ht = (HashMap)alDetailData.get(count);
						out.println("document.formStockTransferListHeader.item_code.value = '"+bean.checkForNull((String)ht.get("ITEM_CODE"),"")+"';");
						out.println("document.formStockTransferListHeader.item_desc.value = \""+bean.checkForNull((String)ht.get("SHORT_DESC"))+"\";");
						out.println("document.formStockTransferListHeader.expiry_yn.value = '"+bean.checkForNull((String)ht.get("EXPIRY_YN"),"")+"';");
						out.println("document.formStockTransferListHeader.kit_item_yn.value = '"+bean.checkForNull((String)ht.get("KIT_ITEM_YN"),"N")+"';");
						out.println("document.formStockTransferListHeader.uom_code.value = '"+bean.checkForNull((String)ht.get("UOM_CODE"),"")+"';");
						out.println("document.formStockTransferListHeader.item_unit_cost.value = '"+bean.checkForNull((String)ht.get("ITEM_UNIT_COST"),"")+"';");
						out.println("document.getElementById('id_item_sal_value').innerHTML ='"+bean.checkForNull((String)ht.get("ITEM_VALUE"),"0")+"';");
						
						out.println("document.formStockTransferListHeader.kit_temp_code.value = '"+bean.checkForNull((String)ht.get("KIT_TEMPLATE_CODE"),"")+"';");
						out.println("document.formStockTransferListHeader.usage_type.value = '"+bean.checkForNull((String)ht.get("USAGE_TYPE"),"")+"';");
						
						try{
							String[] stParameters = {bean.checkForNull((String)ht.get("ITEM_CODE"),""), store_code, "0", "N", "", "N", to_store_code };
							hmStockAvailabilityStatus = new HashMap();
							hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						}catch(Exception e){
							result = false;
						}

					if (hmStockAvailabilityStatus.get("stock_item_yn")!=null && hmStockAvailabilityStatus.get("stock_item_yn").equals("Y") && !(hmStockAvailabilityStatus.get("available_stock").equals("0"))){
						out.println("document.formStockTransferListHeader.item_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"0")+";");
					//	double frm_tmp_conv=bean.getConvFactTemp_From((String)ht.get("ITEM_CODE"),store_code);
					//	double ret_q=Double.parseDouble((String)ht.get("QUANTITY"))*frm_tmp_conv;
					//	out.println("document.formStockTransferListHeader.ret_qty.value = "+ret_q+";");
						out.println("document.formStockTransferListHeader.ret_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"0")+";");
						if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
							
							out.println("document.formStockTransferListHeader.item_qty.value = 0;");
							out.println("document.formStockTransferListHeader.ret_qty.value = 0;");
							out.println("document.formStockTransferListHeader.item_unit_cost.value = 0;");
							out.println("document.getElementById('id_item_sal_value').innerHTML = 0;");
						}
						}else{
						out.println("document.formStockTransferListHeader.item_qty.value = 0;");
						out.println("document.formStockTransferListHeader.ret_qty.value = 0;");
						out.println("document.formStockTransferListHeader.expiry_yn.value = 'XX';");
						}
						out.println("document.formStockTransferListHeader.kit.value = 'kit';");
					
						out.println("document.formStockTransferListHeader.store_code.value = '"+bean.checkForNull((String)store_code,"")+"';");
						out.println("document.getElementById('id_uom').innerHTML = '"+bean.checkForNull((String)ht.get("STOCK_UOM_DESC"),"&nbsp;")+"';");
			double tmp_conv=bean.getConvFactTemp((String)ht.get("ITEM_CODE"),to_store_code);
			bean.setTempConvFact(tmp_conv);
			double frm_tmp_conv=bean.getConvFactTemp((String)ht.get("ITEM_CODE"),store_code);
			bean.setFromTempConvFact(frm_tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
			out.println("setFromTempConvFactor('"+frm_tmp_conv+"');");

						out.println("kitGetStatus();");
					result = true;
				}else{
					out.println("statusOfItem();");
					result = false;
				}
			}catch(Exception e){
				result = false;
				message = e.getMessage();
				e.printStackTrace();
			}
		}
		else if(validate.equals("ERROR_MESSAGE")) {
			ArrayList alDtlData = new ArrayList();
			ArrayList errorList = new ArrayList();
			HashMap ht = new HashMap();
			//alDtlData = bean.getDtlRecords();
			HashMap hmStockAvailabilityStatus = null;
			//alDtlData = bean.getDtlRecords();
			alDtlData = bean.getKitDtlData();
			for(int i=0;i<alDtlData.size();i++){
				ht = (HashMap)alDtlData.get(i);
				String[] stParameters = {(String)ht.get("ITEM_CODE"), store_code, "0", "N", "", "N", to_store };
					result = bean.isPhysicalInventoryProcessStartedForStore((String)ht.get("ITEM_CODE"),store_code,to_store);
					if(result){
						errorList.add("PHY_INV_PROCESS_INITIATED");
						errorList.add((String)ht.get("SHORT_DESC"));
					}
					try{
						hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y")){
							if( hmStockAvailabilityStatus.get("available_stock").equals("0")){
								errorList.add("STOCK_NOT_AVAILABLE");
								errorList.add((String)ht.get("SHORT_DESC"));
							}
							if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
								errorList.add("INSUFFICIENT_BATCH_QTY");
								errorList.add((String)ht.get("SHORT_DESC"));
							}
						}else{
							errorList.add("NOT_STOCK_ITEM");
							errorList.add((String)ht.get("SHORT_DESC"));
						}
					}catch(Exception e){
						if(!result){
							errorList.add("ITEM_STORE_NOT_FOUND");
							errorList.add((String)ht.get("SHORT_DESC"));
						}
					}
			}
			out.println("displayMessage('"+errorList+"');");
			result		=	true;
		}else if(validate.equals("ZERO_QUANTITY")){
			result = true;

			ArrayList alDtlData = new ArrayList();
			//alDtlData = bean.getDtlRecords();
			System.out.println("StockTransferValidate-----bean.getBarcodeApplicable()--"+bean.getBarcodeApplicable());
			
			if(bean.getBarcodeApplicable().equals("Y")){
				alDtlData = bean.getDtlRecordsforBarCode();
				System.out.println("StockTransferValidate---if--alDtlData--"+alDtlData);
				}
			else{	
				alDtlData = bean.getDtlRecords();
				System.out.println("StockTransferValidate---else--alDtlData--"+alDtlData);
			}

			HashMap ht = new HashMap();
			if(Integer.parseInt(index)>alDtlData.size())
				return;
				//ht = (HashMap)bean.getDtlRecord(Integer.parseInt(index));

				if(bean.getBarcodeApplicable().equals("Y")){
				ht = (HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
				System.out.println("StockTransferValidate---if--ht--"+ht);
				}
				else{	
				ht = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
				System.out.println("StockTransferValidate---else--ht--"+ht);
				}

					if(!((String)ht.get("item_unit_cost")).equals("")&&((String)ht.get("item_qty")).equals("0")){
						result = false;
					}
		}else if(validate.equals("CONV_CALCULATE")){
			item_code       =   (String)request.getParameter("item_code");
			String to_store_code	=	(String)request.getParameter("to_store_code");
			String fm_store_code	=	(String)request.getParameter("fm_store_code");
			HashMap conv_factors	=	(HashMap)bean.getConvFactTemp(item_code,fm_store_code,to_store_code);
			out.println("setMultiples('"+(String)conv_factors.get("FROM_STORE_MULTIPLES")+"','"+(String)conv_factors.get("TO_STORE_MULTIPLES")+"','"+(String)conv_factors.get("BATCH_QTY_MULTIPLES")+"');");
			/*double tmp_conv=bean.getConvFactTemp(item_code,to_store_code);
			bean.setTempConvFact(tmp_conv);
			double frm_tmp_conv=bean.getConvFactTemp(item_code,fm_store_code);
			bean.setFromTempConvFact(frm_tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
			out.println("setFromTempConvFactor('"+frm_tmp_conv+"');");*/
			result = true;
		}else if(validate.equals("VALIDATE_DATA")) {
			result = false;
			try{
			ArrayList dtlRecords = (ArrayList)bean.getDtlRecords();
			HashMap hmDtlRecords = null;
			for(int i=0;i<dtlRecords.size();i++){
				hmDtlRecords = (HashMap)dtlRecords.get(i);
				//if(((String)hmDtlRecords.get("for_bin_to_store_hidden")).equals("Y")){
					hresult = bean.validateData(i);
					result = ((Boolean)hresult.get("result")).booleanValue();
					if (!(((Boolean)hresult.get("result")).booleanValue())){
						message="TO_BIN_LOC_NOT_BLANK";
						flag = flag + (String)hresult.get("flag");
					}
				//}
			}
			if((((String)flag).equals(""))){
				result = true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}

		} 
		//Added By Rabbani #inc no:28266 on 16/09/11 
	   //Starts Here
		  else if(validate.equals("COST_PRICE")){
		     String value = null;
			 String from_store_code	=	(String)request.getParameter("from_store_code");
			  ArrayList  alist =  bean.getTrnTypeArrayList();
	          for(int k=0; k<alist.size(); k++){
	          HashMap  blist = (HashMap)alist.get(k);
	           for(int l=0; l<blist.size();l++){
	           trn_type = (String)blist.get("TRNTYPE");
	           if(trn_type.equals("TFR")){
			    value = bean.getCostYN(from_store_code);
			 } 
		   }
	     }
		 
		  if(trn_type == null){
		  value = bean.getAccessCostDetails();
		  }
			if(value.equals("Y")){
			result = true;
			}else{
			result = false;
		  }
		} else if(validate.equals("USAGE_TYPE_STATUS")){ //17/09/12
			       usage_type=	(String)request.getParameter("usage_type");
				   System.out.println("usage_type val=582=>" +usage_type);
			       index	=	(String)request.getParameter("index_");
				    System.out.println("index val=582=>" +index);
			String  BARCODE_YN	=	(String)request.getParameter("BARCODE_YN");
			  System.out.println("BARCODE_YN val==>" +BARCODE_YN);
			   HashMap alDtl			=		new HashMap();
			  if (BARCODE_YN.equals("TRUE")){
				alDtl = (HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
				//System.out.println("stk---if--ht--"+alDtl);
				}
				else{	
				alDtl = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
				//System.out.println("stk---else--ht--"+alDtl);
				}
	         alDtl.put("usage_type",usage_type);	 
		 if (BARCODE_YN.equals("TRUE")){	
      bean.updateDtlRecordforBarCode(Integer.parseInt(index), alDtl);
	  }else{
	  bean.updateDtlRecord(Integer.parseInt(index), alDtl);
	  }  
			result = true;
	 }  
		else if (validate.equals("GET_GTIN")){//Adding start for MOHE-CRF-0167
			String barcode = request.getParameter("barcode");  
			       store_code = request.getParameter("store_code");  
			       item_code =request.getParameter("item_code")==null?"":request.getParameter("item_code");  
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
			 System.err.println("641 in StockTransferValidate.jsp=== barcode_item=="+barcode_item);
		 if(barcode_item!=""){

	        result = bean.isPhysicalInventoryProcessStartedForStore(barcode_item,store_code,"");
		if(result){
															
				throw new Exception("PHY_INV_PROCESS_INITIATED");
		  }

	        item_store_exists=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? and item_code =? and eff_status = 'E'",new String[]{store_code,barcode_item}).get("COUNT"));
	if(item_store_exists>0){
			if(barcodeData.containsKey(barcode_item))
				batchData = (LinkedList)barcodeData.get(barcode_item);
			if(item_code.equals("")){
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
			  out.println("document.formStockTransferListHeader.item_desc.value = '"+bean.checkForNull(Item_desc_val,"")+"';");
			  out.println("document.formStockTransferListHeader.barcode.value = ''");
			    result=true;
			}else{
				out.println("document.formStockTransferListHeader.barcode.value = ''");
			 }
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
	} //END
		else if(validate.equals("BARCODECHECK_SAMEITEM")){
			System.err.println("BARCODECHECK_SAMEITEM starts");
			String newBarcode = request.getParameter("barcode");
			String init_store_code = request.getParameter("store_code");
			String init_item_code = request.getParameter("item_code");
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MOHE-CRF-0167
			   String oldItemCode = "";
			   try{
			   oldItemCode =init_item_code; 
			   System.out.println("oldItemCode-->"+oldItemCode);
			   String newItemCode = "";
			   if(barcode_2d_applicable_yn.equals("Y")){ //Adding start for MOHE-CRF-0167
				   newItemCode = bean.get2DBarcodeItem(init_store_code,newBarcode);
			   }else{
			   newItemCode=bean.checkForNull((String)	bean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{newBarcode,init_store_code}).get("ITEM_CODE"),"");
			   }
			   System.out.println("newItemCode-->"+newItemCode);
			   if( oldItemCode.equals(newItemCode)){
			   	   result = true;
			   bean.getAddBatchRecords().clear();
			   }
			   else{
			       result = false;
			   }
			   
			   }
			   catch(Exception exception){
					exception.printStackTrace();
					flag			=	"BARCODECHECK_SAMEITEM";
					result			=	false;
				}
		
		} // end
	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	//	exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("stockTransferBean",bean,request);
%>
