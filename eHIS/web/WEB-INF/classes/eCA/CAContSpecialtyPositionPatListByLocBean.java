/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
01/31/2024   49654      Twinkle Shah    Ramesh Goli      ML-MMOH-CRF-2109 									
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
public class CAContSpecialtyPositionPatListByLocBean extends CaAdapter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Connection con;
    private PreparedStatement pstmt; 
    private ResultSet rs;

  public ArrayList getMppedPositionDtlToPactitioner(String facilityId, String pract_type, String locale){

	ArrayList accessRightsResult  =new ArrayList();
			StringBuffer dataQuery =new StringBuffer(); 
			dataQuery.append("SELECT DISTINCT A.POSITION_CODE, A.POSITION_DESC, (SELECT 'U' FROM CA_CNTRL_SPL_POSITION_BY_LOC WHERE POSITION_CODE = B.POSITION_CODE AND  PRACT_TYPE = ? AND FACILITY_ID = ?) POSITIONIU, (SELECT POSITION_RESTR_YN FROM CA_CNTRL_SPL_POSITION_BY_LOC WHERE POSITION_CODE = B.POSITION_CODE AND PRACT_TYPE = ? AND FACILITY_ID = ?) POSITION_RESTR_YN,B.PRACT_TYPE FROM AM_POSITION A INNER JOIN AM_PRACTITIONER_LANG_VW B ON A.POSITION_CODE = B.POSITION_CODE WHERE A.EFF_STATUS = 'E' AND A.POSITION_CODE = B.POSITION_CODE AND B.LANGUAGE_ID = ? AND B.PRACT_TYPE = ? AND (? IN ( SELECT SFFU.FACILITY_ID FROM SM_FACILITY_FOR_USER_VW SFFU, SM_APPL_USER SAU WHERE SFFU.APPL_USER_ID = SAU.APPL_USER_ID AND SAU.FUNC_ROLE_ID = B.PRACTITIONER_ID) OR ALL_FACILITIES_YN = 'Y' ) ORDER BY A.POSITION_CODE");
			try{
    			con		= getConnection();
    	    	pstmt = con.prepareStatement(dataQuery.toString());
    	    	pstmt.setString(1,pract_type);
    	    	pstmt.setString(2,facilityId);
    	    	pstmt.setString(3,pract_type);
	    		pstmt.setString(4,facilityId);
    	    	pstmt.setString(5,locale);
    	    	pstmt.setString(6,pract_type);
	    		pstmt.setString(7,facilityId);
    	    	 rs = pstmt.executeQuery();
    	    	if (rs !=null ){
    	    		while(rs.next() )
    	    		{
	    			ArrayList<String>  accessRightsPosition = new ArrayList<String>();
	    			accessRightsPosition.add(rs.getString("position_code")==null?"":(String)rs.getString("position_code"));
	    			accessRightsPosition.add(rs.getString("position_desc")==null?"":(String)rs.getString("position_desc"));
	    			accessRightsPosition.add(rs.getString("positionIU")==null?"I":(String)rs.getString("positionIU"));
	    			accessRightsPosition.add(rs.getString("position_restr_yn")==null?"N":(String)rs.getString("position_restr_yn"));
	    			accessRightsPosition.add(rs.getString("pract_type")==null?"":(String)rs.getString("pract_type"));
	    			accessRightsResult.add(accessRightsPosition);
    	    		}
    		}
    	    	if(rs!=null) rs.close();	
    	    	if(pstmt!=null) pstmt.close();	
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
}


