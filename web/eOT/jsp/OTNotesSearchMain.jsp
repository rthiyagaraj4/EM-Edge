<!DOCTYPE html>
<!-- Created Against ML-MMOH-CRF-1208 [IN:068081] -->

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head> 
<title>
	<fmt:message key="eOT.RecordSurgeonNotes.Label" bundle="${ot_labels}"/>&nbsp;
	<fmt:message key="Common.search.label" bundle="${common_labels}"/>
</title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<frameset rows='30%,*' framespacing='0' id='notesSearchFrame' >
	<frame name="OTNotesSearchCriteriaFrame" id="OTNotesSearchCriteriaFrame" frameborder="no" scrolling="no" noresize src="../../eOT/jsp/OTNotesSearchCriteria.jsp?<%=request.getQueryString()%>&appl_task_id=OT_NOTES">
	</frame>
	<frame name="OTNotesSearchResultFrame" id="OTNotesSearchResultFrame" frameborder="no" scrolling="auto" noresize src="../../eCommon/html/blank.html">
	</frame>
</frameset>
</html>

