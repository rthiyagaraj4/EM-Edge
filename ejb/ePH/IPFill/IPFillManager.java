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
04/13/2017      63877   		chithra      UnusedLocal variable
---------------------------------------------------------------------------------------------------------------
*/
package ePH.IPFill ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;


/**
*
* @ejb.bean
*	name="IPFill"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPFill"
*	local-jndi-name="IPFill"
*	impl-class-name="ePH.IPFill.IPFillManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.IPFill.IPFillLocal"
*	remote-class="ePH.IPFill.IPFillRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.IPFill.IPFillLocalHome"
*	remote-class="ePH.IPFill.IPFillHome"
*	generate= "local,remote"
*
*
*/





public class IPFillManager extends PhEJBSessionAdapter {

	Properties prop   = null;
	ArrayList dispTMP = null; 
	HashMap stock_srl = null; 
	HashMap seq_no	  = null;
	
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
		
		System.err.println("calling ejb method ");
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
		//String updateStock_id 			 = "";	   Unused local variable INC63877
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
			pstmt_fillparam	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_FILLPARAM_INSERT"));
			pstmt_seq=connection.prepareStatement((String) sqlMap.get( "SQL_PH_FILLPARAM_SEQUENCE"));
			resultSet=pstmt_seq.executeQuery();
			while (resultSet.next()){
				SequenceNo=resultSet.getInt("SEQNO");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_seq ) ;
			//System.err.println("SequenceNo--------->"+SequenceNo);
			pstmt_fillparam.setInt(1,SequenceNo);
			pstmt_fillparam.setString(2,(String)tabData.get("iv_drug_ind"));
			pstmt_fillparam.setString(3,(String)tabData.get("compound_drug_ind"));
			pstmt_fillparam.setString(4,(String)tabData.get("ip_excl_intermittent_fill"));
			pstmt_fillparam.setString(5,(String)tabData.get("nursing_unit_or_locn"));
			pstmt_fillparam.setString(6,(String)tabData.get("Nursing_Unit_From"));
			pstmt_fillparam.setString(7,(String)tabData.get("Nursing_Unit_To"));
			pstmt_fillparam.setString(8,(String)tabData.get("Building_Code"));
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
			count =pstmt_fillparam.executeUpdate() ;
			//System.err.println("count--------->"+count);
			closeStatement( pstmt_fillparam ) ;
			connection.commit();
			if (count==0) {
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", "Error During Insertion into Fill Process Param" );
				return map;
			}else {
				//updateStock_id = mainIPFillProcess(SequenceNo+"",sqlMap,tabData,connection,st_doc_type,stock_srl);
				errMsg = mainIPFillProcess(SequenceNo+"",sqlMap,tabData,connection,st_doc_type,stock_srl);
               	errMsg1=errMsg.toString();
				errMsg1=errMsg1.replace('"','`');

				//System.err.println("errMsg1---> "+errMsg1);				

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
				dispTMP = null;	   

			}
				closeConnection( connection, prop );

		}catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "RECORD_NOT_INSERTED_FILL") ;		
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_fillparam ) ;
				closeStatement( pstmt_seq ) ;	
				
				resultSet			=null;
				pstmt_fillparam		=null;
				pstmt_seq 			=null;


				closeConnection( connection, (Properties)tabData.get( "properties" ) );
				tabData = null;
				sqlMap  = null;	
				dispTMP = null;
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
System.err.println("map-from EJB--> "+map);
		return map ;
	}

	private StringBuffer mainIPFillProcess(String fill_proc_id,HashMap sqlMap,HashMap tabData,Connection connection,String st_doc_type,HashMap stock_srl) {
		
		 System.err.println("mainIPFillProcess-----calling this method-->");
		 //System.err.println("tabData-----calling this method-->"+tabData);

		boolean is_success	= false;
		String updateStock_id="";
		String SQL_PH_IP_FILL_PROCESS_SELECT5  = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT5");
		String SQL_PH_IP_FILL_PROCESS_SELECT34			= (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT34");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A	= (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A");
		String SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL");
		String SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP");
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

		String stmt1="SELECT FRACT_DOSE_ROUND_UP_YN,CONTENT_IN_PRES_BASE_UOM,STRENGTH_PER_VALUE_PRES_UOM,STRENGTH_PER_PRES_UOM   FROM PH_DRUG WHERE DRUG_CODE =?";
	   	String stmt2="SELECT SUM(ORDER_LINE_DOSE_QTY_VALUE) TOT FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID = ?AND ORDER_LINE_NUM = ?";

		String SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE");
		String SQL_PH_DISP_MEDICATION_HRD_UPDATE = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE");

		PreparedStatement  pstmt_update = null,pstmt_update1 = null,pstmt_insert_fill_int_dtl = null,pstmt_insert1 = null,pstmt_select38 = null,pstmt_select33 = null,pstmt_select10 = null,pstmt_select11 = null,pstmt_select12 = null,pstmt_insert_hdr_tmp = null,pstmt_select13 = null,pstmt_update_dtl_tmp = null,pstmt_insert_dtl_tmp = null,pstmt_select8 = null,pstmt_stmt1 = null,pstmt_stmt2 = null,pstmt_ip_nod = null,pstmt_update_line_ph = null,pstmt_update_disp_hdr_tmp	=	null,pstmt_update_med_hdr = null,pstmt=null;

		CallableStatement cstmt		= null ;
		ArrayList pstmt_stmnts		= new ArrayList();
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

		ArrayList ip_fill_list			= (ArrayList)tabData.get("ipFillList");
		HashMap dispuoms                = (HashMap)tabData.get("DISPUOMS");
				
		HashMap reqData	 = new HashMap();
		HashMap ip_fill_order	= new HashMap();
		ArrayList all_sources	=	new ArrayList();
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
			cstmt						= connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			pstmt_stmnts.add(pstmt_select38);
			pstmt_stmnts.add(pstmt_select33);
			pstmt_stmnts.add(pstmt_select10);
			pstmt_stmnts.add(pstmt_select11);
			pstmt_stmnts.add(pstmt_select12);
			pstmt_stmnts.add(pstmt_insert_hdr_tmp);
			pstmt_stmnts.add(pstmt_select13);
			pstmt_stmnts.add(pstmt_update_dtl_tmp);
			pstmt_stmnts.add(pstmt_insert_dtl_tmp);
			pstmt_stmnts.add(pstmt_select8);
			pstmt_stmnts.add(pstmt_stmt1);
			pstmt_stmnts.add(pstmt_stmt2);
			pstmt_stmnts.add(pstmt_ip_nod);
			pstmt_stmnts.add(pstmt_update_line_ph);

			pstmt_update_disp_hdr_tmp		= connection.prepareStatement( SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE ) ;
			pstmt_update_med_hdr			= connection.prepareStatement( SQL_PH_DISP_MEDICATION_HRD_UPDATE ) ;

		if(ip_fill_list != null && ip_fill_list.size()>0){
	//System.err.println("in manager----->"+selectedRecords);
			for(int i = 0; i<ip_fill_list.size();i++){

				disp_qty		  = "";
				disp_qty_uom	  = "";
				disp_btch	  = "";
				disp_drug_code = "";
				disp_drug_desc = "";
				drug_choice	  = "";
				exp_date		  = "";
				btch_id		  = "";
				trade_name	  = "";
				dflt_bin		  = "";
				btch_qty		  = "";
				is_success	= false;

				dispTMP = new ArrayList();
              // for(int l = 0; l<selectedRecords.size();l++){
				if(selectedRecords.get(i).equals("Y")){
					   //System.out.println("checked= "+selectedRecords.get(i));
					   //System.out.println(i+ "th record inserting");
				ip_fill_order = (HashMap)ip_fill_list.get(i);

				order_id				= (String)ip_fill_order.get("ORDER_ID"); 
				order_line_no			= (String)ip_fill_order.get("ORDER_LINE_NUM");
				ordering_facility_id	= (String)ip_fill_order.get("ORDERING_FACILITY_ID"); 
				order_catalog_code		= (String)ip_fill_order.get("Drug_Code"); 
				order_qty				= (String)ip_fill_order.get("ORDER_QTY"); 
				order_uom				= (String)ip_fill_order.get("ORDER_UOM"); 
				ord_date_time			= (String)ip_fill_order.get("ORD_DATE_TIME"); 
				patient_id				= (String)ip_fill_order.get("PATIENT_ID"); 
				encounter_id			= (String)ip_fill_order.get("ENCOUNTER_ID"); 
				source_code				= (String)ip_fill_order.get("SOURCE_CODE");
				ord_pract_id			= (String)ip_fill_order.get("ORD_PRACT_ID"); 
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
				
				System.err.println("Tokencount------->"+Tokencount);
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
				
				if(Tokencount==6)
					{			
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

				try
				{
					is_success=insertTMPTables(reqData,sqlMap,tabData,connection,disp_locn_code,end_date_Time,pstmt_stmnts);
					if(!is_success){
						System.err.println("insertTMPTables failed------->"+is_success); 
						errMsg.append("\nUnsuccessfull process on \n Order ID: "+order_id);
						errMsg.append(" Patient ID: "+patient_id);
						errMsg.append(" Ord Drug code: "+order_catalog_code);
						errMsg.append(" Disp Drug code: "+disp_drug_code);
						errMsg.append(" Disp Drug Desc: "+disp_drug_desc);
						errMsg.append(" Error Msg: insertTMPTables failed");
						connection.rollback();
						continue;
					}
				}
				catch (Exception exp)
				{
					exp.printStackTrace();
					errMsg.append("\nUnsuccessfull process on \n Order ID: "+order_id);
					errMsg.append(" Patient ID:"+patient_id);
					errMsg.append(" Ord Drug code :"+order_catalog_code);
					errMsg.append(" Disp Drug code :"+disp_drug_code);
					errMsg.append(" Disp Drug Desc: "+disp_drug_desc);
					errMsg.append(" Error Msg: "+exp.getMessage().toString());
					connection.rollback();
					continue;
				}

				if(is_success){
					try
					{
						order_line_status = getOrderStatus((String)ip_fill_order.get("order_line_status"),SQL_PH_IP_FILL_PROCESS_SELECT5,connection);
						System.err.println("order_line_status------->"+order_line_status);
						System.err.println("order_id------->"+order_id);
						System.err.println("order_line_no------->"+order_line_no);
						
						System.err.println("is_success----475--->"+is_success);

						if(order_line_status.equals("10")|| order_line_status.equals("30")|| order_line_status.equals("56")){
							//pstmt_update	   = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A);
							pstmt_update.setString(1,(String)tabData.get("user_id"));
							pstmt_update.setString(2,(String)tabData.get("login_facility_id"));
							pstmt_update.setString(3,(String)tabData.get("login_at_ws_no"));
							pstmt_update.setString(4,order_id);
							pstmt_update.setString(5,order_line_no);
							int pstmt_update_rows= pstmt_update.executeUpdate();
							System.err.println("pstmt_update_rows--479--->"+pstmt_update_rows);
							//closeStatement( pstmt_update ) ;
							//pstmt_update=null;
							++corderline;
							System.err.println("corderline----->"+corderline);
							
					   }
						pstmt_update1.setString(1,(String)tabData.get("user_id"));
						pstmt_update1.setString(2,(String)tabData.get("login_facility_id"));
						pstmt_update1.setString(3,(String)tabData.get("login_at_ws_no"));
						pstmt_update1.setString(4,order_id);
						int pstmt_update1_rows=pstmt_update1.executeUpdate();
						System.err.println("pstmt_update1_rows------>"+pstmt_update1_rows);
						
						//checking stock is available or not
						//System.err.println("disp_qty------462------->"+disp_qty);

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
						 //	start available_stock
System.err.println("available_stock----477------->"+available_stock+"==disp_qty===="+disp_qty);
						if(available_stock!=null && !available_stock.equals("")){
							f_available_stock = Float.parseFloat(available_stock);
							f_disp_qty		= Float.parseFloat(disp_qty);
						 //start f_disp_qty
							if( (f_available_stock >= f_disp_qty) && Float.parseFloat(disp_qty) > 0){
								dispTMP.add(order_id);				// order_id
								dispTMP.add(order_line_no);			// order_line_no
								dispTMP.add(order_catalog_code);		// pres_drug_code
								dispTMP.add(disp_drug_code);		// disp_drug_code
								dispTMP.add(disp_qty);				// disp_qty
								dispTMP.add(disp_qty_uom);				// disp_uom_code
								batch_record  = new ArrayList();

								batch_record.add(disp_drug_code);	//item_drug_code
								batch_record.add(btch_id);			//batch_id
								batch_record.add(exp_date);	//expiry_date
								batch_record.add(btch_qty);							//issue_qty
								batch_record.add(disp_qty_uom);		//qty_uom
								batch_record.add("");										//item_drug_color
								batch_record.add(trade_name);			//trade_id
								batch_record.add(dflt_bin);//bin_locn_code
								batch_record.add(getItemCost(disp_drug_code,store_code,btch_qty,end_date_Time,connection,cstmt));	//item_cost
																	
								index = 1;

								pstmt_insert1.setString(index  , (String)tabData.get("login_facility_id") );// FACILITY_ID
								pstmt_insert1.setString(++index,disp_locn_code);							// DISP_LOCN_CODE
								pstmt_insert1.setString(++index,order_id);			// ORDER_ID
								pstmt_insert1.setString(++index,order_line_no);		// ORDER_LINE_NUM
								pstmt_insert1.setString(++index,disp_drug_code);	// ITEM_CODE
								pstmt_insert1.setString(++index,btch_id);			// BATCH_ID
								pstmt_insert1.setString(++index,exp_date);		// EXPIRY_DATE
								pstmt_insert1.setString(++index,store_code);								// STORE_CODE
								pstmt_insert1.setString(++index,disp_qty);							// DISP_QTY
								pstmt_insert1.setString(++index,disp_qty_uom);		    // DISP_QTY_UOM
								pstmt_insert1.setString(++index,disp_drug_code);									// DRUG_CODE
								pstmt_insert1.setString(++index,(String)tabData.get("user_id"));			// ADDED_BY_ID
								pstmt_insert1.setString(++index,(String)tabData.get("login_at_ws_no"));		// ADDED_AT_WS_NO
								pstmt_insert1.setString(++index,(String)tabData.get("login_facility_id"));	// ADDED_FACILITY_ID
								pstmt_insert1.setString(++index,(String)tabData.get("user_id"));			// MODIFIED_BY_ID
								pstmt_insert1.setString(++index,(String)tabData.get("login_at_ws_no"));		// MODIFIED_AT_WS_NO
								pstmt_insert1.setString(++index,(String)tabData.get("login_facility_id"));	// MODIFIED_FACILITY_ID
								pstmt_insert1.setString(++index,doc+"");	// DOC_SRL_NO
								pstmt_insert1.setString(++index,dflt_bin);// BIN_LOCATION_CODE
								pstmt_insert1.setString(++index,trade_name);// TRADE_ID
						//pstmt_insert1.addBatch();
								int pstmt_insert1_value=pstmt_insert1.executeUpdate();
								System.err.println("pstmt_insert1_value------->"+pstmt_insert1_value);

								doc++;		
						
								dispTMP.add(batch_record);
								dispTMP.add(patient_id);
								dispTMP.add(encounter_id);
				
								updateStock_id=callStockUpdate(connection,tabData,sqlMap,dispTMP,new HashMap(),st_doc_type,stock_srl,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id,  ord_pract_id); // ,  ord_pract_id added for SRR20056-SCF-7373
								
								if((updateStock_id.equals("")) || (!updateStock_id.equals("RECORD_MODIFIED")))
									throw new Exception("callStockUpdate failed");

								//}

							} //end f_disp_qty
						} //  end available_stock 
					}//before avallable stock
						
					}
					catch (Exception exp1)
					{
						System.err.println("Disp Drug batch fail  --- "+exp1.toString());
						exp1.printStackTrace();
						errMsg.append("\nUnsuccessfull process on \n Order ID: "+order_id);
						errMsg.append(" Patient ID: "+patient_id);
						errMsg.append(" Ord Drug code: "+order_catalog_code);
						errMsg.append(" Disp Drug code: "+disp_drug_code);
						errMsg.append(" Disp Drug Desc: "+disp_drug_desc);
						errMsg.append(" Error Msg: "+exp1.getMessage());
						connection.rollback();
						continue;
					}
				}
					try
					{
						if(!all_sources.contains(source_code)) {
							all_sources.add(source_code);
						}
						connection.commit();	
					}
					catch (Exception exp2)
					{
						System.err.println("Error while commiting the transaction");
						exp2.printStackTrace();
					}
					
			      }//end if
			   }
			}
			System.err.println("updateStock_id---598--->"+updateStock_id);
			
			//if(is_success) {
				//if((!updateStock_id.equals(""))&&(updateStock_id.equals("RECORD_MODIFIED"))){
				System.err.println("all_sources------>"+all_sources);
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

				/*	System.err.println("login_facility_id=====>"+(String)tabData.get("login_facility_id"));
					System.err.println("fill_proc_id=====>"+fill_proc_id);
					System.err.println("fill_int_start_date_time=====>"+fill_int_start_date_time);
					System.err.println("user_id=====>"+(String)tabData.get("user_id"));
					System.err.println("login_at_ws_no=====>"+(String)tabData.get("login_at_ws_no"));
					System.err.println("login_facility_id=====>"+(String)tabData.get("login_facility_id"));*/
					

					int pstmt_insert_fill_value=pstmt_insert_fill_int_dtl.executeUpdate();
					System.err.println("pstmt_insert_fill_value=====>"+pstmt_insert_fill_value);
				}
				closeStatement( pstmt_insert_fill_int_dtl );
				pstmt_update = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL);
				pstmt_update.setString(1,fill_int_start_date_time);
				pstmt_update.setString(2,(String)tabData.get("user_id"));
				pstmt_update.setString(3,(String)tabData.get("login_facility_id"));
				pstmt_update.setString(4,(String)tabData.get("login_at_ws_no"));
				pstmt_update.setString(5,fill_proc_id);
				int pstmt_update_value=pstmt_update.executeUpdate();
			
				System.err.println("pstmt_update_value=====>"+pstmt_update_value);
				is_success = true;
				closeStatement( pstmt_update ) ;
				pstmt_update=null;
				try
				{
					connection.commit();
				}
				catch (Exception exp3)
				{
					exp3.printStackTrace();
					System.err.println("Error while committing all sources");
				}
			 //   }//end if
		     //} //end if
		  // }
		 
		}catch ( Exception e ) {
			try{
			connection.rollback();
			}catch(Exception es) {
				es.printStackTrace();
			}
			is_success = false;
			e.printStackTrace() ;
			//throw new EJBException("Operation Failed.........in mainIPFillProcess method...");
		}finally {
			try {
/*				closeResultSet( resultSet ) ;*/
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

				pstmt_update		=null;
				pstmt_update1		=null;
				pstmt_insert_fill_int_dtl =null;
				pstmt_insert1		=null;
//				resultSet			=null;
//				resultSet1			=null;
//				resultSet2			=null;
				
			}catch(Exception es) { es.printStackTrace(); }
		}
		/*
		 if(!is_success) {
				updateStock_id="RECORD_NOT_INSERTED_FILL" ;
				System.err.println("updateStock_id----699---->"+updateStock_id);
				return updateStock_id;
		}
		*/
		return errMsg;
	}

	
	// Allocating the batches
	private void allocateBatches(String fill_proc_id,HashMap sqlMap,HashMap tabData,Connection connection)throws Exception{
		
		String SQL_PH_IP_FILL_PROCESS_SELECT6 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT6");
		String SQL_PH_IP_FILL_PROCESS_SELECT7 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT7");
		String SQL_PH_IP_FILL_PROCESS_SELECT8 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT8");
		String SQL_PH_IP_FILL_PROCESS_SELECT33= (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT33");
		String SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE		= (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE");
		String SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER			= (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER");
		PreparedStatement pstmt						= null ;
		PreparedStatement pstmt1					= null,pstmt2= null ;
		PreparedStatement pstmt_insert1				= null ;
		PreparedStatement pstmt_order_update		= null ;
		PreparedStatement pstmt_order_line_update	= null ;
		CallableStatement cstmt						= null ;
		ResultSet resultSet       = null ;
		ResultSet resultSet1      = null ;
		ResultSet resultSet2      = null ;
		String store_code		  = "";
		String disp_locn_code	  = "";
		String disp_drug_code     = "";
		String item_code	      = "";
		String disp_qty		      = "";
		String end_date_time      = "";
		String available_stock	  = "";
		float  f_alloc_qty		  = 0f;
		float  f_total_qty		  = 0f;
		int index				  = 1;
		try {
			dispTMP = new ArrayList(); // This ArrayList will be used for Stock Updation...
			
			pstmt1  = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT8) ;
			pstmt1.setString(1,fill_proc_id);
			resultSet1 = pstmt1.executeQuery() ;
			if (resultSet1.next()) {
				store_code		= resultSet1.getString("STORE_CODE");
				disp_locn_code  = resultSet1.getString("DISP_LOCN_CODE");
			}
			closeStatement( pstmt1 ) ;
			closeResultSet( resultSet1 ) ;
			tabData.put("store_code",store_code);
			pstmt1	  = null;
			resultSet1= null;
		
			pstmt                   = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT33);
			pstmt2	                = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT7) ;
			pstmt_insert1			= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP) ;
			pstmt_order_line_update = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE) ;
			pstmt_order_update		= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER) ;

           
			pstmt1	  = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT6) ;
			pstmt1.setString(1,fill_proc_id);
			resultSet1= pstmt1.executeQuery() ;
			while (resultSet1.next()) {

			    disp_drug_code  = resultSet1.getString("DISP_DRUG_CODE");
				disp_qty		= resultSet1.getString("DISP_QTY");
				end_date_time	= resultSet1.getString("END_DATE_TIME");
				/*	Find out whether there is enough stock to satisfy the disp qty
					Calling Stock procedure
				 */
				

				item_code = disp_drug_code;
				//pstmt = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT33);
				pstmt.setString( 1, item_code);
				pstmt.setString( 2, store_code);
				pstmt.setString( 3, disp_qty);
				pstmt.setString( 4, "Y");
				pstmt.setString( 5, end_date_time);
				pstmt.setString( 6, "N");
				pstmt.setString( 7, "");	   
				resultSet = pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next()){
					available_stock = resultSet.getString("AVAIL_STOCK");

					f_alloc_qty		  = 0f;  
					f_total_qty		  = 0f;  
					if(available_stock!=null && !available_stock.equals("")){
						float f_available_stock = Float.parseFloat(available_stock);
						float f_disp_qty		= Float.parseFloat(disp_qty);

						if(f_available_stock>0 && (f_available_stock >=f_disp_qty) && f_disp_qty>0){
							//pstmt1	  = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT7) ;
							pstmt2.setString(1,item_code);
							pstmt2.setString(2,store_code);
							pstmt2.setString(3,end_date_time);
							resultSet2 = pstmt2.executeQuery();
							float f_qty = 0;

							/*pstmt_insert1			= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP) ;
							pstmt_order_line_update = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE) ;
							pstmt_order_update		= connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER) ;*/

							ArrayList batch_record  = null;
							dispTMP.add(resultSet1.getString("ORDER_ID"));				// order_id
							dispTMP.add(resultSet1.getString("ORDER_LINE_NO"));			// order_line_no
							dispTMP.add(resultSet1.getString("DISP_DRUG_CODE"));		// pres_drug_code
							dispTMP.add(resultSet1.getString("DISP_DRUG_CODE"));		// disp_drug_code
							dispTMP.add(new Float(disp_qty).intValue()+"");				// disp_qty
							dispTMP.add(resultSet1.getString("ORDER_UOM"));				// disp_uom_code
							batch_record  = new ArrayList();
							int doc=1;
//							boolean is_entered_in_while = false;
							while(resultSet2.next()){
								//is_entered_in_while = true;
								f_qty = resultSet2.getFloat("QTY");
								if((f_disp_qty-f_total_qty)>f_qty){
									f_alloc_qty = f_qty;
								}else{
									f_alloc_qty = f_disp_qty-f_total_qty;
								}
								if(f_alloc_qty>0){								
									
									batch_record.add(resultSet1.getString("DISP_DRUG_CODE"));	//item_drug_code
									batch_record.add(resultSet2.getString("BATCH_ID"));			//batch_id
									batch_record.add(resultSet2.getString("EXPIRY_DATE_OR_RECEIPT_DATE"));	//expiry_date
									batch_record.add(new Float(f_alloc_qty).intValue()+"");							//issue_qty
									batch_record.add(resultSet1.getString("ORDER_UOM"));		//qty_uom
									batch_record.add("");										//item_drug_color
									batch_record.add(resultSet2.getString("TRADE_ID"));			//trade_id
									batch_record.add(resultSet2.getString("BIN_LOCATION_CODE"));//bin_locn_code
									batch_record.add(getItemCost(item_code,store_code,new Float(f_alloc_qty).intValue()+"",end_date_time,connection,cstmt));	//item_cost
																		
									index = 1;
									pstmt_insert1.setString(index  , (String)tabData.get("login_facility_id") );// FACILITY_ID
									pstmt_insert1.setString(++index,disp_locn_code);							// DISP_LOCN_CODE
									pstmt_insert1.setString(++index,resultSet1.getString("ORDER_ID"));			// ORDER_ID
									pstmt_insert1.setString(++index,resultSet1.getString("ORDER_LINE_NO"));		// ORDER_LINE_NUM
									pstmt_insert1.setString(++index,resultSet1.getString("DISP_DRUG_CODE"));	// ITEM_CODE
									pstmt_insert1.setString(++index,resultSet2.getString("BATCH_ID"));			// BATCH_ID
									pstmt_insert1.setString(++index,resultSet2.getString("EXPIRY_DATE_OR_RECEIPT_DATE"));		// EXPIRY_DATE
									pstmt_insert1.setString(++index,store_code);								// STORE_CODE
									pstmt_insert1.setString(++index,f_alloc_qty+"");							// DISP_QTY
									pstmt_insert1.setString(++index,resultSet1.getString("ORDER_UOM"));		    // DISP_QTY_UOM
									pstmt_insert1.setString(++index,item_code);									// DRUG_CODE
									pstmt_insert1.setString(++index,(String)tabData.get("user_id"));			// ADDED_BY_ID
									pstmt_insert1.setString(++index,(String)tabData.get("login_at_ws_no"));		// ADDED_AT_WS_NO
									pstmt_insert1.setString(++index,(String)tabData.get("login_facility_id"));	// ADDED_FACILITY_ID
									pstmt_insert1.setString(++index,(String)tabData.get("user_id"));			// MODIFIED_BY_ID
									pstmt_insert1.setString(++index,(String)tabData.get("login_at_ws_no"));		// MODIFIED_AT_WS_NO
									pstmt_insert1.setString(++index,(String)tabData.get("login_facility_id"));	// MODIFIED_FACILITY_ID
									pstmt_insert1.setString(++index,doc+"");	// DOC_SRL_NO
									pstmt_insert1.setString(++index,resultSet2.getString("BIN_LOCATION_CODE"));// BIN_LOCATION_CODE
									pstmt_insert1.setString(++index,resultSet2.getString("TRADE_ID"));// TRADE_ID
									f_total_qty +=f_alloc_qty;	
									pstmt_insert1.addBatch();
									doc++;
									if(f_disp_qty == f_total_qty){
										break;
									}
								}else{
									f_total_qty =0;	
								}
							}
							
				closeResultSet( resultSet2 ) ;
				resultSet2=null;

							dispTMP.add(batch_record);
							dispTMP.add(resultSet1.getString("PATIENT_ID"));
							dispTMP.add(resultSet1.getString("ENCOUNTER_ID"));
							// For stock updation ends here
								

							if(f_total_qty >= f_disp_qty){
								pstmt_order_line_update.setString(1,(String)tabData.get("user_id"));			// MODIFIED_BY_ID
								pstmt_order_line_update.setString(2,(String)tabData.get("login_facility_id"));	// MODIFIED_FACILITY_ID
								pstmt_order_line_update.setString(3,(String)tabData.get("login_at_ws_no"));		// MODIFIED_AT_WS_NO
								pstmt_order_line_update.setString(4,resultSet1.getString("ORDER_ID"));			// ORDER_ID
								pstmt_order_line_update.setString(5,resultSet1.getString("ORDER_LINE_NO"));		// ORDER_LINE_NUM
								pstmt_order_line_update.executeUpdate();

								pstmt_order_update.setString(1,(String)tabData.get("user_id"));				// MODIFIED_BY_ID
								pstmt_order_update.setString(2,(String)tabData.get("login_facility_id"));	// MODIFIED_FACILITY_ID
								pstmt_order_update.setString(3,(String)tabData.get("login_at_ws_no"));		// MODIFIED_AT_WS_NO
								pstmt_order_update.setString(4,resultSet1.getString("ORDER_ID"));			// ORDER_ID
								pstmt_order_update.executeUpdate();
							}
							int result1[]=pstmt_insert1.executeBatch();		
							for (int i=0;i<result1.length ;i++ ){
								// A number greater than or equal to zero  indicates success
								// A number -2 indicates that command is successful but number of rows updated is unknow
								// If it won't satisfy any of the above cancel the statement and throw an exception
								if(result1[i]<0  && result1[i] != -2 ){
									pstmt_insert1.cancel();
									connection.rollback();
									throw new EJBException("Operation Failed.........while INSERTing into DISP_DRUG_BATCH_TMP table");
								}
							}	
						}
					}
				}		
				closeResultSet( resultSet ) ;
				resultSet=null;
			}
		}catch(Exception e){
			e.printStackTrace();
			connection.rollback();
			throw new EJBException("Operation Failed.........while allocating the batches");
		}finally{
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_order_update	); 
				closeStatement( pstmt_order_line_update );
				resultSet	=null;
				resultSet1	=null;
				resultSet2	=null;
				pstmt		=null;
				pstmt1		=null;
				pstmt2		=null;
				pstmt_insert1			=null;
				pstmt_order_update		=null;
				pstmt_order_line_update =null;
			}catch(Exception es) { es.printStackTrace(); }
		}
	}
	// Insert into PH_DISP_HDR_TMP, PH_DISP_DTL_TMP tables and update OR_ORDER_LINE_PH
	private boolean insertTMPTables(HashMap reqData,HashMap sqlMap,HashMap tabData,Connection connection,String store_code,String end_date_time,ArrayList pstmt_stmnts)throws Exception{
		System.err.println("insertTMPTables------calling----->");
		String disp_tmp_no     = (String)reqData.get("disp_tmp_no");
		String order_id		   = (String)reqData.get("order_id");
		String order_line_no   = (String)reqData.get("order_line_no");
		String ord_facility_id = (String)reqData.get("ord_facility_id");
		String order_catalog_code = (String)reqData.get("order_catalog_code");
		String disp_drug_code  = (String)reqData.get("disp_drug_code");
		//System.err.println("disp_drug_code------------->"+disp_drug_code);
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

		String SQL_PH_IP_FILL_PROCESS_SELECT38		 = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_SELECT38");
		
		PreparedStatement pstmt				   = null ;
		PreparedStatement pstmt_insert_hdr_tmp = null ;
		PreparedStatement pstmt_insert_dtl_tmp = null ;
		PreparedStatement pstmt_update		   = null ;
		ResultSet resultSet				       = null ;
		int count						       = 0;
		int int_disp_tmp_no				       = 0;

		try {
			/*	Find out whether there is enough stock to satisfy the disp qty
				Calling Stock procedure
			*/
            int rec_count=0;
			
			pstmt = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT38);
			//pstmt = connection.prepareStatement("select count(*) cnt from st_item_store where STORE_CODE=? and ITEM_CODE=? ");
			//pstmt = (PreparedStatement)pstmt_stmnts.get(0); 
			pstmt.setString( 1,store_code ); 
			if ( disp_drug_code == null || disp_drug_code.equals(" ") )
			{
			pstmt.setString( 2,order_catalog_code );
			}else if ( disp_drug_code != null || !disp_drug_code.equals(" ") )
			{
			  pstmt.setString( 2,disp_drug_code );
			}

			System.err.println("store_code---991---->"+store_code);
			System.err.println("order_catalog_code---992---->"+order_catalog_code);
			System.err.println("disp_drug_code----993--->"+disp_drug_code);

			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null && resultSet.next()){
				rec_count = resultSet.getInt("cnt");
			}
			 System.err.println("rec_count--------->"+rec_count);
			closeResultSet( resultSet ) ;
			//closeStatement( pstmt ) ;
			pstmt=null;
			resultSet=null;
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
					pstmt=null;
				   resultSet=null;
				}else if(count==0){
					closeResultSet( resultSet ) ;
					
					pstmt=null;
				    resultSet=null;
			//		pstmt     = connection.prepareStatement( SQL_PH_IP_FILL_PROCESS_SELECT11) ;
					pstmt     = (PreparedStatement)pstmt_stmnts.get(3);
					resultSet = pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()){
						int_disp_tmp_no = resultSet.getInt("TMP_DISP_NO");
				}

				closeResultSet( resultSet ) ;
				//closeStatement( pstmt ) ;
				pstmt=null;
				resultSet=null;
				
				pstmt_insert_hdr_tmp = connection.prepareStatement("INSERT INTO PH_DISP_HDR_TMP (DISP_TMP_NO, FACILITY_ID, DISP_LOCN_CODE,ORDER_ID, RECORD_DATE_TIME, FILL_PROC_ID,ORDERING_FACILITY_ID, ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, DISPENSED_DATE_TIME,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,?,SYSDATE,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?)") ;
					//pstmt_insert_hdr_tmp = (PreparedStatement)pstmt_stmnts.get(5);
					int index = 1;

					seq_no.put(order_id,int_disp_tmp_no+"");
					
					tabData.put("seq_no",seq_no);
		
					pstmt_insert_hdr_tmp.setString(index  ,int_disp_tmp_no+"");	// DISP_TMP_NO
					pstmt_insert_hdr_tmp.setString(++index,(String)tabData.get("login_facility_id"));			// FACILITY_ID
					pstmt_insert_hdr_tmp.setString(++index,disp_locn_code);		// DISP_LOCN_CODE
					pstmt_insert_hdr_tmp.setString(++index,order_id);			// ORDER_ID
					pstmt_insert_hdr_tmp.setString(++index,fill_proc_id);		// FILL_PROC_ID
					pstmt_insert_hdr_tmp.setString(++index,ord_facility_id);	// ORDERING_FACILITY_ID
					pstmt_insert_hdr_tmp.setString(++index,ord_date_time);			// ORD_DATE_TIME
					pstmt_insert_hdr_tmp.setString(++index,patient_id);			// PATIENT_ID
					pstmt_insert_hdr_tmp.setString(++index,encounter_id);		// ENCOUNTER_ID
					pstmt_insert_hdr_tmp.setString(++index,patient_class);		// PATIENT_CLASS				
					pstmt_insert_hdr_tmp.setString(++index,source_type);		// LOCN_TYPE
					pstmt_insert_hdr_tmp.setString(++index,source_code);		// LOCN_CODE
					pstmt_insert_hdr_tmp.setString(++index,"");					// ROOM_TYPE
					pstmt_insert_hdr_tmp.setString(++index,room_num);	// ROOM_NO
					pstmt_insert_hdr_tmp.setString(++index,bed_num);		// BED_NO
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
					int pstmt_insert_hdr_tmp_rows  =pstmt_insert_hdr_tmp.executeUpdate();
					if(pstmt_insert_hdr_tmp_rows>0){
						is_success=true;
					}
					else{
					   is_success=false;
					   return is_success; 
					}

					System.err.println("pstmt_insert_hdr_tmp_rows------>"+pstmt_insert_hdr_tmp_rows);
				}
				String dtl_serial_num = "";
              
			//	pstmt = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_SELECT13);
				pstmt = (PreparedStatement)pstmt_stmnts.get(6);
				pstmt.setString(1,int_disp_tmp_no+"");		// DISP_TMP_NO
				pstmt.setString(2,disp_drug_code);			// DISP_DRUG_CODE
				resultSet = pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					dtl_serial_num = resultSet.getString("DTL_SERIAL_NUM");

					System.err.println("dtl_serial_num------>"+dtl_serial_num);
				}
				closeResultSet( resultSet ) ;
				pstmt=null;
				resultSet=null;
			//	pstmt_update = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP);
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
				
				System.err.println("updated_rows------>"+updated_rows);
					
				System.err.println("req_qty_value---->"+req_qty_value);
				System.err.println("order_id---->"+order_id);
				System.err.println("order_line_no---->"+order_line_no);
				 System.err.println("int_disp_tmp_no---->"+int_disp_tmp_no);
				
				pstmt_update=null;

				if(updated_rows==0){
					if(!stock_srl.containsKey( order_id + disp_drug_code)) {
						stock_srl.put(order_id + disp_drug_code,dtl_serial_num+"");
					}
				//	pstmt_insert_dtl_tmp = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP);
					pstmt_insert_dtl_tmp = (PreparedStatement)pstmt_stmnts.get(8);
					int index = 1;
					if(disp_drug_code.equals(" ")){disp_drug_code=order_catalog_code;}
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
					pstmt_insert_dtl_tmp.setString(++index,dtl_serial_num);							 // DOC_SRL_NO
					int pstmt_insert_dtl_tmp_rows=pstmt_insert_dtl_tmp.executeUpdate();
					System.err.println("pstmt_insert_dtl_tmp_rows------>"+pstmt_insert_dtl_tmp_rows);
					//closeStatement( pstmt_insert_dtl_tmp ) ;
					 if(pstmt_insert_dtl_tmp_rows>0){
						is_success=true;
					 }
				     else{
						 is_success=false;
					     System.err.println("line number:::::1128");
						 return is_success; 
					 }
					
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
				//closeStatement( pstmt ) ;
				pstmt=null;
				resultSet=null;
			  			
			    pstmt	                      = null;
				resultSet                     = null;

				
				pstmt	                      = null;
				resultSet                     = null;

			//	pstmt	   = connection.prepareStatement(stmt2);				
				pstmt	   = (PreparedStatement)pstmt_stmnts.get(11);
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				resultSet = pstmt.executeQuery();
				int total=0;
                 
                if(resultSet!=null && resultSet.next()){
					total  =  resultSet.getInt("TOT");
					
				   //System.err.println("total------->"+total);
					
				}
				
				closeResultSet( resultSet ) ;
				//closeStatement( pstmt ) ;


              /*=====================================================*/
			   
				int no_of_days                = 0;
				String fract_dose_round_up_yn = "N";
				pstmt	                      = null;
				resultSet                     = null;

			//	pstmt	   = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS);
				pstmt	   = (PreparedStatement)pstmt_stmnts.get(12);
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_no);
				pstmt.setString(3,disp_drug_code);
				resultSet = pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()){
					fract_dose_round_up_yn = resultSet.getString("FRACT_DOSE_ROUND_UP_YN");
					if(fract_dose_round_up_yn!=null && fract_dose_round_up_yn.equals("N")){
						no_of_days  =  resultSet.getInt("NO_OF_DAYS");
					}
				}
				

				//System.err.println("fract_dose_round_up_yn------>"+fract_dose_round_up_yn);
				System.err.println("no_of_days----------->"+no_of_days);
				closeResultSet( resultSet ) ;
			
			//	pstmt_update	   = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH);
				pstmt_update	   = (PreparedStatement)pstmt_stmnts.get(13);

				pstmt_update.setString(1,fill_proc_id);
				pstmt_update.setString(2,req_qty_value);
				pstmt_update.setString(3,req_qty_unit);
				pstmt_update.setString(4,disp_tmp_no);
				if(fract_dose_round_up_yn!=null && fract_dose_round_up_yn.equals("Y")){
					pstmt_update.setString(5,fill_int_end_date_time);
				}else{
					pstmt_update.setString(5,fill_int_end_date_time);
					no_of_days	=	0;
				}
				pstmt_update.setString(6,no_of_days+"");
				pstmt_update.setString(7,(String)tabData.get("user_id"));			 // MODIFIED_BY_ID
				pstmt_update.setString(8,(String)tabData.get("login_facility_id")); // MODIFIED_FACILITY_ID
				pstmt_update.setString(9,(String)tabData.get("login_at_ws_no"));	 // MODIFIED_AT_WS_NO
				pstmt_update.setString(10,order_id);			// order_id
				pstmt_update.setString(11,order_line_no);		// order_line_no				
				
				
				System.err.println("fill_proc_id---->"+fill_proc_id);
				System.err.println("req_qty_value---->"+req_qty_value);
				System.err.println("req_qty_unit---->"+req_qty_unit);
				System.err.println("disp_tmp_no---->"+disp_tmp_no);
				System.err.println("fill_int_end_date_time---->"+fill_int_end_date_time);
				System.err.println("no_of_days---->"+no_of_days);
				System.err.println("order_id---->"+order_id);
				System.err.println("order_line_no---->"+order_line_no);
				System.err.println("user_id---->"+(String)tabData.get("user_id"));
				System.err.println("login_facility_id---->"+(String)tabData.get("login_facility_id"));
				System.err.println("login_at_ws_no---->"+(String)tabData.get("login_at_ws_no"));
				
				int pstmt_update_row=pstmt_update.executeUpdate();
				//closeStatement( pstmt_update ) ;
				System.err.println("pstmt_update_row------->"+pstmt_update_row);
				if(pstmt_update_row>0){
					is_success=true;
				}
				else{
					is_success=false;
				}
				 pstmt_update=null;
				}
			
		}catch(Exception e){
			e.printStackTrace();
			is_success=false;
			//connection.rollback();
			System.err.println("while inserting into TMP Tables"+e.getMessage());
			//throw new EJBException("Operation Failed.........while inserting into TMP Tables");
		}finally{
			try {
				resultSet =null;
				pstmt =null;
				pstmt_update =null;
				pstmt_insert_hdr_tmp =null;
				pstmt_insert_dtl_tmp =null;
			}catch(Exception es) { es.printStackTrace(); }
		}
		System.err.println("is_success---->"+is_success);
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
		
		System.err.println("order_status_code--1325--->"+order_status_code);
		System.err.println("order_status_type--1326--->"+order_status_type);
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
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw new EJBException("Operation Failed.........while comparing the dates");
		}finally {
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
			}else {
				pstmt_st_doc_type.setString(1,"DIOP");
			}
			pstmt_st_doc_type.setString(2,facility_id);
			pstmt_st_doc_type.setString(3,facility_id);

			resSet				= pstmt_st_doc_type.executeQuery() ;
			if(resSet.next()) {
				st_doc_type	=	(String)resSet.getString("ST_DOC_TYPE_CODE");
			}
		}catch(Exception e){
				System.err.println(e);
				e.printStackTrace();
		}finally{	
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
		}catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;
		}
		
		return item_cost;
	}

	
	private String callStockUpdate(Connection connection,HashMap tabData,HashMap sqlMap,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type,HashMap stock_srl,PreparedStatement pstmt_update_disp_hdr_tmp,PreparedStatement pstmt_update_med_hdr,String ordering_facility_id, String ord_pract_id){ // , String ord_pract_id added for SRR20056-SCF-7373
		 String updateStock_id="";
		try {
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
			ArrayList orders	=	new ArrayList();
			HashMap stock_dtls	=	new HashMap();
			ArrayList insertDetail	=	new ArrayList();
			ArrayList insertExp		=	new ArrayList();
			ArrayList updateDetail	=	new ArrayList();
			ArrayList updateExp		=	new ArrayList();
//System.out.println("dispTMP ---|"+dispTMP+"|---");
          
			for(int i=0;i<dispTMP.size();i=i+9){


				tabData.put("patient_id",dispTMP.get(i+7));				
				tabData.put("encounter_id",dispTMP.get(i+8));


				if(orders.size()!=0 && (!orders.contains(((String)dispTMP.get(i)).trim()))) {
					stock_dtls.put("insertDetail",insertDetail);
					stock_dtls.put("updateDetail",updateDetail);
					stock_dtls.put("insertExp",insertExp);
					stock_dtls.put("updateExp",updateExp);

			updateStock_id=updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type,pstmt_update_disp_hdr_tmp,pstmt_update_med_hdr,ordering_facility_id);
				
				System.err.println("updateStock_id----1467--->"+updateStock_id);
					
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

				if(item_cost.equals("")) item_cost	=	"0";

				//cost_value	=(Integer.parseInt((String)dispTMP.get(i+4)) * Math.abs(Float.parseFloat(item_cost)))+"";
				cost_value	=	Math.round(Integer.parseInt((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";

				cost_value	= (Double.parseDouble(cost_value)/1000)+"";

				// Item Detail
				HashMap hmDetail	=	new HashMap();
				hmDetail.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim()));
				hmDetail.put("item_code",item_code);
				hmDetail.put("sal_category","");
				hmDetail.put("hcp_issue_factor","");
				hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
				hmDetail.put("item_sal_value",cost_value);
				hmDetail.put("next_due_date","");
				hmDetail.put("stock_item_yn","Y");
				hmDetail.put("remarks","");
				hmDetail.put("item_unit_cost",item_cost);
				hmDetail.put("item_cost_value",cost_value);
				hmDetail.put("item_unit_price",item_cost);
				hmDetail.put("uom_code",((String)dispTMP.get(i+5)).trim());
				hmDetail.put("mode",(String)tabData.get("mode"));
				hmDetail.put("p_ord_practitioner_id",ord_pract_id); // added for SRR20056-SCF-7373
System.err.println("@@@1600p_ord_practitioner_id="+hmDetail.get("p_ord_practitioner_id")+" ord_pract_id="+ord_pract_id);

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
					hmExp.put("sal_item_qty",disp_qty);
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
			System.err.println("updateStock_id----1555--->"+updateStock_id);
		} catch(Exception e) {
			System.err.println("error while updating stock"+e);
			e.printStackTrace();
			
		}
		return updateStock_id; 
	}

	private String updateStock(Connection connection,HashMap tabData, HashMap sqlMap, HashMap stock_dtls,String order_id, String prev_doc_no,String  st_doc_type,PreparedStatement pstmt_update_disp_hdr_tmp,PreparedStatement pstmt_update_med_hdr,String ordering_facility_id) {
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
		String updateStock_id="";

		 System.err.println("bl_interface_yn-------->"+bl_interface_yn);

		//PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		hmHeader.put("facility_id",(String)tabData.get("facility_id"));
		hmHeader.put("doc_type_code",st_doc_type);
		hmHeader.put("doc_no","");
		hmHeader.put("doc_date",(String)tabData.get("today"));
		hmHeader.put("doc_ref","");
		hmHeader.put("store_code",(String)tabData.get("store_code"));
		
		if(((String)tabData.get("DispBillingStage")).equals("A")){
		     hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));
	   }else{
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

        String sal_trn_type = getEncounterPatientClass(connection,sqlMap,(String)tabData.get("encounter_id"),ordering_facility_id, (String)tabData.get("patient_id")); //added patient_id for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription

		hmHeader.put("sal_trn_type",sal_trn_type);
		hmHeader.put("remarks","");
		hmHeader.put("item_class_code","");
		hmHeader.put("module_id","PH");

		hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
		hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
		hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));

		language_data.add((String)tabData.get("LanguageId"));

		hmData.put("HDR_DATA",hmHeader);
		hmData.put("COMMON_DATA",hmCommon);
		hmData.put("LANGUAGE_DATA",language_data);

		try{
			if(insertDetail.size()!=0) {
				hmData.put("DTL_DATA",insertDetail);
				hmData.put("DTL_EXP_DATA",insertExp);
		System.err.println("hmData----1720----stSales.insertSales--hmData----->"+hmData);
				eST.Common.StSales	stSales		=	new eST.Common.StSales();
				HashMap map							=	stSales.insertSales(connection,hmData);

				System.err.println("map-----ejb------>"+map);
				 updateStock_id=(String)map.get( "msgid" );
				if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					connection.rollback();
					throw new EJBException("insert Sales failed");
				}else {
					String docno				=	(String)map.get("doc_no");
					String doctypecode			=	(String)map.get("doc_type_code");
					//pstmt_update_disp_hdr_tmp		=	null;
					//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
					pstmt_update_disp_hdr_tmp.setString(1,doctypecode );
					pstmt_update_disp_hdr_tmp.setString(2,docno);  
					pstmt_update_disp_hdr_tmp.setString(3,order_id);
					pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
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
		System.err.println("hmData----1760----stSales.updateSales--hmData----->"+hmData);
				
				eST.Common.StSales	stSales	=	new eST.Common.StSales();
				HashMap map					=	stSales.updateSales(connection,hmData);
				 updateStock_id=(String)map.get( "msgid" );
				//System.err.println("map-----uadateDetails------>"+map);
			   if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					connection.rollback();
					throw new EJBException("update Sales failed");
				} else {
					//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
					pstmt_update_disp_hdr_tmp.setString(1,st_doc_type);
					pstmt_update_disp_hdr_tmp.setString(2,prev_doc_no);
					pstmt_update_disp_hdr_tmp.setString(3,order_id);
					pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
					pstmt_update_disp_hdr_tmp.executeUpdate();					
					//closeStatement(pstmt_update_disp_hdr_tmp);
				}
			}
		}catch(Exception e) {	
			System.err.println("Exception at 1664"+e);
			e.printStackTrace();
			

		}
		return updateStock_id;
	}

	public String getEncounterPatientClass(Connection connection,HashMap sqlMap,String encounter_id,String facility_id, String patient_id ){//added patient_id for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
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
}
