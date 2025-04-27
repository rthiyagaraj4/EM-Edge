<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
<title> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </title>
  <!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
  <%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  	<script language='javascript' src='../../eDR/js/SearchCriteriaMain.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<%
	
	
	String str    		= "";

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	try
	{
		con	 = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		str  = "SELECT count(*) FROM dr_process_ctl";
		rs   = stmt.executeQuery(str);
		if(rs != null)
		{
			while(rs.next())
			{		
				%>
			 	 <script>		
					document.location.href="../../eDR/jsp/SearchCriteriaAudit.jsp";
				</script> 
				<%
			}
		}
		else
		{
			%>
			<SCRIPT>
				//alert("APP-DR0027 No Access to this function");			
				alert(getMessage('NO_USER_RIGHTS','DR'));
			</SCRIPT>
			<%
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

