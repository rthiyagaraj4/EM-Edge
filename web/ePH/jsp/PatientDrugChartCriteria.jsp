<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
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
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PatientDrugChart.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="PatientDrugChartQueryCriteria" id="PatientDrugChartQueryCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"> 
<%
			String bean_id		= "PrintPrescriptionReportBean" ;
			String bean_name	= "ePH.PrintPrescriptionReportBean";
			PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id, bean_name, request) ;
			bean.setLanguageId(locale);
			String patient_id	=	request.getParameter("patient_id");
			String status		= "";
			if(patient_id==null || patient_id.equals("null")) {
				patient_id	=	"";
			} 
			else {
				status		=	"disabled";
			}
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable">
				<tr>
					<td colspan="7">&nbsp;</td>
				</tr>
				<tr>
					<!--<td width="5%">&nbsp;</td>
					<td width="10%" align="right" class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;
						<select name="nurs_unit" id="nurs_unit" onChange="">
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
							<% ArrayList nursing_units=bean.getNursingUnit();
								  if(nursing_units != null && nursing_units.size() > 0){
										for(int i=0;i<nursing_units.size();i+=2){ %>
							<option value='<%=nursing_units.get(i)%>'><%=nursing_units.get(i+1)%></option>
							<%}}%>
						</select>&nbsp;<img id="mandatory"src="../../eCommon/images/mandatory.gif" ></img>
					</td>--> <!-- commented below code for scf ML-BRU-SCF-0498 [IN:035593] And adding start for scf ML-BRU-SCF-0498 [IN:035593] -->
					<td width="8%" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td>&nbsp;
						<select name="locn_type" id="locn_type" onChange="resetLocation()">
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
						</td>
						<td width="8%">&nbsp;</td>
					<td width="8%"  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><!-- chagned width for ML-MMOH-SCF-1171-->
					<td width="20%" nowrap>&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" STYLE='overflow:visible;' onchange="locationLookup(locn_name)"><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td> <!-- adding end for scf ML-BRU-SCF-0498 [IN:035593] --><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<td width="8%">&nbsp;</td>
					<td width="8%" align="right" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td align="left" nowrap>&nbsp;
						<input type="text" name="patient_id" id="patient_id" value="<%=patient_id%>" <%=status%>  maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" onblur="Duplicatecheck();"><input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"  <%=status%>>&nbsp;<img id="mandatory"src="../../eCommon/images/mandatory.gif" ></img> <!--  onfocus="callPatientSearch()" --><!-- Commenting onfocus for ML-BRU-SCF-2218 --><!-- code 'chkPatientID();'  is replaced by 'Duplicatecheck()'  for ML-BRU-SCF-0621[IN036565]-->
					</td>
					<td width="8%">&nbsp;</td><!-- chagned width for ML-MMOH-SCF-1171-->
				</tr>
				<tr>
					<td colspan="8" align="right"> 
						<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()">
					</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_patient_id" id="p_patient_id" value="">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPTDRCHART">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"><!-- adding for scf ML-BRU-SCF-0498 [IN:035593] Start-->
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>"><!-- addingfor scf ML-BRU-SCF-0498 [IN:035593] End-->
		</form>
	</body>
	<script>
 <%
		putObjectInBean(bean_id,bean,request );
		if(!patient_id.equals("")){ 
%>
			showResults()
 <%
		}
 %>
	</script>
</html>

