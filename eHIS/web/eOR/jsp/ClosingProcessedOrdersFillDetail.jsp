
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*, eCommon.* " %> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"  %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

   
<% 
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;
	
	
	ClosingProcessOrderBean beanObj = (ClosingProcessOrderBean)getBeanObject( bean_id,"eOR.ClosingProcessOrderBean", request ) ;
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	if ( validate.equals( "order_category" ) ) 
	{
		String order_category = (String)hash.get("order_category") ;
		out.println( "clearList('document') ; " ) ;

		ArrayList order_type = beanObj.getClosedOrderType(order_category);
		for( int i=0 ; i< order_type.size() ; i++ ) 
		{
			String[] record = (String[])order_type.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}
	else
	{

		//String order_type_code = (String)hash.get("order_type") ;

	
		//ArrayList dataItem = (ArrayList)beanObj. getUnprocessedInprocess(order_type_code) ;
		ArrayList dataItem=new ArrayList();
		String[] record=null;
 		for( int i=0 ; i< dataItem.size() ; i++ ) 
			{
			
			record = (String[])dataItem.get(i);
			
			out.println( "fillUnprocessInprocess(\"" + record[0] + "\",\"" + record[1] + "\",\"" + record[2] + "\") ; " ) ;
			
			}
			dataItem=null;
	}

	putObjectInBean(bean_id,beanObj,request);
%>
