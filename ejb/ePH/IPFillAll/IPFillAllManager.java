/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/19/2017      63877   		chithra      UnusedLocal variable
29/1/2020		IN072145		Shazana			SKR-SCF-1305
16/03/2021   IN15664         Manickavasagam J	 	   			COMMON-ICN-0029
---------------------------------------------------------------------------------------------------------------
*/
package ePH.IPFillAll ;
import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;


/**
*
* @ejb.bean
*	name="IPFillAll"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPFillAll"
*	local-jndi-name="IPFillAll"
*	impl-class-name="ePH.IPFill.IPFillAllManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.IPFillAll.IPFillAllLocal"
*	remote-class="ePH.IPFillAll.IPFillAllRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.IPFillAll.IPFillAllLocalHome"
*	remote-class="ePH.IPFillAll.IPFillAllHome"
*	generate= "local,remote"
*
*
*/

public class IPFillAllManager extends PhEJBSessionAdapter {

	Properties prop   = null;
	ArrayList dispTMP = null; 
	HashMap stock_srl = null; 
	HashMap seq_no	  = null;
	int insert_Count = 0;
	HashMap patient_cer_no  = new HashMap(); 
	HashMap order_cer_no  = new HashMap(); 
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		return new HashMap() ;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		return new HashMap() ;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;
		
		Connection connection			 = null ;
		PreparedStatement pstmt_fillparam= null;
			//pstmt_update_disp_hdr_tmp = null,pstmt_update_med_hdr = null ;
		PreparedStatement pstmt_seq		 = null;
		ResultSet resultSet				 = null ;
		int count						 = 0;
		int SequenceNo					 = 1;
		//boolean updateStock_id 			 = false;	   
        prop = (Properties)tabData.get( "properties" );
		// Stock Variables		
		
				stock_srl		=	new HashMap();
				seq_no			=	new HashMap();

		String st_doc_type		=	"";
		String today			=	"";
		String errMsg1			=	"";
		
