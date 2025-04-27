<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<script language='javascript' src='../js/NoteTypeByService.js'></script>
<script src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='f_query_add_mod_upper' id='f_query_add_mod_upper' src='../../eCA/jsp/AddModifyNoteTypeByService.jsp' frameborder=0 scrolling = 'no' style='height:10vh;width:99vw'></iframe>
<iframe name='f_query_add_mod_lower' id='f_query_add_mod_lower' src='../../eCommon/html/blank.html' frameborder=0 style='height:85vh;width:97vw'></iframe>

</html>

