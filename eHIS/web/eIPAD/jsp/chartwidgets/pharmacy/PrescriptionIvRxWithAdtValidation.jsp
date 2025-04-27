<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.pharmacy.response.PharmFieldResponse"%>
<%@page import="eIPAD.chartsummary.pharmacy.healthobject.PharmFieldItem"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="ePH.IVPrescriptionBean"%>
<%@page import="com.google.gson.Gson"%> 
<%@page  import="java.sql.*,java.text.DecimalFormat, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*, com.ehis.util.* "  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
try{ 
	String validate		= request.getParameter("validate")==null?"":request.getParameter("validate");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");
	IVPrescriptionBean bean_IVD 	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
	String locale = bean_IVD.getLanguageId();
	String patient_id	= bean_IVD.getPatId();
	String encounter_id	= bean_IVD.getEncId();
	String order_date	= bean_IVD.getOrderDate();
	String pat_class	= bean_IVD.getPatientClass();
	String priority = "R";
	String take_home_medication = "N";
	validate	=	validate.trim();
	
	if(validate.equals("DosageLimitCheck")){
		patient_id			= (String)hash.get("patient_id");
		String drug_code	= (String)hash.get("drug_code");
		String srl_no	= (String)hash.get("srl_no");
		String repeat_value			= (String)hash.get("repeat_value");
		String qty_value				= (String)hash.get("qty_value");
		String dosage_type				= (String)hash.get("dosage_type");

		ArrayList drugList	= bean_IVD.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		String extdrugCode = "";
		String extsrlNo = "";

		HashMap dosageDetails= (HashMap) bean_IVD.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value);
		String limit_ind= (String) dosageDetails.get("LIMIT_IND");

		if(drugList!=null && drugList.size()>0){
			for(int i=0;i<drugList.size();i++){
				drugDetails				= (HashMap)drugList.get(i);
				if(drugDetails.size()>0){ //If 'condition alone' added for SRR20056-SCF-7650  Incident No. 27732
					extdrugCode				= (String)drugDetails.get("DRUG_CODE");
					extsrlNo				= (String)drugDetails.get("SRL_NO");
					if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){					
						drugDetails.put("LIMIT_IND",limit_ind);
						if(limit_ind.equals("Y"))
							drugDetails.put("DOSE_REMARKS","");
					}
				}
			}
		}
		
		if(limit_ind != null && limit_ind.equals("N")){
			String daily_dose = (String) dosageDetails.get("DAILY_DOSE");
			String unit_dose = (String) dosageDetails.get("UNIT_DOSE");
			String mono_graph = (String) dosageDetails.get("MONO_GRAPH");			
			String min_daily_dose= (String) dosageDetails.get("MIN_DAILY_DOSE");
			String min_unit_dose= (String) dosageDetails.get("MIN_UNIT_DOSE");
			mono_graph=mono_graph.replaceAll(" ","%20");
			mono_graph = java.net.URLEncoder.encode(mono_graph,"UTF-8");
			mono_graph=mono_graph.replaceAll("%2520","%20");
			out.println("enableDosageLimit('"+limit_ind+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+min_daily_dose+"','"+min_unit_dose+"','"+srl_no+"')");
		}
		else
			out.println("disableDosageLimit('"+srl_no+"')");
	}
		else if(validate.equals("POPULATEENDDATE")) {
		String start_date	= (String)hash.get("start_date"); 
		String durn_value	= (String)hash.get("durn_value"); 
		String durn_unit	= (String)hash.get("durn_unit"); 
		String end_date		= bean_IVD.populateEndDate(start_date, durn_value, durn_unit);
		out.println("setEndDate('"+ end_date +"','document.formIVPrescriptionDetails.end_date_fluid');");
	}
	else if (validate != null && validate.equals("changeFluid" )){
 	 	String drug_code	= (String)hash.get("fluid_code");
		String trade_code	= (String)hash.get("trade_code");
		String location_code = (String)hash.get("location_code");
			if(trade_code == null){trade_code = "";}
			bean_IVD.setFldTradeCode(trade_code);			
			bean_IVD.setFluidDetails(drug_code,pat_class,priority,location_code,take_home_medication);			
			HashMap fluid_det =(HashMap)bean_IVD.getFluidDetails();			
			String  fluid_stock_uom	= (String) fluid_det.get("FLUID_STOCK_UOM");
			String fluid_stock_uom_desc = bean_IVD.getUomDisplay((String)hash.get("facility_id"),fluid_stock_uom);
			fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
			fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
			fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");			
			String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");		
			bean_IVD.setMFRRecs(new HashMap());
			bean_IVD.setMFRYN("N");			
			String infuse	=	bean_IVD.getInfuseOverValue(drug_code);
			HashMap fluid_details = null;
			fluid_details = bean_IVD.getFluidDetails();
			if(fluid_details !=null){
				String STRENGTH_PER_VALUE_PRES_UOM = (String)fluid_details.get("STRENGTH_PER_VALUE_PRES_UOM");
				String BUILD_MAR_YN = (String)fluid_details.get("BUILD_MAR_YN");
				String PRES_QTY_UOM = (String)fluid_details.get("PRES_QTY_UOM");
				String start_date_fluid = bean_IVD.getSysdate();
				String end_date_fluid	=  bean_IVD.populateEndDate(start_date_fluid,"24","H");
				String trade_codee = (String)fluid_details.get("trade_code");				
				String infuse_over_hrs = (String)fluid_details.get("INFUSION_PERIOD_VALUE");
				String infuse_over_mis = (String)fluid_details.get("INFUSION_PERIOD_VALUE_MIN");				
				out.println("resetFluidDetails('"+STRENGTH_PER_VALUE_PRES_UOM+"','"+infuse_over_hrs+"','"+infuse_over_mis+"','"+BUILD_MAR_YN+"','"+PRES_QTY_UOM+"','"+start_date_fluid+"','"+end_date_fluid+"','"+trade_codee+"');");
			}			
	}
	else if (validate.equals("STOCKDETAILS")){
		String drug_code		 = request.getParameter("drug_code");
		String mode				 = request.getParameter("mode");
		String orderType		 = bean_IVD.getOrderType(drug_code);
		ArrayList orderSetValues = bean_IVD.getOrderSetValues();
		ArrayList stockDetails   = null;
		if(orderSetValues.size() >0){
			if(orderSetValues.get(0).equals(drug_code)){
				String oQty_value = (String)orderSetValues.get(1);
				String oQty_unit  = (String)orderSetValues.get(2);
				String build_MAR  = "";
				if (bean_IVD.checkForStock()) {
					stockDetails = bean_IVD.getStockDetails(drug_code, "1");
					out.println("setStockDetails(1, '"+ oQty_value + "', '" + oQty_unit + "','"+bean_IVD.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1))+"','"+ build_MAR + "');");
				}
			}
		}
		else{
			bean_IVD.setFluidDetails(drug_code,"","","","");
			if (bean_IVD.checkForStock()) {
				stockDetails = bean_IVD.getStockDetails(drug_code, "1");
				
					if (stockDetails.size() != 0){
						HashMap fluid_det =(HashMap)bean_IVD.getFluidDetails();
						String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
						String fluid_stock_uom_desc = bean_IVD.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
						fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
						fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
						fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
						out.println("setStockDetails(1, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "','" +bean_IVD.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1))+"','"+ fluid_stock_uom_desc + "');") ; // stockDetails.get(2)  replaced with bean_IVD.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
					}
					else
						out.println("setStockDetails(2);") ;				
			}
		}
	}
	else if(validate.equals("RELEASE")) {
		String fluid_code	= (String)hash.get("fluid");
		patient_id = request.getParameter("patient_id");
		encounter_id = request.getParameter("encounter_id");
		String patient_class = request.getParameter("patient_class");
		String volume = request.getParameter("volume");
		String narcotic_yn = "";
		bean_IVD.setPatId(patient_id);
		bean_IVD.setEncId(encounter_id);
		bean_IVD.setPatientClass(patient_class);
		bean_IVD.setVOLUME(volume);
		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();
		ArrayList DrugRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable
		int seq_num = 0;
		if(bean_IVD.getOrderID() == null || (bean_IVD.getOrderID()).equals(""))
			bean_IVD.setOrderID();
		String order_id	= bean_IVD.getOrderID();
		String order_format_values = "";
		arrSeq_num = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code, fluid_code+"_0");
		if(arrSeq_num!= null && arrSeq_num.size() >0) {
			int i=0;
			for(i=0;i<arrSeq_num.size();i++) {
				seq_num		= Integer.parseInt((String)arrSeq_num.get(i));	// get the seq_num
				template	= (java.util.Hashtable)	orderEntryRecordBean.getOrderFormats(fluid_code, (fluid_code+seq_num));
				orderFormatHash.put("seq_num"+i,String.valueOf(seq_num));
				orderFormatHash.put("field_mnemonic"+i,(String) template.get("field_mnemonic"));
				orderFormatHash.put("label_text"+i,(String) template.get("label_text"));
				orderFormatHash.put("accept_option"+i,(String) template.get("accept_option"));
				orderFormatHash.put("field_type"+i,(String) template.get("field_type"));
				orderFormatHash.put("field_values"+i,(String) template.get("field_values"));
				order_format_values = order_format_values + ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
			}
			orderFormatHash.put("order_format_count", (String.valueOf(i)));
			orderFormatHash.put("order_id", order_id);
			orderFormatHash.put("order_format_values", order_format_values);
		}
		else {
			orderFormatHash.put("order_format_count", "0");
			orderFormatHash.put("order_id", order_id);
			orderFormatHash.put("order_format_values", "");
		}
		DrugRemarks.add(orderFormatHash);
		ArrayList drugList	= bean_IVD.getDrugDetails();
		boolean cont_flag	= true;
		TreeSet ordStat		= new TreeSet();
		HashMap fluid_details = bean_IVD.getFluidDetails();
		String FLUID_CODE = hash.get("FLUID_CODE")==null?"":hash.get("FLUID_CODE").toString();
		String VOLUME = hash.get("VOLUME")==null?"":hash.get("VOLUME").toString();
		String STRENGTH_PER_VALUE_PRES_UOM = hash.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":hash.get("STRENGTH_PER_VALUE_PRES_UOM").toString();
		String buildMAR_yn = hash.get("buildMAR_yn")==null?"N":hash.get("buildMAR_yn").toString();
		String infusion_over_insert_value = hash.get("infusion_over_insert_value")==null?"":hash.get("infusion_over_insert_value").toString();
		String INFUSION_PERIOD_UOM = hash.get("INFUSION_PERIOD_UOM")==null?"H":hash.get("INFUSION_PERIOD_UOM").toString();
		String IV_PRESC_YN = hash.get("IV_PRESC_YN")==null?"N":hash.get("IV_PRESC_YN").toString();
		String FLUID_UNIT_QTY = hash.get("STOCK_VALUE")==null?"":hash.get("STOCK_VALUE").toString();
		String ORDER_TYPE_CODE = hash.get("ORDER_TYPE_CODE")==null?"":hash.get("ORDER_TYPE_CODE").toString();
		String INFUSION_VALUE = hash.get("INFUSION_VALUE")==null?"":hash.get("INFUSION_VALUE").toString();
		String START_DATE = hash.get("START_DATE")==null?"":hash.get("START_DATE").toString();
		String END_DATE = hash.get("END_DATE")==null?"":hash.get("END_DATE").toString();
		String FREQUENCY = hash.get("FREQUENCY")==null?"":hash.get("FREQUENCY").toString();
		String DURN_TYPE = hash.get("DURN_TYPE")==null?"":hash.get("DURN_TYPE").toString();
		String DURN_UNIT = hash.get("DURN_UNIT")==null?"":hash.get("DURN_UNIT").toString();
		String DURN_VALUE = hash.get("DURN_VALUE")==null?"":hash.get("DURN_VALUE").toString();
		String DRUG_DESC = hash.get("DRUG_DESC")==null?"":hash.get("DRUG_DESC").toString();
		if(!DRUG_DESC.equals(""))
			DRUG_DESC = java.net.URLDecoder.decode(DRUG_DESC,"UTF-8");					
		String INFUSION_UOM_DISPLAY = hash.get("INFUSION_UOM_DISPLAY")==null?"":hash.get("INFUSION_UOM_DISPLAY").toString();					
		String INFUSION_PERIOD_VALUE = hash.get("INFUSION_PERIOD_VALUE")==null?"":hash.get("INFUSION_PERIOD_VALUE").toString();
		String INFUSION_PERIOD_VALUE_MIN = hash.get("INFUSION_PERIOD_VALUE_MIN")==null?"":hash.get("INFUSION_PERIOD_VALUE_MIN").toString();		
		fluid_details.put("INFUSION_PERIOD_VALUE", INFUSION_PERIOD_VALUE);
		fluid_details.put("INFUSION_PERIOD_VALUE_MIN", INFUSION_PERIOD_VALUE_MIN);		
		fluid_details.put("DRUG_CODE", FLUID_CODE);
		fluid_details.put("DRUG_DESC", DRUG_DESC);
		fluid_details.put("VOLUME", VOLUME);
		fluid_details.put("QTY_VALUE", VOLUME);		
		fluid_details.put("STRENGTH_PER_VALUE_PRES_UOM", STRENGTH_PER_VALUE_PRES_UOM);
		fluid_details.put("FLUID_UNIT_QTY", FLUID_UNIT_QTY);
		fluid_details.put("ORDER_TYPE_CODE", ORDER_TYPE_CODE);
		fluid_details.put("SCH_INFUSION_RATE", INFUSION_VALUE);
		fluid_details.put("START_DATE", START_DATE);
		fluid_details.put("END_DATE", END_DATE);
		fluid_details.put("FREQ_CODE", FREQUENCY);
		fluid_details.put("DURN_TYPE", DURN_TYPE);
		fluid_details.put("DURN_UNIT", DURN_UNIT);
		fluid_details.put("FLUID_UNIT_QTY_UOM", INFUSION_UOM_DISPLAY);
		fluid_details.put("SCH_INFUSION_VOL_STR_UNIT", INFUSION_UOM_DISPLAY);
		fluid_details.put("DURN_VALUE", DURN_VALUE);
		fluid_details.put("BUILD_MAR_YN", buildMAR_yn);
		fluid_details.put("INFUSE_OVER_UNIT", INFUSION_PERIOD_UOM);
		
		bean_IVD.setINFUSE_OVER(infusion_over_insert_value);
		bean_IVD.setINFUSION_RATE(INFUSION_VALUE);
		bean_IVD.setBuildMAR_yn(buildMAR_yn);
		if (drugList.size() != 0) {
			int i = 0;
			String allergy_override		= "";
			String dose_override		= "";
			String currentrx_override	= "";
			String currentrx_remarks	= "";
			String allergy_remarks		= "";
			String dose_remarks			= "";	
			String external_database_overrided_reason			= "";	
			String perform_external_database_checks_yn			= "";	
			narcotic_yn = "N";
			for(i=0;i<drugList.size();i++) {
				HashMap drugDetails = (HashMap)drugList.get(i);
				if (drugDetails.size() != 0) {
					if((String)drugDetails.get("DRUG_CLASS") != null && ((String)drugDetails.get("DRUG_CLASS")).equals("N"))
						narcotic_yn = "Y";					
					orderFormatHash	= new HashMap();	// To store it in the HashMap
					arrSeq_num		= new ArrayList();	// get the seq in ArrayList
					template		= new Hashtable();	// get the template values in the HashTable
					seq_num 		= 0;
					order_format_values	= "";
					String catalog_code	= (String)drugDetails.get("DRUG_CODE");
					String drug_code = (String)hash.get("DRUG_CODE"+i);
					String CALC_DOSE_BASED_ON = hash.get("CALC_DOSE_BASED_ON"+i)==null?"":hash.get("CALC_DOSE_BASED_ON"+i).toString();
					String DOSAGE_TYPE = hash.get("DOSAGE_TYPE"+i)==null?"":hash.get("DOSAGE_TYPE"+i).toString();
					String STRENGTH_VALUE = hash.get("STRENGTH_VALUE"+i)==null?"":hash.get("STRENGTH_VALUE"+i).toString();;
					String STRENGTH = hash.get("STRENGTH"+i)==null?"":hash.get("STRENGTH"+i).toString();;				
					String OR_QTY_DESC = hash.get("OR_QTY_DESC"+i)==null?"":hash.get("OR_QTY_DESC"+i).toString();
					String QTY_UNIT = hash.get("QTY_UNIT"+i)==null?"":hash.get("QTY_UNIT"+i).toString();
					String QTY_UOM = hash.get("QTY_UOM"+i)==null?"":hash.get("QTY_UOM"+i).toString();
					String PRES_QTY_UOM = hash.get("PRES_QTY_UOM"+i)==null?"":hash.get("PRES_QTY_UOM"+i).toString();
					String Dosage_Uom = hash.get("Dosage_Uom"+i)==null?"":hash.get("Dosage_Uom"+i).toString();
					String QTY_VALUE = hash.get("QTY_VALUE"+i)==null?"":hash.get("QTY_VALUE"+i).toString();
					String CALC_DOSE_VALUE = hash.get("CALC_DOSE_VALUE"+i)==null?"":hash.get("CALC_DOSE_VALUE"+i).toString();
					String CALC_DOSE_BY = hash.get("CALC_DOSE_BY"+i)==null?"":hash.get("CALC_DOSE_BY"+i).toString();
					String CURRENTRX_REMARKS = hash.get("CURRENTRX_REMARKS"+i)==null?"":hash.get("CURRENTRX_REMARKS"+i).toString();
					if(!CURRENTRX_REMARKS.equals(""))
						CURRENTRX_REMARKS = java.net.URLDecoder.decode(CURRENTRX_REMARKS,"UTF-8");
					String DOSE_REMARKS = hash.get("DOSE_REMARKS"+i)==null?"":hash.get("DOSE_REMARKS"+i).toString();
					if(!DOSE_REMARKS.equals(""))
						DOSE_REMARKS = java.net.URLDecoder.decode(DOSE_REMARKS,"UTF-8");
					String ALLERGY_REMARKS = hash.get("ALLERGY_REMARKS"+i)==null?"":hash.get("ALLERGY_REMARKS"+i).toString();
					if(!ALLERGY_REMARKS.equals(""))
						ALLERGY_REMARKS = java.net.URLDecoder.decode(ALLERGY_REMARKS,"UTF-8");					
					String DRUG_INDICATION = hash.get("DRUG_INDICATION"+i)==null?"":hash.get("DRUG_INDICATION"+i).toString();
					String DRUG_REMARKS = hash.get("DRUG_REMARKS"+i)==null?"":hash.get("DRUG_REMARKS"+i).toString();
					if(!DRUG_INDICATION.equals(""))
						DRUG_INDICATION = java.net.URLDecoder.decode(DRUG_INDICATION,"UTF-8");				
					if(catalog_code.equals(drug_code)) {
						drugDetails.put("CALC_DOSE_BASED_ON", CALC_DOSE_BASED_ON);
						drugDetails.put("DOSAGE_TYPE", DOSAGE_TYPE);
						drugDetails.put("START_DATE", START_DATE);
		                drugDetails.put("END_DATE", END_DATE);
						drugDetails.put("STRENGTH_VALUE", STRENGTH);
						drugDetails.put("OR_QTY_DESC", OR_QTY_DESC);
						drugDetails.put("QTY_UNIT", QTY_UNIT);
						drugDetails.put("QTY_UOM", QTY_UOM);
						drugDetails.put("PRES_QTY_UOM", PRES_QTY_UOM);
						drugDetails.put("Dosage_Uom", Dosage_Uom);
						drugDetails.put("QTY_VALUE", QTY_VALUE);
						drugDetails.put("CURRENTRX_REMARKS", CURRENTRX_REMARKS);
						drugDetails.put("DOSE_REMARKS", DOSE_REMARKS);
						drugDetails.put("ALLERGY_REMARKS", ALLERGY_REMARKS);
						drugDetails.put("DRUG_INDICATION", DRUG_INDICATION);
						drugDetails.put("DRUG_REMARKS", DRUG_REMARKS);
						if(CALC_DOSE_BASED_ON.equals("D")) {
							String QTY_DESC_CODE = hash.get("QTY_DESC_CODE"+i)==null?"":hash.get("QTY_DESC_CODE"+i).toString();
							String QTY_DESC = hash.get("QTY_DESC"+i)==null?"":hash.get("QTY_DESC"+i).toString();
							if(!QTY_DESC.equals(""))
								QTY_DESC = java.net.URLDecoder.decode(QTY_DESC,"UTF-8");
							
							drugDetails.put("QTY_DESC_CODE", QTY_DESC_CODE);
							drugDetails.put("QTY_DESC", QTY_DESC);
							
							if(DOSAGE_TYPE.equals("S")){
								 STRENGTH = hash.get("STRENGTH"+i)==null?"":hash.get("STRENGTH"+i).toString();
								drugDetails.put("STRENGTH", STRENGTH);
								drugDetails.put("STRENGTH_VALUE", STRENGTH);
							}
							else {
								String PRES_QTY_VALUE = hash.get("PRES_QTY_VALUE"+i)==null?"":hash.get("PRES_QTY_VALUE"+i).toString();
								drugDetails.put("PRES_QTY_VALUE", PRES_QTY_VALUE);
							}
						}
						else {
							drugDetails.put("CALC_DOSE_VALUE", CALC_DOSE_VALUE);
							drugDetails.put("CALC_DOSE_BY", CALC_DOSE_BY);
							 STRENGTH = hash.get("STRENGTH"+i)==null?"":hash.get("STRENGTH"+i).toString();
							drugDetails.put("STRENGTH", STRENGTH);
							drugDetails.put("STRENGTH_VALUE", STRENGTH);							
						}
					}
					arrSeq_num = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, catalog_code+"_0");
					if(arrSeq_num!= null && arrSeq_num.size() >0) {
						int k=0;
						for(k=0;k<arrSeq_num.size();k++) {
							seq_num		= Integer.parseInt((String)arrSeq_num.get(k));	// get the seq_num
							template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
							orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
							orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
							orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
							orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
							orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
							orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
							order_format_values = order_format_values + ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
						}
						orderFormatHash.put("order_format_count", (String.valueOf(k)));
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", order_format_values);
						orderFormatHash.put("fr_drug_code", drug_code);
					}
					else {
						orderFormatHash.put("order_format_count", "0");
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", "");
						orderFormatHash.put("fr_drug_code", drug_code);
					}
					
					
					DrugRemarks.add(orderFormatHash);
					cont_flag					= true;
					allergy_override		= "";
					dose_override		= "";
					currentrx_override	= "";
					currentrx_remarks	= "";
					allergy_remarks		= "";
					dose_remarks			= "";	
					if(drugDetails.containsKey("ALLERGY_YN") && drugDetails.get("ALLERGY_YN")!=null)
						allergy_override		= (String)drugDetails.get("ALLERGY_YN");
					if(drugDetails.containsKey("LIMIT_IND") && drugDetails.get("LIMIT_IND")!=null)
						dose_override		= (String)drugDetails.get("LIMIT_IND");
					if(drugDetails.containsKey("CURRENT_RX") && drugDetails.get("CURRENT_RX")!=null)
						currentrx_override	= (String)drugDetails.get("CURRENT_RX");
					if(drugDetails.containsKey("CURRENTRX_REMARKS") && drugDetails.get("CURRENTRX_REMARKS")!=null)
						currentrx_remarks	= (String)drugDetails.get("CURRENTRX_REMARKS");
					if(!currentrx_remarks.equals(""))
						currentrx_remarks = java.net.URLDecoder.decode(currentrx_remarks,"UTF-8");
					    drugDetails.put("CURRENTRX_REMARKS",currentrx_remarks);
					if(drugDetails.containsKey("ALLERGY_REMARKS") && drugDetails.get("ALLERGY_REMARKS")!=null)
						allergy_remarks		= (String)drugDetails.get("ALLERGY_REMARKS");
					if(!allergy_remarks.equals(""))
						allergy_remarks = java.net.URLDecoder.decode(allergy_remarks,"UTF-8");
					    drugDetails.put("ALLERGY_REMARKS",allergy_remarks);
					if(drugDetails.containsKey("DOSE_REMARKS") && drugDetails.get("DOSE_REMARKS")!=null)
						dose_remarks			= (String)drugDetails.get("DOSE_REMARKS");
					if(!dose_remarks.equals(""))
						dose_remarks = java.net.URLDecoder.decode(dose_remarks,"UTF-8");
					    drugDetails.put("DOSE_REMARKS",dose_remarks);
					if ((allergy_override.equals("Y") && allergy_remarks.equals("")) || (dose_override.equals("N") && dose_remarks.equals(""))  || (currentrx_override.equals("Y") && currentrx_remarks.equals(""))) {
						cont_flag = false;
					}
					perform_external_database_checks_yn	= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
					external_database_overrided_reason	= (String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON")==null?"":(String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON");
					if(perform_external_database_checks_yn.equals("Y") && (external_database_overrided_reason.equals("") || external_database_overrided_reason.equals("N")))
						cont_flag = false;
					if (cont_flag) {
						String ord_auth_reqd_yn			= "";
						String ord_appr_reqd_yn			= "";
						String ord_cosign_reqd_yn		= "";
						String init_auth_reqd_yn		= "";
						String init_spl_appr_reqd_yn	= "";
						String init_cosign_reqd_yn		= "";
						if(drugDetails.containsKey("ORD_AUTHORIZED_YN") && drugDetails.get("ORD_AUTHORIZED_YN")!=null)
							ord_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTHORIZED_YN");
						if(drugDetails.containsKey("ORD_APPROVED_YN") && drugDetails.get("ORD_APPROVED_YN")!=null)
							ord_appr_reqd_yn		= (String)drugDetails.get("ORD_APPROVED_YN");
						if(drugDetails.containsKey("ORD_COSIGNED_YN") && drugDetails.get("ORD_COSIGNED_YN")!=null)
							ord_cosign_reqd_yn		= (String)drugDetails.get("ORD_COSIGNED_YN");
						if(drugDetails.containsKey("ORD_AUTH_REQD_YN") && drugDetails.get("ORD_AUTH_REQD_YN")!=null)
							init_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTH_REQD_YN");
						if(drugDetails.containsKey("ORD_SPL_APPR_REQD_YN") && drugDetails.get("ORD_SPL_APPR_REQD_YN")!=null)
							init_spl_appr_reqd_yn	= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
						if(drugDetails.containsKey("ORD_COSIGN_REQD_YN") && drugDetails.get("ORD_COSIGN_REQD_YN")!=null)
							init_cosign_reqd_yn		= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
						String order_status				= "";

						if(init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("N")){
							order_status="10";
						}
						else if (init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("Y")) {
							if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
								order_status	=	"10";
							else
								order_status	=	"05";
						}
						else if (init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("N")) {
							if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
								order_status	=	"10";
							else
								order_status="03";
						}
						else if(init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("Y")){
							if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) )
								order_status="10";
							else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
								order_status="03";
							else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
								order_status="05";
							else 
								order_status="05";
						}
						if(drugDetails.get("CONSENT_REQD_YN").equals("Y") && drugDetails.get("CONSENT_STAGE").equals("A"))
							order_status = "00"; 
						ordStat.add(order_status);
					}
					else {
						out.println("mandateRemarks();");
						break;
					}
				}
			}

			if (cont_flag) {
				if (ordStat.size() != 0){
					bean_IVD.setOrderStatus(ordStat.first().toString());
				}
			}
		}
		//if (cont_flag) {
		//ArrayList OrderID=(ArrayList)bean.genOrderID(groupSize,patient_class);
		
		//Drug remarks related code for EM Mobility STARTS
		//This code is written since DRUG_REMARKS has only one text field in EM Mobility as opposed to OrderFormat fields followed elsewhere
		HashMap drugRemarksHash = new HashMap();
		for(int j=0;j<drugList.size();j++){
			HashMap ext_drugData		=   (HashMap) drugList.get(j);
			String drug_code			=   (String) ext_drugData.get("DRUG_CODE");
			String drug_remstr			=   (String) ext_drugData.get("DRUG_REMARKS")==null?"":(String) ext_drugData.get("DRUG_REMARKS");
			drugRemarksHash.put(drug_code, drug_remstr);
		}
		for(int j=0;j<DrugRemarks.size();j++){
			HashMap orderDrugItem = (HashMap)DrugRemarks.get(j);
			String orderDrug_drugCode = (String)orderDrugItem.get("fr_drug_code");
			int compCount = 0;//alsways zero since we assume only one component in drug remarks for pharmacy drug alone
			if(drugRemarksHash.containsKey(orderDrug_drugCode)){
				String drug_remstr = (String)drugRemarksHash.get(orderDrug_drugCode);
				orderDrugItem.put("order_format_values", "DRUG_REMARKS : "+drug_remstr);
				orderDrugItem.put("field_values"+compCount, drug_remstr);
				orderDrugItem.put("label_text"+compCount, "DRUG_REMARKS");
				orderDrugItem.put("field_type"+compCount, "A");
				orderDrugItem.put("order_format_count", "1");
				orderDrugItem.put("seq_num"+compCount, "0");
				orderDrugItem.put("field_mnemonic"+compCount, "DRUG_REMARKS");
				orderDrugItem.put("accept_option"+compCount, "O");
			}
		}
			
		bean_IVD.genDrugRemarks(DrugRemarks);	
		//Drug remarks related code for EM Mobility STARTS
		//}
		out.println("okClickDialog();");		
	}
	else if (validate.equals("DRUGCODES")) {
		String drugCodes = request.getParameter("drugCodes");
		String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		String starting_date = request.getParameter("starting_date")==null?"":request.getParameter("starting_date");
		String Trade_Codes = request.getParameter("Trade_Codes")==null?"":request.getParameter("Trade_Codes");
		String Trade_Names = request.getParameter("Trade_Names")==null?"":request.getParameter("Trade_Names");
		String resp_id = request.getParameter("resp_id")==null?"":request.getParameter("resp_id");
		String pract_id = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String selected_drug_codes = request.getParameter("selected_drug_codes")==null?"":request.getParameter("selected_drug_codes");
		String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code"); // RUT-CRF-0062 [IN029600] moved from below 
		priority					= request.getParameter("priority")==null?"":request.getParameter("priority"); // RUT-CRF-0062 [IN029600] moved from below 
		String act_patient_class		= hash.get( "act_patient_class" )==null?"":hash.get( "act_patient_class").toString(); // RUT-CRF-0062 Added to get the Build MAR Rule
		take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication"); // RUT-CRF-0062 Added to get the Build MAR Rule
       if(! bean_IVD.getLanguageId().equals("en"))
           starting_date =com.ehis.util.DateUtils.convertDate(starting_date,"DMYHM",bean_IVD.getLanguageId(),"en");
		bean_IVD.setOrderDate(starting_date);
		bean_IVD.setDrgTradeCodesArray(Trade_Codes);
		bean_IVD.setDrugDetails(drugCodes, pract_id, resp_id,"","","",""); // CRF-0062 NEWLY ADDED
		ArrayList drugList		   = (ArrayList)bean_IVD.getDrugDetails();
		ArrayList dfltFluidDetails = null;
		if(drugList.size()==1){
			dfltFluidDetails = bean_IVD.getCompFluidDetails(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
		}
		else if (drugList.size()>1){
			selected_drug_codes += drugCodes.substring(0,drugCodes.length()-1);
			dfltFluidDetails = bean_IVD.getCompFluidDetailsForMultipeDrugs(selected_drug_codes,pract_id,resp_id);
		}
		if(mode.equals("5"))
			out.println("refreshLocation('" + patient_id + "', '" + encounter_id + "', '5','"+pat_class+"');") ;
		else
			out.println("refreshLocation('" + patient_id + "','" + encounter_id + "', '1','"+pat_class+"');") ;

		out.println("clearDfltVehicle();");
		int fluid_adr_count = 0;
		if(dfltFluidDetails != null && dfltFluidDetails.size()>0){
			String dfltFluidCode ="";
			for(int j=0; j<dfltFluidDetails.size();j+=7 ){
				fluid_adr_count = bean_IVD.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
				out.println("assignDfltVehicle('"+ dfltFluidDetails.get(j) + "', '" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+1)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "', '" + dfltFluidDetails.get(j+2)+ "','" + dfltFluidDetails.get(j+3)+ "','" + dfltFluidDetails.get(j+4)+ "','" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+5)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "','" + fluid_adr_count + "');") ;
				if(dfltFluidCode.equals("") && ((String)dfltFluidDetails.get(j+3)).equals("Y"))
					dfltFluidCode = (String)dfltFluidDetails.get(j);
			}
			if(dfltFluidCode.equals(""))
				dfltFluidCode = (String)dfltFluidDetails.get(0);
			bean_IVD.setFluidDetails(dfltFluidCode,act_patient_class,priority,location_code,take_home_medication); // CRF-0062 Added to get the Build MAR Rule
            HashMap fluid_det =(HashMap)bean_IVD.getFluidDetails();			
			String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
			String fluid_stock_uom_desc = bean_IVD.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
			fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
			fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
			fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
			String	back_date					= (String) fluid_det.get("BACK_DATE");
			String  future_date					= (String) fluid_det.get("FUTURE_DATE");
			out.println("setBackFutureDate('"+ back_date +"','"+ future_date +"');");			
			String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
			String buildMARRule=(String)fluid_det.get("BUILD_MAR_RULE");
			out.println("setBuildMAR('"+buildMARRule+"');");
			if (bean_IVD.checkForStock()) {
				ArrayList stockDetails = bean_IVD.getStockDetails(dfltFluidCode, "1");
				if (stockDetails.size() != 0){
					out.println("setStockDetails(3, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" +bean_IVD.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "','"+fluid_stock_uom_desc+"');") ; // stockDetails.get(2)  replaced with bean_IVD.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949]  by Sureshkumar T on 06/06/2012
				}
				else{
					out.println("setStockDetails(2);") ;
				}
			}
			out.println("setOrderType('"+ orderType + "');");
			String infuse	=	bean_IVD.getInfuseOverValue(dfltFluidCode);
			out.println("setInfuseValue('"+infuse+ "',1);");
		}
		String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	 	String dflt_disp_locn	= "";	
		ArrayList ord_disp_location  = (ArrayList) bean_IVD.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added for Bru-HIMS-CRF-347 [IN:037862] ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
		if(ord_disp_location != null & ord_disp_location.size()>0)
			dflt_disp_locn	= (String)ord_disp_location.get(2);
		out.println("displayDispLocn('"+dflt_disp_locn+"');");
	}
	else if(validate.equals("POPULATEENDDATEADMIN")) {
		String start_date	= request.getParameter("start_date");
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		String mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
		String end_date		= bean_IVD.populateEndDate(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",bean_IVD.getLanguageId(),"en"), durn_value, durn_unit);  // convertDate added for LEAP-INT-PH-SCF-14826 [IN:057866]
		if(!bean_IVD.getLanguageId().equals("en")){
			end_date=com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",bean_IVD.getLanguageId());  // convertDate added for LEAP-INT-PH-SCF-14826 [IN:057866]
		}		
		out.println("setEndDate('"+ end_date +"', 'document.formIVPrescriptionDetails.end_date_fluid');");
	}else if (validate.equals("FLUIDDETAILS")) {
		String drug_code	= request.getParameter("drug_code");
		String trade_code	= request.getParameter("trade_code");
			if(trade_code == null){trade_code = "";}
		bean_IVD.setFldTradeCode(trade_code);
		bean_IVD.setFluidDetails(drug_code,"","","",""); // CRF-0062 NEWLY ADDED
		HashMap fluid_det =(HashMap)bean_IVD.getFluidDetails();
		String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
		String fluid_stock_uom_desc = bean_IVD.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
		fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
		fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
		fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");		
		String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
//clearing the mfr details and enabling admin form fields on change of fluid
		bean_IVD.setMFRRecs(new HashMap());
		bean_IVD.setMFRYN("N");		
		int fluid_adr_count = bean_IVD.getADRCount(patient_id,drug_code);   
       if (bean_IVD.checkForStock()) {
			ArrayList stockDetails = bean_IVD.getStockDetails(drug_code, "1");
			if (stockDetails.size() != 0)
				out.println("setStockDetails(1, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" +bean_IVD.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "','"+fluid_stock_uom_desc+"');") ; // stockDetails.get(2)  replaced with bean_IVD.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
			else
				out.println("setStockDetails(2);") ;
		}
		String infuse	=	bean_IVD.getInfuseOverValue(drug_code);
		out.println("setInfuseValue('"+infuse+ "');");
		String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code");
		 priority					= request.getParameter("priority")==null?"":request.getParameter("priority");
		 take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	 	String dflt_disp_locn	= "";	
		ArrayList ord_disp_location  = (ArrayList) bean_IVD.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]

		if(ord_disp_location != null & ord_disp_location.size()>0)
			dflt_disp_locn	= (String)ord_disp_location.get(2);		
	}	
	PersistenceHelper.putObjectInBean(bean_id,bean_IVD,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>
