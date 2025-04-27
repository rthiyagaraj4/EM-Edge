<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "MR" ;
	String p_report_id		= "MROPCSED" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
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
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10'readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("p_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			
		async function searchCode(obj,target)
		{
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var allfacilityid	=	document.Rep2YrlyAdmnTypeForm.p_all_facility_id.value;
			var from_pract_type = document.Rep2YrlyAdmnTypeForm.fm_pract_type.value;
			var to_pract_type = document.Rep2YrlyAdmnTypeForm.to_pract_type.value;

			tit=getLabel("Common.speciality.label","Common");
			sql="select speciality_code,short_desc from am_speciality ";
			search_code="speciality_code";
			search_desc= "short_desc"; 
			
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}


async function searchCode1(obj,target)
		{
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if (obj.name == "clinic") 
			{
			tit=getLabel("Common.emergency.label","Common")+' '+getLabel("Common.clinic.label","Common");
			sql="select clinic_code,long_desc from op_clinic where level_of_care_ind = `E`";
			search_code="clinic_code";
			search_desc= "long_desc";
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



		function ChkDateFormat(Object2) {
			var datefield = Object2;
			if (ChkDate1(Object2) == false) {
				alert(parent.parent.parent.frames[0].getMessage('INVALID_DATE_FMT','SM'));
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
</script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="mychange()" onKeyDown='lockKey()'>
<br>
<br>
<form name="repOPAttforEmgyDeptForm" id="repOPAttforEmgyDeptForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
               <tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
				</tr>
	
				<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_type" id="p_type" onchange='mychange()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
				</tr>
						 <td colspan ='3'> 
				<tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
				</tr>
					<td colspan ='3'></td>
				<tr>
					 <td width='30%' align='right' class='label' nowrap><fmt:message key="eMR.EmergencyClinicCode.label" bundle="${mr_labels}"/> &nbsp;&nbsp;</td>
					 <td align='left'>
						<input name='p_clinic_code' id='p_clinic_code' value='' size='5' maxlength='4'>
						<input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode1(this,p_clinic_code)'>
						&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>	
				<tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
				</tr>
				<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
           </tr>
				<tr>
						<td align='right' id='MY1'class="label">&nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td>
						<!-- <td align='right' id='MY2'class="label">&nbsp;</td> -->
						<td align='left' id='MY3' > &nbsp; </td>
				</tr>
				<tr>
					<td align='right' width='35%' class="label"> &nbsp;</td>
					<td width='25%'  ></td>
					<td>&nbsp;</td>
					
				</tr>
			
           </tr>
		 <tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_report_by" id="p_report_by" >
						 <option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
                         <option value="M"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
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
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">

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

