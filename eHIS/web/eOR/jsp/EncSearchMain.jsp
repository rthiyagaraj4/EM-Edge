<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date       		Edit History      Name        		Description
-----------------------------------------------------------------------
?             	100            		?           		created
21/10/2015		IN057196		Ramesh G		Recording Of Consent Form
-----------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eOR/js/EncSearch.js' language='javascript'>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
</head>
<%
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;
	String sql		=	"";
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String cnsnt_with_order_yn=request.getParameter("cnsnt_with_order_yn")==null?"N":request.getParameter("cnsnt_with_order_yn"); //IN057196
	try
	{
		con			=	ConnectionManager.getConnection(request);
		stmt		=	con.createStatement();
		String install_yn="";
			
		sql=" Select install_yn from sm_module where module_id = 'OR' ";
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			 install_yn = rs.getString("install_yn");
		}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();

		if(install_yn == null || install_yn.equals("null"))
		install_yn = "N";
		
		if(install_yn.equals("Y"))
		{
		}
		else
		{			
			out.println("<script> alert(getMessage('OR_NOT_INSTALLED','SM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
		}
	}
	catch(Exception e)
	{
		out.println("Exception while fetching connection :"+e);
	}
	finally
	{				
		ConnectionManager.returnConnection(con, request);
	}

	if(call_function.equals("GEN_PLACE_ORDER"))
	{			
	%>
		
		<!-- <frameset rows='6%,34%,*,5%'>-->
			<iframe name='commontoolbarFrame'  id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
			<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eOR/jsp/EncSearchCriteria.jsp?jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=<%=call_function%>&cnsnt_with_order_yn=<%=cnsnt_with_order_yn%>' noresize frameborder=0 style='height:31vh;width:100vw'></iframe>
			<iframe scrolling="auto" name='content' id='content' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:53vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
		<!-- </frameset> -->
	<%	
	}
	%>
	</html>
	<%!	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	? "" : inputString;
		}

		private String checkForNull(String inputString, String defaultValue)
		{
			return (inputString==null)	? defaultValue : inputString;
		}
	%>

