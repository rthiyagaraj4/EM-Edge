
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>


<%
try{

	/* Mandatory checks start */
	///String mode			=	request.getParameter( "mode" ) ;
	//String function_id	=	request.getParameter( "function_id" ) ;
	String bean_id = "orderablePerformingLocationBean" ;
	//String bean_name = "eOR.OrderablePerformingLocationBean";

	boolean flag			=   false ;


	OrderablePerformingLocationBean bean = (OrderablePerformingLocationBean)getBeanObject( bean_id.trim(),"eOR.OrderablePerformingLocationBean",request) ;


	Hashtable hash		  = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	try
	{

	  flag			      = bean.doSync(hash);
	}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in OrderCatalogSync.jsp"+"<%=e.getMessage()%>");</script>

	<%
	e.printStackTrace();//COMMON-ICN-0181
	}out.println("syncStatus(" + flag + ")");
putObjectInBean(bean_id,bean,request);

}catch(Exception e){
	//out.println("Exp in OrderablePerformingLocationSync.jsp "+e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
%>
