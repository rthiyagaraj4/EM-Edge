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

public final class __multifactordeductrulepersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MultiFactorDeductRulePersistence.jsp", 1709114127974L ,"10.3.6.0","Asia/Calcutta")) return true;
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
/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
 2			V230801		   48394	   			MMS-DM-SCF-0898-TF			Namrata Charate
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	System.err.println("Persitence file called.deff.");
	String params = request.getQueryString();
	String beanId = "bl_MultiFactorDeductRuleBean";
	String beanName = "eBL.MultiFactorDeductRuleBean";
	System.err.println("Drug category Persitence file called..");
	
	String beanID1 = "bl_MFDRDiagCatBean";
	String beanName1 = "eBL.MFDRDiagCatBean";
	System.err.println("Diagnosis category Persitence file called..");
	
	String beanID2 = "bl_MFDRServicesAndItemsBean";
	String beanName2 = "eBL.MFDRServicesAndItemsBean";
	System.err.println("Services and Items category Persitence file called..");
	 
	
	MultiFactorDeductRuleBean policyBean = (MultiFactorDeductRuleBean) getBeanObject(beanId, beanName, request);
	MFDRDiagCatBean policyBean1 = (MFDRDiagCatBean) getBeanObject(beanID1, beanName1, request);
	MFDRServicesAndItemsBean policyBean2 = (MFDRServicesAndItemsBean) getBeanObject(beanID2, beanName2, request);;
	
	if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<MultiFactorDeductRuleBean>>());
	}
	if(policyBean1.getPolicyMap() == null){
		policyBean1.setPolicyMap(new HashMap<String, List<MFDRDiagCatBean>>());
	}
	if(policyBean2.getPolicyMap() == null){
		policyBean2.setPolicyMap(new HashMap<String, List<MFDRServicesAndItemsBean>>());
	}
	System.err.println("Persitence file called..123");
	HashMap<String, List<MultiFactorDeductRuleBean> > policyMap = policyBean.getPolicyMap();
	HashMap<String, List<MFDRDiagCatBean> > policyMap1 = policyBean1.getPolicyMap();
	HashMap<String, List<MFDRServicesAndItemsBean> > policyMap2 = policyBean2.getPolicyMap();
	
	try 
	{
	
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
	
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    	hash = (Hashtable)hash.get( "SEARCH" ) ;	
			
			String facilityId = (String)session.getValue( "facility_id" ) ;
			String loggedInUser = (String)session.getValue("login_user");	
			String mode = (String)hash.get("mode");		
			
			if(func_mode!= null && func_mode.equals("DrugCategoryDetails"))
			{			
			System.err.println("Function Mode:"+func_mode);
			List<MultiFactorDeductRuleBean> covList = new ArrayList<MultiFactorDeductRuleBean>();
			MultiFactorDeductRuleBean covBean = null;
			int cnt = Integer.parseInt((String)hash.get("rowCount"));
			
			System.err.println("Rowcount is:"+cnt);
			
			for(int i=1; i<=cnt; i++){
				covBean = new MultiFactorDeductRuleBean();
				System.err.println("covList is:"); 
				System.err.println("Status is:"+hash.get("rowStatus_"+i));
				covBean.setFacilityId((String)hash.get("facility_id"));
				covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
				covBean.setPatClass((String)hash.get("ptClass_" + i));
				covBean.setPayerGroup((String)hash.get("payer_group_desc_"+i));
				covBean.setPayerGroupCode((String)hash.get("payer_group_code_"+i));
				covBean.setPayer((String)hash.get("payer_desc_"+i));
				covBean.setPayerCode((String)hash.get("payer_code_"+i));
				covBean.setPolicyType((String)hash.get("policy_type_desc_"+i));
				covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
				covBean.setDrugCategory((String)hash.get("drug_category_"+i));
				covBean.setPatCopay((String)hash.get("patCopay_" + i));
				covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
				covBean.setAcrossEncYN((String)hash.get("across_enc_YN_" + i));  //V230801
				covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
				covBean.setStartDate((String)hash.get("effFrom_" + i));
				covBean.setEndDate((String)hash.get("effTo_" + i));
				covBean.setOldEndDate((String)hash.get("oldEndDate_" + i));
				covBean.setStatus((String)hash.get("rowStatus_" + i));
				covBean.setRowNumber((String)hash.get("rowNumber_" + i)); 
				
				if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPayerGroup()) && "".equals(covBean.getPayerGroupCode()) && "".equals(covBean.getPayer()) && "".equals(covBean.getPayerCode()) && "".equals(covBean.getPolicyType()) && "".equals(covBean.getPolicyTypeCode()) && "".equals(covBean.getDrugCategory()) && "".equals(covBean.getPatCopay()) && "".equals(covBean.getPatLimitAmt()) && "".equals(covBean.getStartDate()))){
					covList.add(covBean); 
				}  
			//	covList.add(covBean);
				System.err.println("covList .."+covList.isEmpty());
			}  
			if(!(covList.isEmpty()))
				policyMap.put("DrugCategoryDetailsPageInfo", covList);
			} 
			else if(func_mode!= null && func_mode.equals("DiagnosisCategoryDetails")){
				System.err.println("Function Mode:"+func_mode);
				List<MFDRDiagCatBean> covList = new ArrayList<MFDRDiagCatBean>();
				MFDRDiagCatBean covBean = null;
				int cnt = Integer.parseInt((String)hash.get("rowCount"));
				System.err.println("Rowcount is:"+cnt);
				
				for(int i=1; i<=cnt; i++){
					covBean = new MFDRDiagCatBean();
					System.err.println("covList is:"); 
					System.err.println("Status is:"+hash.get("rowStatus_"+i));
					covBean.setFacilityId((String)hash.get("facility_id"));
					covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
					covBean.setPatClass((String)hash.get("ptClass_" + i));
					covBean.setPayerGroup((String)hash.get("payer_group_desc_"+i));
					covBean.setPayerGroupCode((String)hash.get("payer_group_code_"+i));
					covBean.setPayer((String)hash.get("payer_desc_"+i));
					covBean.setPayerCode((String)hash.get("payer_code_"+i));
					covBean.setPolicyType((String)hash.get("policy_type_desc_"+i));
					covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
					covBean.setDiagCat((String)hash.get("diag_category_"+i));
					covBean.setPatCopay((String)hash.get("patCopay_" + i));
					covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
					covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
					covBean.setStartDate((String)hash.get("effFrom_" + i));
					covBean.setEndDate((String)hash.get("effTo_" + i));
					covBean.setOldEndDate((String)hash.get("oldEndDate_" + i));
					covBean.setStatus((String)hash.get("rowStatus_" + i));
					System.err.println(hash.get("rowStatus_" + i));
					covBean.setRowNumber((String)hash.get("rowNumber_" + i)); 
					
					if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPayerGroup()) && "".equals(covBean.getPayerGroupCode()) && "".equals(covBean.getPayer()) && "".equals(covBean.getPayerCode()) && "".equals(covBean.getPolicyType()) && "".equals(covBean.getPolicyTypeCode()) && "".equals(covBean.getDiagCat()) && "".equals(covBean.getPatCopay()) && "".equals(covBean.getPatLimitAmt()) && "".equals(covBean.getStartDate()))){
						covList.add(covBean); 
					}  
				//	covList.add(covBean); 
					System.err.println("covList .."+covList.isEmpty());
				}  
				if(!(covList.isEmpty()))
					policyMap1.put("DiagCatDtlsPageInfo", covList);
				
			} /* V230210 starts */
			else if(func_mode!= null && func_mode.equals("ServicesAndItemsCategoryDetails")){
				System.err.println("Function Mode in ServicesAndItemsCategoryDetails:"+func_mode);
				List<MFDRServicesAndItemsBean> covList = new ArrayList<MFDRServicesAndItemsBean>();
				MFDRServicesAndItemsBean covBean = null;
				int cnt = Integer.parseInt((String)hash.get("rowCount"));
				System.err.println("Rowcount is:"+cnt);
				
				for(int i=1; i<=cnt; i++){
					covBean = new MFDRServicesAndItemsBean();
					System.err.println("covList is:"); 
					System.err.println("Status is:"+hash.get("rowStatus_"+i));
					covBean.setFacilityId((String)hash.get("facility_id"));
					covBean.setEpisodeEncounter((String)hash.get("episode_" + i));
					covBean.setPatClass((String)hash.get("ptClass_" + i));
					covBean.setPayerGroup((String)hash.get("payer_group_desc_"+i));
					covBean.setPayerGroupCode((String)hash.get("payer_group_code_"+i));
					covBean.setPayer((String)hash.get("payer_desc_"+i));
					covBean.setPayerCode((String)hash.get("payer_code_"+i));
					covBean.setPolicyType((String)hash.get("policy_type_desc_"+i));
					covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
					covBean.setInclExclCriteria((String)hash.get("incl_excl_criteria_"+i));
					covBean.setServiceDetailsDesc((String)hash.get("service_dtls_desc_"+i));
					covBean.setServiceDetailsCode((String)hash.get("service_dtls_code_"+i));
					covBean.setClinicProc((String)hash.get("clinic_"+i));
					covBean.setClinicProcCode((String)hash.get("clinic_code_"+i));
					covBean.setClinicProcDesc((String)hash.get("clinic_desc_"+i));
					covBean.setReferral((String)hash.get("referral_"+i));
					covBean.setClinicCat((String)hash.get("clinic_category_"+i));				
					covBean.setPatCopay((String)hash.get("patCopay_" + i));
					covBean.setPatLimitAmt((String)hash.get("patLimitAmt_" + i));
					covBean.setAmtGrossNet((String)hash.get("AmtMode_" + i));
					covBean.setAcrossEncYN((String)hash.get("across_enc_YN_" + i));  //V230801
					covBean.setStartDate((String)hash.get("effFrom_" + i));
					covBean.setEndDate((String)hash.get("effTo_" + i));
					covBean.setOldEndDate((String)hash.get("oldEndDate_" + i));
					covBean.setStatus((String)hash.get("rowStatus_" + i));
					System.err.println(hash.get("rowStatus_" + i));
					covBean.setRowNumber((String)hash.get("rowNumber_" + i)); 
					
					if(!("".equals(covBean.getEpisodeEncounter()) && "".equals(covBean.getPayerGroup()) && "".equals(covBean.getPayerGroupCode()) && "".equals(covBean.getPayer()) && "".equals(covBean.getPayerCode()) && "".equals(covBean.getPolicyType()) && "".equals(covBean.getPolicyTypeCode()) && "".equals(covBean.getInclExclCriteria()) && "".equals(covBean.getServiceDetailsDesc()) && "".equals(covBean.getServiceDetailsCode()) && "".equals(covBean.getReferral()) && "".equals(covBean.getClinicCat()) && "".equals(covBean.getPatCopay()) && "".equals(covBean.getPatLimitAmt()) && "".equals(covBean.getStartDate()))){
						covList.add(covBean); 
					}  
					System.err.println("covList .."+covList.isEmpty());
				}  
				if(!(covList.isEmpty()))
					policyMap2.put("ServicesAndItemsCatDtlsPageInfo", covList); 
				
			}  /* V230210 ends */
		System.err.println("Data is in Policy Map..");
		
	
		
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println("Exception from BLDischargeValidation :" + e);
	} 
	putObjectInBean("bl_MultiFactorDeductRuleBean",policyBean,request);   
	putObjectInBean("bl_MFDRDiagCatBean",policyBean1,request); 
	putObjectInBean("bl_MFDRServicesAndItemsBean",policyBean2,request); 
	
	
	

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
