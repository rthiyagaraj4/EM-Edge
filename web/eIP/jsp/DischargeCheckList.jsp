
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,com.ehis.util.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script>
function reset()
{
	f_query_add_mod.location.reload();
//	f_query_add_mod.document.forms[0].reset();
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

	f_query_add_mod.document.forms[0].search.disabled = false;
	parent.content.frames[2].location.href			  = "../../eCommon/html/blank.html";
}
</script>

<%
    request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params				= request.getQueryString() ;
	String source				= url + params ;
	String call_function		= "DischargeCheckList";
	String menu_id				= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String function_id			= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	if(menu_id.equals("VIEW_DISCHARGE_CHECKLIST"))
	{
		call_function = "ViewCheckList";
	}
	String facilityId = (String)session.getValue("facility_id");	
	String loginUser = (String)session.getValue("login_user");
	String locncode = request.getParameter("location_code");
		if(locncode == null) locncode= "";
	Connection con  = null;
	ResultSet rs 	= null; 
	Statement stmt 	= null;
    PreparedStatement pstmt = null;
	ResultSet rset          = null;
	String retVal           = "";
	String retValYN			="";

	try{
		con = ConnectionManager.getConnection(request);	
		stmt = con.createStatement();		
		rs = stmt.executeQuery("select DISCHARGE_CHECKLIST_APP_YN from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{            
			retValYN = rs.getString(1);
			pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','DISCHARGE_CHECKLIST_YN') from dual");
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
			/*Wednesday, May 19, 2010 , modified for PE*/
			/*else
			{
				rs = stmt.executeQuery("select DISCHARGE_CHECKLIST_APP_YN from ip_param where facility_id='"+facilityId+"'") ;
				if(rs.next())
				retValYN = rs.getString(1);
			}*/
			if(retValYN.equalsIgnoreCase("Y"))
			{
				if((!retVal.equals("1")) && (!retVal.equals("2")) && (!retVal.equals("3")) && (!retVal.equals("4")) && (!retVal.equals("5")))
				{		
				%>
					<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=DischargeCheckListFrames.jsp&win_height=33.4&win_width=49.6&call_function=<%=call_function%>&menu_id=<%=menu_id%>&wherecondn=DISCHARGE_CHECKLIST_YN&called_from=DischargeCheckList&oper_stn_id=<%=retVal%>' frameborder=0 scrolling='no' noresize style='height:29vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod1' id='f_query_add_mod1' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
					
				<%
				}
			}
			else
			{
				out.println("<script>alert(getMessage('CHKLIST_NOT_APP','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
			}
						
}else
  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
}catch(Exception e){e.printStackTrace();}
	
	finally{
		ConnectionManager.returnConnection(con,request);
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
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

