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
31/12/2021		TFS-6900		Prabha			MOHE-CRF-0040
29/11/2023						Sushant Tambe	MMS-DM-CRF-0228
---------------------------------------------------------------------------------------------------------------
*/ -->   

 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- Modified for MOHE-CRF-0074 -->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%			
System.out.println("==============in==========>DispMedicationQueryCriteria.jsp");  
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script type="text/javascript" src="../../eCommon/js/dchk.js"></script>		
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="frmDispMedicationQueryCriteria" id="frmDispMedicationQueryCriteria" >
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
	try{
	  con				= ConnectionManager.getConnection(request);
	  boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	   boolean mobile_no_search=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_MOBILE_NO");//Added for TH-KW-CRF-0014
	   boolean ph_print_prescription  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_PRINT_PRESCRIPTION"); //Added for MMS-DM-CRF-0228
	// Added for MOHE-CRF-0074 - END
	String facility_id			= (String) session.getValue("facility_id");
			
	boolean isSite_integration_em_bd_pyxis	= false;
	isSite_integration_em_bd_pyxis =  eCommon.Common.CommonBean.isSiteSpecific(con,"PH","PH_INTEGRATION_EM_BD_PYXIS");//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
			String bean_id = "DispMedicationBean" ;
			String bean_name = "ePH.DispMedicationBean";
			DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
			String disp_locn_name   = bean.getDispLocnName();
				   disp_locn_name   = java.net.URLDecoder.decode(disp_locn_name,"UTF-8");
			String disp_stage       = bean.getDispStage();
			String IssueTokenOnRegnYN       = bean.getIssueTokenOnRegnYN();
			Hashtable param_legends = bean.getLegendsFromParam();
			String grp_by_lbl		=	"";
			//String dateLegendValue	= "Order Date From";//code commented for Bru-HIMS-CRF-418[IN045564] 
			String function_id		   = CommonBean.checkForNull(request.getParameter("function_id"));
			String homepage		   = CommonBean.checkForNull(request.getParameter("homepage"));
			bean.clearCriteriaValues();
			bean.setTabBasegGroupSortDisp();//Added for ML-MMOH-CRF-1666 
			String tab_based_group_sort_disp = bean.getTabBasegGroupSortDisp();
			DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);//Added for Bru-HIMS-CRF-072.1[IN 049144] start
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); 
			medplan_bean.setObject(all_bean);
			medplan_bean.setObject(bean);
			medplan_bean.setStrPrimaryLangID("en");
			String loc_lang_id = all_bean.getSMLOcalLanguageID();
			medplan_bean.setStrLocalLangID(loc_lang_id);
			medplan_bean.getHeaderDetails();//Added for Bru-HIMS-CRF-072.1[IN 049144] end
			all_bean.setDefaultBmsDispLoc(all_bean.getDefaultBmsCollDispLoc(bean.getDispLocnCode()));// Added for HSA-CRF-0113 [IN:048166] 
			//bean.getDefaultNationality();
			String add_criteria_nat_desc	=	bean.getAddCriteriaNatDesc();
			/*String disp_stage_name = "";
			if(disp_stage.equals("V")){
				disp_stage_name = (String)param_legends.get("V");
			}else if(disp_stage.equals("A")){
				disp_stage_name = (String)param_legends.get("A");
			}else if(disp_stage.equals("F")){
				disp_stage_name = (String)param_legends.get("F");
			}else if(disp_stage.equals("B")){
				disp_stage_name = (String)param_legends.get("B");
			}else if(disp_stage.equals("D")){
				disp_stage_name = (String)param_legends.get("D");
			}else if(disp_stage.equals("AS")){
				disp_stage_name = "All Stages";
			}*/
			/*String disableScope="";
			if(!disp_stage.equals("AS")){
				disableScope = "disabled";
			}else{
				disableScope = "";
			}*/
			
			
			///* Below else if Condition  Added  by Himanshu For MMS-DM-CRF-0232 Starts
			//ArrayList result = bean.checkToProceed(facility_id.trim(),"DispMedication");
			ArrayList result = bean.checkToProceed1(facility_id.trim(),"DispMedication","OUT");
			String disp_locn_details="";
			if(result.size()>0) {
				disp_locn_details =(String)result.get(0);
			}
			StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
			int no_of_disp_locns = stdisp_locn_details.countTokens();
			///* Below else if Condition  Added  by Himanshu For MMS-DM-CRF-0232 Ends
			
			
			String ord_date_from="";
			String ord_date_to="";
			String order_facility_id="";
			String order_facility_name="";
			
			String issue_token_on_regn = bean.getIssueTokenOnRegnYN();
			//out.println("issue_token_on_regn:"+issue_token_on_regn);
			if(issue_token_on_regn.equals("")){
				issue_token_on_regn="N";
			}
			/*if(issue_token_on_regn.equals("N")){
				ord_date_from = bean.getTodaysDate();
				ord_date_to   = bean.getTodaysDate();
			}else{*/ //if block and else condition commented for  ML-BRU-SCF-0636 [IN:036826]
				// Remove facility_id in ord_date_to and  Add two lines for SRR20056-SCF-7807[28329] 
				bean.getFromToDate(facility_id, "OP"); //"OP" added for  AMS-CRF-0009[IN:030935]
				ord_date_from	=bean.getFromDate();		
				ord_date_to   = bean.getToDate(); 
				//ord_date_from = bean.getTodaysDate();
				//ord_date_to   = bean.getToDate(facility_id);
			//}	
			bean.setDispDfltDisplay_YN("N"); // Added For SRR20056-CRF-0663
			ArrayList OrderingFacility=bean.getOrderingFacilityId(p_user_name);
			//code for loading iv legends based ph_param setup 9/27/2005
			ArrayList IVlegends = (ArrayList)bean.getIVLegends();
			String ivlegend_option  = "";	
			for(int i=0;i<=IVlegends.size()-2;i=i+2){
				if(function_id.equals("PH_PREPARE_ADMIXTURE")){
					if(i==2||i==6){
						ivlegend_option		=ivlegend_option+	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>";
					}
				}
				else{
					ivlegend_option		=ivlegend_option +	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>"; 
				}
			}
			
		  //till here
			String disp_level = bean.getDispLevel();
			if(disp_level==null) 
				disp_level="";
			String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
			ArrayList region_code_check = bean.getRegionCheckNew(region_code); //Added for MOHE-CRF-0074 //Modified for MOHE-CRF-0074
					
			//added for MMS-DM-CRF-0228 start
			String todayDateTime = bean.getTodaysDateTime();
			String fromDateTime = "";
			String toDateTime = "";
					if(ph_print_prescription)
					{
						fromDateTime = com.ehis.util.DateUtils.minusDate(todayDateTime, "DMYHM", locale, 7, "d");
						toDateTime = com.ehis.util.DateUtils.plusDate(todayDateTime, "DMYHM", locale, 7, "d");
					}
			//added for MMS-DM-CRF-0228 end	
