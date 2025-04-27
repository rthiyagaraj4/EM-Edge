/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.InstrumentCount;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
//CRF-268 Instrument Count - Rajesh V
import java.sql.ResultSet;
//CRF-268 Instrument Count - Rajesh V
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;

/**
*
* @ejb.bean
*	name="InstrumentCount"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="InstrumentCount"
*	local-jndi-name="InstrumentCount"
*	impl-class-name="eOT.InstrumentCount.InstrumentCountManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOT.InstrumentCount.InstrumentCountLocal"
*	remote-class="eOT.InstrumentCount.InstrumentCountRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.InstrumentCount.InstrumentCountLocalHome"
*	remote-class="eOT.InstrumentCount.InstrumentCountHome"
*	generate= "local,remote"
*
*
*/

public class InstrumentCountManager implements SessionBean{

	Properties  prop	= null;

	//public void ejbCreate() throws RemoteException, CreateException {}
	public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) {}

	/**
	 *Method to executeTransaction to execute the Transaction
	 *@param tabData 
	 *@param sql
	 *@return String holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public String executeTransaction(HashMap tabData,String update_sql, String update_hdr_sql){
		String result = "";
		String mode = "";
		prop		 = (Properties)tabData.get( "properties" );
		try{
			 mode = (String)tabData.get("mode");
			 result=insertAndUpdateCheckList(tabData,update_sql,update_hdr_sql);
//			 result=updateCheckList(tabData,sql);
		}catch(Exception ee){
			result = "TRANSACTION_FAILED";
			System.err.println("Instrument Count Manager ExecuteTransaction"+ee);
		}finally{
	   }
	   return result;
	}

	public String insertAndUpdateCheckList(HashMap tabData,String update_sql,String update_hdr_sql){
		Connection con = null;
		PreparedStatement pstmt_update_hdr = null;
		PreparedStatement pstmt_update_hdr_2 = null;
		PreparedStatement pstmt_update = null;
		//CRF-268 Instrument Count - Rajesh V
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String otParam = "";
		//CRF-268 Instrument Count - Rajesh V
		HashMap all_set_item_map = (HashMap) tabData.get("all_set_item_map");
		ArrayList map_keys_list = (ArrayList)tabData.get("map_keys_list");

		String result = "";
		String facility_id = (String)tabData.get("facility_id");
//		String patient_id = (String) tabData.get("patient_id");
		String booking_num = (String) tabData.get("booking_num");
		String oper_num = (String)tabData.get("oper_num");
		String login_user = (String)tabData.get("login_by_id");
		String login_at_ws_no = (String)tabData.get("login_at_ws_no");
		HashMap set_map = new HashMap();
		HashMap item_map = new HashMap();
		ArrayList hdr_upd_list = new ArrayList();
		String remarks = "";
		String initial_status_cmpl_yn	= "N";
		String final_status_cmpl_yn		= "N";
		String bio_hazard_yn = (String)tabData.get("bio_hazard_yn");
		int size=0;
		int count = 0;
		int transaction_commit_count = 0;
		try{
			con = ConnectionManager.getConnection(prop);
			//CRF-268 Instrument Count - Rajesh V
			String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";

			pstmt = con.prepareStatement(sqlOtParam);
			pstmt.setString(1,facility_id);
			rs=pstmt.executeQuery();
			if(rs !=null && rs.next())
			{
				otParam=rs.getString("facility");		
			}
			pstmt = null;
			rs = null;
			if("Y".equalsIgnoreCase(otParam)){
				update_sql = "UPDATE OT_STORE_ISSUE_DTLS SET CSSD_QTY= ?,OPEN_QTY = ?, INITIAL_STATUS = ?, INITIAL_STATUS_REMARKS = NVL(?,''), RETURN_QTY = ?, FINAL_STATUS = ?, FINAL_REMARKS = NVL(?,''), GENERAL_REMARKS=NVL(?,''), FINALIZED_YN = NVL(?,'N'),MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX')) AND OPER_NUM = NVL(?,OPER_NUM) AND SET_CODE = ? AND ITEM_CODE = ?";
				update_hdr_sql = "UPDATE OT_STORE_ISSUE_HDR SET INITIAL_COUNT_CMPL_YN=NVL(?,'N'),FINAL_COUNT_CMPL_YN=NVL(?,'N') WHERE OPERATING_FACILITY_ID=?  AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX')) AND OPER_NUM = NVL(?,OPER_NUM) AND SET_CODE=?";
			}
			
			//CRF-268 Instrument Count - Rajesh V
			pstmt_update = con.prepareStatement(update_sql);
			pstmt_update_hdr = con.prepareStatement(update_hdr_sql);
			size = map_keys_list.size();
			int index = 1;
			String map_key = "";
			String qty = "";
			String update_flag = "N";
			String set_code = "";
			String tray_num = "";
			// Update the OT_store_issue_hdr for bio_hazard flag
			String sql_hdr = "UPDATE OT_STORE_ISSUE_HDR SET BIO_HAZARD_YN=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = NVL(?,OPER_NUM)";
			index=1;
			pstmt_update_hdr_2 = con.prepareStatement(sql_hdr);
			pstmt_update_hdr_2.setString(index++,bio_hazard_yn);	//BIO_HAZARD_YN
			pstmt_update_hdr_2.setString(index++,login_user);	//MODIFIED_BY_ID
			pstmt_update_hdr_2.setString(index++,login_at_ws_no);	//MODIFIED_AT_WS_NO
			pstmt_update_hdr_2.setString(index++,facility_id);//MODIFIED_FACILITY_ID
			pstmt_update_hdr_2.setString(index++,facility_id);	//OPERATING_FACILITY_ID
			pstmt_update_hdr_2.setString(index++,oper_num);	//OPER_NUM
			count = pstmt_update_hdr_2.executeUpdate(); 
			if(count>0)
			{
				con.commit();
				result = "RECORD_INSERTED";
			}else{
				 con.rollback();
			}
			if(size==0)
				size=-1;
			for(int i=0;i<size;i++){
				map_key = (String)map_keys_list.get(i);
				set_map = (HashMap)all_set_item_map.get(map_key);
				for(int j=1;j<=set_map.size();j++){
					item_map = (HashMap)set_map.get(j+"");
					update_flag=(String)item_map.get("UPDATE_FLAG");
					update_flag = update_flag==null?"N":update_flag;
					update_flag = update_flag.equals("null")?"N":update_flag;
					index = 1;
					if(update_flag.equals("Y")){
						initial_status_cmpl_yn	= (String)item_map.get("INITIAL_STATUS_CMPL_YN");
						final_status_cmpl_yn	= (String)item_map.get("FINAL_STATUS_CMPL_YN");
						set_code = (String)item_map.get("SET_CODE");
						tray_num = (String)item_map.get("TRAY_NUM");
						if(initial_status_cmpl_yn.equals("Y") || final_status_cmpl_yn.equals("Y")){
							hdr_upd_list.add(set_code);
							hdr_upd_list.add(tray_num);
							hdr_upd_list.add(initial_status_cmpl_yn);
							hdr_upd_list.add(final_status_cmpl_yn);
						}
						qty=(String)item_map.get("CSSD_QTY");
						qty=qty==null?"0":qty;
						qty=qty.equals("null")?"0":qty;
						pstmt_update.setString(index++,qty); //OPEN_QTY

						qty=(String)item_map.get("OPEN_QTY");
						qty=qty==null?"0":qty;
						qty=qty.equals("null")?"0":qty;
						pstmt_update.setString(index++,qty); //OPEN_QTY

						pstmt_update.setString(index++,(String)item_map.get("INITIAL_STATUS")); //INITIAL_STATUS

						remarks = (String)item_map.get("INITIAL_STATUS_REMARKS");
						remarks=remarks==null?"":remarks;
						remarks=remarks.equalsIgnoreCase("null")?"":remarks;
						pstmt_update.setString(index++,remarks); //INITIAL_STATUS_REMARKS

						qty=(String)item_map.get("RETURN_QTY");
						qty=qty==null?"0":qty;
						qty=qty.equals("null")?"0":qty;
						pstmt_update.setString(index++,qty); //RETURN_QTY
						pstmt_update.setString(index++,(String)item_map.get("FINAL_STATUS")); //FINAL_STATUS

						remarks = (String)item_map.get("FINAL_REMARKS");
						remarks=remarks==null?"":remarks;
						remarks=remarks.equalsIgnoreCase("null")?"":remarks;
						pstmt_update.setString(index++,remarks); //FINAL_REMARKS

						remarks = (String)item_map.get("GENERAL_REMARKS");
						remarks=remarks==null?"":remarks;
						remarks=remarks.equalsIgnoreCase("null")?"":remarks;
						pstmt_update.setString(index++,remarks); //GENERAL_REMARKS
						if(final_status_cmpl_yn.equals("Y"))
							pstmt_update.setString(index++,"Y"); //FINALIZED_YN
						else
							pstmt_update.setString(index++,"N"); //FINALIZED_YN
						pstmt_update.setString(index++,login_user);	//MODIFIED_BY_ID
						pstmt_update.setString(index++,login_at_ws_no);	//MODIFIED_AT_WS_NO
						pstmt_update.setString(index++,facility_id);//MODIFIED_FACILITY_ID
						pstmt_update.setString(index++,facility_id);//OPERATING_FACILITY_ID
						pstmt_update.setString(index++,booking_num);//BOOKING_NUM
						pstmt_update.setString(index++,oper_num);	//OPER_NUM
						pstmt_update.setString(index++,set_code);	// SET_CODE	
						//CRF-268 Instrument Count - Rajesh V
						if(!("Y".equalsIgnoreCase(otParam))){
						pstmt_update.setString(index++,tray_num);	// 	TRAY_NUM
						}
						//CRF-268 Instrument Count - Rajesh V
						pstmt_update.setString(index++,(String)item_map.get("ITEM_CODE"));	// ITEM_CODE
						count = pstmt_update.executeUpdate(); 
						transaction_commit_count++;
					}
				}
				for(int k=0;k<hdr_upd_list.size();k+=4){
					index=1;
					// hdr_upd_list has SET_CODE,TRAY_NUM,INITIAL_STATUS_CMPL_YN, FINAL_STATUS_CMPL_YN
					// UPDATE OT_STORE_ISSUE_HDR SET INITIAL_COUNT_CMPL_YN = ?, FINAL_COUNT_CMPL_YN=?, WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM = NVL(?,BOOKING_NUM) AND OPER_NUM = NVL(?,OPER_NUM) AND SET_CODE=? AND TRAY_NUM=?
					pstmt_update_hdr.setString(index++,""+hdr_upd_list.get(k+2));	//INITIAL_COUNT_CMPL_YN
					pstmt_update_hdr.setString(index++,""+hdr_upd_list.get(k+3));	//FINAL_COUNT_CMPL_YN
					pstmt_update_hdr.setString(index++,facility_id);	//OPERATING_FACILITY_ID
					pstmt_update_hdr.setString(index++,booking_num);	//BOOKING_NUM
					pstmt_update_hdr.setString(index++,oper_num);		//OPER_NUM		
					pstmt_update_hdr.setString(index++,""+hdr_upd_list.get(k));	//SET_CODE
					//CRF-268 Instrument Count - Rajesh V
					if(!("Y".equalsIgnoreCase(otParam))){
					pstmt_update_hdr.setString(index,""+hdr_upd_list.get(k+1));	//TRAY_NUM
					}
					//CRF-268 Instrument Count - Rajesh V
					count = pstmt_update_hdr.executeUpdate(); 
				}
			}
			
			if(transaction_commit_count>0){
				con.commit();
				result = "RECORD_INSERTED";
			 }else{
				 con.rollback();
			 }
		}catch(Exception e){
			try{
				System.err.println("Instrument Count Manager caught error rollback performed: e="+e);
				result="TRANSACTION_FAILED";
				con.rollback();
			}catch(Exception e1){
			}
		}finally{
			try{
				pstmt.close(); 
				rs.close();	
				pstmt_update_hdr_2.close();	//Added Against AAKH-ICN-0008
				pstmt_update.close();
				pstmt_update_hdr.close();
				ConnectionManager.returnConnection(con,prop);
			}
			catch(Exception e){}
		 }
		 return result;
	}
}

