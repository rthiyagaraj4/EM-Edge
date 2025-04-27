/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      		Name        Description
-----------------------------------------------------------------------
?             	100            		?           created
22/08/2011     	IN028369            Chowminya 	Incident No: IN028369 - <Result Reporting - flagged completed with no result value for child orders> 
14/10/2019    	IN071315	    	Nijitha S   GHL-CRF-0607
24/03/2020     IN072737             SIVABAGYAM M Regression-OR-Common-Replace Order System does not allow to replace order and throws SQL warning.
------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
24/06/2020		IN073157			Nijitha S			24/06/2020		Ramesh G		MMS-KH-SCF-0074		
-------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------
*/
package eOR.ORCompleteOrder;

import java.rmi.*;
import java.util.*;
import java.sql.*;
import javax.ejb.*;
import javax.transaction.*;

import eOR.Common.*;

/**
 *
 * @ejb.bean
 *	name="ORCompleteOrder"
 *	type="Stateless"
 *	transaction-type="Bean"
 *	view-type="both"
 *	jndi-name="ORCompleteOrder"
 *	local-jndi-name="ORCompleteOrder"
 *	impl-class-name="eOR.ORCompleteOrder.ORCompleteOrderManager"
 *	
 *
 * @ejb.interface
 *	extends="javax.ejb.EJBObject"
 *	local-extends="javax.ejb.EJBLocalObject" 
 *	local-class="eOR.ORCompleteOrder.ORCompleteOrderLocal"
 *	remote-class="eOR.ORCompleteOrder.ORCompleteOrderRemote"
 *	generate= "local,remote"
 *
 * @ejb.home
 *	extends="javax.ejb.EJBHome" 
 *	local-extends="javax.ejb.EJBLocalHome"
 *	local-class="eOR.ORCompleteOrder.ORCompleteOrderLocalHome"
 *	remote-class="eOR.ORCompleteOrder.ORCompleteOrderHome"
 *	generate= "local,remote"
 *
 *
 */
public class ORCompleteOrderManager extends OrEJBSessionAdapter 
{
    //SessionContext context ;

