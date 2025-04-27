<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<%

    String funcID = request.getParameter("function_id");
    if(funcID == null)  funcID = "" ;

    if(funcID.equals(""))
	    mh.cleanAll() ;
   else
        mh.cleanAll(funcID) ;

    String callFrom= request.getParameter("from");
    if(callFrom == null) {
	    //response.sendRedirect( "../../eCommon/jsp/dmenu.jsp" );
		%>
		<script> 
		location.href = "../../eCommon/jsp/dmenu.jsp" ;
		</script> 
		<%
	}
%>
