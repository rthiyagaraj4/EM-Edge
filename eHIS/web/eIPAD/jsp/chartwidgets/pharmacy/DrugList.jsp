<!DOCTYPE html>
<%@page import="ePH.IVPiggyBackBean"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="ePH.DrugInterfaceControlBean"%>
<%@page import="ePH.IVPrescriptionBean"%>
<%@page import="java.text.DecimalFormat" %>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="ePH.PrescriptionBean"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eDS.Common.JSONObject"%>
<%@page import="eDS.Common.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="ePH.PrescriptionBean_1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% 
String id_drugName_tradeName="";

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	String patient_id = patientContext.getPatientId();
	String encounter_id = patientContext.getEncounterId();
	String patient_class = patientContext.getPatientClass();
	String facility_id = patientContext.getFacilityId();
	String episode_type	= patient_class.substring(0,1);	
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
try{
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;	
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request); 
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;

	String param_bean_id		= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name		= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
	
	IVPiggyBackBean beanBack = (IVPiggyBackBean)PersistenceHelper.getBeanObject("IVPiggyBackBean"+patient_id+encounter_id, "ePH.IVPiggyBackBean", request);
	
  HashMap drug_detail	 =	null;
  ArrayList	presDetails	=(ArrayList) bean.getpresDetails();
  
  /* ivrx list */ 
  ArrayList drugDetails;
  ArrayList AllFluids;
 
  String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_IVD	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
 
  String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_IVPB	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_IVPB	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
  
  String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_IVWA	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
  
  String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patientContext.getPatientId() + patientContext.getEncounterId();
  String bean_name_CRX	= "ePH.IVPrescriptionBean";
  IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);

  boolean cartErrorExists = false;
  float rx_patient_payable_fl = 0;
  float rx_total_charge_fl = 0;
  
  float all_patient_payable_fl = 0;
  float all_total_charge_fl = 0;
