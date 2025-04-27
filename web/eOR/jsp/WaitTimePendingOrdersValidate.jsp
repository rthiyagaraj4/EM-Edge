
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
try
{
	//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	//System.out.println("######val:"+ validate) ;

	String default_val = "";
	try{
		default_val  = request.getParameter( "default_val" ) ;
		if ( default_val == null || default_val.equals( "" ) )
			default_val = "" ;
	}catch(Exception e){
		out.println(e.toString());
	}
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	WaitTimePendingOrdersBean beanObj = (WaitTimePendingOrdersBean)getBeanObject( bean_id , "eOR.WaitTimePendingOrdersBean", request) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	String index  = request.getParameter( "index" ) ;
	//System.out.println("####hash="+index);
	
	String order_category = (String)hash.get("order_category"+index) ;
	if ( validate.equals( "ord_cat" ) ) {
		
		out.println("clearList('document',"+index+");");
		ArrayList OrderTypeData = beanObj.getOrderTypeData(order_category) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\",\""+index+"\") ; " ) ;
		}
			
	}
	putObjectInBean(bean_id,beanObj,request);
	
}
catch(Exception e ) { 
	//out.println(e.toString()) ;//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
	
}


	/**/
%>
