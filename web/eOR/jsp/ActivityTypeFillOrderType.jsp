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
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	
	String bean_id = request.getParameter( "bean_id" ) ;
	
	
	ActivityType  beanObj = (ActivityType)getBeanObject( bean_id , "eOR.ActivityType", request) ;
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	//out.println("hash="+hash);

	//out.println("<script>alert('inside the intermediate jsp')</script>");

		String order_category = (String)hash.get("order_category") ;
		out.println("clearOrderTypeList('document');");
	
		ArrayList OrderTypeData = (ArrayList)beanObj.getOrderType(order_category) ;
		String[] record =null;
 		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			record = (String[])OrderTypeData.get(i);
			out.println( "addOrderType2List(\"" + record[1] + "\",\"" + record[0] + "\") ; " ) ;
		}OrderTypeData=null;

		//putObjectInBean(bean_id,beanObj,request);
	
%>
