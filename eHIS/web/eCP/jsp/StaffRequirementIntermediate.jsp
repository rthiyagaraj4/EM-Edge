<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String workplace_code = request.getParameter("workplace_code");
//String shift_code1=request.getParameter("shift_code1");

		String sql="";
		Connection con = null;
		Statement stmt = null;
		ResultSet rset=null;
		String code1="";
		String desc="";
		String comp=" ";

		con = ConnectionManager.getConnection(request);
		String facility_id=(String)session.getValue("facility_id");
		stmt = con.createStatement();
			
try
	{	

		
			sql = "select shift_code,long_desc from am_shift where shift_code in (select shift_code from rs_shift_for_workplace 						where facility_id='"+facility_id+"' and workplace_code='"+workplace_code+"') and eff_status='E'";
		
		
						comp="parent.frames[1].frames[0].document.forms[0].shift_code";

				
		rset = stmt.executeQuery(sql);
				
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><body CLASS='MESSAGE'><form name='name1' id='name1'>");

		while( rset.next() ) 
		{
			desc=rset.getString(1);
			code1=rset.getString(2);
			System.err.println("desc====cp===="+desc);
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
	catch(Exception e){
		//out.print(e);out.print("<br>sql:"+sql);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
	finally {
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		//conn.close();
		ConnectionManager.returnConnection(con,request);

	}
	%>






