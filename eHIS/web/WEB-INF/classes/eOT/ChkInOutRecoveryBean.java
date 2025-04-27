/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Clob;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import com.ehis.util.DateUtils;
import java.net.URLEncoder;
//MO-CRF-20147.13 Starts
//import java.util.* ;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import oracle.sql.CLOB;
//import java.sql.* ;
import java.io.* ;
//MO-CRF-20147.13 Ends
public class ChkInOutRecoveryBean extends OTAdapter implements Serializable {
	HashMap disposal_map = null;
	HashMap untoward_events_map = null;
	String slate_user_id = "";
	String oper_num = "";
	String recovery_in_out_flag = "";
	String rec_start_time="";
	String rec_end_time="";
	String transfer_ward_code="";
	String transfer_status="";
    String transfer_date_time="";
	String check_out_time="";
	String transfer_code="";
	String doc_comp_yn="";
	String check_out_flag="";
	String order_id="";
	String locale	= "";
	String rec_room_chrging_stg	= "";
	String patient_id	= "";
	String encounter_id="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String nature_type="";
	String nature_code="";
	String accession_num="";
	String accession_num_chrg_unit="";
	String rec_room_code="";
	String rec_room_desc="";
	String modified_charge_units="";
	String service_code="";
	String surgeon_code="";
	String charge_recovery_room_yn="";
	String rec_room_chrge_yn="";
	String calc_chrge_units="";
	String reason_inc_exe="";
	String inc_exe_blng_wdw="";
	String strQuery="";
	String bl_panel_str="";
	
public ChkInOutRecoveryBean() {
	try {
		doCommon();
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public void doCommon() throws Exception {
}

public void clear(){
	super.clear();
	disposal_map = null;
	untoward_events_map = null;
	slate_user_id = "";
	oper_num = "";
	recovery_in_out_flag = "";
	transfer_ward_code="";
	transfer_status="";
	transfer_date_time="";
	rec_start_time="";
	rec_end_time = "";
	check_out_time="";
	transfer_code="";
	doc_comp_yn="";
	check_out_flag="";
	order_id="";
}

public void setAll(Hashtable hash)
{
	mode = (String)hash.get("mode");
	slate_user_id = (String)hash.get("slate_user_id");
	oper_num = (String)hash.get("oper_num");
	order_id = (String)hash.get("order_id");
	recovery_in_out_flag = (String)hash.get("recovery_in_out_flag");
	rec_room_code = (String) hash.get("rec_room_code");
	if(recovery_in_out_flag.equals("CHECK_IN_RECO")){
		rec_start_time = DateUtils.convertDate((String) hash.get("start_date"),"DMY",locale,"en")+" "+(String) hash.get("start_time");
		rec_end_time = ((String)hash.get("end_date")+" "+(String) hash.get("end_time")).trim();
		if(rec_end_time.length()>0)
			rec_end_time = DateUtils.convertDate(rec_end_time,"DMYHM",locale,"en");
	}

	if(recovery_in_out_flag.equalsIgnoreCase("CHECK_OUT_RECO")){
		check_out_time = (String)hash.get("check_out_time");
		rec_start_time = (String) hash.get("start_date")+" "+(String)hash.get("start_time");
		rec_end_time = DateUtils.convertDate((String) hash.get("end_date"),"DMY",locale,"en")+" "+(String) hash.get("end_time");
		transfer_code = (String) hash.get("transfer");
		transfer_ward_code = (String) hash.get("ward_code");
		rec_room_chrging_stg = (String) hash.get("rec_room_chrging_stg");
		patient_id = (String) hash.get("patient_id");
		encounter_id = (String) hash.get("encounter_id");
		episode_type = (String) hash.get("episode_type");
		visit_id = (String) hash.get("visit_id");
		nature_type = (String) hash.get("nature_type");
		nature_code = (String) hash.get("nature_code");
		accession_num_chrg_unit = (String) hash.get("accession_num_chrg_unit");
		modified_charge_units = (String) hash.get("modified_charge_units");
		service_code = (String) hash.get("service_code");
		surgeon_code = (String) hash.get("surgeon_code");
		rec_room_desc = (String) hash.get("rec_room_desc");
		charge_recovery_room_yn = (String) hash.get("charge_recovery_room_yn");
		rec_room_chrge_yn = (String) hash.get("rec_room_chrge_yn");
		episode_id = (String) hash.get("episode_id");
		calc_chrge_units = (String) hash.get("calc_chrge_units");
		reason_inc_exe = (String) hash.get("reason_inc_exe");
		inc_exe_blng_wdw = (String) hash.get("inc_exe_blng_wdw");
		bl_panel_str = (String) hash.get("bl_panel_str");

		transfer_date_time= DateUtils.convertDate((String) hash.get("transfer_date"),"DMY",locale,"en")+" "+(String) hash.get("transfer_time");
		if("M".equals(transfer_code)){
		//Modified by MuthuN against 29152 on 13-9-12
			rec_start_time = (String) hash.get("start_date")+" "+(String)hash.get("start_time");
			rec_end_time = DateUtils.convertDate((String) hash.get("end_date"),"DMY",locale,"en")+" "+(String) hash.get("end_time");
		//Modified by MuthuN against 29152 on 13-9-12
		}
		transfer_status = (String) hash.get("status");
		doc_comp_yn= (String) hash.get("doc_comp_yn");
		check_out_flag = (String) hash.get("check_out_flag");

		String facility_id	= (String) hash.get("facility_id");
		Connection conn =	 null;
		PreparedStatement pstmta = null;
		ResultSet rsa = null;
	
	try
	{
		strQuery	=	"SELECT DECODE(surg_doc_comp_yn,'Y',DECODE(nurs_doc_comp_yn,'Y',DECODE(anes_doc_comp_yn,'Y','Y'),'N'),'N') doc_comp_yn FROM (SELECT DECODE(NVL(CHK_SURGEON_DOC_CMPL_FOR_STS,'N'),'N','Y',NVL(SURGEON_DOC_COMP_YN,'N')) surg_doc_comp_yn, DECODE(NVL(CHK_NURSING_DOC_CMPL_FOR_STS,'N'),'N','Y',NVL(NURSING_DOC_COMP_YN,'N')) nurs_doc_comp_yn, DECODE(NVL(CHK_INTRA_DOC_CMPL_FOR_STS,'N'),'N','Y',NVL(ANAESTHETIST_DOC_COMP_YN,'N')) anes_doc_comp_yn FROM ot_post_oper_hdr a,ot_param_for_facility b WHERE a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = ? AND a.oper_num = ?)";
		conn = 	getConnection() ;

		pstmta = conn.prepareStatement(strQuery);

		pstmta.clearParameters();
		pstmta.setString(1,facility_id);
		pstmta.setString(2,oper_num);

		rsa = pstmta.executeQuery();

		if(rsa != null && rsa.next() )
			doc_comp_yn	= rsa.getString(1);
	}
	catch (Exception e1)
	{
		e1.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			closeResultSet( rsa );
			closeStatement( pstmta );
			closeConnection( conn );
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
}
}

public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	String message = "";
	// Keep here all the Database Validations/Alerts/Warnings before commiting the transaction.
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", message ) ;
	return map;
}
	  
//Used to get Oper_num from Post Anaesthesia 
public String getOperNum(String order_id){

	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	String oper_num = "";
	locale = getProperties().getProperty("LOCALE");
	String SQL = "SELECT OPER_NUM FROM OT_POST_OPER_HDR WHERE ORDER_ID=?";
	try{
		connection			= getConnection() ;
		pstmt				= connection.prepareStatement(SQL);
		pstmt.setString(1,order_id);
		resultSet	= pstmt.executeQuery();
		while(resultSet.next()){
			oper_num = resultSet.getString(1);
		}
		if(pstmt!=null) pstmt.close();
		if(pstmt!=null) pstmt.close();
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
	}
	return oper_num;
}

public void loadUntowardEvtDtls(String oper_num){
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	locale = getProperties().getProperty("LOCALE");
	String SQL = "SELECT UNUSUAL_OCCUR_CODE,GET_DESC(?,'OT_UNUSUAL_OCCUR_CODE_LANG_VW','SHORT_DESC','UNUSUAL_OCCUR_CODE',UNUSUAL_OCCUR_CODE),ACTION_REMARKS,GEN_REMARKS FROM OT_POST_OPER_UNTOWARD WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
	try{
		connection			= getConnection() ;
		pstmt				= connection.prepareStatement(SQL);
		pstmt.setString(1,locale);
		pstmt.setString(2,login_facility_id);
		pstmt.setString(3,oper_num);
		resultSet	= pstmt.executeQuery();
		while(resultSet.next()){
			HashMap map = new HashMap();
			map.put("oper_num",oper_num);
			map.put("slate_user_id",login_by_id);
			map.put("unusual_occur_code",resultSet.getString(1) );
			map.put("unusual_occur_desc",resultSet.getString(2) );
			map.put("action_remarks", resultSet.getString(3) );
			map.put("general_remarks",resultSet.getString(4) );
			map.put("db_mode","L" );
			recordUntowardEventsDtls(map);
		}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
	}

}

public HashMap insert(){
	HashMap map = new HashMap() ;
	boolean transaction_flag = true;
	String err_text = "";
	try{	
			if(recovery_in_out_flag.equalsIgnoreCase("CHECK_IN_RECO")){
			if(disposal_map!=null && disposal_map.size()>0){
				transaction_flag = insertChkInDisposalDtls(oper_num,slate_user_id);
			}
			if(untoward_events_map!=null && untoward_events_map.size()>0){
				transaction_flag=insertUntowardEvtsDtls();
			}
			  if(transaction_flag==true)
					err_text = updateCheckInRecoveryStatus(oper_num,slate_user_id,rec_start_time,rec_end_time,rec_room_code); 
		}else if(recovery_in_out_flag.equalsIgnoreCase("CHECK_OUT_RECO")){		
			Connection connection = getConnection();
			err_text = updateCheckOutRecoveryStatus(connection,oper_num,slate_user_id,check_out_time,rec_start_time,transfer_code,transfer_date_time,transfer_ward_code,transfer_status,doc_comp_yn,check_out_flag,rec_room_chrging_stg,patient_id,encounter_id,episode_id,episode_type, visit_id,nature_type,nature_code,accession_num_chrg_unit,rec_room_code,modified_charge_units,service_code,surgeon_code,charge_recovery_room_yn,rec_room_chrge_yn,calc_chrge_units,bl_panel_str);
		
			if("RECORD_INSERTED".equals(err_text)){
				if("Y".equals(check_out_flag) && "CHECK_OUT_RECO".equals(recovery_in_out_flag) ){
					boolean history_build_flag = buildHistory(connection,login_facility_id,oper_num,order_id);
					err_text = (history_build_flag)?"RECORD_INSERTED":"Failed in history building";
					transaction_flag = err_text.equals("RECORD_INSERTED")?true:false; 
				}
			}
			closeConnection( connection );
		}	
	if(!("RECORD_INSERTED").equals(err_text) || transaction_flag==false){
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", err_text ) ;//commented by below line and added this line for showing err message to front end Specially for Billing Messange on 23/05/2009 by Sathish.k for CRF-224
	}else{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", "RECORD_INSERTED") ;
	}	
	}catch(Exception e) {
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "Operation Failed" ) ;
		e.printStackTrace() ;
	}
	finally {
		clear();
		try {}
		catch( Exception ee ){
		ee.printStackTrace() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "Operation Failed" ) ;
		}
	}
	return map ;
}

public ArrayList getSysDateTime(){
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	ArrayList result = new ArrayList();
	locale = getProperties().getProperty("LOCALE");

	try{
		connection			= getConnection() ;
		pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		resultSet			= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			result.add(DateUtils.convertDate(resultSet.getString("DATE_TIME"),"DMYHM","en",locale));
			result.add(DateUtils.convertDate(resultSet.getString("CURRENT_DATE"),"DMY","en",locale));
			result.add(resultSet.getString("HOURS_MTS"));
		}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		 }catch(Exception es){es.printStackTrace();}
	}
	return result;
}

