/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
18/05/2017    IN063798		 Raja S		22/05/2017		Ramesh Goli			ML-MMOH-CRF-0807
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA; 

import java.io.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import javax.servlet.http.* ;

public class RecClinicalNotesPractBean implements Serializable
{ 
	public ArrayList<String> getPractitionerResultPage (HttpServletRequest req) throws Exception 
	{
        Connection connection       = null;	
        PreparedStatement pstmtData = null;
        ResultSet rs=null;       
		req.setCharacterEncoding("UTF-8");
        ArrayList result = new ArrayList();
		ArrayList<String> error             = new ArrayList<String>();
		String sql = "";
		String speciality_id = req.getParameter("speciality_id")==null?"":req.getParameter("speciality_id");		
		String clinician_id = req.getParameter("clinician_id")==null?"":req.getParameter("clinician_id");
		String note_type = req.getParameter("note_type")==null?"":req.getParameter("note_type");
		String search_text = req.getParameter("search_text")==null?"":req.getParameter("search_text");
		String search_by = req.getParameter("search_by")==null?"D":req.getParameter("search_by");
		String search_criteria = req.getParameter("search_criteria")==null?"S":req.getParameter("search_criteria");
		int from = req.getParameter("from")==null?1:Integer.parseInt(req.getParameter("from"));
		int to = req.getParameter("to")==null?14:Integer.parseInt(req.getParameter("to"));
		
		int start = from ;
        int end = to ;      
		result.clear();
        result.add("total");      
        try {        
			 HttpSession session = req.getSession(false) ;
            String locale =		session.getAttribute("LOCALE")==null?"":(String)session.getAttribute("LOCALE");
			String facility_id =		session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");			
            connection=ConnectionManager.getConnection();            
			 if( search_criteria.equals( "S" ) )
				search_text = search_text+"%";
			else if( search_criteria.equals( "E" ) )
				search_text ="%"+search_text;
			else if( search_criteria.equals( "C" ) )
				search_text ="%"+search_text+"%";
			else
				search_text = search_text+"%";
			if (speciality_id.equals(""))
			{					
				sql="select  distinct a.practitioner_id code, b.practitioner_name description from am_pract_for_facility a, am_practitioner_lang_vw b, ca_note_type_for_resp ib, sm_appl_user ia, sm_resp_for_user ic where b.language_id =  ? and a.facility_id =? and b.practitioner_id = a.practitioner_id and a.practitioner_id != ? and a.eff_status = 'E' and ib.note_type = ? and ib.privilege_type in ('3', '4') and ia.appl_user_id = ic.appl_user_id and ic.resp_id = ib.resp_id and ia.eff_status = 'E' and  a.practitioner_id=ia.func_role_id and  and upper (a.practitioner_id) like upper (?) and upper (b.practitioner_name) like upper (?) order by 2";
			}else{
				sql = "select distinct a.practitioner_id code, b.practitioner_name description from am_pract_for_facility a, am_practitioner_lang_vw b, ca_note_type_for_resp ib, sm_appl_user ia, sm_resp_for_user ic where b.language_id =? and a.facility_id =  ? and b.practitioner_id = a.practitioner_id and a.practitioner_id != ? and a.practitioner_id =ia.func_role_id and ib.note_type = ? and ib.privilege_type in ('3', '4') and ia.appl_user_id = ic.appl_user_id and ic.resp_id = ib.resp_id and ia.eff_status = 'E' and ( b.primary_speciality_code =  ? or exists ( select 1 from am_pract_specialities where facility_id = a.facility_id and practitioner_id = a.practitioner_id and speciality_code =  ?)) and a.eff_status = 'E' and upper (a.practitioner_id) like upper (?) and upper (b.practitioner_name) like upper (?) order by 2  ";
			}  

			pstmtData =	connection.prepareStatement(sql);
			if (speciality_id.equals(""))
			{
				pstmtData.setString(1,locale);
				pstmtData.setString(2,facility_id);
				pstmtData.setString(3,clinician_id);
				pstmtData.setString(4,note_type);
				if(search_by.equals("C")){ 
					pstmtData.setString(5,search_text);
					pstmtData.setString(6,"%");					
				}else if(search_by.equals("D")){ 
					pstmtData.setString(5,"%");
					pstmtData.setString(6,search_text);				
				}
				
			}else{
				pstmtData.setString(1,locale);
				pstmtData.setString(2,facility_id);
				pstmtData.setString(3,clinician_id);
				pstmtData.setString(4,note_type);				
				pstmtData.setString(5,speciality_id);
				pstmtData.setString(6,speciality_id);
				if(search_by.equals("C")){ 
					pstmtData.setString(7,search_text);
					pstmtData.setString(8,"%");					
				}else if(search_by.equals("D")){ 
					pstmtData.setString(7,"%");
					pstmtData.setString(8,search_text);					
				}
			}
			rs = pstmtData.executeQuery();		
			long count = 0;
            long i = 0;
			if( rs != null ) {
				while( rs.next() && i <= end+1 ) {
					if( start != 1 && (i+1) < start ) {
						i++;
						continue;
					}
					else i++;
					count++ ;
					if(i <= end ) {
						ArrayList records=new ArrayList();
						records.clear();						
						records.add(rs.getString(1));
						records.add(rs.getString(2));
						result.add(records);
					}
				}				
				result.set( 0, String.valueOf( count ) ) ;			
			}
             if( rs != null ) rs.close() ;
             if( pstmtData != null ) pstmtData.close();  
        } catch(Exception ex) {
                error.add(ex.getMessage());
                result.add(error);
        } finally {
            try{
                if( rs != null ) rs.close() ;
				if( pstmtData != null ) pstmtData.close();             
                if ( connection != null ) ConnectionManager.returnConnection(connection);
            } catch(Exception e) {
                error.add(e.getMessage());
                result.add(error);
            }
        }		
        return result;
    }
//IN063798 Changes Starts
	public String getPreviousEncounter(String Pat_id,String Enc_id,Connection con) throws SQLException
	{
		String encounterList="";
		PreparedStatement pstmtData = null;
		ResultSet rs=null;  
		try{
			
			String tempEncId="";
			
			int noOfEncounter = 1;
			String paramSql="SELECT NO_OF_ENCOUNTERS FROM CA_NOTE_PARAM";
			pstmtData = con.prepareStatement(paramSql);
			rs = pstmtData.executeQuery();
			while(rs.next())
			{
				noOfEncounter = rs.getInt("NO_OF_ENCOUNTERS");
			}
			if(rs!=null) rs.close();//15905
			if(noOfEncounter!= 1)
			{
				noOfEncounter=noOfEncounter-1;
				encounterList="('"+Enc_id+"'";
				String encListSql="SELECT ENCOUNTER_ID FROM (SELECT encounter_id FROM pr_encounter WHERE patient_id = ? AND encounter_id != ? AND (ADT_STATUS !='09' OR VISIT_STATUS!='99') ORDER BY visit_adm_date_time DESC) WHERE ROWNUM <= ?";
				pstmtData = con.prepareStatement(encListSql);
				pstmtData.setString( 1,	Pat_id);
				pstmtData.setString( 2,	Enc_id);
				pstmtData.setInt( 3,noOfEncounter);
				rs = pstmtData.executeQuery();
				while(rs.next())
				{
					tempEncId = rs.getString("ENCOUNTER_ID") == null ? "" : rs.getString("ENCOUNTER_ID");
					encounterList = encounterList+",'"+tempEncId+"'";
				}

				encounterList=encounterList+")";

			}
			else
			{
				encounterList="('"+Enc_id+"')";
			}

		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmtData!=null) pstmtData.close();
		}
     return encounterList;
	 }
//IN063798 Changes Ends
}	
