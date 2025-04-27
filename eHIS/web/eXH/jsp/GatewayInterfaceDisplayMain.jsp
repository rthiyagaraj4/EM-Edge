<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.*"%>
<html>   

<head> 

<title>Gateway Process</title>

<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='${pageContext.request.contextPath}/eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/common.js" ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String reqParam=request.getQueryString();

pageContext.setAttribute("reqParam", reqParam);

%>

</head>

 <iframe name='gatewaydisplayheaderframe' id='gatewaydisplayheaderframe' src='../../servlet/eXH.CentralizedServlet?<%=reqParam %>' frameborder=0 scrolling="yes" style='height:83vh;width:100vw'></iframe>
 <iframe name='footerFrame' id='footerFrame' src='../../eXH/jsp/GatewayInterfaceFooter.jsp' frameborder=0  scrolling='no' style="padding-bottom: 1px;"  style='height:17vh;width:100vw'></iframe>

</html>





