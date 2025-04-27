<%@page import="java.util.*,java.text.DecimalFormat, ePH.Common.*, ePH.*, eOR.* " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<% 
/*  
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
13/08/2019      IN:070987		    Manickavasagam j                                          SKR-SCF-1254
21/08/2019      IN071018            prathyusha perugupalli                                    NMC-JD-CRF-0026
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
24/10/2019		INO71514			Shazana													  SKR-SCF-1276
27/08/2020      IN073660           Haribabu                                            SKR-SCF-1411
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
4/12/2020	6041			Shazana						Manickam				NMC-JD-CRF-0063				
06/01/2021		TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
8/8/2023		TFS-42591			Sushant Tambe										SKR-SCF-1729
--------------------------------------------------------------------------------------------------------------
*/
	String bean_id		= request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
	String validate		= request.getParameter("validate")==null?"":request.getParameter("validate");
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request);
	String patient_id	= bean.getPatId();
	String encounter_id	= bean.getEncId();
	String order_date	= bean.getOrderDate();
	String pat_class	= bean.getPatientClass(); 
	String locale = bean.getLanguageId();
	validate	=	validate.trim();  
	System.out.println("IVPrescriptionValidate validate: "+validate);//added for NMC-JD-CRF-0063
try{
	if (validate.equals("DRUGCODES")) {
		String drugCodes = request.getParameter("drugCodes");
		String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		String starting_date = request.getParameter("starting_date")==null?"":request.getParameter("starting_date");
		String Trade_Codes = request.getParameter("Trade_Codes")==null?"":request.getParameter("Trade_Codes");
		String Trade_Names = request.getParameter("Trade_Names")==null?"":request.getParameter("Trade_Names");
		String resp_id = request.getParameter("resp_id")==null?"":request.getParameter("resp_id");
		String pract_id = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String selected_drug_codes = request.getParameter("selected_drug_codes")==null?"":request.getParameter("selected_drug_codes");
		String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code"); // RUT-CRF-0062 [IN029600] moved from below 
		String priority					= request.getParameter("priority")==null?"":request.getParameter("priority"); // RUT-CRF-0062 [IN029600] moved from below 
		String act_patient_class		= hash.get( "act_patient_class" )==null?"":hash.get( "act_patient_class").toString(); // RUT-CRF-0062 Added to get the Build MAR Rule
		String take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication"); // RUT-CRF-0062 Added to get the Build MAR Rule
		String weight					= request.getParameter("weight")==null?"":request.getParameter("weight");//Added for IN:070451
		String bsa				= request.getParameter("bsa")==null?"":request.getParameter("bsa");//Added for IN:070451
		String pres_drug_code="";//Added for ML-MMOH-CRF-1223
       if(! bean.getLanguageId().equals("en"))
           starting_date =com.ehis.util.DateUtils.convertDate(starting_date,"DMYHM",bean.getLanguageId(),"en");
        bean.setWeight(weight);//Added for IN:070451
		bean.setBSA(bsa);//Added for IN:070451
		bean.setOrderDate(starting_date);
		bean.setDrgTradeCodesArray(Trade_Codes);
		bean.setDrugDetails(drugCodes, pract_id, resp_id,"","","",""); // CRF-0062 NEWLY ADDED
		System.out.println("validate  page 58");
		ArrayList drugList		   = (ArrayList)bean.getDrugDetails();
		ArrayList dfltFluidDetails = null;
		HashMap drug_details = new HashMap();//Added for ML-MMOH-CRF-1223

		if(drugList.size()==1){
			dfltFluidDetails = bean.getCompFluidDetails(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
		}
		else if (drugList.size()>1){
			selected_drug_codes += drugCodes.substring(0,drugCodes.length()-1);
			dfltFluidDetails = bean.getCompFluidDetailsForMultipeDrugs(selected_drug_codes,pract_id,resp_id);
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
				fluid_adr_count = bean.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
				out.println("assignDfltVehicle('"+ dfltFluidDetails.get(j) + "', '" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+1)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "', '" + dfltFluidDetails.get(j+2)+ "','" + dfltFluidDetails.get(j+3)+ "','" + dfltFluidDetails.get(j+4)+ "','" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+5)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "','" + fluid_adr_count + "');") ;
				if(dfltFluidCode.equals("") && ((String)dfltFluidDetails.get(j+3)).equals("Y"))
					dfltFluidCode = (String)dfltFluidDetails.get(j);
			}
			if(dfltFluidCode.equals(""))
				dfltFluidCode = (String)dfltFluidDetails.get(0);
//commented during PE By Naveen
			//String orderType	= bean.getOrderType(dfltFluidCode);
			bean.setFluidDetails(dfltFluidCode,act_patient_class,priority,location_code,take_home_medication); // CRF-0062 Added to get the Build MAR Rule
            HashMap fluid_det =(HashMap)bean.getFluidDetails();
			// SKR-SCF-0288 [IN:029447]  - Chandrasekhar
			String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
			String fluid_stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
			fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
			fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
			fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");

			String	back_date					= (String) fluid_det.get("BACK_DATE");
			String  future_date					= (String) fluid_det.get("FUTURE_DATE");
			out.println("setBackFutureDate('"+ back_date +"','"+ future_date +"');");
			// SKR-SCF-0288 [IN:029447]  - Chandrasekhar
			String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
			// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- begin
			String buildMARRule=(String)fluid_det.get("BUILD_MAR_RULE");
			out.println("setBuildMAR('"+buildMARRule+"');");
			// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- end
			if (bean.checkForStock()) {
				ArrayList stockDetails = bean.getStockDetails(dfltFluidCode, "1");
				if (stockDetails.size() != 0){
					out.println("setStockDetails(3, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" +bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "','"+fluid_stock_uom_desc+"');") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949]  by Sureshkumar T on 06/06/2012
				}
				else{
					out.println("setStockDetails(2);") ;
				}
			}
//Adding start for Ml-MMOH-CRF-1223
			if(drugList.size()>0){
                drug_details = (HashMap)drugList.get(0);
				pres_drug_code =(String)drug_details.get("DRUG_CODE");
			}
