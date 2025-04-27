<!DOCTYPE html>
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
	String ord_cat = request.getParameter( "ord_cat" ) ;
	String order_type = request.getParameter( "order_type" ) ;
	String func_mode = request.getParameter( "func_mode" ) ;
	String localeName = request.getParameter( "localeName" ) ;
	
	if(func_mode==null)
	func_mode	= "";
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( ord_cat == null || ord_cat.equals( "" ) )
		return ;

	//ExternalOrdersBean beanObj = (ExternalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.ExternalOrdersBean") ;
	ExternalOrdersBean beanObj = (ExternalOrdersBean)getBeanObject( bean_id,  "eOR.ExternalOrdersBean", request ) ;
	 beanObj.setLanguageId(localeName);
		int i=0;
	if(!func_mode.equals("activity_type")) {
		ArrayList OrderTypes = (ArrayList ) beanObj.getOrderTypes(ord_cat) ;
		//System.err.println("Order Types @@@@@@@ " + OrderTypes);

		if(OrderTypes != null)
		{
			//for(int i=0; i < OrderTypes.size();i++2)
			i=0;
			while(i< OrderTypes.size())
			{
				out.println("addOrderType(\""+OrderTypes.get(i)+"\",\""+OrderTypes.get(i+1) +"\");") ;
				i+=2;
			}
		}
		OrderTypes = null;

	}
		
		ArrayList ActivityType = (ArrayList ) beanObj.getActivityType(ord_cat, order_type) ;
 		if(ActivityType != null)
		{
 			i=0;
			while(i< ActivityType.size())
			{
				out.println("addActivityType(\""+ActivityType.get(i+1)+"\",\""+ActivityType.get(i) +"\");") ;
				i+=2;
			}
		}
		ActivityType = null;

		putObjectInBean(bean_id,beanObj,request);
%>
