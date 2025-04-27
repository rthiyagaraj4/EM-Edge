/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;

/*
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import eOT.Common.* ;
import eCommon.Common.* ;
import webbeans.eCommon.* ;
*/
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
import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;
//MO-CRF-20147.13 Starts
//import java.util.* ;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import oracle.sql.CLOB;
//import java.sql.* ;
import java.io.* ;
//MO-CRF-20147.13 Ends
public class ChkOutFromORBean extends OTAdapter implements Serializable {

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
	String check_out_date = "";
	String transfer_code="";
	String doc_comp_yn="";
	String check_out_flag="";
	String order_id="";
	String facility_id="";
	//Newly added parameter for posting the biling in ot_post_oper_hdr by rajesh for crf-224 on 26/05/09
//calc_charge_units,charge_units,or_bill_accession_num,chk_oper_room_yn,oper_room_chrging_stg
	String calc_charge_units="";
	String charge_units="";
	String or_bill_accession_num="";
	String chk_oper_room_yn="";
	String oper_room_chrging_stg="";
	String episode_id="";
	String episode_type="";
	String visit_id="";
	String oper_room_desc="";
	String patient_id="";
	String surgeon_code="";
	String bill_service_code="";
	String oper_room_code="";
	String bl_interface_flag="";
	String charge_operating_room_yn="";
	String reason_inc_exe="";
	String inc_exe_blng_wdw="";
	String strQuery="";
	
	public ChkOutFromORBean() {
        try {
			doCommon();
		}catch(Exception e) {}
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
		check_out_date="";
		transfer_code="";
		doc_comp_yn="";
		check_out_flag="";
		order_id="";
		facility_id="";
	}

