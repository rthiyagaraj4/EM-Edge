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
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.orderentry.daoimpl.MOrderEntryDAOImpl;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsSearchRequest;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse;
import eOR.OrderEntryBean;
import eOR.OrderEntryBillingQueryBean;
import eOR.OrderEntryQueryBean;

/**
 * Servlet implementation class NewOrderServlet
 */
public class MNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MNewOrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * code extracted from OrderEntryByPractitioner.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		PrintWriter out = response.getWriter();
		try{
			if(patientContext!=null){
				String patientId = patientContext.getPatientId();
				String encounterId = patientContext.getEncounterId();
				String locale = patientContext.getLocale();
				
				EncounterListRequest encReq = new EncounterListRequest();
				encReq.setPatientContext(patientContext);
				EncounterListBC encBC = new EncounterListBC();
				//get the current encounter details
				encReq.setFilterEncounterId(patientContext.getEncounterId());
				EncounterListResponse currentEncResp;
				currentEncResp = encBC.getEncounterList(encReq);
				
				Properties properties = (Properties)session.getAttribute("jdbc");
				if(currentEncResp.isSuccessResponse() && !currentEncResp.isEmptyDataResponse()){
					EncounterHO currentEnc = currentEncResp.getEncounterList().get(0);
					if(currentEnc!=null){
						String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
						String or_bean_name = "eOR.OrderEntryBean";
						OrderEntryBean bean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
						bean.clearTemp();
						bean.clear();
						bean.clearDataBean(); 
						bean.clearBillBean();
						
						bean.setLanguageId(locale);
						bean.setLoginPractId(patientContext.getClinicianId());
						bean.setLoginFacilityId(patientContext.getFacilityId());
						bean.setPatientId(patientId); // set the Patient Id
						bean.setEncounterId(encounterId);
						bean.setFunctionId("");
						bean.setResponsibilityId(patientContext.getResponsibilityID());
						bean.setCalledFromCA("Y");
						bean.setRelationshipId(currentEnc.getRelationshipId());
						bean.setRestrictYn("N"); // Used for Pharmacy Orders, otherwise it is N
						if(currentEnc.getAssignCareLocnType().equals("W"))
							bean.setLocationType("N");
						else
							bean.setLocationType(currentEnc.getAssignCareLocnType());
						bean.setLocationCode(currentEnc.getAssignCareLocnCode());
						bean.setSysDate(bean.checkForNull(bean.getSysDate(),""));// Set the Date

						bean.setPatientClass(currentEnc.getPatientClass());
						bean.setPractitionerId(patientContext.getClinicianId());
						String practitionerName = (String)session.getAttribute("practitioner_name")==null?"":(String)session.getAttribute("practitioner_name");
						bean.setPractitionerName(practitionerName);
						bean.setPractitionerType(patientContext.getPracType());
						
						String[] record = null;
						
						OrderEntryBillingQueryBean beanBillQueryObj = new OrderEntryBillingQueryBean();
						beanBillQueryObj.setLanguageId(locale);
						boolean billing_error_disp = true;
						ArrayList billingInformation = beanBillQueryObj.getBillingInfo(properties, bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(), bean.getPatientId());
						if(billingInformation!=null && billingInformation.size() > 0)
						{
							String billing_warning_message = "";
							String billing_error_message = "";
							for(int j=0; j<billingInformation.size(); j++)
							{
									record 					= (String[])billingInformation.get(j);
									billing_warning_message	= bean.checkForNull(record[0],"");
									billing_error_message	= bean.checkForNull(record[1],"");
							}
					 		if(!billing_error_message.equals("")){
					 			billing_error_disp = false;
					 			request.setAttribute("BillingError", billing_error_message);
					 		}
								
					 		if(!billing_warning_message.equals(""))
					 			request.setAttribute("BillingWarning", billing_warning_message);
						}
						
						RequestDispatcher rd;
						//if there is a billing error then the user should not proceed.
						if(!billing_error_disp){
							PersistenceHelper.putObjectInBean(or_bean_id,bean,request);
							rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/orders/MoeBillingError.jsp");
							rd.forward(request, response);
						}
						else{
							OrderEntryQueryBean beanQueryObj = new OrderEntryQueryBean();
							beanQueryObj.setLanguageId(locale);
							// Get the Values for the Presel Select
							StringTokenizer stPreSel = new StringTokenizer(beanQueryObj.getPreselSelectValues(properties),"~~");
							String order_category_yn;
							String order_type_code_yn;
							String order_privilege_level;
							String pin_ident_by_category_yn;
							while(stPreSel!=null && stPreSel.hasMoreTokens())
							{
							 	order_category_yn 			= bean.checkForNull(stPreSel.nextToken(),"N");
						 	 	order_type_code_yn 			= bean.checkForNull(stPreSel.nextToken(),"N");
							 	order_privilege_level		= bean.checkForNull(stPreSel.nextToken(),"");
							 	pin_ident_by_category_yn	= bean.checkForNull(stPreSel.nextToken(),"");
							 	bean.setOrderCategoryYn(order_category_yn);
								bean.setOrderTypeCodeYn(order_type_code_yn);
								bean.setOrderPrivilegeLevel(order_privilege_level);
								bean.setPinIdentByCategoryYn(pin_ident_by_category_yn);
							}
							
							bean.setSex(patientContext.getGender());
							bean.setAge(patientContext.getAge());
							bean.setDob(patientContext.getDob());
							bean.setFacilityName(currentEnc.getFacilityDesc());
							bean.setAccessionType("");
							bean.setAccessionNumber("");
							bean.setInvokeFunction("");
							String adtstatus = (String)beanQueryObj.getAdtStatus(properties,bean.getEncounterId(),bean.getLoginFacilityId());
							String patientDischarged;
							if(adtstatus.equalsIgnoreCase("08"))
								patientDischarged = "Y";
							else
								patientDischarged = "N";
							bean.setPatientDischarged(patientDischarged);
							ArrayList PrEncounterDtls  = beanQueryObj.getPREncounterDetails(properties, bean.getLoginFacilityId(),bean.getEncounterId());
							String attend_practitioner_id;
							String attend_practitioner_name;
							String discharge_date_time;
							String episode_id;
							String op_episode_visit_num;
							String team_id;
							String service_code;
							String visit_adm_date_time;
							if(PrEncounterDtls!=null)
							{
								for(int j=0; j<PrEncounterDtls.size(); j++)
								{
									record 						= (String[])PrEncounterDtls.get(j);
									attend_practitioner_id		= bean.checkForNull(record[0],"");
									attend_practitioner_name	= bean.checkForNull(record[1],"");
									discharge_date_time			= bean.checkForNull(record[2],"");
									episode_id					= bean.checkForNull(record[3],"");
									op_episode_visit_num		= bean.checkForNull(record[4],"");
									team_id						= bean.checkForNull(record[5],"");
									service_code				= bean.checkForNull(record[6],"");
									visit_adm_date_time			= bean.checkForNull(record[7],"");
									bean.setAttendPractitionerId(attend_practitioner_id);
									bean.setAttendPractitionerName(attend_practitioner_name);
									bean.setDischargeDate(discharge_date_time);
									bean.setEpisodeID(episode_id);
									bean.setEpisodeVisitNum(op_episode_visit_num);
									bean.setTeamID(team_id);
									bean.setServiceCode(service_code);
									bean.setVisitAdmDate(visit_adm_date_time);
								}
							}
							bean.setPrivilegeApplicability(bean.checkForNull(bean.getAuthorisationOrOrderingYn("ORD"),""));
							bean.setPrivApplicability("Y");// Always Y because in EM Mobile ordersearch is always for only applicable orders
							bean.setMode("");
							//test starts
							MOrderEntryDAOImpl daoimpl = new MOrderEntryDAOImpl();
							MOrderCatalogsSearchRequest aReq= new MOrderCatalogsSearchRequest();
							aReq.setPatientContext(patientContext);
							aReq.setOrderNature("S");
							aReq.setOrderCategory("LB");
							aReq.setOrderEntryBean(bean);
							
							MOrderCatalogListResponse res = daoimpl.getOrdersBySearch(aReq,true);
							request.setAttribute("ordersResp", res);
							//test ends
							
							
							
							PersistenceHelper.putObjectInBean(or_bean_id,bean,request);
							rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/orders/MoeBase.jsp");
							rd.forward(request, response);
						}
					}
				}
			}
		}
		catch(Exception e){
			out.println(e.getMessage());
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
