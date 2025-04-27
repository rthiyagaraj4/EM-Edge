<!DOCTYPE html>
<%
/*
This Jsp is used for Mp-Parameter Setup.(Called from mp_param.jsp)
This in Intermediate Jsp used for validations in Mp-Param Function
@author - Shyam Prasad.P. 
@version - V3
*/
%>
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="JavaScript" src="../js/mp_param.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
    String relationship_code       = "" ;
    String short_desc       = "" ;

	Connection con = null;
    Statement pstmt = null;
    ResultSet rs        = null;
	String callfunction=request.getParameter("callfunction");
	

	try{
			con = ConnectionManager.getConnection(request);
			if(callfunction.equals("populateRelation")){
			pstmt = con.createStatement();
			rs = pstmt.executeQuery("select relationship_code, short_desc from mp_relationship");
			while (rs.next())
			{		
			  relationship_code = rs.getString("relationship_code");
			  short_desc = rs.getString("short_desc");%>
			  <script>
						
				var temp = "<%=relationship_code%>";
				var temp1="<%=short_desc%>";
				var opt=parent.frames[1].document.createElement("OPTION");	
				opt.text=temp1;
				opt.value=temp;
				parent.frames[1].document.forms[0].org_member_relationship_code.add(opt);
			 </script>
			<%}																		  
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		}
	}

	catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174282188 on 24-08-2023
		}
	finally
	{
    
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
    
%>

