<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
	String sql = "";
	Connection con = null;
	
	String encSummSql="";
	CallableStatement cstmt = null;
	
	String patientId = "", encounterId = "", summDesc = "";
	int summCount = 0;	
	int recordCount = 0;	

	patientId = request.getParameter("patientId");
	encounterId = request.getParameter("encounterId");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

	try
	{
		con	= ConnectionManager.getConnection(request);			
	 
		cstmt=con.prepareCall("{call EC_GET_SUMMARY_CODES(?,?,?,?,?)}");
		cstmt.setString(1,patientId);
		cstmt.setString(2,encounterId);				
		cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
		
		cstmt.execute();				
		
		summCount = cstmt.getInt(3);		
		summDesc = cstmt.getString(4);	
		recordCount = cstmt.getInt(5);

		System.out.println(" ::: summCount ::: "+summCount+" ::: summDesc ::: "+summDesc+" ::: recordCount ::: "+recordCount);
		
		/**********************************/
		%>
			summCount = "<%=summCount%>";
			summDesc = "<%=summDesc%>";
			recordCount = "<%=recordCount%>";
		<%
	}
	catch(Exception e){
		//out.println("Exception"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
	
%>
