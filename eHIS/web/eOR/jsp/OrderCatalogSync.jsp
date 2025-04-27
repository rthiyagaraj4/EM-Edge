
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
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>


<%
try{
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	//String mode			=	request.getParameter( "mode" ) ;
	//String function_id	=	request.getParameter( "function_id" ) ;
	String bean_id		=	"Or_OrderCatalog" ;
	//String bean_name	=	"eOR.OrderCatalogBean";

	boolean flag			=   false ;

	
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject( bean_id.trim(),"eOR.OrderCatalogBean",request) ;


	Hashtable hash		  = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );	

	try
	{
		
	  flag			      = bean.doSync(hash);
	}catch(Exception e){%>
	//<script>alert("Exception thrown ...Chk in OrderCatalogSync.jsp"+"<%=e.getMessage()%>");</script>

	<%}
	out.println("syncStatus(" + flag + ")");
	putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	System.out.println("Exp in OrderCatalogsync.jsp"+e.getMessage());
}
%>
