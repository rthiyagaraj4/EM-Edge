<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	   Name		   Rev.Date   	 Rev.By 	   Description
07/03/2019    IN067953         Devindra       ?           ?            MMS-KH-CRF-0014 
07/07/2019             Manickavasagam       ?           ?            SKR-SCF-1240 
19/08/2019		IN071056		Manickavasagam				 		SKR-SCF-1264
23/06/2020    IN073263        Prabha								  SKR-SCF-1375
09/10/2020    IN74073        Manickavasagam J								  SKR-SCF-1440
31/01/2021    TFS:12662	     Manickavasagam J			     MMS-KH-CRF-0039
*/ 
%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,java.lang.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	 <head>
	 <%
	 request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends

	 String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
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
		</style>
	 </head>
	 <body>
<%
		String locale = (String) session.getAttribute("LOCALE");
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
		String callFrom					=	 request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String  recCount1 					=  request.getParameter("recCount")==null?"":request.getParameter("recCount");
		int recCount =Integer.parseInt(recCount1);
		boolean boolAllergy_icon		=	false;	//Added for RUT-CRF-0065.1 [IN:43255]
		String 	strAllergyreason =	"",generic_id="",generic_name="";//Added for RUT-CRF-0065.1 [IN:43255]
		String disp_schedule_uom_desc="", admin_uom_desc = "";
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
		String drugCode					=    "";
		String selDateTime				=    "";
		String flag						=    "";
				
		String ward_ack_yn = "";//GHL-CRF-0458
		String patient_class_ord = "";//GHL-CRF-0458
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
		//boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // commented for MMS-KH-CRF-0014 [IN:067953]		
		boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
		boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
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
		String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
		String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
				String cancel_recorded_yn="N";//added for jd-crf-0200
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
				drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,order_id,shedule_date_time,"",hold_discontinue_yn,administration_status,order_type,display_order_by,route_admin,admin_route_categ,patient_id_test,"");// added	patient_id_test and "" string for the incident IN037217 and removed drugcode for SKR-SCF-1172		 
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
		ArrayList iv_drug_details				    =	 (ArrayList) drug_details.get("IV");
		String admin_bean_id						=	  "MedicationAdministrationBean";
		String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
		MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
		String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
		admin_bean.setLanguageId(locale);
		String totalTaperQtyDisplay = admin_bean.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
		String allowMAR_share_drug = admin_bean.getAllowMARShareDrug();//Added for HSA-CRF-0090[IN041241] -start
		String shared_drug_disp = "";
		if(allowMAR_share_drug==null || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
			shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end

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
		int tot_records						=   0;		
		int altRecCount						=   0;		int newRecCount		 = 0;
		int ivRecCount						=   0;		
		String patient_id					=   "";
		int no_of_alt_drus_selected			=   0;	
		String stat_style					=   "";
		String store_code	  =	"";
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
		String sch_date_time				=   "";		
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
		String route_color 	=   "";   // Code Added For RUT-CRF-0034 Start
		String fntColor                     =   "#OOOOOO";
		String backGrndColor                =   "#FFFFFF";   // Code Added For RUT-CRF-0034 End
		String order_pract_id 	=   "";  //Added for [IN:040149]
		String bat_id_lookbutton_enabled="Y", auto_Admin_dis="", verbalOrder="";
		String pin_value=bean.getPinNumber();
		DecimalFormat dfToInteger = new DecimalFormat("####.##");
		ArrayList work_sheet_batch_det1		=	new ArrayList();
		ArrayList sliding_scale_details		=	new ArrayList();
		int temp1                           =   0;
		int temp2                           =   0;		
		int temp3                           =   0;		
		int inc								=   0;
		float dialog_height					=	0;
		HashMap overridereason				=	new HashMap();
		int ppn_count						=   0;
		String taper_yn	=	 "N", addedTaperSch="";  //Added for RUT-CRF-0088 [IN036978]
		ArrayList totQty =null,  WardReturnQty= null;
		String dispensed_drug_desc="", disp_drugs="", dispense_drug_code="";
		
	if(iv_drug_details.size()>0){
%>	
		<img id="ball" src="/images/ball.png" style="visibility:hidden" height="5"/>
		<div id="headStart2" >  
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
		<td nowrap class="TDSTYLE" width="11%"><B><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></B></td><!-- Modified for HSA-CRF-0090[IN041241] -->
		<td class="TDSTYLE" width="9%"><B><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></B></td>
		<td class="TDSTYLE" width="12%"><B><fmt:message key="ePH.AdminDtls.label" bundle="${ph_labels}"/></B></td>
		<td class="TDSTYLE"><B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B></td>
		</tr>
		<tr>
		<td class='COLUMNHEADER'  colspan="16"   style="font-size:10"><b><fmt:message key="ePH.IVAdministration.label" bundle="${ph_labels}"/></b></td>
		</tr>
<%   	String sch_infusion_rate        =   "";
		String sch_infusion_vol_str_unit=   "";
        String sch_infusion_vol_str_unit_desc =   "";
		String sch_infusion_per_unit    =   "";
		String sch_infusion_per_unit_table_date = "";
		String trade_name               =   "";
		String qty_uom					=   "";
		String sch_infusion_period		=   "";
		String sch_infusion_period_unit =   "";
		String sch_infusion_period_unit_label =   "";
		String admin_date_time			=	"";
		String modified_date_time		=	"";
		String showTitle				=	""; 
		String displayStyle				=   "";
		String classvalue						=	"";
		String unit_dose				=   "";
		String no_of_doses				=   "";
		String dosage_seq_no			        =   "";
		String hide_ingredient_dtls		=   "";
		String prod_name				=	"";
		String cmp_flag                 =   "";
		String sch_infusion_in_min      =   "";
		String tol_title                =   "";
		String administred_batch_id     =   "";
		String disp_batch_id		    =   "";
		String iv_no_of_drug_per_order  =   "1";
		String MfrYN					=	"N";
		String sfrFLOW_STATUS			=	"";//single flow rate
		String sfrHOLD_DATE_TIME		=	"";
		String sfrHOLD_DURN_IN_MINS		=	"";
		String sfrRESUME_DATE_TIME		=	"";
		String sfrACT_START_DATE_TIME	=	"";
		String sfrACT_END_DATE_TIME		=	"";
		String mfrRemarks				=	"";
		String completedMinutes			=	"0";
		String completedFlow			=	"0";
		String iv_order_pract_id        =""; //Added for [IN:040149]
		String sch_dosage_uom_code	    = ""; //SKR-SCF-1240
		boolean mfrCompletedStatus		=	false;
		ArrayList MfrDetails			=	new ArrayList();
		ArrayList work_sheet_batch_det	=   new ArrayList();
		String drug_count = "1";
		for(int i=0;i<iv_drug_details.size();i+=74){//73 changed to 74 for JD-CRF-0200
			iv_order_pract_id  =  (String)iv_drug_details.get(i+68)==null?"":(String)iv_drug_details.get(i+68); //Added for [IN:040149]
			generic_id = (String)iv_drug_details.get(i+69)==null?"":(String)iv_drug_details.get(i+69); // Added for RUT-CRF-0065.1 [IN:43255]
			linkVacScheduleCode			="";
			dosage_seq_no				= iv_drug_details.get(i+36)==null?"":(String)iv_drug_details.get(i+36);
			pres_catg_code =iv_drug_details.get(i+49)==null?"":(String)iv_drug_details.get(i+49);
			auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);								
			auth_reqd_script="";
			could_not_administer = "";//added for SKR-SCF-1264
			if(auth_reqd){
				if(pin_value.equals(""))
					auth_reqd_script=";pinAuthentication(this,'NP');";
				else
					auth_reqd_script=";pinAuthentication(this,'YP');";
			}
			pract_id					= (String)iv_drug_details.get(i+37);
			against_sch_date			= (String)iv_drug_details.get(i+38);
			adr_reason					= (String)iv_drug_details.get(i+39);
			adr_remarks					= iv_drug_details.get(i+40)==null?"":(String)iv_drug_details.get(i+40);
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
			sch_infusion_per_unit		= (String)iv_drug_details.get(i+3)==null?"":(String)iv_drug_details.get(i+3);
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
			drug_code                =   (String)iv_drug_details.get(i+29);//pres_drug_code
			dispense_drug_code       =   (String)iv_drug_details.get(i+72);
			if(dispense_drug_code.equals(""))
				dispense_drug_code = drug_code;
			dispensed_drug_desc	     =   (String)iv_drug_details.get(i+70);	
			disp_drugs			     =   (String)iv_drug_details.get(i+71);	
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
			administered			 =	 (String)iv_drug_details.get(i+22);
			store_code				 =   (String)iv_drug_details.get(i+30);
			end_date_time 			 =   (String)iv_drug_details.get(i+33);
			freq_code				 =   iv_drug_details.get(i+34)==null?"":(String)iv_drug_details.get(i+34);		
			
			if(iv_prep_yn!=null && (iv_prep_yn.equals("5") || (iv_prep_yn.equals("1") && order_line_num.equals("1")))){//SKR-SCF-1397 and iv_prep_yn and order_line_num added for SKR-SCF-1421
				no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num,iv_prep_yn,drug_code);
			}else{
				no_of_doses				 =   bean.getNoOfDoses(order_id,order_line_num);
			}
			encode_drug_desc         =   drug_desc.replaceAll(" ","%20");
			encode_drug_desc         =   java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
			encode_drug_desc         =   encode_drug_desc.replaceAll("%2520","%20");						
			ext_prod_id              =   (String)iv_drug_details.get(i+44);
			iv_no_of_drug_per_order  =   (String)iv_drug_details.get(i+45);
			trade_code			     =   (String)iv_drug_details.get(i+46);
			imageFileURL			 =   (String)iv_drug_details.get(i+47);
			sch_dosage_uom_code	     =   (String)iv_drug_details.get(i+51); //SKR-SCF-1240
			admn_dose_chng_reason_code = (String)iv_drug_details.get(i+52);
			Store_locn_code			 =	(String)iv_drug_details.get(i+65)==null?"":(String)iv_drug_details.get(i+65);
			 String iv_Auto_Admin               =   bean.getAutoAdminValue(facility_id,Store_locn_code);
			cmp_flag				 =   bean.syscomp(com.ehis.util.DateUtils.convertDate(end_date_time,"DMYHM",locale,"en"),order_id,order_line_num);
			next_schd_date           =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);//added for SCF-7528
			linkVacScheduleCode		 =	(String)iv_drug_details.get(i+53);
			MfrYN					 =	(String)iv_drug_details.get(i+54)==null?"N":(String)iv_drug_details.get(i+54);
			sfrFLOW_STATUS			 =	(String)iv_drug_details.get(i+55)==null?"NS":(String)iv_drug_details.get(i+55);
			sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(i+56)==null?"":(String)iv_drug_details.get(i+56);
			sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(i+57)==null?"0":(String)iv_drug_details.get(i+57);
			sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(i+58)==null?"":(String)iv_drug_details.get(i+58);
			sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(i+59)==null?"":(String)iv_drug_details.get(i+59);
			cancel_recorded_yn=(String)iv_drug_details.get(i+73)==null?"N":(String)iv_drug_details.get(i+73);//added for jd-crf-0200
			//Added IF-Condition for converting date on 8/10/2010 regarding incident num:24067.==By Sandhya
			if(!(sfrACT_START_DATE_TIME.equals(""))){
				sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
			} //Ends
			if(sfrACT_START_DATE_TIME.equals("")){
				sfrACT_START_DATE_TIME=current_date_time;
			
			}
			//added for GHL-CRF-0458 - start
			if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){// isSiteSpecMARPrint changed to WardAckMarRequiredYn.equalsIgnoreCase("Y") for 
			patient_class_ord = bean.getOrderPatientClass(order_id);
			if(patient_class_ord==null)
				patient_class_ord = "";
			}
			//added for GHL-CRF-0458 - end
			sfrACT_END_DATE_TIME	 =	(String)iv_drug_details.get(i+60)==null?"":(String)iv_drug_details.get(i+60);
			dosage_type				 =	(String)iv_drug_details.get(i+61)==null?"":(String)iv_drug_details.get(i+61);
			mfrRemarks				 =	(String)iv_drug_details.get(i+62)==null?"":(String)iv_drug_details.get(i+62);
			completedMinutes		 =	(String)iv_drug_details.get(i+63)==null?"0":(String)iv_drug_details.get(i+63);
			completedFlow			 =	(String)iv_drug_details.get(i+64)==null?"0":(String)iv_drug_details.get(i+64);
			int adr_count			= bean.getADRCount(patient_id_test,drug_code);  //newly added for RUT-SCF-0144 [IN:033371] 

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
				String linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);									
				if(!linkVacScheduleCode1.equals("NO DEFAULT")){
					try{
						String[] vacScheduleDetails;
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
					String[] vacScheduleDetails;
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
			if(freq_nature.equals("P") || bean.enableSelect(com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en"), admin_from_date,admin_to_date) || function_from.equals("CP")) {
				select_status	=	"";
				dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";
			}
			else{
				select_status	=	"disabled";
				dtl_style		=	"visibility:hidden";
				mand_display	=	"style='display:none'";
			}

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
			remarks = iv_drug_details.get(i+24)==null?"Not Entered":(String)iv_drug_details.get(i+24);				
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
			if( freq_code.equals("STAT")) //added by abdul for SCF# 5899
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
			ArrayList iv_batch_ids = new ArrayList();
			HashMap  administred_batch   = bean.getAdminBatchID(order_id,order_line_num,encounter_id, sch_date_time ,drug_code);
			administred_batch_id = (String)administred_batch.get("BATCH_ID");						
			if(administred_batch_id == null)administred_batch_id="";
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
			boolAllergy_icon = false;// Added for RUT-CRF-0065.1 [IN:43255]
			if(ext_prod_id!=null && !ext_prod_id.equals("")){										
				if(overridereason.size()>1)
				   show_remarks="Y";
				strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
				if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
					boolAllergy_icon = true;
			}
			else{									
				if(overridereason.size()>0)
					   show_remarks="Y";
				strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
				if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
					boolAllergy_icon = true;
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
			} // end else 
			if(admin_recorded_yn.equals("Y")){
				if(order_line_num.equals("1"))
					classvalue="IVFLUID1";
				else
					classvalue="IVINGREDIENT1";
				
				//added for SKR-SCF-1375
				if(could_not_administer.equals("Y")){ // added for SKR-SCF-1431
				iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"Y");
				if(iv_batch_ids!=null && iv_batch_ids.size()>0)
					batch_id = (String)iv_batch_ids.get(0);
				} 
				//added for SKR-SCF-1375
%>
				<tr>
<% 
                if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
	                  select_status="disabled";
	                   displayStyle = "";	
	                   sfrFLOW_STATUS_style ="font-size:8;align:center;";
                } // Added for KH-SCF-0010 - End
				if(order_line_num.equals("1")) { 
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
%>
					<td id = 'medAdminIV<%=ivRecCount%>' class="white" width="2%" style="<%=displayStyle%>"  onclick="">&nbsp;</td>
<%                  } // Added for KH-SCF-0010 - End
					else{
				%>
					<td id = 'medAdminIV<%=ivRecCount%>' class="white" width="2%" style="<%=displayStyle%>"  onclick="enableIVAdmin('<%=ivRecCount%>','<%=admin_recorded_yn%>','<%=administered%>','<%=iv_no_of_drug_per_order%>')">&nbsp;</td>
<%
					}
				} 
				else{	
%>
					<td id = 'medAdminIV<%=ivRecCount%>' class="white" width="2%" >&nbsp;</td>
<%
				}
%>
				<input type="hidden" name="iv_qty_in_disp_mode_<%=ivRecCount%>" id="iv_qty_in_disp_mode_<%=ivRecCount%>" value="">
				<td id = 'drugIndi<%=ivRecCount%>' class="<%=classvalue%>" style="<%=drug_class_ind%>">											
				<label id='drug_mast_det_old<%=ivRecCount%>' style="font-size:9;font-weight:bold;color:black;display:inline" title="<%=prod_name%>"><%=drug_desc%> &nbsp;&nbsp;</label>
<%
				if ((iv_prep_yn.equals("0"))||(iv_prep_yn.equals("2"))||(iv_prep_yn.equals("4"))||(iv_prep_yn.equals("6"))){
%>
					<label  id="drug_mast_det_1<%=recCount%>">&nbsp;</label>
<%
				}
				else{
%>
					<label id="drug_mast_det_1<%=ivRecCount%>" style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;display:none' onclick="loadPage('<%=drug_code%>');" >&nbsp;+&nbsp;</label>
<%
				}
%>
				<label id='drug_desc<%=ivRecCount%>' style ="display:none" class='descFont'><%=drug_desc%>&nbsp;&nbsp;</label>
<%//added for AAKH-CRF-0024 [IN:038260] Ends
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
				if(adr_count>0){// added for RUT-SCF-0144 [IN:033371] -- start
%>
					<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=drug_code%>');"></img>
<%
				} // added for RUT-SCF-0144 [IN:033371]  -- end
				 if(prod_name.length()==0){
					if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
						<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" onmouseover="changeCursor(this);">
<%													
					}
				}
				if(boolAllergy_icon){
%>
						<img src='../../eCA/images/HI_RecordAllergies.gif' width='17' height='15' onclick = "showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=encode_drug_desc%>');" onmouseover="changeCursor(this);">
<%
				}
				if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){
%>
					<br><label style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_drugs%> </label>
					<input type="hidden" name="dispensed_drug_desc_<%=recCount%>" id="dispensed_drug_desc_<%=recCount%>" value="<%=disp_drugs%>">
<%
				}
