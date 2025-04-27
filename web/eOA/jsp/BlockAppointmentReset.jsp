<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>

<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String date=(String)request.getParameter("Date");

String clinic_code=(String)request.getParameter("clinic_code");
String practitioner_id=(String)request.getParameter("practitioner_id");
String clinic_type=(String)request.getParameter("clinic_type");
if(clinic_type==null) clinic_type="";
String res_type=(String)request.getParameter("res_type");
if(res_type==null) res_type="";
String value12=(String)request.getParameter("value12");
if( value12 == null || value12.equals("null")) value12="";
String value13=(String)request.getParameter("value13");
if( value13 == null || value13.equals("null"))  value12=""; 
String anchor=(String)request.getParameter("anchor");
if( anchor == null || anchor.equals("null"))  anchor=""; 

String to_anchor=(String)request.getParameter("to_anchor");
if( to_anchor == null || to_anchor.equals("null"))  to_anchor=""; 

String rowNum=(String)request.getParameter("rowNum");
if( rowNum == null || rowNum.equals("null")) rowNum="0"; 
%>

<html>
<head>
<script src='../../eOA/js/Blockapptslots.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

</script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='rbutton' id='rbutton'>
<table border="0" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
	<td width='95%' class='bodycolorfilled'>&nbsp;</td>
	<td align='right' width='50%'>
		<input type='button' class='button' name='reset' id='reset' value='<fmt:message key="eOA.ResetBlockTime.label" bundle="${oa_labels}"/>' onClick='clearFields()'>
	</td>
	</tr>
</table>

<input type='hidden' name='r_appt_status' id='r_appt_status' value='null' >
<input type='hidden' name='clinic_code' id='clinic_code' value=<%= clinic_code %> >
<input type='hidden' name='pract_id' id='pract_id' value=<%=practitioner_id %> >
<input type='hidden' name='appt_date' id='appt_date' value=<%=date %> >
<input type='hidden' name='patient_id' id='patient_id' value='null'>
<input type='hidden' name='clinic_type' id='clinic_type' value=<%=clinic_type%> >
<input type='hidden' name='res_type' id='res_type' value=<%=res_type%> >


</form>
</body>
</html>

