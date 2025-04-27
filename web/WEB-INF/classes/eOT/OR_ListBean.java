/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;

import eOT.Common.OTAdapter;

public class OR_ListBean extends OTAdapter implements Serializable{
	
	HashMap patient_type=null;
	HashMap OT_Notification=null;
	HashMap Surgery_Type=null;
	
	Properties	p = this.properties;
	String	locale	= "";
	
	public OR_ListBean()
	{
		
		try{
			doCommon();
			p = this.properties;
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			
		}catch(Exception e){}
	}
	
	public void doCommon() throws Exception {
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
}
	
	public HashMap getPatientType(){
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        patient_type=new HashMap();
		try{
			connection			= getConnection() ;
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");			
	
			String sql_patient_type = "SELECT patient_class,  short_desc  FROM am_patient_class_lang_vw WHERE patient_class IN ('IP', 'OP', 'EM', 'XT', 'DC')	and language_id =?";

			pstmt				= connection.prepareStatement(sql_patient_type) ;
			pstmt.setString(1,locale);
			
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()==true){
				patient_type.put(checkForNull(resultSet.getString("patient_class")),checkForNull(resultSet.getString("short_desc")));
			}
			
		}catch(Exception e){
			e.printStackTrace() ;			
		}finally{
			try{
				closeResultSet( resultSet ) ;
	            closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}	
			
		}
		return patient_type;
	}
	
	public HashMap getOTNotification(String facility_id){
		OT_Notification=new HashMap();
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        
        try{
			connection			= getConnection() ;
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			
			
			//String sql_patient_type = "SELECT patient_class,  short_desc  FROM am_patient_class_lang_vw WHERE patient_class IN ('IP', 'OP', 'EM', 'XT', 'DC')	and language_id =?"; //Common-ICN-0055
			
			StringBuffer sql=new StringBuffer("");
			sql.append("	SELECT TO_CHAR ((SYSDATE), 'DD/MM/YYYY') tdate,			");
			sql.append("	TO_CHAR (ot_sec1_notice_fm_time, 'hh24:mi') sec1_fm_time1,	");
			sql.append("	TO_CHAR (ot_sec1_notice_to_time, 'hh24:mi') sec1_to_time1,	");
			sql.append("	TO_CHAR (ot_sec2_notice_fm_time, 'hh24:mi') sec2_fm_time1,	");
			sql.append("	TO_CHAR (ot_sec2_notice_to_time, 'hh24:mi') sec2_to_time1,	");
			sql.append("	TO_CHAR (ot_sec3_notice_fm_time, 'hh24:mi') sec3_fm_time1,	");
			sql.append("	TO_CHAR (ot_sec3_notice_to_time, 'hh24:mi') sec3_to_time1	");
			sql.append("	FROM ot_param_for_facility									");
			sql.append("	WHERE operating_facility_id = ?								");
			
			pstmt				= connection.prepareStatement(sql.toString()) ;
			pstmt.setString(1,facility_id);
			
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()==true){
				System.out.println("came in while loop");
				OT_Notification.put("tdate", resultSet.getString("tdate"));
				OT_Notification.put("sec1_fm_time1", checkForNull(resultSet.getString("sec1_fm_time1")));
				OT_Notification.put("sec1_to_time1", checkForNull(resultSet.getString("sec1_to_time1")));
				OT_Notification.put("sec2_fm_time1", checkForNull(resultSet.getString("sec2_fm_time1")));
				OT_Notification.put("sec2_to_time1", checkForNull(resultSet.getString("sec2_to_time1")));
				OT_Notification.put("sec3_fm_time1", checkForNull(resultSet.getString("sec3_fm_time1")));
				OT_Notification.put("sec3_to_time1", checkForNull(resultSet.getString("sec3_to_time1")));
			}
			
		}catch(Exception e){
			e.printStackTrace() ;			
		}finally{
			try{
				closeResultSet( resultSet ) ;
	            closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}			
		}	
		
		return OT_Notification;
	}
	
	public HashMap getSurgeryType(){
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        Surgery_Type=new HashMap();
		try{
			connection			= getConnection() ;
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");			
			
			String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID=? ORDER BY 2";

			pstmt				= connection.prepareStatement(sql_surgery_type) ;
			pstmt.setString(1,locale);
			
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()==true){
				Surgery_Type.put(checkForNull(resultSet.getString("NATURE_CODE")),checkForNull(resultSet.getString("SHORT_DESC")));
			}
			
		}catch(Exception e){
			e.printStackTrace() ;			
		}finally{
			try{
				closeResultSet( resultSet ) ;
	            closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
			
			
		}
		return Surgery_Type;
	}	
}
