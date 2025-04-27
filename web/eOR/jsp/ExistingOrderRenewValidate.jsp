<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%  	request.setCharacterEncoding("UTF-8");

	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName=request.getParameter("localeName");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	//PatOrderByPrivRelnBean beanObj = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request , "eOR.PatOrderByPrivRelnBean") ;
	PatOrderByPrivRelnBean beanObj = (PatOrderByPrivRelnBean)getBeanObject( bean_id, "eOR.PatOrderByPrivRelnBean", request ) ;
	beanObj.setLanguageId(localeName);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "order_id" ) ) {
		String order_id = (String)hash.get("order_id") ;
		String order_type_code = (String)hash.get("order_type_code") ;
		if (order_id == null) order_id = "";

			//String flag = beanObj.callRenewOrders(order_id) ;
			String err_msg = beanObj.callRenewOrders(order_id,order_type_code) ;
			if(err_msg.equals(""))
			out.println( "alert(getMessage('RENEW_ORDERS_SUCCESSFUL','OR'));window.close(); " ) ;
			else
				out.println( "alert(\"" + err_msg + "\");window.close(); " ) ;

	}
	//putObjectInBean(bean_id,beanObj,request);
%>
