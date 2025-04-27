
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	//OrderPrintRoutingBean beanObj = (OrderPrintRoutingBean)mh.getBeanObject( bean_id, request , "eOR.OrderPrintRoutingBean") ;
	 OrderPrintRoutingBean beanObj = (OrderPrintRoutingBean)getBeanObject( bean_id, "eOR.OrderPrintRoutingBean", request ) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "order_category" ) ) {
		String order_category = (String)hash.get("order_category") ;
		out.println( "clearList('document') ; " ) ;

		//ArrayList print_order = beanObj.getPrintOrders(order_category) ;
		ArrayList print_order = beanObj.getOrderTypeData(order_category);
		for( int i=0 ; i< print_order.size() ; i++ ) {
			String[] record = (String[])print_order.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} else if (validate.equals("order_type_code")) {
		String order_type_code = (String)hash.get("order_type_code");
		String facility_id = (String)hash.get("facility_id");

		order_type_code = (order_type_code == null) ? "" : order_type_code;
		facility_id = (facility_id == null) ? "" : facility_id;

		out.println("clearPerformingLocnList('document');");

		ArrayList PerformingLocn = beanObj.getPerformingLocn(order_type_code,facility_id);
		for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
			String[] record = (String[])PerformingLocn.get(i);
			out.println("addPerformingLocnList(\"" + record[1] + "\",\"" + record[0] + "\");");
		}

	}

	putObjectInBean(bean_id,beanObj,request);
%>
