<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>

<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/jquery-3.6.3.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eXH/js/NotificationDisp.js"></SCRIPT>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:1vh;width:100vw'></iframe>  
<iframe name='notificationDisp' id='notificationDisp' src="./DisplayNotificationServlet?requestType=QUERY_CRITERIA" frameborder=0  scrolling='no' style='height:16vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:2vh;width:100vw'></iframe>

