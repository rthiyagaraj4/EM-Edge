<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<html>
	<head>
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
 	<script language='javascript' src='../../eOT/js/SetUpParameterForFacility.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		
	%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' frameborder='0' style='height:8vh;width:100vw'></iframe>
<iframe name='tabsFrame' id='tabsFrame' src='../../eOT/jsp/SetUpParameterForFacilityTabs.jsp'  scrolling='no' frameborder='0' noresize style='height:4vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  scrolling='auto' frameborder='0' noresize style='height:79vh;width:100vw'></iframe><!--Modified Against PMG2023-MMS-CRF-0002-->
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp?<%=params%>'  noresize frameborder='0' scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form>
	<input type=hidden name=source value="<%=params%>">

</html>

