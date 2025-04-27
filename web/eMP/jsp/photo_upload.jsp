<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	%>
<% 
String patient_id = request.getParameter("patient_id"); 
String photoCount = request.getParameter("photoCount");
%>
<HTML>
<HEAD>	
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<script language="JavaScript" src="../../eMP/js/ViewPatDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<!--<BODY onUnLoad='window.returnValue="close"' onKeyDown='lockKey()'>-->
<BODY onUnLoad='let dialogBody = parent.parent.document.getElementById("dialog-body").contentWindow.returnValue = "close";const dialogTag = parent.parent.document.getElementById("dialog_tag").close();' onKeyDown='lockKey()'>
<form name='photoUpload' id='photoUpload' action='../../servlet/eMP.PhotoUploadServlet' method='post' enctype='multipart/form-data'>
<table border=0 cellspacing=0 cellpadding=0 width='80%' align='center'>
<tr ><td class='label' width='50%%' colspan=2>&nbsp;</td></tr>
<tr ><td class='label' width='50%%' colspan=2>&nbsp;</td></tr>
<tr ><td class='label' width='50%%' colspan=2>&nbsp;</td></tr>
<tr ><td class='label' width='50%'><fmt:message key="eMP.PatientPhoto.label" bundle="${mp_labels}"/></td><td class='fields'><input type="file" name="patFile" id="patFile" value=""  size=40 maxlength=40 onchange="" onkeypress="return onkeyPressEvent(event);"></td></tr>
<tr ><td class='label' width='50%' colspan=2>&nbsp;</td></tr>
<tr	><td class='label' width='50%%'></td><td width='25%'  class='button'><input type='button' name='uploadfile' id='uploadfile' value='<fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/>' onclick='parent.uploadfile()' ></td></tr>
<tr ><td class='label' width='50%' colspan=2>&nbsp;</td></tr>
</table>
<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'>
<input type="hidden" name="photoCount" id="photoCount" value='<%=photoCount%>'>
</form>
</BODY>
</HTML>
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