%>
<div class="orderDetailsViewCss">
<div  id="addedDrugListWrapper" class="addedDrugListWrapperCss">
<%
if(bean_IVD.getDrugDetails().size()>0 || bean_IVPB.getDrugDetails().size()>0 || bean_IVWA.getAllFluids().size()>0 || bean.getpresDetails().size()>0 || bean_CRX.getDrugDetails().size()>0){
%>
<div  id="wholeDrugListWrapper" class="rxWrapperCss">
<%
  // "this is for RX order type"   
  if(presDetails!=null && presDetails.size()>0){ 
%>
   <div id="drugListScrollerRx" class="drugListScrollerCss">
     <div id="orderType" class="orderTypeCss">
	    <div class="headerIconStyle">
		  <div class="deleteGroupWrapper" onclick="removeAllRX()">
		     <img style="position: absolute;left: 7px;top: 6px;" id="deleteDrugType" src="${path}/eIPAD/images/Delete_group.PNG">
		  </div> 
		</div>
		<div id="collapseWidgetRx">
		<div class="table headerTypeStyle">
		  <div class="row headerOrderName">
		    <div class="cell vAlignBottom">Rx</div>
		  </div>
		  <div class="row headerOrderPrice">
		    <div class="cell vAlignTop"><span id="rx_total_charge_span">--</span>/<span id="rx_patient_payable_span">--</span></div>
		  </div>
		</div>
		<div class="collapseWidgetStyle" id="">
		  <img id="collapseDrugTypeRx" class="collapseCloseWidget" src="${path}/eIPAD/images/Collapse_Widget.png">
	    </div>
		</div>
	 </div>
     <ul id="drugList"  class="drugListCss">      
      <%
     for(int a=0;a<presDetails.size();a++){
		drug_detail=(HashMap) presDetails.get(a);		
		String drugDesc = (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC"); 
        	String drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");						
		String freqDuration = (String)drug_detail.get("DURN_VALUE")==null?"":(String)drug_detail.get("DURN_VALUE"); //"5" for 5 days
		String freqValue = (String)drug_detail.get("FREQ_VALUE")==null?"":(String)drug_detail.get("FREQ_VALUE"); //"3" -- 3 days
		String freq_desc = (String)drug_detail.get("FREQ_DESC")==null?"":(String)drug_detail.get("FREQ_DESC"); //"Three times a day"
		String freq_nature = (String)drug_detail.get("FREQ_NATURE")==null?"":(String)drug_detail.get("FREQ_NATURE");
		String durationDesc = (String)drug_detail.get("DURN_DESC")==null?"":(String)drug_detail.get("DURN_DESC");// "Day(s)"
		String durationType = (String)drug_detail.get("DURN_TYPE")==null?"":(String)drug_detail.get("DURN_TYPE"); 	
		String srlNo = (String)drug_detail.get("SRL_NO")==null?"":(String)drug_detail.get("SRL_NO");
		String dosage_type = (String)drug_detail.get("DOSAGE_TYPE")==null?"":(String)drug_detail.get("DOSAGE_TYPE"); 
		String qtyDesc = (String)drug_detail.get("QTY_DESC")==null?"":(String)drug_detail.get("QTY_DESC"); //Tablet(s)
		String absDesc = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC"); //Absolute
		String formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC"); //Tablet(s)
		String qtyVal = (String)drug_detail.get("QTY_VALUE")==null?"":(String)drug_detail.get("QTY_VALUE");
		//String tradeName = "";
		String tradeName = (String)drug_detail.get("TRADE_NAME")==null?"":(String)drug_detail.get("TRADE_NAME");
		String startDate = (String)drug_detail.get("START_DATE")==null?"":(String)drug_detail.get("START_DATE");
		String strength_uom	= (String) drug_detail.get("STRENGTH_UOM")==null?"":(String)drug_detail.get("STRENGTH_UOM");
		String strength_value = (String) drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
		String patient_payable = (String) drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
		String total_charge = (String) drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
		String  in_formulary_yn = (String) drug_detail.get("IN_FORMULARY_YN")==null?"0":(String)drug_detail.get("IN_FORMULARY_YN");
		String bl_error_code			= (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE"); 
		String bl_sys_message_id		= (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID");
		String bl_error_text			= (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");
		String man_rem_on_prn_freq_yn = (String)drug_detail.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)drug_detail.get("MANDATORY_REM_ON_PRN_FREQ_YN");
		float patient_payable_fl = 0;
		float total_charge_fl = 0;
		String bl_install_yn = orbean.getBillingInterfaceYn() == null ? "" : orbean.getBillingInterfaceYn();
		ArrayList param_vals	=	bean.getParameterValues();
		String bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(2);
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y") && in_formulary_yn.equals("Y")){
			if((bl_error_code.equals("") && bl_sys_message_id.equals("") && bl_error_text.equals(""))){
				patient_payable_fl = Float.parseFloat(patient_payable);
				total_charge_fl = Float.parseFloat(total_charge);
				rx_patient_payable_fl = rx_patient_payable_fl + patient_payable_fl;
				rx_total_charge_fl = rx_total_charge_fl + total_charge_fl;
				all_patient_payable_fl = all_patient_payable_fl + patient_payable_fl;
				all_total_charge_fl = all_total_charge_fl + total_charge_fl;
			}
		}
		String pat_counseling_reqd = (String)drug_detail.get("PAT_COUNSELING_REQD");
		if(pat_counseling_reqd==null||pat_counseling_reqd.equals("")){
			pat_counseling_reqd = "N";
			drug_detail.put("PAT_COUNSELING_REQD",pat_counseling_reqd);
		}
	
		String uom_disp = bean.getUomDisplay(facility_id,strength_uom);
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
		if(startDate==null||startDate.equals("")){
			startDate = df.format(new Date());
			drug_detail.put("START_DATE",startDate);
			
		}
		String endDate = (String)drug_detail.get("END_DATE"); 
		if(endDate==null || endDate.equals("")){//TODO
			endDate = (String)drug_detail.get("END_DATE")==null?(String)drug_detail.get("START_DATE"):(String)drug_detail.get("END_DATE");  
			drug_detail.put("END_DATE",endDate);
		}
		String freq_code = (String)drug_detail.get("FREQ_CODE")==null?"":(String)drug_detail.get("FREQ_CODE");  
		String priority = (String)drug_detail.get("PRIORITY")==null?"":(String)drug_detail.get("PRIORITY");  
		String allow_duplicate = (String) drug_detail.get("ALLOW_DUPLICATE_DRUG")==null?"":(String)drug_detail.get("ALLOW_DUPLICATE_DRUG");
		String allow_duplicate_op				= (String) drug_detail.get("ALLOW_DUPLICATE_DRUG_OP")==null?"":(String)drug_detail.get("ALLOW_DUPLICATE_DRUG_OP");
		
		if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
			allow_duplicate = allow_duplicate_op;
		}
		String current_rx	= (String)drug_detail.get("CURRENT_RX")==null?"N":(String)drug_detail.get("CURRENT_RX");
		
		DateFormat fMonth = new SimpleDateFormat("MMM");
		DateFormat fDate = new SimpleDateFormat("dd");
		DateFormat fYear = new SimpleDateFormat("yyyy");
		Date startDate_dt = df.parse(startDate);
		Date endDate_dt = df.parse(endDate);
		String formattedStartDate = fDate.format(startDate_dt);		
		String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
		String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
		String formattedStartYear = fYear.format(startDate_dt);

		String formattedEndDate = fDate.format(endDate_dt);		
		String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
		String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();
		String formattedEndYear = fYear.format(endDate_dt);		
		String drugMandatoryWarning = "N";
		String allergy_yn	= (String)drug_detail.get("ALLERGY_YN")==null?"N":(String)drug_detail.get("ALLERGY_YN");
		if(allergy_yn.equals("Y")){
			String allergy_remarks = (String)drug_detail.get("ALLERGY_REMARKS")==null?"":(String)drug_detail.get("ALLERGY_REMARKS");
			if(allergy_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		String limit_ind	= (String)drug_detail.get("LIMIT_IND")==null?"Y":(String)drug_detail.get("LIMIT_IND");
		if(limit_ind.equals("N")){
			String dose_remarks = (String)drug_detail.get("DOSE_REMARKS")==null?"":(String)drug_detail.get("DOSE_REMARKS");
			if(dose_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		} 
		String route_code = (String)drug_detail.get("ROUTE_CODE")==null?"":(String)drug_detail.get("ROUTE_CODE");
		if(route_code.equals("")){
			drugMandatoryWarning = "Y";
			cartErrorExists = true;
		}
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id)==null?"":param_bean.getDrugDBInterface_yn(facility_id);
		String drug_db_duptherapy_yn	    =	param_bean.getDrugDBDuptherapy_yn(facility_id)==null?"":param_bean.getDrugDBDuptherapy_yn(facility_id);
		String ext_prod_id					= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID"); 
		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y")){	
			String currentrx_remarks = (String)drug_detail.get("CURRENTRX_REMARKS")==null?"":(String)drug_detail.get("CURRENTRX_REMARKS");
			if(currentrx_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		String interaction_exists	= (String)drug_detail.get("INTERACTION_EXISTS")==null?"N":(String)drug_detail.get("INTERACTION_EXISTS");
		if(interaction_exists.equals("Y")){
			String interaction_remarks = (String)drug_detail.get("INTERACTION_REMARKS")==null?"":(String)drug_detail.get("INTERACTION_REMARKS");
			if(interaction_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		//Checking if PRN rem is mandatory
		if(man_rem_on_prn_freq_yn.equals("Y") && freq_nature.equals("P")){
			String interaction_remarks = (String)drug_detail.get("PRN_REMARKS")==null?"":(String)drug_detail.get("PRN_REMARKS");
			if(interaction_remarks.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}
		}
		HashMap freqValues = (HashMap)bean.populateFrequencyValues(drugCode,freq_code,"modify",patient_class);
		ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
		ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
		ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
		boolean statFeqFound = false;
		boolean def_freq_found = false;
		boolean dup_found = false;
		String statFreqCode = "";
		String freq_option = "";
		if(current_rx.equals("Y") && allow_duplicate.equals("N")){
			dup_found = true;
		}
		drug_detail.put("SCHEDULED_YN","N");//TODO
		if(freq_code.equals("")){
			drugMandatoryWarning = "Y";
			cartErrorExists = true;
		}
		if(freq_nature.equals("")){
			drug_detail.put("FREQ_NATURE","O");//TODO
		}
     if(durationType.equals("") || durationDesc.equals("")){ 
		Hashtable DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
			durationType = "D";
			durationDesc = (String)DurnDescDetails.get("D");
			
			drug_detail.put("DURN_DESC",durationDesc);
			drug_detail.put("DURN_TYPE",durationType);
      } 				
	  
	  /*forenabling the div */
	  String id_drug= drugCode.replaceAll("[-+.^:,]","");
	  String trad="T";
		if(!tradeName.equalsIgnoreCase(""))
		{
		trad=tradeName;
		}
	 String id_trad= trad.replaceAll("[-+.^:,]","");	
     id_drugName_tradeName=id_drug+"_"+id_trad;
      %>
      <li class="drugItemStyleWrapper">
        <div id="drugItem" class="drugItemStyle">
	    <div class="deleteDrugStyleWrapper">
            <div class="deleteDrugStyle deleteRX" data-DrugCode='<%=id_drugName_tradeName%>' data-Drugunique='<%=id_drug%>'  data-DrugType='RX' onclick="removeRXItem('<%=drugCode%>','<%=id_drugName_tradeName%>')">
			    <img id="deleteDrugItem" src="${path}/eIPAD/images/Delete_cart.png">  		   
            </div>
		</div>
	       
	   <div class="drugDetailsWrapper" onclick="openPharmacyRxDetails(<%=a%>)">
	       <div class="drugDetailsStyle"> 
		      <div id="warningWrapper" class="warningWrapperCss">
			     <%
				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 %>    
				 <img style="padding-right:1px;" src="${path}/eIPAD/images/Drug_Warning12x12.png">
				 <%
				 }
				 %>   
			  </div>
	          <div id="div1" class="drugDataContainer">			    				
                 <div id="drugname" class="drugDescription">
                   <%=drugDesc%>
                 </div>
				 <% if(!tradeName.equalsIgnoreCase(""))
				 {
				 %>
				 <div class="drugTradeName">
                    <%=tradeName%>
                 </div>
				 <%
				 }
				 String quantityDesc = "";
				 if(dosage_type.equals("S")){
					 quantityDesc = uom_disp;
				 }
				 
				 else if(dosage_type.equals("Q")){
					 quantityDesc = qtyDesc;
				 }
				 else {
					 quantityDesc = absDesc;
				 }
				 %>
                 <div id="durationdetails" class="durationDetailsWrapper">
                    <%=qtyVal%>&nbsp;<%=quantityDesc%> - <%=freq_desc%> for <%=freqDuration%> <%=durationDesc%>
                 </div>        				
			  </div>
			  <div id="borderDivWrapper" class="borderDivWrapperCss">
			    <div class="borderDivStyle">
			    </div>
			  </div>
			  <div id="div2" class="drugDateDataWrapper">
			    <div id="footerWrapper" style="width:100%;">
				 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>
                 <div class="table toStylingWrapper">
                    <div class="row">
					  <div class="cell toStyleCss">to</div>
					</div>
                 </div>
                 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>
				 <div class="table priceDetailsWrapper">
				    <div class="row">
				    <%if(patient_payable_fl!=0 || total_charge_fl!=0) {%>
					   <div class="cell vAlignMiddle defaultFontColorOnCart"><%=total_charge%></div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">/</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart"><%=patient_payable%></div>
					<%}else{ %>
						<div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">/</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					<%} %>
					</div>
				 </div>
				 <div style="clear: both;"></div>
				</div>
			  </div>
           </div>
	   </div>      		  
	       <div style="clear: both;"></div>
	    </div>    
      </li>     
      <%
      }
      %>
   </ul>
   </div>
 <%
 } 
if(bean_IVD.getDrugDetails().size()>0 || bean_IVPB.getDrugDetails().size()>0 || bean_IVWA.getAllFluids().size()>0){
%>
<input type="hidden" name="hdnIvRxRecSize" id="hdnIvRxRecSize" id="hdnIvRxRecSize" value="y" />
   <div id="drugListScrollerIvrx" class="drugListScrollerCss">
     <div id="orderTypeIvrx" class="orderTypeCss">
	    <div class="headerIconStyle">
		  <div class="deleteGroupWrapper deleteIVIterClass" data-DrugCode='<%=id_drugName_tradeName%>'  onclick="removeAllIVRX()">
		     <img style="position: absolute;left: 7px;top: 6px;" id="deleteDrugType" src="${path}/eIPAD/images/Delete_group.PNG">
		  </div> 
		</div>		
		<div id="collapseWidgetIvrx">		
		<div class="table headerTypeStyle">
		  <div class="row headerOrderName">
		    <div class="cell vAlignBottom">IV</div>
		  </div>
		  <div class="row headerOrderPrice">
		    <div class="cell vAlignTop">--/--</div>
		  </div>
		</div>
		<div class="collapseWidgetStyle" id="">
		  <img id="collapseDrugTypeIvrx" class="collapseCloseWidget" src="${path}/eIPAD/images/Collapse_Widget.png">
	    </div>	
		</div>		
	 </div>  
	 <ul id="drugListIvrx"  class="drugListCss">     
	 <!-- IV with additives : Multiple Drugs, One Fluid-->
	 <%	 
	String drug_db_interface_yn			= "N";
	String drug_db_product_id			= "";
	String drug_db_dosecheck_yn			= "N";
	String drug_db_duptherapy_yn		= "N";
	String drug_db_interact_check_yn	= "N";
	String drug_db_contraind_check_yn	= "N";
	String drug_db_allergy_check_yn		= "N";
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
	 drugDetails =  bean_IVD.getDrugDetails();
	 if(drugDetails.size()>0)
	 {
		HashMap drugDetail2 = (HashMap)drugDetails.get(0);
		String drug_code2 = (String)drugDetail2.get("DRUG_CODE");
		String tradeName2 = (String)drugDetail2.get("TRADE_NAME")==null?"":(String)drugDetail2.get("TRADE_NAME");
		/*forenabling the div */
		String id_drug2= drug_code2.replaceAll("[-+.^:,]","");
		String trad2="T";
		if(!tradeName2.equalsIgnoreCase("")){
			trad2=tradeName2;
		} 
	 	String id_trad2= trad2.replaceAll("[-+.^:,]","");	
     		id_drugName_tradeName=id_drug2+"_"+id_trad2;
	 %>	 
      <li class="drugItemStyleWrapper">
        <div id="drugItemIvrxAdditives" class="drugItemStyle">
	    <div class="deleteDrugStyleWrapper">
            <div class="deleteDrugStyle" data-DrugCode='<%=id_drugName_tradeName%>' onclick="removeAllIVD('<%=drug_code2%>','<%=id_drugName_tradeName%>')">
			    <img id="deleteDrugItemIvrxWithAdd" src="${path}/eIPAD/images/Delete_cart.png">  		   
            </div>
		</div>       
	   <div class="drugDetailsWrapper" onclick='openPharmacyIvrxDetails(event,"IVD");'>
         <div class="drugDetailsStyle">        
	          <div id="div1IvrxWithAdd" style="padding-top:15px;" class="drugDataContainer">
                 <ul id="ivrxDrugListWrapperOnAdd" style="width: 98%;padding: 0px;">
				    <%
				    String drugMandatoryWarning = "N";
					DateFormat df;
					String formattedStartDate="";		
		            String formattedStartMonthSmallCase="";
		            String formattedStartMonth="";		
		            String formattedStartYear="";
		            String formattedEndDate="";		
		            String formattedEndMonthSmallCase="";
		            String formattedEndMonth="";				
		            String formattedEndYear="";		
					String order_type="";
					HashMap FluidDetails = bean_IVD.getFluidDetails();
					for(int c=0;c<drugDetails.size();c++){
						HashMap drugDetail = (HashMap)drugDetails.get(c);
						String drug_desc = (String)drugDetail.get("DRUG_DESC");
						String drug_code = (String)drugDetail.get("DRUG_CODE");
						String qty_desc = (String)drugDetail.get("QTY_DESC");//AMPOULE
						qty_desc = bean.getUomDisplay(facility_id,qty_desc);
						if(qty_desc.equalsIgnoreCase("")||qty_desc==null){
							
							qty_desc=(String)drugDetail.get("QTY_DESC");
						}
						
						drugDetail.put("QTY_DESC",qty_desc);
						
						 order_type = (String)drugDetail.get("ORDER_TYPE");//ORDER_TYPE
						String qty_value = (String)drugDetail.get("QTY_VALUE");//1
						String pres_qty_value=(String)drugDetail.get("PRES_QTY_VALUE");
						String ori_dosage_type=(String)drugDetail.get("ORI_DOSAGE_TYPE");
						String calc_dose_based_on=(String)drugDetail.get("CALC_DOSE_BASED_ON")==null?"":(String)drugDetail.get("CALC_DOSE_BASED_ON"); 
						String calc_dose_value=(String)drugDetail.get("CALC_DOSE_VALUE");
						String pres_qty_uom=(String)drugDetail.get("PRES_QTY_UOM");
						String start_date = (String)drugDetail.get("START_DATE");
						String end_date = (String)drugDetail.get("END_DATE");						
						String freq_desc = (String)drugDetail.get("FREQ_DESC")==null?"":(String)drugDetail.get("FREQ_DESC"); //"Three times a day"
						String freq_duration = (String)drugDetail.get("DURN_VALUE")==null?"":(String)drugDetail.get("DURN_VALUE"); //"5" for 5 days
						String duration_desc = (String)drugDetail.get("DURN_DESC")==null?"":(String)drugDetail.get("DURN_DESC");// "Day(s)"
						String duration_type = (String)drugDetail.get("DURN_TYPE")==null?"":(String)drugDetail.get("DURN_TYPE");// "Day(s)"
						String freq_value = (String)drugDetail.get("FREQ_VALUE")==null?"":(String)drugDetail.get("FREQ_VALUE"); //"3" -- 3 days
						String fluid_durn_value = (String)FluidDetails.get("DURN_VALUE")==null?"24":(String)FluidDetails.get("DURN_VALUE"); //"3" -- 3 days
						df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
		                  if(start_date==null||start_date.equals("")){
			                  start_date = df.format(new Date());
			                  drugDetail.put("START_DATE",start_date);		
		                  }						
		                  if(end_date==null || end_date.equals("")){//TODO
			               end_date = (String)drugDetail.get("END_DATE")==null?(String)drugDetail.get("START_DATE"):(String)drugDetail.get("END_DATE");  
			               drugDetail.put("END_DATE",end_date);
		                  }			
		                  
		                  if(end_date.equalsIgnoreCase("")){
		      		    	
		      		    	end_date=(String)drugDetail.get("START_DATE");
		      		       }
						   	int durn_int = Integer.parseInt(fluid_durn_value);
						   	if(durn_int==0){
						   		fluid_durn_value = "24";
						   	}
							String freq_durations="";
						   /* if(durn_int>=24){
							   
							   freq_durations="24";
						   }else{
							   
							   freq_durations=freq_duration;
						   } */
						   end_date	=  bean_IVD.populateEndDate(start_date,fluid_durn_value,"H");
		                  
						String dosage_type = (String)drugDetail.get("DOSAGE_TYPE");
						String tradeName = (String)drugDetail.get("TRADE_NAME")==null?"":(String)drugDetail.get("TRADE_NAME");
						String dosage_by = "Strength";
						if(dosage_type.equals("S")){
							dosage_by = "Strength";
						}else if(dosage_type.equals("Q")){
							dosage_by = "Quantity";
						}					
						String current_rx = (String)drugDetail.get("CURRENT_RX")==null?"N":(String)drugDetail.get("CURRENT_RX");
						if(current_rx.equals("Y") && !drug_db_duptherapy_yn.equals("Y")) {
							String currentrx_remarks =  (String)drugDetail.get("CURRENTRX_REMARKS")==null?"":(String)drugDetail.get("CURRENTRX_REMARKS");
							if(currentrx_remarks.equals("")){
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}
						String limit_ind	= (String)drugDetail.get("LIMIT_IND")==null?"Y":(String)drugDetail.get("LIMIT_IND");
						if(limit_ind.equals("N") && !drug_db_dosecheck_yn.equals("Y")){
							String dose_remarks = (String)drugDetail.get("DOSE_REMARKS")==null?"":(String)drugDetail.get("DOSE_REMARKS");
							if(dose_remarks.equals("")){
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						} 
						String allergy_yn	= (String)drugDetail.get("ALLERGY_YN")==null?"N":(String)drugDetail.get("ALLERGY_YN");
						if(allergy_yn.equals("Y") && !drug_db_allergy_check_yn.equals("Y")){
							String allergy_remarks = (String)drugDetail.get("ALLERGY_REMARKS")==null?"":(String)drugDetail.get("ALLERGY_REMARKS");
							if(allergy_remarks.equals("")){
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}			


                        	float qty_value_fl = Float.parseFloat(qty_value);
					
				if(qty_value_fl==0){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}						
				DateFormat fMonth = new SimpleDateFormat("MMM");
		                DateFormat fDate = new SimpleDateFormat("dd");
		                DateFormat fYear = new SimpleDateFormat("yyyy");
		                Date startDate_dt = df.parse(start_date);
		                Date endDate_dt = df.parse(end_date);		
		                formattedStartDate = fDate.format(startDate_dt);		
		                formattedStartMonthSmallCase = fMonth.format(startDate_dt);
		                formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
		                formattedStartYear = fYear.format(startDate_dt);
		                formattedEndDate = fDate.format(endDate_dt);		
		                formattedEndMonthSmallCase = fMonth.format(endDate_dt);
		                formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
		                formattedEndYear = fYear.format(endDate_dt);			
						 /*forenabling the div */
	                    String id_drug= drug_code.replaceAll("[-+.^:,]","");
	                    String trad="T";
		                if(!tradeName.equalsIgnoreCase(""))
		                {	
		                 trad=tradeName;
		                }	 
	                    String id_trad= trad.replaceAll("[-+.^:,]","");	
                            id_drugName_tradeName=id_drug+"_"+id_trad;
				    %>				    
				    <li id="ivrxDrugListOnAddingWithAdd" style="list-style: none;padding-bottom:10px;">
                      <div id="drugnameIvrxWithAdd" class="drugDescription table">
                        <div class="row">
						<div class="cell drugDescriptionInnerCss">
                          <%=drug_desc%>
                        </div>		
			
                        <div class="cell deleteDrugCss deleteIV deleteAllIVD" style="vertical-align:top;" data-DrugType='IVWA'  data-DrugCode='<%=id_drugName_tradeName%>' onclick="removeIVWithAdd('<%=drug_code%>',event,'<%=id_drugName_tradeName%>')">  
<%if(order_type.equalsIgnoreCase("Normal"))	{	%>							
                           <img src="${path}/eIPAD/images/Cart_delete_drug12x12.png">
						   <% } %>
                        </div>

                        </div>
                      </div>
				      <% if(!tradeName.equalsIgnoreCase(""))
					 {
					 %>
					 <div class="drugTradeName">
	                    <%=tradeName%>
	                 </div>
					 <%
					 }
				      %>				 
                      <div id="durationdetailsIvrxWithAdd" class="durationDetailsWrapper">
						<% if(calc_dose_based_on.equals("B")){
							ori_dosage_type="Q";
						}%>
					  
						<% if (ori_dosage_type.equals("Q")) {
							 if (calc_dose_based_on.equals("B")) {%>
								<%=calc_dose_value%> <%=pres_qty_uom%>
							<%} else {%>
								<%=pres_qty_value%> <%=qty_desc%>
							<%}}
						if (ori_dosage_type.equals("S")) {%>
							<%=qty_value%> <%=qty_desc%>
						<%}%>
                      </div>
				    </li>
					<%
					}
					%>
                 </ul>                       
			  </div>
			  <div id="borderDivWrapperIvrxWithAdd" class="borderDivWrapperCss borderDivWrapperIvrxStyle">
			    <div class="fluidDescriptionCss">
				     <%
				     
				     String fluid_drug_desc = (String)FluidDetails.get("DRUG_DESC");
					String fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
                    fluid_qty_uom_desc = bean.getUomDisplay(facility_id,fluid_qty_uom_desc);
					
					if(fluid_qty_uom_desc.equalsIgnoreCase("")||fluid_qty_uom_desc==null){
							
							fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
						}
						FluidDetails.put("PRES_BASE_UOM_DESC",fluid_qty_uom_desc);
						
					String fluid_qty_uom = (String)FluidDetails.get("QTY_UOM");
					String fluid_qty_value = (String)FluidDetails.get("QTY_VALUE");						
					String INFUSION_PERIOD_VALUE = (String)FluidDetails.get("INFUSION_PERIOD_VALUE");
					String INFUSION_PERIOD_VALUE_MIN = (String)FluidDetails.get("INFUSION_PERIOD_VALUE_MIN");					
					String fluid_tradeName = (String)FluidDetails.get("TRADE_NAME")==null?"":(String)FluidDetails.get("TRADE_NAME");
					String Fluid_drugcode = (String)FluidDetails.get("DRUG_CODE");
					String infusion_over = bean_IVD.getINFUSE_OVER();
					if(infusion_over.equals("")){
						infusion_over = "0";
					}
					float infusion_over_fl = Float.parseFloat(infusion_over);
					String 	inf_over_displaystr = INFUSION_PERIOD_VALUE+" Hrs "+INFUSION_PERIOD_VALUE_MIN+" Mins";
					if(infusion_over_fl==0){
						drugMandatoryWarning = "Y";
						cartErrorExists = true;
					}
					
				 	 if(FluidDetails.isEmpty() || Fluid_drugcode==null ||Fluid_drugcode.equals("")){
				 		drugMandatoryWarning = "Y";
						cartErrorExists = true;				 	 				 		
				     %>
				     <div class="fluidDescFontStyle">Fluid not selected</div>
				     <%
				 	 }else{
				 		
				     %>
				     <div id="fluidnameIvrxWithAdd" style="padding-top:15px;text-align:left;padding-left:1px;" class="drugDescription">
                         <%=fluid_drug_desc%>
                     </div>
                     <div id="durationdetailsIvrxWithAddFluid" style="text-align:left;padding-left:1px;" class="durationDetailsWrapper">
                         <%=fluid_qty_value%> <%=fluid_qty_uom_desc%> over  <%=inf_over_displaystr %>
                     </div>
                     <%
				 	 }
                     %>
				</div>
				<div class="ivrxTypeDescriptionCss">
                    IV WITH ADDITIVES
			    </div>			   
			  </div>		 
			  <div id="div2IvrxWithAdd" class="drugDateDataWrapper">
			    <div style="width:100%;">
				 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>
                 <div class="table toStylingWrapper">
                    <div class="row">
					  <div class="cell toStyleCss">to</div>
					</div>
                 </div>
                 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>
				 <div class="table priceDetailsWrapper">
				    <div class="row">
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">/</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					</div>
				 </div>
				 <div style="clear: both;"></div>
				</div>
			  </div>
        </div>
	   </div>   
	     <%
				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 %>        
                 <div id="warningWrapperIvrxWithAdd" style="right: 6px;position: absolute;height: 15px;">			         
				 	<img src="${path}/eIPAD/images/Drug_Warning12x12.png">				   
			  	</div>  
			  	 <%
				 }
				 %> 	         
	   <div style="clear: both;"></div>
	   </div>    
      </li>
      <%
	  }	 
	  AllFluids = bean_IVWA.getAllFluids();
	  if(AllFluids.size()>0){	  
      %>	  
	  <!-- IV without additives : Multiple Fluids-->
	  <ul id="drugList"  class="drugListCss">	  
	  <%
	  for(int c=0;c<AllFluids.size();c++){		  
		  	String drugMandatoryWarning = "N";
			HashMap fluidDetail = (HashMap)AllFluids.get(c);
			String drug_desc = (String)fluidDetail.get("DRUG_DESC");
			String drug_code = (String)fluidDetail.get("DRUG_CODE");
			String qty_desc = (String)fluidDetail.get("QTY_DESC");//ml
			String qty_value = (String)fluidDetail.get("QTY_VALUE"); // 1 ml
			String pres_base_uom_desc = (String)fluidDetail.get("PRES_BASE_UOM_DESC");//Bottle
			String pres_qty_value = (String)fluidDetail.get("PRES_QTY_VALUE");//1 bottle
			String start_date = (String)fluidDetail.get("START_DATE");
			String end_date = (String)fluidDetail.get("END_DATE");
			String infusion_over = (String)fluidDetail.get("INFUSE_OVER");
				String infusion_over_hrs = (String)fluidDetail.get("INFUSION_PERIOD_VALUE");
					String infusion_over_mins = (String)fluidDetail.get("INFUSION_PERIOD_VALUE_MIN");
			if(infusion_over.equals("")){
				infusion_over = "0";
			}
			float infusion_over_fl = Float.parseFloat(infusion_over);
			int infusion_period_value = new Double(infusion_over_fl).intValue();
			int infusion_period_value_min = new Double(Math.ceil((infusion_over_fl)*60)%60).intValue();			
			String 	inf_over_displaystr = infusion_over_hrs+" Hrs "+infusion_over_mins+" Mins";	
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
		            if(start_date==null||start_date.equals("")){
			                  start_date = df.format(new Date());
			                  fluidDetail.put("START_DATE",start_date);		
		            }						
		            if(end_date==null || end_date.equals("")){//TODO
			               end_date = (String)fluidDetail.get("END_DATE")==null?(String)fluidDetail.get("START_DATE"):(String)fluidDetail.get("END_DATE");  
			               fluidDetail.put("END_DATE",end_date);
		            }		
			String infuse_over = (String)fluidDetail.get("INFUSE_OVER");
			String tradeName = (String)fluidDetail.get("TRADE_NAME")==null?"":(String)fluidDetail.get("TRADE_NAME");
			if(infuse_over.equals("")){
				infuse_over = "0";
			}
			float infuse_over_fl = Float.parseFloat(infuse_over);
			if(infuse_over_fl==0 ){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}	        
			DateFormat fMonth = new SimpleDateFormat("MMM");
            DateFormat fDate = new SimpleDateFormat("dd");
            DateFormat fYear = new SimpleDateFormat("yyyy");
            Date startDate_dt = df.parse(start_date);
            Date endDate_dt = df.parse(end_date);
            String formattedStartDate = fDate.format(startDate_dt);		
            String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
            String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
            String formattedStartYear = fYear.format(startDate_dt);
            String formattedEndDate = fDate.format(endDate_dt);		
            String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
            String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
            String formattedEndYear = fYear.format(endDate_dt);	
			int c_Value = c+1;
			 /*forenabling the div */
	                    String id_drug= drug_code.replaceAll("[-+.^:,]","");
	                    String trad="T";
		                if(!tradeName.equalsIgnoreCase(""))
		                {	
		                 trad=tradeName;
		                }	 
	                    String id_trad= trad.replaceAll("[-+.^:,]","");	
                        id_drugName_tradeName=id_drug+"_"+id_trad;
	  %>
	  <li class="drugItemStyleWrapper">
        <div id="drugItemIvrxWithoutAdditives" class="drugItemStyle">
	    <div class="deleteDrugStyleWrapper">
            <div class="deleteDrugStyle deleteIV" data-DrugCode='<%=id_drugName_tradeName%>' data-DrugType='IVWOA' onclick="removeIVWithoutAdd('<%=drug_code%>','<%=c_Value%>','<%=id_drugName_tradeName%>')">
			    <img id="deleteDrugItem" src="${path}/eIPAD/images/Delete_cart.png">  		   
            </div>
		</div>	       
	   <div class="drugDetailsWrapper" onclick="openPharmacyIvRxWaDetails(<%=c%>)">
	       <div class="drugDetailsStyle"> 
		      <div id="warningWrapperIvrxWithoutAdd" class="warningWrapperCss">
			       <%
				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 %>  
				 <img style="padding-right:1px;" src="${path}/eIPAD/images/Drug_Warning12x12.png">
				   <%
				 }
				 %> 
			  </div>
	          <div id="div1IvrxWithoutAdd" class="drugDataContainer">			    				
                 <div id="drugnameIvrxWithoutAdd" class="drugDescription">
                   <div class="drugDescriptionInnerCss">
                     <%=drug_desc%>
                   </div>
                   <div class="deleteDrugCss">                     
                   </div>
                 </div>				
				 <% if(!tradeName.equalsIgnoreCase(""))
				 {
				 %>
				 <div class="drugTradeName">
                    <%=tradeName%>
                 </div>
				 <%
				 }
				 %>				 
                 <div id="durationdetails" class="durationDetailsWrapper">
                    <%=qty_value%> <%=pres_base_uom_desc%> over  <%=inf_over_displaystr %>
                 </div>               				
			  </div>
			  <div id="borderDivWrapperWithoutAdd" class="borderDivWrapperCss">
			    <div class="borderDivStyle">
			       <div class="ivrxWithoutAddTypeDescriptionCss">
                    IV WITHOUT ADDITIVES
			       </div>
				</div>
			  </div>			  
			  <div id="div2IvrxWithoutAdd" class="drugDateDataWrapper">
			    <div style="width:100%;">
				 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>
                 <div class="table toStylingWrapper">
                    <div class="row">
					  <div class="cell toStyleCss">to</div>
					</div>
                 </div>
                 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>
				 <div class="table priceDetailsWrapper">
				    <div class="row">
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">/</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					</div>
				 </div>
				 <div style="clear: both;"></div>
				</div>
			  </div>
           </div>
	   </div>     
	     <div style="clear: both;"></div>
	    </div>    
      </li>
      <%
	  }
      %>
      </ul>
	  <%
	  }	    
	  drugDetails =  bean_IVPB.getDrugDetails();		
	  if(drugDetails.size()>0){
		  String drugMandatoryWarning = "N";
		  HashMap drugDetail = (HashMap)drugDetails.get(0);		  
			String drug_desc = (String)drugDetail.get("DRUG_DESC");
			String qty_desc = (String)drugDetail.get("QTY_DESC");
			String qty_value = (String)drugDetail.get("PRES_QTY_VALUE");
			String DOSAGE_TYPE = (String)drugDetail.get("DOSAGE_TYPE");	
			
			String pres_qty_value=(String)drugDetail.get("PRES_QTY_VALUE");
			String ori_dosage_type=(String)drugDetail.get("ORI_DOSAGE_TYPE");
			String calc_dose_based_on=(String)drugDetail.get("CALC_DOSE_BASED_ON")==null?"":(String)drugDetail.get("CALC_DOSE_BASED_ON"); 
			String calc_dose_value=(String)drugDetail.get("CALC_DOSE_VALUE");
			String pres_qty_uom=(String)drugDetail.get("PRES_QTY_UOM");
			
			if(DOSAGE_TYPE.equalsIgnoreCase("S")){
				String strength_value = (String)drugDetail.get("STRENGTH_VALUE");
				drugDetail.put("PRES_QTY_VALUE", strength_value);
			}					
			String drugCode = (String)drugDetail.get("DRUG_CODE")==null?"":(String)drugDetail.get("DRUG_CODE");	
			String start_date = (String)drugDetail.get("START_DATE");
			String end_date = (String)drugDetail.get("END_DATE");		
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO
            if(start_date==null||start_date.equals("")){
			    start_date = df.format(new Date());
			    drugDetail.put("START_DATE",start_date);		
		    }						
		    if(end_date==null || end_date.equals("")){//TODO
			   end_date = (String)drugDetail.get("END_DATE")==null?(String)drugDetail.get("START_DATE"):(String)drugDetail.get("END_DATE");  
			   drugDetail.put("END_DATE",end_date);
		    }			
		    if(end_date.equalsIgnoreCase("")){
		    	
		    	end_date=(String)drugDetail.get("START_DATE");
		    }
			String dosage_type = (String)drugDetail.get("DOSAGE_TYPE");
			String tradeName = (String)drugDetail.get("TRADE_NAME")==null?"":(String)drugDetail.get("TRADE_NAME");
			String dosage_by = "Strength";
			if(dosage_type.equals("S")){
				qty_value=(String)drugDetail.get("PRES_QTY_VALUE")==null?"":(String)drugDetail.get("PRES_QTY_VALUE");
				dosage_by = "Strength";
			}else if(dosage_type.equals("Q")){
				dosage_by = "Quantity";
			}			
			
			 float qty_value_flw = Float.parseFloat(qty_value);
					
						if(qty_value_flw==0){
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}

						
						
						
			String current_rx = (String)drugDetail.get("CURRENT_RX")==null?"N":(String)drugDetail.get("CURRENT_RX");
			if(current_rx.equals("Y") && !drug_db_duptherapy_yn.equals("Y")) {
				String currentrx_remarks =  (String)drugDetail.get("CURRENTRX_REMARKS")==null?"":(String)drugDetail.get("CURRENTRX_REMARKS");
				if(currentrx_remarks.equals("")){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}
			}
			String limit_ind	= (String)drugDetail.get("LIMIT_IND")==null?"Y":(String)drugDetail.get("LIMIT_IND");
			if(limit_ind.equals("N") && !drug_db_dosecheck_yn.equals("Y")){
				String dose_remarks = (String)drugDetail.get("DOSE_REMARKS")==null?"":(String)drugDetail.get("DOSE_REMARKS");
				if(dose_remarks.equals("")){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}
			} 
			String allergy_yn	= (String)drugDetail.get("ALLERGY_YN")==null?"N":(String)drugDetail.get("ALLERGY_YN");
			if(allergy_yn.equals("Y") && !drug_db_allergy_check_yn.equals("Y")){
				String allergy_remarks = (String)drugDetail.get("ALLERGY_REMARKS")==null?"":(String)drugDetail.get("ALLERGY_REMARKS");
				if(allergy_remarks.equals("")){
					drugMandatoryWarning = "Y";
					cartErrorExists = true;
				}
			}
			String freq_code = (String)drugDetail.get("FREQ_CODE");
			
			ArrayList freqValues = beanBack.getSheduleFrequency(drugCode);				
			if( freqValues.size()>0){
				String contains="no";
				for (int i=0;i<freqValues.size();i+=2){
					//System.out.println("addFrequencyList(\""+((String)freqValues.get(i))+"\",\""+((String)freqValues.get(i+1))+"\",\""+freq_code.trim()+"\")");
					
					String genertedCode=(String)freqValues.get(i);
				
					if(genertedCode.equals(freq_code.trim())){
						contains="yes";
					}
					
				}
				
				if(contains.equalsIgnoreCase("no")){
					
					freq_code="";
				}
			}
			
			
			if(freq_code==null || freq_code.equals("")){
				drugMandatoryWarning = "Y";
				cartErrorExists = true;
			}			
			DateFormat fMonth = new SimpleDateFormat("MMM");
            DateFormat fDate = new SimpleDateFormat("dd");
            DateFormat fYear = new SimpleDateFormat("yyyy");
            Date startDate_dt = df.parse(start_date);
            Date endDate_dt = df.parse(end_date);
            String formattedStartDate = fDate.format(startDate_dt);		
            String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
            String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
            String formattedStartYear = fYear.format(startDate_dt);
            String formattedEndDate = fDate.format(endDate_dt);		
            String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
            String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
            String formattedEndYear = fYear.format(endDate_dt);
			/*forenabling the div */
	                    String id_drug= drugCode.replaceAll("[-+.^:,]","");
	                    String trad="T";
		                if(!tradeName.equalsIgnoreCase(""))
		                {	
		                 trad=tradeName;
		                }	 
	                    String id_trad= trad.replaceAll("[-+.^:,]","");	
                        id_drugName_tradeName=id_drug+"_"+id_trad;		
	  %>
	  <!-- IV Intermittent : One Drug, One Fluid-->
	  <li class="drugItemStyleWrapper">
        <div id="drugItemIvrxIntermittent" class="drugItemStyle">
	    <div class="deleteDrugStyleWrapper">
            <div class="deleteDrugStyle deleteIV" data-DrugCode='<%=id_drugName_tradeName%>' data-DrugType="IVInter"  onclick="RemoveIVIntermittent('<%=id_drugName_tradeName%>')">
			    <img id="deleteDrugItemIvrxInter" src="${path}/eIPAD/images/Delete_cart.png">  		   
            </div>
		</div>      
	   <div class="drugDetailsWrapper" onclick='openPharmacyIvrxDetails(event,"IVPB");'>
         <div class="drugDetailsStyle">            
	          <div id="div1IvrxInter" style="padding-top:15px;" class="drugDataContainer">
                 <ul id="ivrxDrugListWrapperOnAdd" style="width: 98%;padding: 0px;">
				    <li id="ivrxDrugListOnAddingWithoutAdd" style="list-style: none;">
				      <div id="drugnameIvrxWithoutAdd" class="drugDescription">
                         <div class="drugDescriptionInnerCss">
                           <%=drug_desc%>
                         </div>
                         <div class="deleteDrugCss">                     
                         </div>
                      </div>				 
				      <% if(!tradeName.equalsIgnoreCase(""))
					 {
					 %>
					 <div class="drugTradeName">
	                    <%=tradeName%>
	                 </div>
					 <%
					 }
				 	%>
                      <div id="durationdetailsIvrx" class="durationDetailsWrapper">					  
					  <% if(calc_dose_based_on.equals("B")){
						ori_dosage_type="Q";
					  }%>					  
					<% if (ori_dosage_type.equals("Q")) {
							if (calc_dose_based_on.equals("B")) {%>
								<%=calc_dose_value%> <%=pres_qty_uom%>
							<%} else {%>
								<%=pres_qty_value%> <%=qty_desc%>
							<%}}
					if (ori_dosage_type.equals("S")) {%>
						<%=qty_value%> <%=qty_desc%>
					<%}%>						
                      </div>
				    </li>
                 </ul>                 
			  </div>
			  <div id="borderDivWrapperIvrxInter" class="borderDivWrapperCss borderDivWrapperIvrxStyle">
			    <div class="fluidDescriptionCss">
			      <%
			      HashMap FluidDetails = bean_IVPB.getFluidDetails();
	              if(FluidDetails.isEmpty()){
	            	  
	            	  drugMandatoryWarning = "Y";
	  					cartErrorExists = true;		           
	              %>
				     <div class="fluidDescFontStyle">Fluid not selected</div>
				  <%
	              }else{
	            	String fluid_drug_desc = (String)FluidDetails.get("DRUG_DESC");
	            	String fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
					 fluid_qty_uom_desc = bean.getUomDisplay(facility_id,fluid_qty_uom_desc);
					 if(fluid_qty_uom_desc.equalsIgnoreCase("")||fluid_qty_uom_desc==null){
							
							fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
						}
						
						FluidDetails.put("PRES_BASE_UOM_DESC",fluid_qty_uom_desc);
	          		String fluid_qty_uom = (String)FluidDetails.get("QTY_UOM");
	          		String fluid_qty_value = (String)FluidDetails.get("QTY_VALUE");
	          		String fluid_tradeName = (String)FluidDetails.get("TRADE_NAME")==null?"":(String)FluidDetails.get("TRADE_NAME");
					String infusion_over = bean_IVPB.getINFUSE_OVER();
					String INFUSION_PERIOD_VALUE = (String)FluidDetails.get("INFUSION_PERIOD_VALUE");					
					String INFUSION_PERIOD_VALUE_MIN = (String)FluidDetails.get("INFUSION_PERIOD_VALUE_MIN");					
					String 	inf_over_displaystr = INFUSION_PERIOD_VALUE+" Hrs "+INFUSION_PERIOD_VALUE_MIN+" Mins";				
					if(infusion_over.equals("")){
						infusion_over = "0";
					}
					float infusion_over_fl = Float.parseFloat(infusion_over);					
					if(infusion_over_fl==0){
						drugMandatoryWarning = "Y";
						cartErrorExists = true;
					}
				  %>
				  <div id="fluidnameIvrxWithInter" style="padding-top:15px;text-align:left;" class="drugDescription">
                         <%=fluid_drug_desc%>
                  </div>
                  <div id="durationdetailsIvrxWithInterFluid" style="text-align:left;" class="durationDetailsWrapper">
                       <%=fluid_qty_value%> <%=fluid_qty_uom_desc%> over  <%=inf_over_displaystr %>
                  </div>
				  <%
				  }
				  %>     
				</div>
				<div class="ivrxTypeDescriptionCss">
                    IV INTERMITTENT
			    </div>	
			  </div>			  
			  <div id="div2IvrxInter" class="drugDateDataWrapper">
			    <div style="width:100%;">
				 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>
                 <div class="table toStylingWrapper">
                    <div class="row">
					  <div class="cell toStyleCss">to</div>
					</div>
                 </div>
                 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>
				 <div class="table priceDetailsWrapper">
				    <div class="row">
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">/</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					</div>
				 </div>
				 <div style="clear: both;"></div>
				</div>
			  </div>
        </div>
	   </div> 
	       <%
				  if(drugMandatoryWarning.equalsIgnoreCase("Y")){ 
				 %>        
                 <div id="warningWrapperIvrxWithInter" style="right: 6px;position: absolute;height: 15px;">
			         
				 	<img src="${path}/eIPAD/images/Drug_Warning12x12.png">
				   
			  	</div>  
			  	 <%
				 }
				 %>      
	    <div style="clear: both;"></div>
	    </div>    
      </li>
	  <%
	  }
	  %>
   </ul>
   </div>
   <%
   }
   drugDetails =  bean_CRX.getDrugDetails();		
   if(drugDetails.size()>0){
	String drugMandatoryWarning = "N";
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
	String start_date_fluid="";
	String end_date_fluid="";
   %>
  <!-- CRX Bubble Starts--> 
   <div id="drugListScrollerCRX" class="drugListScrollerCss">
     <div id="orderTypeCRX" class="orderTypeCss">
	    <div class="headerIconStyle">
		  <div class="deleteGroupWrapper deleteIVIterClass" data-DrugCode='id_drugName_tradeName'  onclick="removeAllCRX()">
		     <img style="position: absolute;left: 7px;top: 6px;" id="deleteDrugTypeCRX" src="${path}/eIPAD/images/Delete_group.PNG">
		  </div> 
		</div>		
		<div id="collapseWidgetCRX">		
		<div class="table headerTypeStyle">
		  <div class="row headerOrderName">
		    <div class="cell vAlignMiddle">CRX</div>
		  </div>
		</div>
		<div class="collapseWidgetStyle" id="">
		  <img id="collapseDrugTypeCRX" class="collapseCloseWidget" src="${path}/eIPAD/images/Collapse_Widget.png">
	    </div>	
		</div>		
	 </div>  
	 <ul id="drugListCrx"  class="drugListCss">
      <li class="drugItemStyleWrapper">
        <div id="drugItemIvrxAdditives" class="drugItemStyle">
	    <div class="deleteDrugStyleWrapper">
            <div class="deleteDrugStyle" data-DrugCode='id_drugName_tradeName' onclick="removeAllCRX()">
			    <img id="deleteDrugItemIvrxWithAdd" src="${path}/eIPAD/images/Delete_cart.png">  		   
            </div>
		</div>       
	    <div class="drugDetailsWrapper" onclick='openPharmacyCrxDetails("CRX","<%=drugDetails.size() %>");'>
            <div class="drugDetailsStyle">        
	          <div id="div1IvrxWithAdd" style="padding-top:15px;" class="drugDataContainer">
					<ul id="ivrxDrugListWrapperOnAdd" style="width: 98%;padding: 0px;">
					<%
					ArrayList freqValues = (ArrayList) bean_CRX.loadFrequency();
					String bl_patient_payable = "";
					String bl_charge_amt = "";
					float patient_payable = 0;
					float total_charge = 0;
					String freqDuration = "";
					String durnType = "";
					String interval_value = "";
					String freq_desc = "";
					String dosageval = "";
					String dosageuom = "";
					String ordered_qty = "";
					String qty_unit = "";
					String eqvl_value = "";
					String ing_order_uom = "";
					String qty_value = "";
					String freq_code = bean_CRX.getFREQ_CODE();
					String bl_install_yn = orbean.getBillingInterfaceYn() == null ? "" : orbean.getBillingInterfaceYn();
					ArrayList param_vals = bean.getParameterValues();
					String bl_disp_charge_dtl_in_rx_yn = (String) param_vals.get(2);
					String pack_size = "";
					String durn_value = "";
					String bl_decimal_format_string = "#0.00";
					DecimalFormat dfTest = dfTest = new DecimalFormat(bl_decimal_format_string);
					durn_value = request.getParameter("durn_value") == null ? "" : request.getParameter("durn_value");
					for (int c = 0; c < drugDetails.size(); c++) {
						HashMap drugDetail = (HashMap) drugDetails.get(c);
						String allergy_yn = (String) drugDetail.get("ALLERGY_YN") == null ? "N" : (String) drugDetail.get("ALLERGY_YN");
						if (allergy_yn.equals("Y")) {
							String allergy_remarks = (String) drugDetail.get("ALLERGY_REMARKS") == null ? "" : (String) drugDetail.get("ALLERGY_REMARKS");
							if (allergy_remarks.equals("")) {
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}
						String doseOverride = (String) drugDetail.get("DOSE_OVERRIDE") == null ? "N" : (String) drugDetail.get("DOSE_OVERRIDE");
						if (doseOverride.equals("Y")) {
							String doseRemark = (String) drugDetail.get("DOSE_REMARKS") == null ? "" : (String) drugDetail.get("DOSE_REMARKS");
							if (doseRemark.equals("")) {
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}

						String currentRx = (String) drugDetail.get("CURRENT_RX") == null ? "N" : (String) drugDetail.get("CURRENT_RX");
						if (currentRx.equals("Y")) {
							String currentRemark = (String) drugDetail.get("CURRENTRX_REMARKS") == null ? "" : (String) drugDetail.get("CURRENTRX_REMARKS");
							if (currentRemark.equals("")) {
								drugMandatoryWarning = "Y";
								cartErrorExists = true;
							}
						}

						start_date_fluid = (String) drugDetail.get("START_DATE") == null ? "" : (String) drugDetail.get("START_DATE");
						end_date_fluid = (String) drugDetail.get("END_DATE") == null ? "" : (String) drugDetail.get("END_DATE");
						double iOrdQty = 0;
						String drugDesc = (String) drugDetail.get("DRUG_DESC") == null ? "" : (String) drugDetail.get("DRUG_DESC");
						String drugCode = (String) drugDetail.get("DRUG_CODE") == null ? "" : (String) drugDetail.get("DRUG_CODE");
						pack_size = bean_CRX.getPackSize(drugCode);
						String tradeName = (String) drugDetail.get("TRADE_NAME") == null ? "" : (String) drugDetail.get("TRADE_NAME");

						freqDuration = (String) drugDetail.get("DURN_VALUE") == null ? "" : (String) drugDetail.get("DURN_VALUE");
						if (freqDuration.equals("0")) {
							freqDuration = "1";
						}
						durnType = (String) drugDetail.get("DURN_TYPE") == null ? "" : (String) drugDetail.get("DURN_TYPE");
						
						qty_value = (String) drugDetail.get("ORDER_QTY");						
						if (qty_value == null || qty_value.equals(""))
							qty_value = "0";					
						
						float ing_unit_qty = Float.parseFloat(qty_value);
						
						String freqValue = (String) drugDetail.get("FREQ_VALUE") == null ? "" : (String) drugDetail.get("FREQ_VALUE");
						bl_decimal_format_string = (String) drugDetail.get("BL_DECIMAL_FORMAT_STRING") == null ? "#0" : (String) drugDetail.get("BL_DECIMAL_FORMAT_STRING");
						String freq_nature = (String) drugDetail.get("FREQ_NATURE") == null ? "" : (String) drugDetail.get("FREQ_NATURE");
						interval_value = (String) drugDetail.get("INTERVAL_VALUE") == null ? "" : (String) drugDetail.get("INTERVAL_VALUE");
						String srlNo = (String) drugDetail.get("SRL_NO") == null ? "" : (String) drugDetail.get("SRL_NO");
						String dosage_type = (String) drugDetail.get("DOSAGE_TYPE") == null ? "" : (String) drugDetail.get("DOSAGE_TYPE");
						String qtyDesc = (String) drugDetail.get("QTY_DESC") == null ? "" : (String) drugDetail.get("QTY_DESC");
						String absDesc = (String) drugDetail.get("PRES_BASE_UOM_DESC") == null ? "" : (String) drugDetail.get("PRES_BASE_UOM_DESC");
						String formDesc = (String) drugDetail.get("FORM_DESC") == null ? "" : (String) drugDetail.get("FORM_DESC");
						String qtyVal = (String) drugDetail.get("QTY_VALUE") == null ? "" : (String) drugDetail.get("QTY_VALUE");
						String totalqty = (String) drugDetail.get("TOTAL_QTY") == null ? "" : (String) drugDetail.get("TOTAL_QTY");
						String orderqty = (String) drugDetail.get("ORDER_QTY") == null ? "" : (String) drugDetail.get("ORDER_QTY");
						String pres_by = (String) drugDetail.get("PRES_BY_BASE") == null ? "" : (String) drugDetail.get("PRES_BY_BASE");
						dosageval = (String) drugDetail.get("DOSAGE_VALUE") == null ? "" : (String) drugDetail.get("DOSAGE_VALUE");
						dosageuom = (String) drugDetail.get("DOSAGE_UOM") == null ? "" : (String) drugDetail.get("DOSAGE_UOM");
						durn_value = (String) drugDetail.get("DURN_VALUE") == null ? "" : (String) drugDetail.get("DURN_VALUE");
						
						String item_code = (String) drugDetail.get("ITEM_CODE") == null ? "" : (String) drugDetail.get("ITEM_CODE");
						String fract_dose = (String) drugDetail.get("FRACT_DOSE_ROUND_UP_YN") == null ? "" : (String) drugDetail.get("FRACT_DOSE_ROUND_UP_YN");
						String strength_per_value_pres_uom = (String) drugDetail.get("STRENGTH_PER_VALUE_PRES_UOM") == null ? "" : (String) drugDetail.get("STRENGTH_PER_VALUE_PRES_UOM");
						String strength_per_pres_uom = (String) drugDetail.get("STRENGTH_PER_PRES_UOM") == null ? "" : (String) drugDetail.get("STRENGTH_PER_PRES_UOM");
						String amend_repeat_value = (String) drugDetail.get("amend_repeat_value") == null ? "" : (String) drugDetail.get("amend_repeat_value");
						if (amend_repeat_value.equals(""))
							amend_repeat_value = (String) drugDetail.get("REPEAT_VALUE") == null ? "1" : (String) drugDetail.get("REPEAT_VALUE");
						String amend_durn_value = (String) drugDetail.get("amend_durn_value") == null ? "" : (String) drugDetail.get("amend_durn_value");
						if (amend_durn_value.equals(""))
							amend_durn_value = (String) drugDetail.get("DURN_VALUE") == null ? "" : (String) drugDetail.get("DURN_VALUE");
						if (item_code.equals("")) {
							item_code = (String) drugDetail.get("ORDER_CATALOG_CODE");
						}

						float in_tot_qty = 0.0f;						
						if (dosage_type != null) {
							if (dosage_type.equals("S")) {
								in_tot_qty = 0.0f;
								if (fract_dose.equals("Y")) {
									in_tot_qty = new Double(Math.ceil(ing_unit_qty / Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
								} else {
									in_tot_qty = new Double(Math.ceil(ing_unit_qty / Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(strength_per_value_pres_uom))).floatValue();
								}								
								if (freq_nature.equals("I")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(durn_value)) * (24 / (Float.parseFloat(interval_value)));
								} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(amend_repeat_value)) * (Float.parseFloat(amend_durn_value));
								} else if (freq_nature.equals("O")) {
									in_tot_qty = in_tot_qty;
								}
								ordered_qty = in_tot_qty + "";
								ordered_qty = (Math.ceil(Float.parseFloat(ordered_qty) / Float.parseFloat(pack_size))) + "";
							} else {
								qty_unit = (String) drugDetail.get("QTY_DESC_CODE");
								ing_order_uom = (String) drugDetail.get("PRES_BASE_UOM");
								eqvl_value = bean_CRX.getConvFactor(ing_order_uom, qty_unit);
								if (eqvl_value.equals("")) eqvl_value = "1";
								in_tot_qty = 0.0f;
								if (fract_dose.equals("Y")) {
									in_tot_qty = new Double(Math.ceil(ing_unit_qty / (Float.parseFloat(pack_size)))).floatValue() * Float.parseFloat(eqvl_value);
								} else {
									in_tot_qty = ing_unit_qty * Float.parseFloat(eqvl_value);
								}

								if (freq_nature.equals("I")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(durn_value)) * (24 / (Float.parseFloat(interval_value)));
								} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									in_tot_qty = in_tot_qty * (Float.parseFloat(amend_repeat_value)) * (Float.parseFloat(amend_durn_value));
								} else if (freq_nature.equals("O")) {
									in_tot_qty = in_tot_qty;
								}

								if (!fract_dose.equals("Y")) {
									in_tot_qty = new Double(Math.ceil((in_tot_qty) / Float.parseFloat(pack_size))).floatValue();
								}
								ordered_qty = in_tot_qty + "";
							}
						}
						drugDetail.put("ORDERED_QTY", ordered_qty);
						
						bean_CRX.setBillingDetail(drugDetail, episode_type, patient_id, encounter_id, item_code, ordered_qty, take_home_medication);
						String billable_item_yn = (String) drugDetail.get("BILLABLE_ITEM_YN") == null ? "" : (String) drugDetail.get("BILLABLE_ITEM_YN");
						String in_formulary_yn = (String) drugDetail.get("IN_FORMULARY_YN") == null ? "" : (String) drugDetail.get("IN_FORMULARY_YN");

						if (bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y") && billable_item_yn.equals("Y")) {
							bl_charge_amt = (String) drugDetail.get("BL_CHARGE_AMT") == null ? "0.0" : (String) drugDetail.get("BL_CHARGE_AMT");
							bl_patient_payable = (String) drugDetail.get("BL_PATIENT_PAYABLE") == null ? "0.0" : (String) drugDetail.get("BL_PATIENT_PAYABLE");
							//patient_payable = (String) drugDetail.get("BL_PATIENT_PAYABLE_AMT")==null?"0":(String)drugDetail.get("BL_PATIENT_PAYABLE_AMT");
							//total_charge =(String)drugDetail.get("BL_TOTAL_CHARGE_AMT")==null?"0":(String)drugDetail.get("BL_TOTAL_CHARGE_AMT");
							
							if (!bl_patient_payable.equals(""))
								patient_payable += Float.parseFloat(bl_patient_payable);
							if (!bl_charge_amt.equals(""))
								total_charge += Float.parseFloat(bl_charge_amt);
						} else {
							bl_charge_amt = "0";
							bl_patient_payable = "0";
						}

						all_total_charge_fl += Float.parseFloat(bl_charge_amt);
						all_patient_payable_fl += Float.parseFloat(bl_patient_payable);

						if (orderqty == null)
							orderqty = "";
						orderqty = orderqty.equals("") ? "0" : orderqty;
						iOrdQty = Math.ceil(Float.parseFloat(orderqty));

						if (drugMandatoryWarning.equals("N") && (orderqty.equals("") || dosageval.equals("") || durn_value.equals("") || freq_code.equals(""))) {
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}
						if (drugMandatoryWarning.equals("N") && (pres_by.equals("R") || pres_by.equals("P")) && totalqty.equals("")) {
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}
						if (drugMandatoryWarning.equals("N") && pres_by.equals("P") && totalqty.equals("")) {
							drugMandatoryWarning = "Y";
							cartErrorExists = true;
						}

						String id_drug = drugCode.replaceAll("[-+.^:,]", "");
						String trad = "T";
						if (!tradeName.equalsIgnoreCase(""))
							trad = tradeName;
						String id_trad = trad.replaceAll("[-+.^:,]", "");
						id_drugName_tradeName = id_drug + "_" + id_trad;
					%>
				    <li id="ivrxDrugListOnAddingWithAdd" style="list-style: none;padding-bottom:10px;">
                      <div id="drugnameIvrxWithAdd" class="drugDescription table">
                        <div class="row">
						<div class="cell drugDescriptionInnerCss">
                          <%=drugDesc%>
                        </div>	

			<div class="cell deleteDrugCss deleteCRX deleteAllCRX" style="vertical-align:top;" data-DrugType='CRX' data-DrugCode='<%=id_drugName_tradeName%>' onclick="removeCRXDrug('<%=drugCode%>',event,'<%=id_drugName_tradeName%>')">
                           <img src="${path}/eIPAD/images/Cart_delete_drug12x12.png">
                        </div>
                        </div>
                      </div>
				    </li>
				    <%					
                    }
					if(start_date_fluid.equals(""))
						 start_date_fluid=bean_CRX.getSysdate();
					//System.out.println("freqDuration: "+freqDuration); 
					if(end_date_fluid.equals(""))	
						end_date_fluid	=  bean_CRX.populateEndDate(start_date_fluid,freqDuration,durnType);
					
                    				
						
					DateFormat fMonth = new SimpleDateFormat("MMM");
					DateFormat fDate = new SimpleDateFormat("dd");
					DateFormat fYear = new SimpleDateFormat("yyyy");
					Date startDate_dt = df.parse(start_date_fluid);
					Date endDate_dt = df.parse(end_date_fluid);
					String formattedStartDate = fDate.format(startDate_dt);		
					String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
					String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
					String formattedStartYear = fYear.format(startDate_dt);
					String formattedEndDate = fDate.format(endDate_dt);		
					String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
					String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
					String formattedEndYear = fYear.format(endDate_dt);						
					String 	dosandfreq= dosageval+dosageuom;
					
					if(freqValues!=null && freqValues.size()>0){
					for (int i=0;i<freqValues.size();i+=2){                   						
						if(freq_code.equals((String)freqValues.get(i)))
						{
							freq_desc=(String)freqValues.get(i+1);
							break;
						}				
					}					
					}		
					if(dosandfreq.equals(""))
						dosandfreq=freq_desc;
					else
						dosandfreq=dosandfreq + " - " + freq_desc;	
					
				    %>
                 </ul>                       
			  </div>
			  <div id="borderDivWrapper" class="borderDivWrapperCss">
			    <div class="borderDivStyle durationDetailsWrapper">
				<%=dosandfreq%>
			    </div>
			  </div>
			  <div id="div2IvrxWithAdd" class="drugDateDataWrapper">  
			    <div style="width:100%;">
				 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth %>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear %>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>
                 <div class="table toStylingWrapper">
                    <div class="row">
					  <div class="cell toStyleCss">to</div>
					</div>
                 </div>
                 <div class="table drugDateContainer"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
				</div>
				 <div class="table priceDetailsWrapper">
				    <div class="row">					
				    	<%if(patient_payable!=0 || total_charge!=0) {
						String patient_payable_str = dfTest.format(patient_payable);
						String total_charge_str = dfTest.format(total_charge);%>
					   <div class="cell vAlignMiddle defaultFontColorOnCart"><%=total_charge_str%></div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">/</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart"><%=patient_payable_str %></div>
						<%}else{ %>
						<div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">/</div>
					   <div class="cell vAlignMiddle defaultFontColorOnCart">--</div>
						<%} %>					   
					</div>
				 </div>				 
				 <div style="clear: both;"></div>
				</div>
			  </div>
            </div>
	    </div>   
	      
        <div id="warningWrapperCrx" style="right: 6px;position: absolute;height: 15px;">			         
			<%if(drugMandatoryWarning.equalsIgnoreCase("Y")){%>
				<img src="${path}/eIPAD/images/Drug_Warning12x12.png">				   
			<%}%>  
		</div>  	         
		
	   <div style="clear: both;"></div>
	   </div>    
      </li>
   </ul>
   </div>
   <%
    }
   %>
</div>
  <input type="hidden" id="PHCartErrorExists" value="<%=cartErrorExists %>" name="PHCartErrorExists">
<%
  }else{
%>
 <div style="width: 100%;height: 100%;display: flex;align-items: center;justify-content: center">
	  <div style="margin: 0;font-family:Segoe UI Semibold;font-size:12px;color:#6d798f;"> 	    
			Pharmacy cart is empty
      </div>
  </div>
<%
 }
%>   
<input type="hidden" id="rx_patient_payable" name="rx_patient_payable" id="rx_patient_payable" value="<%=rx_patient_payable_fl %>"/>
<input type="hidden" id="rx_total_charge" name="rx_total_charge" id="rx_total_charge" value="<%=rx_total_charge_fl %>"/>
<input type="hidden" id="all_patient_payable" name="all_patient_payable" id="all_patient_payable" value="<%=all_patient_payable_fl %>"/>
<input type="hidden" id="all_total_charge" name="all_total_charge" id="all_total_charge" value="<%=all_total_charge_fl %>"/>
</div>  
<%
}
catch(Exception ex){
	System.out.println(ex.getMessage());
	ex.printStackTrace();
}
}
%>
</div>
<div class="orderDetailsFooterCss">
    <div class="billingDetails table">
	    <div class="row">
			<div class="cell billingDetailsCell">
			    <div class="billingDetailsText segoeuiBold">Total Charge</div>
			</div>
			<div class="cell billingDetailsCell">
			    <div class="table fullHtFullWt">
					<div class="row fullWtHalfHt">
					    <div class="cell billingAmount"><span class="segoeuiBold" id="all_total_charge_span">--</span>/<span id="all_patient_payable_span" class="segoeuiBold">--</span></div>
			        </div>
					<div class="row fullWtHalfHt">
					    <div class="cell billingAmountInfo segoeuiBold">Total/Patient</div>
					</div>
			    </div>
			</div>
		</div>
    </div>
    <div class="billingBottomBorder">
	</div>
</div>
<script>
    var collapseRxWidget = "opened";
    var collapseIvrxWidget = "opened";
	var collapseCrxWidget = "opened";
    var path;
    var cartDrugListScroller;
    function cartDrugListScroll() {
        cartDrugListScroller = new IScroll('#addedDrugListWrapper', {
            scrollX: false,
            scrollY: true,
            interactiveScrollbars: true,
            click: true,
            useTransition: false,
            hideScrollbar: true,
            scrollbars: true,
            bindToWrapper: true,
            fadeScrollbars: true
        });
    }
    $(document).ready(function() {
        path = $("#hdnPath").val();
        cartDrugListScroll();
        var rx_patient_payable = parseFloat($("#rx_patient_payable").val());
        var rx_total_charge = parseFloat($("#rx_total_charge").val());
        var all_patient_payable = parseFloat($("#all_patient_payable").val());
        var all_total_charge = parseFloat($("#all_total_charge").val());
        if (rx_total_charge > 0 || rx_patient_payable > 0) {
            $("#rx_total_charge_span").html(rx_total_charge.toFixed(2));
            $("#rx_patient_payable_span").html(rx_patient_payable.toFixed(2));
        }
        if (all_total_charge > 0 || all_patient_payable > 0) {
            $("#all_total_charge_span").html(all_total_charge.toFixed(2));
            $("#all_patient_payable_span").html(all_patient_payable.toFixed(2));
        }
    });
	
	function cartClose(){
		$("#cartOpened").val("N");
        $("#cartView").hide();
        $("#cartWrapper").show();
        $("#cart").show();
	}
	
	

    function openPharmacyRxDetails(drugItemNo) {
        $("#PageLoadingAnimation").show();
        $("#RxOrderPlaceDiv").hide();
        $("#RxOrderFieldsDiv").show();
        $("#RxOrderFieldsDiv").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
        $("#RxOrderFieldsDiv").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmRxDetailsView.jsp?drugItemNo=' + drugItemNo, function() {
            $("#PageLoadingAnimation").hide();
            $("#rxDetailsLegend").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=rxDetailsLegend', function(res) {});
        });
    }

    function openPharmacyIvrxDetails(evt, drugItemType) {
        $("#PageLoadingAnimation").show();
        $("#RxOrderPlaceDiv").hide();
        $("#RxOrderFieldsDiv").show();
        switch (drugItemType) {
            case "IVD":
                $("#RxOrderFieldsDiv").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/pharmIvRXWithAddView.jsp', function() {
                    $("#PageLoadingAnimation").hide();
                    $("#ivRxWithAddLegend").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=ivRxWithAddLegend',
                        function(res) {});
                });
                break;
            case "IVPB":
                $("#RxOrderFieldsDiv").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/pharmIvRXWithInterView.jsp', function() {
                    $("#PageLoadingAnimation").hide();
                    $("#ivRxInterLegend").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=ivRxInterLegend',
                        function(res) {});
                });
                break;
        }
    }

    function openPharmacyIvRxWaDetails(drugItemNo) {
        $("#PageLoadingAnimation").show();
        $("#RxOrderPlaceDiv").hide();
        $("#RxOrderFieldsDiv").show();
        $("#RxOrderFieldsDiv").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
		
		var takeHomeMedication = $("#take_home_medication").val();
        var priority = $("#priority").val();
        var location_code = $("#location_code").val();
        var location_type = $("#location_type").val();
            
        
		
        $("#RxOrderFieldsDiv").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/pharmIvRXWithoutAdtView.jsp?drugItemNo=' + drugItemNo + '&location_type=' + location_type + '&location_code=' + location_code + '&take_home_medication=' + takeHomeMedication + '&priority=' + priority, function() {
            $("#PageLoadingAnimation").hide();
            $("#ivRxWithoutAddLegend").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=ivRxWithoutAddLegend',
                function(res) {});
        });
    }
	
		
	function openPharmacyCrxDetails(ordertype, lenstr) {
		var lenInt = parseInt(lenstr);
		if(lenInt<2){
			showToastMsg1("Add one or more order drug to the pharmacy cart to access details view");
		}
		else{
			$("#PageLoadingAnimation").show();
            $("#RxOrderPlaceDiv").hide();
            $("#RxOrderFieldsDiv").show();
            $("#RxOrderFieldsDiv").append("<div id='PageLoadingAnimation' class='absoluteCenter'></div>");
			
            var takeHomeMedication = $("#take_home_medication").val();
            var priority = $("#priority").val();
            var location_code = $("#location_code").val();
            var location_type = $("#location_type").val();
            
           // console.log("location_type: "+location_type+" location_code: "+location_code+" takeHomeMedication: "+takeHomeMedication+" priority: "+priority);
            
            $("#RxOrderFieldsDiv").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/pharmCrxDetailsView.jsp?location_type=' + location_type + '&location_code=' + location_code + '&take_home_medication=' + takeHomeMedication + '&priority=' + priority, function(){
		    $("#CRxAddLegend").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/PharmLegend.jsp?id_data=CRxAddLegend',
                function(res) {});
		 });
		}
        
    }
	
    $("#collapseWidgetRx").click(function() {
        if (collapseRxWidget == "opened") {
            $("#drugList").hide();
            collapseRxWidget = "closed";
            $("#collapseDrugTypeRx").removeClass("collapseCloseWidget");
			var hdnIvRxRecSize = $("#hdnIvRxRecSize").val();
			if(hdnIvRxRecSize == "y"){
            $("#drugListScrollerRx").css("border-bottom", "5px solid #ffffff");
			}
        } else if (collapseRxWidget == "closed") {
            $("#drugList").show();
            collapseRxWidget = "opened";
            $("#collapseDrugTypeRx").addClass("collapseCloseWidget");
            $("#drugListScrollerRx").css("border-bottom", "");
        }
        if (cartDrugListScroller) {
            cartDrugListScroller.refresh();
        }
    });

    $("#collapseWidgetIvrx").click(function() {
        if (collapseIvrxWidget == "opened") {
            $("#drugListIvrx").hide();
            collapseIvrxWidget = "closed";
            $("#collapseDrugTypeIvrx").removeClass("collapseCloseWidget");
        } else if (collapseIvrxWidget == "closed") {
            $("#drugListIvrx").show();
            collapseIvrxWidget = "opened";
            $("#collapseDrugTypeIvrx").addClass("collapseCloseWidget");
        }
        if (cartDrugListScroller) {
            cartDrugListScroller.refresh();
        }
    });
	
	
    $("#collapseWidgetCRX").click(function() {
        if (collapseCrxWidget == "opened") {
            $("#drugListCrx").hide();
            collapseCrxWidget = "closed";
            $("#collapseDrugTypeCRX").removeClass("collapseCloseWidget");
        } else if (collapseCrxWidget == "closed") {
            $("#drugListCrx").show();
            collapseCrxWidget = "opened";
            $("#collapseDrugTypeCRX").addClass("collapseCloseWidget");
        }
        if (cartDrugListScroller) {
            cartDrugListScroller.refresh();
        }
    });
	
    function removeRXItem(drugcode, divID) {
        SetRemoveValues(drugcode, divID, "REMOVE_ITEM_RX");
        $("#deleteConfirmMsg").show();
    }

    function EnableDuplicateDrug(SelDivId) {
        var selDivIds = SelDivId.split("_");
        $("div[data-currentid]").each(function(index, value) {
            var drugCodeUnique = $(this).attr('data-drugcodeunique');
            var divId = $(this).attr('data-currentid');

            if (selDivIds[0] == drugCodeUnique) {
                EnableBubbleItem(divId);
            }
            $(this).attr("data-role", "draggable");
        });
    }

    function okDeleteCartItemDialog() 
	{
        var removeType = $("#removeType").val();
        if (removeType == "REMOVE_ITEM_RX") {
            var selDivID = $("#drugDivID").val();
            var selDrugCode = $("#drugDelCode").val();
	    EnableOrderBasedOnDrugInfo(selDrugCode, selDivID);
            EnableBubbleItem(selDivID);            
	    RemoveItemFromList(selDivID);			
            EnableDuplicateDrug(selDivID);
            $("#" + selDivID).removeClass("cstFieldDullRx");
            makeServerCall(selDrugCode, removeType, "");
        } 
		else if (removeType == "REMOVE_DRUG_IVD") {
            var selDivID = $("#drugDivID").val();
            var selDrugCode = $("#drugDelCode").val();
		//	EnableOrderBasedOnDrugInfo(selDrugCode, selDivID);
            EnableBubbleItem(selDivID);
            $("#" + selDivID).removeClass("cstFieldDullRx");
	    		RemoveItemFromList(selDivID);
			makeServerCall(selDrugCode, removeType, "");
		}
		else if (removeType == "REMOVE_DRUG_CRX")
		{
			var selDivID = $("#drugDivID").val();
            var selDrugCode = $("#drugDelCode").val();			
			EnableBubbleItem(selDivID);
            $("#" + selDivID).removeClass("cstFieldDullRx");
	    	RemoveItemFromList(selDivID);
			makeServerCall(selDrugCode, removeType, "");
		}
		else if (removeType == "REMOVE_FLUID_IVWA") 
		{
            var totalString = $("#drugDivID").val().split("$$");
            if (totalString.length > 1) {
                var selDivID = totalString[0];
                var serNo = totalString[1];
                var selDrugCode = $("#drugDelCode").val();
		EnableOrderBasedOnDrugInfo(selDrugCode, selDivID);
                EnableBubbleItem(selDivID);				
		RemoveItemFromList(selDivID);				
                $("#" + selDivID).removeClass("cstFieldDullRx");
                makeServerCall(selDrugCode, removeType, serNo);
            }
        }
	else if (removeType == "REMOVE_ALL_IVPB") 
	{
		var selDivID = $("#drugDivID").val();
		EnableOrderBasedOnDrugInfo("", selDivID);
		EnableBubbleItem(selDivID);
		RemoveItemFromList(selDivID);
                $("#" + selDivID).removeClass("cstFieldDullRx");
                makeServerCall("", removeType, "");
        }
		else if (removeType == "REMOVE_ALL_RX") 
		{
            RemoveAllDrugs("deleteRX");
            makeServerCall("", removeType, "");
        } else if (removeType == "REMOVE_ALL_IV") {
            RemoveAllDrugs("deleteIV");
            makeServerCall("", removeType, "");
        }
	else if  (removeType == "REMOVE_ALL_IVD")
	{
		RemoveAllDrugs("deleteAllIVD");		
		makeServerCall("", removeType, "");
	}
	else if(removeType == "REMOVE_ALL_CRX")
	{
		RemoveAllDrugs("deleteAllCRX");
		makeServerCall("", removeType, "");
	}
        $("#deleteConfirmMsg").hide();		
		if(allAddedDrug.length == 0){
			cartClose();
	    }
    }

    function SetRemoveValues(drugcode, divID, removeType) {
        $("#drugDelCode").val(drugcode);
        $("#drugDivID").val(divID);
        $("#removeType").val(removeType);
    }

    function RemoveAllDrugs(className) 
	{
	
        $("." + className).each(function(index, value) {

            EnableBubbleItem($(this).attr('data-drugcode'));
            RemoveItemFromList($(this).attr('data-drugcode'));
	    EnableOrderBasedOnDrugInfo($(this).attr('data-drugcode'), $(this).attr('data-drugcode'));

        });
    }

    function RemoveItemFromList(drug) 
	{		

        for (var g = 0; g < allAddedDrug.length; g++) {
            var drugDetails = allAddedDrug[g];
            var drugCode = drugDetails.drugCode;	
	      var tempDruTrade=drug.split('_');
		
			
            if (drugCode == drug ) {				
                allAddedDrug.splice(g, 1);
				break;	
            }
        }
		if(allAddedDrug.length == 0){			
			 $("#completePlaceOrdersConfirm").addClass('completePlaceOrdersDisable');
		}
    }

    function removeAllRX() {
        SetRemoveValues("", "", "REMOVE_ALL_RX");
        $("#deleteConfirmMsg").show();

    }

    function EnableBubbleItem(divId) {
        $("#" + divId).removeClass("cstFieldDullRx");
        $("#" + divId).kendoDraggable({
            holdToDrag: true,
            hold: function(e) {},
            hint: function(element) {
                return element.clone();
            },
            dragstart: draggableOnDragStart,
            dragend: draggableOnDragEnd
        });
        try {

            $("#" + divId).data("kendoDraggable").userEvents.minHold = 70;
        } catch (ex) {}
    }

	
	function currentOrderId(drugDetails,drugCode,divId){
		
		var orderDetails=drugDetails;
		
		var drugInfo =orderDetails.drugInfo;
		
		for(var t=0;t< drugInfo.length;t++){
		
		var  currentElemDrug=drugInfo[t];
		//console.log("currentElemDrug:: **********"+JSON.stringify(currentElemDrug));
		 
		//console.log("currentElemDrug currentElemDrug******"+currentElemDrug.drugUnique+"divId:::"+divId+"drugCode:::"+drugCode);
		
		var TradeNames =currentElemDrug.TradeNames;
		var durgCodeTrade;
		if(TradeNames==""){
			
			durgCodeTrade=currentElemDrug.drugUnique+"_T";
		}else{
			
			durgCodeTrade=currentElemDrug.drugUnique+"_"+TradeNames;
		}
		 
		
		 
		if(divId==durgCodeTrade){
			
			return  orderDetails.orderId;
		}
		var tempDruTrade=durgCodeTrade.split('_');
		if( divId.indexOf(tempDruTrade[0]) >= 0){
			
                  return  orderDetails.orderId;
 
           }
		
		
	}
	
	
	}
	
	function enableDrug(drugDetails){
		var orderDetails= drugDetails;
		var drugInfo =orderDetails.drugInfo;
		
		for(var t=0;t< drugInfo.length;t++){
			
		var  currentElemDrug=drugInfo[t];
		
		var durgCodeTrade=currentElemDrug.drugUnique+"_T";
		EnableBubbleItem(durgCodeTrade);
		}
		
	}
	
	function clearDeleteArray(orderId){
		
		for (var g = 0; g < allAddedDrug.length; g++) {
        var drugDetails = allAddedDrug[g];
	
		var order = drugDetails instanceof currentDrug; 
		
	//	console.log("last_element::"+order);
		
		if(!order){
			
	      var order= drugDetails.orderId;
		  
		 // console.log("order:::"+order+"order order orderId"+orderId);
		  
		  var drugInfo =drugDetails.drugInfo;
		  var drugInfoRx=drugInfo[0];
		  var drug_type=drugInfoRx.drug_type;
		  
		  var orderFrom =drugInfoRx.orderFrom;
		  
		  if(drug_type=="Rx" && orderFrom=="po" || drug_type=="IVWA" && orderFrom=="po" ){
			  
		   var rxPos =drugInfoRx.rxPos;
			   
			  if(orderId==order){
			  enableDrug(drugDetails);
			  var orderIdRx=orderId+"_"+rxPos;
			  EnableBubbleItem(orderIdRx);
			  allAddedDrug.splice(g, 1);
			  
		  } 
			  
		  }else{
			  
			  if(orderId==order){
			  enableDrug(drugDetails);
			  allAddedDrug.splice(g, 1);
			  
		  } 
			  
		  }
		  
		 
		}
		
		}
		
	}
	
	
    function EnableOrderBasedOnDrugInfo(drugCode,divId){
    
    //	console.log("all deatils::"+allAddedDrug.length);
		  var drugArray = [];
	 for (var g = 0; g < allAddedDrug.length; g++) {
        var drugDetails = allAddedDrug[g];
		
		//console.log("drugDetails:::drugDetails drugDetails drugDetails drugDetails::"+JSON.stringify(drugDetails));
		var order = drugDetails instanceof currentDrug; 
		
		//console.log("last_element::"+order);
		
		if(!order){
		
	var orderId = currentOrderId(drugDetails,drugCode,divId);
	
//	console.log("order isd::"+orderId);
	
	    clearDeleteArray(orderId);
		EnableBubbleItem(orderId);
		
		}
		
		
    }
    
	
    	
    }
    
    
    function removeIVWithAdd(drugcode, event, divID) {
        event.stopPropagation();
        SetRemoveValues(drugcode, divID, "REMOVE_DRUG_IVD");
        $("#deleteConfirmMsg").show();
    }
    
    function removeCRXDrug(drugcode, event, divID) {		
		event.stopPropagation();
		SetRemoveValues(drugcode, divID, "REMOVE_DRUG_CRX");
		$("#deleteConfirmMsg").show();
    }
    
    
    function removeAllCRX(){
		SetRemoveValues("", "", "REMOVE_ALL_CRX");
		$("#deleteConfirmMsg").show();
    }

    function removeAllIVD(drugcode, divID) {
        SetRemoveValues(drugcode, divID, "REMOVE_ALL_IVD");
        $("#deleteConfirmMsg").show();
		//EnableOrderBasedOnDrugInfo(drugcode, divID);
		//alert("called here");
    }

    function removeIVWithoutAdd(drugcode, srl, divID) {
        SetRemoveValues(drugcode, divID + "$$" + srl, "REMOVE_FLUID_IVWA");
        $("#deleteConfirmMsg").show();
       // EnableOrderBasedOnDrugInfo(drugcode, divID);
    }

	function removeAllIVWA(){
		makeServerCall("", "REMOVE_ALL_IVWA", "");
	}

    function RemoveIVIntermittent(divID) {
        SetRemoveValues("", divID, "REMOVE_ALL_IVPB");
        $("#deleteConfirmMsg").show();
		//EnableOrderBasedOnDrugInfo("", divID);
    }

    function removeAllIVRX() {
	SetRemoveValues("", "", "REMOVE_ALL_IV");
	$("#deleteConfirmMsg").show();
    }

    function makeServerCall(drugcode, mode, srlNo){
	if (drugcode == "")
		drugcode = "N";
	if (srlNo == "")
		srlNo = "N";
	var validationPath = path + '/mobile/charts/pharmacy/PharmValidationJSONServlet?mode=' + mode;
	$.getJSON(validationPath, {
		DrugCode: drugcode,
		SrlNo: srlNo
	})
	.done(function(json){
		var result = json.validationResult;
		refreshCart();
		$("#cartCount").text(getCountOfCart());
		$("#countDisplay").text(getCountOfCart());
	})
	.fail(function(jqxhr, textStatus, error){
		var err = textStatus + ", " + error;
	});
	}

    function refreshCart(){
    	$("#orderDetailsView").load(path + '/eIPAD/jsp/chartwidgets/pharmacy/DrugList.jsp');
    }
</script>

