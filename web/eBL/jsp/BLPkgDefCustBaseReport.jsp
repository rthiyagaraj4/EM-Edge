<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");	%><%
	//String facility_id = (String)session.getValue("p_facility_id");
	String facilityId	= request.getParameter("facilityId");
	System.out.println("facilityId in Customer "+facilityId);
	String packageCode	= request.getParameter("packageCode");
	String fromDate		= request.getParameter("fromDate");	
	String blgClsCode		= request.getParameter("blgClsCode");
	String cust_code		= request.getParameter("cust_code");
	String cust_grp_code		= request.getParameter("cust_grp_code");
	if(facilityId == null) facilityId="";
	if(packageCode == null) packageCode="";
	if(blgClsCode == null) blgClsCode="";
	if(cust_code == null) cust_code="";
	if(cust_grp_code == null) cust_grp_code="";
	System.out.println("packageCode in Customer "+packageCode);
	System.out.println("fromDate in Customer "+fromDate);
	System.out.println("blgClsCode in Customer "+blgClsCode);
	System.out.println("P_CUST_CODE in Customer "+cust_code);
	System.out.println("P_CUST_GRP_CODE in Customer "+cust_grp_code);
	

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
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="BLPKGCUS" />
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>"/>
	<input type="hidden" name="P_PACKAGE_CODE" id="P_PACKAGE_CODE" 	value="<%=packageCode%>" />	
	<input type="hidden" name="P_EFF_FROM_DT" id="P_EFF_FROM_DT" 	value="<%=fromDate%>" />	
	<input type="hidden" name="P_BLNG_CLASS" id="P_BLNG_CLASS" 	value="<%=blgClsCode%>" />
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	value="<%=facilityId%>" />
	<input type="hidden" name="P_CUST_CODE" id="P_CUST_CODE" 	value="<%=cust_code%>" />
	<input type="hidden" name="P_CUST_GRP_CODE" id="P_CUST_GRP_CODE" value="<%=cust_grp_code%>" />
	
</form>
</body>
</html>
<script>
	PkgCustBaseRun();
</script>


