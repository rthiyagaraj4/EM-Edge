<!DOCTYPE html>
<%-- JSP Page specific attributes start 

/*
--------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	   Name		   Rev.Date   	 Rev.By 	   Description
07/03/2019    IN067953         Devindra       ?           ?            MMS-KH-CRF-0014 
24/2/2020	  IN072298			Shazana		24/2/2020	Manickam	   SKR-SCF-1313
10/07/2020      IN073378            Haribabu                                             MMS-DM-SCF-0705
9/10/2021		IN074154		Shazana									ML-MMOH-SCF-1621						
31/01/2021		TFS:12662	        Manickavasagam J			     MMS-KH-CRF-0039
-----------------------------------------------------------------------------------------------------------------------------
*/
--%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,java.lang.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>  
<html>  
	 <head>
<% 
	try{
 		request.setCharacterEncoding("UTF-8");
 		//Added  for COMMON-ICN-0182 on 17-10-2023
 		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
 		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
 		//ends
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_class			=	 request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id_test			=	 request.getParameter("order_id");
		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		//String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		//String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		//String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		//String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
	//	String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
//		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");  
//		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		String mar_disc_dose_yn		=	 request.getParameter("mar_disc_dose_yn")==null?"":request.getParameter("mar_disc_dose_yn");	
%>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<% 
	String bean_id_all_stages				= "DispMedicationAllStages" ;
	String bean_name_all_stages				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
	ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id_test,patient_id_test,order_line_no_test);	
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	//String drug_search_bean_id				= "DrugSearchBean";
	//String drug_search_bean_name			= "ePH.DrugSearchBean";
	//DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);

	String admin_bean_id						=	  "MedicationAdministrationBean";
	String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
	
	ArrayList AdminDateresult						= bean.getCurrentTimeAndAdminWithinHRS();
	String current_date_time				= (String)AdminDateresult.get(0);
	String userAuthPINYN=bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
	ArrayList result = bean.getCurrentTimeAndAdminWithinHRS();
	String adminFromDateTime		= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
	String adminToTime			= bean.getAdiminWindowToDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
	if(!locale.equals("en")){
		adminFromDateTime = com.ehis.util.DateUtils.convertDate(adminFromDateTime, "DMYHM",locale,"en");
		adminToTime = com.ehis.util.DateUtils.convertDate(adminToTime, "DMYHM",locale,"en");
		from_time = com.ehis.util.DateUtils.convertDate(from_time, "DMY",locale,"en");
		to_time = com.ehis.util.DateUtils.convertDate(to_time, "DMY",locale,"en");
	}
	HashMap	drug_details		  =	(HashMap) bean.getDrugDetails();
	ArrayList altDateDayList = admin_bean.getDateDayList(from_time,to_time, "W");
	int daySize=0;
	int dispSizeMms=0;//ADDED FOR MMS-KH-CRF-0010
	int adr_count =0;
	if(altDateDayList!=null && altDateDayList.size()>0)
		daySize = altDateDayList.size();
	String iv_prep_yn			   =	"";
	String title				   =	"";
	String patient_id					=   "";

