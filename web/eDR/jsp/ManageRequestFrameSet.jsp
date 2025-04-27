<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8"); %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	<Script language="JavaScript" src="../../eDR/js/ManageRequest.js" ></Script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<iframe name='list' id='list'	src='../../eDR/jsp/ManageRequestCriteria.jsp'  scrolling='no' noresize style='height:16vh;width:100vw;border:none'></iframe>
		<iframe name='list1' id='list1'	src='../../eDR/jsp/ManageRequestResult.jsp' scrolling='auto' noresize style='height:67vh;width:100vw;border:none'></iframe>
		<iframe name='add_mod' id='add_mod' 	src='../../eDR/jsp/ManageRequestDetail.jsp'  scrolling='no' noresize style='height:15vh;width:100vw;border:none'></iframe>
	
</html>

