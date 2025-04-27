
 <%
/*
---------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------------------------
08/10/2018       68642          B. Haribabu                                    TTM-SCF-0198
02/12/2019       71868          Haribabu                                       GHL-SCF-1471
-----------------------------------------------------------------------------------------------------------------------------
*/
%> 

 <%@page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<%

	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	if(bean_id == null)
		bean_id = (String)hash.get ("bean_id");

	if(bean_name == null)
		bean_name = (String)hash.get ("bean_name");
	String message = "";
	String flag = ""; 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			= (String)session.getAttribute("LOCALE");
	
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	AuthorizeAtIssueStoreBean bean = (AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	System.out.println("functionType = > "+functionType);
	String itemCd =  request.getParameter("item_code");//MO-CRF-20173
	
	switch (functionType) {
	case 1:
		{
				String item_code =  (String) hash.get("item_code");
				String editing =  (String) hash.get("editing");
			
			

				java.util.HashMap addResult = new java.util.HashMap();
				addResult.put("result","false");
				addResult.put("message","");
				if (editing.equals("2")) {
					addResult = bean.updateItemDetailRecord(hash);
				}
				else if (editing.equals("1") && bean.hasRecord(item_code)) {
					addResult.put("message","ITEM_CODE_ALREADY_EXIST");
				}
				else{
					addResult  = bean.addItemDetailRecord(hash);
				}
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}
		break;
	case 2:
		{
				bean.setRemarks((String)hash.get("remarks"));
				bean.setRemarks_code((String)hash.get("remarks_code_1")); //Added by Rabbani #Inc no:33352 on 18/06/12
		}
		break;
	case 3:
		{
		try
			{	// Load All details
			java.util.HashMap detail = bean.getItemDetails(hash);
			String item_code =  (String) hash.get("item_code");
		
			if (((Boolean)detail.get("result")).booleanValue()) {
				String[] stParameters = {item_code, (String)hash.get("request_on_store_code"), "0", "N", "", "N", (String)hash.get("request_by_store_code") };
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
/*				out.println("document.getElementById('lb_req_by_qty_on_hand').innerHTML = '"+bean.checkForNull((String)hmStockAvailabilityStatus.get("to_qty_on_hand"),"0")+"';");
				//out.println("document.getElementById('lb_req_by_qty_on_hand').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_BY_QTY_ON_HAND"),"0")+"';");
				out.println("document.getElementById('lb_req_by_min_stk_level').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_BY_MIN_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById('lb_req_by_max_stk_level').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_BY_MAX_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById('lb_req_by_reorder_level').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_BY_REORDER_LEVEL"),"&nbsp;")+"';");
				out.println("document.getElementById('lb_req_by_store_uom_desc').innerHTML = '"+bean.checkForNull((String)bean.getShortDesc((String)hash.get("item_code"),(String)hash.get("request_by_store_code")),"&nbsp;")+"';");
*/
				String req_on_qty_on_hand = ""+Double.parseDouble(bean.checkForNull((String)hmStockAvailabilityStatus.get("available_stock"),"0"))/(bean.getConvFactTemp((String)hash.get("item_code"),(String)hash.get("request_on_store_code")));
/*				out.println("document.getElementById('lb_req_on_qty_on_hand').innerHTML = '"+bean.checkForNull(req_on_qty_on_hand,"0")+"';");
				//out.println("document.getElementById('lb_req_on_qty_on_hand').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_ON_QTY_ON_HAND"),"0")+"';");
				out.println("document.getElementById('lb_req_on_min_stk_level').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_ON_MIN_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById('lb_req_on_max_stk_level').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_ON_MAX_STK_QTY"),"&nbsp;")+"';");
				out.println("document.getElementById('lb_req_on_reorder_level').innerHTML = '"+bean.checkForNull((String)detail.get("REQ_ON_REORDER_LEVEL"),"&nbsp;")+"';");
				out.println("document.getElementById('lb_req_on_store_uom_desc').innerHTML = '"+bean.checkForNull((String)bean.getShortDesc((String)hash.get("item_code"),(String)hash.get("request_on_store_code")),"&nbsp;")+"';");
*/
				out.println("document.getElementById('req_by_qty_on_hand').value = '"+bean.checkForNull((String)hmStockAvailabilityStatus.get("to_qty_on_hand"),"0")+"';");
				//out.println("document.getElementById('req_by_qty_on_hand').value = '"+bean.checkForNull((String)detail.get("REQ_BY_QTY_ON_HAND"),"0")+"';");
				out.println("document.getElementById('req_by_min_stk_level').value = '"+bean.checkForNull((String)detail.get("REQ_BY_MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('req_by_max_stk_level').value = '"+bean.checkForNull((String)detail.get("REQ_BY_MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('req_by_reorder_level').value = '"+bean.checkForNull((String)detail.get("REQ_BY_REORDER_LEVEL"),"")+"';");
				out.println("document.getElementById('request_by_store_uom_desc').value = '"+bean.checkForNull((String)bean.getShortDesc((String)hash.get("item_code"),(String)hash.get("request_by_store_code")),"&nbsp;")+"';");
			
				out.println("document.getElementById('req_on_qty_on_hand').value = '"+bean.checkForNull(req_on_qty_on_hand,"0")+"';");
				//out.println("document.getElementById("req_on_qty_on_hand").value = '"+bean.checkForNull((String)detail.get("REQ_ON_QTY_ON_HAND"),"0")+"';");
				out.println("document.getElementById('req_on_min_stk_level').value = '"+bean.checkForNull((String)detail.get("REQ_ON_MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('req_on_max_stk_level').value = '"+bean.checkForNull((String)detail.get("REQ_ON_MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('req_on_reorder_level').value = '"+bean.checkForNull((String)detail.get("REQ_ON_REORDER_LEVEL"),"")+"';");
				out.println("document.getElementById('request_on_store_uom_desc').value = '"+bean.checkForNull((String)bean.getShortDesc((String)hash.get("item_code"),(String)hash.get("request_on_store_code")),"&nbsp;")+"';");


				out.println("document.getElementById('qty_on_store').value = '"+bean.checkForNull(req_on_qty_on_hand,"0")+"';");
				out.println("document.getElementById('qty_by_store').value = '"+bean.checkForNull((String)hmStockAvailabilityStatus.get("to_qty_on_hand"),"0")+"';");
				out.println("document.getElementById('ytd_value').innerHTML = '"+bean.checkForNull((String)bean.getYTTDIssueQty(item_code))+"';");
				//out.println("document.getElementById("req_item_qty").innerHTML = '&nbsp;'");
				out.println("document.getElementById('pending_item_qty').innerHTML = '&nbsp;'");
				out.println("document.getElementById('curr_pack_size').innerHTML = '"+bean.checkForNull((String)detail.get("CURR_PACK_SIZE"),"&nbsp;")+"';");
			}
			else {
			}
			out.println("assignResult("+detail.get("result")+",\""+detail.get("message")+"\", \"0\");");
			}
			catch(Exception exception){
				out.println(" assignResult(" + false + ",\""+"ITEM_STORE_NOT_FOUND" + "" +"\", \"0\");") ;
			}
		}
		break;
	case 4:
		{
			try
			{
				String item_code	= request.getParameter("item_code");
				String store_code	= request.getParameter("store_code");
				String req_by_Store	= request.getParameter("req_by_Store");
				boolean result = false;
				boolean result1 = false;
				String phy_inv_id = "";
				result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,req_by_Store);
				if(result1){
					phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
					phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,req_by_Store}).get("PHY_INV_ID");
					out.println("document.formAuthorizeAtIssueStoreDetail.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
//out.println("phy_inv_progress();");
					out.println(" assignResult(" + false + ",\""+"PHY_INV_PROCESS_INITIATED" + "" +"\", \"0\");") ;
//result=true;
					return;
				}
				ArrayList alBatchList=new ArrayList();
				alBatchList=bean.getBatchDetails(item_code,store_code);            
				String stock_item_yn =(String)(alBatchList.get(0));
				if(stock_item_yn.equals("Y")) {
					result = true;
				}else{
					out.println(" assignResult(" + false + ",\""+"NOT_STOCK_ITEM" + "" +"\", \"0\");") ;
					return;
				}																  
//code for displaying RequestUOM
			
				String uom_code		= request.getParameter("uom_code");
				String on_store_code   = request.getParameter("store_code");	
				String default_uom = bean.getDefaultUOM(item_code,on_store_code);
				out.println("clearListItemsNoSelect('document.formAuthorizeAtIssueStoreDetail.pur_uom_code'); ");

			 		ArrayList alEncounterList = bean.getPur_uom_code_List(uom_code,item_code);
					HashMap record	= new HashMap();
					for(int i=0; i< alEncounterList.size(); i++){
						record	=	(HashMap)alEncounterList.get(i);
						String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
						String listRecord2	=	(String)record.get("SHORT_DESC");
						if(default_uom !=null || default_uom ==""){
							out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +default_uom+"\") ; ");
						}else{
							out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ) ; ");
						}
					}

					String iss_default_uom = bean.getDefaultUOM(item_code,on_store_code);	out.println("clearListItemsNoSelect('document.formAuthorizeAtIssueStoreDetail.iss_uom_code'); ");

			 		ArrayList iss_results = bean.getPur_uom_code_List(uom_code,item_code);
					for(int i=0; i< iss_results.size(); i++){
						record	=	(HashMap)iss_results.get(i);
						String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
						String listRecord2	=	(String)record.get("SHORT_DESC");
						if(iss_default_uom !=null || iss_default_uom ==""){
							out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +iss_default_uom+"\") ; ");
						}else{
							out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ) ; ");
						}
					}

			out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
			}
			catch(Exception exception){
				out.println(" assignResult(" + false + ",\""+"ITEM_STORE_NOT_FOUND" + "" +"\", \"0\");") ;
			}
		}
		break;
	case 5:
		{	
				String remarks_legend="";
				try{
					String checked = bean.checkForNull(request.getParameter("checked"));
					String remarks_details = bean.checkForNull(bean.getRemarks());
					remarks_legend="APP-000001 "+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cannotbeblank.label","common_labels");
					 //+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cannotbeblank.label","common_labels");
					if(checked.equals("true") && remarks_details.equals("") )
						throw new Exception(remarks_legend);
					boolean result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}catch(Exception exception){
					out.println(" assignResult(" + false + ",\""+remarks_legend + "" +"\", \"0\");") ;
				}
		}
		break;
	case 6:
		{
			boolean result = false;
			
				try{ 
					
					String uom_code		= request.getParameter("uom");
					String pur_uom_code = request.getParameter("pur_uom_code");
					String item_code = request.getParameter("item_code");
					
					//Added against Inc#32347 by Sakti Sankar
				String uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{uom_code, locale}).get("SHORT_DESC");
				
				String pur_uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{pur_uom_code, locale}).get("SHORT_DESC");
				//Added ends
	
				
				//Added by Sakti sankar against RUT-SCF-0248 displaying special characters

				uom_desc = uom_desc.replaceAll(" ","%20");
				uom_desc = java.net.URLEncoder.encode(uom_desc,"UTF-8");
				uom_desc = uom_desc.replaceAll("%2520","%20");

				pur_uom_desc = pur_uom_desc.replaceAll(" ","%20");
				pur_uom_desc = java.net.URLEncoder.encode(pur_uom_desc,"UTF-8");
				pur_uom_desc = pur_uom_desc.replaceAll("%2520","%20");
				//Added ends

					// Changed By Rams for the CRF 537.3 3/24/2010
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, pur_uom_code,item_code}).get("COUNT"));
				if(item_uom_count!=0){
				 HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, pur_uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_desc+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_desc;
				String stEqvl_value=""+Double.parseDouble((String)stEqvl_value1.get("CONV_FACTOR"));
				out.println("setUOMReqConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}else if(am_count!=0){
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("EQVL_VALUE");
				
				String conver=stEqvl_value+" "+uom_desc+" = 1 "+pur_uom_desc;
				out.println("setUOMReqConvFactor1('"+stEqvl_value+"','"+conver+"');");
				
				result=true;
				
				}else{
				String stEqvl_value="1";
				String conver=stEqvl_value+" "+uom_desc+" = 1 "+pur_uom_desc;
				out.println("setUOMReqConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
		    	}
					
				}catch (Exception exception) {
					exception.printStackTrace();
					throw new Exception("NO_CONV_FAC_FOR_REQ_UOM_CODE");
				}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
	case 7:
		{
		boolean result = false;
		
				try { 
					String uom_code		= request.getParameter("uom");
					String iss_uom_code = request.getParameter("iss_uom_code");
					String item_code = request.getParameter("item_code");

					//Added against Inc#32347 by Sakti Sankar
				String uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{uom_code, locale}).get("SHORT_DESC");
				
				String iss_uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{iss_uom_code, locale}).get("SHORT_DESC");
				//Added ends

				//Added by Sakti sankar against RUT-SCF-0248 displaying special characters

				uom_desc = uom_desc.replaceAll(" ","%20");
				uom_desc = java.net.URLEncoder.encode(uom_desc,"UTF-8");
				uom_desc = uom_desc.replaceAll("%2520","%20");

				iss_uom_desc = iss_uom_desc.replaceAll(" ","%20");
				iss_uom_desc = java.net.URLEncoder.encode(iss_uom_desc,"UTF-8");
				iss_uom_desc = iss_uom_desc.replaceAll("%2520","%20");
				//Added ends
					
						// Changed By Rams for the CRF 537.3 3/24/2010
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, iss_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, iss_uom_code,item_code}).get("COUNT"));
				if( item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(CASE WHEN allow_decimals_yn = 'N' THEN lcm (eqvl_value, eqvl_uom_qty) ELSE (eqvl_value / eqvl_uom_qty) END ) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, iss_uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_desc+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+iss_uom_desc;
				String stEqvl_value=""+Double.parseDouble((String)stEqvl_value1.get("CONV_FACTOR"));
				out.println("setUOMIssConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}else if(am_count!=0){
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, iss_uom_code}).get("EQVL_VALUE");
				
				String conver=stEqvl_value+" "+uom_desc+" = 1 "+iss_uom_desc;
				out.println("setUOMIssConvFactor1('"+stEqvl_value+"','"+conver+"');");
				
				result=true;
				
				}else{
				String stEqvl_value="1";
				String conver=stEqvl_value+" "+uom_desc+" = 1 "+iss_uom_desc;
					out.println("setUOMIssConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
		    	}
			}catch (Exception exception) {
					exception.printStackTrace();
					throw new Exception("NO_CONV_FAC_FOR_REQ_UOM_CODE");
			}
							
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
	case 8:
		{
			boolean result = false;
			try{ 
				ArrayList doc_no=bean.getPrintDocNo();
				String pdocno = "";
				for(int i=0;i<doc_no.size();i++){
					pdocno=(String)doc_no.get(i);
					//bean.doOnlineReportPrinting(pdocno); //Comented By Sakti Sankar on 06/03/2013 against Inc#
					bean.doOnlineReportPrinting(pdocno,request,response); //Added By Sakti Sankar on 06/03/2013 against Inc#
				}
				message = request.getParameter("msg");
				System.out.println("message = > "+message);
				result=true;
			}catch (Exception exception){
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}
			finally
			{
				out.println(" assignResult(" + result + ",\"" + message + "\", 	\"" + flag + "\" ) ; ") ;
			}
		}
		break;
	case 9:
		{
			boolean result = false;
			try { 
				String item_code       =   (String)request.getParameter("item_code");
				String frm_store_code	=	(String)request.getParameter("frm_store_code");
				String to_store_code	=	(String)request.getParameter("to_store_code");
				double frm_tmp_conv=bean.getConvFactTemp(item_code,frm_store_code);
				double to_tmp_conv=bean.getConvFactTemp(item_code,to_store_code);
				//bean.setTempConvFact(tmp_conv);
				out.println("setTempConvFactor('"+frm_tmp_conv+"','"+to_tmp_conv+"');");
				result=true;
			}
			catch (Exception exception) {
				exception.printStackTrace();
				//throw new Exception("NO_CONV_FAC_FOR_ISS_UOM_CODE");
			}
		}
		break;
	case 10:
		{
			String request_on_store       =   (String)request.getParameter("request_on_store");
			bean.setRequest_on_store(request_on_store);
			//To populate the requisition_on_stores
			out.println("clearListItems('formRequisitionIssueQueryCriteria.request_by_store'); ");
			ArrayList req_by_stores = bean.getOnStores(request_on_store);
			HashMap record	= new HashMap();
			for(int i=0; i< req_by_stores.size(); i++) {
				record = (HashMap)req_by_stores.get(i);
				out.println("addListItem(\"formRequisitionIssueQueryCriteria.request_by_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
	case 11: {
		boolean result = false;
		try{
			String kit_template_code = (String)request.getParameter("kit_template_code")==null?"":(String)request.getParameter("kit_template_code");
			String store_code	= request.getParameter("store_code");					
			String request_by_store_code	= request.getParameter("request_by_store_code");					
			if(!(kit_template_code.equals("")))
				bean.kitTemplateValues(kit_template_code,store_code,request_by_store_code);
			ArrayList alDetailData=bean.getKitDtlData();
			int count = (int)bean.getCount();
			HashMap ht = new HashMap();
				if(alDetailData.size()>count){
				
					ht = (HashMap)alDetailData.get(count);
					out.println("document.formAuthorizeAtIssueStoreDetail.item_code.value = '"+bean.checkForNull((String)ht.get("ITEM_CODE"),"")+"';");
					out.println("document.formAuthorizeAtIssueStoreDetail.item_desc.value = \""+bean.checkForNull((String)ht.get("SHORT_DESC"))+"\";");
					out.println("document.formAuthorizeAtIssueStoreDetail.uom.value = '"+bean.checkForNull((String)ht.get("UOM_CODE"),"")+"';");
					out.println("document.formAuthorizeAtIssueStoreDetail.kit_item_yn.value = '"+bean.checkForNull((String)ht.get("KIT_ITEM_YN"),"N")+"';");
					out.println("document.formAuthorizeAtIssueStoreDetail.kit_template_uom.value = '"+bean.checkForNull((String)ht.get("KIT_UOM_DESC"),"")+"';");
					out.println("document.formAuthorizeAtIssueStoreDetail.req_item_qty.value = '"+bean.checkForNull((String)ht.get("QUANTITY"),"0")+"';");
					out.println("document.formAuthorizeAtIssueStoreDetail.req_uom_qty.value = '"+bean.checkForNull((String)ht.get("QUANTITY"),"0")+"';");
					out.println("document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value = '"+bean.checkForNull((String)ht.get("QUANTITY"),"0")+"';");
					out.println("document.formAuthorizeAtIssueStoreDetail.issuing_qty.value = '"+bean.checkForNull((String)ht.get("QUANTITY"),"0")+"';");
					out.println("document.getElementById('uom_label').innerHTML = '<B>"+bean.checkForNull((String)ht.get("STOCK_UOM_DESC"),"&nbsp;")+"</B>';");
					out.println("kitGetStatus('"+bean.checkForNull((String)ht.get("UOM_CODE"),"")+"');");
					result = true;
				}else{
					result = false;
				}
			}catch(Exception e){
				result = false;
				message = e.getMessage();
				e.printStackTrace();
			}
		}
		break;
	case 12:{
			boolean result = false;
			ArrayList alDtlData = new ArrayList();
			ArrayList errorList = new ArrayList();
			ArrayList errorItems = new ArrayList();
			HashMap ht = new HashMap();
			alDtlData = bean.getKitDtlData();
			String store_code	= request.getParameter("store_code");					
			String to_store_code	= request.getParameter("to_store_code");					
			HashMap hmStockAvailabilityStatus = new HashMap();
			for(int i=0;i<alDtlData.size();i++){
				ht = (HashMap)alDtlData.get(i);
				String[] stParameters = {(String)ht.get("ITEM_CODE"), store_code, "0", "N", "", "N", to_store_code };
					result = bean.isPhysicalInventoryProcessStartedForStore((String)ht.get("ITEM_CODE"),store_code,to_store_code);
					if(result){
						errorList.add("PHY_INV_PROCESS_INITIATED");
						errorList.add((String)ht.get("SHORT_DESC"));
						errorItems.add((String)ht.get("ITEM_CODE"));
					}
					try{
						hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y")){
							if( hmStockAvailabilityStatus.get("available_stock").equals("0")){
								errorList.add("STOCK_NOT_AVAILABLE");
								errorList.add((String)ht.get("SHORT_DESC"));
								errorItems.add((String)ht.get("ITEM_CODE"));
							}
							if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
								errorList.add("INSUFFICIENT_BATCH_QTY");
								errorList.add((String)ht.get("SHORT_DESC"));
								errorItems.add((String)ht.get("ITEM_CODE"));
							}
						}else{
							errorList.add("NOT_STOCK_ITEM");
							errorList.add((String)ht.get("SHORT_DESC"));
							errorItems.add((String)ht.get("ITEM_CODE"));
						}
					}catch(Exception e){
						if(!result){
							errorList.add("ITEM_STORE_NOT_FOUND");
							errorList.add((String)ht.get("SHORT_DESC"));
							errorItems.add((String)ht.get("ITEM_CODE"));
						}
					}
			}
			bean.setErrorItems(errorItems);
			out.println("displayMessage('"+errorList+"');");
			result		=	true;
/*			boolean result = false;
			ArrayList alDtlData = new ArrayList();
			ArrayList errorList = new ArrayList();
			ArrayList errorItems = new ArrayList();
			HashMap ht = new HashMap();
			alDtlData = bean.getKitDtlData();
			String store_code	= request.getParameter("store_code");					
			String to_store_code	= request.getParameter("to_store_code");					
			HashMap hmStockAvailabilityStatus = new HashMap();
			//alDtlData = bean.getDtlRecords();
			//alDtlData = bean.getKitDtlData();
			for(int i=0;i<alDtlData.size();i++){
				ht = (HashMap)alDtlData.get(i);
				String[] stParameters = {(String)ht.get("ITEM_CODE"), store_code, "0", "N", "", "N", to_store_code };
					result = bean.isPhysicalInventoryProcessStartedForStore((String)ht.get("ITEM_CODE"),store_code,to_store_code);
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
							/*if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
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
			bean.setErrorItems(errorItems);
			out.println("displayMessage('"+errorList+"');");
			result		=	true;*/
	}
	break;
	case 13:
		{
			try
			{
			String item_code	= request.getParameter("item_code");
			String store_code	= request.getParameter("store_code");
			String req_by_Store	= request.getParameter("req_by_Store");
			boolean result = false;
			boolean result1 = false;
			result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,req_by_Store);
				if(result1)
				{
					//out.println("phy_inv_progress();");
//					result=true;
				}
			ArrayList alBatchList=new ArrayList();
			alBatchList=bean.getBatchDetails(item_code,store_code);            
            String stock_item_yn =(String)(alBatchList.get(0));
			if(stock_item_yn.equals("Y")) {
				result = true;
			}																  
			//code for displaying RequestUOM
		
			String uom_code		= request.getParameter("uom_code");
			String on_store_code   = request.getParameter("store_code");	
			String default_uom = bean.getDefaultUOM(item_code,on_store_code);
				out.println("clearListItems('document.formAuthorizeAtIssueStoreDetail.pur_uom_code'); ");

			 		ArrayList alEncounterList = bean.getPur_uom_code_List(uom_code,item_code);
					HashMap record	= new HashMap();
					for(int i=0; i< alEncounterList.size(); i++) 
					{
					record	=	(HashMap)alEncounterList.get(i);
					String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2	=	(String)record.get("SHORT_DESC");
					if(default_uom !=null || default_uom ==""){
						out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +default_uom+"\") ; ");
					}else{
						out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ) ; ");
					}
					}

					String iss_default_uom = bean.getDefaultUOM(item_code,on_store_code);	out.println("clearListItems('document.formAuthorizeAtIssueStoreDetail.iss_uom_code'); ");

			 		ArrayList iss_results = bean.getPur_uom_code_List(uom_code,item_code);
					for(int i=0; i< iss_results.size(); i++) 
					{
					record	=	(HashMap)iss_results.get(i);
					String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2	=	(String)record.get("SHORT_DESC");
					if(iss_default_uom !=null || iss_default_uom ==""){
						out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +iss_default_uom+"\") ; ");
					}else{
						out.println("addListItem(\"document.formAuthorizeAtIssueStoreDetail.iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ) ; ");
					}
					}


			out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
			}
			catch(Exception exception){
				out.println(" assignResult(" + false + ",\""+"getMessage('ITEM_STORE_NOT_FOUND','ST')" + "" +"\", \"0\");") ;
			}
		}
		break;
	case 14:
		{
			if(bean.getTogglePoint().equals("DOCSRLNO"))
				bean.ascOrder();
			else if(bean.getTogglePoint().equals("DESC"))
				bean.dscOrder();
			else
				bean.setTogglePoint("DOCSRLNO");
			out.println(" assignResult(" + true + ",\"" + "" +"\", \"0\");") ;
		}
	break;
	case 15:
		{
			String request_on_store       =   (String)request.getParameter("request_on_store");
			String request_by_store       =   (String)request.getParameter("request_by_store");
			out.println("clearListItems('formRequisitionIssueQueryCriteria.item_class_code'); ");
			ArrayList item_class_code =new ArrayList(); 
			if(	request_by_store.equals("") && !request_on_store.equals("")) {
			item_class_code=bean.getItemClasses(request_on_store);
			}else if(request_by_store.equals("") && request_on_store.equals("")){
			item_class_code=bean.getDefaultItemClasses1();
			}else{
			item_class_code=bean.getItemClasses(request_on_store,request_by_store);
			}
			HashMap record	= new HashMap();
			for(int i=0; i< item_class_code.size(); i++) {
				record = (HashMap)item_class_code.get(i);
				out.println("addListItem(\"formRequisitionIssueQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		case 16:
		{
			boolean result = false;
		try
			{
			
			String request_on_store_code       =   (String)request.getParameter("request_on_store_code");
			ArrayList checkedvalues=new ArrayList();
			checkedvalues=bean.getAddedItemKeys();
			String doc_no=bean.checkForNull(bean.getDoc_no(),"0");
			if(checkedvalues.size()==0){
			checkedvalues=bean.getItemKeys();
			}
			
			String count="0";
			for(int i=0;i<checkedvalues.size();i++)
				{
				count=(String)bean.fetchRecord("select count(hdr.DOC_NO) count from st_request_hdr hdr,st_request_dtl dtl where hdr.REQ_BY_STORE_CODE=? and hdr.DOC_NO=dtl.DOC_NO and dtl.ITEM_CODE=? and hdr.DOC_TYPE_CODE=dtl.DOC_TYPE_CODE and  hdr.REQUEST_STATUS='W' and hdr.FACILITY_ID=dtl.FACILITY_ID and dtl.DOC_NO not in(?) ",new String[]{request_on_store_code,(String)checkedvalues.get(i),doc_no}).get("COUNT");
					if(!count.equals("0"))
					{
						result=true;
						break;
					}
				}
				if(!result){
					 checkedvalues=new ArrayList();
					 checkedvalues=bean.getItemKeys();
				 for(int i=0;i<checkedvalues.size();i++)
					{
				count=(String)bean.fetchRecord("select count(hdr.DOC_NO) count from st_request_hdr hdr,st_request_dtl dtl where hdr.REQ_BY_STORE_CODE=? and hdr.DOC_NO=dtl.DOC_NO and dtl.ITEM_CODE=? and hdr.DOC_TYPE_CODE=dtl.DOC_TYPE_CODE and  hdr.REQUEST_STATUS='W' and hdr.FACILITY_ID=dtl.FACILITY_ID and dtl.DOC_NO not in(?)  ",new String[]{request_on_store_code,(String)checkedvalues.get(i),doc_no}).get("COUNT");
					if(!count.equals("0"))
						{
						result=true;
						break;
						}
					}
				}

		}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
		}
		break;
		case 17:
		{
			boolean result = false;
		try
			{
			
		
			bean.clearCheckedValues();
			String values = (String) hash.get("values");
			String mode = (String) hash.get("mode");
			java.util.StringTokenizer st	=		new java.util.StringTokenizer(values,"~");
			ArrayList arr					=		new ArrayList();
			while( st.hasMoreElements())
			 {
			 arr.add(st.nextElement() );
			 }

		 	bean.setCheckedDValues(arr);
			ArrayList addedItemKeys=new ArrayList();
			addedItemKeys=bean.getAddedItemKeys();
			if(mode.equals("1")){
			if(addedItemKeys.size()==arr.size()){
			message="No items for Authorised ";
			result		=	true;
			}else{
			for(int i=0;i<arr.size();i++)
				{
				addedItemKeys.remove(arr.get(i));
				}
			}
			}else if(mode.equals("2")){
			if(((addedItemKeys.size())+(bean.getItemKeys().size()))==arr.size()){
			message="No items for Authorised ";
			result		=	true;
			}
			}
		}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
		}
		break;
	case 18:{
		boolean result = false;
		String item_code       =   (String)request.getParameter("item_code");
		String to_store_code	=	(String)request.getParameter("to_store_code");
		String fm_store_code	=	(String)request.getParameter("fm_store_code");
		String issue_uom_code	=	(String)request.getParameter("issue_uom_code");
		String req_string	=	(String)request.getParameter("req_string");
		HashMap conv_factors	=	(HashMap)bean.getConvFactTemp(item_code,fm_store_code,to_store_code,issue_uom_code,req_string);
		if(req_string.equals("REQ_UOM")){
		out.println("setMultiplesReq('"+(String)conv_factors.get("FROM_STORE_MULTIPLES")+"','"+(String)conv_factors.get("TO_STORE_MULTIPLES")+"','"+(String)conv_factors.get("REQ_BATCH_QTY_MULTIPLES")+"','"+(String)conv_factors.get("REQ_UOM_MULTIPLES")+"');");
		}else{
			out.println("setMultiples('"+(String)conv_factors.get("FROM_STORE_MULTIPLES")+"','"+(String)conv_factors.get("TO_STORE_MULTIPLES")+"','"+(String)conv_factors.get("BATCH_QTY_MULTIPLES")+"','"+(String)conv_factors.get("ISSUE_UOM_MULTIPLES")+"');");
		}

		result = true;
	}
	break;
	case 19:{
		System.out.println("enter into case 19 in authorize at issue store validate");
		boolean result = false;
	try{
  			 System.out.println("hash in authorize at issue store validate = "+hash);
			 String item_code =  (String) hash.get("item_code");	
             bean.updateTempRecords(item_code,hash);
			 //ArrayList alList = null;              // commented for TTM-SCF-0198
			 //bean.setExpRecords(item_code, alList); // commented for TTM-SCF-0198
			 
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	break;
	case 20:{
		System.out.println("enter into case in authorize at issue store validate 20");
		boolean result = false;
	try{
  			System.out.println("hash in authorize at issue store validate = "+hash);
			String item_code =  (String) hash.get("item_code");	
		    			
			bean.setExpRecords(item_code, bean.getTempRecords(item_code));
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	break;
	//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016 starts
	case 21:{
		System.out.println("enter into case in authorize at issue store validate 21");
		boolean result = false;
		try{
  			System.out.println("hash in authorize at issue store validate = "+hash);
			String item_code =  (String) hash.get("item_code");	
			String fm_store_code = request.getParameter("fm_store_code");
			String to_store_code = request.getParameter("to_store_code");
			System.out.println("fm_store_code===="+fm_store_code+"=======to_store_code===="+to_store_code);
			String[] stParameters	= {item_code, fm_store_code, "0", "N", "", "N", to_store_code};
			HashMap hmStockAvailabilityStatus  = bean.getStockAvailabilityStatus(stParameters);
			double avail_stock = (Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")));
			System.out.println("avail_stock========= in validate"+avail_stock);
			if(avail_stock<= 0 )
			result = false;
			else
				result= true;
		}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	break;//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016 ends
	//Added for IN:071868 start
	case 22:{
		System.out.println("enter into case in authorize at issue store validate 22");
		boolean result = false;
	try{
  			System.out.println("hash in authorize at issue store validate = "+hash);
			String item_code =  (String) hash.get("item_code");	
		    			
			bean.updTempRecords(item_code);
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	break;
	case 23:{//added for MO-CRF-20173
		System.out.println("enter into case in authorize at issue store validate 23");
		String close_remarks = (String)hash.get("close_remarks"); 
		System.out.println("close_remarks: "+(String)hash.get("close_remarks"));  
		bean.setCloseRemarksDesc(close_remarks);  
		bean.updateItemRemarks(itemCd, close_remarks);   
	}
	break;
	case 24:{//added for MO-CRF-20173
		System.out.println("enter into case in authorize at issue store validate 24");
		boolean result = false;
			try{
				result = bean.getCloseItemValue();	
			}
			catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally{
			out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
		}
	}
	break;
	//Added for IN:071868 end
		default :
		return;
	}
	
putObjectInBean(bean_id,bean,request);
%>
