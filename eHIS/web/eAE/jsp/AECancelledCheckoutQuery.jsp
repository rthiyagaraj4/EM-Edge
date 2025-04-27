<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript' ></script>
	<script language='javascript' src='../../eAE/js/AECancelledCheckout.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>		
<iframe name='AECancelChkoutSearch' id='AECancelChkoutSearch' src='../../eAE/jsp/AECancelledChecoutSearchCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:38vh;width:100vw'></iframe>
<iframe name='AECancelChkoutResult' id='AECancelChkoutResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:44vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>	

</html>

