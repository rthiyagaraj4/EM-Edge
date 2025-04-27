<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.Statement stmt2	= null;
	java.sql.Statement stmt1	= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	ResultSet rs2				= null;

	String user_id	= "";
	String username	= "";
	String step		= "";
	String EmpNo	= "";

	int k	= 0;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		stmt1	= con.createStatement();
		stmt2	= con.createStatement();

		user_id		= request.getParameter("user_id");
		username	= request.getParameter("p_user_name");
		step		= request.getParameter("step");
		EmpNo		= request.getParameter("EmpNo");

		if(EmpNo == null) EmpNo = "";
		if(user_id == null) user_id = "";
		if(username == null) username = "";
		if(step == null) step = "";
		%>

      <html><HEAD>
		  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='userform' id='userform'>

		 <!-- out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><body CLASS='MESSAGE'><form name='userform' id='userform'>");*/ -->
		<%
		if(step.equals("1"))
		{
			String sql = "select EMPLOYEE_NO from sm_appl_user where APPL_USER_ID='"+user_id+"'";
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				while(rs.next())
				{
					EmpNo	= rs.getString("EMPLOYEE_NO");
					if(EmpNo == null) EmpNo = "";
					%>
					<script>
						parent.frames[1]. document.getElementById('EMPNO').value='<%=EmpNo%>';
						parent.frames[1].document.getElementById('EMPNO')EMPNO.disabled=true;
					</script>
					<%
				}
			}
		}
		if(step.equals("2") && !EmpNo.equals(""))
		{
			int i = 0;

			String sql1 = "SELECT count(*) aa FROM sm_appl_user WHERE employee_no = '"+EmpNo+"'";
			rs2 = stmt2.executeQuery(sql1); 
			if(rs2 != null)
			{
				while(rs2.next())
				{
					 k	= rs2.getInt("aa");
				}
			}
			if(k > 0)
			{
				String sql = "SELECT appl_user_id,appl_user_name FROM sm_appl_user WHERE employee_no = '"+EmpNo+"'";
				rs1 = stmt1.executeQuery(sql); 

				if(rs1 != null)
				{
					while(rs1.next())
					{
						user_id		= rs1.getString("appl_user_id");
						username	= rs1.getString("appl_user_name");
						i++;
					}
				}
				if( i <= 1)
				{
					%>
					<script>
						parent.frames[1].document.getElementById('userID').value='<%=username%>';
						parent.frames[1].document.getElementById('p_user_name').value='<%=user_id%>';
					</script>
					<%
				}
				else
				{
					%>
					<script>
						parent.frames[1].document.getElementById('userID').value			= '';
						parent.frames[1].document.getElementById('p_user_name').value	= '';	
					</script>
					<%
				}
			}
			else
			{
				%>
				<script>
				var gm  = getMessage("INVALID_VALUE","Common");
				gm = gm.replace("#",getLabel("Common.EmployeeNo.label","Common"));
				alert(gm);	
				parent.frames[1].document.getElementById('userID').value			= '';
				parent.frames[1].document.getElementById('p_user_name').value	= '';
				parent.frames[1].document.getElementById('EMPNO').value			= '';	
				parent.frames[1].document.getElementById('EMPNO').focus();	
			</script>
			<%
		}		
	}

	if(rs !=null) rs.close();
	if(rs1 !=null) rs1.close();
	if(rs2 !=null) rs2.close();
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
	if(stmt2 !=null) stmt2.close();
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
</form>
</body>
</html>

