/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.ConsumableOrder ;  
import java.io.BufferedWriter;
import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList ;
import java.util.Properties ;
import java.sql.* ;

import javax.ejb.* ;
import oracle.sql.CLOB;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="ConsumableOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ConsumableOrder"
*	local-jndi-name="ConsumableOrder"
*	impl-class-name="ePH.ConsumableOrder.ConsumableOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.ConsumableOrder.ConsumableOrderLocal"
*	remote-class="ePH.ConsumableOrder.ConsumableOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.ConsumableOrder.ConsumableOrderLocalHome"
*	remote-class="ePH.ConsumableOrder.ConsumableOrderHome"
*	generate= "local,remote"
*
*
*/

public class ConsumableOrderManager extends PhEJBSessionAdapter {
  

  /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap ) {
		HashMap map			= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "EJB STARTS") ;
		map.put("msgid","INSERT");
		//Properties  prop					= null;
		Connection connection				= null ;
		PreparedStatement pstmt_insert		= null ;
		PreparedStatement pstmt				= null ;
		PreparedStatement pstmt_select		= null ;
		PreparedStatement pstmt_clob		= null ;
		CallableStatement cstmt_insert		= null;
		ResultSet rset_clob					= null;
		ResultSet resultSet					= null ;

		String patient_id			=	"";
		String encounter_id			=	"";
		String patient_class		=	"";
		String bed_num				= "";
		String room_num				= "";
		String language_id			= "";
		String facility_id			=	"";
		String login_by_id			=	"";
		String login_at_ws_no		=	"";
		String login_facility_id	=	"";
		String trn_group_ref		= "";
		String location_type			= "";
		String location_code			= "";
		String pract_id				= "";
		String regn_reqd_yn			= "";
		String order_status			= "";
		String height				= "";
		String weight				= "";
		String bsa					= "";
		String bmi					= "";
		String height_unit			= "";
		String weight_unit			= "";
		String bsa_unit				= "";
		String perf_facility		= "";
		String perf_sys				= "";
		String perf_deptloc_type	= "";
		String perf_deptloc_code	= "";
		String auth_reqd_yn	= "";
		String apprvl_reqd_yn	= "";
		String ord_authorized_yn	= "";
		String ord_approved_yn	= "";
		//String spl_app_reqd_yn	= "";
		String cosign_reqd_yn	= "";
		String item_desc	= "";
		String line_status	= "";
		String consent_reqd_yn	= "";
		//String ord_consent_reqd_yn	= "";
		String order_date        ="";
		String end_date          =""; 
		String order_id			 ="";	//Added for GHL-CRF-0470
		int srl_NO				 = 0;

		boolean insert_rec_1 = false;
		boolean insert_rec_2 = false;
		boolean insert_rec_3 = false;
		boolean insert_rec_4 = false;
		boolean insert_rec_5 = false;	//Added for GHL-CRF-0470
		int result_insert_5			= 0;	//Added for GHL-CRF-0470
		//Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 start
		String max_durn_pres="";
		PreparedStatement pstmt_max_durn			= null ;
		ResultSet rs_max_durn		= null;
		String take_home_medication  ="";
		//Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 end
		try { 
			//prop	= (Properties)tabData.get( "properties" );
			ArrayList presItemList				= (ArrayList) tabData.get("presItemList");
			ArrayList mandatory_flds			= (ArrayList) tabData.get("mandatory_flds");

			String license						= (String)tabData.get("license");
			String called_from					= (String)tabData.get("called_from");
			HashMap itemDetail				= new HashMap();
			language_id		= (String) tabData.get("language_id");
			String OrderRemarks							= (String) tabData.get("OrderRemarks");	//Added for GHL-CRF-0470
//GHL-CRF-0618
			String non_prefered_item_remarks_code = ""; 
			HashMap nonPreferenceRemarksMedicalItem = (HashMap) tabData.get("nonPreferenceRemarksMedicalItem");//GHL-CRF-0618
//GHL-CRF-0618 - end
			if(mandatory_flds.size() > 1) {
				login_by_id					= (String)mandatory_flds.get(0);
				login_at_ws_no				= (String)mandatory_flds.get(1);
				login_facility_id			= (String)mandatory_flds.get(2);
			}

			String sql_ph_prescription_select19a		        = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT19A");
			String sql_ph_prescription_select20a		        = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT20A");
			String sql_ph_prescription_select55			        = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT55");
			String SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT");
			String sql_or_order_insert							= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT1");
			String sql_or_order_line_insert						= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT2");
			String sql_or_order_line_ph_insert					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT3");
			String sql_ph_patient_drug_profile_insert			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT4");

			HashMap orderStatusCode		=	new HashMap();
			connection							= getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit(false);

			if((called_from!=null && called_from.equals("TAB")) ||(called_from!=null && called_from.equals("ORDERSET"))){
				pstmt_select								= connection.prepareStatement(SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT) ;
				resultSet							= pstmt_select.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					trn_group_ref = resultSet.getString("TRN_GROUP_REF");
					//System.out.println("trn_group_ref====146= EJB==>" +trn_group_ref);
				}
				try {
					closeResultSet( resultSet );
					closeStatement( pstmt_select) ;
				}
				catch(Exception es) {
					es.printStackTrace();
				}
			}
			else
				trn_group_ref = (String)tabData.get("trn_group_ref");
			//System.out.println("trn_group_ref====159= EJB==>" +trn_group_ref);
				
			pstmt			= connection.prepareStatement(sql_ph_prescription_select20a) ;
			resultSet		= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}

			try {
				closeResultSet( resultSet );
				closeStatement( pstmt) ;
			}catch(Exception es) {
				es.printStackTrace();
			}
			pstmt_insert		= connection.prepareStatement(sql_or_order_insert) ;
			pstmt_insert.clearBatch();
            PreparedStatement pstmt_or_order_type	= connection.prepareStatement(sql_ph_prescription_select19a) ;
  //System.err.println("==presItemList== 174==="+presItemList);
			for (int i=0;i<presItemList.size() ;i++ ){
				itemDetail=(HashMap)presItemList.get(i);

				height		=(String)itemDetail.get("HEIGHT");
				weight		=(String)itemDetail.get("WEIGHT");
				bsa			=(String)itemDetail.get("BSA");
				bmi			=(String)itemDetail.get("BMI");
				bsa_unit	=(String)itemDetail.get("BSA_UNIT");
				height_unit	=(String)itemDetail.get("HEIGHT_UOM");//changed for NMC-JD-CRF-0119
				weight_unit	=(String)itemDetail.get("WEIGHT_UOM");
				order_date  = (String)itemDetail.get("ORDERED_DATE");


				pstmt_insert.setString(1,(String)itemDetail.get("ORDER_ID"));
				pstmt_insert.setString(2,(String)itemDetail.get("ORDER_TYPE"));
				String ord_type_code=(String)itemDetail.get("ORDER_TYPE");
				
				pstmt_or_order_type.setString(1,ord_type_code);
				resultSet		= pstmt_or_order_type.executeQuery();
				if(resultSet!=null && resultSet.next()){
					regn_reqd_yn=resultSet.getString(1);
				}
				closeResultSet( resultSet );
				
				pstmt_insert.setString(3,(String)itemDetail.get("ORDER_CATEGORY"));
				pstmt_insert.setString(4,"PH");
				pstmt_insert.setString(5,(String)itemDetail.get("PATIENT_ID"));
				patient_id		= (String)itemDetail.get("PATIENT_ID");
				bed_num = (String)itemDetail.get("BED_NUM")==null?"":(String)itemDetail.get("BED_NUM");
				room_num = (String)itemDetail.get("ROOM_NUM")==null?"":(String)itemDetail.get("ROOM_NUM");
				
				patient_class	= (String)itemDetail.get("PATIENT_CLASS");
				
				facility_id		= (String)itemDetail.get("FACILITY_ID");
				encounter_id	=(String)itemDetail.get("ENCOUNTER_ID");
				location_type	=(String)itemDetail.get("SOURCE_TYPE");
				location_code	=(String)itemDetail.get("SOURCE_CODE");
				pract_id		=(String)itemDetail.get("ORD_PRACT_ID");

				pstmt_insert.setString(6,patient_class);
				pstmt_insert.setString(7,facility_id);
				pstmt_insert.setString(8,encounter_id);
				pstmt_insert.setString(9,encounter_id);
				pstmt_insert.setString(10,"");
				pstmt_insert.setString(11,location_type);
				pstmt_insert.setString(12,location_code);

				pstmt_insert.setString(13,"");//DISCHARGE_IND
				pstmt_insert.setString(14,(String)itemDetail.get("ORDERED_DATE"));
				pstmt_insert.setString(15,(String)itemDetail.get("ORD_PRACT_ID"));
				pstmt_insert.setString(16,(String)itemDetail.get("PRIORITY"));

				auth_reqd_yn =	(String)itemDetail.get("ORD_AUTH_REQD_YN")==null?"":(String)itemDetail.get("ORD_AUTH_REQD_YN");
				apprvl_reqd_yn = (String)itemDetail.get("ORD_SPL_APPR_REQD_YN")==null?"":(String)itemDetail.get("ORD_SPL_APPR_REQD_YN");
				ord_authorized_yn =	(String)itemDetail.get("ORD_AUTHORIZED_YN")==null?"":(String)itemDetail.get("ORD_AUTHORIZED_YN");
				ord_approved_yn =	(String)itemDetail.get("ORD_APPROVED_YN")==null?"":(String)itemDetail.get("ORD_APPROVED_YN");

				order_status		= (String)itemDetail.get("ORDER_STATUS");
				if(order_status.equals("10") || order_status.equals("25")){
					if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")){
						order_status="25";
					} else {
						order_status="10";
					}
				}

				order_status = (String)orderStatusCode.get(order_status);
				
				pstmt_insert.setString(17,auth_reqd_yn);
				pstmt_insert.setString(18,(String)itemDetail.get("ORD_AUTH_LEVEL"));

				if(auth_reqd_yn.equals("")||auth_reqd_yn.equals("N")){
					pstmt_insert.setString(19,"");
					pstmt_insert.setString(20,null);
				}
				else{
					pstmt_insert.setString(19,(String)itemDetail.get("ORD_PRACT_ID"));
					pstmt_insert.setString(20,(String)itemDetail.get("ORDER_DATE_TIME"));
				}

				if(itemDetail.get("ORD_APPR_REQD_YN")==null) {
					pstmt_insert.setString(21,"N");
				} 
				else {
					pstmt_insert.setString(21,(String)itemDetail.get("ORD_APPR_REQD_YN"));
				}

				pstmt_insert.setString(22,(String)itemDetail.get("ORD_APPR_BY_USER_ID"));

				if(itemDetail.get("ORD_APPR_REQD_YN")!= null && ((String)itemDetail.get("ORD_APPR_REQD_YN")).equals("N")){
					pstmt_insert.setString(23,null);
				}
				else{
					pstmt_insert.setString(23,(String)itemDetail.get("ORDER_DATE_TIME"));
				}

				if(itemDetail.get("ORD_COSIGN_REQD_YN")==null) {
					pstmt_insert.setString(24,"N");
				} else {
					pstmt_insert.setString(24,(String)itemDetail.get("ORD_COSIGN_REQD_YN"));
				}
				pstmt_insert.setString(25,"");
				pstmt_insert.setString(26,"");
				pstmt_insert.setString(27,null);
				pstmt_insert.setString(28,null);
				pstmt_insert.setString(29,"N");
				pstmt_insert.setString(30,"CO");//CONT_ORDER_IND
				if(!license.equals("PHBASIC")) {
					
					perf_sys			=	"PH";
					perf_deptloc_type	=	"P";

					perf_deptloc_code	= (String)itemDetail.get("STORE_CODE");
					if(perf_deptloc_code==null || perf_deptloc_code.equals(""))
						perf_deptloc_type	= (String)itemDetail.get("LOCATION_TYPE");
				}
				if(itemDetail.get("PERFORMING_FACILITY_ID") == null || ((String)itemDetail.get("PERFORMING_FACILITY_ID")).equals(""))
					perf_facility		=	(String)itemDetail.get("FACILITY_ID");
				else
					perf_facility		=	(String)itemDetail.get("PERFORMING_FACILITY_ID");

				pstmt_insert.setString(31,perf_facility);
				pstmt_insert.setString(32,perf_sys);
				pstmt_insert.setString(33,perf_deptloc_type);
				pstmt_insert.setString(34,perf_deptloc_code);
				pstmt_insert.setString(35,"");
				pstmt_insert.setString(36,"N");
				pstmt_insert.setString(37,"N");//CHILD_ORDER_YN
				pstmt_insert.setString(38,""); //PARENT_ORDER_ID
				pstmt_insert.setString(39,"N");
				pstmt_insert.setString(40,"");
				pstmt_insert.setString(41,"");
				pstmt_insert.setString(42,"");

				pstmt_insert.setString(43,order_status);
				pstmt_insert.setString(44,"");
				pstmt_insert.setString(45,login_by_id);
				pstmt_insert.setString(46,login_at_ws_no);
				pstmt_insert.setString(47,login_facility_id);
				pstmt_insert.setString(48,login_by_id);
				pstmt_insert.setString(49,login_at_ws_no);
				pstmt_insert.setString(50,login_facility_id);

				if(itemDetail.get("CONSENT_REQD_YN")==null) {
					pstmt_insert.setString(51,"N");
				} else {
					pstmt_insert.setString(51,(String)itemDetail.get("CONSENT_REQD_YN"));
				}

				pstmt_insert.setString(52,"");
				pstmt_insert.setString(53,null);
				pstmt_insert.setString(54,"");
			/*	if(  ((String)tabData.get("external_pres_flag")).equals("true")) {

					pstmt_insert.setString(55,external_ref_facility);
					pstmt_insert.setString(56,external_date_ref);
					pstmt_insert.setString(57,external_ref_practitioner);
					pstmt_insert.setString(58,external_remarks);
					pstmt_insert.setString(59,login_by_id);
					pstmt_insert.setString(60,sys_date);
					
				} else {*/
					pstmt_insert.setString(55,"");
					pstmt_insert.setString(56,"");
					pstmt_insert.setString(57,"");
					pstmt_insert.setString(58,"");
					pstmt_insert.setString(59,"");
					pstmt_insert.setString(60,"");
				//}
				pstmt_insert.setString(61,trn_group_ref);
				//System.out.println("trn_group_ref====347= EJB==>" +trn_group_ref);
				
				// add the statement to the batch
				pstmt_insert.addBatch();
			}

			int[] result_insert= pstmt_insert.executeBatch();

			try {
				closeStatement( pstmt_insert) ;
				closeResultSet( resultSet );
				closeStatement( pstmt_or_order_type) ;

			}catch(Exception es) {
				es.printStackTrace();
			}
			
			for (int i=0;i<result_insert.length ;i++ ) {
				if(result_insert[i]<0  && result_insert[i] != -2 ){
					insert_rec_1=false;
					break;
				}
				else{
				insert_rec_1=true;
				}
			}
			  if(!order_date.equals("")) { 
				  
				  //Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 start
				   pstmt_max_durn= connection.prepareStatement("SELECT MAX_DURN_FOR_IP_PRES,MAX_DURN_FOR_OP_PRES,MAX_DURN_FOR_DM_PRES FROM PH_PARAM WHERE MODULE_ID = 'PH'") ;
					 rs_max_durn		= pstmt_max_durn.executeQuery();
					 while(rs_max_durn.next()){
					 
					 take_home_medication=(String)itemDetail.get("TAKE_HOME_MEDICATION");
					
					if(take_home_medication.equalsIgnoreCase("Y")){
						 max_durn_pres=rs_max_durn.getString("MAX_DURN_FOR_DM_PRES");
						
					}
					else{
						  if( (patient_class.equalsIgnoreCase("IP")) || (patient_class.equalsIgnoreCase("DC")) ){
								 max_durn_pres=rs_max_durn.getString("MAX_DURN_FOR_IP_PRES");
								
							 }
							 else if((patient_class.equalsIgnoreCase("OP")) ||(patient_class.equalsIgnoreCase("EM")) ||  (patient_class.equalsIgnoreCase("XT"))){
								 max_durn_pres= rs_max_durn.getString("MAX_DURN_FOR_OP_PRES");
								
							 }
							 else{
								 max_durn_pres="90";
								
							 }
					}
				
				
				 
				  
			  }
				  try {
						closeResultSet( rs_max_durn );
						closeStatement( pstmt_max_durn) ;
					}catch(Exception es) {
						es.printStackTrace();
					}
				//Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 start

				pstmt			= connection.prepareStatement("SELECT TO_CHAR(TO_DATE(?,'dd/mm/yyyy hh24:mi')+"+max_durn_pres+",'dd/mm/yyyy hh24:mi') END_DATE FROM dual") ;//Modified for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016
				pstmt.setString(1,order_date);
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						end_date=resultSet.getString("END_DATE");
				}
				try {
					closeResultSet( resultSet );
					closeStatement( pstmt) ;
				}catch(Exception es) {
					es.printStackTrace();
				}
			}
