<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhLateAdminDetail.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String bean_id				= "PHRepMednAdmnListBean" ;
	String bean_name			= "ePH.PHRepMednAdmnListBean";
	PHRepMednAdmnListBean bean	= (PHRepMednAdmnListBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String  med_adm_yn			= bean.getMednAdmnList();
    ArrayList nursingList       = bean.getMednNursingList(locale);
	ArrayList dateList          = bean.getMednDateList();

	if(med_adm_yn.equals("N"))
		out.println("<script>GoBack()</script>");
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload=""> <!-- Removed onload focus event ML-BRU-SCF-0498 [IN035593] -->
		<form name="formPhLateAdminDtlCriteria" id="formPhLateAdminDtlCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="6" align="left" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<!--<td  class="label"width='18%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td   width='20%'>&nbsp;&nbsp;<SELECT name="p_nursing_unit" id="p_nursing_unit" >
						<OPTION VALUE=" "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </OPTION>
	<%
						for (int i=0; i<nursingList.size(); i+=2) { 
	%>
							<OPTION VALUE="<%= nursingList.get(i) %>"><%= nursingList.get(i+1) %></OPTION>
	<% 
						}
	%>  
						</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td> -->
			   
					   <td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td><!-- adding start for scf ML-BRU-SCF-0498 [IN:035593] -->
						<td>&nbsp;
						<select name="locn_type" id="locn_type" onChange="resetLocation()">		 <BR>
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
						</td>
					<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<!-- Changed for ML-BRU-SCF- 1536 -->
					<!-- <td>&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" maxlength="20" size="20"  disabled><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(locn_name)" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>-->
					<td>&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" STYLE='overflow:visible;' disabled><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onClick="locationLookupForChart(locn_name)"> <!-- onfocus="locationLookupForChart(locn_name)" --><input type="hidden" name="locn_code" id="locn_code">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td> <!-- Commenting onfocus for ML-BRU-SCF-2218 -->
					 <!-- adding end for scf ML-BRU-SCF-0498 [IN:035593] -->
					 <td   class="label" width='17%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td   > <input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20"  onKeyPress="changeToUpper()" onblur="Duplicatecheck();" > <!--  'chkPatientID()' is replaced by 'Duplicatecheck();' added for ML-BRU-SCF-0621[IN036565]--><input type="button" class="button" value="?" name="pat_search" id="pat_search"
					 onClick="callPatientSearch(document.formPhLateAdminDtlCriteria.p_patient_id)">&nbsp;</td>
					 <!-- onfocus="callPatientSearch(document.formPhLateAdminDtlCriteria.p_patient_id)"  --> <!-- Commenting onfocus for ML-BRU-SCF-2218 -->
					 
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
					<td  >&nbsp;&nbsp;<input type="text" size="13" name="dt_from_disp" id="dt_from_disp" value="<%=com.ehis.util.DateUtils.convertDate((String)dateList.get(0),"DMYHM","en",locale)%>" onBlur="CheckDateT(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from_disp',null,'hh:mm');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><input type="text" size="13" name="dt_to_disp" id="dt_to_disp" value="<%=com.ehis.util.DateUtils.convertDate((String)dateList.get(0),"DMYHM","en",locale)%>"  onBlur="CheckDateT(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to_disp',null,'hh:mm');" > &nbsp; <img src="../../eCommon/images/mandatory.gif"  align="center"> </td> 
				<tr>
					<td  class="label"><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
					<td  >&nbsp;&nbsp;<input type="text" name="p_admin_by_name" id="p_admin_by_name"  size="20"  onKeyPress="changeToUpper()" readonly ><input type="button" class="button" value="?" name="pat_search" id="pat_search"
					onClick="searchCode(document.formPhLateAdminDtlCriteria.p_admin_by_name)">&nbsp;
					<!-- onfocus="searchCode(document.formPhLateAdminDtlCriteria.p_admin_by_name)" --> <!-- Commenting onfocus for ML-BRU-SCF-2218 -->
					</td></td><td colspan='2'>&nbsp;</td>
				</tr> 
			</table>
			<INPUT TYPE="hidden" name="p_admin_by" id="p_admin_by" VALUE="">
			<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="<%=dateList.get(0) %>">
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="<%=dateList.get(0) %>">
			<INPUT TYPE="hidden" name="p_ad_date" id="p_ad_date" VALUE="<%=dateList.get(2) %>">
			<INPUT TYPE="hidden" name="p_in_date" id="p_in_date" VALUE="<%=dateList.get(0) %>">
			<INPUT TYPE="hidden" name="p_en_date" id="p_en_date" VALUE="<%=dateList.get(1) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRADMINSED">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
			<input type="hidden" name="SQL_PH_MED_ADMIN_APPL_USERS" id="SQL_PH_MED_ADMIN_APPL_USERS" value="<%=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_APPL_USERS")%>"> 
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>"> <!-- adding for scf ML-BRU-SCF-0498 [IN:035593] -->
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>"><!-- adding for scf ML-BRU-SCF-0498 [IN:035593] -->
		</form>
	</body>
	<%putObjectInBean(bean_id,bean,request);%>
</html>

