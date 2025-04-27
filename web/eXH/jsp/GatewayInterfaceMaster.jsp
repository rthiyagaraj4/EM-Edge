<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HTML>
<HEAD>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/common.js'> </Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eXH/js/Validate.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript">
function alertbox()
{
	alert("masterpage...");
	
	}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

 <iframe name='gatewayheaderframe' id='gatewayheaderframe' src='../../servlet/eXH.CentralizedServlet' frameborder=0 noresize scrolling="yes" style='height:58vh;width:100vw'></iframe>

</html>





