<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhRepPrescription.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="PhRepPrescriptionCriteriaForm" id="PhRepPrescriptionCriteriaForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onload ="parent.frames[0].document.forms[0].run.disabled = true">
<%
		String bean_id		= "PrintPrescriptionReportBean" ; 
		String bean_name	= "ePH.PrintPrescriptionReportBean";
		PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);

		String patient_id	=	request.getParameter("patient_id");
		String sOrderType	=	request.getParameter("order_type");

		//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
		//java.util.Date date_time	 	= new java.util.Date();
		String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
		bean.getDefltValues();
		String CDROrdersYN=bean.getCDROrdersYN();
		String status		= "";
		if(patient_id==null || patient_id.equals("null")) {
			patient_id	=	"";
		} else {
			status		=	"";
		}
		ArrayList iv_legend=new ArrayList();
		iv_legend=bean.getIVLegends();
%>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable" >
			<tr>
				<td class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<select name="order_type" id="order_type">
					<option value="All"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="" selected><fmt:message key="ePH.NormalRx.label" bundle="${ph_labels}"/></option>
<%
					for(int i=0;i<=9;i=i+2){
%>
						<option value="<%=(String)iv_legend.get(i)%>"><%=(String)iv_legend.get(i+1)%></option>
<%
					}
%>
					<option value="6"><fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></option>
					<option value="7"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
					<option value="8"><fmt:message key="ePH.TPNNonStandard.label" bundle="${ph_labels}"/></option>
<%
					if("Y".equals(CDROrdersYN)){
%>
						<option value="C"><fmt:message key="ePH.CDROrders.label" bundle="${ph_labels}"/></option>
<%
					}
					else{
%>
						<option value="9"><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/></option>
						<option value="0"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
<%
					}
%>
					</select>
				</td>	
				<td class="label"><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="order_date_from" id="order_date_from"  size="10" Onblur="if(CheckDateT(this))if(DateCheck(sysdate,order_date_from))validate_date(this,'TO_DATE_LESS_FROM')"><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_from');" >
				</td>
				<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="order_date_to" id="order_date_to" size="10" Onblur="if(CheckDateT(this)) if(DateCheck(sysdate,order_date_to)) validate_date(this,'TO_DATE_LESS_FROM');"><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_to');"
					>
				</td>		
			</tr>
			<tr>
			<td class="label"><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="order_id" id="order_id" maxlength="15" size="20" onKeyPress="changeToUpper()">

				</td>	
				<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="patient_id" id="patient_id" size="20" value="<%=patient_id%>" <%=status%> maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" onblur="Duplicatecheck();" ><!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->
					<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"  <%=status%> >
					&nbsp;<img   src="../../eCommon/images/mandatory.gif"></img>
				</td>
				<td class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="nationality" id="nationality" maxlength="20" size="20"  disabled>
				</td>
				</tr>
				<tr>
				<td class="label"><%=bean.getNationID()%></td>
				<td>&nbsp;
					<input type="text" name="healthCardNo" id="healthCardNo" maxlength="20" size="20" disabled>
				</td>

				<td class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="encounter_id" id="encounter_id" maxlength="20" size="20"  >
				</td>
				<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
				<td colspan="3">&nbsp;
					<input type="text" name="practitioner_id" id="practitioner_id" maxlength="20" size="20"  >
				</td>		
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<select name="locn_type" id="locn_type" onChange="resetLocation()">		 <BR>
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" STYLE='overflow:visible;' disabled><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
				<!--<input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(locn_name)" onClick="locationLookup(locn_name)">  -->
				<input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onClick="locationLookup(locn_name)"><!-- removed onfocus for NMC-JD-SCF-0160 --> 
				<input type="hidden" name="locn_code" id="locn_code">
				</td>	
				<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="lstOrderBy" id="lstOrderBy"><option value="ASCEND"><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
											  <option value="DESCEND" selected><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option></select>
				</td>
			</tr>
		
			<td class="label" colspan=4></td>
			<td colspan="2"> 
				<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults('<%=patient_id%>')" >
			</td>
		<tr>
		</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_order_id" id="p_order_id" value="">
			<input type="hidden" name="p_order_id1" id="p_order_id1" value="">
			<input type="hidden" name="p_fm_order_id" id="p_fm_order_id" value="">
			<input type="hidden" name="p_to_order_id" id="p_to_order_id" value="">
			<input type="hidden" name="p_patclass" id="p_patclass" value="">
			<input type="hidden" name="p_locncode" id="p_locncode" value="">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
			<input type="hidden" name="p_iv_prep_yn" id="p_iv_prep_yn" value="">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
		</form>
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
<%
	if(sOrderType != null && !sOrderType.equals("")){
		if(sOrderType.equals("ALL"))
			sOrderType = "All";
%>
		<script>
			document.PhRepPrescriptionCriteriaForm.order_type.value = '<%=sOrderType%>';
		</script>
<%
	}
%>
	<script>
 <% 
		if(!patient_id.equals("")){ 
%>
			showResults()
 <%
		}
 %>
	</script>
</html>