public String getRecoveryCheckInTime(String oper_num){
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	String result = "";
	locale =(String) getProperties().getProperty("LOCALE");
	try{
		connection			= getConnection() ;
		pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHK_IN_RECOVERY_SELECT")) ;
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2, oper_num);
		resultSet			= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			result = DateUtils.convertDate(resultSet.getString("RECOVERY_TIME"),"DMYHM","en",locale);
		}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		 }catch(Exception es){es.printStackTrace();}
	}
	return result;
}

public void loadDisposalDtls(String oper_num){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	HashMap map = null;
	try{
		connection = getConnection();
		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_DISPOSAL_DTLS_SELECT"));
		pstmt.setString(1,locale);
		pstmt.setString(2,login_facility_id);
		pstmt.setString(3,oper_num);
		pstmt.setString(4,locale);
		resultSet= pstmt.executeQuery();

		while(resultSet.next()){	
			map = new HashMap();
			map.put("oper_num",oper_num);
			map.put("anatomical_site_code", resultSet.getString("SITE_CODE"));
			map.put("anatomical_site_desc", resultSet.getString("SITE_DESC"));
			map.put("disposal_code", resultSet.getString("DISP_CODE"));
			map.put("disposal_desc", resultSet.getString("DISP_DESC"));
			map.put("update_insert_flag","LOAD"); // posible values LOAD, UPDATE, INSERT, DELETE, IGNORE
			map.put("given_by",CommonBean.checkForNull(resultSet.getString("GIVEN")));
			map.put("received_by",CommonBean.checkForNull(resultSet.getString("RECEIVED")));
			recordDisposalDtls(map);
		}						
	}catch (Exception e){
		e.printStackTrace() ;
	}
	finally{
	  try{
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection);
	  }catch(Exception e){
		e.printStackTrace();
	  System.err.println("439,ChkInOutRecoveryBean Exception====>>"+e);	
	  }
	}
 }

public void recordDisposalDtls(HashMap hmap){
	if(disposal_map==null)
		disposal_map = new HashMap();
	int rowId = (disposal_map.size())+1;
	disposal_map.put(rowId+"",hmap);
}

public HashMap getDisposalDtls(){
	if (disposal_map==null)
		return new HashMap();
	else
		return disposal_map;
}

public HashMap getDisposalDtls(String key){
	return (HashMap)disposal_map.get(key);
}

public void updateDisposalDtls(String key, HashMap hmap){
	if(disposal_map.containsKey(key))
	disposal_map.put(key,hmap);

}

public void removeDisposalDtls(String key){
	HashMap temp_map = new HashMap();
	temp_map = (HashMap)disposal_map.get(key);
	String update_insert_flag = (String)temp_map.get("update_insert_flag");
	if(update_insert_flag.equals("INSERT"))
		temp_map.put("update_insert_flag","IGNORE");
	else if(update_insert_flag.equals("UPDATE") || update_insert_flag.equals("LOAD"))
		temp_map.put("update_insert_flag","DELETE");
}

public void removeAllDisposalDtls(){
	disposal_map = null;
}

// This method is used only for Check-In to Recovery Function.
public boolean insertChkInDisposalDtls(String oper_num,String slate_user_id){
	Connection connection=null;
	PreparedStatement pstmt=null;
	int size = disposal_map.size();
	boolean transaction_flag = true;
	String anatomical_site_code = "";
	String disposal_code = "";
	String update_insert_flag ="";
	try{
	 connection = getConnection();
	 HashMap map = new HashMap();
	if(size>0){
	pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHK_IN_RECOVERY_INSERT"));
	  for(int i=1; i<=size;i++){
			map = (HashMap) disposal_map.get(i+"");
			update_insert_flag = (String)map.get("update_insert_flag");
			if(update_insert_flag.equals("INSERT")){
				anatomical_site_code = (String)map.get("anatomical_site_code");
				disposal_code = (String)map.get("disposal_code");
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,oper_num);
				pstmt.setString(3,anatomical_site_code);
				pstmt.setString(4,disposal_code);
				pstmt.setString(5,slate_user_id);		
				pstmt.setString(6,login_at_ws_no);		
				pstmt.setString(7,login_facility_id);				  
				pstmt.setString(8,slate_user_id);				  
				pstmt.setString(9,login_at_ws_no);		
				pstmt.setString(10,login_facility_id);
				pstmt.setString(11,(String)map.get("given_by"));
				pstmt.setString(12,(String)map.get("received_by"));
				pstmt.execute();
			}
		}
	}				
 }
 catch(Exception e){
	 transaction_flag = false;
		e.printStackTrace() ;
		System.err.println("536,ChkInOutRecoveryBean Exception====>>"+e);	
 }
 finally {
	 try{
	 pstmt.close();
	 //connection.close();
	 closeConnection( connection ); //Common-ICN-0052
	 }
	 catch(Exception e){
		e.printStackTrace();
	 }
 }
