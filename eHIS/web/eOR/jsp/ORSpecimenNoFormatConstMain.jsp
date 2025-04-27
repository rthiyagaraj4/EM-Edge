<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOR/js/ORSpecimenFmt.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
iframe {
    border-left-width: 0px;
    border-top-width: 0px;
    border-bottom-width: 0px;
}
</style>

</head>
<%
	request.setCharacterEncoding("UTF-8");	
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='frameSpecFmtConst' id='frameSpecFmtConst'  src='../../eOR/jsp/ORSpecimenNoFormatConst.jsp' frameborder='1' noresize scrolling='auto' style="height:90vh;width:49%"></iframe>
<iframe name='frameSpecFmtResult' id='frameSpecFmtResult'  src='../../eOR/jsp/ORSpecimenNoFormatResults.jsp' frameborder='1' noresize scrolling='auto' style="height:90vh;width:49%"></iframe>
</html>


