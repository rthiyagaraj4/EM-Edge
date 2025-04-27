<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript' ></script>
    <script language='javascript' src='../../eOP/js/OPCancelledCheckout.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>		
		<iframe name='OPCancelChkoutSearch' id='OPCancelChkoutSearch' src='../../eOP/jsp/OPCancelledCheckoutQuerySearchCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
		<iframe name='OPCancelChkoutResult' id='OPCancelChkoutResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:55vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>	

</html>

