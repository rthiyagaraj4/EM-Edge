<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<%@  page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends %>
<html>
<head>


<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eDS/js/GenerateMealPlan.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script>
</script>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:4vh;width:100vw'></iframe>
<iframe name="at_frame" id="at_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/DSGenerateMealPlanTab.jsp?<%=params%>" style="height:8vh;width:100vw"></iframe>
<iframe name="at_tab_frame" id="at_tab_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/DSMealPlanTabFrames.jsp?<%=params%>" style="height:73vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="no" style="height:6vh;width:100vw"></iframe>
<form name="RecordAnesthesiaForm" id="RecordAnesthesiaForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
</form>
</html>

