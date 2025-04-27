<!DOCTYPE html>
<% 
/*
---------------------------------------------------------------------------------------------------------------------------------	
Date		Edit History	Name		Rev.Date   	Rev.By 			Description
--------------------------------------------------------------------------------------------------------------------------------
03/02/2017	IN061410		Chithra		01/02/2017	Manickkam 		TTM-SCF-0171
03/01/2018	IN066125		Dinesh T	01/02/2017	Ramesh G		EM run on window 10 and IE 11
																	Vaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR
07/03/2019      IN067953        Devindra       ?           ?            MMS-KH-CRF-0014 																	
19/08/2019		IN071056		Manickavasagam				 		SKR-SCF-1264
6/12/2019		IN071721	    Shazana  											SKR-SCF-1290
24/12/2020		11726		        Manickavasagam J			     SKR-SCF-1534
31/1/2021		6771		        Manickavasagam J			     SKR-SCF-1429
22/02/2021		6596		        Manickavasagam J			     ML-MMOH-SCF-1674
26/04/2021		16605		 	Manickavasagam J				     ML-MMOH-SCF-1767
11/05/2023      43323           SREENADH.M               RAMESH.G    NMC-JD-CRF-0186
16/05/2023      45063           SREENADH                             NMC-JD-CRF-0186
15/06/2023      46294       SREENADH.M           RAMESH.G               NMC-JD-CRF-0186 
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,java.lang.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>  
	 <head>
<%
		System.out.println("------------------------->MedicationAdministrationFTDrugDtls.jsp");
 		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id_test			=	 request.getParameter("order_id");
		String str_row_no				=	 request.getParameter("row_no")==null?"0":request.getParameter("row_no");
		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
		String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
		String Auto_Admin				=    "";
		String admin_from_date			=	 request.getParameter("admin_from_date")==null?"":request.getParameter("admin_from_date");
		String admin_to_date			=	 request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		if(!locale.equals("en") && (function_from.equals("CP") || function_from.equals("CA"))){ //function_from Added for RUT-SCF-0323 [IN:044818]
			admin_from_date = com.ehis.util.DateUtils.convertDate(admin_from_date, "DMYHM",locale,"en");
			admin_to_date = com.ehis.util.DateUtils.convertDate(admin_to_date, "DMYHM",locale,"en");
			from_time = com.ehis.util.DateUtils.convertDate(from_time, "DMYHM",locale,"en");
			to_time = com.ehis.util.DateUtils.convertDate(to_time, "DMYHM",locale,"en");
		}
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String display_order_by			=	 request.getParameter("display_order_by")==null?"":request.getParameter("display_order_by");	
		String route_admin				=	 request.getParameter("route_admin")==null?"":request.getParameter("route_admin");	
		String admin_route_categ		=	 request.getParameter("admin_route_categ")==null?"":request.getParameter("admin_route_categ");
		String callFrom		=	 request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		boolean boolAllergy_icon	=	false;	//Added for RUT-CRF-0065.1 [IN:43255]
		boolean alt_flag		= false;//BRU-CRF-399.1
		boolean disp_with_alt	= false;//BRU-CRF-399.1
		boolean alt_multi_drug_flag = false; //BRU-CRF-399.1
		String  alt_batch_drug	= ""; //BRU-CRF-399.1
		HashMap batchIdforOrders = null; //GHL-CRF-0482

		String 	strAllergyreason =	"",generic_id="",generic_name="";//Added for RUT-CRF-0065.1 [IN:43255]
		String disp_schedule_uom_desc="", admin_uom_desc = "",dispense_drug_code="",alt_drug_display="";
		ArrayList arrAltDrugs = new ArrayList();//Added for Bru-HIMS-CRF-399 [IN:043767]
		float ret_qty=0;//added below Variables  for incident NO:33194
		float returned_qty=0;
		float tot_administered_qty=0;
		float disp_qty=0;
		float ward_return_qty=0;// adding end
		DecimalFormat dfTest = new DecimalFormat("0.########");
		if(route_admin.equals("undefined")){
			route_admin="";
		}
		if(admin_route_categ.equals("undefined")){
			admin_route_categ="";
		}
		String dob			=	 request.getParameter("dob")==null?"":request.getParameter("dob");//IN066125
%>
		<script language="javascript">
		var headTop = -1;
		var FloatHead1;
		var FloatHead2;
		var onlyiv=false;
		function processScroll(){
			if (headTop < 0){
				saveHeadPos();
			}				
			if (headTop>0){
				if (document.documentElement && document.documentElement.scrollTop){
					theTop = document.documentElement.scrollTop;
				}
				else if (document.body){
					theTop = document.body.scrollTop;
				}					
				if(FloatHead2!=null){
					if(onlyiv){ //Only IV Drugs
						FloatHead1 = FloatHead2;
					}
					else{ //NonIV and IV Drugs
						if(document.getElementById("ball").offsetTop < theTop){
							FloatHead1.style.visibility= 'hidden';
							FloatHead1 = FloatHead2;
							FloatHead1.style.visibility= 'visible';
							FloatHead1.style.position = "absolute";	
						}
						else {								
							FloatHead1.style.position = "";	
							FloatHead1 = document.getElementById("non_iv_admin_table_row2");
							FloatHead1.style.visibility= 'visible';
							FloatHead1.style.position = "relative";	
						}
					}
				}
				else{ // only NON IV Drugs
					FloatHead1 = document.getElementById("non_iv_admin_table_row2");							
				}
				if (theTop>headTop){
					FloatHead1.style.top = (theTop-headTop) + 'px';								
				}
				else{
					FloatHead1.style.top = '0px';							
				}
			}				
		}
		function saveHeadPos(){
			parTable = document.getElementById("headStart");
			if (parTable != null){
				headTop = parTable.offsetTop + 3;					
				FloatHead1 = document.getElementById("non_iv_admin_table_row2");
				FloatHead1.style.position = "relative";
				FloatHead2= document.getElementById("iv_admin_table_row1");
				if (FloatHead2 != null){						
					onlyiv=false;
				}
			}
			else{					
				parTable = document.getElementById("headStart2");
				if (parTable != null){
					headTop = 3;	
					FloatHead2 = document.getElementById("iv_admin_table_row1");
					FloatHead2.style.position = "absolute";
					onlyiv=true;
				}
			}
		}			
		window.onscroll = processScroll;
		</script>
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
		<style>
		.descFont{
			font-size:9;
			font-weight:bold;
			color:black;
		}
		/* NMC-JD-CRF-0186 - [43323] */
		TD.hiddenCheck{
			visibility: false;
			pointer-events:none;
			background-color: blue;
		}
		TD.visibleCheck{
			visibility: true;
		}
		</style>
	</head>
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
%>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="MedicationAdministrationFTDrugDetails" id="MedicationAdministrationFTDrugDetails" >
<% 
try{
	String drugCode					=    "";
	String selDateTime				=    "";
	String flag						=    "";
			
	if(mode!=null && mode.equals("NOTIME")){
		drugCode					=	request.getParameter("drug_code");
		selDateTime					=	request.getParameter("selDateTime");
	}
	if(function_from.equals("CP")){
		drugCode					=	request.getParameter("p_ord_drug_code");
		mode						=	"CP";
	}
	int row_no								= Integer.parseInt(str_row_no);
	String bean_id_all_stages				= "DispMedicationAllStages" ;
	String bean_name_all_stages				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
	bean_all_stages.setLanguageId(locale);
	bean_all_stages.setModuleId("1");
	ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id_test,patient_id_test,order_line_no_test);	
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	bean.setCurrentTimeAndAdminWithinHRS();
	String drug_search_bean_id				= "DrugSearchBean";
	String drug_search_bean_name			= "ePH.DrugSearchBean";
	DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
	drug_bean.setLanguageId(locale);
	ArrayList result						= bean.getCurrentTimeAndAdminWithinHRS();
	String current_date_time				= (String)result.get(0);
	String AdminBackLogTime					= "";
	if(admin_from_date.equals(""))	
		AdminBackLogTime					= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));		
	else
		AdminBackLogTime					= admin_from_date;
	HashMap drug_details					= new HashMap();					
	String order_id							= "";
	String userAuthPINYN=bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
	userAuthPINYN=userAuthPINYN==null?"":userAuthPINYN;// Added for RUT-CRF-0035 [IN029926] 
	if(!callFrom.equals("RELOADTAPER"))
		bean.clearDrugDetails();
	if(bean.getDrugDetails_Added() == null ){   //Added for RUT-CRF-0088 [IN036978]
		if(mode!=null && (mode.equals("NOTIME") || mode.equals("CP"))){
			String shedule_date_time			= request.getParameter("shedule_date_time");
			order_id							= request.getParameter("order_id");
			if(function_from.equals("CP")){	
%>
				<table>
					<tr>
						<title><fmt:message key="Common.MedicationAdministration.label" bundle="${common_labels}"/></title>
					</tr>
				</table>
<%
				shedule_date_time				 =	request.getParameter("p_start_date_time");
				order_id					     =	request.getParameter("order_id");
			} // Function from CP loop ends	
			drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,order_id,shedule_date_time,drugCode,hold_discontinue_yn,administration_status,order_type,display_order_by,route_admin,admin_route_categ,patient_id_test,"");// added	patient_id_test and "" string for the incident IN037217			
			bean.setDrugDetails_Added(drug_details);  //Added for RUT-CRF-0088 [IN036978]
		}	// Mode from CP loop ends
		else{	
			drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,admin_from_date,admin_to_date,hold_discontinue_yn,administration_status,order_type,to_time,from_time,display_order_by,route_admin,admin_route_categ);
			bean.setDrugDetails_Added(drug_details);  //Added for RUT-CRF-0088 [IN036978]
		}   
	}
	else{   //Added for RUT-CRF-0088 [IN036978]
		drug_details		  = bean.getDrugDetails_Added();
	}	
	String iv_prep_yn			   =	"";
	String title				   =	"";
	if(!order_type.equals("A")){
		iv_prep_yn				=  drug_details.get("iv_prep_yn")==null?"":(String)drug_details.get("iv_prep_yn");
		if(function_from.equals("CP"))
			iv_prep_yn	=	bean.IVType(order_id);
		if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
			title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
		else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
			title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
		else
			title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");
	} //if ends 
	ArrayList	non_iv_drug_details				=	 (ArrayList) drug_details.get("NON_IV");
	String cancel_recorded_yn    ="N";//added for JD-CRF-0200
	ArrayList iv_drug_details				    =	 (ArrayList) drug_details.get("IV");
	String admin_bean_id						=	  "MedicationAdministrationBean";
	String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
	admin_bean.setLanguageId(locale);
	String totalTaperQtyDisplay = admin_bean.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
	String allowMAR_share_drug = admin_bean.getAllowMARShareDrug();//Added for HSA-CRF-0090[IN041241] -start
	String allow_mar_alternate_drug_yn = admin_bean.getAllow_auto_disp_alt_drug_mar();//Added for Bru-HIMS-CRF-399 [IN:043767]
	String shared_drug_disp = "";
	
	
	admin_bean.setNursingUnit(nursing_unit);
	admin_bean.setPatientId(patient_id_test);
	admin_bean.setEncounterId(encounter_id);
	admin_bean.setBedNo(assign_bed_num);
	HashMap defaultValues				=	new HashMap();
	defaultValues						=	admin_bean.getNONIVDrugDetails();
	String	defaultDate					=	"";
	String  defaultBatch				=	"";
	String	defaultTradeId				=	"";
	String	defaultExpiryDate			=	"";
	String schedule_uom_desc			=   "";
	String schedule_uom_code			=   "";
	if (defaultValues.containsKey(selDateTime)){
		try{
			ArrayList alreadyEnteredValues=(ArrayList)defaultValues.get(selDateTime);
			defaultDate				=	(String)alreadyEnteredValues.get(2)==null?"":(String)alreadyEnteredValues.get(2);
			defaultBatch			=	(String)alreadyEnteredValues.get(9)==null?"":(String)alreadyEnteredValues.get(9);
			defaultExpiryDate		=	(String)alreadyEnteredValues.get(10)==null?"":(String)alreadyEnteredValues.get(10);
			defaultTradeId			=	(String)alreadyEnteredValues.get(11)==null?"":(String)alreadyEnteredValues.get(11);
		}
		catch (Exception e){
			defaultDate			="";
			defaultBatch		="";
			defaultExpiryDate	="";
			defaultTradeId		="";
		}
	} 
	int tot_records						=   0;		int recCount		 = 0;
	int altRecCount						=   0;		int newRecCount		 = 0;
//	int ivRecCount						=   0;		
	String patient_id					=   "";
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
	String  item_code					=   "";		order_id		      = "";
	String order_line_num				=   "";		ArrayList batch_ids   = new ArrayList(); 
	String sch_date_time				=   "";		String dosage_seq_no  = "";
	String trade_id						=   "";		String dis_continued  = "";
	String hold							=   "";		String administered   = "";
	String could_not_administer ="";//Added for AAKH-CRF-0024 [IN:038260]
	String admin_recorded_yn			=   "";		String remarks		  =	"";
	String admindrugdetails				=   "";
	String admin_drug_code				=   "";		String admin_drug_desc=	"";
	String Store_locn_code				=	"";
	String sch_date_time_in_locale		=	"";
	String Storelocn_code				=	"";
	String iv_incred					=	"";
	String iv_incred1					=	"";
	String iv_incred2					=	"";
	String route_desc					=	"";
	String pres_catg_code				=   "";
	String pres_base_uom				 =  "";		//added for SKR-SCF-0304
	boolean auth_reqd					=   false;
	String auth_reqd_script				=	"";
	StringTokenizer stadmindrugdetails	=	null;
	StringTokenizer stiv_incred			=	null;	
	String admin_by_name				=	"";		String auth_by_name					=	"";
	String end_date_time				=	"";		String freq_code					=	"";
	String AdUOM						=	"";
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
	String performingDeptLocCode		=	"";	    String future_or_late_admin = ""; // Added for GHL-CRF-0482 [IN:064955]
	String future_date_time		            =	"";    // Added for GHL-CRF-0482 [IN:064955]
	//String nonMfrFluidRemarks			=	"";
	String strength_per_value_pres_uom = "1";
	String route_color 	=   "";   // Code Added For RUT-CRF-0034 Start
	String fntColor                     =   "#OOOOOO";
	String backGrndColor                =   "#FFFFFF";   // Code Added For RUT-CRF-0034 End
	String order_pract_id 	=   "";  //Added for [IN:040149]
	String bat_id_lookbutton_enabled="Y", auto_Admin_dis="", verbalOrder="";
	String pin_value=bean.getPinNumber();
	String mfr_yn	= "";//ML-MMOH-CRF-1014- start
	String statusString = "";
	String placed_from_verbal_order="";//added for ghl-crf-0509
	boolean mfrCompletedStatus		=	false;
	String patient_stock_display	= "";//Added for GHL-CRF-0482
	String patient_stock_check_display = "";//Added for GHL-CRF-0482
	ArrayList MfrDetails			=	new ArrayList();//ML-MMOH-CRF-1014- end
//	DecimalFormat dfToInteger = new DecimalFormat("####.##");
	ArrayList work_sheet_batch_det1		=	new ArrayList();
	ArrayList sliding_scale_details		=	new ArrayList();
	int temp1                           =   0;
	int temp2                           =   0;		
	int temp3                           =   0;		
	int inc								=   0;
	float dialog_height					=	0;
	HashMap overridereason				=	new HashMap();
	int ppn_count						=   0;
	String sch_date_time_in_en = "";//added for skr-scf-1290
	String drug_indication_remarks="";
	String taper_yn	=	 "N", addedTaperSch="";  //Added for RUT-CRF-0088 [IN036978]
	ArrayList totQty =null,  WardReturnQty= null;
	boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
	boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
	boolean isSite_spec_patient_stock = bean.isSiteSpecific("PH","PATIENT_STOCK_REQUIRED");//ADDED FOR GHL-CRF-0482
