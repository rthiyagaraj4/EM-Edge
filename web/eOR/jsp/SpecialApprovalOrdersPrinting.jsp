
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%

	String bean_id = "Or_SpecialApproveOrders" ;
	String bean_name = "eOR.SpecialApproveOrders";
	//String validate = request.getParameter( "validate" ) ;
    //out.println("<script>alert('injsp')</script>");
	SpecialApproveOrders bean = (SpecialApproveOrders)getBeanObject( bean_id, bean_name ,request) ;
	

    Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
    Hashtable allValues = bean.getAllValues();
    //System.out.println("jsp:allValues size():"+allValues.size());
    //out.println("<script>alert('jsp:allValues size():"+allValues.size()+"')</script>");
	//java.util.Properties props = null;

	OnLinePrinting online_print = new OnLinePrinting();
	//System.out.println("==== online_print obj ?>?>?>" + online_print);
	online_print.callOnlinePrint(allValues,request,response);
	//HashMap tmp_map = (HashMap)online_print.callOnlinePrint(allValues);
	//String tmp_vals = (String)tmp_map.get("traceVal");
	//System.out.println("=after the methoid===tmp_vals >"+tmp_vals);

	//putObjectInBean(bean_id, bean ,request);
%>
