/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.PostAnesthesia;
import java.rmi.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.*;
import java.sql.*;
import javax.ejb.*;
import javax.ejb.SessionBean.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="PostAnesthesia"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PostAnesthesia"
*	local-jndi-name="PostAnesthesia"
*	impl-class-name="eOT.PostAnesthesia.PostAnesthesiaManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.PostAnesthesia.PostAnesthesiaLocal"
*	remote-class="eOT.PostAnesthesia.PostAnesthesiaRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.PostAnesthesia.PostAnesthesiaLocalHome"
*	remote-class="eOT.PostAnesthesia.PostAnesthesiaHome"
*	generate= "local,remote"
*
*
*/
public class PostAnesthesiaManager implements  SessionBean{
	HashMap stmt_hash = new HashMap();
	Connection con = null;
	//call back methods overriden
	public void ejbCreate()  {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) {}

	/**
	 *Method to insert the data
	 *@param tabData
	 *@param sqlMap
	 *@param CommonData
	 *@param prop
	 *@return String holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public String insert(ArrayList tabData, HashMap sqlMap, HashMap CommonData, Properties prop) {
		String err_text="";
		try{
				con=ConnectionManager.getConnection(prop);
				createStatementCollection(sqlMap);
				err_text = executeTransactions(tabData,CommonData);
				if(err_text.equals("RECORD_INSERTED"))
				   con.commit();
				else
				   con.rollback();

		}catch(Exception ee){
				  System.err.println("Post Anaesthesia manager error in insert method::"+ee);
		}finally{
			try{
				closeAllStatement(stmt_hash);
				//con.close();
				ConnectionManager.returnConnection(con); //Common-ICN-0052
			}
		catch(Exception e){}
		}
	 
		return err_text;
	}
public void createStatementCollection(HashMap sqlMap){
	try{
		  Set set=sqlMap.keySet();
		  Iterator itr=set.iterator();
		  PreparedStatement pstmt=null;
		  String key="";
		  while(itr.hasNext()){
			  key=(String) itr.next();
				  pstmt=con.prepareStatement((String) sqlMap.get(key));
				  stmt_hash.put(key,pstmt);
		  }
	 }catch(Exception ee){
		System.err.println("Post Anaesthesia manager Err createStatementCollection(EJB): "+ee);
		closeAllStatement(stmt_hash);
	 }
}
public String executeTransactions(ArrayList tabData,HashMap CommonData){
		String pract_type="";
		String role_id="";
		String pract_vals="";
		StringTokenizer stk=null;
		//StringTokenizer stk1=null; //Commented Against AAKH-ICN-0008
		PreparedStatement pstmt = null;
		//PreparedStatement pstmt1 = null; //Commented Against AAKH-ICN-0008
		ResultSet rs=null;
		HashMap hash=null;
		String err_text="";
		String key="";
		int flag=0;
		int size=tabData.size();
		int ot_post_oper_personnel_dup_flag = 0;
		try{
			 for(int i=0;i<size;i++){
				 hash=(HashMap) tabData.get(i);
				 if(hash!=null){
					key=(String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
						 if(key.equals("AT_RECORD_COMPLICATIONS_I")){
							 pstmt = (PreparedStatement) stmt_hash.get(key);
							 pstmt.setString(1,(String)CommonData.get("facility_id"));
							 pstmt.setString(2,(String) hash.get("anesthesia_srl_no"));
							 pstmt.setString(3,(String)hash.get("compl_code"));
							 pstmt.setString(4,(String)CommonData.get("login_user")); 
							 pstmt.setString(5,(String)CommonData.get("login_at_ws_no"));
							 pstmt.setString(6,(String)CommonData.get("facility_id"));
							 pstmt.setString(7,(String)CommonData.get("login_user")); 
							 pstmt.setString(8,(String)CommonData.get("login_at_ws_no"));
							 pstmt.setString(9,(String)CommonData.get("facility_id"));
						}else if(key.equals("AT_RECORD_COMPLICATIONS_D")) {
							 pstmt = (PreparedStatement) stmt_hash.get(key);
							 pstmt.setString(1,(String)CommonData.get("facility_id"));
							 pstmt.setString(2,(String) hash.get("anesthesia_srl_no"));
							 pstmt.setString(3,(String)hash.get("compl_code"));
						}else if(key.equals("AT_ANAESTHESIA_RECORD_HDR_U")){
							pstmt = (PreparedStatement) stmt_hash.get(key);
							pstmt.setString(1,(String)hash.get("height"));
							pstmt.setString(2,(String) hash.get("weight"));
							pstmt.setString(3,(String)hash.get("BMI"));
							pstmt.setString(4,(String)hash.get("BSA"));
							pstmt.setString(5,(String)hash.get("doc_comp"));
							pstmt.setString(6,(String)hash.get("finish_time"));
							pstmt.setString(7,(String)hash.get("status"));
							pstmt.setString(8,(String)CommonData.get("login_user")); 
							pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
							pstmt.setString(10,(String)CommonData.get("facility_id"));
							pstmt.setString(11,(String)hash.get("rec_start_date_time"));
							pstmt.setString(12,(String)hash.get("rec_finish_date_time"));
							pstmt.setString(13,(String)CommonData.get("accession_num"));
							pstmt.setString(14,(String)CommonData.get("facility_id"));
							pstmt.setString(15,(String) hash.get("anesthesia_srl_no"));
							//where condition
							//pstmt.setString(13,(String)CommonData.get("facility_id"));
							//pstmt.setString(14,(String) hash.get("anesthesia_srl_no"));

					 }else if(key.equals("AT_PERSONNEL_I")){
						 /*pstmt = (PreparedStatement) stmt_hash.get("OT_POST_OPER_PERSONNEL_DUP");
						 pstmt.setString(1,(String)CommonData.get("facility_id"));
						 pstmt.setString(2,(String) CommonData.get("accession_num"));
						 pstmt.setString(3,(String)hash.get("practitioner_id"));
						 rs=pstmt.executeQuery();
						 if(rs!=null && rs.next()){
						}else{*/
						 pstmt = (PreparedStatement) stmt_hash.get("OT_POST_OPER_PERSONNEL_I");
						 pstmt.setString(1,(String)CommonData.get("facility_id"));
						 //pstmt.setString(2,(String) hash.get("anesthesia_srl_no"));//oper_num
						 pstmt.setString(2,(String) CommonData.get("accession_num"));//oper_num

