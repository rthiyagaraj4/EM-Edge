<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html><head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><body CLASS='MESSAGE' onMouseDown="CodeArrest()" onKeyDown="lockKey()"></body>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String age_group = request.getParameter("age_group");
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	try{
		  con = ConnectionManager.getConnection(request);
		 
			stmt= con.createStatement();	
			
			String sql_check="Select count(*) from am_age_group where age_group_code='"+age_group+"'";
			ResultSet rs_check=stmt.executeQuery(sql_check);
			rs_check.next();
			int count=rs_check.getInt(1);
			if(count==0) 
			{%>
				<script>
				alert(getMessage("INVALID_AGE_GROUP_CODE","IP"));
				parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[0].document.forms[0].age_group.value='';
				parent.frames[1].frames[0].document.forms[0].age_group.focus();
				</script>
			<%}
			else
			{
				%>
				<script>
				parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[0].document.forms[0].search_age.focus();
				</script>
			<%
			}
		}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	
%>	
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

