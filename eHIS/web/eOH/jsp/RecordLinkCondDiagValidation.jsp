<!DOCTYPE html>
<%@ page  import="java.sql.*,java.util.*,eOH.*,eOR.OrderEntryBillingQueryBean,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	Connection con = null;
	CallableStatement cstmt= null ;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_dtl = null;
	ResultSet rs = null;
	int flag=0;
	int dtl_flag=0;

	String client_ip_address="";
	String facility_id = "";	
	String login_user=""; 
		
	java.util.Properties prop = null;
	facility_id = (String)session.getValue( "facility_id" ) ;
	String practitioner_id = (String)session.getValue("ca_practitioner_id") ;

	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	client_ip_address = prop.getProperty( "client_ip_address" );
	login_user = prop.getProperty( "login_user" );

	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;

	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("insertLinkedConditions")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String trmt_chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String trmt_chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String term_set_id = checkForNull(request.getParameter( "term_set_id" )) ;
			String term_code = checkForNull(request.getParameter( "term_code" )) ;
			String occur_srl_no = checkForNull(request.getParameter( "occur_srl_no" )) ;
			String cond_closed_yn = checkForNull(request.getParameter( "cond_closed_yn" )) ;
			String cond_chart_num = checkForNull(request.getParameter( "cond_chart_num" )) ;
			String cond_chart_line_num = checkForNull(request.getParameter( "cond_chart_line_num" )) ;
			String cond_code = checkForNull(request.getParameter( "cond_code" )) ;

			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;

			trmt_chart_line_num=trmt_chart_line_num==null?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("null")?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("")?"1":trmt_chart_line_num;

			int diag_count = Integer.parseInt(tooth_range_count);
			int diag_chart_line_num_int = Integer.parseInt(trmt_chart_line_num);
			int diag_flag = 0;

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG_COND (OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, TRMT_CHART_NUM, TRMT_CHART_LINE_NUM, TRMT_CODE, COND_CHART_NUM, COND_CHART_LINE_NUM, CONDITION_CODE, COND_CLOSED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

			if(diag_count == 0){
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,term_set_id);
				pstmt.setString(4,term_code);
				pstmt.setString(5,occur_srl_no);
				pstmt.setString(6,trmt_chart_num);
				pstmt.setString(7,trmt_chart_line_num);
				pstmt.setString(8,trmt_code);
				pstmt.setString(9,cond_chart_num);
				pstmt.setString(10,cond_chart_line_num);
				pstmt.setString(11,cond_code);
				pstmt.setString(12,"N");
				pstmt.setString(13,login_user);
				pstmt.setString(14,client_ip_address);
				pstmt.setString(15,facility_id);
				pstmt.setString(16,login_user);
				pstmt.setString(17,client_ip_address);
				pstmt.setString(18,facility_id);
				diag_flag = pstmt.executeUpdate();
			}
			else{
				for(int j=1;j<=diag_count;j++){
					trmt_chart_line_num = diag_chart_line_num_int+"";
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,term_set_id);
					pstmt.setString(4,term_code);
					pstmt.setString(5,occur_srl_no);
					pstmt.setString(6,trmt_chart_num);
					pstmt.setString(7,trmt_chart_line_num);
					pstmt.setString(8,trmt_code);
					pstmt.setString(9,cond_chart_num);
					pstmt.setString(10,cond_chart_line_num);
					pstmt.setString(11,cond_code);
					pstmt.setString(12,"N");
					pstmt.setString(13,login_user);
					pstmt.setString(14,client_ip_address);
					pstmt.setString(15,facility_id);
					pstmt.setString(16,login_user);
					pstmt.setString(17,client_ip_address);
					pstmt.setString(18,facility_id);
					diag_flag = pstmt.executeUpdate();

					diag_chart_line_num_int++;
				}
			}
			
			
			if(diag_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			
			out.println(diag_flag);
		}
		
		else if(func_mode.equalsIgnoreCase("checkAndDeleteLinkedConditions")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String trmt_chart_num = checkForNull(request.getParameter( "trmt_chart_num" )) ;
			String trmt_chart_line_num = checkForNull(request.getParameter( "trmt_chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String term_set_id = checkForNull(request.getParameter( "term_set_id" )) ;
			String term_code = checkForNull(request.getParameter( "term_code" )) ;
			String cond_chart_num =checkForNull(request.getParameter( "cond_chart_num" ));
			String cond_chart_line_num = checkForNull(request.getParameter( "cond_chart_line_num" ));
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" ));
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" ));
			String record_count = "";

			trmt_chart_line_num=trmt_chart_line_num==null?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("null")?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("")?"1":trmt_chart_line_num;
		
			int cond_flag = 0;
			int delete_flag = 0;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		if (oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND COND_CHART_NUM = ? AND COND_CHART_LINE_NUM = ? ");
			
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,term_set_id);
			pstmt.setString(3,term_code);
			pstmt.setString(4,trmt_chart_num);
			pstmt.setString(5,trmt_chart_line_num);
			pstmt.setString(6,cond_chart_num);
			pstmt.setString(7,cond_chart_line_num);
			rs = pstmt.executeQuery();
		}else{
			pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND COND_CHART_NUM = ? AND COND_CHART_LINE_NUM = ? ");
			
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,term_set_id);
			pstmt.setString(4,term_code);
			pstmt.setString(5,trmt_chart_num);
			pstmt.setString(6,trmt_chart_line_num);
			pstmt.setString(7,cond_chart_num);
			pstmt.setString(8,cond_chart_line_num);
			rs = pstmt.executeQuery();
				
		}	
			
			while(rs.next()){
				record_count = checkForNull(rs.getString("RECORD_COUNT"));
			}

			if(!record_count.equals("0")){
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				if (oh_chart_level.equals("E")){
					pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE  PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND COND_CHART_NUM = ? AND COND_CHART_LINE_NUM = ? ");

				//	pstmt.setString(1,facility_id);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,term_set_id);
					pstmt.setString(3,term_code);
					pstmt.setString(4,trmt_chart_num);
					pstmt.setString(5,trmt_chart_line_num);
					pstmt.setString(6,cond_chart_num);
					pstmt.setString(7,cond_chart_line_num);

					delete_flag = pstmt.executeUpdate();
			}else{
					pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND COND_CHART_NUM = ? AND COND_CHART_LINE_NUM = ? ");
					//pstmt=con.prepareStatement("DELETE FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND COND_CHART_NUM = ? AND COND_CHART_LINE_NUM = ? ");

					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,term_set_id);
					pstmt.setString(4,term_code);
					pstmt.setString(5,trmt_chart_num);
					pstmt.setString(6,trmt_chart_line_num);
					pstmt.setString(7,cond_chart_num);
					pstmt.setString(8,cond_chart_line_num);

					delete_flag = pstmt.executeUpdate();
		
				}
				if(delete_flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
			}
				
			out.println(delete_flag);
		}
		else if(func_mode.equalsIgnoreCase("closeConditionAgainstTrmt")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String trmt_chart_num = checkForNull(request.getParameter( "trmt_chart_num" )) ;
			String trmt_chart_line_num = checkForNull(request.getParameter( "trmt_chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String term_set_id = checkForNull(request.getParameter( "term_set_id" )) ;
			String term_code = checkForNull(request.getParameter( "term_code" )) ;
			String occur_srl_no = checkForNull(request.getParameter( "occur_srl_no" )) ;
			String diag_status = checkForNull(request.getParameter( "diag_status" )) ;
			String cond_chart_num = checkForNull(request.getParameter( "cond_chart_num" )) ;
			String cond_chart_line_num = checkForNull(request.getParameter( "cond_chart_line_num" )) ;
			String cond_code = checkForNull(request.getParameter( "cond_code" )) ;

			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;

			trmt_chart_line_num=trmt_chart_line_num==null?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("null")?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("")?"1":trmt_chart_line_num;

			int cond_count = Integer.parseInt(tooth_range_count);
			int close_cond_chart_line_num_int = Integer.parseInt(trmt_chart_line_num);
			int cond_flag = 0;

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DIAG_COND SET COND_CLOSED_YN = 'Y', MODIFIED_BY_ID =?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND OCCUR_SRL_NO = ? AND TRMT_CHART_NUM =? AND TRMT_CHART_LINE_NUM = ? AND TRMT_CODE = ? AND COND_CHART_NUM = ? AND COND_CHART_LINE_NUM = ? AND CONDITION_CODE =?  ");

			if(cond_count == 0){
				pstmt.setString(1,login_user);
				pstmt.setString(2,client_ip_address);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,patient_id);
				pstmt.setString(6,term_set_id);
				pstmt.setString(7,term_code);
				pstmt.setString(8,occur_srl_no);
				pstmt.setString(9,trmt_chart_num);
				pstmt.setString(10,trmt_chart_line_num);
				pstmt.setString(11,trmt_code);
				pstmt.setString(12,cond_chart_num);
				pstmt.setString(13,cond_chart_line_num);
				pstmt.setString(14,cond_code);
				
				cond_flag = pstmt.executeUpdate();

				pstmt_dtl=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COND_CLOSED_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM =? AND CHART_LINE_NUM = ? AND CONDITION_CODE = ? AND NVL(COND_CLOSED_YN,'N') = 'N'");

				pstmt_dtl.setString(1,facility_id);
				pstmt_dtl.setString(2,patient_id);
				pstmt_dtl.setString(3,cond_chart_num);
				pstmt_dtl.setString(4,cond_chart_line_num);
				pstmt_dtl.setString(5,cond_code);
				dtl_flag = pstmt_dtl.executeUpdate();

				if(dtl_flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				
			}
			else{
				for(int j=1;j<=cond_count;j++){
					trmt_chart_line_num = close_cond_chart_line_num_int+"";
					
					pstmt.setString(1,login_user);
					pstmt.setString(2,client_ip_address);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,term_set_id);
					pstmt.setString(7,term_code);
					pstmt.setString(8,occur_srl_no);
					pstmt.setString(9,trmt_chart_num);
					pstmt.setString(10,trmt_chart_line_num);
					pstmt.setString(11,trmt_code);
					pstmt.setString(12,cond_chart_num);
					pstmt.setString(13,cond_chart_line_num);
					pstmt.setString(14,cond_code);
					cond_flag = pstmt.executeUpdate();

					close_cond_chart_line_num_int++;
				}
			}
			
			if(cond_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(cond_flag);
		}
		else if(func_mode.equalsIgnoreCase("checkLinkedConditions")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String trmt_chart_num = checkForNull(request.getParameter( "trmt_chart_num" )) ;
			String trmt_chart_line_num = checkForNull(request.getParameter( "trmt_chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String term_set_id = checkForNull(request.getParameter( "term_set_id" )) ;
			String term_code = checkForNull(request.getParameter( "term_code" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String record_count = "";
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
		}

			trmt_chart_line_num=trmt_chart_line_num==null?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("null")?"1":trmt_chart_line_num;
			trmt_chart_line_num=trmt_chart_line_num.equals("")?"1":trmt_chart_line_num;
		
			int cond_flag = 0;
			int delete_flag = 0;

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
          if (oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE  PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND TRMT_CODE = ? AND COND_CHART_NUM IS NOT NULL AND COND_CHART_LINE_NUM IS NOT NULL AND CONDITION_CODE IS NOT NULL  ");
			
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,term_set_id);
			pstmt.setString(3,term_code);
			pstmt.setString(4,trmt_chart_num);
			pstmt.setString(5,trmt_chart_line_num);
			pstmt.setString(6,trmt_code);
						
			rs = pstmt.executeQuery();
		  }else{
	        pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE OPERATING_FACILITY_ID = ? AND  PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND TRMT_CODE = ? AND COND_CHART_NUM IS NOT NULL AND COND_CHART_LINE_NUM IS NOT NULL AND CONDITION_CODE IS NOT NULL  ");
			
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,term_set_id);
			pstmt.setString(4,term_code);
			pstmt.setString(5,trmt_chart_num);
			pstmt.setString(6,trmt_chart_line_num);
			pstmt.setString(7,trmt_code);
						
			rs = pstmt.executeQuery();	  
		  
		  
		  }
			while(rs.next()){
				record_count = checkForNull(rs.getString("RECORD_COUNT"));
			}
		
			out.println(record_count);
		}
		else if(func_mode.equalsIgnoreCase("checkDiagnosisLink")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "ind_chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			
			String record_count = "";

			chart_line_num=chart_line_num==null?"1":chart_line_num;
			chart_line_num=chart_line_num.equals("null")?"1":chart_line_num;
			chart_line_num=chart_line_num.equals("")?"1":chart_line_num;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DIAG WHERE PATIENT_ID = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND TRMT_CODE = ?");
			
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				rs = pstmt.executeQuery();
		}else{
			pstmt=con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DIAG WHERE OPERATING_FACILITY_ID = ? AND  PATIENT_ID = ? AND TRMT_CHART_NUM = ? AND TRMT_CHART_LINE_NUM = ? AND TRMT_CODE = ?");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				rs = pstmt.executeQuery();

		}
			while(rs.next()){
				record_count = checkForNull(rs.getString("RECORD_COUNT"));
			}
		
			out.println(record_count);
		}
		
	 }catch(Exception e){
		con.rollback();
		System.err.println("RecordLinkCondDiagValidation: Err Msg from RecordLinkCondDiagValidation.jsp "+e);
		System.err.println("RecordLinkCondDiagValidation: Err Msg from func_mode :"+func_mode);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
