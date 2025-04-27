/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date           	Edit History    	Name        		Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
16/05/2022     29147      krishna pranay       17/05/2023     Ramesh Goli              MO-CRF-20183

----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;



public class RestrictPlacingOrdersBean extends OrAdapter implements java.io.Serializable {
	
	
public ArrayList  getRestrictPlacingOrdersDetails(String locale) throws Exception {
		Connection con	= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		ArrayList restrictPlacingOrdersDetails = new ArrayList() ;
		
		String sql =  "SELECT B.ORDER_CATEGORY, B.SHORT_DESC,NVL(A.REST_ORDER_SELF_YN,'N') REST_ORDER_SELF_YN, NVL(A.REST_ORDER_FAMILY_YN,'N') REST_ORDER_FAMILY_YN FROM OR_ORDER_REST_SLF_FAMI_MEMB A RIGHT OUTER JOIN OR_ORDER_CATEGORY_LANG_VW B ON A.ORDER_CATEGORY=B.ORDER_CATEGORY  where  B.LANGUAGE_ID =? order by short_desc";
				

		try{
		    con			= getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1,locale);

			rs = psmt.executeQuery();

			String rest_order_self_yn="";
			String rest_order_family_yn="";

			while ( rs != null && rs.next() ) {
				String[] record = new String[4];
				record[0] = rs.getString( "order_category" )  ;
				record[1] = rs.getString( "short_desc" )  ;
				rest_order_self_yn = rs.getString("rest_order_self_yn");
				if(rest_order_self_yn == null) 	{
					rest_order_self_yn = "";
				}
				record[2] = rest_order_self_yn;
				
				rest_order_family_yn = rs.getString("rest_order_family_yn");
				if(rest_order_family_yn == null) 	{
					rest_order_family_yn = "";
				}
				record[3] = rest_order_family_yn;

				restrictPlacingOrdersDetails.add(record) ;
			}
			if(rs !=null) rs.close();
			if(psmt != null ) psmt.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			closeResultSet( rs ) ;
            closeStatement( psmt ) ;
			closeConnection( con ); 	
		}

		return restrictPlacingOrdersDetails;

	}
}