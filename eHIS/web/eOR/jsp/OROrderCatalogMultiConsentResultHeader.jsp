<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ; 
	String bean_id = "Or_OrderCatalogMultiConsent" ; 
	String bean_name = "eOR.OrderCatalogMultiConsent";

/* Mandatory checks end */
	
	// Initialize Function specific start 
	OrderCatalogMultiConsent bean = (OrderCatalogMultiConsent)getBeanObject( bean_id,bean_name,request ) ;  
	bean.clear() ;
	ArrayList cataloguesData = new ArrayList();
	//cataloguesData = (ArrayList) session.getAttribute("CATALOGUES_DATA");
	cataloguesData = bean.getCatalogues_data();
	
	if(cataloguesData==null) cataloguesData = new ArrayList();
	String[] orMultiConsent = null;
	String categoryDesc = "";
	String orderTypeDesc = "";
	for(int i=0;i<cataloguesData.size();i++)
	{
		orMultiConsent = (String[]) cataloguesData.get(i);
		categoryDesc = orMultiConsent[0];
		orderTypeDesc =  orMultiConsent[1];
		break;
	}
%>
<form name='Order_Catalog_MultiConsent_Result' id='Order_Catalog_MultiConsent_Result'>
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="category_desc" id="category_desc" value="<%=categoryDesc%>">
<INPUT TYPE="hidden" name="order_type_desc" id="order_type_desc" value="<%=orderTypeDesc%>">
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="100%" align=center>
 	<tr>
		<td colspan="4" class="labelleft"><fmt:message key="eOR.CatalogListfortheOrderCategory.label" bundle="${or_labels}"/> - <B><%=categoryDesc%></B> <fmt:message key="eOR.andOrderType.label" bundle="${or_labels}"/> - <B><%=orderTypeDesc%> </B></td>
	</tr>  
	<tr>
		<td class="columnheader" width='48%'><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width='50%'><fmt:message key="eOR.DefinitionExists.label" bundle="${or_labels}"/></td>
	</tr>
</table>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

