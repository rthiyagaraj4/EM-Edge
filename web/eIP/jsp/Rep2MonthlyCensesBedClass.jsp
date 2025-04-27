<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBMIPCB" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>	
	<script src="../../eCommon/js/common.js" language='JavaScript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language='JavaScript'></script>
	<script src="../../eCommon/js/DateUtils.js" language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
async	function searchCode(obj,target)
		{
				var retVal = 	new String();
				var dialogHeight= "400px" ;
				var dialogWidth="900px";
				/* var dialogHeight= "28" ;
				var dialogWidth	= "43" ; */
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var tit="";
				var locale= "<%=locale%>"

				if(obj.name=="bed_class")
				{
					tit=getLabel('Common.BedClass.label','common')
					//sql="select bed_class_code, short_desc from ip_bed_class";
					sql="select bed_class_code, short_desc from ip_bed_class_lang_vw where language_id=`"+locale+"`";
					search_code="bed_class_code";
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

		/*function ChkDateFormat(Object2) {
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
 }*/
</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2MonthlyIPCensusBedClassForm" id="Rep2MonthlyIPCensusBedClassForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
				<tr>
					<td width='30%' class="label"><fmt:message key="eIP.CensusMonth.label" bundle="${ip_labels}"/> &nbsp;</td>
					<td class="fields" width='25%'  >
						<input type=text  name='p_trn_date' id='p_trn_date' size="7" maxlength="7" align="center" onblur='validDateObj(this,"MY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_trn_date','mm/y',null);">
						<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>				
				<tr>
						<td  width='30%' class="label"><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/>&nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fr_bed_class' id='p_fr_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class' id='bed_class' value='?' class='button' onclick='searchCode(this, p_fr_bed_class)'>
						</td>
						<td class="fields" width='40%'>
							<input type=text  name='p_to_bed_class' id='p_to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class' id='bed_class' value='?' class='button' onclick='searchCode(this, p_to_bed_class)'>
						</td>
				</tr>
				
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>
				
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">

	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
		

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

