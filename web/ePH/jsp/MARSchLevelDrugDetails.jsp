<!DOCTYPE html>
<!--
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
03/01/2018	IN066125		Dinesh T	01/02/2017	Ramesh G		EM run on window 10 and IE 11
																	Vaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR
-------------------------------------------------------------------------------------------------------------------------------
07/03/2019 IN067953         Devindra       ?           ?            MMS-KH-CRF-0014 
6/10/2020	IN074154		 Shazana								ML-MMOH-SCF-1621 
22/02/2021	9596		 	Manickavasagam J							ML-MMOH-SCF-1674 
26/04/2021	16605		 	Manickavasagam J							ML-MMOH-SCF-1767 
24/04/2022                  Chandrashekar raju A                    ML-MMOH-SCF-1964
11/05/2023      44335          SREENADH.M        RAMESH.G               NMC-JD-CRF-0186
16/05/2023      45063       SREENADH.M                                  NMC-JD-CRF-0186
15/06/2023      46294       SREENADH.M           RAMESH.G               NMC-JD-CRF-0186 
---------------------------------------------------------------------------------------------------------------------------------------
*/ 

-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,java.lang.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>      
<%-- Mandatory declarations end --%>
<html>
	 <head>
<% 
try{
	System.out.println("==============in==========>MARSchLevelDrugDetails.jsp");
 		request.setCharacterEncoding("UTF-8");
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_class			=	 request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
//		String order_id_test			=	 request.getParameter("order_id");
//		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
		String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		String display_order_by			=	 request.getParameter("display_order_by")==null?"":request.getParameter("display_order_by");	
		String route_admin				=	 request.getParameter("route_admin")==null?"":request.getParameter("route_admin");	
		String admin_route_categ		=	 request.getParameter("admin_route_categ")==null?"":request.getParameter("admin_route_categ");	
		String mar_disc_dose_yn		=	 request.getParameter("mar_disc_dose_yn")==null?"":request.getParameter("mar_disc_dose_yn");	
		String mar_iv_compl_dt_ind	=	 request.getParameter("mar_iv_compl_dt_ind")==null?"":request.getParameter("mar_iv_compl_dt_ind");	
		String Auto_Admin	=    "", recExists="", schKey="";
		String future_date_time		            =	"";    // Added for GHL-CRF-0482 [IN:064955]
		String future_admin          = ""; // Added for GHL-CRF-0482 [IN:064955]
				String cancel_recorded_yn="Y";//ADDED FOR JD-CRF-0200
				String verification_status = "N";//added for MMS-KH-SCF-0056
//		float ret_qty=0;
		int prevSch=0;
//		float returned_qty=0;
//		float tot_administered_qty=0;
//		float disp_qty=0;
//		float ward_return_qty=0;
		boolean allowPRNAdmin= true, prevAllowPRNAdmin=false;;
		DecimalFormat dfTest = new DecimalFormat("0.########");

		if(route_admin.equals("undefined")){
			   route_admin="";
		}
		if(admin_route_categ.equals("undefined")){
			   admin_route_categ="";
		}
		String dob	=	 request.getParameter("dob")==null?"":request.getParameter("dob");//IN066125
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
							FloatHead1 = document.getElementById("nonIVHeader");
							FloatHead1.style.visibility= 'visible';
							FloatHead1.style.position = "relative";	
						}
					}
				}
				else{ // only NON IV Drugs
					FloatHead1 = document.getElementById("nonIVHeader");							
				}
				if (theTop>headTop){
					FloatHead1.style.top = (theTop-headTop)+5 + 'px';								
				}
				else{
					FloatHead1.style.top = '0px';							
				}
			}				
		}

		function saveHeadPos(){
			parTable = document.getElementById("nonIVHeaderDiv");
			if (parTable != null){
				headTop = parTable.offsetTop + 5;
				FloatHead1 = document.getElementById("nonIVHeader");
				FloatHead1.style.position = "relative";
				FloatHead2= document.getElementById("IVHeader");
				if (FloatHead2 != null){						
					onlyiv=false;
				}
			}
			else{					
				parTable = document.getElementById("IVHeaderDiv");
				if (parTable != null){
					//headTop = 3;	
					headTop = parTable.offsetTop + 3;	
					FloatHead2 = document.getElementById("IVHeader");
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<style>
		/*  changes NMC-JD-CRF-0186[44335] */
		TD.hiddenCheck{
			visibility: false;
			pointer-events:none;
			background-color: blue;
			disabled: true;
		}
		TD.visibleCheck{
			visibility: true;
			enabled: true;
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
		<form name="MedicationAdministrationSchLevelDrugDtls" id="MedicationAdministrationSchLevelDrugDtls" >
<% 
			String bean_id_all_stages				= "DispMedicationAllStages" ;
			String bean_name_all_stages				= "ePH.DispMedicationAllStages";
			DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
			bean_all_stages.setLanguageId(locale);
			bean_all_stages.setModuleId("1");
//			ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id_test,patient_id_test,order_line_no_test);	
			String bean_id							= "MedicationAdministrationFTBean";
			String bean_name						= "ePH.MedicationAdministrationFTBean";
			MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
			bean.setLanguageId(locale);
			bean.setCurrentTimeAndAdminWithinHRS();
			bean.clearDrugDetails();
			if(dob==null || dob.equals("")) //added for ARYU-SCF-023
				dob = bean.getPatientDOB(patient_id_test);

			String drug_search_bean_id				= "DrugSearchBean";
			String drug_search_bean_name			= "ePH.DrugSearchBean";
			DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
			drug_bean.setLanguageId(locale);

			String admin_bean_id						=	  "MedicationAdministrationBean";
			String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
			MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
			admin_bean.setLanguageId(locale);
			int admin_within_hrs =  0; // Added for GHL-CRF-0482 - Start
			if(bean.getCurrentTimeAndAdminWithinHRS().size()>2){
				admin_within_hrs = Integer.parseInt(bean.getCurrentTimeAndAdminWithinHRS().get(1).toString()); 
			} // Added for GHL-CRF-0482 - End
			
			ArrayList AdminDateresult						= bean.getCurrentTimeAndAdminWithinHRS();
			String current_date_time				= (String)AdminDateresult.get(0);
			String userAuthPINYN=bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
			//ArrayList result = bean.getCurrentTimeAndAdminWithinHRS();
			String adminFromDateTime		= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
			String adminToTime			= bean.getAdiminWindowToDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
			if(!locale.equals("en")){
				adminFromDateTime = com.ehis.util.DateUtils.convertDate(adminFromDateTime, "DMYHM",locale,"en");
				adminToTime = com.ehis.util.DateUtils.convertDate(adminToTime, "DMYHM",locale,"en");
				from_time = com.ehis.util.DateUtils.convertDate(from_time, "DMY",locale,"en");
				to_time = com.ehis.util.DateUtils.convertDate(to_time, "DMY",locale,"en");
			}

			HashMap	drug_details		  =	(HashMap) bean.getDrugDetailsSchLevel(encounter_id,hold_discontinue_yn,administration_status,order_type, adminFromDateTime, adminToTime,display_order_by,route_admin,admin_route_categ,from_time,to_time);
			ArrayList altDateDayList = admin_bean.getDateDayList(from_time,to_time, "W");
			int daySize=0;
			int dispSizeMms=0;//added for MMS-KH-CRF-0010
			int adr_count =0;
			if(altDateDayList!=null && altDateDayList.size()>0)
				daySize = altDateDayList.size();
			String iv_prep_yn			   =	"";
			String title				   =	"";
			String order_status            ="";//ADDED FOR MMS-KH-SCF-0056
			String patient_id					=   "";
			//int no_of_alt_drus_selected			=   0;	
			LinkedHashMap	hmNonIVDrugDetails				=	(LinkedHashMap) drug_details.get("NON_IV");
			LinkedHashMap hmIVDrugDetails				    =	 (LinkedHashMap) drug_details.get("IV");
			HashMap hmSchList				    =	 (HashMap) drug_details.get("SCHLIST");
			ArrayList	non_iv_drug_details	=null;
			ArrayList	alTmpOrderSchDetail	=null;
//			ArrayList iv_drug_details =null;
			List OrdersList = null;
			Set uniqueSchedules = null;
			String Store_locn_code				=	"";
			String sch_date_time="";
			String Storelocn_code				=	"";
			String drug_code="", drug_desc="", drug_class="", drug_class_ind, freq_desc;
			String  route_desc, pres_catg_code, prn_remarks,medn_admn_dtl_reqd_yn="", slidingscaleremarks, ext_prod_id="", trade_code, imageFileURL, schedule_uom_desc, schedule_uom_code, patient_brgt_medn, sliding_scale_applicable, strength_value, adminsted_pat_brought_medn, dosage_type="", dosage="", dosage_uom_code="", dosage_uom_desc="", content_in_pres_base_uom="", start_date_time="", end_date_time="", end_date="", start_date="";
			String dosage_uom_desc_sch="";//added forML-MMOH-SCF-1463
			String sch_strength_uom, admn_dose_chng_reason_code, onco_direct_drug_count="",  linkVacScheduleCode="", performingDeptLocCode, dose_uom_desc,  verificationremarks="", pres_remarks="", drug_remarks="",pharma_remarks="", show_remarks="", order_pract_id="", route_color="", fntColor="" ,backGrndColor="", sch_strength_value ,sch_strength_uom_desc, store_code="", disp_drug_code  ;
		//verificationremarks, pres_remarks, drug_remarks,pharma_remarks uncommented for mms-kh-crf-0010
    	HashMap overridereason = null;
			String classvalue ="", linkVacScheduleCode1="";
			String[] vacScheduleDetails;
			String order_id="", order_line_num="", dayLegend="", schDate="", dispDate="", schTime = "",dispensed_drug_desc="",disp_drugs="",dispense_drug_code="";
			String administered_yn="", admin_recorded_yn ="", doseDisplay="", non_iv_admin_quaty, displayStyle="", displayFreqStyle="";
			String strength_per_value_pres_uom = "1",qty="", pres_dosage="", fieldname="", dose_uom_desc1="", tempDosage="" , freq_nature="", freq_code="", dosage_seq_no="", 	admin_drug_code	    =  "", admin_drug_desc 	=  "", admindrugdetails;
			String admin_dose_prn="", remarks="", discontinued="", hold="", admin_by_name, auth_by_name,  admin_date_time, modified_date_time="", showAlt="", scheKey ="", schCanAdmin="", admin_rec_disp="", split_dose_yn="", temp="", prn_qty_desc="", prn_admin_date="", callMenu="", prnSrlNo="", stDispHand="", sch_dosage_qty="";//iv_sch_date_tim Added for SKR-SCF-0913[Inc : 46556]
			String admin_uom = "";//BRU-CRF-399.1
			StringBuilder showTitle = new StringBuilder();
			StringTokenizer stadmindrugdetails	=	null;
//			StringTokenizer stiv_incred			=	null;	
			//String pract_id						=	"";	
			String mfrRemarks					=	"";
			String against_sch_date				=	"";
			String adr_reason					=	"";		String adr_remarks					=	"";
			String adr_record_time				=	"";		String adr_recorded_by				=	"";
			String adr_details					=	"";	
			String adminStatus="";
			String encode_drug_desc				=   "";//ADDED FOR MMS-KH-CRF-0010
			encode_drug_desc= drug_desc.replaceAll(" ","%20");
			encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
			encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");
			drug_desc=encode_drug_desc;
//			String next_schd_date				=	"";		String AdUOM						=	"";
			String demostring					=  "\\\'\'";
			String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
			//String nonMfrFluidRemarks			=	"";		
			String linkVacScheduleDesc ="";
      //remarks_style added for mms-kh-crf-0010
			String remarks_style="",/*,  batch_id="", flag="", item_code="", expiry_date ="", AdminBackLogTime="", defaultBatch="", defaultExpiryDate="", defaultTradeId ="", trade_id="" */ ord_hold_date_time="", ord_disc_date_time="", discontinued_sch="", discontinued_dose="", hold_sch="", prev_freq_nature="", prev_end_date="",  prev_order_line_num="", prev_order_id="",prev_dosage_seq_no="", prev_schDate="", prev_schTime="", prev_dosage="", prev_dosage_uom_code="", prev_discontinued_dose="", prev_discontinued_sch="", prev_hold_sch="", prev_displayStyle="", prev_sch_date_time="", prev_hold="", prev_discontinued="";

			int orderCount		 = 0, prev_orderCount =0;
			int recCount = 0;
			int dialog_height = 0;//uncommented for mms-kh-crf-0010
			int rowsPan = 1;
			int schSize = 1;
			int schDayCount =0;
			int dayCount=0;
			int temp1                           =   0;
			int temp2                           =   0;		
			int temp3                           =   0;		
			int ppn_count						=   0;
			String couldAdminReason="";//ADDED FOR MMS-KH-CRF-0010
			String adminReasondDetails="";//ADDED FOR MMS-KH-CRF-0010
//			String prev_key="", curr_key="";
			int sch =0, prn_doseCount=0,  prev_prnSrlNo=0, i_prnSrlNo=1, schCount=0, prevSchCount=0;
			boolean isSite_spec_patient_stock = bean.isSiteSpecific("PH","PATIENT_STOCK_REQUIRED");//ADDED FOR GHL-CRF-0482
			//isSite_spec_patient_stock = true;
			boolean viewAdminRemarks =bean.isSiteSpecific("PH","VIEW_ADMIN_REMARKS");//ADDED FOR MMS-KH-CRF-0010
			String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
			String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
			if(viewAdminRemarks){//Added for MMS-KH-CRF-0010
				dispSizeMms=8;
				}
			else
				dispSizeMms=7;
				
			
			if((hmNonIVDrugDetails.size()==0) &&(hmIVDrugDetails.size()==0)){
%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
				</script>
<%		
				return;
			}
			else{
%>
				<script>
					showHideCriteria('H');
				</script>
<%		
			}
			if(hmNonIVDrugDetails.size()>0){

			    future_date_time   = com.ehis.util.DateUtils.plusDate(current_date_time,"DMYHM",locale,admin_within_hrs,"h").toString();   // Added for GHL-CRF-0482 [IN:064955] - Start				
				
			    if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ 
					future_admin = "";
			    }
			    
			    if(admin_bean.getEarlyOrLateAdminYn().equals("Y") && admin_bean.compareDates(future_date_time,sch_date_time) &&  !(freq_nature.equals("P"))){
					future_admin = "F";
                            } // Added for GHL-CRF-0482 [IN:064955] - End
%>
				<div id="nonIVHeaderDiv" > 
					<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="non_iv_administration_table" >
						<tr id="nonIVHeader">
							<td class="TDSTYLE" width="16%" colspan='2' nowrap>
								<table border="1" cellpadding="0" cellspacing="0"  >
									<tr style='height:14px;'>
										<td class="TDSTYLE" width="16%" colspan='2' nowrap>
											<B><fmt:message key="ePH.OrderDate/Time.label" bundle="${ph_labels}"/></B>
										</td>
									</tr>
									<tr style='height:14px;'>
										<td class="TDSTYLE" width="8%" style='text-align:center;'><B><fmt:message key="Common.Start.label" bundle="${common_labels}"/></B></td>
										<td class="TDSTYLE" width="8%" style='text-align:center;'><B><fmt:message key="Common.End.label" bundle="${common_labels}"/></B></td>
									</tr>
								</table>
							</td>

							<td class="TDSTYLE" width="20%" wrap><B><fmt:message key="ePH.MedicationName.label" bundle="${ph_labels}"/></B></td>
							<%if(viewAdminRemarks){%><!-- added or mms-kh-crf-0010 -->
							
							<td class="TDSTYLE" width="2%" ><B><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></B></td>
							<%} %>
							<td class="TDSTYLE" width="8%" nowrap><B><fmt:message key="Common.Route.label" bundle="${common_labels}"/></B></td>
							<td class="TDSTYLE" width="8%" nowrap><B><fmt:message key="ePH.freq.label" bundle="${ph_labels}"/></B></td>
							<td class="TDSTYLE" width="7%" nowrap><B><fmt:message key="ePH.OrderDosage.label" bundle="${ph_labels}"/></B></td>
							<% //moved from down to up for GHL-CRF-0482
							iv_prep_yn				=    (String)drug_details.get("iv_prep_yn");
							if(iv_prep_yn == null)
							iv_prep_yn =    "";
						
							if(function_from.equals("CP"))
							iv_prep_yn	=	bean.IVType(order_id);

							if(isSite_spec_patient_stock){ %>
							<td class="TDSTYLE" width="2%"><B><fmt:message key="ePH.PatientStock.label" bundle="${ph_labels}"/></B></td>
							<%}
							%>
							<td class="TDSTYLE" width="6%" ><B><fmt:message key="ePH.ScheduleTime.label" bundle="${ph_labels}"/></B></td>
<%
							if(altDateDayList!=null && altDateDayList.size()>0){
								daySize = altDateDayList.size();
								for(int day=0; day<daySize; day+=2){
									dayLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common."+(String)altDateDayList.get(day+1)+".label", "common_labels");
%>
									<td class="TDSTYLE" width="5%">
										<table   border="1" cellpadding="0" cellspacing="0"  >
											<tr style='height:14px;'>
												<td class="TDSTYLE" width="5%"><B><%=com.ehis.util.DateUtils.convertDate(((String)altDateDayList.get(day)),"DMY","en",locale)%></B></td><!-- convertDate Added for SRR - SRR20056-SCF-9369 [IN057079] --> 
											</tr>
											<tr style='height:14px;'>
												<td class="TDSTYLE" width="5%" style='text-align:center;'><B><%=dayLegend%></B></td>
											</tr>
										</table>
									</td>
<%
								}
							}
%>
						</tr>
						<tr>
<%
					if(!order_type.equals("A")){ 
					/*	iv_prep_yn				=    (String)drug_details.get("iv_prep_yn"); //commented moved to up GHL-CRF-0482
						if(iv_prep_yn == null)
							iv_prep_yn =    "";
						if(function_from.equals("CP"))
							iv_prep_yn	=	bean.IVType(order_id); */
						if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
							title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
						else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
							title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
						else
							title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");
%>
						<tr id="nonIVOrderTypeHdr" >
							<td class='COLUMNHEADER' colspan="<%=(daySize/2)+dispSizeMms%>"  style="font-size:10" ><b><%=title%><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
						</tr>
<%	
					}
					OrdersList = new ArrayList(hmNonIVDrugDetails.keySet());
	//added for GHL-CRF-0458 - start
					//boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // commented for MMS-KH-CRF-0014 [IN:067953]
			        String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
			        String verification_req_yn=admin_bean.getverfreqdbefmedAdmin();//added for MMS-KH-SCF-0056
					boolean issitespec_verbal_order_yn = bean.isSiteSpecific("PH","PLACED_VERBAL_ORDER_YN");//ADDED FOR GHL-CRF-0509
					boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
					boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
					String orderID = "";
					String orderLineNum = "";
					String ack_yn = "";
					String patient_class_ord = "";
					String mfr_yn	= "N";//ML-MMOH-CRF-1014
					String statusString = "";//ML-MMOH-CRF-1014
					String placed_from_verbal_order="N";//added for ghl-crf-0509
				//added for GHL-CRF-0482 - start
					String patient_stock_status_str = "";
					String patient_stock_status_str_disp = "";
//					String order_id_for_drug	= "";
					//String order_line_no_for_drug = "";
					String patient_stock_completed="";
					String patient_stock_required = "";
					patient_brgt_medn = "";
					HashMap drugMap = new HashMap();
					HashMap hm_iv_prep = new HashMap();//MMS-KH-CRF-0039
					ArrayList orderList = new ArrayList();
					HashMap hmPatientStockStatusForOrder = new HashMap(); 
					for (int i=0;i<OrdersList.size();i++){
						iv_prep_yn="";//MMS-KH-CRF-0039
						orderID = ((String)OrdersList.get(i)).split("_")[0];
						orderLineNum = ((String)OrdersList.get(i)).split("_")[1];
						alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get((String)OrdersList.get(i));
						for(int j=0; j<alTmpOrderSchDetail.size(); j++){
							patient_stock_status_str = "";
							non_iv_drug_details	   = (ArrayList)alTmpOrderSchDetail.get(j);
							administered_yn        = (String)non_iv_drug_details.get(21);
							admin_recorded_yn      = (String)non_iv_drug_details.get(22);
							patient_brgt_medn      = (String)non_iv_drug_details.get(58);
							disp_drug_code		   = (String)non_iv_drug_details.get(0);
							iv_prep_yn			   = (String)non_iv_drug_details.get(44)==null?"":(String)non_iv_drug_details.get(44);
						
							hm_iv_prep.put(orderID,iv_prep_yn);//MMS-KH-CRF-0039
							if(iv_prep_yn.equals("")){
								if(drugMap!=null ){
								 if(drugMap.containsKey(disp_drug_code)){
									 orderList = (ArrayList)drugMap.get(disp_drug_code);
									if(!orderList.contains(orderID)){
										orderList.add(orderID);
										orderList.add(orderLineNum);
										drugMap.put(disp_drug_code,orderList);
									}
								 }else{
										orderList = new ArrayList();
										orderList.add(orderID);
										orderList.add(orderLineNum);
										drugMap.put(disp_drug_code,orderList);
								 }
								} 
							
								patient_stock_required = (String)non_iv_drug_details.get(93)==null?"N":(String)non_iv_drug_details.get(93);
								patient_stock_completed = (String)non_iv_drug_details.get(94)==null?"N":(String)non_iv_drug_details.get(94);
							}
							if(patient_brgt_medn.equals("Y") || patient_stock_required.equals("N")){
								patient_stock_status_str = "NA";
								break;
							}
							if(administered_yn.equals("N") && patient_stock_completed.equals("N")){
								patient_stock_status_str = "A";
								break;
							}else{
								patient_stock_status_str = "C";
							}
						}
						hmPatientStockStatusForOrder.put(orderID+orderLineNum,patient_stock_status_str);
					}
					bean.setOrderIdListForSameDrug(drugMap); //added for GHL-CRF-0482

//added for GHL-CRF-0482 - end
				//added for GHL-CRF-0458 - end
				for (int i=0;i<OrdersList.size();i++){
					mfr_yn = "N";//ML-MMOH-CRF-1014
					patient_stock_status_str_disp = ""; //added for GHL-CRF-0482
					alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get((String)OrdersList.get(i));
					schSize=1;
					sch =0;
					prn_doseCount=0;
					allowPRNAdmin = true;
					//if(schCount>4)
						//rowsPan = 4;
	
					//added for GHL-CRF-0458 - start
					orderID = ((String)OrdersList.get(i)).split("_")[0];
					orderLineNum = ((String)OrdersList.get(i)).split("_")[1];
					patient_class_ord = bean.getOrderPatientClass(orderID);
						if(patient_class_ord==null)
							patient_class_ord = "";
					if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")){ // isSiteSpecMARPrint changed to WardAckMarRequiredYn for MMS-KH-CRF-0014 [IN:067953]
					   iv_prep_yn = (String)hm_iv_prep.get(orderID)==null?"":(String)hm_iv_prep.get(orderID);//MMS-KH-CRF-0039

						ack_yn	= bean.getAcknowlegeYN(orderID,orderLineNum,iv_prep_yn);
						if(ack_yn==null)
							ack_yn = "";
					}
					//added for GHL-CRF-0458 - end	
					//added for GHL-CRF-0482 - start
					patient_stock_status_str = (String)hmPatientStockStatusForOrder.get(orderID+orderLineNum);
					if(patient_stock_status_str.equals("C"))
						patient_stock_status_str_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.completed.label", "common_labels");
					else if(patient_stock_status_str.equals("A"))
						patient_stock_status_str_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.available.label", "common_labels");
					else
						patient_stock_status_str_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.notapplicable.label", "common_labels");
					//added for GHL-CRF-0482 - end
					for(sch=0; sch<alTmpOrderSchDetail.size(); sch++){
						showAlt="";
						recExists = "Y";
						non_iv_drug_details = (ArrayList)alTmpOrderSchDetail.get(sch);
						drug_code		= (String)non_iv_drug_details.get(28);	
						disp_drug_code		= (String)non_iv_drug_details.get(0);	
						drug_desc		= (String)non_iv_drug_details.get(1);
						encode_drug_desc= drug_desc.replaceAll(" ","%20");
						encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
						encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");
						//drug_desc=encode_drug_desc;
						qty				= (String)non_iv_drug_details.get(2)==null?"0":(String)non_iv_drug_details.get(2);
						dose_uom_desc	= (String)non_iv_drug_details.get(3); 
						order_id	    = (String)non_iv_drug_details.get(13);
						order_line_num  = (String)non_iv_drug_details.get(14);
						order_status=bean.getOrderstatus(order_id,order_line_num);//added for mms-kh-scf-0056	
						sch_date_time   = (String)non_iv_drug_details.get(16);
						dosage_seq_no		= (String)non_iv_drug_details.get(17);
						discontinued		= (String)non_iv_drug_details.get(19);
						hold				= (String)non_iv_drug_details.get(20);
						administered_yn  = (String)non_iv_drug_details.get(21);
						admin_recorded_yn  = (String)non_iv_drug_details.get(22);
						admindrugdetails  = (String)non_iv_drug_details.get(24);
						admin_by_name = (String)non_iv_drug_details.get(25)==null?"":(String)non_iv_drug_details.get(25);
						drug_class	= (String)non_iv_drug_details.get(30);
						auth_by_name  = (String)non_iv_drug_details.get(31)==null?"":(String)non_iv_drug_details.get(31);
						end_date_time	= (String)non_iv_drug_details.get(32);
						freq_code	  = (String)non_iv_drug_details.get(33);
						freq_nature	  = (String)non_iv_drug_details.get(34);
						//prnSrlNo	  = (String)non_iv_drug_details.get(35);
		//System.err.println("==order_id=="+order_id+"==freq_nature===>"+freq_nature);
						prnSrlNo	  = sch+"";
						adr_reason			= (String)non_iv_drug_details.get(38);
						adr_remarks			= (String)non_iv_drug_details.get(39);
						adr_record_time		= (String)non_iv_drug_details.get(40);
						adr_recorded_by		= (String)non_iv_drug_details.get(41);

						pres_dosage			= (String)non_iv_drug_details.get(42);
						iv_prep_yn			= (String)non_iv_drug_details.get(44);
						route_desc			= (String)non_iv_drug_details.get(54);
						pres_catg_code		= (String)non_iv_drug_details.get(55);							
						medn_admn_dtl_reqd_yn	= (String)non_iv_drug_details.get(45);

						prn_remarks			= (String)non_iv_drug_details.get(46);	
						slidingscaleremarks	= (String)non_iv_drug_details.get(47);
						ext_prod_id			= (String)non_iv_drug_details.get(50);
						trade_code			= (String)non_iv_drug_details.get(51);
						imageFileURL		= (String)non_iv_drug_details.get(52);
						schedule_uom_desc	= (String)non_iv_drug_details.get(56);
						schedule_uom_code	= (String)non_iv_drug_details.get(57);
						patient_brgt_medn	= (String)non_iv_drug_details.get(58);
						sliding_scale_applicable	= (String)non_iv_drug_details.get(59);
						strength_value	= (String)non_iv_drug_details.get(60);
						sch_strength_value	=(String)non_iv_drug_details.get(61);
						adminsted_pat_brought_medn	= (String)non_iv_drug_details.get(62);
						dosage_type			= (String)non_iv_drug_details.get(63);
						dosage				= (String)non_iv_drug_details.get(64);
						dosage_uom_code		= (String)non_iv_drug_details.get(65);
						dosage_uom_desc		= (String)non_iv_drug_details.get(66);
						content_in_pres_base_uom= (String)non_iv_drug_details.get(67);
						sch_strength_uom	= (String)non_iv_drug_details.get(68);
						sch_strength_uom_desc	= (String)non_iv_drug_details.get(69);	
						admn_dose_chng_reason_code	=  (String)non_iv_drug_details.get(70);	
						onco_direct_drug_count		= (String)non_iv_drug_details.get(71);
						linkVacScheduleCode			= (String)non_iv_drug_details.get(72);
						performingDeptLocCode		= (String)non_iv_drug_details.get(73);
						start_date_time	= (String)non_iv_drug_details.get(77);
						freq_desc	= (String)non_iv_drug_details.get(78);
						schDate	= (String)non_iv_drug_details.get(79);
						schTime	= (String)non_iv_drug_details.get(80);
						schCanAdmin	= (String)non_iv_drug_details.get(81);
						split_dose_yn	= (String)non_iv_drug_details.get(82);
						ord_hold_date_time	= (String)non_iv_drug_details.get(83);
						ord_disc_date_time	= (String)non_iv_drug_details.get(84);
						sch_dosage_qty	= (String)non_iv_drug_details.get(85);
						dispensed_drug_desc	= (String)non_iv_drug_details.get(86);
						disp_drugs = (String)non_iv_drug_details.get(87);
						dispense_drug_code = (String)non_iv_drug_details.get(88);
						mfr_yn			   = (String)non_iv_drug_details.get(90);//ML-MMOH-CRF-1014
						mfrRemarks			   = (String)non_iv_drug_details.get(91);//ML-MMOH-CRF-1014
						placed_from_verbal_order=(String)non_iv_drug_details.get(92);//added for ghl-crf-0509
						cancel_recorded_yn=(String)non_iv_drug_details.get(96)== null?"N":(String)non_iv_drug_details.get(96);//ADDED FOR JD-CRF-0200
						couldAdminReason=(String)non_iv_drug_details.get(97)== null?"N":(String)non_iv_drug_details.get(97);//ADDED FOR MMS-KH-CRF-0010
						adminReasondDetails=(String)non_iv_drug_details.get(23)== null?"N":(String)non_iv_drug_details.get(23);//ADDED FOR MMS-KH-CRF-0010
						//added for MMS-KH-CRF-0010 start
						verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);
						overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
						pres_remarks			= bean.getPrescriptionInstructions(order_id);
						drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
						pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
						show_remarks		= "N";
						//added for MMS-KH-CRF-0010	 end
						
						System.out.println("590 non_iv_drug_details"+non_iv_drug_details);
						if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ // Added for GHL-CRF-0482 [IN:064955] - Start
							future_admin = "";
					        }
						if(admin_bean.getEarlyOrLateAdminYn().equals("Y") && admin_bean.compareDates(future_date_time,sch_date_time) &&  !(freq_nature.equals("P"))){
							future_admin = "F";
						}
						
						if(dispense_drug_code.equals(""))
							dispense_drug_code = drug_code;
						adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
						if(freq_nature.equals("P") && sch_dosage_qty.equals("0")){
							schCanAdmin = "N";
							allowPRNAdmin = false;
							prevAllowPRNAdmin = false;
						}//added for ML-MMOH-SCF-1964 start
						 if(qty!=null && !qty.equals("") && freq_nature.equals("P")){
							 sch_dosage_qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom))+"";
						}
						//added for MMS-KH-SCF-0182 start
						if(sch_dosage_qty.equals("0")){	
							sch_dosage_qty="0.0";	
						} 
						//added MMS-KH-SCF-0182 end
								int len1= sch_dosage_qty.length();
								if( len1 > 0 ){
									temp = sch_dosage_qty;
									int point= temp.indexOf(".")+1;
									if(temp.charAt(point)=='0')
										sch_dosage_qty = sch_dosage_qty.substring(0,point-1);
									else{//added for SKR-SCF-1429 - start
										if(Float.parseFloat(sch_dosage_qty)>1){ 
										if(temp.charAt(point)=='6' || temp.charAt(point)=='7' || temp.charAt(point)=='8' || temp.charAt(point)=='9'){
											sch_dosage_qty = Math.ceil(Float.parseFloat(sch_dosage_qty))+"";
										}
										}
									} 
								}//added for ML-MMOH-SCF-1964 end
						doseDisplay = "";
						non_iv_admin_quaty="";
						discontinued_dose = "N";
						if(sch_date_time.equals(ord_disc_date_time))
							discontinued_dose="Y";
						tempDosage				=	dosage;
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
						/*if(sliding_scale_applicable.equals("Y") && sliding_scale_details.size()>0){	
							if(sliding_scale_applicable.equals("Y") && batch_ids.size()==0){	
								select_status_1="disabled";
							}
						}
						else{
						*/
						if(admindrugdetails != null){ //if block moved from down to up for AAKH-SCF-0210 [IN:055624]
							stadmindrugdetails = new StringTokenizer(admindrugdetails,":");
							if(stadmindrugdetails.hasMoreTokens()){
								admin_drug_code = stadmindrugdetails.nextToken();
								if(stadmindrugdetails.hasMoreTokens())
									admin_drug_desc = stadmindrugdetails.nextToken();
								if(stadmindrugdetails.hasMoreTokens())
									admin_dose_prn  = stadmindrugdetails.nextToken();	
								if(stadmindrugdetails.hasMoreTokens())
									admin_uom = stadmindrugdetails.nextToken();//admin_uom added for BRU-CRF-399.1
							}
						}
						if(!adr_record_time.equals("") && !adr_reason.equals("")){
							adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
							adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;	
							adminStatus="PAD";
							admin_rec_disp = "display:inline";
						}
						else{
							admin_rec_disp = "display:none";
							adminStatus="";
							adr_details="";
						}
						if(freq_nature.equals("P")){													
							if(administered_yn.equals("Y"))//if block added for AAKH-SCF-0210 [IN:055624]
								qty=admin_dose_prn;
							if(!dosage_seq_no.equals("2")){ //dosage sequence number will start from 2 only, for PRN orders
								dosage=sch_strength_value;
								dosage_uom_code=sch_strength_uom;
								dosage_uom_desc=dosage_uom_desc;// changed from sch_strength_uom_desc_prn to dosage_uom_desc for incident No:32773
							}	
							/*if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){//in case of alternate drug dispense and order by quantity, calculate new dosage- abdul 02/09/10
								ArrayList listArray=bean.getAlternateDrugsEqualQuantity(dosage,drug_code,disp_drug_code);
								if(listArray!=null){
									dosage=(String)listArray.get(0);
									dosage_uom_desc=(String)listArray.get(1);
								}
							}	*/			
							fieldname="non_iv_admin_qty_"+orderCount;
							dose_uom_desc1=dose_uom_desc;
							fieldname   = "non_iv_admin_qty1_"+orderCount;
							dose_uom_desc1 = schedule_uom_desc; 
							pres_dosage = tempDosage;
							if(qty!=null && !qty.equals("") && !administered_yn.equals("Y"))//!administered_yn.equals("Y") added for AAKH-SCF-0210 [IN:055624]
								qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
							int len= qty.length();
							if( len > 0 ){
								temp = qty;
								int point= temp.indexOf(".")+1;
								if(temp.charAt(point)=='0')
									qty = qty.substring(0,point-1);
							}
							if(dosage_type.equals("S"))
								prn_qty_desc = dose_uom_desc;
							else
								prn_qty_desc = dosage_uom_desc;
						}
						else{ 
						/*if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){//in case of alternate drug dispense and order by quantity, calculate new dosage- abdul 02/09/10
								ArrayList listArray = bean.getAlternateDrugsEqualQuantity(qty,drug_code,disp_drug_code);							
								if(listArray!=null){
									qty=(String)listArray.get(0);
									dose_uom_desc=(String)listArray.get(1);
								}
						}*/
						if(qty.equals(""))
							qty = "0";
							if(Float.parseFloat(qty) < 1.0){
								//qty = dfTest.format(Float.parseFloat(qty)); //added for ML-MMOH-SCF-1767
								 if(qty.indexOf(".")!=-1){ //added for ML-MMOH-SCF-1674
										String f_qty = qty.substring(qty.indexOf("."),qty.length());
										if(f_qty.length()>8)
											qty = dfTest.format(Float.parseFloat(qty));
										   
										 qty =Float.parseFloat(qty)+"";
								}
							}									
						}
						if(dosage_type.equals("S")){
							strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
							/*non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty; 
							}	*/
							dosage = pres_dosage;
						}
						else{
							/*non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty;
							}*/
							dosage = pres_dosage;
						}
						try{
							if(Float.parseFloat(dosage) < 1.0)
								dosage = Float.parseFloat(dosage)+"";
						}
						catch(Exception e){
							System.err.println("=====order_id=>"+order_id+" ===order_line_num====>"+order_line_num+"=====>"+dosage_seq_no+"==="+dosage);
							e.printStackTrace();
						}
						//if(admindrugdetails != null){} moved from here to above for AAKH-SCF-0210 [IN:055624] 
						admin_drug_code = "";
						if(administered_yn.equals("Y")){
							dosage_uom_desc_sch = bean.getUomDisplay(facility_id,admin_uom);//BRU-CRF-399.1//dosage_uom_desc canged to dosage_uom_desc_sch  ML-MMOH-SCF-1463
							if(dosage_uom_desc_sch.equals(""))
								dosage_uom_desc_sch = dose_uom_desc;//MMS-KH-SCF-0064
							doseDisplay = qty+" "+dosage_uom_desc_sch+" / ";//dosage_uom_desc canged to dosage_uom_desc_sch forML-MMOH-SCF-1463
						}
						if(remarks==null){
							remarks="Not Entered";
						}
						if(showTitle.length()>0)
							showTitle.setLength(0);
						if(remarks!=null && !remarks.equals(""))
							showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
						/*if(admin_by_name!=null && !admin_by_name.equals(""))
							showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);*/
 
						

						admin_date_time = (String)non_iv_drug_details.get(26);

						if(admin_date_time==null) //null handled for MMS-KH-CRF-0017.1
							admin_date_time="";
						prn_admin_date="";
						if(!admin_date_time.equals("")){
							//if(!locale.equals("en"))
								//admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM",locale,"en");
							prn_admin_date = admin_date_time.substring(0,10);
						}
						modified_date_time = "";
						if(non_iv_drug_details.get(27)!= null){
							modified_date_time = (String)non_iv_drug_details.get(27);
						}
						if(admin_recorded_yn.equals("Y")){//added for MMS-DM-SCF-0453 
							if(administered_yn.equals("N")){
							if(admin_by_name!=null && !admin_by_name.equals(""))
								if(viewAdminRemarks){
								showTitle.append("Reason: "+couldAdminReason+"\n");//ADDED FOR MMS-KH-CRF-0010
							    showTitle.append("Remarks: "+adminReasondDetails+"\n");//ADDED FOR MMS-KH-CRF-0010
								showTitle.append("Could Not Administered By: "+admin_by_name+"\n");
							    showTitle.append("Recorded D/T: "+admin_date_time);//ADDED FOR MMS-KH-CRF-0010
								}
								else
									showTitle.append("Could Not Administered By: "+admin_by_name);
							}
							else{
								if(viewAdminRemarks){//added for MMS-KH-CRF-0010
									
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
									if(auth_by_name!=null && !auth_by_name.equals(""))	
								 showTitle.append("\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								
									showTitle.append("\nRemarks: "+adminReasondDetails+"\n");//ADDED FOR MMS-KH-CRF-0010
								    showTitle.append("Recorded D/T: "+admin_date_time);//ADDED FOR MMS-KH-CRF-0010
								}
								else
								if(admin_by_name!=null && !admin_by_name.equals(""))
							showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
							}
						}else{
						
						if(admin_by_name!=null && !admin_by_name.equals(""))
							{showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
							}
							
						}
						if(auth_by_name!=null && !auth_by_name.equals("") && !viewAdminRemarks){//viewAdminRemarks  added for MMS-KH-CRF-0010
							showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
						}
						
						//verificationremarks	= bean_all_stages.getVerificationRemarks(order_id,order_line_num);
						//overridereason		= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
						//pres_remarks		= bean.getPrescriptionInstructions(order_id);
						//drug_remarks		= bean.getDrugInstructions(order_id,order_line_num);
						//pharma_remarks		= bean.getPharmacistInstructions(order_id,order_line_num);
						show_remarks		= "N";
						order_pract_id  =(String)non_iv_drug_details.get(76); //Added for [IN:040149]
						route_color                 =(String)non_iv_drug_details.get(75);	//Code Added For RUT-CRF-0034 Start
						if(route_color != "" && route_color != null && route_color.length()==12 ){
							fntColor = route_color.substring(0, 6);
							backGrndColor = route_color.substring(6, 12);
						}
						else{
							fntColor = "";
							backGrndColor = "";
						}
						if( !ext_prod_id.equals("")){
							if(overridereason!=null && overridereason.size()>1){
								show_remarks="Y";
							}			
						}
						else{
							if(overridereason!=null && overridereason.size()>0){
								show_remarks="Y";
							}
						}
						//added for MMS-KH-CRF-0010 start
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
						//added for MMS-KH-CRF-0010 end
						strength_value		=	strength_value.trim();
						sch_strength_value	=	sch_strength_value.trim();
						adr_count			= bean.getADRCount(patient_id_test,drug_code); 
						Store_locn_code	= performingDeptLocCode;
						Storelocn_code	= bean.getStoreLocnnCode(nursing_unit);

						if(!Storelocn_code.equals("")){
							non_iv_drug_details.set(29,Storelocn_code);
							store_code		= Storelocn_code;
						}
						verification_status	=	bean.getVerificationStatus(patient_class_ord,facility_id,Store_locn_code,verification_req_yn,WardAckMarRequiredYn);//added for MMS-KH-SCF-0056
						discontinued_sch = "";
						hold_sch="";
						displayFreqStyle = "";
						displayStyle = "";
						if(schCanAdmin.equals("Y")){
							if( !mar_disc_dose_yn.equals("Y") && discontinued.equals("Y") && !sch_date_time.equals(ord_disc_date_time))
								displayStyle = "";
							else
								displayStyle = "COLOR:blue;text-decoration:underline;";
						//added for GHL-CRF-0458
						stDispHand="cursor:pointer;";
						//issitespec_verbal_order_yn and placed_from_verbal_order added for ghl-crf-0509
						//ADDED FOR MMS-KH-SCF-0056
						  if(verification_status.equals("Y") &&(iv_prep_yn.equals("") || iv_prep_yn== null) && (order_status.equals("OS") || order_status.equals("RG")) ){
							displayStyle = "";
							stDispHand = "";
						}  
						if(!iv_prep_yn.equals("8") && WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ack_yn.equals("A") && patient_class_ord.equals("IP") && !patient_brgt_medn.equals("Y") && (!hold.equals("Y") || !discontinued.equals("Y")) ){ // isSiteSpecMARPrint changed to !WardAckMarRequiredYn for MMS-KH-CRF-0014 [IN:067953]	and changed iv_prep_yn.equals("") to !iv_prep_yn.equals("8") for MMS-KH-CRF-0039 						
							
							displayStyle = "";
							stDispHand = "";
							}
							
						}
						if(issitespec_verbal_order_yn && placed_from_verbal_order.equals("Y")){
							displayStyle = "";
							stDispHand = "";
						}
						if(hold.equals("Y") || (!mar_disc_dose_yn.equals("Y") && discontinued.equals("Y")&& !sch_date_time.equals(ord_disc_date_time)))
							stDispHand="";
						if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
							showAlt	 = ("Administered Drug : "+admin_drug_desc+"\n");
							showTitle.insert(0, showAlt);
							displayStyle = "BACKGROUND-COLOR:#CC99CC;COLOR:white;";
						}
						else if(admin_recorded_yn.equals("Y")){
							if(administered_yn.equals("N")){ 
								displayStyle = "BACKGROUND-COLOR:#000000;COLOR:white;";
							}
							else {
								displayStyle = "BACKGROUND-COLOR:green;COLOR:white;";
								if(discontinued.equals("Y") && com.ehis.util.DateUtils.isAfter(adr_record_time, ord_disc_date_time, "DMYHM", locale ))//sch_date_time changed to  adr_record_time for ML-BRU-SCF-1177.1 [IN:049200]
									displayStyle = "BACKGROUND-COLOR:green;COLOR:Red;";
								if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale ))
									displayStyle = "BACKGROUND-COLOR:green;COLOR:yellow;";
							}
						}
						if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
							displayStyle = "";								
							stDispHand = "";
						} // Added for KH-SCF-0010 - End
						if(discontinued.equals("Y")&& com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
							if(admin_recorded_yn.equals("Y") && administered_yn.equals("N"))
								displayStyle = "BACKGROUND-COLOR:#000000;COLOR:red;";
							else if(!admin_recorded_yn.equals("Y"))
								displayStyle = "BACKGROUND-COLOR:red;COLOR:blue;";
							if(sch_date_time.equals(ord_disc_date_time) && mar_disc_dose_yn.equals("Y"))
								stDispHand = "cursor:pointer;";
							else
								stDispHand="";
						}
						else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
							displayStyle = "BACKGROUND-COLOR:yellow;";
							stDispHand="";
						}
						if(discontinued.equals("Y")&& !com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
							discontinued_sch="N";
						}
						if(hold.equals("Y") && !com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
							hold_sch="N";
						}
						if( freq_code.equals("STAT") || freq_nature.equals("O")) {
							displayFreqStyle	=	"BACKGROUND-COLOR:#CE00CE;";
						} 
						if(sch==0){
							uniqueSchedules = null;
							if(hmSchList.containsKey(((String)OrdersList.get(i))+"SCH")){
								uniqueSchedules = (LinkedHashSet <String>)hmSchList.get(((String)OrdersList.get(i))+"SCH");
								schSize = uniqueSchedules.size();
							}
							/*if(schSize>4)
								rowsPan=4;
							else*/
								rowsPan = schSize;
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
									<tr id="nonIVOrderTypeHdr" >
										<td class='COLUMNHEADER'  colspan="<%=(daySize/2)+dispSizeMms%>"  style="font-size:10" ><b><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
									</tr>
<% 
								} 
								else if(temp2==1){ 
%>
									<tr id="nonIVOrderTypeHdr" >
										<td class='COLUMNHEADER'  colspan="<%=(daySize/2)+dispSizeMms%>"  style="font-size:10" ><b><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
									</tr>
<%
								}
								else if(temp3==1){ 
%>
									<tr id="nonIVOrderTypeHdr" >
										<td class='COLUMNHEADER'  colspan="<%=(daySize/2)+dispSizeMms%>"  style="font-size:10" ><b><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/> <fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/></b></td>
									</tr>
<%
								}
							} 
									
							if ((orderCount+1) % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;	
						
							if(drug_class!=null && drug_class.equals("N")){
								drug_class_ind = "background:#66FFFF;";
							}
							else if(drug_class!=null && drug_class.equals("C")){
								drug_class_ind = "background:#CCFFCC;";
							}
							else if(iv_prep_yn.equals("6")){
								drug_class_ind = "background:#E4CAFF;";
							}
							else{
								drug_class_ind = "";
							}
%>
							<tr>
								<input type="hidden" name="non_iv_sliding_scale_<%=orderCount%>" id="non_iv_sliding_scale_<%=orderCount%>" value="<%=sliding_scale_applicable%>">	
								<td class='<%=classvalue%>' width='7%' style="font-size:9;text-align:center;" nowrap rowspan='<%=rowsPan%>'><%=start_date_time%></td>
								<td class='<%=classvalue%>' width='7%' style="font-size:9;text-align:center;" nowrap rowspan='<%=rowsPan%>'><%=end_date_time%></td>
								<td class="<%=classvalue%>" width='19%' style="word-wrap:break-word;font-size:9;<%=drug_class_ind%>"  rowspan='<%=rowsPan%>'>
<%
									if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {
%>
										<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=disp_drug_code%>');" id="drug_mast_det_<%=orderCount%>">&nbsp;+&nbsp;</label>
<%			
									}
%>	
									<label  style="font-size:9;font-weight:bold;color:black"><%=drug_desc%>		
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
										<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=drug_code%>');"></img>
<%
									}
									if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
										<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" onmouseover="changeCursor(this);">
