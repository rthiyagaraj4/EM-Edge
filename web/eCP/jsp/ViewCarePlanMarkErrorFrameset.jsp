<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>

<TITLE>View Evaluation Error</TITLE>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>
<script src="../../eCP/js/ViewCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/CpMessages.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<iframe name='view_cp_mrk_err_hdr' id='view_cp_mrk_err_hdr' src='../../eCP/jsp/ViewCarePlanMarkErrorHeader.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:35%;width:100vw'></iframe>
	<iframe name='view_cp_mrk_err_dtl' id='view_cp_mrk_err_dtl' scrolling='auto'	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='view_cp_dyn_val' id='view_cp_dyn_val' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0%;width:100vw'></iframe>

</head>
</html>

