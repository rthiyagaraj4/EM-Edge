/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
2/7/2021				15757					Shazana														Common-ICN-0028
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST ;
//* pmd 21/02/2005
import eST.Common.StTransaction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.* ;
import javax.servlet.http.*;

public class ProductTransferRequestBean extends StTransaction implements Serializable { 
 
	private int prod_trf_req_no		;
	private String request_store	;
	private String repack_item		;
	private String required_qty		;
	private String item_to_use		;
	private String repack_factor	;
	private String to_factor		;
	private String quantity			;
	private String requested_by		;
	private String remarks			;

	public int getProd_Trf_Req_No(){
		try {
			HashMap hmRecord  = new HashMap();
			hmRecord = fetchRecord(getStRepositoryValue("SQL_ST_PROD_TRANS_REQ_SELECT_MAX_REQ_NO"));
			prod_trf_req_no		 =	Integer.parseInt((String)hmRecord.get("MAX_PROD_TFR_REQUEST_NO"));
			prod_trf_req_no	 = prod_trf_req_no+1;
			if (prod_trf_req_no == 0){
				prod_trf_req_no	 = 1;
			}
		}catch ( Exception e )	{
			e.printStackTrace() ;
		} 
		 return prod_trf_req_no;
	}

	public void setRequest_Store(String requeststore) {
		 this.request_store = checkForNull( requeststore);
	}

	public String getRequest_Store( ) {
		 return request_store;
	}

	public void setRepack_Item(String repackitem) {
		
		 this.repack_item = checkForNull( repackitem);
	}

	public String getRepack_Item( ) {
		 return repack_item;
	}

	public void setRequired_Qty(String requiredqty) {
		 this.required_qty = checkForNull( requiredqty);
	}

	public String getRequired_Qty( ) {
		 return required_qty;
	}

	public void setItem_Used(String itemtouse) {

		 this.item_to_use = checkForNull( itemtouse);
	}

	public String getItem_Used( ) {
		 return item_to_use;
	}


	public void setRepack_Factor(String repackfactor) {
		 this.repack_factor = checkForNull( repackfactor);
	}

	public String getRepack_Factor( ) {
		 return repack_factor;
	}
	public void setTo_Factor(String tofactor) {
		 this.to_factor = checkForNull( tofactor);
	}

	public String getTo_Factor( ) {
		 return to_factor;
	}

	public void setQuantity(String qty) {
		 this.quantity = checkForNull( qty);
	}

	public String getQuantity( ) {
		 return quantity;
	}

	public void setRequested_By(String requestedby) {
		 this.requested_by = checkForNull( requestedby);
	}

	public String getRequested_By( ) {
		 return requested_by;
	}
	public void setRemarks(String remarks) {
		 this.remarks = checkForNull( remarks);
	}