<%						
									}
									if(iv_prep_yn.equals("7")){
										if(ppn_count >0){
%>
											<img src='../../ePH/images/AddedIngredient.gif' width='17' height='15' onclick = "openPPNDisplay('<%=patient_id%>','<%=order_id%>','<%=Store_locn_code%>')" onmouseover="changeCursor(this);">						  
<%										}
									}
									if(linkVacScheduleYN.equals("Y")){ 
										if((!(iv_prep_yn.equals("9")||iv_prep_yn.equals("6")))||(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){
%>
											<br><label id='link_vaccine_label_<%=orderCount%>' style="font-size:10;" title='<%=linkVacScheduleDescToolTip%>'> <fmt:message key="ePH.LinkVaccineShcedule.label" bundle="${ph_labels}"/> <input type='text' size=10 name='link_vaccine_desc_<%=orderCount%>' id='link_vaccine_desc_<%=orderCount%>' value='<%=linkVacScheduleDesc%>' disabled><input type=button  class='button' value='?' name='btn_link_vaccine_<%=orderCount%>' id='btn_link_vaccine_<%=orderCount%>' onClick="linkVaccine('noniv','<%=orderCount%>', 'SCH')"></label>
											<input type='hidden' name="link_vaccine_code_<%=orderCount%>" id="link_vaccine_code_<%=orderCount%>" value='<%=linkVacScheduleCode%>'>
<%
										}
									}
									if(freq_nature.equals("P")){

									/*	if(sch_dosage_qty!=null && !sch_dosage_qty.equals(""))//Adding start for ML-MMOH-SCF-1964
											sch_dosage_qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom));//Adding end for ML-MMOH-SCF-1964*/
%>				
										<br><fmt:message key="ePH.Bal.label" bundle="${ph_labels}"/>&nbsp;<label id='PRN_BAL_QTY_<%=orderCount%>' ><%=sch_dosage_qty%></label>&nbsp;<%=prn_qty_desc%>
<%
										if(!prn_remarks.equals("")){
%>				
											<br><label style='color:blue;'><fmt:message key="Common.PRN.label" bundle="${common_labels}"/>:&nbsp;<%=prn_remarks%></label>
<%
										}
									}
%>
									</label>
<% 									if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){
%>
										<br><label style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_drugs%> </label>
										<input type="hidden" name="dispensed_drug_desc_<%=orderCount%>" id="dispensed_drug_desc_<%=orderCount%>" value="<%=disp_drugs%>">
<%
									}
