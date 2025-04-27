<!DOCTYPE html>
 <!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
10/08/2023		TFS-48847		Sushant Tambe	GHL-CRF-0669
---------------------------------------------------------------------------------------------------------------
*/ --> 
 <%-- JSP Page specific attributes start --%>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script type="text/javascript"src="../../eCommon/js/CommonCalendar.js"></script>	
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<Script>
	async function printOfFn(patient_id,patient_class)
	{
		await callMedplanCheck(document.DispMedicationPrintDialog,patient_id,patient_class);
		await printOnlineDispense(document.DispMedicationPrintDialog,'OK');
		window.returnValue='OK';
		
	}
	</Script>
	</HEAD>
	<body onMouseDown="" onKeyDown="lockKey()">
<%
       Connection con			= null; 
		try{
		   String called_from			= request.getParameter("called_from");
		   String sShowButtons			= request.getParameter("buttons")==null?"":" style='display:none' ";
		   String dispSeqNo				= "";//added for MMS-QH-CRF-0201 [IN:052255] 
		  //ADDED FOR ML-MMOH-CRF-1089 START

				   con				= ConnectionManager.getConnection(request);
				   boolean site=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STD_REGIMEN_LABEL");//added for ML-MMOH-CRF-1089
				  //ADDED FOR ML-MMOH-CRF-1089  END

			boolean refill_site=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REFILL_LABEL");//added for MOHE-CRF-0069
			boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");// MOHE-CRF-0074-Start
       if(called_from.equals("IPGenFill")){ 
%>
				<form name="IPGenFillPrintDialog" id="IPGenFillPrintDialog">
					<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
						<tr>
							<td class="COLUMNHEADER" colspan='2' > <fmt:message key="Common.reportname.label" bundle="${common_labels}"/> </td>
						</tr>
						<tr>
							<td><fmt:message key="ePH.NonAllocatedDrugs.label" bundle="${ph_labels}"/> </td>
							<td  class="label"><input type="checkbox" name="Callocated_drug" id="Callocated_drug" ></td>
						</tr>
						<tr>
							<td> <fmt:message key="ePH.NonAllocatedDrugs.label" bundle="${ph_labels}"/> </td>
							<td  class="label"><input type="checkbox" name="CnonAllocated_drug" id="CnonAllocated_drug" ></td>
						</tr>
						<tr>
							<td class="white" colspan=2 > &nbsp; </td>
						</tr>
						<tr>
							<td  colspan='2' class="white"  align='right'><input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="">&nbsp;<input  type="button" class="button" value='<fmt:message key="Common.cancel.label"  bundle="${common_labels}"/>' onClick="parent.window.close()"></td>
						</tr>
					</table>
				</form>
 <% 
			}
			else if (called_from.equals("DispMedication")){
%>
				<form name="DispMedicationPrintDialog" id="DispMedicationPrintDialog">
<%
					String	bean_id			=	"DispMedicationBean" ;
					String	bean_name		=	"ePH.DispMedicationBean";
					DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);
					String	bean_id_2		=	"DispMedicationAllStages" ;
					String	bean_name_2		=	"ePH.DispMedicationAllStages";
					DispMedicationAllStages bean_2	= (DispMedicationAllStages)getBeanObject( bean_id_2, bean_name_2, request);
					MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); // Added for Bru-HIMS-CRF-072.1[IN 049144]
					String allow_edit_disp_label = bean.getAllowEditDispLabel(); //added for Bru-HIMS-CRF-414 [IN:045554]
					String params = request.getQueryString() ; //added for Bru-HIMS-CRF-414 [IN:045554]
					String disp_no					= request.getParameter("disp_no");
					String login_user				= request.getParameter("login_user");
					String facility_id				= request.getParameter("facility_id");
					String patient_id				= request.getParameter("patient_id");
					String locn_code				= request.getParameter("locn_code");
					String disp_locn				= request.getParameter("disp_locn");
					String patient_class			= request.getParameter("patient_class");
					String order_type				= request.getParameter("order_type");
					if(order_type.equals("")){
						order_type	=	bean.getOrderType();
					}
					String curr_stage				= request.getParameter("curr_stage");
					String complete_order_flag		= request.getParameter("complete_order_flag");
					ArrayList langIdName            =	new ArrayList();//Code Added For
					String localLang                ="";
					ArrayList disp_locns            =	new ArrayList();
					String dis_loc_code				=	bean.getDispLocnCode();
					String nextBmsDispLocn			= 	bean_2.getDefaultBmsDispLoc();// Added for HSA-CRF-0113 [IN:048166] 
					String visible1					=	"";
					ArrayList facilitys				=	null;
					ArrayList e_facilitys           =   null;
					HashMap facility				=   null;
					HashMap e_facility				=	null;
					String SQL_PH_DISP_PRACT_REFERRAL_SELECT  = PhRepository.getPhKeyValue("SQL_PH_DISP_PRACT_REFERRAL_SELECT");	
					String othr_facty_sql					  = PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT110A");
                        //added for Bru_HIMS-CRF-142(30195)  Start
					ArrayList storage_locns = (ArrayList)bean_2.getStrNamesDispLocn(dis_loc_code);
					String storage_location_code = (String)bean_2.getStorageLocation(dis_loc_code,bean.getTokenSeriesCode(),patient_id);
					ArrayList disp_nos1 		=bean_2.getDispNos();
					String disp_fm_no         = "";//KDAH-CRF-0476
					String disp_to_no         = "";//KDAH-CRF-0476
					String disp_no1="";
					bean_2.setDispTranSeqNo(bean.getPrintSeqNo());//added for MMS-QH-CRF-0201 [IN:052255]
					for(int i=0;i<disp_nos1.size();i++){
                            disp_no1 =(String)disp_nos1.get(i);
					}
					if(disp_nos1!=null && disp_nos1.size()>0){//KDAH-CRF-0476
						disp_fm_no = (String)disp_nos1.get(0);
						disp_to_no = (String)disp_nos1.get((disp_nos1.size())-1);
					}
					String Orderresult_id = bean_2.getOrderId(disp_no1,curr_stage);
					String token_series=bean.getTokenSeriesCode();
					String token_no ="";  //added for Bru_HIMS-CRF-142(30195)  end
					HashMap hmAllocBmsCheck			= bean.getHmAllocBmsChk();
					ArrayList alEditLabelPairValues	= bean_2.getAlEditLabelPairValues();
					boolean bAllowPrint				= true;
					String defPrintStatusLS="", defPrintStatusPT="";		
					
					String order_facility_id= "" , order_facility_name= ""; //Added for MOHE-CRF-0074
					String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
					ArrayList region_code_check = bean.getRegionCheck(login_user,region_code); //Added for MOHE-CRF-0074
					if(alEditLabelPairValues != null && hmAllocBmsCheck != null){
						if(hmAllocBmsCheck.size() == alEditLabelPairValues.size() ){
							bAllowPrint				= false;
						}
				   }
					if(patient_class.trim().equals("O")){
						patient_class	=	"OP";
						visible1="visibility:visible";
					}
					else if(patient_class.trim().equals("I")){
						patient_class	=	"IP";
						visible1="visibility:visible";
					}

					HashMap  hmPrintOptions			= bean_2.getPrintOptions(patient_class);
					boolean  bTokenYN				= bean_2.checkTokenSeries(bean.getDispLocnCode().trim());	
					boolean lPrintReport			=  false; //added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
					int repCount=0;//added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
					String sDrugLabelStatus			=	"hide";
					String sBalSheetDefaultCheck	=	"hide";
					String sMedicationPlanSheet		=   "hide";//Added sMedicationPlanSheet  For ML-BRU-CRF-072[Inc:29938]
					String sCertificateReim			=	"hide";
					String sDispenseSheet			=	"hide";
					String sMedicalSupplyLabel		=	"hide";
					String sMedicationList			=	"hide";
					String sRefillMediationSheet	=	"hide";
					String sToken					=	"hide";
					String sFillListDrugMedical		=	"hide";
					String sFillListPatient			=	"hide";
					String sOrderId					=	"";
					String order_line_no			=	"";
					String visible					=	"";
					String srl_no					=	"";
					String sEnableTab				=   "N";
					String sEnableBMSFields			=   "disabled";
					String cuu_facility_chk			=   "checked";
					String sHomeMdnInclude			=	"checked";
					HashMap	med_ind					=	new HashMap();
					HashMap print_option			=	new HashMap();
					//String sDfltLangForDispLblBmsLbl="E";		//newly added for CRF-074 by manickam
					String sDfltLangForDispLabel	= bean.getDefaultLanguageForDispenseLabel(patient_id);
					String sDefaultEnglish			="selected",sDefaultLocLang="";
					String strIncludeZeroQty    = bean.getStrIncludeZeroAllocQtyItems();//Added for ML-BRU-CRF-0473
			        String strIncludeZeroQtyForIP    = bean.getStrIncludeZeroAllocQtyItemsForIP();//Added for ML-BRU-CRF-0473
					ArrayList alBMSOrderIds = bean.getAlBMSOrderIds();
					if(alBMSOrderIds ==null)
						alBMSOrderIds = new ArrayList();
					int iRowCount = 0;					
					int  hmAllocBmsCheckSize =  hmAllocBmsCheck.size() ;  //add this variable for KAUH-SCF-001	
					String sWorkSheet				=	"hide";//added for ML-MMOH-CRF-1089
					String sMFGLabel				=	"hide";//added for ML-MMOH-CRF-1089
					String sLipidLabel				=	"hide";//Added for ML-MMOH-CRF-1089
					String sTPNCoverBag				=	"hide";//Added for ML-MMOH-CRF-1089
					String sRFLabel                 =   "hide";//Added for MOHE-CRF-0069
					int refill_count                = 0;//Added for MOHE-CRF-0069
					String sRFChecked               =    "";//Added for IN19791
					String refill_order ="";
					if( curr_stage.equals("D") || curr_stage.equals("AS") )  //add this condition for KAUH-SCF-001
						hmAllocBmsCheckSize = 1 ;
					//if(hmPrintOptions.size()>0 && bAllowPrint ){
					if((hmPrintOptions.size()>0 && bAllowPrint) || hmAllocBmsCheckSize >0){  // add hmAllocBmsCheck.size() >0 changed to hmAllocBmsCheckSize>0 for KAUH-SCF-001
						HashMap result	=	new HashMap();

						if(curr_stage.equals("D")){
							result = (HashMap)bean.getDEL_IR_FLAG_VALUE();
						}
						else if(curr_stage.equals("AS")){
							result = (HashMap)bean_2.getIR_FLAG_VALUE();
						}

						if(result.size() > 0){
							if(curr_stage.equals("D")){
								ArrayList order_details =(ArrayList)result.get("ORDER_DETAILS");
								if(order_details.size()>0){									
									sEnableTab		 = "Y";
								}
							}
							//enable_nextcollection    = "visibility:visible";
							visible					 = "true";

							if(result.containsKey("order_id"))
								sOrderId			= (String)result.get("order_id");

							if(result.containsKey("order_line_no"))
								order_line_no			= (String)result.get("order_line_no");

							if(result.get("disp_no")!=null && !((String)result.get("disp_no")).equals("") ) {
								disp_no				= (String)result.get("disp_no");
							}
								
							if(result.containsKey("srl_no"))
								srl_no				= (String)result.get("srl_no");
						}
						else{					
						//	enable_nextcollection	 = "display:none";
							visible					 = "false";
						}

						if(hmPrintOptions.get("DRUG_LABEL")!=null && hmPrintOptions.get("DRUG_LABEL").toString().equals("PD")){
							 if(hmAllocBmsCheck.size() == alEditLabelPairValues.size()  && strIncludeZeroQty.equals("Y") && patient_class.equals("OP")){
								sDrugLabelStatus	="checked";
							}
							else if(hmAllocBmsCheck.size() == alEditLabelPairValues.size() ) //if block and else added for KAUH-SCF-001  
								sDrugLabelStatus = "hide";  
							else
								sDrugLabelStatus	="checked";
						 
							if(patient_class.equals("IP") && strIncludeZeroQtyForIP.equals("Y")){ // Added for ML-BRU-SCF-1869 - Start
                                sDrugLabelStatus	="checked";
						    } // Added for ML-BRU-SCF-1869 - End						    
						}
						else if(hmPrintOptions.get("DRUG_LABEL")!=null && hmPrintOptions.get("DRUG_LABEL").toString().equals("PT"))
							sDrugLabelStatus	="";
						/* if(patient_class.equals("IP") && strIncludeZeroQtyForIP.equals("Y")){//Adding start for ML-BRU-CRF-0473
                                 sDrugLabelStatus	="checked";
						}//Adding end for ML-BRU-CRF-0473 */ // Commented for ML-BRU-SCF-1869

						if(hmPrintOptions.get("BMS_SHEET")!=null && hmPrintOptions.get("BMS_SHEET").toString().equals("PD")){
							sBalSheetDefaultCheck = "checked";

						}
						else if(hmPrintOptions.get("BMS_SHEET")!=null && hmPrintOptions.get("BMS_SHEET").toString().equals("PT")){
						   sBalSheetDefaultCheck = "";
						}

						if(hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT")!=null && hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT").toString().equals("PD"))
						   sCertificateReim	="checked";
						else if(hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT")!=null && hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT").toString().equals("PT"))
							sCertificateReim	="";

						if(hmPrintOptions.get("DISPENSE_SHEET")!=null && hmPrintOptions.get("DISPENSE_SHEET").toString().equals("PD"))
						   sDispenseSheet	="checked";
						else if(hmPrintOptions.get("DISPENSE_SHEET")!=null && hmPrintOptions.get("DISPENSE_SHEET").toString().equals("PT"))
							sDispenseSheet	="";

						if(hmPrintOptions.get("FILL_LIST_DRUGMEDICAL")!=null && hmPrintOptions.get("FILL_LIST_DRUGMEDICAL").toString().equals("PD"))
						   sFillListDrugMedical	="checked";
						else if(hmPrintOptions.get("FILL_LIST_DRUGMEDICAL")!=null && hmPrintOptions.get("FILL_LIST_DRUGMEDICAL").toString().equals("PT"))
							sFillListDrugMedical	="";

						if(hmPrintOptions.get("FILL_LIST_PATIENT")!=null && hmPrintOptions.get("FILL_LIST_PATIENT").toString().equals("PD"))
						   sFillListPatient	="checked";
						else if(hmPrintOptions.get("FILL_LIST_PATIENT")!=null && hmPrintOptions.get("FILL_LIST_PATIENT").toString().equals("PT"))
							sFillListPatient	="";

						if(hmPrintOptions.get("MEDICAL_SUPPLY_LABEL")!=null && hmPrintOptions.get("MEDICAL_SUPPLY_LABEL").toString().equals("PD"))
						   sMedicalSupplyLabel	="checked";
						else if(hmPrintOptions.get("MEDICAL_SUPPLY_LABEL")!=null && hmPrintOptions.get("MEDICAL_SUPPLY_LABEL").toString().equals("PT"))
							sMedicalSupplyLabel	="";

						if(hmPrintOptions.get("MEDICATION_LIST")!=null && hmPrintOptions.get("MEDICATION_LIST").toString().equals("PD"))
						   sMedicationList	="checked";
						else if(hmPrintOptions.get("MEDICATION_LIST")!=null && hmPrintOptions.get("MEDICATION_LIST").toString().equals("PT"))
							sMedicationList	="";

						if(hmPrintOptions.get("REFILL_MEDICATION_SHEET")!=null && hmPrintOptions.get("REFILL_MEDICATION_SHEET").toString().equals("PD"))
						   sRefillMediationSheet	="checked";
						else if(hmPrintOptions.get("REFILL_MEDICATION_SHEET")!=null && hmPrintOptions.get("REFILL_MEDICATION_SHEET").toString().equals("PT"))
							sRefillMediationSheet	="";
						//Added sMedicationPlanSheet  For ML-BRU-CRF-072[Inc:29938] start
						if(hmPrintOptions.get("PHPRMEDPL")!=null && hmPrintOptions.get("PHPRMEDPL").toString().equals("PD"))
						   sMedicationPlanSheet	="checked";
						else if(hmPrintOptions.get("PHPRMEDPL")!=null && hmPrintOptions.get("PHPRMEDPL").toString().equals("PT"))
							sMedicationPlanSheet	="";
						//Added sMedicationPlanSheet  For ML-BRU-CRF-072[Inc:29938] end
						if(hmPrintOptions.get("HOME_MDN_INCLUDE")!=null && hmPrintOptions.get("HOME_MDN_INCLUDE").toString().equals("PD"))//Added for RUT-CRF-0061
							sHomeMdnInclude	="checked";
						else if(hmPrintOptions.get("HOME_MDN_INCLUDE")!=null && hmPrintOptions.get("HOME_MDN_INCLUDE").toString().equals("PT"))
							sHomeMdnInclude	="";
						//ADDED FOR ML-MMOH-CRF-1089 START
						if(hmPrintOptions.get("MANUFACTURING_LABEL")!=null && hmPrintOptions.get("MANUFACTURING_LABEL").toString().equals("PD"))
							   sMFGLabel	="checked";
							else if(hmPrintOptions.get("MANUFACTURING_LABEL")!=null && hmPrintOptions.get("MANUFACTURING_LABEL").toString().equals("PT"))
								sMFGLabel	="";
					      if(hmPrintOptions.get("WORK_SHEET")!=null && hmPrintOptions.get("WORK_SHEET").toString().equals("PD"))
							   sWorkSheet	="checked";
							else if(hmPrintOptions.get("WORK_SHEET")!=null && hmPrintOptions.get("WORK_SHEET").toString().equals("PT"))
								sWorkSheet	="";
					//ADDED FOR ML-MMOH-CRF-1089 END
						
						if(bTokenYN){
							if(hmPrintOptions.get("TOKEN")!=null && hmPrintOptions.get("TOKEN").toString().equals("PD"))
								sToken	="checked";
							else if(hmPrintOptions.get("TOKEN")!=null && hmPrintOptions.get("TOKEN").toString().equals("PT"))
								sToken	="";
						}

                      //Adding start for MOHE-CRF-0069
						if(hmPrintOptions.get("REFILL_MEDICATION_LABEL")!=null && hmPrintOptions.get("REFILL_MEDICATION_LABEL").toString().equals("PD"))
							   sRFChecked	="checked"; //changed sRFLabel to SRFChecked for IN19791
							else if(hmPrintOptions.get("REFILL_MEDICATION_LABEL")!=null && hmPrintOptions.get("REFILL_MEDICATION_LABEL").toString().equals("PT"))
								sRFChecked	=""; //changed sRFLabel to SRFChecked for IN19791
			         if(refill_site){//!sRFLabel.equals("hide") && removed for IN19791
							System.err.println("facility_id @@@==="+facility_id+"disp_no==="+disp_no);
							bean_2 .getRefillOrder(facility_id); 
                          				  refill_order = bean_2.getRefillOrderStr();
							//System.err.println("refill_order@@@==="+refill_order);
							if(!refill_order.equals(""))
								sRFLabel ="";
							else
								sRFLabel ="hide";
						}
							
                      //Adding end for MOHE-CRF-0069


						if(result.get("IR_FLAG_VALUE")!=null &&  ((String)(result.get("IR_FLAG_VALUE"))).equals("TRUE"))
							sEnableTab			= "Y";
						if((bean.getDispStage().equals("F") ||  bean.getDispStage().equals("A") || bean.getDispStage().equals("AS")) && alBMSOrderIds.size()>0 && patient_class.equals("OP")){	//"AS"	Added for MO-GN-5434 [IN:043669]
							sEnableTab			= "Y";
							visible				= "true";
						}
						if(sDfltLangForDispLabel.equals("L")){
							sDefaultEnglish		=	"";
							sDefaultLocLang		=	"selected";
							//sDfltLangForDispLblBmsLbl = "L"; // newly added for CRF-074 by manickam
						} 
						else if(sDfltLangForDispLabel.equals("B")){
							sDefaultEnglish		=	"";
							sDefaultLocLang		=	"";
						}
						if(sDrugLabelStatus.equals("hide")){	
							sDefaultEnglish		=	"";
							sDefaultLocLang		=	"";
						}	

						String next_appt_days	     = "";
						String sysdate               = bean.getTodaysDate();
						String getDate_plus_365	     = bean.getDate_plus_365();	
						String strNextCollectionDate = null;
						String strBMSReasonCode = "";
						ArrayList alBMSReasons = bean_2.getBMSReasons(locale);
						String bmsReasonVisible = "hidden";
						if(!allow_edit_disp_label.equals("Y"))//added for Bru-HIMS-CRF-414 [IN:045554]
							langIdName = bean_2.getDefLangForLabel(patient_class); //Added for MMS-QH-CRF-0069 [IN:037977]
						if(langIdName==null || langIdName.size()==0 ){ //if condition & else block added for MMS-QH-CRF-0069 [IN:037977]
							if(!locale.equals("en") ){// Override For ICN-32706  Start
								langIdName = bean_2.getLangNameAndId(locale);
								sDefaultEnglish		=	"";
								sDefaultLocLang		=	"selected";
							}
							else{
								langIdName = bean_2.getLangNameAndId(bean_2.getSMLOcalLanguageID());
							}// Override For ICN-32706  End
						}
						else { //if condition & else block added for MMS-QH-CRF-0069 [IN:037977]
							if(((String)langIdName.get(0)).equals("en")){
								langIdName = bean_2.getLangNameAndId(bean_2.getSMLOcalLanguageID());
								sDefaultEnglish		=	"selected";
								sDefaultLocLang		=	"";
							}
							else{
								sDefaultEnglish		=	"";
								sDefaultLocLang		=	"selected";
							}
						}

						if(patient_class.equals("OP")){							
							/*if(complete_order_flag.equals("Y"))
								enable_nextcollection    = "visibility:visible";
							else
								enable_nextcollection    = enable_nextcollection;*/								     
						   disp_locns  = bean_2.getDispenseLocns();
						   if(curr_stage.equals("D") || curr_stage.equals("AS")){
							   sEnableBMSFields = "";
						   }
							next_appt_days  =bean.CheckForAppointments(patient_id);
								
							// For Next collection date calculation ---- start ---- 
							ArrayList disp_nos 		=	bean_2.getDispNos();
							//		strNextCollectionDate = bean.getNextCollectionDate(sOrderId);
							ArrayList alBMSdtl =null;
							if(sOrderId !=null && !sOrderId.equals(""))
								alBMSdtl= bean.getNextCollectionDate(sOrderId);
							else if(alBMSOrderIds.size()>0)
								alBMSdtl= bean.getNextCollectionDate((String)(((ArrayList)alBMSOrderIds.get(0)).get(0)));
							if(alBMSdtl!=null && alBMSdtl.size()>0){
								strNextCollectionDate = (String)alBMSdtl.get(0);
								strBMSReasonCode = (String)alBMSdtl.get(1)==null?"":(String)alBMSdtl.get(1);
							}
							//Code Added For ML-BRU-SCF-0109 Start
							/*
							int dayOfWeek = com.ehis.util.DateUtils.getDayOfWeek(strNextCollectionDate,"DMY",locale);
							if(dayOfWeek == 0 || dayOfWeek == 5){
								strNextCollectionDate =com.ehis.util.DateUtils.minusDate(strNextCollectionDate,"DMY",locale,1,"d");
							}
							*/ //Commented b'z this SCF need a CRF.
							//Code Added For ML-BRU-SCF-0109 End	
							strNextCollectionDate = com.ehis.util.DateUtils.convertDate(strNextCollectionDate,"DMY","en",locale);
							// For Next collection date calculation ---- end ---- 
							// Code Override For FD-Bru-HIMS-CRF-074 

%>
							<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="tab" overflow="auto">
								<tr>

										<td name="printReport" id="printReport" width="10%"class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);"  onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS');calltable('print_report');checkBMSTab('print_report');" nowrap style='display:inline;'><a class="MENUHIGHERLEVELLINK" style="color:white" name="print_report"><fmt:message key="ePH.PrintReports.label" bundle="${ph_labels}"/></a></td><!-- Code Modified For Bru-HIMS-CRF-075  --><!-- added name and id For MO-GN-5434 (BMS in print dailog when allocate qty is zero)   -->

