<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>
<%	
	request.setCharacterEncoding("UTF-8");
	String called_from	= checkForNull(request.getParameter("called_from"));
	String chck_val		= checkForNull(request.getParameter("chck_val"));
	String pol_rep_no	= checkForNull(request.getParameter("pol_rep_no"));
	String pol_stn_id	= checkForNull(request.getParameter("pol_stn_id"));
	String pol_id		= checkForNull(request.getParameter("pol_id"));
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</script>

<script>

function enablePolice(obj)
{
	if(document.forms[0].medico_legal.checked==true)
	{
		document.forms[0].pol_rep_no.disabled=false;
		document.forms[0].pol_stn_id.disabled=false;
		document.forms[0].pol_id.disabled=false;
	}
	else
	{
		document.forms[0].pol_rep_no.value='';
		document.forms[0].pol_rep_no.disabled=true;
		document.forms[0].pol_stn_id.value='';
		document.forms[0].pol_stn_id.disabled=true;
		document.forms[0].pol_id.value='';
		document.forms[0].pol_id.disabled=true;
	}
}
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>

<table border='0' cellpadding='0' cellspacing='0' width='100%' >

<%	
if(!(called_from.equals("amend_leave") || called_from.equals("record_leave")))
{		
%>
<th colspan='6' align='left'><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></th>
<tr>
<td class='label' <%if(called_from.equals("discharge_patient")){%> width='25%'<%}else{%>  width='25%' <%}%>>&nbsp;<fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
<td  class='QUERYDATA' width='30%'><INPUT TYPE="checkbox" name="medico_legal" id="medico_legal" value="Y" <%=chck_val%>  onClick="getMedicoValues(this);enablePolice(this);" onBlur='focusNext();'><input type='hidden' name='dischgsumsigned' id='dischgsumsigned' value= "N" ></td>
<td width='20%'> </td>
		<td width='25%'> </td>
</tr>
<%	
} 
%>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%' >
	<tr height=1>
		<td width='25%'> </td>
		<td width='30%'> </td>
		<td width='20%'> </td>
		<td width='25%'> </td>
</tr>
<tr>
	<td <%if(called_from.equals("discharge_patient")){%> width=''<%}else{%>  width='' <%}%> class='label' ><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
	<td class='QUERYDATA' width='' colspan='3'><INPUT TYPE='text' name='pol_rep_no' id='pol_rep_no' value= "<%=pol_rep_no%>" size='20' maxlength='30'>
	</td>
</tr>
<tr>
	<td height=6 colspan=4></td>
</tr>
<tr>
	<td class='label' <%if(called_from.equals("discharge_patient")){%> width=''<%}else{%>  width='' <%}%>><fmt:message key="Common.station.label" bundle="${common_labels}"/></td>
	<td class='QUERYDATA' width=''><INPUT TYPE='text' name='pol_stn_id' id='pol_stn_id' value="<%=pol_stn_id%>" size='20' maxlength='30'>
	</td>
	<td class='label' <%if(called_from.equals("discharge_patient")){%> width='5%'<%}else{%>  width='10%' <%}%>><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class='QUERYDATA'><INPUT TYPE='text' name='pol_id' id='pol_id' onblur="focusNext()" value="<%=pol_id%>" size='20' maxlength='30'>
	</td>
</tr>

</table>
</BODY>
<script>
<%
if( called_from.equals("discharge_patient") )
{
%>
	document.forms[0].pol_rep_no.disabled=true;
	document.forms[0].pol_stn_id.disabled=true;
	document.forms[0].pol_id.disabled=true;
<%}%>
</script>
</HTML>
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