//	boolean verify_adm_drug	= bean.isSiteSpecific("PH", "VERIFY_ADM_DRUG"); //MMS-KH-CRF-0017 and commented for MMS-KH-CRF-0017
//	isSite_spec_patient_stock = true;
		String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
		String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
		
	if((non_iv_drug_details.size()==0) &&(iv_drug_details.size()==0)){
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
			if(parent.parent.f_button != null){
				parent.parent.parent.f_search.location.href = "../../ePH/jsp/MedicationAdministrationSearch.jsp";
			}
		</script>
<%		
		return;
	}
	if(non_iv_drug_details.size()>0){
					
%>		<div id="headStart" > 
		<table cellpadding="0" width="100%" align="center" border="1" id="non_iv_administration_table">
		<tr id="non_iv_admin_table_row2">
		<td class="TDSTYLE" width="2%">&nbsp;</td>
		<td class="TDSTYLE"   width="25%"><B><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></B></td>
		<td class="TDSTYLE"   width="2%">&nbsp;</td>
		<td class="TDSTYLE"   width="2%">&nbsp;</td>
		<td class="TDSTYLE"   width="2%">&nbsp;</td>
		<td class="TDSTYLE"   width="6%"><B><fmt:message key="ePH.AdminDose.label" bundle="${ph_labels}"/></B></td>
		<td class="TDSTYLE"   width="9%"><B><fmt:message key="ePH.RouteOfAdministration.label" bundle="${ph_labels}"/></B></td>
		<td class="TDSTYLE"   width="10%"><B><fmt:message key="ePH.ScheduledTime.label" bundle="${ph_labels}"/></B></td>
		<td class="TDSTYLE"   width="10%"><B><fmt:message key="ePH.AdminDate/Time.label" bundle="${ph_labels}"/></B></td>
		<td class="TDSTYLE"   width="2%"><B><fmt:message key="ePH.BroughtByPatient.label" bundle="${ph_labels}"/></B></td>
		<td class="TDSTYLE"   width="13%"><B><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></B></td><!-- Modified for HSA-CRF-0090[IN041241] -->
		<td class="TDSTYLE"   width="10%"><B><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></B></td>
		<td class="TDSTYLE"   width="18%"><B><fmt:message key="ePH.AdminDtls.label" bundle="${ph_labels}"/></B></td>
		<%
			if(isSite_spec_patient_stock) 
				patient_stock_display	=	""; 
			else
				patient_stock_display	=	"display:none";



			if(isSite_spec_patient_stock){
		%>
		<td class="TDSTYLE"   width="2%"><B><fmt:message key="ePH.PatientStockCompleted.label" bundle="${ph_labels}"/></B></td><!-- GHL-CRF-0482-->
		<%
			}
		%>
		<td class="TDSTYLE" ><B><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></B></td>
		</tr>
<%
		if(!order_type.equals("A")){ 
%>
			<tr id="non_iv_admin_table_row1" >
			<td class='COLUMNHEADER' colspan="14"  style="font-size:10" ><b><%=title%> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
			</tr>
<%	
		}
		if(mode!=null && (mode.equals("NOTIME") || mode.equals("CP"))){				
			//inc=79;   //Changed from 69 to 72 //Incremented from 68 to 69 for RUT-CRF-0088 [IN036978]	// 69 to 70 for RUT-CRF-0065.1 [IN:43255] and 72 to 74 for ML-MMOH-CRF-1014 and 75 to 78 for GHL-CRF-0482
		//74 to 75 changed for GHL-CRF-0509
			inc=80; //added for JD-CRF-0200
		}
		else{ 
			//inc=89;  //Changed from 79 to 82   //Incremented from 77 to 78 for RUT-CRF-0088 [IN036978]  //Code Modified For RUT-CRF-0034  // 78 to 79 for RUT-CRF-0065.1 [IN:43255] // 82 to 84 for ML-MMOH-CRF-1014 and 85 to 88 for GHL-CRF-0482
		//	 84 TO 85 changed for GHL-CRF-0509
			inc=90; //added for JD-CRF-0200
		}
		String alt_drug_code, alt_drug_desc, alt_qty, alt_qty_uom, alt_expiry_date,  alt_trade_id, alt_trade_name, linkVacScheduleCode1;
		ArrayList alt_batch_ids = null;
		String[] vacScheduleDetails;
		String administred_batch_id, disp_batch_id, disp_exp_dt, disp_trade_id, admin_dose_prn="", non_iv_admin_quaty=""; // added for SKR-SCF-0304
		String sl_srl_no="", sl_rg_fro, sl_rg_to, sl_adm_qty, rangeUOM, dosageDescription="", showTitle, admin_date_time, modified_date_time, alt_drug, displayStyle, statusFlag, addDisplayStyle , checked, dispensed_drug_desc = "", disp_drugs="",ward_ack_yn="";
		boolean isSiteSpecMARPrint = false;//bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // "bean.isSiteSpecific("PH","WARD_ACK");" changed to "false" for MMS-KH-CRF-0014 [IN:067953]
		String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
		HashMap splitDoseYN = bean.getSplitDoseYN();//ML-MMOH-SCF-1439
		 String verification_req_yn=admin_bean.getverfreqdbefmedAdmin();//added for MMS-KH-SCF-0056
		if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){
			isSiteSpecMARPrint = true;
		}
		boolean issitespec_verbal_order_yn = bean.isSiteSpecific("PH","PLACED_VERBAL_ORDER_YN");//ADDED FOR GHL-CRF-0509
		
		String patient_class_ord = "";//GHL-CRF-0458
		String mfrRemarks		 = "";//added for ml-mmoh-crf-1014
		String admin_uom		 = "";//BRU-CRF-399.1
		String order_status		 = ""; //GHL-CRF-0482
		boolean ack_flag = false;//GHL-CRF-0458
		//added for GHL-CRF-0482 - start
		HashMap drugMap = new HashMap();
		ArrayList orderList = new ArrayList();
		String disp_drug_code_for_batch = "";
		String drug_code_for_batch = "";
		String order_id_for_drug   = "";
		String order_line_no_for_drug   = "";
		String patient_stock_yn = "";
		String patient_stock_required = "";
		String patient_stock_completed	= "";
		String patient_stock_checked    = "";
		String patient_stock_disabled	= "";
		String verification_status = "N";//added for MMS-KH-SCF-0056
	   
		for (int k=0;k<non_iv_drug_details.size();k=k+inc){	
		
			order_id_for_drug	    = (String)non_iv_drug_details.get(k+13);
			order_line_no_for_drug  = (String)non_iv_drug_details.get(k+14);

			if(inc == 90 ){//89 TO 90 MODIFIED for JD-CRF-0200
				disp_drug_code_for_batch = (String)non_iv_drug_details.get(k+81);
			}else if(inc == 80 ){//79 T0 80 MODIFIED for JD-CRF-0200
				disp_drug_code_for_batch = (String)non_iv_drug_details.get(k+71);
			}
			drug_code_for_batch = (String)non_iv_drug_details.get(k+28);
			if(disp_drug_code_for_batch.equals(""))
				disp_drug_code_for_batch = drug_code_for_batch;
			if(drugMap!=null ){
			 if(drugMap.containsKey(disp_drug_code_for_batch)){
				 
				 orderList = (ArrayList)drugMap.get(disp_drug_code_for_batch);
				if(!orderList.contains(order_id_for_drug)){
					orderList.add(order_id_for_drug);
					orderList.add(order_line_no_for_drug);
					drugMap.put(disp_drug_code_for_batch,orderList);
				}
			 }else{
					orderList = new ArrayList();
					orderList.add(order_id_for_drug);
					orderList.add(order_line_no_for_drug);
					drugMap.put(disp_drug_code_for_batch,orderList);
			 }
			}
		}
		//added for GHL-CRF-0482 - end
		for (int i=0;i<non_iv_drug_details.size();i=i+inc){					
			ppn_count = 0;
			linkVacScheduleCode="";
			linkVacScheduleYN ="N";
			patient_stock_checked = "";//GHL-CRF-0482
			patient_stock_disabled = "";
			ward_ack_yn = "";//GHL-CRF-0458
			statusString = "";//ML-MMOH-CRF-1014
			could_not_administer = "";//SKR-SCF-1264
			if(inc == 90 ){//84 to 85 changed for GHL-CRF-0509  // 89 TO 90 MODIFIED for JD-CRF-0200
				iv_prep_yn			= non_iv_drug_details.get(i+44)==null?"":(String)non_iv_drug_details.get(i+44);
				iv_incred			= (String)non_iv_drug_details.get(i+53);
				route_desc			= (String)non_iv_drug_details.get(i+54);
				pres_catg_code		= (String)non_iv_drug_details.get(i+55)==null?"":(String)non_iv_drug_details.get(i+55);
				medn_admn_dtl_reqd_yn	= (String)non_iv_drug_details.get(i+45);
				prn_remarks			= (String)non_iv_drug_details.get(i+46);				
				slidingscaleremarks	= (String)non_iv_drug_details.get(i+47);
				ext_prod_id			= (String)non_iv_drug_details.get(i+50);
				trade_code			= (String)non_iv_drug_details.get(i+51);
				imageFileURL		= (String)non_iv_drug_details.get(i+52);
				schedule_uom_desc	= (String)non_iv_drug_details.get(i+56);
				schedule_uom_code	= (String)non_iv_drug_details.get(i+57);
				patient_brgt_medn	= (String)non_iv_drug_details.get(i+58);
				sliding_scale_applicable	= (String)non_iv_drug_details.get(i+59);
				strength_value_prn	= (String)non_iv_drug_details.get(i+60)==null?"":(String)non_iv_drug_details.get(i+60);
				sch_strength_value_prn	= (String)non_iv_drug_details.get(i+61)==null?"":(String)non_iv_drug_details.get(i+61);
				adminsted_pat_brought_medn	= (String)non_iv_drug_details.get(i+62);	
				dosage_type			= (String)non_iv_drug_details.get(i+63);
				dosage				= (String)non_iv_drug_details.get(i+64);
				dosage_uom_code		= (String)non_iv_drug_details.get(i+65);
				dosage_uom_desc		= (String)non_iv_drug_details.get(i+66);
				content_in_pres_base_uom= (String)non_iv_drug_details.get(i+67);
				sch_strength_uom_prn	= (String)non_iv_drug_details.get(i+68)==null?"":(String)non_iv_drug_details.get(i+68);
				sch_strength_uom_desc_prn	= (String)non_iv_drug_details.get(i+69)==null?"":(String)non_iv_drug_details.get(i+69);	
				admn_dose_chng_reason_code	= (String) non_iv_drug_details.get(i+70)==null?"":(String)non_iv_drug_details.get(i+70);	
				onco_direct_drug_count		= (String)non_iv_drug_details.get(i+71);
				linkVacScheduleCode			= (String)non_iv_drug_details.get(i+72);
				performingDeptLocCode		= (String)non_iv_drug_details.get(i+73)==null?"":(String)non_iv_drug_details.get(i+73);
				pres_base_uom				= (String)non_iv_drug_details.get(i+3);  //added for SKR-SCF-0304
				adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
				verificationremarks	= bean_all_stages.getVerificationRemarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				overridereason		= (HashMap)bean_all_stages.getOverrideremarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pres_remarks		= bean.getPrescriptionInstructions((String)non_iv_drug_details.get(i+13));
				drug_remarks		= bean.getDrugInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pharma_remarks		= bean.getPharmacistInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				show_remarks		= "N";
				boolAllergy_icon	= false;// Added for RUT-CRF-0065.1 [IN:43255]
				order_pract_id  =(String)non_iv_drug_details.get(i+76)==null?"":(String)non_iv_drug_details.get(i+76); //Added for [IN:040149]
				route_color                 = (String)non_iv_drug_details.get(i+75)==null?"":(String)non_iv_drug_details.get(i+75);	//Code Added For RUT-CRF-0034 Start
				mfr_yn = (String)non_iv_drug_details.get(i+82)==null?"":(String)non_iv_drug_details.get(i+82);//ML-MMOH-CRF-1014
				mfrRemarks				 =	(String)non_iv_drug_details.get(i+83)==null?"":(String)non_iv_drug_details.get(i+83);//added for ml-mmoh-crf-1014
				placed_from_verbal_order				 =	(String)non_iv_drug_details.get(i+84)==null?"":(String)non_iv_drug_details.get(i+84);//added for GHL-CRF-0509
				order_status = (String)non_iv_drug_details.get(i+85)==null?"":(String)non_iv_drug_details.get(i+85);//added for GHL-CRF-0482
				patient_stock_required = (String)non_iv_drug_details.get(i+86)==null?"":(String)non_iv_drug_details.get(i+86);//added for GHL-CRF-0482
				patient_stock_completed = (String)non_iv_drug_details.get(i+87)==null?"":(String)non_iv_drug_details.get(i+87);//added for GHL-CRF-0482
				patient_stock_yn = (String)non_iv_drug_details.get(i+88)==null?"":(String)non_iv_drug_details.get(i+88);//added for GHL-CRF-0482
				cancel_recorded_yn = (String)non_iv_drug_details.get(i+89)==null?"":(String)non_iv_drug_details.get(i+89);//added for JD-CRF-0200
			
		       	if(route_color != "" && route_color != null && route_color.length()==12){
					fntColor = route_color.substring(0, 6);
					backGrndColor = route_color.substring(6, 12);
				}//Code Added For RUT-CRF-0034 End
				if(ext_prod_id!=null && !ext_prod_id.equals("")){
					if(overridereason.size()>1){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}	
				}
				else{
					if(overridereason.size()>0){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}
				}
				if(order_type.equals("A"))		  // if and else block Added for RUT-CRF-0088 [IN036978]		
					taper_yn		= (String)non_iv_drug_details.get(i+77);
				else
					taper_yn		= (String)non_iv_drug_details.get(i+76); 
				addedTaperSch = "";
				generic_id  =(String)non_iv_drug_details.get(i+78)==null?"":(String)non_iv_drug_details.get(i+78); // Added for RUT-CRF-0065.1 [IN:43255]
				dispensed_drug_desc		 = (String)non_iv_drug_details.get(i+79);
				disp_drugs = (String)non_iv_drug_details.get(i+80);
				dispense_drug_code = (String)non_iv_drug_details.get(i+81);
			} //end if (inc == 75 )
			else if(inc == 80 ){//74 to 75 changed for GHL-CRF-0509 and 75 to 78 for GHL-CRF-0482// 79 TO 80 MODIFIED for JD-CRF-0200
				medn_admn_dtl_reqd_yn	=	non_iv_drug_details.get(i+44)==null?"":(String)non_iv_drug_details.get(i+44);
				ext_prod_id             =   non_iv_drug_details.get(i+45)==null?"":(String)non_iv_drug_details.get(i+45);
				iv_incred		        =   non_iv_drug_details.get(i+46)==null?"":(String)non_iv_drug_details.get(i+46);
				route_desc		        =   non_iv_drug_details.get(i+47)==null?"":(String)non_iv_drug_details.get(i+47);
				pres_catg_code          =   non_iv_drug_details.get(i+48)==null?"":(String)non_iv_drug_details.get(i+48);
				schedule_uom_desc	    =   non_iv_drug_details.get(i+49)==null?"":(String)non_iv_drug_details.get(i+49);
				schedule_uom_code	    =   non_iv_drug_details.get(i+50)==null?"":(String)non_iv_drug_details.get(i+50);
				sliding_scale_applicable	=	(String)non_iv_drug_details.get(i+51);
				patient_brgt_medn		=	(String)non_iv_drug_details.get(i+52);
				strength_value_prn		=	(String)non_iv_drug_details.get(i+53)==null?"":(String)non_iv_drug_details.get(i+53);
				sch_strength_value_prn		=	(String)non_iv_drug_details.get(i+54)==null?"":(String)non_iv_drug_details.get(i+54);
				content_in_pres_base_uom	=	(String)non_iv_drug_details.get(i+55);
				sch_strength_uom_prn	=	(String)non_iv_drug_details.get(i+56)==null?"":(String)non_iv_drug_details.get(i+56);
				sch_strength_uom_desc_prn	=	(String)non_iv_drug_details.get(i+57)==null?"":(String)non_iv_drug_details.get(i+57);
				dosage_type				=	(String)non_iv_drug_details.get(i+58);
				dosage					=	(String)non_iv_drug_details.get(i+59);
				dosage_uom_code			=	(String)non_iv_drug_details.get(i+60);
				dosage_uom_desc			=	(String)non_iv_drug_details.get(i+61);
				admn_dose_chng_reason_code =(String)non_iv_drug_details.get(i+62);
				linkVacScheduleCode		=	(String)non_iv_drug_details.get(i+63);
				performingDeptLocCode	=   (String)non_iv_drug_details.get(i+64)==null?"":(String)non_iv_drug_details.get(i+64);
				pres_base_uom				= (String)non_iv_drug_details.get(i+65);  //added for SKR-SCF-0304
				adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
				verificationremarks		= bean_all_stages.getVerificationRemarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				overridereason			= (HashMap)bean_all_stages.getOverrideremarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pres_remarks			= bean.getPrescriptionInstructions((String)non_iv_drug_details.get(i+13));
				drug_remarks			= bean.getDrugInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pharma_remarks			= bean.getPharmacistInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				show_remarks		= "N";
				boolAllergy_icon	= false;// Added for RUT-CRF-0065.1 [IN:43255]
				order_pract_id  =(String)non_iv_drug_details.get(i+67)==null?"":(String)non_iv_drug_details.get(i+67); //Added for [IN:040149]
				generic_id  =(String)non_iv_drug_details.get(i+68)==null?"":(String)non_iv_drug_details.get(i+68); // Added for RUT-CRF-0065.1 [IN:43255]
				route_color                 = (String)non_iv_drug_details.get(i+66)==null?"":(String)non_iv_drug_details.get(i+66);	//Code Added For RUT-CRF-0034 Start
				dispensed_drug_desc		 = (String)non_iv_drug_details.get(i+69);
				disp_drugs = (String)non_iv_drug_details.get(i+70);
				dispense_drug_code = (String)non_iv_drug_details.get(i+71);
				placed_from_verbal_order				 =	(String)non_iv_drug_details.get(i+72)==null?"":(String)non_iv_drug_details.get(i+72);//added for GHL-CRF-0509
				order_status = (String)non_iv_drug_details.get(i+72)==null?"":(String)non_iv_drug_details.get(i+72);//added for GHL-CRF-0482
				patient_stock_required = (String)non_iv_drug_details.get(i+76)==null?"":(String)non_iv_drug_details.get(i+76);//added for GHL-CRF-0482
				patient_stock_completed = (String)non_iv_drug_details.get(i+77)==null?"":(String)non_iv_drug_details.get(i+77);//added for GHL-CRF-0482
				patient_stock_yn = (String)non_iv_drug_details.get(i+78)==null?"":(String)non_iv_drug_details.get(i+78);//added for GHL-CRF-0482
				cancel_recorded_yn = (String)non_iv_drug_details.get(i+79)==null?"":(String)non_iv_drug_details.get(i+79);//added for JD-CRF-0200
				if(route_color != "" && route_color != null && route_color.length()==12 ){
					fntColor = route_color.substring(0, 6);
					backGrndColor = route_color.substring(6, 12);
			   	}//Code Added For RUT-CRF-0034 End
				if(ext_prod_id!=null && !ext_prod_id.equals("")){
					if(overridereason.size()>1){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}			
				}
				else{
					if(overridereason.size()>0){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}
				}	
			} // end else if(inc == 66 )
		
		//added for GHL-CRF-0482 - start
			if(!iv_prep_yn.equals(""))
				patient_stock_disabled="disabled";
			if(patient_brgt_medn.equals("Y"))
				patient_stock_disabled="disabled";
		//added for GHL-CRF-0482 - end			

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
			iv_incred2="";
			if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
				content_in_pres_base_uom="1";
			if(iv_incred != null){
				stiv_incred = new StringTokenizer(iv_incred,"|");
				while(stiv_incred.hasMoreTokens()){
					iv_incred1 = stiv_incred.nextToken();
					if(stiv_incred.hasMoreTokens())
						iv_incred2 = stiv_incred.nextToken();						
				}
			} 
			auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);											
			
			if(patient_stock_required.equals("")) //GHL-CRF-0482
				patient_stock_required = "N";
			
			if(auth_reqd){							
				if(pin_value.equals(""))
					auth_reqd_script=";pinAuthentication(this,'NP');";
				else
					auth_reqd_script=";pinAuthentication(this,'YP');";
			}
			if(order_type.equals("A")){
				if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){
					temp1++;
					temp2=0;
					temp3=0;
				}
				else if(iv_prep_yn.equals("8") ||iv_prep_yn.equals("7")){
					temp1=0;
					temp2=0;
					temp3++;
				}
				else{
					 temp1=0;
					 temp3=0;
					 temp2++;
				} 

				if(	temp1==1){
%>
					<tr id="non_iv_admin_table_row1" >
					<td class='COLUMNHEADER'  colspan="14"  style="font-size:10" ><b><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
					</tr>
<% 
				} // end if (temp1==1)
				else if(temp2==1){ 
%>
					<tr id="non_iv_admin_table_row1" >
					<td class='COLUMNHEADER'  colspan="14"  style="font-size:10" ><b><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
					</tr>
<%
				}
				else if(temp3==1){ 
%>
						<tr id="non_iv_admin_table_row1" >
							<td class='COLUMNHEADER'  colspan="14"  style="font-size:10" ><b><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
						</tr>
<%
				}
			} // end 	if(order_type.equals("A"))
			if(recCount==0)	
				recCount = 1;						
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;						
			flag="Y";
			disp_drug_code	= (String)non_iv_drug_details.get(i);
			drug_code		= (String)non_iv_drug_details.get(i+28);
			if(dispense_drug_code.equals(""))
				dispense_drug_code = drug_code;
			store_code		= (String)non_iv_drug_details.get(i+29);	
			drug_class		= non_iv_drug_details.get(i+30)==null?"":(String)non_iv_drug_details.get(i+30);
			end_date_time	= (String)non_iv_drug_details.get(i+32);
			drug_desc		= (String)non_iv_drug_details.get(i+1);	
			encode_drug_desc= drug_desc.replaceAll(" ","%20");
			encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
			encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");
			int adr_count			= bean.getADRCount(patient_id_test,drug_code);  //newly added for RUT-SCF-0144 [IN:033371] 
			qty				= non_iv_drug_details.get(i+2)==null?"0":(String)non_iv_drug_details.get(i+2);
			ordered_qty		= non_iv_drug_details.get(i+2)==null?"0":(String)non_iv_drug_details.get(i+2);
			short_desc		= non_iv_drug_details.get(i+3)==null?"":(String)non_iv_drug_details.get(i+3);
			batch_id		= non_iv_drug_details.get(i+4)==null?"":(String)non_iv_drug_details.get(i+4);
			expiry_date		= non_iv_drug_details.get(i+5)==null?"":(String)non_iv_drug_details.get(i+5); 
			tradename		= non_iv_drug_details.get(i+6)==null?"":(String)non_iv_drug_details.get(i+6);
			item_code		= (String)non_iv_drug_details.get(i+7);
			order_id	    = (String)non_iv_drug_details.get(i+13);
			order_line_num  = (String)non_iv_drug_details.get(i+14);
			patient_id	    = (String)non_iv_drug_details.get(i+15);
			sch_date_time   = (String)non_iv_drug_details.get(i+16);
			if(dob==null || dob.equals("")) //added for ARYU-SCF-023
				dob = bean.getPatientDOB(patient_id);
			sch_date_time_in_locale = sch_date_time; // 26119 : sch_date_time is again converted into eng date so compare date is giving wrong result. hence storing it in another var before convertion.
					//added for skr-scf-1290
					if(!locale.equals("en")){
						sch_date_time_in_en= com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en");
					}
			uom_code		= (String)non_iv_drug_details.get(i+43);
			disp_schedule_uom_desc= schedule_uom_desc.replaceAll(" ","%20");
			disp_schedule_uom_desc= java.net.URLEncoder.encode(disp_schedule_uom_desc,"UTF-8");
			disp_schedule_uom_desc= disp_schedule_uom_desc.replaceAll("%2520","%20");
			admin_uom_desc= short_desc.replaceAll(" ","%20");
			admin_uom_desc= java.net.URLEncoder.encode(admin_uom_desc,"UTF-8");
			admin_uom_desc= admin_uom_desc.replaceAll("%2520","%20");
		//GHL-CRF-0482 - start
			if(patient_stock_completed.equals("Y"))
				patient_stock_checked = "checked";
			else
				patient_stock_checked = "";
		//GHL-CRF-0482-end
			if(iv_prep_yn.equals("9") &&  Integer.parseInt(onco_direct_drug_count)>1 && order_line_num.equals("1"))
				classvalue="IVFLUID1";
			if(iv_prep_yn !=null && iv_prep_yn.equals("7"))
				   ppn_count = bean.getPPNIOrderValues(order_id, patient_id);

			    Store_locn_code	= performingDeptLocCode;
			//IF condtion added for ghl-crf-0509
			    if(issitespec_verbal_order_yn)
					{
					Storelocn_code="";
					}
					else
			    {
						Storelocn_code	= bean.getStoreLocnnCode(nursing_unit);
			    }
		
			if(!Storelocn_code.equals("")  ){
				non_iv_drug_details.set(i+29,Storelocn_code);
				store_code		= Storelocn_code;
			}
			if(Storelocn_code.equals("")) //added for AAKH-CRF-0024 [IN:038260]
				Storelocn_code=Store_locn_code;
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
			HashMap  administred_batch   =  bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);						
			administred_batch_id         = (String)administred_batch.get("BATCH_ID")==null?"":(String)administred_batch.get("BATCH_ID");
			disp_batch_id		 = (String)administred_batch.get("DISP_BATCH_ID")==null?"":(String)administred_batch.get("DISP_BATCH_ID");					
			disp_exp_dt			 = (String)administred_batch.get("DISP_EXPIRY_DATE")==null?"":(String)administred_batch.get("DISP_EXPIRY_DATE");
			disp_trade_id		 = (String)administred_batch.get("DISP_TRADE_ID")==null?"":(String)administred_batch.get("DISP_TRADE_ID");
			if(!locale.equals("en")){
				sch_date_time = com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en");
				expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date, "DMY",locale,"en");
			}	
						
			if(!locale.equals("en"))
				disp_exp_dt = com.ehis.util.DateUtils.convertDate(disp_exp_dt, "DMY",locale,"en");
			dosage_seq_no		= (String)non_iv_drug_details.get(i+17);
			trade_id			= (String)non_iv_drug_details.get(i+18)==null?"":(String)non_iv_drug_details.get(i+18);			
			dis_continued		= (String)non_iv_drug_details.get(i+19);
			hold				= (String)non_iv_drug_details.get(i+20);
			administered		= (String)non_iv_drug_details.get(i+21)==null?"":(String)non_iv_drug_details.get(i+21);
			//administered		= (String)non_iv_drug_details.get(i+22)==null?"N":(String)non_iv_drug_details.get(i+22);
			admin_recorded_yn   = request.getParameter("admin_recorded_yn")==null?"Y":request.getParameter("admin_recorded_yn"); 	
			if(non_iv_drug_details.get(i+22) == null || !((String)non_iv_drug_details.get(i+22)).equals("Y"))
			  admin_recorded_yn = "N";
			remarks				=  non_iv_drug_details.get(i+23)==null?"Not Entered":(String)non_iv_drug_details.get(i+23);
			admindrugdetails	= (String)non_iv_drug_details.get(i+24);
			pract_id			= (String)non_iv_drug_details.get(i+36);
			against_sch_date	= (String)non_iv_drug_details.get(i+37);
			if(!locale.equals("en"))
			   against_sch_date = com.ehis.util.DateUtils.convertDate(against_sch_date, "DMYHM",locale,"en");
			adr_reason			= (String)non_iv_drug_details.get(i+38);
			adr_remarks			= non_iv_drug_details.get(i+39)==null?"":(String)non_iv_drug_details.get(i+39);
			adr_record_time		= (String)non_iv_drug_details.get(i+40);
			adr_recorded_by		= (String)non_iv_drug_details.get(i+41);
			pres_dosage			= (String)non_iv_drug_details.get(i+42);
			pres_unit			= (String)non_iv_drug_details.get(i+43);
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
						admin_dose_prn  = stadmindrugdetails.nextToken();	   // added for SKR-SCF-0304
					if(stadmindrugdetails.hasMoreTokens())
						admin_uom = stadmindrugdetails.nextToken();//admin_uom added for BRU-CRF-399.1
				}
			}
			admin_by_name = (String)non_iv_drug_details.get(i+25);
			auth_by_name  = (String)non_iv_drug_details.get(i+31);
			freq_code	  = (String)non_iv_drug_details.get(i+33);
			freq_nature	  = (String)non_iv_drug_details.get(i+34);
			showTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name;
			if(auth_by_name!=null && !auth_by_name.equals("")){
				showTitle =showTitle + "\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name ;
			}
			admin_date_time = "";
			if(non_iv_drug_details.get(i+26)!= null){
				admin_date_time = (String)non_iv_drug_details.get(i+26);
				if(!locale.equals("en"))
					admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM",locale,"en");
			}
			modified_date_time = non_iv_drug_details.get(i+27)==null?"":(String)non_iv_drug_details.get(i+27);
			if(freq_nature!=null && freq_nature.equals("O")) 
				stat_style	=	"background-color:#CE00CE";
			else if(freq_nature!=null && freq_nature.equals("P"))
				stat_style	=	"background-color:#804040";
			else 
				stat_style	=	"";

			alt_drug			=	bean_all_stages.checkMultiStrength(drug_code);
			bean_all_stages.addDrugs(patient_id,patient_id,drug_code,alt_drug,order_line_num);	
			float tot_alt_qty       = 0.0f;

			if(multi_drugs!=null && multi_drugs.size()>0){ // added for regration issue
			for(int n=0; n<multi_drugs.size(); n+=5){ 
				tot_alt_qty += Float.parseFloat((String)multi_drugs.get(n+3));
			}
			}
            patient_class_ord = bean.getOrderPatientClass(order_id);//GHL-CRF-0458 Moved this to here  for NMC-JD-CRF-0186:  46294
			displayStyle		=	"";
			statusFlag		=	"YES";	// Whether it has to be considered for transaction or not.	// It won't be considered if Alternate Drug is selected.
			addDisplayStyle	=	"";
			checked			=	"";
			// START NMC-JD-CRF-0186 [43323]
			String  episode_type = "";
			String  visit_id = "";
			String  classValSelect = "visibleCheck";
			String  isEnabled = "enable";
			boolean  billChecked = true;
			String unbilledMedicateYN =  bean.getUnbilledMedicateYN(facility_id);
			ArrayList epVisitResult =  bean.getDetails(facility_id, patient_id, encounter_id);
			if(epVisitResult.size() != 0){ 
				episode_type =(String)epVisitResult.get(0);
				visit_id =(String)epVisitResult.get(1);
			 }
			boolean mar_unbill_med_blueColor_disable =  bean.isSiteSpecific("PH","ALLOW_MAR_DISP_UNBILL_MED");//added for NMC-JD-CRF-0186 US002&03 [45063]		
			String billStatus =  bean.getBillStatus(facility_id,patient_id,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num)==null?"":bean.getBillStatus(facility_id,patient_id,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num);  // "" - episode_id
			
			if(billStatus.equals("UNBILLED") && (unbilledMedicateYN.equals("N") 
					|| unbilledMedicateYN == "N") && mar_unbill_med_blueColor_disable && administered.equals("N") && (patient_class_ord.equals("OP")||patient_class_ord.equals("EM"))){ /* [45063] Added for NMC-JD-CRF-0186[46294] */ 
				classValSelect  = "hiddenCheck"; 
				isEnabled  = "disabled"; 
				billChecked  = false; 
			} 
			//END NMC-JD-CRF-0186 [43323]
			select_status_1			=   "";
			  if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ // Added for GHL-CRF-0482 [IN:064955] - Start
					future_or_late_admin = ""; 
			  } // Added for GHL-CRF-0482 [IN:064955] - End
			
			if(bean.getCurrentTimeAndAdminWithinHRS().size()>2){
			  future_date_time   = com.ehis.util.DateUtils.plusDate(current_date_time,"DMYHM",locale,Integer.parseInt(bean.getCurrentTimeAndAdminWithinHRS().get(1).toString()),"h").toString(); 
			}		
			if (admin_bean.compareDates(sch_date_time_in_locale,admin_from_date) && !(freq_nature.equals("P"))){
				medn_admn_dtl_reqd_yn = "Y";
			  if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ // Added for GHL-CRF-0482 [IN:064955] - Start
				future_or_late_admin = "L"; 
			  } // Added for GHL-CRF-0482 [IN:064955] - End
			}
			else if(admin_bean.getEarlyOrLateAdminYn().equals("Y") && admin_bean.compareDates(future_date_time,sch_date_time_in_locale) &&  !(freq_nature.equals("P"))){ // Added for GHL-CRF-0482 [IN:064955] - Start
				medn_admn_dtl_reqd_yn = "Y";
				future_or_late_admin = "F";
			} // Added for GHL-CRF-0482 [IN:064955] - End
			if(medn_admn_dtl_reqd_yn == null)
				medn_admn_dtl_reqd_yn="N";
			if(medn_admn_dtl_reqd_yn.equals("Y")) 
				mand_display	=	"style='display:inline'";
			else
				mand_display	=	"style='display:none'";

			select_status	=	"";
			dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";
		
			if(!locale.equals("en"))
				sch_date_time = com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM","en",locale);
			if(freq_code!=null && freq_code.equals("STAT"))//added by abdul for SCF# 5899
				displayStyle	=	"background-color:#CE00CE;";
			else if(dis_continued.equals("Y"))
				displayStyle = "BACKGROUND-COLOR:red;";
			else if(hold.equals("Y"))
				displayStyle = "BACKGROUND-COLOR:yellow;";
			else if(admin_recorded_yn.equals("Y")){
				if(administered.equals("N")) {
					displayStyle = "BACKGROUND-COLOR:#000000;cursor:pointer;";//added for AAKH-CRF-0024 [IN:038260]
					could_not_administer = "Y";
				} 
				else{  
					displayStyle = "BACKGROUND-COLOR:green;";
					batch_ids	= new ArrayList();
				}
			}
			verbalOrder="";	
			if((bean.getPractitionerType(pract_id)).equals("NS"))
				verbalOrder="<b>V<b>";
			if(admin_recorded_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
				showTitle =  ("Ordered Drug : "+drug_desc+"\n") + showTitle;
				displayStyle = "BACKGROUND-COLOR:#CC99CC;";
			}
			if(drug_class!=null && drug_class.equals("N"))
				drug_class_ind = "background:#66FFFF";
			else if(drug_class!=null && drug_class.equals("C"))
				drug_class_ind = "background:#CCFFCC";
			else if(iv_prep_yn.equals("6"))
				drug_class_ind = "background:#E4CAFF";
			else
				drug_class_ind = "";
			adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
			adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;									
			if(!admin_date_time.equals("")){
				img_path	=	"<img SRC='../../eOR/images/Authorized.gif' onClick=\"recordADR('"+encounter_id+"','"+drug_code+"','1',this,'"+sch_date_time+"','"+order_id+"')\" title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordPostAdministrationDetails.label", "ph_labels")+"' style='cursor:pointer'></img>";
			}
			 drug_indication_remarks=bean_all_stages.getdrugIntaractions(order_id,order_line_num);
			
			if(drug_indication_remarks.trim().equals("") && drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N")){
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
				if(sliding_scale_details.size()>0)
					AdUOM=(String)sliding_scale_details.get(6);
			}
			alt_drug_display="display:none";				//Added for Bru-HIMS-CRF-399 [IN:043767] start
			arrAltDrugs = bean_all_stages.getAlternateDrugs(drug_code,generic_id);
			if(allow_mar_alternate_drug_yn.equals("Y") && Auto_Admin.equals("Y") && alt_drug.equals("Y") && arrAltDrugs.size()>0){
				alt_drug_display="display:inline";			//Added for Bru-HIMS-CRF-399 [IN:043767] end
				alt_flag = true;
			}
