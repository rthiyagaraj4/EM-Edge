<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import ="com.ehis.persist.PersistenceHelper" %>
<%@page import="ePH.IVPrescriptionBean"%>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<script src="${path}/eIPAD/js/pharmIvRxDetailsViewWithAdd.js"></script> 
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String dose_uom = "";
	String pres_base_uom = "";
	String locale			= (String)session.getAttribute("LOCALE");
	Locale appLocale;
	if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
	else 
	appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 	
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
	String selected_drug_codes = "";
	String ph_version =	(String)PhLicenceRights.getKey();
	String facility_id = patientContext.getFacilityId();
	String patient_id = patientContext.getPatientId();
	String patient_class = patientContext.getPatientClass();
	String encounter_id = patientContext.getEncounterId();
	String resp_id = patientContext.getResponsibilityID();
	String pract_id = patientContext.getClinicianId();
	String location_code = patientContext.getLocationCode();
	String location_type = patientContext.getLocationType();	
	String infuse_overs="";
	String infuse_over_hrs="";
	String  infuse_over_mis="";
	String  infusion_rates="";
	String  infuse_over_unitss="";
	String  duration_drun="24";
	String START_DATE ="";
	String END_DATE ="";
	String VOLUME_VALUE="";
	String disp_strs ="";	
	String bl_install_yn = (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
	String mode		= CommonRepository.getCommonKeyValue( "MODE_INSERT" ); 
	String sys_date = "";		
	String bean_id_IVD		= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
	String bean_name_IVD	= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
	bean_IVD.setLanguageId(locale);
	bean_IVD.setPatId(patient_id);
	bean_IVD.setEncId(encounter_id);	
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();	
	HashMap drug_detail =	null;
	HashMap fluid_details = null;	
	ArrayList	presDetails	= (ArrayList) bean_IVD.getDrugDetails();	
	HashMap drugDetails			= (HashMap)presDetails.get(0);
	fluid_details = bean_IVD.getFluidDetails();
	String disp_location;
	if(fluid_details.get("DISP_LOCN_DESC") == null){
		disp_location = (String)drugDetails.get("DISP_LOCN_DESC");
	}else{
		disp_location = (String)fluid_details.get("DISP_LOCN_DESC");
	}
	VOLUME_VALUE=bean_IVD.getVOLUME();
	String  iv_calc_infuse_bys=bean_IVD.getIVCalcInfuseBy();
	if(iv_calc_infuse_bys.equals("I"))
		duration_drun = "24";
	else
		duration_drun = (String)fluid_details.get("DURN_VALUE");			
		String  END_DATES  =	(String)fluid_details.get("END_DATE")==null?"":(String)fluid_details.get("END_DATE");
		String  START_DATES= (String)fluid_details.get("START_DATE")==null?"":(String)fluid_details.get("START_DATE");	
     infuse_overs=	(String)fluid_details.get("SCH_INFUSION_RATE")==null?"":(String)fluid_details.get("SCH_INFUSION_RATE");	
	infuse_over_hrs =(String)fluid_details.get("INFUSION_PERIOD_VALUE")==null?"":(String)fluid_details.get("INFUSION_PERIOD_VALUE");	
	infuse_over_mis = (String)fluid_details.get("INFUSION_PERIOD_VALUE_MIN")==null?"":(String)fluid_details.get("INFUSION_PERIOD_VALUE_MIN");	
	infusion_rates = (String)fluid_details.get("INFUSION_RATE")==null?"":(String)fluid_details.get("INFUSION_RATE");	
	infuse_over_unitss =(String)fluid_details.get("INFUSE_OVER_UNIT")==null?"":(String)fluid_details.get("INFUSE_OVER_UNIT");		
	disp_strs="["+infuse_over_hrs+" Hrs "+infuse_over_mis+" Mins]";	
	String iv_calc_infuse_by=bean_IVD.getIVCalcInfuseBy();	
	sys_date=(String) bean_IVD.getSysdate();
	/* Loading default values into kendo dropdowns */
	String calculateByValues = "";
	String admix_value = "N";
	calculateByValues = calculateByValues + "<OPTION VALUE='D' SELECTED>Dosage</OPTION>";
	calculateByValues = calculateByValues + "<OPTION VALUE='B'>Body wt/BSA</OPTION>"; 	
	String dosageByValues = "";
	dosageByValues = dosageByValues + "<OPTION VALUE='S' SELECTED>Strength</OPTION>";
	dosageByValues = dosageByValues + "<OPTION VALUE='Q'>Quantity</OPTION>"; 	
	String dosageUnitValues = "";
	dosageUnitValues = dosageUnitValues + "<OPTION VALUE='P' SELECTED>Vial(s)</OPTION>";
	dosageUnitValues = dosageUnitValues + "<OPTION VALUE='S' SELECTED>VIAL</OPTION>";
    String dosageStrengthValues = "";
	dosageStrengthValues = dosageStrengthValues + "<OPTION VALUE='M' SELECTED>MG</OPTION>";	
	String bodyWtDoseValues = "";
	bodyWtDoseValues = bodyWtDoseValues + "<OPTION VALUE='M' SELECTED>MG</OPTION>";			
	String dosageUnitDetailedValues = "";	
	/* Loading default values into kendo dropdowns ends */

	int durn_int = Integer.parseInt(duration_drun);
	
	 if(durn_int==0){
		
		duration_drun="24";
		
	} 
	
	/* Banner Indicator Starts */
	String drugDesc ="";
	ArrayList frequencyDetails = bean_IVD.getFrequency();
	String freq_code = "";
	String freq_desc = "";
	if(frequencyDetails.size() > 0){
		freq_code = (String)frequencyDetails.get(0);
		freq_desc = (String)frequencyDetails.get(1);
	}	
	String bl_disp_charge_dtl_in_rx_yn	= "N";	
	String drug_db_interface_yn			= "N";
	String drug_db_product_id			= "";
	String drug_db_dosecheck_yn			= "N";
	String drug_db_duptherapy_yn		= "N";
	String drug_db_interact_check_yn	= "N";
	String drug_db_contraind_check_yn	= "N";
	String drug_db_allergy_check_yn		= "N";	
	String ex_bean_id				= "@ExternalProductLinkBean";
	String ex_bean_name				= "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex  = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);	
	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );	
	String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
	if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>6){
		drug_db_interface_yn			=	sDrugDBAllChecks[0];    
		drug_db_product_id			=	sDrugDBAllChecks[1];    
		drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
		drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
		drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
		drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
		drug_db_allergy_check_yn		=	sDrugDBAllChecks[6];    
	}
	param_bean.clear();			
	ArrayList exProd				= new ArrayList();
	ArrayList aDrugDesc				= new ArrayList();
	HashMap details = null;	
	String FUTURE_DATE = "";
	for(int k=0;k<presDetails.size();k++){
		drug_detail				=   (HashMap) presDetails.get(k);
		String ext_srl_no				=   (String) drug_detail.get("SRL_NO");
		if(!exProd.contains((String)drug_detail.get("EXTERNAL_PRODUCT_ID"))){
			aDrugDesc.add((String)drug_detail.get("DRUG_DESC"));
			if((String) drug_detail.get("EXTERNAL_PRODUCT_ID")!=null && !((String) drug_detail.get("EXTERNAL_PRODUCT_ID")).equals("")){
			       exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
			}
		}
		FUTURE_DATE = (String)drug_detail.get("FUTURE_DATE");	
	}
	
	HashMap   record = new HashMap();
	String infusion_rate		= "";
	String infuse_over			= "";
	String duration				= "24";
	String start_time			= "";
	String end_time				= "";
	String disabled				= "";
	String order_line_num		= "";
	String QTY_UNIT				= "";
	String renewOrderStartDate  = "";
	String selected1  = "selected";
	String selected2  = "";
	String timeFrame			= "";
	String infusion_period_uom ="H"; 
	String mfr_yn				= "";
	String disable_for_mfr		= "";
	String infuse_over_hr		= "";
	String infuse_over_mi		= "";
	String disp_str				= "";
	String infusionOverUnit		= "";	
	ArrayList exstngIVOrders = bean_IVD.getAllExistingIVOrders();
	if(exstngIVOrders.size() > 0) {
	record = (HashMap)exstngIVOrders.get(0);
	start_time = (String)record.get("START_DATE_TIME");
	end_time = (String)record.get("END_DATE_TIME");
	order_line_num = (String)record.get("ORDER_LINE_NUM");
	mfr_yn = (String)record.get("MFR_YN")==null?"":(String)record.get("MFR_YN");
	if(!mfr_yn.equals("Y")){
		infusion_rate = (String)record.get("INFUSION_RATE");
		infuse_over = (String)record.get("INFUSE_OVER");
		if(!infusion_rate.equals("")){
			if(Float.parseFloat(infusion_rate)<1 && Float.parseFloat(infusion_rate)>0)
			infusion_rate=Float.parseFloat(infusion_rate)+"";
		}
		if(infuse_over.indexOf(".") != -1){
			infuse_over_hr = infuse_over.substring(0,infuse_over.indexOf("."));
			Double temp = new Double(infuse_over);
			temp = temp*60;
			temp = (temp%60);
			infuse_over_mi = Math.round(temp)+"";
			if(infuse_over_mi.indexOf(".") != -1)
				infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); 
		}
		else{
			infuse_over_hr = infuse_over;
			infuse_over_mi = "";
		}
		infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
		infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
		disp_str = "["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";
		if(iv_calc_infuse_by.equals("I"))
			duration = "24";
		else
			duration = (String)record.get("DURN_VALUE");		
		QTY_UNIT  = (String)record.get("QTY_UNIT")==null?"":(String)record.get("QTY_UNIT");
		if(!QTY_UNIT.equals("")) 
			QTY_UNIT = QTY_UNIT+" / ";
		infusion_period_uom				=(String)record.get("INF_PERIOD_UNIT")==null?"H":(String)record.get("INF_PERIOD_UNIT");

		if(infusion_period_uom.equals("H")){
			selected2="";
			selected1="selected";
			infusionOverUnit="Hour(s)";
			infusion_period_uom="H";
		}
		else  if(infusion_period_uom.equals("M")){ 
			selected1="";
			selected2="selected";
			infusionOverUnit="Minute(s)";
		}
	}
	else{
		disable_for_mfr = "disabled";
		if(iv_calc_infuse_by.equals("I"))
			duration="24";
		else
			duration = (String)((HashMap)bean_IVD.getMFRRecs()).get("totDurnHrs");
	}
	}	
	String infusionRateDetails = "";
	//System.out.println("infuse_over_unitss : " + infuse_over_unitss);
	if(infuse_over_unitss.equals("M")) {
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='M' selected>Minute(s)</OPTION>";
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='H'>Hour(s)</OPTION>";
	}
	else {
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='M'>Minute(s)</OPTION>";
		infusionRateDetails = infusionRateDetails + "<OPTION VALUE='H' selected>Hour(s)</OPTION>";
	}
	if(infuse_over.equals("")) {
		infuse_over = bean_IVD.getINFUSE_OVER();
	}	
	/* Banner Indicator Ends */
