package eXH.iqvia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.json.simple.parser.ParseException;

import eXH.util.EMDataSource;
import eXH.util.XHDBAdapter;
import eXH.util.XHUtil;

public class IqviaInboundTransaction {
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_errmsg = "";

	String l_in_JSON = "", l_app_msg = "";
	
	String l_err_msg = StringUtils.EMPTY;
	
	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";


	public String InboundDetails(String applicationId, String actionKey, String eventType) throws ParseException{

		l_app_msg = "::: Inside IQVIA IqviaInboundTransaction ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 

		String returnFinalMessage = StringUtils.EMPTY;

		String l_application_id="", l_facility_id="", l_message_id="", l_srl_no="", l_message_text="", l_interface="INTERFACE";
		String l_process_id="", l_client_id="INTERFACE", l_message_ack_text="", l_message_status="", l_rd_order_yn="";

		String l_protocol_link_id="IQVIAG1";

		String l_app_msg = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_debug_yn = "";

		Map<String, String> params = new HashMap<String, String>();

		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM" ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;
		}
		catch(Exception e)
		{
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}

		try{	

			l_application_id = applicationId;
			l_app_msg = "::: Fetching Application Id ::: " + l_application_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			params.put("APPLICATION_ID", l_application_id);		

			l_facility_id = "DF";
			l_app_msg = "::: Fetching Facility Id ::: " + l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			params.put("FACILITY_ID", l_facility_id);		

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");
			l_app_msg = "::: Fetching Message Id ::: " + l_message_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			params.put("MESSAGE_ID", l_message_id);		

			l_srl_no = "1";
			l_app_msg = "::: Fetching Srl No ::: " + l_srl_no;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			params.put("SRL_NO", l_srl_no);

			//MESSAGE_RECEIVED_DATE 

			l_app_msg = "::: Fetching Process Id ::: " + l_process_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			params.put("PROCESS_ID", l_process_id);

			l_app_msg = "::: Fetching Client Id ::: " + l_client_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			params.put("CLIENT_ID", l_client_id); 

			l_message_text = actionKey;
			l_app_msg = "::: Fetching Message Text ::: " + l_message_text;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			params.put("INBOUND_MESSAGE_TEXT", l_message_text);  

			l_app_msg = "::: Fetching Message Ack Text ::: " + l_message_ack_text;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			params.put("MESSAGE_ACK_TEXT", l_message_ack_text); 



			l_app_msg = "::: Fetching Message Status ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Message Status : " + l_message_status;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			params.put("MESSAGE_STATUS", l_message_status); 



			l_app_msg = "::: Fetching Rd Order Y/N ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Rd Order Y/N : " + l_rd_order_yn;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			params.put("RD_ORDER_YN", l_rd_order_yn);  


			params.put("ADDED_BY_ID", l_interface);
			//ADDED_DATE added in the insertInbound method
			params.put("ADDED_AT_WS_NO", l_interface);
			params.put("ADDED_FACILITY_ID", l_facility_id);

			params.put("MODIFIED_BY_ID", l_interface);
			//MODIFIED_DATE added in the insertInbound method
			params.put("MODIFIED_AT_WS_NO", l_interface);
			params.put("MODIFIED_FACILITY_ID", l_facility_id);


			params.put("PATIENT_ID", "");
			params.put("MERGED_PATIENT_ID", "");
			params.put("EPISODE_TYPE", "");
			params.put("EPISODE_ID", "");
			params.put("VISIT_ID", "");
			params.put("ACCESSION_NUM", "");
			params.put("ACTION_TYPE", "");

			params.put("LAST_PROC_DATE", "");
			params.put("EVENT_STATUS", "");
			params.put("NOT_REQ_REASON", "");
			params.put("EXT_ACCESSION_NUM", "");
			params.put("EVENT_TYPE", eventType);
			params.put("PROTOCOL_LINK_ID", l_protocol_link_id);
			params.put("ERR_MSG", "");

			l_app_msg = "IQVIA Inbound Params ...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::::: "+params);	