%>
			<input type="hidden" name="non_iv_sliding_scale_<%=recCount%>" id="non_iv_sliding_scale_<%=recCount%>" value="<%=sliding_scale_applicable%>">	
			<input type="hidden" name="modified_date_time_<%=recCount%>" id="modified_date_time_<%=recCount%>" value="<%=modified_date_time%>">
<%
			if(admin_recorded_yn.equals("Y") || dis_continued.equals("Y") || hold.equals("Y")){
				if(admin_recorded_yn.equals("Y") && administered.equals("N"))
					batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"N");
				else if(admin_recorded_yn.equals("Y") && administered.equals("Y")){//Added for INC#48901--start
					batch_ids.add(batch_id);
					batch_ids.add(expiry_date);
					batch_ids.add(trade_id);
					batch_ids.add(tradename);//Added for INC#48901--end
					batch_ids.add("");
					batch_ids.add("");
					batch_ids.add("");//added for GHL-CRF-458
					batch_ids.add("");//added for GHL-CRF-482
					batch_ids.add("");//added for GHL-CRF-482

				}
				else
					batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"Y");
%>
				<tr id='new<%=recCount%>'>
				<td id='medAdmInd<%=recCount%>' class="white" width="2%" style="<%=displayStyle%>" onClick="enableData('<%=locale%>','<%=current_date_time%>','<%=sch_date_time%>','<%=administered%>','<%=admin_recorded_yn%>','<%=recCount%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=iv_prep_yn%>','<%=order_line_num%>')"><%=verbalOrder%></td>
				<td id ='drugClassIndi<%=recCount%>' class="<%=classvalue%>" style="<%=drug_class_ind%>">	
				<!-- added for AAKH-CRF-0024 [IN:038260] Start -->