	public void setAll(Hashtable hash)
	{
		String locale	= (String) getProperties().getProperty("LOCALE");
		mode = (String)hash.get("mode");
		slate_user_id = (String)hash.get("slate_user_id");
		oper_num = (String)hash.get("oper_num");
		order_id = (String)hash.get("order_id");
		facility_id = (String)hash.get("facility_id");
		check_out_time = (String)hash.get("check_out_time_or");
		check_out_date = (String)hash.get("check_out_date");
		//date conversion to english on 11/29/2010
		check_out_date = DateUtils.convertDate(check_out_date,"DMY",locale,"en");;
		transfer_code = (String) hash.get("transfer");
		transfer_ward_code = (String) hash.get("ward_code");

		
//		transfer_date_time= (String) hash.get("current_date_time_db")+" "+(String) hash.get("check_out_time_or");
		transfer_date_time= check_out_date+" "+check_out_time;
		rec_start_time="";
		rec_end_time="";
		transfer_status = (String) hash.get("status");
		doc_comp_yn= (String) hash.get("doc_comp_yn");
		check_out_flag = (String) hash.get("check_out_flag");
		//Newly added billing code by rajesh for crf 224 on 26/05/09
		calc_charge_units = (String) hash.get("calc_charge_units");
		charge_units = (String) hash.get("charge_units");
		or_bill_accession_num = (String) hash.get("or_bill_accession_num");
		chk_oper_room_yn = (String) hash.get("chk_oper_room_yn");
		oper_room_chrging_stg = (String) hash.get("oper_room_chrging_stg");
		episode_id = (String) hash.get("episode_id");
		episode_type = (String) hash.get("episode_type");
		visit_id = (String) hash.get("visit_id");
		oper_room_desc = (String) hash.get("oper_room_desc");
		patient_id = (String) hash.get("patient_id");
		surgeon_code = (String) hash.get("surgeon_code");
		bill_service_code = (String) hash.get("bill_service_code");
		oper_room_code = (String) hash.get("oper_room");
		bl_interface_flag = (String) hash.get("bl_interface_flag");
		charge_operating_room_yn = (String) hash.get("charge_operating_room_yn");
		reason_inc_exe=(String) hash.get("reason_inc_exe");
		inc_exe_blng_wdw = (String) hash.get("inc_exe_blng_wdw");
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
					closeResultSet( rsa ) ;
					closeStatement( pstmta ) ;
					closeConnection( conn );
				}
				catch (Exception e2)
				{
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
	  
	public HashMap insert(){
		HashMap map = new HashMap() ;
		boolean transaction_flag = true;
		String err_text = "";		
		//String status="";
		//Added by lakshmi 13/7/2011 scf-7752
		Connection connection = null;
		try{	
			//Added by lakshmi 13/7/2011 scf-7752
			connection = getConnection();
			err_text = updateCheckOutRecoveryStatus(connection,oper_num,slate_user_id,check_out_time,rec_start_time,transfer_code,transfer_date_time,transfer_ward_code,transfer_status,doc_comp_yn,check_out_flag,bl_interface_flag,charge_operating_room_yn);
			if("RECORD_INSERTED".equals(err_text)){
				if("Y".equals(check_out_flag) ){
					boolean history_build_flag = buildHistory(connection,facility_id,oper_num,order_id);
					err_text = (history_build_flag)?"RECORD_INSERTED":"ChkOutFromORBean.java : Failed in history building";
					transaction_flag = err_text.equals("RECORD_INSERTED")?true:false; 
				}
			}
			if(!err_text.equals("RECORD_INSERTED") || transaction_flag==false){
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", "Operation Failed : " + err_text ) ;
			}else{
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", "RECORD_INSERTED") ;
			}
		
		}catch(Exception e) {
		System.err.println("Exception occurred while exec "+e);
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "Operation Failed" ) ;
			e.printStackTrace() ;
		}finally {
			//clear();
			try {
				closeConnection(connection); /*Added by lakshmi 13/7/2011 scf-7752 */
			}
			catch( Exception ee ){
		  ee.printStackTrace();
		  System.err.println("Exception occurred while exec1 "+ee);
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
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("DATE_TIME"));
				result.add(resultSet.getString("CURRENT_DATE"));
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
public void loadDisposalDtls(String locale,String facility_id,String oper_num){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		//String given_by ="";
		//String received_by="";
		HashMap map = null;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_DISPOSAL_DTLS_SELECT"));
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
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
		  e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);
		  }catch(Exception e){}
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

public String updateCheckOutRecoveryStatus(Connection connection,String oper_num, String slate_user_id, String check_out_time,String rec_start_time,String transfer_code,String transfer_date_time,String transfer_ward_code,String transfer_status,String doc_comp_yn, String check_out_flag,String bl_interface_flag, String charge_operating_room_yn)
{
	//Connection connection  = null;  -------commented by lakshmi 13/7/2011 scf-7752
	CallableStatement cstmt= null;
	String flag ="";
	String error_text = "";
	String status	  = "";
	try{

			//connection	= getConnection() ;   -------commented by lakshmi 13/7/2011 scf-7752
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,?,?,null,null,null,null,null,null,null,?,?,?,?,?,?,null,null,null,?,?,?,null,?,?,?,?,?)}");
			cstmt.setString(1,"23");	//Function ID			
			//cstmt.setString(2,login_facility_id);
			cstmt.setString(2,login_facility_id);
			//System.out.println("eOT CheckOutFromOrBean facility_id "+login_facility_id);
			cstmt.setString(3,oper_num);
			//cstmt.setString(4,cur_date+" "+check_out_time); 
			cstmt.setString(4,transfer_date_time);
			cstmt.setString(5,doc_comp_yn); // DOC_COMPL_YN	
			// the null fields are additional fields...not used in this function
			//cstmt.setString(6,rec_start_time); // ADDN FIELD 7
			cstmt.setString(6,rec_end_time); // ADDN FIELD 8 	
			cstmt.setString(7,transfer_code); // ADDN FIELD 9	
			cstmt.setString(8,transfer_date_time); // ADDN FIELD 10	
			cstmt.setString(9,transfer_ward_code); // ADDN FIELD 11		
			cstmt.setString(10,transfer_status); // ADDN FIELD 12		
			cstmt.setString(11,check_out_flag); // ADDN FIELD 13
			cstmt.setString(12,or_bill_accession_num); // ADDN FIELD 17 OR_BL_ACCESSION_NUM
			cstmt.setString(13,charge_units); // ADDN FIELD 19 OR_CALC_CHARGEABLE_UNITS
			cstmt.setString(14,calc_charge_units); // ADDN FIELD 18 OR_CHARGEABLE_UNITS
//			cstmt.setString(14,or_bill_accession_num); // ADDN FIELD 20 OR_BL_ACCESSION_NUM
			cstmt.setString(15,slate_user_id);
			cstmt.setString(16,login_at_ws_no);	
			cstmt.registerOutParameter(17,Types.VARCHAR);
			cstmt.registerOutParameter(18,Types.VARCHAR);	
			cstmt.registerOutParameter(19,Types.VARCHAR);	
			cstmt.execute();
			//connection.commit();

			status = cstmt.getString(17);
			if(status.equals("E"))
		       {
				error_text = CommonBean.checkForNull(cstmt.getString(19));
			    connection.rollback();
			   }
			else
		       {
				
				if(("Y").equals(chk_oper_room_yn) && ("Y").equals(bl_interface_flag) && ("Y").equals(check_out_flag) && charge_operating_room_yn.equals("Y") ){
							

					flag=updateOperRoomPopulateIntercaceRecs(connection);
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
		System.err.println("Exception11111111 : "+e);
	        e.printStackTrace() ;
		}finally {
            try{
                closeStatement( cstmt ) ;
                // closeConnection( connection );    -------commented by lakshmi 13/7/2011 scf-7752
             }catch(Exception es){es.printStackTrace();}
        }

		return error_text;
	}

//NEWLY ADDED BILLING PROCEDURES BY RAJESH FOR CRF 224 ON 26/05/2009

public String updateOperRoomPopulateIntercaceRecs(Connection connection){
//		Connection connection  = null;
		CallableStatement cstmt= null;
//		Hashtable messageHashtable = null;
//		String locale	= (String) getProperties().getProperty("LOCALE");
		
		String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";
		String flag ="";

//		String v_err_code="";
//		String v_sys_message_id="";
//		String v_error_text="";
//		String otf_bill_v_error_text="";
		try{
			//connection	= getConnection() ;
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			cstmt.setString(1,"OTR");	//
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,episode_type);//Episode Type
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,or_bill_accession_num);//accession_num
			//cstmt.setString(8,(String)map.get("accession_line_num"));//line_num
			cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,or_bill_accession_num);//accession_num
			//cstmt.setString(11,(String)map.get("accession_line_num"));//line_num
			cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,bill_service_code);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,oper_room_code);//holding_bay_code
			cstmt.setString(16,oper_room_desc);//holding_bay_desc
			cstmt.setString(17,charge_units);//modified_charge_units
			cstmt.setString(18,surgeon_code);//surgeon_code
			
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
			mesg_id  =CommonBean.checkForNull(cstmt.getString(24));
			
			if(!err_text.equals("")){

				err_desc+=getMessag(connection,mesg_id); // Added by lakshmi scf-7752
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				connection.rollback();
			
			}else{
				if("O".equals(oper_room_chrging_stg)){
					flag=updateOperRoomPopulateIntercaceRecsOTF(connection);
					if(!"SUCCESS".equals(flag) ) {
                     err_desc+=flag;
					}
				}else
					connection.commit();

			}	
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				closeStatement( cstmt ) ;
         //       closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return (err_desc.equals(""))?"SUCCESS":err_desc;
	}


