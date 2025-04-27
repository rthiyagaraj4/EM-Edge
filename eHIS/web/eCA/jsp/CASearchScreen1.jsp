<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*" %>
		<%
			Connection con=null; 
			
			PreparedStatement stmt 	= null;
			ResultSet rs		 	= null;
			String sql="";
			String auth=request.getParameter("p_auth_yn");
			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			String p_code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");
			//out.println("<script>alert('p_code_indicator:" + p_code_indicator  + "')</script>");	
			%>
		
		<script>
			var prev=0
			function  change_row_color(obj)
			{
					document.getElementById("t").rows(prev).cells(0).style.backgroundColor=obj.bgColor
					obj.cells(0).style.backgroundColor="#d3d3d3"
					prev	=obj.rowIndex
			}
			function loadOtherFrame(code)
			{
				parent.frames[1].location.href='CASearchScreen2.jsp?p_auth_yn=<%=auth%>&Search_Code='+code+'&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';
				parent.frames[2].location.href='../../eCommon/html/blank.html'
				parent.frames[3].location.href='../../eCommon/html/blank.html' 
				parent.parent.frames[1].document.forms[0].elements(1).disabled=true
			}
		</script>
	</head>
	
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table cellspacing = 1 cellpadding = 2 width = '100%' id = 't'  border = 0 name = 't'>
		<%
			try
			{
				
				con = ConnectionManager.getConnection(request);
				sql="select chapter_code, long_desc from mr_icd10_chapter";
				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
				
				if(rs!=null)
				{
					while(rs.next())
					{	%>
					<tr  onclick='change_row_color(this)'>
					<td>
					<a href=javascript:loadOtherFrame('<%=rs.getString("chapter_code")%>') ><font size=1><%=rs.getString("long_desc")%><a><br>					
					</td>
					</tr>
					<%	}
				
				}
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
			}
			catch(Exception e){
				out.print(e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con, request);
			}
		%>
	</body>
</html>

