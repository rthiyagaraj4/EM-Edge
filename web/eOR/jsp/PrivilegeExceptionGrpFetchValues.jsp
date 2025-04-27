<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter("bean_id") ;
	String comboObjectString = "";	

	PrivilegeExceptionGrpBean beanObj = (PrivilegeExceptionGrpBean)getBeanObject( bean_id.trim(),"eOR.PrivilegeExceptionGrpBean",request);
	beanObj.clear();
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	hash.put("populate", "list");	
	try{
		comboObjectString = beanObj.getComboBoxHtml(hash);
	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in PrivilegeExceptionGrpFetchValues.jsp" + "<%=e.getMessage()%>");</script>
	<%}%>
	 
	<%//%out.println("alert(\"sql" + beanObj.tempChk + "\");");%>
	<%//out.println("alert(\"option" + comboObjectString + "\");");%>
	
	<%String  type = (String)hash.get("type") ;%>	 

	<%if(type.trim().equalsIgnoreCase("OrderCategory")){
	out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_category" + "\" ) ; ") ;
	}

	putObjectInBean(bean_id.trim(),beanObj,request);
%>


