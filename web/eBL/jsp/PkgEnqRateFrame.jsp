<!DOCTYPE html>
<html>
<head><title><fmt:message key="eBL.RateBased.label" bundle="${bl_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params = request.getQueryString();
	//String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");//unused variable

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<iframe name='rate_based_dtl' id='rate_based_dtl' src="../../eBL/jsp/PkgEnqRateBased.jsp?<%=params%>" frameborder='0' noresize scrolling='auto' style='height:65vh;width:100vw'></iframe>
<iframe name=' srvLimit_rate_based_dtl' id=' srvLimit_rate_based_dtl' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='auto' style='height:35vh;width:100vw'></iframe>
</html> 

