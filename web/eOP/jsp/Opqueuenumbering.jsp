<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String facilityid=(String)session.getValue("facility_id");  

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOP/js/Opqueuenumbering.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String assign_q_num_by = "";

	Connection con = null;
	Statement stmt=null;	
	ResultSet rs=null;

	try {
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs = stmt.executeQuery("select ASSIGN_QUEUE_NUM_BY from op_param where OPERATING_FACILITY_ID ='"+facilityid+"'");

		if(rs!=null){
			if(rs.next())
			{
				assign_q_num_by = rs.getString("ASSIGN_QUEUE_NUM_BY");
			}
		}
		if(assign_q_num_by.equals("M"))
		{
			out.println("<script>alert(getMessage('QUEUE_NUM_CTRL_DEFINED_MANUAL','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
		else {
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	<iframe name='dummyframe' id='dummyframe' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

<%		
	}
    }
    catch (Exception e) { 
		e.printStackTrace();
		//out.println(e) ; 
		}
	finally{
	 if(con != null) ConnectionManager.returnConnection(con,request);
	 if(rs!=null) rs.close();
	 if(stmt!=null) stmt.close();
}
%>

</html>