return transaction_flag;
}

// This method is used only for Check Out Recovery Function.
public boolean insertChkOutDisposalDtls(String oper_num,String slate_user_id){
	Connection connection=null;
	PreparedStatement pstmt=null;
	int size = disposal_map.size();
	boolean transaction_flag = true;
	String anatomical_site_code = "";
	String disposal_code = "";
	String update_insert_flag = "";
	try{
	 connection = getConnection();
	 HashMap map = new HashMap();
	if(size>0){
	pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHK_IN_RECOVERY_INSERT"));
	  for(int i=1; i<=size;i++){
			map = (HashMap) disposal_map.get(i+"");
			update_insert_flag = (String)map.get("update_insert_flag");
			if(update_insert_flag.equals("INSERT")){
				anatomical_site_code = (String)map.get("anatomical_site_code");
				disposal_code = (String)map.get("disposal_code");
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,oper_num);
				pstmt.setString(3,anatomical_site_code);
				pstmt.setString(4,disposal_code);
				pstmt.setString(5,slate_user_id);		
				pstmt.setString(6,login_at_ws_no);		
				pstmt.setString(7,login_facility_id);				  
				pstmt.setString(8,slate_user_id);				  
				pstmt.setString(9,login_at_ws_no);		
				pstmt.setString(10,login_facility_id);	
				pstmt.setString(11,(String)map.get("given_by"));
				pstmt.setString(12,(String)map.get("received_by"));
				pstmt.execute();
			}
		}
	}				
 }
 catch(Exception e){
	 transaction_flag = false;
		e.printStackTrace() ;
 }
 finally {
	 try{
	 pstmt.close();
	 //connection.close();
	  closeConnection( connection ); //Common-ICN-0052
	 }
	 catch(Exception e){
		e.printStackTrace();
	 }
 }
return transaction_flag;
}

// This method is used only for Check Out Recovery Function.
public boolean updateChkOutDisposalDtls(String oper_num,String slate_user_id){
		Connection connection=null;
		PreparedStatement pstmt=null;
		int size = disposal_map.size();
		boolean transaction_flag = true;
        HashMap map = new HashMap();
		String update_insert_flag = "";
		try{
		 connection = getConnection();
		if(size>0){
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_DISPOSAL_DTLS_UPDATE"));
		  for(int i=1; i<=size;i++){
				map = (HashMap) disposal_map.get(i+"");
				update_insert_flag = (String)map.get("update_insert_flag");
				if(update_insert_flag.equals("UPDATE")){
					pstmt.setString(1,(String)map.get("anatomical_site_code"));
					pstmt.setString(2,(String)map.get("disposal_code"));
					pstmt.setString(3,(String)map.get("given_by"));
					pstmt.setString(4,(String)map.get("received_by"));
					pstmt.setString(5,slate_user_id);		
					pstmt.setString(6,login_at_ws_no);		
					pstmt.setString(7,login_facility_id);				  
					pstmt.setString(8,login_facility_id);
					pstmt.setString(9,oper_num);
					pstmt.execute();
				}
			}
		}				
	 }
	 catch(Exception e){
		 transaction_flag = false;
            e.printStackTrace() ;
			System.err.println("634, ChkInOutRecoveryBean Exception===="+e);	
	 }
	 finally {
		 try{
		 pstmt.close();
		 //connection.close();
		  closeConnection( connection ); //Common-ICN-0052
		 }
		 catch(Exception e){
			e.printStackTrace();
		 }
	 }
	return transaction_flag;
}

public boolean deleteChkOutDisposalDtls(String oper_num){
		Connection connection=null;
		PreparedStatement pstmt=null;
		int size = disposal_map.size();
		boolean transaction_flag = true;
        HashMap map = new HashMap();
		String update_insert_flag = "";
		try{
		 connection = getConnection();
		if(size>0){
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_DISPOSAL_DTLS_DELETE"));
		  for(int i=1; i<=size;i++){
				map = (HashMap) disposal_map.get(i+"");
				update_insert_flag = (String)map.get("update_insert_flag");
				if(update_insert_flag.equals("DELETE")){
					pstmt.setString(1,login_facility_id);
					pstmt.setString(2,oper_num);
					pstmt.setString(3,(String)map.get("anatomical_site_code"));
					pstmt.setString(4,(String)map.get("disposal_code"));
					pstmt.executeUpdate();
				}
			}
		}				
		connection.commit();
	 }
	 catch(Exception e){
		 transaction_flag = false;
            e.printStackTrace() ;
			System.err.println("676, ChkInOutRecoveryBean Exception===="+e);	
	 }
	 finally {
		 try{
		 pstmt.close();
		// connection.close();
		 closeConnection( connection ); //Common-ICN-0052
		 }
		 catch(Exception e){
			e.printStackTrace();
		 }
	 }
	return transaction_flag;
}

public void recordUntowardEventsDtls(HashMap hmap){
	if(untoward_events_map==null)
		untoward_events_map = new HashMap();
	int rowId = (untoward_events_map.size())+1;
	untoward_events_map.put(rowId+"",hmap);
}

public HashMap getUntowardEventsDtls(){
	if (untoward_events_map==null)
		return new HashMap();
	else
		return untoward_events_map;
}

public void updateUntowardEventsDtls(String key, HashMap hmap){
	if(untoward_events_map.containsKey(key))
	untoward_events_map.put(key,hmap);

}

public void removeUntowardEventsDtls(String key){
	HashMap temp_map = new HashMap();
	int count = 0;
	HashMap map = (HashMap) untoward_events_map.get(key);//.get("db_mode");
	String db_mode = (String) map.get("db_mode");
	if("I".equals(db_mode) ){
			for(int i=1;i<=untoward_events_map.size();i++){
			if(i!=Integer.parseInt(key)){
				count++;
				temp_map.put(count+"",untoward_events_map.get(i+""));
			}
		}
		untoward_events_map = temp_map;
	}else{
		temp_map = (HashMap) untoward_events_map.get(key);
		temp_map.put("db_mode","D");
	}
}

public void removeAllUntowardEventDtls(){
	untoward_events_map = null;
}

//Modified Insert Method....
public boolean insertUntowardEvtsDtls(){
	int size = untoward_events_map.size();
	boolean transaction_flag = true;
	HashMap map = new HashMap();

    if(size>0){
			for(int i=1; i<=size&&transaction_flag==true;i++){
				map = (HashMap) untoward_events_map.get(i+"");
				mode = (String) map.get("db_mode");
				if("I".equals(mode)){
						transaction_flag =insertUntowardEvtsDtlsDB(map);
				}else if ("U".equals(mode)){
						transaction_flag=UpdateUntowardEvtsDtlsDB(map);
				}else if ("D".equals(mode)){
						transaction_flag =deleteUntowardEvtsDtlsDB(map);
				}
			}
		}
		return transaction_flag;
}

