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
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
19/02/2015		IN034403		Ramesh G		We are unable to release muliple patient results on the multi patient result reporting screen.
23/10/2019    	IN071315	    Nijitha S  		GHL-CRF-0607
--------------------------------------------------------------------------------------------------------------------
*/
package eOR.ORMultiPatientOrdersResulting;

import java.rmi.*;
import java.util.*;
import java.sql.*;
import eOR.Common.*;
import javax.ejb.*;
import javax.transaction.*;
//import oracle.sql.CLOB;  //[IN037372]
import java.io.BufferedWriter;

import webbeans.eCommon.*;

/**
 *
 * @ejb.bean
 *	name="ORMultiPatientOrdersResulting"
 *	type="Stateless"
 *	transaction-type="Bean"
 *	view-type="both"
 *	jndi-name="ORMultiPatientOrdersResulting"
 *	local-jndi-name="ORMultiPatientOrdersResulting"
 *	impl-class-name="eOR.ORMultiPatientOrdersResulting.ORMultiPatientOrdersResultingManager"
 *	
 *
 * @ejb.interface
 *	extends="javax.ejb.EJBObject"
 *	local-extends="javax.ejb.EJBLocalObject" 
 *	local-class="eOR.ORMultiPatientOrdersResulting.ORMultiPatientOrdersResultingLocal"
 *	remote-class="eOR.ORMultiPatientOrdersResulting.ORMultiPatientOrdersResultingRemote"
 *	generate= "local,remote"
 *
 * @ejb.home
 *	extends="javax.ejb.EJBHome" 
 *	local-extends="javax.ejb.EJBLocalHome"
 *	local-class="eOR.ORMultiPatientOrdersResulting.ORMultiPatientOrdersResultingLocalHome"
 *	remote-class="eOR.ORMultiPatientOrdersResulting.ORMultiPatientOrdersResultingHome"
 *	generate= "local,remote"
 *
 *
 */
public class ORMultiPatientOrdersResultingManager extends OrEJBSessionAdapter 
{

    StringBuffer traceVals = new StringBuffer();

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
        map.put("traceVal", traceVals.toString());

