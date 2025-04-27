<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date 		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
03/02/2017		IN061410		Chithra		01/02/2017	Manickkam 		TTM-SCF-0171
15/09/2020		IN:073832	        Manickavasagam J			     SKR-SCF-1421
24/12/2020		11726		        Manickavasagam J			     SKR-SCF-1534
31/12/2020      	10309         		Sai Teja P   			31/12/2020  Manickavasagam J    ML-MMOH-SCF-1674  
31/1/2021		6771		        Manickavasagam J			     SKR-SCF-1429
22/02/2021		9596		        Manickavasagam J			     ML-MMOH-SCF-1674
26/04/2021		16605		        Manickavasagam J			     ML-MMOH-SCF-1767
29/12/2021		TFS-26100           Prabha							 MMS-MD-SCF-0179
26/04/2022                  Chandrashekar raju A                    ML-MMOH-SCF-1964
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,java.lang.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- java.sql.*,webbeans.eCommon.* Added for AAKH-CRF-0084 [IN060429] -->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html> 
<%
System.out.println("==============in==========>MARSchLevelDrugAdmin.jsp");
     Connection con			= null; // Added for AAKH-CRF-0084 [IN060429] - start
     con				= ConnectionManager.getConnection(request);
     boolean verify_adm_drug = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","VERIFY_ADM_DRUG");// Added for AAKH-CRF-0084 [IN060429] - End
	
	try{
 		request.setCharacterEncoding("UTF-8");
 		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
 		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
 		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
 		//ends
 		
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_id			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String mode				        =	 request.getParameter("mode");	
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String order_id			=	 request.getParameter("order_id");
		String order_line_num			= request.getParameter("order_line_num")==null?"0":request.getParameter("order_line_num");
		String shedule_date_time			= request.getParameter("p_start_date_time");
		String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String drugCode			= request.getParameter("p_ord_drug_code")==null?"":request.getParameter("p_ord_drug_code");
		String recCount			= request.getParameter("recCount")==null?"0":request.getParameter("recCount");
		String adminOption			= request.getParameter("adminOption")==null?"AD":request.getParameter("adminOption");
		String userAuthPINYN=request.getParameter("userAuthPINYN")==null?"":request.getParameter("userAuthPINYN");
		String callFrom=request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String hold_discontinue_yn=request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String admin_from_date=request.getParameter("admin_from_date")==null?"":request.getParameter("admin_from_date");
		String admin_to_date=request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
		String admin_discontinue=request.getParameter("admin_discontinue")==null?"":request.getParameter("admin_discontinue");
		String sch_date=request.getParameter("sch_date")==null?"":request.getParameter("sch_date");
		String adminByType = "U", selfAdminBy="", admin_disc_classValue="",dispense_drug_code="",generic_id="",dispensed_drug_desc="",disp_drugs="",alt_drug_display="";
		ArrayList arrAltDrugs = new ArrayList();//Added for Bru-HIMS-CRF-399 [IN:043767]
		String adminOptionDisplay="display:none;";
		String mfr_yn			 = request.getParameter("mfr_yn")==null?"":request.getParameter("mfr_yn");//ML-MMOH-CRF-1014
		String user_id= (String) session.getValue("login_user");
		String future_admin = request.getParameter("future_admin")==null?"":request.getParameter("future_admin"); // Added for GHL-SCF-0482
		String onco_iv_prep_yn = request.getParameter("onco_iv_prep_yn")==null?"":request.getParameter("onco_iv_prep_yn");//MMS-KH-CRF-0017.1
		if(adminOption.equals("SAD")){
			adminOptionDisplay ="display:inline;"; 
			adminByType = "P";
			selfAdminBy = "Patient";
		}
		int iRecCount = Integer.parseInt(recCount);
		recCount = "1";
		float ret_qty=0;
		float returned_qty=0;
		float tot_administered_qty=0;
		float disp_qty=0;
		float ward_return_qty=0;
		String start_date_time="";

		DecimalFormat dfTest = new DecimalFormat("0.########");
%>
<%!
	public String roundDigits(String a){
		try{
			String bb = "";
			if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}
			else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 2){
					bb=a.substring(0,a.indexOf(".")+2);
				}
				else{
					bb=a;
				}
			}
			return bb;
		}
		catch (Exception e){
			return a;
		}
	}
%>		<head>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
			<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
			<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
			<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
			<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
			<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script type="text/javascript" src="../../ePH/js/DrugDetailsDisplay.js"></script>
			<script type="text/javascript" src="../../eCommon/js/dchk.js"></script>
			<script language="Javascript" src="../../ePH/js/PPNRegimen.js"></script>
			<title><fmt:message key="Common.MedicationAdministration.label" bundle="${common_labels}"/></title>
		</head>
		<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name="MedicationAdministrationFTDrugDetails" id="MedicationAdministrationFTDrugDetails" >
