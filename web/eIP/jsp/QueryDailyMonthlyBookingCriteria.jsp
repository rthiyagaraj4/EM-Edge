<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="com.ehis.util.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String facilityID=(String)session.getValue("facility_id");
	String locale	 =(String)session.getAttribute("LOCALE");
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src="../js/IPQueryCommon.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	
function initScreen()
{
	document.getElementById("tr1").style.display= 'none';
	document.getElementById("tr4").style.display= 'none';
}

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

</script>
</head>
<body onLoad="initScreen();enableDisable_Booking(document.forms[0].order);" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='BookingStatisticsLookup_Form' id='BookingStatisticsLookup_Form' action='../jsp/BookingStatisticsLookupResult.jsp' target='result' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td  class='label' width='25%'><fmt:message key="eIP.Bookings.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td  class='fields'  width='25%'>
					<select name='booking' id='booking' onChange="enableDisable_Booking(this)">
						<option value='D'><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>							
					</select>
				</td>
				<td  class='label' width='25%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td  class='fields'  width='25%'>
					<select name='order' id='order' onChange="enableDisable_Booking(this)">
						<option value='MS'><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/></option>
						<option value='NU' selected><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			</tr>			
			<tr id="tr1">
				<td  class='label' width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<!-- Modified to Common lookup on 11/02/04 by Sridhar -->
				<td  class='fields'  width='25%'>
					<input type=text  name='nursing_unit_desc' id='nursing_unit_desc' size="15" maxlength="15" align="center" onblur="beforeCommonLookupSearch_Booking(nursing_unit,nursing_unit_desc);" ><input type=hidden  name='nursing_unit' id='nursing_unit' size="4" maxlength="4" onBlur="return makeValidQueryCriteria(this);" align="center"><input type='button' name='nursing_unit_but' id='nursing_unit_but' value='?' class='button' onclick="CommonLookupSearch_Booking(nursing_unit,nursing_unit_desc);">
				</td><input type='hidden' name='nurs_desc_hid' id='nurs_desc_hid' >
				<td  class='label' width='25%'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
				<td  class='fields'  width='25%'>
					<input type=text  name='bed_class_desc' id='bed_class_desc' size="15" maxlength="15" align="center" onBlur="beforeCommonLookupSearch_Booking(Bedcode,bed_class_desc);return makeValidQueryCriteria(this);" ><input type=hidden  name='Bedcode' id='Bedcode' onBlur="return makeValidQueryCriteria(this);"  align="center"><input type='button' name='bed_class_but' id='bed_class_but' value='?' class='button'
					onclick='CommonLookupSearch_Booking(Bedcode,bed_class_desc)'>
				</td> 
			</tr>
			<tr id="tr2">
				<td  class='label' width='25%'><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<!-- Modified to Common Lookup on 11/02/04 by Sridhar  -->
				<td colspan=3>
					<input type=text  name='medical_service_grp_desc' id='medical_service_grp_desc' align="center" size="15" maxlength="15" onBlur="beforeCommonLookupSearch_Booking(medical_service_grp,medical_service_grp_desc);return makeValidQueryCriteria(this);"  ><input type=hidden  name='medical_service_grp' id='medical_service_grp'  align="center" onBlur="return makeValidQueryCriteria(this);" ><input type='button' name='med_src_grp' id='med_src_grp' value='?' class='button' onclick='CommonLookupSearch_Booking(medical_service_grp,medical_service_grp_desc)'>
				</td> 
			</tr>
			<tr id="tr3">
				<td class='label' width='25%'><fmt:message key="Common.PreferredDateFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				
				<td  class='fields'  width='25%'><input type='text' id="from_date" maxlength='10' size='10' name='from_date' onBlur='DateCompare_Booking(this,to_date);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="from_date.focus();return showCalendar('from_date');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;-&nbsp;<input type='text' id="to_date" value='' maxlength='10' size='10' name='to_date' onBlur='DateCompare_Booking(from_date,this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="to_date.focus();return showCalendar('to_date');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td colspan='2'>&nbsp;</td>
			</tr>		
			<tr id="tr4">
				<td class='label' width='25%'><fmt:message key="eIP.PreferredMonthFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				
				<td  class='fields'  width='25%'><input type='text' maxlength='7' size='7' name='from_month' id='from_month' value='' onBlur="beforeCheckString(this,to_month)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].from_month.focus();return showCalendar('from_month','mm/y',null);"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;-&nbsp;<input type='text' value='' maxlength='7' size='7' name='to_month' id='to_month' onBlur="beforeCheckString(from_month,this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].to_month.focus();return showCalendar('to_month','mm/y',null);"/><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td colspan='2'>&nbsp;</td>
			</tr>		
		</table>
		<table align='right'>
			<tr>
				<td align='right' class='white'>
					<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage_Booking()'>
					<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="enableDisable_Booking(this.form.order);clearAll_Booking()">		
				</td>
				<input type=hidden name="facilityID" id="facilityID" value="<%=facilityID%>">
				<input type=hidden name="locale" id="locale" value="<%=locale%>">
			</tr>				
		</table>
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

