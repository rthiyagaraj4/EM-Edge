<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
    Connection con =null;
	ResultSet rset = null;
	ResultSet rset2 = null;
	java.sql.Statement stmt1 = null;
	java.sql.Statement stmt2 = null;

	String patient_class = "";
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
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
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

	
async function searchCode(obj,target)
{
			var loctype = document.forms[0].p_location_type.value;
			var patclass = document.forms[0].p_patient_class.value;
			var facility = '<%=facility_id%>'
			var retVal = 	new String();
			var dialogHeight= "28vh" ;
			var dialogWidth	= "43vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			if(obj.name=="clinic")
			{ 
				tit=getLabel("Common.clinic.label","Common");
				sql="select clinic_code, long_desc from op_clinic where facility_id=`"+facility+"` and CARE_LOCN_TYPE_IND=nvl(`"+loctype+"`,CARE_LOCN_TYPE_IND) and LEVEL_OF_CARE_IND=nvl(`"+patclass+"`,LEVEL_OF_CARE_IND)"; 
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

function clearList(objSelect)
{
	var length = objSelect.options.length;
	for(var index = 1 ;index < length ;index++)
	{
		objSelect.remove(1)
	}
}
function mychange()
 {
	 if (document.getElementById("report_type").value=='M')
	 {
		 if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }else{
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		 
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='7' size='7' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','mm/y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
	    if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }else{
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='4' size='4' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
	    if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }else{
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='10' size='10' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','dd/mm/y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("report_type").value=='M')
	 {
		   if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }else{
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='7' size='7' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','mm/y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		
		  if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }else{
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='4' size='4' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		  if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }else{
		     document.forms[0].p_report_id.value="MRBLABWL";
		 }
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='10' size='10' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','dd/mm/y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }		
 
</script>
</head>
<body  OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();mychange();"  onKeyDown = 'lockKey()'>
<form name="MRBLABWL" id="MRBLABWL" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="0" cellspacing="0"  align='center'>
<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
</th>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>
<tr>
	<td align='left' width='20%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
	<td width='25%'  >
		 <SELECT name="report_type" id="report_type" onchange='mychange()'>
		 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
		 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
		 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
		 </SELECT>
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>
<tr>
		<td align='left' id='MY1'class="label"> &nbsp; </td>
		<td align='left' id='MY' > &nbsp; </td>
		<td align='left' id='MY3' > &nbsp; </td>
</tr>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>
<tr>
	<td align='left' width='30%' class="label" ><fmt:message key="eMR.ReportFor.label" bundle="${mr_labels}"/>&nbsp;</td>	 

			
	<td>
		<SELECT name="p_patient_class" id="p_patient_class" >
		<option value='' style='align:center'>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
		String sql2="select patient_class, short_desc from am_patient_class where PATIENT_CLASS not in('XT') ORDER BY SHORT_DESC";
	
	stmt2 = con.createStatement();			
     rset2 = stmt2.executeQuery(sql2);
	 
			 String desc="";
		 while(rset2.next() && rset2 !=null)
				{
					
					patient_class=rset2.getString("patient_class");
					desc=rset2.getString("short_desc");
					
					out.println("<option value=\""+patient_class+"\">"+desc);
				}
			%>
		</SELECT>&nbsp;
       <!-- <img align='center' src='../../eCommon/images/mandatory.gif'></img> -->
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>

    <%	if(function_id.equals("excepRep")){ %>
	  <tr>
			  <td align='right' width='35%' class="label">&nbsp;</td>
			  		<td >&nbsp;</td>
			  		<td >&nbsp;<td>
			  </tr>
			  <%}else{%>
	<tr>
		<td align='left' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'>
		<SELECT name="p_type" id="p_type" >
		<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
		<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>
		<td >&nbsp; </td>
	</tr>
       <%}%>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
</table>
<input type="hidden" name="p_report" id="p_report"	value="MROPCSEG">
<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<%if(function_id.equals("excepRep")){%>
  <input type="hidden" name="p_report_id" id="p_report_id" 		value="MRBLABWL">
<%}else{%>
  <input type="hidden" name="p_report_id" id="p_report_id" 		value="MRBLABWL">
<%}%>
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
	 if(rset!= null) rset2.close();
	 if(stmt1!=null) stmt1.close();
	 if(stmt1!=null) stmt2.close();
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

