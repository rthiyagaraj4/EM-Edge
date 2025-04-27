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
03/01/2022		TFS-26302         Prabha 			 NMC-JD-SCF-0251
---------------------------------------------------------------------------------------------------------------
 
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale = (String) session.getAttribute("LOCALE");

			String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frmDispMedicationOrderDetails" id="frmDispMedicationOrderDetails">
<%
Connection con			= null;  // Added for ML-MMOH-CRF-0468
          try{
			con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
			boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
			boolean encounter_order_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ENCOUNTER_ORDER_CHECK"); //Added for NMC-JD-SCF-0251
			
			String bean_id = "DispMedicationBean";
			String bean_name = "ePH.DispMedicationBean";
			DispMedicationBean bean = (DispMedicationBean) getBeanObject(bean_id, bean_name, request);
			bean.setLanguageId(locale);
			//this function is used to clear modified date values 
			bean.setOrderIDOrderDate();
			bean.setDispencePeriod(bean.getDispLocnCode());

			String patient_id = request.getParameter("patient_id");
			String Order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");//Added for JD-CRF-0181 [IN:45511]
			String enc_id		=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"); //Added for NMC-JD-SCF-0251
			bean.setCollectorDtlsFlag("N");
			String disp_stage = bean.getDispStage();
			String filling_status = bean.getFillingStatus();
			String disp_locn_catg = bean.getDispLocnCatg();
			ArrayList arrTokenList = new ArrayList();//Added for HSA-CRF-0136 [IN:048412]
			String disp_level = bean.getDispLevelValue();
			if (disp_level.equals("")) {
				disp_level = "O";
				bean.setDispLevelValue(disp_level);
			}
			String token_yn = bean.getIssueTokenOnRegnYN();//Adde here for below for ML-BRU-SCF-1870
			if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {//Adding start for ML-BRU-SCF-1870
				//bean.getOrderlingFacilityID(patient_id.trim());
			}//Adding end for ML-BRU-SCF-1870 and commented for SKR-SCF-1512
			ArrayList result = bean.getOrders(patient_id.trim());
			ArrayList IVlegends = (ArrayList)bean.getIVLegends();
			String[] strIVLegends = new String[5];
			int k = 0;

			for(int i=1;i<IVlegends.size();i=i+2){
				strIVLegends[k++]  = (String) IVlegends.get(i); 
			}
			/*boolean displayFacility = false;
			 for(int i=0;i<result.size();i=i+10){
			 if(result.get(i+5)!=null){
			 displayFacility = true;
			 break;
			 }
			 }*/
			HashMap hmEncbasedRecs = new HashMap(); //added  for SKR-SCF-0330 ICN 29789
			String encounter_id=""; //added  for SKR-SCF-0330 ICN 29789
			/*String tapered_yn=""; //added  for SKR-SCF-0330 ICN 29789
			String taper_order_id=""; //added  for SKR-SCF-0330 ICN 29789*/
			ArrayList[] alResults = null;//new ArrayList[11];		
			int iOrderTypeCode = -1, iFirstOrderTypeCode=-1;
			for (int i = 0; i < result.size(); i = i + 11) {	//10 ->11  for SKR-SCF-0330 ICN 29789   //Modified for RUT-CRF-0088 [IN036978] 13->11
				 //added  for SKR-SCF-0330 ICN 29789 -Start
				if(!Order_id.equals("")){//Added for JD-CRF-0181 [IN:45511]
					if(result.get(i+1).equals(Order_id)){
						encounter_id = result.get(i+10)==null?"11111":(String)result.get(i+10);
				
						if(hmEncbasedRecs.containsKey(encounter_id))
							alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);
						else{
							alResults= new ArrayList[11];
							for (int indx = 0; indx < 11; indx++) {		
								alResults[indx] = new ArrayList();
							}
						}
						//added  for SKR-SCF-0330 ICN 29789 -End
						if(result.get(i + 8) == null)
							iOrderTypeCode =  0;
						else if (result.get(i + 8).toString().equals("0"))
							iOrderTypeCode = 10;
						else
							iOrderTypeCode = Integer.parseInt(result.get(i + 8).toString());
						if(iFirstOrderTypeCode == -1)
							iFirstOrderTypeCode = iOrderTypeCode;

						for (int j = 0; j < 11; j++) {	//10 ->11 for SKR-SCF-0330 ICN 29789  	//Modified for RUT-CRF-0088 [IN036978]  13->11
							alResults[iOrderTypeCode].add(result.get(i + j));	
						}
						hmEncbasedRecs.put(encounter_id, alResults);  //added  for SKR-SCF-0330 ICN 29789
					}
				}
				else{
					encounter_id = result.get(i+10)==null?"11111":(String)result.get(i+10);
				
					if(hmEncbasedRecs.containsKey(encounter_id))
						alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);
					else{
						alResults= new ArrayList[11];
						for (int indx = 0; indx < 11; indx++) {		
							alResults[indx] = new ArrayList();
						}
					}
				 	//added  for SKR-SCF-0330 ICN 29789 -End
					if(result.get(i + 8) == null)
						iOrderTypeCode =  0;
					else if (result.get(i + 8).toString().equals("0"))
						iOrderTypeCode = 10;
					else
						iOrderTypeCode = Integer.parseInt(result.get(i + 8).toString());
					if(iFirstOrderTypeCode == -1)
						iFirstOrderTypeCode = iOrderTypeCode;

					for (int j = 0; j < 11; j++) {	//10 ->11 for SKR-SCF-0330 ICN 29789  	//Modified for RUT-CRF-0088 [IN036978]  13->11
						alResults[iOrderTypeCode].add(result.get(i + j));	
					}
					hmEncbasedRecs.put(encounter_id, alResults);  //added  for SKR-SCF-0330 ICN 29789
				}
				if(i==0){ //if block added for ICN 31563 
					bean.setEncounterID(encounter_id);
				}
			}

			List encounterList = new ArrayList(hmEncbasedRecs.keySet());  //added  for SKR-SCF-0330 ICN 29789

			String bean_id_1 = "DispMedicationAllStages";
			String bean_name_1 = "ePH.DispMedicationAllStages";

			DispMedicationAllStages bean_1 = (DispMedicationAllStages) getBeanObject(bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);
			bean_1.clearPatient(patient_id);
			bean_1.addPatient(patient_id);
			bean.setTodaysDate();//added for GHL-SCF-1244 
			//HashMap pat_details = (HashMap)bean_1.getPatient();
			bean_1.setModuleId("2");
			bean_1.setObject(bean);

			String group_by_patient = bean.getChkGroupByPatient();
			if (group_by_patient == null)
				group_by_patient = "E";
			if (group_by_patient.equals(""))
				group_by_patient = "E";

			// Store the collector details in bean
			String date_time = bean.getTodaysDateTime();

			ArrayList arr_list = bean.getPatientDetails();
			int index = arr_list.indexOf(patient_id);

			String collected_by = "";
			String nationality = "";
			String gender = "";
			//code added on 2/5/2004 to set patient_id ...
			bean.setPatientID(patient_id);
			if (arr_list.size() > 0) {
				collected_by = (String) arr_list.get(index + 1);
				nationality = (String) arr_list.get(index + 2);
				gender = (String) arr_list.get(index + 3);
			}

			String dispensed_by = bean_1.getPharmacistID();
			String disp_locn_code = bean.getDispLocnCode();
			String token_series = bean.checkForNull(bean.getTokenSeriesCode());

			StringBuffer orderIDS_trxRefIDS = new StringBuffer();

			if (disp_locn_catg.equals("I")) {
				bean.setIssueTokenOnRegnYN("N");
			}

		//	String token_yn = bean.getIssueTokenOnRegnYN();//Commented here and added above for ML-BRU-SCF-1870
			if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {
				bean.setDeliveryDetails(collected_by, gender, nationality, dispensed_by, date_time, token_series, "", "", "");
			} 
			else {
				bean.setDeliveryDetails(collected_by, gender, nationality,dispensed_by, date_time, "", "", "");
			}
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="orderdetailstable">
<%
				//if (disp_level.equals("O") || disp_level.equals("")) {
				if (group_by_patient.equals("D")){
%>
					<td class="COLUMNHEADER" style="font-size:9" width="15%">
						<fmt:message key="Common.OrderDate.label" bundle="${common_labels}" />
					</td>
					<td class="COLUMNHEADER" style="font-size:9" width="15%">
						<fmt:message key="Common.OrderDate.label" bundle="${common_labels}" />
						<fmt:message key="Common.OrderID.label" bundle="${common_labels}" />
					</td>
					<td class="COLUMNHEADER" style="font-size:9" width="15%">
						<fmt:message key="Common.practitioner.label" bundle="${common_labels}" />
					</td>
					<td class="COLUMNHEADER" style="font-size:9" width="14%">
						<fmt:message key="Common.Location.label" bundle="${common_labels}" />
					</td>
					<td class="COLUMNHEADER" style="font-size:9" width="14%">
						<fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}" />
					</td>
