<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TCS Additional Id Proof</title>
<%
String QueryString=request.getQueryString();
System.out.println(QueryString);
%>
</head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<iframe SRC="../../eBL/jsp/TCSAddlIdProofType.jsp?<%=QueryString%>"	  NAME="idProofType" frameborder=0  scrolling='no' frameborder='0' style='height:15%;width:100vw'></iframe><iframe SRC="../../eBL/jsp/TCSAddlIdProofDtls.jsp?<%=QueryString%>"	  NAME="idProofDtls" frameborder=0  scrolling='no' frameborder='0' style='height:*%;width:100vw'></iframe>
</html>

