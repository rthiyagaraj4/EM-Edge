/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.RecordAnesthesia;

import java.rmi.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.util.*;
import java.sql.*;
import javax.ejb.*;
import javax.ejb.SessionBean.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RecordAnesthesia"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecordAnesthesia"
*	local-jndi-name="RecordAnesthesia"
*	impl-class-name="eOT.RecordAnesthesia.RecordAnesthesiaManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.RecordAnesthesia.RecordAnesthesiaLocal"
*	remote-class="eOT.RecordAnesthesia.RecordAnesthesiaRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.RecordAnesthesia.RecordAnesthesiaLocalHome"
*	remote-class="eOT.RecordAnesthesia.RecordAnesthesiaHome"
*	generate= "local,remote"
*
*
*/

public class RecordAnesthesiaManager implements  SessionBean{
	HashMap stmt_hash = new HashMap();
	Connection con = null;
	String transaction_err_msg="";
	String err_text ="";
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
	public String insert(ArrayList tabData, HashMap sqlMap, HashMap CommonData, Properties prop) 
	{
	try{
			con=ConnectionManager.getConnection(prop);
			//boolean transaction_flag = false; //Commented Against AAKH-ICN-0008
			createStatementCollection(sqlMap);
			err_text = executeTransactions(tabData,CommonData);
			if(err_text.equals("RECORD_INSERTED"))
			   con.commit();
			else
			   con.rollback();
	
		}catch(Exception ee){
		System.err.println("Record Ansaesthesia Manager error in insert method::"+ee);
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
			System.err.println("Record Ansaesthesia Manager Err createStatementCollection(EJB): "+ee);
			closeAllStatement(stmt_hash);
	 }
}

public String executeTransactions(ArrayList tabData,HashMap CommonData){
	System.err.println(" Inside Execute Transactions....... ");
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	HashMap hash=null;
	String key ="";
	int size=0;
	boolean flag = false;
	int count=0;
	String proc_err_text="";
	try{
	 size = tabData.size();
	 int deleted=0;
	 int inserted=0;
	 int total=0;
	// String tempString = "";
	 for(int i=0;i<size;i++){
		 hash=(HashMap) tabData.get(i);
		 key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");
		 String remarks=java.net.URLDecoder.decode((String)hash.get("remarks"),"UTF-8");
		 //String remarks_temp=(String)hash.get("remarks"); //Commented Against AAKH-ICN-0008
		// String temp_test = updateOrderStatus( (String) hash.get("source_order_id") );//Selvin
	if(key.equals("AT_ANAESTHESIA_RECORD_HDR_U")){
			 inserted++;
			 pstmt = (PreparedStatement) stmt_hash.get(key);
		//	tempString= "key ="+key + " 1 ="+hash.get("weight")+ " 2 ="+hash.get("height")+ " 3 ="+hash.get("bsa")+ " 4 ="+hash.get("bmi")+ " 5 ="+hash.get("preop_asse_done_yn")+" 6= "+hash.get("status")+" 7= "+remarks+" 8= "+CommonData.get("login_user")+" 9= "+CommonData.get("login_at_ws_no")+" 10= "+CommonData.get("facility_id")+" 11= "+CommonData.get("facility_id")+" 12= "+CommonData.get("anesthesia_srl_no");
			 pstmt.setString(1,(String)hash.get("weight"));
			 pstmt.setString(2,(String)hash.get("height")); 
			 pstmt.setString(3,(String)hash.get("bsa"));
			 pstmt.setString(4,(String)hash.get("bmi"));
			 pstmt.setString(5,(String)hash.get("preop_asse_done_yn"));
			 if( "Y".equals ((String)hash.get("preop_asse_done_yn") ) ){
				proc_err_text = updateOrderStatus( (String) hash.get("source_order_id") );
			 }
			 pstmt.setString(6,(String)hash.get("status")); 
    		 //pstmt.setString(7,(String)hash.get("remarks"));
    		 pstmt.setString(7,remarks);
			 pstmt.setString(8,(String)CommonData.get("login_user")); 
			 pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
			 pstmt.setString(10,(String)CommonData.get("facility_id"));
			 pstmt.setString(11,(String)CommonData.get("asa_score_code")); 
			 pstmt.setString(12,(String)CommonData.get("facility_id"));
			 pstmt.setString(13,(String)CommonData.get("anesthesia_srl_no"));
		 }
		 else if(key.equals("AT_RECORD_PREOP_PREMORBID_I")){
			 inserted++;
//			 String remarks=java.net.URLDecoder.decode((String)hash.get("remarks"));
		//tempString= "key ="+key + " 1 ="+CommonData.get("facility_id")+ " 2 ="+ CommonData.get("anesthesia_srl_no")+ " 3 ="+hash.get("pre_morbid_code")+ " 4 ="+remarks+ " 5 ="+CommonData.get("login_user")+" 6= "+CommonData.get("login_at_ws_no")+" 7= "+CommonData.get("facility_id")+" 8= "+CommonData.get("login_user")+" 9= "+CommonData.get("login_at_ws_no")+" 10= "+CommonData.get("facility_id");
			 pstmt = (PreparedStatement) stmt_hash.get(key);
			 pstmt.setString(1,(String)CommonData.get("facility_id"));
			 pstmt.setString(2,(String)CommonData.get("anesthesia_srl_no"));
			 pstmt.setString(3,(String)hash.get("pre_morbid_code"));
			 //pstmt.setString(4,(String)hash.get("remarks"));
			 pstmt.setString(4,remarks);
			 pstmt.setString(5,(String)CommonData.get("login_user")); 
			 pstmt.setString(6,(String)CommonData.get("login_at_ws_no"));
			 pstmt.setString(7,(String)CommonData.get("facility_id"));
			 pstmt.setString(8,(String)CommonData.get("login_user")); 
			 pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
			 pstmt.setString(10,(String)CommonData.get("facility_id"));
		 }else if(key.equals("AT_RECORD_PREOP_PREMORBID_D")) {
			 deleted++;
			//tempString= "key ="+key + " 1 ="+CommonData.get("facility_id")+ " 2 ="+ CommonData.get("anesthesia_srl_no")+ " 3 ="+hash.get("pre_morbid_code");
			 pstmt = (PreparedStatement) stmt_hash.get(key);
			 pstmt.setString(1,(String)CommonData.get("facility_id"));
			 pstmt.setString(2,(String) CommonData.get("anesthesia_srl_no"));
			 pstmt.setString(3,(String)hash.get("pre_morbid_code"));
		 }
			total++;
		count = pstmt.executeUpdate(); 
	//Selvin on 2/22/2013 added crf -0021
 		  if(key.equals("AT_ANAESTHESIA_RECORD_HDR_U"))
				{	
try {		
			int count1 = 0; //Added Against Commented Against AAKH-ICN-0008
			String asa_code=(String)CommonData.get("asa_score_code");
			String ord_id =(String)hash.get("source_order_id");
			String facity_id=(String) CommonData.get("facility_id");
			String sql_update = "UPDATE OT_QUEUE SET  ASA_SCORE_CODE = '"+asa_code+"'  WHERE ORDER_ID = '"+ord_id+"'  AND OPERATING_FACILITY_ID = '"+facity_id+"'";
				 pstmt1=con.prepareStatement(sql_update);
					 count1 = pstmt1.executeUpdate(); 
					//count= count1;
					if(pstmt1 !=null) pstmt1.close(); //Common-ICN-0053
	}
catch(Exception eee){
eee.printStackTrace();
System.err.println("Exception eee"+eee.toString());
}	
				}  
		//Added End  crf -0021
		 if(count>0){
			flag = true; 
		  }	
		 else{
				flag=false;
		 }
	 }
	 if(flag==true && ("RECORD_INSERTED".equals(proc_err_text) || "".equals(proc_err_text)) ){
			err_text ="RECORD_INSERTED";
	}
	else{
			err_text ="RECORD INSERTION FAILS";
	}

}catch(Exception e){
	transaction_err_msg = e.getMessage();
	e.printStackTrace();		
	System.err.println("Record Ansaesthesia Manager Err Msg in Execute Process "+e.getMessage());
	err_text =transaction_err_msg;
}finally{
	try{
		pstmt.close();
		pstmt1.close(); //Added Against AAKH-ICN-0008
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
		   }catch(Exception ee){
				System.err.println("Record Anaesthesia Manager "+ee.getMessage());
		   }
	  }

	  public String  updateOrderStatus(String source_order_id){
		CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		/* HashMap hash = new HashMap(); 
		String key = "";  */ //Commented Against AAKH-ICN-0008
		String langerr_msg_text = "";
		try{
			
			cstmt=con.prepareCall("{call AT_UPD_OR_ORDER_STATUS(?,?,?,?)}");
			cstmt.setString(1,source_order_id);
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.VARCHAR);	
			cstmt.registerOutParameter(4,Types.VARCHAR);	
			cstmt.execute();
			status = cstmt.getString(2);
			langerr_msg_text = cstmt.getString(4);
			if(status.equals("E")){
				//error_text =cstmt.getString(3);
				error_text = langerr_msg_text;
			}else if( status.equals("S") ){
				error_text ="RECORD_INSERTED";
			}
			cstmt.close();
			
		  
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
