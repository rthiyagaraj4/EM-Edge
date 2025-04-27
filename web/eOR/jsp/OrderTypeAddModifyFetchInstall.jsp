<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.* " contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String order_category	= (String)hash.get("ORDER_CATEGORY");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String order_type_code	= (String)hash.get("order_type_code");
	String facility_id = (String)session.getValue("facility_id");
	OrderType bean		= (OrderType)getBeanObject( bean_id, bean_name, request ) ; 		   
	String ins_yn ="";
	String moduleRL = "";
   if((order_category.equalsIgnoreCase("RD"))||(order_category.equalsIgnoreCase("OT")))
   {
	    ins_yn = bean.getInstallYN(order_category);
	   if(ins_yn.equals("Y"))
		{
		   out.println("chkInstl(\"" +ins_yn+ "\"); ") ;
		}   
   }
   else if(order_category.equalsIgnoreCase("LB"))
   {
		 moduleRL = bean.checkForNull(bean.getmoduleRL("",order_category,order_type_code,facility_id));
		 if(moduleRL.equalsIgnoreCase("IBARL"))
		 {
				ins_yn = "Y";
				out.println("chkInstl(\"" +ins_yn+ "\"); ") ;
		  }
   }
	putObjectInBean(bean_id,bean,request);

%>
