<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
	/*
	 --------------------------------------------------------------------------------------------------------------
	 Date       Edit History      Name        Description
	 --------------------------------------------------------------------------------------------------------------
	 ?             100           ?           	created
	 28/04/2014    IN048703		Nijitha S		GHL-SCF-807
	 --------------------------------------------------------------------------------------------------------------
	 Date       Edit History      Name       Rev.Date   Rev.By    Description
	 --------------------------------------------------------------------------------------------------------------
	 29/08/2014	IN050209		 Chowminya	 					   Unbilled services will be regrouped into a new order
	 28/05/2015	IN052230		Karthi L							Order Management-Missing specimens-Dispatch Slip
	 29/05/2015	IN055673		Karthi L							HSA-CRF-0250_IN052230:Unit Test Issue/02 - When click on reprint from Reprint Dispatch Slip function,
	 06/10/2015		IN055737	Karthi L							IN055737 HSA-CRF-0250.1 - Dispatch Slip
	 02/01/2017		IN061888	Karthi L							To record collection all at 1 go
	 08/07/2020     IN072994          Chandrashekar raju                 Modified for MMS-DM-CRF-0170.1
	 11/05/2022		16601		Ramesh GHL-SCF-807					NMC-JD-SCF-0173
	 -------- -------------------------------------------------------------------------------------------------------
	 */ 
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName = request.getParameter( "localeName" ) ;
	String option_list = request.getParameter("option_list")==null?"":request.getParameter("option_list"); // added for IN052230