%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
				<tr>
					<td class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/>&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;<select name="OrderingFacility" id="OrderingFacility" onChange="ClearNursingUnit1()" style="width:200;">
<%			if(region_check){ //MOHE-CRF-0074-Start 
		   for (int i=0;i<region_code_check.size();i+=2){
				order_facility_id=(String)region_code_check.get(i);
				order_facility_name=(String)region_code_check.get(i+1);
				if(facility_id.equals(order_facility_id))	{
%>
				<option value='<%=order_facility_id%>' selected><%=order_facility_name%></option>
<%
			}
			else{
%>
				<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
					}
				}
			}else{ //Added for MOHE-CRF-0074-End
					for (int i=0;i<OrderingFacility.size();i+=2){
						order_facility_id=(String)OrderingFacility.get(i);
						order_facility_name=(String)OrderingFacility.get(i+1);
						if(facility_id.equals(order_facility_id))	{
%>
							<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
<%
						}
						else{
%>
		   					<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
						}
					}
	} //Added for MOHE-CRF-0074
%>
					</SELECT>
					</td>
					<!-- Added for JD-CRF-0181 [IN:40699] -->
					<td class="label"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/> </td>
					<td   class="label">
						<input type="text" name="order_id" id="order_id"  size="20" maxlength="15" onBlur="fetchRecord(this);" onfocus="this.select();" onkeydown="if (event.keyCode==13) {fetchRecord(this);}" onkeypress="return CheckForSpecChars(event)" value=""><!-- Added 'fetchRecode(this)' for JD-CRF-0181 [IN:045355] -->
					</td>
					<td  class="label">Scope</td>
					<td >&nbsp;&nbsp;
						<select name="order_status" id="order_status"  onChange="checkScope(this)">
