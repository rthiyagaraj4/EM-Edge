<!DOCTYPE html>
<%@ page   contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
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
			parent.frames[2].frames[1].document.forms[0].search.disabled = false;
		parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
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
		String facilityId	= (String)session.getValue("facility_id");
        String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		String loginUser = (String)session.getValue("login_user");		
		String locncode = request.getParameter("location_code");
			if(locncode == null) locncode= "";

		Connection con  = null;
		ResultSet rs 	= null; 
		Statement stmt 	= null;
		PreparedStatement pstmt = null;
        ResultSet rset     = null;

		String oper_stn_id = "";
		Statement stmt_opr		= null;
		Statement stmt_clinic	= null;
		Statement stmt_srl_no	= null;	
		ResultSet rset_opr 		= null;
		ResultSet rset_clinic	= null;
		ResultSet rs_srl_no     = null; 
		String retVal           = "";

		try{
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
			if(rs.next())
			{
			pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','ROUTINE_TFR_YN') from dual");
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
				StringBuffer sql_srl_next = new StringBuffer();
				sql_srl_next.append("Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ");
				int srl_no=0;
				stmt_srl_no	=	con.createStatement();
				rs_srl_no	=	stmt_srl_no.executeQuery(sql_srl_next.toString());	
				if(rs_srl_no != null)
				if(rs_srl_no.next())
					srl_no	=	rs_srl_no.getInt(1);
				if(srl_no != 0)
				{
					%>
					        <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintBedBookingTransfer.jsp&win_height=33.4&win_width=49.6&call_function=RequestforTransfer&wherecondn=ROUTINE_TFR_YN&oper_stn_id=<%=oper_stn_id%>' frameborder=0 scrolling='no' noresize style='height:22vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
							<iframe name='desc_frame' id='desc_frame' 	src='QuerySearchResultFrames.jsp?step=bedbook' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
							<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
					
					<% 
				}
				else
				{
				    out.println("<script>alert(getMessage('BED_BKG_SRL_CTRL_NOT_DEFINED','IP'))</script>");
					out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
				}
			  }
	}
	else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
}catch(Exception e){
	//out.println("Exception in tryCatch : "+ e.toString());
	e.printStackTrace();
	}
finally{
		try
	{

		if(rs!=null)			rs.close();
		if(rs_srl_no!=null)     rs_srl_no.close();
		if(rset_opr!=null)      rset_opr.close();
		if(rset_clinic!=null)     rset_clinic.close();
		if(stmt!=null)			stmt.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
		if(stmt_srl_no!=null)   stmt_srl_no.close();	
	}
	catch(Exception e)
	{
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
		}
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

