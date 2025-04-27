<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%!
	String p_module_id		= "RS" ;
%>
<html>
<HEAD>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function getReportId(obj)
{
	var val=obj.value;
	if(val=='WS')
		document.form_repShiftPatternForWorkplaceList.p_report_id.value='RSBSPWPL';
	else if(val=='SW')
		document.form_repShiftPatternForWorkplaceList.p_report_id.value='RSBSPWP1';

}
function searchShiftPatternWorkplace(target1,target2)
{
	var frmObj = document.form_repShiftPatternForWorkplaceList;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var obj = target1;
	if(obj == 'W')
	{
		argumentArray[0] = "select workplace_code code, workplace_desc description  from rs_workplace where eff_status = 'E' and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?)order by workplace_desc ";
	}else
	{
		argumentArray[0] = "select shift_code code, short_desc description  from am_shift where eff_status = 'E' and upper(shift_code) like upper(?) and upper(short_desc) like upper(?)order by short_desc ";
	}

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target2.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = RSCommonLookup("ShiftPatternForWorkplace", argumentArray );
	if(retVal != null && retVal != "" )  {
	target2.value = retVal[1] ;
if(obj == 'W')
	frmObj.workplace_code.value = retVal[0];
else
	frmObj.shift_code.value = retVal[0];
	}
}
</script>
</HEAD>

<BODY onKeyDown = 'lockKey()'>
<br>
<br>
<form name="form_repShiftPatternForWorkplaceList" id="form_repShiftPatternForWorkplaceList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

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
						<input type=text  name='from_workplace_desc' id='from_workplace_desc' value="" size="10" onblur="searchShiftPatternWorkplace('W',from_workplace_desc)"><input type='button' name='workplce1' id='workplce1' value='?' class='button' onclick="searchShiftPatternWorkplace('W',from_workplace_desc)"><input type="hidden" name="from_workplace_code" id="from_workplace_code" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_workplace_desc' id='to_workplace_desc' value="" size="10" onblur="searchShiftPatternWorkplace('W',to_workplace_desc)"><input type='button' name='workplce2' id='workplce2' value='?' class='button' onclick="searchShiftPatternWorkplace('W',to_workplace_desc)"><input type="hidden" name="to_workplace_code" id="to_workplace_code" value="">

						</td>
				</tr>
				<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align="right" class="label" width="20%">Shift Pattern&nbsp;&nbsp;</td>
						<td  width="30%">
						<input type=text  name='from_shift_desc' id='from_shift_desc' value="" size="10" onblur="searchShiftPatternWorkplace('S',from_shift_desc)"><input type='button' name='shift1' id='shift1' value='?' class='button' onclick="searchShiftPatternWorkplace('S',from_shift_desc)"><input type="hidden" name="from_shift_code" id="from_shift_code" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_shift_desc' id='to_shift_desc' value="" size="10" onblur="searchShiftPatternWorkplace('S',to_shift_desc)"><input type='button' name='shift2' id='shift2' value='?' class='button' onclick="searchShiftPatternWorkplace('S',to_shift_desc)"><input type="hidden" name="to_shift_code" id="to_shift_code" value="">
						</td>
				</tr>
				<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
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
						<select name='p_order_by' id='p_order_by' onChange='getReportId(this);'>
						<option value='WS'>Workplace,Shift
						<option value='SW'>Shift,Workplace
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
<input type="hidden" name="p_report_id" id="p_report_id" value="">
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

