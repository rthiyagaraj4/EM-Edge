<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,java.text.DecimalFormat,ePH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<title><fmt:message key="ePH.MFRDetails.label" bundle="${ph_labels}"/></title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>		
		<script language="JavaScript" SRC="../../eCommon/js/ValidateControl.js"></script>	
		<script language="JavaScript" SRC="../../eCommon/js/DateUtils.js"></script>	
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script>
		function closeWindow(){
			window.close();
		}
		function returnMFRDetails(){
			var frmobjMFRDet=document.MedicationAdministrationMFRDetails;			
			var retVal=new Array();
			var rowVal=new Array();
			retVal[0]=frmobjMFRDet.totalNoOfRows.value;
			retVal[1]=frmobjMFRDet.order_id.value;
			var locale=frmobjMFRDet.locale.value;
			totalrows=parseInt(frmobjMFRDet.totalNoOfRows.value);
			var count=0;
			var trows=1;
			while(trows<totalrows){
			 	rowVal[count++]= eval("frmobjMFRDet.FlowStatus"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.srl_no"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.holdMinutes"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.gaphours"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.holdDateTime"+trows).value;
			 	rowVal[count++]= convertDate(eval("frmobjMFRDet.MFR_inf_date_time_"+trows).value,"DMYHM",locale,"en");
			 	rowVal[count++]= convertDate(eval("frmobjMFRDet.MFR_end_date_time_"+trows).value,"DMYHM",locale,"en");
			 	rowVal[count++]= eval("frmobjMFRDet.inf_prd"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.MFR_flow_rate_"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.MFR_batch_id_"+trows).value;
			 	rowVal[count++]= convertDate(eval("frmobjMFRDet.MFR_exp_dt_"+trows).value,"DMY",locale,"en");
			 	rowVal[count++]= eval("frmobjMFRDet.resumeDateTime"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.completedMinutes"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.completedFlow"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.Newly_Admin_"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.iv_trade_id_"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.iv_bin_code_"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.inf_volume_"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.tot_strength_uom"+trows).value;
			 	rowVal[count++]= eval("frmobjMFRDet.MFR_flow_rate_"+trows).value;
				trows++;
			}
			retVal[2]=rowVal;
			window.returnValue = retVal;
			window.close();
		}
		</script>
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
<%  	
		String order_id		=	request.getParameter("orderId");
		String order_line_no=	request.getParameter("orderLineNumber");
		String drug_code	=	request.getParameter("drug_code");
		String store_code	=	request.getParameter("store_code");
		String from_time	=	request.getParameter("from_time");
		String Auto_Admin	=	request.getParameter("auto_admin")==null?"":request.getParameter("auto_admin");
		String called_from	=	request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String drug_desc	=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		String disable_batch_lookup_button="";
		if(Auto_Admin.equals("N"))
			disable_batch_lookup_button="disabled";
		drug_desc=java.net.URLEncoder.encode(drug_desc,"UTF-8");
		try{
			String bean_id							= "MedicationAdministrationFTBean";
			String bean_name						= "ePH.MedicationAdministrationFTBean";
			MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
			bean.setLanguageId(locale);
			ArrayList MFRDetailsList = bean.getMFRDetails(order_id,order_line_no);
			ArrayList result						= bean.getCurrentTimeAndAdminWithinHRS();
			String current_date_time				= (String)result.get(0);
			
			
			current_date_time=com.ehis.util.DateUtils.convertDate(current_date_time,"DMYHM",locale,"en");
			ArrayList mfrAdminDtls=new ArrayList();
			if(called_from.equals("MednAdminChart"))
				mfrAdminDtls=bean.getMFRAdminChartDetails(order_id);
%>	
			<form name="MedicationAdministrationMFRDetails" id="MedicationAdministrationMFRDetails">
<%
			if(mfrAdminDtls.size()>0){
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0"  noresize>
					<tr>
						<td Style="background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';"><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/>: <b>
						<%=mfrAdminDtls.get(0)==null?"":(String)mfrAdminDtls.get(0)%> </b></td>
						<td align="right" Style="background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> &nbsp;</td>
						<td Style="background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';"><textarea readonly style='height:30px;width:2in'><%=mfrAdminDtls.get(1)==null?"":(String)mfrAdminDtls.get(1)%></textarea></td>
					</tr>
					<tr><td>&nbsp</td></tr>
				</table>
<%			
			}
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1"  noresize>
				<tr id="iv_admin_table_row1">
					<td class="TDSTYLE"><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/> #</td>
					<td class="TDSTYLE"><fmt:message key="ePH.AdminDose.label" bundle="${ph_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.SchTime.label" bundle="${ph_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.InfusionDate/Time.label" bundle="${ph_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.InfusionPeriod.label" bundle="${ph_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.InfusionEndTime.label" bundle="${ph_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>/<fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/></td>
				</tr>		
<%
				if(MFRDetailsList!=null && MFRDetailsList.size()>0){
					int rowcount=1;
					String flowRateDurationUnit="";
					String infusionPeriodUnit="";
					String flowRateDurationUnitDesc;
					String infusionPeriodUnitDesc;
					String status="";
					String statusString="";
					String infusionDateTime="";
					String infusionEndTime="";
					String batch_id="";
					String expiry_dt="";
					String flow_srl_no="";
					String tot_strength="";
					String tot_strength_uom="";
					String infuse_over="";
					String infusion_rate="";
					String infusion_vol_str_unit="";
					String infusion_vol_str_unit_desc=""; //added for SKR-SCF-0215 [IN:029303]
					String sch_start_date_time="";
					String first_sch_start_date_time="";
					String gap_duration_in_hrs="";
					String hold_durn_in_mins="";
					String hold_date_time="";
					String resume_date_time="";
					String infuse_over_disabled="";
					String completedFlow="0";
					String completedMinutes="0";
					ArrayList batch_ids;
					boolean currentRowFound=false;
					int currentRowNumber=0;
					HashMap MFRDetails;
					for(int i=0;i<MFRDetailsList.size();i++){
						MFRDetails=(HashMap)MFRDetailsList.get(i);
						flow_srl_no = (String)MFRDetails.get("SL_NO")==null?"1":(String)MFRDetails.get("SL_NO");
						tot_strength = (String)MFRDetails.get("TOT_STRENGTH")==null?"":(String)MFRDetails.get("TOT_STRENGTH");
						tot_strength_uom = (String)MFRDetails.get("TOT_STRENGTH_UOM")==null?"":(String)MFRDetails.get("TOT_STRENGTH_UOM");
						infuse_over = (String)MFRDetails.get("INFUSE_OVER")==null?"0":(String)MFRDetails.get("INFUSE_OVER");
						infusionPeriodUnit = (String)MFRDetails.get("INFUSE_OVER_UNIT")==null?"":(String)MFRDetails.get("INFUSE_OVER_UNIT");
						infusion_rate = (String)MFRDetails.get("INFUSION_RATE")==null?"":(String)MFRDetails.get("INFUSION_RATE");

						DecimalFormat dfTest = new DecimalFormat("0.###");
						infusion_rate = dfTest.format(Float.parseFloat(infusion_rate));

						infusion_vol_str_unit = (String)MFRDetails.get("INFUSION_VOL_STR_UNIT")==null?"":(String)MFRDetails.get("INFUSION_VOL_STR_UNIT");
						infusion_vol_str_unit_desc = (String)MFRDetails.get("INFUSION_VOL_STR_UNIT_DESC")==null?"":(String)MFRDetails.get("INFUSION_VOL_STR_UNIT_DESC"); //SKR-SCF-0215 [IN:029303]
						flowRateDurationUnit = (String)MFRDetails.get("INFUSION_PER_UNIT")==null?"":(String)MFRDetails.get("INFUSION_PER_UNIT");			
						sch_start_date_time = (String)MFRDetails.get("START_DATE_TIME")==null?"":(String)MFRDetails.get("START_DATE_TIME");				
						if(i==0)
							first_sch_start_date_time=sch_start_date_time;
						gap_duration_in_hrs = (String)MFRDetails.get("GAP_DURATION_IN_HRS")==null?"":(String)MFRDetails.get("GAP_DURATION_IN_HRS");				
						status=(String)MFRDetails.get("MAR_STATUS")==null?"":(String)MFRDetails.get("MAR_STATUS");
						infusionDateTime=(String)MFRDetails.get("ACT_START_DATE_TIME")==null?"":(String)MFRDetails.get("ACT_START_DATE_TIME");
						infusionEndTime=(String)MFRDetails.get("ACT_END_DATE_TIME")==null?current_date_time:(String)MFRDetails.get("ACT_END_DATE_TIME");
						batch_id=(String)MFRDetails.get("BATCH_ID")==null?"":(String)MFRDetails.get("BATCH_ID");
						expiry_dt=(String)MFRDetails.get("EXPIRY_DATE")==null?"":(String)MFRDetails.get("EXPIRY_DATE");
						hold_durn_in_mins=(String)MFRDetails.get("HOLD_DURN_IN_MINS")==null?"0":(String)MFRDetails.get("HOLD_DURN_IN_MINS");
						completedMinutes=(String)MFRDetails.get("COMPLETED_DURN_IN_MINS")==null?"0":(String)MFRDetails.get("COMPLETED_DURN_IN_MINS");
						completedFlow=(String)MFRDetails.get("COMPLETED_VOLUME")==null?"0":(String)MFRDetails.get("COMPLETED_VOLUME");
						hold_date_time=(String)MFRDetails.get("HOLD_DATE_TIME")==null?"":(String)MFRDetails.get("HOLD_DATE_TIME");
						resume_date_time=(String)MFRDetails.get("RESUME_DATE_TIME")==null?"":(String)MFRDetails.get("RESUME_DATE_TIME");

						flowRateDurationUnitDesc="";
						infusionPeriodUnitDesc="";
						
						if(batch_id.equals("")){
							batch_ids=bean.getAllBatchIDS(order_id,order_line_no,"N");
							if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and and 7 to 9 for GHL-CRF-0482
								batch_id=(String)batch_ids.get(0);
								expiry_dt=(String)batch_ids.get(1);
							}
						}
						else{
							batch_ids=new ArrayList();
						}
						//out.println("batch_ids size==>"+batch_ids.size());
						if(flowRateDurationUnit.equals("M")) 
							flowRateDurationUnitDesc="Mins";
						else if(flowRateDurationUnit.equals("H"))
							flowRateDurationUnitDesc="Hrs";
						if(infusionPeriodUnit.equals("M")) 
							infusionPeriodUnitDesc="Mins";
						else if(infusionPeriodUnit.equals("H"))
							infusionPeriodUnitDesc="Hrs";
						
						if(status.equals("NS")){
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NOTSTARTED.label","ph_labels");
							infuse_over_disabled="";
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("ST")){
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
							infuse_over_disabled="disabled";
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("HO")){
							infuse_over_disabled="disabled";
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOLD.label","ph_labels");
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("RE")){
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
							infuse_over_disabled="disabled";
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("CO")){
							infuse_over_disabled="disabled";
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.COMPLETED.label","ph_labels");
							currentRowFound=false;					
						}
						else{
							statusString="";
							infuse_over_disabled="";
						}
						
						if(infusionDateTime.equals(""))
							infusionDateTime=current_date_time;

						if(currentRowFound && (currentRowNumber==rowcount)){ //this condition is to find the working row
%>
						<tr>
							<td class='IVFLUID1' align="center"><label><%=flow_srl_no%> </label></td>	
							<td class='IVFLUID1'><input type="text" name="inf_volume_<%=rowcount%>" id="inf_volume_<%=rowcount%>" size=2 value="<%=tot_strength%>" disabled> <%=infusion_vol_str_unit_desc%></td>  
							<!-- Add tot_strength_uom is replaced by  infusion_vol_str_unit_desc  for SKR-SCF-0215.1-->	
							<td class='IVFLUID1'><label style="font-size:9;color:black"><%=com.ehis.util.DateUtils.convertDate(sch_start_date_time,"DMYHM","en",locale)%></label></td>	
							<td class='IVFLUID1' style="cursor:pointer;" id='orderctl<%=rowcount%>'onClick="displayToolTip('<%=rowcount%>')" onMouseOver="hideToolTip('<%=rowcount%>')"><B><label style="font-size:10;color:blue;align:center;"><%=statusString%></label></B><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=rowcount%>'></td>	
							<td class='IVFLUID1'><input type="text" value="<%=com.ehis.util.DateUtils.convertDate(infusionDateTime,"DMYHM","en",locale)%>" name="MFR_inf_date_time_<%=rowcount%>" size=13 maxlength=16 style="font-size:11;" disabled></td>	
							<td class='IVFLUID1'><input type="text" value="<%=infusion_rate%>" name="MFR_flow_rate_<%=rowcount%>" size=2 maxlength=9 class="number" style="font-size:11;color:blue" onKeyPress="return allowValidNumber(this,event,6,2);" onBlur="calculateInfusionPeriodMFR('<%=rowcount%>')" <%=infuse_over_disabled%>><b><label style="font-size:10;"><%=infusion_vol_str_unit_desc%>/<%=flowRateDurationUnitDesc%></label></b></td>
							<!--infusion_vol_str_unit changed to infusion_vol_str_unit_desc SKR-SCF-0215 [IN:029303]-->
							<td class='IVFLUID1'><input type="text" value="" name="MFR_inf_prd_<%=rowcount%>" id="MFR_inf_prd_<%=rowcount%>"  size=1 maxlength=6 class="number" disabled> <b><label style="font-size:10;"><%=infusionPeriodUnitDesc%><div id="sch_inf_per_MFR_<%=rowcount%>">&nbsp;</div></label></b></td>	
							<td class='IVFLUID1'><input type="text" name="MFR_end_date_time_<%=rowcount%>" id="MFR_end_date_time_<%=rowcount%>" value="<%=com.ehis.util.DateUtils.convertDate(infusionEndTime,"DMYHM","en",locale)%>" size=13 maxlength=16 style="font-size:11;" disabled></td>	
							<td class='IVFLUID1'>
<%						
							if(!batch_id.equals("")){
%>
								<input type=text value="<%=batch_id%>" name="MFR_batch_id_<%=rowcount%>" size=8 maxlength=10 disabled> <input type=text value="<%=com.ehis.util.DateUtils.convertDate(expiry_dt,"DMY","en",locale)%>" name="MFR_exp_dt_<%=rowcount%>" size=13 maxlength=16 disabled>
								<input type="hidden" value="" name="Newly_Admin_<%=rowcount%>" id="Newly_Admin_<%=rowcount%>">

<%					
							}
							else if(batch_ids.size()>9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
%>
								<select name="MFR_batch_id_<%=rowcount%>" id="MFR_batch_id_<%=rowcount%>" style="font-size:11" onChange="assignBatchDetails('MFR','MFR',this,'<%=rowcount%>')">
								<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
								for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
%>
									<option  value="<%=(String)batch_ids.get(kk)%>"> <%=(String)batch_ids.get(kk)%></option>
<%
								}
%>	
								</select>
								<input type=text value="" name="MFR_exp_dt_<%=rowcount%>" id="MFR_exp_dt_<%=rowcount%>" size=13 maxlength=16 disabled>
								<input type="hidden" value="" name="Newly_Admin_<%=rowcount%>" id="Newly_Admin_<%=rowcount%>">

<%					
							}
							else{
%>
								<input type=text value="" name="MFR_batch_id_<%=rowcount%>" id="MFR_batch_id_<%=rowcount%>" size=8 maxlength=10 disabled> 
								<input type=text value="" name="MFR_exp_dt_<%=rowcount%>" id="MFR_exp_dt_<%=rowcount%>" size=13 maxlength=16 disabled>
								<input type="button" class="button" value="?" name="MFR_batch_id_but_<%=rowcount%>" id="MFR_batch_id_but_<%=rowcount%>" onClick="callMednBatchSearchMFR('<%=rowcount%>')" <%=disable_batch_lookup_button%>>
								<input type="hidden" value="IV_Y" name="Newly_Admin_<%=rowcount%>" id="Newly_Admin_<%=rowcount%>">
<%
							}
%>
							</td>
							<td class='IVFLUID1' align="center"><label style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openAuditLogWindow('<%=rowcount%>');"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></label></td>	
							</tr>
<%				
						}
						else{
%>
							<tr>
								<td class='IVFLUID1' align="center"><label> <%=flow_srl_no%> </label></td>	
								<td class='IVFLUID1'><input type="text" name="inf_volume_<%=rowcount%>" id="inf_volume_<%=rowcount%>" size=2 value="<%=tot_strength%>" disabled> <%=infusion_vol_str_unit_desc%></td>	<!-- changed tot_strength_uom to  infusion_vol_str_unit_desc for SKR-SCF-0215.1-->	
								<td class='IVFLUID1'><label style="font-size:9;color:black"><%=com.ehis.util.DateUtils.convertDate(sch_start_date_time,"DMYHM","en",locale)%></label></td>	
								<td class='IVFLUID1' id='orderctl<%=rowcount%>' onClick="displayToolTip('<%=rowcount%>')" onMouseOver="hideToolTip('<%=rowcount%>')"> <B><label style="font-size:10;align:center;"><%=statusString%></label></B><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=rowcount%>'></td>	
								<td class='IVFLUID1'><input type="text" value="<%=com.ehis.util.DateUtils.convertDate(infusionDateTime,"DMYHM","en",locale)%>" name="MFR_inf_date_time_<%=rowcount%>" size=13 maxlength=16 style="font-size:11;" disabled></td>	
								<td class='IVFLUID1'><input type="text" value="<%=infusion_rate%>" name="MFR_flow_rate_<%=rowcount%>" size=2 maxlength=9 class="number" style="font-size:11;color:blue" disabled onBlur="calculateInfusionPeriodMFR('<%=rowcount%>')" onKeyPress="return allowValidNumber(this,event,6,2);"><b><label style="font-size:10;"><%=infusion_vol_str_unit_desc%>/<%=flowRateDurationUnitDesc%></label></b></td>
								<!--infusion_vol_str_unit changed to infusion_vol_str_unit_desc SKR-SCF-0215 [IN:029303]-->
								<td class='IVFLUID1'><input type="text" value="" name="MFR_inf_prd_<%=rowcount%>" id="MFR_inf_prd_<%=rowcount%>"  size=1 maxlength=6 class="number" disabled> <b><label style="font-size:10;"><%=infusionPeriodUnitDesc%><div id="sch_inf_per_MFR_<%=rowcount%>">&nbsp;</div></label></b></td>	
								<td class='IVFLUID1'><input type="text" name="MFR_end_date_time_<%=rowcount%>" id="MFR_end_date_time_<%=rowcount%>" value="<%=com.ehis.util.DateUtils.convertDate(infusionEndTime,"DMYHM","en",locale)%>" size=13 maxlength=16 style="font-size:11;" disabled></td>	
								<td class='IVFLUID1'>
<%
								if(!batch_id.equals("")){
%>
									<input type=text value="<%=batch_id%>" name="MFR_batch_id_<%=rowcount%>" size=8 maxlength=10 disabled> <input type=text value="<%=com.ehis.util.DateUtils.convertDate(expiry_dt,"DMYHM","en",locale)%>" name="MFR_exp_dt_<%=rowcount%>" size=13 maxlength=16 disabled>
									<input type="hidden" value="" name="Newly_Admin_<%=rowcount%>" id="Newly_Admin_<%=rowcount%>">

<%
								}
								else if(batch_ids.size()>9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
%>
									<select name="MFR_batch_id_<%=rowcount%>" id="MFR_batch_id_<%=rowcount%>" style="font-size:11" onChange="assignBatchDetails('MFR','MFR',this,'<%=rowcount%>')" disabled>
									<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
									for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8
%>
										<option  value="<%=(String)batch_ids.get(kk)%>"> <%=(String)batch_ids.get(kk)%></option>
<%
									}
%>		
									</select>
									<input type=text value="" name="MFR_exp_dt_<%=rowcount%>" id="MFR_exp_dt_<%=rowcount%>" size=13 maxlength=16 disabled>
									<input type="hidden" value="" name="Newly_Admin_<%=rowcount%>" id="Newly_Admin_<%=rowcount%>">
<%
								}
								else{
%>
									<input type=text value="" name="MFR_batch_id_<%=rowcount%>" id="MFR_batch_id_<%=rowcount%>" size=8 maxlength=10 disabled> 
									<input type=text value="" name="MFR_exp_dt_<%=rowcount%>" id="MFR_exp_dt_<%=rowcount%>" size=13 maxlength=16 disabled>
									<input type="button" class="button" value="?" name="MFR_batch_id_but_<%=rowcount%>" id="MFR_batch_id_but_<%=rowcount%>" onClick="callMednBatchSearchMFR('<%=rowcount%>')" disabled>
									<input type="hidden" value="IV_Y" name="Newly_Admin_<%=rowcount%>" id="Newly_Admin_<%=rowcount%>">
<%	
								}
%>					
								</td>	
								<td class='IVFLUID1' align="center"><label style="font-size:10;color:blue;cursor:pointer;align:center;" onClick="openAuditLogWindow('<%=rowcount%>');"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></label></td>	
								</tr>	
<%				
							}
%>
							<input type="hidden" name="FlowStatus<%=rowcount%>" id="FlowStatus<%=rowcount%>" id="FlowStatus<%=rowcount%>" value='<%=status%>'>
							<input type="hidden" name="srl_no<%=rowcount%>" id="srl_no<%=rowcount%>" id="srl_no<%=rowcount%>" value="<%=flow_srl_no%>">
							<input type="hidden" name="holdMinutes<%=rowcount%>" id="holdMinutes<%=rowcount%>" id="holdMinutes<%=rowcount%>" value="<%=hold_durn_in_mins%>">
							<input type="hidden" name="completedMinutes<%=rowcount%>" id="completedMinutes<%=rowcount%>" id="completedMinutes<%=rowcount%>" value="<%=completedMinutes%>">
							<input type="hidden" name="completedFlow<%=rowcount%>" id="completedFlow<%=rowcount%>" id="completedFlow<%=rowcount%>" value="<%=completedFlow%>">
							<input type="hidden" name="gaphours<%=rowcount%>" id="gaphours<%=rowcount%>" id="gaphours<%=rowcount%>" value="<%=gap_duration_in_hrs%>">
							<input type="hidden" name="holdDateTime<%=rowcount%>" id="holdDateTime<%=rowcount%>" id="holdDateTime<%=rowcount%>" value="<%=hold_date_time%>">
							<input type="hidden" name="resumeDateTime<%=rowcount%>" id="resumeDateTime<%=rowcount%>" id="resumeDateTime<%=rowcount%>" value="<%=resume_date_time%>">
							<input type="hidden" name="inf_prd_hrs<%=rowcount%>" id="inf_prd_hrs<%=rowcount%>" value="">
							<input type="hidden" name="inf_prd_min<%=rowcount%>" id="inf_prd_min<%=rowcount%>" value="">
							<input type="hidden" name="inf_prd<%=rowcount%>" id="inf_prd<%=rowcount%>" value="<%=infuse_over%>">
							<input type="hidden" name="batch_id<%=rowcount%>" id="batch_id<%=rowcount%>" id="batch_id<%=rowcount%>" value="<%=batch_id%>">
							<input type="hidden" name="flowRateDurationUnit<%=rowcount%>" id="flowRateDurationUnit<%=rowcount%>" value="<%=flowRateDurationUnit%>">
							<input type="hidden" name="flowRateDurationUnitDesc<%=rowcount%>" id="flowRateDurationUnitDesc<%=rowcount%>" value="<%=flowRateDurationUnitDesc%>">
							<input type="hidden" name="infusion_vol_str_unit<%=rowcount%>" id="infusion_vol_str_unit<%=rowcount%>" value="<%=infusion_vol_str_unit%>">
							<input type="hidden" name="infusion_vol_str_unit_desc<%=rowcount%>" id="infusion_vol_str_unit_desc<%=rowcount%>" value="<%=infusion_vol_str_unit_desc%>"> <!--Added for SKR-SCF-0215 [IN:029303]-->
							<input type="hidden" name="iv_trade_id_<%=rowcount%>" id="iv_trade_id_<%=rowcount%>" value="">
							<input type="hidden" name="iv_bin_code_<%=rowcount%>" id="iv_bin_code_<%=rowcount%>" value="" >
							<input type="hidden" name="tot_strength_uom<%=rowcount%>" id="tot_strength_uom<%=rowcount%>" value="<%=tot_strength_uom%>">
							<input type="hidden" name="infusionPeriodUnit<%=rowcount%>" id="infusionPeriodUnit<%=rowcount%>" value="<%=infusionPeriodUnit%>"> <!-- Added for SRR20056-SCF-7137.1 IN028154, PH-Incident No.# 28218 -->
		
							<script language='javascript'>
								getHrsMinStrMFR('<%=infuse_over%>','<%=infuse_over%>','<%=infusionPeriodUnit%>','<%=rowcount%>')
							</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%					
							rowcount++;
						}
