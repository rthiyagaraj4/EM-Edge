package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.CosmeticRuleDAO;
import eBL.CosmeticRuleDetailBean;
import eBL.CosmeticRuleHeaderBean;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __cosmeticrulepersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CosmeticRulePersistence.jsp", 1709114120537L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
// Page Added by Rajesh V for KAUH-CRF-0318. To Persist all the data  
            _bw.write(_wl_block2Bytes, _wl_block2);
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

	String beanId = "CosmeticRuleBean" ;
	String beanName = "eBL.CosmeticRuleHeaderBean";
	CosmeticRuleHeaderBean cosmeticBean = null;
	List<CosmeticRuleHeaderBean> cosmeticList = null;
	cosmeticBean = (CosmeticRuleHeaderBean) getBeanObject(beanId, beanName, request);
	String facility_id = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	
	if(cosmeticBean.getCriteriaList() == null){
		cosmeticBean.setCriteriaList(new ArrayList<CosmeticRuleDetailBean>());
	}
	
	if(cosmeticBean.getExclList() == null){
		cosmeticBean.setExclList(new ArrayList<CosmeticRuleDetailBean>());
	}
	
	List<CosmeticRuleDetailBean> criteriaList = cosmeticBean.getCriteriaList();
	List<CosmeticRuleDetailBean> exclList = cosmeticBean.getExclList();
	
	try 
	{

		request.setCharacterEncoding("UTF-8");
		
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		if(func_mode!= null && func_mode.equals("persistHeader"))
		{
			cosmeticBean.setPatientClass((String)hash.get("patientClass"));
			cosmeticBean.setBlngGroupCode((String)hash.get("blngGroupCode"));
			cosmeticBean.setCustGroupCode((String)hash.get("custGrpCode"));
			cosmeticBean.setCustCode((String)hash.get("custCode"));
			cosmeticBean.setRuleCode((String)hash.get("ruleCode"));
			cosmeticBean.setPolicyTypeCode((String)hash.get("policyCode"));
			cosmeticBean.setStatus((String)hash.get("ruleStatus"));
			
			if("".equals(cosmeticBean.getBlngGroupCode())){
				cosmeticBean.setBlngGroupCode("**");
			}
			if("".equals(cosmeticBean.getCustGroupCode())){
				cosmeticBean.setCustGroupCode("**");
			}
			if("".equals(cosmeticBean.getCustCode())){
				cosmeticBean.setCustCode("**");
			}
			if("".equals(cosmeticBean.getPolicyTypeCode())){
				cosmeticBean.setPolicyTypeCode("**");
			}
		}
		
		else if(func_mode!= null && func_mode.equals("persistExclusion"))
		{
			String chkServCode = "";
			CosmeticRuleDetailBean criteriaBean = null;
			exclList = new ArrayList<CosmeticRuleDetailBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("exclLastRow"));
			for(int i=0;i<=lastRowIndex;i++){
				chkServCode = (String)hash.get("blngServCode"+i);
				if(chkServCode != null && !"".equals(chkServCode)){
					criteriaBean = new CosmeticRuleDetailBean();
					criteriaBean.setServType((String)hash.get("inclServType"+i));
					criteriaBean.setServCode((String)hash.get("blngServCode"+i));
					criteriaBean.setInclExclYN((String)hash.get("inclExcl"+i));
					criteriaBean.setStatus((String)hash.get("inclExclStatus"+i));
					criteriaBean.setIsDelFlagYN((String)hash.get("inclExclRem"+i));
					exclList.add(criteriaBean);
				}
			}
			cosmeticBean.setExclList(exclList);
		}
		
		else if(func_mode!= null && func_mode.equals("persistCriteria"))
		{
			String chkServCode = "";
			CosmeticRuleDetailBean criteriaBean = null;
			criteriaList = new ArrayList<CosmeticRuleDetailBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("criteriaLastRow"));
			for(int i=0;i<=lastRowIndex;i++){
				chkServCode = (String)hash.get("servCode"+i);
				if(chkServCode != null && !"".equals(chkServCode)){
					criteriaBean = new CosmeticRuleDetailBean();
					criteriaBean.setServType((String)hash.get("servType"+i));
					criteriaBean.setServCode((String)hash.get("servCode"+i));
					criteriaBean.setStatus((String)hash.get("criteriaStatus"+i));
					criteriaBean.setIsDelFlagYN((String)hash.get("criteriaRem"+i));
					criteriaList.add(criteriaBean);
				}
			}
			cosmeticBean.setCriteriaList(criteriaList);
		}
		
		else if(func_mode!= null && func_mode.equals("getRuleDates")){
			String ruleCode = request.getParameter("ruleCode");
			CosmeticRuleDAO cosmeticDAO = new CosmeticRuleDAO();
			String effDates = cosmeticDAO.getEffDatesForRuleCode(ruleCode,facility_id);
			out.println(effDates);
		}
			
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception in CosmeticRulePersistence ->" + e);
	}
	finally
	{
		
	}

	putObjectInBean(beanId,cosmeticBean,request);


            _bw.write(_wl_block2Bytes, _wl_block2);
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
