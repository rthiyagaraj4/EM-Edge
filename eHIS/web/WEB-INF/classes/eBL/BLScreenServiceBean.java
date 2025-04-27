/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
 */
package eBL;

import java.io.Serializable;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import eBL.Common.BlAdapter;

public class BLScreenServiceBean extends  BlAdapter implements Serializable{
	
	protected String 		screeningCategoryCode						= 	"";
	protected String		screeningCategoryDesc						= 	"";
	protected String 		screeningApplicableQty						= 	"";
	protected String		screeningApplicableAmt						= 	"";
	protected String 		screeningAvailedQty							= 	"";
	protected String		screeningAvailedAmt							= 	"";
	protected String 		screeningBalanceQty							= 	"";
	protected String		screeningBalanceAmt							= 	"";
	protected String 		saveIdValue									= 	"";
	protected ArrayList		saveIdValueList								= 	null;

	/**
	 * @return the screeningCategoryCode
	 */
	public String getScreeningCategoryCode() {
		return screeningCategoryCode;
	}

	/**
	 * @param screeningCategoryCode the screeningCategoryCode to set
	 */
	public void setScreeningCategoryCode(String screeningCategoryCode) {
		this.screeningCategoryCode = screeningCategoryCode;
	}

	/**
	 * @return the screeningCategoryDesc
	 */
	public String getScreeningCategoryDesc() {
		return screeningCategoryDesc;
	}

	/**
	 * @param screeningCategoryDesc the screeningCategoryDesc to set
	 */
	public void setScreeningCategoryDesc(String screeningCategoryDesc) {
		this.screeningCategoryDesc = screeningCategoryDesc;
	}

	/**
	 * @return the screeningApplicableQty
	 */
	public String getScreeningApplicableQty() {
		return screeningApplicableQty;
	}


	/**
	 * @param screeningApplicableQty the screeningApplicableQty to set
	 */
	public void setScreeningApplicableQty(String screeningApplicableQty) {
		this.screeningApplicableQty = screeningApplicableQty;
	}


	/**
	 * @return the screeningApplicableAmt
	 */
	public String getScreeningApplicableAmt() {
		return screeningApplicableAmt;
	}


	/**
	 * @param screeningApplicableAmt the screeningApplicableAmt to set
	 */
	public void setScreeningApplicableAmt(String screeningApplicableAmt) {
		this.screeningApplicableAmt = screeningApplicableAmt;
	}


	/**
	 * @return the screeningAvailedQty
	 */
	public String getScreeningAvailedQty() {
		return screeningAvailedQty;
	}


	/**
	 * @param screeningAvailedQty the screeningAvailedQty to set
	 */
	public void setScreeningAvailedQty(String screeningAvailedQty) {
		this.screeningAvailedQty = screeningAvailedQty;
	}


	/**
	 * @return the screeningAvailedAmt
	 */
	public String getScreeningAvailedAmt() {
		return screeningAvailedAmt;
	}


	/**
	 * @param screeningAvailedAmt the screeningAvailedAmt to set
	 */
	public void setScreeningAvailedAmt(String screeningAvailedAmt) {
		this.screeningAvailedAmt = screeningAvailedAmt;
	}


	/**
	 * @return the screeningBalanceQty
	 */
	public String getScreeningBalanceQty() {
		return screeningBalanceQty;
	}


	/**
	 * @param screeningBalanceQty the screeningBalanceQty to set
	 */
	public void setScreeningBalanceQty(String screeningBalanceQty) {
		this.screeningBalanceQty = screeningBalanceQty;
	}


	/**
	 * @return the screeningBalanceAmt
	 */
	public String getScreeningBalanceAmt() {
		return screeningBalanceAmt;
	}


	/**
	 * @param screeningBalanceAmt the screeningBalanceAmt to set
	 */
	public void setScreeningBalanceAmt(String screeningBalanceAmt) {
		this.screeningBalanceAmt = screeningBalanceAmt;
	}

	/**
	 * @return the saveIdValueList
	 */
	public ArrayList getSaveIdValueList() {
		return saveIdValueList;
	}

	/**
	 * @param saveIdValueList the saveIdValueList to set
	 */
	public void setSaveIdValueList(ArrayList saveIdValueList) {
		this.saveIdValueList = saveIdValueList;
	}

	/**
	 * @return the saveIdValue
	 */
	public String getSaveIdValue() {
		return saveIdValue;
	}

