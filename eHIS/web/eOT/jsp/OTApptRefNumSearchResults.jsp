<!DOCTYPE html>
<%@page  import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>


<% request.setCharacterEncoding("UTF-8"); %>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		conn = ConnectionManager.getConnection(request);
		String sql = request.getParameter("sql");
		String theatre_date_from = request.getParameter("theatre_date_from");
		String patient_id = request.getParameter("patient_id");
		String theatre_date_to=request.getParameter("theatre_date_to"); 
		String func_id=request.getParameter("func_id"); 
	//Chk_In ......Chk_InTo_OR
		String count = "";
		String appt_ref_num="";
		String sql_count="";
		if(func_id.equals("Chk_In")){
			sql_count="SELECT COUNT(*) FROM OT_SCHD_OPERS_VW WHERE PATIENT_ID=? AND APPT_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND OPER_STATUS IN('10','15','20','25','30','35')";
		}else{
			sql_count="SELECT COUNT(*) FROM OT_SCHD_OPERS_VW WHERE PATIENT_ID=? AND APPT_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND OPER_STATUS IN('40','45')";
		}
			pstmt = conn.prepareStatement(sql_count);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,theatre_date_from);
			pstmt.setString(3,theatre_date_to);
    		rs = pstmt.executeQuery();
			while(rs.next()){
				count=rs.getString(1);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(count.equals("1")){
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,theatre_date_from);
				pstmt.setString(3,theatre_date_to);
				rs = pstmt.executeQuery();
				while(rs.next()){
					appt_ref_num=checkForNull(rs.getString("APPT_REF_NUM"));
				}
		  }
			out.println(appt_ref_num);	
		
	}catch (Exception e) {
		System.err.println("Execpetion in OTApptRefNumSearchResults.jsp: "+e);
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}finally{
		rs.close();
		pstmt.close();
        ConnectionManager.returnConnection(conn,request);
	}
%>
