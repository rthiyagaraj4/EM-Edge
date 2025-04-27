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


<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function valid()
{
	var field1 = parent.f_query_add_mod.document.MROPCSEG.p_patient_class.value;
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

			retVal =await  window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

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

function doDateCheck(from,to,messageFrame) {
var fromarray; var toarray;
var fromdate = from.value ;
var todate = to.value ;

if(fromdate.length > 0 && todate.length > 0 ) {
fromarray = fromdate.split("/");
toarray = todate.split("/");
var fromdt = new Date(fromarray[1],fromarray[0],"01");
var todt = new Date(toarray[1],toarray[0],"01");
if(Date.parse(todt) < Date.parse(fromdt)) {
//var error = getMessage("MRDATE1_GT_DATE2",'MR');
var error = getMessage('TO_DT_GR_EQ_FM_DT','SM');
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
return false;
}
else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
}
return true;
}

function ValidateDt(obj,Date1,Date2)
  {
	  /* Date2 should be less than Date1
		  type determines whether the selected type is "D"ay ,"M"onth or "Y"ear
	  */
	  var error = getMessage('MRDATE1_GT_DATE2','MR');
	  if ( Date1.value=='' ||  Date2.value=='')
	  {
		  return ;
	  }
	  else
	  {
			  var frm = 	 Date1.value;
			  var to  = 	 Date2.value;
			  var frm_arr	= frm.split("/");
			  var to_arr	    = to.split("/");
			  /*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
			  var frm_date = new Date(frm_arr[2],frm_arr[1]-1,frm_arr[0]) ;
			  var to_date = new Date(to_arr[2],to_arr[1]-1,to_arr[0]) ;
			  if (Date.parse(to_date) < Date.parse(frm_date))
			  {
			      if (Date2.name=='current_date')
				  {
					  if (Date1.name=='p_fm_Date')
						  error = error.replace('$',getLabel("Common.DateFrom.label","Common"));
					  else
					   	  error = error.replace('$',getLabel("Common.todate.label","Common")); // For p_to_Date
					  error = error.replace('#',getLabel("Common.CurrentDate.label","Common"));
					  alert(error);
					  Date1.value='';
				      Date1.focus();
				  }
				  else
				  {
					  error = error.replace('$',getLabel("Common.DateFrom.label","Common"));
					  error = error.replace('#',getLabel("Common.todate.label","Common"));
					  alert(error);
					  //Date1.select();
					  if (obj.name=='p_fm_Date')
					  {
					  		Date1.value='';
							Date1.focus();
					  }
					  else
					  {
					  		Date2.value='';
							Date2.focus();
					  }
				  }
			  }
	  }
	  return;
  }


/*function mychange()
 {
	 if (document.getElementById("report_type").value=='M')
	 {
		 if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MREXCLST";
		 }else{
		     document.forms[0].p_report_id.value="MROPCSEG";
		 }
		 document.getElementById("MY1").innerHTML="Month&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_mth' maxlength='7' size='7' onBlur='CheckDate(this)'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_mth','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
	    if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MREXCLST";
		 }else{
		     document.forms[0].p_report_id.value="MROPCSEG";
		 }
		 document.getElementById("MY1").innerHTML="Year&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='4' size='4' onBlur='CheckDate(this)'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
	    if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MREXCLST";
		 }else{
		     document.forms[0].p_report_id.value="MROPCSEG";
		 }
		 document.getElementById("MY1").innerHTML="Date&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='10'onBlur='CheckDate(this)' size='10'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("report_type").value=='M')
	 {
		   if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MREXCLST";
		 }else{
		     document.forms[0].p_report_id.value="MROPCSEG";
		 }
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_mth1' maxlength='7' size='7' onBlur='CheckDate(this)'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_mth1','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		
		  if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MREXCLST";
		 }else{
		     document.forms[0].p_report_id.value="MROPCSEG";
		 }
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='4' size='4' onBlur='CheckDate(this)'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		  if (document.getElementById("function_id").value=='excepRep')
		 {
		     document.forms[0].p_report_id.value="MREXCLST";
		 }else{
		     document.forms[0].p_report_id.value="MROPCSEG";
		 }
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='10' size='10' onBlur='CheckDate(this)'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }	*/	
 
</script>
</head>
<!-- <body  OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();mychange();"  onKeyDown = 'lockKey()'> -->
<body  OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();"  onKeyDown = 'lockKey()'>
<form name="MRBLABRG" id="MRBLABRG" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="0" cellspacing="0"  align='center'>
<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>
<!--  <tr>
	<td align='right' width='20%' class="label">Report Type&nbsp;</td>
	<td width='25%'  >
		 <SELECT name="report_type" id="report_type" onchange='mychange()'>
		 <option value="D">Daily</option>
		 <option value="M">Monthly</option>
		 <option value="Y">Yearly</option>
		 </SELECT>
	</td>
	<td>&nbsp;</td>
</tr> -->
<tr>
	<td class="label">&nbsp;</td>
	<td class="querydata"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class="querydata"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
<tr><td class="label" colspan='3'>&nbsp;</td></tr>
<tr>
		<td align='right' id='MY1'class="label"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/>&nbsp;</td>
		<td align='left' id='MY'>&nbsp;<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' onBlur='ValidateDt(this,p_fm_Date,p_to_Date);CheckDate(this)' size='10'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td align='left' id='MY3'>&nbsp;<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' onBlur='ValidateDt(this,p_fm_Date,p_to_Date);CheckDate(this)'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
</tr>
<tr>
	<td colspan=3>&nbsp;</td>
</tr>

	<td colspan=3>&nbsp;</td>
</tr>

    <%	if(function_id.equals("excepRep")){ %>
	  <tr>
			  <td align='right' width='35%' class="label">&nbsp;</td>
			  		<td >&nbsp;</td>
			  		<td >&nbsp;<td>
			  </tr>
			  <%}else{%>
	
       <%}%>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
</table>
<input type="hidden" name="p_report" id="p_report"	value="MROPCSEG">
<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<%if(function_id.equals("excepRep")){%>
  <input type="hidden" name="p_report_id" id="p_report_id" 		value="MRBLABRG">
<%}else{%>
  <input type="hidden" name="p_report_id" id="p_report_id" 		value="MRBLABRG">
<%}%>
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
 
 
</form>
</body>
</html>
<%
} catch(Exception e) { /*  out.println("in else "+e); */e.printStackTrace(); }
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

