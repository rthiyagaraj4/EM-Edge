<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script>
		function reset()
		{
			frames[1].document.forms[0].reset();
			frames[2].location.href = '../../eCommon/html/blank.html';
			frames[1].document.forms[0].search.disabled=false;

		}
	</script>
	
</head>
<%
	
	String url    = "../../eCommon/jsp/commonToolbar.jsp?"; 
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId	= (String)session.getValue("facility_id") ;
	String loginUser	= (String)session.getValue("login_user");
	String function_id=request.getParameter("function_id");
			    if(function_id == null) function_id = "";
	Connection con	= null;
	ResultSet rs	= null;
	PreparedStatement pstmt	= null;
	String oper_stn_id	="";

	try
	{ 
		con		=	ConnectionManager.getConnection(request);
		pstmt	=	con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','BLOCK_BED_YN') from dual");
		pstmt.setString(1,facilityId);
		pstmt.setString(2,loginUser);
		rs		=	pstmt.executeQuery();
		if(rs.next())
			oper_stn_id	=	rs.getString(1);
	
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
			
		%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/CurrentInpatientCountCriteria.jsp?function_id=<%=function_id%>&win_height=33&win_width=50&call_function=IPList' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:70vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
</html>

<%
				
	}
	catch(Exception e)
	{
		//out.println("Exception in try-catch:"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
			ConnectionManager.returnConnection(con,request);
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception while closing connection:"+e.toString());
			e.printStackTrace();
		}
	}
%>





<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

