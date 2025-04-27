<!DOCTYPE html>

<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*"  contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
String assess_note_id=request.getParameter("assess_note_id");

		String sql="";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		String code="";
		String desc="";
		String comp=" ";

		con = ConnectionManager.getConnection(request);
		
			
try
	{	
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		sql = "Select a.assess_catg_code, b.long_desc from cp_assess_note_assess_catg a, cp_assess_catg_lang_vw b where a.assess_note_id = ? and a.assess_catg_code = b.assess_catg_code and b.language_id = ? order by b.long_desc";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,assess_note_id);
		pstmt.setString(2,locale);
		comp="parent.frames[1].frames[0].document.forms[0].assess_catg_code";
		rset = pstmt.executeQuery();
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'><form name='name1' id='name1'>");

		while( rset.next() ) 
		{
			desc=rset.getString(1);
			code=rset.getString(2);
			%>
	<script>
			var temp = "<%=code%>";
			var temp1="<%=desc%>";
			var opt=document.createElement("OPTION");
			opt.text=temp;
			opt.value=temp1;
			var comp=<%=comp%>;
			comp.add(opt)
	</script>
<%	
		}
			
		
	}
	catch(Exception e){
	//	out.print(e);out.print("<br>sql:"+sql);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
	finally {
		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request);

	}
%>