<%
									if(sEnableTab.equals("Y")){
%>
										<td id="enableTab" width="10%" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS');calltable('bal_med_dtl');checkBMSTab('bal_med_dtl');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" name="bal_med_dtl" ><fmt:message key="ePH.BalanceMedicationDetail.label" bundle="${ph_labels}"/></a></td><!-- Code Modified For Bru-HIMS-CRF-075 -->
<%
									}
									else{
%>
										<td  width="10%">&nbsp;</td>
<%
									}
%>
								</tr>
							</table>
<%
						}
%>
						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id ="print_report_table"style="<%=visible1%>">
							<TR>
								<td colspan="3" height="5"></td>
							</TR>
<% 
      //ADDED FOR ML-MMOH-CRF-1089 START
									if(site && order_type.equals("TD")){
									 sDispenseSheet="hide";
									 sDrugLabelStatus="hide";
									 sLipidLabel				=	"checked";
									 sTPNCoverBag				=	"checked";
									 iRowCount++;
									 
								%>
							
								<tr>
										<td class="label" width='20%'> <fmt:message key="ePH.LIPIDLABEL.label" bundle="${ph_labels}"/>  </td>
			<td  class="label" width='20%' ><input type="checkbox" name="lipid_label" id="lipid_label" value ="Y"<%=sLipidLabel%>></td>
			<td class="label" width='20%'> <fmt:message key="ePH.TPNCOVERBAG.label" bundle="${ph_labels}"/> </td>
			<td class="label" width='20%'><input type="checkbox" name="cover_bag" id="cover_bag" value="Y"<%=sTPNCoverBag%>></td>
		</tr>
		
		<tr>
			<td class="label" width='20%'> <fmt:message key="Common.PrintWorksheet.label" bundle="${common_labels}"/> 
			<td  class="label" width='20%'><input type="checkbox" name="workSheet" id="workSheet" value="Y" <%=sWorkSheet%> ></td>	
		
		
		<td class="label" width='20%'> <fmt:message key="ePH.ManufacturingLabel.label" bundle="${ph_labels}"/> </td>
			<td class="label" width='20%'><input type="checkbox" name="MFGLabel" id="MFGLabel" value="Y" <%=sMFGLabel%> ></td>
			</tr>
								<%
								
								}
							//ADDED FOR ML-MMOH-CRF-1089 end
							if(!sDispenseSheet.equals("hide")){
								iRowCount++;
%>
								<tr>
									<td class="label" width='50%'> <fmt:message key="ePH.DispensingSheet.label" bundle="${ph_labels}"/> </td>
									<td class="label" width='50%'colspan="2"><input type="checkbox" name="disp_sheet" id="disp_sheet" <%=sDispenseSheet%>></td>
								</tr>
<%
							}
							if(!sDrugLabelStatus.equals("hide")){
								iRowCount++;
%>
								<tr>
									<td class="label"><fmt:message key="ePH.DispenseLabel.label" bundle="${ph_labels}"/> </td>
									<td class="label" width='5%'><input type="checkbox" name="disp_label" id="disp_label" <%=sDrugLabelStatus%> ></td>
									<td class="label" width='45%'>&nbsp;
										<select name="printDialogLang" id="printDialogLang" onChange='setlabelLangId(this, "PRINT")'><!--Code Added For FD-Bru-HIMS-CRF-074 Start -->
										<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
										<option value="en" <%=sDefaultEnglish%>> <fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
<%
										if(langIdName!=null && langIdName.size()>0 && !((String)langIdName.get(0)).equals("en")){
											localLang = langIdName.get(1)==null?"":(String)langIdName.get(1);
%>
											<option value="<%=langIdName.get(0)%>" <%=sDefaultLocLang%>> <%=localLang%></option>
<%
										}
										else{
%>
											<input type='hidden' name="printDialogLang" id="printDialogLang" value='en'>
<%
										}
%>
							    	 <!-- <option value="B" > Both</option> -->
									</select><!--Code Added For FD-Bru-HIMS-CRF-074 End -->
									</td>
								</tr>
<% 
							}//Added sMedicationPlanSheet  For ML-BRU-CRF-072[Inc:29938] start
							else{ //else block added for RUT-SCF-0162 [IN:033601]
%>
								<input type='hidden' name="printDialogLang" id="printDialogLang" value='en'>
<%
							}
							if(!sMedicationPlanSheet.equals("hide")){
								iRowCount++;
								String strMediPlanSeqNo = "";
								ArrayList arrList = (ArrayList)medplan_bean.getMediPlanSeqNo();
								if(arrList!=null && arrList.size()==1)
									strMediPlanSeqNo = (String)arrList.get(0);
%>
								<tr>
									<td class="label"><fmt:message key="ePH.MedicationPlanSheet.label" bundle="${ph_labels}"/> </td>
									<td class="label"><input type="checkbox" name="med_plan" id="med_plan" <%=sMedicationPlanSheet%> ></td>
									<td class="label"><label style="cursor:pointer;color:blue" onClick="callMedicationPlanner('<%=patient_id%>','','Y','<%=strMediPlanSeqNo%>');"><fmt:message key="ePH.MedicationPlanner.label" bundle="${ph_labels}"/></label></td><!-- Added for Bru-HIMS-CRF-072.1[IN 049144] -->
								</tr>

<%							}//Added sMedicationPlanSheet  For ML-BRU-CRF-072[Inc:29938] end
							if(!sCertificateReim.equals("hide")){
								iRowCount++;
%>
								<tr>
									<td class="label"> <fmt:message key="ePH.CERTIFICATE_REIMBURSEMENT.label" bundle="${ph_labels}"/> </td>
									<td class="label" colspan="2"><input type="checkbox" name="certiReimbur" id="certiReimbur" <%=sCertificateReim%>></td>
								</tr>
<%
							}
							if(!sFillListDrugMedical.equals("hide") && (bean.getFillList().trim().equals("WF") || bean.getFillList().trim().equals("AF"))){
								iRowCount++;
%>
								<tr>
									<td class="label"> <fmt:message key="ePH.FILL_LIST_DRUGMEDICAL.label" bundle="${ph_labels}"/> </td>
									<td class="label" colspan="2"><input type="checkbox" name="fillListDrugMedical" id="fillListDrugMedical" <%=sFillListDrugMedical%>></td>
								</tr>
<%
							}
							if(!sFillListPatient.equals("hide") && bean.getFillList().trim().equals("AF")){
								iRowCount++;
%>
								<tr>
									<td class="label"> <fmt:message key="ePH.FILL_LIST_PATIENT" bundle="${ph_labels}"/> </td>
									<td class="label" colspan="2"><input type="checkbox" name="fillListPatient" id="fillListPatient" <%=sFillListPatient%>></td>
								</tr>
<%
							}
							if(!sMedicalSupplyLabel.equals("hide") && bean.getBConsuableItemAvailable()){
								iRowCount++;
%>
								<tr>
									<td class="label"> <fmt:message key="ePH.MEDICAL_SUPPLY_LABEL.label" bundle="${ph_labels}"/> </td>
									<td class="label" colspan="2"><input type="checkbox" name="medicalSupplyLabel" id="medicalSupplyLabel" <%=sMedicalSupplyLabel%>></td>
								</tr>
<%
							}
							if(!sMedicationList.equals("hide")){
								iRowCount++;
%>
								<tr>
									<td class="label"> <fmt:message key="ePH.MEDICATION_LIST.label" bundle="${ph_labels}"/> </td>
									<td class="label" colspan="2"><input type="checkbox" name="medicationList" id="medicationList" <%=sMedicationList%>></td>
								</tr>
<%
							}
							if(!sToken.equals("hide")){
								iRowCount++;
%>
								<tr>
									<td class="label"> <fmt:message key="ePH.Token.label" bundle="${ph_labels}"/> </td>
									<td class="label" colspan="2"><input type="checkbox" name="token" id="token" <%=sToken%>></td>
								</tr>
<%
							}

							if(!sRefillMediationSheet.equals("hide") && bean_2.getRefillOrderYN(curr_stage, bean.getPrintSeqNo())){ //getRefillOrderYN added for  RUT-SCF-0295 [IN:043115]
								iRowCount++;
%>
								<tr>
									<td class="label"> <fmt:message key="ePH.RefillMedicationSheet.label" bundle="${ph_labels}"/> </td>
									<td class="label" colspan="2"><input type="checkbox" name="refillMediationSheet" id="refillMediationSheet" <%=sRefillMediationSheet%>></td>
								</tr>
<%
							}
					//ADDED FOR ML-MMOH-CRF-1089 end
							if(!sRFLabel.equals("hide") && refill_site){//Adding start for MOHE-CRF-0069
								iRowCount++;
%>
								<tr>
									<td class="label" width='50%'> <fmt:message key="ePH.RefillMedicationLabel.label" bundle="${ph_labels}"/> </td>
									<td class="label" width='50%'colspan="2"><input type="checkbox" name="refill_label" id="refill_label" <%=sRFChecked%>></td><!-- changed sRFLabel to SRFChecked for IN19791-->
								</tr>
<%
							}//Adding end for MOHE-CRF-0069
							if((storage_locns!= null && storage_locns.size()>0) && (curr_stage.equals("A") || curr_stage.equals("F"))){ //added for Bru_HIMS-CRF-142(30195)  Start
%>
								<TR>
									<td class="label" align='right'><fmt:message key="ePH.DeliveryBin.label" bundle="${ph_labels}"/> </td>
									<td class="label" align="right">
										<select name="storage_locn" id="storage_locn">
											<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>   
<%
											if(storage_locns!= null && storage_locns.size()>0){	
												for(int i=0;i<storage_locns.size();i=i+2){
													if(storage_location_code.equals((String)storage_locns.get(i))){
%>
														<option value="<%=storage_locns.get(i)%>" selected><%=storage_locns.get(i+1)%></option>	
<%				
													}
													else{
%>
														<option value="<%=storage_locns.get(i)%>"><%=storage_locns.get(i+1)%></option>
<%					
													}
												}
											}
%>
										</select>
									</td>
									<td>&nbsp;&nbsp;<td>
								</TR>
<%   
							}
							else{
%>
								<TR>
									<td  class="label" colspan="3" height="20">&nbsp;&nbsp;<input type="hidden" name="storage_locn" id="storage_locn" value=""><td>
								</TR>
<%         
							} //added for Bru_HIMS-CRF-142(30195) End
							med_ind=bean_2.getHomeMdnChk(patient_class,dis_loc_code,curr_stage, bean.getPrintSeqNo()); //Added for RUT-CRF-0061 [IN:029599] - start
							if(med_ind.size()>0){
								print_option  = (HashMap)med_ind.get("REPORT_OPTION");
								String defPrintOption = "", defPrintStatus="",  defTapPrintStatus="";
								boolean blOrientDisplay = false; 
								if(print_option.containsKey("HOME_MED_SHEET_TAPER")){
									if(((String)print_option.get("HOME_MED_SHEET_PORTRAIT")).equals("PD")){
										defTapPrintStatus = "checked";
									}
								}
								defPrintStatusLS = print_option.get("HOME_MED_SHEET_LANDSCAPE")==null?"":(String)print_option.get("HOME_MED_SHEET_LANDSCAPE");
								defPrintStatusPT = print_option.get("HOME_MED_SHEET_PORTRAIT")==null?"":(String)print_option.get("HOME_MED_SHEET_PORTRAIT");
								if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT") && print_option.containsKey("HOME_MED_SHEET_LANDSCAPE")){
									if(((String)print_option.get("HOME_MED_SHEET_PORTRAIT")).equals("PD") && ((String)print_option.get("HOME_MED_SHEET_LANDSCAPE")).equals("PD"))
									defPrintOption = "B";
									defPrintStatus = "checked";
								}
								else if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT") && ((String)print_option.get("HOME_MED_SHEET_PORTRAIT")).equals("PD")){
									defPrintOption = "P";
									defPrintStatus = "checked";
								}
								else if(print_option.containsKey("HOME_MED_SHEET_LANDSCAPE") && ((String)print_option.get("HOME_MED_SHEET_LANDSCAPE")).equals("PD")){
									defPrintOption = "L";
									defPrintStatus = "checked";
								}
								else if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT")){
									defPrintOption = "P";
									defPrintStatus = "";
								}
								else if(print_option.containsKey("HOME_MED_SHEET_LANDSCAPE")){
									defPrintOption = "L";
									defPrintStatus = "";
								}
								if(med_ind.containsKey("Include")){	
									blOrientDisplay = true;
									iRowCount++;
%>
									<tr>
										<td class="label"> <fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;(<fmt:message key="ePH.IncludeEyePreparation.label" bundle="${ph_labels}"/>) </td>
										<td class="label" ><input type="checkbox" name="medn_include" id="medn_include" <%=defPrintStatus %>></td>
										<td  class="label"><fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.Orientation.label" bundle="${ph_labels}"/> 
										<select name="homeMedOrientation" id="homeMedOrientation" onchange='changeOrientation(this);'>
<% 
										if(print_option.containsKey("HOME_MED_SHEET_LANDSCAPE")){
%>	
											<option value="L" <%=defPrintOption.equals("L")? "selected":"" %>>  <fmt:message key="ePH.Landscape.label" bundle="${ph_labels}"/></option>
<% 
										}
										if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT") ){
%>	
											<option value="P" <%= defPrintOption.equals("P")? "selected":"" %>>  <fmt:message key="ePH.Portrairt.label" bundle="${ph_labels}"/></option>
<% 
										}
										if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT") && print_option.containsKey("HOME_MED_SHEET_LANDSCAPE")){
