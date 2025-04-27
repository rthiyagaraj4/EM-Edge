<%@ page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
try {
    Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ; 
    hash = (Hashtable)hash.get( "SEARCH" ) ;
    StringTokenizer token		=	null;//ADDED FOR TH-KW-CRF-0020.3
    String dispNo="";//ADDED FOR TH-KW-CRF-0020.3
    String bean_id = (String) hash.get( "bean_id" );
    String bean_name = (String) hash.get( "bean_name" );

    PhAdapter beanObj = (PhAdapter)getBeanObject( bean_id,bean_name,request ) ;
    hash.remove( "bean_id" ) ;
    hash.remove( "bean_name" );

	/* Set Id, Ws No, Date, Facility start */
	// Commented because taken care in multiple handler itself
//  beanObj.setLoginById( (String) session.getValue( "login_user" ) ) ;
//	beanObj.setLoginAtWsNo( beanObj.getProperties().getProperty( "client_ip_address" ) ) ;
//  beanObj.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
    /* Set Id, Ws No, Date, Facility end */
	//out.println("alert(\"bfor set all\");"); 
	 //out.println("alert(\"" + hash + "\");") ;
//System.err.println("==hash====="+hash);
	beanObj.setAll(hash) ;

    HashMap map = beanObj.validate() ;
    boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
    String validationMessage = (String) map.get( "message" ) ;
	//out.println("alert(\"validated value" + validated + "\");"); 
    if ( validated ) {
        map = beanObj.apply() ;
        //out.println("alert(\"" + map + "\");") ;
        boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
        String message = (String) map.get( "message" ) ;
		//message = message.replace("\""," ").replace("'"," "); 
        String dispNos= (String) map.get( "dispNos" ) ;//ADDED FOR TH-KW-CRF-0020.3 START
        if(dispNos !=null && dispNos !=""){
        token	=	new StringTokenizer(dispNos,"-");
		// System.out.println("856 token"+token);
		
		while(token.hasMoreTokens()){
			dispNo=(String)token.nextToken();	
		}}
        // System.out.println("prathyusha 43 dispNos"+dispNos);//ADDED FOR TH-KW-CRF-0020.3 END
        String flag = (String) map.get( "flag" );
		//flag = flag.replace("\""," ").replace("'"," "); 

        String invalidCode = "" ;
        if(map.get("invalidCode") != null)
            invalidCode = (String) map.get( "invalidCode" ) ;
        
        /*
	        System.out.println("result"+result);
	        System.out.println("message"+message);
	        System.out.println("flag"+flag);
	        System.out.println("invalidCode"+invalidCode);
	        System.out.println("dispNo"+dispNo);
        */
        
        out.println("assignResult('" + result + "', '" + beanObj.replaceNewLineChar(message) + "', '" + flag + "' , '" + invalidCode + "','" + dispNo + "') ; ") ; 
    } else {
        out.println("assignResult('" + validated + "', '" + validationMessage + "', '0', '0' ) ; ") ;
    }
	 putObjectInBean(bean_id,beanObj,request); 
}
catch (Exception e) {
    out.println("alert(\"Exception in Controller : " + e + "\");") ;
	e.printStackTrace();
}
%>
