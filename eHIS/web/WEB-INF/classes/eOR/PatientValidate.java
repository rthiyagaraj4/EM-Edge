/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;


public class PatientValidate extends OrAdapter implements java.io.Serializable {

/**
	This will return valide patient_id
	@return		:	String[]
*/

	public String[] isValidPatient(String patient_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;PreparedStatement pstmt1 	= null;
		ResultSet resultSet 		= null;ResultSet resultSet1 		= null;
		String[] v_patient_id		= new String[2];

		try {
			connection 	= getConnection() ;
			pstmt 	= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN") ) ;
			pstmt1 	= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PATIENT_CHECK"));
			pstmt.setString(1,"DR");
			//pstmt		= connection.prepareStatement("select install_yn from sm_module where module_id = 'DR'");
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				if ((resultSet.getString(1)).equalsIgnoreCase("Y")) {

					//pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PATIENT_CHECK"));
					pstmt1.setString( 1, patient_id.trim() ) ;

					resultSet1 = pstmt1.executeQuery() ;

					if ( resultSet1 != null && resultSet1.next() ) {
						v_patient_id[0]	 = resultSet1.getString(1)  ;
						v_patient_id[1]	 = "Y";
					} else {
						v_patient_id[0]	 = patient_id;
						v_patient_id[1]	 = "N";
					}
					closeResultSet( resultSet1 ) ;
				} else {
					v_patient_id[0]	 = patient_id;
					v_patient_id[1]	 = "N";
				}
			}else {
				v_patient_id[0]	 = patient_id;
				v_patient_id[1]	 = "N";
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			System.out.println("patient_id:"+patient_id);
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 ) ;
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet1 ) ;
			closeConnection(connection) ;
		}

		return v_patient_id;
	}

}
