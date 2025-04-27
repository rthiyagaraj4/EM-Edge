<!DOCTYPE html>
<%--
	FileName	: FetchValForUserForOperStn.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>

<%
request.setCharacterEncoding("UTF-8");
String sql=" ";
		Connection con = null;
		Statement stmt = null;
		Statement stmt1 = null;
		
		ResultSet rset=null;
		ResultSet rset1=null;
		
		String sql1="";
		String code="";
		String desc="";
		String name=request.getParameter("name");
		String value=request.getParameter("value");		
		String comp=" ";		
	try
	{	con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		stmt1= con.createStatement();
		if(name!=null)
			name=name.trim();
	
		if(name.equals("userid"))
		{
			sql = "select facility_id,facility_name from sm_facility_for_user_vw  where appl_user_id='"+value+"'";// and facility_id='"+fid+"'";
			comp="parent.document.frames[1].document.forms[0].facility";
		}
		if(name.equals("facility"))
		{
			  sql1=" select oper_stn_id, short_desc from am_oper_stn where facility_id='"+value+"' and eff_status='E' order by short_desc";
			sql="select appl_user_id  ,appl_user_name  from sm_facility_for_user_vw where facility_id='"+value+"'";
			comp="parent.f_query_add_mod.document.forms[0].userid";
		}
		
			if(sql!=null || sql.equals(""))
				//rset = stmt.executeQuery(sql);
				rset1 = stmt1.executeQuery(sql1);
				

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");

	comp="parent.f_query_add_mod.document.forms[0].oprstn";
		if(rset1 != null) 
		{
		while( rset1.next() ) 
		{
			code=rset1.getString(1);
			desc=rset1.getString(2);
%>
	<script>
				
			var temp = "<%=code%>";
			var temp1="<%=desc%>";
			var opt=parent.f_query_add_mod.document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=<%=comp%>
			comp.add(opt)
	</script>
<%		   	  
		}
		}		
		
	}
	catch(Exception e){out.print(e);out.print("<br>sql:"+sql);}
	finally {
		try
		{
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();
		if (rset != null) rset.close();
		if (rset1 != null) rset1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);

	}
	
	%>

