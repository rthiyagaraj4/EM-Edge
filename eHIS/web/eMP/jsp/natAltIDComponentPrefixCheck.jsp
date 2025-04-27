<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, java.text.*, java.net.*" %>


<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	java.sql.Statement p_stmt	= null;
	ResultSet p_rset			= null;

	Hashtable hash = null;
	
	String gender		= "";
	String prefix_value	= "";
	String result		= "";

	try
	{
		con = ConnectionManager.getConnection(request);

		hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
			
		prefix_value	= (String) hash.get("prefix_value");
		gender		= (String) hash.get("gender");

		if(prefix_value == null) prefix_value = "";		
		if(gender == null) gender = "";

		String p_gender = "";
		String p_sql = "select prefix_sex from mp_name_prefix where name_prefix = '"+prefix_value+"'";
		p_stmt = con.createStatement();
		p_rset = p_stmt.executeQuery(p_sql);
		if(p_rset!=null)
		{
		while(p_rset.next())
			{
				p_gender=p_rset.getString(1);
			}
		}
		if((!p_gender.equals("B")) && (!p_gender.equals(gender)))
		{
			result = "1";
		}
		
		if(p_stmt != null) p_stmt.close();
		if(p_rset != null) p_rset.close();

		hash.clear();

	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con, request);
	}
	out.println(result);
%>