%>
<div data-role = "none"  class = "blurPopup" onclick="" data-popid="" style="z-index:10000"></div>
<form id="formIVPrescriptionDetails" name = "formIVPrescriptionDetails" method = "post" action = "" class="ChartSummaryFormElem">		
	<div class="ChartSummaryBlockVar" id="rxDetailsSummaryBlock" data-role = "none">
			<div class="ChartSummaryMainTable" data-role = "none">
				<div data-role = "none" class ="ChartSummaryPageHeader">
               		<div class="ChartSummaryHeaderCell" data-role = "none">
                  		<div class="ChartSummaryHeaderCont" data-role = "none">
                     		<div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
                        		<div class="ChartSummaryHeaderRow" data-role = "none">
                           			<div class="ChartSummaryHeaderTextCol" data-role = "none">
                              			<div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">IV</div>
                           			</div>
                           			<div class="ChartSummaryHeaderEncRightCol" data-role="none">
                              			<div class="WidgetButtonTheme" data-role = "none" onclick="completeIvRxDetailsConfirm()"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
                           			</div>
		                           <div class="ChartSummaryHeaderEncRightCol" data-role="none">
		                              <div class="WidgetButtonTheme" data-role = "none" onclick="closeRxDetailsView()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
		                           </div>
                       	 		</div>
                     		</div>
                  		</div>
               		</div>
            	</div>
				<div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" id="">
					<div data-role = "none" class = "ChartSummaryPageContentCell">
						<div data-role = "none" class = "ChartSummaryMainWrapper pharmDataMainWrapper" id="" >
							<div class="ChartSummaryMainScroller pharmDataContentScroller"  data-role = "none">					 					 
								<div class="table" style="width:100%;height:100%;" data-role = "none">	
									<div  class="row ivrxDetailsViewHeaderRowWrapper" data-role = "none">
										<div class="cell"  data-role = "none">
	                                 		<div class="table" style="width:100%;height:75%;" data-role = "none">
			                                    <div  class="row pharmItemDescNameCell"  data-role = "none">
			                                       <div class="cell pharmRxOrderItemName segoeuiBold"  data-role = "none">
			                                          <span class="pharmRxOrderItemName10padding">IV with Additives
			                                          </span>
			                                       </div>                                      
			                                    </div>
			                                    <div  class="row pharmItemDescNameCell"  data-role = "none">
			                                       <div class="cell pharmRxOrderStrength"  data-role = "none">
												      <div class="pharmRxOrderItemDesc">
			                                             <label class="pharmRxOrderItemLabel">Dispense Location</label>
			                                             <span class="pharmRxOrderItemInfo segoeuiBold"><%=disp_location%></span>
			                                          </div>
			                                       </div>
			                                       <div class="cell pharmRxOrderItemRate"  data-role = "none">
			                                          <span class="pharmRxOrderItemRateDesc">-- / --</span>
			                                       </div>
			                                       <div class="cell pharmRxOrderItemRate"  data-role = "none">
			                                          <span class="pharmRxOrderItemRateLabel">Total / Patient</span>
			                                       </div>
			                                    </div>
			                                    <div  class="row pharmCartBottomContainer"  data-role = "none">
			                                       <div class="cell pharmCartBottomImg" data-role = "none">										 
			                                       </div>
			                                    </div>
	                                 		</div>
											<div class="table ivHeaderWrapper">
											    <div class="row fullHtFullWt">
												   <div class="cell ivHeaderWrapperContent">
												      <div  class="drugDetailsTab segoeuiBold"  id="IVRxDrugTab"  onclick="openDrugDetailsTab()">Drug Details</div> <!--to handle in jquery-->
													  <div class="adminDetailsTab segoeuiBold"   id="IVRxAdminTab" onclick="openAdminDetailsTab()">Administration Details</div>
												   </div>
												</div>
										 	</div>
	                              		</div>
	                           		</div>				   							   
	                           		<!-- Drug details tab starts-->									 
									<div id="drugDetailsIvRxScroller" class="row ivrxDetailsViewContentRowWrapper1"  data-role = "none">
	                               		<div class="detailsViewMainWrapper">
										   <div class="ivrxDrugHeader segoeuiBold">
											     Additive(s)/Drugs
								           </div>
				                           <%
				                           	if(presDetails.size()>0){
												for(int i=0;i<presDetails.size();i++){													
													dosageUnitDetailedValues = "";
				                           			drug_detail = (HashMap) presDetails.get(i);
													drugDesc = (String)drug_detail.get("SHORT_DESC"); 
													String strength = (String)drug_detail.get("ACT_STRENGTH_VALUE");
													String qtyDesc = (String)drug_detail.get("QTY_DESC"); 
													String qty_value = (String)drug_detail.get("QTY_VALUE");
													String strength_uom_desc	= (String)drug_detail.get("STRENGTH_UOM_DESC");
													String dosage_type			= (String)drug_detail.get("DOSAGE_TYPE");
													String qty_desc_code		= (String)drug_detail.get("QTY_DESC_CODE");
													String drug_code = (String)drug_detail.get("DRUG_CODE");
													String start_date = (String)drug_detail.get("START_DATE");
													String strength_uom = (String)drug_detail.get("STRENGTH_UOM");
													String strength_value = (String)drug_detail.get("STRENGTH_VALUE"); 
													String strength_per_pres_uom =  (String)drug_detail.get("STRENGTH_PER_PRES_UOM");
													String pres_qty_value		= (String)drug_detail.get("PRES_QTY_VALUE");
													pres_base_uom =  (String)drug_detail.get("PRES_BASE_UOM");
													String pres_base_uom_desc =  (String)drug_detail.get("PRES_BASE_UOM_DESC");
													String drug_remarks =  (String)drug_detail.get("DRUG_REMARKS")==null?"":(String)drug_detail.get("DRUG_REMARKS");
													String dosage_Type_values = "";
													String str_value	= qty_value;
													String STRENGTH = strength_value;
													if (strength_value.equals("0")) {
														dosage_Type_values += "<OPTION value='Q' > Quantity </OPTION>";
													}
													else {
														if(dosage_type.equals("Q")) {
															dosage_Type_values = "<OPTION value='S' > Strength </OPTION>";
															dosage_Type_values += "<OPTION value='Q' SELECTED > Quantity </OPTION>";
														}else{
															dosage_Type_values = "<OPTION value='S' SELECTED > Strength </OPTION>";
															dosage_Type_values += "<OPTION value='Q' > Quantity </OPTION>";
														}
													}
													String calc_dose_based_on	= (String)drug_detail.get("CALC_DOSE_BASED_ON");
													String calc_dose_by			= (String)drug_detail.get("CALC_DOSE_BY")==null?"":(String) drug_detail.get("CALC_DOSE_BY");
													if(calc_dose_based_on == null)
														calc_dose_based_on = "";
													calculateByValues = "";
													if(calc_dose_based_on.equals("B")) {
														calculateByValues = calculateByValues + "<OPTION VALUE='D'>Dosage</OPTION>";
														calculateByValues = calculateByValues + "<OPTION VALUE='B' SELECTED>Body wt/BSA</OPTION>"; 
													}
													else {
														calculateByValues = calculateByValues + "<OPTION VALUE='D' SELECTED>Dosage</OPTION>";
														calculateByValues = calculateByValues + "<OPTION VALUE='B'>Body wt/BSA</OPTION>"; 
													}													
													String calc_dose_value		= "";													
													if(calc_dose_by.equals("M2"))
													{
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='KG'>KG</OPTION>";
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='M2' SELECTED>M2</OPTION>";
													}
													else {
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='KG' SELECTED>KG</OPTION>";
														dosageUnitDetailedValues = dosageUnitDetailedValues + "<OPTION VALUE='M2' >M2</OPTION>";
													}													
/* Banner Indicator Starts */	
String display_auth_rule			= "display:none";
String color_auth_rule   			= "";
String allergy_yn					=	null;
String limit_ind					=	null;
String drug_db_dosage_check_flag	=  "N";
String drug_db_allergy_check_flag	=  "N";
String ext_prod_id					=	null;
String drug_desc					=	null;
String perform_external_database_checks_yn	=	"";	
ArrayList dosageCheckParams 		= null;
String frequency="", repeat_value="", interval_value="", dosage = "", strength_per_value_pres_uom="", dosage_by="";
String route_code	= "", repeat_durn_type	= "", freq_nature	= "", freq_nature_pas = "I";
String startdate="", enddate="";
String loading_ext_prod_id					=	"";
String srl_no						=	null;
String external_dosage_override_reason		=   "";	
String current_rx					=	null;
String drug_db_duptherapy_flag		=  "N";
String dup_drug_det					= "";
String count_rx				    =	null;
String external_database_overrided_yn	    =	"";	
String drug_db_interact_check_flag			=  "N";
String drug_db_contraind_check_flag			=  "N";
String external_interaction_override_reason	=   "";
String external_contra_override_reason		=   ""; 
String external_alergy_override_reason		=   ""; 
String external_duplicate_override_reason	=   "";
String external_database_overrided_reason	=	"";	
String weight           = request.getParameter("weight")==null?"":request.getParameter("weight");
String bsa              = request.getParameter("bsa")==null?"":request.getParameter("bsa");
allergy_yn							=	(String)drug_detail.get("ALLERGY_YN");
limit_ind							=	(String)drug_detail.get("LIMIT_IND");
drug_db_dosage_check_flag           = (String)drug_detail.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
ext_prod_id			    			=	(String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");

drug_desc				= (String)drugDetails.get("DRUG_DESC")==null?(String)drugDetails.get("SHORT_DESC"):(String)drugDetails.get("DRUG_DESC");

perform_external_database_checks_yn = drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
startdate							= (String)drug_detail.get("START_DATE");
enddate								= (String)drug_detail.get("END_DATE");
srl_no								= (String)drug_detail.get("SRL_NO");
external_dosage_override_reason		= (String) drug_detail.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
current_rx							= (String)drug_detail.get("CURRENT_RX");
external_duplicate_override_reason	= (String) drug_detail.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
external_interaction_override_reason= (String) drug_detail.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
external_contra_override_reason		= (String) drug_detail.get("EXTERNAL_CONTRA_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
external_alergy_override_reason		= (String) drug_detail.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":(String) drug_detail.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
String ord_auth_reqd_yn		= (String) drug_detail.get("ORD_AUTH_REQD_YN")==null?"":(String) drug_detail.get("ORD_AUTH_REQD_YN");
String ord_spl_appr_reqd_yn	= (String) drug_detail.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) drug_detail.get("ORD_SPL_APPR_REQD_YN");
String ord_cosign_reqd_yn	= (String) drug_detail.get("ORD_COSIGN_REQD_YN")==null?"":(String) drug_detail.get("ORD_COSIGN_REQD_YN");
String ord_authorized_yn	= (String) drug_detail.get("ORD_AUTHORIZED_YN")==null?"":(String) drug_detail.get("ORD_AUTHORIZED_YN");
String ord_authorized_prev_yn	= (String) drug_detail.get("ORD_AUTHORIZED_PREV_YN")==null?"":(String) drug_detail.get("ORD_AUTHORIZED_PREV_YN");
String ord_approved_yn		= (String) drug_detail.get("ORD_APPROVED_YN")==null?"":(String) drug_detail.get("ORD_APPROVED_YN");
String ord_cosigned_yn		= (String) drug_detail.get("ORD_COSIGNED_YN")==null?"N":(String) drug_detail.get("ORD_COSIGNED_YN");
String daily_dose			= (String)drug_detail.get("DAILY_DOSE");
String sch_over_yn				= (String)drugDetails.get("SCH_OVER_YN"); // saravanan
if(sch_over_yn==null)
	sch_over_yn		=	"N";
if(ext_prod_id==null)
	ext_prod_id		=	"";
String unit_dose			= (String)drug_detail.get("UNIT_DOSE")==null?"":(String)drug_detail.get("UNIT_DOSE");
String mono_graph			= (String)drug_detail.get("MONO_GRAPH")==null?"":(String)drug_detail.get("MONO_GRAPH");
String min_daily_dose		= (String)drug_detail.get("MIN_DAILY_DOSE")==null?"":(String)drug_detail.get("MIN_DAILY_DOSE");
String min_unit_dose		= (String)drug_detail.get("MIN_UNIT_DOSE")==null?"":(String)drug_detail.get("MIN_UNIT_DOSE");
String exceed_dose_desc		= (String)drug_detail.get("DOSE_REMARKS");
String dup_drug_desc		= (String)drug_detail.get("CURRENTRX_REMARKS");
String allergy_desc			= (String)drug_detail.get("ALLERGY_REMARKS");
String DrugIndicationRemarks= (String)drug_detail.get("DRUG_INDICATION")==null?"":(String) drug_detail.get("DRUG_INDICATION");
calc_dose_value				= (String)drug_detail.get("CALC_DOSE_VALUE")==null?"":(String) drug_detail.get("CALC_DOSE_VALUE");
strength_per_value_pres_uom = (String)drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
loading_ext_prod_id				    = ext_prod_id;
if(mode.equals("amend") && count_rx != null && Integer.parseInt(count_rx) <=1){
	current_rx = "N";
	drug_detail.put("CURRENT_RX",current_rx);
}
if(perform_external_database_checks_yn.equals("Y") && !(ext_prod_id.equals("")) ){
	if(drug_db_duptherapy_yn.equals("Y")|| drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") || drug_db_dosecheck_yn.equals("Y") ){
		dosageCheckParams = null;
		if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
			dosageCheckParams = new ArrayList();
			details = (HashMap) bean_IVD.getAllExistingIVOrders().get(0);
			dosage					   = (String)drug_detail.get("STRENGTH_VALUE");
			strength_per_value_pres_uom = (String)drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
			strength_per_pres_uom       = (String)drug_detail.get("STRENGTH_PER_PRES_UOM");
			if(!(dosage.equals(""))){
				if(!(strength_per_value_pres_uom.equals(""))){
					dosage					   = (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
				}
				if(!(strength_per_pres_uom.equals(""))){
					dosage					   = (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
				}
			}
			dosage_by				   = (String)drug_detail.get("DOSAGE_TYPE");	
			if(dosage_by.equals(""))
				dosage_by = (String)bean_IVD.getDosage_type();

			if(details.get("INFUSE_OVER") == null || details.get("INFUSE_OVER").equals(""))
				details.put("INFUSE_OVER",(String)details.get("DURN_VALUE"));
		
			int freq	= 1;
			if( !( ((String)details.get("DURN_VALUE")).equals("") ) && !( ((String)details.get("INFUSE_OVER")).equals("") ) ){
				freq = (int)Math.ceil(Float.parseFloat((String)details.get("DURN_VALUE"))/Float.parseFloat((String)details.get("INFUSE_OVER")));
			}										
			dose_uom = "";
			if(dosage_by.equals("S"))
				dose_uom		    =	(String)drug_detail.get("STRENGTH_UOM");         
			else if(dosage_by.equals("Q"))
				dose_uom		    =	(String)drug_detail.get("PRES_BASE_UOM");	
			repeat_value     =   (String)drug_detail.get("REPEAT_VALUE")==null?"":(String)drug_detail.get("REPEAT_VALUE");
			interval_value	=	(String)drug_detail.get("INTERVAL_VALUE")==null?"":(String)drug_detail.get("INTERVAL_VALUE");		
			route_code	= (String)drug_detail.get("ROUTE_CODE")==null?"":(String) drug_detail.get( "ROUTE_CODE" );// Added in January 2014 for CIMS dosage check -start
			qty_desc_code= (String)drug_detail.get("QTY_DESC_CODE")==null?"":(String) drug_detail.get( "QTY_DESC_CODE" );
			repeat_durn_type	= drug_detail.get("REPEAT_DURN_TYPE")==null?"":(String) drug_detail.get( "REPEAT_DURN_TYPE" );
			freq_nature	= drug_detail.get( "FREQ_NATURE" )==null?"":(String) drug_detail.get( "FREQ_NATURE" );
			
			freq_nature_pas = "I";	  
			frequency	    =   "1";
			if(repeat_value != "" && interval_value != "")
				frequency = (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
			dosageCheckParams.add(patient_id);
			dosageCheckParams.add(loading_ext_prod_id);
			dosageCheckParams.add(weight);
			dosageCheckParams.add(bsa);
			dosageCheckParams.add(dosage);
			if(beanex!=null && (beanex.getProdID()).equals("CIMS"))  
				dosageCheckParams.add(qty_desc_code);	
			else
				dosageCheckParams.add(dose_uom);
			dosageCheckParams.add(freq+"");
			dosageCheckParams.add("1");
			dosageCheckParams.add(route_code);	 
			dosageCheckParams.add(repeat_durn_type);	 
			if(freq_nature!=null && !freq_nature.equals(""))
				freq_nature_pas =  freq_nature;
			dosageCheckParams.add(freq_nature_pas);	
			dosageCheckParams.add(interval_value);	 
		}
		HashMap tempDetails= null;
		HashMap drugDBCheckResult= null;
		ArrayList reqChecks = new ArrayList();
		if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y"))
			reqChecks.add("Y"); 
		else
			reqChecks.add("N"); 
		reqChecks.add(drug_db_duptherapy_yn); 
		reqChecks.add(drug_db_interact_check_yn); 
		reqChecks.add(drug_db_contraind_check_yn); 
		reqChecks.add(drug_db_allergy_check_yn); 
		startdate	= (String)drug_detail.get("START_DATE");
		enddate		= (String)drug_detail.get("END_DATE");
		drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,aDrugDesc, dosageCheckParams, "Y",startdate,enddate); 
		if(drugDBCheckResult!=null)
			beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
		if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
			drug_db_dosage_check_flag = "N";
			if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
				tempDetails = (HashMap)drugDBCheckResult.get("DOSECHECK");
				if(tempDetails != null && tempDetails.size() > 0){
					beanex.setDosageCheck(ext_prod_id, srl_no,tempDetails);
					drug_db_dosage_check_flag = "Y";
				}
			}
			if(drug_db_dosage_check_flag.equals("N")){
				tempDetails =beanex.getDosageCheck(ext_prod_id, srl_no);
				if(tempDetails != null && tempDetails.containsKey(ext_prod_id)){
					beanex.removeDosageCheck(ext_prod_id, srl_no);
				}
			}
			if(!external_dosage_override_reason.equals(""))
				drug_db_dosage_check_flag="Y";
		}
		if(drug_db_allergy_check_yn.equals("Y")){
			if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ 
				String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
				if(allergy_alert!=null && !allergy_alert.equals(""))
					drug_db_allergy_check_flag="Y";
			} 
			else {  
				tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
				if(tempDetails!=null && tempDetails.size()>0){
					drug_db_allergy_check_flag="Y";
				}
			} 
		}
		if(drug_db_interact_check_yn.equals("Y")){
			tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
			if(tempDetails!=null && tempDetails.size()>0){
				drug_db_interact_check_flag="Y";
			}
			else									
				drug_db_interact_check_flag="N";
		}
		if(drug_db_duptherapy_yn.equals("Y")){ 
			dup_drug_det	= (String)drugDBCheckResult.get("DUPCHECK");
			if(dup_drug_det!=null && !dup_drug_det.equals(""))
				drug_db_duptherapy_flag="Y";
			else{
				drug_db_duptherapy_flag="N";
			}
		}
		if(drug_db_contraind_check_yn.equals("Y")){
			tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
			if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
				drug_db_contraind_check_flag="Y";
			}		
			else
				drug_db_contraind_check_flag="N";
		}
	}
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
	drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_check_flag);
}
else{
	drug_db_product_id = "";
}							
if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
	external_database_overrided_yn = "Y";
