<!DOCTYPE html>
<!-- /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] 
22/07/2020	IN:072092	        	     Manickavasagam J			     GHL-CRF-0618
12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eXH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>   
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
		
<%
        Connection con			= null;  // Added for ML-MMOH-crf-0468 
		try{
			    con				= ConnectionManager.getConnection(request);
			    boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 - End
			    boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); // Added for ML-BRU-CRF-0469 [IN:065426]
			   boolean item_type_site_app = CommonBean.isSiteSpecific(con, "PH", "ITEM_TYPE_APP"); // added for GHL-CRF-0549
			   boolean intractn_req_yn    = CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	// Added for MMS-KH-CRF-0013 [IN:067952] 
		   		boolean formulary_billing_app = CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
		   		boolean expired_order = CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
				 boolean patient_br_legend  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","VERIFY_PAT_BROUGHT_MEDN"); //Added for TH-KW-CRF-0011
				 boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
		 boolean aggred_item_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1

    	String bean_id			= "DispMedicationBean" ;
			String bean_name		= "ePH.DispMedicationBean";

			DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
			
			String p_user_name      = (String) session.getValue( "login_user" ) ;
			String disp_locn_code	 = bean.getDispLocnCode();
			//commented during PE By Naveen
		   // String Unlock_all_records_yn=bean.getUnLockRecordsYN(p_user_name,disp_locn_code);
			String Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();
			String facility_id			= (String)session.getAttribute("facility_id"); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
			DispMedicationAllStages bean_1 = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request ) ;
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); // Added for Bru-HIMS-CRF-072.1[IN 049144]
			String userAuthPINYN		= bean_1.getUserAuthPINRequiredYN(); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
			String retn_disp_med_for_outstanding	=  bean.getRetnDispMedForOutStanding(); //Added for MMS-QH-CRF-0201 [IN:052255]
			String tot_groos_pat_payable = "0";
			String tot_gross_amount      = "0"; // Added for ML-BRU-CRF-0469 [IN:065426]
			String disp_locn_catg		= bean.getDispLocnCatg();
			String disp_cash_coll_stage = bean.getDispCashCollStage();//added for MMS-QH-CRF-0201 [IN:052255]
			String disp_stage		= bean.getDispStage();
			String ws_type		    = bean.getWsType();	
			if(ws_type==null)
				ws_type="";

			Hashtable param_legends		= bean.getLegendsFromParam();
			String patient_id			= request.getParameter("patient_id");
			//String order_id			    = request.getParameter("order_id");
			String stage				= request.getParameter("stage");	
			String tot_no_rec			= request.getParameter("tot_no_rec");
			String allocated_status		= bean.getAllocatedStatus();
			String fill_list			= bean.getFillList();
			String param				="";
			String  tpn_finalize		= request.getParameter("TPN_FINALIZE");
			String billing_interface_yn = request.getParameter("billing_interface_yn")==null?"":request.getParameter("billing_interface_yn");
			String sDispDrugAuthYN		= request.getParameter("DispDrugAuthYN")==null?"N":request.getParameter("DispDrugAuthYN");
			//billing_interface_yn="+billing_interface_yn+"&tot_gross_charge_amount="+tot_gross_charge_amount+"&tot_groos_pat_payable="+tot_groos_pat_payable
			//if(tpn_finalize==null)
			tpn_finalize="YES";
			String showpersonName=bean.getFillPerson();//Added for AMS-CRF-0009[IN:030935]
			Hashtable ht_ws_alloc_batches = bean.getHTWSAllocateBatches();
			int size	=	ht_ws_alloc_batches.size();
			double dPatientPayable = 0; //added for Bru-HIMS-CRF-094-DD1 [IN:047224]
			String patient_class	= bean.getDispLocnCatg();//added for Bru-HIMS-CRF-094-DD1 [IN:047224]

			if(tot_no_rec==null || tot_no_rec.equals("") || tot_no_rec.equals("undefined"))	
				tot_no_rec="0";
