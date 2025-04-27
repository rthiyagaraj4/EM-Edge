/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *  
 */
package eIPAD.chartsummary.common.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import eIPAD.chartsummary.common.dao.SfsExecuteQuery;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.*;

/**
 * @author GaneshkumarC 
 *
 */
public class SfsDAOImpl extends GenericDAOImpl implements SfsExecuteQuery{
	public SfsResponse executeSfsQuery(SfsQuery oSfsQuery)
	{
		
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		SfsResponse oSfsRes = new SfsResponse();
		List<SfsHo> oLstSfsDetails = new ArrayList<SfsHo>();
		ErrorInfo oErrInfo = new ErrorInfo();
		if(oSfsQuery != null && oSfsQuery.getSfsQuery() != null && !oSfsQuery.getSfsQuery().equals(""))
		{
			locale = oSfsQuery.getLocale();
			oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
			try
			{
				connection = createConnection();
				if(connection != null)
				{
					stmt = connection.createStatement();
				}
				if(stmt != null)
				{
					resultSet = stmt.executeQuery(oSfsQuery.getSfsQuery());
				}
				if(resultSet != null)
				{
					while(resultSet.next())
					{
						SfsHo oSfsHo = new SfsHo();
						oSfsHo.setCode(checkForNull(resultSet.getString("code")));
						oSfsHo.setDescription(checkForNull(resultSet.getString("description")));
						oLstSfsDetails.add(oSfsHo);
					}
				}
				if(oLstSfsDetails.size() == 0)
				{
					oErrInfo.setErrorType(Errors.COMMON_EMPTY_DATA, locale);
				}
				oSfsRes.setLstSfsHO(oLstSfsDetails);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
			}
			finally
			{
				int conCloseFailure = closeConnection(connection,stmt,resultSet);
				if(conCloseFailure > 0)
				{
					System.out.println("Connection not closed in the method eIPAD.chartsummary.common.daoimpl. SfsDAOImpl.executeSfsQuery");
				}
			}
		}
		else
		{
			 oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
	    oSfsRes.getErrorsList().add(oErrInfo);
		return oSfsRes;
	}
	protected String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
