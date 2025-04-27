<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBBSCLT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>
<script src="../../eCommon/js/common.js" language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function setFrBoookingVal(Obj)
{
	if(Obj.selectedIndex != 0)
	   document.forms[0].p_fr_booking_val.value = Obj.options[Obj.selectedIndex].text;
	else
  	   document.forms[0].p_fr_booking_val.value = "";
}

function setToBoookingVal(Obj)
{
	if(Obj.selectedIndex != 0)
	   document.forms[0].p_to_booking_val.value = Obj.options[Obj.selectedIndex].text;
	else
  	   document.forms[0].p_to_booking_val.value = "";
}

async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			if(obj.name=="block_code")
			{
				tit=getLabel('Common.BedClass.label','common')
				sql="select blocking_type_code, short_desc from ip_blocking_type ";
				search_code="blocking_type_code";
				search_desc= "short_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="RepBedBookingSrlControlForm" id="RepBedBookingSrlControlForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align="center" width="20%">&nbsp;</td>
					<td class="querydata" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				
				<tr>
						<td align='left' width='20%' class="label"><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/>&nbsp;</td>
						<td class="fields" width='40%'  >
						   <select name='p_fr_booking' id='p_fr_booking' onChange="setFrBoookingVal(this);">&nbsp;
							   <option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
							   <option value='B'><fmt:message key="eIP.BlockBed.label" bundle="${ip_labels}"/>
							   <option value='D'><fmt:message key="eIP.BlockBedonDischarge.label" bundle="${ip_labels}"/>
							   <option value='T'><fmt:message key="eIP.PatientTransfer.label" bundle="${ip_labels}"/>
						   </select> 
						</td>
						<td class="fields" width='40%'> 
							 <select name='p_to_booking' id='p_to_booking'  onChange="setToBoookingVal(this);">&nbsp;
							   <option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
							   <option value='B'><fmt:message key="eIP.BlockBed.label" bundle="${ip_labels}"/>
							   <option value='D'><fmt:message key="eIP.BlockBedonDischarge.label" bundle="${ip_labels}"/>
							   <option value='T'><fmt:message key="eIP.PatientTransfer.label" bundle="${ip_labels}"/>
						   </select> 
						</td>
				</tr>
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_fr_booking_val" id="p_fr_booking_val"	value="">
	<input type="hidden" name="p_to_booking_val" id="p_to_booking_val"	value="">
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
</form>
</BODY>
</HTML>

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

