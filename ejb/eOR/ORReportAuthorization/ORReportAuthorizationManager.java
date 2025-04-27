/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
23/10/2019    	IN071315	    Nijitha S  		GHL-CRF-0607
--------------------------------------------------------------------------------------------------------------------
*/ 
package eOR.ORReportAuthorization;

import java.rmi.*;
import java.util.*;
import java.sql.*;
import eOR.Common.*;
import javax.ejb.*;
import javax.transaction.*;

import webbeans.eCommon.*;

/**
 *
 * @ejb.bean
 *	name="ORReportAuthorization"
 *	type="Stateless"
 *	transaction-type="Bean"
 *	view-type="both"
 *	jndi-name="ORReportAuthorization"
 *	local-jndi-name="ORReportAuthorization"
 *	impl-class-name="eOR.ORReportAuthorization.ORReportAuthorizationManager"
 *	
 *
 * @ejb.interface
 *	extends="javax.ejb.EJBObject"
 *	local-extends="javax.ejb.EJBLocalObject" 
 *	local-class="eOR.ORReportAuthorization.ORReportAuthorizationLocal"
 *	remote-class="eOR.ORReportAuthorization.ORReportAuthorizationRemote"
 *	generate= "local,remote"
 *
 * @ejb.home
 *	extends="javax.ejb.EJBHome" 
 *	local-extends="javax.ejb.EJBLocalHome"
 *	local-class="eOR.ORReportAuthorization.ORReportAuthorizationLocalHome"
 *	remote-class="eOR.ORReportAuthorization.ORReportAuthorizationHome"
 *	generate= "local,remote"
 *
 *
 */
