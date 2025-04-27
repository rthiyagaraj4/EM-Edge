<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.text.*, ePH.*, ePH.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
        request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" SRC="../js/CancelDiscOrdersReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</HEAD>
<%
	String locale			= (String)session.getAttribute("LOCALE");
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	String sys_date      = bean.getSysDate();
	String from_date     = bean.getMonthRangeOfSysdate();
	String p_user_name      = (String) session.getValue( "login_user" ) ;
%>
	<body onMouseDown="" onKeyDown="lockKey()">

		<form name="formDiscontinueOrdersReportCriteria" id="formDiscontinueOrdersReportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
			<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
				<th COLSPAN="8"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td colspan='3'>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>	
					<td class="label" width='15%'nowrap><fmt:message key="ePH.OrderFromDate.label" bundle="${ph_labels}"/></td>
					<td class="label" width='15%'><input type="text" size="11" maxlength=10 name="p_period_fm" id="p_period_fm" value="<%=com.ehis.util.DateUtils.convertDate(from_date,"DMY","en",locale)%>" Onblur="CheckDateT(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_period_fm');" ><img src="../../eCommon/images/mandatory.gif"  align="center"></td>
					<td class="label" width='15%'nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class="label" width='15%'nowrap>
						<input type="text" size="11" name="p_period_t" id="p_period_t" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" Onblur="CheckDateT(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_period_t');" ><img src="../../eCommon/images/mandatory.gif" align="center">
				    </td>
					<td class='label' colspan='2' width='*'></td>
				</tr>
				<tr>
					<td colspan='3'>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>					
					<td class="label" width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/> </td>
					<td class="label" width='15%' >
						<select name="p_patient_class" id="p_patient_class" onChange=" ">
							<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
							<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td colspan="3" class="label">
						<input type="text" name="p_patient_id" id="p_patient_id" value="" maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" onchange="Duplicatecheck();" >
						<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
						<img src="../../eCommon/images/mandatory.gif" align="center" id='img_mand_pat_id' style='display:none;'></img> 
					</td>
				</tr>
				<tr>
					<td colspan='3'>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>
					<td class="label" width='15%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td class="label">
					<select name="p_locn_type" id="p_locn_type" onchange="clearLocation(this)">
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>
					</td>		            
				    <td class="label"><label id='lbl_locn_from'><fmt:message key="ePH.Location.label" bundle="${ph_labels}"/></label></td>
					<td colspan="3" class="label">
					    <input type="text" STYLE='overflow:visible;' id="locationSearch" name="p_locn_name" id="p_locn_name" value=""><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					    <input type="button" class="button" id="search" value="?"onfocus="locationLookup(formDiscontinueOrdersReportCriteria.p_locn_name)" onClick="locationLookup(p_locn_code)">
					    <input type="hidden" name="p_locn_code" id="p_locn_code" value="">
					</td>
					<td class="label" width='15%'><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
					<td class="label">
					<select name="p_order_status" id="p_order_status">
					    <option value="ALL"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value="CN"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
						<option value="DC"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
					</select>
					</td>				
			   </tr>
			   		
			</table>
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
			<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
			<input type="hidden" name="p_period_from" id="p_period_from" value="">
			<input type="hidden" name="p_period_to" id="p_period_to" value="">
			<input type="hidden" name="p_report_id" id="p_report_id" value="PHDISORD">
			<input type="hidden" name="p_user_name" id="p_user_name" value="<%= p_user_name %>">
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">   <!-- Added for ML-BRU-SCF-0498 [IN035593] -->
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
		</form>
	</body>
</html>

