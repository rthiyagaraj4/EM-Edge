<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;

	try{
		con = ConnectionManager.getConnection();
		
		if(func_mode.equalsIgnoreCase("getRegDateTime")){	
			String patient_id = checkForNull(request.getParameter("patient_id")) ;
			String chart_num = checkForNull(request.getParameter("chart_num")) ;
			String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
			String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
			
			String regn_date_time = "";
			String sent_out_date = "";
			String acknowledge_date = "";
			String received_date = "";

			pstmt=con.prepareStatement("SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') REGN_DATE_TIME, TO_CHAR(SENT_OUT_DATE,'DD/MM/YYYY HH24:mi') SENT_OUT_DATE, TO_CHAR(RECEIVED_DATE,'DD/MM/YYYY HH24:mi') RECEIVED_DATE, TO_CHAR(ACKNOWLEDGE_DATE,'DD/MM/YYYY HH24:mi') ACKNOWLEDGE_DATE FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,task_seq_no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				regn_date_time = checkForNull(rs.getString("REGN_DATE_TIME"));
				sent_out_date = checkForNull(rs.getString("SENT_OUT_DATE"));
				received_date = checkForNull(rs.getString("RECEIVED_DATE"));
				acknowledge_date = checkForNull(rs.getString("ACKNOWLEDGE_DATE"));
			}
			
			out.println(regn_date_time+"##"+sent_out_date+"##"+acknowledge_date+"##"+received_date);
		}
		else if(func_mode.equalsIgnoreCase("checkForExtLoc")){	
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String ext_perm_loc = "";

			pstmt=con.prepareStatement("SELECT EXT_PERM_LOC FROM OH_TASKS WHERE TASK_CODE = ?");
			pstmt.setString(1,task_code);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ext_perm_loc = checkForNull(rs.getString("EXT_PERM_LOC"));
			}
			out.println(ext_perm_loc);
		}
		else if(func_mode.equalsIgnoreCase("getCurDateTime")){	
			
			String cur_date_time = "";

			pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') CUR_DATE_TIME FROM DUAL");
			rs=pstmt.executeQuery();
			while(rs.next()){
				cur_date_time = checkForNull(rs.getString("CUR_DATE_TIME"));
			}
			out.println(cur_date_time);
		}
		else if(func_mode.equalsIgnoreCase("getNoteType")){	
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String oh_note_type = "";

			pstmt = con.prepareStatement("SELECT OH_NOTE_TYPE FROM OH_TASKS WHERE TASK_CODE = ?");
			pstmt.setString(1,task_code);
			rs=pstmt.executeQuery();
			while(rs.next()){
				oh_note_type = checkForNull(rs.getString("OH_NOTE_TYPE"));
			}
			out.println(oh_note_type);
		}
		else if(func_mode.equalsIgnoreCase("getSendOutCompleted")){	
			String patient_id = checkForNull(request.getParameter("patient_id")) ;
			String chart_num = checkForNull(request.getParameter("chart_num")) ;
			String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
			String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
			String sendout_yn = "";

			pstmt = con.prepareStatement("SELECT SENDOUT_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE =? AND TASK_CODE = ? AND TASK_SEQ = ?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,task_seq_no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				sendout_yn = checkForNull(rs.getString("SENDOUT_YN"));
			}
			out.println(sendout_yn);
		}
		else if(func_mode.equalsIgnoreCase("checkNotesCompletedYN")){	
			String contr_mod_accession_num = checkForNull(request.getParameter("contr_mod_accession_num")) ;
			String event_status = "";
			String accession_num = "";

			//pstmt = con.prepareStatement("SELECT EVENT_STATUS FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ?");
			pstmt = con.prepareStatement("SELECT EVENT_STATUS, ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM=?");
			pstmt.setString(1,contr_mod_accession_num);
			rs=pstmt.executeQuery();
			while(rs.next()){
				event_status = checkForNull(rs.getString("EVENT_STATUS"));
				accession_num = checkForNull(rs.getString("ACCESSION_NUM"));
			}
			out.println(event_status+"##"+accession_num);
		}
		else if(func_mode.equalsIgnoreCase("getAckDetailsFromDB")){	
			String patient_id = checkForNull(request.getParameter("patient_id")) ;
			String chart_num = checkForNull(request.getParameter("chart_num")) ;
			String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
			String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
			String called_from = checkForNull(request.getParameter("called_from")) ;
			String acknowledge_date = "";
			String ack_receipt_no = "";
			String acknowledged_by = "";
			String expected_delivery_date = "";
			String acknowledged_yn = "";
			String send_practitioner_id = "";
			String performing_location = "";
			String sent_out_date = "";
			String sent_to = "";
			String sendout_yn = "";
			String received_date = "";
			String received_by = "";
			String received_yn = "";
			String remarks = "";
			String lab_price = "";
			String rcv_receipt_no = "";
			
			if(called_from.equals("ack")){
				pstmt=con.prepareStatement("SELECT TO_CHAR(ACKNOWLEDGE_DATE,'DD/MM/YYYY HH24:MI') ACKNOWLEDGE_DATE, ACK_RECEIPT_NO, ACKNOWLEDGED_BY, TO_CHAR(EXPECTED_DELIVERY_DATE,'DD/MM/YYYY HH24:MI') EXPECTED_DELIVERY_DATE, ACKNOWLEDGED_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id);				
				pstmt.setString(2,chart_num);				
				pstmt.setString(3,chart_line_num);				
				pstmt.setString(4,trmt_code);				
				pstmt.setString(5,task_code);				
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				
				while(rs!=null && rs.next()){
					acknowledge_date=checkForNull(rs.getString("ACKNOWLEDGE_DATE"));
					ack_receipt_no=checkForNull(rs.getString("ACK_RECEIPT_NO"));
					acknowledged_by=checkForNull(rs.getString("ACKNOWLEDGED_BY"));
					expected_delivery_date=checkForNull(rs.getString("EXPECTED_DELIVERY_DATE"));
					acknowledged_yn=checkForNull(rs.getString("ACKNOWLEDGED_YN"));
				}
				out.println(acknowledge_date+"##"+ack_receipt_no+"##"+acknowledged_by+"##"+expected_delivery_date+"##"+acknowledged_yn);
			}else if(called_from.equals("sentout")){
				pstmt=con.prepareStatement("SELECT SEND_FROM_FACILITY_ID, SEND_FROM_LOCATION, SEND_PRACTITIONER_ID, PERFORMING_LOCATION, TO_CHAR(SENT_OUT_DATE,'DD/MM/YYYY HH24:MI') SENT_OUT_DATE, SENT_TO, SENDOUT_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id);				
				pstmt.setString(2,chart_num);				
				pstmt.setString(3,chart_line_num);				
				pstmt.setString(4,trmt_code);				
				pstmt.setString(5,task_code);				
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				
				while(rs!=null && rs.next()){
					//send_from_facility_id=checkForNull(rs.getString("SEND_FROM_FACILITY_ID"));
					//send_from_location=checkForNull(rs.getString("SEND_FROM_LOCATION"));
					send_practitioner_id=checkForNull(rs.getString("SEND_PRACTITIONER_ID"));
					performing_location=checkForNull(rs.getString("PERFORMING_LOCATION"));
					sent_out_date=checkForNull(rs.getString("SENT_OUT_DATE"));
					sent_to=checkForNull(rs.getString("SENT_TO"));
					sendout_yn=checkForNull(rs.getString("SENDOUT_YN"));
				}
				out.println(send_practitioner_id+"##"+performing_location+"##"+sent_out_date+"##"+sent_to+"##"+sendout_yn);
			}else if(called_from.equals("rcv")){
				pstmt=con.prepareStatement("SELECT TO_CHAR(RECEIVED_DATE,'DD/MM/YYYY HH24:MI') RECEIVED_DATE, RECEIVED_BY, RECEIVED_YN, REMARKS, LAB_PRICE, RCV_RECEIPT_NO FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id);				
				pstmt.setString(2,chart_num);				
				pstmt.setString(3,chart_line_num);				
				pstmt.setString(4,trmt_code);				
				pstmt.setString(5,task_code);				
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				
				while(rs!=null && rs.next()){
					received_date=checkForNull(rs.getString("RECEIVED_DATE"));
					received_by=checkForNull(rs.getString("RECEIVED_BY"));
					received_yn=checkForNull(rs.getString("RECEIVED_YN"));
					remarks=checkForNull(rs.getString("REMARKS"));
					lab_price=checkForNull(rs.getString("LAB_PRICE"));
					rcv_receipt_no=checkForNull(rs.getString("RCV_RECEIPT_NO"));
				}
				out.println(received_date+"OH2SEP21"+received_by+"OH2SEP21"+received_yn+"OH2SEP21"+remarks+"OH2SEP21"+lab_price+"OH2SEP21"+rcv_receipt_no);
			}
		}
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from OHTrmtSendOutAckValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>

	
