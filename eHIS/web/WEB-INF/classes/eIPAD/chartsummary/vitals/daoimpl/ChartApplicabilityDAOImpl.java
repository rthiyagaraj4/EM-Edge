/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.daoimpl;

import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.vitals.request.*;
import eIPAD.chartsummary.vitals.response.*;
import java.sql.*;
import eIPAD.chartsummary.vitals.dao.*; 


public class ChartApplicabilityDAOImpl extends GenericDAOImpl implements ChartApplicabilityDAO {
	public ChartApplicabilityResponse getChartApplicability(VitalsRequest oVitalsReq)
	{
		ChartApplicabilityResponse oChartApplicabilityResponse = new ChartApplicabilityResponse();
		Connection connection 		= null;
		CallableStatement cstmt		= null;
		String locale = "en";
		//String strPatientId = "";
		String encounterId = "";
		String facilityId = "";
		String patientClass = "";
		String pracType = "";
		String locationCode = "";
		String locationTypeIndicator = "N";
		String ageGroup = "*ALL";
		String errorMessage = "";
		String chartId = "";
		ErrorInfo oErrInfo = new ErrorInfo();
		
		if(oVitalsReq != null)
		{
			PatContext oPatContext = oVitalsReq.getPatientContext();
			if(oPatContext != null)
			{
				patientClass = checkForNull(oPatContext.getPatientClass());
				encounterId = (oPatContext.getSelectedEncounterId() == null || oPatContext.getSelectedEncounterId().equals("")) ? oPatContext.getEncounterId() : oPatContext.getSelectedEncounterId();//checkForNull(oPatContext.getEncounterId());
				facilityId = checkForNull(oPatContext.getFacilityId());
				//strPatientId = checkForNull(oPatContext.getPatientId());
				locationCode = checkForNull(oPatContext.getLocationCode());
				pracType = checkForNull(oPatContext.getPracType());
				
				try
				{
					connection = createConnection();
					if(connection != null)
					{
						cstmt = connection.prepareCall("{call EM_GET_CHART_CODE(?,?,?,?,?,?,?,?,?)}");
						cstmt.setString(1, patientClass);
						cstmt.setString(2, facilityId);
						cstmt.setString(3, encounterId);
						cstmt.setString(4, locationTypeIndicator);
						cstmt.setString(5, pracType);
						cstmt.setString(6, locationCode);
						cstmt.setString(7, ageGroup);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.execute();
						chartId = cstmt.getString(8);
						errorMessage = cstmt.getString(9);
						int cstmtClose = closeConnection(cstmt);
						int conclose = closeConnection(connection);
						if(errorMessage != null && !errorMessage.equals("") )
						{
							//oErrInfo.setErrorMessage(errorMessage);
							oErrInfo.setErrorType(Errors.MULTIPLE_CHART_CONFIGURED,locale);
						}
						if(chartId == null || chartId.equals(""))
						{
							oErrInfo.setErrorType(Errors.COMMON_EMPTY_DATA, locale);
						}
						
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
				}
				finally
				{
					int cstmtClose = closeConnection(cstmt);
					int conclose = closeConnection(connection);
				}
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		oChartApplicabilityResponse.setChartId(chartId);
		oChartApplicabilityResponse.getErrorsList().add(oErrInfo);
		return oChartApplicabilityResponse;
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
