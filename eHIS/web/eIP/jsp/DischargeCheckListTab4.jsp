<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
String call_function= request.getParameter("call_function")==null?"":request.getParameter("call_function");
String disable_fld = "";
if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
	disable_fld = "disabled";
}
%>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eIP/js/DischargeCheckList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DischargeCheckListTab3' id='DischargeCheckListTab3'>
	<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
	<tr><td class='columnheader' colspan=4><fmt:message key="eIP.PersonalHygiene.label" bundle="${ip_labels}"/></td></tr>
	<tr>
		<td class='label' width='25%'><fmt:message key="eIP.ToptoToe.label" bundle="${ip_labels}"/></td>
		<td class='fields' width='25%'><input type='checkbox' name='top_to_toe_chk' id='top_to_toe_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
		<td class='label' width='25%'><fmt:message key="eIP.CareofumbilicusStump.label" bundle="${ip_labels}"/></td>
		<td class='fields' width='25%'><input type='checkbox' name='co_umb_stmp_chk' id='co_umb_stmp_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.CareofSkin.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='care_of_skin_chk' id='care_of_skin_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
		<td class='label' ><fmt:message key="eIP.CareofEye.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='care_of_eye_chk' id='care_of_eye_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr><td class='columnheader' colspan=4><fmt:message key="eIP.Nutrition.label" bundle="${ip_labels}"/></td></tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.BreastFeedingExpressedbreastmilk.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='expr_br_mlk_chk' id='expr_br_mlk_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
		<td class='label' ><fmt:message key="eIP.Tubefeeding.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='tube_feed_chk' id='tube_feed_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.Gastrotomyfeeding.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='gst_feed_chk' id='gst_feed_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
		<td class='label' ><fmt:message key="eIP.Formulamilk.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='frm_milk_chk' id='frm_milk_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.ImmunizationSchedule.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='imn_sch_chk' id='imn_sch_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
		<td class='label' ><fmt:message key="eIP.CareOfStoma.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='care_of_stoma_chk' id='care_of_stoma_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.AnalDilatation.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='anl_dil_chk' id='anl_dil_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
		<td class='label' ><fmt:message key="eIP.POP.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='pop_chk' id='pop_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.Fever.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='fever_chk' id='fever_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
		<td class='label' ><fmt:message key="eIP.Seizure.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='sz_chk' id='sz_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.Jaundice.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='jnd_chk' id='jnd_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
		<td class='label' ><fmt:message key="Common.g6pd.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='gpd_chk' id='gpd_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.StoolColour.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='stlc_chk' id='stlc_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
		<td class='label' ><fmt:message key="eIP.StoolFrequency.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='stlf_chk' id='stlf_chk' onclick="setValue_tab4(this);" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.CareOfPretermbaby.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='coptb_chk' id='coptb_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
		<td class='label' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='oth_ph_chk' id='oth_ph_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr><td class='columnheader' colspan=4><fmt:message key="eIP.Pamphlets.label" bundle="${ip_labels}"/></td></tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.BreastFeeding.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='bfd_chk' id='bfd_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
		<td class='label' ><fmt:message key="eIP.StomaCare.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='stm_cr_chk' id='stm_cr_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='oper_chk' id='oper_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
		<td class='label' ><fmt:message key="eIP.PopCare.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='pop_care_chk' id='pop_care_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
		<td class='fields'  colspan=3><input type='text' name='oth_pamphlets' id='oth_pamphlets' size='30' maxlength='80' <%=disable_fld%> ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.DischargeBookGiven.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='db_given_chk' id='db_given_chk' onclick="setValue_tab4(this);" <%=disable_fld%> ></td>
		<td colspan=2></td>
	</tr>
</table>
</form>
<script>

document.forms[0].top_to_toe_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_top_to_toe_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_top_to_toe_chk.value == 'Y')
document.forms[0].top_to_toe_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_top_to_toe_chk.value != '')
document.forms[0].top_to_toe_chk.disabled = true;

document.forms[0].co_umb_stmp_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_co_umb_stmp_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_co_umb_stmp_chk.value == 'Y')
document.forms[0].co_umb_stmp_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_co_umb_stmp_chk.value != '')
document.forms[0].co_umb_stmp_chk.disabled = true;

document.forms[0].care_of_skin_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_care_of_skin_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_care_of_skin_chk.value == 'Y')
document.forms[0].care_of_skin_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_care_of_skin_chk.value != '')
document.forms[0].care_of_skin_chk.disabled = true;



document.forms[0].care_of_eye_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_care_of_eye_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_care_of_eye_chk.value == 'Y')
document.forms[0].care_of_eye_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_care_of_eye_chk.value != '')
document.forms[0].care_of_eye_chk.disabled = true;


