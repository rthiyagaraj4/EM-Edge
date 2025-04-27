/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import javax.ejb.SessionContext;
import javax.servlet.http.HttpSession;

import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;
/**
 * Invokes the invoke_banner proc
 * @author Boopathy
 *
 */
public class InvokeBannerBean extends BlAdapter implements Serializable
{
	protected String formatCode;
	protected String formatDescription;
	protected String functionId;
	protected String funcDesc;
	protected String rightsType;
	protected String rightsCode;
	protected String billingGroupID;
	protected String billingGroupDesc;
	protected String episodeType;
	protected String effFrom;
	protected String effTo;
	protected String customerGroupCode;
	protected String customerCode;
	protected String patientId;
	protected String episodeId;
	
	protected String cloumn1;
	protected String cloumn1Value;
	protected String cloumn2;
	protected String cloumn2Value;
	protected String cloumn3;
	protected String cloumn3Value;
	
	
	
	
	/**
	 * 
	 */
	public InvokeBannerBean()
	{	
		//System.out.println("Bean Initialized");
	}

	
	public String getFormatCode() {
		return formatCode;
	}

	public void setFormatCode(String formatCode) {
		this.formatCode = formatCode;
	}

	public String getFormatDescription() {
		return formatDescription;
	}

	public String getFunctionId() {
		return functionId != null ? functionId : "";
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getFuncDesc() {
		return funcDesc != null ? funcDesc : "";
	}

	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}

	public String getRightsType() {
		return rightsType != null ? rightsType : "";
	}

	public void setRightsType(String rightsType) {
		this.rightsType = rightsType;
	}

	public String getRightsCode() {
		return rightsCode != null ? rightsCode : "";
	}

	public void setRightsCode(String rightsCode) {
		this.rightsCode = rightsCode;
	}

	public String getBillingGroupID() {
		return billingGroupID != null ? billingGroupID : "";
	}

	public void setBillingGroupID(String billingGroupID) {
		this.billingGroupID = billingGroupID;
	}

	public String getBillingGroupDesc() {
		return billingGroupDesc != null ? billingGroupDesc : "";
	}

	public void setBillingGroupDesc(String billingGroupDesc) {
		this.billingGroupDesc = billingGroupDesc;
	}

	public String getEpisodeType() {
		return episodeType != null ? episodeType : "";
	}

	public void setEpisodeType(String episodeType) {
		this.episodeType = episodeType;
	}

	public String getEffFrom() {
		return effFrom != null ? effFrom : "";
	}

	public void setEffFrom(String effFrom) {
		this.effFrom = effFrom;
	}

	public String getEffTo() {
		return effTo != null ? effTo : "";
	}

	public void setEffTo(String effTo) {
		this.effTo = effTo;
	}

	public void setFormatDescription(String formatDescription) {
		this.formatDescription = formatDescription;
	}

	

	public String getCustomerGroupCode() {
		return customerGroupCode;
	}

	public void setCustomerGroupCode(String customerGroupCode) {
		this.customerGroupCode = customerGroupCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}

	public String getCloumn1() {
		return cloumn1;
	}

	public void setCloumn1(String cloumn1) {
		this.cloumn1 = cloumn1;
	}

	public String getCloumn1Value() {
		return cloumn1Value;
	}

	public void setCloumn1Value(String cloumn1Value) {
		this.cloumn1Value = cloumn1Value;
	}

	

	public String getCloumn2() {
		return cloumn2;
	}

	public void setCloumn2(String cloumn2) {
		this.cloumn2 = cloumn2;
	}

	public String getCloumn2Value() {
		return cloumn2Value;
	}

	public void setCloumn2Value(String cloumn2Value) {
		this.cloumn2Value = cloumn2Value;
	}

	public String getCloumn3() {
		return cloumn3;
	}

	public void setCloumn3(String cloumn3) {
		this.cloumn3 = cloumn3;
	}

	public String getCloumn3Value() {
		return cloumn3Value;
	}

