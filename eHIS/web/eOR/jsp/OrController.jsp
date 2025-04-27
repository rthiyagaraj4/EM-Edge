
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<% 

	HashMap map = null; 
 try {
    
	request.setCharacterEncoding("UTF-8");
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	//System.out.println("hash == "+hash);
	System.out.println("Hash @@@@@@@@@@@@@@@ " + hash);
    hash				= (Hashtable)hash.get( "SEARCH" );
	String bean_id		= (String) hash.get( "bean_id" );
	String bean_name	= (String) hash.get( "bean_name" );

	//System.out.println("===localeName==="+localeName+"=====");
	//System.out.println("===localeName==hash="+hash.get( "locale" )+"=====");
	boolean local_ejbs	= false ;
	/*Added by Parimala*/
		 hash.put("HttpRequest", request) ;		//Ramesh
		 hash.put("HttpResponse", response) ;	//Ramesh
	/*Ends Here*/
	//	out.println("alert(\"bean name =" + bean_name+ "\");") ;   
	//	out.println("alert(\"hash =" + hash + "\");") ; 

  	OrAdapter beanObj = (OrAdapter)getBeanObject( bean_id, bean_name,  request) ; 
 
	
	//out.println("alert(\"name =" + beanObj+ "\");") ; 
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

//	out.println("alert(\"validated :: =" + validated+ "\");") ; 
//	out.println("alert(\"map :: =" + map+ "\");") ; 
	
	map.put( "message",beanObj.getMessage((String)map.get( "message" ))) ;
	//map.put( "message",(String)map.get( "message" )) ;

	String validationMessage = map.get("message") == null ? "" :(String)map.get("message")  ;
	validationMessage = beanObj.replaceNewLineChar( validationMessage );
	//validationMessage = validationMessage.replaceAll(",","-");

	if ( validated ){
		map = beanObj.apply() ;	



    //    out.println("alert(\"map inside :: =" + map+ "\");") ; 

		boolean result = ((Boolean) map.get( "result" )).booleanValue() ;


//		out.println("alert(\"result here> =" + result+ "\");") ; 
//		out.println("alert(\"message here> =" + (String)map.get( "message" )+ "\");") ; 
		map.put( "message",beanObj.getMessage((String)map.get( "message" ))) ;
		//map.put( "message",(String)map.get( "message" )) ;


		String message = beanObj.replaceNewLineChar(beanObj.checkForNull((String)map.get("message")));
		//message = message.replaceAll(",", "-");
		//message ="*"+message;

		//String traceVal =	 beanObj.replaceNewLineChar(beanObj.checkForNull((String) map.get( "traceVal" )));
		String invalidCode = "" ;
       
		if(map.get("invalidCode") != null)
            		invalidCode = (String) map.get( "invalidCode" ) ;

	//	out.println("alert(\"Message : " + message + "\");") ;// 6 th alert

		String flag =beanObj.replaceNewLineChar(beanObj.checkForNull((String) map.get( "flag" )));
		//out.println("assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;	
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
		//out.println("alert(\"Exception from Contoller Jsp:" + e.toString() +  "\");") ;//COMMON-ICN-0181
		e.printStackTrace();
}

 
		
 
%>
 

