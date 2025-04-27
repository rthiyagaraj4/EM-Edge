<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
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
    String localeName= request.getParameter( "localeName" ) ;
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	if ( validate == null || validate.equals( "" ) ) 
		return ;

	ConsignOrders beanObj = (ConsignOrders)getBeanObject( bean_id,"eOR.ConsignOrders", request ) ;
    beanObj.setLanguageId(localeName);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		String locn_type = (String)hash.get("location_type") ;
		out.println( "clearList('document') ; " ) ;
		
	//	out.println( "alert(\"" + locn_type + "\") ; " ) ;

		ArrayList OrderTypeData = beanObj.getLocation(locn_type,practitioner_id,facility_id) ;
		//out.println( "alert(\"" + beanObj.chk+ "\") ; " ) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}
	putObjectInBean(bean_id,beanObj,request);
%>
