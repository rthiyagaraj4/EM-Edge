/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
 */
 
package eBL;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;

import webbeans.eCommon.ConnectionManager;

public class BLFinDtlsBGPayerBean {
	
	private String facilityId = "";
	private String blngGrpCode = "";
	private String blngGrpDesc = "";
	private String custCode = "";
	private String custDesc = "";
	private String custGrpCode = "";
	private String custGrpDesc = "";
	private String policyCode = "";
	private String policyDesc = "";
	private String priority = "";
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getBlngGrpCode() {
		return blngGrpCode;
	}
	public void setBlngGrpCode(String blngGrpCode) {
		this.blngGrpCode = blngGrpCode;
	}
	public String getBlngGrpDesc() {
		return blngGrpDesc;
	}
	public void setBlngGrpDesc(String blngGrpDesc) {
		this.blngGrpDesc = blngGrpDesc;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustDesc() {
		return custDesc;
	}
	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}
	public String getCustGrpCode() {
		return custGrpCode;
	}
	public void setCustGrpCode(String custGrpCode) {
		this.custGrpCode = custGrpCode;
	}
	public String getCustGrpDesc() {
		return custGrpDesc;
	}
	public void setCustGrpDesc(String custGrpDesc) {
		this.custGrpDesc = custGrpDesc;
	}
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public String getPolicyDesc() {
		return policyDesc;
	}
	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}
	
	public LinkedHashMap getPayerDetails(String facilityId, String blngGrpId,String custCode, String custGrpCode,String policyCode,String episodeType,int from,int to){
		Connection con = null;
		CallableStatement cstmt = null;
		BLFinDtlsBGPayerBean bgPayerBean = null;
		LinkedHashMap bgPayerMap = new LinkedHashMap();
		Array listArray = null;
		
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall("{ call blpayersfindtls.get_payer_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, facilityId);
			cstmt.setString(2, blngGrpId);
			cstmt.setString(3, custCode);
			cstmt.setString(4, custGrpCode);
			cstmt.setString(5, policyCode);
			cstmt.setString(6, episodeType);
			cstmt.setInt(7, from);
			cstmt.setInt(8, to);
			cstmt.registerOutParameter(9,java.sql.Types.INTEGER);
			cstmt.registerOutParameter(10, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");  
			cstmt.registerOutParameter(11, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(12, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(13, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(14, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(15, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(16, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(17, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(18, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.registerOutParameter(19, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			cstmt.execute();
			bgPayerMap.put("totalRecords",cstmt.getInt(9));
			for(int k=10;k<=19;k++){
				listArray = cstmt.getArray (k); 
				 Object[] values = (Object[]) listArray.getArray(); 
				 if(values!=null)
		            {
		            	for (int i=0; i < values.length; i++)                 
			            {
		            		if(bgPayerMap.containsKey(i)){
		            			bgPayerBean = (BLFinDtlsBGPayerBean) bgPayerMap.get(i);
		            			switch(k){
		            				case 10:
		            					bgPayerBean.setFacilityId((String)values[i]);
		            					break;
		            				case 11:
		            					bgPayerBean.setBlngGrpCode((String)values[i]);
		            					break;
		            				case 12:
		            					bgPayerBean.setBlngGrpDesc((String)values[i]);
		            					break;
									case 13:
										bgPayerBean.setCustCode((String)values[i]);
										break;
									case 14:
										bgPayerBean.setCustDesc((String)values[i]);
										break;
									case 15:
										bgPayerBean.setPolicyCode((String)values[i]);
										break;
									case 16:
										bgPayerBean.setPolicyDesc((String)values[i]);
										break;
									case 17:
										bgPayerBean.setCustGrpCode((String)values[i]);
										break;
									case 18:
										bgPayerBean.setCustGrpDesc((String)values[i]);
										break;
									case 19:
										bgPayerBean.setPriority(String.valueOf(values[i]));
										break;
		            			}
		            		}
		            		else{
		            			bgPayerBean = new BLFinDtlsBGPayerBean();
		            			switch(k){
	            				case 10:
	            					bgPayerBean.setFacilityId((String)values[i]);
	            					break;
	            				case 11:
	            					bgPayerBean.setBlngGrpCode((String)values[i]);
	            					break;
	            				case 12:
	            					bgPayerBean.setBlngGrpDesc((String)values[i]);
	            					break;
								case 13:
									bgPayerBean.setCustCode((String)values[i]);
									break;
								case 14:
									bgPayerBean.setCustDesc((String)values[i]);
									break;
								case 15:
									bgPayerBean.setPolicyCode((String)values[i]);
									break;
								case 16:
									bgPayerBean.setPolicyDesc((String)values[i]);
									break;
								case 17:
									bgPayerBean.setCustGrpCode((String)values[i]);
									break;
								case 18:
									bgPayerBean.setCustGrpDesc((String)values[i]);
									break;
								case 19:
									bgPayerBean.setPriority(String.valueOf(values[i]));
									break;
		            			}
		            			bgPayerMap.put(i, bgPayerBean);
		            		}
			            }
		            }
			}
		}
		catch(Exception e){
			System.err.println("Exception in BG Payer Map -> "+e); 
			e.printStackTrace();
		}
		finally
		{
			try{
			//cstmt = null; //commented V210416
			if(cstmt!=null) cstmt.close(); //Added for V210416
			ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("exception in blfindtlsbgpayerbean:"+e);
				e.printStackTrace();
			}			
		}
		return bgPayerMap;
	}
}
