/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
01/03/2013	IN035924	  Karthi L	 	CA View chart summary “RESULT WIDGET” should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)
11/03/2013	IN038508 	Karthi L		Past Encounter -> No. of Encounter is entered as 1->But in 2nd Encounter the 1st Encounter Details are not displayed
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
03/03/2014	IN047204		Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
15/05/2014	IN047205		Karthi L		16/05/2014		Ramesh			Changes to clinical event history and chart summary view - to provide link to the scanned document in clinical views
10/02/2015	IN048463		Karthi L										Bed Side Referral Status
24/05/2016	IN055439		Karthi L										MO_CRF_20102		
-----------------------------------------------------------------------------------------------
*/

package eCA;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
//import javax.naming.* ;
//import java.text.SimpleDateFormat;
import webbeans.eCommon.*;
import eCommon.Common.*;
import com.ehis.util.*;

public class CAEncounterList implements Serializable // modified for IN048463
{
	public CAEncounterList()
	{
	}
	
	public HashMap getPatEncounterList(String patientId,String facilityId,String contentId)
	{
		Connection con = null;
		
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int noOfEncounters = 0;
		String scope_display = "";
		
		ArrayList encounterList = new ArrayList();
		HashMap encHashMap = new HashMap();
		try
		{		
			con = ConnectionManager.getConnection();
			String sqlQry2= " SELECT NO_ENC_DISPLAY, DISPLAY_SCOPE_IND FROM CA_CHART_SUMM_CONTENT WHERE CONTENT_ID = ? ";
			pstmt = con.prepareStatement(sqlQry2);
			pstmt.setString(1, contentId);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				noOfEncounters = resultSet.getInt(1);
				scope_display = resultSet.getString(2);
				encHashMap.put("SCOPE_DISP", scope_display);
				encHashMap.put("NO_OF_DAYS", noOfEncounters);
			}
			
			String sqlQry1= "SELECT ENCOUNTER_ID FROM  (SELECT * FROM PR_ENCOUNTER WHERE PATIENT_ID = ? AND FACILITY_ID = ? ORDER BY VISIT_ADM_DATE_TIME DESC) WHERE ROWNUM <= ?";
		
			noOfEncounters = noOfEncounters + 1; // for the issue IN038508 
			pst = con.prepareStatement(sqlQry1);
			pst.setString(1, patientId);
			pst.setString(2, facilityId);
			pst.setInt(3, noOfEncounters);			
			rs = pst.executeQuery();
			while(rs.next()){
				encounterList.add(rs.getString(1));
			}
			encHashMap.put("ENC_LIST",encounterList);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try{
				rs.close();
				pst.close();
				resultSet.close();
				pstmt.close();
				con.close();
			}catch(Exception ex){
			
			}
		}
		return encHashMap;
	}
	// IN047204 - Start
	public String getExternalDmsLinkYN(String facilty_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  externalLinkYN			= "N";
		try
		{
			connection =ConnectionManager.getConnection();
			pstmt = connection.prepareStatement( "SELECT DMS_EXT_LINK_YN FROM OR_PARAM_BY_FACILITY WHERE OPERATING_FACILITY_ID = ?") ;
			pstmt.setString(1, facilty_id.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				externalLinkYN = resultSet.getString("DMS_EXT_LINK_YN");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return externalLinkYN;	
	}
	public HashMap getExternalLinkParameters(String facilty_id, String patient_id, String encounter_id, String language) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap  paramHashMap		= null;
		
		String sqlQuerry = "SELECT PATIENT_CLASS, TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') VISIT_ADM_DATE,  OP_EPISODE_VISIT_NUM,   ATTEND_PRACTITIONER_ID, ASSIGN_CARE_LOCN_TYPE, ASSIGN_CARE_LOCN_CODE, CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,?,'1') ELSE OP_GET_DESC.OP_CLINIC(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,?,'1') END LOCATION_DESC FROM PR_ENCOUNTER WHERE FACILITY_ID = ? AND PATIENT_ID = ? AND ENCOUNTER_ID = ?";
		try
		{
			paramHashMap = new HashMap();
			connection =ConnectionManager.getConnection();
			
			pstmt = connection.prepareStatement(sqlQuerry) ;
			pstmt.setString(1, language);
			pstmt.setString(2, language);
			pstmt.setString(3, facilty_id.trim());
			pstmt.setString(4, patient_id);
			pstmt.setString(5, encounter_id);
			
			resultSet = pstmt.executeQuery() ;
			
			if(resultSet.next())
			{ 
				String LOCN_CODE	= resultSet.getString("ASSIGN_CARE_LOCN_CODE")==null?"":resultSet.getString("ASSIGN_CARE_LOCN_CODE");
				String LOCN_TYPE	= resultSet.getString("ASSIGN_CARE_LOCN_TYPE")==null?"":resultSet.getString("ASSIGN_CARE_LOCN_TYPE");
				String LOC_DESC		= resultSet.getString("LOCATION_DESC")==null?"":resultSet.getString("LOCATION_DESC");String VISIT_ID		= resultSet.getString("OP_EPISODE_VISIT_NUM")==null?"":resultSet.getString("OP_EPISODE_VISIT_NUM");
				String PHYSICIAN_ID	= resultSet.getString("ATTEND_PRACTITIONER_ID")==null?"":resultSet.getString("ATTEND_PRACTITIONER_ID");
				String EPISODE_TYPE	= resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS");
				String ENCNTR_DATE	= resultSet.getString("VISIT_ADM_DATE")==null?"":resultSet.getString("VISIT_ADM_DATE");
				ENCNTR_DATE = DateUtils.convertDate(ENCNTR_DATE,"DMYHM","en",language);
				
				paramHashMap.put("P_LOCN_CODE",LOCN_CODE);
				paramHashMap.put("P_LOCN_TYPE",LOCN_TYPE);
				paramHashMap.put("P_VISIT_ID",VISIT_ID);
				paramHashMap.put("P_LOC_DESC",LOC_DESC);
				paramHashMap.put("P_PHYSICIAN_ID",PHYSICIAN_ID);
				paramHashMap.put("P_EPISODE_TYPE",EPISODE_TYPE);
				paramHashMap.put("P_ENCNTR_DATE",ENCNTR_DATE);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();

		}
		
		return paramHashMap;	
	}	
		
	// IN047204 - End
	//Bru-HIMS-CRF-195.3 - IN047205 - Start
	public ArrayList getExternalLinkdata(String hist_rec_type, String contr_sys_id, String accession_num, String event_code) throws Exception {
		ArrayList externalListData  = null;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		CAExternalLinkDataDTO linkDataObj = null;
		String sqlQuerry = "SELECT EXT_IMAGE_OBJ_ID, EXT_IMAGE_APPL_ID, EXT_IMAGE_SOURCE, SRCE_DOC_REF_NO, SRCE_DOC_REF_LINE_NO FROM CR_ENCNTR_DTL_EXT_APPL WHERE HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ?";
		try
		{
			
			connection =ConnectionManager.getConnection();
			
			pstmt = connection.prepareStatement(sqlQuerry) ;
			pstmt.setString(1, hist_rec_type);
			pstmt.setString(2, contr_sys_id);
			pstmt.setString(3, accession_num);
			pstmt.setString(4, event_code);
			
			resultSet = pstmt.executeQuery() ;
			externalListData = new ArrayList();
			while(resultSet.next())
			{ 
				linkDataObj = new CAExternalLinkDataDTO();
				linkDataObj.setExt_image_obj_id(resultSet.getString("EXT_IMAGE_OBJ_ID")==null?"":resultSet.getString("EXT_IMAGE_OBJ_ID"));
				linkDataObj.setExt_image_appl_id(resultSet.getString("EXT_IMAGE_APPL_ID")==null?"":resultSet.getString("EXT_IMAGE_APPL_ID"));
				linkDataObj.setExt_image_source(resultSet.getString("EXT_IMAGE_SOURCE")==null?"":resultSet.getString("EXT_IMAGE_SOURCE"));
				linkDataObj.setSrce_doc_ref_no(resultSet.getString("SRCE_DOC_REF_NO")==null?"":resultSet.getString("SRCE_DOC_REF_NO"));
				linkDataObj.setSrce_doc_ref_line_no(resultSet.getString("SRCE_DOC_REF_LINE_NO")==null?"":resultSet.getString("SRCE_DOC_REF_LINE_NO"));
				externalListData.add(linkDataObj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();

		}
		return externalListData;
	}
	//Bru-HIMS-CRF-195.3 - IN047205 - End
	// MO_CRF_20102[IN055439] - Start
	public String getTextFormatDefaultYN() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  text_format_default_yn			= "N";
		try
		{
			connection =ConnectionManager.getConnection();
			pstmt = connection.prepareStatement( "SELECT TEXT_FORMAT_DEFAULT_YN FROM CA_NOTE_PARAM") ;
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{ 
				text_format_default_yn = resultSet.getString("text_format_default_yn");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return text_format_default_yn;	
	}
	// MO_CRF_20102[IN055439] - End
}
