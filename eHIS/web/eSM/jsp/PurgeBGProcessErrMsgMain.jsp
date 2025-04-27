<!DOCTYPE html>
<%@ page   contentType="text/html;charset=UTF-8"  %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
    <%
	      request.setCharacterEncoding("UTF-8");
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eSM/js/PurgeBGProcessErrMsg.js'></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js"language="javascript"></Script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='javascript'></script>

		
	
</head>
<%
   
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:24vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod'	src='../../eSM/jsp/PurgeBGProcessErrMsgDetail.jsp' frameborder=0 scrolling='auto' noresize style='height:67vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

