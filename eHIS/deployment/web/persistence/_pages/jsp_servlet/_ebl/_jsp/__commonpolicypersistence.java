package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __commonpolicypersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CommonPolicyPersistence.jsp", 1709114119599L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

 	System.err.println("Entered");
	String params = request.getQueryString();
	
	String beanId = "PayerPolicyInsuranceMasterBean";
	String beanName = "eBL.PolicyInsuranceMasterBean";
	PolicyInsuranceMasterBean policyBean = null;

	String priorityKey = request.getParameter("key");
	
	PolicyInsuranceMasterBean policyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	
	if(policyBeanMain.getMasterMap() == null)
	{
		policyBeanMain.setMasterMap(new HashMap<String,PolicyInsuranceMasterBean>());
	}
	
	HashMap<String,PolicyInsuranceMasterBean> masterMap = policyBeanMain.getMasterMap();
	
	if(!(masterMap == null || masterMap.isEmpty())){
		policyBean = masterMap.get(priorityKey);
	}
	else{
		policyBean = new PolicyInsuranceMasterBean();
	}
	
	if(policyBean == null){
		policyBean = new PolicyInsuranceMasterBean();
	}
	
	if(policyBean.getPolicyMap() == null)
	{
		policyBean.setPolicyMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	if(policyBean.getPopupMap() == null)
	{
		policyBean.setPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	System.err.println("Coming");
	HashMap<String, List<PolicyInsuranceMasterBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > popupMap = policyBean.getPopupMap();
	Connection 	connection = null;
	Boolean siteSpecRefPrice = false;//Added V181013-Aravindh/AAKH-CRF-0107
	System.err.println("Entered2");
	try 
	{
		connection = ConnectionManager.getConnection();
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181013-Aravindh/AAKH-CRF-0107
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		System.err.println("Tab->"+func_mode);
		
		if(func_mode!= null && func_mode.equals("Outpatient"))
		{
			
			
			List<PolicyInsuranceMasterBean> outPatList = new ArrayList<PolicyInsuranceMasterBean>();
			
			PolicyInsuranceMasterBean outPatBean = new PolicyInsuranceMasterBean();
			outPatBean.setCreditAuthReq((String)hash.get("creditAuthReq"));
			outPatBean.setCreditAuthMand((String)hash.get("creditAuthMand"));
			outPatBean.setCreditAuthRef((String)hash.get("defaultCreditAuth"));
			outPatBean.setCovered((String)hash.get("covered"));
			outPatBean.setApprovedDays((String)hash.get("approvedDays"));
			outPatBean.setNoOfDays(((String)hash.get("noOfDays")));
			outPatBean.setApprovedAmt((String)hash.get("approvedAmt"));
			outPatBean.setLimitAmt(((String)hash.get("limitAmt")));
			outPatBean.setCoverageLimitType((String)hash.get("limitType"));
			outPatBean.setMandChkBillGen((String)hash.get("chkBillGen"));
			outPatBean.setMandChkInvoiceGen((String)hash.get("chkInvoiceGen"));
			System.err.println("pesr->"+(String)hash.get("AmtMode"));
			outPatBean.setAmtGrossNet((String)hash.get("AmtMode"));
			outPatBean.setPatCopay((String)hash.get("patCopay"));
			outPatBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			outPatList.add(outPatBean);
				
			policyMap.put("Outpatient", outPatList);
		}
		
		else if(func_mode!= null && func_mode.equals("Inpatient"))
		{
			
			
			List<PolicyInsuranceMasterBean> inPatList = new ArrayList<PolicyInsuranceMasterBean>();
			
			PolicyInsuranceMasterBean inPatBean = new PolicyInsuranceMasterBean();
			inPatBean.setCreditAuthReq((String)hash.get("creditAuthReq"));
			inPatBean.setCreditAuthMand((String)hash.get("creditAuthMand"));
			inPatBean.setCreditAuthRef((String)hash.get("defaultCreditAuth"));
			inPatBean.setCovered((String)hash.get("covered"));
			inPatBean.setApprovedDays((String)hash.get("approvedDays"));
			inPatBean.setNoOfDays(((String)hash.get("noOfDays")));
			inPatBean.setApprovedAmt((String)hash.get("approvedAmt"));
			inPatBean.setLimitAmt(((String)hash.get("limitAmt")));
			inPatBean.setCoverageLimitType((String)hash.get("limitType"));
			inPatBean.setMandChkBillGen((String)hash.get("chkBillGen"));
			inPatBean.setMandChkInvoiceGen((String)hash.get("chkInvoiceGen"));
			System.err.println("pesr->"+(String)hash.get("AmtMode"));
			inPatBean.setAmtGrossNet((String)hash.get("AmtMode"));
			inPatBean.setPatCopay((String)hash.get("patCopay"));
			inPatBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			inPatList.add(inPatBean);
				
			policyMap.put("Inpatient", inPatList);
		}
		
		else if(func_mode!= null && func_mode.equals("External"))
		{
			
			
			List<PolicyInsuranceMasterBean> extList = new ArrayList<PolicyInsuranceMasterBean>();
			
			PolicyInsuranceMasterBean extBean = new PolicyInsuranceMasterBean();
			extBean.setCreditAuthReq((String)hash.get("creditAuthReq"));
			extBean.setCreditAuthMand((String)hash.get("creditAuthMand"));
			extBean.setCreditAuthRef((String)hash.get("defaultCreditAuth"));
			extBean.setCovered((String)hash.get("covered"));
			extBean.setApprovedDays((String)hash.get("approvedDays"));
			extBean.setNoOfDays(((String)hash.get("noOfDays")));
			extBean.setApprovedAmt((String)hash.get("approvedAmt"));
			extBean.setLimitAmt(((String)hash.get("limitAmt")));
			extBean.setCoverageLimitType((String)hash.get("limitType"));
			extBean.setMandChkBillGen((String)hash.get("chkBillGen"));
			extBean.setMandChkInvoiceGen((String)hash.get("chkInvoiceGen"));
			System.err.println("pesr->"+(String)hash.get("AmtMode"));
			extBean.setAmtGrossNet((String)hash.get("AmtMode"));
			extBean.setPatCopay((String)hash.get("patCopay"));
			extBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			extList.add(extBean);
				
			policyMap.put("External", extList);
		}
		
		else if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			System.err.println("count->"+count);
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setAgeGroupDesc((String)hash.get("age_group_" + i));
				covBean.setAgeGroup((String)hash.get("hdn_age_group_" + i));
				covBean.setGender((String)hash.get("gender_" + i));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setClinicNurs((String)hash.get("clinic_" + i));
				covBean.setClinicNursCode((String)hash.get("clinic_code_" + i));
				covBean.setClinicNursDesc((String)hash.get("clinic_desc_" + i));
				covBean.setSpecCode(((String)hash.get("spec_code_" + i)));
				covBean.setSpecDesc((String)hash.get("spec_desc_" + i));
				covBean.setInclExclCriteria(((String)hash.get("incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("bg_desc_" + i));
				covBean.setBillServChk((String)hash.get("bg_chk_" + i));
				
				covBean.setInclExclInd((String)hash.get("incExInd_" + i));
				covBean.setInclExclIndChk((String)hash.get("incExChk_" + i));
				covBean.setInclusionBasis(((String)hash.get("incBasis_" + i)));
				covBean.setValue((String)hash.get("value_" + i));
				covBean.setValueChk1((String)hash.get("valueChk1_" + i));
				covBean.setValueChk2(((String)hash.get("valueChk2_" + i)));
				covBean.setValueChk3((String)hash.get("valueChk3_" + i));
				covBean.setValueChk4((String)hash.get("valueChk4_" + i));
				covBean.setServItemQty((String)hash.get("servItemQty_" + i));
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));
				covBean.setAmtPerVisit((String)hash.get("amtPerVisit_" + i));
				covBean.setAmtPerIPDay((String)hash.get("amtPerIPDay_" + i));
				covBean.setNoOfDays(((String)hash.get("noOfDays_" + i)));
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setRowNumber((String)hash.get("rowNumber" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setPatCopay((String)hash.get("patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
				//Added for AAKH SCF - 0172
				covBean.setEffectiveDate((String)hash.get("effectiveDate" + i));
				if(siteSpecRefPrice) {
					covBean.setCoverRefPrice((String)hash.get("coverRefPrice_" + i));//Added V181013-Aravindh/AAKH-CRF-0107
				}
				covList.add(covBean);
			}
			
			policyMap.put("inclExclCoverage", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("lookup"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setAgeGroupDesc((String)hash.get("age_group_" + i));
				covBean.setAgeGroup((String)hash.get("hdn_age_group_" + i));
				covBean.setGender((String)hash.get("gender_" + i));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setClinicNurs((String)hash.get("clinic_" + i));
				covBean.setClinicNursCode((String)hash.get("clinic_code_" + i));
				covBean.setClinicNursDesc((String)hash.get("clinic_desc_" + i));
				covBean.setSpecCode(((String)hash.get("spec_code_" + i)));
				covBean.setSpecDesc((String)hash.get("spec_desc_" + i));
				covBean.setInclExclCriteria(((String)hash.get("incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("bg_desc_" + i));
				covBean.setBillServChk((String)hash.get("bg_chk_" + i));
				
				covBean.setInclExclInd((String)hash.get("incExInd_" + i));
				covBean.setInclExclIndChk((String)hash.get("incExChk_" + i));
				covBean.setInclusionBasis(((String)hash.get("incBasis_" + i)));
				covBean.setValue((String)hash.get("value_" + i));
				covBean.setValueChk1((String)hash.get("valueChk1_" + i));
				covBean.setValueChk2(((String)hash.get("valueChk2_" + i)));
				covBean.setValueChk3((String)hash.get("valueChk3_" + i));
				covBean.setValueChk4((String)hash.get("valueChk4_" + i));
				covBean.setServItemQty((String)hash.get("servItemQty_" + i));
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));
				covBean.setAmtPerVisit((String)hash.get("amtPerVisit_" + i));
				covBean.setAmtPerIPDay((String)hash.get("amtPerIPDay_" + i));
				covBean.setNoOfDays(((String)hash.get("noOfDays_" + i)));
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setRowNumber((String)hash.get("rowNumber" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setPatCopay((String)hash.get("patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
				if(siteSpecRefPrice) {
					covBean.setCoverRefPrice((String)hash.get("coverRefPrice_" + i));//Added V181025-Aravindh/AAKH-CRF-0107
				}
				//Added for AAKH SCF - 0172
				covBean.setEffectiveDate((String)hash.get("effectiveDate" + i));
				if(!("".equals(covBean.getPatClass()) && "".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getAgeGroup()) && "".equals(covBean.getGender()) && "".equals(covBean.getClinicNursCode())
						&& "".equals(covBean.getSpecCode()) && "".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
				
			}
			
			policyMap.put("inclExclCoverage", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("preApproval"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setAgeGroupDesc((String)hash.get("age_group_" + i));
				covBean.setAgeGroup((String)hash.get("hdn_age_group_" + i));
				covBean.setGender((String)hash.get("gender_" + i));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setClinicNurs((String)hash.get("clinic_" + i));
				covBean.setClinicNursCode((String)hash.get("clinic_code_" + i));
				covBean.setClinicNursDesc((String)hash.get("clinic_desc_" + i));
				covBean.setSpecCode(((String)hash.get("spec_code_" + i)));
				covBean.setSpecDesc((String)hash.get("spec_desc_" + i));
				covBean.setType(((String)hash.get("type_" + i)));
				covBean.setBillServCode((String)hash.get("bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("bg_desc_" + i));
				covBean.setPreApprAmtCapping((String)hash.get("preAppAmt_" + i));
				
				covBean.setPreApprQtyCapping((String)hash.get("preAppQty_" + i));
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));
				
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covList.add(covBean);
			}
			
			policyMap.put("preApproval", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("lookupPreApproval"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setAgeGroupDesc((String)hash.get("age_group_" + i));
				covBean.setAgeGroup((String)hash.get("hdn_age_group_" + i));
				covBean.setGender((String)hash.get("gender_" + i));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setClinicNurs((String)hash.get("clinic_" + i));
				covBean.setClinicNursCode((String)hash.get("clinic_code_" + i));
				covBean.setClinicNursDesc((String)hash.get("clinic_desc_" + i));
				covBean.setSpecCode(((String)hash.get("spec_code_" + i)));
				covBean.setSpecDesc((String)hash.get("spec_desc_" + i));
				covBean.setType(((String)hash.get("type_" + i)));
				covBean.setBillServCode((String)hash.get("bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("bg_desc_" + i));
				covBean.setPreApprAmtCapping((String)hash.get("preAppAmt_" + i));
				
				covBean.setPreApprQtyCapping((String)hash.get("preAppQty_" + i));
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));
				covBean.setSplitReqd(((String)hash.get("splitReqd_" + i)));
				
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				if(!("".equals(covBean.getPatClass()) && "".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getAgeGroup()) && "".equals(covBean.getGender()) && "".equals(covBean.getClinicNursCode())
						&& "".equals(covBean.getSpecCode()) && "".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
			}
			
			policyMap.put("preApproval", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("popup"))
		{

			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();

				covBean.setInclExclCriteria(((String)hash.get("pop_incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("pop_bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("pop_bg_desc_" + i));
				
				covBean.setInclExclInd((String)hash.get("pop_incExInd_" + i));
				covBean.setInclusionBasis(((String)hash.get("pop_incBasis_" + i)));
				covBean.setValue((String)hash.get("pop_value_" + i));
				covBean.setServItemQty((String)hash.get("pop_servItemQty_" + i));
				
				covBean.setAmtPerVisit((String)hash.get("pop_amtPerVisit_" + i));
				covBean.setAmtPerIPDay((String)hash.get("pop_amtPerIPDay_" + i));
				covBean.setNoOfDays(((String)hash.get("pop_noOfDays_" + i)));
				covBean.setStartDate((String)hash.get("pop_effFrom_" + i));
				covBean.setEndDate((String)hash.get("pop_effTo_" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setStatus((String)hash.get("pop_rowStatus" + i));
				covBean.setDelFlag((String)hash.get("pop_delFlag" + i));
				covBean.setPatCopay((String)hash.get("pop_patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("pop_patLimitAmt_" + i));
				//Added for AAKH SCF - 0172
				covBean.setEffectiveDate((String)hash.get("pop_effectiveDate" + i));
				covList.add(covBean);
			}
			
			popupMap.put(rowNumber, covList);
		}
		
		else if(func_mode!= null && func_mode.equals("lookupPreApprovalPopup"))
		{

			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			for(int i=1; i<=count;i++){
				covBean = new PolicyInsuranceMasterBean();

				covBean.setInclExclCriteria(((String)hash.get("pop_incExCriteria_" + i)));
				covBean.setBillServCode((String)hash.get("pop_bg_code_" + i));
				covBean.setBillServDesc((String)hash.get("pop_bg_desc_" + i));
				
				covBean.setInclExclInd((String)hash.get("pop_incExInd_" + i));
				covBean.setInclusionBasis(((String)hash.get("pop_incBasis_" + i)));
				covBean.setValue((String)hash.get("pop_value_" + i));
				covBean.setServItemQty((String)hash.get("pop_servItemQty_" + i));
				
				covBean.setAmtPerVisit((String)hash.get("pop_amtPerVisit_" + i));
				covBean.setAmtPerIPDay((String)hash.get("pop_amtPerIPDay_" + i));
				covBean.setNoOfDays(((String)hash.get("pop_noOfDays_" + i)));
				covBean.setStartDate((String)hash.get("pop_effFrom_" + i));
				covBean.setEndDate((String)hash.get("pop_effTo_" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setStatus((String)hash.get("pop_rowStatus" + i));
				covBean.setDelFlag((String)hash.get("pop_delFlag" + i));
				covBean.setPatCopay((String)hash.get("pop_patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("pop_patLimitAmt_" + i));
				//Added for AAKH SCF - 0172
				covBean.setEffectiveDate((String)hash.get("pop_effectiveDate" + i));
				if(!( "".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
			}
			
			popupMap.put(rowNumber, covList);
		}
		
		else if(func_mode!= null && func_mode.equals("infoFrame"))
		{
			
			policyBean.setFacilityId((String)hash.get("facility"));
			policyBean.setPayer((String)hash.get("payerGroup1"));
			policyBean.setPayerCode((String)hash.get("payerCode"));
			policyBean.setPolicySettlementApplicability((String)hash.get("settlementApplicability"));
			policyBean.setScreeningPolicy((String)hash.get("screeningPolicy"));
			policyBean.setPayerGroup(((String)hash.get("payerGroup2")));
			policyBean.setPayerGroupCode((String)hash.get("payerCode2"));
			policyBean.setStartDate(((String)hash.get("startDate")));
			policyBean.setPolicyType((String)hash.get("policyType"));
			policyBean.setPolicyTypeCode((String)hash.get("policyTypeCode"));
			
			policyBean.setEndDate((String)hash.get("endDate"));
			policyBean.setCoverageBasis(((String)hash.get("coverageBasis")));

			policyBean.setCoverageRules((String)hash.get("coverageRules"));
			policyBean.setCoveragePer((String)hash.get("percent"));
			policyBean.setStartDateChk((String)hash.get("startDateChk"));
			policyBean.setExpiryDays((String)hash.get("expDays"));


		}
		
		else if(func_mode!= null && func_mode.equals("serviceCoverage"))
		{
			
			policyBean.setDefInclExclCriteria((String)hash.get("defaultCriteria"));
			policyBean.setOverRideInclExcl((String)hash.get("overrideInclExcl"));
			policyBean.setCovInclOthPayers((String)hash.get("coverageIclu"));
			policyBean.setLastPayer((String)hash.get("lastPayer"));		
			policyBean.setCoveragePer((String)hash.get("percent"));
			policyBean.setCoverageBasis((String)hash.get("coverageBasis"));
			policyBean.setCoverageRules((String)hash.get("coverageRules"));
			
			policyBean.setPolicyTypeCode((String)hash.get("policy"));
			policyBean.setPayerCode((String)hash.get("payer"));
			policyBean.setPayerGroupCode((String)hash.get("payerGroup"));
			policyBean.setStartDate(((String)hash.get("startDate")));
			policyBean.setEndDate((String)hash.get("endDate"));
			
//			Commented by DhanasekarV  on  3/10/2013
			
			policyBean.setPolicyOrEncounter((String)hash.get("prevEncValues"));
			if(siteSpecRefPrice) {
				policyBean.setCoverRefPrice((String)hash.get("coverRefPriceHdr"));//Added V181003-Aravindh/AAKH-CRF-0107
			}

		}
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.out.println("Exception from BLDischargeValidation :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}

	masterMap.put(priorityKey, policyBean);
	putObjectInBean("PayerPolicyInsuranceMasterBean",policyBeanMain,request);


            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