//This method will be used from PostAnesthesia Function
public boolean insertUntowardEvtsDtlsDB(HashMap map){
	Connection connection=null;
	PreparedStatement pstmt=null;
	boolean transaction_flag = true;
	String oper_num = "";
	String unusual_occur_code= "";
	String general_remarks = "";
	String action_remarks = "";
	try{
		connection = getConnection();
        	pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHK_IN_RECOVERY_INSERT1"));
		 	oper_num=(String)map.get("oper_num");
			unusual_occur_code = (String)map.get("unusual_occur_code");
			action_remarks = (String)map.get("action_remarks");
			general_remarks = (String)map.get("general_remarks");
			//action_remarks=java.net.URLEncoder.encode( action_remarks,"UTF-8" );
			//general_remarks=java.net.URLEncoder.encode( general_remarks,"UTF-8" );
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,oper_num);
			pstmt.setString(3,unusual_occur_code);
			pstmt.setString(4,action_remarks);
			pstmt.setString(5,general_remarks);
			pstmt.setString(6,login_by_id);		
			pstmt.setString(7,login_at_ws_no);		
			pstmt.setString(8,login_facility_id);				  
			pstmt.setString(9,login_by_id);				  
			pstmt.setString(10,login_at_ws_no);		
			pstmt.setString(11,login_facility_id);	
			int flag = pstmt.executeUpdate();
			if(flag>0){
				connection.commit();
			}else{
				connection.rollback();
				transaction_flag = false;
			}
	 }catch(Exception e){
		 transaction_flag = false;
            e.printStackTrace() ;
	 }finally {
		 try{
			pstmt.close();
			//connection.close();
			 closeConnection( connection ); //Common-ICN-0052
		}
		catch(Exception e){
			e.printStackTrace();
		}
	 }
	return transaction_flag;
}

//This method will be used from PostAnesthesia Function
public boolean UpdateUntowardEvtsDtlsDB(HashMap map){
	Connection connection=null;
	PreparedStatement pstmt=null;
	boolean transaction_flag = true;
	String oper_num = "";
	String unusual_occur_code= "";
	String general_remarks = "";
	String action_remarks = "";
	String SQL="UPDATE OT_POST_OPER_UNTOWARD SET ACTION_REMARKS=?, GEN_REMARKS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND UNUSUAL_OCCUR_CODE=?";
	try{
		connection = getConnection();
       	pstmt = connection.prepareStatement(SQL);
		oper_num=(String)map.get("oper_num");
		unusual_occur_code = (String)map.get("unusual_occur_code");
		action_remarks = (String)map.get("action_remarks");
		general_remarks = (String)map.get("general_remarks");
		pstmt.setString(1,action_remarks);
		pstmt.setString(2,general_remarks);
		pstmt.setString(3,login_by_id);				  
		pstmt.setString(4,login_at_ws_no);		
		pstmt.setString(5,login_facility_id);	
		pstmt.setString(6,login_facility_id);
		pstmt.setString(7,oper_num);
		pstmt.setString(8,unusual_occur_code);
		int flag = pstmt.executeUpdate();
		if(flag>0){
			connection.commit();
		}else{
			connection.rollback();
			transaction_flag = false;
		}
	 }catch(Exception e){
		 transaction_flag = false;
            e.printStackTrace() ;
			System.err.println("844, ChkInOutRecoveryBean Exception===="+e);	
	 }finally {
		 try{
			pstmt.close();
			//connection.close();
			 closeConnection( connection ); //Common-ICN-0052
		}
		catch(Exception e){
			e.printStackTrace();
		}
	 }
	return transaction_flag;
}

//This method will be used from PostAnesthesia Function
public boolean deleteUntowardEvtsDtlsDB(HashMap map){
	Connection connection=null;
	PreparedStatement pstmt=null;
	boolean transaction_flag = true;
	String oper_num = "";
	String unusual_occur_code= "";
	String general_remarks = "";
	String action_remarks = "";
	String SQL="DELETE FROM  OT_POST_OPER_UNTOWARD  WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND UNUSUAL_OCCUR_CODE=?";
	try{
		connection = getConnection();
        pstmt = connection.prepareStatement(SQL);
		oper_num=(String)map.get("oper_num");
		unusual_occur_code = (String)map.get("unusual_occur_code");
		action_remarks = (String)map.get("action_remarks");
		general_remarks = (String)map.get("general_remarks");
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,unusual_occur_code);
		int flag = pstmt.executeUpdate();
		if(flag>0){
			connection.commit();
		}else{
			connection.rollback();
			transaction_flag = false;
		}
	 }catch(Exception e){
		 transaction_flag = false;
            e.printStackTrace() ;
	 }finally {
		 try{
			pstmt.close();
			//connection.close();
			 closeConnection( connection ); //Common-ICN-0052
		}
		catch(Exception e){
			e.printStackTrace();
		}
	 }
	return transaction_flag;
}

public String updateCheckInRecoveryStatus(String oper_num, String slate_user_id,String rec_start_time,String rec_end_time,String rec_room_code){
Connection connection  = null;
CallableStatement cstmt= null;
String error_text = "";
String status	  = "";
try{
		connection	= getConnection() ;
		cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),?,null,null,null,null,null,null,?,?,null,null,null,null,null,null,null,null,null,null,null,?,?,?,?,?,?)}");
		cstmt.setString(1,"06");	//Function ID
		cstmt.setString(2,login_facility_id);
		cstmt.setString(3,oper_num);
		cstmt.setString(4,"N"); // DOC_COMPL_YN	
		// the null fields are additional fields...not used in this function
		cstmt.setString(5,rec_start_time); // ADDNL_FLD7	
		cstmt.setString(6,rec_end_time); // ADDNL_FLD8
		cstmt.setString(7,rec_room_code); // ADDNL_FLD8

		cstmt.setString(8,slate_user_id);
		cstmt.setString(9,login_at_ws_no);

		cstmt.registerOutParameter(10,Types.VARCHAR);
		cstmt.registerOutParameter(11,Types.VARCHAR);	
		cstmt.registerOutParameter(12,Types.VARCHAR);	
		cstmt.execute();
		connection.commit();
		status = cstmt.getString(10);
		if(status!=null && !status.equals("null") && !status.equals("")){
			if(status.equals("E")){
				error_text = cstmt.getString(11);
				error_text = cstmt.getString(12); //Lang error
			}else
				error_text = "RECORD_INSERTED";
		}else
			error_text = "RECORD_INSERTED";
	}
	catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			closeStatement( cstmt ) ;
			closeConnection( connection );
		 }catch(Exception es){es.printStackTrace();}
	}

	return error_text;
}

public String updateCheckOutRecoveryStatus(Connection connection,String oper_num, String slate_user_id, String check_out_time,String rec_start_time,String transfer_code,String transfer_date_time,String transfer_ward_code,String transfer_status,String doc_comp_yn, String check_out_flag,String rec_room_chrging_stg,String patient_id,String encounter_id,String episode_id,String episode_type,String visit_id,String nature_type,String nature_code,String accession_num_chrg_unit,String rec_room_code,String modified_charge_units,String service_code,String surgeon_code,String charge_recovery_room_yn,String rec_room_chrge_yn,String calc_chrge_units,String bl_panel_str){

	CallableStatement cstmt= null;
	String error_text = "";
	String status	  = "";
	String flag ="";
	
	try{
			ArrayList date_list = getSysDateTime();
			String cur_date = (String)date_list.get(1);
			cur_date = DateUtils.convertDate(cur_date,"DMY",locale,"en");
			
			if(("N").equals(check_out_flag))
            transfer_ward_code=null;

			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,?,?,null,null,null,null,null,null,null,?,?,?,?,?,?,null,null,null,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,"27");	//Function ID
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,oper_num);
			cstmt.setString(4,cur_date+" "+check_out_time);
			cstmt.setString(5,doc_comp_yn); // DOC_COMPL_YN	
			// the null fields are additional fields...not used in this function
			cstmt.setString(6,rec_end_time); // ADDN FIELD 8
			cstmt.setString(7,transfer_code); // ADDN FIELD 9	
			cstmt.setString(8,transfer_date_time); // ADDN FIELD 10	
			cstmt.setString(9,transfer_ward_code); // ADDN FIELD 11		
			cstmt.setString(10,transfer_status); // ADDN FIELD 12		
			cstmt.setString(11,check_out_flag); // ADDN FIELD 13
			cstmt.setString(12,accession_num_chrg_unit); // ADDN FIELD 17
			cstmt.setString(13,modified_charge_units); // ADDN FIELD 18
			cstmt.setString(14,calc_chrge_units); // ADDN FIELD 19
			cstmt.setString(15,rec_room_code);// ADDN FIELD 20
			cstmt.setString(16,slate_user_id);
			cstmt.setString(17,login_at_ws_no);			
			cstmt.registerOutParameter(18,Types.VARCHAR);
			cstmt.registerOutParameter(19,Types.VARCHAR);	
			cstmt.registerOutParameter(20,Types.VARCHAR);	
			cstmt.execute();
			//connection.commit();
			status = cstmt.getString(18);
			if(status.equals("E"))
		       {
				error_text = CommonBean.checkForNull(cstmt.getString(20));
			    connection.rollback();
			   }
			else
		       {				
				if(("Y").equals(charge_recovery_room_yn) && ("Y").equals(rec_room_chrge_yn)){
					flag=updateRecRoomPopulateIntercaceRecs(connection,oper_num,slate_user_id,check_out_time,rec_start_time,transfer_code,transfer_date_time,transfer_ward_code,transfer_status,doc_comp_yn,check_out_flag,rec_room_chrging_stg,patient_id,encounter_id,episode_id,episode_type, visit_id,nature_type,nature_code,accession_num_chrg_unit,rec_room_code,modified_charge_units,service_code,surgeon_code,bl_panel_str);
					if(!"SUCCESS".equals(flag) ) {
                     error_text+=flag;
					}else{
						 error_text = "RECORD_INSERTED";}
				 }else
				 {
			     error_text = "RECORD_INSERTED";
                 connection.commit();
				 }			    
			   }			
		}
		catch ( Exception e ) {
	        e.printStackTrace();
			System.err.println("1075, ChkInOutRecoveryBean Exception===="+e);
			
		}finally {
            try{
                closeStatement( cstmt ) ;
             }catch(Exception es){es.printStackTrace();
			 System.err.println("1082, ChkInOutRecoveryBean Exception===="+es);
			 }
        }
		return error_text;
	}

