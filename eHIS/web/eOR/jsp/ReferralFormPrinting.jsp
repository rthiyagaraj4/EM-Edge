<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id	 = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	//String mode		 = request.getParameter("mode");
	if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
		return ;
	if (bean_id.equals("Or_ResultReporting")) {
		ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name , request) ;
		 Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	   hash = (Hashtable)hash.get( "SEARCH" ) ;

	    Hashtable allValues  =  bean.getAllValues();
 		 
	    if ((allValues != null) && (allValues.size() > 0)) {
	    	out.println("alert('APP-OR0148 Report has been Submitted to the Printer')");
			//java.util.Properties props = null;

			OnLinePrinting online_print = new OnLinePrinting();
 			online_print.callReferralFormOnlinePrint(allValues,request,response);
		}

		putObjectInBean( bean_id,bean,request);
	} else {
		RegisterOrder bean1 = (RegisterOrder)getBeanObject( bean_id,bean_name,request ) ;
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;

	    Hashtable allValues  = bean1.getAllValues();
	    if ((allValues != null) && (allValues.size() > 0)) {
	    	out.println("alert('APP-OR0148 Report has been Submitted to the Printer')");
			//java.util.Properties props = null;

			OnLinePrinting online_print = new OnLinePrinting();
 			online_print.callReferralFormOnlinePrint(allValues,request,response);
		}
		putObjectInBean( bean_id,bean1,request);
	}
 
	  
%>
