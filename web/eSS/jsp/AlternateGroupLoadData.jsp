<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* "%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = "AlternateGroupBean" ;
	String bean_name = "eSS.AlternateGroupBean";
	AlternateGroupBean bean = (AlternateGroupBean) getBeanObject( bean_id,  bean_name, request ) ;  
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	
	String group_code		=	request.getParameter( "group_code" ) ==null?"":request.getParameter( "group_code" );
	String group_type		=	request.getParameter( "group_type" ) ==null?"":request.getParameter( "group_type" );
	String usage_desc		=	request.getParameter( "usage_desc" ) ==null?"%":request.getParameter( "usage_desc" );
	String surgery_type		=	request.getParameter( "surgery_type" ) ==null?"%":request.getParameter( "surgery_type" );
	
	
	bean.setGroup_code(group_code) ; 
	bean.setGroup_type(group_type) ;
    bean.setUsage_code(usage_desc) ;
	bean.setSurgery_code(surgery_type) ;
	
	bean.loadData(group_code,group_type,usage_desc,surgery_type) ;

	putObjectInBean(bean_id,bean,request);
%>
