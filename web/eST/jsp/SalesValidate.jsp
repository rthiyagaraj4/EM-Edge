
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html;charset=UTF-8"  import=" eST.SalesBean,eST.BatchSearchBean,eST.BatchSearchBeanForBarcode,eST.Common.StRepository,java.util.HashMap,java.util.ArrayList,java.util.Hashtable"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	SalesBean bean = (SalesBean)getBeanObject( "salesBean","eST.SalesBean" ,request) ;  
	bean.setLanguageId(locale);
	
	String validate		=	request.getParameter("validate");
	System.out.println("validate = >"+validate);

	String item_desc	=	request.getParameter("item_desc");
	int no_of_decimals=bean.getNoOfDecimals();

	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
//	String facility_id=(String)session.getValue("facility_id");
	HashMap hashmapDtl=new HashMap();

	String item_code				=	request.getParameter("item_code");
	String store_code				=	request.getParameter("store_code");
	String item_qty					=	request.getParameter("item_qty");
	String sale_req_qty				=	bean.checkForNull(request.getParameter("sale_req_qty"),"0");
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

	String Inpatient_yn				=	request.getParameter("Inpatient_yn");
	String outpatient_yn			=	request.getParameter("outpatient_yn");
	String referral_yn				=	request.getParameter("referral_yn");
	String daycare_yn				=	request.getParameter("daycare_yn");
	String emergency_yn				=	request.getParameter("emergency_yn");
	String directsale_yn			=	request.getParameter("directsale_yn");
	String bl_def_override_excl_incl_ind		=	request.getParameter("bl_def_override_excl_incl_ind");
	String bl_override_excl_incl_ind			=	request.getParameter("bl_override_excl_incl_ind");
	String bl_incl_excl_override_reason_code	=	request.getParameter("bl_incl_excl_override_reason_code");
	String bl_incl_excl_override_reason_desc	=	request.getParameter("bl_incl_excl_override_reason_desc");
	String pat_paid_amt				=	request.getParameter("pat_paid_amt");
	String gross_charge_amt			=	request.getParameter("gross_charge_amt");
	String pat_net_amt				=	request.getParameter("pat_net_amt");
	String approval_reqd_yn			=	request.getParameter("approval_reqd_yn");
	String bl_override_allowed_yn	=	request.getParameter("bl_override_allowed_yn");
	String no_of_decimals1	=	request.getParameter("no_of_decimals");
	String decimal_allowedYN1	=	request.getParameter("decimal_allowedYN");
	String billable_item_yn1	=	bean.checkForNull(request.getParameter("billable_item_yn"),"N");
	String batch_records			=	(String)request.getParameter("batch_records");
	String kit_temp_code            =  bean.checkForNull(request.getParameter("kit_temp_code"),"");        //01/08/12
	String usage_type               =  bean.checkForNull(request.getParameter("usage_type"),""); 

	//String bar_code			=	request.getParameter("bar_code");

	//String grosschargeamt			= 	item_cost_value;
	boolean	result					=	false;
	HashMap msg						=	new HashMap();
	HashMap hmrecord				=	null;	
	HashMap dflt_sal_type	=	null;  // Added by Padmapriya
	String usr_id		=	request.getParameter("user_id");  // Added by Padmapriya
	ArrayList alBatchRecords = null;
	
	try {
		//String operation							=	request.getParameter("operation");
		if (validate.equals("ADD_TO_LIST")) {

			try{
			flag="";
//if(operation.equals("insert")) {
//if(bean.isDuplicateInArrayList(bean.getDetailValues(), "item_code", item_code, Integer.parseInt(doc_srl_no)-1)) {
//throw new Exception("RECORD_ALREADY_EXISTS");
//}
//}
/*Code added for SRR walk-thru on 3/3/2010*/
		       
			System.out.println("...records_to_delete..."+request.getParameter("records_to_delete"));
			bean.setRecords_to_delete(bean.checkForNull((String)request.getParameter("records_to_delete")));
/*Code ended*/
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("stock_item_yn",		stock_item_yn	);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("uom_code",			uom_code		);
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */

			if(bean.getAllowDecimalsYN( item_code).equals("Y")){
			hashmapDtl.put("item_qty",		bean.setNumber(	item_qty,no_of_decimals)	);
			}else{
			hashmapDtl.put("item_qty",			bean.setNumber(	item_qty,0));
			}
			hashmapDtl.put("item_unit_cost",	item_unit_cost	);
			hashmapDtl.put("item_cost_value",	item_cost_value	);
			hashmapDtl.put("stock_available",	stock_available	);
			hashmapDtl.put("remarks",			remarks			);
			hashmapDtl.put("remarks_code",		remarks_code	);
			hashmapDtl.put("gross_charge_amt",	gross_charge_amt	);
			hashmapDtl.put("pat_net_amt",		pat_net_amt	);
			hashmapDtl.put("batch_records",		batch_records	);
			hashmapDtl.put("bl_def_override_excl_incl_ind",		bl_def_override_excl_incl_ind	);
			hashmapDtl.put("p_overridden_excl_incl_ind",		bl_override_excl_incl_ind	);
			hashmapDtl.put("p_overridden_action_reason",	bl_incl_excl_override_reason_code	);
			hashmapDtl.put("bl_incl_excl_override_reason_desc",	bl_incl_excl_override_reason_desc	);
			hashmapDtl.put("pat_paid_amt",	pat_paid_amt	);
			hashmapDtl.put("approval_reqd_yn",	approval_reqd_yn	);
			hashmapDtl.put("bl_override_allowed_yn",	bl_override_allowed_yn	);
			hashmapDtl.put("no_of_decimals",	no_of_decimals1	);
			hashmapDtl.put("decimal_allowedYN",	decimal_allowedYN1	);
			hashmapDtl.put("billable_item_yn",	billable_item_yn1	);
			hashmapDtl.put("sale_req_qty",	sale_req_qty	);
			//hashmapDtl.put("bar_code",	bar_code	);
			hashmapDtl.put("kit_temp_code",	kit_temp_code); //01/08/12
			hashmapDtl.put("usage_type",	usage_type);
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			
			System.out.println("item_code...SalesValidate.jsp..."+item_code);
		//	System.out.println("bar_code...SalesValidate.jsp..."+bar_code);
			System.out.println("index...SalesValidate.jsp..."+Integer.parseInt(index));
			System.out.println("hashmapDtl...SalesValidate.jsp.."+hashmapDtl);
			System.out.println("htFormValues...SalesValidate.jsp..."+htFormValues);
			System.out.println("bean.getDtlRecords()"+bean.getDtlRecords());

			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			if (stock_item_yn.equals("Y")) 
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);

					
			System.out.println("getBarcodeApplicable()()"+bean.getBarcodeApplicable());
			if(bean.getBarcodeApplicable().equals("Y")){
			hashmapDtl.put("ADD","NO");
			htFormValues.put("pindex",		""+index);
			bean.updateDtlRecordforBarCode(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecordsforBarCode(Integer.parseInt(index), htFormValues);
			}

//			bean.setDetailValues(hashmapDtl);
//			bean.setExpValues(htFormValues);
			result			=	true;
			}
			catch(Exception ex)
			{
				result		=	false;
				System.out.println("Exception in SalesValidate.jsp...@validate = ADD_TO_LIST...");
				ex.printStackTrace();
				System.out.println(ex.toString());
			}
		
		}else if (validate.equals("SALES_TYPE")){
			String list1	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			String list2	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			String list3	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			String list4	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels");
			String list5 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			String list6 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			hmrecord	=		bean.getSalesType(store_code);
			String user_id = bean.getLoginById()	;  // Added by Padmapriya
			dflt_sal_type	 = bean.getDfltSalesType(store_code,user_id);  // Added by Padmapriya
			String dflt_sal_type_yn = (String)dflt_sal_type.get("DFLT_SAL_TRN_TYPE");  // Added by Padmapriya
			outpatient_yn		=		(String)hmrecord.get("OUTPATIENT_YN");
			Inpatient_yn		=		(String)hmrecord.get("INPATIENT_YN");
			referral_yn			=		(String)hmrecord.get("REFERRAL_YN");
			daycare_yn			=		(String)hmrecord.get("DAYCARE_YN");
			emergency_yn		=		(String)hmrecord.get("EMERGENCY_YN");
			directsale_yn		=		(String)hmrecord.get("DIRECTSALE_YN");
			out.println("clearListItems('document.formSalesHeader.sal_trn_type'); ");
// Commented by Padmapriya
			/*		if(Inpatient_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"I"+ "\",\"" +list2+ "\"); ");
			if(daycare_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"D"+ "\",\"" +list6+ "\"); ");
			if(outpatient_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"O"+ "\",\"" +list1+ "\"); ");
			if(emergency_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"E"+ "\",\"" +list5+ "\"); ");
			if(referral_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"R"+ "\",\"" +list3+ "\"); ");
			if(directsale_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"X"+ "\",\"" +list4+ "\"); ");  */
	 // Added by Padmapriya
	 
	 if(Inpatient_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"I"+ "\",\"" +list2+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(daycare_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"D"+ "\",\"" +list6+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(outpatient_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"O"+ "\",\"" +list1+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(emergency_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"E"+ "\",\"" +list5+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(referral_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"R"+ "\",\"" +list3+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(directsale_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesHeader.sal_trn_type\", \"" +"X"+ "\",\"" +list4+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			
		}
		
		//  Added by Padmapriya
		
	else if (validate.equals("UA_SALES_TYPE")){
			System.out.println("Sales Validate.jsp validate"+validate);
			String list1	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");    
			String list2	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			String list3	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			String list4	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels");
			String list5 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			String list6 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			hmrecord	=		bean.getSalesType(store_code);
			dflt_sal_type	 = bean.getDfltSalesType(store_code,usr_id);
			String dflt_sal_type_yn = (String)dflt_sal_type.get("DFLT_SAL_TRN_TYPE");
			outpatient_yn		=		(String)hmrecord.get("OUTPATIENT_YN");
			Inpatient_yn		=		(String)hmrecord.get("INPATIENT_YN");
			referral_yn			=		(String)hmrecord.get("REFERRAL_YN");
			daycare_yn			=		(String)hmrecord.get("DAYCARE_YN");
			emergency_yn		=		(String)hmrecord.get("EMERGENCY_YN");
			directsale_yn		=		(String)hmrecord.get("DIRECTSALE_YN");
			out.println("clearListItems('document.Search_form.dflt_sal_type'); ");
			if(Inpatient_yn.equals("Y"))
				out.println("addListItem(\"document.Search_form.dflt_sal_type\", \"" +"I"+ "\",\"" +list2+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(daycare_yn.equals("Y"))
				out.println("addListItem(\"document.Search_form.dflt_sal_type\", \"" +"D"+ "\",\"" +list6+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(outpatient_yn.equals("Y"))
				out.println("addListItem(\"document.Search_form.dflt_sal_type\", \"" +"O"+ "\",\"" +list1+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(emergency_yn.equals("Y"))
				out.println("addListItem(\"document.Search_form.dflt_sal_type\", \"" +"E"+ "\",\"" +list5+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(referral_yn.equals("Y"))
				out.println("addListItem(\"document.Search_form.dflt_sal_type\", \"" +"R"+ "\",\"" +list3+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(directsale_yn.equals("Y"))
				out.println("addListItem(\"document.Search_form.dflt_sal_type\", \"" +"X"+ "\",\"" +list4+ "\",\"" +dflt_sal_type_yn+ "\"); ");	
			//Added by suresh.r 13-11-2013 against JD-CRF-156  beg  (For UserAccessForStore Display Encounter Financial Details valaidation)
			if(request.getParameter("chk_flag").equals("Y")){
				String disp_curr_enc_findtl_yn =bean.getUserAccCurrEncntrFinDdtlYN(store_code,usr_id);
				if(disp_curr_enc_findtl_yn.equals("Y")){
					out.println("document.Search_form.disp_curr_enc_findtl_yn.checked = true");
					out.println("document.Search_form.disp_curr_enc_findtl_yn.value = 'Y'");
				}else{
					out.println("document.Search_form.disp_curr_enc_findtl_yn.checked = false");
					out.println("document.Search_form.disp_curr_enc_findtl_yn.value = 'N'");
				}
			}
			//Added by suresh.r 13-11-2013 against JD-CRF-156  end
		}	
		
	else if (validate.equals("CHECK_STORE_SALESTYPE")){
		String sal_trn_type			=		request.getParameter("sal_trn_type")==null?"I":request.getParameter("sal_trn_type");
		store_code					=		request.getParameter("store_code")==null?"I":request.getParameter("store_code");
		String  result_bean			=		bean.CheckStoreSalesType(store_code,sal_trn_type);
		String result1				=		"";
	
		if(result_bean.equals("N")){
			result			=	false;
			//	message			=	"done";
			result1		=	"Y";
			out.println("alert(getMessage('INVALID_SALES_TYPE_FOR_STORE','ST'));");
			out.println("addList();");
		}else{
			result1		=	"y";
			result			=	false;
		}
	}else if (validate.equals("PATIENT_NAME")){
			String trn_type = (String)request.getParameter("trn_type");
			String siteId = (String)request.getParameter("siteId");
			out.println("clearListItems('document.formSalesHeader.encounter_id'); ");
			if (patient_id.trim().equals("")) {
				out.println("setPatientName('','','');");
				result			=	true;
				return;
			}
			try{
			/*	if(trn_type.equals("X")){
					out.println("document.formSalesHeader.patient_name.disabled = false;");
					out.println("document.formSalesHeader.patient_id.value = '"+bean.checkForNull(bean.getPatientId(patient_id))+"';");
					out.println("setPatientName('');");
					out.println("document.formSalesHeader.patient_name.focus();");
				}
				else{ */
					//HashMap patient_Details = bean.getPatientDetails(patient_id);
					//String patient_name = (String)patient_Details.get("PATIENT_NAME");
					//String patient_sex = (String)patient_Details.get("SEX");
					//String patient_age = (String)patient_Details.get("AGE");
					//String patient_age_type = (String)patient_Details.get("AGE_TYPE");
					//String patient_dob = (String)patient_Details.get("DATE_OF_BIRTH");
					
					out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\");");
					//out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\",\""+patient_sex+"\",\""+patient_age+"\");");

				//	out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\",\""+patient_sex+"\",\""+patient_age+"\",\""+patient_dob+"\",\""+patient_age_type+"\");");
					
					//System.out.println("patient_Details----------->"+patient_Details);

					ArrayList alEncounterList = bean.getEncounterArrayList(patient_id,trn_type,siteId);
					HashMap record	=	null;
					for(int i=0; i< alEncounterList.size(); i++) {
						record	=	(HashMap)alEncounterList.get(i);
						String listRecord	=	(String)record.get("ENCOUNTER_ID");
						out.println("addListItem(\"document.formSalesHeader.encounter_id\", \"" +listRecord+ "\",\"" +listRecord+ "\"); ");
						out.println("defaultEncounter();");
						
					}
					//Added by suresh.r 08-11-2013  against JD-CRF-156 beg
					if(alEncounterList.size()==0 && bean.getBLModuleInstalled().equals("Y")){
						out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
						out.println("document.getElementById('id_fin_dtl').style.visibility = 'hidden';");
					}out.println("callitem();");// Added for ICN7125
					//Added by suresh.r 08-11-2013  against JD-CRF-156 end
			//	}
				result			=	true;
			}
			catch(Exception exception){
				System.out.println("exception...."+exception.getMessage());
				System.err.println("exception...."+exception.getMessage());
				exception.printStackTrace();
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
		}else if(validate.equals("GET_STATUS")) {
			String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
			String phy_inv_id = "";
			HashMap rol_min				=	null;
			try { 

				result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result){
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formSalesListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
				String[] stNames={"item_code"};
				String[] stValues={item_code};
				System.out.println("GET_STATUS==>bean.getDtlRecords()--"+bean.getDtlRecords());
				

				System.out.println("SalesValidate---GET_STATUS --bean.getBarcodeApplicable()--"+bean.getBarcodeApplicable());
				
				/*if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1)){
					throw new Exception("RECORD_ALREADY_EXISTS");
				}*/

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

				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				/** @ 
				 CRF_SRR20056-CRF-0537.1 
				 For handle the Decimals in QOH, avail_Qty Modifications begin 

				**/
				double tmp_conv=bean.getConvFactTemp(item_code,store_code);
				/*if(tmp_conv==999999999){
				throw new Exception("Multiple");
				}*/

				//double avail_stock = Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/bean.getConvFactTemp(item_code,store_code);
				double avail_stock = Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/tmp_conv;
				String allow_decimals_yn=(String)hmStockAvailabilityStatus.get("allow_decimals_yn");
		        double  avail_stock_rol = avail_stock;
				out.println("document.formSalesListHeader.no_of_decimals.value = '"+no_of_decimals+"';");
				out.println("document.formSalesListHeader.decimal_allowedYN.value = '"+allow_decimals_yn+"';");
				out.println("document.formSalesListHeader.dec_allowed_yn.value = '"+allow_decimals_yn+"';");
				
				/* @Name - Priya
				* @Date - 17/05/2010
				* @Inc# - 22038
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and passed it in the setStockDetails() function and  assign it to the item_unit_cost field
				*/
				//String storeItemUnitCost=bean.getUnitCost(item_code,store_code);
				//Modified by suresh.r on 19-08-2014 against Inc #50616 beg
				double baseUnitCost=bean.getBaseUnitCost(item_code);
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
				String storeItemUnitCost=bean.setNumber(""+(baseUnitCost*tmp_conv), noOfDecimalsForCost);
				//Modified by suresh.r on 19-08-2014 against Inc #50616 end

				//out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\",\""+""+avail_stock+"\");");
				String  billable_item_yn=bean.checkForNull((String)bean.fetchRecord("SELECT NVL(BILLABLE_ITEM_YN,'N') BILLABLE_ITEM_YN FROM MM_ITEM WHERE ITEM_CODE=?", item_code).get("BILLABLE_ITEM_YN"),"N");
				out.println("document.formSalesListHeader.billable_item_yn.value = '"+billable_item_yn+"';");
				out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+""+avail_stock+"\");");

				/**End**/

				//}	
				/** @ 
				 CRF_SRR20056-CRF-0537.1 
				 For handle the Decimals in QOH, avail_Qty Modifications end 

				**/
				/** @  before modification 

				int avail_stock = Integer.parseInt((String)hmStockAvailabilityStatus.get("available_stock"))/bean.getConout.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\",\""+hmStockAvailabilityStatus.get("available_stock")+"\");");
				**/
				if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y"))
				{
					if( hmStockAvailabilityStatus.get("available_stock").equals("0"))
						throw new Exception("STOCK_NOT_AVAILABLE");
				} else
					throw new Exception("NOT_STOCK_ITEM");
			
				/*if(((String)bean.getAccessCostDetails()).equals("Y")&& bean.getBLModuleInstalled().equals("Y")){
					out.println("document.getElementById("id_char_amt").style.visibility = 'visible';");
					out.println("document.getElementById("id_charge_amt").style.visibility = 'visible';");
					out.println("document.getElementById("id_pay_amt").style.visibility = 'visible';");
					out.println("document.getElementById("id_payable_amt").style.visibility = 'visible';");
				}*/
			result		=	true;
			//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
	           if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
	        	boolean req_allowed_yn = bean.getReq_allowed_yn(bean.getLoginById(),store_code);
			     rol_min	=	(HashMap)bean.getROL(item_code,store_code);
			
			if(!(bean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0")).equals("0")){
			out.println("document.getElementById('id_min_stk_label').style.visibility = 'visible';");
			out.println("document.getElementById('id_min_str_stk').style.visibility = 'visible';");
			out.println("document.getElementById('id_min_str_stk').innerHTML = '<B>"+bean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0")+"</B>';");
			if 
			((avail_stock_rol) < Double.parseDouble(bean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0"))) {
			 out.println("document.getElementById('id_min_str_stk').innerHTML = '<B style= background-color:red;color:yellow; >"+bean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0")+"</B>';");
			if(req_allowed_yn){
			 out.println("document.getElementById('sales_req_label').style.visibility = 'visible';");
			    }
			 }
			}
			if(!(bean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0")).equals("0")){
			out.println("document.getElementById('id_stk_rol_label').style.visibility = 'visible';");
			out.println("document.getElementById('id_stk_rol').style.visibility = 'visible';");
			out.println("document.getElementById('id_stk_rol').innerHTML = '<B>"+bean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0")+"</B>';");
			 if 
			((avail_stock_rol) < Double.parseDouble(bean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0")))
			{
			out.println("document.getElementById('id_stk_rol').innerHTML = '<B style= background-color:red;color:yellow; >"+bean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0")+"</B>';");
				 
				if(req_allowed_yn){
				 out.println("document.getElementById('sales_req_label').style.visibility = 'visible';");
				}
				
			}
			 }
	       } //ends
			
			}
			catch (Exception exception) {
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

		else if(validate.equals("HEADER_PROCEDURE")){
			try{
		//	String patient = request.getParameter("patient_id");
			String encounter_id = bean.checkForNull(request.getParameter("encounter_id"));
			String sal_trn_type = request.getParameter("sal_trn_type");
			if(sal_trn_type.equals("X"))
				sal_trn_type = "R";
			msg = bean.callBillingHdrProcedure(patient_id,encounter_id,sal_trn_type);
			//msg = "Insurance Policy Is Expired. Proceed?";
			
			if(msg.size() > 0){
				message = (String)msg.get("warning_msg");
			}
			result=true;
			if(msg.size() > 0){
				String error_msg = bean.checkForNull((String)msg.get("error_msg"));
			if(error_msg.length() > 0){
					
					message = (String)msg.get("error_id") + "  " + (String)msg.get("error_msg"); 
					result = false;
					throw new Exception(message);
			}
			}

			}
			catch (Exception exception) {
				
				exception.printStackTrace();
				
			}
			
		}
		else if(validate.equals("ITEMVAD_PROCEDURE")){
			try{
				//	String patient = request.getParameter("patient_id");
					String encounter_id = bean.checkForNull(request.getParameter("encounter_id"));
					String sal_trn_type = request.getParameter("sal_trn_type");
					if(sal_trn_type.equals("X"))
						sal_trn_type = "R";
					String item   = request.getParameter("item_code");
					msg = bean.callBillingItemVadProcedure(patient_id,encounter_id,sal_trn_type,item);
					if(msg.size() > 0){
						message = (String)msg.get("warning_msg");
					}
					result=true;
					if(msg.size() > 0){
						
					   if((bean.checkForNull((String)msg.get("error_msg"))) !=""){
							message = (String)msg.get("error_id") + "  " + (String)msg.get("error_msg"); 
							result = false;
							System.err.println("message--------->"+message);
							throw new Exception(message);

					     }
					}

			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		}
		else if(validate.equals("ITEMCHARGE_DTLS")){
			try{
				String patient = request.getParameter("patient_id");
				String encounter_id = bean.checkForNull(request.getParameter("encounter_id"));
				String sal_trn = "";

				if(((String)bean.getSal_trn_type()).equals(""))
					sal_trn = bean.checkForNull(request.getParameter("sal_trn_type"),"");
				else
					sal_trn = (String)bean.getSal_trn_type();
				out.println("parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value = '"+bean.checkForNull(sal_trn)+"';");
				if(sal_trn.equals("X"))
					sal_trn	 = "R";
				String item_dtls   = request.getParameter("item_code");
				String item_qty_dtl		= request.getParameter("tot_item_qty");
System.err.println("@@@@370sales validate"+patient+"===="+encounter_id+"===="+sal_trn+"===="+item_dtls+"===="+item_qty_dtl);
				msg =bean.callItemChargeDtls(patient,encounter_id,sal_trn,item_dtls,item_qty_dtl);
				//msg = "Insurance Policy Is Expired. Proceed?";
						
				if(msg.size() > 0){
					
				if((bean.checkForNull((String)msg.get("error_msg"))) !=""){
						message = (String)msg.get("error_id") + "  " + (String)msg.get("error_msg"); 
						result = false;
						throw new Exception(message);
				}
				else{
						message = (String)msg.get("insind")+","+(String)msg.get("baseqty")+","+(String)msg.get("baserate")+","+(String)msg.get("basechargeamt")+","+(String)msg.get("grosschargeamt")+","+(String)msg.get("discountper")+","+(String)msg.get("discountamt")+","+(String)msg.get("daytypecode")+","+(String)msg.get("daytypedesc")+","+(String)msg.get("timetypecode")+","+(String)msg.get("timetypedesc")+","+(String)msg.get("addlfactor")+","+item_dtls+","+""+","+""+","+""+","+(String)msg.get("netchargeamt")+","+(String)msg.get("patgrosschargeamt")+","+(String)msg.get("patdiscamt")+","+(String)msg.get("patnetamt")+","+(String)msg.get("custgrosschargeamt")+","+(String)msg.get("custdiscamt")+","+(String)msg.get("custnewamt");
						result = true;
				    }
				}
			}
			catch (Exception exception) {
				
				exception.printStackTrace();
			}
			
		}
		else if(validate.equals("CHECK_AUTHORIZE_ALLOWED")) {
			String stAuthorized_allowed	=	bean.getAuthorize_allowed_yn(store_code);
			out.println("setAuthorize_allowed('"+stAuthorized_allowed+"');");
			result=true;
		}
		// till here
//  Added for online printing on 9/27/2004

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
// End of Online printing on 9/27/2004
		else if(validate.equals("KIT_TEMPLATE")){
			HashMap drug_detail = new HashMap();
			try{
				//if((bean.getPatient_id()).equals("")){
					bean.setPatient_id((String)request.getParameter("patient_id"));
					bean.setEncounter_id((String)request.getParameter("encounter_id"));
					bean.setSal_trn_type((String)request.getParameter("sal_trn_type"));
				//}
				String bl_overriden_action_reason = "";
				//String bl_def_excl_incl_ind = "";
			
				String kit_template_code = (String)request.getParameter("kit_template_code")==null?"":(String)request.getParameter("kit_template_code");
				if(!(kit_template_code.equals(""))){
					bean.kitTemplateValues(kit_template_code,store_code,store_code);
				}
				ArrayList alDetailData=bean.getKitDtlData();
				HashMap hmStockAvailabilityStatus = new HashMap();	
				int count = (int)bean.getCount();
					HashMap ht = new HashMap();
				if(alDetailData.size()>count){
					ht = (HashMap)alDetailData.get(count);
					System.out.println("htht===567==>" +ht);
					/** @ 
							 CRF_SRR20056-CRF-0537.1 
							 For handle the Decimals in QOH, avail_Qty Modifications 

					**/
					
						String allow_decimals_yn=bean.getAllowDecimalsYN((String)ht.get("ITEM_CODE"));
						out.println("document.formSalesListHeader.decimal_allowedYN.value = '"+allow_decimals_yn+"';");
						out.println("document.formSalesListHeader.no_of_decimals.value = '"+no_of_decimals+"';");
						/** @ 
							 CRF_SRR20056-CRF-0537.1 
							 For handle the Decimals in QOH, avail_Qty Modifications end

						**/
					
						out.println("document.formSalesListHeader.item_code.value = '"+bean.checkForNull((String)ht.get("ITEM_CODE"),"")+"';");
						out.println("document.formSalesListHeader.item_desc.value = \""+bean.checkForNull((String)ht.get("SHORT_DESC"))+"\";");
						out.println("document.formSalesListHeader.expiry_yn.value = '"+bean.checkForNull((String)ht.get("EXPIRY_YN"),"")+"';");
						out.println("document.formSalesListHeader.uom_code.value = '"+bean.checkForNull((String)ht.get("UOM_CODE"),"")+"';");
						out.println("document.formSalesListHeader.kit.value = 'kit';");
						out.println("document.formSalesListHeader.store_code.value = '"+bean.checkForNull((String)store_code,"")+"';");
						out.println("document.getElementById('id_uom').innerHTML = '"+bean.checkForNull((String)ht.get("STOCK_UOM_DESC"),"&nbsp;")+"';");
						out.println("document.getElementById('id_item_sal_value').innerHTML = '"+bean.checkForNull((String)ht.get("ITEM_VALUE"),"")+"';");
						
						out.println("document.formSalesListHeader.kit_temp_code.value = '"+bean.checkForNull((String)ht.get("KIT_TEMPLATE_CODE"),"")+"';");
						
						out.println("document.formSalesListHeader.usage_type.value = '"+bean.checkForNull((String)ht.get("USAGE_TYPE"),"")+"';");

						String  billable_item_yn=bean.checkForNull((String)bean.fetchRecord("SELECT NVL(BILLABLE_ITEM_YN,'N') BILLABLE_ITEM_YN FROM MM_ITEM WHERE ITEM_CODE=?", bean.checkForNull((String)ht.get("ITEM_CODE"),"")).get("BILLABLE_ITEM_YN"),"N");
						out.println("document.formSalesListHeader.billable_item_yn.value = '"+billable_item_yn+"';");
						if(bean.getBLModuleInstalled().equals("Y") && billable_item_yn.equals("Y")){
							drug_detail = (HashMap)bean.getBillingDetail(bean.checkForNull(bl_override_excl_incl_ind), bl_overriden_action_reason,(String)ht.get("ITEM_CODE"),bean.checkForNull((String)ht.get("QUANTITY"),"0"),bean.getBlDecimal());
						}
						try{
							String[] stParameters = {bean.checkForNull((String)ht.get("ITEM_CODE"),""), store_code, "0", "N", "", "N", "" };
							hmStockAvailabilityStatus = new HashMap();
							hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						}catch(Exception e){
							result = false;
						}
					if (!((bean.checkForNull((String)drug_detail.get("BL_SYS_MESSAGE_ID"))).equals("") && (bean.checkForNull((String)drug_detail.get("BL_ERROR_TEXT"))).equals("") && (bean.checkForNull((String)drug_detail.get("BL_ERROR_CODE"))).equals(""))){
						out.println("document.formSalesListHeader.expiry_yn.value = 'XX';");
						out.println("document.formSalesListHeader.item_qty.value = 0;");
						out.println("document.formSalesListHeader.tot_item_qty.value = 0;");
					}else if((hmStockAvailabilityStatus.get("stock_item_yn")!=null && hmStockAvailabilityStatus.get("stock_item_yn").equals("Y") && !(hmStockAvailabilityStatus.get("available_stock").equals("0")))){
						out.println("document.formSalesListHeader.item_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"")+";");
						out.println("document.formSalesListHeader.tot_item_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"")+";");
						out.println("document.getElementById('id_store_item_unit_cost').innerHTML = '"+bean.checkForNull((String)ht.get("ITEM_UNIT_COST"),"")+"';");
						if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
							out.println("document.formSalesListHeader.item_qty.value = 0;");
							out.println("document.formSalesListHeader.tot_item_qty.value = 0;");
						}
						out.println("viewCharges();");

					}else{
						out.println("document.formSalesListHeader.expiry_yn.value = 'XX';");
						out.println("document.formSalesListHeader.item_qty.value = 0;");
						out.println("document.formSalesListHeader.tot_item_qty.value = 0;");
					}
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
		else if(validate.equals("setToConv")){//Added for Conversion factor
			store_code				=	request.getParameter("store_code");
			item_code				=	request.getParameter("item_code");
			double tmp_conv=bean.getConvFactTemp(item_code,store_code);
			result=true;
			out.println("setTempConvFactor('"+tmp_conv+"');");
		}
		else if(validate.equals("ERROR_MESSAGE")) {
			result = false;
			bean.setPatient_id((String)request.getParameter("patient_id"));
			bean.setEncounter_id((String)request.getParameter("encounter_id"));
			bean.setSal_trn_type((String)request.getParameter("sal_trn_type"));
			ArrayList alDtlData = new ArrayList();
			ArrayList errorList = new ArrayList();
			HashMap ht = new HashMap();
			HashMap drug_detail = new HashMap();
			//alDtlData = bean.getDtlRecords();
			alDtlData = bean.getKitDtlData();
			HashMap hmStockAvailabilityStatus = null;
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
					if(bean.getBLModuleInstalled().equals("Y")){
						drug_detail = (HashMap)bean.getBillingDetail("", "",(String)ht.get("ITEM_CODE"),bean.checkForNull((String)ht.get("quantity"),"0"),bean.getBlDecimal());
					}
					if (!((bean.checkForNull((String)drug_detail.get("BL_SYS_MESSAGE_ID"))).equals("") && (bean.checkForNull((String)drug_detail.get("BL_ERROR_TEXT"))).equals("") && (bean.checkForNull((String)drug_detail.get("BL_ERROR_CODE"))).equals(""))){
						errorList.add("BILLING_ERROR");
						errorList.add((String)ht.get("SHORT_DESC"));
					}

			}
			//System.out.println("errorList:"+errorList);
			out.println("displayMessage('"+errorList+"');");
			result		=	true;
		}else if(validate.equals("ZERO_QUANTITY")){
			result = true;
			ArrayList alDtlData = new ArrayList();
			
				System.out.println("SalesValidate-----bean.getBarcodeApplicable()--"+bean.getBarcodeApplicable());
			if(bean.getBarcodeApplicable().equals("Y")){
				alDtlData = bean.getDtlRecordsforBarCode();
				System.out.println("SalesValidate---if--alDtlData--"+alDtlData);
				}
			else{	
				alDtlData = bean.getDtlRecords();
				System.out.println("SalesValidate---else--alDtlData--"+alDtlData);
			}

			
			HashMap ht = new HashMap();
			if(Integer.parseInt(index)>alDtlData.size())
				return;

				//ht = (HashMap)bean.getDtlRecord(Integer.parseInt(index));

				if(bean.getBarcodeApplicable().equals("Y")){
				ht = (HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
				System.out.println("SalesValidate---if--ht--"+ht);
				}
				else{	
				ht = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
				System.out.println("SalesValidate---else--ht--"+ht);
				}




					if(!((String)ht.get("item_unit_cost")).equals("")&&((String)ht.get("item_qty")).equals("0")){
						result = false;
					}
		}
		else if(validate.equals("Bill_data")){
			HashMap bill_data=new HashMap(); 
			bill_data= bean.getbill_data();
			String msg1="";
			 if(bill_data.size()>0){
				 ArrayList doc_no = (ArrayList)bill_data.get("doc_no");
			  msg1=(String)bill_data.get("l_slmt_reqd_yn")+","+(String) bill_data.get("l_bill_doc_num")+","+(String) bill_data.get("l_bill_doc_type")+","+""+(String) doc_no.get(0)+","+(String) bill_data.get("v_blng_group_id")+"," +""+(String) bill_data.get("message")+","+""+(String) bill_data.get("p_call_disc_function_yn");
				message=msg1; 
				flag = (String) bill_data.get("flag");
			 }
		   if((bean.checkForNull((String)bill_data.get("error_msg"))) !=""){
				message = (String) bill_data.get("message"); 
				result = false;
				throw new Exception(message);
			}
			result = true;
		}
		else if(validate.equals("STORE_STATUS")){
			int count = 0;
			String patient_class = (String)request.getParameter("patient_class")==null?"":(String)request.getParameter("patient_class");
			String sal_trn_type = (String)request.getParameter("sal_trn_type")==null?"":(String)request.getParameter("sal_trn_type");
			bean.setSal_trn_type(sal_trn_type);
			if(patient_class.equals("IP")||patient_class.equals("DC"))
			{
				count=Integer.parseInt((String)	bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_STORE WHERE IP_SALE_APPL_YN = 'Y' AND STORE_CODE = ?",store_code).get("COUNT"));
			}else if(patient_class.equals("OP")||patient_class.equals("EM")){
				count=Integer.parseInt((String)	bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_STORE WHERE OP_SALE_APPL_YN = 'Y' AND STORE_CODE = ?",store_code).get("COUNT"));
			}
			if(count>0)
				result = true;
			else
				result = false;
		}else if(validate.equals("TOTAL_QTY")){
		double tmp_conv=bean.getConvFactTemp(item_code,store_code);
		/*if(tmp_conv==999999999){
			throw new Exception("Multiple");
			}*/
			result=true;
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
			String tot_item_qty = 	""+(tmp_conv * Double.parseDouble((String)item_qty));
			if(bean.getAllowDecimalsYN( item_code).equals("Y")){
				tot_item_qty=bean.setNumber(tot_item_qty,no_of_decimals);
			}else{
			tot_item_qty=bean.setNumber(tot_item_qty,0);
			}
			out.println("document.formSalesListHeader.tot_item_qty.value = '"+tot_item_qty+"';");

			String bar_or_item_code = bean.checkForNull(request.getParameter("bar_or_item_code"),"");
			if(bar_or_item_code.equals("B")){
			//out.println("parent.frames[1].document.forms[0].item_qty_0.value = '"+tot_item_qty+"';");
			}

			result = true;
		}else if(validate.equals("DISP_DETAILS")){
			String encounter_id = bean.checkForNull(request.getParameter("encounter_id"));
			if(!encounter_id.equals("")){//Added by suresh.r against JD-CRF-156  08-11-2013
			String alParameters[]={locale,bean.getLoginFacilityId(),encounter_id,patient_id,locale};
			HashMap nuOrClinic = new HashMap();
			HashMap hmRecord = (HashMap)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_PATIENT_CLASS_SELECT"),alParameters);
			System.out.println("hmRecord sales from validate=>"+hmRecord);
			out.println("document.getElementById('pat_class').innerText='"+bean.checkForNull((String)hmRecord.get("PATIENT_CLASS"))+"'");
			out.println("document.getElementById('room_no').innerText='"+bean.checkForNull((String)hmRecord.get("ASSIGN_ROOM_NUM"))+"'");
			out.println("document.getElementById('bed_no').innerText='"+bean.checkForNull((String)hmRecord.get("ASSIGN_BED_NUM"))+"'");
			out.println("document.getElementById('NU_Clinic_code').innerText='"+bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE"))+"'");
			out.println("document.getElementById('practitioner_id').value='"+bean.checkForNull((String)hmRecord.get("ATTEND_PRACTITIONER_ID"))+"'");
			out.println("document.getElementById('practitioner_name').value='"+bean.checkForNull((String)hmRecord.get("ATTEND_PRACTITIONER_NAME"))+"'");
			out.println("document.getElementById('patient_classcode').value='"+bean.checkForNull((String)hmRecord.get("PATIENT_CLASS_CODE"))+"'");//Added by suresh r  04-12-2013 against JD-CRF-156

			if(((String)hmRecord.get("ASSIGN_CARE_LOCN_TYPE")).equals("N")){
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_NURSING_UINIT_SELECT"),alParameters1);
			}else{
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_CLINIC_SELECT"),alParameters1);
			}
			//String desc = java.net.URLEncoder.encode((String)nuOrClinic.get("SHORT_DESC"));
			String desc = (String)nuOrClinic.get("SHORT_DESC");
			
			out.println("diss(encodeURIComponent('"+desc+"','UTF-8'));");
						//out.println("document.getElementById("NU_Clinic").innerText='"+bean.checkForNull((String)nuOrClinic.get("SHORT_DESC"))+"'");
			}else{//Added by suresh.r 08-11-2013 against JD-CRF-156  beg
				if(bean.getBLModuleInstalled().equals("Y")){
					out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
					out.println("document.getElementById('id_fin_dtl').style.visibility = 'hidden';");
				}
			}//Added by suresh.r 08-11-2013  against JD-CRF-156  end
		}else if (validate.equals("ASSIGN_OVERRIDE")){
			
			String tot_item_qty	 =	request.getParameter("tot_item_qty");
			if(tot_item_qty.equals("undefined"))
			tot_item_qty	 = "1";

			System.out.println("tot_item_qty----------->"+tot_item_qty);
			bean.setPatient_id((String)request.getParameter("patient_id"));
			bean.setEncounter_id((String)request.getParameter("encounter_id"));
			bean.setSal_trn_type((String)request.getParameter("sal_trn_type"));
			//String bl_override_excl_incl_ind = (String) request.getParameter("bl_override_excl_incl_ind")==null?"":(String) request.getParameter("bl_override_excl_incl_ind");
			String bl_overriden_action_reason = (String) request.getParameter("bl_overriden_action_reason")==null?"":(String) request.getParameter("bl_overriden_action_reason");
			String bl_def_excl_incl_ind = "";
			HashMap drug_detail = new HashMap();
			System.out.println("request.getParameter"+request.getParameter("batch_string"));
			if(request.getParameter("batch_string")==null || request.getParameter("batch_string").length()==0){
				drug_detail = (HashMap)bean.getBillingDetail(bean.checkForNull(bl_override_excl_incl_ind), bl_overriden_action_reason,item_code,tot_item_qty,bean.getBlDecimal());
			}else{
				drug_detail = (HashMap)bean.getBillingDetail(bean.checkForNull(bl_override_excl_incl_ind), bl_overriden_action_reason,item_code,tot_item_qty,bean.getBlDecimal(),request.getParameter("batch_string"));
			}
			String bl_total_charge_amt		= (String)drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
			String bl_patient_payable_amt	= (String)drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
			String patient_paid_amt	= (String)drug_detail.get("PATIENT_PAID_AMT")==null?"0.0":(String)drug_detail.get("PATIENT_PAID_AMT");
			String bl_approval_reqd_yn		= (String)drug_detail.get("BL_APPROVAL_REQD_YN")==null?"":(String)drug_detail.get("BL_APPROVAL_REQD_YN");
			bl_override_allowed_yn	= (String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN");

			bl_def_excl_incl_ind		= (String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");

			String bl_error_code			= (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE"); 
			String bl_sys_message_id		= (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID");
			String bl_error_text			= (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");			
			System.out.println("###############");
			System.out.println(" batch_string = > "+request.getParameter("batch_string"));
			System.out.println(" drug_detail = > "+drug_detail);
			if(request.getParameter("batch_string")==null){
				out.println("assignChargeDetails('"+bl_total_charge_amt+"','"+bl_patient_payable_amt+"','"+bl_def_excl_incl_ind+"','"+bl_approval_reqd_yn+"','"+bl_override_allowed_yn+"','"+bl_error_code+"','"+bl_sys_message_id+"','"+bl_error_text+"','"+patient_paid_amt+"');");
			}else{
				out.println("assignChargeDetailsExp('"+bl_total_charge_amt+"','"+bl_patient_payable_amt+"');");
			}
			System.out.println("###############");

			return;
		}
		else if(validate.equals("BILLING_CASH_COUNTER")){
			try{
				String sal_trn_type = request.getParameter("sal_trn_type");
				HashMap hshCashCounter = new HashMap();
				hshCashCounter = bean.callBillingCashCounterProcedure(sal_trn_type);
				String strMessage = bean.checkForNull((String)hshCashCounter.get("SYS_MESSAGE_ID"));
				if(strMessage.equals("BL1023")){
					result = false;
				}else{
					result = true;	
				}
			}
			catch (Exception exception) {				
				exception.printStackTrace(); 				
			}				
		}
		 	/**
					 * @Name - krishna
					 * @Date - 24/12/2009
					 * @Inc# - IN017635
					 * @Desc - batch detail null handling begin
				 */
				
		else if(validate.equals("setnewbatch")) 
		{
				try
				{
						BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean",request );
						alBatchRecords = bean2.getSelectedList();
						System.out.println("alBatchRecords===========>"+alBatchRecords);
						bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
						result =  true;
				}
				catch (Exception exception) 
				{
						result		=	false;
						message		=	exception.getMessage();
						System.out.println("Exception in SalesValidate.jsp ..validate=setnewbatch...");
						exception.printStackTrace();
						System.out.println(exception.toString());
				}
		}
		/**
					 * @Name - krishna
					 * @Date - 24/12/2009
					 * @Inc# - IN017635
					 * @Desc - batch detail null handling end
				 */
			else if (validate.equals("ENCOUNTER_NEW_LIST"))
			{
			System.out.println("ENCOUNTER_NEW_LIST");
			String trn_type = (String)request.getParameter("trn_type");
			String siteId = (String)request.getParameter("siteId");
			String encounter_id = (String)request.getParameter("encounter_id");				
			try{
			    	ArrayList alEncounterList = bean.getEncounterNewArrayList(patient_id,encounter_id,trn_type,siteId);
					HashMap record	=	null;
					for(int i=0; i< alEncounterList.size(); i++) {
						record	=	(HashMap)alEncounterList.get(i);
						String listRecord	=	(String)record.get("ENCOUNTER_ID");
						if ( listRecord.equals(encounter_id)){
							System.out.println("encounter_idif");
							result			=	true;
						}
						else{
							System.out.println("encounter_idelse");
							result			=	false;
						}
					}				
			}
			catch(Exception exception){
				exception.printStackTrace();
				flag			=	"INVALID_ENCOUNTER";
				result			=	false;
			}
		}
		else if(validate.equals("NURSING_UNIT_LIST")) {			
			out.println("clearListItems('formSalesQueryCriteria.nursing_unit_code'); ");
			String fromdate = bean.checkForNull(request.getParameter("fromdate"),com.ehis.util.DateUtils.getCurrentDate("DMY",locale));
			String todate = bean.checkForNull(request.getParameter("todate"),com.ehis.util.DateUtils.getCurrentDate("DMY",locale));			
			ArrayList nursingunit = bean.getNursingUnitCodeListNewArr(fromdate, todate);
			HashMap record = null;
			for(int i=0; i< nursingunit.size(); i++) {
				record = (HashMap)nursingunit.get(i);
				out.println("addListItem(\"formSalesQueryCriteria.nursing_unit_code\", \"" + record.get("CLINIC_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}else if(validate.equals("USAGE_TYPE_STATUS")){ //18/09/12
			       usage_type=	(String)request.getParameter("usage_type");
				   //System.out.println("usage_type val=948=>" +usage_type);
			       index	=	(String)request.getParameter("index_");
			String  BARCODE_YN	=	(String)request.getParameter("BARCODE_YN");
			  //System.out.println("index_ val==>" +index_);
			  HashMap alDtl			=		new HashMap();
			   ArrayList alDtl1			=		new ArrayList();
			  if (BARCODE_YN.equals("TRUE")){
				alDtl = (HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
				//System.out.println("IssueValidate---if--ht--"+alDtl);
				}
				else{	
				alDtl = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
				//System.out.println("IssueValidate---else--ht--"+alDtl);
				}
	            alDtl.put("usage_type",usage_type);
				
				System.out.println("IssueValidate--ht--"+alDtl);
			if (BARCODE_YN.equals("TRUE")){
         bean.updateDtlRecordforBarCode(Integer.parseInt(index), alDtl);
	     }else{
	     bean.updateDtlRecord(Integer.parseInt(index), alDtl);
	    }
			result = true;
	 }
		//Added by suresh.r 13-11-2013 against JD-CRF-156 beg (For Display Encounter Financial Details valaidation)
		else if(validate.equals("VAL_DISPFINDTL")){
			String encounter_id = bean.checkForNull(request.getParameter("encounter_id"),"");
			String valflag	=request.getParameter("val_flag");
			if(bean.getBLModuleInstalled().equals("Y")&& valflag.equals("1")){
				String pat_class = bean.checkForNull(request.getParameter("pat_class"));
				String encntr_fin_dtl_yn=  bean.getUserAccCurrEncntrFinDdtlYN(store_code,bean.getLoginById());
				if(encntr_fin_dtl_yn.equals("Y")){
					if(encounter_id!=""){
						out.println("document.getElementById('id_fin_dtl').style.visibility = 'visible';");
						String param[]={bean.getLoginFacilityId(),encounter_id,pat_class,patient_id};
						if(!bean.getPolicyExp(param)){
							out.println("document.getElementById('id_polexp').style.visibility = 'visible';");
						}else{
							out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
						}
					}else{
						out.println("document.getElementById('id_fin_dtl').style.visibility = 'hidden';");
						out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
					}
				}
			}else if( valflag.equals("2")){
				HashMap record = bean.getEpisodeVisitID(encounter_id, patient_id);	
				message =record.get("EPISODE_ID")+"|"+record.get("OP_EPISODE_VISIT_NUM");
			}
			
			
		}
		//Added by suresh.r 13-11-2013 against JD-CRF-156 end
		
		else if(validate.equals("toolBar"))  { //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
	         String toolBarString = request.getQueryString() ;
			toolBarString =  "menu_id=ST_MENU&module_id=ST&function_id=ST_SALES&function_name=Sales/Patient Issues&function_type=F&access=YYYYN";
			 session.removeValue("queryString") ;
			 session.putValue( "queryString", toolBarString ) ;
	  	} 
		//Added for GHL-CRF-0413 starts
					
		else if(validate.equals("clearTmpBean"))  { 
			System.err.println("clearTmpBean starts");
			 try{
				 bean.getTempBatchRecords().clear();
			   }
			   catch(Exception exception){
					exception.printStackTrace();
					flag			=	"clearTmpBean";
				result			=	false;
				}
		}
		else if(validate.equals("SET_IN_BEAN"))  { 
			System.err.println("SET_IN_BEAN starts");
			String doc_srl_no_forbean = request.getParameter("doc_srl_no_forbean");
			int srl_no = Integer.parseInt(doc_srl_no_forbean);
			 try{
					ArrayList OldExpRecords = new ArrayList();
					ArrayList alBatchRecords_tmp = new ArrayList();
					alBatchRecords_tmp = bean.getTempBatchRecords();
					System.out.println("getting new batch from tmp");
					HashMap CurrBatchRecords = new HashMap();
				if(bean.getExpRecordsforBarCode(srl_no)!=null && bean.getExpRecordsforBarCode(srl_no).size()>0){
					OldExpRecords =  bean.getExpRecordsforBarCode(srl_no);
					int pdoc_srl_no = srl_no ;
					int OldExp = OldExpRecords.size();
					for ( int m1=0; m1 < alBatchRecords_tmp.size(); m1++ ){
					boolean isExist = false;
					CurrBatchRecords =(HashMap)alBatchRecords_tmp.get(m1) ;					
					for ( int m2 = 0 ; m2 < OldExp ; m2++){
					HashMap exp = (HashMap)OldExpRecords.get(m2);
					if (( CurrBatchRecords.get("ITEM_CODE").equals(exp.get("ITEM_CODE")) &&  CurrBatchRecords.get("BATCH_ID").equals(exp.get("BATCH_ID")) &&  CurrBatchRecords.get("EXPIRY_DATE").equals(exp.get("EXPIRY_DATE"))	&& 	CurrBatchRecords.get("BIN_LOCATION_CODE").equals(exp.get("BIN_LOCATION_CODE")) &&  CurrBatchRecords.get("TRADE_ID").equals(exp.get("TRADE_ID")))){
					isExist = true;
					}  					
					}
					if (!isExist){
					System.out.println("check in SalesListDetail.jsp ...CurrBatchRecords.."+CurrBatchRecords);
					OldExpRecords.add(CurrBatchRecords);
					System.out.println("check in SalesListDetail.jsp ...OldExpRecords.."+OldExpRecords);
					}				
					}					
					bean.setExpRecordsforBarCode( pdoc_srl_no, OldExpRecords);
				}
				else{
					ArrayList alBatchRecords_tmp1 = new ArrayList(bean.getTempBatchRecords());
					bean.setExpRecordsforBarCode(srl_no, alBatchRecords_tmp1);
				}
				System.out.println("setting data"+bean.getTempBatchRecords());
			   }
			   catch(Exception exception){
					exception.printStackTrace();
					flag			=	"SET_IN_BEAN";
					result			=	false;
				}
		}//Added for GHL-CRF-0413 ends 
		
		/*GHL-CRF-0419.2 STARTS*/
		else if(validate.equals("RESTRICT_EM_OP")) 
		{ 
			System.err.println("RESTRICT_EM_OP starts");
			String patient_id1 = request.getParameter("patient_id");
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			int count=0;
			try
			{
				 con=ConnectionManager.getConnection();
				 stmt=con.prepareStatement("SELECT COUNT(*) result FROM PR_ENCOUNTER WHERE ADT_STATUS IN ('00','01') AND PATIENT_ID=? and PATIENT_CLASS IN ('DC','IP')");
				 stmt.setString(1, patient_id1);
				 rs=stmt.executeQuery();
				 if(rs!=null && rs.next())
				 {
					count=rs.getInt(1); 
					out.println("setflagcount(\""+count+"\");");
					//out.println("setflagvount('document.formSalesHeader.flagcount' = '"+count+"';");					
				 }	 
				 
				 //bean.getTempBatchRecords().clear();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				flag			=	"clearTmpBean";
				result			=	false;
			}
		}
		/*GHL-CRF-0419.2 ENDS*/
		}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
		System.out.println(exception.toString());
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean( "salesBean",bean,request);
%>
