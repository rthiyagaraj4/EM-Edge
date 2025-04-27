/*Created by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
package eAM;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import webbeans.eCommon.*;
import org.json.simple.parser.JSONParser;

public class AMCommonBean implements Serializable{

	/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
	public static JSONObject getPractName(Connection con, String natid) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "";
		JSONObject jsonObj = new JSONObject();
		int rec_cnt = 0;
		String practitioner_name = "";

		try{
			sql = "SELECT COUNT (*) OVER () noOfRecords, practitioner_name FROM am_practitioner WHERE UPPER (national_id_num) = UPPER ('"+natid+"')";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				rec_cnt = rs.getInt("noOfRecords");
				practitioner_name = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
			}

			jsonObj.put("rec_cnt",rec_cnt);
			jsonObj.put("practitioner_name",practitioner_name);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPractName - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static String getNatIdMandYN(Connection con) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String natid_mand_yn = "";

		try{
			String sql = "SELECT natid_mand_pract_othstaff_yn FROM sm_site_param";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				natid_mand_yn = rs.getString("natid_mand_pract_othstaff_yn")==null?"":rs.getString("natid_mand_pract_othstaff_yn");
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getNatIdMandYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return natid_mand_yn;
	}
	
	public static String getOthAltDefaultValue(Connection con, String module_id, String functionality_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String oth_alt_val = "";

		try{
			String sql = "SELECT a.value_1 oth_alt_val FROM sm_function_control a, sm_site_param b, mp_alternate_id_type c WHERE a.module_id = '"+module_id+"' AND a.functionality_id = '"+functionality_id+"' AND a.site_id = b.customer_id AND a.value_1 = c.alt_id_type AND eff_status = 'E'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				oth_alt_val = rs.getString("oth_alt_val")==null?"":rs.getString("oth_alt_val");
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOthAltDefaultValue - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return oth_alt_val;
	}

	public static JSONObject getOthAltPractName(Connection con, String othalttype, String othaltid) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "";
		JSONObject jsonObj = new JSONObject();
		int rec_cnt = 0;
		String practitioner_name = "";

		try{
			sql = "SELECT COUNT (*) OVER () noOfRecords, practitioner_name FROM am_practitioner WHERE oth_alt_id_type = '"+othalttype+"' and UPPER (oth_alt_id_no) = UPPER ('"+othaltid+"')";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				rec_cnt = rs.getInt("noOfRecords");
				practitioner_name = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
			}

			jsonObj.put("rec_cnt",rec_cnt);
			jsonObj.put("practitioner_name",practitioner_name);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOthAltPractName - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONObject getOthStaffName(Connection con, String natid) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "";
		JSONObject jsonObj = new JSONObject();
		int rec_cnt = 0;
		String oth_staff_name = "";

		try{
			sql = "SELECT COUNT (*) OVER () noofrecords, other_staff_name FROM am_other_staff WHERE UPPER (national_id_num) = UPPER ('"+natid+"')";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				rec_cnt = rs.getInt("noOfRecords");
				oth_staff_name = rs.getString("other_staff_name")==null?"":rs.getString("other_staff_name");
			}

			jsonObj.put("rec_cnt",rec_cnt);
			jsonObj.put("oth_staff_name",oth_staff_name);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOthStaffName - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONObject getOthAltStaffName(Connection con, String othalttype, String othaltid) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "";
		JSONObject jsonObj = new JSONObject();
		int rec_cnt = 0;
		String oth_staff_name = "";

		try{
			sql = "SELECT COUNT (*) OVER () noOfRecords, other_staff_name FROM am_other_staff WHERE oth_alt_id_type = '"+othalttype+"' and UPPER (oth_alt_id_no) = UPPER ('"+othaltid+"')";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				rec_cnt = rs.getInt("noOfRecords");
				oth_staff_name = rs.getString("other_staff_name")==null?"":rs.getString("other_staff_name");
			}

			jsonObj.put("rec_cnt",rec_cnt);
			jsonObj.put("oth_staff_name",oth_staff_name);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOthAltStaffName - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	/*End MOHE-CRF-0011*/

	/*Added by Suji Keerthi for MOHE-CRF-0021*/
	public static String getNationalIDPrompt(Connection con) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String nat_id_prompt = "";

		try{
			String sql = "SELECT nat_id_prompt FROM mp_param where module_id='MP'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				nat_id_prompt = rs.getString("nat_id_prompt")==null?"":rs.getString("nat_id_prompt");
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getNationalIDPrompt - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return nat_id_prompt;
	}

     public static JSONArray getPractitionerType(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		String practType        ="";
		String descUserDef      ="";
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select pract_type,Desc_Userdef from am_pract_type Where EFF_STATUS = 'E'"; //Modified by Suji Keerthi for AMRI-CRF-0437
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				practType		= rs.getString("pract_type")==null?"":rs.getString("pract_type");
				descUserDef		= rs.getString("Desc_Userdef")==null?"":rs.getString("Desc_Userdef");
				jsonObj.put("pract_type",practType);
				jsonObj.put("Desc_Userdef",descUserDef);
				arrJSON.add(jsonObj);
			}
			if(rs!=null) rs.close(); 
            if(stmt!=null) stmt.close(); 
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPractitionerType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

  public static JSONArray getPrimarySpeciality(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		String specialityCode   ="";
        String shortDesc        ="";
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select speciality_code,short_desc from am_speciality";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				specialityCode		= rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
				shortDesc		    = rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("speciality_code",specialityCode);
				jsonObj.put("short_desc",shortDesc);
				arrJSON.add(jsonObj);
			}
			if(rs!=null) rs.close(); 
            if(stmt!=null) stmt.close(); 
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPrimarySpeciality - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End MOHE-CRF-0021*/

/* Added by Suji Keerthi for MOHE-CRF-0022*/

public static JSONArray getOtherStaffType(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		String otherStaffType   ="";
		String shortDesc        ="";
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select other_staff_type,short_desc from am_other_staff_type";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				otherStaffType		= rs.getString("other_staff_type")==null?"":rs.getString("other_staff_type");
				shortDesc		    = rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("other_staff_type",otherStaffType);
				jsonObj.put("short_desc",shortDesc);
				arrJSON.add(jsonObj);
			}
			if(rs!=null) rs.close(); 
            if(stmt!=null) stmt.close(); 
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOtherStaffType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/* End MOHE-CRF-0022*/
    
	//Below added by Suji Keerthi for AMRI-CRF-0437
	public static JSONArray getFacility(Connection con, String p_user_name, String p_resp_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sqlQuery = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";

			pstmt= con.prepareStatement(sqlQuery);
		    rset= pstmt.executeQuery();
			
			while(rset!=null && rset.next()){

				JSONObject jsonObj	= new JSONObject();
				String facility_id = rset.getString("facility_id")==null?"":rset.getString("facility_id");
				String facility_name = rset.getString("facility_name")==null?"":rset.getString("facility_name");

				jsonObj.put("facility_id",facility_id);
				jsonObj.put("facility_name",facility_name);
				
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFacility - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;

	}
	//Ended by Suji Keerthi for AMRI-CRF-0437
	// Added by lakshmanan for MO-CRF-20183.2 US001 start
public static JSONObject getEmpServNo(Connection con, String empservno) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "";
		JSONObject jsonObj = new JSONObject();
		int rec_cnt = 0;
		
		try{
			sql = "select count(*) from am_practitioner where employee_service_no='"+empservno+"' ";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				rec_cnt = rs.getInt(1);
			}

			jsonObj.put("rec_cnt",rec_cnt);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEmpServNo - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

// Added by lakshmanan for MO-CRF-20183.2 US001 end

}