%>
								</td>
								<!-- added for MMS-KH-CRF-0010 start-->
								<%if(viewAdminRemarks){ %>
								<td   class="<%=classvalue%>" rowspan='<%=rowsPan%>'>
					<img src="../../ePH/images/DrugRemarks.gif" align="center" style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_num%>','<%=dialog_height%>','<%=encode_drug_desc%>','N')" title=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")%> <%=remarks_style%>></img>
				</td>
				<%} %>
					<!-- added for MMS-KH-CRF-0010  end-->
								<td class='<%=classvalue%>' width='7%' style='word-wrap:break-word;' rowspan='<%=rowsPan%>'><label style="color:<%=fntColor%>;background-color:<%=backGrndColor%>;font-size:9;text-align:center;"><%=route_desc%></label></td>
								<td class='<%=classvalue%>' width='7%' style="word-wrap:break-word;font-size:9;text-align:center;<%=displayFreqStyle%>" rowspan='<%=rowsPan%>'><%=freq_desc%></td>
<%
								if(!split_dose_yn.equals("Y")){
%>
									<td class='<%=classvalue%>' width='7%' style="font-size:9;text-align:center;word-wrap:break-word;" rowspan='<%=rowsPan%>'><%=dosage%>&nbsp;<%=dosage_uom_desc%></td>
<%
								}
								//added for GHL-CRF-0482 - start
								patient_stock_status_str = "";
								if(isSite_spec_patient_stock){
%>
								<td class="<%=classvalue%>" width='3%' style="word-wrap:break-word;font-size:9;"  rowspan='<%=rowsPan%>'><%=patient_stock_status_str_disp%></td>
<%								}	//added for GHL-CRF-0482 - end					
							}
							if(uniqueSchedules!=null){
				 				schKey = schTime;
								if(freq_nature.equals("P"))
									schKey = dosage_seq_no;
								if(uniqueSchedules.contains(schKey)){
									uniqueSchedules.remove(schKey);
									prevAllowPRNAdmin = allowPRNAdmin;
									if(sch!=0){
										schDayCount++;
										for(;schDayCount<=(daySize/2); schDayCount++){ //loop to complete the prev dosage row
											dispDate = (String)altDateDayList.get((schDayCount-1)*2);
											if(prev_discontinued.equals("Y"))
												prev_displayStyle = "BACKGROUND-COLOR:red;";
											else if(prev_hold.equals("Y"))
												prev_displayStyle = "BACKGROUND-COLOR:yellow;";
											else
												prev_displayStyle = "";
											if(prev_freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(prev_end_date, dispDate, "DMY", locale) ){
												//dispDate = (String)altDateDayList.get(schDayCount*2);
												prev_sch_date_time = dispDate+" "+schTime;
												end_date = end_date_time.substring(0,10);
												prev_prnSrlNo++;
												//prevSch++;
												scheKey = prev_order_id+"_"+prev_order_line_num+"_"+prevSchCount+"_"+schDayCount;//+"_"+prev_prnSrlNo;
												if(com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && !prev_discontinued.equals("Y") && !prev_hold.equals("Y") && prevAllowPRNAdmin){
													//prevAllowPRNAdmin = false;
%>
													<td class='<%=classvalue%>' width='5%' style="text-align:center;font-size:9;COLOR:blue;text-decoration:underline;word-wrap:break-word;" wrap>
														<div id="order<%=scheKey%>"><label style="<%=stDispHand%>" onClick="dispAdminOptions('<%=scheKey%>','N','N','NONIV','<%=prev_orderCount%>','<%=prevSchCount%>','<%=schDayCount%>','<%=prevSch%>','')"  onMouseOver="hideAdminOptions('<%=scheKey%>')"><u><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></u></label>
														</div>
													</td>
													<input type="hidden" name="dosage_seq_no_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="dosage_seq_no_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_dosage_seq_no%>">
													<input type="hidden" name="SrlNo<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="SrlNo<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_prnSrlNo%>">
													<input type="hidden" name="sch_date_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="sch_date_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=dispDate%>">
													<input type="hidden" name="sch_time_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="sch_time_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_schTime%>">
													<input type="hidden" name="sch_date_time_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="sch_date_time_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_sch_date_time%>">
													<input type="hidden" name="admin_date_time_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="admin_date_time_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="">
													<input type="hidden" name="dosage_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="dosage_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_dosage%>">
													<input type="hidden" name="dosage_uom_code_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="dosage_uom_code_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_dosage_uom_code%>">
													<input type="hidden" name="discontinued_dose_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="discontinued_dose_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_discontinued_dose%>"> 
													<input type="hidden" name="discontiuned_sch_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="discontiuned_sch_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_discontinued_sch%>"> 
													<input type="hidden" name="hold_sch_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="hold_sch_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="<%=prev_hold_sch%>"> 
													<input type="hidden" name="recExists_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="recExists_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="N"> 
													<input type="hidden" name="allowPRN_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" id="allowPRN_<%=prev_orderCount%>_<%=prevSchCount%>_<%=schDayCount%>" value="Y"> 
<%
												}
												else{
%>
													<td class='<%=classvalue%>' width='5%' style="word-wrap:break-word;text-align:center;font-size:9;<%=prev_displayStyle%>" wrap>
														<div id="order<%=scheKey%>" ><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></div>
													</td>
<%
												}
											}
											else{
%>
												<td class='<%=classvalue%>' width='5%'  style="font-size:9;word-wrap:break-word;">&nbsp;</td>
<%
											}
										}
%>
										</tr>
										<tr>
<%
										schDayCount=0;
										dayCount = 0;
										prev_prnSrlNo =0;
										//prevAllowPRNAdmin = false;
									}
									if(freq_nature.equals("P")){
%>
										<td class='<%=classvalue%>' width='5%' style="font-size:9;word-wrap:break-word;" ><fmt:message key="Common.Dose.label" bundle="${common_labels}"/><%=++prn_doseCount%></td>
<%
									}
									else{
										if(split_dose_yn.equals("Y")){
											qty = bean.getSplitDosage(order_id,order_line_num,schTime);//added for ML-MMOH-SCF-1674
%>
											<td class='<%=classvalue%>' width='7%' style="font-size:9;text-align:center;word-wrap:break-word;" ><%=Float.parseFloat(qty)%>&nbsp;<%=dosage_uom_desc%></td><!-- modified for IN074154 -->
<%
										}
%>
										<td class='<%=classvalue%>' width='5%' style="font-size:9;word-wrap:break-word;"><%=schTime%></td>
<%
									}
									schCount++;
								}
								//NMC-JD-CRF-0186[44335]
								// START NMC-JD-CRF-0186[44335]
								String episode_type = "";
								String visit_id = "";
								String classValSelect = "visibleCheck";
								
								ArrayList epVisitResult = bean.getDetails(facility_id, patient_id_test, encounter_id);
								if(epVisitResult.size()!=0){
									episode_type = (String) epVisitResult.get(0);
									visit_id = (String) epVisitResult.get(1);
								}
								boolean mar_unbill_med_blueColor_disable = bean.isSiteSpecific("PH","ALLOW_MAR_DISP_UNBILL_MED");//added for NMC-JD-CRF-0186 US002&03 [45063]	
								String billStatus = bean.getBillStatus(facility_id,patient_id_test,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num)==null?"":bean.getBillStatus(facility_id,patient_id_test,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num);  // "" - episode_id
								String unbilledMedicateYN = bean.getUnbilledMedicateYN(facility_id);
								
								if(billStatus.equals("UNBILLED") && (unbilledMedicateYN.equals("N")
										|| unbilledMedicateYN == "N") && mar_unbill_med_blueColor_disable && administered_yn.equals("N") && (patient_class_ord.equals("OP")||patient_class_ord.equals("EM"))){ //Modified for NMC-JD-CRF-0186 [46294]
									classValSelect = "hiddenCheck";
									displayStyle = "COLOR:white;text-decoration;";
								}
								// END NMC-JD-CRF-0186[44335]				
								for(int day=(dayCount*2); day<daySize; day+=2){
									schDayCount++;
									dayCount++;
									dispDate = (String)altDateDayList.get(day);
									/*if(freq_nature.equals("P")){
										scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+prnSrlNo;
									}
									else*/
										scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount;//+"_"+dosage_seq_no;
									end_date = end_date_time.substring(0,10);
									start_date = start_date_time.substring(0,10);
									schDate	= (String)non_iv_drug_details.get(79);
									if(freq_nature.equals("P") && !com.ehis.util.DateUtils.isBetween(from_time,to_time, schDate, "DMY", locale) && com.ehis.util.DateUtils.isBetween( start_date, end_date, dispDate,"DMY", locale)){ //if block added for SKR-SCF-1001 [IN:048680]
										schDate = dispDate;
										administered_yn = "";
										if(!com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale)){
											schCanAdmin="N";
											stDispHand="";
											displayStyle="";
										}
										else{
											schCanAdmin="Y";
											displayStyle = "COLOR:blue;text-decoration:underline;";
											stDispHand="cursor:pointer;";
											recExists="N";
										}
									}
									else if(freq_nature.equals("P") && com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && !schCanAdmin.equals("Y") && !administered_yn.equals("Y")){
										administered_yn = "";
										schCanAdmin="Y";
										displayStyle = "COLOR:blue;text-decoration:underline;";
										stDispHand="cursor:pointer;";
									}
		//System.err.println("=schDate==>"+schDate+" ===dispDate=>"+dispDate+" freq_nature="+freq_nature+" prn_admin_date="+prn_admin_date+" schDayCount="+schDayCount+" dayCount="+dayCount+" end_date==>"+end_date+" start_date="+start_date);
									if((com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) || (freq_nature.equals("P") && dispDate.equals(prn_admin_date))) && schDayCount ==dayCount){
										if(dispDate.equals(schDate) || (freq_nature.equals("P") && (dispDate.equals(prn_admin_date)))){
											if(!schCanAdmin.equals("Y")){
													if(administered_yn.equals("Y")){
														if(freq_nature.equals("P"))
															callMenu="PRN";
														else 
															callMenu = "NONIV";
														if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start
%>
														<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
															<div id="order<%=scheKey%>" title='<%=showTitle.toString()%>'><label style="vertical-align:middle;cursor:pointer;" onClick=""><%=doseDisplay%><%=schTime%></label>
															<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' onClick="recordADR('<%=encounter_id%>','<%=drug_code%>','1','','<%=sch_date_time%>','<%=order_id%>','<%=order_line_num%>','SCH', '<%=scheKey%>', 'VPAD');" title='<fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
															</div>
														</td>
<%
														} // if Added for KH-SCF-0010 - End
														else{
%>    
														<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
															<!-- //cancelYn,admin_by_name,drug_desc added for JD-CRF-0200 -->
															<div id="order<%=scheKey%>" title='<%=showTitle.toString()%>'><label style="vertical-align:middle;cursor:pointer;" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','<%=callMenu%>','<%=orderCount%>', '<%=schCount%>','<%=schDayCount%>','<%=sch%>','<%=adminStatus%>','','','','','<%=cancelYn%>','<%=admin_by_name%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=qty%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>','<%=iv_prep_yn%>');" onMouseOver="hideAdminOptions('<%=scheKey%>')"><%=doseDisplay%><%=schTime%></label><!--modified for MMS-KH-SCF-0064 -->
															<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' onClick="recordADR('<%=encounter_id%>','<%=drug_code%>','1','','<%=sch_date_time%>','<%=order_id%>','<%=order_line_num%>','SCH', '<%=scheKey%>', 'VPAD');" title='<fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
															</div>
															
				                                          <%if(cancel_recorded_yn.equals("Y")){%>
														<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img> <!--modified for MMS-KH-SCF-0064 -->
													<%}%>
				
														</td>
<%
														}
														}
													else if(freq_nature.equals("P")){
%>
														<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
															<div id="order<%=scheKey%>"><label style='vertical-align:middle;<%=stDispHand%>' ><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></label></div>
														</td>
<%
													}
													else{//changes NMC-JD-CRF-0186 [44335] added classValSelect instead of classvalue
%>
														<td class='<%=classValSelect%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
															<div id="order<%=scheKey%>"><label style='vertical-align:middle;<%=stDispHand%>' >
															<%if(iv_prep_yn.equals("9")){  //added for MMS-KH-CRF-0017.1 start
																if(!order_line_num.equals("2")){%>
															<%=schTime%>
															<%
															}}else{
															%>
															<%=schTime%>
															<%}//added for MMS-KH-CRF-0017.1 end %>
															
															</label>
															<%if(cancel_recorded_yn.equals("Y")){%>
														<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img><!--modified for MMS-KH-SCF-0064 -->
													<%}%>
															</div>
													
														</td>
<%
													}
												}
												else{
													if(freq_nature.equals("P")){
														callMenu="PRN";
													}
													else 
														callMenu = "NONIV";
													if(!mfr_yn.equals("Y")){
														if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start
%>
                                                        <td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
														<div id="order<%=scheKey%>" title='<%=showTitle.toString()%>'>
														<label style="vertical-align:middle;<%=stDispHand%>" onClick="">													
														<%
														} // if Added for KH-SCF-0010 - End
													else{//Srinad changes NMC-JD-CRF-0186[44335] added classValSelect instead of classvalue
 %>
													<td class='<%=classValSelect%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
														<div id="order<%=scheKey%>" title='<%=showTitle.toString()%>'>
														<% //GHL-CRF-0482
														if(stDispHand.equals("")){ %>
														<label style="vertical-align:middle;<%=stDispHand%>" onClick="">
<%														}else{
														%>
														<!-- //cancelYn,admin_by_name,drug_desc added for JD-CRF-0200 -->
														<%if(billStatus.equals("UNBILLED")&& (unbilledMedicateYN.equals("N")
																|| unbilledMedicateYN == "N") && mar_unbill_med_blueColor_disable && administered_yn.equals("N") && (patient_class_ord.equals("OP")||patient_class_ord.equals("EM"))){ %> <!-- NMC-JD-CRF-0186 US002&03[45063] Modified for 46294 -->
														<label style="vertical-align:middle;<%=stDispHand%>" onClick="#" onMouseOver="hideAdminOptions('<%=scheKey%>')"><!--modified for MMS-KH-SCF-0064 -->
														<%}else{%>
														<label style="vertical-align:middle;<%=stDispHand%>" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','<%=callMenu%>','<%=orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=sch%>','<%=adminStatus%>','','','','','<%=cancelYn%>','<%=admin_by_name%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=qty%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>','<%=iv_prep_yn%>');" onMouseOver="hideAdminOptions('<%=scheKey%>')"><!--modified for MMS-KH-SCF-0064 -->
<%                                                      
																} /* NMC-JD-CRF-0186 US002&03 [45063] */
															}
							                            }
														if(freq_nature.equals("P") && !administered_yn.equals("Y")){
															allowPRNAdmin = false;
%>
															<input type="hidden" name="allowPRN_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="allowPRN_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="Y"> 
															<fmt:message key="Common.PRN.label" bundle="${common_labels}"/></label>
<%
														}
														else{
															////ML-MMOH-CRF-1014 - end
//System.err.println("order_line_num=sd==1233=>"+order_line_num+"==iv_prep_yn===>"+iv_prep_yn);
															if(iv_prep_yn.equals("9")){  //added for MMS-KH-CRF-0017.1 -start
																if(!order_line_num.equals("2")){
%>
															<%=doseDisplay%><%=schTime%>
															<%}
															}else{ %>
															<%=doseDisplay%><%=schTime%>
															<%} //added for MMS-KH-CRF-0017.1 end %>
															</label>
<%															
														}
%>
														<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' onClick="recordADR('<%=encounter_id%>','<%=drug_code%>','1','','<%=sch_date_time%>','<%=order_id%>','<%=order_line_num%>','SCH', '<%=scheKey%>', 'VPAD');" title='<fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
														</div>
														<%if(cancel_recorded_yn.equals("Y")){%>
														<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img><!--modified for MMS-KH-SCF-0064 -->
													<%}%>
													</td>
													
<%													}else{ %>
												<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap> <div id="order<%=scheKey%>" title='<%=showTitle.toString()%>'>
<%
															if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014 - start

																ArrayList MfrDetails=bean.getStatusOfMAR(order_id,"SCH");
																String completed_flow = "";
																

																if(MfrDetails.size()>0){
																	statusString=(String)MfrDetails.get(0);
																	completed_flow =(String)MfrDetails.get(1);
												
																}
																if(order_line_num.equals("1")){ %>
																
																<label id="non_iv_MFR_dtls_<%=orderCount%>"  style='vertical-align:middle;COLOR:blue;cursor:pointer;' name="non_iv_MFR_dtls_<%=orderCount%>"  onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','NONIV','<%=orderCount%>','<%=schCount%>','<%=dosage_seq_no%>','<%=sch%>','','<%=dosage_seq_no%>','','<%=mfr_yn%>','<%=completed_flow%>');" ><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/><br><%=statusString%></label><br><a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=mfrRemarks%>','Y');" id='mfrRemarksLink_<%=orderCount%>'><font color="red" size='1'><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></font></a>																
																
<%																}
															
															}	
