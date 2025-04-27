
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*,eSS.Common.*,java.util.*"%>  

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
  request.setCharacterEncoding("UTF-8");
	String bean_id="SterilizationTypeBean";
	String bean_name= "eSS.SterilizationTypeBean";
	SterilizationTypeBean bean = (SterilizationTypeBean)getBeanObject(bean_id , bean_name, request ) ;  
	
	String function					=	request.getParameter("validate");
	
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String code					= (String)hash.get("code");

	if(function.equals("ADD_TO_LIST")){
		
		int description		=	bean.getSterilizationTypeCode(code);
		System.err.println("description---->"+description);
		if(description==1)
		{
		   //out.println("CodeExit();");
           out.println("CodeExit();") ;
		}

		
	}
	
	
		
		putObjectInBean(bean_id,bean,request);
	%>
				
