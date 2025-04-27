/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT;



import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;

public  class BTQueryDetails  implements Serializable {


	public BTQueryDetails() {
		
	}



/* To populate the Order CAtegorys ,except CS */


public ArrayList getAntiBodyDetails(String patient_id,String locale, Properties properties) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
         	ArrayList antiBodyDetails  = new ArrayList() ;
			try{


				connection		= ConnectionManager.getConnection(properties) ;
				pstmt			= connection.prepareStatement( "SELECT A.ANTIBODY_CODE ANTIBODY_CODE1,	A.SHORT_DESC SHORT_DESC1,to_Char(B.LAST_REPORTED_DATE,'dd/mm/yyyy hh24:mi')  LAST_DATE1 FROM BT_ANTIBODY_CODE_MAST_LANG_VW A,BT_PATIENT_ANTIBODY B	WHERE A.ANTIBODY_CODE=B.ANTIBODY_CODE 	AND B.PATIENT_ID=? and A.Language_id=?");

					pstmt.setString(1, ( patient_id==null?"":patient_id));
					pstmt.setString(2, ( locale==null?"":locale));
					resultSet	= pstmt.executeQuery() ;
					while(resultSet!= null && resultSet.next())
					{
						ArrayList antibody = new ArrayList();
						antibody.add( resultSet.getString( "ANTIBODY_CODE1" )) ;
						antibody.add( resultSet.getString( "SHORT_DESC1" )) ;						
						antibody.add(DateUtils.convertDate(resultSet.getString("LAST_DATE1"),"DMYHM","en",locale));
						
						antiBodyDetails.add(antibody);
						
					}
				}catch ( Exception e )	{
					System.err.println( "Error loading values from database When Populating AntiBody" +e) ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					 resultSet.close();
					pstmt.close();
					if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
				}
				return antiBodyDetails;
	}	 

public ArrayList getRequirementDetails(String patient_id,String locale, Properties properties) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
         	ArrayList requirementDetails  = new ArrayList() ;
			try{


				connection		= ConnectionManager.getConnection(properties) ;
				pstmt			= connection.prepareStatement( "SELECT A.REQUIREMENT_CODE REQUIREMENT_CODE1,A.SHORT_DESC SHORT_DESC1 FROM BT_TRANSFUSE_REQ_LANG_VW A , BT_PATIENT_REQUIREMENT B WHERE A.REQUIREMENT_CODE = B.REQUIREMENT_CODE AND B.PATIENT_ID =?  AND A.LANGUAGE_ID = ?");

					pstmt.setString(1, ( patient_id==null?"":patient_id));
					pstmt.setString(2, ( locale==null?"":locale));
					resultSet	= pstmt.executeQuery() ;
					while(resultSet!= null && resultSet.next())
					{
						ArrayList requirement = new ArrayList();
						requirement.add( resultSet.getString( "REQUIREMENT_CODE1" )) ;
						requirement.add( resultSet.getString( "SHORT_DESC1" )) ;						
						requirementDetails.add(requirement);
						
					}
				}catch ( Exception e )	{
					System.err.println( "Error loading values from database When Populating requirement" +e) ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					 resultSet.close();
					pstmt.close();
					if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
				}
				return requirementDetails;
	}	 

}
