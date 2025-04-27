<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<html>
<title><fmt:message key="eMP.clinicaldetails.label" bundle="${mp_labels}"/></title>

<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/RegPatReferral.js'></script>
	<script language='javascript' src='../../eMP/js/RegPatReferral1.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		
		String params = request.getQueryString() ;
		
		String calling_from =request.getParameter("calling_from"); 
		String speciality_code =request.getParameter("speciality_code"); 
	
		String practitioner =request.getParameter("practitioner"); 
		String practitioner_name =request.getParameter("practitioner_name"); 		
		if (calling_from==null) calling_from="";

		String mode=(request.getParameter("mode") == null)?"":request.getParameter("mode");
 
		if (speciality_code==null) speciality_code="";
        if (practitioner==null) practitioner="";
        if (practitioner_name==null) practitioner_name="";
		practitioner_name = java.net.URLEncoder.encode(practitioner_name);
		String utl1= "../../eMP/jsp/RegPatReferralMainPage.jsp?";
		utl1 =  utl1+params;		
		if (calling_from.equals("SEARCH"))
		{
		%>
		<title><fmt:message key="eMP.RegisterPatientReferral.label" bundle="${mp_labels}"/></title>
	 <%
		}
%>
<body onLoad='populateClinicaldetails()' onKeyDown = 'lockKey();' >
	<form name='Clinical_Details_form' id='Clinical_Details_form' method='post' action='' target='messageFrame'>
	<br>
<style>
textarea {
  resize: none;
}
</style>
		<table cellspacing=0 cellpadding=0 align='center' width='90%'  border='0'>
			<TR>
				<TD COLSPAN=4>&nbsp;</TD></TR>
			<tr>
				<td align=left class=LABEL><fmt:message key="eMP.examclinicalfindings.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
				<td colspan=3 align=left>&nbsp;&nbsp;<TEXTAREA  name="exm_clinical_find" cols='60'  onblur='makeValidString(this);return checkMaxLenDtls(this,"<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.examclinicalfindings.label","mp_labels")%>")' ></TEXTAREA>
				</td> 
			</tr>
			<TR>
				<TD COLSPAN=4>&nbsp;</TD></TR>
			<tr>
				<td align=left class=LABEL><fmt:message key="Common.ReferralDiagnosis.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td colspan=3 align=left >&nbsp;&nbsp;<TEXTAREA  name="diagnosis" cols='60'  onblur='makeValidString(this);return checkMaxLenDtls(this,"<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")%>")' ></TEXTAREA>
				</td> 
			</tr>
			<TR>
				<TD COLSPAN=4>&nbsp;</TD></TR>
			<tr>
				<td align=left class=LABEL><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td colspan=3 align=left>&nbsp;&nbsp;<TEXTAREA  name="treatment" cols='60' onblur='makeValidString(this);return checkMaxLenDtls(this,"<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treatment.label","common_labels")%>")' ></TEXTAREA>
				</td> 
			</tr> 
			<TR>
				<TD COLSPAN=4>&nbsp;</TD></TR>
			<tr>
				<td colspan=2 class=LABEL>&nbsp;</td>
				<td colspan=2 align=right><INPUT class='button' TYPE='BUTTON' name='CLOSE' id='CLOSE' VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='close_meDtls();' >&nbsp;&nbsp;</td> 
			</tr>
		</table>
		<input type='hidden' name='calling_from' id='calling_from' value='<%=calling_from%>'>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<script>
		disablefields_callingfrom();
		</script>
	</form>
</body>

</html>

