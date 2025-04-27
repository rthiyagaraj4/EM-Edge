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
import java.io.Serializable;
import java.util.*;
import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import com.ehis.util.DateUtils;
import webbeans.eCommon.*;


public class HoldingAreaBean extends OTAdapter implements Serializable {
	HashMap headerDtls = null;
	ArrayList hold_dtls = null;
	HashMap oper_dtls = null;
	Properties	p = this.properties;
	String	locale	= "";
	public HoldingAreaBean() {
        try {
			doCommon();
			locale	= (String) p.getProperty("LOCALE");			
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {
	}

	public void clear(){
		headerDtls = null; 
		hold_dtls = null;
		oper_dtls = null;  
	}

	public void setHeaderDtls(HashMap map){
	 if(headerDtls==null)
		headerDtls = new HashMap();
		headerDtls= map;
	}

	public void setOperationDtls(HashMap map){
		if(oper_dtls==null)
			oper_dtls = new HashMap();
		    oper_dtls = map;

	}

	public ArrayList getSysDateTime(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String locale = getProperties().getProperty("LOCALE");
		ArrayList result = new ArrayList(); 
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
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
	public String getConvertedMts(String mts){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String result="";
		try{
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_QRY_SELECT3")) ;
			pstmt.setString(1,mts);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				result = resultSet.getString(1);
			}
		}catch ( Exception e ) {
            e.printStackTrace();
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return result;
	}
	public void loadHoldingAreaDtls(String oper_num){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		try{
			locale	= getProperties().getProperty("LOCALE");
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_HOLDING_AREA_SELECT1"));
			pstmt.setString(1,locale);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,oper_num);
			resultSet= pstmt.executeQuery();
			if(hold_dtls==null)	hold_dtls = new ArrayList();
			else{
				hold_dtls = null;
				hold_dtls = new ArrayList();
			}
			while(resultSet.next()){
				
				hold_dtls.add(DateUtils.convertDate(resultSet.getString(1),"DMYHM","en",locale));//FULL DATE & TIME OF CHECK_IN
				hold_dtls.add(resultSet.getString(2));//DESC OF HOLDING_BAY
				hold_dtls.add(resultSet.getString(3));//HH:MI FORMATS
				hold_dtls.add(resultSet.getString(4));//CODE
				hold_dtls.add(DateUtils.convertDate(resultSet.getString(5),"DMY","en",locale));//DATE
				hold_dtls.add(resultSet.getString(6));//SPECIALITY_CODE
			}			
		}catch (Exception e){
            e.printStackTrace() ;
		}
		finally{
		  try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
		  }catch(Exception e){}
		}
	 }
	 public ArrayList getHoldingAreaDtls(){
		if(hold_dtls==null)	hold_dtls=new ArrayList();
		return hold_dtls;
	 }
	 public void cleartHoldingAreaDtls(){
		if(hold_dtls!=null)
			hold_dtls=null;	
	 }

	public String updateAndCommitHoldingAreaDtls(HashMap map){
		Connection connection  = null;
		CallableStatement cstmt= null;
		locale	= (String) getProperties().getProperty("LOCALE");
		String error_text = "";
		String status	  = "";
		String flag ="";

		//String hold_area_chrging_stg=(String)map.get("hold_area_chrging_stg"); //Common-ICN-0055
		String chk_holding_area_chrg_yn_stg=(String)map.get("chk_holding_area_chrg_yn_stg");
		String charge_hold_area_yn=(String)map.get("charge_hold_area_yn");
		String mode=(String)map.get("mode");
		String calc_charge_units=(String)map.get("calc_charge_units");

		try{
			connection	= getConnection() ;
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,?,?,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,"04");	//Function ID
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,(String)map.get("oper_num"));
			cstmt.setString(4,(String)map.get("change_holding_code"));
			cstmt.setString(5,(String)map.get("change_date_time"));
			cstmt.setString(6,"N"); // DOC_COMPL_YN	
			cstmt.setString(7,(String)map.get("bill_acc_temp"));
			cstmt.setString(8,(String)map.get("chk_out_dt_time"));
			cstmt.setString(9,(String)map.get("calc_charge_units"));
			cstmt.setString(10,(String)map.get("modified_charge_units"));
			if(("Y").equals(chk_holding_area_chrg_yn_stg) && ("Y").equals(charge_hold_area_yn)){
				cstmt.setString(11,(String)map.get("accession_line_num"));
			}else{
				cstmt.setString(11,(String)map.get("accession_num"));
			}
			cstmt.setString(12,(String)map.get("slate_user_id"));
			cstmt.setString(13,login_at_ws_no);
			cstmt.registerOutParameter(14,Types.VARCHAR);
			cstmt.registerOutParameter(15,Types.VARCHAR);	
			cstmt.registerOutParameter(16,Types.VARCHAR);	
			cstmt.execute();
			status = cstmt.getString(14);
			if(status.equals("E")){
				error_text = CommonBean.checkForNull(cstmt.getString(16));
			    connection.rollback();
			   
			 }else{
				
				if(("Y").equals(chk_holding_area_chrg_yn_stg) && ("Y").equals(charge_hold_area_yn) && mode.equals("insert") && !calc_charge_units.equals("")){

					flag=updateHoldingAreaPopulateIntercaceRecs(map,connection);
					if(!"SUCCESS".equals(flag) ) {
							error_text+=flag;
					}else{
							 error_text = "RECORD_INSERTED";
							 connection.commit(); // Newly added for checking purpose...
						 }
				 }else{
					 error_text = "RECORD_INSERTED";
					 connection.commit();
				 }
			 }
	
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

	public String updateHoldingAreaPopulateIntercaceRecs(HashMap map,Connection connection){
		//Connection connection  = null;
		CallableStatement cstmt= null;
//		Hashtable messageHashtable = null;
		locale	= (String) getProperties().getProperty("LOCALE");
		String hold_area_chrg_stg=(String)map.get("hold_area_chrging_stg");
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
			cstmt.setString(3,(String)map.get("episode_type"));//Episode Type
			cstmt.setString(4,(String)map.get("patient_id"));//Patient_id
			cstmt.setString(5,(String)map.get("episode_id"));//Episode Id
			cstmt.setString(6,(String)map.get("visit_id"));//visit_id
			cstmt.setString(7,(String)map.get("accession_num"));//accession_num
			cstmt.setString(8,(String)map.get("bill_acc_temp"));//line_num bill_acc_temp
			//cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,(String)map.get("accession_num"));//accession_num
			cstmt.setString(11,(String)map.get("bill_acc_temp"));//line_num
			//cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,(String)map.get("service_code"));//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,(String)map.get("change_holding_code"));//holding_bay_code
			cstmt.setString(16,(String)map.get("change_holding_desc"));//holding_bay_desc
			cstmt.setString(17,(String)map.get("modified_charge_units"));//modified_charge_units
			cstmt.setString(18,(String)map.get("surgeon_code"));//surgeon_code
			cstmt.setString(19,(String)map.get("inc_exe_blng_wdw"));//reason_inc_exc
			cstmt.setString(20,(String)map.get("reason_inc_exc"));//inc_exe_blng_wdw
			cstmt.setString(21,(String)map.get("slate_user_id"));//login_id  ---> to be change
			cstmt.setString(22,login_at_ws_no);//ws_no
			cstmt.registerOutParameter(23,Types.VARCHAR);
			cstmt.registerOutParameter(24,Types.VARCHAR);	
			cstmt.registerOutParameter(25,Types.VARCHAR);


			cstmt.execute();



			err_text+=CommonBean.checkForNull(cstmt.getString(23));
			err_text+=CommonBean.checkForNull(cstmt.getString(24));
			err_text+=CommonBean.checkForNull(cstmt.getString(25));
			mesg_id  =CommonBean.checkForNull(cstmt.getString(23));

			
			if(!err_text.equals("")){

				err_desc+=getMessag(mesg_id);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				connection.rollback();
			
			}else{
	
				if("H".equals(hold_area_chrg_stg)){
					flag=updateHoldingAreaPopulateIntercaceRecsOTF(map,connection);
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
               // closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }

		return (err_desc.equals(""))?"SUCCESS":err_desc;

	
	}


public String updateHoldingAreaPopulateIntercaceRecsOTF(HashMap map,Connection connection){
		//Connection connection  = null;
		CallableStatement cstmt= null;
//		Hashtable messageHashtable = null;
		locale	= (String) getProperties().getProperty("LOCALE");
		String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";
		String flag="";

//		String v_err_code="";
//		String v_sys_message_id="";
//		String v_error_text="";
//		String bill_process_v_error_text="";
		
		try{
		//	connection	= getConnection() ;
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.populate_interfaced_recs(?,?,?,?,?,?,NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,NULL,?,SYSDATE, NULL,NULL,NULL,?,?,?,?,NULL,NULL,NULL,NULL,NULL, NULL,NULL,NULL,NULL,?,?,?)}");
			cstmt.setString(1,"OTF");	//
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,(String)map.get("episode_type"));//Episode Type
			cstmt.setString(4,(String)map.get("patient_id"));//Patient_id
			cstmt.setString(5,(String)map.get("episode_id"));//Episode Id
			cstmt.setString(6,(String)map.get("visit_id"));//visit_id
			cstmt.setString(7,(String)map.get("accession_num"));//accession_num
			cstmt.setString(8,(String)map.get("bill_acc_temp"));//line_num
			//cstmt.setString(8,"1");//Primary Key main --line_num
			cstmt.setString(9,"OT");
			cstmt.setString(10,(String)map.get("accession_num"));//accession_num
			cstmt.setString(11,(String)map.get("bill_acc_temp"));//line_num
			//cstmt.setString(11,"1");//Secondday key main --- line_num
			cstmt.setString(12,"S");//Service
			cstmt.setString(13,(String)map.get("service_code"));//service_code
			cstmt.setString(14,"OTF");//OTF
			cstmt.setString(15,(String)map.get("change_holding_code"));//holding_bay_code
			cstmt.setString(16,(String)map.get("change_holding_desc"));//holding_bay_desc
			cstmt.setString(17,(String)map.get("modified_charge_units"));//modified_charge_units
			cstmt.setString(18,(String)map.get("surgeon_code"));//surgeon_code
			cstmt.setString(19,(String)map.get("inc_exe_blng_wdw"));//reason_inc_exc
			cstmt.setString(20,(String)map.get("reason_inc_exc"));//inc_exe_blng_wdw
			cstmt.setString(21,(String)map.get("slate_user_id"));//login_id  ---> to be change
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
				err_desc+=getMessag(mesg_id);
				if(("").equals(err_desc))
                err_desc+=err_text;
				err_text="";
				connection.rollback();
				
			}
			else{

				flag=updateHoldingAreaProcessIntercaceRecs(map,connection);
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
                //closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
        return (err_desc.equals(""))?"SUCCESS":err_desc;
	
	}


public String updateHoldingAreaProcessIntercaceRecs(HashMap map,Connection connection){
		CallableStatement cstmt= null;
		PreparedStatement pstmt= null;
		locale	= (String) getProperties().getProperty("LOCALE");

		String err_text			= "";
		String err_desc		= "";
		String mesg_id			= "";


		try{
			cstmt=connection.prepareCall("{call Bl_Proc_For_Ext_Service_Mp.process_interfaced_rec(?,?,?,?,?,?, ?,?,?,?,?,?,?)}");
			cstmt.setString(1,login_facility_id);//facility_id
			cstmt.setString(2,(String)map.get("patient_id"));//Patient_id
			cstmt.setString(3,(String)map.get("episode_type"));//Episode Type
			cstmt.setString(4,(String)map.get("episode_id"));//Episode Id
			cstmt.setString(5,(String)map.get("visit_id"));//visit_id
			cstmt.setString(6,(String)map.get("accession_num"));//accession_num
			cstmt.setString(7,"OT");
			cstmt.setString(8,(String)map.get("accession_num"));//accession_num
			cstmt.setString(9,(String)map.get("slate_user_id"));//login_id  ---> to be change
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
				err_desc+=getMessag(mesg_id);
				err_text="";
				connection.rollback();
				
			}else{
				String update_hold_chrg_yn="UPDATE OT_POST_OPER_HDR SET HLD_CHRG_CMP_YN  ='Y' WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM = ?";
				pstmt=connection.prepareStatement(update_hold_chrg_yn);
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,(String)map.get("oper_num"));

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
             }catch(Exception es){es.printStackTrace();}
        }

		 return (err_desc.equals(""))?"SUCCESS":err_desc;


	}





