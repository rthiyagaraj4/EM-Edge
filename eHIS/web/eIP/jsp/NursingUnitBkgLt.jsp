<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/NursingUnitBkgLt.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
		request.setCharacterEncoding("UTF-8"); 
		String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		
		String facilityId		= (String)session.getValue("facility_id");
		//facilityId = "yz";
		Statement stmt	= null;
		ResultSet rs			= null;
		Connection con =null;
		try
		{
			con = ConnectionManager.getConnection(request);
			
			stmt = con.createStatement();
			rs	 = stmt.executeQuery("select CHK_BOOKING_LIMIT_BY from ip_param where FACILITY_ID = '"+facilityId+"'");
			if (rs!= null)
			{
				if(rs.next())
				{
				String bookinglimit = rs.getString("CHK_BOOKING_LIMIT_BY");
				if(!(bookinglimit.equals("1")))
					out.print("<script>alert(getMessage('CHECK_LIMIT_BY_AGE_GROUPBED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				else
				{
		%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html?+<%=params%>' frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
		<%
			}
			}//second if closed
			else
			{
				out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));</script>");
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();	 
			}
 
		}catch(Exception e){
			out.print("Exception "+e);
		}
		finally
		{
			
			ConnectionManager.returnConnection(con,request);
		}
	%>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

