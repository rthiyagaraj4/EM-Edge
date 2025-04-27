<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="com.ehis.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String locale			= (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String param			= request.getParameter("param");
		if(param == null) param="";
	String wherecondn		= request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn="";
	String call_function    = request.getParameter("call_function");
		if((call_function == null) || (call_function.equals(""))) call_function="";
	String facilityID		= (String)session.getAttribute("facility_id");

	ArrayList bookingtype_list		   = new ArrayList();
	Connection con			=  null;
	Statement stmt			= null;
	ResultSet rs			= null;
	String patient_id_length= "";
	try
	{
		String sql			= "select NVL(patient_id_length,0) patient_id_length from mp_param";
		con					=  ConnectionManager.getConnection(request);
		stmt				=   con.createStatement();
		rs					= stmt.executeQuery(sql);
		if (rs != null)
		{
			while(rs.next())
			{
				patient_id_length	= rs.getString(1);
			}
		}

	}
	catch(Exception ex)
	{
		
		ex.printStackTrace();
	}
	finally
	{
		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
		<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<script>

function popDynamicValues(Obj){}

function DisReset()
{
	var param = document.forms[0].param.value;
	if( param != 'ADMIT')
	{ 
	<% 
		if (call_function != null && call_function.equals("RCB"))
		{	
	%>
		parent.parent.frames[0].document.getElementById("reset").disabled=true; 
	<%
		}
	%>
	}
}

function clearAll()
{
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html'; 
	parent.frames[3].document.location.href = '../../eCommon/jsp/error.jsp';
	document.forms[0].search.disabled=false;
}			
function assignValue(obj)
{
	if(obj.checked == true)
		obj.value = "th";
	else
		obj.value = "en";
			
}
async function showLookUp(val)
{
   if(val == 'P')
   {
	var patientid= await PatientSearch('','','','','','','Y','','','OTHER');
	if(patientid != null)
		document.getElementById("patient_id").value = patientid;
	else
		document.getElementById("patient_id").value = "";
    }
 }
</script>

</head>

<body onLoad= 'DisReset()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='BookingReferenceLookup_Form' id='BookingReferenceLookup_Form' action='../jsp/BookingReferenceLookupResult.jsp' target='result' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>

			<tr>
				<td  class='label'  width='25%' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td><td  class='fields' align='left' width='25%'><input type=text name=nursing_unit_desc size=15 onblur='beforeGetNursingUnit("<%=facilityID%>")'><input type=hidden class=label name=nursing_unit size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick='getNursingUnit("<%=facilityID%>")'><input type='hidden' name='nurs_desc_hid' id='nurs_desc_hid' ></td>

				<td class='label'   width='25%'><fmt:message key="Common.PreferredDateFrom.label" bundle="${common_labels}"/></td>
				<td class='fields'  align='left' width='25%'><input type='text' id="date_from" maxlength='10' size='10' name='from_date' id='from_date'  value='' onBlur='DateCompare_nshwCancel(this,to_date,parent.frames[3]);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');">&nbsp;-&nbsp;<input type='text' value='' maxlength='10' size='10' name='to_date' id='to_date' onBlur='DateCompare_nshwCancel(from_date,this,parent.frames[3]);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="to_date.focus();return showCalendar('to_date');"></td>
				
				
				
			</tr>
			<tr>
				<td  class='label'  width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/><input type='hidden' name='param' id='param' value='<%=param%>'> </td><td class='fields' align='left' width='25%'  ><input type=text name=specialty_desc size=15 onblur='beforeGetSpecialty(specialty_desc,"<%=facilityID%>")'><input type=hidden class=label name=Splcode size=15 ><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick='getSpecialty(specialty_desc,"<%=facilityID%>")'></td>
				<input type=hidden name="spec_desc_hid" id="spec_desc_hid" >

				<td class='label'  width='25%' ><fmt:message key="Common.BookingStatus.label" bundle="${common_labels}"/></td>
				<td class='fields' align='left' width='25%'><select name="booking_stat" id="booking_stat" ><option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option><option value="3"><fmt:message key="Common.noshow.label" bundle="${common_labels}"/></option><option value="9"><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option></select><td>

			</tr>
			<tr>
				<td  class='label' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td><td class='fields'  align='left' width='25%'><input type=text name="pract_desc" id="pract_desc" size=27 onblur='beforeGetPractitioner(practitioner_lookup,pract_desc,"<%=facilityID%>")'><input type=hidden class=label name=practid size=15 ><input type=button class=button name='practitioner_lookup' id='practitioner_lookup' value='?'onClick='getPractitionerLocal(this,pract_desc,"<%=facilityID%>")'></td>
				<input type=hidden name="pract_desc_hid" id="pract_desc_hid" >

				<!--/*modification for SRR20056-CRF-0506*/-->
		<%
		try
		{

			con  =  ConnectionManager.getConnection(request);
			stmt	=   con.createStatement();	
			StringBuffer sqlmedserv = new StringBuffer();
			if(sqlmedserv.length() > 0) sqlmedserv.delete(0,sqlmedserv.length());
			sqlmedserv.append(" select booking_type_code,ip_get_desc.ip_booking_type(booking_type_code,'"+locale+"','2')short_desc from ip_booking_type where eff_status = 'E' order by 2 ");
			rs = stmt.executeQuery(sqlmedserv.toString());

			while( rs.next() )
			{
				bookingtype_list.add(checkForNull(rs.getString(1)));
				bookingtype_list.add(checkForNull(rs.getString(2)));
				
			}

			if(rs	 != null)   rs.close();
			if(stmt	 != null)   stmt.close();
		}
		 catch(Exception e){//out.println(e);
		 e.printStackTrace();}
		 finally
		 {
			if(con!=null) ConnectionManager.returnConnection(con,request);
		 }%>
			
				<td  class='label'  width='25%'  ><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></td>
				<td  class='fileds' width='25%' ><SELECT name="ip_booking_type" id="ip_booking_type" >
				<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
				<%
					for(int i=0;i<bookingtype_list.size();i+=2){
				%>
				<option value=<%=bookingtype_list.get(i)%>><%=bookingtype_list.get(i+1)%></option>
				<%}%>	     
				</SELECT>
				</td>

				<!--/*modification for SRR20056-CRF-0506*/-->
			</tr>
		<!--/table>
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1'>
		
		<tr>
			<td  colspan='4' class='label'-->
				<tr>

					<td class='label'  width = '25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width='25%' class='fields' ><input type='text' maxlength='<%=patient_id_length%>' size='20' name='patient_id' id='patient_id' size='<%=patient_id_length%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
					<td class='label' width ='25%' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td  class='fields' width ='25%' ><select name='gender' id='gender'>
					<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
					</td>
                </tr> 
				<tr>
					<td class='label' width ='25%'>&nbsp;</td>
					<td class='label' width ='25%'>&nbsp;</td>
					<td class='label' width ='25%'><fmt:message key="eMP.SearchNameWithLocalLang.label" bundle="${mp_labels}"/></td>
					<td class='fields' width ='25%' ><input type='checkbox' name='loc_lang' id='loc_lang' value='th' 
					id="myCheckBox1" checked onclick='assignValue(this)'></td>
				</tr>
				</table>
				<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>

				<jsp:include page="IPPatientDetailCriteria.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="function_id"   value= "NO_SHOW" />
				</jsp:include>
				</table>
			<!--/td>
		</tr-->
		
		

		<table align='right'>
			<tr>
				<td align='right' class='white'>
				<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage_nshwCancel()'>
				<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'></td>
			</tr>
		</table>
	  <br><br>
	  <INPUT TYPE="hidden" name="call_function" id="call_function" value="<%=call_function%>">
	   <INPUT TYPE="hidden" name="locale" id="locale" value="<%=locale%>">
	  <INPUT TYPE="hidden" name="booking_type" id="booking_type" value="">
	  <INPUT TYPE="hidden" name="daycare_unit" id="daycare_unit" value="">
	</form>
  </body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

