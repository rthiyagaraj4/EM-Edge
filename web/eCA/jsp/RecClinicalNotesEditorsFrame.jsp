<!DOCTYPE html>
<%/*
-------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------------------------
14/9/2016	IN061808		Raja S										JRE 1.8 issue
-------------------------------------------------------------------------------------------------------------------------------------------------------
*/%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.RichTextEditorandMEDIPainter.label" bundle="${ca_labels}"/> </title>
	<META content="text/html; charset=UTF-8" http-equiv=Content-Type>
	<META content="MSHTML 5.00.2920.0" name=GENERATOR>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<!-- 	<script language='javascript' src='../../eCA/js/prototype.js'></script>  -->
	<SCRIPT language="javascript" src="../../eCommon/js/RTEditor.js"></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>

<%
String image_view_counter		=	"";
String RTEText					=	"";
String sec_hdg_code				=	"";
String doc_exists				=	"";
String strContentEditableYn		=	"";
String curr_sec_hdg_code		=	"";
String curr_section_type		=	"";
String curr_result_link_type	=	"";
String curr_result_link_yn		=	"";
String curr_image_linked_yn		=	"";
String curr_child_sec_hdg_code	=	"";
String patient_id				=	"";
String encounter_id				=	"";
String editor_param				=	"";

sec_hdg_code				=	(request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code"));
curr_image_linked_yn		=	(request.getParameter("curr_image_linked_yn")==null?"":request.getParameter("curr_image_linked_yn"));
curr_result_link_type		=	(request.getParameter("curr_result_link_type")==null?"":request.getParameter("curr_result_link_type"));
curr_result_link_yn			=	(request.getParameter("curr_result_link_yn")==null?"":request.getParameter("curr_result_link_yn"));
curr_sec_hdg_code			=	(request.getParameter("curr_sec_hdg_code")==null?"":request.getParameter("curr_sec_hdg_code"));
curr_section_type			=	(request.getParameter("curr_section_type")==null?"":request.getParameter("curr_section_type"));
curr_child_sec_hdg_code		=	(request.getParameter("curr_child_sec_hdg_code")==null?"":request.getParameter("curr_child_sec_hdg_code"));
image_view_counter			=	(request.getParameter("image_view_counter")==null?"":request.getParameter("image_view_counter"));
RTEText						=	(request.getParameter("RTEText")==null?"":request.getParameter("RTEText"));

doc_exists					=	(request.getParameter("doc_exists")==null?"":request.getParameter("doc_exists"));
strContentEditableYn		=	(request.getParameter("content_editable_yn")==null?"Y":request.getParameter("content_editable_yn"));
patient_id					=	(request.getParameter("patient_id")==null?"Y":request.getParameter("patient_id"));
encounter_id					=	(request.getParameter("encounter_id")==null?"Y":request.getParameter("encounter_id"));
editor_param					=	(request.getParameter("editor_param")==null?"":request.getParameter("editor_param"));

if(strContentEditableYn.equals("") )
	strContentEditableYn = "Y";

//RTEText = java.net.URLEncoder.encode(RTEText);
%>
<script language='JavaScript'>

var HTMLContent = "<html><body><form name=\'ImageRTEditorForm\' id=\'ImageRTEditorForm\' action = \'../../eCA/jsp/RTEditor.jsp\' method=\'post\'>";
HTMLContent += "<textarea name = \'RTEText\' id = \'RTEText\' style = \'visibility:hidden\' ><%=RTEText%></textarea>";
HTMLContent += "<input type = hidden name = 'content_editable_yn'  id = 'content_editable_yn' value = '<%=strContentEditableYn%>'>";
//HTMLContent += "<input type = hidden name = 'editor_param' id = 'editor_param' value = '<%=editor_param%>'>";
HTMLContent += "</form></body></html>";

var controller = parent.RecClinicalNotesSecControlFrame;
//controller.document.body.innerHTML = "";
controller.document.body.insertAdjacentHTML('beforeend', HTMLContent);
</script>
</head>
<body>
<!-- <FRAMESET ROWS="100%,*" id = "frameSetIDPainterEditor" border="0" > -->
<IFRAME SRC="../../eCommon/html/blank.html" name="RecClinicalNotesRTEditorFrame" id="RecClinicalNotesRTEditorFrame" noresize style="height:93vh;width:99vw"></IFRAME>
<!--<FRAME SRC="../../eCA/jsp/MedPntredit.jsp?sec_hdg_code=<%=sec_hdg_code%>&image_view_counter=<%=image_view_counter%>&curr_sec_hdg_code=<%=curr_sec_hdg_code%>&curr_child_sec_hdg_code=<%=curr_child_sec_hdg_code%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>" NAME="RecClinicalNotesMediPainterFrame" noresize> --> <!--Commented for IN061808 -->
<IFRAME SRC="../../eCA/jsp/MedPntredit.jsp?sec_hdg_code=<%=sec_hdg_code%>&image_view_counter=<%=image_view_counter%>&curr_sec_hdg_code=<%=curr_sec_hdg_code%>&curr_child_sec_hdg_code=<%=curr_child_sec_hdg_code%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>" NAME="RecClinicalNotesMediPainterFrame" ID="RecClinicalNotesMediPainterFrame" frameborder=0 style="height:0vh;width:99vw;" noresize></IFRAME> <!-- Added style for IN061808 -->
<!-- </FRAMESET> -->
<script language="JavaScript">

getEditor(); 

function getEditor()
{
	var controller = parent.RecClinicalNotesSecControlFrame;
	controller.document.ImageRTEditorForm.target = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.name;
	controller.document.ImageRTEditorForm.submit();
}
</script>
</body>
</html>
