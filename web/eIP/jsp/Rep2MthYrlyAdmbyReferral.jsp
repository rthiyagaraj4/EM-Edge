<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	Connection con =null;
	ResultSet rset = null;
	Statement stmt = null;
	String currentdate = "";
	try 
 {
	con=ConnectionManager.getConnection(request);
	String getDate = "select to_char(sysdate,'dd/mm/rrrr') sdate from dual" ;
	 stmt = con.createStatement();
	rset	  = stmt.executeQuery(getDate);
	if (rset.next())
	{
		currentdate	=  rset.getString("sdate");
	}
	
	} catch(Exception e) {  out.println("in else "+e);}
finally
{   if ( stmt != null ) stmt.close();
	if ( rset != null ) rset.close();
	ConnectionManager.returnConnection(con,request);
}
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
<script src="../../eMR/js/MRReports.js"></script>
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
	if(obj.name=="bed_class")
	{
		tit=getLabel('Common.referralsource.label','common');
		sql="select distinct(HCARE_SETTING_TYPE_CODE),SHORT_DESC from am_hcare_setting_type_lang_vw where language_id =`<%=localeName%>`";
		search_code="HCARE_SETTING_TYPE_CODE";
		search_desc= "SHORT_DESC";
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

function mychange()
{
 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="IPBMCREF";
		 document.getElementById('MY1').innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		 document.getElementById('MY').innerHTML = "<input type='text' name='p_fm_date' id='p_fm_date' id='census_mth' maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,document.forms[0].p_to_date,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,p_fm_date,p_to_date,document.getElementById('report_type').value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('census_mth','mm/y',null);document.forms[0].p_fm_date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
         document.getElementById('MY2').innerHTML = "<input type='text' name='p_to_date' id='p_to_date' id='census_mth1' maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,document.forms[0].p_fm_date,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,p_fm_date,p_to_date,document.getElementById('report_type').value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('census_mth1','mm/y',null);document.forms[0].p_to_date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.forms[0].p_report_id.value="IPBMCREF";
		 document.getElementById('MY1').innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById('MY').innerHTML = "<input type='text' name='p_fm_date' id='p_fm_date' id='census_date' maxlength='4' size='4' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,document.forms[0].p_to_date,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,p_fm_date,p_to_date,document.getElementById('report_type').value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('census_date','y',null);document.forms[0].p_fm_date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
         document.getElementById('MY2').innerHTML = "<input type='text' name='p_to_date' id='p_to_date' id='census_date1' maxlength='4' size='4' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,document.forms[0].p_fm_date,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,p_fm_date,p_to_date,document.getElementById('report_type').value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('census_date1','y',null);document.forms[0].p_to_date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="IPBMCREF";
		 document.getElementById('MY1').innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
	     document.getElementById('MY').innerHTML = "<input type='text' name='p_fm_date' id='p_fm_date' id='census_date' maxlength='10' size='10' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,document.forms[0].p_to_date,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,p_fm_date,p_to_date,document.getElementById('report_type').value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('census_date','dd/mm/y',null);document.forms[0].p_fm_date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
         document.getElementById('MY2').innerHTML = "<input type='text' name='p_to_date' id='p_to_date' id='census_date1' maxlength='10' size='10' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,document.forms[0].p_fm_date,document.forms[0].current_date,document.getElementById('report_type').value); ValidateDt(this,p_fm_date,p_to_date,document.getElementById('report_type').value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('census_date1','dd/mm/y',null);document.forms[0].p_to_date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"


	 }

 
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

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' onload="mychange()">
<br>
<br>
<form name="Rep2MthYrlyBedUtilization" id="Rep2MthYrlyBedUtilization" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='left' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'  >
						 <SELECT name="report_type" id="report_type" onchange='mychange()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
						<td align='left' id='MY1'class="label"> &nbsp; </td>
						<td align='left' id='MY' > &nbsp; </td>
						<td align='left' id='MY2' >&nbsp; </td>
                        <td><td>
				</tr>
				
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
								
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_fm_ref' id='p_fm_ref' size="2" maxlength="2" align="center"  onkeypress='return ValidString(event)' ><input type='button' name='bed_class' id='bed_class' value='?' class='button' onclick='searchCode(this, p_fm_ref)'>
						</td>
						<td width='40%'>
							<input type=text  onkeypress='return ValidString(event)'  name='p_to_ref' id='p_to_ref' size="2" maxlength="2" align="center" ><input type='button' name='bed_class' id='bed_class' value='?' class='button' onclick='searchCode(this, p_to_ref)'>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='left' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="P_REPORT_BY" id="P_REPORT_BY" >
						 <option value="D"><fmt:message key="eOR.Detail.label" bundle="${or_labels}"/></option>
						 <option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
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

	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"  value="">
	<input type="hidden" name="p_user_name" id="p_user_name"	 value="<%= p_user_name %>">
	<input type="hidden" name="p_date_fmt" id="p_date_fmt"	 value="">
    <input type="hidden" name="current_date" id="current_date"	value="<%=currentdate%>">
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

