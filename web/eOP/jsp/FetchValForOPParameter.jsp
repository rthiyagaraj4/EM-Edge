<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		request.setCharacterEncoding("UTF-8");
		String sql=" ";
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		try{
			con=ConnectionManager.getConnection(request);
		
		stmt = con.createStatement();
		rset=null;
		String code="";
		String desc="";
		String selval=request.getParameter("selval");
		String comp=" ";
		String sel="";
		if(sel==null)
			selval="";
		sql = "select disp_type, short_desc from am_disposition_type where eff_status='E' and use_at_concl_yn='Y' order by 2";
		comp="parent.frames[1].document.forms[0].disptype";
		rset = stmt.executeQuery(sql);
		
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey();'><form name='nam1' id='nam1'>");
		if(rset != null) 
		{
			while( rset.next() ) 
			{
				code=rset.getString(1);
				desc=rset.getString(2);
				
	%>
		<script>
				var temp = "<%=code%>";
				var temp1="<%=desc%>";
				var opt=parent.document.frames[1].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				var comp=<%=comp%>
				if('<%=selval%>'==temp)
					opt.selected=true
					
				comp.add(opt)
		</script>
	<%	
				sel="";
			}
		}
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (stmt != null) stmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	%>

