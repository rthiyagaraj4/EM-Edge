
<%@page import="java.io.*"%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,eBL.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.util.*"%>

<%


System.out.println("Im here in persistence");


		
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String functionMode="";
	String saleCategoryCode  = "";
	String itemCode ="";
	String sql = null ; 
	
	functionMode = request.getParameter("func_mode");

	try{
	if(functionMode != null){
		if(functionMode.equals("getSaleCategory")){
		    con = ConnectionManager.getConnection();
		    itemCode = request.getParameter("itemCode");
			System.out.println("the item code is "+itemCode);
			sql  = " select SALE_CATEGORY_CODE from bl_st_item where ITEM_CODE = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemCode);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				saleCategoryCode = (rs.getString("SALE_CATEGORY_CODE") != null) ? rs.getString("SALE_CATEGORY_CODE").trim() : "";
				
                out.print(saleCategoryCode); 
			}

		}
	}
	
	
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception from Getting sale Category code Ajax  :" + e);
	} finally {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
%>