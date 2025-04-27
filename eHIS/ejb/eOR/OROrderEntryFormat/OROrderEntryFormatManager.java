/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           									created
02/07/2014	IN049133		Chowminya									CRF:Disallow user to enter the future date in the LMP date field
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR.OROrderEntryFormat;

import java.rmi.*;
import java.util.*;
import java.sql.*;

import javax.ejb.*;
import javax.transaction.*;

import eOR.Common.*;

/**
 *
 * @ejb.bean
 *	name="OROrderEntryFormat"
 *	type="Stateless"
 *	transaction-type="Bean"
 *	view-type="both"
 *	jndi-name="OROrderEntryFormat"
 *	local-jndi-name="OROrderEntryFormat"
 *	impl-class-name="eOR.OROrderEntryFormat.OROrderEntryFormatManager"
 *	
 *
 * @ejb.interface
 *	extends="javax.ejb.EJBObject"
 *	local-extends="javax.ejb.EJBLocalObject" 
 *	local-class="eOR.OROrderEntryFormat.OROrderEntryFormatLocal"
 *	remote-class="eOR.OROrderEntryFormat.OROrderEntryFormatRemote"
 *	generate= "local,remote"
 *
 * @ejb.home
 *	extends="javax.ejb.EJBHome" 
 *	local-extends="javax.ejb.EJBLocalHome"
 *	local-class="eOR.OROrderEntryFormat.OROrderEntryFormatLocalHome"
 *	remote-class="eOR.OROrderEntryFormat.OROrderEntryFormatHome"
 *	generate= "local,remote"
 *
 *
 */
public class OROrderEntryFormatManager extends OrEJBSessionAdapter 
{

