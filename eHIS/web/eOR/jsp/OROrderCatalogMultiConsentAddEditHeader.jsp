<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.* ,java.util.ArrayList,eOR.Common.*,eCommon.XSSRequestWrapper " %>
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


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%

	String bean_id = "Or_OrderCatalogMultiConsent" ;
	String bean_name = "eOR.OrderCatalogMultiConsent";

/* Mandatory checks end */
	
	// Initialize Function specific start 
	OrderCatalogMultiConsent bean = (OrderCatalogMultiConsent)getBeanObject( bean_id,bean_name,request ) ;  
	bean.clear() ;
	String categoryDesc = request.getParameter("categoryDesc");
	String orderTypeDesc = request.getParameter("orderTypeDesc");
	String catalogDesc = request.getParameter("catalog_desc");
	String catalogCode = request.getParameter("catalog_code");

	ArrayList catalogInfo = new ArrayList();
	String form_list = "";
	String consent_req_bef_order = "";
	String consent_req_bef_regn = "";


	catalogInfo = bean.getCatalogInfo(catalogCode);
	form_list = (String) catalogInfo.get(0);
	consent_req_bef_order = (String) catalogInfo.get(1);
	consent_req_bef_regn = (String) catalogInfo.get(2);

%>
<form name='Order_Catalog_MultiConsent_AddEdit' id='Order_Catalog_MultiConsent_AddEdit'>
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="categoryDesc" id="categoryDesc" value="<%=categoryDesc%>">
<INPUT TYPE="hidden" name="orderTypeDesc" id="orderTypeDesc" value="<%=orderTypeDesc%>">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
 	<tr id='divTitleTable1'>
		<td class="label">
		<%
		if(Integer.parseInt(consent_req_bef_order)>0 && Integer.parseInt(consent_req_bef_regn)==0)
		{
		%>
			<fmt:message key="eOR.ConsentDetailfortheCatalog.label" bundle="${or_labels}"/> - <B><%=catalogDesc%></B> ( <fmt:message key="eOR.BOReq.label" bundle="${or_labels}"/> - <B><%=consent_req_bef_order%></B>)
		<%
		}
		else if(Integer.parseInt(consent_req_bef_order)==0 && Integer.parseInt(consent_req_bef_regn)>0)
		{
		%>
			<fmt:message key="eOR.ConsentDetailfortheCatalog.label" bundle="${or_labels}"/> - <B><%=catalogDesc%> </B>( <fmt:message key="eOR.BRReq.label" bundle="${or_labels}"/> - <B><%=consent_req_bef_regn%></B>)
		<%
		}
		else
		{
		%>
			<fmt:message key="eOR.ConsentDetailfortheCatalog.label" bundle="${or_labels}"/> - <B><%=catalogDesc%> </B>( <fmt:message key="eOR.BOReq.label" bundle="${or_labels}"/> - <B><%=consent_req_bef_order%></B> <fmt:message key="eOR.andBRReq.label" bundle="${or_labels}"/> - <B><%=consent_req_bef_regn%></B>)
		<%
		}
		%>
		</td>
	</tr> 
</table>
<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center id="consent_details">
	<tr id='divTitleTable1'>
	<%
	if(form_list.equals("F"))
	{
	%>
		<td class="columnheadercenter" width="15%"><fmt:message key="eOR.OrderSeq.label" bundle="${or_labels}"/></td>
		<td class="columnheadercenter" width="41%"><fmt:message key="Common.Consent.label" bundle="${common_labels}"/></td>
		<td class="columnheadercenter" width="44%"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
	<%
	}
	else
	{
	%>
		<td class="columnheadercenter" width="9%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class="columnheadercenter" width="13%"><fmt:message key="eOR.OrderSeq.label" bundle="${or_labels}"/></td>
		<td class="columnheadercenter" width="28%"><fmt:message key="Common.Consent.label" bundle="${common_labels}"/></td>
		<td class="columnheadercenter" width="30%"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
		<td class="columnheadercenter" width="16%" align="center"><fmt:message key="eOR.DefaultForm.label" bundle="${or_labels}"/></td>
	<%
	}
	%>
	</tr>
</table>
</form>
</body>
</html>