//Insert OR_ORDER_LINE
			if(insert_rec_1){
				
				pstmt_insert	= connection.prepareStatement(sql_or_order_line_insert) ;
				pstmt_insert.clearBatch();
				
				for(int j=0;j<presItemList.size();j++){
					itemDetail=(HashMap) presItemList.get(j);
					pstmt_insert.setString(1,(String)itemDetail.get("ORDER_ID"));
					pstmt_insert.setString(2,"1");						
					pstmt_insert.setString(3,(String)itemDetail.get("ITEM_CODE"));

					pstmt_insert.setString(4,(String)itemDetail.get("ITEM_DESC"));
					item_desc=(String)itemDetail.get("ITEM_DESC");
					if (item_desc!=null && !item_desc.equals("") && item_desc.length()>40){
						item_desc=item_desc.substring(0,40);
					}
					pstmt_insert.setString(5,item_desc);
					pstmt_insert.setString(6,"");
					pstmt_insert.setString(7,(String)itemDetail.get("ORDER_TYPE"));
					pstmt_insert.setString(8,(String)itemDetail.get("ORDER_CATEGORY"));

					pstmt_insert.setString(9,(String)itemDetail.get("ORDERED_DATE"));
					pstmt_insert.setString(10,(String)itemDetail.get("PRIORITY"));
					pstmt_insert.setString(11,(String)itemDetail.get("ORD_AUTH_REQD_YN"));
					pstmt_insert.setString(12,"");
					pstmt_insert.setString(13,(String)itemDetail.get("ORD_SPL_APPR_REQD_YN"));

					if(itemDetail.get("ORD_COSIGN_REQD_YN")==null) {
						pstmt_insert.setString(14,"N");
					}
					else {
						pstmt_insert.setString(14,(String)itemDetail.get("ORD_COSIGN_REQD_YN"));
					}

					pstmt_insert.setString(15,(String)itemDetail.get("ORDERED_DATE"));//START_DATE

					pstmt_insert.setString(16,(String)itemDetail.get("FORM_CODE"));//FORM_CODE
					pstmt_insert.setString(17,(String)itemDetail.get("ROUTE_CODE"));//


				pstmt_insert.setString(18,(String)itemDetail.get("QTY_VALUE"));
				pstmt_insert.setString(19,(String)itemDetail.get("UOM_CODE"));
				pstmt_insert.setString(20,(String)itemDetail.get("FREQ_CODE"));//FREQ_CODE
				pstmt_insert.setString(21,max_durn_pres);//DURN_VALUE//Modified for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016
				pstmt_insert.setString(22,"D");//DURN_TYPE

				pstmt_insert.setString(23,"");
				pstmt_insert.setString(24,"");
				pstmt_insert.setString(25,null);

				pstmt_insert.setString(26,end_date);//END_DATE_TIME //Modified for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016
				pstmt_insert.setString(27,null);

				pstmt_insert.setString(28,(String)itemDetail.get("QTY_VALUE"));
				pstmt_insert.setString(29,(String)itemDetail.get("UOM_CODE"));

				pstmt_insert.setString(30,"N");
				pstmt_insert.setString(31,null);
				pstmt_insert.setString(32,"");
				pstmt_insert.setString(33,"N");
				pstmt_insert.setString(34,(String)itemDetail.get("BILL_YN"));
				pstmt_insert.setString(35,"N");

				pstmt_insert.setString(36,"CO");
				pstmt_insert.setString(37,"N");

				pstmt_insert.setString(38,"");
				pstmt_insert.setString(39,"N");//CHILD_ORDER_YN
				pstmt_insert.setString(40,"");//PARENT_ORDER_ID

				pstmt_insert.setString(41,"");
				pstmt_insert.setString(42,"");
				pstmt_insert.setString(43,"");
				/*if( ((String)tabData.get("external_pres_flag")).equals("true")){
					pstmt_insert.setString(44,login_by_id);
				}
				else{*/
					pstmt_insert.setString(44,pract_id);
				//}

				pstmt_insert.setString(45,null);
				pstmt_insert.setString(46,"");
				pstmt_insert.setString(47,null);
				pstmt_insert.setString(48,"");
				pstmt_insert.setString(49,null);
				pstmt_insert.setString(50,"");
				pstmt_insert.setString(51,null);
				pstmt_insert.setString(52,"");
				pstmt_insert.setString(53,null);
				pstmt_insert.setString(54,"");
				pstmt_insert.setString(55,null);
				pstmt_insert.setString(56,"");
				pstmt_insert.setString(57,"");

				order_status			=	(String)itemDetail.get("ORDER_STATUS");
				line_status				=	"";
				ord_authorized_yn			=	(String)itemDetail.get("ORD_AUTHORIZED_YN")==null?"N":(String)itemDetail.get("ORD_AUTHORIZED_YN");
				ord_authorized_yn				=	(String)itemDetail.get("ORD_APPROVED_YN")==null?"N":(String)itemDetail.get("ORD_APPROVED_YN");
				consent_reqd_yn			=	(String)itemDetail.get("CONSENT_REQD_YN")==null?"N":(String)itemDetail.get("CONSENT_REQD_YN");
				auth_reqd_yn		=	(String)itemDetail.get("ORD_AUTH_REQD_YN")==null?"N":(String)itemDetail.get("ORD_AUTH_REQD_YN");
				apprvl_reqd_yn	=	(String)itemDetail.get("ORD_SPL_APPR_REQD_YN")==null?"N":(String)itemDetail.get("ORD_SPL_APPR_REQD_YN");
				cosign_reqd_yn		=	(String)itemDetail.get("ORD_COSIGN_REQD_YN")==null?"N":(String)itemDetail.get("ORD_COSIGN_REQD_YN");

				if(order_status.equals("10") || order_status.equals("25")){
						if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")){
							order_status="25";
						}
						else{
							order_status="10";
						}
				}
				if(order_status.equals("03")){
					line_status= (String)orderStatusCode.get("03");
				}
				else if(order_status.equals("05")){
					line_status=(String) orderStatusCode.get("05");
				}
				else if(order_status.equals("10")){
					line_status=(String) orderStatusCode.get("10");
				}
				else if(order_status.equals("25")){
					line_status= (String)orderStatusCode.get("25");
				}
				else if(order_status.equals("00")){
					line_status= (String)orderStatusCode.get("00");
				}

				if( itemDetail.get("BROUGHT_BY_PAT")!=null && ((String)itemDetail.get("BROUGHT_BY_PAT")).equals("Y")) {
					line_status	=	(String)orderStatusCode.get("58");
				}

				pstmt_insert.setString(58,line_status);
				pstmt_insert.setString(59,"");
				pstmt_insert.setString(60,login_by_id);
				pstmt_insert.setString(61,login_at_ws_no);
				pstmt_insert.setString(62,login_facility_id);
				pstmt_insert.setString(63,login_by_id);
				pstmt_insert.setString(64,login_at_ws_no);
				pstmt_insert.setString(65,login_facility_id);

				pstmt_insert.setString(66,"N");
				pstmt_insert.setString(67,"");
				String it_desc="";
				it_desc=(String)itemDetail.get("ITEM_DESC");
				if (it_desc!=null && !it_desc.equals("") && it_desc.length()>40){
					it_desc=it_desc.substring(0,40);
				}
				pstmt_insert.setString(68,it_desc);
				pstmt_insert.setString(69,it_desc);
				pstmt_insert.setString(70,"N");
				pstmt_insert.addBatch();
			}

			int[] result_insert_2= pstmt_insert.executeBatch();

			try {
				closeStatement( pstmt_insert) ;
				closeResultSet( resultSet );

			}catch(Exception es) {
				es.printStackTrace();
			}
			for (int i=0;i<result_insert_2.length ;i++ ){
				if(result_insert_2[i]<0  && result_insert_2[i] != -2 ){
					insert_rec_2=false;
					break;
				}
				else{
				insert_rec_2=true;
				}
			}
		}

       //Insert OR_ORDER_LINE_PH
			if(insert_rec_2){
				pstmt_insert	= connection.prepareStatement(sql_or_order_line_ph_insert) ;
				pstmt_insert.clearBatch();
				for(int j=0;j<presItemList.size();j++){
					itemDetail=(HashMap) presItemList.get(j);
					//GHL-CRF-0618  - start
					non_prefered_item_remarks_code = "";
					if(nonPreferenceRemarksMedicalItem!=null && nonPreferenceRemarksMedicalItem.size()>0)
						non_prefered_item_remarks_code = (String)nonPreferenceRemarksMedicalItem.get((String)itemDetail.get("ITEM_CODE"));
					if(non_prefered_item_remarks_code==null)
						non_prefered_item_remarks_code = "";
					//GHL-CRF-0618 end
					pstmt_insert.setString(1,(String)itemDetail.get("ORDER_ID"));
					pstmt_insert.setString(2,"1");						
					pstmt_insert.setString(3,"MEDICALITEM");	//GENERIC_ID
					pstmt_insert.setString(4,(String)itemDetail.get("FORM_CODE"));		//FORM_CODE
					//item_desc=(String)itemDetail.get("ITEM_DESC");
					pstmt_insert.setString(5,(String)itemDetail.get("TRADE_CODE"));
					pstmt_insert.setString(6,"Y");		//IN_FORMULARY_YN
					pstmt_insert.setString(7,"A");		//DOSAGE_TYPE
					pstmt_insert.setString(8,"");		//SPLIT_DRUG_PREVIEW

					pstmt_insert.setString(9,"");		//TOT_STRENGTH
					pstmt_insert.setString(10,"");		//TOT_STRENGTH_UOM
					pstmt_insert.setString(11,"");		//INFUSE_OVER
					pstmt_insert.setString(12,"");		//INFUSE_OVER_UNIT
					pstmt_insert.setString(13,"");		//INFUSE_OVER_RATE
					pstmt_insert.setString(14,"");		//INFUSION_VOL_STR_UNIT
					pstmt_insert.setString(15,"");		//INFUSION_VOL_PER_UNIT
					pstmt_insert.setString(16,"N");		//BROUGHT_BY_PATIENT_YN
					pstmt_insert.setString(17,"N");		//CUR_DRUG_YN

					pstmt_insert.setString(18,"N");			//REFILL_DRUG_YN
					if(!license.equals("PHBASIC")) {
						perf_sys			=	"PH";
						perf_deptloc_type	=	"P";

						perf_deptloc_code	= (String)itemDetail.get("STORE_CODE");
						if(perf_deptloc_code==null || perf_deptloc_code.equals(""))
							perf_deptloc_type	= (String)itemDetail.get("LOCATION_TYPE");
					}
					pstmt_insert.setString(19,perf_deptloc_type);	//DISPENSING_LOC_TYPE 
					pstmt_insert.setString(20,perf_deptloc_code);	//DISPENSING_LOC
					pstmt_insert.setString(21,"");					//DISPENSING_STORE
					pstmt_insert.setString(22,"");					//IP_FILL_PRD_AHEAD

					pstmt_insert.setString(23,"");					//NEXT_FILL_DATE
					pstmt_insert.setString(24,"");					//LAST_FILL_QTY
					pstmt_insert.setString(25,null);				//LAST_FILL_PROC_ID

					pstmt_insert.setString(26,"");					//DISPENSED_QTY
					pstmt_insert.setString(27,(String)itemDetail.get("QTY_VALUE"));			//BMS_QTY
					pstmt_insert.setString(28,"");											//BMS_STRENGTH
					pstmt_insert.setString(29,login_by_id);
					pstmt_insert.setString(30,login_at_ws_no);
					pstmt_insert.setString(31,login_facility_id);
					pstmt_insert.setString(32,login_by_id);
					pstmt_insert.setString(33,login_at_ws_no);
					pstmt_insert.setString(34,login_facility_id);

					pstmt_insert.setString(35,"N");		//SPLIT_DOSE_YN , , , , , , 

					pstmt_insert.setString(36,"");		//QTY_VALUE_SPLIT_DOSE
					pstmt_insert.setString(37,"");		//QTY_UNIT_SPLIT_DOSE

					pstmt_insert.setString(38,"");		//STRENGTH_VALUE
					pstmt_insert.setString(39,"");		//STRENGTH_UOM
					pstmt_insert.setString(40,(String)itemDetail.get("QTY_VALUE"));//PRES_QTY_VALUE

					pstmt_insert.setString(41,(String)itemDetail.get("UOM_CODE"));		//PRES_QTY_UOM
					pstmt_insert.setString(42,"");		//ALLERGY_OVERRIDE_REASON
					pstmt_insert.setString(43,"");		//DOSAGE_LIMIT_OVERRIDE_REASON
					pstmt_insert.setString(44,"");	//DUPLICATE_DRUG_OVERRIDE_REASON

					pstmt_insert.setString(45,"");		//BATCH_ALLOCATED_YN
					pstmt_insert.setString(46,"");			//AMEND_REASON_CODE
					pstmt_insert.setString(47,"");			//AMEND_REASON
					pstmt_insert.setString(48,"");			//PAT_COUNS_REQD_YN
					pstmt_insert.setString(49,"");			//PAT_COUNS_ORD_PRACT_ID
					pstmt_insert.setString(50,(String)itemDetail.get("BL_OVERRIDE_EXCL_INCL_IND"));			//BL_INCL_EXCL_OVERRIDE_VALUE
					pstmt_insert.setString(51,(String)itemDetail.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"));			//BL_INCL_EXCL_OVERRIDE_REASON
					pstmt_insert.setString(52,"N");	//BUILD_MAR_YN
					pstmt_insert.setString(53,"");	// added for Kauh-scf-060
					pstmt_insert.setString(54,"");	// RUT-CRF-0063 [IN:029601]  -PREGNANCY_OVERRIDE_REASON
					pstmt_insert.setString(55,(String)itemDetail.get("ITEM_REMARKS"));	//Added for GHL-CRF-0470
					pstmt_insert.setString(56,(String)itemDetail.get("ALLOW_ALTERNATE_YN"));	//Added for GHL-CRF-0549 [IN:068344]
					pstmt_insert.setString(57,non_prefered_item_remarks_code);

					pstmt_insert.addBatch();
				}
				int[] result_insert_3= pstmt_insert.executeBatch();
				try {
					closeStatement( pstmt_insert) ;
					closeResultSet( resultSet );
				}
				catch(Exception es) {
					es.printStackTrace();
				}
				for (int i=0;i<result_insert_3.length ;i++ ){
					if(result_insert_3[i]<0  && result_insert_3[i] != -2 ){
						insert_rec_3=false;
						break;
					}
					else{
						insert_rec_3=true;
					}
				}
			}
			//PH_PATIENT_DRUG_PROFILE
			if(insert_rec_3){
				pstmt_insert	= connection.prepareStatement(sql_ph_patient_drug_profile_insert) ;
				pstmt_insert.clearBatch();

                pstmt			= connection.prepareStatement(sql_ph_prescription_select55) ;
				pstmt.setString(1,patient_id);
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						srl_NO=resultSet.getInt("NEXT_SRL_NO");
				}
				try {
					closeResultSet( resultSet );
					closeStatement( pstmt) ;
				}catch(Exception es) {
					es.printStackTrace();
				}
				
				for(int j=0;j<presItemList.size();j++){
					itemDetail=(HashMap) presItemList.get(j);
					pstmt_insert.setString(1,(String)itemDetail.get("PATIENT_ID"));
					pstmt_insert.setString(2,""+(srl_NO++));						
					pstmt_insert.setString(3,(String)itemDetail.get("FACILITY_ID"));	//

					pstmt_insert.setString(4,(String)itemDetail.get("ENCOUNTER_ID"));		//
					pstmt_insert.setString(5,(String)itemDetail.get("PATIENT_CLASS"));
					
					if(!license.equals("PHBASIC")) {
						perf_sys			=	"PH";
						perf_deptloc_type	=	"P";

						perf_deptloc_code	= (String)itemDetail.get("STORE_CODE");
						if(perf_deptloc_code==null || perf_deptloc_code.equals(""))
							perf_deptloc_type	= (String)itemDetail.get("LOCATION_TYPE");
					}
					pstmt_insert.setString(6,perf_deptloc_type);		//
					pstmt_insert.setString(7,perf_deptloc_code);		//
					pstmt_insert.setString(8,"");		//

					pstmt_insert.setString(9,(String)itemDetail.get("ROOM_NUM"));		//
					pstmt_insert.setString(10,(String)itemDetail.get("BED_NUM"));		//
					pstmt_insert.setString(11,"");		//
					pstmt_insert.setString(12,"");		//
					pstmt_insert.setString(13,"");		//
					pstmt_insert.setString(14,(String)itemDetail.get("ORD_PRACT_ID"));		//
					pstmt_insert.setString(15,(String)itemDetail.get("ORD_PRACT_ID"));		//
					pstmt_insert.setString(16,(String)itemDetail.get("ITEM_CODE"));		//
					pstmt_insert.setString(17,"MEDICALITEM");		//GENERIC_ID


					pstmt_insert.setString(18,(String)itemDetail.get("ORDERED_DATE"));			//START_DATE
					pstmt_insert.setString(19,end_date);	//END_DATE
					pstmt_insert.setString(20,"N");	//SPLIT_YN
					pstmt_insert.setString(21,"N");					//TAPPERED_YN
					pstmt_insert.setString(22,"");					//STRENGTH

					pstmt_insert.setString(23,"");					//STRENGTH_UOM
					pstmt_insert.setString(24,"");					//DOSAGE
					pstmt_insert.setString(25,"");				//DOSAGE_UOM

					pstmt_insert.setString(26,"");					//SPLIT_DOSE_PREVIE
					pstmt_insert.setString(27,(String)itemDetail.get("FREQ_CODE"));			//FEQ_CODE
					pstmt_insert.setString(28,"90");			//DURATION
					pstmt_insert.setString(29,(String)itemDetail.get("QTY_VALUE"));
					pstmt_insert.setString(30,"");			//DIAG_TEXT
					pstmt_insert.setString(31,"");			//DRUG_REMARKS
					pstmt_insert.setString(32,"N");			//IV_PREP_YN
					pstmt_insert.setString(33,"");
					pstmt_insert.setString(34,"");

					pstmt_insert.setString(35,"");		//  

					pstmt_insert.setString(36,"");		//
					pstmt_insert.setString(37,"");		//

					pstmt_insert.setString(38,"N");		//
					pstmt_insert.setString(39,"");		//
					pstmt_insert.setString(40,"");//

					pstmt_insert.setString(41,"N");		//
					pstmt_insert.setString(42,"");		//
					pstmt_insert.setString(43,"");		//
					pstmt_insert.setString(44,"P");	//

					pstmt_insert.setString(45,(String)itemDetail.get("FACILITY_ID"));		//
					pstmt_insert.setString(46,(String)itemDetail.get("ORDER_ID"));			//
					pstmt_insert.setString(47,"1");			//
					pstmt_insert.setString(48,"");			//
					pstmt_insert.setString(49,"N");			//
					pstmt_insert.setString(50,"");			//
					pstmt_insert.setString(51,"");			//
					pstmt_insert.setString(52,"");			//
					pstmt_insert.setString(53,"");			//
					pstmt_insert.setString(54,"");			//
					pstmt_insert.setString(55,"");			//
					pstmt_insert.setString(56,"N");			//
					pstmt_insert.setString(57,"");			//
					pstmt_insert.setString(58,"");			//
					pstmt_insert.setString(59,"");			//
					pstmt_insert.setString(60,login_by_id);			//
					pstmt_insert.setString(61,login_at_ws_no);
					pstmt_insert.setString(62,login_facility_id);
					pstmt_insert.setString(63,login_by_id);
					pstmt_insert.setString(64,login_at_ws_no);
					pstmt_insert.setString(65,login_facility_id);
					pstmt_insert.setString(66,"");			//
					pstmt_insert.setString(67,"");			//
					pstmt_insert.setString(68,"");			//
					pstmt_insert.setString(69,"");			//
					pstmt_insert.setString(70,"D");			//
					pstmt_insert.setString(71,"");			//
					pstmt_insert.setString(72,"");			//
					pstmt_insert.setString(73,"");			//
					pstmt_insert.setString(74,"");			//
					pstmt_insert.setString(75,"N");			//REFILL_YN
					pstmt_insert.setString(76,"");			//
					pstmt_insert.setString(77,"");			//
					pstmt_insert.setString(78,"");			//
					pstmt_insert.setString(79,"");			//
					pstmt_insert.setString(80,"");			//
					pstmt_insert.setString(81,"");			//
					pstmt_insert.setString(82,"");			//
					pstmt_insert.setString(83,"");			//
					pstmt_insert.setString(84,"");			//
					pstmt_insert.setString(85,"");			//
					pstmt_insert.setString(86,"A");			//
					pstmt_insert.setString(87,(String)itemDetail.get("HEIGHT"));			//
					pstmt_insert.setString(88,(String)itemDetail.get("HEIGHT_UOM"));			//HEIGHT_UNIT changed HEIGHT_UOM for NMC-JD-CRF-0119 
					pstmt_insert.setString(89,(String)itemDetail.get("WEIGHT"));			//
					pstmt_insert.setString(90,(String)itemDetail.get("WEIGHT_UOM"));			//
					pstmt_insert.setString(91,(String)itemDetail.get("BSA"));			//
					pstmt_insert.setString(92,"N");			//
					pstmt_insert.setString(93,(String)itemDetail.get("BMI"));			//
					pstmt_insert.setString(94,"");			//
					pstmt_insert.setString(95,"");			//
					pstmt_insert.setString(96,"");			//
					pstmt_insert.setString(97,"");			//added for aakh-crf-0140
					pstmt_insert.setString(98,"");//added for aakh-crf-0140
					//pstmt_insert.executeUpdate();
                    srl_NO++;  
					pstmt_insert.addBatch();
				}

				int[] result_insert_4= pstmt_insert.executeBatch();
				//insert_rec_4=true;

				try {
					closeStatement( pstmt_insert) ;
					closeResultSet( resultSet );

				}
				catch(Exception es) {
					insert_rec_4 = false;
					es.printStackTrace();
				}
				for (int i=0;i<result_insert_4.length ;i++ ){
					if(result_insert_4[i]<0  && result_insert_4[i] != -2 ){
						insert_rec_4=false;
						break;
					}
					else{
						insert_rec_4=true;
					}
				}
				
			}
			//GHL-CRF-0470 starts
			if(insert_rec_4){
				String action_seq_num		= "";
				for (int i=0;i<presItemList.size() ;i++ ){
					itemDetail=(HashMap)presItemList.get(i);
					order_id		=(String) itemDetail.get("ORDER_ID");pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_select.setString(1, order_id);
				resultSet		= pstmt_select.executeQuery();
				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}
				closeResultSet( resultSet );
				closeStatement(pstmt_select); 
				String header_comments	= OrderRemarks==null?"":OrderRemarks;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_id);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result_insert_5 = pstmt_insert.executeUpdate();
				insert_rec_5=true;	//Added for ICN-64906
				if(result_insert_5>0){
					pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,action_seq_num);
					rset_clob =pstmt_clob.executeQuery();
					if(rset_clob!=null){
						while(rset_clob.next()){
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(header_comments,0,header_comments.length());
							bw.flush();
							bw.close();
						}
						insert_rec_5=true;
					}
					else{
						insert_rec_5=false;
					}
					closeResultSet( rset_clob );
					closeStatement(pstmt_clob);
				}
				closeStatement(pstmt_insert);
				}	
			}
			//GHL-CRF-0470 ends


			
			if(insert_rec_1 && insert_rec_2&& insert_rec_3 && insert_rec_4 && insert_rec_5){	// insert_rec_5 Added for GHL-CRF-0470
				String auto_order_regn_err = "";
				String tokens_generated_yn = "";
				
				if((called_from!=null && called_from.equals("TAB")) ||(called_from!=null && called_from.equals("ORDERSET"))){
					
					

					if((patient_class.equals("OP") || patient_class.equals("EM")) && !trn_group_ref.equals("")){
						
						cstmt_insert=connection.prepareCall("{call ph_auto_order_regn(?,?,?,?,?,?)}");

						cstmt_insert.setString( 1, trn_group_ref);
						cstmt_insert.setString( 2, patient_id);
						cstmt_insert.setString( 3, login_facility_id);
						cstmt_insert.setString( 4, encounter_id);
						cstmt_insert.registerOutParameter(5, Types.VARCHAR );
						cstmt_insert.registerOutParameter(6, Types.VARCHAR );
						cstmt_insert.execute() ;

						tokens_generated_yn = cstmt_insert.getString(5)==null ? "":cstmt_insert.getString(5);
						auto_order_regn_err = cstmt_insert.getString(6)==null ? "":cstmt_insert.getString(6);
//System.out.println("@@@EJB  859 ===tokens_generated_yn="+tokens_generated_yn+" auto_order_regn_err="+auto_order_regn_err);
						try{
							closeResultSet( resultSet ) ;
							closeStatement( cstmt_insert ) ;
						}catch(Exception es){
							es.printStackTrace() ;
						}
					}
					connection.commit();
				}
				map.put( "result", new Boolean( true ) ) ;
				map.put("msgid","RECORD_INSERTED" ) ;
				map.put("flag","");
				map.put("trn_group_ref",trn_group_ref);
				map.put("tokens_generated_yn",tokens_generated_yn);
			}
			else{
				try{
					connection.rollback();
					//map.put("flag",debug);
					map.put("flag","");
				}
				catch(Exception es){
					es.printStackTrace() ;
					map.put("flag","");
				}
			}

		}catch(Exception e){
			System.err.println("ERROR IN CONSUMABLEORDER EJB tabData"+tabData);
			e.printStackTrace() ;
			try{
				connection.rollback();
				//map.put("flag",debug);
				map.put("flag","");
			}catch(Exception es){
				System.err.println("ERROR IN CONSUMABLEORDER EJB"+es);
				es.printStackTrace() ;
				//map.put("flag",debug);
				map.put("flag","");
			}
		}
		finally{
			try{
				closeStatement( pstmt_insert ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_clob ) ;
				closeResultSet( rset_clob );
				closeResultSet( resultSet );
				closeConnection( connection,(Properties)tabData.get( "properties" ) );
				tabData					=	null;
			}catch(Exception es){
				System.err.println("ERROR IN CONSUMABLEORDER EJB"+es);
			}
		}
		//map.put("flag",debug);
		map.put("flag","");
		return map;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;		
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;		
	}

}
