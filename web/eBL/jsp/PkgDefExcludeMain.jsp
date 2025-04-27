<!DOCTYPE html>
<html>

<head><title><fmt:message key="eBL.RateBased.label" bundle="${bl_labels}"/></title>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<iframe name='srvLimit_rate_based_dtl' id='srvLimit_rate_based_dtl' src="../../eBL/jsp/PkgDefExclude.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style='height:84vh;width:100vw'></iframe>
<iframe name='srvLimit_rate_based_btn' id='srvLimit_rate_based_btn' src="../../eBL/jsp/PkgDefRateBasedBtn.jsp?table_name=srvLimit_rate_based_tbl" frameborder='0' noresize scrolling='no' style='height:16vh;width:100vw'></iframe>
</html>