//Adding end for ML-MMOH-CRF-1223
			
			out.println("setOrderType('"+ orderType + "');");
			//System.err.println("dfltFluidCode@@@96===="+drugCodes.substring(0,drugCodes.length()-1)+"drugCodes@@@=="+drugCodes+"pres_drug_code=="+pres_drug_code);
			String infuse	=	bean.getInfuseOverValue(dfltFluidCode,pres_drug_code);//Added pres_drug_code for ML-MMOH-CRF-1223
			out.println("setInfuseValue('"+infuse+ "',1);");
		}
		String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	 	String dflt_disp_locn	= "";	
	 	System.out.println(" getTakeHomeMedicationOp - IVPrescriptionValidate: "+bean.getTakeHomeMedicationOp());//added for NMC-JD-CRF-0063  
	 	System.out.println(" getOpDischMedInd - IVPrescriptionValidate: "+bean.getOpDischMedInd());//added for NMC-JD-CRF-0063  
		ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added for Bru-HIMS-CRF-347 [IN:037862] ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
		if(ord_disp_location != null & ord_disp_location.size()>0)
			dflt_disp_locn	= (String)ord_disp_location.get(2);
		out.println("displayDispLocn('"+dflt_disp_locn+"');");
	} 
	else if(validate.equals("getDrugDetails")){
		/*String recno				= request.getParameter("recno").trim();
		int no = Integer.parseInt(recno) - 1;
		ArrayList drugList			= bean.getDrugDetails();
		HashMap drugDetails			= (HashMap)drugList.get(no);

		String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
		String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
		String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
		String qty_value			= (String)drugDetails.get("QTY_VALUE");
		String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
		String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
		String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
		String str_value			= "";
		String uom					= "";
		String qty_uom				= "";*/

		/*if (strength_value.equals("0")) {
			
			str_value	= pres_qty_value;
			qty_uom		= pres_base_uom;
			}
		else {
			if(dosage_type.equals("S")) {
				str_value	= strength_value;
				uom			= strength_uom_desc;
				qty_uom		= 
				}	else {
				str_value	= pres_qty_value;
				}

		}
		if(qty_value!=null && !qty_value.equals("")) {
					str_value	=	qty_value;
				}
		out.println("setDose('" + recno + "', '" + str_value + "','" + uom + "');") ;
		*/
	}
	else if(validate.equals("populateFreq")){
		String chk_val			= (String) hash.get( "chk_val" );
		if(chk_val.equals("Y")) {
			ArrayList cont_freqs	=	bean.loadContFreq();
			out.println("clearFrequency()");
			for(int i=0; i<cont_freqs.size(); i+=2) {
				out.println("addFrequency('"+(String)cont_freqs.get(i)+"','"+(String)cont_freqs.get(i+1)+"','"+chk_val+"')");
			}
		} 
		else {
			ArrayList freq_vals		=	bean.populateFrequencyValues();
			out.println("clearFrequency()");
			for(int i=0; i<freq_vals.size(); i+=2) {
				out.println("addFrequency('"+(String)freq_vals.get(i)+"','"+(String)freq_vals.get(i+1)+"','"+chk_val+"')");
			}
		}

	}
	else if(validate.equals("saveRemarks")){

		String remarks		= (String) hash.get( "remarks" );
		String page_mode	= (String) hash.get( "page_mode" );
		String srl_no		= (String) hash.get( "srl_no" );
	
		if(remarks.equals("")){
			out.println("alertForOverrideReason()");
			return;
		}
		
		if(page_mode!=null && (page_mode.equals("curr_rx")))
			bean.setAmendRxRemarks(srl_no,remarks);	
		else if(page_mode!=null && (page_mode.equals("allergy")))
			bean.setAmendAllergyRemarks(srl_no,remarks);	
		else if(page_mode!=null && (page_mode.equals("over_dose")))
			bean.setAmendDoseRemarks(srl_no,remarks);			
		else	
			bean.setAmendRemarks(remarks);
		
		out.println("callClose('OK')");
	}
	else if (validate.equals("QUANTITY")) {
		//String form_code = request.getParameter( "form_code" ) ;
		String drug_code = request.getParameter( "drug_code" ) ;
		String pres_base_uom = request.getParameter( "pres_base_uom" ) ;
		String rx_qty_by_pres_base_uom_yn = request.getParameter( "rx_qty_by_pres_base_uom_yn" ) ;
		out.println("clearData('document.formIVPrescriptionDrugDetails.STRENGTH_UOM', '1');") ;

//		Hashtable QtyDescDetails	= (Hashtable)bean.loadQtyDetails(form_code);
		Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);
		Enumeration keys_des		= QtyDescDetails.keys();
		String uom_code				= "";
		String uom_desc				= "";
		String def_uom_code			= "";
		while(keys_des.hasMoreElements()) {
			uom_code = (String)keys_des.nextElement();
			uom_desc = (String)QtyDescDetails.get(uom_code);

			if(!uom_code.equals("dflt_code"))
				out.println("addData('"+ uom_code + "','" + uom_desc +"', 'document.formIVPrescriptionDrugDetails.STRENGTH_UOM');") ;
			else
				def_uom_code = (String)QtyDescDetails.get("dflt_code");
		}
		if(rx_qty_by_pres_base_uom_yn.equals("Y"))
			def_uom_code= pres_base_uom;
		out.println("setDefaultData('"+ def_uom_code +"', 'document.formIVPrescriptionDrugDetails', '1');") ;
	}
	else if(validate.equals("SETUOM")){
			String strengthUom = request.getParameter("strengthUom");
			String drug_dosage = request.getParameter("drug_dosage");
			String dosage_type = request.getParameter("dosage_type");
			String drug_code = request.getParameter("drug_code");
			ArrayList drugList			= bean.getDrugDetails();
			if(drugList!=null && drugList.size()>0){
				for(int i=0; i<drugList.size(); i++){
					HashMap hm	= (HashMap)drugList.get(i);
					if(hm.size()>0 && hm.get("DRUG_CODE").equals(drug_code)){ //in If condition 'hm.size()>0 &&' added for SRR20056-SCF-7650  Incident No. 27732
						hm.put("PRES_QTY_UOM",strengthUom);
						hm.put("QTY_UOM",strengthUom);
						hm.put("Dosage_Uom",strengthUom);
						hm.put("QTY_UNIT",strengthUom);
						if(dosage_type.equals("Q"))
							hm.put("QTY_DESC_CODE",strengthUom);
						hm.put("QTY_VALUE",drug_dosage);
						hm.put("DOSAGE_TYPE",dosage_type);
					}
				}
			}
			
	}
	else if (validate.equals("STOCKDETAILS")) {
		String drug_code		 = request.getParameter("drug_code");
		String mode				 = request.getParameter("mode");
		String orderType		 = bean.getOrderType(drug_code);
		ArrayList orderSetValues = bean.getOrderSetValues();
		ArrayList stockDetails   = null;
		if(orderSetValues.size() >0){
			if(orderSetValues.get(0).equals(drug_code)){
				String oQty_value = (String)orderSetValues.get(1);
				String oQty_unit  = (String)orderSetValues.get(2);
				if (bean.checkForStock()) {
					stockDetails = bean.getStockDetails(drug_code, "1");
					out.println("setStockDetails(1, '"+ oQty_value + "', '" + oQty_unit + "','"+bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1))+"');");
				}
			}
		}
		else{
			bean.setFluidDetails(drug_code,"","","",""); // CRF-0062 NEWLY ADDED
			if (bean.checkForStock()) {
				stockDetails = bean.getStockDetails(drug_code, "1");
				//if(!mode.equals("amend")){
					if (stockDetails.size() != 0){
						HashMap fluid_det =(HashMap)bean.getFluidDetails();
						String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
						String fluid_stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
						fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
						fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
						fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
						out.println("setStockDetails(1, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "','" +bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1))+"','"+ fluid_stock_uom_desc + "');") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
					}
					else
						out.println("setStockDetails(2);") ;
				//}
			}
		}
		out.println("setOrderType('"+ orderType + "');");
	}
	else if (validate.equals("FLUIDDETAILS")) {
		String drug_code	= request.getParameter("drug_code");
//commented during PE By Naveen
		//String orderType	= bean.getOrderType(drug_code);
		String trade_code	= request.getParameter("trade_code");
        String pres_drug_code	= request.getParameter("pres_drug_code");//Added for ML-MMOH-CRF-1223
			if(trade_code == null){trade_code = "";}
		bean.setFldTradeCode(trade_code);
		bean.setFluidDetails(drug_code,"","","",""); // CRF-0062 NEWLY ADDED
		HashMap fluid_det =(HashMap)bean.getFluidDetails();
		String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
		String fluid_stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
		fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
		fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
		fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
		// SKR-SCF-0288 [IN:029447]  - Chandrasekhar
		//String	back_date					= (String) fluid_det.get("BACK_DATE");
		//String  future_date					= (String) fluid_det.get("FUTURE_DATE");
		//out.println("setBackFutureDate('"+ back_date +"','"+ future_date +"');");
		// SKR-SCF-0288 [IN:029447]  - Chandrasekhar

		String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");

//clearing the mfr details and enabling admin form fields on change of fluid
		bean.setMFRRecs(new HashMap());
		bean.setMFRYN("N");
		out.println("enableFields()");
		int fluid_adr_count = bean.getADRCount(patient_id,drug_code);   
        out.println("displayADRimage('"+fluid_adr_count+"');");
		if (bean.checkForStock()) {
			ArrayList stockDetails = bean.getStockDetails(drug_code, "1");
			if (stockDetails.size() != 0)
				out.println("setStockDetails(1, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" +bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "','"+fluid_stock_uom_desc+"');") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
			else
				out.println("setStockDetails(2);") ;
		}
		out.println("setOrderType('"+ orderType + "');");
		//System.err.println("drug_code @@@308===="+drug_code+"pres_drug_code=="+pres_drug_code);
		//Adding start for Ml-MMOH-CRF-1223
			StringTokenizer st = new StringTokenizer(pres_drug_code, ",");
				String temp_pres_drug_code = "";
				while (st.hasMoreTokens()) {
					  temp_pres_drug_code = st.nextToken();
					break;
				}
      //Adding end for ML-MMOH-CRF-1223

	  //System.err.println("temp_pres_drug_code@@@@==="+temp_pres_drug_code);
		
		String infuse	=	bean.getInfuseOverValue(drug_code,temp_pres_drug_code);//Added temp_pres_drug_code for ML-MMOH-CRF-1223
		out.println("setInfuseValue('"+infuse+ "');");

		String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String priority					= request.getParameter("priority")==null?"":request.getParameter("priority");
		String take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	 	String dflt_disp_locn	= "";	
		ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]

		if(ord_disp_location != null & ord_disp_location.size()>0)
			dflt_disp_locn	= (String)ord_disp_location.get(2);
		out.println("displayDispLocn('"+dflt_disp_locn+"');");

	}
	else if (validate.equals("VOLUMEDETAILS")) {
		String drug_code	= request.getParameter("drug_code");
		//String base_uom		= request.getParameter("base_uom");
		String rec_no		= request.getParameter("rec_no");
		//String orderType	= bean.getOrderType(drug_code);
		String act_pat_class = hash.get("act_patient_class").toString();
		// RUT-CRF-0062  moved from below 
		String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code");  
		String priority					= request.getParameter("priority")==null?"":request.getParameter("priority"); 
		String item_type_site_app       = request.getParameter("item_type_site_app")==null?"":request.getParameter("item_type_site_app"); //GHL-CRF-0549
		String take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		// RUT-CRF-0062  moved from below 
		String mode		= request.getParameter("mode")==null?"":request.getParameter("mode"); //Added for MMS-DM-CRF-0177
		bean.setMFRRecs_fluids(new HashMap(),drug_code);
		out.println("enableFields('"+rec_no+"')");
		bean.setFluidDetails(drug_code,act_pat_class,priority,location_code,take_home_medication);  //RUT-CRF-0062
		bean.setMFRYN("N");	 
	
		if(rec_no.equals("1")){// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- begin
			HashMap fluidDtls = (HashMap) bean.getFluidDetails();
			String buildMARRule=(String)fluidDtls.get("BUILD_MAR_RULE");
			out.println("setBuildMAR('"+buildMARRule+"');");
		}// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- end

		HashMap fluid_det =(HashMap)bean.getFluidDetails();
		
		String	back_date					= (String) fluid_det.get("BACK_DATE");// SKR-SCF-0288 [IN:029447]  - Chandrasekhar
		String  future_date					= (String) fluid_det.get("FUTURE_DATE");
		String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
		out.println("setBackFutureDate('"+ back_date +"','"+ future_date +"');");	// SKR-SCF-0288 [IN:029447]  - Chandrasekhar
		String fluid_stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
		fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
		fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
		fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");

		String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
		//added for nmc-jd-crf-0026 start
		String  act_strength_value					= (String) fluid_det.get("ACT_STRENGTH_VALUE");
		String  strength_uom_desc					= bean.getUomDisplay((String)session.getValue("facility_id"),(String) fluid_det.get("STRENGTH_UOM"));
		String  strength_per_value_pres_uom_val		= (String) fluid_det.get("STRENGTH_PER_VALUE_PRES_UOM");
		String  pres_base_uom_desc					= (String) fluid_det.get("PRES_BASE_UOM_DESC");
		String strength_disply="";
		if(act_strength_value != null && act_strength_value !="" && !act_strength_value.equals("0")){
        strength_disply=act_strength_value+" "+strength_uom_desc+" / "+strength_per_value_pres_uom_val+" "+pres_base_uom_desc;
		}
		
		String generic_name		= (String)fluid_det.get("GENERIC_NAME");
		
		//Added for MMS-DM-CRF-0177
		String new_generic_name = ""; 
		String pre_alloc_appl = ""; 
		String drug_search = "";
		String drug_desc = "";
		
		pre_alloc_appl = bean.getPreAllocApplYN();
	
		drug_search					= (String) fluid_det.get("DRUG_SEARCH_BY")==null?"":(String) fluid_det.get("DRUG_SEARCH_BY");
		drug_desc					= (String) fluid_det.get("DRUG_DESC")==null?"":(String) fluid_det.get("DRUG_DESC");
		drug_desc=drug_desc.replaceAll(" ","%20");
		drug_desc=java.net.URLEncoder.encode(drug_desc,"UTF-8");//added for ML-BRU-SCF-2211
		drug_desc=drug_desc.replaceAll("%2520","%20");
		System.out.println("428 drug_desc"+drug_desc);
		if(pre_alloc_appl.equals("Y") && drug_search.equals("G") && !mode.equals("amend"))
		{System.out.println("430 new_generic_name"+new_generic_name);
			new_generic_name= (String)fluid_det.get("DRUG_DESC_NEW")==null?"":(String)fluid_det.get("DRUG_DESC_NEW");
			new_generic_name=java.net.URLEncoder.encode(new_generic_name,"UTF-8");//added for ML-BRU-SCF-2211
			new_generic_name=new_generic_name.replaceAll(" ","%20");
			new_generic_name = java.net.URLEncoder.encode(new_generic_name,"UTF-8");
			new_generic_name=new_generic_name.replaceAll("%2520","%20");
			out.println("setNewFluidName('"+ new_generic_name + "');"); 	
		}
		else
		{System.out.println("436 drug_desc"+drug_desc);
			out.println("setNewFluidName('"+ drug_desc + "');");
		}
		//Added for MMS-DM-CRF-0177
		
		
		
       //added for nmc-jd-crf-0026 end
		
		if (bean.checkForStock()) {
			ArrayList stockDetails = bean.getStockDetails(drug_code, "1");
            int fluid_adr_count = bean.getADRCount(patient_id,drug_code);   
			if (stockDetails.size() != 0)
				out.println("setVolumeDetails(1, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" + bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "', '" +rec_no + "','"+ fluid_adr_count +"','"+fluid_stock_uom_desc+"','"+strength_disply+"');") ;// stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012//strength_disply added for nmc-jd-crf-0026
				
			else
				out.println("setVolumeDetails(2);") ;
		}
		//GHL-CRF-0549 - start
		String disp_by_alt_form_param = "";
		String disp_by_alt_form_drug  = "";
		String item_type			  = "";
		String mm_item_low_cost_yn    = "";
		String mm_item_high_margin_yn = "";
		String mm_item_Innovator_yn   = "";
		String allow_alternate_checked = "";
		String allow_alternate_disabled = "";
		boolean allow_alternae_flag   = false;
		if(item_type_site_app.equals("true")){
			disp_by_alt_form_param     = bean.getParamDispByAltForm();
			disp_by_alt_form_drug     = (String) fluid_det.get("DISP_ALT_FORM_YN")==null?"N":(String) fluid_det.get("DISP_ALT_FORM_YN");

			if(disp_by_alt_form_param.equals("Y") && disp_by_alt_form_drug.equals("Y"))
			{
					item_type = bean.getItemType(drug_code);
					mm_item_low_cost_yn = item_type.split("~")[0];
					mm_item_high_margin_yn = item_type.split("~")[1];
					mm_item_Innovator_yn = item_type.split("~")[2];
					if(mm_item_low_cost_yn.equals("Y") || mm_item_high_margin_yn.equals("Y")){
						allow_alternate_checked = "checked";
					}else{
						allow_alternate_checked = "";
					}
				if(mm_item_Innovator_yn.equals("Y")) //GHL-SCF-1430 - start
					allow_alternate_checked = "";
							
				if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") &&!mm_item_Innovator_yn.equals("Y")){ //4/24/2019
					allow_alternate_checked = "checked";
				} //GHL-SCF-1430 - end
				allow_alternate_disabled = "";
				allow_alternae_flag = true;
			}else{
				allow_alternate_disabled = "disabled";
			}
			if(allow_alternae_flag){
				out.println("enableAllowAlternate('"+ allow_alternate_disabled + "', '" +rec_no + "', '" +allow_alternate_checked + "');"); 			
			}
		}
		out.println("setOrderType1('"+ orderType + "');"); 
		String infuse	=	bean.getInfuseOverValue(drug_code,"");//Added "" for ML-MMOH-CRF-1223
		out.println("setInfuseOver('"+infuse+ "' , '" +rec_no + "', 'document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+ rec_no +"');");	
		
		String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	 	String dflt_disp_locn	= "";	
		ArrayList ord_disp_location=new ArrayList();  // Added for Bru-HIMS-CRF-347 [IN:037862] -- begin
		if(iv_prep_yn.equals("5")){
			 ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
System.err.println("===ord_disp_location========>"+ord_disp_location+" location_type="+location_type+" location_code="+location_code+" take_home_medication="+take_home_medication+" priority="+priority+" iv_prep_yn="+iv_prep_yn+" drug_code="+drug_code+" patient_id="+patient_id+" encounter_id="+encounter_id);
			out.println("displayDispLocnDrugLevel('"+ord_disp_location.get(2)+"','"+ord_disp_location.get(0)+"','"+ord_disp_location.get(1)+"','"+ord_disp_location.get(3)+"','"+rec_no+"');");
		}
		else{
			 ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
			if(ord_disp_location != null & ord_disp_location.size()>0){
				dflt_disp_locn	= (String)ord_disp_location.get(2);
			} // Bru-HIMS-CRF-347 [IN:037862] -- end
			out.println("displayDispLocn('"+dflt_disp_locn+"');"); 
		}
	}
	else if(validate.equals("GETPRESBASE")) {
		String drug_code	=   request.getParameter("drug_code");
		String pres_base	=	bean.getPresBase(drug_code);
		out.println("setPresBase('"+pres_base+"');");
	}
	else if(validate.equals("IVTYPEDETAILS")) {
		String ivtype	=   request.getParameter("ivtype");
		bean.setIVType(ivtype);
		if((bean.getDrugDetails()!=null && bean.getDrugDetails().size()>0)||(bean.getFluidDetails()!=null && bean.getFluidDetails().size()>0)){
			out.println("confirmAndProceed(this,this);");
		}
		else
			out.println("callClearAll(2);");
	}
	else if (validate.equals("GETEQVLUOM")) {
		String uom_code = request.getParameter("uom_code");
		String base_uom = request.getParameter("base_uom");
		ArrayList eqvlUOM = bean.getEqvlUOM(uom_code, base_uom);

		if (eqvlUOM.size() != 0)
			out.println("setEqvlUOMDetails(1, '"+ eqvlUOM.get(0) + "','" + eqvlUOM.get(1) + "','" + eqvlUOM.get(2) + "');") ;
		else
			out.println("setEqvlUOMDetails(2);") ;
	}
	else if (validate.equals("DELETEDRUG")) {
		String drug_code	= request.getParameter("drug_code");
		int srl_no			= Integer.parseInt(request.getParameter( "srl_no" )) ;

		String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
		String search_bean_name		= "ePH.DrugSearchBean";
		DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id,search_bean_name,request);
		searchbean.removeDrugCode(drug_code);

		bean.removeDrugFromList(srl_no-1, drug_code);

		ArrayList drugList		   = (ArrayList)bean.getDrugDetails();
		int drug_count=0;
		HashMap drugDetails = null;
		String drugCodes="";
        
		String or_bean_name				= "eOR.OrderEntryBean";
		String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		String resp_id					= (String) orbean.getResponsibilityId();
		String pract_id					= (String) orbean.getPractitionerId();

		for(int i=0;i<drugList.size();i++){
			drugDetails = (HashMap)drugList.get(i);
			if (drugDetails.size() != 0){
				drugCodes += (String)drugDetails.get("DRUG_CODE")+",";
				drug_count++;
			}
		}
		if(drug_count>0){
			int fluid_adr_count=0;
			ArrayList dfltFluidDetails = null;
			if(drug_count==1)
				dfltFluidDetails = bean.getCompFluidDetails(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
			else if (drug_count>1){
				dfltFluidDetails = bean.getCompFluidDetailsForMultipeDrugs(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
			}
			if(dfltFluidDetails != null && dfltFluidDetails.size()>0){
				String dfltFluidCode ="";
				out.println("clearDfltVehicle();");
				for(int j=0; j<dfltFluidDetails.size();j+=7 ){
					fluid_adr_count = bean.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
					out.println("assignDfltVehicle('"+ dfltFluidDetails.get(j) + "', '" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+1)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "', '" + dfltFluidDetails.get(j+2)+ "','" + dfltFluidDetails.get(j+3)+ "','" + dfltFluidDetails.get(j+4)+ "','" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+5)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "','" + fluid_adr_count + "');") ;
					if(((String)dfltFluidDetails.get(j+3)).equals("Y"))
						dfltFluidCode = (String)dfltFluidDetails.get(j);
				}
				if(dfltFluidCode.equals(""))
					dfltFluidCode = (String)dfltFluidDetails.get(0);
//commented during PE  By Naveen
				//String orderType	= bean.getOrderType(dfltFluidCode);
				bean.setFluidDetails(dfltFluidCode,"","","",""); // CRF-0062 NEWLY ADDED

				HashMap fluid_det =(HashMap)bean.getFluidDetails();
		        String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
				String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
				String fluid_stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
				fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
				fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
				fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
				if (bean.checkForStock()) {
					ArrayList stockDetails = bean.getStockDetails(dfltFluidCode, "1");
					if (stockDetails.size() != 0)
						out.println("setStockDetails(3, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" +bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "','"+fluid_stock_uom_desc+"');") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
					else
						out.println("setStockDetails(2);") ;
				}
				out.println("setOrderType('"+ orderType + "');");
				String infuse	=	bean.getInfuseOverValue(dfltFluidCode,"");//Added "" for ML-MMOH-CRF-1223
				out.println("setInfuseValue('"+infuse+ "',1);");
			}
		}
		else
			out.println("callClearAll('cancel')");

		out.println("refreshLocation('" + patient_id + "','" + encounter_id + "', '2','"+pat_class+"');") ;
		putObjectInBean(search_bean_id,searchbean,request);
	}
	else if (validate.equals("AMENDDRUG")) {
		
		String pc=request.getParameter("patient_class");
		String mode=request.getParameter("mode");
		patient_id = request.getParameter("patient_id");
		encounter_id = request.getParameter("encounter_id");
		String allow_alternate= request.getParameter("allow_alternate")==null?"N":request.getParameter("allow_alternate");//GHL-CRF-0549
		String item_type_site_app = request.getParameter("item_type_site_app")==null?"":request.getParameter("item_type_site_app");//GHL-CRF-0549
		String abuse_override_remarks=request.getParameter("abuse_override_remarks")==null?"":request.getParameter("abuse_override_remarks");
		String abuse_override=request.getParameter("abuse_override")==null?"":request.getParameter("abuse_override");
		System.out.println("620  validateabuse_drug_override_reason"+abuse_override_remarks);
		System.out.println("hash"+hash);
		int srl_no			= Integer.parseInt((String)hash.get("SRL_NO"));
		String drug_code	= (String)hash.get("DRUG_CODE");
		String order_id 	= (String)hash.get("order_id")==null?"":(String)hash.get("order_id");
		bean.amendDrugs(srl_no-1, drug_code, hash);
		String or_mode = bean.getOrMode();
		ArrayList drugList	= bean.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		String extdrugCode = "";
		String extsrlNo = "";
//GHL-CRF-0549 - start
		if(item_type_site_app.equals("true")){
		if(drugList!=null && drugList.size()>0){
				for(int i=0;i<drugList.size();i++){
					drugDetails				= (HashMap)drugList.get(i);
					extdrugCode				= (String)drugDetails.get("DRUG_CODE");
					if(extdrugCode.equals(drug_code)  ){					
						drugDetails.put("allow_alternate",allow_alternate); 
						break;
					}
				}
			}
		}
//GHL-cRF-0549 - end		
		if(or_mode.equals("amend")){
			String allergy_desc  = (String)hash.get("allergy_desc")==null?"":(String)hash.get("allergy_desc");
			String exceed_dose_desc = (String)hash.get("exceed_dose_desc")==null?"":(String)hash.get("exceed_dose_desc");
			String dup_drug_desc  = (String)hash.get("dup_drug_desc")==null?"":(String)hash.get("dup_drug_desc");
			String buildMAR_yn  = (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn");  //CRF-0062

			if(drugList!=null && drugList.size()>0){
				for(int i=0;i<drugList.size();i++){
					drugDetails				= (HashMap)drugList.get(i);
					extdrugCode				= (String)drugDetails.get("DRUG_CODE");
					extsrlNo				= (String)drugDetails.get("SRL_NO");
					if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){					
						//drugDetails.put("ALLERGY_OVERRIDE_REASON",allergy_desc);
						drugDetails.put("ALLERGY_REMARKS",allergy_desc);
						//drugDetails.put("DOSAGE_LIMIT_OVERRIDE_REASON",exceed_dose_desc);
						drugDetails.put("DOSE_REMARKS",exceed_dose_desc);
						//drugDetails.put("DUPLICATE_DRUG_OVERRIDE_REASON",dup_drug_desc);
						drugDetails.put("CURRENTRX_REMARKS",dup_drug_desc);
						drugDetails.put("buildMAR_yn",buildMAR_yn); //CRF-0062
						drugDetails.put("ABUSE_OVERRIDE",abuse_override);
						drugDetails.put("abuse_override_remarks",abuse_override_remarks);
					drugDetails.put("666 abuse_override_remarks",abuse_override_remarks);
						
						
					}
				}
			}
			out.println("refreshLocation('" + patient_id + "', '" + encounter_id + "', '4','"+pc+"','"+mode+"');") ;
		}
		else
			out.println("refreshLocation('" + patient_id + "', '" + encounter_id + "', '3','"+pc+"','"+mode+"','"+order_id+"');"); 
		putObjectInBean(bean_id,bean,request);
	}
	else if(validate.equals("GETFORMATID")) {
		String or_bean_name	= "eOR.OrderEntryBean";
		String or_bean_id	= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

		String order_catalog_code	= request.getParameter("drug_code");
		String order_type			= request.getParameter("order_type");
		String form_code			= request.getParameter("form_code");
		String route_code			= request.getParameter("route_code");
		String called_frm			= request.getParameter("called_frm");
		String mode					= request.getParameter("mode");				
		String click_yn				= request.getParameter("click_yn")==null?"N":request.getParameter("click_yn");				
		if(mode == null) mode = "";
		String order_category		= "PH";

		if(called_frm.equals("route")) {
			if(orderEntryRecordBean.getOrderFormats(order_catalog_code, order_catalog_code+"_0") != null) 
				orderEntryRecordBean.removeOrderFormats(order_catalog_code, order_catalog_code+"_0");
		}

		String format_id		= bean.getFormatId(order_category, order_type, order_catalog_code);
		out.println("callOrder('" + format_id + "','"+called_frm+"','"+order_catalog_code+"','"+form_code+"','"+route_code+"','"+click_yn+"');");
		putObjectInBean(or_bean_id,orbean,request);
	}
	else if (validate.equals("GETSCHEDULEDFREQORNOT")) {
		String freq_code	= request.getParameter("freq_code");
		String mode			= request.getParameter("mode");
		bean.resetscheduleFrequency();
		boolean sched_yn	= bean.getScheduledFreqYN(freq_code);
		String repeat_value = bean.getRepeatValue();
		String freq_nature	= bean.getFrequencyNature();
		out.println("setSchedFreqActivated('" + sched_yn + "','" + repeat_value + "','" + mode + "','" + freq_nature + "');") ;
	}
	else if(validate.equals("POPULATEENDDATE")) {
		String start_date	= request.getParameter("start_date");
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		String mode			= request.getParameter("mode");
		String end_date		= bean.populateEndDate(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",bean.getLanguageId(),"en"), durn_value, durn_unit); // convertDate added for LEAP-INT-PH-SCF-14826 [IN:057866]
        
		if(!bean.getLanguageId().equals("en")){
			end_date=com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",bean.getLanguageId());  // convertDate added for LEAP-INT-PH-SCF-14826 [IN:057866]
		}
		String rowNum = "";
		if (mode.equals("1"))
			out.println("setEndDate('"+ end_date +"','document.formIVPrescriptionAdminDetail.END_DATE');");
		else if (mode.equals("2"))
			out.println("setEndDate('"+ end_date +"','document.formIVPrescriptionAdminDetail.END_DATE');");
		else if (mode.equals("3"))
			out.println("setEndDate('"+ end_date +"','parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail.END_DATE');");
		else if (mode.equals("MFR")){
			rowNum = request.getParameter("rowNum");
			out.println("setEndDate('"+ end_date +"','"+rowNum+"');");
		}
		else if (mode.equals("MFRStart")){
			rowNum = request.getParameter("rowNum");
			out.println("setStartDate('"+ end_date +"','"+rowNum+"');");
		}
		else
			out.println("setEndDate('"+ end_date +"','document.formIVPrescriptionAdminDetail.END_DATE');");
	}
	else if(validate.equals("POPULATEENDDATEADMIN")) {
		String start_date	= request.getParameter("start_date");
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		String mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
		String end_date		= bean.populateEndDate(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",bean.getLanguageId(),"en"), durn_value, durn_unit);  // convertDate added for LEAP-INT-PH-SCF-14826 [IN:057866]
		if(!bean.getLanguageId().equals("en")){
			end_date=com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",bean.getLanguageId());  // convertDate added for LEAP-INT-PH-SCF-14826 [IN:057866]
		}
		if(mode.equals("1"))
			out.println("setEndDate('"+ end_date +"', 'parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.END_DATE');");
		else if( mode.equals("orderset"))
			out.println("setEndDate('"+ end_date +"', 'parent.parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.END_DATE');");
		else if( mode.equals("IV_CALC"))
			out.println("setEndDate('"+ end_date +"', 'document.formIVPrescriptionAdminDetail.END_DATE');");
		else if( mode.equals("IV_CALC_LOAD"))
			out.println("setEndDate('"+ end_date +"', 'parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.END_DATE');");
		else
			out.println("setEndDate('"+ end_date +"', 'parent.f_iv_admin.formIVPrescriptionAdminDetail.END_DATE');");
	}
	else if(validate.equals("POPULATEENDDATEAD")) {
		String start_date	= request.getParameter("start_date");
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		String rec_no			= request.getParameter("rec_no");
		if(!locale.equals("en"))//Added for RollForward from SRR - SRR20056-SCF-9422
  			start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");
		String end_date		= bean.populateEndDate(start_date, durn_value, durn_unit);
		if(!locale.equals("en")){//Added for RollForward from SRR - SRR20056-SCF-9422	
      			start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
			end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
		}
		out.println("setEndDate('"+ end_date +"','document.formIVPrescriptionAdditives.END_DATE"+ rec_no +"');");
		//out.println("strtEndDateTime('"+ rec_no +"');"); //commented for incident 25543
	}
	else if(validate.equals("POPULATESTARTDATE")) {
		String end_date		= request.getParameter("end_date");
		String durn_unit	= request.getParameter("durn_unit");
		String rec_no		= request.getParameter("rec_no");
		String sTimeFrame	= request.getParameter("sTimeFrame");
		String start_date		= bean.populateEndDate(end_date, sTimeFrame, durn_unit);
		// for setting the next start date time.
		out.println("setEndDate('"+ start_date +"', 'document.formIVPrescriptionAdditives.START_DATE"+ rec_no +"');");
	}
	else if (validate.equals("POPULATEDURNVALS")) {
		String mode			= request.getParameter("mode");
		ArrayList durn_values	= bean.populateDurnValues();
		if (durn_values.size() == 1) {
			if (mode.equals("2")) {
				out.println("clearData('parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE', '');") ;
				out.println("addData('1','" + durn_values.get(0) + "', 'parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE');");
			}
			else if (mode.equals("")) {
				out.println("clearData('document.formIVPrescriptionAdminDetail.DURN_VALUE', '');") ;
				out.println("addData('1','" + durn_values.get(0) + "', 'document.formIVPrescriptionAdminDetail.DURN_VALUE');");
			}
			else if (mode.equals("1")) {
				out.println("clearData('parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE', '');") ;
				out.println("addData('1','" + durn_values.get(0) + "', 'parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE');");
			}
		}
		else {
			if (mode.equals("2")) {
				out.println("clearData('parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE', '1');") ;
				for (int i=0; i<durn_values.size(); i++) {
					out.println("addData('" + (i+1) + "', '" + durn_values.get(i) + "', 'parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE');");
				}
			}
			else if (mode.equals("")) {
				out.println("clearData('document.formIVPrescriptionAdminDetail.DURN_VALUE', '1');") ;
				for (int i=0; i<durn_values.size(); i++) {
					out.println("addData('" + (i+1) + "','" + durn_values.get(i) + "', 'document.formIVPrescriptionAdminDetail.DURN_VALUE');");
				}
			}
			else if (mode.equals("1")) {
				out.println("clearData('parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE', '1');") ;
				for (int i=0; i<durn_values.size(); i++) {
					out.println("addData('" + (i+1) + "', '" + durn_values.get(i) + "', 'parent.f_ivadmin.document.formIVPrescriptionAdminDetail.DURN_VALUE');");
				}
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
		String infusion_over = (String)hash.get("infusion_over");//INO71514
		String validate_overide_on_confirm_yn  = (String)hash.get("validate_overide_on_confirm_yn")==null?"N":(String)hash.get("validate_overide_on_confirm_yn");//Added for IN:069887 		
		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);
		bean.setPatientClass(patient_class);
		bean.setVOLUME(volume);

		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject(pres_bean_id,pres_bean_name, request) ;
		bean.setAmendRemarks(pres_bean.getPresRemarks());

		ArrayList DrugRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable
		int seq_num = 0;
		if(bean.getOrderID() == null || (bean.getOrderID()).equals(""))
			bean.setOrderID();

		String order_id	= bean.getOrderID();
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

		ArrayList drugList	= bean.getDrugDetails();
		boolean cont_flag	= true;
		TreeSet ordStat		= new TreeSet();

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
						System.out.println("orderFormatHash"+orderFormatHash);
						orderFormatHash.put("order_format_count", (String.valueOf(k)));
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", order_format_values);
					}
					else {
						orderFormatHash.put("order_format_count", "0");
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", "");
					}
					DrugRemarks.add(orderFormatHash);
					cont_flag					= true;
					allergy_override		= "";
					dose_override		= "";
					currentrx_override	= "";
					currentrx_remarks	= "";
					allergy_remarks		= "";
					dose_remarks			= "";	
					String allergy_remarks_yn="N", dup_remarks_yn="N", dose_remarks_yn="N",abuse_remarks_yn="N";//Added for IN:069887 
					//ADDED FOR AAKH-CRF-0140 START 
					String abuse_override="N",abuse_override_remarks="";
					//added for aakh-crf-0140 start
					String abuse_restric_trn="";
					String drug_code=(String) drugDetails.get("DRUG_CODE");
					abuse_restric_trn=(String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
					
					 if(abuse_restric_trn.equals("Y")){
							  out.println("showAbuseDetailsrestric('','"+patient_id+"','','','"+drug_code+"','Alert');"); 
							  cont_flag = false;		
					 } 
					 //added for aakh-crf-0140 end
					if(drugDetails.containsKey("ABUSE_OVERRIDE") && drugDetails.get("ABUSE_OVERRIDE")!=null)
						{
						abuse_override		= (String)drugDetails.get("ABUSE_OVERRIDE");
						abuse_override_remarks=(String)drugDetails.get("abuse_drug_override_reason");
						}
					if(drugDetails.containsKey("abuse_override_remarks") && drugDetails.get("abuse_override_remarks")!=null)
						abuse_override_remarks	= (String)drugDetails.get("abuse_override_remarks");
					//ADDED FOR AAKH-CRF-0140 END
					System.out.println("ivprescriptionvalidate 942"+abuse_override+"abuse_override_remarks"+abuse_override_remarks);
					if(drugDetails.containsKey("ALLERGY_YN") && drugDetails.get("ALLERGY_YN")!=null)
						allergy_override		= (String)drugDetails.get("ALLERGY_YN");
					if(drugDetails.containsKey("LIMIT_IND") && drugDetails.get("LIMIT_IND")!=null)
						dose_override		= (String)drugDetails.get("LIMIT_IND");
					if(drugDetails.containsKey("CURRENT_RX") && drugDetails.get("CURRENT_RX")!=null)
						currentrx_override	= (String)drugDetails.get("CURRENT_RX");
					if(drugDetails.containsKey("CURRENTRX_REMARKS") && drugDetails.get("CURRENTRX_REMARKS")!=null)
						currentrx_remarks	= (String)drugDetails.get("CURRENTRX_REMARKS");
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!currentrx_remarks.equals(""))
						currentrx_remarks = java.net.URLDecoder.decode(currentrx_remarks,"UTF-8");
					    drugDetails.put("CURRENTRX_REMARKS",currentrx_remarks);
					if(drugDetails.containsKey("ALLERGY_REMARKS") && drugDetails.get("ALLERGY_REMARKS")!=null)
						allergy_remarks		= (String)drugDetails.get("ALLERGY_REMARKS");
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!allergy_remarks.equals(""))
						allergy_remarks = java.net.URLDecoder.decode(allergy_remarks,"UTF-8");
					    drugDetails.put("ALLERGY_REMARKS",allergy_remarks);
					if(drugDetails.containsKey("DOSE_REMARKS") && drugDetails.get("DOSE_REMARKS")!=null)
						dose_remarks			= (String)drugDetails.get("DOSE_REMARKS");
					 if(drugDetails.containsKey("ABUSE_OVERRIDE") && drugDetails.get("ABUSE_OVERRIDE")!=null)
						{drugDetails.put("ABUSE_OVERRIDE",abuse_override);
					drugDetails.put("abuse_override_remarks",abuse_override_remarks);
						} 
				
					//System.out.println("ivprescriptionvalidate 969"+abuse_override+"abuse_override_remarks"+abuse_override_remarks);
					
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!dose_remarks.equals(""))
						dose_remarks = java.net.URLDecoder.decode(dose_remarks,"UTF-8");
					    drugDetails.put("DOSE_REMARKS",dose_remarks);
					if ((allergy_override.equals("Y") && allergy_remarks.equals("")) || (dose_override.equals("N") && dose_remarks.equals(""))  || (currentrx_override.equals("Y") && currentrx_remarks.equals(""))) {
					//Added for IN:069887  start
						if(allergy_override.equals("Y") && allergy_remarks.equals("")){
							allergy_remarks_yn="Y";
						}
						if(dose_override.equals("N") && dose_remarks.equals("")){
							dose_remarks_yn="Y";
						}
						if(currentrx_override.equals("Y") && currentrx_remarks.equals("")){
							dup_remarks_yn="Y";
						}
						if(abuse_override.equals("Y") && abuse_override_remarks.equals("")){
							abuse_remarks_yn="Y";
						}
						
						//Added for IN:069887 end
						cont_flag = false;
					}
					perform_external_database_checks_yn	= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
					external_database_overrided_reason	= (String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON")==null?"":(String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON");
					if(perform_external_database_checks_yn.equals("Y") && (external_database_overrided_reason.equals("") || external_database_overrided_reason.equals("N")))
						cont_flag = false;

					if (cont_flag) {
						String ord_auth_reqd_yn			= "";
						//String ord_auth_level			= "";
						String ord_appr_reqd_yn			= "";
						String ord_cosign_reqd_yn		= "";
						String init_auth_reqd_yn		= "";
						String init_spl_appr_reqd_yn	= "";
						String init_cosign_reqd_yn		= "";

						if(drugDetails.containsKey("ORD_AUTHORIZED_YN") && drugDetails.get("ORD_AUTHORIZED_YN")!=null)
							ord_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTHORIZED_YN");
						/*if(drugDetails.containsKey("ORD_AUTH_LEVEL") && drugDetails.get("ORD_AUTH_LEVEL")!=null)
							ord_auth_level			= (String)drugDetails.get("ORD_AUTH_LEVEL");*/
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
							order_status = "00"; //PC - Pending consent
						ordStat.add(order_status);
						//out.println("alert('"+order_status+"')");
					}
					else {
					//Added for IN:069887 start
					if(!abuse_restric_trn.equals("Y")){
						if(validate_overide_on_confirm_yn.equals("Y")){
							out.println("showOverideMandAlert('"+allergy_remarks_yn+"','"+dup_remarks_yn+"','"+dose_remarks_yn+"','"+abuse_remarks_yn+"')");
						}
						else{
							out.println("mandateRemarks();");
						}
					}
					
						//Added for IN:069887 end
						break;
					}
				}
			}

			if (cont_flag) {
				if (ordStat.size() != 0){
					//bean.setOrderStatus(ordStat.last().toString());
					bean.setOrderStatus(ordStat.first().toString());
				}
			}
		}

		if (cont_flag) {
			bean.genDrugRemarks(DrugRemarks);
			HashMap returndata =  bean.prepareOrderDetails(hash);
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
			boolean result	= ((Boolean)returndata.get("result")).booleanValue();
			String message	= returndata.get("message")==null?"":(String)returndata.get("message");
			String flag		= returndata.get("flag")==null?"":(String)returndata.get("flag");;

			out.println("assignResult("+ result + ",'" + bean.replaceNewLineChar(message) + "','" + flag + "','"+narcotic_yn +"','"+ print_ord_sht_rule_ind + "');");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		}
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(pres_bean_id,pres_bean,request);
	}
	else if(validate.equals("AMENDRELEASE")){
		/*Hashtable hash	= (Hashtable)XMLobj.parseXMLString(request);
		hash			= (Hashtable)hash.get("SEARCH");*/
		patient_id = request.getParameter("patient_id");
		encounter_id = request.getParameter("encounter_id");
		String patient_class = request.getParameter("patient_class");
		String volume = request.getParameter("volume");
		String buildMAR_yn = request.getParameter("buildMAR_yn");
		String validate_overide_on_confirm_yn  = (String)hash.get("validate_overide_on_confirm_yn")==null?"N":(String)hash.get("validate_overide_on_confirm_yn");//Added for IN:069887 
		String narcotic_yn = "N";

		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);
		bean.setPatientClass(patient_class);
		bean.setVOLUME(volume);
		String fluid_code	= (String)hash.get("fluid");
		bean.setBuildMAR_yn(buildMAR_yn);
		bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED
		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();
		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject(pres_bean_id,pres_bean_name,request) ;
		
		bean.setAmendRemarks(pres_bean.getPresRemarks());
		ArrayList DrugRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable

		int seq_num = 0;
		
		String order_id	= request.getParameter("order_id");
		bean.setOrderID(order_id);
		order_id = bean.getOrderID();
		String order_format_values = "";
		
		String disp_locn_code=bean.getDisp_locn_code();//Addeed for ml-mmoh-crf-0863 
		String auth_amend_pres_yn="";//added for ml-mmoh-crf-0863
		auth_amend_pres_yn = bean.getAuthAmendPres(disp_locn_code);//added for ml-mmoh-crf-0863
			String called_amend_from=pres_bean.getCalledFromAmend();
		//System.out.println("auth_amend_pres_yn"+auth_amend_pres_yn+"disp_locn_code"+disp_locn_code);
		try{
			arrSeq_num = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code, fluid_code+"_0");
		}
		catch(Exception e){
			e.printStackTrace();
		}

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
		ArrayList drugList	= bean.getDrugDetails();
		boolean cont_flag	= true;
		//String tot_inf_val	= (String)hash.get("INFUSION_VALUE");
		//String tot_inf_uom	= (String)hash.get("INFUSION_UOM");
		String freq_code	= (String)hash.get("FREQUENCY");
		bean.getScheduledFreqYN(freq_code);
		TreeSet ordStat		= new TreeSet();
		String drug_class = "";
		if (drugList.size() != 0) {
			for(int i=0;i<drugList.size();i++) {
				HashMap drugDetails = (HashMap)drugList.get(i);

				if (drugDetails.size() != 0) {
					orderFormatHash	= new HashMap();	// To store it in the HashMap
					arrSeq_num		= new ArrayList();	// get the seq in ArrayList
					template		= new Hashtable();	// get the template values in the HashTable
					seq_num 		= 0;
					drug_class = drugDetails.get("DRUG_CLASS")==null?"":(String)drugDetails.get("DRUG_CLASS");
//out.println("alert('"+drug_class+"')");					
					if((String)drugDetails.get("DRUG_CLASS") != null && ((String)drugDetails.get("DRUG_CLASS")).equals("N"))
						narcotic_yn = "Y";
					order_format_values	= "";
					String catalog_code	= (String)drugDetails.get("DRUG_CODE");
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
					}
					else {
						orderFormatHash.put("order_format_count", "0");
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", "");
					}
					DrugRemarks.add(orderFormatHash);

					cont_flag					= true;

					String allergy_override		= "";
					String dose_override		= "";
					String currentrx_override	= "";
					String currentrx_remarks	= "";
					String allergy_remarks		= "";
					String dose_remarks			= "";	
					String allergy_remarks_yn="N", dup_remarks_yn="N", dose_remarks_yn="N",abuse_remarks_yn="N";//Added for IN:069887 
					String abuse_exists=(String)drugDetails.get("ABUSE_EXISTS");
					String abuse_action=(String)drugDetails.get("ABUSE_ACTION");
					//ADDED FOR AAKH-CRF-0140 START 
					String abuse_override="N",abuse_override_remarks="";
					if(drugDetails.containsKey("ABUSE_OVERRIDE") && drugDetails.get("ABUSE_OVERRIDE")!=null)
						abuse_override		= (String)drugDetails.get("ABUSE_OVERRIDE");
					if(drugDetails.containsKey("abuse_override_remarks") && drugDetails.get("abuse_override_remarks")!=null)
						abuse_override_remarks	= (String)drugDetails.get("abuse_override_remarks");
					//ADDED FOR AAKH-CRF-0140 END
					if(drugDetails.containsKey("ALLERGY_YN") && drugDetails.get("ALLERGY_YN")!=null)
						allergy_override		= (String)drugDetails.get("ALLERGY_YN");
					if(drugDetails.containsKey("LIMIT_IND") && drugDetails.get("LIMIT_IND")!=null)
						dose_override		= (String)drugDetails.get("LIMIT_IND");
					if(drugDetails.containsKey("CURRENT_RX") && drugDetails.get("CURRENT_RX")!=null)
						currentrx_override	= (String)drugDetails.get("CURRENT_RX");
					if(drugDetails.containsKey("CURRENTRX_REMARKS") && drugDetails.get("CURRENTRX_REMARKS")!=null)
						currentrx_remarks	= (String)drugDetails.get("CURRENTRX_REMARKS");
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!currentrx_remarks.equals(""))
						currentrx_remarks = java.net.URLDecoder.decode(currentrx_remarks,"UTF-8");
					    drugDetails.put("CURRENTRX_REMARKS",currentrx_remarks);
					if(drugDetails.containsKey("ALLERGY_REMARKS") && drugDetails.get("ALLERGY_REMARKS")!=null)
						allergy_remarks		= (String)drugDetails.get("ALLERGY_REMARKS");
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!allergy_remarks.equals(""))
						allergy_remarks = java.net.URLDecoder.decode(allergy_remarks,"UTF-8");
					    drugDetails.put("ALLERGY_REMARKS",allergy_remarks);
					if(drugDetails.containsKey("DOSE_REMARKS") && drugDetails.get("DOSE_REMARKS")!=null)
						dose_remarks			= (String)drugDetails.get("DOSE_REMARKS");
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!dose_remarks.equals(""))
						dose_remarks = java.net.URLDecoder.decode(dose_remarks,"UTF-8");
					    drugDetails.put("DOSE_REMARKS",dose_remarks);
					    if(drugDetails.containsKey("ABUSE_OVERRIDE") && drugDetails.get("ABUSE_OVERRIDE")!=null)
						{drugDetails.put("ABUSE_OVERRIDE",abuse_override);
					drugDetails.put("abuse_override_remarks",abuse_override_remarks);
						} 

					if ((allergy_override.equals("Y") && allergy_remarks.equals("")) 
							|| (dose_override.equals("N") && dose_remarks.equals("")) 
							|| (currentrx_override.equals("Y") && currentrx_remarks.equals(""))
							|| (abuse_override.equals("Y") && abuse_override_remarks.equals("") && abuse_exists.equals("Y")  && abuse_action.equals("B"))) {
					//Added for IN:069887 start
						if(allergy_override.equals("Y") && allergy_remarks.equals("")){
							allergy_remarks_yn="Y";
						}
						if(dose_override.equals("N") && dose_remarks.equals("")){
							dose_remarks_yn="Y";
						}
						if(currentrx_override.equals("Y") && currentrx_remarks.equals("")){
							dup_remarks_yn="Y";
						}
						if(abuse_override.equals("Y") && abuse_override_remarks.equals("")){
							abuse_remarks_yn="Y";
						}
						//Added for IN:069887  end
						cont_flag = false;
					}

					if (cont_flag) {
						String ord_auth_reqd_yn			= "";
						//String ord_auth_level			= "";
						String ord_appr_reqd_yn			= "";
						String ord_cosign_reqd_yn		= "";
						String init_auth_reqd_yn		= "";
						String init_spl_appr_reqd_yn	= "";
						String init_cosign_reqd_yn		= "";

						if(drugDetails.containsKey("ORD_AUTHORIZED_YN") && drugDetails.get("ORD_AUTHORIZED_YN")!=null)
							ord_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTHORIZED_YN");
						/*if(drugDetails.containsKey("ORD_AUTH_LEVEL") && drugDetails.get("ORD_AUTH_LEVEL")!=null)
							ord_auth_level			= (String)drugDetails.get("ORD_AUTH_LEVEL");*/
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

					/*	if( (init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N")) ){
							order_status="10";
						}else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y"))){
							if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")))
								order_status	=	"10";
							else
								order_status	=	"00";
						}else if ((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N"))) {
							if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
								order_status	=	"10";
							else
								order_status	=	"05";
						}else if ((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N"))) {
							if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
								order_status	=	"10";
							else
								order_status="03";
						}
						else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N"))){
							if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
								order_status="10";
							}
							else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y")){
								order_status="05";
							}else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")){
								order_status="03";
							} else {
								order_status="03";
							}
						}else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y"))){
							if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
								order_status="10";
							}else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y"))){
								order_status="03";
							}else if((ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
								order_status="00";
							}else {
								order_status="00";
							}
						}else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y"))){
							if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) ){
								order_status="10";
							}else {
								order_status="05";
							}
						} else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y"))) {
							if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y"))) {
								order_status	=	"10";
							}
							else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) ) {
								order_status	=	"03";
							}
							else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) {
								order_status	=	"05";
							}
							else if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) {
								order_status	=	"10";
							}
							else {
								order_status	=	"03";
							}
						}
						*/
						if(init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("N")){
							order_status="";//Modified for IN073660
						}
						else if (init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("Y")) {
							if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
								order_status	=	"10";
							else
								order_status	=	"05";
						}
						else if (init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("N") ) {
							if((ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")  ))
								order_status	=	"10";
							else
								
							{//order_status="03"; commented for ml-mmoh-crf-0863 and new if else condtion added
								if( auth_amend_pres_yn.equalsIgnoreCase("Y") && called_amend_from.equals("PH")){
									order_status="";
								}
								else{
									order_status="03";
								}
								}
						}
						else if(init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("Y")){
							if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
								order_status="10";
							}
							else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y")){
								order_status="03";
							}
							else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")){
								order_status="05";
							} 
							else {
								order_status="05";
							}
						}
						
						if(drugDetails.get("CONSENT_REQD_YN").equals("Y") && drugDetails.get("CONSENT_STAGE").equals("A")){
							order_status = "00"; //PC - Pending consent
						}
						ordStat.add(order_status);
						
					}
					else {
					//Added for IN:069887 start
						if(validate_overide_on_confirm_yn.equals("Y")){
							out.println("showOverideMandAlert('"+allergy_remarks_yn+"','"+dup_remarks_yn+"','"+dose_remarks_yn+"','"+abuse_remarks_yn+"')");
						}else{
							out.println("mandateRemarks();");
						}
						//Added for IN:069887 end
						break;
					}
				}
			}
			if (cont_flag) {
				if (ordStat.size() != 0)
					bean.setOrderStatus(ordStat.first().toString());
			}
		}
		if (cont_flag) {
			bean.genDrugRemarks(DrugRemarks);
			HashMap returndata = bean.prepareAmendOrderDetails(hash);
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
			boolean result	= ((Boolean)returndata.get("result")).booleanValue();
			String message	= (String)returndata.get("message");
			String flag		= (String)returndata.get("flag");
			if(message==null) message		=	"";
			if(flag==null) flag		=	"";

			out.println("assignResult(" + result + ", '" + bean.replaceNewLineChar(message) + "', '" + flag + "', '" + narcotic_yn + "', '" + print_ord_sht_rule_ind + "');");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		}
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(pres_bean_id,pres_bean,request);
	}
	else if(validate.equals("RELEASE_FLUIDS")) {
		ArrayList AllFluids			= new ArrayList();	
		ArrayList newAllFluids			= new ArrayList();	
		//HashMap record				= null;
		 String patient_class		= request.getParameter("patient_class");//IN33123-SCF NO:SKR-SCF-0536. Get Patient Class from Request and set to Bean.
		 bean.setPatientClass(patient_class); 
		bean.setPriority((String)hash.get("priority"));
		bean.setHeight((String)hash.get("height"));
		bean.setHeightUOM((String)hash.get("height_uom"));
		bean.setWeight((String)hash.get("weight"));
		bean.setWeightUOM((String)hash.get("weight_uom"));
		bean.setBSA((String)hash.get("bsa"));
		bean.setBMI((String)hash.get("bmi"));
		bean.setAllergic((String)hash.get("allergic_yn"));
		bean.setBuildMAR_yn((String)hash.get("buildMAR_yn")); // RUT-CRF-0062
		bean.setOrderDate((String)request.getParameter("sys_date")); // order date was going null in or_order table. sri:14th jan 2011
		bean.setTakeHomeMedication((String)hash.get("take_home_medication")); // RUT-CRF-0062
		
		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject( pres_bean_id,pres_bean_name,request) ;
		String narcotic_yn = "N";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		String or_bean_name		= "eOR.OrderEntryBean";
		String  order_id1="";
		String  from_order_id="";
		String temp_mfr_remarks="";
		String source_code = "";//SKR-SCF-1254
		OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
		String locn_code = (String)ORbean.getLocationCode();//SKR-SCF-1254
		ORbean.clear();
		bean.setAmendRemarks(pres_bean.getPresRemarks());
		AllFluids = bean.getAllFluids();
		HashMap mfr_recsAll = new HashMap();
		HashMap mfr_recs = new HashMap();
		for(int i=1;i<=6;i++){
			
			HashMap record = new HashMap();
			mfr_recsAll = new HashMap();
			mfr_recsAll = bean.getMFRRecs_fluids("");
			if(!((String)hash.get("FLUID_CODE"+i)).equals("") && ((String)hash.get("SELECT"+i)).equals("Y")) {
				if(mfr_recsAll != null && mfr_recsAll.size() > 0)
					mfr_recs = (HashMap)mfr_recsAll.get((String)hash.get("FLUID_CODE"+i));
				
				if(AllFluids!=null && AllFluids.size()>0){
					for(int j=0; j<AllFluids.size(); j++){
						record = (HashMap) AllFluids.get(j);
						if(record.get("DRUG_CLASS") != null && ((String)record.get("DRUG_CLASS")).equals("N"))
							narcotic_yn = "Y";
						if(((String)hash.get("FLUID_CODE"+i)).equals((String)record.get("DRUG_CODE"))){
							//following if condition is added to get the correct fluid detail when a same fluid is selected mutiple times
							if((String)record.get("ORDER_ID") == null )
								break;
						}
					}
				}
				if(record==null || record.size()==0){
					bean.setFluidDetails (((String)hash.get("FLUID_CODE"+i)),"","","",""); // CRF-0062 NEWLY ADDED
					record	=	bean.getFluidDetails();
				}
				if(record.get("DRUG_CLASS") != null && ((String)record.get("DRUG_CLASS")).equals("N"))
					narcotic_yn = "Y";
				if(!bean.getLanguageId().equals("en")){
					record.put("START_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("START_DATE"+i)),"DMYHM",bean.getLanguageId(),"en"));
					record.put("END_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("END_DATE"+i)),"DMYHM",bean.getLanguageId(),"en"));
				}
				else{
					record.put("START_DATE",((String)hash.get("START_DATE"+i)));
					record.put("END_DATE",((String)hash.get("END_DATE"+i)));
				}
				temp_mfr_remarks="";
				temp_mfr_remarks=(String)hash.get("mfr_remarks"+i);
				if(!temp_mfr_remarks.equals("") || temp_mfr_remarks!=null)
					temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks,"UTF-8");
				record.put("QTY_VALUE",((String)hash.get("volume"+i)));
				record.put("DURN_VALUE",((String)hash.get("DURATION"+i)));
				record.put("MFR_REMARKS",temp_mfr_remarks);
				record.put("BUILD_MAR_YN",((String)hash.get("buildMAR_yn")));
				record.put("PER_FACILITY_ID",((String)hash.get("PER_FACILITY_ID"+i))); // Added for Bru-HIMS-CRF-347 [IN:037862]
				record.put("DISP_LOCN_CODE",((String)hash.get("DISP_LOCN_CODE"+i))); // Added for Bru-HIMS-CRF-347 [IN:037862]
				record.put("DISP_LOCN_TYPE",((String)hash.get("DISP_LOCN_TYPE"+i))); // Added for Bru-HIMS-CRF-347 [IN:037862]
				record.put("PER_FACILITY_ID",((String)hash.get("PER_FACILITY_ID"+i))); // Added for Bru-HIMS-CRF-347 [IN:037862]
				record.put("ROOM_NUM",((String)hash.get("ROOM_NUM"))); //Added for MMS-QH-CRF-0080 [IN:038064]
				record.put("BED_NUM",((String)hash.get("BED_NUM"))); //Added for MMS-QH-CRF-0080 [IN:038064]
				record.put("allow_alternate",((String)hash.get("allow_alternate"+i))); //GHL-CRF-0549
				//added for SKR-SCF-1254 - start
				if(patient_class.equals("IP")){
				source_code = bean.getCurrentLocn(patient_id,encounter_id);
				}
				

				if(patient_class.equals("IP")&& !source_code.equals("") && !source_code.equals(locn_code)){
					String disp_locn			= bean.getDispLocn(patient_class, (String)hash.get("priority"), (String)record.get( "DRUG_CODE" ), (String)ORbean.getLocationType(), (String)ORbean.getLocationCode(), (String) hash.get("take_home_medication"), (String)record.get("ORDER_TYPE_CODE"),(String)record.get( "DRUG_CLASS" ),"N",patient_id,encounter_id);
					if(disp_locn!=null && !disp_locn.equals("")){
						disp_locn = disp_locn.substring(0,disp_locn.indexOf("|"));
					}

					if(disp_locn!=null && !disp_locn.equals("")){
						record.put("locn_code",source_code);
						ORbean.setLocationCode(source_code);
						bean.setLocationCode(source_code);
						record.put("DISP_LOCN_CODE",disp_locn);
					}

				}//added for SKR-SCF-1254 - end
				if(((String)hash.get("mfr_yn"+i)).equals("Y")){
					record.put("INFUSION_RATE","");
					record.put("INFUSE_OVER","");
					record.put("INFUSE_OVER_UNIT_SCH","");
					record.put("INFUSE_OVER_UNIT","");
				}
				else{
					record.put("INFUSION_RATE",((String)hash.get("INF_RATE"+i)));
					record.put("INFUSE_OVER",((String)hash.get("INFUSION_PERIOD_VALUE"+i)));
					record.put("INFUSE_OVER_UNIT_SCH",((String)hash.get("inf_rate_uom"+i)));
					record.put("INFUSE_OVER_UNIT",((String)hash.get("inf_rate_uom"+i)));//MODIFIED FOR INO71514
				}
				record.put("MFR_Recs",mfr_recs);
				bean.setOrderID();
				order_id1 = (String)bean.getOrderID();
				record.put("ORDER_ID",order_id1);
				newAllFluids.add(record);
				if(from_order_id.equals(""))
					from_order_id = order_id1;
			}
		}
		bean.setOrderID(order_id1);
		bean.setOrderId1(from_order_id);
		bean.setAllFluids( newAllFluids);
		HashMap returndata	=	bean.ivFluidsInsert();
		String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
		boolean result	= ((Boolean)returndata.get("result")).booleanValue();
		String message	= (String)returndata.get("message");
		String flag		= (String)returndata.get("flag");
		if(message==null) message		=	"";
		if(flag==null) flag				=	"";

		out.println("assignResult(" + result + ", '" + bean.replaceNewLineChar(message) + "', '" + flag + "', '" + narcotic_yn + "', '" + print_ord_sht_rule_ind + "' );");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		putObjectInBean(or_bean_id,ORbean,request);
		putObjectInBean(pres_bean_id,pres_bean,request);
	}
	else if(validate.equals("AMEND_RELEASE_FLUIDS")){
		
		ArrayList AllFluids			= new ArrayList();	
		HashMap record				= null;
		bean.setPriority((String)hash.get("priority"));
		bean.setHeight((String)hash.get("height"));
		bean.setHeightUOM((String)hash.get("height_uom"));
		bean.setWeight((String)hash.get("weight"));
		bean.setWeightUOM((String)hash.get("weight_uom"));
		bean.setBSA((String)hash.get("bsa"));
		bean.setBMI((String)hash.get("bmi"));
		bean.setAllergic((String)hash.get("allergic_yn"));
		bean.setBuildMAR_yn((String)hash.get("buildMAR_yn")); // RUT-CRF-0062
		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		String drug_class		 = "";
		String narcotic_yn		 = "N";
		String temp_mfr_remarks	 = "";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject(pres_bean_id,pres_bean_name,request) ;
		bean.setAmendRemarks(pres_bean.getPresRemarks());

		HashMap mfr_recs = null;
		// Commented individual fluids and Added inside the for loop 
		for(int row=1;row<=4;row++){
				if(!((String)hash.get("FLUID_CODE"+row)).equals("")&& ((String)hash.get("SELECT"+row)).equals("Y")) {
				bean.setFluidDetails (((String)hash.get("FLUID_CODE"+row)),"","","",""); // CRF-0062 NEWLY ADDED
				record	=	bean.getFluidDetails();
				if(row==1){
					if(drug_class.equals("N"))
						narcotic_yn = "Y";
				}
				if(row!=4){
					mfr_recs = new HashMap();
					mfr_recs = bean.getMFRRecs_fluids((String)hash.get("FLUID_CODE"+row));
				}
				if(!bean.getLanguageId().equals("en")){
					record.put("START_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("START_DATE"+row)),"DMYHM",bean.getLanguageId(),"en"));
					record.put("END_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("END_DATE"+row)),"DMYHM",bean.getLanguageId(),"en"));
				}
				else{
					record.put("START_DATE",((String)hash.get("START_DATE"+row)));
					record.put("END_DATE",((String)hash.get("END_DATE"+row)));
				}
				temp_mfr_remarks="";
				temp_mfr_remarks=(String)hash.get("mfr_remarks"+row);
				if(!temp_mfr_remarks.equals("") || temp_mfr_remarks!=null)
					temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks);
				if(row==1)	{
					 if(mfr_recs != null && mfr_recs.size() >0){
						record.put("DURN_VALUE",mfr_recs.get("totFlowDurnHrs"));
						record.put("INFUSION_RATE","");
						record.put("INFUSE_OVER","");					
						record.put("INFUSE_OVER_UNIT","");					
					}
					else{
						record.put("DURN_VALUE",((String)hash.get("DURATION"+row)));
						record.put("INFUSION_RATE",((String)hash.get("INF_RATE"+row)));
						record.put("INFUSE_OVER",((String)hash.get("INFUSION_PERIOD_VALUE"+row)));					
						record.put("INFUSE_OVER_UNIT",((String)hash.get("inf_rate_uom"+row)));					
					}
					record.put("QTY_VALUE",((String)hash.get("volume"+row)));
					record.put("MFR_Recs",mfr_recs);
					record.put("BUILD_MAR_YN",((String)hash.get("buildMAR_yn")));
					record.put("MFR_REMARKS",temp_mfr_remarks);//Added for SKR-SCF-1729[42591]
				}
				else{
					record.put("MFR_REMARKS",temp_mfr_remarks);
					record.put("QTY_VALUE",((String)hash.get("volume"+row)));
					record.put("DURN_VALUE",((String)hash.get("DURATION"+row)));
					record.put("INFUSION_RATE",((String)hash.get("INF_RATE"+row)));
					record.put("INFUSE_OVER",((String)hash.get("INFUSION_PERIOD_VALUE"+row)));
					record.put("INFUSE_OVER_UNIT",((String)hash.get("inf_rate_uom"+row)));	
					record.put("BUILD_MAR_YN",((String)hash.get("buildMAR_yn")));
				}
				AllFluids.add(record);
			}
		}
		/*if(hash.containsKey("FLUID_CODE1")){
			if(!((String)hash.get("FLUID_CODE1")).equals("") && ((String)hash.get("SELECT1")).equals("Y")) {
				mfr_recs = new HashMap();
				bean.setFluidDetails (((String)hash.get("FLUID_CODE1")),"","","",""); // CRF-0062 NEWLY ADDED
				record	=	bean.getFluidDetails();
				mfr_recs = bean.getMFRRecs_fluids((String)hash.get("FLUID_CODE1"));
				drug_class = record.get("DRUG_CLASS")==null?"":(String)record.get("DRUG_CLASS");
				if(drug_class.equals("N"))
					narcotic_yn = "Y";

				if(!bean.getLanguageId().equals("en")){
					record.put("START_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("START_DATE1")),"DMYHM",bean.getLanguageId(),"en"));
					record.put("END_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("END_DATE1")),"DMYHM",bean.getLanguageId(),"en"));
				}
				else{
					record.put("START_DATE",((String)hash.get("START_DATE1")));
					record.put("END_DATE",((String)hash.get("END_DATE1")));
				}
				record.put("QTY_VALUE",((String)hash.get("volume1")));
				temp_mfr_remarks="";
				temp_mfr_remarks=(String)hash.get("mfr_remarks1");
				if(!temp_mfr_remarks.equals("") || temp_mfr_remarks!=null)
					temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks,"UTF-8");
				record.put("MFR_REMARKS",temp_mfr_remarks);
				if(mfr_recs != null && mfr_recs.size() >0){
					record.put("DURN_VALUE",mfr_recs.get("totFlowDurnHrs"));
					record.put("INFUSION_RATE","");
					record.put("INFUSE_OVER","");					
					record.put("INFUSE_OVER_UNIT","");					
				}else{
					record.put("DURN_VALUE",((String)hash.get("DURATION1")));
					record.put("INFUSION_RATE",((String)hash.get("INF_RATE1")));
					record.put("INFUSE_OVER",((String)hash.get("INFUSION_PERIOD_VALUE1")));					
					record.put("INFUSE_OVER_UNIT",((String)hash.get("inf_rate_uom1")));					
				}
				record.put("MFR_Recs",mfr_recs);
				record.put("BUILD_MAR_YN",((String)hash.get("buildMAR_yn")));
				AllFluids.add(record);
				
			}
		}
		if(hash.containsKey("FLUID_CODE2")){
			if(!((String)hash.get("FLUID_CODE2")).equals("")&& ((String)hash.get("SELECT2")).equals("Y")) {
				bean.setFluidDetails (((String)hash.get("FLUID_CODE2")),"","","",""); // CRF-0062 NEWLY ADDED
				record	=	bean.getFluidDetails();
				mfr_recs = new HashMap();
				mfr_recs = bean.getMFRRecs_fluids((String)hash.get("FLUID_CODE2"));
				if(!bean.getLanguageId().equals("en")){
					record.put("START_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("START_DATE2")),"DMYHM",bean.getLanguageId(),"en"));
					record.put("END_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("END_DATE2")),"DMYHM",bean.getLanguageId(),"en"));
				}
				else{
					record.put("START_DATE",((String)hash.get("START_DATE2")));
					record.put("END_DATE",((String)hash.get("END_DATE2")));
				}
				temp_mfr_remarks="";
				temp_mfr_remarks=(String)hash.get("mfr_remarks2");
				if(!temp_mfr_remarks.equals("") || temp_mfr_remarks!=null)
					temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks);
				record.put("MFR_REMARKS",temp_mfr_remarks);
				record.put("QTY_VALUE",((String)hash.get("volume2")));
				record.put("DURN_VALUE",((String)hash.get("DURATION2")));
				record.put("INFUSION_RATE",((String)hash.get("INF_RATE2")));
				record.put("INFUSE_OVER",((String)hash.get("INFUSION_PERIOD_VALUE2")));
				record.put("INFUSE_OVER_UNIT",((String)hash.get("inf_rate_uom2")));	
				record.put("BUILD_MAR_YN",((String)hash.get("buildMAR_yn")));
				AllFluids.add(record);
			}
		}
		if(hash.containsKey("FLUID_CODE3")){
			if(!((String)hash.get("FLUID_CODE3")).equals("")&& ((String)hash.get("SELECT3")).equals("Y")) {
				bean.setFluidDetails (((String)hash.get("FLUID_CODE3")),"","","",""); // CRF-0062 NEWLY ADDED
				record	=	bean.getFluidDetails();
				mfr_recs = new HashMap();
				mfr_recs = bean.getMFRRecs_fluids((String)hash.get("FLUID_CODE3"));
				if(!bean.getLanguageId().equals("en")){
					record.put("START_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("START_DATE3")),"DMYHM",bean.getLanguageId(),"en"));
					record.put("END_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("END_DATE3")),"DMYHM",bean.getLanguageId(),"en"));
				}
				else{
					record.put("START_DATE",((String)hash.get("START_DATE3")));
					record.put("END_DATE",((String)hash.get("END_DATE3")));
				}
				temp_mfr_remarks="";
				temp_mfr_remarks=(String)hash.get("mfr_remarks3");
				if(!temp_mfr_remarks.equals("") || temp_mfr_remarks!=null)
					temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks);
				record.put("MFR_REMARKS",temp_mfr_remarks);
				record.put("QTY_VALUE",((String)hash.get("volume3")));
				record.put("DURN_VALUE",((String)hash.get("DURATION3")));
				record.put("INFUSION_RATE",((String)hash.get("INF_RATE3")));
				record.put("INFUSE_OVER",((String)hash.get("INFUSION_PERIOD_VALUE3")));
				record.put("INFUSE_OVER_UNIT",((String)hash.get("inf_rate_uom3")));	
				record.put("BUILD_MAR_YN",((String)hash.get("buildMAR_yn")));
				AllFluids.add(record);
			}
		}
		if(hash.containsKey("FLUID_CODE4")){
			if(!((String)hash.get("FLUID_CODE4")).equals("")&& ((String)hash.get("SELECT4")).equals("Y")) {
				bean.setFluidDetails (((String)hash.get("FLUID_CODE4")),"","","",""); // CRF-0062 NEWLY ADDED
				record	=	bean.getFluidDetails();
				if(!bean.getLanguageId().equals("en")){
					record.put("START_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("START_DATE4")),"DMYHM",bean.getLanguageId(),"en"));
					record.put("END_DATE",com.ehis.util.DateUtils.convertDate(((String)hash.get("END_DATE4")),"DMYHM",bean.getLanguageId(),"en"));
				}
				else{
					record.put("START_DATE",((String)hash.get("START_DATE4")));
					record.put("END_DATE",((String)hash.get("END_DATE4")));
				}
				temp_mfr_remarks="";
				temp_mfr_remarks=(String)hash.get("mfr_remarks4");
				if(!temp_mfr_remarks.equals("") || temp_mfr_remarks!=null)
					temp_mfr_remarks=java.net.URLDecoder.decode(temp_mfr_remarks);
				record.put("MFR_REMARKS",temp_mfr_remarks);
				record.put("QTY_VALUE",((String)hash.get("volume4")));
				record.put("DURN_VALUE",((String)hash.get("DURATION4")));
				record.put("INFUSION_RATE",((String)hash.get("INF_RATE4")));
				record.put("INFUSE_OVER",((String)hash.get("INFUSION_PERIOD_VALUE4")));
				record.put("INFUSE_OVER_UNIT",((String)hash.get("inf_rate_uom4")));	
				record.put("BUILD_MAR_YN",((String)hash.get("buildMAR_yn")));
				AllFluids.add(record);
			}
		}*/
		bean.setAllFluids( AllFluids);
		HashMap returndata	=	bean.ivFluidsModify();
		String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
		boolean result	= ((Boolean)returndata.get("result")).booleanValue();
		String message	= (String)returndata.get("message")==null?"":(String)returndata.get("message");
		String flag		= (String)returndata.get("flag")==null?"":(String)returndata.get("flag");
		
		out.println("assignResult('"+ result + "','" + bean.replaceNewLineChar(message) + "','" + flag + "','" + narcotic_yn + "', '" + print_ord_sht_rule_ind + "');");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		putObjectInBean(pres_bean_id,pres_bean,request);
	}
	else if(validate.equals("CLEARBEAN")) {
		String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
		String search_bean_name		= "ePH.DrugSearchBean";
		DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id,search_bean_name,request);
		searchbean.clear();
		String calledFrom	= request.getParameter("calledFrom");
		int presc_mode		= Integer.parseInt(request.getParameter("presc_mode"));
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		String or_bean_name		= "eOR.OrderEntryBean";
		OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
        

		String resp_id					= (String) ORbean.getResponsibilityId();
		String pract_id					= (String) ORbean.getPractitionerId();
		String pract_name				= (String) ORbean.getPractitionerName();
		String attend_pract_id			= (String) ORbean.getAttendPractitionerId();
		String service_code				= (String) ORbean.getServiceCode();
		String service_search_yn		= (String) ORbean.getRestrictYn();
		String locn_type				= (String)ORbean.getLocationType();
		String locn_code				= (String)ORbean.getLocationCode();
		//String pract_id					= (String)ORbean.getPractitionerId();
		ORbean.clear();
		ORbean.setResponsibilityId(resp_id);
		ORbean.setPractitionerId(pract_id);
		ORbean.setPractitionerName(pract_name);
		ORbean.setAttendPractitionerId(attend_pract_id);
		ORbean.setServiceCode(service_code);
		ORbean.setRestrictYn(service_search_yn);
		ORbean.setLocationType(locn_type);
		ORbean.setLocationCode(locn_code);
		//ORbean.setPractitionerId(pract_id);
		bean.clear();
		if (calledFrom.equals("2"))
			bean.setPrescMode(presc_mode);
		String or_mode	=	bean.getOrMode();
		out.println("reloadScreens('"+ calledFrom +"','"+ patient_id +"','"+ encounter_id +"','"+ order_date +"','"+ pat_class +"', '','"+or_mode+"','"+ presc_mode +"');");
		putObjectInBean(search_bean_id,searchbean,request);
	}
	else if(validate.equals("PRINT")) {
		String print_yn				= (String) hash.get( "print_yn" );
		String locn_code			= (String) hash.get( "locn_code" );
		String patient_class		= (String) hash.get( "patient_class" );
		String order_set_code		= (String) hash.get( "order_set_code" );
		String prescriptionPrint	= (String) hash.get( "prescriptionPrint" );
		String NarcoticPrint		= (String) hash.get( "NarcoticPrint" );
		String MARLabelPrint		=  hash.get("MARLabelPrint")==null?"":(String) hash.get("MARLabelPrint");//Added for MMS-QH-CRF-0080 [IN:038064]
		String pract_type		=  hash.get("pract_type")==null?"":(String) hash.get("pract_type");//Added for ML-BRU-SCF-0958 [IN:042045]
		if (prescriptionPrint.equals("Y") || NarcoticPrint.equals("Y")|| MARLabelPrint.equals("Y")) {
			//boolean	printed = (boolean)
			bean.doPrinting(request, response, locn_code, patient_class, prescriptionPrint, NarcoticPrint, MARLabelPrint,patient_id); //MARLabelPrint Added for MMS-QH-CRF-0080 [IN:038064]	//code 'patient_id' added for SKR-SCF-0915[IN046734]	
		}
		String or_bean_name	="eOR.OrderEntryBean";
		String or_bean_id="@orderentrybean"+patient_id+encounter_id;	
		OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
    	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		String key = patient_id + encounter_id;
		//String key = orbean.getPatientId() + orbean.getEncounterId();
		java.util.HashMap previousValues	= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
		String order_catalog_code 			= orbean.getOrderCatalogCode(previousValues, "PH", pract_type); // pract_type added for ML-BRU-SCF-0958 [IN:042045]
		ArrayList ordeCatalogCode	= new ArrayList();
		StringTokenizer token		= new StringTokenizer(order_catalog_code, ",");
		String checkedKey = "";
		while(token.hasMoreTokens()) {
			ordeCatalogCode.add(token.nextToken());
		}
		for (int i=0;i<ordeCatalogCode.size();i++) {
			checkedKey	= (String) ordeCatalogCode.get(i);
			orderEntryRecordBean.removeCheckedEntries(key, "ck" + checkedKey);
			orderEntryRecordBean.removeCheckedEntries(key, "h1" + checkedKey);
			orderEntryRecordBean.removeCheckedEntries(key, "h2" + checkedKey);
		}
		if(!order_set_code.equals("")){
			orderEntryRecordBean.removeCheckedEntries(key, "ck" + order_set_code);
			orderEntryRecordBean.removeCheckedEntries(key, "h1" + order_set_code);
			orderEntryRecordBean.removeCheckedEntries(key, "h2" + order_set_code);
		}

		ArrayList arrCheckCatalog 		= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE",("CK_CODE_0"));
		 if(arrCheckCatalog==null){
           arrCheckCatalog=new ArrayList();
		 }
		String removable_catalog_code	= "";
		int index						= 0;
		if (arrCheckCatalog != null) {
			for(int i=0;i<ordeCatalogCode.size();i++) {
				checkedKey		= (String) ordeCatalogCode.get(i);
				removable_catalog_code	= "ck" + checkedKey;
				if(arrCheckCatalog.contains(removable_catalog_code)) {
					index = arrCheckCatalog.indexOf(removable_catalog_code);
				}
				if (index != -1) {
					if (((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
						arrCheckCatalog.remove(index);
				}
			}

			if(!order_set_code.equals("")){
				removable_catalog_code	= "ck" + order_set_code;
				if(arrCheckCatalog.contains(removable_catalog_code)) {
					index = arrCheckCatalog.indexOf(removable_catalog_code);
				}
				if (((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
					arrCheckCatalog.remove(index);
			}
			if (arrCheckCatalog.size() > 0) {
				orderEntryRecordBean.setOrderFormats("CK_CODE", ("CK_CODE_0"),arrCheckCatalog);
			}
			else {
				orbean.setRefreshYn("Y");
			}
		}
		String iv_prep_yn = bean.getIVPrep();
		bean.clear();

		String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
		String search_bean_name		= "ePH.DrugSearchBean";
		DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id,search_bean_name,request);
		searchbean.clear();

		putObjectInBean(search_bean_id,searchbean,request);
		putObjectInBean(or_bean_id,orbean,request);
		//if(iv_prep_yn.equals("5"))
		//	out.println("reloadOnRelease();");
		
	}//if the drug is scheduled  - store the values in OR_BEAN
	else if (validate.equals("AUTOSCHEDULE")) {
		Hashtable schedule_val	=	new Hashtable();
		ArrayList schedule		=	null;
		Hashtable sch_output	=	null;
		String start_date		= request.getParameter("start_date");
		String qty_value		= request.getParameter("qty_value");
		String freq_code		= request.getParameter("freq_code");
		String drug_code		= request.getParameter("drug_code");
		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		
		if(!bean.checkPreScheduled(freq_code).equals("0") && bean.getScheduledFreqYN(freq_code)) {
			schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code,"0");
			if(schedule.size()==0) {

				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_bean.setLanguageId(locale);
				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", start_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", "N"); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				//added by abdul
				schedule_val.put("code",drug_code);
				//end abdul				
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code);
				sch_output.put("row_value","1");
				//out.println(sch_output);
				bean.setScheduleFrequencyStr(sch_output);

				out.println("makeLink()");
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
		}
	}
	else if (validate.equals("DELETESCHEDULE")) {
		String drug_code		= request.getParameter("drug_code");
		bean.clearscheduleFrequency(drug_code);
	}
	else if (validate != null &&  validate.equals("InsertExternalOverrideReason")) {
		 HashMap drugDetails							=	null;
		 String extdrugCode								=	"";
		 String extsrlNo								=	"";
		 String drug_code								= (String)hash.get( "drug_code" );
		 String srl_no									= (String)hash.get( "srl_no" );
		 String External_Dosage_Override_Reason			= (String)hash.get("External_Dosage_Override_Reason");
		 String External_Duplicate_Override_Reason		= (String)hash.get("External_Duplicate_Override_Reason");
		 String External_Interaction_Override_Reason	= (String)hash.get("External_Interaction_Override_Reason");
		 String External_Contra_Override_Reason			= (String)hash.get("External_Contra_Override_Reason");
		 String External_Alergy_Override_Reason			= (String)hash.get("External_Alergy_Override_Reason");
		 String external_database_overrided_reason		= (String)hash.get("External_database_overrided_reason");

		 if(!External_Dosage_Override_Reason.equals("")&& External_Dosage_Override_Reason!=null)
			External_Dosage_Override_Reason	=	java.net.URLDecoder.decode(External_Dosage_Override_Reason,"UTF-8");
		 if(!External_Duplicate_Override_Reason.equals("")&&External_Duplicate_Override_Reason!=null)
			External_Duplicate_Override_Reason	=	java.net.URLDecoder.decode(External_Duplicate_Override_Reason,"UTF-8");
		 if(!External_Interaction_Override_Reason.equals("")&&External_Interaction_Override_Reason!=null)
			External_Interaction_Override_Reason	=	java.net.URLDecoder.decode(External_Interaction_Override_Reason,"UTF-8");
		 if(!External_Contra_Override_Reason.equals("")&&External_Contra_Override_Reason!=null)
			External_Contra_Override_Reason	=	java.net.URLDecoder.decode(External_Contra_Override_Reason,"UTF-8");
		 if(!External_Alergy_Override_Reason.equals("")&&External_Alergy_Override_Reason!=null)
			External_Alergy_Override_Reason	=	java.net.URLDecoder.decode(External_Alergy_Override_Reason,"UTF-8");

		 ArrayList drugList	= bean.getDrugDetails();
		 if(drugList!=null && drugList.size()>0){
			for(int i=0;i<drugList.size();i++){
				drugDetails				= (HashMap)drugList.get(i);
				extdrugCode				= (String)drugDetails.get("DRUG_CODE");
				extsrlNo				= (String)drugDetails.get("SRL_NO");

				if(extdrugCode != null && extsrlNo!= null && extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){
					drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",External_Dosage_Override_Reason);
					drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",External_Duplicate_Override_Reason);
					drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",External_Alergy_Override_Reason);
					drugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",External_Interaction_Override_Reason);
					drugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",External_Contra_Override_Reason);
					drugDetails.put("DOSE_REMARKS",External_Dosage_Override_Reason);
					drugDetails.put("CURRENTRX_REMARKS",External_Duplicate_Override_Reason);
					drugDetails.put("ALLERGY_REMARKS",External_Alergy_Override_Reason);
					drugDetails.put("EXTERNAL_DATABASE_OVERRIDED_REASON",external_database_overrided_reason);
				}

			}
		}
	}
	else if(validate.equals("ExternalDoseCheck")){
		String adm_prsc				=	(String)hash.get("adm_prsc");	
		String called_from					=	(String)hash.get("called_from");
		patient_id					=	(String)hash.get("patient_id");
		String weight						=	(String)hash.get("weight");				        
		String bsa							=	(String)hash.get("bsa");	
		String pract_name                   =   (String)hash.get("pract_name");
		String repeat_value					=	(String)hash.get("repeat_value");		
		String interval_value				=	(String)hash.get("interval_value");			
		String duration					    =	(String)hash.get("durn_value");			
		String route_code	= (String)hash.get("route_code")==null?"":(String) hash.get( "route_code" );// Added in January 2014 for CIMS dosage check -start
		String qty_desc_code= (String)hash.get("qty_desc_code")==null?"":(String) hash.get( "qty_desc_code" );
		String repeat_durn_type	= hash.get("repeat_durn_type")==null?"":(String) hash.get( "repeat_durn_type" );
		String freq_nature	= hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );
		String freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check -end
		String drug_db_dose_check_flag		=   "N";
		String frequency					=   (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
		String external_prod_id					=	"";
		String dosage							=	"";
		String dosage_by						=	"";
		String dose_uom							=	"";
		String drug_code						=	"";
		String srl_no							=	"";
		String strength_per_pres_uom			=	"";
		String strength_per_value_pres_uom		=	"";
		String fract_dose_round_up_yn			=	"";
		String external_dosage_override_reason	=	"";
		ArrayList drugList	= bean.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		String extdrugCode						=   "";
		String extsrlNo							=   "";
		String startdate="", enddate="";// Added for ML-BRU-SCF-0811 [IN:039394]
		ArrayList reqChecks = new ArrayList();
		reqChecks.add("Y"); //Dosage Check 
		reqChecks.add("N"); //Duplicate Check
		reqChecks.add("N"); //DrugInteraction
		reqChecks.add("N"); //Contra Indication
		reqChecks.add("N"); //AllergyCheck

		if(adm_prsc.equals("presc")){
			external_prod_id             =	(String)hash.get("external_prod_id");
			dosage						=	(String)hash.get("dose");
			dosage_by					=	(String)hash.get("dosage_by");	
			dose_uom						=	(String)hash.get("dose_uom");         
			drug_code					=	(String)hash.get("drug_code");				
			srl_no						=	(String)hash.get("srl_no");				
			strength_per_pres_uom	    =	(String)hash.get("strength_per_pres_uom");	
			strength_per_value_pres_uom	=	(String)hash.get("strength_per_value_pres_uom");	
			fract_dose_round_up_yn		=	(String)hash.get("fract_dose_round_up_yn");		
			external_dosage_override_reason		=	(String)hash.get("external_dosage_override_reason");

			if(dosage_by != null && dosage_by.equals("S")){
				if(fract_dose_round_up_yn.equals("Y")){
					float unit_qty	 =  (float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
					dosage			 =   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
				}
				else{
					dosage			 =  (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
					dosage			 =  (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
				}
				DecimalFormat dfTest =  new DecimalFormat("##.000");
				dosage				 =  dfTest.format(Double.parseDouble(dosage));
				dosage				 =	Math.ceil(Float.parseFloat(dosage))+"";
			}
			String ext_beanid   = "@ExternalProductLinkBean";
			String ext_beanname = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);

			HashMap drugDosageResult	=null;
			ArrayList dosageCheckParams = new ArrayList();
			dosageCheckParams.add(patient_id);
			dosageCheckParams.add(external_prod_id);
			dosageCheckParams.add(weight);
			dosageCheckParams.add(bsa);
			dosageCheckParams.add(dosage);
			if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
				dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
			else
				dosageCheckParams.add(dose_uom);
			dosageCheckParams.add(frequency);
			dosageCheckParams.add(duration);
			dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
			dosageCheckParams.add(repeat_durn_type);	 
			if(freq_nature!=null && !freq_nature.equals(""))
				 freq_nature_pas =  freq_nature;
			dosageCheckParams.add(freq_nature_pas);	
			dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
			/*drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams);
			if(drugDosageResult != null && drugDosageResult.size() > 0){
				ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);	
				drug_db_dose_check_flag="Y";
			}
			else{
				HashMap ext_dosage_det =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
				if(ext_dosage_det != null && ext_dosage_det.size()>0){
					ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
				}
			}	*/
			HashMap drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, external_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
			drug_db_dose_check_flag = "N";
			if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
				drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
				if(drugDosageResult != null && drugDosageResult.size() > 0){
					ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);
					drug_db_dose_check_flag = "Y";
				}
			}
			if(drug_db_dose_check_flag.equals("N")){
				drugDosageResult =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
				if(drugDosageResult != null && drugDosageResult.containsKey(external_prod_id)){
					ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
				}
			}
			putObjectInBean(ext_beanid,ext_beanObj,request);
	
			if(drugList!=null && drugList.size()>0){
				for(int i=0;i<drugList.size();i++){
					drugDetails				= (HashMap)drugList.get(i);
					extdrugCode				= (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
					extsrlNo				= (String)drugDetails.get("SRL_NO")==null?"":(String)drugDetails.get("SRL_NO");
					if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){					
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
					}
				}
			}
		   if(!called_from.equals("ONLOAD")&& drug_db_dose_check_flag.equals("Y")){
				out.println("viewMedicationAlert('"+patient_id+"','"+external_prod_id+"','N','N','N','"+drug_db_dose_check_flag+"','"+called_from+"','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','','','','"+pract_name+"','')");
		   }
		   else
				out.println("setextdoseflag('"+drug_db_dose_check_flag+"')");
		}
		else{
			if(drugList!=null && drugList.size()>0){
				for(int i=0;i<drugList.size();i++){
					drugDetails					= (HashMap)drugList.get(i);
					if((String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")!=null && ((String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")).equals("Y")){
						external_prod_id				=	(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
						dosage							=	(String)drugDetails.get("STRENGTH_VALUE");
						dosage_by						=	(String)drugDetails.get("DOSAGE_TYPE");	
						if(dosage_by.equals("S"))
							dose_uom						=	(String)drugDetails.get("STRENGTH_UOM");         
						else if(dosage_by.equals("Q"))
							dose_uom						=	(String)drugDetails.get("PRES_BASE_UOM");
						drug_code						=	(String)drugDetails.get("DRUG_CODE");				
						srl_no							=	(String)drugDetails.get("SRL_NO");				
						strength_per_pres_uom			=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
						strength_per_value_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
						fract_dose_round_up_yn			=	bean.getFractDoseRndyn(drug_code);
						
					   if(dosage_by != null && dosage_by.equals("S")){
							if(fract_dose_round_up_yn.equals("Y")){
								float unit_qty	 =  (float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
								dosage			 =   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
							}
							else{
								dosage			 =  (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
								dosage			 =  (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
							}
							DecimalFormat dfTest =  new DecimalFormat("##.000");
							dosage				 =  dfTest.format(Double.parseDouble(dosage));
							dosage				 =	Math.ceil(Float.parseFloat(dosage))+"";
						}
						String ext_beanid   = "@ExternalProductLinkBean";
						String ext_beanname = "ePH.ExternalProductLinkBean";
						ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);

						HashMap drugDosageResult	= new HashMap();
						ArrayList dosageCheckParams = new ArrayList();
						dosageCheckParams.add(patient_id);
						dosageCheckParams.add(external_prod_id);
						dosageCheckParams.add(weight);
						dosageCheckParams.add(bsa);
						dosageCheckParams.add(dosage);
						if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
							dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
						else
							dosageCheckParams.add(dose_uom);
						dosageCheckParams.add(frequency);
						dosageCheckParams.add(duration);
						dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
						dosageCheckParams.add(repeat_durn_type);	 
						if(freq_nature!=null && !freq_nature.equals(""))
							 freq_nature_pas =  freq_nature;
						dosageCheckParams.add(freq_nature_pas);	
						dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
						/*drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams);
						if(drugDosageResult != null && drugDosageResult.size() > 0 ){
							ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);	
							drug_db_dose_check_flag="Y";
							drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
							if (drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON") != null && drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON").toString().equals("")){ //condition added by krishnakiran
								out.println("DisplayFDBOverrideImage('"+srl_no+"','DOSAGE');");	
							}
						}
						else{
							HashMap ext_dosage_det =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
							if(ext_dosage_det != null && ext_dosage_det.size()>0){
								drug_db_dose_check_flag="N";
								drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
								ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
								out.println("HideFDBOverrideImage('"+srl_no+"','DOSAGE');");									
							}
						}*/
						HashMap drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, external_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
						if(drugDBCheckResult!=null)
							ext_beanObj.setExternalDBCheckResult(external_prod_id,srl_no,drugDBCheckResult);

						drug_db_dose_check_flag = "N";
						if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
							drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
							if(drugDosageResult != null && drugDosageResult.size() > 0){
								ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);
								drug_db_dose_check_flag = "Y";
								drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
								if (drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON") != null && drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON").toString().equals("")){ //condition added by krishnakiran
									out.println("DisplayFDBOverrideImage('"+srl_no+"','DOSAGE');");	
								}
							}
						}
						if(drug_db_dose_check_flag.equals("N")){
							drugDosageResult =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
							if(drugDosageResult != null && drugDosageResult.containsKey(external_prod_id)){
								ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
								drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
								out.println("HideFDBOverrideImage('"+srl_no+"','DOSAGE');");									
							}
						}
					}
				}
			}
		}
	}
	else if(validate.equals("OrdDispenseLocation")){
		String location_type			= (String)hash.get("location_type");
		String location_code			= (String)hash.get("location_code");
		String take_home_medication	= (String)hash.get("take_home_medication");
		String priority				= (String)hash.get("priority");
		String iv_prep_yn				= (String)hash.get("iv_prep_yn");
		String take_home_medication_op				= (String)hash.get("take_home_medication_op");//Added for NMC-JD-CRF-0063 start
		String take_home_medication_ckk_val				= (String)hash.get("take_home_medication_ckk_val");
		if(take_home_medication_op!=null && !take_home_medication_op.equals("")){
			bean.setTakeHomeMedicationOp(take_home_medication_op);
		}
		bean.setOpDischMedInd(take_home_medication_ckk_val); //end
	 	String dflt_disp_locn	= "";	
		String time_flag ="";
		ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added for Bru-HIMS-CRF-347 [IN:037862] ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]

		if(ord_disp_location != null & ord_disp_location.size()>0){
			dflt_disp_locn	= (String)ord_disp_location.get(2);
			time_flag       = bean.ChkWorkingHours((String)ord_disp_location.get(0));
		}
		out.println("displayDispLocn('"+dflt_disp_locn+"','"+time_flag+"');");
	}
	else if (validate!= null && validate.equals("GET_TRNGROUPREF")){
		String tokens_generated_yn = bean.getTokensGeneratedYN();
		String trn_group_ref = "";
		if(tokens_generated_yn.equals("Y")){
			trn_group_ref = bean.getTrnGroupRef();
		}
		out.println(trn_group_ref);
	}
	else if(validate.equals("DosageLimitCheck")){
		patient_id			= (String)hash.get("patient_id");
		String drug_code	= (String)hash.get("drug_code");
		String srl_no	= (String)hash.get("srl_no");
		String repeat_value			= (String)hash.get("repeat_value");
		String qty_value				= (String)hash.get("qty_value");
		String dosage_type				= (String)hash.get("dosage_type");
		String factor				= (String)hash.get("factor");//Added for IN:070451
		String mode				= (String)hash.get("mode");//Added for IN:070451
		ArrayList drugList	= bean.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		String extdrugCode = "";
		String extsrlNo = "";

		HashMap dosageDetails= (HashMap) bean.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value,factor);//Modified for IN:070451 added factor param
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
			out.println("enableDosageLimit('"+limit_ind+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+min_daily_dose+"','"+min_unit_dose+"','"+mode+"')");//Modified for IN:070451 added mode param
		}
		else
			out.println("disableDosageLimit('"+mode+"')");//Modified for IN:070451 added mode param
	}
	else if(validate.equals("SAVE_MFR")){
		String totRec		= (String)hash.get("noOfRows")==null?"0":(String)hash.get("noOfRows");
		int iTotRec = 0;
		String infVolume	= "";
		String infRate		= "";
		String infRateHrMin	= "";
		String infOverHr	= "";
		String infOverMin	= "";
		String startDateTime	= "";
		String endDateTime	= "";
		String infGapHr		= "";
		String infGapMin	= "";
		String infusion_over_insert_value	= "";
		String totInfVolume	= "";
		String totFlowDurn	= "";
		String totFlowDurnHrs= "";
		String totDuration	= "";
		String totDurnHrs	= "";
		String flowStartDate	= "";
		String flowEndDate	= "";
		String infGapInHr	= "";
		HashMap MFR_Recs	= new HashMap();
		ArrayList MFR_Detail	= new ArrayList();

		if(!totRec.equals(""))
			iTotRec = Integer.parseInt(totRec);
		if(iTotRec > 1)
			bean.setMFRYN("Y");
		if(iTotRec >= 1){
			totInfVolume	= (String)hash.get("TotInfVolume");
			totFlowDurn		= (String)hash.get("TotFlowDurn");
			totDuration		= (String)hash.get("TotDuration");
			totFlowDurnHrs	= (String)hash.get("TotFlowDurnHrs");
			totDurnHrs		= (String)hash.get("TotDurnHrs");
			for(int i = 1; i<=iTotRec; i++){
				MFR_Detail = new ArrayList();
				infVolume		= (String)hash.get("InfVolume"+i);
				infRate			= (String)hash.get("InfRate"+i);
				infRateHrMin	= (String)hash.get("InfRateHrMin"+i);
				infOverHr		= (String)hash.get("InfOverHr"+i);
				infOverMin		= (String)hash.get("InfOverMin"+i);
				startDateTime	= (String)hash.get("StartDateTime"+i);
				endDateTime		= (String)hash.get("EndDateTime"+i);
				infGapHr		= (String)hash.get("InfGapHr"+i);
				infGapMin		= (String)hash.get("InfGapMin"+i);
				infusion_over_insert_value		= (String)hash.get("infusion_over_insert_value"+i);
				infGapInHr		= (String)hash.get("InfGapInHr"+i);

				MFR_Detail.add(infVolume);//1
				MFR_Detail.add(infRate);//2
				MFR_Detail.add(infRateHrMin);//3
				MFR_Detail.add(infOverHr);//4
				MFR_Detail.add(infOverMin);//5
				MFR_Detail.add(infusion_over_insert_value);//6
				MFR_Detail.add(startDateTime);//7
				MFR_Detail.add(endDateTime);//8
				MFR_Detail.add(infGapHr);//9
				MFR_Detail.add(infGapMin);//10
				MFR_Detail.add(infGapInHr);//11

				MFR_Recs.put("MFR"+i,MFR_Detail);
			}
			MFR_Recs.put("totInfVolume",totInfVolume);
			MFR_Recs.put("totFlowDurn",totFlowDurn);
			MFR_Recs.put("totDuration",totDuration);
			MFR_Recs.put("totFlowDurnHrs",totFlowDurnHrs);
			MFR_Recs.put("totDurnHrs",totDurnHrs);
			MFR_Recs.put("flowStartDate",request.getParameter("flowStartDate"));
			MFR_Recs.put("flowEndDate",request.getParameter("flowEndDate"));
			MFR_Recs.put("totRec",totRec);

			bean.setMFRRecs(MFR_Recs);

		}
	}
	else if(validate.equals("SAVE_MFR_FLUIDS")){
		String totRec		= (String)hash.get("noOfRows")==null?"0":(String)hash.get("noOfRows");
		int iTotRec = 0;
		String infVolume	= "";
		String infRate		= "";
		String infRateHrMin	= "";
		String infOverHr	= "";
		String infOverMin	= "";
		String startDateTime	= "";
		String endDateTime	= "";
		String infGapHr		= "";
		String infGapMin	= "";
		String infusion_over_insert_value	= "";
		String totInfVolume	= "";
		String totFlowDurn	= "";
		String totFlowDurnHrs= "";
		String totDuration	= "";
		String totDurnHrs	= "";
		String flowStartDate	= "";
		String flowEndDate	= "";
		String infGapInHr	= "";
		String fluidCode	= (String)hash.get("fluidCode");
		HashMap MFR_Recs	= new HashMap();
		ArrayList MFR_Detail	= new ArrayList();
		
		if(!totRec.equals(""))
			iTotRec = Integer.parseInt(totRec);
		if(iTotRec > 1)
			bean.setMFRYN("Y");
		if(iTotRec >= 1){
			totInfVolume	= (String)hash.get("TotInfVolume");
			totFlowDurn		= (String)hash.get("TotFlowDurn");
			totDuration		= (String)hash.get("TotDuration");
			totFlowDurnHrs	= (String)hash.get("TotFlowDurnHrs");
			totDurnHrs		= (String)hash.get("TotDurnHrs");
			for(int i = 1; i<=iTotRec; i++){
				MFR_Detail = new ArrayList();
				infVolume		= (String)hash.get("InfVolume"+i);
				infRate			= (String)hash.get("InfRate"+i);
				infRateHrMin	= (String)hash.get("InfRateHrMin"+i);
				infOverHr		= (String)hash.get("InfOverHr"+i);
				infOverMin		= (String)hash.get("InfOverMin"+i);
				startDateTime	= (String)hash.get("StartDateTime"+i);
				endDateTime		= (String)hash.get("EndDateTime"+i);
				infGapHr		= (String)hash.get("InfGapHr"+i);
				infGapMin		= (String)hash.get("InfGapMin"+i);
				infusion_over_insert_value		= (String)hash.get("infusion_over_insert_value"+i);
				infGapInHr		= (String)hash.get("InfGapInHr"+i);

				MFR_Detail.add(infVolume);//1
				MFR_Detail.add(infRate);//2
				MFR_Detail.add(infRateHrMin);//3
				MFR_Detail.add(infOverHr);//4
				MFR_Detail.add(infOverMin);//5
				MFR_Detail.add(infusion_over_insert_value);//6
				MFR_Detail.add(startDateTime);//7
				MFR_Detail.add(endDateTime);//8
				MFR_Detail.add(infGapHr);//9
				MFR_Detail.add(infGapMin);//10
				MFR_Detail.add(infGapInHr);//11
				MFR_Detail.add("");//11 admin detail
				
				MFR_Recs.put("MFR"+i,MFR_Detail);
			}
			MFR_Recs.put("totInfVolume",totInfVolume);
			MFR_Recs.put("totFlowDurn",totFlowDurn);
			MFR_Recs.put("totDuration",totDuration);
			MFR_Recs.put("totFlowDurnHrs",totFlowDurnHrs);
			MFR_Recs.put("totDurnHrs",totDurnHrs);
			MFR_Recs.put("flowStartDate",request.getParameter("flowStartDate"));
			MFR_Recs.put("flowEndDate",request.getParameter("flowEndDate"));
			MFR_Recs.put("totRec",totRec);

			bean.setMFRRecs_fluids(MFR_Recs,fluidCode);
		}
	}
	else if(validate.equals("SAVE_FLUIDDETAILS")){
		
		String fluid_code		= (String)hash.get("fluid_code");
		String infusion_over			= (String)hash.get("infusion_over");
		String tot_inf_prd				= (String)hash.get("tot_inf_prd");
		String durn_value				= (String)hash.get("durn_value");
		String lstInfusionRateDurnUnit	= (String)hash.get("lstInfusionRateDurnUnit");
		String orderDate				= (String)hash.get("orderDate");
		String MFR_YN				= (String)hash.get("MFR_YN");
		String iv_calc_infuse_by	= hash.get("iv_calc_infuse_by")==null?"":(String)hash.get("iv_calc_infuse_by");
		String ordered_qty = "";
		float durn_value_f = 0.0f;
		String pack_size = "";
		String tot_flow_durnHrs = "";
		pack_size	= bean.getPackSize(fluid_code);
		if(MFR_YN.equals("Y")){
			HashMap MultiFlowRecs = bean.getMFRRecs();
			if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
				tot_inf_prd = (String)MultiFlowRecs.get("totInfVolume")==null?"":(String)MultiFlowRecs.get("totInfVolume");
				tot_flow_durnHrs= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
				//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
				durn_value_f = Float.parseFloat(tot_flow_durnHrs);
				ordered_qty		= Math.ceil(Float.parseFloat(tot_inf_prd)/Float.parseFloat(pack_size))+"";//*durn_value_f+"";
			}
		}
		else{
			/*if(lstInfusionRateDurnUnit.equals("M")){
			//	infusion_over = Float.parseFloat(infusion_over)/60+"";
			}*/
			if(iv_calc_infuse_by.equals("I"))
				durn_value_f=1;
			else
				durn_value_f			= Float.parseFloat(Math.ceil(((Integer.parseInt(durn_value) / (Float.parseFloat(infusion_over)))*100)/100)+"");
			//String order_uom	= bean.getStockUOM(fluid_code);
			ordered_qty		= Math.ceil(Float.parseFloat(tot_inf_prd)/Float.parseFloat(pack_size))*durn_value_f+"";
		}
     if(! bean.getLanguageId().equals("en"))
           orderDate =com.ehis.util.DateUtils.convertDate(orderDate,"DMYHM",bean.getLanguageId(),"en");
		bean.setOrderDate(orderDate);
		HashMap fluidDetails	= bean.getFluidDetails();
	
		if(fluid_code.equals(fluidDetails.get("DRUG_CODE")))
			fluidDetails.put("ORDERED_QTY",ordered_qty);
	}
	else if(validate.equals("SAVE_ALL_FLUIDDETAILS")){
		String fluid_code			= "";	
		String infusion_over		= "";
		String tot_inf_prd			= "";	
		String durn_value			= "";			                    
		float durn_value_f			= 0.0f;
		String pack_size			= "";	
		String order_uom			= "";	
		String ordered_qty			= "";			                    
		String orderDateTime		= (String)hash.get("orderDateTime");
		String MFR_YN				= "";      
		String tot_flow_durnHrs		= "";  		
		String iv_calc_infuse_by	= (String)hash.get("iv_calc_infuse_by")==null?"":(String)hash.get("iv_calc_infuse_by");

		String bl_error_code				= "";      
		String bl_sys_message_id			= "";      
		String bl_error_text				= "";   		
		String bl_included_IE				= "";          
		String bl_incl_excl_override_value	= "";
		String bl_override_reason_code		= ""; 
		String bl_override_reason_desc		= ""; 
		String bl_override_allowed_yn		= "";
		HashMap existing_fluid_det         = new HashMap();
             
		//HashMap fluidDetails = null;
		ArrayList AllFluids = new ArrayList();

		bean.setOrderDate(com.ehis.util.DateUtils.convertDate(orderDateTime,"DMYHM",locale,"en"));

		for(int i=1; i<=6;i++){
			if(hash.containsKey("fluid_code"+i)){
				HashMap fluidDetails = new HashMap();
				fluid_code		= (String)hash.get("fluid_code"+i);
				infusion_over	= (String)hash.get("infusion_over"+i);
				tot_inf_prd		= (String)hash.get("tot_inf_prd"+i)==null?"0":(String)hash.get("tot_inf_prd"+i);
				durn_value		= (String)hash.get("durn_value"+i)==null?"0":(String)hash.get("durn_value"+i);
				MFR_YN			= (String)hash.get("MFR_YN"+i)==null?"N":(String)hash.get("MFR_YN"+i);
				pack_size		= bean.getPackSize(fluid_code);
				order_uom		= bean.getStockUOM(fluid_code);
				if(MFR_YN.equals("Y")){
					HashMap MultiFlowRecs = bean.getMFRRecs_fluids(fluid_code);
					if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
						tot_inf_prd = (String)MultiFlowRecs.get("totInfVolume")==null?"":(String)MultiFlowRecs.get("totInfVolume");
						tot_flow_durnHrs= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
					//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
						durn_value_f = Float.parseFloat(tot_flow_durnHrs);
						ordered_qty		= Math.ceil(Float.parseFloat(tot_inf_prd)/Float.parseFloat(pack_size))+"";//*durn_value_f+"";
					}
				}
				else{					
					durn_value_f			= Float.parseFloat(Math.ceil(((Integer.parseInt(durn_value) / (Float.parseFloat(infusion_over)))*100)/100)+"");
					ordered_qty		= Math.ceil(Float.parseFloat(tot_inf_prd)/Float.parseFloat(pack_size)*durn_value_f)+"";
				}
				if(iv_calc_infuse_by.equals("I"))
					ordered_qty		= (String)hash.get("order_qty"+i)==null?ordered_qty:(String)hash.get("order_qty"+i);
				bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED
				fluidDetails	= bean.getFluidDetails();
				if(fluid_code.equals(fluidDetails.get("DRUG_CODE"))){
					fluidDetails.put("ORDERED_QTY",ordered_qty);
				}

//added for Billing CRF 0001
				ArrayList all_bean_fluidDetails	= (ArrayList)bean.getAllFluids();
			   if(all_bean_fluidDetails.size()>0 && ((i-1) < (all_bean_fluidDetails.size()))){
                        existing_fluid_det      = (HashMap)all_bean_fluidDetails.get(i-1);
                        if(existing_fluid_det.containsKey("BL_ERROR_CODE")){
								bl_error_code			= (String)existing_fluid_det.get("BL_ERROR_CODE")==null?"":(String)existing_fluid_det.get("BL_ERROR_CODE"); 
								bl_sys_message_id		= (String)existing_fluid_det.get("BL_SYS_MESSAGE_ID")==null?"":(String)existing_fluid_det.get("BL_SYS_MESSAGE_ID");
								bl_error_text			= (String)existing_fluid_det.get("BL_ERROR_TEXT")==null?"":(String)existing_fluid_det.get("BL_ERROR_TEXT");
						}
						if ((!bl_error_code.equals("10") && (bl_error_text.equals(""))) || bl_sys_message_id.equals("")){
                               if(existing_fluid_det.containsKey("BL_OVERRIDE_ALLOWED_YN")){
									bl_included_IE              = (String)existing_fluid_det.get("BL_INCL_EXCL_VALUE")==null?"":(String)existing_fluid_det.get("BL_INCL_EXCL_VALUE");         
									bl_incl_excl_override_value = (String)existing_fluid_det.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)existing_fluid_det.get("BL_INCL_EXCL_OVERRIDE_VALUE");       
									bl_override_reason_code     = (String)existing_fluid_det.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)existing_fluid_det.get("BL_INCL_EXCL_OVERRIDE_REASON");
									bl_override_reason_desc     = (String)existing_fluid_det.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)existing_fluid_det.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
									bl_override_allowed_yn      = (String)existing_fluid_det.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)existing_fluid_det.get("BL_OVERRIDE_ALLOWED_YN");
                                    if(fluid_code.equals(fluidDetails.get("DRUG_CODE"))){
										fluidDetails.put("BL_INCL_EXCL_VALUE",bl_included_IE);
										fluidDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE",bl_incl_excl_override_value);
										fluidDetails.put("BL_INCL_EXCL_OVERRIDE_REASON",bl_override_reason_code);
										fluidDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_override_reason_desc);
										fluidDetails.put("BL_OVERRIDE_ALLOWED_YN",bl_override_allowed_yn);
									}
							   }
						}
			   }
	/*=====ends here===============*/
				AllFluids.add(fluidDetails);
			}
		}
		bean.setAllFluids(AllFluids);
	}
	else if(validate.equals("GET_BL_ERRORS_IVWA")){

		String fluid_code		= (String)hash.get("fluid_code");
		String infusion_over			= (String)hash.get("infusion_over")==null?"":(String)hash.get("infusion_over");
		infusion_over = infusion_over.equals("")?"0":infusion_over;
		String tot_inf_prd				= (String)hash.get("tot_inf_prd");
		String durn_value				= (String)hash.get("durn_value")==null?"":(String)hash.get("durn_value");
		durn_value = durn_value.equals("")?"0":durn_value;
		String actual_patient_class				= (String)hash.get("actual_patient_class")==null?"":(String)hash.get("actual_patient_class");
		String episode_type = actual_patient_class.substring(0,1);
		if(episode_type.equals("X"))
			episode_type = "R";
		String item_code = "";
		String in_formulary_yn = "";
		String bl_error_code	="";
		String bl_sys_message_id = "";
		String bl_error_text	 = "";
		String fract_dose	 = "";
		String strength_per_value_pres_uom = "";
		String strength_per_pres_uom = "";
		String content_in_pres_base_uom = "";
		String drug_desc = ""; 
		String discharge_yn		=  (String)hash.get("discharge_yn");;
		float dur1			= 0.0f;
		if(!durn_value.equals("0") && !infusion_over.equals("0"))
			dur1			= Float.parseFloat(Math.ceil(((Integer.parseInt(durn_value) / (Float.parseFloat(infusion_over)))*100)/100)+"");
		float durn_value_f			= Float.parseFloat(Math.ceil(((Integer.parseInt(durn_value) / (Float.parseFloat(infusion_over)))*100)/100)+"");
		String pack_size	= bean.getPackSize(fluid_code);
		//String order_uom	= bean.getStockUOM(fluid_code);
		String ordered_qty		= Math.ceil(Float.parseFloat(tot_inf_prd)/Float.parseFloat(pack_size))*durn_value_f+"";
		ArrayList blErrorDrugs = new ArrayList();

		HashMap fluidDetails	= bean.getFluidDetails();
		in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
		if(in_formulary_yn.equals("Y")){
			item_code = (String)fluidDetails.get("ITEM_CODE")==null?"":(String)fluidDetails.get("ITEM_CODE");

			if(fluid_code.equals(fluidDetails.get("DRUG_CODE")))
				fluidDetails.put("ORDERED_QTY",ordered_qty);
			bean.setBillingDetail(fluidDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,discharge_yn );
			bl_error_code			= (String)fluidDetails.get("BL_ERROR_CODE")==null?"":(String)fluidDetails.get("BL_ERROR_CODE"); 
			bl_sys_message_id		= (String)fluidDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)fluidDetails.get("BL_SYS_MESSAGE_ID");
			bl_error_text			= (String)fluidDetails.get("BL_ERROR_TEXT")==null?"":(String)fluidDetails.get("BL_ERROR_TEXT");
			drug_desc			= (String)fluidDetails.get("DRUG_DESC")==null?"":(String)fluidDetails.get("DRUG_DESC");
			drug_desc = java.net.URLEncoder.encode(drug_desc.replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20");

			if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
				blErrorDrugs.add("F");
				blErrorDrugs.add(drug_desc);
				blErrorDrugs.add(bl_error_code);
				blErrorDrugs.add(bl_sys_message_id);
				blErrorDrugs.add(bl_error_text);
			}
		}
		ArrayList drugList	= bean.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		if(drugList!=null && drugList.size()>0){
			for(int i=0;i<drugList.size();i++){
				drugDetails				= (HashMap)drugList.get(i);
				in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
				if(in_formulary_yn.equals("Y") && drugDetails.size() > 0){
					item_code = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");

					float ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
					float in_tot_qty = 0.0f;
					content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
					fract_dose					=   bean.getFractDoseRndyn((String)drugDetails.get("DRUG_CODE"));

					if(drugDetails.get("DOSAGE_TYPE") !=null){
						if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")) {				

							strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
							strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
							if(fract_dose.equals("Y")){
								in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
				
							}
							else if(fract_dose.equals("N")){

								in_tot_qty	= (ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)); 
 
							}

							ordered_qty		=   Math.ceil((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";

						}
						else {
							String qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
							String ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
							String eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
							if(eqvl_value.equals(""))	eqvl_value	=	"1";	
								in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);

							if(fract_dose.equals("Y")){
								ordered_qty	=   Math.ceil((in_tot_qty/Float.parseFloat(content_in_pres_base_uom))*dur1)+"";
							}
							else if(fract_dose.equals("N")){
								ordered_qty	=   Math.ceil((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
							}
						}	
					}

					drugDetails.put("ORDERED_QTY",ordered_qty);
					bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,discharge_yn );
					bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
					bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
					bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
					drug_desc			= (String)fluidDetails.get("DRUG_DESC")==null?"":(String)fluidDetails.get("DRUG_DESC");
					drug_desc = java.net.URLEncoder.encode(drug_desc.replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20");

					if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
						blErrorDrugs.add("D");
						blErrorDrugs.add(drug_desc);
						blErrorDrugs.add(bl_error_code);
						blErrorDrugs.add(bl_sys_message_id);
						blErrorDrugs.add(bl_error_text);
					}
				}
			}
		}
		if(blErrorDrugs!=null && blErrorDrugs.size()>0)
			out.println("alertBLErrorDrugs('"+blErrorDrugs+"');");
	}
	//Added for  ML-BRU-CRF-072[Inc:29938]  start
	else if(validate.equals("SAVE_DRUGINDICATION")){
	
			String DrugIndicationRemarks	= (String) hash.get( "drug_indication_new" );
			if(DrugIndicationRemarks!=null && !DrugIndicationRemarks.equals("")) 
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8");
			//bean.setDrugIndicationRemarks(DrugIndicationRemarks);
	}
    //Added for  ML-BRU-CRF-072[Inc:29938] End
	else if(validate.equals("FINDDISPLOCATION")){

	DrugSearchBean	bean1	 =	(DrugSearchBean)getBeanObject( "DrugSearchBean", "ePH.DrugSearchBean", request ) ;
	
			out.print(bean1.getDispLocnCode());
	}
	else if(validate.equals("GET_BL_ERROR_DRUGS_FLUIDS")){

		String actual_patient_class	= (String)hash.get("actual_patient_class")==null?"":(String)hash.get("actual_patient_class");
		String episode_type = actual_patient_class.substring(0,1);
		if(episode_type.equals("X"))
			episode_type = "R";

		String item_code = "";
		String in_formulary_yn = "";
		String bl_error_code	="";
		String bl_sys_message_id = "";
		String bl_error_text	 = "";
		String ordered_qty		= "";
		String fluid_name		= "";
		String discharge_yn	= (String)hash.get("discharge_yn");
		ArrayList blErrorDrugs = new ArrayList();
	
		ArrayList fluidList	= bean.getAllFluids();
		HashMap  fluidDetails			= new HashMap();
		if(fluidList!=null && fluidList.size()>0){
			for(int i=0;i<fluidList.size();i++){
				fluidDetails				= (HashMap)fluidList.get(i);
				in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
				if(in_formulary_yn.equals("Y")){
					item_code = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
					fluid_name = (String)fluidDetails.get("DRUG_DESC")==null?"":(String)fluidDetails.get("DRUG_DESC");

					ordered_qty = (String)fluidDetails.get("ORDERED_QTY")==null?"":(String)fluidDetails.get("ORDERED_QTY");

					bean.setBillingDetail(fluidDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,discharge_yn );
					bl_error_code			= (String)fluidDetails.get("BL_ERROR_CODE")==null?"":(String)fluidDetails.get("BL_ERROR_CODE"); 
					bl_sys_message_id		= (String)fluidDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)fluidDetails.get("BL_SYS_MESSAGE_ID");
					bl_error_text			= (String)fluidDetails.get("BL_ERROR_TEXT")==null?"":(String)fluidDetails.get("BL_ERROR_TEXT");
					fluid_name = java.net.URLEncoder.encode(fluid_name.replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20");

					if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
						blErrorDrugs.add("D");
						blErrorDrugs.add(fluid_name);
						blErrorDrugs.add(bl_error_code);
						blErrorDrugs.add(bl_sys_message_id);
						blErrorDrugs.add(bl_error_text);
					}
				}
			}
		}
		if(blErrorDrugs!=null && blErrorDrugs.size()>0){
			out.println("alertBLErrorDrugs('"+blErrorDrugs+"');");
		}
	}
	putObjectInBean(bean_id,bean,request);	
}
catch(Exception e){
	e.printStackTrace();
}
%>
