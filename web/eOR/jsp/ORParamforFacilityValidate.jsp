<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String facility = request.getParameter( "facility_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String locType = request.getParameter("locType");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

//	out.println("alert("+facility+")");
	//OrParameterForFacilityBean beanObj = (OrParameterForFacilityBean)mh.getBeanObject( bean_id, request , "eOR.OrParameterForFacilityBean") ;
	 OrParameterForFacilityBean beanObj = (OrParameterForFacilityBean)getBeanObject( bean_id,  "eOR.OrParameterForFacilityBean", request ) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		out.println( "clearL2List('document') ; " ) ;

		ArrayList OrderTypeData = beanObj.getOtherLocationPrint(facility,locType) ;
		String[] record =null;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}OrderTypeData=null;
	}
	if ( validate.equals( "ord_cat1" ) ) {
		out.println( "clearDischgPatList('document') ; " ) ;

		//ArrayList OrderTypeData = beanObj.getDischgPatientPrint(facility) ;
		ArrayList OrderTypeData = beanObj.getOtherLocationPrint(facility,locType) ;
		String[] record=null;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			record = (String[])OrderTypeData.get(i);
			out.println( "addDischgPatList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}OrderTypeData=null;
	}

	putObjectInBean(bean_id,beanObj,request);
%>
