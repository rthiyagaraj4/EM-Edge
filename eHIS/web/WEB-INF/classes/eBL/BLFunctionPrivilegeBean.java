/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.Serializable;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlAdapter;

public class BLFunctionPrivilegeBean extends BlAdapter implements Serializable {

	private String custCode = "";
	private String custDesc = "";
	private String custGrpCode = "";
	private String custGrpDesc = "";
	private String policyCode = "";
	private String policyDesc = "";
	private String effFromDate = "";
	private String effToDate = "";
	private String effStatus = "";
	private String status = "";
	private String allowable = "";
	
	private String userType = "";
	private String userCode = "";
	private String functionId = "";
	private String privilegeCode = "";	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

	public String getAllowable() {
		return allowable;
	}

	public void setAllowable(String allowable) {
		this.allowable = allowable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private HashMap<String, ArrayList<BLFunctionPrivilegeBean>> payerDtlMap = null;
	private HashMap<String, String> restrictionMap = null;

	public HashMap<String, String> getRestrictionMap() {
		return restrictionMap;
	}

	public void setRestrictionMap(HashMap<String, String> restrictionMap) {
		this.restrictionMap = restrictionMap;
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

	public String getEffFromDate() {
		return effFromDate;
	}

	public void setEffFromDate(String effFromDate) {
		this.effFromDate = effFromDate;
	}

	public String getEffToDate() {
		return effToDate;
	}

	public void setEffToDate(String effToDate) {
		this.effToDate = effToDate;
	}

	public String getEffStatus() {
		return effStatus;
	}

	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
	}

	public HashMap<String, ArrayList<BLFunctionPrivilegeBean>> getPayerDtlMap() {
		return payerDtlMap;
	}

	public void setPayerDtlMap(
			HashMap<String, ArrayList<BLFunctionPrivilegeBean>> payerDtlMap) {
		this.payerDtlMap = payerDtlMap;
	}
	
	public void clearAll(){
		custCode = "";
		custDesc = "";
		custGrpCode = "";
		custGrpDesc = "";
		policyCode = "";
		policyDesc = "";
		effFromDate = "";
		effToDate = "";
		effStatus = "";
		
		status = "";
		allowable = "";
		
		userType = "";
		userCode = "";
		functionId = "";
		privilegeCode = "";
		
		restrictionMap = null;
		payerDtlMap = null;
	}
	
	public LinkedHashMap getPolicyCustDetails(String facility_id,String userType,String userCode,String functionId,String privilegeCode,String effectiveDate,
											String payerGroup,String payer,String policy,String fromDate,String toDate,int from, int to,String allowableYn){

		Connection 								connection 							= 	null;		
		CallableStatement   					callableStatement					= 	null;
		BLFunctionPrivilegeBean					functionPrivilegeBean				=	null;
		LinkedHashMap							functionPrivilegeMap				=	null;
		String									sql									=	null;
		Array									listArray							=	null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			connection 							=	ConnectionManager.getConnection();
			functionPrivilegeMap	=	new LinkedHashMap();
			sql									=	"{call  blpolicyuseraccessdtls.get_bl_policy_cust_dtls(?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement 					= 	connection.prepareCall(sql);
			callableStatement.setString(1,facility_id);
			callableStatement.setString(2,userType);
			callableStatement.setString(3,userCode);
			callableStatement.setString(4,functionId);
			callableStatement.setString(5,privilegeCode);		
			callableStatement.setString(6,payerGroup);
			callableStatement.setString(7,payer); 
			callableStatement.setString(8,policy);
			allowableYn=null;
			callableStatement.setString(9,allowableYn);
			callableStatement.setInt(10, from);
			callableStatement.setInt(11, to);
			
			if((effectiveDate == null) || ("".equals(effectiveDate))){
				callableStatement.setString(12, null);
			}
			else{
				Date fromDt = new Date(sdf.parse(effectiveDate).getTime());
				callableStatement.setDate(12, fromDt);
			}

			callableStatement.registerOutParameter(13,java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(14, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");  
			callableStatement.registerOutParameter(15, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(16, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(17, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(18, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(19, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(20, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(21, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			callableStatement.registerOutParameter(22, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");  // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT
			
			callableStatement.execute(); 
			functionPrivilegeMap.put("totalRecords",callableStatement.getInt(13));
			for(int k=14;k<23;k++)
			{
				listArray = callableStatement.getArray (k);  
	            Object[] values = (Object[]) listArray.getArray();  
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            { 
		           
			            if(functionPrivilegeMap.containsKey(i))
		            	{
			            	functionPrivilegeBean = (BLFunctionPrivilegeBean) functionPrivilegeMap.get(i);
			            	switch(k)
		            		{
			            		case 14: 	functionPrivilegeBean.setCustGrpCode(((String)values[i]));
	    									break;
				    			case 15: 	functionPrivilegeBean.setCustGrpDesc((String)values[i]);
											break;
				    			case 16: 	functionPrivilegeBean.setCustCode((String)values[i]);
											break;
				    			case 17: 	functionPrivilegeBean.setCustDesc((String)values[i]);
											break;
				    			case 18: 	functionPrivilegeBean.setPolicyCode((String)values[i]);
											break;
				    			case 19: 	functionPrivilegeBean.setPolicyDesc((String)values[i]);
											break;
				    			case 20: 	functionPrivilegeBean.setEffFromDate((String)values[i]);
											break;
				    			case 21: 	functionPrivilegeBean.setEffToDate((String)values[i]);
											break;
				    			case 22: 	functionPrivilegeBean.setAllowable((String)values[i]);
											break;															    			
								default:	
		    				}
		            	}
		            	else
		            	{	
		            		functionPrivilegeBean = new BLFunctionPrivilegeBean();
		            		switch(k)
		            		{
			            		case 14: 	functionPrivilegeBean.setCustGrpCode(((String)values[i]));
	    									break;
				    			case 15: 	functionPrivilegeBean.setCustGrpDesc((String)values[i]);
											break;
				    			case 16: 	functionPrivilegeBean.setCustCode((String)values[i]);
											break;
				    			case 17: 	functionPrivilegeBean.setCustDesc((String)values[i]);
											break;
				    			case 18: 	functionPrivilegeBean.setPolicyCode((String)values[i]);
											break;
				    			case 19: 	functionPrivilegeBean.setPolicyDesc((String)values[i]);
											break;
				    			case 20: 	functionPrivilegeBean.setEffFromDate((String)values[i]);
											break;
				    			case 21: 	functionPrivilegeBean.setEffToDate((String)values[i]);
											break;
				    			case 22: 	functionPrivilegeBean.setAllowable((String)values[i]);
											break;
								default:	
		    				}
		            		functionPrivilegeMap.put(i, functionPrivilegeBean);
		            	}
		            }    
				}     
	         }
			
			
			if(callableStatement!=null) callableStatement.close();	
			
		}catch(Exception e){
			System.out.println("Exception in getPolicyCustDetails in BLFunctionPrivilegesBean "+e); 
			e.printStackTrace();
			}
			finally
			{
				
				
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		
		return functionPrivilegeMap;
		
	
	}
}
