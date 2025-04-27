/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date           	Edit History    	Name        		Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
10/04/2024  50627    Twinkle Shah    10/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.util.* ;
import eCA.Common.CaAdapter;

import java.sql.*;

public class CAAllowPractConsultTagBean extends CaAdapter implements java.io.Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ArrayList  getallowPractConsultTag(String locale) throws Exception {
		Connection con	= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		ArrayList allowPractConsultTag = new ArrayList() ;
		
		String sql ="SELECT DECODE( NVL(A.PRACT_CONSULT_TAG_YN,'N'),'N','N','Y') EXIST_PRACT_TAG_YN, B.PRACT_TYPE, B.DESC_USERDEF, NVL (A.PRACT_CONSULT_TAG_YN, 'N') PRACT_CONSULT_TAG_YN FROM CA_PRACT_CONSULTA_TAG A RIGHT OUTER JOIN AM_PRACT_TYPE B ON A.PRACT_TYPE = B.PRACT_TYPE WHERE B.EFF_STATUS = 'E' ORDER BY 3";
		try{
		    con			= getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			    String pract_consult_tag_yn="";
                String exist_pract_tag_yn="";
			    while ( rs != null && rs.next() ) {
				String[] record = new String[4];
				record[0] = rs.getString( "PRACT_TYPE" )  ;
				record[1] = rs.getString( "DESC_USERDEF" )  ;
				pract_consult_tag_yn = rs.getString("PRACT_CONSULT_TAG_YN")==null?"N":(String)rs.getString("PRACT_CONSULT_TAG_YN");
				record[2] = pract_consult_tag_yn;
				exist_pract_tag_yn = rs.getString("EXIST_PRACT_TAG_YN")==null?"N":(String)rs.getString("EXIST_PRACT_TAG_YN");
				record[3] = exist_pract_tag_yn;
				allowPractConsultTag.add(record) ;
			}
			if(rs !=null) rs.close();
			if(psmt != null ) psmt.close();

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			closeResultSet( rs ) ;
            closeStatement( psmt ) ;
			closeConnection( con ); 	
		}
		return allowPractConsultTag;
	}
}