<!DOCTYPE html>
<%@ page import="java.sql.*" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String p_module_id		= "IP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
function mychange()
{
	 if (document.getElementById("p_type").value=='M')
	 {
		 document.getElementById("MY1").innerHTML="Census Month&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.getElementById("MY1").innerHTML="Census Year&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			
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
	
				if(obj.name=="speciality")
				{
					tit="Specialty"
					sql="select speciality_code, short_desc from am_speciality";
					search_code="speciality_code";
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

		function ChkDateFormat(Object2) {
			var datefield = Object2;
			if (ChkDate1(Object2) == false) {
				alert(parent.parent.parent.frames[0].getMessage('INVALID_DATE_FMT'));
				datefield.select();
				datefield.focus();		
				return false;
			}
			else {
				return true;
			}
		}
		
		function ChkDate1(Object3) {
		var strDate;	
		var strMonth;
		var strYear;	
		var datefield = Object3;
		var strDateArray = new Array();

		strDate = datefield.value;
		if (strDate.length == 0) return true; 
		
		strDateArray = strDate.split("/");
		if (strDateArray.length != 2) {
			return false;
		}
		else {
			strMonth = strDateArray[0];
			strYear = strDateArray[1];
		}


		if (strYear.length < 4) return false;
		if (isNaN(strMonth)==true) return false;
		if (isNaN(strYear)==true) return false;
		if (strYear < 1900) return false;
		if (strMonth>12 || strMonth<1) 	return false;
		return true;
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
</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="mychange()">
<br>
<br>
<form name="Rep2MonthlyIPCensusSpecialityForm" id="Rep2MonthlyIPCensusSpecialityForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> Report Criteria
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>
		<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td align='left' width='30%' class="label">Report Type&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_type" id="p_type" onchange='mychange()'>
						 <option value="M">Month</option>
						 <option value="Y">Year</option>
						 </SELECT>
					</td>
					 <td colspan ='3'> 
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;&nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					<td colspan ='3'></td>
				</tr>
				<tr>
						<td align='left' id='MY1'class="label"> &nbsp; &nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td><td> </td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					
				</tr>

				<tr>
						<td align='left' width='30%' class="label">Specialty Code&nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_speciality_code' id='p_speciality_code' onkeypress='return ValidString(event)' size="4" maxlength="4" align="center"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode(this, p_speciality_code)'>
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
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
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

