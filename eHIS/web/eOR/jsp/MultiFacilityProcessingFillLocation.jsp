
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*, webbeans.eCommon.* "%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8"); 
	String bean_id = request.getParameter( "bean_id" ) ;
	String itemName = request.getParameter("itemName") ;
    String code = request.getParameter("code") ;
	String facility_id = request.getParameter("facility_id");
	String locationType = request.getParameter("locType");
	String order_type_code = request.getParameter("order_type_code");
	String default_val = request.getParameter("default_val");

	
	//out.println("Location Type :" + locationType);
	MultiFacilityProcessingBean  beanObj = (MultiFacilityProcessingBean)getBeanObject( bean_id , "eOR.MultiFacilityProcessingBean", request) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	//String locationType = (String)hash.get("source_location_code");
	//String facility_id = (String)hash.get("ordering_facility_id");
	//out.println(locationType);
	try {
		if (itemName.equals("source_type_code")) {
			ArrayList  locationData = (ArrayList)beanObj.getLocationSpecific(locationType,facility_id) ;
		    //ArrayList  locationData = (ArrayList)beanObj.getLocationSpecific(locationType) ;
		    //out.println("alert('"+locationData.size()+"')");
		    out.println("clearLocationList('document');");
		 	for( int i=0 ; i< locationData.size() ; i++ ) {
				String selected = "false";
				String[] record = (String[])locationData.get(i);
			
				if(record[0].toString().trim().equalsIgnoreCase(default_val.trim())) {selected="true";}
				out.println( "addLocation2List(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
			}locationData=null;
		} 
		else if (itemName.equals("performing_facility_id")) {

			if(order_type_code.equals("ALL"))
			{
             //System.out.println("@@@@@order_type_code: "+order_type_code);

				 ArrayList  locationData1 = (ArrayList)beanObj.getPerformingLocn1(locationType,facility_id);
			
				 out.println("clearPerformLocn('document');");
				 for( int i=0 ; i< locationData1.size() ; i++ ) 
				{
					
					String[] record = (String[])locationData1.get(i);
					
					out.println( "addPerformLocn2List(\"" + record[1] + "\",\"" + record[0] + "\") ; " ) ;
				}locationData1=null; 
          
			}   

           else
		   {
			   ArrayList  locationData = (ArrayList)beanObj.getPerformingLocn(locationType,facility_id,code);//,order_type_code);
				//out.println("alert('"+locationData.size()+"')");
				out.println("clearPerformLocn('document');");
				for( int i=0 ; i< locationData.size() ; i++ ) 
				{
					String[] record = (String[])locationData.get(i);
					out.println( "addPerformLocn2List(\"" + record[1] + "\",\"" + record[0] + "\") ; " ) ;
				}locationData=null;  
			}
		}   
		putObjectInBean(bean_id,beanObj,request);
	} catch (Exception e) {
		System.out.println("exception:"+e.getMessage());
	}

%>
