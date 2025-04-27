<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name       :	ShiftForWorkplace.jsp
*	Purpose 		:
*	Created By		:	Subhash Y
*	Created On		:	15-09-2004
*/
%>
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../js/OrMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script language="javascript" src="../js/RSMessages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../js/ShiftForWorkplace.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize  style='height:8vh;width:100vw'></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" src='../../eCommon/html/blank.html'frameborder=0 scrolling="no" noresize style='height:83vh;width:100vw'></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 scrolling="auto" noresize style="height:9vh;width:100vw"></iframe>

</head>
</html>

