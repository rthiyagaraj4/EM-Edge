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

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
	<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String bean_id	= "MedicationAdministrationFTBean";
	String bean_name= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean	= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	String direct_admin = bean.validateForDirectAdmin();
	String sel_schedule_time = request.getParameter("sel_schedule_time");
	if(sel_schedule_time==null){
		sel_schedule_time = "";
	}
	String bean_id_1	= "MedicationAdministrationBean";
	String bean_name_1  = "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean_1	= (MedicationAdministrationBean)getBeanObject( bean_id_1, bean_name_1 , request);
	bean_1.setLanguageId(locale);

%>
<form name="MedicationAdministrationButton" id="MedicationAdministrationButton" >
<table cellpadding="0" cellspacing="1" width="100%" align="center" border="1">
	<tr>			
		<td class="white" width="1%"  style='background-color:#CC99CC;' id="alt_color_id">&nbsp;&nbsp;</td>
		<td class="white" width="9%"   style="border:none;" id="alt_legend_id">
			<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></b></label>
		</td>
		<td class="white" width="1%"  style='background-color:red;' id="discontinued_color_id">&nbsp;&nbsp;</td>
		<td class="white"   id="discontinued_legend_id">
			<label class="label" style="font-size:9;" width="15%" nowrap><b>&nbsp;<fmt:message key="ePH.Discontinued.label" bundle="${ph_labels}"/></b>&nbsp;&nbsp;&nbsp;</label>
		</td>
		<td class="white" width="1%"  style='background-color:yellow;' id="hold_color_id">&nbsp;&nbsp;</td>
		<td class="white" width="7%"   id="hold_legend_id">
			<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.OnHold.label" bundle="${ph_labels}"/></b></label>
		</td>
		<td class="white" width="1%"  style='background-color:green;' id="hold_color_id">&nbsp;&nbsp;</td>
		<td class="white" width="12%"   id="hold_legend_id">
			<label class="label" style="font-size:9;" wrap><b>&nbsp;<fmt:message key="ePH.AdminRecorded.label" bundle="${ph_labels}"/></b></label>
		</td>
		<td class="white" width="1%"  style='background-color:#00FF00;' id="direct_admin_color_id">&nbsp;&nbsp;</td>
		<td class="white"    id="direct_admin_legend_id">
			<label class="label" style="font-size:9;" width="12%"><b>&nbsp;<fmt:message key="ePH.VerbalOrders.label" bundle="${ph_labels}"/></b></label>
		</td>
		<td class="white" width="1%"   style='background-color:#66FFFF' id="direct_admin_color_id">&nbsp;&nbsp;</td>
		<td class="white"   id="narcotic_legend_id">
			<label class="label" style="font-size:9;" width="6%"><b>&nbsp;<fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></b></label>&nbsp;
		</td>
		<td class="white" width="1%"   style='background-color:#CCFFCC' id="direct_admin_color_id">&nbsp;&nbsp;</td>
		<td class="white"   id="controlled_legend_id">
			<label class="label" style="font-size:9;" width="6%"><b>&nbsp;<fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></b></label>
		</td>
		<td class="white"   style="display:none"><input type='button' value='<fmt:message key="Common.PRN.label" bundle="${common_labels}"/>' name='btnPRN' onClick="recordPRN()" class="button" ></td>
		
<%
	String mode= request.getParameter("mode");
	if(mode==null)mode="";
	
	if(mode.equals("") && direct_admin.equals("Y")){
%>
	<td class="white"  >
			<input type="button" class="button" name="add_entry_button" id="add_button" value='<fmt:message key="ePH.NewRx.label" bundle="${ph_labels}"/>' onclick="callPrescription()" >
	</td>
<%
	}else{
%>
	<td class="white"  >
			<input type="button" class="button" name="add_entry_button" id="add_button" value='<fmt:message key="ePH.NewRx.label" bundle="${ph_labels}"/>' onclick="callPrescription()" style="display:none">
	</td>
<%
	}
	if(mode.equals("noniv")){
%>
		<td   class="white" ><input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="formValidation('<%=mode%>',parent.f_admin_detail.MedicationAdministrationFTDrugDetails);"><input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="cancelDetails('<%=mode%>','cancelSelScheduleDateTime');"></td>	
<%
	}else if(mode.equals("iv")){
%>	
		<td   class="white" ><input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="formValidation('<%=mode%>',parent.f_admin_detail.MedicationAdministrationFTDrugDetails);"><input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="cancelDetails('<%=mode%>','cancelSelScheduleDateTime');"></td>	
<%
	}
%>
</table>
	<input type="hidden" name="sel_schedule_time" id="sel_schedule_time" value="<%=sel_schedule_time%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id_1%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name_1%>">
	<input type="hidden" name="direct_admin" id="direct_admin" value="<%=direct_admin%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>