%>	
											<option value="B"  <%= defPrintOption.equals("B")? "selected":"" %>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
<% 
										}
%>
										</select>
										</td>	
									</tr>
<%
								}
								if(med_ind.containsKey("Separate")){	
									iRowCount++;
%>
									<tr>
										<td class="label"> <fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;(<fmt:message key="ePH.SeperateEyePreparation.label" bundle="${ph_labels}"/>) </td>
<%
										if(blOrientDisplay){
%>
											<td  class="label" colspan='2'><input type="checkbox" name="medn_separate" id="medn_separate" <%=defPrintStatus %>></td>
<%
										}
										else{
%>
											<td  class="label" ><input type="checkbox" name="medn_separate" id="medn_separate" <%=defPrintStatus %>></td>
											<td  class="label"><fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.Orientation.label" bundle="${ph_labels}"/> 
											<select name="homeMedOrientation" id="homeMedOrientation" onchange='changeOrientation(this);'>
											<option value="L" <%=defPrintOption.equals("L")? "selected":"" %>>  <fmt:message key="ePH.Landscape.label" bundle="${ph_labels}"/></option>
											<option value="P" <%= defPrintOption.equals("L")? "selected":"" %>>  <fmt:message key="ePH.Portrairt.label" bundle="${ph_labels}"/></option>
<% 
											if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT") && print_option.containsKey("HOME_MED_SHEET_LANDSCAPE")){
%>	
												<option value="B"  <%= defPrintOption.equals("B")? "selected":"" %>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
<% 
											}
%>
											</select>
											</td>	
<%
											blOrientDisplay = true;
										}
