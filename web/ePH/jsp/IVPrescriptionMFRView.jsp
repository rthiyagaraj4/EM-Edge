<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patientId	=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String volume		="";
	String inf_rate		="";
	String inf_over_hr	="";
	String inf_over_min	="";
	String start_date	="";
	String end_date		="";
	String stock_uom_code="";
	String InfRateHrMin	="";
	String gap_hr = "";
	String gap_min = "";
	String infusion_vol_str_unit_desc=""; //Declare infusion_vol_str_unit_desc for SKR-SCF-215.1

	String volumeUom		=""; 
	String adminRateDetail		="";
	String gapInHr		="";

	String ivType		=request.getParameter("ivType")==null?"":request.getParameter("ivType");
	String mode			=request.getParameter("mode")==null?"":request.getParameter("mode");

	String bean_id		=request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
	String bean_name	=request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
	String order_id		=request.getParameter("order_id")==null?"":request.getParameter("order_id");
	int totRecs = 1;
	String temp="";
	String infusionOverInsertValue	=request.getParameter("infusion_over_insert_value")==null?"":request.getParameter("infusion_over_insert_value");
	
	HashMap rec = new HashMap();

	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name,request) ;

	ArrayList MultiFlowRecs = bean.getMFRRecsView(order_id,locale);	//Add locale for SKR-SCF-215.1

	

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionMFR.js"></SCRIPT>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<title><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></title>
</head>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
	<form name="formIVPrescriptionMFR" id="formIVPrescriptionMFR">
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<tr >
				<td class='label' ><B>
					<fmt:message key="ePH.TotalInfusionVolume.label" bundle="${ph_labels}"/>
					&nbsp;<label id='TotInfVolUnit' maxlength='10'></label> </B>
				</td>
				<td class='label' ><B>
					<fmt:message key="ePH.TotalInfuseDuration.label" bundle="${ph_labels}"/>
					<label id='TotFlowDurn' maxlength='10'></label>
					&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></B>
				</td>
				<td class='label'><B>
					<fmt:message key="ePH.TotalDuration.label" bundle="${ph_labels}"/>
					<label id='TotDuration' maxlength='10'></label>
					&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></B>
				</td>
			</tr>
		</table>
		<table id='mfrTable' >
			<tr>
				<td class="COLUMNHEADER" width='12%'>
					<fmt:message key="ePH.FlowRateNo.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='8%' >
					<fmt:message key="ePH.InfuseVol.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='13%'>
					<fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='9%'>
					<fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='16%'>
					<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='16%'>
					<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" width='9%'>
					<fmt:message key="ePH.InfusionGapTime.label" bundle="${ph_labels}"/>
				</td>
<!--				<td class="COLUMNHEADER" width='14%'>
					&nbsp;&nbsp;
-->				</td>
			</tr>

<%		
	int tot_volume = 0;
	float tot_flow_durn = 0.0f;
	float tot_gap = 0.0f;
	float tot_durn = 0.0f;

	if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){

		for(int i=0; i<MultiFlowRecs.size(); i++){
			rec			= (HashMap)MultiFlowRecs.get(i);
			volume		= (String)rec.get("TOT_STRENGTH");
			volumeUom	= (String)rec.get("TOT_STRENGTH_UOM");
			
			inf_rate		= (String)rec.get("INFUSION_RATE")==null?"0":(String)rec.get("INFUSION_RATE");
			InfRateHrMin	= (String)rec.get("INFUSION_PER_UNIT");
			infusion_vol_str_unit_desc = (String)rec.get("INFUSION_VOL_STR_UNIT_DESC");// Add for SKR-SCF-215.1
			
			inf_over_hr	= "";
			inf_over_min= "";
			infusionOverInsertValue	= (String)rec.get("INFUSE_OVER")==null?"0":(String)rec.get("INFUSE_OVER");
			
			adminRateDetail = (String)rec.get("ADMIN_RATE_DETAIL");
			start_date	= (String)rec.get("START_DATE_TIME");
			end_date	= (String)rec.get("END_DATE_TIME");
			start_date =DateUtils.convertDate(start_date,"DMYHM","en",locale);
			end_date = DateUtils.convertDate(end_date,"DMYHM","en",locale);
			gapInHr = (String)rec.get("GAP_DURATION_IN_HRS")==null?"0":(String)rec.get("GAP_DURATION_IN_HRS");

			tot_volume = tot_volume + Integer.parseInt(volume);
			tot_flow_durn = tot_flow_durn + Float.parseFloat(infusionOverInsertValue);
			tot_gap = tot_gap + Float.parseFloat(gapInHr);
			tot_durn = tot_durn+Float.parseFloat(infusionOverInsertValue) + Float.parseFloat(gapInHr);

			String volumeUomDesc = bean.getUomDisplay((String)session.getValue("facility_id"),volumeUom);  //added for SKR-SCF-215.1					

%>
			<tr>
				<td class='label' ><fmt:message key="ePH.FlowRate.label" bundle="${common_labels}"/>&nbsp;<%=i+1%></td>
				<td class='label' >
					<label id='InfVolUnit<%=i%>'><%=volume%> &nbsp;<%=infusion_vol_str_unit_desc%></label> <!--volumeUom is replaced by infusion_vol_str_unit_desc  for SKR-SCF-215.1-->
				</td>
				<td class='label' >
<%				if(InfRateHrMin.equals("H")){
%>
					<label id='InfRateUnit<%=i%>'><%=inf_rate%>&nbsp;<%=infusion_vol_str_unit_desc%>/<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></label>		<!--volumeUom is replaced by infusion_vol_str_unit_desc  for SKR-SCF-215.1-->
<%}else{%>
					<label id='InfRateUnit<%=i%>'><%=inf_rate%>&nbsp;<%=infusion_vol_str_unit_desc%>/<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></label>	  <!--volumeUom is replaced by infusion_vol_str_unit_desc  for SKR-SCF-215.1-->
<%}%>			
				</td>
				<td class='label' >
					<label id='InfOver<%=i%>'></label>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/>
					<input type=hidden name='InfOverInHrs<%=i%>' id='InfOverInHrs<%=i%>' value='<%=infusionOverInsertValue%>'>
				</td>
				<td class='label' >
					<label id='start_date<%=i%>'><%=start_date%></label>
				</td>
				<td class='label' >
					<label id='end_date<%=i%>'><%=end_date%></label>
				</td>
				<td class='label' >
					<label id='InfGap<%=i%>'></label>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/>
					<input type=hidden name='InfGapInHrs<%=i%>' id='InfGapInHrs<%=i%>' value='<%=gapInHr%>'>
				</td>
<!--				<td class='label' >
					<a href onClick="adminRate(<%=i%>)" onMouseOver="changeCursor(this);" id='adminrate<%=i%>'><fmt:message key="ePH.AdminRate.label" bundle="${ph_labels}"/></a>
				</td>
-->				
			</tr>
<%		}
	}
%>
		</table>
		<input type=hidden name='noOfRows' id='noOfRows' value='<%=MultiFlowRecs.size()%>'>	
		<script>
			calculateViewValues(document.formIVPrescriptionMFR,'<%=tot_volume%>','<%=tot_flow_durn%>','<%=tot_gap%>','<%=tot_durn%>','<%=MultiFlowRecs.size()%>','<%=tot_flow_durn%>','<%=infusion_vol_str_unit_desc%>');  <!--volumeUom is replaced by infusion_vol_str_unit_desc  for SKR-SCF-215.1-->
		</script>
	</form>
</body>
</html>

