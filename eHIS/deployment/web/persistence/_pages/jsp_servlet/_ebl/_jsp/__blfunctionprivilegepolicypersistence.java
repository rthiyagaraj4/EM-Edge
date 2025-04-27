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

public final class __blfunctionprivilegepolicypersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFunctionPrivilegePolicyPersistence.jsp", 1733317015678L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
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


public String checkForNull(String inp){
	return (inp==null) ? "":inp;
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
// Page Added by Rajesh V. To Persist all the data visible in User Privilege Screen 
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "FunctionPrivilegeBean" ;
	String beanName = "eBL.BLFunctionPrivilegeBean";

	BLFunctionPrivilegeBean functionPrivilegeBean = (BLFunctionPrivilegeBean) getBeanObject(beanId, beanName, request);
	String facility_id = (String)session.getAttribute("facility_id");
	
	if(functionPrivilegeBean.getPayerDtlMap() == null)
	{
		functionPrivilegeBean.setPayerDtlMap(new HashMap<String, ArrayList<BLFunctionPrivilegeBean>>());
	}
	
	if(functionPrivilegeBean.getRestrictionMap() == null){
		functionPrivilegeBean.setRestrictionMap(new HashMap<String,String>());
	}
	
	HashMap<String, ArrayList<BLFunctionPrivilegeBean> > payerDtlMap = functionPrivilegeBean.getPayerDtlMap();
	HashMap<String,String> restrictionMap = functionPrivilegeBean.getRestrictionMap();
	
	Connection 	connection = null;
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
		
		if(func_mode!= null && func_mode.equals("PolicyPriv"))
		{
			
			String privilegeKey = (String) hash.get("privilegeKey");
			ArrayList<BLFunctionPrivilegeBean> payerList = new ArrayList<BLFunctionPrivilegeBean>();
			BLFunctionPrivilegeBean bean = null;
			int count = Integer.parseInt((String)hash.get("rowCount"));
			for(int i=1; i<=count;i++){
				bean = new BLFunctionPrivilegeBean();
				bean.setCustGrpCode((String)hash.get("custGrpCode_" + i));
				bean.setCustGrpDesc((String)hash.get("custGrpDesc_" + i));
				bean.setCustCode((String)hash.get("custCode_" + i));
				bean.setCustDesc((String)hash.get("custDesc_" + i));
				bean.setPolicyCode((String)hash.get("policyCode_" + i));
				bean.setPolicyDesc((String)hash.get("policyDesc_" + i));
				bean.setEffFromDate((String)hash.get("effFrom_" + i));
				bean.setEffToDate((String)hash.get("effTo_" + i));
				bean.setAllowable((String)hash.get("allowableYn_" + i));
				bean.setStatus((String)hash.get("status_" + i));
				if(!("".equals(bean.getCustGrpCode()) && "".equals(bean.getCustCode()) && "".equals(bean.getPolicyCode()) && "".equals(bean.getEffFromDate()))){
					payerList.add(bean);
				}
			}
			
			payerDtlMap.put(privilegeKey, payerList);
		}
		else if(func_mode!= null && func_mode.equals("restriction")){
			String userType = (String) request.getParameter("userType");
			String userCode = (String) request.getParameter("userCode");
			String functionId = (String) request.getParameter("functionId");
			String privilegeCode = (String) request.getParameter("privilegeCode");
			String payerGroupCode = (String) request.getParameter("payerGroupCode");
			String payerCode = (String) request.getParameter("payerCode");
			String policy = (String) request.getParameter("policy");
			String effFrom = (String) request.getParameter("effFrom");
			
			if(restrictionMap.containsKey(userType+"~"+userCode+"~"+functionId+"~"+privilegeCode+"~"+payerGroupCode+"~"+payerCode+"~"+policy+"~"+effFrom)){
				out.println("No");
			}
			else{
				restrictionMap.put(userType+"~"+userCode+"~"+functionId+"~"+privilegeCode+"~"+payerGroupCode+"~"+payerCode+"~"+policy+"~"+effFrom, "Y");
			}
		}
		else if(func_mode!= null && func_mode.equals("Privilege")){
			int rowCount = Integer.parseInt((String)hash.get("privilegeListSize"));
			ArrayList<BLFunctionPrivilegeBean> beanList = new ArrayList<BLFunctionPrivilegeBean>();
			BLFunctionPrivilegeBean bean = null;
			for(int i=0;i<rowCount;i++){
				bean = new BLFunctionPrivilegeBean();
				bean.setPrivilegeCode((String)hash.get("privilegeId"+i));
				bean.setEffStatus((String)hash.get("privilege"+i));
				bean.setEffFromDate((String)hash.get("dateFrom"+i));
				bean.setEffToDate((String)hash.get("dateTo"+i));
				bean.setAllowable((String)hash.get("allowedYn"+i));
				beanList.add(bean);
			}
			functionPrivilegeBean.setUserCode((String)hash.get("rightsCode"));
			functionPrivilegeBean.setUserType((String)hash.get("rightsType"));
			functionPrivilegeBean.setFunctionId((String)hash.get("function_type"));
			payerDtlMap.put("privilege", beanList);
		}
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BL Function Privilege :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}

	putObjectInBean(beanId,functionPrivilegeBean,request);


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