		StringBuffer errMsg = new StringBuffer();
		try {
			connection	    =   getConnection( prop ) ;
			st_doc_type	    =	getStockDocType(connection,sqlMap,"I",(String)tabData.get("login_facility_id"));
			if(st_doc_type.equals(""))
			{
				map.put( "flag", " Not Generated" ) ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", "PH_DOC_TYPE_SETTINGS_NOT_AVAIL") ;		
				connection.rollback();
				return map;

			}
		  	pstmt_fillparam	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_FILL_PROCESS_SELECT2"));
			resultSet		=	pstmt_fillparam.executeQuery();
			if(resultSet.next()) {
				today		=	resultSet.getString("SYS_DATE");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_fillparam ) ;
			tabData.put("today",today);

			//pstmt_fillparam	=	null;
			//pstmt_fillparam	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_FILLPARAM_INSERT"));
			pstmt_fillparam	=	connection.prepareStatement("INSERT INTO PH_FILL_PROCESS_PARAM(FILL_PROC_ID, IV_DRUG_IND,COMPOUND_DRUG_IND,  IP_EXCL_INTERMITTENT_FILL,NURSING_UNIT_OR_LOCN,NURSING_UNIT_FROM,NURSING_UNIT_TO,        BUILDING_CODE,FLOOR_CODE,PROC_TYPE,SCHEDULE_START ,IP_FILL_PERIOD_AHEAD , 	 IP_FILL_PRD_UNIT,IP_FILL_EXCL_PRD_BEHIND ,ORDER_BY_FOR_LIST , FACILITY_ID  	 ,DISP_LOCN_CODE ,USER_ID,FILL_PROC_DATE_TIME,    FILL_INT_START_DATE_TIME 	  ,FILL_INT_END_DATE_TIME,CUT_OFF_LIMIT_FOR_NEW_ORD, FILL_PROC_STATUS , 	  ADDED_BY_ID ,ADDED_DATE,ADDED_AT_WS_NO ,ADDED_FACILITY_ID , 	  MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BUILDING_CODE_TO) 	  VALUES(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?, ?,?,?, sysdate,TO_DATE(?,'dd/mm/yyyy  hh24:mi'),TO_DATE(?,'dd/mm/yyyy  hh24:mi'),TO_DATE(?,'hh24:mi'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
			pstmt_seq=connection.prepareStatement((String) sqlMap.get( "SQL_PH_FILLPARAM_SEQUENCE"));
			resultSet=pstmt_seq.executeQuery();
			if(resultSet!=null &&  resultSet.next()){
				SequenceNo=resultSet.getInt("SEQNO");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_seq ) ;
			pstmt_fillparam.setInt(1,SequenceNo);
			pstmt_fillparam.setString(2,(String)tabData.get("iv_drug_ind"));
			pstmt_fillparam.setString(3,(String)tabData.get("compound_drug_ind"));
			pstmt_fillparam.setString(4,(String)tabData.get("ip_excl_intermittent_fill"));
			pstmt_fillparam.setString(5,(String)tabData.get("nursing_unit_or_locn"));
			pstmt_fillparam.setString(6,(String)tabData.get("Nursing_Unit_From"));
			pstmt_fillparam.setString(7,(String)tabData.get("Nursing_Unit_To"));
			pstmt_fillparam.setString(8,(String)tabData.get("Building_Code_from"));
			pstmt_fillparam.setString(9,(String)tabData.get("Floor_Code"));
			pstmt_fillparam.setString(10,(String)tabData.get("Proc_Type"));
			pstmt_fillparam.setString(11,(String)tabData.get("schedule_start"));
			pstmt_fillparam.setString(12,(String)tabData.get("Ip_Fill_Prd_Ahead"));
			pstmt_fillparam.setString(13,(String)tabData.get("ip_fill_prd_unit"));
			pstmt_fillparam.setString(14,(String)tabData.get("ip_fill_excl_prd_behind"));
			pstmt_fillparam.setString(15,(String)tabData.get("order_by_for_list"));
			pstmt_fillparam.setString(16,(String)tabData.get("login_facility_id"));
			pstmt_fillparam.setString(17,(String)tabData.get("disp_locn_code"));			
			pstmt_fillparam.setString(18,(String)tabData.get("user_id"));
			pstmt_fillparam.setString(19,(String)tabData.get("fill_int_start_date_time"));
			pstmt_fillparam.setString(20,(String)tabData.get("fill_int_end_date_time"));
			pstmt_fillparam.setString(21,(String)tabData.get("cut_off_limit_for_new_ord"));			
			pstmt_fillparam.setString(22,""); //Fill proc status is null
			pstmt_fillparam.setString(23,(String)tabData.get("user_id"));
			pstmt_fillparam.setString(24,(String)tabData.get("login_at_ws_no"));
			pstmt_fillparam.setString(25,(String)tabData.get("login_facility_id"));
			pstmt_fillparam.setString(26,(String)tabData.get("user_id"));
			pstmt_fillparam.setString(27,(String)tabData.get("login_at_ws_no"));
			pstmt_fillparam.setString(28,(String)tabData.get("login_facility_id"));
			pstmt_fillparam.setString(29,(String)tabData.get("Building_Code_to"));
			count =pstmt_fillparam.executeUpdate() ;
			closeStatement( pstmt_fillparam ) ;
			connection.commit();
			if (count==0) {
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", "Error During Insertion into Fill Process Param" );
				return map;
			}
			else {
				//updateStock_id = mainIPFillProcess(SequenceNo+"",sqlMap,tabData,connection,st_doc_type,stock_srl);
				errMsg = mainIPFillProcess(SequenceNo+"",sqlMap,tabData,connection,st_doc_type,stock_srl);
                errMsg1=errMsg.toString();
				errMsg1=errMsg1.replace('"','`');
				/*
				if((!updateStock_id.equals(""))&&(updateStock_id.equals("RECORD_MODIFIED"))){
						map.put( "flag", SequenceNo+"" ) ;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "msgid", "RECORD_INSERTED_FILL") ;
						dispTMP = null;	   
						connection.commit();						
					}else{
					map.put( "flag", " Not Generated" ) ;
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", updateStock_id) ;		
					connection.rollback();						
				}
				*/
				map.put( "flag", SequenceNo+"" ) ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "msgid", errMsg1.toString()) ;
				//map.put( "msgid", "") ;
			}
		}
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "RECORD_NOT_INSERTED_FILL") ;
			e.printStackTrace();
			try {
				connection.rollback();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_fillparam ) ;
				closeStatement( pstmt_seq ) ;	
				
				resultSet			=null;
				pstmt_fillparam		=null;
				pstmt_seq 			=null;
				//closeConnection( connection, (Properties)tabData.get( "properties" ) );
				closeConnection( connection, prop );
				tabData.clear();
				sqlMap.clear();	
				dispTMP.clear();
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}

	private StringBuffer mainIPFillProcess(String fill_proc_id,HashMap sqlMap,HashMap tabData,Connection connection,String st_doc_type,HashMap stock_srl) {
		boolean is_success	= false;
		boolean Stk_Update	= false;
		boolean isRollBacked = false;
		String  rollBackedOrderId = "";
		
		//boolean updateStock_id=false;  Unused local variable INC63877
		String SQL_PH_IP_FILL_PROCESS_SELECT5                  = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT5");
		String SQL_PH_IP_FILL_PROCESS_SELECT34			       = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT34");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A	       = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A");
		String SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL");
		String SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP    = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A	   = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL");
		
		String SQL_PH_IP_FILL_PROCESS_SELECT8        = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT8");
		String SQL_PH_IP_FILL_PROCESS_SELECT10       = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT10");
		String SQL_PH_IP_FILL_PROCESS_SELECT11       = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT11");
		String SQL_PH_IP_FILL_PROCESS_SELECT12		 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT12");
		String SQL_PH_IP_FILL_PROCESS_SELECT13		 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT13");
		String SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP");
		String SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH");
		String SQL_PH_IP_FILL_PROCESS_SELECT33		 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT33");
		String SQL_PH_IP_FILL_PROCESS_SELECT38		 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT38");
		String SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE");

		String stmt1="SELECT FRACT_DOSE_ROUND_UP_YN,CONTENT_IN_PRES_BASE_UOM,STRENGTH_PER_VALUE_PRES_UOM,STRENGTH_PER_PRES_UOM   FROM PH_DRUG WHERE DRUG_CODE =?";
	   	String stmt2="SELECT SUM(ORDER_LINE_DOSE_QTY_VALUE) TOT FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID = ?AND ORDER_LINE_NUM = ?";

		//String SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE");
		String SQL_PH_DISP_MEDICATION_HRD_UPDATE = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE");

		PreparedStatement  pstmt_update = null,pstmt_update1 = null,pstmt_insert_fill_int_dtl = null,pstmt_insert1 = null,pstmt_select38 = null,pstmt_select33 = null,pstmt_select10 = null,pstmt_select11 = null,pstmt_select12 = null,pstmt_insert_hdr_tmp = null,pstmt_select13 = null,pstmt_update_dtl_tmp = null,pstmt_insert_dtl_tmp = null,pstmt_select8 = null,pstmt_stmt1 = null,pstmt_stmt2 = null,pstmt_ip_nod = null,pstmt_update_line_ph = null,pstmt_update_disp_hdr_tmp	=	null,pstmt_update_med_hdr = null,pstmt=null, pstmt_update_drug_profile=null;

		CallableStatement cstmt		= null ;
		ArrayList pstmt_stmnts		= new ArrayList();
        String Ipseqnum			    = "";
		String order_id				= "";
		String order_line_no		= "";
		String ordering_facility_id	= "";
		String order_catalog_code	= "";
		String order_qty			= "";
		String order_uom			= "";
		String ord_date_time		= "";
		String patient_id			= "";
		String encounter_id			= "";
		String source_code			= "";
		String ord_pract_id			= "";
		String disp_locn_code			= (String)tabData.get("disp_locn_code");
		String fill_int_start_date_time = (String)tabData.get("fill_int_start_date_time");
		String fill_int_end_date_time	= (String)tabData.get("fill_int_end_date_time");
		ArrayList selectedRecords		= (ArrayList)tabData.get("selectedRecords");
		ArrayList Patientinsertlist		= (ArrayList)tabData.get("Patientinsertlist");
		//ArrayList SeqInserthdrlist		= (ArrayList)tabData.get("SeqInserthdrlist");
		String end_date_Time			= "";
		String order_line_status		= "";

		String disp_qty		  = "";
		String disp_qty_uom	  = "";
		String disp_btch	  = "";
		String disp_drug_code = "";
		String disp_drug_desc = "";
		String drug_choice	  = "";
		String exp_date		  = "";
		String btch_id		  = "";
		String trade_name	  = "";
		String dflt_bin		  = "";
		String btch_qty		  = "";

		String store_code	  = disp_locn_code;
		tabData.put("store_code",store_code);

		String patient_class			= "";
		String source_type				= "";
		String room_num					= "";
		String bed_num					= "";
		String bed_class_code			= "";
		String bed_type_code			= "";
		String specialty_code			= "";
		String attend_practitioner_id	= "";
		String available_stock          = "";
		String performing_facility_id   = "";
		String Prev_order_id			="";
		ArrayList ip_fill_list			= (ArrayList)tabData.get("ipFillList");
		HashMap dispuoms                = (HashMap)tabData.get("DISPUOMS");
		Ipseqnum             	        = (String)tabData.get("Ipseqnum");		
		HashMap reqData					= new HashMap();
		HashMap ip_fill_order			= new HashMap();
		ArrayList all_sources			= new ArrayList();
		dispTMP = new ArrayList(); // This ArrayList will be used for Stock Updation...
		ArrayList batch_record  = null;
		float f_available_stock=0.0f;
		float f_disp_qty	   =0.0f;
		StringTokenizer disp_qty_dtl  = new StringTokenizer("S");
		StringTokenizer btch_dtls = new StringTokenizer("*");
		StringTokenizer ind_b_dtl = new StringTokenizer("^");
		int corderline   = 0;
		int doc			 = 1;
		int index		 = 1;
		//int insert_Count = 0;
		StringBuffer errMsg = new StringBuffer();
		try{
			pstmt_update				= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A);
			pstmt_update1				= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A);
			pstmt_insert_fill_int_dtl	= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL);
			pstmt_insert1				= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP) ;
			pstmt_select38				= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT38);
			pstmt_select33				= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT33);
			pstmt_select10				= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT10) ;
			pstmt_select11				= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT11) ;
			pstmt_select12				= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT12) ;
			pstmt_insert_hdr_tmp		= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP) ;
			pstmt_select13				= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT13);
			pstmt_update_dtl_tmp		= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP);
			pstmt_insert_dtl_tmp		= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP);
			pstmt_select8				= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT8);
			pstmt_stmt1					= connection.prepareStatement(stmt1);				
			pstmt_stmt2					= connection.prepareStatement(stmt2);				
			pstmt_ip_nod				= connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS);
			pstmt_update_line_ph	    = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH);
			pstmt_update_drug_profile	    = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE);
			cstmt						= connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			pstmt_stmnts.add(pstmt_select38);//0
			pstmt_stmnts.add(pstmt_select33);
			pstmt_stmnts.add(pstmt_select10);
			pstmt_stmnts.add(pstmt_select11);
			pstmt_stmnts.add(pstmt_select12);
			pstmt_stmnts.add(pstmt_insert_hdr_tmp); //5
			pstmt_stmnts.add(pstmt_select13);
			pstmt_stmnts.add(pstmt_update_dtl_tmp);
			pstmt_stmnts.add(pstmt_insert_dtl_tmp);
			pstmt_stmnts.add(pstmt_select8);
			pstmt_stmnts.add(pstmt_stmt1); //10
			pstmt_stmnts.add(pstmt_stmt2);
			pstmt_stmnts.add(pstmt_ip_nod);
			pstmt_stmnts.add(pstmt_update_line_ph);
			pstmt_stmnts.add(pstmt_update_drug_profile); //14

			//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE ) ;
			pstmt_update_disp_hdr_tmp		= connection.prepareStatement( "UPDATE PH_DISP_HDR_TMP SET DOC_TYPE=?, DOC_NO=?,CERT_REIMB_NO=? WHERE ORDER_ID = ? AND FACILITY_ID= ?" ) ;
			pstmt_update_med_hdr			= connection.prepareStatement( SQL_PH_DISP_MEDICATION_HRD_UPDATE ) ;

			if(ip_fill_list != null && ip_fill_list.size()>0){
				dispTMP = new ArrayList();
				isRollBacked = false;
				rollBackedOrderId = "";
				HashMap temp =new HashMap();
				String dsn_no="0";
				tabData.put("CUSTOMER_ID",this.getCustomerID(connection));
				for(int i = 0; i<selectedRecords.size();i++){//modified ip_fill_list for SKR-SCF-1305
					disp_qty		  = "";
					disp_qty_uom	  = "";
					disp_btch	      = "";
					disp_drug_code    = "";
					disp_drug_desc    = "";
					drug_choice	      = "";
					exp_date		  = "";
					btch_id		      = "";
					trade_name	      = "";
					dflt_bin		  = "";
					btch_qty		  = "";
					is_success	= false;

					//dispTMP = new ArrayList();
				  // for(int l = 0; l<selectedRecords.size();l++){
					if(selectedRecords.get(i).equals("Y")){	 
						ip_fill_order = (HashMap)ip_fill_list.get(i);
						order_id				= (String)ip_fill_order.get("ORDER_ID");
						patient_id				= (String)ip_fill_order.get("PATIENT_ID"); 
						performing_facility_id	= (String)ip_fill_order.get("PERFORMING_FACILITY_ID");
						ord_pract_id			= (String)ip_fill_order.get("ORD_PRACT_ID"); // moved from down part for SRR20056-SCF-7373
						if(Ipseqnum.equals("Y")){
							if(temp!=null && temp.size()>0)  {
								if(temp.containsKey(patient_id))  {
									dsn_no = (String)temp.get(patient_id);
								 }
								 else{
									dsn_no =  getSeqNumber(connection,performing_facility_id,disp_locn_code);
									temp.put(patient_id,dsn_no)	 ; 
								} 					 
							}	
							else{
								dsn_no =  getSeqNumber(connection, performing_facility_id,disp_locn_code);
								temp.put(patient_id,dsn_no) ;
							} 
						}
						else if(Ipseqnum.equals("N")){
							dsn_no="";
						}
						if(!order_id.equals(Prev_order_id)){
						   if(Stk_Update){
							   // if earlier transaction completed successfully, updating the stock
								try { 
								   //updateStock_id=callStockUpdate(connection,tabData,sqlMap,dispTMP,new HashMap(),st_doc_type,stock_srl,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id, ord_pract_id); // ,  ord_pract_id added for SRR20056-SCF-7373
								   callStockUpdate(connection,tabData,sqlMap,dispTMP,new HashMap(),st_doc_type,stock_srl,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id, ord_pract_id); // ,  ord_pract_id added for SRR20056-SCF-7373
									/*if(!updateStock_id){
										throw new Exception("callStockUpdate failed");
									}*/
									connection.commit(); 
								}
								catch (Exception exp2) {
									connection.rollback();
									Stk_Update = false;
									dispTMP.clear();
									exp2.printStackTrace();
									throw new EJBException(exp2.getMessage()); //Added for SRR20056-SCF-7659.1 
								}	
							   Stk_Update = false;
							   dispTMP.clear();
							}
							Prev_order_id=order_id;
						}

						if(isRollBacked){
							if( order_id.equals(rollBackedOrderId)) {
								// If any transaction rollbacked, skip the other order_line_no's of the rollbacked OrderID
								continue;
							}
							else {
								isRollBacked = false;
								rollBackedOrderId = "";
							}
						}

						order_line_no			= (String)ip_fill_order.get("ORDER_LINE_NUM");
						ordering_facility_id	= (String)ip_fill_order.get("ORDERING_FACILITY_ID"); 
						order_catalog_code		= (String)ip_fill_order.get("Drug_Code"); 
						order_qty				= (String)ip_fill_order.get("ORDER_QTY"); 
						order_uom				= (String)ip_fill_order.get("ORDER_UOM"); 
						ord_date_time			= (String)ip_fill_order.get("ORD_DATE_TIME"); 
						
						encounter_id			= (String)ip_fill_order.get("ENCOUNTER_ID"); 
						source_code				= (String)ip_fill_order.get("SOURCE_CODE");
						end_date_Time			= (String)ip_fill_order.get("end_date_Time"); 
						patient_class		    = (String)ip_fill_order.get("PATIENT_CLASS");
						source_type				= (String)ip_fill_order.get("SOURCE_TYPE"); 

						room_num				= (String)ip_fill_order.get("ROOM_NUM");  
						bed_num					= (String)ip_fill_order.get("BED_NUM");   
						bed_class_code			= (String)ip_fill_order.get("BED_CLASS_CODE");  
						bed_type_code			= (String)ip_fill_order.get("BED_TYPE_CODE"); 
						specialty_code			= (String)ip_fill_order.get("SPECIALTY_CODE"); 
						attend_practitioner_id	= (String)ip_fill_order.get("ATTEND_PRACTITIONER_ID");   
						performing_facility_id	= (String)ip_fill_order.get("PERFORMING_FACILITY_ID");   

						disp_qty_dtl = new StringTokenizer((String)ip_fill_order.get("Disp_qty"),"|");
						int Tokencount=disp_qty_dtl.countTokens();
						
						if(Tokencount==5){
							while(disp_qty_dtl.hasMoreTokens()){
								disp_qty		= disp_qty_dtl.nextToken();
								disp_qty_uom	= disp_qty_dtl.nextToken();
								drug_choice		= disp_qty_dtl.nextToken();
								disp_drug_code  = disp_qty_dtl.nextToken();
								disp_drug_desc  = disp_qty_dtl.nextToken();
								//disp_btch		= disp_qty_dtl.nextToken();
							}  
						}

						if(Tokencount==6){
							while(disp_qty_dtl.hasMoreTokens()){
								disp_qty		= disp_qty_dtl.nextToken();
								disp_qty_uom	= disp_qty_dtl.nextToken();
								drug_choice		= disp_qty_dtl.nextToken();
								disp_drug_code  = disp_qty_dtl.nextToken();
								disp_drug_desc  = disp_qty_dtl.nextToken();
								disp_btch		= disp_qty_dtl.nextToken();
							} 
						}
						
						if(Tokencount==6){			
							btch_dtls = new StringTokenizer(disp_btch,"*");
							while(btch_dtls.hasMoreTokens()){
								ind_b_dtl = new StringTokenizer(btch_dtls.nextToken(),"^");
								while(ind_b_dtl.hasMoreTokens()){
									exp_date	= ind_b_dtl.nextToken();
									btch_id		= ind_b_dtl.nextToken();
									trade_name  = ind_b_dtl.nextToken();
									dflt_bin	= ind_b_dtl.nextToken();
									btch_qty	= ind_b_dtl.nextToken();
								}
							}
						}

						if(compareDateWithTime(end_date_Time,fill_int_end_date_time,SQL_PH_IP_FILL_PROCESS_SELECT34,connection)>0){
							end_date_Time = fill_int_end_date_time;
						}
						if(dispuoms.containsKey(order_id+order_line_no+disp_drug_code)){
							 disp_qty_uom  =(String)dispuoms.get(order_id+order_line_no+disp_drug_code);
						}

						reqData.put("disp_tmp_no"	 ,	""				);
						reqData.put("order_id"		 ,	order_id		);
						reqData.put("order_line_no"	 ,	order_line_no	);
						reqData.put("ord_facility_id",	ordering_facility_id	);
						reqData.put("order_catalog_code" ,	order_catalog_code		);
						reqData.put("disp_drug_code" ,	disp_drug_code		);
						reqData.put("req_qty_value"	 ,	disp_qty		);
						reqData.put("req_qty_unit"	 ,	disp_qty_uom	);
						reqData.put("ord_date_time"	 ,	ord_date_time	);
						reqData.put("patient_id"	 ,	patient_id		);
						reqData.put("encounter_id"	 ,	encounter_id	);
						reqData.put("source_code"	 ,	source_code		);
						reqData.put("ord_pract_id"	 ,	ord_pract_id	);
						reqData.put("fill_proc_id"	 ,	fill_proc_id	);
						reqData.put("disp_locn_code" ,	disp_locn_code	);
						reqData.put("patient_class"	 ,	patient_class	);
						reqData.put("source_type"	 ,	source_type		);

						reqData.put("room_num"		 ,	room_num		);
						reqData.put("bed_num"		 ,	bed_num			);
						reqData.put("bed_class_code" ,	bed_class_code	);
						reqData.put("bed_type_code"  ,	bed_type_code	);
						reqData.put("specialty_code" ,	specialty_code	);
						reqData.put("attend_practitioner_id" ,	attend_practitioner_id		);

						try{
							is_success=insertTMPTables(reqData,sqlMap,tabData,connection,disp_locn_code,end_date_Time,pstmt_stmnts,Patientinsertlist,insert_Count,dsn_no);
							if(!is_success){
								errMsg.append("\nUnsuccessfull process on \n Order ID: "+order_id);
								errMsg.append(" Patient ID: "+patient_id);
								errMsg.append(" Ord Drug code: "+order_catalog_code);
								errMsg.append(" Disp Drug code: "+disp_drug_code);
								errMsg.append(" Disp Drug Desc: "+disp_drug_desc+"\n");
								errMsg.append(" Error Msg: insertTMPTables failed");
								connection.rollback();
								Stk_Update = false;
								dispTMP.clear();
								isRollBacked = true;
								rollBackedOrderId = order_id;
								continue;
							}
						}
						catch (Exception exp){
							exp.printStackTrace();
							errMsg.append("\nUnsuccessfull process on \n Order ID: "+order_id);
							errMsg.append(" Patient ID: "+patient_id);
							errMsg.append(" Ord Drug code : "+order_catalog_code);
							errMsg.append(" Disp Drug code :"+disp_drug_code);
							errMsg.append(" Disp Drug Desc: "+disp_drug_desc+"\n");
							errMsg.append(" Error Msg: "+exp.getMessage());
							connection.rollback();
							Stk_Update = false;
							dispTMP.clear();
							isRollBacked = true;
							rollBackedOrderId = order_id;
							continue;
						}
						
						if(is_success){
							try{
								insert_Count=insert_Count+2;
								order_line_status = getOrderStatus((String)ip_fill_order.get("order_line_status"),SQL_PH_IP_FILL_PROCESS_SELECT5,connection);

								if(order_line_status.equals("10")|| order_line_status.equals("30")|| order_line_status.equals("56")|| order_line_status.equals("62")){ //order_line_status.equals("62") added for MMS-SCF-109
									//pstmt_update	   = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A);
									pstmt_update.setString(1,(String)tabData.get("user_id"));
									pstmt_update.setString(2,(String)tabData.get("login_facility_id"));
									pstmt_update.setString(3,(String)tabData.get("login_at_ws_no"));
									pstmt_update.setString(4,order_id);
									pstmt_update.setString(5,order_line_no); 
									//int pstmt_update_rows= pstmt_update.executeUpdate(); unused local variable 63877
									pstmt_update.executeUpdate();//altered above stament for unused local variable 63877
									//closeStatement( pstmt_update ) ;
									//pstmt_update=null;
									++corderline;
							   }
								pstmt_update1.setString(1,(String)tabData.get("user_id"));
								pstmt_update1.setString(2,(String)tabData.get("login_facility_id"));
								pstmt_update1.setString(3,(String)tabData.get("login_at_ws_no"));
								pstmt_update1.setString(4,order_id);
								//int pstmt_update1_rows=pstmt_update1.executeUpdate();unused local variable 63877
								pstmt_update1.executeUpdate();//altered above stament for unused local variable 63877
								//checking stock is available or not
								if(Tokencount==6){
									pstmt  = null ;
									ResultSet resultSet      = null ;
									//pstmt = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT33);
									pstmt = (PreparedStatement)pstmt_stmnts.get(1);
									pstmt.setString( 1, disp_drug_code);
									pstmt.setString( 2, store_code);
									pstmt.setString( 3, disp_qty);
									pstmt.setString( 4, "Y");
									pstmt.setString( 5, fill_int_end_date_time);
									pstmt.setString( 6, "N");
									pstmt.setString( 7, "");
									resultSet = pstmt.executeQuery() ;
									available_stock = "";
									if(resultSet!=null && resultSet.next()){
										available_stock = resultSet.getString("AVAIL_STOCK");
									}
									closeResultSet( resultSet ) ;
									resultSet=null;
									if(available_stock!=null && !available_stock.equals("")){
										f_available_stock = Float.parseFloat(available_stock);
										f_disp_qty		= Float.parseFloat(disp_qty);
									
										if( (f_available_stock >= f_disp_qty) && Float.parseFloat(disp_qty) > 0){
											dispTMP.add(order_id);				// ORDER_ID
											dispTMP.add(order_line_no);			// ORDER_LINE_NO
											dispTMP.add(order_catalog_code);	// PRES_DRUG_CODE
											dispTMP.add(disp_drug_code);		// DISP_DRUG_CODE
											dispTMP.add(disp_qty);				// DISP_QTY
											dispTMP.add(disp_qty_uom);			// DISP_UOM_CODE
											batch_record  = new ArrayList();

											batch_record.add(disp_drug_code);	//ITEM_DRUG_CODE
											batch_record.add(btch_id);			//BATCH_ID
											batch_record.add(exp_date);	        //EXPIRY_DATE
											batch_record.add(btch_qty);			//ISSUE_QTY
											batch_record.add(disp_qty_uom);		//QTY_UOM
											batch_record.add("");				//ITEM_DRUG_COLOR
											batch_record.add(trade_name);		//TRADE_ID
											batch_record.add(dflt_bin);         //BIN_LOCN_CODE
											batch_record.add(getItemCost(disp_drug_code,store_code,btch_qty,end_date_Time,connection,cstmt));	//ITEM_COST
																				
											index = 1;
											//pstmt_insert1 = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP);
											pstmt_insert1.setString(index  , (String)tabData.get("login_facility_id") );// FACILITY_ID
											pstmt_insert1.setString(++index,disp_locn_code);	// DISP_LOCN_CODE
											pstmt_insert1.setString(++index,order_id);			// ORDER_ID
											pstmt_insert1.setString(++index,order_line_no);		// ORDER_LINE_NUM
											pstmt_insert1.setString(++index,disp_drug_code);	// ITEM_CODE
											pstmt_insert1.setString(++index,btch_id);			// BATCH_ID
											pstmt_insert1.setString(++index,exp_date);		    // EXPIRY_DATE
											pstmt_insert1.setString(++index,store_code);		// STORE_CODE
											pstmt_insert1.setString(++index,disp_qty);			// DISP_QTY
											pstmt_insert1.setString(++index,disp_qty_uom);		 // DISP_QTY_UOM
											pstmt_insert1.setString(++index,disp_drug_code);							// DRUG_CODE
											pstmt_insert1.setString(++index,(String)tabData.get("user_id"));			// ADDED_BY_ID
											pstmt_insert1.setString(++index,(String)tabData.get("login_at_ws_no"));		// ADDED_AT_WS_NO
											pstmt_insert1.setString(++index,(String)tabData.get("login_facility_id"));	// ADDED_FACILITY_ID
											pstmt_insert1.setString(++index,(String)tabData.get("user_id"));			// MODIFIED_BY_ID
											pstmt_insert1.setString(++index,(String)tabData.get("login_at_ws_no"));		// MODIFIED_AT_WS_NO
											pstmt_insert1.setString(++index,(String)tabData.get("login_facility_id"));	// MODIFIED_FACILITY_ID
											pstmt_insert1.setString(++index,doc+"");	         // DOC_SRL_NO
											pstmt_insert1.setString(++index,dflt_bin);           // BIN_LOCATION_CODE
											pstmt_insert1.setString(++index,trade_name);         // TRADE_ID
					
											//int pstmt_insert1_value=pstmt_insert1.executeUpdate();unused local variable 63877
											pstmt_insert1.executeUpdate();//altered above stament for unused local variable 63877
											doc++;		
											dispTMP.add(batch_record);
											dispTMP.add(patient_id);
											dispTMP.add(encounter_id);
											Stk_Update  = true;
										} //end f_disp_qty
									} //  end available_stock 
								}//before stock check	
							}
							catch (Exception exp1){
								exp1.printStackTrace();
								errMsg.append("\nUnsuccessfull process on \n Order ID: "+order_id);
								errMsg.append(" Patient ID: "+patient_id);
								errMsg.append(" Ord Drug code: "+order_catalog_code);
								errMsg.append(" Disp Drug code: "+disp_drug_code);
								errMsg.append(" Disp Drug Desc: "+disp_drug_desc+"\n");
								errMsg.append(" Error Msg: "+exp1.getMessage());
								connection.rollback();
								Stk_Update = false;
								dispTMP.clear();
								isRollBacked = true;
								rollBackedOrderId = order_id;
								continue;
							}
						}
						if(!all_sources.contains(source_code)) {
							all_sources.add(source_code);
					   }
				   }//end if
				} //end loop
				if(Stk_Update){
					//Updating the stock of the last completed Order
					try{
						//updateStock_id=callStockUpdate(connection,tabData,sqlMap,dispTMP,new HashMap(),st_doc_type,stock_srl,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id, ord_pract_id); // ,  ord_pract_id added for SRR20056-SCF-7373
						callStockUpdate(connection,tabData,sqlMap,dispTMP,new HashMap(),st_doc_type,stock_srl,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id, ord_pract_id); // ,  ord_pract_id added for SRR20056-SCF-7373
						/*if(!updateStock_id)
							throw new Exception("callStockUpdate failed");
						*/
						Stk_Update  = false;
						dispTMP.clear();
						try{
							if(!all_sources.contains(source_code)) {
								all_sources.add(source_code);
							}
							connection.commit();	
						}
						catch (Exception exp2){
							exp2.printStackTrace();
							throw new EJBException(exp2.getMessage()); //added for SRR20056-SCF-7659.1 
						}
					}
					catch(Exception e1 ) {
						e1.printStackTrace();
						errMsg.append("\nUnsuccessfull process on \n Order ID: "+order_id);
						errMsg.append(" Patient ID: "+patient_id);
						errMsg.append(" Ord Drug code: "+order_catalog_code);
						errMsg.append(" Disp Drug code: "+disp_drug_code);
						errMsg.append(" Disp Drug Desc: "+disp_drug_desc+"\n");
						errMsg.append(" Error Msg: "+e1.getMessage());
						//errMsg.append("Error Msg: "+e1.getMessage());
						connection.rollback();
					}
				}//END IF
			}
			for(int k=0; k<all_sources.size(); k++) {
				index = 1;
				//pstmt_insert_fill_int_dtl.setString(index,(String)tabData.get("login_facility_id"));			// FACILITY_ID
				pstmt_insert_fill_int_dtl.setString(index,ordering_facility_id);			                    // ORDERING_FACILITY_ID
				pstmt_insert_fill_int_dtl.setString(++index,(String)all_sources.get(k));						// NURSING_UNIT_CODE
				pstmt_insert_fill_int_dtl.setString(++index,fill_proc_id);									    // LAST_FILL_PROC_ID
				pstmt_insert_fill_int_dtl.setString(++index,fill_int_start_date_time);							// FILL_INT_START_DATE_TIME
				pstmt_insert_fill_int_dtl.setString(++index,(String)tabData.get("user_id"));					// ADDED_BY_ID
				pstmt_insert_fill_int_dtl.setString(++index,(String)tabData.get("login_at_ws_no"));				// ADDED_AT_WS_NO
				pstmt_insert_fill_int_dtl.setString(++index,(String)tabData.get("login_facility_id"));			// ADDED_FACILITY_ID
				pstmt_insert_fill_int_dtl.setString(++index,(String)tabData.get("user_id"));					// MODIFIED_BY_ID
				pstmt_insert_fill_int_dtl.setString(++index,(String)tabData.get("login_at_ws_no"));				// MODIFIED_AT_WS_NO
				pstmt_insert_fill_int_dtl.setString(++index,(String)tabData.get("login_facility_id"));			// MODIFIED_FACILITY_ID

				// int pstmt_insert_fill_value=pstmt_insert_fill_int_dtl.executeUpdate(); //Commented for Check Style Report.
				pstmt_insert_fill_int_dtl.executeUpdate(); // altered above statment for Check Style
			}
			closeStatement( pstmt_insert_fill_int_dtl );
			pstmt_update = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL);
			pstmt_update.setString(1,fill_int_start_date_time);
			pstmt_update.setString(2,(String)tabData.get("user_id"));
			pstmt_update.setString(3,(String)tabData.get("login_facility_id"));
			pstmt_update.setString(4,(String)tabData.get("login_at_ws_no"));
			pstmt_update.setString(5,fill_proc_id);
			// int pstmt_update_value=pstmt_update.executeUpdate(); //Commented for Check Style Report.
			pstmt_update.executeUpdate(); // altered above statement for Check Style
			is_success = true;
			closeStatement( pstmt_update ) ;
			pstmt_update=null;
			try{
				connection.commit();
			}
			catch (Exception exp3){
				exp3.printStackTrace();
				throw new EJBException(exp3.getMessage()); //added for SRR20056-SCF-7659.1
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			try{
				connection.rollback();
			}
			catch(Exception es) {
				es.printStackTrace();
			}
			is_success = false;
			//throw new EJBException("Operation Failed.........in mainIPFillProcess method...");
			//added for SRR20056-SCF-7659.1  -Start
			if (e.getMessage().toString().contains("Record Already In Use")){
				throw new EJBException("APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...");
            }
			else
				throw new EJBException("Operation Failed in mainIPFillProcess method....\n"+e);
			//added for SRR20056-SCF-7659.1  - start
		}
		finally {
			try {
				/*closeResultSet( resultSet ) ;*/
				closeStatement( pstmt_select38 ) ;
				closeStatement( pstmt_select33 ) ;
				closeStatement( pstmt_select10) ;
				closeStatement( pstmt_select11 ) ;
				closeStatement( pstmt_select12 ) ;
				closeStatement( pstmt_insert_hdr_tmp ) ;
				closeStatement( pstmt_select13 ) ;
				closeStatement( pstmt_update_dtl_tmp);
				closeStatement( pstmt_insert_dtl_tmp) ;
				closeStatement( pstmt_select8 ) ;
				closeStatement( pstmt_stmt1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_stmt2 ) ;
				closeStatement( pstmt_ip_nod ) ;
				closeStatement( pstmt_update_line_ph);
				closeStatement( pstmt_update );
				closeStatement( pstmt_update1 );
				closeStatement( pstmt_insert_fill_int_dtl );
				closeStatement( pstmt_insert1 ) ;
				closeStatement( cstmt ) ;
				closeStatement(pstmt_update_disp_hdr_tmp);
				closeStatement(pstmt_update_med_hdr);
				closeStatement(pstmt_update_drug_profile);

				pstmt_update		=null;
				pstmt_update1		=null;
				pstmt_insert_fill_int_dtl =null;
				pstmt_insert1		=null;
				insert_Count		=0;
			}
			catch(Exception es) {
				es.printStackTrace(); 
			}
		}
		/*if(!is_success) {
				updateStock_id="RECORD_NOT_INSERTED_FILL" ;
				return updateStock_id;
		}*/
		return errMsg;
	}
	
	// Insert into PH_DISP_HDR_TMP, PH_DISP_DTL_TMP tables and update OR_ORDER_LINE_PH
	private boolean insertTMPTables(HashMap reqData,HashMap sqlMap,HashMap tabData,Connection connection,String store_code,String end_date_time,ArrayList pstmt_stmnts,ArrayList Patientinsertlist,int insert_Count,String dsn_no)throws Exception{
		String disp_tmp_no     = (String)reqData.get("disp_tmp_no");
		String order_id		   = (String)reqData.get("order_id");
		String order_line_no   = (String)reqData.get("order_line_no");
		String ord_facility_id = (String)reqData.get("ord_facility_id");
		String order_catalog_code = (String)reqData.get("order_catalog_code");
		String disp_drug_code  = (String)reqData.get("disp_drug_code");
		String req_qty_value   = (String)reqData.get("req_qty_value");
		String req_qty_unit    = (String)reqData.get("req_qty_unit");
		String patient_id	   = (String)reqData.get("patient_id");
		String encounter_id    = (String)reqData.get("encounter_id");
		String source_code	   = (String)reqData.get("source_code");
		String ord_pract_id    = (String)reqData.get("ord_pract_id");
		String fill_proc_id    = (String)reqData.get("fill_proc_id");
		String disp_locn_code  = (String)reqData.get("disp_locn_code");
		String ord_date_time   = (String)reqData.get("ord_date_time");
		String patient_class   = (String)reqData.get("patient_class");
		String source_type     = (String)reqData.get("source_type");
		boolean is_success	= false;
		String room_num					= (String)reqData.get("room_num");
		String bed_num					= (String)reqData.get("bed_num");
		String bed_class_code			= (String)reqData.get("bed_class_code");
		String bed_type_code			= (String)reqData.get("bed_type_code");
		String specialty_code			= (String)reqData.get("specialty_code");
		String attend_practitioner_id   = (String)reqData.get("attend_practitioner_id");
		String alt_drug_remarks="",key;
		HashMap hmAltDrugRemarks	=  (HashMap)tabData.get("ALTDRUGREMARKS");
		key = order_id+"~"+order_line_no;
		if(hmAltDrugRemarks !=null && hmAltDrugRemarks.containsKey(key))
			alt_drug_remarks = (String)hmAltDrugRemarks.get(key);

		String SQL_PH_IP_FILL_PROCESS_SELECT38		 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT38");
		
		PreparedStatement pstmt				   = null ;
		PreparedStatement pstmt_insert_hdr_tmp = null ;
		PreparedStatement pstmt_insert_dtl_tmp = null ;
		PreparedStatement pstmt_update		   = null ;
		ResultSet resultSet				       = null ;
		int count						       = 0;
		int int_disp_tmp_no				       = 0;
	//	int dailySeqNum1                       = 0;Unused local variable INC63877
	//	String  dlySeqNum                      = "";Unused local variable INC63877
	//	String  Seq_num_str1                   = "";Unused local variable INC63877
		String  cer_res_yn                     = "N";

		try {
			/*	Find out whether there is enough stock to satisfy the disp qty
				Calling Stock procedure
			*/
            int rec_count=0;

			pstmt = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT38);
			//pstmt = connection.prepareStatement("select count(*) cnt from st_item_store where STORE_CODE=? and ITEM_CODE=? ");
			//pstmt = (PreparedStatement)pstmt_stmnts.get(0); 
			pstmt.setString( 1,store_code ); 
			if ( disp_drug_code == null || disp_drug_code.equals("") || disp_drug_code.equals("null") || disp_drug_code.equals(" ")){
				pstmt.setString( 2,order_catalog_code );
			}
			else if ( disp_drug_code != null || !disp_drug_code.equals(" ") ){
				pstmt.setString( 2,disp_drug_code );
			}

			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null && resultSet.next()){
				rec_count = resultSet.getInt("cnt");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;  //common-icn-0029
			pstmt=null;
			if(rec_count>0)  {
			//	pstmt = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT10) ;
				pstmt = (PreparedStatement)pstmt_stmnts.get(2);
				pstmt.setString(1,order_id);
				resultSet = pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					count = resultSet.getInt("COUNT");
				}
				if(count>0){
					int_disp_tmp_no =  resultSet.getInt("DISP_TMP_NO");
				    closeResultSet( resultSet ) ;
					//closeStatement( pstmt ) ;
					pstmt=null;
				}
				else if(count==0){
					closeResultSet( resultSet ) ;
					//closeStatement( pstmt ) ;
					pstmt=null;
			//		pstmt     = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT11) ;
					pstmt     = (PreparedStatement)pstmt_stmnts.get(3);
					resultSet = pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()){
						int_disp_tmp_no = resultSet.getInt("TMP_DISP_NO");
					}

					closeResultSet( resultSet ) ;
				//closeStatement( pstmt ) ;
				pstmt=null;
					
					pstmt_insert_hdr_tmp = connection.prepareStatement("INSERT INTO PH_DISP_HDR_TMP (DISP_TMP_NO, FACILITY_ID, DISP_LOCN_CODE,ORDER_ID, RECORD_DATE_TIME, FILL_PROC_ID,ORDERING_FACILITY_ID, ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, DISPENSED_DATE_TIME,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DAILY_SEQ_NUM)VALUES(?,?,?,?,SYSDATE,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?,?)") ;
					//pstmt_insert_hdr_tmp = (PreparedStatement)pstmt_stmnts.get(5);
					int index = 1;

					seq_no.put(order_id,int_disp_tmp_no+"");
					tabData.put("seq_no",seq_no);
		
					pstmt_insert_hdr_tmp.setString(index  ,int_disp_tmp_no+"");	// DISP_TMP_NO
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("login_facility_id"));// FACILITY_ID
					pstmt_insert_hdr_tmp.setString(++index,disp_locn_code);		// DISP_LOCN_CODE
					pstmt_insert_hdr_tmp.setString(++index,order_id);			// ORDER_ID
					pstmt_insert_hdr_tmp.setString(++index,fill_proc_id);		// FILL_PROC_ID
					pstmt_insert_hdr_tmp.setString(++index,ord_facility_id);	// ORDERING_FACILITY_ID
					pstmt_insert_hdr_tmp.setString(++index,ord_date_time);		// ORD_DATE_TIME
					pstmt_insert_hdr_tmp.setString(++index,patient_id);			// PATIENT_ID
					pstmt_insert_hdr_tmp.setString(++index,encounter_id);		// ENCOUNTER_ID
					pstmt_insert_hdr_tmp.setString(++index,patient_class);		// PATIENT_CLASS				
					pstmt_insert_hdr_tmp.setString(++index,source_type);		// LOCN_TYPE
					pstmt_insert_hdr_tmp.setString(++index,source_code);		// LOCN_CODE
					pstmt_insert_hdr_tmp.setString(++index,"");					// ROOM_TYPE
					pstmt_insert_hdr_tmp.setString(++index,room_num);	         // ROOM_NO
					pstmt_insert_hdr_tmp.setString(++index,bed_num);		     // BED_NO
					pstmt_insert_hdr_tmp.setString(++index,bed_class_code);	   			    // BED_CLASS
					pstmt_insert_hdr_tmp.setString(++index,bed_type_code);				    // BED_TYPE
					pstmt_insert_hdr_tmp.setString(++index,specialty_code);			// SPECIALITY_CODE
					pstmt_insert_hdr_tmp.setString(++index,attend_practitioner_id);	// 
					pstmt_insert_hdr_tmp.setString(++index,ord_pract_id);			// PRES_PHYSICIAN_ID
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("user_id"));			// 
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("user_id"));			 // 
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("login_at_ws_no"));	 // 
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("login_facility_id"));// 
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("user_id"));			 // 
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("login_at_ws_no"));	 // 
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("login_facility_id"));// 
					
					/*if(SeqInserthdrlist.size()>0){
					dailySeqNum1=SeqInserthdrlist.indexOf(patient_id);
					dailySeqNum1++;
					dlySeqNum=SeqInserthdrlist.get(dailySeqNum1).toString();
					 */
					if(!dsn_no.equals("")) {
						pstmt_insert_hdr_tmp.setString(++index,dsn_no);
					}
					else{
						pstmt_insert_hdr_tmp.setString(++index,"");
					}
					int pstmt_insert_hdr_tmp_rows  =pstmt_insert_hdr_tmp.executeUpdate();
					if(pstmt_insert_hdr_tmp_rows>0){
						is_success=true;
					}
					else{
					   is_success=false;
					   return is_success; 
					}
				}
				String dtl_serial_num = "";
              
			//	pstmt = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT13);
				pstmt = (PreparedStatement)pstmt_stmnts.get(6);
				pstmt.setString(1,int_disp_tmp_no+"");		// DISP_TMP_NO
				pstmt.setString(2,disp_drug_code);			// DISP_DRUG_CODE
				resultSet = pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					dtl_serial_num = resultSet.getString("DTL_SERIAL_NUM");
				}
				closeResultSet( resultSet ) ;
				pstmt=null;
			//	pstmt_update = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP);//PH_DISP_DTL_TMP
				pstmt_update = (PreparedStatement)pstmt_stmnts.get(7);
				pstmt_update.setString(1,req_qty_value);
				pstmt_update.setString(2,(String)tabData.get("user_id"));			 // MODIFIED_BY_ID
				pstmt_update.setString(3,(String)tabData.get("login_facility_id"));// MODIFIED_FACILITY_ID
				pstmt_update.setString(4,(String)tabData.get("login_at_ws_no"));	 // MODIFIED_AT_WS_NO
				pstmt_update.setString(5,order_id);
				pstmt_update.setString(6,order_line_no);
				pstmt_update.setString(7,disp_tmp_no);
				pstmt_update.setString(8,int_disp_tmp_no+"");
				int updated_rows = pstmt_update.executeUpdate();
				//code added for inserting special and cautionary instructions

                int no_of_days                  = 0;
				String fract_dose_round_up_yn   = "N";
				String caution_label_text_id    ="";
				String spl_instr_label_text_id  ="";
				String how_to_take_text         ="";

				//String cau_inst_eng         =""; Unused local variable INC63877
				String cau_inst_loc         ="";
				//String spl_inst_eng         =""; Unused local variable INC63877
				String spl_inst_loc         ="";

				pstmt	                      = null;
				pstmt	   = connection.prepareStatement("SELECT FRACT_DOSE_ROUND_UP_YN,CAUTION_LABEL_TEXT_ID_1, SPL_INSTR_LABEL_TEXT_ID, HOW_TO_TAKE_TEXT FROM ph_drug WHERE drug_code = ?");
				//pstmt	   = (PreparedStatement)pstmt_stmnts.get(12);
				pstmt.setString(1,disp_drug_code);
				resultSet = pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()){
					fract_dose_round_up_yn   = resultSet.getString("FRACT_DOSE_ROUND_UP_YN");
					caution_label_text_id    = resultSet.getString("CAUTION_LABEL_TEXT_ID_1")==null?"":resultSet.getString("CAUTION_LABEL_TEXT_ID_1");
					spl_instr_label_text_id  = resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")==null?"":resultSet.getString("SPL_INSTR_LABEL_TEXT_ID");
					how_to_take_text         = resultSet.getString("HOW_TO_TAKE_TEXT")==null?"":resultSet.getString("HOW_TO_TAKE_TEXT");
				}
				
				closeResultSet( resultSet ) ;
				if(!caution_label_text_id.equals("")){
					
					closeStatement( pstmt ) ; //common-icn-0029
					pstmt	                      = null;
					pstmt	   = connection.prepareStatement("SELECT LABEL_TEXT_1,LANGUAGE_ID FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID=? and LANGUAGE_ID in(select LANGUAGE_ID  from sm_language where EFF_STATUS ='E' and PRIMARY_LANG_YN ='N' and rownum<=1)");//'en', removed from  LANGUAGE_ID in( for 40904
					
					pstmt.setString(1,caution_label_text_id);
					resultSet = pstmt.executeQuery();

					while(resultSet!=null && resultSet.next()){                    
						/*if((resultSet.getString("LANGUAGE_ID")).equals("en")) // code commented for 40904 --Start 
							cau_inst_eng    = resultSet.getString("LABEL_TEXT_1")==null?"":resultSet.getString("LABEL_TEXT_1");	
						else */ // code commented for 40904 --End 
						   cau_inst_loc    = resultSet.getString("LABEL_TEXT_1")==null?"":resultSet.getString("LABEL_TEXT_1");		
					}					
					closeResultSet( resultSet ) ;
			  }

              if(!spl_instr_label_text_id.equals("")){

					pstmt	                      = null;
					pstmt	   = connection.prepareStatement("SELECT LABEL_TEXT_1,LANGUAGE_ID FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID=? and LANGUAGE_ID in(select LANGUAGE_ID  from sm_language where EFF_STATUS ='E' and PRIMARY_LANG_YN ='N'  and rownum<=1)");//'en', removed from  LANGUAGE_ID in( for 40904
					
					pstmt.setString(1,spl_instr_label_text_id);
					resultSet = pstmt.executeQuery();
					while(resultSet!=null && resultSet.next()){
						/*if((resultSet.getString("LANGUAGE_ID")).equals("en"))// code commented for 40904 --Start 
							spl_inst_eng    = resultSet.getString("LABEL_TEXT_1")==null?"":resultSet.getString("LABEL_TEXT_1");	
						else */ //code commented for 40904 --End 
							spl_inst_loc    = resultSet.getString("LABEL_TEXT_1")==null?"":resultSet.getString("LABEL_TEXT_1");		
					}
					closeResultSet( resultSet ) ;
			  }
				pstmt_update=null;
				if(updated_rows==0){
					if(!stock_srl.containsKey( order_id + disp_drug_code)) {
						stock_srl.put(order_id + disp_drug_code,dtl_serial_num+"");
					}
					//pstmt_insert_dtl_tmp = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP);
					//pstmt_insert_dtl_tmp = connection.prepareStatement("INSERT INTO PH_DISP_DTL_TMP(DISP_TMP_NO, DTL_SERIAL_NUM, RECORD_DATE_TIME, FACILITY_ID,DISP_LOCN_CODE, PRES_DRUG_CODE,ORDER_ID, ORDER_LINE_NO, ORDERING_FACILITY_ID, DISP_DRUG_CODE,DISP_QTY, DISP_UOM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DOC_SRL_NO,DSN_REFERENCE)VALUES( NVL(?,?),?,SYSDATE,?,?,?,?,?,?,?,NVL(?,0),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?)");

					pstmt_insert_dtl_tmp = connection.prepareStatement("INSERT INTO PH_DISP_DTL_TMP(DISP_TMP_NO, DTL_SERIAL_NUM, RECORD_DATE_TIME, FACILITY_ID,DISP_LOCN_CODE, PRES_DRUG_CODE,ORDER_ID, ORDER_LINE_NO, ORDERING_FACILITY_ID, DISP_DRUG_CODE,DISP_QTY, DISP_UOM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DOC_SRL_NO,DSN_REFERENCE,ALLOC_STATUS,CERT_REIMB_APPL_YN,LABEL_CAU_INSTRN1_ENG, LABEL_SPL_INSTRN1_ENG, LABEL_CAU_INSTRN1_LOC, LABEL_SPL_INSTRN1_LOC,LABEL_PAT_INSTRN1_ENG, ALT_DRUG_REMARKS)VALUES( NVL(?,?),?,SYSDATE,?,?,?,?,?,?,?,NVL(?,0),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?, ?)");
					//pstmt_insert_dtl_tmp = (PreparedStatement)pstmt_stmnts.get(8);
					int index = 1;
					if ( disp_drug_code == null || disp_drug_code.equals("") || disp_drug_code.equals("null") || disp_drug_code.equals(" ")){disp_drug_code=order_catalog_code;}
					pstmt_insert_dtl_tmp.setString(index  ,disp_tmp_no);							 // DISP_TMP_NO
					pstmt_insert_dtl_tmp.setString(++index,int_disp_tmp_no+"");						 // DISP_TMP_NO
					pstmt_insert_dtl_tmp.setString(++index,dtl_serial_num);							 // DTL_SERIAL_NUM
					pstmt_insert_dtl_tmp.setString(++index,(String)tabData.get("login_facility_id"));// FACILITY_ID
					pstmt_insert_dtl_tmp.setString(++index,disp_locn_code);							 // DISP_LOCN_CODE
					pstmt_insert_dtl_tmp.setString(++index,order_catalog_code);						 // PRES_DRUG_CODE
					pstmt_insert_dtl_tmp.setString(++index,order_id);								 // ORDER_ID
					pstmt_insert_dtl_tmp.setString(++index,order_line_no);							 // ORDER_LINE_NO
					pstmt_insert_dtl_tmp.setString(++index,ord_facility_id);						 // ORDERING_FACILITY_ID
					pstmt_insert_dtl_tmp.setString(++index,disp_drug_code);							 // DISP_DRUG_CODE
					pstmt_insert_dtl_tmp.setString(++index,req_qty_value);							 // DISP_QTY
					pstmt_insert_dtl_tmp.setString(++index,req_qty_unit);							 // DISP_UOM_CODE
					pstmt_insert_dtl_tmp.setString(++index,(String)tabData.get("user_id"));			 // ADDED_BY_ID
					pstmt_insert_dtl_tmp.setString(++index,(String)tabData.get("login_at_ws_no"));	 // ADDED_AT_WS_NO
					pstmt_insert_dtl_tmp.setString(++index,(String)tabData.get("login_facility_id"));// ADDED_FACILITY_ID
					pstmt_insert_dtl_tmp.setString(++index,(String)tabData.get("user_id"));			 // MODIFIED_BY_ID
					pstmt_insert_dtl_tmp.setString(++index,(String)tabData.get("login_at_ws_no"));	 // MODIFIED_AT_WS_NO
					pstmt_insert_dtl_tmp.setString(++index,(String)tabData.get("login_facility_id"));// MODIFIED_FACILITY_ID
					pstmt_insert_dtl_tmp.setString(++index,dtl_serial_num);
					if(Patientinsertlist.size()>0){
					     pstmt_insert_dtl_tmp.setString(++index,Patientinsertlist.get(insert_Count+1).toString());		 // DSN_REFERENCE
					}
					else{
					     pstmt_insert_dtl_tmp.setString(++index,"");		  // DSN_REFERENCE
					}
					
					if(req_qty_value.equals("0")){
					    pstmt_insert_dtl_tmp.setString(++index,"N");		  // ALLOC_STATUS
					}
					else{
					    pstmt_insert_dtl_tmp.setString(++index,"F");
					}

                    if(tabData.get("CUSTOMER_ID").equals("SRR")){
						if(getEssentialItemYN(connection,disp_drug_code).equals("N")){
							if(!patient_cer_no.containsKey(patient_id)){
								String cer_res_no = (String)GenerateCerRemNO(connection);
								patient_cer_no.put(patient_id,cer_res_no);								
							}
							cer_res_yn           ="Y";
							order_cer_no.put(order_id,patient_cer_no.get(patient_id));
						}
						else{
							cer_res_yn           ="N";
						}
					}

					 pstmt_insert_dtl_tmp.setString(++index,cer_res_yn);

					 pstmt_insert_dtl_tmp.setString(++index,caution_label_text_id);//'cau_inst_eng' replaced by  'caution_label_text_id' for 40904					
					 pstmt_insert_dtl_tmp.setString(++index,spl_instr_label_text_id);//'spl_inst_eng' replaced by  'spl_instr_label_text_id' for 40904
					 pstmt_insert_dtl_tmp.setString(++index,cau_inst_loc);
					 pstmt_insert_dtl_tmp.setString(++index,spl_inst_loc);
					 pstmt_insert_dtl_tmp.setString(++index,how_to_take_text);
					 pstmt_insert_dtl_tmp.setString(++index,alt_drug_remarks); //Added for  Bru-HIMS-CRF-082 [IN:029948]
					
					int pstmt_insert_dtl_tmp_rows=pstmt_insert_dtl_tmp.executeUpdate();
					 if(pstmt_insert_dtl_tmp_rows>0){
						is_success=true;
					 }
				     else{
						 is_success=false;
						 return is_success; 
					 }
					closeStatement( pstmt_insert_dtl_tmp ) ;
					pstmt_insert_dtl_tmp=null;
					
					HashMap hmDetail	=	new HashMap();
					hmDetail.put("doc_srl_no",dtl_serial_num);
					hmDetail.put("item_code",disp_drug_code);
					hmDetail.put("sal_category","");
					hmDetail.put("hcp_issue_factor","");
					hmDetail.put("item_qty",req_qty_value);
					hmDetail.put("item_sal_value","0");
					hmDetail.put("next_due_date","");
					hmDetail.put("stock_item_yn","Y");
					hmDetail.put("remarks","");
					hmDetail.put("item_unit_cost","0");
					hmDetail.put("item_cost_value","0");
					hmDetail.put("item_unit_price","0");
					hmDetail.put("uom_code",req_qty_unit);
				}

				String fill_int_end_date_time   = "";
			
			//	pstmt = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT8);
				pstmt = (PreparedStatement)pstmt_stmnts.get(9);
				pstmt.setString(1,fill_proc_id);
				resultSet = pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					fill_int_end_date_time   = resultSet.getString("FILL_INT_END_DATE_TIME");
