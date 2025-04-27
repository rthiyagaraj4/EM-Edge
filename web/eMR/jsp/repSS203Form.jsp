
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<%
	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	ResultSet rset = null;
	java.sql.Statement stmt1 = null;

	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");

try {

    con=ConnectionManager.getConnection(request);
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

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
function allowPositiveNumberm() 
{
	var key = window.event.keyCode;
	
	// allows only numbers to be entered
	
	if((key >=47 )&&(key <58)) 
		{
			return true;
		}
		else 
			return false
}
function allowPositiveNumbermy() 
{
	var key = window.event.keyCode;
	
	// allows only numbers to be entered
	if((key >47 )&&(key<58)) 
		{
			return true;
		}
		else 
			return false
}

	


function clearList(objSelect)
{
	var length = objSelect.options.length;
	for(var index = 1 ;index < length ;index++)
	{
		objSelect.remove(1)
	}
}

//function name changed and validateDT added for ML-MMOH-SCF-2021 by Kamatchi S
function mychangeRep()
 {
	 //document.getElementById("report_type").value="D";
	 if (document.getElementById("report_type").value=='M')
	 {
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' onblur='ChkDateFormat(this);ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);' onKeypress='return allowPositiveNumberm();'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
	   
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' onkeypress='return allowPositiveNumbermy()' onblur='ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
	    
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10'onBlur='CheckDate(this);ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("report_type").value=='M')
	 {
		  
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' onblur='ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);ChkDateFormat(this);' onKeypress='return allowPositiveNumberm();'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		  
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		
		 
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' onkeypress='return allowPositiveNumbermy()' onblur='ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		  
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' onBlur='ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);CheckDate(this);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }	
 
</script>
</head>
<!--function name changed for ML-MMOH-SCF-2021 by Kamatchi S-->
<body  OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();mychangeRep();"  onKeyDown = 'lockKey()'>
<form name="MRBSS203" id="MRBSS203" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
<th align='left' colspan='4'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
</th>
<tr>
	<td colspan=4>&nbsp;</td>
</tr>
<tr>
	<td colspan=1 width='10%'>&nbsp;</td>
	<td align='right' width='15%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
	<td width='25%'  >
		 <SELECT name="report_type" id="report_type" onchange='mychangeRep()'><!--function name changed for ML-MMOH-SCF-2021 by Kamatchi S-->
		 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
		 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
		 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
		 </SELECT>
	</td>
	<td width='30%'>&nbsp;</td>
</tr>
	<tr>
	<td colspan=4>&nbsp;</td>
</tr>
<tr>
<td colspan=1 >&nbsp;</td>		
<td align='right' id='MY1'class="label"> &nbsp; </td>
		<td align='left' id='MY' > &nbsp; </td>
		<td align='left' id='MY3' > &nbsp; </td>
</tr>
<tr>
	<td colspan=4>&nbsp;</td>
</tr>
	
</table>
<input type="hidden" name="p_report_id" id="p_report_id" 	value="MRBSS203">
<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
 
 
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */ e.printStackTrace();}
finally
{
	if(con != null)ConnectionManager.returnConnection(con,request);
	 if(rset!= null) rset.close();
	 if(stmt1!=null) stmt1.close();
}
%>

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

