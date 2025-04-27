
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,eOR.* "%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
//	String itemName = request.getParameter("itemName") ;
	String locationType = request.getParameter("locType");
	//out.println("Location Type :" + locationType);
	//OrderPrintRoutingBean  beanObj = (OrderPrintRoutingBean)mh.getBeanObject( bean_id, request , "eOR.OrderPrintRoutingBean") ;
	OrderPrintRoutingBean beanObj = (OrderPrintRoutingBean)getBeanObject( bean_id, "eOR.OrderPrintRoutingBean", request ) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
//		String name1 = (String)hash.get("itemName");
//itemName=itemName.trim();


//	if(  itemName.equals( "otherloc" )  )
	//		{
						out.println("clearLocationList('document');");
						//ArrayList  locationData = (ArrayList)beanObj.getLocationSpecific() ;
						ArrayList  locationData = (ArrayList)beanObj.getLocationSpecific(locationType) ;
 							for( int i=0 ; i< locationData.size() ; i++ ) {
								String[] record = (String[])locationData.get(i);
									out.println( "addLocation2List(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
								}

		//}
/*
		else{
		String location = (String)hash.get("otherlocdis") ;
		String facility_id=(String)hash.get("facility_id");

	//	if(location.equals("S")){
				out.println("clearLocationList1('document');");
				ArrayList locationData = (ArrayList)beanObj.getLocationSpecificForDisch(facility_id) ;
 					for( int i=0 ; i< locationData.size() ; i++ ) {
							String[] record = (String[])locationData.get(i);
								out.println( "addLocation2List1(\"" + record[1] + "\",\"" + record[0] + "\") ; " ) ;
		}

		//}
		}
	*/

	putObjectInBean(bean_id,beanObj,request);
%>
