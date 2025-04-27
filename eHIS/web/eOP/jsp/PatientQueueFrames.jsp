<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html> 
<head>
<title><fmt:message key="eOP.PractVisitLoad.label" bundle="${op_labels}"/></title>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='patient_queue_frame' id='patient_queue_frame' src='../../eOP/jsp/PatientQueueDetails.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling=no noresize style='height:84vh;width:100vw'></iframe>
	<iframe name='patient_queue_close' id='patient_queue_close' src='../../eOP/jsp/PatientQueueButton.jsp' frameborder='0' scrolling=no noresize style='height:6vh;width:100vw'></iframe>

</html>

