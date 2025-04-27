/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.TrackingOutsourceMedn ;
import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList ;
import java.util.Properties ;
import java.util.List ;
import java.util.StringTokenizer ;
import java.sql.* ;

import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="TrackingOutsourceMedn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TrackingOutsourceMedn"
*	local-jndi-name="TrackingOutsourceMedn"
*	impl-class-name="ePH.TrackingOutsourceMedn.TrackingOutsourceMednManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TrackingOutsourceMedn.TrackingOutsourceMednLocal"
*	remote-class="ePH.TrackingOutsourceMedn.TrackingOutsourceMednRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TrackingOutsourceMedn.TrackingOutsourceMednLocalHome"
*	remote-class="ePH.TrackingOutsourceMedn.TrackingOutsourceMednHome"
*	generate= "local,remote"
*
*
*/

public class TrackingOutsourceMednManager extends PhEJBSessionAdapter {
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
		PreparedStatement pstmt_update		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet					= null ;
		Properties prop         =   null;

		String patient_id			=	"";
		String login_by_id			=	"";
		String login_at_ws_no		=	"";
		String login_facility_id	=	"";
		String outSourceId = "";

		try {
			prop         =   (Properties)tabData.get( "properties" );	
			ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
			HashMap hmTrackingDetails	= (HashMap) tabData.get("hmTrackingDetails");
			String referral_facility_id = tabData.get("REFERRAL_FACILITY") == null?"":(String)tabData.get("REFERRAL_FACILITY") ;
			String tracking_remarks = tabData.get("OUTSOURCED_REMARKS")==null?"":(String)tabData.get("OUTSOURCED_REMARKS");
			String disp_locn_code = tabData.get("DISP_LOCN_CODE")==null?"":(String)tabData.get("DISP_LOCN_CODE");
			String facility_id = tabData.get("FACILITY_ID")==null?"":(String)tabData.get("FACILITY_ID");
			List patientList = new ArrayList(hmTrackingDetails.keySet());
			ArrayList alOutsourceOrders = null;
			String key, order_id="", order_line_num="";
			StringTokenizer ordIdDtl = null;

			if(mandatory_flds.size() > 1) {
				login_by_id					= (String)mandatory_flds.get(0);
				login_at_ws_no				= (String)mandatory_flds.get(1);
				login_facility_id			= (String)mandatory_flds.get(2);
			}

			String SQL_PH_OUTSOURCE_MEDN_INSERT		        = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_INSERT");
			String SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE    = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE");
			String SQL_PH_OUTSOURCE_MEDN_GET_OUTSOURCE_ID    = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_GET_OUTSOURCE_ID");

			connection			= getConnection(prop) ;
            pstmt_insert	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_INSERT) ;
            pstmt_update	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE) ;
			pstmt			= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_GET_OUTSOURCE_ID) ;
			for(int patCount=0; patCount<patientList.size(); patCount++){ 
				patient_id = (String) patientList.get(patCount);
				alOutsourceOrders = (ArrayList)hmTrackingDetails.get(patient_id);
				for(int i=0; i<alOutsourceOrders.size(); i++){
					key = (String)alOutsourceOrders.get(i);
					ordIdDtl = new StringTokenizer(key,"~");
					while(ordIdDtl.hasMoreTokens()){
						order_id	=ordIdDtl.nextToken();
						order_line_num	=ordIdDtl.nextToken();
					}

					outSourceId = "";
					resultSet		= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()){
						outSourceId=resultSet.getString("OUTSOURCE_ID");
					}
					if(outSourceId==null || outSourceId.equals("")){
						connection.rollback();
						throw new EJBException("OUTSOURCE_ID Generation Failed");
					}
					closeResultSet(resultSet);

					pstmt_insert.setString(1,facility_id);
					pstmt_insert.setString(2,outSourceId);
					pstmt_insert.setString(3,disp_locn_code);
					pstmt_insert.setString(4,patient_id);
					pstmt_insert.setString(5,order_id);
					pstmt_insert.setString(6,order_line_num);
					pstmt_insert.setString(7,login_by_id);
					pstmt_insert.setString(8,referral_facility_id);
					pstmt_insert.setString(9,tracking_remarks);
					pstmt_insert.setString(10,login_by_id);
					pstmt_insert.setString(11,login_at_ws_no);
					pstmt_insert.setString(12,login_facility_id);
					pstmt_insert.setString(13,login_by_id);
					pstmt_insert.setString(14,login_at_ws_no);
					pstmt_insert.setString(15,login_facility_id);
					pstmt_insert.addBatch();

					pstmt_update.setString(1,"SE");
					pstmt_update.setString(2,login_by_id);
					pstmt_update.setString(3,login_facility_id);
					pstmt_update.setString(4,login_at_ws_no);
					pstmt_update.setString(5,"DF");
					pstmt_update.setString(6,order_id);
					pstmt_update.setString(7,order_line_num);
					pstmt_update.addBatch();
				}
			}

			int[] result_insert= pstmt_insert.executeBatch();
			boolean insert_rec = true;
			for (int i=0;i<result_insert.length ;i++ ) {
				if(result_insert[i]<0  && result_insert[i] != -2 ){
					insert_rec=false;
					break;
				}
			}
			result_insert= pstmt_update.executeBatch();
			if(insert_rec){
				for (int i=0;i<result_insert.length ;i++ ) {
					if(result_insert[i]<0  && result_insert[i] != -2 ){
						insert_rec=false;
						break;
					}
				}
			}
			if(!insert_rec){
				connection.rollback();
			}
			else{
				connection.commit();
				map.put("flag","");
				map.put("result",insert_rec);
				map.put("msgid","RECORD_INSERTED" ) ; //RECORD_MODIFIED
			}
		}
		catch(Exception e){
			System.err.println("ERROR IN Insert OutSource Medication Details EJB tabData"+tabData);
			map.put("flag","");
			map.put("result",false);
			e.printStackTrace() ;
			try{
				connection.rollback();
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		finally{
			try{
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet );
				closeConnection( connection, prop );
				tabData.clear();
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return map;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map			= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "EJB STARTS") ;
		map.put("msgid","INSERT");
		//Properties  prop					= null;
		Connection connection				= null ;
		PreparedStatement pstmt_update_order_line		= null ;
		PreparedStatement pstmt_update_outsource_medn	= null ;
		PreparedStatement pstmt_insert_prd_dtl		= null ;
		PreparedStatement pstmt_insert_ingt_dtl		= null ;
		Properties prop         =   null;

		String login_by_id			=	"";
		String login_at_ws_no		=	"";
		String login_facility_id	=	"";
		String outSourceId = "";
		String tracking_remarks ="";
		boolean insert_rec = true;

		try {
			prop         =   (Properties)tabData.get( "properties" );	
			connection			= getConnection(prop) ;
			ArrayList mandatory_flds	= (ArrayList) tabData.get("mandatory_flds");
			HashMap hmTrackingDetails	= (HashMap) tabData.get("hmTrackingDetails");
			/*String referral_facility_id = tabData.get("REFERRAL_FACILITY") == null?"":(String)tabData.get("REFERRAL_FACILITY") ; 
			String disp_locn_code = tabData.get("DISP_LOCN_CODE")==null?"":(String)tabData.get("DISP_LOCN_CODE"); UnusedLocal variable 63877*/ //COMMENTED FOR COMMON-ICN-0048
			String facility_id = tabData.get("FACILITY_ID")==null?"":(String)tabData.get("FACILITY_ID");
			String trackingAction = tabData.get("TRACKING_ACTION")==null?"":(String)tabData.get("TRACKING_ACTION");
			List outsourceIdList = new ArrayList(hmTrackingDetails.keySet());
			HashMap hmTrackingDetail =null;
			ArrayList alingredients = null;
			ArrayList alProductDtls = null;
			String key, order_id="", order_line_num="";
			StringTokenizer ordIdDtl = null;

			if(mandatory_flds.size() > 1) {
				login_by_id					= (String)mandatory_flds.get(0);
				login_at_ws_no				= (String)mandatory_flds.get(1);
				login_facility_id			= (String)mandatory_flds.get(2);
			}
			if(trackingAction.equals("R")){
				tracking_remarks = tabData.get("RECEIVEED_REMARKS")==null?"":(String)tabData.get("RECEIVEED_REMARKS");

				String SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE    = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE");
				String SQL_PH_OUTSOURCE_MEDN_UPDATE		        = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_UPDATE");
				String SQL_PH_OUTSOURCE_MEDN_PRD_DTL_INSERT   = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_PRD_DTL_INSERT");
				String SQL_PH_OUTSOURCE_MEDN_INGR_DTL_INSERT   = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_INGR_DTL_INSERT");

				pstmt_update_order_line	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE) ;
				pstmt_update_outsource_medn	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_UPDATE) ;
				pstmt_insert_prd_dtl	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_PRD_DTL_INSERT) ;
				pstmt_insert_ingt_dtl	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_INGR_DTL_INSERT) ;
				for(int recCount=0; recCount<outsourceIdList.size(); recCount++){ 
					key = (String) outsourceIdList.get(recCount);
					alProductDtls = (ArrayList)hmTrackingDetails.get(key);
					ordIdDtl = new StringTokenizer(key,"~");
					while(ordIdDtl.hasMoreTokens()){
						outSourceId	=ordIdDtl.nextToken();
						order_id	=ordIdDtl.nextToken();
						order_line_num	=ordIdDtl.nextToken();
					}

					pstmt_update_outsource_medn.setString(1,login_by_id);
					pstmt_update_outsource_medn.setString(2,tracking_remarks);
					pstmt_update_outsource_medn.setString(3,login_by_id);
					pstmt_update_outsource_medn.setString(4,login_at_ws_no);
					pstmt_update_outsource_medn.setString(5,login_facility_id);
					pstmt_update_outsource_medn.setString(6,facility_id);
					pstmt_update_outsource_medn.setString(7,outSourceId);
					pstmt_update_outsource_medn.addBatch();

					pstmt_update_order_line.setString(1,"RC");
					pstmt_update_order_line.setString(2,login_by_id);
					pstmt_update_order_line.setString(3,login_facility_id);
					pstmt_update_order_line.setString(4,login_at_ws_no);
					pstmt_update_order_line.setString(5,"SE");
					pstmt_update_order_line.setString(6,order_id);
					pstmt_update_order_line.setString(7,order_line_num);
					pstmt_update_order_line.addBatch();

					for(int i=0; i<alProductDtls.size(); i++){
						hmTrackingDetail = (HashMap)alProductDtls.get(i);

						pstmt_insert_prd_dtl.setString(1,facility_id);
						pstmt_insert_prd_dtl.setString(2,outSourceId);
						pstmt_insert_prd_dtl.setString(3, (String)hmTrackingDetail.get("srlNo"));
						pstmt_insert_prd_dtl.setString(4, (String)hmTrackingDetail.get("productId"));
						pstmt_insert_prd_dtl.setString(5, (String)hmTrackingDetail.get("productName"));
						pstmt_insert_prd_dtl.setString(6, (String)hmTrackingDetail.get("batchId"));
						pstmt_insert_prd_dtl.setString(7, (String)hmTrackingDetail.get("expiryDate"));
						pstmt_insert_prd_dtl.setString(8, (String)hmTrackingDetail.get("quantity"));
						pstmt_insert_prd_dtl.setString(9, (String)hmTrackingDetail.get("quantityUOM"));
						pstmt_insert_prd_dtl.setString(10,(String)hmTrackingDetail.get("remarks"));
						pstmt_insert_prd_dtl.setString(11,login_by_id);
						pstmt_insert_prd_dtl.setString(12,login_at_ws_no);
						pstmt_insert_prd_dtl.setString(13,login_facility_id);
						pstmt_insert_prd_dtl.setString(14,login_by_id);
						pstmt_insert_prd_dtl.setString(15,login_at_ws_no);
						pstmt_insert_prd_dtl.setString(16,login_facility_id);
						pstmt_insert_prd_dtl.addBatch();

						alingredients = (ArrayList)hmTrackingDetail.get("ingredients");
						if(alingredients!=null && alingredients.size()>0){
							for(int ing=0; ing<alingredients.size(); ing++){
								pstmt_insert_ingt_dtl.setString(1,facility_id);
								pstmt_insert_ingt_dtl.setString(2,outSourceId);
								pstmt_insert_ingt_dtl.setString(3, (String)hmTrackingDetail.get("srlNo"));
								pstmt_insert_ingt_dtl.setString(4, (String)hmTrackingDetail.get("productId"));
								pstmt_insert_ingt_dtl.setString(5, (ing+1)+"");
								pstmt_insert_ingt_dtl.setString(6, (String)alingredients.get(ing));
								pstmt_insert_ingt_dtl.setString(7,login_by_id);
								pstmt_insert_ingt_dtl.setString(8,login_at_ws_no);
								pstmt_insert_ingt_dtl.setString(9,login_facility_id);
								pstmt_insert_ingt_dtl.setString(10,login_by_id);
								pstmt_insert_ingt_dtl.setString(11,login_at_ws_no);
								pstmt_insert_ingt_dtl.setString(12,login_facility_id);
								pstmt_insert_ingt_dtl.addBatch();
							}
						}
					}
				}

				int[] result_insert= pstmt_update_outsource_medn.executeBatch();
				for (int i=0;i<result_insert.length ;i++ ) {
					if(result_insert[i]<0  && result_insert[i] != -2 ){
						insert_rec=false;
						break;
					}
				}
				result_insert= pstmt_update_order_line.executeBatch();
				if(insert_rec){
					for (int i=0;i<result_insert.length ;i++ ) {
						if(result_insert[i]<0  && result_insert[i] != -2 ){
							insert_rec=false;
							break;
						}
					}
				}
				result_insert= pstmt_insert_prd_dtl.executeBatch();
				if(insert_rec){
					for (int i=0;i<result_insert.length ;i++ ) {
						if(result_insert[i]<0  && result_insert[i] != -2 ){
							insert_rec=false;
							break;
						}
					}
				}
				result_insert= pstmt_insert_ingt_dtl.executeBatch();
				if(insert_rec){
					for (int i=0;i<result_insert.length ;i++ ) {
						if(result_insert[i]<0  && result_insert[i] != -2 ){
							insert_rec=false;
							break;
						}
					}
				}
			}
			else if(trackingAction.equals("D")){
				tracking_remarks = tabData.get("DELIVER_REMARKS")==null?"":(String)tabData.get("DELIVER_REMARKS");
				HashMap hmDeliverDtls = null;

				String SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE    = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE");
				String SQL_PH_OUTSOURCE_MEDN_UPDATE		        = (String) sqlMap.get( "SQL_PH_OUTSOURCE_MEDN_UPDATE");

				pstmt_update_order_line	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE) ;
				pstmt_update_outsource_medn	= connection.prepareStatement(SQL_PH_OUTSOURCE_MEDN_UPDATE) ;
				for(int recCount=0; recCount<outsourceIdList.size(); recCount++){ 
					key = (String) outsourceIdList.get(recCount);
					hmDeliverDtls = (HashMap)hmTrackingDetails.get(key);
					ordIdDtl = new StringTokenizer(key,"~");
					while(ordIdDtl.hasMoreTokens()){
						outSourceId	=ordIdDtl.nextToken();
						order_id	=ordIdDtl.nextToken();
						order_line_num	=ordIdDtl.nextToken();
					}

					pstmt_update_outsource_medn.setString(1,login_by_id);
					pstmt_update_outsource_medn.setString(2,(String)hmDeliverDtls.get("DELIVERED_TO_IND"));  
					pstmt_update_outsource_medn.setString(3,(String)hmDeliverDtls.get("DELIVERED_TO"));
					pstmt_update_outsource_medn.setString(4,(String)hmDeliverDtls.get("DELIVERED_SOURCE_CODE"));
					pstmt_update_outsource_medn.setString(5,login_by_id);
					pstmt_update_outsource_medn.setString(6,login_at_ws_no);
					pstmt_update_outsource_medn.setString(7,login_facility_id);
					pstmt_update_outsource_medn.setString(8,facility_id);
					pstmt_update_outsource_medn.setString(9,outSourceId);
					pstmt_update_outsource_medn.addBatch();

					pstmt_update_order_line.setString(1,"IS");
					pstmt_update_order_line.setString(2,login_by_id);
					pstmt_update_order_line.setString(3,login_facility_id);
					pstmt_update_order_line.setString(4,login_at_ws_no);
					pstmt_update_order_line.setString(5,"RC");
					pstmt_update_order_line.setString(6,order_id);
					pstmt_update_order_line.setString(7,order_line_num);
					pstmt_update_order_line.addBatch();
				}
				int[] result_insert= pstmt_update_outsource_medn.executeBatch();
				for (int i=0;i<result_insert.length ;i++ ) {
					if(result_insert[i]<0  && result_insert[i] != -2 ){
						insert_rec=false;
						break;
					}
				}
				result_insert= pstmt_update_order_line.executeBatch();
				if(insert_rec){
					for (int i=0;i<result_insert.length ;i++ ) {
						if(result_insert[i]<0  && result_insert[i] != -2 ){
							insert_rec=false;
							break;
						}
					}
				}
			}

			if(!insert_rec){
				connection.rollback();
			}
			else{
				connection.commit();
				map.put("flag","");
				map.put("result",insert_rec);
				map.put("msgid","RECORD_MODIFIED" ) ; //RECORD_MODIFIED
			}
		}
		catch(Exception e){
			System.err.println("ERROR IN Update OutSource Medication Details EJB tabData"+tabData);
			map.put("flag","");
			map.put("result",false);
			e.printStackTrace() ;
			try{
				connection.rollback();
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		finally{
			try{
				closeStatement( pstmt_update_order_line ) ;
				closeStatement( pstmt_update_outsource_medn ) ;
				closeStatement( pstmt_insert_prd_dtl ) ;
				closeStatement( pstmt_insert_ingt_dtl ) ;
		
				closeConnection( connection, prop );
				tabData.clear();
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return map;	}
	
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
