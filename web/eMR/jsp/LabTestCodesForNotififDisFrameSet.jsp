<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eMR/js/LabTestCodesForNotifDis.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
 <iframe name='f_query_header' id='f_query_header' src='../../eMR/jsp/LabTestCodesForNotififDisSearch.jsp' frameborder=0 scrolling='no'  style='height:20vh;width:94vw'></iframe>
 <iframe name='Dummy' id='Dummy'	src='../../eMR/jsp/LabTestCodesForNotifyDisDynamicValues.jsp' frameborder=0 noresize style='height:53vh;width:94vw' scrolling='auto'></iframe>
 <iframe name='f_query_detail' id='f_query_detail' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:18vh;width:94vw'></iframe>
</html>

