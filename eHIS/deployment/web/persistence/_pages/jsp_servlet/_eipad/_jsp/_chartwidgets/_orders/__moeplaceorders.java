package jsp_servlet._eipad._jsp._chartwidgets._orders;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.google.gson.Gson;
import eIPAD.chartsummary.orderentry.response.MOrderEntryCategTransItem;
import eIPAD.chartsummary.orderentry.response.MOrderEntryTransactionResponse;
import eIPAD.chartsummary.orderentry.response.MOrderEntryCatalogTransItem;
import eIPAD.chartsummary.orderentry.daoimpl.MOrderEntryDAOImpl;
import eOR.Common.OrRepository;
import eOR.OrderEntryBillingQueryBean;
import eOR.ConsentOrders;
import java.util.Map.Entry;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse;
import eIPAD.chartsummary.orderentry.bc.MOrderEntryBC;
import eOR.OrderEntryBean;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __moeplaceorders extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/orders/MoePlaceOrders.jsp", 1709116946348L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

            _bw.write(_wl_block3Bytes, _wl_block3);

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
String or_bean_name = "eOR.OrderEntryBean";
String localeName = (String)session.getAttribute("LOCALE") == null?"en":(String)session.getAttribute("LOCALE");
MOrderEntryTransactionResponse transactionResponse = new MOrderEntryTransactionResponse();

OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
String key							= (bean.getPatientId()+bean.getEncounterId());  // Unique key (For New Orders) to keep the Value in the Bean
HashMap previousValues 				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
HashMap catHashMap = bean.getOrderCategories(previousValues); //Get all the categories that are present in the selected orders

Properties properties				= (Properties) session.getValue( "jdbc" );
ArrayList OrderCategoryArr			= beanQueryObj.getOrderCategory(properties); // Get the Order category
MOrderEntryBC mObc = new MOrderEntryBC();
MOrderEntryDAOImpl daoImp = new MOrderEntryDAOImpl();
MOrderEntryFieldResponse orderCatsResp = mObc.getAllOrderCategories(bean, true);
HashMap hmOrderCategory				= new HashMap();
String billing_interface_yn		= bean.getBillingInterfaceYn();
String[] records;
HashMap bill_dtls				= null;
int i;
ArrayList Default				= null;
String[] recordDefault			= null;
String qty_value				= "";
String qty_uom				= "";
String qty_uom_shortdesc				   = "";
String frequency_val		= "";
String duration_value	= "";
String max_durn_value	= "";
String chk_for_max_durn_action = "";
String prompt_msg		= "";
String comments			= "";
String format_id				= "";
StringTokenizer stFormatID		= null;
String format_id_mandatory_yn	= "";
String practitioner_id = (String)session.getValue("ca_practitioner_id");
String order_id					= "";
String order_line_no			= "";
String[] secondaryOrders		= new String[2];
String[] billing_details 		= null;
ArrayList speciality= null;
String bean_id1 = "Or_ConsentOrders" ;
String bean_name1 = "eOR.ConsentOrders";
ConsentOrders bean1		= (ConsentOrders)getBeanObject( bean_id1, bean_name1, request ) ;
bean1.setLanguageId(localeName);
String   specialty_code				 = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");
String auth_reqd				= "";
String billing_call_yn			= "N";
String billinginterface="";
ArrayList BillChargeInfo		= null;
OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
String dateString				= bean.getSysDate();
String patient_email_id="";
String lb_instal_yn	= bean.checkForNull(bean.getFacilityModuleInstallYn("LB"),"N");
String session_id					= bean.checkForNull(bean.getSessionId(),"");
int display_auth_count			= 0; //TODO -- Value not used in EJB, but used to display the authenticate icon in header
String function_from = "";
String deceased_yn = bean.checkForNull(bean.getDeceasedPatientYn(bean.getPatientId())[0],"N");
String medico_legal_yn = "";//TODO
String postmortem_status = "";//TODO
String body_part_yn = "";//TODO
String registration_no = "";//TODO
String callingFrom = "";//TODO
String p_task_code = "";//TODO
String p_task_srl_no = "";//TODO
String order_set_bill_yn = "N";
String appl_user_name = (String)session.getAttribute("appl_user_name");
String called_from = "";
String show_bill_info_yn = bean.getBillingInterfaceShowYn();
String order_types_comb			= "";
String locn_appt_reqd_yn="N";//N since in EM Mobility we are not linking the appointment booking functionality
StringTokenizer stFormat		= null;
String[] rel_start_date_time	= null; 
eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
if(orderCatsResp!=null && orderCatsResp.getResponseStatus()!= orderCatsResp.FIELD_DATAFETCH_FAILURE){
	ArrayList<MOrderEntryFieldItem> orderCats = orderCatsResp.getFieldItems();
	for(i=0;i<orderCats.size(); i++) 
	{
		MOrderEntryFieldItem catItem = orderCats.get(i);
		hmOrderCategory.put(catItem.getCode(), catItem.getDesc());
	} // end of for
} // end of if 

response.setContentType("application/json");
Gson gson = new Gson();
String jsonRespString = "";


