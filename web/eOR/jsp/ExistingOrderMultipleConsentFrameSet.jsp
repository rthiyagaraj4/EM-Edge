<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
Started Consent Details in Existing Order on July 16th 2007 by Anjaneya Prasad
-->
<!-- 
-----------------------------------------------------------------------
Date       	Edit History      	Name        		Description
-----------------------------------------------------------------------
?             	100            	?           		created
20/02/2012		IN037398		Chowminya G			System displays as "Consent Required"
-----------------------------------------------------------------------
-->
<%@page import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
  <head>
  <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String orderId = request.getParameter("order_id");
	String val1 = request.getParameter("order_category");
	String ord_typ_code = request.getParameter("ord_typ_code");
	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";
	ConsentOrders bean		= (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	 bean.setLanguageId(localeName);
	 bean.clearHasp();
	String queryString="&orderId="+orderId+"&val1="+val1+"&ord_typ_code="+ord_typ_code;
	// Changed the label from ConsentRequiredfor to ConsentDetails IN037398
	if(request.getParameter("viewBy").equals("line")){%>
<title>
<fmt:message key="eOR.ConsentDetails.label" bundle="${or_labels}"/>- <%=request.getParameter("order_catalog_desc")%>
</title>
		<%}else
		{%>
<title>
<fmt:message key="eOR.ConsentDetails.label" bundle="${or_labels}"/> 
</title>
<%}%>
  </head>
  <%
  String viewBy	  = request.getParameter("viewBy");
	viewBy			  = (viewBy == null) ? "":viewBy;
	%>
	<iframe name="multi_title" id="multi_title" src="../../eOR/jsp/ViewOrderTop.jsp?<%=queryString%><%=request.getQueryString()%>&function_from=ExistingMultiConsent" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="multi_title" NORESIZE style="height:30vh;width:99vw"></iframe>
	<iframe name="multi_title" src="../../eOR/jsp/ExistingOrderMultipleConsentHeader.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="multi_title" id="multi_title" NORESIZE style="height:6vh;width:99vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" frameborder=0  marginheight=0 marginwidth=0 name="multi_detail" id="multi_detail" SCROLLING="auto" NORESIZE style="height:54vh;width:100vw;MARGIN-TOP:-21PX"></iframe>
	<iframe src="../../eCommon/html/blank.html" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="multi_btn" id="multi_btn" NORESIZE style="height:10vh;width:99vw"></iframe>
	
</html>

<%putObjectInBean(bean_id,bean,request);%>