//	LinkedHashMap	hmNonIVDrugDetails				=	(LinkedHashMap) drug_details.get("NON_IV");
	LinkedHashMap hmIVDrugDetails				    =	 (LinkedHashMap) drug_details.get("IV");
	HashMap hmSchList				    =	 (HashMap) drug_details.get("SCHLIST");
	ArrayList	alTmpOrderSchDetail	=null;
	ArrayList iv_drug_details =null;
	List OrdersList = null;
	Set uniqueSchedules = null;
	String Store_locn_code				=	"";
	String sch_date_time="";
	String drug_code="", drug_desc="", drug_class="", drug_class_ind, freq_desc;
	String  route_desc, pres_catg_code, prn_remarks,slidingscaleremarks, ext_prod_id="", trade_code, imageFileURL,    dosage_type="", dosage="",  start_date_time="", end_date_time="", end_date="", start_date="";
	String     linkVacScheduleCode="", performingDeptLocCode, dose_uom_desc,  verificationremarks, pres_remarks, drug_remarks,pharma_remarks, show_remarks="", order_pract_id="", route_color="", fntColor="" ,backGrndColor="" , store_code="";
	HashMap overridereason = null;
	String classvalue ="", linkVacScheduleCode1="";
	String[] vacScheduleDetails;
	String order_id="", order_line_num="", dayLegend="", schDate="", dispDate="", schTime = "";
	String administered_yn="", admin_recorded_yn ="",   displayStyle="";
	String strength_per_value_pres_uom = "1",qty="",  freq_nature="", freq_code="", dosage_seq_no="", 			admin_drug_code	    =  "";
	String remarks="", discontinued="", hold="", admin_by_name, auth_by_name,  admin_date_time, modified_date_time="", stat_style="", showAlt="", scheKey ="", schCanAdmin="", admin_rec_disp="", split_dose_yn="", temp="",   stDispHand="", iv_sch_date_tim;//iv_sch_date_tim Added for SKR-SCF-0913[Inc : 46556]
	StringBuilder showTitle = new StringBuilder();
	String pract_id						=	"";		String against_sch_date				=	"";
	String adr_reason					=	"";		String adr_remarks					=	"";
	String adr_record_time				=	"";		String adr_recorded_by				=	"";
	String adr_details					=	"";	
	String adminStatus="";
	String encode_drug_desc				=   "";
	String next_schd_date				=	"";		String AdUOM						=	"";
	String demostring					=  "\\\'\'";
	String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
	String nonMfrFluidRemarks			=	"";		String linkVacScheduleDesc ="";
	String remarks_style="",  batch_id="", flag="", item_code="", expiry_date ="", trade_id="" ,ord_hold_date_time="", ord_disc_date_time="";

	int orderCount		 = 0;
	int dialog_height = 0;
	int rowsPan = 1;
	int schSize = 1;
	int schDayCount =0;
	int dayCount=0;
	int temp1                           =   0;
	int temp2                           =   0;		
	int temp3                           =   0;		
	int ppn_count						=   0;
	String prev_key="", curr_key="";
	String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
	String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
	int sch =0, prn_doseCount=0,  prev_prnSrlNo=0, i_prnSrlNo=1, schCount=0, prevSchCount=0;
	boolean viewAdminRemarks = bean.isSiteSpecific("PH","VIEW_ADMIN_REMARKS");//ADDED FOR MMS-KH-CRF-0010
	if(hmIVDrugDetails.size()>0){	
		String dispensed_drug_desc="", disp_drugs="", dispense_drug_code="";
%>	
		<img id="ball" src="/images/ball.png" style="visibility:hidden;" height="5"/>
		<div id="IVHeaderDiv" >  
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="iv_administration_table" >
				<tr id="IVHeader" >
					<td class="TDSTYLE" width="16%" colspan='2' nowrap>
						<table border="1" cellpadding="0" cellspacing="0"  >
							<tr style='height:18px;'>
								<td class="TDSTYLE" width="16%" colspan='2' nowrap>
									<B><fmt:message key="ePH.OrderDate/Time.label" bundle="${ph_labels}"/></B>
								</td>
							</tr>
							<tr style='height:18px;'>
								<td class="TDSTYLE" width="8%" style='text-align:center;'><B><fmt:message key="Common.Start.label" bundle="${common_labels}"/></B></td>
								<td class="TDSTYLE" width="8%" style='text-align:center;'><B><fmt:message key="Common.End.label" bundle="${common_labels}"/></B></td>
							</tr>
						</table>
					</td>
					<td class="TDSTYLE" width="20%" ><B><fmt:message key="ePH.MedicationName.label" bundle="${ph_labels}"/></B></td>
					<%if(viewAdminRemarks){ %>
					<td class="TDSTYLE" width="8%" nowrap><B><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></B></td>
					<%} %>
					<td class="TDSTYLE" width="8%" wrap><B><fmt:message key="ePH.AdminDose.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></B></td>
					<td class="TDSTYLE" width="8%" nowrap><B><fmt:message key="Common.Route.label" bundle="${common_labels}"/></B></td>
					<td class="TDSTYLE" width="7%" nowrap><B><fmt:message key="ePH.freq.label" bundle="${ph_labels}"/></B></td>
					<td class="TDSTYLE" width="6%" ><B><fmt:message key="ePH.ScheduleTime.label" bundle="${ph_labels}"/></B></td>
<%
					if(altDateDayList!=null && altDateDayList.size()>0){
						daySize = altDateDayList.size();
						for(int day=0; day<daySize; day+=2){
							dayLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common."+(String)altDateDayList.get(day+1)+".label", "common_labels");
%>
							<td class="TDSTYLE" width="5%">
								<table border="1" cellpadding="0" cellspacing="0"  >
									<tr style='height:18px;'>
										<td class="TDSTYLE" width="5%"><B><%=com.ehis.util.DateUtils.convertDate(((String)altDateDayList.get(day)),"DMY","en",locale)%></B></td> <!-- convertDate Added for SRR - SRR20056-SCF-9369 [IN057079] -->
									</tr>
									<tr style='height:18px;'>
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
				<%if(viewAdminRemarks){//Added for MMS-KH-CRF-0010
					dispSizeMms=8;
					}
				else
					dispSizeMms=7;
					%>
				
					<td class='COLUMNHEADER' colspan="<%=(daySize/2)+dispSizeMms%>"  style="font-size:10"><b><fmt:message key="ePH.IVAdministration.label" bundle="${ph_labels}"/></b></td>
				</tr>
<% 
		String sfrFLOW_STATUS_String="";
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
		dosage_seq_no			        =   "";
		String hide_ingredient_dtls		=   "";
		iv_prep_yn						=	"";
		String prod_name				=	"";
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
		String iv_order_pract_id        =""; 
		String pin_value="", statusString="";		
		boolean auth_reqd					=   false;
		String auth_reqd_script				=	"", IVclassvalue="";
		dosage_type				=	"";
		boolean mfrCompletedStatus		=	false;
		ArrayList ivSchDisplay			=	null;
		ArrayList MfrDetails			=	null;
		ArrayList work_sheet_batch_det	=   new ArrayList();
		int ivRowCount = 0;
		boolean ivnextRow = false, nextDaySch=false;
		String ordKey ="", iv_Auto_Admin="";
		HashMap hmIVDrugFluidDtls=null;
		ArrayList alIVPBDrugSchList = null;
		OrdersList = new ArrayList(hmIVDrugDetails.keySet());
		int fluidRowspan=1, drugRowspan=1, freqRowspan=1, schRowspan=1, max_dasage_seq_no=1 ;
		String ivPB_drug_code = "", ivPB_trade_code="", ivPB_drug_desc ="", ivPB_sch_infusion_rate="", ivPB_sch_infusion_vol_str_unit_desc="", ivPB_sch_infusion_per_unit="", 
		ivPB_qty="", ivPB_qty_uom="", ivPB_imageFileURL="",  ivPB_ext_prod_id="", ivPB_encode_drug_desc="", ivSchDisp="", ivSchDispStatus="";
		ArrayList alTmpIVPBDrugDtls = null;
		int no_of_doses = 1, drugIndex=0, drugCount=0;
		String MFRCount = "";
		String ack_yn = "";//GHL-CRF-0458
		String displayStyle_1 = "";//GHL-CRF-0458
		String patient_class_ord = "";//GHL-CRF-0458
		//boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // commented for MMS-KH-CRF-0014 [IN:067953]
		String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
		boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
		boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
		String cancel_recorded_yn="N";//ADDED FOR JD-CRF-0200
				String cancel_recorded_yn_3="N";//ADDED FOR JD-CRF-0200
		for (int i=0;i<OrdersList.size();i++){
			ordKey = (String)OrdersList.get(i);
			iv_prep_yn = ordKey.substring(ordKey.indexOf("_")+1,ordKey.length());
			schSize=1;
			sch =0;
			schRowspan=1;
			rowsPan=1;
			drugRowspan=0;
			fluidRowspan=1;
			freqRowspan=1;
			ivRowCount =0;
			schCount=0;
			alIVPBDrugSchList = null;
			if(hmSchList.containsKey(((String)OrdersList.get(i))+"SCH")){
				uniqueSchedules = (LinkedHashSet <String>)hmSchList.get(((String)OrdersList.get(i))+"SCH");
				schSize = uniqueSchedules.size();
			}
			if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){ 
				hmIVDrugFluidDtls =(HashMap)hmIVDrugDetails.get(ordKey);
				alTmpOrderSchDetail =(ArrayList)hmIVDrugFluidDtls.get(ordKey+"_Fluid");
				alIVPBDrugSchList =(ArrayList)hmIVDrugFluidDtls.get(ordKey+"_Drug");
				rowsPan = schSize;
				if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0){
					if(schSize ==1){
						rowsPan = 2;
						freqRowspan=2;
						schRowspan=2;
						drugRowspan=1;
						fluidRowspan=1;
					}
					else if(schSize%2 >0 && schSize>1){
						fluidRowspan =(schSize/2)+1;
						drugRowspan =schSize/2;
						freqRowspan = schSize/(drugRowspan+fluidRowspan);
					}
					else{
						fluidRowspan =schSize/2;
						drugRowspan =schSize/2;
						freqRowspan = schSize/(drugRowspan+fluidRowspan);
					}
				}
				else{
					fluidRowspan = rowsPan ;
				}
/*				if(iv_prep_yn.equals("4")){ //commented for MMS-KH-CRF-0017
					rowsPan = 1;
					drugRowspan=1;
					fluidRowspan=1;
				} */
			}
			else{
				alTmpOrderSchDetail = (ArrayList)hmIVDrugDetails.get((String)OrdersList.get(i));
				max_dasage_seq_no = Integer.parseInt(hmSchList.get(ordKey+"MAXSEQ")+"");
				rowsPan = (alTmpOrderSchDetail.size()/max_dasage_seq_no);
				if(!iv_prep_yn.equals("2") && !iv_prep_yn.equals("5")){ 
					freqRowspan=rowsPan;
				}
			}
			for(sch=0; sch<alTmpOrderSchDetail.size(); sch++){
				iv_drug_details =(ArrayList)alTmpOrderSchDetail.get(sch);
				iv_order_pract_id  =  (String)iv_drug_details.get(68);
				linkVacScheduleCode	="";
				dosage_seq_no	= iv_drug_details.get(13)==null?"":(String)iv_drug_details.get(13);
				admin_recorded_yn  = (String)iv_drug_details.get(23);
				if(!dosage_seq_no.equals("1") && !( iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")) )
					continue;
				pres_catg_code =(String)iv_drug_details.get(49);
				if(pres_catg_code == null){
					pres_catg_code="";
				}
				auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);								
				auth_reqd_script="";
				if(auth_reqd){
					if(pin_value.equals(""))
						auth_reqd_script=";pinAuthentication(this,'NP');";
					else
						auth_reqd_script=";pinAuthentication(this,'YP');";
				}
				iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]
				pract_id					= (String)iv_drug_details.get(37);
				against_sch_date			= (String)iv_drug_details.get(38);
				adr_reason					= (String)iv_drug_details.get(39)==null?"":(String)iv_drug_details.get(39);
				adr_remarks					= (String)iv_drug_details.get(40);
				adr_record_time				= (String)iv_drug_details.get(41)==null?"":(String)iv_drug_details.get(41);
				adr_recorded_by				= (String)iv_drug_details.get(42);
				iv_prep_yn					= (String)iv_drug_details.get(43);	
				freq_nature					= (String)iv_drug_details.get(35);
				flag						=	"Y";
				sch_infusion_rate			= (String)iv_drug_details.get(1);

				if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
					if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
						sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
					}
				}
				sch_infusion_vol_str_unit	= (String)iv_drug_details.get(2);
				sch_infusion_vol_str_unit_desc = (String)iv_drug_details.get(66);
				sch_infusion_per_unit		= (String)iv_drug_details.get(3);
				route_desc					= (String)iv_drug_details.get(48);
				route_color                 = (String)iv_drug_details.get(67);
				if(route_color != "" && route_color != null && route_color.length()==12){
					fntColor = route_color.substring(0, 6);
					backGrndColor = route_color.substring(6, 12);
				}
				else{
					fntColor = "";
					backGrndColor = "";
				}
				patient_id					= (String)iv_drug_details.get(9);
				sch_infusion_per_unit_table_date = sch_infusion_per_unit;
									
				if(sch_infusion_per_unit.equals("H")){
					sch_infusion_per_unit = "Hrs";
					if(sch_infusion_rate!=null && !(sch_infusion_rate.equals(""))){												
						sch_infusion_in_min=bean.roundDigits(Float.parseFloat(sch_infusion_rate)/60.0+"");
					}
					tol_title=sch_infusion_in_min+"&nbsp;ML/Minute"; 
				}
				else{
					sch_infusion_per_unit = "Mins";
					tol_title="";
				}
				item_code                =   (String)iv_drug_details.get(8);
				drug_code                =   (String)iv_drug_details.get(29);
				drug_desc                =   (String)iv_drug_details.get(11);
				dispensed_drug_desc		 = 	 (String)iv_drug_details.get(77);
				disp_drugs 				 =   (String)iv_drug_details.get(78);
				dispense_drug_code 		 = 	 (String)iv_drug_details.get(79);
				if(dispense_drug_code.equals(""))
					dispense_drug_code 	 = drug_code;
				sch_date_time            =   (String)iv_drug_details.get(12);
				order_id                 =   (String)iv_drug_details.get(14);
				order_line_num           =   (String)iv_drug_details.get(15);
				qty						 =	 (String)iv_drug_details.get(16);
				if(Float.parseFloat(qty) < 1)
					qty="0"+qty; 

				qty_uom					 =	 (String)iv_drug_details.get(17);
				discontinued			 =	 (String)iv_drug_details.get(18);
				hold					 =	 (String)iv_drug_details.get(19);
				sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
				
				sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
				administered_yn			 =	 (String)iv_drug_details.get(22);
				store_code				 =   (String)iv_drug_details.get(30);
				end_date_time 			 =   (String)iv_drug_details.get(33);
				start_date_time			=	(String)iv_drug_details.get(69);
				freq_code				 =   (String)iv_drug_details.get(34);								
				encode_drug_desc         =   drug_desc.replaceAll(" ","%20");
				encode_drug_desc         =   java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
				encode_drug_desc         =   encode_drug_desc.replaceAll("%2520","%20");						
				ext_prod_id              =   (String)iv_drug_details.get(44);
				iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
				trade_code			     =   (String)iv_drug_details.get(46);
				imageFileURL			 =   (String)iv_drug_details.get(47);
				Store_locn_code			 =	(String)iv_drug_details.get(65);
				iv_Auto_Admin               =   bean.getAutoAdminValue(facility_id,Store_locn_code);
				next_schd_date           =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);//added for SCF-7528
				no_of_doses = 1;
				if(bean.getNoOfDoses(order_id,order_line_num) !=null)
					no_of_doses				 =   Integer.parseInt(bean.getNoOfDoses(order_id,order_line_num));
				linkVacScheduleCode		 =	(String)iv_drug_details.get(53);
				MfrYN					 =	(String)iv_drug_details.get(54);
				sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
				sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
				sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
				if(sfrHOLD_DURN_IN_MINS.equals(""))
					sfrHOLD_DURN_IN_MINS="0";
				sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
				sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
				if(!(sfrACT_START_DATE_TIME.equals(""))){
					sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
				}
				
				if(sfrACT_START_DATE_TIME.equals("")){
					sfrACT_START_DATE_TIME=current_date_time;
				}
				sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
				dosage_type				 =(String)iv_drug_details.get(61);
				mfrRemarks				 =	(String)iv_drug_details.get(62);
				completedMinutes		 =	(String)iv_drug_details.get(63);
				if(completedMinutes.equals(""))
					completedMinutes = "0";
				completedFlow			 =	(String)iv_drug_details.get(64);
				if(completedFlow.equals(""))
					completedFlow = "0";
				if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))
					freq_desc			 =	(String)iv_drug_details.get(70);
				else
					freq_desc = "";
				adr_count			= bean.getADRCount(patient_id_test,drug_code);   
				schDate			 =	(String)iv_drug_details.get(71);
				schTime			 =	(String)iv_drug_details.get(72);
				String can_act_sch=(String)iv_drug_details.get(72);//ADDED FOR JD-CRF-0200
				
				schCanAdmin			 =	(String)iv_drug_details.get(73);
				ord_hold_date_time			 =	(String)iv_drug_details.get(75);
				ord_disc_date_time			 =	(String)iv_drug_details.get(76);
			cancel_recorded_yn_3=(String)iv_drug_details.get(80);//ADDED FOR JD-CRF-0200
		

				if(!mfrRemarks.equals(""))
					mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");

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

				if(order_line_num != null && !order_line_num.equals("1"))
					hide_ingredient_dtls = "visibility:hidden;";
				else
					hide_ingredient_dtls = "";

				if(freq_nature!=null && freq_nature.equals("O")) 
					stat_style	=	"background-color:#CE00CE";
				else
					stat_style	=	"";

				administered_yn		 = "Y";
				if(iv_drug_details.get(23)==null || ((String)iv_drug_details.get(23)).equals(""))
					administered_yn = "N";
				remarks = (String)iv_drug_details.get(24);				
				if(remarks==null)
					remarks="Not Entered";

								admin_by_name   = (String)iv_drug_details.get(26);
								auth_by_name    = (String)iv_drug_details.get(32);
								if(showTitle.length()>0)
									showTitle.setLength(0);
								if(remarks!=null && !remarks.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n");
								if(admin_by_name!=null && !admin_by_name.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
								if(auth_by_name!=null && !auth_by_name.equals("")){
									showTitle.append("\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								}

				admin_date_time = "";
				if(iv_drug_details.get(27)!= null)
					admin_date_time = (String)iv_drug_details.get(27);
				if(viewAdminRemarks){
					showTitle.append("\nRecorded D/T: "+admin_date_time);//ADDED FOR MMS-KH-CRF-0010
				}
				modified_date_time = "";
				if(iv_drug_details.get(28)!= null)
					modified_date_time = (String)iv_drug_details.get(28);				
				drug_class = (String)iv_drug_details.get(31);
				drug_class_ind = bean.getDrugClassInd(drug_class);
							
				if(sch_infusion_period_unit==null)
					sch_infusion_period_unit="";

				if(sch_infusion_period_unit.equals("H"))
					sch_infusion_period_unit_label = "Hrs";
				else if(sch_infusion_period_unit.equals("M"))
					sch_infusion_period_unit_label = "Mins";



				displayStyle = bean.getDisplayStyle(freq_code,discontinued,hold,admin_recorded_yn,administered_yn);
				HashMap  administred_batch   = bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);
				administred_batch_id = (String)administred_batch.get("BATCH_ID");						
				if(administred_batch_id == null)administred_batch_id="";
					disp_batch_id		 = (String)administred_batch.get("DISP_BATCH_ID");	
		
				if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){	
					work_sheet_batch_det  =(ArrayList)bean.getProductName(order_id,order_line_num);
		
					if(work_sheet_batch_det!=null && work_sheet_batch_det.size()>0){
					prod_name	=	(String)work_sheet_batch_det.get(0);
					batch_id	=	(String)work_sheet_batch_det.get(1);								
					expiry_date	=	(String)work_sheet_batch_det.get(2);
					drug_code	= "FINAL PRODUCT";
					}
				}
				else{
					prod_name	=	"";
					expiry_date=expiry_date.trim();
				 }
	  
				if(!adr_record_time.equals("") && !adr_reason.equals("")){
					adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);

					adr_details	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+": " + com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+": "+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+": "+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;
					adminStatus="PAD";
					admin_rec_disp = "display:inline";
				}
				else{
					admin_rec_disp = "display:none";
					adminStatus="";
					adr_details="";
				}
//added for MMS-KH-CRF-0010 start
if((iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))){
				pres_remarks			= bean.getPrescriptionInstructions(order_id);
				drug_remarks			= bean.getDrugInstructions(order_id,"2");
				prn_remarks				= bean.getPRNInstructions(order_id,"2");
				pharma_remarks			= bean.getPharmacistInstructions(order_id,"2");
				slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,"2");
				verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,"2");	
				
				
				nonMfrFluidRemarks		= "";
				overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,"2");
}
else{
	pres_remarks			= bean.getPrescriptionInstructions(order_id);
	drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
	prn_remarks				= bean.getPRNInstructions(order_id,order_line_num);
	pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
	slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,order_line_num);
	verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);	
	
	
	nonMfrFluidRemarks		= "";
	overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
}
				show_remarks = bean.getShowRemarks(show_remarks,overridereason);
				
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
					remarks_style	=	"style='visibility:visible'";

					dialog_height	 = bean.getDialogHeight(prn_remarks,drug_remarks,pres_remarks,slidingscaleremarks , pharma_remarks, verificationremarks, nonMfrFluidRemarks, show_remarks , dialog_height,pharm_col);
		
					dialog_height	 += 1.4;
				} 
			
				if(Float.parseFloat(qty) < 1.0)
					qty = Float.parseFloat(qty)+""; //to prefix a zero

				if ((orderCount+1) % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;	
				if(order_line_num.equals("1"))
					IVclassvalue="IVFLUID1";
				else
					IVclassvalue="IVINGREDIENT1";
				stDispHand="cursor:pointer;";
				displayStyle = "";
				if(schCanAdmin.equals("Y")){
					/*if( !mar_disc_dose_yn.equals("Y") && discontinued.equals("Y") && !sch_date_time.equals(ord_disc_date_time))
						displayStyle = "";
					else*/
					displayStyle = "COLOR:blue;text-decoration:underline;";
				}
				stDispHand="cursor:pointer;";
				if(hold.equals("Y") || (!mar_disc_dose_yn.equals("Y") && discontinued.equals("Y")&& !sch_date_time.equals(ord_disc_date_time)))
					stDispHand="";
				if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
					showAlt	 = ("Administered Drug : "+dispensed_drug_desc+"\n");
					showTitle.insert(0, showAlt );
					displayStyle = "BACKGROUND-COLOR:#CC99CC;COLOR:white;";
				}
				else if(admin_recorded_yn.equals("Y")){
					if(administered_yn.equals("N")) 
						displayStyle = "BACKGROUND-COLOR:#000000;COLOR:white;";
					else {
						displayStyle = "BACKGROUND-COLOR:green;COLOR:white;";
						if(discontinued.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:Red;";
						if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:yellow;";
					}
				}
				else if(discontinued.equals("Y")&& com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
					displayStyle = "BACKGROUND-COLOR:red;COLOR:blue;";
					if(sch_date_time.equals(ord_disc_date_time))
						stDispHand = "cursor:pointer;";
					else
						stDispHand="";
				}
				else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
					displayStyle = "BACKGROUND-COLOR:yellow;";
					stDispHand="";
				}
				if(sch==0 ){
%>
						<tr>
							<td class='<%=classvalue%>' width='7%' style="font-size:9;text-align:center;" nowrap rowspan='<%=rowsPan%>'><%=start_date_time%></td>
							<td class='<%=classvalue%>' width='7%' style="font-size:9;text-align:center;" nowrap rowspan='<%=rowsPan%>'><%=end_date_time%></td>
<%
					}

					if(!(iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))){
%>
						<td class="<%=IVclassvalue%>" width='19%' style="word-wrap:break-word;font-size:9;<%=drug_class_ind%>"  >
<%
							if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
								<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=drug_code%>');" id="drug_mast_det_<%=orderCount%>_<%=sch%>">&nbsp;+&nbsp;</label>
<%
							}
