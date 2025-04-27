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
16/03/2021		Alpha-15869       Prabha			 Labels issue
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
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
System.out.println("==============in==========>DispMedicationQueryCriteriaForIP.jsp");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	   String locale			= (String)session.getAttribute("LOCALE");			
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="frmDispMedicationQueryCriteriaIP" id="frmDispMedicationQueryCriteriaIP" >
<%
	Connection con			= null;  // Added for MOHE-CRF-0074 - start
		try{
		  con				= ConnectionManager.getConnection(request);
		  boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
		  boolean mobile_no_search=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_MOBILE_NO");//Added for TH-KW-CRF-0014
		// Added for MOHE-CRF-0074 - END
		  boolean ph_print_prescription  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_PRINT_PRESCRIPTION"); //Added for MMS-DM-CRF-0228
		
			boolean isSite_integration_em_bd_pyxis	= false;
			isSite_integration_em_bd_pyxis =  eCommon.Common.CommonBean.isSiteSpecific(con,"PH","PH_INTEGRATION_EM_BD_PYXIS");//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
			String bean_id			= "DispMedicationBean" ;
			String bean_name		= "ePH.DispMedicationBean";
			DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
			String today			= bean.getTodaysDate();
			String facility_id		= (String) session.getValue( "facility_id" );
			String p_user_name      = (String) session.getValue( "login_user" ) ;
			String stage			= request.getParameter("stage");
			String fill_list		= request.getParameter("fill_list");
			String function_id		= CommonBean.checkForNull(request.getParameter("function_id"));
			String homepage		   = CommonBean.checkForNull(request.getParameter("homepage"));
			String sys_date			= bean.getTodaysDate();
			bean.clearCriteriaValues();
			bean.setTabBasegGroupSortDisp();
			bean.getFromToDate(facility_id, "IP"); // Added for ML-BRU-SCF-0636 [IN:036826]  //"IP" added for  AMS-CRF-0009[IN:030935]
			String ord_date_from	=bean.getFromDate();		//added for  AMS-CRF-0009[IN:030935]
			String ord_date_to   = bean.getToDate(); //added for  AMS-CRF-0009[IN:030935]
			Hashtable param_legends = bean.getLegendsFromParam();
			String disp_stage       = bean.getDispStage();
			String disp_locn_code	= bean.getDispLocnCode();
			String customer_id      = bean.getCustomerID();
			//String disp_stage_name  = "";
			String lock_icon        = "";
			String sIncAbsoluteDrugs	= "";  //sAbsoluteOrder  changed to sIncAbsoluteDrugs -(SRR20056-CRF-0663 )
			/* added for SRR20056-CRF-0663 --START*/
			String sIncPRNDrugs	= "";
			String sIncFreqDrus	= "";
			String sIncAbsoluteDrugsChk	= "";  
			String sIncPRNDrugsChk	= "";
			String sIncFreqDrusChk	= "";
			String dispdfltdisplay	= "";
			String sdfltPriority	= "";
			String sdfltProcessType	= "";
			String sdfltRoutine_lbl_display	= "";
			String sdfltInc_lbl_display	= "";
			String national_id_readonly ="";//Adding start for TH-KW-CRF-0014
			 
			 if(mobile_no_search)
				  national_id_readonly ="";
			 else
				  national_id_readonly ="readonly";//Adding end for TH-KW-CRF-0014
			 //if(customer_id.equals("SRR")) // removed ! from if condition
			 //   sIncAbsoluteDrugsChk	= "Checked";  //sAbsoluteOrder="" changed sIncAbsoluteDrugsChk= "Checked" 

			String sDisp_dflt_display = bean.getDispDfltDisplay(disp_stage, fill_list, disp_locn_code);
			String tab_based_group_sort_disp = bean.getTabBasegGroupSortDisp();
			// sDisp_dflt_display format like "<DATA_FOUND/DATA_NOT_FOUND>PRIORITY~<A/R/U>|[ABSOLUTE_DRUGS~<Y/N>|FREQUENCY_DRUGS~<Y/N>|PRN_DRUGS~<I/E>]";
			//sDisp_dflt_display = "DATA_FOUND|ABSOLUTE_DRUGS~N|FREQUENCY_DRUGS~N|PRN_DRUGS~I";
			//bean.setDispDfltDisplay_YN("Y");

			if(sDisp_dflt_display!=null &&  !sDisp_dflt_display.equals("") && ! sDisp_dflt_display.equals("X")){
				StringTokenizer stDftDisplay = new StringTokenizer(sDisp_dflt_display,"|");
				StringTokenizer stDftDisplayVal = null;
				String stDftDisplayID =null;
				while(stDftDisplay.hasMoreTokens()){
					String stDftDisplayDtl = stDftDisplay.nextToken();
					stDftDisplayVal = new StringTokenizer(stDftDisplayDtl,"~");
					while(stDftDisplayVal.hasMoreTokens()){
						stDftDisplayID = stDftDisplayVal.nextToken();
						if(stDftDisplayID.equals("DATA_NOT_FOUND")){
							dispdfltdisplay = "display:none;";
							bean.setDispDfltDisplay_YN("N");
						}
						else if(stDftDisplayID.equals("PRIORITY"))
							sdfltPriority = stDftDisplayVal.nextToken();
						else if(stDftDisplayID.equals("ABSOLUTE_DRUGS"))
							sIncAbsoluteDrugs = stDftDisplayVal.nextToken();
						else if(stDftDisplayID.equals("FREQUENCY_DRUGS"))
							sIncFreqDrus = stDftDisplayVal.nextToken();
						else if(stDftDisplayID.equals("PRN_DRUGS"))
							sIncPRNDrugs = stDftDisplayVal.nextToken();
						else if(stDftDisplayID.equals("PROCESS_TYPE"))
							sdfltProcessType = stDftDisplayVal.nextToken();
					}
				}
			}
			else
				dispdfltdisplay = "display:none;";

			if(sIncAbsoluteDrugs!=null && sIncAbsoluteDrugs.equals("Y"))
				sIncAbsoluteDrugsChk = " Checked";
			if(sIncFreqDrus!=null && sIncFreqDrus.equals("Y"))
				sIncFreqDrusChk	= " Checked";
			if(sIncPRNDrugs!=null && sIncPRNDrugs.equals("E"))
				sIncPRNDrugsChk	= " Checked";
			/* added for SRR20056-CRF-0663 --END*/
		/* Commented for SRR20056-CRF-0663 - Moved to DispMedicationQueryCriteriaButtons.jsp 
			if(disp_stage.equals("V")){
				disp_stage_name = (String)param_legends.get("V");
				// sAbsoluteOrder	= ""; //Commented for SRR20056-CRF-0663
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
			}
		*/
			String add_criteria_nat_desc	=	bean.getAddCriteriaNatDesc();
			bean.getDispMednDefltValues(); //Added for ML-BRU-SCF-1380 [IN:049774]
			String filter_on_next_fill_date	=	bean.getFilter_on_next_fill_date(); //added for ML-BRU-SCF-1380 [IN:049774]
			ArrayList IVlegends             =  (ArrayList)bean.getIVLegends();
			ArrayList OrderingFacility      =   bean.getOrderingFacilityId(p_user_name);
			String ivlegend_option          = "";	
			String order_facility_id        = "";	
			String order_facility_name      = "";	
			String tpn_admixture_flag = bean.getTpnAdmixtureLabelYN();//added for ML-MMOH-CRF-0430 [IN:057336]
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
					
			///* Below else if Condition  Added  by Himanshu For MMS-DM-CRF-0232 Starts
			ArrayList result = bean.checkToProceed1(facility_id.trim(),"DispMedication","IN_IAE");
			String disp_locn_details="";
			if(result.size()>0) {
				disp_locn_details =(String)result.get(0);
			}
			StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
			int no_of_disp_locns = stdisp_locn_details.countTokens();
			///* Below else if Condition  Added  by Himanshu For MMS-DM-CRF-0232 Ends
					
			String tpn_admixture = "<option value='TA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNAdmixture.label", "ph_labels")+"</option>";//added for ML-MMOH-CRF-0430 [IN:057336]
			for(int i=0;i<=IVlegends.size()-2;i=i+2){
				if(function_id.equals("PH_PREPARE_ADMIXTURE")){
					if(i==2||i==6){
						ivlegend_option		=ivlegend_option +	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>";
					}
				}
				else{
					if(!((fill_list.equals("DWF") || fill_list.equals("AF")) && (i==2||i==6))){ // This is added not to display admx orders in Fill list 
						ivlegend_option		=ivlegend_option +	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>"; 
					}
				}
			}
			if("Y".equals(tpn_admixture_flag))//added for ML-MMOH-CRF-0430 [IN:057336]
				tpn_admixture = "<option value='TA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNCustomize.label", "ph_labels")+"</option>";
			if(stage.equals("F") && fill_list.equals("AF")){
				ArrayList fill_dates ;
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr>
					   <td class="label" align="left" width='15%'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
					   <td class="label" width='18%'><select name="OrderingFacility" id="OrderingFacility" onChange="ClearNursingUnit()">
					   <%if(region_check){ //MOHE-CRF-0074-Start 
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
					}else{   //MOHE-CRF-0074-end
						for (int i=0;i<OrderingFacility.size();i+=2){
							order_facility_id=(String)OrderingFacility.get(i);
							order_facility_name=(String)OrderingFacility.get(i+1);
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
%>
					<%} %> <!-- added for MOHE-CRF-0074- -->
					</SELECT>
					</td>
					<!--
					<td  class="label" nowrap><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
					<td   class="label">&nbsp;			
							<b> <%/*= disp_stage_name */%> </b>
					</td>
					-->
					<td  class="label" width='18%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td  class="label" width='15%' >
						<input type="text" name="nursing_unit_desc" id="nursing_unit_desc" maxlength="20" size="20" ><input type="button" class="button" name="btnNursingUnit" id="btnNursingUnit" value="?" onClick="searchNursingUnit(nursing_unit_desc,document.OrderingFacility)">				
						<input type="hidden" name="nursing_unit" id="nursing_unit">
					</td>

					<td  class="label" nowrap width='15%'><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/></td><!-- IN073342 -->
					<td  class="label">
						  <select name="drug_medical" id="drug_medical" >
							 <option value="" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
							 <option value="Y"><fmt:message key="ePH.DRUGS.label" bundle="${ph_labels}"/></option>
							 <option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${common_labels}"/></option>
						 </select>				
					</td>
				</tr>
				<tr id="row1"> <!-- code ' id="row1" ' added for Bru-HIMS-CRF-416[IN045566] -->
					<!--<td  class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td  >&nbsp;
						<input type="text" name="nursing_unit_desc" id="nursing_unit_desc" maxlength="20" size="20" ><input type="button" class="button" name="btnNursingUnit" id="btnNursingUnit" value="?" onClick="searchNursingUnit(nursing_unit_desc,document.OrderingFacility)">				
						<input type="hidden" name="nursing_unit" id="nursing_unit">
					</td> -->
					<td  class="label" nowrap><fmt:message key="ePH.FillProcessID.label" bundle="${ph_labels}"/></td>
					<td class="label">
						<input type="text" name="fill_process_id" id="fill_process_id" maxlength="20" size="18" value="" onKeyPress="return allowValidNumber(this,event,20,0);" onBlur="CheckNum(this);">
					</td>
					<td  class="label"><fmt:message key="ePH.FillProcessDate.label" bundle="${ph_labels}"/></td>
					<td  class="label"><input type="text" name="fill_process_date" id="fill_process_date" maxlength="10" size="8"  onBlur="CheckDateT(this, '<%=locale%>')"></td>
					<td  class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td  class="label">
						<select name="fill_type" id="fill_type" onChange="clearFillDate();populateFillDate(this)">
<%
							if(sdfltProcessType!=null && sdfltProcessType.equals("I")){
								sdfltRoutine_lbl_display	= "display:none";
								sdfltInc_lbl_display	= "display:inline";
								fill_dates = bean.getIncrementalFillDateTime(disp_locn_code);
%>
								<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
								<option value="I" selected><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></option>
<%
							}
							else{
								fill_dates = bean.getRoutineFillDateTime(disp_locn_code);
								sdfltRoutine_lbl_display	= "display:inline";
								sdfltInc_lbl_display	= "display:none";
%>
								<option value="R" selected><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
								<option value="I" ><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></option>
<%
							}
%>
						</select>
					</td>
				</tr>
				<tr id="row2"> <!-- code ' id="row2" ' added for Bru-HIMS-CRF-416[IN045566] -->
					<!--<td  class="label" nowrap><fmt:message key="ePH.FillProcessID.label" bundle="${ph_labels}"/></td>
					<td >&nbsp;
						<input type="text" name="fill_process_id" id="fill_process_id" maxlength="20" size="18" value="" onKeyPress="return allowValidNumber(this,event,20,0);" onBlur="CheckNum(this);">
					</td>-->
					<td  class="label" nowrap><fmt:message key="ePH.Batches.label" bundle="${ph_labels}"/></td>
					<td class="label">
						<select name="batches" id="batches">
							<option value="BA"><fmt:message key="ePH.Allocated.label" bundle="${ph_labels}"/></option>
							<option value="BNA"><fmt:message key="ePH.NotAllocated.label" bundle="${ph_labels}"/></option>
							<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td  class="label" nowrap><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
					<td class="label">
						<select name="order_status" id="order_status">
							<option value="OSN"><fmt:message key="Common.New.label" bundle="${common_labels}"/></option>
							<option value="OSA" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<!-- <option value="H"><fmt:message key="ePH.HeldOrders.label" bundle="${ph_labels}"/></option> -->
						</select>
					</td>
					<td  class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
					<td class="label">
					<select name="order_type" id="order_type" onChange="defaultDispLevel(document.frmDispMedicationQueryCriteriaIP,this)">
<%
					if(function_id.equals("PH_PREPARE_ADMIXTURE")){
%>
							<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
							<%=ivlegend_option%>
							<%=tpn_admixture %><!-- //added for ML-MMOH-CRF-0430 [IN:057336] -->
							<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
						</select>
<%
					}
					else{
%> 
						<option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="NOR" ><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
						<!-- <option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option> -->
						<%=ivlegend_option%>
						<!-- <option value="TD"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option> -->
						<option value="CD"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
<%
					}
%>
					</select>
					&nbsp;<label class="label" id="lbl_nationality" style="font-weight:bold;display:none" ><%=add_criteria_nat_desc%></label>
					</td>

				</tr>	
				<tr id="row3"> <!-- code ' id="row3" ' added for Bru-HIMS-CRF-416[IN045566] -->
					<td  class="label"><fmt:message key="ePH.DispenseLevel.label" bundle="${ph_labels}"/></td>
					<td class="label" colspan="1" >
						<select name="disp_level" id="disp_level">
<%
						if(!function_id.equals("PH_PREPARE_ADMIXTURE")){					
							if( (bean.getDispLevel()).equals("O")) {
%>
								<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
								<option value="P"><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<% 
							}
							else if( (bean.getDispLevel()).equals("P")) { 
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
						<td  class="label" nowrap>

							<label id="lbl_routine"  style="<%=sdfltRoutine_lbl_display%>"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></label>
							<label id="lbl_incremental" style="<%=sdfltInc_lbl_display%>"><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></label>
							<fmt:message key="ePH.FillDate/Time.label" bundle="${ph_labels}"/> 
						</td>
						<td class="label">
						<select name="fill_date_time" id="fill_date_time" style="width:120px">					
<%
						for (int i=0;i<fill_dates.size();i++){
%>
							<option value="<%=com.ehis.util.DateUtils.convertDate((String)fill_dates.get(i),"DMYHM","en",locale)%>"><%=com.ehis.util.DateUtils.convertDate((String)fill_dates.get(i),"DMYHM","en",locale)%></option>
<%
						}
%>
						</select>
						</td>
						<!-- Added for JD-CRF-0181 [IN:40699] -->
						<td class="label"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
						<td  class="label"><input type="text" name="order_id" id="order_id"  size="20" maxlength="15" onfocus="this.select();" onBlur="fetchRecord(this);" onkeydown="if (event.keyCode==13) {fetchRecord(this);}" onkeypress="return CheckForSpecChars(event)" value=""><!-- Added 'fetchRecode(this)' for JD-CRF-0181 [IN:045355] // Added onfocus for [IN:45893]-->
						</td>
					</tr>
					<tr id="row4"> <!-- code ' id="row4" ' added for Bru-HIMS-CRF-416[IN045566] -->
						<td  class="label" COLSPAN=2 nowrap ><fmt:message key="ePH.GROUPBYORDERINGLOCATION.label" bundle="${ph_labels}"/>&nbsp; <!-- Modified for Alpha 15869 -->
							<input type="checkbox" name="group_by_ord_locn" id="group_by_ord_locn" value="Y" checked >
						</td>
						<td  class="label" COLSPAN=4 nowrap>
							<label style="<%=dispdfltdisplay%>">
								<fmt:message key="ePH.IncFreqDurnOrders.label" bundle="${ph_labels}" /> <!-- Modified for Alpha 15869 -->
								&nbsp;
								<input type="checkbox" name="include_orders_by_freq_durn" id="include_orders_by_freq_durn" value="<%=sIncFreqDrus%>" <%=sIncFreqDrusChk%>   >&nbsp;&nbsp;
							</label>
							<label style="<%=dispdfltdisplay%>">
								<fmt:message key="Common.Include.label" bundle="${common_labels}" />&nbsp;
							</label>
							<fmt:message key="ePH.AbsoluteOrder.label" bundle="${ph_labels}"/>&nbsp; <!-- Modified for Alpha 15869 -->
							<input type="checkbox" name="include_absolute_orders" id="include_absolute_orders" value="<%=sIncAbsoluteDrugs%>"  <%=sIncAbsoluteDrugsChk%> >
							&nbsp;&nbsp;
							<fmt:message key="ePH.PRNOrder.label" bundle="${ph_labels}"/>&nbsp;<input type="checkbox" name="exclude_PRN_orders" id="exclude_PRN_orders" value="<%=sIncPRNDrugs%>"  <%=sIncPRNDrugsChk%> /> <!-- Modified for Alpha 15869 -->
						</td>
					   <!--
						<td  class="label" COLSPAN=2 nowrap><fmt:message key="ePH.AbsoluteOrder.label" bundle="${common_labels}"/>
						&nbsp;
							<input type="checkbox" name="include_absolute_orders" id="include_absolute_orders" value="Y"  <%=sIncAbsoluteDrugs%> >&nbsp;
							<fmt:message key="ePH.PRNOrder.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="exclude_PRN_orders" id="exclude_PRN_orders" value="N"  />

						</td>			
						<td  class="label" nowrap ><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${common_labels}"/></td>
						<td  >&nbsp;
							  <select name="drug_medical" id="drug_medical" >
								 <option value="" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
								 <option value="Y"><fmt:message key="ePH.DRUGS.label" bundle="${ph_labels}"/></option>
								 <option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${common_labels}"/></option>
							 </select>				
						</td>
						-->
						<input type="hidden" name="patient_id" id="patient_id" value=""><!--added for [IN:055192]  -->
					</tr>	
				</table>
<%
			}
			else if(stage.equals("D") && fill_list.equals("DWF")) {
			
				String img_visible		=	"visibility:hidden";
		//commented during PE By Naveen
				//String Unlock_all_records_yn=bean.getUnLockRecordsYN(p_user_name,disp_locn_code);
				String Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
					<tr>
					   <td class="label" align="left" nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
					   <td class="label" Colspan=5><select name="OrderingFacility" id="OrderingFacility" onChange="clearData(nursing_unit);clearData(fill_proc_id);">
<%
				if(region_check){   //MOHE-CRF-0074-Start 
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
				}else{ // MOHE-CRF-0074-End
						for (int i=0;i<OrderingFacility.size();i+=2){
							order_facility_id=(String)OrderingFacility.get(i);
							order_facility_name=(String)OrderingFacility.get(i+1);
							if(facility_id.equals(order_facility_id)){
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
%>
				<%} %> <!-- Added for MOHE-CRF-0074 -->
						</SELECT>
						</td>
						<!--
						<td  class="label" nowrap><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
						<td   class="label">&nbsp;			
								<b> <%/*= disp_stage_name*/ %> </b>
						</td>
						-->
						<td  class="label" nowrap><fmt:message key="ePH.UserLocked.label" bundle="${ph_labels}"/></td>
						<td   class="label">			
							<img src="../../ePH/images/Locked.gif" border="0"  id="lock_id" onMouseOver="showToolTipLockStatus_delivery(this)"onclick="UnLockRecordDelivery_yn('<%=p_user_name%>','<%=Unlock_all_records_yn%>','<%=disp_locn_code%>')" style='cursor:pointer;color:blue;font-size:9;font-weight:bold' style="<%=img_visible%>"></img><b>
						</td>
					</tr>
					<tr>
						<td  class="label" nowrap><fmt:message key="ePH.FillProcDate.label" bundle="${ph_labels}"/></td>
						<td  class="label">
							<input type="text" name="fill_proc_date" id="fill_proc_date"  size="8" maxlength="10" onBlur="if(CheckDateT(this,'<%=locale%>') ) getFillProc();" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar1 onclick="showCalendar('fill_proc_date');document.frmDispMedicationQueryCriteriaIP.fill_proc_date.focus();return false;" >
						</td>
						<td  class="label" nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
						<td  class="label"><select name="fill_proc_type" id="fill_proc_type" onBlur="getFillProc();">
<%
							if(sdfltProcessType!=null && sdfltProcessType.equals("I")){
%>
								<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
								<option value="I" selected><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></option>
<%
							}
							else{
%>
								<option value="R" selected><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
								<option value="I" ><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></option>
<%
							}
%>
							</select>
						</td>
						<td  class="label" nowrap><fmt:message key="Common.FillProcID.label" bundle="${common_labels}"/></td>
						<td  class="label">
							<select name="fill_proc_id" id="fill_proc_id" onchange="getNursingUnit(this);">
								<option value="">&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</option>

							</select>
						</td>
						<td  class="label" nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
						<td  class="label">
							<select name="nursing_unit" id="nursing_unit">
								<option value="">&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</option>
							</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
						</tr>
					</table>
<%
				}
				else if(stage.equals("D")&& fill_list.equals("DF")){
%>
					 <table cellpadding=0 cellspacing=0 width="100%" align="center" border=0>
						<tr>
						   <td class="label" align="left" nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
						   <td class="label"><select name="OrderingFacility" id="OrderingFacility" onChange="ClearNursingUnit()">
						<%if(region_check){  // MOHE-CRF-0074-Start 
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
						}else{   // MOHE-CRF-0074-End
							for (int i=0;i<OrderingFacility.size();i+=2){
								order_facility_id=(String)OrderingFacility.get(i);
								order_facility_name=(String)OrderingFacility.get(i+1);
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
%>
						<%} %> <!-- ADDED  FOR MOHE-CRF-0074 -->
							</SELECT>
							</td>
	 
							<td  class="label" nowrap id="dateLegend"><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/><!--code 'OrderDateFrom' label changed to 'PeriodDateFrom' for Bru-HIMS-CRF-418[IN045564] -->
							</td>
							<td class="label">
<%						if(ph_print_prescription){//Added for MMS-DM-CRF-0228 start
%>								<input type="text" name="order_date_from" id="order_date_from"  size="15" maxlength="16" onBlur="validateDate();" id="order_date_from"  value="<%=com.ehis.util.DateUtils.convertDate(fromDateTime,"DMYHM","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='from_time_calendar' onclick="showCalendar('order_date_from',null,'hh:mm'); document.frmDispMedicationQueryCriteriaIP.order_date_from.focus();return false; " > &nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
								<input type="text" name="order_date_to" id="order_date_to" size="15" maxlength="16" onBlur="validateDate();" id="order_date_to" value="<%=com.ehis.util.DateUtils.convertDate(toDateTime,"DMYHM","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='to_time_calendar' onclick="showCalendar('order_date_to',null,'hh:mm'); document.frmDispMedicationQueryCriteriaIP.order_date_to.focus();return false;" >
<%						}
						else{//Added for MMS-DM-CRF-0228 end
%>								<input type="text" name="order_date_from" id="order_date_from"  size="8" maxlength="10" onBlur="if(CheckDateT(this,'<%=locale%>') ) validateDate();" value="<%=com.ehis.util.DateUtils.convertDate(ord_date_from,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_from');document.frmDispMedicationQueryCriteriaIP.order_date_from.focus();return false; " > &nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
								<input type="text" name="order_date_to" id="order_date_to" size="8" maxlength="10" onBlur="if(CheckDateT(this,'<%=locale%>') ) validateDate()" value="<%=com.ehis.util.DateUtils.convertDate(ord_date_to,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_to');document.frmDispMedicationQueryCriteriaIP.order_date_to.focus();return false;" >
<%						}
%>						
							</td>
							<!--<td  class="label" nowrap><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
							<td   class="label">&nbsp;			
									<b> <%/*=  disp_stage_name*/ %> </b>
							</td>  -->
							<td  class="label"><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td>
							<td class="label">
								<select name="ip_scope" id="ip_scope" onchange="DateLegendChange(this, '<%=filter_on_next_fill_date%>');"> <!--DateLegendChange added for ML-BRU-SCF-1380 [IN:049774]-->
									<option value="N"><fmt:message key="ePH.NewPrescriptions.label" bundle="${ph_labels}"/></option>
									<option value="R"><fmt:message key="ePH.RegularPrescriptions.label" bundle="${ph_labels}"/></option>
									<option value="A" ><fmt:message key="ePH.AllPrescriptions.label" bundle="${ph_labels}"/></option> <!-- Added for ML-MMOH-CRF-0434 [IN057356] -->
								</select>
							</td>
					  </tr>	
					<tr id="row1"> <!-- code ' id="row1" 'added for Bru-HIMS-CRF-416[IN045566] -->
						<td  class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
						<td  class="label">
							<input type="text" name="nursing_unit_desc" id="nursing_unit_desc" STYLE='overflow:visible;' ><input type="button" class="button" name="btnNursingUnit" id="btnNursingUnit" value="?" onClick="searchNursingUnit(nursing_unit_desc)"><!--maxlength="18" size="18" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->			
						<input type="hidden" name="nursing_unit" id="nursing_unit">
						</td>
						<!--<td  class="label"> <fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/> </td>
						<td  >&nbsp;
							<input type="text" name="disp_date" id="disp_date" maxlength="10" size="8" readOnly value="<%=com.ehis.util.DateUtils.convertDate(today,"DMY","en",locale)%>"> 
						</td>-->

						<td  class="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
						<td  class="label">
							<select name="priority" id="priority">
								<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
								<option value="R" ><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
								<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>					
							</select>
						</td>			
						<td  class="label" nowrap ><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${common_labels}"/></td>
						<td  class="label">
							  <select name="drug_medical" id="drug_medical" >
								 <option value="" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
								 <option value="Y"><fmt:message key="ePH.DRUGS.label" bundle="${ph_labels}"/></option>
								 <option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${common_labels}"/></option>
							 </select>				
						</td>
					</tr>
					<tr id="row2"> <!-- code ' id="row2" 'added for Bru-HIMS-CRF-416[IN045566] -->
						<td  class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class="label">
							<input type="text" name="patient_id" id="patient_id"  maxlength="<%=bean.getPatientIDLength()%>" size="18" value="" onKeyPress="uppercase()" onBlur="callPatientSearch()"><input type="button" value="?"  class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
						</td>
						<td  class="label" nowrap><%=bean.getNationID()%></td>
						<td class="label">
							<input type="text" name="national_id_no" id="national_id_no" maxlength="20" size="20" onKeyPress="return CheckForSpecChars(event)" value="" <%=national_id_readonly%>>
						</td>
						<td  class="label" nowrap><%=bean.getHealthCardNo()%></td>
						<td class="label">
							<input type="text" name="health_card_num" id="health_card_num" maxlength="20" size="20" value="" readonly>
						</td>			
					</tr>	
					<tr id="row3"> <!-- code ' id="row3" 'added for Bru-HIMS-CRF-416[IN045566] -->
						<td  class="label"><fmt:message key="ePH.DispenseLevel.label" bundle="${ph_labels}"/></td>
						<td class="label">
							<select name="disp_level" id="disp_level">
<%
							if(!function_id.equals("PH_PREPARE_ADMIXTURE")){ 
								if( (bean.getDispLevel()).equals("O")) { 
%>
									<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
									<option value="P"><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<% 
								}
								else if( (bean.getDispLevel()).equals("P")) { 
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
						<!--
						<td  class="label"><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td>
						<td >&nbsp;	
							<select name="ip_scope" id="ip_scope">
							<option value="N"><fmt:message key="ePH.NewPrescriptions.label" bundle="${ph_labels}"/></option>
							<option value="R"><fmt:message key="ePH.RegularPrescriptions.label" bundle="${ph_labels}"/></option>
							</select>
						</td>
						-->
						<td  class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
						<td class="label">	
							<select name="order_type" id="order_type" onChange="defaultDispLevel(document.frmDispMedicationQueryCriteriaIP,this)">
<%
							if(function_id.equals("PH_PREPARE_ADMIXTURE")){
%>
									<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
									<%=ivlegend_option%>
									<%=tpn_admixture %><!-- //added for ML-MMOH-CRF-0430 [IN:057336] -->
									<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
<%
								}
								else{
%>
									<option value="ALL" selected><fmt:message key="ePH.ALL_EXCEPT_TPN.label" bundle="${ph_labels}"/></option>
									<option value="NOR"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
									<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
									<%=ivlegend_option%>
									<option value="TD"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
									<option value="CD"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
									<%=tpn_admixture %><!-- //added for ML-MMOH-CRF-0430 [IN:057336] -->
									<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
									<option value="CDR"><fmt:message key="ePH.CDROrders.label" bundle="${ph_labels}"/></option> <!-- Added for ML-MMOH-CRF-0435 [IN:057357] -->
<%
								}
%>
								</select>
								&nbsp;<label class="label" id="lbl_nationality" style="font-weight:bold;display:none" ><%=add_criteria_nat_desc%></label>
							</td>			
<%                if(mobile_no_search){
%>
								<td  class="label" nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
             					<td >&nbsp;
			        			<input type="text" name="pat_mobile_no" id="pat_mobile_no" maxlength="20" size="25" value="">
					          </td><!--Added for TH-KW-CRF-0014 -->

<%}else{%>
                           <!-- Added for JD-CRF-0181 [IN:40699] -->
								<td class="label"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
								<td  class="label"><input type="text" name="order_id" id="order_id"  size="20" maxlength="15" onfocus="this.select();" onBlur="fetchRecord(this);" onkeydown="if (event.keyCode==13) {fetchRecord(this);}" onkeypress="return CheckForSpecChars(event)" value=""><!-- Added 'fetchRecode(this)' for JD-CRF-0181 [IN:045355] // Added onfocus for [IN:45893]-->
								<input type="hidden" name="pat_mobile_no" id="pat_mobile_no" value="" >
								</td>
<%}%>

						</tr>
						<tr id="row4"> <!-- code ' id="row4" 'added for Bru-HIMS-CRF-416[IN045566] -->
<%if(mobile_no_search){
%>
                       <!-- Added for JD-CRF-0181 [IN:40699] -->
								<td class="label"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
								<td  class="label"><input type="text" name="order_id" id="order_id"  size="20" maxlength="15" onfocus="this.select();" onBlur="fetchRecord(this);" onkeydown="if (event.keyCode==13) {fetchRecord(this);}" onkeypress="return CheckForSpecChars(event)" value=""><!-- Added 'fetchRecode(this)' for JD-CRF-0181 [IN:045355] // Added onfocus for [IN:45893]-->
								</td>
<%}else{%>
								<td  class="label" COLSPAN='2' nowrap> 
								<label style="<%=dispdfltdisplay%>">
									<fmt:message key="ePH.IncFreqDurnOrders.label" bundle="${ph_labels}" />
									&nbsp;
									<input type="checkbox" name="include_orders_by_freq_durn" id="include_orders_by_freq_durn" value="<%=sIncFreqDrus%>" <%=sIncFreqDrusChk%>   >&nbsp;&nbsp;
								</label>&nbsp;
							</td>
<%}%>

							<td  class="label" nowrap>
								<label style="<%=dispdfltdisplay%>">
									<fmt:message key="Common.Include.label" bundle="${common_labels}" />
								</label>&nbsp;
								<fmt:message key="ePH.AbsoluteOrder.label" bundle="${ph_labels}"/>									
							</td>
							<td  class="label" nowrap>
								<input type="checkbox" name="include_absolute_orders" id="include_absolute_orders" value="<%=sIncAbsoluteDrugs%>"  <%=sIncAbsoluteDrugsChk%> >
							</td>
							<td  class="label"  nowrap>
								<fmt:message key="ePH.PRNOrder.label" bundle="${ph_labels}"/>&nbsp;
							</td>
							<td  class="label" nowrap>
								<input type="checkbox" name="exclude_PRN_orders" id="exclude_PRN_orders" value="<%=sIncPRNDrugs%>"  <%=sIncPRNDrugsChk%> />
								<!--
								<td  class="label" nowrap ><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${common_labels}"/></td>
								<td  >&nbsp;
									  <select name="drug_medical" id="drug_medical" >
										 <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
										 <option value="Y"><fmt:message key="ePH.DRUGS.label" bundle="${ph_labels}"/></option>
										 <option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${common_labels}"/></option>
									 </select>				
								</td>
								-->
							</td>			
						</tr>	
						<tr id="row5"> <!-- code ' id="row5" 'added for Bru-HIMS-CRF-416[IN045566] -->
<%
							if(tab_based_group_sort_disp==null || !tab_based_group_sort_disp.equals("Y")){
%>
								<td  class="label" COLSPAN='6' nowrap ><fmt:message key="ePH.GROUPBYORDERINGLOCATION.label" bundle="${ph_labels}"/>&nbsp;
								<input type="checkbox" name="group_by_ord_locn" id="group_by_ord_locn" value="Y" checked >
								</td>
<%
							}
							else{
%>
								<input type="hidden" name="group_by_ord_locn" id="group_by_ord_locn" value="">
								<td  class="label" nowrap ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;
								<td class='label' nowrap>
									  <select name="customGroupBy" id="customGroupBy" onchange="changeOrderByDisp(this,'G','A');">
										 <option value="NONE" selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option> 
										 <option value="NURSING_UNIT"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></option> 
										 <option value="RELEASE_DATE_TIME"><fmt:message key="ePH.ReleaseDate.label" bundle="${ph_labels}"/></option>
										 <option value="ORD_DATE_TIME"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></option> 
										 <option value="PRIORITY"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option> 
									 </select>	&nbsp;
									 <label id='groupOrderAsc' onclick='displayOrdering("A","G");' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:none'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></label>  
									 <label id='groupOrderSep' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:none'>/ </label>
									 <label id='groupOrderDsc' onclick='displayOrdering("D","G");' style='cursor:pointer;color:blue;font-size:9; FONT-WEIGHT: normal;display:none'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></label>
									 <input type='hidden' name='customGroupOrder' id='customGroupOrder' value='ASC'>
								</td>
								<td  class="label" nowrap ><fmt:message key="ePH.Sortby.label" bundle="${ph_labels}"/>&nbsp;
								<td class='label' nowrap>
									  <select name="customSortBy" id="customSortBy" onchange="changeOrderByDisp(this,'S','A');">
										 <!-- <option value="NONE"><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>  --> <!-- commented for IN[032898] -->
										 <option value="NURSING_UNIT"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></option> 
										 <option value="RELEASE_DATE_TIME" selected><fmt:message key="ePH.ReleaseDate.label" bundle="${ph_labels}"/></option>
										 <option value="PATIENT_ID"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option> 
										 <option value="PRIORITY"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option> 
									 </select>&nbsp;		
									 <label id='sortOrderAsc' onclick='displayOrdering("A","S");' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:inline'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></label> 
									 <label id='sortOrderSep' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:inline'>/ </label>
									 <label id='sortOrderDsc' onclick='displayOrdering("D","S");' style='cursor:pointer;color:blue;font-size:9; FONT-WEIGHT: bolder;display:inline'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></label>
									 <input type='hidden' name='customSortOrder' id='customSortOrder' value='ASC'>
								</td>
								<td  class="label" nowrap ><fmt:message key="ePH.TabBased.label" bundle="${ph_labels}"/>&nbsp;</td>
								<td class="label" nowrap >
									<input type="checkbox" name="customTabBased" id="customTabBased"  value="N" onclick='clickCustomTabBased(this);' />
									<input type="text" name="customTabBasedHrs" id="customTabBasedHrs" id='customTabBasedHrs' size='2' maxlength='3' value="" style='display:none;' onKeyPress="return allowValidNumber(this,event,3,0);" onblur='checkForNumber(this);'/><label id='customTabBasedLabel' style='display:none;' ><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif" align="center"  ></img> </label>

								</td>
<%
								}
%>						</tr>
						<!-- KDAH-CRF-0338 - Start -->
						<tr id="row6">
							<td  class="label" width='18%'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td> 
							<td  class="label" width='15%' >
						        <input type="text" name="bed_no" id="bed_no" maxlength="8" size="8" onBlur='ChangeUpperCase(this)' onKeyPress="return CheckForSpecChars(event)" >				
						</tr>
						<!-- KDAH-CRF-0338 - Ends -->
					</table>	
<%
				}
				else{
%>
					<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
						<tr>
							<td class="label" align="left" nowrap width='10%'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
							<td class="label" width='25%'><select name="OrderingFacility" id="OrderingFacility" onChange="ClearNursingUnit()">
				<%if(region_check){ // MOHE-CRF-0074-Start	   
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
				}else{  // MOHE-CRF-0074-Start
							for (int i=0;i<OrderingFacility.size();i+=2){
								order_facility_id=(String)OrderingFacility.get(i);
								order_facility_name=(String)OrderingFacility.get(i+1);
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
%>
						<%} %> <!-- MOHE-CRF-0074-Start -->
							</SELECT>
							</td>
	
							<td  class="label" nowrap id="dateLegend" idth='10%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/><!--code 'OrderDateFrom' label changed to 'PeriodDateFrom' for Bru-HIMS-CRF-418[IN045564] -->
							</td>
							<td class="label" width='25%'>
<%						if(ph_print_prescription){//Added for MMS-DM-CRF-0228 start
%>								<input type="text" name="order_date_from" id="order_date_from"  size="15" maxlength="16" onBlur="validateDate();" id="order_date_from"  value="<%=com.ehis.util.DateUtils.convertDate(fromDateTime,"DMYHM","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='from_time_calendar' onclick="showCalendar('order_date_from',null,'hh:mm'); document.frmDispMedicationQueryCriteriaIP.order_date_from.focus();return false; " > &nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
								<input type="text" name="order_date_to" id="order_date_to" size="15" maxlength="16" onBlur="validateDate();" id="order_date_to" value="<%=com.ehis.util.DateUtils.convertDate(toDateTime,"DMYHM","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='to_time_calendar' onclick="showCalendar('order_date_to',null,'hh:mm'); document.frmDispMedicationQueryCriteriaIP.order_date_to.focus();return false;" >
<%						}
						else{//Added for MMS-DM-CRF-0228 end
%>								<input type="text" name="order_date_from" id="order_date_from"  size="8" maxlength="10" onBlur="if(CheckDateT(this,'<%=locale%>') ) validateDate();" value="<%=com.ehis.util.DateUtils.convertDate(ord_date_from,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_from');document.frmDispMedicationQueryCriteriaIP.order_date_from.focus();return false; " > &nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
								<input type="text" name="order_date_to" id="order_date_to" size="8" maxlength="10" onBlur="if(CheckDateT(this,'<%=locale%>') ) validateDate()" value="<%=com.ehis.util.DateUtils.convertDate(ord_date_to,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('order_date_to');document.frmDispMedicationQueryCriteriaIP.order_date_to.focus();return false;" >
<%						}
%>									</td>
							<!--
							<td  class="label" nowrap><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
							<td   class="label">&nbsp;			
									<b> <%/*=  disp_stage_name*/ %> </b>
						  </td>
							-->
								<td  class="label" width='10%'><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td>
								<td class="label" width='20%'>	
									<select name="ip_scope" id="ip_scope" onchange="DateLegendChange(this, '<%=filter_on_next_fill_date%>');"> <!--DateLegendChange added for ML-BRU-SCF-1380 [IN:049774]-->
									<option value="N"><fmt:message key="ePH.NewPrescriptions.label" bundle="${ph_labels}"/></option>
                                    <option value="H"><fmt:message key="ePH.HeldOrders.label" bundle="${ph_labels}"/></option>
<%
									if(!stage.equals("V")){
%>
										 <option value="R"><fmt:message key="ePH.RegularPrescriptions.label" bundle="${ph_labels}"/></option>
										 <option value="A" ><fmt:message key="ePH.AllPrescriptions.label" bundle="${ph_labels}"/></option> <!-- Added for ML-MMOH-CRF-0434 [IN057356] -->
<%
									}
%>
									
									
									</select>
								</td>
							</tr>
							<tr id="row1"> <!-- code ' id="row1" 'added for Bru-HIMS-CRF-416[IN045566] -->
								<td  class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
								<td  class="label">
									<input type="text" name="nursing_unit_desc" id="nursing_unit_desc" STYLE='overflow:visible;'><!--maxlength="18" size="18" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
									<input type="button" class="button" name="btnNursingUnit" id="btnNursingUnit" value="?" onClick="searchNursingUnit(nursing_unit_desc)">				
									<input type="hidden" name="nursing_unit" id="nursing_unit">
								</td>
								<td  class="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
								<td  class="label">
								<select name="priority" id="priority">
<%
								// if-else conditions added for added for SRR20056-CRF-0663
								if(sdfltPriority != null && sdfltPriority.equals("R")){
%>
									<option value="" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
									<option value="R" selected><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
									<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>					
<%
								}
								else if(sdfltPriority != null && sdfltPriority.equals("U")){
%>
									<option value="" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
									<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
									<option value="U" selected><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>	
<%
								}
								else{
%>
									<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
									<option value="R" ><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
									<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>					
<%
								}
%>
								</select>
								</td>
								<!--
								<td  class="label"><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td>
								<td >&nbsp;	
									<select name="ip_scope" id="ip_scope">
									<option value="N"><fmt:message key="ePH.NewPrescriptions.label" bundle="${ph_labels}"/></option>
									<%if(!stage.equals("V")){%>
										 <option value="R"><fmt:message key="ePH.RegularPrescriptions.label" bundle="${ph_labels}"/></option>
									<%}%>
									<option value="H"><fmt:message key="ePH.HeldOrders.label" bundle="${ph_labels}"/></option>
									</select>
								</td>
								-->
								<td  class="label" nowrap ><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/></td>
								<td  class="label">
									  <select name="drug_medical" id="drug_medical" >
										 <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
										 <option value="Y"><fmt:message key="ePH.DRUGS.label" bundle="${ph_labels}"/></option>
										 <option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${ph_labels}"/></option>
									 </select>				
								</td>

							</tr>
							<tr id="row2"> <!-- code ' id="row2" 'added for Bru-HIMS-CRF-416[IN045566] -->
								<td  class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
								<td class="label">
								<input type="text" name="patient_id" id="patient_id"  maxlength="<%=bean.getPatientIDLength()%>" size="18" value="" onKeyPress="uppercase()" onBlur="callPatientSearch()"><input type="button" value="?"  class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
								</td>
								<td  class="label" nowrap><%=bean.getNationID()%>&nbsp;</td>
								<td class="label"><input type="text" name="national_id_no" id="national_id_no" maxlength="20" size="20" onKeyPress="return CheckForSpecChars(event)" value="" <%=national_id_readonly%>>
								</td>
								<td  class="label" nowrap><%=bean.getHealthCardNo()%>&nbsp;</td>
								<td class="label"><input type="text" name="health_card_num" id="health_card_num" maxlength="20" size="20" value="" readonly>
							</td>
							</tr>	
							<tr id="row3"> <!-- code ' id="row3" 'added for Bru-HIMS-CRF-416[IN045566] -->
								<td  class="label"><fmt:message key="ePH.DispenseLevel.label" bundle="${ph_labels}"/></td>
								<td class="label">
									<select name="disp_level" id="disp_level">
<%
									if(!function_id.equals("PH_PREPARE_ADMIXTURE")){ 					
										if( (bean.getDispLevel()).equals("O")) {
%>
											<option value="O" selected><fmt:message key="ePH.OrderWise.label" bundle="${ph_labels}"/></option>
											<option value="P"><fmt:message key="ePH.PatientWise.label" bundle="${ph_labels}"/></option>
<%
										}
										else if( (bean.getDispLevel()).equals("P")) { 
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
								<td  class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
								<td  class="label">	
								<select name="order_type" id="order_type" onChange="defaultDispLevel(document.frmDispMedicationQueryCriteriaIP,this)">
<%
								if(function_id.equals("PH_PREPARE_ADMIXTURE")){
%>
									<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>					
									<%=ivlegend_option%>					
									<%=tpn_admixture %><!-- //added for ML-MMOH-CRF-0430 [IN:057336] -->
									<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
<%
								}
								else{
%> 
									<option value="ALL" selected><fmt:message key="ePH.ALL_EXCEPT_TPN.label" bundle="${ph_labels}"/></option>
									<option value="NOR"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
									<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
									<%=ivlegend_option%>
									<option value="TD"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
									<option value="CD"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
									<%=tpn_admixture %><!-- //added for ML-MMOH-CRF-0430 [IN:057336] -->
									<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
									<option value="CDR"><fmt:message key="ePH.CDROrders.label" bundle="${ph_labels}"/></option> <!-- Added for ML-MMOH-CRF-0435 [IN:057357] -->
									
<%
								}
%>
								</select>
								&nbsp;<label class="label" id="lbl_nationality" style="font-weight:bold"><%=add_criteria_nat_desc%></label>
								</td> 
<%                if(mobile_no_search){
%>
								<td  class="label" nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
             					<td >&nbsp;
			        			<input type="text" name="pat_mobile_no" id="pat_mobile_no" maxlength="20" size="25" value="">
					          </td><!--Added for TH-KW-CRF-0014 -->

<%}else{%>
                           <!-- Added for JD-CRF-0181 [IN:40699] -->
								<td class="label"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
								<td  class="label"><input type="text" name="order_id" id="order_id"  size="20" maxlength="15" onfocus="this.select();" onBlur="fetchRecord(this);" onkeydown="if (event.keyCode==13) {fetchRecord(this);}" onkeypress="return CheckForSpecChars(event)" value=""><!-- Added 'fetchRecode(this)' for JD-CRF-0181 [IN:045355] // Added onfocus for [IN:45893]-->
								<input type="hidden" name="pat_mobile_no" id="pat_mobile_no" value="" >
								</td>
<%}%>
							</tr>
							 <tr id="row4"> <!-- code ' id="row4" 'added for Bru-HIMS-CRF-416[IN045566] -->
<%if(mobile_no_search){
%>
                       <!-- Added for JD-CRF-0181 [IN:40699] -->
								<td class="label"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
								<td  class="label"><input type="text" name="order_id" id="order_id"  size="20" maxlength="15" onfocus="this.select();" onBlur="fetchRecord(this);" onkeydown="if (event.keyCode==13) {fetchRecord(this);}" onkeypress="return CheckForSpecChars(event)" value=""><!-- Added 'fetchRecode(this)' for JD-CRF-0181 [IN:045355] // Added onfocus for [IN:45893]-->
								</td>
<%}else{%>
								<td  class="label" COLSPAN='2' nowrap> 
									<label style="<%=dispdfltdisplay%>">
										<fmt:message key="ePH.IncFreqDurnOrders.label" bundle="${ph_labels}" />
										&nbsp;
										<input type="checkbox" name="include_orders_by_freq_durn" id="include_orders_by_freq_durn" value="<%=sIncFreqDrus%>" <%=sIncFreqDrusChk%>   >&nbsp;&nbsp;
									</label>&nbsp;
								</td>
<%}%>
								<td  class="label" nowrap>
									<label style="<%=dispdfltdisplay%>">
										<fmt:message key="Common.Include.label" bundle="${common_labels}" />&nbsp;
									</label>
									<fmt:message key="ePH.AbsoluteOrder.label" bundle="${ph_labels}"/>
								</td>
								<td  class="label" nowrap>
									<input type="checkbox" name="include_absolute_orders" id="include_absolute_orders" value="<%=sIncAbsoluteDrugs%>"  <%=sIncAbsoluteDrugsChk%> >
								</td>
								<td  class="label"  nowrap>
									<fmt:message key="ePH.PRNOrder.label" bundle="${ph_labels}"/>&nbsp;
								</td>
								<td  class="label" nowrap>
									<input type="checkbox" name="exclude_PRN_orders" id="exclude_PRN_orders" value="<%=sIncPRNDrugs%>"  <%=sIncPRNDrugsChk%> />
								<!--
								<td  class="label" nowrap ><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${common_labels}"/></td>
								<td  >&nbsp;
									  <select name="drug_medical" id="drug_medical" >
										 <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
										 <option value="Y"><fmt:message key="ePH.DRUGS.label" bundle="${ph_labels}"/></option>
										 <option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${common_labels}"/></option>
									 </select>				
								</td>
								-->
								</td>			
						</tr>	
						<tr id="row5"> <!-- code ' id="row5" 'added for Bru-HIMS-CRF-416[IN045566] -->
<%
							if(tab_based_group_sort_disp==null || !tab_based_group_sort_disp.equals("Y")){
%>
								<td  class="label" COLSPAN='6' nowrap ><fmt:message key="ePH.GROUPBYORDERINGLOCATION.label" bundle="${ph_labels}"/>&nbsp;
								<input type="checkbox" name="group_by_ord_locn" id="group_by_ord_locn" value="Y" checked >
								</td>
<%
							}
							else{
%>
								<input type="hidden" name="group_by_ord_locn" id="group_by_ord_locn" value="">
								<td  class="label" nowrap ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;
								<td class='label' nowrap>
									  <select name="customGroupBy" id="customGroupBy" onchange="changeOrderByDisp(this,'G','A');">
										 <option value="NONE" selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option> 
										 <option value="NURSING_UNIT"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></option> 
										
											<!-- //added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started -->
										 <% 
										 if(isSite_integration_em_bd_pyxis && stage.equals("V")){
											  %>  
											  <option  value="PERFORMING_DEPTLOC_CODE"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></option>
											  <% 
										 } %> 
										 <!-- //added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 ends -->
										 
										 <option value="RELEASE_DATE_TIME"><fmt:message key="ePH.ReleaseDate.label" bundle="${ph_labels}"/></option>
										 <option value="ORD_DATE_TIME"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></option> 
										 <option value="PRIORITY"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option> 
									 </select>	&nbsp;
									 <label id='groupOrderAsc' onclick='displayOrdering("A","G");' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:none'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></label>  
									 <label id='groupOrderSep' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:none'>/ </label>
									 <label id='groupOrderDsc' onclick='displayOrdering("D","G");' style='cursor:pointer;color:blue;font-size:9; FONT-WEIGHT: bolder;display:none'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></label>
									 <input type='hidden' name='customGroupOrder' id='customGroupOrder' value='ASC'>
								</td>
								<td  class="label" nowrap ><fmt:message key="ePH.Sortby.label" bundle="${ph_labels}"/>&nbsp;
								<td class='label' nowrap>
									  <select name="customSortBy" id="customSortBy" onchange="changeOrderByDisp(this,'S','A');">
										 <!-- <option value="NONE"><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>  --> <!-- commented for IN[032898] -->
										 <option value="NURSING_UNIT"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></option> 
										 <option value="RELEASE_DATE_TIME" selected><fmt:message key="ePH.ReleaseDate.label" bundle="${ph_labels}"/></option>
										 <option value="PATIENT_ID"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option> 
										 <option value="PRIORITY"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option> 
									 </select>&nbsp;		
									 <label id='sortOrderAsc' onclick='displayOrdering("A","S");' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:inline'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></label> 
									 <label id='sortOrderSep' style='cursor:default;color:black;font-size:9; FONT-WEIGHT: bolder;display:inline'>/ </label>
									 <label id='sortOrderDsc' onclick='displayOrdering("D","S");' style='cursor:pointer;color:blue;font-size:9; FONT-WEIGHT: normal;display:inline'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></label>
									 <input type='hidden' name='customSortOrder' id='customSortOrder' value='ASC'>
								</td>
								<td  class="label" nowrap ><fmt:message key="ePH.TabBased.label" bundle="${ph_labels}"/>&nbsp;</td>
								<td class="label" nowrap >
									<input type="checkbox" name="customTabBased" id="customTabBased"  value="N" onclick='clickCustomTabBased(this);' />
									<input type="text" name="customTabBasedHrs" id="customTabBasedHrs" id='customTabBasedHrs' size='2' maxlength='3' value="" style='display:none;' onKeyPress="return allowValidNumber(this,event,3,0);" onblur='checkForNumber(this);'/><label id='customTabBasedLabel' style='display:none;' ><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif" align="center"  ></img> </label>

								</td>
<%
								}
%>
						</tr>
						<tr id="row6"> <!-- Added for KDAH-CRF-0338 - Start  -->
						
						
						<%
						//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
								if(isSite_integration_em_bd_pyxis && stage.equals("V")){
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
				<%	}else
					{
				%>
				<input type="hidden" name="disp_locn" id="disp_locn" value="">
					<%
					}//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 ends
	%>
	
	
	
						  <td  class='label'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td> 
				           <td class='label'>
				           <input type='text' name='bed_no' id='bed_no' size='8' maxlength='8' value="" onBlur='ChangeUpperCase(this)' onKeyPress="return CheckForSpecChars(event)" >
				           </td> 
						</tr> <!-- Added for KDAH-CRF-0338 - End  -->
					</table>
<%
				}
%>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="issue_token_on_regn" id="issue_token_on_regn" value="<%=bean.getIssueTokenOnRegnYN()%>">
				<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=bean.getDispLocnCatg()%>">
				<input type="hidden" name="change_status" id="change_status" value="">
				<input type="hidden" name="SQL_PH_DISP_MEDICATION_SELECT32" id="SQL_PH_DISP_MEDICATION_SELECT32" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT32")%>">
				<input type="hidden" name="SQL_PH_ALT_DISP_LOCN_SELECT1D" id="SQL_PH_ALT_DISP_LOCN_SELECT1D" value="<%=PhRepository.getPhKeyValue("SQL_PH_ALT_DISP_LOCN_SELECT1D")%>">
				<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
				<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
				<input type="hidden" name="p_user_name" id="p_user_name" value="<%=p_user_name%>">
				<input type="hidden" name="dflt_disp_level" id="dflt_disp_level" value="<%=bean.getDispLevel()%>">
				<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
				<!-- <input type="hidden" name="function_id" id="function_id" value="<%/*=function_id*/%>"> -->
				<input type="hidden" name="Language_id" id="Language_id" value="<%=locale%>">
				<input type="hidden" name="Language_id1" id="Language_id1" value="<%=locale%>">
				<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
				<input type="hidden" name="tab_based_group_sort_disp" id="tab_based_group_sort_disp" value="<%=tab_based_group_sort_disp%>">
				<input type="hidden" name="homepage" id="homepage" value="<%=homepage%>">
				<input type="hidden" name="ph_print_prescription" id="ph_print_prescription" value="<%=ph_print_prescription%>"> <!-- Added for MMS-DM-CRF-0228 -->
			</form>
		</body>
		<script>
<% 
			if(stage.equals("D") && fill_list.equals("DWF")) {
%>
				document.frmDispMedicationQueryCriteriaIP.fill_proc_date.focus();
				getFillProc();
<%	
			}
			else{
%>
				document.frmDispMedicationQueryCriteriaIP.OrderingFacility.focus();
<%
			}
%>
		</script>

<%
	putObjectInBean(bean_id,bean,request);
} // Added for MOHE-CRF-0074 - start
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>
</html>  <!--  Added for MOHE-CRF-0074 - End -->				

