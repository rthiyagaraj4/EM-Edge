<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
	<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script language="JavaScript" src='../../eXH/js/Filtergl.js'> </Script>
<script language="JavaScript" src='../../eXH/js/Filter.js'> </Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:1vh;width:100vw'></iframe>
	<iframe name='search' id='search' src='../../eCommon/html/blank.html' frameborder=0  scrolling='no' style='height:2vh;width:100vw'></iframe>
	<iframe name='filterframe' id='filterframe' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:2vh;width:100vw'></iframe>
	<iframe name='recordframe' id='recordframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:2vh;width:100vw'></iframe>
	<body onLoad="commontoolbarFrame.document.forms[0].apply.style.display='none'">
	</body>
</html>

