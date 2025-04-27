/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.*;
import javax.naming.*;

import eOR.Common.*;
import eCommon.Common.*;

import eOR.ORReportAuthorization.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ReportAuthorizationBean extends OrAdapter implements java.io.Serializable 
{
    /*   HttpServletRequest request = null;
    HttpServletResponse response = null;
    
    
    public void setRequestResponse(HttpServletRequest request, HttpServletResponse response){
    this.request = request;
    this.response = response;
    }*/

    /**
    This will populate all the locations for the location type
    @return		:	ArrayList
     */
    Hashtable printParameters = new Hashtable();
    private ArrayList parameters = new ArrayList();

    public Hashtable getPrintValues() 
	{
        return printParameters;
    }

    public void setAll(Hashtable hash) 
	{

        this.mode = (String) hash.get("mode");
        //this.request = (HttpServletRequest)hash.get("HttpRequest");
        //this.response = (HttpServletResponse)hash.get("HttpResponse");


        int total_recs = Integer.parseInt(checkForNull((String) hash.get("total_recs"), "-1"));

        parameters = new ArrayList();

        if (total_recs != 0) 
		{ //that means there are some records

            for (int i = 0; i < total_recs; i++) 
			{
                String chk = checkForNull((String) hash.get("chk" + i), "N");
                if (chk.trim().equalsIgnoreCase("Y")) 
				{
                    try 
					{
                        HashMap param = new HashMap();
                        param.put("practitioner_id", (String) hash.get("practitioner_id"));
                        param.put("practitioner_type", (String) hash.get("practitioner_type"));
                        param.put("order_id", (String) hash.get("order_id" + i));
                        param.put("result_type", (String) hash.get("result_type" + i));
                        param.put("result_status", (String) hash.get("result_status" + i));
                        param.put("report_srl_no", (String) hash.get("report_srl_no" + i));
                        param.put("ord_typ_code", (String) hash.get("order_type_code" + i));
                        param.put("patient_class", (String) hash.get("patient_class" + i));
                        param.put("priority", (String) hash.get("priority" + i));
                        param.put("source_type", (String) hash.get("source_type" + i));
                        param.put("location_code", (String) hash.get("source_code" + i));
                        param.put("order_set_id", (String) hash.get("order_set_id" + i));
                        param.put("bill_yn", (String) hash.get("bill_yn" + i));
                        String order_set_bill_yn = (((String) getOrderSetDetails((String) hash.get("order_set_id" + i))) == null ? "N" : ((String) getOrderSetDetails((String) hash.get("order_set_id" + i))));
                        param.put("order_set_bill_yn", order_set_bill_yn);

                        parameters.add(param);
                    } 
					catch (Exception e) 
					{

                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void clear() 
	{
        parameters = new ArrayList();
    }

    public String isAuthorised(String practitioner_id, String resp_id) throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String isValid = null;

        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_CHK_VALID_USER"));
            pstmt.setString(1, practitioner_id.trim());
            pstmt.setString(2, resp_id.trim());

            resultSet = pstmt.executeQuery();

            if (resultSet != null && resultSet.next()) 
			{
                isValid = resultSet.getString(1);
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
            closeConnection(connection);
        }

        return isValid;
    }

    /**
    This will populate the order category
    @return		:	ArrayList
     */
    public String[] getOrdercategory(String practitioner_id, String resp_id) throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        PreparedStatement pstmt1 = null;
        ResultSet resultSet1 = null;
        String[] order_cat = new String[2];

        try
        {
        
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_SELECT_ORD_CAT"));
            pstmt.setString(1, language_id);
            pstmt.setString(2, practitioner_id.trim());

            resultSet = pstmt.executeQuery();
            boolean recordsFound = false;

            if (resultSet != null && resultSet.next()) 
			{
                order_cat[0] = resultSet.getString(1);
                order_cat[1] = resultSet.getString(2);
                recordsFound = true;
            }

            if (!recordsFound) 
			{
                pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_SELECT_ORD_CAT1"));
                pstmt1.setString(1, language_id);
                pstmt1.setString(2, resp_id.trim());

                resultSet1 = pstmt1.executeQuery();

                if (resultSet1 != null && resultSet1.next()) 
				{
                    order_cat[0] = resultSet1.getString(1);
                    order_cat[1] = resultSet1.getString(2);
                } 
				else 
				{
                    order_cat[0] = "";
                    order_cat[1] = "";
                }
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
            closeResultSet(resultSet1);
            closeStatement(pstmt);
            closeStatement(pstmt1);
            closeConnection(connection);
        }

        return order_cat;
    }

    public ArrayList getOrderCategory(String practitioner_id, String resp_id) throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        PreparedStatement pstmt1 = null;
        ResultSet resultSet1 = null;
        //String[] order_cat 			= new String[2];
        ArrayList orderCategory = new ArrayList();

        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_SELECT_ORD_CAT"));
            pstmt.setString(1, language_id);
            pstmt.setString(2, practitioner_id.trim());

            resultSet = pstmt.executeQuery();

            boolean recordsFound = false;
            while (resultSet != null && resultSet.next()) 
			{
                String[] order_cat = new String[2];
                order_cat[0] = resultSet.getString(1);
                order_cat[1] = resultSet.getString(2);
                orderCategory.add(order_cat);
                recordsFound = true;
            }

            if (!recordsFound) 
			{
                pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_SELECT_ORD_CAT1"));
                pstmt1.setString(1, language_id);
                pstmt1.setString(2, resp_id.trim());

                resultSet1 = pstmt1.executeQuery();

                while (resultSet1 != null && resultSet1.next())
				{
                    String[] order_cat = new String[2];
                    order_cat[0] = resultSet1.getString(1);
                    order_cat[1] = resultSet1.getString(2);
                    orderCategory.add(order_cat);
                    recordsFound = true;
                }

                if (!recordsFound) 
				{
                    String[] order_cat = new String[2];
                    order_cat[0] = "";
                    order_cat[1] = "";
                    orderCategory.add(order_cat);
                }
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
            closeResultSet(resultSet1);
            closeStatement(pstmt);
            closeStatement(pstmt1);
            closeConnection(connection);
        }

        return orderCategory;
    }

    public ArrayList getActivityType(String order_category, String order_type) throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        ArrayList ActivityType = new ArrayList();

        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT"));
            pstmt.setString(1, language_id);
            pstmt.setString(2, order_category.trim());
            pstmt.setString(3, order_type.trim());
            //pstmt.setString( 4, language_id);
            //pstmt.setString( 5, order_category.trim() ) ;


            resultSet = pstmt.executeQuery();
            while (resultSet.next()) 
			{
                String[] record = new String[2];
                record[0] = resultSet.getString("activity_type");
                record[1] = resultSet.getString("short_desc");

                ActivityType.add(record);

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
            closeConnection(connection);
        }

        return ActivityType;
    }

    /**
    This will populate the order category by preactiotioner ID
    @return		:	ArrayList
     */
    public ArrayList getOrderType(String ord_cat, String practitioner_id, String resp_id) throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        PreparedStatement pstmt1 = null;
        ResultSet resultSet1 = null;
        ArrayList OrderCat = new ArrayList();

        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_SELECT_ORD_TYPE"));
            pstmt.setString(1, language_id);
            pstmt.setString(2, ord_cat.trim());
            pstmt.setString(3, practitioner_id.trim());
            //pstmt.setString( 3, ord_cat.trim() ) ;
            //pstmt.setString( 4, practitioner_id.trim() ) ;

            resultSet = pstmt.executeQuery();

            boolean recordsFound = false;
            if (resultSet != null) 
			{
                while (resultSet != null && resultSet.next()) 
				{
                    String[] record = new String[2];
                    record[0] = resultSet.getString("order_type_code");
                    record[1] = resultSet.getString("short_desc");

                    OrderCat.add(record);
                    recordsFound = true;
                }
            }

            if (!recordsFound) 
			{
                pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_SELECT_ORD_TYPE1"));
                pstmt1.setString(1, language_id);
                pstmt1.setString(2, ord_cat.trim());
                pstmt1.setString(3, resp_id.trim());
                //pstmt1.setString( 3, ord_cat.trim() ) ;
                //pstmt1.setString( 4, resp_id.trim() ) ;

                resultSet1 = pstmt1.executeQuery();

                while (resultSet1 != null && resultSet1.next()) 
				{
                    String[] record = new String[2];
                    record[0] = resultSet1.getString("order_type_code");
                    record[1] = resultSet1.getString("short_desc");

                    OrderCat.add(record);
                }
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
            closeResultSet(resultSet1);
            closeStatement(pstmt);
            closeStatement(pstmt1);
            closeConnection(connection);
        }

        return OrderCat;
    }

    /**
    This will populate all the locations for the location type
    @return		:	ArrayList
     */
    public ArrayList getLocation(String facility_id, String practitioner_id, String location_type) throws Exception
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        ArrayList OrderCat = new ArrayList();
        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCN"));
            pstmt.setString(1, language_id);
            pstmt.setString(2, language_id);
            pstmt.setString(3, language_id);
            pstmt.setString(4, language_id);
            pstmt.setString(5, language_id);
            pstmt.setString(6, practitioner_id.trim());
            pstmt.setString(7, location_type.trim());
            pstmt.setString(8, facility_id.trim());

            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) 
			{
                String[] record = new String[2];
                record[0] = resultSet.getString("locn_code");
                record[1] = resultSet.getString("locn_short_desc");

                OrderCat.add(record);
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
            closeConnection(connection);
        }

        return OrderCat;
    }

    /**
    
    @return		:	String
     */
    public String isModuleInstalled(String facility_id, String order_category) throws Exception
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String install_yn = "";


        try
        {
        	
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));

            pstmt.setString(1, order_category.trim());
            pstmt.setString(2, facility_id.trim());

            resultSet = pstmt.executeQuery();

            if (resultSet != null && resultSet.next())
			{
                install_yn = resultSet.getString(1);
            } 
			else
			{
                install_yn = "N";

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
            closeConnection(connection);
        }

        return install_yn;
    }

    /**
    This will query on the basis of the paramters passed.
    @return		:	ArrayList
     */
    public ArrayList getSearchDetails(HashMap Parameters) throws Exception
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        ArrayList results = new ArrayList();
        //int total_records			= 0;
        //Added by Uma on 6/4/2010 for IN016226
        String sql = "";

        try
        {
        	
             connection = getConnection();
            /*date validation for thai 14/2/2007 */
            if (!language_id.equals("en")) 
			{

                String date_from = (String) Parameters.get("date_from");
                String date_to = (String) Parameters.get("date_to");
                if (date_from.equals(" ") || date_from.equals("null")) 
				{
                    date_from = "";
                }
                if (date_to.equals(" ") || date_to.equals("null"))
				{
                    date_to = "";
                }
                date_from = com.ehis.util.DateUtils.convertDate(date_from, "DMYHM", language_id, "en");
                date_to = com.ehis.util.DateUtils.convertDate(date_to, "DMYHM", language_id, "en");

                Parameters.put("date_from", date_from);
                Parameters.put("date_to", date_to);
            }
            /*date validation for thai 14/2/2007*/

            String practitioner_type = (String) Parameters.get("practitioner_type");
            String practitioner_id = (String) Parameters.get("practitioner_id");
            String resp_id = (String) Parameters.get("responsibility_id");
            String order_category = (String) Parameters.get("order_category");

            String start_value = checkForNull((String) Parameters.get("start"), "1");
            String end_value = checkForNull((String) Parameters.get("end"), "0");

            int start = Integer.parseInt(start_value);
            int end = Integer.parseInt(end_value);

            String PerformingLocnYN = "N";
            //Added by Uma on 6/4/2010 for IN016226
            String filter = checkForNull((String) Parameters.get("filter"));

            if (!practitioner_id.equals("")) 
			{
                PerformingLocnYN = isPerformingLocnYN("", practitioner_id, order_category);
            }

            if (PerformingLocnYN.equals("N") && !(resp_id.equals("")))
			{
                PerformingLocnYN = isPerformingLocnYN(resp_id, "", order_category);
            }

            //if(practitioner_type.equals("NS"))
            //	pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_SEARCH_DTL2") ) ;
            //else

            /*Added by Uma on 6/4/2010 for IN016226*/
            if (PerformingLocnYN.equalsIgnoreCase("Y")) 
			{
                sql = (String) OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_SEARCH_DTL1_PERFORM_LOCN");
            } 
			else 
			{
                sql = (String) OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_SEARCH_DTL1");
            }

            if (filter.equals("MP")) 
			{
                sql = sql.replace("$$Filter##", "  AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID=?) ");
            } 
			else if (filter.equals("RP")) 
			{
                sql = sql.replace("$$Filter##", "  AND EXISTS (SELECT 1 from ca_encntr_pract_reln  where patient_id =A.PATIENT_ID and PRACTITIONER_ID =? and sysdate between begin_date_time and nvl(end_date_time,sysdate) AND ENCOUNTER_ID = A.ENCOUNTER_ID AND FACILITY_ID=A.ORDERING_FACILITY_ID AND NVL(STATUS,'01')='01' )");
            } 
			else if (filter.equals("OP")) 
			{
                sql = sql.replace("$$Filter##", " AND a.ord_pract_id =? ");
            } 
			else
			{
                sql = sql.replace("$$Filter##", "");
            }
            /*Ends Here by Uma on 6/4/2010 for IN)16226*/

            pstmt = connection.prepareStatement(sql);

            if (PerformingLocnYN.equalsIgnoreCase("Y")) 
			{
                pstmt.setString(1, language_id);
                pstmt.setString(2, language_id);
                pstmt.setString(3, language_id);
                pstmt.setString(4, language_id);
                pstmt.setString(5, language_id);
                pstmt.setString(6, language_id);
                pstmt.setString(7, practitioner_type);
                pstmt.setString(8, language_id);
                pstmt.setString(9, language_id);
                pstmt.setString(10, language_id);
                pstmt.setString(11, (String) Parameters.get("patient_id"));
                pstmt.setString(12, (String) Parameters.get("encounter_id"));
                pstmt.setString(13, (String) Parameters.get("order_id"));
                pstmt.setString(14, (String) Parameters.get("date_from"));
                pstmt.setString(15, (String) Parameters.get("date_to"));
                pstmt.setString(16, (String) Parameters.get("priority"));
                pstmt.setString(17, (String) Parameters.get("order_category"));
                pstmt.setString(18, (String) Parameters.get("order_type"));
                pstmt.setString(19, (String) Parameters.get("activity_type"));
                pstmt.setString(20, login_facility_id);
                pstmt.setString(21, (String) Parameters.get("performing_location_code"));
                /*Added by Uma on 6/4/2010 for IN016226*/
                if (filter.equals("MP")) 
				{
                    pstmt.setString(22, practitioner_id.trim());
                } 
				else if (filter.equals("OP"))
				{
                    pstmt.setString(22, practitioner_id.trim());
                }
				else if (filter.equals("RP")) 
				{
                    pstmt.setString(22, practitioner_id.trim());
                }
                /*Ends Here by Uma on 6/4/2010 for IN016226*/
            }
			else 
			{
                pstmt.setString(1, language_id);
                pstmt.setString(2, language_id);
                pstmt.setString(3, language_id);
                pstmt.setString(4, language_id);
                pstmt.setString(5, language_id);
                pstmt.setString(6, language_id);
                pstmt.setString(7, practitioner_type);
                pstmt.setString(8, language_id);
                pstmt.setString(9, language_id);
                pstmt.setString(10, language_id);
                pstmt.setString(11, (String) Parameters.get("patient_id"));
                pstmt.setString(12, (String) Parameters.get("encounter_id"));
                pstmt.setString(13, (String) Parameters.get("order_id"));
                pstmt.setString(14, (String) Parameters.get("date_from"));
                pstmt.setString(15, (String) Parameters.get("date_to"));
                pstmt.setString(16, (String) Parameters.get("priority"));
                pstmt.setString(17, (String) Parameters.get("order_category"));
                pstmt.setString(18, (String) Parameters.get("order_type"));
                pstmt.setString(19, (String) Parameters.get("activity_type"));
                pstmt.setString(20, login_facility_id);

                if (filter.equals("MP"))
				{
                    pstmt.setString(21, practitioner_id.trim());
                } 
				else if (filter.equals("OP")) 
				{
                    pstmt.setString(21, practitioner_id.trim());
                } 
				else if (filter.equals("RP")) 
				{
                    pstmt.setString(21, practitioner_id.trim());
                }
                /*Ends Here by Uma on 6/4/2010 for IN016226*/
            }
            /*			pstmt.setString( 1, (String)Parameters.get("patient_id") ) ;
            pstmt.setString( 2, (String)Parameters.get("encounter_id") ) ;
            pstmt.setString( 3, (String)Parameters.get("order_id") ) ;
            pstmt.setString( 4, (String)Parameters.get("date_from") ) ;
            pstmt.setString( 5, (String)Parameters.get("date_to") ) ;
            pstmt.setString( 6, (String)Parameters.get("priority") ) ;
            pstmt.setString( 7, (String)Parameters.get("order_category") ) ;
            
            
            if(practitioner_type.equals("NS"))
            {
            pstmt.setString( 8, (String)Parameters.get("location_type") ) ;
            pstmt.setString( 9, (String)Parameters.get("location_type") ) ; //location_type is to be set twice.
            pstmt.setString( 10, (String)Parameters.get("location") ) ;
            pstmt.setString( 11, (String)Parameters.get("facility_id") ) ;
            pstmt.setString( 12, (String)Parameters.get("practitioner_id") ) ;
            }
            else
            pstmt.setString( 8, (String)Parameters.get("order_type") ) ;
            
             */

            resultSet = pstmt.executeQuery();

            if (resultSet != null)
			{
                /*resultSet.last(); //move to the last
                total_records = resultSet.getRow();
                }
                if(resultSet!=null && total_records > 0){
                resultSet.beforeFirst()  ;
                if(start!=0 && start!=1)
                resultSet.absolute(start-1); */
                if (start > 0) 
				{
                    for (int i = 0; (i < start - 1 && resultSet.next()); i++);
                }
                while (start <= end && resultSet != null && resultSet.next())
				{
                    String[] record = new String[30];

                    record[0] = resultSet.getString("order_date_time");
                    record[1] = resultSet.getString("priority_desc");
                    record[2] = resultSet.getString("order_detail");
                    record[3] = resultSet.getString("encounter_id");
                    record[4] = resultSet.getString("order_status_short_desc");

                    record[5] = resultSet.getString("order_category");
                    record[6] = resultSet.getString("order_category_short_desc");
                    /*if(practitioner_type.equals("NS"))
                    {
                    record[7] = resultSet.getString( "source_type")+resultSet.getString( "source_code");
                    record[8] = resultSet.getString( "location_details" )  ;
                    }else*/
                    {
                        record[7] = resultSet.getString("order_type_code");

                        record[8] = resultSet.getString("order_type_short_desc");
                    }
                    record[9] = resultSet.getString("order_id");
                    record[10] = resultSet.getString("order_status");
                    record[11] = resultSet.getString("patient_id");
                    record[12] = "";
                    record[13] = resultSet.getString("priority");
                    record[14] = resultSet.getString("result_type");
                    record[15] = resultSet.getString("result_Status");
                    record[16] = resultSet.getString("report_srl_no");
                    record[17] = resultSet.getString("sex1");
                    record[18] = resultSet.getString("patient_class");
                    record[19] = resultSet.getString("source_type");
                    record[20] = resultSet.getString("source_code");
                    record[22] = resultSet.getString("patient_name");
                    record[23] = resultSet.getString("age");
                    record[24] = resultSet.getString("location_details");
                    record[25] = resultSet.getString("order_set_id");
                    record[26] = resultSet.getString("bill_yn");
                    record[27] = resultSet.getString("order_line_num");
                    record[28] = resultSet.getString("dob");

                    // Pass the total Number of Records
                    //record[21] = String.valueOf(total_records);

                    results.add(record);
                    start++;
                }
                if (resultSet.next())
				{
                    String[] templist = (String[]) results.get(0);
                    templist[29] = "" + (end + 7);
                    results.set(0, templist);
                }
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
            closeConnection(connection);
        }
        return results;
    }

    /**
    This will populate all the order categories with scope of each category
    @return		:	ArrayList
     */
    public String getSysDate() throws Exception
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String currentDate = "";

        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME"));
            resultSet = pstmt.executeQuery();

            if (resultSet != null && resultSet.next()) 
			{
                currentDate = resultSet.getString("sys_date");
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
            closeConnection(connection);
        }
        return currentDate;
    }

    public HashMap insert() 
	{

        HashMap map = new HashMap();
        HashMap sqlMap = new HashMap();
        map.put("result", new Boolean(false));
        HashMap recordStoreParam = new HashMap();

        try 
		{
            recordStoreParam.put("parameters", parameters);
            recordStoreParam.put("login_by_id", login_by_id);
            recordStoreParam.put("login_at_ws_no", login_at_ws_no);
            recordStoreParam.put("login_facility_id", login_facility_id);


            sqlMap.put("SQL_OR_REPORT_AUTH_RES_HDR_UPDATE", OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_RES_HDR_UPDATE"));
            sqlMap.put("SQL_OR_REPORT_AUTH_RES_DTL_UPDATE", OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_RES_DTL_UPDATE"));
            sqlMap.put("SQL_OR_REPORT_AUTH_ORD_UPDATE", OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_ORD_UPDATE"));
            sqlMap.put("SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE", OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE"));
            sqlMap.put("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A", OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A"));
            sqlMap.put("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY", OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY"));
            sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG", OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG"));
            sqlMap.put("SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS", OrRepositoryExt.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS"));
            sqlMap.put("SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS_STATUS", OrRepositoryExt.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_GET_PARENT_ORDERS_STATUS"));
            sqlMap.put("SQL_OR_REPORT_AUTHORIZATION_UPDATE_PARENT_ORDER_LINE", OrRepositoryExt.getOrKeyValue("SQL_OR_REPORT_AUTHORIZATION_UPDATE_PARENT_ORDER_LINE"));
            sqlMap.put("SQL_OR_REPORT_SELECT_REPORT_AUTH_RES_STATUS", OrRepositoryExt.getOrKeyValue("SQL_OR_REPORT_SELECT_REPORT_AUTH_RES_STATUS"));


            //	return recordStoreParam ;
            return getResult(recordStoreParam, sqlMap);

        }
		catch (Exception e) 
		{
            logErrorMessage(e);
            return null;
        }
    }

    /**********This Method  Actually Calls the EJB's Method ********************/
    private HashMap getResult(HashMap record, HashMap sqlMap) 
	{
        HashMap map = new HashMap();
        StringBuffer tmpBuff = new StringBuffer();

        try 
		{
            /*InitialContext context = new InitialContext();
            Object object		   = context.lookup(OrRepository.getOrKeyValue("OR_ORDER_REPORT_AUTH_JNDI"));
            ORReportAuthorizationHome home  = (ORReportAuthorizationHome) PortableRemoteObject.narrow( object,ORReportAuthorizationHome.class );
            ORReportAuthorizationRemote remote = home.create() ;
            //ReportAuthorizationManager	remote = new ReportAuthorizationManager();*/
            HashMap tabDataParam = new HashMap();

            tabDataParam.put("tabData", record);
            tabDataParam.put("properties", getProperties());

            if (mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))) 
			{
                return null;
            } 
			else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) 
			{
                //map = remote.insert(tabDataParamtabDataParam, sqlMap ) ;
                //	return tabDataParam ;
			/*map = remote.insert(tabDataParam, sqlMap ) ;*/

                Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_ORDER_REPORT_AUTH_JNDI"), ORReportAuthorizationHome.class, getLocalEJB());
                Object busObj = (home.getClass().getMethod("create", null)).invoke(home, null);

                Object argArray[] = new Object[2];
                argArray[0] = tabDataParam;
                argArray[1] = sqlMap;
                Class[] paramArray = new Class[2];
                paramArray[0] = tabDataParam.getClass();
                paramArray[1] = sqlMap.getClass();
                map = (java.util.HashMap) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);

                (busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
                argArray = null;
                paramArray = null;

                if (((Boolean) map.get("result")).booleanValue()) 
				{
                    map.put("message", getMessage(language_id, (String) map.get("message"), "SM"));
                    map.put("traceVal", (String) tmpBuff.toString());
                    tmpBuff.setLength(0);

                    ArrayList params = (ArrayList) record.get("parameters");
                    Hashtable printTab = new Hashtable();

                    for (int i = 0; i < parameters.size(); i++) 
					{
                        HashMap currRec = (HashMap) params.get(i);
                        printTab.clear();

                        String report_srl_no = (String) currRec.get("report_srl_no");
                        String order_id = (String) currRec.get("order_id");
                        String ord_typ_code = (String) currRec.get("ord_typ_code");

                        String patient_class = (String) currRec.get("patient_class");
                        String source_type = (String) currRec.get("source_type");
                        String location_code = (String) currRec.get("location_code");
                        String priority = (String) currRec.get("priority");

                        printTab.put("report_srl_no", report_srl_no);
                        printTab.put("ord_id", order_id);
                        printTab.put("ord_typ_code", ord_typ_code);
                        printTab.put("patient_class", patient_class);
                        printTab.put("source_type", source_type);
                        printTab.put("location_code", location_code);
                        printTab.put("priority", priority);
                        printTab.put("facility_id", login_facility_id);

                        printParameters.putAll(printTab);
                        //onlineprint

                        /* 	OnLinePrinting online_print = new OnLinePrinting(request,response);
                        online_print.printResultEntryReport(printTab);*/
                        //HashMap tmp_map = (HashMap)online_print.printResultEntryReport(printTab);

                    }
                }
            } 
			else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
			{
                return null;
            }

            return map;

        } 
		catch (Exception e)
		{
            map.put("message", e.getMessage());
            e.printStackTrace();
            return map;
        }

    }//End of Method

    /***************************************************************************/
    /*
    public HashMap insert(HashMap tabDataParam , HashMap sqlMap )  {
    
    StringBuffer messages =  null ;
    StringBuffer traceVal =  null ;
    HashMap map =null;
    Connection connection =  null ;
    
    PreparedStatement pstmt_res_hdr	    	= null ;
    PreparedStatement pstmt_res_dtl		    = null ;
    PreparedStatement pstmt_ord				= null ;
    PreparedStatement pstmt_ord_line			= null ;
    PreparedStatement pstmt_ord_status			= null ;
    try {
    messages = new StringBuffer() ;
    traceVal = new StringBuffer() ;
    map = new HashMap() ;
    map.put( "result", new Boolean( false ) ) ;
    map.put( "flag", "flag" ) ;
    
    
    
    HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");
    //	traceVal.append("tabData_p="+tabData_p.toString());
    
    
    //Properties  pt      		=(Properties)tabDataParam.get("properties");
    
    
    //	String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
    //	String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
    //	String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;
    ArrayList parameters		=(ArrayList)tabData_p.get("parameters" ) ;
    
    
    //	 Connection connection = getConnection(pt) ;
    connection = getConnection() ;
    
    
    
    
    String SQL_OR_REPORT_AUTH_RES_HDR_UPDATE						= (String)sqlMap.get("SQL_OR_REPORT_AUTH_RES_HDR_UPDATE");
    String SQL_OR_REPORT_AUTH_RES_DTL_UPDATE						= (String)sqlMap.get("SQL_OR_REPORT_AUTH_RES_DTL_UPDATE");
    String SQL_OR_REPORT_AUTH_ORD_UPDATE							= (String)sqlMap.get("SQL_OR_REPORT_AUTH_ORD_UPDATE");
    String SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE					= (String)sqlMap.get("SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE");
    String SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A		= (String)sqlMap.get("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A");
    String SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY	= (String)sqlMap.get("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY");
    
    pstmt_res_hdr													= connection.prepareStatement(SQL_OR_REPORT_AUTH_RES_HDR_UPDATE);
    pstmt_res_dtl													= connection.prepareStatement(SQL_OR_REPORT_AUTH_RES_DTL_UPDATE);
    pstmt_ord														= connection.prepareStatement(SQL_OR_REPORT_AUTH_ORD_UPDATE);
    pstmt_ord_line													= connection.prepareStatement(SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE);
    
    
    
    int	update_res_hdr[]	= {} ;
    int	update_res_dtl[]	= {} ;
    int	update_ord[]		= {} ;
    int	update_ord_line[]	= {} ;
    
    int counterRes			= 0;//to chk there is any batch add for order and order line updation
    
    ResultSet rs			= null;
    
    for (int i=0 ; i<parameters.size() ; i++ ){
    
    HashMap currRec			= (HashMap)parameters.get(i);
    
    String result_type		= (String)currRec.get("result_type");
    String result_status	= (String)currRec.get("result_status");
    int report_srl_no		= Integer.parseInt((String)currRec.get("report_srl_no"));
    
    String order_status_code= "";//from Query
    
    
    if(result_type.equalsIgnoreCase("A"))
    pstmt_ord_status		= connection.prepareStatement(SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A);
    else
    pstmt_ord_status		= connection.prepareStatement(SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY);
     */
    /**Result Header**/
    /*sql=UPDATE OR_RESULT_HEADER SET AUTH_BY_ID=? ,
    AUTH_DATE_TIME = 'SYSDATE' WHERE ORDER_ID = ? AND REPORT_SRL_NO = ? */
    /*
    pstmt_res_hdr.setString(1,(String)currRec.get("practitioner_id"));
    pstmt_res_hdr.setString(2,(String)currRec.get("order_id"));
    pstmt_res_hdr.setInt(3,report_srl_no);
    pstmt_res_hdr.addBatch();
    
     */
    /**Result Detail**/
    /*sql=UPDATE OR_RESULT_DETAIL SET AUTH_BY_ID=? ,
    AUTH_DATE_TIME = 'SYSDATE' WHERE ORDER_ID = ? AND REPORT_SRL_NO = ?
    AND AUTH_REQD_YN = 'Y' AND
    AUTH_DATE_TIME IS NULL AND AUTH_BY_ID IS NULL*/
    /*
    pstmt_res_dtl.setString(1,(String)currRec.get("practitioner_id"));
    pstmt_res_dtl.setString(2,(String)currRec.get("order_id"));
    pstmt_res_dtl.setInt(3,report_srl_no);
    pstmt_res_dtl.addBatch();
    
    
    
    if(!result_status.trim().equalsIgnoreCase("") && !result_status.trim().equalsIgnoreCase("null")){
    
    counterRes++;
    
    rs = pstmt_ord_status.executeQuery();
    if(rs.next()){
    order_status_code	= rs.getString("order_status_code");
    }
     */
    /**order**/
    /*sql=UPDATE OR_ORDER SET ORDER_STATUS = ? ,
    RESULT_STATUS=? WHERE
    ORDER_ID=?*/
    /*
    pstmt_ord.setString(1, order_status_code);
    pstmt_ord.setString(2,(String)currRec.get("result_status"));
    pstmt_ord.setString(3,(String)currRec.get("order_id"));
    pstmt_ord.addBatch();
     */
    /**order Line**/
    /*sql=UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = ? ,
    RESULT_LINE_STATUS=? WHERE ORDER_ID=? AND (ORDER_ID||ORDER_LINE_NUM)
    IN (SELECT (ORDER_ID||LINE_SRL_NO) FROM OR_RESULT_DETAIL WHERE
    ORDER_ID=? AND REPORT_SRL_NO = ? AND AUTH_BY_ID=? AND
    AUTH_REQD_YN = 'Y' AND AUTH_DATE_TIME IS NULL AND AUTH_BY_ID
    IS NULL AND ROWNUM <=1)*/
    /*
    pstmt_ord_line.setString(1,order_status_code);
    pstmt_ord_line.setString(2,order_status_code);
    pstmt_ord_line.setString(3,(String)currRec.get("order_id"));
    pstmt_ord_line.setString(4,(String)currRec.get("order_id"));
    pstmt_ord_line.setString(5,(String)currRec.get("report_srl_no"));
    pstmt_ord_line.setString(6,(String)currRec.get("practitioner_id"));
    pstmt_ord_line.addBatch();
    }	 //updation only if result status = 3
    
    } //End of no of Recds
    
    
    
    update_res_hdr = pstmt_res_hdr.executeBatch();
    update_res_dtl = pstmt_res_dtl.executeBatch();
    
    
    if(counterRes > 0){
    update_ord = pstmt_ord.executeBatch();
    update_ord_line = pstmt_ord_line.executeBatch();
    }
    
    
    boolean update_res_hdr_status	  = false;
    boolean update_res_dtl_status	  = false;
    boolean update_ord_status		  = false;
    boolean update_ord_line_status	  = false;
    
    
    
    if((update_res_hdr.length > 0)){
    update_res_hdr_status= true ;
    }else if((update_res_hdr.length == (-3))){
    update_res_hdr_status= false ;
    }
    
    
    if((update_res_dtl.length > 0)){
    update_res_dtl_status= true ;
    }else if((update_res_dtl.length == (-3))){
    update_res_dtl_status= false ;
    }
    
    if(counterRes > 0){
    if((update_ord.length > 0)){
    update_ord_status= true ;
    }else if((update_ord.length == (-3))){
    update_ord_status= false ;
    }
    
    if((update_ord_line.length > 0)){
    update_ord_line_status= true ;
    }else if((update_ord_line.length == (-3))){
    update_ord_line_status= false ;
    }
    
    }else{ //No updation only assumption
    update_ord_status= true ;
    update_ord_line_status= true ;
    }
    
    
    //		traceVal.append("/insert_ch="+insert_ch);
    //		traceVal.append("/insert_type="+insert_type);
    //		traceVal.append("/insert_sy="+insert_syn.length+"/insert_Int="+insert_Instr.length+"/insert_ptl="+insert_ptcl.length);
    
    if (update_res_hdr_status && update_res_dtl_status  && update_ord_status && update_ord_line_status){
    connection.commit();
    map.put( "result", new Boolean( true ) ) ;
    messages.append("RECORD_INSERTED") ;
    }else{
    connection.rollback();
    messages.append( "Insert Failed" ) ;
    }
    
    }catch( Exception e ){
    traceVal.append("In Exception==");
    e.printStackTrace();
    traceVal.append(e.getMessage());
    map.put( "traceVal", traceVal.toString() ) ;
    
    try {
    connection.rollback();
    //						closeConnection( connection,pt "));
    closeConnection(connection);
    } catch ( Exception ee ) {
    messages.append(ee.getMessage() ) ;
    }
    messages.append( e.getMessage() ) ;
    
    e.printStackTrace() ;
    } finally{
    try {
    //		closeConnection( connection,pt"));
    closeStatement( pstmt_res_hdr ) ;
    closeStatement( pstmt_res_dtl ) ;
    closeStatement( pstmt_ord ) ;
    closeStatement( pstmt_ord_line ) ;
    closeStatement( pstmt_ord_status ) ;
    closeConnection(connection);
    } catch ( Exception fe ) {
    
    fe.printStackTrace() ;
    }
    }
    
    map.put( "message", messages.toString() ) ;
    map.put( "traceVal", traceVal.toString() ) ;
    return map ;
    }//End of Insert Method
     */
    public ArrayList getSysDateTime() throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        ArrayList currentDate = new ArrayList();

        try
        {
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME"));
            resultSet = pstmt.executeQuery();

            if (resultSet != null && resultSet.next())
			{
                currentDate.add(resultSet.getString("curr_date"));
                currentDate.add(resultSet.getString("last_week_date"));
                currentDate.add(resultSet.getString("sys_date_time"));
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
            closeConnection(connection);
        }

        return currentDate;
    }

    public ArrayList getPerformingLocn(String responsibility_id, String practitioner_id, String order_category) throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        ArrayList PerformingLocn = new ArrayList();
        //String[] order_cat = new String[2];

        try
        {
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN"));
            pstmt.setString(1, language_id);
            pstmt.setString(2, responsibility_id.trim());
            pstmt.setString(3, practitioner_id.trim());
            pstmt.setString(4, order_category.trim());
            pstmt.setString(5, login_facility_id);

            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) 
			{
                String[] performing_locn = new String[2];
                performing_locn[0] = resultSet.getString(1);
                performing_locn[1] = resultSet.getString(2);
                PerformingLocn.add(performing_locn);
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
            closeConnection(connection);
        }
        return PerformingLocn;
    }

    public String isPerformingLocnYN(String responsibility_id, String practitioner_id, String order_category) throws Exception
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String performing_locn_yn = "N";

        try 
		{
            connection = getConnection();

            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_YN"));
            pstmt.setString(1, practitioner_id.trim());
            pstmt.setString(2, order_category.trim());

            resultSet = pstmt.executeQuery();

            if (resultSet != null && resultSet.next())
			{
                performing_locn_yn = resultSet.getString(1);
                performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();

            } 
			else 
			{
                performing_locn_yn = "N";
            }

            closeResultSet(resultSet);
            closeStatement(pstmt);

            if (performing_locn_yn.equals("N")) 
			{
                pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_RESP_PERFORM_LOCN_YN"));
                pstmt.setString(1, responsibility_id.trim());
                pstmt.setString(2, order_category.trim());

                resultSet = pstmt.executeQuery();

                if (resultSet != null && resultSet.next())
				{
                    performing_locn_yn = resultSet.getString(1);
                    performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();

                } 
				else 
				{
                    performing_locn_yn = "N";
                }
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
            closeConnection(connection);
        }

        return performing_locn_yn;
    }

    public String fingurePrintYN() 
	{
        String fingurePrnYN = "";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_AUTHORIZE_FINGURE_PRN_SELECT"));
            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) 
			{
                fingurePrnYN = resultSet.getString("fing_prn_auth_order");
            }
        } 
		catch (Exception e) 
		{

            e.printStackTrace();
            //throw e ;
        } 
		finally
		{
            try 
			{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            } 
			catch (Exception e) 
			{
                e.printStackTrace();
            }
        }
        return fingurePrnYN;
    }

    /***
     *Method called before trasaction where validations should take place.
     * @return      HashMap containing the error information.
     * @throws Exception
     */
    public HashMap validate() throws Exception
	{
        HashMap map = new HashMap();
        map.put("result", new Boolean(true));
        map.put("message", "");

        String order_id = "";
        String valid_operational_yn = "";
        HashMap values = null;

        int int_total_records = parameters.size();

        for (int i = 0; i < int_total_records; i++) 
		{

            //order_type_code 		= (String)allValues.get("ord_typ_code");
            values = (HashMap) parameters.get(i);
            order_id = (String) values.get("order_id");
            valid_operational_yn = getOperationalStatus("REPORT_AUTHORIZATION", order_id, "");

            if (valid_operational_yn.equals("N")) 
			{
                map.put("result", new Boolean(false));
                map.put("message", getMessage(language_id, "OR_STATUS_CHANGED", "OR"));
                map.put("invalidCode", "" + i);

                break;
            }
        }
        return map;
    }
    /*Added by Uma for OrderSetBilling*/

    public String getOrderSetDetails(String order_id) throws Exception 
	{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String record = "N";
        try 
		{
            connection = getConnection();
            pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS"));
            pstmt.setString(1, order_id.trim());
            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) 
			{
                record = resultSet.getString("bill_yn");
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
            closeConnection(connection);
        }

        return record;
    }
    /*Ends Here*/
}
