/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.RecordSurgeon;
//import eOT.Common.ConnectionDispenser; //Commented on 02/07/13
import webbeans.eCommon.*;//Changed on 03/07/13 against UAT5 - Connection Issue
import java.util.* ;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import webbeans.eCommon.ConnectionManager;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.Reader;
//import java.sql.*;
import eOT.Common.BillingManager;
import eOT.Common.BillingUtil;
//import oracle.sql.*;
//MO-CRF-20147.13 Starts
//import java.util.* ;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import oracle.sql.CLOB;
//import java.sql.* ;
import java.io.* ;
//MO-CRF-20147.13 Ends
/**
*
* @ejb.bean
*	name="RecordSurgeon"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecordSurgeon"
*	local-jndi-name="RecordSurgeon"
*	impl-class-name="eOT.RecordSurgeon.RecordSurgeonManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.RecordSurgeon.RecordSurgeonLocal"
*	remote-class="eOT.RecordSurgeon.RecordSurgeonRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.RecordSurgeon.RecordSurgeonLocalHome"
*	remote-class="eOT.RecordSurgeon.RecordSurgeonHome"
*	generate= "local,remote"
*
*
*/
public class RecordSurgeonManager implements SessionBean {

	//Properties  prop	= null;
	HashMap stmt_hash = new HashMap();
	String transaction_err_text = "";
	HashMap<String,List> bill_map = new HashMap<String,List>();
	String order_id = "";
			//int result = 0;


