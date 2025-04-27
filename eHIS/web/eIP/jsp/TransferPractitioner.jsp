<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language ='javascript' src='../../eIP/js/TransferPractitioner.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");		
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	Connection con			= null;
	ResultSet rs 			= null; 	 
    PreparedStatement pstmt = null;
	String retVal      = "";

	try
	{
		con			= ConnectionManager.getConnection(request);
		String sqlQuery = "";
		sqlQuery = "select 1,AM_OPER_STN_ACCESS_CHECK(?,?,'N','','PRACT_TRANSFER_YN') retVal from ip_param where facility_id=? ";
		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,loginUser);
		pstmt.setString(3,facilityId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{           
			retVal = rs.getString("retVal")==null?"":rs.getString("retVal");
			
            if(retVal.equals("1")){
				out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			} else if(retVal.equals("2")) {
				out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
            } else if(retVal.equals("3")) {
					out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	                out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
            }else  if(retVal.equals("4")) {
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(retVal.equals("5")) {
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			} else if((!retVal.equals("1")) && (!retVal.equals("2")) && (!retVal.equals("3")) && (!retVal.equals("4")) && (!retVal.equals("5")))
            {		
				%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
 				<!--frame name='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintTransferPractitioner.jsp&win_height=30.7&win_width=49.6&call_function=TransferPractitioner&wherecondn=EMERGENCY_TFR_YN&oper_stn_id=<%=retVal%>' frameborder=0 scrolling='no' noresize-->
				<!--Thursday, March 11, 2010 , wherecondn=PRACT_TRANSFER_YN is changed since EMERGENCY_TFR_YN is for IntraWard Transfer-->
 				<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eIP/jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintTransferPractitioner.jsp&win_height=30.7&win_width=49.6&call_function=TransferPractitioner&wherecondn=PRACT_TRANSFER_YN&oper_stn_id=<%=retVal%>' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
				
				<%}
		}
		else
           %> <script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));
				document.location.href= '../../eCommon/jsp/dmenu.jsp'
			  </script>
	<%
	if (rs != null)   rs.close();
	if (pstmt != null)   pstmt.close();
	}
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());e.printStackTrace();}
	
	finally
	{
		if(rs!=null) rs.close();		 
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

