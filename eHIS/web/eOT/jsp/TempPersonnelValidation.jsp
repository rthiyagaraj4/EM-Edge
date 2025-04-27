<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*"  %>



<% 
		String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
		String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
		
		String SQL ="SELECT ROLE_TYPE FROM OT_POST_OPER_PERSONNEL WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		StringBuffer sbr = new StringBuffer();
		try{
			con = ConnectionManager.getConnection(request);
			//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			rst = pstmt.executeQuery();
			while(rst.next()){
				 sbr.append(rst.getString(1)).append(",");
			}
			if(sbr.length()>0){
				out.println(sbr.toString());
			}else
				out.println("NO_REC");

		}catch(Exception e){
			System.err.println("Err Msg in TempPersonnelValidation.jsp"+e.getMessage());
		} finally{
			try{
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request);
				sbr.setLength(0);
			}catch(Exception e){}
		}

%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">



