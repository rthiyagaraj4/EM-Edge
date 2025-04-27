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
package eBL.toolbar.dao;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import webbeans.eCommon.ConnectionManager;

import eBL.toolbar.request.ToolbarRequest;
import eBL.toolbar.response.ToolbarResponse;

/**
 * 
 * @author Rajesh V
 *
 */
@SuppressWarnings("rawtypes")
public class ToolBarDisplayDAOImpl implements ToolBarDisplayDAO{

	/**
     * This Method is used to get the User Specific Toolbar Functions and its Properties.
     * @param request
     * @return
     */
	public ToolbarResponse getToolBarForUser(ToolbarRequest toolbarRequest) {
		Object[] values = null;
		Connection con = null;
		CallableStatement cstmt = null;
		Array listArray	= null;
		List<String> errorList = null;
		String str_error_level = "", str_sysmesage_id="", str_error_text="";
		LinkedHashMap toolBarMap = new LinkedHashMap();
		ToolbarResponse response = new ToolbarResponse();
		ToolbarResponse bean = null;
		Locale loc = null;
		ResourceBundle rb = null;
		try{
			loc = new Locale("en");
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall("{ call   bltoolbar.invoke_toolbar(?,?,?,?,?,?,?,?,?,?,?) }");			
			cstmt.setString(1,toolbarRequest.getFacilityId());
			cstmt.setString(2,toolbarRequest.getUserId());
			cstmt.setString(3,toolbarRequest.getResponsibilityId());
			cstmt.setString(4,toolbarRequest.getFunctionId());
			cstmt.registerOutParameter(5, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(6, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1000");
			cstmt.registerOutParameter(7, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1000");
			cstmt.registerOutParameter(8, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.execute(); 
			for(int k=5;k<=8;k++)
			{
				listArray = cstmt.getArray (k);  
				if(listArray!=null){
					try{
						values = (Object[]) listArray.getArray(); 
					}
					catch(Exception e){
						values = null;
						e.printStackTrace();
					}					
				}
				else{
					values=null;
				}        
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {		           
			            if(toolBarMap.containsKey(i))
		            	{
			            	bean = (ToolbarResponse) toolBarMap.get(i);
		            		switch(k)
		            		{
			            		case 5: 	bean.setToolbarFunction(((String)values[i]));
	    									break;
				    			case 6: 	bean.setToolbarUrl((String)values[i]);
											break;
				    			case 7: 	bean.setToolbarIcon((String)values[i]);
											break;
				    			case 8: 	bean.setSeqNo((BigDecimal)values[i]);
											break;				    			
								default:	
		    				}
		            	}
		            	else
		            	{	
		            		bean = new ToolbarResponse();
		            		switch(k)
		            		{
			            		case 5: 	bean.setToolbarFunction(((String)values[i]));
											break;
				    			case 6: 	bean.setToolbarUrl((String)values[i]);
											break;
				    			case 7: 	bean.setToolbarIcon((String)values[i]);
											break;
				    			case 8: 	bean.setSeqNo((BigDecimal)values[i]);
											break;				    							
								default:	
		    				}
		            		toolBarMap.put(i, bean);
		            	}
		            }    
				}     
	        }
			
			str_error_level = cstmt.getString(9);
			str_sysmesage_id = cstmt.getString(10);
			str_error_text = cstmt.getString(11);

			errorList = new ArrayList<String>();
			
			if(str_error_level!=null || str_error_text!=null){
				errorList.add(str_error_text);
			}

			if(str_sysmesage_id!=null){
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){

						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
							rbException.printStackTrace();
						}
						errorList.add(msgArr[l]);
					}
				}else{
					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						System.err.println("Exceprion in RB ->"+rbException);
						rbException.printStackTrace();
					}
					errorList.add(str_sysmesage_id);
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception happened in getting Results -> "+e);
			e.printStackTrace();
		}
		finally{
			response.setErrorList(errorList);
			response.setToolBarMap(toolBarMap);
			if(con!=null){
				ConnectionManager.returnConnection(con);
			}
			//cstmt = null; // commented against V210416.
			try{
			if(cstmt!=null) cstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in getToolBarForUser:"+e);
				e.printStackTrace();
			}
			//Added against V210416 ends.
		}
		return response;
	}
}
