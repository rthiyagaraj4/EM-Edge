<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/jquery-3.6.3.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eXH/js/NotificationSettings.js"></SCRIPT>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	
	String source = url + params ;
%>

<c:remove var="xhNotificationRecipientDtls" scope="session" />

<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>  
<iframe name='searchCriteria' id='searchCriteria' src='../../servlet/eXH.NotificationSettingsServlet?requestType=SEARCH_CRITERIA' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
<iframe name='recipientSchedule' id='recipientSchedule' src="../../servlet/eXH.NotificationSettingsServlet?requestType=RECIPIENT_LIST" frameborder=0  scrolling='no' style='height:75vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>