	public void setCloumn3Value(String cloumn3Value) {
		this.cloumn3Value = cloumn3Value;
	}

	public void clearBean()
	{
		rightsType 			=  "";         
		rightsCode 			=  "";         
		billingGroupID 		=  ""; 
		billingGroupDesc 	=  ""; 
		episodeType 		=  "";         
		effFrom 			=  "";         
		effTo 				=  "";                 
		customerGroupCode 	=  ""; 
		customerCode 		=  "";         
		patientId 			=  "";         
		episodeId 			=  "";         
		                                             
		cloumn1 			=  "";         
		cloumn1Value 		=  "";         
		cloumn2 			=  "";         
		cloumn2Value 		=  "";         
		cloumn3 			=  "";         
		cloumn3Value 		=  "";         

	}
	
				
			
	/**
	 * @param tabdata
	 * @return HashMap
	 * Invokes the invoke_banner proc
	 */
	public java.util.HashMap invokeBanner(java.util.HashMap tabdata) //throws Exception
	{
		
		Connection 			connection = null;
		CallableStatement 	cstmt 										= 	null;
		String 				locale 										= 	"";
		Array 				arr 										= 	null;
		ArrayList 			bannerList									=	null;
		String[]			strAr										=	null;
		HashMap				bannerListMap								=	null;
		InvokeBannerBean	invokeBannerBean							=	null;   
		StringBuffer 		sys_err 									=   null;
		String		 		user_id 									=   null;
		String		 		facility_id 								=   null;
		String 				invokeBannerSQL								=	null;
		

		try {
					facility_id 					= 	(String) tabdata.get("facility_id");
					sys_err 						= 	new StringBuffer("") ;
					connection						=  	getConnection();
					bannerListMap					=	new HashMap();
					user_id 						= 	(String) tabdata.get("login_user");
					locale 							= 	(String) tabdata.get("locale");
					if (user_id == null)
						user_id = "";
					if (locale == null)
						locale = "en";
					
					invokeBannerSQL = "{ call   IBAEHIS.BLBANNERDTLS.INVOKE_BANNER (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					cstmt = connection.prepareCall(invokeBannerSQL);
					
				/*	cstmt.setString(1, facility_id);
					cstmt.setString(2, "ALLEN");
					cstmt.setString(3, null);
					cstmt.setString(4, "RS_LEAVE_DET");
					cstmt.setString(5, "BL09001268");
					cstmt.setString(6, "O");
					cstmt.setString(7, "10013205");
					cstmt.setString(8, "1");   
					cstmt.setString(9, "CSBG");
					cstmt.setString(10, "01");
					cstmt.setString(11, "01-00001");
					cstmt.setString(12, locale);  */
				
					
					
					cstmt.setString(1, facility_id);
					cstmt.setString(2, (String)tabdata.get("userid"));
					cstmt.setString(3, (String)tabdata.get("userrespid"));
					cstmt.setString(4, (String)tabdata.get("functionid"));
					cstmt.setString(5, (String)tabdata.get("patientid"));
					cstmt.setString(6, (String)tabdata.get("episodetype"));
					cstmt.setString(7, (String)tabdata.get("episodeid"));
					cstmt.setString(8, (String)tabdata.get("visitid"));   
					cstmt.setString(9, (String)tabdata.get("blnggrpid"));
					cstmt.setString(10, (String)tabdata.get("custgroupcode"));
					cstmt.setString(11, (String)tabdata.get("custcode"));
					cstmt.setString(12, locale);  
					
					cstmt.registerOutParameter(13,java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					cstmt.registerOutParameter(14,java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					cstmt.registerOutParameter(15,java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					cstmt.registerOutParameter(16,java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					cstmt.registerOutParameter(17,java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					cstmt.registerOutParameter(18,java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					
					cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
					
					
					cstmt.execute();

					System.err.println("Error Info");	
					System.err.println(cstmt.getString(19));
					System.err.println(cstmt.getString(20));
					System.err.println(cstmt.getString(21));
					for(int k=13;k<19;k++)
					{
						arr = cstmt.getArray (k); 
						System.out.println("arr in INVOKE BANNER:::::: "+arr);    
			            Object[] values = (Object[]) arr.getArray(); 
			            for (int i=0; i < values.length; i++)                 
			            {
			            	System.out.println("arr in INVOKE BANNER:K:::"+k+"::(values["+i+"]::: "+values[i]);
			            	String key =i+"-"+k;
		            		if(bannerListMap.containsKey(i))
			            	{
		            			invokeBannerBean = (InvokeBannerBean) bannerListMap.get(i);
			            		switch(k)
			            		{
			            			case 13: 	invokeBannerBean.setCloumn1(values[i].toString());
			            						break;
			            			case 14: 	invokeBannerBean.setCloumn1Value(values[i].toString());
		        								break;
			            			case 15: 	invokeBannerBean.setCloumn2(values[i].toString());
		        								break;
			            			case 16: 	invokeBannerBean.setCloumn2Value(values[i].toString());
		        								break;
			            			case 17: 	invokeBannerBean.setCloumn3(values[i].toString());
		        								break;
			            			case 18: 	invokeBannerBean.setCloumn3Value((values[i].toString()));   
		        								break;
			            			default:	
		        				}
			            	}
			            	else
			            	{	
			            		invokeBannerBean = new InvokeBannerBean();
			            		switch(k)
			            		{
				            		case 13: 	invokeBannerBean.setCloumn1(values[i].toString());
            									break;
			            			case 14: 	invokeBannerBean.setCloumn1Value(values[i].toString());
			    								break;
			            			case 15: 	invokeBannerBean.setCloumn2(values[i].toString());
			    								break;
			            			case 16: 	invokeBannerBean.setCloumn2Value(values[i].toString());
			    								break;
			            			case 17: 	invokeBannerBean.setCloumn3(values[i].toString());
			    								break;
			            			case 18: 	invokeBannerBean.setCloumn3Value((values[i].toString()));   
			    								break;
		        					default:	
		        				}
			            		bannerListMap.put(i, invokeBannerBean);
			            	}
			            }
			            
					}   
					
					
				
					cstmt.close();

					
			  
					System.out.println("IN InvokeBannerBean invokeBanner::::::::"+bannerListMap);
					System.out.println("IN InvokeBannerBean invokeBanner:::::::"+bannerListMap.size());
					Iterator iterator= bannerListMap.keySet().iterator();
					while(iterator.hasNext())
					{
						
						int key =    (Integer)iterator.next();
						System.out.println("IN invokeBanner key:::::::"+key);
						invokeBannerBean = (InvokeBannerBean) bannerListMap.get(key);
							System.out.println("INDEX::: "+key+" ::::COLUMN1::::::::::: 		"+invokeBannerBean.getCloumn1());
							System.out.println("INDEX::: "+key+" ::::COLUMN1VALUE:::::: 		"+invokeBannerBean.getCloumn1Value());
							System.out.println("INDEX::: "+key+" ::::COLUMN2::::::::::: 		"+invokeBannerBean.getCloumn2());
							System.out.println("INDEX::: "+key+" ::::COLUMN2VALUE:::::: 		"+invokeBannerBean.getCloumn2Value());
							System.out.println("INDEX::: "+key+" ::::COLUMN3::::::::::: 		"+invokeBannerBean.getCloumn3());
							System.out.println("INDEX::: "+key+" ::::COLUMN3VALUE:::::: 		"+invokeBannerBean.getCloumn3Value());
						
					}
			
		
	} catch (Exception e) {    
		sys_err.append("invokeBanner Exception:" + e);
		System.out.println("invokeBanner Exception:" + e);
		e.printStackTrace();
	}

	finally {
		try {
			ConnectionManager.returnConnection(connection);
			if (cstmt != null)
				cstmt.close();
			
		} catch (Exception r) {
			r.printStackTrace();
		}
	}
		
		return bannerListMap;
	}
	

	
		 
	  
}