<% 
				String selDateTime				=    "";
				String flag						=    "";
						
				if(mode!=null && mode.equals("NOTIME")){
					drugCode					=	request.getParameter("drug_code");
					selDateTime					=	request.getParameter("selDateTime");
				}
				if(function_from.equals("SCH")){
					drugCode					=	request.getParameter("p_ord_drug_code");
					mode						=	"SCH";
				}
				String bean_id_all_stages				= "DispMedicationAllStages" ;
				String bean_name_all_stages				= "ePH.DispMedicationAllStages";
				DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
				bean_all_stages.setLanguageId(locale);
				bean_all_stages.setModuleId("1");
				ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id,patient_id,order_line_num);	
				String bean_id							= "MedicationAdministrationFTBean";
				String bean_name						= "ePH.MedicationAdministrationFTBean";
				MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
				bean.setLanguageId(locale);
				bean.setCurrentTimeAndAdminWithinHRS();
				boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203
	//			isSiteSpecMARPrint = true;
				String drug_search_bean_id				= "DrugSearchBean";
				String drug_search_bean_name			= "ePH.DrugSearchBean";
				DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
				drug_bean.setLanguageId(locale);
				HashMap drug_details					= new HashMap();					
		
				ArrayList result						= bean.getCurrentTimeAndAdminWithinHRS();
				String current_date_time				= (String)result.get(0);
				String AdminBackLogTime					= "";
				AdminBackLogTime					= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));		
				String adminFromDateTime		= bean.getFromDateTime(current_date_time);
			//	String adminToTime	=current_date_time; removed for IN062053
				String adminToTime			= bean.getAdiminWindowToDateTime(current_date_time);	
				String title				   =	"";
				ArrayList admin_drug_details = null;
				String admin_bean_id						=	  "MedicationAdministrationBean";
				String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
				MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
				admin_bean.setLanguageId(locale);
				String allow_mar_alternate_drug_yn = admin_bean.getAllow_auto_disp_alt_drug_mar();//Added for Bru-HIMS-CRF-399 [IN:043767]
				String allowMAR_share_drug = admin_bean.getAllowMARShareDrug();//Added for HSA-CRF-0090[IN041241] -start
				String shared_drug_disp = "";
				if(allowMAR_share_drug==null || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
					shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
				HashMap defaultValues				=	new HashMap();
				String	defaultDate					=	"";
				String  defaultBatch				=	"";
				String	defaultTradeId				=	"";
				String	defaultExpiryDate			=	"";
				String schedule_uom_desc			=   "";
				String schedule_uom_code			=   "";
				int no_of_alt_drus_selected			=   0;	
				String stat_style					=   "";
				String classvalue					=   "";		String store_code	  =	"";
				String drug_class					=   "";		String drug_class_ind = "";
				String  short_desc					=   "";	
				String  drug_code					=   "";
				String  disp_drug_code				=   "";
				String  uom_code					=   "";
				String  drug_desc					=   "";		String  qty			  = "";
				String encode_drug_desc				=   "";
				String ordered_qty					=   "";		String  batch_id	  = ""; 
				String  expiry_date					=   "";		String  tradename	  =	"";	                     
				String  item_code					=   "";		
				ArrayList batch_ids   = new ArrayList(); 
				String sch_date_time				=   "";		String dosage_seq_no  = "";
				String trade_id						=   "";		String dis_continued  = "";
				String hold							=   "";		String administered   = "";
				String admin_recorded_yn			=   "";		String remarks		  =	"";
				String admindrugdetails				=   "";
				String admin_drug_code				=   "";		String admin_drug_desc=	"";
				String Store_locn_code				=	"";
				String Storelocn_code				=	"";
				String iv_incred					=	"";
				String iv_incred1					=	"";
				String iv_incred2					=	"";
				String route_desc					=	"";
				String pres_catg_code				=   "";
				String pres_base_uom				 =  "";		//added for SKR-SCF-0304
				boolean auth_reqd					=   false;
				boolean alt_flag					=   false;
				boolean disp_with_alt				=   false;//BRU-CRF-399.1
				String auth_reqd_script				=	"";
				StringTokenizer stadmindrugdetails	=	null;
				StringTokenizer stiv_incred			=	null;	
				String admin_by_name				=	"";		String auth_by_name					=	"";
				String end_date_time				=	"";		String freq_code					=	"";
				String next_schd_date				=	"";		String AdUOM						=	"";
				String pract_id						=	"";		String against_sch_date				=	"";
				String adr_reason					=	"";		String adr_remarks					=	"";
				String adr_record_time				=	"";		String adr_recorded_by				=	"";
				String img_path						=	"";		String adr_details					=	"";
				String freq_nature					=	"";		String stat_title					=	"";
				String mand_display					=	"";		String drug_remarks					=	"";
				String prn_remarks					=	"";		String slidingscaleremarks	        =   "";
				String pharma_remarks				=	"";		String verificationremarks			=	"";
				String pres_remarks					=	"";		String remarks_style				=	"";	
				String select_status				=	"";		String dtl_style					=	"";	
				String pres_dosage					=	"";		String pres_unit					=	"";	
				String medn_admn_dtl_reqd_yn		=	"";	    String select_status_1				=   "";
				String ext_prod_id					=   "";		String show_remarks					=	"N";
				String imageFileURL					=	"";		String patient_brgt_medn			=	"N";
				String trade_code					=	"";     String sliding_scale_applicable		=   "N";
				String strength_value_prn			=	"";     String sch_strength_value_prn		=	"";
				String sch_strength_uom_prn			=	"";     String sch_strength_uom_desc_prn	=	"";
				String dosage_uom_code				=	"";     String dosage_uom_desc				=	"";
				String dosage_type					=	"";     String dosage						=	"";
				String adminsted_pat_brought_medn	=	"N";    String content_in_pres_base_uom		=	"1";
				String tempDosage					=	"";     String onco_direct_drug_count		=	"1";
				String demostring					=  "\\\'\'";String linkVacScheduleCode			=	"";
				String admn_dose_chng_reason_code   =	"";		String linkVacScheduleDesc			=	"";
				String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
				String performingDeptLocCode		=	"";		String nonMfrFluidRemarks			=	"";
				String strength_per_value_pres_uom = "1";
				String route_color 	=   "";   
				String fntColor                     =   "#OOOOOO";
				String backGrndColor                =   "#FFFFFF"; 
				String order_pract_id 	=   ""; 
				String displayStyle		=	"";
				String statusFlag		=	"YES";
				String addDisplayStyle	=	"";
				String checked			=	"";
				String verbalOrder="", showAlt="", alt_drug="";	
				String administred_batch_id	 =	"";
				String disp_batch_id		 =	"";
				String disp_exp_dt			 =	"";
				String disp_trade_id		 =	"";		
				String admin_dose_prn		 =  "", Auto_Admin="";
				HashMap  administred_batch  = null;
				String linkVacScheduleCode1	="";			
				String[] vacScheduleDetails;
				int adr_count =0;
				float tot_alt_qty       = 0.0f;
				String rangeUOM = "", sl_srl_no="", sl_rg_fro="", sl_rg_to="", sl_adm_qty="", modified_date_time = "", admin_date_time = "",  showTitle="", non_iv_admin_quaty="", temp ="";
				String auto_Admin_dis="", bat_id_lookbutton_enabled="";	
				ArrayList totQty = null;
				ArrayList WardReturnQty = null;
				
				String pin_value=bean.getPinNumber();
//				DecimalFormat dfToInteger = new DecimalFormat("####.##");
				ArrayList work_sheet_batch_det1		=	new ArrayList();
				ArrayList sliding_scale_details		=	new ArrayList();
			/*	int temp1                           =   0;
				int temp2                           =   0;		
				int temp3                           =   0;		
				int inc								=   0; */
				float dialog_height					=	0;
				HashMap overridereason				=	new HashMap();
				int ppn_count						=   0;
//				int tot_records						=   0;		
				int altRecCount						=   0;		//int newRecCount		 = 0;
				int ivRecCount						=   1;
				ArrayList alreadyEnteredValues = null;
				ArrayList hmAdmin_drug_details = null;
				String customer_id = bean.getCustomerID(); //added MMS-DM-SCF-0442
				String patient_class_ord = "";//GHL-CRF-0458

				String mfrRemarks		 = "";
		//added for GHL-CRF-0482 - start
				String patient_stock_yn = "";
				String patient_stock_required = "";
				String patient_stock_completed	= "";
				String patient_stock_checked    = "";
				String patient_stock_disabled	= "";
				String patient_stock_check_display = "";
				HashMap batchIdforOrders = null; //GHL-CRF-0482
				String onco_order_drug_count ="";
				String sch_date_time_drug    = "";
				String split_dose_yn = "N"; //ML-MMOH-SCF-1439
		//added for GHL-CRF-0482 - end
		
				bean.setIvprepYN(iv_prep_yn); //added for MMS-MD-SCF-0179
				
				int tot_rec = 1;
				if(callFrom.equals("adminNONIV")){
					//MMS-KH-CRF-0017.1 - start
					if(onco_iv_prep_yn.equals("9")){
						onco_order_drug_count = request.getParameter("onco_direct_drug_count");

						if(onco_order_drug_count==null || onco_order_drug_count.equals("")){
							onco_order_drug_count = "1";
						}else{
							tot_rec = Integer.parseInt(onco_order_drug_count) ;
						}
					}
					//MMS-KH-CRF-0017.1 - end
					if(mfr_yn.equals("Y")){
						tot_rec=2;
					}
				}
		
				boolean mfrCompletedStatus		=	false;
				if(callFrom.equals("adminNONIV")){
					boolean isSite_spec_patient_stock = bean.isSiteSpecific("PH","PATIENT_STOCK_REQUIRED");//ADDED FOR GHL-CRF-0482
	//				isSite_spec_patient_stock = true;
					drug_details		  =	(HashMap) bean.getDrugDetails();
					String onco_dosage_seq_no = ""; //JD-CRF-0200
					String onco_modified_date_time = "";//JD-CRF-0200
System.err.println("drug_details=====293===>"+drug_details);
					if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
						title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
					else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
						title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
					else
						title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");
					LinkedHashMap	non_iv_drug_details = null;
					if(drug_details!=null){
						non_iv_drug_details				=	 (LinkedHashMap) drug_details.get("NON_IV");
						if(non_iv_drug_details!=null && non_iv_drug_details.containsKey(order_id+"_"+order_line_num)){
							hmAdmin_drug_details = (ArrayList)non_iv_drug_details.get(order_id+"_"+order_line_num);
							admin_drug_details = (ArrayList)hmAdmin_drug_details.get(iRecCount);
						}
					}
					defaultValues						=	admin_bean.getNONIVDrugDetails();
					if (defaultValues.containsKey(selDateTime)){
						try{
							alreadyEnteredValues=(ArrayList)defaultValues.get(selDateTime);
							defaultDate			=	(String)alreadyEnteredValues.get(2)==null?"":(String)alreadyEnteredValues.get(2);
							defaultBatch		=	(String)alreadyEnteredValues.get(9)==null?"":(String)alreadyEnteredValues.get(9);
							defaultExpiryDate	=	(String)alreadyEnteredValues.get(10)==null?"":(String)alreadyEnteredValues.get(10);
							defaultTradeId		=	(String)alreadyEnteredValues.get(11)==null?"":(String)alreadyEnteredValues.get(11);
						}
						catch (Exception e){
							defaultDate			="";
							defaultBatch		="";
							defaultExpiryDate	="";
							defaultTradeId		="";
						}
					} 
					if(admin_drug_details!=null && admin_drug_details.size()>0){
%>
						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="non_iv_administration_table">
							<tr id="non_iv_admin_table_row2">
								<td class="TDSTYLE" width="2%">&nbsp;</td>
								<td class="TDSTYLE"   width="28%"><B><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE"   width="2%">&nbsp;</td>
								<td class="TDSTYLE"   width="2%">&nbsp;</td>
								<td class="TDSTYLE"   width="4%">&nbsp;</td>
								<td class="TDSTYLE"   width="9%"><B><fmt:message key="ePH.AdminDose.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE"   width="9%"><B><fmt:message key="ePH.RouteOfAdministration.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE"   width="12%"><B><fmt:message key="ePH.ScheduledTime.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE"   width="10%"><B><fmt:message key="ePH.AdminDate/Time.label" bundle="${ph_labels}"/></B></td> <!-- 13 changed to 10  for AAKH-CRF-0084 [IN060429]  -->
								<td class="TDSTYLE"   width="2%"><B><fmt:message key="ePH.BroughtByPatient.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE"   width="10%"><B><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></B></td><!--Modified for HSA-CRF-0090[IN041241]-->
								<td class="TDSTYLE"   width="8%"><B><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></B></td>
								<td class="TDSTYLE"   width="8%"><B><fmt:message key="ePH.AdminDtls.label" bundle="${ph_labels}"/></B></td>
<%								if(isSite_spec_patient_stock){ //added for GHL-CRF-0482
%>
								<td class="TDSTYLE"   width="5%"><B><fmt:message key="ePH.PatientStockCompleted.label" bundle="${ph_labels}"/></B></td>
<%
								}
%>
								</tr>
								<tr id="non_iv_admin_table_row1" >
								<td class='COLUMNHEADER' colspan="14"  style="font-size:10" ><b><%=title%> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
							</tr>
<%
							for(int i=0;i<tot_rec;i++){//ML-MMOH-CRF-1014 - start
						
							if(i==1){
								admin_drug_details = null;
								hmAdmin_drug_details = null;
								hmAdmin_drug_details = (ArrayList)non_iv_drug_details.get(order_id+"_2");
								admin_drug_details = (ArrayList)hmAdmin_drug_details.get(0);
								iRecCount++;
								recCount= "2";
								order_line_num = recCount;
							}//ML-MMOH-CRF-1014
							ppn_count = 0;
							linkVacScheduleCode="";
							linkVacScheduleYN ="N";
							iv_prep_yn			= (String)admin_drug_details.get(44);
							iv_incred			= (String)admin_drug_details.get(53);
							route_desc			= (String)admin_drug_details.get(54);
							pres_catg_code		= (String)admin_drug_details.get(55);							
							medn_admn_dtl_reqd_yn	= admin_drug_details.get(45)==null?"":(String)admin_drug_details.get(45);

							prn_remarks			= (String)admin_drug_details.get(46);				
							slidingscaleremarks	= (String)admin_drug_details.get(47);
							ext_prod_id			= (String)admin_drug_details.get(50);
							trade_code			= (String)admin_drug_details.get(51);
							imageFileURL		= (String)admin_drug_details.get(52);
							schedule_uom_desc	= (String)admin_drug_details.get(56);
							schedule_uom_code	= (String)admin_drug_details.get(57);
							patient_brgt_medn	= (String)admin_drug_details.get(58);
							sliding_scale_applicable	= (String)admin_drug_details.get(59);
							strength_value_prn	= (String)admin_drug_details.get(60)==null?"":(String)admin_drug_details.get(60);
							sch_strength_value_prn	= (String)admin_drug_details.get(61)==null?"":(String)admin_drug_details.get(61);
							adminsted_pat_brought_medn	= (String)admin_drug_details.get(62);	
							dosage_type			= (String)admin_drug_details.get(63);
							dosage				= (String)admin_drug_details.get(64);
							dosage_uom_code		= (String)admin_drug_details.get(65);
							dosage_uom_desc		= (String)admin_drug_details.get(66);
							content_in_pres_base_uom= (String)admin_drug_details.get(67);
							sch_strength_uom_prn	= (String)admin_drug_details.get(68)==null?"":(String)admin_drug_details.get(68);
							sch_strength_uom_desc_prn	= (String)admin_drug_details.get(69)==null?"":(String)admin_drug_details.get(69);	
							admn_dose_chng_reason_code	= (String) admin_drug_details.get(70)==null?"":(String)admin_drug_details.get(70);	
							onco_direct_drug_count		= (String)admin_drug_details.get(71);
							linkVacScheduleCode			= (String)admin_drug_details.get(72);
							performingDeptLocCode		= (String)admin_drug_details.get(73)==null?"":(String)admin_drug_details.get(73);
							pres_base_uom				= (String)admin_drug_details.get(3);
							adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
							verificationremarks	= bean_all_stages.getVerificationRemarks((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							overridereason		= (HashMap)bean_all_stages.getOverrideremarks((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							pres_remarks		= bean.getPrescriptionInstructions((String)admin_drug_details.get(13));
							drug_remarks		= bean.getDrugInstructions((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							pharma_remarks		= bean.getPharmacistInstructions((String)admin_drug_details.get(13),(String)admin_drug_details.get(14));
							show_remarks		= "N";
							order_pract_id  =(String)admin_drug_details.get(76)==null?"":(String)admin_drug_details.get(76);
							start_date_time	= (String)admin_drug_details.get(77);
							route_color                 = (String)admin_drug_details.get(75)==null?"":(String)admin_drug_details.get(75);	
							if(route_color != "" && route_color != null && route_color.length()==12){
								fntColor = route_color.substring(0, 6);
								backGrndColor = route_color.substring(6, 12);
							}
							if(ext_prod_id!=null && !ext_prod_id.equals("")){
								if(overridereason.size()>1){
									show_remarks="Y";
								}			
							}
							else{
								if(overridereason.size()>0){
									show_remarks="Y";
								}
							}
							if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
								linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);						
								if(!linkVacScheduleCode1.equals("NO DEFAULT")){
									try{
										linkVacScheduleYN="Y";
										vacScheduleDetails=linkVacScheduleCode.split("~");
										if(vacScheduleDetails.length>0){
											linkVacScheduleCode=vacScheduleDetails[0]+"~"+vacScheduleDetails[1]+"~"+vacScheduleDetails[2]+"~"+vacScheduleDetails[5];
											linkVacScheduleDescToolTip=vacScheduleDetails[3];
											linkVacScheduleDesc=vacScheduleDetails[4];
										}
									}
									catch(Exception execu){
										execu.printStackTrace();
									}
								}
								else{
									linkVacScheduleYN="Y";
									linkVacScheduleDescToolTip="";
									linkVacScheduleDesc="";
									vacScheduleDetails=linkVacScheduleCode.split("~");
									if(vacScheduleDetails.length>0){
										linkVacScheduleCode=vacScheduleDetails[1];
									}
								}
							}
							else{
								linkVacScheduleYN="N";
								linkVacScheduleDescToolTip="";
								linkVacScheduleDesc="";
							}
							tempDosage				=	dosage;
							strength_value_prn		=	strength_value_prn.trim();
							sch_strength_value_prn	=	sch_strength_value_prn.trim();
							if(iv_prep_yn == null){
								iv_prep_yn="";
							}
							if(pres_catg_code == null){
								pres_catg_code="";
							}
							if(route_desc==null)
								route_desc="";
							iv_incred2="";
							if(iv_incred != null){
								stiv_incred = new StringTokenizer(iv_incred,"|");
								while(stiv_incred.hasMoreTokens()){
									iv_incred1 = stiv_incred.nextToken();
									if(stiv_incred.hasMoreTokens())
										iv_incred2 = stiv_incred.nextToken();						
								}
							} 

							auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);												
							if(auth_reqd){							
								if(pin_value.equals(""))
									auth_reqd_script=";pinAuthentication(this,'NP');";
								else
									auth_reqd_script=";pinAuthentication(this,'YP');";
							}
							
							if ( (iRecCount+1) % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;						
							flag="Y";
							disp_drug_code	= (String)admin_drug_details.get(0);
							drug_code		= (String)admin_drug_details.get(28);
							dispensed_drug_desc	= (String)admin_drug_details.get(86);
							disp_drugs = (String)admin_drug_details.get(87);
							dispense_drug_code = (String)admin_drug_details.get(88);
							generic_id = (String)admin_drug_details.get(89);
							split_dose_yn = (String)admin_drug_details.get(82);//ML-MMOH-SCF-1439
							if(dispense_drug_code.equals(""))
								dispense_drug_code = drug_code;
							store_code		= (String)admin_drug_details.get(29);	
							drug_class		= admin_drug_details.get(30)==null?"":(String)admin_drug_details.get(30);
							end_date_time	= (String)admin_drug_details.get(32);
							drug_desc		= (String)admin_drug_details.get(1);	
							
							encode_drug_desc= drug_desc.replaceAll(" ","%20");
							encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
							encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");

							adr_count	= bean.getADRCount(patient_id,drug_code);
							qty				= (String)admin_drug_details.get(2);
							ordered_qty		= (String)admin_drug_details.get(2);
							if(ordered_qty.equals(""))
								ordered_qty	="0";							
							short_desc		= (String)admin_drug_details.get(3);
							batch_id		= (String)admin_drug_details.get(4)==null?"":(String)admin_drug_details.get(4);
							expiry_date		= (String)admin_drug_details.get(5)==null?"":(String)admin_drug_details.get(5); 
							tradename		= (String)admin_drug_details.get(6)==null?"":(String)admin_drug_details.get(6);
							item_code		= (String)admin_drug_details.get(7);
							order_id	    = (String)admin_drug_details.get(13);
							order_line_num  = (String)admin_drug_details.get(14);
							patient_id	    = (String)admin_drug_details.get(15);
							sch_date_time   = (String)admin_drug_details.get(16);
							uom_code		= (String)admin_drug_details.get(43);
							
							//added for MMS-KH-CRF-0017.1 - start
							if(sch_date_time_drug.equals(""))
								sch_date_time_drug=sch_date_time;

							if(iv_prep_yn.equals("9") && order_line_num.equals("2"))
								sch_date_time = sch_date_time_drug;

							//added for MMS-KH-CRF-0017.1 - end
							patient_class_ord = bean.getOrderPatientClass(order_id);
							//GHL-CRF-0482 - start
							if(iv_prep_yn.equals("")){
								patient_stock_required = (String)admin_drug_details.get(93)==null?"N":(String)admin_drug_details.get(93);
								patient_stock_completed = (String)admin_drug_details.get(94)==null?"N":(String)admin_drug_details.get(94);
								patient_stock_yn = (String)admin_drug_details.get(95)==null?"N":(String)admin_drug_details.get(95);
							}
							
							if(!iv_prep_yn.equals(""))
								patient_stock_disabled="disabled";
							if(patient_brgt_medn.equals("Y"))
								patient_stock_disabled="disabled";
						
							if(patient_stock_completed.equals("Y"))
								patient_stock_checked = "checked";
							else
								patient_stock_checked = "";

							if(patient_stock_required!=null && patient_stock_required.equals("Y")) 
								patient_stock_check_display	=	"display:inline"; 
							else
								patient_stock_check_display	=	"display:none";

							//GHL-CRF-0482-end
							if(patient_class_ord==null)
								patient_class_ord = "";

							if(iv_prep_yn.equals("9") &&  Integer.parseInt(onco_direct_drug_count)>1 && order_line_num.equals("1"))
								classvalue="IVFLUID1";
							if(iv_prep_yn !=null && iv_prep_yn.equals("7"))
								   ppn_count = bean.getPPNIOrderValues(order_id, patient_id);

							if(!locale.equals("en"))
								expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date, "DMY",locale,"en");

							Store_locn_code	= performingDeptLocCode;
							Storelocn_code	= bean.getStoreLocnnCode(nursing_unit);

							if(!Storelocn_code.equals("")){
								admin_drug_details.set(29,Storelocn_code);
								store_code		= Storelocn_code;
							}
							if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")){	
								work_sheet_batch_det1  =(ArrayList)bean.getProductName(order_id,order_line_num);								
								batch_id	=	work_sheet_batch_det1.get(1)==null?"":(String)work_sheet_batch_det1.get(1);
								expiry_date	=	work_sheet_batch_det1.get(2)==null?"":(String)work_sheet_batch_det1.get(2);
								drug_code	= "FINAL PRODUCT";															
							}
							else if(iv_prep_yn.equals("8")){
								work_sheet_batch_det1  =(ArrayList)bean.getTPNProductName(order_id,order_line_num);
								batch_id	=	work_sheet_batch_det1.get(1)==null?"":(String)work_sheet_batch_det1.get(1);								
								expiry_date	=	work_sheet_batch_det1.get(2)==null?"":(String)work_sheet_batch_det1.get(2);
								drug_code	= "FINAL PRODUCT";
							}

							Auto_Admin					 =  bean.getAutoAdminValue(facility_id,Store_locn_code);
							administred_batch   =  bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);						
							disp_batch_id				 =  "";
							administred_batch_id		 =  "";
							disp_exp_dt					 =  "";
							administred_batch_id         =administred_batch.get("BATCH_ID")==null?"":(String)administred_batch.get("BATCH_ID");
										
							disp_batch_id		 = administred_batch.get("DISP_BATCH_ID")==null?"":(String)administred_batch.get("DISP_BATCH_ID");					
							disp_exp_dt			 = administred_batch.get("DISP_EXPIRY_DATE")==null?"":(String)administred_batch.get("DISP_EXPIRY_DATE");
										
							if(!locale.equals("en"))
								disp_exp_dt = com.ehis.util.DateUtils.convertDate(disp_exp_dt, "DMY",locale,"en");

							disp_trade_id		 = (String)administred_batch.get("DISP_TRADE_ID")==null?"":(String)administred_batch.get("DISP_TRADE_ID");
							dosage_seq_no		= (String)admin_drug_details.get(17);
							trade_id			= (String)admin_drug_details.get(18);			
							dis_continued		= (String)admin_drug_details.get(19);
							hold				= (String)admin_drug_details.get(20);
							administered		= (String)admin_drug_details.get(21);
							admin_recorded_yn   = (String)admin_drug_details.get(22); 	
							remarks				= (String)admin_drug_details.get(23);
							admindrugdetails	= (String)admin_drug_details.get(24);
							pract_id			= (String)admin_drug_details.get(36);
							against_sch_date	= (String)admin_drug_details.get(37);
							if(!locale.equals("en"))
							   against_sch_date = com.ehis.util.DateUtils.convertDate(against_sch_date, "DMYHM",locale,"en");
							adr_reason			= admin_drug_details.get(38)==null?"":(String)admin_drug_details.get(38);
							adr_remarks			= admin_drug_details.get(39)==null?"":(String)admin_drug_details.get(39);
							adr_record_time		= admin_drug_details.get(40)==null?"":(String)admin_drug_details.get(40);
							adr_recorded_by		= admin_drug_details.get(41)==null?"":(String)admin_drug_details.get(41);
							pres_dosage			= admin_drug_details.get(42)==null?"":(String)admin_drug_details.get(42);
							pres_unit			= admin_drug_details.get(43)==null?"":(String)admin_drug_details.get(43);
							admin_drug_code	    =  "";
							admin_drug_desc 	=  "";
										
							if( (bean.getPractitionerType(pract_id)).equals("NS")){
								tradename = bean.getTradeNameForNewEntry(encounter_id,sch_date_time,drug_code);
							}
							if(admindrugdetails != null){
								stadmindrugdetails = new StringTokenizer(admindrugdetails,":");
								while(stadmindrugdetails.hasMoreTokens()){
									admin_drug_code = stadmindrugdetails.nextToken();
									if(stadmindrugdetails.hasMoreTokens())
										admin_drug_desc = stadmindrugdetails.nextToken();
									if(stadmindrugdetails.hasMoreTokens())
										admin_dose_prn  = stadmindrugdetails.nextToken();	 
									if(stadmindrugdetails.hasMoreTokens())
										stadmindrugdetails.nextToken();
								}
							}
							if(remarks==null){
								remarks="Not Entered";
							}
							admin_by_name = (String)admin_drug_details.get(25);
							auth_by_name  = (String)admin_drug_details.get(31);
							freq_code	  = (String)admin_drug_details.get(33);
							freq_nature	  = (String)admin_drug_details.get(34)==null?"":(String)admin_drug_details.get(34);
							/*if(!locale.equals("en")){ 
								//sch_date_time = com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en");//Commented ofr SKR-SCF-0997 [IN:048677]
								current_date_time = com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM","en",locale);//Added ofr SKR-SCF-0997 [IN:048677]  
							//} */ // Commented for TTM-SCF-0185-974750 [IN:066489]
							//|| admin_bean.gethold_discontinue(order_id, order_line_num).equals("DD") ,("DE") ADDED FOR MMS-KH-CRF-0014
							if(!customer_id.equals("ALMO") && verify_adm_drug && iv_prep_yn.equals("") && (admin_bean.gethold_discontinue(order_id, order_line_num).equals("DF") || admin_bean.gethold_discontinue(order_id, order_line_num).equals("DP")|| admin_bean.gethold_discontinue(order_id, order_line_num).equals("DD")|| admin_bean.gethold_discontinue(order_id, order_line_num).equals("DE"))){  // Added for AAKH-CRF-0084 [IN060429] and //added && !customer_id.equals("AMOL") for MMS-DM-SCF-0442
							     if(!customer_id.equals("ALNA"))//Added if condition Alone for NMC-JD-SCF-0325
						 		    medn_admn_dtl_reqd_yn = "Y";
						    }
							if (admin_bean.compareDates(sch_date_time,adminFromDateTime) && !(freq_nature.equals("P")))
								medn_admn_dtl_reqd_yn = "Y";
							
							if(defaultDate.equals("") && freq_nature.equals("P")){ //&& !sch_date.equals(""))
								defaultDate = sch_date_time;
								if(com.ehis.util.DateUtils.isBefore( AdminBackLogTime, start_date_time,  "DMYHM", locale))
									AdminBackLogTime = start_date_time;
								if(com.ehis.util.DateUtils.isBefore( AdminBackLogTime, sch_date+" 00:00",  "DMYHM", locale))
									AdminBackLogTime = sch_date+" 00:00";
								//if(com.ehis.util.DateUtils.isAfter( current_date_time, sch_date+" 23:59", "DMYHM", locale))
								current_date_time = sch_date+" 23:59";
								if(com.ehis.util.DateUtils.isBefore( current_date_time, sch_date+" 00:00", "DMYHM", locale))
									current_date_time = sch_date+" 23:59";
								if(com.ehis.util.DateUtils.isAfter( current_date_time, adminToTime, "DMYHM", locale))
									current_date_time = adminToTime;
								//defaultDate = sch_date+ current_date_time.substring(current_date_time.indexOf(" "), current_date_time.length());
							}
							showTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name;
							if(auth_by_name!=null && !auth_by_name.equals("")){
								showTitle =showTitle + "\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name ;
							}

							admin_date_time = "";
							if(admin_drug_details.get(26)!= null){
								admin_date_time = (String)admin_drug_details.get(26);
								if(!locale.equals("en"))
									admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM",locale,"en");
							}
								
							modified_date_time = "";
							if(admin_drug_details.get(27)!= null){
								modified_date_time = (String)admin_drug_details.get(27);
							}
							if(iv_prep_yn.equals("9") && i==0){ //JD-CRF-0200 - start
							 onco_modified_date_time = modified_date_time;
							 onco_dosage_seq_no = dosage_seq_no;
							}
							if(iv_prep_yn.equals("9") && i==1){
								 modified_date_time = onco_modified_date_time ;
								 dosage_seq_no = onco_dosage_seq_no;
							} ////JD-CRF-0200 -end
							if( freq_nature.equals("O")) 
								stat_style	=	"background-color:#CE00CE";
							else if( freq_nature.equals("P"))
								stat_style	=	"background-color:#804040";
							else 
								stat_style	=	"";

							expiry_date = expiry_date.trim();

							alt_drug			=	bean_all_stages.checkMultiStrength(drug_code);
							bean_all_stages.addDrugs(patient_id,patient_id,drug_code,alt_drug,order_line_num);	

							tot_alt_qty       = 0.0f;
							for(int n=0; n<multi_drugs.size(); n+=5){ 
								tot_alt_qty += Float.parseFloat((String)multi_drugs.get(n+3));
							}

							displayStyle		=	"";
							statusFlag		=	"YES";
							addDisplayStyle	=	"";
							checked			=	"";
							select_status_1			=   "";

							if(admin_discontinue.equals("Y")){
								admin_disc_classValue = "background-color:#ffa8a8";
								medn_admn_dtl_reqd_yn = "Y";
							}
						   if(future_admin.equals("F") && adminOption.equals("AD")){ // Added for GHL-CRF-0482 - Start
							    medn_admn_dtl_reqd_yn = "Y";
						   }
						   else if(future_admin.equals("F") && !adminOption.equals("AD")){
						    	future_admin = "";
						    } // Added for GHL-CRF-0482 - End

							if(medn_admn_dtl_reqd_yn.equals("Y")) 
								mand_display	=	"style='display:inline'";
							else
								mand_display	=	"style='display:none'";

							select_status	=	"";
							dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";
							if(freq_code!=null && freq_code.equals("STAT")) {
								displayStyle	=	"background-color:#CE00CE;";
							}
							else if(dis_continued.equals("Y")){
								displayStyle = "BACKGROUND-COLOR:red;";
							}
							else if(hold.equals("Y")){
								displayStyle = "BACKGROUND-COLOR:yellow;";
							}
							else if(admin_recorded_yn.equals("Y")){
								if(administered.equals("N")) {
									displayStyle = "BACKGROUND-COLOR:#000000;";
								} 
								else{  
									displayStyle = "BACKGROUND-COLOR:green;";
									batch_ids	= new ArrayList();
								}
							}
							verbalOrder="";	
							if((bean.getPractitionerType(pract_id)).equals("NS")){
								verbalOrder="<b>V<b>";
							}
							showAlt = "";
							if(admin_recorded_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
								showAlt	 = ("Ordered Drug : "+drug_desc+"\n");
								showTitle = showAlt + showTitle;
								displayStyle = "BACKGROUND-COLOR:#CC99CC;";
							}

							if( drug_class.equals("N")){
								drug_class_ind = "background:#66FFFF";
							}
							else if( drug_class.equals("C")){
								drug_class_ind = "background:#CCFFCC";
							}
							else if(iv_prep_yn.equals("6")){
								drug_class_ind = "background:#E4CAFF";
							}
							else{
								drug_class_ind = "";
							}

							adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
										
							adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;									

							if(!admin_date_time.equals("")){
								img_path	=	"<img SRC='../../eOR/images/Authorized.gif' onClick=\"recordADR('"+encounter_id+"','"+drug_code+"','1',this,'"+sch_date_time+"','"+order_id+"')\" title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordPostAdministrationDetails.label", "ph_labels")+"' style='cursor:pointer'></img>";
							}

							if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N")){
								remarks_style	=	"style='visibility:hidden'";
							}
							else{
								dialog_height = 0 ;
								if(!prn_remarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!drug_remarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!pres_remarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!slidingscaleremarks.trim().equals(""))
									dialog_height	 += 6.5;

								if(!verificationremarks.trim().equals(""))
									dialog_height	 += 6.5;
					
								if(show_remarks.equals("Y"))
									dialog_height	 += 13;
					
								remarks_style	=	"style='visibility:visible'";
								dialog_height	 += 1.4;
							}												
							if(sliding_scale_applicable.equals("Y")){
								sliding_scale_details=bean.getSlidingScaleTemplateDetails(order_id,order_line_num);
								AdUOM="";
								if(sliding_scale_details.size()>0){
									AdUOM=(String)sliding_scale_details.get(6);
								}
							}
							//added for GHL-CRF-0482 - start	
							if(patient_stock_required!=null && patient_stock_required.equals("Y") && iv_prep_yn.equals("")){
								//HashMap drugMap = bean.getOrderIdListForSameDrug();
								//ArrayList orderIdList = (ArrayList)drugMap.get(disp_drug_code);
					
							//if(patient_stock_yn.equals("Y")){
//								batch_ids       =   bean.getAllBatchIDSForPatientStock(patient_id,facility_id,encounter_id,disp_drug_code);
							//}else{
								batchIdforOrders = bean.getBatchIdForOrders();
								if(batchIdforOrders!=null && batchIdforOrders.containsKey(disp_drug_code)){
									int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);

									if(rec_count>0 || patient_stock_yn.equals("Y"))
										batch_ids = (ArrayList)batchIdforOrders.get(disp_drug_code);
									else
										batch_ids = new ArrayList();
									//System.err.println("MARSchLevelDrugAdmin.jsp=======batch_ids====1425===>"+batch_ids);
								}else{
									int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);

									if(rec_count>0 || patient_stock_yn.equals("Y"))
										batch_ids       =   bean.getAllBatchIDSForPatientStock(patient_id,facility_id,encounter_id,disp_drug_code);
									else
										batch_ids = new ArrayList();
									}
							//	}
							}else{	
								batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"N");	
							}
							//added for GHL-CRF-0482 - end
							alt_drug_display="display:none";						//Added for Bru-HIMS-CRF-399 [IN:043767] start
							arrAltDrugs = bean_all_stages.getAlternateDrugs(drug_code,generic_id);
							if(allow_mar_alternate_drug_yn.equals("Y") && Auto_Admin.equals("Y") && alt_drug.equals("Y") && arrAltDrugs.size()>0){
								alt_drug_display="display:inline";					//Added for Bru-HIMS-CRF-399 [IN:043767] end
								alt_flag = true;
							}
