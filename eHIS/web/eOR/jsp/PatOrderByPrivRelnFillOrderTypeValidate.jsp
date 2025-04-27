<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="beanObj" scope="page" class="eOR.PatOrderByPrivRelQueryBean"/>


<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%		request.setCharacterEncoding("UTF-8");

String bean_id = request.getParameter( "bean_id" ) ;
String validate = request.getParameter( "validate" ) ;
String localeName=request.getParameter("localeName");
beanObj.setLanguageId(localeName);

//String practitioner_id = (String)session.getValue("or_practitioner_id");
//String facility_id = (String)session.getValue("facility_id");


if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
if ( validate == null || validate.equals( "" ) ) 
		return ;

//PatOrderByPrivRelnBean  beanObj = (PatOrderByPrivRelnBean)getBeanObject( bean_id,"eOR.PatOrderByPrivReln" ,request) ;
Properties properties		= (Properties) session.getValue( "jdbc" ); 

Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
hash = (Hashtable)hash.get( "SEARCH" ) ;
if(validate.equals("ord_cat")){
	String order_category = (String)hash.get("order_category") ;
	if ( order_category == null || order_category.equals( "" ) )
		order_category="";

	out.println( "clearList1('document') ; " ) ;
	
	ArrayList OrderTypeData = beanObj.getOrderTypeSpecimen(properties, order_category) ;
	for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
		String[] record = (String[])OrderTypeData.get(i);
		out.println( "addLocationList1(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
	
	}
	/*String order_type = "" ;
	out.println( "clearActivityTypeList('document'); " ) ;

	ArrayList ActivityType = beanObj.getActivityType(properties,order_category, order_type);
	for( int i=0 ; i< ActivityType.size() ; i++ ) {
		String[] record = (String[])ActivityType.get(i);
					
		out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		
	}*/

}else if(validate.equals("activity_type")){

	/*String order_category = request.getParameter("order_category");
	String order_type = request.getParameter("order_type") ;
	out.println( "clearActivityTypeList('document'); " ) ;

	ArrayList ActivityType = beanObj.getActivityType(properties, order_category, order_type);
	for( int i=0 ; i< ActivityType.size() ; i++ ) {
		String[] record = (String[])ActivityType.get(i);
					
		out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		
	}*/
}
//putObjectInBean(bean_id,beanObj,request);
%>
