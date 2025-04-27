<!DOCTYPE html>
<html>

<head><title><fmt:message key="eBL.Customers.label" bundle="${bl_labels}"/></title>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script> 
<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<iframe name='cust_dtls' id='cust_dtls' src="../../eBL/jsp/PkgDefCustDtls.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style='height:81vh;width:100vw'></iframe>
<iframe name='cust_btn' id='cust_btn' src="../../eBL/jsp/PkgDefCustBtn.jsp?<%=request.getQueryString()%>&table_name=cust_tbl" frameborder='0' noresize scrolling='no' style='height:19vh;width:100vw'></iframe>
</html> 