%>
							<tr>
								<input type="hidden" name="non_iv_sliding_scale_<%=recCount%>" id="non_iv_sliding_scale_<%=recCount%>" value="<%=sliding_scale_applicable%>">	
								<input type="hidden" name="modified_date_time_<%=recCount%>" id="modified_date_time_<%=recCount%>" value="<%=modified_date_time%>">
								<input type="hidden" name="non_iv_status_flag_<%=recCount%>" id="non_iv_status_flag_<%=recCount%>" value="<%=statusFlag%>">
								<input type="hidden" name="non_iv_dosage_seq_no_<%=recCount%>" id="non_iv_dosage_seq_no_<%=recCount%>" value="<%=dosage_seq_no%>">
								<input type="hidden" name="non_iv_drug_code_<%=recCount%>" id="non_iv_drug_code_<%=recCount%>" value="<%=drug_code%>">
								<input type="hidden" name="non_iv_dispense_drug_code_<%=recCount%>" id="non_iv_dispense_drug_code_<%=recCount%>" value="<%=dispense_drug_code%>">
								<input type="hidden" name="non_iv_item_code_<%=recCount%>" id="non_iv_item_code_<%=recCount%>" value="<%=item_code%>">
								<input type="hidden" name="non_iv_order_id_<%=recCount%>" id="non_iv_order_id_<%=recCount%>" value="<%=order_id%>">
								<input type="hidden" name="non_iv_order_line_no_<%=recCount%>" id="non_iv_order_line_no_<%=recCount%>" value="<%=order_line_num%>">
								<input type="hidden" name="non_iv_store_code_<%=recCount%>" id="non_iv_store_code_<%=recCount%>" value="<%=store_code%>">
								<input type="hidden" name="non_iv_end_date_<%=recCount%>" id="non_iv_end_date_<%=recCount%>" value="<%=end_date_time%>">		
								<input type="hidden" name="non_iv_drug_class<%=recCount%>" id="non_iv_drug_class<%=recCount%>" value="<%=drug_class%>">
								<input type="hidden" name="non_iv_dtls_yn<%=recCount%>" id="non_iv_dtls_yn<%=recCount%>" value="N">							
								<input type="hidden" name="medn_admn_dtl_reqd<%=recCount%>" id="medn_admn_dtl_reqd<%=recCount%>" value="<%=medn_admn_dtl_reqd_yn%>">	
								<input type="hidden" name="iv_prep_yn_forNONIV<%=recCount%>" id="iv_prep_yn_forNONIV<%=recCount%>" value="<%=iv_prep_yn%>">
								<input type="hidden" name="non_iv_dosage_type_<%=recCount%>" id="non_iv_dosage_type_<%=recCount%>" value="<%=dosage_type%>">
								<input type="hidden" name="onco_direct_drug_count_<%=recCount%>" id="onco_direct_drug_count_<%=recCount%>" value="<%=onco_direct_drug_count%>">
								<input type="hidden" name="non_iv_qty_in_disp_mode_<%=recCount%>" id="non_iv_qty_in_disp_mode_<%=recCount%>" value="">										
								<input type="hidden" name="Remarks<%=recCount%>" id="Remarks<%=recCount%>" value="N">					
								<input type="hidden" name="non_iv_Auto_Admin_<%=recCount%>" id="non_iv_Auto_Admin_<%=recCount%>" value="<%=Auto_Admin%>">
								<input type="hidden" name="order_pract_id_<%=recCount%>" id="order_pract_id_<%=recCount%>" value="<%=order_pract_id%>">
								<input type="hidden" name="future_or_late_<%=recCount%>" id="future_or_late_<%=recCount%>" value="<%=future_admin%>"> <!--  Added for GHL-CRF-0482 --> 
								<td class="white" width="2%" style="<%=displayStyle%>"><%=verbalOrder%></td>
								<td class="<%=classvalue%>" style="<%=drug_class_ind%>">
<%
								if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {

%>
									<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=disp_drug_code%>');" id="drug_mast_det_1">&nbsp;+&nbsp;</label>
<%
								}
%>
								<label name="lbl_drug_desc" style="font-size:10;"><%=drug_desc%>&nbsp;&nbsp;							
<%				
								if(ext_prod_id!=null && !ext_prod_id.equals("") && !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1")&&(Integer.parseInt(onco_direct_drug_count)>1))&& !(iv_prep_yn.equals("6"))){
%>					
									<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
								}
								if(imageFileURL!=null && !imageFileURL.equals("")){
%>
									<img src='../../ePH/images/camera.gif' width='17' height='15' onclick = "showImage('<%=drug_code%>','<%=trade_code%>');" onmouseover="changeCursor(this);">
<%
								}
								if(adr_count>0){
%>
									<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id%>','<%=drug_code%>');"></img>
<%
								} 
								if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
									<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" onmouseover="changeCursor(this);">
<%						
								}
								if(iv_prep_yn.equals("7") && ppn_count >0){
%>
									<img src='../../ePH/images/AddedIngredient.gif' width='17' height='15' onclick = "openPPNDisplay('<%=patient_id%>','<%=order_id%>','<%=Store_locn_code%>')" onmouseover="changeCursor(this);">						  
<%	
								}
%>				
								</label>
								<img  id="alternate_image_<%=recCount%>" src='../../ePH/images/altenate.jpg' style="cursor:pointer;<%=alt_drug_display%>" height='15' width='15' onClick="callAlternateDrugWindow('<%=drug_code%>','<%=encode_drug_desc%>','<%=patient_id%>','<%=order_id%>','<%=order_line_num%>','<%=store_code%>','<%=qty%>','<%=expiry_date%>','<%=uom_code%>','<%=recCount%>','<%=freq_nature%>','N');" title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>'></img><!-- //Added for Bru-HIMS-CRF-399 [IN:043767] -->
<%								if(dispensed_drug_desc==null || dispensed_drug_desc.equals(""))//Added for Bru-HIMS-CRF-399 [IN:043767]
									disp_drugs="";
%>
									<br><label id="id_dispdrugdesc_<%=recCount%>"  style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_drugs%> </label><!-- //Added for Bru-HIMS-CRF-399 [IN:043767] -->
									<input type="hidden" name="dispensed_drug_desc_<%=recCount%>" id="dispensed_drug_desc_<%=recCount%>" value="<%=disp_drugs%>">
<%
								if(linkVacScheduleYN.equals("Y")){ 
									if((!(iv_prep_yn.equals("9")||iv_prep_yn.equals("6")))||(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){
%>
										<br><label id='link_vaccine_label_<%=recCount%>' style="font-size:10;" title='<%=linkVacScheduleDescToolTip%>'> <fmt:message key="ePH.LinkVaccineShcedule.label" bundle="${ph_labels}"/> <input type='text' size=10 name='link_vaccine_desc_<%=recCount%>' id='link_vaccine_desc_<%=recCount%>' value='<%=linkVacScheduleDesc%>' disabled><input type=button  class='button' value='?' name='btn_link_vaccine_<%=recCount%>' id='btn_link_vaccine_<%=recCount%>' onClick="linkVaccine('noniv','<%=recCount%>')"></label>
										<input type='hidden' name="link_vaccine_code_<%=recCount%>" id="link_vaccine_code_<%=recCount%>" value='<%=linkVacScheduleCode%>'>
<%
									}
								}
%>							
								</td>
								<td nowrap class='<%=classvalue%>'  >&nbsp;</td>
								<td   class="<%=classvalue%>">
									<img src="../../ePH/images/DrugRemarks.gif" align="center" width="50%" height="60%" style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_num%>','<%=dialog_height%>','<%=encode_drug_desc%>','N')" title=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")%> <%=remarks_style%>></img>
								</td>
								<td  class="<%=classvalue%>">
<%  
								if(iv_prep_yn.equals("8")){ 
%>
									<label  style="cursor:pointer;font-size:9;color:blue" onClick="showTPNDetails('<%=order_id%>');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label>
<%
								}
								if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){	
%>
									<label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','','MAR','<%=Store_locn_code%>','<%=sliding_scale_applicable%>','N');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label>
<%
								}
								else if(iv_prep_yn.equals("6")){
%> 
									<label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','','MAR','<%=Store_locn_code%>','<%=sliding_scale_applicable%>','N');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label>
<%
								}
								else if(!iv_prep_yn.equals("8")){
%> 
									<label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','<%=order_line_num%>','MAR','<%=Store_locn_code%>','<%=sliding_scale_applicable%>','N');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label>
<%
								}
%>
								</td>
								<td class="<%=classvalue%>" style="">
<%								
								if(sliding_scale_applicable.equals("Y") && sliding_scale_details.size()>0){								
									rangeUOM=(String)sliding_scale_details.get(5);
%>
									<input type="text" name="non_iv_sliding_range_<%=recCount%>" id="non_iv_sliding_range_<%=recCount%>" size="5" maxlength="13" onKeyPress="return allowValidNumber(this,event,6,3);" oncopy="return false" onpaste="return false"  onBlur="CheckNum(this);findValuesRange(this,<%=recCount%>)" value="" class="NUMBER" style="font-size:11;<%=addDisplayStyle%>" <%=select_status%>><label style="font-size:10;<%=addDisplayStyle%>" ><b><%=rangeUOM%></b></label>
									<input type="text" name="non_iv_admin_qty_<%=recCount%>" id="non_iv_admin_qty_<%=recCount%>" size="5" maxlength="13" onKeyPress="return allowValidNumber(this,event,6,3);" oncopy="return false" onpaste="return false" onBlur="CheckNum(this)" value="" class="NUMBER" style="font-size:11;<%=addDisplayStyle%>" <%=select_status%>><label style="font-size:10;<%=addDisplayStyle%>" ><b><%=AdUOM%></b></label> 
									<input type="hidden" name="non_iv_admin_qty_uom_<%=recCount%>" id="non_iv_admin_qty_uom_<%=recCount%>" value="<%=AdUOM%>">
									<input type="hidden" name="non_iv_range_uom_<%=recCount%>" id="non_iv_range_uom_<%=recCount%>" value="<%=rangeUOM%>">
<%
									for(int sl=0;sl<sliding_scale_details.size();sl+=7){
										sl_srl_no=(String)sliding_scale_details.get(sl+1);
										sl_rg_fro=(String)sliding_scale_details.get(sl+2);
										sl_rg_to=(String)sliding_scale_details.get(sl+3);
										sl_adm_qty=(String)sliding_scale_details.get(sl+4);
%>
										<input type="hidden" name="sliding_scale_ranges_from_<%=recCount%>_<%=sl_srl_no%>" id="sliding_scale_ranges_from_<%=recCount%>_<%=sl_srl_no%>" value="<%=sl_rg_fro%>">
										<input type="hidden" name="sliding_scale_ranges_to_<%=recCount%>_<%=sl_srl_no%>" id="sliding_scale_ranges_to_<%=recCount%>_<%=sl_srl_no%>" value="<%=sl_rg_to%>">
										<input type="hidden" name="sliding_scale_adm_qty_<%=recCount%>_<%=sl_srl_no%>" id="sliding_scale_adm_qty_<%=recCount%>_<%=sl_srl_no%>" value="<%=sl_adm_qty%>">
<%
									}
%>
									<input type="hidden" name="sliding_scale_srl_no_<%=recCount%>" id="sliding_scale_srl_no_<%=recCount%>" value="<%=sl_srl_no%>">
									<input type="hidden" name="non_iv_admin_chng_dtls_req_<%=recCount%>" id="non_iv_admin_chng_dtls_req_<%=recCount%>" value="N">
									<input type="hidden" name="non_iv_admin_quaty_<%=recCount%>" id="non_iv_admin_quaty_<%=recCount%>" value="<%=non_iv_admin_quaty%>">
<%
								}
								else{
									if(dosage==null || dosage.equals(""))
										dosage = "0";
									if(!split_dose_yn.equals("Y") && !freq_nature.equals("P") ){ //added for ML-MMOH-SCF-1439 and !freq_nature.equals("P") added for SKR-SCF-1534
									if(Float.parseFloat(qty)!=Float.parseFloat(dosage))
										qty = dosage;

									}else{
										if(split_dose_yn.equals("Y")){
										qty = bean.getSplitDosage(order_id,order_line_num,sch_date_time.split(" ")[1]);
										}
									}
									if(freq_nature.equals("P")){													
										if(!dosage_seq_no.equals("2")){ 
											dosage=sch_strength_value_prn;
											dosage_uom_code=sch_strength_uom_prn;
											dosage_uom_desc=dosage_uom_desc;
										}	
										if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){
											ArrayList listArray=bean.getAlternateDrugsEqualQuantity(dosage,drug_code,disp_drug_code);
											if(listArray!=null && !alt_flag){
								
												dosage=(String)listArray.get(0);
												dosage_uom_desc=(String)listArray.get(1);
											}
										}
										
										non_iv_admin_quaty="";
										if(dosage_type.equals("S")){
											strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
											non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value_prn))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	
											if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
												non_iv_admin_quaty=qty;
											}
											dosage = pres_dosage;
										}
										else{
											non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
											if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
												non_iv_admin_quaty=qty;
											}
											dosage = pres_dosage;
										}
										if(Float.parseFloat(dosage) < 1.0){
											dosage = Float.parseFloat(dosage)+"";
										}//BRU-CRF-0399.1 - start	
								if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && batch_ids.size()==9 && !alt_flag){//changed 7 to 9 for GHL-CRF-0482 and !alt_flag added for ML-MMOH-SCF-1761
									String alt_dos_detail1= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
									if(alt_dos_detail1.indexOf("~")!=-1){
								if(!split_dose_yn.equals("Y")){  //if added for ML-MMOH-SCF-1757 & { added for ML-MMOH-SCF-1767
									dosage = alt_dos_detail1.split("~")[0];
									dosage_uom_code = alt_dos_detail1.split("~")[1];
									dosage_uom_desc = alt_dos_detail1.split("~")[2];
								}
									disp_with_alt= true;
								} //BRU-CRF-0399.1 - end
										}	
%>						
										<input type="text" name="non_iv_admin_qty1_<%=recCount%>" id="non_iv_admin_qty1_<%=recCount%>" size="5" maxlength="13" onKeyPress="return allowValidNumber(this,event,6,3);" onopy="return false" onpaste="return false"   onBlur="CheckNum(this);updateNonIvAdminQuantity(this,'<%=recCount%>','<%=strength_value_prn%>','<%=dosage_type%>','<%=content_in_pres_base_uom%>','<%=strength_per_value_pres_uom%>','<%=disp_with_alt%>'); makeDtlsMandatory(this,'<%=recCount%>','<%=drug_code%>','noniv','<%=freq_nature%>'); " value="<%=dosage%>" class="NUMBER" style="font-size:11;<%=addDisplayStyle%>" <%=select_status%>><label id="id_dosage_uom_new_MAR_<%=recCount%>" style="font-size:10;<%=addDisplayStyle%>" ><b><%=dosage_uom_desc%></b></label> 
