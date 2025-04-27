<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.* ,java.text.SimpleDateFormat,java.util.Date,eST.*,eST.Common.*" contentType="text/html; charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
try {
	String locale			= (String)session.getAttribute("LOCALE");//Added for Bru-HIMS-CRF-399 [IN:043767]
	String func_mode			= request.getParameter("func_mode");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= "MedicationAdministrationBean";
	String bean_name			= "ePH.MedicationAdministrationBean";	
	MedicationAdministrationBean bean = (MedicationAdministrationBean)getBeanObject( bean_id, bean_name , request);
	
	String admin_bean_id	= "MedicationAdministrationFTBean";
	String admin_bean_name  = "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean admin_bean	= (MedicationAdministrationFTBean)getBeanObject( admin_bean_id, admin_bean_name, request );

	String drug_search_bean_id				= "DrugSearchBean";
	String drug_search_bean_name			= "ePH.DrugSearchBean";
	DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);

	if(func_mode!= null && func_mode.equals("changeDetails")){
		String drug_code=(String) hash.get("drug_code");
		String order_id=(String) hash.get("order_id");
		String srl_no=(String) hash.get("srl_no");
		String qty=(String) hash.get("qty");
		String time=(String) hash.get("time");
		String remarks=(String) hash.get("remarks");
		
		ArrayList DrugDoseTimeDetails=bean.getDrugDoseTimeDetails();
		if(DrugDoseTimeDetails.size()>0){
			HashMap DoseDetails= new HashMap();
			String drugCode	   = "";
			String srlNo	   = "";
			String orderId	   = "";
			for(int i=0;i<DrugDoseTimeDetails.size();i++){
				DoseDetails = new HashMap();
				DoseDetails	= (HashMap) DrugDoseTimeDetails.get(i);
				drugCode	= (String) DoseDetails.get("DRUG_CODE");
				srlNo		= (String) DoseDetails.get("SRL_NO");
				orderId		= (String) DoseDetails.get("ORDER_ID");
				if( (drugCode.equals(drug_code)) && (srl_no.equals(srlNo)) && (orderId.equals(order_id)) ){
					DoseDetails.put("CHANGE_YN","Y");
					DoseDetails.put("DRUG_CODE",drug_code);
					DoseDetails.put("QTY_"+srl_no,qty);
					DoseDetails.put("TIME"+srl_no,time);
					DoseDetails.put("REMARKS_"+srl_no,remarks);			
				}
			}
		}
		out.println("refreshPage(\"" + order_id + "\",\"" + drug_code + "\",\"" + srl_no + "\");") ;
	 }
	 else if(func_mode!= null && func_mode.equals("addDetails")){
		String drug_code	=(String) hash.get("drug_code");
		String drug_name	=(String) hash.get("drug_name");
		String pract_id		=(String) hash.get("pract_id");
		String pract_name	=(String) hash.get("pract_name");
		String dose_qty		=(String) hash.get("dose_qty");
		String qty_uom		=(String) hash.get("qty_uom");
		String route_code	=(String) hash.get("route_code");
		String freq_code	=(String) hash.get("freq_code");
		String admin_date_time=(String) hash.get("admin_date_time");
		String batch_id		=(String) hash.get("batch_id");
		String expiry_date	=(String) hash.get("expiry_date");
		String trade_name	=(String) hash.get("trade_name");
		String rdesc		=(String) hash.get("route_desc");
		String fdesc		=(String) hash.get("freq_desc");

		ArrayList DrugDoseTimeDetails=new ArrayList();
		DrugDoseTimeDetails=bean.getnewDrugDetails();
		HashMap DoseDetails=new HashMap();
		int srl_no=DrugDoseTimeDetails.size();
		srl_no=srl_no+1;
		DoseDetails.put("DRUG_CODE",drug_code);
		DoseDetails.put("SRL_NO",String.valueOf(srl_no));
		DoseDetails.put("DRUG_NAME",drug_name);
		DoseDetails.put("PRACT_ID",pract_id);
		DoseDetails.put("PRACT_NAME",pract_name);
		DoseDetails.put("DOSE_QTY",dose_qty);
		DoseDetails.put("QTY_UOM",qty_uom);
		DoseDetails.put("ROUTE_CODE",route_code);
		DoseDetails.put("FREQ_CODE",freq_code);
		DoseDetails.put("ADMIN_DATE_TIME",admin_date_time);
		DoseDetails.put("BATCH_ID",batch_id);
		DoseDetails.put("EXPIRY_DATE",expiry_date);
		DoseDetails.put("TRADE_NAME",trade_name);
		DoseDetails.put("ROUTE_DESC",rdesc);
		DoseDetails.put("FREQ_DESC",fdesc);
		bean.setnewDrugDetails(DoseDetails);
		out.println("refreshnewEntryPage();") ;
	 }
	 else if(func_mode!= null && func_mode.equals("ValidateExpiry")){
		 String expiry_date = (String) hash.get("expiry_date");
		 if(bean.validateExpiry(expiry_date)){
		 out.println("warnExpiry()");
		 }
	 }
	 else if(func_mode!= null && func_mode.equals("amendDetails")){
		String drug_code	=(String) hash.get("drug_code");
		String srl_no		=(String) hash.get("srl_no");
		String dose_qty		=(String) hash.get("dose_qty");
		String qty_uom		=(String) hash.get("qty_uom");
		String route_code	=(String) hash.get("route_code");
		String freq_code	=(String) hash.get("freq_code");
		String admin_date_time=(String) hash.get("admin_date_time");
				
		ArrayList newDrugDoseTimeDetails=new ArrayList();
		newDrugDoseTimeDetails=bean.getnewDrugDetails();
		if(newDrugDoseTimeDetails.size()>0){
			HashMap drugDetails= new HashMap();
			String drugCode    = "";
			String srlNo       = "";

			for(int i=0;i<newDrugDoseTimeDetails.size();i++){
				drugDetails = new HashMap();
				drugDetails =(HashMap) newDrugDoseTimeDetails.get(i);
				drugCode	=(String) drugDetails.get("DRUG_CODE");
				srlNo		=(String) drugDetails.get("SRL_NO");
				if( drug_code.trim().equals(drugCode.trim()) && srl_no.trim().equals(srlNo.trim())){
					drugDetails.put("DOSE_QTY",dose_qty);
					drugDetails.put("QTY_UOM",qty_uom);
					drugDetails.put("ROUTE_CODE",route_code);
					drugDetails.put("FREQ_CODE",freq_code);
					drugDetails.put("ADMIN_DATE_TIME",admin_date_time);
				}
			}
		}
		out.println("refreshnewEntryPage();") ;
	 }
	 else if(func_mode!= null && func_mode.equals("deleteDetails")){
		String drug_code	=(String) hash.get("drug_code");
		String srl_no		=(String) hash.get("srl_no");
				
		ArrayList newDrugDoseTimeDetails=new ArrayList();
		newDrugDoseTimeDetails=bean.getnewDrugDetails();
		if(newDrugDoseTimeDetails.size()>0){
			HashMap drugDetails= new HashMap();
			String drugCode    = "";
			String srlNo       = "";
			for(int i=0;i<newDrugDoseTimeDetails.size();i++){
				drugDetails= new HashMap();
				drugDetails= (HashMap) newDrugDoseTimeDetails.get(i);
				drugCode   = (String) drugDetails.get("DRUG_CODE");
				srlNo      = (String) drugDetails.get("SRL_NO");
				if( drug_code.trim().equals(drugCode.trim()) && srl_no.trim().equals(srlNo.trim())){
					drugDetails.put("DRUG_CODE","");
					drugDetails.put("SRL_NO","");
					drugDetails.put("DOSE_QTY","");
					drugDetails.put("QTY_UOM","");
					drugDetails.put("ROUTE_CODE","");
					drugDetails.put("FREQ_CODE","");
					drugDetails.put("ADMIN_DATE_TIME","");
				}
			}
		}
		out.println("refreshnewEntryPage();") ;
	 }
	 else if(func_mode!= null && func_mode.equals("checkForRecords")){
		out.println((bean.getselDrugCodes()).size());
	 }
	 else if(func_mode!= null && func_mode.equals("cancelSelScheduleDateTime")){
		 String sel_schedule_date_time = (String)hash.get("sel_schedule_date_time");
		 bean.cancelSelDrugCodes(sel_schedule_date_time);
	 }
	 else if(func_mode!= null && func_mode.equals("validateAdminDate")){
		String admin_date	=(String) hash.get("admin_date");
		String facility_id	=(String) hash.get("facility_id");		
		String allowable=bean.validateAdminDate(admin_date,facility_id);
		if(allowable!=null && allowable.equals("N")){
			out.println("alertAdminDate();") ;
		}	
	 }
	 else if(func_mode!= null && func_mode.equals("insertDetails")){		
		String non_iv_records		= (String)hash.get("non_iv_records"); 
		String iv_records			= (String)hash.get("iv_records"); 
		String alt_non_iv_records	= (String)hash.get("alt_non_iv_records"); 
		String selDateTime			= (String)hash.get("selDateTime"); 
		ArrayList non_iv_drugs				= new ArrayList();
		ArrayList iv_drugs					= new ArrayList();

		int no_noniv_record=Integer.parseInt(non_iv_records);
		int no_iv_record=Integer.parseInt(iv_records);
		int no_alt_non_iv_record=Integer.parseInt(alt_non_iv_records);

		if(no_noniv_record!=0){
			for(int i=1;i<=no_noniv_record;i++){
				if(hash.get("chk_non_iv_select_"+i) != null && ((String)hash.get("chk_non_iv_select_"+i)).equals("Y") ){
					if(((String)hash.get("non_iv_status_flag_"+i)).equals("YES")){
						if(hash.containsKey("non_iv_drug_code_"+i)){
							non_iv_drugs.add(hash.get("non_iv_drug_code_"+i));		//0		
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_dosage_seq_no_"+i)){ //1
							non_iv_drugs.add(hash.get("non_iv_dosage_seq_no_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_time_"+i)){ //2
							non_iv_drugs.add(hash.get("non_iv_time_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_sch_date_time_"+i)){ //3
							non_iv_drugs.add(hash.get("non_iv_sch_date_time_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						ArrayList remarks = admin_bean.getRemarksForDrug((String)hash.get("non_iv_drug_code_"+i),i+"");
						if(remarks==null){
							remarks = new ArrayList();
							remarks.add("");
							remarks.add("");
							remarks.add("");
							remarks.add("");
						}
						if(hash.containsKey("non_iv_chk_"+i)){
							if(((String)hash.get("non_iv_chk_"+i)).equals("E") || ((String)hash.get("non_iv_chk_"+i)).equals("Y")){
								non_iv_drugs.add("Y");		//4		// ADMINISTERED_YN
								non_iv_drugs.add("Y");		//5		// ADMIN_RECORDED_YN
								non_iv_drugs.add((String)remarks.get(1));	//6		// ADMIN_REMARKS
								non_iv_drugs.add("");		//7		// NON_ADMIN_REMARKS
							}
							else{
								non_iv_drugs.add("N");				// ADMINISTERED_YN
								non_iv_drugs.add("Y");				// ADMIN_RECORDED_YN
								non_iv_drugs.add("");				// ADMIN_REMARKS
								non_iv_drugs.add((String)remarks.get(1));			// NON_ADMIN_REMARKS
							}
						}
						if(hash.containsKey("non_iv_admin_qty_"+i)){ //8
							non_iv_drugs.add(hash.get("non_iv_admin_qty_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_batch_id_"+i)){ //9
							non_iv_drugs.add(hash.get("non_iv_batch_id_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}	

						if(hash.containsKey("non_iv_expiry_date_"+i)){ //10
							non_iv_drugs.add(hash.get("non_iv_expiry_date_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_trade_id_"+i)){ //11
							non_iv_drugs.add(hash.get("non_iv_trade_id_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_item_code_"+i)){ //12
							non_iv_drugs.add(hash.get("non_iv_item_code_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_admin_qty_uom_"+i)){	//13						
							String uom = (String)hash.get("non_iv_admin_qty_uom_"+i);
							if(uom.length()>4){
								uom=uom.substring(0,3);
							}
							non_iv_drugs.add(uom);								
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_order_id_"+i)){ //14
							non_iv_drugs.add(hash.get("non_iv_order_id_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("non_iv_order_line_no_"+i)){ //15
							non_iv_drugs.add(hash.get("non_iv_order_line_no_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						
						non_iv_drugs.add((String)remarks.get(0));		//16	// REASON_CODE	
						non_iv_drugs.add((String)remarks.get(2));		//17	// ADMIN_BY	
						non_iv_drugs.add((String)remarks.get(3));		//18	// AUTHORISED_BY	

						if(hash.containsKey("non_iv_store_code_"+i)){ //19
							non_iv_drugs.add(hash.get("non_iv_store_code_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						
						if(hash.containsKey("non_iv_bin_code_"+i)){ //20
							non_iv_drugs.add(hash.get("non_iv_bin_code_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}

						if(hash.containsKey("non_iv_trade_name_"+i)){ //21
							non_iv_drugs.add(hash.get("non_iv_trade_name_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}

						if(hash.containsKey("non_iv_end_date_"+i)){ //22
							non_iv_drugs.add(hash.get("non_iv_end_date_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						//code added for inserting batch_id in ph_medn_admin_dtl

						if(hash.containsKey("previous_non_iv_batch_id_"+i)){ //23
							non_iv_drugs.add(hash.get("previous_non_iv_batch_id_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}	

						if(hash.containsKey("previous_non_iv_exp_date_"+i)){ //24
							non_iv_drugs.add(hash.get("previous_non_iv_exp_date_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}	

						if(hash.containsKey("previous_non_iv_trade_id_"+i)){ //25
							non_iv_drugs.add(hash.get("previous_non_iv_trade_id_"+i));				
						}
						else{
							non_iv_drugs.add("");				
						}
						if(hash.containsKey("Newly_administerderd_"+i)){ //26
							non_iv_drugs.add(hash.get("Newly_administerderd_"+i));				
						}
						else{
							non_iv_drugs.add("");
						}	
						// added by abdul for new CRF on 7/3/09
						if(hash.containsKey("non_iv_sliding_scale_"+i)){
							non_iv_drugs.add(hash.get("non_iv_sliding_scale_"+i));			//27
							if(((String)hash.get("non_iv_sliding_scale_"+i)).equals("Y")){
								if(hash.containsKey("non_iv_admin_qty_"+i))
									non_iv_drugs.add(hash.get("non_iv_admin_qty_"+i));			//28
								else
									non_iv_drugs.add("");			//28
								if(hash.containsKey("non_iv_admin_qty_uom_"+i))
									non_iv_drugs.add(hash.get("non_iv_admin_qty_uom_"+i));			//29
								else
									non_iv_drugs.add("");			//29
								if(hash.containsKey("non_iv_sliding_range_"+i))
									non_iv_drugs.add(hash.get("non_iv_sliding_range_"+i));			//30
								else
									non_iv_drugs.add("");			//30
								if(hash.containsKey("non_iv_range_uom_"+i))
									non_iv_drugs.add(hash.get("non_iv_range_uom_"+i));			//31
								else
									non_iv_drugs.add("");			//31
							}
							else{									
								non_iv_drugs.add("");			//28
								non_iv_drugs.add("");			//29
								non_iv_drugs.add("");			//30
								non_iv_drugs.add("");			//31
							}
						}
						else{
							non_iv_drugs.add("N");			//27
							non_iv_drugs.add("");			//28
							non_iv_drugs.add("");			//29
							non_iv_drugs.add("");			//30
							non_iv_drugs.add("");			//31
						}	
						if(hash.containsKey("non_iv_admin_qty1_"+i)){
							non_iv_drugs.add(hash.get("non_iv_admin_qty1_"+i));//32				
						}
						else{
							non_iv_drugs.add("");//32				
						}
						if(hash.containsKey("non_iv_admin_qty_uom1_"+i)){
							non_iv_drugs.add(hash.get("non_iv_admin_qty_uom1_"+i));//33				
						}
						else{
							non_iv_drugs.add("");//33			
						}
						if(hash.containsKey("pat_brought_med_"+i)){
							if(hash.get("pat_brought_med_"+i)==null || hash.get("pat_brought_med_"+i)=="")
								non_iv_drugs.add("N");//34
							else
								non_iv_drugs.add(hash.get("pat_brought_med_"+i));//34				
						}
						else{
							non_iv_drugs.add("N");//34			
						}
						non_iv_drugs.add((String)remarks.get(5)); //35
						non_iv_drugs.add((String)remarks.get(6)); //36
						if(hash.containsKey("link_vaccine_code_"+i)){								
								non_iv_drugs.add(hash.get("link_vaccine_code_"+i));//37																	
						}
						else{
							non_iv_drugs.add("");//37				
						}	
						if(hash.containsKey("modified_date_time_"+i)){
							non_iv_drugs.add(hash.get("modified_date_time_"+i));//38
						}
						else{
							non_iv_drugs.add("");//38		
						}
						if(hash.containsKey("non_iv_Auto_Admin_"+i)){
							non_iv_drugs.add(hash.get("non_iv_Auto_Admin_"+i));//39
						}
						else{
							non_iv_drugs.add("");//39
						}
						if(hash.containsKey("order_pract_id_"+i)){
							non_iv_drugs.add(hash.get("order_pract_id_"+i));//40
						}
						else{
							non_iv_drugs.add("");//40
						}
						if(hash.containsKey("adminByType")){
							non_iv_drugs.add(hash.get("adminByType"));//41
						}
						else{
							non_iv_drugs.add("U");//41
						}
						if(hash.containsKey("selfAdminBy")){
							non_iv_drugs.add(hash.get("selfAdminBy"));//42
						}
						else{
							non_iv_drugs.add("");//42
						}
					}
				}
			}
			bean.setselDrugCodes(selDateTime);
			bean.setNONIVDrugDetails(non_iv_drugs,selDateTime);
		}

		HashMap alt_drug_details = new HashMap();
		ArrayList alternate_drugs= new ArrayList();
			
		if(no_alt_non_iv_record>0){	
			for (int i=1;i<=no_alt_non_iv_record ;i++ ){
				if(hash.get("chk_alt_non_iv_select_"+i) != null && ((String)hash.get("chk_alt_non_iv_select_"+i)).equals("Y")){

					if(alt_drug_details.containsKey(hash.get("main_drug_code_"+i))){

						if(hash.containsKey("alt_drug_code_"+i)){
							alternate_drugs.add(hash.get("alt_drug_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("main_drug_code_"+i)){
							alternate_drugs.add(hash.get("main_drug_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_dosage_seq_no_"+i)){
							alternate_drugs.add(hash.get("alt_dosage_seq_no_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_item_code_"+i)){
							alternate_drugs.add(hash.get("alt_item_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_order_id_"+i)){
							alternate_drugs.add(hash.get("alt_order_id_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_order_line_no_"+i)){
							alternate_drugs.add(hash.get("alt_order_line_no_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_admin_qty_"+i)){
							alternate_drugs.add(hash.get("alt_admin_qty_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_admin_qty_uom_"+i)){							
							String uom = (String)hash.get("alt_admin_qty_uom_"+i);
							if(uom.length()>4){
								uom=uom.substring(0,3);
							}
							alternate_drugs.add(uom);
	//							alternate_drugs.add(hash.get("alt_admin_qty_uom_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_schedule_date_time_"+i)){					// SCHEDULED DATE/TIME
							alternate_drugs.add(hash.get("alt_schedule_date_time_"+i));			
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_time_"+i)){								// ADMINISTERED DATE/TIME
							alternate_drugs.add(hash.get("alt_time_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
				
						if(hash.containsKey("alt_batch_id_"+i)){
							alternate_drugs.add(hash.get("alt_batch_id_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_expiry_date_"+i)){
							alternate_drugs.add(hash.get("alt_expiry_date_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_trade_id_"+i)){
							alternate_drugs.add(hash.get("alt_trade_id_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						
						ArrayList remarks = admin_bean.getRemarksForDrug((String)hash.get("alt_drug_code_"+i),i+"");
						if(remarks==null){
							remarks = new ArrayList();
							remarks.add("");
							remarks.add("");
							remarks.add("");
							remarks.add("");
						}
						if(hash.containsKey("alt_chk_"+i)){
							if(((String)hash.get("alt_chk_"+i)).equals("E")){
								alternate_drugs.add("Y");				// ADMINISTERED_YN   13
								alternate_drugs.add("Y");				// ADMIN_RECORDED_YN 14
								alternate_drugs.add((String)remarks.get(1));			// ADMIN_REMARKS     15
								alternate_drugs.add("");				// NON_ADMIN_REMARKS 16
							}
							else{
								alternate_drugs.add("N");				// ADMINISTERED_YN
								alternate_drugs.add("Y");				// ADMIN_RECORDED_YN
								alternate_drugs.add("");				// ADMIN_REMARKS
								alternate_drugs.add((String)remarks.get(1));			// NON_ADMIN_REMARKS
							}
						}
						alternate_drugs.add((String)remarks.get(0));				// REASON_CODE	
						alternate_drugs.add((String)remarks.get(2));				// ADMIN_BY	
						alternate_drugs.add((String)remarks.get(3));				// AUTHORISED_BY	
						if(hash.containsKey("alt_store_code_"+i)){
							alternate_drugs.add(hash.get("alt_store_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						
						if(hash.containsKey("alt_bin_code_"+i)){
							alternate_drugs.add(hash.get("alt_bin_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_trade_name_"+i)){
							alternate_drugs.add(hash.get("alt_trade_name_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_end_date_"+i)){
							alternate_drugs.add(hash.get("alt_end_date_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						alt_drug_details.put((String)hash.get("main_drug_code_"+i),alternate_drugs);		
					}
					else{
						alternate_drugs = new ArrayList();
						if(hash.containsKey("alt_drug_code_"+i)){
							alternate_drugs.add(hash.get("alt_drug_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
							
						if(hash.containsKey("main_drug_code_"+i)){
							alternate_drugs.add(hash.get("main_drug_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_dosage_seq_no_"+i)){
							alternate_drugs.add(hash.get("alt_dosage_seq_no_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_item_code_"+i)){
							alternate_drugs.add(hash.get("alt_item_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_order_id_"+i)){
							alternate_drugs.add(hash.get("alt_order_id_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_order_line_no_"+i)){
							alternate_drugs.add(hash.get("alt_order_line_no_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						if(hash.containsKey("alt_admin_qty_"+i)){
							alternate_drugs.add(hash.get("alt_admin_qty_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_admin_qty_uom_"+i)){
							String uom = (String)hash.get("alt_admin_qty_uom_"+i);
							if(uom.length()>4){
								uom=uom.substring(0,3);
							}
							alternate_drugs.add(uom);								
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_schedule_date_time_"+i)){					// SCHEDULED DATE/TIME
							alternate_drugs.add(hash.get("alt_schedule_date_time_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_time_"+i)){								// ADMINISTERED DATE/TIME
							alternate_drugs.add(hash.get("alt_time_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_batch_id_"+i)){
							alternate_drugs.add(hash.get("alt_batch_id_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_expiry_date_"+i)){
							alternate_drugs.add(hash.get("alt_expiry_date_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_trade_id_"+i)){
							alternate_drugs.add(hash.get("alt_trade_id_"+i));				
						}else{
							alternate_drugs.add("");				
						}
						
						ArrayList remarks = admin_bean.getRemarksForDrug((String)hash.get("alt_drug_code_"+i),i+"");
						if(remarks==null){
							remarks = new ArrayList();
							remarks.add("");
							remarks.add("");
							remarks.add("");
							remarks.add("");
						}
						if(hash.containsKey("alt_chk_"+i)){
							if(((String)hash.get("alt_chk_"+i)).equals("E")){
								alternate_drugs.add("Y");				// ADMINISTERED_YN
								alternate_drugs.add("Y");				// ADMIN_RECORDED_YN
								alternate_drugs.add((String)remarks.get(1));			// ADMIN_REMARKS
								alternate_drugs.add("");				// NON_ADMIN_REMARKS
							}
							else{
								alternate_drugs.add("N");				// ADMINISTERED_YN
								alternate_drugs.add("Y");				// ADMIN_RECORDED_YN
								alternate_drugs.add("");				// ADMIN_REMARKS
								alternate_drugs.add((String)remarks.get(1));			// NON_ADMIN_REMARKS
							}
						}
						alternate_drugs.add((String)remarks.get(0));				// REASON_CODE	
						alternate_drugs.add((String)remarks.get(2));				// ADMIN_BY	
						alternate_drugs.add((String)remarks.get(3));				// AUTHORISED_BY	
						if(hash.containsKey("alt_store_code_"+i)){
							alternate_drugs.add(hash.get("alt_store_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}
						
						if(hash.containsKey("alt_bin_code_"+i)){
							alternate_drugs.add(hash.get("alt_bin_code_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_trade_name_"+i)){
							alternate_drugs.add(hash.get("alt_trade_name_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						if(hash.containsKey("alt_end_date_"+i)){
							alternate_drugs.add(hash.get("alt_end_date_"+i));				
						}
						else{
							alternate_drugs.add("");				
						}

						alt_drug_details.put((String)hash.get("main_drug_code_"+i),alternate_drugs);
					}
				}
			}			
			bean.setselDrugCodes(selDateTime);
			bean.setALTDrugDetails(alt_drug_details,selDateTime); 
		}
		boolean prev_record_admin	=	false;
		if(no_iv_record>0){	
			for (int i=1;i<=no_iv_record ;i++ ){
				if(hash.get("chk_iv_select_"+i) != null && ((String)hash.get("chk_iv_select_"+i)).equals("Y")){
					if(hash.containsKey("iv_dosage_seq_no_"+i)){
						iv_drugs.add(hash.get("iv_dosage_seq_no_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_drug_code_"+i)){
						iv_drugs.add(hash.get("iv_drug_code_"+i));				
					}
					else{
						iv_drugs.add("");				
					}

					if(hash.containsKey("iv_item_code_"+i)){
						iv_drugs.add(hash.get("iv_item_code_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_order_id_"+i)){
						iv_drugs.add(hash.get("iv_order_id_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_order_line_no_"+i)){
						iv_drugs.add(hash.get("iv_order_line_no_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_admin_qty_"+i)){
						iv_drugs.add(hash.get("iv_admin_qty_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_infusion_st_time_"+i)){
						iv_drugs.add(hash.get("iv_infusion_st_time_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_flow_rate_"+i)){
						iv_drugs.add(hash.get("iv_flow_rate_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("sch_infusion_vol_str_unit_"+i)){
						iv_drugs.add(hash.get("sch_infusion_vol_str_unit_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("sch_infusion_per_unit_"+i)){
						iv_drugs.add(hash.get("sch_infusion_per_unit_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_infusion_period_"+i)){
						iv_drugs.add(hash.get("iv_infusion_period_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("sch_infusion_period_unit_"+i)){

						String sch_infusion_period_unit = (String)hash.get("sch_infusion_period_unit_"+i);
						if(sch_infusion_period_unit.equals("Hrs")){
							sch_infusion_period_unit = "H";
						}
						else if(sch_infusion_period_unit.equals("Mins")){
							sch_infusion_period_unit = "M";
						}							
						iv_drugs.add(sch_infusion_period_unit);								
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_batch_id_"+i)){
						iv_drugs.add(hash.get("iv_batch_id_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_expiry_date_"+i)){
						iv_drugs.add(hash.get("iv_expiry_date_"+i));				
					}
					else{
						iv_drugs.add("");				
					}

					if(hash.containsKey("iv_trade_id_"+i)){
						iv_drugs.add(hash.get("iv_trade_id_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					ArrayList remarks = admin_bean.getRemarksForDrug((String)hash.get("iv_drug_code_"+i),i+"");
					if(remarks==null){
						remarks = new ArrayList();
						remarks.add("");
						remarks.add("");
						remarks.add("");
						remarks.add("");
					}
					if(hash.containsKey("iv_chk_complete_"+i)){
						if(((String)hash.get("iv_chk_complete_"+i)).equals("E")|| ((String)hash.get("iv_chk_complete_"+i)).equals("Y")){
							iv_drugs.add((String)remarks.get(1));			// ADMIN_REMARKS
							iv_drugs.add("");				// NON_ADMIN_REMARKS
							iv_drugs.add("Y");				// ADMINISTERED_YN
							iv_drugs.add("Y");				// ADMIN_RECORDED_YN	
							prev_record_admin	=	true;
						}
						else{
							iv_drugs.add("");				// ADMIN_REMARKS
							iv_drugs.add((String)remarks.get(1)); // NON_ADMIN_REMARKS
							iv_drugs.add("N");				// ADMINISTERED_YN
							iv_drugs.add("Y");				// ADMIN_RECORDED_YN	
							prev_record_admin	=	false;
						}
					}
					else {
						if(prev_record_admin) {
							iv_drugs.add((String)remarks.get(1));			// ADMIN_REMARKS
							iv_drugs.add("");				// NON_ADMIN_REMARKS
							iv_drugs.add("Y");				// ADMINISTERED_YN
							iv_drugs.add("Y");				// ADMIN_RECORDED_YN	
						}
						else {
							iv_drugs.add("");				// ADMIN_REMARKS
							iv_drugs.add((String)remarks.get(1)); // NON_ADMIN_REMARKS
							iv_drugs.add("N");				// ADMINISTERED_YN
							iv_drugs.add("Y");				// ADMIN_RECORDED_YN	
						}
					}
					if(hash.containsKey("iv_admin_date_time_"+i)){
						iv_drugs.add(hash.get("iv_admin_date_time_"+i));
					}
					else{
						iv_drugs.add("");
					}
					if(hash.containsKey("iv_qty_uom_"+i)){
						iv_drugs.add(hash.get("iv_qty_uom_"+i));
					}
					else{
						iv_drugs.add("");
					}
					iv_drugs.add((String)remarks.get(0));				// REASON_CODE	
					iv_drugs.add((String)remarks.get(2));				// ADMIN_BY	
					iv_drugs.add((String)remarks.get(3));				// AUTHORISED_BY
					if(hash.containsKey("iv_store_code_"+i)){
						iv_drugs.add(hash.get("iv_store_code_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_bin_code_"+i)){
						iv_drugs.add(hash.get("iv_bin_code_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_trade_name_"+i)){
						iv_drugs.add(hash.get("iv_trade_name_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("iv_end_date_"+i)){
						iv_drugs.add(hash.get("iv_end_date_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					//code added for inserting batch_id in ph_medn_admin_dtl
					if(hash.containsKey("previous_batch_id_"+i)){
						iv_drugs.add(hash.get("previous_batch_id_"+i));				
					}
					else{
						iv_drugs.add("");				
					}
					if(hash.containsKey("IV_Newly_administerderd_"+i)){
						iv_drugs.add(hash.get("IV_Newly_administerderd_"+i));				
					}
					else{
						iv_drugs.add("");
					}
					iv_drugs.add("");
					iv_drugs.add("");
					iv_drugs.add("");
				}
			}
			bean.setselDrugCodes(selDateTime);
			bean.setIVDrugDetails(iv_drugs,selDateTime); 
		}
		if(non_iv_drugs.size() == 0 && iv_drugs.size() == 0 && alt_drug_details.size()== 0){
			bean.clearDrugDetails();
		}
		ArrayList disp_dtls = admin_bean.formDispensingDetails1(non_iv_drugs,iv_drugs,alt_drug_details);
		bean.setDispDtls(disp_dtls);
	 }
	 else if(func_mode!= null && func_mode.equals("insertDetailsSCH")){		
		String order_id = request.getParameter("order_id");
		String srl_no = request.getParameter("srl_no");
		String actionTime = request.getParameter("actionTime");
		String actionBy = request.getParameter("actionBy");
		String actionRemarks = request.getParameter("actionRemarks");
		String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String sfr_status = request.getParameter("sfr_status");
		String iv_sch_admin_date_time = (String)hash.get("iv_sch_admin_date_time");
		String iv_flow_rate = (String)hash.get("iv_flow_rate");
		/*HashMap sfrlogdtls=new HashMap(); commented for AAKH-SCF-0152
		sfrlogdtls.put("order_id",order_id);
		sfrlogdtls.put("srl_no",srl_no);
		sfrlogdtls.put("actionTime",actionTime);
		sfrlogdtls.put("actionBy",actionBy);
		sfrlogdtls.put("actionRemarks",actionRemarks);
		sfrlogdtls.put("mfr_status",sfr_status);
		sfrlogdtls.put("iv_sch_admin_date_time",iv_sch_admin_date_time);
		sfrlogdtls.put("iv_flow_rate",iv_flow_rate);
		admin_bean.addMFRAudigLogList(sfrlogdtls);	
		admin_bean.insertMFRAuditLog();				
		admin_bean.clearMFRAudigLogList();*/
		if(!sfr_status.equals("AD")){
			HashMap hmResult =admin_bean.insertSFRAdminDetailsSCH(hash);
			if((Boolean)hmResult.get("result")){//if block added for AAKH-SCF-0152 above blocked code move inside if.
				HashMap sfrlogdtls=new HashMap();
				sfrlogdtls.put("order_id",order_id);
				sfrlogdtls.put("srl_no",srl_no);
				sfrlogdtls.put("actionTime",actionTime);
				sfrlogdtls.put("actionBy",actionBy);
				sfrlogdtls.put("actionRemarks",actionRemarks);
				sfrlogdtls.put("mfr_status",sfr_status);
				sfrlogdtls.put("iv_sch_admin_date_time",iv_sch_admin_date_time);
				sfrlogdtls.put("iv_flow_rate",iv_flow_rate);
				admin_bean.addMFRAudigLogList(sfrlogdtls);	
				admin_bean.insertMFRAuditLog();				
				admin_bean.clearMFRAudigLogList();
			}
		}
	}
	else if(func_mode!= null && func_mode.equals("chkDuplicate")){
		String selDateTime	=(String) hash.get("selDateTime");
		ArrayList selDrugCodes=new ArrayList();
		selDrugCodes=bean.getselDrugCodes();
		if(selDrugCodes.size()>0){
			String selDate_Time = "";
			for(int i=0;i<selDrugCodes.size();i++){
				selDate_Time=(String) selDrugCodes.get(i);
				if( selDate_Time.trim().equals(selDateTime.trim()) ){
					out.println("alertDuplicate();") ;
					break;
				}
			}
		}				
	 }
	 else if(func_mode!= null && func_mode.equals("validateDateTime")){
			String obj_name			= (String) hash.get("obj_name");
			String from_time		= (String) hash.get("from_time");
			String to_time			= (String) hash.get("to_time");
			String admin_from_date	= (String) hash.get("admin_from_date");
			String admin_to_date	= (String) hash.get("admin_to_date");

			if(obj_name!=null && obj_name.equals("from_time")){
				if(!bean.validateDateAgainstAdminDate(from_time,admin_from_date,admin_to_date)){
					out.println("showAlert('"+obj_name+"','PH_FROM_TIME_RANGE_ALERT')");
					return;
				}else if(!bean.compareDates(from_time,to_time)){
					out.println("showAlert('"+obj_name+"','PH_FROM_TIME_ALERT')");
					return;
				}
				
			}else if(obj_name!=null && obj_name.equals("to_time")){
				if(!bean.validateDateAgainstAdminDate(to_time,admin_from_date,admin_to_date)){
					out.println("showAlert('"+obj_name+"','PH_TO_TIME_RANGE_ALERT')");
					return;
				}else if(!bean.compareDates(from_time,to_time)){
					out.println("showAlert('"+obj_name+"','PH_TO_TIME_ALERT')");
					return;
				}
			}
	 }
	 else if(func_mode!= null && func_mode.equals("clearBean")){
		bean.clear();
		admin_bean.clear();
	 }
	 else if(func_mode!= null && func_mode.equals("getFormCode")){
		 String drug_code=(String) hash.get("drug_code");
		 String form_code=bean.getFormCode(drug_code);
		 HashMap RouteDetails=(HashMap)bean.populateRoute(form_code);
		 ArrayList route_code=new ArrayList();
		 ArrayList route_desc=new ArrayList();
		 if(RouteDetails.size()>0){
			out.println("clearRoute()");
			route_code=(ArrayList)RouteDetails.get("route_code");
			route_desc=(ArrayList)RouteDetails.get("route_desc");
			for(int i=0;i<route_code.size();i++){	
				out.println("populateRoute('"+(String)route_code.get(i)+"','"+(String)route_desc.get(i)+"')");		
			}
		 }	
		Hashtable QtyDescDetails= (Hashtable)bean.loadQtyDetails(form_code);
		Enumeration keys_des	= QtyDescDetails.keys();
		String	uom_code	    = "";
		String	uom_desc	    = "";
		out.println("clearQtyDescList()");
		while(keys_des.hasMoreElements()){
			uom_code	= (String)keys_des.nextElement();
			uom_desc	= (String)QtyDescDetails.get(uom_code);
			if(!uom_code.trim().equals("dflt_code")){
				out.println("addQtyDescList(\""+uom_code+"\",\""+uom_desc+"\")");
			}else{
				out.println("setdfltQtyUom(\""+uom_code+"\",\""+uom_desc+"\")");
			}
		}
	}
	else if(func_mode!= null && func_mode.equals("recordADRDtl")){
		String scheduled_date	= (String) hash.get("scheduled_date");
		String reason_code		= (String) hash.get("reason_code");
		String record_date		= (String) hash.get("record_date");
		String remarks			= (String) hash.get("remarks");
		String administered_by	= (String) hash.get("administered_by");
		String drug				= (String) hash.get("drug");
		String order_id			= (String) hash.get("order_id");
		String encounter_id		= (String) hash.get("encounter_id");
		String callFrom		= hash.get("callFrom") == null?"":(String) hash.get("callFrom");
		String scheKey		= hash.get("scheKey") == null?"":(String) hash.get("scheKey");
		if(remarks!=null && !(remarks.equals("")))
			remarks=java.net.URLDecoder.decode(remarks,"UTF-8");
		ArrayList values = new ArrayList();
		values.add(scheduled_date);
		values.add(reason_code);
		values.add(record_date);
		values.add(remarks);
		values.add(administered_by);
		bean.clearADRDetails(drug+"-"+scheduled_date);
		bean.setADRDetails(drug+"-"+scheduled_date,values);
		bean.setADRReason(order_id,encounter_id,drug,scheduled_date,values);
		admin_bean.clearADRDetails(drug+"-"+scheduled_date);
		admin_bean.setADRDetails(drug+"-"+scheduled_date,values);
		admin_bean.setADRReason(order_id,encounter_id,drug,scheduled_date,values);
		if(callFrom.equals("SCH")){
			bean.setEncounterId(encounter_id);
			HashMap resultMap = bean.updatePostAdminDetails();
			/*if(resultMap!=null && resultMap.containsKey("result")){
				if((Boolean)resultMap.get("result"))
					out.println("dispPostAdminRecordIcon('"+scheKey+"');");
			}*/
		}
	}
	else if(func_mode!=null && func_mode.equals("recordCancelADRDtl")){
		String drug				= (String) hash.get("drug");
		String scheduled_date			= (String) hash.get("scheduled_date");
		admin_bean.clearADRDetails(drug+"-"+scheduled_date);

	}
	else if(func_mode!=null && func_mode.equals("getAdrRemarks")){
		String reason_code				= (String) hash.get("reason_code");
		String appl_trn_type			= (String) hash.get("appl_trn_type");
		String remarks = admin_bean.checkForNull(admin_bean.getAdrRemarks(reason_code,appl_trn_type));
		remarks=remarks.replaceAll(" ","%20");//added for SKR-SCF-0208 -IN029298 -start
		remarks = java.net.URLEncoder.encode(remarks,"UTF-8" );
		remarks=remarks.replaceAll("%2520","%20"); //added for SKR-SCF-0208 -IN029298 -End
		out.println("setRemarks(\""+remarks+"\")");
	}
	else if(func_mode!=null && func_mode.equals("getAdminRemarks")){
		String reason_code				= (String) hash.get("reason_code");
		String appl_trn_type			= (String) hash.get("appl_trn_type");
		String remarks = admin_bean.checkForNull(admin_bean.getAdrRemarks(reason_code,appl_trn_type));
		remarks=remarks.replaceAll(" ","%20");//added for SKR-SCF-0208 -IN029298 -start
		remarks = java.net.URLEncoder.encode(remarks,"UTF-8" );
		remarks=remarks.replaceAll("%2520","%20"); //added for SKR-SCF-0208 -IN029298 -End
		out.println("setAdminRemarks(\""+remarks+"\")");
	}
	else if(func_mode!=null && func_mode.equals("getDefaultValues")){
		String drug				= (String) hash.get("drug");
		String scheduled_date	= (String) hash.get("scheduled_date");
		String frmObj			= (String) hash.get("formObj");
		String encounter_id		= (String) hash.get("encounter_id");
		String order_id			= (String) hash.get("order_id");
		ArrayList allreadyExistRecord = admin_bean.allreadyExistRecord(encounter_id,scheduled_date,drug,order_id);
		if(allreadyExistRecord.size() > 0 && allreadyExistRecord.get(0) != null){
			
			out.println("document."+frmObj+".scheduled_date.value=('"+admin_bean.checkForNull((String)allreadyExistRecord.get(0))+"')");
			out.println("document."+frmObj+".scheduled_date.disabled='true'");
			out.println("document."+frmObj+".reason_code.value=('"+admin_bean.checkForNull((String)allreadyExistRecord.get(1))+"')");
			out.println("document."+frmObj+".reason_code.disabled='true'");

			out.println("document."+frmObj+".remarks.value=('"+admin_bean.checkForNull((String)allreadyExistRecord.get(2))+"')");
			out.println("document."+frmObj+".remarks.disabled='true'");	

			out.println("document."+frmObj+".record_date.value=('"+admin_bean.checkForNull((String)allreadyExistRecord.get(3))+"')");
			out.println("document."+frmObj+".record_date.disabled='true'");	
			out.println("document."+frmObj+".administered_by.value=('"+admin_bean.checkForNull((String)allreadyExistRecord.get(4))+"')");
			out.println("document."+frmObj+".administered_by.disabled='true'");
		}
		else{
			HashMap values  = admin_bean.getADRDetails();
			if(values.containsKey(drug+"-"+scheduled_date)){
				ArrayList defaultValues = (ArrayList)values.get(drug+"-"+scheduled_date);
				if(defaultValues.size() > 0){
					out.println("document."+frmObj+".reason_code.value=('"+admin_bean.checkForNull((String)defaultValues.get(1))+"')");
					out.println("document."+frmObj+".remarks.value=('"+admin_bean.checkForNull((String)defaultValues.get(3))+"')");
					out.println("document."+frmObj+".record_date.value=('"+admin_bean.checkForNull((String)defaultValues.get(2))+"')");
					out.println("document."+frmObj+".administered_by.value=('"+admin_bean.checkForNull((String)defaultValues.get(4))+"')");
				}
			}
		}
	}
	else if(func_mode!=null && func_mode.equals("getBedValues")){
		String facility_id	=(String) hash.get("facility_id");
		String nursing_unit_code =(String) hash.get("nursing_unit_code");	

		String bed_no = "";
		ArrayList bedlist=new ArrayList();
		bedlist=bean.getBedNos(nursing_unit_code,facility_id);
		out.println("clear_to_beds();");	
		out.println("clear_from_beds();") ;
		if(bedlist.size() != 0){					
				out.println("add_from_beds('"+(String)bedlist.get(0)+"')");
				out.println("add_to_beds('"+(String)bedlist.get(bedlist.size()-1)+"')");			
		}			 
	}
	else if(func_mode!= null && func_mode.equals("VO")){
		String yes_no = request.getParameter("yes_no");
			if(yes_no.equals("Y"))
				drug_bean.setCalled_from_verbal_order("Y");
			else if(yes_no.equals("N")){
				drug_bean.setCalled_from_verbal_order("N");
				
			}
	}
	else if(func_mode!= null && func_mode.equals("addPRNDose")){
		HashMap hshArgument = new HashMap();
		hshArgument.put("sch_date_current", (String) hash.get("sch_date"));
		hshArgument.put("order_id", (String) hash.get("order_id"));
		hshArgument.put("order_line_no", (String) hash.get("order_line_no"));
		hshArgument.put("dosage_seq_no", (String) hash.get("dosage_seq_no"));
		hshArgument.put("encounter_id", (String) hash.get("encounter_id"));
		hshArgument.put("drug_code", (String) hash.get("drug_code"));
		hshArgument.put("callFrom", (String) hash.get("callFrom"));
		String callFrom =  hash.get("callFrom")==null?"":(String) hash.get("callFrom");
		if(callFrom.equals("Admin") || callFrom.equals("AddPRN")){
			boolean result = admin_bean.insertPRNDetails(hshArgument);
			if(result){
				String encounter_id="",hold_discontinue_yn="",administration_status="",order_type="",adminFromDateTime="",adminToTime="",display_order_by="",route_admin="",admin_route_categ="",from_time="",to_time="";
				encounter_id = (String) hash.get("encounter_id");
				hold_discontinue_yn = (String) hash.get("hold_discontinue_yn");
				administration_status = (String) hash.get("administration_status");
				order_type = (String) hash.get("order_type");
				adminFromDateTime = (String) hash.get("adminFromDateTime");
				adminToTime = (String) hash.get("adminToTime");
				display_order_by = (String) hash.get("display_order_by");
				route_admin = (String) hash.get("route_admin");
				admin_route_categ = (String) hash.get("admin_route_categ");
				from_time = (String) hash.get("from_time");
				to_time = (String) hash.get("to_time");
				
				admin_bean.getDrugDetailsSchLevel(encounter_id,hold_discontinue_yn,administration_status,order_type, adminFromDateTime, adminToTime,display_order_by,route_admin,admin_route_categ,from_time,to_time);
			}
		}
	}
	else if(func_mode.equals("selectBatch")){//else if Added for Bru-HIMS-CRF-399 [IN:043767]
		String st_bean_id	= "StUtilities";
		String st_bean_name  = "eST.Common.StUtilities";
		StUtilities st_bean	= (StUtilities)getBeanObject( st_bean_id, st_bean_name, request );
		st_bean.setLanguageId(locale);
		String frmObj = (String)hash.get("formObj");
		String recCount = (String)hash.get("recCount");
		String order_id = (String)hash.get("order_id");//BRU-CRF-399.1 - start
		String order_line_num = (String)hash.get("order_line_num");
		String alt_drug_code  = (String)hash.get("alt_drug_code");
		String pres_drug_code = (String)hash.get("pres_drug_code");
		String freq_nature	  = (String)hash.get("freq_nature");
		String old_MAR_yn	  = (String)hash.get("old_MAR_yn");
		String qty			  = (String)hash.get("qty");
		//BRU-CRF-399.1 - end
		HashMap params = new HashMap();		
		params.put("ITEM_CODE",st_bean.checkForNull((String) hash.get("drug_code")));
		params.put("STORE_CODE",st_bean.checkForNull((String) hash.get("store_code")));
		params.put("INCLUDE_SUSPENDED","FALSE");
		params.put("INCLUDE_EXPIRED","FALSE");
		params.put("CUT_OFF_DATE","");
		params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
		params.put("ALREADY_USED_QTY","");
		params.put("MIN_EXP_DATE","");
		HashMap stock	  = (HashMap)st_bean.getBatches(params);
		ArrayList stock_det  = (ArrayList)stock.get("BATCH_DATA");
		if(stock_det.size()>0){
			HashMap batch_det =(HashMap)stock_det.get(0);
			String batch_id = st_bean.checkForNull((String)batch_det.get("BATCH_ID"));
			String expiry_date = st_bean.checkForNull((String)batch_det.get("EXPIRY_DATE"));
			String trade_id = st_bean.checkForNull((String)batch_det.get("TRADE_ID"));
			String bin_code = st_bean.checkForNull((String)batch_det.get("BIN_LOCATION_CODE"));
			
			out.println("assignBatch('"+batch_id+"','"+expiry_date+"','"+trade_id+"','"+bin_code+"','"+recCount+"')");
		}
		if(alt_drug_code!=null && !alt_drug_code.equals("")){//BRU-CRF-399.1 - start
			String dosage_dtl = admin_bean.getAltDosageDetails(pres_drug_code,alt_drug_code,order_id,order_line_num);
			String alt_qty = "";
			String strength_per_value_pres_uom = "";
			if(freq_nature.equals("P")){
				strength_per_value_pres_uom = dosage_dtl.split("~")[3];
				alt_qty = new Float(Float.parseFloat(qty)*Float.parseFloat(strength_per_value_pres_uom)*Float.parseFloat(dosage_dtl.split("~")[0])).intValue()+"";
			}
		out.println("assignDosage('"+dosage_dtl.split("~")[0]+"','"+dosage_dtl.split("~")[1]+"','"+dosage_dtl.split("~")[2]+"','"+recCount+"','"+freq_nature+"','"+old_MAR_yn+"','"+alt_qty+"')");
		}//BRU-CRF-399.1 - end
	}
	else if(func_mode.equals("cancelAdminDetails")){//added for jd-crf-0200 start
		String drug_code = (String)hash.get("drug_code");
		String order_id = (String)hash.get("order_id");
		String order_line_num = (String)hash.get("order_line_num");
		String iv_prep_yn = (String)hash.get("iv_prep_yn");
		String sch_date_time  = (String)hash.get("sch_date_time");
		String dosage_seq = (String)hash.get("dosage_seq");
		String administered_qty = (String)hash.get("administered_qty");
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String admin_date_time = (String)hash.get("admin_date_time");
		String admin_by_name = (String)hash.get("admin_by_name");
	    String reasonCode=(String)hash.get("reasonCode");
	    String strength_per_value_pres_uom=(String)hash.get("strength_per_value_pres_uom");
	    
	    if(iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9")){
	    	
	    	admin_bean.cancelAdminstrationForIvRx(drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,dosage_seq,administered_qty,patient_id,encounter_id,admin_date_time,admin_by_name,reasonCode,strength_per_value_pres_uom);
	    	
	    }
	    else
		admin_bean.cancelAdmisteredDetails(drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,dosage_seq,administered_qty,patient_id,encounter_id,admin_date_time,admin_by_name,reasonCode,strength_per_value_pres_uom);
	}//added for jd-crf-0200 end
	
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
	putObjectInBean(drug_search_bean_id,drug_bean,request);

}
catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	e.printStackTrace();
}
%>
