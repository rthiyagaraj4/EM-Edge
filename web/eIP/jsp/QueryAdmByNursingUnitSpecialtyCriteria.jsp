<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facilityID=(String)session.getValue("facility_id");
	String locale	 =(String)session.getAttribute("LOCALE");
	String call_function=request.getParameter("call_function");

		if((call_function == null) || (call_function.equals(""))) call_function=request.getParameter("fromQuery");
%>

<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
    <script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

function beforeCheckString(from,to)
{
	var flg1 = validDateObj(from,"MY",localeName);
	var flg2 = validDateObj(to,"MY",localeName);
	if(flg1 && flg2 )
	{
		var greg_fromdate = convertDate(from.value,"MY",localeName,"en");
		var greg_todate = convertDate(to.value,"MY",localeName,"en");
		if(!isBefore(greg_fromdate,greg_todate,"MY",'en'))
		{
			alert(getMessage("TO_MNTHYEAR_SHD_GREATER","IP"));	
			to.focus();
			to.select();
		}
	}
	return true;
}

function initScreen()
{
	document.getElementById("tr4").style.display= 'none';
}

</script>
</head>
<body onLoad="initScreen()" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='Criteria_Form' id='Criteria_Form'>
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td  class='label' width='25%'><fmt:message key="eIP.Admissions.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td colspan='3'> 
					<select name='daily_monthly' id='daily_monthly' onChange="enableDisable_Adm(this)">
						<option value='D'><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>							
					</select>
				</td>
			</tr>			

			<tr id="tr1">
					<!-- Modified to common Lookup on 11/02/04 by Sridhar -->
				<td  class='label' width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields' width='25%'>
					<input type=text name=nursing_unit_desc size=15 onblur='beforeGetNursingUnit("<%=facilityID%>")'><input type=hidden class=label name=nursing_unit id=nursing_unit size=15 ><input type=hidden class=label name=nurs_desc_hid id=nurs_desc_hid size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick='getNursingUnit("<%=facilityID%>")'>
				</td>
				<td  class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields' width='25%'>
					<input type=text  name='SplDesc' id='SplDesc' size="15" maxlength="15" align="center" onBlur=" beforeGetSpecialty_BedOccupancy(Splcode,SplDesc);"><input type='button' name='spltybutton' id='spltybutton' value='?' class='button' onclick='SpecialLookup_BedOccupancy(Splcode,SplDesc);'><input type=hidden  name='Splcode' id='Splcode' size="4" maxlength="4" align="center">
				</td>
			</tr>
			<tr>
				<td class='label' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='text' name='admission_service' id='admission_service' maxlength='10' size='10' id='admission_service_id' onblur='beforeGetService("<%=facilityID%>",this)'><input type=hidden class='label' name=servicecode id=servicecode  size=15 value=''><input type=hidden class='label' name='service_desc_hidn' id='service_desc_hidn' size=15 value=''><input type='button' class='button' name='service_lookup' id='service_lookup' value='?' onClick='getService("<%=facilityID%>",document.getElementById("admission_service"))'></td>
				<td class='label' width='25%'><fmt:message key="eIP.StatisticsBy.label" bundle="${ip_labels}"/></td>
				<td class='fields' width='25%'><select name='statisticby' id='statisticby' >
						<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>	
						<option value='C'><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>	
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				</tr>
			<tr id="tr3">
				<!--<td class='label' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='text' name='admission_service' id='admission_service' maxlength='10' size='10' id='admission_service_id' onblur='beforeGetService("<%=facilityID%>",this)'><input type=hidden class='label' name=servicecode size=15 value=''><input type=hidden class='label' name='service_desc_hidn' id='service_desc_hidn' size=15 value=''><input type='button' class='button' name='service_lookup' id='service_lookup' value='?'></td>-->
				<td class='label' width='25%'><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields' width='25%'><input type='text'  maxlength='10' size='10' name='from_date' id='from_date'  value='' onBlur='DateCompare_Adm(this,to_date);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from_date');"/>&nbsp;-&nbsp;<input type='text' value='' maxlength='10' size='10' name='to_date' id='to_date' onBlur='DateCompare_Adm(from_date,this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to_date');"/></td>
				<td class='label' colspan='2'></td>
				
			</tr>		
			<tr id="tr4">
				<!--<td class='label' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='text' name='admission_service' id='admission_service' maxlength='10' size='10' id='admission_service_id' onblur='beforeGetService("<%=facilityID%>",this)'><input type='button' class='button' name='service_lookup' id='service_lookup' value='?'><input type=hidden class='label' name='servicecode' id='servicecode' size=15 value=''><input type=hidden class='label' name='service_desc_hidn' id='service_desc_hidn' size=15 value='' ></td>-->
				<td class='label' width='25%'><fmt:message key="eIP.AdmMonthFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields' width='25%'><input type='text' id="month_from" maxlength='7' size='7' name='from_month' id='from_month'  value='' onBlur="beforeCheckString(this,month_to)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('month_from','mm/y',null);"/>&nbsp;-&nbsp;<input type='text' id="month_to" value='' maxlength='7' size='7' name='to_month' id='to_month' onBlur="beforeCheckString(month_from,this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('month_to','mm/y',null);"/></td>	
				<td class='label' colspan='2'></td>
			</tr>
		</table>
		<table align='right'>
			<tr>
				<td align='right' class='white'>
					<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage_Adm()'>
					<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="clearAll_Adm()">
				</td>
			</tr>				
		</table>
		 <input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
		 <input type=hidden name="locale" id="locale" value="<%=locale%>">
		 <input type='hidden' name='booking_type' id='booking_type' value="" >
	 <input type='hidden' name='daycare_unit' id='daycare_unit' value="" >
	</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