	public String updateAndCommitCheckinToORDtls(HashMap map){
		Connection connection  = null;
		CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		locale	= (String) getProperties().getProperty("LOCALE");
		try{
			connection	= getConnection() ;
			//cstmt=connection.prepareCall("{call OT_UPDATE_STATUS(?,?,null,?,null,?,?,null,null,null,null,null,null,?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,?,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,?,?,?,?,?)}");
			
			cstmt.setString(1,"05");	//Function ID
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,(String)map.get("oper_num"));
			//cstmt.setString(4,(String)map.get("change_holding_code"));
			//cstmt.setString(4,(String)map.get("change_date_time"));
			cstmt.setString(4,(String)map.get("change_date_time"));
			cstmt.setString(5,"N"); // DOC_COMPL_YN	
			// the null fields are additional fields...not used in this function
			cstmt.setString(6,(String)map.get("slate_user_id"));
			cstmt.setString(7,login_at_ws_no);
			cstmt.registerOutParameter(8,Types.VARCHAR);
			cstmt.registerOutParameter(9,Types.VARCHAR);	
			cstmt.registerOutParameter(10,Types.VARCHAR);	
			cstmt.execute();
			connection.commit();
			status = cstmt.getString(8);
			if(status.equals("E")){
				error_text = cstmt.getString(10);
			}else{
				error_text = "RECORD_INSERTED";
			}
			cstmt.close();
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
				 
			System.err.println("527,order_id==="+order_id+"==booking_num=="+booking_num+"==oper_num=="+oper_num+"==speciality_code=="+speciality_code);	 
			 connection = getConnection();
		     cstmt=connection.prepareCall("{call OT_OPER_CHECKLISTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?)}");
		 	 cstmt.setString(1,login_facility_id);
			 cstmt.setString(2,"P");// V_PRE_OR_POST ="Pre" for checkin,checkoutfromward & holdingarea
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
			 System.err.println("553,(7)==="+cstmt.getString(7)+"==(8)=="+cstmt.getString(8)+"==(9)=="+cstmt.getString(9)+"==(10)=="+cstmt.getString(10)+"==(11)=="+cstmt.getString(11)+"==(12)=="+cstmt.getString(12));	 
			
	    }
		catch (Exception e){
            e.printStackTrace() ;
		}
		finally{
		  try{
			closeStatement( cstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
		System.err.println("561,getOperChecklists,result==="+result);
		return result;
	}

	public ArrayList getUserInfo(String booking_num, String oper_num, String current_level, String order_id){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList result=new ArrayList();
		try{
			// if appt_yn = Y, it is completed and booking_num is to be considered
			// if appt_yn = N, it is waitlisted and order_id is to be considered

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
			pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT6"));
			System.err.println("597,getUserInfo,query==="+OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT6"));
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			pstmt.setString(4,order_id);
			System.err.println("602,getUserInfo,booking_num==="+booking_num+"==oper_num=="+oper_num+"==order_id=="+order_id);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("PRE_OP_CHKLST_USR3_ID"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR3_COMPL_YN"));
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
		System.err.println("617,getUserInfo,result==="+result);
		return result;
	}

	 public String getCheckListReqdYNFlag(String function_id){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String check_for_check_list_compl="";
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
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

	public  String getMessag(String mesg_id){
		Connection con = null;
		StringBuilder sbr = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String err_desc = "";
//		String err_mesg = "";
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
		con = getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,mesg_id);
		rst = pstmt.executeQuery();
//		int count=0;
		while(rst.next()){
		err_desc=CommonBean.checkForNull(rst.getString(1));
		}
		}catch(Exception e){
            e.printStackTrace() ;
		}finally{
		try{
		sbr.setLength(0);
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		con.close();
		}catch(Exception e){}
		}
		return err_desc;
   }

}
