<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"  %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    Connection con =null;
	ResultSet rs = null;
	Statement stmt = null;
	String sysdateSql ="";
	String SystemDate ="";
	String p_report_id = "";
    String p_module_id		= "MR" ; 
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	//Added by Ashwini on 08-Apr-2021 for ML-MMOH-CRF-1604
	String function_id = checkForNull(request.getParameter("function_id")) ;

	if(function_id.equals("MRAECSCT_V2003"))
	{
		p_report_id = "MRAECSCTV1" ;
	}else
	{
		p_report_id = "MRAECSCT" ;
	}

try {
     con=ConnectionManager.getConnection(request);
	 sysdateSql="select to_char(sysdate,'dd/mm/yyyy')SystemDate from dual";
	stmt = con.createStatement();
	rs	=	stmt.executeQuery(sysdateSql);
	if (rs.next() && rs != null)
	{
		SystemDate = rs.getString("SystemDate");
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
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
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
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
			var facility = '<%=p_facility_id%>';

			if (obj.name == "clinic") 
			{
				tit=getLabel("Common.emergency.label","Common")+' '+getLabel("Common.clinic.label","Common");
				sql="select clinic_code, long_desc from op_clinic where facility_id=`"+facility+"` and CARE_LOCN_TYPE_IND=`C` and LEVEL_OF_CARE_IND=`E`"; 
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

/*Added by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351*/
async function searchCodeClinicLoc(obj,target)
{  
	var facility = document.forms[0].p_facility_id.value;
	var retVal = new String();
	var dialogHeight = "80vh" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var arguments = "" ;
	var sql = "";
	var search_code = "";
	var search_desc = "";
	var tit = "";
	
	if(obj.value=="ED")
	{
		tit=getLabel("eMR.EmergencyDepartment.label","MR");

		sql="SELECT a.clinic_code, b.short_desc FROM mr_rep_op_attend_zone_catg a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facility+"` and a.service_code = `ED`";						
		
		search_code="a.clinic_code";
		search_desc= "b.short_desc";
	}
	else
	{
		tit=getLabel("Common.Observation.label","Common");
		
		sql="SELECT a.clinic_code, b.short_desc FROM mr_rep_op_attend_zone_catg a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facility+"` and a.service_code = `OB`";
						
		search_code="a.clinic_code";
		search_desc= "b.short_desc";
	}

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value = retVal;
	}
	else
		target.focus();
}
/*End ML-MMOH-CRF-1351*/

function clearList(objSelect)
{
	var length = objSelect.options.length;
	for(var index = 1 ;index < length ;index++)
	{
		objSelect.remove(1)
	}
}

function repAEAttto_change()
{
	 if (document.getElementById("report_type").value=='M')
	 {
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("report_type").value=='M')
	 {
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4'  readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10'  readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }
 			
async function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "28vh" ;
	var dialogWidth	= "43vw" ;
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
	sql="select speciality_code, short_desc from am_speciality ";
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


function ChkDateFormat(Object2) 
{
	var datefield = Object2;
	if (ChkDate1(Object2) == false) 
	{
		alert(parent.parent.parent.frames[0].getMessage('INVALID_DATE_FMT','SM'));
		datefield.select();
		datefield.focus();		
		return false;
	}else {
		return true;
	}
}
		
function ChkDate1(Object3) 
{
	var strDate;	
	var strMonth;
	var strYear;	
	var datefield = Object3;
	var strDateArray = new Array();

	strDate = datefield.value;
	if (strDate.length == 0) 
		return true; 

	strDateArray = strDate.split("/");
	if (strDateArray.length != 2)
	{
		return false;
	}	else {
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

function clinicClearRepAEAtt()
{
	document.forms[0].p_clinic_code.value = "";

	var service = document.forms[0].p_service_type.value;

	if(service == "")
	{
		document.forms[0].p_clinic_code.disabled = true;
		document.forms[0].clinic.disabled = true;
	}else
	{
		document.forms[0].p_clinic_code.disabled = false;
		document.forms[0].clinic.disabled = false;
	}
}
</script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="repAEAttto_change();<%if(!function_id.equals("MRAECSCT_V2003")){%>clinicClearRepAEAtt();<%}%>" onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repAEAtttoEmgyDeptForm" id="repAEAtttoEmgyDeptForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<input type="hidden" name="current_date" id="current_date"	value="<%=SystemDate%>">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
				<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="report_type" id="report_type" onchange='repAEAttto_change()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
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
						<td align='right' id='MY1'class="label">&nbsp;</td>
						<td align='left' id='MY' >&nbsp;</td>
						<td align='left' id='MY3' >&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='35%' class="label"> &nbsp;</td>
					<td width='25%'  ></td>
					<td>&nbsp;</td>
				</tr>
				
				<!--Added by Ashwini on 08-Apr-2021 for ML-MMOH-CRF-1604-->
				<%if(function_id.equals("MRAECSCT_V2003")){%>
				<tr>
					 <td width='30%' align='right' class='label' nowrap><fmt:message key="eMR.EmergencyClinicCode.label" bundle="${mr_labels}"/> &nbsp;&nbsp;</td>
					 <td align='left'>
						<input name='p_clinic_code' id='p_clinic_code' value='' size='5' maxlength='4' onkeypress='ChangeUpperCase(this);' onblur='ChangeUpperCase(this);'>
						<input type='button' name='clinic' id='clinic' value='?' class='button' onclick='searchCode1(this,p_clinic_code)'>
						<img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<%}else{%>
				<!--Added by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351-->
				<tr>
					<td align='right'  class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>
					<td>
					   <SELECT name='p_service_type' id='p_service_type' onchange="clinicClearRepAEAtt()"> 
						   <!--Modified by Ashwini on 29-Jul-2019 for ML-MMOH-CRF-1352-->
						   <option value='' style='align:center'> ----------- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ----------- </option>
						   <option value='ED' style='align:center'><fmt:message key="eMR.EmergencyDepartment.label" bundle="${mr_labels}"/></option>
						   <option value="OB"><fmt:message key="Common.Observation.label" bundle="${common_labels}"/></option>
						</select>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;
					</td>
					<td>
						<input type=text onkeypress='return ValidString(event)' onblur='ChangeUpperCase(this);' name='p_clinic_code' id='p_clinic_code' size="4" maxlength="4"><input type='button' name='clinic' id='clinic' value='?' class='button' onclick="searchCodeClinicLoc(p_service_type,p_clinic_code)">&nbsp;
					</td>
				</tr>
				<!--End ML-MMOH-CRF-1351-->
				<%}%>

				<tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
				</tr>
	
			<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
					<SELECT name="p_type" id="p_type" >
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
	<input type="hidden" name="function_id" id="function_id"	value="<%= function_id %>">

</form>
</BODY>
</HTML>
	<%
} catch(Exception e) {  /* out.println("in else "+e); */ e.printStackTrace();}
finally
{
	if(con != null)ConnectionManager.returnConnection(con,request);
	 if(rs!= null) rs.close();
	 if(stmt!=null) stmt.close();
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