%>
						<input type="hidden" name="currentRowNumber" id="currentRowNumber" id="currentRowNumber" value="<%=currentRowNumber%>">
						<input type="hidden" name="totalNoOfRows" id="totalNoOfRows" id="totalNoOfRows" value="<%=rowcount%>">
						<input type="hidden" name="order_id" id="order_id" id="order_id" value="<%=order_id%>">
						<input type="hidden" name="drug_desc" id="drug_desc" id="drug_desc" value="<%=drug_desc%>">
						<input type="hidden" name="drug_code" id="drug_code" id="drug_code" value="<%=drug_code%>">
						<input type="hidden" name="store_code" id="store_code" id="store_code" value="<%=store_code%>">
						<input type="hidden" name="current_date_time" id="current_date_time" id="current_date_time" value="<%=current_date_time%>">
						<input type="hidden" name="locale" id="locale" value="<%=locale%>">
						<input type="hidden" name="from_time" id="from_time" value="<%=from_time%>">
						<input type="hidden" name="auto_admin" id="auto_admin" value="<%=Auto_Admin%>">
						<input type="hidden" name="first_sch_start_date_time" id="first_sch_start_date_time" id="first_sch_start_date_time" value="<%=first_sch_start_date_time%>">
						<script>
							var cuRoNum=document.getElementById("currentRowNumber").value; 
							if(cuRoNum>0){
								var actDtTime=eval("document.MedicationAdministrationMFRDetails.MFR_inf_date_time_"+cuRoNum).value
								calcDatesForMFR(cuRoNum,actDtTime,document.getElementById("totalNoOfRows").value);
							}
						</script>
<%
					}
%>		
					<tr>
						<td colspan="10" align='Right'>
						<input type="button" name="btnOK" id="btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="returnMFRDetails();">&nbsp;
						<input type="button" name="btnCANCEL" id="btnCANCEL" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="closeWindow();">
						</td>
					</tr>
				</table>
			</form>
			<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='blue'>
				<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
					<tr>
						<td width='100%' id='t'></td>
						</td>
					</tr>
				</table>
			</div>
<%
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
%>
	</body>
</html>

