<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html> 
<head>
<title><fmt:message key="eOA.OverlapDetails.label" bundle="${oa_labels}"/></title>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//System.err.println("======"+request.getQueryString());
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='overlap_details_frame' id='overlap_details_frame' src='../../eOA/jsp/GroupApptOverlapDetails.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling=no noresize style='height:90vh;width:100vw'></iframe>
	<iframe name='overlap_close' id='overlap_close' src='../../eOA/jsp/GroupApptOverlapButton.jsp' frameborder='0' scrolling=no noresize style='height:10vh;width:100vw'></iframe>

</html>

