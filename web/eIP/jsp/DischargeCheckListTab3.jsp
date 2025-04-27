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
<tr>
<td class='COLUMNHEADER' colspan=4><fmt:message key="eIP.HealthEducation.label" bundle="${ip_labels}"/></td>
</tr>
<tr></tr><tr></tr>
<tr>
<td class='COLUMNHEADER'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'></td>
<td class='COLUMNHEADER'><fmt:message key="Common.givenby.label" bundle="${common_labels}"/></td>
<th class='COLUMNHEADER'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
</tr>
<tr>
<td class='label'><fmt:message key="eIP.AdviceonContcare.label" bundle="${ip_labels}"/></td>
<td class='fields'><input type='checkbox' name='adv_cnt_parent' id='adv_cnt_parent' onclick="setValue_tab3(this);" <%=disable_fld%>></td><td class='label'><fmt:message key="eIP.guardian.label" bundle="${ip_labels}"/></td><td class='fields'><input type='checkbox' name='adv_cnt_guardian' id='adv_cnt_guardian' onclick="setValue_tab3(this);" <%=disable_fld%>></td>
</tr>
<tr> 
<td class='label' ><fmt:message key="eIP.WoundCare.label" bundle="${ip_labels}"/></td>
<td class='fields' ><input type='checkbox' name='wc_chk' id='wc_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%> ></td>
<td class='fields' ><input type='text' name='wc_given_by' id='wc_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='wc_given_dt' id='wc_given_dt' size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="wc_given_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].wc_given_dt.select();return showCalendar('wc_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="eIP.Nutrition.label" bundle="${ip_labels}"/></td>
<td class='fields' ><input type='checkbox' name='nu_chk' id='nu_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%> ></td>
<td class='fields' ><input type='text' name='nu_given_by' id='nu_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='nu_given_dt' id='nu_given_dt'  size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="nu_given_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].nu_given_dt.select();return showCalendar('nu_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="Common.Medication.label" bundle="${common_labels}"/></td>
<td class='fields' ><input type='checkbox' name='mc_chk' id='mc_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%> ></td>
<td class='fields' ><input type='text' name='mc_given_by' id='mc_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='mc_given_dt' id='mc_given_dt' size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="mc_given_dt_img"  src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].mc_given_dt.select();return showCalendar('mc_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="eIP.PersonalHygiene.label" bundle="${ip_labels}"/></td>
<td class='fields' ><input type='checkbox' name='ph_chk' id='ph_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%>></td>
<td class='fields' ><input type='text' name='ph_given_by' id='ph_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='ph_given_dt' id='ph_given_dt'  size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="ph_given_dt_img" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].ph_given_dt.select();return showCalendar('ph_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="eIP.CareofPOP.label" bundle="${ip_labels}"/></td>
<td class='fields' ><input type='checkbox' name='cop_chk' id='cop_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%>></td>
<td class='fields' ><input type='text' name='cop_given_by' id='cop_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='cop_given_dt' id='cop_given_dt' size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="cop_given_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].cop_given_dt.select();return showCalendar('cop_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="eIP.CareofCatheters.label" bundle="${ip_labels}"/></td>
<td class='fields' ><input type='checkbox' name='coc_chk' id='coc_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%> ></td>
<td class='fields' ><input type='text' name='coc_given_by' id='coc_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='coc_given_dt' id='coc_given_dt' size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="coc_given_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].coc_given_dt.select();return showCalendar('coc_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="eIP.CareofTube.label" bundle="${ip_labels}"/></td>
<td class='fields' ><input type='checkbox' name='cot_chk' id='cot_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%>></td>
<td class='fields' ><input type='text' name='cot_given_by' id='cot_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='cot_given_dt' id='cot_given_dt'  size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="cot_given_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].cot_given_dt.select();return showCalendar('cot_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
<td class='fields' ><input type='checkbox' name='oth_he_chk' id='oth_he_chk' onclick="setValue_tab3(this);enable_disable_tab3(this);" <%=disable_fld%> ></td>
<td class='label' ></td>
<td class='label' ></td>
</tr>
<tr>
<td class='label'></td>
<td class='fields' ><input type='text' name='oth_text' id='oth_text' size='20' maxlength='80' disabled></td>
<td class='fields' ><input type='text' name='oth_given_by' id='oth_given_by' size='30' maxlength='30' disabled></td>
<td class='fields' ><input type='text' name='oth_given_dt' id='oth_given_dt'  size='16' maxlength='16' onkeypress="return Valid_DT_tab3(event);" onBlur="chk_with_sysdate_tab3(this);" disabled><input type="image" id="oth_given_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_given_dt.select();return showCalendar('oth_given_dt',null,'hh:mm')" disabled>
</td>
</tr>
<tr>
<td class='label' colspan=4></td>
</tr>
</table>
</form>

