<!DOCTYPE html>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<%@page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script>
</script>

<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw" frameborder='0'></iframe>
<iframe name="at_frame" id="at_frame"  scrolling="no" noresize src="../../eOT/jsp/AT_AnaesthesiaTabs.jsp?<%=params%>" style="height:4vh;width:100vw" frameborder='0'></iframe>
<iframe name="at_tab_frame" id="at_tab_frame"  scrolling="no" noresize src="../../eOT/jsp/AT_AnaesthesiaTabFrames.jsp?<%=params%>" style="height:82vh;width:100vw" frameborder='0'></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp"  noresize scrolling="no" style="height:6vh;width:100vw" frameborder='0'></iframe>
<iframe name="dummy" id="dummy" src='../../eCommon/html/blank.html'  noresize scrolling="no" style='height:0vh;width:100vw' frameborder='0'></iframe>
<form name="RecordAnesthesiaForm" id="RecordAnesthesiaForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
</form>
</html>