%>
									</tr>
<%
								}
								if(med_ind.containsKey("Only")){	
									iRowCount++;
%>
									<tr>
										<td class="label" >  <fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;(<fmt:message key="ePH.OnlyEyePreparation.label" bundle="${ph_labels}"/>)  </td>
<%
										if(blOrientDisplay){
%>
											<td  class="label" colspan="2"><input type="checkbox" name="medn_only" id="medn_only" <%=defPrintStatus%> ></td>
<%
										}
										else{
%>
											<td  class="label" ><input type="checkbox" name="medn_only" id="medn_only" <%=defPrintStatus%> ></td>
											<td  class="label"><fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.Orientation.label" bundle="${ph_labels}"/> 
											<select name="homeMedOrientation" id="homeMedOrientation" onchange='changeOrientation(this);'>
											<option value="L" <%=defPrintOption.equals("L")? "selected":"" %>>  <fmt:message key="ePH.Landscape.label" bundle="${ph_labels}"/></option>
											<option value="P" <%= defPrintOption.equals("L")? "selected":"" %>>  <fmt:message key="ePH.Portrairt.label" bundle="${ph_labels}"/></option>
<% 
											if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT") && print_option.containsKey("HOME_MED_SHEET_LANDSCAPE")){
%>	
												<option value="B"  <%= defPrintOption.equals("B")? "selected":"" %>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
<% 
											}
%>
											</select>
											</td>	
<%
											blOrientDisplay = true;
										}
