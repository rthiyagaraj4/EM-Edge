<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ActivityTypeHeader.jsp -->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOR/js/OrderCatalogProcedureLink.js"></script>

	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	 function lockKey()
	  {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }
	</script>
</head>
<body onMouseDown="CodeArrest()"  onload="FocusFirstElement()" onKeyDown="lockKey()" >

<%try{
	/* Mandatory checks start */
	 request.setCharacterEncoding("UTF-8");
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_Order_Catalog_Procedure_Link" ;
	String bean_name = "eOR.OrderCatalogProcedureLink";
	/* Mandatory checks end */
	
	/*	Initialize Function specific start */
	
	OrderCatalogProcedureLink bean = (OrderCatalogProcedureLink)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode( mode ) ; 
	String order_catalog=request.getParameter("order_catalog");
	String order_catalog_code=request.getParameter("order_catalog_code");

	if (order_catalog==null) order_catalog="";
	if (order_catalog_code==null) order_catalog_code="";
	/* Initialize Function specific end */
%>
	<form name="OrderCatalogProcedureLinkHeader" id="OrderCatalogProcedureLinkHeader" method="post" >
	<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" height='100%' align="center">

	<tr>
	<td colspan="3"></td>
	</tr>
	
	<tr>
	<td  class='label' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class="fields">
	<input type='hidden'  name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>
	<input type='text'  name='order_catalog' id='order_catalog' value="<%=order_catalog%>"  size=40 maxlength=40 onBlur='javascript:before_show_order_catalog_window(this,order_catalog_code);'><input type='button' name='search' id='search' class='button'   value='?' onClick='javascript:show_order_catalog_window(order_catalog,order_catalog_code);'>
	<img src="../../eCommon/images/mandatory.gif">
	<input type="hidden" name="order_catalog_sql" id="order_catalog_sql" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROCEDURE_LINK_ORDER_CATALOG_LOOKUP")%>">
		<input type="hidden" name="temp_order_catalog" id="temp_order_catalog" value="">
	</td>
	</tr>

	<tr>
	<td colspan="3"></td>
	</tr>

	</table>

	
	<input type="hidden" name="function_id" id="function_id" value="Order_Catalog_Procedure_Link">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<!-- 	<input type="hidden" name="order_category_desc" id="order_category_desc" value="">
 -->		
<%
	//	putObjectInBean(bean_id,bean,request);
 
}catch(Exception e){
	e.printStackTrace();
	System.err.print("exception in OrderCatalogProcedureAddModifyHeader.jsp="+e);
}
	%>

</form>
</body>
</html>