        return map;
    }

    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap insert(HashMap tabData, HashMap sqlMap) 
	{

        StringBuffer messages = new StringBuffer();

        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        map.put("message", messages.toString());
        map.put("traceVal", traceVals.toString());

        return map;
    }


    /*To Update the (multiple) Orders Selected by the user in the OR_RESULT_HEADER, OR_RESULT_LINE, OR_RESULT_TABLE */
    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap modify(HashMap tabDataParam, HashMap sqlMap) 
	{
        Properties pt = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt_line_value = null;
        PreparedStatement header_pstmt = null;
        PreparedStatement detail_pstmt = null;
        PreparedStatement pstmt_status = null;
        PreparedStatement pstmt_order_status = null;
//		PreparedStatement order_order_status	= null;
        PreparedStatement pstmt_order = null;
        PreparedStatement pstmt_parent = null;
        PreparedStatement pstmt_parent_line = null;
        PreparedStatement pstmt_abn_child_chk = null;
        PreparedStatement pstmt_line = null;
        PreparedStatement pstmt_message = null;
        PreparedStatement pstmt_bill_update = null;
        PreparedStatement pstmt_last_child = null;
        PreparedStatement pstmt_line_num_count = null;
        PreparedStatement header_pstmt_update = null;
        PreparedStatement pstmt_clob = null;
        CallableStatement cstmt = null;
        CallableStatement cstmt_bl_ext_service = null;
        CallableStatement cstmt_bl_ext_chrg_stage = null;
//PreparedStatement line_update_pstmt		= null;
        //PreparedStatement order_sts_update_pstmt= null;
        //PreparedStatement order_sts_result 		= null;
        //PreparedStatement order_line_count 		= null;
        //PreparedStatement result_hdr_update		= null;
        CallableStatement cstmt_bl_result = null;
        ResultSet resultSet = null;
        ArrayList tabData = null;
        StringBuffer messages = null;
        StringBuffer traceVal = null;
        HashMap map = null;


        try 
		{
            messages = new StringBuffer();
            traceVal = new StringBuffer();
            map = new HashMap();
            map.put("result", new Boolean(false));
            map.put("flag", "insert");

            ArrayList discrete_data = null;
            ArrayList discrete_list_data = null;
            ArrayList tabDataMultiple = null;
            String locale = (String) tabDataParam.get("locale");
            String login_by_id = (String) tabDataParam.get("login_by_id");
            String login_at_ws_no = (String) tabDataParam.get("login_at_ws_no");

            // Getting the data from the ArrayList object
            tabDataMultiple = (ArrayList) tabDataParam.get("UpdateData");
            pt = (Properties) tabDataParam.get("properties");
            // Getting the connection object
            connection = getConnection(pt);


            String order_id = "";
            String order_line_num = "";
            String order_type_code = "";
            String catalog_code = "";
            String auth_reqd_yn = "";
            String temp_order_id = "";
            String clinician_id = "";
            String report_srl_num = "1";
            String msr_panel_id = "";
            String main_result_type = "";
            String patient_id = "";
            String patient_class = "";
            String encounter_id = "";

            String auth_by_id = null;
            String auth_date_time = null;
            String result_status = "3";
            String result_type = null;
            //String panel_id							= null;
            String values = null;
            //String accession_num					= null;
            //String last_action_type					= null;
            String insert_result_status = "3";
            //String order_status_code				= "";
            String err_message = "";
            String bill_yn = "N";
            String err_bill_yn = "N";
            String err_code = "";
            String message_id = "";
            String charged_yn = "N";
            //String mess								= "";

            // New Modification Changes of Object Creation as per the ResultEntry
            //int line_count							= 0;
            String order_status = "C";
            String order_result_status = "";
            String order_result_type = "";
            String auth_reqd_yn_db = "N";
            String order_auth_reqd_yn = "";
            String status = "";
            boolean any_abnormal_child = false;
            String parent_order_id = "";
            String p_result_status = "P";
            String abnormal_child = null;
            //String line_result_type					= null;
            String old_srl_no = "";
            String old_order_id = "";
            int line_num_count = 0;

            int last_child = 0;
            int update_line = 1;
            int insert_header = 0;
            int update_order = 0;
            int update_l_status[] = {};
            boolean update_l_st = false;
            boolean insert_dl = false;

            String line_result_type = null;
            String result_type_line_value = "";
            String rec_result_type = "";
            // Variables for inserting into Number/Integer Type Values 
            String norm_low = null;
            String norm_high = null;
            String crit_low = null;
            String crit_high = null;
            String msg = null;


            // Retrieving the Sqls From sqlMap
            String SQL_OR_MULTI_PATIENT_RESULTING_AUTH_REQD_YN = (String) sqlMap.get("SQL_OR_MULTI_PATIENT_RESULTING_AUTH_REQD_YN");
            String SQL_OR_MULTI_PATIENT_RESULTING_LINE_VALUE = (String) sqlMap.get("SQL_OR_MULTI_PATIENT_RESULTING_LINE_VALUE");
            String SQL_OR_RESULT_REPORTING_INSERT_HEADER = (String) sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_HEADER");
            String SQL_OR_RESULT_REPORTING_INSERT_DETAIL = (String) sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_DETAIL");
            //String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS			= (String) sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS");
            //String SQL_OR_ORDER_GET_STATUS_CODE								= (String) sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE");
            //String SQL_OR_REPORT_AUTH_ORD_UPDATE								= (String) sqlMap.get("SQL_OR_REPORT_AUTH_ORD_UPDATE");
            String SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG = (String) sqlMap.get("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG");
            //String SQL_OR_MULTI_PATIENT_RESULTING_LINE_COUNT					= (String) sqlMap.get("SQL_OR_MULTI_PATIENT_RESULTING_LINE_COUNT");
            //String SQL_OR_MULTI_PATIENT_RESULTING_HDR_UPDATE					= (String) sqlMap.get("SQL_OR_MULTI_PATIENT_RESULTING_HDR_UPDATE");
            String SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC = (String) sqlMap.get("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC");
            String SQL_OR_RESULT_ENTRY_HEADER_DETAIL = (String) sqlMap.get("SQL_OR_RESULT_ENTRY_HEADER_DETAIL");
            String SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT = (String) sqlMap.get("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT");
            String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER = (String) sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER");
            String SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK = (String) sqlMap.get("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK");
            String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE = (String) sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE");
            String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE");
            String SQL_OR_ORDER_ENTRY_BILL_MESSAGE = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
            String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED");
            //String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE");
            String SQL_OR_BL_WITHOUT_ORDER_CATALOG = (String) sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
            String SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION");
            String SQL_OR_MULTI_PATIENT_RESULTING_GET_PARENT_LAST_CHILD = (String) sqlMap.get("SQL_OR_MULTI_PATIENT_RESULTING_GET_PARENT_LAST_CHILD");
            String SQL_OR_MULTI_PATIENT_RESULTING_GET_LINE_EXISTS_COUNT = (String) sqlMap.get("SQL_OR_MULTI_PATIENT_RESULTING_GET_LINE_EXISTS_COUNT");
            String SQL_OR_RESULT_REPORTING_UPDATE_HEADER = (String) sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_HEADER");
            String SQL_OR_RESULT_REPORTING_UPDATE_CLOB = (String) sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_CLOB");


            // total no of records
            int noOfRecords = tabDataMultiple.size();

            java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("dd/MM/yyyy H:m");
            java.util.Date today = new java.util.Date();
            String dateString = dt.format(today);

            // New Changes
            //order_line_count		= connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_LINE_COUNT);
            //result_hdr_update		= connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_HDR_UPDATE);

            pstmt_status = connection.prepareStatement(SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC);
            pstmt_order_status = connection.prepareStatement(SQL_OR_RESULT_ENTRY_HEADER_DETAIL);
            pstmt_parent = connection.prepareStatement(SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT);
            pstmt_order = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER);
            pstmt_abn_child_chk = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK);
            pstmt_line = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);
            pstmt_parent_line = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);
            pstmt_message = connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
            pstmt_last_child = connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_GET_PARENT_LAST_CHILD);
            pstmt_line_num_count = connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_GET_LINE_EXISTS_COUNT);
            header_pstmt_update = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_HEADER);
            pstmt_clob = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_CLOB);

            cstmt_bl_result = connection.prepareCall("{ " + SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG + " }");
            cstmt = connection.prepareCall("{ " + SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE + " }");
            cstmt_bl_ext_service = connection.prepareCall("{ " + SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED + " }");
            pstmt_bill_update = connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION);
            //cstmt_bl_ext_chrg_stage = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE+" }");
            cstmt_bl_ext_chrg_stage = connection.prepareCall("{ " + SQL_OR_BL_WITHOUT_ORDER_CATALOG + " }");

            pstmt = connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_AUTH_REQD_YN);
            pstmt_line_value = connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_LINE_VALUE);
            header_pstmt = connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_HEADER);
            detail_pstmt = connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_DETAIL);
            // Updating the result entry for the orders
            for (int i = 0; i < noOfRecords; i++) 
			{
            	temp_order_id = "";  //IN034403
                tabData = (ArrayList) tabDataMultiple.get(i);
                traceVal.append(tabData.toString());

                order_id = (String) tabData.get(0);
                order_line_num = (String) tabData.get(1);
                order_type_code = (String) tabData.get(2);
                catalog_code = (String) tabData.get(3);
                clinician_id = (String) tabData.get(4);
                msr_panel_id = (String) tabData.get(5);
                main_result_type = (String) tabData.get(6);
                discrete_list_data = (ArrayList) tabData.get(7);
                patient_id = (String) tabData.get(11);
                encounter_id = (String) tabData.get(12);
                patient_class = (String) tabData.get(13);


                // Getting the auth_reqd
                //pstmt = connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_AUTH_REQD_YN);
                pstmt.clearParameters();
                pstmt.setString(1, catalog_code.trim());
                resultSet = pstmt.executeQuery();
                while (resultSet != null && resultSet.next()) 
				{
                    auth_reqd_yn = resultSet.getString("L_RESULT_AUTH_REQD_YN");
                }
                //closeStatement(pstmt);
                closeResultSet(resultSet);

                // Checking for the line value for a particular order
                //pstmt_line_value = connection.prepareStatement(SQL_OR_MULTI_PATIENT_RESULTING_LINE_VALUE);
                pstmt_line_value.clearParameters();
                pstmt_line_value.setString(1, order_id.trim());
                resultSet = pstmt_line_value.executeQuery();
                while (resultSet != null && resultSet.next()) 
				{
                    temp_order_id = resultSet.getString("ORDER_ID");
                }
                //closeStatement(pstmt);
                closeResultSet(resultSet);

                // Getting the count for the order if any Order line exists with result status code less than 85
                pstmt_line_num_count.clearParameters();
                pstmt_line_num_count.setString(1, order_id.trim());
                pstmt_line_num_count.setString(2, order_line_num);
                resultSet = pstmt_line_num_count.executeQuery();
                while (resultSet != null && resultSet.next()) 
				{
                    line_num_count = resultSet.getInt("COUNT");
                }
                closeResultSet(resultSet);

                // If no order line numbers exists, than the result status will be 3, else 2
                if (line_num_count == 0) 
				{
                    result_status = "3";
                } 
				else 
				{
                    result_status = "2";
                }

                // if the line value is not existing, updating the line value
                if (temp_order_id == null || temp_order_id.equals(""))
				{
                    //header_pstmt = connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_HEADER);
                    header_pstmt.clearParameters();
                    header_pstmt.setString(1, order_type_code.trim());
                    header_pstmt.setString(2, order_id.trim());
                    header_pstmt.setString(3, report_srl_num);
                    header_pstmt.setString(4, clinician_id.trim());
                    header_pstmt.setString(5, dateString);
                    header_pstmt.setString(6, auth_reqd_yn);
                    header_pstmt.setString(7, auth_by_id);
                    header_pstmt.setString(8, auth_date_time);
                    header_pstmt.setString(9, result_status);

                    header_pstmt.setString(10, (String) tabData.get(14));
                    //header_pstmt.setString(10,result_type);
                    header_pstmt.setString(11, (String) tabData.get(8));
                    header_pstmt.setString(12, (String) tabData.get(9));
                    header_pstmt.setString(13, (String) tabData.get(10));
                    header_pstmt.setString(14, (String) tabData.get(8));
                    header_pstmt.setString(15, (String) tabData.get(9));
                    header_pstmt.setString(16, (String) tabData.get(10));

                    try 
					{
                        insert_header = header_pstmt.executeUpdate();
                    } 
					catch (Exception e) 
					{
                        e.printStackTrace();
                        connection.rollback();
                        traceVal.append(e.getMessage());
                        map.put("traceVal", traceVal.toString());
                        messages.append(e.getMessage());
                        map.put("message", messages.toString());
                        return map;
                    }
                    //closeStatement(header_pstmt);

                } 
				else 
				{
                    header_pstmt_update.clearParameters();
                    header_pstmt_update.setString(1, clinician_id.trim());
                    header_pstmt_update.setString(2, dateString);
                    header_pstmt_update.setString(3, auth_reqd_yn);
                    header_pstmt_update.setString(4, auth_by_id);
                    header_pstmt_update.setString(5, auth_date_time);
                    header_pstmt_update.setString(6, result_status);
                    header_pstmt_update.setString(7, (String) tabData.get(14));
                    header_pstmt_update.setString(8, (String) tabData.get(8));
                    header_pstmt_update.setString(9, (String) tabData.get(9));
                    header_pstmt_update.setString(10, (String) tabData.get(10));
                    header_pstmt_update.setString(11, order_type_code.trim());
                    header_pstmt_update.setString(12, order_id.trim());
                    header_pstmt_update.setString(13, report_srl_num);

                    try 
					{
                        insert_header = header_pstmt_update.executeUpdate();
                    } 
					catch (Exception e) 
					{
                        e.printStackTrace();
                        connection.rollback();
                        traceVal.append(e.getMessage());
                        map.put("traceVal", traceVal.toString());
                        messages.append(e.getMessage());
                        map.put("message", messages.toString());
                        return map;
                    }
                }
                // Inserting the detail values into OR_RESULT_DETAIL Table
                detail_pstmt.clearParameters();


                for (int j = 0; j < discrete_list_data.size(); j++) 
				{
                    discrete_data = (ArrayList) discrete_list_data.get(j);

                    line_result_type = (String) discrete_data.get(13);
                    insert_result_status = "3";
                    norm_low = (String) discrete_data.get(9);
                    norm_high = (String) discrete_data.get(10);
                    crit_low = (String) discrete_data.get(11);
                    crit_high = (String) discrete_data.get(12);

                    result_type_line_value = (String) discrete_data.get(1);

                    // Setting the values in preparedstatement object
                    detail_pstmt.setString(1, order_type_code.trim());
                    detail_pstmt.setString(2, order_id.trim());
                    detail_pstmt.setString(3, report_srl_num);
                    detail_pstmt.setString(4, order_line_num);
                    detail_pstmt.setString(5, (String) discrete_data.get(5));
                    detail_pstmt.setString(6, dateString);

                    if (main_result_type.equals("V") || main_result_type.equals("Z") || main_result_type.equals("P")) 
					{
                        detail_pstmt.setString(7, msr_panel_id.trim());
                    }
					else 
					{
                        //detail_pstmt.setString(7,panel_id);
                        detail_pstmt.setString(7, (String) discrete_data.get(0));
                    }
                    detail_pstmt.setString(8, (String) discrete_data.get(0));
                    detail_pstmt.setString(9, auth_reqd_yn);
                    detail_pstmt.setString(10, auth_by_id);
                    detail_pstmt.setString(11, auth_date_time);
                    // setting the line result type value instead of the original result type
                    detail_pstmt.setString(12, line_result_type);
                    //detail_pstmt.setString(12,(String)discrete_data.get(1));
                    detail_pstmt.setString(13, (String) discrete_data.get(2));
                    detail_pstmt.setString(14, (String) discrete_data.get(3));
                    detail_pstmt.setString(15, (String) discrete_data.get(4));
                    detail_pstmt.setString(16, insert_result_status);
                    if (result_type_line_value.equals("N") || result_type_line_value.equals("I")) 
					{
                        if (norm_low == null || norm_low.equals("") || norm_low.equals("null"))
						{
                            norm_low = null;
                        }
                        if (norm_high == null || norm_high.equals("") || norm_high.equals("null")) 
						{
                            norm_high = null;
                        }
                        if (crit_low == null || crit_low.equals("") || crit_low.equals("null")) 
						{
                            crit_low = null;
                        }
                        if (crit_high == null || crit_high.equals("") || crit_high.equals("null")) 
						{
                            crit_high = null;
                        }
                        detail_pstmt.setString(17, norm_low);
                        detail_pstmt.setString(18, norm_high);
                        detail_pstmt.setString(19, crit_low);
                        detail_pstmt.setString(20, crit_high);
                    } 
					else 
					{
                        detail_pstmt.setString(17, norm_low);
                        detail_pstmt.setString(18, norm_high);
                        detail_pstmt.setString(19, crit_low);
                        detail_pstmt.setString(20, crit_high);
                    }
                    detail_pstmt.setString(21, line_result_type);
                    /*detail_pstmt.setString(17,values);
                    detail_pstmt.setString(18,values);
                    detail_pstmt.setString(19,values);
                    detail_pstmt.setString(20,values);
                    detail_pstmt.setString(21,values);*/
                    detail_pstmt.setString(22, values);
                    detail_pstmt.setString(23, (String) tabData.get(8));
                    detail_pstmt.setString(24, (String) tabData.get(9));
                    detail_pstmt.setString(25, (String) tabData.get(10));
                    detail_pstmt.setString(26, (String) tabData.get(8));
                    detail_pstmt.setString(27, (String) tabData.get(9));
                    detail_pstmt.setString(28, (String) tabData.get(10));
                    detail_pstmt.setString(29, values);
                    detail_pstmt.setString(30, clinician_id.trim());
                    detail_pstmt.addBatch();
                    //discrete_data.clear();	
                }
                //discrete_data.clear();	
                int[] updatedCounts;
                //Executing the batch
                try 
				{
                    updatedCounts = detail_pstmt.executeBatch();
                } 
				catch (Exception e) 
				{
                    connection.rollback();
                    traceVal.append(e.getMessage());
                    e.printStackTrace();
                    map.put("traceVal", traceVal.toString());
                    messages.append(e.getMessage());
                    map.put("message", messages.toString());
                    return map;
                }

                // Checking the length of the batch updation
                if (updatedCounts.length > 0) //if(counter == discrete_list_data.size())
                {
                    //map.put( "result", new Boolean( true ) ) ;
                    insert_dl = true;
                } 
				else 
				{
                    insert_dl = false;
                    connection.rollback();
                    messages.append("Insert Failed");
                }
                // Inserting the CLOB DATA for Long_TExt Result Type - Start
                if (insert_dl) 
				{
                    for (int j = 0; j < discrete_list_data.size(); j++) 
					{

                        discrete_data = (ArrayList) discrete_list_data.get(j);
                        result_type = (String) discrete_data.get(1);
                        if (result_type.equalsIgnoreCase("F"))
						{
                            msg = insertResultDataClob(pstmt_clob, (String) discrete_data.get(14), order_type_code.trim(), order_id.trim(), report_srl_num, order_line_num, (String) discrete_data.get(5));
                        }
                    }
                }
                // Inserting the CLOB DATA for Long_TExt Result Type - End
                // gettting the result_status and auth_reqd from the db				
                pstmt_order_status.clearParameters();
                pstmt_order_status.setString(1, locale.trim());
                pstmt_order_status.setString(2, order_id.trim());
                pstmt_order_status.setString(3, report_srl_num);
                resultSet = pstmt_order_status.executeQuery();
                while (resultSet != null && resultSet.next()) 
				{
                    order_result_status = resultSet.getString("result_status");
                    order_result_type = resultSet.getString("result_type");
                    order_auth_reqd_yn = resultSet.getString("auth_reqd_yn");

                    if (order_result_status == null) 
					{
                        order_result_status = "";
                    }
                    if (order_result_type == null) 
					{
                        order_result_type = "";
                    }
                    if (order_auth_reqd_yn == null) 
					{
                        order_auth_reqd_yn = "";
                    }
                }
                closeResultSet(resultSet);

                rec_result_type = (String) tabData.get(14);
                if (rec_result_type == null) 
				{
                    rec_result_type = "";
                }
                if (!rec_result_type.trim().equals("")) 
				{
                    if (!rec_result_type.trim().equals("N")) 
					{
                        rec_result_type = "A";
                    }
                }

                // Retrieving the or_status from the function
                pstmt_status.clearParameters();
                pstmt_status.setString(1, order_result_status.trim());
                pstmt_status.setString(2, order_status.trim());
                pstmt_status.setString(3, rec_result_type.trim());
                //pstmt_status.setString(3,order_result_type.trim());
                pstmt_status.setString(4, auth_reqd_yn_db.trim());
                pstmt_status.setString(5, order_auth_reqd_yn.trim());
                pstmt_status.setString(6, "N");
                resultSet = pstmt_status.executeQuery();
                status = "";
                while (resultSet != null && resultSet.next()) 
				{
                    status = resultSet.getString("or_status");
                }
                closeResultSet(resultSet);

                // Updating the Order status
                pstmt_order.setString(1, status);
                if (order_status.equalsIgnoreCase("C")) 
				{
                    pstmt_order.setString(2, status);
                } 
				else 
				{
                    pstmt_order.setString(2, "");
                }
                pstmt_order.setString(3, (String) tabData.get(8));
                pstmt_order.setString(4, (String) tabData.get(9));
                pstmt_order.setString(5, (String) tabData.get(10));
                pstmt_order.setString(6, order_id.trim());
                try 
				{
                    update_order = pstmt_order.executeUpdate();
                } 
				catch (Exception ex)
				{
                    ex.printStackTrace();
                }
                // Getting the parent Order ID
                pstmt_parent.clearParameters();
                pstmt_parent.setString(1, order_id.trim());
                resultSet = pstmt_parent.executeQuery();
                while (resultSet != null && resultSet.next())
				{
                    parent_order_id = (String) resultSet.getString("parent_order_id");
                }
                closeResultSet(resultSet);
                if (parent_order_id == null) 
				{
                    parent_order_id = "";
                }

                if (parent_order_id != null && !parent_order_id.trim().equals("")) 
				{
                    // Checking if the order is the last child order for the parent order
                    pstmt_last_child.clearParameters();
                    pstmt_last_child.setString(1, parent_order_id);
                    pstmt_last_child.setString(2, order_id.trim());
                    pstmt_last_child.setString(3, order_line_num.trim());
                    resultSet = pstmt_last_child.executeQuery();
                    while (resultSet != null && resultSet.next()) 
					{
                        last_child = resultSet.getInt(1);
                    }
                    closeResultSet(resultSet);
                    p_result_status = "P";
                    abnormal_child = null;
                    if (last_child == 0) 
					{
                        p_result_status = order_result_status;
                    }
                    // checking if any order is abnormal for that parent order
                    pstmt_abn_child_chk.setString(1, parent_order_id);
                    resultSet = pstmt_abn_child_chk.executeQuery();
                    while (resultSet != null && resultSet.next()) 
					{
                        abnormal_child = resultSet.getString("abnormal_child");
                        if (abnormal_child != null && abnormal_child.trim().equalsIgnoreCase("X")) 
						{
                            any_abnormal_child = true;
                        }
                    }
                    closeResultSet(resultSet);

                    // getting the or_status from the procedure
                    pstmt_status.clearParameters();
                    pstmt_status.setString(1, p_result_status);
                    pstmt_status.setString(2, "C");
                    if (any_abnormal_child)
					{
                        pstmt_status.setString(3, "A");
                    }
					else 
					{
                        pstmt_status.setString(3, rec_result_type);
                    }
                    //pstmt_status.setString(3,order_result_type);
                    pstmt_status.setString(4, auth_reqd_yn_db.trim());
                    pstmt_status.setString(5, order_auth_reqd_yn.trim());
                    pstmt_status.setString(6, "N");
                    resultSet = pstmt_status.executeQuery();
                    status = "";
                    while (resultSet != null && resultSet.next()) 
					{
                        status = resultSet.getString("or_status");
                    }
                    closeResultSet(resultSet);


                    // Updating the order line status for the parent order
                    pstmt_order.setString(1, status);
                    pstmt_order.setString(2, status);
                    pstmt_order.setString(3, (String) tabData.get(8));
                    pstmt_order.setString(4, (String) tabData.get(9));
                    pstmt_order.setString(5, (String) tabData.get(10));
                    pstmt_order.setString(6, parent_order_id.trim());
                    try 
					{
                        pstmt_order.executeUpdate();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                    }

                }

                line_result_type = null;
                discrete_data = new ArrayList();


                for (int j = 0; j < discrete_list_data.size(); j++)
				{
                    discrete_data = (ArrayList) discrete_list_data.get(j);

                    line_result_type = (String) discrete_data.get(13);


                    if (line_result_type == null) 
					{
                        line_result_type = "";
                    }
                    if (!line_result_type.trim().equals(""))
					{
                        if (!line_result_type.trim().equals("N")) 
						{
                            line_result_type = "A";
                        }
                    }


                    pstmt_status.clearParameters();
                    pstmt_status.setString(1, insert_result_status);
                    pstmt_status.setString(2, order_status.trim());
                    pstmt_status.setString(3, line_result_type.trim());
                    //pstmt_status.setString(3,order_result_type.trim());
                    pstmt_status.setString(4, auth_reqd_yn_db.trim());
                    pstmt_status.setString(5, order_auth_reqd_yn.trim());
                    pstmt_status.setString(6, "N");
                    resultSet = pstmt_status.executeQuery();
                    status = "";
                    while (resultSet != null && resultSet.next())
					{
                        status = resultSet.getString("or_status");
                    }
                    closeResultSet(resultSet);

                    // Updating the order line status 
                    pstmt_line.clearParameters();
                    pstmt_line.setString(1, status);
                    if (order_status.equalsIgnoreCase("C")) 
					{
                        pstmt_line.setString(2, status);
                    } 
					else 
					{
                        pstmt_line.setString(2, "");
                    }
                    pstmt_line.setString(3, (String) tabData.get(8));
                    pstmt_line.setString(4, (String) tabData.get(9));
                    pstmt_line.setString(5, (String) tabData.get(10));
                    pstmt_line.setString(6, order_id.trim());
                    pstmt_line.setString(7, (String) order_line_num);
                    pstmt_line.addBatch();

                    // For Billing Related
                    try 
					{
                        if (insert_result_status.trim().equals("3")) 
						{
                            if (auth_reqd_yn_db.equals("N")) // need to check this one also
                            {
                                if ((!old_srl_no.equals((String) order_line_num)) || !old_order_id.equals(order_id.trim())) 
								{
                                    cstmt_bl_result.clearParameters();
                                    cstmt_bl_result.setString(1, patient_id);
                                    cstmt_bl_result.setString(2, encounter_id);
                                    cstmt_bl_result.setString(3, patient_class);
                                    cstmt_bl_result.setString(4, order_id.trim());
                                    cstmt_bl_result.setString(5, order_line_num);


                                    cstmt_bl_result.setString(6, (String) tabData.get(8));
                                    cstmt_bl_result.setString(7, (String) tabData.get(9));
                                    cstmt_bl_result.registerOutParameter(8, Types.VARCHAR);
                                    cstmt_bl_result.registerOutParameter(9, Types.VARCHAR);
                                    try 
									{
                                        cstmt_bl_result.execute();
                                    }
									catch (Exception ex) 
									{
                                        ex.printStackTrace();
                                    }

                                    err_message = cstmt_bl_result.getString(9);
                                    bill_yn = cstmt_bl_result.getString(8);

                                    if (bill_yn != null && bill_yn.equals("Y"))
									{
                                        err_bill_yn = "Y";
                                    }
                                    err_message = cstmt_bl_result.getString(9);

                                    if (err_message != null && !err_message.equals("")) 
									{
                                        update_line = 0;
                                        messages = new StringBuffer();
                                        messages.append(err_message);
                                    }
                                    old_srl_no = (String) order_line_num;
                                    old_order_id = order_id.trim();
                                }
                            }
                        }
                    } 
					catch (Exception ex)
					{
                        update_line = 0;
                        ex.printStackTrace();
                    }

                    if (!parent_order_id.equals("")) 
					{
                        pstmt_status.clearParameters();
                        p_result_status = "P";
                        if (last_child == 0) 
						{
                            p_result_status = order_result_status.trim();
                        }
                        pstmt_status.setString(1, p_result_status);
                        pstmt_status.setString(2, order_status.trim());
                        if (any_abnormal_child)
						{
                            pstmt_status.setString(3, "A");
                        }
						else 
						{
                            pstmt_status.setString(3, line_result_type.trim());
                            //pstmt_status.setString(3,order_result_type.trim());
                        }
                        pstmt_status.setString(4, auth_reqd_yn_db.trim());
                        pstmt_status.setString(5, order_auth_reqd_yn.trim());
                        pstmt_status.setString(6, "N");
                        resultSet = pstmt_status.executeQuery();
                        status = "";
                        while (resultSet != null && resultSet.next()) 
						{
                            status = resultSet.getString("or_status");
                        }
                        closeResultSet(resultSet);

                        // Updating the parent order line status
                        pstmt_parent_line.clearParameters();
                        pstmt_parent_line.setString(1, status);
                        pstmt_parent_line.setString(2, status);
                        pstmt_parent_line.setString(3, (String) tabData.get(8));
                        pstmt_parent_line.setString(4, (String) tabData.get(9));
                        pstmt_parent_line.setString(5, (String) tabData.get(10));
                        pstmt_parent_line.setString(6, parent_order_id.trim());
                        pstmt_parent_line.setString(7, (String) order_line_num);
                        try 
						{
                            pstmt_parent_line.executeUpdate();
                        } 
						catch (Exception ex)
						{
                            ex.printStackTrace();
                        }

                    }
                }
                try 
				{
                    update_l_status = pstmt_line.executeBatch();
                } 
				catch (Exception ex) 
				{
                    ex.printStackTrace();
                }

                if ((update_l_status.length > 0)) 
				{ //check updation in SYN
                    update_l_st = true;
                } 
				else if ((update_l_status.length == (-3))) 
				{
                    update_l_st = false;
                }

                // Billing Consolidated Procedure
                if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0) 
				{
                    if (err_bill_yn.equals("Y")) 
					{
                        cstmt.setString(1, (String) tabData.get(10));
                        cstmt.setString(2, patient_id);
                        if (patient_class != null && (patient_class.equals("IP") || patient_class.equals("EA"))) 
						{
                            cstmt.setString(3, "I");
                        } 
						else if (patient_class != null && (patient_class.equals("DC"))) 
						{
                            cstmt.setString(3, "D");
                        } 
						else if (patient_class != null && (patient_class.equals("EM")))
						{
                            cstmt.setString(3, "E");
                        } 
						else if (patient_class != null && (patient_class.equals("OP"))) 
						{
                            cstmt.setString(3, "O");
                        } 
						else // XT
                        {
                            cstmt.setString(3, "R");			// EPISODE_TYPE
                        }
                        cstmt.setString(4, encounter_id);		// EPISODE_ID 
                        cstmt.setString(5, null); // VISIT_NUM hardcoded value null
                        cstmt.setString(6, order_id); 			// ORDER_ID
                        cstmt.setString(7, "OR");
                        cstmt.setString(8, null);
                        cstmt.setString(9, (String) tabData.get(8));
                        cstmt.setString(10, (String) tabData.get(9));
                        cstmt.registerOutParameter(11, Types.VARCHAR);
                        cstmt.registerOutParameter(12, Types.VARCHAR);
                        cstmt.registerOutParameter(13, Types.VARCHAR);
                        try 
						{
                            cstmt.execute();
                        } 
						catch (Exception ex) 
						{
                            ex.printStackTrace();
                        }

                        err_code = cstmt.getString(11);  // ERR_CODE
                        message_id = cstmt.getString(12);  // SYS_MESSAGE_ID
                        err_message = cstmt.getString(13);  // ERROR_TEXT

                        if (err_code != null && !err_code.equals("") && !err_code.equals("10") && err_message != null && !err_message.equals("")) 
						{
                            update_line = 0;			// Come out
                            messages = new StringBuffer();
                            messages.append(err_message);
                        } 
						else if (message_id != null && !message_id.equals("")) //Query from the sm_message and display the message
                        {
                            update_line = 0;				// Come out
                            messages = new StringBuffer();

                            // Query from the database for the message id and display the Message
                            pstmt_message.clearParameters();
                            pstmt_message.setString(1, message_id);
                            resultSet = pstmt_message.executeQuery();
                            if (resultSet != null)
							{
                                while (resultSet.next()) 
								{
                                    messages.append(resultSet.getString(1));
                                }
                            }
                            closeResultSet(resultSet);
                        }
                    }
                }
                // For Billing Module
                try 
				{
                    if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0)
					{
                        if (err_bill_yn.equals("Y")) 
						{
                            old_srl_no = "";
                            old_order_id = "";

                            for (int j = 0; j < discrete_list_data.size(); j++) 
							{
                                //discrete_data = (ArrayList) discrete_list_data.get(j);
                                if (order_result_status.trim().equals("3") && update_line > 0) 
								{
                                    if (auth_reqd_yn_db.equals("N")) 
									{
                                        if ((!old_srl_no.equals((String) order_line_num)) || !old_order_id.equals(order_id)) 
										{
                                            cstmt_bl_ext_service.setString(1, (String) tabData.get(10));
                                            cstmt_bl_ext_service.setString(2, "OR");
                                            cstmt_bl_ext_service.setString(3, order_id);
                                            cstmt_bl_ext_service.setString(4, (String) order_line_num);
                                            cstmt_bl_ext_service.registerOutParameter(5, Types.VARCHAR);
                                            cstmt_bl_ext_service.registerOutParameter(6, Types.VARCHAR);
                                            cstmt_bl_ext_service.registerOutParameter(7, Types.VARCHAR);
                                            cstmt_bl_ext_service.registerOutParameter(8, Types.VARCHAR);

                                            try 
											{
                                                cstmt_bl_ext_service.execute();
                                            } 
											catch (Exception ex) 
											{
                                                ex.printStackTrace();
                                            }

                                            charged_yn = cstmt_bl_ext_service.getString(5);
                                            err_code = cstmt_bl_ext_service.getString(6);
                                            message_id = cstmt_bl_ext_service.getString(7);
                                            err_message = cstmt_bl_ext_service.getString(8);

                                            if (err_message != null && !err_message.equals("")) 
											{
                                                update_line = 0;
                                                messages = new StringBuffer();
                                                messages.append(err_message);
                                            } 
											else 
											{
                                                cstmt_bl_ext_chrg_stage.setString(1, (String) tabData.get(10));
                                                cstmt_bl_ext_chrg_stage.setString(2, order_id);
                                                cstmt_bl_ext_chrg_stage.setString(3, (String) order_line_num);
                                                cstmt_bl_ext_chrg_stage.setString(4, "RST");
                                                cstmt_bl_ext_chrg_stage.setString(5, login_by_id);
                                                cstmt_bl_ext_chrg_stage.setString(6, login_at_ws_no);

                                                cstmt_bl_ext_chrg_stage.registerOutParameter(7, Types.VARCHAR);
                                                cstmt_bl_ext_chrg_stage.registerOutParameter(8, Types.VARCHAR);
                                                cstmt_bl_ext_chrg_stage.setString(9, "OR");//IN071315
                                                try 
												{
                                                    cstmt_bl_ext_chrg_stage.execute();
                                                }
												catch (Exception ex) 
												{
                                                    ex.printStackTrace();
                                                }

                                                message_id = cstmt_bl_ext_chrg_stage.getString(7);
                                                err_message = cstmt_bl_ext_chrg_stage.getString(8);

                                                if (err_message != null && !err_message.equals("")) 
												{
                                                    update_line = 0;
                                                    messages = new StringBuffer();
                                                    messages.append(err_message);
                                                } 
												else if (message_id != null && !message_id.equals("")) //Query from the sm_message and display the message
                                                {
                                                    update_line = 0;				// Come out
                                                    messages = new StringBuffer();
                                                    // Query from the database for the message id and display the Message
                                                    pstmt_message.clearParameters();
                                                    pstmt_message.setString(1, message_id);
                                                    resultSet = pstmt_message.executeQuery();
                                                    if (resultSet != null) 
													{
                                                        while (resultSet.next()) 
														{
                                                            messages.append(resultSet.getString(1));
                                                        }
                                                    }
                                                    closeResultSet(resultSet);
                                                }
                                            }
                                            //}

                                            if (update_line > 0 && charged_yn != null && charged_yn.equals("Y")) //only if it is'Y' other wise it will be 'N' already
                                            {
                                                pstmt_bill_update.setString(1, charged_yn);
                                                pstmt_bill_update.setString(2, (String) tabData.get(8));
                                                pstmt_bill_update.setString(3, (String) tabData.get(9));
                                                pstmt_bill_update.setString(4, (String) tabData.get(10));
                                                pstmt_bill_update.setString(5, order_id);
                                                pstmt_bill_update.setString(6, (String) order_line_num);
                                                try 
												{
                                                    update_line = pstmt_bill_update.executeUpdate();
                                                }
												catch (Exception ex) 
												{
                                                    ex.printStackTrace();
                                                }
                                            }
                                            old_srl_no = (String) order_line_num;
                                            old_order_id = order_id;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
				catch (Exception e)
				{
                    update_line = 0;
                    traceVal.append("Exception Billing Last");
                    e.printStackTrace();
                }

                if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0)
				{
                    connection.commit();
                    map.put("result", new Boolean(true));
                    messages.append("RECORD_INSERTED");
                } 
				else
				{
                    connection.rollback();
                    if (update_line != 0) 
					{
                        messages.append("Insert Failed");
                    }
                }
                discrete_list_data.clear();
                tabData.clear();
            }
            discrete_list_data.clear();
            tabData.clear();
            discrete_data.clear();
            tabDataMultiple.clear();
            // Commiting the transaction only if all records updates successfully
//			connection.commit();
            connection.rollback();
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
            } 
			catch (Exception ee) 
			{
                messages.append(ee.getMessage());
                ee.printStackTrace();
            }
            if (e instanceof java.lang.NullPointerException || (((String) e.getMessage()).indexOf("Index: 0, Size: 0") != -1)) 
			{
                messages.delete(0, messages.length());
                messages.append("Cannot Update. Try Again Later...");
            } 
			else
			{
                messages.append(e.getMessage());
            }
            e.printStackTrace();
        } 
		finally 
		{
            try 
			{
                closeStatement(header_pstmt);
                closeStatement(detail_pstmt);
                //closeStatement(result_hdr_update);
                closeStatement(pstmt_status);
                closeStatement(pstmt_order_status);
                closeStatement(pstmt_parent);
                closeStatement(pstmt_order);
                closeStatement(pstmt_abn_child_chk);
                closeStatement(pstmt_line);
                closeStatement(pstmt_parent_line);
                closeStatement(pstmt_message);
                closeStatement(pstmt_last_child);
                closeStatement(header_pstmt_update);
                closeStatement(cstmt);
                closeStatement(cstmt_bl_ext_service);
                closeStatement(pstmt_bill_update);
                closeStatement(cstmt_bl_ext_chrg_stage);
                closeStatement(pstmt_line_value);
                closeStatement(pstmt_line_num_count);
                closeStatement(pstmt_clob);
                //closeStatement(line_update_pstmt);
                //closeStatement(order_sts_result);
                //closeStatement(order_sts_update_pstmt);
                closeStatement(pstmt);
                closeStatement(cstmt_bl_result);
                closeResultSet(resultSet);
                closeConnection(connection, pt);
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }

        map.put("message", messages.toString());
        map.put("traceVal", traceVal.toString());
        return map;
    }//End of Update Method


    /*Inserting the Result CLOB data into OR_RESULT_DETAIL Table called when the result type is of LONG_TEXT	*/
    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public String insertResultDataClob(PreparedStatement pstmt_clob, String result_data, String order_type_code, String order_id, String report_srl_no, String line_srl_no, String srl_no) 
	{
        StringBuffer messages = new StringBuffer("");
        ResultSet rset_clob = null;
        try 
		{

            messages.append("*insertClob called*");
            pstmt_clob.setString(1, order_type_code);
            pstmt_clob.setString(2, order_id);
            pstmt_clob.setString(3, report_srl_no);
            pstmt_clob.setString(4, line_srl_no);
            pstmt_clob.setString(5, srl_no);
            rset_clob = pstmt_clob.executeQuery();

            if (rset_clob != null)
			{
                while (rset_clob.next())
				{
                    messages.append("z");
                    //CLOB clb = (CLOB) rset_clob.getClob("result_data");  //Web logic Conversion -- [IN037372]
                    java.sql.Clob clb = (java.sql.Clob) rset_clob.getClob("result_data");
					messages.append("a");
                    //BufferedWriter bw = new BufferedWriter(clb.getCharacterOutputStream()); //Web logic Conversion -- [IN037372]
					BufferedWriter bw = new BufferedWriter(clb.setCharacterStream(0));
                    messages.append("b");
                    bw.write(result_data, 0, result_data.length());
                    messages.append("c");
                    bw.flush();
                    messages.append("d");
                    bw.close();
                    messages.append("**clob**");
                }
            }
            closeResultSet(rset_clob);
        } 
		catch (Exception ee)
		{
            messages.append("Error " + ee.getMessage());
            ee.printStackTrace();
        } 
		finally 
		{
            try 
			{
                closeResultSet(rset_clob);
            } 
			catch (Exception ex) 
			{
                ex.printStackTrace();
            }
        }
        return messages.toString();
    }
}
