
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Incident   		Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
MM/DD/YYYY
01/11/2018		66143			Chithra.M									GHL-SCF-1282
11/16/2018		69074			Manickam									GHL-ICN-0032

---------------------------------------------------------------------------------------------------------
*/ 
%><%@page contentType="text/html;charset=UTF-8" import="eST.Common.*, eST.StockItemConsumptionBean,eST.BatchSearchBean,java.util.Hashtable,java.util.HashMap,java.util.ArrayList"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	StockItemConsumptionBean bean = (StockItemConsumptionBean)getBeanObject( "stockItemConsumptionBean", "eST.StockItemConsumptionBean",request) ;  
	BatchSearchBean bean2 = (BatchSearchBean)getBeanObject("batchSearchBean", "eST.BatchSearchBean", request);
	bean.setLanguageId(locale);
	bean2.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	String item_desc	=	request.getParameter("item_desc");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
//	String facility_id=(String)session.getValue("facility_id");
	HashMap hashmapDtl=new HashMap();
	String item_code				=	request.getParameter("item_code");
	String store_code				=	request.getParameter("store_code");
	String item_qty					=	request.getParameter("item_qty");
	String uom_desc					=	request.getParameter("uom_desc");
	String uom_code					=	request.getParameter("uom_code");
	String stock_available			=	request.getParameter("stock_available");
	String remarks					=	request.getParameter("remarks");
	String remarks_code				=	bean.checkForNull(request.getParameter("remarks_code"));
	String patient_id				=	request.getParameter("patient_id");

	String doc_srl_no				=	request.getParameter("doc_srl_no");
	String item_unit_cost			=	request.getParameter("item_unit_cost");
	String item_cost_value			=	request.getParameter("item_cost_value");
	String expiry_yn				=	request.getParameter("expiry_yn");
	String stock_item_yn			=	request.getParameter("stock_item_yn");
	String index					=	request.getParameter("index");
	String expired_batch			=	request.getParameter("expired_batch");
	String ex_param_days			=	request.getParameter("ex_param_days");
	String mm_trn_qty				=	request.getParameter("mm_trn_qty");
	String batchsearch				=	request.getParameter("batchsearch");
	String batch_records			=	(String)request.getParameter("batch_records");
	String dec_allowed_yn1			=	request.getParameter("dec_allowed_yn");
	String kit_temp_code             =  bean.checkForNull(request.getParameter("kit_temp_code"),"");        //01/08/12
	String usage_type                =  bean.checkForNull(request.getParameter("usage_type"),"");
	
	boolean	result					=	false;
	try {
		//String operation							=	request.getParameter("operation");
		if (validate.equals("ADD_TO_LIST")) {
			
			flag="";
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("stock_item_yn",		stock_item_yn	);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("uom_code",			uom_code		);
			hashmapDtl.put("item_qty",			item_qty		);
			hashmapDtl.put("item_unit_cost",	item_unit_cost	);
			hashmapDtl.put("item_cost_value",	item_cost_value	);
			hashmapDtl.put("stock_available",	stock_available	);
			hashmapDtl.put("remarks",			remarks			);
			hashmapDtl.put("remarks_code",		remarks_code	);
			hashmapDtl.put("expired_batch",		expired_batch	);
			hashmapDtl.put("ex_param_days",		ex_param_days	);
			hashmapDtl.put("mm_trn_qty",		mm_trn_qty		);
			hashmapDtl.put("batch_records",		batch_records	);
			hashmapDtl.put("dec_allowed_yn",	dec_allowed_yn1	);
			hashmapDtl.put("kit_temp_code",	kit_temp_code); //01/08/12
			hashmapDtl.put("usage_type",	usage_type);
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			if(batchsearch.equals("search")){
				bean.setExpRecords(Integer.parseInt(index), (ArrayList)bean2.getSelectedList());
			}
			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);
			result			=	true;
		}
		// from here
		else if (validate.equals("PATIENT_NAME")){
			 String new_con_screen_yn =request.getParameter("new_con_screen_yn")==null?"N":request.getParameter("new_con_screen_yn");//Added for TH-KW-CRF-0042
			out.println("clearListItems('document.formStockItemConsumptionHeader.encounter_id'); ");
			if (patient_id.trim().equals("")) {
				out.println("setPatientName('');");
				result			=	true;
				return;
			}
			try{
				out.println("setPatientName(\""+bean.checkForNull(bean.getPatientName(patient_id))+"\");");
				//ArrayList alEncounterList = bean.getEncounterArrayList(patient_id,(String)request.getParameter("sal_type"));
				
			if((request.getParameter("sal_type")).equals("R") ||  ((request.getParameter("sal_type")).equals("C")) && new_con_screen_yn.equals("N"))
			{//new_con_screen_yn Added for TH-KW-CRF-0042
			}
			else{
				ArrayList alEncounterList = bean.getEncounterArrayList(patient_id,(String)request.getParameter("sal_type"),new_con_screen_yn);// new_con_screen_ynAdded for TH-KW-CRF-0042
				HashMap record	=	null;
				if(new_con_screen_yn.equals("N")){//Added if condition for TH-KW-CRF-0042
				   for(int i=0; i< alEncounterList.size(); i++) {
					record	=	(HashMap)alEncounterList.get(i);
					String code		=	(String)record.get("ITISTOPOPULATELISTBOX");
					String values	=	bean.checkForNull((String)record.get("ENCOUNTER_ID"))+" , "+bean.checkForNull((String)record.get("CLINIC_NAME"))+" , "+bean.checkForNull((String)record.get("DT_TIME"))+" , "+bean.checkForNull((String)record.get("PRACTITIONER_NAME"));
					out.println("addListItem(\"document.formStockItemConsumptionHeader.encounter_id\", \"" +code+ "\",\"" +values+ "\"); ");
				  }
				}else{//Adding start for TH-KW-CRF-0042
					 for(int i=0; i< alEncounterList.size(); i++) {
					    record	=	(HashMap)alEncounterList.get(i);
						String listRecord	=	(String)record.get("ENCOUNTER_ID");
						out.println("addListItem(\"document.formStockItemConsumptionHeader.encounter_id\", \"" +listRecord+ "\",\"" +listRecord+ "\"); ");
						out.println("defaultEncounter();");
					 }
				  }
				}//Adding end for TH-KW-CRF-0042
				result			=	true;
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
		}
		else if(validate.equals("GET_STATUS")) {
			
			String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			String stock_yn	 = "";
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				throw new Exception("RECORD_ALREADY_EXISTS");
			try { 

				result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result)
				{
						String phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formStockItemConsumptionListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				String use_after_expiry_yn =(String)bean.fetchRecord("select USE_AFTER_EXPIRY_YN from st_item where item_code =?",new String[]{item_code}).get("USE_AFTER_EXPIRY_YN");
				
				if(hmStockAvailabilityStatus.get("stock_item_yn").equals("N")){
					stock_yn = "N";
					throw new Exception("NOT_STOCK_ITEM");
				}else{
					Double avail_stock = 0.0;
					if(use_after_expiry_yn.equals("Y")){
					avail_stock=(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")))/bean.getConvFactTemp(item_code,store_code);
					}else{
						avail_stock=Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/bean.getConvFactTemp(item_code,store_code);
				
					}
					/**
						* @Name - Suri
						* @Date - 20/01/2010
						* @Inc# - IN015496
						* @Desc - Code added to accept decimal values dynamically.
						* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
					*/
					int no_of_decimals=0;
					String dec_allowed_yn				=	request.getParameter("dec_allowed_yn");
					if(dec_allowed_yn.equals("Y")){
					 no_of_decimals=bean.getNoOfDecimals();
				     //out.println("alert(\"dec_allowed_yn:---->"+dec_allowed_yn+"\");");
					}
			   /* @Name - Priya
				* @Date - 19/05/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and passed it in the setStockDetails() function and  assign it to the item_unit_cost field
				*/
				//String storeItemUnitCost=bean.getUnitCost(item_code,store_code);
			   //Modified by suresh.r on 19-08-2014 against Inc #50616 beg
				double storeItemUnitCost=bean.getBaseUnitCost(item_code);
				 //out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\",\""+bean.setNumber(avail_stock.toString(),no_of_decimals)+"\");");
				out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+bean.setNumber(avail_stock.toString(),no_of_decimals)+"\",\""+bean.getConvFactTemp(item_code,store_code)+"\");");//Modified by suresh.r on 21-08-2014 added getConvFactTemp against Inc#50616
				}
			}
			catch (Exception exception) {
		//		exception.printStackTrace();
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				if(stock_yn.equals("N"))
					throw new Exception("NOT_STOCK_ITEM");
				else
					throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			if(((String)bean.getAccessCostDetails()).equals("Y")){
				out.println("document.getElementById('id_item_sal_value_label').style.visibility = 'visible';");
				out.println("document.getElementById('id_item_sal_value').style.visibility = 'visible';");
			}
			result=true;
		}
		/*else if(validate.equals("GET_STATUS")) {
			
			String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			String stock_yn	 = "";
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				throw new Exception("RECORD_ALREADY_EXISTS");
			try { 
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				if((hmStockAvailabilityStatus.get("stock_item_yn")).equals("N"))
				{
					stock_yn = "N";
					throw new Exception("NOT_STOCK_ITEM");
				}else{
					out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\",\""+hmStockAvailabilityStatus.get("available_stock")+"\");");
				}
			}
			catch (Exception exception) {
				exception.printStackTrace();
				if(stock_yn.equals("N"))
					throw new Exception("NOT_STOCK_ITEM");
				else
					throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			if(((String)bean.getAccessCostDetails()).equals("Y")){
				out.println("document.getElementById('id_item_sal_value_label').style.visibility = 'visible';");
				out.println("document.getElementById('id_item_sal_value').style.visibility = 'visible';");
			}
			result=true;
		}*/
		else if(validate.equals("CHECK_AUTHORIZE_ALLOWED")) {
			String stAuthorized_allowed	=	bean.getAuthorize_allowed_yn(store_code);
			out.println("setAuthorize_allowed('"+stAuthorized_allowed+"');");
			result=true;
		}		
		else if (validate.equals("printOnlineDoc")){
			try{
			       //String pdocno=bean.getPrintDocNo();
			        //bean.doOnlineReportPrinting(session,pdocno);	
				    //bean.setSession(session);
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
		else if(validate.equals("KIT_TEMPLATE")){
			try{
				String kit_template_code = (String)request.getParameter("kit_template_code")==null?"":(String)request.getParameter("kit_template_code");
				if(!(kit_template_code.equals(""))){
					bean.kitTemplateValues(kit_template_code,store_code,store_code);
					bean.setKit_code(kit_template_code);
				}
				ArrayList alDetailData=bean.getKitDtlData();
				HashMap hmStockAvailabilityStatus = new HashMap();			
				int count = (int)bean.getCount();
					HashMap ht = new HashMap();
				if(alDetailData.size()>count){
					ht = (HashMap)alDetailData.get(count);
						out.println("document.formStockItemConsumptionListHeader.item_code.value = '"+bean.checkForNull((String)ht.get("ITEM_CODE"),"")+"';");
						out.println("document.formStockItemConsumptionListHeader.item_desc.value = \""+bean.checkForNull((String)ht.get("SHORT_DESC"))+"\";");
						//out.println("document.formSalesListHeader.item_desc.value = '"+bean.checkForNull((String)ht.get("SHORT_DESC"),"")+"';");
						out.println("document.formStockItemConsumptionListHeader.expiry_yn.value = '"+bean.checkForNull((String)ht.get("EXPIRY_YN"),"")+"';");
						out.println("document.formStockItemConsumptionListHeader.uom_code.value = '"+bean.checkForNull((String)ht.get("UOM_CODE"),"")+"';");
						//out.println("document.formSalesListHeader.iss_uom_code.value = '"+bean.checkForNull((String)ht.get("DEF_ISSUE_UOM"),"")+"';");
						//out.println("document.formSalesListHeader.item_unit_cost.value = '"+bean.checkForNull((String)ht.get("ITEM_UNIT_COST"),"")+"';");
						out.println("document.getElementById('id_store_item_unit_cost').innerHTML = '"+bean.checkForNull((String)ht.get("ITEM_UNIT_COST"),"&nbsp;")+"';");
						out.println("document.getElementById('id_item_sal_value').innerHTML = '"+bean.checkForNull((String)ht.get("ITEM_VALUE"),"&nbsp;")+"';");
						out.println("document.formStockItemConsumptionListHeader.kit_temp_code.value = '"+bean.checkForNull((String)ht.get("KIT_TEMPLATE_CODE"),"")+"';");
						out.println("document.formStockItemConsumptionListHeader.usage_type.value = '"+bean.checkForNull((String)ht.get("USAGE_TYPE"),"")+"';");
						try{
							String[] stParameters = {bean.checkForNull((String)ht.get("ITEM_CODE"),""), store_code, "0", "N", "", "N", "" };
							hmStockAvailabilityStatus = new HashMap();
							hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						}catch(Exception e){
							result = false;
						}
					if (hmStockAvailabilityStatus.get("stock_item_yn")!=null && hmStockAvailabilityStatus.get("stock_item_yn").equals("Y") && !(hmStockAvailabilityStatus.get("available_stock").equals("0"))){
						out.println("document.formStockItemConsumptionListHeader.item_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"")+";");
						out.println("document.formStockItemConsumptionListHeader.tot_item_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"")+";");
						if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
							out.println("document.formStockItemConsumptionListHeader.item_qty.value = 0;");
							out.println("document.formStockItemConsumptionListHeader.tot_item_qty.value = 0;");
							out.println("document.getElementById('id_store_item_unit_cost').innerHTML = 0;");
							out.println("document.getElementById('id_item_sal_value').innerHTML = 0;");
						}
						int no_of_decimals=0;
						if(((String)hmStockAvailabilityStatus.get("allow_decimals_yn")).equals("Y")){
							 no_of_decimals=bean.getNoOfDecimals();
						 //out.println("alert(\"dec_allowed_yn:---->"+dec_allowed_yn+"\");");
						}
						String use_after_expiry_yn =(String)bean.fetchRecord("select USE_AFTER_EXPIRY_YN from st_item where item_code =?",(String)ht.get("ITEM_CODE")).get("USE_AFTER_EXPIRY_YN");
						Double avail_stock = 0.0;
						if(use_after_expiry_yn.equals("Y")){
						avail_stock=(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")))/bean.getConvFactTemp(item_code,store_code);
						}else{
							avail_stock=Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/bean.getConvFactTemp(item_code,store_code);
					
						}

						out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\",\""+bean.setNumber(avail_stock.toString(),no_of_decimals)+"\",\""+bean.getConvFactTemp(item_code,store_code)+"\");");//Modified by suresh.r on 21-08-2014 added getConvFactTemp against Inc#50616	
					}else{
						out.println("document.formStockItemConsumptionListHeader.item_qty.value = 0;");
						out.println("document.formStockItemConsumptionListHeader.tot_item_qty.value = 0;");
						out.println("document.formStockItemConsumptionListHeader.expiry_yn.value = 'XX';");
					}
						out.println("document.formStockItemConsumptionListHeader.kit.value = 'kit';");
						out.println("document.formStockItemConsumptionListHeader.store_code.value = '"+bean.checkForNull((String)store_code,"")+"';");
						out.println("document.getElementById('id_uom').innerHTML = '"+bean.checkForNull((String)ht.get("STOCK_UOM_DESC"),"&nbsp;")+"';");
						//out.println("document.getElementById('uom_desc').innerHTML = '"+bean.checkForNull((String)ht.get("GEN_UOM_DESC"),"&nbsp;")+"';");
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
			result = false;
			ArrayList alDtlData = new ArrayList();
			ArrayList errorList = new ArrayList();
			HashMap ht = new HashMap();
			HashMap hmStockAvailabilityStatus = null;
			//alDtlData = bean.getDtlRecords();
			alDtlData = bean.getKitDtlData();
			for(int i=0;i<alDtlData.size();i++){
				ht = (HashMap)alDtlData.get(i);
				String[] stParameters = {(String)ht.get("ITEM_CODE"), store_code, "0", "N", "", "N", "" };
					result = bean.isPhysicalInventoryProcessStartedForStore((String)ht.get("ITEM_CODE"),store_code,"");
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
			boolean site = bean.isSite_spec_yn();//Added for GHL-CRF-0413 
			if(site){
				alDtlData = bean.getDtlRecordsforBarCode();
			}
			else{
			alDtlData = bean.getDtlRecords();
			}
			HashMap ht = new HashMap();
			if(Integer.parseInt(index)>alDtlData.size())
				return;
			if(site){
				ht = bean.getDtlRecordforBarCode(Integer.parseInt(index));	
			}
			else{
				ht = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
			}
					if(!((String)ht.get("item_unit_cost")).equals("")&&((String)ht.get("item_qty")).equals("0")){
						result = false;
					}
		}else if(validate.equals("TOTAL_QTY")){
			 String dec_allowed_yn				=	request.getParameter("dec_allowed_yn");
			
			double tmp_conv=bean.getConvFactTemp(item_code,bean.getStore_code());
		/*if(tmp_conv==999999999){
			throw new Exception("Multiple");
			}*/
			String tot_item_qty = 	""+(tmp_conv * Double.parseDouble((String)item_qty));
			/**
				* @Name - Suri
				* @Date - 19/01/2010
				* @Inc# - IN015496
				* @Desc - Code added to accept decimal values dynamically.
				* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			   */
				int no_of_decimals=0;
				//if((bean.getAllowDecimalsYN(item_code)).equals("Y"))
				if(dec_allowed_yn.equals("Y")){
					no_of_decimals=bean.getNoOfDecimals();
				}else{
					no_of_decimals=0;
				}
			out.println("document.formStockItemConsumptionListHeader.tot_item_qty.value = '"+bean.setNumber(tot_item_qty,no_of_decimals)+"';");
			result = true;
		}else if(validate.equals("USAGE_TYPE_STATUS")){ //18/09/12
			       usage_type=	(String)request.getParameter("usage_type");
				   //System.out.println("usage_type val=582=>" +usage_type);
			       index	=	(String)request.getParameter("index_");
				   // System.out.println("index val=582=>" +index);
			      HashMap alDtl			=		new HashMap();
				  alDtl = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
				//  System.out.println("stk---else--ht--"+alDtl); 
	              alDtl.put("usage_type",usage_type);	 
		          //System.out.println("stk---else--ht--"+alDtl); 
	              bean.updateDtlRecord(Integer.parseInt(index), alDtl);
			      result = true;
	           }
		//Added for GHL-CRF-0413 starts
				else if(validate.equals("clearTmpBean"))  { 
					//System.err.println("clearTmpBean starts");
					 try{
						 bean.getTempBatchRecords().clear();
						 //bean.getAlTempExpRecords().clear();
					   }
					   catch(Exception exception){
							exception.printStackTrace();
							flag			=	"clearTmpBean";
							result			=	false;
						}
				}
				else if(validate.equals("SET_IN_BEAN"))  { 
					//System.err.println("SET_IN_BEAN starts");
					String doc_srl_no_forbean = request.getParameter("doc_srl_no_forbean");
					String call = request.getParameter("call")==null?"":request.getParameter("call");
					String new_screen_yn = request.getParameter("new_screen_yn")==null?"N":request.getParameter("new_screen_yn");
				//	System.err.println("doc_srl_no_forbean@@@==="+doc_srl_no_forbean);
					int srl_no = Integer.parseInt(doc_srl_no_forbean);
					 try{
						  if(new_screen_yn.equals("Y") && !call.equals("SCAN"))
						 {
                             if(bean.getExpRecordsforBarCode(srl_no)!=null && bean.getExpRecordsforBarCode(srl_no).size()>0){
									 ArrayList alBatchRecords_tmp = new ArrayList();
							         alBatchRecords_tmp = bean.getTempBatchRecords();
									 ArrayList OldExpRecords = new ArrayList();
									 OldExpRecords =  bean.getExpRecordsforBarCode(srl_no);
									 for(int i=0;i<OldExpRecords.size();i++){
									     OldExpRecords.remove(0);
									 }
                                     OldExpRecords.add(alBatchRecords_tmp);
									 bean.setExpRecordsforBarCode( srl_no, alBatchRecords_tmp);
									// System.err.println("After settign current exp records@@==="+bean.getExpRecordsforBarCode()+"alBatchRecords_tmp=="+alBatchRecords_tmp);
							 }else{
								 if(bean.getTempBatchRecords().size()>0){
								     ArrayList alBatchRecords_tmp1 = new ArrayList(bean.getTempBatchRecords());
								//System.err.println("alBatchRecords_tmp1@@@==="+alBatchRecords_tmp1+"srl_no=="+srl_no);
								     bean.setExpRecordsforBarCode(srl_no, alBatchRecords_tmp1);
							}
							 }
						 }else{
							// System.err.println("call@@@==="+call);
							ArrayList OldExpRecords = new ArrayList();
							ArrayList alBatchRecords_tmp = new ArrayList();
							alBatchRecords_tmp = bean.getTempBatchRecords();
						 //	System.err.println("TemBatchRecords:"+bean.getTempBatchRecords());
							//System.err.println("getExpRecordsforBarCode +==="+bean.getExpRecordsforBarCode(srl_no));
							HashMap CurrBatchRecords = new HashMap();
						if(bean.getExpRecordsforBarCode(srl_no)!=null && bean.getExpRecordsforBarCode(srl_no).size()>0){
							OldExpRecords =  bean.getExpRecordsforBarCode(srl_no);
							int pdoc_srl_no = srl_no ;
							int OldExp = OldExpRecords.size();
							//ArrayList batchlist=OldExpRecords;//GHL-SCF-1282 and commented for GHL-ICN-0032
							//System.out.println("Old batch_records :"+batchlist);
							for ( int m1=0; m1 < alBatchRecords_tmp.size(); m1++ ){
							boolean isExist = false;
							CurrBatchRecords =(HashMap)alBatchRecords_tmp.get(m1) ;					
							for ( int m2 = 0 ; m2 < OldExp ; m2++){
							HashMap exp = (HashMap)OldExpRecords.get(m2);
							if (( CurrBatchRecords.get("ITEM_CODE").equals(exp.get("ITEM_CODE")) &&  CurrBatchRecords.get("BATCH_ID").equals(exp.get("BATCH_ID")) &&  CurrBatchRecords.get("EXPIRY_DATE").equals(exp.get("EXPIRY_DATE"))	&& 	CurrBatchRecords.get("BIN_LOCATION_CODE").equals(exp.get("BIN_LOCATION_CODE")) &&  CurrBatchRecords.get("TRADE_ID").equals(exp.get("TRADE_ID")))){
							isExist = true;
							}	
						//	else{//GHL-SCF-1282	 start and commented	GHL-ICN-0032	 
							//	batchlist.remove(m2);
							//System.out.println("After Removed list:"+batchlist);
						//	}//GHL-SCF-1282 end
							}
							//System.err.println("After Removed list   :"+batchlist);
							//bean.setExpRecordsforBarCode( pdoc_srl_no, batchlist);// added for GHL-SCF-1282 and commented	GHL-ICN-0032	 
							if (!isExist){
							System.out.println("check in SalesListDetail.jsp ...CurrBatchRecords.."+CurrBatchRecords);
							OldExpRecords.add(CurrBatchRecords);
							System.out.println("check in SalesListDetail.jsp ...OldExpRecords.."+OldExpRecords);
							//bean.setExpRecordsforBarCode( pdoc_srl_no, OldExpRecords);//added for GHL-SCF-1282 and commented for GHL-ICN-0032	 
							}				
							}					
							bean.setExpRecordsforBarCode( pdoc_srl_no, OldExpRecords); //commanded for GHL-SCF-1282 and uncommented for GHL-ICN-0032	 
						}
						else{
							if(bean.getTempBatchRecords().size()>0){
								ArrayList alBatchRecords_tmp1 = new ArrayList(bean.getTempBatchRecords());
								bean.setExpRecordsforBarCode(srl_no, alBatchRecords_tmp1);
							}
						}
					 }
						         result = true;
					//	System.err.println("setting data"+bean.getTempBatchRecords());
					//	System.err.println("After Setting ExpRecordsforBarCode @@509==="+bean.getExpRecordsforBarCode());
					   }
					   catch(Exception exception){
							exception.printStackTrace();
							flag			=	"SET_IN_BEAN";
							result			=	false;
						}
				}else if(validate.equals("setBeanDetails"))  { //Adding start for TH-KW-CRF-0043
					//System.err.println("setNewScreenDetails starts");
					 try{
						 String temp_item_code=request.getParameter("item_code");
						 String temp_store_code =request.getParameter("store_code");
						 String batch_qty =request.getParameter("batch_qty");
						 String temp_item_qty =request.getParameter("item_qty");
						 String barcode =request.getParameter("barcode")==null?"":request.getParameter("barcode");
						 String temp_conv          =request.getParameter("temp_conv")==null?"1":request.getParameter("temp_conv");
						 String row_no          =request.getParameter("row_no")==null?"":request.getParameter("row_no");
						 String call            =request.getParameter("call")==null?"":request.getParameter("call");
						 String temp_doc_srl_no ="-1";
						 int  temp_doc_srl_no_forbean =-1;
						 int    doc_srl_no_forbean = -1;
						 int    temp_index =-1;
						 String tmpindex ="-1";

						// System.err.println("call@@======="+call);

						 String manufacturer_name="";
						 String bin_location_code ="";
						 String trade_id="";
						 String batch_id ="";
						 String expiry_date_or_receipt_date ="";
						 String available_qty ="";
						 int temp_avil_qty =0;
						 String temp_expired_batch="";
						 String temp_batchsearch="";
						 String dec_allowed_yn="N";
						 String temp_ex_param_days="";
						 int total_checkboxes =0;
						 String temp_checkboxes ="";
						 StUtilities utilbean = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
					     utilbean.setLanguageId(locale);
					     HashMap hmParameters	=	new HashMap();
					     HashMap newExpBatchMap   = new HashMap();
						 ArrayList alBatchRecords = new ArrayList();
						 ArrayList albaArrayList1 = new ArrayList();
						 HashMap selQuantity = new HashMap(); 
						 Hashtable tempHash     =new Hashtable();
						 HashMap selQty =bean2.getSelectedQTY();
						 HashMap selRecord = new HashMap();
						 if(selQty.containsKey(temp_item_code)){
							 if(!call.equals("SCAN")){
							    selQty.remove(temp_item_code);
							 }
						   }
                     if(call.equals("") || call.equals("SCAN")){
					     hmParameters.put("ITEM_CODE",temp_item_code);
				         hmParameters.put("STORE_CODE",temp_store_code);
				         hmParameters.put("TRN_QTY","0");
				         hmParameters.put("TRN_TYPE","CON");
						 if(call.equals("SCAN"))
						 hmParameters.put("BARCODE_ID",barcode);
						 HashMap hmReturn	=	utilbean.getBatches(hmParameters);
					    // System.err.println("hmReturn---->"+hmReturn+"hmParameters@@@==="+hmParameters);
					     alBatchRecords = (ArrayList)hmReturn.get("BATCH_DATA");// new batch searched in current transaction
						// System.err.println("alBatchRecords---->"+alBatchRecords);
						 bean.getTempBatchRecords().clear();
							ArrayList albaArrayList = new ArrayList(alBatchRecords);
							bean.setTempBatchRecords(alBatchRecords);
						 total_checkboxes = alBatchRecords.size();
					if(bean.getDtlRecordsforBarCode().size()>0){
						for(int h =0; h< bean.getDtlRecordsforBarCode().size();h++){
							HashMap hmDtl = new HashMap();
							hmDtl = bean.getDtlRecordforBarCode(h);
							//System.err.println("hmDtl@@==="+hmDtl);
							if(hmDtl.containsValue(item_code)){
								if(call.equals("SCAN")){
								doc_srl_no_forbean = h;
								temp_doc_srl_no_forbean =h;
								temp_doc_srl_no = (String)hmDtl.get("doc_srl_no");
								temp_item_qty =(String)hmDtl.get("item_qty");
                                temp_item_qty = Integer.parseInt(temp_item_qty)+1+"";
							   }else
                                  temp_doc_srl_no_forbean =h;
							//	System.err.println("doc_srl_no_forbean==="+doc_srl_no_forbean+"temp_doc_srl_no==="+temp_doc_srl_no);
							        hmDtl.put("item_qty","0");
									bean.setalDtlRecordsforBarCode(h,hmDtl);
							}
						}
					}
						 
					 }else if(call.equals("batchsearch")){
						 //BatchSearchBean bbean = (BatchSearchBean)getBeanObject("batchSearchBean", "eST.BatchSearchBean", request);
				           //      bbean.setLanguageId(locale);
						   
				                 alBatchRecords = bean2.getSelectedList();
								 if(doc_srl_no_forbean == -1)		{
									for(int h =0;h<alBatchRecords.size();h++){
										HashMap hmBatchRec =(HashMap) alBatchRecords.get(h);
										String val_item = (String)hmBatchRec.get("ITEM_CODE");
										ArrayList alDtl = bean.getDtlRecordsforBarCode();
										HashMap expRec  =bean.getExpRecordsforBarCode();
										HashMap newExpRec = new HashMap();
										//System.err.println("alDtl @@@==="+alDtl);
										for(int j=0;j<alDtl.size();j++)
										{
											HashMap hmDtl =(HashMap) alDtl.get(j);
										//	System.err.println("hmDtl=="+hmDtl);
											if(hmDtl.containsValue(val_item)){
												temp_doc_srl_no_forbean = j;
											     //temp_index =j;
												 //temp_doc_srl_no = (String)hmDtl.get(doc_srl_no);
												 hmDtl.put("item_qty","0");
									             bean.setalDtlRecordsforBarCode(j,hmDtl);
											}
										}
										
									}
								 }
								  
								  selQuantity = bean2.getSelectedQuantity();
								//System.err.println("selQuantity@@@@==="+selQuantity);  
								 //System.err.println("alBatchRecords@@@ old data======"+bean.getTempBatchRecords());
								 //System.err.println("alBatchRecords@@@ new data======"+alBatchRecords);
					             bean.getTempBatchRecords().clear();
								// System.err.println("alBatchRecords@@@ after clear======"+bean.getTempBatchRecords());
							ArrayList albaArrayList = new ArrayList(alBatchRecords);
							bean.setTempBatchRecords(albaArrayList);
                           total_checkboxes = alBatchRecords.size();
					 }
					
		        for(int i=0;i<alBatchRecords.size();i++){
					       newExpBatchMap  = (HashMap)alBatchRecords.get(i);
                           barcode                   = (String)newExpBatchMap.get("BARCODE_ID")==null?"":(String)newExpBatchMap.get("BARCODE_ID");
						   manufacturer_name         = (String)newExpBatchMap.get("MANUFACTURER_NAME")==null?"":(String)newExpBatchMap.get("MANUFACTURER_NAME");
						   bin_location_code         = (String)newExpBatchMap.get("BIN_LOCATION_CODE");
						   trade_id                  = (String)newExpBatchMap.get("TRADE_ID");
						   batch_id                  = (String)newExpBatchMap.get("BATCH_ID");
						   expiry_date_or_receipt_date =(String)newExpBatchMap.get("EXPIRY_DATE");
						   available_qty             = (String)newExpBatchMap.get("AVAIL_QTY");

						   newExpBatchMap.remove("QTY");
						   albaArrayList1.add(newExpBatchMap);
						   bean.setTempBatchRecords(albaArrayList1);
						   if(call.equals("batchsearch")){
							   String curr_key = batch_id+"~"+temp_item_code;
							   //System.err.println("curr_key@@==="+(String)selQuantity.get(curr_key));
							   if(selQuantity.containsKey(curr_key)){	   
                                   batch_qty = (String)selQuantity.get(curr_key);
							   }
							
						   }
						   
				           String sel_key = batch_id+"~"+temp_item_code;
						   System.err.println("sel_key=="+sel_key+"selQty=="+selQty+"temp_item_code=="+temp_item_code);
				          if(selQty.containsKey(temp_item_code)){
							       selRecord =(HashMap)selQty.get(temp_item_code);
								   System.err.println("selRecord==="+selRecord);
							  if(!selRecord.containsKey(sel_key)){
								  
				            	   bean2.setSelectedQTY(sel_key,batch_qty,temp_item_code);
							  }else{
								  String tem_qty = (String)selRecord.get(sel_key);
								  System.err.println("tem_qty@@@=="+tem_qty);
								  if(call.equals("SCAN")){
								     tem_qty =Integer.parseInt(tem_qty)+1+"";
								  }
								  bean2.setSelectedQTY(sel_key,tem_qty,temp_item_code);
							  }
			//System.err.println("selQuantity@@==="+selQuantity+"selQty=="+bean2.getSelectedQTY());
						  }else{
							   bean2.setSelectedQTY(sel_key,batch_qty,temp_item_code);
						  }
						  // out.println("checkNewQuantity(\""+available_qty+"\",\""+temp_item_qty+"\");");
						    temp_checkboxes =Integer.toString(total_checkboxes);
							tmpindex           =Integer.toString(temp_index);
								
						     tempHash.put("barcode_"+i,barcode);
							 tempHash.put("manufacturer_name_"+i,manufacturer_name);
							 tempHash.put("bin_location_code_"+i,bin_location_code);
							 tempHash.put("trade_id_"+i,trade_id);
							 tempHash.put("batch_id_"+i,batch_id);
							 tempHash.put("expiry_date_or_receipt_date_"+i,expiry_date_or_receipt_date);
							 tempHash.put("available_qty_"+i,available_qty);
							 tempHash.put("item_qty_"+i,batch_qty);
							 if(i==0){
							 tempHash.put("doc_srl_no_forbean",doc_srl_no_forbean);
							 tempHash.put("expired_batch",temp_expired_batch);
							 tempHash.put("batchsearch",temp_batchsearch);
							 tempHash.put("dec_allowed_yn",dec_allowed_yn);
							 tempHash.put("tmp_conv",temp_conv);
							 tempHash.put("ex_param_days",temp_ex_param_days);
							 tempHash.put("total_checkboxes",temp_checkboxes);
							 }

				} 
			    bean.setTempHash(tempHash);

			int i=0;

			 out.println("setBeanRecords(\""+temp_doc_srl_no_forbean+"\",\""+call+"\");");
			out.println("newAddToList(\""+row_no+"\",\""+temp_item_code+"\",\""+temp_store_code+"\",\""+temp_item_qty+"\",\""+doc_srl_no_forbean+"\",\""+temp_doc_srl_no+"\",\""+tmpindex+"\",\""+total_checkboxes+"\",\""+call+"\",\""+available_qty+"\");");


					   }
					   catch(Exception exception){
							exception.printStackTrace();
							flag			=	"clearTmpBean";
							result			=	false;
						}
				}else if(validate.equals("DeleteRecords"))  {
					//System.err.println("DeleteRecords@@@inside delete======");
					 String delete_item_code=request.getParameter("item_code");
					 String checked_yn=request.getParameter("checked_yn");
					 HashMap selQty =bean2.getSelectedQTY();
					 if(checked_yn.equals("N") && selQty.containsKey(delete_item_code))
						  selQty.remove(delete_item_code);
					// System.err.println("selQty@@@ in delete==="+selQty);
					 //System.err.println("delete_item_code=="+delete_item_code+"checked_yn==="+checked_yn);
					 //int row_no       = request.getParameter("row_no");
					 String records_to_delete ="";
						for(int h =0; h< bean.getDtlRecordsforBarCode().size();h++){
							HashMap hmDtl = new HashMap();
							hmDtl = bean.getDtlRecordforBarCode(h);
						//	System.err.println("hmDtl@@==="+hmDtl);
							if(hmDtl.containsValue(delete_item_code)){
								if(checked_yn.equals("Y")){
								    records_to_delete += ("N,");
							}else{
								 records_to_delete += ("Y,");
								     hmDtl.put("item_qty","0");
									bean.setalDtlRecordsforBarCode(h,hmDtl);
							}
						 }else{
							 records_to_delete += ("N,");
						   }
						}
						  if(bean.getDtlRecordsforBarCode().size()==0)
							  records_to_delete += ("N,");
						System.err.println("records_to_delete@@@==="+records_to_delete);
						bean.setRecords_to_delete(records_to_delete);
						
				}else if(validate.equals("SaveRemarks"))  {
					//System.err.println("SaveRemarks @@@inside ======");
					 String rem_item_code=request.getParameter("item_code");
					 String temp_remarks=request.getParameter("remarks");
					 //System.err.println("rem_item_code@@===="+rem_item_code+"remarks=="+remarks);
					 bean.setdtlRemarks(rem_item_code,temp_remarks);
					 	
				}//Adding end for TH-KW-CRF-0043
		}catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	//	exception.printStackTrace();

	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
 <%
putObjectInBean("stockItemConsumptionBean",bean,request);
%>