<%	
				if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {
%>
					<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;display:none;' onclick="loadPage('<%=disp_drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
<%				}
				else{
%>
					<label  id="drug_mast_det_<%=recCount%>">&nbsp;</label>
<%
				}/*added for AAKH-CRF-0024 [IN:038260] ends  */
				if(admin_recorded_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){												
%>
					<label id = 'drugDesc<%=recCount%>' class='descFont' ><%=admin_drug_desc%>
<%								
				}
				else{												
%>
					<label id = 'drugDesc<%=recCount%>' class='descFont'><%=drug_desc%>		
<%
				}
				if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1")&&(Integer.parseInt(onco_direct_drug_count)>1)) && !(iv_prep_yn.equals("6"))){
%>
					<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(admin_drug_desc,"UTF-8")%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
				}
				if(imageFileURL!=null && !imageFileURL.equals("")){
%>
					<img src='../../ePH/images/camera.gif' width='17' height='15' onclick = "showImage('<%=drug_code%>','<%=trade_code%>');" onmouseover="changeCursor(this);">
<%
				}
				if(adr_count>0){ // added for RUT-SCF-0144 [IN:033371]  -- start
%>
					<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=drug_code%>');"></img>
<%
				} //added for RUT-SCF-0144 [IN:033371]  -- end
				if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
					<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" onmouseover="changeCursor(this);">
<%										
				}
				if(iv_prep_yn.equals("7")){
					if(ppn_count >0){
%>
						<img src='../../ePH/images/AddedIngredient.gif' width='17' height='15' onclick = "openPPNDisplay('<%=patient_id%>','<%=order_id%>','<%=Store_locn_code%>')" onmouseover="changeCursor(this);"	>							  
<%	
					}
				}
				if(boolAllergy_icon){
%>
						<img src='../../eCA/images/HI_RecordAllergies.gif' width='17' height='15' onclick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=encode_drug_desc%>');" onmouseover="changeCursor(this);">
<%					
				}
				if(taper_yn.equals("Y") && totalTaperQtyDisplay.equals("Y") ){   //if and else Added for RUT-CRF-0088 [IN036978]
					addedTaperSch = bean.getAddedTaperSch(facility_id+"~"+encounter_id+"~"+order_id+"~"+drug_code+"~"+sch_date_time);
					if(addedTaperSch.equals("N") && administered.equals("Y") ){  // Checks whether this row has been taperd or not
%>			
						<label style='color:blue;text-align:right;' onmouseover="changeCursor(this);"  onclick="taperCurrRow('<%=i%>','<%=inc%>','<%=encounter_id%>')">&nbsp;+&nbsp;<fmt:message key="Common.Taper.label" bundle="${common_labels}"/></label>
<%
					}
					else{
%>						
						<label style='color:black;;text-align:right;'>&nbsp;<fmt:message key="Common.Taper.label" bundle="${common_labels}"/></label>
<%				
					}
					if(addedTaperSch.equals("Y"))
						addedTaperSch = "disabled";
				}
%>
				</label>
				<input type="hidden" name="non_iv_status_flag_<%=recCount%>" id="non_iv_status_flag_<%=recCount%>" value="<%=statusFlag%>">
				<input type="hidden" name="non_iv_dosage_seq_no_<%=recCount%>" id="non_iv_dosage_seq_no_<%=recCount%>" value="<%=dosage_seq_no%>">
				<input type="hidden" name="non_iv_drug_code_<%=recCount%>" id="non_iv_drug_code_<%=recCount%>" value="<%=drug_code%>">
				<input type="hidden" name="non_iv_dispense_drug_code_<%=recCount%>" id="non_iv_dispense_drug_code_<%=recCount%>" value="<%=dispense_drug_code%>">
				<input type="hidden" name="non_iv_item_code_<%=recCount%>" id="non_iv_item_code_<%=recCount%>" value="<%=item_code%>">
				<input type="hidden" name="non_iv_order_id_<%=recCount%>" id="non_iv_order_id_<%=recCount%>" value="<%=order_id%>">
				<input type="hidden" name="non_iv_order_line_no_<%=recCount%>" id="non_iv_order_line_no_<%=recCount%>" value="<%=order_line_num%>">
				<input type="hidden" name="non_iv_store_code_<%=recCount%>" id="non_iv_store_code_<%=recCount%>" value="<%=store_code%>">	
				<input type="hidden" name="non_iv_end_date_<%=recCount%>" id="non_iv_end_date_<%=recCount%>" value="<%=end_date_time%>">	
				<input type="hidden" name="non_iv_Auto_Admin_<%=recCount%>" id="non_iv_Auto_Admin_<%=recCount%>" value="<%=Auto_Admin%>">
				<input type="hidden" name="order_pract_id_<%=recCount%>" id="order_pract_id_<%=recCount%>" value="<%=order_pract_id%>"> <!-- //Added for [IN:040149]-->
				<%if(cancel_recorded_yn.equals("Y")){%>
				<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=encode_drug_desc%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id%>','<%=encounter_id%>','<%=admin_date_time%>')"></img>
				<%}%>
				</td>
<%
				if(adr_reason!=null && !adr_reason.equals("")) {
%>
					<td nowrap class='<%=classvalue%>'  width="2%"><img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>"></img></td>
<%
				} 
				else if(!admin_date_time.equals("") && administered.equals("Y")){
%>
					<td nowrap class='<%=classvalue%>'  width="2%"><%=img_path%></td> 
<%
				}
				else{
%>
					<td nowrap class='<%=classvalue%>'  width="2%">&nbsp;</td>					
<%	
				}
%>
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
				else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){	
%>
					<label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','','MAR','<%=Store_locn_code%>','<%=sliding_scale_applicable%>','N');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label>
<%
				}
				else if(iv_prep_yn.equals("6")){	
%>
					<label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','','MAR','<%=Store_locn_code%>','<%=sliding_scale_applicable%>','N');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label>
<%
				}
				else{	
%>
					<label  style="cursor:pointer;font-size:9;color:blue" onClick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','<%=order_line_num%>','MAR','<%=Store_locn_code%>','<%=sliding_scale_applicable%>','N');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label>
<%
				}
%>
				</td>
				<td class="<%=classvalue%>">
<%				
				if(alt_flag){//BRU-CRF-399.1
					schedule_uom_desc = bean.getUomDisplay(facility_id,admin_uom);
					short_desc		  = schedule_uom_desc;
				}
				if(Float.parseFloat(qty) < 1.0){
					qty = Float.parseFloat(qty)+""; 
				}
				if((dis_continued.equals("Y") || hold.equals("Y"))&& !(admin_recorded_yn.equals("Y")) && sliding_scale_applicable.equals("Y")){
					AdUOM="&nbsp;";
%>					<label  style="font-size:9;font-weight:bold;color:black">&nbsp;</label>

<%				}
				else{
					if(freq_nature.equals("P")) {//	added  for SCF-7692 -- incident no 27804 -- start
						qty=admin_dose_prn;
						
					} // Added for SKR-SCF-304
					if(could_not_administer.equals("")){ //if added for SKR-SCF-1264
					if(dosage_type.equals("S")){
%>					
						<label id="non_iv_admin_qty1_old<%=recCount%>" style="font-size:9;font-weight:bold;color:black"><%=qty%></label>	
<%					}
					else  { // for others (absolute, quantity.)
%>					
						<label id="non_iv_admin_qty1_old<%=recCount%>" style="font-size:9;font-weight:bold;color:black"><%=qty%></label>	
<%
					}//SCF-7692 -- incident no 27804 -- end
					}else{ //else block added for SKR-SCF-1264
%>
					<label id="non_iv_admin_qty1_old<%=recCount%>" style="font-size:9;font-weight:bold;color:black">0</label>
<%					}  
				}
				if(sliding_scale_applicable.equals("Y")){
%>
					<label id='dosageDescriptionOld<%=recCount%>' style="font-size:9;font-weight:bold;color:black"><%=AdUOM%></label>
<%
					dosageDescription = AdUOM;
				}
				else{
					if(freq_nature.equals("P")){ //PRN

%>	
						 <label  id='dosageDescriptionOld<%=recCount%>' style="font-size:9;font-weight:bold;color:black"><%=schedule_uom_desc%></label> 
<%
						 dosageDescription = schedule_uom_desc;
					}
					else{
%>
						<label  id='dosageDescriptionOld<%=recCount%>' style="font-size:9;font-weight:bold;color:black"><%=short_desc%></label>
<%
						dosageDescription = short_desc;
					}
				}
%>
				<input type="text" style="display:none" id="non_iv_admin_qty1_<%=recCount%>"  name="non_iv_admin_qty1_<%=recCount%>" size="5" maxlength="13" onKeyPress="return allowValidNumber(this,event,6,3);" oncopy="return false" onpaste="return false" onBlur="CheckNum(this);updateNonIvAdminQuantity(this,'<%=recCount%>','<%=strength_value_prn%>','<%=dosage_type%>','<%=content_in_pres_base_uom%>','<%=strength_per_value_pres_uom%>','<%=disp_with_alt%>'); makeDtlsMandatory(this,'<%=recCount%>','<%=drug_code%>','noniv','<%=freq_nature%>'); " value="<%=qty%>" class="NUMBER" style="font-size:11;<%=addDisplayStyle%>" <%=select_status%>><label id='dosageDescription<%=recCount%>' style="font-size:10;display:none" ><b><%=dosageDescription%></b></label>	 <!--//added for AAKH-CRF-0024 [IN:038260] -->
<%
				if(!(admn_dose_chng_reason_code.equals(""))){
					String admn_chng_dose_reason_desc = (String) bean. getAdmn_chng_dose_reason_desc(admn_dose_chng_reason_code);
%>
					<img src="../images/changeddosageindicator.gif" align="center" id="chng_dose_ind" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels") +"\n"%>------------------<%="\n"+admn_chng_dose_reason_desc%>"></img>
<%
				}
%>
				<input type="hidden" name="non_iv_admin_qty_<%=recCount%>" id="non_iv_admin_qty_<%=recCount%>" value="<%=qty%>">	
				<input type="hidden" name="non_iv_bal_qty_<%=recCount%>" id="non_iv_bal_qty_<%=recCount%>" value="<%=qty%>"><!-- added for AAKH-CRF-0024 [IN:038260] -->
				<input type="hidden" name="h_non_iv_admin_qty_<%=recCount%>" id="h_non_iv_admin_qty_<%=recCount%>" value="<%=qty%>"><!-- added for AAKH-CRF-0024 [IN:038260] -->
<%
				if(freq_nature.equals("P")){	
%>
					<input type="hidden" name="non_iv_admin_qty_uom_<%=recCount%>" id="non_iv_admin_qty_uom_<%=recCount%>" value="<%=schedule_uom_code%>">
<%
				}
				else{ 
%>
					<input type="hidden" name="non_iv_admin_qty_uom_<%=recCount%>" id="non_iv_admin_qty_uom_<%=recCount%>" value="<%=uom_code%>">
<%
				}
%>
				</td>
				<td class="<%=classvalue%>" style="color:<%=fntColor%>;background-color:<%=backGrndColor%>;font-size:10;"><label> <%=route_desc%></label></td>
				<%
				   fntColor ="000000";    //Code Changed For RUT-CRF-0034 Route Color
				   backGrndColor="FFFFFF";
				%>
				<td class="<%=classvalue%>" id="non_iv_MFR_status_column_<%=recCount%>">