<%
										String sch_dosage_qty	= (String)admin_drug_details.get(85);//Added for ML-MMOH-SCF-1964
										/*if(qty!=null && !qty.equals("") && freq_nature.equals("P")){//Commented for ML-MMOH-SCF-1964
											qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
										    }*/
											//Adding start for ML-MMOH-SCF-1964
										if(sch_dosage_qty!=null && !sch_dosage_qty.equals("") && freq_nature.equals("P")){
											 qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom));
										}else if(qty!=null && !qty.equals("") && freq_nature.equals("P")){
											 qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
										}//Adding end for ML-MMOH-SCF-1964
											int len= qty.length();
											if( len > 0 ){
												temp = qty;
												int point= temp.indexOf(".")+1;
												if(temp.charAt(point)=='0')
													qty = qty.substring(0,point-1);
												else{//added for SKR-SCF-1429 - start
													if(Float.parseFloat(qty)>1){ 
													if(temp.charAt(point)=='6' || temp.charAt(point)=='7' || temp.charAt(point)=='8' || temp.charAt(point)=='9'){
													 qty = Math.ceil(Float.parseFloat(qty))+"";
													}
													}
												} //added for SKR-SCF-1429 - end
											}
											if(dosage_type.equals("S")){ 
%>	
												<label style="font-size:10;<%=addDisplayStyle%>" id = "bal_qty_<%=recCount%>" ><b><fmt:message key="ePH.Bal.label" bundle="${ph_labels}"/><%=qty%>&nbsp;<%=pres_base_uom%></b></label>
												<input type="hidden" name="non_iv_bal_qty_<%=recCount%>" id="non_iv_bal_qty_<%=recCount%>" value="<%=qty%>">
												<input type="hidden" name="non_iv_admin_qty_<%=recCount%>" id="non_iv_admin_qty_<%=recCount%>" value="<%=non_iv_admin_quaty%>">
												<input type="hidden" name="non_iv_admin_qty_uom_<%=recCount%>" id="non_iv_admin_qty_uom_<%=recCount%>" value="<%=dosage_uom_code%>">
												<input type="hidden" name="non_iv_admin_qty_uom1_<%=recCount%>" id="non_iv_admin_qty_uom1_<%=recCount%>" value="<%=dosage_uom_code%>">
												<input type="hidden" name="h_non_iv_admin_qty_<%=recCount%>" id="h_non_iv_admin_qty_<%=recCount%>" value="<%=dosage%>">
												<input type="hidden" name="non_iv_admin_chng_dtls_req_<%=recCount%>" id="non_iv_admin_chng_dtls_req_<%=recCount%>" value="N">
												<input type="hidden" name="non_iv_admin_quaty_<%=recCount%>" id="non_iv_admin_quaty_<%=recCount%>" value="<%=non_iv_admin_quaty%>">
<%
										}
										else{
%>
											<label style="font-size:10;<%=addDisplayStyle%>" id = "bal_qty_<%=recCount%>" ><b><fmt:message key="ePH.Bal.label" bundle="${ph_labels}"/><%=qty%>&nbsp;<%=dosage_uom_desc%></b></label>
											<input type="hidden" name="non_iv_bal_qty_<%=recCount%>" id="non_iv_bal_qty_<%=recCount%>" value="<%=qty%>">
											<input type="hidden" name="non_iv_admin_qty_<%=recCount%>" id="non_iv_admin_qty_<%=recCount%>" value="<%=non_iv_admin_quaty%>">
											<input type="hidden" name="non_iv_admin_qty_uom_<%=recCount%>" id="non_iv_admin_qty_uom_<%=recCount%>" value="<%=dosage_uom_code%>">
											<input type="hidden" name="non_iv_admin_qty_uom1_<%=recCount%>" id="non_iv_admin_qty_uom1_<%=recCount%>" value="<%=dosage_uom_code%>">
											<input type="hidden" name="h_non_iv_admin_qty_<%=recCount%>" id="h_non_iv_admin_qty_<%=recCount%>" value="<%=dosage%>">
											<input type="hidden" name="non_iv_admin_chng_dtls_req_<%=recCount%>" id="non_iv_admin_chng_dtls_req_<%=recCount%>" value="N">
											<input type="hidden" name="non_iv_admin_quaty_<%=recCount%>" id="non_iv_admin_quaty_<%=recCount%>" value="<%=non_iv_admin_quaty%>">
<%										
										}	
									} 
									else{ 
										if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){
											ArrayList listArray = bean.getAlternateDrugsEqualQuantity(qty,drug_code,disp_drug_code);				//System.err.println("MARSchLevelDrugAdmin.jsp=960===>"+listArray);		
											
													if(listArray!=null && !alt_flag){
														qty=(String)listArray.get(0);
														short_desc=(String)listArray.get(1);
													}
										}
										  if(Float.parseFloat(qty) < 1.0){
												//qty = dfTest.format(Float.parseFloat(qty)); //commented for ML-MMOH-SCF-1674
												 if(qty.indexOf(".")!=-1){ //added for ML-MMOH-SCF-1674
													String f_qty = qty.substring(qty.indexOf("."),qty.length());
													if(f_qty.length()>8)
														qty = dfTest.format(Float.parseFloat(qty));
													   
													 qty =Float.parseFloat(qty)+"";
													}					 //ended for ML-MMOH-SCF-1674
										}
										if(admin_recorded_yn.equals("Y") && administered.equals("N"))
											qty = dosage;
										//BRU-CRF-0399.1 - start	
										if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && batch_ids.size()==9 && !alt_flag){//changed 7 to 9 for GHL-CRF-0482 and !alt_flag added for ML-MMOH-SCF-1761
											String alt_dos_detail= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
											if(alt_dos_detail.indexOf("~")!=-1){
											if(!split_dose_yn.equals("Y")){  //if added for ML-MMOH-SCF-1757 { added for ML-MMOH-SCF-1767
												qty = alt_dos_detail.split("~")[0];
										
											uom_code = alt_dos_detail.split("~")[1];
											short_desc = alt_dos_detail.split("~")[2];
											}
											}
										}//BRU-CRF-0399.1 - end
%>										
										<input type="text" name="non_iv_admin_qty_<%=recCount%>" id="non_iv_admin_qty_<%=recCount%>" size="5" maxlength="13" onKeyPress="return	allowValidNumber(this,event,6,3);" oncopy="return false" onpaste="return false"    onBlur="CheckNum(this);    makeDtlsMandatory(this,'<%=recCount%>','<%=drug_code%>','noniv','<%=freq_nature%>');" value="<%=qty%>" class="NUMBER" style="font-size:11;<%=addDisplayStyle%>" <%=select_status%>><label id="id_dosage_uom_new_MAR_<%=recCount%>" style="font-size:10;	<%=addDisplayStyle%>" ><b><%=short_desc%></b></label>		 
										<input type="hidden" name="non_iv_admin_qty_uom_<%=recCount%>" id="non_iv_admin_qty_uom_<%=recCount%>" value="<%=uom_code%>">
										<input type="hidden" name="h_non_iv_admin_qty_<%=recCount%>" id="h_non_iv_admin_qty_<%=recCount%>" value="<%=qty%>">
										<input type="hidden" name="non_iv_admin_chng_dtls_req_<%=recCount%>" id="non_iv_admin_chng_dtls_req_<%=recCount%>" value="N">
										<input type="hidden" name="non_iv_admin_quaty_<%=recCount%>" id="non_iv_admin_quaty_<%=recCount%>" value="<%=non_iv_admin_quaty%>">
<%
									}								
								}				
%> 
								</td>
								<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backGrndColor%>;font-size:10;'><label style="font-size:10;"> <%=route_desc%></label></td>
<%
								if(freq_nature.equals("P")){
%>
									<td class="<%=classvalue%>" ><label style="font-size:9;font-weight;color:black">&nbsp;</label></td>
<%
								}
								else{
								if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014- start
								ArrayList Mfr_Details=bean.getStatusOfMAR(order_id,"");
								String statusString = "";
							if(Mfr_Details.size()>0){
								statusString=(String)Mfr_Details.get(0);
								mfrCompletedStatus=new Boolean((String)Mfr_Details.get(1)).booleanValue();														
							}
							if(!mfrCompletedStatus ){// if added for ml-mmoh-crf-1014
								select_status="disabled";
							}
							%>
							<td class="<%=classvalue%>" id="non_iv_MFR_status_column_<%=recCount%>"><%if(order_line_num.equals("1")){%><label name="non_iv_MFR_dtls_<%=recCount%>" id="non_iv_MFR_dtls_<%=recCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openMFRDetails('<%=recCount%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=drug_code%>','<%=Store_locn_code%>','NotAdmin','','','','','','','Y');"><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label>&nbsp;&nbsp;&nbsp;&nbsp <a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=mfrRemarks%>','Y');" id='mfrRemarksLink_<%=recCount%>'>&nbsp;&nbsp;&nbsp;<font color="red"><b><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></b></font></a><%}else{%>
							&nbsp;&nbsp;&nbsp;
							<%}%></td>
							<input type="hidden" name="non_iv_mfrRemarks<%=recCount%>" id="non_iv_mfrRemarks<%=recCount%>" value="<%=mfrRemarks%>">
<%						}else{//ML-MMOH-CRF-1014- end
%>
									<td class="<%=classvalue%>" ><label style="font-size:9;font-weight;color:black"><%=sch_date_time%> </label></td>
<%
					}
								}
%>								<% AdminBackLogTime=bean.getAdminBackLogTime(sch_date_time);  %><!--  TTM-SCF-0171-907901-->
								<td class="<%=classvalue%>" style="<%=admin_disc_classValue%>">
									<input type="hidden" name="non_iv_sch_date_time_<%=recCount%>" id="non_iv_sch_date_time_<%=recCount%>" value="<%=sch_date_time%>">
									<input type="text" name="non_iv_time_<%=recCount%>" id="non_iv_time_<%=recCount%>" size="15" maxlength="16" value="<%=defaultDate.equals("")?current_date_time:defaultDate%>" <%=select_status%> onBlur="validateAdminDateTime('<%=AdminBackLogTime%>','<%=current_date_time%>', this,'<%=locale%>');" style="font-size:11;<%=addDisplayStyle%>;<%=admin_disc_classValue%>"><%-- removed <%=sch_date_time%> in validateAdminDateTime for AAKH-SCF-0219 [IN:057491] --%>
								</td>														
<%							
								if(!patient_brgt_medn.equals("Y")){										
									if(!(sliding_scale_applicable.equals("Y")&& batch_ids.size()==0)){		
										if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")||iv_prep_yn.equals("8")){
%>							
											<td class="<%=classvalue%>"><input type='checkbox'	name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','NOT','<%=iv_prep_yn%>','<%=order_line_num%>');"	disabled></td>
											<td class="<%=classvalue%>" style="">
											<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>"  size="9" maxlength="10" value="<%=(String)work_sheet_batch_det1.get(1)%>"  disabled > 
											<input type="hidden" name="previous_non_iv_batch_id_<%=recCount%>" id="previous_non_iv_batch_id_<%=recCount%>" value="<%=(String)work_sheet_batch_det1.get(1)%>">
											<input type="hidden" name="previous_non_iv_exp_date_<%=recCount%>" id="previous_non_iv_exp_date_<%=recCount%>" value="<%=(String)work_sheet_batch_det1.get(2)%>">
											<input type="hidden" name="previous_non_iv_trade_id_<%=recCount%>" id="previous_non_iv_trade_id_<%=recCount%>" value="">
											<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value="<%=order_id%>"> <!-- GHL-CRF-0482-->
											<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value="<%=order_line_num%>"><!-- GHL-CRF-0482-->

<%					
										}
										else if(batch_ids.size()==0){
												
											if(Storelocn_code.equals(""))
												Storelocn_code=Store_locn_code;
											if(Auto_Admin.equals("N"))
												auto_Admin_dis="disabled";
											else 
												auto_Admin_dis="";
											bat_id_lookbutton_enabled="Y";
											if(auto_Admin_dis.equals("disabled")||select_status.equals("disabled")){
												bat_id_lookbutton_enabled="N";
											}
											if(iv_prep_yn.trim().length()!=0)
												shared_drug_disp = "display:none";
%>
											<td class="<%=classvalue%>" ><input type='checkbox' name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','<%=bat_id_lookbutton_enabled%>','<%=iv_prep_yn%>','<%=order_line_num%>','<%=verify_adm_drug%>');"></td> <!-- verify_adm_drug added for Added for AAKH-CRF-0084 [IN060429] -->
											<td class="<%=classvalue%>" style="">
<%                                          
                                            if(verify_adm_drug){ // if,else Added for AAKH-CRF-0084 [IN060429] 
%>
											<input type='checkbox' name='non_iv_shared_drug_<%=recCount%>' id='non_iv_shared_drug_<%=recCount%>' title='Shared Drug' value="N" onclick="chkShrdDrug(this,'<%=recCount%>','<%=verify_adm_drug%>')" style='<%=shared_drug_disp%>' <%=auto_Admin_dis%> > 
<%                                          
                                            } else{ 
%>
											<input type='checkbox' name='non_iv_shared_drug_<%=recCount%>' id='non_iv_shared_drug_<%=recCount%>' title='Shared Drug' value="N" onclick="chkShrdDrug(this,'<%=recCount%>')" style='<%=shared_drug_disp%>'>
<%
                                            } 
%>
											<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="7" maxlength="10" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>"  style="font-size:11;<%=addDisplayStyle%>" disabled> 
											<input type="button" class="button" value="?" name="non_iv_batch_id_but_<%=recCount%>" id="non_iv_batch_id_but_<%=recCount%>" <%=select_status%> <%=auto_Admin_dis%> onClick="calcQuantityInDispensingUOM('NONIV','<%=recCount%>');callMednBatchSearch('non_iv_batch_id_<%=recCount%>','non_iv_expiry_date_<%=recCount%>','non_iv_trade_name_<%=recCount%>','non_iv_trade_id_<%=recCount%>','non_iv_bin_code_<%=recCount%>',document.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_<%=recCount%>.value,'<%=recCount%>','non_iv_time_<%=recCount%>','<%=Storelocn_code%>','NONIV','<%=recCount%>')" style="<%=addDisplayStyle%>">
									 	        <img src="../../eCommon/images/mandatory.gif" align="center" name="batch_id_mand_<%=recCount%>" style="visibility:hidden;"></img> <!-- Added for AAKH-CRF-0084 [IN060429] -->
											<input type='hidden' name="Newly_administerderd_<%=recCount%>" id="Newly_administerderd_<%=recCount%>" value='NONIV_Y'>
													
											<input type="hidden" name="previous_non_iv_batch_id_<%=recCount%>" id="previous_non_iv_batch_id_<%=recCount%>" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>">
											<input type="hidden" name="previous_non_iv_exp_date_<%=recCount%>" id="previous_non_iv_exp_date_<%=recCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
											<input type="hidden" name="previous_non_iv_trade_id_<%=recCount%>" id="previous_non_iv_trade_id_<%=recCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
											<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value="<%=order_id%>"> <!-- GHL-CRF-0482-->
											<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value="<%=order_line_num%>"><!-- GHL-CRF-0482-->

											<script>//Added for Bru-HIMS-CRF-399 [IN:043767] 
												if(document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_<%=recCount%>.value ==''){								
													document.getElementById("id_dispdrugdesc_"+<%=recCount%>).innerHTML = '';
													document.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_<%=recCount%>.value = '<%=drug_code%>';
												}
											</script>
<%
										}
										else if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 //changed 7 to 9 for GHL-CRF-0482
											expiry_date = (String)batch_ids.get(1);
											trade_id    = (String)batch_ids.get(2);
											tradename   = (String)batch_ids.get(3);
											select_status="disabled";
%>
											<script>//Added for Bru-HIMS-CRF-399 [IN:043767]
											 document.getElementById("alternate_image_"+<%=recCount%>).style.display="none";
											</script>
<%											
											totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,adminFromDateTime,adminToTime,order_id,order_line_num);
											for(int j=0;j<totQty.size();j=j+4){
												returned_qty = (Float)totQty.get(j+2);
												tot_administered_qty=  (Float)totQty.get(j+3);
											} 
											WardReturnQty =(ArrayList)bean.getWardRetrunQty(patient_id,order_id,performingDeptLocCode,facility_id);
											
											for(int k=0;k<WardReturnQty.size();k=k+2){
												disp_qty =(Float)WardReturnQty.get(k);
												ward_return_qty =(Float)WardReturnQty.get(k+1);
											}
											ret_qty=disp_qty-(returned_qty+ward_return_qty+tot_administered_qty);
											if(ret_qty<=0){
%>
												<td class="<%=classvalue%>"><input type='checkbox' name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','N','<%=iv_prep_yn%>','<%=order_line_num%>');" disabled></td>
												<td class="<%=classvalue%>" style="">
												<input type='hidden' name='non_iv_shared_drug_<%=recCount%>' id='non_iv_shared_drug_<%=recCount%>' value="N"><!--Added for HSA-CRF-0090[IN041241]-->
												<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value="<%=(String)batch_ids.get(0)%>" disabled style="font-size:11;"><input type="button" class="button" name="non_iv_batch_id_but_<%=recCount%>" id="non_iv_batch_id_but_<%=recCount%>" value="?"  <%=select_status%> onClick="calcQuantityInDispensingUOM('NONIV','<%=recCount%>');callMednBatchSearch('non_iv_batch_id_<%=recCount%>','non_iv_expiry_date_<%=recCount%>','non_iv_trade_name_<%=recCount%>','non_iv_trade_id_<%=recCount%>','non_iv_bin_code_<%=recCount%>','<%=drug_code%>','<%=recCount%>','non_iv_time_<%=recCount%>','<%=store_code%>','NONIV','<%=recCount%>')" style="<%=addDisplayStyle%>">
												<input type="hidden" name="previous_non_iv_batch_id_<%=recCount%>" id="previous_non_iv_batch_id_<%=recCount%>" value="<%=(String)batch_ids.get(0)%>">
												<input type="hidden" name="previous_non_iv_exp_date_<%=recCount%>" id="previous_non_iv_exp_date_<%=recCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">	
												<input type="hidden" name="previous_non_iv_trade_id_<%=recCount%>" id="previous_non_iv_trade_id_<%=recCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<% 
											}
											else{
												expiry_date="";
												select_status="";
%>
												<td class="<%=classvalue%>"><input type=checkbox name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','N','<%=iv_prep_yn%>','<%=order_line_num%>');" disabled></td>
												<td class="<%=classvalue%>" style="">
												<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value="" disabled style="font-size:11;"><input type="button" class="button" name="non_iv_batch_id_but_<%=recCount%>" id="non_iv_batch_id_but_<%=recCount%>" value="?"  <%=select_status%> onClick="calcQuantityInDispensingUOM('NONIV','<%=recCount%>');callMednBatchSearch('non_iv_batch_id_<%=recCount%>','non_iv_expiry_date_<%=recCount%>','non_iv_trade_name_<%=recCount%>','non_iv_trade_id_<%=recCount%>','non_iv_bin_code_<%=recCount%>','<%=drug_code%>','<%=recCount%>','non_iv_time_<%=recCount%>','<%=store_code%>','NONIV','<%=recCount%>')" style="<%=addDisplayStyle%>">
												<input type="hidden" name="previous_non_iv_batch_id_<%=recCount%>" id="previous_non_iv_batch_id_<%=recCount%>" value="<%=(String)batch_ids.get(0)%>">
												<input type="hidden" name="previous_non_iv_exp_date_<%=recCount%>" id="previous_non_iv_exp_date_<%=recCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">	
												<input type="hidden" name="previous_non_iv_trade_id_<%=recCount%>" id="previous_non_iv_trade_id_<%=recCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
											} %>
											<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value="<%=(String)batch_ids.get(7)%>"> <!-- GHL-CRF-0482-->
											<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value="<%=(String)batch_ids.get(8)%>"><!-- GHL-CRF-0482-->
