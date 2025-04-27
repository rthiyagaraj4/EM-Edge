<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	InPatient Management..(IP)
/// Func Name / ID	:	Check-In Loder / CHECK_IN_LODGER
/// Developer		:	SRIDHAR R
/// This File is called on the click of CheckIn Lodger Menu..
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	    <script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		<script>
			function reset()
			{
				frames[1].document.forms[0].reset();
				frames[1].document.forms[0].search.disabled = false;
				frames[2].location.href = '../../eCommon/html/blank.html';
			}
		</script>
		<%
			String call_function = request.getParameter("function_id");
			if(call_function == null) call_function = "";
		%>
	</head>
	<%
		request.setCharacterEncoding("UTF-8");
		String url				= "../../eCommon/jsp/commonToolbar.jsp?"; 
		String params			= request.getQueryString();
		String source			= url + params ;
		String loginUser		= (String)session.getValue("login_user");
		String facility			= (String) session.getValue( "facility_id" ) ;
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		Connection con			= null;
		ResultSet rs 			= null; 
		//Statement stmt 			= null;
		PreparedStatement pstmt = null;
        //ResultSet rset     = null;
		String chk_in_lodger_max_period	= "";
		String retVal           = "";
		try
		{
			con = ConnectionManager.getConnection(request);
			//stmt = con.createStatement(); PE_EXE venkat s
			//rs = stmt.executeQuery("select CHK_IN_LODGER_MAX_PERIOD from ip_param where facility_id='"+facility+"' ") ;
			pstmt = con.prepareStatement("select CHK_IN_LODGER_MAX_PERIOD,(AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CHECK_LODGER_YN')) retVal from ip_param where facility_id='"+facility+"'");
			pstmt.setString(1,facility);
		    pstmt.setString(2,loginUser);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next())
			{
			
			chk_in_lodger_max_period = rs.getString("CHK_IN_LODGER_MAX_PERIOD");
			if(chk_in_lodger_max_period == null) chk_in_lodger_max_period ="0";
			retVal = rs.getString("retVal");



			//if(rset.next())
			//{
			//	retVal = rset.getString(1);
		//	}
	      if(retVal.equals("1")){
				out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			else if(retVal.equals("2")){
				out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
            }
			else if(retVal.equals("3")){
					out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	                out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
            }else  if(retVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(retVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!retVal.equals("1")) && (!retVal.equals("2")) && (!retVal.equals("3")) && (!retVal.equals("4")) && (!retVal.equals("5")))
            {		
					%>
						<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
							<iframe name='CheckInLodgerCriteriaFrame' id='CheckInLodgerCriteriaFrame' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&call_function=<%=call_function%>&oper_stn_id=<%=retVal%>&chk_in_lodger_max_period=<%=chk_in_lodger_max_period%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
							<iframe name='CheckInLodgerResultFrame' id='CheckInLodgerResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:100vw'></iframe>
							<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
					<%
				}
			}
			else
				out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();

		}
		catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
		finally
		{
			try
			{
			if(rs!=null)			rs.close();
			//if(stmt!=null)			stmt.close();
			//if(rset!=null)			rset.close();
			if(pstmt!=null)			pstmt.close();
			}
			catch(Exception e)
			{out.println("Exception in tryCatch : "+ e.toString());}
			ConnectionManager.returnConnection(con,request);
		}
	%>
</html><%!
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

