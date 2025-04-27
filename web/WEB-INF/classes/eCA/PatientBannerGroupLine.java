/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
28/03/2014	IN047204			Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
19/03/2015	IN052800		Karthi L											If link image for Histology orderable, from CA, user not able to view the image. No link appear under View.						
20/07/2015	IN052940			Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template if filled up earlier for same patient in template format.					
30/01/2018	IN063931		Prakash C	23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)				
--------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import eOR.Common.* ;
import eCommon.Common.*;
import eCA.Common.CaAdapter;//IN070610
import com.ehis.util.*;
import eOR.Common.OrAdapter;
import webbeans.eCommon.ConnectionManager;
public class  PatientBannerGroupLine extends OrAdapter implements java.io.Serializable
{
	ArrayList recordsLine1 = new ArrayList();
	ArrayList recordsLine2 = new ArrayList();
	ArrayList sortList = new ArrayList();
	HashMap multiHist = new HashMap();
	public CaAdapter adapter = new CaAdapter();//IN070610
	
	public void addToHashMap(String key,String value)
	{
		multiHist.put(key,value);
	}
	public void removeFromHashMap(String key)
	{
		multiHist.remove(key);
	}
	public HashMap returnHashMap()
	{
		return multiHist;
	}
	public boolean ContainsKey(String key)
	{
		if(multiHist.containsKey(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public ArrayList getKeys()
	{
		ArrayList keys = new ArrayList();
		Set mapKeySet = (Set)multiHist.keySet();
		Iterator mapIter = mapKeySet.iterator();		
		while(mapIter.hasNext())
		{
			keys.add((String)mapIter.next());
		}
		return keys;
	}
	public void addRecordstoLine1(String value)
	{
		recordsLine1.add(value);
	}

	public void addRecordstoLine2(String value)
	{
		recordsLine2.add(value);
	}

	public void addRecordsToSortList(String value)
	{
		sortList.add(value);
	}

	public void remRecordsFromLine1(String remVal)
	{
		
		if((recordsLine1.contains(remVal)))
			recordsLine1.remove(remVal);
				
	}
	
	public void remRecordsFromSortList(String remVal)
	{
		
		if((sortList.contains(remVal)))
			sortList.remove(remVal);
				
	}
	
	public ArrayList returnList1()
	{
		return recordsLine1;
	}

	public ArrayList returnList2()
	{
		return recordsLine2;
	}

	public ArrayList returnSortList()
	{
		return sortList;
	}

	public void clearBean()
	{
		recordsLine1 = new ArrayList();
		recordsLine2 = new ArrayList();
		sortList = new ArrayList();
		multiHist.clear();
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
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
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
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return paramHashMap;	
	}	
	// IN047204 - End
	//IN052800 - Start
	public String getOrderIdFromSpecimen(String specimen_no) throws Exception{
		String order_id = "";
		String perf_facility_id = "";
		String fetchQuery = "";
		Connection con = null;
		PreparedStatement prepStat = null;
		ResultSet resultSet =  null;
		
		try {
			fetchQuery =  "SELECT ORDER_ID FROM RL_INTERVAL_TEST_SPECIMENS WHERE SPECIMEN_NO = ?";
			con = ConnectionManager.getConnection();
			prepStat = con.prepareStatement(fetchQuery);
			prepStat.setString(1, specimen_no);
			resultSet = prepStat.executeQuery();
			if(resultSet.next()){
				order_id = resultSet.getString("ORDER_ID");
			}
			if(resultSet != null) resultSet.close();
			if(prepStat != null) prepStat.close();
			if(order_id != null && !order_id.equals("")) {
				fetchQuery = "SELECT PERFORMING_FACILITY_ID FROM OR_ORDER WHERE ORDER_ID = ?";
				prepStat = con.prepareStatement(fetchQuery);
				prepStat.setString(1, order_id);
				resultSet = prepStat.executeQuery();
				if(resultSet.next()){
					perf_facility_id = resultSet.getString("PERFORMING_FACILITY_ID");
				}
			}
		}
		catch(Exception ex){
			System.out.println("231. Error in PatientBannerGroupLine.java ==> " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(prepStat != null) prepStat.close();
			if(con != null) con.close();
		}
		return perf_facility_id;
	}
	//IN052800 - End
	//IN052940 - Start
	public String getCopyPreviousNotesYN(String respId, String languageId, String noteType) throws Exception {
		String copyPreviousNotesYN = "";
		String fetchQuery = "";
		Connection con = null;
		PreparedStatement prepStat = null;
		ResultSet resultSet =  null;
		try{
			fetchQuery = "SELECT (SELECT copy_prev_notes_yn FROM ca_appl_task, ca_note_type a WHERE note_type = b.note_type AND appl_task_id = (SELECT appl_task_id FROM ca_note_group WHERE note_group = a.note_group_id)) ca_disp_copy_prev_notes_yn FROM   CA_NOTE_TYPE_FOR_RESP a, CA_NOTE_TYPE_lang_vw b, SM_RESP C WHERE C.resp_id = ? AND A.note_type = ? AND b.language_id = ? AND c.RESP_ID = A.RESP_ID AND b.NOTE_TYPE = A.NOTE_TYPE AND b.EFF_STATUS = 'E'";
			con = ConnectionManager.getConnection();
			prepStat = con.prepareStatement(fetchQuery);
			prepStat.setString(1, respId);
			prepStat.setString(2, noteType);
			prepStat.setString(3, languageId);
			resultSet = prepStat.executeQuery();
			if(resultSet.next()){
				copyPreviousNotesYN = resultSet.getString("ca_disp_copy_prev_notes_yn");
			}
		}
		catch(Exception ex){
			System.err.println("276. Error in PatientBannerGroupLine.java ==> " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(prepStat != null) prepStat.close();
			if(con != null) con.close();
		}
		return copyPreviousNotesYN;
	}
	//IN052940 - End
	//IN063931 starts
	public String getCopyPreviousSectionYN(String respId, String languageId, String noteType) throws Exception {
		String copyPreviousSectionYN = "";
		String fetchQuery = "";
		Connection con = null;
		PreparedStatement prepStat = null;
		ResultSet resultSet =  null;
		try{
			fetchQuery = "SELECT (SELECT copy_prev_section_yn FROM ca_appl_task, ca_note_type a WHERE note_type = b.note_type AND appl_task_id = (SELECT appl_task_id FROM ca_note_group WHERE note_group = a.note_group_id)) ca_disp_copy_prev_section_yn FROM   CA_NOTE_TYPE_FOR_RESP a, CA_NOTE_TYPE_lang_vw b, SM_RESP C WHERE C.resp_id = ? AND A.note_type = ? AND b.language_id = ? AND c.RESP_ID = A.RESP_ID AND b.NOTE_TYPE = A.NOTE_TYPE AND b.EFF_STATUS = 'E'";
			con = ConnectionManager.getConnection();
			prepStat = con.prepareStatement(fetchQuery);
			prepStat.setString(1, respId);
			prepStat.setString(2, noteType);
			prepStat.setString(3, languageId);
			resultSet = prepStat.executeQuery();
			if(resultSet.next()){
				copyPreviousSectionYN = resultSet.getString("ca_disp_copy_prev_section_yn");
			}
		}
		catch(Exception ex){
			System.err.println("276. Error in PatientBannerGroupLine.java ==> " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(prepStat != null) prepStat.close();
			if(con != null) con.close();
		}
		return copyPreviousSectionYN;
	}//IN063931 ends
}
