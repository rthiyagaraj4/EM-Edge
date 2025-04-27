<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name       :	StaffForWorkplace.jsp
*	Purpose 		:
*	Created By		:	Prabhu.M
*	Created On		:	02-12-2004
*/
%>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>
<script src="../js/StaffForWorkplace.js" language="JavaScript"></script>
<!-- <script language="JavaScript" src="../js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize  style='height:8vh;width:100vw'></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" src='../../eCommon/html/blank.html'frameborder=0 scrolling="no" noresize style='height:83vh;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 scrolling="auto" noresize style="height:9vh;width:100vw"></iframe>
		
</head>
<body>
</body>
</html>

