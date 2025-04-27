/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.Common;

import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;

import eOR.Common.*;

public class  QueryBean extends OrAdapter implements Serializable
{
	 public QueryBean(){
	 }
	public String getModuleInstall(String order_category, String facility_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String install_yn			= "N";

			try{
					connection	= ConnectionManager.getConnection() ;
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
					pstmt.setString(1, order_category);
					pstmt.setString(2, facility_id);
					resultSet	= pstmt.executeQuery() ;

					if ( resultSet != null )
					{
						while(resultSet.next())	// Only one record
						{
							install_yn = resultSet.getString( "operational_yn" )  ;
						}
					}
				}catch ( Exception e )	{
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					if(connection!=null)
						ConnectionManager.returnConnection(connection);
				}
				return install_yn;
	}	 // End of the Installed
} // End of the class