%>
							<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=drug_desc%> &nbsp;&nbsp;
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
							if(adr_count>0){
%>
								<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=drug_code%>');"></img>
<%
							} 

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
									<br> <label id='iv_link_vaccine_label_<%=orderCount%>' style="font-size:10;" title='<%=linkVacScheduleDescToolTip%>'> <fmt:message key="ePH.LinkVaccineShcedule.label" bundle="${ph_labels}"/> <input type='text' size=10 name='iv_link_vaccine_desc_<%=orderCount%>' id='iv_link_vaccine_desc_<%=orderCount%>' value='<%=linkVacScheduleDesc%>' disabled><input type='button'  class='button' value='?' name='iv_btn_link_vaccine_<%=orderCount%>' id='iv_btn_link_vaccine_<%=orderCount%>' onClick="linkVaccine('iv','<%=orderCount%>', 'SCH')"></label>
<%
								}
							}
							if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){
%>
									<br><label style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_drugs%> </label>
									
<%
							}
							if(order_line_num.equals("1")){
%>
								<br>
								<label><fmt:message key="ePH.TotalVolume.label" bundle="${ph_labels}"/>&nbsp;=&nbsp;<%=qty%>&nbsp;<%=qty_uom%>
								</label>
<%
							}
%>
						</td>
						<%if(viewAdminRemarks){ %>
						<td class='<%=classvalue%>' width='7%' style="font-size:9;word-wrap:break-word;" wrap>
						<img src="../../ePH/images/DrugRemarks.gif" align="center" style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_num%>','<%=dialog_height%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','N')" title=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")%> <%=remarks_style%>></img><!--modified for MMS-KH-SCF-0064 -->
						</TD>
						<%} %>
						<td class='<%=classvalue%>' width='7%' style="font-size:9;word-wrap:break-word;" wrap><%=sch_infusion_rate%>&nbsp;
<%
							if(!MfrYN.equals("Y")){
%>
								<%=sch_infusion_vol_str_unit_desc%>/<%=sch_infusion_per_unit%>
<%
							}
%>
						</td>
<%
						if(order_line_num.equals("1")){
%>
							<td class='<%=classvalue%>' width='7%' rowspan='<%=rowsPan%>' style='word-wrap:break-word;'>
								<label style="color:<%=fntColor%>;background-color:<%=backGrndColor%>;font-size:9;text-align:center;"><%=route_desc%></label>
							</td>
							<td class='<%=classvalue%>' width='7%' style="word-wrap:break-word;font-size:9;text-align:center;" rowspan='<%=rowsPan%>'><%=freq_desc%>&nbsp;</td>
							<td class='<%=classvalue%>' width='5%'  style="font-size:9;word-wrap:break-word;" rowspan='<%=rowsPan%>'>&nbsp;</td>
<%
						}
					}
					else if(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")){
						ivnextRow = false;
						if(sch==0 || (ivRowCount == fluidRowspan && uniqueSchedules.contains(schTime))){
							if(sch!=0 &&(ivRowCount== fluidRowspan && alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0)){ //Drug display
								IVclassvalue="IVINGREDIENT1";
								alTmpIVPBDrugDtls = (ArrayList)alIVPBDrugSchList.get(0);
								ivPB_drug_code                =   (String)alTmpIVPBDrugDtls.get(10);
								ivPB_drug_desc                =   (String)alTmpIVPBDrugDtls.get(11);
								ivPB_encode_drug_desc         =   ivPB_drug_desc.replaceAll(" ","%20");
								ivPB_encode_drug_desc         =   java.net.URLEncoder.encode(ivPB_encode_drug_desc,"UTF-8");
								ivPB_encode_drug_desc         =   ivPB_encode_drug_desc.replaceAll("%2520","%20");						
								ivPB_ext_prod_id              =   (String)alTmpIVPBDrugDtls.get(44);
								iv_no_of_drug_per_order  =   (String)alTmpIVPBDrugDtls.get(45);
								ivPB_trade_code			     =   (String)alTmpIVPBDrugDtls.get(46);
								ivPB_imageFileURL			 =   (String)alTmpIVPBDrugDtls.get(47);
								drug_class = (String)alTmpIVPBDrugDtls.get(31);
								drug_class_ind = bean.getDrugClassInd(drug_class);
								adr_count			= bean.getADRCount(patient_id_test,ivPB_drug_code); 
								ivPB_sch_infusion_rate = bean.getIVPBSchInfusionRate((String)alTmpIVPBDrugDtls.get(1));
								sch_infusion_vol_str_unit	= (String)alTmpIVPBDrugDtls.get(2);
								ivPB_sch_infusion_vol_str_unit_desc = (String)alTmpIVPBDrugDtls.get(66);
								
								 ivPB_sch_infusion_per_unit = bean.getIVPBschInfusionUnit((String)alTmpIVPBDrugDtls.get(3));

								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){
%>
										<td class='<%=classvalue%>' width='5%'  style="font-size:9;word-wrap:break-word;" rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
									}
%>
									</tr>
									<tr>
<%
									schDayCount=0;
									dayCount = 0;
								}
%>
								<td class="<%=IVclassvalue%>" width='19%' style="word-wrap:break-word;font-size:9;<%=drug_class_ind%>"  rowspan='<%=drugRowspan%>'>
<%
								if (!iv_prep_yn.equals("4")){
%>
									<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=ivPB_drug_code%>');" id="drug_mast_det_<%=orderCount%>">&nbsp;+&nbsp;</label>
<%
								}
%>
								<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=ivPB_drug_desc%> &nbsp;&nbsp;
<%
								if( !ivPB_ext_prod_id.equals("")&& !iv_prep_yn.equals("4")){
%>
									<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ivPB_ext_prod_id%>','<%=ivPB_encode_drug_desc%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
								}
								if( !ivPB_imageFileURL.equals("")){
%>
									<img src='../../ePH/images/camera.gif' width='17' height='15' onclick = "showImage('<%=ivPB_drug_code%>','<%=ivPB_trade_code%>');" onmouseover="changeCursor(this);">
<%
								}
								if(adr_count>0){
%>
									<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=ivPB_drug_code%>');"></img>
<%
								} 
								if(!iv_prep_yn.equals("4")){
%>
									<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=ivPB_drug_code%>');" onmouseover="changeCursor(this);">
<%													
								}
%>
								</label>		
								<br>
								<label><fmt:message key="ePH.TotalVolume.label" bundle="${ph_labels}"/>&nbsp;=&nbsp;<%=ivPB_qty%>&nbsp;<%=ivPB_qty_uom%>
								</label>
								</td>
								<td class='<%=classvalue%>' width='7%' style="word-wrap:break-word;font-size:9;" wrap rowspan='<%=drugRowspan%>'> <%=ivPB_sch_infusion_rate%>&nbsp;<%=ivPB_sch_infusion_vol_str_unit_desc%>/<%=ivPB_sch_infusion_per_unit%></td>
<%
							}
							else{ //Fluid Display
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){
%>
										<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;font-size:9;" rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
									}
