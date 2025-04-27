<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>  

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>
<%
try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String locale=(String)session.getAttribute("LOCALE");
String clinic_code=request.getParameter("clinic_code");
String srl_no=request.getParameter("srl_no");
String clinic_desc=request.getParameter("clinic_desc");
String pract_id=request.getParameter("pract_id");
if(pract_id.equals("XXABCXXDEFXXGHIXX"))pract_id ="";
if(pract_id==null) pract_id ="";
pract_id = pract_id.trim();
String pract_name=request.getParameter("pract_name");
if(pract_name.equals("XXABCXXDEFXXGHIXXJKLXXMNOXXPQRXXX"))pract_name ="";
if(pract_name==null) pract_name ="";
String day=request.getParameter("day");
String from_time=request.getParameter("from_time");
String to_time=request.getParameter("to_time");
String type_desc=request.getParameter("type_desc");
String date=request.getParameter("date");
String date_disp=DateUtils.convertDate(date,"DMY","en",locale);
String alcncriteria = request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
String first_visits_blocked = request.getParameter("first_visits_blocked")==null?"0":request.getParameter("first_visits_blocked");
String other_visits_blocked = request.getParameter("other_visits_blocked")==null?"0":request.getParameter("other_visits_blocked");
String resource_class = request.getParameter("resourceclass");
String locn_type = request.getParameter("locntype");
String resource1 =request.getParameter("resource1");
String locntype1 = request.getParameter("locntype1");
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eOA/js/Blockapptslots.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='delete_appt_form' id='delete_appt_form'  action='../../servlet/eOA.BlockAppointmentServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' id='main'>
		<tr><td colspan='4'>&nbsp;</td></tr>
		<tr>
		<td  class='label' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

		<td class='fields' nowrap><input type='text' size=15 value='<%=locn_type%>' readonly></td>

		<td  class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

		<td class='fields' nowrap><input type='text' size=15 value='<%=clinic_desc%>' readonly></td>
		</tr>
		
		<tr><td colspan='4'>&nbsp;</td></tr>

		<tr>
		<td class='label'nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>

		<td class='fields' nowrap><input type='text' size=10 value='<%=resource_class%>' readonly></td>
		
		<td class='label' nowrap><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
			 
		<td class='fields' nowrap><input type ='text' maxlength = 30 size = 30 value='<%=pract_name%>' readonly>
		</tr>

		<tr><td colspan='4'>&nbsp;</td></tr>

		<tr>
		<td class='label' nowrap><fmt:message key="eOA.BlockDate.label" bundle="${oa_labels}"/></td>

		<td align="left" width="15%" nowrap><input type='text' size=10 maxsize=10  value='<%=date_disp%>' readonly></td>
		
		<td  class='label' nowrap><fmt:message key="eOA.BlockTime.label" bundle="${oa_labels}"/></td>

		<td class='fields' nowrap><input type='text' size=5 maxsize=5   value='<%=from_time%>' readonly> - <input type='text' size=5 maxsize=5  value='<%=to_time%>' readonly></td>
		</tr>

		<tr><td colspan='4'>&nbsp;</td></tr>

		</table>

<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>' >
<input type='hidden' name='srl_no' id='srl_no' value='<%=srl_no%>' >
<input type='hidden' name='clinic_desc' id='clinic_desc' value='<%=clinic_desc%>' >
<input type='hidden' name='pract_id' id='pract_id' value="<%=pract_id%>" >
<input type='hidden' name='pract_name' id='pract_name' value='<%=pract_name%>' >
<input type='hidden' name='day' id='day' value='<%=day%>' >
<input type='hidden' name='from_time' id='from_time' value='<%=from_time%>' >
<input type='hidden' name='to_time' id='to_time' value='<%=to_time%>' >
<input type='hidden' name='type_desc' id='type_desc' value='<%=type_desc%>' >
<input type='hidden' name='date' id='date' value='<%=date_disp%>' >
<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcncriteria%>' >
<input type='hidden' name='first_visits_blocked' id='first_visits_blocked' value='<%=first_visits_blocked%>' >
<input type='hidden' name='other_visits_blocked' id='other_visits_blocked' value='<%=other_visits_blocked%>' >
<input type='hidden' name='function' id='function' value='delete'>
<input type='hidden' name='function_name' id='function_name' value='delete'>
<input type='hidden' name='resourceType' id='resourceType' value='<%=resource1%>'>
<input type='hidden' name='location1' id='location1' value='<%=locntype1%>'>

<%} catch(Exception e){
	e.printStackTrace();
}%>
</form>
</body>
</html>