if(external_database_overrided_yn.equals("Y") && ((drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("")) || (drug_db_contraind_check_flag.equals("Y") && external_contra_override_reason.equals("")) || (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals(""))))
	external_database_overrided_reason="N";
else
	external_database_overrided_reason="Y";
if(external_dosage_override_reason.equals("")){
	external_dosage_override_reason = (String)(((HashMap)bean_IVD.getAmendDoseRemarks()).get("1")) == null?"":(String)(((HashMap)bean_IVD.getAmendDoseRemarks()).get("1"));
	drug_detail.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",external_dosage_override_reason);
}		
if(drug_db_allergy_check_flag.equals("Y")){
	drug_detail.put("ALLERGY_YN","N");
	allergy_yn = "N";
}
/* Banner Indicator Ends */													
				                           %>							 
									    	<div class="detailsViewWrapper" style="border-bottom:1px solid #e4e8ec;">
											    <!--div style="height:30px;font-family: Segoe UI Semibold;font-size: 15px;color: #096b93;">
											     Additive(s)/Drugs
										        </div-->
											    <div class="ivWithAdditiveTabCss segoeuiBold paddingLeftRight10px">
											        <div style="float:left;margin-top: 6px;padding-right: 10px;"><%=drugDesc%></div>
													<div style="float:left;">													
