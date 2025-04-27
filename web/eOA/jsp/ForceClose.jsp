<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eOA/js/ForceClose.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%		
try
{
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");		
	String locale=(String)session.getAttribute("LOCALE");	 
	String prd="";
	String patient_id_length="";
	patient_id_length = request.getParameter("patient_id_length");	
	prd = request.getParameter("prd");
	int pat_id_len = 0;
	if(!patient_id_length.equals(""))
		 pat_id_len = Integer.parseInt(patient_id_length);
	
	%>
	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name="frsclose" id="frsclose" target="messageFrame" action="../jsp/ServerSideValidation.jsp">
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		 
			<br><br><br><br><br>
			<center>
			<table cellpadding=0 cellspacing=0 border=0 width='60%'>
			<tr>

			<td colspan=4 class='fields' >&nbsp;&nbsp;<fmt:message key="eOA.WaitinglistThatAreLapsedAnd.label" bundle="${oa_labels}"/> <b><%=prd%> </b><fmt:message key="eOA.DaysOldWillBeClosed.label" bundle="${oa_labels}"/></td>
			</tr>
			<tr><td colspan=4>&nbsp;</td></tr>
			<tr>
				<td class=label nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>

				<td class='fields' ><input type=text name='patientid' id='patientid' size='<%=pat_id_len%>'  maxlength='<%=pat_id_len%>' value='' onblur='changeCase(this);' tabindex=6><input type=button name='commonLookup' id='commonLookup' value='?' class='button' onclick='callPatientSearch(); '></td>

				<td class=label  nowrap>
					<fmt:message key="eOA.ReasonforForceClosing.label" bundle="${oa_labels}"/>
					</td>

				<td class='fields'>
				 <input type='text'  name='cboReason' id='cboReason' value='' size='30' maxlength='30' onblur='open_force_close_waitlist();'><input type='button' class='button' value='?' name='search_reason_create' id='search_reason_create' onClick="open_force_close_waitlist();"   tabindex=0>
				<img id='image' align=center src='../../eCommon/images/mandatory.gif'></img>
				<input type="hidden" name="reason_code" id="reason_code" >

				</td>

			</tr>

			</table>

	
		<input type=hidden name="force_prd_days" id="force_prd_days" value="<%=prd%>">
		<input type=hidden name="from" id="from" value="ForceClose">
		<input type=hidden name="locale" id="locale" value="<%=locale%>">

	</form>
	</body>
	</html>			
<%	
}catch(Exception e){
	//out.println(e.getMessage()); 
	e.printStackTrace();
}
%>

