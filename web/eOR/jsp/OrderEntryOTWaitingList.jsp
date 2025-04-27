
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
	request.setCharacterEncoding("UTF-8");
	String order_id 			= CommonBean.checkForNull(request.getParameter("order_id"),"");
	//String practitioner_id 		= CommonBean.checkForNull(request.getParameter("practitioner_id"),"");
	//String pref_surg_date 		= CommonBean.checkForNull(request.getParameter("pref_surg_date"),"");
	//String practitioner_name 	= CommonBean.checkForNull(request.getParameter("practitioner_name"),"");
   String localeName=request.getParameter("localeName");
   	  beanQueryObj.setLanguageId(localeName);

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;
 
	Properties properties		= (Properties)session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	
	String  login_user		    = CommonBean.checkForNull((String)session.getValue( "login_user" ),"MEDICOM" ) ; // Default Medicom
	String  login_ws_no		    = CommonBean.checkForNull(properties.getProperty( "client_ip_address" ),"MEDICOM" ) ; // Default Medicom

	// Call a procedure to execute, if any error, display the message
   	String error_message		= beanQueryObj.checkForNull(beanQueryObj.callOTWaitingList(properties,login_user,login_ws_no,order_id),"");  
	if(!error_message.equals(""))	{ 
 		out.println( "displayOTWaitingError(\""+error_message+"\"); ")  ;
	}

	// Clear the values
	if(hash!=null)
		hash.clear();
			 
%>
