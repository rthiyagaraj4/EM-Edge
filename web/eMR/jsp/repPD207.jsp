<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src='../js/repPD207.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../js/eMRmessages.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String sql		=	"";
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;

	try
	{
	con			=	ConnectionManager.getConnection(request);
	stmt		=	con.createStatement();
	String install_yn="";
		
		sql=" Select install_yn from sm_module where module_id = 'OT' ";
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			 install_yn = rs.getString("install_yn");
		}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();

		if(install_yn == null || install_yn.equals("null"))
		install_yn = "N";
		
		if(install_yn.equals("Y"))
		{
		}
		else
		{			
		out.println("<script> alert(geteMRMessage('OT_NOT_INSTALLED')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");

		//out.println("<script> alert('OT module not installed.Cannot Procced'); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");

		}
	}
	catch(Exception e)
	{
		//out.println("Exception while fetching connection :"+e);
		e.printStackTrace();
	}
	finally
	{				
		ConnectionManager.returnConnection(con, request);
	}
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/repPD207Form.jsp'  frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

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

