
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>


<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
     request.setCharacterEncoding("UTF-8");	
	String bean_id = request.getParameter("bean_id") ;
//	String function_id = request.getParameter("function_id");
	String comboObjectString = "";
	String comboObjectString1= "";

	OrderablePerformingLocationBean OrderableBean = (OrderablePerformingLocationBean)getBeanObject(bean_id.trim(),"eOR.OrderablePerformingLocationBean",request);
	OrderableBean.clearAll();

	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	try
	{

	  comboObjectString = OrderableBean.getComboBoxHtml(hash);

	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in OrderablePerformingLocationComboFill.jsp" + "<%=e.getMessage()%>");</script>
	<%}%>



<%String  type = (String)hash.get("type") ;%>


<%if(type.trim().equalsIgnoreCase("locationCode")) {
out.println("addComboObject(\"" + comboObjectString + "\",\"" + "location_type" + "\" ); ");}%>

<%if(type.trim().equalsIgnoreCase("orderType")) {
out.println("addComboObject(\"" + comboObjectString1 + "\",\"" + "location_code" + "\" ); ");}%>
<%
	try {
		hash.remove("type");
		hash.put("type","orderType");
		comboObjectString1 = OrderableBean.getComboBoxHtml(hash);
	}catch(Exception e) {%>
	<script>alert("Exception thrown ...Chk1 in OrderablePerformingLocationComboFill.jsp" + "<%=e.getMessage()%>");</script>
<%}%>
<%type = (String)hash.get("type") ;%>


<%if(type.trim().equalsIgnoreCase("locationCode")) {
out.println("addComboObject(\"" + comboObjectString + "\",\"" + "location_type" + "\" ); ");}%>

<%if(type.trim().equalsIgnoreCase("orderType")) {
out.println("addComboObject(\"" + comboObjectString1 + "\",\"" + "location_code" + "\" ); ");}

putObjectInBean(bean_id,OrderableBean,request);
%>
