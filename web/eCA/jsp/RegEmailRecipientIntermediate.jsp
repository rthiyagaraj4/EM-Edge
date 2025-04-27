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
eCA.RegEmailRecipientBean CA_RegEmailRecipientBean = (eCA.RegEmailRecipientBean)getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
String srl_no 	=""; 
String from_date 	=""; 
String to_date 	=""; 
String password 	=""; 
String index=""; 
if(hash.containsKey("key")){	
	String key 	= (String)hash.get("key") ;
	if(key == null) key="";
	if(key.equals("clearBean")){		
			CA_RegEmailRecipientBean.clearBean();		
	}else if(key.equals("addToList")){
			srl_no 	= hash.get("srl_no") ==null?"":(String)hash.get("srl_no");
			from_date 	= hash.get("from_date") ==null?"":(String)hash.get("from_date");
			to_date 	= hash.get("to_date") ==null?"":(String)hash.get("to_date");
			password 	= hash.get("password") ==null?"":(String)hash.get("password");
			String[] des={srl_no,from_date,to_date,password};
			index=	java.lang.Integer.toString(Integer.parseInt(srl_no.trim())-1,10);
			CA_RegEmailRecipientBean.removePwdVal(index,des);		
			CA_RegEmailRecipientBean.setPassword(des);		
	}
}
putObjectInBean("CA_RegEmailRecipientBean",CA_RegEmailRecipientBean,session);}
catch(Exception e)
{
	
	e.printStackTrace();
}
%>

