<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script language='javascript' src='../../eIP/js/CancelAdmission.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 	
<script>
  
	</script>
</head>
<%

	request.setCharacterEncoding("UTF-8");
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;
	String facility = (String) session.getValue( "facility_id" ) ;
    String loginUser= (String)session.getValue("login_user");
    String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";   
	
	Connection con  = null;
	ResultSet rs 	= null; 
	ResultSet rs1 	= null; 
	Statement stmt 	= null;
	Statement stmt1 	= null;
	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facility+"' ") ;
		if(rs.next())
		{
            stmt = con.createStatement();
			rs = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facility+"','"+loginUser+"','N','','CANC_ADMISSION_YN') FROM dual") ;
			rs.next();
	     	String OsVal=rs.getString(1);

			if(OsVal.equals("1"))
			{
			out.print("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(OsVal.equals("2"))
			{
			out.print("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3"))
			{
			out.print("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(!OsVal.equals(""))
             {%>
	     <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=CancelAdmissionMain.jsp&win_height=33.4&dialogTop=120&win_width=65&call_function=CancelAdmission&wherecondn=CANC_ADMISSION_YN&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
	
<%}


}else
  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	
	finally{
		try{
			if(rs!=null) rs.close();
			if(rs1!=null) rs1.close();
			if(stmt!=null) stmt.close();
			if(stmt1!=null) stmt1.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception ee)
		{
			out.println("Error While closing the connections :"+ee.toString());
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

