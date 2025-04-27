<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../ePO/js/FacilityForPurchaseUnit.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/common/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"
		</script>
</head>

	<%
		String bean_id		= "facilityForPurchaseUnitBean";
		String bean_name	= "ePO.FacilityForPurchaseUnitBean";
		String mode			= request.getParameter("mode");
 
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		ePO.FacilityForPurchaseUnitBean facilityForPurchaseUnitBean = (ePO.FacilityForPurchaseUnitBean)getBeanObject( bean_id, bean_name, request );
		facilityForPurchaseUnitBean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			facilityForPurchaseUnitBean.clear();
		}
	%>
	<%
		putObjectInBean(bean_id,facilityForPurchaseUnitBean,request);
	%>
	
	<iframe name="FacilityForPurchaseUnitHeaderFrame" id="FacilityForPurchaseUnitHeaderFrame" src="../../ePO/jsp/FacilityForPurchaseUnitHeader.jsp?<%=request.getQueryString()%>"  scrolling='no' noresize  style="height:30vh;width:100vw"></iframe>
	<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
    <iframe name="FacilityForPurchaseUnitListFrame" id="FacilityForPurchaseUnitListFrame" src="../../ePO/jsp/FacilityForPurchaseUnitDetail.jsp?<%=request.getQueryString()%>" scrolling='auto' noresize  style="height:85vh;width:70vw"></iframe>
    <% } else { %>

	<iframe name="FacilityForPurchaseUnitListFrame" id="FacilityForPurchaseUnitListFrame" src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" scrolling='auto' noresize  style="height:85vh;width:70vw"></iframe>
	<% } %>



</html>

