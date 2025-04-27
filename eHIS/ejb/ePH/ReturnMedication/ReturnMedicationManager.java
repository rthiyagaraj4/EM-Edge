/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
26/10/2021      TFS-24317        Prabha         GHL-CRF-0627
---------------------------------------------------------------------------------------------------------------
*/
package ePH.ReturnMedication ;

import java.rmi.* ;
import java.util.* ;
//import java.util.ArrayList;
//import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="ReturnMedication"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReturnMedication"
*	local-jndi-name="ReturnMedication"
*	impl-class-name="ePH.ReturnMedication.ReturnMedicationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.ReturnMedication.ReturnMedicationLocal"
*	remote-class="ePH.ReturnMedication.ReturnMedicationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.ReturnMedication.ReturnMedicationLocalHome"
*	remote-class="ePH.ReturnMedication.ReturnMedicationHome"
*	generate= "local,remote"
*
*
*/ 
public class ReturnMedicationManager extends PhEJBSessionAdapter {

//	Properties prop=null;
	// insert method starts here
	// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
//  modify method starts here
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		ArrayList bl_details             =  new ArrayList();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;
		String 	errod_id="", message="";
		Connection connection	= null ;
		PreparedStatement pstmt_update1		= null ;
		PreparedStatement pstmt_update2		= null;
		PreparedStatement pstmt_update3		= null;
		PreparedStatement pstmt_update4		= null;
		PreparedStatement pstmt_insert1		= null;
		PreparedStatement pstmt_insert2		= null;
		PreparedStatement pstmt_select1		= null;
		PreparedStatement pstmt_select2		= null;
		PreparedStatement pstmt_select3		= null;		//Added for GHL-SCF-790 [IN:046481]
		PreparedStatement pstmt_select_balQty	= null;
		PreparedStatement pstmt_update1_lock	= null;  // Added for SKR-SCF-0393 [IN:030939] 
		PreparedStatement pstmt_update4_lock	= null;  // Added for SKR-SCF-0393 [IN:030939]
		ResultSet rset						= null;
		ResultSet rset1						= null;
		ArrayList language_data             =  new ArrayList();

		String totalrows		=	(String)tabData.get("TOTALROWS");
		//String totalrows1		=	(String)tabData.get("TOTALROWS1");
		String login_by_id		=	(String)tabData.get("login_by_id");
		String login_at_ws_no	=	(String)tabData.get("login_at_ws_no");
		String languageid   	=	(String)tabData.get("LANGUAGEID");
		String patient_class	=	(String)tabData.get("PATIENT_CLASS");
		String disp_cash_coll_stage	=	(String)tabData.get("DISP_CASH_COLL_STAGE");
		ArrayList stock_vals	=	(ArrayList)tabData.get("STOCK_VALS"); //moved up from down stock update part for AMRI-SCF-0376 [IN:055578]
		String token_no			=   "";		
		int rtn_medn_no			= 1;
		String rej_qty_val = (String)tabData.get("Rej_Qty_Value");	//Added for GHL-SCF-790 [IN:046481]
		int bal_qty=0;	//Added for GHL-SCF-790 [IN:046481]

		int rows=Integer.parseInt(totalrows);
		if(tabData.get("BARCODE_FLAG").equals("Y")) // Added for GHL-CRF-0413.8
			rows = (Integer)(tabData.get("BARCODE_TOTALROWS")); // Added for GHL-CRF-0413.8
		//int rows1=Integer.parseInt(totalrows1);
		ArrayList datarr	=	new ArrayList();
		String order_id			=	"";
		String order_line_no	=	"";
		String bl_det            = "";
		boolean entered_Partial=false;
		boolean entered_acepted=false;
		float disp_qty = 0;
		float tot_rtn_qty =0;
		float curr_rtn_qty =0;
		boolean blResult=false;
		CallableStatement callableStatement = null;//Added for KDAH-SCF-0469,KDAH-SCF-508 and KDAH-SCF-508 
	
