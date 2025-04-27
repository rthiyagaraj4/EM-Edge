<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patientId	=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	String encounterId	=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String height		=request.getParameter("height")==null?"":request.getParameter("height");
	String weight		=request.getParameter("weight")==null?"":request.getParameter("weight");
	String ocurrance_num = request.getParameter("ocurrance_num")==null?"":request.getParameter("ocurrance_num");
	String volume		=request.getParameter("volume")==null?"":request.getParameter("volume");
	String base_volume		=request.getParameter("base_volume")==null?"":request.getParameter("base_volume");
	String inf_rate		=request.getParameter("inf_rate")==null?"":request.getParameter("inf_rate");
	String inf_over_hr	=request.getParameter("inf_over_hr")==null?"":request.getParameter("inf_over_hr");
	String inf_over_min	=request.getParameter("inf_over_min")==null?"":request.getParameter("inf_over_min");
	String start_date	=request.getParameter("start_date")==null?"":request.getParameter("start_date");
	String end_date		=request.getParameter("end_date")==null?"":request.getParameter("end_date");
// new var - prev order copy MFR issue : 26465
	String previous		=request.getParameter("previous")==null?"":request.getParameter("previous");

	String stock_uom_code=request.getParameter("stock_uom_code")==null?"":request.getParameter("stock_uom_code");
	String InfRateHrMin	=request.getParameter("InfRateHrMin")==null?"":request.getParameter("InfRateHrMin");
	String mode	=request.getParameter("mode")==null?"":request.getParameter("mode");
	String gap_hr = "";
	String gap_min				= "";
	HashMap record				= new HashMap();
	String tot_volume			= volume;
	//if(base_volume.equals(""))
		//base_volume				= volume;
	inf_over_hr					= inf_over_hr.length() == 1 ? ("0"+inf_over_hr):inf_over_hr;
	inf_over_min				= inf_over_min.length() == 1 ? ("0"+inf_over_min):inf_over_min;
	String tot_flow_durn		=inf_over_hr+":"+inf_over_min;
	String tot_durn				=tot_flow_durn;
	String admin_rate_detail	="";

	String tot_flow_durn_hr		="";
	String tot_flow_durn_mi		="";
	String tot_durn_hr			="";
	String tot_durn_mi			="";
	String gap			="";
	Double Dtemp = null;
	String ivType		=request.getParameter("ivType")==null?"":request.getParameter("ivType");
	String fluid_code	=request.getParameter("fluid_code")==null?"":request.getParameter("fluid_code");
	String drug_code	=request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String bean_id		=request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
	String bean_name	=request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
	int totRecs = 1;
	String temp="";
	String adminRateHidden=request.getParameter("adminRateHidden")==null?"":request.getParameter("adminRateHidden");
	String infusionOverInsertValue	=request.getParameter("infusion_over_insert_value")==null?"":request.getParameter("infusion_over_insert_value");
	HashMap MultiFlowRecs = new HashMap();

	ArrayList rec = new ArrayList();
	ArrayList amendMfrRec = new ArrayList();
	HashMap amendMfrRecDtl = new HashMap();
	inf_over_hr = inf_over_hr.length() == 0 ? ("00"):inf_over_hr;
	inf_over_hr = inf_over_hr.length() == 1 ? ("0"+inf_over_hr):inf_over_hr;

	inf_over_min = inf_over_min.length() == 1 ? ("0"+inf_over_min):inf_over_min;
	tot_flow_durn=inf_over_hr+":"+inf_over_min;
	
	tot_durn_hr = tot_durn_hr.length() == 1 ? ("0"+tot_durn_hr):tot_durn_hr;
	tot_durn_mi = tot_durn_mi.length() == 1 ? ("0"+tot_durn_mi):tot_durn_mi;
	tot_durn=tot_durn_hr+":"+tot_durn_mi;
	if(tot_durn_hr.equals("") && tot_durn_mi.equals("")  )
		tot_durn = tot_flow_durn;
	OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name,request) ;

	String stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code);  

	if(stock_uom_desc==null || stock_uom_desc.equals(""))//Added for CRF-1014
		stock_uom_desc = stock_uom_code;

	MultiFlowRecs = bean.getMFRRecs();

	System.err.println("OncologyRegimenMFR.jsp----92-->");
	if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){

		temp = (String)MultiFlowRecs.get("totRec")==null?"0":(String)MultiFlowRecs.get("totRec");
		totRecs = Integer.parseInt(temp);
		tot_volume = (String)MultiFlowRecs.get("totInfVolume")==null?"":(String)MultiFlowRecs.get("totInfVolume");
		tot_flow_durn= (String)MultiFlowRecs.get("totFlowDurn")==null?"":(String)MultiFlowRecs.get("totFlowDurn");
		tot_durn= (String)MultiFlowRecs.get("totDuration")==null?"":(String)MultiFlowRecs.get("totDuration");
		

	}//else{

		if(mode.equals("amend") || (tot_flow_durn.equals("") && tot_durn.equals("") && !tot_volume.equals(""))){
			tot_flow_durn= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
			tot_durn= (String)MultiFlowRecs.get("totDurnHrs")==null?"":(String)MultiFlowRecs.get("totDurnHrs");
//out.println("@100 tot_flow_durn ="+tot_flow_durn+">>> tot_durn = "+tot_durn);
	/*		out.println("=in amend=");
			//flow enters here only in amend mode for the first time when they click mfr link
			record = (HashMap)(bean.getAllExistingIVOrders()).get(0);
			tot_flow_durn	= record.get("TOT_FLOW_DRUN")==null?"0":(String)record.get("TOT_FLOW_DRUN");
			tot_flow_durn	= record.get("totFlowDurnHrs")==null?"0":(String)record.get("totFlowDurnHrs");
			tot_volume		= (String)record.get("TOT_VOLUME");
			tot_durn		= record.get("TOT_DURN")==null?"0":(String)record.get("TOT_DURN");*/

			if(tot_flow_durn.indexOf(".") != -1){
				tot_flow_durn_hr = tot_flow_durn.substring(0,tot_flow_durn.indexOf("."));
				Dtemp = new Double(tot_flow_durn);
				Dtemp = Dtemp*60;
				Dtemp = (Dtemp%60);

				tot_flow_durn_mi = Math.round(Dtemp)+""; 
				if(tot_flow_durn_mi.indexOf(".") != -1)
					tot_flow_durn_mi = tot_flow_durn_mi.substring(0,tot_flow_durn_mi.indexOf("."));  
			}else{
				tot_flow_durn_hr = tot_flow_durn;
				tot_flow_durn_mi = "";
			}

			tot_flow_durn_hr = tot_flow_durn_hr.equals("")?"00":tot_flow_durn_hr;
			tot_flow_durn_mi = tot_flow_durn_mi.equals("")?"00":tot_flow_durn_mi;

			tot_flow_durn_hr = tot_flow_durn_hr.length() == 1 ? ("0"+tot_flow_durn_hr):tot_flow_durn_hr;
			tot_flow_durn_mi = tot_flow_durn_mi.length() == 1 ? ("0"+tot_flow_durn_mi):tot_flow_durn_mi;

			tot_flow_durn = tot_flow_durn_hr+":"+tot_flow_durn_mi;

			if(tot_durn.indexOf(".") != -1){
				tot_durn_hr = tot_durn.substring(0,tot_durn.indexOf("."));
				Dtemp = new Double(tot_durn);
				Dtemp = Dtemp*60;
				Dtemp = (Dtemp%60);

				tot_durn_mi = Math.round(Dtemp)+""; 
				if(tot_durn_mi.indexOf(".") != -1)
					tot_durn_mi = tot_durn_mi.substring(0,tot_durn_mi.indexOf("."));  
			}else{
				tot_durn_hr = tot_durn;
				tot_durn_mi = "";
			}
			tot_durn_hr = tot_durn_hr.equals("")?"00":tot_durn_hr;
			tot_durn_mi = tot_durn_mi.equals("")?"00":tot_durn_mi;
			tot_durn_hr = tot_durn_hr.length() == 1 ? ("0"+tot_durn_hr):tot_durn_hr;
			tot_durn_mi = tot_durn_mi.length() == 1 ? ("0"+tot_durn_mi):tot_durn_mi;
			tot_durn = tot_durn_hr+":"+tot_durn_mi;
//out.println("@149 tot_durn = "+tot_durn);
		}
	//}
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/OncologyRegimenMFR.js"></SCRIPT>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




	<title><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></title>
