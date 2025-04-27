<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Janet George
*	Created On		:	6 Jan 2005

--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


<script language="JavaScript" src="../../eMR/js/TermSetCritforPatientClass.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<iframe name='f_query_header' id='f_query_header' 	src='../../eMR/jsp/TermSetCritforPatientClassHeader.jsp' frameborder=0 noresize style='height:10%;width:100vw'></iframe>
	 <iframe name='f_query_detail' id='f_query_detail' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
	 <iframe name='Dummy' id='Dummy' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0%;width:100vw'></iframe>

</head>
<body onKeyDown='lockKey()'>
</body>
</html>