	/**
	 * @param saveIdValue the saveIdValue to set
	 */
	public void setSaveIdValue(String saveIdValue) {
		this.saveIdValue = saveIdValue;
	}

	/**
	 * 
	 */
	public void clearBean()
	{
		screeningCategoryCode											= 	"";
		screeningCategoryDesc											= 	"";
		screeningApplicableQty											= 	"";
		screeningApplicableAmt											= 	"";
		screeningAvailedQty												= 	"";
		screeningAvailedAmt												= 	"";
		saveIdValue														= 	"";                   
		saveIdValueList													=	null;
	}
	

	public HashMap getScreenServiceCriteria(String facilityId,String locale,String p_patient_id,String p_episode_type,String p_episode_id,String p_visit_id,String loginUser)throws Exception 
	{
		Connection 			connection 									= 	null;		
		CallableStatement 	callableStatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		PreparedStatement 	preparedstatement1 							= 	null;
		ResultSet 			resultSet1									= 	null;	
		ArrayList			screenServiceCriteriaList					=   null;
		Array 				arr 										= 	null;
		HashMap				screenServiceCriteriaListMap				=	null;
		HashMap				screenServiceMap							=	null;
		String				blRepositoryKey								=	"";
		BLScreenServiceBean bllScreenServiceBean						=	null; 
		String valueDtl="";	
		
		try
		{
			screenServiceCriteriaListMap	=	new HashMap();
			screenServiceMap				=	new HashMap();
			screenServiceCriteriaList		= 	new ArrayList(); 
			connection						=  getConnection();
			callableStatement 				=  connection.prepareCall("begin blinstransactions.bl_ins_screening_services(?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;"); 
			
			/*callableStatement.setString(1, "HS"); 
			callableStatement.setString(2, "DU00000537"); 
			callableStatement.setString(3, "O"); 
			callableStatement.setString(4, "10101497"); 
			callableStatement.setString(5, "1"); 
			*/
			System.err.println("######## facilityId "+facilityId);
			System.err.println("######## facilityId "+p_episode_type);
			System.err.println("######## facilityId "+p_episode_id);
			System.err.println("######## facilityId "+p_visit_id);
			System.err.println("######## facilityId "+loginUser);

			callableStatement.setString(1, facilityId); 
			callableStatement.setString(2, p_patient_id); 
			callableStatement.setString(3, p_episode_type); 
			callableStatement.setString(4, p_episode_id); 
			callableStatement.setString(5, p_visit_id); 
			callableStatement.setString(6, loginUser);
			
			callableStatement.registerOutParameter(7, java.sql.Types.ARRAY, "BL_INS_SCRNING_OR_CAT_CODE"); // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT 
			callableStatement.registerOutParameter(8, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1000"); 
			callableStatement.registerOutParameter(9, java.sql.Types.ARRAY, "BL_INS_SCRNING_AMT_LIMIT"); 
			callableStatement.registerOutParameter(10, java.sql.Types.ARRAY, "BL_INS_SCRNING_UTILIZED_AMT"); 
			callableStatement.registerOutParameter(11, java.sql.Types.ARRAY, "BL_INS_SCRNING_BALANCE_AMT"); 
			callableStatement.registerOutParameter(12, java.sql.Types.ARRAY, "BL_INS_SCRNING_QTY_LIMIT"); 
			callableStatement.registerOutParameter(13, java.sql.Types.ARRAY, "BL_INS_SCRNING_UTILIZED_QTY"); 
			callableStatement.registerOutParameter(14, java.sql.Types.ARRAY, "BL_INS_SCRNING_BALANCE_QTY");		
			
			callableStatement.execute(); 
			for(int k=7;k<15;k++)
			{
				arr = callableStatement.getArray (k); 
				if(arr==null) break;
	            Object[] values = (Object[]) arr.getArray(); 
	            for (int i=0; i < values.length; i++)                 
	            {
	            	String key =i+"-"+k;
					 if(values[i]== null)
	 				valueDtl ="";
					else
					valueDtl =""+ values[i];					

            		if(screenServiceCriteriaListMap.containsKey(i))
	            	{
	            		bllScreenServiceBean = (BLScreenServiceBean) screenServiceCriteriaListMap.get(i);
	            		switch(k)
	            		{
	            			case 7: 	bllScreenServiceBean.setScreeningCategoryCode(valueDtl);
										System.out.println("setScreeningCategoryCode  "+valueDtl);
	            						break;
	            			case 8: 	bllScreenServiceBean.setScreeningCategoryDesc(valueDtl);
										System.out.println("setScreeningCategoryDesc  "+valueDtl);
        								break;
	            			case 9: 	bllScreenServiceBean.setScreeningApplicableAmt((valueDtl));
										System.out.println("setScreeningApplicableAmt  "+valueDtl);
        								break;
	            			case 10: 	bllScreenServiceBean.setScreeningAvailedAmt((valueDtl));
										System.out.println("setScreeningAvailedAmt  "+valueDtl);
        								break;
	            			case 11: 	bllScreenServiceBean.setScreeningBalanceAmt((valueDtl));
        								break;
	            			case 12: 	bllScreenServiceBean.setScreeningApplicableQty((valueDtl));
        								break;
	            			case 13: 	bllScreenServiceBean.setScreeningAvailedQty((valueDtl));
        								break;
	            			case 14: 	bllScreenServiceBean.setScreeningBalanceQty((valueDtl));
        								break;
        					default:	
        				}
	            	}
	            	else
	            	{	
	            		bllScreenServiceBean = new BLScreenServiceBean();
	            		switch(k)
	            		{
	            			case 7: 	bllScreenServiceBean.setScreeningCategoryCode(valueDtl);
	            						break;
	            			case 8: 	bllScreenServiceBean.setScreeningCategoryDesc(valueDtl);
        								break;
	            			case 9: 	bllScreenServiceBean.setScreeningApplicableAmt((valueDtl));
										System.out.println("setScreeningApplicableAmt  "+valueDtl);
        								break;
	            			case 10: 	bllScreenServiceBean.setScreeningAvailedAmt((valueDtl));
										System.out.println("setScreeningAvailedAmt  "+valueDtl);
        								break;
	            			case 11: 	bllScreenServiceBean.setScreeningBalanceAmt((valueDtl));
        								break;
	            			case 12: 	bllScreenServiceBean.setScreeningApplicableQty((valueDtl));
        								break;
	            			case 13: 	bllScreenServiceBean.setScreeningAvailedQty((valueDtl));
        								break;
	            			case 14: 	bllScreenServiceBean.setScreeningBalanceQty((valueDtl));
        								break;
        					default:	
        				}
            			screenServiceCriteriaListMap.put(i, bllScreenServiceBean);
	            	}
	            }
			}				
            
			System.out.println("IN getScreenServiceCriteria screenServiceCriteriaListMap::::::::"+screenServiceCriteriaListMap);
			System.out.println("IN getScreenServiceCriteria screenServiceCriteriaListMap:size:::::::"+screenServiceCriteriaListMap.size());
			Iterator iterator= screenServiceCriteriaListMap.keySet().iterator();
			while(iterator.hasNext())
			{				
				int key =    (Integer)iterator.next();
				System.out.println("IN getScreenServiceCriteria key:::::::"+key);
				bllScreenServiceBean = (BLScreenServiceBean) screenServiceCriteriaListMap.get(key);
				System.out.println("INDEX::: "+key+" ::::Code::::::::::: "+bllScreenServiceBean.getScreeningCategoryCode());
				System.out.println("INDEX::: "+key+" ::::Desc::::::::::: "+bllScreenServiceBean.getScreeningCategoryDesc());
				System.out.println("INDEX::: "+key+" ::::Appl Qty::::::: "+bllScreenServiceBean.getScreeningApplicableQty());
				System.out.println("INDEX::: "+key+" ::::Appl Amt::::::: "+bllScreenServiceBean.getScreeningApplicableAmt());
				System.out.println("INDEX::: "+key+" ::::Availed Amt:::: "+bllScreenServiceBean.getScreeningAvailedAmt());
				System.out.println("INDEX::: "+key+" ::::Availed Qty:::: "+bllScreenServiceBean.getScreeningAvailedQty());
				System.out.println("INDEX::: "+key+" ::::Balance Amt:::: "+bllScreenServiceBean.getScreeningBalanceAmt());
				System.out.println("INDEX::: "+key+" ::::Balance Qty:::: "+bllScreenServiceBean.getScreeningBalanceQty());				
			}			
        } catch (Exception e) {
            e.printStackTrace();
        }
		//Added against V210416
        finally{
            try {            	
                connection.close();  
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }		
		return screenServiceCriteriaListMap;		
	}	
}
