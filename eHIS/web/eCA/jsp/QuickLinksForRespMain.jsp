<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script language='javascript' src='../js/QuickLinksForResp.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
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
<!-- Modified by kishore kumar N on 08/12/2008 for the CRF 0387
	altered frameset row size. (resultFrame) 
-->
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0  scrolling='no' style='height:20vh;width:100vw'></iframe>
	<iframe name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto' style='height:60vh;width:100vw'></iframe>
	<iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto' style='height:0vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