<%
													//if(external_database_overrided_yn.equals("Y") && !ext_prod_id.equals("") && (drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") ||drug_db_allergy_check_flag.equals("Y") ||drug_db_contraind_check_flag.equals("Y") || drug_db_dosage_check_flag.equals("Y"))){
													if(!sch_over_yn.equals("Y") && !ext_prod_id.equals("")){
%>                                        
													<span class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/externalDatabase25X25.png" class="imgBannerIndicator">
													</span>
<% 
													}													
													display_auth_rule = "display:none";
													if(limit_ind!=null && limit_ind.equals("N") && !drug_db_dosage_check_flag.equals("Y")){
														display_auth_rule = "display:inline-block";
													}
%>
													<span id="span_beyondDoseLimit_<%=i%>" name="span_beyondDoseLimit_<%=i%>" class="pharmRxOrderItemIconsVRalign" style='<%=display_auth_rule%>;'>
														<img src="${path}/eIPAD/images/beyondDoseLimit25X25.png" class="imgBannerIndicator">
													</span>
<%																										
													display_auth_rule = "display:none";
													if(current_rx!=null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
														display_auth_rule = "display:inline-block";
													}
%>
													<span id="span_duplicateDrug_<%=i%>" name="span_duplicateDrug_<%=i%>" class="pharmRxOrderItemIconsVRalign"  style='<%=display_auth_rule%>;'>
														<img src="${path}/eIPAD/images/duplicateDrug25X25.png" class="imgBannerIndicator">
													</span>