public String updateOperRoomPopulateIntercaceRecsOTF(Connection connection){
		//Connection connection  = null;
		CallableStatement cstmt= null;
//		Hashtable messageHashtable = null;
//		String locale	= (String) getProperties().getProperty("LOCALE");

		String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";
		String flag="";

//		String v_err_code="";
//		String v_sys_message_id="";
//		String v_error_text="";
//		String bill_process_v_error_text="";
		try{
			//connection	= getConnection() ;
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			cstmt.setString(1,"OTF");	//
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,episode_type);//Episode Type
			cstmt.setString(4,patient_id);//Patient_id
			cstmt.setString(5,episode_id);//Episode Id
			cstmt.setString(6,visit_id);//visit_id
			cstmt.setString(7,or_bill_accession_num);//accession_num
			//cstmt.setString(8,(String)map.get("accession_line_num"));//line_num
			cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,or_bill_accession_num);//accession_num
			//cstmt.setString(11,(String)map.get("accession_line_num"));//line_num
			cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,bill_service_code);//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,oper_room_code);//holding_bay_code
			cstmt.setString(16,oper_room_desc);//holding_bay_desc
			cstmt.setString(17,charge_units);//modified_charge_units
			cstmt.setString(18,surgeon_code);//surgeon_code
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
				err_desc+=getMessag(connection,mesg_id);  // Added by lakshmi scf-7752
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				connection.rollback();
				
			}
			else{
				flag=updateHoldingAreaProcessIntercaceRecs(connection);
				if(!"SUCCESS".equals(flag) ) {
                     err_desc+=flag;
					}
				
			}	
			
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				closeStatement( cstmt ) ;
              //  closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		 return (err_desc.equals(""))?"SUCCESS":err_desc;
	}

