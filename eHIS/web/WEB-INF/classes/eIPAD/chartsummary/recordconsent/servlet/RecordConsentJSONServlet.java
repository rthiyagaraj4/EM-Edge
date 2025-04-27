package eIPAD.chartsummary.recordconsent.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.Gson;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.recordconsent.response.RecordConsentMapResponse;
import eIPAD.chartsummary.recordconsent.response.RecordConsentTransactionResponse;
import eOR.ConsentOrders;

/**
 * Servlet implementation class RecordConsentJSONServlet
 */
public class RecordConsentJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordConsentJSONServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatContext patientContext;
		Gson gson = new Gson();
		String jsonFieldResponse = "";
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		String getValueFrom =request.getParameter("field") == null? "":request.getParameter("field");
		
		if(getValueFrom.equals("CONSENTCOUNT")){
			RecordConsentMapResponse mapResponse = new RecordConsentMapResponse();
			HashMap fieldMap = new HashMap();
			mapResponse.setMap(fieldMap);
			String bean_id = "Or_ConsentOrders" ;
			String bean_name = "eOR.ConsentOrders";
			ConsentOrders bean = (ConsentOrders)PersistenceHelper.getBeanObject( bean_id, bean_name, request);
			String locale = patientContext.getLocale();
			String facility_id = (String)session.getValue("facility_id");
			String source_type = "";
			String source_code = "";
			String practitioner_id = (String)session.getValue("ca_practitioner_id");
			String priority = "";
			String ord_cat = "";
			String order_by = "P";
			String patientId = patientContext.getPatientId();
			ArrayList StatusDetail = new ArrayList();
			String period_from = "";
			String period_to = "";
			int start = 1;
			int end = 500; //TODO remove this arbitrary number
			String practitioner_type = (String)session.getValue("practitioner_type");
			String speciality_code = "";
			String consentRec_order_id = "";
			try{
				StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code, consentRec_order_id) ;
				if(StatusDetail.size()==1){//only if size is 1 we're going to care about the other values
					fieldMap.put("COUNT",StatusDetail.size());
					String[] record = (String[])StatusDetail.get(0);
					String[] multiConsentLine = new String[4];
					multiConsentLine = bean.MultiListConsentsLine((String)record[5],(String)record[25]);
					int consent_req_bef_order = Integer.parseInt(multiConsentLine[2]);
					int consent_req_bef_regn = Integer.parseInt(multiConsentLine[3]);
					int total_consents = consent_req_bef_order + consent_req_bef_regn;
					fieldMap.put("TOTAL_CONSENTS",total_consents);
					if(total_consents==1){
						ArrayList multiConsentList = new ArrayList();
						String[] multiConsentDtls = null;
						String order_catalog_code	=(String)record[24];
						String order_id = (String)record[5];
						String order_line_num = (String)record[25];
						String order_catalog_desc = (String) multiConsentLine[1];
						
						multiConsentDtls = bean.MultiListDtls(order_catalog_code, practitioner_id);
						if(multiConsentDtls[0].equals("F"))
						{
							multiConsentList = bean.multiConsentDraftValues(order_catalog_code,order_id,order_line_num);
						}
						if(multiConsentList==null || multiConsentList.size()==0)
						{
							multiConsentList = bean.MultiListConsentsForNew(order_catalog_code,order_id,order_line_num, practitioner_id);
						}
						fieldMap.put("ORDER_ID",order_id);
						String consent_form_id;
						String consent_form_desc;
						String consent_stage = "A";
						if(consent_req_bef_order == 1){
							consent_stage ="A";
						}else if(consent_req_bef_regn == 1){
							consent_stage ="R";
						}
						if(multiConsentDtls[0].equals("F")){
							consent_form_id = multiConsentDtls[3];
							consent_form_desc = multiConsentDtls[5];
						}else{
							if(multiConsentList.size()>0){
								String[] singleVariableConsent = (String[])multiConsentList.get(0);
								consent_form_id = singleVariableConsent[1];
								consent_form_desc = singleVariableConsent[2];
							}else{
								consent_form_id = "";
								consent_form_desc = "";
							}
						}
						fieldMap.put("CONSENT_FORM_ID",consent_form_id);
						fieldMap.put("CONSENT_FORM_DESC",consent_form_desc);
						fieldMap.put("CONSENT_STAGE",consent_stage);
					}
					
					
				}else{
					fieldMap.put("COUNT",StatusDetail.size());
				}
			}catch(Exception e){
				
			}
			jsonFieldResponse = gson.toJson(mapResponse);
		}else if(getValueFrom.equals("RECORDCONSENT")){
			RecordConsentTransactionResponse transactionResponse = new RecordConsentTransactionResponse();
			String bean_id = "Or_ConsentOrders" ;
			String bean_name = "eOR.ConsentOrders";
			ConsentOrders beanObj = (ConsentOrders)PersistenceHelper.getBeanObject( bean_id, bean_name, request);
			beanObj.clearHasp();
			beanObj.clearHash();
			
			String index = "0";
			String consent_form_id = request.getParameter("consent_form_id"+index)==null?"":request.getParameter("consent_form_id"+index);
			String consent_form_text = request.getParameter("consent_form_text"+index)==null?"":request.getParameter("consent_form_text"+index);
			String consent_stage = request.getParameter("consent_stage"+index)==null?"":request.getParameter("consent_stage"+index);

			HashMap consent= (HashMap)beanObj.getConsentDetail();
			consent.put(index+consent_form_id,consent_form_text);
			beanObj.setConsentDetail(consent);
			beanObj.setConsentFormId(index, consent_form_id);
			HashMap patient_detail= (HashMap)beanObj.getPatientDetail();
			String patient_name = request.getParameter("patient_name")==null?"":request.getParameter("patient_name");
			String practitioner_name = request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");
			String reln_box = request.getParameter("reln_box")==null?"":request.getParameter("reln_box");
			String dat_time = request.getParameter("dat_time")==null?"":request.getParameter("dat_time");
			String remarks = request.getParameter("remarks")==null?"":request.getParameter("remarks");
			String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
			String self = request.getParameter("self")==null?"y":request.getParameter("self");
			ArrayList patient_info = new ArrayList();
			patient_info.add(URLDecoder.decode("", "UTF-8"));
			patient_info.add(practitioner_name);
			patient_info.add(reln_box);
			patient_info.add(dat_time);
			patient_info.add(remarks);
			patient_info.add(practitioner_id);
			patient_info.add(self);
			beanObj.setPatientDetail(patient_detail);
			
			Hashtable hash = new Hashtable();
			hash.put("chk"+index, request.getParameter("chk"+index)==null?"":request.getParameter("chk"+index));
			hash.put("con_id"+index, consent_form_id+"~");
			hash.put("consent_form_id"+index, request.getParameter("consent_form_id"+index)==null?"":request.getParameter("consent_form_id"+index));
			hash.put("consent_stage"+index, request.getParameter("consent_stage"+index)==null?"":request.getParameter("consent_stage"+index));
			hash.put("patient_name"+index, request.getParameter("patient_name"+index)==null?"":request.getParameter("patient_name"+index));
			hash.put("ord_typ_code"+index, request.getParameter("ord_typ_code"+index)==null?"":request.getParameter("ord_typ_code"+index));
			hash.put("ord_status"+index, request.getParameter("ord_status"+index)==null?"":request.getParameter("ord_status"+index));
			hash.put("ord_consent_yn"+index, request.getParameter("ord_consent_yn"+index)==null?"":request.getParameter("ord_consent_yn"+index));
			hash.put("ord_id"+index, request.getParameter("ord_id"+index)==null?"":request.getParameter("ord_id"+index));
			hash.put("ord_line_num"+index, request.getParameter("ord_line_num"+index)==null?"":request.getParameter("ord_line_num"+index));
			hash.put("appt_reqd_yn"+index, request.getParameter("appt_reqd_yn"+index)==null?"":request.getParameter("appt_reqd_yn"+index));
			hash.put("order_pract_name"+index, request.getParameter("order_pract_name"+index)==null?"":request.getParameter("order_pract_name"+index));
			hash.put("cont_order_ind"+index, request.getParameter("cont_order_ind"+index)==null?"":request.getParameter("cont_order_ind"+index));
			hash.put("ord_appr_by_user_id"+index, request.getParameter("ord_appr_by_user_id"+index)==null?"":request.getParameter("ord_appr_by_user_id"+index));
			hash.put("ord_appr_reqd_yn"+index, request.getParameter("ord_appr_reqd_yn"+index)==null?"":request.getParameter("ord_appr_reqd_yn"+index));
			hash.put("ord_consent_by_id"+index, request.getParameter("ord_consent_by_id"+index)==null?"":request.getParameter("ord_consent_by_id"+index));
			hash.put("ord_consent_reqd_yn"+index, request.getParameter("ord_consent_reqd_yn"+index)==null?"":request.getParameter("ord_consent_reqd_yn"+index));
			hash.put("order_catalog_code"+index, request.getParameter("order_catalog_code"+index)==null?"":request.getParameter("order_catalog_code"+index));
			hash.put("patientdetails"+index, request.getParameter("patientdetails"+index)==null?"":request.getParameter("patientdetails"+index));
			hash.put("order_category"+index, request.getParameter("order_category"+index)==null?"":request.getParameter("order_category"+index));

			hash.put("ord_catalog_desc"+index, request.getParameter("ord_catalog_desc"+index)==null?"":request.getParameter("ord_catalog_desc"+index));
			hash.put("pat_class"+index, request.getParameter("pat_class"+index)==null?"":request.getParameter("pat_class"+index));
			hash.put("pat_id"+index, request.getParameter("pat_id"+index)==null?"":request.getParameter("pat_id"+index));
			hash.put("priority"+index, request.getParameter("priority"+index)==null?"":request.getParameter("priority"+index));
			hash.put("location_type"+index, request.getParameter("location_type"+index)==null?"":request.getParameter("location_type"+index));
			hash.put("location_code"+index, request.getParameter("location_code"+index)==null?"":request.getParameter("location_code"+index));
			hash.put("encount_id"+index, request.getParameter("encount_id"+index)==null?"":request.getParameter("encount_id"+index));
			hash.put("ord_auth_reqd_yn"+index, request.getParameter("ord_auth_reqd_yn"+index)==null?"":request.getParameter("ord_auth_reqd_yn"+index));
			hash.put("ord_auth_by_pract_id"+index, request.getParameter("ord_auth_by_pract_id"+index)==null?"":request.getParameter("ord_auth_by_pract_id"+index));
			hash.put("link_ref_no"+index, request.getParameter("link_ref_no"+index)==null?"":request.getParameter("link_ref_no"+index));
			hash.put("link_ref"+index, request.getParameter("link_ref"+index)==null?"":request.getParameter("link_ref"+index));
			hash.put("link_ref_det"+index, request.getParameter("link_ref_det"+index)==null?"":request.getParameter("link_ref_det"+index));
			hash.put("con_bo_cnt"+index, request.getParameter("con_bo_cnt"+index)==null?"":request.getParameter("con_bo_cnt"+index));
			hash.put("con_br_cnt"+index, request.getParameter("con_br_cnt"+index)==null?"":request.getParameter("con_br_cnt"+index));
			hash.put("con_rbo_cnt"+index, request.getParameter("con_rbo_cnt"+index)==null?"":request.getParameter("con_rbo_cnt"+index));
			hash.put("con_rbr_cnt"+index, request.getParameter("con_rbr_cnt"+index)==null?"":request.getParameter("con_rbr_cnt"+index));
			hash.put("con_stage"+index, consent_stage+"~");
			hash.put("order_set_id"+index, request.getParameter("order_set_id"+index)==null?"":request.getParameter("order_set_id"+index));

			hash.put("total_recs", request.getParameter("total_recs")==null?"":request.getParameter("total_recs"));
			hash.put("mode", request.getParameter("mode")==null?"":request.getParameter("mode"));
			hash.put("facility_id", request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));
			hash.put("practitioner_id", request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id"));
			hash.put("practitioner_name", request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name"));
			hash.put("security_level", request.getParameter("security_level")==null?"":request.getParameter("security_level"));
			hash.put("curr_sys_date", request.getParameter("curr_sys_date")==null?"":request.getParameter("curr_sys_date"));
			hash.put("patientId", request.getParameter("patientId")==null?"":request.getParameter("patientId"));
			hash.put("function_id", request.getParameter("function_id")==null?"":request.getParameter("function_id"));
			hash.put("HttpRequest", request) ;
			hash.put("HttpResponse", response) ;
			
			try{
				boolean local_ejbs	= false ;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
				beanObj.setLocalEJB(local_ejbs);
				beanObj.setLoginById( (String) session.getValue( "login_user" ) ) ;
				beanObj.setLoginAtWsNo( beanObj.getProperties().getProperty( "client_ip_address" ) ) ;
				beanObj.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
				beanObj.setMode("1");
				beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
				beanObj.setAll(hash) ;
				HashMap map = beanObj.validate() ;
				boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
				map.put( "message",beanObj.getMessage((String)map.get( "message" ))) ;
				String validationMessage = map.get("message") == null ? "" :(String)map.get("message")  ;
				validationMessage = beanObj.replaceNewLineChar( validationMessage );

				if ( validated ){
					map = beanObj.apply() ;	
					boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
					if(result){
						transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
						transactionResponse.setTransactionMessage("Consent recorded successfully");
					}else{
						transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
						transactionResponse.setTransactionMessage("Consent could not be recorded");
					}
				}
			}catch(Exception e){
				transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
				transactionResponse.setTransactionMessage("Consent could not be recorded");
			}
			jsonFieldResponse = gson.toJson(transactionResponse);
			PersistenceHelper.putObjectInBean(bean_id,beanObj,request);
		}else{
			
		}
		response.setContentType("application/json");
		response.getWriter().write(jsonFieldResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
