<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/PatEncBanner.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:9%;width:100vw'></iframe>
	<iframe name='patEncBannerHdrFrame' id='patEncBannerHdrFrame' src='../../eCA/jsp/PatEncBannerHeader.jsp' frameborder=0 scrolling='no' style='height:7%;width:100vw'></iframe><iframe name='patEncBannerDetailsFrame' id='patEncBannerDetailsFrame'  src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style='height:100vh;width:100vw'></iframe><iframe name='patEncBannerIntermediateFrame' id='patEncBannerIntermediateFrame'  src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style='height:0%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10%;width:100vw'></iframe>
</html>

