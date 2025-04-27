/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
10/16/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210     									
--------------------------------------------------------------------------------------------------------------
*/ 

package eCA;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eCA.Common.CaAdapter;
public class CAAccessRightsForViewRestrictPatientBean extends CaAdapter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Connection con;
    private PreparedStatement pstmt; 
    private PreparedStatement pstmt1; 
    private PreparedStatement pstmt2; 
    private PreparedStatement pstmt3; 
    private ResultSet rs;
    private ResultSet rs1;
    private ResultSet rs2;

  public ArrayList getAccessRightsViewClinicalDataRestrictedPatients(String facilityId, String practitionerId, String search_by, String search_txt, String locale){

	ArrayList accessRightsResult  =new ArrayList();
	
			StringBuffer dataQuery =new StringBuffer(); 
		//	dataQuery.append("SELECT APLV.PRACTITIONER_ID, APLV.PRACTITIONER_NAME, SM_CONVERT_DATE_2T (CRSA.ACCESS_FROM_DATE, ?) ACCESS_FROM_DATE, SM_CONVERT_DATE_2T (CRSA.ACCESS_TO_DATE, ?) ACCESS_TO_DATE, (SELECT 'U' FROM CA_ACCESS_VIEW_RESTR_PATIENT WHERE PRACTITIONER_ID = APLV.PRACTITIONER_ID AND FACILITY_ID = ?) PRACT_YN, CRSA.ACCESS_RES_PAT_YN FROM AM_PRACTITIONER_LANG_VW APLV, CA_ACCESS_VIEW_RESTR_PATIENT CRSA WHERE CRSA.PRACTITIONER_ID(+) = APLV.PRACTITIONER_ID AND (? IN ( SELECT SFFU.FACILITY_ID FROM SM_FACILITY_FOR_USER_VW SFFU, SM_APPL_USER SAU WHERE SFFU.APPL_USER_ID = SAU.APPL_USER_ID AND SAU.FUNC_ROLE_ID = APLV.PRACTITIONER_ID) OR ALL_FACILITIES_YN = 'Y' ) AND APLV.LANGUAGE_ID =? AND CRSA.FACILITY_ID(+) =? AND APLV.EFF_STATUS ='E'");
			dataQuery.append("SELECT APLV.PRACTITIONER_ID, APLV.PRACTITIONER_NAME, TO_CHAR(CRSA.ACCESS_FROM_DATE, 'DD/MM/YYYY') ACCESS_FROM_DATE, TO_CHAR (CRSA.ACCESS_TO_DATE, 'DD/MM/YYYY') ACCESS_TO_DATE, (SELECT 'U' FROM CA_ACCESS_VIEW_RESTR_PATIENT WHERE PRACTITIONER_ID = APLV.PRACTITIONER_ID AND FACILITY_ID = ?) PRACT_YN, CRSA.ACCESS_RES_PAT_YN FROM AM_PRACTITIONER_LANG_VW APLV, CA_ACCESS_VIEW_RESTR_PATIENT CRSA WHERE CRSA.PRACTITIONER_ID(+) = APLV.PRACTITIONER_ID AND (? IN ( SELECT SFFU.FACILITY_ID FROM SM_FACILITY_FOR_USER_VW SFFU, SM_APPL_USER SAU WHERE SFFU.APPL_USER_ID = SAU.APPL_USER_ID AND SAU.FUNC_ROLE_ID = APLV.PRACTITIONER_ID) OR ALL_FACILITIES_YN = 'Y' ) AND APLV.LANGUAGE_ID =? AND CRSA.FACILITY_ID(+) =? AND APLV.EFF_STATUS ='E'");
			if("01".equals(search_by)){
	        dataQuery.append("AND  UPPER(APLV.PRACTITIONER_ID) LIKE UPPER(?)");
	        }else if("02".equals(search_by)){
		   dataQuery.append("AND UPPER(APLV.PRACTITIONER_NAME) LIKE UPPER(?)");
	        }
            dataQuery.append(" ORDER BY PRACTITIONER_NAME ASC  ");
    		try{
    			con		= getConnection();
    	    	pstmt = con.prepareStatement(dataQuery.toString());
    	    		//pstmt.setString(1,locale);
    	    	//	pstmt.setString(2,locale);
    	    		pstmt.setString(1,facilityId);
    	    		pstmt.setString(2,facilityId);
    	    		pstmt.setString(3,locale);
    	    		pstmt.setString(4,facilityId);
    	    		if("01".equals(search_by)||"02".equals(search_by)){
    	    		pstmt.setString(5,"%"+search_txt+"%");
    	    		}  	    	
    	    	rs = pstmt.executeQuery();
    	    	if (rs !=null ){
    	    		while(rs.next() ){
	    			ArrayList<String>  accessRightsRec = new ArrayList<String>();
    	    		accessRightsRec.add(rs.getString("PRACTITIONER_ID")==null?"":(String)rs.getString("PRACTITIONER_ID"));
	    			accessRightsRec.add(rs.getString("PRACTITIONER_NAME")==null?"":(String)rs.getString("PRACTITIONER_NAME"));
	    			accessRightsRec.add(rs.getString("ACCESS_FROM_DATE")==null?"":(String)rs.getString("ACCESS_FROM_DATE"));
	    			accessRightsRec.add(rs.getString("ACCESS_TO_DATE")==null?"":(String)rs.getString("ACCESS_TO_DATE"));
	    			accessRightsRec.add(rs.getString("PRACT_YN")==null?"I":(String)rs.getString("PRACT_YN"));
	    			accessRightsRec.add(rs.getString("ACCESS_RES_PAT_YN")==null?"N":(String)rs.getString("ACCESS_RES_PAT_YN"));
    				accessRightsResult.add(accessRightsRec);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
    		}
    	return accessRightsResult;
    }
 public ArrayList getAccessRightsViewRestrictPatHistoryDtl(String facilityId, String practitionerId)
 {
	 	ArrayList<ArrayList<String>>  accessRightsDetails=new ArrayList<ArrayList<String>>();
	 String sql = "SELECT TO_CHAR (crsal.access_from_date, 'DD/MM/YYYY') access_from_date, TO_CHAR (crsal.access_to_date, 'DD/MM/YYYY') access_to_date, (SELECT practitioner_name FROM am_practitioner WHERE practitioner_id = crsal.added_by_id) practitioner_name, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI:SS') added_date, DECODE (row_status, 'I', 'CREATED', 'U', 'MODIFIED', 'D', 'DELETED' ) rowstatus FROM ca_access_restr_pat_log crsal WHERE crsal.practitioner_id = ? AND crsal.facility_id = ? ORDER BY crsal.added_date DESC";
		try{
			con		= getConnection();
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1, practitionerId);
			pstmt.setString(2, facilityId);			
			rs = pstmt.executeQuery();
			int i=0;
			if(rs!=null){
				while(rs.next()){
	    			ArrayList<String>  accessRightsRec = new ArrayList<String>();

	    			accessRightsRec.add(rs.getString("ACCESS_FROM_DATE")==null?"":(String)rs.getString("ACCESS_FROM_DATE"));
	    			accessRightsRec.add(rs.getString("ACCESS_TO_DATE")==null?"":(String)rs.getString("ACCESS_TO_DATE"));
	    			accessRightsRec.add(rs.getString("PRACTITIONER_NAME")==null?"":(String)rs.getString("PRACTITIONER_NAME"));
	    			accessRightsRec.add(rs.getString("ADDED_DATE")==null?"":(String)rs.getString("ADDED_DATE"));
	    			accessRightsRec.add(rs.getString("ROWSTATUS")==null?"":(String)rs.getString("ROWSTATUS"));
	    			accessRightsDetails.add(accessRightsRec);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
		return accessRightsDetails;
 }
}