<%										}
										else{
%>
											<script>//Added for Bru-HIMS-CRF-399 [IN:043767]
											 document.getElementById("alternate_image_"+<%=recCount%>).style.display="none";
											</script>
											<td class="<%=classvalue%>" ><input type=checkbox name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','NOT','<%=iv_prep_yn%>','<%=order_line_num%>','<%=verify_adm_drug%>');" disabled></td> <!-- verify_adm_drug added for AAKH-CRF-0084 disabled added for GHL-CRF-0482-->
											<td class="<%=classvalue%>" style="">
											<input type='hidden' name='non_iv_shared_drug_<%=recCount%>' id='non_iv_shared_drug_<%=recCount%>' value="N" ><!--Added for HSA-CRF-0090[IN041241]-->
											<select name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" style="font-size:11;<%=addDisplayStyle%>" onChange="assignBatchDetails('<%=mode%>','NON_IV',this,'<%=recCount%>','NOT_MFR','<%=disp_drug_code%>','<%=drug_code%>','<%=qty%>','<%=order_id%>','<%=order_line_num%>','<%=freq_nature%>','N','<%=disp_drugs%>')"> <!-- NOT_MFR Added for AAKH-SCF-0276 --><!-- disp_drug_code,order_id,order_line_num,Freq_nature,disp_drugs added for BRU-CRF-399.1-->
											<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
											for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 //changed 7 to 9 for GHL-CRF-0482
												if (defaultBatch.equals((String)batch_ids.get(kk))){
%>
													<option  selected value="<%=(String)batch_ids.get(kk)%>"><%=(String)batch_ids.get(kk)%></option>
													<input type="hidden" name="previous_non_iv_batch_id_<%=recCount%>" id="previous_non_iv_batch_id_<%=recCount%>" value="<%=(String)batch_ids.get(kk)%>">
													<input type="hidden" name="previous_non_iv_exp_date_<%=recCount%>" id="previous_non_iv_exp_date_<%=recCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
													<input type="hidden" name="previous_non_iv_trade_id_<%=recCount%>" id="previous_non_iv_trade_id_<%=recCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
												}
												else{
%>
													<option  value="<%=(String)batch_ids.get(kk)%>"><%=(String)batch_ids.get(kk)%></option>
<%
												}
											}
%>						
											</select>					
											<img src="../../eCommon/images/mandatory.gif" align="center" name="batch_id_mand_<%=recCount%>" style="visibility:hidden;"></img> <!-- Added for AAKH-CRF-0084 [IN060429] -->
											<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value=""> <!-- GHL-CRF-0482-->
											<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value=""><!-- GHL-CRF-0482-->
<%
										}
											int mm=1;
						//added for BRU-CRF-399.1 - start
						for(int kk=0;kk<batch_ids.size();kk=kk+9){ //6 to 7 for GHL-CRF-0458 //changed 7 to 9 for GHL-CRF-0482
%>
							<input type="hidden" name="non_iv_barcode_id_<%=recCount%>_<%=mm%>" id="non_iv_barcode_id_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+5)%>">
						  <input type="hidden" name="non_iv_alt_drug_code_<%=recCount%>_<%=mm%>" id="non_iv_alt_drug_code_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+4)%>">
						  <input type="hidden" name="non_iv_batch_id_alt_<%=recCount%>_<%=mm%>" id="non_iv_batch_id_alt_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk)%>">
						  <input type="hidden" name="non_iv_batch_order_id_<%=recCount%>_<%=mm%>" id="non_iv_batch_order_id_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+7)%>">  <!-- GHL-CRF-0482-->
						<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>_<%=mm%>" id="non_iv_batch_order_line_no_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+8)%>"> <!-- GHL-CRF-0482-->

<%							mm++;//CRF-399.1

					

						}
%>
										</td>
										<td class="<%=classvalue%>" style="">
											<input type="text" name="non_iv_expiry_date_<%=recCount%>" id="non_iv_expiry_date_<%=recCount%>" size="7" maxlength="10"  value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>" disabled style="font-size:11;<%=addDisplayStyle%>" onblur="ExpiryDateValidationForPatBroughtMedn(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='exp_dt_cal_<%=recCount%>' onClick=" showCalendar('non_iv_expiry_date_<%=recCount%>');" style="visibility:hidden;display:none" > 
										        <img src="../../eCommon/images/mandatory.gif" align="center" name="exp_dt_mand_<%=recCount%>" style="visibility:hidden;" > <!-- Added for AAKH-CRF-0084 [IN060429] -->
										</td>
<%
									} 
									else{
%>	
										<td class="<%=classvalue%>" ><input type=checkbox name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','N','<%=iv_prep_yn%>','<%=order_line_num%>');"></td>
										<td class="<%=classvalue%>" style="">
										<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value=""  style="font-size:11;<%=addDisplayStyle%>" disabled><input type="button" name="non_iv_batch_id_but_<%=recCount%>" id="non_iv_batch_id_but_<%=recCount%>" class="button" value="?" disabled 
										onClick="" style="<%=addDisplayStyle%>">
										</td>
										<td class="<%=classvalue%>" style="">
										<input type="text" name="non_iv_expiry_date_<%=recCount%>" id="non_iv_expiry_date_<%=recCount%>" size="9" maxlength="10"  value="" disabled onblur="ExpiryDateValidationForPatBroughtMedn(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='exp_dt_cal_<%=recCount%>' onClick=" showCalendar('non_iv_expiry_date_<%=recCount%>');" style="visibility:hidden;display:none" >
										</td>
<%
									}
								}
								else{								
%>
									<td class="<%=classvalue%>" ><input type='checkbox' name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" checked disabled></td>
									<td class="<%=classvalue%>" style="">
									<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value=""  style="font-size:11;<%=addDisplayStyle%>"><input type="button" class="button" value="?" disabled onClick="" style="<%=addDisplayStyle%>"  name="non_iv_batch_id_but_<%=recCount%>">
									</td>
									<td class="<%=classvalue%>" style="">
									<input type="text" name="non_iv_expiry_date_<%=recCount%>" id="non_iv_expiry_date_<%=recCount%>" size="9" maxlength="10"  value="" onblur="ExpiryDateValidationForPatBroughtMedn(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='exp_dt_cal_<%=recCount%>' onClick=" showCalendar('non_iv_expiry_date_<%=recCount%>');">
									</td>
<%
								}
%>
								<td class="<%=classvalue%>" style="display:none">
								<input type="hidden" name="non_iv_trade_id_<%=recCount%>" id="non_iv_trade_id_<%=recCount%>" value="<%=trade_id%>" >
								<input type="hidden" name="non_iv_bin_code_<%=recCount%>" id="non_iv_bin_code_<%=recCount%>" value="" >
								<input type="hidden" name="non_iv_trade_name_<%=recCount%>" id="non_iv_trade_name_<%=recCount%>" size="21" maxlength="40" disabled value="<%=defaultTradeId.equals("")?tradename:defaultTradeId%>" style="font-size:11;<%=addDisplayStyle%>">
								</td>
<%
								if(!stat_style.equals("") && freq_nature.equals("O")){
									stat_title	=	"title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.STATDose.label", "ph_labels")+"'";
								}
								else if(!stat_style.equals("") && freq_nature.equals("P")){
									stat_title	=	"title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PRNDose.label", "ph_labels")+"'";
								}
								else{
									stat_title	=	"";
								}
								if(patient_brgt_medn.equals("Y")){
									mand_display="style='display:inline'";	
								}
%>
								<td class="<%=classvalue%>" style="<%=stat_style%>" <%=stat_title%>>
<%
								if(!(iv_prep_yn.equals("9")&&!(order_line_num.equals("1")))){%>
									<label name="non_iv_remarks_<%=recCount%>" style="<%=dtl_style%>" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=recCount%>','<%=drug_code%>','SCH','','','<%=freq_code%>','','','<%=order_id%>','<%=order_line_num%>','<%=encounter_id%>','<%=medn_admn_dtl_reqd_yn%>','<%=iv_prep_yn%>',document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_<%=recCount%>,  '','<%=sch_date_time%>','', true, '', '', '' , '<%=administered%>','<%=admin_recorded_yn%>','<%=admin_discontinue%>' );" style="<%=addDisplayStyle%>"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="drug_remarks_mand_id_<%=recCount%>"  <%=mand_display%>></img>
<%
								}
								else{ 	
									if(mand_display.equals("style='display:inline'")){
%>									
										<script>mandSymbolDisplayForOncology('ONLOAD','<%=recCount%>','<%=order_line_num%>','<%=medn_admn_dtl_reqd_yn%>')</script>
<%
									}
								}
%>
								<input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" checked style='display:none;'>
								<input type="checkbox" name="non_iv_chk_<%=recCount%>" id="non_iv_chk_<%=recCount%>" value="E" checked style='display:none;'>
								</td>	
								<%
							//added for GHL-CRF-0482 - start
									if(isSite_spec_patient_stock){
								%>
								<td style="font-size:09;" class="<%=classvalue%>">
								<input type="checkbox" name="non_iv_patient_stock_<%=recCount%>" id="non_iv_patient_stock_<%=recCount%>"  value="<%=patient_stock_completed%>" onclick="PatientStockCheck(this,'<%=order_id%>','<%=order_line_num%>','Y','<%=recCount%>')" <%=patient_stock_checked%> style="<%=patient_stock_check_display%>" <%=patient_stock_disabled%> >
								</td> <!-- GHL-CRF-0482 end-->
								<%}%>
								<input type="hidden" name="non_iv_mand_symbol_<%=recCount%>" id="non_iv_mand_symbol_<%=recCount%>" value="<%=mand_display%>">				
<%
								if(sliding_scale_applicable.equals("Y") && batch_ids.size()==0){	
									select_status_1="disabled";
								}
								String fieldname="non_iv_admin_qty_"+recCount;
								String short_desc1=short_desc;
								if(freq_nature.equals("P")){
									fieldname   = "non_iv_admin_qty1_"+recCount;
									short_desc1 = schedule_uom_desc; 
									pres_dosage = tempDosage;
								}
%>
								</tr>
<%
								altRecCount=0;
								if( multi_drugs.size()>0){
									no_of_alt_drus_selected ++;
								if(iv_prep_yn.trim().length()!=0 || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
									shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
								else
									shared_drug_disp = "";
									for(int n=0; n<multi_drugs.size(); n+=5){ 
										altRecCount++;
										String alt_drug_code			=	(String)multi_drugs.get(n);
										String alt_drug_desc			=   (String)multi_drugs.get(n+1);
										String alt_qty=(String)multi_drugs.get(n+3);
										String alt_qty_uom =(String)multi_drugs.get(n+4);
										ArrayList alt_batch_ids = bean.getAllBatchIDS(order_id,order_line_num,"N");
										String alt_expiry_date = "";
										String alt_trade_id	   = "";
										String alt_trade_name  = "";
%>
										<tr >
											<td class="white" style="background:#CC99CC" width='2%'>&nbsp;</td>
											<td style="font-size:09;" style="color:#CC99CC" color="#CC99CC" class="<%=classvalue%>">&nbsp;&nbsp;&nbsp;&nbsp;<b><%=alt_drug_desc%></b>
											<input type="hidden" name="alt_drug_code_<%=altRecCount%>" id="alt_drug_code_<%=altRecCount%>" value="<%=alt_drug_code%>">
											<input type="hidden" name="main_drug_code_<%=altRecCount%>" id="main_drug_code_<%=altRecCount%>" value="<%=drug_code%>">
											<input type="hidden" name="alt_dosage_seq_no_<%=altRecCount%>" id="alt_dosage_seq_no_<%=altRecCount%>" value="<%=dosage_seq_no%>">
											<input type="hidden" name="alt_item_code_<%=altRecCount%>" id="alt_item_code_<%=altRecCount%>" value="<%=item_code%>">
											<input type="hidden" name="alt_order_id_<%=altRecCount%>" id="alt_order_id_<%=altRecCount%>" value="<%=order_id%>">
											<input type="hidden" name="alt_order_line_num_<%=altRecCount%>" id="alt_order_line_num_<%=altRecCount%>" value="<%=order_line_num%>">
											</td>
											<td style="font-size:09;" class="<%=classvalue%>">&nbsp;&nbsp;</td>
											<td style="font-size:09;" class="<%=classvalue%>">&nbsp;&nbsp;</td>
											<td style="font-size:09;" class="<%=classvalue%>">&nbsp;&nbsp;</td>
											<td style="font-size:09;" class="<%=classvalue%>">&nbsp;&nbsp;</td>
											<td style="font-size:09;" class="<%=classvalue%>">
											<input type="text" name="alt_admin_qty_<%=altRecCount%>" id="alt_admin_qty_<%=altRecCount%>" size="1" maxlength="4" onKeyPress="return allowValidNumber(this,event,6,3);" onBlur="CheckNum(this); makeDtlsMandatory(this,'<%=altRecCount%>','<%=drug_code%>','alt','<%=freq_nature%>');" value="<%=alt_qty%>" class="NUMBER" style="font-size:11"><label style="font-size:10" id=""><b><%=alt_qty_uom%></b></label> 

											<input type="hidden" name="h_alt_admin_qty_<%=altRecCount%>" id="h_alt_admin_qty_<%=altRecCount%>" value="<%=alt_qty%>">
											<input type="hidden" name="alt_admin_qty_uom_<%=altRecCount%>" id="alt_admin_qty_uom_<%=altRecCount%>" value="<%=alt_qty_uom%>">
											<input type="hidden" name="alt_store_code_<%=altRecCount%>" id="alt_store_code_<%=altRecCount%>" value="<%=store_code%>">
											<input type="hidden" name="alt_end_date_<%=altRecCount%>" id="alt_end_date_<%=altRecCount%>" value="<%=end_date_time%>">
											<input type="hidden" name="alt_admin_chng_dtls_req_<%=altRecCount%>" id="alt_admin_chng_dtls_req_<%=altRecCount%>" value="N">
											</td>
											<td class="<%=classvalue%>" style="color:<%=fntColor%>;background-color:<%=backGrndColor%>;font-size:10;"><label style="font-size:10;"> <%=route_desc%></label></td>
											<td style="font-size:09;" class="<%=classvalue%>">
											<input type="text" name="alt_schedule_time_<%=altRecCount%>" id="alt_schedule_time_<%=altRecCount%>" size="5" maxlength="5" value="" readOnly style="font-size:11;text-align:right">
											</td>
											<td style="font-size:09;" class="<%=classvalue%>">
											<input type="hidden" name="alt_schedule_date_time_<%=altRecCount%>" id="alt_schedule_date_time_<%=altRecCount%>" value="<%=sch_date_time%>">
											<input type="text" name="alt_time_<%=altRecCount%>" id="alt_time_<%=altRecCount%>" size="15" maxlength="16" value="<%=current_date_time%>" onBlur="validateAdminDateTime('<%=AdminBackLogTime%>','<%=current_date_time%>', this,'<%=locale%>');" style="font-size:11" onBlur="">
											</td>
											<td style="font-size:09;" class="<%=classvalue%>">
<%
											if(alt_batch_ids.size()==0){
%>												
												<input type='checkbox' name='alt_shared_drug_<%=altRecCount%>' id='alt_shared_drug_<%=altRecCount%>' title='Shared Drug' value="N" onclick="chkShrdDrug(this,'<%=altRecCount%>')" style='<%=shared_drug_disp%>'><!--Added for HSA-CRF-0090[IN041241]-->
												<input type="text" name="alt_batch_id_<%=altRecCount%>" id="alt_batch_id_<%=altRecCount%>" size="9" maxlength="10" value="<%=defaultBatch%>" style="font-size:11" disabled>
												<input type="button" class="button" value="?" onClick="calcQuantityInDispensingUOM('ALT','<%=altRecCount%>');callMednBatchSearch('alt_batch_id_<%=altRecCount%>','alt_expiry_date_<%=altRecCount%>','alt_trade_name_<%=altRecCount%>','alt_trade_id_<%=altRecCount%>','alt_bin_code_<%=altRecCount%>','<%=drug_code%>','<%=altRecCount%>','alt_time_<%=altRecCount%>','<%=store_code%>','ALT','<%=altRecCount%>')" >
<%
											}
											else if(alt_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8//changed 7 to 9 for GHL-CRF-0482
												alt_expiry_date = (String)alt_batch_ids.get(1);
												alt_trade_id    = (String)alt_batch_ids.get(2);
												alt_trade_name  = (String)alt_batch_ids.get(3);
%>												<input type='hidden' name='alt_shared_drug_<%=altRecCount%>' id='alt_shared_drug_<%=altRecCount%>' value="N" ><!--Added for HSA-CRF-0090[IN041241]-->
												<select name="alt_batch_id_<%=altRecCount%>" id="alt_batch_id_<%=altRecCount%>" style="font-size:11;">
													<option value="<%=(String)alt_batch_ids.get(0)%>"><%=(String)alt_batch_ids.get(0)%></option>
												</select>					
<%
											}
											else{
%>												<input type='hidden' name="alt_shared_drug_<%=altRecCount%>" id="alt_shared_drug_<%=altRecCount%>" value="N" ><!--Added for HSA-CRF-0090[IN041241]-->
												<select name="alt_batch_id_<%=altRecCount%>" id="alt_batch_id_<%=altRecCount%>" style="font-size:11;" onChange="assignBatchDetails('<%=mode%>','ALT_NON_IV',this,'<%=altRecCount%>','','<%=disp_drug_code%>','<%=drug_code%>','<%=qty%>','<%=order_id%>','<%=order_line_num%>','<%=freq_nature%>','N','<%=disp_drugs%>')">
												<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
												for(int kk=0;kk<alt_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8//changed 7 to 9 for GHL-CRF-0482
													if (defaultBatch.equals((String)alt_batch_ids.get(kk))){
%>
													<option selected value="<%=(String)alt_batch_ids.get(kk)%>"><%=(String)alt_batch_ids.get(kk)%></option>
<%
													}
													else{
%>
														<option value="<%=(String)alt_batch_ids.get(kk)%>"><%=(String)alt_batch_ids.get(kk)%></option>
<%
													}
												}
%>						
												</select>					
<%
											}
%>					
											</td>
											<td style="font-size:09;" class="<%=classvalue%>">
												<input type="text" name="alt_expiry_date_<%=altRecCount%>" id="alt_expiry_date_<%=altRecCount%>" size="9" maxlength="10"  value="<%=alt_expiry_date%>" disabled style="font-size:11">
											</td>
											<td style="font-size:09;" class="<%=classvalue%>" style="display:none">
												<input type="hidden" name="alt_trade_name_<%=altRecCount%>" id="alt_trade_name_<%=altRecCount%>" size="21" maxlength="40" disabled value="<%=alt_trade_name%>" style="font-size:11">
												<input type="hidden" name="alt_trade_id_<%=altRecCount%>" id="alt_trade_id_<%=altRecCount%>" value="<%=alt_trade_id%>" >
												<input type="hidden" name="alt_bin_code_<%=altRecCount%>" id="alt_bin_code_<%=altRecCount%>" value="" >
											</td>
											<td style="font-size:09;" class="<%=classvalue%>">
												<label name="alt_remarks_<%=altRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center" onClick="enterRemarks('<%=alt_drug_desc%>','<%=drug_class%>','<%=altRecCount%>','<%=alt_drug_code%>','SCH','','','<%=freq_code%>','','','','','','','<%=iv_prep_yn%>', document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_<%=recCount%>,'','<%=sch_date_time%>,'', true, '', '','' , '<%=administered%>','<%=admin_recorded_yn%>','<%=admin_discontinue%>' )"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></label>&nbsp;
												<img src="../../eCommon/images/mandatory.gif" align="center" id="alt_drug_remarks_mand_id_<%=altRecCount%>" ></img>
												<input type="hidden" name="alt_mand_symbol_<%=altRecCount%>" id="alt_mand_symbol_<%=altRecCount%>" value="style='display:inline'">
												<input type="checkbox" name="chk_alt_non_iv_select_<%=altRecCount%>" id="chk_alt_non_iv_select_<%=altRecCount%>" value="E" checked style='display:none;'>
											</td>
										</tr>
<%	
									}
								}
%>								<input type="hidden" name="non_iv_scanned_batch_yn_<%=recCount%>" id="non_iv_scanned_batch_yn_<%=recCount%>" value=""><!--added for MMS-DM-SCF-0447 -->				
								<input type="hidden" name="patient_brgt_medn_<%=recCount%>" id="patient_brgt_medn_<%=recCount%>" value="<%=patient_brgt_medn%>"><!-- added for GHL-CRF-0482-->

							
<%
						}
