<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


%>

<%
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;

		String code1="";
		String desc="";
		String comp="";
		String sql="";
		
	try
	{	
		con = ConnectionManager.getConnection(request);
		
		//sql = "Select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";
		sql = "Select pract_type, desc_userdef from am_pract_type_lang_vw where language_id = ? and eff_status = 'E' order by desc_userdef";
		comp="parent.document.frames[1].document.forms[0].p_pract_type";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,locale);
		rset = pstmt.executeQuery();
				
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'><form name='name1' id='name1'>");

		while( rset.next() ) 
		{
			desc=rset.getString(1);
			code1=rset.getString(2);
			%>
	<script>
			var temp = "<%=code1%>";
			var temp1="<%=desc%>";
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=temp;
			opt.value=temp1;
			var comp=<%=comp%>;
			comp.add(opt)
	</script>
<%	
		}	
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
	}
	catch(Exception e){out.print(e);out.print("<br>sql:"+sql);}
	finally {
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		ConnectionManager.returnConnection(con,request);
	}	
%>