%>
				</label>
				</td>
<%
				if(order_line_num.equals("1")) {
					if(adr_reason!=null && !adr_reason.equals("")){
%>
						<td class="<%=classvalue%>" width="2%"><img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>"></img>
<%
					}
					else if(!admin_date_time.equals("") && administered.equals("Y")){
%>
						<td class="<%=classvalue%>" width="2%"><%=img_path%></td> 
<%														
					}
					else{
%>
						<td class="<%=classvalue%>" width="2%">&nbsp;</td>
<%
					}
				}
				else{	
%>
					<td class="<%=classvalue%>" width="2%">&nbsp;</td>
<%
				}	
%>
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

				if(could_not_administer.equals("Y")){ //if condition added for SKR-SCF-1264
				qty = "0";
				}
				if(!(MfrYN.equals("Y") && order_line_num.equals("1"))){
%>
					<td class="<%=classvalue%>">
<%
					if(Float.parseFloat(qty) < 1.0){//to prefix a zero
%>
						<label id='qty_old<%=ivRecCount%>' style="font-size:10">
						<%
						if(!qty.equals("0")){ //if condition added for SKR-SCF-1264 - start
						%>
						<%=(Float.parseFloat(qty)+"")%>
						<%}else{ %>
							<%=qty%>
						<%
						}// added for SKR-SCF-1264 - end
						%>
						
						</label>
						<input type="text" id="iv_admin_qty_<%=ivRecCount%>" name="iv_admin_qty_<%=ivRecCount%>" size="1" maxlength="4" value="<%=(Float.parseFloat(qty)+"")%>"  <%=sfrFLOW_STATUS_disable%> class="number" style="display:none;font-size:11;" onKeyPress="return allowValidNumber(this,event,6,3);" onBlur="CheckNum(this);changeDisplay(this,'<%=ivRecCount%>','<%=sch_infusion_per_unit_table_date%>');getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>'); makeDtlsMandatory(this,'<%=ivRecCount%>','<%=drug_code%>','iv','<%=freq_nature%>');">
						<label id='qty_uom_old<%=ivRecCount%>' style="font-size:10;align:center"><%=qty_uom%></label>
						<label id= 'qty_uom<%=ivRecCount%>' style="font-size:10;display:none;" ><b><%=qty_uom%></b></label>
<%
					}
					else{
%>
						<label id='qty_old<%=ivRecCount%>' style="font-size:10;"><%=qty%></label>
						<input type="text" id="iv_admin_qty_<%=ivRecCount%>" name="iv_admin_qty_<%=ivRecCount%>" size="1" maxlength="4" value="<%=qty%>"  <%=sfrFLOW_STATUS_disable%> class="number" style="display:none;font-size:11;" onKeyPress="return allowValidNumber(this,event,6,3);" onBlur="CheckNum(this);changeDisplay(this,'<%=ivRecCount%>','<%=sch_infusion_per_unit_table_date%>');getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>'); makeDtlsMandatory(this,'<%=ivRecCount%>','<%=drug_code%>','iv','<%=freq_nature%>');">
						<label id='qty_uom_old<%=ivRecCount%>' style="font-size:10;align:center;"><%=qty_uom%></label>
						<label id = 'qty_uom<%=ivRecCount%>' style="font-size:10;display:none;" ><b><%=qty_uom%></b></label>
<%
					}
					if(!(admn_dose_chng_reason_code.equals(""))){						
						String admn_chng_dose_reason_desc = (String) bean. getAdmn_chng_dose_reason_desc(admn_dose_chng_reason_code);
%>
						<img src="../images/changeddosageindicator.gif" align="center" id="chng_dose_ind" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels") +"\n"%>-----------<%="\n"+admn_chng_dose_reason_desc%>"></img>
<%
					}
%>
					<input type="hidden" name="iv_qty_uom_<%=ivRecCount%>" id="iv_qty_uom_<%=ivRecCount%>" value="<%=qty_uom%>">
					</td>
<%											
					if(freq_nature!=null && freq_nature.equals("C")){
%>
						<td class="<%=classvalue%>"  >
						<label style="font-size:10;<%=hide_ingredient_dtls%>" >[<b><%=dosage_seq_no%>/<%=no_of_doses%></b>]</label>
						</td>
<%
					}
					else{
%>
						<td class="<%=classvalue%>" >&nbsp;</td>
<%
					}
				}
				else{
%>					<td class="<%=classvalue%>">&nbsp;</td>
					<td class="<%=classvalue%>" >&nbsp;</td>
<%
				}
