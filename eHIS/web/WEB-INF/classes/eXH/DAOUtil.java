/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import webbeans.eCommon.*;

public class DAOUtil
{
	private static DAOUtil daoUtil;

	public static DAOUtil getInstance()  
	{  
		if (daoUtil == null) 
		{
			daoUtil = new DAOUtil();  
		}  
		return daoUtil;  
	}

	public Map<String, String> getSMLanguages(Connection dbConn) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> languages = new LinkedHashMap<String, String>();
		String qry = "SELECT language_id, short_name FROM sm_language_vw ORDER BY short_name";
		try
		{
			pstmt = dbConn.prepareStatement(qry);
			resultSet = pstmt.executeQuery();
			languages.put("", "Select");
			while(resultSet.next())
			{
				languages.put(resultSet.getString("language_id"), resultSet.getString("short_name"));
			}
		}
		catch (Exception exp)
		{
			throw exp;
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, null);
		}
		return languages;
	}

	public Map<String, String> getValuesMap(Connection dbConn, String qry)
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Map<String, String> valuesMap = new LinkedHashMap<String, String>();
		boolean isNewDBConn = false;
		
		try
		{
			if(dbConn == null) 
			{
				dbConn = getEMDBConnection();
				isNewDBConn = true;
			}

			pstmt = dbConn.prepareStatement(qry);
			resultSet = pstmt.executeQuery();
			valuesMap.put("", "Select");
			while(resultSet.next())
			{
				valuesMap.put(resultSet.getString("code"), resultSet.getString("description"));
			}
		}
		catch (Exception exp)
		{
			System.out.println("(DAOUtil:getValuesMap) Exception - " + exp);
			System.out.println("(DAOUtil:getValuesMap) Query - " + qry);
			exp.printStackTrace(System.err);
		}
		finally
		{
			closeDBResources(resultSet, pstmt, dbConn, isNewDBConn);
		}
		return valuesMap;
	}

	private Connection getEMDBConnection() throws Exception
	{
		return ConnectionManager.getConnection();
	}

	public void closeDBResources(ResultSet rs, Statement stmt, Connection dbConn, boolean isNewDBConn)
	{
		if(isNewDBConn) XHUtil.closeDBResources(rs, stmt, dbConn);
		else XHUtil.closeDBResources(rs, stmt, null);
	}

	public List<Map<String, String>> getQueryResult(String query, Connection dbConn)
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		List<Map<String, String>> results = new ArrayList<Map<String, String>>();
		Map<String, String> tempRow = new HashMap<String, String>();

		boolean isNewDBConn = false;

		try
		{
			if(dbConn == null) 
			{
				dbConn = getEMDBConnection();
				isNewDBConn = true;
			}
			
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery(query);
			rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();

			while(rs.next())
			{
				tempRow = new HashMap<String, String>();
				for (int i = 1; i <= colCount; i++)
				{
					tempRow.put(rsmd.getColumnName(i), rs.getString(i));
				}
				results.add(tempRow);
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			closeDBResources(rs, stmt, dbConn, isNewDBConn);
		}
		return results;
	}

	public List<String> executeProcedure(String procStr, Map<String, String> procParams, Connection dbConn)
	{
		CallableStatement cstmt = null;
		//String statusMessage = null;
		boolean isNewDBConn = false;
		List<String> outParams = new ArrayList<String>();

		try
		{
			if(dbConn == null) 
			{
				dbConn = getEMDBConnection();
				isNewDBConn = true;
			}
			cstmt = dbConn.prepareCall(procStr);
			int paramCount = 1;
			List<Integer> outParamIndex = new ArrayList<Integer>();

			for(Map.Entry<String, String> param : procParams.entrySet())
			{
				String key = param.getKey();
				String value = param.getValue();

				if(!key.startsWith("OUT_")) cstmt.setString(paramCount, value);
				else 
				{
					cstmt.registerOutParameter(paramCount, java.sql.Types.VARCHAR);
					outParamIndex.add(paramCount);
				}
				paramCount++;
			}
			cstmt.execute();
			System.out.println("outParamIndex "+outParamIndex);

			for (int i = 0; i < outParamIndex.size(); i++)
			{
				System.out.println("Test..."+outParamIndex.get(i));
				outParams.add(cstmt.getString(outParamIndex.get(i)));
			}
		}
		catch (Exception exp)
		{
			System.out.println("(DAOUtil:executeProcedure) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			closeDBResources(null, cstmt, dbConn, isNewDBConn);
		}

		return outParams;
	}
}
