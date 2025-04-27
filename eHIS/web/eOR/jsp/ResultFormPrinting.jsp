<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with
id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
		request.setCharacterEncoding("UTF-8");
		String localeName=request.getParameter("localeName");
		String bean_id	 = request.getParameter("bean_id");
		if ( bean_id == null || bean_id.equals( "" ) )
			return ;
		String bean_name = "eOR.ResultEntryBean";
		if (bean_id.equals("Or_ResultEntry")) {
			ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id,bean_name , request) ;
 	        bean.setLanguageId(localeName);
			Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	        hash = (Hashtable)hash.get( "SEARCH" ) ;
	        Hashtable allValues  =  bean.getAllValues();
			if ((allValues != null) && (allValues.size() > 0)) {
	    	//out.println("alert('APP-OR0148 Report has been Submitted to thePrinter')");
	    	//System.out.println("alert('APP-OR0148 Report has been Submitted to thePrinter')");
 			OnLinePrinting online_print = new OnLinePrinting();
 			online_print.printResultEntryReport(allValues, request,response);
		}

		//putObjectInBean(bean_id,bean,request);

	}

%>