%>
				<input type="hidden" name="h_iv_admin_qty_<%=ivRecCount%>" id="h_iv_admin_qty_<%=ivRecCount%>" value="<%=qty%>">
				<input type="hidden" name="iv_modified_date_time_<%=ivRecCount%>" id="iv_modified_date_time_<%=ivRecCount%>" value="<%=modified_date_time%>">
				<input type="hidden" name="sch_infusion_per_unit_<%=ivRecCount%>" id="sch_infusion_per_unit_<%=ivRecCount%>" value="<%=sch_infusion_per_unit_table_date%>">
				<input type="hidden" name="iv_infusion_period_<%=ivRecCount%>" id="iv_infusion_period_<%=ivRecCount%>" value="<%=sch_infusion_period%>">
				<input type="hidden" name="could_not_administer_<%=ivRecCount%>" id="could_not_administer_<%=ivRecCount%>" value="<%=could_not_administer%>">
				<input type="hidden" name="iv_admin_chng_dtls_req_<%=ivRecCount%>" id="iv_admin_chng_dtls_req_<%=ivRecCount%>" value="N">
				<input type="hidden" name="sch_dosage_uom_code_<%=ivRecCount%>" id="sch_dosage_uom_code_<%=ivRecCount%>" value="<%=sch_dosage_uom_code%>"><!-- added for SKR-SCF-1240-->
