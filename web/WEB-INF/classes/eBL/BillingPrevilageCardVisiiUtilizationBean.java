/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

public class BillingPrevilageCardVisiiUtilizationBean extends  BlAdapter implements Serializable{
	
	protected String 		PatientId											= 	"";
	protected String 		Clinic												= 	"";
	protected String 		VisitType											=	"";
	protected String 		VisitCount											=	"";
	protected String 		VisitAvailed										=	"";
	protected String 		ClinicCode											= 	"";
	protected String 		VisitTypeCode										=	"";
	protected String 		OpVistsAllowed										=	"";
	protected String 		OpVistsAvailed										=	"";
	
	protected HashMap 		ClinicCodeMap										=	null;
	protected HashMap 		ClinicDescMap										=	null;
	protected HashMap 		VisitCodeMap										=	null;
	protected HashMap 		VisitDescMap										=	null;
	/*
	 * All the Column name and table name used in the query is referred as constants
	 */
	 /*
	public static final	String 	  BL_HCARD_SUBS_VISIT_DTL_TABLE					=  "BL_HCARD_SUBS_VISIT_DTL";  
	public static final	String 	  HCARD_SEQ_NO									=  "HCARD_SEQ_NO";  
	public static final String    CLINIC_CODE									=  "CLINIC_CODE";     
	public static final String    VISIT_TYPE_CODE 								=  "CARD_TYPE_CODE";   
	public static final String    NO_OF_OP_VISITS_ALLOWED						=  "NO_OF_OP_VISITS_ALLOWED";     
	public static final String    NO_OF_OP_VISITS_UTILIZED 						=  "NO_OF_OP_VISITS_UTILIZED";   
	public static final String    ADDED_FACILITY_ID								=  "ADDED_FACILITY_ID";
	*/   //commented checkstyle	
	
	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return PatientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		PatientId = patientId;
	}
	/**
	 * @return the clinic
	 */
	public String getClinic() {
		return Clinic;
	}
	/**
	 * @param clinic the clinic to set
	 */
	public void setClinic(String clinic) {
		Clinic = clinic;
	}
	/**
	 * @return the visitType
	 */
	public String getVisitType() {
		return VisitType;
	}
	/**
	 * @param visitType the visitType to set
	 */
	public void setVisitType(String visitType) {
		VisitType = visitType;
	}
	/**
	 * @return the visitCountT
	 */
	public String getVisitCount() {
		return VisitCount;
	}
	/**
	 * @param visitCountT the visitCountT to set
	 */
	public void setVisitCount(String visitCount) {
		VisitCount = visitCount;
	}
	/**
	 * @return the visitAvailed
	 */
	public String getVisitAvailed() {
		return VisitAvailed;
	}
	/**
	 * @param visitAvailed the visitAvailed to set
	 */
	public void setVisitAvailed(String visitAvailed) {
		VisitAvailed = visitAvailed;
	}
	
	
	
	
	/**
	 * @return the clinicCode
	 */
	public String getClinicCode() {
		return ClinicCode;
	}
	/**
	 * @param clinicCode the clinicCode to set
	 */
	public void setClinicCode(String clinicCode) {
		ClinicCode = clinicCode;
	}
	/**
	 * @return the visitTypeCode
	 */
	public String getVisitTypeCode() {
		return VisitTypeCode;
	}
	/**
	 * @param visitTypeCode the visitTypeCode to set
	 */
	public void setVisitTypeCode(String visitTypeCode) {
		VisitTypeCode = visitTypeCode;
	}   
	
	
	
	/**
	 * @return the opVistsAllowed
	 */
	public String getOpVistsAllowed() {
		return OpVistsAllowed;
	}

	/**
	 * @param opVistsAllowed the opVistsAllowed to set
	 */
	public void setOpVistsAllowed(String opVistsAllowed) {
		OpVistsAllowed = opVistsAllowed;
	}

	/**
	 * @return the opVistsAvailed
	 */
	public String getOpVistsAvailed() {
		return OpVistsAvailed;
	}

	/**
	 * @param opVistsAvailed the opVistsAvailed to set
	 */
	public void setOpVistsAvailed(String opVistsAvailed) {
		OpVistsAvailed = opVistsAvailed;
	}

	
	
	/**
	 * clears the bean value
	 */
	public void clearBean()
	{
		PatientId											= 	"";             
		Clinic												= 	"";             
		VisitType											=	"";             
		VisitCount											=	"";             
		VisitAvailed										=	"";             
		ClinicCode											= 	"";             
		VisitTypeCode										=	"";             
		                                                                                                                    
		ClinicCodeMap										=	null;           
		ClinicDescMap										=	null;           
		VisitCodeMap										=	null;           
		VisitDescMap										=	null;           
   }
	
	public ArrayList getVisitUtilizationDetails(String hCardSeqNo,String added_facility_id,String locale) throws Exception 
	{
		
		System.out.println("getVisitUtilizationDetails INSIDE:::");
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			visitUtilizationDetailsResultSet				= 	null;		
		StringBuffer 		visitUtilizationDetailsSql						=	new StringBuffer();	
		//String 				languageId										=	"en";
		//String 				patientId										= 	""; //commented checkstyle	
		//String				sql												=	""; //commented checkstyle	
		String				blRepositoryKey									=	"Billing_Previlage_Visit_Utilize_SQL";
		//String				clinicCode										=	""; //commented checkstyle	
		String				visitDesc										=	"";
		ArrayList 			visitUtilizationDetailsList						=	null;
		String[] 			strAr											= 	null;
		
		try
		{
			connection = getConnection();
			visitUtilizationDetailsList	= new ArrayList();
		
			visitUtilizationDetailsSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			visitUtilizationDetailsSql.append(" '"+added_facility_id+"' AND  HCARD_SEQ_NO = '"+hCardSeqNo+"' ");
			
			System.out.println("getVisitUtilizationDetails SELECT QUERY:::"+visitUtilizationDetailsSql); 
			
			preparedstatement=connection.prepareStatement(visitUtilizationDetailsSql.toString());	
			visitUtilizationDetailsResultSet = preparedstatement.executeQuery();
			while (visitUtilizationDetailsResultSet.next())
			{
				
				visitDesc = visitUtilizationDetailsResultSet.getString(1)!=null && visitUtilizationDetailsResultSet.getString(1).startsWith("*") ? visitUtilizationDetailsResultSet.getString(1) : getVisitDetails(visitUtilizationDetailsResultSet.getString(1),added_facility_id,locale);
				if(visitDesc!=null && visitDesc.length()>0) 
				{
					strAr		=   new String[6];
					strAr[0]	= visitUtilizationDetailsResultSet.getString(2)!=null && visitUtilizationDetailsResultSet.getString(2).startsWith("*") ? visitUtilizationDetailsResultSet.getString(2) : getClinicCodeDetails(visitUtilizationDetailsResultSet.getString(2),added_facility_id,locale);
					strAr[1]	= visitDesc;
					strAr[2]	= visitUtilizationDetailsResultSet.getString(3);
					strAr[3]	= visitUtilizationDetailsResultSet.getString(4);
					strAr[4]	= visitUtilizationDetailsResultSet.getString(1);
					strAr[5]	= visitUtilizationDetailsResultSet.getString(2);
					visitUtilizationDetailsList.add(strAr);
				}
				
			}
			
				
		}
		catch(Exception e)
		{
			System.out.println("Exception in getVisitUtilizationDetails in BillingPrevilageCardVisiiUtilizationBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(visitUtilizationDetailsResultSet!=null) visitUtilizationDetailsResultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return visitUtilizationDetailsList;  
	}	
	
	public String getClinicCodeDetails(String clinicCode,String added_facility_id,String locale) throws Exception 
	{
		System.out.println("getClinicCodeDetails INSIDE");
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			clinicCodeDetailsResultSet						= 	null;		
		StringBuffer 		clinicCodeDetailsSql							=	new StringBuffer();	
		//String 				languageId										=	"en";
		//String 				patientId										= 	""; //commented checkstyle	
		//String				sql												=	""; //commented checkstyle	
		String				blRepositoryKey									=	"Billing_Previlage_Clinic_Detail_SQL";
		String				clinicDesc										=	"";
		ArrayList 			PatientDetailsList								=	null;
		//String[] 			strAr											= 	null; //commented checkstyle	

		
		try
		{
			connection = getConnection();
			ClinicCodeMap = new HashMap();
			PatientDetailsList	= new ArrayList();
			clinicCodeDetailsSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			clinicCodeDetailsSql.append(" '"+locale+"' AND  CLINIC_CODE =  '"+clinicCode+"' ");
				
			

			System.out.println("getClinicCodeDetails SELECT QUERY:::"+clinicCodeDetailsSql);
			
			preparedstatement=connection.prepareStatement(clinicCodeDetailsSql.toString());	
			clinicCodeDetailsResultSet = preparedstatement.executeQuery();
			while (clinicCodeDetailsResultSet.next())
			{
				//this.ClinicDescMap.put(clinicCodeDetailsResultSet.getString(1), clinicCodeDetailsResultSet.getString(2));
				clinicDesc	= clinicCodeDetailsResultSet.getString(2);
				
			}

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getClinicCodeDetails in BillingPrevilageCardVisiiUtilizationBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(clinicCodeDetailsResultSet!=null) clinicCodeDetailsResultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return clinicDesc;
		
		
	}	

	public String getVisitDetails(String visitTypecode,String added_facility_id,String locale) throws Exception 
	{
		System.out.println("getVisitDetails INSIDE");
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			visitDetailsResultSet							= 	null;		
		StringBuffer 		visitDetailsSql									=	new StringBuffer();	
		//String 				languageId										=	"en";
		//String 				patientId										= 	""; //commented checkstyle	
		//String				sql												=	""; //commented checkstyle	
		String				blRepositoryKey									=	"Billing_Previlage_Clinic_Visit_Detail_SQL";
		String				VistDesc										=	null;
		ArrayList 			PatientDetailsList								=	null;
		try
		{
			
			connection 			= 	getConnection();
			VisitCodeMap		=	new HashMap();
			VisitDescMap		=	new HashMap();;
			PatientDetailsList	= new ArrayList();
			visitDetailsSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			visitDetailsSql.append(" '"+locale+"' AND  A.VISIT_TYPE_CODE =  '"+visitTypecode+"' ");
				
			

			System.out.println("getVisitDetails SELECT QUERY:::"+visitDetailsSql);
			
			preparedstatement=connection.prepareStatement(visitDetailsSql.toString());	
			visitDetailsResultSet = preparedstatement.executeQuery();
			if (visitDetailsResultSet.next())
			{
				
				//this.VisitDescMap.put(visitDetailsResultSet.getString(1), visitDetailsResultSet.getString(2));
				VistDesc = visitDetailsResultSet.getString(2);
				System.out.println("VistDesc::::: "+VistDesc);
			}
			

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getVisitDetails in BillingPrevilageCardVisiiUtilizationBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(visitDetailsResultSet!=null) visitDetailsResultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return VistDesc;
		
	}	
	
	
	
	public void getOpVisitUtilizationStatus(String patientId,String hCardSeqNo,String added_facility_id,String locale) throws Exception 
	{
		
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		//PreparedStatement 	preparedstatement1 							= 	null; //commented checkstyle	
		//ResultSet 			resultSet1									= 	null; //commented checkstyle	
		ArrayList			preApprovalRequestDetailsList				=   null;
		//String[]			arr											= 	null; //commented checkstyle	
		String				blRepositoryKey								=	"";
		String				pId											=	"@patientId";
		String				hId											=	"@hcardSeqNo";
		String				pId1										=	"@patientId1";
		String				hId1										=	"@hcardSeqNo1";
	
		
		
		try
		{
			System.out.println("In getOpVisitUtilizationStatus.:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			preApprovalRequestDetailsList = new ArrayList();
			blRepositoryKey = "Billing_Previlage_OP_Visit_Utilization_Details_SQL";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			sql.replace(sql.indexOf(pId),sql.indexOf(pId)+pId.length(),  patientId);
			sql.replace(sql.indexOf(hId),sql.indexOf(hId)+hId.length(),  hCardSeqNo);
			sql.replace(sql.indexOf(pId1),sql.indexOf(pId1)+pId1.length(),  patientId);
			sql.replace(sql.indexOf(hId1),sql.indexOf(hId1)+pId1.length(),  hCardSeqNo);
			System.out.println("AFTER REPLACE SQL in getOpVisitUtilizationStatus::::blRepositoryKey:: "+blRepositoryKey+" :::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				setOpVistsAllowed(resultSet.getString("NO_OF_OP_VISITS_ALLOWED"));
				setOpVistsAvailed(resultSet.getString("NO_OF_OP_VISITS_UTILIZED"));
			}
				System.out.println("recordApprovalPatientdataList SIZE:::::: "+preApprovalRequestDetailsList.size());
			
		}catch(Exception e){
			System.out.println("Exception in getOpVisitUtilizationStatus in BillingPrevilageCardVisiiUtilizationBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		
		
	}



		
}