%>
		</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		    <style> <!-- Added for MMS-KH-CRF-0013 [IN:067952] - Start -->
	           TD.DINTERACN{ 
		        BACKGROUND-COLOR:pink;
		        FONT-SIZE: 8pt ;
		        height:15;
		        BORDER-STYLE: solid;
		        BORDER-BOTTOM: #663300 0px solid;
	            BORDER-LEFT: #663300 0px solid;
	            BORDER-RIGHT: #663300 1px solid;
	            BORDER-TOP: #663300 1px solid;
                    } 
            TD.EXPIRED_ORDER{    /* Added for MOHE-CRF-0032 */
			BACKGROUND-COLOR:#FFA500; //code modified for MOHE-CRF-0032
			FONT-SIZE: 8pt ;
			height:10;
			BORDER-STYLE: solid;
	}          
	TD.PATIENTMED{    /* Added for MOHE-CRF-0032 */
			BACKGROUND-COLOR:#87CEEB; //code modified for MOHE-CRF-0032
			FONT-SIZE: 8pt ;
			height:10;
			BORDER-STYLE: solid;
	}                                
	           </style>  <!-- Added for MMS-KH-CRF-0013 [IN:067952] - End -->
			<form name="frmDispMedicationAllStagesLegends" id="frmDispMedicationAllStagesLegends">
<%
				if(billing_interface_yn.equals("Y")){
					String tot_gross_charge_amount			 =  request.getParameter("tot_gross_charge_amount");
					tot_groos_pat_payable			 =  request.getParameter("tot_groos_pat_payable");
					tot_gross_amount                 =  request.getParameter("tot_gross_amount")==null?"0.00":(String)request.getParameter("tot_gross_amount"); // Added for ML-BRU-CRF-0469 [IN:065426]
					//String iv_prep_yn							 = "";      
					String disp_drug_penalty		= bean.getDispDrugPenalty(); //added for JD-CRF-0170.1 [IN:040204]
					String admixture_yn						 = request.getParameter("admixture_yn")==null?"N":request.getParameter("admixture_yn");
					float ftPenaltyAmount  = 0; //added for JD-CRF-0170.1 [IN:040204] -start
					String penaltyFont = "";
					if(disp_drug_penalty.equals("Y")){ 
						ftPenaltyAmount = bean_1.getDrugPenaltyAmount();

						if(!(tot_gross_charge_amount.equals("") || tot_groos_pat_payable.equals("")) ){//tot_gross_amount.equals("") removed for KAUH-SCF-0318
							tot_gross_charge_amount = (Float.parseFloat(tot_gross_charge_amount) +ftPenaltyAmount)+"";
							tot_groos_pat_payable  = (Float.parseFloat(tot_groos_pat_payable) +ftPenaltyAmount)+"" ;
							// added for ML-BRU-CRF-0469 start
							//if(displayGrossAmtYn){ //commented for KAUH-SCF-0318
							//tot_gross_amount  = Float.parseFloat(tot_gross_amount) +ftPenaltyAmount+"" ;
							//}
							// added for ML-BRU-CRF-0469 end
						}
						 if(!tot_gross_amount.equals("")){//added for KAUH-SCF-0318
							if(displayGrossAmtYn){
							tot_gross_amount  = Float.parseFloat(tot_gross_amount) +ftPenaltyAmount+"" ;
							}
							// added for ML-BRU-CRF-0469 end
						}
					}
					if(ftPenaltyAmount>0)
						penaltyFont = "COLOR:red;"; //added for JD-CRF-0170.1 [IN:040204] - End
						// if condtion position is inter changed for numberfprmate exception in ML-MMOH-CRF-0449(IN057483)
						if(!tot_groos_pat_payable.equals("")) //added for Bru-HIMS-CRF-094-DD1 [IN:047224]
							dPatientPayable = Double.parseDouble(tot_groos_pat_payable);
						medplan_bean.setStrTotal_gross_charge_amount(tot_gross_charge_amount); // Added for Bru-HIMS-CRF-072.1[IN 049144]
					if(displayGrossAmtYn){ // patient_payable_amt Added for ML-BRU-CRF-0469 [IN:065426] - Start
						medplan_bean.setStrTotal_gross_charge_amount(tot_gross_charge_amount); 
						medplan_bean.setStrTotal_gross_amount(tot_gross_amount);
						medplan_bean.setstrTotal_charge_amount(tot_groos_pat_payable); 
					} // charge_amount Added for ML-BRU-CRF-0469 [IN:065426] - End
					if(admixture_yn.equals("Y")){
						String gross_admx_prep_charge				= request.getParameter("gross_admx_prep_charge");
						String groos_pat_payable_admx_prep_charge	= request.getParameter("groos_pat_payable_admx_prep_charge");
						String mark_up_down						    = request.getParameter("mark_up_down");
						String bl_decimal_format_str				= request.getParameter("bl_decimal_format_str");

						DecimalFormat dfTest							=   new DecimalFormat(bl_decimal_format_str);

						if(!tot_gross_charge_amount.equals("") && !tot_groos_pat_payable.equals("")&&!mark_up_down.equals("")){
							tot_gross_charge_amount = dfTest.format( Float.parseFloat(tot_gross_charge_amount) +( Float.parseFloat(mark_up_down)*Float.parseFloat(gross_admx_prep_charge) ))+"";
							tot_groos_pat_payable  = dfTest.format(Float.parseFloat(tot_groos_pat_payable) +( Float.parseFloat(mark_up_down)*Float.parseFloat(groos_pat_payable_admx_prep_charge) ))+"" ;
						}
					}
                                            //below 3 lines commented and added above for ML-MMOH-CRF-0449(IN057483)
					//if(!tot_groos_pat_payable.equals("")) //added for Bru-HIMS-CRF-094-DD1 [IN:047224]
						//dPatientPayable = Double.parseDouble(tot_groos_pat_payable);
					//medplan_bean.setStrTotal_gross_charge_amount(tot_gross_charge_amount); // Added for Bru-HIMS-CRF-072.1[IN 049144]
%>
					<table cellpadding="0" cellspacing="0" height='10' width="100%" align="center" border="0">	 
						<tr>
							<td class="data" width='30%'>&nbsp;</td>  
							<!-- Added for ML-BRU-CRF-0469 start -->
							<%if(displayGrossAmtYn){%>
							<td  class="data"  align='center' style="font-size:9pt;<%=penaltyFont%>" id='total_gross_amount' ><fmt:message key="ePH.TotalGrossAmount.label" bundle="${ph_labels}"/> : <%=tot_gross_amount%></td>
							<%}%>
							<!-- Added for ML-BRU-CRF-0469 end -->
							<td  class="data"  align='center' style="font-size:9pt;<%=penaltyFont%>" id='total_payable' ><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/> : <%=tot_gross_charge_amount%></td>
							<td  class="data"  align='center' style="font-size:9pt;<%=penaltyFont%>" id='patient_payable' ><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>  : <%=tot_groos_pat_payable%> </td>
						</tr>
					</table>
<%
				}
