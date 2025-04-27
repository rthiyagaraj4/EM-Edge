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
import java.util.HashMap;

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

/**
 * Servlet implementation class MOrderEntryValidateAddToCart
 */
public class MOrderEntryValidateAddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MOrderEntryValidateAddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

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
				String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
				String or_bean_name = "eOR.OrderEntryBean";
				
				String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
				String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
				String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
				String check_box_value = request.getParameter("check_box_value") == null ? "":request.getParameter("check_box_value");
				OrderEntryBean bean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
				eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
				String dateString = bean.getSysDate();
				OrderEntryBillingQueryBean bean_qryobj = (OrderEntryBillingQueryBean)PersistenceHelper.getBeanObject("Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request);
				eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
				String[] billing_details = null;
				ArrayList PlaceOrderItems;
				String[] records = null;
				ArrayList BillChargeInfo;
				String PrivilegeApplicabilityAuth = (String)OrderEntryBean.checkForNull(bean.getAuthorisationOrOrderingYn("AUT"),"");
				
				ArrayList PlaceOrderType		= null;
				ArrayList Default = null;
				String qty_value = "";
				String[] recordDefault = null;
				String patientDischargedYn = bean.getPatientDischarged();
				ArrayList PlaceOrderFrequency	= null;
				String[] frequencyRecords	   = null;
				ArrayList performingLocationCode= null;
				String[] performingLocation		   = null;
				ArrayList DeptLocationCode 		= null;
			  	String[] deptLocation		   = null;
			  	String fac_selected = "";
			  	String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
				String rd_instal_yn				= "N";
			  	if(orderCategoryCode.equals("RD")||orderCategoryCode.equals("CS"))
					rd_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N");
			  	String show_bill_info_yn = bean.getBillingInterfaceShowYn();
			  	HashMap setBills_dtls				= null;
			  	String billing_interface_yn = bean.getBillingInterfaceYn();
			  	
			  	String[] care_set_count 		= null; 
			  	String order_types_comb			= "";
			  	ArrayList PlaceOrderSetItems 	= null;
			  	String[] care_set_group			= null;
			  	String order_set_order_catalog	= "";
			  	String order_type_catalog 		= "";
				
				if(!orderCategoryCode.equals("CS")){
					//String order_type_catalog;
					if(!orderCatalogCode.equals("") && !orderTypeCode.equals("")){
						order_type_catalog = "'"+orderCatalogCode+"'||'"+orderTypeCode+"','1'";
					}else{
						order_type_catalog = "'1||1','1'";
					}
					String order_catalog_code = "'"+orderCatalogCode+"'";
					
					
					
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
					if(validationResponse.getValidationResult() == (MOrderEntryValidationResponse.VALIDATION_SUCCESS)){
						bean.setTempValues("start_date_time"+records[0],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale));
						//PlaceOrderType = bean.getPlaceOrderType(records[0]);
						//(String[])PlaceOrderType.get(j)[0]
						bean.setTempValues("order_type_code"+records[0],orderTypeCode);
						bean.setTempValues("priority"+records[0],"R");
						Default = bean.getPlaceOrderDefault(records[0]);
						recordDefault	 = ((String[])Default.get(0));
						if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
		 				if(recordDefault!=null){
							qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
							if(qty_value.equals("0")) qty_value = "1";
						}else{
							qty_value	 = "1"; 
						}
						bean.setTempValues("quantity"+records[0],qty_value);
						if(patientDischargedYn.equalsIgnoreCase("N"))
						{
							PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
							if(PlaceOrderFrequency!=null && !PlaceOrderFrequency.isEmpty()){
								frequencyRecords = (String[]) PlaceOrderFrequency.get(0);
							}
							if(frequencyRecords!=null && frequencyRecords.length>0){
								bean.setTempValues("frequency_code"+records[0],frequencyRecords[0]);
							}
							else{
								bean.setTempValues("frequency_code"+records[0],"");
							}
							
						}else{
							bean.setTempValues("frequency_code"+records[0],"");
						}
						bean.setTempValues("duration_code"+records[0],"");
						bean.setTempValues("duration_value"+records[0],"");
						
						if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ){ 
							fac_selected = bean.getTempvalue("performing_facility_id"+records[0])==null?login_facility_id:bean.getTempvalue("performing_facility_id"+records[0]);
							
							performingLocationCode = bean.getPerformingLocation(orderCategoryCode,orderTypeCode,records[0]);
							if(performingLocationCode!=null && !performingLocationCode.isEmpty()){
								performingLocation	= (String[]) performingLocationCode.get(0);
							}
				 			if(performingLocation!=null && performingLocation.length>0){
				 				bean.setTempValues("performing_facility_id"+records[0],performingLocation[0]);
					 			bean.setTempValues("performing_facility_desc"+records[0],performingLocation[1]);
				 			}
				 			DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],orderCategoryCode,orderTypeCode,rd_instal_yn);
				 			if(DeptLocationCode!=null && !DeptLocationCode.isEmpty()){
				 				deptLocation	= (String[]) DeptLocationCode.get(0);
				 			}
			 				if(deptLocation!=null && deptLocation.length>0){
				 				bean.setTempValues("performing_dept_loc_code"+records[0],deptLocation[0]);
					 			bean.setTempValues("performing_dept_loc_desc"+records[0],deptLocation[1]);
				 			}
			 				else{
			 					bean.setTempValues("performing_dept_loc_code"+records[0],"");
					 			bean.setTempValues("performing_dept_loc_desc"+records[0],"");
			 				}

				 			
						}
						else{
							bean.setTempValues("performing_facility_id"+records[0],records[5]);
				 			bean.setTempValues("performing_facility_desc"+records[0],bean.getPerformingFacilityName(records[5]));
				 			bean.setTempValues("performing_dept_loc_code"+records[0],"");
				 			bean.setTempValues("performing_dept_loc_desc"+records[0],"");
						}
						if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && show_bill_info_yn.equals("Y"))
						{
				 			//out.println("</br> Billing applicable");
				 			BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString,locale, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
				 			if(BillChargeInfo!=null)
							{
				 				for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
								{
				 					billing_details 	= (String[])BillChargeInfo.get(k);
				 					setBills_dtls		= new HashMap();
				
				 					setBills_dtls.put("charged_yn"       , billing_details[1]);
				 					setBills_dtls.put("total_payable"    , billing_details[2]);
				 					setBills_dtls.put("patient_payable"  , billing_details[3]);
				 					setBills_dtls.put("quantity"         , qty_value);
				 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
				 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
				 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
				 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
				 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
									setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
									setBills_dtls.put("serv_panel_code"  , billing_details[11]);
									setBills_dtls.put("p_episode_type"	 , billing_details[13]);
									setBills_dtls.put("p_episode_id"	 , billing_details[14]);
									setBills_dtls.put("p_visit_id"		 , billing_details[15]);
									setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
									setBills_dtls.put("error_text"		 , billing_details[9]);
									setBills_dtls.put("rate"		 ,"");
									setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
									setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
									orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 
								}
							}
						}
					}
				}else if(orderCategoryCode.equals("CS")){
					
					String order_catalog_code = orderCatalogCode;
					String localeName = locale;
					String order_category = orderCategoryCode;
					String patient_id = patientId;
					String ordSetSelectedAlready = bean.checkForNull(bean.getTempvalue("OrderSetChecked"),"0");
					if(ordSetSelectedAlready.equals("1")){
						MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
						errorItem.setErrorMessageId("ORDER_SET_SELECTED");
						errorItem.setErrorMessage(bean.getMessage(locale,"ORDER_SET_SELECTED","OR"));
						errorItems.add(errorItem);
						validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
					}
					else{
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
								care_set_count = (String[])PlaceOrdercareSetCount.get(t);
								PlaceOrderSetItems	= bean.getPlaceOrderCareSets(OrderEntryBean.checkForNull(orderCatalogCode,""),care_set_count[1],"");
								order_set_order_catalog = "";
								order_type_catalog = "";
								String[] rel_start_date_time	= new String[PlaceOrderSetItems.size()];
								for(int k=0; k<PlaceOrderSetItems.size();k++)			// or for the count
								{
									care_set_group = (String[])PlaceOrderSetItems.get(k);
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
									order_set_order_catalog = ""; // Remove the values
									order_type_catalog			 = ""; // Remove the values
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
						//if validation was successful add details to the bean
						if(validationResponse.getValidationResult() == (MOrderEntryValidationResponse.VALIDATION_SUCCESS)){
							if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !orderCategoryCode.equals("BT") && show_bill_info_yn.equals("Y"))
							{
								BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",orderCatalogCode,dateString,locale, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ;
					 			if(BillChargeInfo!=null)
								{
									for( int m=0 ; m< BillChargeInfo.size() ; m++ )
									{
										billing_details 	= (String[])BillChargeInfo.get(m);
					 					setBills_dtls		= new HashMap();
					
					 					setBills_dtls.put("charged_yn"       , billing_details[1]);
					 					setBills_dtls.put("total_payable"    , billing_details[2]);
					 					setBills_dtls.put("patient_payable"  , billing_details[3]);
					 					setBills_dtls.put("quantity"         , qty_value);
					 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
					 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
					 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
					 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
					 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
					 					setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
					 					setBills_dtls.put("serv_panel_code"  , billing_details[11]);
					 					setBills_dtls.put("p_episode_type"	 , billing_details[13]);
					 					setBills_dtls.put("p_episode_id"	 , billing_details[14]);
					 					setBills_dtls.put("p_visit_id"		 , billing_details[15]);
					 					setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
					 					setBills_dtls.put("rate"		 ,"");
					 					setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
					 					setBills_dtls.put("mod_physician_id"		 , billing_details[20]);

										orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+orderCatalogCode, setBills_dtls);
									}
								}
							}
							if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
							{
								for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
								{
									care_set_count = (String[])PlaceOrdercareSetCount.get(t);
									order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(orderCatalogCode),"");
									/* format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
									 
									if(!format_id.trim().equals("") )
									{
										stFormat = new StringTokenizer(format_id,"~");
										while(stFormat.hasMoreTokens())
					 					{
					 						format_id_mandatory_yn	 	= stFormat.nextToken();
					 						format_id 	 	 			= stFormat.nextToken();
					 					}
										stFormat = null;
					 				} */
					 				/* if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
					 					out.println("<br> Order Format has mandatory header items  " +care_set_count[2]);
					 				else
					 					out.println("<br> Order Format does not has mandatory header items  "+care_set_count[2]); */
					 				String time_frame = "";
					 				PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
					 				
					 				//reqd_or_opt_ind 	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the reqd_or_opt_ind
									//rel_start_date_time	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the rel_start_date_time
									//start_time			= new String[PlaceOrderSetItems.size()]; //Assigning the size for the start_time
											
					 				for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
									{
					 					care_set_group 			= (String[])PlaceOrderSetItems.get(k);
										order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
									    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
									   /*  reqd_or_opt_ind[k]		= care_set_group[5];
									    rel_start_date_time[k]	= care_set_group[10]; // Here the start_date_time is calculated with the sysdate + rel_start_date_time
									    start_time[k]			= care_set_group[11]; // Here the start_time is taken to be stored in the hidden field so that when the header date/time is changed, can be used for calculation */ 
									}
					 				if(order_set_order_catalog.length() > 0)
										order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
									if(order_type_catalog.length() > 0)
										order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
									
									PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),"");
									if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
									{
										for(int i=0; i<PlaceOrderItems.size(); i++)
										{	
											records		= (String[])PlaceOrderItems.get(i);
											Default = bean.getPlaceOrderSetDefault(records[0],order_catalog_code);
											for(int j=0;j<Default.size();j++)
											{
												recordDefault	 = ((String[])Default.get(j));					
												if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
												if(recordDefault!=null){
													qty_value	 = 	bean.checkForNull(recordDefault[8],"1");
													if(qty_value.equals("0")) qty_value = "1";
												}else{
													qty_value	 = "1";
												}
											}
											bean.setTempValues("start_date_time"+records[0],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale));
											bean.setTempValues("order_type_code"+records[0],orderTypeCode);
											bean.setTempValues("priority"+records[0],"R");
											bean.setTempValues("quantity"+records[0],qty_value);
											if(patientDischargedYn.equalsIgnoreCase("N"))
											{
												PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
												if(PlaceOrderFrequency!=null && !PlaceOrderFrequency.isEmpty()){
													frequencyRecords = (String[]) PlaceOrderFrequency.get(0);
												}
												if(frequencyRecords!=null && frequencyRecords.length>0){
													bean.setTempValues("frequency_code"+records[0],frequencyRecords[0]);
												}
												else{
													bean.setTempValues("frequency_code"+records[0],"");
												}
												
											}else{
												bean.setTempValues("frequency_code"+records[0],"");
											}
											bean.setTempValues("duration_code"+records[0],"");
											bean.setTempValues("duration_value"+records[0],"");
											
											if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ){ 
												fac_selected = bean.getTempvalue("performing_facility_id"+records[0])==null?login_facility_id:bean.getTempvalue("performing_facility_id"+records[0]);
												
												performingLocationCode = bean.getPerformingLocation(orderCategoryCode,orderTypeCode,records[0]);
												if(performingLocationCode!=null && !performingLocationCode.isEmpty()){
													performingLocation	= (String[]) performingLocationCode.get(0);
												}
									 			if(performingLocation!=null && performingLocation.length>0){
									 				bean.setTempValues("performing_facility_id"+records[0],performingLocation[0]);
										 			bean.setTempValues("performing_facility_desc"+records[0],performingLocation[1]);
									 			}
									 			DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],orderCategoryCode,orderTypeCode,rd_instal_yn);
									 			if(DeptLocationCode!=null && !DeptLocationCode.isEmpty()){
									 				deptLocation	= (String[]) DeptLocationCode.get(0);
									 			}
								 				if(deptLocation!=null && deptLocation.length>0){
									 				bean.setTempValues("performing_dept_loc_code"+records[0],deptLocation[0]);
										 			bean.setTempValues("performing_dept_loc_desc"+records[0],deptLocation[1]);
									 			}
								 				else{
								 					bean.setTempValues("performing_dept_loc_code"+records[0],"");
										 			bean.setTempValues("performing_dept_loc_desc"+records[0],"");
								 				}

									 			
											}
											else{
												bean.setTempValues("performing_facility_id"+records[0],records[5]);
									 			bean.setTempValues("performing_facility_desc"+records[0],bean.getPerformingFacilityName(records[5]));
									 			bean.setTempValues("performing_dept_loc_code"+records[0],"");
									 			bean.setTempValues("performing_dept_loc_desc"+records[0],"");
											}
											
										}
										
									}
									order_set_order_catalog = ""; // Remove the values
									order_type_catalog			 = ""; // Remove the values
								}
							}
								
						}
					}
				}
				if(validationResponse.getValidationResult() == (MOrderEntryValidationResponse.VALIDATION_SUCCESS)){//Validation passed
					bean.setCatalogCodes(check_box_value);
					String key				= (bean.getPatientId()+bean.getEncounterId());
					HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
					if(previousValues == null){
						previousValues = new HashMap();
					}
					previousValues.put("ck"+orderCatalogCode, "Y");
					previousValues.put("h1"+orderCatalogCode,orderCategoryCode);
					previousValues.put("h2"+orderCatalogCode,orderTypeCode);
					orderEntryRecordBean.setCheckedEntries(key, previousValues);
					if(orderCategoryCode.equals("CS")){
						bean.setTempValues("OrderSetChecked", "1");
					}
				}
				PersistenceHelper.putObjectInBean(or_bean_id,bean,request);
			}else{
				validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_ERROR);
				MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
				errorItem.setErrorMessageId("NULL_PATIENTCONTEXT");
				errorItem.setErrorMessage("No Active User Session");
				errorItems.add(errorItem);
			}
		}
		catch(Exception e){
			validationResponse.setValidationResult(MOrderEntryValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
			MOrderEntryErrorItem errorItem = new MOrderEntryErrorItem();
			errorItem.setErrorMessageId("NULL_PATIENTCONTEXT");
			errorItem.setErrorMessage(e.getMessage());
			errorItems.add(errorItem);
			//out.println(e.getMessage());
		}
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(validationResponse));	
		
/*		MOrderEntryValidationResponse validationResponse = new MOrderEntryValidationResponse();
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
		response.getWriter().write(gson.toJson(validationResponse));*/
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
