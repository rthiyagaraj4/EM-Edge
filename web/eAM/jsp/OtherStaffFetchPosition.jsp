<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
		request.setCharacterEncoding("UTF-8");
		String sql=" ";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		String code1="";
		String desc="";
		String otherstafftype=request.getParameter("otherstafftype");
		System.out.println("otherstafftype:"+otherstafftype);

		String comp=" ";
try
	{	con = ConnectionManager.getConnection(request);
	    System.out.println("con:"+con);
		
		sql = "select position_desc,position_code from am_position where role_type='O' and (staff_type is null or staff_type = ?) and eff_status ='E' order by position_desc";
			comp="parent.f_query_add_mod.OtherStaff_sub.document.OtherStaff1_form.Position";
			System.out.println("comp:"+comp);
			System.out.println("sql:"+sql);
			
		
				pstmt = con.prepareStatement(sql);
				System.out.println("pstmt:"+pstmt);
				pstmt.setString(1 , otherstafftype);
				rset = pstmt.executeQuery();
				System.out.println("rsetfinal:"+rset);
			
		//out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='name1' id='name1'>");

		while( rset.next() ) 
		{
			desc=rset.getString(1);
			code1=rset.getString(2);
			System.out.println("code1:"+code1);
			%>
	<script>
				
			var temp = "<%=code1%>";
			var temp1="<%=desc%>";
			var opt=parent.f_query_add_mod.OtherStaff_sub.document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=<%=comp%>;
			comp.add(opt)
			
	</script>
<%	
		}
			
		
	}
	catch(Exception e){out.print(e);out.print("<br>sql:"+sql);}
	finally {
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		ConnectionManager.returnConnection(con,request);

	}
	
	%>

