<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");  %>
<fmt:setLocale value="${LOCALE}" />
<html>
<%
java.util.Locale AvaLocale[] = null;
AvaLocale = java.util.Locale.getAvailableLocales() ;
out.println("For Func:"+ javax.servlet.jsp.jstl.core.Config.get( session,javax.servlet.jsp.jstl.core.Config.FMT_LOCALE)) ;
for (int i=0;i<AvaLocale.length;++i)
out.println("Locale.available   "+AvaLocale[i]);
out.println("Locale.getDefault  "+java.util.Locale.getDefault());
out.println("\nlog in getDefault "+java.util.ResourceBundle.getBundle( "login", java.util.Locale.getDefault()));
for (java.util.Enumeration headers=request.getHeaderNames(); headers.hasMoreElements();){
	String headerName = (String)headers.nextElement();
	String value = request.getHeader(headerName);					
	out.println("header Name :"+headerName+" & value : "+value+" <br>");
}
 
for (java.util.Enumeration sessionVaules=session.getAttributeNames(); sessionVaules.hasMoreElements();){
	String name = (String)sessionVaules.nextElement();
	Object value = session.getAttribute(name);					
	out.println("Session Attribute Name :"+name+" & value : "+value+" <br>");
}
out.println("response Attribute Name :"+response.getCharacterEncoding()+" <br>");
%>

</html>
