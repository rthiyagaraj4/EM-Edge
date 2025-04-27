/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.CheckIn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap ;
import java.util.Properties;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eOT.Common.BillingUtil;
import eOT.Common.ErrorQueue;
import eOT.Common.OTEJBSessionAdapter ;
import eOT.Common.OperationBillingManager;
/**
*
* @ejb.bean
*	name="CheckIn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CheckIn"
*	local-jndi-name="CheckIn"
*	impl-class-name="eOT.CheckIn.CheckInManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.CheckIn.CheckInLocal"
*	remote-class="eOT.CheckIn.CheckInRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.CheckIn.CheckInLocalHome"
*	remote-class="eOT.CheckIn.CheckInHome"
*	generate= "local,remote"
*
*
*/

public class CheckInManager extends OTEJBSessionAdapter
{
	Properties  prop		= null;
	// Connection connection = null;//Commented on 03/07/13
	/**
	 *Method to modify the data
	 *@param tabData
	 *@param sqlMap
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) );
		map.put( "flag", "0" );
		return map;
	}
	/**
	 *Method to delete the data
	 *@param tabData
	 *@param sqlMap
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) );
		map.put( "flag", "0" );
		return map;
	}

	/**
	 *Method to insert the data
	 *@param tabData
	 *@param sqlMap
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public HashMap insert( HashMap tabData, HashMap sqlMap )
{
	HashMap map = new HashMap() ;
	HashMap checkin_hdr = null;
	HashMap post_oper_dtls = null;
	Connection connection = null;//Changed on 03/07/13 against UAT5 - Connection Issue
	System.err.println("====tabData====CheckInManager====="+tabData);
	//String resourceBusyChk = "";
	try
	{
		boolean transaction_flag = false;
		ArrayList mandatory_flds = (ArrayList)tabData.get("mandatory_flds");
		String login_at_ws_no	 = (String)mandatory_flds.get(1);	//login_at_ws_no
		String login_facility_id = (String)mandatory_flds.get(2);	//login_facility_id
		prop					 = (Properties)tabData.get( "properties" );
		connection=ConnectionManager.getConnection(prop);//Changed on 03/07/13 against UAT5 - Connection Issue
		connection.setAutoCommit(false);//multi user issue
		String sql_ot_common_qry_select1 = (String)sqlMap.get("SQL_OT_COMMON_QRY_SELECT1");
		String user_id_to_insert = (String)tabData.get("user_id_to_insert");
		String patient_class	 = (String)tabData.get("patient_class");
		String booking_no		 = checkForNull( (String)tabData.get("booking_no") );
		//String booking_no		 = (String)tabData.get("booking_no") ;
		String episode_type		 = getEpisodeType(patient_class,sql_ot_common_qry_select1,connection);//Connection Issue
		String operation_no		 = "";
		String[] strOpNoDtls	 = new String[3];
		String locale			= (String)prop.getProperty("LOCALE");
		checkin_hdr = (HashMap)tabData.get("checkin_hdr");
		post_oper_dtls = (HashMap)tabData.get("post_oper_dtls");
		String order_id = "";
		String surgery_date = (String)checkin_hdr.get("surgery_date");
		String surgeon_code = (String)checkin_hdr.get("surgeon_code");
		String called_from = (String)checkin_hdr.get("called_from");
		
		strOpNoDtls = getNextOperationNumber(login_facility_id,episode_type,connection);//Connection Issue
		operation_no = strOpNoDtls[0];
		((HashMap)tabData.get("checkin_hdr")).put("oper_num",operation_no);
		if(operation_no == null && strOpNoDtls[2].equals("PRC-OT0012") )
		{
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			String error1 = getMessage(locale,"PRC-OT0059","OT");
			map.put("msgid", error1 ) ;
			return map;
		}

		//Getting Linked operation Status
		String oper_status		 = getOperStatus(connection);
		String order_type_code=BillingUtil.getOrderTypeCode(""+checkin_hdr.get("speciality_code"));
		if(oper_status.equals("DUMMY"))
		{
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", "RECORD_FAILED_AT_GET_OPER_STATUS" ) ;
			return map;
		}

		if(called_from.equals("OT_MENU"))
			((HashMap)tabData.get("checkin_hdr")).put("order_type_code",order_type_code);

			//Operation Header Insertion
			transaction_flag = insertCheckinHdr(checkin_hdr,sqlMap,user_id_to_insert,login_at_ws_no,login_facility_id,operation_no,episode_type,oper_status,connection);//Connection issue
		if(!transaction_flag)
		{
			connection.rollback();
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", "RECORD_FAILED_AT_HDR" ) ;
			return map;
		}

		//Operation Detail Insertion
		transaction_flag = insertCheckinOperationDtls(post_oper_dtls,sqlMap,user_id_to_insert,login_at_ws_no,login_facility_id,operation_no,episode_type,oper_status,order_type_code,connection);//Connection issue);
		if(!transaction_flag)
		{
			connection.rollback();
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", "RECORD_FAILED_AT_DTL" ) ;
			return map;
		}
	//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
	//Start
		if(transaction_flag)
		{
			transaction_flag = CancelOrderInIPBooking((String)checkin_hdr.get("order_id"),(String)checkin_hdr.get("patient_id"),tabData, connection);
		if(!transaction_flag)
		{
			connection.rollback();
			map.put("flag","0");
			map.put("result", "false" ) ;
			map.put("msgid", "RECORD FAILED AT ORDER_CANCEL BOOKING") ;
			return map;
		}
	}
	//End
//ORDER-ID CREATION IF ORDER-IS NULL AND PASS THIS ORDER ID FOR ORDER LINE CREATION.
		if(called_from.equals("OT_MENU"))
		{
			((HashMap)tabData.get("checkin_hdr")).put("order_type_code",order_type_code);
			String retVal=createBackOrder(tabData,connection);//Connection Issue
			order_id=(retVal.split("#")[0].equals("S"))?retVal.split("#")[1]:retVal.split("#")[0];
			((HashMap)tabData.get("checkin_hdr")).put("order_id",order_id);
		}
		if("E".equals(order_id))
		{
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", "RECORD_FAILED_AT_Check_in Manager createBackOrder Procedure" ) ;
			return map;
		}
		if(called_from.equals("OT_MENU"))
		{
			pushOrderDtls(post_oper_dtls, operation_no, login_facility_id,connection);//Connection issue
		}

		transaction_flag= updateStatusAndCommit(booking_no,operation_no,login_facility_id,user_id_to_insert,login_at_ws_no,surgery_date,surgeon_code,connection);//Connection Issue

		if(!transaction_flag) 
		{
			connection.rollback();
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", "RECORD_UPDATE_STATUS_AND_COMMIT_PROCEDURE" ) ;
			return map;
		}

		transaction_flag =(!"".equals(booking_no))?updateBookingHdr(booking_no,connection):transaction_flag;

		if(!transaction_flag)
		{
			connection.rollback();
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", "RECORD_FAILED_AT_UPDATE_BOOKING_HDR" ) ;
			return map;
		}
		if(transaction_flag)
		{
			connection.commit();
			map.put("flag","0");
			map.put("result", new Boolean( true ) ) ;
			map.put("msgid", "RECORD_INSERTED" ) ;
		}
		else
		{
			connection.rollback();
			String err_msg = ErrorQueue.getErrorMsg();
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", err_msg) ;
		 }

		if(transaction_flag)
		{
			transaction_flag = OperationBillingManager.intializeOperationBillingManager(tabData).processBilling(connection);
		if(!transaction_flag)
		{				
			String err_msg = ErrorQueue.getErrorMsg();
			map.put("flag","0");
			map.put("result", new Boolean( false ) ) ;
			map.put("msgid", err_msg) ;
			connection.rollback();
			return map;
		}
		else
		{
			connection.commit();
		}
	}
	}
	catch(Exception e)
	{
		map.put("flag","0");
		map.put("result", new Boolean( false ) ) ;
		map.put("msgid", e.toString() ) ;
		e.printStackTrace();
	}
	finally
	{
		checkin_hdr = null;
		post_oper_dtls = null;
	if(connection != null)
		ConnectionManager.returnConnection(connection,prop);//Changed on 03/07/13 against UAT5 - Connection Issue
		ErrorQueue.remove();
	}
	return map;
}

private void pushOrderDtls(HashMap oper_map, String oper_num,String login_facility_id,Connection connection){
	//HashMap map = new HashMap(); //Commented Against AAKH-ICN-0008
	PreparedStatement pstmt = null;
	ResultSet resultSet     = null;

	try{
			//connection		= ConnectionDispenser.getConnection();
			pstmt			= connection.prepareStatement("SELECT ORDER_ID,ORDER_LINE_NUM,ORDER_TYPE_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM = ? order by order_id, order_line_num");//KDAH-SCF-0520
			int index=1;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,oper_num);
			resultSet		= pstmt.executeQuery();
			while(resultSet.next()){
				HashMap Tmap = new HashMap();
				Tmap=(HashMap)oper_map.get(""+index);
				Tmap.put("order_id",resultSet.getString("ORDER_ID"));
				Tmap.put("order_type_code",resultSet.getString("ORDER_TYPE_CODE"));
				Tmap.put("order_line_num",resultSet.getString("ORDER_LINE_NUM"));
				oper_map.put(""+index,Tmap);
				index++;
		}
	}catch ( Exception e ) {
			e.printStackTrace();
	}finally {
		try{
				closeResultSet( resultSet );
				closeStatement( pstmt );
		 }catch(Exception es)
			 {
				es.printStackTrace();
			 }
	}
}

private String getEpisodeType(String patient_class,String sql_ot_common_qry_select1,Connection connection){
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	String result			= "";
	try{
			pstmt			= connection.prepareStatement(sql_ot_common_qry_select1);
			pstmt.setString(1,patient_class);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result  = resultSet.getString("EPISODE_TYPE");
			}
	}catch ( Exception e ) {
			e.printStackTrace();
	}finally {
		try{
				closeResultSet( resultSet );
				closeStatement( pstmt );
		 }catch(Exception es)
			 {
				es.printStackTrace();
			}
	}
	return result;
}

private String[] getNextOperationNumber(String login_facility_id,String episode_type,Connection connection)
{
	CallableStatement cstmt		= null ;
	String[] strOpNumDtls		=	 new String[3];
	try{
			cstmt=connection.prepareCall("{call OT_COMMON_FUNCTIONS.OT_NEXT_OPER_NO(?,?,?,?,?)}");
			cstmt.setString( 1, login_facility_id);
			cstmt.setString( 2, episode_type);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.VARCHAR);
			cstmt.registerOutParameter(5,Types.VARCHAR);
			cstmt.execute();
			strOpNumDtls[0] = cstmt.getString(3);
			strOpNumDtls[1] = cstmt.getString(4);
			strOpNumDtls[2] = cstmt.getString(5);
	}
	catch ( Exception e )
	{
		System.out.println( " Param 3 " + strOpNumDtls[0] + " - > " + strOpNumDtls[1] + " - > " + strOpNumDtls[2]);
		System.err.println( "CheckIn Manager : Error sys_date  :"+e );
		e.printStackTrace() ;
	}finally {
		try{
		closeStatement( cstmt );
		 }catch(Exception es)
			 {
				es.printStackTrace();
			}
	}
	return strOpNumDtls;
}

private String getOperStatus(Connection connection){
	String oper_status = "DUMMY";
	CallableStatement cstmt= null;
	int index=0;
	try{
			cstmt=connection.prepareCall("{call OT_COMMON_FUNCTIONS.OT_FUNC_STATUS(?,?)}");
			cstmt.setString( ++index, "01");		// function_id
			cstmt.registerOutParameter( ++index, Types.VARCHAR );  // STATUS
			cstmt.execute();
			oper_status = cstmt.getString(index);
		}catch ( Exception e ) {
			e.printStackTrace();
		}finally {
			try{
					closeStatement( cstmt );
			 }catch(Exception es)
				 {
					es.printStackTrace();
				}
		}
	return oper_status;
}

private boolean insertCheckinHdr(HashMap checkin_hdr,HashMap sqlMap,String user_id_to_insert,String login_at_ws_no,String login_facility_id,String operation_no,String episode_type,String oper_status,Connection connection ){
	//HashMap map = new HashMap();	//Commented Against AAKH-ICN-0008
	PreparedStatement pstmt = null;
	String sql_ot_post_oper_hdr_insert	= (String)sqlMap.get("SQL_OT_POST_OPER_HDR_INSERT");
	try{
			String order_id = (String)checkin_hdr.get("order_id");
			if(order_id!=null && order_id.equals("null")) order_id="";
			String waitlist_no = (String)checkin_hdr.get("waitlist_no");
			//String check_in_time = (String)checkin_hdr.get("check_in_time"); //Commented Against AAKH-ICN-0008
			if(waitlist_no!=null && waitlist_no.equals("null")) 
			waitlist_no="";
			pstmt = connection.prepareStatement(sql_ot_post_oper_hdr_insert);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,operation_no);
			pstmt.setString(3,(String)checkin_hdr.get("surgery_date"));
			pstmt.setString(4,order_id);
			pstmt.setString(5,(String)checkin_hdr.get("booking_no"));
			pstmt.setString(6,waitlist_no);
			pstmt.setString(7,(String)checkin_hdr.get("patient_id"));
			pstmt.setString(8,(String)checkin_hdr.get("patient_class"));
			pstmt.setString(9,episode_type);
			pstmt.setString(10,(String)checkin_hdr.get("encounter_id"));
			pstmt.setString(11,(String)checkin_hdr.get("episode_id"));
			pstmt.setString(12,(String)checkin_hdr.get("nature_type"));
			pstmt.setString(13,(String)checkin_hdr.get("nature_code"));
			pstmt.setString(14,(String)checkin_hdr.get("speciality_code"));
			pstmt.setString(15,oper_status);
			pstmt.setString(16,(String)checkin_hdr.get("surgeon_code"));
			pstmt.setString(17,(String)checkin_hdr.get("anesthetist_code"));
			pstmt.setString(18,(String)checkin_hdr.get("anaesthesia_code"));
			pstmt.setString(19,(String)checkin_hdr.get("oper_room_code"));
			pstmt.setString(20,(String)checkin_hdr.get("order_type_code"));

			//auditing Fields
			pstmt.setString(21,user_id_to_insert); //changes if invoked from Slate
			pstmt.setString(22,login_at_ws_no);
			pstmt.setString(23,login_facility_id);
			pstmt.setString(24,user_id_to_insert); //changes if invoked from Slate
			pstmt.setString(25,login_at_ws_no);
			pstmt.setString(26,login_facility_id);
			//newly added parameter
			pstmt.setString(27,(String)checkin_hdr.get("pre_oper_diag"));
			pstmt.setString(28,(String)checkin_hdr.get("source_code"));
			pstmt.setString(29,(String)checkin_hdr.get("source_type"));
			pstmt.setString(30,(String)checkin_hdr.get("check_in_time"));
			pstmt.setString(31,(String)checkin_hdr.get("all_speciality_code"));
			pstmt.setString(32,(String)checkin_hdr.get("visit_id"));
			pstmt.setString(33,(String)checkin_hdr.get("asst_surgeon_code1")); //Newly added by rajesh on 30/08
			pstmt.setString(34,(String)checkin_hdr.get("asst_surgeon_code2")); //Newly added by rajesh on 30/08
			pstmt.execute();
	}
	catch (Exception e){
			e.printStackTrace();
			System.err.println("CheckInManager : REASON FOR FAILURE IN HDR"+e.getMessage());
		try{
			return false;
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return false;
	}finally{
		try{
				checkin_hdr = null;
				closeStatement( pstmt);
		}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	return true;
}
	
private boolean insertCheckinOperationDtls(HashMap post_oper_dtls,HashMap sqlMap,String user_id_to_insert,String login_at_ws_no,String login_facility_id,String operation_no,String episode_type,String oper_status, String order_type_code,Connection connection ){
	HashMap oper_dtls	   = null;
	PreparedStatement pstmt = null;
	String order_line_num="";
	String l_order_type_code="";
	String sql_ot_post_oper_dtls_insert	= (String)sqlMap.get("SQL_OT_POST_OPER_DTLS_INSERT");
	try{
			pstmt = connection.prepareStatement(sql_ot_post_oper_dtls_insert);
			for(int i=1;i<=post_oper_dtls.size();i++){
			oper_dtls = (HashMap)post_oper_dtls.get(""+i);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,operation_no);
			order_line_num=checkForNull( (String)oper_dtls.get("order_line_num"));
			l_order_type_code=checkForNull( (String)oper_dtls.get("order_type_code"));
			order_line_num=("".equals(order_line_num))?""+i:order_line_num;
			l_order_type_code=("".equals(l_order_type_code))?order_type_code:(String)oper_dtls.get("order_type_code");
			pstmt.setString(3,order_line_num);
			pstmt.setString(4,(String)oper_dtls.get("operation_code"));
			pstmt.setString(5,(String)oper_dtls.get("side_applicable"));
			pstmt.setString(6,(String)oper_dtls.get("remarks"));
			pstmt.setString(7,user_id_to_insert); //changes if invoked from Slate
			pstmt.setString(8,login_at_ws_no);
			pstmt.setString(9,login_facility_id);
			pstmt.setString(10,user_id_to_insert); //changes if invoked from Slate
			pstmt.setString(11,login_at_ws_no);
			pstmt.setString(12,login_facility_id);
			pstmt.setString(13,(String)oper_dtls.get("order_id"));
			//pstmt.setString(14,(String)oper_dtls.get("order_type_code"));
			pstmt.setString(14,order_type_code);
			pstmt.setString(15,order_line_num);
			pstmt.setString(16,checkForNull((String)oper_dtls.get("fpp_category")));//Added Against ML-MMOH-CRF-1939-US4
			pstmt.execute();
		}
	}
	catch (Exception e){
			e.printStackTrace();
			System.err.println("Check In Manager REASON FOR FAILURE IN DTLS"+e.getMessage());
		try{
			return false;
		}catch(Exception ee){
			ee.printStackTrace();
		}
		e.printStackTrace();
	}finally{
		try{
				oper_dtls = null;
				post_oper_dtls = null;
				closeStatement( pstmt ) ;
		}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	return true;
}

private boolean updateStatusAndCommit(String booking_no,String oper_num,String login_facility_id,String user_id_to_insert,String login_at_ws_no,String surgery_date, String surgeon_code,Connection connection){
	String error_text = "";
	String langErrorMsg = "";
	String status = "";
	CallableStatement cstmt= null ;
	int index=1;
	boolean	update_flag = true;
	try{
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,?,?,null,null,?,?,null,null,null,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,?,?,?,?,?)}");

			cstmt.setString( index++, "01");		// function_id
			cstmt.setString( index++, login_facility_id);	// operating_facility_id
			cstmt.setString( index++, booking_no);		// booking_num
			cstmt.setString( index++, oper_num);		// oper_num
														// Holding Area Code
														// CHECKED_IN_DATE_TIME
			cstmt.setString( index++, "N");				// DOC_COMPL_YN for Recovery
			cstmt.setString( index++, surgery_date);	// Operation_Date for Recovery
														// ADDNL_FLD2, ADDNL_FLD3,ADDNL_FLD4
			cstmt.setString( index++, surgeon_code);	// ADDNL_FLD5
			cstmt.setString( index++, user_id_to_insert);		// USER_ID , Slate login_id
			cstmt.setString( index++, login_at_ws_no);	// WS_NO
			cstmt.registerOutParameter( index++, Types.VARCHAR );	  // STATUS-> 'E' for Error and 'S' for Success
			cstmt.registerOutParameter( index++, Types.VARCHAR );  // ERROR_TEXT
			cstmt.registerOutParameter( index++, Types.VARCHAR );  // V_LANG_ERR_MSG_ID
			cstmt.execute() ;
			status = cstmt.getString(index-3);
			error_text = cstmt.getString(index-2);
			langErrorMsg = cstmt.getString(index-1);
			if(status.equals("E")){
				update_flag = false;
				error_text = langErrorMsg;
			}else{
				error_text = "RECORD_INSERTED";
			}
	}catch ( Exception e ){
		e.printStackTrace();
		update_flag = false;
	}finally {
		try{
			closeStatement( cstmt );
		//	ConnectionDispenser.remove();
		 }catch(Exception es)
			 {
				es.printStackTrace();
			 }
	}
	return update_flag;
}

private boolean updateBookingHdr(String booking_no,Connection connection){
	String SQL="UPDATE OT_BOOKING_HDR SET BOOKING_STATUS='1' WHERE BOOKING_NUM=?";
	CallableStatement cstmt= null ;
	boolean	update_flag = false;
	try{
			cstmt=connection.prepareCall(SQL);
			cstmt.setString( 1, booking_no);
			int flag = cstmt.executeUpdate();
			if(flag>0){
				update_flag=true;
			}else{
			}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
				closeStatement( cstmt );
		 }catch(Exception es)
			 {
				es.printStackTrace();
			}
	}
	return update_flag;
}

private String checkForNull(String s){
	return s != null && !s.equals("") && !s.equals("null") ? s : "";
}

private String createBackOrder(HashMap tabData,Connection connection){
	HashMap<String,String> checkin_hdr = (HashMap)tabData.get("checkin_hdr");
	ArrayList<String> audit_flds = (ArrayList)tabData.get("mandatory_flds");
	String login_at_ws_no	 = (String)audit_flds.get(1);	//login_at_ws_no
	String login_facility_id = (String)audit_flds.get(2);	//login_facility_id
	String order_id="";
	String status="";
	String result="";
	String err_txt="";
	String login_user_id  = audit_flds.get(0);
	CallableStatement cstmt= null;
	try{
			cstmt=connection.prepareCall("{call OT_BACK_ORDER_CREATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,login_facility_id);//Ordering Facility
			cstmt.setString(2,null);//Booking Num
			cstmt.setString(3,checkin_hdr.get("oper_num"));//Oper_Num
			cstmt.setString(4,checkin_hdr.get("surgeon_code"));//Operating Practitioner
			cstmt.setString(5,"C");//Booking CheckIn Flag
			cstmt.setString(6,checkin_hdr.get("source_type"));//Source Type
			cstmt.setString(7,checkin_hdr.get("source_code"));//Source Code
			cstmt.setString(8,login_user_id); //Login User Id
			cstmt.setString(9,login_at_ws_no); // WorkStation Id  	/* Added below three paramters by sathish on 17-04-2009  instructed by Dilip Kumar */
			cstmt.setString(10,checkin_hdr.get("surgeon_code"));
			cstmt.setString(11,checkin_hdr.get("surgery_date"));
			cstmt.setString(12,checkin_hdr.get("nature_code"));
			cstmt.setString(13,checkin_hdr.get("anaes_review1"));
			cstmt.setString(14,checkin_hdr.get("anaesthesia_code"));
			cstmt.registerOutParameter(15,Types.VARCHAR);
			cstmt.registerOutParameter(16,Types.VARCHAR);
			cstmt.registerOutParameter(17,Types.VARCHAR);
			cstmt.execute();

