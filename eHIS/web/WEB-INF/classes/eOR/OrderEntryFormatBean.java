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
import webbeans.eCommon.*;

import eOR.Common.*;

public class  OrderEntryFormatBean extends OrAdapter implements Serializable
{
	 public OrderEntryFormatBean()
	 {
			
	 }
/*
		This method is used to populate the Tissue Fields when any Anatomy Site is selected in OrderFormat
	*/
	public ArrayList populateTissueFields(Properties properties,String anatomy_site_code) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList tissueFields		= new ArrayList() ;
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement("SELECT long_desc,tissue_desc_code FROM rl_tissue_desc_type WHERE status IS NULL and TISSUE_DESC_CODE in (select TISSUE_DESC_CODE from RL_TISSUES_FOR_ANATOMY where ANATOMY_SITE_CODE=?)  ORDER BY 1");
			pstmt.setString(1,anatomy_site_code);
			resultSet = pstmt.executeQuery();
			while(resultSet !=null && resultSet.next())
			{
				String[] tissueRecords = new String[2];
				tissueRecords[1] = resultSet.getString("long_desc");
				tissueRecords[0] = resultSet.getString("tissue_desc_code");
				tissueFields.add(tissueRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return tissueFields;
	}

	public String getFixativeField(Properties properties,String anatomy_site_code, String catalog_code) throws Exception
	{
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String sql					= "call RL_GET_DEFAULT_FIXATIVE(?,?,?,?,?)";
		String fixativeCode = "";
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			cstmt 				= connection.prepareCall("{ "+sql+" }");

			cstmt.clearParameters();
			cstmt.setString(1, catalog_code);
			cstmt.setString(2, anatomy_site_code);
			cstmt.registerOutParameter( 3,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;

			cstmt.execute();
			fixativeCode = cstmt.getString(3);
		}
		catch ( Exception e )	
		{
			System.err.println( "Callable Statement for Suspended Check" +e.toString()) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement( cstmt ) ;
			closeConnection(connection);
		}
		return fixativeCode;
	}

	public ArrayList populateFixativeFields(Properties properties) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList fixativeFields		= new ArrayList() ;
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_FIXATIVE"));
			resultSet = pstmt.executeQuery();
			while(resultSet !=null && resultSet.next())
			{
				String[] fixativeRecords = new String[2];
				fixativeRecords[1] = checkForNull(resultSet.getString( "long_desc" ),"");
				fixativeRecords[0] = checkForNull(resultSet.getString( "fixative_code" ),"")  ;
				fixativeFields.add(fixativeRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return fixativeFields;
	}


} // End of the class
