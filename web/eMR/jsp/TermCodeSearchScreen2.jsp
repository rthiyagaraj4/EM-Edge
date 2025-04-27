<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.*" %>
		<%
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs		 = null;
			String searchcode=request.getParameter("Search_Code");
			String sql="";
			String auth=request.getParameter("p_auth_yn");
			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
		%>
		
		<script>
			var prev=0
			function  change_row_color(obj)
			{
					document.getElementById("t").rows(prev).cells(0).style.backgroundColor=obj.bgColor
					obj.cells(0).style.backgroundColor="#B2B6D7"
					prev	=obj.rowIndex
			}
			function loadOtherFrames(fromcode,tocode)
			{
				parent.frames[3].location.href='../../eCommon/html/blank.html'
				parent.frames[2].location.href='TermCodeSearchScreen3.jsp?p_auth_yn=<%=auth%>&From_Diag='+fromcode+'&To_Diag='+tocode+'&Sex=<%=sex%>&Dob=<%=dob%>'; 				
				parent.parent.frames[1].document.forms[0].elements(1).disabled=true
			}
		</script>
	</head>
	
	<body onKeyDown='lockKey()'>
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
			}
			catch(Exception e){/* out.print(e); */ e.printStackTrace();}
			finally
			{
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
				ConnectionManager.returnConnection(con,request);

			}
		%>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

