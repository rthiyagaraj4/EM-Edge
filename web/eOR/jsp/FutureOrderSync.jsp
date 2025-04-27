<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%@ page import="eOR.FutureOrder" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>


<%
try{
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	String bean_id		=	"Or_FutureOrder" ;
	
	boolean flag			=   false ;

	
	FutureOrder bean = (FutureOrder)getBeanObject( bean_id.trim(),"eOR.FutureOrder",request) ;


	Hashtable hash		  = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );	

	try
	{
		
	  flag			      = bean.doSync(hash);
	}
	catch(Exception e)
	{
	%>
		<script>alert("Exception thrown ...Chk in FutureOrderSync.jsp"+"<%=e.getMessage()%>");</script>
	<%
	}
	out.println("syncStatus(" + flag + ")");
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
