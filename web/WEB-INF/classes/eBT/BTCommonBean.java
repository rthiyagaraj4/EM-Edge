/*Created by Ashwini on 08-May-2018 for ML-MMOH-CRF-0589*/
package eBT;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.* ;
import javax.servlet.jsp.PageContext;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import webbeans.eCommon.*;

public class BTCommonBean implements Serializable{

	/*Added by Ashwini on 08-May-2018 for ML-MMOH-CRF-0589*/
	public static JSONArray getTransferToReferral(Connection con, String Language_Id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
	
		try{

			String Sql = " SELECT referral_code, long_desc FROM am_referral_lang_vw WHERE NVL (eff_status, 'D') = 'E' AND language_id = ? ORDER BY 2 ";
		
			pstmt = con.prepareStatement(Sql);
			pstmt.setString(1,Language_Id);
			rs = pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String referral_code	= rs.getString("referral_code")==null?"":rs.getString("referral_code");
				String referral_desc	= rs.getString("long_desc")==null?"":rs.getString("long_desc");
				
				jsonObj.put("referral_code",referral_code);
				jsonObj.put("referral_desc",referral_desc);
				
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTransferToReferral - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static JSONObject getLoginUser(Connection con, String login_user) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();

		try{
			String sql = "SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,login_user);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

					String loginUserName = rs.getString("appl_user_name");
					jsonObj.put("loginUserName",loginUserName);

			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getLoginUser - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONArray getTransferReason(Connection con, String Language_Id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
	
		try{

			String Sql = " SELECT contact_reason, contact_reason_code FROM am_contact_reason_lang_vw WHERE NVL (eff_status, 'D') = 'E' AND NVL (unit_transfer_reason_yn, 'N') = 'Y' AND language_id = ? ORDER BY 1 ";
		
			pstmt = con.prepareStatement(Sql);
			pstmt.setString(1,Language_Id);
			rs = pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String reason_code	= rs.getString("contact_reason_code")==null?"":rs.getString("contact_reason_code");
				String reason_desc	= rs.getString("contact_reason")==null?"":rs.getString("contact_reason");
				
				jsonObj.put("reason_code",reason_code);
				jsonObj.put("reason_desc",reason_desc);
				
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTransferReason - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End ML-MMOH-CRF-0589*/
}