<%
				if(order_line_num.equals("1")){					
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
%>
					<td style='background-color:<%=backGrndColor%>;'><label style="font-size:10;color:<%=fntColor%>;"> <%=route_desc%></label><% if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){%><br><div id="orderctl<%=ivRecCount%>" onClick=""><label id="orderctllink<%=ivRecCount%>" style="<%=sfrFLOW_STATUS_style%>display:none"><b><%=sfrFLOW_STATUS_String%><b><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=ivRecCount%>'></label></div><%}%></td>
<%				
					} // Added for KH-SCF-0010 - End
					else{
					%>
					<td style='background-color:<%=backGrndColor%>;'><label style="font-size:10;color:<%=fntColor%>;"> <%=route_desc%></label><% if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){%><br><div id="orderctl<%=ivRecCount%>" onClick="displayToolTipSFR('<%=ivRecCount%>')" onMouseOver="hideToolTip('<%=ivRecCount%>')"><label id="orderctllink<%=ivRecCount%>" style="<%=sfrFLOW_STATUS_style%>display:none"><b><%=sfrFLOW_STATUS_String%><b><img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=ivRecCount%>' name='imgArrow<%=ivRecCount%>'></label></div><%}%></td>
					<%}
				}
				else{
%>
					<td class="<%=classvalue%>">&nbsp;</td>
<%				
				}
				if(!(MfrYN.equals("Y") && order_line_num.equals("1"))){
%>
					<td class="<%=classvalue%>"  >
<%
					if(!(MfrYN.equals("Y") && !(order_line_num.equals("1")))){
%>
						<label style="font-size:10;" ><%=sch_date_time%></label>
<%
					}
%>					
					&nbsp;</td>
					<td class="<%=classvalue%>">
					<label id='admin_date_time_old<%=ivRecCount%>' style="font-size:10;<%=hide_ingredient_dtls%>" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddatetime.label", "common_labels")%> :<%=com.ehis.util.DateUtils.convertDate(modified_date_time, "DMYHM","en",locale)%>"><%=admin_date_time%></label>
					<input type="text" id='iv_infusion_st_time_<%=ivRecCount%>' name="iv_infusion_st_time_<%=ivRecCount%>" size="13" maxlength="16" value="<%=current_date_time%>" style="font-size:11;" onBlur=" validateAdminDateTime('<%=admin_date_time%>','<%=current_date_time%>', this,'<%=locale%>','<%=sch_date_time%>');" <%=sfrFLOW_STATUS_disable%> style="display:none">
					</td>
					<td class="<%=classvalue%>">
					<label id="iv_flow_rate_old<%=ivRecCount%>"  style="font-size:10;align:center;<%=hide_ingredient_dtls%>"><%=sch_infusion_rate%></label>
					<label id="iv_flow_rate_desc_old<%=ivRecCount%>" style="font-size:10;align:center;<%=hide_ingredient_dtls%>"><%=sch_infusion_vol_str_unit_desc%>/<%=sch_infusion_per_unit%></label>
					<input type="text" id="iv_flow_rate_<%=ivRecCount%>" name="iv_flow_rate_<%=ivRecCount%>" size="2" maxlength="9" value="<%=sch_infusion_rate%>" class="number" style="font-size:11;color:blue" onKeyPress="return allowValidNumber(this,event,6,3);" onBlur="CheckNum(this);changeDisplay(this,'<%=ivRecCount%>','<%=sch_infusion_per_unit_table_date%>');getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>')" style="display:none" <%=sfrFLOW_STATUS_disable%>>
					<label id="iv_flow_rate_desc<%=ivRecCount%>" style="font-size:10;" style="display:none"><b><%=sch_infusion_vol_str_unit_desc%>/<%=sch_infusion_per_unit%></b>
					</td>
					<td class="<%=classvalue%>">
					<label id="iv_infusion_period_txt_old<%=ivRecCount%>" style="font-size:10;"><script language="javascript">document.write(getHrsMinStrForAdminYES(<%=sch_infusion_period%>,'<%=sch_infusion_period_unit%>'));</script></label>
					<label id="sch_inf_per_old<%=ivRecCount%>" style="font-size:10;"><%=sch_infusion_period_unit_label%></label>
					<input type="text" id="iv_infusion_period_txt<%=ivRecCount%>" name="iv_infusion_period_txt<%=ivRecCount%>" size="1" maxlength="6" value="" style="font-size:11;display:none" disabled class="number">
					<label id="sch_inf_per_desc<%=ivRecCount%>" style="font-size:10;display:none"><b><%=sch_infusion_period_unit_label%><div id="sch_inf_per_<%=ivRecCount%>">&nbsp;</div></b></label>
					</td>
					<td class="<%=classvalue%>">
					<label id="iv_batch_id_old<%=ivRecCount%>" style="font-size:10;">&nbsp;<%=batch_id%></label>
<%
					if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){// added for AAKH-CRF-0024 [IN:038260] Starts
%>
						<input type="text" id="iv_batch_id_<%=ivRecCount%>" style='display:none' name="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=(String)work_sheet_batch_det.get(1)%>"  disabled >	   
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
							<input type="text" id="iv_batch_id_<%=ivRecCount%>" style='display:none' name="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>" style="font-size:11;" disabled >
							<input type="button" style='display:none' class="button" value="?" <%=auto_Admin_dis%>  onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=Store_locn_code%>','IV','<%=ivRecCount%>')" id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>" >
							<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>">
							<input type='hidden' name="IV_Newly_administerderd_<%=ivRecCount%>" id="IV_Newly_administerderd_<%=ivRecCount%>" value='IV_Y'>
							<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
							<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
						}
						else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
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
							if(ret_qty<=0){//adding end							
%>
								<input type="text" id="iv_batch_id_<%=ivRecCount%>" style='display:none' name="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=(String)iv_batch_ids.get(0)%>" style="font-size:11;" disabled >
								<input type="button" class="button" value="?" style='display:none' onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=store_code%>','IV','<%=ivRecCount%>')" <%=auto_Admin_dis%> disabled id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>">
								<!-- code added for recording batch_id in ph_medn_admin_dtl -->
								<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=(String)iv_batch_ids.get(0)%>">
								<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
								<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
							}
							else{ //added below condition for incident NO:33194
								expiry_date="";
								select_status_1="";
%>
								<input type="text" id="iv_batch_id_<%=ivRecCount%>" style='display:none' name="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="" style="font-size:11;" disabled >
								<input type="button" class="button" value="?" style='display:none' onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=store_code%>','IV','<%=ivRecCount%>')" <%=auto_Admin_dis%> disabled id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>">
<%
							}
%>

