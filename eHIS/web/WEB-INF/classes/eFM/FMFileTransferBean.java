/*Created by Sangeetha on 18th July 2017 against GDOH-CRF-0133 */
package eFM;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;

public class FMFileTransferBean implements Serializable{

	public static String currentFileFSLocation(Connection con, String patientId, String LangId) throws Exception{
		PreparedStatement pstmt	  = null;
		ResultSet rs 			  = null;
		String Curr_FS_Locn	      = "";
		String curr_fs_locn_id    = "";
		String other_locn_identity= "";
		JSONObject json			  = new JSONObject();
		JSONArray FMLocnJSONArr	  = new JSONArray();
		String returnStr 		  = "";
		int rowCnt				  = 0;

		try{
			String sql = "SELECT curr_fs_locn_short_desc, curr_fs_locn_identity, other_locn_identity FROM (SELECT d.short_desc curr_fs_locn_short_desc, a.curr_fs_locn_identity curr_fs_locn_identity, d.locn_identity other_locn_identity, a.added_date FROM fm_curr_locn a, fm_storage_locn_lang_vw d WHERE a.patient_id = '"+patientId+"' AND a.volume_status = 'A' AND a.curr_facility_id = d.facility_id AND a.curr_fs_locn_code = d.fs_locn_code AND d.language_id = '"+LangId+"' ORDER BY added_date DESC) where rownum <=3";
			
			pstmt= con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){

				JSONObject FMLocnjsonObj	= new JSONObject();

				Curr_FS_Locn		= checkForNull(rs.getString("curr_fs_locn_short_desc"));
				curr_fs_locn_id		= checkForNull(rs.getString("curr_fs_locn_identity"));
				other_locn_identity = checkForNull(rs.getString("other_locn_identity"));
				
				FMLocnjsonObj.put("Curr_FS_Locn",Curr_FS_Locn);
				FMLocnjsonObj.put("curr_fs_locn_id",curr_fs_locn_id);
				FMLocnjsonObj.put("other_locn_identity",other_locn_identity);

				FMLocnJSONArr.add(FMLocnjsonObj);
				rowCnt++;
				
			}
			
			json.put("results",FMLocnJSONArr);
			json.put("rowCnt",rowCnt);
			returnStr = json.toString();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in currentFileFSLocation - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		
		return returnStr;
	}

	public static String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}


}//End of Bean