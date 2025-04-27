/*Created by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
package eFM;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import webbeans.eCommon.*;

public class FMCommonBean implements Serializable{

	/*Added by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
	public static JSONArray getAlternateId(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "SELECT * FROM (SELECT '1' nat_id, nvl(nat_id_prompt,'National ID') nat_id_prompt, 1 from mp_param UNION SELECT a.alt_id1_type, b.short_desc short_desc1, 2 FROM mp_param a, mp_alternate_id_type b WHERE b.alt_id_type = a.alt_id1_type UNION SELECT a.alt_id2_type, b.short_desc short_desc2, 3 FROM mp_param a, mp_alternate_id_type b WHERE b.alt_id_type = a.alt_id2_type UNION SELECT a.alt_id3_type, b.short_desc short_desc3, 4 FROM mp_param a, mp_alternate_id_type b WHERE b.alt_id_type = a.alt_id3_type UNION SELECT a.alt_id4_type, b.short_desc short_desc4, 5 FROM mp_param a, mp_alternate_id_type b WHERE b.alt_id_type = a.alt_id4_type) ORDER BY 3";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String alt_id_type	= rs.getString("nat_id")==null?"":rs.getString("nat_id");
				String short_desc	= rs.getString("nat_id_prompt")==null?"":rs.getString("nat_id_prompt");
				jsonObj.put("alt_id_type",alt_id_type);
				jsonObj.put("short_desc",short_desc);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAlternateId - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End ML-MMOH-CRF-0895*/
}