<%						} 
						else{
%>
							<select id="iv_batch_id_<%=ivRecCount%>" style='display:none' name="iv_batch_id_<%=ivRecCount%>" style="font-size:11;" onChange="assignBatchDetails('<%=mode%>','IV',this,'<%=ivRecCount%>')">
							<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
							for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
								if (defaultBatch.equals((String)iv_batch_ids.get(kk))){
%>
									<option selected value="<%=(String)iv_batch_ids.get(kk)%>"><%=(String)iv_batch_ids.get(kk)%></option>
									<!-- code added for recording batch_id in ph_medn_admin_dtl -->
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
					<input type="hidden" name="iv_Remarks<%=ivRecCount%>" id="iv_Remarks<%=ivRecCount%>" value="N">
					<td class="<%=classvalue%>">
					<label id="iv_expiry_date_old<%=ivRecCount%>" name="iv_expiry_date_old<%=ivRecCount%>" style="font-size:10;">&nbsp;<%=expiry_date%></label>
					<input type="text" name="iv_expiry_date_<%=ivRecCount%>" id="iv_expiry_date_<%=ivRecCount%>" size="9" maxlength="10" disabled value="<%=expiry_date%>" style="font-size:11;display:none">
					</td>
					<td class="<%=classvalue%>" style="display:none">
					<label style="font-size:10;">&nbsp;<%=trade_name%></label>
					</td>
<%
				}
				else{
					MfrDetails=bean.getStatusOfMAR(order_id, "");
					String statusString="";
					if(MfrDetails.size()>0)
					{
						statusString=(String)MfrDetails.get(0);												
					}%>
					<td class="<%=classvalue%>" colspan=6 id="MFR_status_column_<%=ivRecCount%>"><%if(order_line_num.equals("1")){%><label name="iv_MFR_dtls_<%=ivRecCount%>" id="iv_MFR_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openMFRDetails('<%=ivRecCount%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=drug_code%>','<%=Store_locn_code%>','Admin','');"><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label><%}%></td>
<%				}
				String md_admn_req ="";
				if(bean.isWitnessedbyRequiredForIV(order_id)){
					md_admn_req="Y";
				}
				if(order_line_num.equals("1")) {
					if(!cmp_flag.equals("N")){	 
%>
						<td class="<%=classvalue%>" >
						<input type="checkbox" style='display:none' name="iv_chk_complete_<%=ivRecCount%>" id="iv_chk_complete_<%=ivRecCount%>" value="E" checked onClick="clearDrgRemarks(this,'<%=ivRecCount%>','<%=drug_code%>','IV')">
						<label id="iv_lb_dtls_old<%=ivRecCount%>" style="font-size:10;color:black;" title="<%=showTitle%>"><fmt:message key="ePH.AdminDtls.label" bundle="${ph_labels}"/></label>
						<label id="iv_lbl_dtls_<%=ivRecCount%>" name="iv_lbl_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;display:none;" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=ivRecCount%>','<%=drug_code%>','<%=mode%>','IV','A','<%=freq_code%>','<%=dosage_seq_no%>','<%=no_of_doses%>','<%= order_id %>','<%=order_line_num%>','<%=encounter_id %>','<%=md_admn_req%>','<%=iv_prep_yn%>',iv_admin_chng_dtls_req_<%=(ivRecCount-Integer.parseInt(order_line_num)+1)%>,'<%=MfrYN%>','<%=sch_date_time%>','<%=sfrACT_START_DATE_TIME%>','','','','','<%=administered%>','<%=admin_recorded_yn%>')"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="iv_remarks_mand_id_<%=ivRecCount%>" style="display:visible"></img>
<% 
						if(!MfrYN.equals("Y")){
%>
							<br><label id ="iv_lb_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openAuditLogWindow('<%=ivRecCount%>','SFR');"><fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/></label>
<%
						}
%>
						</td>
<%
					}
					else{
%>
						<td class="<%=classvalue%>" >
						<!--added for AAKH-CRF-0024 [IN:038260] start-->
						<input type="checkbox" style='display:none' id="iv_chk_complete_<%=ivRecCount%>" name="iv_chk_complete_<%=ivRecCount%>" value="E" checked onClick="clearDrgRemarks(this,'<%=ivRecCount%>','<%=drug_code%>','IV')">
						<label id ="iv_lb_dtls_old<%=ivRecCount%>" name="iv_lb_dtls_<%=ivRecCount%>" style="font-size:10;color:black;align:center;" title="<%=showTitle%>" ><fmt:message key="ePH.AdminDtls.label" bundle="${ph_labels}"/></label>
						<label id="iv_lbl_dtls_<%=ivRecCount%>" name="iv_lbl_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;display:none" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=ivRecCount%>','<%=drug_code%>','<%=mode%>','IV','A','<%=freq_code%>','<%=dosage_seq_no%>','<%=no_of_doses%>','<%= order_id %>','<%=order_line_num%>','<%=encounter_id %>','<%=md_admn_req%>','<%=iv_prep_yn%>','N','<%=MfrYN%>','<%=sch_date_time%>','<%=sfrACT_START_DATE_TIME%>','','','','','<%=administered%>','<%=admin_recorded_yn%>')"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="iv_remarks_mand_id_<%=ivRecCount%>" style="display:none"></img>
						<img src="../../ePH/images/return.gif" id="nxt_adm_<%=ivRecCount%>" style="display:none"><!--added for AAKH-CRF-0024 [IN:038260] Ends-->
<%
						if(!MfrYN.equals("Y")){
%>
							<br><label id ="iv_lb_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openAuditLogWindow('<%=ivRecCount%>','SFR');"><fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/></label>
<%
						}
%>
						</td>
<%														
					} // end else on line no.1969
				} // end if(order_line_num.equals("1")) on line no.1957
				else{
%>
					<td class="<%=classvalue%>" >&nbsp;
					<label id="iv_lbl_dtls_<%=ivRecCount%>" name="iv_lbl_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;display:none" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=ivRecCount%>','<%=drug_code%>','<%=mode%>','IV','A','<%=freq_code%>','<%=dosage_seq_no%>','<%=no_of_doses%>','<%= order_id %>','<%=order_line_num%>','<%=encounter_id %>','<%=md_admn_req%>','<%=iv_prep_yn%>','N','<%=MfrYN%>','<%=sch_date_time%>','<%=sfrACT_START_DATE_TIME%>','','','','','<%=administered%>','<%=admin_recorded_yn%>')"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="iv_remarks_mand_id_<%=ivRecCount%>" style="display:none"></img>
					</td>
<%
				}	
%>	
					<input type="hidden" name="iv_dosage_seq_no_<%=ivRecCount%>" id="iv_dosage_seq_no_<%=ivRecCount%>" value="<%=dosage_seq_no%>"><!--added for AAKH-CRF-0024 [IN:038260] start-->
					<input type="hidden" name="iv_drug_code_<%=ivRecCount%>" id="iv_drug_code_<%=ivRecCount%>" value="<%=drug_code%>">
					<input type="hidden" name="iv_dispense_drug_code_<%=ivRecCount%>" id="iv_dispense_drug_code_<%=ivRecCount%>" value="<%=dispense_drug_code%>">
					<input type="hidden" name="iv_item_code_<%=ivRecCount%>" id="iv_item_code_<%=ivRecCount%>" value="<%=item_code%>">
					<input type="hidden" name="iv_prep_yn<%=ivRecCount%>" id="iv_prep_yn<%=ivRecCount%>"  value="<%=iv_prep_yn%>">
					<input type="hidden" name="iv_order_id_<%=ivRecCount%>" id="iv_order_id_<%=ivRecCount%>"  value="<%=order_id%>">
					<input type="hidden" name="iv_order_line_no_<%=ivRecCount%>" id="iv_order_line_no_<%=ivRecCount%>" value="<%=order_line_num%>">	
					<input type="hidden" name="iv_store_code_<%=ivRecCount%>" id="iv_store_code_<%=ivRecCount%>" value="<%=store_code%>">	
					<input type="hidden" name="iv_end_date_<%=ivRecCount%>" id="iv_end_date_<%=ivRecCount%>"   value="<%=end_date_time%>">
					<input type="hidden" name="next_schd_date_<%=ivRecCount%>" id="next_schd_date_<%=ivRecCount%>" value="<%=next_schd_date%>">
					<input type="hidden" name="iv_drug_class<%=ivRecCount%>" id="iv_drug_class<%=ivRecCount%>" value="<%=drug_class%>">
					<input type="hidden" name="iv_admin_date_time_<%=ivRecCount%>" id="iv_admin_date_time_<%=ivRecCount%>" value="<%=sch_date_time%>">
					<input type="hidden" name="iv_dtls_yn<%=ivRecCount%>" id="iv_dtls_yn<%=ivRecCount%>" value="Y">
					<input type="hidden" name="iv_order_pract_id_<%=ivRecCount%>" id="iv_order_pract_id_<%=ivRecCount%>" value="<%=iv_order_pract_id%>">
					<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" id="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit_desc%>">
					<input type="hidden" name="iv_trade_name_<%=ivRecCount%>" id="iv_trade_name_<%=ivRecCount%>" size="21" maxlength="40" disabled value="<%=trade_name%>" style="font-size:11;">
					<input type="hidden" name="iv_trade_id_<%=ivRecCount%>" id="iv_trade_id_<%=ivRecCount%>" value="<%=trade_id%>">
					<input type="hidden" name="iv_bin_code_<%=ivRecCount%>" id="iv_bin_code_<%=ivRecCount%>" value="">			<!--added for AAKH-CRF-0024 [IN:038260] End-->
				<td class="<%=classvalue%>">
				<label id ='chk_iv_select_old<%=ivRecCount%>' style="font-size:10;">&nbsp;</label>
<%
                   if(marForDisPatNotReqYN && dischargedYN){
	                      select_status= "disabled";
	                      displayStyle = "";	
	                      sfrFLOW_STATUS_style ="font-size:8;align:center;";
                    }
                   if(order_line_num.equals("1")){		//added for AAKH-CRF-0024 [IN:038260] start
					select_status=""; 
					if(MfrYN.equals("Y") && !mfrCompletedStatus ){
						select_status="disabled";
					}
					else if(((!MfrYN.equals("Y"))&&(sfrFLOW_STATUS.equals("ST")||sfrFLOW_STATUS.equals("HO")||sfrFLOW_STATUS.equals("RE")))||((hold.equals("Y")) || dis_continued.equals("Y"))){
						select_status="disabled";
					}
%>
					<input id="chk_iv_select_<%=ivRecCount%>" style='display:none' type="checkbox" name="chk_iv_select_<%=ivRecCount%>" value="E"  onClick="checkIVGroup('<%=ivRecCount%>','<%=iv_no_of_drug_per_order%>',this,'<%=sch_date_time%>')<%=auth_reqd_script%>" <%=select_status%>>
       <%if(cancelYn.equals("Y")&&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 %>
       <img src="../../ePH/images/cancelAdmin.jpg" align="center"  width="17" height="17"  title="Cancel Admin" onclick="cancelAdminstration('<%=encode_drug_desc%>','<%=admin_by_name%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=qty%>','<%=patient_id%>','<%=encounter_id%>','<%=admin_date_time%>')"></img></td>
<%}
				} 
				else{ 
%>
					<input id="chk_iv_select_<%=ivRecCount%>" style='display:none' type="checkbox" name="chk_iv_select_<%=ivRecCount%>" value="E"  disabled>
<%
				}
%>
				<input type="hidden" name="iv_no_of_drug_per_order_<%=ivRecCount%>" id="iv_no_of_drug_per_order_<%=ivRecCount%>" value="<%=iv_no_of_drug_per_order%>">
				<input type="hidden" name="iv_drug_desc<%=ivRecCount%>" id="iv_drug_desc<%=ivRecCount%>" value="<%=drug_desc%>">
				<input type="hidden" name="sfrFLOW_STATUS<%=ivRecCount%>" id="sfrFLOW_STATUS<%=ivRecCount%>" value="<%=sfrFLOW_STATUS%>">
				<input type="hidden" name="sfrRESUME_DATE_TIME<%=ivRecCount%>" id="sfrRESUME_DATE_TIME<%=ivRecCount%>" value="<%=sfrRESUME_DATE_TIME%>">
				<input type="hidden" name="sfrHOLD_DATE_TIME<%=ivRecCount%>" id="sfrHOLD_DATE_TIME<%=ivRecCount%>" value="<%=sfrHOLD_DATE_TIME%>">
				<input type="hidden" name="sfrACT_END_DATE_TIME<%=ivRecCount%>" id="sfrACT_END_DATE_TIME<%=ivRecCount%>" value="<%=sfrACT_END_DATE_TIME%>">
				<input type="hidden" name="flow_rate_changed_YN<%=ivRecCount%>" id="flow_rate_changed_YN<%=ivRecCount%>" value="">
				<input type="hidden" name="inf_prd_hrs<%=ivRecCount%>" id="inf_prd_hrs<%=ivRecCount%>" value="">
				<input type="hidden" name="durn_bw_std_resumed_<%=ivRecCount%>" id="durn_bw_std_resumed_<%=ivRecCount%>" value="">
				<input type="hidden" name="sfrHOLD_DURN_IN_MINS<%=ivRecCount%>" id="sfrHOLD_DURN_IN_MINS<%=ivRecCount%>" value="<%=sfrHOLD_DURN_IN_MINS%>">
				<input type="hidden" name="iv_dosage_type_<%=ivRecCount%>" id="iv_dosage_type_<%=ivRecCount%>" value="<%=dosage_type%>">
				<input type="hidden" name="inf_prd_min<%=ivRecCount%>" id="inf_prd_min<%=ivRecCount%>" value="">
				<input type="hidden" name="completedMinutes<%=ivRecCount%>" id="completedMinutes<%=ivRecCount%>" value="<%=completedMinutes%>">
				<input type="hidden" name="completedFlow<%=ivRecCount%>" id="completedFlow<%=ivRecCount%>" value="<%=completedFlow%>"><!--added for AAKH-CRF-0024 [IN:038260] ends-->
				</td>
				</tr>
<%
				if(!MfrYN.equals("Y")){//added for AAKH-CRF-0024 [IN:038260]
%>
					<script language='javascript'>
						getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>')
					</script>
<%
				}				
				ivRecCount++;//added for AAKH-CRF-0024 [IN:038260] Ends
			} // end	if(admin_recorded_yn.equals("Y")) on line no. 1827
			else{
					//CRF-413.8
				
				 if(order_line_num.equals("1") && MfrYN!=null && !MfrYN.equals("Y")){
						drug_count = bean.getDrugCount(order_id);
				 }
				iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"N");
				if(ivRecCount==0)
					ivRecCount=1;
				if(order_line_num.equals("1"))
					classvalue="IVFLUID1";
				else
					classvalue="IVINGREDIENT1";