<script>
document.forms[0].adv_cnt_parent.value = parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_parent.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_parent.value == 'Y')
document.forms[0].adv_cnt_parent.checked = true;



document.forms[0].adv_cnt_guardian.value = parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_guardian.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_adv_cnt_guardian.value == 'Y')
document.forms[0].adv_cnt_guardian.checked = true;


document.forms[0].wc_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_wc_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_wc_chk.value == 'Y')
document.forms[0].wc_chk.checked = true;



document.forms[0].wc_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_wc_given_by.value;


document.forms[0].wc_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_wc_given_dt.value;



document.forms[0].nu_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_nu_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_nu_chk.value == 'Y')
document.forms[0].nu_chk.checked = true;



document.forms[0].nu_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_nu_given_by.value;



document.forms[0].nu_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_nu_given_dt.value;


document.forms[0].mc_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_mc_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_mc_chk.value == 'Y')
document.forms[0].mc_chk.checked = true;



document.forms[0].mc_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_mc_given_by.value;


document.forms[0].mc_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_mc_given_dt.value;


document.forms[0].ph_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_ph_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_ph_chk.value == 'Y')
document.forms[0].ph_chk.checked = true;



document.forms[0].ph_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_ph_given_by.value;


document.forms[0].ph_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_ph_given_dt.value;


document.forms[0].cop_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_cop_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_cop_chk.value == 'Y')
document.forms[0].cop_chk.checked = true;



document.forms[0].cop_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_cop_given_by.value;


document.forms[0].cop_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_cop_given_dt.value;


document.forms[0].coc_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_coc_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_coc_chk.value == 'Y')
document.forms[0].coc_chk.checked = true;



document.forms[0].coc_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_coc_given_by.value;


document.forms[0].coc_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_coc_given_dt.value;


document.forms[0].cot_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_cot_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_cot_chk.value == 'Y')
document.forms[0].cot_chk.checked = true;


document.forms[0].cot_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_cot_given_by.value;


document.forms[0].cot_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_cot_given_dt.value;


document.forms[0].oth_he_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_he_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_oth_he_chk.value == 'Y')
document.forms[0].oth_he_chk.checked = true;



document.forms[0].oth_text.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_text.value;


document.forms[0].oth_given_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_given_by.value;


document.forms[0].oth_given_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_oth_given_dt.value;


</script>
<%

