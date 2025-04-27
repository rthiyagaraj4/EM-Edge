package eMR;

import java.sql.*;
import java.io.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public class MRHaadcolorConfigBean implements Serializable{
	
	public static String getHaadDiseaseCodeandDesc(Connection con) throws Exception{
		Statement stmt 	= null;
		ResultSet rs 	= null;
		JSONArray diseaseArrJson		= new JSONArray();
		JSONObject returnDataJsonObj	= new JSONObject();
		String diseaseId				= "";
		String diseaseName				= "";
		String colorCode				= "";
		
		try{
			String sql = "SELECT DISEASE_ID,DISEASE_NAME,COLOR_CODE FROM MR_HAAD_DISEASE_HDR WHERE EFF_STATUS ='E' order by DISEASE_ID asc";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs!=null && rs.next()){
				JSONObject jsonObj	= new JSONObject();
				diseaseId		= rs.getString("DISEASE_ID").equals(null)?"":rs.getString("DISEASE_ID");
				diseaseName		= rs.getString("DISEASE_NAME").equals(null)?"":rs.getString("DISEASE_NAME");
				colorCode		= rs.getString("COLOR_CODE").equals(null)?"":rs.getString("COLOR_CODE");
				jsonObj.put("DISEASE_ID",diseaseId);
				jsonObj.put("DISEASE_NAME",diseaseName);
				jsonObj.put("COLOR_CODE",colorCode);
				diseaseArrJson.add(jsonObj);
			}
			returnDataJsonObj.put("diseaseHDRList",diseaseArrJson);
			
			if(rs!=null)rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getHaadDiseaseCodeandDesc - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return returnDataJsonObj.toString();
	}
	
	public static String getHaadDiseaseDtls(Connection con,String dId,String locale) throws Exception{
		Statement stmt 	= null;
		ResultSet rs 	= null;
		JSONArray diseaseArrJson		= new JSONArray();
		JSONObject returnDataJsonObj	= new JSONObject();
		String diseaseId				= "";
		String termSetId				= "";
		String termCode					= "";
		String termSetDesc				= "";
		
		try{
			String sql = "SELECT DISEASE_ID,TERM_SET_ID,TERM_CODE, mr_get_desc.MR_TERM_SET(TERM_SET_ID,'"+locale+"',1) TERM_SET_DESC FROM MR_HAAD_DISEASE_DTLS WHERE DISEASE_ID ='"+dId+"' order by TERM_SET_ID,TERM_CODE asc";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs!=null && rs.next()){
				JSONObject jsonObj	= new JSONObject();
				diseaseId		= rs.getString("DISEASE_ID").equals(null)?"":rs.getString("DISEASE_ID");
				termSetId		= rs.getString("TERM_SET_ID").equals(null)?"":rs.getString("TERM_SET_ID");
				termCode		= rs.getString("TERM_CODE").equals(null)?"":rs.getString("TERM_CODE");
				termSetDesc		= rs.getString("TERM_SET_DESC").equals(null)?"":rs.getString("TERM_SET_DESC");
				
				jsonObj.put("DISEASE_ID",diseaseId);
				jsonObj.put("TERM_SET_ID",termSetId);
				jsonObj.put("TERM_CODE",termCode);
				jsonObj.put("TERM_SET_DESC",termSetDesc);
				diseaseArrJson.add(jsonObj);
			}
			returnDataJsonObj.put("diseaseDtlsList",diseaseArrJson);
			
			if(rs!=null)rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getHaadDiseaseDtls - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return returnDataJsonObj.toString();
	}



	public static String getTermSetList(Connection con){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	try{
	    	String sql = " select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc";
	    	pstmt = con.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	    	while(rs!=null && rs.next()){

	    		JSONObject jsonobj 				= new JSONObject();

	    		jsonobj.put("term_set_id",rs.getString("term_set_id"));
	    		jsonobj.put("term_set_desc",rs.getString("term_set_desc"));
	    		jsonArray.add(jsonobj);

	    	}
	    	json.put("termSetList",jsonArray);

			if(pstmt !=null) pstmt.close();
			if(rs !=null) rs.close();
			
			sql		= "SELECT DECODE (diag_code_scheme, '1', 'ICD10', '2', 'ICD9CM') scheme_desc,diag_code_scheme FROM mr_parameter";
			pstmt = con.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
			jsonArray = new JSONArray();
			if(rs!=null && rs.next()){
				JSONObject jsonobj1 				= new JSONObject();
	    		jsonobj1.put("scheme_desc",rs.getString("scheme_desc"));
	    		jsonobj1.put("diag_code_scheme",rs.getString("diag_code_scheme"));
	    		jsonArray.add(jsonobj1);
			}
			
			json.put("diagCodeScheme",jsonArray);
	    	returnStr		= json.toString();

    	}catch(Exception ex){
			System.err.println("Exception in getTermSetList - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}

    	return returnStr;
    }


/*Added by Rameswar on  29-06-2016 for AAKH-CRF-0083*/
public static String getHAADPlinecontext(Connection conn, String patient_id, String facility_id) throws Exception{
		PreparedStatement pstmt=null;
		ResultSet rs1=null;
		String result="";
		
		try{
			
			
				
			pstmt = conn.prepareStatement("Select mr_haad_dtls(?,?) from dual");

			
			pstmt.setString( 1, patient_id ) ;
			pstmt.setString( 2, facility_id ) ;
					
			rs1 = pstmt.executeQuery();
						
			if(rs1!=null && rs1.next()){
								
			result	= rs1.getString(1);
								
			}

			

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(rs1  != null) rs1.close();
				
			}catch(Exception ex){
				ex.printStackTrace();
			}

		}
		return result;
		
	}

	

	}


