<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
	
	<script language ='javascript' src='../../eCommon/js/common.js'></script>
	
	<script language ='javascript' src='../../eIP/js/SwapPatientBeds.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<%
	String url				= "../../eCommon/jsp/commonToolbar.jsp?";
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facilityId		= (String)session.getValue("facility_id");
	String facility = (String) session.getValue( "facility_id" ) ;
	String loginUser		= (String)session.getValue("login_user");
	Connection con			= null;
	//ResultSet rset 			= null; 
	ResultSet rs1 			= null; 
	//Statement stmt 			= null;
	Statement stmt1			= null;
	String OsVal			="";
	//StringBuffer sqlSb		= new StringBuffer();
	int srl_no				= 0;
try
{
	con		= ConnectionManager.getConnection(request);	
	stmt1	= con.createStatement();		
	//rs1		= stmt1.executeQuery("select 1 from IP_PARAM where facility_id='"+facilityId+"' ") ;
	/*Wednesday, June 02, 2010 , modified for PE*/
	rs1		= stmt1.executeQuery("select 1,(Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T')cnt,(AM_OPER_STN_ACCESS_CHECK('"+facility+"','"+loginUser+"','N','','SWAP_BED_YN')) OsVal from IP_PARAM where facility_id='"+facilityId+"' ") ;
	if(rs1.next())
	{	
		
		srl_no	=	rs1.getInt("cnt");
		OsVal	=	rs1.getString("OsVal");
		/* stmt	= con.createStatement();	
		rset	= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facility+"','"+loginUser+"','N','','SWAP_BED_YN') FROM dual") ;
		rset.next();
	    OsVal=rset.getString(1); Friday, June 11, 2010 PE_EXE venkat S*/

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
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {
	        /*Wednesday, June 02, 2010 , commented for PE*/
			 /*if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			sqlSb.append("Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ");
			int srl_no=0;
			stmt		=	con.createStatement();
			rset		=	stmt.executeQuery(sqlSb.toString());	
			if(rset != null)
			if(rset.next())
			srl_no	=	rset.getInt(1);*/
			if(srl_no != 0)
			{	%>

    			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/SwapPatientBedsCriteria.jsp?jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=SWAP_PAT_BED&wherecondn=SWAP_BED_YN&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod1' id='f_query_add_mod1' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:49vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod2' id='f_query_add_mod2' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
				
		<%
			}
			else
			{%>
				<script>alert(getMessage('SETUP_BOOK_SRL_CTL','IP'))
				document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
		<%	}
		}
	}else {%>
		<script>
			alert(getMessage('IP_PARAM_NOT_FOUND','IP'));
			document.location.href= '../../eCommon/jsp/dmenu.jsp'
		</script>
<%	}
	//if(rset!=null)rset.close();
	//if(stmt!=null)stmt.close();

}catch(Exception e)
{
	out.println("Exception in tryCatch : "+ e.toString());
}

finally
{
	try
	{
		ConnectionManager.returnConnection(con,request);
		if(rs1!=null)  rs1.close();
	//	if(rset!=null) rset.close();
	//	if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
		
	}catch(Exception e)
	{
		out.println("Error while closing the connections:"+ e.toString());
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

