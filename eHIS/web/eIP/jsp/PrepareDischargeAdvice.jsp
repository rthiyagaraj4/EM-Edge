<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8"); 
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	 %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
		<script language='javascript' src='../js/CancelAdmission.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        
	</head>
<script>
//alert("opening PrepareDischargeAdvice.jsp");
function reset()
{
	f_query_add_mod.document.forms[0].reset();
	if (f_query_add_mod.document.forms[0].searchby != null)
	    {
			if (f_query_add_mod.document.forms[0].soundex.value!='')
			{
				f_query_add_mod.document.forms[0].searchby.value="";
				f_query_add_mod.document.forms[0].searchby.disabled=true;
			}
			else
			{
				f_query_add_mod.document.forms[0].searchby.disabled=false;
				f_query_add_mod.document.forms[0].searchby.value="S";
			}
	    }
	f_query_add_mod.document.forms[0].search.disabled=false;
	parent.content.frames[2].location.href = "../../eCommon/html/blank.html";
}
</script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId = (String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");		
    String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";

	Connection con			= null;
	ResultSet rs 			= null; 
	Statement stmt 			= null;
	PreparedStatement pstmt = null;
	ResultSet rset     = null;
	String retVal           = "";

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();	

		rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{
			//Added by Devang For Operator Station & Clinic  Check
			pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','DISCHARGE_ADVICE_YN') from dual");
			pstmt.setString(1,facilityId);
		    pstmt.setString(2,loginUser);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				retVal = rset.getString(1);
			}
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
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=DischargeAdviceMain.jsp&win_height=33.4&dialogTop=65&win_width=49.6&call_function=PrepareDischargeAdvice&wherecondn=DISCHARGE_ADVICE_YN&oper_stn_id=<%=retVal%>' frameborder=0 scrolling='no' noresize style='height:24vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	 src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:56vh;width:100vw'></iframe>
				<iframe name='desc_frame' id='desc_frame' 	src='QuerySearchResultFrames.jsp?step=leave' frameborder=0 scrolling='auto' noresize style='height:4vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:11vh;width:100vw'></iframe>
				
		<%	}
		}
		else
		{
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

	}catch(Exception e)
	{
		out.println("Exception in tryCatch : "+ e.toString());
	}
	finally
	{
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