</head>
<%
	
%>
<BODY onMouseDown="" onKeyDown="lockKey()" > 
	<form name="formOngoIVPrescriptionMFR" id="formOngoIVPrescriptionMFR">
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<tr >
				<td class='label' >
					<fmt:message key="ePH.TotalInfusionVolume.label" bundle="${ph_labels}"/>
					<input type="text" name="TotInfVolume" id="TotInfVolume" value="<%=tot_volume%>" readonly style="text-align:right"><label id='TotInfVolUnit' maxlength='10'><%=stock_uom_desc%></label> 
				</td>
				<td class='label' >
					<fmt:message key="ePH.TotalInfuseDuration.label" bundle="${ph_labels}"/>
					<input type="text" name="TotFlowDurn" id="TotFlowDurn" value='<%=tot_flow_durn%>' readonly style="text-align:right" maxlength='10'><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
				</td>
				<td class='label'>
					<fmt:message key="ePH.TotalDuration.label" bundle="${ph_labels}"/>
					<input type="text" name="TotDuration" id="TotDuration" value='<%=tot_durn%>' readonly style="text-align:right" maxlength='10'><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
				</td>
			</tr>
		</table>
		<table id='mfrTable' >
			<tr>
				<td class="COLUMNHEADER" width='6%'>
					<fmt:message key="ePH.FlowRateNo.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='9%' >
					<fmt:message key="ePH.InfuseVol.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='18%'>
					<fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='13%'>
					<fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='10%'>
					<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='10%'>
					<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='13%'>
					<fmt:message key="ePH.InfusionGapTime.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='14%'>
					&nbsp;&nbsp;
				</td>
			</tr>

