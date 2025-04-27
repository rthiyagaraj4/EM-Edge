<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.ArrayList, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	if ( validate == null || validate.equals( "" ) ) 
		return ;

	MultiPatientOrdersResultingBean beanObj = (MultiPatientOrdersResultingBean)getBeanObject( bean_id,bean_name,request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	ArrayList typeData = new ArrayList();
	if(validate.equals("locn_type"))
	{
		String locn_type = (String)hash.get("location_type") ;
			
		typeData = beanObj.getLocations(locn_type,practitioner_id,facility_id) ;
		for( int i=0 ; i< typeData.size() ; i++ ) 
		{
			String[] record = (String[])typeData.get(i);
			out.println( "addLocationList(\"" +record[0]+" \",\"" +record[1]+"\") ; " ) ;
		}
	}
	else if(validate.equals("order_type"))
	{
		String order_category = (String)hash.get("order_category") ;
			
		typeData = beanObj.getOrderTypes(order_category) ;
		for( int i=0 ; i< typeData.size() ; i++ ) 
		{
			String[] record = (String[])typeData.get(i);
			out.println( "addOrderTypeList(\"" +record[0]+" \",\"" +record[1]+"\") ; " ) ;
		}
	}
%>
