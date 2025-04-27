<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

28/11/2019      IN059899        PRATHYUSHA                          JD-CRF-0200
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.Properties,  ePH.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../ePH/js/MedicationAdministrationRights.js'></script>
		<!--<script language="JavaScript" src="../../ePH/js/SsCommon.js"></script>-->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"
		</script>
	</head>
	<%
		String bean_id = "MedicationAdministrationRights";
		String bean_name = "ePH.MedicationAdministrationRightsBean";
		String mode = request.getParameter("mode");
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		ePH.MedicationAdministrationRightsBean MedicationAdministrationRightsBean = (ePH.MedicationAdministrationRightsBean) getBeanObject( bean_id,   bean_name,request);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			MedicationAdministrationRightsBean.clear();
		}
		System.out.println("getQueryString"+request.getQueryString());
	%>
	<iframe name="MedicationAdministrationRightsHeaderFrame" id="MedicationAdministrationRightsHeaderFrame" src="../../ePH/jsp/MedicationAdministrationRightsHeader.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' noresize style='height:20vh;width:98vw'></iframe>
	<iframe name="MedicationAdministrationRightsListFrame" id="MedicationAdministrationRightsListFrame" src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:75vh;width:98vw'></iframe>

<%
putObjectInBean(bean_id,MedicationAdministrationRightsBean,request);
%>

</html>

