<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
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
<form name='DischargeCheckListTab7' id='DischargeCheckListTab7'>
<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
	<tr>
		<td class='COLUMNHEADER' colspan=3>&nbsp;<fmt:message key="eIP.OtherAppliancesFixtures.label" bundle="${ip_labels}"/></td>
	</tr>
	<tr></tr>
	<tr>
		<td class='COLUMNHEADER'>&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.givenby.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='fileds'><input type='text' name='oth_app_fix_item1' id='oth_app_fix_item1' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item1_given1' id='oth_app_fix_item1_given1' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item1_dt1' id='oth_app_fix_item1_dt1' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%>><input type="image"  id="oth_app_fix_item1_dt1_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item1_dt1.select();return showCalendar('oth_app_fix_item1_dt1',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item2' id='oth_app_fix_item2' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item2_given2' id='oth_app_fix_item2_given2' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item2_dt2' id='oth_app_fix_item2_dt2' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%>><input type="image"  id="oth_app_fix_item2_dt2_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item2_dt2.select();return showCalendar('oth_app_fix_item2_dt2',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item3' id='oth_app_fix_item3' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item3_given3' id='oth_app_fix_item3_given3' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item3_dt3' id='oth_app_fix_item3_dt3' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);" <%=disable_fld%>><input type="image" id="oth_app_fix_item3_dt3_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item3_dt3.select();return showCalendar('oth_app_fix_item3_dt3',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item4' id='oth_app_fix_item4' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item4_given4' id='oth_app_fix_item4_given4' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item4_dt4' id='oth_app_fix_item4_dt4' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%>><input type="image" id="oth_app_fix_item4_dt4_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item4_dt4.select();return showCalendar('oth_app_fix_item4_dt4',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item5' id='oth_app_fix_item5' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item5_given5' id='oth_app_fix_item5_given5' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item5_dt5' id='oth_app_fix_item5_dt5' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%>><input type="image" id="oth_app_fix_item5_dt5_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item5_dt5.select();return showCalendar('oth_app_fix_item5_dt5',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item6' id='oth_app_fix_item6' size='50' maxlength='80' <%=disable_fld%> ></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item6_given6' id='oth_app_fix_item6_given6' size='30' maxlength='30' <%=disable_fld%> ></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item6_dt6' id='oth_app_fix_item6_dt6' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%>><input type="image" id="oth_app_fix_item6_dt6_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item6_dt6.select();return showCalendar('oth_app_fix_item6_dt6',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item7' id='oth_app_fix_item7' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item7_given7' id='oth_app_fix_item7_given7' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item7_dt7' id='oth_app_fix_item7_dt7' size='16' maxlength='16' <%=disable_fld%> onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);" ><input type="image" id="oth_app_fix_item7_dt7_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item7_dt7.select();return showCalendar('oth_app_fix_item7_dt7',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item8' id='oth_app_fix_item8' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item8_given8' id='oth_app_fix_item8_given8' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item8_dt8' id='oth_app_fix_item8_dt8' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%> ><input type="image" id="oth_app_fix_item8_dt8_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item8_dt8.select();return showCalendar('oth_app_fix_item8_dt8',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item9' id='oth_app_fix_item9' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item9_given9' id='oth_app_fix_item9_given9' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item9_dt9' id='oth_app_fix_item9_dt9' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%>><input type="image" id="oth_app_fix_item9_dt9_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item9_dt9.select();return showCalendar('oth_app_fix_item9_dt9',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
	<tr>
		<td class='fileds' ><input type='text' name='oth_app_fix_item10' id='oth_app_fix_item10' size='50' maxlength='80' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item10_given10' id='oth_app_fix_item10_given10' size='30' maxlength='30' <%=disable_fld%>></td>
		<td class='fileds' ><input type='text' name='oth_app_fix_item10_dt10' id='oth_app_fix_item10_dt10' size='16' maxlength='16' onkeypress="return Valid_DT_tab7(event);" onBlur="chk_with_sysdate_tab2(this);"  <%=disable_fld%>><input type="image" id="oth_app_fix_item10_dt10_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].oth_app_fix_item10_dt10.select();return showCalendar('oth_app_fix_item10_dt10',null,'hh:mm')" <%=disable_fld%>></td>
	</tr>
<table>
</form>
<script>
	document.forms[0].oth_app_fix_item1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item1.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item1.value!='')
	document.forms[0].oth_app_fix_item1.disabled = true;

	document.forms[0].oth_app_fix_item1_given1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item1_given1.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item1_given1.value!='')document.forms[0].oth_app_fix_item1_given1.disabled = true;

	document.forms[0].oth_app_fix_item1_dt1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item1_dt1.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item1_dt1.value!='')
	{
		document.forms[0].oth_app_fix_item1_dt1.disabled = true;
		document.getElementById("oth_app_fix_item1_dt1_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item2.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item2.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item2.value!='')
	document.forms[0].oth_app_fix_item2.disabled = true;

	document.forms[0].oth_app_fix_item2_given2.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item2_given2.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item2_given2.value!='')document.forms[0].oth_app_fix_item2_given2.disabled = true;

	document.forms[0].oth_app_fix_item2_dt2.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item2_dt2.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item2_dt2.value!='')
	{
		document.forms[0].oth_app_fix_item2_dt2.disabled = true;
		document.getElementById("oth_app_fix_item2_dt2_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item3.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item3.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item3.value!='')
	document.forms[0].oth_app_fix_item3.disabled = true;

	document.forms[0].oth_app_fix_item3_given3.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item3_given3.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item3_given3.value!='')document.forms[0].oth_app_fix_item3_given3.disabled = true;

	document.forms[0].oth_app_fix_item3_dt3.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item3_dt3.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item3_dt3.value!='')
	{
		document.forms[0].oth_app_fix_item3_dt3.disabled = true;
		document.getElementById("oth_app_fix_item3_dt3_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item4.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item4.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item4.value!='')
	document.forms[0].oth_app_fix_item4.disabled = true;

	document.forms[0].oth_app_fix_item4_given4.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item4_given4.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item4_given4.value!='')document.forms[0].oth_app_fix_item4_given4.disabled = true;

	document.forms[0].oth_app_fix_item4_dt4.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item4_dt4.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item4_dt4.value!='')
	{
		document.forms[0].oth_app_fix_item4_dt4.disabled = true;
		document.getElementById("oth_app_fix_item4_dt4_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item5.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item5.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item5.value!='')
	document.forms[0].oth_app_fix_item5.disabled = true;

	document.forms[0].oth_app_fix_item5_given5.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item5_given5.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item5_given5.value!='')document.forms[0].oth_app_fix_item5_given5.disabled = true;

	document.forms[0].oth_app_fix_item5_dt5.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item5_dt5.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item5_dt5.value!='')
	{
		document.forms[0].oth_app_fix_item5_dt5.disabled = true;
		document.getElementById("oth_app_fix_item5_dt5_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item6.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item6.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item6.value!='')
	document.forms[0].oth_app_fix_item6.disabled = true;

	document.forms[0].oth_app_fix_item6_given6.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item6_given6.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item6_given6.value!='')document.forms[0].oth_app_fix_item6_given6.disabled = true;

	document.forms[0].oth_app_fix_item6_dt6.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item6_dt6.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item6_dt6.value!='')
	{
		document.forms[0].oth_app_fix_item6_dt6.disabled = true;
		document.getElementById("oth_app_fix_item6_dt6_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item7.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item7.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item7.value!='')
	document.forms[0].oth_app_fix_item7.disabled = true;

	document.forms[0].oth_app_fix_item7_given7.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item7_given7.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item7_given7.value!='')document.forms[0].oth_app_fix_item7_given7.disabled = true;

	document.forms[0].oth_app_fix_item7_dt7.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item7_dt7.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item7_dt7.value!='')
	{
		document.forms[0].oth_app_fix_item7_dt7.disabled = true;
		document.getElementById("oth_app_fix_item7_dt7_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item8.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item8.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item8.value!='')
	document.forms[0].oth_app_fix_item8.disabled = true;

	document.forms[0].oth_app_fix_item8_given8.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item8_given8.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item8_given8.value!='')document.forms[0].oth_app_fix_item8_given8.disabled = true;

	document.forms[0].oth_app_fix_item8_dt8.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item8_dt8.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item8_dt8.value!='')
	{
		document.forms[0].oth_app_fix_item8_dt8.disabled = true;
		document.getElementById("oth_app_fix_item8_dt8_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item9.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item9.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item9.value!='')
	document.forms[0].oth_app_fix_item9.disabled = true;

	document.forms[0].oth_app_fix_item9_given9.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item9_given9.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item9_given9.value!='')document.forms[0].oth_app_fix_item9_given9.disabled = true;

	document.forms[0].oth_app_fix_item9_dt9.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item9_dt9.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item9_dt9.value!='')
	{
		document.forms[0].oth_app_fix_item9_dt9.disabled = true;
		document.getElementById("oth_app_fix_item9_dt9_img").disabled = true;
	}

	document.forms[0].oth_app_fix_item10.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item10.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item10.value!='')
	document.forms[0].oth_app_fix_item10.disabled = true;

	document.forms[0].oth_app_fix_item10_given10.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item10_given10.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item10_given10.value!='')document.forms[0].oth_app_fix_item10_given10.disabled = true;

	document.forms[0].oth_app_fix_item10_dt10.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_app_fix_item10_dt10.value;
	if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_app_fix_item10_dt10.value!='')
	{
		document.forms[0].oth_app_fix_item10_dt10.disabled = true;
		document.getElementById("oth_app_fix_item10_dt10_img").disabled = true;
	}


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