<%
				if(!(sch_date_time==null || freq_nature.equals("P"))){
%>
					<!-- <label style="font-size:9;font-weight:bold;color:black" ><%=sch_date_time%></label> -->
	<%				if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014- start
							MfrDetails=bean.getStatusOfMAR(order_id,"");

							if(MfrDetails.size()>0){
								statusString=(String)MfrDetails.get(0);
								mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue(); 														
							}
							if(!mfrCompletedStatus ){// if added for ml-mmoh-crf-1014
								select_status="disabled";
							}
							%>
							<%if(order_line_num.equals("1")){%><label name="non_iv_MFR_dtls_<%=recCount%>" id="non_iv_MFR_dtls_<%=recCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openMFRDetails('<%=recCount%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=drug_code%>','<%=Store_locn_code%>','NotAdmin','','','','','','','Y');"><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label>&nbsp;&nbsp;&nbsp;&nbsp <a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=mfrRemarks%>','Y');" id='mfrRemarksLink_<%=recCount%>'>&nbsp;&nbsp;&nbsp;<font color="red"><b><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></b></font></a><%}else{%>
							&nbsp;&nbsp;&nbsp;
							<%}%></td>
							<input type="hidden" name="non_iv_mfrRemarks<%=recCount%>" id="non_iv_mfrRemarks<%=recCount%>" value="<%=mfrRemarks%>">
<%						}else{ %>
					<label id='sch_date_time<%=recCount%>' class='descFont' ><%=sch_date_time%></label>
<%					}
				}
				else{
%>
					<label id='sch_date_time<%=recCount%>' class='descFont' >&nbsp;</label>
<%
				}
%>
				</td>				
<%
				if(!admin_date_time.equals("")){
					if(!locale.equals("en")){
						modified_date_time = com.ehis.util.DateUtils.convertDate(modified_date_time, "DMYHM","en",locale);
						admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM","en",locale);
					}
%>
					<td class="<%=classvalue%>">
						<label id='recordeddatetime<%=recCount%>' class='descFont' title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddatetime.label", "common_labels")%> : <%=modified_date_time%>"><%=admin_date_time%></label>
						<input type="text" id="non_iv_time_<%=recCount%>" name="non_iv_time_<%=recCount%>" size="15" maxlength="16" value="<%=defaultDate.equals("")?current_date_time:defaultDate%>" <%=select_status%> onBlur="validateAdminDateTime('<%=admin_date_time%>','<%=current_date_time%>', this,'<%=locale%>');" style="font-size:11;display:none;">
					</td>
 <%
				}
				else{
					if(!locale.equals("en")){
						modified_date_time = com.ehis.util.DateUtils.convertDate(modified_date_time, "DMYHM","en",locale);
					}
%>
					<td class="<%=classvalue%>">
						<label id='recordeddatetime<%=recCount%>' class='descFont' title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddatetime.label", "common_labels")%> : <%=modified_date_time%>">&nbsp;</label>
						<input type="text" id="non_iv_time_<%=recCount%>" name="non_iv_time_<%=recCount%>" size="15" maxlength="16" value="<%=defaultDate.equals("")?current_date_time:defaultDate%>" <%=select_status%> onBlur="validateAdminDateTime('<%=modified_date_time%>','<%=current_date_time%>', this,'<%=locale%>');" style="font-size:11;display:none;">
					</td>
<%
				}
%>
				<input type="hidden" name="non_iv_sch_date_time_<%=recCount%>" id="non_iv_sch_date_time_<%=recCount%>" value="<%=sch_date_time%>"><!-- added for AAKH-CRF-0024 [IN:038260] -->
<%
				bat_id_lookbutton_enabled="Y"; //Added FOR  [IN:043702] -Start
				if(!(sliding_scale_applicable.equals("Y")&& batch_ids.size()==0)){		
					if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")||iv_prep_yn.equals("8"))
							bat_id_lookbutton_enabled="NOT";
					else if(batch_ids.size()==0){
						bat_id_lookbutton_enabled="Y";
						if(auto_Admin_dis.equals("disabled")||select_status.equals("disabled"))
							bat_id_lookbutton_enabled="N";
					}
					else if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 //and 7 to 9 for GHL-CRF-0482
						batch_id = (String)batch_ids.get(0);
						expiry_date = (String)batch_ids.get(1);
						trade_id    = (String)batch_ids.get(2);
						tradename   = (String)batch_ids.get(3);
						select_status="disabled";
						totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
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
						bat_id_lookbutton_enabled="N";
						if(ret_qty>0){
							batch_id="";
							expiry_date="";
							select_status="";
						}
					}
					else
						bat_id_lookbutton_enabled="NOT";
				}
				else
					bat_id_lookbutton_enabled="N"; //Added for  [IN:043702] -end //onclick="enableDisableTextbox - aaded for [IN:043702]
				if(adminsted_pat_brought_medn.equals("Y")){
%>
					<td class="<%=classvalue%>" ><input type='checkbox'  id = "pat_brought_med_<%=recCount%>" name="pat_brought_med_<%=recCount%>" value="<%=adminsted_pat_brought_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','<%=bat_id_lookbutton_enabled%>','<%=iv_prep_yn%>','<%=order_line_num%>');" checked disabled></td>
<%				}
				else{
%>
					<td class="<%=classvalue%>" ><input type='checkbox' id = "pat_brought_med_<%=recCount%>" name="pat_brought_med_<%=recCount%>" value="<%=adminsted_pat_brought_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','<%=bat_id_lookbutton_enabled%>','<%=iv_prep_yn%>','<%=order_line_num%>');" disabled></td>
<%									
				}
%>
				<input type="hidden" name="onco_direct_drug_count_<%=recCount%>" id="onco_direct_drug_count_<%=recCount%>" value="<%=onco_direct_drug_count%>"><!-- added for AAKH-CRF-0024 [IN:038260] Starts -->
				<input type="hidden" name="bat_id_lookbutton_enabled<%=recCount%>" id="bat_id_lookbutton_enabled<%=recCount%>" value="<%=bat_id_lookbutton_enabled%>">
				<input type="hidden" name="medn_admn_dtl_reqd<%=recCount%>" id="medn_admn_dtl_reqd<%=recCount%>" value="<%=medn_admn_dtl_reqd_yn%>">
				<input type="hidden" name="non_iv_drug_class<%=recCount%>" id="non_iv_drug_class<%=recCount%>" value="<%=drug_class%>">
				<input type="hidden" name="non_iv_dtls_yn<%=recCount%>" id="non_iv_dtls_yn<%=recCount%>" value="N">	
				<input type="hidden" name="non_iv_dosage_type_<%=recCount%>" id="non_iv_dosage_type_<%=recCount%>" value="<%=dosage_type%>">
				<input type="hidden" name="non_iv_qty_in_disp_mode_<%=recCount%>" id="non_iv_qty_in_disp_mode_<%=recCount%>" value="">
				<input type="hidden" name="Remarks<%=recCount%>" id="Remarks<%=recCount%>" value="N">
				<input type="hidden" name="iv_prep_yn_forNONIV<%=recCount%>" id="iv_prep_yn_forNONIV<%=recCount%>" value="<%=iv_prep_yn%>">
				<input type="hidden" name="non_iv_trade_id_<%=recCount%>" id="non_iv_trade_id_<%=recCount%>" value="<%=trade_id%>" >
				<input type="hidden" name="non_iv_bin_code_<%=recCount%>" id="non_iv_bin_code_<%=recCount%>" value="" >
				<input type="hidden" name="non_iv_trade_name_<%=recCount%>" id="non_iv_trade_name_<%=recCount%>" size="21" maxlength="40" disabled value="<%=defaultTradeId.equals("")?tradename:defaultTradeId%>" style="font-size:11;<%=addDisplayStyle%>">		<!-- added for AAKH-CRF-0024 [IN:038260] Ends -->
				<td class="<%=classvalue%>">
<%
				if(batch_id.equals(disp_batch_id) || disp_batch_id.equals("")){
%>
					<label id = 'disp_batch_id<%=recCount%>' style="font-size:9;font-weight:bold;color:black" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.TradeName.label", "common_labels")%> : <%=tradename%>">&nbsp;<%=batch_id%></label>
<%
				}
				else{
%>
					<label id = 'disp_batch_id<%=recCount%>' style="font-size:9;font-weight:bold;color:green" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DispBatchId.label", "ph_labels")%> : <%=disp_batch_id%>  <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DispExpiryDate.label", "ph_labels")%> : <%=disp_exp_dt%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DispTradeId.label", "ph_labels")%> :<%=disp_trade_id%>" >&nbsp;<%=batch_id%>
					</label>
<%
				}
%>					
				<input type="text" id="non_iv_batch_id_<%=recCount%>" name="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>"  style="font-size:11;display:none" disabled>
				<input type="button" id="non_iv_batch_id_but_<%=recCount%>" class="button" value="?" name="non_iv_batch_id_but_<%=recCount%>" <%=select_status%> onClick="calcQuantityInDispensingUOM('NONIV','<%=recCount%>');callMednBatchSearch('non_iv_batch_id_<%=recCount%>','non_iv_expiry_date_<%=recCount%>','non_iv_trade_name_<%=recCount%>','non_iv_trade_id_<%=recCount%>','non_iv_bin_code_<%=recCount%>','<%=drug_code%>','<%=recCount%>','non_iv_time_<%=recCount%>','<%=Storelocn_code%>','NONIV','<%=recCount%>')" style="visibility:hidden">
				</td>
				<td class="<%=classvalue%>">
					<label  style="font-size:9;font-weight:bold;color:black" id="lbl_expiry_date<%=recCount%>" title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.expiryDate.label", "common_labels")%> &nbsp;<%=com.ehis.util.DateUtils.convertDate(expiry_date, "DMY","en",locale)%>'> &nbsp;<%=com.ehis.util.DateUtils.convertDate(expiry_date, "DMY","en",locale)%></label>
					<input type="text" name="non_iv_expiry_date_<%=recCount%>" id="non_iv_expiry_date_<%=recCount%>" size="9" maxlength="10"  value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>" disabled style="font-size:11;<%=addDisplayStyle%>" onblur="ExpiryDateValidationForPatBroughtMedn(this)"  style="display:none"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='exp_dt_cal_<%=recCount%>' onClick=" showCalendar('non_iv_expiry_date_<%=recCount%>');" style="visibility:hidden" >
				</td>
				<td class="<%=classvalue%>" style="display:none">
					<label  style="font-size:9;font-weight:bold;color:black" id='lbl_trade_name<%=recCount%>'>&nbsp;<%=tradename%></label>
				</td>
				<td class="<%=classvalue%>"   style="<%=stat_style%>">
<%
				if(!(iv_prep_yn.equals("9")&&!(order_line_num.equals("1")))){
%>
					<input type="hidden" name="non_iv_admin_chng_dtls_req_<%=recCount%>" id="non_iv_admin_chng_dtls_req_<%=recCount%>" value="N">
					<input type="checkbox" id="non_iv_chk_<%=recCount%>" name="non_iv_chk_<%=recCount%>" value="E" checked onClick="validateFieldsForDrug(this,'<%=recCount%>','<%="N"%>') ; clearDrgRemarks(this,'<%=recCount%>','<%=drug_code%>','NonIV')"  <%=select_status_1%> style="display:none">
					<label id="non_iv_remarks_<%=recCount%>" name="non_iv_remarks_<%=recCount%>" style="<%=dtl_style%>" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=recCount%>','<%=drug_code%>','<%=mode%>','','','<%=freq_code%>','<%=dosage_seq_no%>','','<%=order_id%>','<%=order_line_num%>','<%=encounter_id%>','<%=medn_admn_dtl_reqd_yn%>','<%=iv_prep_yn%>','','','<%=sch_date_time%>','',document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_<%=recCount%>,'','','','<%=administered%>','<%=admin_recorded_yn%>')" style="display:none"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label>
					<img style="display:none" src="../../eCommon/images/mandatory.gif" align="center" id="drug_remarks_mand_id_<%=recCount%>"></img>&nbsp; 
<%	
					if(admin_recorded_yn.equals("Y")){
%>
						<label id='adminDtls<%=recCount%>' style="font-size:9;font-weight:bold;color:black;" title="<%=showTitle%>" ><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></label>
<%
					}
				}
				else { 
					if(mand_display.equals("style='display:inline'")){//if block added for AAKH-CRF-0024 [IN:038260]
%>									
						<script>mandSymbolDisplayForOncology('ONLOAD','<%=recCount%>','<%=order_line_num%>','<%=medn_admn_dtl_reqd_yn%>')</script>
<% 
					}//added for AAKH-CRF-0024 [IN:038260] Ends				
				}
%>					
				</td>
				<input type="hidden" name="non_iv_mand_symbol_<%=recCount%>" id="non_iv_mand_symbol_<%=recCount%>" value="<%=mand_display%>">				<!-- added for AAKH-CRF-0024 [IN:038260] STARTS -->
<%
				if(iv_prep_yn.equals("9")){	
					if(!order_line_num.equals("1")){
						select_status_1="disabled";
%>
						<td class="<%=classvalue%>">
						<%-- <td class="<%=classvalue%>" style="<%=patient_stock_display%>" > --%><!--GHL-CRF-0482 -->
						<!-- NMC-JD-CRF-0186-US002 [45063] -->
						<td class="<%=classValSelect%>" style="<%=patient_stock_display%>" > 
						
						<input type="checkbox" id="chk_non_iv_select_<%=recCount%>" name="chk_non_iv_select_<%=recCount%>" value="E" <%=billChecked%> <%=isEnabled%> <%=select_status_1%> style="display:none" onClick="displayDosage(this,'non_iv_admin_qty_<%=recCount%>','<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>')<%=auth_reqd_script%>">
						</td>
<%
					}
					else{
%>
						<td class="<%=classvalue%>">				
						
						<%if(!freq_nature.equals("P") && cancelYn.equals("Y") &&!dis_continued.equals("Y") && !hold.equals("Y") &&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 and freq_nature added for SKR-SCF-1429 %>
					<img src="../../ePH/images/cancelAdmin.jpg" align="center"  width="17" height="17"  title="Cancel Admin" onclick="cancelAdminstration('<%=encode_drug_desc%>','<%=admin_by_name%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=qty%>','<%=patient_id%>','<%=encounter_id%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>')"></img></td>
					
<%
					}	
%>
						<%-- <td class="<%=classvalue%>" style="<%=patient_stock_display%>" > --%><!--GHL-CRF-0482 -->
						<!-- NMC-JD-CRF-0186-US002 [45063] -->
						<td class="<%=classValSelect%>" style="<%=patient_stock_display%>" >
						
						<input type="checkbox" id="chk_non_iv_select_<%=recCount%>" name="chk_non_iv_select_<%=recCount%>" value="E" <%=billChecked%> <%=isEnabled%> <%=select_status_1%> style="display:none" onClick="displayDosage(this,'non_iv_admin_qty_<%=recCount%>','<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>');checkOncologyGroup('<%=recCount%>','<%=onco_direct_drug_count%>',this,'<%=sch_date_time%>')<%=auth_reqd_script%>">
						</td>									
<%					}
				}
				else{
%>														
					<td class="<%=classvalue%>" style="<%=patient_stock_display%>" ><!--GHL-CRF-0482 -->
					<%-- <td class="<%=classvalue%>"> --%>
					<!-- NMC-JD-CRF-0186-US002 [45063] -->
					<td class="<%=classValSelect%>">					
					<input type="checkbox" id="chk_non_iv_select_<%=recCount%>" name="chk_non_iv_select_<%=recCount%>" value="E" <%=billChecked%> <%=isEnabled%> <%=select_status_1%> style="display:none" onClick="displayDosage(this,'non_iv_admin_qty_<%=recCount%>','<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>')<%=auth_reqd_script%>" >
					<%if(!freq_nature.equals("P") && cancelYn.equals("Y") &&!dis_continued.equals("Y") && !hold.equals("Y")&&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 and freq_nature added for SKR-SCF-1429 %>
					<img src="../../ePH/images/cancelAdmin.jpg" align="center"  width="17" height="17"  title="Cancel Admin" onclick="cancelAdminstration('<%=encode_drug_desc%>','<%=admin_by_name%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=qty%>','<%=patient_id%>','<%=encounter_id%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>')"></img></td>
					
<%
					}	} //added for AAKH-CRF-0024 [IN:038260] Ends
%>
				</tr>