%>
				<tr>
<%              if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
	                 select_status="disabled";
	                 displayStyle = "";	   
	                 sfrFLOW_STATUS_style ="font-size:8;align:center;";
                } // Added for KH-SCF-0010 - End
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
				<td class="<%=classvalue%>" style="<%=drug_class_ind%>" title="<%=prod_name%>">			<input type="hidden" name="iv_modified_date_time_<%=ivRecCount%>" id="iv_modified_date_time_<%=ivRecCount%>" value="<%=modified_date_time%>">	
				<input type="hidden" name="iv_dosage_seq_no_<%=ivRecCount%>" id="iv_dosage_seq_no_<%=ivRecCount%>" value="<%=dosage_seq_no%>">
				<input type="hidden" name="iv_drug_code_<%=ivRecCount%>" id="iv_drug_code_<%=ivRecCount%>" value="<%=drug_code%>">
				<input type="hidden" name="iv_dispense_drug_code_<%=ivRecCount%>" id="iv_dispense_drug_code_<%=ivRecCount%>" value="<%=dispense_drug_code%>">
				<input type="hidden" name="iv_item_code_<%=ivRecCount%>" id="iv_item_code_<%=ivRecCount%>" value="<%=item_code%>">
				<input type="hidden" name="iv_prep_yn<%=ivRecCount%>" id="iv_prep_yn<%=ivRecCount%>"  value="<%=iv_prep_yn%>">
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
					<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=drug_code%>');"></img>
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
							<%if(cancel_recorded_yn.equals("Y") && order_line_num.equals("1")){%>
														<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=drug_desc%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img>
													<%}%>
