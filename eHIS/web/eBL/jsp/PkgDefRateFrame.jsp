<!DOCTYPE html>
<html>
<head><title><fmt:message key="eBL.RateBased.label" bundle="${bl_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params = request.getQueryString();
	//String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");//unused variable

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	   
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<iframe name='rate_based_hdr_frame' id='rate_based_hdr_frame' src="../../eBL/jsp/PkgDefRateBasedHdr.jsp" frameborder='0' noresize scrolling='no' style='height:12vh;width:100vw'></iframe>
<iframe name='rate_based_dtl' id='rate_based_dtl' src="../../eBL/jsp/PkgDefRateBased.jsp?<%=params%>" frameborder='0' noresize scrolling='auto' style='height:30vh;width:100vw'></iframe>
<iframe name=' rate_based_btn' id=' rate_based_btn' src="../../eBL/jsp/PkgDefRateBasedBtn.jsp?<%=params%>&table_name=rate_based_tbl" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
<iframe name='srvLimit_rate_based_hdr' id='srvLimit_rate_based_hdr' src="../../eCommon/html/blank.html"  frameborder='0' noresize scrolling='no' style='height:12vh;width:100vw'></iframe>
<iframe name='srvLimit_rate_based_dtl' id='srvLimit_rate_based_dtl' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='auto' style='height:30vh;width:100vw'></iframe>
<iframe name='srvLimit_rate_based_btn' id='srvLimit_rate_based_btn' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
</html> 

