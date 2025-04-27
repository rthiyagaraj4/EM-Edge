/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder;


import java.util.* ;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import webbeans.eCommon.ConnectionManager;
import eIPAD.selectorder.healthobject.*;
import eIPAD.selectorder.request.*;
import eIPAD.selectorder.response.*;
import eOR.Common.OrRepositoryExt;

public class SelectOrderDetails implements java.io.Serializable {
	 private String checkForNull(String strParam)
	 {
		 String str = "";
         if(strParam!=null && strParam.length() > 0)
        	 str = strParam;
         return str;
		 
	 }
	 public InsertOrderResponse insertOrder(InsertOrderRequest insertOrderRequest) 
	 {
		 InsertOrderResponse responseStatus = new InsertOrderResponse();
		 responseStatus.setStatus(responseStatus.failure);
		 if(insertOrderRequest != null && insertOrderRequest.getHttpRequest() != null)
		 {
			Connection con = null;
			PreparedStatement pstmt = null;
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			boolean executedStatus=false;
			ArrayList<Boolean> executionstatusarray = new ArrayList<Boolean>();
		
			
			StringBuffer sql = new StringBuffer("");

			
			HttpServletRequest request = insertOrderRequest.getHttpRequest();
			ArrayList<InsertOrderHO> InsertOrderHOArrayList = insertOrderRequest.getInsertOrderHOArrayList();
			
			if(InsertOrderHOArrayList!=null)
			{
			try {

				con = ConnectionManager.getConnection(request);
				//con.setAutoCommit(false);
				
				sql.append("insert into  OR_RECNT_CATALOG_BY_PATIENT ( ");
				sql.append(" PATIENT_ID , ORDER_CATALOG_CODE , NO_OCCURANCE,");
				sql.append(" ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID , ");
				sql.append(" MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO , MODIFIED_FACILITY_ID , ");
				sql.append(" ENCOUNTER_ID , FACILITY_ID, ");
				sql.append(" ORD_PRACT_ID, ORD_DATE_TIME, ");
				sql.append(" RECNT_STATUS_IND ");
				sql.append(" ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?)");
				pstmt = con.prepareStatement(sql.toString());
				
				try {
					for (InsertOrderHO orderRecord : InsertOrderHOArrayList) {
						
						executedStatus=false;
						boolean isNoOccuranceNull = false;
						boolean isRecentStatusIndNull = false;
						
						String patientId = orderRecord.getPatientID();
						String orderCatalogCode = orderRecord.getOrderCatalogCode();
						int noOccurance = 0;
						try{
							noOccurance = Integer.parseInt(orderRecord.getNoOccurance());
						}
						catch(NumberFormatException e)
						{
							isNoOccuranceNull = true;
						}
						String addedById = orderRecord.getAddedById();
						String addedDate = (orderRecord.getAddedDate()==null || orderRecord.getAddedDate().equals("")) ? dateFormat.format(new java.util.Date()) : orderRecord.getAddedDate();
						java.sql.Date added_date = java.sql.Date.valueOf(addedDate);
						String addedAtWsNo = orderRecord.getAddedAtWsNo();
						String addedFacilityId = orderRecord.getAddedFacilityId();
						String modifiedById = (orderRecord.getModifiedById()==null || orderRecord.getModifiedById().equals("")) ? addedById : orderRecord.getModifiedById();
						String modifiedDate = (orderRecord.getModifiedDate()==null || orderRecord.getModifiedDate().equals("")) ? addedDate : orderRecord.getModifiedDate();
						java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);
						String modifiedAtWsNo = (orderRecord.getModifiedAtWsNo()==null || orderRecord.getModifiedAtWsNo().equals("")) ? addedAtWsNo : orderRecord.getModifiedAtWsNo();
						String modifiedFacilityId = (orderRecord.getModifiedFacilityId()==null || orderRecord.getModifiedFacilityId().equals("")) ? addedFacilityId : orderRecord.getModifiedFacilityId();
						String encounterId = orderRecord.getEncounterId();
						int encounter_id = Integer.parseInt(encounterId);
						String facilityId = (orderRecord.getFacilityId()==null || orderRecord.getFacilityId().equals("")) ? addedFacilityId : orderRecord.getFacilityId();
						String orderPractitionerId = orderRecord.getOrdPractId();
						String orderDateTime = (orderRecord.getOrdDateTime()==null || orderRecord.getOrdDateTime().equals("")) ? addedDate : orderRecord.getOrdDateTime();
						java.sql.Date order_date_time = java.sql.Date.valueOf(orderDateTime);
						
						String recentStatusInd = orderRecord.getRecentStatusInd();
						if(recentStatusInd==null || recentStatusInd.equals(""))
							isRecentStatusIndNull = true;
						
	
						pstmt.setString(1, patientId);
						pstmt.setString(2, orderCatalogCode);
						
						if(!isNoOccuranceNull)
							pstmt.setInt(3, noOccurance);
						else
							pstmt.setNull(3, java.sql.Types.INTEGER);
						
						pstmt.setString(4, addedById);
						pstmt.setDate(5, added_date);
						pstmt.setString(6, addedAtWsNo);
						pstmt.setString(7, addedFacilityId);
						pstmt.setString(8, modifiedById);
						pstmt.setDate(9, modified_date);
						pstmt.setString(10, modifiedAtWsNo);
						pstmt.setString(11, modifiedFacilityId);
						pstmt.setInt(12, encounter_id);
						pstmt.setString(13, facilityId);
						pstmt.setString(14, orderPractitionerId);
						pstmt.setDate(15, order_date_time);
						
						if(!isRecentStatusIndNull)
							pstmt.setString(16, recentStatusInd);
						else
							pstmt.setNull(16, java.sql.Types.VARCHAR);
						
						int executestatus = pstmt.executeUpdate();
						if(executestatus<=0)
						{
							executionstatusarray.add(false);
						}
						else
						{
							executionstatusarray.add(true);
						}
					}
					executedStatus = true;
					for(Boolean b:executionstatusarray)
					{
						if(b==false)
						{
							executedStatus=false;
							break;
						}
					}
					
					if(executedStatus)
					{
						con.commit();
						responseStatus.setStatus(responseStatus.success);
					}
					else
					{
						con.rollback();
						responseStatus.setStatus(responseStatus.failure);
					}
					
					if (pstmt != null)
						pstmt.close();
					} 
				catch (Exception e)
				{
					responseStatus.setStatus(responseStatus.failure);
					e.printStackTrace();
					System.out.println("To String  :  " +e.toString());

					try {
						con.rollback();
					} 
					catch (Exception ee) 
					{
						ee.printStackTrace();
						System.out.println("To String  :  " +ee.toString());
					} 
					finally {
						if (con != null)
							ConnectionManager.returnConnection(con, request);
						if(pstmt!=null)
							pstmt.close();
					}
				}
				finally{
					if(pstmt!=null)
						pstmt.close();
				}
			}
			

			 catch (Exception e) {
				 responseStatus.setStatus(responseStatus.failure);
				e.printStackTrace();
				System.out.println("To String  :  " +e.toString());
			}
			finally{
				if (con != null)
					ConnectionManager.returnConnection(con, request);

			}
		 }
		 }

		 
			return responseStatus;

		}
	 
	 public OrderCategoryResponse getOrderCategory(OrderCategoryRequest oCatRequest) throws Exception
	 {
		 OrderCategoryResponse oCatResponse = new OrderCategoryResponse();
		 List<OrderCategoryHO> oCategoryList = new ArrayList<OrderCategoryHO>();
		 if(oCatRequest != null && oCatRequest.getRequest() != null)
		 {
			  Connection connection 		= null;
			  Statement stmt				= null;
			  ResultSet resultSet 			= null;
			  String locale = "en";
			  StringBuffer sqlStr = new StringBuffer("");
			  HttpServletRequest request = oCatRequest.getRequest();
			  if(oCatRequest.getLanguageID() != null && !oCatRequest.getLanguageID().equals(""))
			  {
				  locale = oCatRequest.getLanguageID();
			  }
			  if(oCatRequest.getCalledFrom() != null && oCatRequest.getCalledFrom().equals("ALL"))
			  {
				  sqlStr.append("SELECT  short_desc, order_category FROM or_order_category_lang_vw  WHERE language_id ='" +locale + "' ORDER BY short_desc");
			  }
			  else
			  {
				  sqlStr.append(" SELECT   or_get_desc.or_order_category (order_category, '" + locale + "' , '2') short_desc,");
				  sqlStr.append(" order_category FROM or_order_category WHERE order_category != 'CN' ");
				  sqlStr.append(" UNION ");
				  sqlStr.append(" SELECT   'Non Specific' short_desc, '*A' order_category  FROM DUAL ORDER BY short_desc");
			  }
			  try {
				  
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ){
						OrderCategoryHO oCategoryHO = new OrderCategoryHO();
						oCategoryHO.setOrderCategory(checkForNull(resultSet.getString("order_category")));
						oCategoryHO.setShortDescription(checkForNull(resultSet.getString("short_desc")));
						oCategoryList.add(oCategoryHO);
					}
					oCatResponse.setLstOrderCategory(oCategoryList);
			  }
			  catch(Exception e){
				  e.printStackTrace() ;
				  throw e;
			  }
			  finally{
				  if ( resultSet != null ) resultSet.close() ;	
				  if ( stmt != null ) stmt.close() ;
				  ConnectionManager.returnConnection(connection,request);
			  }
			  
			  
			  
			  
		 }
		 return oCatResponse;
	 }
	 public TickSheetResponse getTickSheet(TickSheetRequest oTckReq) throws Exception
	 {
		 TickSheetResponse oTckRes = new TickSheetResponse();
		 List<TickSheetHO> oTckLst = new ArrayList<TickSheetHO>();
		 if(oTckReq != null && oTckReq.getRequest() != null)
		 {
			  Connection connection 		= null;
			  Statement stmt				= null;
			  ResultSet resultSet 			= null;
			  String locale = "en";
			  StringBuffer sqlStr = new StringBuffer("");
			  HttpServletRequest request = oTckReq.getRequest();
			  String clinicianID = "";
			  String orderCategory = "";
			  String serviceCode = "";
			  String facilityId = "";
			  String locationType = "";
			  String locationCode = "";
			  
			  if(oTckReq.getClinicianID() != null)
			  {
				  clinicianID = oTckReq.getClinicianID();
			  }
			  if(oTckReq.getOrderCategory() != null)
			  {
				  orderCategory = oTckReq.getOrderCategory();
			  }
			  if(oTckReq.getServiceCode() != null)
			  {
				  serviceCode = oTckReq.getServiceCode();
			  }
			  if(oTckReq.getFacilityId() != null)
			  {
				  facilityId = oTckReq.getFacilityId();
			  }
			  if(oTckReq.getLocationType() != null)
			  {
				  locationType = oTckReq.getLocationType();
			  }
			  if(oTckReq.getLocationCode() != null)
			  {
				  locationCode = oTckReq.getLocationCode();
			  }
			  if(oTckReq.getLanguageID() != null)
			  {
				  locale = oTckReq.getLanguageID();
			  }
			  sqlStr.append(" SELECT   tick_sheet_id, tick_sheet_desc tick_sheet_desc, order_category, seq_no ");
			  sqlStr.append("  FROM or_tick_sheet_lang_vw a ");
			  sqlStr.append(" WHERE order_category = NVL ('" + orderCategory + "', order_category) AND language_id = '" +locale  + "' AND eff_status = 'E' ");
			  sqlStr.append("  AND (   indexed_yn = 'N'  OR (    indexed_yn = 'Y'  AND EXISTS ( SELECT 1 FROM or_tick_sheet_by_index  WHERE order_category = a.order_category AND tick_sheet_id = a.tick_sheet_id ");
			  sqlStr.append(" AND (   (index_type = 'P' AND practitioner_id = '" + clinicianID + "') OR (index_type = 'S' AND service_code = '" + serviceCode + "')  OR (    index_type = 'F' ");
			  sqlStr.append(" AND facility_id = '" + facilityId + "'  AND DECODE (source_type,  'A', '" + locationType + "', source_type  ) = '" + locationType + "' AND DECODE (source_code, ");
			  sqlStr.append(" '*ALL', '" + locationCode + "', source_code  ) = '" + locationCode + "' )   )) )  ) ORDER BY seq_no ");
			  
			  try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ){
						TickSheetHO oTckHO = new TickSheetHO();
						oTckHO.setTickSheetId(checkForNull(resultSet.getString("tick_sheet_id")));
						oTckHO.setTickSheetDesc(checkForNull(resultSet.getString("tick_sheet_desc")));
						oTckHO.setOrderCategory(checkForNull(resultSet.getString("order_category")));
						oTckLst.add(oTckHO);
					}
					oTckRes.setLstTickSheet(oTckLst);
			  }
			  catch(Exception e){
				  e.printStackTrace() ;
				  throw e;
			  }
			  finally{
				  if ( resultSet != null ) resultSet.close() ;	
				  if ( stmt != null ) stmt.close() ;
				  ConnectionManager.returnConnection(connection,request);
			  }
		 }
		 return oTckRes;
	 }
	 public TickSheetResponse getTickSheetSection(TickSheetRequest oTckReq) throws Exception
	 {
		 TickSheetResponse oTckRes = new TickSheetResponse();
		 List<TickSheetHO> oTckLst = new ArrayList<TickSheetHO>();
		 if(oTckReq != null && oTckReq.getRequest() != null)
		 {
			  Connection connection 		= null;
			  Statement stmt				= null;
			  ResultSet resultSet 			= null;
			  String locale = "en";
			  StringBuffer sqlStr = new StringBuffer("");
			  HttpServletRequest request = oTckReq.getRequest();
			  String orderCategory = "";
			  String tickSheetId = "";
			  String orderTypeCode = "";
			  
			  
			  if(oTckReq.getLanguageID() != null)
			  {
				  locale = oTckReq.getLanguageID();
			  }
			  if(oTckReq.getOrderCategory() != null)
			  {
				  orderCategory = oTckReq.getOrderCategory();
			  }
			  if(oTckReq.getTickSheetId() != null)
			  {
				  tickSheetId = oTckReq.getTickSheetId();
			  }
			  if(oTckReq.getOrderTypeCode() != null)
			  {
				  orderTypeCode = oTckReq.getOrderTypeCode();
			  }
			  sqlStr.append(" SELECT   section_code, section_desc FROM or_tick_sheet_section_lang_vw a ");
			  sqlStr.append(" WHERE language_id = '" +locale + "' AND order_category = NVL ('" + orderCategory + "' , order_category)");
			  sqlStr.append(" AND tick_sheet_id = '" + tickSheetId + "' AND eff_status = 'E' AND EXISTS (  SELECT 1  FROM or_tick_sheet_item ");
			  sqlStr.append(" WHERE order_category = a.order_category AND tick_sheet_id = a.tick_sheet_id AND section_code = a.section_code ");
			  sqlStr.append(" AND order_type_code = NVL ('" +orderTypeCode + "' , order_type_code)) ORDER BY section_seq_num ");
			  
			  try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ){
						TickSheetHO oTckHO = new TickSheetHO();
						oTckHO.setSectionCode(checkForNull(resultSet.getString("section_code")));
						oTckHO.setSectionDesc(checkForNull(resultSet.getString("section_desc")));
						oTckLst.add(oTckHO);
					}
					oTckRes.setLstTickSheet(oTckLst);
			  }
			  catch(Exception e){
				  e.printStackTrace() ;
				  throw e;
			  }
			  finally{
				  if ( resultSet != null ) resultSet.close() ;	
				  if ( stmt != null ) stmt.close() ;
				  ConnectionManager.returnConnection(connection,request);
			  }
		 }
		 return oTckRes;
	 }
	 
	 public TickSheetItemRes getTickSheetSectionItems(TickSheetItemsReq oTckItemsReq) throws Exception
	 {
		 TickSheetItemRes oTckItemRes = new TickSheetItemRes();
		 List<TickSheetItemHO> oTckItemLst = new ArrayList<TickSheetItemHO>();
		 if(oTckItemsReq != null && oTckItemsReq.getRequest() != null)
		 {
			 	Connection connection 		= null;
				PreparedStatement pstmt 	= null;
				ResultSet resultSet 		= null;
	//			String sql = "SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text  FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";
				String sql = "SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text  FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and b.order_catalog_nature = ? and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code  AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";
				int reccount = 0;
				HttpServletRequest request = oTckItemsReq.getRequest();
				String priv_applicability_yn = "";
				
				if(oTckItemsReq.getPrivApplicabilityYN() != null )
				{
					priv_applicability_yn = oTckItemsReq.getPrivApplicabilityYN();
					if(priv_applicability_yn.equalsIgnoreCase("Y"))
					{
						sql = sql.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
						sql = sql.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
					}
					else if(priv_applicability_yn.equalsIgnoreCase("N"))
					{
						sql = sql.replace("##FILTERCAT##","");
						sql = sql.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
					}
					else
					{
						sql = sql.replace("##FILTERCAT##","");
						sql = sql.replace("##FILTERPRIV##"," 'Y' priv_yn, ");
					}
					
				}
				try
				{
					
					connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						pstmt		= connection.prepareStatement(sql);
					}
					if(pstmt != null)
					{
						pstmt.setString(++reccount,  checkForNull(oTckItemsReq.getPracType()));
						pstmt.setString(++reccount,  checkForNull(oTckItemsReq.getLanguageId()));
						pstmt.setString(++reccount,  checkForNull(oTckItemsReq.getFacilityID()));
						pstmt.setString(++reccount,  checkForNull(oTckItemsReq.getLocationType()));
						pstmt.setString(++reccount,  checkForNull(oTckItemsReq.getLocationCode()));
						
						if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N")))
						{
							pstmt.setString(++reccount , checkForNull(oTckItemsReq.getClinicianID()));		//P_PRACTITIONER_ID
							pstmt.setString(++reccount , checkForNull(oTckItemsReq.getResponsibilityID()));	//P_RESP_ID
							//pstmt.setString(++reccount , getAuthorisationOrOrderingYn("ORD"));		//P_PRIV_APPL_YN
							pstmt.setString(++reccount , "Y");
						}
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getTickSheetId()));	
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getSectionCode()));//need to add order catalog nature
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getOrderCatalogNature())); //added to filter based on catalog nature
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getPatientClass()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getPatientClass()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getGender()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getDOB()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getFacilityID()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getEncounterID()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getPatientClass()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getAdmitDate()));
						pstmt.setString(++reccount, checkForNull(oTckItemsReq.getDischargeDateTime()));
						if(oTckItemsReq.getOrderCategory() != null)
						{
							if(oTckItemsReq.getOrderCategory().equals("*A"))
							{
								pstmt.setString(++reccount, null);
							}
							else
							{
								pstmt.setString(++reccount, oTckItemsReq.getOrderCategory());
							}
						}
						pstmt.setString(++reccount,"");//for activity type
						pstmt.setString(++reccount,"");//for order type 
						if(priv_applicability_yn.equalsIgnoreCase("Y"))
						{
							pstmt.setString(++reccount , checkForNull(oTckItemsReq.getClinicianID()));	//P_PRACTITIONER_ID
							pstmt.setString(++reccount , checkForNull(oTckItemsReq.getResponsibilityID()));			//P_RESP_ID
							pstmt.setString(++reccount , priv_applicability_yn);		//P_PRIV_APPL_YN
						}
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
							while (resultSet.next() ){
								TickSheetItemHO oTckSheetItemHO = new TickSheetItemHO();
								oTckSheetItemHO.setOrderCatalogCode(checkForNull(resultSet.getString("order_catalog_code")));
								oTckSheetItemHO.setCatalogSynonym(checkForNull(resultSet.getString("catalog_synonym")));
								oTckSheetItemHO.setOrderCategory(checkForNull(resultSet.getString("order_category")));
								oTckSheetItemHO.setTickSheetId(checkForNull(resultSet.getString("tick_sheet_id")));
								oTckSheetItemHO.setSectionCode(checkForNull(resultSet.getString("section_code")));
								oTckSheetItemHO.setOrderTypeCode(checkForNull(resultSet.getString("order_type_code")));
								oTckSheetItemHO.setOrderCatalogNature(checkForNull(resultSet.getString("order_catalog_nature")));
								oTckSheetItemHO.setPrivYN(checkForNull(resultSet.getString("priv_yn")));
								oTckSheetItemHO.setPromptAlertYN(checkForNull(resultSet.getString("prompt_alert_yn")));
								oTckSheetItemHO.setPromptMsg(checkForNull(resultSet.getString("prompt_alert_msg")));
								
								oTckItemLst.add(oTckSheetItemHO);
							}
						}
						
						
					}
					oTckItemRes.setLstTickSheetItem(oTckItemLst);
				}
				catch(Exception e){
					  e.printStackTrace() ;
					  throw e;
				  }
				  finally{
					  if ( resultSet != null ) resultSet.close() ;	
					  if ( pstmt != null ) pstmt.close() ;
					  ConnectionManager.returnConnection(connection,request);
				  }
				
		 }
		 return oTckItemRes;
		 
	 }
	 
	 public ExistingOrderResponse getExistingOrder(ExistingOrderRequest oExtOrderReq) throws Exception
	 {
		 ExistingOrderResponse oExtOrderRes = new ExistingOrderResponse();
		 List<ExistingOrderHO> lstExtOrderHO = new ArrayList<ExistingOrderHO>();
		 if(oExtOrderReq != null && oExtOrderReq.getRequest() != null)
		 {
			  Connection connection 		= null;
			  Statement stmt				= null;
			  ResultSet resultSet 			= null;
			  String locale = "en";
			  StringBuffer sqlStr = new StringBuffer("");
			  HttpServletRequest request = oExtOrderReq.getRequest();
			  
			  sqlStr.append(" SELECT   a.order_category, a.order_id order_id,  patient_id,  encounter_id,  episode_id, episode_visit_num, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,");
			  sqlStr.append(" or_get_order_catalog (a.order_id,  a.order_type_code, '" +checkForNull(oExtOrderReq.getLanguageId()) + "', '" + checkForNull(oExtOrderReq.getPracType())+ "',  b.order_line_num  ) order_detail,");
			  sqlStr.append(" b.order_catalog_code, source_type,  source_code, b.priority, b.order_type_code, or_get_desc.or_order_type (b.order_type_code, '" + checkForNull(oExtOrderReq.getLanguageId())+ "', '2'  ) order_type_short_desc, ");
			  sqlStr.append(" a.ord_pract_id ord_pract_id, order_line_status order_status,  or_get_desc.or_order_status_code(order_line_status, '" +checkForNull(oExtOrderReq.getLanguageId()) + "','2'  ) order_status_short_desc,");
			  sqlStr.append(" TO_CHAR (b.start_date_time, 'dd/mm/yyyy hh24:mi') start_date_time,  TO_CHAR (b.end_date_time, 'dd/mm/yyyy hh24:mi') end_date_time,  b.catalog_synonym catalog_synonym FROM or_order a,  or_order_line b, am_duration_type c, or_catalog_synonym_lang_vw d ");
			  sqlStr.append(" WHERE a.order_id = b.order_id AND b.order_catalog_code = d.order_catalog_code AND b.durn_type = c.durn_type(+) AND d.language_id = '" + checkForNull(oExtOrderReq.getLanguageId()) + "' AND catalog_synonym_type = or_get_synonym_type ('" + checkForNull(oExtOrderReq.getPracType()) + "',  b.order_catalog_code)");
			  sqlStr.append(" AND NVL (b.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') AND SUBSTR (a.order_id, 1, 2) != 'CS' AND patient_id = '" + checkForNull(oExtOrderReq.getPatientId())+ "' ");
			  sqlStr.append(" AND NVL (encounter_id, 0) = NVL (('" + checkForNull(oExtOrderReq.getEncounterId())+ "'), NVL (encounter_id, 0)) AND TO_DATE (TO_CHAR (a.ord_date_time, 'dd/mm/yyyy'), 'dd/mm/yyyy')" );
			  sqlStr.append(" BETWEEN TO_DATE (NVL (('" +checkForNull(oExtOrderReq.getFromDate()) + "'), '01/01/1000'), 'dd/mm/yyyy') ");
			  sqlStr.append(" AND TO_DATE (NVL (('" + checkForNull(oExtOrderReq.getToDate()) + "'), '31/12/9999'), 'dd/mm/yyyy')");
			  sqlStr.append("  AND a.order_category IN (  SELECT order_category FROM or_order_category ic WHERE ic.order_category =  NVL ('" + checkForNull(oExtOrderReq.getOrderCategory())+ "', ic.order_category)) ");
			  sqlStr.append(" AND b.order_type_code = NVL ((''), b.order_type_code)");
			  //check status
			 // sqlStr.append(" AND (b.end_date_time > SYSDATE OR b.end_date_time IS NULL) ");
			  sqlStr.append("  AND b.cancelled_by_sys_yn != 'Y'");
			  sqlStr.append(" ORDER BY DECODE (('D'), 'D', TO_CHAR (a.ord_date_time, 'YYYYMMDDHH24MISS'),  'O', a.order_category, 'T', a.order_type_code  ) DESC, NVL (a.order_set_id, a.order_id), a.order_id,  order_line_num ");
			  try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ){
						
						ExistingOrderHO oExtOrderHO = new ExistingOrderHO();
						
						oExtOrderHO.setOrderCategory(checkForNull(resultSet.getString("order_category")));
						oExtOrderHO.setOrderID(checkForNull(resultSet.getString("order_id")));
						oExtOrderHO.setEncounterId(checkForNull(resultSet.getString("encounter_id")));
						oExtOrderHO.setOrderDetail(checkForNull(resultSet.getString("order_detail")));
						oExtOrderHO.setOrderCatalogCode(checkForNull(resultSet.getString("order_catalog_code")));
						oExtOrderHO.setOrderTypeCode(checkForNull(resultSet.getString("order_type_code")));
						oExtOrderHO.setOrderTypeDesc(checkForNull(resultSet.getString("order_type_short_desc")));
						oExtOrderHO.setOrderStatusDesc(checkForNull(resultSet.getString("order_status_short_desc")));
						oExtOrderHO.setStartDate(checkForNull(resultSet.getString("start_date_time")));
						oExtOrderHO.setEndDate(checkForNull(resultSet.getString("end_date_time")));
						
						lstExtOrderHO.add(oExtOrderHO);
						
					}
					oExtOrderRes.setLstExtOrderHO(lstExtOrderHO);
					
			  }
			  catch(Exception e){
				  e.printStackTrace() ;
				  throw e;
			  }
			  finally{
				  if ( resultSet != null ) resultSet.close() ;	
				  if ( stmt != null ) stmt.close() ;
				  ConnectionManager.returnConnection(connection,request);
			  }
			  
		 }
		 return oExtOrderRes;
	 }
	 
	 private String getDeceasedPatientYn(String patient_id,HttpServletRequest request) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;

			String sqlQuery = "SELECT deceased_yn FROM mp_patient WHERE patient_id=?";
			String record			= null;
			connection	= ConnectionManager.getConnection(request) ;
			try
			{
				if(connection != null)
				{
					pstmt		= connection.prepareStatement(sqlQuery);
				}
				if(pstmt != null)
				{
					pstmt.setString(1,  patient_id);
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						while(resultSet.next())	//Only One Record it will return
						{
							
							record = checkForNull(resultSet.getString( "deceased_yn" ))  ;
						}
					}
				}
			}
			catch(Exception e)
			{
				 e.printStackTrace() ;
				  throw e;
			  }
			  finally{
				  if ( resultSet != null ) resultSet.close() ;	
				  if ( pstmt != null ) pstmt.close() ;
				  ConnectionManager.returnConnection(connection,request);
			  }
			
			
					
				
				return record;
		}	
		 
	 public SearchOrderResponse getSearchOrderDetails(SearchOrderRequest oSrchOrdReq) throws Exception
	 {
		 SearchOrderResponse oSrchOrdRes = new  SearchOrderResponse();
		 List<SearchOrderHO> lstSrchOrderHO =  new ArrayList<SearchOrderHO>();
		 if(oSrchOrdReq != null && oSrchOrdReq.getRequest() != null)
		 {
			 	Connection connection 		= null;
				PreparedStatement pstmt 	= null;
				
				ResultSet resultSet 		= null;
				HttpServletRequest request = oSrchOrdReq.getRequest();
				String sqlQuery = "";
				String respId = checkForNull(oSrchOrdReq.getResponisibilityId());
				String restrictBy = checkForNull(oSrchOrdReq.getRestrictBy());
				String priv_applicability_yn = checkForNull(oSrchOrdReq.getPrivilegeYN());
				String callingFrom = checkForNull(oSrchOrdReq.getCallingFrom());
				String medicoLegalYN = checkForNull(oSrchOrdReq.getMedicoLegalYN());
				String p_pract_type = checkForNull(oSrchOrdReq.getPractionerType());
				String l_synonym_type = "";
				String ph_install_yn = "N";
				String deceased = "N";
				String criteria = "S";
				//String patientId = checkForNull(oSrchOrdReq.getPatientId());
				//String encounterId = checkForNull(oSrchOrdReq.getEncounterId());
				String discharge_adv_date_time = checkForNull(oSrchOrdReq.getDischargeAdviceDateTime());
				int reccount = 0;
				//getDischargeAdvDateTime
				if(oSrchOrdReq.getDischargeAdviceDateTime() != null && !oSrchOrdReq.getDischargeAdviceDateTime().equals("") )
				{
					//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,'Y',a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
					sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
				}
				else
				{
					//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,'Y',a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
					sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
				}
				
				try
				{
					deceased = getDeceasedPatientYn(oSrchOrdReq.getPatientId(),request);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if("MO".equalsIgnoreCase(respId)){
					sqlQuery = sqlQuery.replace("##MODECEASEDCON1##","'"+respId+"'");
					sqlQuery = sqlQuery.replace("##MODECEASEDCON2##","'"+callingFrom+"'");
					sqlQuery = sqlQuery.replace("##MODECEASEDCON3##","'"+medicoLegalYN+"'");
					sqlQuery = sqlQuery.replace("##MODECEASEDCON4##","'Y'");
				}else{
				
					sqlQuery = sqlQuery.replace("##MODECEASEDCON1##","null");
					sqlQuery = sqlQuery.replace("##MODECEASEDCON2##","null");
					sqlQuery = sqlQuery.replace("##MODECEASEDCON3##","null");
					sqlQuery = sqlQuery.replace("##MODECEASEDCON4##","'"+deceased+"'");
				}	
				if(restrictBy.equalsIgnoreCase("N"))
				{
						sqlQuery = sqlQuery.replace("##CATCODE##","");
				}
				if(priv_applicability_yn.equalsIgnoreCase("Y"))
				{
					sqlQuery = sqlQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
					sqlQuery = sqlQuery.replace("##FILTERPRIV##"," , OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
				}
				else if(priv_applicability_yn.equalsIgnoreCase("N"))
				{
					sqlQuery = sqlQuery.replace("##FILTERCAT##","");
					sqlQuery = sqlQuery.replace("##FILTERPRIV##",",  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
				}
				else
				{
					sqlQuery = sqlQuery.replace("##FILTERCAT##","");
					sqlQuery = sqlQuery.replace("##FILTERPRIV##",", 'Y' priv_yn");
				}
				if(oSrchOrdReq.getCriteria() != null && !oSrchOrdReq.getCriteria().equals(""))
				{
					criteria = oSrchOrdReq.getCriteria();
				}
				try
				{
					connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						pstmt		= connection.prepareStatement(sqlQuery);
					}
					if(pstmt != null)
					{
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getFacilityId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getPatientId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getEncounterId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getPatientClass()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getEpisodeId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getEpisodeVisitNum()));
						if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N")))
						{
							pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getClinicianId()));
							pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getResponisibilityId()));
							pstmt.setString(++reccount,  checkForNull(priv_applicability_yn));
							
						}
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getLanguageId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getLanguageId()));
						if ((p_pract_type.equalsIgnoreCase("AN"))||(p_pract_type.equalsIgnoreCase("PS"))||(p_pract_type.equalsIgnoreCase("DN"))||(p_pract_type.equalsIgnoreCase("MD"))||(p_pract_type.equalsIgnoreCase ("SG"))||(p_pract_type.equalsIgnoreCase("NS"))) 
						{
							l_synonym_type = "DC" ;
						}
						else if((p_pract_type.equalsIgnoreCase("RD"))||(p_pract_type.equalsIgnoreCase("PT"))) 
						{
				  			 l_synonym_type = "AD" ;
						}
						pstmt.setString(++reccount,  l_synonym_type);
						pstmt.setString(++reccount,  p_pract_type);
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getOrderCategory()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getOrderCatalogNature()));
						pstmt.setString(++reccount,  criteria);
						pstmt.setString(++reccount,  "%" +checkForNull(oSrchOrdReq.getOrderText() + "%"));
						pstmt.setString(++reccount,   checkForNull(oSrchOrdReq.getOrderText() + "%"));
						pstmt.setString(++reccount,  "%" +checkForNull(oSrchOrdReq.getOrderText()));
						pstmt.setString(++reccount,  criteria);
						pstmt.setString(++reccount,  "%" +checkForNull(oSrchOrdReq.getOrderText() + "%"));
						pstmt.setString(++reccount,   checkForNull(oSrchOrdReq.getOrderText() + "%"));
						pstmt.setString(++reccount,  "%" +checkForNull(oSrchOrdReq.getOrderText()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getPatientClass()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getPatientClass()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getGender()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getDOB()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getFacilityId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getEncounterId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getPatientClass()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getAdmitDate()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getDischargeDateTime()));
						if(discharge_adv_date_time != null && !discharge_adv_date_time.equals(""))
						{
							pstmt.setString(++reccount,  discharge_adv_date_time);
						}
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getOrderCategory()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getFacilityId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getServicecode()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getClinicianId()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getLocationType()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getLocationCode()));
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getOrderType()).trim());
						pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getActivityType()));
						/*
						if(restrictBy.equalsIgnoreCase("Y"))
						{
							if(ph_install_yn.equalsIgnoreCase("Y"))			// If PH has been installed
							{
								pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getServicecode()));
							}
							pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getServicecode()));
						}
						*/
						if(priv_applicability_yn.equalsIgnoreCase("Y"))
						{
							pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getClinicianId()));
							pstmt.setString(++reccount,  checkForNull(oSrchOrdReq.getResponisibilityId()));
							pstmt.setString(++reccount,  checkForNull(priv_applicability_yn));
						}
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
							while (resultSet.next() ){
								SearchOrderHO oSrchOrderHO = new SearchOrderHO();
								oSrchOrderHO.setOrderCatalogCode(checkForNull(resultSet.getString("order_catalog_code")));
								oSrchOrderHO.setGroupName(checkForNull(resultSet.getString("group_name")));
								oSrchOrderHO.setCatalogSynonym(checkForNull(resultSet.getString("catalog_synonym")));
								oSrchOrderHO.setPromptAlertYN(checkForNull(resultSet.getString("prompt_alert_yn")));
								oSrchOrderHO.setPromptMsg(checkForNull(resultSet.getString("prompt_alert_msg")));
								lstSrchOrderHO.add(oSrchOrderHO);
							}
						}
						oSrchOrdRes.setLstSrchOrderHO(lstSrchOrderHO);
					}//
				}
				catch(Exception e){
					  e.printStackTrace() ;
					  throw e;
				  }
				  finally{
					  if ( resultSet != null ) resultSet.close() ;	
					  if ( pstmt != null ) pstmt.close() ;
					  ConnectionManager.returnConnection(connection,request);
				  }
				
				
		 }
		 return oSrchOrdRes;
	 }
	 public String getDischargeAdvDateTime(String patient_id, String encounter_id,HttpServletRequest request) throws Exception
	{
				Connection connection 		= null;
				ResultSet resultSet 	= null;
				PreparedStatement pstmt 	= null;
				String discharge_adv_date_time = null;
				if(request != null)
				{
					try 
					{
						connection	= ConnectionManager.getConnection(request) ;
						if(connection != null)
						{
							pstmt		= connection.prepareStatement("select to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') DIS_ADV_DAT_TIM from ip_discharge_advice where patient_id=? and encounter_id=? and dis_adv_status != '9'"); //--[IN029647]
						}
						if(pstmt != null)
						{
							pstmt.setString(1, patient_id); // pass the patient_id
							pstmt.setString(2, encounter_id); // pass the encounter_id
							resultSet	= pstmt.executeQuery() ;
							if ( resultSet != null )    // Only one record for the module_id
							{
								while(resultSet.next())
								{
									discharge_adv_date_time = checkForNull(resultSet.getString( "DIS_ADV_DAT_TIM" ))  ;
									
								}
							}	// if there is no record, then also it should return as ""
						}
					} 
					 catch ( Exception e )	
					{
	
						e.printStackTrace() ;
						throw e ;
					 } 
					 finally 
					{
						 if ( resultSet != null ) resultSet.close() ;	
						  if ( pstmt != null ) pstmt.close() ;
						  ConnectionManager.returnConnection(connection,request);
					}
				}
				return discharge_adv_date_time;
		}
	 public OrderTypeResponse getOrderType(String orderCategory,String locale,HttpServletRequest request)  throws Exception
	 {
		 OrderTypeResponse oRes = new OrderTypeResponse();
		 List<OrderTypeHO> lstOrderType = new ArrayList<OrderTypeHO>();
		 Connection connection 		= null;
			ResultSet resultSet 	= null;
			PreparedStatement pstmt 	= null;
			
			if(request != null)
			{
				try 
				{
					connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						pstmt		= connection.prepareStatement(" SELECT order_type_code code, short_desc description FROM or_order_type_lang_vw  WHERE language_id = ? AND eff_status = 'E' AND order_category LIKE ?"); //--[IN029647]
					}
					if(pstmt != null)
					{
						pstmt.setString(1, locale); // pass the patient_id
						pstmt.setString(2, orderCategory); // pass the encounter_id
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )    // Only one record for the module_id
						{
							while(resultSet.next())
							{
								OrderTypeHO oTypeHO = new OrderTypeHO();
								oTypeHO.setCode(checkForNull(resultSet.getString("code")))  ;
								oTypeHO.setDescription(checkForNull(resultSet.getString("description")));
								lstOrderType.add(oTypeHO);
								
							}
							oRes.setLstOrderType(lstOrderType);
						}	
					}
				} 
				 catch ( Exception e )	
				{

					e.printStackTrace() ;
					throw e ;
				 } 
				 finally 
				{
					 if ( resultSet != null ) resultSet.close() ;	
					  if ( pstmt != null ) pstmt.close() ;
					  ConnectionManager.returnConnection(connection,request);
				}
			}
		 return oRes;
		 
	 }
}