<%														
													if(allergy_yn!=null && allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {
%>
													<span id="span_allergy_<%=i%>" class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/pharmAllergy25X25.png" class="imgBannerIndicator">
													</span>
<%
													}
													display_auth_rule = "display:none";
													color_auth_rule   = "/eIPAD/images/Req_icon.PNG";              							
													if(ord_auth_reqd_yn != null && ord_auth_reqd_yn.equals("Y")){
														display_auth_rule = "display:inline-block";
														if(ord_authorized_yn.equals("Y"))
															color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
													}
%>
													<span class="pharmRxOrderItemIconsVRalign" style='<%=display_auth_rule%>;'>
														<img src="${path}/eIPAD/images/authorizeRxDet25X25.png" class="imgBannerIndicator">
														<img src="${path}<%=color_auth_rule%>" class="BannerIndicators"/>
													</span>
<%
													display_auth_rule = "display:none";
													color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
													if(ord_cosign_reqd_yn != null && ord_cosign_reqd_yn.equals("Y")){
														display_auth_rule = "display:inline-block";
														if(ord_cosigned_yn.equals("Y"))
															color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
													}
%>
		                                        	<span class="pharmRxOrderItemIconsVRalign" style='<%=display_auth_rule%>;'>
														<img src="${path}/eIPAD/images/cosignRxDet25X25.png" class="imgBannerIndicator"/>
														<img src="${path}<%=color_auth_rule%>" class="BannerIndicators"/>
													</span>
<%
													display_auth_rule = "display:none";
													color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
													if(ord_spl_appr_reqd_yn != null && ord_spl_appr_reqd_yn.equals("Y")){
														display_auth_rule = "display:inline-block";
														if(ord_approved_yn.equals("Y"))
															color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
													}
%>
													<span class="pharmRxOrderItemIconsVRalign" style="<%=display_auth_rule%>;padding-right:10px;">
														<img src="${path}/eIPAD/images/Specialapproval.png" class="imgBannerIndicator">
														<img src="${path}<%=color_auth_rule%>" class="BannerIndicators"/>
													</span> 
													</div>
											    </div>
												<div style="display:flex;" class="paddingLeftRight10px" style="padding-right:8px;">
													<div class="ivrxContainer" style="padding-right:1px;">
													    <div class="IVrxLabel segoeuiBold paddingTopBottom">
														   Calculate By
														</div>
														<%if(strength_value.equals("0")){	 %>
						                                <select class="dropDown ivWidth99Important" id="ivrxWithAddCalcBy_<%=i%>" disabled onchange="onSelectCalculateBy(<%=i%>, 'onchange')">
						                                  <%=calculateByValues%>
						                                </select>  
						                                <%}else{ %>
						                                <select class="dropDown ivWidth99Important" id="ivrxWithAddCalcBy_<%=i%>" onchange="onSelectCalculateBy(<%=i%>, 'onchange')">
						                                  <%=calculateByValues%>
						                                </select>  
						                                <%} %>
													</div>	
                                                    <div id="enabledOnDosage<%=i%>" class="ivrxContainer" style="padding-left:1px;">
														<div class="IVrxLabel segoeuiBold paddingTopBottom" >
															   Dosage By
														</div>
					                                   <select class="dropDown ivrxDosageByCss ivWidth99Important" id="ivrxWithAddDosageBy_<%=i%>" name="dosage<%=i%>" onchange="onSelectDosageBy(<%=i%>, 'onchange')">
															<%=dosage_Type_values%>
					                                   </select>
													</div>	 													
													<div id="disabledOnBodyWt<%=i%>" class="ivrxContainer" style="display:none">
														<div class="IVrxLabel segoeuiBold paddingTopBottom" >
															   Dosage By
														</div>
					                                   <select class="dropDown ivrxDosageByCss ivWidth99Important" id="disabledOnBodyWt_<%=i%>">
					                                 	  
					                                   </select>
													</div>						
												</div>
												<div id="dynamicContentWrapper" style="padding-bottom:15px;" class="paddingLeftRight10px ivWithAddDynamicContentWrapperCss onOrientationChangeDynamicWrapper">
												    <div id="doseDetailsWrapper_Strength<%=i%>" class="doseDetailsWrapperCss" >
														<div id="doseLabel" style="height:35%;width:100%;">
														   <div class="IVrxLabel segoeuiBold" >
														      <span>Strength</span><font class="rxMandatorIndi">*</font>
														   </div>
														</div>
														<div id="doseInput" style="height:65%;width:100%;padding-top: 0.8px;">
														   <div style="width:49.5%;float:left;">
														      <input type="text" class="ivrxWithAddDrugUnit k-textbox" style="height: 43px;width: 98%;" id='id_qty_value_<%=i%>' value="<%= STRENGTH%>" onchange="DosageLimitCheck(this, <%=i %>)" maxlength="11" onKeyPress="allowValidNumber(this,event,8,2);"/>
														   </div>
														   <div style="width:49.6%;float:left;">
															  <div  class="interDurationTime" id="dosageUnitIvwithAdd_strength<%=i%>">
			                                                   <select class="dropDown ivWidth99Important" id="ivWithAddDosageStrengthUnit_<%=i%>">
			                                                      <OPTION VALUE='<%=strength_uom%>' SELECTED><%=strength_uom_desc%></OPTION>
			                                                   </select>
			                                                  </div>
														   </div>
														   <div style="clear: both;"></div> 
														</div>
												 	</div>
												 	<div id="doseDetailsWrapper_Dose<%=i%>" style="display:none;" class=" doseDetailsWrapperCss" >
														<div id="doseLabel" style="height:35%;width:100%;">
														   <div class="IVrxLabel segoeuiBold" >
														      <span>Dose</span><font class="rxMandatorIndi">*</font>
														   </div>
														</div>
														<div id="doseInput" style="height:65%;width:100%;padding-top: 0.8px;">
														   <div style="width:49.5%;float:left;">
														      <input type="text" class="ivrxWithAddDrugUnit k-textbox" id="CALC_DOSE_VALUE_<%=i%>"  style="height:43px;width:98%;" value="<%=pres_qty_value%>" onChange="DosageLimitCheck(this, <%=i%>);" maxlength="11" onKeyPress="allowValidNumber(this,event,8,2);"/>
														   </div>
														   <div style="width:49.6%;float:left;">
														      
															  <div  class="interDurationTime" id="dosageUnitIvwithAdd_qty">
			                                                    <select class="dropDown ivWidth99Important" id="ivWithAddDosageUnit_<%=i%>">
			                                                    <%
																Hashtable QtyDescDetails	= (Hashtable)bean_IVD.listQtyDetails(drug_code);
																Enumeration keys_des		= QtyDescDetails.keys();
																String uom_code				= "";
																String uom_desc				= "";
																String def_uom				= "";
						
																while(keys_des.hasMoreElements()) {
																	uom_code	= (String)keys_des.nextElement();
																	uom_desc	= (String)QtyDescDetails.get(uom_code);
						
																	if(!uom_code.equals("dflt_code")) {
																		if(dosage_type.equals("S")) {
																			if(uom_code.equals(pres_base_uom))
																				def_uom = "SELECTED";
																			else
																				def_uom = "";
																		}
																		else {
																			if(uom_code.equals(qty_desc_code))
																				def_uom = "SELECTED";
																			else
																				def_uom = "";
																		}
																%>

																<OPTION VALUE="<%=uom_code%>" <%=def_uom%> > <%=uom_desc%> </OPTION>
																<%
																	}
																}
																%>
			                                                    </select>
			                                                  </div>
														   </div>
														   <div style="clear: both;"></div>
														</div>
												 	</div>
													<div id="doseDetailsWrapper_OnBodyWt<%=i%>" style="display:none" class="table doseDetailsWrapperCss" >
														<div id="doseLabel" class="row fullWtHalfHt" >
														   <div class="cell IVrxLabel segoeuiBold fullHtHalfWt" >
														      <span>Dose<font class="rxMandatorIndi">*</font></span>
														   </div>
														   <div class="cell fullHtHalfWt" >
														   </div>
														</div>
														<div id="doseInput" class="row fullWtHalfHt" >
														   <div class="cell fullHtHalfWt" >
														      <input type="text" class="ivrxWithAddDrugUnit k-textbox" id="CALC_DOSE_VALUE_OnBodyWt<%=i%>" value="<%=calc_dose_value%>" onchange="calculateDosage_By_BSA_or_Weight(<%=i%>);" maxlength="7" onKeyPress="allowValidNumber(this,event,3,3);" style="height:43px;width:98%" />
														   </div>
														   <div class="cell detailsCell">
															  <div  class="interDurationTime" id="bodyWtUnitIvwithAdd">
			                                                   <select class="dropDown ivWidth99Important" id="bodyWtDoseValues_<%=i%>">
			                                                      <OPTION VALUE='<%=strength_uom%>' SELECTED><%=strength_uom_desc%></OPTION>
			                                                   </select>
			                                                  </div>
														   </div>
														</div>
												 	</div>
													<div id="ivWithAdddoseRemarksField<%=i%>" style="width:49.8%;height: 65px;float: left;" >
													    <div style="width:100%;height: 35%;">
														  <div class="IVrxLabel segoeuiBold">
														  Remarks
														  </div>
														</div>
														
														<div id="ivWithAdddoseUnitInput" style="height:65%;width:100%;">
														   <div style="width:100%;height:100%;">
														   		<textarea class="k-textbox" id="drugRemTextarea_<%=i%>" maxlength="40" style="height:57px;width:100%;"><%=drug_remarks %></textarea>
														   </div>
														</div>
												 	</div>													
													<div id="ivWithAdddoseUnitsWrapper<%=i%>" style="display:none;" class="table ivInterDoseUnitWrapper" >
													    <div class="row fullWtHalfHt">
														  <div class="cell fullHtFullWt" >
														  </div>
														</div>
														<div id="ivWithAdddoseUnitInput" class="row fullWtHalfHt" >
														   <div class="cell fullHtFullWt" >
														     <div class="table" style="width:49.4%;height:100%;float:left;">
														       <div class="row fullHtFullWt">
															     <div class="cell" style="width:99%;height:100%;">
														            
																	<div  class="interDurationTime" id="dosageUnitIvwithAddDetails" >
			                                                         <select class="dropDown ivWidth99Important" id="ivWithAdddosageUnitDetails_<%=i%>" onchange="calculateDosage_By_BSA_or_Weight(<%=i%>);">
			                                                           <%=dosageUnitDetailedValues%>
			                                                         </select>
			                                                        </div>																	
														         </div>
																 <div class="cell ivInterEqualTo" >
			                                                        = 													 
																 </div>
															   </div>
			                                                  </div>  												  
														      <div class="table ivInterDoseMG" >
															     <div class="row fullHtFullWt">
															        <div class="cell fullHtHalfWt" >
			                                                         <input type="text" id="ivrxDoseDrugUnit<%=i%>" name="ivrxDoseDrugUnit<%=i%>" class="ivrxDoseDrugUnit1 k-textbox" style="height:43px;width:99%" value="<%=qty_value%>" onchange="DosageLimitCheck(this, <%=i%>);"/> 			                                                        
																	<div class="pharHtWtTextboxDurnUnit"><%=strength_uom_desc%></div> 																	  
														            </div>														            
															     </div>
															  </div>
														   </div>
														</div>
												 	</div>													
													<div id="ivWithAddDrugIndications_<%=i%>" style="padding-top:20px;" class="textareaWrapper">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Drug indications
			                                                    </div>													 
															    <textarea id="txtDrugIndi_<%=i%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=DrugIndicationRemarks%></textarea>
															  </div>
													       </div>
													</div>													
<%														
													if(allergy_yn!=null && allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {
%>
													<div id="ivWithAddAllergyOveride_<%=i%>" class="textareaWrapper">
												       <div class="fullHtFullWt">
													      <div class="positionRelative" >
														     <div class="IVrxLabel segoeuiBold paddingBottom5px">
															    Allergy override reason<font class="rxMandatorIndi">*</font>
			                                                 </div>													 
													         <textarea class="k-textbox" id="txtAllergy_<%=i%>" maxlength="255" style="height:57px;width:99%;"><%=allergy_desc%></textarea>
														  </div>
												       </div>
													</div>
<% 													}
													display_auth_rule = "display:none";
													if(current_rx!=null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
														display_auth_rule = "display:table";
													}
%>
													<div id="ivWithAddDuplicateOveride_<%=i%>" class="textareaWrapper" style="<%=display_auth_rule%>; padding-top:20px;">
													       <div class="fullHtFullWt">
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Duplicate drug override reason<font class="rxMandatorIndi">*</font>
			                                                    </div>													 
															    <textarea class="k-textbox" id="txtDupDrug_<%=i%>" maxlength="255" style="height:57px;width:99%;"><%=java.net.URLEncoder.encode(dup_drug_desc,"UTF-8")%></textarea>
															  </div>
													       </div>
													</div>													
<%
													display_auth_rule = "display:none";
													if(limit_ind!=null && limit_ind.equals("N") && !drug_db_dosage_check_flag.equals("Y")){
														display_auth_rule = "display:table";
													}
%>
													<div id="ivrxBeyondDosageOvverride_<%=i%>" class="table textareaWrapper" style="<%=display_auth_rule%>">
												       <div class="row fullHtFullWt" >
													      <div class="cell positionRelative">
														     <div class="IVrxLabel segoeuiBold paddingBottom5px">
															    Beyond dosage limit override reason<font class="rxMandatorIndi">*</font>
		                                                     </div>													 
														     <textarea class="k-textbox" id="txtBeyDosLimit_<%=i%>" maxlength="255" style="height:57px;width:99%;"><%=exceed_dose_desc%></textarea>
														  </div>
												       </div>
													</div>
												</div>									
											</div>
											<input type="hidden" value="<%=drugDesc%>" name="drugDesc<%=i%>" id="drugDesc<%=i%>" />
											<input type="hidden" value="<%=drug_code%>" name="drug_code<%=i%>"  id="drug_code<%=i%>"/>
											<input type="hidden" value="<%=strength%>" name="strength<%=i%>" id="strength<%=i%>" />
											<input type="hidden" value="<%=qtyDesc%>" name="qtyDesc<%=i%>" id="qtyDesc<%=i%>" />
											<input type="hidden" value="<%=qty_value%>" name="qty_value<%=i%>" id="qty_value<%=i%>" />
											<input type="hidden" value="<%=strength_uom_desc%>" name="strength_uom_desc<%=i%>" id="strength_uom_desc<%=i%>"/>
											<input type="hidden" value="<%=dosage_type%>" name="dosage_type<%=i%>" id="dosage_type<%=i%>" />
											<input type="hidden" value="<%=qty_desc_code%>" name="qty_desc_code<%=i%>" id="qty_desc_code<%=i%>" />
											<input type="hidden" value="<%=start_date%>" name="start_date<%=i%>" id="start_date<%=i%>" />
											<input type="hidden" value="<%=strength_uom%>" name="strength_uom<%=i%>" id="strength_uom<%=i%>"/>
											<input type="hidden" value="<%=STRENGTH%>" name="strength_value<%=i%>" id="strength_value<%=i%>" />
											<input type="hidden" value="<%=strength_per_pres_uom%>" name="strength_per_pres_uom<%=i%>" id="strength_per_pres_uom<%=i%>" />
											<input type="hidden" value="<%=pres_qty_value%>" name="pres_qty_value<%=i%>" id="pres_qty_value<%=i%>" />
											<input type="hidden" value="<%=str_value%>" name="ORDERSET_STRENGTH<%=i%>" id="ORDERSET_STRENGTH<%=i%>" />
											<input TYPE="hidden" name="STR_VAL_<%=i%>" id="STR_VAL_<%=i%>" id="STR_VAL_<%=i%>" value="<%=str_value%>" />
											<input TYPE="hidden" name="calc_dose_value<%=i%>" id="calc_dose_value<%=i%>" id="calc_dose_value<%=i%>" value="<%=calc_dose_value%>" />											
											<input TYPE="hidden" name="UOM_CODE_<%=i%>" id="UOM_CODE_<%=i%>" id="UOM_CODE_<%=i%>" VALUE="<%=strength_uom%>"/>
											<input type="hidden" value="<%=mode%>" name="mode" />
											<input type="hidden" name="external_product_id_<%=i%>" id="external_product_id_<%=i%>" id="external_product_id_<%=i%>" value="<%=ext_prod_id%>">
											<input type="hidden" name="SRL_NO_<%=i%>" id="SRL_NO_<%=i%>" id="SRL_NO_<%=i%>" value="<%= srl_no%>">
											<input type="hidden" name="LIMIT_IND_<%=i%>" id="LIMIT_IND_<%=i%>" id="LIMIT_IND_<%=i%>" value="<%= limit_ind%>">
											<INPUT TYPE="hidden" name="DAILY_DOSE_<%=i%>" id="DAILY_DOSE_<%=i%>" id="DAILY_DOSE_<%=i%>" VALUE="<%= daily_dose %>">
											<INPUT TYPE="hidden" name="UNIT_DOSE_<%=i%>" id="UNIT_DOSE_<%=i%>" id="UNIT_DOSE_<%=i%>" VALUE="<%= unit_dose %>">
											<INPUT TYPE="hidden" name="MONO_GRAPH_<%=i%>" id="MONO_GRAPH_<%=i%>" id="MONO_GRAPH_<%=i%>" VALUE="<%= mono_graph %>">
											<INPUT TYPE="hidden" name="MIN_DAILY_DOSE_<%=i%>" id="MIN_DAILY_DOSE_<%=i%>" id="MIN_DAILY_DOSE_<%=i%>" VALUE="<%= min_daily_dose %>">
											<INPUT TYPE="hidden" name="MIN_UNIT_DOSE_<%=i%>" id="MIN_UNIT_DOSE_<%=i%>" id="MIN_UNIT_DOSE_<%=i%>" VALUE="<%= min_unit_dose %>">
											<INPUT TYPE="hidden" name="CURRENT_RX_<%=i%>" id="CURRENT_RX_<%=i%>" id="CURRENT_RX_<%=i%>" VALUE="<%= current_rx %>">
											<INPUT TYPE="hidden" name="ALLERGY_YN_<%=i%>" id="ALLERGY_YN_<%=i%>" id="ALLERGY_YN_<%=i%>" VALUE="<%= allergy_yn %>">
											<INPUT TYPE="hidden" name="strength_per_value_pres_uom_<%=i%>" id="strength_per_value_pres_uom_<%=i%>" id="strength_per_value_pres_uom_<%=i%>" VALUE="<%= strength_per_value_pres_uom %>">
											<INPUT TYPE="hidden" name="pres_base_uom_<%=i%>" id="pres_base_uom_<%=i%>" id="pres_base_uom_<%=i%>" VALUE="<%= pres_base_uom %>">											
											<%
												}
											%>
											<input type = "hidden" name = "hdnPath" id = "drugCount" value ="<%=presDetails.size()%>"/>
											<%	
				                           	}
											%>
											<!-- Fluid details STARTS -->
											<%
										 	ArrayList dfltFluidDetails = null;
											ArrayList dfltFluidDetails_desc = null;
											String drugCodes = bean_IVD.getDrugCodes();
											if(presDetails.size()==1){
												dfltFluidDetails = bean_IVD.getCompFluidDetails(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
											}
											else if (presDetails.size()>1){
												selected_drug_codes = "";
												selected_drug_codes += drugCodes.substring(0,drugCodes.length()-1);
												dfltFluidDetails = bean_IVD.getCompFluidDetailsForMultipeDrugs(selected_drug_codes,pract_id,resp_id);
											}	
											String STRENGTH_PER_VALUE_PRES_UOM = (String)fluid_details.get("STRENGTH_PER_VALUE_PRES_UOM");

											String BUILD_MAR_YN = (String)fluid_details.get("BUILD_MAR_YN");
											String PRES_QTY_UOM = (String)fluid_details.get("PRES_QTY_UOM");
											ArrayList exstngIVOrdersDts	= new ArrayList();
											exstngIVOrdersDts		= bean_IVD.getAllExistingIVOrders();
											 String start_date_fluid="";
											 String end_date_fluid="";
											if(exstngIVOrdersDts.size()>0){
												start_date_fluid=START_DATES;
												end_date_fluid=END_DATES;
												if(start_date_fluid.equalsIgnoreCase("") ||end_date_fluid.equalsIgnoreCase("") ){
													start_date_fluid = bean_IVD.getSysdate();
		   											 end_date_fluid	=  bean_IVD.populateEndDate(start_date_fluid,"24","H");
		   										
												
												}
	                                           }else{
	                                        	   
	                                        	 start_date_fluid = bean_IVD.getSysdate();
	   											 end_date_fluid	=  bean_IVD.populateEndDate(start_date_fluid,"24","H");
	   										
	                                           }
	                                           
											
												String trade_code = (String)fluid_details.get("TRADE_CODE");
											String max_duration = (String)fluid_details.get("DURN_VALUE");											
											String fluid_code = (String)fluid_details.get("DRUG_CODE");
																				
											String buildMAR_yn		= "";
	String MAR_app_yn		= "";
	String buildMAR_checked	= "";
	String buildMAR_rule	= "";  
	String buildMAR_enable	= "";
	String params			= request.getQueryString();
	String adr_count		= request.getParameter("adr_count") == null ? "0":request.getParameter("adr_count");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
 	String order_type_flag	= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String order_set_code	= request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");
	ArrayList orderSetCodes	= new ArrayList();
	HashMap   orderSetFluid = new HashMap();
	String iv_prep_default	= request.getParameter("iv_prep_default") == null ? "":request.getParameter("iv_prep_default");
	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	buildMAR_yn = MAR_app_yn;
	String form_code			=	"";
	String route_code			=	"";
	String order_type_code		=	"";
	String Disabled				=	"";
	String checkVal				=   "";
	String admix_value1			=   "";
	String CATALOG_DESC			=   "";
	String ORDER_CATALOG_CODE   =   "";	
	String stock_value			=   "0";
	String FLUID_UNIT_QTY		=   "";
	String stock_uom_code		=   "";
	String time_flag            =   ""; 
	String disable_addmixture	=   "";
	String alert_practitioner_yn=   "";
	String chk_addmixture       =   ""; 
	String base_volume			=   "";	
    String fluid_adr_display    =   "hidden";
	String mfr_display			=	"hidden";
	String read					=	"";
	String mfr_remarks			=	"";
	String remarksDisplay		=	"display:none";
	exstngIVOrders	= new ArrayList();
	iv_calc_infuse_by=bean_IVD.getIVCalcInfuseBy(); //added for SKR-CRF-0035 start
	String iv_calc_infuse_display="", iv_calc_duration_display="";
	if(iv_calc_infuse_by.equals("I")){
		iv_calc_infuse_display="display:inline;";
		iv_calc_duration_display="display:none;";
	}
	else{
		iv_calc_infuse_display="display:none;";
		iv_calc_duration_display="display:inline;";
	}	
	if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){		
		if(!order_set_code.equals("")) 
			orderSetCodes = bean_IVD.getOrdersetCodes(order_set_code);
		if((orderSetCodes.size() != 0) &&(bean_IVD.getFluidCompatibility().equals("Y"))) {
			orderSetFluid = bean_IVD.getOrderSetDrugs((String)orderSetCodes.get(0)); 
			ArrayList orderSetValues	= bean_IVD.getOrderSetValues();
			String	sReqRnot			= "";
			fluid_code					= (String)orderSetFluid.get("drug_code");
			CATALOG_DESC				= (String)orderSetFluid.get("drug_desc");
			bean_IVD.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED
			if(orderSetValues.get(0).equals(fluid_code)){
				stock_value				= (String)orderSetValues.get(1);		
				sReqRnot				= (String)orderSetValues.get(6);
			}
			if(sReqRnot.equals("R")) 
				Disabled = "disabled";
		} 
	}	
	ArrayList stockDetails = bean_IVD.getStockDetails(fluid_code, "1");
	if (stockDetails.size() != 0)
		stock_value=(String)stockDetails.get(0);											
	if(VOLUME_VALUE == null || VOLUME_VALUE == "")
		VOLUME_VALUE = stock_value;
	if(iv_prep_yn.equals("1")){
		checkVal="unchecked";
		admix_value = "N";
	}
	else if(iv_prep_yn.equals("2")){
		checkVal="checked";
		admix_value = "Y";
	}
	else checkVal="";
		if(mode == null) mode="";		
		String resetYN = request.getParameter("reset")==null?"": request.getParameter("reset");
		HashMap hm_fluid_details = null;
		if(!resetYN.equals("Y")){
			if(bean_IVD.getFluidDetails()==null || (bean_IVD.getFluidDetails()).size()==0){				
			}
		}
		hm_fluid_details = bean_IVD.getFluidDetails();				
		if(hm_fluid_details != null){
			if(hm_fluid_details.size()>0){
				fluid_code		= (String)hm_fluid_details.get("DRUG_CODE");
				order_type_code = (String)hm_fluid_details.get("ORDER_TYPE_CODE");
				if(hm_fluid_details.get("BUILD_MAR_YN")==null){
					hm_fluid_details.put("BUILD_MAR_YN",MAR_app_yn);
				}
				buildMAR_yn		= (String) hm_fluid_details.get("BUILD_MAR_YN");
				buildMAR_rule = (String)hm_fluid_details.get("BUILD_MAR_RULE"); 				
				if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				else
					buildMAR_checked="";					
				buildMAR_rule=(buildMAR_rule==null)?"":buildMAR_rule;					
				if(buildMAR_rule.equals("CE")){
					buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("UE")){
					buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("CD")){
					buildMAR_enable="disabled";
				}
				else if(buildMAR_rule.equals("UD")){
					buildMAR_enable="disabled";
				}
			}			
			if( Integer.parseInt(adr_count)>0){
		    int fluid_adr_count = bean_IVD.getADRCount(patient_id,fluid_code);
		    if(fluid_adr_count>0)
			  fluid_adr_display ="visible";
	     }
	 HashMap record1					=	new HashMap(); 
	record1					=	bean_IVD.ChkAdMixture();
	chk_addmixture			=	(String)record1.get("IV_ADMIXTURE_APPL_YN");
	alert_practitioner_yn	=	(String)record1.get("ALERT_PRACTITIONER_YN");
	if(chk_addmixture.equals("N") || mfr_display.equals(""))
	   disable_addmixture	=	"Disabled";		    
	else{
	   disable_addmixture	=	"";
	}	
}		
											%>											
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
			<input type="hidden" name="route_code" id="route_code" value="<%=route_code%>">
			<input type="hidden" name="base_uom" id="base_uom" value="">
			<input type="hidden" name="eqvl_uom_value" id="eqvl_uom_value" value="">
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id_IVD %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name_IVD %>">
			<input type="hidden" name="STOCK_VALUE" id="STOCK_VALUE" value="<%=stock_value%>">
			<input type="hidden" name="DRUG_VOLUME" id="DRUG_VOLUME" value="">
			<input type="hidden" name="STOCK_UOM_CODE" id="STOCK_UOM_CODE" value="<%=stock_uom_code%>">
			<input type="hidden" name="BASE_VOLUME" id="BASE_VOLUME" value="<%=base_volume%>">
			<input type="hidden" name="order_type_flag1" id="order_type_flag1" value="<%= order_type_flag %>">
			<input type="hidden" name="order_set_code" id="order_set_code" value="<%= order_set_code %>">
			<input type="hidden" name="language_id" id="language_id" value="<%= locale %>">
			<input type="hidden" name="mfr_yn" id="mfr_yn" value='<%=read.equals("")?"N":"Y"%>'>
			<input type="hidden" name="mfr_remarks" id="mfr_remarks" value="<%=mfr_remarks%>">
			<input type="hidden" name="back_date" id="back_date"		value="">									
		                                    <div id="ivWithAddFluidDetailsWrapper"  class="interFluidDetailWrapper" >
												<div id="ivWithAddFluidDetailsContent" class="withAddFluidDetailContent">
													<div class="interFluidLabel segoeuiBold">
												     Fluid Details
											        </div>
													<div style="display:flex;" class="paddingLeftRight10px">
														 <div class="ivrxContainer">
														    <div class="IVrxLabel segoeuiBold paddingBottom5px">
															   Fluid<font class="rxMandatorIndi">*</font>
															</div>
				                                            <div id="fluidNameIvWithAdd" class="fullWidth">
				                                                    <select id="fluidNameIvWithAddValues" class="ivWidth100Important" style="height:43px;" name="fluidNameIvWithAddValues" id="fluidNameIvWithAddValues" onchange="changeFluid(this)">  
																		<%
			                                                          		int i=0;
																	String dfl_sel=	(String)fluid_details.get("DRUG_CODE");
																	String PRES_BASE_UOM_DESC_FULD=	(String)fluid_details.get("PRES_BASE_UOM_DESC");
																		String selected="";
																			for(int j=1; j<dfltFluidDetails.size();j+=7){
																				if(dfl_sel != null && (dfltFluidDetails.get(j-1)).equals(dfl_sel)){
																		%>
				                                                          		<OPTION id="fluid_desc<%=i%>" value="<%=dfltFluidDetails.get(j-1)%>" selected><%=dfltFluidDetails.get(j)%></OPTION> 
				                                                        <%
																				}
																				else if(dfl_sel == null && dfltFluidDetails.get(j+2).equals("Y")) {
																		%>
				                                                          		<OPTION id="fluid_desc<%=i%>" value="<%=dfltFluidDetails.get(j-1)%>" selected><%=dfltFluidDetails.get(j)%></OPTION> 
				                                                        <%		
																				}
																				else{
																		%>
																				<OPTION id="fluid_desc<%=i%>" value="<%=dfltFluidDetails.get(j-1)%>"><%=dfltFluidDetails.get(j)%></OPTION>
																		<%
																					
																				}
																				i++;
																			}
				                                                        %>                                   
				                                                    </select>
				                                            </div>  
														 </div>
														 <div style="width: 0.6%;">
													     </div>
														 <div class="ivrxContainer">
														    <div class="IVrxLabel segoeuiBold paddingBottom5px">
															   Volume<font class="rxMandatorIndi">*</font>
															</div>
				                                            <div class="interInputWrap">
																<div class="pharContentKgLabel fullWidth">
				                                            		<input type="text" class="k-textbox"  style="width:99.5%;height:43px;" id="volume" maxlength="5" name="volume" id="volume" onblur="setStockValue(this)" value="<%=VOLUME_VALUE%>"/>
															  		<div class="pharHtWtTextboxUnit" style="right:2%" id="stock_display" name="stock_display"><%=PRES_BASE_UOM_DESC_FULD%></div>
															  		<!-- check for lable --> 
																</div>
				                                            </div>
														 </div>
		                                        	</div>
													<div style="display:flex;" class="paddingLeftRight10px">													
													  	<div class="ivrxContainer">
													    	<div class="IVrxLabel segoeuiBold paddingBottom5px" style="padding-top:3px">
														   		IV Admixture
															</div>
															<div class="interInputWrap" >
																<input style="height: 20px;width: 20px;"  type="checkbox" name="admixture" id="admixture" value='Y' disabled />																													
				                                            </div> 
													 	</div>
														<div style="width:1.5%"></div>
														<div class="ivrxContainer">
														    <div class="IVrxLabel segoeuiBold paddingBottom5px">
															   Build MAR
															</div>	
				                                            <div class="interInputWrap" style="padding-top:5px;">
																<input style="height: 20px;width: 20px;" id="build_mar" name="build_mar" id="build_mar" type="checkbox" <%=buildMAR_checked%> <%=buildMAR_enable%>/>
															</div> 									
														</div>
			                                        </div>												    
												</div>
											</div>
											<!-- Fluid details ENDS -->
	                               		</div> 
										<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" value="<%= drug_db_dosecheck_yn%>">
										<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn" id="drug_db_interface_yn" value="<%= drug_db_interface_yn%>"> 
										<input type="hidden" name="bean_id" id="bean_id" id="bean_id" value="<%= bean_id_IVD%>"> 
										<input type="hidden" name="bean_name" id="bean_name" id="bean_name" value="<%= bean_name_IVD%>"> 
									</div>
								 	<!-- Drug Details Tab ends -->								 	
								<!-- Admin Details Tab Starts -->
	                            <div id="administrationDetailsIvRxScroller" class="row selectPharmOrder pharmOrderIVRxItemContainer"  data-role = "none">
	                                <div class="detailsViewMainWrapper" >					
									    <div class="fullWidth">	   												
									        <div style="display:flex;" class="paddingLeftRight10px">
											 <div class="ivrxContainer">
											    <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   Infusion rate<font class="rxMandatorIndi">*</font>
												</div>
											 <div id="ivWithAdddoseDetailsWrapper" class="table ivInterDoseDetailsWrapper" >
	                                           <div id="" class="row fullWtHalfHt" style="">
												   <div class="cell fullHtHalfWt" style="">											   
												    <div class="pharContentKgLabel" style="padding-left:0px;">													
												      <input type="text" class="ivrxWithAddInfuseRateUnit k-textbox" name="infuse_rate" id="infuse_rate" size="1" maxlength="10" onblur="setInfuseOverValue();" value="<%= infuse_overs%>" style="height:43px;width:98%;"/>
													   <div class="pharHtWtTextboxUnit" name="infusion_uom_display"  id="infusion_uom_display" style="right:14px;"><%=PRES_BASE_UOM_DESC_FULD%></div>   
													  </div>												  
												   </div>
												   <div id="divider" class="table">
													    <div class="row fullWtHalfHt" >
														  <div class="cell dividerContent" >
														    <div id="" style="left:-5.5px;top:14px;position:absolute;" class="" >/</div>
														  </div>
													    </div>
												    </div>
												   <div class="cell detailsCell">												      
													  <div  class="dropDown" id="" style="width:100%;height:36px;">
	                                                    <select style="width: 100%" id="ivrxWithAddInfusionRateUnit" onchange="setInfuseOverValue();" name="infuse_rate_unit" id="infuse_rate_unit">
	                                                       <%=infusionRateDetails%>                                            
	                                                    </select>
	                                                  </div>													  
												   </div>
												</div> 
												</div>		
											 </div> 
											 <div style="width:0.2%;"></div>
											 <div class="ivrxContainer">
											    <div class="IVrxLabel segoeuiBold" style="padding-top:10px;padding-bottom:5px;">
												   Infuse over<font class="rxMandatorIndi">*</font>
												</div>
												<div id="doseDetailsWrapper" class="table interDurationRepeat">
	                                               <div id="doseInput" class="row fullWtHalfHt">
												   <div class="cell fullHtHalfWt">
												      <div class="pharContentKgLabel" style="padding-left:0px;">
												      <input type="text" class="k-textbox ivRxWithAddInfuseOverInput" style="height:43px;width:98%;" id ="INFUSION_PERIOD_VALUE_WA_HRS" name="INFUSION_PERIOD_VALUE" id="INFUSION_PERIOD_VALUE" onchange="setInfuseRateValue();" value="<%= infuse_over_hrs %>" maxlength="2"/>
													   <div class="pharHtWtTextboxUnit" style="right:11px;">Hrs</div> 
													  </div>
												   </div>
												   <div class="cell detailsCell"> 
													  <div class="pharContentKgLabel" style="padding-left:0px;">
												      <input type="text" class="k-textbox ivRxWithAddInfuseOverInput" style="height:43px;width:99%;" id="INFUSION_PERIOD_VALUE_WA_MINS" name="INFUSION_PERIOD_VALUE_MIN" id="INFUSION_PERIOD_VALUE_MIN" onchange="setInfuseRateValue();" value="<%=infuse_over_mis %>" maxlength="2"/>
													   <div class="pharHtWtTextboxUnit" style="right:11px;">mins</div> 
													   <div id="infuse_over_str" class="infuseOverCss" style="" name="infuse_over_str"><%= disp_strs%></div>													
													  </div>
												    </div>
												  </div> 
												</div>	
	                                        </div>	 										 						
										    </div>
										    <div style="display:flex;" class="paddingLeftRight10px">
										    <div class="ivrxContainer">
											    <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   Duration for repeat<font class="rxMandatorIndi">*</font>
												</div>
	                                            <input style="width:99% ! important;height:43px;" class="ivrxDosageByCss k-textbox"  onchange="chkDuration();"  type="text" id="ivrxDosageBy" maxlength="2" value="<%= duration_drun %>"/>
												<div class="pharHtWtTextboxDurnUnit">Hours</div> 
											</div>
											</div>											
											<div style="display:flex;" class="paddingLeftRight10px">
											 <div class="ivrxContainer">
											   <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   Start date and time<font class="rxMandatorIndi">*</font>
												</div>
	                                            <input style="width:99% ! important" class="dropDown" onchange="changeStartDate(this);" id="ivrxWithAddAdminStartDate" value="<%=START_DATES %>" />  
											  </div>								  
											  <div class="ivrxContainer">
											    <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   End date and time<font class="rxMandatorIndi">*</font>
												</div>
	                                            <input style="width:99% ! important;" class="dropDown ivrxDosageByCss" type="text" id="ivrxWithAddAdminAdminEndDate"  value="<%=END_DATES %>" maxlength="8" value="0" disabled/>
											  </div>						
										    </div>									
	                                    </div>
	                                </div>	
	                            </div>
								 <!-- Admin Details Tab Ends -->
								<!-- Pharmacy legend starts -->
								<div id="ivRxWithAddLegend"></div>
								<!-- Pharmacy legend ends --> 
	                        </div>						   	  
	                      </div>						
	                    </div>
	                </div>
	               </div>
            </div> 		
        <input type="hidden" name="INFUSION_UOM" id="INFUSION_UOM" value="">
        <input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}"/>
        <input type="hidden" value="<%=ph_version%>" name="ph_version" />
        <input type="hidden" value="<%=facility_id%>" name="facility_id" />
        <input type="hidden" value="<%=patient_id%>" name="patient_id" />
        <input type="hidden" value="<%=patient_class%>" name="patient_class" />
        <input type="hidden" value="<%=encounter_id%>" name="encounter_id" />
        <input type="hidden" value="<%=resp_id%>" name="resp_id" />
        <input type="hidden" value="<%=pract_id%>" name="pract_id" />
        <input type="hidden" value="<%=location_code%>" name="location_code" />
        <input type="hidden" value="<%=locn_type%>" name="location_type" />
        <input type="hidden" value="<%=bl_install_yn%>" name="bl_install_yn" />
        <input type="hidden" value="<%=start_date_fluid%>" name="start_date_fluid" id="start_date_fluid" />
        <input type="hidden" value="<%=end_date_fluid%>" name="end_date_fluid" id="end_date_fluid" />        
        <input type="hidden" value="<%=bean_id_IVD%>" name="bean_id_IVD" />
        <input type="hidden" value="<%=bean_name_IVD%>" name="bean_name_IVD" />
        <input type="hidden" value="<%=mode%>" name="mode" />
		<input type="hidden" value="<%=trade_code%>" name="trade_code" />
		<input type="hidden" value="<%=max_duration%>" name="max_duration" />
		<input type="hidden" value="<%=iv_calc_infuse_by%>" name="iv_calc_infuse_by" />
		<input type="hidden" value="<%=FUTURE_DATE%>" name="FUTURE_DATE" />
		<input type="hidden" value="<%=locale%>" name="locale" />
		<input type="hidden" value="<%=sys_date%>" name="sys_date" />
		<input type="hidden" name ="bl_disp_charge_dtl_in_rx_yn" id ="bl_disp_charge_dtl_in_rx_yn" value = "<%=bl_disp_charge_dtl_in_rx_yn%>"/>
		<input type="hidden" value="<%=infuse_over%>" name="infusion_over_insert_value" />
		<INPUT TYPE="hidden" name="FREQUENCY" id="FREQUENCY" VALUE = '<%=freq_code%>'>
		<input type="hidden" name="freq_desc" id="freq_desc" value='<%=freq_desc%>' >
		<input type="hidden" name="ORDER_TYPE_CODE" id="ORDER_TYPE_CODE" value='PHR' >
		<input type="hidden" value="<%=END_DATES%>" name="END_DATES" />
		<input type="hidden" value="<%=START_DATES%>" name="START_DATES" />
		<input type="hidden" name="INFUSION_VALUE_WITHOUT_ROUND" id="INFUSION_VALUE_WITHOUT_ROUND" value="<%=infuse_overs%>">
		
		
		
		
		
		
		<input type="hidden" value="<%=drugCodes%>" name="drugCodes" />
		<input type="hidden" value="R" name="priority" id="priority" />
		<input type="hidden" value="" name="take_home_medication" id="take_home_medication" />
		<input type="hidden" id = "typeOfHWcheckWithAdd" value="" name="typeOfHWcheck" id="typeOfHWcheck" />				
		<input type="hidden" name="INFUSION_PERIOD_UOM" id="INFUSION_PERIOD_UOM" value='<%=infusion_period_uom%>' >		
		<!--Selected element ID for Height and weight -->
		<input type="hidden" name="valueOfSelectedElem" id="valueOfSelectedElem" id="valueOfSelectedElem" value="">
		<div class="CSTransactionMessage" id="transactionMsg1" style="background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002;">
			<img style="padding-left:15px;vertical-align:middle;" src="${path}/eIPAD/images/PopError.png" onclick="closeToast()"/>
			<span class="rxToastmsg" id="contentRxToastMsg1">No records found</span>
            <div class="formValErrorMsgTheme" id="transactionMessageContent1"></div>
        </div>		
		<div id="confirmMsg" class="absoluteCenter" style="z-index: 10005;">
			<div class="Error_Window">
				<div class="Error_msg_box">
				<div class="Error_msg">
					<div class="Error_msg_Frame">
						<div>
							<div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30"> </div>
							<div class="Error_cont" id="ClinicalNotesConfirmDialogMsg">Are you sure you wish to cancel the current operation?</div>
						</div>
					</div>
				</div>
				</div>
			<div class="Error_msg_btn">
				<div class="Error_btn_div_con" id="okClick" onclick="okClickDialog()">OK </div>
				<div class="Error_btn_div"> </div>
				<div class="Error_btn_div_con" id="cancelClick" onclick="cancelClickDialog()" data-value="true">Cancel </div>
			</div>
			<div class="top_shadow"> </div>
			</div>
		</div>
    </form>
</div>

