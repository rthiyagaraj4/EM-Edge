<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
  <!--   <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
  <%
  request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
    String episode_id = request.getParameter("episode_id") ;
    String Facility_Id = (String) session.getValue("facility_id");
    Connection conn  = null;
    Statement stmt= null;
    ResultSet rset= null;
    StringBuffer sql=new StringBuffer();
    try{
        conn  =  ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
        sql.append("select episode_notes from op_episode_for_service ");
        sql.append("where operating_facility_id='"+Facility_Id+"' and ");
        sql.append("episode_id = '"+episode_id+"'");

		rset = stmt.executeQuery(sql.toString());
   
%>
<form name=notes_form>
<b><font size=2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eOP.EpisodeNotes.label" bundle="${op_labels}"/></font></b>
    <table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
    <% if(rset != null)
		{
        if(rset.next()) {
            String notes = rset.getString("episode_notes");
            if(notes == null) notes="";
            out.print("<tr><td>"+notes+"</td></tr>");
        }
		}
    %>
    </table>
<%
    
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();

	sql.setLength(0);

	}
    catch(Exception e){out.println("Excep EPISODE NOTES:"+e);
    }
    finally
    {
		try{	
		if(stmt!=null)stmt.close();
		if(rset!=null) rset.close();
		}catch(Exception e){}
        
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
%>
</form>
</html>



