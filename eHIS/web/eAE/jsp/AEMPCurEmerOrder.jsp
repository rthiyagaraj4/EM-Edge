<!DOCTYPE html>
 
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%!
	/* To fetch display order of fields in Result page
       :: Vinod Babu M V - 11/10/2009
	 */
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
			rs = stmt.executeQuery("select count(*) from AE_CURR_EMERG_PAT_RESULT where Facility_id='"+facility_id+"' and User_id='"+loginUser+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
		//System.out.println("recCnt : "+recCnt);
		if (recCnt == 0)
		{
			pstmt = con.prepareStatement("INSERT INTO AE_CURR_EMERG_PAT_RESULT ( FACILITY_ID, FIELD_NAME, FIELD_DESC, FIELD_ORDER, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,USER_ID) 	VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
			for (int i=0; i<len; ++i )
			{ 
				String []fieldStr = fields[i].split("`");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,fieldStr[0].toUpperCase());
				pstmt.setString(3,fieldStr[1].trim());
				pstmt.setInt(4,i+1);
				pstmt.setString(5,loginUser);
				pstmt.setString(6,loginUser);
				pstmt.setString(7,facility_id);
				pstmt.setString(8,loginUser);
				pstmt.setString(9,loginUser);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,loginUser);
				pstmt.addBatch();
			}
		}
		else
		{
			pstmt = con.prepareStatement("UPDATE AE_CURR_EMERG_PAT_RESULT SET field_order = ?,  modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ?,MODIFIED_FACILITY_ID = ? where Field_name=? and Facility_id=? and User_id=?");
			for (int i=0; i<len; ++i )
			{ 
				String []fieldStr = fields[i].split("`");
				pstmt.setInt(1,i+1);
				pstmt.setString(2,loginUser);
				pstmt.setString(3,loginUser);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,fieldStr[0].toUpperCase());
				pstmt.setString(6,facility_id);
				pstmt.setString(7,loginUser);
				pstmt.addBatch();
			}
		}
			int[] batch_result = pstmt.executeBatch();
			for (int i=0; i<batch_result.length; ++i )
			con.commit();
		 }
		 catch(Exception e)
		 {
			 System.out.println("Exception : "+e);
			 e.printStackTrace();
			 con.rollback();
		 }
		 finally
		 {	
			if(pstmt!=null)	pstmt.close();
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs = null;
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
//System.out.println("fieldOrder : "+fieldOrder);
		String facility_id  =	(String)session.getValue("facility_id");
		String loginUser = ((String)session.getValue("login_user")==null)?"":(String)session.getValue("login_user");
		con		=	(Connection)ConnectionManager.getConnection(request);
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
