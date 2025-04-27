<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/BlockBed.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
    request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String url			= "../../eCommon/jsp/commonToolbar.jsp?"; 
	String params		= request.getQueryString() ;
	String source		= url + params ;
	String facilityId	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");
	Connection con		= null;
	ResultSet rs 			= null; 
	Statement stmt 		= null;
	Statement stmt1		= null;
	ResultSet rset 			= null;
	Statement stmt_access 	= null;
	ResultSet rs_access 			= null; 
	Statement stmt_srl_no		= null;
	ResultSet rs_srl_no			= null; 
	PreparedStatement pstmt  = null;
	String gen_booking_srl_yn	= "";
	String retVal					= "";
	
	try{
			con = ConnectionManager.getConnection(request);		
			stmt = con.createStatement();	
			rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
			if(rs.next())
			{	
            pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','BLOCK_BED_YN') from dual");
			pstmt.setString(1,facilityId);
		    pstmt.setString(2,loginUser);
			rset = pstmt.executeQuery();
			if (rset.next())
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
	     	    String sql_srl_next="Select gen_booking_srl_yn from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='B' ";

				stmt_srl_no	=	con.createStatement();
				rs_srl_no		=	stmt_srl_no.executeQuery(sql_srl_next);	
				if ( (rs_srl_no != null) && (rs_srl_no.next()) )
				{
					gen_booking_srl_yn = checkForNull(rs_srl_no.getString("gen_booking_srl_yn"));
				}
				if (!gen_booking_srl_yn.equals(""))
				{
%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			
			<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eIP/jsp/AddModifyBlockBed.jsp?oper_stn_id=<%=retVal%>&gen_booking_srl_yn=<%=gen_booking_srl_yn%>' frameborder=0 style='height:80vh;width:100vw'></iframe>

			<iframe name='messageFrame' id='messageFrame' 		 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>

			<iframe name='messageFrame1' id='messageFrame1' 		 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>
<%
			}
			else
			{%>
				<script>alert(getMessage('SETUP_BOOK_SRL_CTL','IP'))
				document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
		<%	}
		//}
		}
		
	 // Added end 

	}else {%>
            <script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>
		<%}
		if(rs!=null)			rs.close();
		if(stmt!=null)			stmt.close();
		if(rset!=null)			rset.close();
		if(pstmt!=null)			pstmt.close();

    }catch(Exception e){
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
		}
	finally{
		try
		{
		ConnectionManager.returnConnection(con,request);
		if(rs!=null)			rs.close();
	    if(rs_srl_no!=null)		rs_srl_no.close();
		if(rs_access!=null)		rs_access.close();
		if(stmt!=null)			stmt.close();
		if(stmt_srl_no!= null)	stmt_srl_no.close();
		if(stmt1!=null)			stmt1.close();
		if(stmt_access!=null)	stmt_access.close();
		}
		catch(Exception e)
		{
			//out.println("Error while closing the connections:"+e.toString());
			e.printStackTrace();
		}

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

