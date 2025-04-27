<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOR/js/ORConfigureSpeciLabelFmt.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

	<iframe name="commontoolbarFrame" id="commontoolbarFrame"	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='frameCofigSpecimenFrmt' id='frameCofigSpecimenFrmt'  src='../../eOR/jsp/ORConfigureSpeciLabelHdr.jsp' frameborder='0' noresize scrolling='no' style='height:25vh;width:100vw'></iframe>
	<iframe name='frameCofigSpecimenFrmtDtl' id='frameCofigSpecimenFrmtDtl'  src='../../eCommon/html/blank.html' frameborder='0' noresize style='height:56vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>