<%
			} // end 	if(admin_recorded_yn.equals("Y") || dis_continued.equals("Y") || hold.equals("Y")) on line no. 841
			else{
				//GHL-CRF-0482 - start

			if(patient_stock_required!=null && patient_stock_required.equals("Y")) 
				patient_stock_check_display	=	"display:inline"; 
			else
				patient_stock_check_display	=	"display:none";

				if(patient_stock_required!=null && patient_stock_required.equals("Y") && iv_prep_yn.equals("")){
						batchIdforOrders = bean.getBatchIdForOrders();
						if(batchIdforOrders!=null && batchIdforOrders.containsKey(drug_code)){
							int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);
							 if(rec_count>0 || (patient_stock_yn.equals("Y") && order_status.equals("DF")))
								batch_ids = (ArrayList)batchIdforOrders.get(drug_code);
							 else
								batch_ids = new ArrayList();
						}else{
							int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);
							if(rec_count>0 || (patient_stock_yn.equals("Y") && order_status.equals("DF")))
								batch_ids       =   bean.getAllBatchIDSForPatientStock(patient_id,facility_id,encounter_id,drug_code);
							else
								batch_ids = new ArrayList();
						}
					
				}else{ 				//GHL-CRF-0482 - end
					batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"N");	
				}

				if(batch_ids!=null && batch_ids.size()>0 && !disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") ){ //added for BRU-CRF-399.1 - start
					if(disp_drugs!=null && disp_drugs.indexOf(",")!=-1){
					alt_multi_drug_flag = true;
					}
				}//added for BRU-CRF-399.1 - end

%>								
				<tr>
				<td class="white" width="2%" style="<%=displayStyle%>" ><%=verbalOrder%></td>
				<td class="<%=classvalue%>" style="<%=drug_class_ind%>">
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
				<input type="hidden" name="order_pract_id_<%=recCount%>" id="order_pract_id_<%=recCount%>" value="<%=order_pract_id%>"> <!-- //Added for [IN:040149]-->
<%
				if ((iv_prep_yn.equals("0"))||(iv_prep_yn.equals("2"))||(iv_prep_yn.equals("4"))||(iv_prep_yn.equals("6"))||(iv_prep_yn.equals("7"))||(iv_prep_yn.equals("8"))) {
%>
					<label  id="drug_mast_det_<%=recCount%>">&nbsp;</label>
<%
				}
				else{
%>
					<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=disp_drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
<%
				}
%>
				<label name="lbl_drug_desc" style="font-size:10;"><%=drug_desc%>&nbsp;&nbsp;
				<%if(cancel_recorded_yn.equals("Y")){%>
				<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=encode_drug_desc%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id%>','<%=encounter_id%>','<%=admin_date_time%>')"></img>
										
<%			}	
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
				if(adr_count>0){ // added for RUT-SCF-0144 [IN:033371]  -- start
%>
					<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=drug_code%>');"></img>
<%
				} // added for RUT-SCF-0144 [IN:033371]  -- end
				if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
					<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" onmouseover="changeCursor(this);">
<%						
				}
				if(iv_prep_yn.equals("7")){
					if(ppn_count >0){
%>
						  <img src='../../ePH/images/AddedIngredient.gif' width='17' height='15' onclick = "openPPNDisplay('<%=patient_id%>','<%=order_id%>','<%=Store_locn_code%>')" onmouseover="changeCursor(this);">						  
<%					}
				}
				if(boolAllergy_icon){
%>
					<img src='../../eCA/images/HI_RecordAllergies.gif' width='17' height='15' onclick = "showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=encode_drug_desc%>');" onmouseover="changeCursor(this);">	
<%
				}
				
%>	
				<img  id="alternate_image_<%=recCount%>" src='../../ePH/images/altenate.jpg' style="cursor:pointer;<%=alt_drug_display%>" height='15' width='15' onClick="callAlternateDrugWindow('<%=drug_code%>','<%=encode_drug_desc%>','<%=patient_id%>','<%=order_id%>','<%=order_line_num%>','<%=store_code%>','<%=qty%>','<%=expiry_date%>','<%=uom_code%>','<%=recCount%>','<%=freq_nature%>','Y');" title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>'></img><!-- //Added for Bru-HIMS-CRF-399 [IN:043767]  and freq_nature added for Bru-HIMS-CRF-399.1-->
<%				
				if(taper_yn.equals("Y")&& totalTaperQtyDisplay.equals("Y")){   //if and else Added for RUT-CRF-0088 [IN:036978]
					addedTaperSch = bean.getAddedTaperSch(facility_id+"~"+encounter_id+"~"+order_id+"~"+drug_code+"~"+sch_date_time);
					if(addedTaperSch.equals("N") && administered.equals("Y")){  // Checks whether this row has been taperd or not
%>			
						<label style='color:blue;text-align:right' onmouseover="changeCursor(this);"  onclick="taperCurrRow('<%=i%>','<%=inc%>','<%=encounter_id%>')">&nbsp;+&nbsp;<fmt:message key="Common.Taper.label" bundle="${common_labels}"/></label>
<%
					}
					else{
%>						
						<label style='color:black;text-align:right'>&nbsp;<fmt:message key="Common.Taper.label" bundle="${common_labels}"/></label>
<%				
					}
					if(addedTaperSch.equals("Y"))
						addedTaperSch = "disabled";
				}
%>			
				</label>
<%
				if(dispensed_drug_desc==null || dispensed_drug_desc.equals(""))
					disp_drugs="";
%>
				<br><label id="id_dispdrugdesc_<%=recCount%>" style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_drugs%> </label>
				<input type="hidden" name="dispensed_drug_desc_<%=recCount%>" id="dispensed_drug_desc_<%=recCount%>" value="<%=disp_drugs%>">
<%
				if(linkVacScheduleYN.equals("Y")){ 
					if((!(iv_prep_yn.equals("9")||iv_prep_yn.equals("6")))||(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){
%>
						<br><label id='link_vaccine_label_<%=recCount%>' style="font-size:10;" title='<%=linkVacScheduleDescToolTip%>'> <fmt:message key="ePH.LinkVaccineShcedule.label" bundle="${ph_labels}"/> <input type='text' size=10 name='link_vaccine_desc_<%=recCount%>' id='link_vaccine_desc_<%=recCount%>' value='<%=linkVacScheduleDesc%>' disabled><input type=button  class='button' value='?' name='btn_link_vaccine_<%=recCount%>' id='btn_link_vaccine_<%=recCount%>' onClick="linkVaccine('noniv','<%=recCount%>')"></label>
						<input type='hidden' name="link_vaccine_code_<%=recCount%>" id="link_vaccine_code_<%=recCount%>" value='<%=linkVacScheduleCode%>'>
<%					}
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
					<input type="hidden" name="non_iv_admin_quaty_<%=recCount%>" id="non_iv_admin_quaty_<%=recCount%>" value=""><!-- GHL-CRF-0458.1-->
					
<%
				} // end if sliding scale applicable
				else{
					if(dosage==null || dosage.equals("")) //ML-MMOH-SCF-1439 - start
						dosage = "0";
					String split_dose_yn = "N";
					if(splitDoseYN!=null && splitDoseYN.size()>0)
						split_dose_yn = (String)splitDoseYN.get(order_id+order_line_num);

					if(split_dose_yn ==null || split_dose_yn.equals(""))
						split_dose_yn="N";

					if(!split_dose_yn.equals("Y") && !freq_nature.equals("P") ){ //!freq_nature.equals("P") added for SKR-SCF-1534
					if(Float.parseFloat(qty)!=Float.parseFloat(dosage))
						qty = dosage;

					}//ML-MMOH-SCF-1439 - end
					if(split_dose_yn.equals("Y")){ //ML-MMOH-SCF-1674
						qty = bean.getSplitDosage(order_id,order_line_num,sch_date_time.split(" ")[1]);
					}
					if(freq_nature.equals("P")){													
						if(!dosage_seq_no.equals("2")){ //dosage sequence number will start from 2 only, for PRN orders
							if(allow_mar_alternate_drug_yn.equals("Y") && Auto_Admin.equals("Y") && alt_drug.equals("Y") && arrAltDrugs.size()>0){ //added for CRF-399.1
								if(dosage.equals(""))
									dosage=sch_strength_value_prn;

							}
							else{
								dosage=sch_strength_value_prn;
							}
							dosage_uom_code=sch_strength_uom_prn;
							dosage_uom_desc=dosage_uom_desc;// changed from sch_strength_uom_desc_prn to dosage_uom_desc for incident No:32773
						}	
						
						if(dosage_type.equals("S")){
							strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
							non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value_prn))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	//ceil removed and *strength_per_value_pres_uom added for IN24768 --19/11/2010-- priya
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty; //added for SRR20056-SCF-7400
							}	// added for SKR-SCF-304
							dosage = pres_dosage;
						}
						else{
							non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty;
							} // added for SKR-SCF-304
							//dosage = pres_dosage;
						}
						if(Float.parseFloat(dosage) < 1.0){
							dosage = Float.parseFloat(dosage)+"";
						} //BRU-CRF-399.1 - start
						if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && !alt_multi_drug_flag && !iv_prep_yn.equals("7") && !alt_flag ){
							String alt_dos_detail= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
							if(alt_dos_detail.indexOf("~")!=-1){
							if(!split_dose_yn.equals("Y")){  //added for ML-MMOH-SCF-1757 & { added for ML-MMOh-SCF-1757
							dosage = alt_dos_detail.split("~")[0];
							uom_code = alt_dos_detail.split("~")[1];
							dosage_uom_desc = alt_dos_detail.split("~")[2];
							disp_with_alt=true;
							pres_dosage = dosage;
							pres_unit   = dosage_uom_desc;
							admin_uom_desc = dosage_uom_desc ;
							disp_schedule_uom_desc = dosage_uom_desc;
							}
							}
						}//BRU-CRF-399.1 - end
%>						
						<input type="text" name="non_iv_admin_qty1_<%=recCount%>" id="non_iv_admin_qty1_<%=recCount%>" size="5" maxlength="13" onKeyPress="return allowValidNumber(this,event,6,3);" oncopy="return false" onpaste="return false" onBlur="CheckNum(this);updateNonIvAdminQuantity(this,'<%=recCount%>','<%=strength_value_prn%>','<%=dosage_type%>','<%=content_in_pres_base_uom%>','<%=strength_per_value_pres_uom%>','<%=disp_with_alt%>'); makeDtlsMandatory(this,'<%=recCount%>','<%=drug_code%>','noniv','<%=freq_nature%>'); " value="<%=dosage%>" class="NUMBER" style="font-size:11;<%=addDisplayStyle%>" <%=select_status%>><label id="id_dosage_uom_<%=recCount%>" style="font-size:10;<%=addDisplayStyle%>" ><b><%=dosage_uom_desc%></b></label> 
<%
						if(qty!=null && !qty.equals("") && freq_nature.equals("P"))
							qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
						int len= qty.length();
						if( len > 0 ){
							String temp = qty;
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
						if(dosage_type.equals("S")){ //if Condition is added by sureshkumar T for the IncidentNo :  SRR20056-SCF-7039 [inc : 26763] upto 1494
%>	
							<label style="font-size:10;<%=addDisplayStyle%>" id = "bal_qty_<%=recCount%>"><b><fmt:message key="ePH.Bal.label" bundle="${ph_labels}"/><%=qty%>&nbsp;<%=pres_base_uom%></b></label>
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
							<input type="hidden" name="non_iv_admin_quaty_<%=recCount%>" id="non_iv_admin_quaty_<%=recCount%>" value="<%=non_iv_admin_quaty%>"><!-- GHL-CRF-0458.1-->
<%										
						}	
					} // end  if(freq_nature.equals("P"))
					else{ 						
						if(dosage.equals(""))
							dosage = pres_dosage;
						if(!iv_prep_yn.equals("0") && !iv_prep_yn.equals("2") && !iv_prep_yn.equals("4") && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("8")){  // added for regration issue
						if(dosage_type.equals("S")){//added for GHL-CRF-0458.1 -start
							strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
							non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value_prn))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty; 
							}	
							
						}
						else{
							non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty;
							} 
						
						}
						}
//added for GHL-CRF-0458.1 -end
						if(Float.parseFloat(qty) < 1.0){
									//qty = dfTest.format(Float.parseFloat(qty)); commeted for 	ML-MMOH-SCF-1529						
							if(qty.indexOf(".")!=-1){ //if condtion added for ML-MMOH-SCF-1529
								String f_qty = qty.substring(qty.indexOf("."),qty.length());
								if(f_qty.length()>8)
									qty = dfTest.format(Float.parseFloat(qty));
								   
								 qty =Float.parseFloat(qty)+"";
							}
							
						}//BRU-CRF-399.1 - start				
						if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && !alt_multi_drug_flag && !iv_prep_yn.equals("7") && !alt_flag){
							String alt_dos_detail1= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
							if(alt_dos_detail1.indexOf("~")!=-1){

							if(!split_dose_yn.equals("Y")){  //if added for ML-MMOH-SCF-1757 & { added for ML-MMOh-SCF-1757
							qty = alt_dos_detail1.split("~")[0];
							uom_code = alt_dos_detail1.split("~")[1];
							short_desc = alt_dos_detail1.split("~")[2];
							pres_dosage = qty;
							pres_unit   = short_desc;
							admin_uom_desc = short_desc ;}
							}
				System.err.println("MedicationAdministrationFTDrugDtls.jsp==alt_dos_detail=====1622=====>"+alt_dos_detail1);
						}//BRU-CRF-399.1 - end

%>										
						<input type="text" name="non_iv_admin_qty_<%=recCount%>" id="non_iv_admin_qty_<%=recCount%>" size="5" maxlength="13" onKeyPress="return	allowValidNumber(this,event,6,3);" oncopy="return false" onpaste="return false"  onBlur="CheckNum(this); makeDtlsMandatory(this,'<%=recCount%>','<%=drug_code%>','noniv','<%=freq_nature%>');" value="<%=qty%>" class="NUMBER" style="font-size:11;<%=addDisplayStyle%>" <%=select_status%>><label id="id_dosage_uom_<%=recCount%>"  style="font-size:10;	<%=addDisplayStyle%>" ><b><%=short_desc%></b></label><!-- Add freq_nature in makeDtlsMandatory() function for SKR-SCF-0304[29563] -->		  		 
						<input type="hidden" name="non_iv_admin_qty_uom_<%=recCount%>" id="non_iv_admin_qty_uom_<%=recCount%>" value="<%=uom_code%>">
						<input type="hidden" name="h_non_iv_admin_qty_<%=recCount%>" id="h_non_iv_admin_qty_<%=recCount%>" value="<%=qty%>">
						<input type="hidden" name="non_iv_admin_chng_dtls_req_<%=recCount%>" id="non_iv_admin_chng_dtls_req_<%=recCount%>" value="N">
						<input type="hidden" name="non_iv_admin_quaty_<%=recCount%>" id="non_iv_admin_quaty_<%=recCount%>" value="<%=non_iv_admin_quaty%>"><!-- GHL-CRF-0458.1-->
<%
					}								
				}	// end else of end if sliding scale applicable						
%> 
				</td>

				<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backGrndColor%>;font-size:10;'><label style="font-size:10;"> <%=route_desc%></label></td>
<% 
					fntColor  =   "#OOOOOO"; // Code Changed for RUT-CRF-0034 Route Color
	                backGrndColor =   "#FFFFFF";
					if(freq_nature.equals("P")){
%>
						<td class="<%=classvalue%>" ><label style="font-size:9;font-weight;color:black">&nbsp;</label></td>
<%
					}
					else{
						if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014- start
							MfrDetails=bean.getStatusOfMAR(order_id,"");

							if(MfrDetails.size()>0){
								statusString=(String)MfrDetails.get(0);
								mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue();														
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
						<td class="<%=classvalue%>" ><label style="font-size:9;font-weight;color:black"><%=sch_date_time%></label></td>
<%
					}
					}
					
					//added for SKR-SCF-1290
					String Sch_AdminBackLogTime = "";
					if(!locale.equals("en")){
						 Sch_AdminBackLogTime=bean.getAdminBackLogTime(sch_date_time_in_en);
						Sch_AdminBackLogTime = com.ehis.util.DateUtils.convertDate(Sch_AdminBackLogTime, "DMYHM","en",locale);
					}else{
						 Sch_AdminBackLogTime=bean.getAdminBackLogTime(sch_date_time);// added for TTM-SCF-0171-907901	
					}
	 				 