%>	</table><input type="hidden" name="isSite_spec_patient_stock" id="isSite_spec_patient_stock" value = "<%=isSite_spec_patient_stock%>">
<%						}
					}
					else if(callFrom.equals("adminIV")){
						drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,order_id,shedule_date_time,drugCode,hold_discontinue_yn,"","IVRx","","","",patient_id,"");
						ArrayList iv_drug_details = null;
						if(drug_details!=null){
							iv_drug_details =	 (ArrayList) drug_details.get("IV");
						}
						if(iv_drug_details!=null && iv_drug_details.size()>0){
%>
							<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1"  noresize>
								<tr id="iv_admin_table_row1">
								<td class="TDSTYLE" width="2%">&nbsp;</td>
								<td class="TDSTYLE"  width="28%"><B><fmt:message key="ePH.Fluid/Ingrediant.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE" width="2%">&nbsp;</td>
								<td class="TDSTYLE" width="2%">&nbsp;</td>
								<td class="TDSTYLE" width="4%">&nbsp;</td>
								<td class="TDSTYLE" width="6%"><B><fmt:message key="ePH.AdminDose.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE" width="6%"><B><fmt:message key="Common.UnitDose.label" bundle="${common_labels}"/></B></td>
								<td class="TDSTYLE" width="9%"><B><fmt:message key="ePH.RouteOfAdministration.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE" width="8%"><B><fmt:message key="ePH.SchTime.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE" width="10%"><B><fmt:message key="ePH.InfusionDate/Time.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE" width="7%"><B><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE" width="7%"><B><fmt:message key="ePH.InfusionPeriod.label" bundle="${ph_labels}"/></B></td>
								<td class="TDSTYLE" width="11%"><B><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></B></td><!--Modified for HSA-CRF-0090[IN041241]-->
								<td class="TDSTYLE" width="9%"><B><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></B></td>
								<td class="TDSTYLE" width="12%"><B><fmt:message key="ePH.AdminDtls.label" bundle="${ph_labels}"/></B></td>
								</tr>
								<tr>
									<td class='COLUMNHEADER'  colspan="16"   style="font-size:10"><b><fmt:message key="ePH.IVAdministration.label" bundle="${ph_labels}"/></b></td>
								</tr>
<%
								String sch_infusion_rate        =   "";
								String sch_infusion_vol_str_unit=   "";
								String sch_infusion_vol_str_unit_desc =   "";
								String sch_infusion_per_unit    =   "";
								String sch_infusion_per_unit_table_date = "";
								String trade_name               =   "";
								String qty_uom					=   "";
								String sch_infusion_period		=   "";
								String sch_infusion_period_unit =   "";
								String sch_infusion_period_unit_label =   "";
								classvalue						=	"";
								String unit_dose				=   "";
								String no_of_doses				=   "";
								dosage_seq_no			        =   "";
								String hide_ingredient_dtls		=   "";
								iv_prep_yn						=	"";
								String prod_name				=	"";
								String cmp_flag                 =   "";
								String sch_infusion_in_min      =   "";
								String tol_title                =   "";
								String iv_no_of_drug_per_order  =   "1";
								String MfrYN					=	"N";
								String sfrFLOW_STATUS			=	"";
								String sfrHOLD_DATE_TIME		=	"";
								String sfrHOLD_DURN_IN_MINS		=	"";
								String sfrRESUME_DATE_TIME		=	"";
								String sfrACT_START_DATE_TIME	=	"";
								String sfrACT_END_DATE_TIME		=	"";
//								String mfrRemarks				=	"";
								String completedMinutes			=	"0";
								String completedFlow			=	"0";
								String iv_order_pract_id        =""; 
										dosage_type				=	"";
								String sch_dosage_uom_code		= "";//SKR-SCF-1240
		//						boolean mfrCompletedStatus		=	false;
								ArrayList MfrDetails			=	new ArrayList();
//								ArrayList arr_list_remarks		=   new ArrayList();
								ArrayList work_sheet_batch_det	=   new ArrayList();
								String could_not_administer="";
								ArrayList iv_batch_ids = new ArrayList();
								for(int i=0;i<iv_drug_details.size();i+=74){//Changed from 69 to 70 for SKR-SCF-0832[Inc : 44110] 73 CHANGED TO 74
									iv_order_pract_id  =  (String)iv_drug_details.get(i+68)==null?"":(String)iv_drug_details.get(i+68); 
									linkVacScheduleCode			="";
									dosage_seq_no	= iv_drug_details.get(i+36)==null?"":(String)iv_drug_details.get(i+36); 
									pres_catg_code =iv_drug_details.get(i+49)==null?"":(String)iv_drug_details.get(i+49); 
									auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);								
									auth_reqd_script="";
									if(auth_reqd){
										if(pin_value.equals(""))
											auth_reqd_script=";pinAuthentication(this,'NP');";
										else
											auth_reqd_script=";pinAuthentication(this,'YP');";
									}
									pract_id					= (String)iv_drug_details.get(i+37);
									against_sch_date			= (String)iv_drug_details.get(i+38);
									adr_reason					= (String)iv_drug_details.get(i+39);
									adr_remarks					= (String)iv_drug_details.get(i+40);
									adr_record_time				= (String)iv_drug_details.get(i+41);
									adr_recorded_by				= (String)iv_drug_details.get(i+42);
									iv_prep_yn					= (String)iv_drug_details.get(i+43);	
									freq_nature					= (String)iv_drug_details.get(i+35);
									flag						=	"Y";
									sch_infusion_rate			= (String)iv_drug_details.get(i+1);
									if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
										if(Float.parseFloat(sch_infusion_rate) < 1.0){ //added for IN25540 --20/12/2010-- priya
											sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
										}
									}
									sch_infusion_vol_str_unit	= (String)iv_drug_details.get(i+2)==null?"":(String)iv_drug_details.get(i+2);
									sch_infusion_vol_str_unit_desc = (String)iv_drug_details.get(i+66)==null?"":(String)iv_drug_details.get(i+66);
									sch_infusion_per_unit		= (String)iv_drug_details.get(i+3)==null?"":(String)iv_drug_details.get(i+3);																	if(adr_remarks ==null)
										adr_remarks ="";						
									route_desc					= (String)iv_drug_details.get(i+48);
									route_color                 = (String)iv_drug_details.get(i+67);//COde Check for ROute COlor
									if(route_color != "" && route_color != null && route_color.length()==12){
										fntColor = route_color.substring(0, 6);
										backGrndColor = route_color.substring(6, 12);
									}//Code Addd For RUT-CRF-0034 End
									patient_id					= (String)iv_drug_details.get(i+9);
									sch_infusion_per_unit_table_date = sch_infusion_per_unit;
														
									if(sch_infusion_per_unit.equals("H")){
										sch_infusion_per_unit = "Hrs";
										if(sch_infusion_rate!=null && !(sch_infusion_rate.equals(""))){												
											sch_infusion_in_min=roundDigits(Float.parseFloat(sch_infusion_rate)/60.0+"");
										}
										tol_title=sch_infusion_in_min+"&nbsp;ML/Minute"; 
									}
									else{
										sch_infusion_per_unit = "Mins";
										tol_title="";
									}
									batch_id                 =   (String)iv_drug_details.get(i+4)==null?"":(String)iv_drug_details.get(i+4);
									expiry_date              =   (String)iv_drug_details.get(i+5)==null?"":(String)iv_drug_details.get(i+5);
									trade_id                 =   (String)iv_drug_details.get(i+6)==null?"":(String)iv_drug_details.get(i+6);
									trade_name               =   (String)iv_drug_details.get(i+7)==null?"":(String)iv_drug_details.get(i+7);
									item_code                =   (String)iv_drug_details.get(i+8);
									drug_code                =   (String)iv_drug_details.get(i+10);
									drug_desc                =   (String)iv_drug_details.get(i+11);
									sch_date_time            =   (String)iv_drug_details.get(i+12);
									dosage_seq_no            =   (String)iv_drug_details.get(i+13);
									order_id                 =   (String)iv_drug_details.get(i+14);
									order_line_num           =   (String)iv_drug_details.get(i+15);
									qty						 =	 (String)iv_drug_details.get(i+16);
									if(Float.parseFloat(qty) < 1)
										qty="0"+qty; 
									qty_uom					 =	 (String)iv_drug_details.get(i+17);
									dis_continued			 =	 (String)iv_drug_details.get(i+18);
									hold					 =	 (String)iv_drug_details.get(i+19);
									sch_infusion_period		 =	 (String)iv_drug_details.get(i+20)==null?"":(String)iv_drug_details.get(i+20);	
									sch_infusion_period_unit =	 (String)iv_drug_details.get(i+21)==null?"":(String)iv_drug_details.get(i+21);
									administered			 =	 (String)iv_drug_details.get(i+22)==null?"N":(String)iv_drug_details.get(i+22);
									store_code				 =   (String)iv_drug_details.get(i+30);
									end_date_time 			 =   (String)iv_drug_details.get(i+33);
									freq_code				 =   (String)iv_drug_details.get(i+34);				
									
								if(iv_prep_yn!=null && (iv_prep_yn.equals("5") || (iv_prep_yn.equals("1") && order_line_num.equals("1")))) //SKR-SCF-1397 and iv_prep_yn.equals("1") added for SKR-SCF-1421
									no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num,iv_prep_yn,drug_code);
								else
									no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num);
									encode_drug_desc         =   drug_desc.replaceAll(" ","%20");
									encode_drug_desc         =   java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
									encode_drug_desc         =   encode_drug_desc.replaceAll("%2520","%20");						
									ext_prod_id              =   (String)iv_drug_details.get(i+44);
									iv_no_of_drug_per_order  =   (String)iv_drug_details.get(i+45);
									trade_code			     =   (String)iv_drug_details.get(i+46);
									imageFileURL			 =   (String)iv_drug_details.get(i+47);
									admn_dose_chng_reason_code = (String)iv_drug_details.get(i+52);
									sch_dosage_uom_code		 =	 (String)iv_drug_details.get(i+51); //SKR-SCF-1240
									Store_locn_code			 =	(String)iv_drug_details.get(i+65)==null?"":(String)iv_drug_details.get(i+65);
									 String iv_Auto_Admin               =   bean.getAutoAdminValue(facility_id,Store_locn_code);
									cmp_flag				 =   bean.syscomp(end_date_time,order_id,order_line_num);
									next_schd_date           =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);//added for SCF-7528
									linkVacScheduleCode		 =	(String)iv_drug_details.get(i+53);
									MfrYN					 =	(String)iv_drug_details.get(i+54)==null?"N":(String)iv_drug_details.get(i+54);
									sfrFLOW_STATUS			 =	(String)iv_drug_details.get(i+55)==null?"NS":(String)iv_drug_details.get(i+55);
									sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(i+56)==null?"":(String)iv_drug_details.get(i+56);
									sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(i+57)==null?"0":(String)iv_drug_details.get(i+57);
									sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(i+58)==null?"":(String)iv_drug_details.get(i+58);
									sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(i+59)==null?"":(String)iv_drug_details.get(i+59);
									//Added IF-Condition for converting date on 8/10/2010 regarding incident num:24067.==By Sandhya
									dispense_drug_code			= (String)iv_drug_details.get(i+72); //added for SKR-SCF-1240
									if(dispense_drug_code.equals("")) //added for SKR-SCF-1240
										dispense_drug_code = drug_code;
									if(!(sfrACT_START_DATE_TIME.equals(""))){
										sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
									} //Ends
									if(sfrACT_START_DATE_TIME.equals("")){
										sfrACT_START_DATE_TIME=current_date_time;
									
									}
									sfrACT_END_DATE_TIME	 =	(String)iv_drug_details.get(i+60)==null?"":(String)iv_drug_details.get(i+60);
									dosage_type				 =	(String)iv_drug_details.get(i+61)==null?"":(String)iv_drug_details.get(i+61);
									mfrRemarks				 =	(String)iv_drug_details.get(i+62)==null?"":(String)iv_drug_details.get(i+62);
									completedMinutes		 =	(String)iv_drug_details.get(i+63)==null?"0":(String)iv_drug_details.get(i+63);
									completedFlow			 =	(String)iv_drug_details.get(i+64)==null?"0":(String)iv_drug_details.get(i+64);
									adr_count			= bean.getADRCount(patient_id,drug_code);  //newly added for RUT-SCF-0144 [IN:033371] 

									if(!mfrRemarks.equals(""))
										mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");
									String sfrFLOW_STATUS_String="";
									String sfrFLOW_STATUS_disable="";
									String sfrFLOW_STATUS_style="";

									if(sfrFLOW_STATUS.equals("NS")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NOTSTARTED.label","ph_labels");
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";
									}
									else if(sfrFLOW_STATUS.equals("ST")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";
									}
									else if(sfrFLOW_STATUS.equals("HO")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOLD.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";

									}
									else if(sfrFLOW_STATUS.equals("RE")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:blue;align:center;cursor:pointer;";
									}
									else if(sfrFLOW_STATUS.equals("CO")){
										sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.COMPLETED.label","ph_labels");
										sfrFLOW_STATUS_disable="disabled";
										sfrFLOW_STATUS_style="font-size:8;color:black;align:center;cursor:pointer;";
									}
									if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
										linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);									
										if(!linkVacScheduleCode1.equals("NO DEFAULT")){
											try{
												linkVacScheduleYN="Y";
												vacScheduleDetails=linkVacScheduleCode.split("~",6);
												if(vacScheduleDetails.length>0){
													linkVacScheduleCode=vacScheduleDetails[0]+"~"+vacScheduleDetails[1]+"~"+vacScheduleDetails[2]+"~"+vacScheduleDetails[5];
													linkVacScheduleDescToolTip=vacScheduleDetails[3];
													linkVacScheduleDesc=vacScheduleDetails[4];
												}
											}
											catch(Exception execu){
												execu.printStackTrace();
											}
										}
										else{
											linkVacScheduleYN="Y";
											linkVacScheduleDescToolTip="";
											linkVacScheduleDesc="";
											vacScheduleDetails=linkVacScheduleCode.split("~");
											if(vacScheduleDetails.length>0){
												linkVacScheduleCode=vacScheduleDetails[1];
											}										
										}
									}
									else{
										linkVacScheduleYN="N";
										linkVacScheduleDescToolTip="";
										linkVacScheduleDesc="";
									}			
									select_status	=	"";
									dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";

									if(order_line_num != null && !order_line_num.equals("1"))
										hide_ingredient_dtls = "visibility:hidden;";
									else
										hide_ingredient_dtls = "";

									if(freq_nature!=null && freq_nature.equals("C")){
										if(!qty.equals("") && no_of_doses!= null && !no_of_doses.equals(""))
											unit_dose			 =  ((int)(Float.parseFloat(qty)/Float.parseFloat(no_of_doses)))+"";
									}

									if(freq_nature!=null && freq_nature.equals("O")) 
										stat_style	=	"background-color:#CE00CE";
									else
										stat_style	=	"";

									if(unit_dose!=null && unit_dose.equals("0"))
										unit_dose = "1";

									admin_recorded_yn		 = "Y";
									if(iv_drug_details.get(i+23)==null)
										admin_recorded_yn = "N";
									remarks = (String)iv_drug_details.get(i+24);				
									if(remarks==null)
										remarks="Not Entered";

									admin_by_name   = (String)iv_drug_details.get(i+26);
									auth_by_name    = (String)iv_drug_details.get(i+32);
									showTitle       = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"  : "+admin_by_name;
									if(auth_by_name!=null && !auth_by_name.equals(""))
										showTitle = showTitle + "\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name;
									admin_date_time = "";
									if(iv_drug_details.get(i+27)!= null)
										admin_date_time = (String)iv_drug_details.get(i+27);
									modified_date_time = "";
									if(iv_drug_details.get(i+28)!= null)
										modified_date_time = (String)iv_drug_details.get(i+28);				
									drug_class = (String)iv_drug_details.get(i+31);
									if(drug_class!=null && drug_class.equals("N"))
										drug_class_ind = "background:#66FFFF";
									else if(drug_class!=null && drug_class.equals("C"))
										drug_class_ind = "background:#CCFFCC";
									else
										drug_class_ind = "";
									if(sch_infusion_period_unit.equals("H"))
										sch_infusion_period_unit_label = "Hrs";
									else if(sch_infusion_period_unit.equals("M"))
										sch_infusion_period_unit_label = "Mins";
									displayStyle = "";
									if(freq_code!=null && freq_code.equals("STAT")) //added by abdul for SCF# 5899
										displayStyle	=	"background-color:#CE00CE;";
									else if(dis_continued.equals("Y"))
										displayStyle = "BACKGROUND-COLOR:red;";
									else if(hold.equals("Y"))
										displayStyle = "BACKGROUND-COLOR:yellow;";
									else if(admin_recorded_yn.equals("Y")){
										if(administered.equals("N")){
											displayStyle = "BACKGROUND-COLOR:#000000;cursor:pointer;";//added for AAKH-CRF-0024 [IN:038260]
											could_not_administer = "Y";//added for AAKH-CRF-0024 [IN:038260]
										}
										else{
											displayStyle = "BACKGROUND-COLOR:green;";
											could_not_administer="";//added for AAKH-CRF-0024 [IN:038260]
										}
									}
									administred_batch   = bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);
									administred_batch_id = administred_batch.get("BATCH_ID")==null?"":(String)administred_batch.get("BATCH_ID");						
									disp_batch_id		 = (String)administred_batch.get("DISP_BATCH_ID");	
									if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){	
										work_sheet_batch_det  =(ArrayList)bean.getProductName(order_id,order_line_num);
										prod_name	=	(String)work_sheet_batch_det.get(0);
										batch_id	=	(String)work_sheet_batch_det.get(1);								
										expiry_date	=	(String)work_sheet_batch_det.get(2);
										drug_code	= "FINAL PRODUCT";
									}
									else{
										prod_name	=	"";
										expiry_date=expiry_date.trim();
									 }
									adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
									adr_details	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+": " + com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+": "+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+": "+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;

									if(!admin_date_time.equals("")){
										img_path	=	"<img SRC='../../eOR/images/Authorized.gif' onClick=\"recordADR('"+encounter_id+"','"+drug_code+"','1',this,'"+sch_date_time+"','"+order_id+"')\" title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordPostAdministrationDetails.label", "ph_labels")+"' style='cursor:pointer'></img>";
									}
											
									pres_remarks			= bean.getPrescriptionInstructions(order_id);
									drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
									prn_remarks				= bean.getPRNInstructions(order_id,order_line_num);
									pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
									slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,order_line_num);
									verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);							
									nonMfrFluidRemarks		= "";
									if(iv_prep_yn.equals("5")){
										nonMfrFluidRemarks		= bean_all_stages.getNonMFRfluidRemarks(order_id,order_line_num);
									}
									overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
									show_remarks			= "N";
									if(ext_prod_id!=null && !ext_prod_id.equals("")){										
										if(overridereason.size()>1)
										   show_remarks="Y";
									}
									else{									
										if(overridereason.size()>0)
											   show_remarks="Y";
									}
									
									int pres_size = pres_remarks.length();
									int pres_col=2;
									if(pres_size >239)
										pres_col = pres_size/120;
										
									int pharm_size = pharma_remarks.length();
									int pharm_col=2;
									if(pharm_size >239)
										pharm_col = pharm_size/120;
														
									if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N") && nonMfrFluidRemarks.equals("")){
										remarks_style	=	"style='visibility:hidden'";
									}
									else {
										dialog_height = 0 ;
										if(!prn_remarks.trim().equals(""))
											dialog_height	 += 6.5;
										if(!drug_remarks.trim().equals(""))
											dialog_height	 += 6.5;
										if(!pres_remarks.trim().equals(""))
											dialog_height	 +=6.5;
										if(!slidingscaleremarks.trim().equals(""))
											dialog_height	 +=6.5;
										if(!pharma_remarks.trim().equals(""))
											dialog_height	 += 1.6*pharm_col;
										if(!verificationremarks.trim().equals(""))
											dialog_height	 += 6.5;
										if(!nonMfrFluidRemarks.trim().equals(""))
											dialog_height	 += 7.0;
										if(show_remarks.equals("Y"))
											dialog_height	 += 13;
										remarks_style	=	"style='visibility:visible'";
										if(dialog_height==18) 
											dialog_height = dialog_height-2;
										if(dialog_height==11)
											dialog_height = dialog_height-1;
										if(dialog_height==12)
											dialog_height = dialog_height-1;
										if(dialog_height>18) 
											dialog_height = dialog_height-2;
							
										dialog_height	 += 1.4;
									} 
									iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"N");
									if(order_line_num.equals("1"))
										classvalue="IVFLUID1";
									else
										classvalue="IVINGREDIENT1";
