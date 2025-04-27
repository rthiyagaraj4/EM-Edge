<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/MedicationPlanReport.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="MedicationPlanReportResultForm" id="MedicationPlanReportResultForm" >
<%
	try{
		DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);
		DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
		String medplan_bean_id="MedicationPlannerBean";
		String medplan_bean_name="ePH.MedicationPlannerBean";
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request); 
		medplan_bean.setObject(dispBean);
		medplan_bean.setObject(all_bean);
		medplan_bean.setLanguageId(locale);

		String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
		String order_date_from = CommonBean.checkForNull(request.getParameter("order_date_from"));
		String order_date_to = CommonBean.checkForNull(request.getParameter("order_date_to"));
		String encounter_id  = CommonBean.checkForNull(request.getParameter("p_encounter"));
		String disp_locn_code  = CommonBean.checkForNull(request.getParameter("p_disp_locn_code"));
		String disp_locn_desc  = CommonBean.checkForNull(request.getParameter("p_disp_locn_desc"));
		ArrayList result =new ArrayList();
		result=medplan_bean.getMedPlanBasedOnQuery(patient_id,order_date_from,order_date_to,encounter_id,disp_locn_code,disp_locn_desc);
		if(result.size()>0){
		%>
		<table border="1" cellpadding="0" cellspacing="0" width="75%" align="center">
			<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
		<tr>
			<td class="label"><font class="hyperlink" style="cursor:pointer" onClick="callMediPlan('<%=(String)result.get(0)%>','<%=(String)result.get(3)%>','<%=order_date_from%>','<%=order_date_to%>','<%=(String)result.get(4)%>','<%=disp_locn_code%>','<%=(String)result.get(2)%>','<%=(String)result.get(5)%>')"><%=(String)result.get(0)%></font></td>
			<td class="label"><%=(String)result.get(1)%></td>
			<td class="label"><%=(String)result.get(4)%></td>
            <td class="label"><%=(String)result.get(2)%></td>
            <input type="hidden" name="med_plan_id" id="med_plan_id" value="<%=(String)result.get(3)%>">
		</tr>
		<%}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
		<%}%>
	<input type="hidden" name="bean_id" id="bean_id" value="">
	<input type="hidden" name="bean_name" id="bean_name" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="encounter_id" id="encounter_id" value="">
	<% putObjectInBean(medplan_bean_id,medplan_bean,request); 
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
</form>
</body>
</html>