%>
				<td class="<%=classvalue%>" style="">
					<input type="hidden" name="non_iv_sch_date_time_<%=recCount%>" id="non_iv_sch_date_time_<%=recCount%>" value="<%=sch_date_time%>">
					<input type="text" name="non_iv_time_<%=recCount%>" id="non_iv_time_<%=recCount%>" size="15" maxlength="16" value="<%=defaultDate.equals("")?current_date_time:defaultDate%>" <%=select_status%> onBlur="validateAdminDateTime('<%=Sch_AdminBackLogTime%>','<%=current_date_time%>', this,'<%=locale%>');" style="font-size:11;<%=addDisplayStyle%>"> <!--  AdminBackLogTime changed to Sch_AdminBackLogTime for TTM-SCF-0171-907901  -->
				</td>														
<%							
					 //patient_class_ord = bean.getOrderPatientClass(order_id);//GHL-CRF-0458 commeted for NMC-JD-CRF-0186 [46294]
					verification_status	=	bean.getVerificationStatus(patient_class_ord,facility_id,Store_locn_code,verification_req_yn,WardAckMarRequiredYn);//added for MMS-KH-SCF-0056
					System.out.println("verification_status"+verification_status);		
				if(patient_class_ord==null)
					patient_class_ord = "";
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
							auto_Admin_dis="";									
							if(Auto_Admin.equals("N"))
								auto_Admin_dis="disabled";
							else 
								auto_Admin_dis="";
							bat_id_lookbutton_enabled="Y";
							if(auto_Admin_dis.equals("disabled")||select_status.equals("disabled")){
								bat_id_lookbutton_enabled="N";
							}
							if(iv_prep_yn.trim().length()!=0 || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
								shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
							else
								shared_drug_disp = "";
							
%>
							<td class="<%=classvalue%>" ><input type='checkbox' name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','<%=bat_id_lookbutton_enabled%>','<%=iv_prep_yn%>','<%=order_line_num%>');"></td>
							<td class="<%=classvalue%>" style=""><input type='checkbox' name='non_iv_shared_drug_<%=recCount%>' id='non_iv_shared_drug_<%=recCount%>' title='Shared Drug' value="N" onclick="chkShrdDrug(this,'<%=recCount%>')" style='<%=shared_drug_disp%>'><!-- Added for HSA-CRF-0090 -->
							<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>"  style="font-size:11;<%=addDisplayStyle%>" disabled>
							<input type="button" class="button" value="?" name="non_iv_batch_id_but_<%=recCount%>" id="non_iv_batch_id_but_<%=recCount%>" <%=select_status%> <%=auto_Admin_dis%> onClick="calcQuantityInDispensingUOM('NONIV','<%=recCount%>');callMednBatchSearch('non_iv_batch_id_<%=recCount%>','non_iv_expiry_date_<%=recCount%>','non_iv_trade_name_<%=recCount%>','non_iv_trade_id_<%=recCount%>','non_iv_bin_code_<%=recCount%>',document.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_<%=recCount%>.value,'<%=recCount%>','non_iv_time_<%=recCount%>','<%=Storelocn_code%>','NONIV','<%=recCount%>')" style="<%=addDisplayStyle%>">
							<input type='hidden' name="Newly_administerderd_<%=recCount%>" id="Newly_administerderd_<%=recCount%>" value='NONIV_Y'>
									
							<input type="hidden" name="previous_non_iv_batch_id_<%=recCount%>" id="previous_non_iv_batch_id_<%=recCount%>" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>">
							<input type="hidden" name="previous_non_iv_exp_date_<%=recCount%>" id="previous_non_iv_exp_date_<%=recCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
							<input type="hidden" name="previous_non_iv_trade_id_<%=recCount%>" id="previous_non_iv_trade_id_<%=recCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
							<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value="<%=order_id%>"><!-- GHL-CRF-0482-->
							<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value="<%=order_line_num%>"><!-- GHL-CRF-0482-->
							<script>//Added for Bru-HIMS-CRF-399 [IN:043767] 
							if(document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_<%=recCount%>.value ==''){								
								document.getElementById("id_dispdrugdesc_"+<%=recCount%>).innerHTML = '';
								document.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_<%=recCount%>.value = '<%=drug_code%>';
							}
							</script>
							
<%			if(verification_status.equals("Y") && (iv_prep_yn.equals("") || iv_prep_yn== null)  && (order_status.equals("OS") || order_status.equals("RG")))
{//added for mms-kh-scf0056
	select_status_1="disabled";
}
if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))) // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
									select_status_1="disabled";

						}
						else if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							expiry_date = (String)batch_ids.get(1);
							trade_id    = (String)batch_ids.get(2);
							tradename   = (String)batch_ids.get(3);
							//added for GHL-CRF-0458 - start
							ward_ack_yn = (String)batch_ids.get(6)==null?"":(String)batch_ids.get(6);
							
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))) // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status_1="disabled";
							if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status_1 = "disabled";
							} // Added for KH-SCF-0010 - End
							//added for GHL-CRF-0458 - end
							select_status="disabled";
%>
							<script>//Added for Bru-HIMS-CRF-399 [IN:043767]
							 document.getElementById("alternate_image_"+<%=recCount%>).style.display="none";
							</script>
<%							totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
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
							if(ret_qty<=0){// adding end for 33194
%>
								<td class="<%=classvalue%>"><input type='checkbox' name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','N','<%=iv_prep_yn%>','<%=order_line_num%>');" disabled></td>
								<td class="<%=classvalue%>" style=""><input type='hidden' name='non_iv_shared_drug_<%=recCount%>' id='non_iv_shared_drug_<%=recCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
								<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value="<%=(String)batch_ids.get(0)%>" disabled style="font-size:11;"><input type="button" class="button" name="non_iv_batch_id_but_<%=recCount%>" id="non_iv_batch_id_but_<%=recCount%>" value="?"  <%=select_status%> onClick="calcQuantityInDispensingUOM('NONIV','<%=recCount%>');callMednBatchSearch('non_iv_batch_id_<%=recCount%>','non_iv_expiry_date_<%=recCount%>','non_iv_trade_name_<%=recCount%>','non_iv_trade_id_<%=recCount%>','non_iv_bin_code_<%=recCount%>','<%=drug_code%>','<%=recCount%>','non_iv_time_<%=recCount%>','<%=store_code%>','NONIV','<%=recCount%>')" style="<%=addDisplayStyle%>">
								<input type="hidden" name="previous_non_iv_batch_id_<%=recCount%>" id="previous_non_iv_batch_id_<%=recCount%>" value="<%=(String)batch_ids.get(0)%>">
								<input type="hidden" name="previous_non_iv_exp_date_<%=recCount%>" id="previous_non_iv_exp_date_<%=recCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">	
								<input type="hidden" name="previous_non_iv_trade_id_<%=recCount%>" id="previous_non_iv_trade_id_<%=recCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
								<input type="hidden" name="batch_ids_size_<%=recCount%>" id="batch_ids_size_<%=recCount%>" value="<%=batch_ids.size()%>"><!--added for CRF-413.8 -->
								<input type="hidden" name="non_iv_barcode_id_<%=recCount%>" id="non_iv_barcode_id_<%=recCount%>" value="<%=(String)batch_ids.get(5)%>"><!--added for CRF-413.8 -->
							<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value="<%=(String)batch_ids.get(7)%>"> <!-- GHL-CRF-0482-->
							<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value="<%=(String)batch_ids.get(8)%>"> <!-- GHL-CRF-0482-->
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
								<input type="hidden" name="batch_ids_size_<%=recCount%>" id="batch_ids_size_<%=recCount%>" value="<%=batch_ids.size()%>"><!--added for CRF-413.8 -->
								<input type="hidden" name="non_iv_barcode_id_<%=recCount%>" id="non_iv_barcode_id_<%=recCount%>" value="<%=(String)batch_ids.get(5)%>"><!--added for CRF-413.8 -->
								<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value="<%=(String)batch_ids.get(7)%>"> <!-- GHL-CRF-0482-->
								<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value="<%=(String)batch_ids.get(8)%>"> <!-- GHL-CRF-0482-->
<%
							}
						}
						else{//added below condition for incident NO:33194
%>
							<script>//Added for Bru-HIMS-CRF-399 [IN:043767]
							 document.getElementById("alternate_image_"+<%=recCount%>).style.display="none";
							</script>
							<td class="<%=classvalue%>" ><input type=checkbox name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','NOT','<%=iv_prep_yn%>','<%=order_line_num%>');" disabled ></td>
							<td class="<%=classvalue%>" style=""><input type='hidden' name='non_iv_shared_drug_<%=recCount%>' id='non_iv_shared_drug_<%=recCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
							<select name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" style="font-size:11;<%=addDisplayStyle%>" onChange="assignBatchDetails('<%=mode%>','NON_IV',this,'<%=recCount%>','','<%=disp_drug_code%>','<%=drug_code%>','<%=qty%>','<%=order_id%>','<%=order_line_num%>','<%=freq_nature%>','Y','<%=disp_drugs%>')"><!-- disp_drug_code,order_id,order_line_num,Freq_nature,disp_drugs added for BRU-CRF-399.1-->
							<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
							int mm =1;//CRF-413.8
							System.err.println("MedicationAdministrationFTDrugDtls.jsp====batch_ids.size()============1666==>"+batch_ids.size());
							for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							System.err.println("defaultBatch===>"+defaultBatch+"==(String)batch_ids.get(kk)===>"+(String)batch_ids.get(kk));
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
						
%>
						
<%							}
%>						
							</select>	
					<input type="hidden" name="batch_ids_size_<%=recCount%>" id="batch_ids_size_<%=recCount%>" value="<%=batch_ids.size()%>"><!--added for CRF-413.8 -->
					<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>" id="non_iv_batch_order_id_<%=recCount%>" value="<%=order_id%>"><!-- GHL-CRF-0482-->
					<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>" id="non_iv_batch_order_line_no_<%=recCount%>" value="<%=order_line_num%>"><!-- GHL-CRF-0482-->
<%
						for(int kk=0;kk<batch_ids.size();kk=kk+9){ //6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							
%>
							<input type="hidden" name="non_iv_barcode_id_<%=recCount%>_<%=mm%>" id="non_iv_barcode_id_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+5)%>">
						  <input type="hidden" name="non_iv_alt_drug_code_<%=recCount%>_<%=mm%>" id="non_iv_alt_drug_code_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+4)%>">
						  <input type="hidden" name="non_iv_batch_id_alt_<%=recCount%>_<%=mm%>" id="non_iv_batch_id_alt_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk)%>">
						<input type="hidden" name="non_iv_batch_order_id_<%=recCount%>_<%=mm%>" id="non_iv_batch_order_id_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+7)%>">  <!-- GHL-CRF-0482-->
						<input type="hidden" name="non_iv_batch_order_line_no_<%=recCount%>_<%=mm%>" id="non_iv_batch_order_line_no_<%=recCount%>_<%=mm%>" value="<%=(String)batch_ids.get(kk+8)%>"> <!-- GHL-CRF-0482-->
<%						mm++;//CRF-413.8

					

						}
						//added for GHL-CRF-0458 - start
						for(int kk=0;kk<batch_ids.size();kk=kk+9){ // 7 to 9 for GHL-CRF-0482
							ward_ack_yn = (String)batch_ids.get(kk+6)==null?"":(String)batch_ids.get(kk+6);
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && ward_ack_yn.equals("A") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))){ // // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status_1="";
								ack_flag = true;
								break;
							}
							//added for GHL-CRF-0458 - end
						}
						//commented for MOHE-SCF-0127
						
						if(!ack_flag && WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")) //&& patient_class_ord.equals("IP") added for GHL-CRF-0482 // // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
							select_status_1="disabled";

						}

						//added for MMS-KH-CRF-0039 - start
						if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && (iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6"))){
						 ward_ack_yn = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn);
					
						 if(ward_ack_yn==null)
							 ward_ack_yn="";
						
						 if(!ward_ack_yn.equals("A")){
						    select_status="disabled";
							select_status_1="disabled";
						 }
						}

						//added for GHL-CRF-0509 start
						if(issitespec_verbal_order_yn && placed_from_verbal_order.equals("Y")){
							select_status_1="";
						} //added for GHL-CRF-0509 end
						if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
							select_status_1 = "disabled";
						} // Added for KH-SCF-0010 - End
