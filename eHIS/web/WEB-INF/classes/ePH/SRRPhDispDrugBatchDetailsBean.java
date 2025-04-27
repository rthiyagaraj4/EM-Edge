/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.Serializable ;
import java.util.*;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class SRRPhDispDrugBatchDetailsBean extends PhAdapter implements Serializable {
	
    public ArrayList getArrayCodeList(String facility)
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
     //   Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION"));
            preparedstatement.setString(1,facility);
	    preparedstatement.setString(2,getLanguageId());
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery();resultset != null && resultset.next(); )
            {
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
				arraylist.add(hashmap);
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




/*public ArrayList getTradeName(String drug_code) throws Exception
		{
			
			result = fetchRecords(PhRepository.getPhKeyValue("SQL_PH_REPORT_TRADE_NAME_FOR_DRUG"),drug_code);
			return result;
		}*/

 /*public ArrayList getTradeName(String drug_code)
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist1 = new ArrayList();
     //   Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_REPORT_TRADE_NAME_FOR_DRUG"));
            preparedstatement.setString(1,drug_code);
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); )
            {
                hashmap = new HashMap();
                hashmap.put("tradeid", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("tradedesc",CommonAdapter.checkForNull(resultset.getString(2)));
				arraylist1.add(hashmap);
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
        return arraylist1;
    }*/


	public ArrayList getTradeName(String drug_code) {
		ArrayList tradenamelist = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
//		String facility_id1 = facility_id;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORT_TRADE_NAME_FOR_DRUG" )) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					tradenamelist.add( resultSet.getString( "TRADE_CODE" ) ) ;
					tradenamelist.add( resultSet.getString( "SHORT_NAME" ) );
				}
			}

		}
		catch ( Exception e ) {
			System.err.println( "Error Populating Trade List" +e.toString()) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace(); 
			}
		}

		return tradenamelist;
	}
}
