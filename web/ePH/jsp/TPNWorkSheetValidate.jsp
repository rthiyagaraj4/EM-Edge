<%@page  import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	String func_mode	= request.getParameter("func_mode");
//	out.println("func_mode"+func_mode);
	if (func_mode == null || func_mode.equals(""))
		return;

	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;


	if(func_mode.equals("item_search")) {
		String bean_id		= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");
		TPNWorkSheetBean beanObj	= (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

		String generic_code	= request.getParameter("generic_code");
		String order_id		= request.getParameter("order_id");
		String locn_code	= request.getParameter("locn_code");
		boolean tpn_change_mmoh =false;//Added for ML-MMOH-CRF-1201
		String patient_id ="";//Added for ML-MMOH-CRF-1201

		ArrayList item_list			= beanObj.getItemList(generic_code, order_id, locn_code,tpn_change_mmoh,patient_id);//Added empty strings for ML-MMOH-CRF-1201
		out.println("formTPNWorkSheetDetails.item_count.value=\"" + item_list.size() + "\"");

		if (item_list.size() == 0) {
			out.println("checkItem(\"" + item_list + "\", \"" + locn_code + "\", '1');") ;
		}
		else if (item_list.size() == 1) {
			out.println("checkItem(\"" + item_list + "\", \"" + locn_code + "\", '2');") ;
		}
		else if (1 < item_list.size()) {
			out.println("checkItem(\"" + item_list + "\", \"" + locn_code + "\", '3');") ;
		}
		putObjectInBean(bean_id,beanObj,request);
	}
	/*if(func_mode.equals("checkUOM")) {
		String allocQty		="";
		float disp_qty		=0.0f;
		String bean_id		= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");
		String issueUOM		= request.getParameter("issueUOM");
		String allocUOM	= request.getParameter("allocUOM");
		String Issue_Qty		= request.getParameter("Issue_Qty");
		String alloc_qty	= request.getParameter("alloc_qty");
		String row_num	= request.getParameter("row_num");
		String Eqvl_value="";
		if(Issue_Qty==null) Issue_Qty="";
		if(alloc_qty==null) alloc_qty="";
		if(allocUOM==null) allocUOM="";
		if(issueUOM==null) issueUOM="";
		TPNWorkSheetBean beanObj	= (TPNWorkSheetBean)mh.getBeanObject(bean_id, request , bean_name);
		String Eqvl_value			= beanObj.getAllocQty(issueUOM, allocUOM);
		if(Eqvl_value==null) Eqvl_value="";
		if(!Eqvl_value.equals("")){
			disp_qty=Float.parseFloat(alloc_qty);
			allocQty=String.valueOf(disp_qty);
			}
			else{
			allocQty="";
			}
			out.println("validateVariationPer1('"+row_num+"','"+allocQty+"','"+Eqvl_value+"')");
	}*/
	if(func_mode.equals("check1UOM")) {
		
		String bean_id		= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");
		String issueUOM		= request.getParameter("issueUOM");
		String allocUOM		= request.getParameter("allocUOM");
		String row_num		= request.getParameter("row_num");
		if(allocUOM==null) allocUOM="";
		if(issueUOM==null) issueUOM="";
	
		TPNWorkSheetBean beanObj	= (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);
		String Eqvl_value			= beanObj.getAllocQty(issueUOM, allocUOM);
		if(Eqvl_value==null) Eqvl_value="";
		
		if(!Eqvl_value.equals(""))
			out.println("document.formTPNWorkSheetDetails.Eqvl_value_"+row_num+".value='"+Eqvl_value+"'");
		putObjectInBean(bean_id,beanObj,request);	
	}
	else if(func_mode.equals("batch_dtl")) {
		String bean_id	= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");

		TPNWorkSheetBean beanObj	= (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

		String batch_id		= request.getParameter("batch_id");
		String generic_code	= request.getParameter("generic_code");
		String store_code	= request.getParameter("store_code");
		String order_id		= request.getParameter("order_id");
		String group_code	= request.getParameter("group_code");
		String no=request.getParameter("no");
		
		ArrayList result	= beanObj.getBatchDetail(generic_code, order_id, store_code, batch_id,group_code);
		if(result.size()!=0) {
			out.println("displayQty('"+result.get(0)+"','"+result.get(1)+"','"+no+"')");
		}
		putObjectInBean(bean_id,beanObj,request);
	}
	else if(func_mode.equals("rec_worksheet")) {
		try{
		
		Hashtable rec = null;
		ArrayList hs = new ArrayList(); 
		String bean_id			= "DispMedicationAllStages";
		String bean_name		= "ePH.DispMedicationAllStages";
		DispMedicationAllStages beanObj	= (DispMedicationAllStages)getBeanObject(bean_id,bean_name, request );
		String bean_id1			= "DispMedicationBean" ;
		String bean_name1		= "ePH.DispMedicationBean";
		DispMedicationBean bean_2	= (DispMedicationBean)getBeanObject(bean_id1,bean_name1,request);
		String bean_id2			= "TPNWorkSheetBean" ;
		String bean_name2		= "ePH.TPNWorkSheetBean";
		TPNWorkSheetBean beanTPNWS	= (TPNWorkSheetBean)getBeanObject(bean_id2,bean_name2,request);

		int total				=	Integer.parseInt((String)hash.get("row_count"));
		//ArrayList all_detail	=	new ArrayList();
		ArrayList drug_detail	=	new ArrayList();
		ArrayList TPN_Det		=	new ArrayList();
		String patient_id				= (String)hash.get("patient_id");
		String order_id					= (String)hash.get("order_id");
		String locn_code				= (String)hash.get("locn_code");
		String overage_volume			= (String)hash.get("overage_volume");
		String overage_volume_uom		= (String)hash.get("overage_volume_uom");
		String osmolarity_volume		= (String)hash.get("osmolarity_volume");
		String phsph_item_code			= "";
		String calci_item_code			= "";
		String phsph_alc_qty			= "";
		String calci_alc_qty			= "";
		String phsp_calc_message		= "";

		//float temp;
		double totQty=0;
		String issueUom="";
//		String issueUom1="";
		String item_cost="";
		String Equval_value		= "";
		String issued_stock_qty = "";
		ArrayList orderDetails=bean_2.getOrderLineDetails(patient_id,order_id);
		String end_date=(String)orderDetails.get(7);
		
		for(int i=0; i<total; i++) {
			issued_stock_qty	= "";
			String alloc_qty	=	((String)hash.get("ISSUE_QTY_"+i))==null?"":(String)hash.get("ISSUE_QTY_"+i);
			issued_stock_qty	=	alloc_qty; 
				//String group_code		=	(String)hash.get("CONST_GROUP_CODE_"+i);	
				String item_drug_code	=	(String)hash.get("CONST_GENERIC_CODE_"+i);
				//String Order_qty	=	(String)hash.get("ORDER_QTY_"+i);
				String batch_id			=	(String)(request.getParameter("BATCH_"+i))==null?"":request.getParameter("BATCH_"+i);
				String Pres_Qty			=	((String)hash.get("ALLOC_QTY_"+i))==null?"":(String)hash.get("ALLOC_QTY_"+i);
				String expiry_date		=	(String)(request.getParameter("EXPIRY_DATE_"+i))==null?"":request.getParameter("EXPIRY_DATE_"+i);
				//String qty_uom			=	(String)hash.get("order_uom"+i);
				String item_code		=	(String)hash.get("ITEM_"+i);
				
				if(item_drug_code.equals("PO4")){
					phsph_item_code			= item_code;
					phsph_alc_qty			= Pres_Qty;
				}else if(item_drug_code.equals("Ca")){
					calci_item_code			= item_code;				
					calci_alc_qty			= Pres_Qty;
				}
				
				String trade_id			=	(String)hash.get("trade_id_"+i);
				String bin_locn_code	=	(String)hash.get("bin_locn_code_"+i);
				String allocUom			=   (request.getParameter("ALLOC_QTY_UOM"+i))==null?"":request.getParameter("ALLOC_QTY_UOM"+i);
				issueUom				=   (request.getParameter("QTY_UOM"+i))==null?"":request.getParameter("QTY_UOM"+i);
				String issued_stock_uom	=	((String)hash.get("issued_stock_uom_"+i))==null?"":(String)hash.get("issued_stock_uom_"+i);
				String osmolar_value	=	((String)hash.get("osmolar_value_"+i))==null?"":(String)hash.get("osmolar_value_"+i);

				//if(group_code.equals("MN"))		tpn_qty_uom		=	qty_uom;
			/*all_detail.add(item_drug_code);
			all_detail.add(item_drug_code);
			all_detail.add(alloc_qty);
			all_detail.add(qty_uom);*/
			Equval_value		= ((String)hash.get("Eqvl_value_"+i))==null?"":(String)hash.get("Eqvl_value_"+i);

			if(!alloc_qty.equals("") && !Equval_value.equals("")){
				//issued_stock_qty	= Math.ceil(Float.parseFloat(alloc_qty)/Float.parseFloat(Equval_value))+""; 
			}

			rec = new Hashtable();
			rec.put("ISSUE_QTY_"+i,issued_stock_qty);
			rec.put("concentration_percent_"+i,((String)hash.get("concentration_percent_"+i))==null?"":(String)hash.get("concentration_percent_"+i));
			rec.put("LastDerivedValue"+i,((String)hash.get("LastDerivedValue"+i))==null?"":((String)hash.get("LastDerivedValue"+i)));
			rec.put("manufacture_var_percentage"+i,(String)hash.get("manufacture_var_percentage"+i));
			rec.put("trade_id_"+i,((String)hash.get("trade_id_"+i))==null?"":(String)hash.get("trade_id_"+i));
			rec.put("bin_locn_code_"+i,((String)hash.get("bin_locn_code_"+i))==null?"":(String)hash.get("bin_locn_code_"+i));
			//rec.put("trade_id_"+i,((String)hash.get("trade_id_"+i))==null?"":(String)hash.get("trade_id_"+i));
			rec.put("BATCH_"+i,(batch_id)==null?"":batch_id);
			rec.put("EXPIRY_DATE_"+i,(expiry_date)==null?"":expiry_date);
			rec.put("ALLOC_QTY_"+i,((String)hash.get("ALLOC_QTY_"+i))==null?"":(String)hash.get("ALLOC_QTY_"+i));
			//rec.put("ALLOC_QTY_UOM"+i,((String)hash.get("ALLOC_QTY_UOM"+i))==null?"":(String)hash.get("ALLOC_QTY_UOM"+i));
			rec.put("ITEM_"+i,((String)hash.get("ITEM_"+i))==null?"":(String)hash.get("ITEM_"+i));
			rec.put("LastDerivedValue"+i,((String)hash.get("LastDerivedValue"+i))==null?"":(String)hash.get("LastDerivedValue"+i));
			rec.put("ALLOC_QTY_UOM"+i,allocUom);
			rec.put("QTY_UOM"+i,issueUom);
			rec.put("osmolar_value_"+i,osmolar_value);

			hs.add(rec);
			
		
//			if(!alloc_qty.equals("")||!Pres_Qty.equals("")) {
			if(!issued_stock_qty.equals("")||!Pres_Qty.equals("")) {
				
					TPN_Det.add(order_id);
					TPN_Det.add("1");
					TPN_Det.add(item_drug_code);
					TPN_Det.add(Pres_Qty);
					TPN_Det.add(allocUom);
					TPN_Det.add(item_code);
					TPN_Det.add(issued_stock_qty);
					TPN_Det.add(issueUom);
					TPN_Det.add(batch_id);
					TPN_Det.add(expiry_date);
					TPN_Det.add(trade_id);
					TPN_Det.add(bin_locn_code);
					TPN_Det.add(alloc_qty);
					TPN_Det.add(issued_stock_uom);
					if(!alloc_qty.equals("")){
					totQty+=Double.parseDouble(alloc_qty);
					}
				/*	if(!issued_stock_qty.equals("")){
						totQty+=new Float(Math.ceil(Float.parseFloat(issued_stock_qty))).intValue();
					}*/

					
//					issueUom1			=   (request.getParameter("QTY_UOM"+i))==null?"":request.getParameter("QTY_UOM"+i);
								
				 //  if (drug_detail.indexOf(item_code) == -1){
					   if(!item_code.equals("")){
							/* To Calculate the item cost */
//							item_cost= bean_2.getItemCost(item_code, locn_code, alloc_qty, end_date);
							item_cost= bean_2.getItemCost(item_code, locn_code, issued_stock_qty, end_date);
						
							drug_detail.add(item_code);
							drug_detail.add(batch_id);
							drug_detail.add(expiry_date);
							drug_detail.add(issued_stock_qty);
							drug_detail.add(issued_stock_uom);
							drug_detail.add("");
							drug_detail.add(trade_id);
							drug_detail.add(bin_locn_code);
							drug_detail.add(item_cost);
							drug_detail.add(issued_stock_uom);//Added for[IN:049778]
						}
				  /* }else{
//						if(!alloc_qty.equals("")){
						if(!issued_stock_qty.equals("")){
							 //temp=Float.parseFloat((String)drug_detail.get(drug_detail.indexOf(item_code)+3))+Float.parseFloat(alloc_qty);
							 temp=Float.parseFloat((String)drug_detail.get(drug_detail.indexOf(item_code)+3))+Float.parseFloat(issued_stock_qty);
							 
							 drug_detail.set(drug_detail.indexOf(item_code)+3,temp+"");			
//							 item_cost= bean_2.getItemCost(item_code, locn_code, alloc_qty, end_date);
							item_cost= bean_2.getItemCost(item_code, locn_code, issued_stock_qty, end_date);
							 temp=Float.parseFloat((String)drug_detail.get(drug_detail.indexOf(item_code)+8))+Float.parseFloat(item_cost);
							 drug_detail.set(drug_detail.indexOf(item_code)+8,temp+"");
						}	
					
				   }*/
		}
		
	}

beanObj.setOsmolarityVol(osmolarity_volume);
beanObj.setOverageVol(overage_volume);
beanObj.setOverageVolUom(overage_volume_uom);
beanObj.setTPNValues(drug_detail);
beanObj.setDrugDetail(patient_id,order_id,"1",drug_detail);
beanObj.setDrugQuantity(patient_id,order_id,"1",totQty);
beanObj.setTPNDetails(TPN_Det);
beanObj.setTPNQty(String.valueOf(totQty));
beanObj.setTPNQtyUOM(overage_volume_uom);
	
	bean_2.setPrevWorkSheetDetails(hs);

	if(!phsph_item_code.equals("") &&  !calci_item_code.equals("")){
		phsp_calc_message	= beanTPNWS.getPhCaMessage(phsph_alc_qty,calci_alc_qty);
		
		if(!phsp_calc_message.equals("")){
			out.println("showPhCaAlert('"+phsp_calc_message+"')");
		}
	}
	putObjectInBean(bean_id,beanObj,request);
	putObjectInBean(bean_id1,bean_2,request);
		}catch(Exception e){
			e.printStackTrace();
		}
	}else if(func_mode.equals("concenPer")) {
		ArrayList returnVals= new ArrayList();

	

		String bean_id		= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");
		TPNWorkSheetBean beanObj	= (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

		
		String generic_code	= request.getParameter("generic_code");
		String item_code=request.getParameter("item_code");
		String num=request.getParameter("num")==null?"":request.getParameter("num");
		String item_concentration_percent="";//Added for ML-MMOH-CRF-1201
		String item_volume ="";//Added for ML-MMOH-CRF-1201
		ArrayList itemvalues			= new ArrayList();//Added for ML-MMOH-CRF-1201
		
		returnVals	= beanObj.getConcentrationPercentage(generic_code, item_code);
		
		
		if(returnVals !=null && returnVals.size()>0 ) {
		float cp= ((Float)returnVals.get(0)).floatValue();
		float vp=((Float)returnVals.get(1)).floatValue();
		String stock_uom=(String)returnVals.get(2);
		 
		  if ( cp > 0){	
			out.println("document.formTPNWorkSheetDetails.concentration_percent_"+num+".value="+cp);
			out.println("document.formTPNWorkSheetDetails.manufacture_var_percentage"+num+".value="+vp);
		  }else{
			out.println("document.formTPNWorkSheetDetails.concentration_percent_"+num+".value=''");
			out.println("document.formTPNWorkSheetDetails.manufacture_var_percentage"+num+".value=''");
		  }
			out.println("document.formTPNWorkSheetDetails.issued_stock_uom_"+num+".value='"+stock_uom+"'");
//			out.println("document.getElementById("QTY_UOM")"+num+".innerText='"+stock_uom+"'");
		}else{
			out.println("document.formTPNWorkSheetDetails.concentration_percent_"+num+".value=''");
			out.println("document.formTPNWorkSheetDetails.manufacture_var_percentage"+num+".value=''");
			out.println("document.getElementById('QTY_UOM'+num).innerText=''");
			out.println("document.formTPNWorkSheetDetails.ISSUE_QTY_"+num+".value=''");
			out.println("document.formTPNWorkSheetDetails.ALLOC_QTY_"+num+".value=''");
			out.println("document.getElementById('ALLOC_QTY_UOM'+num).innerText=''");
		}
		String osmolor_value = beanObj.getOsmolarityValue(generic_code, item_code);
			if(!osmolor_value.equals("")){
				out.println("document.getElementById('osmolar_value_lb_'+num).innerText="+osmolor_value);
				out.println("document.formTPNWorkSheetDetails.osmolar_value_"+num+".value="+osmolor_value);
			}
			//Adding start for ML-MMOH-1201
		 itemvalues = beanObj.getItemValues(generic_code,item_code);
		System.err.println("itemvalues.size()===="+itemvalues.size());
				if(itemvalues !=null && itemvalues.size()>0 ) {
					//System.err.println("(String)itemvalues.get(k)@@@==="+(String)itemvalues.get(k));
					  item_concentration_percent =(String)itemvalues.get(0)==null?"1":(String)itemvalues.get(0);
					  item_volume =(String)itemvalues.get(1)==null?"1":(String)itemvalues.get(1);
				   }
				 
			  out.println("document.formTPNWorkSheetDetails.item_concentration_percent_"+num+".value="+item_concentration_percent);
			  out.println("document.formTPNWorkSheetDetails.item_volume_"+num+".value="+item_volume);
			    System.err.println("item_concentration_percent===="+item_concentration_percent+"item_volume==="+item_volume);
//Adding end for ML-MMOH-CRF-1201
	putObjectInBean(bean_id,beanObj,request);	
	}

	else if(func_mode.equals("Issue_Qty")) {
		String result		="";
		String bean_id		= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");
		String order_id		= request.getParameter("order_id");
		//String row_count	= request.getParameter("row_count");
		String item_code	= request.getParameter("item_code");
		String Issue_Qty	= request.getParameter("Issue_Qty");
		String calculate_for	= request.getParameter("calculate_for");
		String no			=request.getParameter("no");
		String CONST_GENERIC_CODE	= request.getParameter("CONST_GENERIC_CODE");
		String concentration_percent	= request.getParameter("concentration_percent");
		String ALLOC_QTY_UOM	= request.getParameter("ALLOC_QTY_UOM");
		String ORDER_QTY	= request.getParameter("ORDER_QTY");
		if(Issue_Qty==null) Issue_Qty="";
		if(calculate_for==null) calculate_for="";
			
	TPNWorkSheetBean bean = (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

result =bean.getIssueQty(order_id,item_code,CONST_GENERIC_CODE,ALLOC_QTY_UOM,concentration_percent,ORDER_QTY,Issue_Qty,calculate_for);

	ArrayList OtherPrescQty =new ArrayList();
	int srlNo;
	float othPresQt=0.0f;
	if(result!=null && !result.equals("")) {
		
		
		

		if(calculate_for.equals("")){
			StringTokenizer st = new StringTokenizer(result,"$");
			result = st.nextToken();
			String unit=st.nextToken();
		
			out.println("document.formTPNWorkSheetDetails.ISSUE_QTY_"+no+".value="+result);
			out.println("document.formTPNWorkSheetDetails.issued_stock_uom_"+no+".value='"+unit+"'");
		//	out.println("document.getElementById("QTY_UOM")"+no+".innerText='"+unit+"'");

		}
		else{
			OtherPrescQty = bean.getOthrerPrescQty();
			out.println("document.formTPNWorkSheetDetails.ALLOC_QTY_"+no+".value="+result);
			out.println("document.getElementById('ALLOC_QTY_UOM'+no).innerText=document.getElementById('ALLOC_QTY_UOM_'+no).innerText;");
			for(int i=0;i<OtherPrescQty.size();i+=2){
			srlNo=	(((Integer)OtherPrescQty.get(i)).intValue());
			othPresQt=((Float)OtherPrescQty.get(i+1)).floatValue();
			
			out.println("document.getElementById('ALLOC_QTY_UOM'+no).innerText=document.getElementById('ALLOC_QTY_UOM_'+no).innerText;");
			out.println("document.getElementById('ALLOC_QTY_UOM'+srlNo).innerText=document.getElementById('ALLOC_QTY_UOM_'+srlNo).innerText;");
			out.println("if (document.formTPNWorkSheetDetails.ALLOC_QTY_"+srlNo+".value=='') document.formTPNWorkSheetDetails.ALLOC_QTY_"+srlNo+".value=0;document.formTPNWorkSheetDetails.ALLOC_QTY_"+srlNo+".value=parseInt(document.formTPNWorkSheetDetails.ALLOC_QTY_"+srlNo+".value)+"+othPresQt+"-parseInt(document.formTPNWorkSheetDetails.LastDerivedValue"+no+".value)");
			out.println("document.formTPNWorkSheetDetails.ISSUE_QTY_"+srlNo+".disabled=true");
			out.println("document.formTPNWorkSheetDetails.LastDerivedValue"+no+".value="+result);
			out.println("validateVariationPer("+no+","+srlNo+");");
			}

			}
			
		}
		putObjectInBean(bean_id,bean,request);
	} else if(func_mode.equals("Presc_Qty")) {

		String result		="";
		String bean_id		= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");
		String order_id		= request.getParameter("order_id");
		String item_code	= "";
		String Issue_Qty	= "";
		String calculate_for	= request.getParameter("calculate_for");
		//String no			=request.getParameter("no");
		String CONST_GENERIC_CODE	= "";
		String concentration_percent	= "";
		String ALLOC_QTY_UOM	= "";
		String ORDER_QTY	= "";
		if(Issue_Qty==null) Issue_Qty="";
		if(calculate_for==null) calculate_for="";
		ArrayList OtherPrescQty = new ArrayList();
		ArrayList ElAlocValues  = new ArrayList();
		int srlNo;
		float othPresQt=0.0f;
		String prv_value="";
		TPNWorkSheetBean bean = (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);
		for(int ini=0;ini<10;ini++){
		   ElAlocValues.add("");
		}	

		for(int ElNum=3;ElNum<=9;ElNum++){
			item_code				= (String)hash.get("ITEM_"+ElNum);
			Issue_Qty				= (String)hash.get("ISSUE_QTY_"+ElNum);
			CONST_GENERIC_CODE		= (String)hash.get("CONST_GENERIC_CODE_"+ElNum);
			concentration_percent	= (String)hash.get("concentration_percent_"+ElNum);
			ALLOC_QTY_UOM			= (String)hash.get("ALLOC_QTY_UM_"+ElNum);
			ORDER_QTY				= (String)hash.get("OVERAGE_ORDER_QTY_"+ElNum);

			if(!item_code.equals("")){
				result =bean.getIssueQty(order_id,item_code,CONST_GENERIC_CODE,ALLOC_QTY_UOM,concentration_percent,ORDER_QTY,Issue_Qty,calculate_for);


				if(!result.equals("")){
				   OtherPrescQty = bean.getOthrerPrescQty();

				   prv_value = (String)ElAlocValues.get(ElNum-1);
				   if(!prv_value.equals("")){
					   prv_value = (Float.parseFloat(prv_value)+Float.parseFloat(result))+"";
					   result = prv_value+"";
				   }

				   ElAlocValues.set(ElNum-1,result);
				   		for(int opq=0;opq<OtherPrescQty.size();opq+=2){
							srlNo		= (((Integer)OtherPrescQty.get(opq)).intValue());
							othPresQt	= ((Float)OtherPrescQty.get(opq+1)).floatValue();
				   prv_value = (String)ElAlocValues.get(srlNo-1);
				   if(!prv_value.equals("")){
					   othPresQt = Float.parseFloat(prv_value)+othPresQt;
				   }

							ElAlocValues.set(srlNo-1,othPresQt+"");
						}
				}
			}	
		}

	for(int alVal=3;alVal<=9;alVal++){

		String aloc_value  = (String)ElAlocValues.get(alVal-1);

		if(!aloc_value.equals("")){
			out.println("setAllocValues("+alVal+","+aloc_value+");");
		//	out.println("validateVariationPer("+alVal+");");
		}else{
			aloc_value = "0";
			out.println("setAllocValues("+alVal+","+aloc_value+");");
		}
	}
	
		putObjectInBean(bean_id,bean,request);
	}else if(func_mode.equals("GET_BL_DET")) {
		String bean_id			             = "DispMedicationAllStages";
		String bean_name		             = "ePH.DispMedicationAllStages";
		DispMedicationAllStages beanObj	     = (DispMedicationAllStages)getBeanObject(bean_id,bean_name, request );

		String	bean_id_1					=	"DispMedicationBean" ;
	    String	bean_name_1					=	"ePH.DispMedicationBean";
	    DispMedicationBean bean_1			=  (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
		//bean_1.setLanguageId(locale);

		StringBuffer batch_str				= new StringBuffer();
		//StringBuffer gross_charge_display_str   = new StringBuffer();
		//StringBuffer pat_charge_display_str     = new StringBuffer();
		String decimalFormatString			=  "";
		float gross_charge_amount           =  0;
		float groos_pat_payable             =  0;
		String gross_charge_amount_str		=  "";
	    String groos_pat_payable_str		=  "";
		String tot_gross_charge_amount_str	=  "";
	    String tot_groos_pat_payable_str	=  "";	
		String patient_id                   =  (String)hash.get("patient_id");  
		String encounter_id				    =	bean_1.getEncounterID();
		String sal_trn_type                 =   beanObj.getEncounterPatientClass(encounter_id, patient_id);//I-->Inpatient O-->OutPatient R-->Referral E-->Emergency D-->Daycare // patient_id for getEncounterPatientClass added for [IN:035667] 
		String item_code					=   (String)hash.get("item_code");   
		String issue_qty                    =   (String)hash.get("issue_qty");       
		String trade_id                     =   (String)hash.get("trade_id"); 
		String batch_id                     =   (String)hash.get("batch_id"); 
		String exp_date                     =   (String)hash.get("exp_date"); 
		String bin_loc_code                 =   (String)hash.get("bin_loc_code"); 
	    String sysdate						=    bean_1.getTodaysDate();
		String Store_code                   =	(String)hash.get("Store_code");  
		String order_id                     =   (String)hash.get("order_id"); 
		String disp_stage				    = 	 bean_1.getDispStage();
        double issued_qty                   =   Double.parseDouble(issue_qty);
		String rec_no                       =   (String)hash.get("rec_no");
		String tot_gross_charge_amount      =   (String)hash.get("tot_gross_charge_amount");
		String tot_groos_pat_payable        =   (String)hash.get("tot_groos_pat_payable");
		String old_gross_charge_amount      =   (String)hash.get("old_gross_charge_amount");
		String old_groos_pat_payable        =   (String)hash.get("old_groos_pat_payable");
		String dischargeIND        =   (String)hash.get("dischargeIND");
	    batch_str.append(trade_id).append(";").append(batch_id).append(";").append(exp_date).append(";").append(bin_loc_code).append(";").append(issued_qty+"").append(";");


        HashMap  chareg_det  = (HashMap)beanObj.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,item_code,issued_qty,batch_str.toString(),sysdate,Store_code,"","",order_id,"1",disp_stage,dischargeIND);
	    String err_msg   =(String)chareg_det.get("error_msg");

		decimalFormatString         = (String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
		DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
         if(err_msg.equals("")){
				
				if(!chareg_det.get("grosschargeamt").equals("null")){
					 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
				}
				if(!chareg_det.get("patnetamt").equals("null")){
					groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
				}
				 gross_charge_amount_str  = dfTest.format(gross_charge_amount);
				 groos_pat_payable_str    = dfTest.format(groos_pat_payable);

            if(!tot_gross_charge_amount.equals("")&&!tot_groos_pat_payable.equals("")){
               float tot_gross_charge_amt = 0;
			   float tot_pat_payable_amt  = 0;
			   if(!old_gross_charge_amount.equals("")&&!old_groos_pat_payable.equals("")){

			        tot_gross_charge_amt = Float.parseFloat(tot_gross_charge_amount) - Float.parseFloat(old_gross_charge_amount);
			        tot_pat_payable_amt  = Float.parseFloat(tot_groos_pat_payable) - Float.parseFloat(old_groos_pat_payable);
			   }else{

                    tot_gross_charge_amt = Float.parseFloat(tot_gross_charge_amount);
					tot_pat_payable_amt  = Float.parseFloat(tot_groos_pat_payable);
			   }
					 tot_gross_charge_amt = tot_gross_charge_amt + Float.parseFloat(gross_charge_amount_str);

					 tot_pat_payable_amt  = tot_pat_payable_amt  + Float.parseFloat(groos_pat_payable_str);

					 tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amt);
					 tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);
			}
            if(tot_gross_charge_amount.equals("")&&tot_groos_pat_payable.equals("")){

                    tot_gross_charge_amount_str = gross_charge_amount_str;
                    tot_groos_pat_payable_str   = groos_pat_payable_str ;
			}			
         }else{
               if(old_gross_charge_amount.equals(""))
				       old_gross_charge_amount ="0";
			   if(old_groos_pat_payable.equals(""))
				       old_groos_pat_payable ="0";
              //if(!tot_gross_charge_amount.equals("")&&!old_gross_charge_amount.equals("")&&!tot_groos_pat_payable.equals("")&&!old_groos_pat_payable.equals("")){
			  if(!tot_gross_charge_amount.equals("")&&!tot_groos_pat_payable.equals("")){
               
			   
			    float tot_gross_charge_amt   = Float.parseFloat(tot_gross_charge_amount) - Float.parseFloat(old_gross_charge_amount);
			
			    float tot_pat_payable_amt    = Float.parseFloat(tot_groos_pat_payable) - Float.parseFloat(old_groos_pat_payable);               
				tot_gross_charge_amount_str  = dfTest.format(tot_gross_charge_amt);
				tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);
			  }


		 }

        out.println("setBillingAmounts('"+rec_no+"','"+gross_charge_amount_str+"','"+groos_pat_payable_str+"','"+err_msg+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"','"+java.net.URLEncoder.encode(decimalFormatString)+"');");

		putObjectInBean(bean_id,beanObj,request);
	}else if(func_mode.equals("RE_CAL_BL_DET")) {
		

			
		//String decimalFormatString			=  "";		
		String tot_gross_charge_amount_str	=  "";
	    String tot_groos_pat_payable_str	=  "";	
		String tot_gross_charge_amount      =   (String)hash.get("tot_gross_charge_amount");
		String tot_groos_pat_payable        =   (String)hash.get("tot_groos_pat_payable");
		String old_gross_charge_amount      =   (String)hash.get("old_gross_charge_amount");
		String old_groos_pat_payable        =   (String)hash.get("old_groos_pat_payable");
        String decimal_format_string        =   java.net.URLDecoder.decode(((String)hash.get("decimal_format_string")),"UTF-8");

				
		DecimalFormat dfTest        = new DecimalFormat(decimal_format_string);
	

		  if(!tot_gross_charge_amount.equals("")&&!old_gross_charge_amount.equals("")&&!tot_groos_pat_payable.equals("")&&!old_groos_pat_payable.equals("")){
		   
		   
			float tot_gross_charge_amt   = Float.parseFloat(tot_gross_charge_amount) - Float.parseFloat(old_gross_charge_amount);
		
			float tot_pat_payable_amt    = Float.parseFloat(tot_groos_pat_payable) - Float.parseFloat(old_groos_pat_payable);               
			tot_gross_charge_amount_str  = dfTest.format(tot_gross_charge_amt);
			tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);
		  }else if(!tot_gross_charge_amount.equals("")&&!tot_groos_pat_payable.equals("")){
               tot_gross_charge_amount_str    = tot_gross_charge_amount;
			   tot_groos_pat_payable_str	  = tot_groos_pat_payable;
		  }



        out.println("setREcalcultedBillDet('"+tot_groos_pat_payable_str+"','"+tot_gross_charge_amount_str+"');");

	}else if(func_mode.equals("checkPrecipate")) {

		String sel_const_no				= request.getParameter("no");
		String sel_CONST_GENERIC_CODE	= request.getParameter("CONST_GENERIC_CODE");
		String sel_ALLOC_QTY			= request.getParameter("ALLOC_QTY");
		String ovrge_ordrd_volume		= request.getParameter("ovrge_ordrd_volume");

		String item_code				= "";
		String Issue_Qty				= "";
		String CONST_GENERIC_CODE		= "";
		String ALLOC_QTY				= "";
		String ALLOC_QTY_UOM			= "";
		String ORDER_QTY				= "";
		String precip_mesg				= "";

		float const_generic_vol_factor	= 0;
		float const1_min	= 0;
		float const1_max	= 0;
		float const2_min	= 0;
		float const2_max	= 0;

		String bean_id		= request.getParameter("bean_id");
		String bean_name	= request.getParameter("bean_name");

		TPNWorkSheetBean beanObj	= (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

		HashMap	molecule_codes	 = (HashMap)beanObj.getmoleculeCodes();
		HashMap	const_precp_info = (HashMap)beanObj.getConstGenericsPreciptMsgs();
		ArrayList constPrecpMsgs = null;
				
		for(int ElNum=3;ElNum<=9;ElNum++){
			constPrecpMsgs = new ArrayList();
			item_code				= (String)hash.get("ITEM_"+ElNum);
			Issue_Qty				= (String)hash.get("ISSUE_QTY_"+ElNum);
			CONST_GENERIC_CODE		= (String)hash.get("CONST_GENERIC_CODE_"+ElNum);
			ALLOC_QTY				= (String)hash.get("ALLOC_QTY_"+ElNum);
			ALLOC_QTY_UOM			= (String)hash.get("ALLOC_QTY_UM_"+ElNum);
			ORDER_QTY				= (String)hash.get("OVERAGE_ORDER_QTY_"+ElNum);		
			if((item_code != null && !item_code.equals("")) && !sel_CONST_GENERIC_CODE.equals(CONST_GENERIC_CODE)){
				constPrecpMsgs = (ArrayList)const_precp_info.get(CONST_GENERIC_CODE);
				if(constPrecpMsgs != null && constPrecpMsgs.size()>0){
					for(int i=0;i<constPrecpMsgs.size();i=i+14){
						const_generic_vol_factor	= 0;
						const1_min	= 0;
						const1_max	= 0;
						const2_min	= 0;
						const2_max	= 0;

						if((constPrecpMsgs.get(i).equals(sel_CONST_GENERIC_CODE)) && (constPrecpMsgs.get(i+2).equals(CONST_GENERIC_CODE)) && (constPrecpMsgs.get(i+4).equals(molecule_codes.get(sel_CONST_GENERIC_CODE))) && (constPrecpMsgs.get(i+5).equals(molecule_codes.get(CONST_GENERIC_CODE))) && (constPrecpMsgs.get(i+10).equals(ALLOC_QTY_UOM))){
						

							const_generic_vol_factor = Float.parseFloat(ovrge_ordrd_volume)/Float.parseFloat((String)constPrecpMsgs.get(i+11));
							
							const1_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+6));
							const1_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+7));

							const2_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+8));
							const2_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+9));

							if(((Float.parseFloat(sel_ALLOC_QTY) >= const1_min) && (Float.parseFloat(sel_ALLOC_QTY) <= const1_max)) && ((Float.parseFloat(ALLOC_QTY) >= const2_min) && (Float.parseFloat(ALLOC_QTY) <= const2_max))){
								if(!precip_mesg.equals("")){
									precip_mesg = precip_mesg +"||";
								}
								precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+12);
								precip_mesg = precip_mesg + "$";
								precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+1);
								precip_mesg = precip_mesg + "$";
								precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+3);
								precip_mesg = precip_mesg + "$";
								precip_mesg = precip_mesg +(String)constPrecpMsgs.get(i+13);

							}

						}
						else if((constPrecpMsgs.get(i).equals(CONST_GENERIC_CODE)) && (constPrecpMsgs.get(i+2).equals(sel_CONST_GENERIC_CODE))	&& (constPrecpMsgs.get(i+4).equals(molecule_codes.get(CONST_GENERIC_CODE))) && (constPrecpMsgs.get(i+5).equals(molecule_codes.get(sel_CONST_GENERIC_CODE))) && (constPrecpMsgs.get(i+10).equals(ALLOC_QTY_UOM))){


							const_generic_vol_factor = Float.parseFloat(ovrge_ordrd_volume)/Float.parseFloat((String)constPrecpMsgs.get(i+11));
							const1_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+6));
							const1_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+7));

							const2_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+8));
							const2_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+9));

							if(((Float.parseFloat(ALLOC_QTY) >= const1_min) && (Float.parseFloat(ALLOC_QTY) <= const1_max)) && ((Float.parseFloat(sel_ALLOC_QTY) >= const2_min) && (Float.parseFloat(sel_ALLOC_QTY) <= const2_max))){
								if(!precip_mesg.equals("")){
									precip_mesg = precip_mesg +"||";
								}
								precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+12);
								precip_mesg = precip_mesg + "$";
								precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+1);
								precip_mesg = precip_mesg + "$";
								precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+3);
								precip_mesg = precip_mesg + "$";
								precip_mesg = precip_mesg +(String)constPrecpMsgs.get(i+13);


							}
						}
					}
				}
			}
		}

		if(!precip_mesg.equals("")){
			out.println("showPrecipMessage(\""+precip_mesg+"\",\""+sel_const_no+"\")"); 
		}
	}else if(func_mode.equals("checkPrecipateAtRecord")) {
		String ovrge_ordrd_volume		= request.getParameter("ovrge_ordrd_volume");
		String item_code				= "";
		String CONST_GENERIC_CODE		= "";
		String ALLOC_QTY				= "";
		String ALLOC_QTY_UOM			= "";
		String precip_mesg				= "";
		
		String item_code_j				= "";
		String CONST_GENERIC_CODE_j		= "";
		String ALLOC_QTY_j				= "";
		String ALLOC_QTY_UOM_j			= "";

		float const_generic_vol_factor	= 0;
		float const1_min				= 0;
		float const1_max				= 0;
		float const2_min				= 0;
		float const2_max				= 0;

		String bean_id					= request.getParameter("bean_id");
		String bean_name				= request.getParameter("bean_name");

		TPNWorkSheetBean beanObj		= (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

		HashMap	molecule_codes			= (HashMap)beanObj.getmoleculeCodes();
		HashMap	const_precp_info		= (HashMap)beanObj.getConstGenericsPreciptMsgs();
		ArrayList constPrecpMsgs		= null;

		for(int oL=3;oL<=9;oL++){
		
			item_code				= (String)hash.get("ITEM_"+oL);
			CONST_GENERIC_CODE		= (String)hash.get("CONST_GENERIC_CODE_"+oL);
			ALLOC_QTY				= (String)hash.get("ALLOC_QTY_"+oL);
			ALLOC_QTY_UOM			= (String)hash.get("ALLOC_QTY_UM_"+oL);
			for(int iL=oL+1;iL<=9;iL++){
				
				constPrecpMsgs			= new ArrayList();
				item_code_j				= (String)hash.get("ITEM_"+iL);
				CONST_GENERIC_CODE_j	= (String)hash.get("CONST_GENERIC_CODE_"+iL);
				ALLOC_QTY_j				= (String)hash.get("ALLOC_QTY_"+iL);
				ALLOC_QTY_UOM_j			= (String)hash.get("ALLOC_QTY_UM_"+iL);
				if((item_code_j != null && !item_code_j.equals("")) && !CONST_GENERIC_CODE.equals(CONST_GENERIC_CODE_j)){
					constPrecpMsgs = (ArrayList)const_precp_info.get(CONST_GENERIC_CODE_j);
					if(constPrecpMsgs != null && constPrecpMsgs.size()>0){
						for(int i=0;i<constPrecpMsgs.size();i=i+14){
							const_generic_vol_factor	= 0;
							const1_min	= 0;
							const1_max	= 0;
							const2_min	= 0;
							const2_max	= 0;
							if((constPrecpMsgs.get(i).equals(CONST_GENERIC_CODE)) && (constPrecpMsgs.get(i+2).equals(CONST_GENERIC_CODE_j)) && (constPrecpMsgs.get(i+4).equals(molecule_codes.get(CONST_GENERIC_CODE))) && (constPrecpMsgs.get(i+5).equals(molecule_codes.get(CONST_GENERIC_CODE_j))) && (constPrecpMsgs.get(i+10).equals(ALLOC_QTY_UOM_j))){
								

									const_generic_vol_factor = Float.parseFloat(ovrge_ordrd_volume)/Float.parseFloat((String)constPrecpMsgs.get(i+11));
									
									const1_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+6));
									const1_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+7));

									const2_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+8));
									const2_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+9));

									if(((Float.parseFloat(ALLOC_QTY) >= const1_min) && (Float.parseFloat(ALLOC_QTY) <= const1_max)) && ((Float.parseFloat(ALLOC_QTY_j) >= const2_min) && (Float.parseFloat(ALLOC_QTY_j) <= const2_max))){
										if(!precip_mesg.equals("")){
											precip_mesg = precip_mesg +"||";
										}
										precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+12);
										precip_mesg = precip_mesg + "$";
										precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+1);
										precip_mesg = precip_mesg + "$";
										precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+3);
										precip_mesg = precip_mesg + "$";
										precip_mesg = precip_mesg +(String)constPrecpMsgs.get(i+13);

									}

								}else if((constPrecpMsgs.get(i).equals(CONST_GENERIC_CODE_j)) && (constPrecpMsgs.get(i+2).equals(CONST_GENERIC_CODE))	&& (constPrecpMsgs.get(i+4).equals(molecule_codes.get(CONST_GENERIC_CODE_j))) && (constPrecpMsgs.get(i+5).equals(molecule_codes.get(CONST_GENERIC_CODE))) && (constPrecpMsgs.get(i+10).equals(ALLOC_QTY_UOM_j))){


									const_generic_vol_factor = Float.parseFloat(ovrge_ordrd_volume)/Float.parseFloat((String)constPrecpMsgs.get(i+11));
									const1_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+6));
									const1_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+7));

									const2_min	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+8));
									const2_max	= const_generic_vol_factor * Float.parseFloat((String)constPrecpMsgs.get(i+9));

									if(((Float.parseFloat(ALLOC_QTY_j) >= const1_min) && (Float.parseFloat(ALLOC_QTY_j) <= const1_max)) && ((Float.parseFloat(ALLOC_QTY) >= const2_min) && (Float.parseFloat(ALLOC_QTY) <= const2_max))){
										if(!precip_mesg.equals("")){
											precip_mesg = precip_mesg +"||";
										}
										precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+12);
										precip_mesg = precip_mesg + "$";
										precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+1);
										precip_mesg = precip_mesg + "$";
										precip_mesg = precip_mesg + (String)constPrecpMsgs.get(i+3);
										precip_mesg = precip_mesg + "$";
										precip_mesg = precip_mesg +(String)constPrecpMsgs.get(i+13);

									}
								}
							}
						}
					}
			}		
		}

		if(!precip_mesg.equals("")){
			out.println("assignAtRcrd(\""+precip_mesg+"\")"); 
		}
	}
%>
