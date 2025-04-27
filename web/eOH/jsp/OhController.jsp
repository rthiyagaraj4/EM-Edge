<%@page  import="java.sql.*, java.util.*, java.io.*, eOH.Common.*, eOH.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<% 

	HashMap map = null; 
 try {
    
	request.setCharacterEncoding("UTF-8");
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash				= (Hashtable)hash.get( "SEARCH" );
	String bean_id		= (String) hash.get( "bean_id" );
	String bean_name	= (String) hash.get( "bean_name" );

	boolean local_ejbs	= false ;

  	OHAdapter beanObj = (OHAdapter)getBeanObject( bean_id, bean_name,  request) ; 
 
	
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



//		out.println("alert(\"map=" + map+ "\");") ; 

		if(map.get("invalidCode") != null)
         		 invalidCodeVal = (String) map.get( "invalidCode" ) ;

		//out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\" ) ; ") ;
		String flag =beanObj.replaceNewLineChar(beanObj.checkForNull((String) map.get( "flag" )));
		//out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\" ) ; ") ;
		out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"" + flag + "\","+ "\"" + invalidCodeVal +"\" ) ; ") ;

	}

	putObjectInBean(bean_id,beanObj,request);
}catch (Exception e) {
		out.println("alert(\"Exception from Contoller Jsp:" + e.toString() +  "\");") ;
		e.printStackTrace();
}

 
		
 
%>
 