<%
						if(disp_stage.equals("D")){
%>
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="EX"><fmt:message key="Common.ExternalPrescriptions.label" bundle="${common_labels}"/></option>
<%
						} 
						else 	if(!disp_stage.equals("AS")){
%>
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="H"><fmt:message key="ePH.Dept.OrderonHold.label" bundle="${ph_labels}"/></option>
							<option value="EX"><fmt:message key="Common.ExternalPrescriptions.label" bundle="${common_labels}"/></option>
<%
						}
						else{ 
%>
							<!-- <option value="A">All Prescriptions</option> -->
							<option value="" >----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="P" ><fmt:message key="ePH.NewPrescriptions.label" bundle="${ph_labels}"/></option>
							<option value="PD"> <fmt:message key="ePH.NewandDischargemedication.label" bundle="${ph_labels}"/></option>
							<option value="B"> <fmt:message key="ePH.BMSPrescriptions.label" bundle="${ph_labels}"/></option>
							<option value="R"> <fmt:message key="ePH.RefillPrescriptions.label" bundle="${ph_labels}"/></option>
							<option value="D"> <fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></option>
							<option value="H"> <fmt:message key="ePH.Dept.OrderonHold.label" bundle="${ph_labels}"/></option>
							<option value="E"> <fmt:message key="ePH.ExpiredPrescriptions.label" bundle="${ph_labels}"/></option>
							<option value="EX"><fmt:message key="Common.ExternalPrescriptions.label" bundle="${common_labels}"/></option>
<%
						}
%>
						</select>
					</td>			
				</tr>
				<tr id="row1"> <!-- code ' id="row1" 'added for Bru-HIMS-CRF-416[IN045566] -->
					<td  class="label" nowrap id="dateLegend"> <fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td> <!--code 'dateLegendValue' replaced by <fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/> for Bru-HIMS-CRF-418[IN045564]  -->
					<td  >&nbsp;&nbsp;
						
<%
						if(ph_print_prescription){//Added for MMS-DM-CRF-0228
%>						<input type="text" name="order_date_from" id="order_date_from"  size="15" maxlength="16" onBlur="validateDate();" id="order_date_from" value="<%=com.ehis.util.DateUtils.convertDate(fromDateTime,"DMYHM","en",locale) %>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='from_time_calendar' onClick=" showCalendar('order_date_from',null,'hh:mm');document.frmDispMedicationQueryCriteria.order_date_from.focus();return false;" >
<%						}
						else{
%>						<input type="text" name="order_date_from" id="order_date_from"  size="8" maxlength="10" onBlur="if(CheckDateT(this,'<%=locale%>')) validateDate();" value="<%=com.ehis.util.DateUtils.convertDate(ord_date_from,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_from');document.frmDispMedicationQueryCriteria.order_date_from.focus();return false;" >
<%						}
%>					</td>
					<td  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td  >&nbsp;&nbsp;
<%
						if(ph_print_prescription){//Added for MMS-DM-CRF-0228
%>						<input type="text" name="order_date_to" id="order_date_to"   size="15" maxlength="16" onBlur="validateDate();" id="order_date_to" value="<%=com.ehis.util.DateUtils.convertDate(toDateTime,"DMYHM","en",locale) %>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='to_time_calendar' onclick="showCalendar('order_date_to',null,'hh:mm');document.frmDispMedicationQueryCriteria.order_date_to.focus();return false;" > 
<%						}
						else{
%>						<input type="text" name="order_date_to" id="order_date_to" size="8" maxlength="10" onBlur="if(CheckDateT(this,'<%=locale%>')) validateDate()" value="<%=com.ehis.util.DateUtils.convertDate(ord_date_to,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_to');document.frmDispMedicationQueryCriteria.order_date_to.focus();return false;" >
<%						}
%>		
					</td>
					<td  class="label"><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/></td>
					 <td >&nbsp;&nbsp;	
<%
				if(function_id.equals("PH_PREPARE_ADMIXTURE")){
%>
					<select name="order_type" id="order_type" onChange="defaultDispLevel(document.frmDispMedicationQueryCriteria,this)">				
						<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>					
						<%=ivlegend_option%>					
						<!-- <option value="TA"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option> -->
						<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
					</select>
<%
					}
					else{
%>
						<select name="order_type" id="order_type" onChange="defaultDispLevel(document.frmDispMedicationQueryCriteria,this)">
							<option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="NOR"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
							<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
							<%=ivlegend_option%>
							<!-- <option value="TD"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option> -->
							<option value="CD"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
							<!-- <option value="TA"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option> -->
							<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
							<option value="CDR"><fmt:message key="ePH.CDROrders.label" bundle="${ph_labels}"/></option> <!-- Added for ML-MMOH-CRF-0435 [IN:057357] -->
						</select>
<%
					}
