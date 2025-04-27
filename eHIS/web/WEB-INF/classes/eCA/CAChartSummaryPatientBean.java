/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
01/11/2018  IN063285            prathyusha                                      ML-MMOH-CRF-0757
--------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import eCA.Common.CaAdapter;
import eOR.Common.* ;


public class CAChartSummaryPatientBean extends CaAdapter implements Serializable {
	public String finacialDetailsRequiredForPatient(String encounter_id,String episode_id, String patient_id, String patient_class, String visit_id) throws Exception {
		
		Connection connection = null;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		PreparedStatement pStatment1 = null;
		ResultSet resultSet1 = null;
		String paramQuery =  " SELECT FINACIAL_DTL_REQ_YN FROM CA_PARAM";
		String blVisitDtlsQuery1 = " SELECT count(*) COUNT FROM   BL_EPISODE_FIN_DTLS  WHERE operating_facility_id = ?  AND episode_id = ? AND (tot_unbld_amt <> 0 or  tot_outst_amt <> 0)";
		String blVisitDtlsQuery2 = " SELECT count(*) COUNT FROM   BL_VISIT_FIN_DTLS WHERE operating_facility_id = ? AND episode_id = ? AND  patient_id = ? AND visit_id   = nvl(?,1) AND (tot_unbld_amt <> 0 or  tot_outst_amt <> 0)";
		String finacial_dtl_req_yn="N";
		String bill_amont="N";
		String resultStatus="N";
		
	 try{
		       connection = getConnection() ;
				
		       pStatment = connection.prepareStatement(paramQuery.toString());
				resultSet = pStatment.executeQuery();
				
				while(resultSet.next())
				{
					finacial_dtl_req_yn = resultSet.getString("FINACIAL_DTL_REQ_YN");
				}
				if(resultSet!=null)resultSet.close();		
				if(pStatment!=null)pStatment.close();
				
				if(patient_class.equals( "IP") || patient_class.equals( "DC") || patient_class.equals( "OP") || patient_class.equals("EM")){
				if(patient_class.equals("IP") || patient_class.equals("DC")){
				pStatment1 = connection.prepareStatement(blVisitDtlsQuery1.toString());
				}
				else if(patient_class.equals( "OP") || patient_class.equals("EM") ){
					pStatment1 = connection.prepareStatement(blVisitDtlsQuery2.toString());
				}
				
				pStatment1.setString(1, login_facility_id);
				pStatment1.setString(2, episode_id);
				
				 if(patient_class.equals( "OP") || patient_class.equals("EM")){
					
					 pStatment1.setString(3, patient_id);
					 pStatment1.setString(4, visit_id);
				}
				resultSet1 = pStatment1.executeQuery();
				
				while(resultSet1.next())
				{
					int count = resultSet1.getInt("COUNT");
					if(count>0){
						bill_amont="Y";
					}
					else{
						bill_amont="N";
					}
					
				}
				
				if(resultSet1!=null)resultSet1.close();		
				if(pStatment1!=null)pStatment1.close();
				}
				
				if(finacial_dtl_req_yn.equals("Y") && bill_amont.equals("Y")&& encounter_id !=null  && !encounter_id.equals("")){
					 resultStatus ="Y";
				 }
				else{
					 resultStatus ="N";	
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	 
		
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			if(connection != null) connection.close();
		}
		return resultStatus;
	}
}