if(catHashMap!=null && !catHashMap.isEmpty()){ 
	//OROrderController.jsp
	/* if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
		local_ejbs = true;
	bean.setLocalEJB(local_ejbs); */
	/* bean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	bean.setLoginAtWsNo( bean.getProperties().getProperty( "client_ip_address" ) ) ;
	bean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
	bean.setMode("1"); */
	
	
	for(Object code:catHashMap.keySet()){
	    String order_category = (String)code;
	    String order_category_desc = (String)hmOrderCategory.get(order_category);
	    Hashtable hash = new Hashtable(); //Hash that is used to collect 

	    if(!order_category.equals("CS")){
	    	String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues);
	    	String practitioner_type = bean.getPractitionerType();
	    	String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category,practitioner_type);//IN042045
	    	ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category,""),bean.checkForNull(order_catalog_code,"''"),""); // Last parameter to identify normalOE or from preview
	    	
	    	
	    	if(PlaceOrderItems!=null){
	    		for(i=0; i<PlaceOrderItems.size(); i++){
	    			billinginterface="";
	    			String servicepanel="";
	    			String servicepanelcode="";
	    			String finbill="";
	    			locn_appt_reqd_yn="";
	    			records =(String[])PlaceOrderItems.get(i); // String array
	    			Default = bean.getPlaceOrderDefault(records[0]);
	    			
	    			for(int j=0;j<Default.size();j++)
	    			{
	    				recordDefault	 = ((String[])Default.get(j));
	    				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
	     				if(recordDefault!=null){
	    					qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
	    					if(qty_value.equals("0")) qty_value = "1";
	    						qty_uom			 =  bean.checkForNull(recordDefault[9],"");
	    						qty_uom_shortdesc=  bean.checkForNull(recordDefault[10],"");
	    				}else{
	    					qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
	    				}
	    			}
	    			if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";
	    			if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
					if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
					if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
					if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
					if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
					
					format_id = bean.checkForNull(records[47],"");
					if(!records[47].trim().equals(""))
					{
			     		stFormatID 	= new StringTokenizer(records[47],"~");
			     		while(stFormatID.hasMoreTokens())
			     		{
			     			format_id_mandatory_yn  = stFormatID.nextToken();
			     			format_id 				= stFormatID.nextToken();
			     		}
						stFormatID = null;// Nullifying the objects
			 		}
					
	    			hash.put("ck"+records[0], "Y");
	    			hash.put("h1"+records[0], records[3]);
	    			hash.put("h2"+records[0], records[4]);
	    			hash.put("start_date_time"+i, bean.checkForNull(bean.getTempvalue("start_date_time"+records[0]), ""));
	    			hash.put("catalog_code"+i, records[0]);
	    			hash.put("auth_reqd"+i, ""); //TODO Correct value to be passed TBR
	    			hash.put("order_type_code"+i, bean.checkForNull(bean.getTempvalue("order_type_code"+records[0]), ""));
	    			hash.put("order_type"+i, bean.checkForNull(bean.getTempvalue("order_type_code"+records[0]), ""));
	    			hash.put("priority"+i, bean.checkForNull(bean.getTempvalue("priority"+records[0]), ""));
	    			hash.put("frequency_code"+i, bean.checkForNull(bean.getTempvalue("frequency_code"+records[0]), ""));
	    			hash.put("cat_desc"+i, records[1]);
	    			hash.put("type_desc"+i, ""); //TODO TBR
	    			hash.put("quantity"+i, bean.checkForNull(bean.getTempvalue("quantity"+records[0]), "1"));
	    			hash.put("frequency_val"+i, frequency_val);
	    			hash.put("schedule_yn"+i, "N");
	    			hash.put("schedule_mandatorily_yn"+i, "N");
	    			hash.put("freq_nature"+i, "F");
	    			hash.put("repeat_value"+i, "");
	    			hash.put("duration_value"+i, bean.checkForNull(bean.getTempvalue("duration_value"+records[0]), ""));
	    			hash.put("duration_def_value"+i, duration_value);
	    			hash.put("duration_code"+i, bean.checkForNull(bean.getTempvalue("duration_code"+records[0]), ""));
	    			hash.put("duration"+i, ""); //TODO
	    			hash.put("format_id_val"+i, format_id);
	    			hash.put("format_id_yn"+i, "Y");
	    			hash.put("format_id_mandatory_yn"+i, format_id_mandatory_yn);
	    			if(records[51].equalsIgnoreCase("Y")){
	    				hash.put("consent_id_lookup"+i, "C");
	    				ArrayList multiConsentList = new ArrayList();
	    				String[] multiConsentValues = null;
	    				String[] multiConsentDtls = null;
	    				boolean consentflag=false;
	    				multiConsentDtls		= bean1.MultiListDtls(records[0],practitioner_id);
	    				multiConsentList		= bean1.MultiListConsentsdtl(records[0],order_id,order_line_no, practitioner_id);
	    				if(multiConsentList==null || multiConsentList.size()==0)
	    				{
	    					multiConsentList		= bean1.MultiListConsents(records[0],order_id,order_line_no,practitioner_id);
	    				}
	    				int total_recs = 0;				
	    				if(multiConsentDtls != null)
	    				{	
	    					int num_of_consent_req_bo=0;
	    					int num_of_consent_req_br=0;
	    					int num_consent_bo=0;
	    					int num_consent_br=0;
	    					if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2])) > 1 ) ))
	    					{		
	    						for(int m=0;m<multiConsentList.size();m++)
	    						{
	    							multiConsentValues = (String[])multiConsentList.get(m);
	    							num_of_consent_req_bo=Integer.parseInt(multiConsentValues[7]);
	    							num_of_consent_req_br=Integer.parseInt(multiConsentValues[8]);
	    							if(multiConsentValues[6].equals("F"))
	    							{
	    								if(multiConsentValues[3].equals("A"))
	    								{
	    									if(num_of_consent_req_bo!=num_consent_bo)
	    									{
	    										num_consent_bo++;
	    										consentflag = true;
	    									}
	    								}
	    								else if(multiConsentValues[3].equals("R"))
	    								{
	    									if(num_of_consent_req_br!=num_consent_br)
	    									{
	    										num_consent_br++;
	    										consentflag = true;
	    									}
	    								}
	    								if(consentflag)
	    								{
	    									hash.put("consent_chk"+i+total_recs, "Y");
	    									hash.put("consent_form_id"+i+total_recs, multiConsentValues[1]);
	    									hash.put("consent_stages"+i+total_recs, multiConsentValues[3]);
    										total_recs++;
    										consentflag = false;
	    								}
	    							}
	    						}
	    						hash.put("consent_form_list"+i, multiConsentDtls[0]);
	    						hash.put("total_recs"+i, total_recs);
		    				}
		    				else
		    				{
		    					if(multiConsentDtls[0].equals("F"))
		    					{	
		    						if(!(bean.checkForNull(multiConsentDtls[3])).equals(""))
		    						{
		    							total_recs = total_recs++;
		    						}
		    						hash.put("consent_stages"+i+"0", multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":""));
		    						hash.put("consent_chk"+i+"0", "Y");
		    						hash.put("consent_form_id"+i, multiConsentDtls[3]);
	    						}
		    					hash.put("consent_form_list"+i, multiConsentDtls[0]);
		    					hash.put("total_recs"+i, total_recs);
	    					}
	    					hash.put("multiConsentList"+i, total_recs);
	    				}
	    			}
	    			secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); 
	    			hash.put("sec_tasks_type"+i, secondaryOrders[1]);
	    			hash.put("end_date_time"+i, bean.checkForNull(bean.getTempvalue("end_date_time"+records[0]), ""));
	    			hash.put("performing_facility_id"+i, bean.checkForNull(bean.getTempvalue("performing_facility_id"+records[0]), ""));
	    			hash.put("performing_dept_loc_code"+i, bean.checkForNull(bean.getTempvalue("performing_dept_loc_code"+records[0]), ""));
	    			
	    			if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))
					{
	    				billinginterface="interface";
						billing_call_yn		= "Y";
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
						if(BillChargeInfo!=null)
						{
							for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
							{
								billing_details 	= (String[])BillChargeInfo.get(k);
							}
						}
						if(!billing_details[9].equals(""))
						{
							finbill="Billing";
						}
						
	    				//hash.put("bill_now_check"+i, bean.getTempvalue("bill_now_check"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("bill_now_check"+records[0])); //TODO related to Change bill link
	    				//hash.put("bill_now"+i, bean.getTempvalue("bill_now"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""): bean.getTempvalue("bill_now"+records[0]));
	    				//hash.put("bill_now_check_Df"+i, bean.getTempvalue("bill_now_check_Df"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("bill_now_check_Df"+records[0]));
	    				//hash.put("future_date"+i, billing_details[18]);
	    				//hash.put("round_off_start_time"+i, billing_details[19]);
	    				//bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
					}
	    			
	    			//speciality=new ArrayList();
	    			speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
	    			String speciality_code[]=new String[3];
					if(speciality.size()>0)
					{
						for(int sc=0;sc<speciality.size();sc++)
						{
								speciality_code=(String[])speciality.get(sc);
						}
					}
					
					hash.put("order_catalog_code"+i, records[0]);
					hash.put("enable_email"+i, "N");
					hash.put("order_catalog_nature"+i, records[2]);
					hash.put("quantity_uom"+i, records[11]);
					hash.put("freq_applicable_yn"+i, records[14]);
					hash.put("soft_stop_yn"+i, records[19]);
					hash.put("cont_order_yn"+i, records[20]);
					hash.put("chk_for_dupl_yn"+i, records[22]);
					hash.put("chk_for_dupl_status"+i, records[23]);
				
					hash.put("chk_for_dupl_ahead_action"+i, records[24]);
					hash.put("chk_for_dupl_ahead_period"+i, records[25]);
					hash.put("chk_for_dupl_ahead_unit"+i, records[26]);
					hash.put("chk_for_dupl_behind_action"+i, records[27]);
					hash.put("chk_for_dupl_behind_period"+i, records[28]);
					hash.put("chk_for_dupl_behind_unit"+i, records[29]);

					hash.put("appt_reqd_yn"+i, records[33]);
					hash.put("locn_appt_reqd_yn"+i, locn_appt_reqd_yn); 
					hash.put("appt_time"+i, records[34]);
					hash.put("pat_instrn_age_sex_yn"+i, records[35]);
					hash.put("complete_on_order_yn"+i, records[37]);
					hash.put("bill_yn"+i, records[38]);
					hash.put("result_applicable_yn"+i, records[39]);
					hash.put("result_auth_reqd_yn"+i, records[40]);
					hash.put("chart_result_type"+i, records[41]);
					hash.put("contr_msr_mod_id"+i, records[43]);
					hash.put("contr_msr_panel_id"+i, records[44]);

					hash.put("ord_auth_reqd_yn"+i, records[48]);
					hash.put("ord_cosign_reqd_yn"+i, records[49]);
					hash.put("ord_spl_appr_reqd_yn"+i, records[50]);
					hash.put("ord_consent_reqd_yn"+i, records[51]);
					hash.put("activity_type"+i, records[53]);
					hash.put("check_for_dupl_level"+i, records[54]);
					
					hash.put("group_order_category"+i, order_category);
					hash.put("billing_call_yn"+i, billing_call_yn);
					hash.put("specimen_type"+i, "");
					hash.put("nurse_collect"+i, "N");
					hash.put("start_time"+i, "");
					hash.put("care_set_order_category"+i, "");//For Care Sets
					hash.put("care_set_authorized"+i, "false"); //For Care Sets
					hash.put("order_id"+i, order_id); //For Copy Order
					hash.put("order_line_num"+i, order_line_no); //For Copy Order
					hash.put("line_preps"+i, ""); //For Copy Order
					hash.put("line_pat_instrn"+i, "");//For Copy Order
					hash.put("line_dept_instrn"+i, ""); //For Copy Order
					hash.put("line_comments"+i, comments);
					hash.put("routine_appt_reqd_yn"+i, records[55]);
					hash.put("stat_appt_reqd_yn"+i, records[56]);
					hash.put("urgent_appt_reqd_yn"+i, records[57]);

					hash.put("routine_chk_for_dupl_yn"+i, records[58]);
					hash.put("urgent_chk_for_dupl_yn"+i, records[59]);
					hash.put("stat_chk_for_dupl_yn"+i, records[60]);
					hash.put("consent_stage"+i, records[61]);
					
					hash.put("num_of_consent_req_bo"+i, records[64]);
					hash.put("num_of_consent_req_br"+i, records[65]);
					hash.put("billing_interface"+i, billinginterface);
					hash.put("service_panel"+i, servicepanel);
					hash.put("service_panel_code"+i, servicepanelcode);
					//hash.put("numbering"+i, numbering);
					hash.put("FinBill"+i, finbill);
					if(bean.checkForNull(records[66],"N").equalsIgnoreCase("N"))
					{
						records[66] = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N");
					}
					hash.put("clin_cmts_reqd_yn"+i, bean.checkForNull(records[66],"N"));

					hash.put("authorised_yn"+i, "N");
					hash.put("skip_auth"+i, records[70]);
									
					if(speciality_code[0].equalsIgnoreCase("Y"))
					{
				
						hash.put("splty_code"+i, speciality_code[1]);
						hash.put("auth_yn"+i, speciality_code[2]);
			
					}
					else
					{
			
						hash.put("splty_code"+i, "");
						hash.put("auth_yn"+i, bean.checkForNull(records[67],"N"));
				
					}
					hash.put("auto_report_yn"+i, bean.checkForNull(records[63],""));
					
					hash.put("order_date_time", bean.checkForNull(bean.getTempvalue("start_date_time"+records[0]), ""));
	    		}
	    		hash.put("patient_email_id", bean.checkForNull(patient_email_id,""));
	    		hash.put("care_set_count", "0");//Used for Care Sets
	    		hash.put("mode", "1");
	    		hash.put("sys_date", com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
	    		hash.put("total_rows", ""+i);
	    		hash.put("amend_total_rows", "0");
	    		hash.put("check_box_val", "");
	    		hash.put("authorized", bean.checkForNull(bean.getTempvalue("authorized"+order_category),"false"));//TODO
	    		hash.put("patient_id", bean.getPatientId());
	    		hash.put("encounter_id", bean.getEncounterId());
	    		hash.put("location_type", bean.getLocationType());
	    		hash.put("location_code", bean.getLocationCode());
	    		hash.put("priority_hdr", "");
	    		
	    		hash.put("header_comments", "");
	    		hash.put("order_category", order_category);
	    		hash.put("consented", bean.checkForNull(bean.getTempvalue("consented"+order_category),"false"));//TODO
	    		hash.put("cosigned", bean.checkForNull(bean.getTempvalue("cosigned"+order_category),"false"));//TODO
	    		hash.put("special_approved", bean.checkForNull(bean.getTempvalue("special_approved"+order_category),"false"));//TODO
	    		hash.put("lb_instal_yn", lb_instal_yn);
	    		hash.put("rd_install_yn", bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"));
	    		hash.put("ot_install_yn", bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N"));
	    		hash.put("session_id", session_id);
	    		hash.put("sex", bean.getSex());
	    		hash.put("dob", bean.getDob());
	    		hash.put("display_auth_count", display_auth_count);
	    		hash.put("facility_id", bean.getLoginFacilityId());
	    		hash.put("ordering_practitioner", bean.getPractitionerId());
	    		hash.put("function_from", function_from);
	    		//IN030279 Start 
	    		hash.put("deceased_yn", deceased_yn);
	    		hash.put("medico_legal_yn", medico_legal_yn);
	    		hash.put("postmortem_status", postmortem_status);
	    		hash.put("body_part_yn", body_part_yn);
	    		hash.put("registration_no", registration_no);
	    		hash.put("callingFrom", callingFrom);
	    		//IN030279 End. 
	    		hash.put("p_task_code", p_task_code);
	    		hash.put("p_task_srl_no", p_task_srl_no);
	    		hash.put("ref_facility_id", "");//External Orders
	    		hash.put("ref_date_time", "");//External Orders
	    		hash.put("ref_sent_pract_id", "");//External Orders
	    		hash.put("ref_sent_remarks", "");//External Orders
	    		hash.put("query_string", "");//Query String -- TODO

	    	
	    		if(order_set_bill_yn.equals("Y"))
	    		{
	    			hash.put("care_set_catalog_code", "");//Used for Care Sets
	    			hash.put("care_set_catalog_desc", "");//Used for Care Sets
	    		}
	    		else
	    		{
	    			hash.put("care_set_catalog_code", "");//Used for Care Sets
	    			hash.put("care_set_catalog_desc", "");//Used for Care Sets
	    		}
	    	
	    		hash.put("function_name", "NEW_ORDER"); //For Order Format Line Level 
	        	hash.put("specialty_code", specialty_code);
	    			 //Used in OrderEntryCalendar.js to send to OA Appointment Booking
	    		hash.put("cosign_reqd_yn", ""); //Will be set at the time of apply, and used to set the Cosign_reqd_yn='Y' when nurse is logging in 
	    		hash.put("primary_order_type", ""); //Used for Primary Order Type OT Ordercategory 
	    		hash.put("validated_status", "validation_reqd");
	    		hash.put("new_order_reqd", ""); 
	    		hash.put("email_yn", "N"); //For Email 
	    		hash.put("appl_user_name", appl_user_name); 
	    		hash.put("localeName", localeName);
	    		hash.put("order_set_bill_yn", order_set_bill_yn);
	    		hash.put("checkCount", i);
	    		hash.put("called_from", called_from);
	    		hash.put("show_bill_info_yn", show_bill_info_yn); //added for IN039607 
	    		
	    		//out.println(hash.toString());
	    		//out.println("<br>|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||<br>");		
	    				
	    		
				order_type_catalog			 = ""; // Remove the values
				
				
	    	}
	    }else if(order_category.equals("CS")){
	    	String practitioner_type = bean.getPractitionerType();
	    	String order_catalog_code 		= bean.checkForNull(bean.getOrderCatalogCode(previousValues,order_category,practitioner_type),"");
	    	ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(bean.checkForNull(order_catalog_code,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),order_category);
	    	
	    	String billing_order_set_details[] = bean.getOrderSetBillDetails(order_catalog_code);
			order_set_bill_yn = bean.checkForNull(billing_order_set_details[1],"N");
			String care_set_catalog_desc = bean.checkForNull(billing_order_set_details[0],"");
			String charge_yn = bean.checkForNull(billing_order_set_details[2],"");
			if(charge_yn.equalsIgnoreCase("N"))
			{
				order_set_bill_yn = "N";
			}
			ArrayList PlaceOrderItems 		= null;
			String[] care_set_group			= null;
			ArrayList PlaceOrderSetItems 	= null;
			String order_set_order_catalog	= "";
			String order_type_catalog 		= "";
			auth_reqd				= "X";
			int count						= 0;
			int t = 0 ;
			
			
			if(charge_yn.equalsIgnoreCase("N"))
			{
				order_set_bill_yn = "N";
			}
			if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !order_category.equals("BT"))
			{
				bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code);
			}
			if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get -- Grouping based on order category
			{
				for(t=0; t<PlaceOrdercareSetCount.size(); t++)
				{
					String[] care_set_count 		= null;
					care_set_count = (String[])PlaceOrdercareSetCount.get(t);
					String servicepanel="";
					String servicepanelcode="";
					String finbill="";
					String speciality_code[]=new String[3];
					
					// Pass the order_category and the order_types for the order_category to get the format_id
					order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(order_catalog_code),"");  // Order Types Combination for the order_category
					// Get the Format Id for the Header
					format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
					if(!format_id.trim().equals("") )
					{
						stFormat = new StringTokenizer(format_id,"~");
						while(stFormat.hasMoreTokens())
	 					{
	 						format_id_mandatory_yn	 	= stFormat.nextToken();
	 						format_id 	 	 			= stFormat.nextToken();
	 					}
						stFormat = null;
	 				}
					if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
						hash.put("format_id_yn"+t, "N");
					else
						hash.put("format_id_yn"+t, "Y");
					
					hash.put("hdr_format_id_mandatory_yn"+t, format_id_mandatory_yn);
					hash.put("hdr_care_set_order_category"+t, care_set_count[1]);
					hash.put("hdr_order_catalog_code"+t, order_catalog_code);
					hash.put("hdr_format_id"+t, format_id);
					hash.put("hdr_format_id"+count, auth_reqd);
					
					
					String time_frame = "";
					PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
					rel_start_date_time	= new String[PlaceOrderSetItems.size()];
					for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
					{
						care_set_group 			= (String[])PlaceOrderSetItems.get(k);
						order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
					    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
					    rel_start_date_time[k]	= care_set_group[10]; 
					}
					if(order_set_order_catalog.length() > 0)
						order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
					if(order_type_catalog.length() > 0)
						order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
					PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),""); // Last parameter to identify normalOE or from preview
					if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
					{
						for(i=0; i<PlaceOrderItems.size(); i++)
						{
							records		= (String[])PlaceOrderItems.get(i);
							hash.put("enable_email"+count, "N");
							hash.put("ck"+records[0], "Y"); //Always all items of ordersets are added
							hash.put("h1"+records[0], records[3]);
							hash.put("h2"+records[0], records[4]);
							hash.put("catalog_code"+count, records[0]);
							hash.put("start_time"+count, bean.checkForNull(bean.getTempvalue("start_date_time"+records[0]), ""));
							hash.put("cat_desc"+count, records[1]);
							hash.put("order_type_code"+count, bean.checkForNull(bean.getTempvalue("order_type_code"+records[0]), ""));
							hash.put("type_desc"+count, "");
							hash.put("order_type"+count, bean.checkForNull(bean.getTempvalue("order_type_code"+records[0]), ""));
							hash.put("priority"+count, bean.checkForNull(bean.getTempvalue("priority"+records[0]), ""));
							//hash.put("order_type"+count, records[52]);
							hash.put("quantity"+count, qty_value);
							hash.put("frequency_code"+count, qty_value);
							hash.put("frequency_val"+count, frequency_val);
							hash.put("schedule_yn"+count, "N");
							hash.put("schedule_mandatorily_yn"+count, "N");
							hash.put("freq_nature"+count, "F");
							hash.put("repeat_value"+count, "");
							hash.put("duration_value"+count, bean.checkForNull(bean.getTempvalue("duration_value"+records[0]), ""));
							hash.put("duration_def_value"+count, bean.checkForNull(bean.getTempvalue("duration_value"+records[0]), ""));
							hash.put("duration_code"+count, bean.checkForNull(bean.getTempvalue("duration_code"+records[0]), ""));
			    			hash.put("duration"+count, ""); //TODO
			    			
			    			format_id = bean.checkForNull(records[47],"");
			    			format_id_mandatory_yn = "N";
			    			if(!records[47].trim().equals(""))
			    			{
			    	     		stFormatID 	= new StringTokenizer(records[47],"~");
			    	     		while(stFormatID.hasMoreTokens())
			    	     		{
			    	     			format_id_mandatory_yn  = stFormatID.nextToken();
			    	     			format_id 				= stFormatID.nextToken();
			    	     		}
			    				stFormatID	= null;
			    	 		}
							
			    			hash.put("format_id_val"+count, format_id); 
			    			hash.put("format_id_mandatory_yn"+count, format_id_mandatory_yn); 
			    			hash.put("format_id_val"+count, format_id); 
			    			if(records[51].equalsIgnoreCase("Y"))
							{
			    				hash.put("consent_id_lookup"+count, "C"); 
			    				ArrayList multiConsentList = new ArrayList();
								String[] multiConsentValues = null;
								String[] multiConsentDtls = null;
								boolean consentflag = false;
								multiConsentDtls		= bean1.MultiListDtls(records[0],practitioner_id);
								multiConsentList		= bean1.MultiListConsentsdtl(records[0],order_id,order_line_no, practitioner_id);
								if(multiConsentList==null || multiConsentList.size()==0)
								{
									multiConsentList		= bean1.MultiListConsents(records[0],order_id,order_line_no,practitioner_id);
								}
								int total_recs = 0;					
								if(multiConsentDtls != null)
								{	
									int num_of_consent_req_bo=0;
									int num_of_consent_req_br=0;
									int num_consent_bo=0;
									int num_consent_br=0;
									if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2])) > 1 ) ))
									{
									
										for(int m=0;m<multiConsentList.size();m++)
										{
											multiConsentValues = (String[])multiConsentList.get(m);
											num_of_consent_req_bo=Integer.parseInt(multiConsentValues[7]);
											num_of_consent_req_br=Integer.parseInt(multiConsentValues[8]);					
											if(multiConsentValues[6].equals("F"))
											{
												if(multiConsentValues[3].equals("A"))
												{
													if(num_of_consent_req_bo!=num_consent_bo)
													{
														num_consent_bo++;
														consentflag = true;
													}										
												}
												else if(multiConsentValues[3].equals("R"))
												{
													if(num_of_consent_req_br!=num_consent_br)
													{
														num_consent_br++;
														consentflag = true;
													}										
												}
												if(consentflag)
												{
													hash.put("consent_chk"+count+total_recs, "Y"); 
													hash.put("consent_form_id"+count+total_recs, multiConsentValues[1]); 
													hash.put("consent_stages"+count+total_recs, multiConsentValues[3]); 
													
													total_recs++;
													consentflag = false;
													
												}		
											}
										}
										hash.put("consent_form_list"+count, multiConsentDtls[0]);
										hash.put("total_recs"+count, total_recs);
									}
									else
									{
										if(multiConsentDtls[0].equals("F"))
										{	
											if(!bean.checkForNull(multiConsentDtls[3]).equals(""))
											{
												total_recs = total_recs++;
											}
											hash.put("total_recs"+count, multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":""));
											hash.put("consent_chk"+count+0, "Y");
											hash.put("consent_form_id"+count+0, multiConsentDtls[3]);
										}
										hash.put("consent_form_list"+count, multiConsentDtls[0]);
										hash.put("total_recs"+count, total_recs);
									}
									hash.put("multiConsentList"+count, total_recs);
								}
							}
							
							
			    			secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); //Pass the catalog_code and patient_class
			    			hash.put("sec_tasks_type"+count, secondaryOrders[1]);
			    			hash.put("end_date_time"+count, "");
			    			hash.put("performing_facility_id"+count, bean.checkForNull(bean.getTempvalue("performing_facility_id"+records[0]), ""));
			    			hash.put("performing_dept_loc_code"+count, bean.checkForNull(bean.getTempvalue("performing_dept_loc_code"+records[0]), ""));
			    			if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y"))
							{
			    				billinginterface="interface";
								billing_call_yn		= "Y";
								BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],rel_start_date_time[i], localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
								if(BillChargeInfo!=null)
								{
									for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
										billing_details 	= (String[])BillChargeInfo.get(k);
									}
								}
								bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
				    			hash.put("bill_now_check"+count, bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""));
				    			hash.put("bill_now"+count, bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""));
				    			hash.put("bill_now_check_Df"+count, bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""));
				    			hash.put("future_date"+count, billing_details[18]);
				    			hash.put("round_off_start_time"+count, billing_details[19]);
				    			if(!billing_details[9].equals(""))
				    				finbill="Billing";
							}
							hash.put("order_catalog_nature"+count, records[2]);
							hash.put("quantity_uom"+count, records[11]);
							hash.put("freq_applicable_yn"+count, records[14]);
							hash.put("soft_stop_yn"+count, records[19]);
							hash.put("cont_order_yn"+count, records[20]);
							hash.put("chk_for_dupl_yn"+count, records[22]);
							hash.put("chk_for_dupl_status"+count, records[23]);
							
							hash.put("chk_for_dupl_ahead_action"+count, records[24]);
							hash.put("chk_for_dupl_ahead_period"+count, records[25]);
							hash.put("chk_for_dupl_ahead_unit"+count, records[26]);
							hash.put("chk_for_dupl_behind_action"+count, records[27]);
							hash.put("chk_for_dupl_behind_period"+count, records[28]);
							hash.put("chk_for_dupl_behind_unit"+count, records[29]);

							hash.put("appt_reqd_yn"+count, records[33]);
							hash.put("locn_appt_reqd_yn"+count, locn_appt_reqd_yn);
							hash.put("appt_time"+count, records[34]);
							hash.put("pat_instrn_age_sex_yn"+count, records[35]);
							hash.put("complete_on_order_yn"+count, records[37]);
							hash.put("bill_yn"+count, billing_call_yn);
							hash.put("result_applicable_yn"+count, records[39]);
							hash.put("result_auth_reqd_yn"+count, records[40]);
							hash.put("chart_result_type"+count, records[41]);
							hash.put("contr_msr_mod_id"+count, records[43]);
							hash.put("contr_msr_panel_id"+count, records[44]);
							hash.put("ord_auth_reqd_yn"+count, records[48]);
							hash.put("ord_cosign_reqd_yn"+count, records[49]);
							hash.put("ord_spl_appr_reqd_yn"+count, records[50]);
							hash.put("ord_consent_reqd_yn"+count, records[51]);
							hash.put("activity_type"+count, records[53]);
							hash.put("check_for_dupl_level"+count, records[54]);
							hash.put("routine_appt_reqd_yn"+count, records[55]);
							hash.put("stat_appt_reqd_yn"+count, records[56]);
							hash.put("urgent_appt_reqd_yn"+count, records[57]);
							hash.put("routine_chk_for_dupl_yn"+count, records[58]);
							hash.put("urgent_chk_for_dupl_yn"+count, records[59]);
							hash.put("stat_chk_for_dupl_yn"+count, records[60]);
							hash.put("consent_stage"+count, records[61]);
							
							hash.put("num_of_consent_req_bo"+count, records[64]);
							hash.put("num_of_consent_req_br"+count, records[65]);
							hash.put("billing_interface"+count, billinginterface);
							hash.put("service_panel"+count, servicepanel);
							hash.put("service_panel_code"+count, servicepanelcode);
							//hash.put("numbering"+count, numbering);
							hash.put("FinBill"+count, finbill);
							
							if(bean.checkForNull(records[66],"N").equalsIgnoreCase("N"))
							{
								records[66] = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, care_set_count[1]),"N");
							}
							hash.put("clin_cmts_reqd_yn"+count, bean.checkForNull(records[66],"N"));
							hash.put("authorised_yn"+count, "N");
							
							speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd);
							if(speciality.size()>0)
							{
								for(int sc=0;sc<speciality.size();sc++)
								{
										speciality_code=(String[])speciality.get(sc);
								}
							}							
							if(speciality_code[0].equalsIgnoreCase("Y")){
								hash.put("splty_code"+count, speciality_code[1]);
								hash.put("auth_yn"+count, speciality_code[2]);
							}else{
								hash.put("splty_code"+count, "");
								hash.put("auth_yn"+count, bean.checkForNull(records[67],"N"));
							}
							
							hash.put("group_order_category"+count, care_set_count[1]);
							hash.put("billing_call_yn"+count, billing_call_yn);
							hash.put("specimen_type"+count, "");
							hash.put("nurse_collect"+count, "N");
							hash.put("care_set_authorized"+count, bean.checkForNull(bean.getTempvalue("authorized"+order_category),"false"));
							hash.put("order_id"+count, ""); //For Copy Order 
							hash.put("order_line_num"+count, ""); //For Copy Order 
							hash.put("line_preps"+count, ""); //For Copy Order 
							hash.put("line_pat_instrn"+count, ""); //For Copy Order 
							hash.put("line_dept_instrn"+count, ""); //For Copy Order 
							hash.put("line_comments"+count, "");
							hash.put("auto_report_yn"+count, bean.checkForNull(records[63],"")); //auto_report_yn
							hash.put("skip_auth"+count, records[70]);//IN048467 - HSA-CRF-0150
							hash.put("order_date_time", bean.checkForNull(bean.getTempvalue("start_date_time"+records[0]), ""));
							count++;
						}
						order_set_order_catalog = ""; // Remove the values
						order_type_catalog			 = ""; // Remove the values
					}
					hash.put("care_set_order_category"+t, care_set_count[1]);
				}
				hash.put("care_set_count", ""+t);
			}
			hash.put("patient_email_id", patient_email_id);
			hash.put("mode", "1");
			hash.put("sys_date", com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
			hash.put("total_rows", ""+count); //used for New orders
			hash.put("amend_total_rows", "0");
			hash.put("check_box_val", "");

			hash.put("authorized", bean.checkForNull(bean.getTempvalue("authorized"+order_category),"false"));
			hash.put("patient_id", bean.getPatientId());
			hash.put("encounter_id", bean.getEncounterId());
			hash.put("location_type", bean.getLocationType());
			hash.put("location_code", bean.getLocationCode());
			hash.put("priority_hdr", "R");//TODO
			
			hash.put("header_comments", "");
			hash.put("order_category", order_category);
			hash.put("consented", bean.checkForNull(bean.getTempvalue("consented"+order_category),"false"));
			hash.put("cosigned", bean.checkForNull(bean.getTempvalue("cosigned"+order_category),"false"));
			hash.put("special_approved", bean.checkForNull(bean.getTempvalue("special_approved"+order_category),"false"));//TODO
			hash.put("lb_instal_yn", lb_instal_yn);
			hash.put("facility_id", bean.getLoginFacilityId());
			hash.put("ordering_practitioner", bean.getPractitionerId());
			hash.put("function_from", function_from);
			hash.put("deceased_yn", deceased_yn);
			hash.put("medico_legal_yn", medico_legal_yn);
			hash.put("postmortem_status", postmortem_status);
			hash.put("body_part_yn", body_part_yn);
			hash.put("registration_no", registration_no);
			hash.put("callingFrom", callingFrom);
			hash.put("p_task_code", p_task_code);
			hash.put("p_task_srl_no", p_task_srl_no);
			hash.put("primary_order_type", ""); // Used for Primary Order Type OT Ordercategory
			hash.put("rd_install_yn", bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"));
			hash.put("ot_install_yn", bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N"));

			hash.put("sex", bean.getSex());
			hash.put("dob", bean.getDob());
			hash.put("session_id", session_id);
			hash.put("care_set_catalog_code", order_catalog_code);
			hash.put("specialty_code", specialty_code);
				//Used in OrderEntryCalendar.js to send to OA Appointment Booking
			hash.put("cosign_reqd_yn", "N"); //Will be set at the time of apply, and used to set the Cosign_reqd_yn='Y' when nurse is logging in


			hash.put("function_name", "ORDER_SET"); //For Order Format Line Level
			hash.put("record_from", "ORDER_SET");


			hash.put("validated_status", "validation_reqd");
			hash.put("localeName", localeName);
			hash.put("called_from", called_from);
			hash.put("email_yn", "N");//For Email
			hash.put("appl_user_name", appl_user_name); 
			hash.put("order_set_bill_yn", order_set_bill_yn);
			hash.put("charge_yn", charge_yn);
			hash.put("care_set_catalog_desc", care_set_catalog_desc);
			hash.put("checkCount", "");
			hash.put("ref_facility_id", ""); //External Orders
			hash.put("ref_date_time", ""); //External Orders
			hash.put("ref_sent_pract_id", ""); //External Orders
			hash.put("ref_sent_remarks", ""); //External Orders
			hash.put("show_bill_info_yn", bean.getBillingInterfaceShowYn()); // added for IN035929[IN040092]
			//out.println(hash.toString());
			//out.println("<br>|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||<br>");
					
	    }
	    
	  
	    //out.println("<h1>Result of "+order_category_desc+" Orders</h1>");
	    boolean local_ejbs	= false ;
		HashMap map = null; 
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
		bean.setLocalEJB(local_ejbs);
		bean.setLoginById( (String) session.getValue( "login_user" ) ) ;
		bean.setLoginAtWsNo( bean.getProperties().getProperty( "client_ip_address" ) ) ;
		bean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
		if((String) hash.get( "mode" )!=null)
			bean.setMode("1") ;

		if((String) hash.get( "locale" )!=null)
			bean.setLanguageId( (String) hash.get( "locale" ) ) ;
		else
			bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		hash.put("HttpRequest", request) ;		
		hash.put("HttpResponse", response) ;
		bean.setAll(hash) ;
		map = bean.validate() ;
		boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
		String validationMessage = map.get("message") == null ? "" :(String)map.get("message")  ;
		validationMessage = bean.replaceNewLineChar( validationMessage );
		//out.println(map);
		MOrderEntryCategTransItem categoryTransactionResult = new MOrderEntryCategTransItem();
		categoryTransactionResult.setCategoryCode(order_category);
		categoryTransactionResult.setCategoryDesc(order_category_desc);
		
		if ( validated ){
			map = bean.apply() ;	
			boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
			map.put( "message",bean.getMessage((String)map.get( "message" ))) ;
			String message = bean.replaceNewLineChar(bean.checkForNull((String)map.get("message")));
			String invalidCode = "" ;
			if(map.get("invalidCode") != null)
        		invalidCode = (String) map.get( "invalidCode" ) ;
			String flag =bean.replaceNewLineChar(bean.checkForNull((String) map.get( "flag" )));
			//out.println("assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" , \"" + invalidCode.trim() + "\") ; ") ;
			//out.println("<br>"+message);
			categoryTransactionResult.setTransactionResult(result);
			categoryTransactionResult.setTransactionRespDesc(message);
		}
		else {
			String invalidCodeVal = "" ;
			if(map.get("invalidCode") != null)
         		 invalidCodeVal = (String) map.get( "invalidCode" ) ;
			String flag =bean.replaceNewLineChar(bean.checkForNull((String) map.get( "flag" )));
			//out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"" + flag + "\","+ "\"" + invalidCodeVal +"\" ) ; ") ;
			 ArrayList<MOrderEntryCatalogTransItem> suspErrorList =  daoImp.validateSuspendedCheck(bean);
			 ArrayList<MOrderEntryCatalogTransItem> apptErrorList =  daoImp.validateAppointment(bean);
			 ArrayList<MOrderEntryCatalogTransItem> duplErrorList =  daoImp.validateDuplCheck(bean);
			 ArrayList<MOrderEntryCatalogTransItem> examConflictErrorList =  daoImp.validateExamConflicts(bean);
			 ArrayList<MOrderEntryCatalogTransItem> panelDuplErrorList =  daoImp.validatePanelDuplCheck(bean);
			 ArrayList<MOrderEntryCatalogTransItem> samePanelDuplErrorList =  daoImp.validateSamePanelDuplCheck(bean);
			/* Validation Error Messages from OrderEntryDuplicate.jsp -- START */
			categoryTransactionResult.setTransactionResult(validated);
			categoryTransactionResult.setTransactionRespDesc(validationMessage);
			categoryTransactionResult.getCatalogTransactionItems().addAll(suspErrorList);
			categoryTransactionResult.getCatalogTransactionItems().addAll(apptErrorList);
			categoryTransactionResult.getCatalogTransactionItems().addAll(duplErrorList);
			categoryTransactionResult.getCatalogTransactionItems().addAll(examConflictErrorList);
			categoryTransactionResult.getCatalogTransactionItems().addAll(panelDuplErrorList);
			categoryTransactionResult.getCatalogTransactionItems().addAll(samePanelDuplErrorList);
		  	
	  		/* if(flag.equals(String.valueOf(OrRepository.SHOW_MODAL_WINDOW))){
		
		  		String dupl_message				= "";  // For Lab is installed and panel dupl check
				String susp_message				= "";  // For Lab is installed and catalog is suspended
				String rd_appt = "";
				int conflict_exam_count_records = 0; int conflict_records = 0,total_records=0,total_dupl_count_records=0;
				int count_patient = 0 , count_chk_records = 0 ;
				int dupl_count_alert			= 0;
				int dupl_count_error			= 0;
				int dupe_reject_count			= 0;
				int new_order_count  			= 0;
				int dupe_record_count			= 0;
				
				ArrayList RejectOrders=new ArrayList();
				ArrayList DuplicateCatalogCodes=new ArrayList();	
				ArrayList dupl_ord_catalogs = new ArrayList();
				ArrayList multi_patient = new ArrayList();
				HashMap mandatoryCatagoryMap = null;
				HashMap NewOrderMap		=new HashMap();
				HashMap DuplicateOrderMap		=new HashMap();
				
				HashMap hashValues				= bean.getAllValues();
				if(hashValues!=null)
				{
					dupl_message		 		= bean.checkForNull((String)hashValues.get("dupl_message"),"");
					susp_message		 		= bean.checkForNull((String)hashValues.get("susp_message"),"");
					rd_appt							= bean.checkForNull((String)hashValues.get("rd_appt"),""); // For Radialogy Appointment
					dupl_count_alert 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_alert"),"0"));
					dupl_count_error 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_error"),"0"));
					conflict_exam_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_exam_count_records"),"0"));
					conflict_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_records"),"0"));
					total_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
					total_dupl_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_dupl_count_records"),"0"));
					//called_from_multi				= bean.checkForNull((String)hashValues.get("called_from_multi"),"");
					count_patient			= (Integer)hashValues.get("count_patient")==null?0:(Integer)hashValues.get("count_patient");
					count_chk_records	= (Integer)hashValues.get("count_chk_records")==null?0:(Integer)hashValues.get("count_chk_records");	
					
					for(int l=1;l<=total_dupl_count_records;l++)
					{
						DuplicateCatalogCodes.add(bean.checkForNull((String)hashValues.get("dupl_catalog_code"+l),""));
						mandatoryCatagoryMap = bean.isDupeMandatoryHashMap(DuplicateCatalogCodes); //IN024984
					}
					for(int l=0;l<dupl_count_error;l++)
					{
						if(!RejectOrders.contains(bean.checkForNull((String)hashValues.get("reject_dupl_catalog_code"+l),"")))
							RejectOrders.add(bean.checkForNull((String)hashValues.get("reject_dupl_catalog_code"+l),""));
					}
					dupe_reject_count = RejectOrders.size();
					for(int dp_orders=0;dp_orders<total_records;dp_orders++)
					{
						if(!DuplicateCatalogCodes.contains((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),""))))
						{			
							NewOrderMap.put((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),"")),(bean.checkForNull((String)hashValues.get("cat_desc"+dp_orders),"")));
						}
						else
						{
							DuplicateOrderMap.put((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),"")),(bean.checkForNull((String)hashValues.get("cat_desc"+dp_orders),"")));
							
						}
					}
					new_order_count = NewOrderMap.size(); //IN047632
					dupe_record_count = total_records - new_order_count; //IN047632
					//multi_pat_catalog_count = dupl_ord_catalogs.size();
					if((dupl_count_error > 0) || (dupl_count_alert > 0) ) // for the duplicate check
					{
						if(NewOrderMap.size()>0)
						{
							out.println("NEW ORDERS");
							Set newmap=NewOrderMap.keySet();
							Iterator iterator 	 = newmap.iterator();
							while( iterator. hasNext() )
							{
								out.println(NewOrderMap.get(iterator.next()));
							}
						}
						if((DuplicateOrderMap.size()>0))
						{
							out.println("DUPLICATE ORDERS");
							int dr=0;
							Set newmap=DuplicateOrderMap.keySet();
							Iterator iterator 	 = newmap.iterator();
							while( iterator. hasNext() )
							{
								String DupDesckey=(String)iterator.next();
								String DupKeyShortDesc = (String)DuplicateOrderMap.get(DupDesckey);
								out.println(DuplicateOrderMap.get(DupDesckey));
								
							}
						}
					}
					else if(conflict_exam_count_records >0) // For the Exam Conflicts for radialogy
					{
						if(conflict_records > 0 ) //That means it can be proceeded
							out.println("Exam Conflicts Found...");
						else  // otherwise cannot proceed further should stop (displaying the last record desc)
						out.println("Exam Conflicts Found...Cannot Proceed...<br>");
						out.println(bean.checkForNull((String)hashValues.get("conflict_reason0"),""));
					}
					else if(rd_appt.equals("X")) 	// For the Radiology , if appointment is there 
					{
						out.println("Other Appointments already exists...");
					}
					else if(!susp_message.equals("")) {  // For Lab Installed and Test Codes and Panel Matching
					  	out.println("<b>"+susp_message+"</b><br> has been Suspended/Invalid.<br> Cannot Proceed...");	
					} else   // For Lab Installed and Test Codes and Panel Matching
						out.println("<b>"+dupl_message+"</b><br> is Already Selected in the Panel.<br> Cannot Proceed...");
					
					
				}
		  	} */
		  		//else if(validationMessage!=null && !validationMessage.equals("")){
		  			//out.println("<br>"+validationMessage);
		  		//}
		  		//else{
		  			//out.println("Error in placing the orders");
		  		//}
		  	}
		  	
		transactionResponse.getCategoryTransactionItems().add(categoryTransactionResult);
		putObjectInBean(or_bean_id,bean,request);
	    
	  
	    
	}//end of for -- Iterating Order Categories
} //end of if
jsonRespString = gson.toJson(transactionResponse);
response.setContentType("application/json");
response.getWriter().write(jsonRespString);

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