//					fill_int_start_date_time = resultSet.getString("FILL_INT_START_DATE_TIME");
				}
				closeResultSet( resultSet ) ;
				pstmt=null;

			//	pstmt	   = connection.prepareStatement(stmt2);				
				pstmt	   = (PreparedStatement)pstmt_stmnts.get(11);
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet = pstmt.executeQuery();
				int total=0;
                 
                if(resultSet!=null && resultSet.next()){
					total  =  resultSet.getInt("TOT");
				}
				closeResultSet( resultSet ) ;

			/*	int no_of_days                = 0;
				String fract_dose_round_up_yn = "N";
				pstmt	                      = null;
				resultSet                     = null;

				pstmt	   = connection.prepareStatement("SELECT FRACT_DOSE_ROUND_UP_YN FROM ph_drug WHERE drug_code = ?");
				//pstmt	   = (PreparedStatement)pstmt_stmnts.get(12);
				pstmt.setString(1,disp_drug_code);
				resultSet = pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()){
					fract_dose_round_up_yn = resultSet.getString("FRACT_DOSE_ROUND_UP_YN");
				}
				
				closeResultSet( resultSet ) ;
				*/
			//	pstmt_update	   = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH);//ORDER_LINE_PH
				pstmt_update	   = (PreparedStatement)pstmt_stmnts.get(13);
				pstmt_update.setString(1,fill_proc_id);
				pstmt_update.setString(2,req_qty_value);
				pstmt_update.setString(3,req_qty_unit);
				pstmt_update.setString(4,disp_tmp_no);
				if(fract_dose_round_up_yn!=null && fract_dose_round_up_yn.equals("Y")){
					pstmt_update.setString(5,fill_int_end_date_time);
					pstmt_update.setString(6,(String)tabData.get("Ip_Fill_Prd_Ahead"));
				}
				else{
					pstmt_update.setString(5,fill_int_end_date_time);
					no_of_days	=	0;
					pstmt_update.setString(6,no_of_days+"");
				}
				//pstmt_update.setString(6,no_of_days+"");
				pstmt_update.setString(7,(String)tabData.get("user_id"));			 // MODIFIED_BY_ID
				pstmt_update.setString(8,(String)tabData.get("login_facility_id")); // MODIFIED_FACILITY_ID
				pstmt_update.setString(9,(String)tabData.get("login_at_ws_no"));	 // MODIFIED_AT_WS_NO
				pstmt_update.setString(10,order_id);			// order_id
				pstmt_update.setString(11,order_line_no);		// order_line_no				
				int pstmt_update_row=pstmt_update.executeUpdate();
				//closeStatement( pstmt_update ) ;
				if(pstmt_update_row>0){
					is_success=true;
				}
				else{
					is_success=false;
				}
				 pstmt_update=null;

				if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
					pstmt_update	   = (PreparedStatement)pstmt_stmnts.get(14);
					pstmt_update.setString(1,alt_drug_remarks);
					pstmt_update.setString(2,(String)tabData.get("user_id"));			 // MODIFIED_BY_ID
					pstmt_update.setString(3,(String)tabData.get("login_at_ws_no"));	 // MODIFIED_AT_WS_NO
					pstmt_update.setString(4,(String)tabData.get("login_facility_id")); // MODIFIED_FACILITY_ID
					pstmt_update.setString(5,order_id);			// order_id
					pstmt_update.setString(6,order_line_no);		// order_line_no				
					pstmt_update.executeUpdate();
					closeStatement(pstmt_update);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			is_success=false;
			//connection.rollback();
			//throw new EJBException("Operation Failed.........while inserting into TMP Tables");
		}
		finally{
			try {
				resultSet =null;
				pstmt =null;
				pstmt_update =null;
				pstmt_insert_hdr_tmp =null;
				pstmt_insert_dtl_tmp =null;
			}catch(Exception es) { es.printStackTrace(); }
		}
		return is_success;
	}
	
	/* The method getOrderStatus is used to get ORDER_STATUS_TYPE from OR_ORDER_STATUS_CODE 
	   based on ORDER_STATUS_CODE
	 */
	private String getOrderStatus(String order_status_code,String SQL_PH_IP_FILL_PROCESS_SELECT5,Connection connection) throws Exception{
		String order_status_type = "";
		PreparedStatement pstmt  = null ;
		ResultSet resultSet      = null ;
		try {
			//connection = getConnection(prop) ;   commented by naveen on 3/12/2005 as suggested by mohanthy & srikantha
			pstmt = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT5) ;
			pstmt.setString(1,order_status_code);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				order_status_type = resultSet.getString("ORDER_STATUS_TYPE");
			}
			if(resultSet != null){	closeResultSet( resultSet ) ;}
			if(pstmt != null){	closeStatement( pstmt ) ;}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			connection.rollback();
			throw new EJBException("Operation Failed.........while getOrderStatus");
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				resultSet=null;
				pstmt=null;
			}catch(Exception es) { es.printStackTrace(); }
		}
		return order_status_type;
	}

	private int compareDateWithTime(String end_date_time,String fill_int_end_date_time,String SQL_PH_IP_FILL_PROCESS_SELECT34,Connection connection){
		int datevalue = 0;
		PreparedStatement pstmt  = null ;
		ResultSet resultSet      = null ;
		try {
			pstmt = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT34) ;
			pstmt.setString(1,end_date_time);
			pstmt.setString(2,fill_int_end_date_time);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				datevalue = resultSet.getInt("DATEVALUE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw new EJBException("Operation Failed.........while comparing the dates");
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				resultSet=null;
				pstmt=null;

			}catch(Exception es) { es.printStackTrace(); }
		}
		return datevalue;
	}

	private String getStockDocType(Connection conn, HashMap sqlMap,String patient_class,String facility_id){
		String st_doc_type							=	"";
		PreparedStatement pstmt_st_doc_type			=	null;
		ResultSet resSet							=	null;
		try {
			pstmt_st_doc_type	= conn.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT56") ) ;
			if(patient_class.equals("I")) {
				pstmt_st_doc_type.setString(1,"DIIP");
			}
			else {
				pstmt_st_doc_type.setString(1,"DIOP");
			}
			    pstmt_st_doc_type.setString(2,facility_id);
				 pstmt_st_doc_type.setString(3,facility_id);
			resSet				= pstmt_st_doc_type.executeQuery() ;
			if(resSet.next()) {
				st_doc_type	=	(String)resSet.getString("ST_DOC_TYPE_CODE");
			}
		}
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		finally{	
			try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_type ) ;
				resSet=null;
				pstmt_st_doc_type=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return st_doc_type;
	}

	public String getItemCost(String item_code,String store_code, String qty_reqd,String eff_date,Connection connection,CallableStatement cstmt){
		//CallableStatement cstmt = null ;
		String item_cost		=	"";
		try {
			//cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, item_code );
			cstmt.setString( 2, store_code );
			cstmt.setString( 3, qty_reqd );
			cstmt.setString( 4, "N" );
			cstmt.setString( 5, eff_date);
			cstmt.setString( 6, "Y");
			cstmt.setString( 7, "");
			cstmt.registerOutParameter(8,  Types.VARCHAR );
			cstmt.registerOutParameter(9,  Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.INTEGER );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			cstmt.registerOutParameter(13, Types.VARCHAR );
			cstmt.registerOutParameter(14, Types.VARCHAR );
			cstmt.registerOutParameter(15, Types.VARCHAR );
			cstmt.registerOutParameter(16, Types.VARCHAR );
			cstmt.registerOutParameter(17, Types.VARCHAR );
			cstmt.registerOutParameter(18, Types.VARCHAR );
			cstmt.registerOutParameter(19, Types.VARCHAR );
			cstmt.execute() ;
			item_cost	=	(String)(cstmt.getString(10));
			//closeStatement( cstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		return item_cost;
	}
	
	private boolean callStockUpdate(Connection connection,HashMap tabData,HashMap sqlMap,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type,HashMap stock_srl,PreparedStatement pstmt_update_disp_hdr_tmp,PreparedStatement pstmt_update_med_hdr,String ordering_facility_id, String ord_pract_id)throws Exception{ // , String ord_pract_id added for SRR20056-SCF-7373
		 boolean updateStock_id=false;
		try {
			//if block added for SRR20056-SCF-7659.1 
			if(stock_srl.size() == 0 || stock_srl == null || stock_srl.equals("")){
				connection.rollback();
				throw new Exception("APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...");
			} 
			String item_code	=	"";
			String item_cost	=	"";
			String cost_value	=	"";
			String batch_id		=	"";
			String expiry_date	=	"";
			String bin_locn_code =	"";
			String trade_id		=	"";
			String disp_qty		=	"";
			String order_id		=	"";
			String docno		=	"";
			String temp_order_id=   "";//Added for MMS-DM-CRF-126.1
			String temp_order_line_no=   "";//Added for MMS-DM-CRF-126.1
			ArrayList orders	=	new ArrayList();
			HashMap stock_dtls	=	new HashMap();
			ArrayList insertDetail	=	new ArrayList();
			ArrayList insertExp		=	new ArrayList();
			ArrayList updateDetail	=	new ArrayList();
			ArrayList updateExp		=	new ArrayList();
            HashMap BaseAndIssueUOMQty	= new HashMap();
			if(tabData.get("st_decimal_restriction")==null)//added for MMS-DM-SCF-0210 [IN:059660]
				tabData.put("st_decimal_restriction", "N");//added for MMS-DM-SCF-0210 [IN:059660]
		    eST.Common.StSales	stSales		=	new eST.Common.StSales();//added for MMS-DM-SCF-0210 [IN:059660]
			int     noOfDecimalsForCost   =  Integer.parseInt(stSales.getNoOfDecimalsCost(connection));//added for MMS-DM-SCF-0210 [IN:059660]
          
			for(int i=0;i<dispTMP.size();i=i+9){
				tabData.put("patient_id",dispTMP.get(i+7));				
				tabData.put("encounter_id",dispTMP.get(i+8));
                temp_order_id =(String)dispTMP.get(i);//Added for MMS-DM-CRF-126.1
                temp_order_line_no =(String)dispTMP.get(i+1);//Added for MMS-DM-CRF-126.1

				if(orders.size()!=0 && (!orders.contains(((String)dispTMP.get(i)).trim()))) {
					stock_dtls.put("insertDetail",insertDetail);
					stock_dtls.put("updateDetail",updateDetail);
					stock_dtls.put("insertExp",insertExp);
					stock_dtls.put("updateExp",updateExp);

					updateStock_id=updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id);
				
					stock_dtls		=	new HashMap();
					insertDetail	=	new ArrayList();
					insertExp		=	new ArrayList();
					updateDetail	=	new ArrayList();
					updateExp		=	new ArrayList();
					orders			=	new ArrayList();
					order_id		=	"";
					docno			=	"";
				}
				ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);

				if(batchDetails.size()>0){	
					item_code				=	(String)batchDetails.get(0);
					item_cost				=	(String)batchDetails.get(8);

					if(item_cost.equals("")) 
						item_cost	=	"0";

					//cost_value	=(Integer.parseInt((String)dispTMP.get(i+4)) * Math.abs(Float.parseFloat(item_cost)))+"";
	//commented during 537.3
					//cost_value	=	Math.round(Integer.parseInt((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";
					//cost_value	= (Double.parseDouble(cost_value)/1000)+"";
	//ends here
					// Item Detail
					HashMap hmDetail	=	new HashMap();
					hmDetail.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim()));
					hmDetail.put("item_code",item_code);
					hmDetail.put("sal_category","");
					hmDetail.put("hcp_issue_factor","");
					//hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
				   //done for 551.3 CRF
					BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  (String)tabData.get("store_code"), ((String)dispTMP.get(i+4)).trim(),  ((String)dispTMP.get(i+5)).trim() );
					hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
					hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));

					cost_value	=	Math.round(Double.parseDouble((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(item_cost)*1000)+"";
					cost_value	=   (Double.parseDouble(cost_value)/1000)+"";

					hmDetail.put("next_due_date","");
					hmDetail.put("stock_item_yn","Y");
					hmDetail.put("remarks","");
					System.err.println("st_decimal_restriction@@@@==="+tabData.get("st_decimal_restriction"));
					if(tabData.get("st_decimal_restriction").equals("Y")){//Added for MMS-DM-SCF-0210 [IN:059660]
						hmDetail.put("item_cost_value",stSales.setNumber(""+item_cost, noOfDecimalsForCost)); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]//no of decimals added for MMS-DM-SCF-0210 [IN:059660]
					    hmDetail.put("item_sal_value",stSales.setNumber(""+item_cost, noOfDecimalsForCost)); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]//no of decimals added for MMS-DM-SCF-0210 [IN:059660]
					}else{
						hmDetail.put("item_cost_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
					    hmDetail.put("item_sal_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
					}
					hmDetail.put("item_unit_cost",item_cost);
					hmDetail.put("item_unit_price",item_cost);
					hmDetail.put("uom_code",((String)dispTMP.get(i+5)).trim());
					hmDetail.put("mode",(String)tabData.get("mode"));
					hmDetail.put("p_ord_practitioner_id",ord_pract_id); // added for SRR20056-SCF-7373
					hmDetail.put("ph_order_id",temp_order_id); // added for MMS-DM-CRF-126.1
					hmDetail.put("ph_order_line_no",temp_order_line_no); // added for MMS-DM-CRF-126.1
					hmDetail.put("ph_function_id","IP_FILL_ALL"); // added for MMS-DM-CRF-126.1
					if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim())) 
						updateDetail.add(hmDetail);
					else
						insertDetail.add(hmDetail);
				}
				// Batch Details
				for (int j=0;j<batchDetails.size() ; j=j+9){
					batch_id		= (String)batchDetails.get(j+1);
					expiry_date		= (String)batchDetails.get(j+2);
					disp_qty		= (String)batchDetails.get(j+3);
					trade_id		= (String)batchDetails.get(j+6);
					bin_locn_code	= (String)batchDetails.get(j+7);

					HashMap hmExp	=	new HashMap();
					hmExp.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim()));
					hmExp.put("store_code",(String)tabData.get("store_code"));
					hmExp.put("item_code",item_code);
					hmExp.put("batch_id",batch_id);
					hmExp.put("bin_location_code",bin_locn_code);
					hmExp.put("expiry_date_or_receipt_date",expiry_date);
					hmExp.put("trade_id",trade_id);
					//hmExp.put("sal_item_qty",disp_qty);