%>
									</tr>
									<tr>
<%
									schDayCount=0;
									dayCount = 0;
								}
%>
								<td class="<%=IVclassvalue%>" width='19%' style="word-wrap:break-word;font-size:9;<%=drug_class_ind%>"  rowspan='<%=fluidRowspan%>'>
<%
									if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
										<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=drug_code%>');" id="drug_mast_det_<%=orderCount%>">&nbsp;+&nbsp;</label>
<%
									}
%>
									<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=drug_desc%> &nbsp;&nbsp;
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
									if(adr_count>0){
%>
										<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=drug_code%>');"></img>
<%
									} 
									if(prod_name.length()==0 && !iv_prep_yn.equals("4")){
%>
										<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" onmouseover="changeCursor(this);">
<%													
									}
									if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){
%>
										<br><label style="font-size:9;color:green">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_drugs%> </label>
									<%
									}
%>
									</label>		
									<br>
									<label><fmt:message key="ePH.TotalVolume.label" bundle="${ph_labels}"/>&nbsp;=&nbsp;<%=qty%>&nbsp;<%=qty_uom%>
									</label>
								</td>
								<%if(viewAdminRemarks){ %><!-- if condtion added for  MMS-KH-CRF-0010 -->
									<td   class="<%=classvalue%>" rowspan='<%=rowsPan%>' >
									
					<img src="../../ePH/images/DrugRemarks.gif" align="center" style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','2','<%=dialog_height%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','N')" title=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")%> <%=remarks_style%> /> <!--modified for MMS-KH-SCF-0064 -->
				</td>
				<%} %>
								<td class='<%=classvalue%>' width='7%' style="font-size:9;word-wrap:break-word;" wrap rowspan='<%=fluidRowspan%>'> <%=sch_infusion_rate%>&nbsp;<%=sch_infusion_vol_str_unit_desc%>/<%=sch_infusion_per_unit%></td>
								<td class='<%=classvalue%>' width='7%' rowspan='<%=rowsPan%>' style='word-wrap:break-word;' >
									<label style="color:<%=fntColor%>;background-color:<%=backGrndColor%>;font-size:9;text-align:center;"><%=route_desc%></label>
								</td>
								<td class='<%=classvalue%>' width='7%' style="word-wrap:break-word;font-size:9;text-align:center;" rowspan='<%=rowsPan%>'><%=freq_desc%>&nbsp;</td>
<%
							}
						}
					}
						if(order_line_num.equals("1") || iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")) {
							if(uniqueSchedules!=null){
								if(uniqueSchedules.contains(schTime)){
									uniqueSchedules.remove(schTime);
									ivRowCount++;
									if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4")){
										if(sch!=0 && !ivnextRow){
											ivnextRow = false;
											for(;schDayCount<(daySize/2); schDayCount++){
%>
												<td class='<%=classvalue%>' width='5%'  style="font-size:9;word-wrap:break-word;" >&nbsp;</td>
<%
											}
%>
											</tr>
											<tr>
<%
										}
%>
										<td class='<%=classvalue%>' width='5%' style="font-size:9;word-wrap:break-word;" rowspan='<%=freqRowspan%>'><%=schTime%></td>
<%
										schDayCount=0;
										dayCount = 0;
										schCount++;
									}
								}
								nextDaySch = false;
								drugCount=1;
								if(sfrFLOW_STATUS.equals("NS")){
									sfrFLOW_STATUS_String="";
								}
								else if(sfrFLOW_STATUS.equals("ST")){
									sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
								}
								else if(sfrFLOW_STATUS.equals("HO")){
									sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
								}
								else if(sfrFLOW_STATUS.equals("RE")){
									sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
								}
								if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD") || administered_yn.equals("Y")){
									sfrFLOW_STATUS_String = "";
									stDispHand = "BACKGROUND-COLOR:green;COLOR:white;;cursor:pointer;";
								}
								ivSchDispStatus="";
								if(!sfrFLOW_STATUS.equals("NS") && !sfrFLOW_STATUS.equals("CO"))
									ivSchDispStatus = sfrFLOW_STATUS_String+" <br> </label><label style='vertical-align:middle;' >";
								if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>sch && !iv_prep_yn.equals("4"))
									drugCount=2;
								for(int day=(dayCount*2); day<daySize; day+=2){
									dispDate = (String)altDateDayList.get(day);
									scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+sch;//sch Added for identified issues fix
									if((com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) ) && schDayCount ==dayCount){
										schDayCount++;
										dayCount++;
										if(dispDate.equals(schDate)){
											if(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")){
												if(!schCanAdmin.equals("Y")){
													if(administered_yn.equals("Y")){ //IV PiggyPack administered td
%>
														<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;"  rowspan='<%=freqRowspan%>'>
															<div id="order<%=scheKey%>" style='vertical-align:middle;<%=stDispHand%>' title='<%=showTitle.toString()%>'>
<%
															if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){
%>
																<!--cancelYn,admin_by_name,drug_desc,scheKey added for JD-CRF-0200 -->
															<label style='vertical-align:middle;<%=stDispHand%>;' onClick="alert('click');openAuditLogWindowIV('<%=orderCount%>','SFR','SCH','<%=schDayCount%>', '<%=schCount%>','<%=cancelYn%>','<%=admin_by_name%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=scheKey%>','<%=qty%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=patient_id_test%>','<%=encounter_id%>','','');"><%=schTime%></b></label><!--modified for MMS-KH-SCF-0064 --><!-- Modified for IN073378 -->
<%
															}
															else{
																if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start
%>
																<label style="vertical-align:middle;cursor:pointer;<%=displayStyle%>" onClick=""><%=schTime%></label>
<%
																} // if Added for KH-SCF-0010 - End
																else{//cancelYn,admin_by_name,drug_desc added for JD-CRF-0200
%>
																	<label style="vertical-align:middle;cursor:pointer;<%=displayStyle%>" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','IV','<%=orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=sch%>','<%=sfrFLOW_STATUS%>','<%=dosage_seq_no%>','<%=drugCount%>',,'','','','','<%=cancelYn%>','<%=admin_by_name%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');"><%=schTime%></label><!--modified for MMS-KH-SCF-0064 -->
<%
																}
																}
%>
															</div>
															<%if(cancel_recorded_yn_3.equals("Y")){%><!--ADDED FOR JD-CRF-0200 -->
													<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img><!--modified for MMS-KH-SCF-0064 -->
														<%} %>
														</td>
<%
													}
													else{ //IV PiggyPack can not admin td
%>
														<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;"  rowspan='<%=freqRowspan%>'>&nbsp;
															<div id="order<%=scheKey%>" style='vertical-align:middle;<%=stDispHand%>'><label style='vertical-align:middle;<%=stDispHand%>;<%=displayStyle%>'><%=schTime%></label></div>
														</td>
<%
													}
												}
												else{ //IV PiggyPack can admin td
%>
													<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;"  rowspan='<%=freqRowspan%>'>
														<div id="order<%=scheKey%>" style='vertical-align:middle;<%=stDispHand%>'>
<%
															if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD") || administered_yn.equals("Y")){
%>
														<label style='vertical-align:middle;<%=stDispHand%>;' onClick="openAuditLogWindowIV('<%=orderCount%>','SFR','SCH','<%=schDayCount%>', '<%=schCount%>','<%=cancelYn%>','<%=admin_by_name%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=scheKey%>','<%=qty%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=patient_id_test%>','<%=encounter_id%>','','');"><%=schTime%></b></label><!--modified for MMS-KH-SCF-0064 --><!-- Modified for IN073378 -->
<%
															}
															else{
																if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start
%>
															<label style="vertical-align:middle;<%=stDispHand%>;<%=displayStyle%>"><B><%=ivSchDispStatus%></B><%=schTime%></label>
<%
																} // if Added for KH-SCF-0010 - End
															else{
%>
																<label style="vertical-align:middle;<%=stDispHand%>;<%=displayStyle%>" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','IV','<%=orderCount%>','<%=schCount%>','<%=schDayCount%>','<%=sch%>','<%=sfrFLOW_STATUS%>','<%=dosage_seq_no%>','<%=drugCount%>');"><B><%=ivSchDispStatus%></B><%=schTime%></label>
<%
															}
												        }
%>
														</div>
														<%if(cancel_recorded_yn_3.equals("Y")){%><!--ADDED FOR JD-CRF-0200 -->
														<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img> <!--modified for MMS-KH-SCF-0064 -->
													<%}%>
													</td>
<%
												}
												drugCount=1;
