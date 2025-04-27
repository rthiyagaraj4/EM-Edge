package eIPAD.chartsummary.pharmacy.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.ehis.util.DateUtils;
import com.google.gson.Gson;

import eCommon.Common.CommonBean;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.pharmacy.healthobject.PharmErrorItem;
import eIPAD.chartsummary.pharmacy.response.PharmValidationResponse;
import eOR.OrderEntryBean;
import eOR.ScheduleFrequencyCompBean;
import eOR.Common.OrderEntryRecordBean;
import ePH.DrugInterfaceControlBean;
import ePH.DrugSearchBean;
import ePH.IVPiggyBackBean;
import ePH.IVPrescriptionBean;
import ePH.PrescriptionBean;
import ePH.PrescriptionBean_1;

/**
 * Servlet implementation class PharmValidationJSONServlet
 */
public class PharmValidationJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmValidationJSONServlet() {  
        super();
        // TODO Auto-generated constructor stub
    }
    private boolean checkDuplicateItem(String drug_code, String patient_id, String encounter_id, HttpServletRequest request){
    	boolean duplicateExists = false;
    	
    	String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name			= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean_RX		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
    	ArrayList presDetails = bean_RX.getpresDetails();
		if(presDetails!=null && presDetails.size()>0){
			for(int k=0;k<presDetails.size();k++){
				HashMap drugDet = (HashMap)presDetails.get(k);
				String drugCodeInCart = (String)drugDet.get("DRUG_CODE");
				if(drugCodeInCart.equals(drug_code)){
					duplicateExists = true;
				}
			}
		}
		
		String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patient_id + encounter_id;
		String bean_name_CRX	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);
		ArrayList drugList_CRX = bean_CRX.getDrugDetails();
		if(drugList_CRX!=null && !drugList_CRX.isEmpty()){
			for(int k=0;k<drugList_CRX.size();k++){
				HashMap drugDet = (HashMap)drugList_CRX.get(k);
				String drugCodeInCart = (String)drugDet.get("DRUG_CODE");
				if(drugCodeInCart.equals(drug_code)){
					duplicateExists = true;
				}
			}
		}
				
		
		String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patient_id + encounter_id;
		String bean_name_IVD	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
		ArrayList drugList_IVD = bean_IVD.getDrugDetails();
		if(drugList_IVD!=null && !drugList_IVD.isEmpty()){
			for(int k=0;k<drugList_IVD.size();k++){
				HashMap drugDet = (HashMap)drugList_IVD.get(k);
				String drugCodeInCart = (String)drugDet.get("DRUG_CODE");
				if(drugCodeInCart.equals(drug_code)){
					duplicateExists = true;
				}
			}
		}
		
		String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patient_id + encounter_id;
		String bean_name_IVPB	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean_IVPB	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
		ArrayList drugList_IVPB = bean_IVPB.getDrugDetails();
		if(drugList_IVPB!=null && !drugList_IVPB.isEmpty()){
			for(int k=0;k<drugList_IVPB.size();k++){
				HashMap drugDet = (HashMap)drugList_IVPB.get(k);
				String drugCodeInCart = (String)drugDet.get("DRUG_CODE");
				if(drugCodeInCart.equals(drug_code)){
					duplicateExists = true;
				}
			}
		}
		
		String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patient_id + encounter_id;
		String bean_name_IVWA	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
		ArrayList drugList_IVWA = bean_IVWA.getAllFluids();
		if(drugList_IVWA!=null && !drugList_IVWA.isEmpty()){
			for(int k=0;k<drugList_IVWA.size();k++){
				HashMap drugDet = (HashMap)drugList_IVWA.get(k);
				String drugCodeInCart = (String)drugDet.get("DRUG_CODE");
				if(drugCodeInCart.equals(drug_code)){
					duplicateExists = true;
				}
			}
		}
    	
    	return duplicateExists;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		String pharmPrescriptionMode = request.getParameter("PharmPrescriptionMode")==null?"RX":request.getParameter("PharmPrescriptionMode");
		PharmValidationResponse validationResponse = new PharmValidationResponse();
		ArrayList<PharmErrorItem> errorItems = new ArrayList<PharmErrorItem>();
		validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);
		HttpSession session = request.getSession(true);
		validationResponse.setErrorItems(errorItems);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		if(patientContext!=null){
			String patient_id = patientContext.getPatientId();
			String encounter_id	= patientContext.getEncounterId();
			String locale = patientContext.getLocale();
			String pract_id = patientContext.getClinicianId();
			String resp_id = patientContext.getResponsibilityID();
			String facility_id	= patientContext.getFacilityId();
			String patient_class= patientContext.getPatientClass();
			if(mode.equals("VALIDATE_ADDTOCART")){
				if(pharmPrescriptionMode.equals("RX")){
					try{
						/* OrderEntryBean updation STARTS */
						String or_bean_name				= "eOR.OrderEntryBean";
						String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
						OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
						OrderEntryRecordBean orderEntryRecordBean = (OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
						String orderCatalogCode = request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");//strArray[0]
						String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");//empty str
						String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "PH":request.getParameter("OrderCatCode");//PH
						String check_box_value	= orbean.checkForNull(request.getParameter( "check_box_value" ),"") ; //CKDRUGCODE1,CKDRUGCODE2
						
						/* OrderEntryBean updation ENDS */
						
						/* PrescriptionBean_1 updation STARTS */
						/* Code taken from PrescriptionValidation_1.jsp --- chkDuplicateDrugCode*/
						String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
						String bean_name			= "ePH.PrescriptionBean_1";
						PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
						String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
						String presBean_name		= "ePH.PrescriptionBean";
						PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
						String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
						String param_bean_name				= "ePH.DrugInterfaceControlBean";
						DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
						String drug_code	= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode"); //strArray[0]
						String sys_date     = presBean.getSysdate();
						String drugCode	= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode"); //strArray[0]
						String tradeCodes	= request.getParameter("TradeCodes") == null ? "":request.getParameter("TradeCodes"); //strArray[10]
						String tradeNames	= request.getParameter("TradeNames") == null ? "":request.getParameter("TradeNames");//java.net.URLEncoder.encode(strArray[11],"UTF-8")
						String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
						String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");//Taken from PharmBasePage - take_home_medication
						String order_set_code=request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");//Taken from PharmBasePage - order_set_code
						String order_set_occur_num="";//TODO, for now send as empty string
						String drug_db_interface_yn = request.getParameter("drug_db_interface_yn") == null ? "":request.getParameter("drug_db_interface_yn");//Taken from PharmBasePage - drug_db_interface_yn
						String act_patient_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");// Taken from PharmBasePage --actual_patient_class
						String home_leave_yn_val = request.getParameter("home_leave_yn_val") == null ? "":request.getParameter("home_leave_yn_val");// Taken from PharmBasePage --home_leave_yn_val
						String heightStr = request.getParameter("height") == null ? "0":request.getParameter("height");// Taken from PharmBasePage --height
						String weightStr = request.getParameter("weight") == null ? "0":request.getParameter("weight");// Taken from PharmBasePage --weight
						String in_formulary = request.getParameter("in_formulary") == null ? "0":request.getParameter("in_formulary");//strArray[13]
						String drug_class = request.getParameter("drug_class") == null ? "0":request.getParameter("drug_class");//strArray[21]
						//String tradeCodesArr[] = tradeCodes.split(",");
						//String tradeNamesArr[] = tradeNames.split(",");
						String locn_type = "";
						String trade_code = request.getParameter("TradeCodes") == null ? "":request.getParameter("TradeCodes");
						String trade_name = request.getParameter("TradeNames") == null ? "":request.getParameter("TradeNames");
						String order_type_code = "";
				
						int trade_count=0;
						if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
							locn_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");// Taken from PharmBasePage --location_type
						else
							locn_type	= "P";
						String locn_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");// Taken from PharmBasePage --location_type
						boolean allow_add= true;
						HashMap chk	=	null;
						int srl_no	=bean.getSrlNo()+1;
						sys_date     = presBean.getSysdate();// added for IN23575 --01/09/2010-- priya
						if(!locale.equals("en"));
							sys_date  = DateUtils.convertDate(sys_date, "DMYHM",locale,"en");
						boolean duplicateExists = checkDuplicateItem(drug_code, patient_id, encounter_id, request);
						ArrayList presDetails = bean.getpresDetails();
						/*if(presDetails!=null && presDetails.size()>0){
							for(int k=0;k<presDetails.size();k++){
								HashMap drugDet = (HashMap)presDetails.get(k);
								String drugCodeInCart = (String)drugDet.get("DRUG_CODE");
								if(drugCodeInCart.equals(drug_code)){
									duplicateExists = true;
								}
							}
						}*/
						if(duplicateExists){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("DUPLICATE_ITEM");
							errorItem.setErrorMessage("Drug is already present in the cart");
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
						}else{
							chk	=(HashMap)bean.loadDrugDetails(priority,take_home_medication,locn_type,locn_code,facility_id,drug_code.trim(),patient_class,patient_id,sys_date,String.valueOf(srl_no),order_set_code,order_set_occur_num, drug_db_interface_yn, trade_code, trade_name,act_patient_class,pract_id, resp_id,encounter_id,home_leave_yn_val);
							String wt_mand_yn= chk.get("WT_MAND_YN")== null?"":(String) chk.get("WT_MAND_YN");
							String ht_mand_yn= chk.get("HT_MAND_YN")== null?"":(String) chk.get("HT_MAND_YN");
							float height;
							float weight;
							try {
								height = Float.parseFloat(heightStr);
							}catch(NumberFormatException ex) {
								height = 0.0f;
							}
							try {
								weight = Float.parseFloat(weightStr);
							}catch(NumberFormatException ex) {
								weight = 0.0f;
							}
							
							if(wt_mand_yn.equals("Y") && ht_mand_yn.equals("Y")){
								if(height<=0 && weight<=0){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("HEIGHTWEIGHT_MANDATORY");
									errorItem.setErrorMessage("Height and weight values are mandatory to proceed with this prescription");
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
								}
								else if(height<=0){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("HEIGHT_MANDATORY");
									errorItem.setErrorMessage("Height value is mandatory to proceed with this prescription");
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
								}
								else if(weight<=0){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("WEIGHT_MANDATORY");
									errorItem.setErrorMessage("Weight value is mandatory to proceed with this prescription");
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
								}
							}
							else if(wt_mand_yn.equals("Y")){
								if(weight<=0){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("WEIGHT_MANDATORY");
									errorItem.setErrorMessage("Weight value is mandatory to proceed with this prescription");
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
								}
							}
							else if(ht_mand_yn.equals("Y")){
								if(height<=0){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("HEIGHT_MANDATORY");
									errorItem.setErrorMessage("Height value is mandatory to proceed with this prescription");
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
								}
							}
							//Stock check
							String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
							String ph_bean_name 			= "ePH.DrugSearchBean";
							DrugSearchBean ph_drug_bean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;
							
							ArrayList stock_params	=	ph_drug_bean.validateForStock();
							if(stock_params.size() > 1) {
								String consider_stock					= (String)stock_params.get(0);
								String disp_charge_dtl_in_drug_lkp_yn	= (String)stock_params.get(2);
								String disp_price_type_in_drug_lkp		= (String)stock_params.get(3);
								String allow_yn	= (String)stock_params.get(1);
								if(in_formulary.equals("Y") && consider_stock.equals("Y")) {
									ArrayList stock_dtls = ph_drug_bean.checkStock(drug_code, trade_code, drug_class, order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
									String avl_qty = (String)stock_dtls.get(1);
									String strEnableDisable	=	(String)stock_dtls.get(3);
									if((allow_yn.equals("N") && (stock_dtls.size()==0 || avl_qty.equals(""))) || strEnableDisable.equals("disabled")) {
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("STOCK_UNAVAILABLE");
										errorItem.setErrorMessage("Selected drug not available in stock");
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
									} 
								}
							}
							
							
							//drug interaction check 
							
							String interaction_exists			= (String) chk.get("INTERACTION_EXISTS")==null?"N": (String) chk.get("INTERACTION_EXISTS"); //Added for	RUT-CRF-0066 IN[029604] -Start
							String intr_restric_trn			= (String) chk.get("INTR_RESTRIC_TRN")==null?"N": (String) chk.get("INTR_RESTRIC_TRN");
							StringBuffer intr_msg_content = new StringBuffer("");
							if(interaction_exists.equals("Y")){
								HashMap DrugInteractionDtl= null;
								ArrayList hmDrugIntList = (ArrayList) chk.get("INTERACTION_DTL");
								if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
									for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
										DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
										String intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
										String intr_name = (String)DrugInteractionDtl.get("intr_name");
										String severity_level = (String)DrugInteractionDtl.get("severity_level");
										String significant_level = (String)DrugInteractionDtl.get("significant_level");
										String probability = (String)DrugInteractionDtl.get("probability");
										String restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
										String interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
										intr_msg_content.append(chk.get("DRUG_DESC"));
										intr_msg_content.append(" interacts with ");
										intr_msg_content.append(intr_name);
										intr_msg_content.append("<br />");
										intr_msg_content.append(interaction_desc+"<br />(Severity level - ");
										if(severity_level.equals("L"))
											intr_msg_content.append("Minor");
										if(severity_level.equals("M"))
											intr_msg_content.append("Moderate");
										if(severity_level.equals("H"))
											intr_msg_content.append("Major");
										intr_msg_content.append(") , (Significant Level "+significant_level+") , (Documentation - ");
										if(probability.equals("E")) // added for FD-RUT-CRF-0066.1 [IN036975] --begin
											intr_msg_content.append("Established");
										else if(probability.equals("P"))
											intr_msg_content.append("Probable");
										else if(probability.equals("S"))
											intr_msg_content.append("Suspected");
										else if(probability.equals("O"))
											intr_msg_content.append("Possible");
										else if(probability.equals("U"))
											intr_msg_content.append("Unlikely");
										intr_msg_content.append(") ");
									}
								}
								
								if(intr_restric_trn.equals("Y")){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("DRUG_INTERACTION");
									errorItem.setErrorMessage(intr_msg_content.toString());
									errorItem.setErrorDetails(DrugInteractionDtl);
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
								}else{
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("DRUG_INTERACTION");
									errorItem.setErrorMessage(intr_msg_content.toString());
									errorItem.setErrorDetails(DrugInteractionDtl);
									errorItems.add(errorItem);
									if(validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_ERROR && validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_WARNING)
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);
								}
								
								
							}
							
							//duplicate medications check
							boolean dup_found	=	false;
							String skip_duplicte_alert       = bean.getSkipDuplicateAlertIp_yn(); 
							String allow_duplicate				= (String) chk.get("ALLOW_DUPLICATE_DRUG");
							String allow_duplicate_op				= (String) chk.get("ALLOW_DUPLICATE_DRUG_OP");
							String drug_db_duptherapy_flag      = (String)chk.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)chk.get("DRUG_DB_DUPTHERAPY_FLAG");
							String generic_id = (String)chk.get("GENERIC_ID");
							String generic_name = (String)chk.get("GENERIC_NAME");
							String drug_desc = (String)chk.get("DRUG_DESC");
							String orig_current_rx = "";
							String dup_drug_info	=	""; 
							String previous_order_date = "";
							boolean skip_dup_flag = true;
							String current_rx					= (String) chk.get("CURRENT_RX")==null?"":(String) chk.get("CURRENT_RX");
							if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
								allow_duplicate = allow_duplicate_op;
								skip_duplicte_alert = bean.getSkipDuplicateAlertOp_yn(); // Added for MO-CRF-20085.1 [IN057392]
								//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_OP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
							}
							//String duplicate_check_at_atc_yn       = (String) chk.get("DUPLICATE_CHECK_AT_ATC_YN"); 
							if( chk.containsKey("ORIG_CURRENT_RX") && ((String)chk.get("ORIG_CURRENT_RX")).equals("Y") ) {
								orig_current_rx	=	(String)chk.get("ORIG_CURRENT_RX");
							}
							String start_date					= (String) chk.get("START_DATE");
							String end_date					= (String) chk.get("END_DATE");
							String freq_code					= (String) chk.get("FREQ_CODE")==null?"":(String) chk.get("FREQ_CODE");
							
							String overlap_period_for_op        =   bean.getOverlapPeriodForOP();//CRF-20085.1
							String overlap_period_for_ip        =   bean.getOverlapPeriodForIP();//CRF-20085.1
							String ph_drug_overlap_period = ""; 
							
							if(patient_class.equals("OP"))
								ph_drug_overlap_period = overlap_period_for_op;
						
							if (patient_class.equals("IP"))
								ph_drug_overlap_period = overlap_period_for_ip;
							int no_of_days = 0;
							if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){					
								previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);
								if(previous_order_date==null || previous_order_date.equals(""))
									previous_order_date = start_date;
								no_of_days= DateUtils.daysBetween(previous_order_date, start_date, "DMYHM", locale);
								if(!locale.equals("en"))
									previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
								if(no_of_days<=Integer.parseInt(ph_drug_overlap_period))
									skip_dup_flag = false;
								
							}
							
							String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
							String ext_prod_id			   = (String) chk.get("EXTERNAL_PRODUCT_ID")==null?"":(String) chk.get("EXTERNAL_PRODUCT_ID");
							if((!drug_db_interface_yn.equals("Y")) || drug_db_duptherapy_yn.equals("N") || (ext_prod_id.equals(""))){
								//if(current_rx.equals("Y")) {
									String atc_level_1		=	"";
									String atc_level_2		=	"";
									String atc_level_3		=	"";
									String atc_level_4		=	"";
									String atc_level_5		=	"";
									String generic_atc_name =   "";
									String provide_taper	=	"";
									String temp_generic_id	=	"";
									String temp_drug_code	=	"";
									String temp_drug_desc	=	"";
									String current_rx_tapered = "";
									String duplicate_check_at_atc_yn=""; //added for skr-scf-0143 IN 29184
									ArrayList atc_values	=  new ArrayList();
									ArrayList atc_dup_drug_code= null; // added for the incident no 27465
									HashMap drug_detail		=	null;
									if(presDetails!=null && presDetails.size()>0){
										for(int i=0;i<presDetails.size();i++){
											current_rx_tapered = "";
											drug_detail=(HashMap) presDetails.get(i);
											duplicate_check_at_atc_yn       = (String) drug_detail.get("DUPLICATE_CHECK_AT_ATC_YN");
											ext_prod_id			= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
											drug_db_duptherapy_flag		=  (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");
											//copied_drug_yn		=  (String)drug_detail.get("COPIED_DRUG_YN")==null?"":(String)drug_detail.get("COPIED_DRUG_YN");
											current_rx_tapered = drug_detail.get("CURRENT_RX")==null?"":(String)drug_detail.get("CURRENT_RX");// moved out from the below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -start
											//amend_yn			= drug_detail.get("AMEND_YN")==null?"":(String)drug_detail.get("AMEND_YN");
											if( current_rx_tapered.equals("Y") && !drug_detail.containsKey("ORIG_CURRENT_RX")) {
												drug_detail.put("ORIG_CURRENT_RX","Y");							
											}
											else if( !current_rx_tapered.equals("Y")){ //else if block added for Bru-HIMS-CRF-265 [IN:032315] // && !amend_yn.equals("Y") added for [IN:044495]
												drug_detail.put("ORIG_CURRENT_RX","N");		
											}
											if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){
												atc_level_1	    =	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
												atc_level_2	    =	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
												atc_level_3	    =	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
												atc_level_4	    =	(String)drug_detail.get("ATC_CLASS_LEV4_CODE");
												atc_level_5	    =	(String)drug_detail.get("ATC_CLASS_LEV5_CODE");
												generic_atc_name=  	(String)drug_detail.get("GENERIC_ATC_NAME");
												temp_generic_id	=	(String)drug_detail.get("GENERIC_ID");
												temp_drug_desc	=	(String)drug_detail.get("DRUG_DESC");
												temp_drug_code  =   (String)drug_detail.get("DRUG_CODE");
												temp_drug_desc=temp_drug_desc.replaceAll(" ","%20");
												temp_drug_desc = java.net.URLEncoder.encode(temp_drug_desc,"UTF-8");
												temp_drug_desc=temp_drug_desc.replaceAll("%2520","%20");
												if(drug_detail.get("TAPPERED_OVER")!=null)
													 provide_taper	= (String)drug_detail.get("TAPPERED_OVER");
												if( (!provide_taper.equals("Y")) && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") )  ) {
													atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE"); // added for the incident no 27465 - start
													if(atc_dup_drug_code == null)
														atc_dup_drug_code = new ArrayList();// added for the incident no 27465 - end	
													if(atc_values.contains(temp_generic_id)) {
														current_rx = "Y";
														drug_detail.put("CURRENT_RX","Y");
														atc_dup_drug_code.add(temp_drug_code);
														drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
														drug_detail.put("ALERT_YN","Generic :");
													}
													else if(atc_values.contains(atc_level_5)) {
														drug_detail.put("CURRENT_RX","Y");
														current_rx="Y";
														drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
														drug_detail.put("ALERT_YN","Level 4:");
														atc_dup_drug_code.add(temp_drug_code);
														drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
													}
													else if(atc_values.contains(atc_level_4)) {
														drug_detail.put("CURRENT_RX","Y");
														current_rx="Y";
													}
													else {
														atc_values.add(temp_drug_desc);
														atc_values.add(temp_drug_code);
														atc_values.add(temp_generic_id);
														if(!(generic_atc_name==null || generic_atc_name.equals(""))){
															atc_values.add(generic_atc_name);
														}
														if(!(atc_level_1==null || atc_level_1.equals(""))){
															atc_values.add(atc_level_1);
														}
														if(!(atc_level_2==null || atc_level_2.equals(""))){
															atc_values.add(atc_level_2);
														}
														if(!(atc_level_3==null || atc_level_3.equals(""))){
															atc_values.add(atc_level_3);
														}
														if(!(atc_level_4==null || atc_level_4.equals(""))){
															atc_values.add(atc_level_4);
														}
														if(!(atc_level_5==null || atc_level_5.equals(""))){
															atc_values.add(atc_level_5);
														}
													}
												}
											}
										}
									}
									duplicate_check_at_atc_yn       = (String) chk.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
									if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){
										atc_level_1	    =	(String)chk.get("ATC_CLASS_LEV1_CODE");
										atc_level_2	    =	(String)chk.get("ATC_CLASS_LEV2_CODE");
										atc_level_3	    =	(String)chk.get("ATC_CLASS_LEV3_CODE");
										atc_level_4	    =	(String)chk.get("ATC_CLASS_LEV4_CODE");
										atc_level_5	    =	(String)chk.get("ATC_CLASS_LEV5_CODE");
										generic_atc_name=  	(String)chk.get("GENERIC_ATC_NAME");
										if(chk.get("TAPPERED_OVER")!=null)
											 provide_taper	= (String)chk.get("TAPPERED_OVER");
										if( (!provide_taper.equals("Y")) && (chk.get("CURRENTRX_REMARKS")==null || ((String)chk.get("CURRENTRX_REMARKS")).equals("") )  ) {	
											atc_dup_drug_code = (ArrayList)chk.get("ATC_DUP_DRUG_CODE"); // added for the incident no 27465 - start
											if(atc_dup_drug_code == null)
												atc_dup_drug_code = new ArrayList();// added for the incident no 27465 - end	
											if(atc_values.contains(generic_id)) {
												current_rx = "Y";
												chk.put("CURRENT_RX","Y");
												if(skip_dup_flag){
													dup_found = true;
													if(!atc_dup_drug_code.contains(drug_code))//Added to avoid duplicate drugcode on atc list for TTM-SCF-0073[IN046928]
														atc_dup_drug_code.add(drug_code);// added for the incident no 27465
													chk.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
												}
											}
											else if(atc_values.contains(atc_level_5)){
												chk.put("CURRENT_RX","Y");
												current_rx="Y";
												if(skip_dup_flag){ 
													dup_found = true;
													atc_dup_drug_code.add(drug_code);
													chk.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
												}
											}
											else if(atc_values.contains(atc_level_4)){
												drug_detail.put("CURRENT_RX","Y");
												current_rx="Y";
												if(skip_dup_flag){
													dup_found = true;
													atc_dup_drug_code.add(drug_code);
													chk.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
												}
											}
										}	
									}
								//}
							}
							
							
							
							if(orig_current_rx.equals("Y")  || drug_db_duptherapy_flag.equals("Y") || current_rx.equals("Y")) { 
								dup_found	=	true;
								ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
								HashMap  dup_info		=	null;
								/*if(curr_info!=null && curr_info.size()>=1) {
									dup_info	  =	(HashMap)curr_info.get(0);
									dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+". ";
									dup_drug_info = dup_drug_info+" Prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
								}else{
									dup_drug_info = "Patient is currently on "+generic_name+" Medication";
								}*/
								dup_drug_info = drug_desc + " duplicates with generic  "+generic_name + ". ";
							}
							if(dup_found){
								/*if(allow_duplicate.equals("N")){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("DUPLICATE_DRUG");
									errorItem.setErrorMessage(dup_drug_info);
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
								}else{*/
									/*PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("DUPLICATE_DRUG");
									errorItem.setErrorMessage(dup_drug_info);
									errorItems.add(errorItem);
									if(validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_ERROR)
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);*/
								//}
								if(allow_duplicate.equals("N")){
									chk.put("PRIORITY","U");
									chk.put("FREQ_CODE", "STAT");
									chk.put("FREQ_DESC", "STAT");
									chk.put("DURN_VALUE", "1");
									chk.put("freq_chng_durn_desc", "D");
									chk.put("DURN_DESC", "Day(s)");
									dup_drug_info = dup_drug_info + "Only STAT dose can be prescribed";
									//chk.put("CURRENTRX_OVERRIDE", "N");
								}
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("DUPLICATE_DRUG");
								errorItem.setErrorMessage(dup_drug_info);
								errorItems.add(errorItem);
								if(validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_ERROR && validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_WARNING)
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);
							}
							
							
						
							
							/*boolean skip_dup_flag = true;
							String overlap_period_for_op        =   bean.getOverlapPeriodForOP();//CRF-20085.1
							String overlap_period_for_ip        =   bean.getOverlapPeriodForIP();//CRF-20085.1
							String ph_drug_overlap_period = ""; 
							String previous_order_date              =   "";
							String skip_duplicte_alert              =   "";
							String allow_duplicate				= (String) chk.get("ALLOW_DUPLICATE_DRUG");
							String allow_duplicate_op				= (String) chk.get("ALLOW_DUPLICATE_DRUG_OP");
							String start_date					= (String) chk.get("START_DATE");
							String end_date					= (String) chk.get("END_DATE");
							String generic_id					= (String) chk.get("GENERIC_ID");
							String freq_code					= (String) chk.get("FREQ_CODE")==null?"":(String) chk.get("FREQ_CODE");
							String current_rx					=(String) chk.get("CURRENT_RX")==null?"":(String) chk.get("CURRENT_RX");
							String drug_db_duptherapy_flag      = (String)chk.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)chk.get("DRUG_DB_DUPTHERAPY_FLAG");
							if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
								allow_duplicate = allow_duplicate_op;
								skip_duplicte_alert = bean.getSkipDuplicateAlertOp_yn(); // Added for MO-CRF-20085.1 [IN057392]
								//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_OP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
							}
							if(patient_class.equals("OP"))
								ph_drug_overlap_period = overlap_period_for_op;
						
							if (patient_class.equals("IP"))
								ph_drug_overlap_period = overlap_period_for_ip;
							int no_of_days = 0;
							if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){					
								previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);
								if(previous_order_date==null || previous_order_date.equals(""))
									previous_order_date = start_date;
								no_of_days= DateUtils.daysBetween(previous_order_date, start_date, "DMYHM", locale);
								if(!locale.equals("en"))
									previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
								if(no_of_days<=Integer.parseInt(ph_drug_overlap_period))
									skip_dup_flag = false;
								
							}*/
							
							/*if(skip_dup_flag){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("DUPLICATE_ORDERS");
								errorItem.setErrorMessage(intr_msg_content.toString());
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}*/
							if(validationResponse.getValidationResult() == PharmValidationResponse.VALIDATION_SUCCESS){
								
								
								
								//OrderEntryBean and PrescriptionBean_1 updation starts
								orbean.setCatalogCodes(check_box_value);
								String key				= (orbean.getPatientId()+orbean.getEncounterId());
								HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
								if(previousValues == null){
									previousValues = new HashMap();
								}
								previousValues.put("ck"+orderCatalogCode, "Y");
								previousValues.put("h1"+orderCatalogCode,orderCategoryCode);
								previousValues.put("h2"+orderCatalogCode,orderTypeCode);
								orderEntryRecordBean.setCheckedEntries(key, previousValues);
								bean.addDrugDetails(999,chk);
								bean.setSrlNo(srl_no);
								//OrderEntryBean updation ends
								
								//populateEndDate
								String freq_nature			= (String) chk.get( "FREQ_NATURE" )==null?"":(String) chk.get("FREQ_NATURE");
								start_date			= (String) chk.get( "START_DATE" )==null?"":(String) chk.get("START_DATE");
								String durn_value			= (String) chk.get( "DURN_VALUE" )==null?"":(String) chk.get("DURN_VALUE");
								String repeat_durn_type		= (String) chk.get( "REPEAT_DURN_TYPE" )==null?"":(String) chk.get("REPEAT_DURN_TYPE");
								end_date=(String)bean.populateEndDate(freq_nature,start_date,durn_value,repeat_durn_type);
								chk.put("END_DATE", end_date);
								
								//validateDosageLimit
								String qty_value	= (String) chk.get( "QTY_VALUE" )==null?"":(String) chk.get("QTY_VALUE");
								String repeat_value	= (String) chk.get( "REPEAT_VALUE" )==null?"":(String) chk.get("REPEAT_VALUE");
								String dosage_type  = (String) chk.get( "DOSAGE_TYPE" )==null?"":(String) chk.get("DOSAGE_TYPE");
								String calc_def_dosage_yn		= (String) chk.get("CALC_DEF_DOSAGE_YN")==null?"":(String) chk.get("CALC_DEF_DOSAGE_YN");
								ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
								if(freq_nature.equals("P") || freq_nature.equals("O")){
									chk.put("LIMIT_IND","Y");
									chk.put("DOSE_REMARKS","");
								}
								if(schedule.size() > 0){
									 /*HashMap detail	=	(HashMap)schedule.get(0);
									 qty_value		=	(String)detail.get("admin_qty");*/
									 ArrayList dose_list		= (ArrayList)schedule.get(4);
									 if(dose_list!=null && dose_list.size()>0)
										 qty_value		=	(String)dose_list.get(0);
									else
										 qty_value="1";
								}
								
								if(calc_def_dosage_yn.equals("Y")){
									HashMap dosageDetails= (HashMap) presBean.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value);
									String limit_ind= (String) dosageDetails.get("LIMIT_IND")==null?"":(String) chk.get("LIMIT_IND");
									if(limit_ind != null && limit_ind.equals("N")){
										String daily_dose = (String) dosageDetails.get("DAILY_DOSE")==null?"":(String) chk.get("DAILY_DOSE");
										String unit_dose = (String) dosageDetails.get("UNIT_DOSE")==null?"":(String) chk.get("UNIT_DOSE");
										String mono_graph = (String) dosageDetails.get("MONO_GRAPH")==null?"":(String) chk.get("MONO_GRAPH");
										String min_daily_dose= (String) dosageDetails.get("MIN_DAILY_DOSE")==null?"":(String) chk.get("MIN_DAILY_DOSE");
										String min_unit_dose= (String) dosageDetails.get("MIN_UNIT_DOSE")==null?"":(String) chk.get("MIN_UNIT_DOSE");
										String dose_unit= (String) dosageDetails.get("DOSAGE_UNIT")==null?"":(String) chk.get("DOSAGE_UNIT");
										chk.put("LIMIT_IND",limit_ind);
										chk.put("DAILY_DOSE",daily_dose);
										chk.put("UNIT_DOSE", unit_dose);
										chk.put("MONO_GRAPH", mono_graph);
										chk.put("MIN_DAILY_DOSE", min_daily_dose);
										chk.put("MIN_UNIT_DOSE", min_unit_dose);
										chk.put("DOSAGE_UNIT",(String) dosageDetails.get("DOSAGE_UNIT"));
									}
								}
								String qty_desc_code = chk.get("QTY_DESC_CODE")==null?"":(String)chk.get("QTY_DESC_CODE");
								String interval_value = chk.get("INTERVAL_VALUE")==null?"":(String)chk.get("INTERVAL_VALUE");
								String episode_type= patientContext.getPatientClass();
								if(episode_type !=null && (!episode_type.equals("")))
									episode_type = episode_type.substring(0,1);
								if(episode_type !=null && episode_type.equals("X"))
									episode_type = "R";
								String order_Date = bean.getOrderDate();
								String bl_overriden_action_reason = ""; //empty since we dont allow override in EM Mobile
								bean.setBillingDetail(chk,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,"", bl_overriden_action_reason, "ASSIGN_OVERRIDE",take_home_medication);//,pat_brought_medn
								
							}
						}
						/* PrescriptionBean_1 updation ENDS */
						PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
						PersistenceHelper.putObjectInBean(bean_id,bean,request);
					}
					catch(Exception e){
						PharmErrorItem errorItem = new PharmErrorItem();
						errorItem.setErrorMessageId("EXCEPTION_OCCURED");
						errorItem.setErrorMessage(e.getMessage());
						errorItems.add(errorItem);
						validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					}
					
				}
				else if(pharmPrescriptionMode.equals("CRX")){
					String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patient_id + encounter_id;
					String bean_name_CRX	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);
					String drug_code = request.getParameter("DrugCode")==null?"":request.getParameter("DrugCode");
					String trade_code = request.getParameter("TradeCodes")==null?"":request.getParameter("TradeCodes");
					String act_patient_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");
					String priority	= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");
					String location_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");
					String location_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");
					String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");					
					String recno= request.getParameter("recno") == null ? "":request.getParameter("recno");
					String source_code= request.getParameter("source_code") == null ? "":request.getParameter("source_code");
					String in_formulary = request.getParameter("in_formulary") == null ? "0":request.getParameter("in_formulary");//strArray[13]
					String order_type_code = "";
					String layerheight = request.getParameter("layerheight"); 				
					String drug_class ="";
					int size=bean_CRX.getDrugDetails().size();
					resp_id=size+1+"";
					//System.out.println("resp_id::"+resp_id);					
					boolean duplicateExists = checkDuplicateItem(drug_code, patient_id, encounter_id, request);
					//System.out.println("CRX duplicateExists : "  + duplicateExists);
					
					
					ArrayList drugList_CRX = bean_CRX.getDrugDetails();
					
					
					if(drugList_CRX.size()>=10){
						PharmErrorItem errorItem = new PharmErrorItem();
						errorItem.setErrorMessageId("ADDITIVE_ALREADY_SELECTED");
						errorItem.setErrorMessage("Maximum of 10 drugs  can be added in Compunding Rx");
						errorItems.add(errorItem);
						validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					}else{
						
						if(duplicateExists){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("DUPLICATE_ITEM");
							errorItem.setErrorMessage("Drug is already present in the cart");
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
						}
						else
						{					
						bean_CRX.setPriority(priority);
						bean_CRX.setDrgTradeCodesArray(trade_code);
						bean_CRX.setDrugDetails(drug_code, pract_id, resp_id,act_patient_class,priority,source_code,take_home_medication);
						HashMap hm	= bean_CRX.getCurrDrugDetails();
						
						String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
						String ph_bean_name 			= "ePH.DrugSearchBean";
						DrugSearchBean ph_drug_bean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;
						
						ArrayList stock_params	=	ph_drug_bean.validateForStock();					
						if(stock_params.size() > 1) {
							String consider_stock					= (String)stock_params.get(0);
							String disp_charge_dtl_in_drug_lkp_yn	= (String)stock_params.get(2);
							String disp_price_type_in_drug_lkp		= (String)stock_params.get(3);						
							String allow_yn	= (String)stock_params.get(1);						
							if(in_formulary.equals("Y") && consider_stock.equals("Y")) {
								ArrayList stock_dtls = ph_drug_bean.checkStock(drug_code, trade_code, drug_class, order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
								String avl_qty = (String)stock_dtls.get(1);							
								String strEnableDisable	=	(String)stock_dtls.get(3);							
								if((allow_yn.equals("N") && (stock_dtls.size()==0 || avl_qty.equals(""))) || strEnableDisable.equals("disabled")) {
									PharmErrorItem errorItem = new PharmErrorItem();								
									errorItem.setErrorMessageId("STOCK_UNAVAILABLE");
									errorItem.setErrorMessage("Selected drug not available in stock");
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
								} 
							}
						}
						String strength				= (String)hm.get("STRENGTH_VALUE");
						String strength_uom			= (String)hm.get("STRENGTH_UOM");
						
						String dosage				= (String)hm.get("QTY_VALUE");
						String dosage_uom			= (String)hm.get("QTY_UOM");		
						String form_desc			= (String)hm.get("FORM_DESC");
						String allergy_override		= (String)hm.get("ALLERGY_OVERRIDE");
						String dose_override		= (String)hm.get("DOSE_OVERRIDE");
						String currentrx_override	= (String)hm.get("CURRENTRX_OVERRIDE");
						String stock_uom			=  	bean_CRX.getStockUOM((String)hm.get("DRUG_CODE"));
						String generic_id			= (String)hm.get("GENERIC_ID");
						String generic_name			= (String)hm.get("GENERIC_NAME");
						String drug_desc            = (String)hm.get("DRUG_DESC")==null?"":(String)hm.get("DRUG_DESC");
						String limit_ind			= (String)hm.get("LIMIT_IND");
						String allergy_yn			= (String)hm.get("ALLERGY_YN");
						String current_rx			= (String)hm.get("CURRENT_RX");
						String drug_code1			= (String)hm.get("DRUG_CODE");
						String srl_no				= (String)hm.get("SRL_NO");
						String pres_base_uom		= (String)hm.get("PRES_BASE_UOM"); 
						String pres_base_uom_need   =  CommonBean.checkForNull( bean_CRX.getUomDisplay(facility_id,pres_base_uom));
						String external_product_id	= (String)hm.get("EXTERNAL_PRODUCT_ID");
						String perform_ext_db_checks	=(String)hm.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
						drug_class = (String)hm.get("DRUG_CLASS")==null?"":(String)hm.get("DRUG_CLASS");
						hm.put("DURN_VALUE","1");
						hm.put("DURN_TYPE","D");
						hm.put("END_DATE","" );
						if(recno.equals("1")){
							String buildMAR_Rule=hm.get("BUILD_MAR_RULE").toString();
							if(buildMAR_Rule.equals("CE") || buildMAR_Rule.equals("CD"))
								bean_CRX.setBuildMAR_yn("Y");
							else
								bean_CRX.setBuildMAR_yn("N");
							//out.println("setBuildMAR('"+buildMAR_Rule+"');");
							}
					}
						
						
						
						
					}
					
			}else if(pharmPrescriptionMode.equals("IVD")){
					try{
						String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
						String bean_name_IVD	= "ePH.IVPrescriptionBean";
						IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
						String drug_code = request.getParameter("DrugCode")==null?"":request.getParameter("DrugCode");
						String trade_code = request.getParameter("TradeCodes")==null?"":request.getParameter("TradeCodes");
						String act_patient_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");
						String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
						String location_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");
						String location_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");
						String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");
						String drugCodes = drug_code+",";
						String Trade_Codes = trade_code + ",";
						
						boolean duplicateExists = checkDuplicateItem(drug_code, patient_id, encounter_id, request);
						if(duplicateExists){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("DUPLICATE_ITEM");
							errorItem.setErrorMessage("Drug is already present in the cart");
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}else{
							bean.setExcludeADRAllergyAlert("");
							bean.setIS_COPY_ORDER(false);
							bean.setOrderDate(bean.getSysdate());
							bean.setDrgTradeCodesArray(Trade_Codes);
							bean.setDrugDetails(drugCodes, pract_id, resp_id,"","","","");
							StringBuffer selected_drug_codes = new StringBuffer();//csv of added drugs
							ArrayList drugDetails = bean.getDrugDetails();
							for(int c=0;c<drugDetails.size();c++){
								HashMap drugDetail = (HashMap)drugDetails.get(c);
								
								
								/*validate=SETUOM STARTS*/
								if(((String)drugDetail.get("DRUG_CODE")).equals(drug_code)){
									String strength_uom			= (String)drugDetail.get("STRENGTH_UOM");
									String strength_uom_desc	= (String)drugDetail.get("STRENGTH_UOM_DESC");
									String dosage_type	= (String)drugDetail.get("DOSAGE_TYPE");
									String drug_dosage	= (String)drugDetail.get("STRENGTH_VALUE");
									drugDetail.put("PRES_QTY_UOM",strength_uom);
									drugDetail.put("QTY_UOM",strength_uom);
									drugDetail.put("Dosage_Uom",strength_uom);
									drugDetail.put("QTY_UNIT",strength_uom);
									if(dosage_type.equals("Q"))
										drugDetail.put("QTY_DESC_CODE",strength_uom);
									drugDetail.put("QTY_VALUE",drug_dosage);
								}
								/*validate=SETUOM STARTS*/
								
								if(c==0){
									selected_drug_codes.append((String)drugDetail.get("DRUG_CODE")); 
								}else{
									selected_drug_codes.append(",");
									selected_drug_codes.append((String)drugDetail.get("DRUG_CODE")); 
								}
								
								String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"5":request.getParameter("iv_prep_yn");
								ArrayList ord_disp_location=new ArrayList();
								if(iv_prep_yn.equals("5")){
									ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);
									drugDetail.put("ORDER_TYPE","Normal");
									drugDetail.put("DISP_LOCN_DESC",ord_disp_location.get(2));
									drugDetail.put("DISP_LOCN_CODE",ord_disp_location.get(0));
									drugDetail.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
	
									
								}else{
									ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
									if(ord_disp_location != null & ord_disp_location.size()>0){
										String dflt_disp_locn	= (String)ord_disp_location.get(2);
										drugDetail.put("DISP_LOCN_DESC",ord_disp_location.get(2));
										drugDetail.put("DISP_LOCN_CODE",ord_disp_location.get(0));
										drugDetail.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
									}
	
								}
								
								String startDt		= (String)drugDetail.get("START_DATE");
								String endDt			= (String)drugDetail.get("END_DATE");
								
								  HashMap fluid_det =(HashMap)bean.getFluidDetails();
								  fluid_det.put("START_DATE",startDt);
						          fluid_det.put("END_DATE",endDt);
								
							}
							ArrayList dfltFluidDetails = null;
							if(drugDetails.size()==1){
								dfltFluidDetails = bean.getCompFluidDetails(drug_code,pract_id,resp_id);
							}else{
								dfltFluidDetails = bean.getCompFluidDetailsForMultipeDrugs(selected_drug_codes.toString(),pract_id,resp_id);
							}
							
							
							
							int fluid_adr_count = 0;
							String dfltFluidCode ="";
							if(dfltFluidDetails != null && dfltFluidDetails.size()>0){
								
								for(int j=0; j<dfltFluidDetails.size();j+=7 ){
									fluid_adr_count = bean.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
									//out.println("assignDfltVehicle('"+ dfltFluidDetails.get(j) + "', '" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+1)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "', '" + dfltFluidDetails.get(j+2)+ "','" + dfltFluidDetails.get(j+3)+ "','" + dfltFluidDetails.get(j+4)+ "','" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+5)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "','" + fluid_adr_count + "');") ;
									if(dfltFluidCode.equals("") && ((String)dfltFluidDetails.get(j+3)).equals("Y"))
										dfltFluidCode = (String)dfltFluidDetails.get(j);
								}
								if(dfltFluidCode.equals(""))
									dfltFluidCode = (String)dfltFluidDetails.get(0);
					//commented during PE By Naveen
								//String orderType	= bean.getOrderType(dfltFluidCode);
								bean.setFluidDetails(dfltFluidCode,act_patient_class,priority,location_code,take_home_medication); // CRF-0062 Added to get the Build MAR Rule
					            HashMap fluid_det =(HashMap)bean.getFluidDetails();
								// SKR-SCF-0288 [IN:029447]  - Chandrasekhar
								String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
								String fluid_stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
								fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
								fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
								fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
		
								String	back_date					= (String) fluid_det.get("BACK_DATE");
								String  future_date					= (String) fluid_det.get("FUTURE_DATE");
								//out.println("setBackFutureDate('"+ back_date +"','"+ future_date +"');");
								// SKR-SCF-0288 [IN:029447]  - Chandrasekhar
								String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
								// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- begin
								String buildMARRule=(String)fluid_det.get("BUILD_MAR_RULE");
								//out.println("setBuildMAR('"+buildMARRule+"');");
								// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- end
								if (bean.checkForStock()) {
									ArrayList stockDetails = bean.getStockDetails(dfltFluidCode, "1");
									if (stockDetails.size() != 0){
										//out.println("setStockDetails(3, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" +bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "','"+fluid_stock_uom_desc+"');") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949]  by Sureshkumar T on 06/06/2012
									}
									else{
										//out.println("setStockDetails(2);") ;
									}
								}
								//out.println("setOrderType('"+ orderType + "');");
								String infuse	=	bean.getInfuseOverValue(dfltFluidCode,"");
								//out.println("setInfuseValue('"+infuse+ "',1);");
								StringTokenizer st			=	new StringTokenizer(drugCodes,",");
								String  drug_code1			=	st.nextToken();
								
								if (bean.checkForStock()) {
									ArrayList stockDetails = bean.getStockDetails(drug_code1, "1");
		
									if (stockDetails.size() != 0){
										fluid_det.put("STOCK_VALUE",stockDetails.get(0));
							            fluid_det.put("QTY_VALUE",stockDetails.get(0));
							            bean.setVOLUME((String)stockDetails.get(0));
							            fluid_det.put("STOCK_UOM_DESC",bean.getUomDisplay(facility_id,(String)stockDetails.get(1)));
							            fluid_det.put("STOCK_UOM_CODE", stockDetails.get(1));
										// stock_value=(String)stockDetails.get(0);
										//out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
									}
									else{
										 //out.println("setStockDetails(2);") ;
									}
								} 
							}
							/*String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
						 	String dflt_disp_locn	= "";	
							ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added for Bru-HIMS-CRF-347 [IN:037862] ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
							if(ord_disp_location != null & ord_disp_location.size()>0)
								dflt_disp_locn	= (String)ord_disp_location.get(2);*/
							//out.println("displayDispLocn('"+dflt_disp_locn+"');");
							
							
							String infuse_over_value="";
							String infuse_over_unit="";
							String infusion_period_value = "";
							String infusion_period_value_min = "";
							String infuse_over_unit_sch;
							String infusion_rate="";
							
							String infuse	=	bean.getInfuseOverValue(dfltFluidCode,"");
							StringTokenizer st_inf = new StringTokenizer(infuse,"::");
							if(st_inf.hasMoreTokens())
								infuse_over_value = st_inf.nextToken();
							if(st_inf.hasMoreTokens())
								infuse_over_unit = st_inf.nextToken();
							bean.setINFUSE_OVER(infuse_over_value);
							if(infuse_over_unit.equals("M")){
								infuse_over_value = ""+Math.round(Math.ceil(Float.parseFloat(infuse_over_value)));
							}
							infusion_period_value = ""+Math.floor(Float.parseFloat(infuse_over_value));
							infusion_period_value_min = ""+(Math.ceil((((new Double(infuse_over_value))*60)%60))*10)/10;
							String volume="";
							if(!infuse_over_value.equals("") && Float.parseFloat(infuse_over_value)>0){
								volume=bean.getVOLUME();
								infusion_rate = ""+Math.round((Float.parseFloat(volume)/Float.parseFloat(infuse_over_value))*100.0)/100.0;
							}
							
							
							if(infuse_over_value.indexOf(".") != -1){
								infusion_period_value	 = infuse_over_value.substring(0,infuse_over_value.indexOf("."));
								Double Dtemp	 = new Double(infuse_over_value);
								Dtemp			 = Dtemp*60;
								Dtemp			 = (Dtemp%60);
								infusion_period_value_min	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
								if(infusion_period_value_min.indexOf(".") != -1)
									infusion_period_value_min = infusion_period_value_min.substring(0,infusion_period_value_min.indexOf(".")); // infuse_over_mi = xx
	
							}else{
								infusion_period_value	 = infuse_over_value;
								infusion_period_value_min	 = "";
							}
	
							infusion_period_value			= infusion_period_value.equals("")?"0":infusion_period_value;
							infusion_period_value_min			= infusion_period_value_min.equals("")?"0":infusion_period_value_min;
						//String 	disp_str				= "["+infusion_period_value+" Hrs "+infusion_period_value_min+" Mins]";
							
						HashMap fluid_det =(HashMap)bean.getFluidDetails();
						
						
						
							
							fluid_det.put("INFUSE_OVER",infuse_over_value);//infusion_over_insert_value
							fluid_det.put("INFUSION_PERIOD_VALUE",infusion_period_value);
							fluid_det.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
							fluid_det.put("SCH_INFUSION_RATE",infusion_rate);
							fluid_det.put("INFUSION_PERIOD_UOM",infuse_over_unit);
							
							
							
							
							
							
							String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"5":request.getParameter("iv_prep_yn");
							String dflt_disp_locn	= "";	
							ArrayList ord_disp_location=new ArrayList();
							if(iv_prep_yn.equals("5")){
								ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);
							
								fluid_det.put("DISP_LOCN_DESC",ord_disp_location.get(2));
								fluid_det.put("DISP_LOCN_CODE",ord_disp_location.get(0));
								fluid_det.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
							
								
							}else{
								ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
								if(ord_disp_location != null & ord_disp_location.size()>0){
									dflt_disp_locn	= (String)ord_disp_location.get(2);
									fluid_det.put("DISP_LOCN_DESC",ord_disp_location.get(2));
									fluid_det.put("DISP_LOCN_CODE",ord_disp_location.get(0));
									fluid_det.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
								}
	
							}
						
						}
						
						
						PersistenceHelper.putObjectInBean(bean_id_IVD,bean,request);
						
					}
					catch(Exception e){
						PharmErrorItem errorItem = new PharmErrorItem();
						errorItem.setErrorMessageId("EXCEPTION_OCCURED");
						errorItem.setErrorMessage(e.getMessage());
						errorItems.add(errorItem);
						validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					}
				}else if(pharmPrescriptionMode.equals("IVPB")){
					try{
						IVPiggyBackBean bean_pig = (IVPiggyBackBean)PersistenceHelper.getBeanObject("@IVPiggyBackBean"+patient_id+encounter_id, "ePH.IVPiggyBackBean", request);
						String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
						String bean_name_IVPB	= "ePH.IVPrescriptionBean";
						IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
						
						
						String param_bean_id				= "@DrugInterfaceControlBean";
						String param_bean_name				= "ePH.DrugInterfaceControlBean";
						DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
						String drug_db_interface_yn			= "N";
						String drug_db_product_id			= "";
						String drug_db_dosecheck_yn			= "N";
						String drug_db_duptherapy_yn		= "N";
						String drug_db_interact_check_yn	= "N";
						String drug_db_contraind_check_yn	= "N";
						String drug_db_allergy_check_yn		= "N";
						String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
						if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>6){
							drug_db_interface_yn			=	sDrugDBAllChecks[0];    
							drug_db_product_id			=	sDrugDBAllChecks[1];    
							drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
							drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
							drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
							drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
							drug_db_allergy_check_yn		=	sDrugDBAllChecks[6];    
						}
						iv_bean.setDrug_DB_Product_id(drug_db_product_id);
						iv_bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
						String drugCodes = request.getParameter("DrugCode")==null?"":request.getParameter("DrugCode");
						String trade_code = request.getParameter("TradeCodes") == null ? "":request.getParameter("TradeCodes");
						String act_pat_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");// Taken from PharmBasePage --actual_patient_class
						String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
						String location_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");// Taken from PharmBasePage --location_type
						String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");//Taken from PharmBasePage - take_home_medication
						String location_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");
						String iv_prep_yn	= request.getParameter("iv_prep_yn") == null ? "3":request.getParameter("iv_prep_yn");
						
						boolean duplicateExists = checkDuplicateItem(drugCodes, patient_id, encounter_id, request);
						if(duplicateExists){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("DUPLICATE_ITEM");
							errorItem.setErrorMessage("Drug is already present in the cart");
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
						}else{
							
							ArrayList drugList			= iv_bean.getDrugDetails();
							if(drugList.size()>0){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("ADDITIVE_ALREADY_SELECTED");
								errorItem.setErrorMessage("Only one additive can be selected in IV Intermittent");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}else{
								iv_bean.setIS_COPY_ORDER(false);
								iv_bean.setDrgTradeCodesArray(trade_code);
								iv_bean.setDrugDetails(drugCodes, pract_id, resp_id,act_pat_class,priority,location_code,take_home_medication);
								String dflt_disp_locn	= "";	
								ArrayList ord_disp_location  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
								if(ord_disp_location != null & ord_disp_location.size()>0){
									dflt_disp_locn	= (String)ord_disp_location.get(2);
								}
								drugList			= iv_bean.getDrugDetails();
								HashMap hm	= (HashMap)drugList.get(0);
								
								String generic_id			= (String)hm.get("GENERIC_ID");
								String generic_name			= (String)hm.get("GENERIC_NAME");
								String strength				= (String)hm.get("STRENGTH_VALUE");
								String strength_uom			= (String)hm.get("STRENGTH_UOM");
								String dosage				= (String)hm.get("STRENGTH_PER_VALUE_PRES_UOM");
								hm.put("QTY_VALUE", dosage);
								iv_bean.setQTY_VALUE(dosage);
								iv_bean.setDOSAGE(dosage);
								String dosage_uom			= (String)hm.get("QTY_UOM");
								iv_bean.setQTY_UNIT(dosage_uom);
								String freq_code			= (String)hm.get("FREQ_CODE");
								String allergy_override		= (String)hm.get("ALLERGY_OVERRIDE");
								String dose_override		= (String)hm.get("DOSE_OVERRIDE");
								String currentrx_override	= (String)hm.get("CURRENTRX_OVERRIDE");
								String drug_desc	        = (String)hm.get("DRUG_DESC");
								String dosage_unit	        = (String)hm.get("DOSAGE_UNIT");
								String daily_dose			= (String)hm.get("DAILY_DOSE");
								String min_daily_dose		= (String)hm.get("MIN_DAILY_DOSE")==null?"":(String)hm.get("MIN_DAILY_DOSE");
								String min_unit_dose		= (String)hm.get("MIN_UNIT_DOSE")==null?"":(String)hm.get("MIN_UNIT_DOSE");
								String unit_dose			= (String)hm.get("UNIT_DOSE")==null?"":(String)hm.get("UNIT_DOSE");
								String dosage_std			= (String)hm.get("DOSAGE_STD")==null?"":(String)hm.get("DOSAGE_STD");
								String recomm_dosage_by		= (String)hm.get("RECOMM_DOSAGE_BY")==null?"":(String)hm.get("RECOMM_DOSAGE_BY");
								String calc_by_ind			= (String)hm.get("CALC_BY_IND")==null?"":(String)hm.get("CALC_BY_IND");
								String mono_graph			= (String)hm.get("MONO_GRAPH")==null?"":(String)hm.get("MONO_GRAPH");
								String limit_ind			= (String)hm.get("LIMIT_IND")==null?"":(String)hm.get("LIMIT_IND");
								String recomm_yn			= (String)hm.get("RECOMM_YN")==null?"":(String)hm.get("RECOMM_YN");
								String dosage_by 		    = (String)hm.get("DOSAGE_TYPE");
								String volume	            = (String)hm.get("CONTENT_IN_PRES_BASE_UOM");
								String pres_base_uom		= (String)hm.get("PRES_BASE_UOM");
								String ord_auth_reqd_yn     = (String)hm.get("ORD_AUTH_REQD_YN");
								String auth_yn_val          = (String)hm.get("ORD_AUTHORIZED_YN");
								String ord_spl_appr_reqd_yn = (String)hm.get("ORD_SPL_APPR_REQD_YN");
								String approval_yn_val      = (String)hm.get("ORD_APPROVED_YN");
								String ord_cosign_reqd_yn   = (String)hm.get("ORD_COSIGN_REQD_YN");
								String cosign_yn_val        = (String)hm.get("ORD_COSIGNED_YN");
								String consent_reqd_yn      = (String)hm.get("CONSENT_REQD_YN");
								String allergy_yn			= (String)hm.get("ALLERGY_YN");
								String current_rx			= (String)hm.get("CURRENT_RX");
								String drug_code			= (String)hm.get("DRUG_CODE");
								String srl_no				= (String)hm.get("SRL_NO");
								String allergy_remarks		= (String)hm.get("ALLERGY_REMARKS");
								String dose_remarks			= (String)hm.get("DOSE_REMARKS");
								String currentrx_remarks	= (String)hm.get("CURRENTRX_REMARKS");
								String sRegRopt				= (String)hm.get("REQD_OR_OPT_IND"); 
								String external_product_id	= (String)hm.get("EXTERNAL_PRODUCT_ID"); 
								String perform_ext_db_checks= (String)hm.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
								String iv_ingredient_yn		= (String)hm.get("IV_INGREDIENT_YN");
								String iv_fluid_yn			= (String)hm.get("IV_FLUID_YN");	
								String startdate			= (String)hm.get("START_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
								String enddate				= (String)hm.get("END_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
							   int drug_adr_count = iv_bean.getADRCount(patient_id,drug_code);   
								 
								StringTokenizer st			=	new StringTokenizer(drugCodes,",");
								String  drug_code1			=	st.nextToken();
								String	back_date			= (String) hm.get("BACK_DATE");
								String  future_date			= (String) hm.get("FUTURE_DATE");
								
								String tdmOrderId = "";
								if(hm.get("TDM_ORDER_ID")== null){
								   tdmOrderId = iv_bean.getOrderIdForTDMDtls(patient_id,drug_code);
									hm.put("TDM_ORDER_ID",tdmOrderId);
								}
								else 
									tdmOrderId = (String)hm.get("TDM_ORDER_ID");
			
								if(tdmOrderId !=null && !tdmOrderId.equals("")){
								}
								if( iv_ingredient_yn.equals("Y")){
									ArrayList freqValues = bean_pig.getSheduleFrequency(drug_code);
									if(freqValues!=null && freqValues.size()>0){
										//out.println("clearFrequencyList();") ;
										for (int i=0;i<freqValues.size();i+=2){
											//out.println("addOption('"+((String)freqValues.get(i))+"','"+((String)freqValues.get(i+1))+"');");
											//out.println("addFrequencyList(\""+((String)freqValues.get(i))+"\",\""+((String)freqValues.get(i+1))+"\",\""+freq_code.trim()+"\")");
										}
										//out.println("dfltFreq('"+freq_code.trim()+"')");
									}
									if(iv_fluid_yn.equals("Y") ){
										strength	 = volume;
										strength_uom = pres_base_uom;
									}
									if(!dosage_by.equals("S")){
										strength = dosage;
										strength_uom = pres_base_uom;
									}
								}
								int fluid_adr_count = 0;
								if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("Y")){
			
									//commented during PE BY Naveen  code added below
									//String orderType	= iv_bean.getOrderType(drug_code1);
									fluid_adr_count     = iv_bean.getADRCount(patient_id,drug_code1);
									// volume was passed earlier, now passing dosage - sept-14-2010
									//out.println("assignDfltVehicle('"+ drug_code1 + "', '" + java.net.URLEncoder.encode(drug_desc,"UTF-8") + "', '" + dosage +"','Y','" +trade_code+ "','"+java.net.URLEncoder.encode(trade_name,"UTF-8")+"','"+fluid_adr_count+"');") ;// added "java.net.URLEncoder.encode(<>,"UTF-8")" for SRR20056-SCF-7374 Incident No. 27415
									//--REMOVED since fluid code and drug code are same//iv_bean.setFluidDetails(drug_code1,act_pat_class,priority,location_code,take_home_medication); // CRF-0062 NEWLY ADDED
			
					                HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();
								    String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
									iv_bean.setFluidFlag("N");
									  
									if (iv_bean.checkForStock()) {
										ArrayList stockDetails = iv_bean.getStockDetails(drug_code1, "1");
										iv_bean.setVOLUME((String)stockDetails.get(0));
										if (stockDetails.size() != 0){
											hm.put("FLUID_UNIT_QTY",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
											//fluid_det.put("STOCK_VALUE",stockDetails.get(0));
											//fluid_det.put("QTY_VALUE",stockDetails.get(0));
											//iv_bean.setVOLUME((String)stockDetails.get(0));
								            //fluid_det.put("STOCK_UOM_DESC",iv_bean.getUomDisplay(facility_id,(String)stockDetails.get(1)));
								            //fluid_det.put("STOCK_UOM_CODE", stockDetails.get(1));
											//stock_value=(String)stockDetails.get(0);
											//out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
										}
										else{
											 //out.println("setStockDetails(2);") ;
										}
									} 
			
									//out.println("setOrderType(\""+ orderType + "\");");
									
									String infuse_over_value="";
									String infuse_over_unit="";
									String infusion_period_value = "";
									String infusion_period_value_min = "";
									String infuse_over_unit_sch;
									String infusion_rate="";
									
									String infuse	=	iv_bean.getInfuseOverValue(drug_code1,"");
									StringTokenizer st_inf = new StringTokenizer(infuse,"::");
									
						
									
									
									if(st_inf.hasMoreTokens())
										infuse_over_value = st_inf.nextToken();
									if(st_inf.hasMoreTokens())
										infuse_over_unit = st_inf.nextToken();
									iv_bean.setINFUSE_OVER(infuse_over_value);
									if(infuse_over_unit.equals("M")){
										infuse_over_value = ""+Math.round(Math.ceil(Float.parseFloat(infuse_over_value)));
									}else{
										
										
									}
									infusion_period_value = ""+Math.floor(Float.parseFloat(infuse_over_value));
									infusion_period_value_min = ""+(Math.ceil((((new Double(infuse_over_value))*60)%60))*10)/10;
									
									if(!infuse_over_value.equals("") && Float.parseFloat(infuse_over_value)>0){
										volume=iv_bean.getVOLUME();
										infusion_rate = ""+Math.round((Float.parseFloat(volume)/Float.parseFloat(infuse_over_value))*100.0)/100.0;
									}
									
	
									if(infuse_over_value.indexOf(".") != -1){
										infusion_period_value	 = infuse_over_value.substring(0,infuse_over_value.indexOf("."));
										Double Dtemp	 = new Double(infuse_over_value);
										Dtemp			 = Dtemp*60;
										Dtemp			 = (Dtemp%60);
										infusion_period_value_min	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
										if(infusion_period_value_min.indexOf(".") != -1)
											infusion_period_value_min = infusion_period_value_min.substring(0,infusion_period_value_min.indexOf(".")); // infuse_over_mi = xx
	
									}else{
										infusion_period_value	 = infuse_over_value;
										infusion_period_value_min	 = "";
									}
	
									infusion_period_value			= infusion_period_value.equals("")?"0":infusion_period_value;
									infusion_period_value_min			= infusion_period_value_min.equals("")?"0":infusion_period_value_min;
									//String 	disp_str				= "["+infusion_period_value+" Hrs "+infusion_period_value_min+" Mins]";
									
									
									
									//fluid_det.put("INFUSE_OVER",infuse_over_value);//infusion_over_insert_value
									//fluid_det.put("INFUSION_PERIOD_VALUE",infusion_period_value);
									//fluid_det.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
									//fluid_det.put("INFUSION_RATE",infusion_rate);
									//fluid_det.put("INFUSE_OVER_UNIT",infuse_over_unit);
									
									ArrayList stockDetails = iv_bean.getStockDetails(drugCodes, "1");
									if (stockDetails.size() != 0){
										hm.put("STOCK_VALUE",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
										//hm.put("FLUID_UNIT_QTY",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
									}
									hm.put("INFUSION_RATE",infuse_over_value);//infusion_over_insert_value
									hm.put("INFUSION_PERIOD_VALUE",infusion_period_value);
									hm.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
									hm.put("SCH_INFUSION_RATE",infusion_rate);
									hm.put("INFUSION_PERIOD_UOM",infuse_over_unit);
									
									
									
									//out.println("setInfuseValue(\""+infuse+ "\", \"DRUGLOAD\");") ; //call_mode="DRUGLOAD" added for SRR20056-SCF-7374 Incident No. 27415
									
									//out.println("setSchedule();");
									//out.println("setUOM(\""+strength_uom+ "\", \"" + strength + "\");") ; //Commented for SRR20056-SCF-7374 Incident No. 27415
									//out.println("disableall();");    
								}else if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("N")){
									String or_bean_name				= "eOR.OrderEntryBean";
									String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
									OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
									String resp_id1					= (String) orbean.getResponsibilityId();
									String pract_id1				= (String) orbean.getPractitionerId();
			
			
									ArrayList dfltFluidDetails = iv_bean.getCompFluidDetails(drug_code1,pract_id1,resp_id1);
			
									String orderType	= iv_bean.getOrderType(drug_code);
									String fluid_code ="";
									
									if (iv_bean.checkForStock()) {
										ArrayList stockDetails = iv_bean.getStockDetails(drug_code1, "1");
										iv_bean.setVOLUME((String)stockDetails.get(0));
										if (stockDetails.size() != 0){
											hm.put("FLUID_UNIT_QTY",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
											hm.put("STOCK_VALUE",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
											//fluid_det.put("STOCK_VALUE",stockDetails.get(0));
											//fluid_det.put("QTY_VALUE",stockDetails.get(0));
											//iv_bean.setVOLUME((String)stockDetails.get(0));
								            //fluid_det.put("STOCK_UOM_DESC",iv_bean.getUomDisplay(facility_id,(String)stockDetails.get(1)));
								            //fluid_det.put("STOCK_UOM_CODE", stockDetails.get(1));
											//stock_value=(String)stockDetails.get(0);
											//out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
										}
										else{
											 //out.println("setStockDetails(2);") ;
										}
									} 
									
									
									if(dfltFluidDetails!=null && dfltFluidDetails.size() > 0) {
										//out.println("clearDfltVehicle();");
										for(int j=0; j<dfltFluidDetails.size();j+=7 ){
											if(j==0)
												fluid_code = (String)dfltFluidDetails.get(j);
											fluid_adr_count = iv_bean.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
											//out.println("assignDfltVehicle(\""+ dfltFluidDetails.get(j) + "\", \"" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+1)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "\", \"" + dfltFluidDetails.get(j+2)+ "\", \"" + dfltFluidDetails.get(j+3)+ "\", \"" + dfltFluidDetails.get(j+4)+ "\", \"" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+5)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "\",\"" + fluid_adr_count + "\");") ;
											if(((String)dfltFluidDetails.get(j+3)).equals("Y"))
												fluid_code = (String)dfltFluidDetails.get(j);
										}
										/*if(!order_set_code.equals("")){
											ArrayList orderSetCodes = (ArrayList) iv_bean.getOrdersetCodes(order_set_code);
											fluid_code = (String) orderSetCodes.get(0);
										}*/
			
										iv_bean.setFluidDetails(fluid_code,act_pat_class,priority,location_code,take_home_medication); // CRF-0062 NEWLY ADDED
										HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();
										if (iv_bean.checkForStock()) {
											ArrayList stockDetails = iv_bean.getStockDetails(fluid_code, "1");
			
											if (stockDetails.size() != 0){
												fluid_det.put("STOCK_VALUE",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
												hm.put("FLUID_UNIT_QTY",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
												fluid_det.put("FLUID_UNIT_QTY",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
									            fluid_det.put("QTY_VALUE",stockDetails.get(0));
									            iv_bean.setVOLUME((String)stockDetails.get(0));
									            fluid_det.put("STOCK_UOM_DESC",iv_bean.getUomDisplay(facility_id,(String)stockDetails.get(1)));
									            fluid_det.put("STOCK_UOM_CODE", stockDetails.get(1));
													//out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
											}
											else{
											//out.println("setStockDetails(2);") ;
											}
											/*stockDetails = iv_bean.getStockDetails(drugCodes, "1");
											if (stockDetails.size() != 0){
												hm.put("STOCK_VALUE",stockDetails.get(0).equals("")?"0":stockDetails.get(0));
											}*/
										}
										//out.println("setOrderType(\""+ orderType + "\");");
										String infuse_over_value="";
										String infuse_over_unit="";
										String infusion_period_value = "";
										String infusion_period_value_min = "";
										String infuse_over_unit_sch;
										String infusion_rate="";
										
										String infuse	=	iv_bean.getInfuseOverValue(fluid_code,"");
										StringTokenizer st_inf = new StringTokenizer(infuse,"::");
										if(st_inf.hasMoreTokens())
											infuse_over_value = st_inf.nextToken();
										if(st_inf.hasMoreTokens())
											infuse_over_unit = st_inf.nextToken();
										iv_bean.setINFUSE_OVER(infuse_over_value);
										if(infuse_over_unit.equals("M")){
											infuse_over_value = ""+Math.round(Math.ceil(Float.parseFloat(infuse_over_value)));
										}
										infusion_period_value = ""+Math.floor(Float.parseFloat(infuse_over_value));
										infusion_period_value_min = ""+(Math.ceil((((new Double(infuse_over_value))*60)%60))*10)/10;
										
										if(!infuse_over_value.equals("") && Float.parseFloat(infuse_over_value)>0){
											volume=iv_bean.getVOLUME();
											infusion_rate = ""+Math.round((Float.parseFloat(volume)/Float.parseFloat(infuse_over_value))*100.0)/100.0;
										}
										
										
										if(infuse_over_value.indexOf(".") != -1){
											infusion_period_value	 = infuse_over_value.substring(0,infuse_over_value.indexOf("."));
											Double Dtemp	 = new Double(infuse_over_value);
											Dtemp			 = Dtemp*60;
											Dtemp			 = (Dtemp%60);
											infusion_period_value_min	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
											if(infusion_period_value_min.indexOf(".") != -1)
												infusion_period_value_min = infusion_period_value_min.substring(0,infusion_period_value_min.indexOf(".")); // infuse_over_mi = xx
	
										}else{
											infusion_period_value	 = infuse_over_value;
											infusion_period_value_min	 = "";
										}
	
										infusion_period_value			= infusion_period_value.equals("")?"0":infusion_period_value;
										infusion_period_value_min			= infusion_period_value_min.equals("")?"0":infusion_period_value_min;
										String 	disp_str				= "["+infusion_period_value+" Hrs "+infusion_period_value_min+" Mins]";
										
										
										
										fluid_det.put("INFUSE_OVER",infuse_over_value);//infusion_over_insert_value
										fluid_det.put("INFUSION_PERIOD_VALUE",infusion_period_value);
										fluid_det.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
										fluid_det.put("INFUSION_RATE",infusion_rate);
										fluid_det.put("INFUSE_OVER_UNIT",infuse_over_unit);
										
										
										hm.put("INFUSION_RATE",infuse_over_value);//infusion_over_insert_value
										hm.put("INFUSION_PERIOD_VALUE",infusion_period_value);
										hm.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
										hm.put("SCH_INFUSION_RATE",infusion_rate);
										hm.put("INFUSION_PERIOD_UOM",infuse_over_unit);
										
										
										
										//out.println("setInfuseValue(\""+infuse+ "\");");
									}
								}
								
								//out.println("assignDosageDetails('"+(String)hm.get("DRUG_CODE")+"','"+java.net.URLEncoder.encode(drug_desc,"UTF-8")+"','"+strength+"','"+strength_uom+"','"+dosage+"','"+dosage_uom+"','"+freq_code+"','"+allergy_override+"','"+dose_override+"','"+currentrx_override+"','"+sRegRopt+"','"+drug_adr_count+"','"+pract_id+"','"+resp_id+"','"+buildMAR_yn+"','"+iv_fluid_yn+"','"+(String)hm.get("DURN_VALUE")+"')"); //iv_fluid_yn parameter added for "SRR20056-SCF-7374 IN27415"
								
								//out.println("assignAuthorization('"+ord_auth_reqd_yn+"','"+auth_yn_val+"','"+ord_spl_appr_reqd_yn+"','"+approval_yn_val+"','"+ord_cosign_reqd_yn+"','"+cosign_yn_val+"','"+consent_reqd_yn+"')");
								//out.println("dtlsForOverride('"+generic_id+"','"+generic_name+"','"+java.net.URLEncoder.encode(drug_desc,"UTF-8")+"','"+limit_ind+"','"+allergy_yn+"','"+current_rx+"','"+drug_code+"','"+srl_no+"','"+allergy_remarks+"','"+dose_remarks+"','"+currentrx_remarks+"')");
								
								//validate=DELETESCHEDULE
								//iv_bean.clearscheduleFrequency(drug_code);
								
								//validate=populateDurationDesc
								String durn_desc			= "";
								String repeat_durn_type		= "";
								String freq_value			= "";
								String freq_nature			= "";
								String interval_value		= "";
								String interval_durn_type		= "";
								String repeat_value			= "";
								String schedule_yn			= "";
								HashMap freqNature			=(HashMap)iv_bean.freqValidate(freq_code);
								if(freqNature.size()>0){
									freq_nature		= (String)freqNature.get("freq_nature");
									freq_value		= (String)freqNature.get("freq_value");
									interval_value	= (String)freqNature.get("interval_value");
									interval_durn_type	= (String)freqNature.get("interval_durn_type");
									repeat_value	= (String)freqNature.get("repeat_value");
									schedule_yn		= (String)freqNature.get("schedule_yn");
									repeat_durn_type= (String)freqNature.get("repeat_durn_type");
								}
								if(freq_nature != null && !freq_nature.equals("O")){
									//out.println("dfltDurnDesc(\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+formObj+"\")");			
					//out.println("alert('"+repeat_durn_type+"')");
									//out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\",\""+formObj+"\")");
									iv_bean.setRepeatValue(repeat_value);
								}
								else{
									durn_desc	="";
									freq_value	="";			
									//out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\",\""+formObj+"\")");
								}
								iv_bean.setFrequencyNature(freq_nature);
								iv_bean.setRepeatValue(repeat_value);
								iv_bean.setIntervalValue(interval_value);
								
								//validate=AUTOSCHEDULE
								Hashtable schedule_val	=	new Hashtable();
								ArrayList schedule		=	null;
								Hashtable sch_output	=	null;
								String sch_bean_id		= "OrScheduleFreq" ;
								String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
								if(iv_bean.getScheduledFreqYN(freq_code) && !iv_bean.checkPreScheduled(freq_code).equals("0")) {
									schedule	=	(ArrayList)iv_bean.getScheduleFrequencyStr(drug_code,"0");
			
									if(schedule.size()==0) {
										ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)PersistenceHelper.getBeanObject( sch_bean_id,sch_bean_name ,request);
										schedule_bean.setLanguageId(locale);
										schedule_val.put("facility_id", (String)session.getValue("facility_id"));
										schedule_val.put("start_time_day_param", startdate);
										schedule_val.put("module_id", "PH"); 
										schedule_val.put("split_dose_yn", "N"); 
										schedule_val.put("split_qty",dosage);
										schedule_val.put("freq_code",  freq_code );
										schedule_val.put("code",drug_code);
					//out.println("alert('"+drug_code+"')");
										sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
										sch_output.put("code",drug_code);
										sch_output.put("row_value","1");
										sch_output.put("start_date_time",startdate);
										iv_bean.setScheduleFrequencyStr(sch_output);
										//out.println("makeLink()");
										PersistenceHelper.putObjectInBean(sch_bean_id,schedule_bean,request);
									} 
									HashMap chkValuescheduleFrequency	=	null;
									ArrayList frequencyValues	        =	null;
									chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();
			
									if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
										frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code);
									}
								   HashMap data		    =	null;
								   String att			=	null;
								   String adm_time		=	"";
								   String adm_qty		=	"";
								   String total_qty	    =   "";
			
									if(frequencyValues!=null && frequencyValues.size()>0){
									/*	adm_time =adm_time +"<tr>";					
										for(int i=0;i<frequencyValues.size();i++){
											data=(HashMap)frequencyValues.get(i);
											att="align=center class=TIP";
											adm_time =adm_time +"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
										}
										adm_time =adm_time +"</tr>";
										adm_qty=adm_qty +"<tr>";
										for(int i=0;i<frequencyValues.size();i++){
											att="align=center class=TIP";
											data=(HashMap)frequencyValues.get(i);
											adm_qty=adm_qty +"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
											total_qty=(String) data.get("admin_qty");
										}
										adm_qty=adm_qty +"</tr>";*/
										String tooltiptable = (String)bean_pig.getTooltipStringFrFreq(frequencyValues,"toolTip");
										boolean split_chk	=	iv_bean.checkSplit(frequencyValues);
										adm_qty = tooltiptable;
										//out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"','"+iv_bean.getRepeatValue()+"')");
									}
								}
								
								
								//validate=SETUOM
			
								String drug_dosage = request.getParameter("drug_dosage");
								String dosage_type = request.getParameter("dosage_type");
								
								drugList			= iv_bean.getDrugDetails();
								hm.put("PRES_QTY_UOM",strength_uom);
								hm.put("QTY_UOM",strength_uom);
								hm.put("QTY_DESC_CODE",strength_uom);
								
								ArrayList ord_disp_locations=new ArrayList();
								if(iv_prep_yn.equals("5")){
									ord_disp_locations  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);
	
									hm.put("DISP_LOCN_DESC",ord_disp_locations.get(2));
									hm.put("DISP_LOCN_CODE",ord_disp_locations.get(0));
									hm.put("DISP_LOCN_TYPE",ord_disp_locations.get(1));
	
									
								}else{
									ord_disp_locations  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
									if(ord_disp_locations != null & ord_disp_locations.size()>0){
										String dflt_disp_locns	= (String)ord_disp_locations.get(2);
										hm.put("DISP_LOCN_DESC",ord_disp_locations.get(2));
										hm.put("DISP_LOCN_CODE",ord_disp_locations.get(0));
										hm.put("DISP_LOCN_TYPE",ord_disp_locations.get(1));
									}
	
								}
							}
						
						}
						
						
						PersistenceHelper.putObjectInBean(bean_id_IVPB,iv_bean,request);
					}
					catch(Exception e){
						PharmErrorItem errorItem = new PharmErrorItem();
						errorItem.setErrorMessageId("EXCEPTION_OCCURED");
						errorItem.setErrorMessage(e.getMessage());
						errorItems.add(errorItem);
						e.printStackTrace();
						validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					}
				}else if(pharmPrescriptionMode.equals("IVWA")){
					try{
						String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
						String bean_name_IVWA	= "ePH.IVPrescriptionBean";
						IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
						
						String drug_code = request.getParameter("DrugCode")==null?"":request.getParameter("DrugCode");
						String act_pat_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");
						String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
						String location_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");
						String location_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");
						String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");
						boolean duplicateExists = checkDuplicateItem(drug_code, patient_id, encounter_id, request);
						if(duplicateExists){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("DUPLICATE_ITEM");
							errorItem.setErrorMessage("Drug is already present in the cart");
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
						}else{
							ArrayList AllFluids = bean.getAllFluids();
							if(AllFluids!=null && AllFluids.size()>=6){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("ADDITIVE_ALREADY_SELECTED");
								errorItem.setErrorMessage("Maximum of six fluids only can be ordered");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}else{
								bean.setMFRRecs_fluids(new HashMap(),drug_code);
								bean.setFluidDetails(drug_code,act_pat_class,priority,location_code,take_home_medication);  
								bean.setMFRYN("N");	
								
								String IVWAmode;// as used in js function setVolumeDetails(mode, stock_value, stock_uom_code, stock_uom_desc,recno,fluid_adr_count, fluid_stock_uom_desc)
								String stock_value;
								String stock_uom_code;
								String stock_uom_desc;
								String recno;
								String fluid_stock_uom_desc;
								HashMap fluid_det =(HashMap)bean.getFluidDetails();
								if (bean.checkForStock()) {
									ArrayList stockDetails = bean.getStockDetails(drug_code, "1");
						            int fluid_adr_count = bean.getADRCount(patient_id,drug_code);  
						            fluid_det.put("STOCK_VALUE",stockDetails.get(0));
						            fluid_det.put("QTY_VALUE",stockDetails.get(0));
						            fluid_det.put("STOCK_UOM_DESC",bean.getUomDisplay(facility_id,(String)stockDetails.get(1)));
						            fluid_det.put("STOCK_UOM_CODE", stockDetails.get(1));
						            
								}
								String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"5":request.getParameter("iv_prep_yn");
								String dflt_disp_locn	= "";	
								ArrayList ord_disp_location=new ArrayList();
								if(iv_prep_yn.equals("5")){
									ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);
									//out.println("displayDispLocnDrugLevel('"+ord_disp_location.get(2)+"','"+ord_disp_location.get(0)+"','"+ord_disp_location.get(1)+"','"+ord_disp_location.get(3)+"','"+rec_no+"');");
									fluid_det.put("DISP_LOCN_DESC",ord_disp_location.get(2));
									fluid_det.put("DISP_LOCN_CODE",ord_disp_location.get(0));
									fluid_det.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
									
								}else{
									ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
									if(ord_disp_location != null & ord_disp_location.size()>0){
										dflt_disp_locn	= (String)ord_disp_location.get(2);
										fluid_det.put("DISP_LOCN_DESC",ord_disp_location.get(2));
										fluid_det.put("DISP_LOCN_CODE",ord_disp_location.get(0));
										fluid_det.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
									}
									//out.println("displayDispLocn('"+dflt_disp_locn+"');"); 
								}
								
								if(AllFluids!=null && AllFluids.size()>0){
									String trailingDate = (String)((HashMap)AllFluids.get(AllFluids.size()-1)).get("END_DATE");
									fluid_det.put("START_DATE",trailingDate);
								}else{
									fluid_det.put("START_DATE",bean.getSysdate());
								}
								fluid_det.put("DURN_VALUE","24");
								fluid_det.put("DURN_TYPE","H");
								
								String infuse_over_value="";
								String infuse_over_unit="";
								String infusion_period_value = "";
								String infusion_period_value_min = "";
								String infuse_over_unit_sch;
								String infusion_rate="";
								
								String infuse	=	bean.getInfuseOverValue(drug_code,"");
								StringTokenizer st = new StringTokenizer(infuse,"::");
								if(st.hasMoreTokens())
									infuse_over_value = st.nextToken();
								if(st.hasMoreTokens())
									infuse_over_unit = st.nextToken();
								
								if(infuse_over_unit.equals("M")){
									infuse_over_value = ""+Math.round(Math.ceil(Float.parseFloat(infuse_over_value)));
								}
								infusion_period_value = ""+Math.floor(Float.parseFloat(infuse_over_value));
								infusion_period_value_min = ""+(Math.ceil((((new Double(infuse_over_value))*60)%60))*10)/10;
								
								if(!infuse_over_value.equals("") && Float.parseFloat(infuse_over_value)>0){
									String volume=(String)fluid_det.get("PRES_QTY_VALUE");
									infusion_rate = ""+Math.round((Float.parseFloat(volume)/Float.parseFloat(infuse_over_value))*100.0)/100.0;
								}
								
								if(infuse_over_value.indexOf(".") != -1){
									infusion_period_value	 = infuse_over_value.substring(0,infuse_over_value.indexOf("."));
									Double Dtemp	 = new Double(infuse_over_value);
									Dtemp			 = Dtemp*60;
									Dtemp			 = (Dtemp%60);
									infusion_period_value_min	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
									if(infusion_period_value_min.indexOf(".") != -1)
										infusion_period_value_min = infusion_period_value_min.substring(0,infusion_period_value_min.indexOf(".")); // infuse_over_mi = xx
	
								}else{
									infusion_period_value	 = infuse_over_value;
									infusion_period_value_min	 = "";
								}
	
								infusion_period_value			= infusion_period_value.equals("")?"0":infusion_period_value;
								infusion_period_value_min			= infusion_period_value_min.equals("")?"0":infusion_period_value_min;
								
								
								fluid_det.put("INFUSE_OVER",infuse_over_value);//infusion_over_insert_value
								fluid_det.put("INFUSION_PERIOD_VALUE",infusion_period_value);
								fluid_det.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
								fluid_det.put("INFUSION_RATE",infusion_rate);
								fluid_det.put("INFUSE_OVER_UNIT",infuse_over_unit);
								
								String start_date = (String)fluid_det.get("START_DATE");
								String durn_value = (String)fluid_det.get("DURN_VALUE");
								String durn_unit = (String)fluid_det.get("DURN_TYPE");
								String end_date		= bean.populateEndDate(start_date, durn_value, durn_unit);
								fluid_det.put("END_DATE",end_date);
								//
								
								/*fluid_det.put("INFUSE_OVER",infuse);
								fluid_det.put("","");
								fluid_det.put("","");
								: "1",
								INFUSE_OVER_UNIT: "H",
								INFUSE_OVER_UNIT_SCH: "H",
								INFUSION_RATE: "1",*/
								
								
								if(AllFluids==null){
									AllFluids = new ArrayList();
									bean.setAllFluids(AllFluids);
								}else{
									AllFluids.add(fluid_det);
									bean.setAllFluids(AllFluids);
								}
							}
						}
						PersistenceHelper.putObjectInBean(bean_id_IVWA,bean,request);
					}
					catch(Exception e){
						PharmErrorItem errorItem = new PharmErrorItem();
						errorItem.setErrorMessageId("EXCEPTION_OCCURED");
						errorItem.setErrorMessage(e.getMessage());
						errorItems.add(errorItem);
						validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					}
				}
				else if(pharmPrescriptionMode.equals("PO")){
					String drugTypeCode = request.getParameter("drugTypeCode")==null?"":request.getParameter("drugTypeCode");

					/*ArrayList orders =  bean.getPrescriptions();
					
					orders.add((String)hash.get( "order_id") +","+(String)hash.get( "order_line"));
					orders.add((String)hash.get( "drug_code") );*/
					
				
					if(drugTypeCode.equals("Rx")){
						try{
							/* OrderEntryBean updation STARTS */
							String or_bean_name				= "eOR.OrderEntryBean";
							String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
							OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
							OrderEntryRecordBean orderEntryRecordBean = (OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
							String orderCatalogCode = request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");//strArray[0]
							String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");//empty str
							String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "PH":request.getParameter("OrderCatCode");//PH
							String check_box_value	= orbean.checkForNull(request.getParameter( "check_box_value" ),"") ; //CKDRUGCODE1,CKDRUGCODE2
							
							/* OrderEntryBean updation ENDS */
							
							/* PrescriptionBean_1 updation STARTS */
							/* Code taken from PrescriptionValidation_1.jsp --- chkDuplicateDrugCode*/
							String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
							String bean_name			= "ePH.PrescriptionBean_1";
							PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
							
							String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
							String presBean_name		= "ePH.PrescriptionBean";
							PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
							String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
							String param_bean_name				= "ePH.DrugInterfaceControlBean";
							
							
							
							DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
							String drug_code	= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode"); //strArray[0]
							String sys_date     = presBean.getSysdate();
							String drugCode	= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode"); //strArray[0]
							String tradeCodes	= request.getParameter("TradeCodes") == null ? "":request.getParameter("TradeCodes"); //strArray[10]
							String tradeNames	= request.getParameter("TradeNames") == null ? "":request.getParameter("TradeNames");//java.net.URLEncoder.encode(strArray[11],"UTF-8")
							String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
							String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");//Taken from PharmBasePage - take_home_medication
							String order_set_code=request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");//Taken from PharmBasePage - order_set_code
							String order_set_occur_num="";//TODO, for now send as empty string
							String drug_db_interface_yn = request.getParameter("drug_db_interface_yn") == null ? "":request.getParameter("drug_db_interface_yn");//Taken from PharmBasePage - drug_db_interface_yn
							String act_patient_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");// Taken from PharmBasePage --actual_patient_class
							String home_leave_yn_val = request.getParameter("home_leave_yn_val") == null ? "":request.getParameter("home_leave_yn_val");// Taken from PharmBasePage --home_leave_yn_val
							String heightStr = request.getParameter("height") == null ? "0":request.getParameter("height");// Taken from PharmBasePage --height
							String weightStr = request.getParameter("weight") == null ? "0":request.getParameter("weight");// Taken from PharmBasePage --weight
							String in_formulary = request.getParameter("in_formulary") == null ? "0":request.getParameter("in_formulary");//strArray[13]
							String drug_class = request.getParameter("drug_class") == null ? "0":request.getParameter("drug_class");//strArray[21]
							//String tradeCodesArr[] = tradeCodes.split(",");
							//String tradeNamesArr[] = tradeNames.split(",");
							String locn_type = "";
							String trade_code = request.getParameter("TradeCodes") == null ? "":request.getParameter("TradeCodes");
							String trade_name = request.getParameter("TradeNames") == null ? "":request.getParameter("TradeNames");
							String order_type_code = "";
					
							int trade_count=0;
							if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
								locn_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");// Taken from PharmBasePage --location_type
							else
								locn_type	= "P";
							String locn_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");// Taken from PharmBasePage --location_type
							boolean allow_add= true;
							HashMap chk	=	null;
							int srl_no	=bean.getSrlNo()+1;
							sys_date     = presBean.getSysdate();// added for IN23575 --01/09/2010-- priya
							if(!locale.equals("en"));
								sys_date  = DateUtils.convertDate(sys_date, "DMYHM",locale,"en");
							boolean duplicateExists = checkDuplicateItem(drug_code, patient_id, encounter_id, request);
							ArrayList presDetails = bean.getpresDetails();
							
							if(duplicateExists){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("DUPLICATE_ITEM");
								errorItem.setErrorMessage("Drug is already present in the cart");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}else{
								
								String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
								String selectedDrugCode = request.getParameter("DrugCode")==null?"":request.getParameter("DrugCode");
								String order_line ="1";
								ArrayList orders =  bean.getPrescriptions();
								
								orders.add(orderId +","+ order_line);
								orders.add(selectedDrugCode);
		
								orders 	=  bean.getPrescriptions();
								//System.out.println("orders"+orders);
								
								/*ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
								System.out.println("prescriptionDetails"+prescriptionDetails);
								if( ((String)((HashMap) prescriptionDetails.get(0)).get("DRUG_CODE")).equals((String)orders.get(0)) ) {
									System.out.println("found");
								}*/
								
								chk	=(HashMap)bean.loadDrugDetails(priority,take_home_medication,locn_type,locn_code,facility_id,selectedDrugCode.trim(),patient_class,patient_id,sys_date,String.valueOf(srl_no),order_set_code,order_set_occur_num, drug_db_interface_yn, trade_code, trade_name,act_patient_class,pract_id, resp_id,encounter_id,home_leave_yn_val);
								String wt_mand_yn= chk.get("WT_MAND_YN")== null?"":(String) chk.get("WT_MAND_YN");
								String ht_mand_yn= chk.get("HT_MAND_YN")== null?"":(String) chk.get("HT_MAND_YN");
								float height;
								float weight;
								try {
									height = Float.parseFloat(heightStr);
								}catch(NumberFormatException ex) {
									height = 0.0f;
								}
								try {
									weight = Float.parseFloat(weightStr);
								}catch(NumberFormatException ex) {
									weight = 0.0f;
								}
								
								if(wt_mand_yn.equals("Y") && ht_mand_yn.equals("Y")){
									if(height<=0 && weight<=0){
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("HEIGHTWEIGHT_MANDATORY");
										errorItem.setErrorMessage("Height and weight values are mandatory to proceed with this prescription");
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
									}
									else if(height<=0){
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("HEIGHT_MANDATORY");
										errorItem.setErrorMessage("Height value is mandatory to proceed with this prescription");
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
									}
									else if(weight<=0){
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("WEIGHT_MANDATORY");
										errorItem.setErrorMessage("Weight value is mandatory to proceed with this prescription");
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
									}
								}
								else if(wt_mand_yn.equals("Y")){
									if(weight<=0){
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("WEIGHT_MANDATORY");
										errorItem.setErrorMessage("Weight value is mandatory to proceed with this prescription");
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
									}
								}
								else if(ht_mand_yn.equals("Y")){
									if(height<=0){
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("HEIGHT_MANDATORY");
										errorItem.setErrorMessage("Height value is mandatory to proceed with this prescription");
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_WARNING);
									}
								}
								//Stock check
								String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
								String ph_bean_name 			= "ePH.DrugSearchBean";
								DrugSearchBean ph_drug_bean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;
								
								ArrayList stock_params	=	ph_drug_bean.validateForStock();
								if(stock_params.size() > 1) {
									String consider_stock					= (String)stock_params.get(0);
									String disp_charge_dtl_in_drug_lkp_yn	= (String)stock_params.get(2);
									String disp_price_type_in_drug_lkp		= (String)stock_params.get(3);
									String allow_yn	= (String)stock_params.get(1);
									if(in_formulary.equals("Y") && consider_stock.equals("Y")) {
										ArrayList stock_dtls = ph_drug_bean.checkStock(drug_code, trade_code, drug_class, order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
										String avl_qty = (String)stock_dtls.get(1);
										String strEnableDisable	=	(String)stock_dtls.get(3);
										if((allow_yn.equals("N") && (stock_dtls.size()==0 || avl_qty.equals(""))) || strEnableDisable.equals("disabled")) {
											PharmErrorItem errorItem = new PharmErrorItem();
											errorItem.setErrorMessageId("STOCK_UNAVAILABLE");
											errorItem.setErrorMessage("Selected drug not available in stock");
											errorItems.add(errorItem);
											validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
										} 
									}
								}
								
								
								//drug interaction check 
								
								String interaction_exists			= (String) chk.get("INTERACTION_EXISTS")==null?"N": (String) chk.get("INTERACTION_EXISTS"); //Added for	RUT-CRF-0066 IN[029604] -Start
								String intr_restric_trn			= (String) chk.get("INTR_RESTRIC_TRN")==null?"N": (String) chk.get("INTR_RESTRIC_TRN");
								StringBuffer intr_msg_content = new StringBuffer("");
								if(interaction_exists.equals("Y")){
									ArrayList hmDrugIntList = (ArrayList) chk.get("INTERACTION_DTL");
									HashMap DrugInteractionDtl =null;
									if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
										for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
											 DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
											String intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
											String intr_name = (String)DrugInteractionDtl.get("intr_name");
											String severity_level = (String)DrugInteractionDtl.get("severity_level");
											String significant_level = (String)DrugInteractionDtl.get("significant_level");
											String probability = (String)DrugInteractionDtl.get("probability");
											String restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
											String interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
											intr_msg_content.append(chk.get("DRUG_DESC"));
											intr_msg_content.append(" interacts with ");
											intr_msg_content.append(intr_name);
											intr_msg_content.append("<br />");
											intr_msg_content.append(interaction_desc+"<br />(Severity level - ");
											if(severity_level.equals("L"))
												intr_msg_content.append("Minor");
											if(severity_level.equals("M"))
												intr_msg_content.append("Moderate");
											if(severity_level.equals("H"))
												intr_msg_content.append("Major");
											intr_msg_content.append(") , (Significant Level "+significant_level+") , (Documentation - ");
											if(probability.equals("E")) // added for FD-RUT-CRF-0066.1 [IN036975] --begin
												intr_msg_content.append("Established");
											else if(probability.equals("P"))
												intr_msg_content.append("Probable");
											else if(probability.equals("S"))
												intr_msg_content.append("Suspected");
											else if(probability.equals("O"))
												intr_msg_content.append("Possible");
											else if(probability.equals("U"))
												intr_msg_content.append("Unlikely");
											intr_msg_content.append(") ");
										}
									}
									
									if(intr_restric_trn.equals("Y")){
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("DRUG_INTERACTION");									
										errorItem.setErrorMessage(intr_msg_content.toString());
										errorItem.setErrorDetails(DrugInteractionDtl);
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
									}else{
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("DRUG_INTERACTION");
										errorItem.setErrorMessage(intr_msg_content.toString());
										errorItem.setErrorDetails(DrugInteractionDtl);
										errorItems.add(errorItem);
										if(validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_ERROR && validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_WARNING)
											validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);
									}
									
									
								}
								
								//duplicate medications check
								boolean dup_found	=	false;
								String skip_duplicte_alert       = bean.getSkipDuplicateAlertIp_yn(); 
								String allow_duplicate				= (String) chk.get("ALLOW_DUPLICATE_DRUG");
								String allow_duplicate_op				= (String) chk.get("ALLOW_DUPLICATE_DRUG_OP");
								String drug_db_duptherapy_flag      = (String)chk.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)chk.get("DRUG_DB_DUPTHERAPY_FLAG");
								String generic_id = (String)chk.get("GENERIC_ID");
								String generic_name = (String)chk.get("GENERIC_NAME");
								String drug_desc = (String)chk.get("DRUG_DESC");
								String orig_current_rx = "";
								String dup_drug_info	=	""; 
								String previous_order_date = "";
								boolean skip_dup_flag = true;
								String current_rx					= (String) chk.get("CURRENT_RX")==null?"":(String) chk.get("CURRENT_RX");
								if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
									allow_duplicate = allow_duplicate_op;
									skip_duplicte_alert = bean.getSkipDuplicateAlertOp_yn(); // Added for MO-CRF-20085.1 [IN057392]
									//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_OP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
								}
								//String duplicate_check_at_atc_yn       = (String) chk.get("DUPLICATE_CHECK_AT_ATC_YN"); 
								if( chk.containsKey("ORIG_CURRENT_RX") && ((String)chk.get("ORIG_CURRENT_RX")).equals("Y") ) {
									orig_current_rx	=	(String)chk.get("ORIG_CURRENT_RX");
								}
								String start_date					= (String) chk.get("START_DATE");
								String end_date					= (String) chk.get("END_DATE");
								String freq_code					= (String) chk.get("FREQ_CODE")==null?"":(String) chk.get("FREQ_CODE");
								
								String overlap_period_for_op        =   bean.getOverlapPeriodForOP();//CRF-20085.1
								String overlap_period_for_ip        =   bean.getOverlapPeriodForIP();//CRF-20085.1
								String ph_drug_overlap_period = ""; 
								
								if(patient_class.equals("OP"))
									ph_drug_overlap_period = overlap_period_for_op;
							
								if (patient_class.equals("IP"))
									ph_drug_overlap_period = overlap_period_for_ip;
								int no_of_days = 0;
								if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){					
									previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);
									if(previous_order_date==null || previous_order_date.equals(""))
										previous_order_date = start_date;
									no_of_days= DateUtils.daysBetween(previous_order_date, start_date, "DMYHM", locale);
									if(!locale.equals("en"))
										previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
									if(no_of_days<=Integer.parseInt(ph_drug_overlap_period))
										skip_dup_flag = false;
									
								}
								
								String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
								String ext_prod_id			   = (String) chk.get("EXTERNAL_PRODUCT_ID")==null?"":(String) chk.get("EXTERNAL_PRODUCT_ID");
								if((!drug_db_interface_yn.equals("Y")) || drug_db_duptherapy_yn.equals("N") || (ext_prod_id.equals(""))){
									//if(current_rx.equals("Y")) {
										String atc_level_1		=	"";
										String atc_level_2		=	"";
										String atc_level_3		=	"";
										String atc_level_4		=	"";
										String atc_level_5		=	"";
										String generic_atc_name =   "";
										String provide_taper	=	"";
										String temp_generic_id	=	"";
										String temp_drug_code	=	"";
										String temp_drug_desc	=	"";
										String current_rx_tapered = "";
										String duplicate_check_at_atc_yn=""; //added for skr-scf-0143 IN 29184
										ArrayList atc_values	=  new ArrayList();
										ArrayList atc_dup_drug_code= null; // added for the incident no 27465
										HashMap drug_detail		=	null;
										if(presDetails!=null && presDetails.size()>0){
											for(int i=0;i<presDetails.size();i++){
												current_rx_tapered = "";
												drug_detail=(HashMap) presDetails.get(i);
												duplicate_check_at_atc_yn       = (String) drug_detail.get("DUPLICATE_CHECK_AT_ATC_YN");
												ext_prod_id			= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
												drug_db_duptherapy_flag		=  (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");
												//copied_drug_yn		=  (String)drug_detail.get("COPIED_DRUG_YN")==null?"":(String)drug_detail.get("COPIED_DRUG_YN");
												current_rx_tapered = drug_detail.get("CURRENT_RX")==null?"":(String)drug_detail.get("CURRENT_RX");// moved out from the below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -start
												//amend_yn			= drug_detail.get("AMEND_YN")==null?"":(String)drug_detail.get("AMEND_YN");
												if( current_rx_tapered.equals("Y") && !drug_detail.containsKey("ORIG_CURRENT_RX")) {
													drug_detail.put("ORIG_CURRENT_RX","Y");							
												}
												else if( !current_rx_tapered.equals("Y")){ //else if block added for Bru-HIMS-CRF-265 [IN:032315] // && !amend_yn.equals("Y") added for [IN:044495]
													drug_detail.put("ORIG_CURRENT_RX","N");		
												}
												if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){
													atc_level_1	    =	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
													atc_level_2	    =	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
													atc_level_3	    =	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
													atc_level_4	    =	(String)drug_detail.get("ATC_CLASS_LEV4_CODE");
													atc_level_5	    =	(String)drug_detail.get("ATC_CLASS_LEV5_CODE");
													generic_atc_name=  	(String)drug_detail.get("GENERIC_ATC_NAME");
													temp_generic_id	=	(String)drug_detail.get("GENERIC_ID");
													temp_drug_desc	=	(String)drug_detail.get("DRUG_DESC");
													temp_drug_code  =   (String)drug_detail.get("DRUG_CODE");
													temp_drug_desc=temp_drug_desc.replaceAll(" ","%20");
													temp_drug_desc = java.net.URLEncoder.encode(temp_drug_desc,"UTF-8");
													temp_drug_desc=temp_drug_desc.replaceAll("%2520","%20");
													if(drug_detail.get("TAPPERED_OVER")!=null)
														 provide_taper	= (String)drug_detail.get("TAPPERED_OVER");
													if( (!provide_taper.equals("Y")) && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") )  ) {
														atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE"); // added for the incident no 27465 - start
														if(atc_dup_drug_code == null)
															atc_dup_drug_code = new ArrayList();// added for the incident no 27465 - end	
														if(atc_values.contains(temp_generic_id)) {
															current_rx = "Y";
															drug_detail.put("CURRENT_RX","Y");
															atc_dup_drug_code.add(temp_drug_code);
															drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
															drug_detail.put("ALERT_YN","Generic :");
														}
														else if(atc_values.contains(atc_level_5)) {
															drug_detail.put("CURRENT_RX","Y");
															current_rx="Y";
															drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
															drug_detail.put("ALERT_YN","Level 4:");
															atc_dup_drug_code.add(temp_drug_code);
															drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
														}
														else if(atc_values.contains(atc_level_4)) {
															drug_detail.put("CURRENT_RX","Y");
															current_rx="Y";
														}
														else {
															atc_values.add(temp_drug_desc);
															atc_values.add(temp_drug_code);
															atc_values.add(temp_generic_id);
															if(!(generic_atc_name==null || generic_atc_name.equals(""))){
																atc_values.add(generic_atc_name);
															}
															if(!(atc_level_1==null || atc_level_1.equals(""))){
																atc_values.add(atc_level_1);
															}
															if(!(atc_level_2==null || atc_level_2.equals(""))){
																atc_values.add(atc_level_2);
															}
															if(!(atc_level_3==null || atc_level_3.equals(""))){
																atc_values.add(atc_level_3);
															}
															if(!(atc_level_4==null || atc_level_4.equals(""))){
																atc_values.add(atc_level_4);
															}
															if(!(atc_level_5==null || atc_level_5.equals(""))){
																atc_values.add(atc_level_5);
															}
														}
													}
												}
											}
										}
										duplicate_check_at_atc_yn       = (String) chk.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
										if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){
											atc_level_1	    =	(String)chk.get("ATC_CLASS_LEV1_CODE");
											atc_level_2	    =	(String)chk.get("ATC_CLASS_LEV2_CODE");
											atc_level_3	    =	(String)chk.get("ATC_CLASS_LEV3_CODE");
											atc_level_4	    =	(String)chk.get("ATC_CLASS_LEV4_CODE");
											atc_level_5	    =	(String)chk.get("ATC_CLASS_LEV5_CODE");
											generic_atc_name=  	(String)chk.get("GENERIC_ATC_NAME");
											if(chk.get("TAPPERED_OVER")!=null)
												 provide_taper	= (String)chk.get("TAPPERED_OVER");
											if( (!provide_taper.equals("Y")) && (chk.get("CURRENTRX_REMARKS")==null || ((String)chk.get("CURRENTRX_REMARKS")).equals("") )  ) {	
												atc_dup_drug_code = (ArrayList)chk.get("ATC_DUP_DRUG_CODE"); // added for the incident no 27465 - start
												if(atc_dup_drug_code == null)
													atc_dup_drug_code = new ArrayList();// added for the incident no 27465 - end	
												if(atc_values.contains(generic_id)) {
													current_rx = "Y";
													chk.put("CURRENT_RX","Y");
													if(skip_dup_flag){
														dup_found = true;
														if(!atc_dup_drug_code.contains(drug_code))//Added to avoid duplicate drugcode on atc list for TTM-SCF-0073[IN046928]
															atc_dup_drug_code.add(drug_code);// added for the incident no 27465
														chk.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
													}
												}
												else if(atc_values.contains(atc_level_5)){
													chk.put("CURRENT_RX","Y");
													current_rx="Y";
													if(skip_dup_flag){ 
														dup_found = true;
														atc_dup_drug_code.add(drug_code);
														chk.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
													}
												}
												else if(atc_values.contains(atc_level_4)){
													drug_detail.put("CURRENT_RX","Y");
													current_rx="Y";
													if(skip_dup_flag){
														dup_found = true;
														atc_dup_drug_code.add(drug_code);
														chk.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
													}
												}
											}	
										}
									//}
								}
								
								
								
								if(orig_current_rx.equals("Y")  || drug_db_duptherapy_flag.equals("Y") || current_rx.equals("Y")) { 
									dup_found	=	true;
									ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
									HashMap  dup_info		=	null;
									/*if(curr_info!=null && curr_info.size()>=1) {
										dup_info	  =	(HashMap)curr_info.get(0);
										dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+". ";
										dup_drug_info = dup_drug_info+" Prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
									}else{
										dup_drug_info = "Patient is currently on "+generic_name+" Medication";
									}*/
									dup_drug_info = drug_desc + " duplicates with generic  "+generic_name + ". ";
								}
								if(dup_found){
									/*if(allow_duplicate.equals("N")){
										PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("DUPLICATE_DRUG");
										errorItem.setErrorMessage(dup_drug_info);
										errorItems.add(errorItem);
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
									}else{*/
										/*PharmErrorItem errorItem = new PharmErrorItem();
										errorItem.setErrorMessageId("DUPLICATE_DRUG");
										errorItem.setErrorMessage(dup_drug_info);
										errorItems.add(errorItem);
										if(validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_ERROR)
											validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);*/
									//}
									if(allow_duplicate.equals("N")){
										chk.put("PRIORITY","U");
										chk.put("FREQ_CODE", "STAT");
										chk.put("FREQ_DESC", "STAT");
										chk.put("DURN_VALUE", "1");
										chk.put("freq_chng_durn_desc", "D");
										chk.put("DURN_DESC", "Day(s)");
										dup_drug_info = dup_drug_info + "Only STAT dose can be prescribed";
										//chk.put("CURRENTRX_OVERRIDE", "N");
									}
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("DUPLICATE_DRUG");
									errorItem.setErrorMessage(dup_drug_info);
									errorItems.add(errorItem);
									if(validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_ERROR && validationResponse.getValidationResult() != PharmValidationResponse.VALIDATION_WARNING)
										validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);
								}
								
								
							
								
								/*boolean skip_dup_flag = true;
								String overlap_period_for_op        =   bean.getOverlapPeriodForOP();//CRF-20085.1
								String overlap_period_for_ip        =   bean.getOverlapPeriodForIP();//CRF-20085.1
								String ph_drug_overlap_period = ""; 
								String previous_order_date              =   "";
								String skip_duplicte_alert              =   "";
								String allow_duplicate				= (String) chk.get("ALLOW_DUPLICATE_DRUG");
								String allow_duplicate_op				= (String) chk.get("ALLOW_DUPLICATE_DRUG_OP");
								String start_date					= (String) chk.get("START_DATE");
								String end_date					= (String) chk.get("END_DATE");
								String generic_id					= (String) chk.get("GENERIC_ID");
								String freq_code					= (String) chk.get("FREQ_CODE")==null?"":(String) chk.get("FREQ_CODE");
								String current_rx					=(String) chk.get("CURRENT_RX")==null?"":(String) chk.get("CURRENT_RX");
								String drug_db_duptherapy_flag      = (String)chk.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)chk.get("DRUG_DB_DUPTHERAPY_FLAG");
								if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
									allow_duplicate = allow_duplicate_op;
									skip_duplicte_alert = bean.getSkipDuplicateAlertOp_yn(); // Added for MO-CRF-20085.1 [IN057392]
									//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_OP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
								}
								if(patient_class.equals("OP"))
									ph_drug_overlap_period = overlap_period_for_op;
							
								if (patient_class.equals("IP"))
									ph_drug_overlap_period = overlap_period_for_ip;
								int no_of_days = 0;
								if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){					
									previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);
									if(previous_order_date==null || previous_order_date.equals(""))
										previous_order_date = start_date;
									no_of_days= DateUtils.daysBetween(previous_order_date, start_date, "DMYHM", locale);
									if(!locale.equals("en"))
										previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
									if(no_of_days<=Integer.parseInt(ph_drug_overlap_period))
										skip_dup_flag = false;
									
								}*/
								
								/*if(skip_dup_flag){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("DUPLICATE_ORDERS");
									errorItem.setErrorMessage(intr_msg_content.toString());
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
								}*/
								if(validationResponse.getValidationResult() == PharmValidationResponse.VALIDATION_SUCCESS){
									
									
									
									//OrderEntryBean and PrescriptionBean_1 updation starts
									orbean.setCatalogCodes(check_box_value);
									String key				= (orbean.getPatientId()+orbean.getEncounterId());
									HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
									if(previousValues == null){
										previousValues = new HashMap();
									}
									previousValues.put("ck"+orderCatalogCode, "Y");
									previousValues.put("h1"+orderCatalogCode,orderCategoryCode);
									previousValues.put("h2"+orderCatalogCode,orderTypeCode);
									orderEntryRecordBean.setCheckedEntries(key, previousValues);
									bean.addDrugDetails(999,chk);
									bean.setSrlNo(srl_no);
									//OrderEntryBean updation ends
									
									//populateEndDate
									String freq_nature			= (String) chk.get( "FREQ_NATURE" )==null?"":(String) chk.get("FREQ_NATURE");
									start_date			= (String) chk.get( "START_DATE" )==null?"":(String) chk.get("START_DATE");
									String durn_value			= (String) chk.get( "DURN_VALUE" )==null?"":(String) chk.get("DURN_VALUE");
									String repeat_durn_type		= (String) chk.get( "REPEAT_DURN_TYPE" )==null?"":(String) chk.get("REPEAT_DURN_TYPE");
									end_date=(String)bean.populateEndDate(freq_nature,start_date,durn_value,repeat_durn_type);
									chk.put("END_DATE", end_date);
									
									//validateDosageLimit
									String qty_value	= (String) chk.get( "QTY_VALUE" )==null?"":(String) chk.get("QTY_VALUE");
									String repeat_value	= (String) chk.get( "REPEAT_VALUE" )==null?"":(String) chk.get("REPEAT_VALUE");
									String dosage_type  = (String) chk.get( "DOSAGE_TYPE" )==null?"":(String) chk.get("DOSAGE_TYPE");
									String calc_def_dosage_yn		= (String) chk.get("CALC_DEF_DOSAGE_YN")==null?"":(String) chk.get("CALC_DEF_DOSAGE_YN");
									ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
									if(freq_nature.equals("P") || freq_nature.equals("O")){
										chk.put("LIMIT_IND","Y");
										chk.put("DOSE_REMARKS","");
									}
									if(schedule.size() > 0){
										 /*HashMap detail	=	(HashMap)schedule.get(0);
										 qty_value		=	(String)detail.get("admin_qty");*/
										 ArrayList dose_list		= (ArrayList)schedule.get(4);
										 if(dose_list!=null && dose_list.size()>0)
											 qty_value		=	(String)dose_list.get(0);
										else
											 qty_value="1";
									}
									
									if(calc_def_dosage_yn.equals("Y")){
										HashMap dosageDetails= (HashMap) presBean.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value);
										String limit_ind= (String) dosageDetails.get("LIMIT_IND")==null?"":(String) chk.get("LIMIT_IND");
										if(limit_ind != null && limit_ind.equals("N")){
											String daily_dose = (String) dosageDetails.get("DAILY_DOSE")==null?"":(String) chk.get("DAILY_DOSE");
											String unit_dose = (String) dosageDetails.get("UNIT_DOSE")==null?"":(String) chk.get("UNIT_DOSE");
											String mono_graph = (String) dosageDetails.get("MONO_GRAPH")==null?"":(String) chk.get("MONO_GRAPH");
											String min_daily_dose= (String) dosageDetails.get("MIN_DAILY_DOSE")==null?"":(String) chk.get("MIN_DAILY_DOSE");
											String min_unit_dose= (String) dosageDetails.get("MIN_UNIT_DOSE")==null?"":(String) chk.get("MIN_UNIT_DOSE");
											String dose_unit= (String) dosageDetails.get("DOSAGE_UNIT")==null?"":(String) chk.get("DOSAGE_UNIT");
											chk.put("LIMIT_IND",limit_ind);
											chk.put("DAILY_DOSE",daily_dose);
											chk.put("UNIT_DOSE", unit_dose);
											chk.put("MONO_GRAPH", mono_graph);
											chk.put("MIN_DAILY_DOSE", min_daily_dose);
											chk.put("MIN_UNIT_DOSE", min_unit_dose);
											chk.put("DOSAGE_UNIT",(String) dosageDetails.get("DOSAGE_UNIT"));
										}
									}
									String qty_desc_code = chk.get("QTY_DESC_CODE")==null?"":(String)chk.get("QTY_DESC_CODE");
									String interval_value = chk.get("INTERVAL_VALUE")==null?"":(String)chk.get("INTERVAL_VALUE");
									String episode_type= patientContext.getPatientClass();
									if(episode_type !=null && (!episode_type.equals("")))
										episode_type = episode_type.substring(0,1);
									if(episode_type !=null && episode_type.equals("X"))
										episode_type = "R";
									String order_Date = bean.getOrderDate();
									String bl_overriden_action_reason = ""; //empty since we dont allow override in EM Mobile
									bean.setBillingDetail(chk,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,"", bl_overriden_action_reason, "ASSIGN_OVERRIDE",take_home_medication);//,pat_brought_medn
									
								}
							}
							/* PrescriptionBean_1 updation ENDS */
							PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
							PersistenceHelper.putObjectInBean(bean_id,bean,request);
						}
						catch(Exception e){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("EXCEPTION_OCCURED");
							errorItem.setErrorMessage(e.getMessage());
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
						}
					}else if(drugTypeCode.equals("IVD")){
						
						//System.out.println("inside IV with additives") po;
						try{
							/*drug details begins here*/
							String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
							String bean_name_IVD	= "ePH.IVPrescriptionBean";
							IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
							
							String or_bean_name				= "eOR.OrderEntryBean";
							String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
							OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
							
							String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
							String bean_name			= "ePH.PrescriptionBean_1";
							PrescriptionBean_1 Pres_bean= (PrescriptionBean_1)PersistenceHelper.getBeanObject( bean_id,bean_name,request);	
							
							
							String order_id = request.getParameter("orderId")==null?"":request.getParameter("orderId");
							String drug_code	= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");
							String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");
							String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");
							String location_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");
							String location_type= request.getParameter("location_type") == null ? "":request.getParameter("location_type");
							String answer = "Y";
							String start_date_time = "";
							ArrayList exstngIVorder = new ArrayList();
							HashMap record = null; 
							StringBuffer drugCodes = new StringBuffer();
							String act_pat_class = "IP";
                              ArrayList drugLists			= bean.getDrugDetails();
							
							if(drugLists.size()>0){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("ADDITIVE_ALREADY_SELECTED");
								errorItem.setErrorMessage("Only one IV can be Selected");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
								
							}else{
								
								exstngIVorder = (ArrayList)bean.getExistingIVRecords(order_id,"N",act_pat_class);
								boolean existingOrd_duplicateExists = false;
								for(int i=1;i<exstngIVorder.size();i++){
									record = (HashMap)exstngIVorder.get(i);
									String drugCode_indv = (String)record.get("ORDER_CATALOG_CODE");
									existingOrd_duplicateExists = checkDuplicateItem(drugCode_indv, patient_id, encounter_id, request);
									if(existingOrd_duplicateExists){
										break;
									}
								}
								
								if(existingOrd_duplicateExists){
									PharmErrorItem errorItem = new PharmErrorItem();
									errorItem.setErrorMessageId("DUPLICATE_ITEM");
									errorItem.setErrorMessage("Drug is already present in the cart");
									errorItems.add(errorItem);
									validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
								}else{
									
									for(int i=1;i<exstngIVorder.size();i++){
										record = new HashMap();
										record = (HashMap)exstngIVorder.get(i);
										drugCodes.append(record.get("ORDER_CATALOG_CODE"));
										drugCodes.append(",");
										start_date_time = (String)record.get("START_DATE_TIME");
									}
		
									bean.setPatId(patient_id);
									bean.setSTART_DATE_TIME(start_date_time);
									bean.setDrugDetails(drugCodes.toString(),"","","","","","");
									bean.setAllExistingIVOrders(exstngIVorder);
									
									String startDts		="";
									String endDts			="";
									ArrayList drugDetails = bean.getDrugDetails();
									String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"5":request.getParameter("iv_prep_yn");
									HashMap drugDetail= new HashMap();
									for(int c=0;c<drugDetails.size();c++){
										 drugDetail = (HashMap)drugDetails.get(c);
										 
										 
										 
										 
										 
										 
										 
										drugDetail.put("ORDER_TYPE","Previous");
										HashMap 	records = (HashMap)exstngIVorder.get(c);
										String recd_drun_details = (String)records.get("DURN_VALUE");
										drugDetail.put("DURN_VALUE",recd_drun_details);
										ArrayList ord_disp_location=new ArrayList();
										if(iv_prep_yn.equals("5")){
											ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);
		
											drugDetail.put("DISP_LOCN_DESC",ord_disp_location.get(2));
											drugDetail.put("DISP_LOCN_CODE",ord_disp_location.get(0));
											drugDetail.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
		
											
										}else{
											ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
											if(ord_disp_location != null & ord_disp_location.size()>0){
												String dflt_disp_locn	= (String)ord_disp_location.get(2);
												drugDetail.put("DISP_LOCN_DESC",ord_disp_location.get(2));
												drugDetail.put("DISP_LOCN_CODE",ord_disp_location.get(0));
												drugDetail.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
											}
		
										}
										 startDts		= (String)drugDetail.get("START_DATE");
										 endDts			= (String)drugDetail.get("END_DATE");
										
										
										
									}
									/*drug details ends here*/
									
									/*fluid details begin here*/
									
									ArrayList exstngIVOrders	= new ArrayList();
							  		HashMap   record_fluid			= new HashMap();
							  		String MAR_app_yn = "";
							  		String mfr_display = "";
									exstngIVOrders		= bean.getAllExistingIVOrders();
									record_fluid				= (HashMap)exstngIVOrders.get(0);
									String CATALOG_DESC		= (String)record_fluid.get("CATALOG_DESC");
									String ORDER_CATALOG_CODE	= (String)record_fluid.get("ORDER_CATALOG_CODE");
									String mfr_remarks			= (String)record_fluid.get("MFR_REMARKS");
									String fluid_code			= ORDER_CATALOG_CODE;
									String test = (String)record_fluid.get("SCH_INFUSION_RATE");
									//System.out.println("test"+record_fluid);
									bean.setFluidDetails(ORDER_CATALOG_CODE,"","","",""); // CRF-0062 NEWLY ADDED
									if (bean.checkForStock()) {
										ArrayList stockDetails = bean.getStockDetails(ORDER_CATALOG_CODE, "1");
										if (stockDetails.size() != 0){
											String stock_value    = (String)stockDetails.get(0);
											String stock_uom_code = (String)stockDetails.get(1);
											
											String base_volume    = stock_value;
										}
									}
									String stock_value     = (String)record_fluid.get("QTY_VALUE");
									
									
									String order_type_code	= bean.getOrderType(ORDER_CATALOG_CODE);
									bean.setPatientClass(patient_class);
									
									bean.setQTY_VALUE(stock_value);
									
									bean.setPatId(patient_id);
									bean.setEncId(encounter_id);
									
									HashMap drug_det= new HashMap();
									
									for(int i=1;i<exstngIVOrders.size();i++){
										bean.setPatientClass(patient_class);
										record_fluid					= (HashMap)exstngIVOrders.get(i);
										drug_det = (HashMap)exstngIVOrders.get(i-1);
									//	System.out.println("record fluid"+record_fluid);
										//  HashMap fluid_det =(HashMap)bean.getFluidDetails();
										//record_fluid.put("START_DATE",startDts);
										//record_fluid.put("END_DATE",endDts);
										String ends= (String)record_fluid.get("END_DATE_TIME");
										String renewOrderStartDate=bean.comp_date_time(ends,order_id,i+"");
										String start_date_fluid = renewOrderStartDate;
										String end_date_fluid	=  bean.populateEndDate(start_date_fluid,"24","H");
										
										//drug info:
										
										String qty_vals_drug= (String) record_fluid.get("QTY_VALUE");
										//String qty_vals_drug= (String) record_fluid.get("QTY_VALUE");
										String qty_UOM_drug= (String) record_fluid.get("DOSAGE_UOM_CODE");
										
										
									String qty_vals= (String) drug_det.get("QTY_VALUE");
										
									
									String qty_unit= (String) drug_det.get("QTY_UNIT");	
									
									String infuse_over= (String) drug_det.get("INFUSE_OVER");
									
									String durn_vals= (String) drug_det.get("DURN_VALUE");	
									
									String infusion_rate= (String) drug_det.get("INFUSION_RATE");	
									//SCH_INFUSION_RATE
									
									
									
								//	INFUSE_OVER=24, DURN_VALUE=45,
								
								//PRES_QTY_VALUE
										
										record_fluid.put("START_DATE",start_date_fluid);
										record_fluid.put("END_DATE",end_date_fluid);
										
										
										ORDER_CATALOG_CODE		= (String)record_fluid.get("ORDER_CATALOG_CODE");
										bean.setDrugDetails(ORDER_CATALOG_CODE,orbean.getPractitionerId(),orbean.getResponsibilityId(),"","","","");  //CRF-0062 // Added getPractitionerId and getResponsibilityId for ML-MMOH-CRF-0343 [IN:057182]
										bean.setIVPB("N");
										HashMap 	records = (HashMap)exstngIVorder.get(i);
										String recd_drun_details = (String)records.get("DURN_VALUE");
										drugDetail = (HashMap)drugDetails.get(i-1);
										drugDetail.put("DURN_VALUE",recd_drun_details);
										
										
										drugDetail.put("QTY_VALUE",qty_vals_drug);
										drugDetail.put("QTY_UNIT",qty_unit);
										drugDetail.put("INFUSE_OVER",infuse_over);
										drugDetail.put("DURN_VALUE",durn_vals);
										drugDetail.put("PRES_QTY_VALUE",qty_vals_drug);
										drugDetail.put("QTY_DESC",qty_UOM_drug);
										drugDetail.put("SCH_INFUSION_RATE",infusion_rate);
										
										String	qty_uom = Pres_bean.getUomDisplay(facility_id,qty_unit);
										
										
										HashMap fulid_dtls=(HashMap)bean.getFluidDetails();
										fulid_dtls.put("DURN_VALUE",recd_drun_details);
										fulid_dtls.put("QTY_VALUE",qty_vals);
										fulid_dtls.put("QTY_UNIT",qty_unit);
										fulid_dtls.put("INFUSE_OVER",infuse_over);
										fulid_dtls.put("INFUSE_OVER",infuse_over);
										fulid_dtls.put("SCH_INFUSION_RATE",infusion_rate);
										
										
										//drugDetail.put("DURN_VALUE",durn_vals);
										fulid_dtls.put("PRES_QTY_VALUE",qty_vals);
										fulid_dtls.put("PRES_BASE_UOM_DESC",qty_unit);
										
										bean.setVOLUME(qty_vals);
									}
									
									
									
										 
									if(record_fluid.get("BUILD_MAR_YN")==null){
										record_fluid.put("BUILD_MAR_YN",MAR_app_yn);
									}
									String buildMAR_yn		= (String) record_fluid.get("BUILD_MAR_YN");
									bean.setBuildMAR_yn(buildMAR_yn);
									/*fluid details ends here*/
									
									/*admin details begin here*/
									
									ArrayList exstngIVOrders_admin	= new ArrayList();
									HashMap   record_admin			= new HashMap();
									exstngIVOrders_admin = bean.getAllExistingIVOrders();
									record_admin = (HashMap)exstngIVOrders_admin.get(0);
									
									
									String iv_calc_infuse_by=bean.getIVCalcInfuseBy(); 
									String infuse_over_mi = "";
									String infuse_over_hr = "";
									String duration = "";
									String start_time = (String)record_admin.get("START_DATE_TIME");
									String end_time = (String)record_admin.get("END_DATE_TIME");
									String order_line_num = (String)record_admin.get("ORDER_LINE_NUM");
									String srlNo = "0";
									
									String startDt		= (String)record_admin.get("START_DATE_TIME");
									String endDt			= (String)record_admin.get("END_DATE_TIME");
									
									//  HashMap fluid_det =(HashMap)bean.getFluidDetails();
									record_admin.put("START_DATE",startDt);
									record_admin.put("END_DATE",endDt);
							          
		
									String INFUSE_OVER2=	(String)record_admin.get("SCH_INFUSION_RATE")==null?"":(String)record_admin.get("SCH_INFUSION_RATE");		
									String infuse_over1=(String)record_admin.get("INFUSE_OVER")==null?"":(String)record_admin.get("INFUSE_OVER");
									String INFUSION_RATE = (String)record_admin.get("INFUSION_RATE")==null?"":(String)record_admin.get("INFUSION_RATE");
									String INFUSE_OVER_UNIT = (String)record_admin.get("INF_PERIOD_UNIT")==null?"":(String)record_admin.get("INF_PERIOD_UNIT");
									
									String infusion_period_value="";
									String infusion_period_value_min ="";
		
									if(infuse_over1.indexOf(".") != -1){
										infusion_period_value	 = infuse_over1.substring(0,infuse_over1.indexOf("."));
										Double Dtemp	 = new Double(infuse_over1);
										Dtemp			 = Dtemp*60;
										Dtemp			 = (Dtemp%60);
										infusion_period_value_min	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
										if(infusion_period_value_min.indexOf(".") != -1)
											infusion_period_value_min = infusion_period_value_min.substring(0,infusion_period_value_min.indexOf(".")); // infuse_over_mi = xx
		
									}else{
										infusion_period_value	 = infuse_over1;
										infusion_period_value_min	 = "0";
									}
									//System.out.println("values---------->>>"+infuse_over1+infusion_period_value+infusion_period_value_min);
									record_admin.put("INFUSE_OVER",infuse_over1);//infusion_over_insert_value
									record_admin.put("INFUSION_PERIOD_VALUE",infusion_period_value);
									record_admin.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
									
									
									HashMap fulid_dtls=(HashMap)bean.getFluidDetails();
									fulid_dtls.put("INFUSE_OVER",infuse_over1);
									fulid_dtls.put("INFUSION_PERIOD_VALUE",infusion_period_value);
									fulid_dtls.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
									fulid_dtls.put("INFUSION_RATE",infuse_over1);
									fulid_dtls.put("INFUSE_OVER_UNIT",INFUSE_OVER_UNIT);
									fulid_dtls.put("DURN_UNIT",INFUSE_OVER_UNIT);
									//fulid_dtls.put("SCH_INFUSION_RATE",infuse_over1);
									fulid_dtls.put("START_DATE",startDts);
									fulid_dtls.put("END_DATE",endDts);
									
									for(int c=0;c<drugDetails.size();c++){
										 drugDetail = (HashMap)drugDetails.get(c);
										 
										 
											
										 record_fluid					= (HashMap)exstngIVOrders.get(c+1);
										 String ends= (String)record_fluid.get("END_DATE_TIME");
										 String renewOrderStartDate=bean.comp_date_time(ends,order_id,c+"");
										 String start_date_fluid = renewOrderStartDate;
										 String end_date_fluid	=  bean.populateEndDate(start_date_fluid,"24","H");
											
										 drugDetail.put("START_DATE",start_date_fluid);
										 drugDetail.put("END_DATE",end_date_fluid);
										 
										 fulid_dtls.put("START_DATE",start_date_fluid);
										 fulid_dtls.put("END_DATE",end_date_fluid);
											
									
									}
									
									/*String mfr_yn = (String)record_admin.get("MFR_YN")==null?"":(String)record_admin.get("MFR_YN");
									if(!mfr_yn.equals("Y")){
										String infusion_rate = (String)record_admin.get("INFUSION_RATE");
										String infuse_over = (String)record_admin.get("INFUSE_OVER");
										bean.setInfRate(srlNo, infusion_rate);
										bean.setINFUSE_OVER(infuse_over);
										if(iv_calc_infuse_by.equals("I"))
											duration = "24"; 
										else
											duration = (String)record_admin.get("DURN_VALUE");
										bean.setDURN_VALUE(duration);
										String QTY_UNIT  = (String)record_admin.get("QTY_UNIT")==null?"":(String)record_admin.get("QTY_UNIT");
										bean.setQTY_UNIT(QTY_UNIT);
										String infusion_period_uom	=(String)record_admin.get("INF_PERIOD_UNIT")==null?"H":(String)record_admin.get("INF_PERIOD_UNIT");
									}
									else{
										if(iv_calc_infuse_by.equals("I"))
											duration="24";
										else
											duration = (String)((HashMap)bean.getMFRRecs()).get("totDurnHrs");
										bean.setDURN_VALUE(duration);
									}*/
									/*admin details ends here*/
									
								}
								PersistenceHelper.putObjectInBean(bean_id_IVD,bean,request);
							}
						}
						catch(Exception e){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("EXCEPTION_OCCURED");
							errorItem.setErrorMessage(e.getMessage());
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							e.printStackTrace();
						}
						
					}else if(drugTypeCode.equals("IVWA")){
						
						String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
						String bean_name_IVWA	= "ePH.IVPrescriptionBean";
						IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
						
                        String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
                        String act_pat_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");
						String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
						String location_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");
						String location_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");
						String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");

						ArrayList AllFluids = bean.getAllFluids();
						
						if(AllFluids!=null && AllFluids.size()>=6){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("ADDITIVE_ALREADY_SELECTED");
							errorItem.setErrorMessage("Maximum of six fluids only can be ordered");
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
						}else{
							ArrayList exstngIVorder = 	bean.getExistingIVRecords(orderId, "N", act_pat_class);
							
							boolean existingOrd_duplicateExists = false;
							for(int i=1;i<exstngIVorder.size();i++){
								HashMap	record = (HashMap)exstngIVorder.get(i);
								String drugCode_indv = (String)record.get("ORDER_CATALOG_CODE");
								existingOrd_duplicateExists = checkDuplicateItem(drugCode_indv, patient_id, encounter_id, request);
								if(existingOrd_duplicateExists){
									break;
								}
							}
							
							if(existingOrd_duplicateExists){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("DUPLICATE_ITEM");
								errorItem.setErrorMessage("Drug is already present in the cart");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}else{
							
							
							
							
							
							if(exstngIVorder !=null && exstngIVorder.size()!=0){
							HashMap	extDrugFulidInfo		=	(HashMap)exstngIVorder.get(0);
							String fulid_code=(String)extDrugFulidInfo.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugFulidInfo.get("ORDER_CATALOG_CODE");
							boolean duplicateExists = checkDuplicateItem(fulid_code, patient_id, encounter_id, request);
							if(duplicateExists){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("DUPLICATE_ITEM");
								errorItem.setErrorMessage("Drug is already present in the cart");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}else{
								
								bean.setFluidDetails(fulid_code,act_pat_class,priority,location_code,take_home_medication);  
								HashMap fluid_det =(HashMap)bean.getFluidDetails();
								String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"5":request.getParameter("iv_prep_yn");
								String dflt_disp_locn	= "";	
								ArrayList ord_disp_location=new ArrayList();
								if(iv_prep_yn.equals("5")){
									ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,fulid_code,patient_id,encounter_id);
									//out.println("displayDispLocnDrugLevel('"+ord_disp_location.get(2)+"','"+ord_disp_location.get(0)+"','"+ord_disp_location.get(1)+"','"+ord_disp_location.get(3)+"','"+rec_no+"');");
									fluid_det.put("DISP_LOCN_DESC",ord_disp_location.get(2));
									fluid_det.put("DISP_LOCN_CODE",ord_disp_location.get(0));
									fluid_det.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
								}else{
									ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
									if(ord_disp_location != null & ord_disp_location.size()>0){
										dflt_disp_locn	= (String)ord_disp_location.get(2);
										fluid_det.put("DISP_LOCN_DESC",ord_disp_location.get(2));
										fluid_det.put("DISP_LOCN_CODE",ord_disp_location.get(0));
										fluid_det.put("DISP_LOCN_TYPE",ord_disp_location.get(1));
									}
									//out.println("displayDispLocn('"+dflt_disp_locn+"');"); 
								}
								
								String  durn_value_exis = (String)extDrugFulidInfo.get("DURN_VALUE")==null?"":(String)extDrugFulidInfo.get("DURN_VALUE");
								fluid_det.put("DURN_VALUE", durn_value_exis);
								String infusion_rate_exis = (String)extDrugFulidInfo.get("INFUSION_RATE")==null?"":(String)extDrugFulidInfo.get("INFUSION_RATE");
								fluid_det.put("INFUSION_RATE", infusion_rate_exis);
								String qty_value_exis = (String)extDrugFulidInfo.get("QTY_VALUE")==null?"":(String)extDrugFulidInfo.get("QTY_VALUE");
								fluid_det.put("QTY_VALUE", qty_value_exis);
								String infuse_over_exis = (String)extDrugFulidInfo.get("INFUSE_OVER")==null?"":(String)extDrugFulidInfo.get("INFUSE_OVER");
								fluid_det.put("INFUSE_OVER", infuse_over_exis);
								String mfr_remarks_exis = (String)extDrugFulidInfo.get("MFR_REMARKS")==null?"":(String)extDrugFulidInfo.get("MFR_REMARKS");
								fluid_det.put("MFR_REMARKS", mfr_remarks_exis);
								String pres_base_uom_desc_exis = (String)extDrugFulidInfo.get("PRES_BASE_UOM")==null?"":(String)extDrugFulidInfo.get("PRES_BASE_UOM");
								if(pres_base_uom_desc_exis!=null && !pres_base_uom_desc_exis.equals(""))
									pres_base_uom_desc_exis = bean.getUomDisplay(facility_id,pres_base_uom_desc_exis);
								fluid_det.put("PRES_BASE_UOM_DESC", pres_base_uom_desc_exis);
								String infusion_per_unit_exis =(String)extDrugFulidInfo.get("INFUSION_PER_UNIT")==null?"":(String)extDrugFulidInfo.get("INFUSION_PER_UNIT");
								fluid_det.put("INFUSE_OVER_UNIT_SCH", infusion_per_unit_exis);
								String build_mar_rule_exis= (String)extDrugFulidInfo.get("BUILD_MAR_RULE")==null?"":(String)extDrugFulidInfo.get("BUILD_MAR_RULE");
								fluid_det.put("BUILD_MAR_RULE", build_mar_rule_exis);
								String disp_locn_desc_exis =(String)extDrugFulidInfo.get("DISP_LOCN_DESC")==null?"":(String)extDrugFulidInfo.get("DISP_LOCN_DESC");
								fluid_det.put("DISP_LOCN_DESC", disp_locn_desc_exis);
								String durn_type_exis =(String)extDrugFulidInfo.get("DURN_TYPE")==null?"":(String)extDrugFulidInfo.get("DURN_TYPE");
								fluid_det.put("DURN_TYPE", durn_type_exis);
								if(AllFluids!=null && AllFluids.size()>0){
									String trailingDate = (String)((HashMap)AllFluids.get(AllFluids.size()-1)).get("END_DATE");
									fluid_det.put("START_DATE",trailingDate);
								}else{
									fluid_det.put("START_DATE",bean.getSysdate());
								}
								String start_date = (String)fluid_det.get("START_DATE");
								String end_date		= bean.populateEndDate(start_date, durn_value_exis, durn_type_exis);
								fluid_det.put("END_DATE",end_date);

								
								
								String ends= (String)extDrugFulidInfo.get("END_DATE_TIME");
								 String renewOrderStartDate=bean.comp_date_time(ends,orderId,"1");
								 String start_date_fluid = renewOrderStartDate;
								 String end_date_fluid	=  bean.populateEndDate(start_date_fluid,durn_value_exis,durn_type_exis);
									
								 fluid_det.put("START_DATE",start_date_fluid);
								 fluid_det.put("END_DATE",end_date_fluid);
								 
								 
								 
								String infusion_period_value="";
								String infusion_period_value_min ="";
								if(infuse_over_exis.indexOf(".") != -1){
									infusion_period_value	 = infuse_over_exis.substring(0,infuse_over_exis.indexOf("."));
									Double Dtemp	 = new Double(infuse_over_exis);
									Dtemp			 = Dtemp*60;
									Dtemp			 = (Dtemp%60);
									infusion_period_value_min	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
									if(infusion_period_value_min.indexOf(".") != -1)
										infusion_period_value_min = infusion_period_value_min.substring(0,infusion_period_value_min.indexOf(".")); // infuse_over_mi = xx
	
								}else{
									infusion_period_value	 = infuse_over_exis;
									infusion_period_value_min	 = "";
								} 
								   fluid_det.put("INFUSION_PERIOD_VALUE",infusion_period_value);  
								   fluid_det.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);  
								if(AllFluids==null){
									AllFluids = new ArrayList();
									bean.setAllFluids(AllFluids);
								}else{
									AllFluids.add(fluid_det);
									bean.setAllFluids(AllFluids);
								}
								
							}
							}else{
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("EXCEPTION_OCCURED");
								errorItem.setErrorMessage("Could not add this drug to the cart");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}
						
						}	
						}
						
					}else if(drugTypeCode.equals("IVPB")){
						Hashtable schedule_val	=	new Hashtable();
						ArrayList schedule		=	null;
						Hashtable sch_output	=	null;
						//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
						IVPiggyBackBean bean_pig = (IVPiggyBackBean)PersistenceHelper.getBeanObject("@IVPiggyBackBean"+patient_id+encounter_id, "ePH.IVPiggyBackBean", request);
						String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
						String bean_name_IVPB	= "ePH.IVPrescriptionBean";
						IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
						String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
						 String act_pat_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");
						ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(orderId, "N", act_pat_class);//TODO -- change patient_class hardcoded
						ArrayList drugList			= iv_bean.getDrugDetails();
						String trade_code = request.getParameter("TradeCodes") == null ? "":request.getParameter("TradeCodes");
						//String act_pat_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");// Taken from PharmBasePage --actual_patient_class
						String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
						String location_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");// Taken from PharmBasePage --location_type
						String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");//Taken from PharmBasePage - take_home_medication
						String location_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");
						String iv_prep_yn	= request.getParameter("iv_prep_yn") == null ? "3":request.getParameter("iv_prep_yn");
					
						
						if(drugList.size()>0){
							PharmErrorItem errorItem = new PharmErrorItem();
							errorItem.setErrorMessageId("ADDITIVE_ALREADY_SELECTED");
							errorItem.setErrorMessage("Only one additive can be selected in IV Intermittent");
							errorItems.add(errorItem);
							validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
						}else{
							HashMap extDrugList =new HashMap();
							HashMap extDrugListInfo =new HashMap();
							int siz			=	exstngIVorder.size();
							String lengt=siz+"";
							if(lengt.equals("1")){
								extDrugListInfo		=	(HashMap)exstngIVorder.get(0);
								extDrugList		=	(HashMap)exstngIVorder.get(0);
							}
							else{
								extDrugListInfo		=	(HashMap)exstngIVorder.get(0);
								extDrugList		=	(HashMap)exstngIVorder.get(1);
							}
							//setting drug info
							String drug_codes=	(String)extDrugList.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugList.get("ORDER_CATALOG_CODE");	
							boolean duplicateExists = checkDuplicateItem(drug_codes, patient_id, encounter_id, request);
							if(duplicateExists){
								PharmErrorItem errorItem = new PharmErrorItem();
								errorItem.setErrorMessageId("DUPLICATE_ITEM");
								errorItem.setErrorMessage("Drug is already present in the cart");
								errorItems.add(errorItem);
								validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
							}else{
								iv_bean.setDrugDetails(drug_codes,pract_id,resp_id,"","","","");  //CRF-0062 //added getPractitionerId and getResponsibilityId for ML-MMOH-CRF-0343 [IN:057182]
								//setting fulid info
								String fluid_codes=	(String)extDrugListInfo.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugListInfo.get("ORDER_CATALOG_CODE");	
								iv_bean.setFluidDetails(fluid_codes,"","","",""); 
								String 	INFUSION_RATE=	(String)extDrugList.get("INFUSION_RATE");
								String vehicle_new=	(String)extDrugListInfo.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugListInfo.get("ORDER_CATALOG_CODE");	
								String freq_code_exis=	(String)extDrugList.get("FREQ_CODE")==null?"":(String)extDrugList.get("FREQ_CODE");	
								String start_date_time_exis = (String)extDrugList.get("START_DATE_TIME")==null?"":(String)extDrugList.get("START_DATE_TIME");
								String durn_value_exis=  (String)extDrugList.get("DURN_VALUE")==null?"":(String)extDrugList.get("DURN_VALUE");
								String durn_type_exis=  (String)extDrugList.get("DURN_TYPE")==null?"":(String)extDrugList.get("DURN_TYPE");
								String dose_type_exis = (String)extDrugList.get("DOSAGE_TYPE")==null?"":(String)extDrugList.get("DOSAGE_TYPE");
								String qty_value_exis=  (String)extDrugList.get("QTY_VALUE")==null?"":(String)extDrugList.get("QTY_VALUE");
								String strength_value_exis = (String)extDrugList.get("STRENGTH_VALUE")==null?"":(String)extDrugList.get("STRENGTH_VALUE");
								//String qty_value_exis= (String)extDrugList.get("QTY_VALUE")==null?"":(String)extDrugList.get("QTY_VALUE");
								String qty_value_vol_exis=(String)extDrugListInfo.get("QTY_VALUE")==null?"":(String)extDrugListInfo.get("QTY_VALUE");
								String pres_base_uom_exis = (String)extDrugList.get("PRES_BASE_UOM")==null?"":(String)extDrugList.get("PRES_BASE_UOM");
								String pre_order_uom_exis=(String)extDrugListInfo.get("ORDER_UOM")==null?"":(String)extDrugListInfo.get("ORDER_UOM");
								ArrayList drugAllList= iv_bean.getDrugDetails();
								HashMap drugMap			= (HashMap)drugAllList.get(0);	
								String dosage_type_exis = (String)extDrugList.get("DOSAGE_TYPE")==null?"":(String)extDrugList.get("DOSAGE_TYPE");
							String fulids_qty_values=  (String)extDrugListInfo.get("QTY_VALUE")==null?"":(String)extDrugListInfo.get("QTY_VALUE");
								if(dosage_type_exis.equalsIgnoreCase("Q")){
									drugMap.put("STRENGTH_VALUE", strength_value_exis);
									drugMap.put("QTY_VALUE",qty_value_exis );
									drugMap.put("PRES_QTY_VALUE",qty_value_exis);	
								}else if(dosage_type_exis.equalsIgnoreCase("S")){
									drugMap.put("STRENGTH_VALUE", qty_value_exis);
									drugMap.put("QTY_VALUE", strength_value_exis);
									drugMap.put("PRES_QTY_VALUE",qty_value_exis);	
								}
								drugMap.put("CALC_DOSE_VALUE", strength_value_exis);
								drugMap.put("PRES_BASE_UOM", pres_base_uom_exis);
								drugMap.put("vehicle",vehicle_new);
								drugMap.put("SCH_INFUSION_RATE", INFUSION_RATE);
								drugMap.put("FREQ_CODE", freq_code_exis);
								drugMap.put("DURN_VALUE", durn_value_exis);
								drugMap.put("DURN_TYPE", durn_type_exis);
								iv_bean.setVOLUME(qty_value_vol_exis);
								drugMap.put("DOSAGE_TYPE", dose_type_exis);
								drugMap.put("DURN_TYPE", durn_type_exis);
								
								
							//	String infusion_over = bean_IVPB.getINFUSE_OVER();
							//String INFUSION_PERIOD_VALUE = (String)FluidDetails.get("INFUSION_PERIOD_VALUE");					
							//	String INFUSION_PERIOD_VALUE_MIN = (String)FluidDetails.get("INFUSION_PERIOD_VALUE_MIN");	
								
								
								
								String ends= (String)extDrugListInfo.get("END_DATE_TIME");
								 String renewOrderStartDate=iv_bean.comp_date_time(ends,orderId,"1");
								 String start_date_fluid = renewOrderStartDate;
								 String end_date_fluid	=  iv_bean.populateEndDate(start_date_fluid,durn_value_exis,durn_type_exis);
									
								 drugMap.put("START_DATE",start_date_fluid);
								 drugMap.put("END_DATE",end_date_fluid);
								 
								 
								
								ArrayList ord_disp_locations=new ArrayList();
								if(iv_prep_yn.equals("5")){
									ord_disp_locations  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_codes,patient_id,encounter_id);
		
									drugMap.put("DISP_LOCN_DESC",ord_disp_locations.get(2));
									drugMap.put("DISP_LOCN_CODE",ord_disp_locations.get(0));
									drugMap.put("DISP_LOCN_TYPE",ord_disp_locations.get(1));
		
									
								}else{
									ord_disp_locations  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
									if(ord_disp_locations != null & ord_disp_locations.size()>0){
										String dflt_disp_locns	= (String)ord_disp_locations.get(2);
										drugMap.put("DISP_LOCN_DESC",ord_disp_locations.get(2));
										drugMap.put("DISP_LOCN_CODE",ord_disp_locations.get(0));
										drugMap.put("DISP_LOCN_TYPE",ord_disp_locations.get(1));
									}
		
								}
								String INFUSE_OVER2=	(String)drugMap.get("SCH_INFUSION_RATE")==null?"":(String)drugMap.get("SCH_INFUSION_RATE");		
								String infuse_over1=(String)extDrugList.get("INFUSE_OVER")==null?"":(String)extDrugList.get("INFUSE_OVER");
								String infusion_period_value="";
								String infusion_period_value_min ="";
								if(infuse_over1.indexOf(".") != -1){
									infusion_period_value	 = infuse_over1.substring(0,infuse_over1.indexOf("."));
									Double Dtemp	 = new Double(infuse_over1);
									Dtemp			 = Dtemp*60;
									Dtemp			 = (Dtemp%60);
									infusion_period_value_min	 = Math.round(Dtemp)+""; // infuse_over_mi = xx.0
									if(infusion_period_value_min.indexOf(".") != -1)
										infusion_period_value_min = infusion_period_value_min.substring(0,infusion_period_value_min.indexOf(".")); // infuse_over_mi = xx
								
								}else{
									infusion_period_value	 = infuse_over1;
									infusion_period_value_min	 = "0";
								}
								drugMap.put("INFUSE_OVER",infuse_over1);//infusion_over_insert_value
								drugMap.put("INFUSION_PERIOD_VALUE",infusion_period_value);
								drugMap.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
								HashMap fulid_dtls=(HashMap)iv_bean.getFluidDetails();
								fulid_dtls.put("INFUSION_PERIOD_VALUE",infusion_period_value);
								fulid_dtls.put("INFUSION_PERIOD_VALUE_MIN",infusion_period_value_min);
								fulid_dtls.put("QTY_VALUE",qty_value_vol_exis);
								fulid_dtls.put("PRES_BASE_UOM_DESC",pre_order_uom_exis);
								
								/*
								String fluid_drug_desc = (String)FluidDetails.get("DRUG_DESC");
				            	String fluid_qty_uom_desc = (String)FluidDetails.get("PRES_BASE_UOM_DESC");
				          		String fluid_qty_uom = (String)FluidDetails.get("QTY_UOM");
				          		String fluid_qty_value = (String)FluidDetails.get("QTY_VALUE");
				          		String fluid_tradeName = (String)FluidDetails.get("TRADE_NAME")==null?"":(String)FluidDetails.get("TRADE_NAME");
								String infusion_over = bean_IVPB.getINFUSE_OVER();
								String INFUSION_PERIOD_VALUE = (String)FluidDetails.get("INFUSION_PERIOD_VALUE");					
								String INFUSION_PERIOD_VALUE_MIN = (String)FluidDetails.get("INFUSION_PERIOD_VALUE_MIN");					
								String 	inf_over_displaystr = INFUSION_PERIOD_VALUE+" Hrs "+INFUSION_PERIOD_VALUE_MIN+" Mins";	
								*/
								
								ArrayList	schedules	=	(ArrayList)iv_bean.getScheduleFrequencyStr(drug_codes,"0");
								if(schedules.size()==0) {
									String sch_bean_id		= "OrScheduleFreq" ;
									String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
									ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)PersistenceHelper.getBeanObject( sch_bean_id,sch_bean_name ,request);
									schedule_bean.setLanguageId(locale);
									sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
									schedule_val.put("facility_id", facility_id);
									schedule_val.put("start_time_day_param", start_date_time_exis);
									schedule_val.put("module_id", "PH"); 
									schedule_val.put("split_dose_yn", "N"); 
									schedule_val.put("split_qty",qty_value_exis);
									schedule_val.put("freq_code",  freq_code_exis );
									schedule_val.put("code",drug_codes);
								    sch_output.put("code",drug_codes);
									sch_output.put("row_value","1");
									sch_output.put("start_date_time",start_date_time_exis);
									iv_bean.setScheduleFrequencyStr(sch_output);
								} 
							}
						}
					}
				}
			}else if(mode.equals("REMOVE_ITEM_RX")){
				try{
					String or_bean_name				= "eOR.OrderEntryBean";
					String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
					OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
					eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
					String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
					String bean_name			= "ePH.PrescriptionBean_1";
					PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
					String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
					String param_bean_name				= "ePH.DrugInterfaceControlBean";
					DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
					String search_bean_id	="@DrugSearchBean"+patient_id+encounter_id;
					String search_bean_name	="ePH.DrugSearchBean";
					DrugSearchBean searchbean = (DrugSearchBean)PersistenceHelper.getBeanObject( search_bean_id, search_bean_name , request) ;
					String drugCode		= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");
					String srlNo="";
					String generic_id="";
					String order_set_code = request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");
					ArrayList addprescriptionDetails	=	(ArrayList)bean.getpresDetails();
					String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);  
					
					for(int j=0;j<addprescriptionDetails.size();j++){
						HashMap drugData      =  (HashMap) addprescriptionDetails.get(j);
						if(((String)drugData.get("DRUG_CODE")).equals(drugCode)){
							srlNo = drugData.get("SRL_NO")==null?"": (String) drugData.get("SRL_NO");
							generic_id = drugData.get("GENERIC_ID")==null?"": (String) drugData.get("GENERIC_ID");
						}
					}
					if(!srlNo.equals("")){
					String key				= patient_id+encounter_id;
					HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
					previousValues.remove("ck"+drugCode);
					previousValues.remove("h1"+drugCode);
					previousValues.remove("h2"+drugCode);
					orderEntryRecordBean.setCheckedEntries(key, previousValues);
					
					int sno= 0;//Added for RUT-SCF-0320[IN044815]
					if(srlNo!=null && srlNo.trim().length()>0)//Added for RUT-SCF-0320[IN044815]
						sno  = Integer.parseInt(srlNo);//Added for RUT-SCF-0320[IN044815]
					//String patient_id	= (String)hash.get("patient_id");
					//String encounter_id	= (String)hash.get("encounter_id");
					//String called_from	= (String)hash.get("called_from")==null?"":(String)hash.get("called_from"); DEL
					
					drugCode = drugCode.trim();
					srlNo = srlNo.trim();
					int drug_index	=	-1;
					String temp_freq_nature="";
					int remove_pos	=	0;
					ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
					int codeCount_1=0;
					int codeCount_2=0;
					HashMap ext_drugData	=	null;
					String ext_drug_code	=	null;
					String ext_srl_no		=	null;
					String ext_prod_id = "";
					String curr_yn    = "";
					String st_date_local="";
					String end_date_local="";
					String severity_level="";
					ArrayList alDrugIntrDtlList = null;
					ArrayList atc_dup_drug_code = new ArrayList();
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData      =  (HashMap) prescriptionDetails.get(j);
						curr_yn			  = "";
						// ext_drugData.put("CURRENT_RX",curr_yn);
						// ext_drugData.put("ATC_LEVEL_DUPLICATION","N");
						if(ext_drugData.containsKey("ATC_DUP_DRUG_CODE")){
							atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_DUP_DRUG_CODE");
							if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(drugCode)){
								atc_dup_drug_code.remove(drugCode);
							}
							if(ext_drugData.get("GENERIC_ID").equals(generic_id))//Added to clear atc drugcode on same generic id for TTM-SCF-0073[IN046928]
								atc_dup_drug_code.clear();
							
							//ext_drugData.put("CURRENT_RX",curr_yn);
							// commented aboveline and added in if condition below for the incident no.SRR20056-SCF-7745 [Incident No. 28045] and added braces for ifcondition.
							if(!(atc_dup_drug_code.size()>0)) {
								ext_drugData.put("CURRENT_RX",curr_yn);
								ext_drugData.put("ATC_LEVEL_DUPLICATION","N");
								ext_drugData.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
								//ext_drugData.put("ATC_DUP_DRUG_CODE",null);
								ext_drugData.put("CURRENTRX_REMARKS","");
								if(ext_drugData.containsKey("ALERT_YN"))
									ext_drugData.remove("ALERT_YN");
							}
						}
						if(ext_drugData.containsKey("ATC_LEVEL4_DUP_DRUG_CODE")){
							atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_LEVEL4_DUP_DRUG_CODE");
							if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(drugCode)){
								atc_dup_drug_code.remove(drugCode);
							}
							//ext_drugData.put("CURRENT_RX",curr_yn);
							// commented aboveline and added in if condition below for the incident no.SRR20056-SCF-7745 [Incident No. 28045] and added braces for ifcondition.
							if(!(atc_dup_drug_code.size()>0))	{
								ext_drugData.put("CURRENT_RX",curr_yn);
								ext_drugData.put("ATC_LEVEL4_DUPLICATION","N");
								ext_drugData.put("ATC_LEVEL4_DUP_DRUG_CODE",atc_dup_drug_code);
								ext_drugData.put("CURRENTRX_REMARKS","");
								if(ext_drugData.containsKey("ALERT_YN"))
									ext_drugData.remove("ALERT_YN");
							}
						}
					}
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData=(HashMap) prescriptionDetails.get(j);
						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no=(String) ext_drugData.get("SRL_NO");
						temp_freq_nature = ext_drugData.get("FREQ_NATURE")==null?"": (String) ext_drugData.get("FREQ_NATURE");
						if( !(temp_freq_nature.equals("P") || temp_freq_nature.equals("O"))){
							if(drugCode.equals(ext_drug_code)){
								codeCount_1++;
							}
							if(drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no))
								drug_index = j;
						}
					}
					if(codeCount_1>1){
						for(int k=drug_index; k<prescriptionDetails.size();k++){
							ext_drugData=(HashMap) prescriptionDetails.get(k);
							ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
							if(drugCode.equals(ext_drug_code)){
								codeCount_2++;
							}
						}
					}
					for(int h=0;h<prescriptionDetails.size();h++){
						ext_drugData=(HashMap) prescriptionDetails.get(h);
						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no=(String) ext_drugData.get("SRL_NO");
						if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no)){
							remove_pos=h;
							break;
						}
					}
					if(codeCount_1>1 && codeCount_2>1 && order_set_code.equals("")){
						//out.println("alertParentRecord('delete')") ;
						//Will never come here.. since in EM Mobility we're not dealing with order sets
					}
					else{
						prescriptionDetails.remove((remove_pos));
						//searchbean.removeDrugCode(drugCode);
						//searchbean.removeSelectedDrug(drugCode);
						bean.getclearscheduleFrequency(drugCode);
						bean.removePRNRemarks(drugCode);//Added for SKR-SCF-0647[Inc:35263]
						bean.clearCopiedDrugs(drugCode);
						if(prescriptionDetails.size()>0 && remove_pos>0){
							ext_drugData=(HashMap) prescriptionDetails.get(remove_pos-1);
							if(drugCode.equals((String)ext_drugData.get("DRUG_CODE")))
								ext_drugData.put("DRUG_TAPERED_YN","N");
						}
						if(codeCount_1>0 && prescriptionDetails.size()>0){//Modified for RUT-SCF-0320[IN044815]
							HashMap prev_extdrugData=null;
							srlNo = (String)ext_drugData.get("SRL_NO");
							drugCode = (String)ext_drugData.get("DRUG_CODE");
							String tapered_over = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
							if(tapered_over.equals("Y")){
								float tap_lvl_qty = 0;   //Added for RUT-CRF-0088 [IN036978]
								String Ccalled_from				= "ONCANCEL";
								float Cqty_value			= Float.parseFloat(ext_drugData.get("qty_value")==null?"1":(String) ext_drugData.get("qty_value"));
								float Crepeat_value			= Float.parseFloat( ext_drugData.get("repeat_value")==null?"1":(String) ext_drugData.get("repeat_value"));
								float Cdurn_value			= Float.parseFloat(ext_drugData.get("durn_value")==null?"1":(String) ext_drugData.get("durn_value"));
								float Cinterval_value			= Float.parseFloat( ext_drugData.get("interval_value")==null?"1":(String) ext_drugData.get("interval_value"));
								float totTapperQty = bean.getTotalTaperQty(drugCode, srlNo,Ccalled_from,Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);     //Commented and Added for RUT-CRF-0088 [IN036978]
								float prevTotTapperQty = bean.getTotalTaperQty(drugCode, srlNo,"PREVTOTQTY",Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
								tap_lvl_qty=bean.getTotalTaperQty(drugCode, srlNo,Ccalled_from,Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
								//tapQtyValues= bean.getTotalTaperQty(drugCode, srlNo,"PREVTOTQTY",Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
								String tempsno = null;//Added for RUT-SCF-0320[IN044815]
								for(int j=0;j<prescriptionDetails.size();j++){
									prev_extdrugData =  (HashMap) addprescriptionDetails.get(j);
									ext_drug_code=(String) prev_extdrugData.get("DRUG_CODE");
									ext_srl_no=(String) prev_extdrugData.get("SRL_NO");
									tempsno = String.valueOf(sno);//Added for RUT-SCF-0320[IN044815]--start
									if(sno < Integer.parseInt(ext_srl_no)){
										prev_extdrugData.put("SRL_NO",tempsno);
										sno = sno+1;
									}//Added for RUT-SCF-0320[IN044815]--end
									if(prev_extdrugData!=null){
										if(drugCode.equals(ext_drug_code) ){
											if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))){
												if(!srlNo.equals(ext_srl_no))
													prev_extdrugData.put("DRUG_TAPERED_YN","Y");
												prev_extdrugData.put("TOTTAPPERQTY",totTapperQty+"");    //Commented for RUT-CRF-0088 [IN036978]
												prev_extdrugData.put("PREVTOTALTAPERQTY",prevTotTapperQty+"");
											}
										}
									}
								}
							}
							else{
								ext_drugData.remove("DRUG_TAPERED_YN");
								ext_drugData.remove("TAP_LVL_QTY");
								ext_drugData.remove("TOTTAPPERQTY");
								ext_drugData.remove("PREVTOTALTAPERQTY");   //Commented for RUT-CRF-0088 [IN036978]
							}
						}
						//Added for	RUT-CRF-0066 IN[029604] - start
						String inrteraction_exists="",  restrict_transaction="N"; 
						for(int h=0;h<prescriptionDetails.size();h++){
							ext_drugData=(HashMap) prescriptionDetails.get(h);
							if(ext_drugData!=null){
								ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
								ext_srl_no=(String) ext_drugData.get("SRL_NO");
								ext_prod_id=  (String) ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");
								if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
									inrteraction_exists=(String) ext_drugData.get("INTERACTION_EXISTS")==null?"":(String) ext_drugData.get("INTERACTION_EXISTS");
									if(inrteraction_exists.equals("Y")){
										ext_drugData.put("INTERACTION_EXISTS", "N" );
										//ext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
										ext_drugData.put("INTR_MSG_CONTENT","");
										ext_drugData.put("INTR_RESTRIC_TRN","N");
										st_date_local = (String)ext_drugData.get("START_DATE");
										end_date_local =  (String)ext_drugData.get("END_DATE");
										if(!locale.equals("en")){
											st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
											end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
										}
										alDrugIntrDtlList = bean.getDrugInteractionDtls(ext_drug_code,  (String) ext_drugData.get("FORM_CODE"), (String) ext_drugData.get("GENERIC_ID"), st_date_local, end_date_local, patient_id);
										if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
											severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) ;
											restrict_transaction= (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
											ext_drugData.put("SEVERITY_LEVEL", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) );
											ext_drugData.put("INTR_RESTRIC_TRN", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1) );
											ext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
											ext_drugData.put("INTERACTION_EXISTS", "Y" );
											if(restrict_transaction.equals("Y") || severity_level.equals("H")){
												ext_drugData.put("INTR_ALERT", "Y" );
											}
											/*for(int intr=0; intr<(alDrugIntrDtlList.size()-1); intr++){
												hmDrugInteractionDtl = (HashMap) alDrugIntrDtlList.get(intr);
												if(((String)hmDrugInteractionDtl.get("restrict_transaction")).equals("Y"))
													intr_msg_content += (String)hmDrugInteractionDtl.get("intr_name")+"["+(String)hmDrugInteractionDtl.get("severity_level")+"], ";
											}
											if(intr_msg_content.length()>0)
												intr_msg_content = intr_msg_content.substring(0, intr_msg_content.length()-2);
											ext_drugData.put("INTR_MSG_CONTENT", intr_msg_content );*/
										}
									}
								}
							}
						}
						//Added for	RUT-CRF-0066 IN[029604] - end
					}
					}
					PersistenceHelper.putObjectInBean(search_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
					PersistenceHelper.putObjectInBean(bean_id,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					e.printStackTrace();
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
				}
				
			}else if(mode.equals("REMOVE_ALL_RX")){

				try{
					String or_bean_name				= "eOR.OrderEntryBean";
					String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
					OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
					eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
					String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
					String bean_name			= "ePH.PrescriptionBean_1";
					PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
					String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
					String param_bean_name				= "ePH.DrugInterfaceControlBean";
					DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
					
					String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
					String ph_bean_name 			= "ePH.DrugSearchBean";
					DrugSearchBean searchbean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;
					String drugCode;
					String srlNo;
					String generic_id;
					String order_set_code  = request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");
					ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
					String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);  
					
					String key				= patient_id+encounter_id;
					HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
					
					for(int k =0;k<prescriptionDetails.size();k++){
						HashMap ordItem = (HashMap)prescriptionDetails.get(k);
						drugCode = (String)ordItem.get("DRUG_CODE");
						previousValues.remove("ck"+drugCode);
						previousValues.remove("h1"+drugCode);
						previousValues.remove("h2"+drugCode);
						
						prescriptionDetails.remove(k);
						//searchbean.removeDrugCode(drugCode);
						//searchbean.removeSelectedDrug(drugCode);
						bean.getclearscheduleFrequency(drugCode);
						bean.removePRNRemarks(drugCode);
						bean.clearCopiedDrugs(drugCode);
						
					}
					prescriptionDetails.clear();
					orderEntryRecordBean.setCheckedEntries(key, previousValues);
					
					
					PersistenceHelper.putObjectInBean(ph_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
					PersistenceHelper.putObjectInBean(bean_id,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
				
			
				
			}
			else if(mode.equals("REMOVE_DRUG_IVD")){
				try{
					String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVD	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
					
					String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
					String search_bean_name		= "ePH.DrugSearchBean";
					DrugSearchBean searchbean	= (DrugSearchBean)PersistenceHelper.getBeanObject(search_bean_id,search_bean_name,request);
					
					String or_bean_name				= "eOR.OrderEntryBean";
					String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
					OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
					
					String drug_code		= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");
					ArrayList drugList		   = (ArrayList)bean.getDrugDetails();
					int srl_no = 0;
					String srlNo;
					String generic_id;
					for(int j=0;j<drugList.size();j++){
						HashMap drugData      =  (HashMap) drugList.get(j);
						if(((String)drugData.get("DRUG_CODE")).equals(drug_code)){
							srlNo = drugData.get("SRL_NO")==null?"": (String) drugData.get("SRL_NO");
							srl_no = j+1;
							generic_id = drugData.get("GENERIC_ID")==null?"": (String) drugData.get("GENERIC_ID");
						}
					}
					
					if(!drug_code.equals("") && srl_no>0){
						//searchbean.removeDrugCode(drug_code);
						bean.removeDrugFromList(srl_no-1, drug_code);
						drugList.remove(srl_no-1);
						int drug_count=0;
						HashMap drugDetails = null;
						String drugCodes="";
	
						for(int i=0;i<drugList.size();i++){
							drugDetails = (HashMap)drugList.get(i);
							if (drugDetails.size() != 0){
								drugCodes += (String)drugDetails.get("DRUG_CODE")+",";
								drug_count++;
							}
						}
						if(drug_count>0){
							int fluid_adr_count=0;
							ArrayList dfltFluidDetails = null;
							if(drug_count==1)
								dfltFluidDetails = bean.getCompFluidDetails(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
							else if (drug_count>1){
								dfltFluidDetails = bean.getCompFluidDetailsForMultipeDrugs(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
							}
							if(dfltFluidDetails != null && dfltFluidDetails.size()>0){
								String dfltFluidCode ="";
								for(int j=0; j<dfltFluidDetails.size();j+=7 ){
									fluid_adr_count = bean.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
									if(((String)dfltFluidDetails.get(j+3)).equals("Y"))
										dfltFluidCode = (String)dfltFluidDetails.get(j);
								}
								if(dfltFluidCode.equals(""))
									dfltFluidCode = (String)dfltFluidDetails.get(0);
				//commented during PE  By Naveen
								//String orderType	= bean.getOrderType(dfltFluidCode);
								bean.setFluidDetails(dfltFluidCode,"","","",""); // CRF-0062 NEWLY ADDED
	
								HashMap fluid_det =(HashMap)bean.getFluidDetails();
						        String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
								String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
								String fluid_stock_uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
								fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
								fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
								fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
								if (bean.checkForStock()) {
									ArrayList stockDetails = bean.getStockDetails(dfltFluidCode, "1");
									/*if (stockDetails.size() != 0)
										out.println("setStockDetails(3, '"+ stockDetails.get(0) + "', '" + stockDetails.get(1) + "', '" +bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "','"+fluid_stock_uom_desc+"');") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
									else
										out.println("setStockDetails(2);") ;*/
								}
								String infuse	=	bean.getInfuseOverValue(dfltFluidCode,"");
							}
						}else{
							HashMap fluid_det =(HashMap)bean.getFluidDetails();
							fluid_det.clear();		
						}
					}

					PersistenceHelper.putObjectInBean(search_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(bean_id_IVD,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
			}
			else if(mode.equals("REMOVE_DRUG_CRX")){
				
				try{
					String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_CRX	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);
					
					String drug_code		= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");
					
					ArrayList drugList		   = (ArrayList)bean_CRX.getDrugDetails();
					int srl_no = 0;
					String srlNo;
					String generic_id;
					for(int j=0;j<drugList.size();j++){
						HashMap drugData      =  (HashMap) drugList.get(j);
						if(((String)drugData.get("DRUG_CODE")).equals(drug_code)){
							srlNo = drugData.get("SRL_NO")==null?"": (String) drugData.get("SRL_NO");
							srl_no = j+1;
							generic_id = drugData.get("GENERIC_ID")==null?"": (String) drugData.get("GENERIC_ID");
						}
					}
					
					if(!drug_code.equals("") && srl_no>0){
						//searchbean.removeDrugCode(drug_code);
						bean_CRX.removeDrugFromList(srl_no-1, drug_code);
						drugList.remove(srl_no-1);
						int drug_count=0;
						HashMap drugDetails = null;
						String drugCodes="";
	
						for(int i=0;i<drugList.size();i++){
							drugDetails = (HashMap)drugList.get(i);
							if (drugDetails.size() != 0){
								drugCodes += (String)drugDetails.get("DRUG_CODE")+",";
								drug_count++;
							}
						}
						if(drug_count>0){
							int fluid_adr_count=0;
							ArrayList dfltFluidDetails = null;
							if(drug_count==1)
								dfltFluidDetails = bean_CRX.getCompFluidDetails(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
							else if (drug_count>1){
								dfltFluidDetails = bean_CRX.getCompFluidDetailsForMultipeDrugs(drugCodes.substring(0,drugCodes.length()-1),pract_id,resp_id);
							}
							if(dfltFluidDetails != null && dfltFluidDetails.size()>0){
								String dfltFluidCode ="";
								for(int j=0; j<dfltFluidDetails.size();j+=7 ){
									fluid_adr_count = bean_CRX.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
									if(((String)dfltFluidDetails.get(j+3)).equals("Y"))
										dfltFluidCode = (String)dfltFluidDetails.get(j);
								}
								if(dfltFluidCode.equals(""))
									dfltFluidCode = (String)dfltFluidDetails.get(0);
				
								bean_CRX.setFluidDetails(dfltFluidCode,"","","",""); // CRF-0062 NEWLY ADDED
	
								HashMap fluid_det =(HashMap)bean_CRX.getFluidDetails();
						        String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
								String  fluid_stock_uom					= (String) fluid_det.get("FLUID_STOCK_UOM");
								String fluid_stock_uom_desc = bean_CRX.getUomDisplay((String)session.getValue("facility_id"),fluid_stock_uom);
								fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll(" ","%20");
								fluid_stock_uom_desc = java.net.URLEncoder.encode(fluid_stock_uom_desc,"UTF-8");
								fluid_stock_uom_desc=fluid_stock_uom_desc.replaceAll("%2520","%20");
								if (bean_CRX.checkForStock()) {
									ArrayList stockDetails = bean_CRX.getStockDetails(dfltFluidCode, "1");
									
								}
								String infuse	=	bean_CRX.getInfuseOverValue(dfltFluidCode,"");
							}
						}else{
							HashMap fluid_det =(HashMap)bean_CRX.getFluidDetails();
							fluid_det.clear();
						}
					}

					//PersistenceHelper.putObjectInBean(search_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(bean_id_CRX,bean_CRX,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
				
			}
			else if(mode.equals("REMOVE_ALL_CRX")){
				try{
					System.out.println("REMOVE_ALL_CRX REMOVE_ALL_CRX Modi");
					
					String bean_id_CRX			= "@IVPrescriptionBean_CRX"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_CRX	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_CRX, bean_name_CRX, request);
					String drug_code;
					ArrayList drugList		   = (ArrayList)bean_CRX.getDrugDetails();
					int srl_no = 0;
					String srlNo;
					String generic_id;
					for(int j=0;j<drugList.size();j++){
						HashMap drugData      =  (HashMap) drugList.get(j);
						drug_code = drugData.get("DRUG_CODE")==null?"": (String) drugData.get("DRUG_CODE");						
						srlNo = drugData.get("SRL_NO")==null?"": (String) drugData.get("SRL_NO");
						srl_no = j+1 ;
						generic_id = drugData.get("GENERIC_ID")==null?"": (String) drugData.get("GENERIC_ID");
						//searchbean.removeDrugCode(drug_code);
						bean_CRX.removeDrugFromList(srl_no-1, drug_code);
						drugList.remove(srl_no-1);
					}
					drugList.clear();
					HashMap fluid_det =(HashMap)bean_CRX.getFluidDetails();
					fluid_det.clear();
					//PersistenceHelper.putObjectInBean(search_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(bean_id_CRX,bean_CRX,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
			} else if(mode.equals("REMOVE_ALL_IVD")){
				try{

					String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVD	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
					
					String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
					String search_bean_name		= "ePH.DrugSearchBean";
					DrugSearchBean searchbean	= (DrugSearchBean)PersistenceHelper.getBeanObject(search_bean_id,search_bean_name,request);
					
					String or_bean_name				= "eOR.OrderEntryBean";
					String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
					OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
					
					String drug_code;
					ArrayList drugList		   = (ArrayList)bean.getDrugDetails();
					int srl_no = 0;
					String srlNo;
					String generic_id;
					for(int j=0;j<drugList.size();j++){
						HashMap drugData      =  (HashMap) drugList.get(j);
						drug_code = drugData.get("DRUG_CODE")==null?"": (String) drugData.get("DRUG_CODE");
						srlNo = drugData.get("SRL_NO")==null?"": (String) drugData.get("SRL_NO");
						srl_no = j+1 ;
						generic_id = drugData.get("GENERIC_ID")==null?"": (String) drugData.get("GENERIC_ID");
						//searchbean.removeDrugCode(drug_code);
						bean.removeDrugFromList(srl_no-1, drug_code);
						drugList.remove(srl_no-1);
					}
					drugList.clear();
					HashMap fluid_det =(HashMap)bean.getFluidDetails();
					fluid_det.clear();
					PersistenceHelper.putObjectInBean(search_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(bean_id_IVD,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
			}
			else if(mode.equals("REMOVE_FLUID_IVWA")){
				try{
					String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVWA	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
					String drugCode		= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");
					String srlNo = request.getParameter("SrlNo") == null ? "":request.getParameter("SrlNo");
					int srl_no = Integer.parseInt(srlNo);
					if(srl_no>0){
						srl_no--;
						ArrayList AllFluids = bean.getAllFluids();
						AllFluids.remove(srl_no);
					}
					PersistenceHelper.putObjectInBean(bean_id_IVWA,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
			}
			else if(mode.equals("REMOVE_ALL_IVWA")){
				try{

					String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVWA	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
					String drugCode		= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");
					ArrayList AllFluids = bean.getAllFluids();
					AllFluids.clear();
					PersistenceHelper.putObjectInBean(bean_id_IVWA,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
			}
			else if(mode.equals("REMOVE_ALL_IVPB")){
				try{
					String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVPB	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
					bean.setDrgTradeCodesArray("");
					ArrayList drugList			= bean.getDrugDetails();
					drugList.clear();
					HashMap fluid_det =(HashMap)bean.getFluidDetails();
					fluid_det.clear();
					PersistenceHelper.putObjectInBean(bean_id_IVPB,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
			}
			else if(mode.equals("REMOVE_ALL_IV")){
				
				/*try{
					String or_bean_name				= "eOR.OrderEntryBean";
					String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
					OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
					eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
					String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
					String bean_name			= "ePH.PrescriptionBean_1";
					PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
					String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
					String param_bean_name				= "ePH.DrugInterfaceControlBean";
					DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
					
					String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
					String ph_bean_name 			= "ePH.DrugSearchBean";
					DrugSearchBean searchbean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;
					String drugCode;
					String srlNo;
					String generic_id;
					String order_set_code  = request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");
					ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
					String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);  
					
					String key				= patient_id+encounter_id;
					HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
					
					for(int k =0;k<prescriptionDetails.size();k++){
						HashMap ordItem = (HashMap)prescriptionDetails.get(k);
						drugCode = (String)ordItem.get("DRUG_CODE");
						previousValues.remove("ck"+drugCode);
						previousValues.remove("h1"+drugCode);
						previousValues.remove("h2"+drugCode);
						
						prescriptionDetails.remove(k);
						//searchbean.removeDrugCode(drugCode);
						//searchbean.removeSelectedDrug(drugCode);
						bean.getclearscheduleFrequency(drugCode);
						bean.removePRNRemarks(drugCode);
						bean.clearCopiedDrugs(drugCode);
						
					}
					orderEntryRecordBean.setCheckedEntries(key, previousValues);
					
					
					PersistenceHelper.putObjectInBean(ph_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
					PersistenceHelper.putObjectInBean(bean_id,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
				}*/
				
				try{

					String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVD	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
					
					String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
					String search_bean_name		= "ePH.DrugSearchBean";
					DrugSearchBean searchbean	= (DrugSearchBean)PersistenceHelper.getBeanObject(search_bean_id,search_bean_name,request);
					
					String or_bean_name				= "eOR.OrderEntryBean";
					String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
					OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
					
					String drug_code;
					ArrayList drugList		   = (ArrayList)bean.getDrugDetails();
					int srl_no = 0;
					String srlNo;
					String generic_id;
					for(int j=0;j<drugList.size();j++){
						HashMap drugData      =  (HashMap) drugList.get(j);
						drug_code = drugData.get("DRUG_CODE")==null?"": (String) drugData.get("DRUG_CODE");
						srlNo = drugData.get("SRL_NO")==null?"": (String) drugData.get("SRL_NO");
						srl_no = j+1;
						generic_id = drugData.get("GENERIC_ID")==null?"": (String) drugData.get("GENERIC_ID");
						//searchbean.removeDrugCode(drug_code);
						bean.removeDrugFromList(srl_no-1, drug_code);
						drugList.remove(srl_no-1);
					}
					drugList.clear();
					HashMap fluid_det =(HashMap)bean.getFluidDetails();
					fluid_det.clear();
					PersistenceHelper.putObjectInBean(search_bean_id,searchbean,request);
					PersistenceHelper.putObjectInBean(bean_id_IVD,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
				}
			
				
				try{
					String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVWA	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
					String drugCode		= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode");
					ArrayList AllFluids = bean.getAllFluids();
					AllFluids.clear();
					PersistenceHelper.putObjectInBean(bean_id_IVWA,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
				}
				
				try{
					String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
					String bean_name_IVPB	= "ePH.IVPrescriptionBean";
					IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
					bean.setDrgTradeCodesArray("");
					ArrayList drugList			= bean.getDrugDetails();
					drugList.clear();
					HashMap fluid_det =(HashMap)bean.getFluidDetails();
					fluid_det.clear();
					PersistenceHelper.putObjectInBean(bean_id_IVPB,bean,request);
				}
				catch(Exception e){
					PharmErrorItem errorItem = new PharmErrorItem();
					errorItem.setErrorMessageId("EXCEPTION_OCCURED");
					errorItem.setErrorMessage(e.getMessage());
					errorItems.add(errorItem);
					validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
					e.printStackTrace();
				}
			}
			
			else if(mode.equals("SELECT_IVPB_FLUID")){
			
				String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
				String bean_name_IVPB	= "ePH.IVPrescriptionBean";
				IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
				String drug_code = request.getParameter("DrugCode")==null?"":request.getParameter("DrugCode");
				String trade_code = request.getParameter("TradeCode") == null ? "":request.getParameter("TradeCode");
				iv_bean.setFldTradeCode(trade_code);
				int fluid_adr_count = iv_bean.getADRCount(patient_id,drug_code);
				iv_bean.setFluidDetails(drug_code,"","","","");
				if (iv_bean.checkForStock()){
					ArrayList stockDetails = iv_bean.getStockDetails(drug_code, "1");
					if (stockDetails.size() != 0){
						//out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949]
					}
					else{
						//out.println("setStockDetails(2);") ;
					}
					String infuse	=	iv_bean.getInfuseOverValue(drug_code,"");
					
				}
				//iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);
			}
			
			
		}else{
			PharmErrorItem errorItem = new PharmErrorItem();
			errorItem.setErrorMessageId("NULL_PATIENTCONTEXT");
			errorItem.setErrorMessage("No patient selected");
			errorItems.add(errorItem);
			validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_ERROR);
			
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