<%		
	System.err.println("OncologyRegimenMFR.jsp----221======MultiFlowRecs=-->"+MultiFlowRecs);
	String dateDisabled = "";
	if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
		for(int i=1; i<=totRecs; i++){
			rec			= (ArrayList)MultiFlowRecs.get("MFR"+i);
			if(i > 1)
				dateDisabled = "disabled";
			volume		= (String)rec.get(0);
			inf_rate	= (String)rec.get(1);
			InfRateHrMin= (String)rec.get(2);
			inf_over_hr	= ((String)rec.get(3)).equals("")?"0":(String)rec.get(3);
			inf_over_min= ((String)rec.get(4)).equals("")?"0":(String)rec.get(4);
			infusionOverInsertValue	= (String)rec.get(5);
			start_date	= (String)rec.get(6);
			end_date	= (String)rec.get(7);
// assigning current date/future date to start_date - prev order copy MFR issue : 26465
			if(previous.equals("previous") && i == 1){
				start_date	= request.getParameter("start_date")==null?(String)rec.get(6):request.getParameter("start_date");
			}
			gap_hr	= (String)rec.get(8);
			gap_min	= (String)rec.get(9);
			gap=(String)rec.get(10);
%>
			<tr>
				<td class='label' >&nbsp;<%=i%></td>
				<td class='label' >
					<input type="text" name="InfVolume<%=i%>" id="InfVolume<%=i%>" class="number" value="<%=volume%>"  maxlength='5' size='5' onKeyPress="return allowValidNumber(this,event,5,0);" onblur='setInfuseOverValue(<%=i%>);populateDate(<%=i%>)' onchange="showValidateGif(<%=i%>)"><label id='InfVolUnit<%=i%>'><%=stock_uom_desc%></label>
					<!-- Changed stock_uom_code to stock_uom_desc , SKR-SCF-0215.1 -->
				</td>
				<td class='label' >
					<input type="text" name="InfRate<%=i%>" id="InfRate<%=i%>" class="number"  value="<%=inf_rate%>"  maxlength='7' size='7' onKeyPress="return allowValidNumber(this,event,6,2);" onblur='setInfuseOverValue(<%=i%>);populateDate(<%=i%>)' onchange="showValidateGif(<%=i%>)"><label id='InfRateUnit<%=i%>'><%=stock_uom_desc%>/</label>
					<!-- Changed stock_uom_code to stock_uom_desc , SKR-SCF-0215.1 -->
					<select name='InfRateHrMin<%=i%>' id='InfRateHrMin<%=i%>' onChange='setInfuseOverValue(<%=i%>);populateDate(<%=i%>);showValidateGif(<%=i%>)'>
<%						if (InfRateHrMin.equals("H")){
%>							<option value='H' selected><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
							<option value='M'><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option> 
							
<%						}else{ %>
							<option value='H' ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
							<option value='M' selected><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
<%						}%>					
					</select>
				</td>
				<td class='label' >
					<input type="text"  width='3%' class="number" size='1' maxlength="2" name="InfOverHr<%=i%>" id="InfOverHr<%=i%>" value='<%=inf_over_hr%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkHr(<%=i%>);setInfuseRateValue(<%=i%>);populateDate(<%=i%>)" onchange="showValidateGif(<%=i%>)">
					<b>:</b>
					<input type="text"  width='3%' class="number" size='1' maxlength="2" name="InfOverMin<%=i%>" id="InfOverMin<%=i%>" value='<%=inf_over_min%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkMin(<%=i%>);setInfuseRateValue(<%=i%>);populateDate(<%=i%>)" onchange="showValidateGif(<%=i%>)"><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
					<input type="hidden" name="infusion_over_insert_value<%=i%>" id="infusion_over_insert_value<%=i%>" value='<%=infusionOverInsertValue%>'>
				</td>
				<td class='label' >
					<input type="text" name="StartDateTime<%=i%>" id="StartDateTime<%=i%>" <%=dateDisabled%> value='<%=start_date%>' size="14" maxlength="16" onblur="return validateDate(<%=i%>);populateDate(<%=i%>)" onchange="showValidateGif(<%=i%>)">&nbsp;<IMG src="../../eCommon/images/CommonCalendar.gif" id=Calendar  <%=dateDisabled%> onclick="showCalendar('StartDateTime<%=i%>',null,'hh:mm');this.focus();showValidateGif(<%=i%>);return false;" >&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img> 
				</td>
				<td class='label' >
					<input type="text" name="EndDateTime<%=i%>" id="EndDateTime<%=i%>" value='<%=end_date%>' disabled size="14" maxlength="12"  >
				</td>
				<td class='label' >
					<input type="text" name="InfGapHr<%=i%>" id="InfGapHr<%=i%>"  width='3%' class="number" size='1' maxlength="2" value='<%=gap_hr%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkHrGap(<%=i%>)" onchange="showValidateGif(<%=i%>)">
					<b>:</b>
					<input type="text" name="InfGapMin<%=i%>" id="InfGapMin<%=i%>"  width='3%' class="number" size='1' maxlength="2" value='<%=gap_min%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkMinGap(<%=i%>)" onchange="showValidateGif(<%=i%>)"><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
					<input type='hidden' name='InfGapInHr<%=i%>' id='InfGapInHr<%=i%>' value='<%=gap%>'>
				</td>
				<td class='label' >
<%
				if(!adminRateHidden.equals("hidden")) {
%>
					<a href onClick="adminRate(<%=i%>)" onMouseOver="changeCursor(this);" id='adminrate<%=i%>'><fmt:message key="ePH.AdminRate.label" bundle="${ph_labels}"/></a>
<%
	}
%>
					<img src="../../eCommon/images/enabled.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'<%=i%>','validate')" id='validate<%=i%>' style="visibility:hidden">
<%
					if(i==totRecs){
%>
						<img src="../../eCommon/images/nolines_plus.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'<%=i%>')" id='add<%=i%>'>
						<img src="../../eCommon/images/disabled.gif" onMouseOver="changeCursor(this)" onclick="deleteRow(this,'<%=i%>')" id='del<%=i%>'>
<%					
					}
					else{
%>
					<img src="../../eCommon/images/nolines_plus.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'<%=i%>')" id='add<%=i%>' style="visibility:hidden">
					<img src="../../eCommon/images/disabled.gif" onMouseOver="changeCursor(this)" onclick="deleteRow(this,'<%=i%>')" id='del<%=i%>' style="visibility:hidden">
<%	
					}
%>
				</td>
			</tr>
<%	
		}
	}
	else if(record != null && record.size() > 0){
		//out.println("record=="+record);
		amendMfrRec = (ArrayList)record.get("MFR_RECS");
		int i = 0;
		totRecs = amendMfrRec.size();
		for(int j=0; j<amendMfrRec.size(); j++){
			amendMfrRecDtl		= (HashMap)amendMfrRec.get(j);
			i = j+1;
			if(i > 1)
				dateDisabled = "disabled";
			volume		= (String)amendMfrRecDtl.get("TOT_STRENGTH");
			inf_rate	= (String)amendMfrRecDtl.get("INFUSION_RATE");
			InfRateHrMin= (String)amendMfrRecDtl.get("INFUSION_PER_UNIT");
			infusionOverInsertValue = (String)amendMfrRecDtl.get("INFUSE_OVER");
			if(infusionOverInsertValue.indexOf(".") != -1){
				inf_over_hr = infusionOverInsertValue.substring(0,infusionOverInsertValue.indexOf("."));
				Dtemp = new Double(infusionOverInsertValue);
				Dtemp = Dtemp*60;
				Dtemp = (Dtemp%60);

				inf_over_min = Math.round(Dtemp)+""; 
				if(inf_over_min.indexOf(".") != -1)
					inf_over_min = inf_over_min.substring(0,inf_over_min.indexOf("."));  
			}else{
				inf_over_hr = infusionOverInsertValue;
				inf_over_min = "";
			}
			inf_over_hr = inf_over_hr.equals("")?"0":inf_over_hr;
			inf_over_min = inf_over_min.equals("")?"0":inf_over_min;


			start_date	= (String)amendMfrRecDtl.get("START_DATE_TIME");
			end_date	= (String)amendMfrRecDtl.get("END_DATE_TIME");
			admin_rate_detail	= (String)amendMfrRecDtl.get("ADMIN_RATE_DETAIL");
			gap = (String)amendMfrRecDtl.get("GAP_DURATION_IN_HRS");
			if(gap.indexOf(".") != -1){
				gap_hr = gap.substring(0,gap.indexOf("."));
				Dtemp = new Double(gap);
				Dtemp = Dtemp*60;
				Dtemp = (Dtemp%60);

				gap_min = Math.round(Dtemp)+""; 
				if(gap_min.indexOf(".") != -1)
					gap_min = gap_min.substring(0,gap_min.indexOf("."));  
			}else{
				gap_hr = gap;
				gap_min = "";
			}
			gap_hr = gap_hr.equals("")?"":gap_hr;
			gap_min = gap_min.equals("")?"":gap_min;

//			gap_hr	= (String)amendMfrRecDtl.get(8);
//			gap_min	= (String)amendMfrRecDtl.get(9);

%>
			<tr>
				<td class='label' >&nbsp;<%=i%></td>
				<td class='label' >
					<input type="text" name="InfVolume<%=i%>" id="InfVolume<%=i%>" class="number" value="<%=volume%>"  maxlength='5' size='5' onKeyPress="return allowValidNumber(this,event,5,0);" onchange="showValidateGif(<%=i%>)"><label id='InfVolUnit<%=i%>'><%=stock_uom_desc%></label>	<!-- Changed stock_uom_code to stock_uom_desc , SKR-SCF-0215.1 -->
				</td>
				<td class='label' >
					<input type="text" name="InfRate<%=i%>" id="InfRate<%=i%>" class="number"  value="<%=inf_rate%>"  maxlength='7' size='7' onKeyPress="return allowValidNumber(this,event,6,2);" onblur='setInfuseOverValue(<%=i%>);populateDate(<%=i%>)' onchange="showValidateGif(<%=i%>)"><label id='InfRateUnit<%=i%>'><%=stock_uom_desc%>/</label><!-- Changed stock_uom_code to stock_uom_desc , SKR-SCF-0215.1 -->
					<select name='InfRateHrMin<%=i%>' id='InfRateHrMin<%=i%>' onChange='setInfuseOverValue(<%=i%>);populateDate(<%=i%>);showValidateGif(<%=i%>)'>
<%
					if (InfRateHrMin.equals("H")){
%>						<option value='H' selected><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
							
<%						
					}
					else{
%>
						<option value='H' ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
						<option value='M' selected><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
<%						
					}
%>					
					</select>
				</td>
				<td class='label' >
					<input type="text"  width='3%' class="number" size='1' maxlength="2" name="InfOverHr<%=i%>" id="InfOverHr<%=i%>" value='<%=inf_over_hr%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkHr(<%=i%>);setInfuseRateValue(<%=i%>);populateDate(<%=i%>)" onchange="showValidateGif(<%=i%>)">
					<b>:</b>
					<input type="text"  width='3%' class="number" size='1' maxlength="2" name="InfOverMin<%=i%>" id="InfOverMin<%=i%>" value='<%=inf_over_min%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkMin(<%=i%>);setInfuseRateValue(<%=i%>);populateDate(<%=i%>)" onchange="showValidateGif(<%=i%>)" ><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
					<input type="hidden" name="infusion_over_insert_value<%=i%>" id="infusion_over_insert_value<%=i%>" value='<%=infusionOverInsertValue%>'>
				</td>
				<td class='label' >
					<input type="text" name="StartDateTime<%=i%>" id="StartDateTime<%=i%>" <%=dateDisabled%> value='<%=start_date%>' size="14" maxlength="16" onblur="return validateDate(<%=i%>);populateDate(<%=i%>)" onchange="showValidateGif(<%=i%>)">&nbsp;<IMG src="../../eCommon/images/CommonCalendar.gif" id=Calendar <%=dateDisabled%>  onclick="showCalendar('StartDateTime<%=i%>',null,'hh:mm');this.focus();return false;" >&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img>
				</td>
				<td class='label' >
					<input type="text" name="EndDateTime<%=i%>" id="EndDateTime<%=i%>" value='<%=end_date%>' disabled size="14" maxlength="12"  >
				</td>
				<td class='label' >
					<input type="text" name="InfGapHr<%=i%>" id="InfGapHr<%=i%>"  width='3%' class="number" size='1' maxlength="2" value='<%=gap_hr%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkHrGap(<%=i%>)" onchange="showValidateGif(<%=i%>)">
					<b>:</b>
					<input type="text" name="InfGapMin<%=i%>" id="InfGapMin<%=i%>"  width='3%' class="number" size='1' maxlength="2" value='<%=gap_min%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkMinGap(<%=i%>)" onchange="showValidateGif(<%=i%>)"><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
					<input type='hidden' name='InfGapInHr<%=i%>' id='InfGapInHr<%=i%>' value='<%=gap%>'>
				</td>
				<td class='label' >
<%
				if(!adminRateHidden.equals("hidden")) {
%>
					<a href onClick="adminRate(<%=i%>)" onMouseOver="changeCursor(this);" id='adminrate<%=i%>'><fmt:message key="ePH.AdminRate.label" bundle="${ph_labels}"/></a>
<%
				}
%>
				<img src="../../eCommon/images/enabled.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'<%=i%>','validate')" id='validate<%=i%>' style="visibility:hidden">
<%			
				if(i==totRecs){
%>
					<img src="../../eCommon/images/nolines_plus.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'<%=i%>')" id='add<%=i%>'>
					<img src="../../eCommon/images/disabled.gif" onMouseOver="changeCursor(this)" onclick="deleteRow(this,'<%=i%>')" id='del<%=i%>'>
<%				
				}
				else{
%>
					<img src="../../eCommon/images/nolines_plus.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'<%=i%>')" id='add<%=i%>' style="visibility:hidden">
					<img src="../../eCommon/images/disabled.gif" onMouseOver="changeCursor(this)" onclick="deleteRow(this,'<%=i%>')" id='del<%=i%>' style="visibility:hidden">
<%		
				}
%>
				</td>
				
			</tr>
<%		}
	}
	else{
%>
			<tr>
				<td class='label' >&nbsp;1</td>
				<td class='label' >
					<input type="text" name="InfVolume1" id="InfVolume1" class="number" value="<%=volume%>"  maxlength='5' size='5' onKeyPress="return allowValidNumber(this,event,5,0);" onchange="showValidateGif(1)"><label id='InfVolUnit1'><%=stock_uom_desc%></label>
				</td>
				<td class='label' >
				
					<input type="text" name="InfRate1" id="InfRate1" class="number"  value="<%=inf_rate%>"  maxlength='7' size='7' onKeyPress="return allowValidNumber(this,event,6,2);" onblur='setInfuseOverValue(1);populateDate(1)' onchange="showValidateGif(1)"><label id='InfRateUnit1'><%=stock_uom_desc%>/</label>&nbsp;<select name='InfRateHrMin1' id='InfRateHrMin1' onChange='setInfuseOverValue(1);populateDate(1);showValidateGif(1)' >
<%	
					if (InfRateHrMin.equals("H")){
%>						<option value='H' selected><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
							
<%					
					}	
					else{ 
%>
							<option value='H' ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
							<option value='M' selected><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
<%						
					}
%>					
					</select>
				</td>
				<td class='label' >
<%				
					inf_over_hr = inf_over_hr.equals("")?"0":inf_over_hr;
					inf_over_min = inf_over_min.equals("")?"0":inf_over_min;
					if(inf_over_hr.substring(0,1).equals("0") && inf_over_hr.length()==2)
						inf_over_hr = inf_over_hr.substring(1,2);
					if(inf_over_min.substring(0,1).equals("0") && inf_over_min.length()==2)
						inf_over_min = inf_over_min.substring(1,2);
%>
					<input type="text"  width='3%' class="number" size='1' maxlength="2" name="InfOverHr1" id="InfOverHr1" value='<%=inf_over_hr%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkHr(1);setInfuseRateValue(1);populateDate(1)" onchange="showValidateGif(1)">
					<b>:</b>
					<input type="text"  width='3%' class="number" size='1' maxlength="2" name="InfOverMin1" id="InfOverMin1" value='<%=inf_over_min%>'  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkMin(1);setInfuseRateValue(1);populateDate(1)" onchange="showValidateGif(1)"><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
					<input type="hidden" name="infusion_over_insert_value1" id="infusion_over_insert_value1" value='<%=infusionOverInsertValue%>'>
				</td>
				<td class='label' >
					<input type="text" name="StartDateTime1" id="StartDateTime1" value='<%=start_date%>' size="14" maxlength="16" onblur="return validateDate(1)" onchange="showValidateGif(1)">&nbsp;<IMG src="../../eCommon/images/CommonCalendar.gif" id=Calendar  onclick="showCalendar('StartDateTime1',null,'hh:mm');document.formOngoIVPrescriptionMFR.StartDateTime1.focus();return false;" onchange="showValidateGif(1)">&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img>
				</td>
				<td class='label' >
					<input type="text" name="EndDateTime1" id="EndDateTime1" value='' disabled size="14" maxlength="12"  onchange="showValidateGif(1)">
				</td>
				<td class='label' >
					<input type="text" name="InfGapHr1" id="InfGapHr1"  width='3%' class="number" size='1' maxlength="2" value=''  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkHrGap(1)" onchange="showValidateGif(1)">
					<b>:</b>
					<input type="text" name="InfGapMin1" id="InfGapMin1"  width='3%' class="number" size='1' maxlength="2" value=''  onKeyPress="return allowValidNumber(this,event,3,0);"  onBlur="checkMinGap(1)"onchange="showValidateGif(1)" ><fmt:message key="ePH.hr(s).label" bundle="${ph_labels}"/>
					<input type='hidden' name='InfGapInHr1' id='InfGapInHr1' value=''>
				</td>
				<td class='label' >
<%	
				if(!adminRateHidden.equals("hidden")) {%>
					<a href onClick="adminRate(1)" onMouseOver="changeCursor(this);" id='adminrate1'><fmt:message key="ePH.AdminRate.label" bundle="${ph_labels}"/></a>
<%
				}
%>
					<img src="../../eCommon/images/enabled.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'1','validate')" id='validate1' style="visibility:hidden">
					<img src="../../eCommon/images/nolines_plus.gif"  onMouseOver="changeCursor(this)" onclick="addRow(this,'1')" id='add1'>
					<img src="../../eCommon/images/disabled.gif" style="visibility:hidden" onMouseOver="changeCursor(this)" onclick="deleteRow(this,'1')" id='del1'>
				</td>
				
			</tr>
<%	
		}
