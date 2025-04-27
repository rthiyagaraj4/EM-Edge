<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/common.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		 
</head>
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

	if(frames[1].document.forms[0].gender!=null)
	{
		frames[1].document.forms[0].gender.value = "F";
		frames[1].document.forms[0].gender.disabled = "true";
	}


	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[1].document.forms[0].search.disabled=false;
}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String function_name 	= request.getParameter( "function_name" ) ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId = (String)session.getValue("facility_id");
	String locncode = request.getParameter("location_code");
		if(locncode == null) locncode= "";
	String loginUser = (String)session.getValue("login_user");
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	Connection con  = null;
	ResultSet rs 	= null; 
	PreparedStatement pstmt 	= null;
	try
	{
		con = ConnectionManager.getConnection(request);		
		String sqlQuery = "";
		String OsVal =  "" ;
		sqlQuery = "select 1,AM_OPER_STN_ACCESS_CHECK(?,?,'N','','LINK_BABY_TO_MOTHER_YN') OsVal from ip_param where facility_id=? ";
		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,loginUser);
		pstmt.setString(3,facilityId);
		rs = pstmt.executeQuery() ;
		if(rs.next())
		{ 
			 
	     	OsVal=rs.getString("OsVal")==null?"":rs.getString("OsVal");
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
			}else	
			if(!OsVal.equals(""))
			{
		%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=LinkBabytoMotherDetails.jsp&win_height=33.4&win_width=49.6&function_name=<%=function_name%>&call_function=BabyLinktoMother' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
			
	<%	}
		
		}else
          out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString()); e.printStackTrace();}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
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

