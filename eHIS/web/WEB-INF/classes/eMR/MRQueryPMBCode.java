/*Created by Thamizh selvi on 06/10/2016 for GDOH-CRF-0082*/
package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public class MRQueryPMBCode implements Serializable{
	
	StringBuffer ordSb			= new StringBuffer();
	public static JSONObject getPMBandTermCode(Connection con,String pmbCode,String pmbCode_Desc,String termCode,String termCode_Desc,StringBuffer ordSb,int currentPageNo) throws Exception{
		PreparedStatement pstmt=null;
		ResultSet rs 	= null;
		JSONObject json	= new JSONObject();
		JSONArray pmbArrJSON		= new JSONArray();
		StringBuffer sqlSb			= new StringBuffer();
		int recordsPerPage 	= 16;
		int noOfRecs = 0;
		int noOfRecords 			= 0;
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;
		
		if(currentPageNo!=1){
				from		= (currentPageNo - 1) * recordsPerPage +1;
				to			= (from -1) + recordsPerPage;
		}

		try{

			
			sqlSb.append("select * from (SELECT  results.*, rownum as rcnt FROM (");
			
			sqlSb.append("SELECT COUNT (*) OVER () noOfRecords,PMB_CODE,PMB_DESC,TREATMENT_DESC,TERM_CODE,TERM_SUPPORT_CODE,TERM_DESC FROM MR_PMB_CODE WHERE upper(PMB_CODE) like upper('"+pmbCode+"%') and upper(pmb_desc) like upper('"+pmbCode_Desc+"%') and upper(term_code) like upper('"+termCode+"%') and upper(term_desc) like upper('"+termCode_Desc+"%')");
	
			sqlSb.append(" order by "+ordSb+" ");


			
			sqlSb.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");
			
			pstmt = con.prepareStatement(sqlSb.toString());
			rs	 = pstmt.executeQuery();

			while(rs!=null && rs.next()){
				JSONObject jsonObj	= new JSONObject();
				noOfRecs	= rs.getInt("noOfRecords");
				String PMB_Code		= rs.getString("PMB_CODE")==null?"":rs.getString("PMB_CODE");
				String PMBDesc	= rs.getString("PMB_DESC")==null?"":rs.getString("PMB_DESC");
				String TreatmentDesc	= rs.getString("TREATMENT_DESC")==null?"":rs.getString("TREATMENT_DESC");
				String Term_Code	= rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
				String supp_Code = rs.getString("TERM_SUPPORT_CODE")==null?"":rs.getString("TERM_SUPPORT_CODE");
				String TermDesc	= rs.getString("TERM_DESC")==null?"":rs.getString("TERM_DESC");
			
				jsonObj.put("PMB_CODE",PMB_Code);
				jsonObj.put("PMB_DESC",PMBDesc);
				jsonObj.put("TREATMENT_DESC",TreatmentDesc);
				jsonObj.put("TERM_CODE",Term_Code);
				jsonObj.put("SUPPORT_CODE",supp_Code);
				jsonObj.put("TERM_DESC",TermDesc);
				
				pmbArrJSON.add(jsonObj);
			}

			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs){
				to	= noOfRecs;
			}
			
			json.put("PMBArray",pmbArrJSON);
			json.put("currentPageNo", currentPageNo);
			json.put("noOfRecords", noOfRecs);
			json.put("noOfPages", noOfPages);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPMBandTermCode - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
/*Below line added for this CRF GDOH-CRF-0082 User Story2 (Record Diagnosis)*/
public static String getPMBCode(Connection con, String diagcode){
	 Statement stmt1=null;
	 ResultSet rs=null;
     String diad_pmb_code="";	 
	try{
	     String pmbSqlString="select pmb_code from mr_pmb_code where term_code='"+diagcode+"'";
		 stmt1=con.createStatement();
		 rs = stmt1.executeQuery(pmbSqlString);
		 if(rs!=null && rs.next()){
		 diad_pmb_code=rs.getString("pmb_code")==null?"":rs.getString("pmb_code");
		 }           			
		if(rs!=null)rs.close();
		if(stmt1!=null)stmt1.close();	
	}catch(Exception ex1){
	 ex1.printStackTrace();
	}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt1!=null)stmt1.close();
			}catch(Exception ex2){				
				ex2.printStackTrace();
			}
	}
	return diad_pmb_code;
	}
public static int getSupportDignosisWithPMB(Connection con, String diagcode,String supportdigcode){
	 Statement stmt=null;
	 ResultSet rs=null;     
     int supportCount=0;	 
	try{
	     String PMBCheckQuery="select pmb_code from mr_pmb_code where term_code='"+diagcode+"' and term_support_code in("+supportdigcode+")";
		 stmt=con.createStatement();		
		 rs = stmt.executeQuery(PMBCheckQuery) ;	
		 while(rs!=null && rs.next()){
			supportCount++;					 
		}         			
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
	}catch(Exception ex4){
	 ex4.printStackTrace();
	}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex5){				
				ex5.printStackTrace();
			}
	}
	return supportCount;
	}		
	//GDOH-CRF-0082 User Story2
}