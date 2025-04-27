/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PharmacistHomeBean extends PhAdapter implements Serializable {



	private String store_code;

	public void initialize(){
		super.initialize();
		store_code = "";
	}

	public void  clear(){
		super.clear();
		store_code ="";  
	}

	public void setStore_code(String store_code){
		this.store_code=store_code;
	}
	public String getStore_code(){
		return store_code;
	}



	public String getStore_code_List(String deft_Store) {
		ArrayList sqlParam = new ArrayList ();
		String listValues ="";
		try{
			sqlParam.add(getLoginFacilityId());
			sqlParam.add(getLoginById());
			sqlParam.add(getLanguageId());
			listValues = getListValues(PhRepository.getPhKeyValue("SQL_ST_SAL_STORE_SELECT"), sqlParam,deft_Store);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listValues;
    }

	public ArrayList getDesktopDtl() {
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList dfltDesktopDtl = new ArrayList();
		try{
			connection = getConnection() ;
			sql_query           = "SELECT DESKTOP_ID , NVL(LEGEND_FOR_DESK_TOP,DESKTOP_SUMMARY_NAME) DESKTOP_SUMMARY_NAME,DFLT_FUNCTION_ID FROM PH_ST_DESKTOP_FOR_USER PH, SM_DESKTOP_SUM_HDR SM WHERE SM.DESKTOP_SUMMARY_ID = PH.DESKTOP_ID AND PH.USER_ID = ? ";
			//sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_HOMELEAVE");
			pstmt				= connection.prepareStatement(sql_query) ;

			pstmt.setString(1,getLoginById());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				dfltDesktopDtl.add(checkForNull(resultSet.getString("DESKTOP_ID")));
				dfltDesktopDtl.add(checkForNull(resultSet.getString("DESKTOP_SUMMARY_NAME")));
				dfltDesktopDtl.add(checkForNull(resultSet.getString("DFLT_FUNCTION_ID")));
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;

		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return dfltDesktopDtl;
	}
}
