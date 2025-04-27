/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingorders.daoimpl;

import eCommon.Common.CommonBean;
import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;
import  eIPAD.chartsummary.pendingorders.dao.*;
import  eIPAD.chartsummary.pendingorders.request.*;
import  eIPAD.chartsummary.pendingorders.response.*;
import  eIPAD.chartsummary.pendingorders.healthobject.*;
import eOR.Common.OrRepository;
import eOR.Common.OrRepositoryExt;

public class PendingOrderDAOImpl extends GenericDAOImpl implements PendingOrderDAO{ 
	public PendingOrderResponse getPendingOrdersDetails(PendingOrderRequest oPendingOrderReq)
	{
		PendingOrderResponse oPendingOrderResponse = new PendingOrderResponse();
		Connection connection 		= null;
		PreparedStatement pStmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String strPatientId = "";
		StringBuffer sqlStr = new StringBuffer("");
		String strPracType = "";
		String encounterId;
		List<PendingOrders> pendingOrdersList = new ArrayList<PendingOrders>();
		ErrorInfo oErrInfo = new ErrorInfo();
		if(oPendingOrderReq != null)
		{
			PatContext oPatContext = oPendingOrderReq.getPatientContext();
			if(oPatContext != null)
			{
				List<PendingOrderItems> pendingOrderItemsList;
				Map<PendingOrders,List<PendingOrderItems>> pendingOrdersMap = new LinkedHashMap<PendingOrders,List<PendingOrderItems>>();
				strPatientId = checkForNull(oPatContext.getPatientId());
				locale =  checkForNull(oPatContext.getLocale());
				strPracType = checkForNull(oPatContext.getPracType());
				encounterId = (oPatContext.getSelectedEncounterId() == null || oPatContext.getSelectedEncounterId().equals("")) ? oPatContext.getEncounterId() : oPatContext.getSelectedEncounterId();
				if(locale.equals(""))
				{
					locale = "en";
				}
				
				sqlStr.append("SELECT DISTINCT c.short_desc order_category_short_desc,f.short_desc order_status_desc,start_date_time,c.order_category,TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time, ");
				sqlStr.append(" or_get_order_catalog (a.order_id, a.order_type_code,'" + locale+ "','"+ strPracType +"',b.order_line_num) item_short_desc,a.ord_pract_id,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn , b.order_id order_id, b.order_line_num order_line_num, ");
				sqlStr.append(" (CASE  WHEN a.ord_pract_id IS NOT NULL THEN  (SELECT short_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.ord_pract_id and language_id = '"+locale+"') END) pract_short_name ");
				sqlStr.append(" FROM or_order a,or_order_line b,or_order_category_lang_vw c,am_duration_type d,or_catalog_synonym_lang_vw e, or_order_status_code f ");
				sqlStr.append(" WHERE b.order_category = c.order_category AND b.order_catalog_code = e.order_catalog_code AND e.language_id = '" + locale+ "' ");
				sqlStr.append(" AND catalog_synonym_type = or_get_synonym_type ('"+ strPracType +"', b.order_catalog_code) AND patient_id = '" + strPatientId + "' and a.encounter_id='"+encounterId+"' ");
				sqlStr.append(" AND a.order_id = b.order_id AND b.durn_type = d.durn_type(+) AND b.order_line_status IN ( SELECT order_status_code FROM or_order_status_code ");
				sqlStr.append(" WHERE order_status_type IN (10, 15, 16, 17, 20, 23, 25, 30, 40, 45, 50, 52, 54, 55, 65, 67)) and f.order_status_code =  b.order_line_status  AND NVL (a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') ");
				sqlStr.append(" AND EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code AND order_catalog_nature != 'S') AND c.language_id = '" + locale+ "' ");
				if(oPendingOrderReq.getOrderCategory() != null && !oPendingOrderReq.getOrderCategory().equals(""))
				{
					sqlStr.append(" and c.order_category = '" + oPendingOrderReq.getOrderCategory() +"' ");
				}
	            sqlStr.append(" ORDER BY 1,2 DESC ");
	            try
	            {
	            	connection = createConnection();
					if(connection != null)
					{
						pStmt = connection.prepareStatement(sqlStr.toString());
						
					}
					if(pStmt != null){
						resultSet = pStmt.executeQuery();
					}
					if(resultSet != null)
					{
						while(resultSet.next())
						{
							PendingOrders oPendingOrders = new PendingOrders();
							PendingOrderItems oPendingOrdersItems = new PendingOrderItems();
							
							oPendingOrders.setOrderCategory(checkForNull(resultSet.getString("order_category")));
							oPendingOrders.setOrderCategoryDescription(checkForNull(resultSet.getString("order_category_short_desc")));
							
							oPendingOrdersItems.setCatalogDescription(checkForNull(resultSet.getString("item_short_desc")));
							oPendingOrdersItems.setOrderDateTime(checkForNull(resultSet.getString("test_date_time")));
							oPendingOrdersItems.setFormatExistYN(checkForNull(resultSet.getString("format_exist_yn")));
							oPendingOrdersItems.setOrderId(checkForNull(resultSet.getString("order_id")));
							oPendingOrdersItems.setOrderLineNum(checkForNull(resultSet.getString("order_line_num")));
							oPendingOrdersItems.setPractitionerId(checkForNull(resultSet.getString("ord_pract_id")));
							oPendingOrdersItems.setPractitionerName(checkForNull(resultSet.getString("pract_short_name")));
							oPendingOrdersItems.setOrderStatusDesc(checkForNull(resultSet.getString("order_status_desc")));
							
							if(pendingOrdersMap.containsKey(oPendingOrders))
							{
								pendingOrdersMap.get(oPendingOrders).add(oPendingOrdersItems);
							}
							else
							{
								pendingOrderItemsList = new ArrayList<PendingOrderItems>();
								pendingOrderItemsList.add(oPendingOrdersItems);
								pendingOrdersMap.put(oPendingOrders, pendingOrderItemsList);
							}
						}
						Iterator<Entry<PendingOrders,List<PendingOrderItems>>> iter = pendingOrdersMap.entrySet().iterator();
						while(iter.hasNext())
						{
							Map.Entry<PendingOrders,List<PendingOrderItems>> mEntry = iter.next();
							PendingOrders oPendingOrdersEntry = mEntry.getKey();
							List<PendingOrderItems> pendingOrderItemsListEntry = mEntry.getValue();
							if(pendingOrderItemsListEntry != null && oPendingOrdersEntry != null)
							{
								oPendingOrdersEntry.setListCount(pendingOrderItemsListEntry.size());
								oPendingOrdersEntry.setPendingOrderItemList(pendingOrderItemsListEntry);
							}
							pendingOrdersList.add(oPendingOrdersEntry);
						}
						if(pendingOrdersList != null && pendingOrdersList.size() == 0)
						{
							oErrInfo.setErrorType(Errors.PENDINGORDER_EMPTY_DATA, locale);
						}
						oPendingOrderResponse.setPendingOrderList(pendingOrdersList);
					}
	            }
	            catch(Exception e)
	            {
	            	e.printStackTrace();
	            	oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
	            }
	            finally
	            {
	            	int conCloseFailure = closeConnection(connection,pStmt,resultSet);
					if(conCloseFailure > 0)
					{
						System.out.println("Connection not closed in the method eIPAD.chartsummary.pendingorders.daoimpl.getPendingOrdersDetails");
					}
	            }
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		oPendingOrderResponse.getErrorsList().add(oErrInfo);
		return oPendingOrderResponse;
	}
	
	public PendingOrderCountResponse getPendingOrderItemsCount(PatContext rPatContext){
		PendingOrderCountResponse response = new PendingOrderCountResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(rPatContext!=null){
			locale = (rPatContext.getLocale() == null || rPatContext.getLocale().equals("")) ? "en": rPatContext.getLocale();
			String patientId = rPatContext.getPatientId();
			String encounterId =(rPatContext.getSelectedEncounterId() == null || rPatContext.getSelectedEncounterId().equals("")) ? rPatContext.getEncounterId() : rPatContext.getSelectedEncounterId();
			
			ArrayList<PendingOrderCountHO> catCountList = new ArrayList<PendingOrderCountHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer pendOrdCountQuery = new StringBuffer("");
			pendOrdCountQuery.append("select count , d.order_category, c.short_desc  from (SELECT count(*) count, a.order_category order_category ");
			pendOrdCountQuery.append(" FROM or_order a,or_order_line b WHERE patient_id = '"+patientId+"' and a.encounter_id='"+encounterId+"' ");
			pendOrdCountQuery.append(" AND a.order_id = b.order_id AND b.order_line_status IN ( SELECT order_status_code FROM or_order_status_code ");
			pendOrdCountQuery.append(" WHERE order_status_type IN (10, 15, 16, 17, 20, 23, 25, 30, 40, 45, 50, 52, 54, 55, 65, 67)) AND NVL (a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') ");
			pendOrdCountQuery.append(" AND EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code AND order_catalog_nature != 'S') ");
			pendOrdCountQuery.append(" group by a.order_category) d, or_order_category_lang_vw c where d.order_category = c.order_category and c.language_id='"+locale+"' ");
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(pendOrdCountQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String orderCatCode;
						String orderCatDesc;
						int orderCount;
						int totalCount = 0;
						while(rs.next())
						{
							orderCatCode=rs.getString("order_category")==null?"":rs.getString("order_category");
							orderCatDesc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
							orderCount=rs.getInt("count");
							totalCount = totalCount + orderCount;
							
							PendingOrderCountHO pendingOrderCountHO = new PendingOrderCountHO();
							pendingOrderCountHO.setOrderCategoryCode(orderCatCode);
							pendingOrderCountHO.setOrderCategoryDesc(orderCatDesc);
							pendingOrderCountHO.setOrderCount(orderCount);
							
							catCountList.add(pendingOrderCountHO);
						}
						
						response.setPendingOrderCountList(catCountList);
						response.setPendingOrdersTotalCount(totalCount);
						if(catCountList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.PENDINGORDER_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching Pending Order details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
				
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	public PendingOrderFormatResponse getOrderFormatDetail(PatContext rPatContext, String order_id){
		PendingOrderFormatResponse response = new PendingOrderFormatResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String login_facility_id = rPatContext.getFacilityId();
		String language_id = rPatContext.getLocale();
		if(rPatContext!=null && order_id!=null){
			
			Connection connection = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			//PreparedStatement pstmt2 = null;
			PreparedStatement pstmt3 = null;
			PreparedStatement pstmt4 = null;
			PreparedStatement pstmt5 = null;
			PreparedStatement pstmt6 = null;
			//PreparedStatement pstmt7 = null;
			ResultSet resultSet = null;
			ResultSet resultSet1 = null;
			//ResultSet resultSet2 = null;
			ResultSet resultSet3 = null;
			ResultSet resultSet4 = null;
			ResultSet resultSet5 = null;
			ResultSet resultSet6 = null;
			//ResultSet resultSet7 = null;
			
			List<String[]> order_format_dtl = new ArrayList<String[]>();
			//String lb_install_yn 		= "N";commented for lb_install_yn change on 7/18/2007 by uma
			String bt_install_yn 		= "N";
			String rd_install_yn 		= "N";
			String ot_install_yn		= "N";
			String order_category		= "";
			//String[] record2 = null;
			String[] record1 = null;
			String labchk="";
			
			//StringBuffer pendOrdFormatQuery = new StringBuffer("");
			
			try{
				connection = createConnection();
				if(connection == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					
					if(order_id!=null && order_id.length() >2)
						order_category = order_id.substring(0,2); // First 2 characters for order_category

					/*if(order_category.equals("LB")){
						pstmt2 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt2.setString(1, "RL");
						pstmt2.setString(2, login_facility_id);
						resultSet2 = pstmt2.executeQuery() ;
						if(resultSet2!=null && resultSet2.next() ) {
							lb_install_yn = 	resultSet2.getString("operational_yn")  ;
						}
					}commented on 7/18/2007 for lb_install_yn change by uma*/

					if(order_category.equals("LB")){
						pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt3.setString(1, "BT");
						pstmt3.setString(2, login_facility_id);
						resultSet3 = pstmt3.executeQuery() ;
						if(resultSet3!=null &&  resultSet3.next() ) {
							bt_install_yn = 	resultSet3.getString("operational_yn")  ;
						}
					}else if(order_category.equals("RD")){
						pstmt4 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt4.setString(1, "RD");
						pstmt4.setString(2, login_facility_id);
						resultSet4 = pstmt4.executeQuery() ;
						if(resultSet4!=null &&  resultSet4.next() ) {
							rd_install_yn = 	resultSet4.getString("operational_yn")  ;
						}
					}else if(order_category.equals("OT")){
						pstmt5 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt5.setString(1, "OT");
						pstmt5.setString(2, login_facility_id);
						resultSet5 = pstmt5.executeQuery() ;
						if(resultSet5!=null &&  resultSet5.next() ) {
							ot_install_yn = 	resultSet5.getString("operational_yn")  ;
						}
					}


					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_CMTS") ) ;
					pstmt.setString(1, (String)order_id.trim());
					resultSet = pstmt.executeQuery() ;
					while( resultSet != null && resultSet.next() ) {
						String record[] = new String[6];

						record[0] = resultSet.getString("order_field_type")  ;
						record[1] = resultSet.getString("order_label_text")  ;
						record[2] = resultSet.getString("order_field_value")  ;
						record[3] = resultSet.getString("accept_option")  ;
						record[4] = resultSet.getString("discr_msr_uom")  ;
						record[5] = resultSet.getString("order_field_mnemonic")  ;

						if(order_category.equals("LB")){
							pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
							pstmt6.setString( 1, CommonBean.checkForNull(order_id.trim(),"") );
	
							resultSet6 = pstmt6.executeQuery() ;
							if( resultSet6 != null && resultSet6.next() ) {
									 record1 = new String[2];// Only One record
									record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
									record1[1]=resultSet6.getString( "order_type_code" )  ;
							}
							labchk=CommonBean.checkForNull(getmoduleRL(record1[0],order_category,record1[1],login_facility_id),"");
						}
						//if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("SPECIMEN_TYPE") )//changed on 7/18/2007 for lb_instal_yn change check by uma
						if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("SPECIMEN_TYPE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							pstmt1.setString(2, language_id);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma
						else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_field_mnemonic").equals("DONOR_BLOOD_GROUP") )
						{
							record[2]=CommonBean.checkForNull(record[2],"");
							if(record[2].equals("null"))record[2]="";
							if(!record[2].equals(""))
							{
								pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
								pstmt1.setString(1, record[2]);
								resultSet1 = pstmt1.executeQuery() ;
								if(resultSet1!=null && resultSet1.next() ) {	// One rec
									record[2] = resultSet1.getString("description")  ;
								}
							}
						//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma
						}
						else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_field_mnemonic").equals("DONOR_RHESUS") )
						{
								record[2]=CommonBean.checkForNull(record[2],"");
								if(record[2].equals("null"))record[2]="";
								if(!record[2].equals(""))
								{
									pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
									pstmt1.setString(1, record[2]);
									resultSet1 = pstmt1.executeQuery() ;
									if(resultSet1!=null && resultSet1.next() ) {	// One rec
										record[2] = resultSet1.getString("description")  ;
									}
							}
										//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma
						}
						 else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						} else if(order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("ANATOMY_SITE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
							pstmt1.setString(1,language_id);
							pstmt1.setString(2, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC") )changed on 7/18/2007 for lb_install_yn change by uma
						} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("FIXATIVE") )changed on 7/18/2007 for lb_install_yn change by uma
						} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("FIXATIVE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("TRANSPORT_MODE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("STUDY_LOC") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PATIENT_POSITION") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
						{
							// For both OT install or OT not  uninstalled

									pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
									pstmt1.setString(1, language_id);
									pstmt1.setString(2, order_id);
									resultSet1 = pstmt1.executeQuery() ;

									if(resultSet1!=null && resultSet1.next() )
									{	// One rec
										record[2] = resultSet1.getString("description")  ;
									}
						}
						else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_field_mnemonic").equals("OT_OPER_KEYWORD") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(order_category.equals("CN") && (resultSet.getString("order_field_mnemonic").equals("PERFORM_PRACT_ID") || resultSet.getString("order_field_mnemonic").equals("CONULT_MED_ID")) )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_AM_PRACTITIONER_PERFORM_TEAM_SURGEON") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_field_mnemonic").equals("ANAESTHETIST_CODE") )
						{

							pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}

						}
						else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
						{

							pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}

						}else if(((order_category.trim()).equalsIgnoreCase("OT"))  && (resultSet.getString("order_field_mnemonic").equals("ANAESTHESIA")) )    // For OT ANAESTHESIA
						{

							pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}

						}
						/*Added by Uma on 2/22/2010 for IN017828 SRR20056-CRF-0587*/
						else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("BLOOD_PRODUCT_PROCESS") )
						{
							pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						/*Ends Here 2/22/2010 for IN017828 SRR20056-CRF-0587*/

						//closeResultSet( resultSet1 ) ;
						//closeStatement( pstmt1 ) ;

						order_format_dtl.add(record);
					}
					//pstmt=con.prepareStatement(pendOrdFormatQuery.toString());
					//rs = pstmt.executeQuery();
					/*if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						while(rs.next()){
							
						}
					}*/
				}
				response.setOrderFormatDtl(order_format_dtl);
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(connection,pstmt,resultSet);
				conCloseFailure = closeConnection(pstmt1);
				conCloseFailure = closeConnection(resultSet1);
				conCloseFailure = closeConnection(pstmt3);
				conCloseFailure = closeConnection(resultSet3);
				conCloseFailure = closeConnection(pstmt4);
				conCloseFailure = closeConnection(resultSet4);
				conCloseFailure = closeConnection(pstmt5);
				conCloseFailure = closeConnection(resultSet5);
				conCloseFailure = closeConnection(pstmt6);
				conCloseFailure = closeConnection(resultSet6);
			}
			
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	public PendingOrderFormatResponse getOrderFormatLineDetail(PatContext rPatContext, String order_id, String line_id, String called_from){
		PendingOrderFormatResponse response = new PendingOrderFormatResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String login_facility_id = rPatContext.getFacilityId();
		String language_id = rPatContext.getLocale();
		if(rPatContext!=null && order_id!=null){
			
			Connection connection = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			//PreparedStatement pstmt2 = null;
			PreparedStatement pstmt3 = null;
			PreparedStatement pstmt4 = null;
			PreparedStatement pstmt5 = null;
			PreparedStatement pstmt6 = null;
			//PreparedStatement pstmt7 = null;
			ResultSet resultSet = null;
			ResultSet resultSet1 = null;
			//ResultSet resultSet2 = null;
			ResultSet resultSet3 = null;
			ResultSet resultSet4 = null;
			ResultSet resultSet5 = null;
			ResultSet resultSet6 = null;
			//ResultSet resultSet7 = null;
			
			List<String[]> order_format_dtl = new ArrayList<String[]>();
			//String lb_install_yn 		= "N";commented for lb_install_yn change on 7/18/2007 by uma
			String bt_install_yn 		= "N";
			String rd_install_yn 		= "N";
			String ot_install_yn		= "N";
			String order_category		= "";
			//String[] record2 = null;
			String[] record1 = null;
			String labchk="";
			
			//StringBuffer pendOrdFormatQuery = new StringBuffer("");
			
			try{
				connection = createConnection();
				if(connection == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					
					if(order_id!=null && order_id.length() >2)
						order_category = order_id.substring(0,2); // First 2 characters for order_category

					/*if(order_category.equals("LB")){
						pstmt2 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt2.setString(1, "RL");
						pstmt2.setString(2, login_facility_id);
						resultSet2 = pstmt2.executeQuery() ;
						if(resultSet2!=null && resultSet2.next() ) {
							lb_install_yn = 	resultSet2.getString("operational_yn")  ;
						}
					}commented on 7/18/2007 for lb_install_yn logic change by uma */
					 if(order_category.equals("LB")){
						pstmt6 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS") ) ;
						pstmt6.setString( 1, CommonBean.checkForNull((String)order_id.trim(),"") );

						resultSet6 = pstmt6.executeQuery() ;
						if( resultSet6 != null && resultSet6.next() ) {
								 record1 = new String[2];// Only One record
								record1[0]=resultSet6.getString( "ORDER_CATALOG_CODE" )  ;
								record1[1]=resultSet6.getString( "order_type_code" )  ;
						}
						labchk=CommonBean.checkForNull(getmoduleRL(record1[0],order_category,record1[1],login_facility_id),"");

					}
					if(order_category.equals("LB")){
						pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt3.setString(1, "BT");
						pstmt3.setString(2, login_facility_id);
						resultSet3 = pstmt3.executeQuery() ;
						if(resultSet3!=null &&  resultSet3.next() ) {
							bt_install_yn = 	resultSet3.getString("operational_yn")  ;
						}
					} else if(order_category.equals("RD")){
						pstmt4 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt4.setString(1, "RD");
						pstmt4.setString(2, login_facility_id);
						resultSet4 = pstmt4.executeQuery() ;
						if(resultSet4!=null &&  resultSet4.next() ) {
							rd_install_yn = 	resultSet4.getString("operational_yn")  ;
						}
					}else if(order_category.equals("OT")){
						pstmt5 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt5.setString(1, "OT");
						pstmt5.setString(2, login_facility_id);
						resultSet5 = pstmt5.executeQuery() ;
						if(resultSet5!=null &&  resultSet5.next() ) {
							ot_install_yn = 	resultSet5.getString("operational_yn")  ;
						}
					}
					if(called_from!=null && called_from.equals("RESULT_ENTRY"))
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_RESULT_ENTRY_CMTS") ) ;
					else
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_CMTS") ) ;

					pstmt.setString(1, (String)order_id.trim());
					pstmt.setString(2, (String)line_id.trim());
					resultSet = pstmt.executeQuery() ;
					while( resultSet != null && resultSet.next() ) {
						//String record[] = new String[8]; //Changed index IN045798
						String record[] = new String[9];
						record[0] = resultSet.getString("order_line_field_type")  ;
						record[1] = resultSet.getString("order_line_label_text")  ;
						record[2] = resultSet.getString("order_line_field_value")  ;
						record[3] = resultSet.getString("item_narration")  ;
						record[4] = resultSet.getString("order_line_field_mnemonic")  ;
						record[5] = resultSet.getString("order_line_num")  ;
						record[6] = resultSet.getString("catalog_synonym_dc");
						record[7] = resultSet.getString("discr_msr_uom");
						record[8] = resultSet.getString("accept_option");//IN045798

						//if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE") )changed on 7/18/2007 for lb_install_yn logic change by uma
						if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							pstmt1.setString(2, language_id);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_line_field_mnemonic").equals("DONOR_BLOOD_GROUP") )
						{
							record[2]=CommonBean.checkForNull(record[2],"");
							if(!record[2].equals(""))
							{
								pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
								pstmt1.setString(1, record[2]);
								resultSet1 = pstmt1.executeQuery() ;
								if(resultSet1!=null && resultSet1.next() ) {	// One rec
									record[2] = resultSet1.getString("description")  ;
								}
							}
						//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma
						}
						else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && 	resultSet.getString("order_line_field_mnemonic").equals("DONOR_RHESUS") )
						{
							record[2]=CommonBean.checkForNull(record[2],"");
							if(!record[2].equals(""))
							{
											pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
											pstmt1.setString(1, record[2]);
											resultSet1 = pstmt1.executeQuery() ;
											if(resultSet1!=null && resultSet1.next() ) {	// One rec
												record[2] = resultSet1.getString("description")  ;
											}
								}
										//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT") )changed on 7/18/2007 for lb_install_yn change by uma
						}
						else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("REQUEST_COMMENT") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						} else if(order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("ANATOMY_SITE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC") )changed on 7/18/2007 for lb_install_yn logic change by uma
						} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						//} else if(lb_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE") )changed on 7/18/2007 for lb_instal_yn logic change by uma
						} else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(bt_install_yn.equals("Y") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("BLOOD_CATEGORY_RQST") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("TRANSPORT_MODE") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("EXAM_VIEW_REQSTD") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("STUDY_LOC") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(rd_install_yn.equals("Y") && order_category.equals("RD") && resultSet.getString("order_line_field_mnemonic").equals("REQUEST_COMMENT") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PATIENT_POSITION") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("PERFORM_TEAM_SURGEON") )
						{
							// For both OT install or OT not  uninstalled
							pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON") ) ;
									pstmt1.setString(1, language_id);
									pstmt1.setString(2, order_id);
									resultSet1 = pstmt1.executeQuery() ;

									if(resultSet1!=null && resultSet1.next() )
									{	// One rec
										record[2] = resultSet1.getString("description")  ;
									}
						}
						else if(ot_install_yn.equals("Y") && order_category.equals("OT") && resultSet.getString("order_line_field_mnemonic").equals("OT_OPER_KEYWORD") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(ot_install_yn.equals("Y") && order_category.equals("OT") && (resultSet.getString("order_line_field_mnemonic").equals("PROSTHESIS_IMPLANT") || resultSet.getString("order_line_field_mnemonic").equals("CONSIGNMENT_IMPLANT") ) )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						else if(order_category.equals("PH") && resultSet.getString("order_line_field_mnemonic").equals("PRES_REMARKS") )
						{
							pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PH_PRES_REMARK") ) ;
							pstmt1.setString(1, record[2]);
							pstmt1.setString(2, language_id);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}else if(order_category.equals("OT") && ot_install_yn.equalsIgnoreCase("Y") && resultSet.getString("order_line_field_mnemonic").equals("ANAESTHETIST_CODE") )
						{

							pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}

						}
						else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
						{

							pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY") ) ;
							pstmt1.setString(1, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}

						}
						else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && (resultSet.getString("order_line_field_mnemonic").equals("ANAESTHESIA")) )    // For OT SURGERY_TYPE
						{

							pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}

						}
						/*Added by Uma on 2/22/2010 for IN017828 SRR20056-CRF-0587*/
						else if(labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") && resultSet.getString("order_line_field_mnemonic").equals("BLOOD_PRODUCT_PROCESS") )
						{
							pstmt1 = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC") ) ;
							pstmt1.setString(1, language_id);
							pstmt1.setString(2, record[2]);
							resultSet1 = pstmt1.executeQuery() ;
							if(resultSet1!=null && resultSet1.next() ) {	// One rec
								record[2] = resultSet1.getString("description")  ;
							}
						}
						/*Ends Here 2/22/2010 for IN017828 SRR20056-CRF-0587*/

						order_format_dtl.add(record);
					}
				}
				
				response.setOrderFormatDtl(order_format_dtl);
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(connection,pstmt,resultSet);
				conCloseFailure = closeConnection(pstmt1);
				conCloseFailure = closeConnection(resultSet1);
				conCloseFailure = closeConnection(pstmt3);
				conCloseFailure = closeConnection(resultSet3);
				conCloseFailure = closeConnection(pstmt4);
				conCloseFailure = closeConnection(resultSet4);
				conCloseFailure = closeConnection(pstmt5);
				conCloseFailure = closeConnection(resultSet5);
				conCloseFailure = closeConnection(pstmt6);
				conCloseFailure = closeConnection(resultSet6);
			}
			
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
	private String getmoduleRL(String catalogcode, String categorycode,String ordertypecode, String facility_id) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String modname = "";
		try {
			connection = createConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("OR_GET_INTERFACED_APPL"));
			pstmt.setString(1, (String) catalogcode);
			pstmt.setString(2, (String) categorycode);
			pstmt.setString(3, (String) ordertypecode);
			pstmt.setString(4, (String) facility_id);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				modname = rs.getString("modname");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally {
			int conCloseFailure = closeConnection(connection,pstmt,rs);
		}
		return modname;
	}
}