	//public void ejbCreate() throws  CreateException {}
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
	 *@param prop Connection Properties
	 *@return String holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public String insert(ArrayList tabData, HashMap sqlMap, HashMap CommonData, Properties prop) {
	  	Connection connection = null;
		//PMG2017-SS-CRF-0001-US001
		PreparedStatement pstmt = null;
		ResultSet rst;
		//PMG2017-SS-CRF-0001-US001
		String err_text = "";
		String bill_final_err_mesg="";
		String surgeon_doc_comp_yn=( String ) CommonData.get( "surgeon_doc_comp_yn" );
		String oper_proc_comp=( String ) CommonData.get("oper_proc_comp" ); 
		String trfr_to_ot_flag=( String ) CommonData.get( "trfr_to_ot_flag" );
		String facility_id = (String) CommonData.get("facility_id");
		//String doc_leveltype = (String) CommonData.get("doc_level"); //Commented Against AAKH-ICN-0008
		String executeTransactions_success_YN = "N"; 
		ArrayList result_array = new ArrayList();
		//commented by sathish on 24/12/2008
		String build_history_yn = ( surgeon_doc_comp_yn.equals("Y") )?"YES":"NO";
		//PMG2017-SS-CRF-0001-US001
		String anaesthesia_code = checkForNull((String) CommonData.get("anaesthesia_code"));
		String anaes_srl_no1 ="";
		//PMG2017-SS-CRF-0001-US001
		try{
			 //connection = ConnectionDispenser.getConnection();//Changed on 03/07/13 against UAT5 - Connection Issue 
			 connection=ConnectionManager.getConnection(prop);//Changed on 03/07/13 against UAT5 - Connection Issue
			 createStatementCollection(connection,sqlMap,tabData);
			result_array = (ArrayList)executeTransactions(connection,tabData,CommonData);
			 executeTransactions_success_YN = (String)result_array.get(0);

			// if(!executeTransactions(connection,tabData,CommonData)) return transaction_err_text;
			
			 //calling Billing Procedure
			 boolean billing_installed_yn = isBillingInstalled(facility_id,connection);//Connection Issue
			  /* Newly added below condition by Sathish.K on 13-03-2009 for TransferTOOT Cases... 
			 to uncheck Billing after TransferTOOT from Recovery Room.*/
			 if(("Y").equals(trfr_to_ot_flag))
			 {
				 billing_installed_yn=false;
			 }
			 if( billing_installed_yn==true ){
	bill_final_err_mesg=checkForNull(callBillingProcedure(CommonData,bill_map,tabData,billing_installed_yn,connection));//Connection Issue Modified Against ML-MMOH-CRF-1939-US4
System.err.println("138 bill_final_err_mesg in insert after callBillingProcedure  = "+bill_final_err_mesg);

			 if( "RECORD_INSERTED".equals(bill_final_err_mesg) ) {
					connection.commit();
			 }else{
					 connection.rollback();

			}
			 }
			 if( build_history_yn.equals("YES")) {
				if(!buildHistory(CommonData,connection))  return "Opertation failed in history builiding";
					String surg_avg_time_txt = callSurgeonAvgTime(CommonData,connection) ;//Connection Issue
					if(!surg_avg_time_txt.equals("RECORD_INSERTED") ) return surg_avg_time_txt;
			 }
			 PreparedStatement pstmt1 = null;
			int j=0;
			String pros_implants_complete_flag=checkForNull(( String ) CommonData.get( "pros_implants_complete_flag" )); 
		
			String oper_no=				( String )CommonData.get( "oper_num" );

		//PMG2017-SS-CRF-0001-US002 & US003
		String SQL_ANES_SURG_CHK = "SELECT anaesthesia_serial_num FROM at_anaesthesia_record_hdr WHERE SOURCE_ORDER_ID = ? AND operating_facility_id = ?";

			pstmt=connection.prepareStatement(SQL_ANES_SURG_CHK);
			pstmt.setString(1,(String) CommonData.get("order_id"));
			pstmt.setString(2,(String) CommonData.get("facility_id"));
			rst=pstmt.executeQuery();
			if(rst.next()){
			anaes_srl_no1 = rst.getString(1);
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

		if(!anaes_srl_no1.equals("")){
		String sql_update_anes="UPDATE at_anaesthesia_record_hdr SET ANAESTHESIA_CODE=? WHERE operating_facility_id = ? AND SOURCE_ORDER_ID = ?";		
			pstmt1 = connection.prepareStatement(sql_update_anes);	
			pstmt1.setString(1,anaesthesia_code);
			pstmt1.setString(2,(String) CommonData.get("facility_id"));
			pstmt1.setString(3,(String) CommonData.get("order_id"));
			j=pstmt1.executeUpdate();			
			if(pstmt1 !=null) pstmt1.close();
		}
	
		String sql_update="UPDATE ot_post_oper_hdr SET IMPLANT_ENTRY_CMP_YN='"+pros_implants_complete_flag+"' ,PROC_CHRG_CMP_YN='"+oper_proc_comp+"',ANESTHESIA_CODE='"+anaesthesia_code+"'  WHERE operating_facility_id = '"+facility_id+"' AND oper_num  ='"+oper_no+"'";
		pstmt1 = connection.prepareStatement(sql_update);
		j=pstmt1.executeUpdate();
		
		if(pstmt1 !=null) pstmt1.close();
		//PMG2017-SS-CRF-0001-US002 & US003
		
		if(bill_final_err_mesg.equals("RECORD_INSERTED") || bill_final_err_mesg.equals(""))
		{
		 err_text=checkForNull(updateDocumentationLevel(CommonData,connection));//Connection Issue Modified Against ML-MMOH-CRF-1939-US4
		 
		 
System.err.println(" 193 executeTransactions_success_YN = "+executeTransactions_success_YN);
System.err.println(" 194 erron text before commit returns from updateDocumentationLevel = "+err_text);
		if(err_text.equals("RECORD_INSERTED") ) {

			if(executeTransactions_success_YN.equals("Y")) 
		{
			tabData = (ArrayList)result_array.get(1);
			connection.commit();
		}

			connection.commit();
		}else{
			connection.rollback();
		}
		}else
		{
			err_text=bill_final_err_mesg;
			connection.rollback();
		}
	 }catch(Exception ee){
	 ee.printStackTrace();}
	   finally{
		  try{
			closeAllStatement(stmt_hash);
			if(connection!=null)
			ConnectionManager.returnConnection(connection,prop);//Changed on 02/07/13 against UAT5 - Connection Issue
			//connection.close();		
			//ConnectionDispenser.remove();//Connection Issue
		}catch(Exception e){
		e.printStackTrace();
		}
    }
	//System.err.println("REC_SURG_MAN: Line 182--> "+err_text);
	return err_text;
 }



 


public void createStatementCollection(Connection connection,HashMap sqlMap,ArrayList tabData){
	Set set=sqlMap.keySet();
	Iterator itr=set.iterator();
	PreparedStatement pstmt=null;
	 //String sql_update= "";	//Commented Against AAKH-ICN-0008
	String key="";
	try{
		   while(itr.hasNext()){
			  key=(String) itr.next();
			 if(key.equals("OT_POST_OPER_DTLS_L")){
				// Ignore This Key
			 }else{ // below if condition in Repository OT_POST_OPER_DTLS_D key related query oper_line_status column is there which is not there in related table after completion of Oper_line_status relatedCrf pls remove this conditon
				 if(!("OT_POST_OPER_DTLS_U").equals(key)) 
				 {
				  pstmt=connection.prepareStatement((String) sqlMap.get(key));
				stmt_hash.put(key,pstmt);

			     } else if(("OT_POST_OPER_DTLS_U").equals(key)){
		         	
		//	HashMap hash=null;
		//	String chk_oper_status="";
		//	int size = tabData.size();
		//	for(int i=0;i<size;i++){
			// hash=(HashMap)tabData.get(i);
			/* if(hash!=null){
				chk_oper_status= (String)hash.get("oper_line_status");
	         
				 if(!chk_oper_status.equals("99"))
				 {
				sql_update="UPDATE OT_POST_OPER_DTLS SET RIGHT_LEFT_FLAG=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,OPER_LINE_STATUS=?,OPER_REMARKS=? WHERE OPER_LINE_NUM=? AND OPER_CODE=? AND OPER_NUM = ? AND OPERATING_FACILITY_ID=?";
				 }else
				 {
					 sql_update="UPDATE OT_POST_OPER_DTLS SET RIGHT_LEFT_FLAG=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,OPER_LINE_STATUS=?,CANCEL_REMARKS=?,CANCELLED_BY_ID=?,CANCELLED_DATE=SYSDATE WHERE OPER_LINE_NUM=? AND OPER_CODE=? AND OPER_NUM = ? AND OPERATING_FACILITY_ID=?";
				 } 
			 }*/
				
				//pstmt=connection.prepareStatement(sql_update);
				stmt_hash.put(key,pstmt);
	//	}
			
				 }
				  //StatementFactory.setDefaultDebug(DebugLevel.VERBOSE);
				  //pstmt = StatementFactory.getStatement(connection,(String) sqlMap.get(key));
				  
			 }
		  }
		  				

	 }catch(Exception ee){
			System.err.println("REC_SURG_MAN: Err createStatementCollection(EJB): "+ee);
			closeAllStatement(stmt_hash);

	 }

}

public ArrayList executeTransactions(Connection connection,ArrayList tabData,HashMap CommonData){
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	//PreparedStatement pstmt_del = null;	//Commented Against AAKH-ICN-0008
	PreparedStatement pstmt_chk = null;
	HashMap hash=null;
	ResultSet rst											=	null;
	//ResultSet rst1											=	null; //Commented Against AAKH-ICN-0008
	String key ="";
	String proc_text="";
	String order_id = checkForNull( (String) CommonData.get("order_id") ).intern();
	String order_line_text[] =new String[4];
	String dummy_line_text[] =new String[]{"","","S",""};
	String oper_code = "";
	String panel_str = "";
	String bill_str = "";
	//String bill_param[] = new String[]{"",""};
	boolean flag = false;
	ArrayList result_array = new ArrayList(); 
	int size = tabData.size();
	String trace="0.0";
	String sql_update="";
	String success_flag_yn = "N";
	String key_line="";
	//boolean flag_chk = true;
	String surgeon_doc_comp_yn= (String)CommonData.get("surgeon_doc_comp_yn");
	String update_notes = (String)CommonData.get("update_notes"); ////Added against PMG2023-MMS-CRF-0002
	try{
		 //System.err.println("tabData  "+tabData);

		 for(int i=0;i<size;i++){
		 trace="1.0";
		 boolean flag_chk = true;
		 hash=(HashMap)tabData.get(i);
		 if(hash!=null){
		 key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");

		 /*System.err.println("key  "+key);
		 System.err.println("table_name  "+(String) hash.get("table_name"));
		 System.err.println("db_mode  "+(String) hash.get("db_mode"));
		 System.err.println("hash  "+hash);*/
		String chk_oper_status=""; 
	
			pstmt = (PreparedStatement) stmt_hash.get(key);
		 proc_text="";

		 /*
		String SQL_ANES_SRL_NO = "SELECT anaesthesia_serial_num FROM at_anaesthesia_record_hdr WHERE SOURCE_ORDER_ID = ?";
		exdecute

			get the anaesthesia_serial_num
*/
		oper_code = (String)hash.get("oper_code");
		if(oper_code!= null && !oper_code.equals("")) {
			panel_str = checkForNull((String)hash.get("panel_str"));
			bill_str = checkForNull((String)hash.get("bill_str"));
			if(!panel_str.equals(null) && !panel_str.equals("")){
				//bill_map.put(oper_code,java.net.URLDecoder.decode(panel_str,"UTF-8"));
				List<String> list = new ArrayList<String>();
				list.add(java.net.URLDecoder.decode(panel_str,"UTF-8"));
				list.add(bill_str);
				bill_map.put(oper_code,list);
			}
		}


if(key.equals("OT_POST_OPER_DTL2_WOU_I") || key.equals("VISIT_PERSONNEL_I")||key.equals("OT_POST_OPER_DTL2_I") )
			 {
		key="OT_POST_OPER_DTL2_I";
			 }
		 if(key.equals("OT_POST_OPER_DTLS_I")){
trace="2.0";
//System.err.println("@@@@@@@@@@@@@@@@@OT_POST_OPER_DTLS_I@@@@@@@@@@@@@@@@@@@");
			String new_remarks=(String)hash.get("oper_remarks");
			//new_remarks= java.net.URLEncoder.encode( new_remarks,"UTF-8" );
			new_remarks=java.net.URLDecoder.decode(new_remarks,"UTF-8");


			order_line_text = (order_id!="")?callOROrderLineUpdate(CommonData,hash,"I",connection):dummy_line_text;
			   /* for(int k=0;k<order_line_text. length;k++)*/
				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_line_num"));
				pstmt.setString(4,(String)hash.get("oper_code"));
				pstmt.setString(5,(String)hash.get("right_left_flag"));
				pstmt.setString(6,new_remarks);
				pstmt.setString(7,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(8,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(9,(String)CommonData.get("facility_id"));
				pstmt.setString(10,(String)CommonData.get("login_user")); //changes if invoked from Slate
				pstmt.setString(11,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(12,(String)CommonData.get("facility_id"));
				pstmt.setString(13,(String)CommonData.get("order_id"));
				pstmt.setString(14,order_line_text[0]);
				pstmt.setString(15,order_line_text[1]);
				pstmt.setString(16,checkForNull((String)hash.get("fpp_category")));
				proc_text =(order_line_text[2].equals("E"))?order_line_text[3]:"SUCCESS";
				trace="2.1";

		}else if(key.equals("OT_POST_OPER_DTLS_U")){
			trace="3.0";
			chk_oper_status=(String)hash.get("oper_line_status");
			if(!chk_oper_status.equals("99"))
			{
				sql_update="UPDATE OT_POST_OPER_DTLS SET RIGHT_LEFT_FLAG=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,OPER_LINE_STATUS=?,OPER_REMARKS=?,FPP_CATEGORY=? WHERE OPER_LINE_NUM=? AND OPER_CODE=? AND OPER_NUM = ? AND OPERATING_FACILITY_ID=?";

				pstmt=connection.prepareStatement(sql_update);

			String new_remarks=(String)hash.get("oper_remarks");
			//new_remarks= java.net.URLEncoder.encode( new_remarks,"UTF-8" );
			new_remarks=java.net.URLDecoder.decode(new_remarks,"UTF-8");
			pstmt.setString(1,(String)hash.get("right_left_flag"));
			pstmt.setString(2,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(3,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(4,(String)CommonData.get("facility_id"));
			pstmt.setString(5,(String)hash.get("oper_line_status"));
			pstmt.setString(6,new_remarks);
			pstmt.setString(7,checkForNull((String)hash.get("fpp_category")));
			pstmt.setString(8,(String)hash.get("oper_line_num"));
			pstmt.setString(9,(String)hash.get("oper_code"));
			pstmt.setString(10,(String)hash.get("oper_num"));
			pstmt.setString(11,(String)CommonData.get("facility_id"));



			
			//new_remarks=java.net.URLDecoder.decode(new_remarks);
		
			}else
			{
				sql_update="UPDATE OT_POST_OPER_DTLS SET RIGHT_LEFT_FLAG=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,OPER_LINE_STATUS=?,CANCEL_REMARKS=?,CANCELLED_BY_ID=?,FPP_CATEGORY=?,CANCELLED_DATE=SYSDATE WHERE OPER_LINE_NUM=? AND OPER_CODE=? AND OPER_NUM = ? AND OPERATING_FACILITY_ID=?";
				pstmt=connection.prepareStatement(sql_update);
				String cancel_remarks=(String)hash.get("cancel_remarks");
				cancel_remarks=java.net.URLDecoder.decode(cancel_remarks,"UTF-8");

			pstmt.setString(1,(String)hash.get("right_left_flag"));
			pstmt.setString(2,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(3,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(4,(String)CommonData.get("facility_id"));
			pstmt.setString(5,chk_oper_status);
			pstmt.setString(6,cancel_remarks);
			pstmt.setString(7,(String)CommonData.get("login_user"));
			pstmt.setString(8,checkForNull((String)hash.get("fpp_category")));
			pstmt.setString(9,(String)hash.get("oper_line_num"));
			pstmt.setString(10,(String)hash.get("oper_code"));
			pstmt.setString(11,(String)hash.get("oper_num"));
			pstmt.setString(12,(String)CommonData.get("facility_id"));

		
			}
			
/**/
trace="3.1";

			/*bill_param[0] = java.net.URLDecoder.decode((String) hash.get("panel_str"));
			bill_param[1] = (String) hash.get("bill_str");
			bill_map.put((String)hash.get("oper_code"),bill_param);*/
			//// bshankar bill_map.put(hash.get("oper_code"),java.net.URLDecoder.decode((String) hash.get("panel_str")));
		}/*else if(key.equals("OT_POST_OPER_DTLS_D")) {
trace="4.0";
			order_line_text =(order_id!="")?callOROrderLineUpdate(CommonData,hash,"D"):dummy_line_text;
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,"");//for testing (String)hash.get("oper_num"));
			pstmt.setString(3,"");//for testing (String)hash.get("oper_line_num"));  Commented this block on19-03-2009 due to Oper_line_status(old query using presenetly
			pstmt.setString(4,(String)hash.get("oper_code"));

		//	pstmt.setString(1,(String)hash.get("oper_line_status"));
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String)hash.get("oper_num"));//for testing (String)hash.get("oper_num"));
			pstmt.setString(3,(String)hash.get("oper_line_num"));//for testing (String)hash.get("oper_line_num"));  Commented this block on19-03-2009 due to Oper_line_status(old query using presenetly
			pstmt.setString(4,(String)hash.get("oper_code"));

			proc_text =(order_line_text[2].equals("E"))?order_line_text[3]:"SUCCESS";
			//// bshankar bill_map.put(hash.get("oper_code"),java.net.URLDecoder.decode((String) hash.get("panel_str")));
			//billing logic to be added here for deletion we need to pass reverse entry
trace="4.1";

		}*/else if(key.equals("OT_POST_OPER_PERSONNEL_I")){
trace="5.0";


			/*INSERT INTO OT_POST_OPER_PERSONNEL(OPERATING_FACILITY_ID,OPER_NUM,SPECIALITY_CODE,
			PRACTITIONER_ID,ROLE_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ROLE_TYPE) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)")*/
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
			pstmt.setString(4,(String)hash.get("practitioner_id"));
			pstmt.setString(5,(String)hash.get("role_id"));
			pstmt.setString(6,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(7,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(8,(String)CommonData.get("facility_id"));
			pstmt.setString(9,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(10,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(11,(String)CommonData.get("facility_id"));
			pstmt.setString(12,(String)hash.get("role_type"));
trace="5.1";


		}else if(key.equals("OT_POST_OPER_PERSONNEL_D")){
trace="6.0";
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
			pstmt.setString(4,(String)hash.get("practitioner_id"));
			pstmt.setString(5,(String)hash.get("role_id"));
trace="6.1";
		}else if(key.equals("OT_POST_OPER_DTL2_WOU_I")){
trace="7.0";
			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("speciality_code"));
			pstmt.setString(4,(String) hash.get("wound_code"));
			pstmt.setString(5,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(6,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(7,(String)CommonData.get("facility_id"));
			pstmt.setString(8,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(10,(String)CommonData.get("facility_id"));
trace="7.1";
	}else if(key.equals("OT_POST_OPER_DTL2_WOU_U")){
trace="8.0";
		/*UPDATE OT_POST_OPER_DTL2 SET WOUND_TYPE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND SPECIALITY_CODE=?*/
			pstmt.setString(1,(String)hash.get("wound_code"));
			pstmt.setString(2,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(3,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(4,(String)CommonData.get("facility_id"));
			//where condition
			pstmt.setString(5,(String)CommonData.get("facility_id"));
			pstmt.setString(6,(String)hash.get("oper_num"));
			pstmt.setString(7,(String) hash.get("speciality_code"));
trace="8.1";
	}else if(key.equals("VISIT_PERSONNEL_I")){
trace="9.0";


String remarks=(String) hash.get("visit_desc");
String visit_desc="";
visit_desc=java.net.URLDecoder.decode(remarks,"UTF-8");
		pstmt.setString(1,(String) CommonData.get("facility_id"));
		pstmt.setString(2,(String) hash.get("oper_num"));
		pstmt.setString(3,(String) hash.get("speciality_code"));
		pstmt.setString(4,visit_desc);
		//auditing fields
		pstmt.setString(5,(String)CommonData.get("login_user"));
		pstmt.setString(6,(String)CommonData.get("login_at_ws_no"));
		pstmt.setString(7,(String)CommonData.get("facility_id"));
		pstmt.setString(8,(String)CommonData.get("login_user"));
		pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
		pstmt.setString(10,(String)CommonData.get("facility_id"));
		pstmt.setString(11,(String)hash.get("wound_code"));
trace="9.1";

	}else if(key.equals("VISIT_PERSONNEL_U")){
trace="10.0";
String remarks=(String) hash.get("visit_desc");
String visit_desc="";
visit_desc=java.net.URLDecoder.decode(remarks,"UTF-8");

		pstmt.setString(1,visit_desc);
		pstmt.setString(2,(String)CommonData.get("login_user"));
		pstmt.setString(3,(String)CommonData.get("login_at_ws_no"));
		pstmt.setString(4,(String)CommonData.get("facility_id"));
		//where condition
		pstmt.setString(5,(String)CommonData.get("facility_id"));
		pstmt.setString(6,(String) hash.get("oper_num"));
		pstmt.setString(7,(String) hash.get("speciality_code"));
trace="10.1";
	}else if(key.equals("OT_POST_OPER_DTL2_I")){
trace="11.0";

String remarks=(String) hash.get("visit_desc");
if(remarks==null) remarks="";



String visit_desc="";
if(!remarks.equals(""))
		{
visit_desc=java.net.URLDecoder.decode(remarks,"UTF-8");

		}

	String preparation_time=(String)hash.get("preparation_time");
	if(preparation_time==null) preparation_time="";

	if(preparation_time.equals(""))
	{
		preparation_time=preparation_time.trim();
	}

	

	String procedure_start_time=	(String)hash.get("procedure_start_time");
	if(procedure_start_time==null) procedure_start_time="";
	if(procedure_start_time.equals(""))
	{
		procedure_start_time=procedure_start_time.trim();
	}


	String procedure_end_time=	(String)hash.get("procedure_end_time");
	if(procedure_end_time==null) procedure_end_time="";
	if(procedure_end_time.equals(""))
	{
		procedure_end_time=procedure_end_time.trim();
	}


	String anaesthesia_start_time=	(String)hash.get("anaesthesia_start_time");
	if(anaesthesia_start_time==null) anaesthesia_start_time="";
	if(anaesthesia_start_time.equals(""))
	{
		anaesthesia_start_time=anaesthesia_start_time.trim();
	}

	String anaesthesia_end_time=	(String)hash.get("anaesthesia_end_time");
		if(anaesthesia_end_time==null) anaesthesia_end_time="";
	if(anaesthesia_end_time.equals(""))
	{
		anaesthesia_end_time=anaesthesia_end_time.trim();
	}

	String surgery_start_time=	(String)hash.get("surgery_start_time");
		if(surgery_start_time==null) surgery_start_time="";

	if(surgery_start_time.equals(""))
	{
		surgery_start_time=surgery_start_time.trim();
	}

	String surgery_end_time=	(String)hash.get("surgery_end_time");
		if(surgery_end_time==null) surgery_end_time="";

	if(surgery_end_time.equals(""))
	{
		surgery_end_time=surgery_end_time.trim();
	}

	//Added by Arthi for ML-MMOH-CRF-1936
	String prep_start_time=	(String)hash.get("prep_start_time");
		if(prep_start_time==null) prep_start_time="";

	if(prep_start_time.equals(""))
	{
		prep_start_time=prep_start_time.trim();
	}

	String prep_end_time=	(String)hash.get("prep_end_time");
		if(prep_end_time==null) prep_end_time="";

	if(prep_end_time.equals(""))
	{
		prep_end_time=prep_end_time.trim();
	}
	
	System.err.println("prep_start_time in manager :"+prep_start_time);
	System.err.println("prep_end_time in manager :"+prep_end_time);
	System.err.println("anaesthesia_start_time in manager :"+anaesthesia_start_time);
	System.err.println("anaesthesia_end_time in manager :"+anaesthesia_end_time);
	//End ML-MMOH-CRF-1936




int count_chk=0;

String sql_chk="select count(*) from OT_POST_OPER_DTL2 where OPERATING_FACILITY_ID='"+(String)CommonData.get("facility_id")+"'and OPER_NUM='"+(String) hash.get("oper_num")+"' and SPECIALITY_CODE='"+(String) hash.get("speciality_code")+"'";

pstmt_chk=connection.prepareStatement(sql_chk);
rst=pstmt_chk.executeQuery();

	if(rst !=null && rst.next())
	{
		count_chk=rst.getInt(1);
	}
	if(count_chk <=0)
		{
		String sql_new="INSERT INTO OT_POST_OPER_DTL2 (OPERATING_FACILITY_ID,OPER_NUM,SPECIALITY_CODE,PREPARATION_TIME,ANEST_PROC_START_TIME,ANEST_PROC_END_TIME,ANEST_START_TIME,ANEST_END_TIME,SURG_START_TIME,SURG_END_TIME, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VISITING_PERSONNEL,WOUND_TYPE,PREP_START_TIME,PREP_END_TIME) VALUES ('"+(String)CommonData.get("facility_id")+"','"+(String) hash.get("oper_num")+"','"+(String) hash.get("speciality_code")+"',TO_DATE('"+preparation_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+procedure_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+procedure_end_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+anaesthesia_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+anaesthesia_end_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+surgery_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+surgery_end_time+"','DD/MM/YYYY HH24:MI'),'"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+(String)CommonData.get("login_user")+"',SYSDATE,'"+(String)CommonData.get("login_at_ws_no")+"','"+(String)CommonData.get("facility_id")+"','"+visit_desc+"','"+(String)hash.get("wound_code")+"',TO_DATE('"+prep_start_time+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+prep_end_time+"','DD/MM/YYYY HH24:MI'))";//Modified Against ML-MMOH-CRF-1936



		pstmt=connection.prepareStatement(sql_new);
		//System.err.println("sql_new  "+sql_new);

	}else
	{
		flag_chk = false;
	}

	/*	pstmt.setString(1,(String)CommonData.get("facility_id"));
		pstmt.setString(2,(String) hash.get("oper_num"));
		pstmt.setString(3,(String) hash.get("speciality_code"));
		pstmt.setString(4,preparation_time);
		pstmt.setString(5,procedure_start_time);
		pstmt.setString(6,procedure_end_time);
		pstmt.setString(7,anaesthesia_start_time);
		pstmt.setString(8,anaesthesia_end_time);
		pstmt.setString(9,surgery_start_time);
		pstmt.setString(10,surgery_end_time);
		pstmt.setString(11,(String)CommonData.get("login_user"));
		pstmt.setString(12,(String)CommonData.get("login_at_ws_no"));
		pstmt.setString(13,(String)CommonData.get("facility_id"));
		pstmt.setString(14,(String)CommonData.get("login_user"));
		pstmt.setString(15,(String)CommonData.get("login_at_ws_no"));
		pstmt.setString(16,(String)CommonData.get("facility_id"));
		pstmt.setString(17,visit_desc);
		pstmt.setString(18,(String)hash.get("wound_code"));*/

		//System.err.println("count_chk  "+count_chk);
		//System.err.println("flag_chk  "+flag_chk);

	}else if(key.equals("OT_POST_OPER_DTL2_U")){

trace="12.0";

		pstmt.setString(1,((String) hash.get("preparation_time")).trim());
		pstmt.setString(2,((String)hash.get("procedure_start_time")).trim());
		pstmt.setString(3,((String)hash.get("procedure_end_time")).trim());
		pstmt.setString(4,((String)hash.get("anaesthesia_start_time")).trim());
		pstmt.setString(5,((String)hash.get("anaesthesia_end_time")).trim());
		pstmt.setString(6,((String)hash.get("surgery_start_time")).trim());
		pstmt.setString(7,((String)hash.get("surgery_end_time")).trim());
		pstmt.setString(8,(String)CommonData.get("login_user"));
		pstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
		pstmt.setString(10,(String)CommonData.get("facility_id"));
		pstmt.setString(11,((String)hash.get("prep_start_time")).trim());//Added by Arthi for ML-MMOH-CRF-1936
		pstmt.setString(12,((String)hash.get("prep_end_time")).trim());//Added by Arthi for ML-MMOH-CRF-1936
	//where condition
		pstmt.setString(13,(String)CommonData.get("facility_id"));
		pstmt.setString(14,(String) hash.get("oper_num"));
		pstmt.setString(15,(String) hash.get("speciality_code"));
	}else if(key.equals("OT_POST_OPER_DTL2_D")){
trace="13.0";
		pstmt.setString(1,(String)CommonData.get("facility_id"));
		pstmt.setString(2,(String) hash.get("oper_num"));
		pstmt.setString(3,(String) hash.get("speciality_code"));
	}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_I")){
trace="14.0";

		//System.err.println("key: "+key);

String excl_incl_ind="";
String action_reason_code="";
String st_interface_flag=( String ) CommonData.get( "st_interface_flag" );

			 bill_str=(String) hash.get("bill_str");
			if(bill_str==null) bill_str="";
			if(!bill_str.equals("") )
		{
			String[] charge_arr=null;
			charge_arr=bill_str.split("::");
			if(charge_arr.length==6)
			 {
				 excl_incl_ind=charge_arr[5];
			 }
   			 if(charge_arr.length==9)
		     {
		         action_reason_code=charge_arr[8];  
			 }
		}
			if(("null").equals(excl_incl_ind))
			{
				excl_incl_ind="";
			}
			if(("null").equals(action_reason_code))
			{
				action_reason_code="";
			}




			key_line = getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type"),connection );
			hash.put("key_line",key_line);
			hash.put("nursing_doc",surgeon_doc_comp_yn);



			/* String reserved_qty =(String)hash.get("reserved_qty");
			String quantity =(String)hash.get("quantity");
			String requested_qty =(String)hash.get("requested_qty");
			String req_store_code =(String)hash.get("req_store_code");
			String sale_document_no =(String)hash.get("sale_document_no");
			String sale_document_type =(String)hash.get("sale_document_type"); */ //Commented Against AAKH-ICN-0008
			String manufacturer=(String)hash.get("manufacturer");
			String batch=(String)hash.get("batch");



				pstmt.setString(1,(String)CommonData.get("facility_id"));
				pstmt.setString(2,(String) hash.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String)hash.get("implant_code"));
				pstmt.setString(6,(String)hash.get("accessory_type"));
				pstmt.setString(7,(String)hash.get("quantity"));
				pstmt.setString(8,manufacturer);
				pstmt.setString(9,batch);
				//pstmt.setString(10,(String)hash.get("remarks"));
				String remarksVal = ((String)hash.get("remarks"));
				if(!remarksVal.equals(""))
				{
					remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
				}
				pstmt.setString(10,remarksVal);



				//St values
			pstmt.setString(11,(String)hash.get("req_store_code"));
			pstmt.setString(12,(String)hash.get("reserved_qty"));
			pstmt.setString(13,(String)hash.get("requested_qty"));
			pstmt.setString(14,(String)hash.get("sale_document_type"));
			pstmt.setString(15,(String)hash.get("sale_document_no"));


	
	
			//auditing fields
			pstmt.setString(16,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(17,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(18,(String)CommonData.get("facility_id"));
			pstmt.setString(19,(String)CommonData.get("login_user")); //changes if invoked from Slate
			pstmt.setString(20,(String)CommonData.get("login_at_ws_no"));
			pstmt.setString(21,(String)CommonData.get("facility_id"));

		
	/*Added by Suma for bill changes on 26 feb 2010*/

		String st_bill_value=(String)hash.get("sale_document_type")+"-"+(String)hash.get("sale_document_no");



		if(st_interface_flag.equals("Y"))
		{
	pstmt.setString(22,st_bill_value);
		}else
		{
	pstmt.setString(22,"I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
		}

	/*ends here*/
	/*Added by Suma for bill changes on 05/03/2010*/
		
if(st_interface_flag.equals("Y"))
		{
		pstmt.setString(23,"1");
		}else
		{
		pstmt.setString(23,key_line);
		}
/*Added by Suma ends here*/


			pstmt.setString(24,excl_incl_ind);
			pstmt.setString(25,action_reason_code);


		}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_U")){
trace="15.0";
			//ACCESSORY_CODE=?,QUANTITY=?,PROSTHESIS_MFR,PROSTHESIS_BATCH_NO,REMARKS=?
			//pstmt.setString(1,(String)hash.get("implant_code"));

           String st_interface_flag=( String ) CommonData.get( "st_interface_flag" );
		   key_line = getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type"),connection );
		   String st_bill_value=(String)hash.get("sale_document_type")+"-"+(String)hash.get("sale_document_no");

String excl_incl_ind="";
String action_reason_code="";
			 bill_str=(String) hash.get("bill_str");
			if(bill_str==null) bill_str="";
			if(!bill_str.equals("") )
		{
			String[] charge_arr=null;
			charge_arr=bill_str.split("::");
			//Added on 10/26/2010 by AnithaJ
			 if(charge_arr.length==6)
			 {
				 excl_incl_ind=charge_arr[5];
			 }
     		 if(charge_arr.length==9)
		     {
		         action_reason_code=charge_arr[8];  
			 }
		}


			if(("null").equals(excl_incl_ind))
			{
				excl_incl_ind="";
			}
			if(("null").equals(action_reason_code))
			{
				action_reason_code="";
			}

			String manufacturer=(String)hash.get("manufacturer");
			String batch=(String)hash.get("batch");

			pstmt.setString(1,(String)hash.get("quantity"));
			pstmt.setString(2,manufacturer);
			pstmt.setString(3,batch);
			//pstmt.setString(4,(String)hash.get("remarks"));
			String remarksVal = ((String)hash.get("remarks"));
			if(!remarksVal.equals(""))
			{
				remarksVal=java.net.URLDecoder.decode(remarksVal,"UTF-8");
			}
			pstmt.setString(4,remarksVal);

			pstmt.setString(5,excl_incl_ind);
			pstmt.setString(6,action_reason_code);
			//UPDATE OT_SURGICAL_ACCESSORIES SET ACCESSORY_CODE=?,QUANTITY=?,PROSTHESIS_MFR=?,PROSTHESIS_BATCH_NO=?,REMARKS=? WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND OPER_CODE=? AND OPER_LINE_NUM=? AND ACCESSORY_CODE=?"
			pstmt.setString(7,(String)hash.get("sale_document_type"));
			pstmt.setString(8,(String)hash.get("sale_document_no"));

			if(st_interface_flag.equals("Y"))
		    {
	        pstmt.setString(9,st_bill_value);
		    }else
		    {
	         pstmt.setString(9,"I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
		    }

			if(st_interface_flag.equals("Y"))
			{
			pstmt.setString(10,"1");
			}else
			{
			pstmt.setString(10,key_line);
			}
			pstmt.setString(11,(String)hash.get("req_store_code"));
			pstmt.setString(12,(String)hash.get("requested_qty"));
			pstmt.setString(13,(String)CommonData.get("facility_id"));
			pstmt.setString(14,(String) hash.get("oper_num"));
			pstmt.setString(15,(String) hash.get("oper_code"));
			pstmt.setString(16,(String) hash.get("oper_line_no"));
			pstmt.setString(17,(String)hash.get("implant_code"));
		}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_D")){
trace="16.0";

			pstmt.setString(1,(String)CommonData.get("facility_id"));
			pstmt.setString(2,(String) hash.get("oper_num"));
			pstmt.setString(3,(String) hash.get("oper_code"));
			pstmt.setString(4,(String) hash.get("oper_line_no"));
			pstmt.setString(5,(String)hash.get("implant_code"));
		}else if(key.equals("OT_POST_OPER_PROC_DTLS_I")){

trace="17.0";

				pstmt.setString(1,(String) CommonData.get("facility_id"));
				pstmt.setString(2,(String) CommonData.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String) hash.get("coding_scheme"));
				pstmt.setString(6,(String) hash.get("proc_code"));
				//auditing fields
				pstmt.setString(7,(String)CommonData.get("login_user"));
				pstmt.setString(8,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(9,(String)CommonData.get("facility_id"));
				pstmt.setString(10,(String)CommonData.get("login_user"));
				pstmt.setString(11,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(12,(String)CommonData.get("facility_id"));
		}else if(key.equals("OT_POST_OPER_PROC_DTLS_U")){
trace="18.0";

			//dataMap.put("OT_POST_OPER_PROC_DTLS_U","UPDATE OT_POST_OPER_PROC_DTLS SET  PROC_CODING_SCHEME=?,PROC_CODE =?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND OPER_CODE=? AND OPER_LINE_NUM=? AND PROC_CODING_SCHEME=? AND PROC_CODE=?");
     			pstmt.setString(1,(String) hash.get("coding_scheme"));
				pstmt.setString(2,(String) hash.get("proc_code"));
				pstmt.setString(3,(String)CommonData.get("login_user"));
				pstmt.setString(4,(String)CommonData.get("login_at_ws_no"));
				pstmt.setString(5,(String)CommonData.get("facility_id"));
				//where fields
				pstmt.setString(6,(String) CommonData.get("facility_id"));
				pstmt.setString(7,(String) CommonData.get("oper_num"));
				pstmt.setString(8,(String) hash.get("oper_code"));
				pstmt.setString(9,(String) hash.get("oper_line_no"));
				pstmt.setString(10,(String) hash.get("coding_scheme"));
				pstmt.setString(11,(String) hash.get("old_proc_code"));
		}else if(key.equals("OT_POST_OPER_PROC_DTLS_D")){
trace="19.0";

			//dataMap.put("OT_POST_OPER_PROC_DTLS_D","DELETE FROM OT_POST_OPER_PROC_DTLS WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND OPER_CODE=? AND OPER_LINE_NUM=? AND PROC_CODING_SCHEME=? AND PROC_CODE=?");
				pstmt.setString(1,(String) CommonData.get("facility_id"));
				pstmt.setString(2,(String) CommonData.get("oper_num"));
				pstmt.setString(3,(String) hash.get("oper_code"));
				pstmt.setString(4,(String) hash.get("oper_line_no"));
				pstmt.setString(5,(String) hash.get("coding_scheme"));
				pstmt.setString(6,(String) hash.get("proc_code"));
	}
trace="20.0";
int count=0;
if(flag_chk)
			 {
 count = pstmt.executeUpdate();
			 }

//Added below block for 27150 on 4/21/2011 by Anitha
	if( key.equals("OT_POST_OPER_DTLS_U") && count > 0  && chk_oper_status.equals("99"))
	{


		String cancel_remarks=(String)hash.get("cancel_remarks");
		cancel_remarks=java.net.URLDecoder.decode(cancel_remarks,"UTF-8");

		String sqlOR="UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99' AND ROWNUM =1), CAN_DATE_TIME = SYSDATE, CAN_LINE_REASON = SUBSTR(?,1,255),CAN_PRACT_ID = ? where (order_id,order_line_num) = (select order_id,order_line_num from ot_post_oper_dtls where operating_facility_id =? and oper_num = ? and oper_line_num = ?)";

		pstmt1=connection.prepareStatement(sqlOR);
		pstmt1.setString(1,cancel_remarks);
		pstmt1.setString(2,(String)hash.get("practitioner_id"));

		pstmt1.setString(3,(String) CommonData.get("facility_id"));
		pstmt1.setString(4,(String) hash.get("oper_num"));
		pstmt1.setString(5,(String) hash.get("oper_line_num"));
	/*	System.out.println("sqlOR   -------------"+sqlOR);
		System.out.println("cancel_remarks   -------------"+cancel_remarks);
		System.out.println("pract_id   -------------"+hash.get("practitioner_id")); 
		System.out.println("sqlOR   -------------"+(String) CommonData.get("facility_id"));
		System.out.println("oper_num   -------------"+(String) hash.get("oper_num"));
		System.out.println("oper_line_no   -------------"+(String) hash.get("oper_line_num")); 
*/

		int count1=0;
//System.out.println("before update RecordSurgeonManager"); 
		count1=pstmt1.executeUpdate();
//System.out.println("After update RecordSurgeonManager"); 

		//System.out.println("count1   -------------"+count1);
		if(pstmt1 !=null) pstmt1.close(); //Common-ICN-0053
	}


//end



//System.err.println("flag_chk-----"+flag_chk);
//System.err.println("count-----"+count);
 // int count =0;

  /*if(key.intern()=="OT_POST_OPER_DTLS_I" && proc_text.intern()=="SUCCESS"){
	count = pstmt.executeUpdate();
  }else if(key.intern()=="OT_POST_OPER_DTLS_D" && proc_text.intern()=="SUCCESS"){
	count =(order_id.intern()=="")?pstmt.executeUpdate():1;
  }

  if(key.intern()!="OT_POST_OPER_DTLS_I" && key.intern()!="OT_POST_OPER_DTLS_D")
	count = pstmt.executeUpdate();*/
	////////////////// bshankar boolean key_check = (key.intern()!="OT_POST_OPER_DTLS_I" && key.intern()!="OT_POST_OPER_DTLS_D" && key.intern()!="OT_POST_OPER_DTLS_L")?true:false;
trace="20.1";
	////////////////// bshankar  int count = (key_check==true)?pstmt.executeUpdate():(key.intern()=="OT_POST_OPER_DTLS_I" && proc_text.intern()=="SUCCESS")?pstmt.executeUpdate():(key.intern()=="OT_POST_OPER_DTLS_D" && proc_text.intern()=="SUCCESS" && order_id=="")?pstmt.executeUpdate():1;
	//int count = pstmt.executeUpdate();

	//boolean key_check = (key.intern()!="OT_POST_OPER_DTLS_I" && key.intern()!="OT_POST_OPER_DTLS_D")?true:false;
//	int count = (key_check==true)?pstmt.executeUpdate():(key.intern()=="OT_POST_OPER_DTLS_I" && proc_text.intern()=="SUCCESS")?pstmt.executeUpdate():(key.intern()=="OT_POST_OPER_DTLS_D" && proc_text.intern()=="SUCCESS" && order_id=="")?pstmt.executeUpdate():1;

trace="20.2";

	if(count>0 || proc_text.intern()=="SUCCESS"){
trace="20.3";
		success_flag_yn = "Y"; 
	}else
	{
		success_flag_yn = "N"; 
	}
	//System.err.println("success_flag_yn-----"+success_flag_yn);

	}else{
trace="20.4";
		success_flag_yn = "Y"; 
		break;
	}
trace="20.5";

	}//end of for loop
trace="21.0";
transaction_err_text="";
result_array.add(success_flag_yn);
	result_array.add(tabData);
}catch(Exception e){
//trace="22.0";
	transaction_err_text=e.getMessage();
	e.printStackTrace();
	flag = false;
}finally{
	try{
		 if(pstmt!=null) pstmt.close();
		 if(pstmt1!=null) pstmt1.close(); //Added Against AAKH-ICN-0008
		 //hash.clear();
	}catch(Exception e){}
}

 return result_array;
}


void closeAllStatement(HashMap hashStatement){
	String key="";
	Set set=hashStatement.keySet();
	Iterator itr=set.iterator();
	PreparedStatement pstmt=null;
	try{
		while(itr.hasNext()){
			 key=(String) itr.next();
			 if(key.equals("OT_POST_OPER_DTLS_L")){
				// Ignore This Key
			 }else{ 
				 pstmt=(PreparedStatement)hashStatement.get(key);
				 if(pstmt!=null) pstmt.close();
			 }
		 }
	}catch(Exception ee){
		System.err.println("REC_SURG_MAN: "+ee.getMessage());
	}

    }





public String updateDocumentationLevel(HashMap map, Connection connection){
	//Connection con = null;
	CallableStatement cstmt = null;
	PreparedStatement pstmt	= null; //Added against PMG2023-MMS-CRF-0002
	String updateSql = ""; //Added against PMG2023-MMS-CRF-0002
	String error_text = "";
	String status	  = "";
	String doc_compl_date="null";
	if( ( (String) map.get("doc_complete") ).equals("Y")){
		doc_compl_date="TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')";
	}
	try{
			//Added against PMG2023-MMS-CRF-0002
			updateSql = "UPDATE OT_POST_OPER_HDR SET  SURGEON_UPDATE_NOTES_YN = '"+(String)map.get("update_notes")+"' WHERE operating_facility_id = '"+(String)map.get("facility_id")+"' AND oper_num = '"+(String)map.get("oper_num")+"'";
			pstmt = connection.prepareStatement(updateSql);
			pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			//Added against PMG2023-MMS-CRF-0002
			
			//con = ConnectionDispenser.getConnection();
			//cstmt=con.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,null,?,?,null,null,?,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,null,?,?,null,null,?,?,null,null,null,null,null,null,null,null,null,"+doc_compl_date+",null,null,null,null,null,?,?,?,?,?)}");
			cstmt.setString(1,"07");//Function ID
			cstmt.setString(2,(String)map.get("facility_id"));
			cstmt.setString(3,(String)map.get("oper_num"));
			cstmt.setString(4,(String)map.get("doc_complete"));//DOCUMENTATION_COMPLETE
			cstmt.setString(5,(String)map.get("doc_level")); // ADDNL_FLD1
			//ADDN_FLD2-<DOCUMENT_VERIFIED_YN>
			//ADDN_FLD3-<WOUND_TYPE> FROM SURGEON_NOTES
			cstmt.setString(6,(String)map.get("theatre_code")); // ADDNL_FLD4
			cstmt.setString(7,(String)map.get("diagnosis_text"));//ADDNL_FLD5
			//ADDN_FLD6-<WOUND_TYPE> FROM SURGEON_NOTES
			// the null fields are additional fields...not used in this function
			cstmt.setString(8,(String) map.get("login_user"));
			cstmt.setString(9,(String) map.get("login_at_ws_no"));
			cstmt.registerOutParameter(10,Types.VARCHAR);
			cstmt.registerOutParameter(11,Types.VARCHAR);
			cstmt.registerOutParameter(12,Types.VARCHAR);//LANG_ERR_MSG_ID
			cstmt.execute();
			status = cstmt.getString(10);
			if(status.equals("E")){
				//error_text = cstmt.getString(11);
				error_text = cstmt.getString(12);
				connection.rollback();
			}else{
				error_text ="RECORD_INSERTED";
				connection.commit();
			}
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                if(cstmt!=null) cstmt.close();
				//con.close();
             }catch(Exception es){es.printStackTrace();}
        }

		return error_text;
	}

	public boolean buildHistory(HashMap CommonData,Connection connection){
		System.err.println("978,RecordSurgeonManager.java==buildHistory==");
		String emt = "".intern();
		//Connection con = null;
		PreparedStatement pstmt									=	null;
		PreparedStatement while_pstmt							=	null;
		/* PreparedStatement pstmt2								=	null;
		ResultSet rst2											=	null;
		ResultSet rst1											=	null;  */ //Commented Against AAKH-ICN-0008
		ResultSet rst											=	null;
		ResultSet while_rst											=	null;
		boolean err_text										=	true;
		String facility_id										=	( String )CommonData.get( "facility_id" );
		String oper_no											=	( String )CommonData.get( "oper_num" );
		String documt_level										=	( String )CommonData.get( "doc_level" );
		StringBuilder content									=	new StringBuilder();
		String short_desc										=	emt;
		String side												=	emt;
		String documentation_level								=	emt;
		String speciality_code									=	emt;
		String speciality_code_as                               = "*ALL";		
		/* PreparedStatement pstmt1									=	null; 
		String documentation_level_all								=	emt;
		String speciality_code_all									=	emt;
		String recovery_start_time_all								=	emt;
		String recovery_end_time_all								=	emt;
		String short_desc1_all										=	emt; */ //Commented Against AAKH-ICN-0008
		String short_desc1										=	emt;
		String speciality_desc									=	emt;
		String role_desc										=	emt;
		String practitioner_name								=	emt;
		String holding_area_desc								=	emt;
		String checked_in_date_time								=	emt;
		String recovery_start_time								=	emt;
		String recovery_end_time								=	emt;
		//CLOB clob_notes_content									= 	null; //commented by dilip on 01/11/2007
		Clob clob_notes_content									= 	null; //Modified by MuthuN against 39099 on 02-04-2013
		//java.sql.Clob clob_notes_content						= 	null;
		 Clob oper_details										=	null; //commented by dilip on 01/11/2007
		//CLOB oper_details										=	null;
		java.io.Writer oper_details_writer						=	null;
//		java.io.Reader oper_details_reader						=	null;//testing 
		java.io.BufferedWriter	oper_details_buffered_writer	= null;
		String anaes_srl_no=emt;
		final String QUOTE = "'";
		final String COMMA = ",";
		String SQL_ANES_SRL_NO = "SELECT anaesthesia_serial_num FROM at_anaesthesia_record_hdr WHERE SOURCE_ORDER_ID = ?";

		/* java.io.Writer			section_content_writer		=	null;
		java.io.BufferedWriter	bf_section_content_writer	=	null;
		String notes_section_content =""; */	//Commented Against AAKH-ICN-0008
		String surg_contr_mod_accession_num = "";
		String key	=  "";
		String val	=  "";
		//String acros_spec ="AS"; //Commented Against AAKH-ICN-0008
		String contr_mod_accession_num = "";
		HashMap map = new HashMap();
		////MO-CRF-20147.13 
		String compressedResult = "";
		String compressResultYN = "N";
		////MO-CRF-20147.13 
	try{
		 //con = ConnectionDispenser.getConnection();
		 //con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connection Issue
		 //CHANGES DONE BY BALA ON 31/12/2007 FOR CANCELATION OF OPERATIONS
		 String sql="SELECT SHORT_DESC,DECODE(RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Both Sides',RIGHT_LEFT_FLAG) side FROM   OT_POST_OPER_DTLS A,OT_OPER_MAST B WHERE  A.OPER_CODE = B.OPER_CODE AND A.OPERATING_FACILITY_ID = '"+facility_id+"' AND  A.OPER_NUM = '"+oper_no+"' ";
		 pstmt=connection.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
		 //commented on the date of 01/07/2013	 
		 //content.append("<tr><td colspan=2><B>Operation Details:</B></td></tr>");
		 while(rst.next()){
			short_desc  = rst.getString("SHORT_DESC")==null?emt:rst.getString("SHORT_DESC");
			side  = rst.getString("side")==null?emt:rst.getString("side");
	//commented on the date of 01/07/2013		
		//content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+short_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+side+" </td></tr>");

		 }

		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close();
	 
		 sql="select 'Anaesthesia Given to Patient:  '||SHORT_DESC short_desc, TO_CHAR(RECOVERY_START_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_START_TIME,TO_CHAR(RECOVERY_END_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_END_TIME,DOCUMENTATION_LEVEL,SPECIALITY_CODE from  ot_post_oper_hdr a, AM_ANAESTHESIA b where  A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND    A.OPER_NUM = '"+oper_no+"' and    a.ANESTHESIA_CODE = b. ANAESTHESIA_CODE(+)";
		 pstmt=connection.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 while(rst.next()){
			documentation_level		=		 rst.getString("DOCUMENTATION_LEVEL")==null?emt:rst.getString("DOCUMENTATION_LEVEL");
	// 20/06/2013	if(documentation_level.equals("AS")){			
			//speciality_code			= "*ALL";
		//}else{	
			speciality_code			=		 rst.getString("SPECIALITY_CODE")==null?emt:rst.getString("SPECIALITY_CODE");
	//	}	
			recovery_start_time		=		 rst.getString("RECOVERY_START_TIME")==null?emt:rst.getString("RECOVERY_START_TIME");
			recovery_end_time		=		 rst.getString("RECOVERY_END_TIME")==null?emt:rst.getString("RECOVERY_END_TIME");
			short_desc1				=		 rst.getString("SHORT_DESC")==null?emt:rst.getString("SHORT_DESC");
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

		pstmt=connection.prepareStatement(SQL_ANES_SRL_NO);
		pstmt.setString(1,(String) CommonData.get("order_id"));
		rst=pstmt.executeQuery();
		if(rst.next()){
			anaes_srl_no = rst.getString(1);
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
        
		
		
			
			
		// added by sathish on 24/12/2008 
		String sql_speciality = "SELECT DISTINCT A.SPECIALITY_CODE,B.SHORT_DESC  FROM OT_OPER_MAST A, AM_SPECIALITY B WHERE A.OPER_CODE IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID = ?  AND OPER_NUM = ?) AND A.SPECIALITY_CODE = B.SPECIALITY_CODE AND NVL(B.EFF_STATUS,'E')='E' ORDER BY 1";
		pstmt=connection.prepareStatement(sql_speciality);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_no);
		 rst=pstmt.executeQuery();
		 while(rst.next()){	
			key	= checkForNull(rst.getString(1));//speciality_code
			val = checkForNull(rst.getString(2));//speciality_desc
			map.put(key,val);
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		//System.out.println( "the facility id  is " + facility_id );		
		//System.out.println( "the oper_no  is " + oper_no );		
		//System.out.println( "the speciality_code  is " + speciality_code );		
		//newly added by subramanian on 4/3/2006
	//	contr_mod_accession_num = facility_id+oper_no+speciality_code;
        //System.out.println("contr_mod_accession_numinside the other condition " + contr_mod_accession_num);	


      if(documt_level.equals("AS")){		
		//contr_mod_accession_num = facility_id+oper_no+"*ALL";		
		contr_mod_accession_num = facility_id+oper_no+speciality_code_as;		
		}else{				
		contr_mod_accession_num = facility_id+oper_no+speciality_code;
		}  
		
		
	
		//System.out.println("contr_mod_accession_num outside condition " + contr_mod_accession_num);
		String facility_srl_no = facility_id+anaes_srl_no;
		StringBuffer sbr = new StringBuffer();
		sbr.append(QUOTE).append(contr_mod_accession_num).append("10").append(QUOTE).append(COMMA);
		//sbr.append(QUOTE).append(contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
		//added by sathish on 24/12/2008
		
		if(documt_level.equals("AS")){		
		
		surg_contr_mod_accession_num = facility_id+oper_no+speciality_code_as;	
		sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);		
		}else{	
		Iterator keys = map.keySet().iterator();
			while(keys.hasNext()){
				surg_contr_mod_accession_num = facility_id+oper_no+(String)keys.next();	
				sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
			} 
	   }		  
		/*Iterator keys = map.keySet().iterator();
			while(keys.hasNext()){
				surg_contr_mod_accession_num = facility_id+oper_no+(String)keys.next();				
				sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
			} */
			
		//System.out.println("the surg_contr_mod_accession_num"  + surg_contr_mod_accession_num);	
		sbr.append(QUOTE).append(contr_mod_accession_num).append("40").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(contr_mod_accession_num).append("99").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("PRE").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("INTRA").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("POST").append(QUOTE);
		//sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") ORDER BY 1";
		//added by sathish on 24/12/2008
		//sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT, CONTR_MOD_ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") AND EVENT_STATUS <> 9 ORDER BY 1";
		sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT,CONTR_MOD_ACCESSION_NUM,compress_note_content_yn, compress_note_content FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") AND EVENT_STATUS <> 9 ORDER BY 1";	//Modified Against MO-CRF-20147.13
		
		//System.out.println(" the sql is " + sql);
		
		sbr.setLength(0);
		content.append("<link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' />");
		while_pstmt = connection.prepareStatement(sql);
		while_rst=while_pstmt.executeQuery();
		while(while_rst.next()){
			switch(while_rst.getInt(1)){
				case 1: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Holding Area Notes</TD><TR><TABLE>"); break;
				//case 2: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>"); break;
				case 2:				  	
					val = while_rst.getString(4);
					key = val.substring(12,val.length()-2);					
					if (key!=null && !key.equals("") && !key.equals("*ALL")) {
					content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes("+map.get(key)+")</TD><TR><TABLE>"); 
					}else{
					content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>");
					}
						
					    break;
				case 3: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Recovery Notes</TD><TR><TABLE>"); break;
				case 4: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Operative Records</TD><TR><TABLE>"); break;
				case 5: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Pre Anesthesia Details</TD><TR><TABLE>"); break;
				case 6: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Intra Anesthesia Details</TD><TR><TABLE>"); break;
				case 7: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Post Anesthesia Details</TD><TR><TABLE>"); break;
				default :break;

			}
			 //clob_notes_content	= (CLOB)while_rst.getClob("note_content");   //comment by dilip 01/11/2007
			 clob_notes_content	= while_rst.getClob("note_content"); //Modified by MuthuN against 39099 on 02-04-2013
			//clob_notes_content	=	(java.sql.Clob) while_rst.getObject("note_content");
			if(clob_notes_content!=null){
				
				//System.out.println("inside if condition clob_notes_content in the record surgeon manager   " + clob_notes_content);		
				//clob_notes_section_content	=	(java.sql.Clob) rs1.getObject("notes_section_content"); commented by Dilip
				// added by dilip.
				//		section_content_writer		=	((java.sql.Clob)clob_notes_content).getCharacterOutputStream();
				//		bf_section_content_writer = new java.io.BufferedWriter(section_content_writer);
				//		bf_section_content_writer.write(notes_section_content,0,clob_notes_content.length());
				//		bf_section_content_writer.flush();
				//		bf_section_content_writer.close();
				// end of dilip.
				content.append(clob_notes_content.getSubString(1,(int) clob_notes_content.length())).append("*********");
				System.out.println("content.appended clob_notes check it " );
				
				
			} // end of if(clob_notes_content!=null)
				
				//MO-CRF-20147.13 Starts
				
				compressResultYN = while_rst.getString("compress_note_content_yn")==null?"N":(String)while_rst.getString("compress_note_content_yn");
				System.err.println("1359, compressResultYN : "+compressResultYN);
				java.sql.Blob note_blob =  (java.sql.Blob)while_rst.getBlob("compress_note_content");
				if(note_blob!=null && note_blob.length()>0){
				InputStream ins1 = note_blob.getBinaryStream();
				ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
				int i;
				while((i = ins1.read()) != -1) 
					bytearrayoutputstream.write(i);

				byte[] compressed	=bytearrayoutputstream.toByteArray();
				if(compressed.length > 0){
					if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
						GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

						String line;
						while ((line = bufferedReader.readLine()) != null) {
							compressedResult += line;
							System.err.println("1359, compressedResult : "+compressedResult);
						}
					}					
				}
				}
		//MO-CRF-20147.13 Ends
		} // end of if(rst.next())
				content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
				content.append("<tr><td></td><td nowrap>"+short_desc1+"</td></tr>");
				
	
				sql=" SELECT DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities', D.SHORT_DESC) SPECIALITY_DESC,C.ROLE_DESC, B.SHORT_NAME PRACTITIONER_NAME  FROM   OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER B, OT_ROLES C, (SELECT '*ALL' SPECIALITY_CODE,'All Specialities'  SHORT_DESC FROM DUAL UNION SELECT SPECIALITY_CODE, SHORT_DESC FROM  AM_SPECIALITY  )  D  WHERE  A.OPERATING_FACILITY_ID = '"+facility_id+"' AND 	 A.OPER_NUM			 ='"+oper_no+"' AND	  A.SPECIALITY_CODE	 = D.SPECIALITY_CODE  AND	 A.PRACTITIONER_ID	 = B.PRACTITIONER_ID  AND  A.ROLE_ID	 = C.ROLE_ID ";

				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
		        pstmt=connection.prepareStatement(sql);
				rst=pstmt.executeQuery();
//commented on the date of 01/07/2013				
			//content.append("<tr><td colspan=6 class='CAGROUPHEADING'>Personnel Details</td></tr>");
				while(rst.next()){
					speciality_desc		=	rst.getString("SPECIALITY_DESC")==null?emt:rst.getString("SPECIALITY_DESC");
					role_desc			=	rst.getString("ROLE_DESC")==null?emt:rst.getString("ROLE_DESC");
					practitioner_name	=	rst.getString("PRACTITIONER_NAME")==null?emt:rst.getString("PRACTITIONER_NAME");
//commented on the date of 01/07/2013					
			//	content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+speciality_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+role_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+practitioner_name+"  </td></tr>");
				}
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				sql="SELECT B.HOLDING_AREA_DESC, TO_CHAR(CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_IN_DATE_TIME FROM  OT_OPER_HOLDING_DTLS A, OT_HOLDING_AREAS B WHERE A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND   A.OPER_NUM ='"+oper_no+"' AND   A.OPERATING_FACILITY_ID  = B.OPERATING_FACILITY_ID AND A. HOLDING_AREA_CODE = B. HOLDING_AREA_CODE";
				pstmt=connection.prepareStatement(sql);
				rst=pstmt.executeQuery();
			//commented on the date of 01/07/2013		
			//	content.append("<tr><td colspan=5 class='CAGROUPHEADING'>Holding Bay Details</td></tr>");
				while(rst.next()){
					holding_area_desc  = rst.getString("HOLDING_AREA_DESC")==null?emt:rst.getString("HOLDING_AREA_DESC");
					checked_in_date_time  = rst.getString("CHECKED_IN_DATE_TIME")==null?emt:rst.getString("CHECKED_IN_DATE_TIME");
//commented on the date of 01/07/2013					
				//content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+holding_area_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+checked_in_date_time+"</td></tr>");
				}
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
//commented on the date of 01/07/2013	
				//content.append("<tr><td colspan=6 class='CAGROUPHEADING'><B>Recovery start and end time:</B></td></tr>");
				//content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+recovery_start_time+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+recovery_end_time+"</td></tr>");
				content.append("</table></BODY></HTML>");
				System.err.println("1424, compressedResult : "+compressedResult);
				if(compressResultYN.equals("N"))	//MO-CRF-20147.13
				{
				String updateSql = "UPDATE ot_post_oper_hdr SET  oper_details = empty_clob()  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";
				pstmt = connection.prepareStatement(updateSql);
				//int flag = pstmt.executeUpdate();
				pstmt.executeUpdate();
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				//pstmt.close();
				
				String selectSql = "select oper_details from ot_post_oper_hdr where operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"' for update";
				pstmt = connection.prepareStatement(selectSql);
				rst = pstmt.executeQuery();
				if(rst.next()){
					oper_details = rst.getClob("oper_details");				
					
					//oper_details_writer = ((oracle.sql.CLOB)oper_details).getCharacterOutputStream();
					oper_details_writer = oper_details.setCharacterStream(0L);//Modified by MuthuN against CLOB weblogic
					oper_details_buffered_writer = new java.io.BufferedWriter(oper_details_writer);	
					oper_details_buffered_writer.write(content.toString(),0,content.length());	
					oper_details_buffered_writer.flush();										
					oper_details_buffered_writer.close();

					//oper_details = (oracle.sql.CLOB) rst.getClob("oper_details");
					//clob_notes_content	=	(oracle.sql.CLOB) rst.getObject("note_content");
					//oper_details_writer = ((oracle.sql.CLOB)oper_details).getCharacterOutputStream();
					//oper_details_buffered_writer = new java.io.BufferedWriter(oper_details_writer);
					//oper_details_buffered_writer.write(content.toString(),0,content.length());
					//oper_details_buffered_writer.flush();
					//oper_details_buffered_writer.close();
				/*	CLOB clb 			= (CLOB) rst.getClob("oper_details");
					BufferedWriter bw 				= new BufferedWriter(clb.getCharacterOutputStream());
					bw.write(clb,0,clb.length());
					bw.flush();
					bw.close();*/
				}
				}
				//MO-CRF-20147.13 Starts
			else{
				System.err.println("1464, compressedResult : "+compressedResult);
			String updateCompressed = "UPDATE OT_POST_OPER_HDR SET compress_note_content_yn = ? , compress_note_content = ?  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";

			pstmt = connection.prepareStatement(updateCompressed);

			pstmt.setString(1,compressResultYN );
			pstmt.setBytes(2, compress(compressedResult));
			pstmt.executeUpdate();
			System.err.println("~~~~Executed~~~~~~`");
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
				
		}
		//MO-CRF-20147.13 Ends
				
			//}
		
			//}
		//}
	}catch(Exception ee){
		ee.printStackTrace();
		System.err.println("REC_SURG_MAN: error in insert method::"+ee);
		err_text=false;
	}finally{
		try{
			if(rst!=null) rst.close();
			if(while_rst!=null) while_rst.close();
			if(pstmt!=null) pstmt.close();
			if(while_pstmt!=null) while_pstmt.close();

			//connection.close();
			connection.commit();
		 }catch(Exception e){}
	  }
 	return err_text;
	 //return true;
	}
	
	//MO-CRF-20147.13 Starts
	public  byte[] compress(final String str) throws IOException {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}
		System.err.println("compressing");
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes("UTF-8"));
		gzip.close();
		return obj.toByteArray();
	}
	//MO-CRF-20147.13 Ends
	
	public ArrayList getOperationDtls(String oper_num,String facility_id, ArrayList tabData,Connection connection){
		//Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList list = new ArrayList();
		HashMap result = null;
		HashMap hash = null;
		//String SQL="SELECT A.OPER_CODE,B.SHORT_DESC,NVL(DECODE(A.RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Bilateral','N','Not Applicable'),'Not Applicable') RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.OPER_LINE_NUM OPR_LN_NUM,A.ORDER_LINE_NUM ORD_LN_NUM,A.ORDER_ID ORD_ID FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";
		//changes for cancelled operation done by subramanian on 31/12/2007
		//String SQL="SELECT A.OPER_CODE,B.SHORT_DESC,NVL(DECODE(A.RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Bilateral','N','Not Applicable'),'Not Applicable') RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.OPER_LINE_NUM OPR_LN_NUM,A.ORDER_LINE_NUM ORD_LN_NUM,A.ORDER_ID ORD_ID FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND NVL(A.OPER_LINE_STATUS,'X') NOT IN ('99')";
		String SQL="SELECT A.OPER_CODE,B.SHORT_DESC,NVL(DECODE(A.RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Bilateral','N','Not Applicable'),'Not Applicable') RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.OPER_LINE_NUM OPR_LN_NUM,A.ORDER_LINE_NUM ORD_LN_NUM,A.ORDER_ID ORD_ID,A.FPP_CATEGORY fpp_category,nvl(C.FPP_YN,'N' ) fpp_yn FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B, OR_ORDER_CATALOG C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE and c.ORDER_CATALOG_CODE=A.OPER_CODE";


		int size = tabData.size();
		int i = 0;
		String oper_code = "";
		//String db_mode = "";	//Commented Against AAKH-ICN-0008
		boolean found=false;
		//Modified by DhanasekarV against issue 13/11/2011
		String table_name1 = "";
		//String db_mode1 = ""; //Commented Against AAKH-ICN-0008
		try{
			//con = ConnectionDispenser.getConnection();
			//con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connection Issue

			pstmt = connection.prepareStatement(SQL) ;
			pstmt.setString(1, facility_id );
			pstmt.setString(2, oper_num );
			resultSet= pstmt.executeQuery();
			while(resultSet.next()){
				result = new HashMap();
				oper_code = checkForNull(resultSet.getString("OPER_CODE"));
				result.put("oper_code",oper_code);
				result.put("oper_desc",checkForNull(resultSet.getString("SHORT_DESC")));
				result.put("oper_line_num",checkForNull(resultSet.getString("OPR_LN_NUM"))) ;
				result.put("order_line_num",checkForNull(resultSet.getString("ORD_LN_NUM")) );
				result.put("order_id",checkForNull(resultSet.getString("ORD_ID")) );
				result.put("fpp_category",checkForNull(resultSet.getString("fpp_category")) );
				result.put("fpp_yn",checkForNull(resultSet.getString("fpp_yn")) );
				found=false;
				//modified by DhanasekarV against issue 13/11/2011
				i = 0;
				while(found==false && i<size){

//table_name=OT_POST_OPER_DTLS
					hash=(HashMap)tabData.get(i);
					if(hash!=null){
						if(oper_code.equals((String)hash.get("oper_code"))){
							table_name1=(String)hash.get("table_name");	
							if(table_name1.equals("OT_POST_OPER_DTLS")==true)
							{
							result.put("db_mode",hash.get("db_mode"));
							found=true;
							}							
						}
					}
					i++;
				}
				list.add(result);
			}
		}catch (Exception e){
			   e.printStackTrace();
	          System.err.println("REC_SURG_MAN: Err Msg in getOperationalDtls "+e.getMessage());
		}
		finally{
		  try{
                if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				//con.close();
		  }catch(Exception e){}
		}
		return list;
 }

  public String getBillingEpisodeType(String patient_class,String episode_type,Connection connection){
		//Connection con  = null;
		PreparedStatement pstmt=null;
		ResultSet rst  = null;
		String bl_episode_type = "";
		String SQL="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE  PATIENT_CLASS=? AND EPISODE_TYPE =?";
		try{
			//con = ConnectionDispenser.getConnection();
			//con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connection Issue
			pstmt = connection.prepareStatement(SQL) ;
			pstmt.setString(1,patient_class);
			pstmt.setString(2,episode_type);
			rst= pstmt.executeQuery();
				while(rst.next()){
					bl_episode_type=rst.getString(1);
			}
		}catch (Exception e){
			e.printStackTrace();
	        System.err.println("REC_SURG_MAN: Err Msg in getBillingEpisodeType(OTCommonBean) "+e.getMessage());
		}
		finally{
		  try{
                if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				//con.close();
		  }catch(Exception e){}
		}
		return bl_episode_type;
 }


 public boolean isBillingInstalled(String facility_id,Connection connection){
	//Connection con = null;
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean flag = false;
	try{
		//con = ConnectionDispenser.getConnection();
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=connection.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);


		}
	}catch(Exception e){
		e.printStackTrace();

   }finally{
		try{
			//if(rst!=null)rst.close();
			if(cstmt!=null)cstmt.close();
			//if(con!=null)con.close();
		}catch(Exception e){}

	}
	return flag;
 }


//New procedure introduced for Apr'07 release
public String GeneratePatientBill( HashMap map,HashMap<String,List> bill_map,ArrayList tabData,Connection connection ){

	//identifiers used
	String[] charge_arr=null;
	//String total_amt		= "";
	//String payable			= "";
	//String paid				= "";
	//String charge_yn		= "";
	//String err_text			= ""; //Commented Against AAKH-ICN-0008
	String err_desc			= "";
	String oper_desc		= "";
	//String mesg_id			= "";	//Commented Against AAKH-ICN-0008
	String oper_code		= "";
	String key		= "";
	String catalog_bill_yn="";	
	String bl_strerrorlevel="";
	String bl_strsysmessageid="";
	String bl_strerrortext="";
	String fpp_category="N";
	String fpp_yn="N";
	//String oper_line_status="";	//Commented Against AAKH-ICN-0008
	String surgeon_doc_comp_yn= (String)map.get("surgeon_doc_comp_yn");
	String oper_proc_comp=( String ) map.get("oper_proc_comp" ); 
	//values getting from Passed HashMap
	String facility_id		= (String)map.get("facility_id") ;
	String patient_id		= (String)map.get("patient_id") ;
	String oper_num			= (String)map.get("oper_num") ;
	String episode_id		= (String)map.get("episode_id") ;
	String episode_type		= (String)map.get("episode_type") ;
	String patient_class	= (String)map.get("patient_class") ;
	String ws_no			= (String)map.get("login_at_ws_no") ;
	String oper_date		= (String)map.get("oper_date") ;
	String surgeon_code		= (String)map.get("surgeon_code") ;
	String visit_id			= (String)map.get("visit_id") ;
	String chargesApplicableCheck = "";
	//047397 start
	String checkInTime = (String) map.get("checkInTime");
	String customerId = (String) map.get("customerId");
	PreparedStatement chargesApplicablePstmt = null;
	StringBuffer chargesApplicableBuffer = new StringBuffer();
	ResultSet chargesApplicableRs = null; 
	//047397 end

	//values getting from methods
	String bl_episode_type  = getBillingEpisodeType(patient_class,episode_type,connection);
	ArrayList list			= getOperationDtls( (String) map.get( "oper_num" ), (String) map.get( "facility_id" ),tabData,connection);
	HashMap hmap = new HashMap();
	Set set = bill_map.keySet();
    Iterator itr = set.iterator();
	String db_mode="";
	boolean found_flag = false;
	//String err_desc="";
	
	//System.out.println("1 list---------"+list);
	int k=0;
	while(itr.hasNext()){
		key = (String) itr.next();
		found_flag=false;
		k=0;
		while(k<list.size() && found_flag==false) {
			hmap = (HashMap) list.get(k);
		
			db_mode = checkForNull( (String)hmap.get("db_mode"));
			/*db_mode=db_mode==null?"":db_mode;
			db_mode=db_mode.equals("null")?"":db_mode;*/


			if(key.equals(""+hmap.get("oper_code")) && (db_mode.equals("U") || db_mode.equals("I") || db_mode.equals("")) ){
				found_flag=true;
			}else{
				found_flag = false;
			}
			k++;
		}

		if(found_flag==false){
			//list.remove(k-1);
		}
		}
		boolean flagchk=true;
		HashMap hash=null;
		HashMap hash1=null;
		//db resource initialization
		//Connection con= null;
		Statement stmt=null;
		ResultSet rset=null;
		CallableStatement cstmt = null;
		hash = null;
		//String[] bill_param = new String[2]; //Commented Against AAKH-ICN-0008
		List<String> panel_str	= new ArrayList<String>();
		//String charge_str	="";	//Commented Against AAKH-ICN-0008
		String[] pract_arr=null;
		String pract_code_val = "";
		String oper_line_status_exist="";
		String trace="30.0";
		String panel_str1="";
		//con = ConnectionDispenser.getConnection();
		//con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connection Issue
		//cstmt=con.prepareCall("{call OT_BILLING_PACKAGE.BL_INTERFACE_OPER_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		trace="30.1";
	   //cstmt=con.prepareCall("{call OT_BILLING_PACKAGE.BL_INTERFACE_OPER_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	   try { 


		stmt=connection.createStatement();
		//047397 start
		chargesApplicableBuffer.append("	SELECT charges_appl_checkin_yn	");
		chargesApplicableBuffer.append("	FROM ot_param_for_facility	");
		chargesApplicableBuffer.append("	WHERE operating_facility_id = ?	");
		chargesApplicablePstmt = connection.prepareStatement(chargesApplicableBuffer.toString());
		chargesApplicablePstmt.setString(1, facility_id);
		chargesApplicableRs = chargesApplicablePstmt.executeQuery();
		while(chargesApplicableRs.next())
			chargesApplicableCheck = checkForNull(chargesApplicableRs.getString("charges_appl_checkin_yn"));
		//047397 end
	   cstmt=connection.prepareCall("{call OT_BILLING_PACKAGE.BL_INTERFACE_OPER_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_number(?),?,?,?,?,?)}");
	   //if(size>0){
		String v_stage = "";
		String v_oper_request_num = "";
		String v_line_num = "";
		//int size = tabData.size(); //Common-ICN-0055
			 		//System.err.println("list.size() :" +list.size());

		for(int i=0;i<list.size();i++){
		   trace="31.0";
		   hash = (HashMap) list.get(i);
		   hash1 = (HashMap) tabData.get(i);
		   fpp_yn = checkForNull((String)hash.get("fpp_yn"));// Added Against ML-MMOH-SCF-2510
		   fpp_category = checkForNull((String)hash.get("fpp_category"));// Added Against ML-MMOH-SCF-2510
		   System.err.println("hash :" +hash);
		   System.err.println("fpp_yn :" +fpp_yn);
		   System.err.println("fpp_category :" +fpp_category);

			trace="31.1";
			 oper_code=(String) hash.get("oper_code");

		String sql_cat_bill="select nvl(a.BILL_YN,'N' ) BILL_YN  from or_order_catalog a,ot_oper_mast b where a.order_catalog_code=b.order_catalog_code and b.oper_code='"+oper_code+"'";
	
	rset=stmt.executeQuery(sql_cat_bill);

	    if(rset !=null && rset.next())
    	{
		catalog_bill_yn=rset.getString("BILL_YN");
		}
if(catalog_bill_yn.equals("Y"))
			{
			if(bill_map.size()>0) 
			{
		    panel_str		=  bill_map.get(hash.get("oper_code") );
//System.err.println("panel_str :" +panel_str);
	//if(panel_str.isEmpty())
		if(panel_str.equals("null") || panel_str.equals(null))
		{
			flagchk=false;
		}else
		{
			flagchk=true;
		}
if(flagchk==true)
				{
			panel_str1=checkForNull(panel_str.get(0));
			//System.err.println("panel_str1 :" +panel_str1);

		if(("").equals(panel_str1) || ("null").equals(panel_str1))
		{
			panel_str1=null;
		}
          
		if(panel_str1!= null)
		{
			pract_arr=panel_str1.split("#");
			//System.err.println("pract_arr :" +pract_arr);
		if(pract_arr.length>1)
			{
			pract_code_val=pract_arr[5];
			//System.err.println("pract_code_val :" +pract_code_val);
			}
		}
		}

		    trace="31.2";
		   // below code is to get the db_mode for the operation. if its I, then mode should be passed as ORD
			//Commented by Dhanasekarv on 13/11/2011
		   //db_mode = checkForNull( (String)hash1.get("db_mode") );
			db_mode = checkForNull( (String)hash.get("db_mode") );		
	
	//	 String  db_modeq = checkForNull( (String)hash.get("db_mode") );
		  v_oper_request_num	=oper_num;
		  v_line_num			=(String)hash.get("oper_line_num");
		  //Commented by Dhanasekarv on 13/11/2011
		 // oper_line_status			=(String)hash1.get("oper_line_status");


	
//Added by Suma wrt Status changes

		String sql_oper_lilne_status_exist="SELECT OPER_LINE_STATUS FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID ='"+facility_id+"'AND OPER_NUM='"+oper_num+"'AND OPER_LINE_NUM='"+v_line_num+"' ";
		rset=stmt.executeQuery(sql_oper_lilne_status_exist);
	    if(rset !=null && rset.next())
    	{
			oper_line_status_exist=rset.getString("OPER_LINE_STATUS");
			if(oper_line_status_exist==null) oper_line_status_exist="";
		}
if(rset !=null)rset.close();
/*		System.out.println("2 db_mode---------"+db_mode);
		System.out.println("3 oper_proc_comp---------"+oper_proc_comp);
		System.out.println("4 oper_line_status_exist---------"+oper_line_status_exist);
*/
		 if(db_mode.equals("D")){
				 v_stage="CAN";
		  }else if(db_mode.equals("U") || db_mode.equals("I"))
		 {
			if (oper_proc_comp.equals("Y") ){
				if(oper_line_status_exist.equals("99"))
				{
					v_stage="CAN";
				}else
				{
					v_stage="CMP";
				}
		  }else{
				if(oper_line_status_exist.equals("99"))
				{
					v_stage="CAN";
				}else
				{				
					v_stage="REG";
				}
		 }


		  }
		 
		//  System.out.println("5 v_stage---------"+v_stage);

		String overridden_excl_incl_ind="";
		String action_reason_code="";
		  if(panel_str == null) // Here panel_str is list and it constains panelstring  and bil_str
		  {
		  overridden_excl_incl_ind="";
	      action_reason_code="";  
		  }
		  else
		 {
		  String bill_str1=panel_str.get(1);
          charge_arr=bill_str1.split("::");
		  overridden_excl_incl_ind=charge_arr[5];
	      action_reason_code=charge_arr[8];  
		 }
		
		// String overridden_excl_incl_ind=panel_str.get(1).split("::")[5];
	    // String action_reason_code=panel_str.get(1).split("::")[8]; 

		  // till here
		  oper_desc=(String) hash.get("oper_desc") ;
		  cstmt.setString(1,facility_id );						//v_facility_id					 VARCHAR2,
		  cstmt.setString(2,patient_id );						//v_patient_id				 VARCHAR2,
		  cstmt.setString(3,episode_id );						//v_episode_id				 VARCHAR2,
		  cstmt.setString(4,visit_id );							//v_visit                                         VARCHAR2,		  
		  cstmt.setString(5,(String) hash.get("order_id") );	//v_order_id                                    VARCHAR2,		  
		  cstmt.setString(6,(String) hash.get("order_line_num"));//v_ord_line_no                                VARCHAR2,		  
		  cstmt.setString(7,(String) hash.get("oper_code"));	//v_oper_code				  VARCHAR2,
		  cstmt.setString(8,"Y" ); //bl_interfaced_yn			//v_bl_interfaced				  VARCHAR2,
		  cstmt.setString(9,bl_episode_type );					//v_bl_episode_type			  VARCHAR2,
		  //cstmt.setString(10,oper_num );						//v_oper_request_num			  VARCHAR2,
		  cstmt.setString(10,v_oper_request_num );						//v_oper_request_num			  VARCHAR2,
		  //cstmt.setString(11,(String)hash.get("oper_line_num"));//v_line_num					  VARCHAR2,
		  cstmt.setString(11,v_line_num);//v_line_num					  VARCHAR2,
		  //cstmt.setString(12,"RST" );							//v_stage					  VARCHAR2,
		  cstmt.setString(12,v_stage );							//v_stage					  VARCHAR2,
		//047397 start
		  if (customerId != null && customerId.equalsIgnoreCase("KDAH"))
		  {
			  if((chargesApplicableCheck != null && chargesApplicableCheck.equalsIgnoreCase("Y")) && (checkInTime != null && checkInTime.trim().length() > 0))
				  cstmt.setString(13, checkInTime);
			  else
				  cstmt.setString(13, oper_date);
		  }
		  else
			  cstmt.setString(13, oper_date); // v_oper_date VARCHAR2, FORMAT SHOULD BE 'DD/MM/YYYY HH24:MI'
		//047397 end
//Modified By Dhanasekar V against sriraj Issue....

   if(("").equals(pract_code_val)||("null").equals(pract_code_val))
            {
	          pract_code_val=null;
            }

		   if(pract_code_val!=null)
			{
			
					cstmt.setString(14,pract_code_val);
			}else
			{
					cstmt.setString(14,surgeon_code );
			}

		  //cstmt.setString(14,surgeon_code );					//v_phy_id					  VARCHAR,
		  cstmt.setString(15,ws_no ) ;							//v_ws_no					  VARCHAR2,
		  cstmt.setString(16,null) ;							//v_catalog_code			IN OUT VARCHAR2,
		  cstmt.setString(17, oper_desc );	//v_oper_desc				   VARCHAR2,		  
		   if(panel_str == null) //Here panel_str is list and it constains panelstring  and bil_str
		  {
		  cstmt.setString(18,"");	
		  }//panel Str		//v_revised_billing_details			   VARCHAR2,
		  else{
		  cstmt.setString(18, panel_str.get(0));		//panel Str		//v_revised_billing_details			   VARCHAR2,
		  }
		  cstmt.registerOutParameter(19,Types.VARCHAR);			//v_serv_panel_ind			OUT      VARCHAR2,
		  cstmt.registerOutParameter(20,Types.VARCHAR);			//v_blng_srvc_code			OUT      VARCHAR2,
		  cstmt.registerOutParameter(21,Types.VARCHAR);			//v_charge_stage			OUT      VARCHAR2,
		  cstmt.registerOutParameter(22,Types.VARCHAR);			//err_code		//		v_err_code				OUT      VARCHAR2,
		  cstmt.registerOutParameter(23,Types.VARCHAR);			//sys_mesg_id	//		v_sys_message_id		OUT      VARCHAR2,
		  cstmt.registerOutParameter(24,Types.VARCHAR);			//error_text	//		v_error_text			OUT      VARCHAR2,
		  cstmt.registerOutParameter(25,Types.VARCHAR);			//		v_preapp_msg	OUT      VARCHAR2,
		  cstmt.registerOutParameter(26,Types.VARCHAR);			//		v_excl_msg	OUT      VARCHAR2,
		  cstmt.registerOutParameter(27,Types.VARCHAR);			//LANG_ERR_MSG_ID	//		V_LANG_ERR_MSG_ID		OUT	    VARCHAR2,
		  cstmt.setString(28,"N");								//FUTURE_ORDER_YN	//		P_FUTURE_ORDER_YN		VARCHAR2 DEFAULT 'N'
		  if(panel_str == null)// Here panel_str is list and it constains panelstring  and bil_str
		  {
		  cstmt.setString(29,"");// P_AMT	
		  }
		  else
		  {
		  cstmt.setString(29,panel_str.get(1).split("::")[0]);
		  }
		  trace="31.3";

		    cstmt.setString(30,"OT");
		   if(("null").equals(overridden_excl_incl_ind))
				{
				cstmt.setString(31,"") ;
				}
				else 
				{
				cstmt.setString(31,overridden_excl_incl_ind) ;	//overridden_excl_incl_ind	  VARCHAR2 default null
				}

				if(("null").equals(action_reason_code))
				{
				cstmt.setString(32,"") ;
				}
				else
				{
				cstmt.setString(32,action_reason_code) ;	//action_reason_code	  VARCHAR2 default null
				}
				//Added Against ML-MMOH-SCF-2510-TF
				cstmt.setString( 33,  fpp_yn ) ;						 
				cstmt.setString( 34,  fpp_category ) ;
				
				
System.err.println("action_reason_code="+action_reason_code);

		  cstmt.execute();
		  bl_strerrorlevel = checkForNull(cstmt.getString(22));
		  bl_strsysmessageid = checkForNull(cstmt.getString(23));
		  bl_strerrortext = checkForNull(cstmt.getString(24));
		  err_desc=decodeProcedureErrorMsg(bl_strerrorlevel,bl_strsysmessageid,bl_strerrortext,"GeneratePatientBill()");
		  if(!"RECORD_INSERTED".equals(err_desc)) break;
		}
		}else
		{
			err_desc="RECORD_INSERTED";
		}
		 }//end for
		
		if("RECORD_INSERTED".equals(err_desc) && "Y".equals(surgeon_doc_comp_yn) ) {
				err_desc=callAddBillSubServices(map,connection);
		}
		if(err_desc.equals("RECORD_INSERTED") && "Y".equals(oper_proc_comp)) {
			
	String oper_finalization_stage="";
		String final_stage="SELECT OPER_FINALIZATION_STAGE  FROM ot_param_for_facility WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		rset=stmt.executeQuery(final_stage);
	    if(rset !=null && rset.next())
    	{
			oper_finalization_stage=rset.getString("OPER_FINALIZATION_STAGE");
			if(oper_finalization_stage==null) oper_finalization_stage="";
		}
if(rset !=null)rset.close();


if(oper_finalization_stage.equals("S"))
			{
				err_desc= callBillRecord(map,connection);//connection Issue

			}
		}
		if(!err_desc.equals("RECORD_INSERTED")) {
			connection.rollback();
return err_desc;
		 }else 
	   {
	connection.commit();
		 }
		



		trace="33.5";
		if(stmt !=null)stmt.close();
		if(rset !=null)rset.close();
 }catch(Exception e){
	trace="34.0";
	err_desc=e.getMessage();
	e.printStackTrace();
}finally{
		try{
			hash.clear();
			list.clear();
			if(cstmt!=null) cstmt.close();
			if(chargesApplicablePstmt!=null) chargesApplicablePstmt.close();	//Added Against AAKH-ICN-0008
			if(chargesApplicableRs!=null) chargesApplicableRs.close();	//Added Against AAKH-ICN-0008
		}catch(Exception e){}
}
	return err_desc;
}


public String callAddBillSubServices(HashMap CommonData,Connection connection){
		String err_desc="";
		String bl_strerrorlevel="";
		String bl_strsysmessageid="";
		String bl_strerrortext="";
		CallableStatement cstmt=null;
		HashMap hm=(HashMap) CommonData.get("bl_addl_serv");
	try{
		//Connection con = ConnectionDispenser.getConnection();
		//Connection con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connection Issue
		String surgeon_doc_comp_yn=( String ) CommonData.get( "surgeon_doc_comp_yn" );
		if(surgeon_doc_comp_yn.equals("Y") && (hm.size()>0) )	{
				
				cstmt=connection.prepareCall("{call BL_POPULATE_INTERFACE_SURG (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //23 ? and 3 ? for out params
				cstmt.setString(1,(String) hm.get("facility_id") );//facility_id
				cstmt.setString(2,(String) hm.get("patient_id") );//patient_id
				cstmt.setString(3,(String) hm.get("episode_type") );//episode_type
				cstmt.setString(4,(String) hm.get("episode_id") );//episode_id
				cstmt.setString(5,(String) hm.get("visit_id") );//visit_id
				cstmt.setString(6,(String) hm.get("str_order_cat_code") );//str_order_cat_code
				cstmt.setString(7,(String) hm.get("str_serv_panel_ind") );//str_serv_panel_ind
				cstmt.setString(8,(String) hm.get("str_blng_serv_code") );//str_blng_serv_code
				cstmt.setString(9,(String) hm.get("str_trx_date_time") );//str_trx_date_time
				cstmt.setString(10,(String) hm.get("str_serv_qty") );//str_serv_qty
				cstmt.setString(11,(String) hm.get("charging_stage") );//charging_stage
				cstmt.setString(12,(String) hm.get("str_charge_based_amt") );//str_charge_based_amt
				cstmt.setString(13,(String) hm.get("str_pract_id") );//str_pract_id
				cstmt.setString(14,(String) hm.get("str_overridden_excl_incl_ind") );//str_overridden_excl_incl_ind
				cstmt.setString(15,(String) hm.get("strloggeduser") );//strloggeduser
				cstmt.setString(16,(String) hm.get("strclientip") );//strclientip
				cstmt.setString(17,(String) hm.get("str_dep_blng_serv_code") );//str_dep_blng_serv_code
				cstmt.setString(18,(String) hm.get("str_dep_serv_charge_eff_perc") );//str_dep_serv_charge_eff_perc
				cstmt.setString(19,(String) hm.get("str_disc_seq_num") );//str_disc_seq_num
				cstmt.setString(20,(String) hm.get("str_multi_surg_disc_eff_perc") );//str_multi_surg_disc_eff_perc
				//cstmt.setString(21,(String) "OT" );//str_ref_sec_module_id
				cstmt.setString(21,(String) hm.get("str_ref_module_id"));//str_ref_sec_module_id 
				cstmt.setString(22,(String) hm.get("str_ref_oper_num") );//str_ref_oper_num
				//cstmt.setString(22,(String) hm.get("str_ref_sec_key_main") );//str_ref_sec_key_main
				cstmt.setString(23,(String) hm.get("str_ref_sec_key_line_num") );//str_ref_sec_key_line_num
				cstmt.registerOutParameter(24,Types.VARCHAR);//strerrorlevel
				cstmt.registerOutParameter(25,Types.VARCHAR);//strsysmessageid
				cstmt.registerOutParameter(26,Types.VARCHAR);//strerrortext 
				cstmt.execute();
				bl_strerrorlevel=checkForNull(cstmt.getString(24));
				bl_strsysmessageid=checkForNull(cstmt.getString(25));
				bl_strerrortext=checkForNull(cstmt.getString(26));
				err_desc=decodeProcedureErrorMsg(bl_strerrorlevel,bl_strsysmessageid,bl_strerrortext,"callAddBillSubServices()");

			}else{
				err_desc="RECORD_INSERTED";
			}
			if(!"RECORD_INSERTED".equals(err_desc)){
			connection.rollback();

		}else
		{
			connection.commit();
		}


		}catch(Exception e){
			err_desc=e.getMessage();
			e.printStackTrace();
		}finally{
			try{
				//if(rst!=null)rst.close();
				if(cstmt!=null)cstmt.close();
				//con.close();
			}catch(Exception e){}
		}
		return err_desc;
} 

	public String getBillSubRegnLineNum(String oper_num,String oper_line_num,String acc_type,Connection connection){

		//Added as local variable to function for 26068 by AnithaJ on 1/28/2011
		int result = 0;

		//String error_text = "";	//Commented Against AAKH-ICN-0008
		PreparedStatement pstmt= null;
		//Connection con = null;
		ResultSet rst = null;

		//Consumable -> C , Equipment-->B, CSSD --> S ,Implant-->I
			
		//String SQL = "SELECT MAX(NVL(BILL_SUB_REGN_LINE_NUM,0))+1 FROM OT_SURGICAL_ACCESSORIES WHERE OPER_NUM = ? AND OPER_LINE_NUM=? AND ACCESSORY_TYPE=?";
		if(result==0){
			String SQL = "SELECT NVL(MAX(TO_NUMBER(BILL_SUB_REGN_LINE_NUM)),0)+1 FROM OT_SURGICAL_ACCESSORIES WHERE OPER_NUM = ? AND OPER_LINE_NUM=? ";

			try{
				//con=ConnectionManager.getConnection();
				pstmt=connection.prepareStatement(SQL);
				pstmt.setString(1,oper_num);
				pstmt.setString(2,oper_line_num);
				rst = pstmt.executeQuery();
				while(rst.next()){
					result = rst.getInt(1);
				}
				if(rst !=null)rst.close();

			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}finally{
				try{
					if(pstmt!=null) pstmt.close();
					//if(connection!=null)
					//ConnectionManager.returnConnection(connection);//Changed on 04/07/13 against UAT5 - Connection Issue
					//if(con!=null) con.close();
				 }catch(Exception es){}
			}
		}else
			result++;
		
		if(result==0) 
			result=1;// Default value in case query returns no rows
		return ""+result;
	}


public String callBillingProcedure(HashMap map,HashMap bill_map,ArrayList tabData,boolean billing_installed_yn,Connection connection){
	String err_mesg = "";
	//Connection con = null;
	//String err_mesg_from_sub_services = "";	//Commented Against AAKH-ICN-0008
	PreparedStatement pstmt = null;
	HashMap hash=null;
	//Connection con = null;
	String key ="";
	//String key_line="";	//Commented Against AAKH-ICN-0008
	//String surgeon_doc_comp_yn=( String ) map.get( "surgeon_doc_comp_yn" ); //Commented Against AAKH-ICN-0008
	String pros_implants_complete_flag=( String ) map.get( "pros_implants_complete_flag" );
	//String oper_proc_comp=( String ) map.get("oper_proc_comp" ); 
	String st_interface_flag=( String ) map.get( "st_interface_flag" );
		int size=0;
	BillingManager billingManager = null;
	boolean flag = false;
	if(billing_installed_yn==true){

try{
	//con = ConnectionManager.getConnection();
	 size = tabData.size();
//connection=ConnectionManager.getConnection();
	 for(int i=0;i<size;i++){
		hash=(HashMap) tabData.get(i);
		if(hash!=null){
			key = (String) hash.get("table_name")+"_"+(String) hash.get("db_mode");

//if(pros_implants_complete_flag.equals("Y"))
		//	{
		if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_I")){

			//	key_line = getBillSubRegnLineNum( (String) hash.get("oper_num"),(String) hash.get("oper_line_no"),(String) hash.get("accessory_type") );

			if(st_interface_flag.equals("N"))
				{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_complete_flag);
				billingManager = BillingManager.intializeBillingManager(hash,map);
				//boolean acc_flag= billingManager.processBilling(map,key,pros_implants_complete_flag,"N", connection);//Connection //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 681");
				
				}
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_U")){
				if(st_interface_flag.equals("N"))
				{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_complete_flag);
				billingManager = BillingManager.intializeBillingManager(hash,map);
				//boolean acc_flag = billingManager.processBilling(map,key,pros_implants_complete_flag,"N", connection); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 689");
			}
			}else if(key.equals("OT_SURGICAL_ACCESSORIES_IMPLANTS_D")){
			if(st_interface_flag.equals("N"))
				{
				hash.put("BillRegnLineNum",(String)hash.get("key_line"));
				hash.put("BillRegnNum","I"+(String)hash.get("oper_num")+(String)hash.get("oper_line_no"));
				hash.put("nursing_doc",pros_implants_complete_flag);
				billingManager = BillingManager.intializeBillingManager(hash,map);
				//boolean acc_flag = billingManager.processBilling(map,key,pros_implants_complete_flag,"N", connection); //Commented Against AAKH-ICN-0008
				billingManager.tearDown("Rec Nursing Manager: 697");
				
			}
			}

		//}
		}
	 }

		
			err_mesg = checkForNull(GeneratePatientBill(map,bill_map,tabData,connection));//Connection Issue Modified Against ML-MMOH-CRF-1939-US4 
System.err.println("2268 err_mesg generetedpatientbill = "+err_mesg);
			if(err_mesg.equals("RECORD_INSERTED") ){
				err_mesg="RECORD_INSERTED";
				connection.commit();
			}else{
				connection.rollback();
				
			
			}
	}catch(Exception e){
	System.err.println("RecSurgeonManager: Err Msg in callBillingProcedure "+e.getMessage());
	flag = false;
	e.printStackTrace();
	err_mesg = e.getMessage();
}finally{
	try{
		pstmt.close();
		//connection.close();
	}
	catch(Exception e){}
 }


	}else{
		err_mesg = "RECORD_INSERTED";
	}
	
	 return err_mesg;
}



public String getMessage(String oper_desc,String mesg_id){
	Connection con = null;
	StringBuilder sbr = new StringBuilder();
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String err_desc = "";
	String err_mesg = "";
	String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
	try{
		//con = ConnectionDispenser.getConnection();
		con=ConnectionManager.getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,mesg_id);
		rst = pstmt.executeQuery();
		int count=0;
		 while(rst.next()){
			 ++count;
			err_desc=rst.getString(1);
			if(count > 1)
				err_mesg=sbr.append("##").append(oper_desc).append("##").append(err_desc).toString();
			else
				err_mesg=sbr.append(oper_desc).append("##").append(err_desc).toString();

		}

	}catch(Exception e){
		System.err.println("REC_SURG_MAN: Err Mesg in getMessage"+e);
	}
	finally{
		try{
			sbr.setLength(0);
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con != null)
			ConnectionManager.returnConnection(con);//Changed on 03/07/13 against UAT5 - Connection Issue
			//con.close();
		}catch(Exception e){}
	}
	return err_mesg;
}

public String getMessage(String mesg_id){
	Connection con = null;
	StringBuilder sbr = new StringBuilder();
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String err_desc = "";
//	String err_mesg = "";
	String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
	try{
		//con = ConnectionDispenser.getConnection();
		con=ConnectionManager.getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,mesg_id);
		rst = pstmt.executeQuery();
		int count=0;
		 while(rst.next()){
			 ++count;
			err_desc=rst.getString(1);
		}

	}catch(Exception e){
		System.err.println("REC_SURG_MAN: Err Mesg in getMessage"+e);
	}
	finally{
		try{
			sbr.setLength(0);
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();	//Added Against Common-ICN-0031
		}catch(Exception e){}
	}
	return err_desc;
}


public String callBillRecord( HashMap map ,Connection connection){
	//Connection con = ConnectionDispenser.getConnection();
	//Connection con=ConnectionManager.getConnection();//Connection
	CallableStatement cstmt = null;
	String err_level="";
	String sys_message_id="";
	String error_text="";
	String facility_id = (String)map.get("facility_id") ;
	String patient_id = (String)map.get("patient_id") ;
	String oper_num =  (String)map.get("oper_num") ;
	String order_id =  (String)map.get("order_id") ;
	String episode_id = (String)map.get("episode_id") ;
	String client_ip_address =  (String)map.get("login_at_ws_no") ;
	//String oper_date = (String)map.get("oper_date") ;
	String visit_id = (String)map.get("visit_id") ;
	String patient_class = (String)map.get("patient_class") ;
	String episode_type = (String)map.get("episode_type") ;
	//String err_code = "";
	String err_desc = "";
	String bl_episode_type = getBillingEpisodeType(patient_class,episode_type,connection);//Connection Issue
	//String surgeon_code = (String)map.get("surgeon_code") ;
	try{
		//con = ConnectionManager.getConnection();
		cstmt=connection.prepareCall("{call OT_BILLING_PACKAGE.OT_BL_INTERFACED_REC(?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,patient_id );
		cstmt.setString(3,bl_episode_type );
		cstmt.setString(4,episode_id );
		cstmt.setString(5,visit_id );
		cstmt.setString(6,order_id ) ;
		cstmt.setString(7,oper_num) ;
		cstmt.setString(8,client_ip_address );
		//out parameters
		cstmt.registerOutParameter(9,Types.VARCHAR);//v_err_code 
		cstmt.registerOutParameter(10,Types.VARCHAR);//v_sys_message_id
		cstmt.registerOutParameter(11,Types.VARCHAR);//v_error_text
		cstmt.registerOutParameter(12,Types.VARCHAR);//LANG_ERR_MESG_ID NOT ADDED IN THE PROCEDURE
		cstmt.execute();
		err_level = checkForNull(cstmt.getString(9));
		sys_message_id = checkForNull(cstmt.getString(10));
		error_text = checkForNull(cstmt.getString(11));
		err_desc=decodeProcedureErrorMsg(err_level,sys_message_id,error_text,"callBillRecord()");
		if(!"RECORD_INSERTED".equals(err_desc)){
			connection.rollback();
		}else
		{
			connection.commit();

		}

	}catch(Exception e){
		err_desc=e.getMessage();
		System.err.println("REC_SURG_MAN: Err Msg in 0"+e);
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
		}catch(Exception e){}
	}
   return err_desc;
}

public String checkForNull(String str){
	return (  str!=null && str.intern()!="null" )?str.trim():"";
}

public String callSurgeonAvgTime(HashMap map,Connection connection){
		//Connection con = null;
	   	CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		try{
			//con = ConnectionDispenser.getConnection();
			cstmt=connection.prepareCall("{call OT_SURGEON_AVG_TIME(?,?,?,null,null,null,?,?,?,?,?)}");
			cstmt.setString(1,(String)map.get("facility_id"));
			cstmt.setString(2,(String)map.get("oper_num"));
			cstmt.setString(3,(String)map.get("surgeon_code"));
			cstmt.setString(4,(String) map.get("login_user"));
			cstmt.setString(5,(String) map.get("login_at_ws_no"));
			cstmt.registerOutParameter(6,Types.VARCHAR);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
			cstmt.execute();
			status = cstmt.getString(6);
			if(status.equals("E")){
				error_text ="Oper Num ="+map.get("oper_num")+"::"+cstmt.getString(7);
				connection.rollback();
			}else if( status.equals("S") ){
				error_text ="RECORD_INSERTED";
				connection.commit();
			}
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                if(cstmt!=null) cstmt.close();
				//con.close();
             }catch(Exception es){es.printStackTrace();}
        }

		return error_text;
	}






	public String[] callOROrderLineUpdate(HashMap CommonData,HashMap hash,String mode,Connection connection){
		//Connection con = null;
	   	CallableStatement cstmt= null;
		String msg_text[] = new String[4];
		String langerr_msg_text = "";
		try{
			//con = ConnectionDispenser.getConnection();
			//con=ConnectionManager.getConnection();//Connection
			cstmt= connection.prepareCall("{call OT_OR_ORDER_LINE_UPD(?,?,?,?,?,?,?,?,?,null,null,null,null,null,?,?,?,?,?)}");
			cstmt.setString(1,(String)CommonData.get("facility_id"));
			cstmt.setString(2,(String)CommonData.get("order_id"));
			cstmt.setString(3,(String)hash.get("order_line_num"));
			cstmt.setString(4,mode);//insert or Delete flag
			cstmt.setString(5,(String)hash.get("oper_code"));
			cstmt.setString(6,(String)CommonData.get("surgeon_code"));
			cstmt.setString(7,(String)hash.get("oper_num"));
			cstmt.setString(8,(String)CommonData.get("login_user")); //changes if invoked from Slate
			cstmt.setString(9,(String)CommonData.get("login_at_ws_no"));
			cstmt.registerOutParameter(10,12);
			cstmt.registerOutParameter(11,12);
			cstmt.registerOutParameter(12,12);
			cstmt.registerOutParameter(13,12);
			cstmt.registerOutParameter(14,12);
			cstmt.execute();
			msg_text[0] = 	cstmt.getString(10);//order_type_code
			msg_text[1] = 	cstmt.getString(11);//order_line_num	
			msg_text[2] = 	cstmt.getString(12);//status
			msg_text[3] = 	cstmt.getString(13);//error_msg
			langerr_msg_text = 	cstmt.getString(14);//lang_error_txt
			if(msg_text[2].equals("S")){
				hash.put("order_id",(String)CommonData.get("order_id"));
				hash.put("order_line_num",msg_text[1]);
			}
			/*if(msg_text[2].equals("E")){
				error_text = langerr_msg_text;
				con.rollback();

			}else if( msg_text[2].equals("S") ){
				con.commit();
			}*/
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                if(cstmt!=null) cstmt.close();
             }catch(Exception es){es.printStackTrace();}
        }

		return msg_text;
	}

	public String decodeProcedureErrorMsg(String err_level,String sys_mesg_id,String err_text,String fname) {
		String err_msg =("".equals(sys_mesg_id))?"RECORD_INSERTED":getMessage(sys_mesg_id); 
		err_msg = ("".equals(err_text) && "RECORD_INSERTED".equals(err_msg) )?"RECORD_INSERTED":(!"".equals(sys_mesg_id))?err_msg:err_text;
		return err_msg;
	}

}




