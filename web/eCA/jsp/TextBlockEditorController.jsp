<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 
request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
try 
{
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String out_data = (String)hash.get("out_data") ;
	if(!"".equals(out_data)){
		String retData = java.net.URLEncoder.encode(out_data,"UTF-8");
		session.setAttribute("TEXTBLOCK_CONTENT",retData);
		out.println("Data Avaliable");
	}else{
		session.setAttribute("TEXTBLOCK_CONTENT","");
		out.println("");
	}
}catch(Exception e){
	out.println("");
}
	
%>
