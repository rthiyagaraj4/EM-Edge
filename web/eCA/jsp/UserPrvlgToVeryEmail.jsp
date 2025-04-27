<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language="javascript" src="../js/UserPrvlgToVeryEmail.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCA/jsp/UserPrvlgToVeryEmailHdr.jsp?" ; 
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='UserPrvlgToVeryEmailHdrFrame' id='UserPrvlgToVeryEmailHdrFrame'	src='<%=source%>' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:25%;width:100vw'></iframe><iframe name='UserPrvlgToVeryEmailDtlFrame' id='UserPrvlgToVeryEmailDtlFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=no framespacing=NO border=0 style='height:100vh;width:100vw'></iframe>
</html>

