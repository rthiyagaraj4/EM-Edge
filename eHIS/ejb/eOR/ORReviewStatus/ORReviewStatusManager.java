/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORReviewStatus ;
import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;

import javax.ejb.* ;
import javax.transaction.* ;

/**
*
* @ejb.bean
*	name="ORReviewStatus"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORReviewStatus"
*	local-jndi-name="ORReviewStatus"
*	impl-class-name="eOR.ORReviewStatus.ORReviewStatusManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORReviewStatus.ORReviewStatusLocal"
*	remote-class="eOR.ORReviewStatus.ORReviewStatusRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORReviewStatus.ORReviewStatusLocalHome"
*	remote-class="eOR.ORReviewStatus.ORReviewStatusHome"
*	generate= "local,remote"
*
*
*/

public class ORReviewStatusManager extends OrEJBSessionAdapter {

//	SessionContext context ;
//	Connection connection = null ;
	PreparedStatement pstmt = null ;

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify(HashMap tabDataParam , HashMap sqlMap )  {
	StringBuffer messages =  null ;
	StringBuffer traceVal =  null ;
	HashMap map =null;
	Connection connection =  null ;
	PreparedStatement pstmt_order	    	= null ;
	PreparedStatement pstmt_order_l	    	= null ;
	PreparedStatement pstmt_line		    = null ;
	Properties  pt = null;
	String task_type = "";
		try
		{
			messages = new StringBuffer() ;
			traceVal = new StringBuffer() ;
			map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "flag" ) ;

			traceVal.append("----- UPDATE CALLED -----");

			HashMap tabData = (HashMap)tabDataParam.get("tabData");
			pt = (Properties)tabDataParam.get("properties");

			ArrayList lineRecords = (ArrayList)tabData.get("lineRecords");
			Hashtable allValues = (Hashtable)tabData.get("allValues");

			int update_order = 0;
			int update_order_l = 0;
			int update_line[] = {};

			boolean   update_line_flag = false ;

			traceVal.append("1");

			connection = getConnection(pt) ;


			String SQL_OR_REVIEW_STATUS_ORDER_UPDATE	= (String)sqlMap.get("SQL_OR_REVIEW_STATUS_ORDER_UPDATE");
			String SQL_OR_REVIEW_STATUS_LINE_UPDATE	= (String)sqlMap.get("SQL_OR_REVIEW_STATUS_LINE_UPDATE");
			String SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE = (String)sqlMap.get("SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE");

			pstmt_order = connection.prepareStatement(SQL_OR_REVIEW_STATUS_ORDER_UPDATE);
			pstmt_order_l = connection.prepareStatement(SQL_OR_REVIEW_STATUS_LINE_UPDATE);
			pstmt_line = connection.prepareStatement(SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE);
			traceVal.append("2");

			task_type = (String)allValues.get("task_type");
			if(task_type.trim().equalsIgnoreCase("UpdateOrder"))
			{
				pstmt_order.setString(1, (String)allValues.get("order_status"));
				pstmt_order.setString(2, (String)allValues.get("orderRemark"));
				pstmt_order.setString(3, (String)allValues.get("login_by_id"));
				pstmt_order.setString(4, (String)allValues.get("login_at_ws_no"));
				pstmt_order.setString(5, (String)allValues.get("login_facility_id"));
				pstmt_order.setString(6, (String)allValues.get("order_id"));
				update_order = pstmt_order.executeUpdate();

				pstmt_order_l.setString(1, (String)allValues.get("order_status"));
				pstmt_order_l.setString(2, (String)allValues.get("orderRemark"));
				pstmt_order_l.setString(3, (String)allValues.get("login_by_id"));
				pstmt_order_l.setString(4, (String)allValues.get("login_at_ws_no"));
				pstmt_order_l.setString(5, (String)allValues.get("login_facility_id"));
				pstmt_order_l.setString(6, (String)allValues.get("order_id"));
				update_order_l = pstmt_order_l.executeUpdate();
				if (update_order >= 1 && update_order_l >= 1)
				{
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append("RECORD_MODIFIED") ;
				}else
				{
					connection.rollback();
					messages.append( "Update Failed" ) ;
				}
			}
			else
			{
				int sizeDetail	= lineRecords.size()  ;
				for (int i=0;i<sizeDetail;i++)
				{
					HashMap lineRecord = (HashMap)lineRecords.get(i);
					traceVal.append("-3a-");
					traceVal.append((String)allValues.get("order_id")+","+(String)lineRecord.get("orderLineNum")+","+(String)lineRecord.get("lineStatus")+"-");
					pstmt_line.setString(1, (String)lineRecord.get("lineStatus"));
					pstmt_line.setString(2, (String)lineRecord.get("lineStatusRemark"));
					pstmt_line.setString(3, (String)allValues.get("login_by_id"));
					pstmt_line.setString(4, (String)allValues.get("login_at_ws_no"));
					pstmt_line.setString(5, (String)allValues.get("login_facility_id"));
					pstmt_line.setString(6, (String)allValues.get("order_id"));
					pstmt_line.setString(7, (String)lineRecord.get("orderLineNum"));
					pstmt_line.addBatch();
				}
				update_line = pstmt_line.executeBatch();
				traceVal.append("3b");

				if((update_line.length > 0)) //check updation in SYN
					update_line_flag = true;
				else if((update_line.length == (-3)))
					update_line_flag = false;

				if (update_line_flag)
				{
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append("RECORD_MODIFIED") ;
				}else
				{
					connection.rollback();
					messages.append( "Update Failed" ) ;
				}
			}

		}
		catch( Exception e )
		{
			traceVal.append("In Exception==");
			e.printStackTrace();
			traceVal.append(e);
			traceVal.append("#"+e.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;

			try {
				connection.rollback();
			//	closeConnection( connection,pt);
				} catch ( Exception ee ) {
					messages.append(ee.getMessage() ) ;
				}
				messages.append( e.getMessage() ) ;
				System.err.println(e.getMessage());
				e.printStackTrace() ;
		}
		finally
		{
			try {
				closeStatement( pstmt ) ;
				closeStatement( pstmt_order ) ;
				closeStatement( pstmt_order_l ) ;
				closeStatement( pstmt_line ) ;
				closeConnection( connection,pt);
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
		return map ;
	}//End of modify Method

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData, HashMap sqlMap )   {

		HashMap map					 = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", new Boolean( false ) ) ;
		return map ;

	}// End of Insert Method

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
		public HashMap delete( HashMap tabData, HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", new Boolean( false ) ) ;
		return map;
	}
} // End of Class
