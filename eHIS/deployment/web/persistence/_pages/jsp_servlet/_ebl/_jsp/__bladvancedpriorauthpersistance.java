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

public final class __bladvancedpriorauthpersistance extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLAdvancedPriorAuthPersistance.jsp", 1713248478390L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n\r\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	System.err.println("Persitence file called");
	String params = request.getQueryString();
	String beanId = "bl_BLAdvancedPriorAuthBean";
	String beanName = "eBL.BLAdvancedPriorAuthBean";
	System.err.println("Drug category Persitence file called..");
	
	
	BLAdvancedPriorAuthBean policyBean = (BLAdvancedPriorAuthBean) getBeanObject(beanId, beanName, request);
	
	if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<BLAdvancedPriorAuthBean>>());
	}
	
	HashMap<String, List<BLAdvancedPriorAuthBean> > policyMap = policyBean.getPolicyMap();
	
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
			List<BLAdvancedPriorAuthBean> covList = new ArrayList<BLAdvancedPriorAuthBean>();
			BLAdvancedPriorAuthBean covBean = null;
			int cnt = Integer.parseInt((String)hash.get("totalServices"));
			
			System.err.println("Rowcount is:"+cnt);
			
			for(int i=1; i<=cnt; i++){
				covBean = new BLAdvancedPriorAuthBean();
				System.err.println("covList is: "+hash.toString()); 
				System.err.println("check_service_ is:"+(String)hash.get("check_service_"+i));
				System.err.println("request_id_ is:"+(String)hash.get("request_id_"+i));
				System.err.println("seq_no_ is:"+(String)hash.get("seq_no_"+i));
				System.err.println("int_response_id_ is:"+(String)hash.get("int_response_id_"+i));
				System.err.println("int_first_request_id_ is:"+(String)hash.get("int_first_request_id_"+i));
				
				
				covBean.setFacilityId(facilityId);
				covBean.setRequestId((String)hash.get("request_id_"+i));
				covBean.setSeqNo((String)hash.get("seq_no_"+i));
				covBean.setIntRequestId((String)hash.get("int_request_id_"+i));
				covBean.setIntResponseId((String)hash.get("int_response_id_"+i));
				covBean.setIntFirstReqId((String)hash.get("int_first_request_id_"+i));
				covBean.setCommResponseId((String)hash.get("commnuication_response_id_"+i));
				
				covBean.setCustCode((String)hash.get("cust_Code_"+i));
				covBean.setCustGrpCode((String)hash.get("cust_grp_code_"+i));
				covBean.setPolicyTypeCode((String)hash.get("policy_type_code_"+i));
				
				covBean.setServGrpCode((String)hash.get("serv_grp_code_"+i));
				covBean.setServClassification((String)hash.get("serv_classification_code_"+i));
				covBean.setBlngServCode((String)hash.get("blng_serv_code_"+i));
				covBean.setApaStatus((String)hash.get("APA_status_"+i));
				covBean.setPreAppStatus((String)hash.get("pre_app_status_"+i));
				covBean.setCheckService((String)hash.get("check_service_" + i));
				covBean.setFileName((String)hash.get("fileName_"+i));
				covBean.setFilePath((String)hash.get("filePath"));
				covBean.setPatientId((String)hash.get("patient_id"));
				covBean.setNationalId((String)hash.get("nationalId"));
				covBean.setIqamaId((String)hash.get("iqamaId"));
				covBean.setTotalServices((String)hash.get("totalServices"));
				
				System.err.println("Blng_serv_code_ "+(String)hash.get("blng_serv_code_" + i));
				System.err.println("PatID "+(String)hash.get("patient_id"));
				System.err.println("nationalId "+(String)hash.get("nationalId"));
				System.err.println("iqamaId "+(String)hash.get("iqamaId"));
				System.err.println("fileName "+(String)hash.get("fileName_" + i));
				
				covList.add(covBean); 
				System.err.println("covList .."+covList.isEmpty());   
			}  
			if(!(covList.isEmpty()))
				policyMap.put("BLAdvancedPriorAuthList", covList);  
			 
			
			System.err.println("Data is in Policy Map..");
		
	
		
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println("Exception from BLAdvancedPriorAuthPersistance :" + e);
	} 
	putObjectInBean("bl_BLAdvancedPriorAuthBean",policyBean,request);   
	
	
	

        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
