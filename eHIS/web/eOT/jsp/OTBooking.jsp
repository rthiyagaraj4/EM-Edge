	<!DOCTYPE html>
<%@page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<head>
<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
<script language='javascript'>
function callAuthorization()
{
	alert("User not authorized to access Booking");
	var msg=getMessage("APP-OT0092","OT");
	alert(msg);
	parent.location.href="../../eCommon/jsp/dmenu.jsp";
//	parent.window.close();
}
</script>

<%  
	String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString()+"&facility_id="+facility_id;
    String url = "../../eCommon/jsp/commonToolbar.jsp?";
    String source = url + params ;
%>

	<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
	<!-- <script language="javascript" src="../web/eCommon/js/common.js"></script> -->
	<!--<script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>-->


 <iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" frameborder='0' style="height:6vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="auto" src="../../eOT/jsp/MainFrame.jsp?<%= params %>" frameborder='0' style="height:87vh;width:100vw"></iframe>
 <!--Scrolling made auto for the SCF- SKR-SCF-0847 [IN:044280] -->
<!--
<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/MainFrame.jsp?<%= params %>">
-->
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='no' frameborder='0' style="height:6vh;width:100vw"></iframe>


