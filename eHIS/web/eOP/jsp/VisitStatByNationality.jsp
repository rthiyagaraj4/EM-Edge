<!DOCTYPE html>
<%--
Filename		: VisitStatByNationality.jsp
Modified On		: 14-03-2008
Version			: 3
--%>

<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale=(String)session.getAttribute("LOCALE");
	StringBuffer NationalityVal	=new StringBuffer();
	NationalityVal.setLength(0);
%>
<html>
<HEAD>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link> 

<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eOP/js/repOPVisitStatsByPatientNationality.js" language="javascript"></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()"onload = 'FocusFirstElement()' onKeyDown ='lockKey()'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br>
<%//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
    Connection con  =null; 
    String isSpltyNurUnitToEnableYNAppl="";
	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);
    }
	 catch(Exception e){out.println(e);}
	 finally
	 {		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

%>
<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>

<table cellpadding='2' border = '0' cellspacing='0' width='80%'>

<tr>
<td width='33%'>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  name='p_fr_visit_date' id='p_fr_visit_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_fr_visit_date.select();return showCalendar('p_fr_visit_date');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
	<td class='fields'><input type=text  name='p_to_visit_date' id='p_to_visit_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_visit_date.select();return showCalendar('p_to_visit_date');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fr_clinic_code" id="p_fr_clinic_code" size="4" maxlength="4" onBlur='searchCode(fromclinic,this)'><input type='button' name='fromclinic' id='fromclinic' value='?' class='button' onclick='searchCode(this, p_fr_clinic_code)'>
	</td>

	<td class='fields'>
	    <input type="text" name="p_to_clinic_code" id="p_to_clinic_code" size="4" maxlength="4" onBlur='searchCode(toclinic,this)'><input type='button' name='toclinic' id='toclinic' value='?' class='button' onclick='searchCode(this, p_to_clinic_code)'>
	</td>
</tr>
<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fr_splty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_splty_code"/>
					</jsp:include>
					</tr>
<%}else{%>
<tr>
	<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fr_splty_code" id="p_fr_splty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fr_splty_code)'>
	</td>
	<td class='fields'>
	    <input type="text" name="p_to_splty_code" id="p_to_splty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_splty_code)'>
	</td>
</tr><%}%>
<tr>
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>	
	<td class='fields'><input type="text" name="p_fr_pract_code" id="p_fr_pract_code" size="15" maxlength="15" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this,p_fr_pract_code)'>
	</td>	
	<td class='fields'>
	<input type="text" name="p_to_pract_code" id="p_to_pract_code" size="15" maxlength="15" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this,p_to_pract_code)'>
	</td>
</tr>	
</table>

<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
		<input type="hidden" name="p_facility" id="p_facility"  		value="<%=p_facility_id %>">
		
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPBVSTPN">
		<input type="hidden" name="p_user_name" id="p_user_name"		    value="<%=p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>"></input>
		<input type="hidden" name="locale" id="locale"				value="<%=locale%>">

		<!--
		<input type="hidden" name="p_clinic_from" id="p_clinic_from"		value="">
		<input type="hidden" name="p_clinic_to" id="p_clinic_to" 		value="">
		
		<input type="hidden" name="p_pract_from" id="p_pract_from" 		value="">
		<input type="hidden" name="p_pract_to" id="p_pract_to"		    value="">
		
		<input type="hidden" name="p_incl_no_show" id="p_incl_no_show" 		value="">
		<input type="hidden" name="p_visit_status" id="p_visit_status"		value="">
		
		<input type="hidden" name="p_date_from" id="p_date_from"		    value="">
		<input type="hidden" name="p_date_to" id="p_date_to" 		    value="">
		-->

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>
<%
	NationalityVal.setLength(0);
%>
</form>
</body>
</center>
</html>

