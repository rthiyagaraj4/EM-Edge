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
<%@page import="eOR.OrderEntryBean"%>
<%@page import="ePH.DrugInterfaceControlBean"%>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<script src="${path}/eIPAD/js/pharmCrxDetailsView.js"></script> 
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Locale appLocale;
	if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
	else 
	appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
	
	String PRES_BY_BASE="";
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");	
	String facility_id = patientContext.getFacilityId();
	String patient_id = patientContext.getPatientId();
	String patient_class = patientContext.getPatientClass();
	String act_patient_class =  request.getParameter("act_patient_class");
	String encounter_id = patientContext.getEncounterId();
	String resp_id = patientContext.getResponsibilityID();
	String pract_id = patientContext.getClinicianId();
	String location_code = patientContext.getLocationCode();
	String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name					= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean		= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
	
	String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patient_id + encounter_id;
	String bean_name_CRX	= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);
	
	String ex_bean_id   = "@ExternalProductLinkBean";
	String ex_bean_name = "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
	HashMap drug_data=new HashMap();
	
	
	/* Calculate Dispense Location */
	String bean_id_eph			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name_eph		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id_eph,bean_name_eph,request);
	bean.setLanguageId(locale);

	String location_type_eph		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code_eph		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication     = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority				    = request.getParameter("priority")==null?"":request.getParameter("priority");
	String dflt_disp_locn	        = "";
	String iv_prep_yn		        = "6";	
	
	//bean.setTakeHomeMedication(take_home_medication);
	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type_eph,location_code_eph,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
	
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
			dflt_disp_locn	= (String)ord_disp_location.get(2)==null?"":(String)ord_disp_location.get(2);			
		}
	
	/* Dispende Location Ends */
	
	String drug_db_interface_yn				=	param_bean.getDrugDBInterface_yn(facility_id);  
	String drug_db_dose_check_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn			=   param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn		=   param_bean.getDrugDBInteract_check_yn(facility_id);
	String drug_db_contraind_check_yn		=   param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn			=   param_bean.getDrugDBAllergy_check_yn(facility_id);
	String drug_db_product_id		  		=	param_bean.getDrugDBProductID(facility_id);
	
	bean_CRX.setLanguageId("en");
	bean_CRX.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_CRX.setDrug_DB_Product_id(drug_db_product_id);
	bean_CRX.setExternalDosageYN(drug_db_dose_check_yn);
	/* drug details tab - field validations */
	
	HashMap drug_detail =	null;	
	
	ArrayList	presDetails	= (ArrayList) bean_CRX.getDrugDetails();	
	HashMap drugDetails			= (HashMap)presDetails.get(0);
	
	ArrayList AllUOMs = bean_CRX.getAllUOMs();	/* required quantity dropdown */
	
	String durn_values            = "";
	String durn_type            = "";
	String start            = "";
	String end            = "";	
	String  dosage_value = "";
	String  dosage_UOM = "";
	String freq_codes = "";	
	
	String drugDescription="";
	String strengthValue="";
	String strengthDesc="";
	String formDesc="";
	String drugCode="";
	String strengthOrder_qty="",strengthQty_UOM="",ratioQty_UOM="";
	String allergyOverride="",drugOverride="",dosagelimitOverride="",drugIndication="";
	String freq_code="",freq_nature="";
	String drug_code_crx="";
	String durn_value="";
	String buildMAR_yn="",buildMAR_ynCheck="",buildMAR_ynEnable="",buildMAR_rule="";
	String repeat_durn_type="",interval_value="",calcualted_durn_value="",scheduled_yn="";
	String total_ratio,total_ratio_qty="",total_percent_qty="";
	String allDrugs="";
    	String DosageInfo="",final_prod_qty_uom="",pres_base_uom_value="";
	String DosageValue="",DosageText="";
	int allDrugs_count = 0;
	
	String start_date_fluid = bean_CRX.getSysdate();
	String end_date_fluid	=  bean_CRX.populateEndDate(start_date_fluid,"24","H");
	
	
	for(int uomsize=0;uomsize<AllUOMs.size();uomsize+=2){
		//System.out.println("allUOMS"+AllUOMs.get(uomsize+1));
		//String requiredQTY = (String)AllUOMs.get(uomsize+1);
		final_prod_qty_uom=final_prod_qty_uom + "<option  value='"+AllUOMs.get(uomsize)+"'>"+AllUOMs.get(uomsize+1)+"</option>";
    }
	
	
	/* populateDate */
	String  START_DATES = (String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE");	
	String  END_DATES  =	(String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");
	
	
	/* populateFrequency */
	drug_code_crx = (String)drugDetails.get("FREQ_CODE")==null?"":(String)drugDetails.get("FREQ_CODE");

		ArrayList freqValues	=  (ArrayList) bean_CRX.loadFrequency();  	        
			if(freqValues!=null && freqValues.size()>0){
					%>
					<script>clearFrequencyList();</script>
					<%
					for (int i=0;i<freqValues.size();i+=2){
					%>					
                    <script>
					addFrequencyListCrx('<%=(String)freqValues.get(i)%>','<%=(String)freqValues.get(i+1)%>');
					</script>					
					<%
					}
					%>
					<script>defaultFreq('<%=drug_code_crx%>');</script>
                    <%			
			}
			
	/* setting duration value */
	
	/* setting total footer values */
	total_ratio =  (String)drugDetails.get("TOTAL_RATIO")==null?"":(String)drugDetails.get("TOTAL_RATIO");
	total_ratio_qty =  (String)drugDetails.get("TOTAL_RATIO_QTY")==null?"":(String)drugDetails.get("TOTAL_RATIO_QTY");
	total_percent_qty =  (String)drugDetails.get("TOTAL_PERCENT_QTY")==null?"":(String)drugDetails.get("TOTAL_PERCENT_QTY");
    	
%>
<div data-role = "none"  class = "blurPopup" onclick="" data-popid="" style="z-index:10000"></div>
<form id="formCRXPrescriptionDetails" name="formCRXPrescriptionDetails" id="formCRXPrescriptionDetails" method = "post" action = "" class="ChartSummaryFormElem">		
	<div class="ChartSummaryBlockVar" id="rxDetailsSummaryBlock" data-role = "none">
		<div class="ChartSummaryMainTable" data-role = "none">
				<div data-role = "none" class ="ChartSummaryPageHeader">
               		<div class="ChartSummaryHeaderCell" data-role = "none">
                  		<div class="ChartSummaryHeaderCont" data-role = "none">
                     		<div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
                        		<div class="ChartSummaryHeaderRow" data-role = "none">
                           			<div class="ChartSummaryHeaderTextCol" data-role = "none">
                              			<div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">CRx</div>
                           			</div>
                           			<div class="ChartSummaryHeaderEncRightCol" data-role="none">
                              			<div class="WidgetButtonTheme" data-role = "none" onclick="completeCRxDetailsConfirm()"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
                           			</div>
		                           <div class="ChartSummaryHeaderEncRightCol" data-role="none">
		                              <div class="WidgetButtonTheme" data-role = "none" onclick="closeCrxDetailsView()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
		                           </div>
                       	 		</div>
                     		</div>
                  		</div>
               		</div>
            	</div>
				<div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" >
					<div data-role = "none" class = "ChartSummaryPageContentCell">
						<div data-role = "none" class = "ChartSummaryMainWrapper pharmDataMainWrapper" >
							<div class="ChartSummaryMainScroller pharmDataContentScroller"  data-role = "none">					 					 
								<div class="table" style="width:100%;height:100%;" data-role = "none">	
									<div  class="row crxDetailsViewHeaderRowWrapper" data-role = "none">
			                            <div class="table ivHeaderWrapper" style="width:100%;height:25%;">
									        <div class="row fullHtFullWt">
										        <div class="cell ivHeaderWrapperContent">
												    <div  class="drugDetailsTab segoeuiBold" id="CRxDrugTab"  onclick="openDrugDetailsTab()">Drug Details</div> <!--to handle in jquery-->
												    <div class="adminDetailsTab segoeuiBold" id="CRxAdminTab" onclick="openAdminDetailsTab()">Administration Details</div>
											    </div>
			                                </div>                                      
			                            </div>
	                           		</div>
									
	<!-- Drug details  tab -->								
	<div id="CRxDrug" class="row" style="width:100%;height: 85%;background-color:#f5f9fc;" >
        <div class="table" style="width:100%;height:100%;">    
		    <div class="row" style="height:10%;width: 100%;">
		        <div class="row IVrxLabel segoeuiBold paddingBottom5px" style="padding-left:5px;display:block;">
		            Prescribing  by
				</div>	 
				<div class="row ivrxSubTabs" style="background-color: #f5f9fc;">
					<div class="table" style="width:100%;height:100%;">
                        <div class="ivrxTabsContainer" style="margin-top:0;">								
                            <div class="radioTabs" id="CRxStrength">
								<div class="table radioTabsTable">
								    <div class="row">
									    <div class="cell radioTabsCell">
										    <div id="CRxStrengthOption" class="ivrxTabs ivrxTabsOnActive"></div>
										</div>
									</div>
                                    <div class="row">
									    <div  id="CRxStrengthLabel" class="cell ivrxDescription ivrxTabsDescOnActive">
										     Strength
										</div>
									</div>									  
								</div>
							</div>								
							<div class="radioTabs" id="CRxRatio">
								<div class="table radioTabsTable">
								    <div class="row">
									    <div class="cell radioTabsCell">
										    <div id="CRxRatioOption" class="ivrxTabs"></div>
										</div>
									</div>
                                    <div class="row">
									    <div  id="CRxRatioLabel" class="cell ivrxDescription">
										  Ratio
										</div>
									</div>									  
								</div>
							</div>																
                            <div class="radioTabs" id="CRxPercentage">
								<div class="table radioTabsTable">
								    <div class="row">
									    <div class="cell radioTabsCell">
										    <div id="CRxPercentOption" class="ivrxTabs"></div>
										</div>
									</div>
                                    <div class="row">
									    <div id="CRxPercentLabel" class="cell ivrxDescription">
										  Percentage %
										</div>
									</div>									  
								</div>
							</div>								
						</div>
					</div>
                </div>
			</div>					
                <!-- Strength -->	                      									 
				<div id="CRx_strength" class="row ivrxDetailsViewContentRowWrapper"  data-role = "none">
					<div class="detailsViewMainWrapper">	
                        <%
                        
				        if(presDetails.size()>0){
						    for(int i=0;i<presDetails.size();i++){	
				                drug_detail = (HashMap) presDetails.get(i);
				                drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
				                if(PRES_BY_BASE.equals("")){
								   PRES_BY_BASE=(String)drug_detail.get("PRES_BY_BASE")==null?"":(String)drug_detail.get("PRES_BY_BASE");	
								}
				              	//for value retaining ABC
				                durn_values            = (String)drug_detail.get("DURN_VALUE")==null?"":(String)drug_detail.get("DURN_VALUE");
				              	if(durn_values.equals("")||durn_values.equals("0")){
				              		durn_values = "1";
				              	}
				        		durn_type            = (String)drug_detail.get("DURN_TYPE")==null?"":(String)drug_detail.get("DURN_TYPE");	
				        		start            = (String)drug_detail.get("START_DATE")==null?"":(String)drug_detail.get("START_DATE");	
				        		end            = (String)drug_detail.get("END_DATE")==null?"":(String)drug_detail.get("END_DATE");	
				        		dosage_value =(String)drug_detail.get("DOSAGE_VALUE")==null?"":(String)drug_detail.get("DOSAGE_VALUE");	
				        		dosage_UOM =(String)drug_detail.get("DOSAGE_UOM")==null?"":(String)drug_detail.get("DOSAGE_UOM");	
				        		freq_codes =  (String)drug_detail.get("FREQ_CODE")==null?"":(String)drug_detail.get("FREQ_CODE");	
				                
				                //banner indicators begins
				                String strength				= (String)drug_detail.get("STRENGTH_VALUE");
				            	String strength_uom			= (String)drug_detail.get("STRENGTH_UOM");
				            	String strength_uom_need	= CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,strength_uom));//Modified for CRF--0749 INC-13640
				            	String dosage				= (String)drug_detail.get("QTY_VALUE");
				            	String dosage_uom			= (String)drug_detail.get("QTY_UOM");
				            	String form_desc			= (String)drug_detail.get("FORM_DESC");
				            	String allergy_override		= (String)drug_detail.get("ALLERGY_OVERRIDE");
				            	String dose_override		= (String)drug_detail.get("DOSE_OVERRIDE");
				            	String currentrx_override	= (String)drug_detail.get("CURRENTRX_OVERRIDE");
				            	String stock_uom			=  	bean_CRX.getStockUOM((String)drug_detail.get("DRUG_CODE"));
				            	String generic_id			= (String)drug_detail.get("GENERIC_ID");
				            	String generic_name			= (String)drug_detail.get("GENERIC_NAME");
				            	String drugDescription1 		= (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
				            	String limit_ind			= (String)drug_detail.get("LIMIT_IND");
				            	String allergy_yn			= (String)drug_detail.get("ALLERGY_YN");
				            	String current_rx			= (String)drug_detail.get("CURRENT_RX");
				            	String drug_code			= (String)drug_detail.get("DRUG_CODE");
				            	String srl_no				= (String)drug_detail.get("SRL_NO");
				            	String pres_base_uom		= (String)drug_detail.get("PRES_BASE_UOM"); 
				            	String pres_base_uom_need   =  CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,pres_base_uom));//Modified for CRF--0749
				            	String external_product_id	= (String)drug_detail.get("EXTERNAL_PRODUCT_ID");
				                String perform_ext_db_checks	=(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS"); 
				            	String drug_class = (String)drug_detail.get("DRUG_CLASS")==null?"":(String)drug_detail.get("DRUG_CLASS");	
				            	String startdate = (String)drug_detail.get("START_DATE");
				            	String enddate = (String)drug_detail.get("END_DATE");	
				            	String drug_remstr			=   (String) drug_detail.get("DRUG_REMARKS")==null?"":(String) drug_detail.get("DRUG_REMARKS");
				            	String currentOverRes=  (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String) drug_detail.get("CURRENTRX_REMARKS");
				            	String currentAllergyOverRes =  (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String) drug_detail.get("ALLERGY_REMARKS");
				            	String currentDoseOverRes =  (String) drug_detail.get("DOSE_REMARKS")==null?"":(String) drug_detail.get("DOSE_REMARKS");
				            	
				            	ArrayList exProd				= new ArrayList();
				            	ArrayList drugDesc				= new ArrayList();
				            	String dup_drug_det			    = "";
				            	HashMap drug_Interactions		= null;
				            	//boolean chk_drug_med_condition	= false;
				            	//StringBuffer interaction_det    = new StringBuffer();
				            	//String contra_indication_for_drug   = "";

				            	String drug_db_contraind_check_flag	="N";
				            	String drug_db_interact_check_flag	="N";
				            	String drug_db_duptherapy_flag		="N";
				            	String drug_db_dose_check_flag      ="N"; 
				            	String drug_db_allergy_flag			="N";
				            	//String ext_override_reason		="";
				            	String ext_prod_id                   ="";

				            	ArrayList temp =(ArrayList)bean_CRX.getDrugDetails();
				            	
				            	
				    			 for(int j=0;j<temp.size();j++){
				    				drug_data	=	(HashMap)temp.get(j);					
				    				drugDesc.add((String)drug_data.get("DRUG_DESC"));
				    				ext_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_data.get("EXTERNAL_PRODUCT_ID");
				    				if(!ext_prod_id.equals("")){
				    					 exProd.add(ext_prod_id);
				    				}
				    			 }
				    			 ext_prod_id = drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
				    			 /*
				    				if(exProd.size()>0)
				    					beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
				    				*/
				    			 if(!ext_prod_id.equals("")){
				    					/*
				    	                if(drug_db_interact_check_yn.equals("Y")){
				    					   beanex.getDDInteractions(external_product_id);//Store interactions
				    					       drug_Interactions		= beanex.getInteractions();//get Interactions
				    						if(drug_Interactions.size()>0){							
				    	                         drug_db_interact_check_flag="Y";
				    						}
				    			        }
				    	                if(drug_db_duptherapy_yn.equals("Y")){ 
				    					   dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result

				    					   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
				    	                        drug_db_duptherapy_flag="Y";
				    					}
				    	                if(drug_db_contraind_check_yn.equals("Y")){
				    						  ArrayList ex_prod_ids =new ArrayList();
				    						  ex_prod_ids.add(external_product_id);
				    					      boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
				    						  HashMap contra_indications =(HashMap)beanex.getContraIndications();
				    						  if(contra_indications.containsKey(external_product_id)){
				    							 drug_db_contraind_check_flag="Y";
				    						  }				  
				    					}

				    					if(drug_db_allergy_check_yn.equals("Y")){
				    						ArrayList ex_prod_ids =new ArrayList();
				    						ex_prod_ids.add(ext_prod_id);
				    						beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
				    						HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
				    						if(drug_alergies.containsKey(ext_prod_id)){
				    							drug_db_allergy_flag	= "Y";
				    						}	
				    					}*/
				    					if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
				    						String storeIDs = "N";
				    						if(exProd.size()>0 )
				    							storeIDs = "Y";
				    							
				    						HashMap tempDetails= null;
				    						ArrayList reqChecks = new ArrayList();
				    						reqChecks.add("N"); //Dosage Check 
				    						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
				    						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
				    						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
				    						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
				    						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				    						if(drugDBCheckResult!=null)
				    							beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
				    						if(drug_db_allergy_check_yn.equals("Y")){
				    						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
				    							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
				    							   if(allergy_alert!=null && !allergy_alert.equals(""))
				    									drug_db_allergy_flag="Y";
				    						   } 
				    						   else {  
				    								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
				    								if(tempDetails!=null && tempDetails.size()>0){
				    									 drug_db_allergy_flag="Y";
				    								}
				    							} 
				    						}

				    						if(drug_db_interact_check_yn.equals("Y")){
				    							tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
				    							if(tempDetails!=null && tempDetails.size()>0){
				    								 drug_db_interact_check_flag="Y";
				    							}
				    						}

				    						if(drug_db_duptherapy_yn.equals("Y")){ 
				    						   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
				    						   if(dup_drug_det!=null && !dup_drug_det.equals(""))
				    								drug_db_duptherapy_flag="Y";
				    						}
				    						if(drug_db_contraind_check_yn.equals("Y")){
				    							tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
				    							if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
				    								drug_db_contraind_check_flag="Y";
				    							}		
				    						}
				    					}
				    				}
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);
				    				if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_yn.equals("Y")){
				    					//out.println("viewMedicationAlert('"+drug_code+"','"+recno+"','"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ON_LOAD','','','','','','"+drug_db_allergy_flag+"');");
				    				}

				    				if(drug_db_duptherapy_flag.equals("Y")){
				    					current_rx ="N";
				    					drug_detail.put("CURRENT_RX",current_rx);
				    				}

				    				if(drug_db_allergy_flag.equals("Y")){
				    					allergy_yn ="N";
				    					drug_detail.put("ALLERGY_YN",allergy_yn);
				    				}

				    				if(perform_ext_db_checks.equals("Y")){
				    					limit_ind = "Y";
				    					drug_detail.put("LIMIT_IND",limit_ind);
				    				}
				    								
				    				if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
				    					//out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"');");
				    				}
				                	
				    				
				    				
				            	
				            	strengthValue = (String)drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
								strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");	
								String TOT_STRENGTH_UOM_CODE =(String)drug_detail.get("TOT_STRENGTH_UOM")==null?"":(String)drug_detail.get("TOT_STRENGTH_UOM");
								
								DosageValue=DosageValue+TOT_STRENGTH_UOM_CODE+",";
								DosageText=DosageText+strengthDesc+",";
								
                                formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC");	
                                
                                allDrugs+=drugCode+",";
                                allDrugs_count=allDrugs_count+1;
								strengthOrder_qty = (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
                                strengthQty_UOM = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");
								pres_base_uom_value = (String)drug_detail.get("PRES_BASE_UOM")==null?"":(String)drug_detail.get("PRES_BASE_UOM");
									
								
						   String ORDER_QTY = (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
						   String DRUG_INDICATION =		 (String)drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
						   
						   
								//allergyOverride = (String)drug_detail.get("ALLERGY_YN")==null?"":(String)drug_detail.get("ALLERGY_YN");
								//dosagelimitOverride = (String)drug_detail.get("DOSE_OVERRIDE")==null?"":(String)drug_detail.get("DOSE_OVERRIDE");
								//drugIndication = (String)drug_detail.get("LIMIT_IND")==null?"":(String)drug_detail.get("LIMIT_IND");									
								//drugOverride = (String)drug_detail.get("CURRENT_RX")==null?"":(String)drug_detail.get("CURRENT_RX");
								
                                /* build MAR values */
	                            if(buildMAR_yn.equals("Y"))
			                      buildMAR_ynCheck="checked";
	                            else{
		                          buildMAR_ynCheck="";
		                          buildMAR_yn = "N";
	                            }
						
	                            if(i==0)  {               // To load the build MAR based on the first drug
							      buildMAR_rule	= (String)drugDetails.get("BUILD_MAR_RULE")==null?"":(String)drugDetails.get("BUILD_MAR_RULE");
						        }
						        buildMAR_yn="N";
						        if(buildMAR_rule==null){
							      buildMAR_rule="";
						        }
						        if(buildMAR_rule.equals("CE")){
							      buildMAR_ynCheck ="checked";		
							      buildMAR_ynEnable="";
							      buildMAR_yn="Y";
						        }
						        else if(buildMAR_rule.equals("UE")){
							      buildMAR_ynCheck ="";		
							      buildMAR_ynEnable="";
						        }
						        else if(buildMAR_rule.equals("CD")){
							      buildMAR_ynCheck ="checked";		
							      buildMAR_ynEnable="disabled";
							      buildMAR_yn="Y";
						        }
						        else if(buildMAR_rule.equals("UD")){
							     buildMAR_ynCheck ="";		
							     buildMAR_ynEnable="disabled";
						        }
						
						        bean_CRX.setBuildMAR_yn(buildMAR_yn);
						
	                            buildMAR_yn     = (String)drugDetails.get("BUILDMAR_YN")==null?"":(String)drugDetails.get("BUILDMAR_YN");								
									
                        %>						
						<div id="CRx_strength_Inner" >
							    <div class="CRxBannerIndWrapper" style="">
									<div style="height:auto;width:100%">								
										<div class="CRxBannerContent" >
											<div class="ivrxDrugHeader segoeuiBold">
											   <%=drugDescription1%>
											</div>
											<div class="pharmRxOrderStrength">
												<div class="pharmRxOrderItemDesc">
			                                    <%
			                                    if(!strengthValue.equals("0"))
												{ 
											    %>
			                                    <label class="pharmRxOrderItemLabel">Strength : </label>
                                                <span class="pharmRxOrderItemInfo segoeuiBold"><%=strengthValue%> <%=strengthDesc%></span>	 
                                                <%
												} 
												%> 
			                                    <label class="pharmRxOrderItemLabel">Form : </label>
			                                    <span class="pharmRxOrderItemInfo segoeuiBold"><%=formDesc%></span>
												
												<input type="hidden" id="current_qty_S<%=i%>" name="current_qty_S<%=i%>" value="<%=strengthValue%>">
												</div>
			                                </div>
											<div class="CRxBannerIconsWrap" style="">
													<%
													if(!ext_prod_id.equals("") && drug_db_interface_yn.equals("Y")){
													%>
													<span class="pharmRxOrderItemIconsVRalign">
													<img src="${path}/eIPAD/images/externalDatabase25X25.png" class="imgBannerIndicator"></span>
													<%}
													if(dose_override.equals("Y")){
													%>
													<span name="" class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/beyondDoseLimit25X25.png" class="imgBannerIndicator"></span>
													<%
													}if(current_rx.equals("Y")){
													%>
													<span name="" class="pharmRxOrderItemIconsVRalign" >
														<img src="${path}/eIPAD/images/duplicateDrug25X25.png" class="imgBannerIndicator"></span>
													<%}
													if(allergy_yn.equals("Y")){
													%>
													<span  class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/pharmAllergy25X25.png" class="imgBannerIndicator"></span>
													<%
													}
													%>
											</div>
										</div>
										<div class="CRxBannerContent" style="">
											<div class="IVrxLabel segoeuiBold paddingBottom5px" style="padding-top:10px;">Quantity<font class="rxMandatorIndi">*</font></div>
											<input id="strengthQty_<%=i%>" type="text" class="k-textbox" style="height:43px;width:99%;"  size="6" maxlength="6" onblur="calculateOrderQuantiyInStrengthMode(<%=i%>)" value="<%= ORDER_QTY %>"/>
											<div class="pharHtWtTextboxDurnUnit"id="strengthQty_UOM_<%=i%>"><%=strengthQty_UOM%></div>
										</div>
									</div>
							    </div>		
												  			 
							    <div class="detailsViewWrapper detailsViewWrapBorder" style="">
								   <div id="dynamicContentWrapper" style="padding-bottom:15px;padding-top:0px;" class="paddingLeftRight10px ivWithAddDynamicContentWrapperCss onOrientationChangeDynamicWrapper">			
                                                <%
												//if(perform_ext_db_checks.equals("Y")){
												%>									
												<div class="textareaWrapper" id="crxDrugIndication">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Drug indications
			                                                    </div>													 
															    <textarea  id="txtDrugIndi_S<%=i%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;" value="<%=DRUG_INDICATION %>"><%=DRUG_INDICATION %></textarea>
															  </div>
													       </div>
												</div>
                                                <%
												//}
												%>
                                                <div class="textareaWrapper" id="crxDrugRemarks_Strength">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Remarks
			                                                    </div>													 
															    <textarea  id="drugRemTextarea_S<%=i%>" class="k-textbox"maxlength="40" style="height:57px;width:100%;"><%=URLDecoder.decode(drug_remstr, "UTF-8")%></textarea>
															    
															  </div>
													       </div>
												</div>   												
																								
												<%
												if(current_rx.equals("Y")){
												%>												
												<div class="textareaWrapper" id="crxDuplicateDrugOverride">
													  <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																   Duplicate drug override reason<font class="rxMandatorIndi">*</font>
			                                                    </div>									 				 
															    <textarea id="txtDuplicateDrug_S<%=i%>"  value="<%=currentOverRes %>" class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=currentOverRes %></textarea>
															  </div>
													  </div>
												</div>
												<input type="hidden" id="DuplicateDrug_S<%=i%>" value="<%=current_rx %>">
                                                <%
												}else{
													
													%>
												<input type="hidden" id="DuplicateDrug_S<%=i%>" value="<%=current_rx %>">	
													<%
												}
												if(allergy_yn.equals("Y")){
												%>    												

												<div class="textareaWrapper" id="crxAllergyOverride">
												     <div class="fullHtFullWt">
													      <div class="positionRelative" >
														     <div class="IVrxLabel segoeuiBold paddingBottom5px">
															    Allergy override reason<font class="rxMandatorIndi">*</font>
			                                                 </div>													 
													         <textarea id="txtAllergyOverride_S<%=i%>" value="<%=currentAllergyOverRes%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=currentAllergyOverRes%></textarea>
														  </div>
												     </div>
												</div>
												<input type="hidden" id="AllergyOverride_S<%=i%>" value="<%=allergy_yn %>">
                                                <%
												}else{
													
													%>
												<input type="hidden" id="AllergyOverride_S<%=i%>" value="<%=allergy_yn %>">
													<%
												}
												if(dose_override.equals("Y")){
												%>
												<div class="textareaWrapper">
													    <div class="fullHtFullWt">
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Beyond dosage limit override reason<font class="rxMandatorIndi">*</font>
			                                                    </div>													 
															    <textarea id="txtBeyondDosage_S<%=i%>"  value="<%=currentDoseOverRes%>"  class="k-textbox"  maxlength="255" style="height:57px;width:99%;"><%=currentDoseOverRes%></textarea>
															  </div>
													     </div>
												</div>
													<input type="hidden" id="BeyondDosage_S<%=i%>" value="<%=dose_override %>">
												<%
												}
                                                      else{
													
													%>
												<input type="hidden" id="BeyondDosage_S<%=i%>" value="<%=dose_override %>">
													<%
												}
												%>
									</div>									
								</div>
						</div>
						<input type="hidden" id="drug_code_<%=i%>" name="drug_code_<%=i%>"	 value="<%=drugCode%>">
						<input type="hidden" id="drug_name<%=i%>" name="drug_name<%=i%>"	 value="<%=drugDescription1%>">
						
						<input type="hidden" name="drug_class<%=i%>" id="drug_class<%=i%>" value="">
						<input type="hidden" name="external_prod_id<%=i%>" id="external_prod_id<%=i%>" value="">
						<input type="hidden" name="Perform_ext_db_checks_YN<%=i%>" id="Perform_ext_db_checks_YN<%=i%>" value="N">
						<input type="hidden" id="strength<%=i%>" name="strength<%=i%>" value="">
						
						<input type="hidden" id="strengthDesc_<%=i%>" name="strengthDesc_<%=i%>" value="<%=strengthDesc%>">
						
						<input type="hidden" name="strength_uom<%=i%>" id="strength_uom<%=i%>"	value="">
						<input type="hidden" name="strength_uom_need<%=i%>" id="strength_uom_need<%=i%>"	value="">
						
						
						<input type="hidden" name="generic_id<%=i%>" id="generic_id<%=i%>" value="">
						<input type="hidden" name="generic_name<%=i%>" id="generic_name<%=i%>"	value="">
						
						<input type="hidden" name="pres_base_uom<%=i%>" id="pres_base_uom<%=i%>"	id="pres_base_uom<%=i%>" value="<%=pres_base_uom_value%>">
						<input type="hidden" name="pres_base_uom_need<%=i%>" id="pres_base_uom_need<%=i%>" value="">
						
						<input type="hidden" name="equvalentUOM_conversion_value<%=i%>" id="equvalentUOM_conversion_value<%=i%>" id="equvalentUOM_conversion_value<%=i%>" value="">
						<input type="hidden" name="equvalentUOM_conversion_factor<%=i%>" id="equvalentUOM_conversion_factor<%=i%>" id="equvalentUOM_conversion_factor<%=i%>" value="">
						<input type="hidden" name="contentInPresBaseUOM<%=i%>" id="contentInPresBaseUOM<%=i%>" id="contentInPresBaseUOM<%=i%>" value="">
						<input type="hidden" name="orderQty<%=i%>" id="orderQty<%=i%>" id="orderQty<%=i%>" value="">
						<input type="hidden" name="orderQtyUOM<%=i%>" id="orderQtyUOM<%=i%>" id="orderQtyUOM<%=i%>" value="">
								
						<input type="hidden" name="strength_uom_<%=i%>" id="strength_uom_<%=i%>" id="strength_uom_<%=i%>" value="">
						
						
						
						<%
                            }
							if(DosageValue.length()>0)  
								DosageValue = DosageValue.substring(0, DosageValue.length()-1);
							if(DosageText.length()>0)
								DosageText = DosageText.substring(0, DosageText.length()-1);
					    }
					    %>	
		                
		            </div>
                </div>					
	            <!-- Strength ends -->
				<!-- Ratio -->
               	<div id="CRx_ratio" style="display:none;" class="row ivrxDetailsViewContentRowWrapper"  data-role = "none">					
					<div class="detailsViewMainWrapper">	
					<%     String TOTAL_QTY ="";
							 if(presDetails.size()>0){
							 drug_detail = (HashMap) presDetails.get(0);
							 TOTAL_QTY = (String)drug_detail.get("TOTAL_QTY")==null?"":(String)drug_detail.get("TOTAL_QTY");	
							 }
					
					%>
					    <div id="CRx_ratio_inner">	
							<div class="finalProdSection" style="">
									<div class="finalProdContent" style="" >
											<div class="IVrxLabel segoeuiBold fullHtHalfWt" >
												<span>Required final product quantity</span><font class="rxMandatorIndi">*</font>
											</div>	  
									</div>
										<div style="width:50%;" >
											 <div style="width: 49%;display:inline-block;" >
													<input type="text" class="ivrxWithAddDrugUnit k-textbox" style="width:100%;height:43px;"  id="final_prod_qty" onblur="percentageRatioCalculation('o','NX','R')" value="<%=TOTAL_QTY %>"  maxlength="3"/>
											 </div>
											<div style="width: 49%;display:inline-block;">
												 <div  class="interDurationTime">
									             
	                                            <select style="width:100%;" id="req_qty_UOM" onChange="validateUOMRatioPercent('R',this)">
												<%=final_prod_qty_uom%>
												</select>
	                                              </div>
										    </div>
										</div>
							</div>
						    <div class="detailsViewMainWrapper">
							   <%
				                if(presDetails.size()>0){
						            for(int j=0;j<presDetails.size();j++){	
						            	drug_detail = (HashMap) presDetails.get(j);
						            	if(PRES_BY_BASE.equals("")){
								          PRES_BY_BASE=(String)drug_detail.get("PRES_BY_BASE")==null?"":(String)drug_detail.get("PRES_BY_BASE");	
								        }
							            drugDescription = (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
										strengthValue = (String)drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
								        strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");	
                                        formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC");
										drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
                                        ratioQty_UOM = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");										
										pres_base_uom_value = (String)drug_detail.get("PRES_BASE_UOM")==null?"":(String)drug_detail.get("PRES_BASE_UOM");
						            	
										
										//banner indicators begins
						                String strength				= (String)drug_detail.get("STRENGTH_VALUE");
						            	String strength_uom			= (String)drug_detail.get("STRENGTH_UOM");
						            	String strength_uom_need	= CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,strength_uom));//Modified for CRF--0749 INC-13640
						            	String dosage				= (String)drug_detail.get("QTY_VALUE");
						            	String dosage_uom			= (String)drug_detail.get("QTY_UOM");
						            	String form_desc			= (String)drug_detail.get("FORM_DESC");
						            	String allergy_override		= (String)drug_detail.get("ALLERGY_OVERRIDE");
						            	String dose_override		= (String)drug_detail.get("DOSE_OVERRIDE");
						            	String currentrx_override	= (String)drug_detail.get("CURRENTRX_OVERRIDE");
						            	String stock_uom			=  	bean_CRX.getStockUOM((String)drug_detail.get("DRUG_CODE"));
						            	String generic_id			= (String)drug_detail.get("GENERIC_ID");
						            	String generic_name			= (String)drug_detail.get("GENERIC_NAME");
						            	String drugDescription1 		= (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
						            	String limit_ind			= (String)drug_detail.get("LIMIT_IND");
						            	String allergy_yn			= (String)drug_detail.get("ALLERGY_YN");
						            	String current_rx			= (String)drug_detail.get("CURRENT_RX");
						            	String drug_code			= (String)drug_detail.get("DRUG_CODE");
						            	String srl_no				= (String)drug_detail.get("SRL_NO");
						            	String pres_base_uom		= (String)drug_detail.get("PRES_BASE_UOM"); 
						            	String pres_base_uom_need   =  CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,pres_base_uom));//Modified for CRF--0749
						            	String external_product_id	= (String)drug_detail.get("EXTERNAL_PRODUCT_ID");
						                String perform_ext_db_checks	=(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS"); 
						            	String drug_class = (String)drug_detail.get("DRUG_CLASS")==null?"":(String)drug_detail.get("DRUG_CLASS");	
						            	String startdate = (String)drug_detail.get("START_DATE");
						            	String enddate = (String)drug_detail.get("END_DATE");	
						            	String drug_remstr			=   (String) drug_detail.get("DRUG_REMARKS")==null?"":(String) drug_detail.get("DRUG_REMARKS");
						            	String currentOverRes=  (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String) drug_detail.get("CURRENTRX_REMARKS");
						    		    String currentAllergyOverRes =  (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String) drug_detail.get("ALLERGY_REMARKS");
						                String currentDoseOverRes =  (String) drug_detail.get("DOSE_REMARKS")==null?"":(String) drug_detail.get("DOSE_REMARKS");
						            	
						            	ArrayList exProd				= new ArrayList();
						            	ArrayList drugDesc				= new ArrayList();
						            	String dup_drug_det			    = "";
						            	HashMap drug_Interactions		= null;
						            	
						            	String drug_db_contraind_check_flag	="N";
						            	String drug_db_interact_check_flag	="N";
						            	String drug_db_duptherapy_flag		="N";
						            	String drug_db_dose_check_flag      ="N"; 
						            	String drug_db_allergy_flag			="N";
						            	String ext_prod_id                   ="";

						            	ArrayList temp =(ArrayList)bean_CRX.getDrugDetails();
						    			 for(int k=0;k<temp.size();k++){
						    				drug_data	=	(HashMap)temp.get(k);					
						    				drugDesc.add((String)drug_data.get("DRUG_DESC"));
						    				ext_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_data.get("EXTERNAL_PRODUCT_ID");
						    				if(!ext_prod_id.equals("")){
						    					 exProd.add(ext_prod_id);
						    				}
						    			 }
						    			 ext_prod_id = drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
						    			 
						    			 if(!ext_prod_id.equals("")){
						    					/*
						    	                if(drug_db_interact_check_yn.equals("Y")){
						    					   beanex.getDDInteractions(external_product_id);//Store interactions
						    					       drug_Interactions		= beanex.getInteractions();//get Interactions
						    						if(drug_Interactions.size()>0){							
						    	                         drug_db_interact_check_flag="Y";
						    						}
						    			        }
						    	                if(drug_db_duptherapy_yn.equals("Y")){ 
						    					   dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result

						    					   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
						    	                        drug_db_duptherapy_flag="Y";
						    					}
						    	                if(drug_db_contraind_check_yn.equals("Y")){
						    						  ArrayList ex_prod_ids =new ArrayList();
						    						  ex_prod_ids.add(external_product_id);
						    					      boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
						    						  HashMap contra_indications =(HashMap)beanex.getContraIndications();
						    						  if(contra_indications.containsKey(external_product_id)){
						    							 drug_db_contraind_check_flag="Y";
						    						  }				  
						    					}

						    					if(drug_db_allergy_check_yn.equals("Y")){
						    						ArrayList ex_prod_ids =new ArrayList();
						    						ex_prod_ids.add(ext_prod_id);
						    						beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
						    						HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
						    						if(drug_alergies.containsKey(ext_prod_id)){
						    							drug_db_allergy_flag	= "Y";
						    						}	
						    					}*/
						    					if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
						    						String storeIDs = "N";
						    						if(exProd.size()>0 )
						    							storeIDs = "Y";
						    							
						    						HashMap tempDetails= null;
						    						ArrayList reqChecks = new ArrayList();
						    						reqChecks.add("N"); //Dosage Check 
						    						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
						    						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
						    						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
						    						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
						    						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
						    						if(drugDBCheckResult!=null)
						    							beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
						    						if(drug_db_allergy_check_yn.equals("Y")){
						    						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
						    							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
						    							   if(allergy_alert!=null && !allergy_alert.equals(""))
						    									drug_db_allergy_flag="Y";
						    						   } 
						    						   else {  
						    								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
						    								if(tempDetails!=null && tempDetails.size()>0){
						    									 drug_db_allergy_flag="Y";
						    								}
						    							} 
						    						}

						    						if(drug_db_interact_check_yn.equals("Y")){
						    							tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
						    							if(tempDetails!=null && tempDetails.size()>0){
						    								 drug_db_interact_check_flag="Y";
						    							}
						    						}

						    						if(drug_db_duptherapy_yn.equals("Y")){ 
						    						   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
						    						   if(dup_drug_det!=null && !dup_drug_det.equals(""))
						    								drug_db_duptherapy_flag="Y";
						    						}
						    						if(drug_db_contraind_check_yn.equals("Y")){
						    							tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
						    							if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
						    								drug_db_contraind_check_flag="Y";
						    							}		
						    						}
						    					}
						    				}
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
						    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);
						    				if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_yn.equals("Y")){
						    					//out.println("viewMedicationAlert('"+drug_code+"','"+recno+"','"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ON_LOAD','','','','','','"+drug_db_allergy_flag+"');");
						    				}

						    				if(drug_db_duptherapy_flag.equals("Y")){
						    					current_rx ="N";
						    					drug_detail.put("CURRENT_RX",current_rx);
						    				}

						    				if(drug_db_allergy_flag.equals("Y")){
						    					allergy_yn ="N";
						    					drug_detail.put("ALLERGY_YN",allergy_yn);
						    				}

						    				if(perform_ext_db_checks.equals("Y")){
						    					limit_ind = "Y";
						    					drug_detail.put("LIMIT_IND",limit_ind);
						    				}
						    								
						    				if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
						    					//out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"');");
						    				}
								     
								        //ratio_value_
								        String ratio_precenatge=  (String)drug_detail.get("RATIO_PERCENTAGE")==null?"":(String)drug_detail.get("RATIO_PERCENTAGE");
								        //ratio_req_qty_
								        
								        String reqd_qty=  (String)drug_detail.get("REQD_QTY")==null?"":(String)drug_detail.get("REQD_QTY");
								        String ord_qty=  (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
								        
								        String DRUG_INDICATION=  (String)drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
						        %>	
							    <div class="CRxBannerIndWrapper" style="">
									<div style="height:auto;width:100%">
										<div class="CRxBannerContent" >
											<div class="ivrxDrugHeader segoeuiBold">
											    <%=drugDescription%>
											</div>
											<div class="cell pharmRxOrderStrength">
												<div class="pharmRxOrderItemDesc">
			                                    <%
			                                    if(!strengthValue.equals("0"))
												{ 
											    %>
			                                    <label class="pharmRxOrderItemLabel">Strength : </label>
                                                <span class="pharmRxOrderItemInfo segoeuiBold"><%=strengthValue%> <%=strengthDesc%></span>	 
                                                <%
												} 
												%> 
			                                    <label class="pharmRxOrderItemLabel">Form : </label>
			                                    <span class="pharmRxOrderItemInfo segoeuiBold"><%=formDesc%></span>
												
												<input type="hidden" id="current_qty_R<%=j%>" name="current_qty_R<%=j%>" value="<%=strengthValue%>">
												</div>
			                                </div>
											<div class="CRxBannerIconsWrap" style="">
													<%
													if(!ext_prod_id.equals("") && drug_db_interface_yn.equals("Y")){
													%>
													<span class="pharmRxOrderItemIconsVRalign">
													<img src="${path}/eIPAD/images/externalDatabase25X25.png" class="imgBannerIndicator"></span>
													<%}
													if(dose_override.equals("Y")){
													%>
													<span name="" class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/beyondDoseLimit25X25.png" class="imgBannerIndicator"></span>
													<%
													}if(current_rx.equals("Y")){
													%>
													<span name="" class="pharmRxOrderItemIconsVRalign" >
														<img src="${path}/eIPAD/images/duplicateDrug25X25.png" class="imgBannerIndicator"></span>
													<%}
													if(allergy_yn.equals("Y")){
													%>
													<span  class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/pharmAllergy25X25.png" class="imgBannerIndicator"></span>
													<%
													}
													%>
											</div>
										</div>
										<div class="CRxBannerContent">
										  <div style="display:flex;">
										   <div style="width:33%;padding-right:5px;">
										     <div class="IVrxLabel segoeuiBold paddingBottom5px" style="padding-top:5px;">Ratio<font class="rxMandatorIndi">*</font></div>
											 <input type="text" class="k-textbox" id="ratio_value_<%=j%>" value="<%=ratio_precenatge %>" style="height:43px;width:100%;" maxlength="2" onblur="percentageRatioCalculation('<%=j%>','PR','R')"/>
										   </div>
										   <div style="width:33%;padding-right:5px;">
										     <div class="IVrxLabel segoeuiBold paddingBottom5px" style="padding-top:5px;">Req qty</div>
											 <input  type="text" class="k-textbox k-state-disabled" id="ratio_req_qty_<%=j%>" style="height:43px;width:100%;" value="<%=reqd_qty %>" readonly></input>
										   </div>
										   <div style="width:33%;padding-right:5px;">
										     <div class="IVrxLabel segoeuiBold paddingBottom5px"  style="padding-top:5px;">Derived qty</div>											 
											   <div class="interInputWrap">
												  <div class="pharContentKgLabel fullWidth">
											       <input type="text" class="k-textbox k-state-disabled" id="ratio_derived_qty_<%=j%>" style="height:43px;width:100%;" value="<%=ord_qty %>" readonly></input>
											       <div class="pharHtWtTextboxUnit" style="right:2%" id="ratioQty_UOM_<%=j%>"><%=ratioQty_UOM%></div>
											      </div>
											  </div>											 
										   </div>
										  </div>
										</div>
									</div>
							    </div>		
												  			 
							    <div class="detailsViewWrapper detailsViewWrapBorder">									
									<div id="dynamicContentWrapper" style="padding-bottom:15px;padding-top:0px;display:inline-block;" class="paddingLeftRight10px  onOrientationChangeDynamicWrapper">			
									<%
												//if(drugIndication.equals("Y")){
												%>									
												<div class="textareaWrapper" id="crxDrugIndication">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Drug indications
			                                                    </div>													 
															    <textarea  id="txtDrugIndi_R<%=j%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;" value="<%=DRUG_INDICATION %>" > <%=DRUG_INDICATION %></textarea>
															  </div>
													       </div>
												</div>
                                                <%
												//}
												%> 												
                                                <div class="textareaWrapper" id="crxDrugRemarks_Ratio">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Remarks
			                                                    </div>													 
															    <textarea id="drugRemTextarea_R<%=j%>" class="k-textbox" maxlength="40" style="height:57px;width:100%;"><%=URLDecoder.decode(drug_remstr, "UTF-8") %></textarea>
															  </div>
													       </div>
												</div> 												 
												<%
												if(current_rx.equals("Y")){
												%>												
												<div class="textareaWrapper" id="crxDuplicateDrugOverride">
													  <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																   Duplicate drug override reason<font class="rxMandatorIndi">*</font>
			                                                    </div>													 
															    <textarea id="txtDuplicateDrug_R<%=j%>"  value="<%=currentOverRes%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=currentOverRes%></textarea>
															  </div>
													  </div>
												</div>
												<input type="hidden" id="DuplicateDrug_R<%=j%>" value="<%=current_rx %>">
                                                <%
												}else{
													
													%>
												<input type="hidden" id="DuplicateDrug_R<%=j%>" value="<%=current_rx %>">
													<%
												}
												if(allergy_yn.equals("Y")){
												%>    												

												<div class="textareaWrapper" id="crxAllergyOverride">
												     <div class="fullHtFullWt">
													      <div class="positionRelative" >
														     <div class="IVrxLabel segoeuiBold paddingBottom5px">
															    Allergy override reason<font class="rxMandatorIndi">*</font>
			                                                 </div>													 
													         <textarea id="txtAllergyOverride_R<%=j%>"  value="<%=currentAllergyOverRes%>"  class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=currentAllergyOverRes%></textarea>
														  </div>
												     </div>
												</div>
												<input type="hidden" id="AllergyOverride_R<%=j%>" value="<%=allergy_yn %>">
                                                <%
												}else{
													
													%>
												<input type="hidden" id="AllergyOverride_R<%=j%>" value="<%=allergy_yn %>">
													<%
												}
												if(dose_override.equals("Y")){
												%>
												<div class="textareaWrapper">
													    <div class="fullHtFullWt">
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Beyond dosage limit override reason<font class="rxMandatorIndi">*</font>
			                                                    </div>													 
															    <textarea id="txtBeyondDosage_R<%=j%>"   value="<%=currentDoseOverRes %>" class="k-textbox"  maxlength="255" style="height:57px;width:99%;"><%=currentDoseOverRes %></textarea>
															  </div>
													     </div>
												</div>
												<input type="hidden" id="BeyondDosage_R<%=j%>" value="<%=dose_override %>">
												<%
												}else{
													
													%>
												<input type="hidden" id="BeyondDosage_R<%=j%>" value="<%=dose_override %>">
													<%
												}
												%>
									
									</div>									
								</div>
								<%
                                    }   
					            } 
					            %>
	                        </div> 
					    </div>	
				    </div>
                </div>					
				
                <!-- Ratio ends-->				
		        <!-- Percentage begins-->
				<div id="CRx_Percentage" style="display:none;" class="row ivrxDetailsViewContentRowWrapper"  data-role = "none">	
					<div class="detailsViewMainWrapper">
					<%         //  String TOTAL_QTY;
							 if(presDetails.size()>0){
							 drug_detail = (HashMap) presDetails.get(0);
							 TOTAL_QTY = (String)drug_detail.get("TOTAL_QTY")==null?"":(String)drug_detail.get("TOTAL_QTY");
							 }
					
					%>
					<div id="CRx_Percentage_inner">	
					    <div class="finalProdSection">
								<div class="finalProdContent">
								   <div class="IVrxLabel segoeuiBold fullHtHalfWt" >
								      <span>Required final product quantity</span><font class="rxMandatorIndi">*</font>
								   </div>
								</div>
								<div style="width:50%;" >
								   <div style="width: 49%;display:inline-block;" >
								      <input type="text" class="ivrxWithAddDrugUnit k-textbox" name="final_prod_qty_P" id="final_prod_qty_P" id="final_prod_qty_P" value="<%=TOTAL_QTY %>" onblur="percentageRatioCalculation('o','NX','P')"  size=5 maxlength=3 style="width:100%;height:43px;"/>
								   </div>
								   <div style="width: 49%;display:inline-block;">
									  <div  class="interDurationTime">
	                                      <select name=final_prod_qty_uom id="final_prod_qty_uom" style="width:100%;" onchange="validateUOMRatioPercent('P',this)">
	                                      		<%=final_prod_qty_uom%>
	                                      </select>
                                     </div>
								   </div>
								</div>
							</div>
						<div class="detailsViewMainWrapper">
                            <%
						    String allDrugs_percentage="";
                            String DosageInfo_percentage="";
                           //String calcDoseValueUnit="";
                    	
                        
				        if(presDetails.size()>0){
						    for(int i=0;i<presDetails.size();i++){	
						    		drug_detail = (HashMap) presDetails.get(i);
						    		if(PRES_BY_BASE.equals("")){
								       PRES_BY_BASE=(String)drug_detail.get("PRES_BY_BASE")==null?"":(String)drug_detail.get("PRES_BY_BASE");	
								    }
						    	 	drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
					                drugDescription = (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
									strengthValue = (String)drug_detail.get("STRENGTH_VALUE")==null?"":(String)drug_detail.get("STRENGTH_VALUE");
							        strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");	
                                    formDesc = (String)drug_detail.get("FORM_DESC")==null?"":(String)drug_detail.get("FORM_DESC");
									drugCode = (String)drug_detail.get("DRUG_CODE")==null?"":(String)drug_detail.get("DRUG_CODE");
                                    ratioQty_UOM = (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");										
									pres_base_uom_value = (String)drug_detail.get("PRES_BASE_UOM")==null?"":(String)drug_detail.get("PRES_BASE_UOM");
									
					                //banner indicators begins
					                String strength				= (String)drug_detail.get("STRENGTH_VALUE");
					            	String strength_uom			= (String)drug_detail.get("STRENGTH_UOM");
					            	String strength_uom_need	= CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,strength_uom));//Modified for CRF--0749 INC-13640
					            	String dosage				= (String)drug_detail.get("QTY_VALUE");
					            	String dosage_uom			= (String)drug_detail.get("QTY_UOM");
					            	String form_desc			= (String)drug_detail.get("FORM_DESC");
					            	String allergy_override		= (String)drug_detail.get("ALLERGY_OVERRIDE");
					            	String dose_override		= (String)drug_detail.get("DOSE_OVERRIDE");
					            	String currentrx_override	= (String)drug_detail.get("CURRENTRX_OVERRIDE");
					            	String stock_uom			=  	bean_CRX.getStockUOM((String)drug_detail.get("DRUG_CODE"));
					            	String generic_id			= (String)drug_detail.get("GENERIC_ID");
					            	String generic_name			= (String)drug_detail.get("GENERIC_NAME");
					            	String drugDescription1 		= (String)drug_detail.get("DRUG_DESC")==null?"":(String)drug_detail.get("DRUG_DESC");
					            	String limit_ind			= (String)drug_detail.get("LIMIT_IND");
					            	String allergy_yn			= (String)drug_detail.get("ALLERGY_YN");
					            	String current_rx			= (String)drug_detail.get("CURRENT_RX");
					            	String drug_code			= (String)drug_detail.get("DRUG_CODE");
					            	String srl_no				= (String)drug_detail.get("SRL_NO");
					            	String pres_base_uom		= (String)drug_detail.get("PRES_BASE_UOM"); 
					            	String pres_base_uom_need   =  CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,pres_base_uom));//Modified for CRF--0749
					            	String external_product_id	= (String)drug_detail.get("EXTERNAL_PRODUCT_ID");
					                String perform_ext_db_checks	=(String)drug_detail.get("PERFORM_EXTERNAL_DATABASE_CHECKS"); 
					            	String drug_class = (String)drug_detail.get("DRUG_CLASS")==null?"":(String)drug_detail.get("DRUG_CLASS");	
					            	String startdate = (String)drug_detail.get("START_DATE");
					            	String enddate = (String)drug_detail.get("END_DATE");
					            	String drug_remstr			=   (String) drug_detail.get("DRUG_REMARKS")==null?"":(String) drug_detail.get("DRUG_REMARKS");
					            	String currentOverRes=  (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String) drug_detail.get("CURRENTRX_REMARKS");
					    		    String currentAllergyOverRes =  (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String) drug_detail.get("ALLERGY_REMARKS");
					                String currentDoseOverRes =  (String) drug_detail.get("DOSE_REMARKS")==null?"":(String) drug_detail.get("DOSE_REMARKS");
					                
					                
					            	
					            	ArrayList exProd				= new ArrayList();
					            	ArrayList drugDesc				= new ArrayList();
					            	String dup_drug_det			    = "";
					            	HashMap drug_Interactions		= null;
					            	
					            	String drug_db_contraind_check_flag	="N";
					            	String drug_db_interact_check_flag	="N";
					            	String drug_db_duptherapy_flag		="N";
					            	String drug_db_dose_check_flag      ="N"; 
					            	String drug_db_allergy_flag			="N";
					            	String ext_prod_id                   ="";

				            	ArrayList temp =(ArrayList)bean_CRX.getDrugDetails();
				            	
				            	
				    			 for(int j=0;j<temp.size();j++){
				    				drug_data	=	(HashMap)temp.get(j);					
				    				drugDesc.add((String)drug_data.get("DRUG_DESC"));
				    				ext_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_data.get("EXTERNAL_PRODUCT_ID");
				    				if(!ext_prod_id.equals("")){
				    					 exProd.add(ext_prod_id);
				    				}
				    			 }
				    			 ext_prod_id = drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
				    			 /*
				    				if(exProd.size()>0)
				    					beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
				    				*/
				    			 if(!ext_prod_id.equals("")){
				    					/*
				    	                if(drug_db_interact_check_yn.equals("Y")){
				    					   beanex.getDDInteractions(external_product_id);//Store interactions
				    					       drug_Interactions		= beanex.getInteractions();//get Interactions
				    						if(drug_Interactions.size()>0){							
				    	                         drug_db_interact_check_flag="Y";
				    						}
				    			        }
				    	                if(drug_db_duptherapy_yn.equals("Y")){ 
				    					   dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result

				    					   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
				    	                        drug_db_duptherapy_flag="Y";
				    					}
				    	                if(drug_db_contraind_check_yn.equals("Y")){
				    						  ArrayList ex_prod_ids =new ArrayList();
				    						  ex_prod_ids.add(external_product_id);
				    					      boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
				    						  HashMap contra_indications =(HashMap)beanex.getContraIndications();
				    						  if(contra_indications.containsKey(external_product_id)){
				    							 drug_db_contraind_check_flag="Y";
				    						  }				  
				    					}

				    					if(drug_db_allergy_check_yn.equals("Y")){
				    						ArrayList ex_prod_ids =new ArrayList();
				    						ex_prod_ids.add(ext_prod_id);
				    						beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
				    						HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
				    						if(drug_alergies.containsKey(ext_prod_id)){
				    							drug_db_allergy_flag	= "Y";
				    						}	
				    					}*/
				    					if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
				    						String storeIDs = "N";
				    						if(exProd.size()>0 )
				    							storeIDs = "Y";
				    							
				    						HashMap tempDetails= null;
				    						ArrayList reqChecks = new ArrayList();
				    						reqChecks.add("N"); //Dosage Check 
				    						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
				    						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
				    						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
				    						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
				    						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				    						if(drugDBCheckResult!=null)
				    							beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
				    						if(drug_db_allergy_check_yn.equals("Y")){
				    						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
				    							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
				    							   if(allergy_alert!=null && !allergy_alert.equals(""))
				    									drug_db_allergy_flag="Y";
				    						   } 
				    						   else {  
				    								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
				    								if(tempDetails!=null && tempDetails.size()>0){
				    									 drug_db_allergy_flag="Y";
				    								}
				    							} 
				    						}

				    						if(drug_db_interact_check_yn.equals("Y")){
				    							tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
				    							if(tempDetails!=null && tempDetails.size()>0){
				    								 drug_db_interact_check_flag="Y";
				    							}
				    						}

				    						if(drug_db_duptherapy_yn.equals("Y")){ 
				    						   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
				    						   if(dup_drug_det!=null && !dup_drug_det.equals(""))
				    								drug_db_duptherapy_flag="Y";
				    						}
				    						if(drug_db_contraind_check_yn.equals("Y")){
				    							tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
				    							if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
				    								drug_db_contraind_check_flag="Y";
				    							}		
				    						}
				    					}
				    				}
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				    				drug_detail.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);
				    				if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_yn.equals("Y")){
				    					//out.println("viewMedicationAlert('"+drug_code+"','"+recno+"','"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ON_LOAD','','','','','','"+drug_db_allergy_flag+"');");
				    				}

				    				if(drug_db_duptherapy_flag.equals("Y")){
				    					current_rx ="N";
				    					drug_detail.put("CURRENT_RX",current_rx);
				    				}

				    				if(drug_db_allergy_flag.equals("Y")){
				    					allergy_yn ="N";
				    					drug_detail.put("ALLERGY_YN",allergy_yn);
				    				}

				    				if(perform_ext_db_checks.equals("Y")){
				    					limit_ind = "Y";
				    					drug_detail.put("LIMIT_IND",limit_ind);
				    				}
				    								
				    				if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
				    					//out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"');");
				    				}
				                	
				            	
				            
								//strengthDesc = (String)drug_detail.get("STRENGTH_UOM_DESC")==null?"":(String)drug_detail.get("STRENGTH_UOM_DESC");
	                            //ratio_value_
						        String ratio_precenatge=  (String)drug_detail.get("RATIO_PERCENTAGE")==null?"":(String)drug_detail.get("RATIO_PERCENTAGE");
						        //ratio_req_qty_
						        
						        String reqd_qty=  (String)drug_detail.get("REQD_QTY")==null?"":(String)drug_detail.get("REQD_QTY");
						        //ratioQty_UOM_
						        String ord_qty=  (String)drug_detail.get("ORDER_QTY")==null?"":(String)drug_detail.get("ORDER_QTY");
						        String stock_display_unit_UOM= (String)drug_detail.get("PRES_BASE_UOM_DESC")==null?"":(String)drug_detail.get("PRES_BASE_UOM_DESC");								
						        String DRUG_INDICATION =  (String)drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
						        String base_drug_selected =  (String)drug_detail.get("BASE_DRUG")==null?"":(String)drug_detail.get("BASE_DRUG");
						        String sel="";
						        String dis="";
						        if(base_drug_selected.equalsIgnoreCase("Y")){
						        	sel="checked='checked'";
						        	dis="disabled='disabled'";
						        }else{
						        	
						        	sel="";
						        	dis="";
						        }
						       System.out.println("selll:"+sel+"dis::"+dis);
						%>						
							    <div class="CRxBannerIndWrapper" style="">
									<div style="height:auto;width:100%">								
										<div class="CRxBannerContent" >
										<div style="display:flex;">
											<div style="width:84%;">
												 <div class="ivrxDrugHeader segoeuiBold"> <%=drugDescription%> </div>
												<div class="cell pharmRxOrderStrength">
												      <div class="pharmRxOrderItemDesc">
 			                                            <%
			                                            if(!strengthValue.equals("0"))
														{
														%>
			                                            <label class="pharmRxOrderItemLabel">Strength : </label>
			                                            <span class="pharmRxOrderItemInfo segoeuiBold"><%=strengthValue%> <%=strengthDesc%></span>	 
			                                            <%
														}
														%> 
			                                            <label class="pharmRxOrderItemInfo">Form : </label>
														<span class="pharmRxOrderItemInfo segoeuiBold"><%=formDesc%></span>
														
														<input type="hidden" id="current_qty_P<%=i%>" name="current_qty_P<%=i%>" value="<%=strengthValue%>">
			                                          </div>
			                                    </div>
												<div class="CRxBannerIconsWrap" style="">
													<%
													if(!ext_prod_id.equals("") && drug_db_interface_yn.equals("Y")){
													%>
													<span class="pharmRxOrderItemIconsVRalign">
													<img src="${path}/eIPAD/images/externalDatabase25X25.png" class="imgBannerIndicator"></span>
													<%}
													if(dose_override == "Y"){
													%>
													<span name="" class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/beyondDoseLimit25X25.png" class="imgBannerIndicator"></span>
													<%
													}if(current_rx == "Y"){
													%>
													<span name="" class="pharmRxOrderItemIconsVRalign" >
														<img src="${path}/eIPAD/images/duplicateDrug25X25.png" class="imgBannerIndicator"></span>
													<%}
													if(allergy_yn == "Y"){
													%>
													<span  class="pharmRxOrderItemIconsVRalign">
														<img src="${path}/eIPAD/images/pharmAllergy25X25.png" class="imgBannerIndicator"></span>
													<%
													}
													%>
												</div>
											</div>
											<div class="CRxBaseCheckWrap">
											<span style="display:inline-block;width:45%;float:right;"><input style="height: 20px;width: 20px;vertical-align: text-top;" type="checkbox" <%=sel%> name='baseDrug<%=i%>' id='baseDrug<%=i%>' value='<%=i%>' onclick="selectBaseDrug(this)"></span>
													<span  class="pharmRxOrderItemLabel IVrxLabel" style="display:inline-block;vertical-align: middle;height: 15px;width:45%;color: #65696f;float:right;padding-top:3px;">Base</span>	
											</div>
										</div>
										</div>
										<div class="CRxBannerContent" >
											 <div style="display:flex;">
										   <div style="width:33%;padding-right:5px;">
										     <div class="IVrxLabel segoeuiBold paddingBottom5px" style="padding-top:5px;">Percentage<font class="rxMandatorIndi">*</font></div>
											  <input type="text" class="k-textbox" style="height:43px;width:100%;" <%=dis%> name="percent_ratio<%=i%>" value="<%=ratio_precenatge %>" size=2 id="percent_ratio<%=i%>"  onKeyPress="return percentageRatioValidation(this)" onblur="percentageRatioCalculation('<%=i%>','PR','P')"></input>
										   </div>
										   <div style="width:33%;padding-right:5px;">
										     <div class="IVrxLabel segoeuiBold paddingBottom5px" style="padding-top:5px;"> Req qty</div>
											  <input type="text" class="k-textbox" style="height:43px;width:100%;" name="req_qty_p<%=i%>" id="req_qty_p<%=i%>" value="<%=reqd_qty%>" size=1  maxlength="6" id="req_qty_p<%=i%>" readonly ></input>
										   </div>
										   <div style="width:33%;padding-right:5px;">
										     <div class="IVrxLabel segoeuiBold paddingBottom5px" style="padding-top:5px;" >Derived qty</div>
											   <div class="interInputWrap">
												  <div class="pharContentKgLabel fullWidth">
											       <input type="text" class="k-textbox" style="height:43px;width:100%;" name="derived_qty_p<%=i%>" id="derived_qty_p<%=i%>"  id="derived_qty_p<%=i%>" value="<%=ord_qty%>" size="3" maxlength="6" readonly ></input>
											       <div class="pharHtWtTextboxUnit" style="right:2%" id="stock_display_unit_P<%=i%>" name="stock_display_unit_P<%=i%>" > <%=stock_display_unit_UOM%></div>
											      </div>
											  </div>
										   </div>
										  </div>
										</div>
									</div>
							    </div>		
												  			 
							    <div class="detailsViewWrapper detailsViewWrapBorder">
										<div id="dynamicContentWrapper" style="padding-bottom:15px;padding-top:0px;display:inline-block;" class="paddingLeftRight10px  onOrientationChangeDynamicWrapper">												  
													<div  class="textareaWrapper">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Drug indications
			                                                    </div>													 
															    <textarea id="txtDrugIndi_P<%=i%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;" value="<%=DRUG_INDICATION %>"><%=DRUG_INDICATION %></textarea>
															  </div>
													       </div>
													</div>	
                                                    <div class="textareaWrapper" id="crxDrugRemarks_Percent">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Remarks
			                                                    </div>													 
															    <textarea id="drugRemTextarea_P<%=i%>" class="k-textbox" maxlength="40" style="height:57px;width:100%;"><%=URLDecoder.decode(drug_remstr, "UTF-8") %></textarea>
															  </div>
													       </div>
												    </div>													
													<%
													if(current_rx.equals("Y")){
													%>												
													<div  class="textareaWrapper">
													       <div class="fullHtFullWt" >
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																   Duplicate drug override reason<font class="rxMandatorIndi">*</font>
			                                                    </div>													 
															    <textarea id="txtDuplicateDrug_P<%=i%>" value="<%=currentOverRes%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=currentOverRes%></textarea>
															  </div>
													       </div>
													</div>
													<input type="hidden" id="DuplicateDrug_P<%=i%>" value="<%=current_rx %>">
													<%
													}
													else{
														
														%>
													<input type="hidden" id="DuplicateDrug_P<%=i%>" value="<%=current_rx %>">
														<%
													}if(allergy_yn.equals("Y")){
													%>													
													<div class="textareaWrapper">
												       <div class="fullHtFullWt">
													      <div class="positionRelative" >
														     <div class="IVrxLabel segoeuiBold paddingBottom5px">
															    Allergy override reason<font class="rxMandatorIndi">*</font>
			                                                 </div>													 
													         <textarea id="txtAllergyOverride_P<%=i%>"  value="<%=currentAllergyOverRes%>" class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=currentAllergyOverRes%></textarea>
														  </div>
												       </div>
													</div>
													<input type="hidden" id="AllergyOverride_P<%=i%>" value="<%=allergy_yn %>">
													<%
													}
