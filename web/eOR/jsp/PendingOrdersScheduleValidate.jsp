
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* " contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="beanQuery" scope="page" class="eOR.QueryBean"/>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%				request.setCharacterEncoding("UTF-8");

	String bean_id 			= request.getParameter( "bean_id" ) ;
	String validate 		= request.getParameter( "validate" ) ;
	//String flag				= request.getParameter("flag");
	String default_val		= request.getParameter("default_val");
	String default_val1		= request.getParameter("default_val1");
	String default_val2		= request.getParameter("default_val2");
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String localeName       = request.getParameter("localeName");

    beanQuery.setLanguageId(localeName);
	//String practitioner_id	= (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	//String resp_id 			= (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	default_val				= (default_val == null) ? "" : default_val;
	default_val1			= (default_val1 == null) ? "" : default_val1;
	default_val2			= (default_val2 == null) ? "" : default_val2;

//	PatOrderByPrivRelnBean  beanObj = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request , "eOR.PatOrderByPrivRelnBean") ;
//	 PatOrderByPrivRelnBean beanObj = (PatOrderByPrivRelnBean)getBeanObject( bean_id, "eOR.PatOrderByPrivRelnBean", request ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		//String orderCategory = (String)hash.get("order_category") ;
		//ArrayList order_category = beanObj.getOrderCategory();
		ArrayList order_category = beanQuery.getOrderCat(facility_id, properties);
		for( int i=0 ; i< order_category.size() ; i++ ) {
			String[] record = (String[])order_category.get(i);
			out.println( "addCategoryList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		
	}else if ( validate.equals( "order_type" ) ) {
		String order_category = (String)hash.get("order_category") ;
		if ( order_category == null || order_category.equals( "" ) )
			order_category="";

		out.println( "clearOrderTypeList('document') ; " ) ;
		
		ArrayList OrderTypeData = beanQuery.getOrderTypeSpecimen(order_category, properties) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		
		}
		String order_type = "" ;
		out.println( "clearActivityTypeList('document'); " ) ;

		ArrayList ActivityType = beanQuery.getActivityType(order_category, order_type, properties);
		for( int i=0 ; i< ActivityType.size() ; i++ ) {
			String[] record = (String[])ActivityType.get(i);
						
			out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			
		}

	} else if ( validate.equals( "activity_type" ) ) {
		//String order_category = request.getParameter("order_category");
		//String order_type = request.getParameter("order_type") ;
		String order_category= (String)hash.get("order_category") ;
		String order_type =  (String)hash.get("order_type") ;

		out.println( "clearActivityTypeList('document'); " ) ;

		ArrayList ActivityType = beanQuery.getActivityType(order_category, order_type, properties);
		for( int i=0 ; i< ActivityType.size() ; i++ ) {
			String[] record = (String[])ActivityType.get(i);
			out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}else if(validate.equals("patient_class")){

		ArrayList patientClass = beanQuery.getPatientClass(properties);
		for( int i=0 ; i< patientClass.size() ; i++ ) {
			String[] record = (String[])patientClass.get(i);
			out.println( "addPatClass(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}else if ( validate.equals( "perform_locn" ) ) {
		
		ArrayList performing_location = beanQuery.getPerformingLocation(facility_id, properties);
		for( int i=0 ; i< performing_location.size() ; i++ ) {
			String[] record = (String[])performing_location.get(i);
			out.println( "addPerfLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		
	}
	
//	putObjectInBean(bean_id,beanObj,request);
%>
