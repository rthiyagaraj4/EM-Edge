/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 02.11.2005
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.* ;
//import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PhProcessFillBean extends PhAdapter implements Serializable {

	public PhProcessFillBean() {
        try {
            doCommon();
        }catch(Exception e) {
		e.printStackTrace() ;
		}
	}

	private void doCommon() throws Exception {

    }
  
  public ArrayList loadFillProcessID(String process_type ,String process_date) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String process_id			=	"";

		ArrayList fill_process_id	= new ArrayList();

		try{
		connection = getConnection() ;
		String str_qry	=PhRepository.getPhKeyValue("SQL_PH_FILL_PROCESS_SELECT1");
		pstmt			= connection.prepareStatement(str_qry) ;
		pstmt.setString(1,process_type);
		pstmt.setString(2,process_date);
		resultSet		= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			process_id		=	resultSet.getString(1);
			fill_process_id.add(process_id);
		}
		 
	    }catch ( Exception e ) {
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
					es.printStackTrace() ;
					}
              }


		return fill_process_id;


  }

	public ArrayList getOrderingFacilityId(String p_user_name) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//System.err.println("p_user_name----->"+p_user_name);
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
			pstmt = connection.prepareStatement("SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_lang_vw B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?") ;
			pstmt.setString(1,p_user_name);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME"));
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		//System.err.println("result--from bean--->"+result);
		return result;
	}
	



	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date	="";		
		try{
		connection = getConnection() ;
		String str_qry	=PhRepository.getPhKeyValue("SQL_PH_FILL_PROCESS_SELECT2");
		pstmt			= connection.prepareStatement(str_qry) ;
		resultSet		= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			sys_date=resultSet.getString(1);
		}
		 
	    }catch ( Exception e ) {
				sys_date+=e.toString();
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
					es.printStackTrace() ;
					}
              }
		return sys_date;
}

}
