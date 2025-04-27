<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
 
<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>




	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	 <script language="javascript" src="../js/SRRUnutilizedDrugs.js"></script>  
 	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function initialize()
{
	
		document.getElementById("dis_date_time").style.display='none';
		document.getElementById("dis_date_time1").style.display='none';
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.checked=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.disabled=false;
		document.formUnutilizedDrugs.P_Discontinue_yn_cb.value='N';
		document.formUnutilizedDrugs.P_expiry_order_yn_cb.checked=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.disabled=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.value='N';
		

}

function showDate(dis_status)
{
	
	var dis_status = document.formUnutilizedDrugs.p_order_status.value;

	if (dis_status=='DC')
	{
		
		document.getElementById("dis_date_time").style.display='inline';
		document.getElementById("dis_date_time1").style.display='inline';
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.checked=true;
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.disabled=true;
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.value='Y';
	    document.formUnutilizedDrugs.p_discontinue_yn.value='Y';	//hidden text varaible 	
		document.formUnutilizedDrugs.P_expiry_order_yn_cb.checked=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.disabled=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.value='N';
	    document.formUnutilizedDrugs.p_expiry_order_yn.value='N';//hidden text varaible 

	}else if (dis_status=='E')
	{

		document.getElementById("dis_date_time").style.display='none';
		document.getElementById("dis_date_time1").style.display='none';
		document.formUnutilizedDrugs.P_expiry_order_yn_cb.checked=true;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.disabled=true;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.value='Y';
	    document.formUnutilizedDrugs.p_expiry_order_yn.value='Y';//hidden text varaible 
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.checked=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.disabled=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.value='N';
	    document.formUnutilizedDrugs.p_discontinue_yn.value='N';//hidden text varaible 
	}
	else
	{
	
		
		document.getElementById("dis_date_time").style.display='none';
		document.getElementById("dis_date_time1").style.display='none';
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.checked=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.disabled=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn_cb.value='N';
	    document.formUnutilizedDrugs.p_discontinue_yn.value='N';//hidden text varaible 
		document.formUnutilizedDrugs.P_expiry_order_yn_cb.checked=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.disabled=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn_cb.value='N';
	    document.formUnutilizedDrugs.p_expiry_order_yn.value='N';//hidden text varaible 
		
		
	}

	
}
</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = 'initialize()' topmargin="0">
<FORM name="formUnutilizedDrugs" id="formUnutilizedDrugs" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%

	String	bean_id						=	"PHRepDispStatisByDispBean" ;
	String	bean_name					=	"ePH.PHRepDispStatisByDispBean";
	//String sql_ph_nursing_unit_select	=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1");
	//String sql_ph_clinic_select			=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
//	String sql_ph_clinic_select			=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
	String sql_ph_drug_search_select2	=	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
	PHRepDispStatisByDispBean bean=(PHRepDispStatisByDispBean)getBeanObject(bean_id,bean_name ,request);
	bean.setLanguageId(locale);
	
	

	
%>

<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" >
			
			<tr>
					<td class="label">
						<fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>
					</td>
					<td>
						<select name ="locn_type">
						  <option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
						  <option VALUE="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						   <option VALUE="N" selected ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>
                    </td>					
					<td class="label">
						 <fmt:message key="ePH.Location.label" bundle="${ph_labels}"/> 
					</td>
					<td>
						<input type="text" name="locn_text" id="locn_text" size="20" value="" > 
						<INPUT TYPE="button" name="locn_lookup_btn" id="locn_lookup_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(formUnutilizedDrugs.locn_text);" >
						<input type="hidden" name="locn_id" id="locn_id" value ="" /> 
                    </td> 
					
					
			</tr>
			<tr>
					<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
					<td align="left"><input type="text" name="p_patient_id" id="p_patient_id" size="20" 
					maxlength="<%=bean.getPatientIDLength()%>" value="" onKeyPress="changeToUpper()"> 
					<INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.formUnutilizedDrugs.p_patient_id)" >
					</td>					
					<td class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td><select name="p_order_status" id="p_order_status"  maxlength="3" onChange="showDate(this)">
						<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
						<option  VALUE="C" ><fmt:message key="ePH.CurrentInpatient.label" bundle="${ph_labels}"/></option>
						<option  VALUE="D"><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></option>
						<option  VALUE="DC"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
						<option  VALUE="E"><fmt:message key="ePH.ExpiredOrder.label" bundle="${ph_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>&nbsp;&nbsp;
					</td>

			</tr>
			<tr>
				<td class="label" ><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
				<td ><input type="text" name="or_date" id="or_date"  size="8"  value="" maxlength="10" OnBlur='ChkDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('or_date');" > <!--ChcekDate changed to ChkDate for ICN 31194-->
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				<INPUT TYPE="hidden" name="p_date" id="p_date" VALUE="">
				</td>
				<td class="label" id="dis_date_time"><fmt:message key="ePH.DiscontinuedDateTimeFrom.label" bundle="${ph_labels}" /></td>
				<td  id="dis_date_time1"><input type="text" name="p_disc_date_time" id="p_disc_date_time"  size="8"  value="" maxlength="10" OnBlur='ChkDate(this)'><!--CheckDate changed to ChkDate for ICN 31194-->
				<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar  onclick="return showCalendar('p_disc_date_time');" > 
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				<INPUT TYPE="hidden" name="d_date" id="d_date" VALUE="">
				</td>

			</tr>
			<tr >
				<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
				<td colspan="3"><input type="text" name="drug_name" id="drug_name" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onfocus="searchDrugName();" onclick="searchDrugName();">
				<input type="hidden" name="drug_code" id="drug_code" value="">
				</td>	
			</tr>
			<tr>
				<td  class="label"  nowrap><fmt:message key="ePH.OnlyDiscontinuedOrder.label" bundle="${ph_labels}"/></td>
				<td><input type="checkbox" name="P_Discontinue_yn_cb" id="P_Discontinue_yn_cb" value="N" onClick="assignValue()"></td>
				<td class="label" nowrap ><fmt:message key="ePH.IncludeExpiredOrder.label" bundle="${ph_labels}"/></td>			
				<td><input type="checkbox" name="P_expiry_order_yn_cb" id="P_expiry_order_yn_cb" value="N"  onClick="assignValueForEx()"> </td>
			</tr>

</table>
    <INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUNUTLDRUG">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_discontinue_yn" id="p_discontinue_yn" value="N">
    <INPUT TYPE="hidden" name="p_expiry_order_yn" id="p_expiry_order_yn" value="N">
    <INPUT TYPE="hidden" name="p_order_locn_type" id="p_order_locn_type" value="">
    <INPUT TYPE="hidden" name="p_locn_code" id="p_locn_code" value="">
    <INPUT TYPE="hidden" name="p_reprint" id="p_reprint" value="Y">
	
    
</FORM>
<input type="hidden" name="sql_ph_nursing_unit_select" id="sql_ph_nursing_unit_select" value="<%=sql_ph_nursing_unit_select%>">
<input type="hidden" name="sql_ph_clinic_select" id="sql_ph_clinic_select" value="<%=sql_ph_clinic_select%>">
<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">


</html>


<% 
putObjectInBean(bean_id,bean,request);
%>