						 pract_vals=(String)hash.get("pract_type");
						 stk=new StringTokenizer(pract_vals,"##");
						 if(stk.hasMoreTokens()){
								pract_type=stk.nextToken();
								role_id=stk.nextToken();
						 }
						 pstmt.setString(3,role_id);
						 pstmt.setString(4,pract_type);
						 pstmt.setString(5,(String)hash.get("practitioner_id"));
						 pstmt.setString(6,(String)CommonData.get("login_user")); 
						 pstmt.setString(7,(String)CommonData.get("login_at_ws_no"));
						 pstmt.setString(8,(String)CommonData.get("facility_id"));
						 pstmt.setString(9,(String)CommonData.get("login_user")); 
						 pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
						 pstmt.setString(11,(String)CommonData.get("facility_id"));
						 if(rs!=null && rs.next()){
							 ot_post_oper_personnel_dup_flag = -1; // Do not Insert the record
							// l_chk=rs.getString("L_CHK");
						 }else{
							 ot_post_oper_personnel_dup_flag=1;
							 // Moved the Code from here to line 217. AT_PERSONAL has to be inserted before inserting ot_personal
						 }
					//}
				 }else if(key.equals("AT_PERSONNEL_D")) {
//DELETE FROM OT_POST_OPER_PERSONNEL WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND PRACTITIONER_ID=?

					 pstmt = (PreparedStatement) stmt_hash.get(key);
					 pstmt.setString(1,(String)CommonData.get("facility_id"));
					 pstmt.setString(2,(String) CommonData.get("accession_num"));
					 pstmt.setString(3,(String)hash.get("practitioner_id"));

				}
			  flag = pstmt.executeUpdate(); 
			  if(flag > 0){
					err_text ="RECORD_INSERTED";
			  }//end of flag
			}//end for hash(if loop)
		}//end of for-Loop
	 }catch(Exception e){
		 err_text = e.getMessage();
		 System.err.println("Post Anaesthesia manager Err Msg in Execute Process "+e.getMessage());
	 }finally{
		try{
			pstmt.close();
		}
		catch(Exception e){}
	 }
	 return err_text;
}//close of method execute transactions

void closeAllStatement(HashMap hashStatement){
	String key="";
	Set set=hashStatement.keySet();
	Iterator itr=set.iterator();
	PreparedStatement pstmt=null;
	try{
		while(itr.hasNext()){
			 key=(String) itr.next();
			 pstmt=(PreparedStatement)hashStatement.get(key); 
			 if(pstmt!=null) pstmt.close();
		 }
	  }catch(Exception ee){
		System.err.println("Post Anaesthesia manager "+ee.getMessage());
	  }
				
}
	   
}//End OF Class