%>
									<tr>
<% 
									if(order_line_num.equals("1")) {
%>
										<td class="white" width="2%" style="<%=displayStyle%>">&nbsp;</td>
<%
									}
									else {
%>
										<td class="white" width="2%">&nbsp;</td>
<%
									}	
%>
									<td class="<%=classvalue%>" style="<%=drug_class_ind%>" title="<%=prod_name%>">
									<input type="hidden" name="iv_modified_date_time_<%=ivRecCount%>" id="iv_modified_date_time_<%=ivRecCount%>" value="<%=modified_date_time%>">	
									<input type="hidden" name="iv_dosage_seq_no_<%=ivRecCount%>" id="iv_dosage_seq_no_<%=ivRecCount%>" value="<%=dosage_seq_no%>">
									<input type="hidden" name="iv_drug_code_<%=ivRecCount%>" id="iv_drug_code_<%=ivRecCount%>" value="<%=drug_code%>">
									<input type="hidden" name="iv_item_code_<%=ivRecCount%>" id="iv_item_code_<%=ivRecCount%>" value="<%=item_code%>">
									<input type="hidden" name="iv_order_id_<%=ivRecCount%>" id="iv_order_id_<%=ivRecCount%>"  value="<%=order_id%>">
									<input type="hidden" name="iv_order_line_no_<%=ivRecCount%>" id="iv_order_line_no_<%=ivRecCount%>" value="<%=order_line_num%>">	
									<input type="hidden" name="iv_store_code_<%=ivRecCount%>" id="iv_store_code_<%=ivRecCount%>" value="<%=store_code%>">	
									<input type="hidden" name="iv_end_date_<%=ivRecCount%>" id="iv_end_date_<%=ivRecCount%>"   value="<%=end_date_time%>">
									<input type="hidden" name="next_schd_date_<%=ivRecCount%>" id="next_schd_date_<%=ivRecCount%>" value="<%=next_schd_date%>">
									<input type="hidden" name="iv_drug_class<%=ivRecCount%>" id="iv_drug_class<%=ivRecCount%>" value="<%=drug_class%>">
									<input type="hidden" name="iv_dtls_yn<%=ivRecCount%>" id="iv_dtls_yn<%=ivRecCount%>" value="N">
									<input type="hidden" name="iv_Remarks<%=ivRecCount%>" id="iv_Remarks<%=ivRecCount%>" value="N">
									<input type="hidden" name="iv_qty_in_disp_mode_<%=ivRecCount%>" id="iv_qty_in_disp_mode_<%=ivRecCount%>" value="">
<%
									if ((iv_prep_yn.equals("0"))||(iv_prep_yn.equals("2"))||(iv_prep_yn.equals("4"))||(iv_prep_yn.equals("6"))){
%>
										<label  id="drug_mast_det_1<%=recCount%>">&nbsp;</label>
<%
									}
									else{
%>
										<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=drug_code%>');" id="drug_mast_det_1<%=ivRecCount%>">&nbsp;+&nbsp;</label>
<%
									}
%>
									<label style="font-size:10;align:center"><%=drug_desc%>&nbsp;&nbsp;
<%
									if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){
%>
										<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ext_prod_id%>','<%=encode_drug_desc%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
									}
									if(imageFileURL!=null && !imageFileURL.equals("")){
%>
										<img src='../../ePH/images/camera.gif' width='17' height='15' onclick = "showImage('<%=drug_code%>','<%=trade_code%>');" onmouseover="changeCursor(this);">
<%
									}			
									if(adr_count>0){// added for RUT-SCF-0144 [IN:033371]  -- start
%>
										<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id%>','<%=drug_code%>');"></img>
<%
									} // added for RUT-SCF-0144 [IN:033371]  -- end
									if(prod_name.length()==0){
										if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
											<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" onmouseover="changeCursor(this);">
<%															
										}
									}
%>
									</label>
<%
									if(linkVacScheduleYN.equals("Y")){ 
										if(order_line_num.equals("1")){
%>
											<br> <label id='iv_link_vaccine_label_<%=ivRecCount%>' style="font-size:10;" title='<%=linkVacScheduleDescToolTip%>'> <fmt:message key="ePH.LinkVaccineShcedule.label" bundle="${ph_labels}"/> <input type='text' size=10 name='iv_link_vaccine_desc_<%=ivRecCount%>' id='iv_link_vaccine_desc_<%=ivRecCount%>' value='<%=linkVacScheduleDesc%>' disabled><input type='button'  class='button' value='?' name='iv_btn_link_vaccine_<%=ivRecCount%>' id='iv_btn_link_vaccine_<%=ivRecCount%>' onClick="linkVaccine('iv','<%=ivRecCount%>')"></label>
											<input type='hidden' name="iv_link_vaccine_code_<%=ivRecCount%>" id="iv_link_vaccine_code_<%=ivRecCount%>" value='<%=linkVacScheduleCode%>'>
<%
										}
									}
%>
									</td>
									<td class="<%=classvalue%>">&nbsp;</td>
									<td   class="<%=classvalue%>">
									<img src="../../ePH/images/DrugRemarks.gif" align="center" width="50%" height="60%" style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_num%>','<%=dialog_height%>','<%=encode_drug_desc%>','N')" title=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")%> <%=remarks_style%>></img>
									</td>
<%   
									if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){	
%> 
										<td   class="<%=classvalue%>"><label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','','MAR','<%=Store_locn_code%>','N','<%=MfrYN%>');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label></td>
<%					
									}
									else{
%>
										<td   class="<%=classvalue%>"><label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','<%=order_line_num%>','MAR','<%=Store_locn_code%>','N','<%=MfrYN%>');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label></td>
<%                 
									}
									if(freq_code.equals("STAT"))
										displayStyle="";
									if(Float.parseFloat(qty) < 1.0)
										qty = Float.parseFloat(qty)+""; //to prefix a zero
									if(MfrYN.equals("Y") && order_line_num.equals("1")){
%>
										<td  class="<%=classvalue%>">
										<input type="hidden" name="iv_admin_qty_<%=ivRecCount%>" id="iv_admin_qty_<%=ivRecCount%>" value="<%=qty%>">
										<input type="hidden" name="iv_qty_uom_<%=ivRecCount%>" id="iv_qty_uom_<%=ivRecCount%>" value="<%=qty_uom%>">
										<input type="hidden" name="h_iv_admin_qty_<%=ivRecCount%>" id="h_iv_admin_qty_<%=ivRecCount%>" value="<%=qty%>">
										<input type="hidden" name="iv_admin_chng_dtls_req_<%=ivRecCount%>" id="iv_admin_chng_dtls_req_<%=ivRecCount%>" value="N">
										<td class="<%=classvalue%>"  >&nbsp;</td>
										</td>
<%
									}
									else{
										if((hold.equals("Y")) || dis_continued.equals("Y")){
											sfrFLOW_STATUS_disable="disabled";
										}
										if(!dis_continued.equals("Y"))
											displayStyle="";
%>												
										<td  class="<%=classvalue%>">
										<input type="text" name="iv_admin_qty_<%=ivRecCount%>" id="iv_admin_qty_<%=ivRecCount%>" size="1" maxlength="4" value="<%=qty%>"  <%=sfrFLOW_STATUS_disable%> class="number" style="<%=displayStyle%>font-size:11;" onKeyPress="return allowValidNumber(this,event,6,3);" onBlur="CheckNum(this);changeDisplay(this,'<%=ivRecCount%>','<%=sch_infusion_per_unit_table_date%>');getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>'); makeDtlsMandatory(this,'<%=ivRecCount%>','<%=drug_code%>','iv','<%=freq_nature%>');">
										<input type="hidden" name="iv_qty_uom_<%=ivRecCount%>" id="iv_qty_uom_<%=ivRecCount%>" value="<%=qty_uom%>">
										<input type="hidden" name="h_iv_admin_qty_<%=ivRecCount%>" id="h_iv_admin_qty_<%=ivRecCount%>" value="<%=qty%>">
										<input type="hidden" name="iv_admin_chng_dtls_req_<%=ivRecCount%>" id="iv_admin_chng_dtls_req_<%=ivRecCount%>" value="N">
										<label style="font-size:10;" ><b><%=qty_uom%></b></label>
										</td>
<%
										if(freq_nature!=null && freq_nature.equals("C")){
%>
											<td class="<%=classvalue%>" >
											<label style="<%=hide_ingredient_dtls%>">[<b><%=dosage_seq_no%>/<%=no_of_doses%></b>]</label>
											</td>
<%
										}
										else{
%>
											<td class="<%=classvalue%>"  >&nbsp;</td>
<%
										}
									}
									if(order_line_num.equals("1")){   
%>										
										<td style='background-color:<%=backGrndColor%>;'><label style="font-size:10;color:<%=fntColor%>;"> <%=route_desc%></label><% if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){%><br><div id="orderctl<%=ivRecCount%>" onClick="displayToolTipSFR('<%=ivRecCount%>')" onMouseOver="hideToolTip('<%=ivRecCount%>')"><label style="<%=sfrFLOW_STATUS_style%>"><b><%=sfrFLOW_STATUS_String%><b><img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=ivRecCount%>' name='imgArrow<%=ivRecCount%>'></label></div><%}%></td>
<%
										backGrndColor="";
										fntColor ="";
									}
									else{
%>
										<td class="<%=classvalue%>">&nbsp;</td>
<%
									}
									if(MfrYN.equals("Y") && order_line_num.equals("1")){
										MfrDetails=bean.getStatusOfMAR(order_id,"");
										String statusString="";
										if(MfrDetails.size()>0){
											statusString=(String)MfrDetails.get(0);
											mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue();														
										}
										if(!(hold.equals("Y")) && !(dis_continued.equals("Y"))){													
%>
											<td class="<%=classvalue%>" colspan=6 id="MFR_status_column_<%=ivRecCount%>"><%if(order_line_num.equals("1")){%><label name="iv_MFR_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openMFRDetails('<%=ivRecCount%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=drug_code%>','<%=Store_locn_code%>','NotAdmin','');"><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label>&nbsp;&nbsp;&nbsp;&nbsp <a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=mfrRemarks%>','Y');" id='mfrRemarksLink_<%=ivRecCount%>'>&nbsp;&nbsp;&nbsp;<font color="red"><b><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></b></font></a><%}%></td>
<%
										} 
										else {
											mfrCompletedStatus=false;
%>
											<td class="<%=classvalue%>" colspan=6 id="MFR_status_column_<%=ivRecCount%>"><%if(order_line_num.equals("1")){%><label name="iv_MFR_dtls_<%=ivRecCount%>" style="font-size:10;color:black;align:center;" onClick=""><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label><%}%></td>
<%
										}
%>
										<input type="hidden" name="iv_admin_date_time_<%=ivRecCount%>" id="iv_admin_date_time_<%=ivRecCount%>" value="<%=sch_date_time%>">
										<input type="hidden" name="iv_infusion_st_time_<%=ivRecCount%>" id="iv_infusion_st_time_<%=ivRecCount%>" value="<%=sfrACT_START_DATE_TIME%>">
										<input type="hidden" name="iv_flow_rate_<%=ivRecCount%>" id="iv_flow_rate_<%=ivRecCount%>" value="0">													
										<input type="hidden" name="sch_infusion_vol_str_unit_<%=ivRecCount%>" id="sch_infusion_vol_str_unit_<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit%>">
										<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" id="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit_desc%>"> <!-- added for SKR-SCF-0215 [IN:029303] -->
										<input type="hidden" name="sch_infusion_per_unit_<%=ivRecCount%>" id="sch_infusion_per_unit_<%=ivRecCount%>" value="<%=sch_infusion_per_unit_table_date%>">
										<input type="hidden" name="iv_infusion_period_txt<%=ivRecCount%>" id="iv_infusion_period_txt<%=ivRecCount%>" value="">												
										<input type="hidden" name="iv_infusion_period_<%=ivRecCount%>" id="iv_infusion_period_<%=ivRecCount%>" value="<%=sch_infusion_period%>">
										<input type="hidden" name="sch_infusion_period_unit_<%=ivRecCount%>" id="sch_infusion_period_unit_<%=ivRecCount%>" value="<%=sch_infusion_period_unit%>">
										<input type="hidden" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" value="">
										<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="">
										<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="">
										<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="">
										<input type="hidden" name="iv_expiry_date_<%=ivRecCount%>" id="iv_expiry_date_<%=ivRecCount%>" value="">
										<input type="hidden" name="iv_mfrRemarks<%=ivRecCount%>" id="iv_mfrRemarks<%=ivRecCount%>" value="<%=mfrRemarks%>">		
										<input type="hidden" name="sch_dosage_uom_code_<%=ivRecCount%>" id="sch_dosage_uom_code_<%=ivRecCount%>" value="<%=sch_dosage_uom_code%>"><!-- added for SKR-SCF-1240-->
										<input type="hidden" name="iv_dispense_drug_code_<%=ivRecCount%>" id="iv_dispense_drug_code_<%=ivRecCount%>" value="<%=dispense_drug_code%>"> <!-- SKR-SCF-1240-->
<%
									}
									else{
										if(MfrYN.equals("Y") && !(order_line_num.equals("1"))){
											if(sch_infusion_rate==null || sch_infusion_rate.equals("null"))
												sch_infusion_rate="0";
											if(!(sch_infusion_rate.equals("")) && Float.parseFloat(sch_infusion_rate) < 1.0)
												sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
%>
											<td class="<%=classvalue%>">&nbsp;</td>
<%
										}
										else{
%>
											<td class="<%=classvalue%>"><label  style="font-size:9;color:black" ><%=sch_date_time%></label></td>
<%
										}
%>
							<td  class="<%=classvalue%>">
							<input type="hidden" name="iv_admin_date_time_<%=ivRecCount%>" id="iv_admin_date_time_<%=ivRecCount%>" value="<%=sch_date_time%>">
							<input type="text" name="iv_infusion_st_time_<%=ivRecCount%>" id="iv_infusion_st_time_<%=ivRecCount%>" size="13" maxlength="16" value="<%=sfrACT_START_DATE_TIME%>" style="font-size:11;" onBlur=" validateAdminDateTime('<%=AdminBackLogTime%>','<%=current_date_time%>', this,'<%=locale%>','<%=sch_date_time%>');" <%=sfrFLOW_STATUS_disable%> style="<%=hide_ingredient_dtls%>">	<!-- added for SCF-7528-->
							</td>
							<td class="<%=classvalue%>">
							<input type="text" name="iv_flow_rate_<%=ivRecCount%>" id="iv_flow_rate_<%=ivRecCount%>" size="2" maxlength="9" value="<%=sch_infusion_rate%>" class="number" style="font-size:11;color:blue" onKeyPress="return allowValidNumber(this,event,6,3);" onBlur="CheckNum(this);changeDisplay(this,'<%=ivRecCount%>','<%=sch_infusion_per_unit_table_date%>');getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>')" style="<%=hide_ingredient_dtls%>" <%=sfrFLOW_STATUS_disable%>>
							<label style="font-size:10;" style="<%=hide_ingredient_dtls%>"><b><%=sch_infusion_vol_str_unit_desc%>/<%=sch_infusion_per_unit%></b>
							</label>
							<input type="hidden" name="sch_infusion_vol_str_unit_<%=ivRecCount%>" id="sch_infusion_vol_str_unit_<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit%>">
							<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" id="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit_desc%>"> <!-- added for SKR-SCF-0215 [IN:029303]-->
							<input type="hidden" name="sch_infusion_per_unit_<%=ivRecCount%>" id="sch_infusion_per_unit_<%=ivRecCount%>" value="<%=sch_infusion_per_unit_table_date%>">
							</td>
							<td  class="<%=classvalue%>">
							<input type="text" name="iv_infusion_period_txt<%=ivRecCount%>" id="iv_infusion_period_txt<%=ivRecCount%>" size="1" maxlength="6" value="" style="font-size:11;" disabled class="number" style="<%=hide_ingredient_dtls%>">
							<label style="font-size:10;" style="<%=hide_ingredient_dtls%>"><b><%=sch_infusion_period_unit_label%><div id="sch_inf_per_<%=ivRecCount%>">&nbsp;</div></b></label>
							<input type="hidden" name="iv_infusion_period_<%=ivRecCount%>" id="iv_infusion_period_<%=ivRecCount%>" value="<%=sch_infusion_period%>">
							<input type="hidden" name="sch_infusion_period_unit_<%=ivRecCount%>" id="sch_infusion_period_unit_<%=ivRecCount%>" value="<%=sch_infusion_period_unit%>">
							<input type="hidden" name="sch_dosage_uom_code_<%=ivRecCount%>" id="sch_dosage_uom_code_<%=ivRecCount%>" value="<%=sch_dosage_uom_code%>"><!-- added for SKR-SCF-1240-->
							<input type="hidden" name="iv_dispense_drug_code_<%=ivRecCount%>" id="iv_dispense_drug_code_<%=ivRecCount%>" value="<%=dispense_drug_code%>"><!-- SKR-SCF-1240-->
							</td>
							<td nowrap class="<%=classvalue%>"><!--Modified for HSA-CRF-0090[IN041241]-->
<%
							if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){
%>								
								<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!--Added for HSA-CRF-0090[IN041241]-->
								<input type="text" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=(String)work_sheet_batch_det.get(1)%>"  disabled >	   
								<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=(String)work_sheet_batch_det.get(1)%>">
								<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=(String)work_sheet_batch_det.get(2)%>">
								<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="">
<%	
							}
							else{
								auto_Admin_dis="";						
								if(iv_batch_ids.size()==0){	
									if(iv_Auto_Admin.equals("N")||(hold.equals("Y")) || dis_continued.equals("Y"))
										auto_Admin_dis="disabled";
									else 
										auto_Admin_dis="";
%>
									<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
									<input type="text" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>" style="font-size:11;" disabled ><input type="button" class="button" value="?" <%=auto_Admin_dis%>  onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=Store_locn_code%>','IV','<%=ivRecCount%>')" id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>" >
									<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>">
									<input type='hidden' name="IV_Newly_administerderd_<%=ivRecCount%>" id="IV_Newly_administerderd_<%=ivRecCount%>" value='IV_Y'>
									<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
									<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
								}
								else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 //changed 7 to 9 for GHL-CRF-0482

									expiry_date = (String)iv_batch_ids.get(1);
									trade_id	= (String)iv_batch_ids.get(2);
									trade_name  = (String)iv_batch_ids.get(3);
									auto_Admin_dis="disabled";
									totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
									for(int j=0;j<totQty.size();j=j+4){
										returned_qty = (Float)totQty.get(j+2);
										tot_administered_qty=  (Float)totQty.get(j+3);
										ret_qty=returned_qty-tot_administered_qty;							 
									}
									if(ret_qty<=0){					
%>										<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!--Added for HSA-CRF-0090[IN041241]-->
										<input type="text" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=(String)iv_batch_ids.get(0)%>" style="font-size:11;" disabled ><input type="button" class="button" value="?"  onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=store_code%>','IV','<%=ivRecCount%>')" <%=auto_Admin_dis%> disabled id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>">
										<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=(String)iv_batch_ids.get(0)%>">
										<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
										<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
									}
									else{
										expiry_date="";
										select_status_1="";
%>										<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N"><!--Added for HSA-CRF-0090[IN041241]-->
										<input type="text" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="" style="font-size:11;" disabled ><input type="button" class="button" value="?"  onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=store_code%>','IV','<%=ivRecCount%>')" <%=auto_Admin_dis%> disabled id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>">
<%
										}
									} 
									else{
%>										<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!--Added for HSA-CRF-0090[IN041241]-->
										<select name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" style="font-size:11;" onChange="assignBatchDetails('<%=mode%>','IV',this,'<%=ivRecCount%>','','<%=disp_drug_code%>','<%=drug_code%>','<%=qty%>','<%=order_id%>','<%=order_line_num%>','<%=freq_nature%>','N','<%=disp_drugs%>')">
										<!-- disp_drug_code,order_id,order_line_num,Freq_nature,disp_drugs added for BRU-CRF-399.1-->
										<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
										for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){ //changed 7 to 9 for GHL-CRF-0482
											if (defaultBatch.equals((String)iv_batch_ids.get(kk))){
%>
												<option selected value="<%=(String)iv_batch_ids.get(kk)%>"><%=(String)iv_batch_ids.get(kk)%></option>
												<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=(String)iv_batch_ids.get(kk)%>">
												<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
												<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
											}
											else{
%>
												<option value="<%=(String)iv_batch_ids.get(kk)%>"><%=(String)iv_batch_ids.get(kk)%></option>
<%
											}
										} 
%>
										</select>
<%
										} 
									} 										
