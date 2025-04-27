<!DOCTYPE html>
<!--
CRF/SCF Reference No 	:  ML-MMOH-CRF-1972
Detected Release  No  	:  SEPTEMBER 2023 Release 
File prepared by      	:  Lakshmanan P
File prepared date    	:  06-07-2023
Purpose of the change   :  Cancel for Admission in AE current emergency Admission Patient 				   
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites	
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
  <% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script type="text/javascript">
function CancelOrAbort(name) {
	var cancel_for_admission_remarks= document.forms[0].cancel_for_admission_remarks.value;
	var errors='';
	if(cancel_for_admission_remarks.length > 200) {
          errors = errors + getMessage("REMARKS_CANNOT_EXCEED","Common"); 
         errors = errors.replace('$',"REMARKS");
         errors = errors.replace('#',200);
         errors = errors + "\n" ;
		 alert(errors) ;
		return false;
		document.forms[0].cancel_for_admission_remarks.focus();
	}
	if (name=="cancel") {
		if (document.forms[0].ReasonForCancellation.value!="" & document.forms[0].cancel_for_admission_remarks.value!="") {
			document.forms[0].submit();
			parent.window.returnValue = "Y"
			alert(getMessage("RECORD_MODIFIED","SM" ));
			parent.window.close();
		} else {
			alert(getMessage("MAND_CANT_BLNK","AE"));
		}
	} else if (name=="abortcancel"){
		parent.window.close();
	} 
}
function CheckMaxLimit(obj,lab,max) {
	var errors='';
	if(obj.value.length > max) {
          errors = errors + getMessage("REMARKS_CANNOT_EXCEED","Common"); 
         errors = errors.replace('$',lab);
         errors = errors.replace('#',max);
         errors = errors + "\n" ;
		 alert(errors) ;
		return false;
		obj.focus();
	} else return true;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String Patient_Id = checkForNull(request.getParameter("Patient_Id"));
String encounter_id = checkForNull(request.getParameter("encounter_id"));
String referral_id = checkForNull(request.getParameter("referral_id"));
Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String facility_id	=	(String)session.getValue("facility_id");
String loggedInId = p.getProperty( "login_user" ) ;
Connection con = null;

try
	{
	con = ConnectionManager.getConnection(request);
	Statement stmt = null;
	ResultSet rset=null;
	PreparedStatement pstmt1=null;
	ResultSet rset1=null;
	
	String sql1="select DISP_REFERRAL_ID from OP_PATIENT_QUEUE where encounter_id=? and facility_id=? ";
	pstmt1	=	con.prepareStatement(sql1);
	pstmt1.setString(1,encounter_id);
	pstmt1.setString(2,facility_id);
	rset1=pstmt1.executeQuery();
	if (rset1 !=null && rset1.next()){
		referral_id=rset1.getString("DISP_REFERRAL_ID");
	}
	if(rset1 != null) rset1.close();	
	if(pstmt1 != null) pstmt1.close();
	
	String sql="";
	sql="select CONTACT_REASON_CODE , CONTACT_REASON  from am_contact_reason   where CANCEL_FOR_ADMISSION_YN='Y' AND EFF_STATUS='E' order by CONTACT_REASON";
	stmt = con.createStatement();
	rset = stmt.executeQuery(sql); 
%>
<body  OnMouseDown="CodeArrest()" onLoad='' onKeyDown = 'lockKey()'>
<br>
<form name="CancelForAdmission" id="CancelForAdmission" action="../../servlet/eAE.AEManagePatientServlet" method="post" >
<table width='80%' align='center' valign='top' border='0'>
<td class="label"><fmt:message key="eIP.ReasonForCancellation.label" bundle="${ip_labels}"/>
</td>
<td  class='fields'>

<Select name="ReasonForCancellation" id="ReasonForCancellation">
<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<%
while(rset !=null && rset.next()) {
	out.println("<option value='"+ rset.getString("CONTACT_REASON_CODE") + "'>" +rset.getString("CONTACT_REASON"));
}%> 
</Select>
<%	  
if(rset != null) rset.close();	
if(stmt != null) stmt.close();

%>
<img src='../../eCommon/images/mandatory.gif'></img>
</td>
<td class='label'><fmt:message key='eIP.CancelledBy.label' bundle="${ip_labels}"/>
</td>
<td class='fields'><input type='text' id="CancelledBy" name="CancelledBy" id="CancelledBy" size='10'  maxlenght='10' value='<%=loggedInId%>' disabled />
</td>
<tr>
<td class="label" rowspan='2' ><fmt:message key='Common.remarks.label'bundle="${common_labels}"/>
</td>
<td class='fields' rowspan='2'><textarea name="cancel_for_admission_remarks" ROWS="2" COLS="20"  onKeyPress='checkMaxLimit(this,200); return CheckForSpecCharsValidation1(event)' onBlur='makeValidString(this);CheckSplCharsValidation(this);return(CheckMaxLimit(this,"Remarks",200));' ></textarea>
<img src='../../eCommon/images/mandatory.gif'></img>
</td>
<td>&nbsp;</td><td>&nbsp;</td>
</tr>
<tr>
<td class='fields'><input type="button" class='Button' name="CancellForAdmissionBtn" id="CancellForAdmissionBtn" onclick="CancelOrAbort('cancel')" title='CancellForAdmissionBtn' value='<fmt:message key="eIP.CancelForAdmission.label" bundle="${ip_labels}"/>' >
</td>
<td class='fields' ><input type="button" class='Button' name="AbortCancellForAdmissionBtn" id="AbortCancellForAdmissionBtn" onclick="CancelOrAbort('abortcancel')" title='AbortCancellForAdmissionBtn' value='<fmt:message key="Common.Abort.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.CancelForAdmission.label" bundle="${ip_labels}"/>' >
</td>
</tr>
<input type='hidden' name='Patient_Id' id='Patient_Id' value='<%=Patient_Id%>' />
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>' />
<input type='hidden' name='referral_id' id='referral_id' value='<%=referral_id%>' />
<input type='hidden' name='CancelledBy1' id='CancelledBy1' value='<%=loggedInId%>' />
<input type='hidden' name='operation_mode' id='operation_mode' value='updateCancelForAdmission'/>
</table>
</form>
</body>
</html>
<%
	}
	catch(Exception e){				   
	e.printStackTrace();
	}
finally	{
	if(con!=null) ConnectionManager.returnConnection(con,request);
} %>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

