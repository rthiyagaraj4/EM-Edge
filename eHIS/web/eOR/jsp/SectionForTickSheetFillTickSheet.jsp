<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.*, eOR.Common.*, eOR.*" %>
<%-- change effected --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	
	SectionForTickSheet  beanObj = (SectionForTickSheet)getBeanObject( bean_id , "eOR.SectionForTickSheet", request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

		String order_category_id = (String)hash.get("order_category") ;
		out.println("clearTickSheetSectionList('document');");

		ArrayList TickSheetData = (ArrayList)beanObj.getTickSheetSectionTickSheet(order_category_id) ;
		String[] record =null;

		for( int i=0 ; i< TickSheetData.size() ; i++ ) {
			record = (String[])TickSheetData.get(i);
			out.println( "addTickSheet2List(\"" + record[1] + "\",\"" + record[0] + "\") ; " ) ;
		}TickSheetData=null;

		putObjectInBean(bean_id,beanObj,request);
	
%>