%>
				<table cellpadding="0" cellspacing="0" height='10' width="100%" align="center" border="1">
					<tr>
<%
					if(!(fill_list.equals("DWF")) ){
%>
						<td class='ALLERGY' width='6%' height="5" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/></label></td>
						<td class='DOSELIMIT' width='10%' height="5" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="ePH.BeyondDosage.label" bundle="${ph_labels}"/></label></td>
						<td class='CURRENTRX' height="5" width="8%" align='center'><label style="font-size:9;font-weight:bold" ><fmt:message key="ePH.DUPLICATE.label" bundle="${ph_labels}"/></label></td>
						<% if(intractn_req_yn && bean.getOrderType().equals("NOR")){ // Added for MMS-KH-CRF-0013 [IN:067952] - Start %>
						<td class='DINTERACN' width='8%' height="5" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/></label></td>
						<% } // Added for MMS-KH-CRF-0013 [IN:067952] - End %>
						<td class='white' width='2%' height="5" border='0' align='center'><img src="../../ePH/images/DrugRemarks.gif" width='15' height='15'></td><td class='white' width='10%' height="5" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></label></td>
						<td class='FORMULARY' width="10%" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="ePH.NonFormulary.label" bundle="${ph_labels}"/></label></td>
						<td class='white' width='3%'height="5" align='center'  border='0'>&nbsp;<img src="../../ePH/images/Patientcounsel.gif" ></img></td>
						<td class='white' width='8%' height="5" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="ePH.COUNSELLING.label" bundle="${ph_labels}"/>  </label></td>
						<%if(drug_abuse_appl){ %>
						<td style="BACKGROUND-COLOR:purple;" width='8%' height="5" align='center'><label style="font-size:9;font-weight:bold;">Drug Abuse </label></td>
						
						<% }if(expired_order){ // modifeid for MOHE-CRF-0032
						%>  
						<td class='EXPIRED_ORDER' width='8%' height="5" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="ePH.ExpiredOrder.label" bundle="${ph_labels}"/></label></td>
						<%
						}else{
						%>
						<td class='EXPIRED_MEDICATION' width='8%' height="5" align='center'><label style="font-size:9;font-weight:bold"><fmt:message key="Common.Expired.label" bundle="${common_labels}"/></label></td>
<% 
					}} 
