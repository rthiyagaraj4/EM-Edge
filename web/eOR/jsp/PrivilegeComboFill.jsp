<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%> 
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

	PrivilegeBean privilege = (PrivilegeBean)getBeanObject( bean_id.trim(),"eOR.PrivilegeBean",request) ;
	privilege.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
//	privilege.clearAll();
	
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	String privilege_ctx	=	"";
	String privilege_ctx_str=   "";

	try{
		privilege_ctx	=	(String)hash.get("privilege_ctx");


		if(privilege_ctx.trim().equalsIgnoreCase("P"))
			privilege_ctx_str = "responsibilty";
		else
			privilege_ctx_str = "relation";
		
		comboObjectString = (String)privilege.getComboOptions(privilege_ctx_str);

	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in CataLogSectionFill.jsp" + "<%=e.getMessage()%>");</script>
	<%}%>
	 
<%out.println("showPrevCtxHtml(\"" + privilege_ctx + "\",\"" + comboObjectString + "\" ) ; ");

 putObjectInBean(bean_id.trim(),privilege,request);%>
	
