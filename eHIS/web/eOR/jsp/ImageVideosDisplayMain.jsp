<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
28/03/2019	IN068778		Selvin M		28/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eOR.VideoFileList.label" bundle="${ca_labels}"/></title> 
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eOR/js/ImageVideosFileUpload.js' ></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	
	<iframe name='ImageVideosDisplayFrame' id='ImageVideosDisplayFrame' src='../../eOR/jsp/ImageVideosDisplay.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	
</html>