<%
				if(linkVacScheduleYN.equals("Y")){ 
					if(order_line_num.equals("1")){
%>
						<br> <label id='iv_link_vaccine_label_<%=ivRecCount%>' style="font-size:10;" title='<%=linkVacScheduleDescToolTip%>'> <fmt:message key="ePH.LinkVaccineShcedule.label" bundle="${ph_labels}"/> <input type='text' size=10 name='iv_link_vaccine_desc_<%=ivRecCount%>' id='iv_link_vaccine_desc_<%=ivRecCount%>' value='<%=linkVacScheduleDesc%>' disabled><input type='button'  class='button' value='?' name='iv_btn_link_vaccine_<%=ivRecCount%>' id='iv_btn_link_vaccine_<%=ivRecCount%>' onClick="linkVaccine('iv','<%=ivRecCount%>')"></label>
						<input type='hidden' name="iv_link_vaccine_code_<%=ivRecCount%>" id="iv_link_vaccine_code_<%=ivRecCount%>" value='<%=linkVacScheduleCode%>'>
<%
					}
				}
				if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){
%>
					<br><label style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_drugs%> </label>
					<input type="hidden" name="dispensed_drug_desc_<%=recCount%>" id="dispensed_drug_desc_<%=recCount%>" value="<%=disp_drugs%>">
<%
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
%>												
					<td  class="<%=classvalue%>">
					<input type="text" name="iv_admin_qty_<%=ivRecCount%>" id="iv_admin_qty_<%=ivRecCount%>" size="1" maxlength="4" value="<%=qty%>"  <%=sfrFLOW_STATUS_disable%> class="number" style="<%=displayStyle%>font-size:11;" onKeyPress="return allowValidNumber(this,event,6,3);" onBlur="CheckNum(this);changeDisplay(this,'<%=ivRecCount%>','<%=sch_infusion_per_unit_table_date%>');getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>'); makeDtlsMandatory(this,'<%=ivRecCount%>','<%=drug_code%>','iv','<%=freq_nature%>');">  													
					<input type="hidden" name="iv_qty_uom_<%=ivRecCount%>" id="iv_qty_uom_<%=ivRecCount%>" value="<%=qty_uom%>">
					<input type="hidden" name="h_iv_admin_qty_<%=ivRecCount%>" id="h_iv_admin_qty_<%=ivRecCount%>" value="<%=qty%>">
					<input type="hidden" name="iv_admin_chng_dtls_req_<%=ivRecCount%>" id="iv_admin_chng_dtls_req_<%=ivRecCount%>" value="N">
					<label style="font-size:10;" ><b><%=qty_uom%></b></label>
					</td>
					<td class="<%=classvalue%>" >
<%
					if(freq_nature!=null && freq_nature.equals("C")){
%>
						<label style="<%=hide_ingredient_dtls%>">[<b><%=dosage_seq_no%>/<%=no_of_doses%></b>]</label>
<%
					}
%>
					&nbsp;</td>
<%
				}
				if(order_line_num.equals("1")){ 
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
%>
											<td style='background-color:<%=backGrndColor%>;'><label style="font-size:10;color:<%=fntColor%>;"> <%=route_desc%></label><% if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){%><br><div id="orderctl<%=ivRecCount%>" onClick=""><label style="<%=sfrFLOW_STATUS_style%>"><b><%=sfrFLOW_STATUS_String%><b><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=ivRecCount%>'></label></div><%}%></td>
<%				
					} // Added for KH-SCF-0010 - End
					else{
%>										
					<td style='background-color:<%=backGrndColor%>;'><label style="font-size:10;color:<%=fntColor%>;"> <%=route_desc%></label><% if(!MfrYN.equals("Y") && !(hold.equals("Y")) && !(dis_continued.equals("Y"))){%><br><div id="orderctl<%=ivRecCount%>" onClick="displayToolTipSFR('<%=ivRecCount%>')" onMouseOver="hideToolTip('<%=ivRecCount%>')"><label style="<%=sfrFLOW_STATUS_style%>"><b><%=sfrFLOW_STATUS_String%><b><img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=ivRecCount%>' name='imgArrow<%=ivRecCount%>'></label></div><%}%></td>
<%                  }
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
						<td class="<%=classvalue%>" colspan=6 id="MFR_status_column_<%=ivRecCount%>"><%if(order_line_num.equals("1")){%><label name="iv_MFR_dtls_<%=ivRecCount%>" id="iv_MFR_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openMFRDetails('<%=ivRecCount%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=drug_code%>','<%=Store_locn_code%>','NotAdmin','');"><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label>&nbsp;&nbsp;&nbsp;&nbsp <a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=mfrRemarks%>','Y');" id='mfrRemarksLink_<%=ivRecCount%>'>&nbsp;&nbsp;&nbsp;<font color="red"><b><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></b></font></a><%}%></td>
<%
					} 
					else {
						mfrCompletedStatus=false;
%>
						<td class="<%=classvalue%>" colspan=6 id="MFR_status_column_<%=ivRecCount%>"><%if(order_line_num.equals("1")){%><label name="iv_MFR_dtls_<%=ivRecCount%>" id="iv_MFR_dtls_<%=ivRecCount%>" style="font-size:10;color:black;align:center;" onClick=""><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label><%}%></td>
<%
					}
%>
					<input type="hidden" name="iv_admin_date_time_<%=ivRecCount%>" id="iv_admin_date_time_<%=ivRecCount%>" value="<%=sch_date_time%>">
					<input type="hidden" name="iv_infusion_st_time_<%=ivRecCount%>" id="iv_infusion_st_time_<%=ivRecCount%>" value="<%=sfrACT_START_DATE_TIME%>">
					<input type="hidden" name="iv_flow_rate_<%=ivRecCount%>" id="iv_flow_rate_<%=ivRecCount%>" value="0">													
					<input type="hidden" name="sch_infusion_vol_str_unit_<%=ivRecCount%>" id="sch_infusion_vol_str_unit_<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit%>">
					<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" id="sch_infusion_vol_str_unit_desc<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit_desc%>"> <!-- added for SKR-SCF-0215 [IN:029303] -->
					<input type="hidden" name="sch_infusion_per_unit_<%=ivRecCount%>" id="sch_infusion_per_unit_<%=ivRecCount%>" value="<%=sch_infusion_per_unit_table_date%>">
					<input type="hidden" name="sch_dosage_uom_code_<%=ivRecCount%>" id="sch_dosage_uom_code_<%=ivRecCount%>" value="<%=sch_infusion_vol_str_unit%>"><!-- added for SKR-SCF-1240-->
					<input type="hidden" name="iv_infusion_period_txt<%=ivRecCount%>" id="iv_infusion_period_txt<%=ivRecCount%>" value="">												
					<input type="hidden" name="iv_infusion_period_<%=ivRecCount%>" id="iv_infusion_period_<%=ivRecCount%>" value="<%=sch_infusion_period%>">
					<input type="hidden" name="sch_infusion_period_unit_<%=ivRecCount%>" id="sch_infusion_period_unit_<%=ivRecCount%>" value="<%=sch_infusion_period_unit%>">
					<input type="hidden" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" value="">
					<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="">
					<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="">
					<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="">
					<input type="hidden" name="iv_expiry_date_<%=ivRecCount%>" id="iv_expiry_date_<%=ivRecCount%>" value="">
					<input type="hidden" name="iv_mfrRemarks<%=ivRecCount%>" id="iv_mfrRemarks<%=ivRecCount%>" value="<%=mfrRemarks%>">		
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
<%					}
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
					<input type="hidden" name="sch_dosage_uom_code_<%=ivRecCount%>" id="sch_dosage_uom_code_<%=ivRecCount%>" value="<%=sch_dosage_uom_code%>"><!-- added for SKR-SCF-1240-->
					</td>
					<td  class="<%=classvalue%>">
					<input type="text" name="iv_infusion_period_txt<%=ivRecCount%>" id="iv_infusion_period_txt<%=ivRecCount%>" size="1" maxlength="6" value="" style="font-size:11;" disabled class="number" style="<%=hide_ingredient_dtls%>">
					<label style="font-size:10;" style="<%=hide_ingredient_dtls%>"><b><%=sch_infusion_period_unit_label%><div id="sch_inf_per_<%=ivRecCount%>">&nbsp;</div></b></label>
					<input type="hidden" name="iv_infusion_period_<%=ivRecCount%>" id="iv_infusion_period_<%=ivRecCount%>" value="<%=sch_infusion_period%>">
					<input type="hidden" name="sch_infusion_period_unit_<%=ivRecCount%>" id="sch_infusion_period_unit_<%=ivRecCount%>" value="<%=sch_infusion_period_unit%>">
					</td>
					<td nowrap class="<%=classvalue%>"><!-- Modified for HSA-CRF-0090[IN041241] -->
<%				
					if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){
%>						<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
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
							<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!-- Added for HSA-CRF-0090 -->
							<input type="text" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>" style="font-size:11;" disabled ><input type="button" class="button" value="?" <%=auto_Admin_dis%>  onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=Store_locn_code%>','IV','<%=ivRecCount%>')" id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>" >
							<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=defaultBatch.equals("")?batch_id:defaultBatch%>">
							<input type='hidden' name="IV_Newly_administerderd_<%=ivRecCount%>" id="IV_Newly_administerderd_<%=ivRecCount%>" value='IV_Y'>
							<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
							<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")) //GHL-CRF-0458 //isSiteSpecMARPrint && WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status="disabled";
							if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status="disabled";
								displayStyle = "";
								sfrFLOW_STATUS_style ="font-size:8;align:center;";
							} // Added for KH-SCF-0010 - End
						}
						else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
							expiry_date = (String)iv_batch_ids.get(1);
							trade_id	= (String)iv_batch_ids.get(2);
							trade_name  = (String)iv_batch_ids.get(3);
							//added for GHL-CRF-0458 - start
							ward_ack_yn = (String)iv_batch_ids.get(6)==null?"":(String)iv_batch_ids.get(6);
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))) // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status="disabled";
							if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status="disabled";
								displayStyle = "";	
								sfrFLOW_STATUS_style ="font-size:8;align:center;";
							} // Added for KH-SCF-0010 - End
							//added for GHL-CRF-0458 - end
							auto_Admin_dis="disabled";
							totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
							for(int j=0;j<totQty.size();j=j+4){
								returned_qty = (Float)totQty.get(j+2);
								tot_administered_qty=  (Float)totQty.get(j+3);
								ret_qty=returned_qty-tot_administered_qty;							 
							}
							if(ret_qty<=0){//adding end							
%>								<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
								<input type="text" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="<%=(String)iv_batch_ids.get(0)%>" style="font-size:11;" disabled ><input type="button" class="button" value="?"  onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=store_code%>','IV','<%=ivRecCount%>')" <%=auto_Admin_dis%> disabled id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>">
								<!-- code added for recording batch_id in ph_medn_admin_dtl -->
								<input type="hidden" name="previous_batch_id_<%=ivRecCount%>" id="previous_batch_id_<%=ivRecCount%>" value="<%=(String)iv_batch_ids.get(0)%>">
								<input type="hidden" name="previous_exp_date_<%=ivRecCount%>" id="previous_exp_date_<%=ivRecCount%>" value="<%=defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate%>">
								<input type="hidden" name="previous_trade_id_<%=ivRecCount%>" id="previous_trade_id_<%=ivRecCount%>" value="<%=defaultTradeId.equals("")?trade_id:defaultTradeId%>">
<%
								}
								else{ //added below condition for incident NO:33194
									expiry_date="";
									select_status_1="";
%>									<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
									<input type="text" name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" size="9" maxlength="10" value="" style="font-size:11;" disabled ><input type="button" class="button" value="?"  onClick="calcQuantityInDispensingUOM('IV','<%=ivRecCount%>');callMednBatchSearch('iv_batch_id_<%=ivRecCount%>','iv_expiry_date_<%=ivRecCount%>','iv_trade_name_<%=ivRecCount%>','iv_trade_id_<%=ivRecCount%>','iv_bin_code_<%=ivRecCount%>','<%=drug_code%>','<%=ivRecCount%>','iv_infusion_period_<%=ivRecCount%>','<%=store_code%>','IV','<%=ivRecCount%>')" <%=auto_Admin_dis%> disabled id="iv_batch_id_but_<%=ivRecCount%>" name="iv_batch_id_but_<%=ivRecCount%>">
<%
							}
%>
							
							<input type="hidden" name="iv_barcode_id_<%=ivRecCount%>" id="iv_barcode_id_<%=ivRecCount%>" value="<%=iv_batch_ids.get(5)%>"><!-- CRF-413.8-->
