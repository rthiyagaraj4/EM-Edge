<!DOCTYPE html>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- Author - kumar: called from QueryPackageDtls.jsp on selection of packages-->
<%
	String patient_id = request.getParameter("patient_id");
	//String qryStr = request.getQueryString("qryStr");
%>
<html>
<head>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
    <Script src="../js/AddModifyPatFinDetails.js" language="JavaScript"></Script>
    <Script src="/eCIS/op/js/VisitRegistration.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe src="AddModifyPatFinDetailsMain.jsp?<%=request.getQueryString()%>" name="FinancialDtls_frame" id="FinancialDtls_frame"  frameborder=0 scrolling='no' noresize style='height:90vh;width:100vw'></iframe>
<iframe src="PackageDetailsMain.jsp?patient_id=<%=patient_id%>" name="package_frame" id="package_frame" frameborder=0 scrolling='no' noresize  style='height:10vh;width:100vw'></iframe>
</head>
</html>

