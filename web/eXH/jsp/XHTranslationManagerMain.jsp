<!DOCTYPE html>

<html><%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>

	<%request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../js/XHTranslationManager.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>

</script>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='Search' id='Search' 	src='../../eXH/jsp/XHTranslationManagerCriteria.jsp'   frameborder=0 scrolling=auto noresize style='height:17vh;width:100vw'></iframe>
	<iframe name='result' id='result' 	src='../../eCommon/html/blank.html'   frameborder=0 scrolling=auto noresize style='height:68vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
	<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

</html>

