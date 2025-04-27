<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
</HEAD>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rst			= null;

	String appl_user_id			   = "";
	String mysql				   = "";	
	String primary_splty_long_desc = "";	
	String pract_type_desc		   = "";
	
	int record_count = 0;

	try
	{
		con	 = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		appl_user_id = request.getParameter("appl_user_id");

		if(appl_user_id == null || appl_user_id.equals("null")) appl_user_id = "";

		
		mysql = "SELECT pract_type_desc,primary_splty_long_desc FROM  am_practitioner_vw where PRACTITIONER_ID = '"+appl_user_id+"'";
		
		rst  = stmt.executeQuery(mysql);
		if(rst != null && rst.next())
		{
			pract_type_desc			= rst.getString("pract_type_desc"); 
			primary_splty_long_desc = rst.getString("primary_splty_long_desc");
			
			record_count++;
		}

		if(pract_type_desc == null || pract_type_desc.equals("null")) pract_type_desc = "";
		if(primary_splty_long_desc == null || primary_splty_long_desc.equals("null")) 						primary_splty_long_desc = "";
		
		if(record_count != 0)
		{
			%>
			<SCRIPT>
				parent.frames[3].document.getElementById("td1").innerHTML = getLabel("Common.designation.label","common");
				parent.frames[3].document.getElementById("td2").innerHTML = "<%=pract_type_desc%>";
				parent.frames[3].document.getElementById("td3").innerHTML = getLabel("Common.primaryspeciality.label","common");
				parent.frames[3].document.getElementById("td4").innerHTML = "<%=primary_splty_long_desc%>";
			</SCRIPT>
			<%
		}
	if(rst  != null)  rst.close();
	if(stmt != null) stmt.close();
	}catch(Exception e){out.println("Exception e" + e.toString());}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>

