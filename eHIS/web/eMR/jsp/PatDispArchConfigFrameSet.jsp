<!DOCTYPE html>
<!-- AgeGroupForTermCodeFrameSet.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	7 Feb 2005

--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<iframe name='criteriaFrame' id='criteriaFrame' 	src='../../eMR/jsp/PatDispArchConfigCriteria.jsp' frameborder=0 style='height:10%;width:100vw'></iframe><iframe name='resultsFrame' id='resultsFrame' 	src='../../eMR/jsp/PatDispArchConfigResults.jsp?arch_disp=0' frameborder=0 style='height:100vh;width:100vw'></iframe>
</head>
<body onKeyDown = 'lockKey()'>
</body>
</html>

