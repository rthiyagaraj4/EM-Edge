<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eMP/js/PatEncBanner.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key='eMP.PreviewBanner.label' bundle="${mp_labels}" /></title>
</head>
<%
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String params = request.getQueryString() ;
%>

<iframe name='patEncBannerTransFrame' id='patEncBannerTransFrame'  src='../../eMP/jsp/PatEncBannerTrans.jsp?<%=params%>' frameborder='0' noresize scrolling='auto' style='height:85vh;width:100vw'></iframe>
<iframe name='patEncBannerTransButtonsFrame' id='patEncBannerTransButtonsFrame'  src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='no' style='height:5vh;width:99vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

