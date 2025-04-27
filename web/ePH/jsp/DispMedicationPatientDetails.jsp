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
04/13/2017      KDAH-CRF-0338     Devindra/Mukesh    Inclusion of Bed No in the Fill and Deliver screen in Dispense Medication. 
31/12/2021      TFS-6900		 Prabha 			 MOHE-CRF-0040
---------------------------------------------------------------------------------------------------------------
*/ -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<SCRIPT LANGUAGE="JavaScript"> //script added for Bru-HIMS-CRF-094-DD1 [IN:047224]
			function blinkImage(){
				var e;
				try{
					e = document.getElementById("payingPatient");
					if(e.style=='display'){
						e.style.visibility = ( e.style.visibility == 'visible' )? 'hidden' : 'visible';
					}
				}
				catch(e){}
			}
			function blinkPatExp(){
				var e;
				try{
					e = document.getElementById("policy_exp");
					e.style.color = ( e.style.color == 'darkred' )? '#ff0000' : 'darkred';
				}
				catch(e){}
			}
			window.onload = function(){
				window.setInterval("blinkImage()",500);
				window.setInterval("blinkPatExp()",500);
			}
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="" onKeyDown="lockKey()"  topmargin="0">
<%  Connection con			= null;  // Added for ML-MMOH-CRF-0468
try{
	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
	boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
	boolean item_type_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ITEM_TYPE_APP"); // Added for GHL-CRF-0549 - Devindra

		String bean_id			= "DispMedicationBean" ;
		String bean_name		= "ePH.DispMedicationBean";
		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		String	bean_id1				=	"DispMedicationAllStages" ;  // Added for GHL-CRF-0549 - Start
		String	bean_name1			=	"ePH.DispMedicationAllStages";		
		DispMedicationAllStages allStages = (DispMedicationAllStages)getBeanObject( bean_id1, bean_name1,request);
		allStages.setLanguageId(locale);
		bean.setObject(allStages); // Added for GHL-CRF-0549 - End
		String patient_id		= request.getParameter("patient_id");
		String patient_name		= request.getParameter("patient_name");
		   patient_name		= java.net.URLDecoder.decode(patient_name,"UTF-8");
		String encounter_id		= bean.getEncounterID();
		String episode_id		= request.getParameter("episode_id");	//code added for IN045366

		String sex				= request.getParameter("sex");
		String age				= request.getParameter("age");
		String bed_num      = request.getParameter("bed_num")==null?"":request.getParameter("bed_num"); // Added for KDAH-CRF-0338
		String patient_class	= bean.getDispLocnCatg();
		String height			= "";
		String weight			= "";
		String ht_uom			= "";
		String wt_uom			= "";
		ArrayList ht_wt			= bean.getHtWt(patient_id);
		String stages			= bean.getDispStage();
		if(ht_wt.size()!=0 ) {
			height			=	(String)ht_wt.get(0);
			ht_uom			=	(String)ht_wt.get(1);
			weight			=	(String)ht_wt.get(2);
			wt_uom			=	(String)ht_wt.get(3);

			if(weight!=null && !weight.equals("")){ //added for ML-MMOH-SCF-0976 
			 if(Float.parseFloat(weight)<1){
			 weight=Float.parseFloat(weight)+"";
			 }
			}
		}
		if(patient_class.equals("O")){
			patient_class = "OP";
		}
		else {
			patient_class = "IP";
		}

		String disp_locn_code   = bean.getDispLocnCode();
		boolean displayFacility = true;
		String pndng_ord_count  = bean.getPendngOrderCnt(patient_id);
        String primary_blng_grp = ""; // Added for GHL-CRF-0549 - Devindra        
        String bl_encounter =  CommonBean.checkForNull((String)(request.getParameter("encounter_id")));
		allStages.setDisplayInsStatus(con);//Added for TH-KW-CRF-0012
        primary_blng_grp=bean.getPrimaryBillingGroup(patient_class,bl_encounter,patient_id); // Added for GHL-CRF-0549 - Devindra 
		if(sex.equalsIgnoreCase("female"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		else if(sex.equalsIgnoreCase("male"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(sex.equalsIgnoreCase("unknown"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
	<form name="frmPatientDetails" id="frmPatientDetails" >
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="patient_details" >
			<tr>
				<%if(patient_class.equals("IP") && !((String) bean.getFillList()).equals("AF")){ // && !((String) bean.getFillList()).equals("AF") add for with fill list if else conition Added for KDAH-CRF-0338 - Start %>
				<td wrap class="COMMONTOOLBARFUNCTION" width="75%" nowrap><font style="font-size:9px">&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patient_id%>,&nbsp;<fmt:message key="Common.bedno.label" bundle="${common_labels}"/>-<%=bed_num%>
				<%}else{ %>
				<td wrap class="COMMONTOOLBARFUNCTION" width="75%" nowrap><font style="font-size:9px">&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patient_id%>
				<%} // if else conition Added for KDAH-CRF-0338 - End %>
				<label id='payingPatient' style='font:12;color:red;display:none;'><b>&nbsp;[<fmt:message key="ePH.PayingPatient.label" bundle="${ph_labels}"/>]</b></label> <!--payingPatient  added for Bru-HIMS-CRF-094-DD1 [IN:047224] -->
				</td>
				<td class="COMMONTOOLBARFUNCTION" width="25%"><font style="font-size:9px"><fmt:message key="Common.height.label" bundle="${common_labels}"/>:&nbsp; <%=height%>&nbsp;<%=ht_uom%>&nbsp;,&nbsp;<fmt:message key="Common.weight.label" bundle="${common_labels}"/>:&nbsp;<%=weight%>&nbsp;<%=wt_uom%></font></td>
			</tr>
			<tr>
				<td colspan="2">
<% 
				if ((patient_class.equals("OP")) && ( stages .equals("AS") || stages .equals("D"))) {
%>
					<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showOtherOrders('<%=patient_id%>','<%=disp_locn_code %>','<%=encounter_id%>')" ><fmt:message key="ePH.OtherOrders.label" bundle="${ph_labels}"/></font>&nbsp; <!-- Modified for MOHE-CRF-0040 -->
<% 
				}
%>
				<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showAllergicDrug('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></font>
				<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showActiveProblems('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Problems.label" bundle="${common_labels}"/></font>
				<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showCurrentRx('<%=patient_id%>','','','<%=patient_class%>')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></font>
				<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showDemographics('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/></font>
				<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showDrugProfile('<%=patient_id%>','<%=disp_locn_code%>','<%=patient_class%>','<%=bean.getDispMednDrugProfile()%>','<%=bean.getEncounterID()%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></font> <!-- added bean.getDispMednDrugProfile() for  Bru-HIMS-CRF-081 [IN:029947] // encounter_id added for AAKH-CRF-0088.2 -->
				<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showDispDrugs('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Disp.Drugs.label" bundle="${ph_labels}"/></font>		
<%
				if(Integer.parseInt(pndng_ord_count)>0){
%>
					<font style="font-size:13;cursor:pointer;color:#ff0000;" id="pending_ordrs" onClick="showPendingOrders('<%=patient_id%>','<%=disp_locn_code%>')"><B>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></b></font>
					<script>
						XX1=new blinkText("XX1",'pending_ordrs',500,500,'darkred','#ff0000');
					</script>
<%
				}
				else{
%>
					<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showPendingOrders('<%=patient_id%>','<%=disp_locn_code%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></font>
<%
				}
				if(bean.getViewPatientHistoryYN().equals("Y")){
%>
				 <font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="callPatientHistory('<%=patient_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PatientHistory.label" bundle="${common_labels}"/></font>
<%
				} 
				if(stages .equals("D")){
%> 
					<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showReleaseBatch('<%=patient_id%>','<%=disp_locn_code%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.ReleaseBatch.label" bundle="${ph_labels}"/></font><!-- Added for Bru-HIMS-CRF-416[IN045566] -->
<%		
				}		    
				//if(bean.getCurrEncFinancialDtl().equals("Y")){ //code added for JD-CRF-0156[IN041737]--Start
%>	     
					&nbsp;&nbsp;<img src="../../ePH/images/dollar.png" style="cursor:pointer" height="17" title="Current Encounter Financial Details" onclick='callFinancialDetailScreen();' id='imgFinDtl'  style='display:none;'>		 
				<% if(item_type_appl && bean.getBLInterfaceYN().equals("Y")){ // Added for GHL-CRF-0549 - Start - Devindra %>
					<label id="primary_blng_grp" style='color:darkred;'><%=primary_blng_grp%></label> 
				<%}  // Added for GHL-CRF-0549 - End - Devindra %>
					<label id="policy_exp" style='visibility:hidden;color:darkred;'> <font style="font-size:9px;" ><fmt:message key="ePH.PolicyExpired.label" bundle="${ph_labels}"/></font> </label>
<% 
				//}  //code added for JD-CRF-0156[IN041737] --End  
				if(bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR") ||( bean.getCriteriaOrderType().equals("TD") && tpn_mf_label)  ) { // TD added for ml-mmoh-crf-0468 CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
%>
					</td>
					<TD>
						<img src="../../ePH/images/max.gif" id ="expand" value="expand" style="cursor:pointer" onClick="expandFrame();" height="20" title=""> 
<%
				}
%>
				</td>
			</tr>
<%
			String disp_level		= bean.getDispLevelValue();
			String token_yn			= bean.getIssueTokenOnRegnYN();
			if(disp_level.equals("")) {
				disp_level	=	"O";
				bean.setDispLevelValue(disp_level);
			}
			//if(!patient_class.equals("IP") && !disp_level.equals("P")){
			//out.println("<script>alert('"+disp_level+"');</script>");
			if(disp_level.equals("O")){
%>
				<tr>
					<td colspan="2">
						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<%
						if(token_yn.equals("Y")) { 
%>
							<td class="COLUMNHEADER" style="font-size:9px" width="14%"><fmt:message key="ePH.OrderDate/TokenNo..label" bundle="${ph_labels}"/></td>
<%
						}
						else{
%>
							<td class="COLUMNHEADER" style="font-size:9px" width="14%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
<%
						}
%>
						<td class="COLUMNHEADER" style="font-size:9px" width="13%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" style="font-size:9px" width="18%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" style="font-size:9px" width="15%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" style="font-size:9px" width="10%"><fmt:message key="ePH.OrderRemarks.label" bundle="${ph_labels}"/></td>
<%
						if(displayFacility==true){
%>
							<td class="COLUMNHEADER" style="font-size:9px" width="14%"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
<%
						}
%>
						</table>
					</td>
				</tr>
<%
			}
%>
			</table>
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
			<input type="hidden" name="patient_id" id="patient_id" value="">
			<input type="hidden" name="episode_id" id="episode_id" value="">
			<input type="hidden" name="visit_id" id="visit_id" value="">
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id1,allStages,request);
}
catch(Exception e){
	e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-0468 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-0468 end
%>

