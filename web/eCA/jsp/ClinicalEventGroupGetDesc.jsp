<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.net.URLDecoder" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCA/js/ClinicalEventGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()"   onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name='ClinicalEventGroupForm' id='ClinicalEventGroupForm'>

 <%
	String groupid="";
	String sqlquery="";
	String longdesc="";
    
    groupid = request.getParameter("groupid")==null?"":request.getParameter("groupid");
    sqlquery = java.net.URLDecoder.decode((request.getParameter("sqlquery")==null?"":request.getParameter("sqlquery")));
    
	Connection con = null;
	Statement  stmt = null;
	ResultSet	rs = null;
	try{
		con=ConnectionManager.getConnection(request);
       
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlquery);
          
		if(rs!=null && rs.next())
		{
             
	 	longdesc = rs.getString("long_desc");
	    out.println("<script>setLongDesc('"+longdesc+"')</script>");
	 	}
        
		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	}
	catch(Exception e){
		e.printStackTrace();
	//	out.println("Exception "+e);//COMMON-ICN-0181

	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>

</form>
</body>
</html>