%>
					<!--<td class='white' width='2%'><img src='../../eCommon/images/disabled.gif' align='center'></td>
					<td class='white'>&nbsp;&nbsp;<label style="font-size:9;font-weight:bold">No Stock</label></td>-->
<%
					if(disp_stage.equals("V")){   // Verification
%>
						<td class='STOCK' width='2%'><HR style="color:yellow" width="80%"></td>
						<td class='white' width='10%'>&nbsp;&nbsp;<label style="font-size:9;font-weight:bold;"><fmt:message key="ePH.InsufficientStock.label" bundle="${ph_labels}"/></label></td>
<%                   if(patient_br_legend){//Added for TH-KW-CRF-0002
%>
						<td class="PATIENTMED" width="10%" >   
				         <label class="label" style="font-size:9;font-weight:bold" width="17%"><b>&nbsp;<fmt:message key="ePH.PatientBroughtMedication.label" bundle="${ph_labels}"/></b></label>
				       </td>
<%
                 }
			}
			if(!(fill_list.equals("DWF") || fill_list.equalsIgnoreCase("AF")) ){// Added for Bru-HIMS-CRF-093-DD1[IN047223] start-
%>
				<td class="HOME_MED" width="10%" >   
				<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="ePH.HomeLeaveMedication.label" bundle="${ph_labels}"/></b></label>
				</td>
<%
			} //Added for Bru-HIMS-CRF-093-DD1[IN047223] end
			if(disp_stage.equals("AS")){	   // All Stages
%>
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.CompleteDispense.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeDispensing();}" name="all_stages_butt" ></td>  
<%
					}
					else if(disp_stage.equals("V")){   // Verification
%>
						<td align="right" class='white'>&nbsp;<input  type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/><%=param_legends.get("V")%>' class="button" onClick="completeVerification()"></td>
<%
					}
					else if(disp_stage.equals("A")){	// Allocation
					String label_display="NO";
					bean.setWsStatus("I"); // Worksheet will be incomplete by default
					if(size>0 && (size==Integer.parseInt(tot_no_rec))){
						if((bean.getMfgUnitDetails()).size()!=5)
							label_display="YES";
						bean.setWsStatus("C");
%>   
																									
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.FinalizeWorksheet.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('WS_FINALIZE','<%=label_display%>');}" id="allocation_butt" ></td>
<%	
					}
					else if((bean.getAdmixtureType()).equals("TA")){
						
						if(tpn_finalize.equals("YES")){
							label_display="YES";
							bean.setWsStatus("C");
%>  
							<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.FinalizeTPNWorksheet.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('TPN_WS_FINALIZE','<%=label_display%>');}" id="allocation_butt" ></td>
<%
						}
						else{
%>
							<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.CompleteDispense.label" bundle="${ph_labels}"/> <%=param_legends.get("F")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('TPN_WS_RECORD');}" id="allocation_butt" ></td>
<%
						}
					}
					else if((bean.getAdmixtureType()).equals("CA")){
						if(tpn_finalize.equals("YES")){
							label_display="YES";
%>  
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.FinalizeCytoWorksheet.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('CYTO_WS_FINALIZE','<%=label_display%>');}" id="allocation_butt" ></td>
<%
					}
					else{
%>
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("F")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('CYTO_WS_RECORD');}" id="allocation_butt" ></td>
<%
					}
				}
				else if(ws_type.equals("2")||ws_type.equals("4")){
					label_display="YES";
					bean.setWsStatus("C");
%>
					<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("A")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('WS_RECORD','<%=label_display%>');}" id="allocation_butt" ></td>
