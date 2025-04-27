<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eMP/js/PatEncBanner.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='patEncBannerHdrFrame' id='patEncBannerHdrFrame' src='../../eMP/jsp/PatEncBannerHeader.jsp' frameborder=0 scrolling='no' style='height:4vh;width:100vw'></iframe>
	<iframe name='patEncBannerDetailsFrame' id='patEncBannerDetailsFrame'  src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style='height:74vh;width:100vw'></iframe>
	<iframe name='patEncBannerIntermediateFrame' id='patEncBannerIntermediateFrame'  src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style='height:4vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

