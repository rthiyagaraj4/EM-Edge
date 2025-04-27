/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;

import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.SingleTableHandlerHome;

public class NoteForExternalDrugProfileBean extends PhAdapter implements Serializable{
	
	private ArrayList noteTypeDetails = null;
//	private String location_type="";  Removed for IN063877
//	private String facility_id="";  Removed for IN063877
	private String note_group_code="";
	private Hashtable recordSet				= new Hashtable();
	
	public void clear(){
		this.noteTypeDetails=null;
		if(this.recordSet !=null)
			recordSet.clear();
	}
	
	public void setNoteGroupCode(String note_group_code){
		this.note_group_code=note_group_code;
	}
	
	public ArrayList getNoteTypeDetails(){
		return this.noteTypeDetails;
	}
	public boolean getNoteExists(String note_type, String note_group_id){
		Connection connection	 =	null ;
		PreparedStatement note_exists =	null ;
		ResultSet note_result = null;
		boolean flag = false;
		
		String exists ="";
		try{
			
			connection = getConnection();
			
			note_exists=connection.prepareStatement("select NOTE_TYPE from PH_NOTE_EXT_DRUG where NOTE_TYPE=? and NOTE_GROUP_ID=?");
			note_exists.setString(1, note_type);
			note_exists.setString(2, note_group_id);
			note_result = note_exists.executeQuery();
			if(note_result.next())
				exists = (String)(note_result.getString("note_type"));
			if(exists.length()>0)	
			   flag = true;
			
		}
		catch(Exception e){
			e.printStackTrace();
			
	    }
		finally{
			try {
				closeConnection(connection);
				closeResultSet(note_result);
				closeStatement(note_exists);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		  return flag;
	}
	public boolean getNoteExistsAndEnabled(String note_type, String note_group_id){
		Connection connection	 =	null ;
		PreparedStatement note_exists =	null ;
		ResultSet note_result = null;
		boolean flag = false;
		String exists = "";
		try{
			
			connection = getConnection();
			
			note_exists=connection.prepareStatement("select NOTE_TYPE from PH_NOTE_EXT_DRUG where NOTE_TYPE=? and NOTE_GROUP_ID=? and EXT_DRUG_NOTE_YN='Y'");
			note_exists.setString(1, note_type);
			note_exists.setString(2, note_group_id);
			note_result = note_exists.executeQuery();
			if(note_result.next())
				exists = (String)(note_result.getString("NOTE_TYPE"));
			if(exists.length()>0)	
			   flag = true;
			
		}
		catch(Exception e){
			e.printStackTrace();
			
	    }
		finally{
			try {
				closeConnection(connection);
				closeResultSet(note_result);
				closeStatement(note_exists);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		  return flag;
	}
	public ArrayList getNoteTypeForGroup(String note_group_code){
			Connection connection	 =	null ;
			PreparedStatement pstmt_select_note_type =	null ;
			ResultSet rset_note_type = null;
			noteTypeDetails = new ArrayList();
			setNoteGroupCode(note_group_code);
			String sql_select_disp_type="";
			try{
				sql_select_disp_type ="SELECT note_type note_code,note_type_desc,event_class,eff_status,confidential_yn FROM ca_note_type where note_group_id=? ORDER BY  note_type_desc"; 
				
				connection = getConnection();
				pstmt_select_note_type = connection.prepareStatement(sql_select_disp_type);
				pstmt_select_note_type.setString(1, note_group_code);
				rset_note_type = pstmt_select_note_type.executeQuery();
				while((rset_note_type!= null)&& (rset_note_type.next())){
					noteTypeDetails.add(rset_note_type.getString("note_code"));
					noteTypeDetails.add(rset_note_type.getString("note_type_desc"));
					noteTypeDetails.add(rset_note_type.getString("event_class"));
					noteTypeDetails.add(rset_note_type.getString("eff_status"));
					noteTypeDetails.add(rset_note_type.getString("confidential_yn"));
				}
			}
			catch(Exception e){
					e.printStackTrace();
			}
			finally{
				try{
					closeResultSet(rset_note_type);
					closeStatement(pstmt_select_note_type);
					closeConnection(connection);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			return noteTypeDetails;
		}
	public void setAll( Hashtable recordSet ) {
		this.mode=(String)recordSet.get("mode");
		this.recordSet = recordSet;
	}
	
	public HashMap insert() {		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		Connection connection				  = null;
		PreparedStatement insert             = null ;
		PreparedStatement update     = null ;
		String note_type_code="";
		String note_group_code ="";
	    String cheked_yn ="";
	    boolean update_yn = false,insert_yn=false;
		try{
			int total_count = Integer.parseInt((String)recordSet.get("maxRecord"));
			connection		= getConnection() ;
			insert			= connection.prepareStatement("INSERT INTO PH_NOTE_EXT_DRUG (NOTE_GROUP_ID,NOTE_TYPE, EXT_DRUG_NOTE_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
			update          = connection.prepareStatement("update PH_NOTE_EXT_DRUG set EXT_DRUG_NOTE_YN=? where NOTE_TYPE=? and NOTE_GROUP_ID=?"); 
			for(int i=0;i<total_count;i++){
				note_type_code  = (String)recordSet.get("note_type_code"+i); 
				note_group_code = (String)recordSet.get("note_group_code");
				cheked_yn = (String)recordSet.get("check"+i);
				
				if(getNoteExists(note_type_code,note_group_code) && !cheked_yn.equalsIgnoreCase("Y") ){
					update.setString(1,"N");
					update.setString(2, note_type_code);
					update.setString(3, note_group_code);
					update.addBatch();
					update_yn = true;
				}
				else if(cheked_yn.equalsIgnoreCase("Y") && !getNoteExists(note_type_code,note_group_code) ){
					insert.setString(1, note_group_code);
					insert.setString(2, note_type_code);
					insert.setString(3, "Y");
					insert.setString(4, login_by_id.trim());
					insert.setString(5, login_at_ws_no.trim());
					insert.setString(6, login_facility_id.trim());
					insert.setString(7, login_by_id.trim());
					insert.setString(8, login_at_ws_no.trim());
					insert.setString(9, login_facility_id.trim());
					insert.addBatch();	
					insert_yn = true;
				}
				else if(cheked_yn.equalsIgnoreCase("Y") && !getNoteExistsAndEnabled(note_type_code,note_group_code)){
					update.setString(1,"Y");
					update.setString(2, note_type_code);
					update.setString(3, note_group_code);
					update.addBatch();
					update_yn = true;
				}
				
			}
			
			if(insert_yn){
			insert.executeBatch();
			map.put( "result", new Boolean( true ) ) ;
			}
			if(update_yn){
				update.executeBatch();
				map.put( "result", new Boolean( true ) ) ;
			}
			if(map.get("result") != null){
				map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
			}
			
			if(insert_yn || update_yn)
			   connection.commit();
						
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				try {
					connection.rollback();
					insert.close();
					update.close();
					closeConnection( connection );//common-icn-0029
				}
				catch (Exception e) {
					e.printStackTrace();
				}	
		}
		return map ;
	}

}
