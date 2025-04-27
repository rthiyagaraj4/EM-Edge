package eIPAD.InsuranceAuthorization.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import eIPAD.InsuranceAuthorization.dao.InsuranceAuthDAO;
import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

public class InsuranceAuthDAOImpl extends GenericDAOImpl implements InsuranceAuthDAO{
	public EncounterListResponse getEncounterListForPatient(String patientId, String facilityId, String locale){
		EncounterListResponse response = new EncounterListResponse();
		ArrayList<EncounterHO> encounterList = new ArrayList<EncounterHO>();
		ErrorInfo oErrInfo = new ErrorInfo();
		response.setEncounterList(encounterList);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String encQuery = "SELECT encounter_id FROM pr_encounter WHERE patient_id = ? ORDER BY VISIT_ADM_DATE_TIME DESC";
		if(patientId != null && !patientId.equals("")){
			try																					  
			{
				con =  createConnection();
				pstmt = con.prepareStatement(encQuery);
				pstmt.setString(1, patientId);
				rs = pstmt.executeQuery();
				String encounterId;
				
				while(rs.next())
				{
					oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
					encounterId = rs.getString("encounter_id");
					EncounterHO encounterHO = new EncounterHO();
					encounterHO.setEncounterId(encounterId);
					response.getEncounterList().add(encounterHO);
				}
			}catch(Exception e){
		    	
				e.printStackTrace();
				oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
		    }
			finally{
		    	int conCloseFailure = closeConnection(con,pstmt,rs);
		    	if(conCloseFailure > 0)
				{
					System.out.println("Connection not closed");
				}
		    }
		}else{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		response.getErrorsList().add(oErrInfo);
		return response;
	}
}