%>
		  										<input type="hidden" name="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=qty%>">
												<input type="hidden" name="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="N">
												<input type="hidden" name="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=modified_date_time%>">	
												<input type="hidden" name="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=dosage_seq_no%>">
												<input type="hidden" name="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=end_date_time%>">
												<input type="hidden" name="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=next_schd_date%>">
												<input type="hidden" name="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="N">
												<input type="hidden" name="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="N">
												<input type="hidden" name="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_date_time%>">
												<input type="hidden" name="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrACT_START_DATE_TIME%>">
												<input type="hidden" name="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_rate%>">
												<input type="hidden" name="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_vol_str_unit%>">
												<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_vol_str_unit_desc%>"> 
												<input type="hidden" name="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_per_unit_table_date%>">
												<input type="hidden" name="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_period%>">
												<input type="hidden" name="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_period_unit%>">
												<input type="hidden" name="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=batch_id%>">
												<input type="hidden" name="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=expiry_date%>">
												<input type="hidden" name="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=batch_id%>">
												<input type="hidden" name="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="expiry_date">
												<input type="hidden" name="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=trade_name%>" >
												<input type="hidden" name="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=trade_id%>">
												<input type="hidden" name="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type='hidden' name="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value='IV_Y'>
												<input type="hidden" name="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=iv_no_of_drug_per_order%>">
												<input type="hidden" name="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrFLOW_STATUS%>">
												<input type="hidden" name="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrHOLD_DATE_TIME%>">
												<input type="hidden" name="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrHOLD_DURN_IN_MINS%>">
												<input type="hidden" name="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrRESUME_DATE_TIME%>">
												<input type="hidden" name="sfrACT_END_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrACT_END_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrACT_END_DATE_TIME%>">
												<input type="hidden" name="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="0">
												<input type="hidden" name="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="0">
												<input type="hidden" name="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=dosage_type%>">
												<input type="hidden" name="completedMinutes<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="completedMinutes<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=completedMinutes%>">
												<input type="hidden" name="completedFlow<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="completedFlow<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=completedFlow%>">
												<input type="hidden" name="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(Float.parseFloat(qty)+"")%>"> 
												<input type="hidden" name="iv_qty_uom_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_qty_uom_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=qty_uom%>">
												<input type="hidden" name="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=iv_sch_date_tim%>"><!--Added for SKR-SCF-0913[Inc : 46556] -->

												<input type="hidden" name="iv_drug_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_drug_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(10)%>">
												<input type="hidden" name="iv_item_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_item_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(8)%>">
												<input type="hidden" name="iv_order_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_order_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>"  value="<%=(String)iv_drug_details.get(14)%>">
												<input type="hidden" name="iv_order_line_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_order_line_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(15)%>">	
												<input type="hidden" name="iv_drug_class<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_drug_class<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(31)%>">
												<input type='hidden' name="iv_link_vaccine_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_link_vaccine_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value='<%=linkVacScheduleCode%>'>
<%
												if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>sch && !iv_prep_yn.equals("4")){
													iv_drug_details =(ArrayList)alIVPBDrugSchList.get(sch);
													drugCount++;
													admin_recorded_yn  = (String)iv_drug_details.get(23);
													sch_infusion_rate			= (String)iv_drug_details.get(1);
													iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]

													if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
														if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
															sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
														}
													}
													sch_date_time            =   (String)iv_drug_details.get(12);
													qty						 =	 (String)iv_drug_details.get(16);
													if(Float.parseFloat(qty) < 1)
														qty="0"+qty; 

													qty_uom					 =	 (String)iv_drug_details.get(17);
													discontinued			 =	 (String)iv_drug_details.get(18);
													hold					 =	 (String)iv_drug_details.get(19);
													sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
													
													sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
													administered_yn			 =	 (String)iv_drug_details.get(22);
													end_date_time 			 =   (String)iv_drug_details.get(33);
													start_date_time			=	(String)iv_drug_details.get(69);
													iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
													
													
													next_schd_date =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);
													//sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
													sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
													sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
													if(sfrHOLD_DURN_IN_MINS.equals(""))
														sfrHOLD_DURN_IN_MINS="0";
													sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
													sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
													if(!(sfrACT_START_DATE_TIME.equals(""))){
														sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
													}
													
													if(sfrACT_START_DATE_TIME.equals("")){
														sfrACT_START_DATE_TIME=current_date_time;
													}
													sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
													dosage_type				 =(String)iv_drug_details.get(61);
													mfrRemarks				 =	(String)iv_drug_details.get(62);
													completedMinutes		 =	(String)iv_drug_details.get(63);
													if(completedMinutes.equals(""))
														completedMinutes = "0";
													completedFlow			 =	(String)iv_drug_details.get(64);
													if(completedFlow.equals(""))
														completedFlow = "0";
													adr_count			= bean.getADRCount(patient_id_test,drug_code);   
													schDate			 =	(String)iv_drug_details.get(71);
													ord_hold_date_time			 =	(String)iv_drug_details.get(75);
													ord_disc_date_time			 =	(String)iv_drug_details.get(76);

													if(!mfrRemarks.equals(""))
														mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");
													remarks = iv_drug_details.get(24)==null?"Not Entered":(String)iv_drug_details.get(24);				
										admin_by_name   = (String)iv_drug_details.get(26);
										auth_by_name    = (String)iv_drug_details.get(32);
										if(showTitle.length()>0)
											showTitle.setLength(0);
										if(remarks!=null && !remarks.equals(""))
											showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
										if(admin_by_name!=null && !admin_by_name.equals(""))
											showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
										if(auth_by_name!=null && !auth_by_name.equals("")){
											showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
										}
													//ADDED FOR MMS-KH-CRF-0010 START
													pres_remarks			= bean.getPrescriptionInstructions(order_id);
													drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
													prn_remarks				= bean.getPRNInstructions(order_id,order_line_num);
													pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
													slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,order_line_num);
													verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);	
													
									nonMfrFluidRemarks		= "";
													//if(iv_prep_yn.equals("5")){
														nonMfrFluidRemarks		= bean_all_stages.getNonMFRfluidRemarks(order_id,order_line_num);
													//}
													overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,"2");
													
											show_remarks = bean.getShowRemarks(show_remarks,overridereason);

									if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N") && nonMfrFluidRemarks.equals("")){
														remarks_style	=	"style='visibility:hidden'";
													}
													else {
														dialog_height = 0 ;
														remarks_style	=	"style='visibility:visible'";

					dialog_height	 = bean.getDialogHeight(prn_remarks,drug_remarks,pres_remarks,slidingscaleremarks , pharma_remarks, verificationremarks, nonMfrFluidRemarks, show_remarks , dialog_height,pharm_col);											
														dialog_height	 += 1.4;
													} 
													//ADDED FOR MMS-KH-CRF-0010
													admin_date_time = "";
													if(iv_drug_details.get(27)!= null)
														admin_date_time = (String)iv_drug_details.get(27);
													modified_date_time = "";
													if(iv_drug_details.get(28)!= null)
														modified_date_time = (String)iv_drug_details.get(28);	
														linkVacScheduleCode		 =	(String)iv_drug_details.get(53);
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
%>
												<input type="hidden" name="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=qty%>">
												<input type="hidden" name="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="N">
												<input type="hidden" name="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=modified_date_time%>">	
												<input type="hidden" name="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=dosage_seq_no%>">
												<input type="hidden" name="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=end_date_time%>">
												<input type="hidden" name="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=next_schd_date%>">
												<input type="hidden" name="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="N">
												<input type="hidden" name="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="N">
												<input type="hidden" name="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_date_time%>">
												<input type="hidden" name="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrACT_START_DATE_TIME%>">
												<input type="hidden" name="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_rate%>">
												<input type="hidden" name="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_vol_str_unit%>">
												<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_vol_str_unit_desc%>"> 
												<input type="hidden" name="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_per_unit_table_date%>">
												<input type="hidden" name="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_period%>">
												<input type="hidden" name="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sch_infusion_period_unit%>">
												<input type="hidden" name="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=batch_id%>">
												<input type="hidden" name="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=expiry_date%>">
												<input type="hidden" name="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=batch_id%>">
												<input type="hidden" name="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="expiry_date">
												<input type="hidden" name="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=trade_name%>" >
												<input type="hidden" name="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=trade_id%>">
												<input type="hidden" name="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type='hidden' name="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value='IV_Y'>
												<input type="hidden" name="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=iv_no_of_drug_per_order%>">
												<input type="hidden" name="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrFLOW_STATUS%>">
												<input type="hidden" name="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrHOLD_DATE_TIME%>">
												<input type="hidden" name="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrHOLD_DURN_IN_MINS%>">
												<input type="hidden" name="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="">
												<input type="hidden" name="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrRESUME_DATE_TIME%>">
												<input type="hidden" name="sfrACT_END_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="sfrACT_END_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=sfrACT_END_DATE_TIME%>">
												<input type="hidden" name="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="0">
												<input type="hidden" name="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="0">
												<input type="hidden" name="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=dosage_type%>">
												<input type="hidden" name="completedMinutes<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="completedMinutes<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=completedMinutes%>">
												<input type="hidden" name="completedFlow<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="completedFlow<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=completedFlow%>">
												<input type="hidden" name="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(Float.parseFloat(qty)+"")%>"> 
												<input type="hidden" name="iv_qty_uom_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_qty_uom_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=qty_uom%>">
												<input type="hidden" name="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=iv_sch_date_tim%>"><!--Added for SKR-SCF-0913[Inc : 46556] -->

												<input type="hidden" name="iv_drug_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_drug_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(10)%>">
												<input type="hidden" name="iv_item_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_item_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(8)%>">
												<input type="hidden" name="iv_order_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_order_id_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>"  value="<%=(String)iv_drug_details.get(14)%>">
												<input type="hidden" name="iv_order_line_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_order_line_no_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(15)%>">	
												<input type="hidden" name="iv_drug_class<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_drug_class<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(31)%>">
												<input type='hidden' name="iv_link_vaccine_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" id="iv_link_vaccine_code_<%=orderCount%>_<%=schCount%>_<%=schDayCount%>_<%=drugCount%>" value='<%=linkVacScheduleCode%>'>
<%
												}
											}
											else{
												if(MfrYN.equals("Y") ){
													MfrDetails=bean.getStatusOfMAR(order_id,"SCH");
													statusString="";
													displayStyle_1 = "color:blue;cursor:pointer;align:center;";//GHL-CRF-0458
													if(MfrDetails.size()>0){
														statusString=(String)MfrDetails.get(0);
														mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue();
														MFRCount=(String)MfrDetails.get(2);
													}
														if(!(hold.equals("Y")) && !(discontinued.equals("Y"))){													
																if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){ //GHL-CRF-0458 - start // isSiteSpecMARPrint changed to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953] 
																	
																patient_class_ord = bean.getOrderPatientClass(order_id);
																if(patient_class_ord==null)
																	patient_class_ord = "";
																if(patient_class_ord.equals("IP")){
																	ack_yn		 = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn); //iv_prep-yn added for MMS-KH-CRF-0039
																}


																if( WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ack_yn.equals("A") && patient_class_ord.equals("IP")){
																	statusString = "";
																	displayStyle_1 ="color:blue;cursor:pointer;align:center;display:none"; 
																}
																	//GHL-CRF-0458 - end
																}
																if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start
%>																									
															 <td class="<%=classvalue%>"id="MFR_status_column_<%=orderCount%>" rowspan='<%=rowsPan%>'><div id="order<%=scheKey%>" style='word-wrap:break-word;vertical-align:middle;<%=stDispHand%>'><label id="iv_MFR_dtls_<%=orderCount%>" name="iv_MFR_dtls_<%=orderCount%>" style="<%=displayStyle_1%>" onClick="" id='mfrRemarksLink_<%=orderCount%>'><font color="red" size='1'><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></font></a>
															
															</div></td>
<%
																} // if Added for KH-SCF-0010 - End
															   else{%>                                                                                                                      <td class="<%=classvalue%>"id="MFR_status_column_<%=orderCount%>" rowspan='<%=rowsPan%>'><div id="order<%=scheKey%>" style='word-wrap:break-word;vertical-align:middle;<%=stDispHand%>'><label id="iv_MFR_dtls_<%=orderCount%>" name="iv_MFR_dtls_<%=orderCount%>" style="<%=displayStyle_1%>" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','IV','<%=orderCount%>','<%=schCount%>','<%=dosage_seq_no%>','<%=sch%>','<%=sfrFLOW_STATUS%>','<%=dosage_seq_no%>','','','','','<%=cancelYn%>','<%=admin_by_name%>','<%=drug_desc%>');"><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/><br><%=statusString%></label><br><a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=mfrRemarks%>','Y');" id='mfrRemarksLink_<%=orderCount%>'><font color="red" size='1'><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></font></a>
															</div></td>
