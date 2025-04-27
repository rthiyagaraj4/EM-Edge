<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
PreparedStatement stmt = null;
ResultSet rs = null ;
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try
{

	String term_set_id   =  request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
	term_set_id          =  term_set_id.trim();
	String term_code	 =  request.getParameter("term_code")==null?"":request.getParameter("term_code");
	term_code			 =  term_code.trim();

	if (!(term_set_id.equals("") && term_code.equals(""))){		

		con=ConnectionManager.getConnection(request);
		
		boolean rs_chkk=false;
		String long_desc	= "";
		String short_desc	= "";
		
		String term_code_sql= "";

		if (!term_code.equals(""))
		{

			term_code_sql="select term_code,short_desc ,long_desc from mr_term_code where term_set_id like upper(?) and term_code like upper(?)";

			stmt = con.prepareStatement(term_code_sql);
			stmt.setString(1,term_set_id);//term_set_id
			stmt.setString(2,term_code);//term_code
			rs = stmt.executeQuery();
			if(rs.next())
			{
				rs_chkk=true;
				short_desc  = rs.getString("short_desc");
				long_desc	= rs.getString("long_desc");
				
				String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
					+"top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].LongDescription.value='"+long_desc
					+"';top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].Description.value='"+short_desc +"'</script></head><body CLASS='MESSAGE'></body></html>";
				
				out.println(a1);
			}
			String a2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>";
		
			if(long_desc !=null && !long_desc.equals(""))
			{
				a2=a2+"top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].exclamation.style.display='inline'"	;
				
			}else{
			a2 = a2+"top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].exclamation.style.display='none'" ;		
			}
			a2 = a2+"</script></head><body CLASS='MESSAGE'></body></html>";
			out.println(a2);
			
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();

			if(!rs_chkk)
			{
				
				out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE'><script>top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].LongDescription.value='';top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].Description.value='';top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].diagprob_desc.select();document.write('OP0017 - Invalid procedure code');</script></body><html>");
			}
		}
	}else{
			//out.println("<script>alert('"+term_code+"')</script>");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE'><script>top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].Description.value='';</script></body>");

	}

		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
}catch(Exception e)
{
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	out.println("<html><head><link  rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE'></body>");
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
