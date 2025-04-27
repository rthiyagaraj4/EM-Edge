/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	           Edit History        	Name        		Rev.Date		  Rev.Name		     Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/09/2023	  28906	   Ranjith P R		25/07/2023		RAMESH G		ML-MMOH-CRF-1846.1
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
//28906 starts
package eCA;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import eCA.Common.CaAdapter;
import webbeans.eCommon.ConnectionManager;

public class PhenotypeDetailsBean extends CaAdapter implements Serializable {
	
public ArrayList getPhenotypeDetails(Properties properties,String locale,String patient_id) throws SQLException{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList details				= new ArrayList();
	try
	{	
		connection				= ConnectionManager.getConnection(properties) ;
	    pstmt = connection.prepareStatement("SELECT  TYPE,pheno_type_code,description,result_date from (SELECT 'RH Phenotype' TYPE,A.RH_PHENO_TYPE_CODE PHENO_TYPE_CODE, B.RESULT_COMMENT DESCRIPTION ,A.PHENO_TYPE_REPORTED_DATE RESULT_DATE FROM BT_PATIENT_BLGRP_RH_ANT A, RL_RESULT_COMMENT_CODE B WHERE A.RH_PHENO_TYPE_CODE=B.RESULT_COMMENT_CODE AND A.PATIENT_ID=? UNION SELECT 'RBC Phenotype' TYPE,A.RBC_PHENOTYPE_CODE PHENO_TYPE_CODE,B.LONG_DESC DESCRIPTION,A.LAST_REPORTED_DATE RESULT_DATE FROM BT_PATIENT_RBC_PHENOTYPE_VW A , BT_RBC_PHENOTYPE_CODE B WHERE A. RBC_PHENOTYPE_CODE =B.RBC_PHENOTYPE_CODE AND A.PATIENT_ID=? ) order by result_date desc ");
    	pstmt.setString(1, patient_id);
    	pstmt.setString(2, patient_id);
    	
    	resultSet = pstmt.executeQuery() ;

		if ( resultSet != null ){
			HashMap<String,String>  resultMap=null;
			while(resultSet.next()){
				resultMap= new HashMap<String,String>();
				
				resultMap.put("TYPE",resultSet.getString("TYPE")==null?"":resultSet.getString("TYPE"));
				resultMap.put("PHENOTYPE_CODE",resultSet.getString("PHENO_TYPE_CODE")==null?"":resultSet.getString("PHENO_TYPE_CODE"));
				resultMap.put("PHENOTYPE_DESCRIPTION", resultSet.getString("DESCRIPTION")==null?"":resultSet.getString("DESCRIPTION"));
				resultMap.put("RESULT_DATE", resultSet.getString("RESULT_DATE")==null?"":resultSet.getString("RESULT_DATE"));
				
				details.add(resultMap);
				//24094 ends
	
			}		
	}
	}
	catch(Exception e){
		e.printStackTrace();		
	}
		finally{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection!=null)connection.close();
			
	}
return details ;

}
}
	
//28906 ends

