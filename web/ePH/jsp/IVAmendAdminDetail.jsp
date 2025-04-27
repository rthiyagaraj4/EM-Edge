<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>

<%
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
		String mode				= request.getParameter("mode");

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setOrderDate(start_date);
	bean.setPatientClass(patient_class);
	bean.setPatId(patient_id);
	bean.setEncId(encounter_id);

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId();
	String order_id		= (String)ORbean.getOrderId();
	
	String freq_code    = "";
	//String durn_value	= "";
	//String durn_type	= "";

	String end_date		= "";
	String infuse_over	= "";
	String infusion_rate= "";

	String tot_infuse_over	= "";
	//String tot_infuse_over_unit	= "";
	
	HashMap hm_fluid_details = null;
	if(bean.getAmendFluidDetails()==null){
		bean.loadAmendDetails(order_id, patient_id,patient_class);
	}else if(bean.getAmendFluidDetails() !=null && (bean.getAmendFluidDetails()).size()==0){
		bean.loadAmendDetails(order_id, patient_id,patient_class);	
	}

	hm_fluid_details = bean.getAmendFluidDetails();

	if(hm_fluid_details !=null){
		if(hm_fluid_details.size()>0){
			freq_code	=	(String)hm_fluid_details.get("FREQ_CODE");
			//durn_value  =   (String)hm_fluid_details.get("DURN_VALUE");
			//durn_type	=	(String)hm_fluid_details.get("DURN_TYPE");
			start_date	=	(String)hm_fluid_details.get("START_DATE_TIME");
			end_date	=	(String)hm_fluid_details.get("END_DATE_TIME");
			infuse_over	=	(String)hm_fluid_details.get("INFUSE_OVER");
			infusion_rate	=	(String)hm_fluid_details.get("INFUSION_RATE");

			tot_infuse_over = (String)hm_fluid_details.get("TOT_INFUSION_OVER");
			//tot_infuse_over_unit = (String)hm_fluid_details.get("TOT_INFUSION_OVER_UNIT");
	
		}else{
			start_date	=	bean.getOrderDate();
		}
	}


%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="formIVPrescriptionAdminDetail" id="formIVPrescriptionAdminDetail">

	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<th align="left" colspan="11"><font style="font-size:9"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></font></th>
		<tr>
		<td align='right' width='15%' class='label'><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td align="left" >
		<input type="text" width='3%' class="number" size="2" value="<%=infusion_rate%>" maxlength="3" name="INFUSION_VALUE" onBlur="CheckNum(this);setInfusion_uom();setInfuseOverValue()" onKeyPress="return allowValidNumber(this,event,3,0);" ><label align="left"  width='2%' class='label' id='infusion_uom_display'></label></td>
		<td align='right' width='15%' class='label'><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td align="left" >
		<input type="text"  width='3%' class="number" size='1' maxlength="2" name="INFUSION_PERIOD_VALUE" id="INFUSION_PERIOD_VALUE" value="<%=infuse_over%>" onKeyPress="return allowValidNumber(this,event,2,0);" tabindex='2' onBlur="CheckNum(this);checkHr(INFUSION_PERIOD_VALUE);setInfuseRateValue()" >
		
		<label align="left"  width='5%'class='label'><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b></label></td>		
		
		<td align='right' width='10%' class='label'><fmt:message key="Common.duration.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align="left" >
		<input type="text" width='10%' class="number" size="1" maxlength="2" value="<%=tot_infuse_over%>" name="DURN_VALUE" onBlur="CheckNum(this);chkDuration(this,'<%=mode%>')" onKeyPress="return allowValidNumber(this,event,3,0);" >
		</td>
		<td align="left"  width='5%'class='label'><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b></td>		
		</tr>
		<tr>
		<td align='right' class='label'><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align="left" >
		<input type="text" name="START_DATE" id="START_DATE" value="<%=start_date%>" size="12" maxlength="16" tabindex='4' onblur="resetInfuse()"><img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('START_DATE',null,'hh:mm');return false;" >&nbsp; <img src="../../eCommon/images/mandatory.gif" ></img>
		</td>
		
		<td align='right' class='label'><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td>
		<input type="text" name="END_DATE" id="END_DATE" value="<%=end_date%>" size="12" maxlength="12" tabindex='5' readonly>&nbsp; 
		</td>
		<td align="left"   class='label' ></td>
		<td align="left"   class='label' ></td>
		<td align="left"   class='label' ></td>
		
	
		</tr>
		</table>
	
		

<!--<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">-->

<input type="hidden" name="BEAN_ID" id="BEAN_ID" value="<%= bean_id %>">
<input type="hidden" name="BEAN_NAME" id="BEAN_NAME" value="<%= bean_name %>">
<!--<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">-->

<INPUT TYPE="hidden" name="LOCN_TYPE" id="LOCN_TYPE" VALUE="<%= locn_type %>">
<INPUT TYPE="hidden" name="LOCN_CODE" id="LOCN_CODE" VALUE="<%= locn_code %>">
<INPUT TYPE="hidden" name="INFUSION_PERIOD_UOM" id="INFUSION_PERIOD_UOM" VALUE="H" >
<INPUT TYPE="hidden" name="DURN_UNIT" id="DURN_UNIT" VALUE='H'>
<INPUT TYPE="hidden" name="DURN_VALUE" id="DURN_VALUE" VALUE=''>
<INPUT TYPE="hidden" name="INFUSION_UOM" id="INFUSION_UOM" VALUE='H'>
<INPUT TYPE="hidden" name="FREQUENCY" id="FREQUENCY" VALUE = '<%=freq_code%>'>
<input type="hidden" name="freq_desc" id="freq_desc" value='' >
<input type="hidden" name="sys_date" id="sys_date" value="<%=start_date%>">
<input type="hidden" name="drug_codes" id="drug_codes" value="">
<input type="hidden" name="INFUSION_UOM_DISPLAY" id="INFUSION_UOM_DISPLAY" value="">
<INPUT TYPE="hidden" name="PRACT_ID" id="PRACT_ID" VALUE="<%= pract_id %>">
<input type="hidden" name="EQVL_UOM_CODE" id="EQVL_UOM_CODE" value="">
<input type="hidden" name="INFUSION_PER_UNIT" id="INFUSION_PER_UNIT" value="H">



</FORM>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,ORbean,request);
%>

