/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
* Java Bean for Search of Code, Code Type and Description
*/
package eST;

//import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import eST.Common.StAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class CommonSearchBean extends eST.Common.StAdapter implements java.io.Serializable {

	// Table Column Variables 
	private String code;
	private String type_code;
	private String desc;
	private boolean result;

	public CommonSearchBean() {
	}

	public void setCode(String code) {

		 this.code = code;
	}

	public String getCode() {
		 return this.code;
	}

	public void setType_code(String type_code) {
		 this.type_code = type_code;
	}

	public String getType_code() {
		 return this.type_code;
	}

	public void setDesc(String desc) {
		 this.desc = desc;
	}

	public String getDesc() {
		 return desc;
	}

	public void setResult(boolean result) {
		 this.result = result;
	}

	public boolean getResult() {
		 return this.result;
	}

	public void clear(){
		super.clear();
		desc="";
		code="";
		type_code="";
	}

	public void execute(int qry) {
		String sql  =null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		try {
            connection = getConnection();
			switch (qry) {
				case 1:
						sql = (String) eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_SEARCH_SELECT");
					break;
				default :
					break;
			}
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, getCode());
			if (qry == 2) {
				pstmt.setString(2, getType_code());
			}
            resultSet = pstmt.executeQuery();
			result = false;

            if (resultSet != null && resultSet.next()) {
				result = true;
				setCode (resultSet.getString("code"));
				setDesc (resultSet.getString("description"));
			}
        }
		catch (Exception e) {
            e.printStackTrace();
        }
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
	}
public boolean IsPromptForFinalizeRequired(String trn_type,String store_code) throws Exception{	
		
	String getColumn 	= "";
	boolean result 		= false;
	
	try {	
		
			if(trn_type.equals("GRN")){				
				getColumn = "GRN_FINALIZE_PROMPT_YN";				
			}else if(trn_type.equals("RTV")){
				getColumn = "RTV_FINALIZE_PROMPT_YN";
			}else if(trn_type.equals("ISS")){
				getColumn = "ISS_FINALIZE_PROMPT_YN";
			}else if(trn_type.equals("REQ")){
				getColumn = "REQ_AUTHORIZE_PROMPT_YN";
			}else if(trn_type.equals("MFG")){
				getColumn = "MFG_FINALIZE_PROMPT_YN";
			}else if(trn_type.equals("TFR")){
				getColumn = "TFR_FINALIZE_PROMPT_YN";
			}else if(trn_type.equals("ADJ")){
				getColumn = "ADJ_FINALIZE_PROMPT_YN";
			}else if(trn_type.equals("SAL")){
				getColumn = "SAL_AUTHORIZE_PROMPT_YN";
			}else if(trn_type.equals("SRT")){
				getColumn = "SRT_FINALIZE_PROMPT_YN";
			}else if(trn_type.equals("URG")){
				getColumn = "URG_FINALIZE_PROMPT_YN";
			}else if(trn_type.equals("RET")){
				getColumn = "RET_FINALIZE_PROMPT_YN";
			}
			else if(trn_type.equals("PRT")){//Added for ML-MMOH-CRF-0448 B.Badmavathi
				getColumn = "PRT_FINALIZE_PROMPT_YN";
			}
			
			String stArray[] = { store_code, getLoginById() };
			//String sql = "SELECT GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN FROM ST_USER_ACCESS_FOR_STORE WHERE STORE_CODE = ? AND USER_ID = ?";//Modified for ML-MMOH-CRF-0448 B.Badmavathi
			String sql = "SELECT GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,PRT_FINALIZE_PROMPT_YN FROM ST_USER_ACCESS_FOR_STORE WHERE STORE_CODE = ? AND USER_ID = ?";
			
			String prompt_for_finalize_yn = checkForNull((String)fetchRecord(sql,stArray).get(getColumn),"N");	
			result = prompt_for_finalize_yn.equals("Y");		
	
     
        } catch (Exception e) {
            e.printStackTrace();
        }		
	return result ; 
}
}
