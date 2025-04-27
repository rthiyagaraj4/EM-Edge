<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,eBL.BLMedRepOutStdAmtBean,oracle.jdbc.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>

 <%
 	String sysDateTime="";
	Connection con				= null;
    PreparedStatement pstmt		= null;
    ResultSet rs				= null;	
    con	=	ConnectionManager.getConnection(request);
try
		{

    
	String query_date="select to_char(sysdate,'dd/mm/yyyy'), to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') curr_time from dual";

// 			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
			pstmt = con.prepareStatement(query_date);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				if( rs.next() )
					sysDateTime = rs.getString("curr_time"); 
				System.out.println("sysDateTime  :"+sysDateTime);
			}
		if (rs != null)   rs.close();
		if (pstmt != null)   pstmt.close();
		}		
		catch(Exception e)
		{
			System.out.println("Exception @ sysdate  :"+e);
			e.printStackTrace();
		}
		finally
		{	

			ConnectionManager.returnConnection(con);
		}	 
 out.println(sysDateTime);
		%>