%>
									</tr>
<%
								}
								if(med_ind.containsKey("Taper")){	
									iRowCount++;
%>
									<td class="label" ><fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;(<fmt:message key="ePH.TaperOrder.label" bundle="${ph_labels}"/>)  </td>
<%
									if(blOrientDisplay){
%>
										<td  class="label" colspan="2"><input type="checkbox" name="medn_taper" id="medn_taper" <%=defTapPrintStatus%> ></td>
<%
									}
									else{
%>
										<td  class="label" colspan="2"><input type="checkbox" name="medn_taper" id="medn_taper" <%=defTapPrintStatus%> ></td>
										<td  class="label"><fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.Orientation.label" bundle="${ph_labels}"/> 
										<select name="homeMedOrientation" id="homeMedOrientation" onchange='changeOrientation(this);'>
										<option value="L" <%=defPrintOption.equals("L")? "selected":"" %>>  <fmt:message key="ePH.Landscape.label" bundle="${ph_labels}"/></option>
										<option value="P" <%= defPrintOption.equals("L")? "selected":"" %>>  <fmt:message key="ePH.Portrairt.label" bundle="${ph_labels}"/></option>
<% 
										if(print_option.containsKey("HOME_MED_SHEET_PORTRAIT") && print_option.containsKey("HOME_MED_SHEET_LANDSCAPE")){
%>	
											<option value="B"  <%= defPrintOption.equals("B")? "selected":"" %>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
<% 
										}
%>
										</select>
										</td>	
<%
										blOrientDisplay = true;
									}
%>
									</tr>
<%
								}
							}//Added for RUT-CRF-0061 [IN:029599] -end
