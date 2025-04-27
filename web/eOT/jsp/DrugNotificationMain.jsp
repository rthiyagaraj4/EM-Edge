<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>           
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
	
	<script language='javascript' src='../../eOT/js/DrugNotification.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>

	<!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
	<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	<% String target = "../../eOT/jsp/DrugNotificationQueryCriteria.jsp?"+request.getQueryString(); %>
 </head>
 	<iframe name='QryCriteriaFrame' id='QryCriteriaFrame'	src='<%=target%>'  scrolling='no' noresize frameborder='0' style='height:10vh;width:95vw'></iframe>
	<iframe name='QryRstFrame' id='QryRstFrame' src='../../eCommon/html/blank.html'  scrolling='no' noresize frameborder='0' style='height:85vh;width:95vw'></iframe>
	
</html>

