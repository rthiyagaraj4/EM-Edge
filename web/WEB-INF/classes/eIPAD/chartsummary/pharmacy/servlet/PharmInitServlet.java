package eIPAD.chartsummary.pharmacy.servlet;

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

import eCommon.Common.CommonRepository;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eOR.OrderEntryBean;
import eOR.OrderEntryBillingQueryBean;
import eOR.OrderEntryQueryBean;
import ePH.ConsumableOrderBean;
import ePH.DrugInterfaceControlBean;
import ePH.DrugSearchBean;
import ePH.IVPiggyBackBean;
import ePH.IVPrescriptionBean;
import ePH.PregnancyCategoryBean;
import ePH.PrescriptionBean;
import ePH.PrescriptionBean_1;

/**
 * Servlet implementation class PharmInitServlet
 */
public class PharmInitServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		String patient_id = patientContext.getPatientId();
		String encounter_id = patientContext.getEncounterId();
		String facility_id = patientContext.getFacilityId();
		String locale = patientContext.getLocale();
		PrintWriter out = response.getWriter();
		try{
			if(patientContext != null){
				/*Initializing OrderEntryBean STARTS*/			
				String or_bean_name		="eOR.OrderEntryBean";
				String or_bean_id		="@orderentrybean"+patient_id+encounter_id;
				OrderEntryBean orbean = (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id, or_bean_name, request ) ;
				
				String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
				String ph_bean_name 			= "ePH.DrugSearchBean";
				DrugSearchBean ph_drug_bean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;
				ph_drug_bean.clear();
				ph_drug_bean.setLanguageId(locale);
				ph_drug_bean.setMode("");
				
				orbean.clearTemp();
				orbean.clear();
				orbean.clearDataBean(); 
				orbean.clearBillBean();
				EncounterListRequest encReq = new EncounterListRequest();
				encReq.setPatientContext(patientContext);
				EncounterListBC encBC = new EncounterListBC();
				//get the current encounter details
				encReq.setFilterEncounterId(patientContext.getEncounterId());
				EncounterListResponse currentEncResp;
				currentEncResp = encBC.getEncounterList(encReq);
				Properties properties = (Properties)session.getAttribute("jdbc");
				
				orbean.setLanguageId(locale);
				orbean.setLoginPractId(patientContext.getClinicianId());
				orbean.setLoginFacilityId(patientContext.getFacilityId());
				orbean.setPatientId(patient_id); // set the Patient Id
				orbean.setEncounterId(encounter_id);
				orbean.setFunctionId("");
				orbean.setResponsibilityId(patientContext.getResponsibilityID());
				orbean.setCalledFromCA("Y");
				if(currentEncResp.isSuccessResponse() && !currentEncResp.isEmptyDataResponse()){
					EncounterHO currentEnc = currentEncResp.getEncounterList().get(0);
					if(currentEnc!=null){
						if(currentEnc.getAssignCareLocnType().equals("W"))
							orbean.setLocationType("N");
						else
							orbean.setLocationType(currentEnc.getAssignCareLocnType());
						orbean.setLocationCode(currentEnc.getAssignCareLocnCode());
						orbean.setPatientClass(currentEnc.getPatientClass());
						orbean.setFacilityName(currentEnc.getFacilityDesc());
						orbean.setRelationshipId(currentEnc.getRelationshipId());
					}
				}
				orbean.setRestrictYn("N"); // Used for Pharmacy Orders, otherwise it is N TODO
				orbean.setSysDate(orbean.checkForNull(orbean.getSysDate(),""));// Set the Date

				orbean.setPractitionerId(patientContext.getClinicianId());
				String practitionerName = (String)session.getAttribute("practitioner_name")==null?"":(String)session.getAttribute("practitioner_name");
				orbean.setPractitionerName(practitionerName);
				orbean.setPractitionerType(patientContext.getPracType());
				
				String[] record = null;
				
				OrderEntryBillingQueryBean beanBillQueryObj = new OrderEntryBillingQueryBean();
				beanBillQueryObj.setLanguageId(locale);
				boolean billing_error_disp = true;
				ArrayList billingInformation = beanBillQueryObj.getBillingInfo(properties, orbean.getLoginFacilityId(),orbean.getEncounterId(),orbean.getPatientClass(), orbean.getPatientId());
				if(billingInformation!=null && billingInformation.size() > 0)
				{
					String billing_warning_message = "";
					String billing_error_message = "";
					for(int j=0; j<billingInformation.size(); j++)
					{
							record 					= (String[])billingInformation.get(j);
							billing_warning_message	= orbean.checkForNull(record[0],"");
							billing_error_message	= orbean.checkForNull(record[1],"");
					}
			 		if(!billing_error_message.equals("")){
			 			billing_error_disp = false;
			 			request.setAttribute("BillingError", billing_error_message);
			 		}
						
			 		if(!billing_warning_message.equals(""))
			 			request.setAttribute("BillingWarning", billing_warning_message);
			 		
			 		request.setAttribute("ErrorMessage", billing_error_message);
				}
				RequestDispatcher rd;
				//if there is a billing error then the user should not proceed.
				if(!billing_error_disp){
					PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
					
					rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/pharmacy/PharmErrorPage.jsp");
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
					 	order_category_yn 			= orbean.checkForNull(stPreSel.nextToken(),"N");
				 	 	order_type_code_yn 			= orbean.checkForNull(stPreSel.nextToken(),"N");
					 	order_privilege_level		= orbean.checkForNull(stPreSel.nextToken(),"");
					 	pin_ident_by_category_yn	= orbean.checkForNull(stPreSel.nextToken(),"");
					 	orbean.setOrderCategoryYn(order_category_yn);
					 	orbean.setOrderTypeCodeYn(order_type_code_yn);
					 	orbean.setOrderPrivilegeLevel(order_privilege_level);
					 	orbean.setPinIdentByCategoryYn(pin_ident_by_category_yn);
					}
					
					orbean.setSex(patientContext.getGender());
					orbean.setAge(patientContext.getAge());
					orbean.setDob(patientContext.getDob());
					orbean.setAccessionType("");
					orbean.setAccessionNumber("");
					orbean.setInvokeFunction("");
					String adtstatus = (String)beanQueryObj.getAdtStatus(properties,orbean.getEncounterId(),orbean.getLoginFacilityId());
					String patientDischarged;
					if(adtstatus.equalsIgnoreCase("08"))
						patientDischarged = "Y";
					else
						patientDischarged = "N";
					orbean.setPatientDischarged(patientDischarged);
					ArrayList PrEncounterDtls  = beanQueryObj.getPREncounterDetails(properties, orbean.getLoginFacilityId(),orbean.getEncounterId());
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
							attend_practitioner_id		= orbean.checkForNull(record[0],"");
							attend_practitioner_name	= orbean.checkForNull(record[1],"");
							discharge_date_time			= orbean.checkForNull(record[2],"");
							episode_id					= orbean.checkForNull(record[3],"");
							op_episode_visit_num		= orbean.checkForNull(record[4],"");
							team_id						= orbean.checkForNull(record[5],"");
							service_code				= orbean.checkForNull(record[6],"");
							visit_adm_date_time			= orbean.checkForNull(record[7],"");
							orbean.setAttendPractitionerId(attend_practitioner_id);
							orbean.setAttendPractitionerName(attend_practitioner_name);
							orbean.setDischargeDate(discharge_date_time);
							orbean.setEpisodeID(episode_id);
							orbean.setEpisodeVisitNum(op_episode_visit_num);
							orbean.setTeamID(team_id);
							orbean.setServiceCode(service_code);
							orbean.setVisitAdmDate(visit_adm_date_time);
							ph_drug_bean.setServiceCode(service_code);
							
						}
					}
					orbean.setPrivilegeApplicability(orbean.checkForNull(orbean.getAuthorisationOrOrderingYn("ORD"),""));
					String PrivilegeApplicabilityAuth = (String)orbean.checkForNull(orbean.getAuthorisationOrOrderingYn("AUT"),"");
					String PrivilegeApplicabilityOrd = (String)orbean.checkForNull(orbean.getAuthorisationOrOrderingYn("ORD"),"");
					//PrivilegeApplicability =(String)bean.getPrivForPractYN();	
					session.putValue("PrivilegeApplicability",PrivilegeApplicabilityOrd);
					session.putValue("PrivilegeApplicabilityAuth",PrivilegeApplicabilityAuth);
					orbean.setMode("");
					orbean.setFunctionId("PH");
					orbean.setCalledFromCA("Y"); 
					
				}
				
				
				
				/*Initializing OrderEntryBean ENDS*/	
				
				String module_install_yn	= "N";
				module_install_yn 			= orbean.checkForNull(orbean.getModuleInstallYn("PH"),"N");
				
				if(module_install_yn.equals("N")){
					request.setAttribute("ErrorMessage", "Pharmacy module is not installed");
					rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/pharmacy/PharmErrorPage.jsp");
					rd.forward(request, response);
				}else{
					String presBean1_id			= "@PrescriptionBean_1"+patient_id+encounter_id;	
					String presBean1_name		= "ePH.PrescriptionBean_1";
					PrescriptionBean_1 bean	= (PrescriptionBean_1)PersistenceHelper.getBeanObject(presBean1_id,presBean1_name,request);
					bean.clear();
					bean.setLanguageId(locale);
					bean.setActPatientClass_frm_Hdr(patientContext.getPatientClass()); 
					bean.getProfileCount(patient_id);
					ArrayList param_vals	=	bean.getParameterValues();
					String diag_for_medn_order_by = (String)param_vals.get(20);
					ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);
					String p_called_from_ca = "Y";//Called from Clinician Access
					bean.setCalledFromAmend(p_called_from_ca);
					
					String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
					String presBean_name		= "ePH.PrescriptionBean";
					PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
					presBean.clear();
					presBean.setLanguageId(locale);
					
					String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVD	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
					bean_IVD.clear();
					bean_IVD.setLanguageId(locale);
					bean_IVD.setPatientClass(patientContext.getPatientClass());
					bean_IVD.setPatId(patient_id);
					bean_IVD.setEncId(encounter_id);
					bean_IVD.setIVType("IVD");
					bean_IVD.setLocationType(orbean.getLocationType());
					bean_IVD.setLocationCode(orbean.getLocationCode());
					bean_IVD.setPractionerID(patientContext.getClinicianId());
					bean_IVD.setPrintMarLabel(bean.getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVD.setPrintMarBarcode(bean.getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVD.setIVCalcInfuseBy(bean.getIVCalcInfuseBy()); //Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVD.setOrderStatus("");
					bean_IVD.setSTART_DATE("");
					bean_IVD.setEND_DATE("");
					bean_IVD.setSTART_DATE_TIME("");
					bean_IVD.setEND_DATE_TIME("");
					bean_IVD.setINFUSE_OVER("");
					bean_IVD.setINFUSION_RATE("");
					bean_IVD.setFREQ_CODE("");
					bean_IVD.setDOSAGE("");
					bean_IVD.setVOLUME("");
					bean_IVD.setQty_value("");
					bean_IVD.setQTY_VALUE("");
					bean_IVD.setQty_unit("");
					bean_IVD.setQTY_UNIT("");
					
					String drug_priv_appln_yn	= (String) session.getValue("PrivilegeApplicability")==null?"":(String) session.getValue("PrivilegeApplicability");
					bean_IVD.setDrugPrivApplnYN(drug_priv_appln_yn);

					String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVWA	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
					
					bean_IVWA.clear();
					bean_IVWA.setLanguageId(locale);
					bean_IVWA.setPatientClass(patientContext.getPatientClass());
					bean_IVWA.setPatId(patient_id);
					bean_IVWA.setEncId(encounter_id);
					bean_IVWA.setIVType("IVWA");
					bean_IVWA.setLocationType(orbean.getLocationType());
					bean_IVWA.setLocationCode(orbean.getLocationCode());
					bean_IVWA.setPractionerID(patientContext.getClinicianId());
					bean_IVWA.setOrderDate(bean_IVWA.getSysdate());
					String mode_IVWA = CommonRepository.getCommonKeyValue( "MODE_MODIFY" ); 
					bean_IVWA.setMode(mode_IVWA);
					bean_IVWA.setPrintMarLabel(bean.getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVWA.setPrintMarBarcode(bean.getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVWA.setIVCalcInfuseBy(bean.getIVCalcInfuseBy()); //Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVWA.setDrugPrivApplnYN(drug_priv_appln_yn);
					bean_IVWA.setOrderStatus("");
					bean_IVWA.setSTART_DATE("");
					bean_IVWA.setEND_DATE("");
					bean_IVWA.setSTART_DATE_TIME("");
					bean_IVWA.setEND_DATE_TIME("");
					bean_IVWA.setINFUSE_OVER("");
					bean_IVWA.setINFUSION_RATE("");
					bean_IVWA.setFREQ_CODE("");
					bean_IVWA.setDOSAGE("");
					bean_IVWA.setVOLUME("");
					bean_IVWA.setQty_value("");
					bean_IVWA.setQTY_VALUE("");
					bean_IVWA.setQty_unit("");
					bean_IVWA.setQTY_UNIT("");

					String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVPB	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean_IVPB	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
					String bean_id_pig			= "IVPiggyBackBean"+patient_id+encounter_id;
					String bean_name_pig		= "ePH.IVPiggyBackBean";
					IVPiggyBackBean bean_pig	= (IVPiggyBackBean)PersistenceHelper.getBeanObject( bean_id_pig, bean_name_pig , request) ;
					bean_pig.setLanguageId(locale);
					bean_pig.setLoginFacilityId(facility_id);
					
					
					bean_IVPB.clear();
					bean_IVPB.setLanguageId(locale);
					bean_IVPB.setPatientClass(patientContext.getPatientClass());
					bean_IVPB.setPatId(patient_id);
					bean_IVPB.setEncId(encounter_id);
					bean_IVPB.setIVType("IVD");
					bean_IVPB.setLocationType(orbean.getLocationType());
					bean_IVPB.setLocationCode(orbean.getLocationCode());
					bean_IVPB.setPractionerID(patientContext.getClinicianId());
					bean_IVPB.setOrderDate(bean_IVPB.getSysdate());
					bean_IVPB.setIVPB("Y");
					bean_IVPB.setPrintMarLabel(bean.getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVPB.setPrintMarBarcode(bean.getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVPB.setIVCalcInfuseBy(bean.getIVCalcInfuseBy()); //Added for MMS-QH-CRF-0080 [IN:038064]
					bean_IVPB.setDrugPrivApplnYN(drug_priv_appln_yn);
					bean_IVPB.setOrderStatus("");
					bean_IVPB.setSTART_DATE("");
					bean_IVPB.setEND_DATE("");
					bean_IVPB.setSTART_DATE_TIME("");
					bean_IVPB.setEND_DATE_TIME("");
					bean_IVPB.setINFUSE_OVER("");
					bean_IVPB.setINFUSION_RATE("");
					bean_IVPB.setFREQ_CODE("");
					bean_IVPB.setDOSAGE("");
					bean_IVPB.setVOLUME("");
					bean_IVPB.setQty_value("");
					bean_IVPB.setQTY_VALUE("");
					bean_IVPB.setQty_unit("");
					bean_IVPB.setQTY_UNIT("");
					
					
					/* CRX Bean Start */
				//	System.out.println("Saravanvanan  CRX STSRT");
					String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_CRX	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);
					bean_CRX.clear();
					bean_CRX.setLanguageId(locale);
					bean_CRX.setPatientClass(patientContext.getPatientClass());
					bean_CRX.setPatId(patient_id);
					bean_CRX.setEncId(encounter_id);
					bean_CRX.setIVType("CRX");
					bean_CRX.setLocationType(orbean.getLocationType());
					bean_CRX.setLocationCode(orbean.getLocationCode());
					bean_CRX.setPractionerID(patientContext.getClinicianId());
					bean_CRX.setPrintMarLabel(bean.getPrintMarLabel());
					bean_CRX.setPrintMarBarcode(bean.getPrintMarBarcode());
					bean_CRX.setIVCalcInfuseBy(bean.getIVCalcInfuseBy()); 
					bean_CRX.setOrderDate(bean_CRX.getSysdate());
					bean_CRX.setFREQ_CODE("");
					//String drug_priv_appln_yn	= (String) session.getValue("PrivilegeApplicability")==null?"":(String) session.getValue("PrivilegeApplicability");
					//bean_CRX.setDrugPrivApplnYN(drug_priv_appln_yn);				
					
					
					/* CRX Bean End */
					
					
					/*String IVbean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
					String IVbean_name		= "ePH.IVPrescriptionBean";
					IVPrescriptionBean IVbean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(IVbean_id, IVbean_name, request);
					IVbean.clear();
					IVbean.setLanguageId(locale);*/
					
					ph_drug_bean.setIdentity("MedicationOrder");
					ph_drug_bean.setPractitionerId(patientContext.getClinicianId());
					ph_drug_bean.setGender(patientContext.getGender());
					ph_drug_bean.setDOB(patientContext.getDob());
					ph_drug_bean.setPatientId(patient_id);
					ph_drug_bean.setPatientClass(patientContext.getPatientClass());
					
					String Consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
					String Consumable_bean_name				= "ePH.ConsumableOrderBean";
					ConsumableOrderBean Consumable_bean		= (ConsumableOrderBean)PersistenceHelper.getBeanObject( Consumable_bean_id,Consumable_bean_name, request );
					Consumable_bean.clear();
					Consumable_bean.setLanguageId(locale);
					
					String pregn_bean_id = "PregnancyCategory" ;
					String pregn_bean_name = "ePH.PregnancyCategoryBean";
					PregnancyCategoryBean pregn_bean = (PregnancyCategoryBean)PersistenceHelper.getBeanObject( pregn_bean_id, pregn_bean_name, request ) ;
					pregn_bean.clear();
					pregn_bean.setLanguageId(locale);
					
					String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
					String param_bean_name				= "ePH.DrugInterfaceControlBean";
					DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
					param_bean.clear();
					param_bean.setLanguageId(locale);
					
					// code extracted from ePH/jsp/Prescription.jsp
					String overlap_period_for_op        =   param_bean.getOverlapPeriodForOP(facility_id);
					String overlap_period_for_ip        =   param_bean.getOverlapPeriodForIP(facility_id);
					bean.setOverlapPeriodForOP(overlap_period_for_op);
					bean.setOverlapPeriodForIP(overlap_period_for_ip);
					param_bean.clear();
					
					String	bl_install_yn			=	orbean.getBillingInterfaceYn()	== null ? "" : orbean.getBillingInterfaceYn();
					if(bl_install_yn.equals("Y")){
				         bean.setBLDecimalFormatString(presBean.getDecimalFormatString());
					}
					String pregnency_yn				=presBean.getPregnencyYN(patient_id);
					String lmp_date                 =presBean.getLMPDate(patient_id);
					String sys_date=(String) presBean.getSysdate();
					double preg_week                =Math.ceil(presBean.getCalPregStage(sys_date,lmp_date));
					String trimester                =presBean.getTrimster(preg_week);
					
					bean.setPregnencyYN(pregnency_yn);
					bean.setPregTrimester(trimester);
					bean.setCalledFrom("");
					bean.setOrderDate(sys_date); 
					
					PersistenceHelper.putObjectInBean(presBean1_id,bean,request);
					PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
					PersistenceHelper.putObjectInBean(presBean_id,presBean,request);
					/*PersistenceHelper.putObjectInBean(IVbean_id,IVbean,request);*/
					PersistenceHelper.putObjectInBean(bean_id_IVD,bean_IVD,request);
					PersistenceHelper.putObjectInBean(bean_id_IVWA,bean_IVWA,request);
					PersistenceHelper.putObjectInBean(bean_id_IVPB,bean_IVPB,request);
					PersistenceHelper.putObjectInBean(ph_bean_id,ph_drug_bean,request);
					PersistenceHelper.putObjectInBean(Consumable_bean_id,Consumable_bean,request);
					PersistenceHelper.putObjectInBean(pregn_bean_id,pregn_bean,request);
					PersistenceHelper.putObjectInBean(param_bean_id,param_bean,request);
					PersistenceHelper.putObjectInBean(bean_id_pig,bean_pig,request);
					rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/pharmacy/PharmBase.jsp");
					rd.forward(request, response);
				}
			}else{
				out.println("Patient not chosen or Session expired. Please try logging in again");
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
	
	}

}