%>												
												</div>
												<%if(cancel_recorded_yn.equals("Y")){%>
														<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img> <!--modified for MMS-KH-SCF-0064 -->
													<%}%>
												</td>

<%												}
												}
												break;
											}
											else if(freq_nature.equals("P")&&  com.ehis.util.DateUtils.isAfter( dispDate,start_date, "DMY", locale) &&  com.ehis.util.DateUtils.isAfter(end_date, dispDate, "DMY", locale)){
												if(com.ehis.util.DateUtils.isBetween( start_date, end_date, dispDate,"DMY", locale) && com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && prevAllowPRNAdmin){
%>
													<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;COLOR:blue;text-decoration:underline;">
													<div id="order<%=scheKey%>"><label style="<%=stDispHand%>;" onClick="dispAdminOptions('<%=scheKey%>','N','N','NONIV','<%=prev_orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=prevSch%>','')"  onMouseOver="hideAdminOptions('<%=scheKey%>')"><u><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></u></label></td>
													<input type="hidden" name="dosage_seq_no_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_seq_no_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_dosage_seq_no%>">
													<input type="hidden" name="SrlNo<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="SrlNo<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_prnSrlNo%>">
													<input type="hidden" name="sch_date_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_date_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dispDate%>">
													<input type="hidden" name="sch_time_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_time_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_schTime%>">
													<input type="hidden" name="sch_date_time_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_date_time_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_sch_date_time%>">
													<input type="hidden" name="admin_date_time_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="admin_date_time_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="">
													<input type="hidden" name="dosage_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_dosage%>">
													<input type="hidden" name="dosage_uom_code_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_uom_code_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_dosage_uom_code%>">
													<input type="hidden" name="discontinued_dose_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="discontinued_dose_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_discontinued_dose%>"> 
													<input type="hidden" name="discontiuned_sch_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="discontiuned_sch_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_discontinued_sch%>"> 
													<input type="hidden" name="hold_sch_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="hold_sch_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prev_hold_sch%>"> 
													<input type="hidden" name="recExists_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="recExists_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="N"> 
													<input type="hidden" name="allowPRN_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" id="allowPRN_<%=prev_orderCount%>_<%=schCount%>_<%=schDayCount%>" value="Y"> 
<%
													//break;
												}
												else{
%>
													<td class='<%=classvalue%>' width='5%'  style="text-align:center;font-size:9;word-wrap:break-word;">
													<fmt:message key="Common.PRN.label" bundle="${common_labels}"/></td>
<%
												}
											}
											else {
%>
												<td class='<%=classvalue%>' width='5%'  style="text-align:center;font-size:9;word-wrap:break-word;">&nbsp;</td>
<%
											}
										}
										else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){
											end_date = end_date_time.substring(0,10);
											if(freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(end_date, dispDate, "DMY", locale) ){
%>
												<fmt:message key="Common.PRN.label" bundle="${common_labels}"/>
<%
											}
											else{
%>
												<td class='<%=classvalue%>' width='5%'  style="font-size:9;word-wrap:break-word;">&nbsp;</td>
<%
											}
											schDayCount++;
											dayCount++;
										}
										else if(freq_nature.equals("P") && (dispDate.equals(prn_admin_date))){
											if(!schCanAdmin.equals("Y"))
												callMenu = "NONIV";
											else
												callMenu = "PRN";
											if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start
%>
                                                   <td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
												<div id="order<%=scheKey%>"> <label style="<%=stDispHand%>" onClick=""><%=doseDisplay%><%=schTime%></label>
												<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' onClick="recordADR('<%=encounter_id%>','<%=drug_code%>','1','','<%=sch_date_time%>','<%=order_id%>','<%=order_line_num%>','SCH', '<%=scheKey%>', 'VPAD');" title='<fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
												</div>
											</td> 
<%
											} // if Added for KH-SCF-0010 - End
										 else{
%>
											<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
												<div id="order<%=scheKey%>"> <label style="<%=stDispHand%>" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','<%=callMenu%>','<%=orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=sch%>','<%=adminStatus%>');"  onMouseOver="hideAdminOptions('<%=scheKey%>')"><%=doseDisplay%><%=schTime%></label>
												<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' onClick="recordADR('<%=encounter_id%>','<%=drug_code%>','1','','<%=sch_date_time%>','<%=order_id%>','<%=order_line_num%>','SCH', '<%=scheKey%>', 'VPAD');" title='<fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
												</div>
											</td>
<%                                       }
											schDayCount++;
											dayCount++;
										}
										else{
%>
											<td class='<%=classvalue%>' width='5%' >&nbsp;</td>
<%
											dayCount++;
										}
									}
								}
								else{
									dayCount=0;
										for(int day=0; day<daySize; day+=2){
											dispDate = (String)altDateDayList.get(day);
											/*if(freq_nature.equals("P"))
												scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+prnSrlNo;
											else*/
												scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount;//+"_"+dosage_seq_no;
											if(dispDate.equals(schDate)){
												if(!schCanAdmin.equals("Y")){
													if(administered_yn.equals("Y")){
														if(freq_nature.equals("P"))
															callMenu="PRN";
														else 
															callMenu = "NONIV";
%>
														<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
															<div id="order<%=scheKey%>" title='<%=showTitle.toString()%>'> <label style="cursor:pointer;" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','<%=callMenu%>','<%=orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=sch%>','<%=adminStatus%>');" onMouseOver="hideAdminOptions('<%=scheKey%>')"><%=doseDisplay%><%=schTime%></label>
															<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' onClick="recordADR('<%=encounter_id%>','<%=drug_code%>','1','','<%=sch_date_time%>','<%=order_id%>','<%=order_line_num%>','SCH', '<%=scheKey%>', 'VPAD');" title='<fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
															</div>
														</td>
<%
													}
													else{
%>
														<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" >
															<div id="order<%=scheKey%>" ><label style='vertical-align:middle;' ><%=schTime%></label></div>
														</td>
<%
													}
												}
												else{
%>
													<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;<%=displayStyle%>" wrap>
														<div id="order<%=scheKey%>" > <label style="<%=stDispHand%>" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','NONIV','<%=orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=sch%>','<%=adminStatus%>')" onMouseOver="hideAdminOptions('<%=scheKey%>')"><%=doseDisplay%><%=schTime%></label>
														<img SRC="../../ePH/images/stop.gif" title="<%=adr_details%>" id='PADtls<%=scheKey%>' onClick="recordADR('<%=encounter_id%>','<%=drug_code%>','1','','<%=sch_date_time%>','<%=order_id%>','<%=order_line_num%>','SCH', '<%=scheKey%>', 'VPAD');" title='<fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>' style='cursor:pointer;<%=admin_rec_disp%>'></img>
														</div>
													</td>
<%
													schDayCount++;
												}
											}
											else{
%>
												<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;" >&nbsp;</td>
<%
											}
										dayCount++;
									}
%>
									</tr>
<%
								}
								//prnSrlNo = (Integer.parseInt(prnSrlNo)+1) +"";
								prev_freq_nature=freq_nature;
								if(freq_nature.equals("P")){
									prev_end_date=end_date_time.substring(0,10);
									prev_prnSrlNo=Integer.parseInt(prnSrlNo);
									prev_order_line_num=order_line_num;
									prev_order_id=order_id;
									prev_dosage_seq_no = dosage_seq_no;
									prev_schDate = schDate;
									prev_schTime = schTime;
									prev_dosage = dosage;
									prev_dosage_uom_code = dosage_uom_code;
									prev_discontinued_dose = discontinued_dose;
									prev_discontinued_sch = discontinued_sch;
									prev_hold_sch = hold_sch;
									prev_displayStyle = displayStyle;
									prev_discontinued = discontinued;
									prev_hold = hold;
									prev_dosage_seq_no = dosage_seq_no;
									prevSchCount = schCount;
									prevSch = sch+1;
                                 //System.err.println("sch_dosage_qty@@@@==="+sch_dosage_qty);
									/* if(sch_dosage_qty!=null && !sch_dosage_qty.equals("")){//Adding start for ML-MMOH-SCF-1964
											//sch_dosage_qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom));//Adding end for ML-MMOH-SCF-1964											
										//	sch_dosage_qty = Math.ceil(Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom))+"";
									}
						 */		%>						
									<script>
										eval('document.getElementById("PRN_BAL_QTY_")<%=orderCount%>').innerText='<%=sch_dosage_qty%>';
									</script>
<%
								}
