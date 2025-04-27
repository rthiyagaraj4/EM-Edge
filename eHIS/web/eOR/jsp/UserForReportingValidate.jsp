<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* "%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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

	UserForReporting beanObj = (UserForReporting)getBeanObject( bean_id,"eOR.UserForReporting", request  ) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		String order_category = (String)hash.get("order_category") ;
		out.println( "clearL2List('document') ; " ) ;

		ArrayList OrderTypeData = beanObj.getOrderTypeData(order_category) ;
		String[] record=null;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			
		}record=null;
		OrderTypeData.clear();
	} else if (validate.equals("performing_locn")) {
		String order_category = (String)hash.get("order_category");
		String performing_facility = (String)hash.get("performing_facility");
		out.println("clearPerformingLocnList('parent.list_bottom.document');");

		ArrayList PerformingLocnData = beanObj.getPerformingLocn(order_category,performing_facility);
		out.println("parent.list_bottom.document.list_dtl.all.locn_names.innerHTML = \"&nbsp;\"");
		String [] record=null;
		for (int i = 0; i < PerformingLocnData.size(); i++) {
			record = (String[])PerformingLocnData.get(i);
			out.println("addPerformingLocnList(\"" + record[1] + "\",\"" + record[0] + "\");");
			out.println("parent.list_bottom.list_dtl.all.locn_names.innerHTML += \"<input type='hidden' name='location_name"+record[1]+"' id='location_name"+record[1]+"' value='"+record[0]+"'>\"");
		}//PerformingLocnData=null;
		record =null;
		PerformingLocnData.clear();
	}

	putObjectInBean(bean_id,beanObj,request);
%>

