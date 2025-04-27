<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@		page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "MR" ;
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name	= (String) session.getValue( "login_user" ) ;
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/CommonCalendar.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
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
		if(obj.name=="bed_class")
		{
			tit=getLabel('Common.BedClass.label','common')
			sql="select bed_class_code, short_desc from ip_bed_class";
			search_code="bed_class_code";
			search_desc= "short_desc";
		}
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
		if (!(retVal == null))
			target.value=retVal;
		else
			target.focus();
}

function mychange()
{
	if (document.getElementById("report_type").value=='M')
	{
		document.forms[0].p_report_id.value="IPBMCSBU";
		document.getElementById("MY1").innerHTML=getLabel('Common.month.label','common')+"&nbsp;"
		document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>";
	}
	else  if (document.getElementById("report_type").value=='Y')
	{
		document.forms[0].p_report_id.value="IPBMCSBU";
		document.getElementById("MY1").innerHTML=getLabel('Common.year.label','common')+"&nbsp;"
		document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>";
	}
}	
</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' onload='mychange()'>
<br>
<br>
<form name="Rep2MthYrlyBedUtilization" id="Rep2MthYrlyBedUtilization" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='70%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'  >
						 <SELECT name="report_type" id="report_type" onchange='mychange()'>
						 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
					<td colspan ='2'>
				</tr>				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>			
				<tr>
					<td align='right' id='MY1'class="label"> &nbsp; </td>
					<td align='left' id='MY' > &nbsp; </td>
				</tr>
				
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
		</table>
	</td>
</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"  value="">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_date_fmt" id="p_date_fmt"	value="">

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

