<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;

	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("populateTreatment")){	
				String complication_code    = checkForNull(request.getParameter( "complication_code" )) ;
				String trmt_category_type = "";
				StringBuffer trmt_category = new StringBuffer();

				pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE FROM OH_COMPLICATION_TRMT_CAT_TYPE    WHERE COMPLICATION_CODE = ?");
				pstmt.setString(1,complication_code);

				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
					trmt_category.append(trmt_category_type+"##");
									
			   }
			out.println(trmt_category);
			}
	 }catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from MTrmtCatTypeForComplicationsValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