<%						} // end 	else if(iv_batch_ids.size()==4) on line no.2180
						else{
%>							<input type='hidden' name='iv_shared_drug_<%=ivRecCount%>' id='iv_shared_drug_<%=ivRecCount%>' value="N" ><!-- Added for HSA-CRF-0090[IN041241] -->
							<select name="iv_batch_id_<%=ivRecCount%>" id="iv_batch_id_<%=ivRecCount%>" style="font-size:11;" onChange="assignBatchDetails('<%=mode%>','IV',this,'<%=ivRecCount%>')">
							<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
								int mm=1;
							for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
								if (defaultBatch.equals((String)iv_batch_ids.get(kk))){
%>
									<option selected value="<%=(String)iv_batch_ids.get(kk)%>"><%=(String)iv_batch_ids.get(kk)%></option>
									<!-- code added for recording batch_id in ph_medn_admin_dtl -->
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
						for(int kk=0;kk<iv_batch_ids.size();kk=kk+9){ // 7 to 9 for GHL-CRF-0482
							
%>
							<input type="hidden" name="iv_barcode_id_<%=ivRecCount%>_<%=mm%>" id="iv_barcode_id_<%=ivRecCount%>_<%=mm%>" value="<%=(String)iv_batch_ids.get(kk+5)%>">
<%						mm++;//CRF-413.8
						}
						//added for GHL-CRF-0458 - start
						for(int kk=0;kk<iv_batch_ids.size();kk=kk+9){ // 7 to 9 for GHL-CRF-0482
							ward_ack_yn = (String)iv_batch_ids.get(kk+6)==null?"":(String)iv_batch_ids.get(kk+6);
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))){ // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status="disabled";
								break;
							}
							//added for GHL-CRF-0458 - end
							 if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status="disabled";
								displayStyle = "";	
								sfrFLOW_STATUS_style ="font-size:8;align:center;";
								break;
							} // Added for KH-SCF-0010 - End
						}

						} // end else on line no. 2205
%>
					<input type="checkbox" name="barcode_check_<%=order_id%>_<%=ivRecCount%>" id="barcode_check_<%=order_id%>_<%=ivRecCount%>" onclick="openBarcodeSFRWidow('<%=drug_count%>','<%=ivRecCount%>','<%=locale%>','<%=current_date_time%>','<%=order_id%>')"><!-- for CRF-413.8--> 
<%					} // end else on line no.2163												
%>
					</td>												
					<td class="<%=classvalue%>">
					<input type="text" name="iv_expiry_date_<%=ivRecCount%>" id="iv_expiry_date_<%=ivRecCount%>" size="9" maxlength="10" disabled value="<%=expiry_date%>" style="font-size:11;">
					</td>
<%
				} // ending of if MfrYN.equals("Y")
						//added for MMS-KH-CRF-0039 - start
						if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && (iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6"))){
						 ward_ack_yn = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn);
					
						 if(ward_ack_yn==null)
							 ward_ack_yn="";
						
						 if(!ward_ack_yn.equals("A"))
						   select_status="disabled";
						}
						//added for MMS-KH-CRF-0039 - end
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
					<input type="checkbox" name="iv_chk_complete_<%=ivRecCount%>" id="iv_chk_complete_<%=ivRecCount%>" value="E" checked onClick="clearDrgRemarks(this,'<%=ivRecCount%>','<%=drug_code%>','IV')">
					<label name="iv_lbl_dtls_<%=ivRecCount%>" style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="enterRemarks('<%=encode_drug_desc%>','<%=drug_class%>','<%=ivRecCount%>','<%=drug_code%>','<%=mode%>','IV','A','<%=freq_code%>','<%=dosage_seq_no%>','<%=no_of_doses%>','<%= order_id %>','<%=order_line_num%>','<%=encounter_id %>','<%=md_admn_req%>','<%=iv_prep_yn%>',iv_admin_chng_dtls_req_<%=(ivRecCount-Integer.parseInt(order_line_num)+1)%>,'<%=MfrYN%>','<%=sch_date_time%>','<%=sfrACT_START_DATE_TIME%>')"><fmt:message key="ePH.Dtl.label" bundle="${ph_labels}"/></label><!-- <%=sch_date_time%> passed to this method enterRemarks() for SCF-7528 -->
					<img src="../../eCommon/images/mandatory.gif" align="center" id="iv_remarks_mand_id_<%=ivRecCount%>" style="display:visible"></img><!-- made display:visible for IN26641 --23/02/2011-- priya -->
					<img src="../../ePH/images/return.gif" id="nxt_adm_<%=ivRecCount%>" style="display:none">									
<%				}
%>
				&nbsp;<input type="hidden" name="iv_mand_symbol_<%=ivRecCount%>" id="iv_mand_symbol_<%=ivRecCount%>" value="style='display:inline'">
<%
				if(order_line_num.equals("1") && (!MfrYN.equals("Y"))) { 
%>
					<label style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openAuditLogWindow('<%=ivRecCount%>','SFR');"><fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/></label>
<%
				}				
%>
				</td>
				<td>
<% 
				if(order_line_num.equals("1")){		
					if(!WardAckMarRequiredYn.equalsIgnoreCase("Y"))//GHL-CRF-0458 // // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
					select_status=""; //added for IN24023 --12/11/2010-- priya
					if(MfrYN.equals("Y") && !mfrCompletedStatus ){
						select_status="disabled";
					}
					else if(((!MfrYN.equals("Y"))&&(sfrFLOW_STATUS.equals("ST")||sfrFLOW_STATUS.equals("HO")||sfrFLOW_STATUS.equals("RE")))||((hold.equals("Y")) || dis_continued.equals("Y"))){
						select_status="disabled";
					}
					if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
						select_status="disabled";
						displayStyle = "";		
						sfrFLOW_STATUS_style ="font-size:8;align:center;";
					} // Added for KH-SCF-0010 - End
%>
					<input type="checkbox" name="chk_iv_select_<%=ivRecCount%>" id="chk_iv_select_<%=ivRecCount%>" value="E"  onClick="checkIVGroup('<%=ivRecCount%>','<%=iv_no_of_drug_per_order%>',this,'<%=sch_date_time%>')<%=auth_reqd_script%>" <%=select_status%>>
<%
				} 
				else{ 
%>
					<input type="checkbox" name="chk_iv_select_<%=ivRecCount%>" id="chk_iv_select_<%=ivRecCount%>" value="E"  disabled>
<%
				}	
%>
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
				<input type="hidden" name="iv_order_pract_id_<%=ivRecCount%>" id="iv_order_pract_id_<%=ivRecCount%>" value="<%=iv_order_pract_id%>"> <!-- //Added for [IN:040149]-->
				<input type="hidden" name="drug_count_<%=ivRecCount%>" id="drug_count_<%=ivRecCount%>" value="<%=drug_count%>"><!-- CRF-413.8-->
				<input type="hidden" name="iv_batch_ids_<%=ivRecCount%>" id="iv_batch_ids_<%=ivRecCount%>" value="<%=iv_batch_ids.size()%>"><!-- CRF-413.8-->
				<input type="hidden" name="iv_sch_date_time_<%=ivRecCount%>" id="iv_sch_date_time_<%=ivRecCount%>" value="<%=sch_date_time%>"><!-- CRF-413.8-->
				
				</tr>	
				
<%			
				if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))){ //added for GHL-CRF-0458 - start // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
%>					<script>
					if(eval(document.getElementById("orderctl"+'<%=ivRecCount%>'))){
						eval(document.getElementById("orderctl"+'<%=ivRecCount%>')).style.display ="none";
					}
					if(eval(document.getElementById("iv_MFR_dtls_"+'<%=ivRecCount%>')))
					eval(document.getElementById("iv_MFR_dtls_"+'<%=ivRecCount%>')).style.display = "none";
					</script>
<%				} //added for GHL-CRF-0458 - end
				if(!MfrYN.equals("Y")){
%>
					<script language='javascript'>
						getHrsMinStr('TAKE','<%=sch_infusion_period_unit%>','<%=ivRecCount%>')
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
				}
				ivRecCount++;//added for AAKH-CRF-0024 [IN:038260] Ends
			} // end else on line no. 2010
		} // end for(int i=0;i<iv_drug_details.size();i=i+54)
		
%>		
		</table></div>
<%
	} // end if(iv_drug_details.size()>0)
%>
<input type="hidden" name="iv_records_iv" id="iv_records_iv"	value="<%=ivRecCount%>"/>
<script>
document.forms[0].iv_records.value=document.forms[0].iv_records_iv.value;
</script>
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
</body>
</html>