else{
														
														%>
													<input type="hidden" id="AllergyOverride_P<%=i%>" value="<%=allergy_yn %>">
														<%
													}
													if(dose_override.equals("Y")){
													%>
													<div  class="textareaWrapper">
													       <div class="fullHtFullWt">
														      <div class="positionRelative">
															    <div class="IVrxLabel segoeuiBold paddingBottom5px">
																    Beyond dosage limit override reason<font class="rxMandatorIndi">*</font>
			                                                    </div>													 
															    <textarea id="txtBeyondDosage_P<%=i%>" value="<%=currentDoseOverRes %>" class="k-textbox" maxlength="255" style="height:57px;width:99%;"><%=currentDoseOverRes %></textarea>
															  </div>
													       </div>
													</div>
													<input type="hidden" id="BeyondDosage_P<%=i%>" value="<%=dose_override %>">
													<%
													}else{
														
														%>
													<input type="hidden" id="BeyondDosage_P<%=i%>" value="<%=dose_override %>">
														<%
													}
													%>
										</div>									
								</div>
	                    <%
						    }
				        }
				        %>						
						</div>
					</div>
                    </div>					
				<!-- Percentage ends-->	
                </div>
		<!-- Pharmacy legend starts --> <div id="CRxAddLegend"></div><!-- Pharmacy legend ends --> 							
	    </div>
	</div>
    <!-- Admin Details Tab Starts -->
	<div id="CRxAdmin" class="row" style="height:85%;width:100%;background-color:#f5f9fc;" data-role = "none">	
	    <div class="detailsViewMainWrapper" >					
			<div class="fullWidth">	   												
				<div style="display:flex;" class="paddingLeftRight10px">
					<div class="ivrxContainer">
											    <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   Dosage<font class="rxMandatorIndi">*</font>
												</div>
											 <div id="" class="table ivInterDoseDetailsWrapper" style="width:100%;">
	                                           <div  class="row fullWtHalfHt" style="">
												   <div class="cell fullHtHalfWt" style="">											   
												    <div class="pharContentKgLabel" style="padding-left:0px;">													
												      <input type="text" class="ivrxWithAddInfuseRateUnit k-textbox" name="dosage_value" id="dosage_value" id="dosage_value" size="1" maxlength="3" onblur="dosageChange(this);" value="<%=dosage_value%>" style="height:43px;width:98%;"/>
													   <div class="pharHtWtTextboxUnit" name="dosage_uom_display" style="right:14px;"></div>   
													  </div>												  
												   </div>
												   <div class="cell detailsCell">												      
													  <div  class="dropDown" style="width:100%;height:36px;">
	                                                    <select style="width: 100%" id="dosageUOM" name="uom" id="uom">
	                                                       <!-- %= DosageInfo % -->
	                                                    </select>
	                                                  </div>													  
												   </div>
												</div> 
												</div>		
				    </div> 
				<div style="width:0.2%;">
				</div>
				<div class="ivrxContainer">
											     <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   Frequency<font class="rxMandatorIndi">*</font>
												</div>
	                                      
                                                <select  style="width:99% ! important;height:43px;"  id="freq_value_crx" class="ivrxDosageByCss k-textbox">											
											    </select>												
	              </div>	 										 						
				</div>
										    <div style="display:flex;" class="paddingLeftRight10px">
										    <div class="ivrxContainer">
											  <div class="IVrxLabel segoeuiBold" style="padding-top:10px;padding-bottom:5px;">
												   Duration<font class="rxMandatorIndi">*</font>
												</div>
												<div id="doseDetailsWrapper" class="table interDurationRepeat">
	                                               <div id="doseInput" class="row fullWtHalfHt">
												   <div class="cell fullHtHalfWt">
												      <div class="pharContentKgLabel" style="padding-left:0px;">
												      <input type="text" class="k-textbox ivRxWithAddInfuseOverInput" style="height:43px;width:98%;" id ="duration_details" name="duration_details" id="duration_details" value="<%=durn_values%>" onblur="validateDuration()" maxlength="2"/>
													  </div>
												   </div>
												   <div class="cell detailsCell"> 
													  <div class="pharContentKgLabel" style="padding-left:0px;">
													   <select class="ivRxWithAddInfuseOverInput k-textbox" style="height:43px;width:99%;" id="durn_desc_crx" name="durn_desc_crx" id="durn_desc_crx">
	                                                   </select> 
													  
													  </div>
												    </div>
												  </div> 
												</div> 
											</div>
											</div>											
											<div style="display:flex;" class="paddingLeftRight10px">
											 <div class="ivrxContainer">
											   <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   Start date and time<font class="rxMandatorIndi">*</font>
												</div>
                                                <input style="width:99% ! important" class="dropDown" id="crxStartDate" value="" />
											  </div>								  
											  <div class="ivrxContainer">
											    <div class="IVrxLabel segoeuiBold paddingTopBottom">
												   End date and time<font class="rxMandatorIndi">*</font>
												</div>
												<input style="width:99% ! important" class="dropDown ivrxDosageByCss" id="crxEndDate" value="" disabled/>
											  </div>						
										    </div>
											<div class="interTextareaWrapper">
										       <div class="fullHtFullWt">
											      <div class="positionRelative" style="padding-left:10px;">
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 3px;">
														Build MAR
													</div>	
													<div class="interInputWrap">
														
														<input type="checkbox" name="buildMAR_yn" id="buildMAR_yn" style="height: 20px;width: 20px;" value="<%=buildMAR_yn%>" <%=buildMAR_ynCheck%> <%=buildMAR_ynEnable%> >
														
													</div> 		
												  </div>
										       </div>
											</div>
											<div class="interTextareaWrapper" >
										       <div class="fullHtFullWt">
											      <div class="positionRelative" style="padding-left:5px;">
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 4px;">
											           Admixture
											         </div>
											         <div class="interInputWrap" >
                                                       <input style="height: 20px;width: 20px;" name="Admixture" id="Admixture" type="checkbox" checked="yes" disabled="true"/>
                                                     </div> 
												  </div>
										       </div>
											</div>
	        </div>
	    </div>	
	</div>           
	<!-- Admin Details Tab Ends -->
    <!-- CRx details footer -->		
	<div style="height:40px;width:100%;position:absolute;bottom:0;" class="row" >	
					<div class="table" style="height:100%;width:100%">
								 <div  class="row pharmCartBottomContainer" style="height:1%;" data-role = "none">
			                         <div class="cell billingBottomBorder" style="background-color:#ffffff;" data-role = "none"></div>
			                     </div>
			                     <div  class="row pharmItemDescNameCell" style=" height: calc(100% - 94%);line-height: 35px;background-color:#ffffff;" data-role = "none">
			                          <div class="cell pharmRxOrderFooterCell"  data-role = "none">
											<div class="pharmRxOrderItemDesc">
			                                    <div class="pharmRxOrderItemLabelFooter">Dispense Location : </div>
												<div style="width: 2px;height:1px;" class="pharmRxOrderItemInfoFooter"></div>
			                                    <div class="pharmRxOrderItemInfoFooter segoeuiBold"><%=dflt_disp_locn%></div>
			                                 </div>
			                           </div>
									  <div class="cell pharmRxOrderFooterCell" id="total_ratio" style="display: none" data-role = "none">
									      <div class="pharmRxOrderItemDescFooter">
										    <div class="pharmRxOrderItemLabelFooter">Ratio:</div> 
			                                <div style="width: 2px;height:1px;" class="pharmRxOrderItemInfoFooter"></div>
											<div id="total_ratio_display" class="pharmRxOrderItemInfoFooter segoeuiBold">
											<%=total_ratio%>
											</div>
			                              </div>
									  </div> 
			                          <div class="cell pharmRxOrderFooter" id="total_qty" style="display: none" data-role = "none">
									      <div class="pharmRxOrderItemDescFooter">
			                                 <div class="pharmRxOrderItemLabelFooter">Total quantity:</div>
											 <div style="width:2px;height:1px" class="pharmRxOrderItemInfoFooter"></div>
			                                 <div id="total_qty_display" class="pharmRxOrderItemInfoFooter segoeuiBold">
											 <%=total_ratio_qty%>
											 </div>
										  </div>
			                          </div>
									  <div class="cell pharmRxOrderFooter" id="total_qty_percent" style="display: none" data-role = "none">
									      <div class="pharmRxOrderItemDescFooter">
			                                 <div class="pharmRxOrderItemLabelFooter">Total quantity:</div>
											 <div style="width:2px;height:1px" class="pharmRxOrderItemInfoFooter"></div>
			                                 <div id="total_qty_percent_display" class="pharmRxOrderItemInfoFooter segoeuiBold">
											 <%=total_percent_qty%>
											 </div>
										  </div>
			                          </div>
			           		     </div>
					</div>
				</div>
	<!-- CRx details footer ends -->	
    </div>	
	</div>						
	</div>
	</div>
	</div>
    </div> 	
        	<input type="hidden" value="<%=bean_id_CRX%>"			name="bean_id_CRX" id="bean_id_CRX"/>
		<input type="hidden" value="<%=DosageValue%>"			name="DosageValue" id="DosageValue"/>
		<input type="hidden" value="<%=DosageText%>"			name="DosageText" id="DosageText"/>
		
		<input type="hidden" value="<%=bean_name_CRX%>"        name="bean_name_CRX" id="bean_name_CRX"/>
		<input type="hidden" value="<%=start_date_fluid%>"     name="start_date_fluid" id="start_date_fluid" />
        <input type="hidden" value="<%=end_date_fluid%>"       name="end_date_fluid" id="end_date_fluid" />
		<input type="hidden" value="<%=END_DATES%>"            name="END_DATES" id="END_DATES" />
		<input type="hidden" value="<%=START_DATES%>"          name="START_DATES" id="START_DATES" />
		<input type="hidden" value="<%=durn_value%>"           name="durn_value" id="durn_value" />
		<input type="hidden" value=""                          name="calcualted_durn_value" id="calcualted_durn_value"		>
		<input type="hidden" value="<%=interval_value%>"       name="interval_value">
		<input type="hidden" value=""                          name="interval_value" id="interval_value">
		<input type="hidden" value="<%=freq_nature%>"          name="freq_nature"   id="freq_nature"/>
		<input type="hidden" value=""                          name="durn_type" id="durn_type" id="durn_type"/>
		<input type="hidden" value="<%=repeat_durn_type %>"    name="repeat_durn_type"/>
		<input type="hidden" value="<%=scheduled_yn%>"         name="scheduled_yn"	/>
		<input type="hidden" value="<%=drug_db_interface_yn%>" name="drug_db_interface_yn"/>
		<input type="hidden" value=""                          name="dosage_detail" id="dosage_detail" id="dosage_detail"/>
		<input type="hidden" value=""                          name="back_date" id="back_date" />
		<input type="hidden" value=""                          name="future_date" id="future_date"/>
		
		<input type="hidden" name="mode" id="mode"				value="new">
		<input type="hidden" name="patient_class" id="patient_class"		value="<%=patient_class%>">
		<input type="hidden" name="act_patient_class" id="act_patient_class"	value="<%=act_patient_class%>">
		<input type="hidden" name="patient_id" id="patient_id"			value="<%=patient_id%>"> 
		<input type="hidden" name="facility_id" id="facility_id"			value="<%=facility_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
		<input type="hidden" name="resp_id" id="resp_id"		        value="<%=resp_id%>">
		<input type="hidden" name="pract_id" id="pract_id"		    value="<%=pract_id%>">
		<input type="hidden" name="result_factor" id="result_factor"	id="result_factor"	    value="">
		<input type="hidden" name="prescribingBy" id="prescribingBy"		value="<%=PRES_BY_BASE %>">
		<input type="hidden" value="<%=allDrugs%>" name="allDrugs" id="allDrugs"/>
		<input type="hidden" value="<%=allDrugs_count%>" name="allDrugs_count" id="allDrugs_count"/>
		<input type="hidden" name="current_freq_code" id="current_freq_code"	  id="current_freq_code"	    value="<%=freq_codes%>">
		<input type="hidden" name="current_dosage_uom" id="current_dosage_uom"	  id="current_dosage_uom"    value="<%=dosage_UOM%>">
		
		<input type="hidden" name="current_drun_code" id="current_drun_code"	  id="current_drun_code"	    value="<%=durn_type%>">
		<input type="hidden" name="current_start" id="current_start"	  id="current_start"	    value="<%=start%>">
		<input type="hidden" name="current_end" id="current_end"	  id="current_end"	    value="<%=end%>">
		
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

