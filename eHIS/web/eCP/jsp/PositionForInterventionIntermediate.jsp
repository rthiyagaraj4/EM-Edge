<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%   
//This file is saved on 18/10/2005.
		String  role_type = request.getParameter("role_type");
		String sql="";
		String locale			= (String)session.getAttribute("LOCALE");
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset=null;

		String code1="";
		String desc="";
		String comp=" ";

		con = ConnectionManager.getConnection(request);
			
try
	{	
if(role_type.equals("P"))
   {
			//sql = "select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";
			sql = "SELECT pract_type, desc_userdef FROM am_pract_type_lang_vw WHERE eff_status = 'E' and language_id = '"+locale+"' ORDER BY desc_userdef";
			comp="parent.frames[1].frames[0].document.forms[0].staff_type";
    }
else
	{
	//sql="select other_staff_type, short_desc from am_other_staff_type where eff_status = 'E' order by short_desc";
	sql="SELECT other_staff_type, short_desc FROM am_other_staff_type_lang_Vw WHERE eff_status = 'E' and language_id = '"+locale+"' ORDER BY short_desc";
    comp="parent.frames[1].frames[0].document.forms[0].staff_type";
	}
		stmt = con.prepareStatement(sql);
		rset = stmt.executeQuery();
				
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><body CLASS='MESSAGE'><form name='name1' id='name1'>");

		while( rset.next() ) 
		{
			desc=rset.getString(1);
			code1=rset.getString(2);
	%>
	   <script>
			var temp = "<%=code1%>";
			var temp1="<%=desc%>";
			var opt=parent.frames[1].frames[0].document.createElement("OPTION");
			opt.text=temp;
			opt.value=temp1;
			var comp=<%=comp%>;
			comp.add(opt)
       </script>
<%	
		}
	}
	catch(Exception e){out.print(e);out.print("<br>sql:"+sql);}
	finally {
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
    	ConnectionManager.returnConnection(con,request);
	}
%>




