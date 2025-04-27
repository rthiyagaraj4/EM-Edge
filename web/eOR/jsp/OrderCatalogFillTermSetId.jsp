<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	
	
	OrderCatalogBean  beanObj = (OrderCatalogBean)getBeanObject( bean_id , "eOR.OrderCatalogBean", request) ;
	
	//Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   // hash = (Hashtable)hash.get( "SEARCH" );
	//out.println("hash="+hash);

	//out.println("<script>alert('inside the intermediate jsp')</script>");

		//String order_category = (String)hash.get("order_category") ;
		out.println("clearProcTermSetIdList('document');");
	
		ArrayList TermSetID = (ArrayList)beanObj.populateTermSetID() ;
		String[] record =null;
 		for( int i=0 ; i< TermSetID.size() ; i++ ) {
			record = (String[])TermSetID.get(i);
			out.println( "addProcTermSetIdList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}TermSetID=null;

		//putObjectInBean(bean_id,beanObj,request);
	
%>
