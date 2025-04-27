
<%//@ page  import="java.sql.*, java.util.*, java.io.*, eOT.Common.*" contentType="text/html;charset=" %>
<%@page  import="java.util.Hashtable,java.util.HashMap,eOT.Common.*,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
try {
	//tabid = MainPage,OtherDetails
	
	HashMap map = new HashMap();
    Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ; 
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	String tab_id =(String)hash.get("tab_id");
	session.removeAttribute(tab_id);
	map.putAll(hash);
	session.setAttribute(tab_id,map);
	out.println("Success");
}catch (Exception e) {
	e.printStackTrace();
    //out.println("alert(\"Exception in Controller : " +e+ "\")") ;
}
%>