%>
							<TR>
								<td colspan="5" height="20">&nbsp;&nbsp;<td>
							</TR>
							<tr><td class="white" colspan="3"></td></tr>
							<tr><td class="white" colspan="3"></td></tr>
							<tr><td class="white" colspan="3"></td></tr>
							<tr><td class="white" colspan="3"></td></tr>
							<tr><td class="white" colspan="3"></td></tr>
						</table>

						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
							<tr>
								<td  colspan="3" class="white" <%=sShowButtons%> align='right'><input type="button"  name ="printOK" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="printOfFn('<%=patient_id%>','<%=patient_class%>')"><!--callMedplanCheck Added for Bru-HIMS-CRF-072.1[IN 049144] -->
								&nbsp;<input type="button" class="button" <%=sShowButtons%> value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="printOnlineDispense(document.DispMedicationPrintDialog,'CANCEL');parent.window.returnValue='OK';parent.window.close()"></td>
							</tr>
						</table>

						<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="Bal_Med_table" style="visibility:hidden">
							<tr>
<%
								if(!sBalSheetDefaultCheck.equals("hide")){
%>
									<td class="label"  > <fmt:message key="ePH.BalanceMedicationSheet.label" bundle="${ph_labels}"/> </td>
									<td  >&nbsp;&nbsp;<input type="checkbox" name="bal_sheet" id="bal_sheet" <%=sBalSheetDefaultCheck%>></td>
<%
								}
								else{
%>		
									<td class="label" colspan=2>&nbsp;</td>
<%
								}
								if(!next_appt_days.equals("")){
%>
									<td>
									<img src='../../ePH/images/MI_View-ScheduleAppionment.gif' title='<fmt:message key="ePH.APPOINTMENTLIST.label" bundle="${ph_labels}"/>' style="display:inline;cursor:pointer;width:20;height:20" id="appt_list" onClick="DiplayAppointmentDtls('<%=patient_id%>','<%=sysdate%>','<%=getDate_plus_365%>')"> </td>
<%
								}
								else{
%>
									<td>&nbsp;</td>
<%
								}
%>
                                   <td class="label">&nbsp;
<%
								if(!sBalSheetDefaultCheck.equals("hide")){
%>
									<select name="bmsTabLang" id="bmsTabLang" ><!--Code Added For FD-Bru-HIMS-CRF-075 Start -->
									<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
									<option value="en" <%=sDefaultEnglish%>> <fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
<%
									if(langIdName!=null && langIdName.size()>0 && !((String)langIdName.get(0)).equals("en")){
										localLang = langIdName.get(1)==null?"":(String)langIdName.get(1);
%>
										<option value="<%=langIdName.get(0)%>" <%=sDefaultLocLang%>> <%=localLang%></option>
<%
									}
%>
								      <!-- <option value="B" > Both</option> -->
										</select><!--Code Added For FD-Bru-HIMS-CRF-075 End -->
<%
									}
									else{
%>
										<input type='hidden' value='E' name="bmsTabLang" id="bmsTabLang">
<%
									}
%>
									</td>   
								</tr>
								<tr>
									<td class="label" > <fmt:message key="ePH.NextCollectionDetail.label" bundle="${ph_labels}"/> </td>
									<td  class="label"><input type="radio" name="curr_facility" id="curr_facility" value="C" onclick="callfacillity(this)"  <%=sEnableBMSFields%>  <%=cuu_facility_chk%> ><fmt:message key="ePH.CurrentFacility.label" bundle="${ph_labels}"/></td>
									<td  class="label"><input type="radio" name="curr_facility" id="curr_facility" value="E" onclick="callfacillity(this)" <%=sEnableBMSFields%> ><fmt:message key="Common.externalfacility.label" bundle="${common_labels}"/></td>
									<td ></td> 
								</tr>
							</table>
							<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="curr_facility_table" style="visibility:hidden">
								<tr>
									<td class="COLUMNHEADER" colspan="4" ><fmt:message key="ePH.CurrentFacilityDetail.label" bundle="${ph_labels}"/></td>
								<tr>
								<TR>
									<td colspan="4" height="20">&nbsp;&nbsp;<td>
								</TR>
								<tr>
									<td class="label" width='25%'>&nbsp;&nbsp;<label><fmt:message key="ePH.NextCollectionDate.label" bundle="${ph_labels}"/></label></td>
									<td class="label" width='25%'><input type="text" name="next_collection_date1" id="next_collection_date1"  size="8" maxlength="10"    onBlur="CheckDate(this);checkSysDate(sysdate,next_collection_date1);" value="<%=strNextCollectionDate%>" >
									<INPUT  TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif"  id=Calendar onclick="return showCalendar('next_collection_date1');" > 
<% 
									if(curr_stage.equals("D") || curr_stage.equals("AS") ) { 
%>	
										<img src="../../eCommon/images/mandatory.gif" align='center'></img>
<%
									}
%>
									</td> 
									<td class="label">&nbsp;&nbsp;<fmt:message key="ePH.NextCollectionFrom.label" bundle="${ph_labels}"/> </td>
									<td>
										<select name="disp_locations" id="disp_locations" <%=sEnableBMSFields%>>
											<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
											for(int i=0; i<disp_locns.size(); i+=2) {
												if(nextBmsDispLocn==null || nextBmsDispLocn.equals("") ){//If condition & Else Added for HSA-CRF-0113 [IN:048166] 
													if( dis_loc_code.equals((String)disp_locns.get(i))) {
%>
														<option value="<%=(String)disp_locns.get(i)%>" selected><%=(String)disp_locns.get(i+1)%></option>
<%	
													}
													else {	
%>
														<option value="<%=(String)disp_locns.get(i)%>"><%=(String)disp_locns.get(i+1)%></option>
<%	
													}
												}
												else{
													if( nextBmsDispLocn.equals((String)disp_locns.get(i))) {
%>
														<option value="<%=(String)disp_locns.get(i)%>" selected><%=(String)disp_locns.get(i+1)%></option>
<%	
													}
													else {	
%>
														<option value="<%=(String)disp_locns.get(i)%>"><%=(String)disp_locns.get(i+1)%></option>
<%	
													}
												}
											}	
%>
											</select>
										   <img src="../../eCommon/images/mandatory.gif" align=center></img>
										</td>
									</tr>
									<TR id='trCurBMSReason'>
<%
										if(alBMSReasons!=null && alBMSReasons.size()>0)
											bmsReasonVisible = "visible";
										else
											bmsReasonVisible = "hidden";
%>
										<td class="label" >&nbsp;&nbsp;<fmt:message key="ePH.BalanceMedicationRemarks.label" bundle="${ph_labels}"/></td>
										<td class="label">
											<select name="CurbmsReason" id="CurbmsReason"  onchange="chaneBMSINeditlabel()" >
												<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
												if(alBMSReasons!=null && alBMSReasons.size()>0){
													for(int indx=0; indx<alBMSReasons.size(); indx+=2){
														if(strBMSReasonCode.equals((String)alBMSReasons.get(indx))){
%>
															<option value="<%=(String)alBMSReasons.get(indx)%>" selected><%=(String)alBMSReasons.get(indx+1)%></option>
<%
														}
														else{
%>
															<option value="<%=(String)alBMSReasons.get(indx)%>"><%=(String)alBMSReasons.get(indx+1)%></option>
<%
														}
													}
												}
