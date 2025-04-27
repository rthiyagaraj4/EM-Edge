<!DOCTYPE html>
<%--
	
*	Application		:	eMR
*	Created By		:	Bangarraju
*	Created On		:	10 Jan 2007
--%>
 <html>
 <head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/EquivalentTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_term_code_set' id='f_term_code_set' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:16vh;width:100vw'></iframe>
<iframe name='f_term_code_result' id='f_term_code_result' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:27vh;width:100vw'></iframe>
<iframe name='f_term_selected_frms' id='f_term_selected_frms' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:39vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:8%;width:100vw'></iframe>
</head>
</html>

