<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id		= "DispatchBean" ;
	String bean_name	= "eSS.DispatchBean";
	DispatchBean bean	= (DispatchBean)getBeanObject( bean_id, bean_name , request ) ;  
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	if(request.getParameter("function_id").equals("dispatch_add_modify")){
	String rof_doc_type_code		=	request.getParameter( "rof_doc_type_code" ) ==null?"":request.getParameter( "rof_doc_type_code" );
	String rof_doc_no	=	request.getParameter( "rof_doc_no" ) ==null?"":request.getParameter( "rof_doc_no" );
	String doc_date		=	request.getParameter( "doc_date" ) ==null?"":request.getParameter( "doc_date" );
	String store_code	=	request.getParameter( "store_code" ) ==null?"":request.getParameter( "store_code" );
	String location		=	request.getParameter( "location" ) ==null?"":request.getParameter( "location" );
	String doc_ref		=	request.getParameter( "doc_ref" ) ==null?"":request.getParameter( "doc_ref" );
	

	bean.setStore_code(store_code) ;
	bean.setRof_doc_type_code(rof_doc_type_code) ;
	bean.setRof_doc_no(rof_doc_no) ;
	bean.setDoc_date(doc_date) ;
	bean.setDoc_ref(doc_ref) ;
	bean.setLocation(location) ;
	
	
	bean.loadData();

	}
	putObjectInBean(bean_id, bean ,request);


%>
