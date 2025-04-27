<!DOCTYPE html>
<%--
	FileName	: ServerFunction.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>



<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,webbeans.eCommon.*"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");	
	String pr_id = request.getParameter("process_d");

	int process = Integer.parseInt(pr_id);
	Connection con		= null;
	Statement stmt		=	null;
	Statement stmt1		=	null;
	ResultSet rs			=	null;
	ResultSet rset		=	null;
	StringBuffer sbQuery = new StringBuffer();

	try
	{
		con = ConnectionManager.getConnection(request);
			
			if ( process == 1 )
			{
					stmt = con.createStatement();
					int DAYS,MONTHS,AGE;
					
					String DOB=request.getParameter("date_of_birth");
                    out.println(DOB);
					sbQuery.append(	"select calculate_age('"+DOB+"',1) from dual");
					
					rs = stmt.executeQuery(sbQuery.toString());
					rs.next();
					AGE = rs.getInt(1);
                    if(rs!=null) rs.close();
					if(stmt!=null) 	stmt.close();
					sbQuery.append(	"select calculate_age('"+DOB+"',2) from dual");
					
					stmt = con.createStatement();
					rs = stmt.executeQuery(sbQuery.toString());
					rs.next();
					MONTHS = rs.getInt(1);

                    if(stmt!=null) 	stmt.close();
					sbQuery.append(	"select calculate_age('"+DOB+"',3) from dual");
					
					stmt = con.createStatement();
					if(rs!=null) 	rs.close();
					rs = stmt.executeQuery(sbQuery.toString());
					rs.next();
					DAYS = rs.getInt(1);

					if(stmt!=null) 	stmt.close();

					String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>parent.f_query_add_mod.practitioner_sub.document.getElementById('b_age').value='"+AGE+"';parent.f_query_add_mod.practitioner_sub.document.getElementById('b_months').value='"+ MONTHS +"';parent.f_query_add_mod.practitioner_sub.document.getElementById('b_days').value='"+DAYS+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>";
					out.println(htmlVal);
			}
			if ( process == 2 )
				{

					stmt1 = con.createStatement();

					String DAYS,MONTHS,AGE;
					
					DAYS = request.getParameter("b_days");
					MONTHS = request.getParameter("b_months");
					AGE = request.getParameter("b_age");

					if ( DAYS.equals("") )
						DAYS = "null";
					if ( MONTHS.equals("") )
						MONTHS = "null";
					if ( AGE.equals("") )
						AGE = "null";

					String DOB;
				
					String sql1 = "select calculate_date_of_birth ("+AGE+","+MONTHS+","+DAYS+") from dual";
					rset = stmt1.executeQuery(sql1);
					rset.next();
					DOB = rset.getString(1);

					if ( DOB == "" || DOB == null )
						DOB = "";

					String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'> parent.f_query_add_mod.practitioner_sub.document.getElementById('date_of_birth').value='"+DOB+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value='"+DOB+"'</body></html>";
					out.println(htmlVal);
			} 
		if (rs != null)   rs.close();
		if (rset != null)   rset.close();
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();
	}
	catch(Exception e) 
	{
		out.println(e.toString());
	}
	finally
	{
	  ConnectionManager.returnConnection(con,request);

	}


%>