%>
					&nbsp;<label class="label" id="lbl_nationality" style="font-weight:bold;display:none" ><%=add_criteria_nat_desc%></label>
				</td>
				</tr>
				<tr id="row2"> <!-- code ' id="row2" 'added for Bru-HIMS-CRF-416[IN045566] -->
					<td  class="label" nowrap><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
<%
					if(disp_level.equals("O") || disp_level.equals("")) {
						grp_by_lbl	=	"Order Wise";
					} 
					else {
						grp_by_lbl	=	"Patient Wise";
					}
%>
					<td >&nbsp;&nbsp;	
<%
					if((bean.getFunctionIdentity()).equals("PrepareAdmixture")){
%>
						<label class="label" id="lbl_admixture_type"><b><fmt:message key="ePH.AllAdmixtures.label" bundle="${ph_labels}"/></b></label>
<%
					}
					else{
%>
						<label class="label" id="lbl_disp_level" name="lbl_disp_level"><b><%=grp_by_lbl%></b></label>
<%
					}
%>
					<input type="checkbox" name="chk_group_by_patient" id="chk_group_by_patient" value="E" checked style="visibility:hidden">&nbsp;
				</td>
				<td> </td>
				<td> </td>
<%            if(mobile_no_search){//Adding start for TH-KW-CRF-0014
%>
			    	<td  class="label" nowrap><%=bean.getNationID()%></td>
				     	<td class="label">&nbsp;
							<input type="text" name="national_id_no" id="national_id_no" maxlength="20" size="20" onKeyPress="return CheckForSpecChars(event)" value="">
						</td>
<%}else{%>
                <input type="hidden" name="national_id_no" id="national_id_no" value="" >
<%}//Adding end for TH-KW-CRF-0014%>
				<!--<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
				<td   class="label">&nbsp;&nbsp;
					<b><%/*=disp_locn_name*/%></b>
					<input type="hidden" name="disp_locn_name" id="disp_locn_name" value="<%/*=disp_locn_name*/%>" readOnly>
				</td>

				<td  class="label" nowrap><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
				<td   class="label">&nbsp;&nbsp;			
						<b> <%/*= disp_stage_name*/ %> </b>&nbsp;&nbsp;<label class="label" id="lbl_nationality" style="font-weight:bold"><%/*=add_criteria_nat_desc*/%></label>
				</td>-->
			</tr>			
			<tr id="row3">
				<td  class="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				<td  >&nbsp;&nbsp;
					<select name="priority" id="priority">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td  class="label" nowrap><fmt:message key="ePH.DispenseLevel.label" bundle="${ph_labels}"/></td>
				<td >&nbsp;&nbsp;	
					<select name="disp_level" id="disp_level">
<%
					if(!function_id.equals("PH_PREPARE_ADMIXTURE")){
						if( (disp_level).equals("O")) {
%>
							<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
							<option value="P"><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<% 
						} 
						else if( (disp_level).equals("P")) {
%>
							<option value="O"><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
							<option value="P" selected><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<%
						} 
						else {	
%>
							<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
							<option value="P"><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<%
						}
					}
					else{
%>
						<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
<%
					 }
%>
					</select>
				</td>
<%
				if(IssueTokenOnRegnYN!=null && IssueTokenOnRegnYN.equals("N")){
%>
					<td  class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;
						<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="18" value="" onKeyPress="uppercase()"><input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()" >
					</td>
<%
				}
				else{//else block added for [IN:054559] 
%>
						<input type="hidden" name="patient_id" id="patient_id" value="" >
<%
				}
