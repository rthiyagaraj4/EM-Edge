<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<%
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;

		String code1="";
		String desc="";
		String sql="";
		String role_type=request.getParameter("role_type");
		String comp=" ";
		

	try{	
		con = ConnectionManager.getConnection(request);
	
		if(role_type.equals("P"))	{
				//sql = "	Select pract_type staff_type, desc_userdef staff_type_desc from am_pract_type where eff_status = 'E' order by 2 ";
				sql = "	Select pract_type staff_type, desc_userdef staff_type_desc from am_pract_type_lang_vw where language_id = ? and eff_status = 'E' order by 2 ";
		}
		else{
				//sql="Select other_staff_type staff_type, short_desc staff_type_desc from am_other_staff_type where eff_status = 'E' order by 2";
				sql="Select other_staff_type staff_type, short_desc staff_type_desc from am_other_staff_type_lang_vw where language_id = ? and eff_status = 'E' order by 2";
		}
		comp="parent.document.frames[1].document.forms[0].staff_type";
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1,locale);		
		rset = pstmt.executeQuery();

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'><form name='name1' id='name1'>");

		while( rset.next() ) {
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
		if(pstmt != null)
			pstmt.close();
		if(rset != null)
			rset.close();
	}
	catch(Exception e){out.print(e);out.print("<br>sql:"+sql);}
	finally {
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		ConnectionManager.returnConnection(con,request);
	}	
%>

