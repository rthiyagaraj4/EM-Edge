<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<title>
		<fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/>
	</title>
	<%
 		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="Javascript" src="../../eCommon/js/common.js"></SCRIPT>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/dchk.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
	<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="MedicationAdministrationEntryForm" id="MedicationAdministrationEntryForm" >
<%
String mode			= request.getParameter("mode");

//String adminMode	= request.getParameter("adminMode");

String facility_id	= (String) session.getValue("facility_id");
String bean_id					= "MedicationAdministrationBean";
String bean_name				= "ePH.MedicationAdministrationBean";
MedicationAdministrationBean bean			= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name , request);
bean.setLanguageId(locale);

if(  (!mode.equals("entry")) && (!mode.equals("entryAmend")) ){

String drug_code	= request.getParameter("drug_code");
String srl_no		= request.getParameter("srl_no");
String time			= request.getParameter("time");
String qty			= request.getParameter("qty");
String uom			= request.getParameter("uom");
String order_id		= request.getParameter("order_id");
String drug_name	="";
String pract_name	="";
if(mode==null) mode="noniv";
if(mode!=null && mode.equals("noniv")){
ArrayList DrugDoseTimeDetails=bean.getDrugDoseTimeDetails();
if(DrugDoseTimeDetails.size()>0){
for(int i=0;i<DrugDoseTimeDetails.size();i++){
		HashMap DoseDetails=new HashMap();
		DoseDetails		= (HashMap) DrugDoseTimeDetails.get(i);
		String drugCode	= (String) DoseDetails.get("DRUG_CODE");
		String srlNo	= (String) DoseDetails.get("SRL_NO");
		String orderId	= (String) DoseDetails.get("ORDER_ID");

		if( (drugCode.equals(drug_code)) && (srl_no.equals(srlNo)) && (orderId.equals(order_id)) ){
			drug_name=(String) DoseDetails.get("DRUG_NAME");
			pract_name=(String) DoseDetails.get("PRACT_NAME");
		
		}

	}
}

%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<th ><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></th>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td  class="label" width="25%"><b><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/> :</b></td>
		<td  class="label" width="75%"><%=pract_name%></td>
	</tr>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="label" width="60%"><input type='radio' name ='admin' checked onclick='validateAdminDetail_1()'><fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/><input type='radio' name ='admin' onclick='validateAdminDetail_2()'><fmt:message key="Common.NotAdministered.label" bundle="${common_labels}"/></td>
		<td class="label" width="40%"><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></td>
</tr>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
	<th width="40%" class="HEADERTITLE1"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
	<th width="20%" class="HEADERTITLE1" colspan='2'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
	<th width="20%" class="HEADERTITLE1"><fmt:message key="ePH.AdminTime.label" bundle="${ph_labels}"/></th>
	<th width="20%" class="HEADERTITLE1"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
	<tr>
		<td  class="QRYEVEN" width="40%"><font size='1'><%=drug_name%></font></td>
		<td  class="QRYEVEN" width="15%"><input type='text' value='<%=qty%>' name='qty' size='9' class='number'></td><td align="left" class="QRYEVEN" width="5%"><label valign='center'><font size='1'><%=uom%></font></label></td>
		<td  class="QRYEVEN" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' value='<%=time%>' name='time' size='8' class='number'></td>
		<td class="QRYEVEN" width="20%"><a href=''><font size='1'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></a>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif" id='remarks_man' style='visibility:hidden'></img></td>	
	</tr>
</table>
<%
}else if(mode!=null && mode.equals("iv")){
%>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<th ><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></th>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="label" width="25%"><b><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/> :</b></td>
		<td class="label" width="75%"><%=pract_name%></td>
	</tr>
</table>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td  class="label" width="59%"><input type='radio' name ='admin'><fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/><input type='radio' name ='admin'><fmt:message key="Common.NotAdministered.label" bundle="${common_labels}"/></td><td class="label" width="41%">&nbsp;</td>
		</tr>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td  class="label" width="30%"><fmt:message key="Common.FluidName.label" bundle="${common_labels}"/></td>
		<td class="label" width="31%">&nbsp;&nbsp;<input type="text" class="label" name="infuse_start_time" id="infuse_start_time" size="48">&nbsp;<input type='button' class='button' value='?'></td>
		<td  class="label" width="18%"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class="label" width="8%">&nbsp;&nbsp;<input type="text" class="label" name="flow_rate" id="flow_rate" size="6"></td>
		<td class="label" width=""><fmt:message key="Common.ml.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td  class="label" width="29%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
		<td class="label" width="32%">&nbsp;&nbsp;<input type="text" class="label" name="infuse_start_time" id="infuse_start_time" size="48">&nbsp;<input type='button' class='button' value='?'></td>
		<td  class="label" width="18%"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class="label" width="8%">&nbsp;&nbsp;<input type="text" class="label" name="flow_rate" id="flow_rate" size="6"></td>
		<td class="label" width=""><fmt:message key="Common.ml.label" bundle="${common_labels}"/></td>
	</tr>
	
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="label" width="23%"><fmt:message key="ePH.InfusionStartTime.label" bundle="${ph_labels}"/></td>
		<td class="label" width="20%">&nbsp;&nbsp;<input type="text" class="label" name="infuse_start_time" id="infuse_start_time" size='6'></td>
		<td class="label" width="10%"><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/></td>
		<td class="label" width="12%">&nbsp;&nbsp;<input type="text" class="label" name="flow_rate" id="flow_rate" size='6'></td>
		<td class="label" width="" nowrap><fmt:message key="ePH.mlPerMinute.label" bundle="${ph_labels}"/>.</td>
		<td class="label" width="25%">&nbsp;</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="ePH.InfusionPeriod.label" bundle="${ph_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" class="label" name="infuse_start_time" id="infuse_start_time" size='6'></td>
		<td class="label" colspan='6'><a href=""><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
	</tr>
	
</table>

<%
}
%>
<input type="hidden" value="<%=qty%>" name="ori_qty">
<input type="hidden" value="<%=time%>" name="ori_time">
<input type="hidden" value="<%=drug_code%>" name="drug_code">
<input type="hidden" value="<%=order_id%>" name="order_id">
<input type="hidden" value="<%=srl_no%>" name="srl_no">
<input type="hidden" value="" name="remarks" id="remarks">
<%
}else if(mode!=null && mode.equals("entry")){
	String sql_ph_med_admin_select9=(String) PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT9");
	HashMap FrequencyValues=bean.populateFrequencyValues();
	//out.println(FrequencyValues);

	String sys_date=bean.getSysdate();
%>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<th colspan="4"  >
		<fmt:message key="ePH.Add/ModifyAdditionalDrugAdministrationDetails.label" bundle="${ph_labels}"/>
	</th>
	<tr>
		<td   class="label" ><fmt:message key="Common.OrderingPract.label" bundle="${common_labels}"/></td>
		<td  class="label" colspan="3">&nbsp;&nbsp;
			<input type="text"  name="pract_name" id="pract_name" size='45' disabled>
			<input type="hidden" name="pract_code" id="pract_code"><input type="button" class="button" name="" id="" value='?' onclick="searchPract();">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
	<tr>
		<td  class="label" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
		<td   class="label" colspan="3">&nbsp;&nbsp;
				<input type="text"  name="drug_name" id="drug_name" size='45'>
				<input type="button" class="button" name="" id="" value='?' onclick="drugSearch();">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
				<input type="hidden" name="drug_code" id="drug_code">
		</td>
	</tr>
	<tr>
		<td  class="label" ><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/> </td>
		<td  class="label" >&nbsp;&nbsp;
			<select name='route' id='route'>
				<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
		<td class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td  class="label" >&nbsp;&nbsp;
			<select name='freq' id='freq'>
				<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%
		if(FrequencyValues.size()>0){
			ArrayList freq_code=(ArrayList) FrequencyValues.get("FreqCode");
			ArrayList freq_desc=(ArrayList) FrequencyValues.get("FreqDesc");
			for(int i=0;i<freq_code.size();i++){
		%>
			<option value='<%=(String)freq_code.get(i)%>'><%=(String)freq_desc.get(i)%></option>
		<%
			}
		}
		%>
		</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr>
		<td  class="label"  nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DosageQuantity.label" bundle="${ph_labels}"/></td>
		<td  class="label" >&nbsp;&nbsp;
			<input type="text" class="number" name="dose_qty" id="dose_qty" size='5' maxlength='12' onblur="CheckPositiveNumber(this);"onKeyPress="return(ChkNumberInput(this,event,'6'));">
			<select name='qty_desc' id='qty_desc'>
				<option>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
		<td  class="label" >&nbsp;&nbsp;<fmt:message key="ePH.AdminDate/Time.label" bundle="${ph_labels}"/></td>
		<td  class="label" >&nbsp;&nbsp;
			<input type="text" name="admin_date_time" id="admin_date_time" size='15' onblur="chkAdminDate(this,'<%=locale%>');" value="<%=sys_date%>">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
	<tr>
		<td class="label"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>			
		<td >&nbsp;
			<input type="text" name="batch_id" id="batch_id" value="" size="9" maxlength="10" >				
				<!-- onBlur="validateNewEntryBatchID(drug_code,this,'MedicationAdministrationFTBean','ePH.MedicationAdministrationFTBean') -->
		</td>			
		<td class="label" ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>			
		<td >&nbsp;
			<input type="text" name="expiry_date" id="expiry_date" value="" size="7" maxlength="10" onBlur="validateForExpiry(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('expiry_date');" > &nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"> 				
		</td>			
	</tr>
	<tr>
		<td class="label"  ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
		<td colspan="3"  >&nbsp;
			<input type="text" name="trade_name" id="trade_name" value="" size="20" maxlength="20">
		</td>
	</tr>
	</table>
	<input type='hidden' value='<%=sql_ph_med_admin_select9%>' name='sql_ph_med_admin_select9'>
	<input type='hidden' value='<%=sys_date%>' name='sys_date'>
	<input type='hidden' value='<%=facility_id%>' name='facility_id'>
<br>
<%
}else if(mode!=null && mode.equals("entryAmend")){
	
	String sql_ph_med_admin_select9=(String) PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT9");
	HashMap FrequencyValues=bean.populateFrequencyValues();
	//out.println(FrequencyValues);

	String sys_date=bean.getSysdate();
	String sys_date_without_time = bean.getSysDateWithoutTime();
%>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<th colspan="4"  >
		<fmt:message key="ePH.Add/ModifyAdditionalDrugAdministrationDetails.label" bundle="${ph_labels}"/>
	</th>
	<tr>
		<td  class="label" ><fmt:message key="Common.OrderingPract.label" bundle="${common_labels}"/></td>
		<td  class="label" colspan="3">&nbsp;&nbsp;
			<input type="text"  name="pract_name" id="pract_name" size='45' disabled>
			<input type="button" class="button" name="" id="" value='?' onclick="searchPract();" disabled>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
			<input type="hidden" name="pract_code" id="pract_code">
		</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
		<td  class="label" colspan="3">&nbsp;&nbsp;
			<input type="text"  name="drug_name" id="drug_name" size='45' disabled>
			<input type="button" class="button" name="" id="" value='?' onclick="drugSearch();" disabled>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
			<input type="hidden" name="drug_code" id="drug_code">
		</td>
	</tr>
	<tr>
		<td  class="label" ><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></td>
		<td class="label" >&nbsp;&nbsp;
			<select name='route' id='route'>
				<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
		<td   class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td  class="label" >&nbsp;&nbsp;
			<select name='freq' id='freq'>
				<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%
		if(FrequencyValues.size()>0){
			ArrayList freq_code=(ArrayList) FrequencyValues.get("FreqCode");
			ArrayList freq_desc=(ArrayList) FrequencyValues.get("FreqDesc");
			for(int i=0;i<freq_code.size();i++){
		%>
			<option value='<%=(String)freq_code.get(i)%>'><%=(String)freq_desc.get(i)%></option>
		<%
			}
		}
		%>
			</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="ePH.DosageQuantity.label" bundle="${ph_labels}"/></td>
		<td   class="label" >&nbsp;&nbsp;
			<input type="text" class="number" name="dose_qty" id="dose_qty" size='5' maxlength='12' onblur="CheckPositiveNumber(this);"onKeyPress="return(ChkNumberInput(this,event,'6'));">
			<select name='qty_desc' id='qty_desc'>
				<option>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
		<td   class="label"><fmt:message key="ePH.AdminDate/Time.label" bundle="${ph_labels}"/></td>
		<td  class="label" >&nbsp;&nbsp;
			<input type="text" name="admin_date_time" id="admin_date_time" size='15' onblur="chkAdminDate(this,'<%=locale%>');" value="<%=sys_date%>">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>	
	
		<tr>
			<td class="label"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>			
			<td  width="32%">&nbsp;
				<input type="text" name="batch_id" id="batch_id" value="" size="9" maxlength="10" >
				<!-- onBlur="validateNewEntryBatchID(drug_code,this,'MedicationAdministrationFTBean','ePH.MedicationAdministrationFTBean')" -->
			</td>			
			<td class="label"  ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>			
			<td  >&nbsp;
				<input type="text" name="expiry_date" id="expiry_date" value="" size="7" maxlength="10" disabled> 
			</td>			
		</tr>
		<tr>
			<td class="label"  ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
			<td colspan="3"  >&nbsp;
				<input type="text" name="trade_name" id="trade_name" value="" size="38" maxlength="40" disabled>
			</td>
		</tr>
	</table>
<input type='hidden' value='<%=sql_ph_med_admin_select9%>' name='sql_ph_med_admin_select9'>
	<input type='hidden' value='<%=sys_date%>' name='sys_date'>
	<input type='hidden' value='<%=sys_date_without_time%>' name='sys_date_without_time'>
	<input type='hidden' value='<%=facility_id%>' name='facility_id'>
	<input type='hidden' value='' name='srl_no' id='srl_no'>
<br>
<%
String srlNo=request.getParameter("srl_no");
String drugCode=request.getParameter("drug_code");

	ArrayList newDrugDoseTimeDetails=new ArrayList();
	newDrugDoseTimeDetails=bean.getnewDrugDetails();
	if(newDrugDoseTimeDetails.size()>0){
		for(int i=0;i<newDrugDoseTimeDetails.size();i++){
			HashMap drugDetails=new HashMap();
			drugDetails=(HashMap) newDrugDoseTimeDetails.get(i);
			
			String drug_code=(String) drugDetails.get("DRUG_CODE");
			String srl_no=(String) drugDetails.get("SRL_NO");
			if( drug_code.trim().equals(drugCode.trim()) && srl_no.trim().equals(srlNo.trim())){
				String drug_name=(String) drugDetails.get("DRUG_NAME");
				String pract_id=(String) drugDetails.get("PRACT_ID");
				String pract_name=(String) drugDetails.get("PRACT_NAME");
				String route_code=(String) drugDetails.get("ROUTE_CODE");
				String dose_qty=(String) drugDetails.get("DOSE_QTY");
				String qty_uom=(String) drugDetails.get("QTY_UOM");
				String freq_code=(String) drugDetails.get("FREQ_CODE");
				String admin_date_time=(String) drugDetails.get("ADMIN_DATE_TIME");
				String batch_id	=(String)drugDetails.get("BATCH_ID");
				String expiry_date=(String)drugDetails.get("EXPIRY_DATE");
				String trade_name=(String)drugDetails.get("TRADE_NAME");
			%>
				<script>dfltEntryDetails("<%=srl_no.trim()%>","<%=drug_code%>","<%=drug_name%>","<%=pract_id%>","<%=pract_name%>","<%=route_code%>","<%=dose_qty%>","<%=qty_uom%>","<%=freq_code%>","<%=admin_date_time%>",'<%=batch_id%>','<%=expiry_date%>','<%=trade_name%>');</script>

			<%
				break;
			}			
		}
	}
}
%>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

