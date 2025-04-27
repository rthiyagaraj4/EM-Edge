<!DOCTYPE html>
<html>

<head><title><fmt:message key="eBL.Customers.label" bundle="${bl_labels}"/></title>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<iframe name='customers_dtl' id='customers_dtl' src="../../eBL/jsp/PkgDefCustomers.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style='height:92vh;width:100vw'></iframe>
<iframe name='customers_btn' id='customers_btn' src="../../eBL/jsp/PkgDefRateBasedBtn.jsp?<%=request.getQueryString()%>&table_name=customers_tbl" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
</html> 

