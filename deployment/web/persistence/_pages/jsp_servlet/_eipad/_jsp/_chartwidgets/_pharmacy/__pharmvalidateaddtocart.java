package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import com.google.gson.Gson;
import com.ehis.util.DateUtils;
import eIPAD.chartsummary.pharmacy.healthobject.PharmErrorItem;
import java.util.ArrayList;
import eIPAD.chartsummary.pharmacy.response.PharmValidationResponse;
import ePH.PrescriptionBean;
import ePH.PrescriptionBean_1;
import eIPAD.chartsummary.common.healthobject.PatContext;
import com.ehis.persist.PersistenceHelper;
import eOR.OrderEntryBean;
import eOR.Common.OrderEntryRecordBean;

public final class __pharmvalidateaddtocart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/PharmValidateAddToCart.jsp", 1709116948223L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

PharmValidationResponse validationResponse = new PharmValidationResponse();
ArrayList<PharmErrorItem> errorItems = new ArrayList<PharmErrorItem>();
validationResponse.setValidationResult(PharmValidationResponse.VALIDATION_SUCCESS);
validationResponse.setErrorItems(errorItems);
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	String patient_id = patientContext.getPatientId();
	String encounter_id	= patientContext.getEncounterId();
	String locale = patientContext.getLocale();
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
	/* OrderEntryBean updation ENDS*/
	
	/* PrescriptionBean_1 updation STARTS */
	/* Code taken from PrescriptionValidation_1.jsp --- chkDuplicateDrugCode*/
	String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name			= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
	String drug_code	= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode"); //strArray[0]
	String facility_id	= patientContext.getFacilityId();
	String patient_class= patientContext.getPatientClass();
	String sys_date     = presBean.getSysdate();
	String drugCodes	= request.getParameter("DrugCode") == null ? "":request.getParameter("DrugCode"); //strArray[0]
	String tradeCodes	= request.getParameter("TradeCodes") == null ? "":request.getParameter("TradeCodes"); //strArray[10]
	String tradeNames	= request.getParameter("TradeNames") == null ? "":request.getParameter("TradeNames");//java.net.URLEncoder.encode(strArray[11],"UTF-8")
	String priority		= request.getParameter("Priority") == null ? "R":request.getParameter("Priority");//Default value "R"
	String take_home_medication= request.getParameter("take_home_medication") == null ? "N":request.getParameter("take_home_medication");//Taken from PharmBasePage - take_home_medication
	String order_set_code=request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");//Taken from PharmBasePage - order_set_code
	String order_set_occur_num="";//TODO, for now send as empty string
	String drug_db_interface_yn = request.getParameter("drug_db_interface_yn") == null ? "":request.getParameter("drug_db_interface_yn");//Taken from PharmBasePage - drug_db_interface_yn
	String act_patient_class = request.getParameter("act_patient_class") == null ? "":request.getParameter("act_patient_class");// Taken from PharmBasePage --actual_patient_class
	String pract_id = patientContext.getClinicianId();
	String resp_id = patientContext.getResponsibilityID();
	String home_leave_yn_val = request.getParameter("home_leave_yn_val") == null ? "":request.getParameter("home_leave_yn_val");// Taken from PharmBasePage --home_leave_yn_val
	String heightStr = request.getParameter("height") == null ? "0":request.getParameter("height");// Taken from PharmBasePage --height
	String weightStr = request.getParameter("weight") == null ? "0":request.getParameter("weight");// Taken from PharmBasePage --weight
	String tradeCodesArr[] = tradeCodes.split(",");
	String tradeNamesArr[] = tradeNames.split(",");
	String locn_type = "";
	String trade_code = "";
	String trade_name = "";
	int trade_count=0;
	if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
		locn_type	= request.getParameter("location_type") == null ? "":request.getParameter("location_type");// Taken from PharmBasePage --location_type
	else
		locn_type	= "P";
	String locn_code	= request.getParameter("location_code") == null ? "":request.getParameter("location_code");// Taken from PharmBasePage --location_type
	boolean allow_add= true;
	HashMap chk	=	null;
	if(allow_add){
		drugCodes = drugCodes.replace('[',' ');
		drugCodes = drugCodes.replace(']',' ');
		StringTokenizer stDrugCodes = new StringTokenizer(drugCodes.trim(),",");
		while(stDrugCodes.hasMoreTokens()){
			int srl_no	=bean.getSrlNo()+1;
			drug_code	=stDrugCodes.nextToken();
			if(trade_count < tradeCodesArr.length){
				trade_code=tradeCodesArr[trade_count];
				trade_name = java.net.URLDecoder.decode(tradeNamesArr[trade_count++],"UTF-8");
			}
			else{
				trade_code = "";
				trade_name = "";
			}
			sys_date     = presBean.getSysdate();// added for IN23575 --01/09/2010-- priya
			if(!locale.equals("en"));
				sys_date  = DateUtils.convertDate(sys_date, "DMYHM",locale,"en");
			boolean duplicateExists = false;
			ArrayList presDetails = bean.getpresDetails();
			if(presDetails!=null && presDetails.size()>0){
				for(int k=0;k<presDetails.size();k++){
					HashMap drugDet = (HashMap)presDetails.get(k);
					String drugCodeInCart = (String)drugDet.get("DRUG_CODE");
					if(drugCodeInCart.equals(drug_code)){
						duplicateExists = true;
					}
				}
			}
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
				if(validationResponse.getValidationResult() == PharmValidationResponse.VALIDATION_SUCCESS){
					//OrderEntryBean updation starts
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
				}
			}
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

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