    StringBuffer traceVals = new StringBuffer();
    String seq_num_value = "";
    String mnemonic_value = "";
    String field_mnemonic_value = "";
    String value_seq_num = "";
	String oth_field_mnemonic = "";//IN049133
	String oth_seq_num = "";//IN049133
    boolean depend_flag = true;

    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap insert(HashMap tabData, HashMap sqlMap) 
	{
        //Set keys = tabData.keySet();			
        traceVals = new StringBuffer();
        StringBuffer messages = null;
        HashMap map = null;
        Connection connection = null;
        PreparedStatement pstmt_insert_order_entry_update = null;

        try 
		{
            connection = getConnection((Properties) tabData.get("properties"));
            //connection = getConnection() ;
            messages = new StringBuffer();
            map = new HashMap();
            int inserted = 0;

            inserted = insertDetails(tabData, sqlMap, connection);
            traceVals.append("after first insert " + inserted);

            if (inserted < 1) 
			{
                connection.rollback();
                messages.append("Insert Failed");
            } 
			else 
			{
                traceVals.append("-- b4 calling 2nd isnert: ");

                inserted = 0;
                traceVals.append(" ---just b4 calling 2nd isnert: ");
                inserted = insertListValues(tabData, sqlMap, connection);
                traceVals.append(" ---just after calling 2nd isnert: " + inserted);
                if (inserted < 1) 
				{
                    connection.rollback();
                    messages.append("Insert Failed");
                }

            }
            if (inserted >= 1) 
			{
                // this is to update the order catalog table based on the type of order category - "non specific"
                if ((((String) tabData.get("level")).equals("L")) && (((String) tabData.get("order_category")).equals("*A"))) 
				{
                    final String SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS1 = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS1");
                    traceVals.append(" ---SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS1: " + SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS1);
                    if (pstmt_insert_order_entry_update != null) 
					{
                        closeStatement(pstmt_insert_order_entry_update);
                    }
                    pstmt_insert_order_entry_update = connection.prepareStatement(SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS1);

                    pstmt_insert_order_entry_update.setString(1, (String) tabData.get("format_id"));
                    pstmt_insert_order_entry_update.setString(2, (String) tabData.get("order_category"));
                    pstmt_insert_order_entry_update.setString(3, (String) tabData.get("order_category"));
                    pstmt_insert_order_entry_update.setString(4, (String) tabData.get("order_type"));
                    pstmt_insert_order_entry_update.setString(5, (String) tabData.get("order_type"));
                    pstmt_insert_order_entry_update.setString(6, (String) tabData.get("order_catalog"));
                    pstmt_insert_order_entry_update.setString(7, (String) tabData.get("order_catalog"));

                    traceVals.append("-- before execute of non specific--");
                    pstmt_insert_order_entry_update.executeUpdate();
                    traceVals.append("-- after  execute of non specific--");
                } 
				else if ((((String) tabData.get("level")).equals("L")) && (!(((String) tabData.get("order_category")).equals("*A")))) 
				{
                    final String SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS2 = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS2");
                    traceVals.append(" ---SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS2: " + SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS2);
                    if (pstmt_insert_order_entry_update != null) 
					{
                        closeStatement(pstmt_insert_order_entry_update);
                    }
                    pstmt_insert_order_entry_update = connection.prepareStatement(SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_INS2);

                    pstmt_insert_order_entry_update.setString(1, (String) tabData.get("format_id"));
                    pstmt_insert_order_entry_update.setString(2, (String) tabData.get("order_category"));
                    pstmt_insert_order_entry_update.setString(3, (String) tabData.get("order_type"));
                    pstmt_insert_order_entry_update.setString(4, (String) tabData.get("order_type"));
                    pstmt_insert_order_entry_update.setString(5, (String) tabData.get("order_catalog"));
                    pstmt_insert_order_entry_update.setString(6, (String) tabData.get("order_catalog"));

                    traceVals.append("-- before execute else of update--");
                    inserted = pstmt_insert_order_entry_update.executeUpdate();
                    traceVals.append("-- after execute else of update--" + inserted);
                } 
				else 
				{
                    inserted = 1; // this will execute if "level type = header"
                }
                if (inserted < 1) 
				{
                    connection.rollback();
                    messages.append("Delete Failed");
                } 
				else 
				{
                    connection.commit();
                    map.put("result", new Boolean(true));
                    map.put("message", "Operation Completed Successfully...");
                    //messages.append( "Operation Completed Successfully..." ) ;
                    messages.append("RECORD_INSERTED");
                }
            }
        } 
		catch (Exception e) 
		{
            try 
			{
                connection.rollback();
            } 
			catch (Exception e1)
			{
                messages.append("Delete Failed" + e1.getMessage());
            }

            traceVals.append("insert exception" + e.getMessage());
        } 
		finally 
		{
            try 
			{
                if (pstmt_insert_order_entry_update != null) 
				{
                    closeStatement(pstmt_insert_order_entry_update);
                }
                if (connection != null) 
				{
                    //closeConnection(connection);
                    closeConnection(connection, (Properties) tabData.get("properties"));
                }
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }

        map.put("message", messages.toString());
        map.put("traceVal", traceVals.toString());

        return map;
    }

    private int insertDetails(HashMap tabData, HashMap sqlMap, Connection connection) 
	{
        traceVals.append("first line first method in insert");
        StringBuffer messages = new StringBuffer();
        PreparedStatement pstmt_insert_order_entry = null;
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        int result = 0;

        try
        {
            String formatId = (String) tabData.get("formatId");
            String level = (String) tabData.get("level");
            String element_type = (String) tabData.get("element_type");
            String order_category = (String) tabData.get("order_category");
            String order_type = (String) tabData.get("order_type");
            String order_catalog = (String) tabData.get("order_catalog");
            String meaning = (String) tabData.get("meaning");
            traceVals.append("meaning : " + meaning);

            final String SQL_OR_ORDER_ENTRY_FORMAT_INSERT_HDR = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_HDR");
            pstmt_insert_order_entry = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_INSERT_HDR);

            pstmt_insert_order_entry.setString(1, (String) formatId);
            pstmt_insert_order_entry.setString(2, (String) level);
            pstmt_insert_order_entry.setString(3, (String) element_type);
            pstmt_insert_order_entry.setString(4, (String) order_category);
            pstmt_insert_order_entry.setString(5, (String) order_type);
            pstmt_insert_order_entry.setString(6, (String) order_catalog);
            pstmt_insert_order_entry.setString(7, (String) meaning);

            pstmt_insert_order_entry.setString(8, (String) tabData.get("added_by_id"));
            pstmt_insert_order_entry.setString(9, (String) tabData.get("added_at_ws_no"));
            pstmt_insert_order_entry.setString(10, (String) tabData.get("added_facility_id"));
            pstmt_insert_order_entry.setString(11, (String) tabData.get("modified_by_id"));
            pstmt_insert_order_entry.setString(12, (String) tabData.get("modified_at_ws_no"));
            pstmt_insert_order_entry.setString(13, (String) tabData.get("modified_facility_id"));

            traceVals.append("-- before execute --");
            result = pstmt_insert_order_entry.executeUpdate();
            traceVals.append("-- after execute --");


        } 
		catch (Exception e) 
		{
            traceVals.append("Exception if any -- " + e);

            messages.append(e.getMessage());
            e.printStackTrace();
        } 
		finally 
		{
            try 
			{
                if (pstmt_insert_order_entry != null) 
				{
                    pstmt_insert_order_entry.close();
                }
                closeStatement(pstmt_insert_order_entry);
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }
        map.put("traceVal", traceVals.toString());
        return result;

    }

    private int insertListValues(HashMap tabData, HashMap sqlMap, Connection connection) 
	{

        StringBuffer messages = new StringBuffer();
        PreparedStatement pstmt_insert_order_entry_list_dtl = null;
        HashMap map = new HashMap();
        LinkedHashMap default_dependency_values = new LinkedHashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        int result = 0;

        try 
		{
            String formatId = (String) tabData.get("formatId");
            String listValues = (String) tabData.get("listValues");
            TreeMap formatFinalValues = (TreeMap) tabData.get("formatFinalValues");
            default_dependency_values = (LinkedHashMap) tabData.get("dflt_dependency_values");

            traceVals.append("*** listValues ::: " + listValues);

            final String SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DTL = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DTL");

            pstmt_insert_order_entry_list_dtl = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DTL);

            pstmt_insert_order_entry_list_dtl.setString(1, (String) formatId);

            pstmt_insert_order_entry_list_dtl.setString(7, (String) tabData.get("added_by_id"));
            pstmt_insert_order_entry_list_dtl.setString(8, (String) tabData.get("added_at_ws_no"));
            pstmt_insert_order_entry_list_dtl.setString(9, (String) tabData.get("added_facility_id"));
            pstmt_insert_order_entry_list_dtl.setString(10, (String) tabData.get("modified_by_id"));
            pstmt_insert_order_entry_list_dtl.setString(11, (String) tabData.get("modified_at_ws_no"));
            pstmt_insert_order_entry_list_dtl.setString(12, (String) tabData.get("modified_facility_id"));
            //if(listValues != null){

            if (formatFinalValues.size() > 0) 
			{

                //StringTokenizer st1		= new StringTokenizer(listValues,"`");
                String mainStr = "";
                try 
				{
                    //while(st1.hasMoreTokens()){
                    //for(int cnt=0;cnt<formatFinalValues.size();cnt++){
                    Collection c = formatFinalValues.values();     //obtain an Iterator for Collection 
                    Iterator itr = c.iterator();     //iterate through TreeMap values iterator
                    //int itrn=0;
                    while (itr.hasNext()) 
					{

                        //mainStr  = st1.nextToken();
                        mainStr = (String) itr.next();
                        if (mainStr != null && !mainStr.equals("")) 
						{
                            StringTokenizer st2 = new StringTokenizer(mainStr, "~");

                            String lbl_txt = "";
                            String accept_option = "";
                            String dflt_val = "";
                            String agegroup_val = "";
                            String dependency_val = "";
                            int inserted = 0;

                            seq_num_value = (String) st2.nextToken();
                            mnemonic_value = (String) st2.nextToken();
                            lbl_txt = (String) st2.nextToken();
                            accept_option = (String) st2.nextToken();
                            dflt_val = (String) st2.nextToken();
							
                            dflt_val = (dflt_val == null || (dflt_val != null && dflt_val.equals("null"))) ? "" : dflt_val.trim();

                            agegroup_val = (String) st2.nextToken();
                            dependency_val = (String) st2.nextToken();

                            if (!dependency_val.equals(" ") && !dependency_val.equals("Y") && depend_flag == true) 
							{
                                inserted = insertDependValues(dependency_val, tabData, sqlMap, connection, mnemonic_value);
                                //inserted=0;
                                dependency_val = "Y";
                                if (inserted < 1) 
								{
                                    connection.rollback();
                                    messages.append("Insert Failed");
                                }
                            } 
							else if (dependency_val.equals(" ")) 
							{
                                dependency_val = "N";
                            }

                            if (agegroup_val.equals(" "))
							{
                                agegroup_val = "";
                            }

                            lbl_txt = (String) default_dependency_values.get(lbl_txt.trim());
                            dflt_val = default_dependency_values.get(dflt_val) == null ? "" : (String) default_dependency_values.get(dflt_val);
                            dflt_val = dflt_val.equals("null") ? "" : dflt_val;

                            if (dflt_val.equals("null") || dflt_val.equals("") || dflt_val == null) 
							{
                                dflt_val = "";
                            }

                            if (lbl_txt.equals("null") || lbl_txt.equals("") || lbl_txt == null) 
							{
                                lbl_txt = "";
                            }

                            if (inserted >= 1 || dependency_val.equals("N")) 
							{
                                pstmt_insert_order_entry_list_dtl.setString(2, seq_num_value);
                                pstmt_insert_order_entry_list_dtl.setString(3, mnemonic_value);
                                pstmt_insert_order_entry_list_dtl.setString(4, lbl_txt);
                                pstmt_insert_order_entry_list_dtl.setString(5, accept_option);
                                pstmt_insert_order_entry_list_dtl.setString(6, dflt_val);
                                pstmt_insert_order_entry_list_dtl.setString(13, agegroup_val);
                                pstmt_insert_order_entry_list_dtl.setString(14, dependency_val);
                                try
                                {
                                    result = pstmt_insert_order_entry_list_dtl.executeUpdate();
                                } 
								catch (Exception e) 
								{
                                    e.printStackTrace();
                                }
                            }
                            traceVals.append("-- after execute --");
                        }
                    }
                } 
				catch (Exception e) 
				{
                    e.printStackTrace();
                }
            }
        } 
		catch (Exception e) 
		{
            traceVals.append("Exception if any -- " + e);

            messages.append(e.getMessage());
            e.printStackTrace();
        } 
		finally
		{
            try 
			{
                if (pstmt_insert_order_entry_list_dtl != null)
				{
                    pstmt_insert_order_entry_list_dtl.close();
                }
                closeStatement(pstmt_insert_order_entry_list_dtl);
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }
        return result;

    }

    private int insertDependValues(String dependency_val, HashMap tabData, HashMap sqlMap, Connection connection, String mnemonic_value) 
	{
        StringBuffer messages = new StringBuffer();
        LinkedHashMap default_dependency_values = new LinkedHashMap();
        PreparedStatement pstmt_insert_order_entry_depend = null;
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        int result = 0;
        try 
		{
            String formatId = (String) tabData.get("formatId");
            default_dependency_values = (LinkedHashMap) tabData.get("dflt_dependency_values");

            String depend_val = dependency_val;

            traceVals.append("*** depend_val ::: " + depend_val);
            final String SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DEPENDENDENCY = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DEPENDENDENCY");

            pstmt_insert_order_entry_depend = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_INSERT_DEPENDENDENCY);
            pstmt_insert_order_entry_depend.setString(1, (String) formatId);
            pstmt_insert_order_entry_depend.setString(2, (String) seq_num_value);
            pstmt_insert_order_entry_depend.setString(3, (String) mnemonic_value);
            pstmt_insert_order_entry_depend.setString(11, (String) tabData.get("added_by_id"));
            pstmt_insert_order_entry_depend.setString(12, (String) tabData.get("added_at_ws_no"));
            pstmt_insert_order_entry_depend.setString(13, (String) tabData.get("added_facility_id"));
            pstmt_insert_order_entry_depend.setString(14, (String) tabData.get("modified_by_id"));
            pstmt_insert_order_entry_depend.setString(15, (String) tabData.get("modified_at_ws_no"));
            pstmt_insert_order_entry_depend.setString(16, (String) tabData.get("modified_facility_id"));


            if (depend_val != null) 
			{
                StringTokenizer st1 = new StringTokenizer(depend_val, "||");
                String mainStr = "";
                String tempStr = "";
                while (st1.hasMoreTokens()) 
				{

                    mainStr = st1.nextToken();
                    StringTokenizer st2 = new StringTokenizer(mainStr, ",");
                    //String field_mnemonic_value = "";
                    //String value_seq_num = "";
                    String field_mnemonic_value1 = "";
                    String field_value_type = "";
                    String field_mnemonic_action = "";
                    String field_action_msg = "";
                    String field_notify = "";
                    String oth_mnemonic_val = "";
                    String temp_field_mnemonic_value = "";
                    int inserted = 0;
                    traceVals.append("---main token " + mainStr);
                    field_mnemonic_value = (String) st2.nextToken();
                    tempStr = field_mnemonic_value.trim();

                    if (tempStr != null && tempStr.length() > 0) 
					{
                        if ((tempStr.substring(0, 1)).equalsIgnoreCase("Y")) 
						{
                            field_mnemonic_value = tempStr.substring(1, tempStr.length());
                        }
                    }

                    if (field_mnemonic_value.indexOf("dependency_") != -1) 
					{
                        temp_field_mnemonic_value = (String) default_dependency_values.get(field_mnemonic_value.trim());
                    }

                    if (temp_field_mnemonic_value.equals("")) 
					{
                        field_mnemonic_value = field_mnemonic_value;
                    } 
					else 
					{
                        field_mnemonic_value = temp_field_mnemonic_value;
                    }

                    if (st2.hasMoreTokens()) 
					{
                        value_seq_num = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        field_mnemonic_value1 = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        field_value_type = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        field_mnemonic_action = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        field_action_msg = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        field_notify = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        oth_mnemonic_val = (String) st2.nextToken();
                    }

                    if (oth_mnemonic_val == null) 
					{
                        oth_mnemonic_val = "";
                    }

                    oth_mnemonic_val = oth_mnemonic_val.trim();
                    if (!(oth_mnemonic_val.equals(""))) 
					{
                        inserted = insertOthMnemonic(oth_mnemonic_val, tabData, sqlMap, connection, mnemonic_value);
                        oth_mnemonic_val = "Y";
                        if (inserted < 1) 
						{
                            connection.rollback();
                            messages.append("Insert Failed");
                        }
                    } 
					else if (oth_mnemonic_val.equals("")) 
					{
                        oth_mnemonic_val = "N";
                    }

                    if (inserted >= 1 || oth_mnemonic_val.equals("N")) 
					{
                        pstmt_insert_order_entry_depend.setString(4, field_mnemonic_value.trim());
                        pstmt_insert_order_entry_depend.setString(5, value_seq_num);
                        pstmt_insert_order_entry_depend.setString(6, field_mnemonic_value1.trim());
                        pstmt_insert_order_entry_depend.setString(7, field_value_type.trim());
                        pstmt_insert_order_entry_depend.setString(8, field_mnemonic_action);
                        pstmt_insert_order_entry_depend.setString(9, field_action_msg.trim());
                        pstmt_insert_order_entry_depend.setString(10, oth_mnemonic_val);
                        pstmt_insert_order_entry_depend.setString(17, field_notify);
                        result = pstmt_insert_order_entry_depend.executeUpdate();
                    }
                    traceVals.append("-- after execute --");
                }
            }
        } 
		catch (Exception e) 
		{
            traceVals.append("in insertDependValues,Exception if any -- " + e);

            messages.append(e.getMessage());
            e.printStackTrace();
        }
		finally 
		{
            try
            {
                if (pstmt_insert_order_entry_depend != null) 
				{
                    pstmt_insert_order_entry_depend.close();
                }
                closeStatement(pstmt_insert_order_entry_depend);
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }
        return result;
    }

    private int insertOthMnemonic(String oth_mnemonic_val, HashMap tabData, HashMap sqlMap, Connection connection, String mnemonic_value) 
	{
        traceVals.append(" ---just inside 2nd isnert: ");
        StringBuffer messages = new StringBuffer();
        LinkedHashMap default_value_other = new LinkedHashMap();
        PreparedStatement pstmt_insert_order_entry_oth_mnemonic = null;
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        int result = 0;

        try 
		{
            default_value_other = (LinkedHashMap) tabData.get("dflt_dependency_values");
            String formatId = (String) tabData.get("formatId");
            String oth_mnemonic_values = oth_mnemonic_val;

            traceVals.append("*** oth_mnemonic_values ::: " + oth_mnemonic_values);

            final String SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_MNEMONIC = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_MNEMONIC");

            pstmt_insert_order_entry_oth_mnemonic = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_MNEMONIC);

            pstmt_insert_order_entry_oth_mnemonic.setString(1, (String) formatId);
            pstmt_insert_order_entry_oth_mnemonic.setString(2, (String) seq_num_value);
            pstmt_insert_order_entry_oth_mnemonic.setString(3, mnemonic_value);
            pstmt_insert_order_entry_oth_mnemonic.setString(4, (String) field_mnemonic_value);
            pstmt_insert_order_entry_oth_mnemonic.setString(5, (String) value_seq_num);
            pstmt_insert_order_entry_oth_mnemonic.setString(13, (String) tabData.get("added_by_id"));
            pstmt_insert_order_entry_oth_mnemonic.setString(14, (String) tabData.get("added_at_ws_no"));
            pstmt_insert_order_entry_oth_mnemonic.setString(15, (String) tabData.get("added_facility_id"));
            pstmt_insert_order_entry_oth_mnemonic.setString(16, (String) tabData.get("modified_by_id"));
            pstmt_insert_order_entry_oth_mnemonic.setString(17, (String) tabData.get("modified_at_ws_no"));
            pstmt_insert_order_entry_oth_mnemonic.setString(18, (String) tabData.get("modified_facility_id"));

            if (oth_mnemonic_values != null) 
			{

                StringTokenizer st1 = new StringTokenizer(oth_mnemonic_values, "!!");
                String mainStr = "";

                while (st1.hasMoreTokens()) 
				{
                    mainStr = st1.nextToken();

                    StringTokenizer st2 = new StringTokenizer(mainStr, "$");//

                    //String oth_seq_num = ""; //Commentted IN049133
                    //String oth_field_mnemonic = ""; //IN049133
                    String oth_lbl_txt = "";
                    String oth_accept_option = "";
                    String oth_dflt_val = "";
                    String oth_agegroup_val = "";
		    String oth_depend_val = "";//IN049133
		    int inserted = 0;//IN049133

                    //traceVals.append("---main token "+mainStr);
                    if (st2.hasMoreTokens()) 
					{
                        oth_seq_num = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        oth_field_mnemonic = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        oth_lbl_txt = (String) st2.nextToken();
                        oth_lbl_txt = (String) default_value_other.get(oth_lbl_txt.trim());
                    }

                    if (st2.hasMoreTokens()) 
					{
                        oth_accept_option = (String) st2.nextToken();
                    }

                    if (st2.hasMoreTokens()) 
					{
                        oth_dflt_val = (String) st2.nextToken();
                        oth_dflt_val = (String) default_value_other.get(oth_dflt_val.trim());
                    }

                    if (st2.hasMoreTokens()) 
					{
                        oth_agegroup_val = (String) st2.nextToken();
                    }


                    if (oth_agegroup_val.equals(" ")) 
					{
                        oth_agegroup_val = "";
                    }
					//IN049133 - Start
                    String field_type = (String)st2.nextToken();
					System.out.println("OROrderEntryFormatManager.java-----field_type------>"+field_type);
                    String value1 = (String)st2.nextToken();
					System.out.println("OROrderEntryFormatManager.java-----value1------>"+value1);
                    String value2 = (String)st2.nextToken();
					System.out.println("OROrderEntryFormatManager.java-----value2------>"+value2);
					oth_depend_val = (String) st2.nextToken();
					
		    if(" ".equals(oth_depend_val))
		    {
			oth_depend_val = "";
	            }
                    if (!oth_depend_val.equals("") && !oth_depend_val.equals("N") && depend_flag == true) 
					{
                        inserted = insertOthDependValues(oth_depend_val, tabData, sqlMap, connection, mnemonic_value);
                          
                        oth_depend_val = "Y";
                        if (inserted < 1) 
						{
                            connection.rollback();
                            messages.append("Insert Failed");
                        }
                    } 
					else if (oth_depend_val.equals("")) 
					{
                        oth_depend_val = "N";
                    }
					//IN049133 - End
                    pstmt_insert_order_entry_oth_mnemonic.setString(6, oth_field_mnemonic);
                    pstmt_insert_order_entry_oth_mnemonic.setString(7, oth_seq_num);
                    pstmt_insert_order_entry_oth_mnemonic.setString(8, oth_lbl_txt);
                    pstmt_insert_order_entry_oth_mnemonic.setString(9, oth_accept_option);
                    pstmt_insert_order_entry_oth_mnemonic.setString(10, oth_dflt_val.trim());
                    pstmt_insert_order_entry_oth_mnemonic.setString(11, oth_agegroup_val);
		    pstmt_insert_order_entry_oth_mnemonic.setString(12, oth_depend_val);//IN049133

                    result = pstmt_insert_order_entry_oth_mnemonic.executeUpdate();
                    traceVals.append("-- after execute --");

                }
            }
        } 
		catch (Exception e) 
		{
            traceVals.append("insertOthMnemonic,Exception if any -- " + e);

            messages.append(e.getMessage());
            e.printStackTrace();
        } 
		finally
		{
            try 
			{
                if (pstmt_insert_order_entry_oth_mnemonic != null) 
				{
                    pstmt_insert_order_entry_oth_mnemonic.close();
                }
                closeStatement(pstmt_insert_order_entry_oth_mnemonic);
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }
        return result;
    }
//IN049133 - Start
 private int insertOthDependValues(String dependency_val, HashMap tabData, HashMap sqlMap, Connection connection, String mnemonic_value) 
	{
        StringBuffer messages = new StringBuffer();
        LinkedHashMap default_dependency_values = new LinkedHashMap();
        PreparedStatement pstmt_insert_order_entry_oth_depend = null;
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        int result = 0;
        try 
		{
            String formatId = (String) tabData.get("formatId");
            default_dependency_values = (LinkedHashMap) tabData.get("dflt_dependency_values");

            String depend_val = dependency_val;

	     final String SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_DEPEND_MNEMONIC = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_DEPEND_MNEMONIC");
			
            pstmt_insert_order_entry_oth_depend = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_INSERT_OTH_DEPEND_MNEMONIC);
			
            pstmt_insert_order_entry_oth_depend.setString(1, (String) formatId);
            pstmt_insert_order_entry_oth_depend.setString(2, (String) seq_num_value);
            pstmt_insert_order_entry_oth_depend.setString(3, (String) mnemonic_value);
			pstmt_insert_order_entry_oth_depend.setString(4, (String) field_mnemonic_value);
            pstmt_insert_order_entry_oth_depend.setString(5, (String) value_seq_num);
			pstmt_insert_order_entry_oth_depend.setString(6, (String) oth_field_mnemonic);
			pstmt_insert_order_entry_oth_depend.setString(7, (String) oth_seq_num);
            pstmt_insert_order_entry_oth_depend.setString(14, (String) tabData.get("added_by_id"));
            pstmt_insert_order_entry_oth_depend.setString(15, (String) tabData.get("added_at_ws_no"));
            pstmt_insert_order_entry_oth_depend.setString(16, (String) tabData.get("added_facility_id"));
            pstmt_insert_order_entry_oth_depend.setString(17, (String) tabData.get("modified_by_id"));
            pstmt_insert_order_entry_oth_depend.setString(18, (String) tabData.get("modified_at_ws_no"));
            pstmt_insert_order_entry_oth_depend.setString(19, (String) tabData.get("modified_facility_id"));

            if (depend_val != null) 
			{
                StringTokenizer st1 = new StringTokenizer(depend_val, "@");
                String mainStr = "";
                String tempStr = "";
                while (st1.hasMoreTokens()) 
				{
                    mainStr = st1.nextToken();
                    StringTokenizer st2 = new StringTokenizer(mainStr, "^");
                    String oth_depend_field_mnemonic = "";
                    String oth_depend_seq_num = "";
                    String field_value_type = "";
                    String field_mnemonic_action = "";
                    String field_action_msg = "";
                    String value2 = "";
                    
                    String temp_field_mnemonic_value = "";
       
                    oth_depend_field_mnemonic = (String) st2.nextToken();
                    tempStr = oth_depend_field_mnemonic.trim();
                 
                    if (tempStr != null && tempStr.length() > 0) 
					{
                        if ((tempStr.substring(0, 1)).equalsIgnoreCase("Y")) 
						{
                            oth_depend_field_mnemonic = tempStr.substring(1, tempStr.length());
                        }
                    }

                    if (oth_depend_field_mnemonic.indexOf("othdependency_") != -1) 
					{
                        temp_field_mnemonic_value = (String) default_dependency_values.get(oth_depend_field_mnemonic.trim());
                    }

                    if (temp_field_mnemonic_value.equals("")) 
					{
                        oth_depend_field_mnemonic = oth_depend_field_mnemonic;
                    } 
					else 
					{
                        oth_depend_field_mnemonic = temp_field_mnemonic_value;
                    }
			
                    if (st2.hasMoreTokens()) 
					{
                        oth_depend_seq_num = (String) st2.nextToken();
                    }
					
					value2 = (String)st2.nextToken();	
					
                    if (st2.hasMoreTokens()) 
					{
                        field_value_type = (String) st2.nextToken();
                    }
					
                    if (st2.hasMoreTokens()) 
					{
                        field_mnemonic_action = (String) st2.nextToken();
                    }
					
                    if (st2.hasMoreTokens()) 
					{
                        field_action_msg = (String) st2.nextToken();
                    }

                    pstmt_insert_order_entry_oth_depend.setString(8, oth_depend_field_mnemonic.trim());
                    pstmt_insert_order_entry_oth_depend.setString(9, oth_depend_seq_num);
                    pstmt_insert_order_entry_oth_depend.setString(10, value2.trim());
                    pstmt_insert_order_entry_oth_depend.setString(11, field_value_type.trim());
                    pstmt_insert_order_entry_oth_depend.setString(12, field_mnemonic_action);
                    pstmt_insert_order_entry_oth_depend.setString(13, field_action_msg.trim());
            
                    result = pstmt_insert_order_entry_oth_depend.executeUpdate();
                }
            }
        } 
		catch (Exception e) 
		{
            messages.append(e.getMessage());
            e.printStackTrace();
        }
		finally 
		{
            try
            {
                if (pstmt_insert_order_entry_oth_depend != null) 
				{
                    pstmt_insert_order_entry_oth_depend.close();
                }
                closeStatement(pstmt_insert_order_entry_oth_depend);
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }
        return result;
    }    
//IN049133 - End	
    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap modify(HashMap tabData, HashMap sqlMap) 
	{
        //Set keys = tabData.keySet();			
        StringBuffer messages = new StringBuffer();
        HashMap map = new HashMap();
        traceVals.append("--entered in modify--");

        PreparedStatement pstmt_delete_order_entry_format = null;

        Connection connection = null;
        StringBuffer traceVals = new StringBuffer();

        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        int inserted = 0;

        try 
		{
            connection = getConnection((Properties) tabData.get("properties"));

            String format_id = (String) tabData.get("formatId");

            final String SQL_OR_ORDER_ENTRY_DELETE_DTL = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DELETE_DTL");

            traceVals.append("-- before first execute --");

            /*****************/
            if (depend_flag == true) 
			{
                final String SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY");

                if (pstmt_delete_order_entry_format != null)
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }

                pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY);
                pstmt_delete_order_entry_format.setString(1, format_id.trim());

                try
                {
                   inserted = pstmt_delete_order_entry_format.executeUpdate();
                } 
				catch (Exception e) 
				{
                    e.printStackTrace();
                }

                final String SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC");

                if (pstmt_delete_order_entry_format != null) 
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }

                pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC);

