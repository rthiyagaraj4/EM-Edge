<!DOCTYPE html>
<html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" 
			contentType="text/html; charset=UTF-8" %>

<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
response.setContentType("text/html");
String Facility_Id = (String) session.getValue("facility_id");
String sql4 = "";
String pid_length="";
String locale=(String)session.getAttribute("LOCALE");
%>

<%

Connection conn1 = null;
Statement stmt4=null;
ResultSet rset4=null;

try{
		conn1 = ConnectionManager.getConnection(request);
	    stmt4 = conn1.createStatement();
	    sql4 = "select patient_id_length from mp_param";
		rset4 = stmt4.executeQuery(sql4);
		if(rset4 != null){
		if(rset4.next())
			  pid_length = rset4.getString(1);
          
		}
		if(pid_length==null || pid_length.equals(""))
			pid_length = "20";
        if(rset4 != null) rset4.close();
		if(stmt4 != null) stmt4.close();
       
%>


<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src='../js/QueryPatientVisits.js'></script>
<script language="javascript" src="../js/OPPractitionerComponent.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='query_criteria_form' id='query_criteria_form'>
    <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
    <tr>
        <td class='LABEL' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
        <td class='fields'  width='25%'><input type='text' name='txtpatid' id='txtpatid' size='20' onKeyPress="return CheckForSpecChars(event)" onBlur='changeCase(this)' maxlength='<%=pid_length%>'><input type='button' class='button'  name='butpat' id='butpat' value='?'  onclick='patqry()'></td>
		<td colspan='2'>&nbsp;</td>
	</tr>
	<tr>
        <td class='LABEL'><fmt:message key="eOP.MRN.label" bundle="${op_labels}"/></td>
        <td class='fields'><input type='text' name='txtmrn' id='txtmrn' size='15' maxlength='15'></td>
        <td class='LABEL' width='25%'><fmt:message key="eOP.OpenEpisodes.label" bundle="${op_labels}"/></td>
        <td class='fields' width='25%'><input type='checkbox' name='openEpisode' id='openEpisode' value='N'></td>
    </tr>
    <tr>
        <td class='LABEL'><fmt:message key="Common.VisitDateFrom.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text'  name='txtdtfrm' id='txtdtfrm' size='10' maxlength='10' onblur='validDateObj(this,"DMY",localeName);'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('txtdtfrm');" style="cursor='hand'"></img></td>

        <td class='LABEL'> <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text'  name='txtdtto' id='txtdtto' size='10' maxlength='10' onblur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('txtdtto');" style="cursor='hand'"></img></td>
    </tr>
    <tr>
        <td class='LABEL'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text' name='opservice_desc' id='opservice_desc' size=15' maxlength='15' onBlur="getValues(service_button,this,opservice)"><input type='hidden' name='opservice' id='opservice' value=''><input type='button' class='button' readOnly name='service_button' id='service_button' value='?' onClick="getValues(this,opservice_desc,opservice)";></td>
		
		<td class="LABEL"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" name ="speciality_desc" maxlength="15" size="15" onBlur="getValues(speciality_button,this,speciality_code)"><input type='button' class='button'  name='speciality_button' id='speciality_button' value='?' onclick="getValues(this,speciality_desc,speciality_code)"><input type='hidden' name='speciality_code' id='speciality_code' value=''></td>

	</tr>
    <tr>     
	<td class='LABEL'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields'> <input type='text' name='oplocation_desc' id='oplocation_desc' size=15' maxlength='15' onBlur="getValues(locn_button,this,oplocation)"><input type='hidden' name='oplocation' id='oplocation' value=''><input type='button' class='button' readOnly name='locn_button' id='locn_button' value='?' onClick="getValues(this,oplocation_desc,oplocation)";> </td>
        <td class='LABEL'> <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text' name='oppract_desc' id='oppract_desc' size=30' maxlength='30' onBlur="getValues(pract_button,this,oppract)"><input type='hidden' name='oppract' id='oppract' value=''><input type='button' class='button' readOnly name='pract_button' id='pract_button' value='?' onClick="getValues(this,oppract_desc,oppract)";></td>
    </tr>

	<tr>
	<td class='LABEL'><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></td>
	<td class='field' width="25%"><input type='text' name='created_by' id='created_by' onKeyPress="return(CheckForSpecChars(event))"  value="" size='20' maxlength='30' onBlur='GetCancellLookupBlur(this);'><input type='hidden' name='user' id='user' size='40' maxlength='30' value='' readonly><input type='button' class='BUTTON' value="?"  name='cancel_search' id='cancel_search'onclick='GetCancellLookup(created_by)' ></td>
	<td class='LABEL'><fmt:message key="eMR.EpisodeNo.label" bundle="${mr_labels}"/></td>
	<td class='fields'><input type='text' name='episode_no' id='episode_no' size='15' maxlength='15'></td>
	</tr>
        <tr>
			<td colspan='3'>&nbsp;</td>
            <td class='fields'><input type="button" class='Button' name="search_button" id="search_button" title='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="chkfld();"><input type="button" class='Button' name="clear_button" id="clear_button" title='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearqry()"></td>
        </tr>
    </table>

	<input type='hidden' name='facility_id' id='facility_id' value='<%=Facility_Id%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	
</form>
</body>
</html>
<%
}
catch(Exception e){out.println("Excep1:"+e);}
finally
{
	try{
	if(stmt4!=null) stmt4.close();
	if(rset4!=null)rset4.close();
	}catch(Exception e){}
   if(conn1!=null) ConnectionManager.returnConnection(conn1,request);
}
%>

