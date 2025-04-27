<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String category = request.getParameter("category");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

    if ( category == null || category.equals( "" ) )
		return ;

	ORReportsConsolidatedOrderList beanObj = (ORReportsConsolidatedOrderList)getBeanObject( bean_id , "eOR.ORReportsConsolidatedOrderList", request) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
	String order_category = "";
		if (category.equalsIgnoreCase("from")) {
			order_category = (String)hash.get("p_from_category") ;
			out.println( "clearL1List('document') ; " ) ;
		} else if (category.equalsIgnoreCase("to")) {
			order_category = (String)hash.get("p_to_category") ;
			out.println( "clearL2List('document') ; " ) ;
		}

		ArrayList OrderTypeData;

		if (order_category.equals("")) OrderTypeData = beanObj.getAllOrderType();
		else OrderTypeData = beanObj.getOrderTypeData(order_category) ;

		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			if (category.equalsIgnoreCase("from")) {
				out.println( "addOrderType1List(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			} else if (category.equalsIgnoreCase("to")) {
				out.println( "addOrderType2List(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
		}
	}putObjectInBean(bean_id,beanObj,request);
%>
