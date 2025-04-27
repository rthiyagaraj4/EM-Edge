<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String locale = (String)session.getAttribute("LOCALE");
    
try 
{
	con=ConnectionManager.getConnection(request);
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function mychange()
 {
	 if (document.getElementById("report_type").value=='M')
	 {
		 
		  document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='P_FR_CENSUS_DATE' id='P_FR_CENSUS_DATE' maxlength='7' size='7' readonly onblur=\"ValidateDt(this,P_FR_CENSUS_DATE,P_TO_CENSUS_DATE,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('P_FR_CENSUS_DATE','mm/y',null);document.forms[0].P_FR_CENSUS_DATE.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("report_type").value=='W')
	 {
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.Week.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='P_FR_CENSUS_DATE' id='P_FR_CENSUS_DATE' size='10' onBlur='CheckDate(this); DateSetup();' maxLength='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('P_FR_CENSUS_DATE','dd/mm/y',null);document.forms[0].P_FR_CENSUS_DATE.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		 
	 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
	 document.getElementById("MY").innerHTML = "<input type='text' name='P_FR_CENSUS_DATE' id='P_FR_CENSUS_DATE' maxlength='10' size='10' readonly onblur=\"ValidateDt(this,P_FR_CENSUS_DATE,P_TO_CENSUS_DATE,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('P_FR_CENSUS_DATE','dd/mm/y',null);document.forms[0].P_FR_CENSUS_DATE.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("report_type").value=='M')
	 {
		 
		  document.getElementById("MY3").innerHTML = "<input type='text' name='P_TO_CENSUS_DATE' id='P_TO_CENSUS_DATE' maxlength='7' size='7' readonly onblur=\"ValidateDt(this,P_FR_CENSUS_DATE,P_TO_CENSUS_DATE,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('P_TO_CENSUS_DATE','mm/y',null);document.forms[0].P_TO_CENSUS_DATE.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("report_type").value=='W')
	 {
		 document.getElementById("MY3").innerHTML = "<input type='text' name='P_TO_CENSUS_DATE' id='P_TO_CENSUS_DATE' size='10' onBlur='CheckDate(this)' maxLength='10' readonly><img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		 
		 document.getElementById("MY3").innerHTML = "<input type='text' name='P_TO_CENSUS_DATE' id='P_TO_CENSUS_DATE' maxlength='10' size='10' readonly onblur=\"ValidateDt(this,P_FR_CENSUS_DATE,P_TO_CENSUS_DATE,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('P_TO_CENSUS_DATE','dd/mm/y',null);document.forms[0].P_TO_CENSUS_DATE.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }	
</script>  
</head>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();mychange()"  onKeyDown = 'lockKey()'>
<form name="MRCSWKDT" id="MRCSWKDT" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
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
						 <option value="W"><fmt:message key="Common.weekly.label" bundle="${common_labels}"/></option>
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
					<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
                 
                <tr>
					<td align='left' id='MY1'class="label"> &nbsp; </td>
					<td align='left' id='MY' > &nbsp; </td>
					<td align='left' id='MY3' > &nbsp; </td>
			    </tr>
			<tr>
				<td colspan=3>&nbsp;</td>
			</tr>

            </table>
        </td>
</tr>
</table>


<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MRCSWKDT">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
</form>
</body>
</html>
<%
} catch(Exception e) { /*  out.println("in else "+e); */e.printStackTrace();} 
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
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

