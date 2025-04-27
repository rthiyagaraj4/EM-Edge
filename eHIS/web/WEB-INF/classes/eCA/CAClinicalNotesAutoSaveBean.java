package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eOR.Common.OrAdapter;

public class CAClinicalNotesAutoSaveBean extends OrAdapter implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			//Auto Save Starts
			public int removedatafromsectionTemp(String patient_id,
					String encounter_id, String note_type,String login_user_id,Connection con) throws SQLException {
					
				StringBuffer deleteqry =  new StringBuffer();
				StringBuffer deleteqryobjtmp =  new StringBuffer();
				StringBuffer deleteqryaddendumtmp =  new StringBuffer();
				int cnt = 0;
				int objtmpcnt = 0;
				int addendumtmpcnt = 0;
				int success =0;
				deleteqry.append("DELETE FROM CA_ENCNTR_NOTE_SECTION_TMP WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? AND ADDED_BY_ID=? AND NOTE_TYPE = ? ");
				deleteqryobjtmp.append("DELETE FROM CA_ENCNTR_NOTE_SECTION_OBJ_TMP WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? AND ADDED_BY_ID=? AND NOTE_TYPE = ? ");
				deleteqryaddendumtmp.append("DELETE FROM CA_ENCNTR_NOTE_ADDENDUM_TMP WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? AND ADDED_BY_ID=? AND NOTE_TYPE = ? ");
				int index=1;
				PreparedStatement pstmt =  null;
				try {
					pstmt	=	con.prepareStatement(deleteqry.toString());
					pstmt.setString	(	index++,	patient_id	);
					pstmt.setString	(	index++,	encounter_id	);
					pstmt.setString	(	index++,	login_user_id		);
					pstmt.setString	(	index++,	note_type	);
				
					cnt = pstmt.executeUpdate();
					pstmt	=	con.prepareStatement(deleteqryobjtmp.toString());
					index = 1;
					pstmt.setString	(	index++,	patient_id	);
					pstmt.setString	(	index++,	encounter_id	);
					pstmt.setString	(	index++,	login_user_id		);
					pstmt.setString	(	index++,	note_type	);
					objtmpcnt = pstmt.executeUpdate();
					index = 1;
					pstmt	=	con.prepareStatement(deleteqryaddendumtmp.toString());
					pstmt.setString	(	index++,	patient_id	);
					pstmt.setString	(	index++,	encounter_id	);
					pstmt.setString	(	index++,	login_user_id		);
					pstmt.setString	(	index++,	note_type	);
					addendumtmpcnt = pstmt.executeUpdate();
					if(cnt>0 || addendumtmpcnt >0 || objtmpcnt > 0)
					{
						success=1; 
						con.commit();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally 
				{
					if(pstmt!=null){	pstmt.close();	} 
				
				}
				return success;
			} 
			
			public String getAutoSaveNoteYN() throws Exception {
					
				StringBuffer autosaveynquery =  new StringBuffer();
				Connection				con					= null;
				String auto_save_yn = "N";
				ResultSet rs = null;
				autosaveynquery.append("SELECT AUTO_SAVE_YN,AUTO_SAVE_TIME FROM CA_NOTE_PARAM ");
			
				PreparedStatement pstmt =  null;
				try {
					con=getConnection();
					pstmt	=	con.prepareStatement(autosaveynquery.toString());
					
				rs = pstmt.executeQuery();
				while (rs.next()) {
				
					auto_save_yn=rs.getString(1);
				
				}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
		  			closeResultSet( rs ) ;
		  			closeStatement( pstmt ) ;
		  			closeConnection(con);
		  		}
				return auto_save_yn;
			} 
			
			
			//Auto Save Ends

}
