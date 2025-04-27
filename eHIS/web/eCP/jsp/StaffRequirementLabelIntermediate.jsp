<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*"%>


<%
//This file is saved on 18/10/2005.	
	String shift_code1 = request.getParameter("shift_code1");
	
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	PreparedStatement pstmt = null;//common-icn-0180
	String start_time=null;
	String end_time=null;
	con = ConnectionManager.getConnection(request);
	try
	{
	//String sql="select to_char(shift_start_time,'hh24:mi') start_time,to_char(shift_end_time,'hh24:mi') end_time from am_shift where shift_code='"+shift_code1+"'";//common-icn-0180
	String sql="select to_char(shift_start_time,'hh24:mi') start_time,to_char(shift_end_time,'hh24:mi') end_time from am_shift where shift_code=?";//common-icn-0180
	
	//stmt= con.createStatement();//common-icn-0180
	pstmt=con.prepareStatement(sql);//common-icn-0180
	pstmt.setString(1, shift_code1);//common-icn-0180
	 //rs=stmt.executeQuery(sql);//common-icn-0180
	 rs=pstmt.executeQuery();//common-icn-0180
			while(rs.next())
		{     
						
					start_time = rs.getString("start_time")==null ? "": rs.getString("start_time");	
					end_time = rs.getString("end_time")==null ? "": rs.getString("end_time");	
					
		
			out.println( "assignDateRange(\"" + start_time + "\",\"" + end_time + "\") ; " ) ;
			//out.println( "assignDateRange(\"" + record1[0] + "\",\"" + record1[1] + "\",\"" + record1[2] + "\",\"" + record1[3] + "\",\"" + record1[4] +  "\");") ;	
		}	
		
		}catch(Exception e) { out.println("Main : "+e.toString());}
			finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (pstmt != null) pstmt.close();//common-icn-0180
		ConnectionManager.returnConnection(con,request); 
	}

%>
	
