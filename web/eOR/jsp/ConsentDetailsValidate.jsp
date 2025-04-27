<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	//	if ( relation == null || relation.equals( "" ) )

		
		

	ConsentOrders beanObj = (ConsentOrders)getBeanObject( bean_id,"eOR.ConsentOrders", request ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
/*will populate the relation list box in ConsentDetails.jsp called frm consentdetails.js */
	
	ArrayList RelationData = beanObj.getRelationData() ;

	for( int i=0 ; i< RelationData.size() ; i++ ) {
			String[] record = (String[])RelationData.get(i);
			//if(!record[1].equals("relation")) {
			out.println( "addRelationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			//}
		}
	putObjectInBean(bean_id,beanObj,request);
	
%>
