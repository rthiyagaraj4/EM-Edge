<!DOCTYPE html>
<html>
<head>
<title>
	<fmt:message key="eBL.RateBased.label" bundle="${bl_labels}"/>
</title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	 
		String params = request.getQueryString();
		//System.out.println("params:"+params);
		//String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	
</head>

<iframe name='blng_grp_rate_based_dtl_hdr' id='blng_grp_rate_based_dtl_hdr' src="../../eBL/jsp/PkgDefBlngGrpRateBasedHdr.jsp?<%=params%>" frameborder='0' noresize scrolling='no' style='height:19vh;width:100vw'></iframe>
<iframe name='blng_grp_rate_based_dtl' id='blng_grp_rate_based_dtl' src="../../eBL/jsp/PkgDefBlngGrpRateBased.jsp?<%=params%>" frameborder='0' noresize scrolling='auto' style='height:25vh;width:100vw'></iframe>
<iframe name='blng_grp_rate_based_btn' id='blng_grp_rate_based_btn' src="../../eBL/jsp/PkgDefBlngGrpBtn.jsp?<%=params%>&table_name=blng_grp_rate_based_tbl" frameborder='0' noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
<iframe name='blng_grp_srvLimit_rate_based_dtl_hdr' id='blng_grp_srvLimit_rate_based_dtl_hdr' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='NO' style='height:19vh;width:100vw'></iframe>
<iframe name='blng_grp_srvLimit_rate_based_dtl' id='blng_grp_srvLimit_rate_based_dtl' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='auto' style='height:22vh;width:100vw'></iframe>
<iframe name='blng_grp_srvLimit_rate_based_btn' id='blng_grp_srvLimit_rate_based_btn' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
</html> 

