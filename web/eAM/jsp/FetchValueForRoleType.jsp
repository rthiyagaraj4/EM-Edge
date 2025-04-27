<!DOCTYPE html>
<%--
	FileName	: FetchValueForRoleType.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>

<%
request.setCharacterEncoding("UTF-8");
		String sql="";
		Connection con = null;
		Statement stmt = null;
		ResultSet rset=null;
		String code1="";
		String desc="";
		String role_type=request.getParameter("role_type");
		String comp=" ";
try
	{	
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		
	
		if(role_type.equals("P"))
			{
				sql = "	select pract_type,desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef ";
			}
		else
			{
				sql="select other_staff_type,short_desc from am_other_staff_type where eff_status = 'E' order by short_desc";
			}
		comp="parent.f_query_add_mod.document.forms[0].staff_type";
		rset = stmt.executeQuery(sql);
		
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='name1' id='name1'>");

		while( rset.next() ) 
		{
			desc=rset.getString(1);
			code1=rset.getString(2);
			%>
	<script>
			var temp = "<%=code1%>";
			var temp1="<%=desc%>";
			var opt=parent.f_query_add_mod.document.createElement("OPTION");
			opt.text=temp;
			opt.value=temp1;
			var comp=<%=comp%>;
			comp.add(opt)
	</script>
<%	
		}
	}
	catch(Exception e)
	{
		out.print(e);out.print("<br>sql:"+sql);
	}
	finally 
	{
		try
		{
			if (stmt != null) stmt.close();
			if (rset != null) rset.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);

	}
	
	%>

