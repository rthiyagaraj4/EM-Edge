<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%!  
	public String specialCharacter(String single)
	{
		if(single == null) single = "";
		return single.replaceAll("'","");
	}	
%>
<% 
Connection con = null;
ResultSet rs=null;
try {
	//String validate=request.getParameter("validate") == null ? "" :request.getParameter("validate") ;
	Properties p;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	con = ConnectionManager.getConnection(request);
	
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String min_data_set				=(String) hash.get("MIN_DATA_SET");
	String sql="select MDS_SOURCE_SQL from MR_MDS where MDS_CODE='"+min_data_set+"'";
	Statement stmt = con.createStatement();
	ResultSet rset =stmt.executeQuery(sql);
	String mds_sql="";
	if(rset.next())
		{
		mds_sql=rset.getString("MDS_SOURCE_SQL");
		}
		mds_sql=mds_sql.replace("##@@##",locale);
	%>
	<%=mds_sql%>;
	<%
	if(rset!=null) rset.close();	
	if(stmt!=null) stmt.close();
}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
%>	
