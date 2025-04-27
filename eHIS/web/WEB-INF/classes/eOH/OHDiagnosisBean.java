/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH ;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import eOH.Common.OHAdapter;
import com.ehis.util.DateUtils;
import eCommon.Common.CommonBean;

public class OHDiagnosisBean extends OHAdapter implements Serializable {
	public OHDiagnosisBean() {
		try {
			doCommon();
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {}

	public void clear(){}

	public String getPermanentDeciduous(String facility_id, String patient_id, String treatment_condition_date){
		
		Connection connection  = null ;
		PreparedStatement pstmt= null ;
		ResultSet rs = null;

		int mixed_dentition_from_age_yrs = 0;
		int mixed_dentition_from_age_days = 0;
		int mixed_dentition_to_age_yrs = 0;
		int mixed_dentition_to_age_days = 0;
		String dflt_mixed_dentition_chart = "";

		String PD_flag = "";
		String currentAgeOfPatient = "";
		int patientAge = 0;
		int patientAgeDays = 0;
			
		try{
			connection	= getConnection() ;
			pstmt=connection.prepareStatement("SELECT NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT GET_AGE_YD(DATE_OF_BIRTH,?) FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE FROM OH_PARAM_FOR_FACILITY A WHERE FACILITY_ID=?");
			pstmt.setString(1,treatment_condition_date);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,facility_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				mixed_dentition_from_age_yrs	= Integer.parseInt(rs.getString("MIXED_DENTITION_FROM_AGE_YRS"));
				mixed_dentition_from_age_days	= Integer.parseInt(rs.getString("MIXED_DENTITION_FROM_AGE_DAYS"));
				mixed_dentition_to_age_yrs		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_YRS"));
				mixed_dentition_to_age_days		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_DAYS"));
				dflt_mixed_dentition_chart      = rs.getString("DFLT_MIXED_DENTITION_CHART");
				currentAgeOfPatient	= rs.getString("PATIENT_AGE");
			}
				
			// get the age in years.
			int patientAgeAtIndex = currentAgeOfPatient.indexOf("Y");
			if(patientAgeAtIndex == -1)
			  patientAge = 0;
			else 
			  patientAge = Integer.parseInt(currentAgeOfPatient.substring(0,patientAgeAtIndex));

			if(currentAgeOfPatient.indexOf("D") != -1){
				patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+1,currentAgeOfPatient.indexOf("D")));
			}

				
			if(patientAge < mixed_dentition_from_age_yrs){
				PD_flag = "D"; // Deciduous
			}
			else if(patientAge == mixed_dentition_from_age_yrs){
				if(patientAgeDays < mixed_dentition_to_age_days){
					PD_flag = "D"; // Deciduous
				}
				
			}
			
			if(patientAge > mixed_dentition_to_age_yrs ){
				PD_flag = "P"; // Permament
			}
			else if(patientAge == mixed_dentition_to_age_yrs ){
				if( patientAgeDays > mixed_dentition_to_age_days){
					PD_flag = "P"; // Permament
				}
				
			}
			
			if(patientAge>=mixed_dentition_from_age_yrs && patientAge<=mixed_dentition_to_age_yrs){
							
				if(dflt_mixed_dentition_chart.equals("D")){
					PD_flag = "D"; // Deciduous
				}
				else{
					PD_flag = "P"; // Permament
				}
			}
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				if(rs!=null) rs.close();
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return  PD_flag;
	}

}

