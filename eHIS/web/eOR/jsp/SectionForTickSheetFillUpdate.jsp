<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*" %> 
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
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString(request) ;
    hash = (Hashtable)hash.get("SEARCH");

		ArrayList UpdateData=new ArrayList();

		UpdateData.add((String)hash.get("order_category"));
		UpdateData.add((String)hash.get("tick_sheet_id") );
		UpdateData.add((String)hash.get("section_code") );
//out.println("alert(\"validated=" +"inside fill update" + "\");") ; 
//		out.println("clearTickSheetSectionList('document');");
	
	String[] UpdateData1=new String[2];
		
	 UpdateData1 = (String[])beanObj.loadData(UpdateData) ;
 	
	//	out.println("alert(\"after load data method=" + TickSheetUpdateData.size()+ "\");") ; 
		
out.println( "AssignDesc(\"" + (String)UpdateData1[0] + "\",\"" + (String)UpdateData1[1] + "\") ; " ) ;
UpdateData1=null;

putObjectInBean(bean_id,beanObj,request);
		
	
%>