<%                                                       }
														}
														else {
															mfrCompletedStatus=false;
%>
															<td class="<%=classvalue%>" rowspan='<%=rowsPan%>'><div id="order<%=scheKey%>" style='word-wrap:break-word;vertical-align:middle;<%=stDispHand%>'><label id="iv_MFR_dtls_<%=orderCount%>" name="iv_MFR_dtls_<%=orderCount%>" style="font-size:9;color:black;align:center;" onClick=""><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/> <br><%=statusString%></label><br><a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=mfrRemarks%>','Y');" id='mfrRemarksLink_<%=orderCount%>'><font color="red" size='1'><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></font></a><div></td>
<%
														}
%>
														<input type="hidden" name="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=qty%>">
														<input type="hidden" name="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="N">
														<input type="hidden" name="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=modified_date_time%>">	
														<input type="hidden" name="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=dosage_seq_no%>">
														<input type="hidden" name="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=end_date_time%>">
														<input type="hidden" name="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=next_schd_date%>">
														<input type="hidden" name="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="N">
														<input type="hidden" name="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="N">
														<input type="hidden" name="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="">
														<input type="hidden" name="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sch_date_time%>">
														<input type="hidden" name="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sfrACT_START_DATE_TIME%>">
														<input type="hidden" name="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sch_infusion_rate%>">
														<input type="hidden" name="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sch_infusion_vol_str_unit%>">
														<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sch_infusion_vol_str_unit_desc%>"> 
														<input type="hidden" name="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sch_infusion_per_unit_table_date%>">
														
														<input type="hidden" name="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sch_infusion_period%>">
														<input type="hidden" name="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sch_infusion_period_unit%>">
														<input type="hidden" name="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=batch_id%>">
														<input type="hidden" name="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=expiry_date%>">
														<input type="hidden" name="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="">
														<input type="hidden" name="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=batch_id%>">
														<input type="hidden" name="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="expiry_date">
														<input type="hidden" name="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=trade_name%>" >
														<input type="hidden" name="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=trade_id%>">
														<input type="hidden" name="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="">
														<input type='hidden' name="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value='IV_Y'>
														<input type="hidden" name="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=iv_no_of_drug_per_order%>">
														<input type="hidden" name="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sfrFLOW_STATUS%>">
														<input type="hidden" name="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sfrHOLD_DATE_TIME%>">
														<input type="hidden" name="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sfrHOLD_DURN_IN_MINS%>">
														<input type="hidden" name="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="">
														<input type="hidden" name="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="">
														<input type="hidden" name="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sfrRESUME_DATE_TIME%>">
														<input type="hidden" name="MFR_end_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="MFR_end_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=sfrACT_END_DATE_TIME%>">
														<input type="hidden" name="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="0">
														<input type="hidden" name="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="0">
														<input type="hidden" name="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=dosage_type%>">
														<input type="hidden" name="completedMinutes<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="completedMinutes<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=completedMinutes%>">
														<input type="hidden" name="completedFlow<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="completedFlow<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=completedFlow%>">
														<input type="hidden" name="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=(Float.parseFloat(qty)+"")%>"> 
														<input type="hidden" name="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=iv_sch_date_tim%>"><!--Added for SKR-SCF-0913[Inc : 46556] -->
														<input type="hidden" name="totalNoOfRows<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" id="totalNoOfRows<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>" value="<%=MFRCount%>"><!--Added for SKR-SCF-0913[Inc : 46556] -->
<%
													}
													else{
%>
															<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;"  rowspan='<%=freqRowspan%>'>
<%
															ivSchDisplay = bean.getIVSchecdule(order_id, order_line_num, adminFromDateTime, adminToTime,iv_prep_yn,drug_code); //added iv_prep_yn,drug_code for SKR-SCF-1421
															ivSchDispStatus = ""; 
															schCount = 0;
															for(int ivSch=0; ivSch<ivSchDisplay.size();ivSch+=8){//6 CHANGED TO 8 FOR JD-CRF-0200
																dosage_seq_no = (String)ivSchDisplay.get(ivSch+5);
																sch_date_time = (String)ivSchDisplay.get(ivSch+1)+" "+(String)ivSchDisplay.get(ivSch+2);
																//sch_date_time = sfrACT_START_DATE_TIME;
																cancel_recorded_yn=(String)ivSchDisplay.get(ivSch+6);//ADDED FOR JD-CRF-0200
																can_act_sch=(String)ivSchDisplay.get(ivSch+7);//ADDED FOR JD-CRF-0200
																
																scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+dosage_seq_no;//ivSch Added for identified issues fix
																if(!com.ehis.util.DateUtils.isBefore((String)ivSchDisplay.get(ivSch+1), to_time, "DMY", locale))
																	break;
																sfrFLOW_STATUS = (String)ivSchDisplay.get(ivSch+3);
																schCanAdmin = (String)ivSchDisplay.get(ivSch+4);
																if(!dosage_seq_no.equals("1") && alTmpOrderSchDetail.size()>schCount+1){
																	iv_drug_details =(ArrayList)alTmpOrderSchDetail.get(schCount+1);
																	if(dosage_seq_no.equals((String)iv_drug_details.get(13))){
																		schCount++;
																		admin_recorded_yn  = (String)iv_drug_details.get(23);
																		sch_infusion_rate			= (String)iv_drug_details.get(1);
																		iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]

																		if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
																			if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
																				sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
																			}
																		}
																		sch_date_time            =   (String)iv_drug_details.get(12);
																		qty						 =	 (String)iv_drug_details.get(16);
																		if(Float.parseFloat(qty) < 1)
																			qty="0"+qty; 

																		qty_uom					 =	 (String)iv_drug_details.get(17);
																		discontinued			 =	 (String)iv_drug_details.get(18);
																		hold					 =	 (String)iv_drug_details.get(19);
																		sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
																		
																		sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
																		administered_yn			 =	 (String)iv_drug_details.get(22);
																		end_date_time 			 =   (String)iv_drug_details.get(33);
																		start_date_time			=	(String)iv_drug_details.get(69);
																		iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
																		
																		
																		next_schd_date =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);
																		//sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
																		sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
																		sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
																		if(sfrHOLD_DURN_IN_MINS.equals(""))
																			sfrHOLD_DURN_IN_MINS="0";
																		sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
																		sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
																		if(!(sfrACT_START_DATE_TIME.equals(""))){
																			sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
																		}
																		
																		if(sfrACT_START_DATE_TIME.equals("")){
																			sfrACT_START_DATE_TIME=current_date_time;
																		}
																		sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
																		dosage_type				 =(String)iv_drug_details.get(61);
																		mfrRemarks				 =	(String)iv_drug_details.get(62);
																		completedMinutes		 =	(String)iv_drug_details.get(63);
																		if(completedMinutes.equals(""))
																			completedMinutes = "0";
																		completedFlow			 =	(String)iv_drug_details.get(64);
																		if(completedFlow.equals(""))
																			completedFlow = "0";
																		adr_count			= bean.getADRCount(patient_id_test,drug_code);   
																		schDate			 =	(String)iv_drug_details.get(71);
																		//schCanAdmin			 =	(String)iv_drug_details.get(71);
																		ord_hold_date_time			 =	(String)iv_drug_details.get(75);
																		ord_disc_date_time			 =	(String)iv_drug_details.get(76);

																		if(!mfrRemarks.equals(""))
																			mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");

																		remarks = iv_drug_details.get(24)==null?"Not Entered":(String)iv_drug_details.get(24);				
								admin_by_name   = (String)iv_drug_details.get(26);
								auth_by_name    = (String)iv_drug_details.get(32);

								if(showTitle.length()>0)
									showTitle.setLength(0);
								if(remarks!=null && !remarks.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
								if(admin_by_name!=null && !admin_by_name.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
								if(auth_by_name!=null && !auth_by_name.equals("")){
									showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								}

																		admin_date_time = "";
																		if(iv_drug_details.get(27)!= null)
																			admin_date_time = (String)iv_drug_details.get(27);
																		modified_date_time = "";
																		if(iv_drug_details.get(28)!= null)
																			modified_date_time = (String)iv_drug_details.get(28);	
																	}
																}

																stDispHand="";
																sfrFLOW_STATUS_String="";
																ivSchDispStatus="";
																if(sfrFLOW_STATUS.equals("NS")){
																	sfrFLOW_STATUS_String="";
																}
																else if(sfrFLOW_STATUS.equals("ST")){
																	sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
																}
																else if(sfrFLOW_STATUS.equals("HO")){
																	sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
																}
																else if(sfrFLOW_STATUS.equals("RE")){
																	sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
																}
																else if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){
																	sfrFLOW_STATUS_String = "";
																	stDispHand = "BACKGROUND-COLOR:green;COLOR:white;;cursor:pointer;";
																}
																if(schCanAdmin.equals("Y") || !sfrFLOW_STATUS.equals("NS"))
																	displayStyle="font-size:8;color:blue;align:center;cursor:pointer;";
																else
																	displayStyle="font-size:8;color:black;align:center;";
																if(!sfrFLOW_STATUS.equals("CO"))
																	administered_yn="N";
																if(!sfrFLOW_STATUS.equals("NS") && !sfrFLOW_STATUS.equals("CO"))
																	ivSchDispStatus = sfrFLOW_STATUS_String+" <br>";
																if(!dispDate.equals((String)ivSchDisplay.get(ivSch+1)) && !nextDaySch){ //IV infuse schedule continius to next day
																	schDayCount++;
																	dayCount++;
																	nextDaySch = true;
%>
																	&nbsp;</td>
																	<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;"  rowspan='<%=freqRowspan%>'>
<%
																}
																if(schCanAdmin.equals("Y") ){ //IV infuse schedule can be administered
																if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){ //GHL-CRF-0458 - start // isSiteSpecMARPrint changed to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
																	
																patient_class_ord = bean.getOrderPatientClass(order_id);
																if(patient_class_ord==null)
																	patient_class_ord = "";
																if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")){
																	ack_yn		 = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn); //iv_prep_yn added for MMS-KH-CRF-0039
																	if(ack_yn==null) //MMS-KH-CRF-0017
																		ack_yn = "";
																}
  
																	if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ack_yn.equals("A") && patient_class_ord.equals("IP") &&  !iv_prep_yn.equals("8")) //!iv_prep_yn.equals("2") && !iv_prep_yn.equals("4") && !iv_prep_yn.equals("6") added for MMS-KH-CRF-017
																		displayStyle = "";
																		//GHL-CRF-0458 - end
																	}																	
																if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
																	displayStyle = "";
																	stDispHand = "";
																 } // Added for KH-SCF-0010 - End
