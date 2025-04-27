<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page language="java"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eOA/js/repResetRunlist.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

%>
<!--frameset rows='60,40,*,40'-->
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %>  scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe scrolling="no" name='menuFrame' id='menuFrame' src='../../eOT/jsp/repOtMastListForm.jsp'   style='height:7vh;width:100vw'></iframe>
<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'   style='height:78vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
</html>