%>
									</td>												
									<td class="<%=classvalue%>">
									<input type="text" name="iv_expiry_date_<%=ivRecCount%>" id="iv_expiry_date_<%=ivRecCount%>" size="9" maxlength="10" disabled value="<%=expiry_date%>" style="font-size:11;">
									</td>
<%
								}
%>
								<td class="<%=classvalue%>" style="display:none">
								<input type="hidden" name="iv_trade_name_<%=ivRecCount%>" id="iv_trade_name_<%=ivRecCount%>" size="21" maxlength="40" disabled value="<%=trade_name%>" style="font-size:11;">
								<input type="hidden" name="iv_trade_id_<%=ivRecCount%>" id="iv_trade_id_<%=ivRecCount%>" value="<%=trade_id%>">
								<input type="hidden" name="iv_bin_code_<%=ivRecCount%>" id="iv_bin_code_<%=ivRecCount%>" value="">
								</td>
								<td class="<%=classvalue%>"><% 
								String md_admn_req ="";
								if(bean.isWitnessedbyRequiredForIV(order_id)){
									md_admn_req="Y";
								}
								if(order_line_num.equals("1") && !((hold.equals("Y")) || dis_continued.equals("Y"))){
%>	
									<input type="checkbox" name="iv_chk_complete_<%=ivRecCount%>" id="iv_chk_complete_<%=ivRecCount%>" value="E" checked onClick="clearDrgRemarks(this,'<%=ivRecCount%>','<%=drug_code%>','IV')" style='display:none;'>
									<label name="iv_lbl_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=ivRecCount%>','<%=drug_code%>','<%=mode%>','IV','A','<%=freq_code%>','<%=dosage_seq_no%>','<%=no_of_doses%>','<%= order_id %>','<%=order_line_num%>','<%=encounter_id %>','<%=md_admn_req%>','<%=iv_prep_yn%>',iv_admin_chng_dtls_req_<%=(ivRecCount-Integer.parseInt(order_line_num)+1)%>,'<%=MfrYN%>','<%=sch_date_time%>','<%=sfrACT_START_DATE_TIME%>',true,'','','','','','<%=admin_discontinue%>')"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="iv_remarks_mand_id_<%=ivRecCount%>" style="display:visible"></img>
									<img src="../../ePH/images/return.gif" id="nxt_adm_<%=ivRecCount%>" style="display:none">									
<%
								}
								else{
%>
									&nbsp;
<%
								}
%>
								<input type="hidden" name="iv_mand_symbol_<%=ivRecCount%>" id="iv_mand_symbol_<%=ivRecCount%>" value="style='display:inline'">
<%
								if(order_line_num.equals("1") && (!MfrYN.equals("Y"))) { 
%>
									<label style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openAuditLogWindow('<%=ivRecCount%>','SFR');"><fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/></label>
<%
								}				
%>
								<input type="checkbox" name="chk_iv_select_<%=ivRecCount%>" id="chk_iv_select_<%=ivRecCount%>" value="E" checked style='display:none;' >
								</td>
								<input type="hidden" name="iv_no_of_drug_per_order_<%=ivRecCount%>" id="iv_no_of_drug_per_order_<%=ivRecCount%>" value="<%=iv_no_of_drug_per_order%>">
								<input type="hidden" name="sfrFLOW_STATUS<%=ivRecCount%>" id="sfrFLOW_STATUS<%=ivRecCount%>" value="<%=sfrFLOW_STATUS%>">
								<input type="hidden" name="sfrHOLD_DATE_TIME<%=ivRecCount%>" id="sfrHOLD_DATE_TIME<%=ivRecCount%>" value="<%=sfrHOLD_DATE_TIME%>">
								<input type="hidden" name="sfrHOLD_DURN_IN_MINS<%=ivRecCount%>" id="sfrHOLD_DURN_IN_MINS<%=ivRecCount%>" value="<%=sfrHOLD_DURN_IN_MINS%>">
								<input type="hidden" name="durn_bw_std_resumed_<%=ivRecCount%>" id="durn_bw_std_resumed_<%=ivRecCount%>" value="">
								<input type="hidden" name="flow_rate_changed_YN<%=ivRecCount%>" id="flow_rate_changed_YN<%=ivRecCount%>" value="">
								<input type="hidden" name="sfrRESUME_DATE_TIME<%=ivRecCount%>" id="sfrRESUME_DATE_TIME<%=ivRecCount%>" value="<%=sfrRESUME_DATE_TIME%>">
								<input type="hidden" name="sfrACT_END_DATE_TIME<%=ivRecCount%>" id="sfrACT_END_DATE_TIME<%=ivRecCount%>" value="<%=sfrACT_END_DATE_TIME%>">
								<input type="hidden" name="iv_drug_desc<%=ivRecCount%>" id="iv_drug_desc<%=ivRecCount%>" value="<%=drug_desc%>">
								<input type="hidden" name="inf_prd_hrs<%=ivRecCount%>" id="inf_prd_hrs<%=ivRecCount%>" value="">
								<input type="hidden" name="inf_prd_min<%=ivRecCount%>" id="inf_prd_min<%=ivRecCount%>" value="">
								<input type="hidden" name="iv_dosage_type_<%=ivRecCount%>" id="iv_dosage_type_<%=ivRecCount%>" value="<%=dosage_type%>">
								<input type="hidden" name="completedMinutes<%=ivRecCount%>" id="completedMinutes<%=ivRecCount%>" value="<%=completedMinutes%>">
								<input type="hidden" name="completedFlow<%=ivRecCount%>" id="completedFlow<%=ivRecCount%>" value="<%=completedFlow%>">
								<input type="hidden" name="iv_Auto_Admin_<%=ivRecCount%>" id="iv_Auto_Admin_<%=ivRecCount%>" value="<%=iv_Auto_Admin%>">
								<input type="hidden" name="iv_order_pract_id_<%=ivRecCount%>" id="iv_order_pract_id_<%=ivRecCount%>" value="<%=iv_order_pract_id%>">
								<input type="hidden" name="iv_prep_yn<%=ivRecCount%>" id="iv_prep_yn<%=ivRecCount%>" value="<%=iv_prep_yn%>">
							</tr>											
<%
							if(!MfrYN.equals("Y")){
%>
								<script language='javascript'>
									getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>')
								</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
							}
							ivRecCount++;
						} 
%>
							<input type="hidden" name="iv_admin_by" id="iv_admin_by" value="<%=user_id%>">
							<input type="hidden" name="iv_admin_date_time_audit" id="iv_admin_date_time_audit" value="<%=current_date_time%>">
							<input type="hidden" name="iv_admin_remarks" id="iv_admin_remarks" value="">
							<input type="hidden" name="iv_dosage_seq_no" id="iv_dosage_seq_no" value="<%=dosage_seq_no%>">
						</table>
						<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:15%;visibility:hidden;" bgcolor="blue">
							<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="100%" height="100%" align="center">
								<tr><td id="t"></td></tr>
							</table>
						</div>
<%
					}
				}
%>	
				<br>
				<br>
				<br>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
					<tr align="right">
						<td  class="button"   width='50%'>
							<input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="callCancel()">
							<input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="callSchrecord(this,'<%=adminOption%>','<%=callFrom%>','<%=recCount%>','<%=iv_prep_yn%>','<%=order_id%>','<%=order_line_num%>','<%=item_code%>','<%=isSiteSpecMARPrint%>','<%=patient_id%>','<%=patient_class_ord%>','<%=batch_ids.size()%>','<%=patient_stock_yn%>','<%=encounter_id%>','<%=patient_brgt_medn%>')">&nbsp;&nbsp;  <!-- recCount,iv_prep_yn  added for AAKH-CRF-0084 and patient_class_ord added for ICN66152-->
						</td>
						<td class='label' width='50%'>
							<label style='<%=adminOptionDisplay%>'>&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.adminby.label" bundle="${ph_labels}"/>&nbsp&nbsp;<label>
							<select name='selfAdminByType' id='selfAdminByType' onchange='changeAdminbyType(this)' style='<%=adminOptionDisplay%>'>
								<option value='P' selected><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
								<option value='R'><fmt:message key="ePH.patientsRelative.label" bundle="${ph_labels}"/></option>
							</select>&nbsp&nbsp;
							<label style='display:none;' id='selfAdminNamelbl'><fmt:message key="Common.name.label" bundle="${common_labels}"/>&nbsp&nbsp;<label>
							<input type='text' name='selfAdminBy' id='selfAdminBy' value='<%=selfAdminBy%>' maxlength='30' size='20' style='display:none;'>
							<img src="../../eCommon/images/mandatory.gif"  id="selfAdminByMand"  style='display:none;'></img>
						</td>
					</tr>
				</table>
				<input type="hidden" name="adminByType" id="adminByType"	value="<%=adminByType%>">
				<input type="hidden" name="current_date_time" id="current_date_time"	value="<%=current_date_time%>">
				<input type="hidden" name="from_time" id="from_time"			value="<%=admin_from_date%>">
				<input type="hidden" name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
				<input type="hidden" name="disp_locn_code" id="disp_locn_code"		value="<%=Store_locn_code%>">
				<input type="hidden" name="nursing_unit" id="nursing_unit"		value="<%=nursing_unit%>">
				<input type="hidden" name="patient_id_selected" id="patient_id_selected" value="<%=patient_id%>">
				<input type="hidden" name="patient_id" id="patient_id"			value="<%=patient_id%>">
				<input type="hidden" name="order_id" id="order_id"			value="<%=order_id%>">
				<input type="hidden" name="order_line_num" id="order_line_num"		value="<%=order_line_num%>">			
				<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
				<input type="hidden" name="mode" id="mode"				value="<%=CommonRepository.getCommonKeyValue( "MODE_INSERT" )%>">	
				<input type="hidden" name="tot_no_of_records" id="tot_no_of_records"	value="1">	
				<input type="hidden" name="non_iv_records" id="non_iv_records"		value="<%=tot_rec%>"><!--changed 1 to tot_rec for ML-MMOH-CRF-1014 -->
				<input type="hidden" name="new_non_iv_records" id="new_non_iv_records"	value="<%=tot_rec%>"><!--changed 1 to tot_rec for ML-MMOH-CRF-1014 -->
				<input type="hidden" name="alt_non_iv_records" id="alt_non_iv_records"	value="<%=altRecCount%>">
				<input type="hidden" name="iv_records" id="iv_records"			value="<%=ivRecCount-1%>">
				<input type="hidden" name="func_mode" id="func_mode"			value="CP">
				<input type="hidden" name="drugCode" id="drugCode"			value="<%=drugCode%>">
				<input type="hidden" name="selDateTime" id="selDateTime"			value="<%=selDateTime%>">
				<input type="hidden" name="adr_recorded" id="adr_recorded"		value="N">
				<input type="hidden" name="admin_recorded" id="admin_recorded"		value="N">
				<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
				<input type="hidden" name="freq_nature" id="freq_nature"			value="<%=freq_nature%>">
				<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"		value="<%=userAuthPINYN%>">
				<input type="hidden" name="admin_discontinue" id="admin_discontinue"	value="<%=admin_discontinue%>">
				<input type="hidden" name="function_from" id="function_from"	value="<%=function_from%>">
				<input type="hidden" name="verify_adm_drug" id="verify_adm_drug" value="<%=verify_adm_drug%>"> <!--  Added for AAKH-CRF-0084 [IN060429] -->
				<input type="hidden" name="allowed_yn_<%=recCount%>" id="allowed_yn_<%=recCount%>" value = ""><!--added for GHL-CRF-0458 and recCount added for IN066062-->
			</form>
		</body>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_all_stages,bean_all_stages,request);
		putObjectInBean(drug_search_bean_id,drug_bean,request);
		putObjectInBean(admin_bean_id,admin_bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ // Added for AAKH-CRF-0084 - Start
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for AAKH-CRF-0084 - End
%>	
</html>

