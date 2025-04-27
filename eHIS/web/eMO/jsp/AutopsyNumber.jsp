
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
		Connection conn              = null;
		ResultSet rs	             = null;
		java.sql.Statement stmt	             = null;
	try
	{
		 
        request.setCharacterEncoding("UTF-8");
		String facilityId            = (String) session.getValue("facility_id");
		Hashtable hash               = (Hashtable)obj.parseXMLString( request ) ;
		hash                         = (Hashtable)hash.get("SEARCH") ;
		String prefix_facility_id_yn = (String)hash.get("prefix_facility_id_yn");
		String suffix_facility_id_yn = (String)hash.get("suffix_facility_id_yn");
		String prefix_year_yn        = (String)hash.get("prefix_year_yn");
		String suffix_year_yn        = (String)hash.get("suffix_year_yn");
		String start_num             = (String)hash.get("start_num");
		String year                  = "";
		String final_result          = "";
		conn                         = ConnectionManager.getConnection(request);
		stmt                         = conn.createStatement();
		rs                           = stmt.executeQuery("select to_char(sysdate,'yyyy') from dual");
		if(rs!=null)
		{
		 while(rs.next())
			{
				year = rs.getString(1);
			}
		}
		if(rs != null)	rs.close();	
		if(stmt !=null) stmt.close();
		if(prefix_facility_id_yn.equals("Y"))
			final_result = final_result + facilityId;
		if(prefix_year_yn.equals("Y"))
		    final_result = final_result + year;
		stmt             = conn.createStatement();
		rs               = stmt.executeQuery("select trim(to_char('"+start_num+"','0000000000')) anumber from dual");
		if(rs!=null)
		{
			while(rs.next())
			{
				final_result =  final_result+rs.getString("anumber");
			}
		}
		if(suffix_facility_id_yn.equals("Y"))
			final_result    = final_result + facilityId;
		if(suffix_year_yn.equals("Y"))
			final_result    = final_result + year;
			out.println(final_result);
		if(rs != null)	rs.close();	
		if(stmt !=null) stmt.close();
	hash.clear();
	}
	catch(Exception e) {out.println(e.toString());}
	finally
	{
		if(conn !=null) ConnectionManager.returnConnection(conn,request);
	}
%>

