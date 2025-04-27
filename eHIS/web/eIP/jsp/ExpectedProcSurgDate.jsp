<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script language='javascript' src='../js/CancelAdmission.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId = (String)session.getValue("facility_id");	
	String loginUser = (String)session.getValue("login_user");
	Connection con			= null;
	ResultSet rs 			= null; 
	Statement stmt 			= null;
	String call_function	= "";
	String function_id		= checkForNull(request.getParameter("function_id"));
	//String functionid		= checkForNull(request.getParameter("functionid"));

	if(function_id.equals("MODIFY_SERVICE_FOR_INPATIENT"))
	{
		call_function = "MODIFY_SERVICE_FOR_INPATIENT";
	}
	else
	{
		call_function = "REC_EXP_PROC_DATE";
	}

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();		
		rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{ 	stmt = con.createStatement();
			rs = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','REVISE_ADMISSION_YN') FROM dual") ;
			rs.next();
	     	String OsVal=rs.getString(1);
            if(OsVal.equals("1"))
			{
			out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else	if(!OsVal.equals(""))
			{
			%>
			        <iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0 scrolling='no' style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='InpatientLookupCriteria.jsp?<%=source%>&jsp_name=ExpectedDischargeMain.jsp&win_height=33.4&dialogTop=10&win_width=49.6&call_function=<%=call_function%>&wherecondn=REVISE_ADMISSION_YN&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto'  style='height:55vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
			
			<%
			}
			
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		else
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
		try{
			
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e) {out.println("Error while closing the connection :"+e.toString());}
	}
%>

<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>
</html>

<%!
	/// Added by Sridhar R , on 2/24/2006.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

