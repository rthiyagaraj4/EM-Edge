/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
-------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2024  50627    Twinkle Shah    21/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
14/06/2024    62519   Krishna Pranay     20/06/2024     Ramesh Goli      COMMON-ICN-0289
-------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eCA.Common.CaAdapter;
public class ConsultationTaggingBean extends CaAdapter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<ArrayList<String>> getPatRecordConsultationTagging(String patient_id,String facility_id,String language_id){
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		ArrayList<ArrayList<String>> ResultDetail = null;
		try
		{
		String  emrResultQuery="SELECT * FROM (SELECT A.PATIENT_ID, A.FACILITY_ID, A.ENCOUNTER_ID ENCOUNTER_ID, AM_GET_DESC.AM_PATIENT_CLASS (A.PATIENT_CLASS, ?, '2' ) EPISODE_TYPE_DESC, TO_CHAR (A.VISIT_ADM_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) VISIT_ADM_DATE, TO_CHAR (A.DISCHARGE_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) DISCHARGE_DATE_TIME, NVL (AM_GET_DESC.AM_PRACTITIONER (A.ATTEND_PRACTITIONER_ID, ?, '2' ), '' ) PHY_PROV_NAME, AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE, ?, '2') SPECIALITY, A.PATIENT_CLASS FROM PR_ENCOUNTER A, MP_PATIENT B, CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND ( ( A.PATIENT_CLASS IN ('IP', 'DC') AND A.ADT_STATUS NOT IN ('00', '09') ) OR ( A.PATIENT_CLASS IN ('OP', 'EM') AND A.VISIT_STATUS NOT IN ('01', '02', '99') ) ) AND A.FACILITY_ID = ? AND C.FACILITY_ID = A.FACILITY_ID AND A.DISCHARGE_DATE_TIME IS NULL AND (A.PATIENT_CLASS = 'IP' AND C.APPLI_PAT_CONSULTAG_IPYN = 'Y' ) UNION ALL SELECT A.PATIENT_ID, A.FACILITY_ID, A.ENCOUNTER_ID ENCOUNTER_ID, AM_GET_DESC.AM_PATIENT_CLASS (A.PATIENT_CLASS, ?, '2' ) EPISODE_TYPE_DESC, TO_CHAR (A.VISIT_ADM_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) VISIT_ADM_DATE, TO_CHAR (A.DISCHARGE_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) DISCHARGE_DATE_TIME, NVL (AM_GET_DESC.AM_PRACTITIONER (A.ATTEND_PRACTITIONER_ID, ?, '2' ), '' ) PHY_PROV_NAME, AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE, ?, '2') SPECIALITY, A.PATIENT_CLASS FROM PR_ENCOUNTER A, MP_PATIENT B, CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND ( ( A.PATIENT_CLASS IN ('IP', 'DC') AND A.ADT_STATUS NOT IN ('00', '09') ) OR ( A.PATIENT_CLASS IN ('OP', 'EM') AND A.VISIT_STATUS NOT IN ('01', '02', '99') ) ) AND A.FACILITY_ID = ? AND C.FACILITY_ID = A.FACILITY_ID AND A.DISCHARGE_DATE_TIME IS NULL AND (A.PATIENT_CLASS = 'OP' AND C.APPLI_PAT_CONSULTAG_OPYN = 'Y' ) UNION ALL SELECT A.PATIENT_ID, A.FACILITY_ID, A.ENCOUNTER_ID ENCOUNTER_ID, AM_GET_DESC.AM_PATIENT_CLASS (A.PATIENT_CLASS, ?, '2' ) EPISODE_TYPE_DESC, TO_CHAR (A.VISIT_ADM_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) VISIT_ADM_DATE, TO_CHAR (A.DISCHARGE_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) DISCHARGE_DATE_TIME, NVL (AM_GET_DESC.AM_PRACTITIONER (A.ATTEND_PRACTITIONER_ID, ?, '2' ), '' ) PHY_PROV_NAME, AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE, ?, '2') SPECIALITY, A.PATIENT_CLASS FROM PR_ENCOUNTER A, MP_PATIENT B, CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND ( ( A.PATIENT_CLASS IN ('IP', 'DC') AND A.ADT_STATUS NOT IN ('00', '09') ) OR ( A.PATIENT_CLASS IN ('OP', 'EM') AND A.VISIT_STATUS NOT IN ('01', '02', '99') ) ) AND A.FACILITY_ID = ? AND C.FACILITY_ID = A.FACILITY_ID AND A.DISCHARGE_DATE_TIME IS NULL AND (A.PATIENT_CLASS = 'DC' AND C.APPLI_PAT_CONSULTAG_DCYN = 'Y' ) UNION ALL SELECT A.PATIENT_ID, A.FACILITY_ID, A.ENCOUNTER_ID ENCOUNTER_ID, AM_GET_DESC.AM_PATIENT_CLASS (A.PATIENT_CLASS, ?, '2' ) EPISODE_TYPE_DESC, TO_CHAR (A.VISIT_ADM_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) VISIT_ADM_DATE, TO_CHAR (A.DISCHARGE_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS' ) DISCHARGE_DATE_TIME, NVL (AM_GET_DESC.AM_PRACTITIONER (A.ATTEND_PRACTITIONER_ID, ?, '2' ), '' ) PHY_PROV_NAME, AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE, ?, '2') SPECIALITY, A.PATIENT_CLASS FROM PR_ENCOUNTER A, MP_PATIENT B, CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND ( ( A.PATIENT_CLASS IN ('IP', 'DC') AND A.ADT_STATUS NOT IN ('00', '09') ) OR ( A.PATIENT_CLASS IN ('OP', 'EM') AND A.VISIT_STATUS NOT IN ('01', '02', '99') ) ) AND A.FACILITY_ID = ? AND C.FACILITY_ID = A.FACILITY_ID AND A.DISCHARGE_DATE_TIME IS NULL AND (A.PATIENT_CLASS = 'EM' AND C.APPLI_PAT_CONSULTAG_EMYN = 'Y' )) RESULT ORDER BY TO_DATE (VISIT_ADM_DATE, 'DD/MM/YYYY HH24:MI:SS') DESC";
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			pstmt.setString( 1 , language_id);
			pstmt.setString( 2 , language_id);
			pstmt.setString( 3 , language_id);
			pstmt.setString( 4 , patient_id);
			pstmt.setString( 5 , facility_id);
			pstmt.setString( 6 , language_id);
			pstmt.setString( 7 , language_id);
			pstmt.setString( 8 , language_id);
			pstmt.setString( 9 , patient_id);
			pstmt.setString( 10 ,facility_id);
			pstmt.setString( 11, language_id);
			pstmt.setString( 12, language_id);
			pstmt.setString( 13, language_id);
			pstmt.setString( 14, patient_id);
			pstmt.setString( 15, facility_id);
			pstmt.setString( 16, language_id);
			pstmt.setString( 17, language_id);
			pstmt.setString( 18, language_id);
			pstmt.setString( 19, patient_id);
			pstmt.setString( 20, facility_id);
			rs	= pstmt.executeQuery();
			ResultDetail = new ArrayList<ArrayList<String>>();
			while(rs.next())
				{
						ArrayList<String> SearchResult	= new ArrayList<String>() ;
					SearchResult.add(rs.getString( "patient_id"));		
					SearchResult.add(rs.getString( "encounter_id"));	
					SearchResult.add(rs.getString( "visit_adm_date")); 
				    SearchResult.add(rs.getString( "speciality")); 
					SearchResult.add(rs.getString( "patient_class"));	
						ResultDetail.add(SearchResult);
				}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
		     /*  if(rs != null)  //62519
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null) 
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}*/
			
			//start  62519
			try{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection( con );
				 
				}catch(Exception e){
				e.printStackTrace();
				}
			
			//  end  62519
		}
		return ResultDetail;
	}	