<%
				}
				else{
%>
					<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("A")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation();}" id="allocation_butt" ></td>
<%
				}
			}
			else if(disp_stage.equals("F")){	//Filling
				String label_display="NO";
				bean.setWsStatus("I"); // Worksheet will be incomplete by default
				//if(size==Integer.parseInt(tot_no_rec) && size>0){
		
				if( size>0 ){
					if((bean.getMfgUnitDetails()).size()!=5)
						label_display="YES";
					bean.setWsStatus("C");
%>			
					<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.FinalizeWorksheet.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('WS_FINALIZE','<%=label_display%>');}" id="allocation_butt_ws" ></td>
<%
				}
				else if((bean.getAdmixtureType()).equals("TA")){
					if(tpn_finalize.equals("YES")){
						label_display="YES";
						bean.setWsStatus("C");
%>
						<!-- Added for to display legends in fill stage for inpatient ML-MMOH-CRF-0434 start [IN057356]-->
						<td align="center"  style='background-color: blue;font-size:9;font-weight:bold;width:3%;' >&nbsp;<fmt:message key="ePH.NewLegend.label" bundle="${ph_labels}"/></td>
						<td align="center"  style='background-color: green;font-size:9;font-weight:bold;width:3%;'><fmt:message key="ePH.RegularLegend.label" bundle="${ph_labels}"/></td>
						<td align="center"  style='background-color: yellow;font-size:9;font-weight:bold;width:3%;'><fmt:message key="ePH.HeldLegend.label" bundle="${ph_labels}"/></td>
						<!-- Added for ML-MMOH-CRF-0434 End [IN057356] -->
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.FinalizeTPNWorksheet.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('TPN_WS_FINALIZE','<%=label_display%>');}" id="allocation_butt" ></td>
<%
					}
					else{
%>
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("F")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('TPN_WS_RECORD');}" id="allocation_butt" ></td>
<%
					}
				}
				else if((bean.getAdmixtureType()).equals("CA")){				
					if(tpn_finalize.equals("YES")){
						label_display="YES";
%>
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="  ePH.FinalizeCytoWorksheet.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('CYTO_WS_FINALIZE','<%=label_display%>');}" id="allocation_butt" ></td>
<%
					}
					else{
%>
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("F")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('CYTO_WS_RECORD');}" id="allocation_butt" ></td>
<%
					}
				}
				else if(ws_type.equals("2")||ws_type.equals("4")){
					label_display="YES";
					bean.setWsStatus("C");			
%>
<!-- Added for to display legends in fill stage for inpatient ML-MMOH-CRF-0434 start [IN057356]-->
<td align="center"  style='background-color: blue;font-size:9;font-weight:bold;width:5%;' >&nbsp;<fmt:message key="ePH.NewLegend.label" bundle="${ph_labels}"/></td>
<td align="center"  style='background-color: green;font-size:9;font-weight:bold;width:5%;'><fmt:message key="ePH.RegularLegend.label" bundle="${ph_labels}"/></td>
<td align="center"  style='background-color: yellow;font-size:9;font-weight:bold;width:5%;'><fmt:message key="ePH.HeldLegend.label" bundle="${ph_labels}"/></td>
<!-- Added for ML-MMOH-CRF-0434 End [IN057356] -->
					<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/>  <%=param_legends.get("F")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('WS_RECORD','<%=label_display%>');}" id="allocation_butt" ></td>
