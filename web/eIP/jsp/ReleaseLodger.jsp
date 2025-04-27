<!DOCTYPE html>
<%
/// MODULE  : InPatient Management..(IP)
/// This File is called on the click of Lodger or Accompanying Person Buttons...
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../js/BookLodger.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
    <script>
	   function reset()
		{
			ReleaseBed_details.document.forms[0].reset();
			f_query_add_mod.document.location.href ='../../eCommon/html/blank.html'; 
			ReleaseBed_details.document.forms[0].search.disabled=false;
		}  
	</script>
</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url				= "../../eCommon/jsp/commonToolbar.jsp?"; 
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String loginUser		= (String)session.getValue("login_user");
	String facility			= (String) session.getValue( "facility_id" ) ;
	String function_id		= checkForNull(request.getParameter("function_id"));	

	Connection con			= null;
	//ResultSet rs 			= null; 
	//Statement stmt 			= null;
	//Statement stmt_opr		= null;
	//ResultSet rset_opr 		= null;
	PreparedStatement pstmt = null;
	ResultSet rset			= null;
	String retVal			= "";
	String patient_id_length= "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		//stmt	= con.createStatement();
		//rs		= stmt.executeQuery("select 1 from ip_param where facility_id='"+facility+"' ") ;
		pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CHECK_LODGER_YN') retVal,(select PATIENT_ID_LENGTH from mp_param) PATIENT_ID_LENGTH  from ip_param WHERE facility_id=? ");
		pstmt.setString(1,facility);
		pstmt.setString(2,loginUser);
		pstmt.setString(3,facility);
		rset = pstmt.executeQuery();

		if(rset.next())
		{
			retVal = rset.getString("retVal");
			patient_id_length = rset.getString("PATIENT_ID_LENGTH");
			/* Added by Devang For Operator Station & Clinic  Check
			pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CHECK_LODGER_YN') from dual");
			pstmt.setString(1,facility);
		    pstmt.setString(2,loginUser);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				retVal = rset.getString(1);
			}

			*/
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
				<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
					<iframe name="ReleaseBed_details" id="ReleaseBed_details" src="../jsp/ReleaseLodgerLookupCriteria.jsp?wherecondn=CHECK_LODGER_YN&function_id=<%=function_id%>&oper_stn_id=<%=retVal%>&patIDLength=<%=patient_id_length%>"  frameborder=0 noresize scrolling='no' style='height:40vh;width:100vw'></iframe>
					<iframe src="../../eCommon/html/blank.html" name="f_query_add_mod" id="f_query_add_mod" frameborder=0 noresize scrolling='auto' style='height:47vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>
		<%	}
		}
		else
		{
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}

	}catch(Exception e)
	{
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
	}
	finally
	{
		//if(rs!=null)			rs.close();
		//if(stmt!=null)			stmt.close();
		if(rset!=null)			rset.close();
		if(pstmt!=null)			pstmt.close();
		//if(rset_opr !=null)		rset_opr.close();
		//if(stmt_opr!=null) 		stmt_opr.close();
	
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

