<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
09/02/2017		IN061112			Badmavathi B					        GHL-CRF-0413 - Barcode search
30/12/2020      TFSid:11896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
10/02/2021		TFS-14260		B Haribabu 			10/02/2021				   MOHE-SCF-0079
---------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	IssueReturnBean bean = (IssueReturnBean)getBeanObject("issueReturnBean","eST.IssueReturnBean", request ) ;   
	bean.setLanguageId(locale);

	// bean.clear();
	// StDueHeaderBean beanHdr = (StDueHeaderBean) mh.getBeanObject( "stDueHeaderBean", request,  "eST.Common.StDueHeaderBean" );
	// bean.setProductTransferHeaderBean(beanHdr);

	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String validate		=	request.getParameter("validate");

	String doc_srl_no 	   = request.getParameter("doc_srl_no");
	String item_code 	   = request.getParameter("item_code");
	String item_desc 	   = request.getParameter("item_desc");
	String uom_code 	   = request.getParameter("uom_code");
	String uom_desc 	   = request.getParameter("uom_desc");
	String uom_desc_base   = request.getParameter("uom_desc_base");
	String item_qty 	   = request.getParameter("item_qty");
	String item_unit_cost  = request.getParameter("item_unit_cost");
	String item_unit_cost_org  = request.getParameter("item_unit_cost_org");
	String item_cost_value = request.getParameter("item_cost_value");
	String stock_available = request.getParameter("stock_available");
	String remarks		   = bean.checkForNull(request.getParameter("remarks"),"");
	String remarks_code		   = bean.checkForNull(request.getParameter("remarks_code"),"");
	String fm_store_code   = request.getParameter("fm_store_code");	
	String to_store_code   = request.getParameter("to_store_code");	
	String batch_records   = request.getParameter("batch_records");	
	String frm_conv_fact	="";
	String to_conv_fact		="";
	//String fm_bin_location_code  = request.getParameter("fm_bin_location_code");	
	//String to_bin_location_code  = request.getParameter("to_bin_location_code");	
	String index		   = request.getParameter("index");	
	String message			=	"";
	String flag				=	"";
	String facility_id=(String)session.getValue("facility_id");
    String Max_Returnable_Qty =(String)request.getParameter("Max_Returnable_Qty");	
    String stock_uom =(String)request.getParameter("stock_uom");	
	//stock_available = stock_available.trim();
	 String from_multiples			=	bean.checkForNull(request.getParameter("from_multiples"),"1");
    String to_multiples				=	bean.checkForNull(request.getParameter("to_multiples"),"1");
    String batch_multiples			=	bean.checkForNull(request.getParameter("batch_multiples"),"1");
    String issue_uom_multiples		=	bean.checkForNull(request.getParameter("issue_uom_multiples"),"1");

	HashMap hashmapDtl = new HashMap();
	HashMap hmminmaxlist=new HashMap();

	boolean	result	  =	 false;

	try {

	//	String label					=	request.getParameter("label");

		if(validate.equals("GET_STATUS")) {

            item_code       =   request.getParameter("item_code");
			fm_store_code	=	request.getParameter("fm_store_code");
            to_store_code	=	request.getParameter("to_store_code");
			double tmp_conv=bean.getConvFactTemp(item_code,fm_store_code);
			Double baseItemUnitCost=bean.getBaseUnitCost(item_code);//Added against inc#50521 to display base unit cost
			double final_unit_cost = baseItemUnitCost*tmp_conv;
			out.println("document.formIssueReturnListHeader.item_unit_cost.value = '"+final_unit_cost+"';");//Added against inc#50521 to display base unit cost
			out.println("document.formIssueReturnListHeader.item_unit_cost_org.value = '"+final_unit_cost+"';");//Added against inc#50521 to display base unit cost
			
			String phy_inv_id = "";
            try {
				String return_uom=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ISSUE_UOM_DEFAULT"),new String[]{item_code,fm_store_code}).get("DEF_ISSUE_UOM");
				out.println("document.formIssueReturnListHeader.return_uom_code.value = '"+return_uom+"';");//Added against inc#50521 to display base unit cost
            	//Added by suresh.r against #48289 on 01-04-2014 beg
            	String[] stNames={"item_code"};
				String[] stValues={item_code};
				if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1)){
					throw new Exception("RECORD_ALREADY_EXISTS");
				}
				//Added by suresh.r against #48289 on 01-04-2014 end
				result = bean.isPhysicalInventoryProcessStartedForStore(item_code,fm_store_code,to_store_code);
				if(result)
				{
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,fm_store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,to_store_code}).get("PHY_INV_ID");
					out.println("document.formIssueReturnListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
			//out.println("clearListItems('document.formIssueReturnListHeader.Max_Returnable_Qty'); ");
			ArrayList alBatchDetail= bean.getBatchDetails(item_code,fm_store_code);
            String stStockItem_YN= (String)alBatchDetail.get(5);
// commmented to enable non stock returns
/*			  if(stStockItem_YN.equals("N"))
			  {
				out.println( "stock_item_check();" ) ;      
			  }
			  else*/
			  {   
				ArrayList alPendingQty=new ArrayList();
				String alMaxReturnableQty = "";
				double stPendingQty = 0.0;
				
				if(bean.getIssueRetBasedOn().equals("D")){
				alPendingQty=bean.calculatePendingQuantity(facility_id,item_code,fm_store_code,to_store_code,stStockItem_YN.equals("Y"));
				 stPendingQty=Double.parseDouble(bean.checkForNull((String)alPendingQty.get(0),"0"))/tmp_conv ;
				}else{
				String facility_id_new = (String)bean.fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE=?",new String[]{to_store_code}).get("FACILITY_ID"); //modified for TFS-14260

				alMaxReturnableQty = bean.getMaxReturnableQty(facility_id_new, to_store_code, fm_store_code,item_code,bean.getDoc_no()); //Added by Sakti against inc no:50521 on 28/08/2014 to take max return qty from sum of avail_qty from batch search query //modified for TFS-14260
				 stPendingQty=Double.parseDouble(bean.checkForNull(alMaxReturnableQty,"0"))/tmp_conv ; //Added by Sakti against inc no:50521 on 28/08/2014 to take max return qty from sum of avail_qty from batch search query
				}
				if(stPendingQty==0)
				{
				  out.println( "noPendingQty();" ) ;      
				}
				else
				{
				  out.println( "showPendingQty(\"" + stPendingQty + "\" );" ) ;      
				}
			 }

		 }catch(Exception exception) {
				exception.printStackTrace();
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
					throw exception;
				}
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				throw new Exception("ITEM_STORE_NOT_FOUND");
		 }
		 result	= true;
	  }else if(validate.equals("setToConv")){
			item_code       =   (String)request.getParameter("item_code");
			to_store_code	=	(String)request.getParameter("to_store_code");
			fm_store_code	=	(String)request.getParameter("fm_store_code");
			
			double tmp_conv=bean.getConvFactTemp(item_code,to_store_code);
			bean.setTempConvFact(tmp_conv);
		     double frm_tmp_conv=bean.getConvFactTemp(item_code,fm_store_code);
		
			bean.setFromTempConvFact(frm_tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
			out.println("setFromTempConvFactor('"+frm_tmp_conv+"');");
		}else if(validate.equals("ADD_TO_LIST")){

	  	    flag="";
			
			to_conv_fact				=	(String)request.getParameter("to_conv_fact");  
			frm_conv_fact				=	(String)request.getParameter("frm_conv_fact"); 
	  //Added against GHL-CRF-0413.3 starts
			String doc_srl_no_forbean = (String) request.getParameter("doc_srl_no_forbean");
			String site = (String) request.getParameter("site");
	  //Added against GHL-CRF-0413.3 ends
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			//hashmapDtl.put("stock_item_yn",		stock_item_yn	);
			hashmapDtl.put("item_desc",			item_desc		);
			//hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_desc_base",			uom_desc_base		); //Added against inc#50521 to store base UOM
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("uom_code",			uom_code		);
			hashmapDtl.put("item_qty",			item_qty		);
			hashmapDtl.put("Max_Returnable_Qty", Max_Returnable_Qty ) ; 
			hashmapDtl.put("item_unit_cost",	item_unit_cost	);
			hashmapDtl.put("item_cost_value",	item_cost_value	);
			hashmapDtl.put("stock_available",	stock_available	);
			hashmapDtl.put("remarks",			remarks			);
			hashmapDtl.put("remarks_code",		remarks_code	);
			hashmapDtl.put("to_conv_fact",		to_conv_fact	);
			hashmapDtl.put("frm_conv_fact",		frm_conv_fact	);
			hashmapDtl.put("batch_records",		batch_records	);
			hashmapDtl.put("stock_uom",			stock_uom	);
			hashmapDtl.put("from_multiples",	from_multiples);
			hashmapDtl.put("to_multiples",		to_multiples);
			hashmapDtl.put("batch_multiples",	batch_multiples);
			hashmapDtl.put("issue_uom_multiples",	issue_uom_multiples);
			hashmapDtl.put("item_unit_cost_org",	item_unit_cost_org); 
		
			String[] stNames={"item_code"};
			String[] stValues={item_code};

//Added against GHL-CRF-0413.3 starts
if(site.equals("true")){
	hashmapDtl.put("seq_no",	(String)request.getParameter("seq_no")); 
	int doc_srl_no1 = Integer.parseInt(doc_srl_no_forbean);
	doc_srl_no1++;
	String doc_srl_no2 = ""+doc_srl_no1;
	hashmapDtl.put("doc_srl_no",	doc_srl_no2);
	bean.updateDtlRecord(Integer.parseInt(doc_srl_no_forbean), hashmapDtl);
	bean.updateExpRecords(Integer.parseInt(doc_srl_no_forbean), htFormValues);
}
else{
			if(bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
//Added against GHL-CRF-0413.3 ends
			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);
}
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

			//double lTotal_qty	=	Double.parseDouble(item_qty);

			//double dItem_cost_value=bean.dAvg_unit_cost*lTotal_qty;
			//double dItem_cost_value=(Double.parseDouble(item_unit_cost_org)*lTotal_qty); //Added to correct pass unit cost  against inc#50521
			/*dItem_cost_value*=1000;
			dItem_cost_value=Math.round(dItem_cost_value);
			dItem_cost_value/=1000;*/
			/**
			 * @Name - Priya
			 * @Date - 02/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and round up  item_cost_value,item_unit_cost
			 */
				int noOfDecimalsForCost=Integer.parseInt((String) bean.getNoOfDecimalsCost());	

			
			//hashmapDtl.put("item_cost_value",	bean.setNumber(""+dItem_cost_value,noOfDecimalsForCost));
			//hashmapDtl.put("item_unit_cost",	bean.setNumber(""+bean.dAvg_unit_cost,noOfDecimalsForCost)); 
			hashmapDtl.put("item_unit_cost",	bean.setNumber(item_unit_cost,noOfDecimalsForCost)); 
			


			result			=	true;

        
	   }
	  else if(validate.equals("CHECK_FINALIZE_ALLOWED")) {
		    String store_code = request.getParameter("fm_store_code");
			String stFinalize_allowed	=	bean.getFinalize_allowed_yn(store_code);
			out.println("setFinalize_allowed('"+stFinalize_allowed+"');");
			result=true;
		}

		 else if (validate.equals("printOnlineDoc")){
			try{
			
			//String pdocno=bean.getPrintDocNo();
			
			//bean.doOnlineReportPrinting(pdocno);	
			ArrayList doc_no=bean.getPrintDocNo();
			String pdocno = "";
			for(int i=0;i<doc_no.size();i++){
				pdocno=(String)doc_no.get(i);
				//bean.doOnlineReportPrinting(pdocno);
				bean.doOnlineReportPrinting(pdocno,request,response); //Added By Sakti Sankar on 06/03/2013 against Inc#
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}
		else if (validate.equals("MIN_MAX_STATUS")){
			try{
				String[]  minmaxarg = {""+bean.getConvFactTemp(item_code,fm_store_code),item_code, fm_store_code};
				String[] stParameters = {item_code, fm_store_code, "0", "N", "", "N", to_store_code};
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				String avail_stock = ""+Double.parseDouble(bean.checkForNull((String)hmStockAvailabilityStatus.get("available_stock"),"0"))/bean.getConvFactTemp(item_code,fm_store_code);
				HashMap hmminmax = new HashMap();
				hmminmax =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);
				//out.println("document.getElementById("lb_frm_store_qty_on_hand").innerHTML = '"+bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"&nbsp;")+"';");
/*				out.println("document.getElementById("lb_frm_store_qty_on_hand").innerHTML = '"+bean.checkForNull(avail_stock,"&nbsp;")+"';");
				out.println("document.getElementById("lb_frm_store_min_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_frm_store_max_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_frm_store_reorder_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_frm_store_uom_desc").innerHTML = '"+bean.checkForNull((String)bean.getShortDesc(item_code,fm_store_code),"&nbsp;")+"';");
*/
				//out.println("document.getElementById("frm_store_qty_on_hand").value = '"+bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"0")+"';");
				out.println("document.getElementById('frm_store_qty_on_hand').value = '"+bean.checkForNull(avail_stock,"0")+"';");
				out.println("document.getElementById('frm_store_min_stk_level').value = '"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('frm_store_max_stk_level').value = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('frm_store_reorder_level').value = '"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"")+"';");
				out.println("document.getElementById('frm_store_uom_desc').value = '"+bean.checkForNull((String)bean.getShortDesc(item_code,fm_store_code),"&nbsp;")+"';");
				
				String[]  minmaxarg1 = {""+bean.getConvFactTemp(item_code,to_store_code),item_code, to_store_code};
				HashMap hmminmax1 = new HashMap();
				hmminmax1 =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg1);

				//out.println("document.getElementById("lb_to_store_qty_on_hand").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("QTY_ON_HAND"),"&nbsp;")+"';");
/*				out.println("document.getElementById("lb_to_store_qty_on_hand").innerHTML = '"+bean.checkForNull((String)hmStockAvailabilityStatus.get("to_qty_on_hand"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_min_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("MIN_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_max_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("MAX_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_reorder_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("REORDER_LEVEL"),"&nbsp;")+"';");
				out.println("document.getElementById("lb_to_store_uom_desc").innerHTML = '"+bean.checkForNull((String)bean.getShortDesc(item_code,to_store_code),"&nbsp;")+"';");
*/			
				//out.println("document.getElementById("to_store_qty_on_hand").value = '"+bean.checkForNull((String)hmminmax1.get("QTY_ON_HAND"),"0")+"';");
				out.println("document.getElementById('to_store_qty_on_hand').value = '"+bean.checkForNull((String)hmStockAvailabilityStatus.get("to_qty_on_hand"),"0")+"';");
				out.println("document.getElementById('to_store_min_stk_level').value = '"+bean.checkForNull((String)hmminmax1.get("MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('to_store_max_stk_level').value = '"+bean.checkForNull((String)hmminmax1.get("MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('to_store_reorder_level').value = '"+bean.checkForNull((String)hmminmax1.get("REORDER_LEVEL"),"")+"';");
				out.println("document.getElementById('to_store_uom_desc').value = '"+bean.checkForNull((String)bean.getShortDesc(item_code,to_store_code),"&nbsp;")+"';");

			result =  true;
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
		}else if (validate.equals("POPULATE_TO_STORES")){
			HashMap record =  new HashMap();
			String request_by_store=request.getParameter("request_by_store");
			bean.setFrom_store_code(request_by_store);
			//To populate the requisition_on_stores
			out.println("clearListItems('formIssueReturnQueryCriteria.to_store'); ");
			ArrayList req_by_stores = bean.getOnStoresIssueReturn(bean.getFrom_store_code());
			for(int i=0; i< req_by_stores.size(); i++) {
				record = (java.util.HashMap)req_by_stores.get(i);
				out.println("addListItem(\"formIssueReturnQueryCriteria.to_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}else if (validate.equals("CLEAR_DATA")){
			bean.clearAlDtlRecords();
			result = true;
		}else if (validate.equals("LOAD_DETAILS")){
			try{
				String issue_doc_type_code	=	(String)request.getParameter("issue_doc_type_code");
				String doc_no				=	(String)request.getParameter("doc_no");
				String to_store_code_temp = (String)request.getParameter("to_store_code");
				String seq_no = (String)request.getParameter("seq_no");
				String facility_id_frm = (String)request.getParameter("facility_id");
				bean.setTo_store_code(to_store_code_temp);
				bean.setFrom_store_code(fm_store_code);
				String phy_inv_id = "";
				Boolean result1 = false;
				bean.setIssueDocTypeCode(issue_doc_type_code);
				bean.setIssueDocNo(doc_no);
				bean.loadDetailPage(doc_no,issue_doc_type_code,seq_no,facility_id_frm);
				result = true;
				ArrayList alDetailData=(ArrayList)bean.getDtlRecords();
				//HashMap data = new HashMap();
				HashMap data1 = new HashMap();
	 			
				for(int i=0;i<alDetailData.size();i++){
					data1 = (HashMap)alDetailData.get(i);
					result1 = bean.isPhysicalInventoryProcessStartedForStore((String)data1.get("item_code"),fm_store_code,to_store_code);
					if(result1){
							phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)data1.get("item_code"),fm_store_code}).get("PHY_INV_ID");
						if(bean.checkForNull(phy_inv_id,"").equals(""))
							phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)data1.get("item_code"),to_store_code}).get("PHY_INV_ID");
						out.println("dispMess('"+phy_inv_id+"');");
							//out.println("parent.frames[2].frameSalesReturnListHeader.document.formSalesReturnListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					}
				}
			}catch(Exception e){
				if (e.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					result = false;
					throw e;
				}
			}
		}else if(validate.equals("CONV_CALCULATE")){
			item_code       =   (String)request.getParameter("item_code");
			String retto_store_code	=	(String)request.getParameter("to_store_code");
			String retfm_store_code	=	(String)request.getParameter("fm_store_code");
			String return_uom_code	=	(String)request.getParameter("return_uom_code");
			
			
			HashMap conv_factors	=	(HashMap)bean.getConvFactTemp(item_code,retfm_store_code,retto_store_code,return_uom_code);
				out.println("setMultiples('"+(String)conv_factors.get("FROM_STORE_MULTIPLES")+"','"+(String)conv_factors.get("TO_STORE_MULTIPLES")+"','"+(String)conv_factors.get("BATCH_QTY_MULTIPLES")+"','"+(String)conv_factors.get("ISSUE_UOM_MULTIPLES")+"');");
			result = true;
		}
		//Added for GHL-CRF-0413 starts
		else if(validate.equals("clearTmpBean"))  { 
			System.err.println("clearTmpBean starts");
			 try{
				 bean.getTempBatchRecords().clear();
				 bean.getAlTempExpRecords().clear();
			   }
			   catch(Exception exception){
					exception.printStackTrace();
					flag			=	"clearTmpBean";
					result			=	false;
				}
		}
		else if(validate.equals("HEADER_DETAILS")){
			System.err.println("HEADER_DETAILS starts");
			String hdr_barcode = request.getParameter("bar_code");
			String hdr_itemcode = request.getParameter("item_code");
			result = false;
			try{
				ArrayList alExpBarcode = bean.getDtlRecords();
				System.out.println("bean dtl"+alExpBarcode.size());
				for(int y =0;y< alExpBarcode.size();y++){
					HashMap hmPerRecord = new HashMap();
					hmPerRecord = bean.getDtlRecord(y);
					  if(hmPerRecord.containsValue(hdr_itemcode)){
						  if(hmPerRecord.containsKey("Max_Returnable_Qty")){
						  String Max_Return_qty = (String)hmPerRecord.get("Max_Returnable_Qty");
				    		  String  hdr_uom_desc = (String)hmPerRecord.get("stock_uom");//Modified for TFS id: 11896
						  String hdr_uom_desc_base = (String)hmPerRecord.get("uom_desc_base");
						  String hdr_item_unit_cost = (String)hmPerRecord.get("item_unit_cost");
						  String hdr_item_cost_value = (String)hmPerRecord.get("item_cost_value");
						  String seq_no = (String)hmPerRecord.get("seq_no");
						  out.println("document.getElementById('pending_qty').innerHTML = '<B>"+Max_Return_qty+"</B>';");
						out.println("document.getElementById('Max_Returnable_Qty').value = '"+Max_Return_qty+"';");
						out.println("document.getElementById('id_uom').innerHTML = '<B>"+hdr_uom_desc+"</B>';");
						out.println("document.getElementById('id_uom_base').innerHTML = '<B>"+hdr_uom_desc_base+"</B>';");
						out.println("document.getElementById('item_unit_cost_org').value = '"+hdr_item_unit_cost+"';");
						out.println("document.getElementById('item_unit_cost').value = '"+hdr_item_unit_cost+"';");
						out.println("document.getElementById('seq_no').value = '"+seq_no+"';");
						result = true;
						  }
					  }
				}
			} catch(Exception exception){
				exception.printStackTrace();
				flag			=	"HEADER_DETAILS";
				result			=	false;
			}
		}
		else if(validate.equals("BARCODECHECK_SAMEITEM"))  {
			System.err.println("BARCODECHECK_SAMEITEM starts");
			String valid_barcode = request.getParameter("barcode");
			String valid_store_code = request.getParameter("store_code");
			String valid_item_code = request.getParameter("valid_item_code");
			result = false;
			try{
				HashMap newBatchId = null;
 				 newBatchId=	(HashMap)bean.fetchRecord("select batch_id,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, BIN_LOCATION_CODE  from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code});
				String mode = bean.getMode();
				if(mode.equals("1")){
				HashMap hmExpRecords = new HashMap();
				hmExpRecords = bean.getExpRecords();
				for(int i =0;i< hmExpRecords.size(); i++)
				{
					String j = ""+i;
					ArrayList alExpList = (ArrayList)hmExpRecords.get(j);
					 for(int k=0; k< alExpList.size() ; k++ ){
						 HashMap hmPerBatch = (HashMap)alExpList.get(k);
						 if((hmPerBatch.containsValue(newBatchId.get("BATCH_ID"))) && (hmPerBatch.containsValue(newBatchId.get("EXPIRY_DATE_OR_RECEIPT_DATE")))&& (hmPerBatch.containsValue(newBatchId.get("BIN_LOCATION_CODE")))){
							 result = true;
						 }
					 }
				}
				}else{
					ArrayList alExpList = (ArrayList)bean.getAlTempExpRecords();
					 for(int k=0; k< alExpList.size() ; k++ ){
						 HashMap hmPerBatch = (HashMap)alExpList.get(k);
						 if((hmPerBatch.containsValue(newBatchId.get("BATCH_ID"))) && (hmPerBatch.containsValue(newBatchId.get("EXPIRY_DATE_OR_RECEIPT_DATE")))&& (hmPerBatch.containsValue(newBatchId.get("BIN_LOCATION_CODE")))){
							 result = true;
						 }
					 }
				}
			} catch(Exception exception){
				exception.printStackTrace();
				flag			=	"BARCODECHECK_SAMEITEM";
				result			=	false;
			}
		}
		else if(validate.equals("VALIDATE_RET"))  { 
			System.err.println("VALIDATE_RET starts");
			String valid_barcode = request.getParameter("barcode");
			String valid_store_code = request.getParameter("store_code");
			String valid_to_Store = request.getParameter("toStore");
			String seq_no = "";
			result = false;
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
			String newItemCode = "";//Moved here from down for MMS-DM-CRF-0174.6
			String batchId_2d = "";
			ArrayList barcode2DDetails =new ArrayList();
			HashMap newBatchId = null;
			try{
					boolean res = false;
					if(barcode_2d_applicable_yn.equals("Y")){//Adding start for MMS-DM-CRF-0174.6
						  barcode2DDetails = bean.get2DBarcodeBacthes(valid_store_code,valid_barcode);
						  if(barcode2DDetails.size()>0){
							  newBatchId =(HashMap)barcode2DDetails.get(0);
                              newItemCode = (String)newBatchId.get("ITEM_CODE");
							  //batchId_2d  = (String)batch2D.get("ITEM_CODE");
                                 
						  }						  
									   
					}else{//Adding end for MMS-DM-CRF-0174.6
					   newItemCode =bean.checkForNull((String)	bean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code}).get("ITEM_CODE"),"");
					}
					System.err.println("newItemCode new for 2DBarcode===="+newItemCode);
					 if(!newItemCode.equals(""))
					 {
					 //Added for TFS id: 11896 start
						 double tmp_conv=bean.getConvFactTemp(newItemCode,valid_store_code);

							out.println("setConvFactor(\""+tmp_conv+"\");");
							//Added for TFS id: 11896 end
					if(barcode_2d_applicable_yn.equals("N")){
					  newBatchId=	(HashMap)bean.fetchRecord("select batch_id,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE, BIN_LOCATION_CODE  from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code});//EXPIRY_DATE_OR_RECEIPT_DATE to EXPIRY_DATE  for MMS-DM-CRF-0174.6
					}
					//System.err.println("newBatchId@@==="+newBatchId);
					  HashMap hmExpBarcode = bean.getExpRecords();
					  for(int b=0;b< hmExpBarcode.size();b++){
						   ArrayList alExp = new ArrayList();
						   String j = ""+b;
						   alExp = (ArrayList)hmExpBarcode.get(j);
						   for(int c=0;c<alExp.size();c++)
						   {
							   HashMap hmExp = new HashMap();
							   hmExp = (HashMap)alExp.get(c);
		 					   if(hmExp.containsValue(newItemCode)){
								 seq_no = (String)hmExp.get("SEQ_NO");
								 res = true;
						   }
						  }
					   }
					  if(res){
						  ArrayList alExpList = bean.getBatchExpRecords(seq_no,valid_store_code,valid_to_Store,newItemCode,"RET");
						  HashMap hmExpMap = new HashMap();
						  for (int k = 0 ; k< alExpList.size(); k++){
						  hmExpMap =(HashMap) alExpList.get(k); 
						   if((hmExpMap.containsValue(newBatchId.get("BATCH_ID"))) && (hmExpMap.containsValue(newBatchId.get("EXPIRY_DATE")))&& (hmExpMap.containsValue(newBatchId.get("BIN_LOCATION_CODE")))){//EXPIRY_DATE_OR_RECEIPT_DATE to EXPIRY_DATE  for MMS-DM-CRF-0174.6
							  result = true;
						   	}
						  }
					 }
					  	if(!result){
						  message ="BARCODE_NOT_FOUND_ISS_DOC";
						  throw new Exception("BARCODE_NOT_FOUND_ISS_DOC");//Added for GHL-CRF-0413
				  }
				}else{
					throw new Exception("ITEM_STORE_NOT_FOUND1");//Added for GHL-CRF-0413
				  }
			}
		catch(Exception exception){
			exception.printStackTrace();
			flag			=	"VALIDATE_RET";
			result			=	false;
		}
	}
		else if(validate.equals("VALIDATE_RET_ITEMS")){
		try{
        	   	String barcode       =   request.getParameter("barcode");
			           fm_store_code	=	request.getParameter("fm_store_code");
            	       to_store_code	=	request.getParameter("to_store_code");
				 String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
				 if(barcode_2d_applicable_yn.equals("Y")){//Added if else condition for MMS-DM-CRF-0174.6
                       item_code =bean.get2DBarcodeItem(to_store_code,barcode);
				 }else{
		           item_code = bean.checkForNull((String)	bean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{barcode,fm_store_code}).get("ITEM_CODE"),"");
				 }
		        if(!item_code.equals("")){
	            	String val_item_desc = bean.checkForNull((String)	bean.fetchRecord("select SHORT_DESC from mm_item where item_code= ?",new String[]{item_code}).get("SHORT_DESC"),"");
	            out.println("document.formIssueReturnListHeader.item_desc.value = '"+val_item_desc+"';");
	            result = true;
					}
		        else
		        	throw new Exception("ITEM_STORE_NOT_FOUND1");//Added for GHL-CRF-0413
				}
	catch(Exception exception){
		exception.printStackTrace();
		flag			=	"VALIDATE_RET_ITEMS";
		result			=	false;
	}
}
	 else if(validate.equals("SET_IN_BEAN_RET"))  { 
		String doc_srl_no_forbean = request.getParameter("doc_srl_no_forbean");
		String bar_code = request.getParameter("barcode");
		String item_code1 = request.getParameter("item_code");
		int srl_no = Integer.parseInt(doc_srl_no_forbean);
		System.err.println("SET_IN_BEAN_RET starts"+srl_no);
		try{
			ArrayList OldExpRecords = new ArrayList();
			ArrayList alBatchRecords_tmp = new ArrayList();
			ArrayList alBatchRecords_tmp1 = new ArrayList(bean.getTempBatchRecords());
			bean.setExpRecords(srl_no, alBatchRecords_tmp1);
			out.println("calHeaderDetails('"+bar_code+"','"+item_code1+"');");
		   }
		   catch(Exception exception){
			exception.printStackTrace();
			flag			=	"SET_IN_BEAN_RET";
			result			=	false;
		}
	} 
	//Added for GHL-CRF-0413  ends
	}catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("issueReturnBean",bean,request);
%>
