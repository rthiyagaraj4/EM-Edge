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
import blPolicy.EncounterSpecificDefinitionBean;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import org.apache.commons.codec.binary.Base64;

public final class __encounterspecpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/EncounterSpecPersistence.jsp", 1731393555543L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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


     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
    private String checkForStatus(String inputString) {
 		return (inputString == null|| "".equals(inputString)) ? "I" : inputString;
 	}
     

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

/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			V220629             			 	MOHE-CRF-0114				Manivel Natarajan
2			V230228								MMS-DM-CRF-0209.5			Namrata Charate
----------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	String params = request.getQueryString();
	
	String beanId = "bl_EncounterSpecificDefinitionBean" ;
	String beanName = "blPolicy.EncounterSpecificDefinitionBean";
	
	String beanId1 = "bl_EncSpecMFDRBean" ;  
	String beanName1 = "eBL.EncSpecMFDRBean";
	EncSpecMFDRBean policyBean1 = (EncSpecMFDRBean) getBeanObject(beanId1, beanName1, request); //V230228
	String facility_id = (String)session.getAttribute("facility_id");
	EncounterSpecificDefinitionBean policyBean = (EncounterSpecificDefinitionBean) getBeanObject(beanId, beanName, request);
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
	Boolean SiteSpecGroupService = false;
	String SiteSpecGroupServiceInd = "";
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS-->
	String partSql = "";
	String partExclSql = "";
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	EncounterSpecificDefinitionBean fmtDtlsBean = null;
	List<EncounterSpecificDefinitionBean> policyList = null;
	if(policyBean.getPolicyMap() == null)
	{
		policyBean.setPolicyMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}
	
	if(policyBean.getPopupMap() == null)
	{
		policyBean.setPopupMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}
	
	System.err.println("check for diag popup");
	if(policyBean.getDiagPopupMap() == null)
	{
		System.err.println("diag popup is null");
		policyBean.setDiagPopupMap(new HashMap<String, List<EncounterSpecificDefinitionBean>>());
	}		
	
	if(policyBean.getRestrictionMap() == null){
		policyBean.setRestrictionMap(new HashMap<String,String>());
	}
	
	//V230228
	if(policyBean1.getPolicyMap() == null){
		policyBean1.setPolicyMap(new HashMap<String, List<EncSpecMFDRBean>>());
	}
	HashMap<String, List<EncounterSpecificDefinitionBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<EncounterSpecificDefinitionBean> > popupMap = policyBean.getPopupMap();
	HashMap<String, List<EncounterSpecificDefinitionBean> > diagPopupMap = policyBean.getDiagPopupMap();//Added for MOHE-CRF-0114
	HashMap<String,String> restrictionMap = policyBean.getRestrictionMap();
	HashMap<String, List<EncSpecMFDRBean> > policyMap1 = policyBean1.getPolicyMap();  //V230228
	
	Connection 	connection = null;
	Boolean siteSpecRefPrice = false;//Added V181003-Aravindh/AAKH-CRF-0107
	try 
	{
		connection = ConnectionManager.getConnection();
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181003-Aravindh/AAKH-CRF-0107
		//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
		SiteSpecGroupService = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_GROUP_SRVICE_IND");
		if (SiteSpecGroupService) {
			SiteSpecGroupServiceInd = "Y";
		} else {
			SiteSpecGroupServiceInd = "N";
		}
		//MMS-QH-CRF-0170-US-4   Ram kumar S 28/08/2020 ENDS-->
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		System.err.println("func_mode:"+func_mode);
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	   	hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		
		if(func_mode!= null && func_mode.equals("Outpatient"))
		{			
			List<EncounterSpecificDefinitionBean> outPatList = new ArrayList<EncounterSpecificDefinitionBean>();
			
			EncounterSpecificDefinitionBean outPatBean = new EncounterSpecificDefinitionBean();
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
			outPatBean.setAmtGrossNet((String)hash.get("AmtMode"));
			outPatBean.setPolicyApplicability((String)hash.get("applicability"));
			outPatBean.setPatCopay((String)hash.get("patCopay"));
			outPatBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			outPatBean.setEncSpecMFDRYN((String)hash.get("mfdrLink"));  //V230228
			outPatList.add(outPatBean);
				
			policyMap.put("Outpatient", outPatList);
		}
		
		else if(func_mode!= null && func_mode.equals("Inpatient"))
		{			
			List<EncounterSpecificDefinitionBean> inPatList = new ArrayList<EncounterSpecificDefinitionBean>();
			
			EncounterSpecificDefinitionBean inPatBean = new EncounterSpecificDefinitionBean();
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
			inPatBean.setAmtGrossNet((String)hash.get("AmtMode"));
			inPatBean.setPolicyApplicability((String)hash.get("applicability"));
			inPatBean.setPatCopay((String)hash.get("patCopay"));
			inPatBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			inPatBean.setEncSpecMFDRYN((String)hash.get("mfdrLink"));   //V230228
			inPatList.add(inPatBean);
				
			policyMap.put("Inpatient", inPatList);
		}
		
		else if(func_mode!= null && func_mode.equals("External"))
		{			
			List<EncounterSpecificDefinitionBean> extList = new ArrayList<EncounterSpecificDefinitionBean>();
			
			EncounterSpecificDefinitionBean extBean = new EncounterSpecificDefinitionBean();
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
			extBean.setAmtGrossNet((String)hash.get("AmtMode"));
			extBean.setPolicyApplicability((String)hash.get("applicability"));
			extBean.setPatCopay((String)hash.get("patCopay"));
			extBean.setPatLimitAmt((String)hash.get("patLimitAmt"));
			extBean.setEncSpecMFDRYN((String)hash.get("mfdrLink"));   //V230228
			extList.add(extBean);
				
			policyMap.put("External", extList);
		}
		
		else if(func_mode!= null && func_mode.equals("inclExclCoverage"))
		{			
			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();
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
				System.out.println("bg_chk"+(String)hash.get("bg_chk_" + i));
				System.out.println("includeHomeMedication "+(String)hash.get("includeHomeMedication" + i));
				covBean.setIncludeHomeMedication((String)hash.get("includeHomeMedication" + i));
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
				covBean.setEffectiveDate((String)hash.get("hdnEffDate_"+ i));
				//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 -->
				if("Y".equals(SiteSpecGroupServiceInd)){
					 covBean.setGroupRservice((String)hash.get("GroupServiceInd_" + i));
				}
				if(siteSpecRefPrice) {
				covBean.setCoverRefPrice((String)hash.get("coverRefPrice_" + i));//Added V181003-Aravindh/AAKH-CRF-0107
				}
				covBean.setExlinclacrossenc((String)hash.get("Exlinclacrossenc_"+ i)); //Added V190326-Dhananjay/MMS-DM-CRF-0158
				covBean.setDiagCopaySetup(((String)hash.get("chkDiagBasedCopayYN_" + i)));//Added for MOHE-CRF-0114
				if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPatClass()) && "".equals(covBean.getAgeGroup()) && "".equals(covBean.getGender()) && "".equals(covBean.getClinicNursCode()) && "".equals(covBean.getSpecCode()) && "".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
			}
			
			policyMap.put("inclExclCoverage", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("preApproval"))
		{		
			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();
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
				covBean.setPreApprDurCapping((String)hash.get("preAppDur_" + i)); //Added V180725-Gayathri/MMS-DM-CRF-0126
				covBean.setServLimit(((String)hash.get("serviceLmt_" + i)));
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setStatus((String)hash.get("rowStatus" + i));
				covBean.setDelFlag((String)hash.get("delFlag" + i));
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));				
				covBean.setPreacrossenc((String) hash.get("Preacrossenc_" + i)); //Added V190326-Dhananjay/MMS-DM-CRF-0158
				//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 -->
				if("Y".equals(SiteSpecGroupServiceInd)){
					covBean.setGroupRservice((String)hash.get("preGroupServiceInd_" + i));
				}
				if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPatClass()) && "".equals(covBean.getAgeGroup()) && "".equals(covBean.getGender()) && "".equals(covBean.getClinicNursCode()) && "".equals(covBean.getSpecCode()) && "".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
			}
			
			policyMap.put("preApproval", covList);
		}
		
		else if(func_mode!= null && func_mode.equals("popup"))
		{

			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			String rowNumber = (String)hash.get("rowNumber");
			for(int i=1; i<=count;i++){
				covBean = new EncounterSpecificDefinitionBean();

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
				covBean.setEffectiveDate((String)hash.get("hdnEffDate_"+ i));
				if(!("".equals(covBean.getBillServCode()))){
					covList.add(covBean);
				}
			}
			
			popupMap.put(rowNumber, covList);
		}
		else if(func_mode!= null && func_mode.equals("diagpopup"))//Added for MOHE-CRF-0114
		{
			System.err.println("Inside diagpopup1:"+(String)hash.get("rowNumber"));
			List<EncounterSpecificDefinitionBean> covList = new ArrayList<EncounterSpecificDefinitionBean>();
			EncounterSpecificDefinitionBean covBean = null;
			int count = Integer.parseInt((String)hash.get("inclRowCount"));
			System.err.println("Inside diagpopup1.1.1:"+count);
			String rowNumber = (String)hash.get("rowNumber");
			for(int i=1; i<=count;i++){
				System.err.println("Inside diagpopup1.1:");
				covBean = new EncounterSpecificDefinitionBean();
System.err.println("Inside diagpopup1.2:");
				covBean.setDiagType(((String)hash.get("popDiag_diagType_" + i)));
				covBean.setDiagPatCopay((String)hash.get("popDiag_copay_" + i));
				covBean.setDiagStartDate((String)hash.get("popDiag_effFrom_" + i));
				covBean.setDiagEndDate((String)hash.get("popDiag_effTo_" + i));
				covBean.setDiagStatus((String)hash.get("popDiag_rowStatus" + i));
				covBean.setDiagDelFlag((String)hash.get("popDiag_delFlag" + i));
System.err.println("Inside diagpopup1.3:"+covBean.getDiagType());

				if(!("".equals(covBean.getDiagType()))){
					covList.add(covBean);
				}
System.err.println("Inside diagpopup1.4:");				
			}			
			System.err.println("Inside diagpopup2 rowNumber:"+rowNumber);
			System.err.println("Inside diagpopup2 covList:"+covList);
			diagPopupMap.put(rowNumber, covList);
			System.err.println("Inside diagpopup3:");
		}
		else if(func_mode!= null && func_mode.equals("infoFrame"))
		{
			policyBean.setFacilityId(facility_id);
			policyBean.setPayerCode((String)hash.get("payer"));
			policyBean.setPayerGroupCode((String)hash.get("payerGroup"));
			policyBean.setPolicyTypeCode((String)hash.get("policy"));
			policyBean.setPatientId((String)hash.get("patient_id"));
			
			policyBean.setVisitId((String)hash.get("visitId"));
			policyBean.setAccEntityID((String)hash.get("acctSeq"));
			policyBean.setPriority((String)hash.get("priority"));
			policyBean.setPolicyNo((String)hash.get("policyNo"));
			policyBean.setEpisodeId((String)hash.get("episodeId"));
			policyBean.setEpisodeType((String)hash.get("episodeType"));
			policyBean.setRecalcCharges((String)hash.get("recalc_charges"));
			
			
			if(("I".equals(policyBean.getEpisodeType())) || ("D".equals(policyBean.getEpisodeType()))){
				partSql = " and hdr.episode_type = ? and hdr.episode_id = ?  and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			else if(("O".equals(policyBean.getEpisodeType())) || ("E".equals(policyBean.getEpisodeType()))){
				partSql = " and hdr.episode_type = ? and hdr.episode_id = ? and hdr.visit_id =? and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			else if("R".equals(policyBean.getEpisodeType())){
				partSql = " and hdr.episode_type = ?  and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			String sqlFetchHdr = "Select encounter_id,status,ill_ded_amt, vst_ded_amt,pol_ref_cust_code,blng_grp_id,to_char(nvl(hdr.effective_from,sysdate),'dd/mm/yyyy') effective_from from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? "+partSql;
			pstmt = connection.prepareStatement(sqlFetchHdr);
			
			pstmt.setString(1,policyBean.getFacilityId());
			pstmt.setString(2,policyBean.getPayerGroupCode());
			pstmt.setString(3,policyBean.getPayerCode());
			pstmt.setString(4,policyBean.getPolicyTypeCode());
			pstmt.setString(5,policyBean.getPatientId());
			if(("I".equals(policyBean.getEpisodeType())) || ("D".equals(policyBean.getEpisodeType()))){
				pstmt.setString(6,policyBean.getEpisodeType());
				pstmt.setString(7,policyBean.getEpisodeId());
				pstmt.setString(8,policyBean.getAccEntityID());
				pstmt.setString(9,policyBean.getPriority());
				pstmt.setString(10,policyBean.getPolicyNo());
			}
			else if(("O".equals(policyBean.getEpisodeType())) || ("E".equals(policyBean.getEpisodeType()))){
				pstmt.setString(6,policyBean.getEpisodeType());
				pstmt.setString(7,policyBean.getEpisodeId());
				pstmt.setString(8,policyBean.getVisitId());
				pstmt.setString(9,policyBean.getAccEntityID());
				pstmt.setString(10,policyBean.getPriority());
				pstmt.setString(11,policyBean.getPolicyNo());
			}
			else if("R".equals(policyBean.getEpisodeType())){
				pstmt.setString(6,policyBean.getEpisodeType());
				pstmt.setString(7,policyBean.getAccEntityID());
				pstmt.setString(8,policyBean.getPriority());
				pstmt.setString(9,policyBean.getPolicyNo());
			}
			
			rst = pstmt.executeQuery();
			if(rst!=null){
				while (rst.next()) {
					policyBean.setEncounterId(rst.getString("encounter_id"));
					policyBean.setIllDedAmt(rst.getString("ill_ded_amt"));
					policyBean.setVstDedAmt(rst.getString("vst_ded_amt"));
					policyBean.setPolRefCustCode(rst.getString("pol_ref_cust_code"));
					policyBean.setStatus(rst.getString("status"));
					policyBean.setBlngGrpid(rst.getString("blng_grp_id"));
					policyBean.setStartDate(rst.getString("effective_from"));
				}
			}
		

		}
		
		else if(func_mode!= null && func_mode.equals("serviceCoverage"))
		{
			
			policyBean.setDefInclExclCriteria((String)hash.get("defaultCriteria"));
			policyBean.setOverRideInclExcl((String)hash.get("overrideInclExcl"));
			policyBean.setCovInclOthPayers((String)hash.get("coverageIclu"));
			policyBean.setLastPayer((String)hash.get("lastPayer"));
			policyBean.setCoverageBasis((String)hash.get("coverageBasis"));
			policyBean.setCoveragePer((String)hash.get("percent"));
			policyBean.setCoverageRules((String)hash.get("coverageRules"));
			if((String)hash.get("encGrpId") == null || "null".equals((String)hash.get("encGrpId"))){
				policyBean.setAcrossGroupId("");
			}
			else{
				policyBean.setAcrossGroupId((String)hash.get("encGrpId"));
			}
			if(siteSpecRefPrice) {
			policyBean.setCoverRefPrice((String)hash.get("coverRefPriceHdr"));//Added V181003-Aravindh/AAKH-CRF-0107
			}
			if("true".equals((String)hash.get("siteSpecPolApprv"))) {
				policyBean.setPolicyApproved((String)hash.get("policyApprvdYN"));//Added V190523-Aravindh/NMC-JD-CRF-0010
			}
			//Added V190523 MuthuN/NMC-JD-CRF-0002-1.1 Start
			if("true".equals((String)hash.get("siteSpecClaimExist"))) {		
				policyBean.setclaimsAgrmtExts((String)hash.get("ClaimsAgrmtExts"));
			}
			//Added V190523 MuthuN/NMC-JD-CRF-0002-1.1 End
		}
		
		//Persisting values to bean when user clicks on any row from lookup window
		else if(func_mode!= null && func_mode.equals("inclExclCoverageLookup"))
		{
			List<EncounterSpecificDefinitionBean> covList = policyMap.get("inclExclCoverage");
			policyList = new ArrayList<EncounterSpecificDefinitionBean>();
			if(covList == null){
				covList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			String payerGroup = request.getParameter("payergroupCode");
			String payer = request.getParameter("payerCode");
			String policy = request.getParameter("policyCode");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String patientId = request.getParameter("patientId");
			String visitId = request.getParameter("visitId");
			String acctSeq = request.getParameter("acctSeq");
			String priority = request.getParameter("priority");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String epsdEnc = request.getParameter("epsdEnc");
			String patClass = request.getParameter("patClass");
			String ageGrp = request.getParameter("ageGrp");
			String gender = request.getParameter("gender");
			String clinicNurs = request.getParameter("clinicNurs");
			String clinicNursCode = request.getParameter("clinicNursCode");
			String specCode = request.getParameter("specCode");
			String criteria = request.getParameter("criteria");
			String billServCode = request.getParameter("billServCode");
			
			if(restrictionMap.containsKey("C~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate)){
				out.println("No");
			}
			else{
			
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
					partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_ID");
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
					partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_OE");
				}
				else if("R".equals(episodeType)){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
					partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_R");
				}
				
				
				sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_FIRST_PART")+partExclSql+BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART")+partSql +
						"and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
						" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";
				System.err.println("sqlCoverage in EncounterPersistance.jsp:"+sqlCoverage);
				pstmt = connection.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,payerGroup);
				pstmt.setString(7,payer);
				pstmt.setString(8,policy);
				pstmt.setString(9,patientId);
				
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					pstmt.setString(10,episodeType);
					pstmt.setString(11,episodeId);
					pstmt.setString(12,acctSeq);
					pstmt.setString(13,priority);
					
					pstmt.setString(14,facilityId);
					pstmt.setString(15,payerGroup);
					pstmt.setString(16,payer);
					pstmt.setString(17,policy);
					pstmt.setString(18,patientId);
					
					pstmt.setString(19,episodeType);
					pstmt.setString(20,episodeId);
					pstmt.setString(21,acctSeq);
					pstmt.setString(22,priority);
					
					pstmt.setString(23,criteria);
					pstmt.setString(24,billServCode);
					pstmt.setString(25,patClass);
					pstmt.setString(26,epsdEnc);
					pstmt.setString(27,gender);
					pstmt.setString(28,ageGrp);
					pstmt.setString(29,clinicNurs);
					pstmt.setString(30,clinicNursCode);
					pstmt.setString(31,specCode);
					pstmt.setString(32,startDate);

				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					pstmt.setString(10,episodeType);
					pstmt.setString(11,episodeId);
					pstmt.setString(12,visitId);
					pstmt.setString(13,acctSeq);
					pstmt.setString(14,priority);
					
					pstmt.setString(15,facilityId);
					pstmt.setString(16,payerGroup);
					pstmt.setString(17,payer);
					pstmt.setString(18,policy);
					pstmt.setString(19,patientId);
					
					pstmt.setString(20,episodeType);
					pstmt.setString(21,episodeId);
					pstmt.setString(22,visitId);
					pstmt.setString(23,acctSeq);
					pstmt.setString(24,priority);
					
					pstmt.setString(25,criteria);
					pstmt.setString(26,billServCode);
					pstmt.setString(27,patClass);
					pstmt.setString(28,epsdEnc);
					pstmt.setString(29,gender);
					pstmt.setString(30,ageGrp);
					pstmt.setString(31,clinicNurs);
					pstmt.setString(32,clinicNursCode);
					pstmt.setString(33,specCode);
					pstmt.setString(34,startDate);
				}
				else if("R".equals(episodeType)){
					
					pstmt.setString(10,episodeType);
					pstmt.setString(11,acctSeq);
					pstmt.setString(12,priority);
					
					pstmt.setString(13,facilityId);
					pstmt.setString(14,payerGroup);
					pstmt.setString(15,payer);
					pstmt.setString(16,policy);
					pstmt.setString(17,patientId);
					
					pstmt.setString(18,episodeType);
					pstmt.setString(19,acctSeq);
					pstmt.setString(20,priority);
					
					pstmt.setString(21,criteria);
					pstmt.setString(22,billServCode);
					pstmt.setString(23,patClass);
					pstmt.setString(24,epsdEnc);
					pstmt.setString(25,gender);
					pstmt.setString(26,ageGrp);
					pstmt.setString(27,clinicNurs);
					pstmt.setString(28,clinicNursCode);
					pstmt.setString(29,specCode);
					pstmt.setString(30,startDate);
				}
				

				rst = pstmt.executeQuery();
			
				int rsCnt = 0;
				if(rst!=null){
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					
					while (rst.next()) {
						fmtDtlsBean = new EncounterSpecificDefinitionBean();
						fmtDtlsBean.setPatClass(rst.getString("patient_class"));
						fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
						fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
						fmtDtlsBean.setGender(rst.getString("SEX"));
						fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
						fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
						fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
						fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
						fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
						fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
						fmtDtlsBean.setInclExclCriteria(rst.getString("serv_excl_incl_crit"));
						fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
						fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
						fmtDtlsBean.setIncludeHomeMedication(rst.getString("INCL_HOME_MEDICATION_YN"));
						fmtDtlsBean.setBillServChk(rst.getString("special_service_yn"));
						fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
						fmtDtlsBean.setInclExclIndChk(rst.getString("ovride_incl_excl_yn"));
						fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
						if(Integer.parseInt(rst.getString("total"))>0){
							fmtDtlsBean.setServLimit("Y");
						}
						else{
							fmtDtlsBean.setServLimit("N");
						}
						fmtDtlsBean.setValue(rst.getString("copay_val"));
						fmtDtlsBean.setValueChk1(rst.getString("include_policy_level_copay_yn"));
						fmtDtlsBean.setValueChk2(rst.getString("pre_approval_yn"));
						fmtDtlsBean.setValueChk3(rst.getString("cumm_cvrg_with_oth_payers_yn"));
						fmtDtlsBean.setValueChk4(rst.getString("last_payer_coverage_yn"));
						fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
						fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
						fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
						fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
						fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
						fmtDtlsBean.setEffectiveDate(rst.getString("effective_date"));
						fmtDtlsBean.setStatus("U");
						//Group Service INdicator Added
						if("Y".equals(SiteSpecGroupServiceInd)){
							fmtDtlsBean.setGroupServInd(rst.getString("group_service_ind"));
						}
						if(siteSpecRefPrice) {
						fmtDtlsBean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181003-Aravindh/AAKH-CRF-0107
						}
						fmtDtlsBean.setExlinclacrossenc(rst.getString("across_enc_exlincl_yn")); //Added V190326-Dhananjay/MMS-DM-CRF-0158
						fmtDtlsBean.setDiagCopaySetup(rst.getString("DIAG_BASED_COPAY_DEFN"));//Added for MOHE-CRF-0114
						System.out.println("PERS     UUUUUUUUUUUUUUUUUUU");
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}
					
					if(rsCnt<1){
	
						EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
						policyList = new ArrayList<EncounterSpecificDefinitionBean>();
						policyList.add(titleBean);
					}
				}
				else{
					EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					policyList.add(titleBean);
				}
				
				if(rsCnt>0){
					covList.addAll(policyList);
				}
				
				policyMap.put("inclExclCoverage", covList);
				restrictionMap.put("C~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate,"Y");
			}
		}
		
		else if(func_mode!= null && func_mode.equals("preApprovalLookup")){
			
			List<EncounterSpecificDefinitionBean> covList = policyMap.get("preApproval");
			policyList = new ArrayList<EncounterSpecificDefinitionBean>();
			if(covList == null){
				covList = new ArrayList<EncounterSpecificDefinitionBean>();
			}
			
			String payerGroup = request.getParameter("payergroupCode");
			String payer = request.getParameter("payerCode");
			String policy = request.getParameter("policyCode");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String patientId = request.getParameter("patientId");
			String visitId = request.getParameter("visitId");
			String acctSeq = request.getParameter("acctSeq");
			String priority = request.getParameter("priority");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String epsdEnc = request.getParameter("epsdEnc");
			String patClass = request.getParameter("patClass");
			String ageGrp = request.getParameter("ageGrp");
			String gender = request.getParameter("gender");
			String clinicNurs = request.getParameter("clinicNurs");
			String clinicNursCode = request.getParameter("clinicNursCode");
			String specCode = request.getParameter("specCode");
			String criteria = request.getParameter("criteria");
			String billServCode = request.getParameter("billServCode");
			
			if(restrictionMap.containsKey("P~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate)){
				out.println("No");
			}
			else{
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
				}
				else if("R".equals(episodeType)){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
				}
				
				sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL")+partSql+
						" and hdr.serv_excl_incl_crit = ? and hdr.blng_serv_code = ? and hdr.patient_class = ? And Hdr.Episode_Or_Encounter_Flag = ? AND hdr.SEX  = ? "+
						" AND hdr.AGE_GROUP_CODE = ? AND hdr.CLINIC_NURSING_IND = ? AND hdr.CLINIC_NURSING_CODE = ? And Hdr.SPLTY_CODE = ? AND to_char(hdr.EFFECTIVE_FROM,'dd/mm/yyyy')  = ? ";


				pstmt = connection.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,payerGroup);
				pstmt.setString(7,payer);
				pstmt.setString(8,policy);
				pstmt.setString(9,patientId);
				
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					pstmt.setString(10,episodeType);
					pstmt.setString(11,episodeId);
					pstmt.setString(12,acctSeq);
					pstmt.setString(13,priority);
					
					pstmt.setString(14,criteria);
					pstmt.setString(15,billServCode);
					pstmt.setString(16,patClass);
					pstmt.setString(17,epsdEnc);
					pstmt.setString(18,gender);
					pstmt.setString(19,ageGrp);
					pstmt.setString(20,clinicNurs);
					pstmt.setString(21,clinicNursCode);
					pstmt.setString(22,specCode);
					pstmt.setString(23,startDate);

				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					pstmt.setString(10,episodeType);
					pstmt.setString(11,episodeId);
					pstmt.setString(12,visitId);
					pstmt.setString(13,acctSeq);
					pstmt.setString(14,priority);
					
					pstmt.setString(15,criteria);
					pstmt.setString(16,billServCode);
					pstmt.setString(17,patClass);
					pstmt.setString(18,epsdEnc);
					pstmt.setString(19,gender);
					pstmt.setString(20,ageGrp);
					pstmt.setString(21,clinicNurs);
					pstmt.setString(22,clinicNursCode);
					pstmt.setString(23,specCode);
					pstmt.setString(24,startDate);
					
				}
				else if("R".equals(episodeType)){
					
					pstmt.setString(10,episodeType);
					pstmt.setString(11,acctSeq);
					pstmt.setString(12,priority);
					
					pstmt.setString(13,criteria);
					pstmt.setString(14,billServCode);
					pstmt.setString(15,patClass);
					pstmt.setString(16,epsdEnc);
					pstmt.setString(17,gender);
					pstmt.setString(18,ageGrp);
					pstmt.setString(19,clinicNurs);
					pstmt.setString(10,clinicNursCode);
					pstmt.setString(21,specCode);
					pstmt.setString(22,startDate);
					
				}
				rst = pstmt.executeQuery();
				

				int rsCnt = 0;
				if(rst!=null){
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					
					while (rst.next()) {
						fmtDtlsBean = new EncounterSpecificDefinitionBean();
						fmtDtlsBean.setPatClass(rst.getString("patient_class"));
						fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
						fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
						fmtDtlsBean.setGender(rst.getString("SEX"));
						fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
						fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
						fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
						fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
						fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
						fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
						fmtDtlsBean.setType(rst.getString("serv_excl_incl_crit"));
						fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
						fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
						fmtDtlsBean.setPreApprAmtCapping(rst.getString("preapproval_amt_capping"));
						fmtDtlsBean.setPreApprQtyCapping(rst.getString("preapproval_qty_capping"));
						fmtDtlsBean.setPreApprDurCapping(rst.getString("preapproval_dur_capping"));
						fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
						fmtDtlsBean.setPreacrossenc(rst.getString("ACROSS_ENC_PREAPP_YN")); //Added V190326-Dhananjay/MMS-DM-CRF-0158
						fmtDtlsBean.setStatus("U");
						if("Y".equals(SiteSpecGroupServiceInd)){
							fmtDtlsBean.setGroupServInd(rst.getString("group_service_ind"));
						}
						policyList.add(fmtDtlsBean);
						rsCnt++;					
					}
					if(rsCnt<1){
						EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
						titleBean.setStartDate(startDate);
						titleBean.setEndDate(endDate);
						policyList = new ArrayList<EncounterSpecificDefinitionBean>();
						policyList.add(titleBean);
					}
				}
				else{
					EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
					titleBean.setStartDate(startDate);
					titleBean.setEndDate(endDate);
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					policyList.add(titleBean);
				}
				
				if(rsCnt>0){
					covList.addAll(policyList);
				}
				
				policyMap.put("preApproval", covList);
				restrictionMap.put("P~"+epsdEnc+"~"+patClass+"~"+ageGrp+"~"+gender+"~"+clinicNurs+"~"+clinicNursCode+"~"+specCode+"~"+criteria+"~"+billServCode+"~"+startDate,"Y");
			}
		}
		
		else if(func_mode!= null && func_mode.equals("preApprovalPopupLookup")){

			String payerGroup = request.getParameter("payergroupCode");
			String payer = request.getParameter("payerCode");
			String policy = request.getParameter("policyCode");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String policyNo = request.getParameter("policyNo");
			String patientId = request.getParameter("patientId");
			String visitId = request.getParameter("visitId");
			String acctSeq = request.getParameter("acctSeq");
			String priority = request.getParameter("priority");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String policyEncounter = request.getParameter("policyEncounter");
			String encEpsd = request.getParameter("epsdEnc");
			String patClass = request.getParameter("patClass");
			String ageGroup = request.getParameter("ageGrp");
			String gender = request.getParameter("gender");
			String clinicNursInd = request.getParameter("clinicNurs");
			String clinicNursCode = request.getParameter("clinicNursCode");
			String spltyCode = request.getParameter("specCode");
			String criteria = request.getParameter("criteria");
			String blngCode = request.getParameter("billServCode");
			
			String rowNumber = request.getParameter("rowNumber");
			String criteriaPop = request.getParameter("criteriaPop");
			String billServCodePop = request.getParameter("billServCodePop");
			String startDatePop = request.getParameter("startDatePop");
			
			if(restrictionMap.containsKey("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
					criteriaPop+"~"+billServCodePop+"~"+startDatePop)){
				out.println("No");
			}
			else{
				List<EncounterSpecificDefinitionBean> popupList = popupMap.get(rowNumber);
	
				if(popupList == null){
					popupList = new ArrayList<EncounterSpecificDefinitionBean>();	
				}
			
			
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
				}
				else if("R".equals(episodeType)){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
				}
				
				sqlCoverage =  BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL_POPUP")+partSql+
						" and hdr.EXCL_SERV_EXCL_INCL_CRIT = ? and hdr.EXCL_BLNG_SERV_CODE = ? and TO_CHAR (hdr.EXCL_EFFECTIVE_FROM, 'dd/mm/yyyy') = ?";


				pstmt = connection.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,payerGroup);
				pstmt.setString(4,payer);
				pstmt.setString(5,policy);
				pstmt.setString(6,criteria);
				pstmt.setString(7,blngCode);
				pstmt.setString(8,patClass);
				pstmt.setString(9,patientId);
				
				pstmt.setString(10,encEpsd);
				pstmt.setString(11,gender);
				pstmt.setString(12,ageGroup);
				pstmt.setString(13,clinicNursInd);
				pstmt.setString(14,clinicNursCode);
				pstmt.setString(15,spltyCode);
				pstmt.setString(16,startDate);
				
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					pstmt.setString(17,episodeType);
					pstmt.setString(18,episodeId);
					pstmt.setString(19,acctSeq);
					pstmt.setString(20,priority);
					
					pstmt.setString(21,criteriaPop);
					pstmt.setString(22,billServCodePop);
					pstmt.setString(23,startDatePop);

				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					pstmt.setString(17,episodeType);
					pstmt.setString(18,episodeId);
					pstmt.setString(19,visitId);
					pstmt.setString(20,acctSeq);
					pstmt.setString(21,priority);
					
					pstmt.setString(22,criteriaPop);
					pstmt.setString(23,billServCodePop);
					pstmt.setString(24,startDatePop);
					
				}
				else if("R".equals(episodeType)){
					
					pstmt.setString(17,episodeType);
					pstmt.setString(18,acctSeq);
					pstmt.setString(19,priority);
					
					pstmt.setString(20,criteriaPop);
					pstmt.setString(21,billServCodePop);
					pstmt.setString(22,startDatePop);
					
				}
				
				rst = pstmt.executeQuery();
			
				int rsCnt = 0;
				if(rst!=null){
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					
					while (rst.next()) {
						fmtDtlsBean = new EncounterSpecificDefinitionBean();
	
						fmtDtlsBean.setInclExclCriteria(rst.getString("excl_serv_excl_incl_crit"));
						fmtDtlsBean.setBillServCode(rst.getString("excl_blng_serv_code"));
						fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
						fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
						fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
						fmtDtlsBean.setValue(rst.getString("copay_val"));
						fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
						fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
						fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
						fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
						fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
						fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
						fmtDtlsBean.setEffectiveDate(rst.getString("effective_date"));
						fmtDtlsBean.setStatus("U");
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}
					
					if(rsCnt<1){
						EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
						titleBean.setStartDate(startDate);
						titleBean.setEndDate(endDate);
						policyList = new ArrayList<EncounterSpecificDefinitionBean>();
						policyList.add(titleBean);
					}
				}
				else{
					EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
					titleBean.setStartDate(startDate);
					titleBean.setEndDate(endDate);
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					policyList.add(titleBean);
				}		
				
				if(rsCnt>0){
					popupList.addAll(policyList);
				}
				
				popupMap.put(rowNumber, popupList);
				restrictionMap.put("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
						criteriaPop+"~"+billServCodePop+"~"+startDatePop,"Y");
			}
		}
		else if(func_mode!= null && func_mode.equals("diagCopayPopupLoad")){//Added for MOHE-CRF-0114
			try{
				String payerGroup = request.getParameter("payergroupCode");
				String payer = request.getParameter("payerCode");
				String policy = request.getParameter("policyCode");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				String policyNo = request.getParameter("policyNo");
//				String patientId = request.getParameter("patientId");
				String patientId ="";
				if("Y".equals(request.getParameter("compressed")==null?"":request.getParameter("compressed"))) {
						patientId = new String(Base64.decodeBase64(((String)request.getParameter("patientId")).getBytes())); 
				}else{
					patientId = checkForNull(request.getParameter("patientId"));
				}
				String visitId = request.getParameter("visitId");
				String acctSeq = request.getParameter("acctSeq");
				String priority = request.getParameter("priority");
				String episodeType = request.getParameter("episodeType");
				String episodeId = request.getParameter("episodeId");				
				String policyEncounter = request.getParameter("policyEncounter");
				String encEpsd = request.getParameter("epsdEnc");
				String patClass = request.getParameter("patClass");
				String ageGroup = request.getParameter("ageGrp");
				String gender = request.getParameter("gender");
				String clinicNursInd = request.getParameter("clinicNurs");
				String clinicNursCode = request.getParameter("clinicNursCode");
				String spltyCode = request.getParameter("specCode");
				String criteria = request.getParameter("criteria");
				String blngCode = request.getParameter("billServCode");
				
				String rowNumber = request.getParameter("rowNumber");
				String criteriaPop = request.getParameter("criteriaPop");
				String billServCodePop = request.getParameter("billServCodePop");
				String startDatePop = request.getParameter("startDatePop");
				/*if(restrictionMap.containsKey("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+
						gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
						criteriaPop+"~"+billServCodePop+"~"+startDatePop)) {
									
					out.println("No");
				}
				else{*/
				List<EncounterSpecificDefinitionBean> popupList = diagPopupMap.get(rowNumber);
				System.err.println("popupList in diagCopayPopupLoad:"+popupList);
				System.err.println("rowNumber in diagCopayPopupLoad:"+rowNumber);
				if(popupList == null){
					popupList = new ArrayList<EncounterSpecificDefinitionBean>();	
														
					
				String sqlForDiagCopay =  "SELECT DIAGNOSIS_TYPE, COPAY, to_char(DIAG_EFFECTIVE_FROM,'dd/mm/yyyy') DIAG_EFFECTIVE_FROM, to_char(DIAG_EFFECTIVE_TO,'dd/mm/yyyy') DIAG_EFFECTIVE_TO FROM bl_insu_policy_addl_diag "+
							   " WHERE OPERATING_FACILITY_ID = '"+ facility_id +"'"+
							   " AND PATIENT_ID = '" + patientId +"'"+
							   " AND CUST_GROUP_CODE = '"+ payerGroup +"'"+
							   " AND CUST_CODE = '"+ payer +"'"+
							   " AND POLICY_TYPE_CODE = '"+ policy +"'"+
							   " AND SERV_EXCL_INCL_CRIT = '"+ criteria +"'"+
							   " AND PATIENT_CLASS = '"+ patClass +"'"+
							   " AND SEX = '"+ gender +"'"+
							   " AND AGE_GROUP_CODE = '"+ ageGroup +"'"+
							   " AND BLNG_SERV_CODE = '"+ blngCode +"'"+
							   " AND EPISODE_OR_ENCOUNTER_FLAG = '"+ encEpsd +"'"+
							   " AND CLINIC_NURSING_IND = '" + clinicNursInd +"'"+
							   " AND CLINIC_NURSING_CODE = '" + clinicNursCode +"'"+
							   " AND SPLTY_CODE = '" + spltyCode +"'"+
							   " AND TO_CHAR (EFFECTIVE_FROM, 'dd/mm/yyyy') = '" + startDate +"'";							   
							   
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					sqlForDiagCopay = sqlForDiagCopay + "and episode_type = '"+episodeType+"' and episode_id = "+episodeId+"  and acct_seq_no = nvl("+acctSeq+",acct_seq_no) and priority = "+priority;
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					sqlForDiagCopay = sqlForDiagCopay + " and episode_type = '"+episodeType+"' and episode_id = "+episodeId+" and visit_id = "+visitId+" and acct_seq_no = nvl("+acctSeq+",acct_seq_no) and priority = "+priority;	
				}
				else if("R".equals(episodeType)){
					sqlForDiagCopay = sqlForDiagCopay + "and episode_type = '"+episodeType+"'  and acct_seq_no = nvl("+acctSeq+",acct_seq_no) and priority = "+priority;
				}
				
				sqlForDiagCopay = sqlForDiagCopay + " ORDER BY DIAG_EFFECTIVE_FROM";
				System.err.println("sql in diag popup load data:"+sqlForDiagCopay);
				pstmt = connection.prepareStatement(sqlForDiagCopay);
				rst = pstmt.executeQuery();
				
				int rsCnt = 0;
				if(rst!=null){
					System.err.println("Inside Resultset loop");
					
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					System.err.println("Inside Resultset loop1");
					while (rst.next()) {
						System.err.println("Inside Resultset loop2");
						fmtDtlsBean = new EncounterSpecificDefinitionBean();
						System.err.println("Inside Resultset loop3");
						System.err.println("sql data:"+rst.getString("DIAGNOSIS_TYPE")+"/"+rst.getString("COPAY")+"/"+rst.getString("DIAG_EFFECTIVE_FROM")+"/"+rst.getString("DIAG_EFFECTIVE_TO"));
						fmtDtlsBean.setDiagType(rst.getString("DIAGNOSIS_TYPE"));
						fmtDtlsBean.setDiagPatCopay(rst.getString("COPAY"));
						fmtDtlsBean.setDiagStartDate(rst.getString("DIAG_EFFECTIVE_FROM"));
						fmtDtlsBean.setDiagEndDate(rst.getString("DIAG_EFFECTIVE_TO"));
						fmtDtlsBean.setDiagStatus("U");
						fmtDtlsBean.setDiagDelFlag("");
						
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}												
				}
				
				if(rsCnt>0){
					popupList.addAll(policyList);
				}
				
				diagPopupMap.put(rowNumber, popupList);
				restrictionMap.put("E~"+encEpsd+"~"+patClass+"~"+ageGroup+"~"+
						gender+"~"+clinicNursInd+"~"+clinicNursCode+"~"+spltyCode+"~"+criteria+"~"+blngCode+"~"+startDate+"~"+
						criteriaPop+"~"+billServCodePop+"~"+startDatePop, "Y");
				}			//}
			}
			catch(Exception e){
				System.err.println("Exception inside diagCopayPopupLoad:"+e);
			}
		}
		else if(func_mode!= null && func_mode.equals("ServicesAndItemsCategoryDetails")){   //Added for V230228
				System.err.println("Function Mode in ServicesAndItemsCategoryDetails:"+func_mode);
				List<EncSpecMFDRBean> covList = new ArrayList<EncSpecMFDRBean>();
				EncSpecMFDRBean covBean = null;
				int cnt = Integer.parseInt((String)hash.get("rowCount"));
				System.err.println("Rowcount is:"+cnt);
				
				for(int i=1; i<=cnt; i++){
					covBean = new EncSpecMFDRBean();
					System.err.println("covList is:"); 
					System.err.println("Status is:"+hash.get("rowStatus_"+i));
					covBean.setFacilityId((String)hash.get("facility_id"));
					covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
					System.err.println(hash.get("episode_" + i));
					covBean.setPatClass((String)hash.get("ptClass_" + i));
					System.err.println(hash.get("ptClass_" + i));
					covBean.setPayerGroup((String)hash.get("payer_group_desc_"+i));
					System.err.println(hash.get("payer_group_desc_" + i));
					covBean.setPayerGroupCode((String)hash.get("payer_group_code_"+i));
					System.err.println(hash.get("payer_group_code_" + i));
					covBean.setPayer((String)hash.get("payer_desc_"+i));
					System.err.println(hash.get("payer_desc_" + i));
					covBean.setPayerCode((String)hash.get("payer_code_"+i));
					System.err.println(hash.get("payer_code_" + i));
					covBean.setPolicyType((String)hash.get("policy_type_desc_"+i));
					System.err.println(hash.get("policy_type_desc_" + i));
					covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
					System.err.println(hash.get("policy_type_code_" + i));
					covBean.setInclExclCriteria((String)hash.get("incl_excl_criteria_"+i));
					System.err.println(hash.get("incl_excl_criteria_" + i));
					covBean.setServiceDetailsDesc((String)hash.get("service_dtls_desc_"+i));
					System.err.println(hash.get("service_dtls_desc_" + i));
					covBean.setServiceDetailsCode((String)hash.get("service_dtls_code_"+i));
					System.err.println(hash.get("service_dtls_code_" + i));
					covBean.setClinicProc((String)hash.get("clinic_"+i));
					System.err.println(hash.get("clinic_" + i));
					covBean.setClinicProcCode((String)hash.get("clinic_code_"+i));
					System.err.println(hash.get("clinic_code_" + i));
					covBean.setClinicProcDesc((String)hash.get("clinic_desc_"+i));
					System.err.println(hash.get("clinic_desc_" + i));
					covBean.setReferral((String)hash.get("referral_"+i));
					System.err.println(hash.get("referral_" + i));
					covBean.setClinicCat((String)hash.get("clinic_category_"+i));
					System.err.println(hash.get("clinic_category_" + i));					
					covBean.setPatCopay((String)hash.get("patCopay_" + i));
					System.err.println(hash.get("patCopay_" + i));
					covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
					System.err.println(hash.get("patLimitAmt_" + i));
					covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
					System.err.println(hash.get("AmtMode_" + i));
					covBean.setAcrossEncYN((String)hash.get("across_enc_YN_" + i));  //V230801
					covBean.setStartDate((String)hash.get("effFrom_" + i));
					System.err.println(hash.get("effFrom_" + i));
					covBean.setEndDate((String)hash.get("effTo_" + i));
					System.err.println(hash.get("effTo_" + i));
					covBean.setOldEndDate((String)hash.get("oldEndDate_" + i));
					System.err.println(hash.get("oldEndDate_" + i));
					covBean.setStatus((String)hash.get("rowStatus_" + i));
					System.err.println(hash.get("rowStatus_" + i));
					covBean.setRowNumber((String)hash.get("rowNumber_" + i)); 
					System.err.println(hash.get("rowNumber_" + i));
					
					covBean.setPatientId((String)hash.get("patientId")); 
					covBean.setEpisodeType((String)hash.get("episodeType")); 
					covBean.setEpisodeId((String)hash.get("episodeId")); 
					covBean.setVisitId((String)hash.get("visitId")); 
					covBean.setEncounterId((String)hash.get("encounterId")); 
					covBean.setAccSeqNo((String)hash.get("accSeqNo")); 
					covBean.setPriority((String)hash.get("priority")); 
					
					if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPayerGroup()) && "".equals(covBean.getPayerGroupCode()) && "".equals(covBean.getPayer()) && "".equals(covBean.getPayerCode()) && "".equals(covBean.getPolicyType()) && "".equals(covBean.getPolicyTypeCode()) && "".equals(covBean.getInclExclCriteria()) && "".equals(covBean.getServiceDetailsDesc()) && "".equals(covBean.getServiceDetailsCode()) && "".equals(covBean.getReferral()) && "".equals(covBean.getClinicCat()) && "".equals(covBean.getPatCopay()) && "".equals(covBean.getPatLimitAmt()) && "".equals(covBean.getStartDate()))){
						covList.add(covBean); 
					}  
					System.err.println("covList .."+covList.isEmpty());
				}  
				if(!(covList.isEmpty()))
					policyMap1.put("ServicesAndItemsCatDtlsPageInfo", covList); 
				
			}
		//Ends
		
		//On click of Lookup Starts
		
		//Ends
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from EncounterSpecPersistence.jsp :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}

	putObjectInBean("bl_EncounterSpecificDefinitionBean",policyBean,request);
	putObjectInBean("bl_EncSpecMFDRBean",policyBean1,request);  //V230228
	


            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
