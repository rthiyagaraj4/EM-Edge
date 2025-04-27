<%@page  contentType="text/html;charset=UTF-8"%>

<%@page   import= "java.sql.Connection,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String facility_id =(String) session.getAttribute("facility_id"); 
	String asstSurgeon1=checkForNull(request.getParameter("asstSurgeon1"));
	String asstSurgeon2=checkForNull(request.getParameter("asstSurgeon2"));
	String booking_no=checkForNull(request.getParameter("booking_no"));
	String surgeon_code=checkForNull(request.getParameter("surgeon_code"));
	
	//Added Against ML-MMOH-CRF-1791-US03...starts
	
	String auto_schdl_yn=checkForNull(request.getParameter("auto_schdl_yn"));
	String surgeon_code2=checkForNull(request.getParameter("surgeon_code2"));
	String tab_name=checkForNull(request.getParameter("tab_name"));
	String appt_ref_num=checkForNull(request.getParameter("appt_ref_num"));
	String oper_num=checkForNull(request.getParameter("oper_num"));
	
	String sql_2 = "UPDATE OT_POST_OPER_HDR SET ASST_SURGEON_CODE = ? ,ASST_SURGEON_CODE_2 = ?,SURGEON_CODE = ?, MODIFIED_DATE = sysdate  WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ?";
	
	String sql_3 = "UPDATE OT_QUEUE SET SURGEON_CODE=? , MODIFIED_DATE = sysdate WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ?";
	
	//Added Against ML-MMOH-CRF-1791-US03...ends
	
	String sql="UPDATE OT_BOOKING_HDR SET ASST_SURGEON_CODE = ? ,ASST_SURGEON_CODE_2 = ?,TEAM_DOCTOR_CODE=? WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM=?"; 
	
	String ot_queue_updt="UPDATE OT_QUEUE SET SURGEON_CODE = ?  WHERE OPERATING_FACILITY_ID=? AND APPT_REF_NUM=?"; 

	Connection con = null;
	PreparedStatement pstmt=null;
	con = ConnectionManager.getConnection(request);

	try{
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,asstSurgeon1);
		pstmt.setString(2,asstSurgeon2);
		pstmt.setString(3,surgeon_code);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,booking_no);
		int result=	pstmt.executeUpdate();
		/*if(result>0){
			con.commit();
			out.println("Updated Successfully");
		}else{
			con.rollback();
		}*/
		pstmt=con.prepareStatement(ot_queue_updt);
		pstmt.setString(1,surgeon_code);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,booking_no);
		int result1=	pstmt.executeUpdate();
		if(result>0 && result1>0){
			con.commit();
			out.println("Updated Successfully");
		}else{
			con.rollback();
		}
		//Added Against ML-MMOH-CRF-1791-US03...starts
		
		if((tab_name.equals("SLATE")) && appt_ref_num.equals("") && auto_schdl_yn.equals("Y") && surgeon_code2.equals("ALL_OT_SURG")){
	
		pstmt=con.prepareStatement(sql_2);
		pstmt.setString(1,asstSurgeon1);
		pstmt.setString(2,asstSurgeon2);
		pstmt.setString(3,surgeon_code);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,oper_num);
		int result3 =	pstmt.executeUpdate();
				
		pstmt=con.prepareStatement(sql_3);
		pstmt.setString(1,surgeon_code);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		int result4 =	pstmt.executeUpdate();
		
		if(result3 > 0 && result4 > 0){
			con.commit();
			out.println("Updated Successfully");
		}else{
			con.rollback();
		}
		}
		//Added Against ML-MMOH-CRF-1791-US03...ends
		
		pstmt.close();
		
}catch(Exception e){
		 //out.println("Err in RecordAsstSurgeon.jsp"+e.getMessage());
		 e.printStackTrace();
	}finally{
		
		if(pstmt!=null) pstmt.close();		
		if(con!=null) con.close();
	}

%>
