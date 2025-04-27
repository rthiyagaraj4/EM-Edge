<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<script>
	function reset() 
	{
	parent.frames[2].frames[1].document.forms[0].reset();
	if (frames[1].document.forms[0].searchby != null)
	    {
			if (frames[1].document.forms[0].soundex.value!='')
			{
				frames[1].document.forms[0].searchby.value="";
				frames[1].document.forms[0].searchby.disabled=true;
			}
			else
			{
				frames[1].document.forms[0].searchby.disabled=false;
				frames[1].document.forms[0].searchby.value="S";
			}
	    }
		parent.frames[2].frames[1].document.forms[0].search.disabled = false;
	parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html'
	}

	</script>
</head>
<%
        request.setCharacterEncoding("UTF-8");
		//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String loginUser = (String)session.getValue("login_user");
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		Connection con  = null;
		ResultSet rs 	= null; 
		Statement stmt 	= null;
		String retVal           = "";
	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		rs = stmt.executeQuery("select 1,AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','REVISE_LEAVE_YN') retVal from ip_param where facility_id='"+facilityId+"'");

		if(rs.next())
		{
				retVal = rs.getString(2);
		
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
				<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod' 	src="../jsp/IPLookupCriteriaForLeave.jsp?function_id=<%=function_id%>&jsp_name=PaintAmendInpatientLeave.jsp&win_height=47&win_width=50&dialogTop=58&module=eIP&call_function=AMEND_LEAVE&wherecondn=REVISE_LEAVE_YN&oper_stn_id=<%=retVal%>" style="height:25vh;width:100vw"></iframe>
					<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
					<iframe name='desc_frame' id='desc_frame' 	src='QuerySearchResultFrames.jsp?step=amendleave' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
				
			<%
		}
	}else
	  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");

	if (rs != null) rs.close();
	if(stmt != null) stmt.close();


	}catch(Exception e){
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
	}
	finally{
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

