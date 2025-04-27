/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  package eST;

import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Hashtable;

public class VarianceReportBean extends StTransaction implements Serializable{

	private String item_code;
	private String store_code;

	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public String getReportOption()
	{
		return getStaticListOptionTag("STBPHVR1,Variance Report at Batch Level;STBPHVR4,Variance Report at Item Level;STBPHVR2,Variance Report at Store Level;STBPHVR3,Summary Report at Item Class Level");//;STBPHVR2,Variance History By Item code");
		
	}

	public String getPhysicalInv()
	{
		return getStaticListOptionTag(" ,---Select---;");
	}


		public ArrayList getArrayCodeList(String facility_id)
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
		//ArrayList expDetailsList = new ArrayList();
		facility_id=facility_id;

        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_CANCEL_COUNT_PHY_INV_ID"));
			preparedstatement.setString( 1, facility_id ) ;       
			
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("PHY_INV_ID", CommonAdapter.checkForNull(resultset.getString(1)));
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
  
	public void clear()
	{
	this.item_code="";
	this.store_code="";
	}
}