%>
			</tr>
			<tr id="row4">
				<td  class="label" nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
				<td  colspan=>&nbsp;&nbsp;
					<select name="ord_loc_type" id="ord_loc_type" onChange="clearvalues(disp_locn_desc,ord_locn_code)">
					<!--<% //if(disp_stage.equals("AS")){%>
                           <option value=""><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option> 
						   <option value="C"selected><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<%//}else{%>  --> 
					<!--above code comment for KAUH-SCF-0065 [IN034846] -->
					      <option value=""selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option> 
						  <option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<%//} %>	<!--This line comment for KAUH-SCF-0065 [IN034846] -->				
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> </option>
					 </select>&nbsp;
					<input type="text" STYLE='overflow:visible;' name="disp_locn_desc" id="disp_locn_desc" onBlur="clearValue(disp_locn_desc,ord_locn_code)"><!--size="40" maxlength="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<input type="button" class="button" value="?" name="btnDispLocn" id="btnDispLocn" onClick="searchCode(disp_locn_desc,'<%=bean.getDispLocnCatg()%>','L')" value="" ><input type="hidden" name="ord_locn_code" id="ord_locn_code" value="">
				</td>
				<td  class="label" nowrap><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
				<td  >&nbsp;&nbsp;
					  <select name="order_by" id="order_by" disabled>
						<option value=""selected>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option> 
						<option value="DM"><fmt:message key="ePH.DischargeMedications.label" bundle="${ph_labels}"/></option>
						<option value="OP"><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/></option>
					 </select>				
				</td>

					<%if(mobile_no_search){
%>
                               <td  class="label" nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
             					<td >&nbsp;&nbsp;
			        			<input type="text" name="pat_mobile_no" id="pat_mobile_no" maxlength="20" size="25" value="">
					           </td><!--Added for TH-KW-CRF-0014 -->
<%                 }else{%>
								<input type="hidden" name="pat_mobile_no" id="pat_mobile_no" value="" >
<%}%>

				</tr>	
				<tr id="row5">
<%			if(tab_based_group_sort_disp!=null && tab_based_group_sort_disp.equals("Y")){ 
%>
					<td  class="label" COLSPAN=2 nowrap ><fmt:message key="ePH.GROUPBYORDERINGLOCATION.label" bundle="${ph_labels}"/>
					&nbsp;&nbsp;
						<input type="checkbox" name="group_by_ord_locn" id="group_by_ord_locn" value="N" onCLick="changeOrderByDispOp(this,'G');">
					</td>
<%
			} else{
%>					<td  class="label" COLSPAN=2 nowrap ><fmt:message key="ePH.GROUPBYORDERINGLOCATION.label" bundle="${ph_labels}"/> <!-- IN073342 -->
					&nbsp;&nbsp;
						<input type="checkbox" name="group_by_ord_locn" id="group_by_ord_locn" value="N"  >
					</td>
<%				}%>


				
					<td  class="label" COLSPAN=2 nowrap><fmt:message key="ePH.AbsoluteOrder.label" bundle="${ph_labels}"/> <!-- IN073342 -->
					&nbsp;&nbsp;
						<input type="checkbox" name="include_absolute_orders" id="include_absolute_orders" value="N"  >&nbsp;&nbsp;
						<fmt:message key="ePH.PRNOrder.label" bundle="${ph_labels}"/> <!-- IN073342 -->
					&nbsp;&nbsp;
						<input type="checkbox" name="exclude_PRN_orders" id="exclude_PRN_orders" value="N"  />
					</td>			
					
					<td  class="label" nowrap ><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/></td> <!-- IN073342 -->
					<td  >&nbsp;&nbsp;
						  <select name="drug_medical" id="drug_medical" >
							 <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
							 <option value="Y"><fmt:message key="ePH.DRUGS.label" bundle="${ph_labels}"/></option>
							 <option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${ph_labels}"/></option> <!-- IN073342 -->
						 </select>				
					</td>
				</tr>
				
				<tr>
				<%
						//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
								if(isSite_integration_em_bd_pyxis && disp_stage.equals("V")){
									%>
				<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
				<td >&nbsp;&nbsp;
					<select name="disp_locn" id="disp_locn" id="disp_locn" >
					<%	
					String selectDispLocation	=	null;
					if(bean.getDispLocnCode().equals("all"))
					{
						selectDispLocation="selected";
					}else {
						selectDispLocation="";
					}
						if (no_of_disp_locns > 1 && isSite_integration_em_bd_pyxis){%>
									<option value="all" <%=selectDispLocation%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
								<%}
						String disp_locn			=	null;
						StringTokenizer st_disp_locn =	null;
						String strdisp_locn_code	=	null;
						String disp_locn_name_opn		=	null;
			
						while (stdisp_locn_details.hasMoreTokens()){
							disp_locn			= stdisp_locn_details.nextToken();
							selectDispLocation	= "";
							st_disp_locn		= new StringTokenizer(disp_locn,",");
							strdisp_locn_code	= st_disp_locn.nextToken();
							if((strdisp_locn_code).equals(bean.getDispLocnCode())){
								selectDispLocation="selected";
							}else if(bean.getDispLocnCode().equals("all"))
							{
								
							}
							else{
								selectDispLocation="";
							}
							disp_locn_name_opn = st_disp_locn.nextToken();
							st_disp_locn.nextToken();
							
			%>
							<option value="<%=strdisp_locn_code%>" <%=selectDispLocation%> ><%=disp_locn_name_opn%></option>
							
			<%}
						stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
				%></select></td>
				<%	} else{%>
			<input type="hidden" name="disp_locn" id="disp_locn" value="">
				<%}//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 ends