document.forms[0].expr_br_mlk_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_expr_br_mlk_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_expr_br_mlk_chk.value == 'Y')
document.forms[0].expr_br_mlk_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_expr_br_mlk_chk.value != '')
document.forms[0].expr_br_mlk_chk.disabled = true;


document.forms[0].tube_feed_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_tube_feed_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_tube_feed_chk.value == 'Y')
document.forms[0].tube_feed_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_tube_feed_chk.value != '')
document.forms[0].tube_feed_chk.disabled = true;



document.forms[0].gst_feed_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_gst_feed_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_gst_feed_chk.value == 'Y')
document.forms[0].gst_feed_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_gst_feed_chk.value != '')
document.forms[0].gst_feed_chk.disabled = true;


document.forms[0].frm_milk_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_frm_milk_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_frm_milk_chk.value == 'Y')
document.forms[0].frm_milk_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_frm_milk_chk.value != '')
document.forms[0].frm_milk_chk.disabled = true;


document.forms[0].imn_sch_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_imn_sch_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_imn_sch_chk.value == 'Y')
document.forms[0].imn_sch_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_imn_sch_chk.value != '')
document.forms[0].imn_sch_chk.disabled = true;


document.forms[0].care_of_stoma_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_care_of_stoma_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_care_of_stoma_chk.value == 'Y')
document.forms[0].care_of_stoma_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_care_of_stoma_chk.value != '')
document.forms[0].care_of_stoma_chk.disabled = true;


document.forms[0].anl_dil_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_anl_dil_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_anl_dil_chk.value == 'Y')
document.forms[0].anl_dil_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_anl_dil_chk.value != '')
document.forms[0].anl_dil_chk.disabled = true;



document.forms[0].pop_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_pop_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_pop_chk.value == 'Y')
document.forms[0].pop_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_pop_chk.value != '')
document.forms[0].pop_chk.disabled = true;



document.forms[0].fever_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_fever_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_fever_chk.value == 'Y')
document.forms[0].fever_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_fever_chk.value != '')
document.forms[0].fever_chk.disabled = true;



document.forms[0].sz_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_sz_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_sz_chk.value == 'Y')
document.forms[0].sz_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_sz_chk.value != '')
document.forms[0].sz_chk.disabled = true;



document.forms[0].jnd_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_jnd_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_jnd_chk.value == 'Y')
document.forms[0].jnd_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_jnd_chk.value != '')
document.forms[0].jnd_chk.disabled = true;


document.forms[0].gpd_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_gpd_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_gpd_chk.value == 'Y')
document.forms[0].gpd_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_gpd_chk.value != '')
document.forms[0].gpd_chk.disabled = true;



document.forms[0].stlc_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_stlc_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_stlc_chk.value == 'Y')
document.forms[0].stlc_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_stlc_chk.value != '')
document.forms[0].stlc_chk.disabled = true;



document.forms[0].stlf_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_stlf_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_stlf_chk.value == 'Y')
document.forms[0].stlf_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_stlf_chk.value != '')
document.forms[0].stlf_chk.disabled = true;


document.forms[0].coptb_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_coptb_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_coptb_chk.value == 'Y')
document.forms[0].coptb_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_coptb_chk.value != '')
document.forms[0].coptb_chk.disabled = true;


document.forms[0].oth_ph_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_ph_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_oth_ph_chk.value == 'Y')
document.forms[0].oth_ph_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_ph_chk.value != '')
document.forms[0].oth_ph_chk.disabled = true;



document.forms[0].bfd_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_bfd_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_bfd_chk.value == 'Y')
document.forms[0].bfd_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_bfd_chk.value != '')
document.forms[0].bfd_chk.disabled = true;

document.forms[0].stm_cr_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_stm_cr_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_stm_cr_chk.value == 'Y')
document.forms[0].stm_cr_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_stm_cr_chk.value != '')
document.forms[0].stm_cr_chk.disabled = true;


document.forms[0].oper_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_oper_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_oper_chk.value == 'Y')
document.forms[0].oper_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_oper_chk.value != '')
document.forms[0].oper_chk.disabled = true;



document.forms[0].pop_care_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_pop_care_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_pop_care_chk.value == 'Y')
document.forms[0].pop_care_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_pop_care_chk.value != '')
document.forms[0].pop_care_chk.disabled = true;



document.forms[0].oth_pamphlets.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_pamphlets.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_pamphlets.value!='')
document.forms[0].oth_pamphlets.disabled = true;


document.forms[0].db_given_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_db_given_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_db_given_chk.value == 'Y')
document.forms[0].db_given_chk.checked = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_db_given_chk.value != '')
document.forms[0].db_given_chk.disabled = true;

</script>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

