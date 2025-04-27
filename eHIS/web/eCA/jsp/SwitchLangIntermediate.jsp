<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
 <%
		request.setCharacterEncoding("UTF-8");	
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale					=	(String) p.getProperty("LOCALE");

		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;			
		String cur_lang_id =hash.get("cur_lang_id")==null?"":(String) hash.get("cur_lang_id");
		String opt_lang_id =hash.get("opt_lang_id")==null?"":(String) hash.get("opt_lang_id");		
		 	 
		 
		 if(locale.equals(cur_lang_id))
		 {
			locale = opt_lang_id;
			p.setProperty("LOCALE",locale);
			 
		 }
		 else 
		 {
			locale = cur_lang_id;
			p.setProperty("LOCALE",locale);
		 }

		 out.println("newLanguage()");
	
	%>