public String updateHoldingAreaProcessIntercaceRecs(Connection connection){
	//	Connection connection  = null;
		CallableStatement cstmt= null;
		PreparedStatement pstmt= null;
//		String	locale	= (String) getProperties().getProperty("LOCALE");
//		Hashtable messageHashtable = null;

		String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";

//		String v_err_code="";
//		String v_sys_message_id="";
//		String v_error_text="";
		try{
		//	connection	= getConnection() ;
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.process_interfaced_rec(?,?,?,?,?,?, ?,?,?,?,?,?,?)}");
			cstmt.setString(1,login_facility_id);//facility_id
			cstmt.setString(2,patient_id);//Patient_id
			cstmt.setString(3,episode_type);//Episode Type
			cstmt.setString(4,episode_id);//Episode Id
			cstmt.setString(5,visit_id);//visit_id
			cstmt.setString(6,or_bill_accession_num);//accession_num
			cstmt.setString(7,"OT");
			cstmt.setString(8,or_bill_accession_num);//accession_num
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
				err_desc+=getMessag(connection,mesg_id);  // Added by lakshmi scf-7752
				//Modified by DhanasekarV against 16/06/2011 IN027773
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";    // Uncommented by lakshmi scf-7752
				connection.rollback();
			
			}else{

				String update_oper_room_chrg_yn="UPDATE OT_POST_OPER_HDR SET OR_CHRG_CMP_YN  ='Y'WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM = ?";
				pstmt=connection.prepareStatement(update_oper_room_chrg_yn);
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,oper_num);
				pstmt.executeUpdate();
				connection.commit();
			}	
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				closeStatement( cstmt ) ;
              //  closeConnection( connection );
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

			 if(booking_num!=null && !booking_num.equals("null") && !booking_num.equals(""))
				 order_id = "";

			 connection = getConnection();
		     cstmt=connection.prepareCall("{call OT_OPER_CHECKLISTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?)}");
		 	 cstmt.setString(1,login_facility_id);
			 cstmt.setString(2,"S");//P- Pre-Operative CheckList or O- Post Operative CheckList checkin,checkoutfromward & holdingarea 
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
		}
		finally{
		  try{
			closeStatement( cstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
		return result;
	}
	public ArrayList getUserInfo(String facility_id,String booking_num, String oper_num, String current_level, String order_id){
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
			pstmt.setString(1,facility_id);
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
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}
	 public String getCheckListReqdYNFlag(String locale,String function_id){
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
		  e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return check_for_check_list_compl;
	 }

	//new method added on 15/06/2005 by subramanian
	public String getNursingUnitDesc(String facility_id,String care_location_code){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String nursing_unit_desc="";
	try{
		connection = getConnection();
		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT11")) ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,care_location_code);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		  nursing_unit_desc = resultSet.getString(1);
		}
	}catch (Exception e){
		  e.printStackTrace();
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){}
	}
	return nursing_unit_desc;
 }

  public String getClinicDesc(String locale,String facility_id,String clinic_location_code){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String clinic_unit_desc="";
	try{
		connection = getConnection();
		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT8")) ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,clinic_location_code);
		pstmt.setString(3,locale);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		  clinic_unit_desc = resultSet.getString(1);
		}
	}catch (Exception e){
		  e.printStackTrace();
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){}
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
			if(resultSet!=null) resultSet.close();
			if(pstmt!=null) pstmt.close();			
			pstmt = connection.prepareStatement(SQL_ANAESTHESIA_EVAL_2) ;
			pstmt.setString(1,order_id);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
			  anaesthesia_eval_reqd_yn = "Y";
			}
		}
	}catch (Exception e){
		  e.printStackTrace();
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){}
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
		  //list.add(resultSet.getString(1));
		  //list.add(resultSet.getString(2));
		  //list.add(resultSet.getString(3));
		  list = new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)};
		 
		}
	}catch (Exception e){
		  e.printStackTrace();
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){}
	}
	return list;
   }

   public boolean buildHistory(Connection connection,String login_facility_id,String oper_num,String order_id) {
		//Connection con = null;    -------commented by lakshmi 13/7/2011 scf-7752
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
		//String locn_type				=				"";
		//String	notes_content			=				"";
		String speciality_desc			=				"";
		String role_desc				=				"";
		String practitioner_name		=				"";
		String holding_area_desc		=				"";
		String checked_in_date_time		=				"";
		String recovery_start_time		=				"";
		String recovery_end_time		=				"";
		//Reader content_reader			=				null;
		String speciality_code_as                               = "*ALL";
		String contr_mod_accession_num = "";
		Clob clob_notes_content			=				null;
		//BufferedReader	bf_content_reader	=	null;
		Clob oper_details				=				null;
		java.io.Writer oper_details_writer			=	null;
		java.io.BufferedWriter	oper_details_buffered_writer	= null;
		//oracle.sql.CLOB			clob_notes_content	= null;
		HashMap map = new HashMap();
		String surg_contr_mod_accession_num = "";
		String key						=               "";
		String val						=               "";
		//Gomu
		String compressedResult = "";
		String compressResultYN = "N";
		//Gomu

	try{
		 //con = getConnection();     -------commented by lakshmi 13/7/2011 scf-7752
		 String sql="SELECT SHORT_DESC,DECODE(RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Both Sides',RIGHT_LEFT_FLAG) side FROM   OT_POST_OPER_DTLS A,OT_OPER_MAST B WHERE  A.OPER_CODE = B.OPER_CODE AND A.OPERATING_FACILITY_ID = '"+facility_id+"' AND  A.OPER_NUM = '"+oper_no+"' ";
		 pstmt=connection.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='/eHIS/eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
		 content.append("<tr><td colspan=2><B>Operation Details:</B></td></tr>");
		 while(rst.next()){
			short_desc  = rst.getString("SHORT_DESC")==null?"":rst.getString("SHORT_DESC");
			side  = rst.getString("side")==null?"":rst.getString("side");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+short_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+side+" </td></tr>");
			
		 }
		 sql="select 'Anaesthesia Given to Patient:  '||SHORT_DESC short_desc, TO_CHAR(RECOVERY_START_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_START_TIME,TO_CHAR(RECOVERY_END_TIME,'dd/mm/yyyy hh24:mi') RECOVERY_END_TIME,DOCUMENTATION_LEVEL,SPECIALITY_CODE from  ot_post_oper_hdr a, AM_ANAESTHESIA b where  A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND    A.OPER_NUM = '"+oper_no+"' and    a.ANESTHESIA_CODE = b. ANAESTHESIA_CODE(+)";
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close();
		 pstmt=connection.prepareStatement(sql);
		 rst=pstmt.executeQuery();
		 while(rst.next()){	
			documentation_level		=		 rst.getString("DOCUMENTATION_LEVEL")==null?"":rst.getString("DOCUMENTATION_LEVEL");
			speciality_code			=		 rst.getString("SPECIALITY_CODE")==null?"":rst.getString("SPECIALITY_CODE");
			recovery_start_time		=		 rst.getString("RECOVERY_START_TIME")==null?"":rst.getString("RECOVERY_START_TIME");
			recovery_end_time		=		 rst.getString("RECOVERY_END_TIME")==null?"":rst.getString("RECOVERY_END_TIME");
			short_desc1				=		 rst.getString("SHORT_DESC")==null?"":rst.getString("SHORT_DESC");
		}
		String anaes_srl_no="";
		//String pre_intra_post_title="";
		//String surgeon_note = "";
		final String QUOTE = "'";
		final String COMMA = ",";
		String SQL_ANES_SRL_NO = "SELECT anaesthesia_serial_num FROM at_anaesthesia_record_hdr WHERE SOURCE_ORDER_ID = ?";
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close();

		pstmt=connection.prepareStatement(SQL_ANES_SRL_NO);
		pstmt.setString(1,order_id);
		rst=pstmt.executeQuery();
		if(rst.next()){
			anaes_srl_no = rst.getString(1);
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		
		//added by sahtihs on 29/12/2008
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

		
		//newly added by subramanian on 4/3/2006
		if(documentation_level.equals("AS")){		
		contr_mod_accession_num = facility_id+oper_no+speciality_code_as;		
		}else{		
		contr_mod_accession_num = facility_id+oper_no+speciality_code;
		} 
		String facility_srl_no = facility_id+anaes_srl_no;
		StringBuffer sbr = new StringBuffer();
		sbr.append(QUOTE).append(contr_mod_accession_num).append("10").append(QUOTE).append(COMMA);
		//sbr.append(QUOTE).append(contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
		// added by sathish on 29/12/2008
	/*	Iterator keys = map.keySet().iterator();
			while(keys.hasNext()){
				surg_contr_mod_accession_num = facility_id+oper_no+(String)keys.next();
				sbr.append(QUOTE).append(surg_contr_mod_accession_num).append("30").append(QUOTE).append(COMMA);
			} */
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
		sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT, CONTR_MOD_ACCESSION_NUM, compress_note_content_yn, compress_note_content FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") AND EVENT_STATUS <> 9 ORDER BY 1";	//Modified Against MO-CRF-20147.13 
		//Above query is commented against 45394 and changes modified below
		//sql="SELECT DECODE(SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1),'10',1,'30',2,'40',3,'99',4,'RE',5,'RA',6,'ST',7,9) STAGE_ORD, SUBSTR(CONTR_MOD_ACCESSION_NUM,LENGTH(CONTR_MOD_ACCESSION_NUM)-1) STAGE, NOTE_CONTENT, CONTR_MOD_ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM in("+sbr.toString()+") ORDER BY 1";//Against 45394
		sbr.setLength(0);
		content.append("<link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' />"); 
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close();

		pstmt = connection.prepareStatement(sql);
		rst=pstmt.executeQuery();
		while(rst.next()){
			switch(rst.getInt(1)){
				case 1: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Holding Area Notes</TD><TR><TABLE>"); break;
				//case 2: content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>"); break;
				case 2: 
					/*if(documt_level.equals("AS")){	
				    content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes</TD><TR><TABLE>"); 					
					}else{
					val = rst.getString(4);
					key = val.substring(12,val.length()-2);
					content.append("<TABLE><TR><TD CLASS='CAGROUPHEADING' colspan=6>Surgeon Notes("+map.get(key)+")</TD><TR><TABLE>"); 
					}*/
					val = rst.getString(4);
					key = val.substring(12,val.length()-2);
					if (key!=null && !key.equals("") && !key.equals("*ALL")) {
					//if (key!=null && key !=" "){
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
		System.err.println("1172, compressResultYN : " +compressResultYN);
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
        content.append("<HTML><HEAD><LINK rel='stylesheet' type='text/css' href='/eHIS/eCommon/html/IeStyle.css'></LINK><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0  width='100%'>");
		content.append("<tr><td></td><td nowrap>"+short_desc1+"</td></tr>");
	    sql=" SELECT DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities', D.SHORT_DESC) SPECIALITY_DESC,C.ROLE_DESC, B.SHORT_NAME PRACTITIONER_NAME  FROM   OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER B, OT_ROLES C, (SELECT '*ALL' SPECIALITY_CODE,'All Specialities'  SHORT_DESC FROM DUAL UNION SELECT SPECIALITY_CODE, SHORT_DESC FROM  AM_SPECIALITY  )  D  WHERE  A.OPERATING_FACILITY_ID = '"+facility_id+"' AND 	 A.OPER_NUM			 ='"+oper_no+"' AND	  A.SPECIALITY_CODE	 = D.SPECIALITY_CODE  AND	 A.PRACTITIONER_ID	 = B.PRACTITIONER_ID  AND  A.ROLE_ID	 = C.ROLE_ID ";
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close();
		pstmt=connection.prepareStatement(sql);
		rst=pstmt.executeQuery();
		content.append("<tr><td colspan=6 class='CAGROUPHEADING'>Personnel Details</td></tr>");
		while(rst.next()){
			speciality_desc		=	rst.getString("SPECIALITY_DESC")==null?"":rst.getString("SPECIALITY_DESC");
			role_desc			=	rst.getString("ROLE_DESC")==null?"":rst.getString("ROLE_DESC");
			practitioner_name	=	rst.getString("PRACTITIONER_NAME")==null?"":rst.getString("PRACTITIONER_NAME");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+speciality_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+role_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+practitioner_name+"  </td></tr>");
			
		}
		sql="SELECT B.HOLDING_AREA_DESC, TO_CHAR(CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_IN_DATE_TIME FROM  OT_OPER_HOLDING_DTLS A, OT_HOLDING_AREAS B WHERE A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND   A.OPER_NUM ='"+oper_no+"' AND   A.OPERATING_FACILITY_ID  = B.OPERATING_FACILITY_ID AND A. HOLDING_AREA_CODE = B. HOLDING_AREA_CODE";
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close();

		pstmt=connection.prepareStatement(sql);
		rst=pstmt.executeQuery();
		content.append("<tr><td colspan=5 class='CAGROUPHEADING'>Holding Bay Details</td></tr>");
		while(rst.next()){
			holding_area_desc  = rst.getString("HOLDING_AREA_DESC")==null?"":rst.getString("HOLDING_AREA_DESC");
			checked_in_date_time  = rst.getString("CHECKED_IN_DATE_TIME")==null?"":rst.getString("CHECKED_IN_DATE_TIME");
			content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+holding_area_desc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+checked_in_date_time+"</td></tr>");
			
		}
		//pstmt.close();
		//rst.close();
		content.append("<tr><td colspan=6 class='CAGROUPHEADING'><B>Recovery start and end time:</B></td></tr>");
		content.append("<tr><td>&nbsp;&nbsp;&nbsp;</td><td nowrap>"+recovery_start_time+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+recovery_end_time+"</td></tr>");
		content.append("</table></BODY></HTML>");
		if(compressResultYN.equals("N"))	//MO-CRF-20147.13
		{
		String updateSql = "UPDATE ot_post_oper_hdr SET  oper_details = empty_clob()  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close(); 

		pstmt = connection.prepareStatement(updateSql);
		pstmt.executeUpdate();

		//pstmt.close();
		if(pstmt!=null) pstmt.close();  //Added by lakshmi scf-7752
		String selectSql = "select oper_details from ot_post_oper_hdr where operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"' for update";
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close();

		pstmt = connection.prepareStatement(selectSql);
		rst = pstmt.executeQuery();
		if(rst.next()){
			oper_details = rst.getClob("oper_details");
			//oper_details_writer = ((oracle.sql.CLOB)oper_details).getCharacterOutputStream();
			oper_details_writer = oper_details.setCharacterStream(0L);
//			oper_details_writer =null;
			oper_details_buffered_writer = new java.io.BufferedWriter(oper_details_writer);	
			oper_details_buffered_writer.write(content.toString(),0,content.length());	
			oper_details_buffered_writer.flush();										
			oper_details_buffered_writer.close();
			//con.commit();
		}
		}
		//MO-CRF-20147.13 Starts
		else{
			String updateCompressed = "UPDATE OT_POST_OPER_HDR SET compress_note_content_yn = ? , compress_note_content = ?  WHERE operating_facility_id = '"+facility_id+"' AND oper_num = '"+oper_no+"'";
			System.err.println("1261, updateCompressed : " +updateCompressed);
			pstmt = connection.prepareStatement(updateCompressed);

			pstmt.setString(1,compressResultYN );
		 pstmt.setBytes(2, compress(compressedResult));
		 pstmt.executeUpdate();
		 System.err.println("1261, Executed ~~~~~~~~~");
		 if(rst!=null) rst.close();
		 if(pstmt!=null) pstmt.close(); 

		}
		//MO-CRF-20147.13 Ends
	}catch(Exception ee){
		ee.printStackTrace();
		err_text=false;
	}finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			// Modified by DhanasekarV against issue 28058 on 29/07/2011
			connection.commit();
			//con.close();     -------commented by lakshmi 13/7/2011 scf-7752
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
	//MO-CRF-20147.13
	
	public  String getMessag(Connection connection,String mesg_id){
		//Connection con = null;    -------commented by lakshmi 13/7/2011 scf-7752
		StringBuilder sbr = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String err_desc = "";
//		String err_mesg = "";
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
		//con = getConnection(); -------commented by lakshmi 13/7/2011 scf-7752
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,mesg_id);
		rst = pstmt.executeQuery();
//		int count=0;
		while(rst.next()){
		err_desc=CommonBean.checkForNull(rst.getString(1));
		}
		}catch(Exception e){
		  e.printStackTrace();
		}finally{
		try{
		sbr.setLength(0);
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		//con.close();   -------commented by lakshmi 13/7/2011 scf-7752
		}catch(Exception e){}
		} 
		return err_desc;
   }

}