%>
																	<div id="order<%=scheKey%>" style='vertical-align:middle;<%=stDispHand%>'>	
<%
																	if(!sfrFLOW_STATUS.equals("NS")){
																		if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){
%>                                                                        <!--cancelYn,admin_by_name,drug_desc,scheKey added for JD-CRF-0200 -->
																			<label style='vertical-align:middle;<%=stDispHand%>;' title='<%=showTitle.toString()%>' onClick="openAuditLogWindowIV('<%=orderCount%>','SFR','SCH','<%=dosage_seq_no%>', '<%=schCount%>','<%=cancelYn%>','<%=admin_by_name%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=scheKey%>','<%=qty%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=patient_id_test%>','<%=encounter_id%>','','');"><b><br>(<%=(String)ivSchDisplay.get(ivSch)%>)</b></label><!--modified for MMS-KH-SCF-0064 --><!-- Modified for IN073378 -->
<%
																		}
																		else{
																		if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start
%>													
																		  <label style='vertical-align:middle;<%=displayStyle%>;<%=stDispHand%>' onClick=""><B><%=ivSchDispStatus%></B></label>
<%
																		} // if Added for KH-SCF-0010 - End
																	   else{
%>
																			<label style='vertical-align:middle;<%=displayStyle%>;<%=stDispHand%>' onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','IV','<%=orderCount%>','<%=schCount%>','<%=dosage_seq_no%>','<%=sch%>','<%=sfrFLOW_STATUS%>','<%=dosage_seq_no%>','<%=rowsPan%>');"><B><%=ivSchDispStatus%></B></label>
<%
																		  } 
%>																		<label style="vertical-align:middle;" ><%=(String)ivSchDisplay.get(ivSch+2)%></label>
																			<br>(<%=(String)ivSchDisplay.get(ivSch)%>)&nbsp;
<%
																		}
																	}
																	else{
																		if(marForDisPatNotReqYN && dischargedYN || displayStyle.equals("")){ // if Added for KH-SCF-0010 - Start // || displayStyle.equals("") Added for MMS-KH-CRF-0014 [IN:067953] 
%>													
																		  <label style="vertical-align:middle;<%=displayStyle%>;" onClick=""><b><%=(String)ivSchDisplay.get(ivSch+2)%></b></label><br>(<%=(String)ivSchDisplay.get(ivSch)%>)&nbsp;
<%
																		} // if Added for KH-SCF-0010 - End
																	   else{if(cancel_recorded_yn.equals("Y")){
%>
																		<label style="vertical-align:middle;<%=displayStyle%>;" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','IV','<%=orderCount%>','<%=schCount%>','<%=dosage_seq_no%>','<%=sch%>','<%=sfrFLOW_STATUS%>','<%=dosage_seq_no%>','<%=rowsPan%>');"><b><%=can_act_sch%></b></label><br>(<%=(String)ivSchDisplay.get(ivSch)%>)&nbsp;
<%
																	}
																	   else{%>
																		<label style="vertical-align:middle;<%=displayStyle%>;" onClick="dispAdminOptions('<%=scheKey%>','<%=administered_yn%>','<%=admin_recorded_yn%>','IV','<%=orderCount%>','<%=schCount%>','<%=dosage_seq_no%>','<%=sch%>','<%=sfrFLOW_STATUS%>','<%=dosage_seq_no%>','<%=rowsPan%>');"><b><%=(String)ivSchDisplay.get(ivSch+2)%></b></label><br>(<%=(String)ivSchDisplay.get(ivSch)%>)&nbsp;
																		<%   }
																	   }
%>
																	</div>
																	<%if(cancel_recorded_yn.equals("Y")){%>
														<img src="../../ePH/images/history1.jpg" align="center"  width="17" height="17"  title="Cancel History" onclick="cancelHistory('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=dosage_seq_no%>','<%=patient_id_test%>','<%=encounter_id%>','<%=admin_date_time%>')"></img><!--modified for MMS-KH-SCF-0064 -->
													<%}%>
<%
																}
                                                               }
																else{ //IV infuse schedule can not administer
%>
																	<div id="order<%=scheKey%>" style='vertical-align:middle;<%=stDispHand%>'>
<%
																		if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){
%>
																			<!--cancelYn,admin_by_name,drug_desc,scheKey added for JD-CRF-0200 -->
																	<label style='vertical-align:middle;<%=stDispHand%>;' onClick="openAuditLogWindowIV('<%=orderCount%>','SFR','SCH','<%=dosage_seq_no%>', '<%=schCount%>','<%=cancelYn%>','<%=admin_by_name%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=scheKey%>','<%=qty%>','<%=admin_date_time%>','<%=strength_per_value_pres_uom%>','<%=drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=iv_prep_yn%>','<%=sch_date_time%>','<%=patient_id_test%>','<%=encounter_id%>','<%=sch_infusion_per_unit_table_date%>','<%=sch_infusion_vol_str_unit_desc%>');"><b>(<%=(String)ivSchDisplay.get(ivSch)%>)<br></b></label><!--modified for MMS-KH-SCF-0064 --><!-- Modified for IN073378 -->
<%
																		}
																		else{
%>
																			<%=ivSchDispStatus%>
																			<label style="vertical-align:middle;<%=displayStyle%>;"><%=(String)ivSchDisplay.get(ivSch+2)%></label><br>(<%=(String)ivSchDisplay.get(ivSch)%>)&nbsp;
<%
																		}
%>
																	</div>
<%
																}
																drugCount= 0;
																for(drugIndex=1; drugIndex<=rowsPan; drugIndex++){ 
																	if(alTmpOrderSchDetail.size() >= (rowsPan * Integer.parseInt(dosage_seq_no)) )
																		iv_drug_details =(ArrayList)alTmpOrderSchDetail.get( ((drugIndex-1) * (alTmpOrderSchDetail.size()/rowsPan)) +(Integer.parseInt(dosage_seq_no)-1) );
																	else
																		iv_drug_details =(ArrayList)alTmpOrderSchDetail.get( ((drugIndex-1) * (alTmpOrderSchDetail.size()/rowsPan)) +((alTmpOrderSchDetail.size()/rowsPan)-1));
																	if(dosage_seq_no.equals((String)iv_drug_details.get(13))){
																		drugCount++;
																		admin_recorded_yn  = (String)iv_drug_details.get(23);
																		sch_infusion_rate			= (String)iv_drug_details.get(1);
																		iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]
																		if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
																			if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
																				sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
																			}
																		}
																		sch_date_time            =   (String)iv_drug_details.get(12);
																		qty						 =	 (String)iv_drug_details.get(16);
																		if(Float.parseFloat(qty) < 1)
																			qty="0"+qty; 

																		qty_uom					 =	 (String)iv_drug_details.get(17);
																		discontinued			 =	 (String)iv_drug_details.get(18);
																		hold					 =	 (String)iv_drug_details.get(19);
																		sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
																		
																		sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
																		administered_yn			 =	 (String)iv_drug_details.get(22);
																		end_date_time 			 =   (String)iv_drug_details.get(33);
																		start_date_time			=	(String)iv_drug_details.get(69);
																		iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
																		
																		
																		next_schd_date =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);
																		//sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
																		sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
																		sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
																		if(sfrHOLD_DURN_IN_MINS.equals(""))
																			sfrHOLD_DURN_IN_MINS="0";
																		sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
																		sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
																		if(!(sfrACT_START_DATE_TIME.equals(""))){
																			sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
																		}
																		
																		if(sfrACT_START_DATE_TIME.equals("")){
																			sfrACT_START_DATE_TIME=current_date_time;
																		}
																		sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
																		dosage_type				 =(String)iv_drug_details.get(61);
																		mfrRemarks				 =	(String)iv_drug_details.get(62);
																		completedMinutes		 =	(String)iv_drug_details.get(63);
																		if(completedMinutes.equals(""))
																			completedMinutes = "0";
																		completedFlow			 =	(String)iv_drug_details.get(64);
																		if(completedFlow.equals(""))
																			completedFlow = "0";
																		adr_count			= bean.getADRCount(patient_id_test,drug_code);   
																		schDate			 =	(String)iv_drug_details.get(71);
																		ord_hold_date_time			 =	(String)iv_drug_details.get(75);
																		ord_disc_date_time			 =	(String)iv_drug_details.get(76);

						if(!mfrRemarks.equals(""))
									mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");
								remarks = iv_drug_details.get(24)==null?"Not Entered":(String)iv_drug_details.get(24);				
								admin_by_name   = (String)iv_drug_details.get(26);
								auth_by_name    = (String)iv_drug_details.get(32);
								if(showTitle.length()>0)
									showTitle.setLength(0);
								if(remarks!=null && !remarks.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
								if(admin_by_name!=null && !admin_by_name.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
								if(auth_by_name!=null && !auth_by_name.equals("")){
									showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								}

																		admin_date_time = "";
																		if(iv_drug_details.get(27)!= null)
																			admin_date_time = (String)iv_drug_details.get(27);
																		modified_date_time = "";
																		if(iv_drug_details.get(28)!= null)
																			modified_date_time = (String)iv_drug_details.get(28);	
																			linkVacScheduleCode		 =	(String)iv_drug_details.get(53);
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
%>
																		<input type="hidden" name="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="h_iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=qty%>">
																		<input type="hidden" name="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_admin_chng_dtls_req_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="N">
																		<input type="hidden" name="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_modified_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=modified_date_time%>">	
																		<input type="hidden" name="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_dosage_seq_no_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=dosage_seq_no%>">
																		<input type="hidden" name="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_end_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=end_date_time%>">
																		<input type="hidden" name="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="next_schd_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=next_schd_date%>">
																		<input type="hidden" name="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_dtls_yn<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="N">
																		<input type="hidden" name="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_Remarks<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="N">
																		<input type="hidden" name="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_qty_in_disp_mode_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="">
																		<input type="hidden" name="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_admin_date_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sch_date_time%>">
																		<input type="hidden" name="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_infusion_st_time_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sfrACT_START_DATE_TIME%>">
																		<input type="hidden" name="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_flow_rate_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sch_infusion_rate%>">
																		<input type="hidden" name="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sch_infusion_vol_str_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sch_infusion_vol_str_unit%>">
																		<input type="hidden" name="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sch_infusion_vol_str_unit_desc<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sch_infusion_vol_str_unit_desc%>"> 
																		<input type="hidden" name="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sch_infusion_per_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sch_infusion_per_unit_table_date%>">
																		
																		<input type="hidden" name="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_infusion_period_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sch_infusion_period%>">
																		<input type="hidden" name="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sch_infusion_period_unit_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sch_infusion_period_unit%>">
																		<input type="hidden" name="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="previous_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=batch_id%>">
																		<input type="hidden" name="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="previous_exp_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=expiry_date%>">
																		<input type="hidden" name="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="previous_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="">
																		<input type="hidden" name="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_batch_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=batch_id%>">
																		<input type="hidden" name="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_expiry_date_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="expiry_date">
																		<input type="hidden" name="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_trade_name_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=trade_name%>" >
																		<input type="hidden" name="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_trade_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=trade_id%>">
																		<input type="hidden" name="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_bin_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="">
																		<input type='hidden' name="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="IV_Newly_administerderd_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value='IV_Y'>
																		<input type="hidden" name="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_no_of_drug_per_order_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=iv_no_of_drug_per_order%>">
																		<input type="hidden" name="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sfrFLOW_STATUS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sfrFLOW_STATUS%>">
																		<input type="hidden" name="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sfrHOLD_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sfrHOLD_DATE_TIME%>">
																		<input type="hidden" name="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sfrHOLD_DURN_IN_MINS<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sfrHOLD_DURN_IN_MINS%>">
																		<input type="hidden" name="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="durn_bw_std_resumed_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="">
																		<input type="hidden" name="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="flow_rate_changed_YN<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="">
																		<input type="hidden" name="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sfrRESUME_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sfrRESUME_DATE_TIME%>">
																		<input type="hidden" name="sfrACT_END_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="sfrACT_END_DATE_TIME<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=sfrACT_END_DATE_TIME%>">
																		<input type="hidden" name="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="inf_prd_hrs<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="0">
																		<input type="hidden" name="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="inf_prd_min<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="0">
																		<input type="hidden" name="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_dosage_type_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=dosage_type%>">
																		<input type="hidden" name="completedMinutes<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="completedMinutes<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=completedMinutes%>">
																		<input type="hidden" name="completedFlow<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="completedFlow<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=completedFlow%>">
																		<input type="hidden" name="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_admin_qty_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=(Float.parseFloat(qty)+"")%>"> 
																		<input type="hidden" name="iv_qty_uom_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_qty_uom_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=qty_uom%>">
																		<input type="hidden" name="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_sch_date_tim_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=iv_sch_date_tim%>"><!--Added for SKR-SCF-0913[Inc : 46556] -->

																		<input type="hidden" name="iv_drug_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_drug_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(10)%>">
																		<input type="hidden" name="iv_item_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_item_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(8)%>">
																		<input type="hidden" name="iv_order_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_order_id_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>"  value="<%=(String)iv_drug_details.get(14)%>">
																		<input type="hidden" name="iv_order_line_no_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_order_line_no_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(15)%>">	
																		<input type="hidden" name="iv_drug_class<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_drug_class<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value="<%=(String)iv_drug_details.get(31)%>">
																		<input type='hidden' name="iv_link_vaccine_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" id="iv_link_vaccine_code_<%=orderCount%>_<%=schCount%>_<%=dosage_seq_no%>_<%=drugCount%>" value='<%=linkVacScheduleCode%>'>
<%
																	}
																}
															}
