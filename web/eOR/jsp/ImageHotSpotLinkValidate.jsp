
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
			<%/*	out.println( "clearL2List('document') ; " ) ;

				ArrayList OrderTypeData = beanObj.getOrderTypeData(order_category) ;
				for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
					String[] record = (String[])OrderTypeData.get(i);
					out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}*/%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	if ( validate == null || validate.equals( "" ) ) 
		return ;

	ImageHotSpotLinkBean beanObj = (ImageHotSpotLinkBean)getBeanObject( bean_id , "eOR.ImageHotSpotLinkBean", request) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		String image_id = (String)hash.get("image") ;
		//out.println( "clearL2List('document') ; " ) ;

		ArrayList OrderTypeData = beanObj.getHotSpotNames(image_id) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} 
	putObjectInBean(bean_id,beanObj,request);
%>
