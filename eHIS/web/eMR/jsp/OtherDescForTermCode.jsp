<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "eCommon.XSSRequestWrapper"%>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="JavaScript" src="../js/OtherDescForTermCode.js"></script>
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



							<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
									<iframe name='OthsearchCriteria' id='OthsearchCriteria' src='../../eMR/jsp/OthDescForTermCodeCriteria.jsp' frameborder=0  scrolling='auto' style='height:28vh;width:100vw'></iframe>
									<iframe name='OthSearchResults' id='OthSearchResults' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:52vh;width:100vw'></iframe>
									<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
								

</head>
</html>

