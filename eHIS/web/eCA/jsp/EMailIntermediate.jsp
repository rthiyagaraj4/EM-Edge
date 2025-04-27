<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
try
{
Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
hash = (Hashtable)hash.get( "SEARCH" ) ;
String beanKey="";
eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean=null;
if(hash.containsKey("key")){
	String key 	= (String)hash.get("key") ;
	if(key == null) key="";
	if(key.equals("clearBean")){
		if(hash.containsKey("beanKey")){
			beanKey=(String)hash.get("beanKey") ;
			CA_EmailRepBodyTxtBean = (eCA.EmailRepBodyTxtBean)getObjectFromBean(beanKey,"eCA.EmailRepBodyTxtmBean",session);
			CA_EmailRepBodyTxtBean.clearBean();
		}
	}
	
}else if(hash.containsKey("html_format")){
	
	String html_format 	= (String)hash.get("html_format") ;
	if(html_format == null) html_format="";
	if(hash.containsKey("beanKey")){
		beanKey=(String)hash.get("beanKey") ;
		CA_EmailRepBodyTxtBean = (eCA.EmailRepBodyTxtBean)getObjectFromBean(beanKey,"eCA.EmailRepBodyTxtmBean",session);
		CA_EmailRepBodyTxtBean.setEditorContent(html_format);
	}
	
}
putObjectInBean(beanKey,CA_EmailRepBodyTxtBean,session);	
}
catch(Exception e)
{
	
	e.printStackTrace();
}
%>

