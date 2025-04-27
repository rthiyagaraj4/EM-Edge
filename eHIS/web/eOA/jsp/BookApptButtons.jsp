<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper "%>
 <html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOA/js/BookAppointment.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
 <% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

		 String fromPage=request.getParameter("fromPage")==null?"":request.getParameter("fromPage");
		 String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");
		
		 
		// if (!fromPage.equals("BookAppointment"){
	    /*Above line commented and  below line added for this CRF  Bru-HIMS-CRF-191 [IN:030391]*/		
		if (!fromPage.equals("BookAppointment") && !fromPage.equals("GroupAppoinment"))
		{ 
			 %>

			<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
			<form name="recur_day_results" id="recur_day_results" method="post">
			<table cellpadding=0 cellspacing=0 width="100%">
			<tr><td class="OAQRYODD" align=middle><input type="button" value="OK" class=button onclick="parent.frames[1].validate1()">
			<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="parent.frames[1].ret_none1()">
			</td></tr>
			</table>
			</form>
			</body>
			</html>
	<%}else if(fromPage.equals("GroupAppoinment")){ /*this else if condtion added for this CRF  Bru-HIMS-CRF-191 [IN:030391]*/%>
	
	 	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
			<form name="appt_group_result" id="appt_group_result" method="post">
			<table cellpadding=0 cellspacing=0 width="100%">
			<tr><td  align=right><input type='button' name='GroupAppt' id='GroupAppt' value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/> <fmt:message key="Common.booking.label" bundle="${common_labels}"/>' onClick='ConfrimGrpAppt()' class="BUTTON" >
			<input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onClick='parent.frames[0].exitval()' >
			</td></tr>
			</table>
			</form>
			</body>
			</html>
	
	<% //End this CRF  Bru-HIMS-CRF-191 [IN:030391]
		}else{
		
		//String patientid=request.getParameter("patientid")==null?"":request.getParameter("patientid");
		//String contact_num_reqd_yn=request.getParameter("contact_num_reqd_yn")==null?"N":request.getParameter("contact_num_reqd_yn");
		

	%>
<body onKeyDown = 'lockKey()'>
<form name="BookApptBottom" id="BookApptBottom" method='post'>
<table border='0' cellpadding='0' cellspacing='0' width='100%' >
					<tr>
					<td   align='left' colspan=6 width="100%"> 	
					<input type='button' name='previous_encounter' id='previous_encounter' value='<fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/>'  class="BUTTON" onClick='parent.frames[0].past_visits_view()' disabled>
					<input  type = 'button' id='other_id1' name='other_id1' value = '<fmt:message key="eOA.OtherAppointments.label" bundle="${oa_labels}"/>' onclick = 'parent.frames[0].show_window("Two")'  class="BUTTON" ></input>
					<input type = 'hidden' id='OtherAppts' name='OtherAppts' id='OtherAppts' value = 'Other Appts' onclick = 'parent.frames[0].show_window("Two")'  class="BUTTON" ></input>
					<Input type='button' id='no_show_appt' value = '<fmt:message key="eOA.NoShowappt.label" bundle="${oa_labels}"/>' class="BUTTON"  style="visibility:hidden" onclick = 'parent.frames[0].show_noshow_appts()'  class="BUTTON">
					<input type='button' id='recurring' value='<fmt:message key="eOA.RecurringDays.label" bundle="${oa_labels}"/>' class="BUTTON" style="visibility:hidden" onClick='parent.frames[0].open_date_select()'>
					<%if(!from_page.equals("modifyappt")){%>
					<input type='button' id='ffgh' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class="BUTTON" onClick='parent.frames[0].clearAll1()'>
					<%}%>
					<input type='button' name='Insupd' id='Insupd' value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/> <fmt:message key="Common.booking.label" bundle="${common_labels}"/>' onClick='callFuncs();' class="BUTTON" >
					<input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onClick='parent.frames[0].exitval()' >
			</td>
			</TR>
   			</table>

	</form>
	</body>


<%}//end of else%>

