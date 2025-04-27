<!DOCTYPE html>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><script src="../../eRS/js/repRSMasterList.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/messages.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<!--frameset rows='60,40,*,40'-->
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %>  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='menuFrame' id='menuFrame' src='../../eRS/jsp/repRSMasterListForm.jsp'  frameborder=0 noresize style='height:7vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  frameborder=0  noresize style='height:78vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
</html>


