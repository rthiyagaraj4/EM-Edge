<!DOCTYPE html>
<%@ page import = "webbeans.eCommon.*,java.util.*,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script>
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
	f_query_add_mod.document.forms[0].search.disabled = false;
	parent.content.frames[2].location.href = "../../eCommon/html/blank.html";
}
</script>
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
	String facilityId = (String)session.getValue("facility_id");	
	String loginUser = (String)session.getValue("login_user");
	String locncode = request.getParameter("location_code");
	if(locncode == null) locncode= "";
	String function_id=request.getParameter("function_id");
     if(function_id == null) function_id = "";



	Connection con  = null;
	ResultSet rs 	= null; 
	Statement stmt 	= null;
    PreparedStatement pstmt = null;
	ResultSet rset     = null;
	Statement stmt_srl_no	= null;	
	ResultSet rs_srl_no     = null;
	String retVal="";
	String display_discharge_pat_list	="A";

	try{
		con = ConnectionManager.getConnection(request);	
		stmt = con.createStatement();		
		rs = stmt.executeQuery("select display_discharge_pat_list from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{	
            display_discharge_pat_list	= rs.getString("display_discharge_pat_list");
				if(display_discharge_pat_list == null)
					display_discharge_pat_list	= "A";

			pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','DISCHARGE_PAT_YN') from dual");
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
				String sql_srl_next="Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"
				+facilityId+"' and booking_type='T' ";
				int srl_no=0;
				stmt_srl_no	=	con.createStatement();
				rs_srl_no	=	stmt_srl_no.executeQuery(sql_srl_next);	
				if(rs_srl_no != null)
				if(rs_srl_no.next())
					srl_no	=	rs_srl_no.getInt(1);
					   if(rs_srl_no!=null) rs_srl_no.close();
					  if(stmt_srl_no!=null) stmt_srl_no.close();
				if(srl_no != 0)
				{
%>
					<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=DischargePatient&wherecondn=DISCHARGE_PAT_YN&oper_stn_id=<%=retVal%>&display_discharge_pat_list=<%=display_discharge_pat_list%>' frameborder=0 scrolling='no' noresize style='height:24vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod1' id='f_query_add_mod1' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
					
<%				}
				else
				{
					out.println("<script>alert(getMessage('BED_BKG_SRL_CTRL_NOT_DEFINED','IP'))</script>");
					out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
				}
	      }

}else
  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());e.printStackTrace();}
finally
	{
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

