<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<%
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDDCNN" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src='../js/Rep2MasterList.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
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
	
				if(obj.name=="nursing_unit")
				{
					tit="Nursing Unit"
					sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%=p_facility_id%>`";
					search_code="nursing_unit_code";
					search_desc=  "short_desc";
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
<form name="Rep2DailyIPCensusNUForm" id="Rep2DailyIPCensusNUForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> Report Criteria
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
				<tr>
					<td align='right' width='30%' class="label">Census Date &nbsp;</td>
					<td width='25%'  >
						<input type=text  name='p_trn_date' id='p_trn_date' size="10" maxlength="10" align="center" onblur='CheckDate(this)'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_trn_date');">
						<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%">From</td>
					<td class="label" width="40%">To</td>
				</tr>				
				<tr>
						<td align='right' width='30%' class="label">Nursing Unit Code&nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_fr_nursing_unit' id='p_fr_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_fr_nursing_unit)'>
						</td>
						<td width='40%'>
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
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

	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">

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

