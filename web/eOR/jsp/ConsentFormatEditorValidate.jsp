<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	
	request.setCharacterEncoding("UTF-8");
	String bean_id	= request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	 
    ConsentFormat beanObj  = (ConsentFormat)getBeanObject( bean_id, bean_name ,request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	String html_format 	= beanObj.checkForNull((String)hash.get("html_format"),"") ;
 	//System.out.println("====html_format==="+html_format);
	beanObj.setConsentValues(html_format);
	beanObj.setDesc(html_format);
	
 
	putObjectInBean(bean_id,beanObj,request);
	
%>
