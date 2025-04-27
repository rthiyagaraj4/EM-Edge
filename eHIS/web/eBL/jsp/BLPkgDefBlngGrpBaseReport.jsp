<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");	%><%
	String facilityId	= request.getParameter("facilityId");
	System.out.println("facilityId in Billing group "+facilityId);
	String packageCode	= request.getParameter("packageCode");
	String fromDate		= request.getParameter("fromDate");	
	String blgClsCode	= request.getParameter("blgClsCode");
	String blng_grp_code= request.getParameter("blng_grp_code");
	if(facilityId == null) facilityId="";
	if(packageCode == null) packageCode="";
	if(blgClsCode == null) blgClsCode="";
	if(blng_grp_code == null) blng_grp_code="";
	
	System.out.println("packageCode in billing grp "+packageCode);
	System.out.println("fromDate in billing grp "+fromDate);
	System.out.println("blgClsCode in billing grp "+blgClsCode);
	System.out.println("P_BLNG_GRP_CODE in billing grp "+blng_grp_code);
	
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
%>
<html>
<head><title></title>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eBL/js/PkgDef.js" ></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='JavaScript' src='../../eCommon/js/messages.js'></script>
<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='BLReportOptionsForm' id='BLReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="BL" />
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="BLPKGBLG" />
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>"/>
	<input type="hidden" name="P_PACKAGE_CODE" id="P_PACKAGE_CODE" 	value="<%=packageCode%>" />	
	<input type="hidden" name="P_EFF_FROM_DT" id="P_EFF_FROM_DT" 	value="<%=fromDate%>" />	
	<input type="hidden" name="P_BLNG_CLASS" id="P_BLNG_CLASS" 	value="<%=blgClsCode%>" />
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	value="<%=facilityId%>" />
	<input type="hidden" name="P_BLNG_GRP_CODE" id="P_BLNG_GRP_CODE" value="<%=blng_grp_code%>" />
	
</form>
</body>
</html>
<script>
	PkgBlngGrpBaseRun();
</script>