%>
				<!-- Added for ML-MMOH-CRF-1666 start -->	
<%			if(tab_based_group_sort_disp!=null && tab_based_group_sort_disp.equals("Y")){ 
%>
				
				<td  class="label" nowrap ><fmt:message key="ePH.Sortby.label" bundle="${ph_labels}"/></td>&nbsp;
				<td class='label' nowrap>
					<select name="customSortBy" id="customSortBy" onchange="changeOrderByDispOp(this,'S','A');">
					<option value="NURSING_UNIT"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></option> 
					<option value="RELEASE_DATE_TIME" selected><fmt:message key="ePH.ReleaseDate.label" bundle="${ph_labels}"/></option>
					<option value="PATIENT_ID"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option> 
					<option value="PRIORITY"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option> 
					</select>&nbsp;		
					<label id='sortOrderAsc' onclick='displayOrderingOp("A","G");' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:inline'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></label> 
					<label id='sortOrderSep' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:inline'>/ </label>
					<label id='sortOrderDsc' onclick='displayOrderingOp("D","G");' style='cursor:pointer;color:blue;font-size:9; FONT-WEIGHT: bolder;display:inline'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></label>
					<input type='hidden' name='customSortOrder' id='customSortOrder' value='ASC'>
				</td>
				<td>		
				
<%}%>				<!-- Added for ML-MMOH-CRF-1666 end -->	
</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="issue_token_on_regn" id="issue_token_on_regn" value="<%=bean.getIssueTokenOnRegnYN()%>">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=bean.getDispLocnCatg()%>">
			<input type="hidden" name="change_status" id="change_status" value="">
			<input type="hidden" name="SQL_PH_DISP_MEDICATION_SELECT10" id="SQL_PH_DISP_MEDICATION_SELECT10" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT10")%>">
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="SQL_PH_ALT_DISP_LOCN_SELECT1E" id="SQL_PH_ALT_DISP_LOCN_SELECT1E" value="<%=PhRepository.getPhKeyValue("SQL_PH_ALT_DISP_LOCN_SELECT1E")%>">
			<input type="hidden" name="SQL_PH_DISP_MEDICATION_SELECT32" id="SQL_PH_DISP_MEDICATION_SELECT32" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT32")%>"> <!--SQL_PH_ALT_DISP_LOCN_SELECT1D changed for  ML-BRU-SCF-1591 [IN:055119]-->
<%
						if(ph_print_prescription){//Added for MMS-DM-CRF-0228
%>						<input type="hidden" name="ordering_date" id="ordering_date" value="<%=com.ehis.util.DateUtils.convertDate(fromDateTime,"DMYHM","en",locale)%>">
<%						}
						else{
%>						<input type="hidden" name="ordering_date" id="ordering_date" value="<%=com.ehis.util.DateUtils.convertDate(ord_date_from,"DMY","en",locale)%>">
<%						}
%>			
			<input type="hidden" name="dflt_disp_level" id="dflt_disp_level" value="<%=disp_level%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			<input type="hidden" name="Language_id" id="Language_id" value="<%=locale%>">
			<input type="hidden" name="disp_stage" id="disp_stage" value=<%=disp_stage%>>
			<input type="hidden" name="homepage" id="homepage" value="<%=homepage%>">
			<input type="hidden" name="tab_based_group_sort_disp" id="tab_based_group_sort_disp" value="<%=tab_based_group_sort_disp%>">
			<input type="hidden" name="ph_print_prescription" id="ph_print_prescription" value="<%=ph_print_prescription%>"> <!-- Added for MMS-DM-CRF-0228 -->
		</form>	
	</body>
<%
putObjectInBean(bean_id,bean,request);
	} // Added for MOHE-CRF-0074 - start
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}  // Added for MOHE-CRF-0074 - End
%>
</html>

