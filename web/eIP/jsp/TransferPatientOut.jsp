<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  %>
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
	String url				="../../eCommon/jsp/commonToolbar.jsp?";
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String function_id		= request.getParameter("function_id");
        if(function_id == null) function_id = "";
	Connection con			= null;
	ResultSet rs 			= null; 
	Statement stmt 			= null;
	Statement stmt_opr		= null;
	ResultSet rset_opr 		= null;
	String priotity_status  = "";	

	try{

		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		rs = stmt.executeQuery("select priority_applicable_yn from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{	stmt = con.createStatement();
			priotity_status = checkForNull(rs.getString("priority_applicable_yn"));
			rs = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','TRANSFER_OUT_PATIENT_YN') FROM dual") ;
			rs.next();
	     	String OsVal=rs.getString(1);
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
		%>
		<%
			/*Monday, May 03, 2010 , commented for PE  */
			/*
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select priority_applicable_yn from ip_param where facility_id='"+facilityId+"'");
			try
			{
				stmt_opr=con.createStatement();
				rset_opr=stmt_opr.executeQuery(sqlQuery.toString());
				
				if(rset_opr != null && rset_opr.next())
				{
					priotity_status=checkForNull(rset_opr.getString("PRIORITY_APPLICABLE_YN"));
				if(rset_opr	!= null)   rset_opr.close();
				if(stmt_opr  != null)   stmt_opr.close();		
				}
			}
			catch(Exception e)
			{
			}
			*/
		
		%>
	<%	if(priotity_status.equals("Y"))
		{	%>
				<iframe name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=TransferPatientOutFrames.jsp&win_height=31.5&win_width=49.6&call_function=TransferPatientOut&wherecondn=transfer_out_patient_yn&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no' noresize style='height:36vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:42vh;width:100vw'></iframe>
				<iframe name='desc_frame' src='QuerySearchResultFrames.jsp' frameborder=0 noresize scrolling='auto' style='height:4vh;width:100vw'></iframe>
				<iframe name='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
	<%	}else{	%>
				<iframe name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=TransferPatientOutFrames.jsp&win_height=31.5&win_width=49.6&call_function=TransferPatientOut&wherecondn=transfer_out_patient_yn&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no' noresize style='height:29vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:57vh;width:100vw'></iframe>
				<iframe name='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:7vh;width:100vw'></iframe>
	<%	}	%>

<%	if(rs	!= null)   rs.close();
	if(stmt  != null)   stmt.close();		
	}}else
      out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	
		if(rset_opr !=null )rset_opr.close();
		if(stmt_opr!=null) 		stmt_opr.close();
	
	
		}catch(Exception e)
		{
			
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
