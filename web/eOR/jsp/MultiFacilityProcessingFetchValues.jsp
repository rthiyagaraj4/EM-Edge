
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"%> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String default_val = request.getParameter("default_val");
	String bean_id = request.getParameter("bean_id") ;
	String comboObjectString = "";	

	MultiFacilityProcessingBean beanObj = (MultiFacilityProcessingBean)getBeanObject( bean_id.trim(),"eOR.MultiFacilityProcessingBean",request);
	beanObj.clear();
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	try{
		comboObjectString = beanObj.getComboBoxHtml(hash,default_val.trim());
	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in CataLogSectionFill.jsp" + "<%=e.getMessage()%>");</script>
	<%}%>
	 
	
	<%String  type = (String)hash.get("type") ;%>
		<%if(type.trim().equalsIgnoreCase("OrderCategory")){
	out.println("addComboObject(\""+comboObjectString+ "\",\""+"order_category"+"\" ) ; ") ;
	}else if(type.trim().equalsIgnoreCase("OrderingFacID")){
	out.println("addComboObject(\""+comboObjectString+"\",\""+"performing_facility_id"+"\" ) ; ") ;
	}

	putObjectInBean(bean_id,beanObj,request);
%>