<%
				}
				//}

				String classvalue = "";
				String token_no = "", pract_name,strLocation;
				int recCount = 0, encRecCount=0; // encRecCount added for KAUH-SCF-0061 [IN:034820]
				String iv_prep_yn = null;
				//added for GHL-CRF-0453 - start
				String print_value = "";
				String min_value   = "0";//GHL-CRF-0453
				String max_value   = "0";//GHL-CRF-0453
				String print_msg   = "";
				String print_spilt = "";//GHL-CRF-0453
				HashMap printValueForOrders = bean.getPrintValueForOrders(); //CRF-453
				//added for GHL-CRF-0453 - end
				if (bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR") || (tpn_mf_label && bean.getCriteriaOrderType().equals("TD"))){//TD added for ml-mmoh-crf-0468 // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					iOrderTypeCode = -1;
					 //added  for SKR-SCF-0330 ICN 29789 -Start
					if(hmEncbasedRecs!=null && hmEncbasedRecs.size()>0){ 
						for(int encCount=0; encCount<encounterList.size(); encCount++){ 
							encounter_id = (String) encounterList.get(encCount)==null?"":(String) encounterList.get(encCount); 
							alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);  
							if(encCount==0){ //if block added for ICN 31563 
								bean.setEncounterID(encounter_id);
							}
							//Added for NMC-JD-SCF-0251
							String order_checked = "";
							String order_disabled="disabled";
							if(encounter_order_check){
								if(enc_id.equals(encounter_id)){
									order_checked="checked";
									order_disabled="";
								}
							}
							//Added for NMC-JD-SCF-0251
%>
							<TR>
								<td colspan ="8" ><font style="font-size:12">&nbsp;&nbsp;<B><%=encounter_id.equals("11111")?"&nbsp;":encounter_id %></B></font>
								<input type="hidden" name="encounterId_<%=encCount%>" id="encounterId_<%=encCount%>" value="<%=encounter_id%>"> 
								</td>
							</TR>
<%
							 //added  for SKR-SCF-0330 ICN 29789 -End
							for(int j=0;j<11;j++){
								encRecCount = 0; // added for KAUH-SCF-0061 [IN:034820]
								result = (ArrayList)alResults[j];
								if(result != null && result.size() >0){
									if(result.get(8) == null)
										iOrderTypeCode =  0;
									else if (result.get(8).toString().equals("0"))
										iOrderTypeCode = 10;
									else
										iOrderTypeCode = Integer.parseInt(result.get(8).toString());
									//iOrderTypeCode = result.get(8) == null?10:Integer.parseInt(result.get(8).toString());
									if(iOrderTypeCode == 0){
%>
										<TR><td colspan ="8" class="commontoolbarfunction"><input type ="checkbox" name = "OrderType_<%=encCount%>_<%=j%>" <%=order_checked%>  onclick="uncheckOtherBoxes('<%=encCount%>','<%=j%>',this,'<%=recCount%>','<%=iOrderTypeCode%>')"><font style="font-size:11"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></font> </td> </TR> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									else if(iOrderTypeCode == 10){
%>
										<TR><td colspan = 8 class="commontoolbarfunction"><input type ="checkbox" name = "OrderType_<%=encCount%>_<%=j%>" <%=order_checked%> onclick="uncheckOtherBoxes('<%=encCount%>','<%=j%>',this,'<%=recCount%>','<%=iOrderTypeCode%>')"><font style="font-size:11"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></font></td> </TR> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									else if( iOrderTypeCode> 0 && iOrderTypeCode <6){
%>
										<TR><td colspan = 8 class="commontoolbarfunction"><input type ="checkbox" name = "OrderType_<%=encCount%>_<%=j%>" <%=order_checked%> onclick="uncheckOtherBoxes('<%=encCount%>','<%=j%>',this,'<%=recCount%>','<%=iOrderTypeCode%>')"><font style="font-size:11"> <%=strIVLegends[iOrderTypeCode-1]%></font></td></TR> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									else if( iOrderTypeCode == 6){
%>
										<TR><td colspan = 8 class="commontoolbarfunction"><input type ="checkbox" name = "OrderType_<%=encCount%>_<%=j%>" <%=order_checked%> onclick="uncheckOtherBoxes('<%=encCount%>','<%=j%>',this,'<%=recCount%>','<%=iOrderTypeCode%>')"><font style="font-size:11"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/></font> </td> </TR> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									else if( iOrderTypeCode == 7){
%>
										<TR><td colspan = 8 class="commontoolbarfunction"><input type ="checkbox"  name = "OrderType_<%=encCount%>_<%=j%>" <%=order_checked%> onclick="uncheckOtherBoxes('<%=encCount%>','<%=j%>',this,'<%=recCount%>','<%=iOrderTypeCode%>')"><font style="font-size:11"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></font></td> </TR> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									else if( iOrderTypeCode == 8){
%>
										<TR><td colspan = 8 class="commontoolbarfunction"><input type ="checkbox" name = "OrderType_<%=encCount%>_<%=j%>"  <%=order_checked%> onclick="uncheckOtherBoxes('<%=encCount%>','<%=j%>',this,'<%=recCount%>','<%=iOrderTypeCode%>')"><font style="font-size:11"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></font></td> </TR> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									else if(iOrderTypeCode == 9){
%>
										<TR><td colspan = 8 class="commontoolbarfunction"><input type ="checkbox" name = "OrderType_<%=encCount%>_<%=j%>" <%=order_checked%> onclick="uncheckOtherBoxes('<%=encCount%>','<%=j%>',this,'<%=recCount%>','<%=iOrderTypeCode%>')"><font style="font-size:11"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/> </font></td> </TR> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
								}
								k=0; // This is used to set the index for the second level checkboxes
								if(token_series.equals("*A"))//Added for HSA-SCF-0081 [IN:050227]
									token_series="";
								for (int i = 0; i < result.size(); i=i+11, recCount++) { //10-->11	//Modified for RUT-CRF-0088 [IN036978] 13->11
									encRecCount++; // added for KAUH-SCF-0061 [IN:034820]
									iv_prep_yn = (String) result.get(i + 8);
									bean_1.addPrescription(patient_id, (String) result.get(i + 1));
									//tapered_yn =(String)result.get(i + 11)==null?"":(String)result.get(i + 11); // Commented for RUT-CRF-0088 [IN036978] 
									//taper_order_id =(String)result.get(i + 12)==null?"":(String)result.get(i + 12);

									//HashMap pat_details_1 = (HashMap)bean_1.getPatient();
									if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {
										//token_no	=	bean.getTokenDetails(disp_locn_code,patient_id,token_series,(String)result.get(i+1));
										token_no = bean.getTokenNo();
										if (!token_no.equals("") && !token_series.equals(""))//Condition && !token_series.equals("") added for HSA-CRF-0136 [IN:048412]
											bean_1.setTokenVals((String) result.get(i + 1), token_series+"_"+token_no);//Moved here for HSA-CRF-0136 [IN:048412]
										if (token_no.equals("") || token_series.equals("")) {//Condition || token_series.equals("") added for HSA-CRF-0136 [IN:048412]
											arrTokenList = bean.getTokenDetails(disp_locn_code, patient_id, token_series, (String) result.get(i + 1));
											if(arrTokenList!=null && arrTokenList.size()>0){//Added for HSA-CRF-0136 [IN:048412] start
												token_no = (String)arrTokenList.get(1);
												bean_1.setTokenVals((String) result.get(i + 1), (String)arrTokenList.get(0)+"_"+(String)arrTokenList.get(1));
											}//Added for HSA-CRF-0136 [IN:048412] end
										}
										//bean_1.setTokenVals((String) result.get(i + 1), token_no); //commented for HSA-CRF-0136 [IN:048412] 
									}
									if (disp_level.equals("O")) {
										orderIDS_trxRefIDS = new StringBuffer();
									}
									orderIDS_trxRefIDS.append((String) result.get(i + 1)).append("::").append((String) result.get(i + 9)).append("::");

									if (recCount % 2 == 0)
										classvalue = "QRYODD";
									else
										classvalue = "QRYEVEN";

									// Dispense By Orders
									//if (disp_level.equals("O") || disp_level.equals("")) {
%>
									<!-- added for GHL-CRF-0453 - start-->
									<tr><td width="4%">

<%					//	System.err.println("DispMedicationOrderDetails.jsp=====324=printValueForOrders===dssd====>"+printValueForOrders);
									if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(result.get(i + 1));//GHL-CRF-0453 8/2/2017
											if(print_spilt!=null){//GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(result.get(i + 1))).split("~")[0];
												max_value = ((String)printValueForOrders.get(result.get(i + 1))).split("~")[1];
											}
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationOrderDetails.jsp===print_msg=====346====>"+print_msg);
									}
									if(print_value.equals("1")){
										if(print_msg.equals("F")){
%>
											<img  src="../../ePH/images/printed_fully.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Fully Printed')"></img>

						
<%											}else{ %>
											<img  src="../../ePH/images/printed_partial.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Partially Printed')"></img>


<%											}
									}else{ %>
								&nbsp;
<% 								}
%>
										
										</td>
							<!-- added for GHL-CRF-0453 - end-->
<% 
									if(j==2 || j==4 || j==10 || j==6  || (j==7 && tpn_mf_label)){// only for Admixture orders (single order should be selected)
%>
										<td width="2%"><input type ="checkbox" name = "OrderValues_<%=encCount%>_<%=j%>" <%=order_checked%> <%=order_disabled%> onclick = "selectSingleADM('<%=encCount%>','<%=j%>','<%=k++%>');setIVPrepYN(this,'<%=iv_prep_yn%>');" disabled value="<%=result.get(i + 1)%>"></td> <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									else{
%>
										<td width="2%"><input type ="checkbox" name = "OrderValues_<%=encCount%>_<%=j%>" <%=order_checked%> <%=order_disabled%> onclick ="setIVPrepYN(this,'<%=iv_prep_yn%>');selectTaperOrders(this,'<%=result.get(i + 1)%>','<%=encCount%>','<%=j%>','<%=recCount%>','<%=iOrderTypeCode%>');" value="<%=result.get(i + 1)%>"></td>  <!-- Added for NMC-JD-SCF-0251 -->
<%
									}
									if (token_yn.equals("Y") && (!disp_locn_catg.equals("I"))) {
%>
										<td style="font-size:9" width="13%" class="<%=classvalue%>">
											<%=com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMY","en", locale)%>&nbsp;&nbsp;[<%=token_no%>]
										</td>
<%
										}
										else {
%>
											<td style="font-size:9" width="13%" class="<%=classvalue%>">
												<%=com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMYHM","en", locale)%>
											</td>
<%
										}
										if ((result.get(i)).equals("R")) {

											pract_name = (String) result.get(i + 3);
											/*if(!pract_name.equals("")&&pract_name!=null){
											 pract_name=pract_name.replaceAll(" ","%20");
											 pract_name=	java.net.URLEncoder.encode(pract_name);
											 pract_name=pract_name.replaceAll("%2520","%20");
											 }*/
%>
											<td style="font-size:9" width="13%" class="<%=classvalue%>">
												<b><%=result.get(i + 1)%></b>
												</font>
											</td>
<%
										} 
										else if ((result.get(i)).equals("U")) {
											pract_name = (String) result.get(i + 3);
											/*if(!pract_name.equals("")&&pract_name!=null){
											 pract_name=pract_name.replaceAll(" ","%20");
											 pract_name=	java.net.URLEncoder.encode(pract_name);
											 pract_name=pract_name.replaceAll("%2520","%20");
											 }*/
%>
											<td style="font-size:9" width="13%" class="<%=classvalue%>">
												<b><%=result.get(i + 1)%></b>&nbsp;
												</font>
											</td>
<%
										}
%>
										<td style="font-size:9" width="17%" class="<%=classvalue%>">
											<%=result.get(i + 3)%>&nbsp;
										</td>
<%
										strLocation = "&nbsp;";
										if (result.get(i + 4) == null) {
											strLocation = "";
										} 
										else {
											strLocation = (String) result.get(i + 4);
										}
%>
										<td style="font-size:9" width="15%" class="<%=classvalue%>">
											<%=strLocation%>&nbsp;
										</td>
<%
										if ((((String) result.get(i + 6)).trim()).equals("Y")) {
%>
											<td style="font-size:9" width="10%" class="<%=classvalue%>">
												<font class="HYPERLINK" onclick="showOrderComments('<%=result.get(i + 1)%>')"
													style="cursor:pointer">&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}" />
												</font>
											</td>
<%
										} 
										else {
%>
											<td style="font-size:9" width="10%" class="<%=classvalue%>">
												&nbsp;
											</td>
<%
										}
%>
										<td style="font-size:9" width="14%" class="<%=classvalue%>">
											<%=result.get(i + 5) == null ? "&nbsp;": result.get(i + 5)%>&nbsp;
										</td>
										<%-- <input type='hidden' name='tapered_yn_<%=encCount%>_<%=recCount%>' id='tapered_yn_<%=encCount%>_<%=recCount%>' value='<%=tapered_yn%>'>
										<input type='hidden' name='taper_order_id_<%=encCount%>_<%=recCount%>' id='taper_order_id_<%=encCount%>_<%=recCount%>' value='<%=taper_order_id%>'>--%>
									</tr>
<%
							//}
								}
%>
								<input type="hidden" name="encOrdCount_<%=encCount%>_<%=j%>" id="encOrdCount_<%=encCount%>_<%=j%>" value="<%=encRecCount%>"> <!--added for KAUH-SCF-0061 [IN:034820] -->
<%
							}
						}
					}
				}
				else{
					 //added  for SKR-SCF-0330 ICN 29789 -Start
					if(hmEncbasedRecs!=null && hmEncbasedRecs.size()>0){ 
						for(int encCount=0; encCount<encounterList.size(); encCount++){ 
							encRecCount = 0; // added for KAUH-SCF-0061 [IN:034820]
							encounter_id = (String) encounterList.get(encCount); 
							alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);  
							if(encCount==0){ //if block added for ICN 31563 
								bean.setEncounterID(encounter_id);
							}
%>
							<TR>
								<td colspan ="8" ><font style="font-size:12">&nbsp;&nbsp;<B><%=(String) encounterList.get(encCount)%></B></font>
								<input type="hidden" name="encounterId_<%=encCount%>" id="encounterId_<%=encCount%>" value="<%=encounter_id%>"> 
								</td>
							</TR>
<%
							 //added  for SKR-SCF-0330 ICN 29789 -End
						result = (ArrayList)alResults[iOrderTypeCode]; //0 changed to iOrderTypeCode for ICN 31563
						if(token_series.equals("*A")) //Added for HSA-SCF-0081 [IN:050227]
							token_series="";
						for (int i = 0; i < result.size(); i = i + 11, recCount++) { //10->11 for SKR-SCF-0330 ICN 29789
							encRecCount++; // added for KAUH-SCF-0061 [IN:034820]
							iv_prep_yn = (String) result.get(i + 8);
							bean_1.addPrescription(patient_id, (String) result.get(i + 1));
							//tapered_yn =(String)result.get(i + 11)==null?"":(String)result.get(i + 11); //Commented for RUT-CRF-0088 [IN036978] 
							//taper_order_id =(String)result.get(i + 12)==null?"":(String)result.get(i + 12);
							//HashMap pat_details_1 = (HashMap)bean_1.getPatient();
							if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {
								//token_no	=	bean.getTokenDetails(disp_locn_code,patient_id,token_series,(String)result.get(i+1));
								token_no = bean.getTokenNo();
								if (!token_no.equals("") && !token_series.equals(""))//Condition && !token_series.equals("") added for HSA-CRF-0136 [IN:048412]
									bean_1.setTokenVals((String) result.get(i + 1), token_series+"_"+token_no);//Moved here for HSA-CRF-0136 [IN:048412]
								if (token_no.equals("") || token_series.equals("")) {//Condition || token_series.equals("") added for HSA-CRF-0136 [IN:048412]
									arrTokenList = bean.getTokenDetails(disp_locn_code, patient_id, token_series, (String) result.get(i + 1));//Changed as ArrayList for HSA-CRF-0136 [IN:048412]
									if(arrTokenList!=null && arrTokenList.size()>0){//Added for HSA-CRF-0136 [IN:048412] start
										token_no = (String)arrTokenList.get(1);
										bean_1.setTokenVals((String) result.get(i + 1), (String)arrTokenList.get(0)+"_"+(String)arrTokenList.get(1));
									}//Added for HSA-CRF-0136 [IN:048412] end
								}
								//bean_1.setTokenVals((String) result.get(i + 1), token_no);//commented for HSA-CRF-0136 [IN:048412] 
							}
							if (disp_level.equals("O")) {
								orderIDS_trxRefIDS = new StringBuffer();
							}
							orderIDS_trxRefIDS.append((String) result.get(i + 1)).append("::").append((String) result.get(i + 9)).append("::");

							if (recCount % 2 == 0)
								classvalue = "QRYODD";
							else
								classvalue = "QRYEVEN";
							// Dispense By Orders
							if (disp_level.equals("O") || disp_level.equals("")) {
%>
								<tr>
<%
								if (token_yn.equals("Y") && (!disp_locn_catg.equals("I"))) {
%>
									<td style="font-size:9" width="13%" class="<%=classvalue%>">
										<%=com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMY","en", locale)%>&nbsp;&nbsp;[<%=token_no%>]
									</td>
<%
								} 
								else {
%>
									<td style="font-size:9" width="13%" class="<%=classvalue%>">
										<%=com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMYHM","en", locale)%>
									</td>
<%
								}
								if ((result.get(i)).equals("R")) {

									pract_name = (String) result.get(i + 3);
									/*if(!pract_name.equals("")&&pract_name!=null){
									 pract_name=pract_name.replaceAll(" ","%20");
									 pract_name=	java.net.URLEncoder.encode(pract_name);
									 pract_name=pract_name.replaceAll("%2520","%20");
									 }*/
%>
									<td style="font-size:9" width="13%" class="<%=classvalue%>">
										<font class="HYPERLINK"
											onClick="checkOrderChanges('<%=recCount%>','<%=result.get(i +1)%>' ,'<%=patient_id%>','<%=disp_stage%>','<%=result.get(i + 7)%>','<%=java.net.URLEncoder.encode(pract_name, "UTF-8")%>','<%=filling_status%>','<%=disp_locn_catg%>','<%=group_by_patient%>','<%=iv_prep_yn%>','<%=disp_level%>','<%=java.net.URLEncoder.encode(orderIDS_trxRefIDS.toString())%>')" 
											style="cursor:pointer" id="font_order_id<%=recCount%>"><%=result.get(i + 1)%>
										</font>
									</td>
<%
								} 
								else if ((result.get(i)).equals("U")) {
									pract_name = (String) result.get(i + 3);
									/*if(!pract_name.equals("")&&pract_name!=null){
									 pract_name=pract_name.replaceAll(" ","%20");
									 pract_name=	java.net.URLEncoder.encode(pract_name);
									 pract_name=pract_name.replaceAll("%2520","%20");
									 }*/
%>
									<td style="font-size:9" width="13%" class="<%=classvalue%>">
										<font style="color:brown"
											onClick="checkOrderChanges('<%=recCount%>','<%=result.get(i + 1)%>','<%=patient_id%>','<%=disp_stage%>','<%=result.get(i + 7)%>','<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>','<%=filling_status%>','<%=disp_locn_catg%>','<%=group_by_patient%>','<%=iv_prep_yn%>','<%=disp_level%>','<%=java.net.URLEncoder.encode(orderIDS_trxRefIDS.toString())%>')"
											style="cursor:pointer"><%=result.get(i + 1)%>
										</font>
									</td>
<%
								}
%>
									<td style="font-size:9" width="17%" class="<%=classvalue%>">
										<%=result.get(i + 3)%>&nbsp;
									</td>
<%
									strLocation = "&nbsp;";
									if (result.get(i + 4) == null) {
										strLocation = "";
									} 
									else {
										strLocation = (String) result.get(i + 4);
									}
%>
									<td style="font-size:9" width="15%" class="<%=classvalue%>">
										<%=strLocation%>&nbsp;
									</td>
<%
									if ((((String) result.get(i + 6)).trim()).equals("Y")) {
%>
										<td style="font-size:9" width="10%" class="<%=classvalue%>">
											<font class="HYPERLINK" onclick="showOrderComments('<%=result.get(i + 1)%>')"
												style="cursor:pointer">&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}" />
											</font>
										</td>
<%
									} 
									else {
%>
										<td style="font-size:9" width="10%" class="<%=classvalue%>">
											&nbsp;
										</td>
<%
									}
%>
									<td style="font-size:9" width="14%" class="<%=classvalue%>">
										<%=result.get(i + 5) == null ? "&nbsp;": result.get(i + 5)%>&nbsp;
									</td>
										<%-- <input type='hidden' name='tapered_yn_<%=encCount%>_<%=recCount%>' id='tapered_yn_<%=encCount%>_<%=recCount%>' value='<%=tapered_yn %>'>
										<input type='hidden' name='taper_order_id_<%=encCount%>_<%=recCount%>' id='taper_order_id_<%=encCount%>_<%=recCount%>' value='<%=taper_order_id%>'>--%>
									</tr>
<%
								}
							}
%>
							<input type="hidden" name="encOrdCount_<%=encCount%>_<%=iOrderTypeCode%>" id="encOrdCount_<%=encCount%>_<%=iOrderTypeCode%>" value="<%=encRecCount%>">  <!--added for KAUH-SCF-0061 [IN:034820]-->
<%
						}
					}
				}
%>
			</table>
			<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=bean_id_1%>">
			<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=bean_name_1%>">
			<input type="hidden" name="encounterCount" id="encounterCount" value="<%=encounterList.size()%>"> <!--  added  for SKR-SCF-0330 ICN 29789-->
			<input type="hidden" name="num_of_orders" id="num_of_orders" value="<%=recCount%>">
<%
			if (bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR") || (tpn_mf_label && bean.getCriteriaOrderType().equals("TD")) ){  //Td added for ml-mmoh-crf-0468 // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
%>
				<input type="button" name="getValues" id="getValues" value='<fmt:message key="ePH.ProcessOrders.label" bundle="${ph_labels}" />' onClick="getOrderIds('<%=patient_id%>','<%=disp_stage%>','<%=filling_status%>','<%=disp_locn_catg%>','<%=group_by_patient%>','<%=disp_level%>')">
<%
			}
%>
			<input type="hidden" name="continueSameOrder" id="continueSameOrder" value="">
			<input type="hidden" name="OldTrxOrderIds" id="OldTrxOrderIds" value="">
			<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="">
			<input type="hidden" name="iv_order_id" id="iv_order_id" value="">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
			<input type="hidden" name="firstOrderTypeCode" id="firstOrderTypeCode" value="<%=iFirstOrderTypeCode%>">
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>"><!-- Added for for Bru-HIMS-CRF-081 -->
			<input type="hidden" name="OrderType" id="OrderType" value="<%=bean.getCriteriaOrderType()%>"> <!-- OrderType Added for ML-MMOH-CRF-0435 [IN:057357] -->
		     <input type="hidden" name="tpn_mf_label" id="tpn_mf_label" value="<%=tpn_mf_label%>"> 
		</form>
		<script language="javascript">
		<%//if moved from else block for  GHL-ICN-0013
		if((tpn_mf_label && bean.getCriteriaOrderType().equals("TD"))){// if Added for GHL-ICN-0011
		%>
				   selectFirstOrder();
		<%
		}
		else if(!bean.getCriteriaOrderType().equals("ALL") && !bean.getCriteriaOrderType().equals("CDR")){  // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]//(tpn_mf_label && bean.getCriteriaOrderType().equals("TD") IS REMOVED FOR GHL-ICN-0011
			if(recCount!=0 && disp_level.equals("O")){
%>
					document.getElementById("font_order_id0").click();
<%
				}	
				else{	
%>
					checkOrderChanges('','','<%=patient_id%>','<%=disp_stage%>','','','<%=filling_status%>','<%=disp_locn_catg%>','<%=group_by_patient%>','','<%=disp_level%>','<%=java.net.URLEncoder.encode(orderIDS_trxRefIDS.toString())%>');
<%	
				}
			}
			else{
				if(encounter_order_check){ //Modified for NMC-JD-SCF-0251
%>
				selectFirstOrder1();
<%
			}else{
%>
				selectFirstOrder();
<%			
			}	 //Modified for NMC-JD-SCF-0251
			}
			if(bean.getCurrEncFinancialDtl().equals("Y")){ //code added for JD-CRF-0156[IN041737]--Start
				encounter_id = bean.getEncounterID();
				ArrayList encounterId_details	 = bean.getEpisodeDetails(patient_id,encounter_id); 
				if(encounterId_details.size()>0){
					String 	episode_id		 = (String)encounterId_details.get(0);					
					String  patient_class	 = (String)encounterId_details.get(1);	
					String visit_id="";
					boolean policyValid = bean.getPolicyExp(encounter_id,patient_class,patient_id);
					if(patient_class.equals("OP") &&  encounter_id.length()>4)
						visit_id = encounter_id.substring(encounter_id.length()-4, encounter_id.length());
%>
					setTimeout("displayFinancialDtlIcon('<%=patient_id%>','<%=episode_id%>','<%=visit_id%>','<%=policyValid%>')",'50');;
<%
				}
			}
%>
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</body>
</html>
<%
	putObjectInBean(bean_id, bean, request);
	putObjectInBean(bean_id_1, bean_1, request);
          }
          catch(Exception e){
          	e.printStackTrace();
          }
          finally{ // Added for ML-MMOH-SCF-0468 - start
          	
          	if(con != null)
          		ConnectionManager.returnConnection(con,request);	
          } // Added for ML-MMOH-crf-0468 end
%>

