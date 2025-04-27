<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>


<% 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;

		String locale = (String)session.getAttribute("LOCALE"); 
		String facility_id      = (String) session.getAttribute("facility_id");
		String func_mode =	request.getParameter("func_mode") ;
		String oper_num =	request.getParameter("oper_num") ;
		request.setCharacterEncoding("UTF-8");
		try{
			con = ConnectionManager.getConnection(request);
			
			if(func_mode.equalsIgnoreCase("getPractRoleType")){
			String sql			= "";		
			String role_type_id	= "";
			String pract_id	= "";
			String compareString= "";
			sql="SELECT B.ROLE_TYPE, A.PRACTITIONER_ID FROM OT_POST_OPER_PERSONNEL A, OT_ROLES_LANG_VW B, AM_SPECIALITY C,AM_PRACTITIONER D, AM_POSITION E WHERE B.LANGUAGE_ID = ? AND OPERATING_FACILITY_ID =? AND OPER_NUM	= ? AND A.SPECIALITY_CODE = C.SPECIALITY_CODE (+) AND A.ROLE_ID = B.ROLE_ID AND A.PRACTITIONER_ID = D.PRACTITIONER_ID AND  D.POSITION_CODE    = E.POSITION_CODE(+)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,oper_num);
			rst = pstmt.executeQuery();
			while(rst.next()){
				role_type_id=rst.getString(1);
				pract_id=rst.getString(2);
				compareString=compareString+"@@"+role_type_id+"||"+pract_id;
			
			}
			out.println(compareString);
		}
		
		}catch(Exception e){
			System.err.println("Err Msg in TempSugeonValidation.jsp"+e.getMessage());
		} finally{
			try{
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		}

%>



