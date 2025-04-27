/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.DispenseRights ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="DispenseRights"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DispenseRights"
*	local-jndi-name="DispenseRights"
*	impl-class-name="ePH.DispenseRights.DispenseRightsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DispenseRights.DispenseRightsLocal"
*	remote-class="ePH.DispenseRights.DispenseRightsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DispenseRights.DispenseRightsLocalHome"
*	remote-class="ePH.DispenseRights.DispenseRightsHome"
*	generate= "local,remote"
*
*
*/

public class DispenseRightsManager extends PhEJBSessionAdapter {
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put("flag","0");
		map.put("result",new Boolean(false));
		map.put( "msgid", "" ) ;

		//System.err.println("@@@@@@@@@@@DispenseRightsManager tabData="+tabData+" sqlMap="+sqlMap);

		Connection connection					= null ;
		PreparedStatement pstmt_rights			= null ;
		PreparedStatement pstmt_update_users	= null ;
		PreparedStatement pstmt_insert_users	= null ;
		PreparedStatement pstmt_rights_exist=null;
		String debug=null;

		boolean continue_flag = false;
		int count=0;
		ResultSet resultSet = null ;

		debug="before try";

		try {
			ArrayList insertData	= (ArrayList)tabData.get( "INSERTRIGHTS" );
			ArrayList insertData1	= (ArrayList)tabData.get( "INSERTUSERS" ) ;
            HashMap commonData	=	new HashMap();
            commonData=(HashMap)tabData.get("COMMONDATA"); 
			String login_facility_id=(String)commonData.get("login_facility_id");
			String getDispLocnCode=(String)commonData.get("getDispLocnCode");
			String getUserID                    = (String)commonData.get("getUserID");
			String general_yn                   = (String)commonData.get("general_yn");
			String narcotic_yn                  = (String)commonData.get("narcotic_yn");
			String controlled_yn                = (String)commonData.get("controlled_yn");
			String regn_yn                      = (String)commonData.get("regn_yn");
			String verify_yn                    = (String)commonData.get("verify_yn");
			String fill_yn                      = (String)commonData.get("fill_yn");
			String allocate_yn                  = (String)commonData.get("allocate_yn");
			String bill_receipt_yn              = (String)commonData.get("bill_receipt_yn");
			String deliver_yn                   = (String)commonData.get("deliver_yn");
			String allow_reprint_yn             = (String)commonData.get("allow_reprint_yn");
			String no_of_reprints               = (String)commonData.get("no_of_reprints");
			String medn_rtn_yn                 = (String)commonData.get("medn_rtn_yn");
			String ip_verify_yn                 = (String)commonData.get("ip_verify_yn");
			String ip_allocate_yn               = (String)commonData.get("ip_allocate_yn");
			String ip_deliver_yn                = (String)commonData.get("ip_deliver_yn");
			String login_by_id                  = (String)commonData.get("login_by_id");
			String lwsno                        = (String)commonData.get("lwsno");
			 login_facility_id =         (String)commonData.get("login_facility_id");
			 login_by_id=                 (String)commonData.get("login_by_id");
			 lwsno=                       (String)commonData.get("lwsno");
		     login_facility_id=           (String)commonData.get("login_facility_id");
		    String ip_accept_medn_rtn_yn=       (String)commonData.get("ip_accept_medn_rtn_yn");
		    String change_dose_durn_verify_yn=  (String)commonData.get("change_dose_durn_verify_yn");
		    String trade_change_allowed_yn=     (String)commonData.get("trade_change_allowed_yn");
		    String allow_multi_trade_yn=        (String)commonData.get("allow_multi_trade_yn");
		    String re_route_orders=             (String)commonData.get("re_route_orders");
		    String allow_patient_history_yn=    (String)commonData.get("allow_patient_history_yn");
		    String op_reissue_medication_yn=    (String)commonData.get("op_reissue_medication_yn");
		    String ip_reissue_medication_yn=    (String)commonData.get("ip_reissue_medication_yn");
			String unlock_records_yn=		     (String)commonData.get("unlock_records_yn");//Added for CRF-0439
			String dflt_ip_fill				=    (String)commonData.get("dflt_ip_fill"); //Added for ICN-30405
			String dflt_ip_deliver			=    (String)commonData.get("dflt_ip_deliver"); //Added for ICN-30405
			  String auth_amend_pres_yn=  (String)commonData.get("auth_amend_pres_yn");//added for ml-mmoh-crf-0863
			//int	 no_of_reprint;
			                                
	  		connection	= getConnection( (Properties)tabData.get( "properties" ) ) ;
			/* We check if for the same user,displocncode,facility combination a record already exists in the PH_DISP_RIGHTs table*/
			pstmt_rights_exist=connection.prepareStatement((String) sqlMap.get( "SQLDISPRIGHTS"));
			pstmt_rights_exist.setString(1,(String)insertData.get(0));
			pstmt_rights_exist.setString(2,(String)insertData.get(1));
			pstmt_rights_exist.setString(3,(String)insertData.get(2));
			resultSet =pstmt_rights_exist.executeQuery() ;
			while (resultSet.next()) {
				count=resultSet.getInt("COUNT1");
			}
			if (count!=0) {
				//map.put( "msgid", "Dispense Rights already exists for this Dispense Location!!!" );
				map.put( "msgid",  "RECORD_EXISTS");
				return map;
			}
			/* IF no records exist in ph_disp_rights continue with the insertion process */
			
			pstmt_rights	= connection.prepareStatement( (String) sqlMap.get( "SQL_PH_DISP_RIGHTS_INSERTRIGHTS" ) ) ;
			if (sqlMap.containsKey( "SQLINSERTUSERS" )) {
				pstmt_insert_users	= connection.prepareStatement( (String) sqlMap.get( "SQLINSERTUSERS" ) ) ;
				debug= debug + "inside insert users";
			}//end of if sqlinsertusers
			else if (sqlMap.containsKey( "SQLUPDATEUSERS" )) {
				 pstmt_update_users	= connection.prepareStatement( (String) sqlMap.get( "SQLUPDATEUSERS" ) ) ;
				debug=debug +"inside update users";
			}//end of sql update users
			

			pstmt_rights.setString(1,login_facility_id);
			pstmt_rights.setString(2,getDispLocnCode);
			pstmt_rights.setString(3,getUserID);
			pstmt_rights.setString(4,general_yn);
			pstmt_rights.setString(5,narcotic_yn);
			pstmt_rights.setString(6,controlled_yn);
			pstmt_rights.setString(7,regn_yn);
			pstmt_rights.setString(8,verify_yn);
			pstmt_rights.setString(9,fill_yn);
			pstmt_rights.setString(10,allocate_yn);
			pstmt_rights.setString(11,bill_receipt_yn);
			pstmt_rights.setString(12,deliver_yn);
			pstmt_rights.setString(13,allow_reprint_yn);
			/*int noOfPrint=0;
			try{
			if(no_of_reprints == null || (no_of_reprints.trim()).length()==0 || no_of_reprints.equals("")){
			noOfPrint=0//pstmt_rights.setInt(14,1);//no_of_reprints
			}else{
				noOfPrint=Integer.parseInt(no_of_reprints);//no_of_reprints
			}
			}catch(NumberFormatException ex){
				noOfPrint=0;
				
			}*/
			pstmt_rights.setString(14,no_of_reprints);
			pstmt_rights.setString(15,medn_rtn_yn);
			pstmt_rights.setString(16,ip_verify_yn);
			pstmt_rights.setString(17,ip_allocate_yn);
			pstmt_rights.setString(18,ip_deliver_yn);
			pstmt_rights.setString(19,login_by_id);
			pstmt_rights.setString(20,lwsno);
			pstmt_rights.setString(21,login_facility_id);
			pstmt_rights.setString(22,login_by_id);
			pstmt_rights.setString(23,lwsno);
			pstmt_rights.setString(24,login_facility_id);
			pstmt_rights.setString(25,ip_accept_medn_rtn_yn);
			pstmt_rights.setString(26,change_dose_durn_verify_yn);
			pstmt_rights.setString(27,trade_change_allowed_yn);
			pstmt_rights.setString(28,allow_multi_trade_yn);
			pstmt_rights.setString(29,re_route_orders);
			pstmt_rights.setString(30,allow_patient_history_yn);
			pstmt_rights.setString(31,op_reissue_medication_yn);
			pstmt_rights.setString(32,ip_reissue_medication_yn);
			pstmt_rights.setString(33,unlock_records_yn);//Added for CRF-0439

			pstmt_rights.setString(34,dflt_ip_fill);//Added for ICN-30405
			pstmt_rights.setString(35,dflt_ip_deliver);//Added for ICN-30405
			pstmt_rights.setString(36,commonData.get("track_outsourcing_yn")==null?"N":(String)commonData.get("track_outsourcing_yn"));//added for Bru-HIMS-CRF-087 [IN:029953] - Start
			pstmt_rights.setString(37,commonData.get("outsourcing_send_yn")==null?"N":(String)commonData.get("outsourcing_send_yn"));
			pstmt_rights.setString(38,commonData.get("outsourcing_receive_yn")==null?"N":(String)commonData.get("outsourcing_receive_yn"));
			pstmt_rights.setString(39,commonData.get("outsourcing_deliver_yn")==null?"N":(String)commonData.get("outsourcing_deliver_yn"));
			pstmt_rights.setString(40,commonData.get("outsourcing_def_action")==null?"":(String)commonData.get("outsourcing_def_action"));
			pstmt_rights.setString(41,commonData.get("outsourcing_def_facility")==null?"":(String)commonData.get("outsourcing_def_facility"));//added for Bru-HIMS-CRF-087 [IN:029953] - End
			pstmt_rights.setString(42,commonData.get("ip_medn_rtn_after_bill_gen")==null?"":(String)commonData.get("ip_medn_rtn_after_bill_gen"));//added for JD-CRF-0178 [IN:039208]
			pstmt_rights.setString(43,commonData.get("op_medn_rtn_after_bill_gen")==null?"":(String)commonData.get("op_medn_rtn_after_bill_gen"));//added for JD-CRF-0178 [IN:039208]
			pstmt_rights.setString(44,commonData.get("financial_details")==null?"":(String)commonData.get("financial_details"));//code added for JD-CRF-0156[IN:041737]
			pstmt_rights.setString(45,commonData.get("ip_dflt_disp_stage")==null?"":(String)commonData.get("ip_dflt_disp_stage"));//code added for [IN:047788]
			pstmt_rights.setString(46,commonData.get("op_dflt_disp_stage")==null?"":(String)commonData.get("op_dflt_disp_stage"));//code added for [IN:047788]
			pstmt_rights.setString(47,commonData.get("dflt_token_series_ind")==null?"":(String)commonData.get("dflt_token_series_ind"));//code added for HSA-CRF-0136 [IN:048412]
			pstmt_rights.setString(48,commonData.get("sort_token_series_ind")==null?"":(String)commonData.get("sort_token_series_ind"));//code added for HSA-CRF-0136 [IN:048412]
			pstmt_rights.setString(49, auth_amend_pres_yn);//added for ml-mmoh-crf-0863
			
			int result = pstmt_rights.executeUpdate();
			if ( result<1 ) {
				connection.rollback();
				//map.put( "msgid", "Insert Failed!!!Transaction rolled back!!!" ) ;
				map.put( "msgid", "TRANSACTION_FAILED") ;
			}
			else {
				continue_flag = true ;
			}
			if (continue_flag) {
				int result1 = 1;
				if (pstmt_insert_users != null ) {
					//map.put( "msgid", "inside pstmt_insert_users") ;
					pstmt_insert_users.setString(1,	(String)insertData1.get(0));
					pstmt_insert_users.setString(2,	(String)insertData1.get(1));
					pstmt_insert_users.setString(3,	(String)insertData1.get(2));
					pstmt_insert_users.setString(4,	(String)insertData1.get(3));
					pstmt_insert_users.setString(5,	(String)insertData1.get(4));
					pstmt_insert_users.setString(6,	(String)insertData1.get(5));
					pstmt_insert_users.setString(7,	(String)insertData1.get(6));
					pstmt_insert_users.setString(8,	(String)insertData1.get(7));
					pstmt_insert_users.setString(9,	(String)insertData1.get(8));
					result1 = pstmt_insert_users.executeUpdate() ;
				}
				else if (pstmt_update_users != null) {

					//map.put( "msgid", "inside pstmt_update_users") ;
					pstmt_update_users.setString(1,	(String)insertData1.get(0));
					pstmt_update_users.setString(2,	(String)insertData1.get(1));
					pstmt_update_users.setString(3,	(String)insertData1.get(2));
					pstmt_update_users.setString(4,	(String)insertData1.get(3));
					pstmt_update_users.setString(5,	(String)insertData1.get(4));
					result1 = pstmt_update_users.executeUpdate() ;
				}
				if ( result1<1 ) {
					connection.rollback();
					map.put( "msgid", "TRANSACTION_FAILED" );
				}
				else {
					map.put( "result", new Boolean( true ) ) ;
					map.put( "msgid",  "RECORD_INSERTED" );
					connection.commit();
				}
			}
			else {
				map.put( "result", new Boolean( true ) ) ;
				map.put( "msgid",  "RECORD_INSERTED");
				connection.commit();
			}
		}//end of try
		catch( Exception e ) {
			e.printStackTrace();
			try{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid",   "EXCEPTION_OCCURED_WHILE_INSERTION" ) ;
			}
			catch(Exception erb){
				erb.printStackTrace();
			}
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_rights ) ;
				closeStatement( pstmt_update_users ) ;
				closeStatement( pstmt_insert_users ) ;
				closeStatement( pstmt_rights_exist );
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
   		HashMap result=new HashMap();
		result.put("flag","0");
		result.put("result",new Boolean(false));
		result.put( "msgid", "" ) ;
		Connection connection=null;
		PreparedStatement pstmt_rights=null;
		PreparedStatement pstmt_update_users=null;
		try{
	  		connection	= getConnection( (Properties)tabData.get( "properties" ) ) ;
			pstmt_rights = connection.prepareStatement((String) sqlMap.get( "SQL_PH_DISP_RIGHTS_UPDATERIGHTS" )) ;
			pstmt_rights.setString(1,(String)tabData.get("general_yn")) ;
			pstmt_rights.setString(2,(String)tabData.get("narcotic_yn")) ;
			pstmt_rights.setString(3,(String)tabData.get("controlled_yn")) ;
			pstmt_rights.setString(4,(String)tabData.get("regn_yn")) ;
			pstmt_rights.setString(5,(String)tabData.get("verify_yn")) ;
			pstmt_rights.setString(6,(String)tabData.get("fill_yn")) ;
			pstmt_rights.setString(7,(String)tabData.get("allocate_yn")) ;
			pstmt_rights.setString(8,(String)tabData.get("bill_receipt_yn")) ;
			pstmt_rights.setString(9,(String)tabData.get("deliver_yn")) ;
			pstmt_rights.setString(10,(String)tabData.get("allow_reprint_yn")) ;
			pstmt_rights.setString(11,(String)tabData.get("no_of_reprints")) ;
			pstmt_rights.setString(12,(String)tabData.get("medn_rtn_yn")) ;
			pstmt_rights.setString(13,(String)tabData.get("ip_verify_yn")) ;
			pstmt_rights.setString(14,(String)tabData.get("ip_allocate_yn")) ;
			pstmt_rights.setString(15,(String)tabData.get("ip_deliver_yn")) ;
			pstmt_rights.setString(16,(String)tabData.get("login_by_id")) ;
			pstmt_rights.setString(17,(String)tabData.get("login_at_ws_no")) ;
			pstmt_rights.setString(18,(String)tabData.get("login_facility_id")) ;
			pstmt_rights.setString(19,(String)tabData.get("ip_accept_medn_rtn_yn")) ;
			pstmt_rights.setString(20,(String)tabData.get("change_dose_durn_verify_yn")) ;
			pstmt_rights.setString(21,(String)tabData.get("trade_change_allowed_yn")) ;
			pstmt_rights.setString(22,(String)tabData.get("allow_multi_trade_yn")) ;
			pstmt_rights.setString(23,(String)tabData.get("reroute_order_yn"));
			pstmt_rights.setString(24,(String)tabData.get("allow_patient_history_yn"));
			pstmt_rights.setString(25,(String)tabData.get("op_reissue_medication_yn"));
			pstmt_rights.setString(26,(String)tabData.get("ip_reissue_medication_yn"));
			pstmt_rights.setString(27,(String)tabData.get("unlock_records_yn"));
			pstmt_rights.setString(28,(String)tabData.get("dflt_ip_fill"));
			pstmt_rights.setString(29,(String)tabData.get("dflt_ip_deliver"));
			pstmt_rights.setString(30,tabData.get("track_outsourcing_yn")==null?"N":(String)tabData.get("track_outsourcing_yn"));//added for Bru-HIMS-CRF-087 [IN:029953] - Start
			pstmt_rights.setString(31,tabData.get("outsourcing_send_yn")==null?"N":(String)tabData.get("outsourcing_send_yn"));
			pstmt_rights.setString(32,tabData.get("outsourcing_receive_yn")==null?"N":(String)tabData.get("outsourcing_receive_yn"));
			pstmt_rights.setString(33,tabData.get("outsourcing_deliver_yn")==null?"N":(String)tabData.get("outsourcing_deliver_yn"));
			pstmt_rights.setString(34,tabData.get("outsourcing_def_action")==null?"":(String)tabData.get("outsourcing_def_action"));
			pstmt_rights.setString(35,tabData.get("outsourcing_def_facility")==null?"":(String)tabData.get("outsourcing_def_facility"));//added for Bru-HIMS-CRF-087 [IN:029953] - End
			pstmt_rights.setString(36,tabData.get("ip_medn_rtn_after_bill_gen")==null?"":(String)tabData.get("ip_medn_rtn_after_bill_gen"));//added for JD-CRF-0178 [IN:039208]
			pstmt_rights.setString(37,tabData.get("op_medn_rtn_after_bill_gen")==null?"":(String)tabData.get("op_medn_rtn_after_bill_gen"));//added for JD-CRF-0178 [IN:039208]
			pstmt_rights.setString(38,tabData.get("financial_details")==null?"":(String)tabData.get("financial_details"));//code added for JD-CRF-0156[IN:041737]
			pstmt_rights.setString(39,tabData.get("ip_dflt_disp_stage")==null?"":(String)tabData.get("ip_dflt_disp_stage"));//code added for [IN:047788]
			pstmt_rights.setString(40,tabData.get("op_dflt_disp_stage")==null?"":(String)tabData.get("op_dflt_disp_stage"));//code added for [IN:047788]
			pstmt_rights.setString(41,tabData.get("dflt_token_series_ind")==null?"":(String)tabData.get("dflt_token_series_ind"));//code added for HSA-CRF-0136 [IN:048412]
			pstmt_rights.setString(42,tabData.get("sort_token_series_ind")==null?"":(String)tabData.get("sort_token_series_ind"));//code added for HSA-CRF-0136 [IN:048412]
			pstmt_rights.setString(43,(String)tabData.get("auth_amend_pres_yn")) ;//added for ml-mmoh-crf-0863 (43 to 46 changed)
			pstmt_rights.setString(44,(String)tabData.get("login_facility_id")) ;
			pstmt_rights.setString(45,(String)tabData.get("disp_locn_code")) ;
			pstmt_rights.setString(46,(String)tabData.get("user_id")) ;
			
			
			
			int res =1;			
			res = pstmt_rights.executeUpdate() ;
		 
			if (sqlMap.containsKey("SQL_PH_DISP_RIGHTS_UPDATEUSER")){
				pstmt_update_users = connection.prepareStatement((String) sqlMap.get( "SQL_PH_DISP_RIGHTS_UPDATEUSER" )) ;
				pstmt_update_users.setString(1,(String)tabData.get("newPassword"));
				pstmt_update_users.setString(2,(String)tabData.get("user_id")) ;
				pstmt_update_users.setString(3,(String)tabData.get("login_at_ws_no")) ;
			    pstmt_update_users.setString(4,(String)tabData.get("login_facility_id")) ;
			    pstmt_update_users.setString(5,(String)tabData.get("user_id")) ;
				res =pstmt_update_users.executeUpdate();
			}
			if(res>=1){
				connection.commit();
				result.put( "result", new Boolean( true ) ) ;
				result.put("msgid",  "RECORD_MODIFIED");
			}
		}
		catch (Exception e){
			e.printStackTrace();				
			result.put( "msgid", "Exception in EJB:" +e.getMessage() ) ;
			try{
				connection.rollback();
			}
			catch (Exception e1){
				e1.printStackTrace() ;				
			    result.put("msgid",   "EXCEPTION_OCCURED_WHILE_INSERTION") ;
			}
		}
		finally {
			try {
				closeStatement( pstmt_rights ) ;
				closeStatement( pstmt_update_users ) ;
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return result;

	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
  		HashMap result = new HashMap() ;		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		int count=0;
		result.put("flag","0");
		result.put("result",new Boolean(false));

		try {
			connection	= getConnection( (Properties)tabData.get( "properties" ) )  ;
			try{
				pstmt = connection.prepareStatement( (String)sqlMap.get( "SQL_PH_DISP_RIGHTS_DELETERIGHTS" )) ;
				pstmt.setString(1,(String)tabData.get("login_facility_id"));
				pstmt.setString(2,(String)tabData.get("disp_locn_code"));
				pstmt.setString(3,(String)tabData.get("user_id"));
				pstmt.executeUpdate() ;
			}
			catch(Exception e){
				e.printStackTrace() ;
	            throw e ;
			}
			closeStatement( pstmt ) ;
			pstmt=connection.prepareStatement((String)sqlMap.get( "SQL_QUERY_SELECT_WORKLOAD" ));
			pstmt.setString(1,(String)tabData.get("user_id"));
			resultSet =pstmt.executeQuery() ;
			while (resultSet.next()) {
				count=resultSet.getInt(1);
			}
	
			if (count ==0) {
				try{
					closeStatement( pstmt ) ;
					pstmt = connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_RIGHTS_DELETEUSERS")) ;
					pstmt.executeUpdate();
				}
				catch(Exception e){
					connection.rollback();
					result.put( "result", new Boolean( false ) ) ;
					result.put("msgid",  "RECORD_DELETED" ) ;
					e.printStackTrace();
					return result;
				}
			}	
			connection.commit();
			result.put( "result", new Boolean( true ) ) ;
			result.put("msgid",  "RECORD_DELETED" ) ;
		}
		catch (Exception e) {
			e.printStackTrace();
			try{
				connection.rollback();
				result.put("msgid",   "TRANSACTION_FAILED" );
				return result;
			}
			catch (Exception e1){
				result.put("msgid",   "TRANSACTION_FAILED"  );
			}
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement( pstmt ) ;
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return result;
	}
}
