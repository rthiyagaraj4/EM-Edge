<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
  <head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMR/js/ReprintSickLeave.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
  <%
		request.setCharacterEncoding("UTF-8");
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
  %>
  <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:40%;width:100vw'></iframe>
		<iframe name='reprint_criteria' id='reprint_criteria' 	src='../../eMR/jsp/ReprintSickLeaveCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:70%;width:100vw'></iframe>
		<iframe name='reprint_result' id='reprint_result' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling = auto style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:30%;width:100vw'></iframe>
</html>