%>
								<input type="hidden" name="dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dosage_seq_no%>"><!--sch===>schDayCount -->
								<input type="hidden" name="SrlNo<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="SrlNo<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prnSrlNo%>">
								<input type="hidden" name="sch_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=schDate%>">
								<input type="hidden" name="sch_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=schTime%>">
								<input type="hidden" name="sch_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=sch_date_time%>">
								<input type="hidden" name="admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=admin_date_time%>">
								<input type="hidden" name="dosage_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dosage%>">
								<input type="hidden" name="dosage_uom_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_uom_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dosage_uom_code%>">
								<input type="hidden" name="discontinued_dose_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="discontinued_dose_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=discontinued_dose%>"> 
								<input type="hidden" name="discontiuned_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="discontiuned_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=discontinued_sch%>"> 
								<input type="hidden" name="hold_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="hold_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=hold_sch%>"> 
								<input type="hidden" name="recExists_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="recExists_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=recExists%>"> 
								<input type="hidden" name="sch_dosage_qty<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_dosage_qty<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=sch_dosage_qty%>">
								<input type="hidden" name="future_admin_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="future_admin_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=future_admin%>"> <!-- future_admin  Added for GHL-CRF-0482 --> 
<%
								recCount++;
								prev_orderCount  = orderCount;
								recExists = "N";
							}
							i_prnSrlNo = sch-1;
							for(schDayCount++;schDayCount<=(daySize/2); schDayCount++){
								dispDate = (String)altDateDayList.get((schDayCount-1)*2);
								sch_date_time = dispDate+" "+schTime;
								end_date = end_date_time.substring(0,10);
								if(discontinued.equals("Y"))
									displayStyle = "BACKGROUND-COLOR:red;";
								else if(prev_hold.equals("Y"))
									displayStyle = "BACKGROUND-COLOR:yellow;";
								else
									displayStyle = "";
								if(freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(end_date, dispDate, "DMY", locale)){
									i_prnSrlNo++;
									scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount;//+"_"+prev_prnSrlNo;
									if(com.ehis.util.DateUtils.isBetween(adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && prevAllowPRNAdmin){
										//prevAllowPRNAdmin = false;
%>
										<td class='<%=classvalue%>' width='5%' style="text-align:center;font-size:9;COLOR:blue;text-decoration:underline;word-wrap:break-word;<%=displayStyle%>" >
											<div id="order<%=scheKey%>"><label style="<%=stDispHand%>" onClick="dispAdminOptions('<%=scheKey%>','N','N','NONIV','<%=orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=prevSch%>','')"  onMouseOver="hideAdminOptions('<%=scheKey%>')"><u><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></u></label>
											</div>
										</td>
										<input type="hidden" name="dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dosage_seq_no%>"><!-- i_prnSrlNo schDayCount-->
										<input type="hidden" name="SrlNo<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="SrlNo<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=prnSrlNo%>">
										<input type="hidden" name="sch_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dispDate%>">
										<input type="hidden" name="sch_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=schTime%>">
										<input type="hidden" name="sch_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="sch_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=sch_date_time%>">
										<input type="hidden" name="admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="">
										<input type="hidden" name="dosage_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dosage%>">
										<input type="hidden" name="dosage_uom_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="dosage_uom_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=dosage_uom_code%>">
										<input type="hidden" name="discontinued_dose_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="discontinued_dose_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=discontinued_dose%>"> 
										<input type="hidden" name="discontiuned_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="discontiuned_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=discontinued_sch%>"> 
										<input type="hidden" name="hold_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="hold_sch_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="<%=hold_sch%>"> 
										<input type="hidden" name="recExists_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="recExists_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="N"> 
										<input type="hidden" name="allowPRN_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" id="allowPRN_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>" value="Y"> 
<%
									}
									else{
%>
										<td class='<%=classvalue%>' width='5%' style="word-wrap:break-word;text-align:center;font-size:9;" >
											<div id="order<%=scheKey%>" ><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></div>
										</td>
<%
									}
								}
								else{
%>
									<td class='<%=classvalue%>' width='5%' style="font-size:9;" >&nbsp;</td>
<%
								}
							}
%>
							<input type="hidden" name="non_iv_drug_code_<%=orderCount%>" id="non_iv_drug_code_<%=orderCount%>" value="<%=drug_code%>">
							<input type="hidden" name="non_iv_dispense_drug_code_<%=recCount%>" id="non_iv_dispense_drug_code_<%=recCount%>" value="<%=dispense_drug_code%>">
							<input type="hidden" name="non_iv_drug_desc_<%=orderCount%>" id="non_iv_drug_desc_<%=orderCount%>" value="<%=drug_desc%>">
							<input type="hidden" name="non_iv_order_id_<%=orderCount%>" id="non_iv_order_id_<%=orderCount%>" value="<%=order_id%>">
							<input type="hidden" name="non_iv_order_line_no_<%=orderCount%>" id="non_iv_order_line_no_<%=orderCount%>" value="<%=order_line_num%>">
							<input type="hidden" name="non_iv_store_code_<%=orderCount%>" id="non_iv_store_code_<%=orderCount%>" value="<%=store_code%>">
							<input type="hidden" name="non_iv_end_date_<%=orderCount%>" id="non_iv_end_date_<%=orderCount%>" value="<%=end_date_time%>">		
							<input type="hidden" name="non_iv_drug_class<%=orderCount%>" id="non_iv_drug_class<%=orderCount%>" value="<%=drug_class%>">
							<input type="hidden" name="non_iv_dtls_yn<%=orderCount%>" id="non_iv_dtls_yn<%=orderCount%>" value="N">							
							<input type="hidden" name="freq_code<%=orderCount%>" id="freq_code<%=orderCount%>" value="<%=freq_code%>">	
							<input type="hidden" name="iv_prep_yn<%=orderCount%>" id="iv_prep_yn<%=orderCount%>" value="<%=iv_prep_yn%>">
							<input type="hidden" name="non_iv_dosage_type_<%=orderCount%>" id="non_iv_dosage_type_<%=orderCount%>" value="<%=dosage_type%>">
							<input type="hidden" name="onco_direct_drug_count_<%=orderCount%>" id="onco_direct_drug_count_<%=orderCount%>" value="<%=onco_direct_drug_count%>">
							<input type="hidden" name="onco_iv_prep_yn_<%=orderCount%>" id="onco_iv_prep_yn_<%=orderCount%>" value="<%=iv_prep_yn%>"><!--added for MMS-KH-CRF-0017.1 -->
							<input type="hidden" name="non_iv_qty_in_disp_mode_<%=orderCount%>" id="non_iv_qty_in_disp_mode_<%=orderCount%>" value="">										
							<input type="hidden" name="Remarks<%=orderCount%>" id="Remarks<%=orderCount%>" value="N">					
							<input type="hidden" name="non_iv_Auto_Admin_<%=orderCount%>" id="non_iv_Auto_Admin_<%=orderCount%>" value="<%=Auto_Admin%>">
							<input type="hidden" name="order_pract_id_<%=orderCount%>" id="order_pract_id_<%=orderCount%>" value="<%=order_pract_id%>"> 
							<input type="hidden" name="discontinued<%=orderCount%>" id="discontinued<%=orderCount%>" value="<%=discontinued%>"> 
							<input type="hidden" name="ord_disc_date_time<%=orderCount%>" id="ord_disc_date_time<%=orderCount%>" value="<%=ord_disc_date_time%>"> 
							<input type="hidden" name="hold<%=orderCount%>" id="hold<%=orderCount%>" value="<%=hold%>"> 
							<input type="hidden" name="freq_nature_<%=orderCount%>" id="freq_nature_<%=orderCount%>" value="<%=freq_nature%>"> 
							<input type="hidden" name="maxdosecount_<%=orderCount%>" id="maxdosecount_<%=orderCount%>" value="<%=schCount%>">
							<input type="hidden" name="MfrYN<%=orderCount%>" id="MfrYN<%=orderCount%>" value="<%=mfr_yn%>"><!--ML-MMOH-CRF-1014 -->
							<input type="hidden" name="placed_from_verbal_order<%=orderCount%>" id="placed_from_verbal_order<%=orderCount%>" value="<%=placed_from_verbal_order%>"><!--added FOR GHL-CRF-509 -->
							
							
						</tr>
<%
						schDayCount=0;
						dayCount = 0;
						orderCount++;
					}