			order_id = 	checkForNull(cstmt.getString(15));
			status = 	checkForNull(cstmt.getString(16));
			err_txt = 	checkForNull(cstmt.getString(17));
		if(status.equals("S"))
		{
			result="S#"+order_id;
		}
		else
		{
			result="E#"+err_txt;
		}
			cstmt.close();
	}
	catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			if(cstmt!=null) cstmt.close();
		//	con.close();
		 }catch(Exception es)
			{
				es.printStackTrace();
			}
	}
	return result;
}
//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
//Start
//This Method is used to Check Whether this OT Order has been Booked against IP BOOKING
//If Yes,Remove the ORDER from IP BOOKING

public boolean CancelOrderInIPBooking(String Order_id,String Patient_id,HashMap tabData, Connection connection)
{
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	PreparedStatement upd_pstmt=null;
	ArrayList<String> audit_flds = (ArrayList)tabData.get("mandatory_flds");
	String login_at_ws_no	 = (String)audit_flds.get(1);	//login_at_ws_no
	String login_facility_id = (String)audit_flds.get(2);	//login_facility_id
	String login_user_id  = audit_flds.get(0);
	try{
			pstmt=connection.prepareStatement("Select count(*) as cnt from ip_booking_list where patient_id=? and order_id=? ");
			pstmt.setString(1,Patient_id);
			pstmt.setString(2,Order_id);
			rset=pstmt.executeQuery();
			rset.next();
			int order_cnt=rset.getInt("cnt");
			if(order_cnt>=1)
			{
				String ot_sql="UPDATE IP_BOOKING_LIST SET ORDER_ID=NULL,ORDER_LINE_NO=NULL,OPER_CODE=NULL,OPER_SHORT_DESC=NULL,PREF_SURG_DATE=NULL,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=SYSDATE,MODIFIED_FACILITY_ID=? WHERE PATIENT_ID = ? AND ORDER_ID = ? ";

				upd_pstmt=connection.prepareCall(ot_sql);
				upd_pstmt.setString(1,login_user_id);
				upd_pstmt.setString(2,login_at_ws_no);
				upd_pstmt.setString(3,login_facility_id);
				upd_pstmt.setString(4,Patient_id);
				upd_pstmt.setString(5,Order_id);
				upd_pstmt.executeUpdate();
			}
		}
		catch(Exception e)
			{
				System.out.println("Exception occurred while checking the Order ID already exists in IP_BOOKING_LIST : "+e);
				e.printStackTrace();
				return false;
			}
	finally
	{
		try
		{
			if(pstmt != null)
					pstmt.close();
			if(upd_pstmt != null)
					upd_pstmt.close();
			if(rset != null)
					rset.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred while closing connection");
			e.printStackTrace();
		}
	}
	return true;
	}
//End

private String getMessage(String locale, String messageId, String moduleId)
{
	java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
	String mesg = (String) message.get("message");
	message.clear();
	return(mesg);
}
}//Class closing