<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDBDCN" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	
	    java.util.Date dNow = new java.util.Date();
        java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy");        	
		String CurrentDate=ft.format(dNow);	
%>

<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	async function searchCode(obj,target)
		{
				var retVal = 	new String();
				var dialogHeight= "400px" ;
				var dialogWidth	= "700px" ;
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
					search_desc= "short_desc";
				}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	
				if (!(retVal == null))
				{
					target.value=retVal;
				}
				else
					target.focus();
		}
 function ValidString(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}
/*Below function added IN:052797 */
function validateCensusDate(obj) {
		var from = obj.value;	
		var to = document.forms[0].CurrentDate.value;  
		var localeName=document.forms[0].locale.value; 
        var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
		if (!isBeforeNow(obj.value,"DMY",localeName)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=getLabel("eIP.CensusDate.label","IP");					
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}
</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2DailyIPCensusForm" id="Rep2DailyIPCensusForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> Report Criteria
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
				<tr>
					<td align='left' width='35%' class="label">Census Date &nbsp;</td>
					<td width='25%'  >
						<input type=text  name='p_trn_date' id='p_trn_date' size="10" maxlength="10" align="center" onBlur="if(CheckDate(this))validateCensusDate(this);"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_trn_date');">	<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
				</tr>				
				<tr>
						<td align='left' width='30%' class="label">Nursing Unit Code&nbsp;</td>
						<td width='20%'  >
							<input type=text onkeypress='return ValidString(event)' name='p_nursing_unit_code' id='p_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_nursing_unit_code)'>
							<img align='center' src='../../eMP/images/mandatory.gif'>
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

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate" value="<%=CurrentDate%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">

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

