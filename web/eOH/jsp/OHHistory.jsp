<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager,java.sql.Clob,java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String facility_id      = (String) session.getAttribute("facility_id");
	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;

	try{
		con = ConnectionManager.getConnection();

		String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
		String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
		String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
		//chart_line_num = "1";
		String result_text = "";
		BufferedReader bf_content_reader = null;
		Clob clob_result_text = null;
		StringBuffer content  = new StringBuffer();
		
		if(pstmt != null) pstmt.close();
		if(rst != null) rst.close();
		
		pstmt = con.prepareStatement("SELECT RESULT_TEXT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND NVL(COND_CLOSED_YN,'N') = 'N'");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,chart_num);
		pstmt.setString(4,chart_line_num);
		
		rst = pstmt.executeQuery();
		while(rst.next()){
			clob_result_text = rst.getClob("RESULT_TEXT");
			if(clob_result_text!=null){
				bf_content_reader = new java.io.BufferedReader(clob_result_text.getCharacterStream());
				char[] arr_result_text = new char[(int)clob_result_text.length()];
				bf_content_reader.read(arr_result_text,0,(int)clob_result_text.length());
				result_text = new String(arr_result_text);
				content.append(result_text);
				bf_content_reader.close();
				out.println(content.toString());
			}
		}

	}catch(Exception e){
			con.rollback();
			System.err.println("Err Msg from OHHistory.jsp "+e);
			System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
