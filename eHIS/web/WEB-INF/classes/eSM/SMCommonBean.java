/*Created by Ashwini on 30-Jun-2017 for AMS-CRF-0132*/
package eSM;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;

public class SMCommonBean implements Serializable{
	
	public static int getGSTINFacilityCnt(Connection con,String gstin_facility) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int facCnt				= 0;
		try{
			sql				= " select count(*) gstinCnt from sm_facility_param where gstin_facility = '"+gstin_facility+"'";
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				facCnt			= rs.getInt("gstinCnt");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getGSTINFacilityCnt method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return facCnt;
	}

	public static JSONObject getUserSessionDetails(Connection con,String reqUserId) throws Exception{
		
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		PreparedStatement pstmt	= null;
		ResultSet  rs			= null;
		String whereCond		= "";
		try{
			if(!reqUserId.equals("")){
				whereCond	= " and b.appl_user_id = '"+reqUserId+"'";
			}

			//String sql="SELECT a.appl_user_id USERID, a.appl_user_name USERNAME, to_char(b.login_date,'dd/mm/rrrr hh24:mi') LOGINDATE, b.added_at_ws_no WORKSTATION  FROM sm_appl_user a, sm_appl_user_audit b WHERE a.appl_user_id = b.appl_user_id "+whereCond+" AND ( A.appl_user_id,b.login_date)IN(SELECT a.appl_user_id, MAX (b.login_date) FROM sm_appl_user a, sm_appl_user_audit b WHERE a.appl_user_id = b.appl_user_id  "+whereCond+" GROUP BY a.appl_user_id)";
			String sql="SELECT a.appl_user_id USERID, a.appl_user_name USERNAME, to_char(b.login_date,'dd/mm/rrrr hh24:mi') LOGINDATE, (b.login_date + (SELECT (nvl(unlock_user_session_hrs,0) / 24) FROM sm_site_param WHERE site_id = 'DS') ) login_new_date, b.added_at_ws_no WORKSTATION  FROM sm_appl_user a, sm_appl_user_audit b WHERE a.appl_user_id = b.appl_user_id "+whereCond+" AND ( A.appl_user_id,b.login_date)IN(SELECT a.appl_user_id, MAX (b.login_date) FROM sm_appl_user a, sm_appl_user_audit b WHERE a.appl_user_id = b.appl_user_id  "+whereCond+" GROUP BY a.appl_user_id) AND (b.login_date + (SELECT (nvl(unlock_user_session_hrs,0) / 24) FROM sm_site_param WHERE site_id = 'DS')) <= SYSDATE ";
			
		

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next()){
				JSONObject jsonObj	= new JSONObject();
				
				String userID		= rs.getString("USERID")==null?"":rs.getString("USERID");
				String userName		= rs.getString("USERNAME")==null?"":rs.getString("USERNAME");
				String loginDate	= rs.getString("LOGINDATE")==null?"":rs.getString("LOGINDATE");
				String workStation	= rs.getString("WORKSTATION")==null?"":rs.getString("WORKSTATION");
			
				jsonObj.put("USERID",userID);
				jsonObj.put("USERNAME",userName);
				jsonObj.put("LOGINDATE",loginDate);
				jsonObj.put("WORKSTATION",workStation);
				arrJSON.add(jsonObj);
			}
			json.put("userListArr",arrJSON);
						
		}catch(Exception ex){
			System.err.println("Exception in getUserSessionDetails - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return json;
	}

	public static String getMultiLoginDetails(Connection con) throws Exception{
		Statement stmt		= null;
		ResultSet rs 		= null;
		String MULTIPLE_LOGIN_ALLOWED_YN	= "Y";

		try{

			String sysDateSql = "Select MULTIPLE_LOGIN_ALLOWED_YN from SM_SITE_PARAM";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sysDateSql);
			
			if(rs!=null && rs.next()){
				MULTIPLE_LOGIN_ALLOWED_YN = rs.getString("MULTIPLE_LOGIN_ALLOWED_YN")==null?"Y":rs.getString("MULTIPLE_LOGIN_ALLOWED_YN");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMultiLoginDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return MULTIPLE_LOGIN_ALLOWED_YN;
	}
//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020
	public static JSONObject getUserFacilityAccessYN(Connection con,String User_Id) throws Exception{
		Statement stmt=null;
		ResultSet rs 	= null;
		JSONObject jsonObj	= new JSONObject();
		String create_facility_yn	= "N";
		String create_user_yn ="N";
		try{
			String sql = "SELECT create_facility_yn, create_user_yn FROM sm_user_access_rights WHERE appl_user_id = '"+User_Id+"'";
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);
			if(rs!=null && rs.next()){
				create_facility_yn		= rs.getString("create_facility_yn")==null?"":rs.getString("create_facility_yn");
				create_user_yn		= rs.getString("create_user_yn")==null?"":rs.getString("create_user_yn");
				}
				jsonObj.put("create_facility_yn",create_facility_yn);
				jsonObj.put("create_user_yn",create_user_yn);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getUserFacilityAccessYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	} 

	/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
	public static JSONObject getSMSiteParamDetails(Connection con) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String region_prompt	= "";

		try{

			sql = "SELECT * FROM sm_site_param";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				region_prompt = checkForNull(rs.getString("region_prompt"));
			}

			jsonObj.put("region_prompt",region_prompt);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSMSiteParamDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
	
	/*Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2*/
	public static JSONObject getADAndEMUserYN(Connection con,String loginID) throws Exception{
		
		loginID						= java.net.URLDecoder.decode(loginID,"UTF-8");
		JSONObject jsonObj			= new JSONObject();
		PreparedStatement pstmt_ad	= null;
		ResultSet  rs_ad			= null;
		PreparedStatement pstmt_em	= null;
		ResultSet  rs_em			= null;
		String sql_ad				= "";
		String sql_em				= "";
		String active_dir_id		= "";
		String appl_user_id			= "";
		String ad_em_user_yn		= "N";

		try{
			
			sql_ad = " SELECT active_dir_id FROM sm_appl_user WHERE active_dir_id = '"+loginID+"' ";
			
			pstmt_ad = con.prepareStatement(sql_ad);
			rs_ad = pstmt_ad.executeQuery();
			
			if(rs_ad != null && rs_ad.next()){
				active_dir_id = rs_ad.getString("active_dir_id")==null?"":rs_ad.getString("active_dir_id");
			}

			if(!active_dir_id.equals("")){
				sql_em = " SELECT appl_user_id FROM sm_appl_user WHERE appl_user_id = '"+loginID+"' and active_dir_id is null ";
			
				pstmt_em = con.prepareStatement(sql_em);
				rs_em = pstmt_em.executeQuery();
				
				if(rs_em != null && rs_em.next()){
					appl_user_id = rs_em.getString("appl_user_id")==null?"":rs_em.getString("appl_user_id");
				}

				if(!appl_user_id.equals("")){
					ad_em_user_yn = "Y";
				}
			}

			jsonObj.put("ad_em_user_yn",ad_em_user_yn);
						
		}catch(Exception ex){
			System.err.println("Exception in getADAndEMUserYN - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt_ad !=null) pstmt_ad.close();
				if(pstmt_em !=null) pstmt_em.close();
				if(rs_ad !=null) rs_ad.close();
				if(rs_em !=null) rs_em.close();
			}
			catch(Exception fe){
			}
		}
		return jsonObj;
	}

	public static JSONObject getLinkedADUserDetails(Connection con,String loginID) throws Exception{
		
		loginID					= java.net.URLDecoder.decode(loginID,"UTF-8");
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet  rs			= null;
		String active_dir_id	= "";
		String appl_user_id		= "";
		String appl_user_paswd	= "";
		String appl_user_pin	= "";

		try{
			
			String sql = " SELECT active_dir_id, appl_user_id, app_password.decrypt (appl_user_password) AS appl_user_password, app_password.decrypt (pin_no) AS appl_user_pin FROM sm_appl_user WHERE active_dir_id = '"+loginID+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()){

				active_dir_id = rs.getString("active_dir_id")==null?"":rs.getString("active_dir_id");
				appl_user_id	= rs.getString("appl_user_id")==null?"":rs.getString("appl_user_id");
				appl_user_paswd = rs.getString("appl_user_password")==null?"":rs.getString("appl_user_password");
				appl_user_pin = rs.getString("appl_user_pin")==null?"":rs.getString("appl_user_pin");
			}

			jsonObj.put("active_dir_id",active_dir_id);
			jsonObj.put("appl_user_id",appl_user_id);
			jsonObj.put("appl_user_paswd",appl_user_paswd);	
			jsonObj.put("appl_user_pin",appl_user_pin);	
						
		}catch(Exception ex){
			System.err.println("Exception in getLinkedADUserDetails - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return jsonObj;
	}
	/*End ML-MMOH-CRF-1844.2*/

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString,String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
	}
	/*End AAKH-CRF-0128.1*/

}