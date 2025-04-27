/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.VerifyCheckList;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;

/**
*
* @ejb.bean
*	name="VerifyCheckList"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="VerifyCheckList"
*	local-jndi-name="VerifyCheckList"
*	impl-class-name="eOT.VerifyCheckList.VerifyCheckListManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOT.VerifyCheckList.VerifyCheckListLocal"
*	remote-class="eOT.VerifyCheckList.VerifyCheckListRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.VerifyCheckList.VerifyCheckListLocalHome"
*	remote-class="eOT.VerifyCheckList.VerifyCheckListHome"
*	generate= "local,remote"
*
*
*/

public class VerifyCheckListManager implements SessionBean{

	Properties  prop	= null;

	public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) {}

	/**
	 *Method to executeTransaction to execute the Transaction
	 *@param tabData 
	 *@param insert_sql
	 *@param update_sql
	 *@return String holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public String executeTransaction(HashMap tabData,String insert_sql,String update_sql){
		String result = "";
		String mode = "";
		prop=(Properties)tabData.get("jdbc_prop");
		try{
			 mode = (String)tabData.get("mode");
			 result=insertAndUpdateCheckList(tabData,insert_sql,update_sql);
//			 result=updateCheckList(tabData,sql);
		}catch(Exception ee){
			result = "TRANSACTION_FAILED";
			System.err.println("VerifyChecklistManager : "+ee);
		}finally{
	   }
	   return result;
	}


	public String insertAndUpdateCheckList(HashMap tabData,String insert_sql, String update_sql){
		Connection con = null;
		PreparedStatement pstmt_insert = null;
		PreparedStatement pstmt_update = null;
		PreparedStatement pstmt_verify = null;
		ResultSet rs1 = null;

		HashMap all_checklist_dtls = (HashMap) tabData.get("checklist_dtls");

		HashMap checklist_dtls = null;
		String checklist_type = "";
		int size=0;
		String result = "";
		String facility_id = (String)tabData.get("facility_id");
		String checklist_stage = (String) tabData.get("checklist_stage");
		String booking_num = (String) tabData.get("booking_num");
		String oper_num = (String)tabData.get("oper_num");
		String order_id = (String)tabData.get("order_id");
		String login_user = (String)tabData.get("checklist_user_id");
		String login_at_ws_no = (String)tabData.get("login_at_ws_no");
		String checklist_value = "";
		String insert_update_flag = "";
		String accept_remarks_yn = "N";

		int countVerify = 0;

		String verify_sql = "SELECT COUNT(*) FROM  OT_OPER_CHECKLIST_DTLS  WHERE OPERATING_FACILITY_ID = ? AND ORDER_ID = ? AND BOOKING_NUM = ? AND OPER_NUM = ? AND CHECKLIST_STAGE = ? AND CHECKLIST_CODE = ? AND CHECKLIST_ITEM_CODE  = ?";

		int count = 0;
		int transaction_commit_count = 0;
		try{
			con = ConnectionManager.getConnection(prop);
			pstmt_insert = con.prepareStatement(insert_sql);
			pstmt_update = con.prepareStatement(update_sql);
			pstmt_verify = con.prepareStatement(verify_sql);

			size = all_checklist_dtls.size();
			int insert_count = 0;
			int update_count=0;
			for(int i=1;i<=size;i++){
				 checklist_dtls=(HashMap) all_checklist_dtls.get(i+"");
				 checklist_type = (String) checklist_dtls.get("checklist_type");
				 accept_remarks_yn = (String) checklist_dtls.get("accept_remarks_yn");
				 checklist_value = (String)checklist_dtls.get("checklist_value");
				 if(checklist_type.equals("C")){
					checklist_value=checklist_value==null?"N":checklist_value;
					checklist_value=checklist_value.equalsIgnoreCase("null")?"N":checklist_value;
					checklist_value=checklist_value.equals("")?"N":checklist_value;
				 }else if(checklist_type.equals("L")){
					checklist_value=checklist_value==null?"":checklist_value;
					checklist_value=checklist_value.equalsIgnoreCase("null")?"":checklist_value;
				 }
				 if(checklist_type.equals("E") && accept_remarks_yn.equals("Y")) // for header titles, there is no checklist_value
					 checklist_value="";
				 insert_update_flag	 = (String)checklist_dtls.get("insert_update_flag");
				 if( (((checklist_value!=null && !checklist_value.equals("") && !checklist_value.equals("null")) || (checklist_value!=null && checklist_value.equals("") && !checklist_value.equals("null") && checklist_value.equals("Y") )) || (checklist_type.equals("E") && accept_remarks_yn.equals("Y"))) && insert_update_flag.equals("I")){
					 insert_count++;

					pstmt_verify.setString(1,facility_id);
					pstmt_verify.setString(2,order_id);
					pstmt_verify.setString(3,booking_num);
					pstmt_verify.setString(4,oper_num);
					pstmt_verify.setString(5,checklist_stage);
					pstmt_verify.setString(6,(String) checklist_dtls.get("checklist_code"));
					pstmt_verify.setString(7,(String) checklist_dtls.get("checklist_item_code"));

					rs1 = pstmt_verify.executeQuery();
					countVerify    =  0;
					if (rs1.next()==true)
					{
						countVerify  = Integer.parseInt(rs1.getString(1));
					}
				//	System.err.println("eOT VerifyChecklistManager  OT_OPER_CHECKLIST_DTLS count "+countVerify);
					if (countVerify == 0)
					{					
					 pstmt_insert.setString(1,facility_id);
					 pstmt_insert.setString(2,checklist_stage);
					 pstmt_insert.setString(3,order_id);
					 pstmt_insert.setString(4,booking_num);
					 pstmt_insert.setString(5,oper_num);				 
					 pstmt_insert.setString(6,(String) checklist_dtls.get("checklist_code"));
					 pstmt_insert.setString(7,(String) checklist_dtls.get("checklist_item_code"));
					 pstmt_insert.setString(8,(String) checklist_dtls.get("checklist_item_srl_no"));					 
					 pstmt_insert.setString(9,checklist_value); 
					 pstmt_insert.setString(10,(String) checklist_dtls.get("remarks"));
					 //auditing Fields;
					 pstmt_insert.setString(11,login_user); 
					 pstmt_insert.setString(12,login_at_ws_no);
					 pstmt_insert.setString(13,facility_id);
					 pstmt_insert.setString(14,login_user); 
					 pstmt_insert.setString(15,login_at_ws_no);
					 pstmt_insert.setString(16,facility_id);
					 count = pstmt_insert.executeUpdate(); 
					 transaction_commit_count++;
					}
				 }else if(insert_update_flag.equals("U")){
					update_count++;
					pstmt_update.setString(1,checklist_value); 
					pstmt_update.setString(2,(String)checklist_dtls.get("remarks")); //CHECKLIST_REMARKS
					pstmt_update.setString(3,login_user);		//MODIFIED_BY_ID
					pstmt_update.setString(4,login_at_ws_no);	//MODIFIED_AT_WS_NO
					pstmt_update.setString(5,facility_id);		//MODIFIED_FACILITY_ID
					pstmt_update.setString(6,facility_id);		//OPERATING_FACILITY_ID
					pstmt_update.setString(7,booking_num);		//BOOKING_NUM
					pstmt_update.setString(8,oper_num);			//OPER_NUM
					pstmt_update.setString(9,order_id);			//ORDER_ID
					pstmt_update.setString(10,(String) checklist_dtls.get("checklist_code"));			//CHECKLIST_CODE
					pstmt_update.setString(11,(String) checklist_dtls.get("checklist_item_code"));		//CHECKLIST_ITEM_CODE
					pstmt_update.setString(12,(String) checklist_dtls.get("checklist_item_srl_no"));	//CHECKLIST_ITEM_SRL_NO
					pstmt_update.setString(13,(String) checklist_dtls.get("checklist_stage"));	//CHECKLIST_STAGE
					 count = pstmt_update.executeUpdate(); 
					 transaction_commit_count++;
				 }
				 if(rs1 != null) rs1.close(); //Common-ICN-0054
			}
			String confirm_yn = (String)tabData.get("confirm_yn");
			int confirm_count = 1;
			String booking_or_oper_flag = (String)tabData.get("booking_or_oper_flag");
			String accession_num="";
			if(!booking_num.equals("") && !booking_num.equalsIgnoreCase("null")){
				accession_num = booking_num;
				booking_or_oper_flag = "BKG";
			}else if(!order_id.equals("") && !order_id.equalsIgnoreCase("null")){
				accession_num = order_id;
				booking_or_oper_flag = "ORD";
			}else{
				accession_num = oper_num;
				booking_or_oper_flag = "OPR";
			}

/*			if(booking_or_oper_flag.equals("B"))
				accession_num = booking_num;
			else if(booking_or_oper_flag.equals("O"))
				accession_num = oper_num;
			else // order_id
				accession_num = order_id;
*/
			confirm_count = updateCheckListDtls(facility_id,booking_or_oper_flag,accession_num,checklist_stage,login_user,confirm_yn,login_at_ws_no);
			
			if(transaction_commit_count>0 && confirm_count>0){
				java.util.Properties p=(java.util.Properties)tabData.get("jdbc_prop");
				String locale = p.getProperty("LOCALE");

				con.commit();
				//java.util.Hashtable message = MessageManager.getMessage(con,"RECORD_INSERTED") ;
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");				
				result = (String)message.get("message") ;
				message=null;
			 }
		}catch(Exception e){
			try{
				System.err.println("Verify Checklist Manager caught error rollback performed: e="+e);
				result="TRANSACTION_FAILED";
				con.rollback();
			}catch(Exception e1){
			}
		}finally{
			try{
			
				if(rs1 != null) rs1.close();

				pstmt_insert.close();
				pstmt_update.close();
				pstmt_verify.close();
				rs1.close();//Common-ICN-0031-TF
				
				ConnectionManager.returnConnection(con,prop);
			}
			catch(Exception e){}
		 }
		 return result;
	}
	public int updateCheckListDtls(String facility_id,String booking_or_oper_flag, String accession_num,String checklist_stage,String user_id,String confirm_yn,String login_at_ws_no){
		String error_text = "";
		String status = "";
		Connection connection  = null ;
		CallableStatement cstmt= null ;
		int index=1;
		int count=0;
		try{
			/*
			if(booking_or_oper_flag.equals("B"))
				booking_or_oper_flag="BKG";
			else if(booking_or_oper_flag.equals("O"))
				booking_or_oper_flag="OPR";
			else 
				booking_or_oper_flag="ORD";
			*/
			connection	= ConnectionManager.getConnection(prop) ;
			cstmt=connection.prepareCall("{call OT_CHECKLIST_DTLS(?,?,?,?,?,?,null,null,null,?,?,?,?,?)}");
			cstmt.setString( index++, facility_id);			// facility_id
			cstmt.setString( index++, booking_or_oper_flag);// booking_or_oper_flag
			cstmt.setString( index++, accession_num);		// accession_num			
			cstmt.setString( index++, checklist_stage);		// checklist_stage
			cstmt.setString( index++, user_id);				// user_id
			cstmt.setString( index++, confirm_yn);			// confirm_yn
															// ADDNL_FLD1,ADDNL_FLD2, ADDNL_FLD3
			cstmt.setString( index++, user_id);				// USER_ID , Slate login_id 
			cstmt.setString( index++, login_at_ws_no);		// WS_NO

			cstmt.registerOutParameter( index++, Types.VARCHAR );	// STATUS-> 'E' for Error and 'S' for Success
			cstmt.registerOutParameter( index++, Types.VARCHAR );  // ERROR_TEXT
			cstmt.registerOutParameter( index, Types.VARCHAR );  // LANG_ERR_MSG_ID 
			cstmt.execute() ;
			connection.commit();
			status = cstmt.getString(index-2);
			if(status.equals("E")){
				count=0;
				//error_text = cstmt.getString(index);
				error_text = cstmt.getString(index);
			}else{
				count=1;
				error_text = "RECORD_INSERTED";
			}
		}catch ( Exception e ) {
			System.err.println("Verify Checklist Manager caught error in calling update proc 278===="+e);
	        e.printStackTrace() ;
		}finally {
            try{
				count=1;
				cstmt.close();
				ConnectionManager.returnConnection(connection,prop);
             }catch(Exception es){es.printStackTrace();}
        }
		return count;
	}
}