if(!call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
%>

<script>	
	if(document.forms[0].wc_chk.checked==true)
	{		
			document.forms[0].wc_given_by.disabled = false;
			document.forms[0].wc_given_dt.disabled = false;
			document.getElementById("wc_given_dt_img").disabled = false;		
	}
	if(document.forms[0].nu_chk.checked==true)
	{

			document.forms[0].nu_given_by.disabled = false;
			document.forms[0].nu_given_dt.disabled = false;
			document.getElementById("nu_given_dt_img").disabled = false;
	}
	if(document.forms[0].mc_chk.checked==true)
	{
		
			document.forms[0].mc_given_by.disabled = false;
			document.forms[0].mc_given_dt.disabled = false;
			document.getElementById("mc_given_dt_img").disabled = false;		
	}
	if(document.forms[0].ph_chk.checked==true)
	{
			document.forms[0].ph_given_by.disabled = false;
			document.forms[0].ph_given_dt.disabled = false;
			document.getElementById("ph_given_dt_img").disabled = false;
	}
	if(document.forms[0].cop_chk.checked==true)
	{
			document.forms[0].cop_given_by.disabled = false;
			document.forms[0].cop_given_dt.disabled = false;
			document.getElementById("cop_given_dt_img").disabled = false;
	}
	if(document.forms[0].coc_chk.checked==true)
	{
			document.forms[0].coc_given_by.disabled = false;
			document.forms[0].coc_given_dt.disabled = false;
			document.getElementById("coc_given_dt_img").disabled = false;	
	}
	if(document.forms[0].cot_chk.checked==true)
	{
			document.forms[0].cot_given_by.disabled = false;
			document.forms[0].cot_given_dt.disabled = false;
			document.getElementById("cot_given_dt_img").disabled = false;
	}
	if(document.forms[0].oth_he_chk.checked==true)
	{
			document.forms[0].oth_text.disabled = false;
			document.forms[0].oth_given_by.disabled = false;
			document.forms[0].oth_given_dt.disabled = false;
			document.getElementById("oth_given_dt_img").disabled = false;
	}

</script>
<script>
if(parent.DischargeCheckList_frame1.document.forms[0].hh_adv_cnt_parent.value != '')
document.forms[0].adv_cnt_parent.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_adv_cnt_guardian.value != '')
document.forms[0].adv_cnt_guardian.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_wc_chk.value == 'Y')
document.forms[0].wc_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_wc_given_by.value!='')
document.forms[0].wc_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_wc_given_dt.value!='')
{
document.forms[0].wc_given_dt.disabled = true;
document.getElementById("wc_given_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_nu_chk.value != '')
document.forms[0].nu_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_nu_given_by.value!='')
document.forms[0].nu_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_nu_given_dt.value!='')
{
document.forms[0].nu_given_dt.disabled = true;
document.getElementById("nu_given_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_mc_chk.value != '')
document.forms[0].mc_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_mc_given_by.value!='')
document.forms[0].mc_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_mc_given_dt.value!='')
{
document.forms[0].mc_given_dt.disabled = true;
document.getElementById("mc_given_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_ph_chk.value != '')
document.forms[0].ph_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_ph_given_by.value!='')
document.forms[0].ph_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_ph_given_dt.value!='')
{
document.forms[0].ph_given_dt.disabled = true;
document.getElementById("ph_given_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_cop_chk.value != '')
document.forms[0].cop_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_cop_given_by.value!='')
document.forms[0].cop_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_cop_given_dt.value!='')
{
document.forms[0].cop_given_dt.disabled = true;
document.getElementById("cop_given_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_coc_chk.value != '')
document.forms[0].coc_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_coc_given_by.value!='')
document.forms[0].coc_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_coc_given_dt.value!='')
{
document.forms[0].coc_given_dt.disabled = true;
document.getElementById("coc_given_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_cot_chk.value != '')
document.forms[0].cot_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_cot_given_by.value!='')
document.forms[0].cot_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_cot_given_dt.value!='')
{
document.forms[0].cot_given_dt.disabled = true;
document.getElementById("cot_given_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_he_chk.value != '')
document.forms[0].oth_he_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_text.value!='')
document.forms[0].oth_text.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_given_by.value!='')
document.forms[0].oth_given_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_oth_given_dt.value!= '')
{
	document.forms[0].oth_given_dt.disabled = true;
	document.getElementById("oth_given_dt_img").disabled = true;
}

</script>
<%
	}
%>
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

