<!DOCTYPE html>
<%@page session="true" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/DTLinkEncounterVolumeDocType.js'></script>
</head>
<%
	String encounter_id			= checkForNull(request.getParameter("encounter_id"));
	String volume_no			= checkForNull(request.getParameter("volume_no"));
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String file_no				= checkForNull(request.getParameter("file_no"));
	String file_type			= checkForNull(request.getParameter("file_type"));
	String patient_class		= checkForNull(request.getParameter("patient_class"));
	String action_code			= checkForNull(request.getParameter("action_code"));
	String encounter_date_time	= checkForNull(request.getParameter("encounter_date_time"));
	String maintain_doc_or_file	= checkForNull(request.getParameter("maintain_doc_or_file"));
	String doc_folder_id		= checkForNull(request.getParameter("doc_folder_id"));
	String source				= "../../eCommon/jsp/pline.jsp?EncounterId="+encounter_id;
	String params				=	"../../eFM/jsp/DTLinkEncounterDocumentsAdd.jsp?encounter_id="+encounter_id+"&doc_folder_id="+doc_folder_id+"&volume_no="+volume_no+"&file_no="+file_no+"&maintain_doc_or_file="+maintain_doc_or_file;
%>
<form name="DTLinkDocumentFrame" action="../../servlet/eFM.DTLinkEncounterDocTypeServlet" method="POST" target="messageFrame">
<input type="Hidden" name="encounter_id" value = "<%=encounter_id%>">
<input type="Hidden" name="patient_id" value = "<%=patient_id%>">
<input type="Hidden" name="file_no" value = "<%=file_no%>">
<input type="Hidden" name="file_type" value = "<%=file_type%>">
<input type="Hidden" name="patient_class" value = "<%=patient_class%>">
<input type="Hidden" name="action_code" value = "<%=action_code%>">
<input type="Hidden" name="encounter_date_time" value = "<%=encounter_date_time%>">
<input type="Hidden" name="maintain_doc_or_file" value = "<%=maintain_doc_or_file%>">
<input type="Hidden" name="doc_folder_id" value = "<%=doc_folder_id%>">
</form>
<frameset rows='12%,*' frameborder='0'>
	<frame name='patient_line_frame' src='<%=source%>' frameborder=0 scrolling='no' noresize>
	<frameset rows="33%, 67%" frameborder='0'>
		<frame name='add_doc_frame' src='<%=params%>' frameborder=0 scrolling='no' noresize>
		<frame name='select_doc_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize>
	</frameset>
 </frameset>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
