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

public final class __commonpolicydeletepersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CommonPolicyDeletePersistence.jsp", 1709114118912L ,"10.3.6.0","Asia/Calcutta")) return true;
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
	
	HashMap<String, List<PolicyInsuranceMasterBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > popupMap = policyBean.getPopupMap();
	Connection 	connection = null;

	//Delete Definitions
	/*String deletedBeanId = "DeletedPayerPolicyBean";
	PolicyInsuranceMasterBean deletedPolicyBean = null;
	
	PolicyInsuranceMasterBean deletedPolicyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(deletedBeanId, beanName, request);
	
	if(deletedPolicyBeanMain.getMasterMap() == null)
	{
		deletedPolicyBeanMain.setMasterMap(new HashMap<String,PolicyInsuranceMasterBean>());
	}
	
	HashMap<String,PolicyInsuranceMasterBean> deletedMasterMap = deletedPolicyBeanMain.getMasterMap();
	
	if(!(deletedMasterMap == null || deletedMasterMap.isEmpty())){
		deletedPolicyBean = deletedMasterMap.get(priorityKey);
	}
	else{
		deletedPolicyBean = new PolicyInsuranceMasterBean();
	}
	
	if(deletedPolicyBean == null){
		deletedPolicyBean = new PolicyInsuranceMasterBean();
	}
	
	if(deletedPolicyBean.getPolicyMap() == null)
	{
		deletedPolicyBean.setPolicyMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	if(deletedPolicyBean.getPopupMap() == null)
	{
		deletedPolicyBean.setPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
	}
	
	HashMap<String, List<PolicyInsuranceMasterBean> > deletedPolicyMap = deletedPolicyBean.getPolicyMap();
	HashMap<String, List<PolicyInsuranceMasterBean> > deletedPopupMap = deletedPolicyBean.getPopupMap();*/
	//Delete Definitions
	try 
	{
		connection = ConnectionManager.getConnection();
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
		
		if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			//Delete Definitions
			/*List<PolicyInsuranceMasterBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<PolicyInsuranceMasterBean>();
			}*/
			
			int delCnt = 0;
			//Delete Definitions
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
				//Delete Definitions
				if("Y".equals((String)hash.get("delFlag" + i))){
					/*if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}*/
					popupMap.remove(Integer.toString(i-delCnt));
					//deletedPopupMap.remove(Integer.toString(i-delCnt));
					int k = i-delCnt+1;
					for(int j=k;j<=count-delCnt;j++){
						popupMap.put(Integer.toString(j-1), popupMap.get(Integer.toString(j)));
						//deletedPopupMap.put(Integer.toString(j-1), deletedPopupMap.get(Integer.toString(j)));
					}
					for(int l=count-delCnt;l<=count;l++){
						popupMap.put(Integer.toString(l), null);
						//deletedPopupMap.put(Integer.toString(l), null);
					}
					delCnt++;
				}
				else{
					covList.add(covBean);
				}
				//System.err.println("Cov List Size->"+covList.size());
				//Delete Definitions
			}
			if(covList.size() == 0){
				covList.add(new PolicyInsuranceMasterBean());
			}
			policyMap.put("inclExclCoverage", covList);
			//Delete Definitions
			//deletedPolicyMap.put("inclExclCoverage", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("preApproval"))
		{
			
			
			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			//Delete Definitions
			/*List<PolicyInsuranceMasterBean> deletedCovList = deletedPolicyMap.get("preApproval");
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<PolicyInsuranceMasterBean>();
			}*/
			
			//Delete Definitions
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
				//Added for AAKH SCF - 0172
				covBean.setEffectiveDate((String)hash.get("effectiveDate" + i));
				//Delete Definitions
				/*if("Y".equals((String)hash.get("delFlag" + i))){
					if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}
				}
				else{
					covList.add(covBean);
				}*/
				if(!("Y".equals((String)hash.get("delFlag" + i)))){
					covList.add(covBean);
				}
				//Delete Definitions
				
			}
			if(covList.size() == 0){
				covList.add(new PolicyInsuranceMasterBean());
			}
			policyMap.put("preApproval", covList);
			//Delete Definitions
			//deletedPolicyMap.put("preApproval", deletedCovList);
			//Delete Definitions
		}
		
		else if(func_mode!= null && func_mode.equals("popup"))
		{

			List<PolicyInsuranceMasterBean> covList = new ArrayList<PolicyInsuranceMasterBean>();
			
			PolicyInsuranceMasterBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			//Delete Definitions
			/*List<PolicyInsuranceMasterBean> deletedCovList = deletedPopupMap.get(rowNumber);
			
			if(deletedCovList == null){
				deletedCovList = new ArrayList<PolicyInsuranceMasterBean>();
			}*/
			
			//Delete Definitions
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
				//Delete Definitions
				/*if("Y".equals((String)hash.get("pop_delFlag" + i))){
					if("U".equals(covBean.getStatus())){
						deletedCovList.add(covBean);
					}
				}
				else{
					covList.add(covBean);
				}*/
				if(!("Y".equals((String)hash.get("pop_delFlag" + i)))){
					covList.add(covBean);
				}
				//Delete Definitions
			}
			if(covList.size() == 0){
				covList.add(new PolicyInsuranceMasterBean());
			}
			popupMap.put(rowNumber, covList);
			//Delete Definitions
			//deletedPopupMap.put(rowNumber, deletedCovList);
			//Delete Definitions
		}
		
		/*else if(func_mode!= null && func_mode.equals("MergeBeans")){
			List<PolicyInsuranceMasterBean> covList = policyMap.get("inclExclCoverage");
			List<PolicyInsuranceMasterBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
			if(covList != null && deletedCovList != null){
				covList.addAll(deletedCovList);
			}
			
			policyMap.put("inclExclCoverage", covList);
			
			covList = null;
			deletedCovList = null;
			
			covList = policyMap.get("preApproval");
			deletedCovList = deletedPolicyMap.get("preApproval");
			if(covList != null && deletedCovList != null){
				covList.addAll(deletedCovList);
			}
			
			policyMap.put("preApproval", covList);
			
			for (Iterator iterator = popupMap.keySet().iterator(); iterator
					.hasNext();) {
				String keyVal = (String) iterator
						.next();
				if(popupMap.get(keyVal) != null && deletedPopupMap.get(keyVal) != null){
					covList = popupMap.get(keyVal);
					deletedCovList = deletedPopupMap.get(keyVal);
					covList.addAll(deletedCovList);
					popupMap.put(keyVal, covList);
				}
				
			}
			deletedPolicyBean = new PolicyInsuranceMasterBean();
		}*/
		
	
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
	
	//Delete Definitions
	/*deletedMasterMap.put(priorityKey, deletedPolicyBean);
	putObjectInBean(deletedBeanId,deletedPolicyBeanMain,request);*/
	//Delete Definitions


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
