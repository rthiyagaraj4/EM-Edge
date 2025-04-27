<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%
			request.setCharacterEncoding("UTF-8");
			Connection con				  =null;
			PreparedStatement pstmt = null;
			ResultSet rs					  = null;
			String PAT_SQL			  = ""; 
			int	 record_count			  = 0; 
			String patient_id			  = "";
			String facility_id			  = (String) session.getValue("facility_id");	

		try{
				con				  = ConnectionManager.getConnection(request);
				patient_id		  = request.getParameter("patient_id");
				PAT_SQL = "SELECT count(*) record_count FROM mr_pat_file_index WHERE facility_id ='"+facility_id+"' AND patient_id = '"+patient_id+"' and doc_folder_id is null ";
				pstmt=con.prepareStatement(PAT_SQL);
				rs = pstmt.executeQuery();
				while(rs.next()){
						record_count = rs.getInt("record_count");
				}
				out.print(record_count);
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
		}catch(Exception ex){
				ex.printStackTrace();
		}finally{
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if(con!=null){
					ConnectionManager.returnConnection(con,request);
				}

		}

%>
