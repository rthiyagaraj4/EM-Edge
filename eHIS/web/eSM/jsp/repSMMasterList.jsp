<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../js/repResetRunList.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %>  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='menuFrame' id='menuFrame' src='../jsp/repSmMastListForm.jsp'  frameborder=0 noresize style='height:7vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  frameborder=0 noresize style='height:78vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
</html>

