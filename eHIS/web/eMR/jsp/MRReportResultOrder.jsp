<!DOCTYPE html>
 
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%!
	
	public String updateFieldOrder(Connection con,String facility_id,String loginUser,String fieldOrder) throws java.sql.SQLException 
	{   
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String [] fields = fieldOrder.split("~");

		

		int len = fields.length;
		int recCnt = 0;
		try {

			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from MR_REPORT_RESULT_ORDER where Facility_id='"+facility_id+"' and User_id='"+loginUser+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
		
		if (recCnt == 0)
		{
			pstmt = con.prepareStatement("INSERT INTO MR_REPORT_RESULT_ORDER ( FACILITY_ID, FIELD_NAME, FIELD_DESC, FIELD_ORDER, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,USER_ID,APPL_YN) 	VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)");
			for (int i=0; i<len; ++i )
			{ 
				String []fieldStr = fields[i].split("`");
				
				String temp = fieldStr[1].trim(); 
				String temp_chk=String.valueOf(temp.charAt(0));
				
				String temp1="";
				
				temp=temp.replace('<','%');
				temp=temp.replace('>','$');
				temp1 = temp.replace(temp.substring(0,temp.indexOf("$")+1),"");
				
				
				
				if(temp.contains("CHECKED"))temp_chk="Y";
				else temp_chk="N";
				
				System.out.println("IF temp=====>"+temp);
				System.out.println("IF temp1=====>"+temp1);
				System.out.println("IF temp_chk=====>"+temp_chk);
				
				pstmt.setString(1,facility_id);
				pstmt.setString(2,fieldStr[0].toUpperCase());
				pstmt.setString(3,temp1);
				pstmt.setInt(4,i+1);
				pstmt.setString(5,loginUser);
				pstmt.setString(6,loginUser);
				pstmt.setString(7,facility_id);
				pstmt.setString(8,loginUser);
				pstmt.setString(9,loginUser);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,loginUser);
				pstmt.setString(12,temp_chk);
				pstmt.addBatch();
			}
		}
		else
		{  
			pstmt = con.prepareStatement("UPDATE MR_REPORT_RESULT_ORDER SET field_order = ?,  modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ?,MODIFIED_FACILITY_ID = ?,APPL_YN = ? where Field_name=? and Facility_id=? and User_id=?");
			for (int i=0; i<len; ++i )
			{ 
				String []fieldStr = fields[i].split("`");
				
				String temp = fieldStr[1].trim();
				String temp1="";
				temp=temp.replace('<','%');
				temp=temp.replace('>','$');
				temp1 = temp.substring(0,temp.indexOf("$")+1);
				
				
				
				String temp_chk=String.valueOf(temp1.charAt(temp1.indexOf("value=")+6));
				
				System.out.println("temp=====>"+temp);
				System.out.println("temp1=====>"+temp1);
				System.out.println("temp_chk=====>"+temp_chk);
				
				if(temp.contains("CHECKED"))temp_chk="Y";
				else temp_chk="N";
				
				
				pstmt.setInt(1,i+1);
				pstmt.setString(2,loginUser);
				pstmt.setString(3,loginUser);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,temp_chk);
				pstmt.setString(6,fieldStr[0].toUpperCase());
				pstmt.setString(7,facility_id);
				pstmt.setString(8,loginUser);
				pstmt.addBatch();
			}
		}
			
			int[] batch_result = pstmt.executeBatch();
			
			for (int i=0; i<batch_result.length; ++i )
			con.commit();
		 }
		 catch(Exception e)
		 {
			 
			 e.printStackTrace();
			 con.rollback();
		 }
		 finally
		 {	
			if(pstmt!=null)	pstmt.close();
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
		 }
		//The fields are added to the list in the order of their display
		return fields[0];
	}
%>
<%
	Connection con		= null ;
	try
	{
		String fieldOrder	=	(request.getParameter("fieldOrder")==null)	? "" : request.getParameter("fieldOrder");
		//String val1	=	(request.getParameter("chk1_1")==null)	? "" : request.getParameter("chk1_1");
		
		String facility_id  =	(String)session.getValue("facility_id");
		String loginUser = ((String)session.getValue("login_user")==null)?"":(String)session.getValue("login_user");
		con		=	(Connection)ConnectionManager.getConnection(request);
		System.err.println("fieldOrder==>"+fieldOrder);
		out.print(updateFieldOrder(con,facility_id,loginUser,fieldOrder));
			

	}
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>
