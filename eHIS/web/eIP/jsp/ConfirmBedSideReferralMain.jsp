<!DOCTYPE html>
<%
/*
*******************************************************************************************
* @Module			: InPatient Management [IP]
* @Function Name	: Inpatient Referral -> Confirm Bedside Referral 
* @Author			: SRIDHAR R 
* @Created Date		: 6 JULY 2004
* @Funtion			: This function provides the receipt for Bedside Visit in Register Inpatient Referral...
*******************************************************************************************
*/
%>
<%@ page  contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String facility_id	= (String)session.getAttribute("facility_id");
String loginUser		=	checkForNull((String)session.getValue("login_user"));
%>
<html>
<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
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
	request.setCharacterEncoding("UTF-8"); 
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	Connection con		= null;
	ResultSet rs 		= null; 
	ResultSet rset 		= null; 
	Statement stmt 		= null;
	try
	{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();

	rs = stmt.executeQuery("select 1 from ip_param where facility_id = '"+facility_id+"'") ;
	if(rs.next())
	{

		rset = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+loginUser+"','N','','CONFIRM_BEDSIDE_REFERRAL_YN') FROM dual") ;
		rset.next();
		String OsVal=rset.getString(1);
		if(OsVal.equals("1"))
		{
			out.print("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(OsVal.equals("2"))
		{
			out.print("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(OsVal.equals("3"))
		{
			out.print("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(OsVal.equals("4"))
		{
			out.print("<script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}else if(OsVal.equals("5"))
		{
			out.print("<script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else if(!OsVal.equals(""))
		{	%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/ConfirmBedsideReferralCriteria.jsp?<%=source%>&jsp_name=ConfirmBedSideReferralDetail.jsp&win_height=27&win_width=48&call_function=BedSideReferral' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
				<iframe name='messageFrame2' id='messageFrame2' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
			</html>
<%		}
	}else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));</script>");
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}
	if(rs	!= null)   rs.close();
	if(stmt  != null)   stmt.close();	
	}catch(Exception e)
	{
		out.println("Exception in tryCatch ConfirmBedSideReferralMain : "+ e.toString());
	}	finally
	{
		ConnectionManager.returnConnection(con,request);
	}			
		
%>

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

