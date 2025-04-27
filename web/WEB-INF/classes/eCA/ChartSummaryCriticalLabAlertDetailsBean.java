/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	           Edit History        	Name        		Rev.Date		  Rev.Name		     Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
16/04/2024	  32074	   Ranjith P R		                   17/04/2024		  RAMESH G    ML-MMOH-CRF-1912.1
9/08/2024	      64856        HARIHARAN K	          9/08/2024				                ML-MMOH-SCF-2920
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
//32074 starts
package eCA;

import java.io.*;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import eCA.Common.CaAdapter;
import webbeans.eCommon.ConnectionManager;

public class ChartSummaryCriticalLabAlertDetailsBean extends CaAdapter implements Serializable {
	
public ArrayList getChartSummaryCriticalLabAlertDetails(Properties properties,String locale,String patient_id,String operating_facility_id) throws SQLException{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList details				= new ArrayList();
	try
	{	
		connection				= ConnectionManager.getConnection(properties) ;
	    pstmt = connection.prepareStatement("SELECT a.specimen_no, a.unit_no, a.product_code, a.patient_id,c.product_code, c.short_desc AS product_desc,b.trans_reaction_order_id,d.encounter_id FROM bt_unit_request_dtl a, bt_request_adverse_reac b, bt_product_mast_lang_vw c,RL_request_header d WHERE b.patient_id = ? AND b.operating_facility_id = ? AND a.specimen_no = b.specimen_no AND d.specimen_no = b.specimen_no  AND a.product_code = b.product_code AND a.patient_id = b.patient_id AND a.operating_facility_id = b.operating_facility_id AND a.unit_no = b.unit_no AND c.product_code = a.product_code AND c.language_id = ? order by b.MODIFIED_DATE DESC");//ML-MMOH-SCF-2920
    	pstmt.setString(1, patient_id);
    	pstmt.setString(2, operating_facility_id);
    	pstmt.setString(3, locale);
    	
    	resultSet = pstmt.executeQuery() ;

		if ( resultSet != null ){
			HashMap<String,String>  resultMap=null;
			while(resultSet.next()){
				resultMap= new HashMap<String,String>();
				
				resultMap.put("SPECIMEN_NUMBER",resultSet.getString("SPECIMEN_NO")==null?"":resultSet.getString("SPECIMEN_NO"));
				resultMap.put("UNIT_NO",resultSet.getString("UNIT_NO")==null?"":resultSet.getString("UNIT_NO"));
				resultMap.put("PRODUCT_CODE", resultSet.getString("PRODUCT_CODE")==null?"":resultSet.getString("PRODUCT_CODE"));
				resultMap.put("PRODUCT_DESC", resultSet.getString("PRODUCT_DESC")==null?"":resultSet.getString("PRODUCT_DESC"));
				resultMap.put("encounter_id", resultSet.getString("encounter_id")==null?"":resultSet.getString("encounter_id"));//ML-MMOH-SCF-2920
			
				
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

public ArrayList getAdverseTransfusionDetails(Properties properties,String locale,String patient_id,String unit_no,String specimen_num,String product_code,String his_rec_type,String encounter_id) throws SQLException{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList details				= new ArrayList();
	StringBuffer displaydata = null;
	String Result_string = "";
	String data = "";
	String Transfusion_Remarks = "";
	Clob note;
	java.io.BufferedReader r;
	
	try
	{	
		connection				= ConnectionManager.getConnection(properties) ;
	    pstmt = connection.prepareStatement("SELECT a.result_str,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) AS result_str_linked,(SELECT b.comments FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) AS comments FROM cr_encounter_detail a WHERE a.patient_id = ? AND NVL(a.status, '`') NOT IN ('S', 'E') AND a.hist_rec_type = ? AND a.encounter_id = ? AND a.accession_num LIKE( ?)  AND  a.event_code = ? AND INSTR(LOWER(a.result_str), LOWER(?)) > 0");
    	pstmt.setString(1, patient_id);
    	pstmt.setString(2, his_rec_type);
    	pstmt.setString(3, encounter_id);
    	pstmt.setString(4,"%"+ specimen_num+"%");
    	pstmt.setString(5, product_code);
    	pstmt.setString(6, unit_no);
    	
    	resultSet = pstmt.executeQuery() ;

		if ( resultSet != null ){
			
			while(resultSet.next()){
				displaydata = new StringBuffer();
				Result_string = resultSet.getString("RESULT_STR")==null?"":resultSet.getString("RESULT_STR");
				note=resultSet.getClob("result_str_linked");
					if(note!=null)
					{
						r = new java.io.BufferedReader(note.getCharacterStream());
						String line = null;	
								
						while((line=r.readLine()) != null) 
						{
							displaydata.append(line+"\n");
						
						}
					
					}
				
					displaydata.append((resultSet.getString("comments")==null?"":(String)resultSet.getString("comments"))); //6484
			
	
			}		
	}
		if(displaydata.length() >0)
		{
			data = "<br/><PRE style='word-wrap:break-word;'>"+Result_string+"</PRE><br/><PRE style='word-wrap:break-word;'>"+(displaydata.toString()).replaceAll("line-height: 100%"," ")+"</PRE>"; //IN068396
		}
		else{
			//data=resultstr+" "+displaydata.toString();//IN068396
			data=Result_string+" "+(displaydata.toString()).replaceAll("line-height: 100%"," ");//IN068396
		}
			details.add(data);
		//	details.add(displaydata);
			
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
	
//32074 ends

