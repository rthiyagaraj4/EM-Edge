/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH ;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import eOH.Common.OHAdapter;
import java.util.Properties;
import com.ehis.util.DateUtils;
import eCommon.Common.CommonBean;

public class OHBillingBean extends OHAdapter implements Serializable {
	String total_pay_for_trmt = "";

	public OHBillingBean() {
		try {
			doCommon();
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {}

	public void clear(){}

public ArrayList getPanelIndicatorAndCode(String task_code,String episode_type,String trmt_or_task){
		ArrayList list = new ArrayList(2);
		Connection connection  = null ;
		CallableStatement cstmt= null ;
		//String catalog_code = getOrderCatalogCode(task_code,trmt_or_task);	//Commented Against Common-ICN-0031
		try{
			connection	= getConnection() ;
			cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_ORDER_CATALOG_DTLS(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,"OH");//P_MODUlE_ID
			cstmt.setString(2,task_code);//catalog_code
			cstmt.setString(3,episode_type);//P_EPISODE_TYPE
			cstmt.registerOutParameter(4,Types.VARCHAR);//P_ORDER_CATALOG_CODE
			cstmt.registerOutParameter(5,Types.VARCHAR);//P_SERV_PANEL_IND
			cstmt.registerOutParameter(6,Types.VARCHAR);//P_SERV_PANEL_CODE
			cstmt.registerOutParameter(7,Types.VARCHAR);//P_CHARGING_STAGE
			cstmt.registerOutParameter(8,Types.VARCHAR);//p_err_code
			cstmt.registerOutParameter(9,Types.VARCHAR);//p_sys_message_id
			cstmt.registerOutParameter(10,12);//p_error_text
			cstmt.execute();
			list.add(cstmt.getString(5));
			list.add(cstmt.getString(6));
			//Here accept the error codes also so that in case of any error, it can be displayed in the front-end
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                closeStatement( cstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return  list;
	}

	public HashMap getBillingInfo(HashMap map){
		Connection connection  = null ;
		CallableStatement cstmt= null ;
		String[] charge_arr=null;
		String order_catalog = getOrderCatalogCode((String) map.get("task_code"),(String) map.get("trmt_or_task"));
		order_catalog = ("".equals(order_catalog))?(String) map.get("task_code"):order_catalog;
		
		try{
			connection	= getConnection() ;
			cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//cstmt.setString(1,login_facility_id);				    //P_FACILITY_ID
			cstmt.setString(1,(String)map.get("facility_id"));				    //P_FACILITY_ID
			cstmt.setString(2,(String)map.get("module_id"));		//P_MODULE_ID
			cstmt.setString(3,(String)map.get("key"));				//P_KEY	--->( ORDER_ID )
			cstmt.setString(4,(String)map.get("key_line_no"));		
			cstmt.setString(5,(String)map.get("episode_type"));	    //P_EPISODE_TYPE
			cstmt.setString(6,(String)map.get("patient_id"));	    //P_PATIENT_ID
			cstmt.setString(7,(String)map.get("episode_id"));	    //P_EPISODE_ID
			cstmt.setString(8,(String)map.get("visit_id"));		    //P_VISIT_ID
			cstmt.setString(9,(String)map.get("encounter_id"));	    //P_DUMMY1
			cstmt.setString(10,null);							    //ACCT_SEQ_NUMBER
			//cstmt.setString(11,(String)map.get("service_date"));  //P_SERVICE_DATE
			cstmt.setString(11,order_catalog);						//P_ITEM_CODE
			cstmt.setString(12,(String)map.get("serv_panel_ind"));  //P_SERV_PANEL_IND
			cstmt.setString(13,(String)map.get("serv_panel_code")); //P_SERV_PANEL_CODE
			cstmt.setString(14,(String) map.get("quantity") );		//P_SERV_QTY
			cstmt.setString(15,null);								//P_CHARGE_BASED_AMT
			cstmt.setString(16,"P");								//P_PRACT_STAFF_IND
			cstmt.setString(17,(String)map.get("pract_staff_id"));	//P_PRACT_STAFF_ID
			cstmt.registerOutParameter(18,Types.VARCHAR);			//P_STR
			cstmt.registerOutParameter(19,Types.VARCHAR);			//P_CHARGE_BASED_YN
			cstmt.registerOutParameter(20,Types.FLOAT);				//P_TOT_AMT
			cstmt.registerOutParameter(21,Types.FLOAT);				//P_PAT_PAYABLE_AMT
			cstmt.registerOutParameter(22,Types.VARCHAR);			//P_EXCL_INCL_IND
			cstmt.registerOutParameter(23,Types.VARCHAR);			//P_PREAPP_YN
			cstmt.setString(24,null);								//P_EXCL_INCL_ACTION_IND
			cstmt.setString(25,null);								//P_ACTION_REASON_CODE
			cstmt.registerOutParameter(26,Types.FLOAT);				//P_PAT_PAID_AMT
			cstmt.registerOutParameter(27,Types.VARCHAR);			//P_CHARGED_YN
			cstmt.registerOutParameter(28,Types.VARCHAR);			//P_PAT_BILLED_YN
			cstmt.setString(29,(String)map.get("locale"));			//P_LANGUAGE_ID
			cstmt.registerOutParameter(30,Types.VARCHAR);			//P_ERROR_LEVEL
			cstmt.registerOutParameter(31,Types.VARCHAR);			//P_SYS_MESSAGE_ID
			cstmt.registerOutParameter(32,Types.VARCHAR);			//P_ERROR_TEXT
			cstmt.execute();

			String panel_str = checkForNull(cstmt.getString(18));
			charge_arr =panel_str.split("#");

			String p_excl_incl_action_ind = charge_arr[2];
			if(p_excl_incl_action_ind.equals("") || p_excl_incl_action_ind.equals("null") || p_excl_incl_action_ind.equals(null) || p_excl_incl_action_ind.equals(" ") ){
				p_excl_incl_action_ind = charge_arr[7];
			}

		  	map.put("quantity"         ,(String) map.get("quantity"));
			map.put("bl_panel_str"     , CommonBean.checkForNull(cstmt.getString(18)));
			map.put("charge_based_yn"     , CommonBean.checkForNull(cstmt.getString(19)));
			map.put("total_payable"    , CommonBean.checkForNull(cstmt.getString(20)));
			map.put("patient_payable"  , CommonBean.checkForNull(cstmt.getString(21)));
			//map.put("incl_excl_ind" , CommonBean.checkForNull(cstmt.getString(22)));
			map.put("incl_excl_ind" , p_excl_incl_action_ind);
			map.put("preapp_yn"        , CommonBean.checkForNull(cstmt.getString(23)));
			map.put("patient_paid_amt" , CommonBean.checkForNull(cstmt.getString(26)));
			map.put("charged_yn"       , CommonBean.checkForNull(cstmt.getString(27)));
			map.put("billed_yn"       , CommonBean.checkForNull(cstmt.getString(28)));
			map.put("err_id"       , CommonBean.checkForNull(cstmt.getString(31)));
			map.put("err_text"       , CommonBean.checkForNull(cstmt.getString(32)));
			map.put("order_catalog",order_catalog);
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                closeStatement( cstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return  map;
	}


	public HashMap formatBillingDetails(ArrayList bill_dtls){
		HashMap bill_map = new HashMap();
		//String emt = "".intern();
		if(bill_dtls!=null && bill_dtls.size()>0){
			String[] bill_info = (String[]) bill_dtls.get(0);
			bill_map.put("bl_panel_str",bill_info[0]);                //P_STR
			bill_map.put("charge_based_yn",bill_info[1]);        //P_CHARGE_BASED_YN
			bill_map.put("total_payable",bill_info[2]);            //P_TOT_AMT
			bill_map.put("patient_payable",bill_info[3]);        //P_PAT_PAYABLE_AMT
			bill_map.put("excl_incl_ind",bill_info[4]);            //P_EXCL_INCL_IND
			bill_map.put("preapp_yn",bill_info[5]);              //P_PREAPP_YN
			bill_map.put("patient_paid_amt",bill_info[6]);    //P_PAT_PAID_AMT
			bill_map.put("charged_yn",bill_info[7]);           //P_CHARGED_YN
			bill_map.put("pat_billed_yn",bill_info[8]);         //P_PAT_BILLED_YN
			bill_map.put("error_text",bill_info[9]);            //ERROR_TEXT
			bill_map.put("serv_panel_ind",bill_info[10]);    //P_SERV_PANEL_IND
			bill_map.put("serv_panel_code",bill_info[11]); //P_SERV_PANEL_CODE
			bill_map.put("service_panel_name",bill_info[12]);//P_SERVICE_PANEL_NAME
			bill_map.put("episode_type",bill_info[13]);      //P_EPISODE_TYPE
			bill_map.put("episode_id",bill_info[14]);        //P_EPISODE_ID
			bill_map.put("visit_id",bill_info[15]);          //P_VISIT_ID
			//other billing details
			bill_map.put("pract_staff_ind","P");

	}
	return bill_map;

	}


	public String getOrderCatalogCode(String task_code,String trmt_or_task){
		String SQL = "";
		if(trmt_or_task.equals("TASK")){
			SQL = "SELECT ORDER_CATALOG_CODE FROM OH_TASKS WHERE TASK_CODE=?";
		}
		else if(trmt_or_task.equals("TRMT")){
			SQL = "SELECT ORDER_CATALOG_CODE FROM OH_TREATMENT WHERE TRMT_CODE=?";
		}
		Connection connection  = null ;
		PreparedStatement pstmt= null ;
		ResultSet rst = null;
		String result="";

		try{
			connection	= getConnection() ;
			pstmt=connection.prepareStatement(SQL);
			pstmt.setString(1,task_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				result = rst.getString(1);
			}
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				if(rst!=null) rst.close();
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return  result;
	}

	public ArrayList getEpisodeAndVisitId(String encounter_id){
		String SQL = "SELECT EPISODE_ID, OP_EPISODE_VISIT_NUM FROM PR_ENCOUNTER WHERE ENCOUNTER_ID = ?";
		Connection connection  = null ;
		PreparedStatement pstmt= null ;
		ResultSet rst = null;
		ArrayList result = new ArrayList();
		String episode_id="";
		String visit_id="";

		try{
			connection	= getConnection() ;
			pstmt=connection.prepareStatement(SQL);
			pstmt.setString(1,encounter_id);
			rst = pstmt.executeQuery();
			while(rst.next()){
				episode_id = rst.getString(1);
				visit_id = rst.getString(2);
			}
			result.add(episode_id);
			result.add(visit_id);
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				if(rst!=null) rst.close();
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return  result;

	}

	
	//public ArrayList getBillDetails(String treatment_tasks_code,String episode_type,String module_id,String key,String key_line_no,String patient_id,String episode_id,String visit_id,String encounter_id,String quantity,String pract_staff_id,String facility_id,String locale,String trmt_or_task){
	public HashMap getBillDetails1(String treatment_tasks_code,String episode_type,String module_id,String key,String key_line_no,String patient_id,String episode_id,String visit_id,String encounter_id,String quantity,String pract_staff_id,String facility_id,String locale,String trmt_or_task){
		//HttpSession session=req.getSession(false);
		//java.util.Properties prop = null;
		//String facility_id = (String)session.getValue( "facility_id" ) ;
		//prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		//String locale = prop.getProperty("LOCALE");

		String serv_panel_ind = "";
		String serv_panel_code = "";
		//String bl_key = "";
		String patient_payable = "";
		String patient_paid_amt = "";
		String total_payable = "";

		ArrayList bl_str_list = null;
		ArrayList bill_detail_list = new ArrayList();
		HashMap bl_str_map = null;
		HashMap bill_map = null;
		try{
			//connection	= getConnection() ;
			bl_str_list = getPanelIndicatorAndCode(treatment_tasks_code,episode_type,trmt_or_task);
			serv_panel_ind = (String)bl_str_list.get(0);
			serv_panel_code = (String)bl_str_list.get(1);

			bill_map = new HashMap();
			bill_map.put("facility_id",facility_id);
			bill_map.put("module_id",module_id);
			bill_map.put("key",key);
			bill_map.put("key_line_no",key_line_no);
			bill_map.put("episode_type",episode_type);
			bill_map.put("patient_id",patient_id);
			bill_map.put("episode_id",episode_id);
			bill_map.put("visit_id",visit_id);
			bill_map.put("encounter_id",encounter_id);
			bill_map.put("serv_panel_ind",serv_panel_ind);
			bill_map.put("serv_panel_code",serv_panel_code);
			bill_map.put("quantity",quantity);
			bill_map.put("pract_staff_id",pract_staff_id);
			bill_map.put("locale",locale);
			bill_map.put("task_code",treatment_tasks_code);
			bill_map.put("trmt_or_task",trmt_or_task);
			
			bl_str_map = getBillingInfo(bill_map);
			
			patient_payable = (String)bl_str_map.get("patient_payable");
			patient_paid_amt = (String)bl_str_map.get("patient_paid_amt");
			total_payable = (String)bl_str_map.get("total_payable");

			bill_detail_list.add(patient_payable);
			bill_detail_list.add(patient_paid_amt);
			bill_detail_list.add(total_payable);

		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				//Common-ICN-0044
				bl_str_list.clear();	
				bill_detail_list.clear();	
				bill_map.clear();	
				//Common-ICN-0044
                //closeStatement( cstmt ) ;
                //closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		//return  bill_detail_list;
		return  bl_str_map;
	}

	public ArrayList getBillDetails(String treatment_tasks_code,String episode_type,String module_id,String key,String key_line_no,String patient_id,String episode_id,String visit_id,String encounter_id,String quantity,String pract_staff_id,String facility_id,String locale,String trmt_or_task){
		//HttpSession session=req.getSession(false);
		//java.util.Properties prop = null;
		//String facility_id = (String)session.getValue( "facility_id" ) ;
		//prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		//String locale = prop.getProperty("LOCALE");

		String serv_panel_ind = "";
		String serv_panel_code = "";
		//String bl_key = "";
		String patient_payable = "";
		String patient_paid_amt = "";
		String total_payable = "";
		String incl_excl_ind = "";
		String preapp_yn = "";


		ArrayList bl_str_list = null;
		ArrayList bill_detail_list = new ArrayList();
		HashMap bl_str_map = null;
		HashMap bill_map = null;
		try{
			//connection	= getConnection() ;
			bl_str_list = getPanelIndicatorAndCode(treatment_tasks_code,episode_type,trmt_or_task);

			serv_panel_ind = (String)bl_str_list.get(0);
			serv_panel_code = (String)bl_str_list.get(1);

			bill_map = new HashMap();
			bill_map.put("facility_id",facility_id);
			bill_map.put("module_id",module_id);
			bill_map.put("key",key);
			bill_map.put("key_line_no",key_line_no);
			bill_map.put("episode_type",episode_type);
			bill_map.put("patient_id",patient_id);
			bill_map.put("episode_id",episode_id);
			bill_map.put("visit_id",visit_id);
			bill_map.put("encounter_id",encounter_id);
			bill_map.put("serv_panel_ind",serv_panel_ind);
			bill_map.put("serv_panel_code",serv_panel_code);
			bill_map.put("quantity",quantity);
			bill_map.put("pract_staff_id",pract_staff_id);
			bill_map.put("locale",locale);
			bill_map.put("task_code",treatment_tasks_code);
			bill_map.put("trmt_or_task",trmt_or_task);
			
			bl_str_map = getBillingInfo(bill_map);
			
			patient_payable = (String)bl_str_map.get("patient_payable");
			patient_paid_amt = (String)bl_str_map.get("patient_paid_amt");
			total_payable = (String)bl_str_map.get("total_payable");
			incl_excl_ind = (String)bl_str_map.get("incl_excl_ind");
			preapp_yn = (String)bl_str_map.get("preapp_yn");
			
			bill_detail_list.add(patient_payable);
			bill_detail_list.add(patient_paid_amt);
			bill_detail_list.add(total_payable);
			bill_detail_list.add(incl_excl_ind);
			bill_detail_list.add(preapp_yn);
			bill_detail_list.add(serv_panel_ind);

		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				//Common-ICN-0044
				bl_str_list.clear();	
				bill_detail_list.clear();	
				bl_str_map.clear();	
				bill_map.clear();	
				//Common-ICN-0044
                //closeStatement( cstmt ) ;
                //closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return  bill_detail_list;
		//return  bl_str_map;
	}

	public String GeneratePatientBill( HashMap bill_map){

		String[] charge_arr=null;
		String err_text			= "";
		String err_desc			= "";
		String mesg_id			= "";
		//String oper_code		= "";

		//values getting from Passed HashMap
		String facility_id		= (String)bill_map.get("facility_id") ;
		String patient_id		= (String)bill_map.get("patient_id") ;
		String episode_id		= (String)bill_map.get("episode_id") ;
		String encounter_id		= (String)bill_map.get("encounter_id") ;
		String visit_id			= (String)bill_map.get("visit_id") ;
		String episode_type		= (String)bill_map.get("episode_type") ;
		String patient_class	= (String)bill_map.get("patient_class") ;
		String surgeon_code		= (String)bill_map.get("surgeon_code") ;
		String chart_num		= (String)bill_map.get("chart_num") ;
		//String chart_line_num	= (String)bill_map.get("chart_line_num") ;
		String order_id			= (String)bill_map.get("order_id") ;
		String order_line_num	= (String)bill_map.get("order_line_num") ;
		String task_code		= (String)bill_map.get("task_code") ;
		String task_desc		= (String)bill_map.get("task_desc") ;

		//String key				= (String)bill_map.get("key");
		//String key_line			= (String)bill_map.get("key_line");
		String task_order_catalog_code	= (String) bill_map.get("task_order_catalog_code");
		String panel_str		= (String) bill_map.get("bl_panel_str");
		String service_date		= (String)bill_map.get("service_date") ;
		String current_charging_stage		= (String) bill_map.get("current_charging_stage");
		String serv_panel_ind		= (String) bill_map.get("serv_panel_ind");
		String ws_no			= (String)bill_map.get("login_at_ws_no") ;

		// if call_process_yn is Y, then the Billing Process has to be invoked, otherwise only populate interface rec has to be invoked.
		// In either case, populate interface rec has to be called mandatorily.
		String call_process_yn	= (String)bill_map.get("call_process_yn");
		String override_inc_exl	= (String)bill_map.get("override_inc_exl");
		String reason_override_inc_exl	= (String)bill_map.get("reason_override_inc_exl");

		String bl_episode_type  = getBillingEpisodeType(patient_class,episode_type);

		Connection con= null;
		CallableStatement cstmt = null;
		try{
			con	= getConnection() ;
			cstmt=con.prepareCall("{call OH_BILLING_PACKAGE.BL_INTERFACE_TASK_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			/*
			 if current transaction is to perform Register Order, current_charging_stage = "REG" (to be done at later stage)
			 if current transaction is to perform Result Entry, current_charging_stage = "RST"
			 if current transaction is Mark Error, current_charging_stage = "CAN"
			*/

			cstmt.setString(1,facility_id );			//v_facility_id		VARCHAR2,
			cstmt.setString(2,patient_id );				//v_patient_id		VARCHAR2,
			cstmt.setString(3,episode_id );				//v_episode_id		VARCHAR2,
			cstmt.setString(4,encounter_id );			//v_encounter_id	VARCHAR2,
			cstmt.setString(5,visit_id );				//v_visit           VARCHAR2,
			cstmt.setString(6,order_id);				//v_order_id        VARCHAR2,
			cstmt.setString(7,order_line_num);			//v_ord_line_no		VARCHAR2,
			cstmt.setString(8,task_code);				//v_task_code	VARCHAR2,
			cstmt.setString(9,"Y");						//v_bl_interfaced		VARCHAR2,
			cstmt.setString(10,bl_episode_type );		//v_bl_episode_type		VARCHAR2,
			if(current_charging_stage.equals("CAN")){
				cstmt.setString(11,order_id);	//SECONDARY KEY (order_id_chart_num	VARCHAR2,
			}else{
				cstmt.setString(11,order_id+"_"+chart_num );	//SECONDARY KEY (order_id_chart_num	VARCHAR2,
			}
			cstmt.setString(12,order_line_num);			//secondary key line num order_line_num			VARCHAR2,
			cstmt.setString(13,current_charging_stage );//v_stage				VARCHAR2,
			cstmt.setString(14,service_date );			//v_service_date		VARCHAR2, -- FORMAT SHOULD BE 'DD/MM/YYYY HH24:MI'
			cstmt.setString(15,surgeon_code );			//v_phy_id				VARCHAR,
			cstmt.setString(16,ws_no ) ;				//v_ws_no				VARCHAR2,
			cstmt.setString(17,task_order_catalog_code) ;					//v_catalog_code IN OUT VARCHAR2,
			cstmt.setString(18,task_desc);				//v_oper_desc		VARCHAR2,
			cstmt.setString(19,panel_str);				//panel Str		//v_revised_billing_details	VARCHAR2,
			cstmt.registerOutParameter(20,Types.VARCHAR);		//v_serv_panel_ind	OUT     VARCHAR2,
			cstmt.registerOutParameter(21,Types.VARCHAR);		//v_blng_srvc_code	OUT     VARCHAR2,
			cstmt.registerOutParameter(22,Types.VARCHAR);		//v_charge_stage	OUT     VARCHAR2,
			cstmt.registerOutParameter(23,Types.VARCHAR);		//err_code			OUT     VARCHAR2,
			cstmt.registerOutParameter(24,Types.VARCHAR);		//v_sys_message_id	OUT     VARCHAR2,
			cstmt.registerOutParameter(25,Types.VARCHAR);		//error_text		OUT     VARCHAR2,
			cstmt.registerOutParameter(26,Types.VARCHAR);		//v_preapp_msg		OUT     VARCHAR2,
			cstmt.registerOutParameter(27,Types.VARCHAR);		//v_excl_msg		OUT     VARCHAR2,
			cstmt.registerOutParameter(28,Types.VARCHAR);		//V_LANG_ERR_MSG_ID	OUT	    VARCHAR2,
			cstmt.setString(29,"N");							//P_FUTURE_ORDER_YN			VARCHAR2 DEFAULT 'N'
			if(panel_str!=null && !panel_str.equals("")){
				/*
				charge_arr = panel_str.split("<NR>")	;
				if(charge_arr.length<3){
					charge_arr =panel_str.split("#");
					cstmt.setString(30,charge_arr[9]);//qty
					cstmt.setString(31,charge_arr[10]);//payable_amount
					cstmt.setString(32,charge_arr[2]);//include exclude indicator
					cstmt.setString(33,charge_arr[3]);//reason_code
				}else{
					charge_arr[1].split("#");
					cstmt.setString(30,"1");//qty
					cstmt.setString(31,"");//payable_amount
					cstmt.setString(32,charge_arr[2]);//include exclude indicator
					cstmt.setString(33,charge_arr[3]);//reason_code
				}
				*/
				if(serv_panel_ind.equals("S")){
					charge_arr =panel_str.split("#");
					cstmt.setString(30,charge_arr[9]);//qty
					//cstmt.setString(30,"1.0");//qty
					cstmt.setString(31,charge_arr[10]);//payable_amount
					//cstmt.setString(32,charge_arr[2]);//include exclude indicator
					cstmt.setString(32,override_inc_exl);//include exclude indicator
					//cstmt.setString(33,charge_arr[3]);//reason_code
					cstmt.setString(33,reason_override_inc_exl);//reason_code
				}else if(serv_panel_ind.equals("L")){
					cstmt.setString(30,"1");//qty
					cstmt.setString(31,"");//payable_amount
					cstmt.setString(32,"");//include exclude indicator
					cstmt.setString(33,"");//reason_code
				}
			}else{
				cstmt.setString(30,"1");//qty
				cstmt.setString(31,"");//payable_amount
				cstmt.setString(32,"");//include exclude indicator
				cstmt.setString(33,null);//reason_code
			}
			cstmt.execute();
			//con.commit();
			String sys_mesg_text = checkForNull(cstmt.getString(23));			
			String proc_err_text = checkForNull(cstmt.getString(25));			
			mesg_id = checkForNull(cstmt.getString(24));		
			 err_text+=checkForNull(sys_mesg_text);
			err_text+=checkForNull(mesg_id);
			err_text+=checkForNull(proc_err_text); 
			if(!err_text.equals("")){
				
				//err_desc+=task_desc+"::"+mesg_id;
				err_desc=err_desc+task_desc+"::"+mesg_id;
				err_text="";
			}
			if(err_desc.equals("")){
				con.commit();
				if(call_process_yn.equals("Y")){
					callProcessBill(bill_map);
				}
			}
		}catch(Exception e){
			try{
				System.err.println("Rollback performed, Err Msg in GeneratePatientBill"+e.getMessage());
				con.rollback();
			}catch(Exception e_1){
				System.err.println("GeneratePatientBill :Caught Exception during rollback"+e_1);
			}
			err_desc=e.getMessage();
			e.printStackTrace();
			
		}finally{
			try{
				bill_map.clear();
				closeStatement( cstmt ) ;
				closeConnection( con );
			}catch(Exception e){}
		}
		return (err_desc.equals(""))?"SUCCESS":err_desc;
	}

	public String getBillingEpisodeType(String patient_class,String episode_type){
		Connection con  = null;
		PreparedStatement pstmt=null;
		ResultSet rst  = null;
		String bl_episode_type = "";
		String SQL="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE  PATIENT_CLASS=? AND EPISODE_TYPE =?";
		try{
			con	= getConnection() ;
			pstmt = con.prepareStatement(SQL) ;
			pstmt.setString(1,patient_class);
			pstmt.setString(2,episode_type);
			rst= pstmt.executeQuery();
				while(rst.next()){
					bl_episode_type=rst.getString(1);
			}
		}catch (Exception e){
	          System.err.println("REC_SURG_MAN: Err Msg in getBillingEpisodeType(OHBillingBean) "+e);
		}
		finally{
		  try{
			if(rst!=null) rst.close();
			closeStatement( pstmt ) ;
			closeConnection( con );
		  }catch(Exception e){}
		}
		return bl_episode_type;
	}	

	public String callProcessBill( HashMap bill_map ){
		Connection con = null;
		CallableStatement cstmt = null;
		String facility_id = (String)bill_map.get("facility_id") ;
		String patient_id = (String)bill_map.get("patient_id") ;
		String key =  checkForNull((String)bill_map.get("key")) ;
		String order_id =  (String)bill_map.get("order_id") ;
		String chart_num =  (String)bill_map.get("chart_num") ;
		if(key.equals(""))
			key=order_id+"_"+chart_num;
		String episode_id = (String)bill_map.get("episode_id") ;
		String client_ip_address =  (String)bill_map.get("login_at_ws_no") ;
		String visit_id = (String)bill_map.get("visit_id") ;
		String patient_class = (String)bill_map.get("patient_class") ;
		String episode_type = (String)bill_map.get("episode_type") ;
		/* String override_inc_exl	= (String)bill_map.get("override_inc_exl");
		String reason_override_inc_exl	= (String)bill_map.get("reason_override_inc_exl"); */ //Commented Against Common-ICN-0031
		String err_desc = "";
		String err_code = "";
		String bl_episode_type = getBillingEpisodeType(patient_class,episode_type);
		try{
			con = getConnection();
			cstmt=con.prepareCall("{call OH_BILLING_PACKAGE.OH_BL_INTERFACED_REC(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,facility_id );
			cstmt.setString(2,patient_id );
			cstmt.setString(3,bl_episode_type );
			cstmt.setString(4,episode_id );
			cstmt.setString(5,visit_id );
			cstmt.setString(6,order_id ) ;
			cstmt.setString(7,key) ;
			cstmt.setString(8,client_ip_address );
			cstmt.registerOutParameter(9,Types.VARCHAR);
			cstmt.registerOutParameter(10,Types.VARCHAR);
			cstmt.registerOutParameter(11,Types.VARCHAR);
			cstmt.registerOutParameter(12,Types.VARCHAR);//LANG_ERR_MESG_ID NOT ADDED IN THE PROCEDURE
			cstmt.execute();
			
			err_code=checkForNull(cstmt.getString(9));
			if(checkForNull(cstmt.getString(9)).equals("") || cstmt.getString(9).equals("null") || cstmt.getString(9).equals(null)){
				err_desc="RECORD_INSERTED";
				con.commit();
			}
		}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in callProcessBill"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("callProcessBill :Caught Exception during rollback"+e_1);
				}
				err_desc=e.getMessage();
		}finally{
			try{
				closeStatement(cstmt);
				closeConnection(con);
			}catch(Exception e){}
		}
		System.err.println("OHBillingBean callProcessBill err_desc:=="+err_desc);
	   return err_desc;
	}

	public boolean isBillingInstalled(String facility_id){
	Connection con = null;
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean flag = false;
	try{
		con = getConnection();
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=con.prepareCall("{call OH_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
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
		}else{
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();

	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(con!=null)con.close();
		}catch(Exception e){}

	}
	return flag;
 }

	public void setTotalPayable(String totalPayable){
		this.total_pay_for_trmt = totalPayable;
			
	}

	public String getTotalPayable(){
		return total_pay_for_trmt;
			
	}	
	
}

