<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%!
	String p_module_id		= "RS" ;
	String p_report_id		= "RSBSHPTN" ;
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function searchShiftPattern(target)
{
	var frmObj = document.form_repShiftPatternList;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = "select shift_pattern_id code, short_desc description  from rs_shift_pattern where eff_status = 'E' and upper(shift_pattern_id) like upper(?) and upper(short_desc) like upper(?)order by short_desc ";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = RSCommonLookup("Shift Pattern", argumentArray );
	if(retVal != null && retVal != "" )  {
	target.value = retVal[1] ;
	frmObj.shift_pattern_id.value = retVal[0];
	}
}
</script>
</head>

<BODY onKeyDown = 'lockKey()'>
<br>
<br>
<form name="form_repShiftPatternList" id="form_repShiftPatternList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

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
						<td align="right" class="label" width="20%">Shift Pattern &nbsp;</td>
						<td  width="30%">
						<input type=text  name='from_shift_pattern' id='from_shift_pattern' value="" size="10"  onblur="searchShiftPattern(from_shift_pattern)"><input type='button' name='grade1' id='grade1' value='?' class='button' onclick="searchShiftPattern(from_shift_pattern)"><input type="hidden" name="shift_pattern_id" id="shift_pattern_id" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_shift_pattern' id='to_shift_pattern' value="" size="10"  onblur="searchShiftPattern(to_shift_pattern)"><input type='button' name='grade2' id='grade2' value='?' class='button' onclick='searchShiftPattern(to_shift_pattern)'><input type="hidden" name="shift_pattern_id" id="shift_pattern_id" value="">

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
				<tr>
					<td align="right" width='30%' class="label">
						Order By &nbsp;
					</td>
					<td width='20%' align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'>Shift Pattern ID
						<option value='2'>Short Desc
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
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" )%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" )%>">
<input type="hidden" name="pref" id="pref">
<input type="hidden" name="text" id="text">
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

