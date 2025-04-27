<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eOA/js/GenerateSchedule.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--Below Frame size modified for this CRF  [AMRI-CRF-0236]-->
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='summary' id='summary'  MARGINWIDTH=0 MARGINHEIGHT=0  FRAMEBORDER=NO src='../../eOA/jsp/addmodifyGenerateSchedule.jsp'  style='height:30vh;width:100vw'></iframe>
	<iframe name ='detail' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO   src='../../eCommon/html/blank.html'  scrolling='no' noresize style='height:51vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

