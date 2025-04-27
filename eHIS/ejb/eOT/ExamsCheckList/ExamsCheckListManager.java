/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.ExamsCheckList;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;

/**
*
* @ejb.bean
*	name="ExamsCheckList"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ExamsCheckList"
*	local-jndi-name="ExamsCheckList"
*	impl-class-name="eOT.ExamsCheckList.ExamsCheckListManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOT.ExamsCheckList.ExamsCheckListLocal"
*	remote-class="eOT.ExamsCheckList.ExamsCheckListRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.ExamsCheckList.ExamsCheckListLocalHome"
*	remote-class="eOT.ExamsCheckList.ExamsCheckListHome"
*	generate= "local,remote"
*
*
*/
public class ExamsCheckListManager implements SessionBean{
	Properties  prop	= null;
	public void ejbCreate()  {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) {}

	/**
	 *Method to executeTransaction to execute the transaction 
	 *@param tabData 
	 *@param hdr_insert_sql 
	 *@param dtl_insert_sql 
	 *@param hdr_update_sql 
	 *@param dtl_update_sql  
	 *@return String holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public String executeTransaction(HashMap tabData,String hdr_insert_sql,String dtl_insert_sql,String hdr_update_sql,String dtl_update_sql) {
		Connection con = null;
		//boolean hdr_flag = true; //Commented Against AAKH-ICN-0008
		//boolean dtl_flag = true; //Commented Against AAKH-ICN-0008
		String result = "";
		String mode = "";
		prop=(Properties)tabData.get("jdbc_prop");
		ArrayList result_arr = new ArrayList();
		String status = "";
		try{
			 mode = (String)tabData.get("mode");
			 result_arr = insertAndUpdateCheckListHdr(tabData,hdr_insert_sql,hdr_update_sql);
			 status = (String)result_arr.get(0);
			 if(!status.equals("E")){
				 result_arr = null;
				 result_arr = insertAndUpdateCheckListDtl(tabData,dtl_insert_sql,dtl_update_sql);
				 status = (String)result_arr.get(0);
				 if(!status.equals("E")){
					 try{
						 con = ConnectionManager.getConnection(prop);
						 java.util.Hashtable message = MessageManager.getMessage(con,"RECORD_INSERTED");
						 result = (String)message.get("message") ;
						 message=null;
					 }catch(Exception e1){
						 System.err.println("Exams CheckList Manager caugh Exception in creating message manager connection"+e1);
					 }finally{
						ConnectionManager.returnConnection(con,prop);
					 }
				 }else{
					result = (String)result_arr.get(1);
					result = "TRANSACTION_FAILED";
				 }
			 }else{
				 result = (String)result_arr.get(1);
				 result = "TRANSACTION_FAILED";
			 }
		}catch(Exception ee){
			result = "TRANSACTION_FAILED";
			System.err.println("Exams CheckList Manager  52: Caught Exception in ExamsCheckListManager, "+ee);
		}finally{
			tabData		= null;
			result_arr	= null;
	   }
	   return result;
	}

// method for inserting and updating HDR records.
	public ArrayList insertAndUpdateCheckListHdr(HashMap tabData,String insert_sql,String update_sql){
		Connection con = null;
		PreparedStatement pstmt_insert = null;
		PreparedStatement pstmt_update = null;		
		//int size=0; //Commented Against AAKH-ICN-0008
		ArrayList result_arr = new ArrayList();
		//String result = ""; //Commented Against AAKH-ICN-0008
		String facility_id = (String)tabData.get("facility_id");
		String login_user = (String)tabData.get("checklist_user_id");
		String login_at_ws_no = (String)tabData.get("login_at_ws_no");
		String completed_by_id = (String)tabData.get("completed_by_id");
		if(completed_by_id==null) completed_by_id="";
		if(completed_by_id!=null && completed_by_id.equals("null")) completed_by_id="";

		// hdr check_list_code and rowwise checklist_code are same... 
		// maintained separately for future changes if any
		//String checklist_value = ""; //Commented Against AAKH-ICN-0008
		String hdr_insert_update_flag = (String)tabData.get("hdr_insert_update_flag");
		int count = 0;
		int transaction_commit_count = 0;
		try{
			con = ConnectionManager.getConnection(prop);
			pstmt_insert = con.prepareStatement(insert_sql);
			pstmt_update = con.prepareStatement(update_sql);		
			if(hdr_insert_update_flag.equals("I")){
				pstmt_insert.setString(1,facility_id);
				pstmt_insert.setString(2,(String) tabData.get("order_id"));
				pstmt_insert.setString(3,(String)tabData.get("patient_id"));	 
				pstmt_insert.setString(4,"");
				pstmt_insert.setString(5,""); 
				pstmt_insert.setString(6,"1");
				pstmt_insert.setString(7,(String)tabData.get("check_list_code"));
				pstmt_insert.setString(8,completed_by_id);
				if(completed_by_id.equals(""))
					pstmt_insert.setString(9,"N"); // COMPLETED_BY_DATE
				else
					pstmt_insert.setString(9,"Y"); // COMPLETED_BY_DATE
				 //auditing Fields;
				pstmt_insert.setString(10,login_user); 
				pstmt_insert.setString(11,login_at_ws_no);
				pstmt_insert.setString(12,facility_id);
				pstmt_insert.setString(13,login_user); 
				pstmt_insert.setString(14,login_at_ws_no);
				pstmt_insert.setString(15,facility_id);
				count = pstmt_insert.executeUpdate(); 
				transaction_commit_count++;
			 }else if(hdr_insert_update_flag.equals("U")){
				 pstmt_update.setString(1,completed_by_id);
				 if(completed_by_id.equals(""))
					pstmt_update.setString(2,"N"); // COMPLETED_BY_DATE
				 else
					pstmt_update.setString(2,"Y"); // COMPLETED_BY_DATE
				 pstmt_update.setString(3,login_user); 
				 pstmt_update.setString(4,login_at_ws_no);
				 pstmt_update.setString(5,facility_id);

				 //auditing Fields;
				 pstmt_update.setString(6,facility_id);
				 pstmt_update.setString(7,(String) tabData.get("order_id"));
				 pstmt_update.setString(8,(String) tabData.get("patient_id"));
				 pstmt_update.setString(9,(String)tabData.get("check_list_code"));
				 pstmt_update.setString(10,"1");	 
				 count = pstmt_update.executeUpdate(); 
				 transaction_commit_count++;
			 }
			if(transaction_commit_count>0){
				con.commit();
			 }
			result_arr.add("");
		}catch(Exception e){
			try{
				System.err.println("Exams CheckList Manager  156: caught error rollback performed: e="+e);
				result_arr.add("E");
				result_arr.add(e);
				con.rollback();
			}catch(Exception e1){
			}
		}finally{
			try{
				if(pstmt_insert!=null) pstmt_insert.close();
				if(pstmt_update!=null) pstmt_update.close();
				ConnectionManager.returnConnection(con,prop);
			}
			catch(Exception e){}
		 }
		 return result_arr;
	}
// method for inserting and updating DTL records
	public ArrayList insertAndUpdateCheckListDtl(HashMap tabData,String insert_sql,String update_sql){
		Connection con = null;
		PreparedStatement pstmt_insert = null;
		PreparedStatement pstmt_update = null;		
		HashMap all_checklist_dtls = (HashMap) tabData.get("checklist_dtls");
		HashMap checklist_dtls = null;
		int size=0;
		ArrayList result_arr = new ArrayList();
		//String result = ""; //Commented Against AAKH-ICN-0008
		String order_id = (String) tabData.get("order_id");
		String facility_id = (String)tabData.get("facility_id");
		String login_user = (String)tabData.get("checklist_user_id");
		String login_at_ws_no = (String)tabData.get("login_at_ws_no");
		String checklist_value = "";
		String insert_update_flag = "";
		String old_remarks = "";
		String new_remarks ="";
		int count = 0;
		int transaction_commit_count = 0;
		try{
			con = ConnectionManager.getConnection(prop);
			pstmt_insert = con.prepareStatement(insert_sql);
			pstmt_update = con.prepareStatement(update_sql);			
			size = all_checklist_dtls.size();
			int insert_count = 0;
			int update_count = 0;
			for(int i=1;i<=size;i++){
				 checklist_dtls=(HashMap) all_checklist_dtls.get(i+"");
				 checklist_value = "";
				 checklist_value = (String)checklist_dtls.get("checklist_value");
				 if(checklist_value==null)
					 checklist_value="N";
				 else if(checklist_value!=null){
					 if(checklist_value.equals("null") || checklist_value.equals(""))
						 checklist_value = "N";
				 }
				 insert_update_flag	 = (String)checklist_dtls.get("insert_update_flag");
				 if(insert_update_flag.equals("I")){
					 if(checklist_value.equals("Y")){
						 insert_count++;
						 pstmt_insert.setString(1,facility_id);
						 pstmt_insert.setString(2,order_id);
						 pstmt_insert.setString(3,"1");	 
						 pstmt_insert.setString(4,(String) checklist_dtls.get("checklist_item_code"));
						 pstmt_insert.setString(5,checklist_value); 
						 new_remarks = "";
						 new_remarks = (String) checklist_dtls.get("new_remarks");
						 new_remarks=new_remarks==null?"":new_remarks;
						 new_remarks=new_remarks.equalsIgnoreCase("null")?"":new_remarks;
						 pstmt_insert.setString(6,new_remarks);
						 //auditing Fields;
						 pstmt_insert.setString(7,login_user); 
						 pstmt_insert.setString(8,login_at_ws_no);
						 pstmt_insert.setString(9,facility_id);
						 pstmt_insert.setString(10,login_user); 
						 pstmt_insert.setString(11,login_at_ws_no);
						 pstmt_insert.setString(12,facility_id);
						 count = pstmt_insert.executeUpdate(); 
						 transaction_commit_count++;
					 }
				 }else if(insert_update_flag.equals("U")){
					 update_count++;
					 pstmt_update.setString(1,checklist_value); 
					 old_remarks = "";
					 new_remarks = "";
					 old_remarks = (String) checklist_dtls.get("old_remarks");
					 old_remarks=old_remarks==null?"":old_remarks;
					 old_remarks=old_remarks.equalsIgnoreCase("null")?"":old_remarks;
					 new_remarks = (String) checklist_dtls.get("new_remarks");
					 new_remarks=new_remarks==null?"":new_remarks;
					 new_remarks=new_remarks.equalsIgnoreCase("null")?"":new_remarks;
					 if(!old_remarks.equals("") && !new_remarks.equals(""))
						old_remarks=old_remarks+" ";

					 pstmt_update.setString(2,old_remarks+new_remarks);
					 pstmt_update.setString(3,login_user); 
					 pstmt_update.setString(4,login_at_ws_no);
					 pstmt_update.setString(5,facility_id);
					 pstmt_update.setString(6,facility_id);
					 pstmt_update.setString(7,order_id);
					 pstmt_update.setString(8,(String)checklist_dtls.get("checklist_item_code"));
					 pstmt_update.setString(9,"1");	 
					 //auditing Fields;
					 count = pstmt_update.executeUpdate(); 
					 transaction_commit_count++;
				 }
			}
			if(transaction_commit_count>0){
				con.commit();
			 }
			result_arr.add("");
		}catch(Exception e){
			try{
				System.err.println("Exams CheckList Manager  254: caught error rollback performed: e="+e);
				result_arr.add("E");
				result_arr.add(e);
				con.rollback();
			}catch(Exception e1){
			}
		}finally{
			try{
				all_checklist_dtls = null;
				checklist_dtls = null;
				if(pstmt_insert!=null) pstmt_insert.close();
				if(pstmt_update!=null) pstmt_update.close();
				ConnectionManager.returnConnection(con,prop);
			}
			catch(Exception e){}
		 }
		 return result_arr;
	}

	/**
	 *Method to updateRDCheckList to update the RD details
	 *@param prop Connection Properties 
	 *@param sql 
	 *@param appt_ref_num 
	 *@param login_facility_id 
	 *@param login_by_id 
	 *@param login_at_ws_no 
	 *@return ArrayList holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public ArrayList updateRDCheckList(Properties prop,String sql,String appt_ref_num,String login_facility_id,String login_by_id,String login_at_ws_no){
		Connection con = null;
		PreparedStatement pstmt_update = null;
		ArrayList result_arr = new ArrayList();
		int count = 0; //Added Against AAKH-ICN-0008
		try{
			con = ConnectionManager.getConnection(prop);
			pstmt_update = con.prepareStatement(sql);		
			pstmt_update.setString(1,"Y");
			pstmt_update.setString(2,login_by_id); 
			pstmt_update.setString(3,login_at_ws_no);
			pstmt_update.setString(4,login_facility_id);
			pstmt_update.setString(5,login_facility_id);
			pstmt_update.setString(6,appt_ref_num);
			count = pstmt_update.executeUpdate(); 
			con.commit();
			result_arr.add("S");
		}catch(Exception e){
			try{
				System.err.println("Exams CheckList Manager  156: caught error rollback performed: e="+e);
				result_arr.add("E");
				result_arr.add(e);
				con.rollback();
			}catch(Exception e1){
			}
		}finally{
			try{
				if(pstmt_update!=null) pstmt_update.close();
				ConnectionManager.returnConnection(con,prop);
			}
			catch(Exception e){}
		 }
		 return result_arr;
	}
// end of insering and updating DTL records
}

