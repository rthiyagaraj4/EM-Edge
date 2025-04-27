<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<iframe name='noteTypeValuesFrame' id='noteTypeValuesFrame' src='../../eCA/jsp/SectionForNoteTypePopulate.jsp' frameborder=0  scrolling='no' style='height:8vh;width:100vw'></iframe>
		<iframe name='sectionsFrame' id='sectionsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:47vh;width:100vw'></iframe>
		<iframe name='addSectionsFrame' id='addSectionsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:38vh;width:100vw'></iframe>
		<iframe name='removeRecFrame' id='removeRecFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0vh;width:100vw'></iframe>
		<iframe name='BlankFrame' id='BlankFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0vh;width:100vw'></iframe>
	
</html>