    PreparedStatement pstmt = null;
    StringBuffer traceVals = new StringBuffer();

    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap insert(HashMap tabData, HashMap sqlMap) 
	{

        Connection connection = null;
        StringBuffer messages = new StringBuffer();

        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));


        try 
		{
            connection = getConnection((Properties) tabData.get("properties"));
            connection.setAutoCommit(false);

            map = updateValues(connection, tabData, sqlMap);

        } 
		catch (Exception e) 
		{
            traceVals.append("Exception if any -- " + e);

            try 
			{
                connection.rollback();
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
                if (pstmt != null) 
				{
                    closeStatement(pstmt);
                }
                if (connection != null) 
				{
                    closeConnection(connection, (Properties) tabData.get("properties"));
                    connection = null;
                }
            } 
			catch (Exception fe) 
			{
                fe.printStackTrace();
            }
        }

        //map.put( "message", messages.toString() ) ;
        map.put("traceVal", traceVals.toString());

        return map;
    }

    public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap) 
	{
        //PreparedStatement pstmt 	= null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;
        PreparedStatement pstmt5 = null;
        /*Added by Uma on 3/13/2010 for IN019916*/
        PreparedStatement pstmt7 = null;
        PreparedStatement pstmt_set_status = null;
        CallableStatement bill_cstmt = null;
        CallableStatement cstmt_auto_completion = null;
        /*Ends Here IN019916*/
        CallableStatement cstmt = null;
        ResultSet resultSet = null;
        /*Added by Uma on 3/13/2010 for IN019916*/
        ResultSet billResultSet = null;
        ResultSet resultset_status = null;
        /*Ends Here IN019916*/
		PreparedStatement pstmt_child_ord = null;//--[IN028369]--
		ResultSet resultset_child = null;//--[IN028369]--

        //String message 				= "";//removed by kavitha.k 17.12.2004

        HashMap map = new HashMap();

        int count = 0;

        count = Integer.parseInt((String) tabData.get("totalCount"));
        String[] updt_vals1;
        String[] updt_vals2;

        int result = 0;
        String hdr_code = "";
        String tmpStr = "";
        int i = 0;
        String complete_type = "";
        String cont_order_ind = "";
        String p_order_set_status_type = "";

		complete_type = (String) tabData.get("complete_type");
        cont_order_ind = (String) tabData.get("cont_order_ind");
        cont_order_ind = cont_order_ind.trim();
        String currentDate = (String) tabData.get("currentDate");
        String order_category = (String) tabData.get("order_category") == null ? "" : (String) tabData.get("order_category");
        String order_type = (String) tabData.get("order_type") == null ? "" : (String) tabData.get("order_type");
        String practitioner_id = (String) tabData.get("practitioner_id") == null ? "" : (String) tabData.get("practitioner_id");

        tmpStr = (String) tabData.get("tmpStr");
       
        try 
		{
            /*Added by Uma on 3/13/2010 for IN019916*/
            String bill_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
            pstmt7 = connection.prepareStatement(bill_sql);
            pstmt_set_status = connection.prepareStatement("select order_status from or_order where order_id=?");
            bill_cstmt = connection.prepareCall("{ " + (String) sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") + " }");
            cstmt_auto_completion = connection.prepareCall("{ " + (String) sqlMap.get("SQL_OR_AUTOREPORT_COMPLETION") + " }");
            /*Ends Here for IN019916*/
            //Billing related parameters - start
            String p_facility_id = "";
            String p_order_id = "";
            String p_order_line_num = "";
            String p_mode = "CMP";
            String p_user = "";
            String p_ws_no = "";
            //Added by Uma on 3/13/2010 for IN019916
            String p_bill_yn = "";
            String p_error_message = "";
            String p_auto_report_yn = "";
            String order_catalog_code = "";
            String p_order_set_id = "";
            String p_order_set_bill_yn = "N";
            //Billing related parameters - end

            do 
			{
                if ((complete_type.trim()).equals("H"))
				{

                    updt_vals1 = (String[]) tabData.get("head_data");
                    updt_vals2 = (String[]) tabData.get("line_data");

                    if (updt_vals1[0] == null || updt_vals1[0].equals("~")) 
					{
                        updt_vals1[0] = "";
                    }
                    if (updt_vals1[1] == null || updt_vals1[1].equals("~")) 
					{
                        updt_vals1[1] = "";
                    }

                    p_order_id = updt_vals1[0];
                    p_order_line_num = updt_vals1[1];//added
                    p_facility_id = updt_vals1[2];
                    p_user = updt_vals1[3];
                    p_ws_no = updt_vals1[4];
                    p_order_set_id = updt_vals1[5];
                    p_order_set_bill_yn = updt_vals1[6];

                    if (p_order_line_num.equals("")) 
					{
                        p_order_line_num = "1";
                    }

                    /*Added by Uma on 3/13/2010 for IN019916*/
                    pstmt7.setString(1, p_order_id);
                    pstmt7.setString(2, p_order_line_num);

                    billResultSet = pstmt7.executeQuery();

                    if (billResultSet.next()) 
					{
                        p_bill_yn = billResultSet.getString("bill_yn");
                    }
                    closeResultSet(billResultSet);
                    /*Ends Here by Uma on 3/13/2010 for IN019916*/

                    pstmt4 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_AUTOREPORT"));
                    pstmt4.setString(1, p_order_id);
                    pstmt4.setString(2, p_order_line_num);
                    try 
					{
                        resultSet = pstmt4.executeQuery();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "pstmt4 Failed=dm=");
                        return map;
                    }
                    while (resultSet.next()) 
					{
                        p_auto_report_yn = resultSet.getString("auto_report_yn");
                        order_catalog_code = resultSet.getString("order_catalog_code");
                        order_type = resultSet.getString("order_type_code");
                    }
                    closeResultSet(resultSet);
                    closeStatement(pstmt4);

                    if (p_auto_report_yn.equals("Y")) 
					{
						pstmt_child_ord = connection.prepareStatement("select order_id from or_order where order_id=? or parent_order_id=?");//--[IN028369]-- Start
						pstmt_child_ord.setString(1, p_order_id);
						pstmt_child_ord.setString(2, p_order_id);
						try 
						{
						resultset_child = pstmt_child_ord.executeQuery();
						} 
						catch (Exception ex) 
						{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "pstmt_child_ord Failed=dm=");
                        return map;
						}
						
						while (resultset_child.next()) {
						String order_id = (String) resultset_child.getString("order_id"); 
						//--[IN028369]-- End
                        //AutoReport Procedure - Starts
                        cstmt_auto_completion.clearParameters();
                        cstmt_auto_completion = connection.prepareCall("{ " + (String) sqlMap.get("SQL_OR_AUTOREPORT_COMPLETION") + " }");
                        cstmt_auto_completion.setString(1, order_id); 					// P_ORDER_ID
                        cstmt_auto_completion.setString(2, p_order_line_num);				// P_ORDER_LINE_NUM
                        cstmt_auto_completion.setString(3, practitioner_id);				// P_PRACT_ID
                        cstmt_auto_completion.setString(4, currentDate); 					// P_START_DATE
                        cstmt_auto_completion.setString(5, null);							// P_DISCR_MSR_ID
                        cstmt_auto_completion.setString(6, order_catalog_code);				// P_ORDER_CATALOG_CODE
                        cstmt_auto_completion.setString(7, order_type);				 	// P_ORDER_TYPE_CODE
                        cstmt_auto_completion.setString(8, p_ws_no); 						// P_WS_NO
                        cstmt_auto_completion.setString(9, p_user); 						// P_USER
                        cstmt_auto_completion.setString(10, p_facility_id); 				// P_FACILITY_ID
                        cstmt_auto_completion.registerOutParameter(11, Types.VARCHAR); 	// P_ERROR_MESSAGE
                        try 
						{
                            cstmt_auto_completion.execute();
                        } 
						catch (Exception ex)
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", "Billin Procedure Failed");
                            return map;
                        }
                        p_error_message = cstmt_auto_completion.getString(11);  // message

                        if (p_error_message != null && !p_error_message.equals("")) 
						{
                            result = 0;
                        } 
						else
						{
                            result = 1;
                        }


                        if (result < 1) 
						{
                            traceVals.append("====ROLLBACK");
                            map.put("result", new Boolean(false));

                            connection.rollback();
                            map.put("message", p_error_message);

                            return map;
                        }//AutoReport Procedure - ends
                    }
						//--[IN028369]-- Start
						closeResultSet(resultset_child);
						closeStatement(pstmt_child_ord);
						//--[IN028369]-- End
                    }
                    closeStatement(cstmt_auto_completion);

                    if ((p_order_set_bill_yn.equalsIgnoreCase("N")) && (p_bill_yn.equalsIgnoreCase("Y"))) 
					{
                        pstmt_child_ord = connection.prepareStatement("select order_id from or_order where order_id=? or parent_order_id=?");//--[IN028369]-- Start
						pstmt_child_ord.setString(1, p_order_id);
						pstmt_child_ord.setString(2, p_order_id);
						try 
						{
						resultset_child = pstmt_child_ord.executeQuery();
						} 
						catch (Exception ex) 
						{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "pstmt_child_ord Failed=dm=");
                        return map;
						}
		
						 while (resultset_child.next()) {
						String order_id = (String) resultset_child.getString("order_id"); 
						//--[IN028369]-- End
                        bill_cstmt.clearParameters();
                        bill_cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
                        bill_cstmt.setString(2, order_id);						// P_ORDER_ID
                        bill_cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
						if (p_auto_report_yn.equals("Y")) //Added by Uma on 12/15/2010 For IN025486
						{
							p_mode			= "RST";
						}
						else
						{
							p_mode			= "CMP";
						}
						bill_cstmt.setString(4, p_mode); 						// P_MODE
                        bill_cstmt.setString(5, p_user);							// P_USER
                        bill_cstmt.setString(6, p_ws_no);						// P_WS_NO
                        bill_cstmt.registerOutParameter(7, Types.VARCHAR); 	// P_BILL_YN
                        bill_cstmt.registerOutParameter(8, Types.VARCHAR); 	// P_ERROR_MESSAGE
                      //IN071315 Starts
						if("Y".equals((String) tabData.get("p_called_from_ca")))
							bill_cstmt.setString(9, "CA");
						else
							bill_cstmt.setString(9, "OR");
						//IN071315 Ends

                        try 
						{
                            bill_cstmt.execute();
                        } 
						catch (Exception ex) 
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", "SQL_OR_BL_WITHOUT_ORDER_CATALOG Failed");
                            return map;
                        }
                        p_error_message = bill_cstmt.getString(8);  // message

                        if (p_error_message != null && !p_error_message.equals(""))							
						{
                            result = 0;
                        } 
						else 
						{
                            result = 1;
                        }

                        if (result < 1) 
						{
                            traceVals.append("====ROLLBACK");
                            map.put("result", new Boolean(false));

                            connection.rollback();
                            map.put("message", p_error_message);

                            return map;
                        }
                    }
						//--[IN028369]-- Start
						closeResultSet(resultset_child);
						closeStatement(pstmt_child_ord);
						//--[IN028369]-- End
                    }

                    //Billing Procedure - End
                    pstmt4 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1"));

                    if (order_category.equals("PH")) 
					{
                        pstmt4.setString(1, "60");
                    } 
					else 
					{
                        if (p_auto_report_yn.equals("Y")) 
						{
                            pstmt4.setString(1, "85");
                        } 
						else 
						{
                            pstmt4.setString(1, "53");
                        }
                    }
                    //pstmt4.setString( 1, "60") ; // complete code
                    pstmt4.setString(2, updt_vals1[1]);
                    pstmt4.setString(3, p_user);
                    pstmt4.setString(4, p_ws_no);
                    pstmt4.setString(5, p_facility_id);
                    pstmt4.setString(6, updt_vals1[0]);

                    try 
					{
                        result = pstmt4.executeUpdate();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_ORDER_ENTRY_CANCEL_HEADER1 Failed");
                        return map;
                    }
                    closeStatement(pstmt4);
                    //if (pstmt4!=null)pstmt4.close();//added by Kavitha.K 17.12.2004

                    pstmt4 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_REMARKS_UPDATE"));
                    pstmt4.setString(1, updt_vals2[3]);
                    pstmt4.setString(2, updt_vals2[4]);
                    pstmt4.setString(3, p_user);
                    pstmt4.setString(4, p_ws_no);
                    pstmt4.setString(5, p_facility_id);
                    pstmt4.setString(6, updt_vals1[0]);
                    pstmt4.setString(7, "");

                    try 
					{
                        result = pstmt4.executeUpdate();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_ORDER_ENTRY_COMPLETE_REMARKS_UPDATE Failed");
                        return map;
                    }
                    closeStatement(pstmt4);
                    //if (pstmt4!=null)pstmt4.close();//added by Kavitha.K 17.12.2004

                    if (cont_order_ind.equals("DR") || cont_order_ind.equals("CR")) 
					{
                        pstmt4 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN"));
                        if (order_category.equals("PH")) 
						{
                            pstmt4.setString(1, "60");
                        } 
						else 
						{
                            if (p_auto_report_yn.equals("Y")) 
							{
                                pstmt4.setString(1, "85");
                            } 
							else 
							{
                                pstmt4.setString(1, "53");
                            }
                        }
                        //pstmt4.setString( 1, "60") ; // complete code
                        pstmt4.setString(2, updt_vals1[1]);
                        pstmt4.setString(3, p_user);
                        pstmt4.setString(4, p_ws_no);
                        pstmt4.setString(5, p_facility_id);
                        pstmt4.setString(6, updt_vals1[0]);

                        try 
						{
                            pstmt4.executeUpdate();
                        } 
						catch (Exception ex) 
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", "SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN Failed");
                            return map;
                        }
                        closeStatement(pstmt4);
                    }

                    if (result >= 1) 
					{
                        result = 0;
                        pstmt5 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2"));

                        if (order_category.equals("PH")) 
						{
                            pstmt5.setString(1, "60");
                        } 
						else 
						{
                            if (p_auto_report_yn.equals("Y")) 
							{
                                pstmt5.setString(1, "85");
                            }
							else 
							{
                                pstmt5.setString(1, "53");
                            }
                        }
                        //pstmt5.setString( 1, "60"  ) ; // complete code
                        pstmt5.setString(2, null);
                        pstmt5.setString(3, null);
                        pstmt5.setString(4, null);
                        pstmt5.setString(5, currentDate);
                        pstmt5.setString(6, null);
                        pstmt5.setString(7, null);
                        pstmt5.setString(8, null);
                        pstmt5.setString(9, null);
                        pstmt5.setString(10, null);
                        pstmt5.setString(11, null);
                        pstmt5.setString(12, null);
                        pstmt5.setString(13, p_user);
                        pstmt5.setString(14, p_ws_no);
                        pstmt5.setString(15, p_facility_id);
                        pstmt5.setString(16, updt_vals2[2]);

                        try 
						{
                            result = pstmt5.executeUpdate();
                        } 
						catch (Exception ex)
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", "SQL_OR_ORDER_ENTRY_CANCEL_HEADER2 Failed");
                            return map;
                        }
                        closeStatement(pstmt5);
                        //if (pstmt5!=null)pstmt5.close();//added by Kavitha.K 17.12.2004

                        if (cont_order_ind.equals("DR") || cont_order_ind.equals("CR")) 
						{
                            pstmt5 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN"));

                            if (order_category.equals("PH")) 
							{
                                pstmt5.setString(1, "60");
                            }
							else 
							{
                                if (p_auto_report_yn.equals("Y"))
								{
                                    pstmt5.setString(1, "85");
                                }
								else
								{
                                    pstmt5.setString(1, "53");
                                }
                            }
                            //pstmt5.setString( 1, "60"  ) ; // complete code
                            pstmt5.setString(2, null);
                            pstmt5.setString(3, null);
                            pstmt5.setString(4, null);
                            pstmt5.setString(5, currentDate);
                            pstmt5.setString(6, null);
                            pstmt5.setString(7, null);
                            pstmt5.setString(8, null);
                            pstmt5.setString(9, null);
                            pstmt5.setString(10, null);
                            pstmt5.setString(11, null);
                            pstmt5.setString(12, null);
                            pstmt5.setString(13, p_user);
                            pstmt5.setString(14, p_ws_no);
                            pstmt5.setString(15, p_facility_id);
                            pstmt5.setString(16, updt_vals2[2]);

                            try 
							{
                                pstmt5.executeUpdate();
                            } 
							catch (Exception ex) 
							{
                                ex.printStackTrace();
                                map.put("result", new Boolean(false));
                                connection.rollback();
                                map.put("message", "SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN Failed");
                                return map;
                            }
                            closeStatement(pstmt5);
                        }
                    }
                } 
				else if ((complete_type.trim()).equals("L")) 
				{
                    updt_vals1 = (String[]) tabData.get("head_data" + i);
                    updt_vals2 = (String[]) tabData.get("line_data");

                    if (updt_vals1[0] == null || updt_vals1[0].equals("~")) 
					{
                        updt_vals1[0] = null;
                    }
                    if (updt_vals1[1] == null || updt_vals1[1].equals("~")) 
					{
                        updt_vals1[1] = null;
                    }

                    p_order_id = updt_vals1[2];
                    p_order_line_num = updt_vals1[3];
                    p_facility_id = updt_vals1[4];
                    p_user = updt_vals1[5];
                    p_ws_no = updt_vals1[6];
                    p_order_set_id = updt_vals1[7];
                    p_order_set_bill_yn = updt_vals1[8];

                    /*Added by Uma on 3/13/2010 for IN019916*/
                    pstmt7.setString(1, p_order_id);
                    pstmt7.setString(2, p_order_line_num);

                    billResultSet = pstmt7.executeQuery();
                    if (billResultSet.next()) 
					{
                        p_bill_yn = billResultSet.getString("bill_yn");
                    }
                    /*Ends Here by Uma on 3/13/2010 for IN019916*/

                    pstmt4 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_AUTOREPORT"));
                    pstmt4.setString(1, p_order_id);
                    pstmt4.setString(2, p_order_line_num);

                    try 
					{
                        resultSet = pstmt4.executeQuery();
                    }
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_ORDER_ENTRY_COMPLETE_LINE_AUTOREPORT Failed");
                        return map;
                    }

                    while (resultSet.next()) 
					{
                        p_auto_report_yn = resultSet.getString("auto_report_yn");
                        order_catalog_code = resultSet.getString("order_catalog_code");
                        order_type = resultSet.getString("order_type_code");
                    }

                    closeResultSet(resultSet);
                    closeStatement(pstmt4);


                    if (p_auto_report_yn.equals("Y")) 
					{
					pstmt_child_ord = connection.prepareStatement("select order_id from or_order where order_id=? or parent_order_id=?");//--[IN028369]-- Start
						pstmt_child_ord.setString(1, p_order_id);
						pstmt_child_ord.setString(2, p_order_id);
						try 
						{
						resultset_child = pstmt_child_ord.executeQuery();
						} 
						catch (Exception ex) 
						{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "pstmt_child_ord Failed=dm=");
                        return map;
						}
						
						while (resultset_child.next()) {
						String order_id = (String) resultset_child.getString("order_id"); 
						//--[IN028369]-- End
                        //AutoReport Procedure - Starts
                        cstmt_auto_completion.clearParameters();
                        cstmt_auto_completion.setString(1, order_id); 					// P_ORDER_ID
                        cstmt_auto_completion.setString(2, p_order_line_num);				// P_ORDER_LINE_NUM
                        cstmt_auto_completion.setString(3, practitioner_id);				// P_PRACT_ID
                        cstmt_auto_completion.setString(4, currentDate); 					// P_START_DATE
                        cstmt_auto_completion.setString(5, null);							// P_DISCR_MSR_ID
                        cstmt_auto_completion.setString(6, order_catalog_code);				// P_ORDER_CATALOG_CODE
                        cstmt_auto_completion.setString(7, order_type);				 	// P_ORDER_TYPE_CODE
                        cstmt_auto_completion.setString(8, p_ws_no); 						// P_WS_NO
                        cstmt_auto_completion.setString(9, p_user); 						// P_USER
                        cstmt_auto_completion.setString(10, p_facility_id); 				// P_FACILITY_ID
                        cstmt_auto_completion.registerOutParameter(11, Types.VARCHAR); 	// P_ERROR_MESSAGE

                        try 
						{
                            cstmt_auto_completion.execute();
                        } 
						catch (Exception ex) 
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", "SQL_OR_AUTOREPORT_COMPLETION Failed");
                            return map;
                        }
                        p_error_message = cstmt_auto_completion.getString(11);  // message

                        if (p_error_message != null && !p_error_message.equals(""))
						{
                            result = 0;
                        } 
						else 
						{
                            result = 1;
                        }


                        if (result < 1) 
						{
                            traceVals.append("====ROLLBACK");
                            map.put("result", new Boolean(false));

                            connection.rollback();
                            map.put("message", p_error_message);

                            return map;
                        }//AutoReport Procedure - ends
                    }
						//--[IN028369]-- Start
						closeResultSet(resultset_child);
						closeStatement(pstmt_child_ord);
						//--[IN028369]-- End
                    }
                    
                    //Billing Procedure - Start
                    if ((p_order_set_bill_yn.equalsIgnoreCase("N")) && (p_bill_yn.equalsIgnoreCase("Y"))) 
					{
					pstmt_child_ord = connection.prepareStatement("select order_id from or_order where order_id=? or parent_order_id=?");//--[IN028369]-- Start
						pstmt_child_ord.setString(1, p_order_id);
						pstmt_child_ord.setString(2, p_order_id);
						try 
						{
						resultset_child = pstmt_child_ord.executeQuery();
						} 
						catch (Exception ex) 
						{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "pstmt_child_ord Failed=dm=");
                        return map;
						}
						
						while (resultset_child.next()) {
						String order_id = (String) resultset_child.getString("order_id"); 
						//--[IN028369]-- End
                        bill_cstmt.clearParameters();
                        bill_cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID

                        //if((p_order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(p_order_set_id.equals(""))))
                        //{

                        //cstmt.setString(2, p_order_set_id);						// P_ORDER_ID
                        //cstmt.setString(3,"1");				// P_ORDER_LINE_NUM
                        //}
                        //else
                        //{

                        bill_cstmt.setString(2, order_id);						// P_ORDER_ID
                        bill_cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
                        //}
						if (p_auto_report_yn.equals("Y")) //Added by Uma on 12/15/2010 for IN025486
						{
							p_mode			= "RST";
						}
						else
						{
							p_mode			= "CMP";
						}
                        bill_cstmt.setString(4, p_mode); 						// P_MODE
                        bill_cstmt.setString(5, p_user);							// P_USER
                        bill_cstmt.setString(6, p_ws_no);						// P_WS_NO
                        bill_cstmt.registerOutParameter(7, Types.VARCHAR); 	// P_BILL_YN
                        bill_cstmt.registerOutParameter(8, Types.VARCHAR); 	// P_ERROR_MESSAGE
                        //IN073157 Starts
						if("Y".equals((String) tabData.get("p_called_from_ca")))
							bill_cstmt.setString(9, "CA");
						else
							bill_cstmt.setString(9, "OR");
						//IN073157 Ends
                        try 
						{
                            bill_cstmt.execute();
                        } 
						catch (Exception ex)
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", "SQL_OR_BL_WITHOUT_ORDER_CATALOG Failed");
                            return map;
                        }
                        p_error_message = bill_cstmt.getString(8);  // message

                        if (p_error_message != null && !p_error_message.equals("")) 
						{
                            result = 0;
                        } 
						else 
						{
                            result = 1;
                        }

                        if (result < 1) 
						{
                            traceVals.append("====ROLLBACK");
                            map.put("result", new Boolean(false));

                            connection.rollback();
                            map.put("message", p_error_message);
                            return map;
                        }
						}
						//--[IN028369]-- Start
						closeResultSet(resultset_child);
						closeStatement(pstmt_child_ord);
						//--[IN028369]-- End
                    }

                    //Billing Procedure - End
                    pstmt3 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1"));

                    if (order_category.equals("PH")) 
					{
                        pstmt3.setString(1, "60");
                    }
					else 
					{
                        if (p_auto_report_yn.equals("Y")) 
						{
                            pstmt3.setString(1, "85");
                        } 
						else 
						{
                            pstmt3.setString(1, "53");
                        }
                    }

                    pstmt3.setString(2, updt_vals1[0]);
                    pstmt3.setString(3, updt_vals1[1]);
                    pstmt3.setString(4, p_user);
                    pstmt3.setString(5, p_ws_no);
                    pstmt3.setString(6, p_facility_id);
                    pstmt3.setString(7, updt_vals1[2]);
                    pstmt3.setString(8, updt_vals1[3]);
                    try 
					{
                        result = pstmt3.executeUpdate();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_ORDER_ENTRY_COMPLETE_LINE1 Failed");
                        return map;
                    }
                    closeStatement(pstmt3);

                    //if (pstmt3!=null)pstmt3.close();//added by Kavitha.K 17.12.2004
                    pstmt3 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_REMARKS_UPDATE"));
                    pstmt3.setString(1, updt_vals2[2]);
                    pstmt3.setString(2, updt_vals2[3]);
                    pstmt3.setString(3, p_user);
                    pstmt3.setString(4, p_ws_no);
                    pstmt3.setString(5, p_facility_id);
                    pstmt3.setString(6, updt_vals1[2]);
                    pstmt3.setString(7, updt_vals1[3]);
                    try 
					{
                        result = pstmt3.executeUpdate();
                    } 
					catch (Exception ex)
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();

                        map.put("message", "SQL_OR_ORDER_ENTRY_COMPLETE_REMARKS_UPDATE Failed");
                        return map;
                    }
                    closeStatement(pstmt3);
                    //if (pstmt3!=null)pstmt3.close();//added by Kavitha.K 17.12.2004

                    if ((cont_order_ind.trim()).equals("DR") || (cont_order_ind.trim()).equals("CR")) 
					{

                        pstmt3 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1_FREQ_EXPLN"));
						/*Added by Uma on 6/19/2010 for IN021472*/
						if (order_category.equals("PH")) 
						{
							pstmt3.setString(1, "60");
						}
						else 
						{
							if (p_auto_report_yn.equals("Y")) 
							{
								pstmt3.setString(1, "85");
							} 
							else 
							{
								pstmt3.setString(1, "53");
							}
						}
						/*Ends Here by Uma on 6/19/2010 for IN021472*/
                        pstmt3.setString(2, updt_vals1[0]);
                        pstmt3.setString(3, updt_vals1[1]);
                        pstmt3.setString(4, p_user);
                        pstmt3.setString(5, p_ws_no);
                        pstmt3.setString(6, p_facility_id);
                        pstmt3.setString(7, updt_vals1[2]);
                        pstmt3.setString(8, updt_vals1[3]);

                        try 
						{
                            pstmt3.executeUpdate();
                        } 
						catch (Exception ex) 
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();

                            map.put("message", "SQL_OR_ORDER_ENTRY_COMPLETE_LINE1_FREQ_EXPLN Failed");
                            return map;
                        }
                        closeStatement(pstmt3);
                    }
                }

                i++;
            } while (i < count);

            //}while(i+1<count);

            if ((complete_type.trim()).equals("L")) 
			{
                updt_vals2 = (String[]) tabData.get("line_data");
                String sql = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_SELECT");

                int t = sql.lastIndexOf("?");
                sql = sql.substring(0, t) + tmpStr.trim() + sql.substring(t + 1);

                pstmt2 = connection.prepareStatement(sql);
                pstmt2.setString(1, (String) updt_vals2[1].trim());
                try 
				{
                    resultSet = pstmt2.executeQuery();
                } 
				catch (Exception ex) 
				{
                    ex.printStackTrace();
                    map.put("result", new Boolean(false));
                    connection.rollback();

                    map.put("message", "SQL_OR_ORDER_ENTRY_COMPLETE_LINE_SELECT Failed");
                    return map;
                }

                while (resultSet.next()) 
				{
                    hdr_code = resultSet.getString("order_line_status");
                }

                if (((hdr_code.trim()).equals("")) || ((hdr_code.trim()).equals("CD"))) 
				{

                    result = 0;
                    pstmt1 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE3"));

                    if (order_category.equals("PH")) 
					{
                        pstmt1.setString(1, "60");
                    } 
					else 
					{
                        if (p_auto_report_yn.equals("Y"))
						{
                            pstmt1.setString(1, "85");
                        } 
						else 
						{
                            pstmt1.setString(1, "53");
                        }
                    }
                    //pstmt1.setString( 1, "60") ; // complete code
                    pstmt1.setString(2, p_user);
                    pstmt1.setString(3, p_ws_no);
                    pstmt1.setString(4, p_facility_id);
                    pstmt1.setString(5, updt_vals2[1].trim());
                    try 
					{
                        result = pstmt1.executeUpdate();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();

                        map.put("message", "SQL_OR_ORDER_ENTRY_CANCEL_LINE3 Failed");
                        return map;
                    }
                    closeStatement(pstmt1);
                    //if (pstmt1!=null)pstmt1.close();//added by Kavitha.K 17.12.2004
                    if (cont_order_ind.equals("DR") || cont_order_ind.equals("CR")) 
					{
                        //result=0;
                        pstmt1 = connection.prepareStatement((String) sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN"));

                        if (order_category.equals("PH")) 
						{
                            pstmt1.setString(1, "60");
                        } 
						else 
						{
                            //if(p_auto_report_yn.equals("Y"))
                            //pstmt1.setString( 1, "85") ;
                            //else
                            pstmt1.setString(1, "53");
                        }
                        //pstmt1.setString( 1, "60") ; // complete code
                        pstmt1.setString(2, p_user);
                        pstmt1.setString(3, p_ws_no);
                        pstmt1.setString(4, p_facility_id);
                        pstmt1.setString(5, updt_vals2[1].trim());
                        try
                        {
                          pstmt1.executeUpdate();
                        } 
						catch (Exception ex) 
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();

                            map.put("message", "SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN Failed");
                            return map;
                        }
                        closeStatement(pstmt1);
                    }
                }
            }

            if ((p_order_set_bill_yn.equalsIgnoreCase("Y")) && (!(p_order_set_id.equals("")))) 
			{

                pstmt_set_status.setString(1, p_order_set_id);
                resultset_status = pstmt_set_status.executeQuery();
                while (resultset_status.next())
				{
                    p_order_set_status_type = resultset_status.getString("order_status");
                }
                closeStatement(pstmt_set_status);
                closeResultSet(resultset_status);

                if (p_order_set_status_type == null) 
				{
                    p_order_set_status_type = "";
                }
                if ((p_order_set_bill_yn.equalsIgnoreCase("Y")) && (!(p_order_set_id.equals(""))) && ((p_order_set_status_type.equalsIgnoreCase("RS")))) 
				{
                    bill_cstmt.clearParameters();
                    bill_cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
                    bill_cstmt.setString(2, p_order_set_id);						// P_ORDER_ID
                    bill_cstmt.setString(3, "1");				// P_ORDER_LINE_NUM
                    bill_cstmt.setString(4, p_mode); 						// P_MODE
                    bill_cstmt.setString(5, p_user);							// P_USER
                    bill_cstmt.setString(6, p_ws_no);						// P_WS_NO
                    bill_cstmt.registerOutParameter(7, Types.VARCHAR); 	// P_BILL_YN
                    bill_cstmt.registerOutParameter(8, Types.VARCHAR); 	// P_ERROR_MESSAGE
                    try 
					{
                        bill_cstmt.execute();
                        //closeStatement( bill_cstmt ) ;
                    } 
					catch (Exception fe) 
					{
                        fe.printStackTrace();
                    }
                    p_error_message = bill_cstmt.getString(8);  // message
                    if (p_error_message != null && !p_error_message.equals("")) 
					{
                        result = 0;
                    }
					else 
					{
                        result = 1;
                    }

                }
            }
            if (result < 1) 
			{
                traceVals.append("====ROLLBACK");
                connection.rollback();
                map.put("result", new Boolean(false));
                map.put("message", "Operation failure ...");

            } 
			else 
			{
                traceVals.append("====COMMIT");
                connection.commit();
                map.put("result", new Boolean(true));
                map.put("message", "RECORD_MODIFIED");
                //messages.append( "RECORD_MODIFIED" ) ;
                //messages.append( "Operation Completed Successfully..." ) ;
            }
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
            traceVals.append("====Exception : " + e);

        } 
		finally 
		{
            try 
			{
                closeResultSet(resultSet);
                closeResultSet(billResultSet);
                closeStatement(pstmt1);
                closeStatement(pstmt2);
                closeStatement(pstmt3);
                closeStatement(pstmt4);
                closeStatement(pstmt5);
                closeStatement(pstmt7);
                closeStatement(cstmt);
                closeStatement(bill_cstmt);
                closeStatement(cstmt_auto_completion);
            } 
			catch (Exception ee) 
			{
                ee.printStackTrace();
            }
        }
        return map;
    }

    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    public HashMap modify(HashMap tabData, HashMap sqlMap) 
	{
        StringBuffer messages = new StringBuffer();
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag", "");
        map.put("callOnSuccess", new Boolean(false));
        map.put("message", messages.toString());
        map.put("traceVal", traceVals.toString());
        /********************************************************************/
        Connection connection = null;
        CallableStatement cstmt = null;
        CallableStatement cstmt_charge_type = null;
        PreparedStatement pstmt7 = null;
        PreparedStatement pstmt_catalog = null;
        PreparedStatement pstmt_line_update = null;
        PreparedStatement pstmt_bill_msg = null;
        PreparedStatement pstmt_schl = null;
        PreparedStatement pstmt_episode_dtls = null;
        PreparedStatement pstmt_auth = null;
        PreparedStatement pstmt_bill = null;
        PreparedStatement pstmt_physician = null;
        PreparedStatement pstmt_pkg = null;

        String bill_yn = "";
        String cont_order_ind = "";
        String p_error_message = "";
        String p_subs_module_id = "";
        String p_subs_regn_num = "";
        String p_subs_regn_line_num = "";
        String p_err_code = "";
        String p_sys_message_id = "";
        String p_error_text = "";
        String print_report_yn = "";
        //String p_print_report_yn			 = "";
        String p_error_code = "";
        String p_error_level = "";
        String p_err_text = "";
        String cancel_allow_yn = "";
        //String cancel_allow_yn			 = "";
        int print_report_count = 0;
        String print_billing_report_yn = "";
        ResultSet print_bill = null;

        ResultSet resultSet_bill = null;
        ResultSet resultSet_bill_msg = null;
        ResultSet resultSet_catalog = null;
        ResultSet resultSet_schl = null;
        ResultSet resultSet_episode_dtls = null;
        ResultSet resultSet_auth = null;
        ResultSet resultSet_physician = null;
        ResultSet resultSet_pkg = null;

        Hashtable print_report_values = new Hashtable(); //Global  // For On Line Printing(Billing Report Details)
        CallableStatement cstmt_sub_module_dtls = null;
        CallableStatement cstmt_cancel_allow_yn = null;
        CallableStatement cstmt_freq_order = null;
        CallableStatement cstmt_charge_dtls = null;
        CallableStatement cstmt_replace = null;
        CallableStatement cstmt_bl = null;
        /*Added by Uma on 2/11/2010 for package billing CRF 712*/
        CallableStatement cstmt_swap = null;
        String billingPackageRef = "";
        String p_error_text_bl = "";
        String p_sysmessage_id_bl = "";
        String p_error_level_bl = "";
        String order_catalog_code = "";
        String patient_id = "";
        String pkg_closed_yn = "N";
        /*Ends Here*/
        try 
		{
            connection = getConnection((Properties) tabData.get("properties"));
            connection.setAutoCommit(false);
            /*Added by Uma on 2/11/2010 for package billing CRF 712*/
            cstmt_swap = connection.prepareCall("{ " + (String) OrRepositoryExt.getOrKeyValue("SQL_OR_GET_BILLING_PACKAGE_SWAP_ORDERABLE") + " }");
            pstmt_catalog = connection.prepareStatement("select order_catalog_code,patient_id from or_order_line a,or_order b where a.order_id=b.order_id and a.order_id = ? and a.order_line_num = ?");
            pstmt_bill_msg = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE"));
            /*Ends Here*/
            pstmt_line_update = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_OR_ORDER_LINE_UPDATE"));
            //cstmt_charge_type = connection.prepareCall("{ CALL BL_PROC_FOR_EXT_SERVICE_MP.POPULATE_INTERFACED_RECS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,To_Date(?,dd/mm/yyyy hh24:mi') ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? }");
            pstmt_physician = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_PHYSICIAN_ID_SELECT"));
            pstmt_schl = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_MONTH_DAY_TIME"));
            pstmt_episode_dtls = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_EPISODE_VISIT_ID_SELECT"));
            cstmt_charge_dtls = connection.prepareCall("{ " + OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_GET_ORDER_CATALOG_CHARGE_DTLS") + " }");
            pstmt_auth = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_BL_AUTH_FOR_CHARGE_YN"));
            cstmt_bl = connection.prepareCall("{ " + OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") + " }");
            cstmt_replace = connection.prepareCall("{ " + OrRepository.getOrKeyValue("SQL_OR_ORDER_REPLACEABLE_ACTIVATION") + " }");
            cstmt_cancel_allow_yn = connection.prepareCall("{ ? = call  BL_PROC_ITEM_VALIDATIONS_MP.IS_CANCEL_ORDER_ALLOWED_YN(?,?,?,?,?,?,?,?,?,?,?)}");
            cstmt_sub_module_dtls = connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_SEC_KEY_FOR_PRIM_KEY(?,?,?,?,?,?,?,?,?) }");
            cstmt_freq_order = connection.prepareCall("{call OR_FREQ_ORD_CAN_DIS(?,?,?,?,?,?,?,?,?,?) }");
            pstmt7 = connection.prepareStatement("select nvl(PRINT_BILLING_REPORT_YN,'N') print_billing_report_yn from or_param_by_facility where operating_facility_id=?");
            String bill_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
            pstmt_pkg = connection.prepareStatement("select blpackage.check_package_closed(?,?,?) pkg_close_yn from dual");

            if (((String) tabData.get("function_from")).equals("Replace")) 
			{
                //String p_error_message	= "";
                int result = 0;

                billingPackageRef = (String) getBillingPackageRef(connection, (String) tabData.get("order_id"), (String) tabData.get("order_line_num"));

                if (Integer.parseInt(billingPackageRef) > 0) 
				{

                    pstmt_catalog.setString(1, (String) tabData.get("order_id"));
                    pstmt_catalog.setString(2, (String) tabData.get("order_line_num"));
                    resultSet_catalog = pstmt_catalog.executeQuery();
                    if (resultSet_catalog.next()) 
					{
                        order_catalog_code = resultSet_catalog.getString("order_catalog_code");
                        patient_id = resultSet_catalog.getString("patient_id");
                    }
                    pstmt_pkg.setString(1, (String) tabData.get("login_facility_id"));
                    pstmt_pkg.setString(2, patient_id);
                    pstmt_pkg.setString(3, billingPackageRef);
                    resultSet_pkg = pstmt_pkg.executeQuery();
                    if (resultSet_pkg.next())
					{
                        pkg_closed_yn = resultSet_pkg.getString("pkg_close_yn");
                    }
                    closeResultSet(resultSet_pkg);
                }

                if ((Integer.parseInt(billingPackageRef) == 0) || ((Integer.parseInt(billingPackageRef) > 0) && pkg_closed_yn.equalsIgnoreCase("N"))) 
				{

                    pstmt7.setString(1, (String) tabData.get("login_facility_id"));
                    print_bill = pstmt7.executeQuery();
                    if (print_bill.next()) 
					{
                        print_billing_report_yn = print_bill.getString("print_billing_report_yn");
                    }

                    pstmt_bill = connection.prepareStatement(bill_sql);
                    pstmt_bill.setString(1, (String) tabData.get("order_id"));
                    pstmt_bill.setString(2, (String) tabData.get("order_line_num"));
                    resultSet_bill = pstmt_bill.executeQuery();
                    if (resultSet_bill.next()) 
					{
                        bill_yn = resultSet_bill.getString("bill_yn");
                        cont_order_ind = resultSet_bill.getString("cont_order_ind");
                    }

                    if (bill_yn.equalsIgnoreCase("Y")) 
					{
                        if ((cont_order_ind.equalsIgnoreCase("CR")) || (cont_order_ind.equalsIgnoreCase("DR"))) 
						{
                            cstmt_freq_order.setString(1, (String) tabData.get("order_id"));										// P_ORDER_ID
                            cstmt_freq_order.setString(2, (String) tabData.get("order_line_num"));						    // P_ORDER_LINE_NUM
                            cstmt_freq_order.setString(3, (String) tabData.get("login_facility_id"));									    // P_FACILITY_ID
                            cstmt_freq_order.setString(4, "CAN");									    // P_mode
                            cstmt_freq_order.setString(5, (String) tabData.get("login_by_id"));									    // P_login_ID
                            cstmt_freq_order.setString(6, (String) tabData.get("login_at_ws_no"));									    // P_ws_no
                            cstmt_freq_order.registerOutParameter(7, Types.VARCHAR); 	// P_PRINT_YN
                            cstmt_freq_order.registerOutParameter(8, Types.VARCHAR); 	// P_ERR_CODE
                            cstmt_freq_order.registerOutParameter(9, Types.VARCHAR); 	// P_SYS_MESSAGE_ID
                            cstmt_freq_order.registerOutParameter(10, Types.VARCHAR); 	// P_ERROR_TEXT					
                            cstmt_freq_order.execute();

                            print_report_yn = cstmt_freq_order.getString(7);						// P_PRINT_YN
                            p_error_code = cstmt_freq_order.getString(8);				// P_ERR_CODE
                            p_sys_message_id = cstmt_freq_order.getString(9);		// P_SYS_MESSAGE_ID
                            p_err_text = cstmt_freq_order.getString(10);				        // P_ERROR_TEXT
                            if (p_error_code == null) 
							{
                                p_error_code = "";
                            }

                            if (p_error_code.equals("")) 
							{
                                if ((print_report_yn.equalsIgnoreCase("Y")) && (print_billing_report_yn.equalsIgnoreCase("Y"))) 
								{
                                    print_report_values.put("p_facility_id" + print_report_count, (String) tabData.get("login_facility_id"));
                                    print_report_values.put("p_order_id" + print_report_count, (String) tabData.get("order_id"));
                                    print_report_values.put("p_order_line_num" + print_report_count, (String) tabData.get("order_line_num"));
                                    print_report_values.put("print_report_yn" + print_report_count, print_report_yn);
                                    //map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
                                    print_report_count++;
                                    print_report_values.put("total_recs", String.valueOf(print_report_count));
                                }
                                if (print_report_count > 0) 
								{
                                    map.put("print_report_values", print_report_values); // For On Line Printing(Billing Details)
                                }
                            }
                            if (p_error_code == null) 
							{
                                p_error_code = "";
                            }
                            if (p_err_text == null) 
							{
                                p_err_text = "";
                            }
                            if (p_err_text != null && !p_err_text.equals("")) 
							{
                                result = 0;
                            } 
							else
							{
                                result = 1;
                            }
                            if (result < 1) 
							{
                                traceVals.append("====ROLLBACK");
                                map.put("result", new Boolean(false));
                                connection.rollback();
                                map.put("message", p_err_text);
                                return map;
                            } 
							else if (!p_error_code.equals("")) 
							{
                                map.put("result", new Boolean(false));
                                map.put("message", p_error_code);
                                connection.rollback();
                                return map;
                            } 
							else
							{
                                map.put("message", "RECORD_MODIFIED");
                                map.put("result", new Boolean(true));
                                connection.commit();
                                return map;
                            }

                        } 
						else 
						{

                            try 
							{

                                cstmt_sub_module_dtls.setString(1, (String) tabData.get("login_facility_id"));									    // P_FACILITY_ID
                                cstmt_sub_module_dtls.setString(2, (String) tabData.get("order_id"));										// P_ORDER_ID
                                cstmt_sub_module_dtls.setString(3, (String) tabData.get("order_line_num"));						    // P_ORDER_LINE_NUM
                                cstmt_sub_module_dtls.registerOutParameter(4, Types.VARCHAR); 	// P_SUBS_MODULE_ID
                                cstmt_sub_module_dtls.registerOutParameter(5, Types.VARCHAR); 	// P_SUBS_REGN_NUM
                                cstmt_sub_module_dtls.registerOutParameter(6, Types.VARCHAR); 	// P_SUBS_REGN_LINE_NUM
                                cstmt_sub_module_dtls.registerOutParameter(7, Types.VARCHAR); 	// P_ERR_CODE
                                cstmt_sub_module_dtls.registerOutParameter(8, Types.VARCHAR); 	// P_SYS_MESSAGE_ID	
                                cstmt_sub_module_dtls.registerOutParameter(9, Types.VARCHAR); 	// P_ERROR_TEXT
                                cstmt_sub_module_dtls.execute();
                                p_subs_module_id = cstmt_sub_module_dtls.getString(4);						// P_SUBS_MODULE_ID
                                p_subs_regn_num = cstmt_sub_module_dtls.getString(5);						    // P_SUBS_REGN_NUM
                                p_subs_regn_line_num = cstmt_sub_module_dtls.getString(6);				    // P_SUBS_REGN_LINE_NUM
                                p_err_code = cstmt_sub_module_dtls.getString(7);				                    // P_ERR_CODE
                                p_sys_message_id = cstmt_sub_module_dtls.getString(8);				        // P_SYS_MESSAGE_ID
                                p_error_text = cstmt_sub_module_dtls.getString(9);				                    // P_ERROR_TEXT

                                if ((p_err_code != null && p_err_code != "null" && !p_err_code.equals("")) && (p_sys_message_id != null && p_sys_message_id != "null" && !p_sys_message_id.equals(""))) 
								{
                                } 
								else 
								{

                                    cstmt_cancel_allow_yn.registerOutParameter(1, java.sql.Types.VARCHAR);
                                    cstmt_cancel_allow_yn.setString(2, (String) tabData.get("login_facility_id"));
									//IN071315 Starts
                                    //cstmt_cancel_allow_yn.setString(3, "OR");
                                    if("Y".equals((String) tabData.get("p_called_from_ca")))
                                    	cstmt_cancel_allow_yn.setString(3, "OR|CA");
                                    else{
                                    	cstmt_cancel_allow_yn.setString(3, "OR|OR");
                                    }
									//IN071315 Ends
                                    cstmt_cancel_allow_yn.setString(4, (String) tabData.get("order_id"));
                                    cstmt_cancel_allow_yn.setString(5, (String) tabData.get("order_line_num"));
                                    cstmt_cancel_allow_yn.setString(6, p_subs_module_id);
                                    cstmt_cancel_allow_yn.setString(7, p_subs_regn_num);
                                    cstmt_cancel_allow_yn.setString(8, p_subs_regn_line_num);
                                    cstmt_cancel_allow_yn.registerOutParameter(9, java.sql.Types.VARCHAR);
                                    cstmt_cancel_allow_yn.registerOutParameter(10, java.sql.Types.VARCHAR);
                                    cstmt_cancel_allow_yn.registerOutParameter(11, java.sql.Types.VARCHAR);
                                    cstmt_cancel_allow_yn.registerOutParameter(12, java.sql.Types.VARCHAR);

                                    cstmt_cancel_allow_yn.execute();
                                    cancel_allow_yn = cstmt_cancel_allow_yn.getString(1);
                                    print_report_yn = cstmt_cancel_allow_yn.getString(9);
                                    p_error_code = cstmt_cancel_allow_yn.getString(10);
                                    p_error_level = cstmt_cancel_allow_yn.getString(11);
                                    p_err_text = cstmt_cancel_allow_yn.getString(12);

                                }
                                print_report_yn = (print_report_yn == null) ? "N" : print_report_yn;
                                p_error_code = (p_error_code == null) ? "" : p_error_code;
                                p_error_level = (p_error_level == null) ? "" : p_error_level;
                                p_error_text = (p_err_text == null) ? "" : p_err_text;
                                cancel_allow_yn = (cancel_allow_yn == null) ? "" : cancel_allow_yn;
                            } 
							catch (Exception ce) 
							{
                                ce.printStackTrace();
                            }
                        }
                    }
                    //print_report_yn = "Y";
			/*if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
                    {
                    print_report_values.put("p_facility_id"+print_report_count,(String)tabData.get("login_facility_id"));
                    print_report_values.put("p_order_id"+print_report_count,(String)tabData.get("order_id"));
                    print_report_values.put("p_order_line_num"+print_report_count,(String)tabData.get("order_line_num"));
                    print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
                    //map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
                    print_report_count++;
                    print_report_values.put("total_recs",print_report_count); 		
                    }*/
                    //map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
                    if ((bill_yn.equalsIgnoreCase("Y")) && (cancel_allow_yn.equalsIgnoreCase("Y"))) 
					{
                        if (!((cont_order_ind.equalsIgnoreCase("DR")) || (cont_order_ind.equalsIgnoreCase("CR")))) 
						{
                            //cstmt_bl = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
                            cstmt_bl.setString(1, (String) tabData.get("login_facility_id"));
                            cstmt_bl.setString(2, (String) tabData.get("order_id"));
                            cstmt_bl.setString(3, (String) tabData.get("order_line_num"));
                            cstmt_bl.setString(4, "CAN");
                            cstmt_bl.setString(5, (String) tabData.get("login_by_id"));
                            cstmt_bl.setString(6, (String) tabData.get("login_at_ws_no"));
                            cstmt_bl.registerOutParameter(7, Types.VARCHAR);
                            cstmt_bl.registerOutParameter(8, Types.VARCHAR);
                          //IN071315 Starts
							if("Y".equals((String) tabData.get("p_called_from_ca")))
								cstmt_bl.setString(9, "CA");
							else
								cstmt_bl.setString(9, "OR");
							//IN071315 Ends
                            try 
							{
                                cstmt_bl.execute();
                            } 
							catch (Exception ee) 
							{
                                ee.printStackTrace();
                                map.put("result", new Boolean(false));
                                connection.rollback();
                                map.put("message", "SQL_OR_BL_WITHOUT_ORDER_CATALOG Failed");
                                return map;
                            }
                            p_error_message = cstmt_bl.getString(8);
                            if (p_error_message != null && !p_error_message.equals("")) 
							{
                                map.put("result", new Boolean(false));
                                connection.rollback();
                                map.put("message", p_error_message);
                                return map;
                                //break;													
                            } // End of !err_message
                            else 
							{
                                if ((print_report_yn.equalsIgnoreCase("Y")) && (print_billing_report_yn.equalsIgnoreCase("Y"))) 
								{
                                    print_report_values.put("p_facility_id" + print_report_count, (String) tabData.get("login_facility_id"));
                                    print_report_values.put("p_order_id" + print_report_count, (String) tabData.get("order_id"));
                                    print_report_values.put("p_order_line_num" + print_report_count, (String) tabData.get("order_line_num"));
                                    print_report_values.put("print_report_yn" + print_report_count, print_report_yn);
                                    //map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
                                    print_report_count++;
                                    print_report_values.put("total_recs", String.valueOf(print_report_count));
                                }
                                if (print_report_count > 0)
								{
                                    map.put("print_report_values", print_report_values); // For On Line Printing(Billing Details)
                                }
                            }
                            if (p_error_message != null && !p_error_message.equals("")) 
							{
                                result = 0;
                            } 
							else 
							{
                                result = 1;
                            }
                            closeStatement(cstmt);
                            if (result < 1) 
							{
                                map.put("result", new Boolean(false));
                                connection.rollback();
                                map.put("message", p_error_message);
                                return map;
                            }
                        }
                    } 
					else 
					{  /*Modified by Uma on 2/15/2010 for IN019274*/
                        if (bill_yn.equalsIgnoreCase("Y"))
						{
                            if (p_error_code == null)
							{
                                p_error_code = "";
                            }
                            if (p_error_message == null)
							{
                                p_error_message = "";
                            }
                            if (!p_error_code.equals("")) 
							{
                                map.put("message", p_error_code);
                                map.put("result", new Boolean(false));
                                connection.rollback();
                                result = 0;
                                return map;
                            } 
							else if (!p_error_message.trim().equals(""))
							{
                                map.put("message", p_error_message);
                                map.put("result", new Boolean(false));
                                connection.rollback();
                                result = 0;
                                return map;
                            } 
							else 
							{
                                result = 1;
                            }
                            //return map;
                        }
                        /*Ends Here IN019274*/
                    }
                }

                if (result >= 0) 
				{

                    cstmt_replace.setString(1, (String) tabData.get("order_id"));
                    cstmt_replace.registerOutParameter(2, Types.VARCHAR);
                    cstmt_replace.setString(3, (String) tabData.get("order_line_num"));
                    cstmt_replace.setString(4, (String) tabData.get("new_order_catalog"));
                    cstmt_replace.setString(5, (String) tabData.get("remarks_text"));
                    cstmt_replace.setString(6, (String) tabData.get("login_by_id"));
                    cstmt_replace.setString(7, (String) tabData.get("login_at_ws_no"));
                    try 
					{
                        cstmt_replace.execute();
                    } 
					catch (Exception ex)
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_ORDER_REPLACEABLE_ACTIVATION Failed");
                        return map;
                    }
                    p_error_message = cstmt_replace.getString(2);
                    if (p_error_message != null && !p_error_message.equals("")) 
					{
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", p_error_message);
                        return map;
                        //break;												
                    } // End of !err_message
                    if (p_error_message != null && !p_error_message.equals("")) 
					{
                        result = 0;
                    } 
					else 
					{
                        result = 1;
                    }
                    closeStatement(cstmt);
                    if (result < 1)
					{
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", p_error_message);
                        return map;
                    }
                }

                if (result >= 0) 
				{

                    if (pkg_closed_yn.equalsIgnoreCase("N")) 
					{

                        cstmt_bl.setString(1, (String) tabData.get("login_facility_id"));
                        cstmt_bl.setString(2, (String) tabData.get("order_id"));
                        cstmt_bl.setString(3, (String) tabData.get("order_line_num"));
                        cstmt_bl.setString(4, "REG");
                        cstmt_bl.setString(5, (String) tabData.get("login_by_id"));
                        cstmt_bl.setString(6, (String) tabData.get("login_at_ws_no"));
                        cstmt_bl.registerOutParameter(7, Types.VARCHAR);
                        cstmt_bl.registerOutParameter(8, Types.VARCHAR);
                      //IN072737 Starts
						if("Y".equals((String) tabData.get("p_called_from_ca")))
							cstmt_bl.setString(9, "CA");
						else
							cstmt_bl.setString(9, "OR");
						//IN072737 Ends
                        try 
						{
                            cstmt_bl.execute();
                        } 
						catch (Exception ex) 
						{
                            ex.printStackTrace();
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", "SQL_OR_BL_WITHOUT_ORDER_CATALOG Failed");
                            return map;
                        }
                        p_error_message = cstmt_bl.getString(8);
                        if (p_error_message != null && !p_error_message.equals(""))
						{
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", p_error_message);
                            return map;
                            //break;
                        } // End of !err_message
                        if (p_error_message != null && !p_error_message.equals("")) 
						{
                            result = 0;
                        } 
						else
						{
                            result = 1;
                        }
                        closeStatement(cstmt);
                        if (result < 1) 
						{
                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", p_error_message);
                            return map;
                        }
                    }
                }
                /*Added by Uma on 2/10/2010 for package billing*/

                if (Integer.parseInt(billingPackageRef) > 0) 
				{

                    cstmt_swap.clearParameters();
                    cstmt_swap.setString(1, (String) tabData.get("login_facility_id"));	//p_facility_id
                    cstmt_swap.setString(2, patient_id);	//p_patient_id
                    cstmt_swap.setInt(3, Integer.parseInt(billingPackageRef));	//p_package_seq_no
                    cstmt_swap.setString(4, order_catalog_code); //catalog_code
                    cstmt_swap.setString(5, (String) tabData.get("login_by_id")); //p_user	
                    cstmt_swap.setString(6, (String) tabData.get("login_at_ws_no")); //p_at_ws_no
                    cstmt_swap.registerOutParameter(7, Types.VARCHAR); //p_error_level
                    cstmt_swap.registerOutParameter(8, Types.VARCHAR); //p_sysmessage_id
                    cstmt_swap.registerOutParameter(9, Types.VARCHAR); //p_error_text 
                    try
                    {
                       cstmt_swap.execute();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_ORDER_REPLACEABLE_ACTIVATION Failed");
                        return map;
                    }
                    p_error_level_bl = cstmt_swap.getString(7);
                    p_sysmessage_id_bl = cstmt_swap.getString(8);
                    p_error_text_bl = cstmt_swap.getString(9);
                    if (p_sysmessage_id_bl != null && !p_sysmessage_id_bl.equals(""))
					{

                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", p_sysmessage_id_bl);

                        return map;

                    } 
					else if (p_error_level_bl != null && !p_error_level_bl.equals("")) 
					{

                        if (p_error_text_bl != null && !p_error_text_bl.equals("")) 
						{

                            map.put("result", new Boolean(false));
                            connection.rollback();
                            map.put("message", p_error_text_bl);

                            return map;
                        }
                    }

                }
                /*Ends Here*/
                closeStatement(cstmt_swap);

                if (result >= 0) 
				{
                    connection.commit();
                    map.put("result", new Boolean(true));
                    map.put("message", "RECORD_MODIFIED");
                    return map;
                }
            } 
			else if (((String) tabData.get("function_from")).equals("ChargeType"))
			{

                String authorised_yn = "";
                //String p_error_message	= "";
                PreparedStatement pstmt = null;
                ResultSet resultSet = null;

                int result = 0;
                //pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_BL_AUTH_FOR_CHARGE_YN") ) ;
                pstmt_auth.setString(1, (String) tabData.get("login_facility_id"));
                pstmt_auth.setString(2, "U");
                pstmt_auth.setString(3, (String) tabData.get("login_by_id"));
                pstmt_auth.setString(4, "CA");
                pstmt_auth.setString(5, "CLINICIAN_ACCESS");

                try
                {
                   resultSet_auth = pstmt_auth.executeQuery();
                }
				catch (Exception ex) 
				{
                    ex.printStackTrace();
                    map.put("result", new Boolean(false));
                    connection.rollback();
                    map.put("message", "SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_BL_AUTH_FOR_CHARGE_YN Failed");
                    return map;
                }

                while (resultSet_auth != null && resultSet_auth.next()) 
				{
                    authorised_yn = resultSet_auth.getString("authorised_yn");
                }

                if (authorised_yn.equals("Y")) 
				{
                    result = 1;
                }
				else 
				{
                    result = 0;
                }
                closeResultSet(resultSet_auth);

                if (result < 1) 
				{

                    pstmt_auth.setString(1, (String) tabData.get("login_facility_id"));
                    pstmt_auth.setString(2, "R");
                    pstmt_auth.setString(3, null);
                    pstmt_auth.setString(4, "CA");
                    pstmt_auth.setString(5, "CLINICIAN_ACCESS");
                    try 
					{
                        resultSet_auth = pstmt_auth.executeQuery();
                    }
					catch (Exception ex)
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_BL_AUTH_FOR_CHARGE_YN Failed");
                        return map;
                    }

                    while (resultSet_auth != null && resultSet_auth.next()) 
					{
                        authorised_yn = resultSet_auth.getString("authorised_yn");
                    }

                    if (authorised_yn.equals("Y")) 
					{
                        result = 1;
                    } 
					else 
					{
                        result = 0;
                    }


                    if (result < 1)
					{
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "CHANGE_CHARGE_TYPE_NO_ACCESS");
                        return map;
                    }
                }

                String episode_type = "";
                String patient_class = (String) tabData.get("patient_class");

                if (patient_class.equals("IP") || patient_class.equals("EA"))
				{
                    episode_type = "I";
                } 
				else if (patient_class.equals("OP")) 
				{
                    episode_type = "O";
                }
				else if (patient_class.equals("EM")) 
				{
                    episode_type = "E";
                } 
				else if (patient_class.equals("DC")) 
				{
                    episode_type = "D";
                }
				else if (patient_class.equals("XT")) 
				{
                    episode_type = "R";
                }

                String p_serv_panel_ind = "";
                String p_serv_panel_code = "";
                String p_charging_stage = "";
                String msg = "";

                cstmt_charge_dtls.setString(1, "OR");
                cstmt_charge_dtls.setString(2, (String) tabData.get("catalog_code"));
                cstmt_charge_dtls.setString(3, episode_type);
                cstmt_charge_dtls.setString(4, (String) tabData.get("new_charge_type"));
                cstmt_charge_dtls.registerOutParameter(5, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(6, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(7, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(8, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(9, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(10, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(11, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(12, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(13, Types.VARCHAR);
                cstmt_charge_dtls.registerOutParameter(14, Types.VARCHAR);

                try
				{
                    cstmt_charge_dtls.execute();
                }  
				catch (Exception ex) 
				{
                    ex.printStackTrace();
                    map.put("result", new Boolean(false));
                    connection.rollback();
                    map.put("message", "SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_GET_ORDER_CATALOG_CHARGE_DTLS Failed");
                    return map;
                }

                p_serv_panel_ind = cstmt_charge_dtls.getString(6);
                p_serv_panel_code = cstmt_charge_dtls.getString(7);
                p_charging_stage = cstmt_charge_dtls.getString(8);
                p_err_code = cstmt_charge_dtls.getString(12);
                p_sys_message_id = cstmt_charge_dtls.getString(13);
                p_error_text = cstmt_charge_dtls.getString(14);

                if (p_err_code == null && p_error_text != null) 
				{
                    result = 0;
                    msg = p_error_text;
                }
				else if (p_sys_message_id != null) 
				{
                    result = 0;
                    //pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE") ) ;
                    pstmt_bill_msg.setString(1, p_sys_message_id);
                    try 
					{
                        resultSet_bill_msg = pstmt_bill_msg.executeQuery();
                    } 
					catch (Exception ex) 
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_ORDER_ENTRY_BILL_MESSAGE Failed");
                        return map;
                    }

                    while (resultSet != null && resultSet.next()) 
					{
                        msg = resultSet.getString("message_text_sysdef");

                    }
                    closeResultSet(resultSet);
                    closeStatement(pstmt);
                } 
				else 
				{
                    result = 1;
                }
                closeStatement(cstmt);

                if (result < 1) 
				{
                    map.put("result", new Boolean(false));
                    connection.rollback();
                    map.put("message", msg);
                    return map;
                }

                String p_episode_id = "";
                String p_visit_id = "";
                String p_physician_id = "";

                pstmt_episode_dtls.setString(1, (String) tabData.get("order_id"));
                resultSet_episode_dtls = pstmt_episode_dtls.executeQuery();

                while (resultSet_episode_dtls != null && resultSet_episode_dtls.next()) 
				{
                    p_episode_id = resultSet_episode_dtls.getString("episode_id");
                    p_visit_id = resultSet_episode_dtls.getString("episode_visit_num");
                }

                pstmt_physician.setString(1, (String) tabData.get("order_id"));
                pstmt_physician.setString(2, (String) tabData.get("order_line_num"));
                resultSet_physician = pstmt_physician.executeQuery();

                while (resultSet_physician != null && resultSet_physician.next())
				{
                    p_physician_id = resultSet_physician.getString("ord_pract_id");
                }

                String sysdate = "";

                resultSet_schl = pstmt_schl.executeQuery();

                while (resultSet_schl != null && resultSet_schl.next())
				{
                    sysdate = resultSet_schl.getString("sys_date_time");
                }

                cstmt_charge_type = connection.prepareCall("{ CALL BL_PROC_FOR_EXT_SERVICE_MP.POPULATE_INTERFACED_RECS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,To_Date(?,dd/mm/yyyy hh24:mi') ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? }");
                cstmt_charge_type.setString(1, "CHG");
                cstmt_charge_type.setString(2, (String) tabData.get("login_facility_id"));
                cstmt_charge_type.setString(3, episode_type);
                cstmt_charge_type.setString(4, (String) tabData.get("patient_id"));
                cstmt_charge_type.setString(5, p_episode_id);
                cstmt_charge_type.setString(6, p_visit_id);
                cstmt_charge_type.setString(7, (String) tabData.get("order_id"));
                cstmt_charge_type.setString(8, (String) tabData.get("order_line_num"));
                //IN071315 Starts
                //cstmt_charge_type.setString(9, "OR");
                if("Y".equals((String) tabData.get("p_called_from_ca")))
                {
                	cstmt_charge_type.setString(9, "OR|CA");
                }
                else{
                	cstmt_charge_type.setString(9, "OR|OR");
                }
                //IN071315 Ends
                cstmt_charge_type.setString(10, (String) tabData.get("order_id"));
                cstmt_charge_type.setString(11, (String) tabData.get("order_line_num"));
                cstmt_charge_type.setString(12, p_serv_panel_ind);
                cstmt_charge_type.setString(13, p_serv_panel_code);
                cstmt_charge_type.setString(14, p_charging_stage);
                cstmt_charge_type.setString(15, (String) tabData.get("catalog_code"));
                cstmt_charge_type.setString(16, (String) tabData.get("catalog_desc"));
                cstmt_charge_type.setString(17, "1");
                cstmt_charge_type.setString(18, null);
                cstmt_charge_type.setString(19, p_physician_id);
                cstmt_charge_type.setString(20, sysdate);
                cstmt_charge_type.setString(21, (String) tabData.get("login_by_id"));
                cstmt_charge_type.setString(22, (String) tabData.get("login_at_ws_no"));
                cstmt_charge_type.registerOutParameter(23, Types.VARCHAR);
                cstmt_charge_type.registerOutParameter(24, Types.VARCHAR);
                cstmt_charge_type.registerOutParameter(25, Types.VARCHAR);
                cstmt_charge_type.execute();
                p_err_code = cstmt_charge_type.getString(23);
                p_sys_message_id = cstmt_charge_type.getString(24);
                p_error_text = cstmt_charge_type.getString(25);

                if (p_err_code == null && p_error_text != null) 
				{
                    result = 0;
                    msg = p_error_text;
                }
				else if (p_sys_message_id != null) 
				{
                    result = 0;

                    pstmt_bill_msg.setString(1, p_sys_message_id);
                    resultSet_bill_msg = pstmt_bill_msg.executeQuery();

                    while (resultSet_bill_msg != null && resultSet_bill_msg.next())
					{
                        msg = resultSet_bill_msg.getString("message_text_sysdef");
                    }

                } 
				else 
				{
                    result = 1;
                }

                if (result < 1) 
				{
                    map.put("result", new Boolean(false));
                    connection.rollback();
                    map.put("message", msg);
                    return map;
                }
				else 
				{


                    pstmt_line_update.setString(1, (String) tabData.get("new_charge_type"));
                    pstmt_line_update.setString(2, (String) tabData.get("login_by_id"));
                    pstmt_line_update.setString(3, (String) tabData.get("login_at_ws_no"));
                    pstmt_line_update.setString(4, (String) tabData.get("login_facility_id"));
                    pstmt_line_update.setString(5, (String) tabData.get("order_id"));
                    try 
					{
                        pstmt_line_update.executeUpdate();
                    } 
					catch (Exception ex)
					{
                        ex.printStackTrace();
                        map.put("result", new Boolean(false));
                        connection.rollback();
                        map.put("message", "SQL_OR_RESULT_ENTRY_OR_ORDER_LINE_UPDATE Failed");
                        return map;
                    }
                    connection.commit();
                    map.put("result", new Boolean(true));
                    map.put("message", "RECORD_MODIFIED");
                }
            }

        } catch (Exception e)
		{
            traceVals.append("Exception if any -- " + e);

            try 
			{
                connection.rollback();
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
                closeStatement(pstmt7);
                closeResultSet(print_bill);
                closeStatement(pstmt);
                closeStatement(pstmt_bill);
                closeStatement(pstmt_line_update);
                closeStatement(pstmt_bill_msg);
                closeStatement(pstmt_schl);
                closeStatement(pstmt_physician);
                closeStatement(pstmt_episode_dtls);
                closeStatement(pstmt_auth);
                closeStatement(pstmt_catalog);
                closeResultSet(resultSet_episode_dtls);
                closeResultSet(resultSet_bill_msg);
                closeResultSet(resultSet_schl);
                closeResultSet(resultSet_bill);
                closeResultSet(resultSet_physician);
                closeResultSet(resultSet_auth);
                closeResultSet(resultSet_catalog);
                closeStatement(cstmt);
                closeStatement(cstmt_charge_type);
                closeStatement(cstmt_charge_dtls);
                closeStatement(cstmt_bl);
                closeStatement(cstmt_replace);
                closeStatement(cstmt_cancel_allow_yn);
                closeStatement(cstmt_sub_module_dtls);
                closeStatement(cstmt_freq_order);
                closeStatement(pstmt_pkg);
                if (connection != null) 
				{
                    closeConnection(connection, (Properties) tabData.get("properties"));
                    connection = null;
                }
            } 
			catch (Exception fe)
			{
                fe.printStackTrace();
            }
        }
        /********************************************************************/
        return map;
    }

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

    /****************************************************************************/
    /**
     * @ejb.interface-method
     *	 view-type="both"
     */
    /*Added by Uma on 2/10/2010 package billing*/
    public String getBillingPackageRef(Connection connection, String order_id, String order_line_num) throws Exception 
	{
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String billingPackageRef = "";
        try
        {
            pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_BILLING_PACKAGE_REF"));
            pstmt.clearParameters();
            pstmt.setString(1, order_id);
            pstmt.setString(2, order_line_num);
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) 
			{
                billingPackageRef = resultSet.getString("billing_package_ref") == null ? "0" : resultSet.getString("billing_package_ref");
            }
        }
		catch (Exception e) 
		{
            e.printStackTrace();
            throw e;
        } 
		finally 
		{
            closeResultSet(resultSet);
            closeStatement(pstmt);
        }
        return billingPackageRef;
    }
    /*Ends Here*/
}
