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


public  class BTPatientDetails  implements Serializable {


	String strSex="";
	String strPatientId="";
	String strSourceType="";
	String strSourceCode="";
	String strSourceDesc="";
	String strEpisodeType="";	
	String strFacilityName="";
	String strEpisodeNo="";
	String strTfrNo="";
	String strConsultantCode="";

	String strSpecimen_no="";
	String strFacilityId="";
	String strDob="";
	String strNaltyCode="";
	String strNaltyName="";
	String strActualDBYN="";
	String strRaceCode="";
	String strRaceDesc="";
	String strActPatientId="";
	String strRefCode="";
	String strRefDesc="";
	String strLocation="";
	String strRoomNo="";
	String strBedNo="";
	String strCurPhysId="";
	String strCurPhysName="";
	String strPhysicianName="";
	String strPhysicianId="";
	String strYear="";
	String strMonth="";
	String strDate="";
	String	strBloodGp="";
	String	strRehusesCode="";
	String strRhPhenoType="";

	//Connection connection=null;


	public BTPatientDetails() {
		
	}

public void getInOutPatientDetails(String strPatientId,Connection conn)
	{ 
 PreparedStatement pstmt=null;
 ResultSet resultSet=null;
 try{

		 pstmt	= conn.prepareStatement( "SELECT  SEX SEX1,DATE_OF_BIRTH DOB1, NATIONALITY_CODE NATIONALITY_CODE1 FROM   MP_PATIENT_MAST  WHERE  strPatientId = ?");

	
					pstmt.setString(1, ( strPatientId==null?"":strPatientId));
					resultSet	= pstmt.executeQuery() ;
					
					strSex=resultSet.getString("SEX1");
					strDob=resultSet.getString("DOB1");
					strNaltyCode=resultSet.getString("NATIONALITY_CODE1");
					pstmt.close();
					resultSet.close(); //Common-ICN-0045

		
 }
 catch(Exception e)
		{}
					closeData(pstmt,resultSet);
					
	}

public void getReferalDetails(Connection conn)
	{

	 PreparedStatement pstmt=null;
	 ResultSet resultSet=null;
 try{
	    pstmt		= conn.prepareStatement( "SELECT A.SEX SEX1,A.DATE_OF_BIRTH DOB1, NVL(A.ACTUAL_DOB_YN, 'N') ACTUAL_DOB_YN1,A.NATIONALITY_CODE NATIONALITY_CODE1, A.RACE_CODE RACE_CODE1, A.ACTUAL_strPatientId ACTUAL_strPatientId1,A.LOCATION LOCATION1, A.REF_strSourceCode REF_strSourceCode1,A.REF_SOURCE_DESC REF_SOURCE_DESC1 FROM   RL_PATIENT_MAST A,RL_REFERRAL B  WHERE  A.strPatientId = ?  AND B.REFERRAL_CODE =A.REFERRAL_CODE") ;
		pstmt.setString(1, ( strPatientId==null?"":strPatientId));					
		resultSet	= pstmt.executeQuery() ;
					strSex=resultSet.getString("SEX1");
					strDob=resultSet.getString("DOB1");
					strActualDBYN=resultSet.getString("ACTUAL_DOB_YN1");
					strRaceCode=resultSet.getString("RACE_CODE1");
					strActPatientId=resultSet.getString("ACTUAL_strPatientId1");
					strNaltyCode=resultSet.getString("NATIONALITY_CODE1");
					strRefCode=resultSet.getString("REF_strSourceCode1");
					strRefDesc=resultSet.getString("REF_SOURCE_DESC1");
					strLocation=resultSet.getString("LOCATION1");
				resultSet.close(); //Common-ICN-0045
 }
 catch(Exception ee)
		{
		}
closeData(pstmt,resultSet);
	}
public void getSourceDesc(Connection conn) 
	{

	 PreparedStatement pstmt=null;
	 ResultSet resultSet=null;
	 try{
	     if  (strSourceType.equals("E"))  	
		{
		   pstmt=conn.prepareStatement("SELECT SHORT_DESC SHORT_DESC1 FROM RL_REFERRAL WHERE REFERRAL_CODE = ?");			  		
		   pstmt.setString(1, ( strSourceCode==null?"":strSourceCode));	

		}	
	      else if (strSourceType.equals("C")) 
		{
		  pstmt=conn.prepareStatement("SELECT SHORT_DESC SHORT_DESC1 FROM OP_CLINIC WHERE facility_id = ?    AND  CLINIC_CODE = ?");			  				 
			pstmt.setString(1, ( strFacilityId==null?"":strFacilityId));
			pstmt.setString(2, ( strSourceCode==null?"":strSourceCode));	

		}
	      else if (strSourceType.equals("W")) 
		{
		   		pstmt=conn.prepareStatement("SELECT SHORT_DESC SHORT_DESC1 FROM IP_WARD    WHERE facility_id = ?    AND ward_code = ?");			  		
    			pstmt.setString(1, ( strFacilityId==null?"":strFacilityId));
				pstmt.setString(2, ( strSourceCode==null?"":strSourceCode));	
		}
			    
		 resultSet	= pstmt.executeQuery();
		 strSourceDesc=resultSet.getString("SHORT_DESC1");
		 resultSet.close(); //Common-ICN-0045
	 }
	 catch(Exception ee)
		{}

	 closeData(pstmt,resultSet);
	}


public void getIPOPDtl(Connection conn) 
	{

	 PreparedStatement pstmt=null;
	  ResultSet resultSet=null;
try
		{
 if (strEpisodeType.equals("I")) 
		{
  	pstmt=conn.prepareStatement("SELECT CUR_ROOM_NUM CUR_ROOM_NUM1,CUR_BED_NUM CUR_BED_NUM1,CUR_PHYSICIAN_ID CUR_PHYSICIAN_ID1 FROM IP_EPISODE WHERE facility_id = ?    AND strPatientId = ?  AND EPISODE_ID = ? ");			  				 
	pstmt.setString(1, ( strFacilityId==null?"":strFacilityId));
	pstmt.setString(2, ( strPatientId==null?"":strPatientId));
	pstmt.setString(3, ( strEpisodeNo==null?"":strEpisodeNo));
	resultSet=pstmt.executeQuery();
	strRoomNo=resultSet.getString("CUR_ROOM_NUM1");
	strBedNo=resultSet.getString("CUR_BED_NUM1");
	strCurPhysId=resultSet.getString("CUR_PHYSICIAN_ID1");     
		}
  else if (strEpisodeType.equals("O")) 
		{
  	pstmt=conn.prepareStatement("SELECT PHYSICIAN_ID PHYSICIAN_ID1 FROM OP_VISIT  WHERE  facility_id = ?	 AND strPatientId = ?   AND EPISODE_ID = ?   AND VISIT_ID = ? ");			  				 
	pstmt.setString(1,(strFacilityId==null?"":strFacilityId));
	pstmt.setString(2,(strPatientId==null?"":strPatientId));
	pstmt.setString(3,(strEpisodeNo==null?"":strEpisodeNo));	
	pstmt.setString(4,(strTfrNo==null?"":strTfrNo));
	resultSet=pstmt.executeQuery();
	strCurPhysId=resultSet.getString("PHYSICIAN_ID1");
	}
	resultSet.close(); //Common-ICN-0045
	 }
	 catch(Exception ee)
		{
		}
		closeData(pstmt,resultSet);

	}

public void get_physician_name(Connection conn)
	{

PreparedStatement pstmt=null;
	  ResultSet resultSet=null;
try		{

if (strEpisodeType.equals("I") || strEpisodeType.equals("O")) 
		{
	pstmt=conn.prepareStatement("SELECT SHORT_NAME  SHORT_NAME1  FROM SY_PHYSICIAN_MAST  WHERE facility_id = ?  AND PHYSICIAN_ID = ?");			  				 
	pstmt.setString(1,( strFacilityId==null?"":strFacilityId));
	pstmt.setString(2,( strPhysicianId==null?"":strPhysicianId));
		}
  else
  {
	   pstmt=conn.prepareStatement("SELECT SHORT_NAME SHORT_NAME1 FROM RL_CONSULTANTS WHERE REF_CONSULTANT_ID = ?");
	   pstmt.setString(1,(strPhysicianId==null?"":strPhysicianId));
	}
	 resultSet=pstmt.executeQuery();
	  strPhysicianName=resultSet.getString("SHORT_NAME1");	 
	  resultSet.close(); //Common-ICN-0045
	  	 }
	 catch(Exception ee)
		{	}

closeData(pstmt,resultSet);
	}

public void getOrderFacilityName(Connection conn)
	{

	PreparedStatement pstmt=null;
	  ResultSet resultSet=null;
	try
		{
		pstmt=conn.prepareStatement(" SELECT FACILITY_NAME FACILITY_NAME1 FROM SM_FACILITY_PARAM  WHERE facility_id = ?");			  				 
		pstmt.setString(1,strFacilityId);
		resultSet=pstmt.executeQuery();
		strFacilityName=resultSet.getString("FACILITY_NAME1");	
		resultSet.close(); //Common-ICN-0045
		 }
	 catch(Exception ee)
		{
		}
closeData(pstmt,resultSet);
	}

private void closeData(PreparedStatement pstmt,ResultSet rslt)
		{

	try{
		if(pstmt!=null) pstmt.close();
		if(rslt!=null) rslt.close();
		pstmt=null;
		rslt=null;
	}
	catch(Exception ee)	{}

		}


public void getPatientDetails(String specimen_no, Properties properties) throws Exception 
	{
		
			PreparedStatement pstmt 	= null;
			PreparedStatement pstmt1 	= null;
			ResultSet resultSet 		= null;
			Connection connection=null;
			try{


				connection		= ConnectionManager.getConnection(properties) ;
				pstmt			= connection.prepareStatement( "SELECT strPatientId strPatientId1,TFR_VISIT_NO TFR_VISIT_NO1,strEpisodeNo strEpisodeNo1,strSourceCode strSourceCode1,strSourceType strSourceType1,strEpisodeType strEpisodeType1,CONSULTANT_CODE1 FROM RL_REQUEST_HEADER WHERE SPECIMEN_NO = ?");

	
					pstmt.setString(1, ( specimen_no==null?"":specimen_no));
					resultSet	= pstmt.executeQuery() ;
					
					strPatientId=resultSet.getString("strPatientId1");
					strSourceType=resultSet.getString("strSourceType1");
					strSourceCode=resultSet.getString("strSourceCode1");
					strEpisodeNo=resultSet.getString("strEpisodeNo1");
					strTfrNo=resultSet.getString("TFR_VISIT_NO1");
					strEpisodeType=resultSet.getString("strEpisodeType1");
					strConsultantCode=resultSet.getString("CONSULTANT_CODE1");
					

				if(strEpisodeType.equals("O") ||strEpisodeType.equals("I") ||strEpisodeType.equals("H"))
				{
				 getIPOPDtl(connection);
				 }
				 else
				{
				getReferalDetails(connection);
				}

		try
				{
		pstmt1=connection.prepareStatement( "SELECT NATIONALITY NATIONALITY1	FROM MP_COUNTRY_HIS_VW	WHERE COUNTRY_CODE = ?");
		pstmt1.setString(1,strNaltyCode);
		resultSet=pstmt1.executeQuery();
		strNaltyName=resultSet.getString("NATIONALITY1");

				}
				catch(Exception e1)
				{
					strNaltyName="";
				}

		
				getSourceDesc(connection);


				resultSet.close();
					pstmt1.close(); //Common-ICN-0045
				}catch ( Exception e )	{
					System.err.println( "Error loading values from database When Populating requirement" +e) ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					 resultSet.close();
					pstmt.close();
					if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
				}
			closeData(pstmt,resultSet);

	}	 


}
