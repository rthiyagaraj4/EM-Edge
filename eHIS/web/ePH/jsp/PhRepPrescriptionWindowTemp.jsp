 <%-- saved on 03/11/2005 --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	
	
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;

	out.println("submitTheWindow()");
%>

