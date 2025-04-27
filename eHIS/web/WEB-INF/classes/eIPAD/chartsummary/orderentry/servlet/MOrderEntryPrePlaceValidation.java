/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.orderentry.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.Gson;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.orderentry.response.MOrderEntryErrorItem;
import eIPAD.chartsummary.orderentry.response.MOrderEntryValidationResponse;
import eOR.OrderEntryBean;
import eOR.OrderEntryBillingQueryBean;
import eOR.Common.OrderEntryRecordBean;

/**
 * Servlet implementation class OrderEntryPrePlaceValidation
 * This servlet takes care of the four validations error which in EM will appear pink
 * 1. Billing information error
 * 2. BILLING_SERVICE_NOT_DEFINED error
 * 3. PRIV_ORDER_AUTH_RIGHTS error
 * 4. CATALOG_OPERATIONAL_MODULE error
 * 
 * Code extracted from OrderEntryPlaceOrderCareSetResults.jsp and OrderEntryPlaceOrderResult.jsp
 */
public class MOrderEntryPrePlaceValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		PrintWriter out = response.getWriter();
		
		MOrderEntryValidationResponse validationResponse = new MOrderEntryValidationResponse();
		ArrayList<MOrderEntryErrorItem> errorItems = new ArrayList<MOrderEntryErrorItem>();
		validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_SUCCESS);
		validationResponse.setErrorItems(errorItems);
		
		try{
			if(patientContext!=null){
				String patientId = patientContext.getPatientId();
				String encounterId = patientContext.getEncounterId();
				String locale = patientContext.getLocale();
				String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
				String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
				String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
				
				String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
				String or_bean_name = "eOR.OrderEntryBean";
				OrderEntryBean bean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
				//OrderEntryQueryBean beanQueryObj = new OrderEntryQueryBean();
				//beanQueryObj.setLanguageId(locale);
				String dateString = bean.getSysDate();
				//OrderEntryRecordBean orderEntryRecordBean = (OrderEntryRecordBean) bean.getOrderEntryRecordBean();
				OrderEntryBillingQueryBean bean_qryobj = (OrderEntryBillingQueryBean)PersistenceHelper.getBeanObject("Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request) ;
				String[] billing_details = null;
				ArrayList PlaceOrderItems;
				String[] records = null;
				ArrayList BillChargeInfo;
				String PrivilegeApplicabilityAuth = (String)OrderEntryBean.checkForNull(bean.getAuthorisationOrOrderingYn("AUT"),"");
				
				
				
				if(!orderCategoryCode.equals("CS")){
					String order_type_catalog;
					if(!orderCatalogCode.equals("") && !orderTypeCode.equals("")){
						order_type_catalog = "'"+orderCatalogCode+"'||'"+orderTypeCode+"','1'";
					}else{
						order_type_catalog = "'1||1','1'";
					}
					String order_catalog_code = "'"+orderCatalogCode+"'";
					
					String billing_interface_yn = bean.getBillingInterfaceYn();
					
					PlaceOrderItems = bean.getPlaceOrdersResult(OrderEntryBean.checkForNull(order_type_catalog,"'1||1','1'"),OrderEntryBean.checkForNull(orderCategoryCode,""),OrderEntryBean.checkForNull(order_catalog_code,"''"),"");
					
					if(PlaceOrderItems!=null && !PlaceOrderItems.isEmpty()){
						records =(String[])PlaceOrderItems.get(0);
						if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))
						{
							BillChargeInfo = bean_qryobj.getBillChargeDetails("1",records[0],dateString,locale, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ;
							for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
							{
								billing_details 	= (String[])BillChargeInfo.get(k);
								if(!billing_details[9].equals("")){
									MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
									errorItem.setErrorMessageId(billing_details[9]);
									errorItem.setErrorMessage(billing_details[9]);
									errorItems.add(errorItem);
									validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
								}
								if(billing_details[10].equals("")&&billing_details[11].equals("")){
									MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
									errorItem.setErrorMessageId("BILLING_SERVICE_NOT_DEFINED");
									errorItem.setErrorMessage(bean.getMessage(locale,"BILLING_SERVICE_NOT_DEFINED","OR"));
									errorItems.add(errorItem);
									validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
								}
							
							}
						}
						if(records[48].equalsIgnoreCase("Y")){
							
							String PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth);
							if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
							{
								MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
								errorItem.setErrorMessageId("PRIV_ORDER_AUTH_RIGHTS");
								errorItem.setErrorMessage(bean.getMessage(locale,"PRIV_ORDER_AUTH_RIGHTS","OR"));
								errorItems.add(errorItem);
								validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
							}
						}
						if(records[69].equalsIgnoreCase("N"))
						{
							MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
							errorItem.setErrorMessageId("CATALOG_OPERATIONAL_MODULE");
							errorItem.setErrorMessage(bean.getMessage(locale,"CATALOG_OPERATIONAL_MODULE","OR"));
							errorItems.add(errorItem);
							validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
						}
						
					}
					else{
						MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
						errorItem.setErrorMessageId("NO_RECORD_FOUND_FOR_CRITERIA");
						errorItem.setErrorMessage(bean.getMessage(locale,"NO_RECORD_FOUND_FOR_CRITERIA","common"));
						errorItems.add(errorItem);
						validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
					}
				}else if(orderCategoryCode.equals("CS")){
					
					String ordSetSelectedAlready = bean.checkForNull(bean.getTempvalue("OrderSetChecked"),"0");
					if(ordSetSelectedAlready.equals("1")){
						MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
						errorItem.setErrorMessageId("ORDER_SET_SELECTED");
						errorItem.setErrorMessage(bean.getMessage(locale,"ORDER_SET_SELECTED","OR"));
						errorItems.add(errorItem);
						validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
					}
					else{
						String billing_interface_yn		= bean.getBillingInterfaceYn();
						String billing_order_set_details[] = bean.getOrderSetBillDetails(orderCatalogCode);
						String order_set_bill_yn = OrderEntryBean.checkForNull(billing_order_set_details[1],"N");
						String care_set_catalog_desc = OrderEntryBean.checkForNull(billing_order_set_details[0],"");
						String charge_yn = OrderEntryBean.checkForNull(billing_order_set_details[2],"");
						if(charge_yn.equalsIgnoreCase("N"))
						{
							order_set_bill_yn = "N";
						}
						if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !orderCategoryCode.equals("BT"))
						{
							BillChargeInfo = bean_qryobj.getBillChargeDetails("1",orderCatalogCode,dateString,locale, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
							if(BillChargeInfo==null) 
								BillChargeInfo= new ArrayList();
							billing_details = null;
							for( int m=0 ; m< BillChargeInfo.size() ; m++ ) 
							{
								billing_details 	= (String[])BillChargeInfo.get(m);
								if(!billing_details[9].equals(""))
								{
									MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
									errorItem.setErrorMessageId(billing_details[9]);
									errorItem.setErrorMessage(billing_details[9]);
									errorItems.add(errorItem);
									validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
								}
								if(billing_details[10].equals("")||billing_details[11].equals("")){
									MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
									errorItem.setErrorMessageId("BILLING_SERVICE_NOT_DEFINED");
									errorItem.setErrorMessage(bean.getMessage(locale,"BILLING_SERVICE_NOT_DEFINED","OR"));
									errorItems.add(errorItem);
									validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
								}
									
							}
						}
						ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(OrderEntryBean.checkForNull(orderCatalogCode,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),orderCategoryCode);
						if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
						{
							for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
							{
								String[] care_set_count = (String[])PlaceOrdercareSetCount.get(t);
								ArrayList PlaceOrderSetItems	= bean.getPlaceOrderCareSets(OrderEntryBean.checkForNull(orderCatalogCode,""),care_set_count[1],"");
								String order_set_order_catalog = "";
								String order_type_catalog = "";
								String[] rel_start_date_time	= new String[PlaceOrderSetItems.size()];
								for(int k=0; k<PlaceOrderSetItems.size();k++)			// or for the count
								{
									String[] care_set_group = (String[])PlaceOrderSetItems.get(k);
									order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";
									order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
									rel_start_date_time[k]	= care_set_group[10];
								}
								if(order_set_order_catalog.length() > 0)
									order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
								if(order_type_catalog.length() > 0)
									order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
								
								PlaceOrderItems = bean.getPlaceOrdersResult(OrderEntryBean.checkForNull(order_type_catalog,"''"),OrderEntryBean.checkForNull(care_set_count[1],""),OrderEntryBean.checkForNull(order_set_order_catalog,"''"),""); // Last parameter to identify normalOE or from preview
								if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
								{
									for(int i=0; i<PlaceOrderItems.size(); i++)
									{
										records		= (String[])PlaceOrderItems.get(i);
										if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y"))
										{
											BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",records[0],rel_start_date_time[i], locale, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; 
											if(BillChargeInfo!=null)
											{
												for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
													billing_details 	= (String[])BillChargeInfo.get(k);
													if(!billing_details[9].equals("")){
														MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
														errorItem.setErrorMessageId(billing_details[9]);
														errorItem.setErrorMessage(billing_details[9]);
														errorItems.add(errorItem);
														validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
													}
													if(billing_details[10].equals("")||billing_details[11].equals(""))
													{
														MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
														errorItem.setErrorMessageId("BILLING_SERVICE_NOT_DEFINED");
														errorItem.setErrorMessage(bean.getMessage(locale,"BILLING_SERVICE_NOT_DEFINED","OR"));
														errorItems.add(errorItem);
														validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
													}
													
												}
											}
										}
										if(records[48].equalsIgnoreCase("Y"))
										{
											String PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth);
											if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
											{
												MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
												errorItem.setErrorMessageId("PRIV_ORDER_AUTH_RIGHTS");
												errorItem.setErrorMessage(bean.getMessage(locale,"PRIV_ORDER_AUTH_RIGHTS","OR"));
												errorItems.add(errorItem);
												validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
											}
										}
										if(records[69].equalsIgnoreCase("N"))
										{
											MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
											errorItem.setErrorMessageId("CATALOG_OPERATIONAL_MODULE");
											errorItem.setErrorMessage(bean.getMessage(locale,"CATALOG_OPERATIONAL_MODULE","OR"));
											errorItems.add(errorItem);
											validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
										}
									}
								}
								else{
									MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
									errorItem.setErrorMessageId("NO_RECORD_FOUND_FOR_CRITERIA");
									errorItem.setErrorMessage(bean.getMessage(locale,"NO_RECORD_FOUND_FOR_CRITERIA","common"));
									errorItems.add(errorItem);
									validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
								}
							}
						}
					}
				}
			}else{
				validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
			}
		}
		catch(Exception e){
			validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
			out.println(e.getMessage());
		}
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(validationResponse));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