	public String getRemarks( ) {
		 return remarks;
	}

	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(super.login_by_id);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_PRODUCT_TRANSFER_STORE_SELECT"), alParam);
		alOptionValues.remove(0);
		optionValues = getListOptionTag(alOptionValues, getRequest_Store());
		alOptionValues = null;
		return optionValues;
	}	

	public void setAll(Hashtable htRecordSet){
		/*setRequest_Store((String) htRecordSet.get("store_code"));
		setItem_Used	((String) htRecordSet.get("fm_item_code"));
		setRepack_Item	((String) htRecordSet.get("to_item_code"));
		setRepack_Factor((String) htRecordSet.get("fm_stk_uom_conv_factor"));
		setTo_Factor	((String) htRecordSet.get("to_stk_uom_conv_factor"));
		setQuantity		((String) htRecordSet.get("fm_item_qty"));
		setRequired_Qty	((String) htRecordSet.get("to_item_qty"));
		setRemarks		((String) htRecordSet.get("remarks"));
		setRequested_By	((String) htRecordSet.get("requested_by"));*/
	}

	public void clear(){
		repack_item		="";
		required_qty	="";
		item_to_use		="";
		repack_factor	="";
		to_factor		="";
		quantity		="";
		requested_by	="";
		remarks			="";
	}

	public HashMap insert() {
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	languageData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		languageData.add(getLanguageId());
		alInsertData.add(String.valueOf(prod_trf_req_no));
		alInsertData.add(getRequest_Store());
		alInsertData.add(getItem_Used());	
		alInsertData.add(getRepack_Item());	
		alInsertData.add(getRepack_Factor());
		alInsertData.add(getTo_Factor());	
		alInsertData.add(getQuantity());		
		alInsertData.add(getRequired_Qty());	
		alInsertData.add(getRequested_By());	
		alInsertData.add(getRemarks	());	
		alInsertData.add("E");
		alInsertData.add(getLoginById()); 
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
//		hmSQLMap.put( "SelectSQL", getStRepositoryValue("SQL_ST_PROD_TRANS_REQ_COUNT")		);
		hmSQLMap.put( "InsertSQL", getStRepositoryValue("SQL_ST_PROD_TRANS_REQ_INSERT")		);

//		alWhereData.add(String.valueOf(prod_trf_req_no));
//		alWhereData.add("2");

		hmTableData.put( "properties",			getProperties() );
//		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put( "LanguageData",			languageData	);
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
		
	}

	public java.util.ArrayList getRepackUom(String item_code) {
        ArrayList alRepackuomCode = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_REPACK_UOM_SELECT"));
            pstmt.setString(1, item_code);
			resultSet = pstmt.executeQuery();
			
            while (resultSet != null && resultSet.next()) {
				
                String record1 = "";
				String record2=  "";
                record1 = checkForNull(resultSet.getString("repacking_group_code"));
				record2 = checkForNull(resultSet.getString("repack_unit_uom"));
				
                alRepackuomCode.add(record1);
				alRepackuomCode.add(record2);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		return alRepackuomCode;
	}

	public java.util.ArrayList getEqvlUom(String stk_uom,String repack_uom) {
		
		
        ArrayList alEqvlUomCode = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_EQVL_UOM_VALUE_SELECT"));
            pstmt.setString(1, stk_uom);
			pstmt.setString(2, repack_uom);
			resultSet = pstmt.executeQuery();
				
            while (resultSet != null && resultSet.next()) 
			{
				String eqvluom = "";
				eqvluom = checkForNull(resultSet.getString("eqvl_value"));
				alEqvlUomCode.add(eqvluom);
			}

        }catch (Exception e) {
			 e.printStackTrace();
        }finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		return alEqvlUomCode;
	}
	/*public void doOnlineReportPTRPrinting(String req_no,String p_language_id,javax.servlet.http.HttpSession session ) {
		try{
			String reportid = "STBPTRDC";
			HashMap hmReportParameter	=	new HashMap();
			HashMap hmParameters	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_prod_tfr_request_no",req_no);
			hmReportParameter.put("P_LANGUAGE_ID" ,p_language_id);
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",session.getAttribute("jdbc"));
			hmParameters.put("report_server",session.getAttribute("report_server"));
			hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",getRequest_Store());
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

	public void doOnlineReportPTRPrinting(String req_no,Object request,Object response) {
		try{
	
			String reportid = "STBPTRDC";
			//String copies = getNoOfCopies(reportid);

			if (!isInternalRequest("ST",reportid)) return;
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", getRequest_Store()) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_prod_tfr_request_no",req_no);
				//report2.addParameter("copies",copies);
				onlineReports.add( report2) ;

				
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}
	
	/*ML-MMOH-SCF-1065*/
	
	
	public ArrayList getConvCode(String item_code,String uom_desc,String equivalent_uom_desc,String lang_id) {
		 java.sql.Connection connection = null;
	        java.sql.PreparedStatement  pstmt = null;
	        java.sql.ResultSet  resultSet = null;
	        
	        java.sql.PreparedStatement  pstmt1 = null;
	        java.sql.ResultSet  resultSet1 = null;
	        
	        java.sql.PreparedStatement  pstmt2 = null;
	        java.sql.ResultSet  resultSet2 = null;
	        
	        java.sql.PreparedStatement  pstmt3 = null;
	        java.sql.ResultSet  resultSet3 = null;
	        
	        String uom_code="";
	        String equiv_uom_code="";
	       // int convfactor=0;
	        ArrayList<Integer> convfactor=new ArrayList<Integer>();
	       // int convfactor=0;
	        try {
	            connection = getConnection();
	            pstmt = connection.prepareStatement("select UOM_CODE from am_uom_lang_vw where short_desc =? and language_id=?");
	            pstmt.setString(1, uom_desc);
				pstmt.setString(2, lang_id);
				resultSet = pstmt.executeQuery();
	            if (resultSet != null && resultSet.next()) 
				{
	            	uom_code=resultSet.getString(1);
	            	System.out.println("uom_code-"+uom_code);
				}
	            pstmt1 = connection.prepareStatement("select UOM_CODE from am_uom_lang_vw where short_desc =? and language_id=?");
	            pstmt1.setString(1, equivalent_uom_desc);
				pstmt1.setString(2, lang_id);
				resultSet1 = pstmt1.executeQuery();
	            if (resultSet1 != null && resultSet1.next()) 
				{
	            	equiv_uom_code =resultSet1.getString(1);
	            	System.out.println("equiv_uom_code-"+equiv_uom_code);
				}
	            
	            pstmt2 = connection.prepareStatement("select EQVL_VALUE from am_uom_eqvl where UOM_CODE=? AND EQVL_UOM_CODE =?");
	         //   pstmt2.setString(1, item_code);
				pstmt2.setString(1, equiv_uom_code);
				pstmt2.setString(2, uom_code);
				resultSet2 = pstmt2.executeQuery();
	            if (resultSet2 != null && resultSet2.next()) 
				{
	            	//convfactor =resultSet2.getInt(1);
	            	convfactor.add(resultSet2.getInt(1));
	            	System.out.println("convfactor-"+convfactor);
				}
	            else
	            {
	            	convfactor.add(1);
	            }
	           // int convfactor1=0;//commented for 15757
	            
	            pstmt3 = connection.prepareStatement("select EQVL_VALUE from am_uom_eqvl where UOM_CODE=? AND EQVL_UOM_CODE =?");
		         //   pstmt3.setString(1, item_code);
					pstmt3.setString(1, uom_code);
					pstmt3.setString(2, equiv_uom_code);
					resultSet3 = pstmt3.executeQuery();
		            if (resultSet3 != null && resultSet3.next()) 
					{
		            	convfactor.add(resultSet3.getInt(1));
		            	//System.out.println("convfactor1-"+convfactor);//commented for 15757
					}
		            else
		            {
		            	convfactor.add(1);
		            }
		           
	        }catch (Exception e) {
				 e.printStackTrace();
	        }finally {
	            try{
	                closeResultSet(resultSet);
	                closeStatement(pstmt);
	                closeConnection(connection);
	                closeResultSet(resultSet1);
	                closeStatement(pstmt1);
	                closeResultSet(resultSet2);
	                closeStatement(pstmt2);
	                closeResultSet(resultSet3);
	                closeStatement(pstmt3);
	            }catch(Exception es){
					es.printStackTrace();
	            }
	        }
//		double convfactor=1;
	        return convfactor;
	}
}
