
 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper"  %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String func_mode	= request.getParameter("func_mode");
	if (func_mode == null || func_mode.equals(""))
		return;

	String bean_id		= "ReissueMedBean" ;
	String bean_name	= "ePH.ReissueMedBean";
	ReissueMedBean beanObj	= (ReissueMedBean)getBeanObject(bean_id,bean_name,request );

	if(func_mode.equals("ShowQueryCrieteria")){
		Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash	= (Hashtable)hash.get( "SEARCH" ) ;
		beanObj.setPassword((String) hash.get("password"));
		String homepage		=(String)hash.get("homepage")==null?"":(String)hash.get("homepage");
		String patient_class		=(String)hash.get("Patient_Class")==null?"":(String)hash.get("Patient_Class");
		String disp_locn_code	=(String)hash.get("disp_locn_code")==null?"":(String)hash.get("disp_locn_code");
		beanObj.setPatientClass(patient_class);
		beanObj.setDispLocnCode(disp_locn_code); //added for Bru-HIMS-CRF-073.1 [IN:047222]
		if(!homepage.equals("Y")){ //if condition and else block added for Bru-HIMS-CRF-073.1 [IN:047222]
			String disp_locn_desc		=(String)hash.get("DispLocnDesc")==null?"":(String)hash.get("DispLocnDesc");
			disp_locn_desc = java.net.URLDecoder.decode(disp_locn_desc,"UTF-8");
			if(!beanObj.validateThePassword()){
				out.println("alert(getMessage('PH_INVALID_PASSWORD','PH'))");
				out.println("focusOnPasswordField('Y')");			
			}
			else{
				beanObj.setDispLocnDesc(disp_locn_desc);
				out.println("focusOnPasswordField('N')");
			}
		} //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		else{
			String disp_locn_desc="";
			boolean dispLocnFound = false;
			ArrayList dispLocn = beanObj.getDispLocn(patient_class,(String)session.getAttribute("LOCALE")) ;
			for (int i=0; i<dispLocn.size(); i+=2) {
				if(disp_locn_code.equals((String) dispLocn.get(i))){
					disp_locn_desc =(String) dispLocn.get(i+1) ;
					dispLocnFound = true;
					break;
				}
			}
			if(dispLocnFound){
				beanObj.setDispLocnDesc(disp_locn_desc);
				out.println("retVal ='"+disp_locn_desc+"'");	
			}
			else
				out.println("retVal ='ACCESS_DENIED'");			
		} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
	}
	if(func_mode.equals("getDispNo")) {
		beanObj	= (ReissueMedBean)getBeanObject(bean_id,bean_name,request );
		String disp_no			=	beanObj.getNewDispNo();
		out.println("onSuccess('"+disp_no+"')");
	}
	if(func_mode.equals("PrintReissue")) {		
		ArrayList print_data		=(ArrayList) beanObj.getprint_data();
		Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String language_id          = (String)hash.get("language_id");
		String report_id			=  "";
		String ReportOutput			=  "";
        String order_type           =  "";
		String order_id				=	"";
		String patient_class		= "";	 

		ecis.utils.OnlineReports onlineReports		=	null;
		ecis.utils.OnlineReport report1				=	null;
		//onlineReports 	    = new ecis.utils.OnlineReports(); comented on 4/Aug/2010 for the incident num:23060
		for(int j=0; j<print_data.size();j=j+8){
			patient_class        =(String)print_data.get(j+4);
			order_id				=(String)print_data.get(j+7);
			order_type           = beanObj.getOrdertype(order_id);
			if(order_type.equals("")) {															
				if(patient_class.equals("IP") )
					report_id="PHPRDISLB_AL_IP";
				else if(patient_class.equals("OP"))
					report_id="PHPRDISLB_AL_OP";						
			} 
			else if(order_type.equals("2")) {
				report_id="PHRIVCONT";	//pending....	
			}
			else if(order_type.equals("5")) {
				report_id="PHRIVCONTWOADD";		
			}
			else if(order_type.equals("3")) {
				report_id="PHRIVINTT";		
			}
			else if(order_type.equals("9")) {
				report_id="PHRCYTOLBDEL";		
			}
			else if(order_type.equals("7")) {
				report_id="PHRTPNDISPLBDL";
			}
			onlineReports 	    = new ecis.utils.OnlineReports();
			report1				= new ecis.utils.OnlineReport((String)print_data.get(j+5), "PH",report_id) ;
			report1.addParameter("p_report_id",report_id) ;
			report1.addParameter("p_disp_no",(String)print_data.get(j));
			report1.addParameter("p_srl_no", (String)print_data.get(j+1)) ;
			report1.addParameter("p_user_name", (String)print_data.get(j+6)) ;
			report1.addParameter("p_facility_id",(String)print_data.get(j+5)) ;
			report1.addParameter("p_locn_code",(String)print_data.get(j+2));
			report1.addParameter("p_patient_id",(String)print_data.get(j+3)) ;					
			report1.addParameter("p_patient_class",patient_class);
			report1.addParameter("p_module_id", "PH") ;
			report1.addParameter("p_language_id",language_id) ;
			report1.addParameter("p_order_id",order_id ) ;

			onlineReports.add( report1) ;	
			ReportOutput = onlineReports.execute( request, response );
		}
		if(ReportOutput != null)
			out.println("report1 not null");	

		// objects nullified after usage
		print_data =new ArrayList();
		beanObj.setprint_data(print_data);
		print_data =null;
	}
	if(func_mode.equals("ResultPageDisp")) {
		String dispCode		= request.getParameter("DispCode");
		String DispDate		= request.getParameter("DispDate");
		String DrugCode		= request.getParameter("DrugCode");
		String OrderId			= request.getParameter("OrderId");
		String OrderDate		= request.getParameter("OrderDate");
		String PatientClass	= request.getParameter("PatientClass");
		String OrderLocation	= request.getParameter("OrderLocation");
		String PatientId		= request.getParameter("PatientId");
		beanObj.setDispDetails(dispCode, DispDate, DrugCode,OrderId,OrderDate,PatientClass,OrderLocation,PatientId);
	} 
	else if((func_mode.trim()).equals("StoreData")){
		LinkedHashMap drugs		= new LinkedHashMap();	//Changed to HashMap for Bru-HIMS-CRF-405[IN:044830]  //HashMap changed to LinkedHashMap for [IN:049860]
		HashMap batches	= new HashMap(); //ArrayList changed to HashMap for [IN:049860]
		Hashtable hash	= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash	= (Hashtable)hash.get( "SEARCH" ) ;
		if( beanObj.getDrug() != null)
			drugs = beanObj.getDrug();
		if( beanObj.getBatch() != null)
			batches = beanObj.getBatch();
		
		ArrayList tempdrug = new ArrayList();
		ArrayList tempbatch = new ArrayList();

		String dispNo			= request.getParameter("dispNo")==null?"":request.getParameter("dispNo");
		String reissueReason	= request.getParameter("reissueReason")==null?"":request.getParameter("reissueReason");
		String totqty			= request.getParameter("totqty")==null?"":request.getParameter("totqty");
		String uom				= request.getParameter("uom")==null?"":request.getParameter("uom");;
		String drugCode			= request.getParameter("drugCode")==null?"":request.getParameter("drugCode");;
		String ItemCode			= request.getParameter("ItemCode")==null?"":request.getParameter("ItemCode");;
		String StoreCode		= request.getParameter("StoreCode")==null?"":request.getParameter("StoreCode");
		String OrderID			= request.getParameter("OrderID")==null?"":request.getParameter("OrderID");//Added for Bru-HIMS-CRF-405[IN:044830]
		String OrderLineNo		= request.getParameter("OrderLineNo")==null?"":request.getParameter("OrderLineNo");;
		String DispLocCode		= request.getParameter("DispLocCode")==null?"":request.getParameter("DispLocCode");;
		String unitCost			= request.getParameter("unitCost")==null?"":request.getParameter("unitCost");
		String endDate			= request.getParameter("endDate")==null?"":request.getParameter("endDate");
		String Uom				= request.getParameter("Uom")==null?"":request.getParameter("Uom");;
		String Disp_facility_id				= request.getParameter("Disp_facility_id")==null?"":request.getParameter("Disp_facility_id");;
		String approval_no      = request.getParameter("approval_no")==null?"":request.getParameter("approval_no");//AAKH-CRF-0117
		/*String addflag			= "Y";		//Commented for Bru-HIMS-CRF-405[IN:044830]
		if (!(drugs.isEmpty())){
			for(int k=0; k< drugs.size(); k++){
				if(drugCode.equals((String)((ArrayList)(drugs.get(k))).get(4))&&dispNo.equals((String)((ArrayList)(drugs.get(k))).get(0))){
					addflag = "N";
					((ArrayList)(drugs.get(k))).remove(1);
					((ArrayList)(drugs.get(k))).add(1,reissueReason);
					((ArrayList)(drugs.get(k))).remove(2);
					((ArrayList)(drugs.get(k))).add(2,totqty);
				}
			}
		}
		if(addflag == "Y"){*/
			tempdrug.add(dispNo);
			tempdrug.add(reissueReason);
			tempdrug.add(totqty);
			tempdrug.add(uom);
			tempdrug.add(drugCode);
			tempdrug.add(ItemCode);
			tempdrug.add(StoreCode);
			tempdrug.add(OrderLineNo);
			tempdrug.add(DispLocCode);
			tempdrug.add(Uom);
			tempdrug.add(unitCost);
			tempdrug.add(endDate);
			tempdrug.add(Disp_facility_id);
			tempdrug.add(OrderID);				//Added for Bru-HIMS-CRF-405[IN:044830]
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_cau_instrn1_eng")),"UTF-8"));//14	Added for [IN:052983] start
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_cau_instrn2_eng")),"UTF-8"));
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_spl_instrn1_eng")),"UTF-8"));
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_spl_instrn2_eng")),"UTF-8"));
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_pat_instrn1_eng")),"UTF-8")); //DECODE added for ML-MMOH-SCF-1951
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_cau_instrn1_loc")),"UTF-8"));
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_cau_instrn2_loc")),"UTF-8"));
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_spl_instrn1_loc")),"UTF-8"));
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_spl_instrn2_loc")),"UTF-8"));
			tempdrug.add(java.net.URLDecoder.decode(beanObj.checkForNull((String)hash.get("label_pat_instrn1_loc")),"UTF-8"));//23	Added for [IN:052983] end //DEOCDE added for ML-MMOH-SCF-1951
			System.out.println("200 ReissueMedValidation.jsp tempdrug"+tempdrug);
			beanObj.setApprovalNo(OrderID,OrderLineNo,dispNo,approval_no);//AAKH-CRF-0117
			System.out.println("202 ReissueMedValidation.jsp tempdrug"+tempdrug);
			drugs.put(OrderID+"_"+OrderLineNo+"_"+ItemCode,tempdrug);	//Added for Bru-HIMS-CRF-405[IN:044830] && ItemCode Added for Inc 49860
					System.out.println("202 ReissueMedValidation.jsp tempdrug"+tempdrug);
			String batch_id		= request.getParameter("batchId");
			String expiryDate	= request.getParameter("expiryDate");
			String binLocCode	= request.getParameter("binLocCode");
			String tradeId		= request.getParameter("tradeId");
			String qty			= request.getParameter("qty");
			String batchUom			= request.getParameter("uom"); //Added for HSA-SCF-0221
			System.out.println("200 ReissueMedValidation.jsp batch_id"+batch_id);
			System.out.println("200 ReissueMedValidation.jsp expiryDate"+expiryDate);
			System.out.println("200 ReissueMedValidation.jsp binLocCode"+binLocCode);
			System.out.println("200 ReissueMedValidation.jsp tradeId"+tradeId);
			System.out.println("200 ReissueMedValidation.jsp qty"+qty);
			System.out.println("200 ReissueMedValidation.jsp batchUom"+batchUom);
			tempbatch.add(batch_id.trim());
			tempbatch.add(expiryDate.trim());
			tempbatch.add(binLocCode.trim());
			tempbatch.add(tradeId.trim());
			tempbatch.add(qty);
			tempbatch.add(batchUom); //Added for HSA-SCF-0221
			batches.put(OrderID+"_"+OrderLineNo+"_"+ItemCode,tempbatch);
			System.out.println("200 ReissueMedValidation.jsp batches"+batches);
		//}	//Commented for Bru-HIMS-CRF-405[IN:044830]
		beanObj.setData(drugs,batches);
		beanObj.setInsertRecords(drugCode+"_"+dispNo,"Y");
	}
	else if(func_mode.equals("ClearData")){
		if(beanObj != null){
			beanObj.clearDrugData();
		}
	}
	else if(func_mode.equals("updateRecords")){
		String drug_code = request.getParameter( "drug_code" );	
		String disp_no	 = request.getParameter( "disp_no" );
		String value	 = request.getParameter( "value" );
		String OrderID	 = request.getParameter("OrderID")==null?"":request.getParameter("OrderID");	//Added for Bru-HIMS-CRF-405[IN:044830]
		String OrderLineNo	= request.getParameter("OrderLineNo")==null?"":request.getParameter("OrderLineNo");	//Added for Bru-HIMS-CRF-405[IN:044830]
		String recno		= request.getParameter("recno")==null?"":request.getParameter("recno");	//Added for Bru-HIMS-CRF-405[IN:044830]
		String bl_interface_yn		= request.getParameter("bl_interface_yn")==null?"":request.getParameter("bl_interface_yn");	//Added for Bru-HIMS-CRF-405[IN:044830]
		beanObj.setInsertRecords(drug_code+"_"+disp_no,value);
		if(value.equals("N")){	//Added for Bru-HIMS-CRF-405[IN:044830] start
			LinkedHashMap drugs		= new LinkedHashMap(); //HaspMap changed to LinkedHashMap for [IN:049860]
			HashMap batches	= new HashMap(); //ArrayList changed to HashMap for [IN:049860]
			if( beanObj.getDrug() != null)
				drugs = beanObj.getDrug();
			if( beanObj.getBatch() != null)
				batches = beanObj.getBatch();
			if(drugs!=null && drugs.size()>0)
				drugs.remove(OrderID+"_"+OrderLineNo+"_"+drug_code);//Added drug_code for INC 50896
			if(batches!=null && batches.size()>0)//Added if condition  for INC 50896
				batches.remove(OrderID+"_"+OrderLineNo+"_"+drug_code);
					System.out.println("254 batches"+batches);
			beanObj.setData(drugs,batches);
			System.out.println("256 drugs"+drugs);
			//out.println("document.getElementById('reissueqty_'+recno).innerText='';");
			out.println("document.getElementById('reissueqty_" + recno + "').innerText='';");

			if(bl_interface_yn.equals("Y")){
				//out.println("document.getElementById('gross_charge_amount_display_'+recno).innerText='';");
				//out.println("document.getElementById('groos_pat_payable_display_'+recno).innerText='';");
				//out.println("document.getElementById('nc_exec_'+recno).innerText='';");
				out.println("document.getElementById('gross_charge_amount_display_" + recno + "').innerText='';");
				out.println("document.getElementById('gross_charge_amount_display_" + recno + "').innerText='';");
				out.println("document.getElementById('gross_charge_amount_display_" + recno + "').innerText='';");
			}
			//out.println("document.getElementById('reasons'+recno).selectedIndex=0;");
			out.println("document.getElementById('reasons" + recno + "').selectedIndex=0;");
		}//Added for Bru-HIMS-CRF-405[IN:044830] end
		
	}
	else if(func_mode.equals("CalculateBillDetails")){
		Hashtable hash						=   (Hashtable)XMLobj.parseXMLString( request ) ;
				 hash						=   (Hashtable)hash.get( "SEARCH" ) ;
		String	patientId					=	(String) hash.get("patientId");
		String	encounter_id				=	(String) hash.get("encounter_id");
		String	sysdate						=	(String) hash.get("sysdate");
		String	ItemCode					=	(String) hash.get("ItemCode");
		String	StoreCode					=	(String) hash.get("StoreCode");
		String	totqty						=	(String) hash.get("totqty");
		String	batch_str					=	(String) hash.get("batch_str");
		String	order_id					=	(String) hash.get("order_id");
		String	OrderLineNo					=	(String) hash.get("OrderLineNo");
		String   recno						=	(String) hash.get("recno");
		String   old_gross_charge_amount		=	(String) hash.get("gross_charge_amount");
		String   old_groos_pat_payable		=	(String) hash.get("groos_pat_payable");
		String   old_tot_groos_pat_payable_str	=	(String) hash.get("tot_groos_pat_payable");	 
		String   old_tot_gross_charge_amount_str	=	(String) hash.get("tot_gross_charge_amount");	 
		String   dispNo							=	(String) hash.get("dispNo");//[IN035994] Added new parameter DispNo
		String   dischargeIND			=   (String) hash.get("discharge_ind")==null?"N":(String) hash.get("discharge_ind")	;
		String   Disp_facility_id          = (String) hash.get("Disp_facility_id"); //Disp_facility_id added for FD-BRU-CRF-092
		String   tot_gross_charge_amount_str	=   "";
		String   tot_groos_pat_payable_str	=   "";
		String   gross_charge_amount_str		=   "";
		String   groos_pat_payable_str		=   "";
		String   decimalFormatString			=   "";
		float    tot_gross_charge_amount		=   0;
		float    tot_groos_pat_payable		=   0; 
		if(!old_tot_groos_pat_payable_str.equals("")){
		   tot_gross_charge_amount =Float.parseFloat(old_tot_groos_pat_payable_str);
		}
		if(!old_tot_gross_charge_amount_str.equals("")){
			tot_groos_pat_payable   =Float.parseFloat(old_tot_gross_charge_amount_str);
		}
		float    gross_charge_amount		    =   0;
		float    groos_pat_payable		    =   0; 
          
		if((beanObj.getBillableItemYN (ItemCode)).equals("Y")) { 
			if(encounter_id==null || encounter_id.equals("null")){//[IN035994] checking encounter_id null value.
				encounter_id="";
			}
			HashMap billing_det=(HashMap)beanObj.callItemChargeDtls(patientId,encounter_id,ItemCode,Integer.parseInt(totqty),batch_str,sysdate,StoreCode,order_id,OrderLineNo,dischargeIND,Disp_facility_id,dispNo);	// Disp_facility_id added for FD-BRU-CRF-092 //[IN035994] Added new parameter DispNo
			if(billing_det.get("error_msg").equals("")){

				decimalFormatString=(String)billing_det.get("BL_DECIMAL_FORMAT_STRING");
				DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);

				/*if(!billing_det.get("grosschargeamt").equals("null")){
					 gross_charge_amount= Float.parseFloat((String)billing_det.get("grosschargeamt"));
				}*/  //commented for  ML-BRU-SCF-0368 [IN:034748]
				if(!billing_det.get("netchargeamt").equals("null")){ //if block added ML-BRU-SCF-0368 [IN:034748]
					 gross_charge_amount= Float.parseFloat((String)billing_det.get("netchargeamt"));
				} 
				if(!billing_det.get("patnetamt").equals("null")){
					 groos_pat_payable  = Float.parseFloat(((String)billing_det.get("patnetamt")).trim());
				}

				gross_charge_amount_str       = dfTest.format(gross_charge_amount);
				groos_pat_payable_str         = dfTest.format(groos_pat_payable);

				if(!old_tot_groos_pat_payable_str.equals("")&&!old_tot_gross_charge_amount_str.equals("")&&!old_gross_charge_amount.equals("")&&!old_groos_pat_payable.equals("")){
					tot_gross_charge_amount       = tot_gross_charge_amount-Float.parseFloat(old_gross_charge_amount);
					tot_groos_pat_payable         = tot_groos_pat_payable-Float.parseFloat(old_groos_pat_payable);
				}

				tot_gross_charge_amount       = tot_gross_charge_amount+gross_charge_amount;
				tot_groos_pat_payable         = tot_groos_pat_payable+groos_pat_payable;

				tot_gross_charge_amount_str   = dfTest.format(tot_gross_charge_amount);
				tot_groos_pat_payable_str     = dfTest.format(tot_groos_pat_payable);             
				out.println("DisplayBillingDetails('Y','"+recno+"','"+gross_charge_amount_str+"','"+groos_pat_payable_str+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"','"+billing_det.get("error_msg")+"','"+billing_det.get("excl_incl_ind")+"','"+billing_det.get("approval_reqd_yn")+"','"+billing_det.get("override_allowed_yn")+"','"+order_id+"','"+OrderLineNo+"')");
			}
			else{
                   out.println("DisplayBillingDetails('N','"+recno+"','"+gross_charge_amount_str+"','"+groos_pat_payable_str+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"','"+billing_det.get("error_msg")+"','','','','','')");

			}
		}
	}
	else if(func_mode.equals("GETBLDETAILS")){
		//beanObj.getBLDetails();
        out.println("callbillingwindow('"+beanObj.getBLDetails()+"','"+beanObj.getDispLocnCode()+"')");
	}
	else if(func_mode.equals("onLinePrinting")){
		String bean_id1		= "ReissueMedBean" ;
		String bean_name1	= "ePH.ReissueMedBean";
		ReissueMedBean bean1 = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;	
		String patient_id=request.getParameter("patient_id");
		String flag=request.getParameter("flag");
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport((String)session.getValue( "facility_id" ), "PH", "PHTOKEN") ;
		report2.addParameter("p_module_id", "PH") ;
		report2.addParameter("p_report_id", "PHTOKEN") ;
		report2.addParameter("P_TOKEN_NO", flag) ;
		report2.addParameter("P_TRANS_NAME", "RI") ;
		report2.addParameter("P_FACILITY_ID",(String)session.getValue( "facility_id" )) ;
		report2.addParameter("P_DISP_LOCN_CODE",  bean1.getDispLocnCode()) ;
		report2.addParameter("P_TOKEN_SERIES",bean1.getTokenSeriesCode() ) ;
		report2.addParameter("p_language_id", (String)session.getAttribute("LOCALE")) ;
		report2.addParameter("p_patient_id", patient_id) ;
		onlineReports.add( report2) ;
		onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );			
	}
	else if(func_mode.equals("DISPLOCN")){
		String patientcat = request.getParameter( "patientcat" ) ;
		ArrayList dispLocn =new ArrayList();
		dispLocn=beanObj.getDispLocn(patientcat,(String)session.getAttribute("LOCALE")) ;
		if (dispLocn.size()==0){
			out.println("clearData('document.frmReissueMedLogin.disp_locn');") ;
		}
		String displocation1 = "";

		out.println("addData('',' ---Select---','document.frmReissueMedLogin.disp_locn');");
		for (int i=0; i<dispLocn.size(); i+=2) {
			displocation1 = dispLocn.get(i+1)==null?"":(String) dispLocn.get(i+1);
			displocation1=displocation1.replaceAll(" ","%20");								
			displocation1=java.net.URLEncoder.encode(displocation1,"UTF-8");		
			displocation1=displocation1.replaceAll("%2520","%20");	
			out.println("addData('"+ dispLocn.get(i) + "', '" + displocation1 +"', 'document.frmReissueMedLogin.disp_locn');") ;
		}
	}
	else if(func_mode.equals("updateReason")){ //Code added for IN23375 for updating changed reissue reason after allocating -- 26/08/2010-- priya
		LinkedHashMap drugs		= new LinkedHashMap();//Changed to HashMap for Bru-HIMS-CRF-405[IN:044830]  //HashMap changed to LinkedHashMap for [IN:049860]
		if( beanObj.getDrug() != null)
			drugs = beanObj.getDrug();

		Hashtable hash		=   (Hashtable)XMLobj.parseXMLString( request ) ;
		hash						=   (Hashtable)hash.get( "SEARCH" ) ;	
		String dispNo			=  hash.get("disp_no")==null?"":(String) hash.get("disp_no");
		String reissueReason	=  hash.get("reissue_reason")==null?"":(String) hash.get("reissue_reason");
		String drugCode			= hash.get("drug_code")==null?"":(String) hash.get("drug_code");
		String OrderID			= hash.get("OrderID")==null?"":(String) hash.get("OrderID");//Added for Bru-HIMS-CRF-405[IN:044830]		
		String OrderLineNo		= hash.get("OrderLineNo")==null?"":(String) hash.get("OrderLineNo");//Added for Bru-HIMS-CRF-405[IN:044830]

		if (!(drugs.isEmpty())){
			for(int k=0; k< drugs.size(); k++){
				ArrayList temp = (ArrayList)(drugs.get(OrderID+"_"+OrderLineNo));//Added for Bru-HIMS-CRF-405[IN:044830]
				if(temp!=null && temp.size()>0){//Condition changed for Bru-HIMS-CRF-405[IN:044830]
					temp.remove(1);//Changed as temp for Bru-HIMS-CRF-405[IN:044830]
					temp.add(1,reissueReason);//Changed as temp for Bru-HIMS-CRF-405[IN:044830]			
				}
			}
		}   
	}
	else if(func_mode!= null && func_mode.equals("ApprovalNoForDrug")){ //added for AAKH-CRF-0117 - start
 		Hashtable hash	= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash	= (Hashtable)hash.get( "SEARCH" ) ;
		String approval_no      =    (String) hash.get( "approval_no" );
		String order_id      =    (String) hash.get( "order_id" );
		String order_line_no      =    (String) hash.get( "order_line_num" );
		String disp_no      =    (String) hash.get( "disp_no" );
 		 beanObj.setApprovalNo(order_id,order_line_no,disp_no,approval_no);
 		}
	putObjectInBean(bean_id,beanObj,request); 
%>
