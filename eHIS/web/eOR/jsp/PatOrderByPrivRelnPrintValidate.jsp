<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	

    Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	//System.out.println("==============================="+hash);
	//HashMap map = new HashMap() ;
	OnLinePrinting online_print = new OnLinePrinting();
	online_print.callOnlinePrint(hash,request,response);
	//map = (HashMap)online_print.callOnlinePrint(hash,request,response);
	//System.out.println("==============================="+map);
   
%>
