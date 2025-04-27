<!DOCTYPE html>
<%@ page  import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%
 String locale = (String)session.getAttribute("LOCALE"); 
	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//String locale		   =  (String)session.getAttribute("LOCALE"); 
	String func_mode	   =  request.getParameter( "func_mode" ) ;
	String chart_code   =  request.getParameter( "chart_code" ) ;
	String patient_id     =  request.getParameter( "patient_id" ) ;
	String across_chart_yn  =  request.getParameter( "across_chart_yn" ) ;
	String eval_type  =  request.getParameter( "eval_type" ) ;
	StringBuilder sbr	   =  new StringBuilder();
	String chart_num = request.getParameter( "chart_num" ) ;
	String populate_list = request.getParameter( "populate_list" ) ;
	String chart_num_yn = "" ;
	String SQL="";
	con = ConnectionManager.getConnection();

	if("EvaluationList".equals(func_mode)){
		
		//SQL = "SELECT A.CHART_CODE,'#'||B.CHART_LINE_NUM||'-'||B.ADDED_BY_ID||'-'||TO_CHAR(B.ADDED_DATE,'DD/MM/YYYY'),B.CHART_NUM,B.CHART_LINE_NUM,TO_CHAR(B.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR A, OH_PERIODONTAL_CHART_HDR_LINE B, OH_PERIODONTAL_CHART_DEF_HDR C WHERE  A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_CODE=? AND B.CHART_NUM=? AND B.CHART_LINE_NUM >1 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID  AND  A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.CHART_CODE = C.CHART_CODE ORDER BY 2";
		//BASELINE VS EVALUATION - ACROSS CHART = 'N' 
		//EVALUATION VS EVALUATION - SECOND QUERY - ACROSS CHART = 'N'

        // Following are the conditions in which chart num will not be considered
		//1.When the option is Baseline vs Evaluation and Across Charts is "N"
		//2.When the option is Evaluation vs Evaluation and it is first list item
		//3.When the option is Evaluation vs Evaluation and it is second list item and Across charts = "Y"



		if(("BE".equals(eval_type) && "N".equals(across_chart_yn)) || ("EE".equals(eval_type) && "2".equals(populate_list) && "Y".equals(across_chart_yn))|| ("EE".equals(eval_type) && "1".equals(populate_list))){
			chart_num_yn="Y";
		}else{
			chart_num_yn="N";
		}

		//SQL = "SELECT 								A.CHART_CODE,'#'||A.CHART_NUM||'-'||A.CHART_LINE_NUM||'-'||A.CHART_COMPLETED_BY||'-'||CHART_COMPLETED_DATE,       A.CHART_NUM,A.CHART_LINE_NUM,TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID  = ? AND A.CHART_CODE	= ? AND ('Y' = ? OR A.CHART_NUM = ?) AND A.CHART_TYPE	 = 'EC' AND A.CHART_LINE_STATUS	= 'CM'  ORDER BY A.CHART_LINE_NUM";
		SQL = "SELECT A.CHART_CODE,'-'||A.OPERATING_FACILITY_ID||'-'||A.CHART_NUM||'-'||A.CHART_LINE_NUM||'-'||SM_CONVERT_DATE(CHART_COMPLETED_DATE,?),       A.CHART_NUM,A.CHART_LINE_NUM,TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE  A.PATIENT_ID  = ? AND A.CHART_CODE	= ? AND ('Y' = ? OR A.CHART_NUM = ?) AND A.CHART_TYPE	 = 'EC' AND A.CHART_LINE_STATUS	= 'CM'  ORDER BY A.CHART_LINE_NUM";


		try{
			//con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			pstmt.setString(4,chart_num_yn);
			pstmt.setString(5,chart_num);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				sbr.append(rst.getString(1)).append("@@");//CHART_CODE
				sbr.append(rst.getString(3)).append("@@");//CHART_NUM
				sbr.append(rst.getString(4)).append("##");//CHART_LINE_NUM
				sbr.append(rst.getString(2)).append("~");//CHART_DESC
				//sbr.append(rst.getString(5))..append("##");//CHART_COMPLETED_DATE
			}
			out.println(sbr.toString());
	}catch(Exception e){
		System.err.println("Err Msg from PerioCompareChartValidation.jsp "+e);
	}finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			sbr.setLength(0);
		}
	}else if("BaseLineList".equals(func_mode)){
//		 SQL = "SELECT A.CHART_CODE,'#'||B.CHART_LINE_NUM||'-'||B.ADDED_BY_ID||'-'||TO_CHAR(B.ADDED_DATE,'DD/MM/YYYY'),B.CHART_NUM,B.CHART_LINE_NUM,TO_CHAR(B.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR A, OH_PERIODONTAL_CHART_HDR_LINE B, OH_PERIODONTAL_CHART_DEF_HDR C WHERE  A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_CODE=? AND B.CHART_LINE_NUM "+cond+" AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID  AND  A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.CHART_CODE = C.CHART_CODE ORDER BY 2";
		 //SQL = "SELECT A.CHART_CODE,'#'||A.CHART_NUM||'-'||A.CHART_LINE_NUM||'-'||A.CHART_COMPLETED_BY||'-'||CHART_COMPLETED_DATE,       A.CHART_NUM,A.CHART_LINE_NUM,TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID  = ? AND A.CHART_CODE	= ? AND A.CHART_TYPE	 = 'BC' AND A.CHART_LINE_STATUS	= 'CM' ORDER BY 2";
		// SQL = "SELECT A.CHART_CODE,'#'||A.CHART_NUM||'-'||A.CHART_LINE_NUM||'-'||SM_CONVERT_DATE(CHART_COMPLETED_DATE,?),       A.CHART_NUM,A.CHART_LINE_NUM,TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID  = ? AND A.CHART_CODE	= ? AND A.CHART_TYPE	 = 'BC' AND A.CHART_LINE_STATUS	= 'CM' ORDER BY 2";
		SQL = "SELECT A.CHART_CODE,'-'||A.OPERATING_FACILITY_ID||'-'||A.CHART_NUM||'-'||A.CHART_LINE_NUM||'-'||SM_CONVERT_DATE(CHART_COMPLETED_DATE,?),       A.CHART_NUM,A.CHART_LINE_NUM,TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR_LINE A WHERE A.PATIENT_ID  = ? AND A.CHART_CODE	= ? AND A.CHART_TYPE	 = 'BC' AND A.CHART_LINE_STATUS	= 'CM' ORDER BY 2";
		 try{
		//	con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				sbr.append(rst.getString(1)).append("@@");//CHART_CODE
				sbr.append(rst.getString(3)).append("@@");//CHART_NUM
				sbr.append(rst.getString(4)).append("##");//CHART_LINE_NUM
				sbr.append(rst.getString(2)).append("~");//CHART_DESC
			}
			out.println(sbr.toString());

		}catch(Exception e){
			System.err.println("Err Msg from PerioCompareChartValidation.jsp "+e);
		}finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			sbr.setLength(0);
		}
	}else if("BothBaseLineList".equals(func_mode)){
		SQL = "SELECT A.CHART_CODE,'-'||A.OPERATING_FACILITY_ID||'-'||A.CHART_NUM||'-'||A.CHART_LINE_NUM||'-'||SM_CONVERT_DATE(CHART_COMPLETED_DATE,?), A.CHART_NUM,A.CHART_LINE_NUM,TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR_LINE A,OH_PERIODONTAL_CHART_HDR B  WHERE A.PATIENT_ID  = ? AND A.CHART_CODE	= ? AND A.CHART_TYPE	 = 'BC' AND A.CHART_NUM=B.CHART_NUM AND A.PATIENT_ID  = B.PATIENT_ID AND A.CHART_CODE	= B.CHART_CODE AND (A.CHART_LINE_STATUs= 'CM' OR B.CHART_STATUS= 'CD') ORDER BY 2";
		try{
		//	con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				sbr.append(rst.getString(1)).append("@@");//CHART_CODE
				sbr.append(rst.getString(3)).append("@@");//CHART_NUM
				sbr.append(rst.getString(4)).append("##");//CHART_LINE_NUM
				sbr.append(rst.getString(2)).append("~");//CHART_DESC
			}
			out.println(sbr.toString());

		}catch(Exception e){
			System.err.println("Err Msg from PerioCompareChartValidation.jsp "+e);
		}finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			sbr.setLength(0);
		}
	}else if("BothBaseLineListTemp".equals(func_mode)){
		SQL = "SELECT A.CHART_CODE,'-'||A.OPERATING_FACILITY_ID||'-'||A.CHART_NUM||'-'||A.CHART_LINE_NUM||'-'||SM_CONVERT_DATE(CHART_COMPLETED_DATE,?), A.CHART_NUM,A.CHART_LINE_NUM,TO_CHAR(A.CHART_COMPLETED_DATE,'DD/MM') FROM OH_PERIODONTAL_CHART_HDR_LINE A,OH_PERIODONTAL_CHART_HDR B  WHERE A.PATIENT_ID  = ? AND A.CHART_CODE	= ? AND A.CHART_TYPE	 = 'BC' AND A.CHART_NUM=B.CHART_NUM AND A.PATIENT_ID  = B.PATIENT_ID AND A.CHART_CODE	= B.CHART_CODE AND (A.CHART_LINE_STATUs= 'CM' OR B.CHART_STATUS= 'CD') ORDER BY 2";
		try{
		//	con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				sbr.append(rst.getString(1)).append("@@");//CHART_CODE
				sbr.append(rst.getString(3)).append("@@");//CHART_NUM
				sbr.append(rst.getString(4)).append("##");//CHART_LINE_NUM
				sbr.append(rst.getString(2)).append("~");//CHART_DESC
			}
			out.println(sbr.toString());

		}catch(Exception e){
			System.err.println("Err Msg from PerioCompareChartValidation.jsp "+e);
		}finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			sbr.setLength(0);
		}
	}
	
	
	
%>

	