%>						<input type="hidden" name="placed_from_verbal_order_<%=recCount%>" id="placed_from_verbal_order_<%=recCount%>" value="<%=placed_from_verbal_order%>">
						<input type="hidden" name="batch_assigned_verbal_order_<%=recCount%>" id="batch_assigned_verbal_order_<%=recCount%>" value=""><!-- added for GHL-CRF-0509 -->
								</td>
						<td class="<%=classvalue%>" style="">
							<input type="text" name="non_iv_expiry_date_<%=recCount%>" id="non_iv_expiry_date_<%=recCount%>" size="9" maxlength="10"  value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>" disabled style="font-size:11;<%=addDisplayStyle%>" onblur="ExpiryDateValidationForPatBroughtMedn(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='exp_dt_cal_<%=recCount%>' onClick=" showCalendar('non_iv_expiry_date_<%=recCount%>');" style="display:none" >
						</td>
<%
					} //end if(!(sliding_scale_applicable.equals("Y")&& batch_ids.size()==0))
					else{
%>	
						<td class="<%=classvalue%>" ><input type=checkbox name="pat_brought_med_<%=recCount%>" id="pat_brought_med_<%=recCount%>" value="<%=patient_brgt_medn%>" onclick="enableDisableTextbox('<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>','N','<%=iv_prep_yn%>','<%=order_line_num%>');"></td>
						<td class="<%=classvalue%>" style="">
						<input type="text" name="non_iv_batch_id_<%=recCount%>" id="non_iv_batch_id_<%=recCount%>" size="9" maxlength="10" value=""  style="font-size:11;<%=addDisplayStyle%>" disabled><input type="button" name="non_iv_batch_id_but_<%=recCount%>" id="non_iv_batch_id_but_<%=recCount%>" class="button" value="?" disabled 
						onClick="" style="<%=addDisplayStyle%>">
						</td>
						<td class="<%=classvalue%>" style="">
						<input type="text" name="non_iv_expiry_date_<%=recCount%>" id="non_iv_expiry_date_<%=recCount%>" size="9" maxlength="10"  value="" disabled onblur="ExpiryDateValidationForPatBroughtMedn(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='exp_dt_cal_<%=recCount%>' onClick=" showCalendar('non_iv_expiry_date_<%=recCount%>');" style="display:none" >
						</td>
<%					}
				}// end of if(!patient_brgt_medn.equals("Y"))
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
				if(!(iv_prep_yn.equals("9")&&!(order_line_num.equals("1")))){
%>
					<input type="checkbox" name="non_iv_chk_<%=recCount%>" id="non_iv_chk_<%=recCount%>" value="E" checked onClick="validateFieldsForDrug(this,'<%=recCount%>','<%=medn_admn_dtl_reqd_yn%>') ; clearDrgRemarks(this,'<%=recCount%>','<%=drug_code%>','NonIV')"  <%=select_status_1%> style="<%=addDisplayStyle%>"  <%=addedTaperSch%>>
					
					<label name="non_iv_remarks_<%=recCount%>" style="<%=dtl_style%>" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=recCount%>','<%=drug_code%>','<%=mode%>','','','<%=freq_code%>','','','<%=order_id%>','<%=order_line_num%>','<%=encounter_id%>','<%=medn_admn_dtl_reqd_yn%>','<%=iv_prep_yn%>',document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_<%=recCount%>)" style="<%=addDisplayStyle%>"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label>
					
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
				</td>	
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
				admin_uom_desc= short_desc1.replaceAll(" ","%20");
				admin_uom_desc= java.net.URLEncoder.encode(admin_uom_desc,"UTF-8");
				admin_uom_desc= admin_uom_desc.replaceAll("%2520","%20");
				if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && batch_ids.size()==9){ //BRU-CRF-399.1 and 7 to 9 for GHL-CRF-0482
					pres_dosage = dosage;
					admin_uom_desc = dosage_uom_desc ;
				}
				if(iv_prep_yn.equals("9")){	
					if(!order_line_num.equals("1")){
						select_status_1="disabled";
%>						<td class="<%=classvalue%>" style="<%=patient_stock_display%>"> <!-- GHL-CRF-0482-->
							<input type="checkbox" name="non_iv_patient_stock_<%=recCount%>" id="non_iv_patient_stock_<%=recCount%>" value="<%=patient_stock_completed%>" onclick="PatientStockCheck(this,'<%=order_id%>','<%=order_line_num%>')" <%=patient_stock_checked%> style="<%=patient_stock_check_display%>" <%=patient_stock_disabled%> >
						</td>
						<!--  Charanges for NMC-JD-CRF-0186 [43323]-->
						<td class="<%=classValSelect%>">
						<%-- <input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" <%=checked%> <%=select_status_1%> style="<%=addDisplayStyle%>" onClick="displayDosage(this,<%=fieldname%>,'<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>')<%=auth_reqd_script%>"> --%>
						<input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" <%=billChecked%> <%=isEnabled%> onClick="displayDosage(this,<%=fieldname%>,'<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>')<%=auth_reqd_script%>">
						</td>
<%
					}
					else{
%>
						<td class="<%=classvalue%>" style="<%=patient_stock_display%>"> <!-- GHL-CRF-0482-->
							<input type="checkbox" name="non_iv_patient_stock_<%=recCount%>" id="non_iv_patient_stock_<%=recCount%>" value="<%=patient_stock_completed%>" onclick="PatientStockCheck(this,'<%=order_id%>','<%=order_line_num%>')"  <%=patient_stock_checked%> style="<%=patient_stock_check_display%>" <%=patient_stock_disabled%>  >
						</td>
						<!--  Charanges for NMC-JD-CRF-0186[43323]-->
						<td class="<%=classValSelect%>">
						<%-- <input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" <%=checked%> <%=select_status_1%> style="<%=addDisplayStyle%>" onClick="displayDosage(this,<%=fieldname%>,'<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>');checkOncologyGroup('<%=recCount%>','<%=onco_direct_drug_count%>',this,'<%=sch_date_time%>')<%=auth_reqd_script%>"> --%>
						<input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" <%=billChecked%> <%=isEnabled%> onClick="displayDosage(this,<%=fieldname%>,'<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>');checkOncologyGroup('<%=recCount%>','<%=onco_direct_drug_count%>',this,'<%=sch_date_time%>')<%=auth_reqd_script%>">
						</td>									
<%					}
				}
				else{
%>														
					<td class="<%=classvalue%>" style="<%=patient_stock_display%>"><!-- GHL-CRF-0482-->
							<input type="checkbox" name="non_iv_patient_stock_<%=recCount%>" id="non_iv_patient_stock_<%=recCount%>" value="<%=patient_stock_completed%>" onclick="PatientStockCheck(this,'<%=order_id%>','<%=order_line_num%>')" <%=patient_stock_checked%> style="<%=patient_stock_check_display%>" <%=patient_stock_disabled%> >
					</td>
					<%if(patient_brgt_medn.equals("Y")){ %>
						<input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" <%=checked%> <%=select_status_1%> style="<%=addDisplayStyle%>" onClick="displayDosage(this,<%=fieldname%>,'<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>');validateQtyAck(this,'<%=recCount%>','<%=order_id%>','<%=order_line_num%>','<%=disp_drug_code%>','<%=isSiteSpecMARPrint%>','<%=patient_id%>','<%=iv_prep_yn%>','<%=patient_class_ord%>','<%=batch_ids.size()%>','<%=patient_stock_yn%>','<%=encounter_id%>','<%=patient_brgt_medn%>')<%=auth_reqd_script%>" >
					<%}else{ %>
					<!--  Charanges for NMC-JD-CRF-0186[43323] -->
					<td class="<%=classValSelect%>">  
					<%-- <input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" <%=checked%> <%=select_status_1%> style="<%=addDisplayStyle%>" onClick="displayDosage(this,<%=fieldname%>,'<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>');validateQtyAck(this,'<%=recCount%>','<%=order_id%>','<%=order_line_num%>','<%=disp_drug_code%>','<%=isSiteSpecMARPrint%>','<%=patient_id%>','<%=iv_prep_yn%>','<%=patient_class_ord%>','<%=batch_ids.size()%>','<%=patient_stock_yn%>','<%=encounter_id%>','<%=patient_brgt_medn%>')<%=auth_reqd_script%>" ><!-- validateQtyAck added for GHL-CRF-0458--> --%>
					<input type="checkbox" name="chk_non_iv_select_<%=recCount%>" id="chk_non_iv_select_<%=recCount%>" value="E" <%=billChecked%> <%=isEnabled%> onClick="displayDosage(this,<%=fieldname%>,'<%=pres_dosage%>','<%=pres_unit%>','<%=freq_nature%>','<%=disp_schedule_uom_desc%>','<%=admin_uom_desc%>','<%=AdminBackLogTime%>','<%=current_date_time%>', '<%=defaultDate.equals("")?current_date_time:defaultDate%>','<%=locale%>','<%=recCount%>');validateQtyAck(this,'<%=recCount%>','<%=order_id%>','<%=order_line_num%>','<%=disp_drug_code%>','<%=isSiteSpecMARPrint%>','<%=patient_id%>','<%=iv_prep_yn%>','<%=patient_class_ord%>','<%=batch_ids.size()%>','<%=patient_stock_yn%>','<%=encounter_id%>','<%=patient_brgt_medn%>')<%=auth_reqd_script%>" >
					</td>
					<%} %>
<%				}
%>
				</tr>
				<input type="hidden" name="allowed_yn_<%=recCount%>" id="allowed_yn_<%=recCount%>" value = ""><!--added for GHL-CRF-0458 and recCount added for IN066062 -->
				<input type="hidden" name="alt_dosage_<%=recCount%>" id="alt_dosage_<%=recCount%>" value="<%=pres_dosage%>"><!--BRU-CRF-399.1 -->
				<input type="hidden" name="alt_dosage_uom_<%=recCount%>" id="alt_dosage_uom_<%=recCount%>" value="<%=disp_schedule_uom_desc%>"><!--BRU-CRF-399.1 -->
				<input type="hidden" name="alt_MAR_YN_<%=recCount%>" id="alt_MAR_YN_<%=recCount%>" value="N"><!--BRU-CRF-399.1 -->
				<input type="hidden" name="future_or_late_<%=recCount%>" id="future_or_late_<%=recCount%>" value = "<%=future_or_late_admin%>"><!-- Added for GHL-CRF-0482 [IN:064955] -->
				<input type="hidden" name="patient_brgt_medn_<%=recCount%>" id="patient_brgt_medn_<%=recCount%>" value = "<%=patient_brgt_medn%>"> <!--GHL-CRF-0482 -->
<%
				altRecCount=0;
				if(recCount==row_no && multi_drugs.size()>0){
					no_of_alt_drus_selected ++;
					if(iv_prep_yn.trim().length()!=0 || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
						shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
					else
						shared_drug_disp = "";
					for(int n=0; n<multi_drugs.size(); n+=5){ 
						altRecCount++;
						alt_drug_code			=	(String)multi_drugs.get(n);
						alt_drug_desc			=   (String)multi_drugs.get(n+1);
						alt_qty=(String)multi_drugs.get(n+3);
						alt_qty_uom =(String)multi_drugs.get(n+4);
						alt_batch_ids = bean.getAllBatchIDS(order_id,order_line_num,"N");
						alt_expiry_date = "";
						alt_trade_id	   = "";
						alt_trade_name  = "";
%>
						<tr >
						<td class="white" style="background:#CC99CC" width='2%'>&nbsp;</td>
						<td style="font-size:09;" style="color:#CC99CC" color="#CC99CC" class="<%=classvalue%>">&nbsp;&nbsp;&nbsp;&nbsp;<b><%=alt_drug_desc%></b>
						<input type="hidden" name="alt_drug_code_<%=altRecCount%>" id="alt_drug_code_<%=altRecCount%>" value="<%=alt_drug_code%>">
						<input type="hidden" name="main_drug_code_<%=altRecCount%>" id="main_drug_code_<%=altRecCount%>" value="<%=drug_code%>">
						<input type="hidden" name="alt_dosage_seq_no_<%=altRecCount%>" id="alt_dosage_seq_no_<%=altRecCount%>" value="<%=dosage_seq_no%>">
						<input type="hidden" name="alt_item_code_<%=altRecCount%>" id="alt_item_code_<%=altRecCount%>" value="<%=item_code%>">
						<input type="hidden" name="alt_order_id_<%=altRecCount%>" id="alt_order_id_<%=altRecCount%>" value="<%=order_id%>">
						<input type="hidden" name="alt_order_line_no_<%=altRecCount%>" id="alt_order_line_no_<%=altRecCount%>" value="<%=order_line_num%>">
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
						<%
						   fntColor ="000000";      //Code Changed For RUT-CRF-0034 Route Color
						   backGrndColor="FFFFFF";					   
						%>
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
							<input type='checkbox' name='alt_shared_drug_<%=altRecCount%>' id='alt_shared_drug_<%=altRecCount%>' title='Shared Drug' value="N" onclick="chkShrdDrug(this,'<%=altRecCount%>')" style='<%=shared_drug_disp%>'><!-- Added for HSA-CRF-0090[IN041241] -->
							<input type="text" name="alt_batch_id_<%=altRecCount%>" id="alt_batch_id_<%=altRecCount%>" size="9" maxlength="10" value="<%=defaultBatch%>" style="font-size:11" disabled>
							<input type="button" class="button" value="?" onClick="calcQuantityInDispensingUOM('ALT','<%=altRecCount%>');callMednBatchSearch('alt_batch_id_<%=altRecCount%>','alt_expiry_date_<%=altRecCount%>','alt_trade_name_<%=altRecCount%>','alt_trade_id_<%=altRecCount%>','alt_bin_code_<%=altRecCount%>','<%=drug_code%>','<%=altRecCount%>','alt_time_<%=altRecCount%>','<%=store_code%>','ALT','<%=altRecCount%>')" >
<%
						}
						else if(alt_batch_ids.size()==9){ //changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							alt_expiry_date = (String)alt_batch_ids.get(1);
							alt_trade_id    = (String)alt_batch_ids.get(2);
							alt_trade_name  = (String)alt_batch_ids.get(3);
%>							<input type='hidden' name='alt_shared_drug_<%=altRecCount%>' id='alt_shared_drug_<%=altRecCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
							<select name="alt_batch_id_<%=altRecCount%>" id="alt_batch_id_<%=altRecCount%>" style="font-size:11;">
								<option value="<%=(String)alt_batch_ids.get(0)%>"><%=(String)alt_batch_ids.get(0)%></option>
							</select>					
<%
						}
						else{
%>							<input type='hidden' name="alt_shared_drug_<%=altRecCount%>" id="alt_shared_drug_<%=altRecCount%>" value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
							<select name="alt_batch_id_<%=altRecCount%>" id="alt_batch_id_<%=altRecCount%>" style="font-size:11;" onChange="assignBatchDetails('<%=mode%>','ALT_NON_IV',this,'<%=altRecCount%>','','<%=disp_drug_code%>','<%=drug_code%>','<%=qty%>','<%=order_id%>','<%=order_line_num%>','<%=freq_nature%>','Y','<%=disp_drugs%>')"><!-- disp_drug_code,order_id,order_line_num,Freq_nature,disp_drugs added for BRU-CRF-399.1-->
							<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
							for(int kk=0;kk<alt_batch_ids.size();kk=kk+9){////changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
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
						<input type="checkbox" name="alt_chk_<%=altRecCount%>" id="alt_chk_<%=altRecCount%>" value="E" checked onClick="">
						<label name="alt_remarks_<%=altRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center" onClick="enterRemarks('<%=alt_drug_desc%>','<%=drug_class%>','<%=altRecCount%>','<%=alt_drug_code%>','<%=mode%>','','','<%=freq_code%>','','','','','','','<%=iv_prep_yn%>')"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></label>&nbsp;
						<img src="../../eCommon/images/mandatory.gif" align="center" id="alt_drug_remarks_mand_id_<%=altRecCount%>" ></img>
						<input type="hidden" name="alt_mand_symbol_<%=altRecCount%>" id="alt_mand_symbol_<%=altRecCount%>" value="style='display:inline'"
						</td>
						<td class="<%=classvalue%>" style="<%=patient_stock_display%>" >
							<input type="checkbox" name="non_iv_patient_stock_<%=altRecCount%>" id="non_iv_patient_stock_<%=altRecCount%>" value="E" <%=patient_stock_checked%> style="<%=patient_stock_check_display%>" <%=patient_stock_disabled%> >
						<%if(!freq_nature.equals("P") && cancelYn.equals("Y") &&!dis_continued.equals("Y") && !hold.equals("Y")&&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 and freq_nature added for SKR-SCF-1429 %>
					<img src="../../ePH/images/cancelAdmin.jpg" align="center"  width="17" height="17"  title="Cancel Admin" onclick="cancelAdminstration('<%=encode_drug_desc%>','<%=admin_by_name%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=qty%>','<%=patient_id%>','<%=encounter_id%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>')"></img></td>
					
<%
					}%>
						</td><!-- GHL-CRF-0482-->
						<td class="<%=classvalue%>">
						<input type="checkbox" name="chk_alt_non_iv_select_<%=altRecCount%>" id="chk_alt_non_iv_select_<%=altRecCount%>" value="E" checked>
						</td>
						</tr>
	<%	
					}	// end for(int n=0; n<multi_drugs.size(); n+=5) on line no. 1293
				} // end if(recCount==row_no && multi_drugs.size()>0) on line no. 1290==End of Alt Non IV
			} // end else on line no. 1068
			recCount++;
		} // end for (int i=0;i<non_iv_drug_details.size();i=i+inc) on line no.339
%>
		</table>
		</div>
<%
	} // end if(non_iv_drug_details.size()>0) on line no.294
%>	
	<br>
	<input type="hidden" name="iv_records" id="iv_records"	value="">
	<jsp:include page="MedicationAdministrationFTDrugDtlsIV.jsp"> 
	<jsp:param name="recCount" value="<%=String.valueOf(recCount)%>" />  
	</jsp:include>
<%
	recCount	= recCount -1;
	tot_records = (recCount+newRecCount+altRecCount)-no_of_alt_drus_selected;

	String parvalues=current_date_time+"~"+encounter_id+"~"+admin_due_date+"~"+assign_bed_num+"~"+Store_locn_code+"~"+nursing_unit+"~"+patient_id+"~"+patient_id_test+"~"+order_id_test+"~"+order_line_no_test+"~"+str_row_no+"~"+bean_id+"~"+bean_name+"~"+CommonRepository.getCommonKeyValue( "MODE_INSERT" )+"~"+tot_records+"~"+recCount+"~"+altRecCount+"~"+newRecCount+"~"+mode+"~"+drugCode+"~"+selDateTime+"~"+hold_discontinue_yn+"~"+locale+"~"+from_time+"~"+freq_nature+"~"+freq_nature+"~"+userAuthPINYN+"~"+admin_from_date+"~"+admin_to_date+"~"+dob+"~"+isSite_spec_patient_stock+"~";
%>
		<jsp:include page="../../ePH/jsp/MedicationAdministrationFTDrugDtls01.jsp" > 
			<jsp:param name="parvalues" value="<%=parvalues%>"/>
		</jsp:include>	
<% 
	if(function_from.equals("CP")){ //&& flag.equals("Y") removed for SKR-SCF-1172
%>
	  <table align="center"><tr><td colspan="222" class="white">&nbsp;</td><td  class="white" ><input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="callCancel()"></td><td   class="white" ><input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="callrecord()"></td></tr>
	  </table>
<%
	} 
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_all_stages,bean_all_stages,request);
	putObjectInBean(drug_search_bean_id,drug_bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
if(mode!=null && !mode.equals("CP")){
%>
<script language="javascript">
	if(parent.parent.frames[1].document.getElementById("barcode_id")!=undefined){
		parent.parent.frames[1].document.getElementById("barcode_id").disabled=false;
		parent.parent.frames[1].document.getElementById("barcode_id").focus();
}
<%}
   if(mode!=null && mode.equals("NOTIME")){
%>
		 parent.parent.commontoolbarFrame.document.getElementById("apply").disabled=true;
		
<% 
	}
%>

	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
catch(Exception e){
	e.printStackTrace();
}
%>
	</form>
	</body>
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:15%;visibility:hidden;" bgcolor="blue">
	<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="100%" height="100%" align="center">
	<tr><td id="t"></td></tr>
	</table>
	</div>
	</html>
	

