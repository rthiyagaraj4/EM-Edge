/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class TransTypeBean extends PhAdapter implements Serializable 
{
/*public TransTypeBean() {
        try 
		{
            //doCommon();
        }
        catch(Exception e) 
		{
           System.out.println("Exception in constructor"+e.toString());
		}
    }*/

public ArrayList getAllByGenericName(String from,String to)throws Exception
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;

		long count=0;
		long i = 0;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRN_TYPE_SELECT1") );
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
				String arr[] = new String[4];
				arr[0]=resultSet.getString("PH_TRN_TYPE");
				arr[1]=resultSet.getString("LONG_DESC");
				arr[2]=resultSet.getString("SHORT_DESC");
				arr[3]=resultSet.getString("ST_TRN_TYPE_CODE");

				records.add(arr);
				}
			}
			if( start != 1 )
					prevnextlink += "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14)
					prevnextlink += "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"')\">Next</a>" ;
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es)
			{
//				System.out.println("Exception while closing resultsets and statements"+es.toString());
				es.printStackTrace();
			}
		}
		return records;
	}
}
