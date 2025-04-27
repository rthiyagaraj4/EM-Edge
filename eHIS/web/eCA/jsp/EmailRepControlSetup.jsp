<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language="javascript" src="../js/EmailRepControlSetup.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCA/jsp/EmailRepControlSetupHdr.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='EmailRepControlSetupHdrFrame' id='EmailRepControlSetupHdrFrame'	src='<%=source%>' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:10%;width:100vw'></iframe><iframe name='EmailRepControlSetupDtlFrame' id='EmailRepControlSetupDtlFrame' src='../../eCA/jsp/EmailRepControlSetupDtl.jsp' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:100vh;width:100vw'></iframe>
</html>