%>
		</table>
		<table align='right'>
			<tr><td colspan=2>&nbsp;</td></tr>
			<tr align='right'>
				<td  class="white" align='right'> 
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button" onClick="saveMFR('<%=drug_code%>');">
				</td>
				<td>
					<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="window.returnValue='';window.close();">
				</td>
			<tr>
		</table>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patientId%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterId%>">
		<input type="hidden" name="weight" id="weight" value="<%=weight%>">
		<input type="hidden" name="height" id="height" value="<%=height%>">
		<input type="hidden" name="ivType" id="ivType" value="<%=ivType%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="noOfRows" id="noOfRows" value="<%=totRecs%>">
		<input type="hidden" name="stockValue" id="stockValue" value="<%=volume%>">
		<input type="hidden" name="baseVolume" id="baseVolume" value="<%=base_volume%>">
		<input type="hidden" name="beanId" id="beanId" value="<%=bean_id%>">
		<input type="hidden" name="beanName" id="beanName" value="<%=bean_name%>">
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<input type="hidden" name="TotFlowDurnHrs" id="TotFlowDurnHrs" value="">
		<input type="hidden" name="TotDurnHrs" id="TotDurnHrs" value="">
		<input type="hidden" name="fluidCode" id="fluidCode" value='<%=fluid_code%>'>
		<input type="hidden" name="adminRateHidden" id="adminRateHidden" value='<%=adminRateHidden%>'>
		<input type="hidden" name="ocurrance_num" id="ocurrance_num" value='<%=ocurrance_num%>'>

		<script>
			populateDate('1');
			
		</script>
	</form>
</body>
</html>

