<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); 
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue%>
<html>
<head>
	<title><fmt:message key="eMR.DiagnosisTabs.label" bundle="${mr_labels}"/></title>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script>
	var currentTab = new String();
	currentTab = "Diagnosis";

	function tab_change(tab_name)
	{
		if(currentTab == "Diagnosis")
			document.getElementById("curr_id").src="../../eMR/images/current diagnosis_light.gif";
		else if(currentTab =="Episode")
			document.getElementById("EOC_id").src="../../eMR/images/Episodeofcare_light.gif";

		if(tab_name == "Diagnosis")
				document.getElementById("curr_id").src="../../eMR/images/current diagnosis_dark.gif";		
		else if(tab_name =="Episode")
			document.getElementById("EOC_id").src="../../eMR/images/Episodeofcare_dark.gif";

		currentTab = tab_name;
	}

	function Call_click(tab_name)
	{
		if(tab_name == "Diagnosis"){
					var qery_str1=document.forms[0].query_string.value;
		parent.RecDiagnosisMain.location.href='../../eMR/jsp/RecDiagnosisMain.jsp?'+qery_str1;

		}	
		else if(tab_name =="Episode"){
			var qery_str=document.forms[0].query_string.value;
			parent.RecDiagnosisMain.location.href='../../eMR/jsp/RecDiagnosisEOCMain.jsp?'+qery_str;
		}
	}
	</script>
</head>
<%
	String	editor_reqd_yn		=	"",		function_id			=	"";
	String	style_visibility	=	"",		error_docs_exists	=	"";
	String	operation_mode		=	"",		align_property		=	"LEFT";
	String	query_string		=	"";

	editor_reqd_yn			=	(request.getParameter("editor_reqd_yn")==null)	?	"Y"	:	request.getParameter("editor_reqd_yn");
	function_id				=	(request.getParameter("function_id")==null)	?	""	:	request.getParameter("function_id");
	error_docs_exists		=	(request.getParameter("error_docs_exists")==null)	?	""	:	request.getParameter("error_docs_exists");
	operation_mode			=	(request.getParameter("operation_mode")==null)	?	""	:	request.getParameter("operation_mode");

	query_string			=	(request.getQueryString()==null)	?	""	:	request.getQueryString();
	if( function_id.equals("DISCHARGE_SUMMARY") || function_id.equals("NOTIFIABLE_FORM")|| function_id.equals("SPCL_NOTE") )//commented for relaxing the user to record any number of referral letters
	{
		style_visibility = " style='visibility:hidden' ";
		if(error_docs_exists.equalsIgnoreCase("true")) align_property = "RIGHT";
	}
	if( function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES") )
	{
		style_visibility = " style=visibility:hidden ";
	}
%>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="tab_change('Diagnosis');Call_click('Diagnosis');">
 on load scipt call removed as part of PE
 -->
 <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >

	<center>
	<form name='RecClinicalNotesTabForm' id='RecClinicalNotesTabForm'>
	<table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
			<td align="<%=align_property%>">
				<!-- <a align='left' href="javascript:tab_change('Diagnosis')" ><img src="../../eMR/images/current diagnosis_light.gif" border=0 id='curr_id' onClick="Call_click('Diagnosis')"></a>
				<a align='left' href="javascript:tab_change('Episode')" ><img src="../../eMR/images/Episodeofcare_light.gif" border=0 id='EOC_id' onClick="Call_click('Episode')"></a>
 -->
				<!-- <a <style_visibility%> href='javascript:callRecDiagnosis()'>
					<input type='Button' name='Diagnosis' id='Diagnosis' value=' Current Problems/Diagnosis ' class="button" onClick='callRecDiagnosis();'>
				</a> -->
				<!-- <a <style_visibility%> href='javascript:callEpisodeofCare()'>
					<input type='Button' name='Episode' id='Episode' value=' Episode of Care ' class="button" onClick='callEpisodeofCare();'>
				</a> -->
			<%
			if(error_docs_exists.equalsIgnoreCase("true"))
			{
		%> <input type="BUTTON" class="BUTTON" name="view_error" id="view_error" value="View Error Docs" onClick="showErrorDocuments()">
		<%
			}
			
		%>
	</td> </tr>
	</table>
	<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
	<input type='hidden' name='editor_reqd_yn' id='editor_reqd_yn' value='<%=editor_reqd_yn%>'>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=request.getParameter("patient_id")%>'>
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
	<input type='hidden' name='operation_mode' id='operation_mode' value='<%=operation_mode%>'>
	<input type='hidden' name='curr_click' id='curr_click' value='Y'>
	<input type='hidden' name='EOC_click' id='EOC_click' value='Y'>
   



	</form>
	</center>
	<script language='javascript'>
	<%
		String callback_mode = "";
		callback_mode	=	(request.getParameter("callback_mode")==null)? "" : request.getParameter("callback_mode");
		if(callback_mode.equals("Search"))
		{
	%>
		//callRecClinicalNotesSearch(); // commented as part of PE
	<%
		}
		else if(callback_mode.equals("Add"))
		{
	%>
			//callRecClinicalNotesMain(); // commented as part of PE
	<%
		}
	%>
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</body>
</html>