%>
															</td>
<%
														}
													}
													break;
												}
												else{ //iv no schedule day td before schedule day from start day of week till schedule daye all iv types
%>
													<td class='<%=classvalue%>' width='5%'  style="word-wrap:break-word;text-align:center;font-size:9;" rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
												}
											}
											else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){ //iv no schedule day td
												schDayCount++;
												dayCount++;
%>
												<td class='<%=classvalue%>' width='5%' rowspan='<%=freqRowspan%>' style="font-size:9;word-wrap:break-word;">&nbsp;</td>
<%
											}
											else
												dayCount++;
										}
									}
									if(!(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4"))){
										for(;schDayCount<(daySize/2); schDayCount++){ //iv no schedule day td after schedule day till end of week
%>
											<td class='<%=classvalue%>' width='5%'  style="font-size:9;word-wrap:break-word;"  rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
										}
									}
								}
								if(!(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4"))){
									schDayCount=0;
									dayCount = 0;
%>
									</tr>											
<%
								}
							}
%>
							<input type="hidden" name="MfrYN<%=orderCount%>" id="MfrYN<%=orderCount%>" value="<%=MfrYN%>">
							<input type="hidden" name="iv_mfrRemarks<%=orderCount%>" id="iv_mfrRemarks<%=orderCount%>" value="<%=mfrRemarks%>">		
							<input type="hidden" name="iv_drug_code_<%=orderCount%>" id="iv_drug_code_<%=orderCount%>" value="<%=drug_code%>">
							<input type="hidden" name="iv_dispense_drug_code_<%=orderCount%>" id="iv_dispense_drug_code_<%=orderCount%>" value="<%=dispense_drug_code%>">
							<input type="hidden" name="iv_drug_desc_<%=orderCount%>" id="iv_drug_desc_<%=orderCount%>" value="<%=drug_desc%>">
							<input type="hidden" name="iv_item_code_<%=orderCount%>" id="iv_item_code_<%=orderCount%>" value="<%=item_code%>">
							<input type="hidden" name="iv_order_id_<%=orderCount%>" id="iv_order_id_<%=orderCount%>"  value="<%=order_id%>">
							<input type="hidden" name="iv_order_line_no_<%=orderCount%>" id="iv_order_line_no_<%=orderCount%>" value="<%=order_line_num%>">	
							<input type="hidden" name="iv_store_code_<%=orderCount%>" id="iv_store_code_<%=orderCount%>" value="<%=store_code%>">	
							<input type="hidden" name="iv_drug_class<%=orderCount%>" id="iv_drug_class<%=orderCount%>" value="<%=drug_class%>">
							<input type="hidden" name="iv_order_pract_id_<%=orderCount%>" id="iv_order_pract_id_<%=orderCount%>" value="<%=iv_order_pract_id%>"> 
							<input type="hidden" name="iv_prep_yn<%=orderCount%>" id="iv_prep_yn<%=orderCount%>" value="<%=iv_prep_yn%>"> 
							<input type="hidden" name="freq_code<%=orderCount%>" id="freq_code<%=orderCount%>" value="<%=freq_code%>"> 
							<input type="hidden" name="iv_Auto_Admin_<%=orderCount%>" id="iv_Auto_Admin_<%=orderCount%>" value="<%=iv_Auto_Admin%>">
							<input type="hidden" name="disp_locn_code<%=orderCount%>" id="disp_locn_code<%=orderCount%>"		value="<%=Store_locn_code%>">
							<input type='hidden' name="iv_discontinued<%=orderCount%>" id="iv_discontinued<%=orderCount%>" value='<%=discontinued%>'>
							<input type='hidden' name="iv_hold<%=orderCount%>" id="iv_hold<%=orderCount%>" value='<%=hold%>'>
							<input type='hidden' name="iv_link_vaccine_code_<%=orderCount%>" id="iv_link_vaccine_code_<%=orderCount%>" value='<%=linkVacScheduleCode%>'>
<%
							orderCount++;
							if(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")){
								for(;schDayCount<(daySize/2); schDayCount++){
%>
									<td class='<%=classvalue%>' width='5%'  style="font-size:9;word-wrap:break-word;"  rowspan='<%=freqRowspan%>'>&nbsp;</td>
<%
								}

								schDayCount=0;
								dayCount = 0;
%>
							</tr>
<%
							if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0 && schSize ==1){
								//rowsPan = 2;
								//freqRowspan=2;
								//schRowspan=2;
								drugRowspan=1;
							//	fluidRowspan=1;
								ivnextRow = true;
								IVclassvalue="IVINGREDIENT1";
								alTmpIVPBDrugDtls = (ArrayList)alIVPBDrugSchList.get(0);
								ivPB_drug_code                =   (String)alTmpIVPBDrugDtls.get(10);
								ivPB_drug_desc                =   (String)alTmpIVPBDrugDtls.get(11);
								ivPB_encode_drug_desc         =   ivPB_drug_desc.replaceAll(" ","%20");
								ivPB_encode_drug_desc         =   java.net.URLEncoder.encode(ivPB_encode_drug_desc,"UTF-8");
								ivPB_encode_drug_desc         =   ivPB_encode_drug_desc.replaceAll("%2520","%20");						
								ivPB_ext_prod_id              =   (String)alTmpIVPBDrugDtls.get(44);
								//iv_no_of_drug_per_order  =   (String)alTmpIVPBDrugDtls.get(45);
								ivPB_trade_code			     =   (String)alTmpIVPBDrugDtls.get(46);
								ivPB_imageFileURL			 =   (String)alTmpIVPBDrugDtls.get(47);
								//drug_class = (String)alTmpIVPBDrugDtls.get(31);
								drug_class_ind = bean.getDrugClassInd((String)alTmpIVPBDrugDtls.get(31));

								adr_count			= bean.getADRCount(patient_id_test,ivPB_drug_code); 
								ivPB_sch_infusion_rate = bean.getIVPBSchInfusionRate((String)alTmpIVPBDrugDtls.get(1));
								//sch_infusion_vol_str_unit	= (String)alTmpIVPBDrugDtls.get(2);
								ivPB_sch_infusion_vol_str_unit_desc = (String)alTmpIVPBDrugDtls.get(66);
								ivPB_sch_infusion_per_unit = bean.getIVPBschInfusionUnit((String)alTmpIVPBDrugDtls.get(3));
								
								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);

%>
								<tr>
								<td class="<%=IVclassvalue%>" width='19%' style="word-wrap:break-word;font-size:9;<%=drug_class_ind%>"  rowspan='<%=drugRowspan%>'>
<%
								if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
									<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="loadPage('<%=ivPB_drug_code%>');" id="drug_mast_det_<%=orderCount%>">&nbsp;+&nbsp;</label>
<%
								}
%>
								<label style="font-size:9;font-weight:bold;color:black" title="<%=prod_name%>"><%=ivPB_drug_desc%> &nbsp;&nbsp;
<%
								if( !ivPB_ext_prod_id.equals("")){
%>
									<img src="../../ePH/images/info.gif" align="center"  width="17" height="17" style="cursor:pointer;" onClick="showDrugInfo('<%=ivPB_ext_prod_id%>','<%=ivPB_encode_drug_desc%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")%>"></img>
<%
								}
								if(!ivPB_imageFileURL.equals("")){
%>
									<img src='../../ePH/images/camera.gif' width='17' height='15' onclick = "showImage('<%=ivPB_drug_code%>','<%=ivPB_trade_code%>');" onmouseover="changeCursor(this);">
<%
								}
								if(adr_count>0){
%>
									<img  id="ADR_img" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick = "callADRdetails('<%=patient_id_test%>','<%=ivPB_drug_code%>');"></img>
<%
								} 
								if(!iv_prep_yn.equals("4")){
%>
									<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=ivPB_drug_code%>');" onmouseover="changeCursor(this);">
<%													
								}
%>
								</label>		
								<br>
								<label><fmt:message key="ePH.TotalVolume.label" bundle="${ph_labels}"/>&nbsp;=&nbsp;<%=ivPB_qty%>&nbsp;<%=ivPB_qty_uom%>
								</label>
								</td>
								<td class='<%=classvalue%>' width='7%' style="word-wrap:break-word;font-size:9;" wrap rowspan='<%=drugRowspan%>'> <%=ivPB_sch_infusion_rate%>&nbsp;<%=ivPB_sch_infusion_vol_str_unit_desc%>/<%=ivPB_sch_infusion_per_unit%></td>
								</tr>
<%
							}
						}
					}
%>
					</table>
				</div>
<%
			}
%>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_all_stages,bean_all_stages,request);
//	putObjectInBean(drug_search_bean_id,drug_bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>

