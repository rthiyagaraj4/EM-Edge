<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
Connection conn = null;
ResultSet rs	= null;
Statement stmt	= null;
try
{
	request.setCharacterEncoding("UTF-8");

	String locale = (String)session.getAttribute("LOCALE");
	StringBuffer stbuf=new StringBuffer();
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String code = (String)hash.get("code");
	String description = "";
   	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	stbuf.append("select description from MO_CONSENT_FORM_lang_vw where LANGUAGE_ID='"+locale+"' and CONSENT_FORM_CODE='"+code+"'");
	rs = stmt.executeQuery(stbuf.toString());
	if(rs!=null)
	{
	 while(rs.next())
		{
		  	description = rs.getString(1);
		
		}
	}
	
	out.println(description);
    stbuf.setLength(0);

	if(rs != null)	rs.close();	
	if(stmt !=null) stmt.close();
	hash.clear();
	}
catch(Exception e) {out.println("Error in  Concent Details"+e.toString());}
finally
{

	ConnectionManager.returnConnection(conn,request);
}
%>