//done for 551.3 CRF
                    BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  (String)tabData.get("store_code"), disp_qty,  ((String)dispTMP.get(i+5)).trim());
				    hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
//ends here
					hmExp.put("ret_item_qty","");

					if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim())) 
						updateExp.add(hmExp);	
					else
						insertExp.add(hmExp);
				}

				if(!orders.contains(((String)dispTMP.get(i)).trim())) {
					orders.add(((String)dispTMP.get(i)).trim());
					order_id	=	(String)orders.get(0);

					if(prev_doc_no.containsKey(order_id))
						docno		=	(String)prev_doc_no.get(order_id);
				}
			}
			stock_dtls.put("insertDetail",insertDetail);
			stock_dtls.put("updateDetail",updateDetail);
			stock_dtls.put("insertExp",insertExp);
    		stock_dtls.put("updateExp",updateExp);
	    	updateStock_id=updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id);
		} 
		catch(Exception e) {
			e.printStackTrace();
			//throw e;
			throw new EJBException(e.getMessage());
		}
		return updateStock_id; 
	}

	private boolean updateStock(Connection connection,HashMap tabData, HashMap sqlMap, HashMap stock_dtls,String order_id, String prev_doc_no,String  st_doc_type,PreparedStatement pstmt_update_disp_hdr_tmp,PreparedStatement pstmt_update_med_hdr,String ordering_facility_id) throws Exception{
	//	Stock Insertion starts
		HashMap hmHeader	=	new HashMap();
		HashMap hmCommon	=	new HashMap();
		HashMap hmData		=	new HashMap();
		ArrayList insertDetail	=	(ArrayList)stock_dtls.get("insertDetail");
		ArrayList updateDetail	=	(ArrayList)stock_dtls.get("updateDetail");
		ArrayList insertExp		=	(ArrayList)stock_dtls.get("insertExp");
		ArrayList updateExp		=	(ArrayList)stock_dtls.get("updateExp");
		ArrayList language_data =  new ArrayList();
		String bl_interface_yn  =   (String)tabData.get("BL_INTERFACE_YN")== null?"N":(String)tabData.get("BL_INTERFACE_YN");
		boolean updateStock_id=false;

		//PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		hmHeader.put("facility_id",(String)tabData.get("facility_id"));
		hmHeader.put("doc_type_code",st_doc_type);
		hmHeader.put("doc_no","");
		hmHeader.put("doc_date",(String)tabData.get("today"));
		hmHeader.put("doc_ref","");
		hmHeader.put("store_code",(String)tabData.get("store_code"));
		
		if(((String)tabData.get("DispBillingStage")).equals("A")){
		     hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));
	   }
	   else{
            hmHeader.put("authorized_by_id","");
	   }
		//hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));
		hmHeader.put("cancelled_by_id","");
		hmHeader.put("cancelled_remarks","");
		hmHeader.put("finalized_yn","N");
		hmHeader.put("gl_interfaced_yn","N");
		hmHeader.put("billable_trn_yn",bl_interface_yn);
		hmHeader.put("take_home_yn","N");
		hmHeader.put("trn_type","SAL");
		hmHeader.put("add_qty_sal_yn","N");
		hmHeader.put("patient_id",(String)tabData.get("patient_id"));
		hmHeader.put("encounter_id",(String)tabData.get("encounter_id"));

        String sal_trn_type = getEncounterPatientClass(connection,sqlMap,(String)tabData.get("encounter_id"), ordering_facility_id,(String)tabData.get("patient_id")); //patient_id added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription

		hmHeader.put("sal_trn_type",sal_trn_type);
		hmHeader.put("remarks","");
		hmHeader.put("item_class_code","");
		hmHeader.put("module_id","PH");
		
		hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
		hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
		hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
		hmCommon.put("FACILITY_STR_FOR_BL",ordering_facility_id+"|"+(String)tabData.get("facility_id"));

		language_data.add((String)tabData.get("LanguageId"));

		hmData.put("HDR_DATA",hmHeader);
		hmData.put("COMMON_DATA",hmCommon);
		hmData.put("LANGUAGE_DATA",language_data);
		String message_id ="";
		String message  = "";

		try{
			if(insertDetail.size()!=0) {
				hmData.put("DTL_DATA",insertDetail);
				hmData.put("DTL_EXP_DATA",insertExp);
				eST.Common.StSales	stSales	=	new eST.Common.StSales();
				HashMap map	=	stSales.insertSales(connection,hmData);

				 updateStock_id=((Boolean) map.get( "result" )).booleanValue();
				if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					connection.rollback();
					//message_id =(String)map.get("msgid");
					//throw new EJBException("insert Sales failed"+(String)map.get("msgid"));
					message_id = (String)map.get("msgid");
					message  = (String)map.get("message");
					if(message_id.equals(message))
						message="";

					throw new EJBException(message_id+":-"+message);//"insert Sales failed"
				}
				else {
					String docno				=	(String)map.get("doc_no");
					String doctypecode			=	(String)map.get("doc_type_code");
					//pstmt_update_disp_hdr_tmp		=	null;
					//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
					pstmt_update_disp_hdr_tmp.setString(1,doctypecode );
					pstmt_update_disp_hdr_tmp.setString(2,docno);  
					pstmt_update_disp_hdr_tmp.setString(3,(String)order_cer_no.get(order_id));  
					pstmt_update_disp_hdr_tmp.setString(4,order_id);
					pstmt_update_disp_hdr_tmp.setString(5,(String)tabData.get("facility_id"));
					pstmt_update_disp_hdr_tmp.executeUpdate();
					//closeStatement(pstmt_update_disp_hdr_tmp);
					if(((HashMap)tabData.get("seq_no")).containsKey(order_id)) {
						//pstmt_update_disp_hdr_tmp		=	null;
						//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE") ) ;
						pstmt_update_med_hdr.setString(1,doctypecode );
						pstmt_update_med_hdr.setString(2,docno);  
						pstmt_update_med_hdr.setString(3,(String)((HashMap)tabData.get("seq_no")).get(order_id));
						pstmt_update_med_hdr.setString(4,(String)tabData.get("facility_id"));
						pstmt_update_med_hdr.executeUpdate();
						//closeStatement(pstmt_update_disp_hdr_tmp);
					}
				}
			}
			if(updateDetail.size()!=0) {
				hmHeader.put("doc_no",prev_doc_no);
				hmHeader.put("doc_type_code",st_doc_type);
				hmData.put("HDR_DATA",hmHeader);
				hmData.put("DTL_DATA",updateDetail);
				hmData.put("DTL_EXP_DATA",updateExp);

				eST.Common.StSales	stSales	=	new eST.Common.StSales();
				HashMap map					=	stSales.updateSales(connection,hmData);
				 updateStock_id=((Boolean) map.get( "result" )).booleanValue();
			   if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					connection.rollback();
					//message_id =(String)map.get("msgid");
					//throw new EJBException("update Sales failed : " + message_id);
					message_id = (String)map.get("msgid");
					message  = (String)map.get("message");
					if(message_id.equals(message))
						message="";
					if(message_id.contains("POPULATE_MAT_INTERFACED_RECS-1ORA-00001: unique constraint"))
						message = "APP-PH0900 Record already exists in Patient Charge Folio";
					throw new EJBException(message_id+":-"+message);
				} 
				else {
					//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
					pstmt_update_disp_hdr_tmp.setString(1,st_doc_type);
					pstmt_update_disp_hdr_tmp.setString(2,prev_doc_no);
					pstmt_update_disp_hdr_tmp.setString(3,(String)order_cer_no.get(order_id)); 
					pstmt_update_disp_hdr_tmp.setString(4,order_id);
					pstmt_update_disp_hdr_tmp.setString(5,(String)tabData.get("facility_id"));
					pstmt_update_disp_hdr_tmp.executeUpdate();					
					//closeStatement(pstmt_update_disp_hdr_tmp);
				}
			}
		}
		catch(Exception e) {	
			e.printStackTrace();
        /*    if( (message_id!=null && message_id.equals("CODE_ALREADY_EXISTS")) || (message_id!=null && (message_id.equals("RECORD_UPDATED_BY_OTH_USER") || e.getMessage().equals("RECORD_UPDATED_BY_OTH_USER")) ) ){ // added by rawther for scf : 7659 inc :027745
				// CODE_ALREADY_EXISTS , in ST it is changed to   RECORD_UPDATED_BY_OTH_USER
		 	    message_id ="Record Already In Use - It is used by Other User. Please Try again...";
			}
			else{
				// SRR20056-SCF-7659.1 (rawther, below 4 lines)
			    if(message_id!=null && (message_id.toString().contains("java.lang")|| message_id.toString().contains("java.sql")))
               		message_id ="Error - "+e.getMessage()+" - "+message_id;
                else if(message_id!=null)
					message_id = message_id;
				else 
					message_id = "Error - " +e;
			}
            throw new EJBException("update Stock : "+message_id);		*/
			throw new EJBException("Error - "+e.getMessage());
		}
		return updateStock_id;
	}

	public String getEncounterPatientClass(Connection connection,HashMap sqlMap,String encounter_id ,String facility_id, String patient_id){ //patient_id added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
		String EncounterPatientClass	= "";
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
		    pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,patient_id); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription

		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				EncounterPatientClass=resultSet.getString("ENC_PATIENT_CLASS");
			}
		}
        catch ( Exception e ) {
            e.printStackTrace() ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return EncounterPatientClass;
	}

	public String getSeqNumber(Connection connection, String sFacilityId,String sStoreCode)throws Exception{
		CallableStatement oCalStatement	= null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		int iDailySeqNo					= 0;
		//Connection connection_local		= getConnection( prop ) ;
		try {
			oStatement	= connection.createStatement();
			oResultSet	= oStatement.executeQuery("SELECT DECODE(ip_dsn_yn,null,'N',ip_dsn_yn) ip_dsn_yn FROM ph_facility_param WHERE facility_id = '"+sFacilityId+"'");

			if(oResultSet!=null && oResultSet.next()){
				if(oResultSet.getString("IP_DSN_YN").equals("Y")){
					oCalStatement=connection.prepareCall("{call PH_GET_DISP_DLY_SEQ_NO(?,?,?)}");
					oCalStatement.setString(1, sFacilityId.trim());
					oCalStatement.setString(2, sStoreCode.trim());
					oCalStatement.registerOutParameter(3,Types.VARCHAR);
					oCalStatement.execute();
					iDailySeqNo = oCalStatement.getInt(3);
					//connection_local.commit();
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally{		
			//closeConnection( connection_local, prop );
			closeResultSet( oResultSet ) ;
			closeStatement( oStatement ) ;
			closeStatement( oCalStatement ) ;
		}
		 if(iDailySeqNo == 0)
			 return "";
		 else
			 return iDailySeqNo+"";		
	}
//done for 537.3 variable UOM
	private HashMap getBaseAndIssueUOMQty(Connection connection, String item_code, String store_code,String disp_qty, String disp_uom){
        PreparedStatement pstmt             = null ;
        ResultSet resultSet                 = null ;
		String base_uom						= "";
		String def_store_uom				= "";
		double  base_to_disp_uom_equl_value	= 0;
		double  base_to_def_uom_equl_value		= 0;
		HashMap BaseAndIssueQTYDetail		= new HashMap();
		double base_qty						= 0;
		double issue_qty					= 0;
		
		try{
			pstmt					= connection.prepareStatement("SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code");
			pstmt.setString(1,store_code);
			pstmt.setString(2,item_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
                  base_uom		=	resultSet.getString("GEN_UOM_CODE");
				  def_store_uom	=	resultSet.getString("DEF_ISSUE_UOM");
			}
			
           base_to_disp_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, disp_uom);
		   base_to_def_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, def_store_uom);
           base_qty   =	Double.parseDouble(disp_qty)*(base_to_disp_uom_equl_value);
		   issue_qty  =	base_qty/base_to_def_uom_equl_value;

		   BaseAndIssueQTYDetail.put("BASE_QTY",base_qty+"");
		   BaseAndIssueQTYDetail.put("ISSUE_QTY",issue_qty+"");
			
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return BaseAndIssueQTYDetail;
	}

	public double getEqulValue (Connection connection,String item_code,String uom_code,String equl_uom_code){
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		double eqvl_value			= 1;
		try {
			if(uom_code.equals(equl_uom_code)){
				eqvl_value			= 1;
			}
			else{
				pstmt		= connection.prepareStatement( "select eqvl_value/eqvl_uom_qty EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
				pstmt.setString(1,item_code);
				pstmt.setString(2,uom_code);
				pstmt.setString(3,equl_uom_code);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet.next()){
					eqvl_value = resultSet.getDouble("EQVL_VALUE") <= 0 ? 1:resultSet.getDouble("EQVL_VALUE");	
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return eqvl_value;
	}

	public String getCustomerID(Connection connection)throws Exception	{
		
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String customer_id			= "";
		try {
			pstmt = connection.prepareStatement("SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE SITE_ID = 'DS'");
			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				customer_id = rsCustomerID.getString("CUSTOMER_ID")==null?"":rsCustomerID.getString("CUSTOMER_ID");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
		}
		return customer_id;
	}

	public String getEssentialItemYN(Connection connection,String item_code)throws Exception	{
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String essential_item_yn			= "";
		try {
			pstmt = connection.prepareStatement("select ESSENTIAL_ITEM_YN  from mm_item where item_code =?");
			pstmt.setString(1,item_code);
			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				essential_item_yn = rsCustomerID.getString("ESSENTIAL_ITEM_YN");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
		}
		return essential_item_yn;
	}

	public String GenerateCerRemNO (Connection connection)throws Exception	{
        CallableStatement cstmt	    = null;
       // ResultSet rsCustomerID		= null;
		String cer_rem_no			= "";
		try {			
			cstmt					= connection.prepareCall("{call ph_gen_cert_reimb_no (?)}");
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.execute();
			cer_rem_no	= cstmt.getString(1);
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			closeStatement( cstmt ) ;
		}
		return cer_rem_no;
	}
//ends here
}
