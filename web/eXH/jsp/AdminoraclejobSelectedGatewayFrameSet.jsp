<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<html>
<head>
<title>Selected Gateways</title>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='details_frame' id='details_frame' src='../../eXH/jsp/AdminoraclejobSelectedSelectedGatewayDisplay.jsp?<%=request.getQueryString()%>' wrap frameborder='0' scrolling=auto  noresize style='height:88vh;width:100vw'></iframe>
<iframe name='close' id='close' src='../../eXH/jsp/AdminoraclejobSelectedSelectedGatewayClose.jsp' wrap frameborder='0' scrolling=no noresize style='height:10vh;width:100vw'></iframe>

</html>  										 												   

