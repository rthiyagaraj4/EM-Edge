package eBL;

import java.io.*;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import eBL.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

public class BLRevenueStageBean extends BlAdapter implements Serializable 
{
	Hashtable recordSet = null;
	public HashMap saveOrderValues		= new HashMap();

	public HashMap getOrderValues()
	{
		return saveOrderValues;		
	}
	
	public ArrayList getOrderCategory(String facilityId) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		PreparedStatement pstmt1 	= null;
		ResultSet rs 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String[] record=null;
		int rowdiff=0;		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select order_category, long_desc,short_desc, order_type_code,rev_satge, to_char(eff_from,'dd/mm/yyyy') eff_from,to_char(eff_to,'dd/mm/yyyy') eff_to,eff_from eff_from1 from BL_ORDER_REVENUE_STAGE where operating_facility_id = '"+facilityId+"' and ((trunc(sysdate) between trunc(eff_from) and trunc(nvl(eff_to,sysdate)))or(trunc(eff_from) > trunc(sysdate))) order by ORDER_CATEGORY,order_type_code,eff_from1 ");
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) 
			{
				record = new String[12];
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "LONG_DESC" )  ;
				record[2] = resultSet.getString( "SHORT_DESC" )  ;
				record[3] = resultSet.getString( "order_type_code" )  ;
				record[4] = resultSet.getString( "rev_satge" )  ;
				record[5] = resultSet.getString( "eff_from" )  ;
				record[6] = resultSet.getString( "eff_to" )  ;
				
				saveOrderValues.put(record[0],record[1]+"~~"+record[3]+"~~"+record[4]+"~~"+record[5]);				
			OrderCat.add(record);
			}
		} 
		catch ( Exception e )	
		{	System.err.println("error in java ==>"+e);	
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return OrderCat;
	}

}