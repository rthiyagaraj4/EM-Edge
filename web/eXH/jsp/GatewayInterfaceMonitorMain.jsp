<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.*"%>
<html>   

<head> 
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXH/js/CommProtocolId.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>



<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='gatewayheaderframe' id='gatewayheaderframe' src='../../servlet/eXH.CentralizedServlet?frame=header' frameborder=0 scrolling="no" style='height:58vh;width:100vw'></iframe>
	<iframe name='gatewaytableframe' id='gatewaytableframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='yes' style='height:58vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eXH/jsp/GatewayInterfaceFooter.jsp' frameborder=0  scrolling='no' style='height:6vh;width:100vw'></iframe>

</html>





