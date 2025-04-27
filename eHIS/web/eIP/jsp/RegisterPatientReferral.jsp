<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*"%>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String facility_id	= (String)session.getAttribute("facility_id");
String loginUser		=	checkForNull((String)session.getValue("login_user"));
%>

<html>
<head>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<script>
	function reset()
	{
		f_query_add_mod.document.forms[0].reset();
		f_query_add_mod1.location.href = "../../eCommon/html/blank.html";
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
		frames[1].document.forms[0].search.disabled=false;
	}
</script>
<%
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String locncode = request.getParameter("location_code");
	String function_id=request.getParameter("function_id");
	/*below Line Added for this CRF Bru-HIMS-CRF-182.1 */
	String invokedModule = request.getParameter("invokedModule")==null?"":request.getParameter("invokedModule");	
    if(function_id == null) function_id = "";
		if(locncode == null) locncode= "";
	//String wherecondn	= "ADMIT_PAT_YN";
	String wherecondn	= "REG_IP_REFERRAL_YN";
	Connection con		= null;
	ResultSet rs 		= null; 
	PreparedStatement pstmt 		= null;
	try
	{
	con = ConnectionManager.getConnection(request);	
	String sqlQuery = "" ;
	sqlQuery = "select 1,AM_OPER_STN_ACCESS_CHECK(?,?,'N','','REG_IP_REFERRAL_YN') OsVal from ip_param where FACILITY_ID =? " ;
	pstmt = con.prepareStatement(sqlQuery);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,loginUser);
	pstmt.setString(3,facility_id);
	rs =pstmt.executeQuery();
	if(rs.next())
	{		
		String OsVal=rs.getString("OsVal")==null?"":rs.getString("OsVal");
		if(OsVal.equals("1")) {			out.print("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(OsVal.equals("2")) {
			out.print("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(OsVal.equals("3")) {
			out.print("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(OsVal.equals("4")) {

			out.print("<script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}else if(OsVal.equals("5")) {
			out.print("<script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		} else if(!OsVal.equals("")) {	
		/*below Condtion Added for this CRF Bru-HIMS-CRF-182.1 */	
		if(invokedModule.equals("CA")){ %>
				<iframe name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' 		src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintReferralPatientDetails.jsp&win_height=27&win_width=48&call_function=ReferralPatientDetails&wherecondn=<%=wherecondn%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:65vh;width:100vw'></iframe>
				<iframe name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
		<!--Santhosh starts ML-MMOH-CRF-1894-->
		<%}else if(function_id.equals("REG_PATIENT_REFERRAL")){%>
				<iframe name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' 		src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintReferralPatientDetails.jsp&win_height=27&win_width=48&call_function=ReferralPatientDetails&wherecondn=<%=wherecondn%>' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:51vh;width:100vw'></iframe>
				<iframe name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
		<!--Santhosh end-->
		<%}else{%> 
				<iframe name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' 		src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintReferralPatientDetails.jsp&win_height=27&win_width=48&call_function=ReferralPatientDetails&wherecondn=<%=wherecondn%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:57vh;width:100vw'></iframe>
				<iframe name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
		<% }%>
			</html>
<%	}
	}
	else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));</script>");
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}

	if(rs	!= null)   rs.close();
	if(pstmt  != null)   pstmt.close();	
	}catch(Exception e)
	{
		out.println("Exception in tryCatch RegisterPatientReferral : "+ e.toString());
		e.printStackTrace();
	}	
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}			
		
%>
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
