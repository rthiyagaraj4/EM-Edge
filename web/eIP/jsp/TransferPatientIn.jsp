<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eCommon/js/common.js'></script>	
	 
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
		parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	}
</script>

<%
    request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId = (String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");		
	String locncode = request.getParameter("location_code");
		if(locncode == null) locncode= "";
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";

	Connection con			= null;
	ResultSet rs 			= null; 
	Statement stmt 			= null;
	Statement stmt_opr		= null;
	Statement stmt_clinic	= null;
	ResultSet rset_opr 		= null;
	ResultSet rset_clinic	= null;
	String priotity_status  = "N";
	int srl_no				= 0;
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		rs = stmt.executeQuery("select PRIORITY_APPLICABLE_YN from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{
			if(rs != null)
			{
				priotity_status=rs.getString("PRIORITY_APPLICABLE_YN");
				if(priotity_status == null) priotity_status="N";
			}

			stmt = con.createStatement();
			/*Tuesday, May 04, 2010 , modified for PE*/
			//rs = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','TRANSFER_IN_PATIENT_YN') FROM dual") ;
			rs = stmt.executeQuery("Select count(*) ,AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','TRANSFER_IN_PATIENT_YN') from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T'") ;
			rs.next();
			srl_no	=	rs.getInt(1);
			String OsVal=rs.getString(2);
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
			}else	if(!OsVal.equals(""))
				{
					/*Tuesday, May 04, 2010 , commnted for PE*/
					/*
					String sql_srl_next="Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ";
					
					stmt1	=	con.createStatement();
					rs1		=	stmt1.executeQuery(sql_srl_next);	
					if(rs1 !=null && rs1.next())
					srl_no	=	rs1.getInt(1);

					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					*/
					if(srl_no != 0)
					{

	/*					String QUERY_PRIORITY_APPLICABLE=" select PRIORITY_APPLICABLE_YN from ip_param where facility_id='"+facilityId+"' ";

						stmt_pri=con.createStatement();
						rs_pri=stmt_pri.executeQuery(QUERY_PRIORITY_APPLICABLE);

						if(rs_pri != null && rs_pri.next())
						{
							priotity_status=rs_pri.getString("PRIORITY_APPLICABLE_YN");
							if(priotity_status == null) priotity_status="N";
						}
						if(rs_pri!=null) rs_pri.close();
						if(stmt_pri!=null) stmt_pri.close();
	*/
						if(priotity_status.equals("Y"))
						{	%>
							<iframe name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=TransferPatientInFrames.jsp&win_height=32.5&win_width=49.6&call_function=TransferPatientIn&wherecondn=TRANSFER_IN_PATIENT_YN&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no' noresize style='height:36vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:42vh;width:100vw'></iframe>
							<iframe name='desc_frame' src='QuerySearchResultFrames.jsp' frameborder=0 noresize scrolling='auto' style='height:4vh;width:100vw'></iframe>
							<iframe name='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
					<%	}
						else
						{	%>
							<iframe name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=TransferPatientInFrames.jsp&win_height=32.5&win_width=49.6&call_function=TransferPatientIn&wherecondn=TRANSFER_IN_PATIENT_YN&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no' noresize style='height:36vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:46vh;width:100vw'></iframe>
							<iframe name='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
					<%	}	%>
							
				<%	}
					else
					{	%>
						<script>
							alert(getMessage('SETUP_BOOK_SRL_CTL','IP'))
							document.location.href ='../../eCommon/jsp/dmenu.jsp'
						</script>
				<%	}
				}
				
		
		}else
		{
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(rset_opr !=null )rset_opr.close();
		if(rset_clinic!=null) 	rset_clinic.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
	
	}catch(Exception e){
		
		e.printStackTrace();
		}
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