		try{
			connection	= getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			pstmt_update1	=	connection.prepareStatement((String) sqlMap.get("SQLUPDATE1"));
			//pstmt_update1	=	connection.prepareStatement("UPDATE PH_DISP_DRUG_BATCH SET RETURNED_QTY=NVL(RETURNED_QTY,0)+NVL(?,0),RTN_BIN_LOCATION_CODE=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? WHERE DISP_NO=? AND SRL_NO=? AND SRL_NO_BATCH=? AND FACILITY_ID=?");
			pstmt_update2	=	connection.prepareStatement((String) sqlMap.get( "SQLUPDATE2"));
			pstmt_select1	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_RET_MEDN_SELECT10")); 
			pstmt_update3	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_RET_MEDN_UPDATE3")); 
			if(((String)tabData.get("EFF_STATUS")).equals("E") && rej_qty_val.equals("E"))// if block and else condition Added for GHL-SCF-790 [IN:046481]
				pstmt_update4	=	connection.prepareStatement("UPDATE PH_WARD_RETURN_DTL SET ACKNOWLEDGE_REASON =?, ACKNOWLEDGED_BY_ID=?, STORE_ACKNOWLEDGE_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,BAL_QTY =(NVL(BAL_QTY,0)+?),REJ_QTY=? WHERE  FACILITY_ID=? AND RET_DOC_NO=? AND RET_DOC_LINE_NO=?");
			else
				pstmt_update4	=	connection.prepareStatement("UPDATE PH_WARD_RETURN_DTL SET ACKNOWLEDGE_REASON =?, ACKNOWLEDGED_BY_ID=?, STORE_ACKNOWLEDGE_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,BAL_QTY =?,REJ_QTY=(NVL(REJ_QTY,0)+?) WHERE  FACILITY_ID=? AND RET_DOC_NO=? AND RET_DOC_LINE_NO=?"); 
			pstmt_update1_lock	= connection.prepareStatement("SELECT 1 FROM PH_DISP_DRUG_BATCH WHERE DISP_NO=? AND SRL_NO=? AND SRL_NO_BATCH=? AND FACILITY_ID=? FOR UPDATE NOWAIT");   // for update added for the issue SKR-SCF-0393 [IN30939] to create a row level lock			
			pstmt_update4_lock	= connection.prepareStatement("SELECT ADDED_BY_ID FROM PH_WARD_RETURN_DTL WHERE FACILITY_ID=? AND RET_DOC_NO=? AND RET_DOC_LINE_NO=? FOR UPDATE NOWAIT");   // for update added for the issue SKR-SCF-0393 [IN30939] to create a row level lock
			//ADDED_BY_ID added for AMRI-CRF-0453
			//pstmt_insert1	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_RET_MEDN_INSERT1"));
			pstmt_insert1	=	connection.prepareStatement("INSERT INTO PH_RETURN_MEDN_LOG( FACILITY_ID , DISP_NO,  SRL_NO  , MEDN_RETURN_DATE,ITEM_CODE ,RETURNED_QTY ,RETURN_REASON_CODE ,  TOKEN_SERIES_CODE, TOKEN_SERIAL_NO, TOKEN_STATUS,  ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID , MODIFIED_BY_ID ,  MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ,SRL_NO_BATCH,DISP_LOCN_CODE,BIN_LOCATION_CODE)VALUES(?,?,?,SYSDATE,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?)");
			pstmt_insert2	=	connection.prepareStatement("INSERT INTO PH_RETN_MEDN( FACILITY_ID, RTN_MEDN_NO, DISP_NO, SRL_NO, SRL_NO_BATCH, DRUG_CODE, ITEM_CODE, BATCH_ID, EXPIRY_DATE, DISP_QTY, RTN_QTY_UOM, RTN_QTY, BIN_LOCATION_CODE,RET_DISP_LOCN_CODE,ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID,MODIFIED_BY_ID , MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,WARD_RET_RAISED_BY,WARD_RET_REQ_QTY)VALUES(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)");//WARD_RET_RAISED_BY added for AMRI-CRF-0453 //WARD_RET_REQ_QTY Added for GHL-CRF-0627
			pstmt_select2   =   connection.prepareStatement("select PH_RTN_MEDN_NO.NEXTVAL RTN_MEDN_NO from dual");	
			pstmt_select3   =   connection.prepareStatement("SELECT bal_qty FROM ph_ward_return_dtl WHERE  facility_id=? AND ret_doc_no=? AND ret_doc_line_no=?");
			String token_series_code		=(String)tabData.get("TOKEN_SERIES_CODE");
			if(rows>0){
				 if((patient_class.equals("O")||patient_class.equals("E")||patient_class.equals("R"))&&(!token_series_code.equals(""))){  
					   token_no       =    InsertTokenDetails(connection,tabData,sqlMap);
				 }
			}		
			HashMap hmWardRetDetails =(HashMap)tabData.get("WARDRETDETAILS"); //Added bellow for AMS-SCF-0038 [IN:030868]
			String key=""; //Added bellow for AMS-SCF-0038 [IN:030868]
			ArrayList alWardRetDtl =null; //Added bellow for AMS-SCF-0038 [IN:030868]
			//Generate return medication  sequence number
			rset1=pstmt_select2.executeQuery();
			if (rset1.next()){
				rtn_medn_no=rset1.getInt("RTN_MEDN_NO");
			}
			closeResultSet( rset1 );
			String st_retn_key_dtl ="", dtlKey = "", hdrKey=""; //added for AMRI-SCF-0376 [IN:055578]  -start
			//HashMap hmDtlGrp	=	(HashMap)tabData.get("hmDtlGrp"); //Commented for COMMON-ICN-0048
			HashMap hmDetail = null; //added for AMRI-SCF-0376 [IN:055578]  -end
			HashMap hdr_data = null;
			HashMap dtl_data=	null;
			List encounterList = null;
			ArrayList insertDetail = null;
			String ward_retn_raised_by="";//AMRI-CRF-0453
				
			for (int i=1; i<=rows;i++ ){
				//perform operations here
				datarr			=	(ArrayList)tabData.get("RECORD"+i);
				order_id		=	"";
				order_line_no	=	"";
				if(((String)tabData.get("EFF_STATUS")).equals("D")){
					if(datarr!=null && datarr.size()>0){
						if((String)datarr.get(4)!=null && !((String)datarr.get(4)).equals("")) {
							hdrKey = (String)datarr.get(12); //added for AMRI-SCF-0376 [IN:055578]  -start
							dtlKey = (String)datarr.get(13); 
							hmDetail = null;
							for(int p=0; p<stock_vals.size(); p+=3) {
								hdr_data  =(HashMap)stock_vals.get(p);
								if(hdr_data.size()>0){
									dtl_data = (HashMap)(stock_vals.get(p+1));
									if(dtl_data !=null && dtl_data.size()>0){
										insertDetail = (ArrayList)dtl_data.get(hdrKey);
										for(int dt=0; dt<insertDetail.size(); dt++){
											hmDetail = (HashMap)insertDetail.get(dt);
											if(hmDetail!=null && hmDetail.containsKey("dtlKey") && dtlKey.equals((String)hmDetail.get("dtlKey")))
												break;
											else
												hmDetail = null;
										}
									}
								}
							}//added for AMRI-SCF-0376 [IN:055578]  -end

							pstmt_update1_lock.setString(1,datarr.get(0).toString());//added for SKR-SCF-0393 [IN30939] 
							pstmt_update1_lock.setString(2,datarr.get(2).toString());
							pstmt_update1_lock.setString(3,datarr.get(3).toString());
							pstmt_update1_lock.setString(4,datarr.get(11).toString());
							pstmt_update1_lock.executeQuery(); //SKR-SCF-0393 [IN30939] - end
							//update operations have to be performed
							pstmt_update1.setString(1,(String)datarr.get(4));
							pstmt_update1.setString(2,(String)datarr.get(1)); //RTN_BIN_LOCATION_CODE
							pstmt_update1.setString(3,login_by_id);
							pstmt_update1.setString(4,login_at_ws_no);
							pstmt_update1.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update1.setString(6,(String)datarr.get(6));
							pstmt_update1.setString(7,(String)datarr.get(0));
							pstmt_update1.setString(8,(String)datarr.get(2));
							pstmt_update1.setString(9,(String)datarr.get(3));
							pstmt_update1.setString(10,(String)datarr.get(11));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Change Parameter from Login_facility_id to sal_facility_id

							pstmt_update1.addBatch() ;

							pstmt_update2.setString(1,(String)datarr.get(4));
							pstmt_update2.setString(2,(String)tabData.get("REMARKS"));
							pstmt_update2.setString(3,login_by_id);
							pstmt_update2.setString(4,login_at_ws_no);
							pstmt_update2.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update2.setString(6,(String)datarr.get(0));
							pstmt_update2.setString(7,(String)datarr.get(2));
							pstmt_update2.setString(8,(String)datarr.get(11));//(String)tabData.get( "FACILITY_ID" ));//IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Change Parameter from Login_facility_id to sal_facility_id

							pstmt_update2.addBatch() ;

							/*pstmt_select1.setString(1,(String)datarr.get(0));//commented   for GHL-SCF-1084
							pstmt_select1.setString(2,(String)datarr.get(2));
							pstmt_select1.setString(3,(String)datarr.get(11)); //(String)tabData.get( "FACILITY_ID" ) Changed (String)datarr.get(11) for ML-BRU-SCF-1153 [IN:045199]
							rset	=	pstmt_select1.executeQuery();
							
							if(rset.next()){
								order_id		=	rset.getString("ORDER_ID");
								order_line_no	=	rset.getString("ORDER_LINE_NO");
							}

							closeResultSet( rset );*/
							order_id=(String)datarr.get(14);//Added for GHL-SCF-1084
							order_line_no=(String)datarr.get(15);//Added for GHL-SCF-1084
							System.err.println("order_id@@@@229==="+order_id+"order_line_no====="+order_line_no);
							pstmt_update3.setString(1,(String)datarr.get(4));
							pstmt_update3.setString(2,(String)tabData.get("REMARKS"));
							pstmt_update3.setString(3,login_by_id);
							pstmt_update3.setString(4,login_at_ws_no);
							pstmt_update3.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update3.setString(6,order_id);
							pstmt_update3.setString(7,order_line_no);
							pstmt_update3.addBatch();
						 
							pstmt_insert1.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(2,(String)datarr.get(0));                        
							pstmt_insert1.setString(3,(String)datarr.get(2));	                     
							pstmt_insert1.setString(4,(String)datarr.get(5));
							pstmt_insert1.setString(5,(String)datarr.get(4));
							pstmt_insert1.setString(6,(String)tabData.get("REMARKS"));
							pstmt_insert1.setString(7,(String)tabData.get( "TOKEN_SERIES_CODE" ));
							pstmt_insert1.setString(8,token_no);
							pstmt_insert1.setString(9,"RM");
							pstmt_insert1.setString(10,login_by_id);
							pstmt_insert1.setString(11,login_at_ws_no);
							pstmt_insert1.setString(12,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(13,login_by_id);
							pstmt_insert1.setString(14,login_at_ws_no);
							pstmt_insert1.setString(15,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(16,(String)datarr.get(3));	                     //SRL_NO_BATCH
							pstmt_insert1.setString(17,(String)tabData.get("Login_disp_locn_code")); //(String)tabData.get( "DISP_LOCN_CODE" ) changed for MMS-DM-CRF-0010 [IN:054441]
							pstmt_insert1.setString(18,(String)datarr.get(1));
							pstmt_insert1.addBatch();
							st_retn_key_dtl = (String)tabData.get( "FACILITY_ID" )+"-"+rtn_medn_no+"-"+(String)datarr.get(0)+"-"+(String)datarr.get(2)+"-"+(String)datarr.get(3);
							if(hmDetail!=null && hmDetail.size()>0)
								hmDetail.put("remarks",st_retn_key_dtl );
							pstmt_insert2.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.setString(2,String.valueOf(rtn_medn_no));           //RTN_MEDN_NO               
							pstmt_insert2.setString(3,(String)datarr.get(0));	              //DISP_NO                   
							pstmt_insert2.setString(4,(String)datarr.get(2));	              //SRL_NO
							pstmt_insert2.setString(5,(String)datarr.get(3));	              //SRL_NO_BATCH
							pstmt_insert2.setString(6,(String)datarr.get(5));	              //DRUG_CODE 
							pstmt_insert2.setString(7,(String)datarr.get(5));                 //ITEM_CODE
							pstmt_insert2.setString(8,(String)datarr.get(7));				  //BATCH_ID
							pstmt_insert2.setString(9,(String)datarr.get(8));				  //EXPIRY_DATE
							pstmt_insert2.setString(10,(String)datarr.get(9));				  //DISP_QTY
							pstmt_insert2.setString(11,(String)datarr.get(10));				  //RTN_QTY_UOM
							pstmt_insert2.setString(12,(String)datarr.get(4));                //RTN_QTY
							pstmt_insert2.setString(13,(String)datarr.get(1));	              //BIN_LOCATION_CODE         
							pstmt_insert2.setString(14,(String)datarr.get(6));	              //RET_DISP_LOCN_CODE  
							pstmt_insert2.setString(15,login_by_id);
							pstmt_insert2.setString(16,login_at_ws_no);
							pstmt_insert2.setString(17,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.setString(18,login_by_id);
							pstmt_insert2.setString(19,login_at_ws_no);
							pstmt_insert2.setString(20,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.setString(21,"");//added for AMRI-CRF-0453
							pstmt_insert2.setString(22,""); //added for GHL-CRF-0627
							pstmt_insert2.addBatch();
						}
					}
				}
				else if(((String)tabData.get("EFF_STATUS")).equals("E")){
					if(datarr!=null && datarr.size()>0){
						hdrKey = (String)datarr.get(20); //added for AMRI-SCF-0376 [IN:055578] -start
						dtlKey = (String)datarr.get(21); 
						hmDetail = null;
						for(int p=0; p<stock_vals.size(); p+=3) {
							hdr_data  =(HashMap)stock_vals.get(p);
							if(hdr_data.size()>0){
								dtl_data = (HashMap)(stock_vals.get(p+1));
								if(dtl_data !=null && dtl_data.size()>0){
									insertDetail = (ArrayList)dtl_data.get(hdrKey);
									if(insertDetail!=null){
										for(int dt=0; dt<insertDetail.size(); dt++){
											hmDetail = (HashMap)insertDetail.get(dt);
											if(hmDetail!=null && hmDetail.containsKey("dtlKey") && dtlKey.equals((String)hmDetail.get("dtlKey")))
												break;
											else
												hmDetail = null;
										}
									}
								}
							}
						}//added for AMRI-SCF-0376 [IN:055578]  -end
						if(rej_qty_val.equals("E") && !((String)datarr.get(6)).equals("P")){ // if block Added for GHL-SCF-790 [IN:046481] 
							pstmt_select3.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_select3.setString(2,(String)datarr.get(9));
							pstmt_select3.setString(3,(String)datarr.get(10));
							rset1=pstmt_select3.executeQuery();
							if(rset1.next())
								bal_qty = Integer.parseInt(rset1.getString("bal_qty"));
							closeResultSet( rset1 );
							if(bal_qty > 0)
								datarr.set(6,"P");
						}
						//key = (String)datarr.get(0)+(String)datarr.get(2)+(String)datarr.get(3); //Commented for  GHL-SCF-855 [IN:053188] 
						key = (String)datarr.get(0)+"_"+(String)datarr.get(2)+"_"+(String)datarr.get(1)+"_"+datarr.get(15)+"_"+datarr.get(16); //added for  GHL-SCF-855 [IN:053188] (KDAH-SCF-0252 [IN:050489] - code break)//datarr.get(15) added for AMRI-SCF-0378[IN055710]// datarr.get(16) // Added for ML-BRU-SCF-1880
						if(((String)datarr.get(6)).equals("A"))	{
							entered_acepted=true;
							
							pstmt_update1_lock.setString(1,datarr.get(0).toString());//added for SKR-SCF-0393 [IN30939] 
							pstmt_update1_lock.setString(2,datarr.get(2).toString());
							pstmt_update1_lock.setString(3,datarr.get(3).toString());
							pstmt_update1_lock.setString(4,tabData.get( "FACILITY_ID" ).toString());
							pstmt_update1_lock.executeQuery(); //SKR-SCF-0393 [IN30939] - end
							//update operations have to be performed
							pstmt_update1.setString(1,(String)datarr.get(4));
							pstmt_update1.setString(2,(String)datarr.get(1));
							pstmt_update1.setString(3,login_by_id);
							pstmt_update1.setString(4,login_at_ws_no);
							pstmt_update1.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update1.setString(6,(String)datarr.get(11));
							pstmt_update1.setString(7,(String)datarr.get(0));
							pstmt_update1.setString(8,(String)datarr.get(2));
							pstmt_update1.setString(9,(String)datarr.get(3));
							pstmt_update1.setString(10,(String)tabData.get( "FACILITY_ID" ));

							pstmt_update1.addBatch() ;

							pstmt_update2.setString(1,(String)datarr.get(4));
							if(!((String)tabData.get("REMARKS")).equals("")){
								pstmt_update2.setString(2,(String)tabData.get("REMARKS"));
							}
							else {
								pstmt_update2.setString(2,(String)datarr.get(8));
							}
							pstmt_update2.setString(3,login_by_id);
							pstmt_update2.setString(4,login_at_ws_no);
							pstmt_update2.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update2.setString(6,(String)datarr.get(0));
							pstmt_update2.setString(7,(String)datarr.get(2));
							pstmt_update2.setString(8,(String)tabData.get( "FACILITY_ID" ));

							pstmt_update2.addBatch() ;

							/*pstmt_select1.setString(1,(String)datarr.get(0));//COMMENTED for GHL-SCF-1084
							pstmt_select1.setString(2,(String)datarr.get(2));
							pstmt_select1.setString(3,(String)tabData.get( "FACILITY_ID" ));
							rset	=	pstmt_select1.executeQuery();
							
							if(rset.next()){
								order_id		=	rset.getString("ORDER_ID");
								order_line_no	=	rset.getString("ORDER_LINE_NO");
							}
							closeResultSet( rset );*/
							order_id=(String)datarr.get(22);//Added for GHL-SCF-1084
							order_line_no=(String)datarr.get(23);//Added for GHL-SCF-1084
							System.err.println("order_id@@@@371==="+order_id+"order_line_no====="+order_line_no);

							pstmt_update3.setString(1,(String)datarr.get(4));
							if(!((String)tabData.get("REMARKS")).equals("")){
								pstmt_update3.setString(2,(String)tabData.get("REMARKS"));
							}
							else {
								pstmt_update3.setString(2,(String)datarr.get(8));
							}
							
							pstmt_update3.setString(3,login_by_id);
							pstmt_update3.setString(4,login_at_ws_no);
							pstmt_update3.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update3.setString(6,order_id);
							pstmt_update3.setString(7,order_line_no);
							pstmt_update3.addBatch();
						   /*  //Commented and added bellow for AMS-SCF-0038 [IN:030868]
							pstmt_insert1.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(2,(String)datarr.get(0));
							pstmt_insert1.setString(3,(String)datarr.get(2));
							pstmt_insert1.setString(4,(String)datarr.get(5));
							pstmt_insert1.setString(5,(String)datarr.get(4));
							
							
							if(!((String)tabData.get("REMARKS")).equals("")){
								pstmt_insert1.setString(6,(String)tabData.get("REMARKS"));
							}else {
								pstmt_insert1.setString(6,(String)datarr.get(8));
							}
							pstmt_insert1.setString(7,(String)tabData.get( "TOKEN_SERIES_CODE" ));
							pstmt_insert1.setString(8,token_no);
							pstmt_insert1.setString(9,"RM");
							pstmt_insert1.setString(10,login_by_id);
							pstmt_insert1.setString(11,login_at_ws_no);
							pstmt_insert1.setString(12,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(13,login_by_id);
							pstmt_insert1.setString(14,login_at_ws_no);
							pstmt_insert1.setString(15,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(16,(String)datarr.get(3));
							pstmt_insert1.setString(17,(String)tabData.get( "DISP_LOCN_CODE" ));
							pstmt_insert1.setString(18,(String)datarr.get(1));
							
							pstmt_insert1.addBatch();
							*/
							//added for SKR-SCF-0393 [IN30939] 
							pstmt_update4_lock.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4_lock.setString(2,(String)datarr.get(9));
							pstmt_update4_lock.setString(3,(String)datarr.get(10));
							ResultSet resultset1= pstmt_update4_lock.executeQuery(); //SKR-SCF-0393 [IN30939] - end
							//added for AMRI-CRF-0453 - start
							if(resultset1!=null && resultset1.next()){
							 ward_retn_raised_by = resultset1.getString("ADDED_BY_ID");
							}

							closeResultSet( resultset1 ); 
							//added for AMRI-CRF-0453 - end

							pstmt_update4.setString(1,(String)datarr.get(7));
							pstmt_update4.setString(2,login_by_id);
							pstmt_update4.setString(3,(String)datarr.get(6));
							pstmt_update4.setString(4,login_by_id);
							pstmt_update4.setString(5,login_at_ws_no);
							pstmt_update4.setString(6,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4.setString(7,(String)datarr.get(14));
							pstmt_update4.setString(8,(String)datarr.get(13));
							pstmt_update4.setString(9,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4.setString(10,(String)datarr.get(9));
							pstmt_update4.setString(11,(String)datarr.get(10));
							pstmt_update4.addBatch();
							/* //Commented and added bellow for AMS-SCF-0038 [IN:030868]
							pstmt_insert2.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.setString(2,String.valueOf(rtn_medn_no));                    //RTN_MEDN_NO                
							pstmt_insert2.setString(3,(String)datarr.get(0));	                       //DISP_NO                     
							pstmt_insert2.setInt(4,Integer.parseInt(datarr.get(2).toString()));	       //SRL_NO
							pstmt_insert2.setInt(5,Integer.parseInt(datarr.get(3).toString()));	       //SRL_NO_BATCH
							pstmt_insert2.setString(6,(String)datarr.get(5));	                       //DRUG_CODE 
							pstmt_insert2.setString(7,(String)datarr.get(5));                          //ITEM_CODE
							
							pstmt_insert2.setString(8,(String)datarr.get(15));				            //BATCH_ID
							pstmt_insert2.setString(9,(String)datarr.get(16));				            //EXPIRY_DATE
							pstmt_insert2.setInt(10,Integer.parseInt(datarr.get(17).toString()));		//DISP_QTY
							pstmt_insert2.setString(11,(String)datarr.get(18));				            //RTN_QTY_UOM
							pstmt_insert2.setInt(12,Integer.parseInt(datarr.get(4).toString()));        //RTN_QTY
							pstmt_insert2.setString(13,(String)datarr.get(1));	                       //BIN_LOCATION_CODE 
							pstmt_insert2.setString(14,(String)datarr.get(11));						  //RET_DISP_LOCN_CODE
							pstmt_insert2.setString(15,login_by_id);
							pstmt_insert2.setString(16,login_at_ws_no);
							pstmt_insert2.setString(17,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.setString(18,login_by_id);
							pstmt_insert2.setString(19,login_at_ws_no);
							pstmt_insert2.setString(20,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.addBatch();
							*/
						}
						else if(((String)datarr.get(6)).equals("R")){
							
							pstmt_update4_lock.setString(1,(String)tabData.get( "FACILITY_ID" ));//added for SKR-SCF-0393 [IN30939] 
							pstmt_update4_lock.setString(2,(String)datarr.get(9));
							pstmt_update4_lock.setString(3,(String)datarr.get(10));
							ResultSet resultset1 = pstmt_update4_lock.executeQuery(); //SKR-SCF-0393 [IN30939] - end	
					   //added for AMRI-CRF-0453 - start
							if(resultset1!=null && resultset1.next()){
							 ward_retn_raised_by = resultset1.getString("ADDED_BY_ID");
							}

							closeResultSet( resultset1 ); 
							pstmt_update4.setString(1,(String)datarr.get(7));
							pstmt_update4.setString(2,login_by_id);
							pstmt_update4.setString(3,(String)datarr.get(6));
							pstmt_update4.setString(4,login_by_id);
							pstmt_update4.setString(5,login_at_ws_no);
							pstmt_update4.setString(6,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4.setString(7,(String)datarr.get(14));
							pstmt_update4.setString(8,(String)datarr.get(13));
							pstmt_update4.setString(9,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4.setString(10,(String)datarr.get(9));
							pstmt_update4.setString(11,(String)datarr.get(10));
							pstmt_update4.addBatch();
					 
						}
						else if(((String)datarr.get(6)).equals("P")){
							
							entered_Partial=true;
							//update operations have to be performed
							
							pstmt_update1_lock.setString(1,datarr.get(0).toString());//added for SKR-SCF-0393 [IN30939] --begin
							pstmt_update1_lock.setString(2,datarr.get(2).toString());
							pstmt_update1_lock.setString(3,datarr.get(3).toString());
							pstmt_update1_lock.setString(4,tabData.get( "FACILITY_ID" ).toString());
							pstmt_update1_lock.executeQuery(); //SKR-SCF-0393 [IN30939] - end	
							pstmt_update1.setString(1,(String)datarr.get(12));
							
							pstmt_update1.setString(2,(String)datarr.get(1));
							pstmt_update1.setString(3,login_by_id);
							pstmt_update1.setString(4,login_at_ws_no);
							pstmt_update1.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update1.setString(6,(String)datarr.get(11));
							pstmt_update1.setString(7,(String)datarr.get(0));
							pstmt_update1.setString(8,(String)datarr.get(2));
							pstmt_update1.setString(9,(String)datarr.get(3));
							pstmt_update1.setString(10,(String)tabData.get( "FACILITY_ID" ));

							pstmt_update1.addBatch();
							
							pstmt_update2.setString(1,(String)datarr.get(12));
							if(!((String)tabData.get("REMARKS")).equals("")){
								pstmt_update2.setString(2,(String)tabData.get("REMARKS"));
							}else {
								pstmt_update2.setString(2,(String)datarr.get(8));
							}
							pstmt_update2.setString(3,login_by_id);
							pstmt_update2.setString(4,login_at_ws_no);
							pstmt_update2.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update2.setString(6,(String)datarr.get(0));
							pstmt_update2.setString(7,(String)datarr.get(2));
							pstmt_update2.setString(8,(String)tabData.get( "FACILITY_ID" ));

							pstmt_update2.addBatch() ;

							pstmt_select1.setString(1,(String)datarr.get(0));
							pstmt_select1.setString(2,(String)datarr.get(2));
							pstmt_select1.setString(3,(String)tabData.get( "FACILITY_ID" ));
							rset	=	pstmt_select1.executeQuery();
							
							if(rset.next()){
								order_id		=	rset.getString("ORDER_ID");
								order_line_no	=	rset.getString("ORDER_LINE_NO");
							}
							closeResultSet( rset );
						
							pstmt_update3.setString(1,(String)datarr.get(12));							
							if(!((String)tabData.get("REMARKS")).equals("")){
								pstmt_update3.setString(2,(String)tabData.get("REMARKS"));
							}else {
								pstmt_update3.setString(2,(String)datarr.get(8));
							}
							
							pstmt_update3.setString(3,login_by_id);
							pstmt_update3.setString(4,login_at_ws_no);
							pstmt_update3.setString(5,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update3.setString(6,order_id);
							pstmt_update3.setString(7,order_line_no);
							pstmt_update3.addBatch();
							/* //Commented and added bellow for AMS-SCF-0038 [IN:030868]
							pstmt_insert1.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(2,(String)datarr.get(0));
							pstmt_insert1.setString(3,(String)datarr.get(2));
							pstmt_insert1.setString(4,(String)datarr.get(5));
							pstmt_insert1.setString(5,(String)datarr.get(12));
							
							if(!((String)tabData.get("REMARKS")).equals("")){
								pstmt_insert1.setString(6,(String)tabData.get("REMARKS"));
							}
							else {
								pstmt_insert1.setString(6,(String)datarr.get(8));
							}
							pstmt_insert1.setString(7,(String)tabData.get( "TOKEN_SERIES_CODE" ));
							pstmt_insert1.setString(8,token_no);
							pstmt_insert1.setString(9,"RM");
							pstmt_insert1.setString(10,login_by_id);
							pstmt_insert1.setString(11,login_at_ws_no);
							pstmt_insert1.setString(12,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(13,login_by_id);
							pstmt_insert1.setString(14,login_at_ws_no);
							pstmt_insert1.setString(15,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert1.setString(16,(String)datarr.get(3));
							pstmt_insert1.setString(17,(String)tabData.get( "DISP_LOCN_CODE" ));
							pstmt_insert1.setString(18,(String)datarr.get(1));
							pstmt_insert1.addBatch();
							*/
							//added for SKR-SCF-0393 [IN30939] 
							pstmt_update4_lock.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4_lock.setString(2,(String)datarr.get(9));
							pstmt_update4_lock.setString(3,(String)datarr.get(10));
							ResultSet resultset1 = pstmt_update4_lock.executeQuery(); //SKR-SCF-0393 [IN30939] - end
							//added for AMRI-CRF-0453 - start
							if(resultset1!=null && resultset1.next()){
							 ward_retn_raised_by = resultset1.getString("ADDED_BY_ID");
							}

							closeResultSet( resultset1 ); 
							pstmt_update4.setString(1,(String)datarr.get(7));
							pstmt_update4.setString(2,login_by_id);
							pstmt_update4.setString(3,(String)datarr.get(6));//Acknowledgement Status
							pstmt_update4.setString(4,login_by_id);
							pstmt_update4.setString(5,login_at_ws_no);
							pstmt_update4.setString(6,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4.setString(7,(String)datarr.get(14));// Bal Qty
							pstmt_update4.setString(8,(String)datarr.get(13));// Rej Qty
							pstmt_update4.setString(9,(String)tabData.get( "FACILITY_ID" ));
							pstmt_update4.setString(10,(String)datarr.get(9));
							pstmt_update4.setString(11,(String)datarr.get(10));
							pstmt_update4.addBatch();
						   /* //Commented and added bellow for AMS-SCF-0038 [IN:030868]
							pstmt_insert2.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.setString(2,String.valueOf(rtn_medn_no));                    //RTN_MEDN_NO                
							pstmt_insert2.setString(3,(String)datarr.get(0));	                       //DISP_NO                     
							pstmt_insert2.setInt(4,Integer.parseInt(datarr.get(2).toString()));	       //SRL_NO
							pstmt_insert2.setInt(5,Integer.parseInt(datarr.get(3).toString()));	       //SRL_NO_BATCH
							pstmt_insert2.setString(6,(String)datarr.get(5));	                       //DRUG_CODE 
							pstmt_insert2.setString(7,(String)datarr.get(5));                          //ITEM_CODE
							
							pstmt_insert2.setString(8,(String)datarr.get(15));				            //BATCH_ID
							pstmt_insert2.setString(9,(String)datarr.get(16));				            //EXPIRY_DATE
							pstmt_insert2.setInt(10,Integer.parseInt(datarr.get(17).toString()));		//DISP_QTY
							pstmt_insert2.setString(11,(String)datarr.get(18));				            //RTN_QTY_UOM
							pstmt_insert2.setInt(12,Integer.parseInt(datarr.get(4).toString()));        //RTN_QTY
							pstmt_insert2.setString(13,(String)datarr.get(1));	                      //BIN_LOCATION_CODE 
							pstmt_insert2.setString(14,(String)datarr.get(11));				    	//RET_DISP_LOCN_CODE
							pstmt_insert2.setString(15,login_by_id);
							pstmt_insert2.setString(16,login_at_ws_no);
							pstmt_insert2.setString(17,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.setString(18,login_by_id);
							pstmt_insert2.setString(19,login_at_ws_no);
							pstmt_insert2.setString(20,(String)tabData.get( "FACILITY_ID" ));
							pstmt_insert2.addBatch();
							*/
						}
						//Added bellow for AMS-SCF-0038 [IN:030868] -Start
						if(hmWardRetDetails.containsKey(key)){
							alWardRetDtl = (ArrayList )hmWardRetDetails.get(key);
							if(alWardRetDtl!=null && alWardRetDtl.size()>0){
								pstmt_insert1.setString(1,(String)tabData.get( "FACILITY_ID" ));
								pstmt_insert1.setString(2,(String)alWardRetDtl.get(0));
								pstmt_insert1.setString(3,(String)alWardRetDtl.get(2));
								pstmt_insert1.setString(4,(String)alWardRetDtl.get(5));
								pstmt_insert1.setString(5,(String)alWardRetDtl.get(12));
								if(!((String)tabData.get("REMARKS")).equals(""))
									pstmt_insert1.setString(6,(String)tabData.get("REMARKS"));
								else 
									pstmt_insert1.setString(6,(String)alWardRetDtl.get(8));
								pstmt_insert1.setString(7,(String)tabData.get( "TOKEN_SERIES_CODE" ));
								pstmt_insert1.setString(8,token_no);
								pstmt_insert1.setString(9,"RM");
								pstmt_insert1.setString(10,login_by_id);
								pstmt_insert1.setString(11,login_at_ws_no);
								pstmt_insert1.setString(12,(String)tabData.get( "FACILITY_ID" ));
								pstmt_insert1.setString(13,login_by_id);
								pstmt_insert1.setString(14,login_at_ws_no);
								pstmt_insert1.setString(15,(String)tabData.get( "FACILITY_ID" ));
								pstmt_insert1.setString(16,(String)alWardRetDtl.get(3));
								pstmt_insert1.setString(17,(String)tabData.get("Login_disp_locn_code")); //(String)tabData.get( "DISP_LOCN_CODE" ) changed for MMS-DM-CRF-0010 [IN:054441]
								pstmt_insert1.setString(18,(String)alWardRetDtl.get(1));
								pstmt_insert1.addBatch();
							
								st_retn_key_dtl = (String)tabData.get( "FACILITY_ID" )+"-"+rtn_medn_no+"-"+(String)alWardRetDtl.get(0)+"-"+(String)alWardRetDtl.get(2)+"-"+(String)alWardRetDtl.get(3);
								if(hmDetail!=null && hmDetail.size()>0)
									hmDetail.put("remarks",st_retn_key_dtl );
								pstmt_insert2.setString(1,(String)tabData.get( "FACILITY_ID" ));
								pstmt_insert2.setString(2,String.valueOf(rtn_medn_no));                    //RTN_MEDN_NO                
								pstmt_insert2.setString(3,(String)alWardRetDtl.get(0));	                       //DISP_NO                     
								pstmt_insert2.setInt(4,Integer.parseInt(alWardRetDtl.get(2).toString()));	       //SRL_NO
								pstmt_insert2.setInt(5,Integer.parseInt(alWardRetDtl.get(3).toString()));	       //SRL_NO_BATCH
								pstmt_insert2.setString(6,(String)alWardRetDtl.get(5));	                       //DRUG_CODE 
								pstmt_insert2.setString(7,(String)alWardRetDtl.get(5));                          //ITEM_CODE
								
								pstmt_insert2.setString(8,(String)alWardRetDtl.get(15));				            //BATCH_ID
								pstmt_insert2.setString(9,(String)alWardRetDtl.get(16));				            //EXPIRY_DATE
								pstmt_insert2.setInt(10,Integer.parseInt(alWardRetDtl.get(17).toString()));		//DISP_QTY
								pstmt_insert2.setString(11,(String)alWardRetDtl.get(18));				            //RTN_QTY_UOM
								pstmt_insert2.setInt(12,Integer.parseInt(alWardRetDtl.get(12).toString()));        //RTN_QTY
								pstmt_insert2.setString(13,(String)alWardRetDtl.get(1));	                      //BIN_LOCATION_CODE 
								pstmt_insert2.setString(14,(String)alWardRetDtl.get(11));				    	//RET_DISP_LOCN_CODE
								pstmt_insert2.setString(15,login_by_id);
								pstmt_insert2.setString(16,login_at_ws_no);
								pstmt_insert2.setString(17,(String)tabData.get( "FACILITY_ID" ));
								pstmt_insert2.setString(18,login_by_id);
								pstmt_insert2.setString(19,login_at_ws_no);
								pstmt_insert2.setString(20,(String)tabData.get( "FACILITY_ID" ));

								if(ward_retn_raised_by==null || ward_retn_raised_by.equals(""))
									ward_retn_raised_by = login_by_id;
								pstmt_insert2.setString(21,ward_retn_raised_by); //added for AMRI-CRF-0453
								pstmt_insert2.setInt(22,Integer.parseInt(alWardRetDtl.get(25).toString())); //Added for GHL-CRF-0627
								pstmt_insert2.addBatch();

								hmWardRetDetails.remove(key);
							}
						}
						//Added bellow for AMS-SCF-0038 [IN:030868] -End
					} //end for if datarr.size()
				}
			} //end for loop
			if(((String)tabData.get("EFF_STATUS")).equals("D")){

				int[] result1=pstmt_update1.executeBatch();
				int[] result2=pstmt_update2.executeBatch();
				int[] result3=pstmt_update3.executeBatch();
				int k;
				for ( k=0;k<result1.length ;k++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result1[k]<0  && result1[k] != -2 ){
						pstmt_update1.cancel();
						connection.rollback();
						map.put ("result",blResult);
						map.put( "msgid", "Error During Updation into disp drug batch ");
						return map;
					}		
				}

				for (k=0;k<result2.length ;k++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result2[k]<0  && result2[k] != -2 ){
						pstmt_update2.cancel();
						connection.rollback();
						map.put ("result",blResult);
						map.put( "msgid", "Error During Updation into disp dtl ");
						return map;
					}		
				}

				for (k=0;k<result3.length ;k++ ){
					if(result3[k]<0  && result3[k] != -2 ){
						pstmt_update3.cancel();
						connection.rollback();
						map.put ("result",blResult);
						map.put( "msgid", "Error During Updation into patient drug profile ");
						return map;
					}		
				}

				int[] result4=pstmt_insert1.executeBatch();
				for (k=0;k<result4.length ;k++ ){
					if(result4[k]<0  && result4[k] != -2 ){
						pstmt_update4.cancel();
						connection.rollback();
						map.put ("result",blResult);
						map.put( "msgid", "Error during return log insertion ");
						return map;
					}		
				}

				int[] result5=pstmt_insert2.executeBatch();
				for (k=0;k<result5.length ;k++ ){
					if(result5[k]<0  && result5[k] != -2 ){
						pstmt_update4.cancel();
						connection.rollback();
						map.put ("result",blResult);
						map.put( "msgid", "Error during return PH_RETN_MEDN insertion ");
						return map;
					}		
				}
			}
			else if(((String)tabData.get("EFF_STATUS")).equals("E")){
				pstmt_select_balQty	=	connection.prepareStatement(" SELECT 1 CAN_UPDATE FROM PH_WARD_RETURN_DTL WHERE TO_DATE (?, 'DD/MM/YYYY HH24:MI:SSSSS') = MODIFIED_DATE AND (store_acknowledge_status IS NULL OR store_acknowledge_status NOT IN ('A', 'C')) AND FACILITY_ID = ? AND RET_DOC_NO=? AND RET_DOC_LINE_NO=?");  //added for SKR-SCF-0393 [IN:030939] -start
				//AND (store_acknowledge_status IS NULL OR store_acknowledge_status NOT IN ('A', 'C')) added for AMRI-SCF-0617

				String can_Update = "";
				for (int i=1; i<=rows;i++ ){
					datarr			=	(ArrayList)tabData.get("RECORD"+i)==null?new ArrayList():(ArrayList)tabData.get("RECORD"+i);
					can_Update = "";
					if(datarr.size()>0){
						if(((String)datarr.get(6)).equals("A") || ((String)datarr.get(6)).equals("R") || ((String)datarr.get(6)).equals("P")){
							pstmt_select_balQty.setString(1,(String)datarr.get(19));
							pstmt_select_balQty.setString(2,(String)tabData.get( "FACILITY_ID" ));
							pstmt_select_balQty.setString(3,(String)datarr.get(9));
							pstmt_select_balQty.setString(4,(String)datarr.get(10));
							rset	=	pstmt_select_balQty.executeQuery();
							if(rset.next()){
								can_Update		=	rset.getString("CAN_UPDATE");
							}
							closeResultSet( rset );
							//commented for ghl-scf-1448  and removed the comment for AMRI-SCF-0617 and KDAH-SCF-0635
								if(can_Update==null || !can_Update.equals("1")){
								connection.rollback();
								map.put( "result", blResult) ;
								map.put( "msgid", "APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...") ;
								System.err.println("ReturnMedicationManager.java==Exception===tabData====762=====>"+tabData);
								return map ;
							}
							//added  for ghl-scf-1448 start
							
							/* if( ((String)datarr.get(24) ==null || (String)datarr.get(24) =="" || Integer.parseInt((String)datarr.get(24))== 0 )){
								 connection.rollback();
									map.put( "result", blResult) ;
									map.put( "msgid", "APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...") ;
									return map ;
							  } */
							//added  for ghl-scf-1448 end
							 
						}
					}
				}
				closeResultSet( rset );
				closeStatement( pstmt_select_balQty ) ; //added for SKR-SCF-0393 [IN:030939] -end

				//if(((String)datarr.get(6)).equals("A") || ((String)datarr.get(6)).equals("P")){
				if(entered_acepted==true||entered_Partial==true){
					int[] result1=pstmt_update1.executeBatch();
					int[] result2=pstmt_update2.executeBatch();
					int[] result3=pstmt_update3.executeBatch();
					int[] result4=pstmt_insert1.executeBatch();
					int[] result5=pstmt_update4.executeBatch();
					int[] result6=pstmt_insert2.executeBatch();
					int k;
					for ( k=0;k<result1.length ;k++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result1[k]<0  && result1[k] != -2 ){
							pstmt_update1.cancel();
							connection.rollback();
							map.put ("result",blResult);
							map.put( "msgid", "Error During Updation into disp drug batch ");
							return map;
						}		
					}

					for (k=0;k<result2.length ;k++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result2[k]<0  && result2[k] != -2 ){
							pstmt_update2.cancel();
							connection.rollback();
							map.put ("result",blResult);
							map.put( "msgid", "Error During Updation into disp dtl ");
							return map;
						}		
					}

					for (k=0;k<result3.length ;k++ ){
						if(result3[k]<0  && result3[k] != -2 ){
							pstmt_update3.cancel();
							connection.rollback();
							map.put ("result",blResult);
							map.put( "msgid", "Error During Updation into patient drug profile ");
							return map;
						}		
					}

					for (k=0;k<result4.length ;k++ ){
						if(result4[k]<0  && result4[k] != -2 ){
							pstmt_update4.cancel();
							connection.rollback();
							map.put ("result",blResult);
							map.put( "msgid", "Error during return log insertion ");
							return map;
						}		
					}

					for (k=0;k<result5.length ;k++ ){
						if(result5[k]<0  && result5[k] != -2 ){
							pstmt_update4.cancel();
							connection.rollback();
							map.put ("result",blResult);
							map.put( "msgid", "ERROR DURING UPDATION INTO PH_WARD_RETURN_DTL ");
							return map;
						}		
					}

					for (k=0;k<result6.length ;k++ ){
						if(result6[k]<0  && result6[k] != -2 ){
							pstmt_update4.cancel();
							connection.rollback();
							map.put ("result",blResult);
							map.put( "msgid", "Error during return PH_RETN_MEDN insertion ");
							return map;
						}		
					}
				}
				else{
					int[] result5=pstmt_update4.executeBatch();
					for (int k=0;k<result5.length ;k++ ){
						if(result5[k]<0  && result5[k] != -2 ){
							pstmt_update4.cancel();
							connection.rollback();
							map.put ("result",blResult);
							map.put( "msgid", "ERROR DURING UPDATION INTO PH_WARD_RETURN_DTL ");
							return map;
						}		
					}
				}//END ELSE
			} //END IF
			//Added for SRR-SCF20056-7701 @ Siriraj War Room UAT5 -IN030939	SKR-SCF-0393-start 
			pstmt_select_balQty	=	connection.prepareStatement((String) sqlMap.get( "SQL_PH_RET_MEDN_GET_BAL_QTY")); 
			for (int i=1; i<=rows;i++ ){
				datarr			=	(ArrayList)tabData.get("RECORD"+i)==null?new ArrayList():(ArrayList)tabData.get("RECORD"+i);
				if( ((String)tabData.get("EFF_STATUS")).equals("D") || ((String)datarr.get(6)).equals("A") || ((String)datarr.get(6)).equals("P")){
					if(datarr.size()>0){
						if(datarr!=null && (String)datarr.get(4)!=null && !((String)datarr.get(4)).equals("")) {
							pstmt_select_balQty.setString(1,(String)tabData.get( "FACILITY_ID" ));
							pstmt_select_balQty.setString(2,(String)datarr.get(0));
							pstmt_select_balQty.setString(3,(String)datarr.get(2));
							pstmt_select_balQty.setString(4,(String)datarr.get(3));
							rset	=	pstmt_select_balQty.executeQuery();
							if(rset.next()){
								tot_rtn_qty		=	rset.getFloat("TOT_RTN_QTY");
							}
							closeResultSet( rset ); //common-icn-0029
							disp_qty = Float.parseFloat(datarr.get(9).toString());
							curr_rtn_qty = Float.parseFloat(datarr.get(4).toString());
							//if( (tot_rtn_qty+curr_rtn_qty)>disp_qty){
							if( tot_rtn_qty>disp_qty){
								connection.rollback();
								map.put( "result", blResult) ;
								map.put( "msgid", "APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...") ;
								return map ;
							}
						}
					}
				}
			}//Added for SRR-SCF20056-7701 @ Siriraj War Room UAT5 IN030939	SKR-SCF-0393 -end 
			// Stock Routine starts
			HashMap hmData			=	new HashMap();
			HashMap hmCommon		=	new HashMap();

			hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
			hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
			hmCommon.put("login_facility_id",(String)tabData.get( "FACILITY_ID" ));
			language_data.add(languageid);
			HashMap ret_map	= new HashMap();
			HashMap hdr_data_dtl = new HashMap(); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
			HashMap exp_data	=	new HashMap();
			eST.Common.StSalesReturn	salesReturn	=	new eST.Common.StSalesReturn();
			String billable_trn_yn="";//Assigned value for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508  
			ArrayList doc_no = null;
			String take_home_yn="";
			String doc_loop_falg="false";//Added for KDAH-SCF-0469,KDAH-SCF-508 and KDAH-SCF-508 
			ArrayList enc_group =new ArrayList();//Added for KDAH-SCF-0469,KDAH-SCF-508 and KDAH-SCF-508 
			String enc_list="";//Added for KDAH-SCF-0469,KDAH-SCF-508 and KDAH-SCF-508 
			for(int p=0; p<stock_vals.size(); p+=3) {
				hdr_data  =(HashMap)stock_vals.get(p);
				if(hdr_data.size()>0){
					encounterList = new ArrayList(hdr_data.keySet());
					dtl_data = (HashMap)(stock_vals.get(p+1)); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
					exp_data = (HashMap)(stock_vals.get(p+2)); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
					for(int encCount=0; encCount<encounterList.size(); encCount++){ //ENCOUNTER BASED HEADER FOR LOOP added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						hmData.clear();
						hdr_data_dtl.clear();
						hdr_data_dtl = (HashMap)hdr_data.get((String) encounterList.get(encCount)); //added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979
						hdr_data_dtl.put("token_series_code",(String)tabData.get( "TOKEN_SERIES_CODE" ));
						hdr_data_dtl.put("token_serial_no",token_no);
						int temp_count=encCount+1;//Adding start for KDAH-SCF-0452
						//System.err.println("encounterList.size()@@@@====="+encounterList.size()+"encCount====="+temp_count);
						
						if(encounterList.size()==temp_count)
							doc_loop_falg="true";
           //  System.err.println("doc_loop_falg====="+doc_loop_falg);
			            hdr_data_dtl.put("doc_loop_falg",doc_loop_falg);//Adding end for KDAH-SCF-0452
						/*if( !(((String)tabData.get( "Facility_Flag" )).equals("Y"))){
							dtl_data.put("FACILITY_STR_FOR_BL",(String)tabData.get("Ordering_facility_id")+"|"+(String)tabData.get( "FACILITY_ID" ));
						}
						else{
							dtl_data.put("FACILITY_STR_FOR_BL",(String)dtl_data.get( "sal_facility_id" )+"|"+(String)tabData.get( "FACILITY_ID" ));
						}*/

						hmData.put("HDR_DATA",hdr_data_dtl);
						hmData.put("COMMON_DATA",hmCommon);
						hmData.put("DTL_DATA",(ArrayList)dtl_data.get((String) encounterList.get(encCount)));
						hmData.put("DTL_EXP_DATA",(ArrayList)exp_data.get((String) encounterList.get(encCount)));
						hmData.put("LANGUAGE_DATA",language_data);
						hmData.put("ENCLISTGROUP",tabData.get("ENCLISTGROUP"));//Added for KDAH-SCF-0452
System.err.println("====hmData===>"+hmData);
						ret_map	=	salesReturn.insertSalesReturn(connection, hmData);
						billable_trn_yn   = (String)hdr_data_dtl.get("billable_trn_yn");
						take_home_yn   = (String)hdr_data_dtl.get("take_home_yn");
						if(billable_trn_yn.equals("Y")&& disp_cash_coll_stage.equals("D") && !take_home_yn.equals("Y")){// && !patient_class.equals("I") && !patient_class.equals("D")){ //removed for SRR20056-SCF-7639 ICN027720 //patient_class condition added for [IN:045323] MMS BETA ADHOC Testing
							doc_no =(ArrayList)ret_map.get("doc_no");
							// bl_det   =    getBillingDetails(connection,(String)tabData.get( "FACILITY_ID" ),(String)tabData.get( "STORE_CODE" ),(String)ret_map.get("doc_type_code"),(String)doc_no.get(0),login_by_id,login_at_ws_no,(String)tabData.get( "PATIENT_ID" ),(String)tabData.get( "ENCOUNTER_ID" ),patient_class);
							bl_det   =    getBillingDetails(connection,(String)tabData.get("Ordering_facility_id"),(String)tabData.get( "STORE_CODE" ),(String)ret_map.get("doc_type_code"),(String)doc_no.get(0),login_by_id,login_at_ws_no,(String)tabData.get( "PATIENT_ID" ),(String)hdr_data_dtl.get("encounter_id"),patient_class); //(String)tabData.get( "ENCOUNTER_ID" ) changed to hdr_data_dtl.get("encounter_id")
						}
						if( !(((Boolean) ret_map.get( "result" )).booleanValue()) )	{
							//System.err.println("insert Sales Return failed hmData="+hmData+" ret_map="+ ret_map+" bl_det="+bl_det);		
							connection.rollback();
							errod_id=(String)ret_map.get("msgid");
							message = (String)ret_map.get("message");
							errod_id = errod_id.replace("javax.ejb.EJBException:","");
							errod_id = errod_id.replace("java.lang.Exception:","");
							message = message.replace("javax.ejb.EJBException:","");
							message = message.replace("java.lang.Exception:","");
							errod_id = errod_id.trim();
							message = message.trim();
							if(errod_id.equals(message))
								message="";
							if(!message.equals(""))
								message = "\n"+message;
							map.put( "result", blResult ) ;
							map.put( "msgid", errod_id+message) ;
							return map ;
							//throw new EJBException(message+"\n"+errod_id);//"update Sales failed"
							//throw new EJBException("insert Sales Return failed");
						}
						if(bl_det!=null && !bl_det.equals("")) //if block added (Encounter based billing detail for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 AND changed from bl_det.equals("") to !bl_det.equals("") for EMR-12.X-Alpha-PHIS-PH-Inc#2558
							bl_details.add(bl_det);
					} //END ENCOUNTER BASED HEADER FOR LOOP
				}//END IF
			}//END FOR LOOP
			//Added for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508 
			 enc_group= (ArrayList)hmData.get("ENCLISTGROUP");
			HashMap	billingmessage =	new HashMap();
			  if(enc_group!=null && enc_group.size()>0) //null handled for KDAH-SCF-0561
				enc_list =(String)enc_group.get(0);
			 // System.err.println("billable_trn_yn@@@==="+billable_trn_yn+"enc_list==="+enc_list);
			if(billable_trn_yn.equals("Y") && !enc_list.equals("") && !enc_list.equals("null")){

			//System.err.println("===============Inside st_sal_bl_recalc_proc Calling=================");
						callableStatement	= connection.prepareCall("{ call st_sal_bl_recalc_proc(?,?,?,?,?,?,?,?) }");
					
                   System.err.println("enc_group in salesReturn@@@====="+enc_group+"FACILITY_ID==="+(String)tabData.get( "FACILITY_ID" )+"PATIENT_ID==="+(String)tabData.get( "PATIENT_ID" )+"enc_list==="+enc_list+"login_at_ws_no==="+(String)tabData.get("login_at_ws_no"));

						callableStatement.setString(1,(String)tabData.get( "FACILITY_ID" ));
						callableStatement.setString(2,"PH");
						callableStatement.setString(3,(String)tabData.get( "PATIENT_ID" ));
						callableStatement.setString(4,enc_list);
						callableStatement.setString(5,(String)tabData.get("login_at_ws_no"));	
						callableStatement.registerOutParameter(6, Types.VARCHAR);
						callableStatement.registerOutParameter(7, Types.VARCHAR);
						callableStatement.registerOutParameter(8, Types.VARCHAR);
						//System.err.println("===================before calling procedure=================");
						callableStatement.execute();
						//System.err.println("===================after calling procedure================="+(String)callableStatement.getString(6));
						billingmessage.put("error_id" , (String)callableStatement.getString(6));
						billingmessage.put("error_msg" , (String)callableStatement.getString(8));
						System.err.println("StSalesReturn==error_id=======>"+((String)callableStatement.getString(6))+"<====");
						System.err.println("StSalesReturn==error_msg=======>"+((String)callableStatement.getString(8))+"<====");
						closeStatement(callableStatement);
						if((String)billingmessage.get("error_msg") != null  && (String)billingmessage.get("error_msg") !=""){
							if("BL9146".equals((String)billingmessage.get("error_id"))){//Added for MMS-DM-CRF-192.2 in 03/03/2016
								throw new Exception((String)billingmessage.get("error_msg"));
							}else{
								String msg = (String)billingmessage.get("error_id") + "  " + (String)billingmessage.get("error_msg"); 						
								throw new Exception(msg );
							}
						}
		            // }

					}//Adding end for KDAH-SCF-0469,KDAH-SCF-507 and KDAH-SCF-508  //commenting end for KDAH Live return issue on 27/01/2017

		// Stock Routing ends  
			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			map.put( "doc_no", ret_map.get("doc_no")) ;
			map.put( "flag", token_no ) ;
			map.put( "bl_det",bl_details ); //bl_det changed to bl_details (encounter based) for added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 
			map.put( "rtn_medn_no",String.valueOf(rtn_medn_no));
			connection.commit();
		}//end of try
		catch(SQLException e1){   //Added for SKR-SCF-0393 IN030939  - begin
			e1.printStackTrace();
			if(e1.getMessage().toUpperCase().contains("NOWAIT SPECIFIED")){
				map.put( "result", new Boolean( false ) ) ; 
				map.put( "msgid", "APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...") ;
				map.put("flag","0");
							System.err.println("Return Med Exception 1039==tabData="+tabData+" ==>>>>map="+map);
			}
			else{
				map.put( "result", new Boolean( false ) ) ; 
				map.put( "msgid", e1.getMessage()) ;
				map.put("flag","0");
							System.err.println("Return Med Exception 1045==tabData="+tabData+" ==>>>>map="+map);
			}
			try{
				connection.rollback();
			}
			catch(Exception ee){
				ee.printStackTrace() ;
			}
		}//Added for SKR-SCF-0393 IN030939  - end
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception in return medication" +e) ;
			System.err.println("Return Med Exception tabData="+tabData+" ==>>>>map="+map);
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
				closeResultSet( rset );
				closeResultSet( rset1 ) ;
		//		closeResultSet( resultset1 ); //ADDED FOR COMMON-ICN-0048
				closeStatement( pstmt_select2 ) ;
				closeStatement( pstmt_select3 ) ; //common-icn-0029
				closeStatement( pstmt_update1 ) ;
				closeStatement( pstmt_update2 ) ;
				closeStatement( pstmt_update3 ) ;
				closeStatement( pstmt_update4 ) ;
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_select1 ) ;
				closeStatement( pstmt_select_balQty ) ;
				closeStatement( pstmt_update1_lock ) ;
				closeStatement( pstmt_update4_lock ) ;
				closeStatement(callableStatement);//Added for KDAH-SCF-0469,KDAH-SCF-508 and KDAH-SCF-508
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}

	public String InsertTokenDetails(Connection connection,HashMap tabData ,HashMap sqlMap){
    
	    PreparedStatement pstmt_update3 = null;
		String next_token_series_no = "";
        String login_by_id				=(String) tabData.get("login_by_id");
		String login_at_ws_no			=(String) tabData.get("login_at_ws_no");
		String login_facility_id		=(String) tabData.get("FACILITY_ID");
		//String disp_locn_code			=(String)tabData.get("DISP_LOCN_CODE");
        String token_series_code		=(String)tabData.get("TOKEN_SERIES_CODE");
        String Login_disp_locn_code		=(String)tabData.get("Login_disp_locn_code");
	
		try{
			//Update Token Series...
           next_token_series_no = getNextTokenSeriesNo(connection, sqlMap,login_facility_id,Login_disp_locn_code,token_series_code,(String)tabData.get("LANGUAGEID") );

			pstmt_update3 = connection.prepareStatement( (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES") ) ;
			pstmt_update3.setString(1,login_by_id);
			pstmt_update3.setString(2,login_at_ws_no);
			pstmt_update3.setString(3,login_facility_id);
			pstmt_update3.setString(4,login_facility_id);
			pstmt_update3.setString(5,Login_disp_locn_code);
			pstmt_update3.setString(6,token_series_code);
			pstmt_update3.executeUpdate();
			closeStatement(pstmt_update3);
		}
		catch(Exception e){
			e.printStackTrace();
			next_token_series_no="";
		}
		finally{
			try {				
				closeStatement( pstmt_update3 );						
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return  next_token_series_no;
	}

	public String getNextTokenSeriesNo(Connection connection ,HashMap sqlMap,String facility_id,String disp_locn_code,String token_series_code,String language_id)throws Exception{
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String next_token_series_no="";
		try {
			pstmt = connection.prepareStatement( (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_SELECT15" ) );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			pstmt.setString(4,language_id.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				next_token_series_no=resultSet.getString("NEXT_SERIAL_NO" ) ;
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
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
		return next_token_series_no;
	}

/*public int validateForInsertUpdate(Connection connection ,HashMap sqlMap,String facility_id,String disp_locn_code,String token_series_code)throws Exception{
		
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		int insertUpdate=0;
		try {
			pstmt = connection.prepareStatement( (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_SELECT14" ) );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				if (resultSet.getInt("COUNT" )>0){
					insertUpdate	= 1;
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){es.printStackTrace();
			}
		}
		return insertUpdate;
	}*/
	private String getBillingDetails(Connection connection,String login_facility_id,String Store_code,String doc_type_code,String doc_no,String login_by_id,String login_at_ws_no,String patient_id ,String encounter_id,String patient_class ){
		HashMap message_bill  =   new HashMap();
		String p_charge_amt   =   "99999";

		//  String msg            =   "";
		String	hmResult	=	"";
		CallableStatement callableStatement = null;
		StringBuffer gross_charge_display_str  = new StringBuffer();
		try{
			callableStatement	= connection.prepareCall("{ call ST_BL_BILL_GEN (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, login_facility_id); 
			callableStatement.setString(2, Store_code);
			callableStatement.setString(3, doc_type_code+"-"+doc_no );
			callableStatement.setString(4, login_by_id);//login_by_id
			callableStatement.setString(5, login_at_ws_no);
			callableStatement.setFloat(6,  Float.parseFloat(p_charge_amt));
			callableStatement.setString(7, patient_id);
			callableStatement.setString(8, patient_class);
			callableStatement.setString(9, encounter_id);
			callableStatement.registerOutParameter(10, Types.VARCHAR);
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.VARCHAR);
			callableStatement.setString(16, "PH");
			callableStatement.setString(17,  "N");
			callableStatement.setString(19,  login_facility_id); //added for MOHE-CRF-0060
			callableStatement.registerOutParameter(18, Types.VARCHAR);
			callableStatement.execute();

			message_bill.put("l_slmt_reqd_yn" , (String)callableStatement.getString(10));
			message_bill.put("l_bill_doc_type" , (String)callableStatement.getString(11));
			message_bill.put("l_bill_doc_num" , (String)callableStatement.getString(12));
			message_bill.put("v_blng_group_id" , (String)callableStatement.getString(13));
			message_bill.put("p_call_disc_function_yn" , (String)callableStatement.getString(18)==null?"N":(String)callableStatement.getString(18));
			message_bill.put("error_id" , (String)callableStatement.getString(14));
			String err_text =(String)callableStatement.getString(15)==null?"":(String)callableStatement.getString(15);

			message_bill.put("error_id_txt" , err_text);
			/*if(((String)message_bill.get("error_msg"))!=null &&((String)message_bill.get("error_msg")) .equals("")){
				msg = (String)message_bill.get("error_id") + "  " + (String)message_bill.get("error_msg"); 
				System.err.println("error message=" + msg);
				throw new Exception(msg +"  -   doc_no:" + doc_no);
			}*/
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
			   closeStatement(callableStatement);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	    //gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("error_id_txt"));
		gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("p_call_disc_function_yn")).append(",").append((String)message_bill.get("l_slmt_reqd_yn")).append(",").append(doc_type_code+"-"+doc_no).append(",").append(patient_id).append(",").append(encounter_id).append(",").append(patient_class).append(",").append((String)message_bill.get("error_id_txt"));
		hmResult = gross_charge_display_str.toString();
		return hmResult;	
   }
	// delete method starts here
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}	// delete method ends here
}
