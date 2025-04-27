/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History         Name        		Rev.Date	    	Rev.Name 		      Description
--------------------------------------------------------------------------------------------------------------------------------------------
10/03/2022      36285             Hariharan k       		                                          MMs-DM-CRF-0221.v1.0(003)
----------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;


public class ProceduresBean extends eCA.Common.CaAdapter implements java.io.Serializable {
	public String  getProceduresData(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String procedure_yn = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT EN_PRI_SEC_PROC_YN FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=?" ) ;
			pstmt.setString(1,facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				procedure_yn =  resultSet.getString("EN_PRI_SEC_PROC_YN")==null?"N":(String)resultSet.getString("EN_PRI_SEC_PROC_YN");
			}
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return procedure_yn;
	
	}
}
	