<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>                                
<head>                                
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
 -->	<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>     
<%
	String patient_id				= request.getParameter("patient_id");
	String disp_locn_code			= request.getParameter("disp_locn_code");
	String encounter_id             = request.getParameter("encounter_id");
	String bean_id					= "DirectDispensingBean" ;
	String bean_name				= "ePH.DirectDispensingBean";	
	String patient_class			= "";
    String practitioner_id			= "";
	String locn_code				= "";
	String patient_class_str        = "";
	String locn_name			    = "";
	String pract_name			    = "";
	String visit_date_time          = "";
	HashMap record					= null;
	
	DirectDispensingBean bean = (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
	//bean.setLanguageId(locale);
	ArrayList enc_details = (ArrayList)bean.getEncounterDetails(patient_id,encounter_id);
	bean.setPatientID(patient_id);
	bean.setDispLocnCode(disp_locn_code);
	
	
%>
<form name="encounterdetail" id="encounterdetail">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" >
<title> <fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></title>
<tr>
<th > <fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>  </th>
<th > <fmt:message key="ePH.PractionerID.label" bundle="${ph_labels}"/> </th>
<th > <fmt:message key="Common.Location.label" bundle="${common_labels}"/> </th>
<th > <fmt:message key="Common.patientclass.label" bundle="${common_labels}"/> </th>
<th > <fmt:message key="ePH.VisitDate/Time.label" bundle="${ph_labels}"/></th>
</tr>
<%
    for(int i=0;i<enc_details.size();i++){
		record=new HashMap();
		record=(HashMap)enc_details.get(i);
		practitioner_id			=	(String)record.get("PRACTITIONER_ID");
		locn_code				=	(String)record.get("LOCN_CODE");
		encounter_id			=	(String)record.get("ENCOUNTER_ID");
		patient_class			=	(String)record.get("PATIENT_CLASS");
		locn_name				=	(String)record.get("LOCN_NAME");
		pract_name				=	(String)record.get("PRACT_NAME");
		visit_date_time			=	(String)record.get("VISIT_DATE_TIME");
		
		 if(patient_class.equals("OP")){
			 patient_class_str="OutPatient";
		 }else if(patient_class.equals("EM")){
			 patient_class_str="Emergency";
		 }else if(patient_class.equals("XT")){
			 patient_class_str="External";
		 }
			

%>
	<tr nowrap ><td   class="label"id="encounter_id_<%=i%>" width='10%' style="cursor:pointer;color:blue;"onclick="saveEncounterIDDetails(document.encounterdetail,'<%=i%>');"	nowrap > <%=encounter_id%></td>
		<td    class="label" id="pract_name_<%=i%>"width='35%' nowrap><%=pract_name%></td>
		<td    class="label" id="ord_locn_name_<%=i%>" width='35%'nowrap><%=locn_name%></td>
		<td	   class="label" width='10%' nowrap><%=patient_class_str%></td>
		<td    class="label" width='10%' nowrap><%=com.ehis.util.DateUtils.convertDate(visit_date_time,"DMYHM","en",locale)%></td>		
	</tr>
	<input type="hidden" name="patient_class_<%=i%>" id="patient_class_<%=i%>"value="<%=patient_class%>">
	<input type="hidden" name="practioner_id_<%=i%>" id="practioner_id_<%=i%>"value="<%=practitioner_id%>">
	<input type="hidden" name="ord_locn_<%=i%>" id="ord_locn_<%=i%>"		value="<%=locn_code%>">

<% 
	
  }
%>
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">
	
<% putObjectInBean(bean_id,bean,request); %>
</table>
</form>
</html>

