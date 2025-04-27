<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	//Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
	  String resp_id     = (String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	 String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../js/MRReports.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>

</script>


</head>
<%
  Connection con =null;
  ResultSet rs   = null;
  Statement stmt = null;
%>
<%
		
     String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
     String CurrentDate=" ";
	 String auth_level = "";
	try{
		 con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next()){
			CurrentDate= rs.getString(1);
		}

		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();


		stmt=con.createStatement();
		rs = stmt.executeQuery("SELECT AUTH_AT_STAGE FROM mr_parameter");	
		while (rs.next()){
			auth_level= rs.getString(1);
		}
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();

		

	
%>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="Diag_proc" id="Diag_proc" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='70%' cellpadding="3" cellspacing="0"  align='center'>


	<tr>
		<td class='label' width="30%">&nbsp;</td>
		<td class="querydata" width="35%">&nbsp;</td>
		<td class="querydata" width="35%">&nbsp;</td>
	</tr>
	<tr>
		<td class='label' width="30%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="35%"><select name='p_location_type' id='p_location_type' onchange='resetParameter(p_location_type)'>
		<option value="">--------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------------
				<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
				<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
				<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
				<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
				</select></td>
		<td class="querydata" width="35%"></td>
	</tr>
	
<tr>
		<td class='label' width="30%">&nbsp;</td>
		<td class="querydata" width="35%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="35%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	
	<tr>
		<td class="label"><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		 <input type='text' name='from_speciality' id='from_speciality' size='15'  maxLength='10' OnBlur="beforeSerachSpeciality(this,from_speciality,p_fr_specialty_code,from_location,p_fr_location_code)"><input type='button' name='spec' id='spec' value='?' class='button' onclick="searchSpecialty(this,from_speciality,p_fr_specialty_code,from_location)" >
		<input type="hidden" name="p_fr_specialty_code" id="p_fr_specialty_code"  value=""> 

		
		</td>
		
		<td class='fields'><input type='text'  name='to_speciality' id='to_speciality' size='15'  maxLength='10' OnBlur="beforeSerachSpeciality(this,to_speciality,p_to_specialty_code,to_location,p_to_location_code)"><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchSpecialty(this,to_speciality,p_to_specialty_code,to_location)'  >
		<input type="hidden" name="p_to_specialty_code" id="p_to_specialty_code"  value=""> 
		
      		    
		
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='text' name='from_location' id='from_location' onBlur="beforeGetLoc('<%=user_id%>','<%=facility_id%>',p_fr_specialty_code,p_fr_location_code,from_location)" size='15'><input type='button' name='spec' id='spec' value='?' class='button' onclick="getLocn('<%=user_id%>','<%=facility_id%>',p_fr_specialty_code,p_fr_location_code,from_location)"  >
		<input type="hidden" name="p_fr_location_code" id="p_fr_location_code"  value="">
		</td>
		
		<td class='fields'><input type='text'  name='to_location' id='to_location' size='15'  onBlur="beforeGetLoc('<%=user_id%>','<%=facility_id%>',p_to_specialty_code,p_to_location_code,to_location)"><input type='button' name='spec' id='spec' value='?' class='button' onclick="getLocn('<%=user_id%>','<%=facility_id%>',p_to_specialty_code,p_to_location_code,to_location)"  >
		<input type="hidden" name="p_to_location_code" id="p_to_location_code"  value="">
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='text'  name='from_service' id='from_service' size='15'  maxLength='10' onBlur='beforeSearchServices(this,from_service,p_fr_service_code)'><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchServices(this,from_service,p_fr_service_code)'  ><input type="hidden" name="p_fr_service_code" id="p_fr_service_code" value="">
		</td>
		
		<td class='fields'><input type='text' name='to_service' id='to_service' size='15'  maxLength='10' onBlur='beforeSearchServices(this,to_service,p_to_service_code)'><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchServices(this,to_service,p_to_service_code)'  >
		<input type="hidden" name="p_to_service_code" id="p_to_service_code"  value="">
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></td>
		<td>
		<input type='text' name='p_fr_adm_date' id='p_fr_adm_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateDmissionDate_From(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_adm_date');"/></td>
		<td class='fields'><input type='text' name='p_to_adm_date' id='p_to_adm_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateDmissionDate_To(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_adm_date');"/>
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></td>
		<td>
		<input type='text' name='p_fr_dis_date' id='p_fr_dis_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateDischarge_From(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_dis_date');"/></td>
		<td class='fields'><input type='text' name='p_to_dis_date' id='p_to_dis_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateDischarge_To(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_dis_date');"/>
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></td>
		<td>
		
		<input type='text' name='p_fr_period_date' id='p_fr_period_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validatePeriod_From(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_period_date');"></td>
		<td class='fields'><input type='text' name='p_to_period_date' id='p_to_period_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validatePeriod_To(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_period_date');">
		</td>
	</tr>

	<tr>
			<td class=label><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="p_level_status" id="p_level_status">  
			<%
				if(auth_level.equals("1"))
				{%>
					<option value="ALL"  ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="1"  >1</option>
					<option value="2" >2</option>
					<option value="3" >3</option>

				<%}
				else if(auth_level.equals("2"))
				{%>
					<option value="ALL"  ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="2" >2</option>
					<option value="3" >3</option>

				<%}
				else if(auth_level.equals("3"))
				{%>
					<option value="3" >3</option>
				<%}%>
			<!-- <option value="1"  >1</option>
			<option value="2" >2</option>
			<option value="3" >3</option> -->
				</select>
			</td>
			<td class=label></td>
	</tr>
<%
	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}

	%>
	
<input type='hidden' name='language' id='language' value='<%=localeName%>'>
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"	  value="MR">
	<input type="hidden" name="p_report_id" id="p_report_id"   value="MRNRCDGPR">
	<input type="hidden" name="p_user_name" id="p_user_name"	  value="<%=p_user_name%>">
	<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"	  value="<%=resp_id%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"	 value="<%= CurrentDate %>">


	</table>
	</form>
	</body>