%>	
					</table>
				</div>
				<br>
<%
			} 
%>
				<jsp:include page="MARSchLevelDrugDetailsIV.jsp"> 
				<jsp:param name="recCount" value="<%=String.valueOf(recCount)%>" />  
				</jsp:include>
				<input type="hidden" name="mar_disc_dose_yn" id="mar_disc_dose_yn"	value="<%=mar_disc_dose_yn%>">
				<input type="hidden" name="mar_iv_compl_dt_ind" id="mar_iv_compl_dt_ind"	value="<%=mar_iv_compl_dt_ind%>">
				<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
				<input type="hidden" name="patient_class" id="patient_class"	value="<%=patient_class%>">
				<input type="hidden" name="patient_id" id="patient_id"			value="<%=patient_id_test%>">
				<input type="hidden" name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
				<input type="hidden" name="patient_id_selected" id="patient_id_selected" value="<%=patient_id%>">
				<input type="hidden" name="current_date_time" id="current_date_time"	value="<%=current_date_time%>">
				<input type="hidden" name="admin_due_date" id="admin_due_date"		value="<%=admin_due_date%>">
				<input type="hidden" name="assign_bed_num" id="assign_bed_num"		value="<%=assign_bed_num%>">
				<input type="hidden" name="nursing_unit" id="nursing_unit"		value="<%=nursing_unit%>">
				<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
				<input type="hidden" name="mode" id="mode"				value="<%=CommonRepository.getCommonKeyValue( "MODE_INSERT" )%>">	
				<input type="hidden" name="non_iv_records" id="non_iv_records"		value="<%=orderCount%>">
				<input type="hidden" name="func_mode" id="func_mode"			value="<%=mode%>">
				<input type="hidden" name="hold_discontinue_yn" id="hold_discontinue_yn" value="<%=hold_discontinue_yn%>">
				<input type="hidden" name="administration_status" id="administration_status" value="<%=administration_status%>">
				<input type="hidden" name="adr_recorded" id="adr_recorded"		value="N">
				<input type="hidden" name="admin_recorded" id="admin_recorded"		value="N">
				<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
				<input type="hidden" name="from_time" id="from_time"			value="<%=from_time%>">
				<input type="hidden" name="to_time" id="to_time"			value="<%=to_time%>">
				<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"			value="<%=userAuthPINYN%>">
				<input type="hidden" name="adminFromDateTime" id="adminFromDateTime"			value="<%=adminFromDateTime%>">
				<input type="hidden" name="adminToTime" id="adminToTime"			value="<%=adminToTime%>">
				<input type="hidden" name="dob" id="dob"			value="<%=dob%>"><!--IN066125-->
			</form>
		</body>
		<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:10%;visibility:hidden;" bgcolor="blue">
			<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="100%" height="100%" align="center">
				<tr><td id="tooltiptd"></td></tr>
			</table>
		</div>
	</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_all_stages,bean_all_stages,request);
	putObjectInBean(drug_search_bean_id,drug_bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>

