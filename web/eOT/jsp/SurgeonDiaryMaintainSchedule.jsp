<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<html>
	<head>
 	<script language='javascript' src='../../eOT/js/SurgeonDiaryMaintainSchedule.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="javascript" src="../../eOT/js/Hashtable.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOT/jsp/SurgeonDiaryMaintainScheduleHeader.jsp' style='height:19vh;width:100vw' frameborder='0'></iframe>
		<iframe name='f_query_search_values' id='f_query_search_values' src='../../eCommon/html/blank.html'  noresize style='height:64vh;width:100vw' frameborder='0'></iframe>
		<!--<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOT/jsp/SurgeonDiaryMaintainAddModifySchedule.jsp' frameborder=0>-->
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' noresize scrolling='auto' style='height:9vh;width:100vw' frameborder='0'></iframe>
		<iframe name='hidden_frame' id='hidden_frame'	src='../../eOT/jsp/CommonMasterObjectCollect.jsp'  noresize style='height:0vh;width:100vw' frameborder='0'></iframe>
	
	<body onload="disapply()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	</body>
</html>