public class ORReportAuthorizationManager extends OrEJBSessionAdapter 
{
    //  	StringBuffer messages = new StringBuffer() ;
//	StringBuffer traceVal = new StringBuffer() ;

    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap insert(HashMap tabDataParam, HashMap sqlMap) 
	{
        StringBuffer messages					= null;
        StringBuffer traceVal					= null;
        HashMap map								= null;
        Connection connection					= null;
        Properties pt							= null;

        PreparedStatement pstmt_res_hdr			= null;
        PreparedStatement pstmt_res_dtl			= null;
        PreparedStatement pstmt_ord				= null;
        PreparedStatement pstmt_ord_line		= null;
        PreparedStatement pstmt_ord_status		= null;
        PreparedStatement pstmt_parent_order	= null;
        PreparedStatement pstmt_parent_ord		= null;
        PreparedStatement pstmt_parent_ord_line = null;
        PreparedStatement pstmt_upd_ord_status	= null;
        CallableStatement cstmt					= null;
        ResultSet rs							= null;
        ResultSet rs_order						= null;
        ResultSet rs_ord						= null;
        ResultSet ord_status_resultset			= null;
        // ResultSet rs_ord_line								= null;
        int rs_orders[] = {};
        int rs_orders_line[] = {};

        try 
		{
            messages = new StringBuffer();
            traceVal = new StringBuffer();
            map = new HashMap();
            map.put("result", new Boolean(false));
            map.put("flag", "flag");

            HashMap tabData_p = (HashMap) tabDataParam.get("tabData");

            pt = (Properties) tabDataParam.get("properties");

            String login_by_id = (String) tabData_p.get("login_by_id");
            String login_at_ws_no = (String) tabData_p.get("login_at_ws_no");
            String login_facility_id = (String) tabData_p.get("login_facility_id");
            ArrayList parameters = (ArrayList) tabData_p.get("parameters");

            connection = getConnection(pt);
			connection.setAutoCommit( false ) ;

            String SQL_OR_REPORT_AUTH_RES_HDR_UPDATE = (String) sqlMap.get("SQL_OR_REPORT_AUTH_RES_HDR_UPDATE");
            String SQL_OR_REPORT_AUTH_RES_DTL_UPDATE = (String) sqlMap.get("SQL_OR_REPORT_AUTH_RES_DTL_UPDATE");
            String SQL_OR_REPORT_AUTH_ORD_UPDATE = (String) sqlMap.get("SQL_OR_REPORT_AUTH_ORD_UPDATE");
            String SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE = (String) sqlMap.get("SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE");
            String SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A = (String) sqlMap.get("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A");
            String SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY = (String) sqlMap.get("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY");
            String SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS = (String) sqlMap.get("SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS");
            String SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS_STATUS = (String) sqlMap.get("SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS_STATUS");
            String SQL_OR_REPORT_AUTHORIZATION_UPDATE_PARENT_ORDER_LINE = (String) sqlMap.get("SQL_OR_REPORT_AUTHORIZATION_UPDATE_PARENT_ORDER_LINE");
            String SQL_OR_REPORT_SELECT_REPORT_AUTH_RES_STATUS = (String) sqlMap.get("SQL_OR_REPORT_SELECT_REPORT_AUTH_RES_STATUS");

            pstmt_res_hdr = connection.prepareStatement(SQL_OR_REPORT_AUTH_RES_HDR_UPDATE);
            pstmt_res_dtl = connection.prepareStatement(SQL_OR_REPORT_AUTH_RES_DTL_UPDATE);
            pstmt_ord = connection.prepareStatement(SQL_OR_REPORT_AUTH_ORD_UPDATE);
            pstmt_ord_line = connection.prepareStatement(SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE);
            pstmt_parent_order = connection.prepareStatement(SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS);
            pstmt_parent_ord = connection.prepareStatement(SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS_STATUS);
            pstmt_parent_ord_line = connection.prepareStatement(SQL_OR_REPORT_AUTHORIZATION_UPDATE_PARENT_ORDER_LINE);
            pstmt_upd_ord_status = connection.prepareStatement(SQL_OR_REPORT_SELECT_REPORT_AUTH_RES_STATUS);

            cstmt = connection.prepareCall("{ " + (String) sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") + " }");

            int update_res_hdr[]				= {};
            int update_res_dtl[]				= {};
            int update_ord[]					= {};
            int update_ord_line[]				= {};

            int counterRes = 0;//to chk there is any batch add for order and order line updation

            //Billing related parameters - start
            String p_facility_id				= "";
            String p_order_id					= "";
            String p_order_line_num				= "";
            String p_mode						= "RST";
            String p_user						= "";
            String p_ws_no						= "";
            //String p_bill_yn		= "";
            String p_error_message				= "";
            //int pr_order_status_cnt				= 0;//15950
            ArrayList<String> orderList			= new ArrayList<String>();
            String header_order_id				= "";
			String order_status_code		= "";//from Query
            //Billing related parameters - end

            for (int i = 0; i < parameters.size(); i++) 
			{

                HashMap currRec = (HashMap) parameters.get(i);

                String result_type				= (String) currRec.get("result_type");
                String result_status		    = (String) currRec.get("result_status");
                String order_set_id				= (String) currRec.get("order_set_id");
                String order_set_bill_yn		= (String) currRec.get("order_set_bill_yn");
                String bill_yn					= (String) currRec.get("bill_yn");
                int report_srl_no				= Integer.parseInt((String) currRec.get("report_srl_no"));            

                p_order_id						= (String) currRec.get("order_id");

                //Added by Sridhar Reddy to fix IN021831 for updating pending report authorization for order header level.

                if (!orderList.contains(p_order_id)) 
				{
                    orderList.add(p_order_id);
                }

                p_facility_id					= login_facility_id;
                p_user							= login_by_id;
                p_ws_no							= login_at_ws_no;
                int result = 0;

                //Billing Procedure - Start
                //cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
                if (((bill_yn.equalsIgnoreCase("Y")) || (order_set_bill_yn.equalsIgnoreCase("Y")))) 
				{
                    cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
                    if ((order_set_bill_yn.equalsIgnoreCase("Y")) && (!(order_set_id.equals("")))) 
					{
                        cstmt.setString(2, order_set_id);						// P_ORDER_ID
                        cstmt.setString(3, "1");				// P_ORDER_LINE_NUM
                    } 
					else 
					{
                        cstmt.setString(2, p_order_id);						// P_ORDER_ID
                        cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
                    }
                    cstmt.setString(4, p_mode); 						// P_MODE
                    cstmt.setString(5, p_user);							// P_USER
                    cstmt.setString(6, p_ws_no);						// P_WS_NO
                    cstmt.registerOutParameter(7, Types.VARCHAR); 	// P_BILL_YN
                    cstmt.registerOutParameter(8, Types.VARCHAR); 	// P_ERROR_MESSAGE
                    cstmt.setString(9, "OR"); //IN071315
                    cstmt.execute();
                    p_error_message = cstmt.getString(8);  // message

                    if (p_error_message != null && !p_error_message.equals("")) 
					{
                        result = 0;
                    } else {
                        result = 1;
                    }

                    if (result < 1) 
					{
                        //traceVals.append("====ROLLBACK");
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", p_error_message);
                        return map;
                    }
                }
                //Billing Procedure - End

                if (result_type.equalsIgnoreCase("A")) 
				{
                    pstmt_ord_status = connection.prepareStatement(SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A);
                } 
				else 
				{
                    pstmt_ord_status = connection.prepareStatement(SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY);
                }

                /**Result Header**/
                /*sql=UPDATE OR_RESULT_HEADER SET AUTH_BY_ID=? ,
                AUTH_DATE_TIME = 'SYSDATE' WHERE ORDER_ID = ? AND REPORT_SRL_NO = ? */
                pstmt_res_hdr.setString(1, (String) currRec.get("practitioner_id"));
                pstmt_res_hdr.setString(2, login_by_id);
                pstmt_res_hdr.setString(3, login_at_ws_no);
                pstmt_res_hdr.setString(4, login_facility_id);
                pstmt_res_hdr.setString(5, (String) currRec.get("order_id"));
                pstmt_res_hdr.setInt(6, report_srl_no);
                pstmt_res_hdr.addBatch();

                /**Result Detail**/
                /*sql=UPDATE OR_RESULT_DETAIL SET AUTH_BY_ID=? ,
                AUTH_DATE_TIME = 'SYSDATE' WHERE ORDER_ID = ? AND REPORT_SRL_NO = ?
                AND AUTH_REQD_YN = 'Y' AND
                AUTH_DATE_TIME IS NULL AND AUTH_BY_ID IS NULL*/
                pstmt_res_dtl.setString(1, (String) currRec.get("practitioner_id"));
                pstmt_res_dtl.setString(2, login_by_id);
                pstmt_res_dtl.setString(3, login_at_ws_no);
                pstmt_res_dtl.setString(4, login_facility_id);
                pstmt_res_dtl.setString(5, (String) currRec.get("order_id"));
                pstmt_res_dtl.setInt(6, report_srl_no);
                pstmt_res_dtl.addBatch();

                if (!result_status.trim().equalsIgnoreCase("") && !result_status.trim().equalsIgnoreCase("null")) 
				{

                    counterRes++;

                    rs = pstmt_ord_status.executeQuery();
                    if (rs.next()) 
					{
                        order_status_code = rs.getString("order_status_code");
                    }
                    closeStatement(pstmt_ord_status);
                    closeResultSet(rs);
                    /**order**/
                    /*pstmt_ord.setString(1, order_status_code);
                    pstmt_ord.setString(2,(String)currRec.get("result_status"));
                    pstmt_ord.setString(3,login_by_id);
                    pstmt_ord.setString(4,login_at_ws_no);
                    pstmt_ord.setString(5,login_facility_id);
                    pstmt_ord.setString(6,(String)currRec.get("order_id"));
                    pstmt_ord.addBatch();*/
                    /**order Line**/
                    /*sql=UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = ? ,
                    RESULT_LINE_STATUS=? WHERE ORDER_ID=? AND (ORDER_ID||ORDER_LINE_NUM)
                    IN (SELECT (ORDER_ID||LINE_SRL_NO) FROM OR_RESULT_DETAIL WHERE
                    ORDER_ID=? AND REPORT_SRL_NO = ? AND AUTH_BY_ID=? AND
                    AUTH_REQD_YN = 'Y' AND AUTH_DATE_TIME IS NULL AND AUTH_BY_ID
                    IS NULL AND ROWNUM <=1)*/

                    pstmt_ord_line.setString(1, order_status_code);
                    pstmt_ord_line.setString(2, order_status_code);
                    pstmt_ord_line.setString(3, login_by_id);
                    pstmt_ord_line.setString(4, login_at_ws_no);
                    pstmt_ord_line.setString(5, login_facility_id);
                    pstmt_ord_line.setString(6, (String) currRec.get("order_id"));
                    pstmt_ord_line.setString(7, (String) currRec.get("order_id"));
                    pstmt_ord_line.setString(8, (String) currRec.get("report_srl_no"));
                    //pstmt_ord_line.setString(6,(String)currRec.get("practitioner_id"));
                    pstmt_ord_line.addBatch();


                }	 //updation only if result status = 3

            } //End of no of Recds

            //update_res_hdr = pstmt_res_hdr.executeBatch();
            //update_res_dtl = pstmt_res_dtl.executeBatch();


            if (counterRes > 0) 
			{
				update_ord_line = pstmt_ord_line.executeBatch();
                if (orderList != null && orderList.size() > 0) 
				{
                    for (int hordercnt = 0; hordercnt < orderList.size(); hordercnt++) 
					{
                        header_order_id = (String) orderList.get(hordercnt);
						pstmt_upd_ord_status.setString(1,header_order_id);
						ord_status_resultset = pstmt_upd_ord_status.executeQuery();

						while(ord_status_resultset!=null&&ord_status_resultset.next())
						{
							order_status_code = ord_status_resultset.getString("header_order_status");
						}

						pstmt_ord.setString(1, order_status_code);
						pstmt_ord.setString(2, order_status_code);
						pstmt_ord.setString(3, login_by_id);
						pstmt_ord.setString(4, login_at_ws_no);
						pstmt_ord.setString(5, login_facility_id);
						pstmt_ord.setString(6, header_order_id);
						pstmt_ord.addBatch();
						if (ord_status_resultset != null)ord_status_resultset.close();//Checkstyle
						
                    }
                }				
            
				update_ord = pstmt_ord.executeBatch();

				if (ord_status_resultset != null)ord_status_resultset.close();//15950
				closeStatement(pstmt_upd_ord_status);
				//closeResultSet(ord_status_resultset);			

//				for (int i = 0;i < update_ord_line.length;i++) {
				/*Added by Uma for Child Orders*/

                for (int i = 0; i < parameters.size(); i++) 
				{
                    HashMap currRec = (HashMap) parameters.get(i);
                    String parent_order_id = "";
                    String parent_order_line_no = "";
                    String ord_stat_code = "";
                    String order_Id = (String) currRec.get("order_id");
                    String order_Line_no = (String) currRec.get("report_srl_no");
                    pstmt_parent_order.clearParameters();
                    pstmt_parent_order.setString(1, order_Id.trim());
                    pstmt_parent_order.setString(2, order_Line_no.trim());
                    rs_order = pstmt_parent_order.executeQuery();

					if (rs_order != null) 
					{
                        while ((rs_order != null) && (rs_order.next())) 
						{
                            parent_order_id = (String) rs_order.getString("parent_order_id") == null ? "" : (String) rs_order.getString("parent_order_id");
                            parent_order_line_no = (String) rs_order.getString("parent_order_line_num") == null ? "" : (String) rs_order.getString("parent_order_line_num");
                        }
                    }
                    closeResultSet(rs_order);

                    if ((parent_order_id != null) && !(parent_order_id.trim().equals(""))) 
					{
                        pstmt_parent_ord.clearParameters();
                        pstmt_parent_ord.setString(1, parent_order_id.trim());
                        rs_ord = pstmt_parent_ord.executeQuery();
                        while ((rs_ord != null) && (rs_ord.next())) 
						{
                            ord_stat_code = (String) rs_ord.getString("parent_order_status") == null ? "" : (String) rs_ord.getString("parent_order_status");
                        }
                        closeResultSet(rs_ord);
                        if (ord_stat_code != null && !ord_stat_code.trim().equals("")) 
						{
                            pstmt_ord.clearParameters();
                            pstmt_ord.setString(1, ord_stat_code.trim());
                            pstmt_ord.setString(2, ord_stat_code.trim());
                            pstmt_ord.setString(3, login_by_id);
                            pstmt_ord.setString(4, login_at_ws_no);
                            pstmt_ord.setString(5, login_facility_id);
                            pstmt_ord.setString(6, parent_order_id.trim());
                            pstmt_ord.addBatch();
                            pstmt_parent_ord_line.clearParameters();
                            pstmt_parent_ord_line.setString(1, ord_stat_code.trim());
                            pstmt_parent_ord_line.setString(2, ord_stat_code.trim());
                            pstmt_parent_ord_line.setString(3, login_by_id);
                            pstmt_parent_ord_line.setString(4, login_at_ws_no);
                            pstmt_parent_ord_line.setString(5, login_facility_id);
                            pstmt_parent_ord_line.setString(6, parent_order_id.trim());
                            pstmt_parent_ord_line.setString(7, parent_order_line_no.trim());
                            pstmt_parent_ord_line.addBatch();

                        }
                        rs_orders = pstmt_ord.executeBatch();
                        rs_orders_line = pstmt_parent_ord_line.executeBatch();
                    }

                }
//				}/*Ends Here Added by Uma*/
            }

            update_res_hdr = pstmt_res_hdr.executeBatch();
            update_res_dtl = pstmt_res_dtl.executeBatch();

            boolean update_res_hdr_status = false;
            boolean update_res_dtl_status = false;
            boolean update_ord_status = false;
            boolean update_ord_line_status = false;

            if ((update_res_hdr.length > 0)) 
			{
                update_res_hdr_status = true;
            } 
			else if ((update_res_hdr.length == (-3))) 
			{
                update_res_hdr_status = false;
            }


            if ((update_res_dtl.length > 0)) 
			{
                update_res_dtl_status = true;
            } 
			else if ((update_res_dtl.length == (-3))) 
			{
                update_res_dtl_status = false;
            }

            if (counterRes > 0)
			{
                if ((update_ord.length > 0)) 
				{
                    update_ord_status = true;
                } 
				else if ((update_ord.length == (-3))) 
				{
                    update_ord_status = false;
                }

                if ((update_ord_line.length > 0)) 
				{
                    update_ord_line_status = true;
                } 
				else if ((update_ord_line.length == (-3))) 
				{
                    update_ord_line_status = false;
                }

            } 
			else 
			{ //No updation only assumption
                update_ord_status = true;
                update_ord_line_status = true;
            }
            closeStatement(pstmt_parent_order);
            closeStatement(pstmt_parent_ord);
            closeStatement(pstmt_parent_ord_line);

            if (update_res_hdr_status && update_res_dtl_status && update_ord_status && update_ord_line_status) 
			{
                connection.commit();
                map.put("result", new Boolean(true));
                messages.append("RECORD_INSERTED");
            } 
			else
			{
                connection.rollback();
                messages.append("Insert Failed");
            }

        } 
		catch (Exception e) 
		{
            traceVal.append("In Exception==");
            e.printStackTrace();
            traceVal.append(e.getMessage());
            map.put("traceVal", traceVal.toString());

            try 
			{
                connection.rollback();
                closeConnection(connection, pt);
                //	closeConnection(connection);
            } 
			catch (Exception ee) 
			{
                messages.append(ee.getMessage());
            }
            messages.append(e.getMessage());
            e.printStackTrace();

        } 
		finally
		{
            try 
			{
                closeStatement(pstmt_res_hdr);
                closeStatement(pstmt_res_dtl);
                closeStatement(pstmt_ord);
                closeStatement(pstmt_ord_line);
                closeStatement(pstmt_ord_status);
                closeStatement(cstmt);
                closeResultSet(rs);
                closeConnection(connection, pt);
                //		closeConnection(connection);
            }
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }

        map.put("message", messages.toString());
        map.put("traceVal", traceVal.toString());
        return map;
    }//End of Insert Method

    /****************************************************************************/
    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap modify(HashMap tabDataParam, HashMap sqlMap) 
	{
        StringBuffer messages = new StringBuffer();
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));
        map.put("message", messages.toString());

        return map;

    }

    /*****************************************************************************/
    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap delete(HashMap tabData, HashMap sqlMap)
	{

        StringBuffer messages = new StringBuffer();
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));
        map.put("message", messages.toString());

        return map;
    }
}