<%
				}
				else if((bean.getAdmixtureType()).equals("TD") && tpn_mf_label){ //Added for ml-mmoh-crf-0468
					label_display="YES";
					%>
					<!-- Added for to display legends in fill stage for inpatient ML-MMOH-CRF-0434 start [IN057356]-->
					<td align="center"  style='background-color: blue;font-size:9;font-weight:bold;width:5%;' >&nbsp;<fmt:message key="ePH.NewLegend.label" bundle="${ph_labels}"/></td>
					<td align="center"  style='background-color: green;font-size:9;font-weight:bold;width:5%;'><fmt:message key="ePH.RegularLegend.label" bundle="${ph_labels}"/></td>
					<td align="center"  style='background-color: yellow;font-size:9;font-weight:bold;width:5%;'><fmt:message key="ePH.HeldLegend.label" bundle="${ph_labels}"/></td>
					<!-- Added for ML-MMOH-CRF-0434 End [IN057356] -->
										<%-- <td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("F")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeFilling();}" id="filling_butt"></td> --%>
										<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.FinalizeTPNWorksheet.label" bundle="${ph_labels}"/>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeAllocation('TPN_WS_FINALIZE','<%=label_display%>');}" id="allocation_butt" ></td>
					<%
									}	
				else{
%>
<!-- Added for to display legends in fill stage for inpatient ML-MMOH-CRF-0434 start [IN057356]-->
<td align="center"  style='background-color: blue;font-size:9;font-weight:bold;width:5%;' >&nbsp;<fmt:message key="ePH.NewLegend.label" bundle="${ph_labels}"/></td>
<td align="center"  style='background-color: green;font-size:9;font-weight:bold;width:5%;'><fmt:message key="ePH.RegularLegend.label" bundle="${ph_labels}"/></td>
<td align="center"  style='background-color: yellow;font-size:9;font-weight:bold;width:5%;'><fmt:message key="ePH.HeldLegend.label" bundle="${ph_labels}"/></td>
<!-- Added for ML-MMOH-CRF-0434 End [IN057356] -->
					<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("F")%>' class="button" onClick="if(dispDrugAuthCheck('<%=sDispDrugAuthYN%>')){completeFilling();}" id="filling_butt"></td>
<%
				}
			}
			else if(disp_stage.equals("D")){	//Delivery		
				if (!(fill_list.equals("DWF")) ){
					// 1. getWsStatus == "I or  C" param is WS_FINALIZE
					// 2. getAdmixtureType == "CA" param is CYTO_WS_FINALIZE or "TA" TPN_WS_FINALIZE
					String AdmixtureType =bean.getOrderType();
					if(AdmixtureType.equals("CA")){
						param="CYTO_WS_FINALIZE";
					}
					else if(AdmixtureType.equals("TA")){
						param="TPN_WS_FINALIZE";
					}
					else if(!bean.getWorksheetID().equals("")){
						param="WS_FINALIZE";
					}
if(patient_class.equals("I")){
						%>
					
						<!-- Added for to display legends in deliver stager for in patients ML-MMOH-CRF-0434  [IN057356]start -->
						<td align="center"  style='background-color: blue;font-size:9;font-weight:bold;width:5%;' >&nbsp;<fmt:message key="ePH.NewLegend.label" bundle="${ph_labels}"/></td>
                        <td align="center"  style='background-color: green;font-size:9;font-weight:bold;width:5%;'><fmt:message key="ePH.RegularLegend.label" bundle="${ph_labels}"/></td>
				<!-- Added for ML-MMOH-CRF-0434 End [IN057356] -->
				
				<%	}

%>
						<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=param_legends.get("D")%>' class="button" name="btnDelivery" onClick="recordDelivery('<%=param%>', '<%=p_user_name%>')"></td>
<%
				}
				else{ 
%>
					<!--below condition is added by sureshkumar T for the SRR20056-SCF-5399 [Inc : 24063 ] -->
					<td class='white' width="18%" style="font-size:9;font-weight:bold" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.NoStock.label" bundle="${ph_labels}"/></td>
					<td class='white' width='2%' ><img src='../../eCommon/images/disabled.gif'></td> 
			
					<td align="right" class='white'>&nbsp;<input type="button" value='<fmt:message key="ePH.CompleteDeliver.label" bundle="${ph_labels}"/>' 
					class="button" name="btnDelivery" onClick="if(checkAuthForDWF()){completeFillDelivery('<%=p_user_name%>','<%=Unlock_all_records_yn%>','<%=disp_locn_code%>');}"></td>
<% 
					}
				}
				putObjectInBean(bean_id,bean,request);
