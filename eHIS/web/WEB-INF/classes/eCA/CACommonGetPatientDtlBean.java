/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date                    Edit History        Name                                 Rev.Date                           Rev.Name                         Description
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

18/10/2023     32902             Krishna Pranay    	                  19/10/2023                                         Ramesh G                              MMS-DM-CRF-0210	
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

package eCA;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eCA.Common.CaAdapter;
public class CACommonGetPatientDtlBean extends CaAdapter implements Serializable{
              
              private static final long serialVersionUID = 1L;
   
  
    public int getAccessRightsViewPatient(String practitionerId,String facilityId)
	 {   
		Connection con	= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			 int cCount=0;
	 	 String sql = "SELECT count(*) countNum FROM CA_ACCESS_VIEW_RESTR_PATIENT WHERE practitioner_id =? AND facility_id =? AND ( ( access_from_date IS NULL AND access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (access_to_date, 'DD/MM/YYYY') ) OR ( access_from_date IS NOT NULL AND access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (access_from_date, 'DD/MM/YYYY') ) OR ( access_from_date IS NOT NULL AND access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (access_to_date, 'DD/MM/YYYY') ) )";
	 		try{
	 			 con			= getConnection();
	 			pstmt  = con.prepareStatement(sql);
				pstmt.setString(1, practitionerId);
				pstmt.setString(2, facilityId);

				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					cCount=rs.getInt("countNum");
					
				}
				
				if(rs!=null)
		    		rs.close();			    	
		    	if(pstmt!=null)
		    		pstmt.close();
	 	}catch(Exception e){        		
	 			e.printStackTrace();
	 	}
	 	finally
	 	{
	 		if(con!=null)
	 			try {
	 				con.close();
	 			} catch (SQLException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}		
	 	}
	 		return cCount;
	 }
    
    public String getRestrictedPatientYN(String patient_id)
	 {  
		Connection con	= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String restPatientYN ="";

	 	 String sql = "SELECT NVL(RESTRICT_REINSTATE_YN,'N') RESTRICT_REINSTATE_YN FROM MP_PATIENT WHERE  PATIENT_ID=?";
	 		try{
	 			 con			= getConnection();
	 			pstmt  = con.prepareStatement(sql);
				pstmt.setString(1, patient_id);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					restPatientYN	= rs.getString("RESTRICT_REINSTATE_YN")==null?"N":rs.getString("RESTRICT_REINSTATE_YN");
				}
				if(rs!=null)
		    		rs.close();			    	
		    	if(pstmt!=null)
		    		pstmt.close();
	 	}catch(Exception e){        		
	 			e.printStackTrace();
	 	}
	 	finally
	 	{
	 		if(con!=null)
	 			try {
	 				con.close();
	 			} catch (SQLException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}		
	 	}
	 		return restPatientYN;
	 }
}


