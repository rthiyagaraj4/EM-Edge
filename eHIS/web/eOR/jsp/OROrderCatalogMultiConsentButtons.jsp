<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.* ,java.util.*,eOR.Common.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OROrderCatalogMultiConsent.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script> 
		function callFormList()
		{
			var catalog_type = document.Order_Catalog_MultiConsent_Buttons.catalog_type.value;
			if(catalog_type=="V")
			{
				document.getElementById("testButton").style.visibility	= 'visible'
			}
			else
			{
				document.getElementById("testButton").style.visibility	= 'hidden'
			}
		}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="callFormList();">
<%

	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	if(mode==null)
	{
		mode = "2";
	}
	String bean_id = "Or_OrderCatalogMultiConsent" ;
	String bean_name = "eOR.OrderCatalogMultiConsent";

/* Mandatory checks end */
	
	// Initialize Function specific start 
	OrderCatalogMultiConsent bean = (OrderCatalogMultiConsent)getBeanObject( bean_id,bean_name,request ) ;  
	bean.clear() ;

	String catalogCode = request.getParameter("catalog_code");
	ArrayList catalogInfo = new ArrayList();
	catalogInfo = bean.getCatalogInfo(catalogCode);
	String catalog_type = (String) catalogInfo.get(0);
	//String consent_req_bef_order = (String) catalogInfo.get(1);
	//String consent_req_bef_regn = (String) catalogInfo.get(2);
%>

<form name='Order_Catalog_MultiConsent_Buttons' id='Order_Catalog_MultiConsent_Buttons'>
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="catalog_type" id="catalog_type" value="<%=catalog_type%>">
<INPUT TYPE="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=catalogCode%>">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>
	<td align ="right">
		<input align=right type="button" value="AddMoreRows" class="button" onClick="addMoreRows()" id="testButton" style="visibility:hidden">
		<input align=right type="button" value=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%> class="button" onClick="Record()">
		<input align=right type="button" value=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%> class="button" onclick='getCancel()'>
	</td>
</tr>
</table>
</form>
</body>
</html>