public ArrayList getConsultationTagHistoryDtl(String facilityId, String patient_id,String encounter_id)
{
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	Connection con		 		= null;
 	ArrayList<ArrayList<String>>  consultationTagHistory=new ArrayList<ArrayList<String>>();
    String sql = "SELECT(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = A.TAG_PRACTITIONER_ID) PRACTITIONER_NAME, TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE, TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI') END_DATE, DECODE (ROW_STATUS, 'I', 'Created', 'U', 'Modified', 'D', 'Deleted' ) ACTION, A.ADDED_BY_ID,TO_CHAR (ADDED_DATE, 'DD/MM/YYYY HH24:MI') ADDED_DATE FROM CA_CONSULTATION_TAGGING_LOG A WHERE A.PATIENT_ID =? AND A.FACILITY_ID =? AND A.ENCOUNTER_ID=? ORDER BY A.ADDED_DATE DESC";
	try{
		con		= getConnection();
		pstmt	= con.prepareStatement(sql);
		pstmt.setString(1, patient_id);	
		pstmt.setString(2, facilityId);
		pstmt.setString(3, encounter_id);
		rs = pstmt.executeQuery();
		// int i=0;  //62519  
		if(rs!=null){
			while(rs.next()){
    			ArrayList<String>  consultationTagHistoryRec = new ArrayList<String>();
    			consultationTagHistoryRec.add(rs.getString("PRACTITIONER_NAME")==null?"":(String)rs.getString("PRACTITIONER_NAME"));
    			consultationTagHistoryRec.add(rs.getString("START_DATE")==null?"":(String)rs.getString("START_DATE"));
    			consultationTagHistoryRec.add(rs.getString("END_DATE")==null?"":(String)rs.getString("END_DATE"));
    			consultationTagHistoryRec.add(rs.getString("ACTION")==null?"":(String)rs.getString("ACTION"));
    			consultationTagHistoryRec.add(rs.getString("ADDED_BY_ID")==null?"":(String)rs.getString("ADDED_BY_ID"));
    			consultationTagHistoryRec.add(rs.getString("ADDED_DATE")==null?"":(String)rs.getString("ADDED_DATE"));
    			consultationTagHistory.add(consultationTagHistoryRec);
    }
	}
	if(rs!=null) rs.close();	
	if(pstmt!=null) pstmt.close();	
	if(con!=null) con.close();	
}catch(Exception e){        		
		e.printStackTrace();
}
finally
{
	if(con!=null)
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
}
	return consultationTagHistory;
}

