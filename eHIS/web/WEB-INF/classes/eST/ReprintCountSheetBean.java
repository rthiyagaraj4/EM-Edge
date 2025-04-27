/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import eST.Common.StRepository;
//import eCommon.Common.CommonBean;
//import eCommon.Common.CommonEJBSessionInterface;
//import eST.Common.StAdapter;
//import eST.Common.StHeaderBean;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpSession;

public class ReprintCountSheetBean  extends StTransaction implements Serializable{

	private String facility_id;
	private String phy_inv_id;

	public ArrayList getArrayCodeList(String facility_id)
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
		//ArrayList expDetailsList = new ArrayList();
		facility_id=facility_id;
       // Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REPRINT_COUNT_SHEET_PHY"));
			preparedstatement.setString( 1, facility_id ) ;       
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("phy_inv_id", CommonAdapter.checkForNull(resultset.getString(1)));
               // hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }
   

	public ArrayList getDateValues(String phy_inv_id,String facility_id) throws Exception{ 
		Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
		//ArrayList expDetailsList = new ArrayList();
		facility_id=facility_id;
        //Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REPRINT_COUNT_SHEET_DATE"));
			preparedstatement.setString( 1, facility_id ) ;    
			preparedstatement.setString( 2, phy_inv_id ) ;       
			   
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("count_sheet_date", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("phy_inv_proc_mode", CommonAdapter.checkForNull(resultset.getString(2)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;	}


	/*public String getPhysicalInv()
	{

		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_COUNT_PHY_INV_ID"),C1));
	}
	*/
	public void clear()
	{
	this.phy_inv_id="";
	this.facility_id="";
	}
}
