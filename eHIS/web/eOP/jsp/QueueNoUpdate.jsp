<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<head>
<title>
	<fmt:message key="eOP.UpdateQueueNumber.label" bundle="${op_labels}"/> 
</title>
	<% 
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script src="../../eOP/js/QueuenumberUpdate.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String p_patient_id=request.getParameter("patient_id");
	String p_encounter_id   = request.getParameter("Encounter_Id");
	String fac_id       = (String) session.getValue( "facility_id" ) ;
	String p_clinic_code=request.getParameter("locn_code");
	String p_locn_type=request.getParameter("locn_type");
	String p_pract_id=request.getParameter("pract_id");
	try
	{
%>
<body>
<form name='updateQueuenumber' id='updateQueuenumber' method='post' action='../../servlet/eOP.UpdateQueueNumber'>
<br>
<style>
textarea {
    display: block;
    margin-left: 5px;
}
</style>
	<table align='center'>
	<tr>
		<td><fmt:message key="eOP.UpdateQueueNumber.label" bundle="${op_labels}"/></td><td><input type='text' name='queue_no' id='queue_no' value = "" size='15'onKeyPress='return Check_SpecCharsValidationOP1(event);'  onPaste='return checkspecialandalphanumericOP1(event);'  maxlength='15' ></td>
		</tr>
	</table>
<br>
<div align='Right'>	
	<tr>
	<td colspan='4' class='button'><input type='button'  class='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="UpdateQueueNo();"><input type='button' align='left' class='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='CloseUpdateQueueNo();'></td>
    </tr>
</div>
<% 
out.print("<input type='hidden' name='fac_id' id='fac_id' value='"+fac_id+"'>");
out.print("<input type='hidden' name='patientid' id='patientid' value='"+p_patient_id+"'>");
out.print("<input type='hidden' name='encntrid' id='encntrid' value='"+p_encounter_id+"'>");
out.print("<input type='hidden' name='clinic_code' id='clinic_code' value='"+p_clinic_code+"'>");
%>
</form>
</body>
</HTML>
<%			
	
	}
	catch(Exception e)
	{
		System.err.println(e);
		e.printStackTrace();
	}	
%>

