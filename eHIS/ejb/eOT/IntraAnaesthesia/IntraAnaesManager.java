/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.IntraAnaesthesia;
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
*	name="IntraAnaesthesia"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IntraAnaesthesia"
*	local-jndi-name="IntraAnaesthesia"
*	impl-class-name="eOT.IntraAnaesthesia.IntraAnaesManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.IntraAnaesthesia.IntraAnaesLocal"
*	remote-class="eOT.IntraAnaesthesia.IntraAnaesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.IntraAnaesthesia.IntraAnaesLocalHome"
*	remote-class="eOT.IntraAnaesthesia.IntraAnaesHome"
*	generate= "local,remote"
*
*
*/

public class IntraAnaesManager implements  SessionBean{
	HashMap stmt_hash = new HashMap();
	Connection con = null;

	String transaction_err_msg="";
	String err_text ="";
	String updt_err_text="";
	//call back methods overriden
	public void ejbCreate() {}
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
	try{
			con=ConnectionManager.getConnection(prop);
			//boolean transaction_flag = false;
			createStatementCollection(sqlMap);
			err_text = executeTransactions(tabData,CommonData);
			if(err_text.equals("RECORD_INSERTED")){
				err_text = callAnaesthesiaUpdateProcedure(tabData,CommonData);
				if(err_text.equals("RECORD_INSERTED"))
					con.commit();
				else
					con.rollback();
			}else
			   con.rollback();

		}catch(Exception ee){
		System.err.println("Intra Anaesthesia manager Error in insert method::"+ee);
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
		  // Added by bshankar
		  pstmt=con.prepareStatement("DELETE FROM OT_POST_OPER_PERSONNEL WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND PRACTITIONER_ID=?");
		  stmt_hash.put("OT_POST_OPER_PERSONNEL_D",pstmt); 
	 }catch(Exception ee){
			System.err.println("Intra Anaesthesia manager Err createStatementCollection(EJB): "+ee);
			closeAllStatement(stmt_hash);
	 }
}

