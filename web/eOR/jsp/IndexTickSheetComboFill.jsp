
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter("bean_id") ;
	String comboObjectString = "";	

	IndexTickSheet beanObj = (IndexTickSheet)getBeanObject( bean_id.trim(),"eOR.IndexTickSheet",request);
	//beanObj.clear();
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	try
	{
		
	  comboObjectString = beanObj.getComboBoxHtml(hash);
	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in CataLogSectionFill.jsp" + "<%=e.getMessage()%>");</script>
	<%}%>
	 
	<%//%out.println("alert(\"sql" + beanObj.tempChk + "\");");%>
	<%//out.println("alert(\"option" + comboObjectString + "\");");%>
	
<%String  type = (String)hash.get("type") ;%>	 

<%if(type.trim().equalsIgnoreCase("OrderCategory")){
out.println("addComboObject(\"" + comboObjectString + "\",\"" + "order_category" + "\" ) ; ") ;}

		putObjectInBean(bean_id,beanObj,request);
 
%>
