<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/ReleaseBed.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url				= "../../eCommon/jsp/commonToolbar.jsp?"; 
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String formUrl			= "ReleaseBed.jsp";
	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";

	Connection con		= null;
	ResultSet rs 			= null; 
	Statement stmt 		= null;
	ResultSet rset 			= null;
	ResultSet rset1 			= null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	String retVal				 = "";
	String retVal1				 = "";
	String reserve_bed_on_tfr_yn = "";

	try{
			con = ConnectionManager.getConnection(request);		
			stmt = con.createStatement();		

			//rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
			rs = stmt.executeQuery("select 1,RESERVE_BED_ON_TFR_YN from ip_param where facility_id='"+facilityId+"' ") ;

			if(rs.next())
			{	
				reserve_bed_on_tfr_yn = rs.getString("RESERVE_BED_ON_TFR_YN");
				pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','RELEASE_BED_YN') from dual");
				pstmt.setString(1,facilityId);
				pstmt.setString(2,loginUser);
				rset = pstmt.executeQuery();
				if(rset.next())
				{
					retVal = rset.getString(1);
				}
				/**/
				pstmt1 = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CANCEL_RESERVE_BED_YN') from dual");
				pstmt1.setString(1,facilityId);
				pstmt1.setString(2,loginUser);
				rset1 = pstmt1.executeQuery();
				if(rset1.next())
				{
					retVal1 = rset1.getString(1);
				}
				/**/
				if(retVal.equals("1") || retVal1.equals("1")){
					out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}
				else if(retVal.equals("2") || retVal1.equals("2")){
					out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}
				else if(retVal.equals("3") || retVal1.equals("3")){
						out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
						out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
				}else  if(retVal.equals("4") || retVal1.equals("4"))
				{
				out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(retVal.equals("5") || retVal1.equals("5"))
				{
				out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}
				else if(((!retVal.equals("1")) && (!retVal.equals("2")) && (!retVal.equals("3")) && (!retVal.equals("4")) && (!retVal.equals("5"))) || ((!retVal1.equals("1")) && (!retVal1.equals("2")) && (!retVal1.equals("3")) && (!retVal1.equals("4")) && (!retVal1.equals("5"))))
				{		
		      %>
				  <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src= '<%= formUrl %>?function_id=<%=function_id%>&oper_stn_id=<%=retVal%>&reserve_bed_on_tfr_yn=<%=reserve_bed_on_tfr_yn%>' frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	  	  <%}
	  }
	  else
        out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
			if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();


		if(rs!=null) rs.close();
		if(rset!=null) rset.close();
		if(rset1!=null) rset1.close();
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();

    }
	
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
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

