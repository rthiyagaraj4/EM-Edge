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
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __policyapprovalvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PolicyApprovalValidation.jsp", 1709114141036L ,"10.3.6.0","Asia/Calcutta")) return true;
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


private String nulltoStr(String inputString) {
	if (inputString == null) {
		return "";
	} else {
		return inputString;
	}
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String bean_id = "bl_PolicyApprovalBean";
	String bean_name = "eBL.PolicyApprovalBean";
	PolicyApprovalBean bean = (PolicyApprovalBean) getBeanObject(bean_id, bean_name, request);

	Connection con = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	try {
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");
		bean.setLanguageId(locale);

		String facilityId = (String) session.getValue("facility_id");
		String loggedInUser = (String) session.getValue("login_user");
		Properties p = (Properties) session.getValue( "jdbc" ) ;
		String clientIpAddress	= p.getProperty("client_ip_address");
		String mode = (String) hash.get("mode");
		int count = 0;
		if (func_mode != null && func_mode.equals("APPLY")) {
			String fromRcrd = (String) hash.get("fromRcrd");
			String toRcrd = (String) hash.get("toRcrd");
			int startRcrd = Integer.parseInt(fromRcrd);
			int endRcrd = Integer.parseInt(toRcrd);
			
			HashMap<String, PolicyApprovalBean> hMap = new HashMap<String, PolicyApprovalBean>();
			for(int i= startRcrd - 1; i < endRcrd; i++) {
				String chkBoxStatus = nulltoStr((String) hash.get("chk_"+i));
				String dbChkBoxStatus = nulltoStr((String) hash.get("chkBxDbVal_"+i));
 				if(!dbChkBoxStatus.equals(chkBoxStatus)) {
					PolicyApprovalBean appBean = new PolicyApprovalBean();
					
					appBean.setChkBox((String) hash.get("chk_"+i));
					appBean.setCustomerGroup(nulltoStr((String) hash.get("custGrp_"+i)));
					appBean.setCustomer((String) hash.get("cust_"+i));
					appBean.setPolicy((String) hash.get("policy_"+i));
					
					hMap.put("chk_"+i, appBean);
				}
			}
			
			for(int i = 0; i < startRcrd-1; i++) {
				PolicyApprovalBean appBean = bean.getList().get(i);
				if(!appBean.getChkBoxDBVal().equals(appBean.getChkBox())) {
					appBean.setChkBox(appBean.getChkBox());
					appBean.setCustomerGroup(appBean.getCustomerGroup());
					appBean.setCustomer(nulltoStr(appBean.getCustomer()));
					appBean.setPolicy(appBean.getPolicy());
					
					hMap.put("chk_"+i, appBean);
				}
			}
			
			for(int i = endRcrd + 1; i < bean.getList().size(); i++) {
				PolicyApprovalBean appBean = bean.getList().get(i);
				if(!appBean.getChkBoxDBVal().equals(appBean.getChkBox())) {
					appBean.setChkBox(appBean.getChkBox());
					appBean.setCustomerGroup(appBean.getCustomerGroup());
					appBean.setCustomer(nulltoStr(appBean.getCustomer()));
					appBean.setPolicy(appBean.getPolicy());
					
					hMap.put("chk_"+i, appBean);
				}
			}
			bean.setFacilityId(facilityId);
			
			bean.sethMap(hMap);
		} else if(func_mode != null && func_mode.equals("MODIFY")) {
			String fromRcrd = (String) hash.get("fromRcrd");
			String toRcrd = (String) hash.get("toRcrd");
			int startRcrd = Integer.parseInt(fromRcrd);
			int endRcrd = Integer.parseInt(toRcrd);
			
			List<PolicyApprovalBean> list = bean.getList();
			for(int i= startRcrd - 1; i < endRcrd; i++) {
				String chkBoxStatus = nulltoStr((String) hash.get("chk_"+i));
				PolicyApprovalBean appBean = new PolicyApprovalBean();
				appBean.setChkBox((String) hash.get("chk_"+i));
				appBean.setChkBoxDBVal((String) hash.get("chkBxDbVal_"+i));
				appBean.setCustomerGroup((String) hash.get("custGrp_"+i));
				appBean.setCustomer(nulltoStr((String) hash.get("cust_"+i)));
				appBean.setPolicy((String) hash.get("policy_"+i));
				appBean.setCustomerGroupDesc((String) hash.get("custGrpDesc_"+i));
				appBean.setCustomerDesc(nulltoStr((String) hash.get("custDesc_"+i)));
				appBean.setPolicyDesc((String) hash.get("policyDesc_"+i));
				
				list.set(i, appBean);
			}
			bean.setList(list);
		}

	} catch (Exception e) {
		System.out.println("Exception from PolicyApprovalValidation: " + e);
		e.printStackTrace();
	} finally {
		if (pstmt != null)
			pstmt.close();
		if (rs != null)
			rs.close();
		if (con != null)
			ConnectionManager.returnConnection(con);
	}
	putObjectInBean(bean_id, bean, request);

            _bw.write(_wl_block2Bytes, _wl_block2);
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