                pstmt_delete_order_entry_format.setString(1, format_id.trim());

                inserted = pstmt_delete_order_entry_format.executeUpdate();
				
				//IN049133 - Start
				final String SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC");

                if (pstmt_delete_order_entry_format != null) 
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }

                pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC);

                pstmt_delete_order_entry_format.setString(1, format_id.trim());

                inserted = pstmt_delete_order_entry_format.executeUpdate();
				//IN049133 - End
            }

            if (pstmt_delete_order_entry_format != null) 
			{
                closeStatement(pstmt_delete_order_entry_format);
            }


            ///

            try 
			{
                pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_DELETE_DTL);

                pstmt_delete_order_entry_format.setString(1, format_id);
                inserted = pstmt_delete_order_entry_format.executeUpdate();

            } 
			catch (Exception e)
			{
                e.printStackTrace();
            }
            traceVals.append("-- after first execute --");

            traceVals.append("after delete in modify : " + inserted);
            if (pstmt_delete_order_entry_format != null)
			{
                closeStatement(pstmt_delete_order_entry_format);
            }

            /*****************/

            /*if ( inserted < 1 ) {
            connection.rollback() ;
            messages.append( "Delete Failed" ) ;
            }else{*/
            inserted = 0;
            inserted = insertListValues(tabData, sqlMap, connection);
            if (inserted < 1) 
			{
                connection.rollback();

                messages.append("Insert format Items Failed");
            } 
			else 
			{
                traceVals.append("commit loop");
                connection.commit();
                map.put("result", new Boolean(true));
                map.put("message", "Operation Completed Successfully...");
                messages.append("RECORD_MODIFIED");
            }
            //messages.append( "Operation Completed Successfully..." ) ;
            //}
        } 
		catch (Exception e) 
		{
            traceVals.append("Exception if any -- " + e);

            messages.append(e.getMessage());
            e.printStackTrace();
        } 
		finally 
		{
            try 
			{
                if (pstmt_delete_order_entry_format != null) 
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }
                if (connection != null) 
				{
                    closeConnection(connection, (Properties) tabData.get("properties"));
                }

            } 
			catch (Exception fe)
			{
                fe.printStackTrace();
            }
        }

        map.put("traceVal", traceVals.toString());
        map.put("message", messages.toString());
        return map;
    }

    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap delete(HashMap tabData, HashMap sqlMap) 
	{

        Connection connection = null;
        StringBuffer traceVals = new StringBuffer();
        StringBuffer messages = new StringBuffer();
        HashMap map = new HashMap();

        PreparedStatement pstmt_insert_order_entry_update = null;
        PreparedStatement pstmt_delete_order_entry_format = null;

        traceVals.append("---------------- DELETE ---------------------");

        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));

        int inserted = 0;

        try 
		{
            connection = getConnection((Properties) tabData.get("properties"));
            //connection = getConnection() ;

            String format_id = (String) tabData.get("format_id");

            traceVals.append("connection  : " + connection);
            traceVals.append("format_id  : " + format_id);
            traceVals.append("SQL_OR_ORDER_ENTRY_DELETE_DTL  : " + (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DELETE_DTL"));


            final String SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_DEL = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_DEL");
            pstmt_insert_order_entry_update = connection.prepareStatement(SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_DEL);

            pstmt_insert_order_entry_update.setString(1, format_id.trim());

            traceVals.append("-- before execute of updation of ord catalog--" + SQL_OR_ORDER_ENTRY_UPDATE_CATALOG_DEL);
            pstmt_insert_order_entry_update.executeUpdate();

            closeStatement(pstmt_insert_order_entry_update);
            //inserted = pstmt_insert_order_entry_update.executeUpdate() ;
            traceVals.append("-- after  execute of updation of ord catalog--");

            /*if ( inserted < 1 ) {
            connection.rollback() ;
            messages.append( "Updation in catalog Failed" ) ;
            }else{*/


            final String SQL_OR_ORDER_ENTRY_DELETE_DTL = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DELETE_DTL");

            pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_DELETE_DTL);

            pstmt_delete_order_entry_format.setString(1, format_id.trim());

            traceVals.append("-- before first execute --");
            inserted = pstmt_delete_order_entry_format.executeUpdate();
            traceVals.append("-- after first execute --");

            traceVals.append("after first insert " + inserted);
            /*****************/
            if (depend_flag == true) 
			{
                final String SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY");

                if (pstmt_delete_order_entry_format != null) 
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }
                pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_DELETE_DEPENDENCY);
                pstmt_delete_order_entry_format.setString(1, format_id.trim());
                inserted = pstmt_delete_order_entry_format.executeUpdate();

                final String SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC");

                if (pstmt_delete_order_entry_format != null) 
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }
                pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTH_MNEMONIC);
                pstmt_delete_order_entry_format.setString(1, format_id.trim());
                inserted = pstmt_delete_order_entry_format.executeUpdate();
				//IN049133 - Start
				final String SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC");

                if (pstmt_delete_order_entry_format != null) 
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }
                pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_FORMAT_DELETE_OTHDEPEND_MNEMONIC);
                pstmt_delete_order_entry_format.setString(1, format_id.trim());
                inserted = pstmt_delete_order_entry_format.executeUpdate();
				//IN049133 - End
            }

            if (pstmt_delete_order_entry_format != null) 
			{
                closeStatement(pstmt_delete_order_entry_format);
            }

            inserted = 0;
            final String SQL_OR_ORDER_ENTRY_DELETE_HDR = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_DELETE_HDR");
            pstmt_delete_order_entry_format = connection.prepareStatement(SQL_OR_ORDER_ENTRY_DELETE_HDR);

            pstmt_delete_order_entry_format.setString(1, format_id.trim());

            traceVals.append("-- before 2nd execute --");
            inserted = pstmt_delete_order_entry_format.executeUpdate();
            traceVals.append("-- after 2nd execute --" + inserted);

            if (inserted < 1)
			{
                connection.rollback();
                messages.append("Delete of Header record Failed");
            } 
			else 
			{
                connection.commit();
                map.put("result", new Boolean(true));
                map.put("message", "Operation Completed Successfully...");
                messages.append("RECORD_DELETED");
            }
        } 
		catch (Exception e) 
		{
            traceVals.append("Exception if any -- " + e);

            messages.append(e.getMessage());
            e.printStackTrace();
        } 
		finally 
		{
            try 
			{
                if (pstmt_delete_order_entry_format != null) 
				{
                    closeStatement(pstmt_delete_order_entry_format);
                }
                closeStatement(pstmt_insert_order_entry_update);
                if (connection != null) 
				{
                    //closeConnection(connection);
                    closeConnection(connection, (Properties) tabData.get("properties"));
                }

            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }
        map.put("message", messages.toString());
        map.put("traceVal", traceVals.toString());

        return map;
    }
}