public String executeTransactions(ArrayList tabData,HashMap CommonData){
	String pract_type="";
	String role_id="";
	String pract_vals="";
	StringTokenizer stk=null;
	//StringTokenizer stk1=null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs=null;
	HashMap hash=null;
	String key ="";
	String intra_op_done_yn="";
	int size=0;
	boolean flag = false;
	int count=0;
	String trace = "0";
	try{
	 size = tabData.size();
	 int deleted=0;
	 int inserted=0;
	 int total=0;
	//boolean ins_flag=true;
	//String dtl_db_mode=(String) CommonData.get("dtl_db_mode");
	 for(int i=0;i<size;i++){
		 trace = "1.0";
		 hash=(HashMap)tabData.get(i);
		 trace = "1.1";
		 key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
		 trace = "1.2";
		 if(key.equals("AT_ANAESTHESIA_RECORD_HDR_U")){
			 trace = "2.0";
			 inserted++;
			 intra_op_done_yn = (String)hash.get("intraop_done_yn") ;
			 pstmt = (PreparedStatement) stmt_hash.get(key);
			 pstmt.setString(1,(String)hash.get("weight"));
			 pstmt.setString(2,(String)hash.get("height"));
			 pstmt.setString(3,(String)hash.get("bsa"));
			 pstmt.setString(4,(String)hash.get("bmi"));
			 pstmt.setString(5,(String)hash.get("anaesthesia_code"));
			 pstmt.setString(6,(String)hash.get("anaesthetist_code1"));
			 pstmt.setString(7,(String)hash.get("anaesthetist_code2"));
			 pstmt.setString(8,(String)hash.get("start_date"));
			 pstmt.setString(9,(String)hash.get("finish_date"));
			 pstmt.setString(10,(String)hash.get("intraop_done_yn"));
			 pstmt.setString(11,(String)hash.get("status"));
			 pstmt.setString(12,(String)CommonData.get("login_user"));
			 pstmt.setString(13,(String)CommonData.get("login_at_ws_no"));
			 pstmt.setString(14,(String)CommonData.get("facility_id"));
			 pstmt.setString(15,(String) CommonData.get("accession_num"));
			 pstmt.setString(16,(String)CommonData.get("facility_id"));
			 pstmt.setString(17,(String) CommonData.get("anesthesia_srl_no"));
			 trace="2.1";
			 count = pstmt.executeUpdate();
			 trace="2.2";
			 /*pstmt1 = (PreparedStatement) stmt_hash.get("OT_POST_OPER_HDR_U");
			 pstmt1.setString(1,(String)hash.get("anaesthesia_code"));
			 pstmt1.setString(2,(String)CommonData.get("login_user"));
			 pstmt1.setString(3,(String)CommonData.get("login_at_ws_no"));
			 pstmt1.setString(4,(String)CommonData.get("facility_id"));
			 if(intra_op_done_yn.equals("Y")){
				/*
				pstmt1.setString(5,"Y");
				pstmt1.setString(6, format(Calendar.getInstance()));
				pstmt2 = (PreparedStatement) stmt_hash.get("OT_QUEUE_U");
 				//pstmt2.setString(1,(String)hash.get("Y"));
				pstmt2.setString(1,(String)CommonData.get("facility_id"));
				pstmt2.setString(2,(String) CommonData.get("accession_num"));
				count = pstmt2.executeUpdate();
			  }else{
				pstmt1.setString(5,"N");
				pstmt1.setString(6,"");
			  }
			  pstmt1.setString(7,(String)CommonData.get("facility_id"));
			  pstmt1.setString(8,(String) CommonData.get("accession_num"));
			  count = pstmt1.executeUpdate();
			 }*/
		 }else if(key.equals("AT_PERSONNEL_I")){
			 trace = "3.0";
			 pstmt1 = (PreparedStatement) stmt_hash.get("OT_POST_OPER_PERSONNEL_DUP");
			 pstmt1.setString(1,(String)CommonData.get("facility_id"));
			 pstmt1.setString(2,(String) CommonData.get("accession_num"));
 			 pstmt1.setString(3,(String)hash.get("practitioner_id"));
			 trace = "3.1";
			 rs=pstmt1.executeQuery();
			 trace = "3.2";
			 if(rs!=null && rs.next()){
				trace = "3.3";
				// l_chk=rs.getString("L_CHK");
			}else{
				trace = "3.4";
				 pstmt1 = (PreparedStatement) stmt_hash.get("OT_POST_OPER_PERSONNEL_I");
				 pstmt1.setString(1,(String)CommonData.get("facility_id"));
				 pstmt1.setString(2,(String) CommonData.get("accession_num"));
				 pract_vals=(String)hash.get("pract_type");
				 stk=new StringTokenizer(pract_vals,"##");
				 if(stk.hasMoreTokens()){
					pract_type=stk.nextToken();
					role_id=stk.nextToken();
				 }
				 pstmt1.setString(3,role_id);
				 pstmt1.setString(4,pract_type);
				 pstmt1.setString(5,(String)hash.get("practitioner_id"));
				 pstmt1.setString(6,(String)CommonData.get("login_user"));
				 pstmt1.setString(7,(String)CommonData.get("login_at_ws_no"));
				 pstmt1.setString(8,(String)CommonData.get("facility_id"));
				 pstmt1.setString(9,(String)CommonData.get("login_user"));
				 pstmt1.setString(10,(String)CommonData.get("login_at_ws_no"));
				 pstmt1.setString(11,(String)CommonData.get("facility_id"));
				 trace = "3.5";
	 			 count = pstmt1.executeUpdate();
				 trace = "3.6";
			 }
			 trace = "3.7";
		 }
		 else if(key.equals("AT_PERSONNEL_D")){
			 trace = "4.0";
			 deleted++;
			 ////pstmt = (PreparedStatement) stmt_hash.get(key);
			 ////pstmt.setString(1,(String)CommonData.get("facility_id"));
			 ////pstmt.setString(2,(String) CommonData.get("anesthesia_srl_no"));
			 pract_vals=(String)hash.get("pract_type");
			 trace = "4.1";
			 stk=new StringTokenizer(pract_vals,"##");
			 trace = "4.2";
			 if(stk.hasMoreTokens()){
				trace = "4.3";
					pract_type=stk.nextToken();
				trace = "4.4";
					role_id=stk.nextToken();
				trace = "4.5";
			 }
			trace = "4.6";
			 ////pstmt.setString(3,pract_type);
			 ////pstmt.setString(4,role_id);
			 ////pstmt.setString(5,(String)hash.get("practitioner_id"));
			 pstmt1 = (PreparedStatement) stmt_hash.get("OT_POST_OPER_PERSONNEL_D");
			 pstmt1.setString(1,(String)CommonData.get("facility_id") );
			 pstmt1.setString(2,(String)CommonData.get("accession_num") );
			 pstmt1.setString(3,(String)hash.get("practitioner_id") );
			 trace = "4.7";
			 count = pstmt1.executeUpdate();
			 trace = "4.8";
		 }
		trace = "5.0";
		total++;
		//count = pstmt.executeUpdate();
		if(count>0){
			trace="5.1";
			flag = true;
			//con.commit();
		 }else{
			 trace="5.2";
			flag=false;
			//con.rollback();
		 }
		 trace="5.3";
	 }
	 trace="6.0";
	 if(flag==true  ){
		trace="6.1";
		err_text =callAnaesthesiaUpdateProcedure(tabData,CommonData);
		trace="6.2";
	}
	else{
		trace="6.3";
		err_text =updt_err_text;
	}
	trace="6.4";
}catch(Exception e){
	transaction_err_msg = e.getMessage();
	System.err.println("Intra Anesthesia Manager: 308 in Exception for Execute Process:"+e);
	err_text =transaction_err_msg;
}finally{
	try{
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt2!=null) pstmt2.close();
	}
	catch(Exception e){}
 }
 return err_text;
}


	void closeAllStatement(HashMap hashStatement)
	{
		String key="";
		Set set=hashStatement.keySet();
		Iterator itr=set.iterator();
		PreparedStatement pstmt=null;
		try{
			while(itr.hasNext()){
				 key=(String) itr.next();
				 pstmt=(PreparedStatement)hashStatement.get(key);
				 if(pstmt!=null)
				 pstmt.close();
			 }
			 // Added by bshankar
			 pstmt=(PreparedStatement)hashStatement.get("OT_POST_OPER_PERSONNEL_D");
			 if(pstmt!=null) pstmt.close();

		   }catch(Exception ee){
				System.err.println("Intra Anaesthesia manager  "+ee.getMessage());
		   }

	  }



	public String  callAnaesthesiaUpdateProcedure(ArrayList tab,HashMap commonData){
		CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		HashMap hash = new HashMap();
		String key = "";
		try{

			/*At_Intra_Anae_Status_upd (P_FACILITY_ID  VARCHAR2, P_OPER_NUM           VARCHAR2, P_ANESTHESIA_CODE    VARCHAR2, P_ANAESTHESIA_CMP_YN VARCHAR2,
			 P_USER   VARCHAR2, P_WS_NO	      VARCHAR2,  V_PROC_STATUS        OUT VARCHAR2,
			 V_ERR_MSG            OUT VARCHAR2
			)*/
			for(int i=0;i<tab.size();i++){
			hash=(HashMap) tab.get(i);
			key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
			if(key.equals("AT_ANAESTHESIA_RECORD_HDR_U")){
			cstmt=con.prepareCall("{call At_Intra_Anae_Status_upd(?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,(String)commonData.get("facility_id"));
			cstmt.setString(2,(String)hash.get("accession_num"));
			cstmt.setString(3,(String)hash.get("anaesthesia_code"));
			cstmt.setString(4,(String)hash.get("intraop_done_yn"));
			cstmt.setString(5,(String) commonData.get("login_user"));
			cstmt.setString(6,(String)commonData.get("login_at_ws_no"));
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);
			cstmt.registerOutParameter(9,Types.VARCHAR); // LANG_ERR_MSG_ID
			cstmt.execute();
			status = cstmt.getString(7);
			if(status.equals("E")){
				error_text =cstmt.getString(8);
				error_text =cstmt.getString(9); // LANG_ERR_MSG_ID
			}else if( status.equals("S") ){
				error_text ="RECORD_INSERTED";
			}
			cstmt.close();
			break;
		  }else
			  continue;
		 }//end for For-Loop
	    }catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                if(cstmt!=null) cstmt.close();
				//con.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return error_text;
	}
 }






