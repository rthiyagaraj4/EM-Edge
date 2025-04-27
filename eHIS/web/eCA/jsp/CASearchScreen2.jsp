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

		<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.* " %>
		<%
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs		 = null;
			//String fac_id    	= (String) session.getValue( "facility_id" ) ;
			String searchcode=request.getParameter("Search_Code");
			String sql="";
			String auth=request.getParameter("p_auth_yn");


			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			String p_code_indicator =(request.getParameter("p_code_indicator")==null)?"":request.getParameter("p_code_indicator");
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
			function loadOtherFrames(fromcode,tocode)
			{
				parent.frames[3].location.href='../../eCommon/html/blank.html'
				parent.frames[2].location.href='CASearchScreen3.jsp?p_auth_yn=<%=auth%>&From_Diag='+fromcode+'&To_Diag='+tocode +'&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>'; 				
				parent.parent.frames[1].document.forms[0].elements(1).disabled=true
			}
		</script>
	</head>
	
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table cellspacing=1 cellpadding=2 width='100%' id='t'  border=0 name='t' id='t'>
		<%
			try
			{
				con = ConnectionManager.getConnection(request);
/*
				sql="select  long_desc, from_diag_code, to_diag_code from mr_icd10_subchapter where chapter_code='"+searchcode+"'";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
*/				

				sql="select  long_desc, from_diag_code, to_diag_code from mr_icd10_subchapter where chapter_code=?";
				stmt=con.prepareStatement(sql);
				stmt.setString(1,searchcode);
				rs=stmt.executeQuery();

				if(rs!=null)
				{
					while(rs.next())
					{	%>
					<tr  onclick='change_row_color(this)'>
					<td>
						<a href=javascript:loadOtherFrames('<%=rs.getString("from_diag_code")%>','<%=rs.getString("to_diag_code")%>') ><font size=1><%=rs.getString("long_desc")%><a><br>
					</td>
					</tr>
			<%	}
				
				}
			
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
			}
			catch(Exception e){
				//out.print(e);//COMMON-ICN-0181
                              e.printStackTrace();//COMMON-ICN-0181
				}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);

			}
		%>
	</body>
</html>

