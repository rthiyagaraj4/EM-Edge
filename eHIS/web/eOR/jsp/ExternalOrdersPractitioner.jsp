
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
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	//String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName = request.getParameter( "localeName" ) ;
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

		//ExternalOrdersBean beanObj = (ExternalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.ExternalOrdersBean") ;
		ExternalOrdersBean beanObj = (ExternalOrdersBean)getBeanObject( bean_id, "eOR.ExternalOrdersBean" , request) ;
		beanObj.setLanguageId(localeName);
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		 hash = (Hashtable)hash.get( "SEARCH" ) ;

		 String ref_facility_id = request.getParameter( "ref_facility_id" ) ;

		 out.println( "clearList() ; " ) ;
 

		ArrayList practType = beanObj.getPractitioner(ref_facility_id) ;
		 
		for( int i=0 ; i< practType.size() ; i++ ) {
			String[] record = (String[])practType.get(i);
			out.println( "addPractitionerList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
	  
		}

		putObjectInBean(bean_id,beanObj,request);

%>
