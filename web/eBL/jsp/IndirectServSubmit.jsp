<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*, eBL.*,eBL.Common.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<% 

	HashMap map = null; 
 try {
    
	request.setCharacterEncoding("UTF-8");
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	System.out.println("Hash @@@@@@@@@@@@@@@ " + hash);
    hash				= (Hashtable)hash.get( "SEARCH" );
	String bean_id		= (String) hash.get( "bean_id" );
	String bean_name	= (String) hash.get( "bean_name" );

	boolean local_ejbs	= false ;
	hash.put("HttpRequest", request) ;		
	hash.put("HttpResponse", response) ;	
	
  	BlAdapter beanObj = (BlAdapter)getBeanObject( bean_id, bean_name,  request) ; 
 
	
	hash.remove( "bean_id" ) ;
	hash.remove( "bean_name" );

	// Set the mode for Local Ejb or Remote Ejb

 	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
		local_ejbs = true;
 
	beanObj.setLocalEJB(local_ejbs);
	// Set Id, Ws No, Date, Facility start 
	beanObj.setLoginById( (String) session.getValue( "login_user" ) ) ;
	beanObj.setLoginAtWsNo( beanObj.getProperties().getProperty( "client_ip_address" ) ) ;
	beanObj.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
  	if((String) hash.get( "mode" )!=null)
		beanObj.setMode( (String) hash.get( "mode" )) ;

	if((String) hash.get( "locale" )!=null)
		beanObj.setLanguageId( (String) hash.get( "locale" ) ) ;
	else
		beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;

 	beanObj.setAll(hash) ;
 
 	map = beanObj.validate() ;

		
	boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;

	map.put( "message",beanObj.getMessage((String)map.get( "message" ))) ;

	String validationMessage = map.get("message") == null ? "" :(String)map.get("message")  ;
	validationMessage = beanObj.replaceNewLineChar( validationMessage );
	if ( validated ){
		map = beanObj.apply() ;	

		boolean result = ((Boolean) map.get( "result" )).booleanValue() ;

		map.put( "message",beanObj.getMessage((String)map.get( "message" ))) ;
		

		String message = beanObj.replaceNewLineChar(beanObj.checkForNull((String)map.get("message")));
		
		
		String invalidCode = "" ;
       
		if(map.get("invalidCode") != null)
            		invalidCode = (String) map.get( "invalidCode" ) ;

		String flag =beanObj.replaceNewLineChar(beanObj.checkForNull((String) map.get( "flag" )));
		out.println("assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" , \"" + invalidCode.trim() + "\") ; ") ;
	} else {
		
		String invalidCodeVal = "" ;

		if(map.get("invalidCode") != null)
         		 invalidCodeVal = (String) map.get( "invalidCode" ) ;

		String flag =beanObj.replaceNewLineChar(beanObj.checkForNull((String) map.get( "flag" )));
		out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"" + flag + "\","+ "\"" + invalidCodeVal +"\" ) ; ") ;
	}

	putObjectInBean(bean_id,beanObj,request);
}catch (Exception e) {
		out.println("alert(\"Exception from Contoller Jsp:" + e.toString() +  "\");") ;
		e.printStackTrace();
}

 
		
 
%>
 

