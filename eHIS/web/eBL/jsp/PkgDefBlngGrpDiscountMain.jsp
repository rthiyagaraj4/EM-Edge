<!DOCTYPE html>
<html>
<head>
<title>
	<fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>
</title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefDiscount.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<iframe name='blng_grp_discount_dtl_hdr' id='blng_grp_discount_dtl_hdr' src="../../eBL/jsp/PkgDefBlngGrpDiscountHdr.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='NO' style='height:7vh;width:100vw'></iframe>
<iframe name='blng_grp_discount_dtl' id='blng_grp_discount_dtl' src="../../eBL/jsp/PkgDefBlngGrpDiscount.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style='height:81vh;width:100vw'></iframe>
<iframe name='blng_grp_discount_btn' id='blng_grp_discount_btn' src="../../eBL/jsp/PkgDefDiscountBtn.jsp?<%=request.getQueryString()%>&table_name=blng_grp_discount_tbl" frameborder='0' noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
</html> 