public String updateRecRoomPopulateIntercaceRecs(Connection connection,String oper_num, String slate_user_id, String check_out_time,String rec_start_time,String transfer_code,String transfer_date_time,String transfer_ward_code,String transfer_status,String doc_comp_yn, String check_out_flag,String rec_room_chrging_stg,String patient_id,String encounter_id,String episode_id,String episode_type,String visit_id,String nature_type,String nature_code,String accession_num_chrg_unit,String rec_room_code,String modified_charge_units,String service_code,String surgeon_code,String bl_panel_str){

		CallableStatement cstmt= null;
		locale	= (String) getProperties().getProperty("LOCALE");
		String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";
		String flag ="";

		try{
		String pract_code_val = "";
		String[] pract_arr=null;

	  if(!bl_panel_str.equals(""))
		{
			pract_arr=bl_panel_str.split("#");
			pract_code_val=pract_arr[5];
		}
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,?,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			
			cstmt.setString(1,"OTR");	
			cstmt.setString(2,login_facility_id);			
			cstmt.setString(3,episode_type);//Episode Type			
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,accession_num_chrg_unit);//accession_num
		    cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,accession_num_chrg_unit);//accession_num
			cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,service_code);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,rec_room_code);//rec_room_code
			cstmt.setString(16,rec_room_desc);//rec_room_desc
			cstmt.setString(17,modified_charge_units);//modified_charge_units

			if(!pract_code_val.equals("") ||!pract_code_val.equals(null) )
			{			
					cstmt.setString(18,pract_code_val );
			}else
			{
					cstmt.setString(18,surgeon_code );
			}				

			cstmt.setString(19,"P");
			cstmt.setString(20,inc_exe_blng_wdw);//reason_inc_exc
			cstmt.setString(21,reason_inc_exe);//inc_exe_blng_wdw
			cstmt.setString(22,slate_user_id);//login_id  ---> to be change
			cstmt.setString(23,login_at_ws_no);//ws_no
			cstmt.registerOutParameter(24,Types.VARCHAR);
			cstmt.registerOutParameter(25,Types.VARCHAR);	
			cstmt.registerOutParameter(26,Types.VARCHAR);

			System.err.println("1187==Before==Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs===="+System.currentTimeMillis());
			cstmt.execute();
			System.err.println("1189==After==Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs====="+System.currentTimeMillis());
			err_text+=CommonBean.checkForNull(cstmt.getString(24));
			err_text+=CommonBean.checkForNull(cstmt.getString(25));
			err_text+=CommonBean.checkForNull(cstmt.getString(26));
			mesg_id  =CommonBean.checkForNull(cstmt.getString(25));
			System.err.println("1191,err_text===="+err_text);	
			System.err.println("1192,mesg_id===="+mesg_id);	
			if(!err_text.equals("")){
				err_desc+=getMessag(connection,mesg_id);   //Added by lakshmi scf-7752
				System.err.println("1196,err_desc===="+err_desc);	
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				connection.rollback();
			}else{
				if(("R".equals(rec_room_chrging_stg)== true) && ("Y".equals(check_out_flag)==true)){
					flag=updateRecRoomPopulateIntercaceRecsOTF(connection,oper_num,slate_user_id,check_out_time,rec_start_time,transfer_code,transfer_date_time,transfer_ward_code,transfer_status,doc_comp_yn,check_out_flag,rec_room_chrging_stg,patient_id,encounter_id,episode_id,episode_type, visit_id,nature_type,nature_code,accession_num_chrg_unit,rec_room_code,rec_room_desc,modified_charge_units,service_code,surgeon_code,bl_panel_str);
					if(!"SUCCESS".equals(flag) ) {
                     err_desc+=flag;
					 System.err.println("1207,err_desc===="+err_desc);	
					}
				}else
					connection.commit();
			}	
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
			System.err.println("1199, ChkInOutRecoveryBean Excpetion===="+e);	
		}finally {
            try{
				closeStatement( cstmt ) ;
             }catch(Exception es){es.printStackTrace();
			 System.err.println("1205, ChkInOutRecoveryBean Excpetion===="+es);	
			 }
        }
		return (err_desc.equals(""))?"SUCCESS":err_desc;
	}
	
  public String updateRecRoomPopulateIntercaceRecsOTF(Connection connection,String oper_num, String slate_user_id, String check_out_time,String rec_start_time,String transfer_code,String transfer_date_time,String transfer_ward_code,String transfer_status,String doc_comp_yn, String check_out_flag,String rec_room_chrging_stg,String patient_id,String encounter_id,String episode_id,String episode_type,String visit_id,String nature_type,String nature_code,String accession_num_chrg_unit,String rec_room_code,String rec_room_desc,String modified_charge_units,String service_code,String surgeon_code,String bl_panel_str){
		CallableStatement cstmt= null;
		locale	= (String) getProperties().getProperty("LOCALE");
        String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";
		String flag="";
		try{
		String pract_code_val = "";
		String[] pract_arr=null;
	  if(!bl_panel_str.equals(""))
		{
			pract_arr=bl_panel_str.split("#");
			pract_code_val=pract_arr[5];
		}
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			
			cstmt.setString(1,"OTF");	//
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,episode_type);//Episode Type
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,accession_num_chrg_unit);//accession_num
			cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,accession_num_chrg_unit);//accession_num
			cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,service_code);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,rec_room_code);//rec_room_code
			cstmt.setString(16,rec_room_desc);//rec_room_desc
			cstmt.setString(17,modified_charge_units);//modified_charge_units

			System.err.println("1269,login_facility_id===="+login_facility_id);	

			if(!pract_code_val.equals("") ||!pract_code_val.equals(null) )
			{			
					cstmt.setString(18,pract_code_val );

			}else
			{
					cstmt.setString(18,surgeon_code );
			}
			
			cstmt.setString(19,inc_exe_blng_wdw);//reason_inc_exc
			cstmt.setString(20,reason_inc_exe);//inc_exe_blng_wdw
			cstmt.setString(21,slate_user_id);//login_id  ---> to be change
			cstmt.setString(22,login_at_ws_no);//ws_no
			cstmt.registerOutParameter(23,Types.VARCHAR);
			cstmt.registerOutParameter(24,Types.VARCHAR);	
			cstmt.registerOutParameter(25,Types.VARCHAR);

			cstmt.execute();

			err_text+=CommonBean.checkForNull(cstmt.getString(23));
			err_text+=CommonBean.checkForNull(cstmt.getString(24));
			err_text+=CommonBean.checkForNull(cstmt.getString(25));
			mesg_id=CommonBean.checkForNull(cstmt.getString(24));

			if(!err_text.equals("")){
				err_desc+=getMessag(connection,mesg_id); //Added by lakshmi scf-7752
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				connection.rollback();
			}
			else{
				flag=updateRecRoomProcessIntercaceRecs(connection,oper_num,slate_user_id,check_out_time,rec_start_time,transfer_code,transfer_date_time,transfer_ward_code,transfer_status,doc_comp_yn,check_out_flag,rec_room_chrging_stg,patient_id,encounter_id,episode_id,episode_type, visit_id,nature_type,nature_code,accession_num_chrg_unit,rec_room_code,rec_room_desc);
				if(!"SUCCESS".equals(flag) ) {
                     err_desc+=flag;
					}				
			}			
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
			System.err.println("1301, ChkInOutRecoveryBean Exception===="+e);	
		}finally {
            try{
				closeStatement( cstmt ) ;
             }catch(Exception es){es.printStackTrace();}
        }
        return (err_desc.equals(""))?"SUCCESS":err_desc;
	}

    public String updateRecRoomProcessIntercaceRecs(Connection connection,String oper_num, String slate_user_id, String check_out_time,String rec_start_time,String transfer_code,String transfer_date_time,String transfer_ward_code,String transfer_status,String doc_comp_yn, String check_out_flag,String rec_room_chrging_stg,String patient_id,String encounter_id,String episode_id,String episode_type,String visit_id,String nature_type,String nature_code,String accession_num_chrg_unit,String rec_room_code,String rec_room_desc){
		CallableStatement cstmt= null;
		PreparedStatement pstmt= null;
		locale	= (String) getProperties().getProperty("LOCALE");
		String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";
		try{
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.process_interfaced_rec(?,?,?,?,?,?, ?,?,?,?,?,?,?)}");
			cstmt.setString(1,login_facility_id);//facility_id
			cstmt.setString(2,patient_id);//Patient_id
			cstmt.setString(3,episode_type);//Episode Type
			cstmt.setString(4,episode_id);//Episode Id
			cstmt.setString(5,visit_id);//visit_id
			cstmt.setString(6,accession_num_chrg_unit);//accession_num
			cstmt.setString(7,"OT");
			cstmt.setString(8,accession_num_chrg_unit);//accession_num
			cstmt.setString(9,slate_user_id);//login_id  ---> to be change
			cstmt.setString(10,login_at_ws_no);//ws_no
			cstmt.registerOutParameter(11,Types.VARCHAR);
			cstmt.registerOutParameter(12,Types.VARCHAR);	
			cstmt.registerOutParameter(13,Types.VARCHAR);	
			cstmt.execute();
			err_text+=CommonBean.checkForNull(cstmt.getString(11));
			err_text+=CommonBean.checkForNull(cstmt.getString(12));
			err_text+=CommonBean.checkForNull(cstmt.getString(13));
			mesg_id=CommonBean.checkForNull(cstmt.getString(12));
			if(!err_text.equals("")){
				err_desc+=getMessag(connection,mesg_id);   //Added by lakshmi scf-7752
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				connection.rollback();				
			}else{
				String update_rec_room_chrg_yn="UPDATE OT_POST_OPER_HDR SET REC_CHRG_CMP_YN ='Y' WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM  = ?";
				pstmt=connection.prepareStatement(update_rec_room_chrg_yn);
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,oper_num);
				pstmt.executeUpdate();
				connection.commit();
			}	
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
			System.err.println("1368, ChkInOutRecoveryBean Exception===="+e);		
		}finally {
            try{
				closeStatement( cstmt ) ;
             }catch(Exception es){es.printStackTrace();}
        }
		 return (err_desc.equals(""))?"SUCCESS":err_desc;
	}

	public ArrayList getOperChecklists(String booking_num, String oper_num, String speciality_code,String order_id){
		Connection connection = null;
		CallableStatement cstmt=null;
		ArrayList result=new ArrayList();
		try{
			 if(booking_num==null)			booking_num="";
			 if(booking_num.equals("null"))	booking_num="";

			 if(oper_num==null)				oper_num="";
			 if(oper_num.equals("null"))	oper_num="";

			 if(order_id==null)				order_id="";
			 if(order_id.equals("null"))	order_id="";

			 if(!booking_num.equals("")){
				order_id = "";
				oper_num = "";
			 }else if(!order_id.equals("")){
				booking_num = "";
				oper_num = "";
			 }

			 connection = getConnection();
		     cstmt=connection.prepareCall("{call OT_OPER_CHECKLISTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?)}");
		 	 cstmt.setString(1,login_facility_id);
			 cstmt.setString(2,"S");// V_PRE_OR_POST ="Pre" for checkin,checkoutfromward & holdingarea
		 	 cstmt.setString(3,order_id);
		 	 cstmt.setString(4,booking_num);
		 	 cstmt.setString(5,oper_num);
		 	 cstmt.setString(6,speciality_code);
			 cstmt.registerOutParameter(7,Types.VARCHAR); // concatenated Checklist String
			 cstmt.registerOutParameter(8,Types.VARCHAR); // V_NO_OF_VERIFICATIONS
			 cstmt.registerOutParameter(9,Types.VARCHAR); // role_1
			 cstmt.registerOutParameter(10,Types.VARCHAR); // role_2
			 cstmt.registerOutParameter(11,Types.VARCHAR); // role_3
			 cstmt.registerOutParameter(12,Types.VARCHAR); // role_4

			 cstmt.registerOutParameter(13,Types.VARCHAR); //STATUS
			 cstmt.registerOutParameter(14,Types.VARCHAR); // Error text
			 cstmt.registerOutParameter(15,Types.VARCHAR); // Language Error text
			 cstmt.execute();
			 result.add(cstmt.getString(7));  //checklist string
			 result.add(cstmt.getString(8));  // no_of_verifications
			 result.add(cstmt.getString(9));  // role_id_1
			 result.add(cstmt.getString(10));  // role_id_2
			 result.add(cstmt.getString(11)); // role_id_3
			 result.add(cstmt.getString(12)); // role_id_4
	    }
		catch (Exception e){
            e.printStackTrace();
			System.err.println("1430, ChkInOutRecoveryBean Exception===="+e);		
		}
		finally{
		  try{
			closeStatement( cstmt );
			closeConnection( connection );
		  }catch(Exception e){
			e.printStackTrace();
		  }
		}
		return result;
	}

	public ArrayList getUserInfo(String booking_num, String oper_num, String current_level, String order_id){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList result=new ArrayList();
		try{
			if(booking_num==null) booking_num="";
			if(booking_num.equals("null"))	booking_num="";

			if(oper_num==null)				oper_num="";
			if(oper_num.equals("null"))		oper_num="";

			if(order_id==null)			order_id="";
			if(order_id.equals("null"))	order_id="";

			if(!booking_num.equals("")){
				order_id = "";
				oper_num = "";
			}else if(!order_id.equals("")){
				booking_num = "";
				oper_num = "";
			}
		
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT6")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			pstmt.setString(4,order_id);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("PRE_OP_CHKLST_USR1_ID"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR1_COMPL_YN"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR2_ID"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR2_COMPL_YN"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR3_ID"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR3_COMPL_YN"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR4_ID"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR4_COMPL_YN"));

				result.add(resultSet.getString("POST_OP_CHKLST_USR1_ID"));
				result.add(resultSet.getString("POST_OP_CHKLST_USR1_COMPL_YN"));
				result.add(resultSet.getString("POST_OP_CHKLST_USR2_ID"));
				result.add(resultSet.getString("POST_OP_CHKLST_USR2_COMPL_YN"));
				result.add(resultSet.getString("POST_OP_CHKLST_USR3_ID"));
				result.add(resultSet.getString("POST_OP_CHKLST_USR3_COMPL_YN"));
				result.add(resultSet.getString("POST_OP_CHKLST_USR4_ID"));
				result.add(resultSet.getString("POST_OP_CHKLST_USR4_COMPL_YN"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
			System.err.println("1496, ChkInOutRecoveryBean Exception===="+e);
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){
			 es.printStackTrace();
			 System.err.println("1504, ChkInOutRecoveryBean Exception===="+es);
			 }
        }
		return result;
	}
	
	 public String getCheckListReqdYNFlag(String function_id){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String check_for_check_list_compl="";
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT7")) ;
			pstmt.setString(1, locale);
			pstmt.setString(2, function_id);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        check_for_check_list_compl = resultSet.getString("CHECK_FOR_CHECK_LIST_COMPL");
			}
		}catch (Exception e){
            e.printStackTrace() ;
			System.err.println("1529, ChkInOutRecoveryBean Exception===="+e);
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){
			 e.printStackTrace() ;
		  }
		}
		return check_for_check_list_compl;
	 }

	//new method added on 15/06/2005 by subramanian
	public String getNursingUnitDesc(String care_location_code){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String nursing_unit_desc="";
	try{		
		connection = getConnection();
		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT11")) ;
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,care_location_code);
		pstmt.setString(3,locale);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		  nursing_unit_desc = resultSet.getString(1);
		}
	}catch (Exception e){
            e.printStackTrace() ;
			System.err.println("1565, ChkInOutRecoveryBean Exception===="+e);
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){
		 e.printStackTrace() ;
	  }
	}
	return nursing_unit_desc;
 }

  public String getClinicDesc(String clinic_location_code){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String clinic_unit_desc="";
	try{		
		connection = getConnection();
		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT8")) ;
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,clinic_location_code);
		pstmt.setString(3,locale);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		  clinic_unit_desc = resultSet.getString(1);
		}
	}catch (Exception e){
            e.printStackTrace() ;
			System.err.println("1600, ChkInOutRecoveryBean Exception===="+e);
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){
		 e.printStackTrace() ;
	  }
	}
	return clinic_unit_desc;
 }
	
 public String getAnaesthesiaApplicableYN(String order_id){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String SQL_ANAESTHESIA_EVAL_1 = "SELECT 'X'FROM AT_ANAESTHESIA_RECORD_HDR WHERE SOURCE_ORDER_ID=?";
	String SQL_ANAESTHESIA_EVAL_2 = "SELECT 'X' FROM AT_PENDING_ORDERS WHERE SOURCE_ORDER_ID = ?";
	String anaesthesia_eval_reqd_yn = "N";
	int indx = 0;
	try{
		connection = getConnection();
		pstmt = connection.prepareStatement(SQL_ANAESTHESIA_EVAL_1) ;
		pstmt.setString(1,order_id);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		  ++indx;
		  anaesthesia_eval_reqd_yn = "Y";
		}
		if(indx>0){
			pstmt = connection.prepareStatement(SQL_ANAESTHESIA_EVAL_2) ;
			pstmt.setString(1,order_id);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
			  anaesthesia_eval_reqd_yn = "Y";
			}
		}
		if(pstmt!=null) pstmt.close();
		if(resultSet!=null) resultSet.close();
	}catch (Exception e){
            e.printStackTrace() ;
			System.err.println("1645, ChkInOutRecoveryBean Exception===="+e);	
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){
		 e.printStackTrace() ;
	  }
	}
	return anaesthesia_eval_reqd_yn;
   }

   public String[] getAllDocumentionReqdYN(String facility_id){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String[] list = null;
	String SQL = "SELECT NVL(chk_surgeon_doc_cmpl_for_sts,'N'),NVL(chk_nursing_doc_cmpl_for_sts,'N'),NVL(chk_intra_doc_cmpl_for_sts,'N') FROM OT_PARAM_FOR_FACILITY WHERE operating_facility_id  =?";
	try{
		connection = getConnection();
		pstmt = connection.prepareStatement(SQL) ;
		pstmt.setString(1,facility_id);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		  list = new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)};
		 
		}
		if(pstmt!=null) pstmt.close();
		if(resultSet!=null) resultSet.close();
	}catch (Exception e){
		  e.printStackTrace();
		  System.err.println("1681, ChkInOutRecoveryBean Exception===="+e);	
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){
		 e.printStackTrace() ;
	  }
	}
	return list;
   }

   public boolean buildHistory(Connection connection,String login_facility_id,String oper_num,String order_id) {
		PreparedStatement pstmt			=				null;
		ResultSet rst					=				null;
		boolean err_text				=				true;
		String facility_id				=				login_facility_id;
		String oper_no					=				oper_num;
		StringBuffer content			=				new StringBuffer();
		String short_desc				=				"";
		String side						=				"";
		String documentation_level		=				"";
		String speciality_code			=				"";
		String short_desc1				=				"";
		String speciality_desc			=				"";
		String role_desc				=				"";
		String practitioner_name		=				"";
		String holding_area_desc		=				"";
		String checked_in_date_time		=				"";
		String recovery_start_time		=				"";
		String recovery_end_time		=				"";
		String speciality_code_as                               = "*ALL";
		String contr_mod_accession_num = "";
		Clob clob_notes_content			=				null;
		Clob oper_details				=				null;
		java.io.Writer oper_details_writer			=	null;
		java.io.BufferedWriter	oper_details_buffered_writer	= null;
		HashMap map = new HashMap();
		String surg_contr_mod_accession_num = "";
		String key						=               "";
		String val						=               "";
		//MO-CRF-20147.13
		String compressedResult = "";
		String compressResultYN = "N";
		//MO-CRF-20147.13 
try{
		 locale =(String) getProperties().getProperty("LOCALE");
		 String sql="SELECT SHORT_DESC,DECODE(RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Both Sides',RIGHT_LEFT_FLAG) side FROM   OT_POST_OPER_DTLS A,OT_OPER_MAST B WHERE  A.OPER_CODE = B.OPER_CODE AND A.OPERATING_FACILITY_ID = '"+facility_id+"' AND  A.OPER_NUM = '"+oper_no+"' AND A.OPER_LINE_STATUS IS NULL "; //Modified Against ARYU-SCF-0099	
		 pstmt=connection.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
		 content.append("<tr><td colspan=2><B>Operation Details:</B></td></tr>");
		 while(rst.next()){
			short_desc  = rst.getString("SHORT_DESC")==null?"":rst.getString("SHORT_DESC");
			side  = rst.getString("side")==null?"":rst.getString("side");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+short_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+side+" </td></tr>");		
		 }
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
		 sql="select 'Anaesthesia Given to Patient:  '||SHORT_DESC short_desc, TO_CHAR(RECOVERY_START_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_START_TIME,TO_CHAR(RECOVERY_END_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_END_TIME,DOCUMENTATION_LEVEL,SPECIALITY_CODE from  ot_post_oper_hdr a, AM_ANAESTHESIA b where  A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND    A.OPER_NUM = '"+oper_no+"' and    a.ANESTHESIA_CODE = b. ANAESTHESIA_CODE(+)";
		 pstmt=connection.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 while(rst.next()){	
			documentation_level		=		 rst.getString("DOCUMENTATION_LEVEL")==null?"":rst.getString("DOCUMENTATION_LEVEL");
			speciality_code			=		 rst.getString("SPECIALITY_CODE")==null?"":rst.getString("SPECIALITY_CODE");
			recovery_start_time		=		 rst.getString("RECOVERY_START_TIME")==null?"":rst.getString("RECOVERY_START_TIME");
			recovery_end_time		=		 rst.getString("RECOVERY_END_TIME")==null?"":rst.getString("RECOVERY_END_TIME");
			short_desc1				=		 rst.getString("SHORT_DESC")==null?"":rst.getString("SHORT_DESC");
		}
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
		String anaes_srl_no="";
		final String QUOTE = "'";
		final String COMMA = ",";
		String SQL_ANES_SRL_NO = "SELECT anaesthesia_serial_num FROM at_anaesthesia_record_hdr WHERE SOURCE_ORDER_ID = ?";
		pstmt=connection.prepareStatement(SQL_ANES_SRL_NO);
		pstmt.setString(1,order_id);
		rst=pstmt.executeQuery();
		if(rst.next()){
			anaes_srl_no = rst.getString(1);
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

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
		
		if(documentation_level.equals("AS")){				
		contr_mod_accession_num = facility_id+oper_no+speciality_code_as;		
		}else{		
		contr_mod_accession_num = facility_id+oper_no+speciality_code;
		} 
		String facility_srl_no = facility_id+anaes_srl_no;
		StringBuffer sbr = new StringBuffer();
		sbr.append(QUOTE).append(contr_mod_accession_num).append("10").append(QUOTE).append(COMMA);
		if(documentation_level.equals("AS")){		
		surg_contr_mod_accession_num = facility_id+oper_no+speciality_code_as;	
		sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);		
		}else{	
		Iterator keys = map.keySet().iterator();
			while(keys.hasNext()){
				surg_contr_mod_accession_num = facility_id+oper_no+(String)keys.next();
				sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
			}
	  }
	  
		sbr.append(QUOTE).append(contr_mod_accession_num).append("40").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(contr_mod_accession_num).append("99").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("PRE").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("INTRA").append(QUOTE).append(COMMA);
		sbr.append(QUOTE).append(facility_srl_no).append("POST").append(QUOTE);
		//sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT, CONTR_MOD_ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") AND EVENT_STATUS <> 9 ORDER BY 1";
		sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT, CONTR_MOD_ACCESSION_NUM,compress_note_content_yn, compress_note_content FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") AND EVENT_STATUS <> 9 ORDER BY 1";	//MO-CRF-20147.13
		sbr.setLength(0);
		content.append("<link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' />"); 
		pstmt = connection.prepareStatement(sql);
		rst=pstmt.executeQuery();
		while(rst.next()){
			switch(rst.getInt(1)){
				case 1: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Holding Area Notes</TD><TR><TABLE>"); break;
				case 2:
					val = rst.getString(4);
					key = val.substring(12,val.length()-2);
					if (key!=null && !key.equals("") && !key.equals("*ALL")) {
					content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes("+map.get(key)+")</TD><TR><TABLE>"); 
					}else{
					content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>");
					}
					break;
				case 3: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Recovery Notes</TD><TR><TABLE>"); break;
				case 4: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Operative Records</TD><TR><TABLE>"); break;
				case 5: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Pre Anesthesia Details</TD><TR><TABLE>"); break;
				case 6: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Intra Anesthesia Details</TD><TR><TABLE>"); break;
				case 7: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING'colspan=6>Post Anesthesia Details</TD><TR><TABLE>"); break;
				default :break;

			}
			clob_notes_content	= rst.getClob("note_content");
			if(clob_notes_content!=null){
				content.append(clob_notes_content.getSubString(1,(int) clob_notes_content.length())).append("*****");
		
			} // end of if(clob_notes_content!=null)
				//MO-CRF-20147.13 Starts
		
		compressResultYN = rst.getString("compress_note_content_yn")==null?"N":(String)rst.getString("compress_note_content_yn");
		java.sql.Blob note_blob =  (java.sql.Blob)rst.getBlob("compress_note_content");
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
								}
							}					
						}
					}
		//MO-CRF-20147.13 Ends
		} // end of if(rst.next())
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
        content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
		content.append("<tr><td></td><td nowrap>"+short_desc1+"</td></tr>");

		sql=" SELECT DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities', D.SHORT_DESC) SPECIALITY_DESC,C.ROLE_DESC, B.SHORT_NAME PRACTITIONER_NAME  FROM   OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B, OT_ROLES_LANG_VW C, (SELECT '*ALL' SPECIALITY_CODE,'All Specialities'  SHORT_DESC FROM DUAL UNION SELECT SPECIALITY_CODE, SHORT_DESC FROM  AM_SPECIALITY_LANG_VW WHERE  LANGUAGE_ID='"+locale+"' )  D  WHERE B.LANGUAGE_ID='"+locale+"' AND  C.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID = '"+facility_id+"' AND 	 A.OPER_NUM			 ='"+oper_no+"' AND	  A.SPECIALITY_CODE	 = D.SPECIALITY_CODE  AND	 A.PRACTITIONER_ID	 = B.PRACTITIONER_ID  AND  A.ROLE_ID	 = C.ROLE_ID ";
        pstmt=connection.prepareStatement(sql);
		rst=pstmt.executeQuery();
		content.append("<tr><td colspan=6 class='CAGROUPHEADING'>Personnel Details</td></tr>");
		while(rst.next()){
			speciality_desc		=	rst.getString("SPECIALITY_DESC")==null?"":rst.getString("SPECIALITY_DESC");
			role_desc			=	rst.getString("ROLE_DESC")==null?"":rst.getString("ROLE_DESC");
			practitioner_name	=	rst.getString("PRACTITIONER_NAME")==null?"":rst.getString("PRACTITIONER_NAME");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+speciality_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+role_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+practitioner_name+"  </td></tr>");			
		}
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
		sql="SELECT B.HOLDING_AREA_DESC, TO_CHAR(CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_IN_DATE_TIME FROM  OT_OPER_HOLDING_DTLS A, OT_HOLDING_AREAS_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND   A.OPER_NUM ='"+oper_no+"' AND   A.OPERATING_FACILITY_ID  = B.OPERATING_FACILITY_ID AND A. HOLDING_AREA_CODE = B. HOLDING_AREA_CODE";
		pstmt=connection.prepareStatement(sql);
		rst=pstmt.executeQuery();
		content.append("<tr><td colspan=5 class='CAGROUPHEADING'>Holding Bay Details</td></tr>");
		while(rst.next()){
			holding_area_desc  = rst.getString("HOLDING_AREA_DESC")==null?"":rst.getString("HOLDING_AREA_DESC");
			checked_in_date_time  = rst.getString("CHECKED_IN_DATE_TIME")==null?"":rst.getString("CHECKED_IN_DATE_TIME");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+holding_area_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+checked_in_date_time+"</td></tr>");		
		}
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
		content.append("<tr><td colspan=6 class='CAGROUPHEADING'><B>Recovery start and end time:</B></td></tr>");
		content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+recovery_start_time+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+recovery_end_time+"</td></tr>");
		content.append("</table></BODY></HTML>");
		if(compressResultYN.equals("N"))	//MO-CRF-20147.13 
		{
		String updateSql = "UPDATE ot_post_oper_hdr SET  oper_details = empty_clob()  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";
		if(pstmt!=null) pstmt.close();
		pstmt = connection.prepareStatement(updateSql);
		pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();
		String selectSql = "select oper_details from ot_post_oper_hdr where operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"' for update";
		pstmt = connection.prepareStatement(selectSql);
		rst = pstmt.executeQuery();
		if(rst.next()){
			oper_details = rst.getClob("oper_details");
			oper_details_writer = oper_details.setCharacterStream(0L);
			oper_details_buffered_writer = new java.io.BufferedWriter(oper_details_writer);	
			oper_details_buffered_writer.write(content.toString(),0,content.length());	
			oper_details_buffered_writer.flush();									
			oper_details_buffered_writer.close();
		}
		
		}
		//MO-CRF-20147.13 Starts
		else{
			String updateCompressed = "UPDATE OT_POST_OPER_HDR SET compress_note_content_yn = ? , compress_note_content = ?  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";
			
			pstmt = connection.prepareStatement(updateCompressed);

			pstmt.setString(1,compressResultYN );
		 pstmt.setBytes(2, compress(compressedResult));
		 pstmt.executeUpdate();
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close(); 

		}
		//MO-CRF-20147.13 Ends

	}catch(Exception ee){
		ee.printStackTrace();
		System.err.println("1883, ChkInOutRecoveryBean Exception===="+ee);	
		err_text=false;
	}finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			connection.commit();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	  }
 	return err_text;
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
	
	public String getMessag(Connection connection,String mesg_id){
		StringBuilder sbr = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String err_desc = "";
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,mesg_id);
		rst = pstmt.executeQuery();
		while(rst.next()){
		err_desc=CommonBean.checkForNull(rst.getString(1));
		}
		}catch(Exception e){
            e.printStackTrace() ;
			System.err.println("1913, ChkInOutRecoveryBean Exception===="+e);	
		}finally{
		try{
		sbr.setLength(0);
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		}catch(Exception e){
		e.printStackTrace();
		}
		}
		return err_desc;
   }
 }