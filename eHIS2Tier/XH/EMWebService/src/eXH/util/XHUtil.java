package eXH.util;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class XHUtil {
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";	
	public static String singleParamExeQry(String qry)
	{
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder retValue = new StringBuilder();
		try
		{
			dbConn = EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery(qry);

			if(rs.next()) {
				retValue.append(rs.getString(1));
			}
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		finally {
			XHUtil.closeDBResources(rs, stmt, null);			
			EMDataSource.returnConnection(dbConn);
		}
		return retValue.toString();
	}
	public static String getSHA512(String input){
        String toReturn = null;
        String l_errmsg = "";
        String l_app_msg = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%040x", new BigInteger(1, digest.digest()));            
            
        } catch (Exception e) {
        	//l_errcd = "E";
			l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			toReturn = l_errmsg;
        }
        return toReturn;
    }
	public String validateRequest(String actionkey,String key,String Signature){
		String l_debug_yn = "",query = "";
    	String l_app_msg = "",l_errmsg = "";
    	String l_key = "",l_salt ="";
    	String l_segment_id = "PWS",l_standard_code ="";
    	
    	Connection dbConn = null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	
		try
		{			
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;
			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
			
			l_app_msg = " ::: Inside validateRequest ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: l_segment_id : "+l_segment_id+" ::: l_standard_code : "+l_standard_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt=null;
	    	rs=null;
			
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			query = "SELECT ELEMENT_ID,NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
						+ " WHERE SEGMENT_ID = ? "
						+ " AND STANDARD_CODE = ? ";
			 			

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_segment_id);
			pstmt.setString(2, l_standard_code);
			rs = pstmt.executeQuery();
			Map<String,String> params = new HashMap<String,String>();
			while(rs.next())
			{				
				params.put(rs.getString("ELEMENT_ID"), rs.getString("DEFAULT_VALUE")==null?"":rs.getString("DEFAULT_VALUE"));
			}
			
			l_key = params.get("KEY");
			l_salt = params.get("SALT");
			l_app_msg = " ::: key : "+key+ " ::: l_key : "+l_key+ " ::: l_salt : "+l_salt;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if(!l_key.equals(key)){
				l_errmsg = "Error in "+ l_app_msg + " : " + "key doesnot match";
				l_app_msg = " ::: l_errmsg : "+l_errmsg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				return "{\"status\":0,\"error_message\":\"Authentication Error! - Key does not match \"} ";
			}
			/*l_app_msg = " ::: Fetching Siganture... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_signature = XHUtil.getSHA512(l_key+"|"+l_pkey+"|"+l_salt);
			l_app_msg = " ::: l_signature : "+l_signature;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_signature.indexOf("Error")>=0)
			{
				l_errmsg = "Error in "+ l_app_msg + " : " + l_signature;
				l_app_msg = " ::: l_errmsg : "+l_errmsg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				return "{\"status\":0,\"error_message\":\"Authentication Error!\"}";
			}
			if(!(l_signature.equals("signature"))){
				return "{\"status\":{\"response_code\":401,\"message\":\"signature mismatch\"},\"body\":{\"message\":\"signature mismatch\"}";
			}*/
			else {
				return "true";
			}
		}
		catch(Exception e)
		{
			l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			l_app_msg = " ::: l_errmsg : "+l_errmsg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			return "{\"status\":0,\"error_message\":\"Authentication Exception! - "+e.getMessage()+"\"}" ;
		}
		finally {
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		
		
	}
	public static void updateInteractiveDetails(Map<String,String> params)
	{
		String procQuery = "{call XHINTERACTIVE.INTERACTIVE_INTERFAC_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection dbConn = null;
		CallableStatement cstmt = null;

		try
		{
			dbConn = EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			cstmt = dbConn.prepareCall(procQuery);

			String msgID = XHUtil.singleParamExeQry("SELECT xh_interactive_integration_seq.nextval FROM dual");
			params.put("INTERACTIVE_TRX_NO",msgID);

			cstmt.setString(1, "I");
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.setString(4, params.get("LOGIN_USER"));
			cstmt.setString(5, params.get("CLIENT_MACHINE"));
			cstmt.setString(6, params.get("CLIENT_MACHINE"));
			cstmt.setString(7, params.get("PGM_ID"));
			cstmt.setString(8, params.get("MODULE_ID"));
			cstmt.setString(9, params.get("SESSION_ID"));
			cstmt.setString(10, params.get("REQUEST_DATE"));
			cstmt.setString(11, params.get("REQUEST_TEXT"));
			cstmt.setString(12, params.get("APPLICATION_ID"));
			cstmt.setString(13, XHDBAdapter.isNullReplace(params.get("MSG_ID"), msgID));
			cstmt.setString(14, params.get("FACILITY_ID"));
			cstmt.setString(15, params.get("MESSAGE_DATE"));
			cstmt.setString(16, params.get("EVENT_TYPE"));
			cstmt.setString(17, params.get("PATIENT_ID"));
			cstmt.setString(18, "");
			cstmt.setString(19, params.get("EPISODE_TYPE"));
			cstmt.setString(20, params.get("ENCOUNTER_ID"));
			cstmt.setString(21, params.get("ACC_NO"));
			cstmt.setString(22, params.get("EXT_ACC_NO"));
			cstmt.setString(23, params.get("REQUEST_SYNTAX"));
			cstmt.setString(24, params.get("ACK_MSG_ID"));
			cstmt.setString(25, params.get("PROTOCOL_LINK_ID"));				
			cstmt.setString(26, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID"), params.get("LOGIN_USER")));
			cstmt.setString(27, XHDBAdapter.isNullReplace(params.get("ADDED_BY_DATE"), params.get("MESSAGE_DATE")));
			cstmt.setString(28, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
			cstmt.setString(29, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_DATE"), params.get("MESSAGE_DATE")));
			cstmt.setString(30, params.get("CLIENT_MACHINE"));
			cstmt.setString(31, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));
			cstmt.setString(32, params.get("CLIENT_MACHINE"));
			cstmt.setString(33, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_FACILITY"), params.get("FACILITY_ID")));
			cstmt.setString(34, msgID);
			cstmt.setString(35, params.get("RESPONSE_TEXT"));
			cstmt.setString(36, params.get("RESPONSE_SYNTAX"));
			cstmt.setString(37, params.get("PROFILE"));
			cstmt.setString(38, params.get("ERROR_TEXT"));
			cstmt.setString(39, params.get("ACK_TEXT"));
			cstmt.setString(40, params.get("ACK_SYNTAX"));
			
			cstmt.execute();

			String errorCode = cstmt.getString(2);
			String errorMsg = cstmt.getString(3);
			
			if("S".equals(errorCode)) {
				dbConn.commit();
			}
			else {
				System.out.println("(XHUtil:updateInteractiveDetails) Error " + errorMsg);
			}
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
			System.out.println("(XHUtil:updateInteractiveDetails) Exception " + exp);
		}		
		finally {
			//XHUtil.closeDBResources(null, cstmt, dbConn);	
			XHUtil.closeDBResources(null, cstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
	}
	public static String insertInboundMessageDetails(Map<String,String> params)
	{
		String insertstmt = "INSERT INTO XI_INBOUND_MESSAGE (application_id, facility_id, message_id, srl_no, message_received_date, process_id, "
									+" client_id, inbound_message_text, message_ack_text, message_status, rd_order_yn, "
									+" added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "
									+" patient_id, merged_patient_id, episode_type, episode_id, visit_id, accession_num, action_type, "
									+" last_proc_date, event_status, not_req_reason, ext_accession_num, event_type, protocol_link_id) "
							+" VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";                       
                        
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		int insertCount = 0;

		String l_err_code = "S", l_err_msg = "Success";


		try
		{
			dbConn = EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			pstmt = dbConn.prepareStatement(insertstmt);

			pstmt.setString(1, params.get("APPLICATION_ID"));
			pstmt.setString(2, params.get("FACILITY_ID"));
			pstmt.setString(3, params.get("MSG_ID"));
			pstmt.setString(4, params.get("SRL_NO")); //SRL_NO
			pstmt.setTimestamp(5, new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(6, XHDBAdapter.isNullReplace(params.get("PROCESS_ID"),"")); // PROCESS_ID

			pstmt.setString(7, XHDBAdapter.isNullReplace(params.get("CLIENT_ID"),"")); // CLIENT_ID
			pstmt.setString(8, params.get("MESSAGE_TEXT")); //INBOUND_MESSAGE_TEXT
			pstmt.setString(9, XHDBAdapter.isNullReplace(params.get("MESSAGE_ACK_TEXT"),"")); // MESSAGE_ACK_TEXT
			pstmt.setString(10, XHDBAdapter.isNullReplace(params.get("MESSAGE_STATUS"),"")); // MESSAGE_STATUS
			pstmt.setString(11, XHDBAdapter.isNullReplace(params.get("RD_ORDER_YN"),"")); // RD_ORDER_YN

			pstmt.setString(12, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID"), params.get("LOGIN_USER")));
			pstmt.setTimestamp(13, new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(14, params.get("CLIENT_MACHINE"));
			pstmt.setString(15, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));

			pstmt.setString(16, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
			pstmt.setTimestamp(17, new  java.sql.Timestamp(System.currentTimeMillis()));		
			pstmt.setString(18, params.get("CLIENT_MACHINE"));
			pstmt.setString(19, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_FACILITY"), params.get("FACILITY_ID")));
			
			pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("PATIENT_ID"),""));
			pstmt.setString(21, XHDBAdapter.isNullReplace(params.get("MERGED_PATIENT_ID"),""));
			pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("EPISODE_TYPE"),""));
			pstmt.setString(23, XHDBAdapter.isNullReplace(params.get("EPISODE_ID"),""));
			pstmt.setString(24, XHDBAdapter.isNullReplace(params.get("VISIT_ID"),""));
			pstmt.setString(25, XHDBAdapter.isNullReplace(params.get("ACCESSION_NUM"),""));
			pstmt.setString(26, XHDBAdapter.isNullReplace(params.get("ACTION_TYPE"),""));

			pstmt.setString(27, XHDBAdapter.isNullReplace(params.get("LAST_PROC_DATE"),""));
			pstmt.setString(28, XHDBAdapter.isNullReplace(params.get("EVENT_STATUS"),""));
			pstmt.setString(29, XHDBAdapter.isNullReplace(params.get("NOT_REQ_REASON"),""));
			pstmt.setString(30, XHDBAdapter.isNullReplace(params.get("EXT_ACCESSION_NUM"),""));
			pstmt.setString(31, XHDBAdapter.isNullReplace(params.get("EVENT_TYPE"),""));
			pstmt.setString(32, XHDBAdapter.isNullReplace(params.get("PROTOCOL_LINK_ID"),""));			
			
			insertCount = pstmt.executeUpdate();

			if (insertCount == 1)
			{
				dbConn.commit();				
			}
			else
			{
				dbConn.rollback();	
			}

			return l_err_code + "$!^"+ l_err_msg;

		}
		catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(XHUtil:insertInboundMessageDetails) Exception " + exp);
			return l_err_code + "$!^"+ l_err_msg;
		}
		finally {
			XHUtil.closeDBResources(null, pstmt, null);			
			EMDataSource.returnConnection(dbConn);
		}
	}


	public static void closeDBResources(ResultSet rs, Statement stmt, Connection conn)
	{
		try {
			if(rs != null) rs.close();			
			rs = null;
		}
		catch(Exception exp) {
		}
		finally  {
			try {
				if(stmt != null) stmt.close();				
				stmt = null;
			}
			catch(Exception exp) {
			}
			finally  {
				try {
					if(conn != null) 
					{
						//conn.close();
					
						//ConnectionManager.returnConnection(conn);
						EMDataSource.returnConnection(conn);
					}
				}
				catch (Exception exp) { }				
			}
		}
	}
	
	public static String getDebugYN(){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "";
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

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
			System.out.println(" ::: Exception in getting debug YN : "+e.getMessage());
			return "N";
		}
		finally {
			//XHUtil.closeDBResources(rs, pstmt, dbConn);		
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		return l_debug_YN;

	}
	
}
