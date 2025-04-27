/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
08/05/2019		IN69021			Ramesh G			?				?				MMS-DM-CRF-0150
24/12/2021		6868			Ramesh G			24/12/2021		Ramesh G 		AAKH-CRF-0125
--------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;


import javax.servlet.*;
import javax.servlet.http.*;

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;

public class MDSForDiagnosisMandatoryBean extends OrAdapter implements java.io.Serializable{
	public ArrayList getResultDetails(Properties properties,String minimumData, String termsetId) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList ResultDetails = new ArrayList() ;
		
		try {
			connection			= ConnectionManager.getConnection(properties) ;
			//6868 Start.
			pstmt		= connection.prepareStatement("SELECT PRIMARY_DIAGNOSIS_YN FROM OR_MDS_DIAGNOSIS_MAND_HDR WHERE TERM_SET_ID=? AND MINUMUM_DATA_TYPE=?" ) ;
			pstmt.setString( 1, termsetId);
			pstmt.setString( 2, minimumData);
			resultSet  = pstmt.executeQuery() ;

			if( resultSet != null) {
				if(resultSet.next())
				{
				String[] record = new String[1];
				record[0] = resultSet.getString( "PRIMARY_DIAGNOSIS_YN" )  ;	
				ResultDetails.add(record) ;
				}else{
					String[] record = new String[1];
					record[0] = "N"  ;					
					ResultDetails.add(record) ;
				}	
				
			}else{
				String[] record = new String[1];
				record[0] = "N"  ;				
				ResultDetails.add(record) ;
			}	
			
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			//6868 End.
			String sqlQuery 	="";
			if("S".equals(minimumData)){
				sqlQuery 	= "SELECT A.SPECIALITY_CODE CODE,A.SHORT_DESC DESCRIPTION,DECODE(B.APPLIED_CODE,NULL,'N','Y') APPLIED_YN FROM AM_SPECIALITY  A LEFT JOIN OR_MDS_DIAGNOSIS_MAND B ON A.SPECIALITY_CODE = B.APPLIED_CODE AND B.MINUMUM_DATA_TYPE='S' AND B.TERM_SET_ID=? ORDER BY A.SHORT_DESC";
			}else if("O".equals(minimumData)){
				sqlQuery 	= "SELECT A.ORDER_CATEGORY CODE,SHORT_DESC DESCRIPTION,DECODE(B.APPLIED_CODE,NULL,'N','Y') APPLIED_YN FROM OR_ORDER_CATEGORY A LEFT JOIN OR_MDS_DIAGNOSIS_MAND B ON A.ORDER_CATEGORY = B.APPLIED_CODE AND B.MINUMUM_DATA_TYPE='O' AND B.TERM_SET_ID=? ORDER BY A.SHORT_DESC";
			}else if("P".equals(minimumData)){
				sqlQuery 	= "SELECT A.PATIENT_CLASS CODE,A.SHORT_DESC DESCRIPTION,DECODE(B.APPLIED_CODE,NULL,'N','Y') APPLIED_YN FROM (SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS!='XT') A LEFT JOIN OR_MDS_DIAGNOSIS_MAND B ON A.PATIENT_CLASS = B.APPLIED_CODE AND B.MINUMUM_DATA_TYPE='P' AND B.TERM_SET_ID=? ORDER BY A.SHORT_DESC";
			}
			pstmt		= connection.prepareStatement(sqlQuery ) ;
			pstmt.setString( 1, termsetId);
			resultSet  = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[3];
				record[0] = resultSet.getString( "CODE" )  ;
				record[1] = resultSet.getString( "DESCRIPTION" )  ;
				record[2] = resultSet.getString( "APPLIED_YN" )  ;
				ResultDetails.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}

		return ResultDetails;
	}
}