%>
											</select>
										<td>
										<input type='hidden' name='curBMSReasonVisibility' id='curBMSReasonVisibility' value='<%=bmsReasonVisible%>'>
									</TR>
									<tr><td>&nbsp;</td></tr><!--for HSA-CRF-0155 [IN048487] -->
								</table>
								<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="extr_facility_table" style="visibility:hidden">
									<tr>
										<td class="COLUMNHEADER" colspan="5"><fmt:message key="ePH.ExternalFacilityDetail.label" bundle="${ph_labels}"/></td>
									</tr>
									<tr>
										<td class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<%  
								if(region_check){ //Added for MOHE-CRF-0074-Start
									if(region_code_check!=null && region_code_check.size() > 1 ){
%>
										<TD COLSPAN="2" class="label">
											<SELECT name="referral_facility" id="referral_facility" onChange="disable_facility(this,referral_location_desc,othr_factySearch,ref_referral_facility)" >
											<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</OPTION>	
<%
											for(int i=0;i<region_code_check.size();i+=2){
												order_facility_id=(String)region_code_check.get(i);
												order_facility_name=(String)region_code_check.get(i+1);
%>
												<OPTION  VALUE='<%=order_facility_id%> '><%=order_facility_name%></OPTION>
<%
											}
%>
											</SELECT>
											<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
										</TD>
<%
									}
									else if(region_code_check!=null && region_code_check.size() == 1 )  {   // only one record						
										order_facility_name=(String)region_code_check.get(0);
										order_facility_name=(String)region_code_check.get(1);
%>
										<td class="label"><input type="text" size="15" name="referral_facility" id="referral_facility" disabled value='<%=order_facility_name%>'><input type="hidden"  value='<%=order_facility_name%>'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td>
<%	
									} 
									else {
%>
										<td class="label"><input type="text" size="15" name="referral_facility" id="referral_facility" disabled value=''><input type="hidden"  value=''><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td>
<% 
										} //Added for MOHE-CRF-0074-End
								}else{
										facilitys=bean.getRefFacility(); 
										if(facilitys!=null && facilitys.size() > 1 ){
%>
											<TD COLSPAN="2" class="label">
												<SELECT name="referral_facility" id="referral_facility" onChange="disable_facility(this,referral_location_desc,othr_factySearch,ref_referral_facility)" >
												<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</OPTION>	
<%
												for(int t=0;t<facilitys.size();t++){
													facility=(HashMap)facilitys.get(t);
%>
													<OPTION  VALUE='<%=facility.get("FACILITY_ID")%> '><%=facility.get("FACILITY_NAME") %></OPTION>
<%
												}
%>
												</SELECT>
												<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
											</TD>
<%
										}
										else if(facilitys!=null && facilitys.size() == 1 )  {   // only one record						
											facility=(HashMap)facilitys.get(0);
%>
											<td class="label"><input type="text" size="15" name="referral_facility" id="referral_facility" disabled value='<%=facility.get("FACILITY_NAME")%>'><input type="hidden"  value='<%=facility.get("FACILITY_ID")%>'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td>
<%	
										} 
										else {
%>
											<td class="label"><input type="text" size="15" name="referral_facility" id="referral_facility" disabled value=''><input type="hidden"  value=''><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td>
<% 
										} 
								} //Added for MOHE-CRF-0074
%>
										<TD   class='label' nowrap><fmt:message key="Common.OtherFacility.label" bundle="${common_labels}"/> &nbsp;
<%		
										e_facilitys=(ArrayList)bean_2.getOtherRefFacility(); 
										if(e_facilitys!=null && e_facilitys.size() > 0 ){
%>
											<SELECT name="ref_referral_facility" id="ref_referral_facility" onChange="clear_text(this,referral_location_desc,referral_facility,referral_location)">
												<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</OPTION>	
<%
												for(int t=0;t<e_facilitys.size();t+=2){
%>
													<OPTION  VALUE='<%=e_facilitys.get(t)%>'><%=e_facilitys.get(t+1)%></OPTION>
<%
												}
											}
%>
											&nbsp;&nbsp;<INPUT TYPE="text" name="referral_location_desc" id="referral_location_desc" onblur='disable_facility1(this,referral_facility)'>
											<INPUT type="button" value="?" class="button" name="othr_factySearch" id="othr_factySearch"  onclick="callOtherfactySeach()">
											<INPUT TYPE="hidden" name="referral_location" id="referral_location" value="">
									   </TD>
									</tr>
									<tr>	
										<td class="label" ><label><fmt:message key="ePH.NextCollectionDate.label" bundle="${ph_labels}"/></label> </td>
										<td class="label"><input type="text" name="next_collectiondate" id="next_collectiondate"  size="8" maxlength="10" value="<%=strNextCollectionDate%>"   onBlur="CheckDate(this);checkSysDate(sysdate,next_collectiondate);" ><INPUT  TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif"  id=Calendar onclick="return showCalendar('next_collectiondate');" > <img src="../../eCommon/images/mandatory.gif" align=center   ></img>
										</td>
										<td class="label"colspan="3">&nbsp;</td>
									</tr> 
									<TR id='trExtBMSReason'>
<%
										if(alBMSReasons!=null && alBMSReasons.size()>0)
											bmsReasonVisible = "visible";
										else
											bmsReasonVisible = "hidden";
%>
										<td class="label" ><fmt:message key="ePH.BalanceMedicationRemarks.label" bundle="${ph_labels}"/></td>
										<td class="label">
											<select name="ExtbmsReason" id="ExtbmsReason"  >
												<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
												if(alBMSReasons!=null && alBMSReasons.size()>0){
													for(int indx=0; indx<alBMSReasons.size(); indx+=2){
														if(strBMSReasonCode.equals((String)alBMSReasons.get(indx))){
%>
														<option value="<%=(String)alBMSReasons.get(indx)%>" selected><%=(String)alBMSReasons.get(indx+1)%></option>
<%
													}
													else{
%>
														<option value="<%=(String)alBMSReasons.get(indx)%>"><%=(String)alBMSReasons.get(indx+1)%></option>
<%
												}
											}
										}
%>
										</select>
									<td>
									<input type='hidden' name='extBMSReasonVisibility' id='extBMSReasonVisibility' value='<%=bmsReasonVisible%>'>
									<td colspan="2" >&nbsp;&nbsp;<td>
								</TR>
								 <tr>
									<td class="label"  name="referral_remarks"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
									<td colspan="5" class="label"><textarea size="555" name="referral_remarks" cols="60" rows="2"></textarea><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td>
								</tr> 
<%
								String functional_role_id	=    bean.getFunctRollID(login_user);
								String Pract_name			=	 bean_2.getPractitionerName( functional_role_id);
%>
							<tr >
								<td  class="label"><fmt:message key="ePH.ReferedBy.label" bundle="${ph_labels}"/></td>
								<td  class="label"><input type="text" name="practioner_name" id="practioner_name" maxlength="40" size="20" value="<%=Pract_name%>" onchange="searchPractioner(this, 'ONCHANGE');"><input type="button" class="button" value="?" name="practioner_search" id="practioner_search" onclick="searchPractioner(this, 'ONCLICK');">
								<input type="hidden" name="practioner_id" id="practioner_id" value="<%=functional_role_id%>"><img src="../../eCommon/images/mandatory.gif" ID="mand1" > </td>
								<td  class="label" COLSPAN='3'><fmt:message key="ePH.PrintExternalPrescription.label" bundle="${ph_labels}"/>
								<input type="checkbox" name="print_extr_pres" id="print_extr_pres"></td>

							</tr>	
						</table>
						<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="extr_facility_btn_table" style="visibility:hidden">
							<TR>
								<td colspan="4" height="20">&nbsp;&nbsp;<td>
							</TR>
							<tr>    
								<td  colspan="4" class="white" align="center"><input type="button" name="recordButton" id="recordButton" class="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="setOrOrder(document.DispMedicationPrintDialog);">&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="reset_table(document.DispMedicationPrintDialog)"></td>
							</tr>
						</table>