//	String practitioner_id = (String)session.getValue("ca_practitioner_id");
//	String facility_id = (String)session.getValue("facility_id");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	SpecimenOrder beanObj = (SpecimenOrder)getBeanObject( bean_id,"eOR.SpecimenOrder" , request ) ;
		beanObj.setLanguageId(localeName);

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
    String locn_type = (String)hash.get("location_type") ;
	if ( validate.equals( "ord_cat" ) ) {
		out.println( "clearList('document') ; " ) ;
		out.println( "clearList1('document') ; " ) ;


		ArrayList OrderTypeData = beanObj.getLocation(locn_type) ;
		String[] record =null;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			out.println( "addLocationList1(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		record =null;
	} else if(validate.equals("prn_ord_cat")) {
		out.println("clearList2('document');");
		locn_type = request.getParameter("location_type");
		ArrayList OrderTypeData = beanObj.getLocation(locn_type);
		for (int i = 0; i <OrderTypeData.size(); i++) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println("addLocationList2(\"" + record[0] + "\",\"" + record[1] + "\"); ");
		}
	} else if(validate.equals("prn_disp_ord_cat")) {
		out.println("clearDispatchList('document');");
		locn_type = request.getParameter("location_type");
		ArrayList OrderTypeData = beanObj.getLocation(locn_type);
		for (int i = 0; i <OrderTypeData.size(); i++) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println("addDispatchLocationList(\"" + record[0] + "\",\"" + record[1] + "\"); ");
		}
	} else if (validate.equals("PRINT_VALUES")) {
	   Hashtable stored_values = beanObj.getStored_values();
	   Hashtable tabDataPrint = beanObj.getTabDataPrint();
	   Hashtable specLabDataPrint = beanObj.getSpecLabDataPrint(); //IN046592
	   OnLinePrinting online_print = new OnLinePrinting();
	   if (stored_values.size() > 0) 
		{
		   online_print.callSpecimenOnLinePrint(stored_values,request,response); // Pass the Hash Table
	   }
	   if (tabDataPrint.size() > 0) 
		{
		   online_print.callSpecimenCollectOnLinePrint(tabDataPrint,request,response);
	   }
		//IN046592 Start.
		//16601  added below line option_list validate
		if (specLabDataPrint.size() > 0 && ( "N".equals(option_list) || "R".equals(option_list))) 
		{
		   online_print.callSpecimenOnLinePrintReport(specLabDataPrint,request,response);
	   }
	   //IN046592 End.
	 //Clear the bean values set for printing
	 	beanObj.clearPrintingValues();//IN047220
	}
	else if (validate.equals("GET_SEPECIMEN_VALUES")) {
	   
		Hashtable specLabDataPrint = beanObj.getSpecLabDataPrint();    
		int int_total_records=Integer.parseInt((String)specLabDataPrint.get("total_recs"));
		StringBuffer specimenValues=new StringBuffer();
		if (int_total_records > 0 && ( "N".equals(option_list) || "R".equals(option_list))) 
		{			
			for(int i=0;i<int_total_records;i++){
				if(i!=0)
					specimenValues.append("|");
				specimenValues.append((String)specLabDataPrint.get("specimen_no"+i));
			}
		}
		System.out.println("============>"+specimenValues.toString());
		out.println(specimenValues.toString());
	}
	else if (validate.equals("PRINT_DISPATCH_SLIP")) {
	   String period_from			= (String)hash.get("period_from");
	   String period_to				= (String)hash.get("period_to");
   	   String print_locn_type		= (String)hash.get("print_locn_type");
   	   String print_locn			= (String)hash.get("print_locn");

	   String patient_id			= (String)hash.get("patient_id");
	   String location_type			= (String)hash.get("location_type");
	   String locn					= (String)hash.get("locn");
	   String locn1					= (String)hash.get("locn1");
	   String priority				= (String)hash.get("priority");
	   String facility_id			= (String)hash.get("facility_id");
	   String ordered_location		= (String)hash.get("ordered_location");
	   int print_sequ = 0;
	   String print_sequ_str = "";

  	   //IN052230 - Start
	   if(option_list.equalsIgnoreCase("S")) {
		   print_sequ = beanObj.insertReprintDispSlipRecords();
		   print_sequ_str = String.valueOf(print_sequ);
	   }
	   // IN052230 - End
  
      HashMap tabDataPrint			= new HashMap();
	   tabDataPrint.put("period_from",period_from);
   	   tabDataPrint.put("period_to",period_to);
   	   tabDataPrint.put("print_locn_type",print_locn_type);
       tabDataPrint.put("print_locn",print_locn);

	   tabDataPrint.put("patient_id",patient_id);
   	   tabDataPrint.put("location_type",location_type);
   	   tabDataPrint.put("locn",locn);
       tabDataPrint.put("locn1",locn1);
	   tabDataPrint.put("priority",priority);
   	   tabDataPrint.put("facility_id",facility_id);
   	   tabDataPrint.put("ordered_location",ordered_location);
   	   tabDataPrint.put("print_sequ",print_sequ_str); // IN052230
 	   OnLinePrinting online_print	= new OnLinePrinting();
	   if (tabDataPrint.size() > 0) {
	       online_print.callSpecimenDispatchSlipOnLinePrint(tabDataPrint, request, response);
	   }
	}else if(validate.equals("POPULATE_LOCATION_ORDER")){
		out.println("clearOrderList('document');");
		String facility_id = (String)hash.get("facility_id");
		String location_order = (String)hash.get("location_order") ;
		ArrayList OrderLocationData = beanObj.getLocationOrder(location_order,facility_id);
		String[] record = null;
		for (int i = 0; i <OrderLocationData.size(); i++) {
			record = (String[])OrderLocationData.get(i);
			out.println("addOrderList(\"" + record[0] + "\",\"" + record[1] + "\"); ");
		}
	}
	else if(validate.equals("UPDATE_PERF_LOCN"))
	{
		String l_operation = request.getParameter("p_operation")==null?"":request.getParameter("p_operation");
		String l_order_id = request.getParameter("p_order_id")==null?"":request.getParameter("p_order_id");
		String l_catalog_code = request.getParameter("p_catalog_code")==null?"":request.getParameter("p_catalog_code");
		String l_catalog_desc = request.getParameter("p_catalog_desc")==null?"":request.getParameter("p_catalog_desc");
		String l_order_type_code = request.getParameter("p_order_type_code")==null?"":request.getParameter("p_order_type_code");
		
		if(l_operation.equals("ADD"))
		{
			ArrayList orderDetails = new ArrayList();
			orderDetails.add(l_order_id);
			orderDetails.add(l_catalog_code);
			orderDetails.add(l_catalog_desc);
			orderDetails.add(l_order_type_code);
			beanObj.addSelectedLocnRecord(l_order_id,orderDetails);
		}
		else if(l_operation.equals("REMOVE"))
		{	
			beanObj.removeSelectedLocnRecord(l_order_id);
		}
	}
	else if(validate.equals("CHANGE_PERFORM_LOCN"))
	{
		String l_performing_facility = (String)hash.get("p_performing_facility") ;
		out.println( "clearChangePerformLocnList('document') ; " ) ;
		ArrayList performingLocn = new ArrayList();
		performingLocn = beanObj.getPerformingLocationDetails(l_performing_facility);

		for( int i=0 ; i< performingLocn.size() ; i++ ) 
		{
			String[] record = (String[])performingLocn.get(i);
			out.println( "addChangePerformLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}//IN048703 Starts
	else if(validate.equals("UPDATE_PERIOD"))
	{
		ArrayList behindDetails = beanObj.getSpecimenBehindDetails();
		String behind_date = "";
		String ahead_date  = "";
		//IN052230 - Start
		//HashMap dispatchMap = beanObj.getPatientDispSlipSelected();
		beanObj.removeAllPatientDispSlipSelected();
		//IN052230 - End
		if (behindDetails.size() > 0) 
		{
			if (behindDetails.get(0) != null)
				behind_date = (String) behindDetails.get(0);
			if (behindDetails.get(1) != null)
				ahead_date  = (String) behindDetails.get(1);
			
			
			if (behind_date.equals(" ") || behind_date.equals("null")) behind_date=""; 
			if (ahead_date.equals(" ") || ahead_date.equals("null")) ahead_date=""; 
			if(!localeName.equals("en")){
			behind_date =  com.ehis.util.DateUtils.convertDate(behind_date,"DMYHM","en",localeName);
			ahead_date =  com.ehis.util.DateUtils.convertDate(ahead_date,"DMYHM","en",localeName);
			}
			out.println("setPeriodValues('"+behind_date+"','"+ahead_date+"');");
		}
	}//IN048703 Ends //IN049737 - Start
	else if(validate.equals("CHECK_BILLSETTLEMENT"))
	{
		String order_id = (String)hash.get("order_id");
		String ordering_facility = (String)hash.get("ordering_facility");
		String patient_class = (String)hash.get("patient_class");
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String rec_num = (String)hash.get("rec_num");
		String check_bill = beanObj.getFunctiondtl();
		if("Y".equals(check_bill))
		{	
			ArrayList BillDetails = beanObj.getBillSettlementYN(ordering_facility, order_id);
			String message = "";	
			String details = "";
			if (BillDetails.size() > 0) 
			{
				for( int i=0 ; i< BillDetails.size() ; i++ ) 
				{	
					String[] record = (String[])BillDetails.get(i);	
					message = record[0];
					details = record[1];
				}
				out.println("settlementPendingMsg(\""+message+ "\",\""+details+"\",\""+patient_id+"\",\""+encounter_id+"\",\""+ordering_facility+"\",\""+rec_num+"\");");
			}
		}
	}//IN049737 - End
	//IN052230 - Start
 	else if(validate.equals("PRINT_DISPSLIP_SELECTED")){
		StringBuilder rdsBuilder = new StringBuilder(); // IN055673
		String rdsString = ""; // IN055673
 		String l_operation 		= request.getParameter("p_operation")==null?"":request.getParameter("p_operation");
 		String l_patient_id 	= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
 		String l_specimen_no	= request.getParameter("p_specimen_num")==null?"":request.getParameter("p_specimen_num");
		String l_order_id		= request.getParameter("p_order_id")==null?"":request.getParameter("p_order_id");
		rdsBuilder.append(l_patient_id+"~"+l_order_id); // IN055673
		rdsString = rdsBuilder.toString(); // IN055673
 		if(l_operation.equals("ADD"))
 		{
 			if(!beanObj.getPatientDispSlipSelected().containsKey(l_specimen_no)) {
 				beanObj.addPatientDispSlipSelected(l_specimen_no, rdsString);
 			}
 		}
		else if(l_operation.equals("ADDALL")) {
			beanObj.removeAllPatientDispSlipSelected();
			beanObj.addPatientDispSlipSelected(beanObj.getClonedPatientDispSlipRecords());
		}
 		else if(l_operation.equals("REMOVE")) 
 		{	
 			beanObj.removePatientDispSlipSelected(l_specimen_no);
 		}
		else if(l_operation.equals("REMOVEALL"))
		{
			beanObj.removeAllPatientDispSlipSelected();
		}
 	}
	else if(validate.equals("UPDATE_MAP_SIZE")){
		HashMap dispatchMap = beanObj.getPatientDispSlipSelected();
		int selectedRecords = 0;
		if(dispatchMap != null){
			selectedRecords = dispatchMap.size();
		}
		out.println("setLatestDispSlipMapSize('"+selectedRecords+"');");
	}
	//IN052230 - End
	//	IN055737 HSA-CRF-0250.1 - Start
	else if(validate.equals("SPECIMEN_BARCODE_SEARCH")) {
		String isSpecimenAdded = "";
		 HashMap cloneMap = null;
		 HashMap dispatchMap = beanObj.getPatientDispSlipSelected();
		 int cloneMapSize = 0;
		 String l_specimen_no	= request.getParameter("p_specimen_num")==null?"":request.getParameter("p_specimen_num");
		 if(l_specimen_no != null && !l_specimen_no.equals("")) {
			 cloneMap = beanObj.getClonedPatientDispSlipRecords();
			 cloneMapSize = cloneMap.size();
				if(cloneMap != null) {
					if(cloneMap.containsKey(l_specimen_no)) {
						if(!dispatchMap.containsKey(l_specimen_no)){ 
							beanObj.addPatientDispSlipSelected(l_specimen_no, (String)cloneMap.get(l_specimen_no));
							isSpecimenAdded = "SPECIMEN_ADDED";
						} else {
							isSpecimenAdded = "SPECIMEN_EXIST";
						}
					} else {
						isSpecimenAdded ="SPECIMEN_NA";
					}
				}
		 }
		 out.println("isBarCodeSpecimenAdded( \"" + isSpecimenAdded + "\",\"" + l_specimen_no + "\",\"" + cloneMapSize + "\") ;"); 
		
	}
	//IN055737 HSA-CRF-0250.1 - End
	else if(validate.equals("MULTI_CHECK_REC_COL")){
 		String collected_by			= "";
 		String retunValue = "";
		collected_by	=	request.getParameter("collected_by");
		String login_user = (String)session.getAttribute("login_user");
		if (login_user == null) {
		   login_user = "";
		}
		String curr_sys_date 		= "";
		if(curr_sys_date==null)
			curr_sys_date 			= "";
		ArrayList sysdate = (ArrayList)beanObj.getSysDateTime();
		if (sysdate.size() == 3)
			curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();

		if (curr_sys_date.equals("null")|| curr_sys_date=="")curr_sys_date="";

		if ( !localeName.equals("en") )
		{ 
			curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);
		}
		if(collected_by == null || collected_by.equalsIgnoreCase("")){
			collected_by = login_user;
		}
		retunValue = collected_by + "," + curr_sys_date;
		out.println("'"+retunValue+"'");
	}
	else if(validate.equals("BARCODE_SCANCOUNT")){//Added forIN072994
		String patient_id = (String)hash.get("patient_id");
		String barcode_scaned_yn =(String)hash.get("barcode_scaned_yn");
		String option =(String)hash.get("option");
		String pat_class_enc_list = (String)hash.get("patClassEncList");
		String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="",encounter_id="",patient_class="";
		String entry_type ="";
		 if(barcode_scaned_yn.equals("Y"))
			 entry_type ="S";
		 else 
			 entry_type ="M";


			ArrayList scanCountSetup =beanObj.getScanCountReqForPatientClass(pat_class_enc_list);
			if(scanCountSetup.size()>0){
			
				scan_count_required_yn = (String)scanCountSetup.get(0);
				alert_required_yn      = (String)scanCountSetup.get(1);
				remarks_required_yn    = (String)scanCountSetup.get(2);
				encounter_id           = (String)scanCountSetup.get(3);
				patient_class          = (String)scanCountSetup.get(4);
			}
			if(scan_count_required_yn.equals("Y")){
				if(barcode_scaned_yn.equals("N") && alert_required_yn.equals("Y")){
				     out.println("callManualScanRemarks( \"" + patient_id + "\",\"" + encounter_id + "\",\"" + patient_class + "\",\"" + remarks_required_yn + "\",\"" + option + "\") ;"); 

				}else{
					out.println("scanBarcodeCount( \"" + patient_id + "\",\"" + encounter_id + "\",\"" + patient_class + "\",\"" + entry_type + "\",\"" + option + "\") ;"); 
				}//changed  callManualScanRemarks for testing issue raised by MMS
			}
	}   //Adding end forIN072994
	putObjectInBean(bean_id,beanObj,request);
%>
