<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>  
<!--<script src="../../eCP/js/common.js" language="JavaScript"></script>-->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<!--<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>-->
<script src="../../eCP/js/ViewCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/CpMessages.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<iframe name='view_cp_criteria' id='view_cp_criteria' src='../../eCP/jsp/ViewCarePlanCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe>
<iframe name='view_cp_result' id='view_cp_result' scrolling='auto'	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:17vh;width:100vw'></iframe>
<iframe name='view_cp_dyn_val' id='view_cp_dyn_val' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:4vh;width:100vw'></iframe>
<iframe name='view_cp_addmod' id='view_cp_addmod' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:4vh;width:100vw'></iframe>
<iframe name='view_cp_tabs' id='view_cp_tabs' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
<iframe name='view_cp_detail' id='view_cp_detail' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:60vh;width:100vw'></iframe>
</head>
</html>

