/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
26/2/2021	TFS15204		   Ramesh Goli		26/2/2021		Ramesh G			COMMN-ICN-0026
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eCA;

import eCommon.Common.* ;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;
import javax.servlet.jsp.PageContext;
import java.math.*;

import eCA.Common.CaAdapter;
public class CAMenuDetailsBean extends CaAdapter implements Serializable {

//IN066237 starts
	public ArrayList selfNotesCount(String source_id,String desktop_id,String resp_id,String pract_id,String facility_id)throws Exception
	{
		Connection con 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultDetail	= new ArrayList() ;
		
		if(source_id.equals(" ") || source_id.equals("null")) source_id = "";
		if(desktop_id.equals(" ") || desktop_id.equals("null")) desktop_id = "";
		if(resp_id.equals(" ") || resp_id.equals("null")) resp_id = "";
		if(pract_id.equals(" ") || pract_id.equals("null")) pract_id = "";
		if(facility_id.equals(" ") || facility_id.equals("null")) facility_id = "";
		
		String countSql ="";
		
		try 
		{
			
			con = getConnection() ;		
			String sql="SELECT sc.summary_comp_id||sd.SUMMARY_COMP_OCC_NUM summ_comp_id,sc.executable_name, sc.summary_comp_desc,NVL (sc.summary_comp_desc_legend,NVL (sc.summary_comp_desc_user, sc.summary_comp_desc)) summary_comp_desc_bg,ds.source_sql FROM sm_desktop_sum_comp sc, sm_data_source ds,sm_desktop_sum_dtl sd WHERE ds.source_id = sc.summary_data_source_id and sc.SUMMARY_COMP_ID= sd.SUMMARY_COMP_ID and sd.DESKTOP_SUMMARY_ID=? AND ds.source_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1, desktop_id);
			pstmt.setString( 2, source_id);
			resultSet = pstmt.executeQuery() ;
			
			if(resultSet.next()){ 
				
	/*0*/			ResultDetail.add(resultSet.getString( "summ_comp_id" ))  ;
	/*1*/			ResultDetail.add(resultSet.getString( "executable_name" ))  ;
	/*2*/			ResultDetail.add(resultSet.getString( "summary_comp_desc" ))  ;
	/*3*/			ResultDetail.add(resultSet.getString( "summary_comp_desc_bg" ))  ;
					countSql=resultSet.getString( "source_sql" )==null?"":(String)resultSet.getString( "source_sql" );
			}
			
			if(resultSet != null) resultSet.close();
			if(pstmt != null)pstmt.close();
			
			if(!"".equals(countSql)){		//TFS15204	
				countSql=countSql.replaceAll("&&LOGGED_IN_PRACT##",  "'"+pract_id+"'");
				countSql=countSql.replaceAll("&&LOGGED_IN_RESP##",  "'"+resp_id+"'");
				countSql=countSql.replaceAll("&&LOGGED_IN_FACILITY##",   "'"+facility_id+"'");
				
				pstmt = con.prepareStatement(countSql);
			
				resultSet = pstmt.executeQuery() ;
				if(resultSet.next()){ 
		/*4*/		ResultDetail.add((String)resultSet.getString("grptot"))  ;
				}			
			} //TFS15204
			
		}
		catch( Exception e )	
		{
			System.err.println( "Error loading values from database CAMenuDetailsBean SEARCH" );
			e.printStackTrace() ;				
		} 
		finally 
		{
			 if(resultSet != null) resultSet.close();
			 if(pstmt != null)pstmt.close();
			 if(con != null) con.close();
		}
		return ResultDetail;
	}//IN066237 ends
	//51215 Start.
	public ArrayList outPatientCount(String source_id,String desktop_id,String resp_id,String pract_id,String facility_id)throws Exception
	{
		Connection con 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultDetail	= new ArrayList() ;
		
		if(source_id.equals(" ") || source_id.equals("null")) source_id = "";
		if(desktop_id.equals(" ") || desktop_id.equals("null")) desktop_id = "";
		if(resp_id.equals(" ") || resp_id.equals("null")) resp_id = "";
		if(pract_id.equals(" ") || pract_id.equals("null")) pract_id = "";
		if(facility_id.equals(" ") || facility_id.equals("null")) facility_id = "";
		
		String countSql ="";
		
		try 
		{
			
			con = getConnection() ;		
			String sql="SELECT sc.summary_comp_id||sd.SUMMARY_COMP_OCC_NUM summ_comp_id,sc.executable_name, sc.summary_comp_desc,NVL (sc.summary_comp_desc_legend,NVL (sc.summary_comp_desc_user, sc.summary_comp_desc)) summary_comp_desc_bg,ds.source_sql FROM sm_desktop_sum_comp sc, sm_data_source ds,sm_desktop_sum_dtl sd WHERE ds.source_id = sc.summary_data_source_id and sc.SUMMARY_COMP_ID= sd.SUMMARY_COMP_ID and sd.DESKTOP_SUMMARY_ID=? AND ds.source_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1, desktop_id);
			pstmt.setString( 2, source_id);
			resultSet = pstmt.executeQuery() ;
			
			if(resultSet.next()){ 
				
	/*0*/			ResultDetail.add(resultSet.getString( "summ_comp_id" ))  ;
	/*1*/			ResultDetail.add(resultSet.getString( "executable_name" ))  ;
	/*2*/			ResultDetail.add(resultSet.getString( "summary_comp_desc" ))  ;
	/*3*/			ResultDetail.add(resultSet.getString( "summary_comp_desc_bg" ))  ;
					countSql=resultSet.getString( "source_sql" )==null?"":(String)resultSet.getString( "source_sql" );
			}
			
			if(resultSet != null) resultSet.close();
			if(pstmt != null)pstmt.close();
			
			if(!"".equals(countSql)){		//TFS15204	
				countSql=countSql.replaceAll("&&LOGGED_IN_PRACT##",  "'"+pract_id+"'");
				countSql=countSql.replaceAll("&&LOGGED_IN_RESP##",  "'"+resp_id+"'");
				countSql=countSql.replaceAll("&&LOGGED_IN_FACILITY##",   "'"+facility_id+"'");
				
				pstmt = con.prepareStatement(countSql);
			
				resultSet = pstmt.executeQuery() ;
				if(resultSet.next()){ 
				ResultDetail.add((String)resultSet.getString(1))  ;
				}			
			} 
			if(resultSet != null) resultSet.close();
			if(pstmt != null)pstmt.close();
			
			
			pstmt = con.prepareStatement("SELECT Count(*) TOTALRECOD FROM pr_encounter p WHERE p.facility_id =? AND p.attend_practitioner_id = ? AND ( (    'Y' = (SELECT ca_rest_unbilled_patient FROM ca_cons_param) AND 'N' = blcommonproc.unbld_outst_amt_exists_yn (p.facility_id,p.patient_id,DECODE (p.patient_class,'OP', 'O','EM', 'E','IP', 'I','DC', 'D'),NULL,NULL,p.encounter_id,NULL) ) OR ('N' = (SELECT ca_rest_unbilled_patient FROM ca_cons_param)) )  AND p.visit_status IN ('01', '02', '03', '04', '05', '06') AND p.visit_adm_date_time BETWEEN TRUNC (SYSDATE) AND TRUNC (SYSDATE) + 1 AND p.patient_class = 'OP' AND OP_PATIENT_C4C_STATUS_DISPLAY(p.facility_id,p.patient_id,p.encounter_id,p.patient_class)='Y'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,pract_id);
			resultSet = pstmt.executeQuery();
			if (resultSet.next())
			{
				ResultDetail.add(resultSet.getString("TOTALRECOD"));
			}
			if(resultSet != null) resultSet.close();
			if(pstmt != null)pstmt.close();
		}
		catch( Exception e )	
		{
			System.err.println( "Error loading values from database CAMenuDetailsBean SEARCH" );
			e.printStackTrace() ;				
		} 
		finally 
		{
			 if(resultSet != null) resultSet.close();
			 if(pstmt != null)pstmt.close();
			 if(con != null) con.close();
		}
		return ResultDetail;
	}
	public int getC4CNofication(String pract_id,String facility_id)throws Exception
	{
		Connection con 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 		= null;
		
		int totalCount=0;
		int [] updateStuCounts			= null;
		String countSql ="";
		
		try 
		{
			
			con = getConnection() ;		
			String sql="SELECT FACILITY_ID,ENCOUNTER_ID FROM PR_ENCOUNTER P  WHERE P.FACILITY_ID = ? AND P.ATTEND_PRACTITIONER_ID = ? AND P.C4C_YN  = 'Y'  AND P.PATIENT_CLASS = 'OP'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1, facility_id);
			pstmt.setString( 2, pract_id);
			resultSet = pstmt.executeQuery() ;
			
			pstmt1 = con.prepareStatement("UPDATE PR_ENCOUNTER  SET C4C_YN  = 'I' WHERE FACILITY_ID=? AND  ENCOUNTER_ID=? ");
			while(resultSet.next()){ 
				totalCount++;
				
				pstmt1.setString( 1, (String)resultSet.getString("FACILITY_ID"));
				pstmt1.setString( 2, (String)resultSet.getString("ENCOUNTER_ID"));
				pstmt1.addBatch();
			}
			if(totalCount>0){
			updateStuCounts =  pstmt1.executeBatch();
			con.commit();
			}
			if( pstmt1!=null)  pstmt1.close();

			if(resultSet != null) resultSet.close();
			if(pstmt != null)pstmt.close();
		}
		catch( Exception e )	
		{
			System.err.println( "Error loading values from database CAMenuDetailsBean SEARCH" );
			e.printStackTrace() ;				
		} 
		finally 
		{
			 if(resultSet != null) resultSet.close();
			 if(pstmt != null)pstmt.close();
			 if(con != null) con.close();
		}
		return totalCount;
	}
	//51215 End.
}