<%
					//putObjectInBean(bean_id,bean,request);
					//putObjectInBean(bean_id_2,bean_2,request);

					}
					if(iRowCount>0) //added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
						lPrintReport = true;
					if(sEnableTab.equals("Y")){
						if(iRowCount<5)
							iRowCount = 6;	
					}
					iRowCount = (iRowCount * 5 )+1;
					if(iRowCount > 30 || (iRowCount == 0 && hmAllocBmsCheckSize >0 ))// || condition added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
						iRowCount = 31;
				//KDAH-CRF-0476 - start
					String report_id = "";	
					
				//Added for GHL-CRF-0669[48847] start
					String customer_id = bean.getCustomerID();
					String p_patient_class = bean.getPatientClass(patient_id, bean.getEncounterID());
				if(customer_id.equals("MC") && bean.getOrderType().equals("NOR")){
					if(p_patient_class.equals("IP") || p_patient_class.equals("DC")){
						if(curr_stage.equals("F") || curr_stage.equals("A")){
							report_id="PHPRDISSHFILL_IP";
						}
						else if(curr_stage.equals("D")){
							report_id="PHPRDISSH_IP";
						}
					}else if(p_patient_class.equals("EM")){
						if(curr_stage.equals("F") || curr_stage.equals("A")){
							report_id="PHPRDISSHFILL_EM";
						}
						else if(curr_stage.equals("D")){
							report_id="PHPRDISSH_EM";
						}
					} else { 
						if(curr_stage.equals("F") || curr_stage.equals("A")){
							report_id="PHPRDISSHFILL";
						}
						else if(curr_stage.equals("D")){
							report_id="PHPRDISSH";
						}
				  	}
				}//Added for GHL-CRF-0669[48847] end
				else{		
					if( curr_stage.equals("A") || curr_stage.equals("F") ){
						if(bean.getOrderType().equals("NOR"))
							report_id = "PHPRDISSHFILL";
						else if(bean.getOrderType().equals("IVWA"))
							report_id = "PHPRDISSHCONFILL";
						else if(bean.getOrderType().equals("IVID"))
							report_id="PHPRDISSHINTFILL";
						else if(bean.getOrderType().equals("IVID"))
							report_id="PHPRDISSHCONFILL";
						else if(bean.getOrderType().equals("CD"))
							report_id="PHCYTODISSHFL";
						else if(bean.getOrderType().equals("TD"))
							report_id="PHRDISSHTPNFILL";
					}else{
						if(curr_stage.equals("D") || curr_stage.equals("AS") ){//curr_stage.equals("AS") added for 66934
							if(bean.getOrderType().equals("NOR"))
								report_id = "PHPRDISSH";
							else if (bean.getOrderType().equals("IVAD"))
								report_id = "PHRIVCONT";
							else if (bean.getOrderType().equals("IVWA"))
								report_id = "PHRIVCONTWOADD";
							else if (bean.getOrderType().equals("IVID"))
								report_id = "PHRIVINTT";
							else if(bean.getOrderType().equals("CD"))
								report_id = "PHCYTODISSHDL";
						}
					}
				}
					//KDAH-CRF-0476 -end
%>
					<input type="hidden" name="disp_no" id="disp_no"				value="<%=disp_no%>">
					<input type="hidden" name="login_user" id="login_user"			value="<%=login_user%>">
					<input type="hidden" name="facility_id" id="facility_id"			value="<%=facility_id%>">
					<input type="hidden" name="patient_id" id="patient_id"			value="<%=patient_id%>">
					<input type="hidden" name="disp_locn" id="disp_locn"			value="<%=disp_locn%>">
					<input type="hidden" name="locn_code" id="locn_code"			value="<%=locn_code%>"> <!-- added for locn_code -->
					<input type="hidden" name="patient_class" id="patient_class"		value="<%=patient_class%>">
					<input type="hidden" name="sysdate" id="sysdate"			   value="<%=com.ehis.util.DateUtils.convertDate(bean_2.getCurrDate(),"DMY","en",locale)%>">
					<input type="hidden" name="order_line_no" id="order_line_no"		value="<%=order_line_no%>">
					<input type="hidden" name="order_id" id="order_id"			value="<%=sOrderId%>">
					<input type="hidden" name="bean_id_2" id="bean_id_2"			value="<%=bean_id_2%>">
					<input type="hidden" name="bean_name_2" id="bean_name_2"			value="<%=bean_name_2%>">
					<input type="hidden" name="visible" id="visible"				value="<%=visible%>">
					<input type="hidden" name="order_type" id="order_type"			value="<%=order_type%>">
					<input type="hidden" name="srl_no" id="srl_no"				value="<%=srl_no%>">	
					<input type="hidden" name="complete_order_flag" id="complete_order_flag" value="<%=complete_order_flag%>">
					<input type="hidden" name="enable_tab" id="enable_tab"			value="<%=sEnableTab%>">
					<input type="hidden" name="curr_stage" id="curr_stage"			value="<%=curr_stage%>">
					<input type="hidden" name="Language_id" id="Language_id"			value="<%=locale%>">		
					<input type="hidden" name="SQL_PH_DISP_PRACT_REFERRAL_SELECT" id="SQL_PH_DISP_PRACT_REFERRAL_SELECT" value="<%=SQL_PH_DISP_PRACT_REFERRAL_SELECT%>">
					<input type="hidden" name="EnableBMSFields" id="EnableBMSFields"		value="<%=sEnableBMSFields%>">
					<INPUT TYPE="hidden" name="othr_facty_sql" id="othr_facty_sql" Value="<%=othr_facty_sql%>">
					<INPUT TYPE="hidden" name="localLang" id="localLang" Value="<%=localLang %>"><!-- Code Added For FD-Bru-HIMS-CRF-074  --> 
					<INPUT TYPE="hidden" name="sBalSheetDefaultCheck" id="sBalSheetDefaultCheck" Value="<%=sBalSheetDefaultCheck %>">
					<INPUT TYPE="hidden" name="sDrugLabelStatus" id="sDrugLabelStatus" Value="<%=sDrugLabelStatus %>">
					<INPUT TYPE="hidden" name="dis_loc_code" id="dis_loc_code" Value="<%=dis_loc_code %>">
					<INPUT TYPE="hidden" name="Orderresult_id" id="Orderresult_id" Value="<%=Orderresult_id %>">
					<INPUT TYPE="hidden" name="token_series" id="token_series" Value="<%=token_series %>">
					<INPUT TYPE="hidden" name="defPrintStatusLS" id="defPrintStatusLS" Value="<%=defPrintStatusLS %>">
					<INPUT TYPE="hidden" name="defPrintStatusPT" id="defPrintStatusPT" Value="<%=defPrintStatusPT %>">
					<INPUT TYPE="hidden" name="iRowCount" id="iRowCount" Value="<%=iRowCount %>">
					<INPUT TYPE="hidden" name="allow_edit_disp_label" id="allow_edit_disp_label" Value="<%=allow_edit_disp_label %>">
					<INPUT TYPE="hidden" name="params" id="params" Value="<%=params %>">


<!-- KDAH-CRF-0476 - start-->
					<INPUT TYPE="hidden" name="module_id" id="module_id" VALUE="PH">
					<INPUT TYPE="hidden" name="report_id" id="report_id" VALUE="<%=report_id%>">
					<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="disp_fm_no" id="disp_fm_no" value="<%=disp_fm_no%>">
					<input type="hidden" name="disp_to_no" id="disp_to_no" value="<%=disp_to_no%>">
					<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
					<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
					<INPUT TYPE="hidden" name="disp_date" id="disp_date" VALUE="<%=com.ehis.util.DateUtils.convertDate(bean_2.getCurrDate(),"DMY","en",locale)%>">
					<INPUT TYPE="hidden" name="reprint_yn" id="reprint_yn" VALUE="Y">
					<INPUT TYPE="hidden" name="p_order_type" id="p_order_type" VALUE="<%=bean.getOrderType()%>">
					<!-- KDAH-CRF-0476 - start-->
<%
					if(locale.equals("en")){
%>
						<INPUT TYPE="hidden" name="defaultLanguage" id="defaultLanguage" Value="E">
<%	
					}
					else { 
%>
						<INPUT TYPE="hidden" name="defaultLanguage" id="defaultLanguage" Value="L">
<% 
					}
%>
				</form>
				<script>
					parent.document.body.rows = "<%=iRowCount%>,60,5,0";
<%
					if(!lPrintReport){ //added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
%>
						disablePrintRep();
<%
					}
%>
				</script>
<%
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{//added for ml-bru-crf-0469
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	
	}
%>
	</body>
</html>

