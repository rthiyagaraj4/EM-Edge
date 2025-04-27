<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%!
	String p_module_id		= "RS" ;
	String p_report_id		= "RSBSTWPL" ;
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function searchStaffForWorkplace(target)
{
	var frmObj = document.form_repStaffForWorkplaceList;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = "select workplace_code code, workplace_desc description  from rs_workplace where eff_status = 'E' and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?)order by workplace_desc ";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = RSCommonLookup("Workplace", argumentArray );
	if(retVal != null && retVal != "" )  {
	target.value = retVal[1] ;
	frmObj.workplace_code.value = retVal[0];
	}
}
</script>
</HEAD>

<BODY onKeyDown = 'lockKey()'>
<br>
<br>
<form name="form_repStaffForWorkplaceList" id="form_repStaffForWorkplaceList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>
	<th align='left'> Report Criteria
	</th>
	<tr>
		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
					<tr>
						<td align="left" width="35%">&nbsp;</td>
						<td class="label"  align="left"  width="20%">From</td>
						<td class="label" align="left"  width="40%">To</td>
					</tr>
					<tr>
						<td align="right" class="label" width="20%">Workplace &nbsp;</td>
						<td  width="30%">
						<input type=text  name='from_workplace_desc' id='from_workplace_desc' value="" size="10"  onblur="searchStaffForWorkplace(from_workplace_desc)"><input type='button' name='workplace1' id='workplace1' value='?' class='button' onclick="searchStaffForWorkplace(from_workplace_desc)"><input type="hidden" name="from_workplace_code" id="from_workplace_code" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_workplace_desc' id='to_workplace_desc' value="" size="10" onblur="searchStaffForWorkplace(to_workplace_desc)"><input type='button' name='workplace2' id='workplace2' value='?' class='button' onclick='searchStaffForWorkplace(to_workplace_desc)'><input type="hidden" name="to_workplace_code" id="to_workplace_code" value="">
						</td>
				</tr>
				<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%'  class="label">Nature &nbsp; </td>
					<td width='20%' align="left">
						<select name='p_nature' id='p_nature'>
						<option value="B">Both
						<option value="E">Enabled
						<option value="D">Disabled
						</select>
					</td>
				</tr>

<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=session.getValue("facility_id")%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=session.getValue("login_user")%>">
<input type="hidden" name="pref" id="pref" >
<input type="hidden" name="text" id="text" >
</form>
</BODY>
</HTML>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