			l_app_msg = "Inserting Params into the XH_INBOUND_MESSAGE ..";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			returnFinalMessage = insertInbound(params);

		}catch(Exception e){
			e.printStackTrace();	
		}	

		return returnFinalMessage;
	}

	public static String getFormattedStringDate(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	public static String GenerateMessageIDMethod(String SeqenceName) {

		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_trans_id = 0;

		l_app_msg = "::: Inside GenerateMessageIDMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			query = "select " + SeqenceName + ".NEXTVAL Message_id FROM DUAL ";

			if (dbConn == null)
				return l_conn_msg;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_trans_id = rs.getInt("MESSAGE_ID");
			}

			if (l_trans_id > 0) {
				l_field_value = String.valueOf(l_trans_id);
			}

		} catch (Exception e) {
			l_field_value = "Error in Generating Message ID Exception - "
					+ e.getMessage();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}

		return l_field_value;
	}

	public String insertInbound(Map<String,String> params){

		String l_app_msg = "";

		l_app_msg = "::: Inside insertInbound ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		String insertstmt = "INSERT INTO XH_INBOUND_MESSAGE (APPLICATION_ID, FACILITY_ID, MESSAGE_ID, SRL_NO, MESSAGE_RECEIVED_DATE, PROCESS_ID, "
				+ " CLIENT_ID, INBOUND_MESSAGE_TEXT, MESSAGE_ACK_TEXT, MESSAGE_STATUS, RD_ORDER_YN, ERR_MSG, "
				+ " ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, "
				+ " PATIENT_ID, MERGED_PATIENT_ID, EPISODE_TYPE, EPISODE_ID, VISIT_ID, ACCESSION_NUM, ACTION_TYPE, "
				+ " LAST_PROC_DATE, EVENT_STATUS, NOT_REQ_REASON, EXT_ACCESSION_NUM, EVENT_TYPE, PROTOCOL_LINK_ID)" 
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";  



		l_app_msg = "::: Query insertstmt ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+insertstmt);

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;

	

		try
		{
			dbConn = EMDataSource.getConnection();

			pstmt = dbConn.prepareStatement(insertstmt);

			pstmt.setString(1, params.get("APPLICATION_ID"));
			l_app_msg = "::: Inserting the APPLICATION_ID ::: "+params.get("APPLICATION_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(2, params.get("FACILITY_ID"));
			l_app_msg = "::: Inserting the FACILITY_ID ::: "+params.get("FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(3, params.get("MESSAGE_ID"));
			l_app_msg = "::: Inserting the MESSAGE_ID ::: "+params.get("MESSAGE_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(4, params.get("SRL_NO"));
			l_app_msg = "::: Inserting the SRL_NO ::: "+params.get("SRL_NO");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis())); // MESSAGE_RECEIVED_DATE

			pstmt.setString(6, XHDBAdapter.isNullReplace(params.get("PROCESS_ID"), "")); 
			l_app_msg = "::: Inserting the PROCESS_ID ::: "+params.get("PROCESS_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(7, XHDBAdapter.isNullReplace(params.get("CLIENT_ID"), ""));
			l_app_msg = "::: Inserting the CLIENT_ID ::: "+params.get("CLIENT_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(8, params.get("INBOUND_MESSAGE_TEXT"));
			l_app_msg = "::: Inserting the INBOUND_MESSAGE_TEXT ::: "+params.get("INBOUND_MESSAGE_TEXT");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(9, XHDBAdapter.isNullReplace(params.get("MESSAGE_ACK_TEXT"), "")); 
			l_app_msg = "::: Inserting the INBOUND_MESSAGE_TEXT ::: "+params.get("MESSAGE_ACK_TEXT");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(10, XHDBAdapter.isNullReplace(params.get("MESSAGE_STATUS"), ""));
			l_app_msg = "::: Inserting the INBOUND_MESSAGE_TEXT ::: "+params.get("MESSAGE_STATUS");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(11, XHDBAdapter.isNullReplace(params.get("RD_ORDER_YN"), ""));
			l_app_msg = "::: Inserting the INBOUND_MESSAGE_TEXT ::: "+params.get("RD_ORDER_YN");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(12, XHDBAdapter.isNullReplace(params.get("ERR_MSG"), ""));
			l_app_msg = "::: Inserting the ERR_MSG ::: "+params.get("ERR_MSG");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(13, params.get("ADDED_BY_ID"));
			l_app_msg = "::: Inserting the ADDED_BY_ID ::: "+params.get("ADDED_BY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setTimestamp(14, new java.sql.Timestamp(System.currentTimeMillis())); // ADDED_DATE

			pstmt.setString(15, params.get("ADDED_AT_WS_NO"));			
			l_app_msg = "::: Inserting the ADDED_AT_WS_NO ::: "+params.get("ADDED_AT_WS_NO");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(16, params.get("ADDED_FACILITY_ID"));		
			l_app_msg = "::: Inserting the ADDED_FACILITY_ID ::: "+params.get("ADDED_FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(17, params.get("MODIFIED_BY_ID"));
			l_app_msg = "::: Inserting the MODIFIED_BY_ID ::: "+params.get("MODIFIED_BY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setTimestamp(18, new java.sql.Timestamp(System.currentTimeMillis())); // MODIFIED_DATE

			pstmt.setString(19, params.get("MODIFIED_AT_WS_NO"));			
			l_app_msg = "::: Inserting the MODIFIED_AT_WS_NO ::: "+params.get("MODIFIED_AT_WS_NO");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(20, params.get("MODIFIED_FACILITY_ID"));		
			l_app_msg = "::: Inserting the MODIFIED_FACILITY_ID ::: "+params.get("MODIFIED_FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(21, XHDBAdapter.isNullReplace(params.get("PATIENT_ID"), ""));	
			l_app_msg = "::: Inserting the PATIENT_ID ::: "+params.get("PATIENT_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("MERGED_PATIENT_ID"), ""));	
			l_app_msg = "::: Inserting the MERGED_PATIENT_ID ::: "+params.get("MERGED_PATIENT_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(23, XHDBAdapter.isNullReplace(params.get("EPISODE_TYPE"), ""));	
			l_app_msg = "::: Inserting the EPISODE_TYPE ::: "+params.get("EPISODE_TYPE");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(24, XHDBAdapter.isNullReplace(params.get("EPISODE_ID"), ""));
			l_app_msg = "::: Inserting the EPISODE_ID ::: "+params.get("EPISODE_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(25, XHDBAdapter.isNullReplace(params.get("VISIT_ID"), ""));
			l_app_msg = "::: Inserting the VISIT_ID ::: "+params.get("VISIT_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(26, XHDBAdapter.isNullReplace(params.get("ACCESSION_NUM"), ""));
			l_app_msg = "::: Inserting the ACCESSION_NUM ::: "+params.get("ACCESSION_NUM");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(27, XHDBAdapter.isNullReplace(params.get("ACTION_TYPE"), ""));
			l_app_msg = "::: Inserting the ACTION_TYPE ::: "+params.get("ACTION_TYPE");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(28, XHDBAdapter.isNullReplace(params.get("LAST_PROC_DATE"), ""));
			l_app_msg = "::: Inserting the LAST_PROC_DATE ::: "+params.get("LAST_PROC_DATE");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(29, XHDBAdapter.isNullReplace(params.get("EVENT_STATUS"), ""));
			l_app_msg = "::: Inserting the EVENT_STATUS ::: "+params.get("EVENT_STATUS");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(30, XHDBAdapter.isNullReplace(params.get("NOT_REQ_REASON"), ""));
			l_app_msg = "::: Inserting the NOT_REQ_REASON ::: "+params.get("NOT_REQ_REASON");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(31, XHDBAdapter.isNullReplace(params.get("EXT_ACCESSION_NUM"), ""));
			l_app_msg = "::: Inserting the EXT_ACCESSION_NUM ::: "+params.get("EXT_ACCESSION_NUM");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(32, XHDBAdapter.isNullReplace(params.get("EVENT_TYPE"), ""));
			l_app_msg = "::: Inserting the EVENT_TYPE ::: "+params.get("EVENT_TYPE");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(33, XHDBAdapter.isNullReplace(params.get("PROTOCOL_LINK_ID"), ""));
			l_app_msg = "::: Inserting the PROTOCOL_LINK_ID ::: "+params.get("PROTOCOL_LINK_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			

			insertCount = pstmt.executeUpdate();

			if (insertCount == 1) {
				l_err_msg = "Inbound Message Table Inserted Successfully";
				l_errcd = "S";
				dbConn.commit();			
			} else {
				l_err_msg = "Error in Inserting Inbound Message Table";
				l_errcd = "E";
				dbConn.rollback();
			}		

		}catch (Exception exp) {
			l_errcd = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: InsertPratitioner) Exception " + exp);
			return  l_err_msg;
		}		
		finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_errcd +"#" + l_err_msg;
	}


}