%>
					</tr>
					<tr>
					<%if(aggred_item_app && patient_class.equals("O") && !stage.equals("D") && !stage.equals("F") && !(fill_list.equals("DWF")) ){
						%>	
						<td style="BACKGROUND-COLOR:#00FFFF;" width='3%' height="5" align='center'><label style="font-size:9;font-weight:bold;">Brand Item With Alternate</label></td>
						<td style="BACKGROUND-COLOR:#7CFC00;" width='3%' height="5" align='center'><label style="font-size:9;font-weight:bold;">Brand Item Without Alternate</label></td>
						
						<%
						}
						%>
					</tr>
				</table>
					<%if(item_type_site_app ){ %> <!--formulary_billing_app added for GHL-CRF-0618-->
					<tr>
					<%if(!formulary_billing_app){%>
					<td>		
					<td class="white" align="left"><img src="../../ePH/images/LowCost.jpg" height='15' width='15' >&nbsp;
								<td class='white' nowrap><fmt:message key="ePH.LowCostItem.label" bundle="${ph_labels}"/>
								</td >&nbsp;
								<td class="white" align="left"><img src="../../ePH/images/HighMargin.jpg" height='15' width='15' ></td>&nbsp;
								<td class="white" align="left" nowrap><fmt:message key="ePH.HighMarginItem.label" bundle="${ph_labels}"/>&nbsp;
								</td>
								<td class="white" align="left"><img src="../../ePH/images/Innovator.jpg" height='15' width='15' ></td>&nbsp;<td class="white" align="left" nowrap>&nbsp;
								<fmt:message key="ePH.Innovator.label" bundle="${ph_labels}"/>
								</td>
					</td>
					<%}else{ %>
					
							<td class='white' width='1%'></td>	
								 <td class="white" align="left">
									<img src="../../ePH/images/Preference1.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem1.label" bundle="${ph_labels}"/>&nbsp;</td>
												
								<td class="white" align="left">
									<img src="../../ePH/images/Preference2.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem2.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference3.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem3.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference4.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.NonPreferedItem.label" bundle="${ph_labels}"/>&nbsp;</td>
		
			
					</tr>
					<%}
					}%>
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
				<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"	value="<%=userAuthPINYN%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
				<input type="hidden" name="disp_stage" id="disp_stage"	value="<%=disp_stage%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
				<input type="hidden" name="disp_locn_catg" id="disp_locn_catg"	value="<%=disp_locn_catg%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
				<input type="hidden" name="disp_locn_code" id="disp_locn_code"	value="<%=disp_locn_code%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
				<input type="hidden" name="showFillPerson" id="showFillPerson"	value="<%=showpersonName%>"> <!-- added for AMS-CRF-0009[IN:030935]  -->
				<input type="hidden" name="retn_disp_med_for_outstanding" id="retn_disp_med_for_outstanding" value="<%=retn_disp_med_for_outstanding%>"> <!-- added for MMS-QH-CRF-0201 [IN:052255]  -->
				<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>"> <!-- added for MMS-QH-CRF-0201 [IN:052255] -->
				<input type="hidden" name="p_user_name" id="p_user_name" value="<%=p_user_name%>"> <!-- added for MMS-QH-CRF-0201  [IN:052255]-->
				<input type="hidden" name="disp_cash_coll_stage" id="disp_cash_coll_stage" value="<%=disp_cash_coll_stage%>"> <!-- added for MMS-QH-CRF-0201  [IN:052255]-->
				<input type="hidden" name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=displayGrossAmtYn%>"> <!-- added for ML-BRU-CRF-0469-->
			</form>
		</body>
		<script>
<% 
		if(stage.equals("A")) { 
%>
			controlAllocationButton('<%=allocated_status%>');
<% 
		}
		else if(stage.equals("F")) { 
%>
			controlFillingButton('<%=allocated_status%>');
<% 
		}
		else if(stage.equals("AS")) { 
%>
		//controlAllStagesButton();
<%
		}
		if(patient_class.equals("O") ){ //added for Bru-HIMS-CRF-094-DD1 [IN:047224]
			if( dPatientPayable>0){
%>
				displayPayeeIndicator('Y');
<%
			}
			else{
%>
				displayPayeeIndicator('N');
<%
			}
		}
%>
		</script>
<%
	}
	catch ( Exception e ) {
		e.printStackTrace() ;
	}
finally{ // Added for ML-MMOH-SCF-0468 start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-SCF-0468 end

%>
</html>

