<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
<title><fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/></title>
  	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
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
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
		
	String str    		= "";
	
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt			= con.createStatement();

		String criteria	 = request.getParameter("criteria");
		if(criteria.equals("dflt"))
		{
			str = " SELECT * FROM dr_def_search_criteria";
			rs = stmt.executeQuery(str);
			if(rs != null)
			{
				if(rs.next())
				{
		 
					%>
					<script>
						parent.frames[1].location.href="../../eDR/jsp/SearchCriteriaMain.jsp?criteria=dflt";
					 </script>
					<%
				}		
				else
				{	
					%>
					<SCRIPT>
						alert(getMessage('NO_RECORDS_FOR_REVIEW','DR'));
						parent.frames[1].location.href="../../eDR/jsp/SearchCriteriaMain.jsp?criteria=prev";
					</SCRIPT>
					<%	
				}
			} if(rs != null) rs.close();
		}
		else if(criteria.equals("prev"))
		{
			str = "SELECT * FROM dr_search_criteria";
			rs  = stmt.executeQuery(str);
			if(rs != null)
			{
				if(rs.next())
				{			
					%>
			 		  <script>		 		  
						parent.frames[1].location.href="../../eDR/jsp/SearchCriteriaMain.jsp?criteria=prev";		
					  </script>
					<%
				}		
				else
				{
					%>
					<SCRIPT>
						alert(getMessage('NO_RECORDS_FOR_REVIEW','DR'));
						parent.frames[1].location.href="../../eDR/jsp/SearchCriteriaMain.jsp?criteria=prev";
					</SCRIPT>
					<%
				}
			} 
		}	

		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

