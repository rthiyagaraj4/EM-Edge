<%@page contentType="text/html;charset=UTF-8" import=" ePO.*,ePO.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
    String check_status		=		request.getParameter("check_status");
    String stitem_code		=		request.getParameter("item_code");
	String bean_id			=		request.getParameter("bean_id");
	String bean_name		=		request.getParameter("bean_name");
    String functionType		=		request.getParameter("function_type");
	String supplier 		=  		request.getParameter("supplier");
	String dflt_currency 	=       "";
	String commit_code 		=  		request.getParameter("commit_code");
	String department_id    =  		request.getParameter("dept_id");
	String acc_number 	    =  		request.getParameter("acc_no");
	String acc_desc     	=       "";
	String uom_code 	    =  		request.getParameter("uom_code");
	String commt_code 	    =  		request.getParameter("commt_code");
	String dept_code		=		request.getParameter("dept_code");
	String uom_desc			=		"";
	String commt_desc 		=		"";
	int	index = 0;

	if ((bean_id == null) || (bean_id.equals("")))
		return;

	DeliveryOrderBean bean		=		(DeliveryOrderBean) getBeanObject(bean_id, bean_name, request  );
	bean.setLanguageId(locale);

	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		(Hashtable) hash.get ("SEARCH");
	boolean result			=		false;
	boolean result1			=		false;
	String message			=		"";
	String flag				=		"";
	
	if(functionType.equals("LOADCURRENCY")){
		System.out.println("LOADCURRENCY");
		String local_currency = request.getParameter("localCurrency");
		dflt_currency = request.getParameter("tran_currency");
				
		out.println("clearListItems('formDeliveryOrderHeader.currency_code'); ");
		ArrayList currency_code = bean.getCurrencyLists();
		HashMap record = new HashMap();
			for(int i=0; i< currency_code.size(); i++) {
				record = (HashMap)currency_code.get(i);
				out.println("addListItem(\"formDeliveryOrderHeader.currency_code\", \"" + record.get("CURRENCY_CODE") + "\",\"" + record.get("SHORT_DESC") + "\",\"" +dflt_currency+ "\");");
			}
			
		String currency_desc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  SY_FOREIGN_CURRENCY where CURRENCY_CODE=?",new String[]{dflt_currency}).get("SHORT_DESC"),"");
		System.out.println("currency_desc = "+currency_desc);
		String currency_desc_lc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  SY_FOREIGN_CURRENCY where CURRENCY_CODE=?",new String[]{local_currency}).get("SHORT_DESC"),"");
		
		out.println(" formDeliveryOrderHeader.currency_code.disabled=true ; ");	
		out.println(" formDeliveryOrderHeader.delivery_type.disabled=true ; ");	
		out.println(" formDeliveryOrderHeader.supplier_code.disabled=true ; ");	
		
		out.println("parent.DODetailFrame.document.getElementById('currency_label_1').innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DODetailFrame.document.getElementById("currency_label_2").innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DODetailFrame.document.getElementById("currency_label_3").innerHTML = '" +  currency_desc +"'; ");
		out.println("parent.DODetailFrame.document.getElementById('currency_label_4').innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DOListFrame.document.getElementById("currency_label_5").innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DOListFrame.document.getElementById("currency_label_6").innerHTML = '" +  currency_desc +"'; ");
		out.println("parent.DOListFrame.document.getElementById('currency_label_7').innerHTML = '" +  currency_desc +"'; ");
		out.println("parent.DOListFrame.document.getElementById('currency_label_8').innerHTML = '" +  currency_desc_lc +"'; ");
		
		if(dflt_currency.equals(local_currency)){
			out.println("document.getElementById('exc_rate').value = '" +  1 +"'; ");
			out.println("document.getElementById('exc_rate').disabled = true; ");
		}else{
			out.println("document.getElementById('exc_rate').value = '" +  "" +"'; ");
			out.println("document.getElementById('exc_rate').disabled = false; ");
		}
		
		
		
	}
	
	else if(functionType.equals("SETCURRCODE")){
		System.out.println("SETCURRCODE");
		String local_currency = request.getParameter("local_currency");
		dflt_currency = request.getParameter("tran_currency");
				
		String currency_desc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  SY_FOREIGN_CURRENCY where CURRENCY_CODE=?",new String[]{dflt_currency}).get("SHORT_DESC"),"");
		
		String currency_desc_lc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  SY_FOREIGN_CURRENCY where CURRENCY_CODE=?",new String[]{local_currency}).get("SHORT_DESC"),"");
		
		System.out.println("currency_desc in do validate = "+currency_desc);
		
	//	out.println(" formDeliveryOrderHeader.currency_code.disabled=true ; ");	
		out.println("parent.DODetailFrame.document.getElementById('currency_label_1').innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DODetailFrame.document.getElementById("currency_label_2").innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DODetailFrame.document.getElementById("currency_label_3").innerHTML = '" +  currency_desc +"'; ");
		out.println("parent.DODetailFrame.document.getElementById('currency_label_4').innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DOListFrame.document.getElementById("currency_label_5").innerHTML = '" +  currency_desc +"'; ");
	//	out.println("parent.DOListFrame.document.getElementById("currency_label_6").innerHTML = '" +  currency_desc +"'; ");
		out.println("parent.DOListFrame.document.getElementById('currency_label_7').innerHTML = '" +  currency_desc +"'; ");
		out.println("parent.DOListFrame.document.getElementById('currency_label_8').innerHTML = '" +  currency_desc_lc +"'; ");
		
		if(dflt_currency.equals(local_currency)){
			out.println("document.getElementById('exc_rate').value = '" +  1 +"'; ");
			out.println("document.getElementById('exc_rate').disabled = true; ");
		}else{
			out.println("document.getElementById('exc_rate').value = '" +  "" +"'; ");
			out.println("document.getElementById('exc_rate').disabled = false; ");
		}
		
		
		
	}
	else if(functionType.equals("POREQDFORDO")){
	 	try{
			
			String poReqd = bean.checkForNull((String)bean.fetchRecord("SELECT PO_REQD_FOR_DO FROM PO_PARAMETER").get("PO_REQD_FOR_DO"),"");
			
			if(poReqd.equals("Y"))
				result = true;
			else
				result = false;
				
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
	else if(functionType.equals("CHECHBATCHDETAILS")){
	 	try{
			String itm_cd = request.getParameter("itm_cd");
			String itm_cd1 = request.getParameter("itm_cd1");
			String po_no = request.getParameter("po_no");
			String delv_date = request.getParameter("delv_date");
			String request_no = request.getParameter("request_no");
			
			String mode = request.getParameter("mode");	
			ArrayList hmExpRecords = new ArrayList();
			ArrayList hmExpRecords1 = new ArrayList();
			hmExpRecords = (ArrayList)bean.getBatchRecords(itm_cd);
			
				System.out.println("hmExpRecords in validate = "+hmExpRecords);
			if(hmExpRecords != null){
				if(hmExpRecords.size() > 0 )  
					result = true;
				else
					result = false;	
			}else{
				hmExpRecords1 = bean.getBatchDetailsData(bean.getDoc_no(),itm_cd1,po_no,delv_date,request_no);
				if(hmExpRecords1 != null){
				if(hmExpRecords1.size() > 0 )  
					result = true;
				else
					result = false;	
			}else{
				result = false;	
			}
			
		//	result = false;	
			}	
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
	else if(functionType.equals("LOADSTORE")){
		System.out.println("LOADSTORE");
		String facility_id = request.getParameter("facility_id");
		String count = request.getParameter("count");			
		System.out.println("facility_id in do validate = "+facility_id);
		
		out.println("clearListItems('formDOBatchDetails.req_store_code_"+ count+"'); ");
		ArrayList store_code = bean.getRequestByStoreList(facility_id);
		System.out.println("store_code = "+store_code);
		HashMap record = new HashMap();
			for(int i=0; i< store_code.size(); i++) {
				record = (HashMap)store_code.get(i);
				out.println("addListItem(\"formDOBatchDetails.req_store_code_"+count+"\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
	
	}
	else if(functionType.equals("LOADUOM")){
			System.out.println("LOADUOM");
			try {
				try {
						String store_code = request.getParameter("store_code");			
						String item_code = request.getParameter("item_code");			
						String count = request.getParameter("count");			
						String delivery_uom_code = request.getParameter("delivery_uom_code");			
						System.out.println("delivery_uom_code in validate = "+delivery_uom_code);
						
						ArrayList alRecord = new ArrayList();
						alRecord.add(store_code);
						alRecord.add(item_code);
						
						 String def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord).get("DEF_ISSUE_UOM");
						 System.out.println("def_uom = "+def_uom);
						 						 
						 if(def_uom != null && def_uom != ""){
							String def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
							//out.println("document.getElementById("uom_label_")" + count + ".innerHTML = '" +  def_uom_desc +"'; ");//Commented by suresh.r on 04-06-2014 against ML-BRU-SCF-1356
							out.println("document.getElementById('delivery_uom_' + count).value = '" + def_uom + "';");
							if(delivery_uom_code.equals(def_uom)){
								out.println("document.getElementById('dist_conv_fact_' + count).value = '" + 1 + "';");

							}else{
								ArrayList uomRecord = new ArrayList();
								uomRecord.add(delivery_uom_code);
								uomRecord.add(def_uom);
								String eqvl_value = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_EQVL_UOM_VALUE"),uomRecord).get("EQVL_VALUE");
								out.println("document.getElementById('dist_conv_fact_' + count).value = '" + bean.checkForNull(eqvl_value) + "';");

							}
						 }else{
						
							out.println("document.formDOBatchDetails.req_store_code_" + count + ".focus(); ");
							out.println("document.getElementById('delivery_uom_' + count).value = '" + "" + "';");
							//out.println("document.getElementById("uom_label_")" + count + ".innerHTML = '" +  "" +"'; ");//Commented by suresh.r on 04-06-2014 against ML-BRU-SCF-1356
						 }
					
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
					throw exception;
				//	exception.printStackTrace();
					
				}
			}
			
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				//exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}
	
	
	else if(functionType.equals("LOADDEPTID")){
		System.out.println("LOADDEPTID");
		
		
		System.out.println("commit_code in po validate = "+commit_code);
				
		out.println("clearListItems('formPurchaseOrderDetail.dept_id'); ");
		ArrayList dept_id = bean.getDept_no(commit_code);
		HashMap record = new HashMap();
		System.out.println("dept_id.size() in po validate = "+dept_id.size());
			for(int i=0; i< dept_id.size(); i++) {
				record = (HashMap)dept_id.get(i);
			/*	if(dept_id.size()==1){
				out.println("addListItem(\"formPurchaseOrderDetail.dept_id\", \"" + record.get("DEPT_CODE") + "\",\"" + record.get("SHORT_DESC")  + "\",\"" +record.get("DEPT_CODE") +"\");");
				}else{
			*/	
				out.println("addListItem(\"formPurchaseOrderDetail.dept_id\", \"" + record.get("DEPT_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			//	}
			}
	}
	
	else if(functionType.equals("LOADACCNO")){
		System.out.println("LOADACCNO");
		
		
		System.out.println("department_id in po validate = "+department_id);
				
		out.println("clearListItems('formPurchaseOrderDetail.acc_no'); ");
		ArrayList acc_no = bean.getAccount_no(department_id,commit_code);
		HashMap record = new HashMap();
			for(int i=0; i< acc_no.size(); i++) {
				record = (HashMap)acc_no.get(i);
				out.println("addListItem(\"formPurchaseOrderDetail.acc_no\", \"" + record.get("ACCOUNT_NO") + "\",\"" + record.get("ACCOUNT_NO") + "\");");
			}
	}
	
	else if(functionType.equals("LOADACCDESC")){
		System.out.println("LOADACCDESC");
		
		
		System.out.println("acc_number in po validate = "+acc_number);
		
		HashMap hmRecord = bean.getAcctDesc(acc_number,commit_code,department_id);
			if(hmRecord.size()>0){
				acc_desc = (String)hmRecord.get("ACCOUNT_NAME");
			}
		
		out.println("document.getElementById('acc_desc_label').innerHTML = '" +  acc_desc +"'; ");
		out.println("document.getElementById('acc_desc').value = '" +  acc_desc +"'; ");	
	}
	
	else if(functionType.equals("GETUOMDESC")){
		System.out.println("GETUOMDESC");
		
		
		System.out.println("uom_code in po validate = "+uom_code);
		
		HashMap hmRecord = bean.getUomDesc(uom_code);
			if(hmRecord.size()>0){
				uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
		out.println("document.getElementById('temp_delv_uom_code').value = '" +  uom_code +"'; ");
		out.println("document.getElementById('temp_delv_uom_desc').value = '" +  uom_desc +"'; ");
			
	}
	
	else if(functionType.equals("GETCOMMNTDESC")){
		System.out.println("GETCOMMNTDESC");
		
		
		System.out.println("commt_code in po validate = "+commt_code);
		
		HashMap hmRecord = bean.getCommntDesc(commt_code);
			if(hmRecord.size()>0){
				commt_desc = (String)hmRecord.get("SHORT_DESC");
			}
		
		out.println("document.getElementById('temp_commt').value = '" +  commt_desc +"'; ");
			
	}

	else if(functionType.equals("SETORDERVALUES")){
	

			try{
				String order_remarks = request.getParameter("order_remarks");
                 bean.setOrder_remarks(order_remarks);
				 
				result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(functionType.equals("SETADDITIONALDETAILS")){
	

			try{
			
				String inv_no = request.getParameter("inv_no");
				String inv_date = request.getParameter("inv_date");
				String inv_recdBy = request.getParameter("inv_recdBy");
				String pmnt_term = request.getParameter("pmnt_term");
				String terms_conditions = request.getParameter("terms_conditions");
				String delivery_mode = request.getParameter("delivery_mode");
				String delivery_remarks = request.getParameter("delivery_remarks");
				
				
                bean.setInv_no(inv_no);
				bean.setInv_date(inv_date);
				bean.setInv_recdBy(inv_recdBy);
				bean.setPmnt_term(pmnt_term);
				bean.setTerms_conditions(terms_conditions);
				bean.setDelivery_mode(delivery_mode);
				bean.setDelivery_remarks(delivery_remarks);
				
				
				 
				result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
	
	
	else if(functionType.equals("SETITEMVALUES")){
	

			try{
				
				String item_remarks = request.getParameter("item_remarks");
				//out.println("PODetailFrame.formPurchaseOrderDetail.item_remarks.value = '"+bean.checkForNull(item_remarks,"")+"';");
				out.println("document.forms[0].item_remarks.value = '"+bean.checkForNull(item_remarks,"")+"';");
                				 
				result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(functionType.equals("SETDELIVERYVALUES")){
	 	try{
				System.out.println("hash"+hash);
				System.out.println("item_code:"+stitem_code);

              bean.updateDeliveryRecords(stitem_code, hash);
              
		
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
	else if(functionType.equals("SETBATCHVALUES")){
	 	try{
				System.out.println("hash in SETBATCHVALUES =  "+hash);
				System.out.println("item_code:"+stitem_code);

              bean.updateBatchRecords(stitem_code, hash);
              
		
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
/*	else if(functionType.equals("SETBILLTODELIVERTODETAILS")){
	 	try{
				System.out.println("hash in SETBILLTODELIVERTODETAILS "+hash);
			//	String idx = request.getParameter("index");
				//System.out.println("hash in SETBILLTODELIVERTODETAILS idx = "+idx);
			//	System.out.println("item_code:"+stitem_code);

              bean.updateBillToDeliveryRecords(hash);
              
		
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
		
	
	else if(functionType.equals("OVERRIDEBUDGET")){
			System.out.println("OVERRIDEBUDGET");
			try {
				try {
					String override_Budget = "";
					String balance_amt = "" ;
					HashMap amountHandler = (HashMap)bean.newOverride();
					System.out.println("amountHandler = "+ amountHandler);
					Iterator it = amountHandler.entrySet().iterator();
					while (it.hasNext()) {
						ArrayList alCommtRecord = new ArrayList();
						ArrayList alBudgetRecord = new ArrayList();
						Map.Entry pairs = (Map.Entry)it.next();
						for (String retval: ((String)pairs.getKey()).split("-")){
							alBudgetRecord.add(retval); //COMMNT_CODE , DEPT_NO
						}
						String override_amt = (String)pairs.getValue();
						System.out.println("override_amt outside= "+ override_amt);
				
						 override_Budget = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_OVERRIDE"),alBudgetRecord).get("OVERRIDE_BUDGET");
						 System.out.println("override_Budget outside= "+override_Budget);
						 balance_amt = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_BALANCE"),alBudgetRecord).get("BALANCE_BDGT_AMT");
							System.out.println("balance_amt outside= "+balance_amt);
					
						// Start
						
					String com_desc = "";
					String com_code = "";
					String dept_desc = "";
					String dt_code = "";
					System.out.println("alBudgetRecord.size() = "+alBudgetRecord.size());
					for(int i=0;i<alBudgetRecord.size();i++){
								com_code = (String) alBudgetRecord.get(i);
								dt_code = (String) alBudgetRecord.get(++i);
								
								String[] stParameters1 ={bean.getLanguageId(),com_code};	
								String[] stParameters2 ={bean.getLanguageId(),com_code,dt_code};	
								com_desc	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMM_DESC_SELECT"),stParameters1).get("SHORT_DESC");
								dept_desc	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_DEPT_DESC_SELECT"),stParameters2).get("SHORT_DESC");
								System.out.println("com_code = "+com_code);
								System.out.println("dt_code = "+dt_code);
								System.out.println("com_desc = "+com_desc);
								System.out.println("dept_desc = "+dept_desc);

					}
					
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.com_code.value = '" +  com_code +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.com_desc.value = '" +  com_desc +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.dt_code.value = '" +  dt_code +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.dept_desc.value = '" +  dept_desc +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.balance_amt.value = '" +  balance_amt +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.override_amt.value = '" +  override_amt +"'; ");
						
						// End
				
						if(Double.parseDouble(override_amt) > Double.parseDouble(balance_amt)){
							if(override_Budget.equals("W")){
								throw new Exception("OVERRIDE_WARNING");
							}else if(override_Budget.equals("E")){
								throw new Exception("OVERRIDE_ERROR");
							}else if(override_Budget.equals("N")){
								throw new Exception("OVERRIDE_NOTAPPLICABLE");
							}
						}
					}
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
				//	exception.printStackTrace();
						System.out.println("exception.getMessage() = "+exception.getMessage());
						if (exception.getMessage().equals("OVERRIDE_WARNING"))
							throw exception;
						else if (exception.getMessage().equals("OVERRIDE_ERROR"))
							throw exception;	
						else if (exception.getMessage().equals("OVERRIDE_NOTAPPLICABLE"))
							throw exception;	
							
				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				//exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}
		
	else if(functionType.equals("COMMITCODE")){
			try {
				try {
					String override_Budget = "";
					ArrayList alBudgetRecord = new ArrayList();
					String dept_id	= request.getParameter("dept_id");					
					String net_amount	= request.getParameter("net_amount");
					String bal_budget   = "";
					alBudgetRecord.add(commit_code);
					alBudgetRecord.add(dept_id);
					 override_Budget = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_OVERRIDE"),alBudgetRecord).get("OVERRIDE_BUDGET");
					bal_budget=(String)bean.fetchRecord(("select BALANCE_BDGT_AMT from PO_COMMTTMENT_ACCOUNT where MASTER_CODE = ? and DEPT_CODE = ? "),new String[]{commit_code,dept_id}).get("BALANCE_BDGT_AMT");
					System.out.println("bal_budget outside= "+bal_budget);
					out.println("document.getElementById("bal_budget").value = '" +  bal_budget +"'; ");
					String[] stParameters2 ={bean.getLanguageId(),commit_code,dept_id};	
					String dept_desc	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_DEPT_DESC_SELECT"),stParameters2).get("SHORT_DESC");
					out.println("document.getElementById("dept_desc").value = '" +  dept_desc +"'; ");
					if(override_Budget.equals("E")){
					if(Double.parseDouble(bean.checkForNull(bal_budget)) < Double.parseDouble(net_amount)){
						System.out.println("bal_budget = "+bal_budget);
						throw new Exception("BAL_BUD_LESS_THAN_ORDER_QTY");
					}
					}
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
					//exception.printStackTrace();

						if (exception.getMessage().equals("BAL_BUD_LESS_THAN_ORDER_QTY"))
							throw exception;

				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				//exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}
		else if(functionType.equals("CHECKITEMAPPROVAL")){
			try {
			
						// Added by Padmapriya for INC # 34857 on 03/09/2012
				
				HashMap hashApp = new HashMap();
				String app_item = "";
			    hashApp=bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PO_ITEM_APPROVAL_YN"));
				app_item=(String)hashApp.get("ITEM_LEVEL_ORDER_APPROVAL");
				System.out.println("app_item = "+app_item);							
				if(app_item.equals("Y")){                               
					ArrayList checkApproval = bean.checkApprovedYN();
					ArrayList hashCheck = new ArrayList();
					for(int i=0; i< checkApproval.size(); i++){
						hashCheck = (ArrayList)checkApproval.get(i);
						 for(int j=0;j<hashCheck.size();j++){
									
							System.out.println("hashCheck in po validate = "+hashCheck.get(j));
							if(hashCheck.get(++j).equals("N")){
								result = true;
								message = (String) hashCheck.get(0);
								System.out.println("result in po validate 1 = "+result);
								break;                
							}
							System.out.println("result in po validate 2 = "+result);
						}
					}
					}else{
						result = false;
					}
					// End by Padmapriya for INC # 34857 on 03/09/2012
					
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			
			}

	
		}
	*/	
		else if(functionType.equals("ADDITEMRECORD")){
			try {
				try {
			
					String item_code	= request.getParameter("item_code");
					String itm_cd	= request.getParameter("itm_cd");
					String po_no	= request.getParameter("po_no");
					String delv_date	= request.getParameter("delv_date");
					String request_no	= request.getParameter("request_no");
					
					String item_code1 = "";
					if(po_no!=""){
						item_code1 = item_code+po_no+delv_date+request_no;
						System.out.println("item_code1 in doqty distribution = "+item_code1);
					}else{
						item_code1 = item_code;
					}
				/*	
					if(bean.getBatchRecords(item_code1) != null && bean.getBatchRecords(item_code1).size()>0){
							result = true;
							out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
					}
				*/	
					ArrayList hmExpRecords = new ArrayList();
					ArrayList hmExpRecords1 = new ArrayList();
					hmExpRecords = (ArrayList)bean.getBatchRecords(item_code1);
			
					System.out.println("hmExpRecords in validate = "+hmExpRecords);
				if(hmExpRecords != null){
					if(hmExpRecords.size() > 0 )  {
						int delv_qty = 0;
						for(int i=0;i<hmExpRecords.size();i++){
							HashMap hmQty = (HashMap)hmExpRecords.get(i);
							delv_qty = delv_qty + Integer.parseInt((String)hmQty.get("DELV_QTY"));
						}
						result = true;
						flag = ""+delv_qty ; 
						}
					else
						result = false;	
				}else{
					hmExpRecords1 = bean.getBatchDetailsData(bean.getDoc_no(),item_code,po_no,delv_date,request_no);
					System.out.println("hmExpRecords1 in validate = "+hmExpRecords1);
						if(hmExpRecords1 != null){
							if(hmExpRecords1.size() > 0 )  {
							int delv_qty = 0;
								for(int i=0;i<hmExpRecords1.size();i++){
								HashMap hmQty = (HashMap)hmExpRecords1.get(i);
								delv_qty = delv_qty + Integer.parseInt((String)hmQty.get("DELV_QTY"));
								}
								
								result = true;
								flag = ""+delv_qty ; 
							}	
							else
								result = false;	
						}else{
							result = false;	
						}
				}	
				
				
				}catch (Exception exception) {
					exception.printStackTrace();

					if (exception.getMessage().equals("RECORD_ALREADY_EXISTS"))
						throw exception;
					if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED"))
						throw exception;

					throw new Exception("REQ_ON_ITEM_STORE_NOT_FOUND");
				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		} 
		
		else if (functionType.equals("MODIFYMODE")){
				java.util.HashMap addResult = bean.addDetailRecordModifyMode(hash);				
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}else if(functionType.equals("EDITING")){
			// bean.updateBlockedAmount();
			java.util.HashMap addResult = bean.addDetailRecord(hash);
			System.out.println("addResult in editing"+addResult);
			System.out.println("bean.getItemKeys() in po list = "+bean.getItemKeys());
			out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
			putObjectInBean(bean_id,bean,request);
		}
		
		else if(functionType.equals("UPDATECHECKSTATUS")){
                ArrayList alItemKeys = new ArrayList();

				for(int i=0;i<bean.getItemKeys().size();i++) {
			      alItemKeys.add(bean.getItemKeys().get(i));	
		         } 
				
				java.util.ArrayList newKeys = bean.getItemKeysAdded();

				if (newKeys != null && newKeys.size() >0) {
					alItemKeys.addAll(newKeys);
				}

				HashMap hmItemStore = (HashMap)bean.getHmItemDetail();
				System.out.println("hmItemStore in validate= "+hmItemStore);
				String itemStoreKey = "";

				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize = alItemKeys.size();
					DeliveryOrderDetailBean detailBean;
					for (int i=0;	i<totalSize;	i++){
						itemStoreKey = (String) alItemKeys.get(i);
						detailBean = (DeliveryOrderDetailBean)hmItemStore.get(itemStoreKey);
						if(itemStoreKey.equals(stitem_code)){
							
							detailBean.setCheck_box_status(check_status);
                            hmItemStore.remove(itemStoreKey);
                            hmItemStore.put(itemStoreKey,detailBean);
                            bean.setHmItemDetail(hmItemStore);
						
							break ;
						}

					}//end of For loop
				}//end of if condition
              
		}
		else if(functionType.equals("LOAD_DETAILS_NEW")){	
			try{
			String loc_batch_string = (String)hash.get("loc_batch_string");
			String tran_currency_temp		  =	   bean.checkForNull(request.getParameter("tran_currency_temp"));
			System.out.println("loc_batch_string---492--->"+loc_batch_string);

			loc_batch_string = loc_batch_string.substring(2,loc_batch_string.length());

			StringTokenizer stListItems=new StringTokenizer(loc_batch_string,"||");

			ArrayList podetails = null;
			HashMap podtl = null;

			 while (stListItems.hasMoreTokens()) {

			   StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),";");
			  
			   String req_no =  stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String item_code = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   //String order_qty = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String delv_date = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String request_no = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
		 //    String itemcode_reqno = item_code +""+ req_no;
				String itemcode_reqno = item_code +""+ req_no+""+delv_date+""+request_no;

			   podetails = bean.getPoItemDetails(req_no);

			   System.out.println("podetails---508--->"+podetails);


				for(int i =0 ;i<podetails.size();i++){
					podtl = (HashMap)podetails.get(i);
					
					//if((podtl.get("ITEM_CODE")).equals(item_code) &&  (podtl.get("PO_NO")).equals(req_no) && (podtl.get("DELV_DATE")).equals(delv_date)){					
					if((podtl.get("ITEM_CODE")).equals(item_code) &&  (podtl.get("PO_NO")).equals(req_no) && (podtl.get("DELV_DATE")).equals(delv_date) && ( bean.checkForNull((String)podtl.get("REQ_NO"))).equals(request_no)){					
					//podtl.put("ORDER_QTY",order_qty);
					podtl.put("ITEMCODE_REQNO",itemcode_reqno);
					podtl.put("editing","1");	
					String tran_currency = (String)podtl.get("TRANS_CURRENCY");
					System.out.println("tran_currency_temp in validate = "+tran_currency_temp);
					System.out.println("tran_currency in validate = "+tran_currency);
					ArrayList t_curr = new ArrayList();
					t_curr.add(tran_currency_temp);
					if( tran_currency_temp != "" && !tran_currency_temp.equals(tran_currency)){
						tran_currency_temp = tran_currency;
					}
					if( t_curr.contains(tran_currency)){
					}else{
						bean.setReqKeys(new ArrayList());
						System.out.println("bean.getReqKeys = "+bean.getReqKeys());
						
					}
					HashMap addResult =	bean.addDetailRecordNew(podtl);
					addResult.put("flag",tran_currency);
					out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \""+addResult.get("flag")+"\");");

					}
				}   
		   }			
			
			putObjectInBean(bean_id,bean,request);
			}
			catch(Exception e){
			throw e;
			}
		} else if(functionType.equals("MM_UOM")){

			String def_uom_code = (String)bean.fetchRecord("select gen_uom_code from mm_item where item_code= ?" ,bean.checkForNull(stitem_code)).get("GEN_UOM_CODE");

			//out.println("document.formDeliveryOrderDetail.uom.value='"+bean.checkForNull(def_uom_code)+"'");
			
			out.println("document.formDeliveryOrderDetail.delivery_uom.value='"+bean.checkForNull(def_uom_code)+"'");
			
			out.println("clearListItems('formDeliveryOrderDetail.delivery_uom'); ");
			ArrayList equl_uom_code = bean.getUOMLists(stitem_code,def_uom_code);
			HashMap record = new HashMap();
			for(int i=0; i< equl_uom_code.size(); i++) {
				record = (HashMap)equl_uom_code.get(i);
				out.println("addListItem(\"formDeliveryOrderDetail.delivery_uom\", \"" + record.get("EQVL_UOM_CODE") + "\",\"" + record.get("SHORT_DESC") + "\",\"" +def_uom_code+ "\");");
			}
			
			//out.println("document.getElementById("temp_uom_code").value='"+bean.checkForNull(def_uom_code)+"'");
			
			out.println("document.getElementById('temp_delv_uom_code').value='"+bean.checkForNull(def_uom_code)+"'");
			
					
			HashMap hmRecord = bean.getUomDesc(def_uom_code);
			if(hmRecord.size()>0){
				uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
		
			//out.println("document.getElementById("temp_uom").value = '" +  uom_desc +"'; ");
			
			out.println("document.getElementById('temp_delv_uom_desc').value = '" +  uom_desc +"'; ");
			
			out.println("checkUOMConvFactor();");

		} else if (functionType.equals("PRINTONLINEDOC")){
			try{
			
			ArrayList doc_no=bean.getPrintDocNo();
			System.out.println("doc_no====>386 jsp"+doc_no);
			String pdocno = "";
			for(int i=0;i<doc_no.size();i++){
				pdocno=(String)doc_no.get(i);
				bean.doOnlineReportPrinting(pdocno,request,response);	
			}
			}catch(Exception e){
					e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}else if(functionType.equals("CHECKFORAUTHORIZE"))
		{
			String request_by_pu = (String) hash.get("request_by_pu");
			if (request_by_pu != null && request_by_pu.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			System.out.println("request_by_pu==>"+request_by_pu);
			java.util.HashMap resultMap = bean.canAuthorize();
			System.out.println("resultMap==>"+resultMap);
			if (resultMap != null) {
				String authorize = (String)resultMap.get("DO_APPROVE_ALLOWED_YN");  
				System.out.println("authorize==>"+authorize);
				if(authorize != null && authorize != ""){	
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
				}else{
					authorize = "No";
				}
				out.println("setAuthorize('"+authorize+"');");
				
			}
		}
		else if(functionType.equals("DOCNO_ENABLE_YN")) {
			
			String purchase_unit				=		request.getParameter("purchase_unit");			
			System.out.println("purchase_unit=>"+purchase_unit);
			HashMap hashRecord = bean.fetchRecord("SELECT PO_DOC_NO_GEN_METHOD FROM PO_DOCNO_CONTROL");

			String doc_no_md = bean.checkForNull((String) hashRecord.get("PO_DOC_NO_GEN_METHOD"));
			System.out.println("doc_no_md=>"+doc_no_md);

			if(doc_no_md.equals("A")){
			out.println("document.formPurchaseOrderHeader.doc_no.disabled=true");
			out.println("document.formPurchaseOrderHeader.autono_yn.value='Yes'");
			}else{
			out.println("document.formPurchaseOrderHeader.doc_no.disabled=false");
			out.println("document.formPurchaseOrderHeader.autono_yn.value='No'");
			}	
				
		}
		else if(functionType.equals("CHECK_REQ_KEY")){
			
			try{
				System.out.println("bean.getReqKeys() = "+bean.getReqKeys());
				if(bean.getReqKeys().size() > 0){
					result=true;
			    }else{
					result = false;
				}
			}catch (Exception exception) {
			result		=	false;
			message		=	exception.getMessage();
			exception.printStackTrace();
		}finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		}
	else  if(functionType.equals("CHECKUOMCONVFACTOR")) {

			
		try{
			try { 
				//String uom_code		= request.getParameter("uom");
				String pur_uom_code = request.getParameter("pur_uom_code");
				String item_code = request.getParameter("item_code");
				//Added and passed gen_uom_code to uom_code by suresh.r on 11-03-2015 against ML-BRU-SCF-1476(Inc 52684),ML-BRU-SCF-1385.1(Inc 52685)
				uom_code = bean.checkForNull((String)bean.fetchRecord("select gen_uom_code from mm_item where item_code= ?" ,bean.checkForNull(item_code)).get("GEN_UOM_CODE"));
				//System.out.println("UOM_CODE = "+uom_code);
				//System.out.println("pur_uom_code = "+pur_uom_code);
				//System.out.println("item_code = "+item_code);
				//Modified params order uom_code first then pur_uom_code by suresh.r on 11-03-2015 against ML-BRU-SCF-1476(Inc 52684),ML-BRU-SCF-1385.1(Inc 52685)
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code,pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code,pur_uom_code,item_code}).get("COUNT"));
		
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code,pur_uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_code +" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_code;
				String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else if(am_count!=0){				
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code,pur_uom_code}).get("EQVL_VALUE");
				String conver=stEqvl_value+" "+pur_uom_code+" = 1 "+uom_code;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else{
				String stEqvl_value="1";
				String conver="1"+" "+uom_code+" = 1 "+pur_uom_code;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
		
				}
			}catch (Exception exception) {
				exception.printStackTrace();
				
				throw new Exception("NO_CONV_FAC_FOR_REQ_UOM_CODE");
			}
		}catch (Exception exception) {
			result		=	false;
			message		=	exception.getMessage();
			exception.printStackTrace();
		}finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
		
		
%>
<%
putObjectInBean(bean_id,bean,request);
%>
