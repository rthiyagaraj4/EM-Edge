/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import eOT.Common.OTAdapter;
import java.util.Properties;
import com.ehis.util.DateUtils;

public class NotesBean  extends OTAdapter implements Serializable {
	String locale = "";
	public NotesBean() {
        try {
				//doCommon();
				locale = getProperties().getProperty("LOCALE");		
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {}
	public void clear(){}

	public String getContrModAccessionNum(String stage,String[] val){
		 String oper_num = val[0];//anesthesia_srl_no in case from anaesthesia
		 String speciality_code =val[1];//anesthesia_accession_num in case from anaesthesia
		 String locn_type = val[2];
		 String contra_mod_access_num = "";
		switch(getStageCode(stage)){
			case 5:
						contra_mod_access_num = login_facility_id+oper_num+speciality_code+"99"; //OPERATIVE_NOTES
						break;
			case 6: 
						//login_facility_id+anesthesia_srl_no+"PRE"+anesthesia_accession_num;
						contra_mod_access_num = login_facility_id+oper_num+"PRE"+speciality_code;//PRE_ANES
						break;
			case 7: 
						contra_mod_access_num =  login_facility_id+oper_num+"INTRA";//INTRA
						break;
			case 8: 
						contra_mod_access_num =  login_facility_id+oper_num+"POST";//POST	
						break;

			default:  contra_mod_access_num = login_facility_id+oper_num+speciality_code+locn_type; 
						break;
			
		}
		
		return contra_mod_access_num;
	}

	private int getStageCode(String stage){
		//SURGEON_NOTES, NURSING_NOTES, HOLD_NOTES, RECOVERY_NOTES, OPERATIVE_NOTES, PRE_ANES, INTRA_ANES, POST_ANES
		java.util.Map map = new HashMap();
		map.put("HOLD_NOTES","1");
		map.put("SURGEON_NOTES","2");
		map.put("NURSING_NOTES","3");
		map.put("RECOVERY_NOTES","4");
		map.put("OPERATIVE_NOTES","5");
		map.put("PRE_ANES","6");
		map.put("INTRA_ANES","7");
		map.put("POST_ANES","8");
		 map =java.util.Collections.unmodifiableMap(map);
		return Integer.parseInt( (String)map.get(stage) );
	}


	public String getStageSql(String stage ){
		//when notes not entered
		String sql="";
		switch(getStageCode(stage)){
			//OPERATIVE_NOTES
			case 5:
			sql = "SELECT P.OPERATIVE_RECORDS_NOTE_TYPE OPERATIVE_RECORDS_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM OT_PARAM P, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=P.OPERATIVE_RECORDS_NOTE_TYPE AND N.LANGUAGE_ID=?";
			break;
			//PRE_ANES
			case 6:
			sql = "SELECT A.PRE_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.PRE_ANES_NOTE_TYPE AND N.LANGUAGE_ID=?"; 
			break;
			//INTRA_ANES
			case 7:
			sql = "SELECT A.INTRA_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.INTRA_ANES_NOTE_TYPE AND N.LANGUAGE_ID=?"; 
			break;
			//POST_ANES
			case 8:
			sql = "SELECT A.POST_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.POST_ANES_NOTE_TYPE AND N.LANGUAGE_ID=?"; 
			break;
		}
		return sql;
}


/**
		@comments: Already Notes entered and called_from will be one of the following		 OPERATIVE_NOTES||PRE_ANES||INTRA_ANES||POST_ANES	

	*/
	public ArrayList getListItemValues(String mod_access_num,String speciality_code,String locn_code,String called_from){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList list = new ArrayList();
		String sql = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE and Event_Status <> '9' AND H.LANGUAGE_ID=? ";
		String[] records = null;
		int rec=0;
		int i=0;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
			pstmt.setString(1,mod_access_num);
			pstmt.setString(2,locale);
			resultSet  = pstmt.executeQuery();
			resultSet.last();
			rec = resultSet.getRow();
			resultSet.beforeFirst() ;
			if(rec>0) 	records = new String[rec*2];
			while(resultSet.next()){
		        records[i]= resultSet.getString(1);
		        records[i+1]= resultSet.getString(2);
				i++;
				
			}
			//if notes entered flag = false
			if(i==0){
					if( "OPERATIVE_NOTES".equals(called_from) ||  "PRE_ANES".equals(called_from) ||  "INTRA_ANES".equals(called_from) ||  "POST_ANES".equals(called_from) ){
						records = getNoteTypeList(called_from);
					}else{
						records = getNoteTypeListVal(speciality_code,locn_code);
					}
			}
		list.add(records);
		}catch (Exception e){
	          System.err.println("Err Msg in getListItemValues="+e.getMessage());
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return list;
	}
	
	/**
		@comments: Already Notes not entered and called_from will be one of the following		 OPERATIVE_NOTES||PRE_ANES||INTRA_ANES||POST_ANES	

	*/
	public String[] getNoteTypeList(String stage){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String sql = getStageSql(stage);
		String[] records =null;
		int count = 0;
		int rec = 0;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
			pstmt.setString(1,locale);
			resultSet  = pstmt.executeQuery();
			resultSet.last();
			rec = resultSet.getRow();
			resultSet.beforeFirst() ;
			if(rec>0) 	records = new String[rec*2];
			while(resultSet.next()){
		        records[count]= resultSet.getString(1);
		        records[count+1]= resultSet.getString(2);
				count+=2;
			}
		}catch (Exception e){
	          System.err.println("Err Msg in getListItemValues="+e.getMessage());
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return records;
 }

	/**
		@comments: Already Notes not entered and called_from will be one of the following		HOLD_NOTES||SURGEON_NOTES||NURSING_NOTES||RECOVERY_NOTES||OPERATIVE_NOTES		

	*/
	 public String[] getNoteTypeListVal(String speciality_code,String locn_code){
		 String speciality_code_loc = "ALL".equalsIgnoreCase(speciality_code)?"*ALL":speciality_code;
		String sql_count = "SELECT COUNT(*) NOTE_TYPE_COUNT FROM OT_NOTE_TYPE_FOR_SPECIALTIES WHERE SPECIALTY_CODE=? AND LOCN_TYPE=?";
		String sql = "SELECT S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE_LANG_VW C WHERE SPECIALTY_CODE=? AND LOCN_TYPE=? AND S.NOTE_TYPE=C.NOTE_TYPE AND NVL(C.EFF_STATUS,'E')='E' AND C.LANGUAGE_ID=?";
		
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String[] records =null;
		int count = 0;
		int cnt = 0;
		int rec = 0;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(sql_count) ;
			pstmt.setString(1,speciality_code_loc);
			pstmt.setString(2,locn_code);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        cnt = resultSet.getInt(1);
			}
			if(resultSet!=null)resultSet.close();
			if(pstmt!=null) pstmt.close();
			if(cnt==0) speciality_code = "*ALL";
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
			pstmt.setString(1,speciality_code_loc);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,"en");
			resultSet  = pstmt.executeQuery();
			resultSet.last();
			rec = resultSet.getRow();
			resultSet.beforeFirst();
			if(rec>0) 	records = new String[rec*2];
			while(resultSet.next()){
		        records[count]= resultSet.getString(1);
		        records[count+1]= resultSet.getString(2);
				count+=2;
			}
		}catch (Exception e){
	          System.err.println("Err Msg in getListItemValues="+e.getMessage());
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return records;
 }

}
