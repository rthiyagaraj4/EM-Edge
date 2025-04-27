<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>

<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<jsp:useBean id="XMLobj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;	

	String staff_id= request.getParameter("staff_id");
	String role_type=request.getParameter("role_type");
	Connection con = null; 
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	con = ConnectionManager.getConnection(request);
	int exist=0;
	String sql="select count(*) from rs_staff_profile where role_type=? and staff_id=?";
	try{
		stmt=con.prepareStatement(sql);
		stmt.setString(1,role_type);
		stmt.setString(2,staff_id);
		rs=stmt.executeQuery();
		while(rs.next())
		{	
			exist=Integer.parseInt(rs.getString(1));
		}
	} catch ( Exception e )	{
			e.printStackTrace() ;
	} finally {
			rs.close();
			stmt.close();
			
			con.close();

	}
		if(exist>0)
		{
			out.println("showstaffprofile(\""+role_type+"\",\""+ staff_id+"\") ; " ) ;
		}
		else 
		{
			out.println("parent.parent.frames[2].location.href = \"../../eCommon/html/blank.html\";");
			out.println("parent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"NO_RECORD_AVAILABLE\");");

		}
%>