public String  appliPatConsulTagIPYN(String facilityId,String patientID)
{	
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	Connection con		 		= null;
	String appli_pat_consultag_ipyn="N";
	 int cCount=0;
	String sql1=("SELECT COUNT(C.APPLI_PAT_CONSULTAG_IPYN) APPLI_PAT_CONSULTAG_IPYN FROM PR_ENCOUNTER A, MP_PATIENT B,CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS IN ('IP', 'DC','OP','EM') AND A.FACILITY_ID = ? AND C.FACILITY_ID =A.FACILITY_ID AND (A.PATIENT_CLASS ='IP' AND C.APPLI_PAT_CONSULTAG_IPYN ='Y' )");
				try{
			     con		= getConnection();
				 pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, patientID);
				pstmt.setString(2, facilityId);
				rs = pstmt.executeQuery() ;
				if(rs!=null && rs.next()){
						cCount=rs.getInt("APPLI_PAT_CONSULTAG_IPYN");
                       if(cCount >0) 
    	                appli_pat_consultag_ipyn ="Y";
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
	
		}catch(Exception e){        		
				e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		}
			return appli_pat_consultag_ipyn;
}
public String  appliPatConsulTagOPYN(String facilityId,String patientID)
{	
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	Connection con		 		= null;
	String appli_pat_consultag_opyn="N";
	 int cCount=0;
	String sql1=("SELECT COUNT(C.APPLI_PAT_CONSULTAG_OPYN) APPLI_PAT_CONSULTAG_OPYN FROM PR_ENCOUNTER A, MP_PATIENT B,CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS IN ('IP', 'DC','OP','EM') AND A.FACILITY_ID = ? AND C.FACILITY_ID =A.FACILITY_ID AND (A.PATIENT_CLASS ='OP' AND C.APPLI_PAT_CONSULTAG_OPYN ='Y' )");
				try{
			     con		= getConnection();
				 pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, patientID);
				pstmt.setString(2, facilityId);
				rs = pstmt.executeQuery() ;
				if(rs!=null && rs.next()){
						cCount=rs.getInt("APPLI_PAT_CONSULTAG_OPYN");
                       if(cCount >0) 
    	                appli_pat_consultag_opyn ="Y";
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
	
		}catch(Exception e){        		
				e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		}
			return appli_pat_consultag_opyn;
}
public String  appliPatConsulTagEMYN(String facilityId,String patientID)
{	
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	Connection con		 		= null;
	String appli_pat_consultag_emyn="N";
	 int cCount=0;
	String sql1=("SELECT COUNT(C.APPLI_PAT_CONSULTAG_EMYN) APPLI_PAT_CONSULTAG_EMYN FROM PR_ENCOUNTER A, MP_PATIENT B,CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS IN ('IP', 'DC','OP','EM') AND A.FACILITY_ID = ? AND C.FACILITY_ID =A.FACILITY_ID AND (A.PATIENT_CLASS ='EM' AND C.APPLI_PAT_CONSULTAG_EMYN ='Y' )");
				try{
			     con		= getConnection();
				 pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, patientID);
				pstmt.setString(2, facilityId);
				rs = pstmt.executeQuery() ;
				if(rs!=null && rs.next()){
						cCount=rs.getInt("APPLI_PAT_CONSULTAG_EMYN");
                       if(cCount >0) 
    	                appli_pat_consultag_emyn ="Y";
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
	
		}catch(Exception e){        		
				e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		}
			return appli_pat_consultag_emyn;
}
public String  appliPatConsulTagDCYN(String facilityId,String patientID)
{	
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	Connection con		 		= null;
	String appli_pat_consultag_dcyn="N";
	 int cCount=0;
	String sql1=("SELECT COUNT(C.APPLI_PAT_CONSULTAG_DCYN) APPLI_PAT_CONSULTAG_DCYN FROM PR_ENCOUNTER A, MP_PATIENT B,CA_PARAM_BY_FACILITY C WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS IN ('IP', 'DC','OP','EM') AND A.FACILITY_ID = ? AND C.FACILITY_ID =A.FACILITY_ID AND (A.PATIENT_CLASS ='DC' AND C.APPLI_PAT_CONSULTAG_DCYN ='Y' )");
				try{
			     con		= getConnection();
				 pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, patientID);
				pstmt.setString(2, facilityId);
				rs = pstmt.executeQuery() ;
				if(rs!=null && rs.next()){
						cCount=rs.getInt("APPLI_PAT_CONSULTAG_DCYN");
                       if(cCount >0) 
    	                appli_pat_consultag_dcyn ="Y";
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
	
		}catch(Exception e){        		
				e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		}
			return appli_pat_consultag_dcyn;
}

public boolean  getRecordYN(String facilityId,String patientID,String encounterid)
{	
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	Connection con		 		= null;
	 int cCount=0;
	 boolean recordExist=false;
	String sql1=("SELECT COUNT(*) COUNT FROM CA_CONSULTATION_TAGGING_LOG WHERE FACILITY_ID = ? AND PATIENT_ID = ? AND ENCOUNTER_ID = ?");
				try{
			     con		= getConnection();
				 pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, facilityId);
				pstmt.setString(2, patientID);
				pstmt.setString(3, encounterid);
				rs = pstmt.executeQuery() ;
				if(rs!=null && rs.next()){
						cCount=rs.getInt("COUNT");
                       if(cCount >0) 
                    	   recordExist =true;
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
	
		}catch(Exception e){        		
				e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		}
			return recordExist;
}
}
