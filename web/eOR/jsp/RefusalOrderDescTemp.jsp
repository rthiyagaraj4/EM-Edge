<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page  import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	request.setCharacterEncoding("UTF-8");

 String localeName=request.getParameter("localeName");

	String consent_form_text = "";
	String consent_form_id = "";
		
	//String reason = "";
	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(localeName);
	
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
 		
    hash = (Hashtable)hash.get( "SEARCH" ) ;
  		
	bean_id = (String)hash.get("bean_id");
	bean_name = (String)hash.get("bean_name");
 	
	consent_form_id = (String)hash.get("consent_form_id");
 
	if(hash.containsKey("consent_form_text"))
	{
		consent_form_text = (String)hash.get("consent_form_text");
System.err.println("====consent_form_text=========="+consent_form_text);		
		bean.setConsentContent(consent_form_text);
		bean.setRefusalFormID(consent_form_id);
		//setnewOrderId
	}
	
	System.err.println("====Finished==========");
	putObjectInBean(bean_id,bean,request);
%>
