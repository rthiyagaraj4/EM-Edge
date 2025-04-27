<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
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
	 <script language="javascript" src="../../ePH/js/UnutilizedDrugs.js"></script>  
 	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function initialize()
{
	
		document.getElementById("dis_date_time").style.display='none';
		document.getElementById("dis_date_time1").style.display='none';
	    document.formUnutilizedDrugs.P_Discontinue_yn.checked=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn.disabled=false;
		document.formUnutilizedDrugs.P_Discontinue_yn.value='N';
		document.formUnutilizedDrugs.P_expiry_order_yn.checked=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn.disabled=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn.value='N';
		

}

function showDate(dis_status)
{
	
	var dis_status = document.formUnutilizedDrugs.p_order_status.value;

	if (dis_status=='DC')
	{
		
		document.getElementById("dis_date_time").style.display='inline';
		document.getElementById("dis_date_time1").style.display='inline';
	    document.formUnutilizedDrugs.P_Discontinue_yn.checked=true;
	    document.formUnutilizedDrugs.P_Discontinue_yn.disabled=true;
	    document.formUnutilizedDrugs.P_Discontinue_yn.value='Y';
		document.formUnutilizedDrugs.P_expiry_order_yn.checked=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn.disabled=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn.value='N';

	}else if (dis_status=='E')
	{

		document.getElementById("dis_date_time").style.display='none';
		document.getElementById("dis_date_time1").style.display='none';
		document.formUnutilizedDrugs.P_expiry_order_yn.checked=true;
	    document.formUnutilizedDrugs.P_expiry_order_yn.disabled=true;
	    document.formUnutilizedDrugs.P_expiry_order_yn.value='Y';
	    document.formUnutilizedDrugs.P_Discontinue_yn.checked=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn.disabled=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn.value='N';
	}
	else
	{
	
		document.getElementById("dis_date_time").style.display='none';
		document.getElementById("dis_date_time1").style.display='none';
	    document.formUnutilizedDrugs.P_Discontinue_yn.checked=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn.disabled=false;
	    document.formUnutilizedDrugs.P_Discontinue_yn.value='N';
		document.formUnutilizedDrugs.P_expiry_order_yn.checked=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn.disabled=false;
	    document.formUnutilizedDrugs.P_expiry_order_yn.value='N';
		
		
	}

	
}
</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = 'initialize()' topmargin="0">
<FORM name="formUnutilizedDrugs" id="formUnutilizedDrugs" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%

	String	bean_id			=	"PHRepDispStatisByDispBean" ;
	String	bean_name		=	"ePH.PHRepDispStatisByDispBean";
	String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
	HashMap p_nursing_unit=new HashMap();
	ArrayList nursingunit_code=new ArrayList();
	ArrayList nursingunit_desc=new ArrayList();

PHRepDispStatisByDispBean bean=(PHRepDispStatisByDispBean)getBeanObject(bean_id,bean_name ,request);
bean.setLanguageId(locale);


p_nursing_unit=bean.populateNursingUnit();
nursingunit_code=(ArrayList)p_nursing_unit.get("code");
nursingunit_desc=(ArrayList)p_nursing_unit.get("desc");
%>

<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" >
<TR><TD colspan="4">&nbsp;</TD>
<TR><TD colspan="4">&nbsp;</TD>
<tr>
					<td class="label"> <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_nursing_unit" id="p_nursing_unit">
						<option VALUE="A">&nbsp;&nbsp;&nbsp&nbsp; ---------<fmt:message key="Common.AllLocations.label" bundle="${common_labels}"/> ---------&nbsp;&nbsp;&nbsp&nbsp; </option>
						<%
							for(int i=0;i<nursingunit_code.size();i++){
							%>
							<option  VALUE="<%=nursingunit_code.get(i)%>"><%=nursingunit_desc.get(i)%>
							</option>
							<%
							} 

							
						%>
					</select>
					
					</td>
					<td class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_order_status" id="p_order_status"  maxlength="3" onChange="showDate(this)">
						<option> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
						<option  VALUE="C" ><fmt:message key="ePH.CurrentInpatient.label" bundle="${ph_labels}"/></option>
						<option  VALUE="D"><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></option>
						<option  VALUE="DC"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
						<option  VALUE="E"><fmt:message key="ePH.ExpiredOrder.label" bundle="${ph_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>&nbsp;&nbsp;
					</td>
			</tr>
			<tr>
			<td  class="label" width='10%'nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
			<td align="left" colspan="3">&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" size="20" 
			maxlength="<%=bean.getPatientIDLength()%>" value="" onKeyPress="changeToUpper()" onblur="Duplicatecheck();" > <!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]--><INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.formUnutilizedDrugs.p_patient_id)" >
			</td>
			</tr>
			<tr>
				<td class="label" ><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
				<td >&nbsp;&nbsp;<input type="text" name="or_date" id="or_date"  size="8"  value="" maxlength="10" OnBlur='CheckDateT(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('or_date');" ><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				<INPUT TYPE="hidden" name="p_date" id="p_date" VALUE="">
				</td>
				<td class="label" id="dis_date_time"><fmt:message key="ePH.DiscontinuedDateTimeFrom.label" bundle="${ph_labels}" /></td>
				<td  id="dis_date_time1">&nbsp;&nbsp;<input type="text" name="p_disc_date_time" id="p_disc_date_time"  size="8"  value="" maxlength="10" OnBlur='CheckDateT(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar  onclick="return showCalendar('p_disc_date_time');" ><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				<INPUT TYPE="hidden" name="d_date" id="d_date" VALUE="">
				</td>

			</tr>
			<tr >
				<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
				<td colspan="3">&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search"  onclick="searchDrugName();">
				<input type="hidden" name="drug_code" id="drug_code" value="">
			</td>	
</tr>
<tr>
	<td  class="label" nowrap ><fmt:message key="ePH.IncludeDiscontinuedOrder.label" bundle="${ph_labels}"/>	<input type="checkbox" name="P_Discontinue_yn" id="P_Discontinue_yn" value="N" onClick="assignValue()"></td>
	<td class="label" nowrap > <fmt:message key="ePH.IncludeExpiredOrder.label" bundle="${ph_labels}"/>
	<input type="checkbox" name="P_expiry_order_yn" id="P_expiry_order_yn" value="N"  onClick="assignValueForEx()"></td>	
	<td colspan="2">&nbsp;</td>
	</tr>

<TR>
<td colspan="4">&nbsp;</td>
</TR>

</table>
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUNUTLDRUG">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_discontinue_yn" id="p_discontinue_yn" value="N">
    <INPUT TYPE="hidden" name="p_expiry_order_yn" id="p_expiry_order_yn" value="N">
    
</FORM>

<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">

</html>


<% 
putObjectInBean(bean_id,bean,request);
%>

