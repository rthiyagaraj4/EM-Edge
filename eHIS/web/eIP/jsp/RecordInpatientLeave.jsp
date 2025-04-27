<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script language='javascript' src='../js/RecordInpatientLeave.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
</head>

<%
   	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String loginUser = (String)session.getValue("login_user");		
    String facility = (String) session.getValue( "facility_id" ) ;
	String function_name 	= request.getParameter( "function_name" ) ;
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	Connection con  = null;
	ResultSet rs 	= null; 	
	PreparedStatement pstmt = null;
	
	String retVal="";

	try{
		con = ConnectionManager.getConnection(request);		
		String sqlQuery = "select 1,AM_OPER_STN_ACCESS_CHECK(?,?,'N','','DISCHARGE_PAT_YN') retVal from ip_param where facility_id=? ";
		
		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,facility);
		pstmt.setString(2,loginUser);
		pstmt.setString(3,facility);
		rs = pstmt.executeQuery();
		if(rs.next() && rs!=null)
		{          
			retVal = rs.getString("retVal")==null?"":rs.getString("retVal");			
            if(retVal.equals("1")){
				out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			} else if(retVal.equals("2")){
				out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
            } else if(retVal.equals("3")){
					out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	                out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
            }else  if(retVal.equals("4")) {
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(retVal.equals("5")) {
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			} else if((!retVal.equals("1")) && (!retVal.equals("2")) && (!retVal.equals("3")) && (!retVal.equals("4")) && (!retVal.equals("5")))
				{		
				%>
						<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=RecordInpatienLeaveMain.jsp&win_height=33.4&dialogTop=65&win_width=49.6&function_name=<%=function_name%>&call_function=RecordInpatienLeave&wherecondn=REVISE_LEAVE_YN&oper_stn_id=<%=retVal%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
					
			<%}
	}else
		  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString()); e.printStackTrace();}

	finally
	{
		try
		{
			if(rs!=null)			rs.close();
			if(pstmt!=null)		pstmt.close();
		}
		catch(Exception e)
		{out.println("Exception in tryCatch : "+ e.toString());  e.printStackTrace();}
		ConnectionManager.returnConnection(con,request);
   	}
%>
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

